#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2016, XS Embedded GmbH, PCA Peugeot Citroen
*
* \file test-guidance-capi.py
*
* \brief This simple test shows how the guidance 
*              could be easily tested using a python script
*
* \author Marco Residori <marco.residori@xse.de>
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.1
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
from collections import namedtuple,defaultdict
from _dbus_bindings import Int32
from PIL.GimpGradientFile import SEGMENTS
from xml.dom.minidom import parse
import xml.dom.minidom
import argparse
import sys
import errno
import time
from dltTrigger import *
#import pdb;
#pdb.set_trace()

from pip import locations

#name of the test 
test_name = "guidance"

#constants as defined in the Navigation API
GENIVI_NAVIGATIONCORE_LATITUDE = 0x00a0
GENIVI_NAVIGATIONCORE_LONGITUDE = 0x00a1
GENIVI_NAVIGATIONCORE_TOTAL_TIME = 0x018e
GENIVI_NAVIGATIONCORE_TOTAL_DISTANCE = 0x018f
GENIVI_NAVIGATIONCORE_ROAD_NAME = 0x0147
GENIVI_NAVIGATIONCORE_START_LATITUDE = 0x0141
GENIVI_NAVIGATIONCORE_END_LATITUDE = 0x0142
GENIVI_NAVIGATIONCORE_START_LONGITUDE = 0x0143
GENIVI_NAVIGATIONCORE_END_LONGITUDE = 0x0144
GENIVI_NAVIGATIONCORE_DISTANCE = 0x0148
GENIVI_NAVIGATIONCORE_TIME = 0x0149
GENIVI_NAVIGATIONCORE_SPEED = 0x00a4
GENIVI_NAVIGATIONCORE_ACTIVE = 0x0060

#constants used into the script
TIME_OUT = 10000
HORIZONTAL_SIZE = 800
VERTICAL_SIZE = 480
MAIN_MAP = 0x0010
NUMBER_OF_SEGMENTS = 1000

#add signal receivers
def routing_routeCalculationProgressUpdate_handler(routeHandle, status, percentage):
    print 'Route Calculation: ' + str(int(percentage)) + ' %'

def routing_routeCalculationSuccessful_handler(routeHandle,unfullfilledPreferences):
    global g_guidance_active
    print 'Route Calculation Successfull: ' + str(routeHandle)
    #get route overview
    overview = g_routing_interface.getRouteOverview(dbus.UInt32(g_route_handle),dbus.Array([dbus.Int32(GENIVI_NAVIGATIONCORE_TOTAL_DISTANCE),dbus.Int32(GENIVI_NAVIGATIONCORE_TOTAL_TIME)]))
    #retrieve distance 
    totalDistance = dbus.Struct(overview[dbus.Int32(GENIVI_NAVIGATIONCORE_TOTAL_DISTANCE)])
    print 'Total Distance: ' + str(totalDistance[1]/1000) + ' km'
    totalTime = dbus.Struct(overview[dbus.Int32(GENIVI_NAVIGATIONCORE_TOTAL_TIME)])
    m, s = divmod(totalTime[1], 60)
    h, m = divmod(m, 60)
    print "Total Time: %d:%02d:%02d" % (h, m, s)
    #get route segments     GetRouteSegments(const uint32_t& routeHandle, const int16_t& detailLevel, const std::vector< DBusCommonAPIEnumeration >& valuesToReturn, const uint32_t& numberOfSegments, const uint32_t& offset, uint32_t& totalNumberOfSegments, std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > >& routeSegments)
    valuesToReturn = [dbus.Int32(GENIVI_NAVIGATIONCORE_ROAD_NAME),
    dbus.Int32(GENIVI_NAVIGATIONCORE_START_LATITUDE),
    dbus.Int32(GENIVI_NAVIGATIONCORE_END_LATITUDE),
    dbus.Int32(GENIVI_NAVIGATIONCORE_START_LONGITUDE),
    dbus.Int32(GENIVI_NAVIGATIONCORE_END_LONGITUDE),
    dbus.Int32(GENIVI_NAVIGATIONCORE_DISTANCE),
    dbus.Int32(GENIVI_NAVIGATIONCORE_TIME),
    dbus.Int32(GENIVI_NAVIGATIONCORE_SPEED)]
    numberOfSegments = NUMBER_OF_SEGMENTS
    detailLevel = 0
    offset = 0
    ret = g_routing_interface.getRouteSegments(dbus.UInt32(g_route_handle),dbus.Int16(detailLevel),dbus.Array(valuesToReturn),dbus.UInt32(numberOfSegments),dbus.UInt32(offset))
    print "Total number of segments: " + str(ret[0]) 
    #len(ret[1]) is size
    #ret[1][0][GENIVI_NAVIGATIONCORE_START_LATITUDE] is the start latitude
    g_guidance_active = True
#        pdb.set_trace()
#    display_route(routeHandle)
    launch_guidance(routeHandle)
    
def session_sessionDeleted_handler(sessionHandle):
    print('Session handle deleted: '+str(sessionHandle))
    if sessionHandle == g_navigationcore_session_handle:
        print 'Test PASSED'
    else:
        print 'Test FAILED'
    exit()

def routing_routeDeleted_handler(routeHandle):
    print('Route handle deleted: '+str(routeHandle))

def guidance_guidanceStatusChanged_handler(guidanceStatus,routeHandle):
    global g_guidance_active
    print('Guidance status changed: '+str(guidanceStatus))
    if guidanceStatus != GENIVI_NAVIGATIONCORE_ACTIVE and g_guidance_active == True:
        g_guidance_active = False
        route = g_current_route + 1
        if route < routes.length:
            launch_route_calculation(route)
        else:
            for i in range(routes.length):
                g_routing_interface.deleteRoute(dbus.UInt32(g_navigationcore_session_handle),dbus.UInt32(routes[i].getElementsByTagName("handle")[0].childNodes[0].data))
            g_navigationcore_session_interface.deleteSession(dbus.UInt32(g_navigationcore_session_handle))
   
def guidance_positionOnRouteChanged_handler(offsetOnRoute):
    print "Offset on route: " +str(offsetOnRoute)
    ret = g_guidance_interface.getDestinationInformation()
    print "Travel time: " +str(ret[1])
    ret = g_guidance_interface.getManeuversList(dbus.UInt16(1),dbus.UInt32(0))
    print "Number of maneuvers: " +str(ret[1])
    print "Next road to turn: " +str(ret[2][0][4])
    g_mapmatchedposition_interface.setSimulationMode(dbus.UInt32(g_navigationcore_session_handle),dbus.Boolean(False))
    g_guidance_interface.stopGuidance(dbus.UInt32(g_navigationcore_session_handle))
    
def mapmatchedposition_simulationStatusChanged_handler(simulationStatus):
    print "Simulation status: " +str(simulationStatus)
        
#timeout
def timeout():
    print 'Timeout Expired'
    print '\nTest FAILED'
    exit()

def exit():
    stopTrigger(test_name)
    loop.quit()

def display_route(route):
    g_mapviewercontrol_interface.displayRoute( \
        dbus.UInt32(g_mapviewer_sessionhandle), \
        dbus.UInt32(g_mapviewer_maphandle), \
        dbus.UInt32(route), \
        dbus.Boolean(True))
    
def launch_guidance(route):
    g_mapmatchedposition_interface.setSimulationMode(dbus.UInt32(g_navigationcore_session_handle),dbus.Boolean(True))
    g_guidance_interface.startGuidance(dbus.UInt32(g_navigationcore_session_handle),dbus.UInt32(route))
#    g_mapmatchedposition_interface.startSimulation(g_navigationcore_session_handle)
        
def launch_route_calculation(route):
    global g_current_route
    global g_route_handle
    global g_routing_interface
    global g_navigationcore_session_handle
    g_current_route = route
    print 'Route name: '+routes[g_current_route].getElementsByTagName("name")[0].childNodes[0].data
    #get route handle
    ret = g_routing_interface.createRoute(dbus.UInt32(g_navigationcore_session_handle)) 
    g_route_handle=ret[1]
    routes[g_current_route].getElementsByTagName("handle")[0].childNodes[0].data = g_route_handle
    print 'Route handle: ' + str(g_route_handle)
    start = routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data
    dest = routes[g_current_route].getElementsByTagName("destination")[0].childNodes[0].data
    print 'Calculating route from \
'+start+'(' + str(locations[routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data][0]) + ',' + str(locations[routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data][1]) + ') to \
'+dest+'(' + str(locations[routes[g_current_route].getElementsByTagName("destination")[0].childNodes[0].data][0]) + ',' + str(locations[routes[g_current_route].getElementsByTagName("destination")[0].childNodes[0].data][1]) + ')' 
    #set waypoints
    waypointDoubleCapiType = 0x03
    g_routing_interface.setWaypoints(dbus.UInt32(g_navigationcore_session_handle), \
                                   dbus.UInt32(g_route_handle), \
                                   dbus.Boolean(0), \
                                   dbus.Array([ \
                                        dbus.Dictionary({dbus.Int32(GENIVI_NAVIGATIONCORE_LATITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(locations[routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data][0])]),dbus.Int32(GENIVI_NAVIGATIONCORE_LONGITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(locations[routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data][1])])}), \
                                        dbus.Dictionary({dbus.Int32(GENIVI_NAVIGATIONCORE_LATITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(locations[routes[g_current_route].getElementsByTagName("destination")[0].childNodes[0].data][0])]),dbus.Int32(GENIVI_NAVIGATIONCORE_LONGITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(locations[routes[g_current_route].getElementsByTagName("destination")[0].childNodes[0].data][1])])}) \
                                   ]) \
                                   )
    
    #calculate route
    g_routing_interface.calculateRoute(dbus.UInt32(g_navigationcore_session_handle),dbus.UInt32(g_route_handle))

def createMapView():
    global g_mapviewer_sessionhandle
    global g_mapviewer_sessionstatus
    global g_mapviewer_sessionlist
    global g_mapviewer_maphandle
    
    #get mapviewer session handle
    ret = g_mapviewer_session_interface.createSession(dbus.String('test mapviewer'))
    g_mapviewer_sessionhandle=ret[1]
    print 'Mapviewer session handle: ' + str(g_mapviewer_sessionhandle)
    
    g_mapviewer_sessionstatus = g_mapviewer_session_interface.getSessionStatus(dbus.UInt32(g_mapviewer_sessionhandle));
    print 'Mapviewer session status: ' + str(g_mapviewer_sessionstatus)
    
    g_mapviewer_sessionlist = g_mapviewer_session_interface.getAllSessions();
    print 'Mapviewer active sessions = ' + str(len(g_mapviewer_sessionlist))
    
    #get mapviewer handle
    ret = g_mapviewercontrol_interface.createMapViewInstance( \
      dbus.UInt32(g_mapviewer_sessionhandle), \
      dbus.Struct((dbus.UInt16(HORIZONTAL_SIZE),dbus.UInt16(VERTICAL_SIZE))), \
     dbus.Int32(MAIN_MAP))
    g_mapviewer_maphandle=ret[1]
    
    print 'MapView handle: ' + str(g_mapviewer_maphandle)
    
    time.sleep(2)
    
    print 'Stop following the car position' 
    g_mapviewercontrol_interface.setFollowCarMode( \
        dbus.UInt32(g_mapviewer_sessionhandle), \
        dbus.UInt32(g_mapviewer_maphandle), \
        dbus.Boolean(False))

def deleteMapView():
    g_mapviewercontrol_interface.releaseMapViewInstance( \
      dbus.UInt32(g_mapviewer_sessionhandle), \
      dbus.UInt32(g_mapviewer_maphandle))
    
    g_mapviewer_session_interface.deleteSession(g_mapviewer_sessionhandle)
    
    
print('--------------------------')
print('Guidance Test')
print('--------------------------')

parser = argparse.ArgumentParser(description='Route Calculation Test for navigation PoC and FSA.')
parser.add_argument('-r','--rou',action='store', dest='routes', help='List of routes in xml format')
args = parser.parse_args()

if args.routes == None:
    print('route file is missing')
    sys.exit(1)
else:
    try:
        DOMTree = xml.dom.minidom.parse(args.routes)
    except OSError as e:
        if e.errno == errno.ENOENT:
            print('file not exists')
        sys.exit(1)
    route_set = DOMTree.documentElement
            
print("Country : %s" % route_set.getAttribute("country"))

routes = route_set.getElementsByTagName("route")

#create dictionary with the locations
locations = {}
for location in route_set.getElementsByTagName("location"):
    lat_long = [location.getElementsByTagName("latitude")[0].childNodes[0].data,location.getElementsByTagName("longitude")[0].childNodes[0].data]
    locations[location.getAttribute("name")] = lat_long

if __name__ == '__main__':
    dbus.mainloop.glib.DBusGMainLoop(set_as_default=True) 

#connect to session bus
bus = dbus.SessionBus()

bus.add_signal_receiver(routing_routeCalculationProgressUpdate_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Routing.v4_0", \
                        signal_name = "routeCalculationProgressUpdate")

bus.add_signal_receiver(routing_routeCalculationSuccessful_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Routing.v4_0", \
                        signal_name = "routeCalculationSuccessful")

bus.add_signal_receiver(routing_routeDeleted_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Routing.v4_0", \
                        signal_name = "routeDeleted")

bus.add_signal_receiver(session_sessionDeleted_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Session.v4_0", \
                        signal_name = "sessionDeleted")

bus.add_signal_receiver(guidance_guidanceStatusChanged_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Guidance.v4_0", \
                        signal_name = "guidanceStatusChanged")

bus.add_signal_receiver(guidance_positionOnRouteChanged_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Guidance.v4_0", \
                        signal_name = "positionOnRouteChanged")

bus.add_signal_receiver(mapmatchedposition_simulationStatusChanged_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.MapMatchedPosition.v4_0", \
                        signal_name = "simulationStatusChanged")

startTrigger(test_name)

navigationcore_session_obj = bus.get_object('org.genivi.navigation.navigationcore.Session.v4_0_Session','/Session')
g_navigationcore_session_interface = dbus.Interface(navigationcore_session_obj, dbus_interface='org.genivi.navigation.navigationcore.Session.v4_0')

routing_obj = bus.get_object('org.genivi.navigation.navigationcore.Routing.v4_0_Routing','/Routing')
g_routing_interface = dbus.Interface(routing_obj, dbus_interface='org.genivi.navigation.navigationcore.Routing.v4_0')

guidance_obj = bus.get_object('org.genivi.navigation.navigationcore.Guidance.v4_0_Guidance','/Guidance')
g_guidance_interface = dbus.Interface(guidance_obj, dbus_interface='org.genivi.navigation.navigationcore.Guidance.v4_0')

mapviewer_session_obj = bus.get_object('org.genivi.navigation.mapviewer.Session.v4_0_Session','/Session')
g_mapviewer_session_interface = dbus.Interface(mapviewer_session_obj, dbus_interface='org.genivi.navigation.mapviewer.Session.v4_0')

g_mapviewercontrol_obj = bus.get_object('org.genivi.navigation.mapviewer.MapViewerControl.v4_0_MapViewerControl','/MapViewerControl')
g_mapviewercontrol_interface = dbus.Interface(g_mapviewercontrol_obj, dbus_interface='org.genivi.navigation.mapviewer.MapViewerControl.v4_0')

g_mapmatchedposition_obj = bus.get_object('org.genivi.navigation.navigationcore.MapMatchedPosition.v4_0_MapMatchedPosition','/MapMatchedPosition')
g_mapmatchedposition_interface = dbus.Interface(g_mapmatchedposition_obj, dbus_interface='org.genivi.navigation.navigationcore.MapMatchedPosition.v4_0')

#get navigationcore session handle
ret = g_navigationcore_session_interface.createSession(dbus.String("test guidance"))
g_navigationcore_session_handle=ret[1]
print 'Navigation core session handle: ' + str(g_navigationcore_session_handle)

#createMapView()

g_current_route = 0
g_guidance_active = False
launch_route_calculation(0)

#main loop 
gobject.timeout_add(TIME_OUT, timeout)
loop = gobject.MainLoop()
loop.run()

#deleteMapView()
