#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2016, XS Embedded GmbH, PCA Peugeot Citroen
* \copyright Copyright (C) 2017, PSA GROUP
*
* \file test-guidance.py
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
import xml.dom.minidom
import argparse
import sys
import os.path
import time
import genivi
try:
    from dltTrigger import *
    dltTrigger=True
    print('DLT signal sent')
except dltTriggerNotBuilt:
    dltTrigger=False
#import pdb;pdb.set_trace()

#name of the test 
test_name = "guidance/map viewer"

#constants used into the script
TIME_OUT = 240000
HORIZONTAL_SIZE = 800
VERTICAL_SIZE = 480
NUMBER_OF_SEGMENTS = 500
ZOOM_GUIDANCE = 2
SPEED_FACTOR_SLOW = 16
SPEED_FACTOR_FAST = 128
SPEED_THRESHOLD_TO_FAST = 8
SPEED_THRESHOLD_TO_SLOW = 2

#add signal receivers
def routing_routeCalculationProgressUpdate_handler(routeHandle, status, percentage):
    print ('Route Calculation: ' + str(int(percentage)) + ' %')

def routing_routeCalculationSuccessful_handler(routeHandle,unfullfilledPreferences):
    global g_guidance_active
    print ('Route Calculation Successfull: ' + str(routeHandle))
    #get route overview
    overview = g_routing_interface.GetRouteOverview(dbus.UInt32(g_route_handle),dbus.Array([dbus.Int32(genivi.TOTAL_DISTANCE),dbus.Int32(genivi.TOTAL_TIME)]))
    #retrieve distance 
    totalDistance = dbus.Struct(overview[dbus.Int32(genivi.TOTAL_DISTANCE)])
    print ('Total Distance: ' + str(totalDistance[1]/1000) + ' km')
    totalTime = dbus.Struct(overview[dbus.Int32(genivi.TOTAL_TIME)])
    m, s = divmod(totalTime[1], 60)
    h, m = divmod(m, 60)
    print ("Total Time: %d:%02d:%02d" % (h, m, s))
    #get route segments     GetRouteSegments(const uint32_t& routeHandle, const int16_t& detailLevel, const std::vector< DBusCommonAPIEnumeration >& valuesToReturn, const uint32_t& numberOfSegments, const uint32_t& offset, uint32_t& totalNumberOfSegments, std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > >& routeSegments)
    valuesToReturn = [dbus.Int32(genivi.ROAD_NAME),
    dbus.Int32(genivi.START_LATITUDE),
    dbus.Int32(genivi.END_LATITUDE),
    dbus.Int32(genivi.START_LONGITUDE),
    dbus.Int32(genivi.END_LONGITUDE),
    dbus.Int32(genivi.DISTANCE),
    dbus.Int32(genivi.TIME),
    dbus.Int32(genivi.SPEED)]
    numberOfSegments = NUMBER_OF_SEGMENTS
    detailLevel = 0
    offset = 0
    ret = g_routing_interface.GetRouteSegments(dbus.UInt32(g_route_handle),dbus.Int16(detailLevel),dbus.Array(valuesToReturn),dbus.UInt32(numberOfSegments),dbus.UInt32(offset))
    print ("Total number of segments: " + str(ret[0]) )
    #len(ret[1]) is size
    #ret[1][0][genivi.START_LATITUDE] is the start latitude
    g_guidance_active = True
#        pdb.set_trace()
    display_route(routeHandle)
    #wait to display the route
    time.sleep(2)
    launch_guidance(routeHandle)
    
def session_sessionDeleted_handler(sessionHandle):
    print('Session handle deleted: '+str(sessionHandle))
    if sessionHandle == g_navigationcore_session_handle:
        exit(0)
    else:
        exit(1)

def routing_routeDeleted_handler(routeHandle):
    print('Route handle deleted: '+str(routeHandle))

def guidance_guidanceStatusChanged_handler(guidanceStatus,routeHandle):
    global g_guidance_active
    global g_total_amount_of_maneuvers
    print('Guidance status changed: '+str(guidanceStatus))
    if guidanceStatus != genivi.ACTIVE and g_guidance_active == True:
        g_guidance_active = False
        route = g_current_route + 1
        if route < routes.length:
            launch_route_calculation(route)
        else:
            for i in range(routes.length):
                g_routing_interface.DeleteRoute(dbus.UInt32(g_navigationcore_session_handle),dbus.UInt32(routes[i].getElementsByTagName("handle")[0].childNodes[0].data))
            g_navigationcore_session_interface.DeleteSession(dbus.UInt32(g_navigationcore_session_handle))
    else:
        ret = g_guidance_interface.GetDestinationInformation()
        m, s = divmod(ret[1], 60)
        h, m = divmod(m, 60)
        print ("Travel Time: %d:%02d:%02d" % (h, m, s))
        ret = g_guidance_interface.GetManeuversList(dbus.UInt16(10),dbus.UInt32(0))
        print ("Number of maneuvers: " +str(ret[1]))
        print ("Next road to turn: " +ret[2][0][4])
   
def guidance_positionOnRouteChanged_handler(offsetOnRoute):
    print ("Offset on route: " +str(offsetOnRoute))
    
def guidance_maneuverChanged_handler(maneuver):
    if maneuver == genivi.PASSED:
        print ("Maneuver passed ")
    else:
        print ("Maneuver: " +str(maneuver))
    ret = g_guidance_interface.GetDestinationInformation()
    m, s = divmod(ret[1], 60)
    h, m = divmod(m, 60)
    print ("Travel Time: %d:%02d:%02d" % (h, m, s))
    ret = g_guidance_interface.GetManeuversList(dbus.UInt16(10),dbus.UInt32(0))
    print ("Number of maneuvers: " +str(ret[1]))
    print ("Next road to turn: " +ret[2][0][4])
    if ret[1] ==SPEED_THRESHOLD_TO_FAST:
        g_mapmatchedposition_interface.SetSimulationSpeed(dbus.UInt32(g_navigationcore_session_handle), dbus.Byte(SPEED_FACTOR_FAST))
    if ret[1] == SPEED_THRESHOLD_TO_SLOW:
        g_mapmatchedposition_interface.SetSimulationSpeed(dbus.UInt32(g_navigationcore_session_handle), dbus.Byte(SPEED_FACTOR_SLOW))
 
def guidance_waypointReached_handler(isDestination):
    print("Waypoint reached: " +str(isDestination))
    if isDestination == 1:
        g_mapmatchedposition_interface.SetSimulationMode(dbus.UInt32(g_navigationcore_session_handle),dbus.Boolean(False))
        g_guidance_interface.StopGuidance(dbus.UInt32(g_navigationcore_session_handle))
        
def mapmatchedposition_simulationStatusChanged_handler(simulationStatus):
    print ("Simulation status: " +str(simulationStatus))
        

# Timeout
def timeout():
    print ('Timeout Expired\n')
    exit(1)

def exit(value):
    global g_exit
    g_exit=value
    #deleteMapView()
    if dltTrigger==True:
        stopTrigger(test_name)
    loop.quit()
    
def display_route(route):
    ret = g_routing_interface.GetRouteBoundingBox(dbus.UInt32(g_route_handle))
    g_mapviewercontrol_interface.SetMapViewBoundingBox(dbus.UInt32(g_mapviewer_sessionhandle),dbus.UInt32(g_mapviewer_maphandle),ret)
    g_mapviewercontrol_interface.DisplayRoute( \
        dbus.UInt32(g_mapviewer_sessionhandle), \
        dbus.UInt32(g_mapviewer_maphandle), \
        dbus.UInt32(route), \
        dbus.Boolean(True))
    
def launch_guidance(route):
    g_mapmatchedposition_interface.SetSimulationMode(dbus.UInt32(g_navigationcore_session_handle),dbus.Boolean(True))
    g_guidance_interface.StartGuidance(dbus.UInt32(g_navigationcore_session_handle),dbus.UInt32(route))
    g_mapviewercontrol_interface.SetFollowCarMode(dbus.UInt32(g_navigationcore_session_handle),dbus.UInt32(g_mapviewer_maphandle),True)
    g_mapviewercontrol_interface.SetMapViewScale(dbus.UInt32(g_mapviewer_sessionhandle),dbus.UInt32(g_mapviewer_maphandle),ZOOM_GUIDANCE)
    g_mapviewercontrol_interface.SetTargetPoint(dbus.UInt32(g_mapviewer_sessionhandle),\
                                                dbus.UInt32(g_mapviewer_maphandle),\
                                                dbus.Struct((\
                                                dbus.Double(locations[routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data][0]),\
                                                dbus.Double(locations[routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data][1]),\
                                                dbus.Double(0)\
                                                )))
    g_mapmatchedposition_interface.StartSimulation(dbus.UInt32(g_navigationcore_session_handle))
    g_mapmatchedposition_interface.SetSimulationSpeed(dbus.UInt32(g_navigationcore_session_handle), dbus.Byte(SPEED_FACTOR_SLOW))
        
def launch_route_calculation(route):
    global g_current_route
    global g_route_handle
    global g_routing_interface
    global g_navigationcore_session_handle
    g_current_route = route
    print ('Route name: '+routes[g_current_route].getElementsByTagName("name")[0].childNodes[0].data)
    #get route handle
    ret = g_routing_interface.CreateRoute(dbus.UInt32(g_navigationcore_session_handle)) 
    g_route_handle=ret[1]
    routes[g_current_route].getElementsByTagName("handle")[0].childNodes[0].data = g_route_handle
    print ('Route handle: ' + str(g_route_handle))
    start = routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data
    dest = routes[g_current_route].getElementsByTagName("destination")[0].childNodes[0].data
    print ('Calculating route from \
    '+start+'(' + str(locations[routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data][0]) + ',' + str(locations[routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data][1]) + ') to \
    '+dest+'(' + str(locations[routes[g_current_route].getElementsByTagName("destination")[0].childNodes[0].data][0]) + ',' + str(locations[routes[g_current_route].getElementsByTagName("destination")[0].childNodes[0].data][1]) + ')' )
    #set waypoints
    waypointDoubleCapiType = 0x03
    g_routing_interface.SetWaypoints(dbus.UInt32(g_navigationcore_session_handle), \
                                   dbus.UInt32(g_route_handle), \
                                   dbus.Boolean(0), \
                                   dbus.Array([ \
                                        dbus.Dictionary({dbus.Int32(genivi.LATITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(locations[routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data][0])]),dbus.Int32(genivi.LONGITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(locations[routes[g_current_route].getElementsByTagName("start")[0].childNodes[0].data][1])])}), \
                                        dbus.Dictionary({dbus.Int32(genivi.LATITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(locations[routes[g_current_route].getElementsByTagName("destination")[0].childNodes[0].data][0])]),dbus.Int32(genivi.LONGITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(locations[routes[g_current_route].getElementsByTagName("destination")[0].childNodes[0].data][1])])}) \
                                   ]) \
                                   )
    
    #calculate route
    g_routing_interface.CalculateRoute(dbus.UInt32(g_navigationcore_session_handle),dbus.UInt32(g_route_handle))

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
     dbus.Int32(genivi.MAIN_MAP))
    g_mapviewer_maphandle=ret[1]
    
    print ('MapView handle: ' + str(g_mapviewer_maphandle))
    
    time.sleep(2)
    
    print ('Stop following the car position') 
    g_mapviewercontrol_interface.SetFollowCarMode( \
        dbus.UInt32(g_mapviewer_sessionhandle), \
        dbus.UInt32(g_mapviewer_maphandle), \
        dbus.Boolean(False))
    
    print ('Set the 2D perspective') 
    g_mapviewercontrol_interface.SetMapViewPerspective(\
        dbus.UInt32(g_mapviewer_sessionhandle),\
        dbus.UInt32(g_mapviewer_maphandle), \
        genivi.PERSPECTIVE_TWO_D)

def deleteMapView():
    g_mapviewercontrol_interface.ReleaseMapViewInstance( \
      dbus.UInt32(g_mapviewer_sessionhandle), \
      dbus.UInt32(g_mapviewer_maphandle))
    g_mapviewer_session_interface.DeleteSession(g_mapviewer_sessionhandle)
    
print('--------------------------')
print('Guidance Test')
print('--------------------------')

g_exit=0

parser = argparse.ArgumentParser(description='Route Calculation Test for navigation PoC and FSA.')
parser.add_argument('-r','--rou',action='store', dest='routes', help='List of routes in xml format')
args = parser.parse_args()

if args.routes == None:
    print('route file is missing')
    print >>sys.stderr,'Test '+test_name+' FAILED'
    sys.exit(1)
else:
    if not os.path.isfile(args.routes):
        print('file not exists')
        print >>sys.stderr,'Test '+test_name+' FAILED'
        sys.exit(1)
    try:
        DOMTree = xml.dom.minidom.parse(args.routes)
    except OSError as e:
        print >>sys.stderr,'Test '+test_name+' FAILED'
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
                        dbus_interface = "org.genivi.navigation.navigationcore.Routing", \
                        signal_name = "RouteCalculationProgressUpdate")

bus.add_signal_receiver(routing_routeCalculationSuccessful_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Routing", \
                        signal_name = "RouteCalculationSuccessful")

bus.add_signal_receiver(routing_routeDeleted_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Routing", \
                        signal_name = "RouteDeleted")

bus.add_signal_receiver(session_sessionDeleted_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Session", \
                        signal_name = "SessionDeleted")

bus.add_signal_receiver(guidance_guidanceStatusChanged_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Guidance", \
                        signal_name = "GuidanceStatusChanged")

bus.add_signal_receiver(guidance_positionOnRouteChanged_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Guidance", \
                        signal_name = "PositionOnRouteChanged")

bus.add_signal_receiver(guidance_maneuverChanged_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Guidance", \
                        signal_name = "ManeuverChanged")

bus.add_signal_receiver(guidance_waypointReached_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.Guidance", \
                        signal_name = "WaypointReached")

bus.add_signal_receiver(mapmatchedposition_simulationStatusChanged_handler, \
                        dbus_interface = "org.genivi.navigation.navigationcore.MapMatchedPosition", \
                        signal_name = "SimulationStatusChanged")

if dltTrigger==True:
    startTrigger(test_name)

navigationcore_session_obj = bus.get_object('org.genivi.navigation.navigationcore.Session','/org/genivi/navigationcore')
g_navigationcore_session_interface = dbus.Interface(navigationcore_session_obj, dbus_interface='org.genivi.navigation.navigationcore.Session')

routing_obj = bus.get_object('org.genivi.navigation.navigationcore.Routing','/org/genivi/navigationcore')
g_routing_interface = dbus.Interface(routing_obj, dbus_interface='org.genivi.navigation.navigationcore.Routing')

guidance_obj = bus.get_object('org.genivi.navigation.navigationcore.Guidance','/org/genivi/navigationcore')
g_guidance_interface = dbus.Interface(guidance_obj, dbus_interface='org.genivi.navigation.navigationcore.Guidance')

mapviewer_session_obj = bus.get_object('org.genivi.navigation.mapviewer.Session','/org/genivi/mapviewer')
g_mapviewer_session_interface = dbus.Interface(mapviewer_session_obj, dbus_interface='org.genivi.navigation.mapviewer.Session')

mapviewercontrol_obj = bus.get_object('org.genivi.navigation.mapviewer.MapViewerControl','/org/genivi/mapviewer')
g_mapviewercontrol_interface = dbus.Interface(mapviewercontrol_obj, dbus_interface='org.genivi.navigation.mapviewer.MapViewerControl')

g_mapmatchedposition_obj = bus.get_object('org.genivi.navigation.navigationcore.MapMatchedPosition','/org/genivi/navigationcore')
g_mapmatchedposition_interface = dbus.Interface(g_mapmatchedposition_obj, dbus_interface='org.genivi.navigation.navigationcore.MapMatchedPosition')

#get navigationcore session handle
ret = g_navigationcore_session_handle = g_navigationcore_session_interface.CreateSession(dbus.String("test guidance"))
g_navigationcore_session_handle=ret[1]
print ('Navigation core session handle: ' + str(g_navigationcore_session_handle))

createMapView()

g_current_route = 0
g_guidance_active = False
launch_route_calculation(0)

#main loop 
gobject.timeout_add(TIME_OUT, timeout)
loop = gobject.MainLoop()
loop.run()
if g_exit == 1:
    print >>sys.stderr,'Test '+test_name+' FAILED'
else:
    print >>sys.stderr,'Test '+test_name+' PASSED'
sys.exit(g_exit)
