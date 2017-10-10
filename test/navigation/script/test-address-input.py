#!/usr/bin/python
# -*- coding: latin-1 -*-

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* @copyright Copyright (C) 2014, Alpine Electronics R&D Europe GmbH
* \copyright Copyright (C) 2017, PSA GROUP
*
* @file test-address-input.py
*
* @brief This simple test shows how the address input
*              could be easily tested using a python script
*
* @author Stephan Wiehr <stephan.wiehr@alpine.de>
* @author Philippe Colliot <philippe.colliot@mpsa.com>
*
* @version 1.1
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
* List of changes:
* 04-02-2016, Philippe Colliot, Update to the new API ('i' for enumerations and 'yv' for variants), add status handler
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
#import pdb;pdb.set_trace()    

output = commands.getoutput('ps -A')
if not 'dlt' in output:
    dltAvailable=False
    
#name of the test 
test_name = "address input"

# List of addresses
COUNTRY_STRING = list()
CITY_STRING = list()
STREET_STRING = list()
HOUSE_NUMBER_STRING = list()

# Default size of the list 
WINDOW_SIZE = 20

print('\n--------------------------\n' + \
      'AddressInput Test' + \
      '\n--------------------------\n')

g_exit=0

parser = argparse.ArgumentParser(description='Location input Test for navigation PoC and FSA.')
parser.add_argument('-l','--loc',action='store', dest='locations', help='List of locations in xml format')
parser.add_argument("-v", "--verbose", action='store_true',help='Print the whole log messages')
parser.add_argument('-a','--address',action='store', dest='host', help='Set remote host address')
parser.add_argument('-p','--prt',action='store', dest='port', help='Set remote port number')
args = parser.parse_args()

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
    COUNTRY_STRING.append(location.getElementsByTagName("country")[0].childNodes[0].data)
    CITY_STRING.append(location.getElementsByTagName("city")[0].childNodes[0].data)
    STREET_STRING.append(location.getElementsByTagName("street")[0].childNodes[0].data)
    #HOUSE_NUMBER_STRING.append(location.getElementsByTagName("number")[0].childNodes[0].data)
    HOUSE_NUMBER_STRING.append('') #there's a bug in the navigation core when the house number doesn't exist, so deactivated 

if __name__ == '__main__':
    dbus.mainloop.glib.DBusGMainLoop(set_as_default=True)

# connect to session bus (remote or local)
if args.host != None:
	bus = dbus.bus.BusConnection("tcp:host=" + args.host +",port="+args.port)
else:
    bus = dbus.SessionBus()

def vprint(text):
    if args.verbose:
        print(text)
    
# Turn selection criteria values to their corresponding string description
def selection_criterion_to_string(selection_criterion):
    return_value = ''
    if selection_criterion == genivi.LATITUDE:
        return_value += 'Latitude'
    elif selection_criterion == genivi.LONGITUDE:
        return_value += 'Longitude'
    elif selection_criterion == genivi.COUNTRY:
        return_value += 'Country'
    elif selection_criterion == genivi.STATE:
        return_value += 'State'
    elif selection_criterion == genivi.CITY:
        return_value += 'City'
    elif selection_criterion == genivi.TOWN_CENTER:
        return_value += 'City center'
    elif selection_criterion == genivi.ZIPCODE:
        return_value += 'ZipCode'
    elif selection_criterion == genivi.STREET:
        return_value += 'Street'
    elif selection_criterion == genivi.HOUSE_NUMBER:
        return_value += 'House number'
    elif selection_criterion == genivi.CROSSING:
        return_value += 'Crossing'
    elif selection_criterion == genivi.FULL_ADDRESS:
        return_value += 'Full address'
    else:
        return_value += str(selection_criterion)

    return return_value


# Prepare a dictionary array for pretty printing

def dictionary_array_to_string(dict_array, linefeed, offset=0):
    return_value = ''
    i = offset
    for item in dict_array:
        return_value += str(i) + '. ' + unicode(dictionary_to_string(item))
        if i < offset + len(dict_array) - 1:
            return_value += linefeed
        i += 1

    return return_value


# Prepare a dictionary for pretty printing
# NB: the value is supposed to be [UInt8, Variant], according to the DBus '(yv)', used by CommonAPI
def dictionary_to_string(dictionary):
    return_value = ''
    i = 0
    for key in dictionary.keys():
        value = dictionary[key][1]
        return_value += selection_criterion_to_string(key) + ' = ' + unicode(value)
        i += 1
        if i < len(dictionary):
            return_value += ', '

    return return_value


# Prepare a selection criteria array for pretty printing

def selection_criteria_array_to_string(selection_criterion_array):
    return_value = ''
    i = 0
    for item in selection_criterion_array:
        return_value += selection_criterion_to_string(item)
        i += 1
        if i < len(selection_criterion_array):
            return_value += ', '

    return return_value


def print_current_context():
    vprint('\tACTIVE CONTEXT: selection criterion = ' + selection_criterion_to_string(current_selection_criterion) + \
          ', search string = \'' + entered_search_string + '\'')


def change_selection_criterion(selection_criterion):
    global current_selection_criterion

    current_selection_criterion = selection_criterion
    location_input_interface.SetSelectionCriterion(dbus.UInt32(session_handle), dbus.UInt32(location_input_handle),
                                                   dbus.UInt16(current_selection_criterion))


# Full string search
def full_string_search(handle, search_string):
    global entered_search_string
    global found_exact_match

    entered_search_string = search_string
    found_exact_match = 1  # Force exact match for full string search
    vprint('\nACTION: Full string search, selection criterion = ' + \
          selection_criterion_to_string(current_selection_criterion) + ', trying \'' + search_string + '\'')
    location_input_interface.Search(dbus.UInt32(session_handle), dbus.UInt32(handle), dbus.String(search_string),
                                    dbus.UInt16(20))


def evaluate_address(address, guidable):
    test_passed = 0
    print('\nAddress complete!\nEvaluating...')
    if COUNTRY_STRING[current_address_index] == '':
        test_passed = 1
    elif address[genivi.COUNTRY][1] == COUNTRY_STRING[current_address_index]:
        print ('Country\t\t\t-> ok (' + address[genivi.COUNTRY][1] + ')')
        if CITY_STRING[current_address_index] == '':
            test_passed = 1
        elif address[genivi.CITY][1] == CITY_STRING[current_address_index]:
            print ('City\t\t\t-> ok (' + address[genivi.CITY][1] + ')')
            if STREET_STRING[current_address_index] == '':
                test_passed = 1
            elif address[genivi.STREET][1] == STREET_STRING[current_address_index]:
                print ('Street\t\t\t-> ok (' + address[genivi.STREET][1] + ')')
                if HOUSE_NUMBER_STRING[current_address_index] == '':
                    test_passed = 1
                elif address[genivi.HOUSE_NUMBER][1] == HOUSE_NUMBER_STRING[current_address_index]:
                    print ('House number\t-> ok (' + address[genivi.HOUSE_NUMBER][1] + ')')
                    test_passed = 1

    if guidable == 1:
        if test_passed == 1:
            print ('TEST PASSED')
        else:
            print('wrong address')
            exit(1)
    else:
        print ('non-guidable address')
        exit(1)
    address_index = current_address_index + 1
    if address_index < len(COUNTRY_STRING):
        startSearch(address_index)
    else:
        print ('END OF THE TEST')
        exit(0)


# Signal receiver

# Handler for ContentUpdated callback

def search_status_handler(handle,status):
    vprint('\n::Search status ' + str(int(status)))
    if status == genivi.FINISHED:
            location_input_interface.RequestListUpdate(dbus.UInt32(session_handle), dbus.UInt32(handle),
                                                       dbus.UInt16(0),
                                                       dbus.UInt16(WINDOW_SIZE))
        

def content_updated_handler(handle, guidable, available_selection_criteria, address):
    global target_search_string
    global entered_search_string

    vprint('\n::ContentUpdated for LocationInputHandle ' + str(int(handle)))
    print_current_context()
    vprint('\tGuidable = ' + str(guidable))
    vprint('\tAvailable selection criteria = ' + selection_criteria_array_to_string(available_selection_criteria))
    vprint('\tADDRESS: '+dictionary_to_string(address))

    if current_selection_criterion == genivi.COUNTRY:
        change_selection_criterion(genivi.CITY)
        target_search_string = CITY_STRING[current_address_index]
    elif current_selection_criterion == genivi.CITY:
        change_selection_criterion(genivi.STREET)
        target_search_string = STREET_STRING[current_address_index]
    elif current_selection_criterion == genivi.STREET:
        change_selection_criterion(genivi.HOUSE_NUMBER)
        target_search_string = HOUSE_NUMBER_STRING[current_address_index]
    elif current_selection_criterion == genivi.HOUSE_NUMBER:
        target_search_string = ''
    entered_search_string = ''
    if target_search_string == '':
        evaluate_address(address, guidable)
    else:
        full_string_search(handle, target_search_string)

def search_result_list_handler(handle, total_size, window_offset, window_size, result_list_window):
    global spell_next_character
    global found_exact_match

    vprint('\n::SearchResultList for LocationInputHandle ' + str(int(handle)))
    print_current_context()
    vprint('\tTotal size = ' + str(int(total_size)) + ', Window offset = ' + str(int(window_offset)) + \
          ', Window size = ' + str(int(window_size)))
    vprint('\t' + dictionary_array_to_string(result_list_window, '\n\t', window_offset))

    if found_exact_match == 1:
        found_exact_match = 0
        i = 0
        for address in result_list_window:
            if unicode(address[current_selection_criterion][1]) == target_search_string:
                vprint('\nACTION: Found exact match, selecting \''+unicode(address[current_selection_criterion][1]) + \
                      '\' (Session '+str(int(session_handle)) + ' LocationInputHandle ' + str(int(handle))+')')
                location_input_interface.SelectEntry(dbus.UInt32(session_handle), dbus.UInt32(handle), dbus.UInt16(i))
                break
            i += 1
        if i == window_size:
            vprint('\nACTION: Found exact match, searching in next page (Session '+str(int(session_handle)) +\
                  ' LocationInputHandle ' + str(int(handle))+')')
            location_input_interface.RequestListUpdate(dbus.UInt32(session_handle), dbus.UInt32(handle),
                                                       dbus.UInt16(window_offset + window_size),
                                                       dbus.UInt16(window_size))
    elif total_size == 1:
        selection_name = result_list_window[0][current_selection_criterion]
        if selection_name[1] == target_search_string:
            vprint('\nACTION: Single entry list, selecting \'' + selection_name[1] + \
                  '\' (Session '+str(int(session_handle)) + ' LocationInputHandle ' + str(int(handle))+')')
            location_input_interface.SelectEntry(dbus.UInt32(session_handle), dbus.UInt32(handle), dbus.UInt16(0))
        else:
            print ('Unexpected single result list')
            exit(1)
    elif spell_next_character == 1:
        spell_next_character = 0
        spell_search(handle, entered_search_string, target_search_string, available_characters)


# add signal receiver
bus.add_signal_receiver(search_status_handler,
                        dbus_interface='org.genivi.navigation.navigationcore.LocationInput',
                        signal_name='SearchStatus')

bus.add_signal_receiver(search_result_list_handler,
                        dbus_interface='org.genivi.navigation.navigationcore.LocationInput',
                        signal_name='SearchResultList')

bus.add_signal_receiver(content_updated_handler,
                        dbus_interface='org.genivi.navigation.navigationcore.LocationInput',
                        signal_name='ContentUpdated')


# Timeout
def timeout():
    print ('Timeout Expired\n')
    exit(1)

def exit(value):
    global g_exit
    g_exit=value
    error=location_input_interface.DeleteLocationInput(dbus.UInt32(session_handle),dbus.UInt32(location_input_handle))
    print('Delete location input: '+str(int(error)))
    error=session_interface.DeleteSession(dbus.UInt32(session_handle))
    print('Delete session: '+str(int(error)))
    if dltAvailable==True:
        stopTrigger(test_name)
    loop.quit()
    

def startSearch(address_index):
    global found_exact_match
    global available_characters
    global target_search_string
    global current_address_index
    global entered_search_string
    current_address_index = address_index
    entered_search_string = ''
    found_exact_match = 0
    available_characters = ''
    target_search_string = COUNTRY_STRING[current_address_index]
    
    change_selection_criterion(genivi.COUNTRY)
    full_string_search(location_input_handle, target_search_string)

if dltAvailable==True:
    startTrigger(test_name)
  
session = bus.get_object('org.genivi.navigation.navigationcore.Session', '/org/genivi/navigationcore')
session_interface = dbus.Interface(session, dbus_interface='org.genivi.navigation.navigationcore.Session')

# Get SessionHandle
ret = session_interface.CreateSession(dbus.String('test location input'))
session_handle=ret[1]
print ('Session handle = ' + str(session_handle))

location_input_obj = bus.get_object('org.genivi.navigation.navigationcore.LocationInput', '/org/genivi/navigationcore')
location_input_interface = dbus.Interface(location_input_obj, dbus_interface='org.genivi.navigation.navigationcore.LocationInput')

# Get LocationInputHandle
ret = location_input_interface.CreateLocationInput(dbus.UInt32(session_handle))
location_input_handle = ret[1]
print ('LocationInput handle = ' + str(location_input_handle))

attributes = location_input_interface.GetSupportedAddressAttributes()
print ('Initially supported address attributes = ' + selection_criteria_array_to_string(attributes))

# Configuration
current_address_index = 0
entered_search_string = ''
spell_next_character = 0
found_exact_match = 0
available_characters = ''
target_search_string = ''

startSearch(0)

# Main loop
gobject.timeout_add(10000, timeout)
loop = gobject.MainLoop()
loop.run()
if g_exit == 1:
    print >>sys.stderr,'Test '+test_name+' FAILED'
else:
    print >>sys.stderr,'Test '+test_name+' PASSED'
sys.exit(g_exit)
