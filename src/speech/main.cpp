/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file main.cpp
*
* \brief This file is part of the speech proof of concept.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.1
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
#include <dbus-c++-1/dbus-c++/glib-integration.h>
#include <semaphore.h>
#include <flite.h>

extern "C" {
    cst_voice* register_cmu_us_kal(const char *voxdir);
    void unregister_cmu_us_kal(cst_voice *vox);
}


#include <CommonAPI/CommonAPI.hpp>
#include <CommonTypes.hpp>
#include <SpeechOutputStubDefault.hpp>

using namespace v4::org::genivi::hmi::speechoutputservice;
using namespace v4::org::genivi;

static std::shared_ptr < CommonAPI::Runtime > runtime;
static const std::string domain = "local";

static int m_lenLastChunk;
static int m_slotCount;
static const uint32_t MAX_CHUNK_SIZE			= 1024 + 1;		/**< Maximum size of any chunk which can be stored within the queue. */
static const uint32_t MAX_SLOT_COUNT			= 16;						/**< Maximum number of chunks which can be present in the queue at the same time. */
static const uint32_t MAX_SLOT_COUNT_NO_WARN	= (3 * MAX_SLOT_COUNT) / 4;	/**< When pushing a chunk, TAQS_WARNING shall be reported if the new occupied slot count exceeds MAX_SLOT_COUNT_NO_WARN. */
static const uint32_t MAX_CHUNK_LENGTH	= 1024;	/**< max length of a single prompt part */
static const uint32_t MAX_MARKER_LENGTH	= 32;	/**< marker tag inside the prompt chunk */
static const uint32_t PROCESS_CHUNKS_LOOP = 100;
static cst_voice* mp_voice;
static pthread_mutex_t mutex;

static std::string m_chunkBuffer; /** max size = MAX_CHUNK_SIZE*MAX_SLOT_COUNT */

 gboolean processChunks(gpointer data) {
    //worker thread to process chunks in buffer

    pthread_mutex_lock(&mutex);

    if (m_chunkBuffer.length() > 0)
    {
        printf("\n>>> [server] processChunks()\n");
        std::string tempBuffer;
        tempBuffer.assign(m_chunkBuffer);
        m_chunkBuffer.clear(); //buffer empty
        m_slotCount=0; //reset counter of slots

        pthread_mutex_unlock(&mutex);

        // pass string to TTS engine
        flite_text_to_speech(tempBuffer.c_str(),mp_voice,"play");
    }
    else
    {
        pthread_mutex_unlock(&mutex);
    }
    return(true);
}

class  SpeechOutputServerStub
: public SpeechOutputStubDefault
{

public:

    SpeechOutputServerStub() {
        m_version.setVersionMajor(1);
        m_version.setVersionMinor(0);
        m_version.setVersionMicro(0);
        m_version.setDate("12-10-2016");

        m_lenLastChunk = 0;
        m_slotCount = 0;

        flite_init();

        mp_voice = register_cmu_us_kal(NULL);

    }

    ~SpeechOutputServerStub() {
        unregister_cmu_us_kal(mp_voice);
    }

    /**
     * description: This method returns the API version implemented by the SpeechOutput.
     */
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply) {
        _reply(m_version);
    }

    /**
     * description: Must be called to open a SpeechOutputService session and to get the audio
     *   connection.
     */
    void openPrompter(const std::shared_ptr<CommonAPI::ClientId> _client, SpeechOutput::ConnectionType _connectionType, SpeechOutput::PreProcessingType _preProcessingType, openPrompterReply_t _reply) {
        printf("\n>>> [server] openPrompter()\n");

        _reply();
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
    void addTextChunk(const std::shared_ptr<CommonAPI::ClientId> _client, SpeechOutput::Chunk _chunk, addTextChunkReply_t _reply) {
        printf("\n>>> [server] addTextChunk()\n    \"%s\"\n", _chunk.c_str());

        SpeechOutput::ChunkID _chunkID;

        // todo: manage _chunkID

        SpeechOutput::QueueStatus qStatus = SpeechOutput::QueueStatus::QS_UNKNOWN;

        if (_chunk.size() > 0 && _chunk.size() < MAX_CHUNK_LENGTH)
        {
            if (m_slotCount <  (int) MAX_SLOT_COUNT)
            {
                if (m_slotCount <= (int) MAX_SLOT_COUNT_NO_WARN)
                {
                    qStatus = SpeechOutput::QueueStatus::QS_LOW_FILL;
                }
                else
                {
                    qStatus = SpeechOutput::QueueStatus::QS_HIGH_FILL;
                }
                m_chunkBuffer.append(_chunk);
                m_lenLastChunk = _chunk.size();
                ++m_slotCount;
            }
            else
            {
                qStatus = SpeechOutput::QueueStatus::QS_FULL;
            }
        }

        fireNotifyQueueStatusEvent(qStatus);

        _reply(_chunkID);
    }

    /**
     * description: A prompt must be playing to perform an abort action. If no prompting operation
     *   in progress there will be no reaction of the system.
     */
    void abortPrompter(const std::shared_ptr<CommonAPI::ClientId> _client, abortPrompterReply_t _reply) {
        printf("\n>>> [server] abortPrompter()\n");

        _reply();
    }

    /**
     * description: The prompter is closed after the last text chunk submitted has finished playing.
     */
    void closePrompter(const std::shared_ptr<CommonAPI::ClientId> _client, closePrompterReply_t _reply) {
        printf("\n>>> [server] closePrompter()\n");

        _reply();
    }


// Specific methods


private:
    CommonTypes::Version m_version;

};


int main(int  argc , char**  argv )
{
    GMainLoop * mainloop ;
    guint processChunksID;

    // Set the global C and C++ locale to the user-configured locale,
    // so we can use std::cout with UTF-8, via Glib::ustring, without exceptions.
    std::locale::global(std::locale(""));

    // Common API data init
    runtime = CommonAPI::Runtime::get();
    bool successfullyRegistered;

    const std::string instanceSpeechOutput = "SpeechOutput";
    std::shared_ptr<SpeechOutputServerStub> myServiceSpeechOutput = std::make_shared<SpeechOutputServerStub>();
    successfullyRegistered = runtime->registerService(domain, instanceSpeechOutput, myServiceSpeechOutput);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instanceSpeechOutput, myServiceSpeechOutput);
    }

    processChunksID = g_timeout_add(PROCESS_CHUNKS_LOOP,processChunks,NULL);

    // Create a new GMainLoop with default context and initial state of "not running "
    mainloop = g_main_loop_new (g_main_context_default() , FALSE );

    // Send a feedback to the user
    std::cout << "speech server started" << std::endl;

    // loop listening

    g_main_loop_run ( mainloop );


    return EXIT_SUCCESS;
}
