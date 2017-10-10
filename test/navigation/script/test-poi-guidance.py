#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2017, PSA GROUP
*
* \file test-poi-guidance.py
*
* \brief This simple test shows how the poi search 
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
import xml.dom.minidom
import argparse
import sys
import os.path
import commands
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
test_name = "poi search/route/guidance"

#constants used into the script
TIME_OUT = 120000
ID_FUEL = 256
ID_HOTEL = 257
ID_CAR_PARKING = 258
ID_BAR = 259
ID_RESTAURANT = 260
ATTRIBUTE_SOURCE = 0
ATTRIBUTE_PHONE = 2
RADIUS_HOTEL = 100 #in tenth of meter !
RADIUS_RESTAURANT = 500
MAX_WINDOW_SIZE = 100
OFFSET = 0
NUMBER_OF_SEGMENTS = 500
SPEED_FACTOR = 16

# List of coordinates
LATITUDE = list()
LONGITUDE = list()
ALTITUDE = list()
COUNTRY_STRING = list()
CITY_STRING = list()
STREET_STRING = list()
HOUSE_NUMBER_STRING = list()

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
        g_routing_interface.DeleteRoute(dbus.UInt32(g_navigationcore_session_handle),dbus.UInt32(g_route_handle))
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
    #shortcut to end the guidance before reaching the destination
    g_mapmatchedposition_interface.PauseSimulation(dbus.UInt32(g_navigationcore_session_handle))
    g_mapmatchedposition_interface.SetSimulationMode(dbus.UInt32(g_navigationcore_session_handle),dbus.Boolean(False))
    g_guidance_interface.StopGuidance(dbus.UInt32(g_navigationcore_session_handle))

def guidance_waypointReached_handler(isDestination):
    print("Waypoint reached: " +str(isDestination))
    if isDestination == 1:
        g_mapmatchedposition_interface.PauseSimulation(dbus.UInt32(g_navigationcore_session_handle))
        g_mapmatchedposition_interface.SetSimulationMode(dbus.UInt32(g_navigationcore_session_handle),dbus.Boolean(False))
        g_guidance_interface.StopGuidance(dbus.UInt32(g_navigationcore_session_handle))
        
def mapmatchedposition_simulationStatusChanged_handler(simulationStatus):
    print ("Simulation status: " +str(simulationStatus))
        

def poi_configurationChanged_signal_handler(changedSettings):
    for changedSetting in changedSettings:
        if changedSetting == genivi.LOCALE:
            ret=g_poiConfiguration_interface.GetLocale()
            print("language: " + ret[0]) 
            print("country: " + ret[1]) 
            print("script: " + ret[2])

def poi_poiStatus_signal_handler(poiSearchHandle,statusValue):
    if poiSearchHandle == g_searchHandle:
        if statusValue == genivi.SEARCH_FINISHED:
            print("Search finished")
        elif statusValue == genivi.SEARCH_NOT_STARTED:
            g_poiSearch_interface.DeletePoiSearchHandle(poiSearchHandle)
            launch_route_calculation(0)
         
def poi_resultListChanged_signal_handler(poiSearchHandle,resultListSize):
    global g_locations
    global start
    global destination
    poiList=[]
    if poiSearchHandle == g_searchHandle: 
        if resultListSize != 0:
            ret=g_poiSearch_interface.RequestResultList(dbus.UInt32(poiSearchHandle),dbus.UInt16(OFFSET),dbus.UInt16(window_size),[ATTRIBUTE_SOURCE,ATTRIBUTE_PHONE])
            if ret[0] == genivi.SEARCH_FINISHED and ret[1] >= 0:
                print("Results: "+str(int(ret[1])))
                for result in ret[2]:
                    poiList.append(result[0])
                ret=g_poiSearch_interface.GetPoiDetails(poiList)
                for resultDetail in ret:
                    if resultDetail[1][0] == ID_HOTEL:
                        print("Hotel: " +resultDetail[0][1])
                        start=resultDetail[0][1]
                        g_locations["start"]=[resultDetail[0][2][0],resultDetail[0][2][1]]                        
                    elif resultDetail[1][0] == ID_RESTAURANT:
                        print("Restaurant: " +resultDetail[0][1])
                        destination=resultDetail[0][1]
                        g_locations["destination"]=[resultDetail[0][2][0],resultDetail[0][2][1]]                        
                g_poiSearch_interface.CancelPoiSearch(dbus.UInt32(poiSearchHandle))
        else:
            print('No poi found')
            g_poiSearch_interface.CancelPoiSearch(dbus.UInt32(poiSearchHandle))  
       
def timeout():
    print ('Timeout Expired\n')
    exit(1)

def exit(value):
    global g_exit
    g_exit=value
    if dltAvailable==True:
        stopTrigger(test_name)
    loop.quit()

def launch_guidance(route):
    g_guidance_interface.StartGuidance(dbus.UInt32(g_navigationcore_session_handle),dbus.UInt32(route))
    g_mapmatchedposition_interface.SetSimulationMode(dbus.UInt32(g_navigationcore_session_handle),dbus.Boolean(True))
    g_mapmatchedposition_interface.SetSimulationSpeed(dbus.UInt32(g_navigationcore_session_handle), dbus.Byte(SPEED_FACTOR))
    g_mapmatchedposition_interface.StartSimulation(dbus.UInt32(g_navigationcore_session_handle))
       
def launch_route_calculation(route):
    global g_current_route
    global g_route_handle
    global g_routing_interface
    global g_navigationcore_session_handle
    global g_locations
    global start
    global destination
    g_current_route = route
    #get route handle
    ret = g_routing_interface.CreateRoute(dbus.UInt32(g_navigationcore_session_handle)) 
    g_route_handle=ret[1]
    print ('Route handle: ' + str(g_route_handle))
    print ('Calculating route from \
    '+start+'(' + str(g_locations["start"][0]) + ',' + str(g_locations["start"][1]) + ') to \
    '+destination+'(' + str(g_locations["destination"][0]) + ',' + str(g_locations["destination"][1]) + ')' )
    #set waypoints
    waypointDoubleCapiType = 0x03
    g_routing_interface.SetWaypoints(dbus.UInt32(g_navigationcore_session_handle), \
                                   dbus.UInt32(g_route_handle), \
                                   dbus.Boolean(0), \
                                   dbus.Array([ \
                                        dbus.Dictionary({dbus.Int32(genivi.LATITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(g_locations["start"][0])]),dbus.Int32(genivi.LONGITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(g_locations["start"][1])])}), \
                                        dbus.Dictionary({dbus.Int32(genivi.LATITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(g_locations["destination"][0])]),dbus.Int32(genivi.LONGITUDE):dbus.Struct([dbus.Byte(waypointDoubleCapiType),dbus.Double(g_locations["destination"][1])])}) \
                                   ]) \
                                   )
    
    #calculate route
    g_routing_interface.CalculateRoute(dbus.UInt32(g_navigationcore_session_handle),dbus.UInt32(g_route_handle))

print('\n--------------------------')
print('Poi Test')
print('--------------------------\n')

#this script loads a file that could contains several locations but only uses the first one (to avoid creating specific resource)
g_exit=0

parser = argparse.ArgumentParser(description='Poi Test for navigation PoC and FSA.')
parser.add_argument('-l','--loc',action='store', dest='locations', help='List of locations in xml format')
parser.add_argument("-v", "--verbose", action='store_true',help='Print the whole log messages')
parser.add_argument('-a','--address',action='store', dest='host', help='Set remote host address')
parser.add_argument('-p','--prt',action='store', dest='port', help='Set remote port number')
parser.add_argument('-s','--string',action='store', dest='string', help='String to search')
parser.add_argument('-r','--radius',action='store', dest='radius', help='Search radius in tenth of meters')
parser.add_argument('-w','--window',action='store', dest='window', help='Max number of requested results')
args = parser.parse_args()

if args.radius == None:
    radius_hotel=RADIUS_HOTEL
    radius_restaurant=RADIUS_RESTAURANT
else:
    radius_hotel=args.radius
    radius_restaurant=args.radius

if args.window == None:
    window_size=MAX_WINDOW_SIZE
else:
    window_size=args.window

if args.string == None:
    print('string to search is missing, by default no string, get all')
    stringToSearch=''
else:
    stringToSearch=args.string

if args.locations == None:
    print('location file is missing')
    print >>sys.stderr,'Test '+test_name+' FAILED'
    sys.exit(1)
else:
    if not os.path.isfile(args.locations):
        print('file not exists')
        print >>sys.stderr,'Test '+test_name+' FAILED'
        sys.exit(1)
    try:
        DOMTree = xml.dom.minidom.parse(args.locations)
    except OSError as e:
        print >>sys.stderr,'Test '+test_name+' FAILED'
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

print("Search for hotel and restaurant with keyword: "+ stringToSearch)

# connect to session bus (remote or local)
if args.host != None:
	bus = dbus.bus.BusConnection("tcp:host=" + args.host +",port="+args.port)
else:
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

bus.add_signal_receiver(poi_configurationChanged_signal_handler, \
                        dbus_interface = "org.genivi.navigation.poiservice.POIConfiguration", \
                        signal_name = "ConfigurationChanged")

bus.add_signal_receiver(poi_poiStatus_signal_handler, \
                        dbus_interface = "org.genivi.navigation.poiservice.POISearch", \
                        signal_name = "PoiStatus")

bus.add_signal_receiver(poi_resultListChanged_signal_handler, \
                        dbus_interface = "org.genivi.navigation.poiservice.POISearch", \
                        signal_name = "ResultListChanged")

if dltAvailable==True:
    startTrigger(test_name)

navigationcore_session_obj = bus.get_object('org.genivi.navigation.navigationcore.Session','/org/genivi/navigationcore')
g_navigationcore_session_interface = dbus.Interface(navigationcore_session_obj, dbus_interface='org.genivi.navigation.navigationcore.Session')

routing_obj = bus.get_object('org.genivi.navigation.navigationcore.Routing','/org/genivi/navigationcore')
g_routing_interface = dbus.Interface(routing_obj, dbus_interface='org.genivi.navigation.navigationcore.Routing')

guidance_obj = bus.get_object('org.genivi.navigation.navigationcore.Guidance','/org/genivi/navigationcore')
g_guidance_interface = dbus.Interface(guidance_obj, dbus_interface='org.genivi.navigation.navigationcore.Guidance')

mapviewer_session_obj = bus.get_object('org.genivi.navigation.mapviewer.Session','/org/genivi/mapviewer')
g_mapviewer_session_interface = dbus.Interface(mapviewer_session_obj, dbus_interface='org.genivi.navigation.mapviewer.Session')

mapmatchedposition_obj = bus.get_object('org.genivi.navigation.navigationcore.MapMatchedPosition','/org/genivi/navigationcore')
g_mapmatchedposition_interface = dbus.Interface(mapmatchedposition_obj, dbus_interface='org.genivi.navigation.navigationcore.MapMatchedPosition')

poiConfiguration = bus.get_object('org.genivi.navigation.poiservice.POIConfiguration','/org/genivi/poiservice/POIConfiguration')
g_poiConfiguration_interface = dbus.Interface(poiConfiguration, dbus_interface='org.genivi.navigation.poiservice.POIConfiguration')

poiContentAccess = bus.get_object('org.genivi.navigation.poiservice.POIContentAccess','/org/genivi/poiservice/POIContentAccess')
g_poiContentAccess_interface = dbus.Interface(poiContentAccess, dbus_interface='org.genivi.navigation.poiservice.POIContentAccess')

poiSearch = bus.get_object('org.genivi.navigation.poiservice.POISearch','/org/genivi/poiservice/POISearch')
g_poiSearch_interface = dbus.Interface(poiSearch, dbus_interface='org.genivi.navigation.poiservice.POISearch')

g_poiConfiguration_interface.SetLocale(dbus.String("fra"),dbus.String("FRA"),dbus.String("Latn"))

#get navigationcore session handle
ret = g_navigationcore_session_handle = g_navigationcore_session_interface.CreateSession(dbus.String("test guidance"))
g_navigationcore_session_handle=ret[1]
print ('Navigation core session handle: ' + str(g_navigationcore_session_handle))

g_current_route = 0
g_guidance_active = False
g_locations = {}
start=""
dest=""
categories=[]
ret=g_poiSearch_interface.GetAvailableCategories()
for categoryAndName in ret:
    if categoryAndName[0] == ID_HOTEL or categoryAndName[0] == ID_RESTAURANT:
        print("Category ID: " + str(int(categoryAndName[0])))
        categories.append(categoryAndName[0])
        print("Name: " + categoryAndName[1])

attributes_hotel=[]
attributes_restaurant=[]
attributesDetails=[]
ret=g_poiSearch_interface.GetCategoriesDetails(categories)
for results in ret:
    if results[0][0] == ID_HOTEL:
        for attribute in results[1]:
            attributes_hotel.append(attribute[0])
            attributesDetails.append(dbus.Struct([dbus.UInt32(attribute[0]),dbus.UInt32(ID_HOTEL),dbus.Int32(1280),dbus.Struct([dbus.Byte(2),dbus.String("")]),dbus.Int32(1314),dbus.Boolean(False)])) 
    elif results[0][0] == ID_RESTAURANT:
        for attribute in results[1]:
            attributes_restaurant.append(attribute[0])
            attributesDetails.append(dbus.Struct([dbus.UInt32(attribute[0]),dbus.UInt32(ID_RESTAURANT),dbus.Int32(1280),dbus.Struct([dbus.Byte(2),dbus.String("")]),dbus.Int32(1314),dbus.Boolean(False)])) 
        
ret=g_poiSearch_interface.GetRootCategory()

g_searchHandle=g_poiSearch_interface.CreatePoiSearchHandle()
print("Search handle: " + str(int(g_searchHandle)))

#init the target (it's the first location in the input file by default) and test 
index=0
lat = LATITUDE[index]
lon = LONGITUDE[index]
alt = ALTITUDE[index]

g_poiSearch_interface.SetCenter(g_searchHandle,dbus.Struct([dbus.Double(lat),dbus.Double(lon),dbus.Double(alt)]))

g_poiSearch_interface.SetCategories(g_searchHandle,[dbus.Struct([dbus.UInt32(ID_HOTEL),dbus.UInt32(radius_hotel)]),dbus.Struct([dbus.UInt32(ID_RESTAURANT),dbus.UInt32(radius_restaurant)])])

g_poiSearch_interface.SetAttributes(g_searchHandle,attributesDetails)

g_poiSearch_interface.StartPoiSearch(g_searchHandle,stringToSearch,dbus.Int32(genivi.SORT_BY_DISTANCE))


#main loop 
gobject.timeout_add(TIME_OUT, timeout)
loop = gobject.MainLoop()
loop.run()
if g_exit == 1:
    print >>sys.stderr,'Test '+test_name+' FAILED'
else:
    print >>sys.stderr,'Test '+test_name+' PASSED'
sys.exit(g_exit)

