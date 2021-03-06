#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2015, Mentor Graphics
* \copyright Copyright (C) 2017, PSA Group
*
* \file test-map-viewer-control-capi.py
*
* \brief This simple test shows how the mapviewer 
*        could be easily tested using a python script
*
* \author Marco Residori <marco.residori@mentor_graphics.com>
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.1
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
* List of changes:
* 04-02-2016, Philippe Colliot, Update to the new API ('i' for enumerations and 'yv' for variants), add some methods
*
* @licence end@
**************************************************************************
"""

import dbus
import gobject
import dbus.mainloop.glib
import time
from dltTrigger import *
from xml.dom.minidom import parse
import xml.dom.minidom
import argparse
import sys
import errno
#import pdb; pdb.set_trace()

#name of the test 
test_name = "map viewer"

#constants as defined in the Navigation API
LATITUDE = 0x00a0
LONGITUDE = 0x00a1
MAPVIEWER_MAX = 0x0041
MAPVIEWER_MIN = 0x0040

MAIN_MAP = 0x0010
SPLIT_SCREEN = 0x0011

#constants used by the script
HORIZONTAL_SIZE = 800
VERTICAL_SIZE = 480
TIME_OUT = 20000
INIT_SCALE=2
TEST_STEP_START=0
TEST_STEP_SCALE=1
TEST_STEP_ROTATE=2

# List of coordinates
LATITUDE = list()
LONGITUDE = list()
ALTITUDE = list()
COUNTRY_STRING = list()
CITY_STRING = list()
STREET_STRING = list()
HOUSE_NUMBER_STRING = list()

def mapviewer_mapViewScaleChanged_handler(mapViewInstanceHandle,scale,isMinMax):
    global g_scale
    global step
    new_scale=int(scale)
    print("Scale: "+str(new_scale))
    print('Is min max: '+str(int(isMinMax)))
    if step ==TEST_STEP_SCALE:
        time.sleep(0.25)
        if g_scale > new_scale and isMinMax !=MAPVIEWER_MIN:
            print("Zoom in")
            g_scale=new_scale
            MapViewerControl_interface.setMapViewScaleByDelta( \
                dbus.UInt32(sessionhandle), \
                dbus.UInt32(mapviewerhandle), \
                dbus.Int16(-1))
        else:
            if isMinMax !=MAPVIEWER_MAX:
                print("Zoom out")
                g_scale=new_scale
                MapViewerControl_interface.setMapViewScaleByDelta( \
                    dbus.UInt32(sessionhandle), \
                    dbus.UInt32(mapviewerhandle), \
                    dbus.Int16(1))
            else:
                print('Test scale PASSED')
                next_step()

#timeout
def timeout():
    print('Timeout Expired') 
    print ('\nTest FAILED')
    exit()


def exit():
    MapViewerControl_interface.releaseMapViewInstance( \
        dbus.UInt32(sessionhandle), \
        dbus.UInt32(mapviewerhandle))
    session_interface.deleteSession(sessionhandle)
    stopTrigger(test_name)
    loop.quit()

def next_step():
    global step
    if step == TEST_STEP_START:
        step=TEST_STEP_SCALE
        print ('Test scale')
        MapViewerControl_interface.setMapViewScale( \
        dbus.UInt32(sessionhandle), \
        dbus.UInt32(mapviewerhandle), \
        dbus.UInt16(INIT_SCALE))
    else:
            if step ==TEST_STEP_SCALE:
                step=TEST_STEP_ROTATE
                print ('Test rotate')
                MapViewerControl_interface.setMapViewScale( \
                    dbus.UInt32(sessionhandle), \
                    dbus.UInt32(mapviewerhandle), \
                    dbus.UInt16(INIT_SCALE))
                exit()
            else:
                    if step ==TEST_STEP_ROTATE:
                        exit()
        
print('\n--------------------------')
print('MapViewerControl Test')
print('--------------------------\n')

parser = argparse.ArgumentParser(description='Map Viewer Test for navigation PoC and FSA.')
parser.add_argument('-l','--loc',action='store', dest='locations', help='List of locations in xml format')
parser.add_argument("-v", "--verbose", action='store_true',help='print the whole log messages')
args = parser.parse_args()

if args.locations == None:
    print('location file is missing')
    sys.exit(1)
else:
    try:
        DOMTree = xml.dom.minidom.parse(args.locations)
    except OSError as e:
        if e.errno == errno.ENOENT:
            print('file not exists')
        sys.exit(1)
    location_set = DOMTree.documentElement
            
print("Area : %s" % location_set.getAttribute("area"))

locations = location_set.getElementsByTagName("location")

for location in location_set.getElementsByTagName("location"):
    LATITUDE.append(location.getElementsByTagName("latitude")[0].childNodes[0].data)
    LONGITUDE.append(location.getElementsByTagName("longitude")[0].childNodes[0].data)
    ALTITUDE.append(0)
    COUNTRY_STRING.append(location.getElementsByTagName("country")[0].childNodes[0].data)
    CITY_STRING.append(location.getElementsByTagName("city")[0].childNodes[0].data)
    STREET_STRING.append(location.getElementsByTagName("street")[0].childNodes[0].data)
    HOUSE_NUMBER_STRING.append(location.getElementsByTagName("number")[0].childNodes[0].data)

if __name__ == '__main__':
    dbus.mainloop.glib.DBusGMainLoop(set_as_default=True) 


#connect to session bus
bus = dbus.SessionBus()
result = bus.request_name("org.genivi.navigation.mapviewer.MapViewerClient", dbus.UInt32(0))

bus.add_signal_receiver(mapviewer_mapViewScaleChanged_handler, \
                        dbus_interface = "org.genivi.navigation.mapviewer.MapViewerControl.v4_0", \
                        signal_name = "mapViewScaleChanged")


startTrigger(test_name)  

session = bus.get_object('org.genivi.navigation.mapviewer.Session.v4_0_Session','/Session')
session_interface = dbus.Interface(session, dbus_interface='org.genivi.navigation.mapviewer.Session.v4_0')

#get session handle
ret = session_interface.createSession(dbus.String("test mapviewer"))
sessionhandle=ret[1]
print('Session handle: ' + str(sessionhandle))

sessionstatus = session_interface.getSessionStatus(dbus.UInt32(sessionhandle));
print ('Session status: ' + str(sessionstatus))

sessionlist = session_interface.getAllSessions();
print( 'Active sessions = ' + str(len(sessionlist)))

MapViewerControl_obj = bus.get_object('org.genivi.navigation.mapviewer.MapViewerControl.v4_0_MapViewerControl','/MapViewerControl')
MapViewerControl_interface = dbus.Interface(MapViewerControl_obj, dbus_interface='org.genivi.navigation.mapviewer.MapViewerControl.v4_0')

#get mapviewer handle
ret = MapViewerControl_interface.createMapViewInstance( \
  dbus.UInt32(sessionhandle), \
  dbus.Struct((dbus.UInt16(HORIZONTAL_SIZE),dbus.UInt16(VERTICAL_SIZE))), \
  dbus.Int32(MAIN_MAP))
mapviewerhandle=ret[1]

print('MapView handle: ' + str(mapviewerhandle))

index=0

lat1 = LATITUDE[index]
lon1 = LONGITUDE[index]
alt1 = ALTITUDE[index]

time.sleep(2)

print ('Stop following the car position') 
MapViewerControl_interface.setFollowCarMode( \
    dbus.UInt32(sessionhandle), \
    dbus.UInt32(mapviewerhandle), \
    dbus.Boolean(False))

print('Set center in '+ CITY_STRING[index]+ ' (' + str(lat1) + ',' + str(lon1) + ')') 
MapViewerControl_interface.setTargetPoint( \
    dbus.UInt32(sessionhandle), \
    dbus.UInt32(mapviewerhandle), \
    dbus.Struct((dbus.Double(lat1),dbus.Double(lon1),dbus.Double(alt1))))

# Get current position
targetPoint = MapViewerControl_interface.getTargetPoint( \
    dbus.UInt32(mapviewerhandle) )

lat2 = targetPoint[0]
lon2 = targetPoint[1]
alt2 = targetPoint[2]

print ('Get center -> (' + str(lat2) + ',' + str(lon2) + ')' ) 

if round(float(lat1),4) != round(float(lat2),4) :
    print ('\nTest Failed:' + str(round(float(lat1),4)) + '!=' + str(round(float(lat2),4))  + '\n' )

if round(float(lon1),4) != round(float(lon2),4) :
    print('\nTest Failed:' + str(round(float(lon1),4)) + '!=' + str(round(float(lon2),4))  + '\n' )

if round(float(alt1),4) != round(float(alt2),4) :
    print('\nTest Failed:' + str(round(float(alt1),4)) + '!=' + str(round(float(alt2),4))  + '\n')

ret=MapViewerControl_interface.getMapViewScale(dbus.UInt32(mapviewerhandle))
print('Scale: '+str(int(ret[0])))
print('Is min max: '+str(int(ret[1])))

g_scale=int(ret[0])
time.sleep(2)
step=TEST_STEP_START
next_step()

#main loop 
gobject.timeout_add(TIME_OUT, timeout)
loop = gobject.MainLoop()
loop.run()

