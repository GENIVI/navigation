#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2016, PSA GROUP
*
* \file test-speech.py
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
import commands
import argparse
import dbus.mainloop.glib

import genivi
try:
    from dltTrigger import *
except dltTriggerNotBuilt:
    dltAvailable=False
else:
    dltAvailable=True
#import pdb; pdb.set_trace()

output = commands.getoutput('ps -A')
if not 'dlt' in output:
    dltAvailable=False

#name of the test 
test_name = "speech output"

#constants used into the script
TIME_OUT = 20000

def catch_speech_notifyConnectionStatus_signal_handler(connectionStatus):
    print("Connection status: " + str(int(connectionStatus))) 

def catch_speech_notifyMarkerReached_signal_handler(chunkID,marker):
    print("Chunk ID: " + chunkID) 

def catch_speech_notifyQueueStatus_signal_handler(queueStatus):
    print("Queue status: " + str(int(queueStatus))) 
    if queueStatus==genivi.SPEECHSERVICE_QS_FULL:
        print("Test failed, queue full")
        g_speech_interface.closePrompter()
        exit(0)

def catch_speech_notifyTTSStatus_signal_handler(ttsStatus):
    print("TTS status: " + str(int(ttsStatus))) 

#timeout
def timeout():
    print ('Timeout Expired\n')
    exit(1)

def exit(value):
    global g_exit
    g_exit=value
    if dltAvailable==True:
        stopTrigger(test_name)
    loop.quit()

print('\n--------------------------')
print('Speech Test')
print('--------------------------\n')

g_exit=0

parser = argparse.ArgumentParser(description='Location input Test for navigation PoC and FSA.')
parser.add_argument("-v", "--verbose", action='store_true',help='Print the whole log messages')
parser.add_argument('-a','--address',action='store', dest='host', help='Set remote host address')
parser.add_argument('-p','--prt',action='store', dest='port', help='Set remote port number')
args = parser.parse_args()

if __name__ == '__main__':
    dbus.mainloop.glib.DBusGMainLoop(set_as_default=True) 

# connect to session bus (remote or local)
if args.host != None:
	bus = dbus.bus.BusConnection("tcp:host=" + args.host +",port="+args.port)
else:
    bus = dbus.SessionBus()

bus.add_signal_receiver(catch_speech_notifyConnectionStatus_signal_handler, \
                        dbus_interface = "org.genivi.hmi.speechservice.SpeechOutput", \
                        signal_name = "notifyConnectionStatus")
bus.add_signal_receiver(catch_speech_notifyMarkerReached_signal_handler, \
                        dbus_interface = "org.genivi.hmi.speechservice.SpeechOutput", \
                        signal_name = "notifyMarkerReached")
bus.add_signal_receiver(catch_speech_notifyQueueStatus_signal_handler, \
                        dbus_interface = "org.genivi.hmi.speechservice.SpeechOutput", \
                        signal_name = "notifyQueueStatus")
bus.add_signal_receiver(catch_speech_notifyTTSStatus_signal_handler, \
                        dbus_interface = "org.genivi.hmi.speechservice.SpeechOutput", \
                        signal_name = "notifyTTSStatus")

if dltAvailable==True:
    startTrigger(test_name)

speech = bus.get_object('org.genivi.hmi.speechservice.SpeechOutput','/org/genivi/hmi/speechservice/SpeechOutput')
g_speech_interface = dbus.Interface(speech, dbus_interface='org.genivi.hmi.speechservice.SpeechOutput')

g_speech_interface.openPrompter(genivi.SPEECHSERVICE_CT_NAVIGATION, genivi.SPEECHSERVICE_PPT_NAVIGATION)
g_speech_interface.addTextChunk(dbus.String("\
    Now is the winter of our discontent\
    Made glorious summer by this sun of York;\
    And all the clouds that lour'd upon our house\
    In the deep bosom of the ocean buried. "))

#main loop 
gobject.timeout_add(TIME_OUT, timeout)
loop = gobject.MainLoop()
loop.run()
