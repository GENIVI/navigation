/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file raw-file-sort.h
*
* \brief This file is part of the poi proof of concept.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.1
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License (MPL), v. 2.0.
* If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* For further information see http://www.genivi.org/.
*
* List of changes:
* 10-02-2014, Philippe Colliot, refinement and migration to the new repository
* <date>, <name>, <description of change>
*
* @licence end@
*/

#ifndef __RAW_FILE_SORT_H__
#define __RAW_FILE_SORT_H__

#include <stdbool.h>
#include <unistd.h>
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <stdint.h>
#include <sys/types.h>

#include <libxml++/libxml++.h>
#include <libxml++/parsers/textreader.h>

/**
 * \enum CONSTANTS
 * \brief Miscellaneous constants.
 *
 */
enum CONSTANTS {
	GEO_NODE_BUFFER_SIZE = 5000,
	POI_BUFFER_SIZE = 2000,
    NODE_BUFFER_SIZE = 10000
};


/**
 * \def INIT_DEFAULT_POI(node, poi)
 * \brief Macro to set to default values.
 * \param node and poi
 * 
*/
#define INIT_DEFAULT_POI(node, poi) { (node.segment = 0);(node.latitude = 0);(node.longitude = 0);(poi.category = "default");(poi.name = "default");(poi.phone = "default");(poi.website = "default");(poi.source = "default");(poi.opening_hours = "default");(poi.stars = 0);(poi.addr_house_number = "default");(poi.addr_street = "default");(poi.addr_postcode = 0);(poi.addr_city = "default");(poi.altitude = 0);(poi.offset = 0);;(poi.brand = "default");(poi.operateur = "default"); }


void clear_string(Glib::ustring *str);
void xml_parser(Glib::ustring file_to_parse, std::string sort_primary_key, std::string* sort_list, uint8_t sort_list_size, poi_t* poi_buffer,uint16_t* poi_buffer_index);

#endif
