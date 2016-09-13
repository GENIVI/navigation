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

print '\n--------------------------'
print 'MapViewerControl Test'
print '--------------------------\n'

#connect to session bus
bus = dbus.SessionBus()

session = bus.get_object('org.genivi.navigation.mapviewer.Session_Session','/Session')
session_interface = dbus.Interface(session, dbus_interface='org.genivi.navigation.mapviewer.Session')

#get session handle
ret = session_interface.createSession(dbus.String('test mapviewer'))
sessionhandle=ret[1]
print 'Session handle: ' + str(sessionhandle)

sessionstatus = session_interface.getSessionStatus(dbus.UInt32(sessionhandle));
print 'Session status: ' + str(sessionstatus)

sessionlist = session_interface.getAllSessions();
print 'Active sessions = ' + str(len(sessionlist))

MapViewerControl_obj = bus.get_object('org.genivi.navigation.mapviewer.MapViewerControl_MapViewerControl','/MapViewerControl')
MapViewerControl_interface = dbus.Interface(MapViewerControl_obj, dbus_interface='org.genivi.navigation.mapviewer.MapViewerControl')

#get mapviewer handle
ret = MapViewerControl_interface.createMapViewInstance( \
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
MapViewerControl_interface.setFollowCarMode( \
    dbus.UInt32(sessionhandle), \
    dbus.UInt32(mapviewerhandle), \
    dbus.Boolean(False))

print 'Set center in Bern(' + str(lat1) + ',' + str(lon1) + ')' 
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

print 'Get center -> (' + str(lat2) + ',' + str(lon2) + ')'  

if round(lat1,4) != round(lat2,4) :
    print '\nTest Failed:' + str(round(lat1,4)) + '!=' + str(round(lat2,4))  + '\n' 

if round(lon1,4) != round(lon2,4) :
    print '\nTest Failed:' + str(round(lon1,4)) + '!=' + str(round(lon2,4))  + '\n' 

if round(alt1,4) != round(alt2,4) :
    print '\nTest Failed:' + str(round(alt1,4)) + '!=' + str(round(alt2,4))  + '\n'

ret=MapViewerControl_interface.getMapViewScale(dbus.UInt32(mapviewerhandle))
print('Scale ID: '+str(int(ret[0])))
print('MapScaleType: '+str(int(ret[1])))

time.sleep(3)

print 'Zoom in'
MapViewerControl_interface.setMapViewScaleByDelta( \
    dbus.UInt32(sessionhandle), \
    dbus.UInt32(mapviewerhandle), \
    dbus.Int16(1))

time.sleep(3)

print 'Zoom in'
MapViewerControl_interface.setMapViewScaleByDelta( \
    dbus.UInt32(sessionhandle), \
    dbus.UInt32(mapviewerhandle), \
    dbus.Int16(1))

time.sleep(3)

print 'Zoom out'
MapViewerControl_interface.setMapViewScaleByDelta( \
    dbus.UInt32(sessionhandle), \
    dbus.UInt32(mapviewerhandle), \
    dbus.Int16(-1))

time.sleep(3)

print 'Zoom out'
MapViewerControl_interface.setMapViewScaleByDelta( \
    dbus.UInt32(sessionhandle), \
    dbus.UInt32(mapviewerhandle), \
    dbus.Int16(-1))

time.sleep(3)

MapViewerControl_interface.releaseMapViewInstance( \
  dbus.UInt32(sessionhandle), \
  dbus.UInt32(mapviewerhandle))

session_interface.deleteSession(sessionhandle)
                                

print '\nTest Finished\n'





