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
#include <stdlib.h>
#include <stdint.h>
#include <iostream>
#include <fstream>

#include <CommonTypes.hpp>
#include <POIServiceTypes.hpp>

using namespace v4::org::genivi::navigation::poiservice;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

/**
 * \struct category_attribute_t
 * \brief attributes.
 *
 *  Used to store attributes
 *
 */
typedef struct
{
    CommonTypes::CategoryID id; //unique id
    std::string name; //attribute unique name
    bool isSearched; //attributes is into the search scope
} category_attribute_t;


/**
 * \struct poi_category_t
 * \brief poi data.
 *
 *  Used to store the poi category data
 *
 */
typedef struct
{
    CommonTypes::CategoryID id; // unique id
    std::string name; // unique name
    std::string icon; // url of the associated icon
    bool top_level; //true if the category is a pre-defined one (top level with only ALL_CATEGORIES as parent), false for customized categories created by plug-in.
    uint32_t radius;
    double angle; //angle corresponding to the radius (to speed up the SQL search)
    bool hasRecordsInTheDatabase; //records exist in the database
    bool isSearch; //true if the category is into the scope of the search
    std::vector<category_attribute_t> attributeList; //list of attributes
    std::vector<CommonTypes::CategoryID> parentList; //list of parents
    std::vector<CommonTypes::CategoryID> childList; //list of children
} poi_category_t;


/**
 * \struct route_vector_t
 * \brief vector in a route.
 *
 *  Used to store vector of a route
 *
 */
typedef struct
{
    NavigationTypes::Coordinate3D startPoint;
    NavigationTypes::Coordinate3D endPoint;
} route_vector_t;


/**
 * \struct poi_t
 * \brief poi related informations.
 *
 *  Used to store data of a poi
 * 
 */
typedef struct {
    std::string name;
    NavigationTypes::Coordinate3D coordinate;
    uint64_t segment; /*!< segment (similar to id of <node id="185881594" latitude="48.8607204" longitude="2.2960844"/>). */
    uint16_t offset;
    uint16_t categoryIndex; //index into the table of categories
    uint32_t distance;
    std::string source;
    std::string website;
    std::string phone;
    uint16_t stars;
    std::string openinghours;
    std::string addr_house_number;
    std::string addr_street;
    uint16_t addr_postcode;
    std::string addr_city;
    std::string brand;
    std::string operateur;
} poi_t;

/**
 * \struct camIdName_t
 * \brief cam related informations.
 *
 *  Used to store data of a cam
 *
 */
typedef struct {
    POIServiceTypes::ContentAccessModuleID id;
    std::string name;
} camIdName_t;


#endif
