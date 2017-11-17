/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2017, PSA GROUP
*
* \file main.cpp
*
* \brief This file is part of the speech service proof of concept.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
* \brief Some parts of the code has been inspired by the following people:
* \brief Mario Thielert, David Kämpf, Dominique Massonie
*
* \version 1.0
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License (MPL), v. 2.0.
* If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* For further information see http://www.genivi.org/.
*
* List of changes:
* <date>, <name>, <description of change>
*
* @licence end@
*/

#include <stdbool.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <sys/types.h>
#include <iostream>
#include <cmath>
#include <typeinfo>
#ifndef DBUS_HAS_RECURSIVE_MUTEX
#define DBUS_HAS_RECURSIVE_MUTEX
#endif
#include <dbus-c++/glib-integration.h>
#include "genivi-speechservice-constants.h"
#include "genivi-speechservice-speechoutput_adaptor.h"
#include "log.h"
#include <semaphore.h>
#include <flite.h>

extern "C" {
    cst_voice* register_cmu_us_kal(const char *voxdir);
    void unregister_cmu_us_kal(cst_voice *vox);
}

DLT_DECLARE_CONTEXT(gCtx)

static const char* speech_SERVICE_NAME = "org.genivi.hmi.speechservice.SpeechOutput";
static const char* speech_OBJECT_PATH = "/org/genivi/hmi/speechservice/SpeechOutput";

static DBus::Glib::BusDispatcher *dispatcher;
static DBus::Connection *dbusConnection;

static int m_lenLastChunk;
static int m_slotCount;
static const uint32_t MAX_CHUNK_SIZE			= 1024 + 1;		/**< Maximum size of any chunk which can be stored within the queue. */
static const uint32_t MAX_SLOT_COUNT			= 16;						/**< Maximum number of chunks which can be present in the queue at the same time. */
static const uint32_t MAX_SLOT_COUNT_NO_WARN	= (3 * MAX_SLOT_COUNT) / 4;	/**< When pushing a chunk, TAQS_WARNING shall be reported if the new occupied slot count exceeds MAX_SLOT_COUNT_NO_WARN. */
static const uint32_t MAX_CHUNK_LENGTH	= 1024;	/**< max length of a single prompt part */
static const uint32_t MAX_MARKER_LENGTH	= 32;	/**< marker tag inside the prompt chunk */
static const uint32_t PROCESS_CHUNKS_LOOP = 100;
static cst_voice* mp_voice;
static cst_audio_streaming_info* mp_asi;
static pthread_mutex_t mutex;

static std::string m_chunkBuffer; /** max size = MAX_CHUNK_SIZE*MAX_SLOT_COUNT */
static bool m_abortRequest;

class SpeechOutput
: public org::genivi::hmi::speechservice::SpeechOutput_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
public:

    SpeechOutput(DBus::Connection &connection);

    ~SpeechOutput();

    ::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > getVersion();

    void openPrompter(const int32_t& connectionType, const int32_t& preProcessingType);

    uint32_t addTextChunk(const std::string& chunk);

    void abortPrompter();

    void closePrompter();

private:
    ::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > m_version;
    int32_t m_preProcessingType;
    int32_t m_connectionType;
};

gboolean processChunks(gpointer data) {
   //worker thread to process chunks in buffer

   pthread_mutex_lock(&mutex);

   if (m_chunkBuffer.length() > 0)
   {
       std::string tempBuffer;
       tempBuffer.assign(m_chunkBuffer);
       m_chunkBuffer.clear(); //buffer empty
       m_slotCount=0; //reset counter of slots

       pthread_mutex_unlock(&mutex);

       LOG_DEBUG_MSG(gCtx,"processChunks");

       // pass string to TTS engine
       flite_text_to_speech(tempBuffer.c_str(),mp_voice,"play");
   }
   else
   {
       pthread_mutex_unlock(&mutex);
   }
   return(true);
}

static int fliteCallback(const cst_wave *w, int start, int size,
             int last, cst_audio_streaming_info_struct *asi)
{
    static cst_audiodev *ad = 0;
    int32_t ret=CST_AUDIO_STREAM_CONT;
    if (start == 0){
        ((SpeechOutput*)asi->userdata)->notifyTTSStatus(GENIVI_SPEECHSERVICE_TS_ENQUEUED);
        ad = audio_open(w->sample_rate,w->num_channels,CST_AUDIO_LINEAR16);
    }

    audio_write(ad,&w->samples[start],size*sizeof(short));

    if (last == 1)
    {
        audio_drain(ad);
        audio_close(ad);
        ad = NULL;
        LOG_DEBUG_MSG(gCtx,"end of processing chunks");
        ((SpeechOutput*)asi->userdata)->notifyTTSStatus(GENIVI_SPEECHSERVICE_TS_FINISHED);
    }

    pthread_mutex_lock(&mutex);
    if(m_abortRequest){
        m_abortRequest=false;
        ret=CST_AUDIO_STREAM_STOP;
        ((SpeechOutput*)asi->userdata)->notifyTTSStatus(GENIVI_SPEECHSERVICE_TS_ABORTED);
    }
    pthread_mutex_unlock(&mutex);
    /* if you want to stop return CST_AUDIO_STREAM_STOP */
    return ret;
}


SpeechOutput::SpeechOutput(DBus::Connection &connection) : DBus::ObjectAdaptor(connection, speech_OBJECT_PATH){
    m_version._1=1;
    m_version._2=0;
    m_version._3=0;
    m_version._4="12-10-2016";

    m_lenLastChunk = 0;
    m_slotCount = 0;

    m_preProcessingType=GENIVI_SPEECHSERVICE_PPT_NONE;

    flite_init();

    mp_voice = register_cmu_us_kal(NULL);
    LOG_DEBUG(gCtx,"Voice name: %s",mp_voice->name);
    mp_asi = new_audio_streaming_info();
    mp_asi->asc = fliteCallback;
    mp_asi->userdata=this;

    feat_set(mp_voice->features,"streaming_info",audio_streaming_info_val(mp_asi));

    notifyTTSStatus(GENIVI_SPEECHSERVICE_TS_ACTIVE);
}

SpeechOutput::~SpeechOutput(){
        unregister_cmu_us_kal(mp_voice);
    }

::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > SpeechOutput::getVersion(){
        return m_version;
    }

void SpeechOutput::openPrompter(const int32_t& connectionType, const int32_t& preProcessingType){
    LOG_DEBUG(gCtx,"openPrompter: connection %d preprocessing %d",connectionType,preProcessingType);
    if(m_preProcessingType==GENIVI_SPEECHSERVICE_PPT_NONE){
        m_preProcessingType=preProcessingType;
        m_connectionType=connectionType;
        notifyConnectionStatus(GENIVI_SPEECHSERVICE_CS_ESTABLISHED);
    }else{
        notifyConnectionStatus(GENIVI_SPEECHSERVICE_CS_REFUSED);
    }
}

/**
     * description: The prompter must be opened to trigger the playback of the provided prompt.
     *
        The prompt length must not exceed the length of a PromptChunk
     *   buffer.
        Synthesizes the provided text or if using the escape sequence of the
     *   engine supplier a wave file in a supported sampling rate is provided, the
     *   system will back back also wave files.
        The text will be normalized using the
     *   context identifier provided to openprompter. This applies to matching
     *   prerecorded files as well as the synthesis of number and words that are
     *   matched to a lexical dictionary.
        The synthesize will start if the prompter is
     *   idle, if the prompter is already playing the playback will be delayed until
     *   all previously added text chunks are played back. For every text chunk
     *   provided a notification will be send.
     */
uint32_t SpeechOutput::addTextChunk(const std::string& chunk){
    LOG_DEBUG(gCtx,"addTextChunk: %s", chunk.c_str());

    uint32_t _chunkID;

    // todo: manage _chunkID

    int32_t qStatus =  GENIVI_SPEECHSERVICE_CS_UNKNOWN;

    if (chunk.size() > 0 && chunk.size() < MAX_CHUNK_LENGTH)
    {
        if (m_slotCount <  (int) MAX_SLOT_COUNT)
        {
            if (m_slotCount <= (int) MAX_SLOT_COUNT_NO_WARN)
            {
                qStatus = GENIVI_SPEECHSERVICE_QS_LOW_FILL;
            }
            else
            {
                qStatus = GENIVI_SPEECHSERVICE_QS_HIGH_FILL;
            }
            m_chunkBuffer.append(chunk);
            m_lenLastChunk = chunk.size();
            ++m_slotCount;
        }
        else
        {
            qStatus = GENIVI_SPEECHSERVICE_QS_FULL;
        }
    }

    notifyQueueStatus(qStatus);

    return(_chunkID);
}

/**
 * description: A prompt must be playing to perform an abort action. If no prompting operation
 *   in progress there will be no reaction of the system.
 */
void SpeechOutput::abortPrompter(){
    LOG_DEBUG_MSG(gCtx,"abortPrompter");
    pthread_mutex_lock(&mutex);
    m_abortRequest=true;
    pthread_mutex_unlock(&mutex);
    m_preProcessingType=GENIVI_SPEECHSERVICE_PPT_NONE;
    notifyConnectionStatus(GENIVI_SPEECHSERVICE_CS_TERMINATED);
}

/**
 * description: The prompter is closed after the last text chunk submitted has finished playing.
 */
void SpeechOutput::closePrompter(){
    LOG_DEBUG_MSG(gCtx,"closePrompter");
    m_preProcessingType=GENIVI_SPEECHSERVICE_PPT_NONE;
    notifyConnectionStatus(GENIVI_SPEECHSERVICE_CS_TERMINATED);
}

static SpeechOutput* serverSpeechOutput;

int main(int  argc , char**  argv )
{
    DLT_REGISTER_APP("SPCS","SPEECH SERVER");
    DLT_REGISTER_CONTEXT(gCtx,"SPCS","Global Context");

    GMainLoop * mainloop ;
    guint processChunksID;

    // Set the global C and C++ locale to the user-configured locale,
    // so we can use std::cout with UTF-8, via Glib::ustring, without exceptions.
    std::locale::global(std::locale(""));

    // creating the dispatcher
    dispatcher = new DBus::Glib::BusDispatcher();
    DBus::default_dispatcher = dispatcher;
    dispatcher->attach(NULL);

    // create a connection on the session bus
    dbusConnection = new DBus::Connection(DBus::Connection::SessionBus());
    dbusConnection->setup(dispatcher);

    // create the server for SpeechOutput
    dbusConnection->request_name(speech_SERVICE_NAME);
    serverSpeechOutput=new SpeechOutput(*dbusConnection);

    processChunksID = g_timeout_add(PROCESS_CHUNKS_LOOP,processChunks,serverSpeechOutput);

    // Create a new GMainLoop with default context and initial state of "not running "
    mainloop = g_main_loop_new (g_main_context_default() , FALSE );

    // Send a feedback to the user
    LOG_INFO_MSG(gCtx,"Speech output server started");

    // loop listening
    g_main_loop_run ( mainloop );

    // clean memory
    delete serverSpeechOutput;
    delete dbusConnection;
    delete dispatcher;

    LOG_INFO_MSG(gCtx,"Speech output server stopped");

    return EXIT_SUCCESS;
}

