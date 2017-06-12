#!/usr/bin/python

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2017, PSA GROUP
*
* \file test-poi.py
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
test_name = "poi search"

#constants used into the script
TIME_OUT = 10000
ID_FUEL = 256
ID_HOTEL = 257
ID_CAR_PARKING = 258
ID_BAR = 259
ID_RESTAURANT = 260
ATTRIBUTE_SOURCE = 0
ATTRIBUTE_PHONE = 2
RADIUS_HOTEL = 100 #in tenth of meter !
RADIUS_RESTAURANT = 500
STRING_TO_SEARCH = "hof"
MAX_WINDOW_SIZE = 100
OFFSET = 0

# List of coordinates
LATITUDE = list()
LONGITUDE = list()
ALTITUDE = list()
COUNTRY_STRING = list()
CITY_STRING = list()
STREET_STRING = list()
HOUSE_NUMBER_STRING = list()

def catch_poi_configurationChanged_signal_handler(changedSettings):
    for changedSetting in changedSettings:
        if changedSetting == genivi.LOCALE:
            ret=g_poiConfiguration_interface.GetLocale()
            print("language: " + ret[0]) 
            print("country: " + ret[1]) 
            print("script: " + ret[2])

def catch_poi_poiStatus_signal_handler(poiSearchHandle,statusValue):
    if poiSearchHandle == g_searchHandle:
        if statusValue == genivi.SEARCH_FINISHED:
            print("Search finished")
        elif statusValue == genivi.SEARCH_NOT_STARTED:
            g_poiSearch_interface.DeletePoiSearchHandle(poiSearchHandle)
            print("Test PASSED")
            exit()
         
def catch_poi_resultListChanged_signal_handler(poiSearchHandle,resultListSize):
    poiList=[]
    if poiSearchHandle == g_searchHandle: 
        if resultListSize != 0:
            ret=g_poiSearch_interface.RequestResultList(dbus.UInt32(poiSearchHandle),dbus.UInt16(OFFSET),dbus.UInt16(MAX_WINDOW_SIZE),[ATTRIBUTE_SOURCE,ATTRIBUTE_PHONE])
            if ret[0] == genivi.SEARCH_FINISHED and ret[1] >= 0:
                print("Results: "+str(int(ret[1])))
                for result in ret[2]:
                    poiList.append(result[0])
                ret=g_poiSearch_interface.GetPoiDetails(poiList)
                for resultDetail in ret:
                    if resultDetail[1][0] == ID_HOTEL:
                        print("Hotel: " +resultDetail[0][1])
                    elif resultDetail[1][0] == ID_RESTAURANT:
                        print("Restaurant: " +resultDetail[0][1])
                g_poiSearch_interface.CancelPoiSearch(dbus.UInt32(poiSearchHandle))
        else:
            g_poiSearch_interface.CancelPoiSearch(dbus.UInt32(poiSearchHandle))  
       
def timeout():
    print ('Timeout Expired')
    print ('\nTest FAILED')
    exit()

def exit():
    if dltTrigger==True:
        stopTrigger(test_name)
    loop.quit()


print('\n--------------------------')
print('Poi Test')
print('--------------------------\n')

parser = argparse.ArgumentParser(description='Poi Test for navigation PoC and FSA.')
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

print("Search for hotel and restaurant with keyword: "+ STRING_TO_SEARCH)

#connect to session bus
bus = dbus.SessionBus()

bus.add_signal_receiver(catch_poi_configurationChanged_signal_handler, \
                        dbus_interface = "org.genivi.navigation.poiservice.POIConfiguration", \
                        signal_name = "ConfigurationChanged")

bus.add_signal_receiver(catch_poi_poiStatus_signal_handler, \
                        dbus_interface = "org.genivi.navigation.poiservice.POISearch", \
                        signal_name = "PoiStatus")

bus.add_signal_receiver(catch_poi_resultListChanged_signal_handler, \
                        dbus_interface = "org.genivi.navigation.poiservice.POISearch", \
                        signal_name = "ResultListChanged")

if dltTrigger==True:
    startTrigger(test_name)

poiConfiguration = bus.get_object('org.genivi.navigation.poiservice.POIConfiguration','/org/genivi/poiservice/POIConfiguration')
g_poiConfiguration_interface = dbus.Interface(poiConfiguration, dbus_interface='org.genivi.navigation.poiservice.POIConfiguration')

poiContentAccess = bus.get_object('org.genivi.navigation.poiservice.POIContentAccess','/org/genivi/poiservice/POIContentAccess')
g_poiContentAccess_interface = dbus.Interface(poiContentAccess, dbus_interface='org.genivi.navigation.poiservice.POIContentAccess')

poiSearch = bus.get_object('org.genivi.navigation.poiservice.POISearch','/org/genivi/poiservice/POISearch')
g_poiSearch_interface = dbus.Interface(poiSearch, dbus_interface='org.genivi.navigation.poiservice.POISearch')

g_poiConfiguration_interface.SetLocale(dbus.String("fra"),dbus.String("FRA"),dbus.String("Latn"))

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

g_poiSearch_interface.SetCategories(g_searchHandle,[dbus.Struct([dbus.UInt32(ID_HOTEL),dbus.UInt32(RADIUS_HOTEL)]),dbus.Struct([dbus.UInt32(ID_RESTAURANT),dbus.UInt32(RADIUS_RESTAURANT)])])

g_poiSearch_interface.SetAttributes(g_searchHandle,attributesDetails)

g_poiSearch_interface.StartPoiSearch(g_searchHandle,dbus.String(STRING_TO_SEARCH),dbus.Int32(genivi.SORT_BY_DISTANCE))


#main loop 
gobject.timeout_add(TIME_OUT, timeout)
loop = gobject.MainLoop()
loop.run()
