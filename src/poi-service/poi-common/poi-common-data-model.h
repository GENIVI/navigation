/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-common-data-model.h
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
#ifndef __POICOMMONDATAMODEL_H__
#define __POICOMMONDATAMODEL_H__

// Content of this file is the result of several updates of code used by different projects and for this reason is still messy

typedef uint32_t poiId_t;
typedef uint32_t categoryId_t;
typedef uint32_t resourceId_t;
typedef uint32_t attributeId_t;
typedef uint32_t handleId_t;
typedef uint8_t camId_t;

typedef struct
{
    double latitude;
    double longitude;
    double altitude;
} geocoordinate3D_t;

enum ATTRIBUTE_LIST{
    ATTRIBUTE_SOURCE = 0,
    ATTRIBUTE_WEBSITE = 1,
    ATTRIBUTE_PHONE = 2,
    ATTRIBUTE_STARS = 3,
    ATTRIBUTE_OPENINGHOURS = 4,
    ATTRIBUTE_ADDRHOUSENUMBER = 5,
    ATTRIBUTE_ADDRSTREET = 6,
    ATTRIBUTE_ADDRPOSTCODE = 7,
    ATTRIBUTE_ADDRCITY = 8,
    ATTRIBUTE_BRAND = 9,
    ATTRIBUTE_OPERATEUR = 10,
    ATTRIBUTE_CREDIT_CARD = 11,
    ATTRIBUTE_SIZE
};


// Data types used by the CAM and the server
/**
 * \struct category_attribute_t
 * \brief attributes.
 *
 *  Used to store attributes
 *
 */
typedef struct
{
    attributeId_t id; //unique id (used for the search into the database)
    attributeId_t alias_id; //id given by the content access server
    std::string name; //attribute name
    bool isSearched; //attributes is into the search scope
} category_attribute_common_t;

/**
 * \struct poi_category_t
 * \brief poi data.
 *
 *  Used to store the poi category data
 *
 */
typedef struct
{
    categoryId_t id; // unique id (used for the search into the database)
    categoryId_t alias_id; //id given by the content access server
    std::string name; // unique name
    std::string icon; // url of the associated icon
    bool top_level; //true if the category is a pre-defined one (top level with only ALL_CATEGORIES as parent), false for customized categories created by plug-in.
    uint32_t radius;
    double angle; //angle corresponding to the radius (to speed up the SQL search)
    bool hasRecordsInTheDatabase; //records exist in the database
    bool isSearch; //true if the category is into the scope of the search
    std::vector<category_attribute_common_t> attributeList; //list of attributes
    std::vector<categoryId_t> parentList; //list of parents
    std::vector<categoryId_t> childList; //list of children
} poi_category_common_t;

// some defines to be used by the test
#define ALL_CATEGORIES 0
#define INVALID_CATEGORY 0x00
#define MAX_CATEGORIES 256 //to be improved
#define CAM_CATEGORY_OFFSET 0x0100 //offset added to create the id of a category provided by a CAM (to be multiplied by the camId)
#define CAM_ATTRIBUTE_OFFSET 0x0100 //offset added to create the id of an attribute provided by a CAM (to be multiplied by the camId)
#define ICON_WIDTH 32
#define ICON_HEIGHT 37
#define NEW_CATEGORY_NAME "recreation"
#define ATTRIBUTE_PHONE_NAME "phone"
#define ATTRIBUTE_CREDIT_CARD_NAME "credit card"
#define NEW_CITY_NAME "Velizy"
#define NEW_STARS_VALUE 5
#define ICON_URL "../resource/file"
#define ICON_FORMAT "png"
#define POI_PROVIDER "OpenStreetMap"
#define POI_NAME "mySweetHome"
#define POI_LOCATION_LATITUDE 48.779839
#define POI_LOCATION_LONGITUDE 2.217260
#define POI_LOCATION_ALTITUDE 120
#define SEARCH_CENTER_LOCATION_LATITUDE 48.76
#define SEARCH_CENTER_LOCATION_LONGITUDE 2.22
#define SEARCH_CENTER_LOCATION_ALTITUDE 100
#define SEARCH_RADIUS 300 //in tens of meters
#define SEARCH_STRING "Sweet"

#define LANGUAGE_CODE "fra"
#define COUNTRY_CODE "FRA"
#define SCRIPT_CODE "Latn"

#define MEDIASET 1
#define PARENT_ID 0

#define SEARCH_HANDLE 1
#define SEARCH_MAX_SIZE 50

#define CAM_ID 1

#define NO_HANDLE 0

#endif
