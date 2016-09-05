#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2016, PSA GROUP
*
* \file test-speech-capi.py
*
* \brief This simple test shows how the speech 
*              could be easily tested using a python script
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.0
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
* List of changes:
*
* @licence end@
**************************************************************************
"""

import dbus
import gobject
import dbus.mainloop.glib
import time

import pdb;
#pdb.set_trace()
#constants as defined in the Navigation API
GENIVI_Configuration_Settings_LOCALE = 37
GENIVI_SearchStatusState_FINISHED = 1298
GENIVI_SearchStatusState_NOT_STARTED = 1296

#constants used into the script
TIME_OUT = 10000

def catch_speech_notifyConnectionStatus_signal_handler(connectionStatus):
    print("Connection status: " + str(int(connectionStatus))) 

def catch_speech_notifyMarkerReached_signal_handler(chunkID,marker):
    print("Chunk ID: " + chunkID) 

def catch_speech_notifyQueueStatus_signal_handler(queueStatus):
    print("Queue status: " + str(int(queueStatus))) 

def catch_speech_notifyTTSStatus_signal_handler(ttsStatus):
    print("TTS status: " + str(int(ttsStatus))) 

#timeout
def timeout():
    print ('Timeout Expired')
    print ('\nTest FAILED')
    loop.quit()

if __name__ == '__main__':
    dbus.mainloop.glib.DBusGMainLoop(set_as_default=True) 

#connect to session bus
bus = dbus.SessionBus()

bus.add_signal_receiver(catch_speech_notifyConnectionStatus_signal_handler, \
                        dbus_interface = "org.genivi.hmi.speechoutputservice.SpeechOutput", \
                        signal_name = "notifyConnectionStatus")
bus.add_signal_receiver(catch_speech_notifyMarkerReached_signal_handler, \
                        dbus_interface = "org.genivi.hmi.speechoutputservice.SpeechOutput", \
                        signal_name = "notifyMarkerReached")
bus.add_signal_receiver(catch_speech_notifyQueueStatus_signal_handler, \
                        dbus_interface = "org.genivi.hmi.speechoutputservice.SpeechOutput", \
                        signal_name = "notifyQueueStatus")
bus.add_signal_receiver(catch_speech_notifyTTSStatus_signal_handler, \
                        dbus_interface = "org.genivi.hmi.speechoutputservice.SpeechOutput", \
                        signal_name = "notifyTTSStatus")

speech = bus.get_object('org.genivi.hmi.speechoutputservice.SpeechOutput_SpeechOutput','/SpeechOutput')
g_speech_interface = dbus.Interface(speech, dbus_interface='org.genivi.hmi.speechoutputservice.SpeechOutput')

g_speech_interface.addTextChunk(dbus.String("Hello"))

#main loop 
gobject.timeout_add(TIME_OUT, timeout)
loop = gobject.MainLoop()
loop.run()
