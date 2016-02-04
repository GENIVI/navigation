#!/usr/bin/python
# -*- coding: latin-1 -*-

"""
**************************************************************************
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* @copyright Copyright (C) 2014, Alpine Electronics R&D Europe GmbH
*
* @file test-location-input.py
*
* @brief This simple test shows how the location input
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

# constants as defined in the Navigation API
LATITUDE = 0x00a0
LONGITUDE = 0x00a1
ALTITUDE = 0x00a2
FULL_ADDRESS = 0x00b2
COUNTRY = 0x00a6
STATE = 0x00a7
CITY = 0x00a8
ZIPCODE = 0x00a9
STREET = 0x00aa
HOUSE_NUMBER = 0x00ab
CROSSING = 0x00ac
DISTRICT = 0x00ad
PHONE_NUMBER = 0x00ae
POI_NAME = 0x00af
TOWN_CENTER = 0x00b0
FINISHED = 0x00c2

# List of addresses
COUNTRY_STRING = list()
CITY_STRING = list()
STREET_STRING = list()
HOUSE_NUMBER_STRING = list()
# Address #0
COUNTRY_STRING.append('Switzerland')
CITY_STRING.append(u'Genève')
STREET_STRING.append('Rue de Lausanne')
HOUSE_NUMBER_STRING.append('32')
# Address #1
COUNTRY_STRING.append('Switzerland')
CITY_STRING.append('Bern')
STREET_STRING.append('Haslerstrasse')
HOUSE_NUMBER_STRING.append('25')
# Address #2
COUNTRY_STRING.append('Switzerland')
CITY_STRING.append(u'Zürich')
STREET_STRING.append('Rainstrasse')
HOUSE_NUMBER_STRING.append('75')
# Address #3
COUNTRY_STRING.append('Italy')
CITY_STRING.append('Aosta')
STREET_STRING.append('Via Liconi')
HOUSE_NUMBER_STRING.append('44')

# Default size of the list 
WINDOW_SIZE = 20

# Configuration
current_address_index = 0

# Search mode (0 = Spell, 1 = Full string search)
country_search_mode = 1
city_search_mode = 0
street_search_mode = 0
house_number_search_mode = 1


print '\n--------------------------\n' + \
      'LocationInput Test' + \
      '\n--------------------------\n'

if __name__ == '__main__':
    dbus.mainloop.glib.DBusGMainLoop(set_as_default=True)

# connect to session bus
bus = dbus.SessionBus()


# Turn selection criteria values to their corresponding string description
def selection_criterion_to_string(selection_criterion):
    return_value = ''
    if selection_criterion == LATITUDE:
        return_value += 'Latitude'
    elif selection_criterion == LONGITUDE:
        return_value += 'Longitude'
    elif selection_criterion == COUNTRY:
        return_value += 'Country'
    elif selection_criterion == STATE:
        return_value += 'State'
    elif selection_criterion == CITY:
        return_value += 'City'
    elif selection_criterion == TOWN_CENTER:
        return_value += 'City center'
    elif selection_criterion == ZIPCODE:
        return_value += 'ZipCode'
    elif selection_criterion == STREET:
        return_value += 'Street'
    elif selection_criterion == HOUSE_NUMBER:
        return_value += 'House number'
    elif selection_criterion == CROSSING:
        return_value += 'Crossing'
    elif selection_criterion == FULL_ADDRESS:
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
    print '\tACTIVE CONTEXT: selection criterion = ' + selection_criterion_to_string(current_selection_criterion) + \
          ', search string = \'' + entered_search_string + '\''


def change_selection_criterion(selection_criterion):
    global current_selection_criterion

    current_selection_criterion = selection_criterion
    location_input_interface.SetSelectionCriterion(dbus.UInt32(session_handle), dbus.UInt32(location_input_handle),
                                                   dbus.UInt16(current_selection_criterion))


# Spell search
def spell_search(handle, entered_string, search_string, valid_characters, first=0):
    global entered_search_string

    print '-> SpellSearch - entered \'' + entered_string + '\' target \'' + search_string + '\''

    if unicode(search_string) != unicode(entered_string):
        found = unicode(search_string).lower().find(unicode(entered_string).lower())
        if found == 0:
            spell_character = ''
            is_valid = -1
            if first == 0:
                spell_character = search_string[len(entered_string)]
                is_valid = valid_characters.find(spell_character)
            else:
                is_valid = 0
            if is_valid != -1:
                entered_search_string = entered_string + spell_character
                print '\nACTION: Spell search, selection criterion = ' + \
                      selection_criterion_to_string(current_selection_criterion) + ', trying \'' + spell_character + \
                      '\''
                location_input_interface.Spell(dbus.UInt32(session_handle), dbus.UInt32(handle),
                                               dbus.String(spell_character), dbus.UInt16(20))
            else:
                print 'TEST FAILED (Target character can not be entered)'
                loop.quit()
        else:
            print 'TEST FAILED (Unexpected completion)'
            loop.quit()
    else:
        print 'Full spell match'


# Full string search
def full_string_search(handle, search_string):
    global entered_search_string
    global found_exact_match

    entered_search_string = search_string
    found_exact_match = 1  # Force exact match for full string search
    print '\nACTION: Full string search, selection criterion = ' + \
          selection_criterion_to_string(current_selection_criterion) + ', trying \'' + search_string + '\''
    location_input_interface.Search(dbus.UInt32(session_handle), dbus.UInt32(handle), dbus.String(search_string),
                                    dbus.UInt16(20))


def evaluate_address(address, guidable):
    test_passed = 0
    print '\nAddress complete!\nEvaluating...'
    if COUNTRY_STRING[current_address_index] == '':
        test_passed = 1
    elif address[COUNTRY] == COUNTRY_STRING[current_address_index]:
        print 'Country\t\t\t-> ok (' + address[COUNTRY] + ')'
        if CITY_STRING[current_address_index] == '':
            test_passed = 1
        elif address[CITY] == CITY_STRING[current_address_index]:
            print 'City\t\t\t-> ok (' + address[CITY] + ')'
            if STREET_STRING[current_address_index] == '':
                test_passed = 1
            elif address[STREET] == STREET_STRING[current_address_index]:
                print 'Street\t\t\t-> ok (' + address[STREET] + ')'
                if HOUSE_NUMBER_STRING[current_address_index] == '':
                    test_passed = 1
                elif address[HOUSE_NUMBER] == HOUSE_NUMBER_STRING[current_address_index]:
                    print 'House number\t-> ok (' + address[HOUSE_NUMBER] + ')'
                    test_passed = 1

    if guidable == 1:
        if test_passed == 1:
            print 'TEST PASSED'
        else:
            print 'TEST FAILED (wrong address)'
    else:
        print 'TEST FAILED (non-guidable address)'

    loop.quit()


# Signal receiver

# Handler for ContentUpdated callback

def search_status_handler(handle,status):
    print '\n::Search status ' + str(int(status))
    if status == FINISHED:
            location_input_interface.RequestListUpdate(dbus.UInt32(session_handle), dbus.UInt32(handle),
                                                       dbus.UInt16(0),
                                                       dbus.UInt16(WINDOW_SIZE))
        

def content_updated_handler(handle, guidable, available_selection_criteria, address):
    global target_search_string
    global entered_search_string

    print '\n::ContentUpdated for LocationInputHandle ' + str(int(handle))
    print_current_context()
    print '\tGuidable = ' + str(guidable)
    print '\tAvailable selection criteria = ' + selection_criteria_array_to_string(available_selection_criteria)
    print '\tADDRESS: '+dictionary_to_string(address)

    search_mode = -1

    if current_selection_criterion == COUNTRY:
        change_selection_criterion(CITY)
        target_search_string = CITY_STRING[current_address_index]
        search_mode = city_search_mode
    elif current_selection_criterion == CITY:
        change_selection_criterion(STREET)
        target_search_string = STREET_STRING[current_address_index]
        search_mode = street_search_mode
    elif current_selection_criterion == STREET:
        change_selection_criterion(HOUSE_NUMBER)
        target_search_string = HOUSE_NUMBER_STRING[current_address_index]
        search_mode = house_number_search_mode
    elif current_selection_criterion == HOUSE_NUMBER:
        target_search_string = ''

    entered_search_string = ''
    if target_search_string == '':
        evaluate_address(address, guidable)
    elif search_mode == 0:
        spell_search(handle, '', target_search_string, '', 1)
    elif search_mode == 1:
        full_string_search(handle, target_search_string)
    else:
        print '\nTEST FAILED (Invalid search mode)'
        loop.quit()

# Handler for SpellResult callback
def spell_result_handler(handle, unique_string, valid_characters, full_match):
    global entered_search_string
    global spell_next_character
    global found_exact_match
    global available_characters

    print '\n::SpellResult for LocationInputHandle '+str(int(handle))
    if unique_string != entered_search_string:
        print '\tAUTOCOMPLETE: \'' + entered_search_string + '\' -> \'' + unique_string + '\''
    entered_search_string = unique_string
    available_characters = valid_characters
    print_current_context()
    print '\tUnique string = \''+unique_string+'\''
    print '\tValid Characters = \''+valid_characters+'\''
    print '\tFull Match = '+str(full_match)

    if len(valid_characters) == 1:
        if unicode(valid_characters[0]) == u'\x08':
            print '\nTEST FAILED (Dead end spelling)'
            loop.quit()

    if unicode(entered_search_string) == unicode(target_search_string):
        found_exact_match = 1

    spell_next_character = 1


# Handler for SearchResultList callback

def search_result_list_handler(handle, total_size, window_offset, window_size, result_list_window):
    global spell_next_character
    global found_exact_match

    print '\n::SearchResultList for LocationInputHandle ' + str(int(handle))
    print_current_context()
    print '\tTotal size = ' + str(int(total_size)) + ', Window offset = ' + str(int(window_offset)) + \
          ', Window size = ' + str(int(window_size))
    print '\t' + dictionary_array_to_string(result_list_window, '\n\t', window_offset)

    if found_exact_match == 1:
        found_exact_match = 0
        i = 0
        for address in result_list_window:
            if unicode(address[current_selection_criterion][1]) == target_search_string:
                print '\nACTION: Found exact match, selecting \''+unicode(address[current_selection_criterion][1]) + \
                      '\' (Session '+str(int(session_handle)) + ' LocationInputHandle ' + str(int(handle))+')'
                location_input_interface.SelectEntry(dbus.UInt32(session_handle), dbus.UInt32(handle), dbus.UInt16(i))
                break
            i += 1
        if i == window_size:
            print '\nACTION: Found exact match, searching in next page (Session '+str(int(session_handle)) +\
                  ' LocationInputHandle ' + str(int(handle))+')'
            location_input_interface.RequestListUpdate(dbus.UInt32(session_handle), dbus.UInt32(handle),
                                                       dbus.UInt16(window_offset + window_size),
                                                       dbus.UInt16(window_size))
    elif total_size == 1:
        selection_name = result_list_window[0][current_selection_criterion]
        if selection_name == target_search_string:
            print '\nACTION: Single entry list, selecting \'' + result_list_window[0][current_selection_criterion] + \
                  '\' (Session '+str(int(session_handle)) + ' LocationInputHandle ' + str(int(handle))+')'
            location_input_interface.SelectEntry(dbus.UInt32(session_handle), dbus.UInt32(handle), dbus.UInt16(0))
        else:
            print '\nTEST FAILED (Unexpected single result list)'
            loop.quit()
    elif spell_next_character == 1:
        spell_next_character = 0
        spell_search(handle, entered_search_string, target_search_string, available_characters)


# add signal receiver
bus.add_signal_receiver(search_status_handler,
                        dbus_interface='org.genivi.navigationcore.LocationInput',
                        signal_name='SearchStatus')

bus.add_signal_receiver(search_result_list_handler,
                        dbus_interface='org.genivi.navigationcore.LocationInput',
                        signal_name='SearchResultList')

bus.add_signal_receiver(spell_result_handler,
                        dbus_interface='org.genivi.navigationcore.LocationInput',
                        signal_name='SpellResult')

bus.add_signal_receiver(content_updated_handler,
                        dbus_interface='org.genivi.navigationcore.LocationInput',
                        signal_name='ContentUpdated')


# Timeout
def timeout():
    print 'Timeout Expired'
    print '\nTEST FAILED\n'
    loop.quit()


session = bus.get_object('org.genivi.navigationcore.Session', '/org/genivi/navigationcore')
session_interface = dbus.Interface(session, dbus_interface='org.genivi.navigationcore.Session')

# Get SessionHandle
session_handle = session_interface.CreateSession(dbus.String('test location input'))
print 'Session handle = ' + str(session_handle)

location_input_obj = bus.get_object('org.genivi.navigationcore.LocationInput', '/org/genivi/navigationcore')
location_input_interface = dbus.Interface(location_input_obj, dbus_interface='org.genivi.navigationcore.LocationInput')

# Get LocationInputHandle
location_input_handle = location_input_interface.CreateLocationInput(dbus.UInt32(session_handle))
print 'LocationInput handle = ' + str(location_input_handle)

attributes = location_input_interface.GetSupportedAddressAttributes()
print 'Initially supported address attributes = ' + selection_criteria_array_to_string(attributes)

# Start by entering country
entered_search_string = ''
spell_next_character = 0
found_exact_match = 0
available_characters = ''
target_search_string = COUNTRY_STRING[current_address_index]

change_selection_criterion(COUNTRY)

if country_search_mode == 0:
    spell_search(location_input_handle, '', target_search_string, '', 1)
elif country_search_mode == 1:
    full_string_search(location_input_handle, target_search_string)

# Main loop
gobject.timeout_add(10000, timeout)
loop = gobject.MainLoop()
loop.run()