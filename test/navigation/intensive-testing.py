#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2014, PCA Peugeot Citroen
*
* \file intensive-testing.py
*
* \brief This script tests the enhanced position by using  the logreplayer at a given frame rate.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.0
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
* List of changes:
* <date>, <name>, <description of change>
*
* @licence end@
**************************************************************************
"""
import sys,tty,termios,select,gobject,time,dbus,re,argparse,subprocess,signal,os

from subprocess import call 
from subprocess import Popen 
from threading import Timer
from enum import Enum
from dbus.mainloop.glib import DBusGMainLoop
from traceback import print_exc

# Define some constants
DURATION_TESTING = 20000 #in ms
PATH_LOGFILES='./'

def startEnhancedPositionServer(): 
	global pathEnhancedposition
	enhancedposition=pathEnhancedposition + 'enhanced-position-service'
	FNULL = open(os.devnull,'w')
	pid = Popen([enhancedposition], stdout=FNULL, stderr=FNULL)
	return pid

def launchLog(file): 
	global pathLogreplayer
	logreplayer=pathLogreplayer + 'log-replayer'
	file=PATH_LOGFILES + file
	FNULL = open(os.devnull,'w')
	call([logreplayer, file], stdout=FNULL, stderr=FNULL)

class Genivi(Enum):
	ENHANCEDPOSITIONSERVICE_LATITUDE = 0x0020
	ENHANCEDPOSITIONSERVICE_LONGITUDE = 0x0021
	ENHANCEDPOSITIONSERVICE_ALTITUDE = 0x0022
      
def loopDbus():
	global testCounter
	# launch the logreplayer with test file
	launchLog("test.log")
	# get the geolocation
	geoLocation = enhancedPositionInterface.GetData(dbus.Array([Genivi.ENHANCEDPOSITIONSERVICE_LATITUDE,Genivi.ENHANCEDPOSITIONSERVICE_LONGITUDE]))
	latitude=float(geoLocation[dbus.UInt16(Genivi.ENHANCEDPOSITIONSERVICE_LATITUDE)])
	longitude=float(geoLocation[dbus.UInt16(Genivi.ENHANCEDPOSITIONSERVICE_LONGITUDE)])
	testCounter += 1
	print str(testCounter), str(latitude), str(longitude)
	if testCounter >= maxLoopTesting:
		cleanExit()
	return True 

def cleanExit():
	global enhancedpositionPid
	enhancedpositionPid.kill()
	sys.exit(1)
	
def exitProg(signum, frame):
	# restore the original signal handler and exit 
	signal.signal(signal.SIGINT, original_sigint)
	cleanExit()

# Main program begins here
parser = argparse.ArgumentParser(description='Intensive testing of enhanced position.')
parser.add_argument('-p','--path',action='store', dest='path', help='Path for the bin of positioning')
parser.add_argument('-f','--frame',action='store', dest='frame', type=int, help='Number of messages per second')
args = parser.parse_args()

if args.path == None:
	pathEnhancedposition='../../src/navigation/bin/positioning/enhanced-position-service/src/'
	pathLogreplayer='../../src/navigation/bin/positioning/log-replayer/src/'
else:
	pathEnhancedposition = args.path + 'bin/positioning/enhanced-position-service/src/' 
	pathLogreplayer= args.path + 'bin/positioning/log-replayer/src/'

if args.frame == None:
	periodicityTesting = 200 #in ms
else:
	periodicityTesting = 1000/args.frame #in ms
maxLoopTesting = DURATION_TESTING/periodicityTesting

# Start the enhanced position server
enhancedpositionPid = startEnhancedPositionServer()
time.sleep(.5)
 
# Initialize DBus loop as the main loop
DBusGMainLoop(set_as_default=True)

# Connect on the bus
dbus.mainloop.glib.DBusGMainLoop(set_as_default=True)
dbusConnectionBus = dbus.SessionBus()

# Enhanced position
try:
	enhancedPositionObject = dbusConnectionBus.get_object("org.genivi.positioning.EnhancedPosition", "/org/genivi/positioning/EnhancedPosition")
except dbus.DBusException:
	print "connection to Enhanced position failed"
	print_exc()
	cleanExit()

enhancedPositionInterface = dbus.Interface(enhancedPositionObject, "org.genivi.positioning.EnhancedPosition")

# Start
testCounter=0
original_sigint = signal.getsignal(signal.SIGINT)
signal.signal(signal.SIGINT, exitProg)
gobject.timeout_add(periodicityTesting,loopDbus)
loop = gobject.MainLoop()
loop.run()



