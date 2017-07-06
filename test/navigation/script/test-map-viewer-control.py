#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2015, Mentor Graphics
* \copyright Copyright (C) 2017, PSA GROUP
*
* \file test-map-viewer-control.py
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
import xml.dom.minidom
import argparse
import sys
import errno
import genivi
try:
    from dltTrigger import *
    dltTrigger=True
    print('DLT signal sent')
except dltTriggerNotBuilt:
    dltTrigger=False
#import pdb; pdb.set_trace()

#name of the test 
test_name = "map viewer"

#constants used by the script
HORIZONTAL_SIZE = 800
VERTICAL_SIZE = 480
MAIN_MAP = 0x0010
TIME_OUT = 1000000
INIT_SCALE=8
SCALE_FOR_ROTATE=4
SCALE_FOR_THREE_D=4
TEST_STEP_START=0
TEST_STEP_SCALE=1
TEST_STEP_ROTATE=2
TEST_STEP_THREE_D=3
SCALE_DELTA_DECREASE=-1
SCALE_DELTA_INCREASE=1
ROTATE_INCREMENT=5
ROTATE_MAX=360
ROTATE_SPEED=30

# List of coordinates
LATITUDE = list()
LONGITUDE = list()
ALTITUDE = list()
COUNTRY_STRING = list()
CITY_STRING = list()
STREET_STRING = list()
HOUSE_NUMBER_STRING = list()

def init_test_rotate():
    print ('Test rotate')
    g_mapviewercontrol_interface.SetMapViewScale( \
        dbus.UInt32(g_mapviewer_sessionhandle), \
        dbus.UInt32(g_mapviewer_maphandle), \
        dbus.UInt16(SCALE_FOR_ROTATE))
   
def test_rotate():    
    global g_angle
    if g_angle <   (ROTATE_MAX-ROTATE_INCREMENT):
        g_angle += ROTATE_INCREMENT
        g_mapviewercontrol_interface.SetMapViewRotation( \
            dbus.UInt32(g_mapviewer_sessionhandle), \
            dbus.UInt32(g_mapviewer_maphandle), \
            dbus.Int16(g_angle), \
            dbus.Int16(ROTATE_SPEED))
        return True
    else:
        print('Test rotate PASSED')
        return False
   
def init_test_scale():
    print ('Test scale')
    g_mapviewercontrol_interface.SetMapViewScale( \
    dbus.UInt32(g_mapviewer_sessionhandle), \
    dbus.UInt32(g_mapviewer_maphandle), \
    dbus.UInt16(INIT_SCALE))
    
def test_scale(scale,isMinMax):
    global g_scale
    global g_scale_delta
    global g_heading_angle
    print("Scale: "+str(scale))
    print('Is min max: '+str(isMinMax))
    g_scale=scale
    if g_scale_delta==SCALE_DELTA_DECREASE:
        if isMinMax !=genivi.MAPVIEWER_MIN:
            print("Zoom in")
            g_mapviewercontrol_interface.SetMapViewScaleByDelta( \
                dbus.UInt32(g_mapviewer_sessionhandle), \
                dbus.UInt32(g_mapviewer_maphandle), \
                dbus.Int16(g_scale_delta))
            return True
        else:
            print("Zoom out")
            g_scale_delta=SCALE_DELTA_INCREASE
            g_mapviewercontrol_interface.SetMapViewScaleByDelta( \
                dbus.UInt32(g_mapviewer_sessionhandle), \
                dbus.UInt32(g_mapviewer_maphandle), \
                dbus.Int16(g_scale_delta))  
            return True
    else:
        if isMinMax !=genivi.MAPVIEWER_MAX:
            print("Zoom out")
            g_mapviewercontrol_interface.SetMapViewScaleByDelta( \
                dbus.UInt32(g_mapviewer_sessionhandle), \
                dbus.UInt32(g_mapviewer_maphandle), \
                dbus.Int16(g_scale_delta))
            return True
        else:
            print('Test scale PASSED')
            return False


def init_test_three_d():
    print('Test 3D')
    g_mapviewercontrol_interface.SetMapViewScale( \
        dbus.UInt32(g_mapviewer_sessionhandle), \
        dbus.UInt32(g_mapviewer_maphandle), \
        dbus.UInt16(SCALE_FOR_THREE_D))

def test_three_d():
    g_mapviewercontrol_interface.SetMapViewPerspective(\
        dbus.UInt32(g_mapviewer_sessionhandle),\
        dbus.UInt32(g_mapviewer_maphandle), \
        genivi.PERSPECTIVE_THREE_D)
    return False

def mapviewer_mapViewRotated_handler(mapViewInstanceHandle):
    if step ==TEST_STEP_ROTATE:
        if test_rotate()==False:
            next_step()

def mapviewer_mapViewScaleChanged_handler(mapViewInstanceHandle,scale,isMinMax):
    global step
    if step ==TEST_STEP_SCALE:
        if test_scale(int(scale),int(isMinMax))==False:
            next_step()
    else:
        if step == TEST_STEP_ROTATE:
            test_rotate()
        else:
            if step == TEST_STEP_THREE_D:
                test_three_d()


def mapviewer_mapViewPerspectiveChanged_handler(mapViewInstanceHandle, perspective):
    print("Perspective: "+str(perspective))
    if step==TEST_STEP_THREE_D:
        if int(perspective)==genivi.PERSPECTIVE_THREE_D:
            time.sleep(2)
            print('Test 3D PASSED')
        else:
            print('Test 3D failed')
        exit()
    
def timeout():
    print('Timeout Expired') 
    print ('\nTest FAILED')
    exit()

def next_step():
    global step
    if step == TEST_STEP_START:
        step=TEST_STEP_SCALE
        init_test_scale()
    else:
            if step ==TEST_STEP_SCALE:
                step=TEST_STEP_ROTATE
                init_test_rotate()
            else:
                    if step ==TEST_STEP_ROTATE:
                        step=TEST_STEP_THREE_D
                        init_test_three_d()
                    else:
                        exit()
        

def createMapView():
    global g_mapviewer_sessionhandle
    global g_mapviewer_sessionstatus
    global g_mapviewer_sessionlist
    global g_mapviewer_maphandle
    
    #get mapviewer session handle
    ret = g_mapviewer_session_interface.CreateSession(dbus.String('test mapviewer'))
    g_mapviewer_sessionhandle=ret[1]
    print ('Mapviewer session handle: ' + str(g_mapviewer_sessionhandle))
    
    g_mapviewer_sessionstatus = g_mapviewer_session_interface.GetSessionStatus(dbus.UInt32(g_mapviewer_sessionhandle));
    print ('Mapviewer session status: ' + str(g_mapviewer_sessionstatus))
    
    g_mapviewer_sessionlist = g_mapviewer_session_interface.GetAllSessions();
    print ('Mapviewer active sessions = ' + str(len(g_mapviewer_sessionlist)))
    
    #get mapviewer handle
    ret = g_mapviewercontrol_interface.CreateMapViewInstance( \
      dbus.UInt32(g_mapviewer_sessionhandle), \
      dbus.Struct((dbus.UInt16(HORIZONTAL_SIZE),dbus.UInt16(VERTICAL_SIZE))), \
     dbus.Int32(MAIN_MAP))
    g_mapviewer_maphandle=ret[1]
    
    print ('MapView handle: ' + str(g_mapviewer_maphandle))
    
    time.sleep(2)
    
    print ('Stop following the car position') 
    g_mapviewercontrol_interface.SetFollowCarMode( \
        dbus.UInt32(g_mapviewer_sessionhandle), \
        dbus.UInt32(g_mapviewer_maphandle), \
        dbus.Boolean(False))

def deleteMapView():
    g_mapviewercontrol_interface.ReleaseMapViewInstance( \
      dbus.UInt32(g_mapviewer_sessionhandle), \
      dbus.UInt32(g_mapviewer_maphandle))
    g_mapviewer_session_interface.DeleteSession(g_mapviewer_sessionhandle)
   
def exit():
    deleteMapView()
    if dltTrigger==True:
        stopTrigger(test_name)
    loop.quit()
   
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

bus.add_signal_receiver(mapviewer_mapViewScaleChanged_handler, \
                        dbus_interface = "org.genivi.navigation.mapviewer.MapViewerControl", \
                        signal_name = "MapViewScaleChanged")

bus.add_signal_receiver(mapviewer_mapViewRotated_handler, \
                        dbus_interface = "org.genivi.navigation.mapviewer.MapViewerControl", \
                        signal_name = "MapViewRotated")

bus.add_signal_receiver(mapviewer_mapViewPerspectiveChanged_handler, \
                        dbus_interface = "org.genivi.navigation.mapviewer.MapViewerControl", \
                        signal_name = "MapViewPerspectiveChanged")
                        
if dltTrigger==True:
    startTrigger(test_name)

mapviewer_session_obj = bus.get_object('org.genivi.navigation.mapviewer.Session','/org/genivi/mapviewer')
g_mapviewer_session_interface = dbus.Interface(mapviewer_session_obj, dbus_interface='org.genivi.navigation.mapviewer.Session')

mapviewercontrol_obj = bus.get_object('org.genivi.navigation.mapviewer.MapViewerControl','/org/genivi/mapviewer')
g_mapviewercontrol_interface = dbus.Interface(mapviewercontrol_obj, dbus_interface='org.genivi.navigation.mapviewer.MapViewerControl')

createMapView()

#init the target (it's the first location in the input file by default) and test 
index=0
lat1 = LATITUDE[index]
lon1 = LONGITUDE[index]
alt1 = ALTITUDE[index]
print('Set center in '+ CITY_STRING[index]+ ' (' + str(lat1) + ',' + str(lon1) + ')') 
g_mapviewercontrol_interface.SetTargetPoint( \
    dbus.UInt32(g_mapviewer_sessionhandle), \
    dbus.UInt32(g_mapviewer_maphandle), \
    dbus.Struct((dbus.Double(lat1),dbus.Double(lon1),dbus.Double(alt1))))
targetPoint = g_mapviewercontrol_interface.GetTargetPoint( \
    dbus.UInt32(g_mapviewer_maphandle) )
lat2 = targetPoint[0]
lon2 = targetPoint[1]
alt2 = targetPoint[2]
if round(float(lat1),4) != round(float(lat2),4) :
    print ('\nTest Failed:' + str(round(float(lat1),4)) + '!=' + str(round(float(lat2),4))  + '\n' )
    exit()
if round(float(lon1),4) != round(float(lon2),4) :
    print('\nTest Failed:' + str(round(float(lon1),4)) + '!=' + str(round(float(lon2),4))  + '\n' )
    exit()
if round(float(alt1),4) != round(float(alt2),4) :
    print('\nTest Failed:' + str(round(float(alt1),4)) + '!=' + str(round(float(alt2),4))  + '\n')
    exit()

#init the scale
#get the default
ret=g_mapviewercontrol_interface.GetMapViewScale(dbus.UInt32(g_mapviewer_maphandle))
print('Scale: '+str(int(ret[0])))
print('Is min max: '+str(int(ret[1])))
#and set it to init value
g_scale=INIT_SCALE
g_scale_delta=SCALE_DELTA_DECREASE
g_mapviewercontrol_interface.SetMapViewScale( \
    dbus.UInt32(g_mapviewer_sessionhandle), \
    dbus.UInt32(g_mapviewer_maphandle), \
    dbus.UInt16(g_scale))

#wait for map refresh
time.sleep(0.25)

#init the perspective to 2D
g_mapviewercontrol_interface.SetMapViewPerspective(dbus.UInt32(g_mapviewer_sessionhandle),dbus.UInt32(g_mapviewer_maphandle), genivi.PERSPECTIVE_TWO_D)
 
#init the heading angle
g_mapviewercontrol_interface.SetCameraHeadingAngle(dbus.UInt32(g_mapviewer_sessionhandle),dbus.UInt32(g_mapviewer_maphandle), dbus.Int32(0))
ret=g_mapviewercontrol_interface.GetCameraHeading(dbus.UInt32(g_mapviewer_maphandle))
print('Heading: '+str(int(ret[1])))
g_angle=int(ret[0])

step=TEST_STEP_START
next_step()

#main loop 
g_timer_timeout=gobject.timeout_add(TIME_OUT, timeout)
loop = gobject.MainLoop()
loop.run()

