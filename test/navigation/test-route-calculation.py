#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2014, XS Embedded GmbH, PCA Peugeot Citroen
*
* \file simulation-dashboard.py
*
* \brief This simple test shows how the route calculation 
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
* 04-02-2016, Philippe Colliot, Update to the new API ('i' for enumerations and 'yv' for variants)
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
#import pdb; pdb.set_trace()

#typedef
routeOverviewValue = namedtuple('routeOverviewValue', ['y','v'])

#constants as defined in the Navigation API
GENIVI_LATITUDE = 0x00a0
GENIVI_LONGITUDE = 0x00a1
GENIVI_TOTAL_TIME = 0x018e
GENIVI_TOTAL_DISTANCE = 0x018f
GENIVI_ROAD_NAME = 0x0147

#constants used into the script
TIME_OUT = 10000

#waypoints used by the script
ZUERICH = 0
BERN = 1
GENEVE = 2
NEUCHATEL = 3

LOCATION_LAT_INDEX = 0
LOCATION_LON_INDEX = 1
LOCATION_NAME_INDEX = 2
locations = []
locations.append([])
locations[ZUERICH].append(47.3673)
locations[ZUERICH].append(8.5500)
locations[ZUERICH].append('Zuerich')
locations.append([])
locations[BERN].append(46.9479)
locations[BERN].append(7.4446)
locations[BERN].append('Bern')
locations.append([])
locations[GENEVE].append(46.2065442)
locations[GENEVE].append(6.1411703)
locations[GENEVE].append('Geneve')
locations.append([])
locations[NEUCHATEL].append(46.9905681)
locations[NEUCHATEL].append(6.928624)
locations[NEUCHATEL].append('Neuchatel')


ROUTE_START_INDEX = 0
ROUTE_DEST_INDEX = 1
ROUTE_NAME_INDEX = 2
ROUTE_HANDLE = 3
routes = []
routes.append([])
routes[0].append(ZUERICH)
routes[0].append(BERN)
routes[0].append('Route number 1')
routes[0].append(0) #by default
routes.append([])
routes[1].append(GENEVE)
routes[1].append(NEUCHATEL)
routes[1].append('Route number 2')
routes[1].append(0) #by default

print '--------------------------'
print 'Route Calculation Test'
print '--------------------------'

if __name__ == '__main__':
    dbus.mainloop.glib.DBusGMainLoop(set_as_default=True) 

#connect to session bus
bus = dbus.SessionBus()

#add signal receivers
def catchall_route_calculation_signals_handler(routeHandle, status, percentage):
    print 'Route Calculation: ' + str(int(percentage)) + ' %'
    if int(percentage) == 100:
        #get route overview
        overview = g_routing_interface.GetRouteOverview(dbus.UInt32(g_route_handle),dbus.Array([dbus.Int32(GENIVI_TOTAL_DISTANCE),dbus.Int32(GENIVI_TOTAL_TIME)]))
        #retrieve distance 
        totalDistance = dbus.Struct(overview[dbus.Int32(GENIVI_TOTAL_DISTANCE)])
        print 'Total Distance: ' + str(totalDistance[1]/1000) + ' km'
        totalTime = dbus.Struct(overview[dbus.Int32(GENIVI_TOTAL_TIME)])
        m, s = divmod(totalTime[1], 60)
        h, m = divmod(m, 60)
        print "Total Time: %d:%02d:%02d" % (h, m, s)
        #get route segments     GetRouteSegments(const uint32_t& routeHandle, const int16_t& detailLevel, const std::vector< DBusCommonAPIEnumeration >& valuesToReturn, const uint32_t& numberOfSegments, const uint32_t& offset, uint32_t& totalNumberOfSegments, std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > >& routeSegments)
        totalNumberOfSegments = dbus.Int32()
        CapiVariant = namedtuple('CapiVariant', ('y','v'))
        routeSegments = [{(Int32,CapiVariant)}]
        #g_routing_interface.GetRouteSegments(dbus.UInt32(g_route_handle),dbus.Int16(0),dbus.Array([dbus.Int32(GENIVI_TOTAL_DISTANCE),dbus.Int32(GENIVI_TOTAL_TIME),dbus.Int32(GENIVI_ROAD_NAME)]),dbus.UInt32(500),dbus.UInt32(0),totalNumberOfSegments,routeSegments)
        route = g_current_route + 1
        if route < len(routes):
            launch_route_calculation(route)
        else:
            for i in range(len(routes)):
                g_routing_interface.DeleteRoute(dbus.UInt32(g_session_handle),dbus.UInt32(routes[i][ROUTE_HANDLE]))
            g_session_interface.DeleteSession(dbus.UInt32(g_session_handle))

def catchall_session_signals_handler(sessionHandle):
    print('Session handle deleted: '+str(sessionHandle))
    if sessionHandle == g_session_handle:
        print 'Test PASSED'
    else:
        print 'Test FAILED'
    loop.quit()

def catchall_route_deleted_signals_handler(routeHandle):
    print('Route handle deleted: '+str(routeHandle))

bus.add_signal_receiver(catchall_route_calculation_signals_handler, \
                        dbus_interface = "org.genivi.navigationcore.Routing", \
                        signal_name = "RouteCalculationProgressUpdate")

bus.add_signal_receiver(catchall_route_deleted_signals_handler, \
                        dbus_interface = "org.genivi.navigationcore.Routing", \
                        signal_name = "RouteDeleted")

bus.add_signal_receiver(catchall_session_signals_handler, \
                        dbus_interface = "org.genivi.navigationcore.Session", \
                        signal_name = "SessionDeleted")

#timeout
def timeout():
    print 'Timeout Expired'
    print '\nTest FAILED'
    loop.quit()

def launch_route_calculation(route):
    global g_current_route
    global g_route_handle
    global g_routing_interface
    global g_session_handle
    g_current_route = route
    print 'Route name: '+routes[g_current_route][ROUTE_NAME_INDEX]
    #get route handle
    g_route_handle = g_routing_interface.CreateRoute(dbus.UInt32(g_session_handle)) 
    routes[g_current_route][ROUTE_HANDLE] = g_route_handle
    print 'Route handle: ' + str(g_route_handle)
    start = routes[g_current_route][ROUTE_START_INDEX]
    dest = routes[g_current_route][ROUTE_DEST_INDEX]
    print 'Calculating route from \
'+locations[start][LOCATION_NAME_INDEX]+'(' + str(locations[start][LOCATION_LAT_INDEX]) + ',' + str(locations[start][LOCATION_LON_INDEX]) + ') to \
'+locations[dest][LOCATION_NAME_INDEX]+'(' + str(locations[dest][LOCATION_LAT_INDEX]) + ',' + str(locations[dest][LOCATION_LON_INDEX]) + ')' 
    #set waypoints
    g_routing_interface.SetWaypoints(dbus.UInt32(g_session_handle), \
                                   dbus.UInt32(g_route_handle), \
                                   dbus.Boolean(0), \
                                   dbus.Array([ \
                                        dbus.Dictionary({dbus.UInt16(GENIVI_LATITUDE):dbus.Struct([0,dbus.Double(locations[start][LOCATION_LAT_INDEX])]),dbus.UInt16(GENIVI_LONGITUDE):dbus.Struct([0,dbus.Double(locations[start][LOCATION_LON_INDEX])])}), \
                                        dbus.Dictionary({dbus.UInt16(GENIVI_LATITUDE):dbus.Struct([0,dbus.Double(locations[dest][LOCATION_LAT_INDEX])]),dbus.UInt16(GENIVI_LONGITUDE):dbus.Struct([0,dbus.Double(locations[dest][LOCATION_LON_INDEX])])}) \
                                   ]) \
                                   )
    
    #calculate route
    g_routing_interface.CalculateRoute(dbus.UInt32(g_session_handle),dbus.UInt32(g_route_handle))


session = bus.get_object('org.genivi.navigationcore.Session','/org/genivi/navigationcore')
g_session_interface = dbus.Interface(session, dbus_interface='org.genivi.navigationcore.Session')

#get session handle
g_session_handle = g_session_interface.CreateSession(dbus.String("test route calculation"))
print 'Session handle: ' + str(g_session_handle)

routing_obj = bus.get_object('org.genivi.navigationcore.Routing','/org/genivi/navigationcore')
g_routing_interface = dbus.Interface(routing_obj, dbus_interface='org.genivi.navigationcore.Routing')

g_current_route = 0
launch_route_calculation(0)


#main loop 
gobject.timeout_add(TIME_OUT, timeout)
loop = gobject.MainLoop()
loop.run()


