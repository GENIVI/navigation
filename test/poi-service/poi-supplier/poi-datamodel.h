/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-datamodel.h
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
#ifndef __POIPOCDATAMODEL_H__
#define __POIPOCDATAMODEL_H__

#include <stdbool.h>
#include <unistd.h>
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <stdint.h>
#include <sys/types.h>
#include <glibmm/ustring.h>

typedef uint32_t poiId_t;
typedef uint32_t categoryId_t;

typedef enum {
    INVALID = 0,
    NOT_STARTED,
    SEARCHING,
    FINISHED
} search_status_t;

typedef struct
{
    categoryId_t id; // unique id
    Glib::ustring name; // unique name
    bool top_level; //true if the category is a pre-defined one (top level with only ALL_CATEGORIES as parent), false for customized categories created by plug-in.
	uint32_t radius;
	double angle; //angle corresponding to the radius (to speed up the SQL search)
	bool isSearch; //true if the category is into the scope of the search
} poi_category_t;

typedef struct
{
	double lat;
	double lon;
	int32_t alt;
} location_t;

/**
 * \struct geo_node_t
 * \brief id and geo coordinates.
 *
 *  Used to store geo coordinate data
 * 
 */
typedef struct {
	uint64_t segment; /*!< segment (similar to id of <node id="185881594" lat="48.8607204" lon="2.2960844"/>). */
	double latitude; /*!< . */
	double longitude; /*!< . */
} geo_node_t;

/**
 * \struct poi_t
 * \brief poi related informations.
 *
 *  Used to store data of a poi
 * 
 */
typedef struct {
    Glib::ustring name;
	geo_node_t node;
	uint16_t altitude;
	uint16_t offset;
    Glib::ustring category;
    Glib::ustring source;
    Glib::ustring website;
	std::string phone;
    uint16_t stars;
    Glib::ustring opening_hours;
    Glib::ustring addr_house_number;
    Glib::ustring addr_street;
    uint16_t addr_postcode;
    Glib::ustring addr_city;
    Glib::ustring brand;
    Glib::ustring operateur; //nb: use the french word to avoid error with operator keyword
} poi_t;

#endif
