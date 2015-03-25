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


enum ATTRIBUTE_LIST{
    ATTRIBUTE_SOURCE = 0,
    ATTRIBUTE_WEBSITE,
    ATTRIBUTE_PHONE,
    ATTRIBUTE_STARS,
    ATTRIBUTE_OPENINGHOURS,
    ATTRIBUTE_ADDRHOUSENUMBER,
    ATTRIBUTE_ADDRSTREET,
    ATTRIBUTE_ADDRPOSTCODE,
    ATTRIBUTE_ADDRCITY,
    ATTRIBUTE_BRAND,
    ATTRIBUTE_OPERATEUR,
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

// some remaining defines

#define ALL_CATEGORIES 0
#define INVALID_CATEGORY 0x00
#define MAX_CATEGORIES 256 //to be improved
#define CAM_CATEGORY_OFFSET 0x0100 //offset added to create the id of a category provided by a CAM (to be multiplied by the camId)
#define CAM_ATTRIBUTE_OFFSET 0x0100 //offset added to create the id of an attribute provided by a CAM (to be multiplied by the camId)

#endif
