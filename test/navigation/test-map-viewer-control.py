#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2015, Mentor Graphics
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

#import pdb; pdb.set_trace()

#constants as defined in the Navigation API
LATITUDE = 0x00a0
LONGITUDE = 0x00a1

MAIN_MAP = 0x0010
SPLIT_SCREEN = 0x0011

#constants used by the script
HORIZONTAL_SIZE = 800
VERTICAL_SIZE = 480
TIME_OUT = 20000
MIN_SCALE = 0
MAX_SCALE = 21

def mapviewer_mapViewScaleChanged_handler(mapViewInstanceHandle,scale,isMinMax):
    global g_scale
    new_scale=int(scale)
    print("Scale: "+str(new_scale))
    print('Is min max: '+str(int(isMinMax)))
    time.sleep(0.25)
    if g_scale > new_scale and new_scale !=MIN_SCALE:
        print("Zoom in")
        g_scale=new_scale
        MapViewerControl_interface.SetMapViewScaleByDelta( \
            dbus.UInt32(sessionhandle), \
            dbus.UInt32(mapviewerhandle), \
            dbus.Int16(1))
    else:
        if new_scale < MAX_SCALE:
            print("Zoom out")
            g_scale=new_scale
            MapViewerControl_interface.SetMapViewScaleByDelta( \
                dbus.UInt32(sessionhandle), \
                dbus.UInt32(mapviewerhandle), \
                dbus.Int16(-1))
        else:
            print 'Test PASSED'
            MapViewerControl_interface.ReleaseMapViewInstance( \
                dbus.UInt32(sessionhandle), \
                dbus.UInt32(mapviewerhandle))
            session_interface.DeleteSession(sessionhandle)
            loop.quit()

#timeout
def timeout():
    print 'Timeout Expired'
    print '\nTest FAILED'
    loop.quit()


print '\n--------------------------'
print 'MapViewerControl Test'
print '--------------------------\n'

if __name__ == '__main__':
    dbus.mainloop.glib.DBusGMainLoop(set_as_default=True) 


#connect to session bus
bus = dbus.SessionBus()

bus.add_signal_receiver(mapviewer_mapViewScaleChanged_handler, \
                        dbus_interface = "org.genivi.mapviewer.MapViewerControl", \
                        signal_name = "MapViewScaleChanged")


session = bus.get_object('org.genivi.mapviewer.Session','/org/genivi/mapviewer')
session_interface = dbus.Interface(session, dbus_interface='org.genivi.mapviewer.Session')

#get session handle
ret = session_interface.CreateSession(dbus.String("test mapviewer"))
sessionhandle=ret[1]
print 'Session handle: ' + str(sessionhandle)

sessionstatus = session_interface.GetSessionStatus(dbus.UInt32(sessionhandle));
print 'Session status: ' + str(sessionstatus)

sessionlist = session_interface.GetAllSessions();
print 'Active sessions = ' + str(len(sessionlist))

MapViewerControl_obj = bus.get_object('org.genivi.mapviewer.MapViewerControl','/org/genivi/mapviewer')
MapViewerControl_interface = dbus.Interface(MapViewerControl_obj, dbus_interface='org.genivi.mapviewer.MapViewerControl')

#get mapviewer handle
ret = MapViewerControl_interface.CreateMapViewInstance( \
  dbus.UInt32(sessionhandle), \
  dbus.Struct((dbus.UInt16(HORIZONTAL_SIZE),dbus.UInt16(VERTICAL_SIZE))), \
  dbus.Int32(MAIN_MAP))
mapviewerhandle=ret[1]

print 'MapView handle: ' + str(mapviewerhandle)

# Bern
lat1 = 46.9479
lon1 = 7.4446
alt1 = 0

time.sleep(2)

print 'Stop following the car position' 
MapViewerControl_interface.SetFollowCarMode( \
    dbus.UInt32(sessionhandle), \
    dbus.UInt32(mapviewerhandle), \
    dbus.Boolean(False))

print 'Set center in Bern(' + str(lat1) + ',' + str(lon1) + ')' 
MapViewerControl_interface.SetTargetPoint( \
    dbus.UInt32(sessionhandle), \
    dbus.UInt32(mapviewerhandle), \
    dbus.Struct((dbus.Double(lat1),dbus.Double(lon1),dbus.Double(alt1))))

# Get current position
targetPoint = MapViewerControl_interface.GetTargetPoint( \
    dbus.UInt32(mapviewerhandle) )

lat2 = targetPoint[0]
lon2 = targetPoint[1]
alt2 = targetPoint[2]

print 'Get center -> (' + str(lat2) + ',' + str(lon2) + ')'  

if round(lat1,4) != round(lat2,4) :
    print '\nTest Failed:' + str(round(lat1,4)) + '!=' + str(round(lat2,4))  + '\n' 

if round(lon1,4) != round(lon2,4) :
    print '\nTest Failed:' + str(round(lon1,4)) + '!=' + str(round(lon2,4))  + '\n' 

if round(alt1,4) != round(alt2,4) :
    print '\nTest Failed:' + str(round(alt1,4)) + '!=' + str(round(alt2,4))  + '\n'

ret=MapViewerControl_interface.GetMapViewScale(dbus.UInt32(mapviewerhandle))
print('Scale: '+str(int(ret[0])))
print('Is min max: '+str(int(ret[1])))

g_scale=int(ret[0])

time.sleep(1)

print 'Zoom in'
MapViewerControl_interface.SetMapViewScaleByDelta( \
    dbus.UInt32(sessionhandle), \
    dbus.UInt32(mapviewerhandle), \
    dbus.Int16(1))

time.sleep(1)

#main loop 
gobject.timeout_add(TIME_OUT, timeout)
loop = gobject.MainLoop()
loop.run()

