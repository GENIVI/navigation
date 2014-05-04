/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file main.cpp
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

#include <stdbool.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <sys/types.h>
#include <iostream>
#include <cmath>
#include <typeinfo>
#include <getopt.h>
#include <dbus-c++/glib-integration.h>

#include "poi-server-class.h"

static const char* poiSearch_SERVICE_NAME = "org.genivi.poiservice.POISearch";
static const char* poiSearch_OBJECT_PATH = "/org/genivi/poiservice/POISearch";
static const char* poiContentAccess_SERVICE_NAME = "org.genivi.poiservice.POIContentAccess";
static const char* poiContentAccess_OBJECT_PATH = "/org/genivi/poiservice/POIContentAccess";
static const char* contentAccessModule_OBJECT_PATH = "/org/genivi/poiservice/POIContentAccessModule";
static const char* EnhancedPosition_SERVICE_NAME = "org.genivi.positioning.EnhancedPosition";
static const char* EnhancedPosition_OBJECT_PATH = "/position";
static const char* Routing_SERVICE_NAME = "org.genivi.navigationcore.Routing";
static const char* Routing_OBJECT_PATH = "/org/genivi/navigationcore";

// SQL requests
static const char* SQL_REQUEST_GET_AVAILABLE_CATEGORIES = "SELECT Id,name FROM poicategory WHERE Id IN (SELECT poicategory_Id FROM belongsto GROUP BY poicategory_Id);";
static const char* SQL_REQUEST_GET_CATEGORY_ATTRIBUTES = "SELECT Id,name FROM poiattribute WHERE Id IN (SELECT poiattribute_Id FROM hasattribute WHERE poicategory_Id IS ";
static const char* SQL_REQUEST_GET_AVAILABLE_AREA = "SELECT leftlongitude,bottomlatitude,rightlongitude,toplatitude FROM availablearea;";
static const char* SQL_REQUEST_GET_PARENT_CATEGORIES = "SELECT parentId FROM poicategorykinship WHERE childId IS ";
static const char* SQL_REQUEST_GET_CHILD_CATEGORIES = "SELECT childId FROM poicategorykinship WHERE parentId IS ";
static const char* SQL_REQUEST_GET_CATEGORY_ICONS = "SELECT url,format FROM iconset WHERE Id IS (SELECT iconset_Id FROM isdisplayedas WHERE poicategory_Id IS  ";

// DBus instances
static DBus::Glib::BusDispatcher *dispatcher;
static DBus::Connection *dbusConnection;
static poiSearchServer *serverPoiSearch;
static poiContentAccessServer *serverpoiContentAccess;
static EnhancedPosition *clientEnhancedPosition;
static Routing *clientRouting;

// class Routing

Routing::Routing(DBus::Connection &connection)
    : DBus::ObjectProxy(connection,Routing_OBJECT_PATH,Routing_SERVICE_NAME)
{
}

Routing::~Routing()
{
}

void Routing::RouteDeleted(const uint32_t &routeHandle)
{

}

void Routing::RouteCalculationCancelled(const uint32_t &routeHandle)
{

}

void Routing::RouteCalculationSuccessful(const uint32_t& routeHandle, const std::map< uint16_t, uint16_t >& unfullfilledPreferences)
{

}

void Routing::RouteCalculationFailed(const uint32_t& routeHandle, const uint16_t& errorCode, const std::map< uint16_t, uint16_t >& unfullfilledPreferences)
{

}

void Routing::RouteCalculationProgressUpdate(const uint32_t& routeHandle, const uint16_t &status, const uint8_t &percentage)
{

}

void Routing::AlternativeRoutesAvailable (const std::vector<uint32_t>& routeHandlesList)
{

}



// class EnhancedPosition

EnhancedPosition::EnhancedPosition(DBus::Connection &connection)
    : DBus::ObjectProxy(connection,EnhancedPosition_OBJECT_PATH,EnhancedPosition_SERVICE_NAME)
{
    m_currentLocation.latitude = 48.85792; //by default center of Paris
    m_currentLocation.longitude = 2.3383145;
    m_currentLocation.altitude = 0;
}
EnhancedPosition::~EnhancedPosition()
{
}
void EnhancedPosition::PositionUpdate(const std::vector< uint16_t >& changedValues)
{
    std::map< uint16_t, ::DBus::Variant > reply;
    std::map< uint16_t, ::DBus::Variant >::iterator iter;

    reply = GetPosition();
    iter = reply.find(GENIVI_NAVIGATIONCORE_LATITUDE);
    if (iter != reply.end())
        m_currentLocation.latitude = reply.at(GENIVI_NAVIGATIONCORE_LATITUDE);
    iter = reply.find(GENIVI_NAVIGATIONCORE_LONGITUDE);
    if (iter != reply.end())
        m_currentLocation.longitude = reply.at(GENIVI_NAVIGATIONCORE_LONGITUDE);
    iter = reply.find(GENIVI_NAVIGATIONCORE_ALTITUDE);
    if (iter != reply.end())
        m_currentLocation.altitude = reply.at(GENIVI_NAVIGATIONCORE_ALTITUDE);
}

void EnhancedPosition::RotationRateUpdate(const std::vector< uint16_t >& changedValues)
{

}

void EnhancedPosition::AccuracyUpdate(const std::vector< uint16_t >& changedValues)
{

}

void EnhancedPosition::SatelliteInfoUpdate(const std::vector< uint16_t >& changedValues)
{

}

void EnhancedPosition::StatusUpdate(const std::vector< uint16_t >& changedValues)
{

}

// Specific methods

DBus_geoCoordinate3D::geoCoordinate3D_t EnhancedPosition::GetCurrentLocation()
{
    return(m_currentLocation);
}

// class  contentAccessModule

contentAccessModule::contentAccessModule(DBus::Connection &connection, const std::string& service)
    : DBus::ObjectProxy(connection, contentAccessModule_OBJECT_PATH,service.c_str())
{
}

contentAccessModule::~contentAccessModule()
{
}

// class  poiContentAccessServer

poiContentAccessServer::poiContentAccessServer(DBus::Connection &connection)
: DBus::ObjectAdaptor(connection, poiContentAccess_OBJECT_PATH)
{
    //version is hard coded
    m_version._1 = 0;
    m_version._2 = 4;
    m_version._3 = 0;
    m_version._4 = "25-10-2012";
    m_camName = "";
    m_camId = INVALID_HANDLE;
    mp_clientcontentAccessModule = NULL;
    m_poiSearchHandle = INVALID_HANDLE;
    m_poiCategoriesAdded.clear();
    m_poiCategoriesRegistered.clear();
}

poiContentAccessServer::~poiContentAccessServer()
{
    if (mp_clientcontentAccessModule)
	delete(mp_clientcontentAccessModule);
}

uint8_t poiContentAccessServer::RegisterContentAccessModule(const std::string& moduleName)
{
    // the POC is limited to the management of one CAM !
    if (m_camId != INVALID_HANDLE)
        sendDBusError("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {
        m_camName = moduleName;
        m_camId = VALID_HANDLE;
        // create a client for contentAccessModule
        mp_clientcontentAccessModule = new contentAccessModule(*dbusConnection, moduleName);
	// connect it to the POISearch server
	ConnectTocontentAccessModuleClient(mp_clientcontentAccessModule);
    }
    return(m_camId);
}

void poiContentAccessServer::UnRegisterContentAccessModule(const uint8_t& camId)
{
    if ((m_camId == INVALID_HANDLE) || (camId != m_camId))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {
        m_poiCategoriesRegistered.clear();
        m_poiCategoriesAdded.clear();
        m_camName = "";
        m_camId = INVALID_HANDLE;
	ConnectTocontentAccessModuleClient(NULL);
	delete(mp_clientcontentAccessModule);
    }
}

void poiContentAccessServer::RegisterPoiCategories(const uint8_t& camId, const std::vector< uint16_t >& poiCategories)
{
    std::vector< DBus_categoryReason::DBus_categoryReason_t > poiCategoriesAndReason;
    DBus_categoryReason::categoryReason_t categoryAndReason;
    DBus_categoryReason catAndReas;
    size_t category_index;

    if ((m_camId == INVALID_HANDLE) || (camId != m_camId))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {
        if (m_poiCategoriesRegistered.size() < MAX_CATEGORIES)
        { //limitation of categories managed
            for (category_index=0;category_index<poiCategories.size();category_index++)
            {
                if (poiCategories.at(category_index) == (m_poiCategoriesAdded.at(category_index).id))
                { //category id has been added before, so register it
                    m_poiCategoriesRegistered.push_back(m_poiCategoriesAdded.at(category_index));
                    categoryAndReason.id = m_poiCategoriesAdded.at(category_index).id;
                    categoryAndReason.reason = GENIVI_POISERVICE_ADDED;
                    catAndReas.set(categoryAndReason);
                    poiCategoriesAndReason.push_back(catAndReas.getDBus());
                }
            }
            mp_poiSearch->CategoriesUpdated(poiCategoriesAndReason);
        }
        else
           sendDBusError("org.genivi.poiprovider.poiContentAccess.Error.CAMCategoryNotAvailable"); //to be discussed !
    }
}

std::vector< uint16_t > poiContentAccessServer::AddCategories(const uint8_t& camId, const std::vector< DBus_CAMcategory::DBus_CAMcategory_t >& poiCategories)
{
    DBus_CAMcategory CAMcat;
    DBus_CAMcategory::CAMcategory_t CAMCategory;
    DBus_CAMcategoryDetails::CAMcategoryDetails_t details;
    poi_category_t category;
    category_attribute_t attribute;
    std::vector<uint16_t> return_value;
    size_t category_index,attribute_index;

    return_value.clear();

    if ((m_camId == INVALID_HANDLE) || (camId != m_camId))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {
        if (m_poiCategoriesAdded.size() < MAX_CATEGORIES)
        { //limitation of categories managed
            for (category_index=0;category_index<poiCategories.size();category_index++)
            {
                CAMcat.setDBus(poiCategories.at(category_index));
                CAMCategory = CAMcat.get();

                details = CAMCategory.details;

                category.id = (camId*CAM_CATEGORY_OFFSET) + category_index; //create an alias
                category.name = details.name; // get the category name
                category.icon = details.icons;
                category.top_level = false; //additional categories, so false
                category.attributeList.clear();
                for (attribute_index=0;attribute_index<CAMCategory.attributes.size();attribute_index++)
                {
                    attribute.name = (CAMCategory.attributes.at(attribute_index)).name;
                    attribute.id = (camId*CAM_ATTRIBUTE_OFFSET) + attribute_index;
                    attribute.isSearched = false;
                    category.attributeList.push_back(attribute);
                }
                m_poiCategoriesAdded.push_back(category);
                return_value.push_back(category.id);
            }
        }
        else
            sendDBusError("org.genivi.poiprovider.poiContentAccess.Error.CAMCategoriesOverflow"); //to be discussed !
    }
    return(return_value);
}

void poiContentAccessServer::UpdateCategories(const uint8_t& camId, const std::vector< DBus_CAMcategoryUpdate::DBus_CAMcategoryUpdate_t >& poiCategories)
{
    if ((m_camId == INVALID_HANDLE) || (camId != m_camId))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {

    }
}

void poiContentAccessServer::RemoveCategories(const uint8_t& camId, const std::vector< uint16_t >& poiCategories)
{
    std::vector< DBus_categoryReason::DBus_categoryReason_t > poiCategoriesAndReason;
    DBus_categoryReason::categoryReason_t categoryAndReason;
    DBus_categoryReason catAndReas;
    size_t category_index;

    if ((m_camId == INVALID_HANDLE) || (camId != m_camId))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {
        if ((m_poiCategoriesAdded.size() > 0) && (poiCategories.size() > 0))
        {
            if (poiCategories.size() > m_poiCategoriesAdded.size())
                sendDBusError("org.genivi.poiprovider.poiContentAccess.Error.CategoryError"); //to be discussed !
            else
            {
                for (category_index=0;category_index<poiCategories.size();category_index++)
                {
                    categoryAndReason.id = poiCategories.at(category_index); //prepare it before, because after it'll be erased !
                    categoryAndReason.reason = GENIVI_POISERVICE_REMOVED;
                    catAndReas.set(categoryAndReason);
                    if (removeCategoryFromTables(poiCategories.at(category_index)) == true)
                        poiCategoriesAndReason.push_back(catAndReas.getDBus());
                }
                //warn the clients
                mp_poiSearch->CategoriesUpdated(poiCategoriesAndReason);
            }
        }
    }
}

// Specific methods

void poiContentAccessServer::ConnectTopoiSearchServer(poiSearchServer *poiSearch)
{
    mp_poiSearch = poiSearch; //link to the instance of poi search
}

void poiContentAccessServer::ConnectTocontentAccessModuleClient(contentAccessModule *client)
{
    mp_contentAccessModule = client; //link to the instance of contentAccessModule
}

DBus::Variant poiContentAccessServer::createVariantString(std::string str)
{
    DBus::Variant var;
    DBus::MessageIter iter = var.writer();
    iter.append_string(str.c_str());
    return var;
}

DBus::Variant poiContentAccessServer::createVariantUint16(uint16_t value)
{
    DBus::Variant var;
    DBus::MessageIter iter = var.writer();
    iter.append_uint16(value);
    return var;
}

bool poiContentAccessServer::GetRegisteredContentAccessModule(cam_t *cam)
{
    if (m_camId == INVALID_HANDLE)
        return(false);
    else
    {
        cam->id = m_camId;
        cam->name = m_camName;
        return(true);
    }
}

bool poiContentAccessServer::GetRegisteredCategories(uint8_t camId, std::vector< DBus_categoryIdName::DBus_categoryIdName_t > *categoryList)
{
    DBus_categoryIdName::categoryIdName_t category;
    DBus_categoryIdName cat;
    size_t category_index;

    if (camId != m_camId)
        return(false);
    else
    { //only one cam managed
        for (category_index=0;category_index<m_poiCategoriesRegistered.size();category_index++)
        {
            category.id.id = (m_poiCategoriesRegistered.at(category_index)).id;
            category.name = (m_poiCategoriesRegistered.at(category_index)).name;
            category.id.top_level = (m_poiCategoriesRegistered.at(category_index)).top_level;
            cat.set(category);
            categoryList->push_back(cat.getDBus());
        }
        return(true);
    }
}

bool poiContentAccessServer::GetRegisteredCategoriesDetails(uint8_t camId, std::vector<DBus_category> *categoryList)
{
    DBus_category cat;
    DBus_category::category_t category;
    DBus_categoryDetails::categoryDetails_t categoryDetails;
    DBus_categoryOperator::categoryOperator_t categoryOperator;
    std::vector<DBus_categoryAttribute::categoryAttribute_t> categoryAttributeList;
    DBus_categoryAttribute::categoryAttribute_t categoryAttribute;
    std::vector<DBus_categorySortOption::categorySortOption_t> categorySortOptionList;;
    DBus_categorySortOption::categorySortOption_t categorySortOption;;
    uint16_t index;
    size_t category_index;

    if (camId != m_camId)
        return(false);
    else
    { //only one cam managed
        for (category_index=0;category_index<m_poiCategoriesRegistered.size();category_index++)
        {
            categoryDetails.id = (m_poiCategoriesRegistered.at(category_index)).id;
            categoryDetails.parents_id.clear();

            for (index=0;index<(m_poiCategoriesRegistered.at(category_index)).parentList.size();index++)
            { //parents
                categoryDetails.parents_id.push_back((m_poiCategoriesRegistered.at(category_index)).parentList.at(index));
            }
            categoryDetails.icons = (m_poiCategoriesRegistered.at(category_index)).icon;
            categoryDetails.name = (m_poiCategoriesRegistered.at(category_index)).name;
            categoryDetails.top_level = (m_poiCategoriesRegistered.at(category_index)).top_level;
            categoryDetails.description = "no description available";
            categoryDetails.media = "no media";
            categoryAttributeList.clear();
            for (index=0;index<((m_poiCategoriesRegistered.at(category_index)).attributeList.size());index++)
            {
                categoryAttribute.name = ((m_poiCategoriesRegistered.at(category_index)).attributeList.at(index)).name;
                categoryAttribute.type = 0;
                categoryAttribute.oper.clear();
                categoryOperator.id = GENIVI_POISERVICE_EQUAL;
                categoryOperator.name = "EQUAL";
                categoryAttribute.oper.push_back(categoryOperator);
                categoryAttributeList.push_back(categoryAttribute);
            }
            categorySortOptionList.clear();
            categorySortOption.id = GENIVI_POISERVICE_SORT_DEFAULT;
            categorySortOption.name = "DEFAULT";
            categorySortOptionList.push_back(categorySortOption);

            category.details = categoryDetails;
            category.attributes = categoryAttributeList;
            category.sortOptions = categorySortOptionList;
            cat.set(category);
            categoryList->push_back(cat);
        }
        return(true);
    }
}

void poiContentAccessServer::ResetRegisteredSearchCategoriesFlags(uint8_t camId)
{
    size_t index;

    if (camId == m_camId)
    { //only one cam managed
        //firstly clean up the list used for the search
        m_poiCategories.clear();
        for (index=0;index<m_poiCategoriesRegistered.size();index++)
        {
            (m_poiCategoriesRegistered.at(index)).isSearch = false;
        }
    }
}

void poiContentAccessServer::ResetRegisteredAttributeCategoriesFlags(uint8_t camId)
{
    size_t index,sub_index;

    if (camId == m_camId)
    { //only one cam managed
        //firstly clean up the list used for the search
        m_poiAttributes.clear();
        for (index=0;index<m_poiCategoriesRegistered.size();index++)
        {
            for (sub_index=0;sub_index<((m_poiCategoriesRegistered.at(index)).attributeList).size();sub_index++)
                (m_poiCategoriesRegistered.at(index)).attributeList.at(sub_index).isSearched =false;
        }
    }
}

void poiContentAccessServer::SetRegisteredSearchCategory(uint8_t camId, DBus_categoryRadius::categoryRadius_t category)
{
    size_t index;
    DBus_categoryRadius catRad;

    if (camId == m_camId)
    { //only one cam managed
        //firstly clean up the list used for the search
        m_poiCategories.clear();
        for (index=0;index<m_poiCategoriesRegistered.size();index++)
        {
            if ((m_poiCategoriesRegistered.at(index)).id == category.id)
            {
                (m_poiCategoriesRegistered.at(index)).isSearch = true;
                (m_poiCategoriesRegistered.at(index)).id= category.id;
                (m_poiCategoriesRegistered.at(index)).radius = category.radius;
                catRad.set(category);
                m_poiCategories.push_back(catRad.getDBus()); //populate the list used for the search
            }
        }
    }
}

void poiContentAccessServer::SetRegisteredAttributeCategoryFlag(uint8_t camId,uint32_t categoryId, std::string attributeName, uint16_t attributeId)
{
    size_t index, sub_index;
    DBus_attributeDetails attrib;
    DBus_attributeDetails::attributeDetails_t attribute;

    if (camId == m_camId)
    { //only one cam managed

        //default setting of attribute
        attribute = attrib.get();

        for (index=0;index<m_poiCategoriesRegistered.size();index++)
        {
            if ((m_poiCategoriesRegistered.at(index)).id == categoryId)
            {
                for (sub_index=0;sub_index<((m_poiCategoriesRegistered.at(index)).attributeList).size();sub_index++)
                {
                    if ((m_poiCategoriesRegistered.at(index)).attributeList.at(sub_index).name == attributeName)
                    {
                        (m_poiCategoriesRegistered.at(index)).attributeList.at(sub_index).isSearched =true;
                        attribute.id = attributeId;
                        attribute.attribute.name = attributeName;
                        attribute.poiCategory = categoryId;
                        attrib.set(attribute);
                        m_poiAttributes.push_back(attrib.getDBus());
                    }
                }
            }
        }
    }
}

void poiContentAccessServer::SetLanguage(std::string LanguageCode, std::string CountryCode)
{
    if (m_camId != INVALID_HANDLE)
    { //only one cam managed
        mp_contentAccessModule->SetLanguage(LanguageCode,CountryCode);
    }
}

void poiContentAccessServer::SetPoiSearchHandle(uint8_t poiSearchHandle)
{
    m_poiSearchHandle =  poiSearchHandle;
}

void poiContentAccessServer::ResetPoiSearchHandle()
{
    m_poiSearchHandle = INVALID_HANDLE;
}

void poiContentAccessServer::PoiSearchCanceled(uint8_t poiSearchHandle)
{
    m_poiTable.clear();
    m_poiDetailsTable.clear();
    mp_contentAccessModule->PoiSearchCanceled(poiSearchHandle);
}

DBus_poiCAMDetails::DBus_poiCAMDetails_t poiContentAccessServer::GetResultPoi(uint16_t index)
{
    return(m_poiTable.at(index));
}

DBus_searchResultDetails::DBus_searchResultDetails_t poiContentAccessServer::GetPoiDetails(uint32_t id)
{
    uint16_t index;
    bool isPOIFound;
    DBus_searchResultDetails searchResDet;
    DBus_searchResultDetails::searchResultDetails_t searchResDetails;
    isPOIFound = false;
    index=0;
    while ((isPOIFound == false) && (index<m_poiDetailsTable.size()))
    {
        searchResDet.setDBus(m_poiDetailsTable.at(index));
        searchResDetails = searchResDet.get();
        if (searchResDetails.details.id == id)
            isPOIFound = true;
        else
            index++;
    }
    return(m_poiDetailsTable.at(index));
}

uint16_t poiContentAccessServer::searchAroundALocation(DBus_geoCoordinate3D::geoCoordinate3D_t location,const std::string* inputString, uint16_t sortOption)
{
    uint16_t maxSize;
    DBus_geoCoordinate3D loc;
    std::vector< std::string > attributes;
    uint16_t statusValue;
    uint16_t resultListSize;
    std::vector<uint32_t> poiList;
    uint16_t index;

    resultListSize = 0;

    if (m_camId != INVALID_HANDLE)
    { //only one cam managed
        m_poiTable.clear(); //clean up the table of poi
        m_poiDetailsTable.clear(); //clean up the table of details

        //prepare the data for the Poi Search on the CAM
        maxSize = 255; //by default, to be discussed why it's needed to define it ?
        loc.set(location);
        mp_contentAccessModule->PoiSearchStarted(m_poiSearchHandle,maxSize,loc.getDBus(),m_poiCategories,m_poiAttributes,*inputString,sortOption);

        //wait for end of search on the CAM
        do
        {
           mp_contentAccessModule->ResultListRequested(m_camId,m_poiSearchHandle,attributes,statusValue,resultListSize,m_poiTable);
        } while(statusValue == GENIVI_POISERVICE_SEARCHING);

        //get details now !
        //build list of poi to get
        for (index=0;index<resultListSize;index++)
            poiList.push_back(m_poiTable.at(index)._1);
        m_poiDetailsTable = mp_contentAccessModule->PoiDetailsRequested(poiList);
    }

    return(resultListSize);
}

bool poiContentAccessServer::isAttributeAvailable(std::string attributeName)
{
    //to do
    return(true);
}

bool poiContentAccessServer::removeCategoryFromTables(uint16_t id)
{
    size_t index;
    bool isFound;

    //check if category has been registered and remove it
    isFound = false;
    index = 0;
    do {
        if ((m_poiCategoriesRegistered.at(index)).id == id)
        {
            m_poiCategoriesRegistered.erase(m_poiCategoriesRegistered.begin()+index);
            isFound = true;
        }
        else
            index++;
    } while ((isFound==false) && (index<m_poiCategoriesRegistered.size()));

    if (isFound == true)
    {
        //remove the category that has been added
         isFound = false;
         index = 0;
         do {
             if ((m_poiCategoriesAdded.at(index)).id == id)
             {
                 m_poiCategoriesAdded.erase(m_poiCategoriesAdded.begin()+index);
                 isFound = true;
             }
             else
                 index++;
         } while ((isFound==false) && (index<m_poiCategoriesAdded.size()));
         return(true);
    }
    return(false);
}

void poiContentAccessServer::sendDBusError(const char* message)
{
    //todo DBus::ErrorInvalidArgs( throw ??
    throw DBus::ErrorFailed(message);
}

// class  poiSearchServer

poiSearchServer::poiSearchServer(DBus::Connection &connection, const char* poiDatabaseFileName, poiContentAccessServer* poiContentAccess)
    : DBus::ObjectAdaptor(connection, poiSearch_OBJECT_PATH)
    {
        std::string sqlQuery; //SQL request on database
        std::ostringstream  strStream; //temporary stream used for transformation into string
        vector<vector<string> > query_result, additionnal_query_result;
        vector<string>  query_line, additionnal_query_line;
        size_t index,sub_index;
        category_attribute_t attribute;
        uint16_t value;
        uint16_t parent,child;

        //version is hard coded
        DBus_version::version_t version;
        version.major = 1;
        version.minor = 0;
        version.micro = 0;
        version.date = "19-12-2012";
        m_version.set(version);
        m_languageCode = "fra"; //french by default (ISO 639-2)
        m_countryCode = "FRA"; //france by default (ISO 3166-1 alpha-3)
        m_poiSearchHandle = INVALID_HANDLE;
        m_poiSearchProximity = false; //by default search around the current location
        mp_database = new Database(poiDatabaseFileName);
        mp_poiContentAccess = poiContentAccess;
	mp_dbusConnection = &connection;
        m_availableCategories = 0;
        m_rootCategory = 0;
        m_searchStatus = GENIVI_POISERVICE_NOT_STARTED;
        m_routeHandle = INVALID_HANDLE;

        // all the pois and the related stuff are included into the database at the startup
        // so we can update some tables into the constructor

        // retrieve the available categories (the ones that have at least one record)
        query_result = mp_database->query(SQL_REQUEST_GET_AVAILABLE_CATEGORIES);
        if (query_result.empty())
        {
            onError(); //database is not well populated
            //todo something with table ?
        }
        else
        { // Id,name
            m_availableCategories = query_result.size(); //store the number of categories
            for (index = 0; index < m_availableCategories; index++)
            {
                // read the result of the query and store it
                query_line = query_result.at(index);
                fromString<uint16_t>(value,query_line[0], std::dec);
                m_availableCategoryTable[index].id = value;

                // retrieve the associated icons (for the moment, just one)
                sqlQuery = SQL_REQUEST_GET_CATEGORY_ICONS;
                strStream.str("");
                strStream << value;
                sqlQuery += strStream.str();
                sqlQuery += ");";
                additionnal_query_result = mp_database->query(sqlQuery.c_str());
                if (additionnal_query_result.empty())
                {
                    onError(); //database is not well populated
                    //todo something with table ?
                }
                else
                {
                    additionnal_query_line = additionnal_query_result.at(0);
                    m_availableCategoryTable[index].icon = additionnal_query_line[0] + '.' + additionnal_query_line[1];
                }

                m_availableCategoryTable[index].name = query_line[1];

                // retrieve the associated attributes
                sqlQuery = SQL_REQUEST_GET_CATEGORY_ATTRIBUTES;
                strStream.str("");
                strStream << m_availableCategoryTable[index].id;
                sqlQuery += strStream.str();
                sqlQuery += ");";
                additionnal_query_result = mp_database->query(sqlQuery.c_str());
                if (additionnal_query_result.empty())
                {
                    onError(); //database is not well populated
                    //todo something with table ?
                }
                else
                {
                    for (sub_index = 0; sub_index <additionnal_query_result.size(); sub_index++)
                    {
                        additionnal_query_line = additionnal_query_result.at(sub_index);
                        fromString<ushort>(attribute.id,additionnal_query_line[0], std::dec);
                        attribute.name = additionnal_query_line[1];
                        attribute.isSearched = false;
                        m_availableCategoryTable[index].attributeList.push_back(attribute);
                    }
                }
                m_availableCategoryTable[index].top_level = true; //this POC only manages predefined categories
                m_availableCategoryTable[index].isSearch = false; //for the moment no categories selected
            }            
        }

        //retrieve the parents of the categories
        //root category is the only one that is its own parent
        for (index = 0; index < m_availableCategories; index++)
        {
            sqlQuery = SQL_REQUEST_GET_PARENT_CATEGORIES;
            strStream.str("");
            strStream << m_availableCategoryTable[index].id;
            sqlQuery += strStream.str();
            sqlQuery += ";";
            query_result = mp_database->query(sqlQuery.c_str());
            if (query_result.empty())
            {
                onError(); //database is not well populated
                //todo something with table ?
            }
            else
            {
                for (parent=0;parent<query_result.size();parent++)
                {
                    query_line = query_result.at(parent);
                    fromString<uint16_t>(value,query_line[0], std::dec);
                    if (index == value)
                        m_rootCategory = index; //child is parent, so it's the root
                    m_availableCategoryTable[index].parentList.push_back(value);
                }
            }
        }

        //retrieve the children of the categories
        for (index = 0; index < m_availableCategories; index++)
        {
            sqlQuery = SQL_REQUEST_GET_CHILD_CATEGORIES;
            strStream.str("");
            strStream << m_availableCategoryTable[index].id;
            sqlQuery += strStream.str();
            sqlQuery += ";";
            query_result = mp_database->query(sqlQuery.c_str());
            if (query_result.empty())
            {
                //no child
            }
            else
            {
                for (child=0;child<query_result.size();child++)
                {
                    query_line = query_result.at(child);
                    fromString<uint16_t>(value,query_line[0], std::dec);
                    m_availableCategoryTable[index].childList.push_back(value);
                }
            }
        }

        //retrieve the available area into the database
        query_result = mp_database->query(SQL_REQUEST_GET_AVAILABLE_AREA);
        if (query_result.empty())
        {
            onError(); //database is not well populated
            //todo something with table ?
        }
        else
        {
            // read the result of the query, for the moment only the first area !
            query_line = query_result.at(0);
            fromString<double>(m_leftBottomLocation.latitude,query_line[0], std::dec);
            fromString<double>(m_leftBottomLocation.longitude,query_line[1], std::dec);
            fromString<double>(m_rightTopLocation.latitude,query_line[2], std::dec);
            fromString<double>(m_rightTopLocation.longitude,query_line[3], std::dec);
        }
        m_centerLocation.latitude = 48.85792; //by default center of Paris
        m_centerLocation.longitude = 2.3383145;
        m_centerLocation.altitude = 0;
    }

poiSearchServer::~poiSearchServer()
    {
        delete mp_database;
    }

DBus_version::DBus_version_t poiSearchServer::GetVersion()
{
    return(m_version.getDBus());
}

void poiSearchServer::GetLanguage(std::string& languageCode, std::string& countryCode)
{
    // in fact only one language and one country available
    languageCode = m_languageCode;
    countryCode = m_countryCode;
}

void poiSearchServer::SetLanguage(const std::string& languageCode, const std::string& countryCode)
{
    m_languageCode = languageCode;
    m_countryCode = countryCode;
}

std::vector< ::DBus::Struct< uint16_t, bool > > poiSearchServer::ValidateCategories(const std::vector< uint16_t >& categories)
{
    std::vector< ::DBus::Struct< uint16_t, bool > > table;
    return(table);
}

std::vector< DBus_categoryIdName::DBus_categoryIdName_t > poiSearchServer::GetAvailableCategories()
{
    std::vector< DBus_categoryIdName::DBus_categoryIdName_t > return_value;
    std::vector< DBus_categoryIdName::DBus_categoryIdName_t > categoryCAMList;
    DBus_categoryIdName::categoryIdName_t category;
    DBus_categoryIdName cat;
    uint16_t index;
    cam_t cam;

    // load categories from the embedded database
    for (index = 0; index < m_availableCategories; index++)
    {
        category.id.id = m_availableCategoryTable[index].id;
        category.id.top_level = m_availableCategoryTable[index].top_level;
        category.name = m_availableCategoryTable[index].name;
        cat.set(category);
        return_value.push_back(cat.getDBus());
    }

    // load categories from the additional database
    if (mp_poiContentAccess->GetRegisteredContentAccessModule(&cam))
    {
        if (mp_poiContentAccess->GetRegisteredCategories(cam.id,&categoryCAMList) == true)
        {
            return_value.insert(return_value.end(),categoryCAMList.begin(),categoryCAMList.end());
        }
    }

    return (return_value);
}

uint16_t poiSearchServer::GetRootCategory()
{
    return(m_rootCategory);
}

std::vector< DBus_categoryId::DBus_categoryId_t > poiSearchServer::GetChildrenCategories(const uint16_t& category)
{
    std::vector< DBus_categoryId::DBus_categoryId_t > return_value;
    DBus_categoryId::categoryId_t child_category;
    DBus_categoryId child_cat;
    uint16_t index;
    return_value.clear();
    for (index=0;index<m_availableCategoryTable[category].childList.size();index++)
    {
        child_category.id = m_availableCategoryTable[category].childList[index];
        child_category.top_level = m_availableCategoryTable[child_category.id].top_level;
        child_cat.set(child_category);
        return_value.push_back(child_cat.getDBus());
    }
    return(return_value);
}

std::vector< DBus_categoryId::DBus_categoryId_t > poiSearchServer::GetParentCategories(const uint16_t& category)
{
    std::vector< DBus_categoryId::DBus_categoryId_t > return_value;
    DBus_categoryId::categoryId_t parent_category;
    DBus_categoryId parent_cat;
    uint16_t index;
    return_value.clear();
    for (index=0;index<m_availableCategoryTable[category].parentList.size();index++)
    {
        parent_category.id = m_availableCategoryTable[category].parentList[index];
        parent_category.top_level = m_availableCategoryTable[parent_category.id].top_level;
        parent_cat.set(parent_category);
        return_value.push_back(parent_cat.getDBus());
    }
    return(return_value);
}

std::vector< DBus_category::DBus_category_t > poiSearchServer::GetCategoriesDetails(const std::vector< uint16_t >& categories)
{
    std::vector<DBus_category::DBus_category_t > return_value;
    std::vector<DBus_category> categoryCAMList;
    DBus_category cat;
    DBus_category::category_t category;
    DBus_categoryDetails::categoryDetails_t categoryDetails;
    DBus_categoryOperator::categoryOperator_t categoryOperator;
    std::vector<DBus_categoryAttribute::categoryAttribute_t> categoryAttributeList;
    DBus_categoryAttribute::categoryAttribute_t categoryAttribute;
    std::vector<DBus_categorySortOption::categorySortOption_t> categorySortOptionList;;
    DBus_categorySortOption::categorySortOption_t categorySortOption;;
    size_t index,sub_index;
    uint16_t category_index;
    cam_t cam;

    // load categories details from the embedded database
    index=0;
    return_value.clear();
    while ((index<categories.size())&&(index < m_availableCategories))
    {
        if ( isCategoryAvailable(categories.at(index),&category_index) == true)
        { //category found into the embedded data!
            categoryDetails.id = m_availableCategoryTable[category_index].id;
            categoryDetails.parents_id.clear();

            for (sub_index=0;sub_index<m_availableCategoryTable[category_index].parentList.size();sub_index++)
            { //parents
                categoryDetails.parents_id.push_back(m_availableCategoryTable[category_index].parentList.at(sub_index));
            }
            categoryDetails.icons = m_availableCategoryTable[category_index].icon;
            categoryDetails.name = m_availableCategoryTable[category_index].name;
            categoryDetails.top_level = m_availableCategoryTable[category_index].top_level;
            categoryDetails.description = "no description available";
            categoryDetails.media = "no media";
            categoryAttributeList.clear();
            //scan the attributes
            for (sub_index=0;sub_index<m_availableCategoryTable[category_index].attributeList.size();sub_index++)
            {
                categoryAttribute.name = (m_availableCategoryTable[category_index].attributeList.at(sub_index)).name;
                categoryAttribute.type = 0;
                categoryAttribute.oper.clear();
                categoryOperator.id = GENIVI_POISERVICE_EQUAL;
                categoryOperator.name = "EQUAL";
                categoryAttribute.oper.push_back(categoryOperator);
                categoryAttributeList.push_back(categoryAttribute);
            }

            categorySortOptionList.clear();
            categorySortOption.id = GENIVI_POISERVICE_SORT_DEFAULT;
            categorySortOption.name = "DEFAULT";
            categorySortOptionList.push_back(categorySortOption);

            category.details = categoryDetails;
            category.attributes = categoryAttributeList;
            category.sortOptions = categorySortOptionList;
            cat.set(category);
            return_value.push_back(cat.getDBus());
        }
        index++;
    }

    // load categories details from the additional database
    if (mp_poiContentAccess->GetRegisteredContentAccessModule(&cam))
    {
        categoryCAMList.clear();
        if (mp_poiContentAccess->GetRegisteredCategoriesDetails(cam.id,&categoryCAMList) == true)
        {
            for (index=0;index<categoryCAMList.size();index++)
                return_value.push_back((categoryCAMList.at(index)).getDBus());
        }
    }

    return (return_value);
}

uint8_t poiSearchServer::CreatePoiSearchHandle()
{
    // the POC is limited to the management of one handle !
    if (m_poiSearchHandle != INVALID_HANDLE)
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        m_poiSearchHandle = VALID_HANDLE;
        //set the handle for the content access server
        mp_poiContentAccess->SetPoiSearchHandle(m_poiSearchHandle);
        //set the language used by the content access server
         mp_poiContentAccess->SetLanguage(m_languageCode,m_countryCode);
    }
    return (m_poiSearchHandle);
}

void poiSearchServer::DeletePoiSearchHandle(const uint8_t& poiSearchHandle)
{
    cam_t cam;
    bool reply;
    if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
   {
        m_poiSearchHandle = INVALID_HANDLE;
        reply = mp_poiContentAccess->GetRegisteredContentAccessModule(&cam);
        if (reply == true)
        {
             //reset the handle
             mp_poiContentAccess->ResetPoiSearchHandle();
        }

    }
}

void poiSearchServer::SetRouteHandle(const uint8_t& poiSearchHandle, const uint8_t& sessionHandle, const uint8_t& routeHandle, const uint16_t& startSearchOffset, const uint16_t& endSearchOffset)
{
    uint32_t index;
    int16_t detailLevel;
    std::vector< uint16_t > valuesToReturn;
    uint32_t numberOfSegments;
    uint32_t offset;
    uint32_t totalNumberOfSegments;
    std::vector< std::map< uint16_t, ::DBus::Variant > > routeSegments;
    std::map< uint16_t, ::DBus::Variant > element;
    std::map< uint16_t, ::DBus::Variant >::iterator iter;
    route_vector_t routeVector;

    if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        m_sessionHandle = sessionHandle;
        m_routeHandle = routeHandle;
        m_startSearchOffset = startSearchOffset;
        m_endSearchOffset = endSearchOffset;

        //Get the route segments
        m_route.clear(); //clear the existing route
        detailLevel = 0; //to be clarified
        valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_START_LATITUDE);
        valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_END_LATITUDE);
        valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_START_LONGITUDE);
        valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_END_LONGITUDE);
        offset = 0;

        //First get the total amount of segments
        numberOfSegments = 0;

        mp_Routing->GetRouteSegments(m_routeHandle,detailLevel,valuesToReturn,numberOfSegments,offset,totalNumberOfSegments,routeSegments);
        m_totalNumberOfSegments = totalNumberOfSegments;

        // Get all the segments
        numberOfSegments = m_totalNumberOfSegments;
        mp_Routing->GetRouteSegments(m_routeHandle,detailLevel,valuesToReturn,numberOfSegments,offset,totalNumberOfSegments,routeSegments);
        for (index=0;index<routeSegments.size();index++)
        {
            element = routeSegments.at(index);
            iter = element.find(GENIVI_NAVIGATIONCORE_START_LATITUDE);
            if (iter != element.end())
                routeVector.startPoint.latitude = element.at(GENIVI_NAVIGATIONCORE_START_LATITUDE);
            iter = element.find(GENIVI_NAVIGATIONCORE_START_LONGITUDE);
            if (iter != element.end())
                routeVector.startPoint.longitude = element.at(GENIVI_NAVIGATIONCORE_START_LONGITUDE);
            iter = element.find(GENIVI_NAVIGATIONCORE_END_LATITUDE);
            if (iter != element.end())
                routeVector.endPoint.latitude = element.at(GENIVI_NAVIGATIONCORE_END_LATITUDE);
            iter = element.find(GENIVI_NAVIGATIONCORE_END_LONGITUDE);
            if (iter != element.end())
                routeVector.endPoint.longitude = element.at(GENIVI_NAVIGATIONCORE_END_LONGITUDE);
            m_route.push_back(routeVector);
        }
    }
}

void poiSearchServer::SetCategories(const uint8_t& poiSearchHandle, const std::vector< DBus_categoryRadius::DBus_categoryRadius_t >& poiCategories)
{
    uint16_t index;
    uint16_t category_index;
    cam_t cam;
    DBus_categoryRadius catRad;
    DBus_categoryRadius::categoryRadius_t categoryRadius;

    if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        //reset of the flags of the categories into the embedded database
        for (index=0;index<m_availableCategories;index++)
        {
            m_availableCategoryTable[index].isSearch = false;
        }

        //reset the flags of the categories into the additional database
       if ((mp_poiContentAccess->GetRegisteredContentAccessModule(&cam)) == true)
       {
           mp_poiContentAccess->ResetRegisteredSearchCategoriesFlags(cam.id);
       }

        for (index=0; index < poiCategories.size();index++)
        {
            catRad.setDBus(poiCategories.at(index));
            categoryRadius = catRad.get();
            if ( isCategoryAvailable(categoryRadius.id,&category_index) == true)
            { //category found into the embedded data !
                m_availableCategoryTable[category_index].isSearch = true;
                m_availableCategoryTable[category_index].radius = (categoryRadius.radius)*10; //get the radius (unit is 10 m)
                m_availableCategoryTable[category_index].angle = calculateAngle(m_availableCategoryTable[category_index].radius);
            }
            else
            {
                if ((mp_poiContentAccess->GetRegisteredContentAccessModule(&cam)) == true)
                {
                    mp_poiContentAccess->SetRegisteredSearchCategory(cam.id,categoryRadius);
                }
            }
        }
    }
}

void poiSearchServer::SetAttributes(const uint8_t& poiSearchHandle, const std::vector< DBus_attributeDetails::DBus_attributeDetails_t >& poiAttributes)
{
    DBus_attributeDetails attribDet;
    DBus_attributeDetails::attributeDetails_t attributeDetails;
    size_t index,sub_index;
    uint16_t category_index;
    cam_t cam;

    if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        //reset flags for all the attributes of the categories into the embedded database
        for (index=0;index<m_availableCategories;index++)
        {
            for (category_index=0;category_index<((m_availableCategoryTable[index]).attributeList).size();category_index++)
                (m_availableCategoryTable[index]).attributeList.at(category_index).isSearched =false;
        }

        //reset the flags of all the attributes of the categories into the additional database
        if ((mp_poiContentAccess->GetRegisteredContentAccessModule(&cam)) == true)
        {
           mp_poiContentAccess->ResetRegisteredAttributeCategoriesFlags(cam.id);
        }

        //set the flags of attributes to be searched for the given categories
        for (index=0;index<poiAttributes.size();index++)
        {
            attribDet.setDBus(poiAttributes[index]);
            attributeDetails = attribDet.get(); //get the attribute in readable format
            if ( isCategoryAvailable(attributeDetails.poiCategory,&category_index) == true)
            { //category found into the embedded database!
                for (sub_index=0;sub_index<(m_availableCategoryTable[category_index].attributeList.size());sub_index++)
                { //check attribute by name
                    if ((m_availableCategoryTable[category_index].attributeList.at(sub_index)).name == attributeDetails.attribute.name)
                        (m_availableCategoryTable[category_index].attributeList.at(sub_index)).isSearched =true;
                }
            }
            else
            { //set the flags of attributes to be searched into the additional database
                if ((mp_poiContentAccess->GetRegisteredContentAccessModule(&cam)) == true)
                {
                    mp_poiContentAccess->SetRegisteredAttributeCategoryFlag(cam.id,attributeDetails.poiCategory,attributeDetails.attribute.name,attributeDetails.id);
                }
            }
        }
    }
}

void poiSearchServer::StartPoiSearch(const uint8_t& poiSearchHandle, const std::string& inputString, const uint16_t& sortOption)
{

    if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        m_totalSize = 0;
        if (m_poiSearchProximity == false)
        { //no proximity search started on this session !
            m_searchStatus = GENIVI_POISERVICE_SEARCHING;
            PoiStatus(poiSearchHandle,(uint16_t)m_searchStatus);
            //sortOption is not used yet
            //for the moment, no thread used, because just one handle managed
            // search on the embedded database first
            m_totalSize = searchAroundALocation(m_centerLocation,&inputString); //search around the current location of the vehicle
            //and now search on the additional database if the cam has been registered before the creation of the poi search handle
            m_totalSize += mp_poiContentAccess->searchAroundALocation(m_centerLocation,&inputString,sortOption);
            m_searchStatus = GENIVI_POISERVICE_FINISHED;
            PoiStatus(poiSearchHandle,(uint16_t)m_searchStatus);
            ResultListChanged(poiSearchHandle,m_totalSize);
        }
    }
}

void poiSearchServer::CancelPoiSearch(const uint8_t& poiSearchHandle)
{
    if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        if (m_poiSearchProximity == false)
        { //no proximity search started on this session !
            m_searchStatus = GENIVI_POISERVICE_NOT_STARTED;
            PoiStatus(poiSearchHandle,(uint16_t)m_searchStatus);
        }
    }
}

void poiSearchServer::SetCenter(const uint8_t& poiSearchHandle, const DBus_geoCoordinate3D::DBus_geoCoordinate3D_t& location)
{
    DBus_geoCoordinate3D geoCoord;

    if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        geoCoord.setDBus(location);
        m_centerLocation = geoCoord.get();
    }
}

void poiSearchServer::StartPoiProximityAlert(const uint8_t& poiSearchHandle, const std::string& inputString, const uint16_t& sortOption)
{
    if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        if (m_poiSearchProximity == false)
        {
            m_poiSearchProximity = true; //start proximity search !
            m_searchStatus = GENIVI_POISERVICE_SEARCHING;
            PoiStatus(poiSearchHandle,(uint16_t)m_searchStatus);
        }
    }
}

void poiSearchServer::CancelPoiProximityAlert(const uint8_t& poiSearchHandle)
{
    if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        if (m_poiSearchProximity == true)
        {
            m_poiSearchProximity = false; //stop proximity search !
            m_searchStatus = GENIVI_POISERVICE_NOT_STARTED;
            PoiStatus(poiSearchHandle,(uint16_t)m_searchStatus);
        }
    }
}

void poiSearchServer::RequestResultList(const uint8_t& poiSearchHandle, const uint16_t& offset, const uint16_t& maxWindowSize, const std::vector< std::string >& attributes, uint16_t& statusValue, uint16_t& resultListSize, std::vector< DBus_searchResult::DBus_searchResult_t >& resultListWindow)
{
    DBus_searchResult::searchResult_t element; //id distance status attributes[]
    DBus_searchResult el;
    DBus_poiCAMDetails::poiCAMDetails_t camElement; //id name category location distance attributes[]
    DBus_poiCAMDetails camEl;
    DBus_poiAttribute::poiAttribute_t attribute; //name type value
    uint16_t index,size,sub_index;
    size_t attribute_index;
    poi_t poi;
    std::ostringstream  strStream; //temporary stream used for transformation into string

    if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        statusValue = m_searchStatus;
        if (m_searchStatus == GENIVI_POISERVICE_FINISHED)
        { //consider that the search is finished for the CAM too

            if ((offset+1)>m_totalSize)
                index=0;
            else
                index=offset;
            if ((index+maxWindowSize)>m_totalSize)
                size=m_totalSize-index;
            else
                size=maxWindowSize;
            resultListSize = size;

            while (size>0)
            { //load the poi into the vector
                if ((index+1)>m_poiTable.size())
                {
                    //no more data into the embedded table, so pick data from the additional table
                    camEl.setDBus(mp_poiContentAccess->GetResultPoi(index-m_poiTable.size()));
                    camElement = camEl.get();
                    element.id = camElement.source_id; //id
                    element.distance = camElement.distance; //distance
                    element.route_status = GENIVI_POISERVICE_OFF_ROUTE;
                    element.attributes.clear(); //clean list of attributes
                    for (sub_index=0;sub_index<camElement.attributes.size();sub_index++)
                    { //need to be improved here, no management of different types of value, by default set to string
                        attribute.name = (camElement.attributes.at(sub_index)).name; //name
                        attribute.type= (camElement.attributes.at(sub_index)).type;
                        attribute.value = (camElement.attributes.at(sub_index)).value;
                        element.attributes.push_back(attribute);
                    }
                    el.set(element);
                    resultListWindow.push_back(el.getDBus());
                    index++;
                    size-=1;
                }
                else
                { // pick data from the embedded table
                    poi = m_poiTable.at(index);
                    element.id = poi.segment;
                    element.distance = poi.distance;
                    element.route_status = GENIVI_POISERVICE_OFF_ROUTE;
                    element.attributes.clear(); //clean list of attributes

                    for (attribute_index=0;attribute_index<m_availableCategoryTable[poi.categoryIndex].attributeList.size();attribute_index++)
                    { //scan the attributes for the category
                        if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_SOURCE)
                        {
                            attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                            if (isAttributeRequired(attribute.name,attributes)==true)
                            {
                                attribute.type = GENIVI_POISERVICE_STRING;
                                attribute.value = poi.source;
                                element.attributes.push_back(attribute);
                            }
                        }
                        else
                        {
                            if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_WEBSITE)
                            {
                                attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                if (isAttributeRequired(attribute.name,attributes)==true)
                                {
                                    attribute.type = GENIVI_POISERVICE_STRING;
                                    attribute.value = poi.website;
                                    element.attributes.push_back(attribute);
                                }
                            }
                            else
                            {
                                if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_PHONE)
                                {
                                    attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                    if (isAttributeRequired(attribute.name,attributes)==true)
                                    {
                                        attribute.type = GENIVI_POISERVICE_STRING;
                                        attribute.value = poi.phone;
                                        element.attributes.push_back(attribute);
                                    }
                                }
                                else
                                {
                                    if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_STARS)
                                    {
                                        attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                        if (isAttributeRequired(attribute.name,attributes)==true)
                                        {
                                            attribute.type = GENIVI_POISERVICE_INTEGER;
                                            strStream.str("");
                                            strStream << poi.stars;
                                            attribute.value = strStream.str();
                                            element.attributes.push_back(attribute);
                                        }
                                    }
                                    else
                                    {
                                        if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_OPENINGHOURS)
                                        {
                                            attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                            if (isAttributeRequired(attribute.name,attributes)==true)
                                            {
                                                attribute.type = GENIVI_POISERVICE_STRING;
                                                attribute.value = poi.openinghours;
                                                element.attributes.push_back(attribute);
                                            }
                                        }
                                        else
                                        {
                                            if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRHOUSENUMBER)
                                            {
                                                attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                                if (isAttributeRequired(attribute.name,attributes)==true)
                                                {
                                                    attribute.type = GENIVI_POISERVICE_STRING;
                                                    attribute.value = poi.addr_house_number;
                                                    element.attributes.push_back(attribute);
                                                }
                                            }
                                            else
                                            {
                                                if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRSTREET)
                                                {
                                                    attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                                    if (isAttributeRequired(attribute.name,attributes)==true)
                                                    {
                                                        attribute.type = GENIVI_POISERVICE_STRING;
                                                        attribute.value = poi.addr_street;
                                                        element.attributes.push_back(attribute);
                                                    }
                                                }
                                                else
                                                {
                                                    if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRPOSTCODE)
                                                    {
                                                        attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                                        if (isAttributeRequired(attribute.name,attributes)==true)
                                                        {
                                                            attribute.type = GENIVI_POISERVICE_INTEGER;
                                                            strStream.str("");
                                                            strStream << poi.addr_postcode;
                                                            attribute.value = strStream.str();                                                            element.attributes.push_back(attribute);
                                                        }
                                                    }
                                                    else
                                                    {
                                                        if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRCITY)
                                                        {
                                                            attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                                            if (isAttributeRequired(attribute.name,attributes)==true)
                                                            {
                                                                attribute.type = GENIVI_POISERVICE_STRING;
                                                                attribute.value = poi.addr_city;
                                                                element.attributes.push_back(attribute);
                                                            }
                                                        }
                                                        else
                                                        {
                                                            if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_BRAND)
                                                            {
                                                                attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                                                if (isAttributeRequired(attribute.name,attributes)==true)
                                                                {
                                                                    attribute.type = GENIVI_POISERVICE_STRING;
                                                                    attribute.value = poi.brand;
                                                                    element.attributes.push_back(attribute);
                                                                }
                                                            }
                                                            else
                                                            {
                                                                if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_OPERATEUR)
                                                                {
                                                                    attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                                                    if (isAttributeRequired(attribute.name,attributes)==true)
                                                                    {
                                                                        attribute.type = GENIVI_POISERVICE_STRING;
                                                                        attribute.value = poi.operateur;
                                                                        element.attributes.push_back(attribute);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    el.set(element);
                    resultListWindow.push_back(el.getDBus());
                    index++;
                    size-=1;
                }
            }
        }        
    }
}

std::vector< DBus_searchResultDetails::DBus_searchResultDetails_t > poiSearchServer::GetPoiDetails(const std::vector< uint32_t >& id)
{
    std::vector< DBus_searchResultDetails::DBus_searchResultDetails_t > return_value;
    DBus_searchResultDetails searchResDet;
    DBus_searchResultDetails::searchResultDetails_t searchResDetails;
    DBus_poiAttribute::poiAttribute_t attribute;
    uint16_t indexPOIList,indexIDList;
    size_t attribute_index;
    poi_t poi;
    bool isPOIFound;
    std::ostringstream  strStream; //temporary stream used for transformation into string

    //for the moment, no optimization so it needs to be improved a little :-)

    for (indexIDList=0;indexIDList<id.size();indexIDList++)
    { //scan the list of poi to detail
        isPOIFound = false;

        //scan the embedded table
        //'while' first because the table could be empty in case of additional data only !
        indexPOIList=0;
        while((isPOIFound == false) && (indexPOIList<m_poiTable.size()))
        {
            poi = m_poiTable.at(indexPOIList);
            if (poi.segment == id.at(indexIDList))
            {
                isPOIFound = true;
                searchResDetails.details.id = poi.segment;
                searchResDetails.details.name = poi.name;
                searchResDetails.details.latitude = poi.coordinate.latitude;
                searchResDetails.details.longitude = poi.coordinate.longitude;
                searchResDetails.details.altitude = poi.coordinate.altitude;
                searchResDetails.categories.clear();
                searchResDetails.categories.push_back(m_availableCategoryTable[poi.categoryIndex].id); //POI only owns to one category for the moment !
                searchResDetails.attributes.clear();

                // check the attributes for the category and get the value
                for (attribute_index=0;attribute_index<m_availableCategoryTable[poi.categoryIndex].attributeList.size();attribute_index++)
                { //scan the attributes for the category
                    if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_SOURCE)
                    {
                        attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                        attribute.type = GENIVI_POISERVICE_STRING;
                        attribute.value = poi.source;
                        searchResDetails.attributes.push_back(attribute);
                    }
                    else
                    {
                        if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_WEBSITE)
                        {
                            attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                            attribute.type = GENIVI_POISERVICE_STRING;
                            attribute.value = poi.website;
                            searchResDetails.attributes.push_back(attribute);
                        }
                        else
                        {
                            if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_PHONE)
                            {
                                attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                attribute.type = GENIVI_POISERVICE_STRING;
                                attribute.value = poi.phone;
                                searchResDetails.attributes.push_back(attribute);
                            }
                            else
                            {
                                if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_STARS)
                                {
                                    attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                    attribute.type = GENIVI_POISERVICE_INTEGER;
                                    strStream.str("");
                                    strStream << poi.stars;
                                    attribute.value = strStream.str();
                                    searchResDetails.attributes.push_back(attribute);
                                }
                                else
                                {
                                    if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_OPENINGHOURS)
                                    {
                                        attribute.name = (m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).name;
                                        attribute.type = GENIVI_POISERVICE_STRING;
                                        attribute.value = poi.openinghours;
                                        searchResDetails.attributes.push_back(attribute);
                                    }
                                }
                            }
                        }
                    }
                }

                searchResDet.set(searchResDetails);
                return_value.push_back(searchResDet.getDBus());
            }
            else
                ++indexPOIList;
        }

        if (isPOIFound == false)
        {
            //not found in embedded table, so get it into  the additional data
            //we consider that the element exists into the additional data (no check)
            return_value.push_back(mp_poiContentAccess->GetPoiDetails(id.at(indexIDList)));
        }
    }

    return (return_value);
}

// Specific methods

void poiSearchServer::ConnectToEnhancedPositionClient(EnhancedPosition *client)
{
    mp_enhancedPosition = client; //link to the instance of enhancedPosition
}

void poiSearchServer::ConnectToRoutingClient(Routing *client)
{
    mp_Routing = client; //link to the instance of routing
}

DBus::Variant poiSearchServer::createVariantString(std::string str)
{
    DBus::Variant var;
    DBus::MessageIter iter = var.writer();
    iter.append_string(str.c_str());
    return var;
}

DBus::Variant poiSearchServer::createVariantUint16(uint16_t value)
{
    DBus::Variant var;
    DBus::MessageIter iter = var.writer();
    iter.append_uint16(value);
    return var;
}

void poiSearchServer::sendDBusError(const char* message)
{
    throw DBus::ErrorFailed(message);
}

void poiSearchServer::onError()
{
}

uint16_t poiSearchServer::searchAroundALocation(DBus_geoCoordinate3D::geoCoordinate3D_t location,const std::string* inputString)
{
    uint16_t index, all_categories_index;
    uint16_t total_size;
    DBus_geoCoordinate3D::geoCoordinate3D_t left_bottom_location,right_top_location;

    total_size = 0;

    m_poiTable.clear(); //clean the table of poi

    if (isAllCategoriesSelected(&all_categories_index))
    {
        left_bottom_location.latitude = location.latitude - m_availableCategoryTable[all_categories_index].angle;
        left_bottom_location.longitude = location.longitude - m_availableCategoryTable[all_categories_index].angle;
        right_top_location.latitude = location.latitude + m_availableCategoryTable[all_categories_index].angle;
        right_top_location.longitude = location.longitude + m_availableCategoryTable[all_categories_index].angle;
        for (index=0;index<m_availableCategories;index++)
        {
            total_size += searchPOIRequest(index, *inputString,left_bottom_location,right_top_location);
        }
    }
    else
    {
        for (index=0;index<m_availableCategories;index++)
        {
            if (m_availableCategoryTable[index].isSearch)
            {
                left_bottom_location.latitude = location.latitude - m_availableCategoryTable[index].angle;
                left_bottom_location.longitude = location.longitude - m_availableCategoryTable[index].angle;
                right_top_location.latitude = location.latitude + m_availableCategoryTable[index].angle;
                right_top_location.longitude = location.longitude + m_availableCategoryTable[index].angle;
                total_size += searchPOIRequest(index, *inputString,left_bottom_location,right_top_location);
            }
        }

    }
    return(total_size);
}

uint16_t poiSearchServer::searchPOIRequest(uint16_t categoryIndex, std::string search_string, DBus_geoCoordinate3D::geoCoordinate3D_t left_bottom_location,DBus_geoCoordinate3D::geoCoordinate3D_t right_top_location)
{
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > sqlQueryResult; //result of the query on database
    vector<string>  sqlQueryLine;
    std::ostringstream  strStream; //temporary stream used for transformation into string
    size_t index,sub_index,attribute_index;
    poi_t poi;
    std::string name;

    name = m_availableCategoryTable[categoryIndex].name;

    sqlQuery = "SELECT name,segment,latitude,longitude,altitude";

    for (attribute_index=0;attribute_index<m_availableCategoryTable[categoryIndex].attributeList.size();attribute_index++)
    {
        if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).isSearched == true)
        {
            sqlQuery += ",";
            sqlQuery += (m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).name;
        }

    }
    sqlQuery += " FROM poi WHERE (Id IN (SELECT poi_Id FROM belongsto,poicategory WHERE (belongsto.poicategory_Id = poicategory.Id) AND (poicategory.name = '";
    sqlQuery += name;
    sqlQuery += "'))) AND ((latitude > ";
    strStream.str(""); //to clean before !
    strStream << left_bottom_location.latitude;
    sqlQuery += strStream.str();
    sqlQuery += ") AND (latitude < ";
    strStream.str(""); //to clean before !
    strStream << right_top_location.latitude;
    sqlQuery += strStream.str();
    sqlQuery += ")) AND ((longitude > ";
    strStream.str(""); //to clean before !
    strStream << left_bottom_location.longitude;
    sqlQuery += strStream.str();
    sqlQuery += ") AND (longitude < ";
    strStream.str(""); //to clean before !
    strStream << right_top_location.longitude;
    sqlQuery += strStream.str();
    sqlQuery += ")) AND (name LIKE '%";
    sqlQuery += search_string;
    sqlQuery += "%');";
    sqlQueryResult = mp_database->query(sqlQuery.c_str());

    //populate the table of poi
    poi.categoryIndex = categoryIndex;

    for (index=0;index<sqlQueryResult.size();index++)
    {
        sqlQueryLine = sqlQueryResult.at(index);
        poi.name = sqlQueryLine[0];
        fromString<uint64_t>(poi.segment,sqlQueryLine[1], std::dec);
        fromString<double>(poi.coordinate.latitude,sqlQueryLine[2], std::dec);
        fromString<double>(poi.coordinate.longitude,sqlQueryLine[3], std::dec);
        fromString<int>(poi.coordinate.altitude,sqlQueryLine[4], std::dec);
        sub_index = 5;

        for (attribute_index=0;attribute_index<m_availableCategoryTable[categoryIndex].attributeList.size();attribute_index++)
        {
            if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).isSearched == true)
            {
                if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_SOURCE)
                    poi.source = sqlQueryLine[sub_index];
                else
                    if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_WEBSITE)
                        poi.website = sqlQueryLine[sub_index];
                    else
                        if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_PHONE)
                            poi.phone = sqlQueryLine[sub_index];
                        else
                            if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_STARS)
                                fromString<uint16_t>(poi.stars,sqlQueryLine[sub_index], std::dec);
                            else
                                if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_OPENINGHOURS)
                                    poi.openinghours = sqlQueryLine[sub_index];
                                else
                                    if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRHOUSENUMBER)
                                        poi.addr_house_number = sqlQueryLine[sub_index];
                                    else
                                        if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRSTREET)
                                            poi.addr_street = sqlQueryLine[sub_index];
                                        else
                                            if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRPOSTCODE)
                                                fromString<uint16_t>(poi.addr_postcode,sqlQueryLine[sub_index], std::dec);
                                            else
                                                if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRCITY)
                                                    poi.addr_city = sqlQueryLine[sub_index];
                                                else
                                                    if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_BRAND)
                                                        poi.brand = sqlQueryLine[sub_index];
                                                    else
                                                        if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_OPERATEUR)
                                                            poi.operateur = sqlQueryLine[sub_index];
                sub_index++;
            }

        }

        //calculate distance from the center location
        poi.distance = calculateDistance(m_centerLocation,poi.coordinate);
        m_poiTable.push_back(poi);
    }

    return(sqlQueryResult.size());
}

bool poiSearchServer::isCategoryAvailable(uint16_t id, uint16_t *category_id)
{
    bool isFound = false;
    uint16_t index = 0;
    do
    {
        if (m_availableCategoryTable[index].id == id)
        {
            *category_id = index;
            isFound = true;
        }
        else
            ++index;
    } while ((isFound==false) && (index < m_availableCategories));

    return(isFound);
}

bool poiSearchServer::isAllCategoriesSelected(uint16_t* index)
{
    bool isSelected = false;
    *index = 0;
    do
    {
        if ((m_availableCategoryTable[*index].name == "all categories") && m_availableCategoryTable[*index].isSearch)
        {
            isSelected = true;
        }
        else
            *index += 1;
    } while ((isSelected==false) && (*index < m_availableCategories));

    return(isSelected);
}

bool poiSearchServer::isAttributeRequired(std::string attribute,std::vector<std::string> attributes)
{
    bool isRequired = false;
    size_t index;
    index=0;
    while((isRequired==false)&&(index < attributes.size()))
    {
        if (attributes.at(index) == attribute)
            isRequired = true;
        else
            index++;
    };

    return(isRequired);
}

uint32_t poiSearchServer::calculateDistance(const DBus_geoCoordinate3D::geoCoordinate3D_t origin, const DBus_geoCoordinate3D::geoCoordinate3D_t target)
{
    //this piece of software is based on an haversine formula given by:
    // - Doctors Rick and Peterson, The Math Forum
    // http://mathforum.org/dr.math/
    // haversine of angle A is (1-cos(A))/2 that is equal to sin^2(A/2)

    //earth is considered to be a perfect spĥere, in order to simplify calculation
    const double PI = 4.0*atan(1.0);
    const double earth=6378137; //IUGG value for the equatorial radius of the Earth in m
    DBus_geoCoordinate3D::geoCoordinate3D_t pointA, pointB;
    double buffer;

    pointA.latitude = origin.latitude * (PI/180);
    pointA.longitude = origin.longitude * (PI/180);
    pointB.latitude = target.latitude * (PI/180);
    pointB.longitude = target.longitude * (PI/180);

    buffer= pow(sin((pointA.latitude-pointB.latitude)/2.0),2.0)+cos(pointA.latitude)*cos(pointB.latitude)*pow(sin((pointA.longitude-pointB.longitude)/2),2);
    buffer = 2*atan2(sqrt(buffer),sqrt(1.0-buffer));
    buffer=earth*buffer;
    return ((uint32_t) buffer); //return distance in meters
}

double poiSearchServer::calculateAngle(const uint32_t radius)
{
    //N is the point on the sphere for the origin
    //M is a point of the sphere at the distance radius (NM = radius)
    //O is the center of the earth
    //ON=OM so the triangle is isosceles
    //alpha is the angle ON,OM
    //beta is the angle NM,NO
    //OM*sin(alpha)=NM*sin(beta)
    //alpha+beta+beta=PI (because of isoceles)
    //beta=(PI-alpha)/2
    //sin(beta) = cos(alpha/2)
    //sin(alpha)=2*sin(alpha/2)*cos(alpha/2)
    //alpha=2*arcsin(NM/(2*OM))

    //earth is considered to be a perfect spĥere, in order to simplify calculation
    const double PI = 4.0*atan(1.0);
    const double earth=6378137; //IUGG value for the equatorial radius of the Earth in m
    double angle;
    angle=2*asin(radius/(2*earth));
    angle = (angle*180)/PI; //in degrees
    return(angle);
}

bool poiSearchServer::calculateLineCoefficient(double* a,double* b,const DBus_geoCoordinate3D::geoCoordinate3D_t pointA,const DBus_geoCoordinate3D::geoCoordinate3D_t pointB)
{
   /* longitude on the x axis, latitude on the y axis
    * segment line y = a*x + b
    * pointA and pointB points of the segment
    * if xA is different of xB
    * a = (yA-yB)/(xA-xB)
    * b = (xA*yB - xB*yA)/(xA-xB)
    */
    if (pointA.longitude == pointB.longitude)
    { //equation x = constant
        *b = pointA.longitude; //constant into *b
        return(false);
    }
    else
    {
        *a = (pointA.latitude-pointB.latitude)/(pointA.longitude-pointB.longitude);
        *b = (pointA.longitude*pointB.latitude - pointB.longitude*pointA.latitude)/(pointA.longitude-pointB.longitude);
        return(true);
    }
}

/**
 * \fn double calculateOrthoDistance(const double a,const double b,const DBus_geoCoordinate3D::geoCoordinate3D_t pointP)
 * \brief calculate ortho distance between a point P and a line defined by the slope a and the y intercept b.
 *
 * \param  double a -slope
 * \param  double b -y intercept
 * \param  DBus_geoCoordinate3D::geoCoordinate3D_t pointP -point
 * \return uint32_t distance.
 */
uint32_t poiSearchServer::calculateOrthoDistance(const double a,const double b,const DBus_geoCoordinate3D::geoCoordinate3D_t pointP)
{
    /* longitude on the x axis, latitude on the y axis
     * segment line y = a*x + b
     * projection line y = c*x + d
     * pointP point and pointI ortho projection
     * ortho projection => c = (-1)/a
     * P point of projection line so yP = c*xP + d
     * => d = yP + xP/a
     * I point of segment and projection lines
     * so yI = a*xI  + b
     * and yI = c*xI + d
     * => xI = (d-b)/(a-c)
     * and yI = (a*d - b*c)/(a-c)
     * so xI = (a*yP + xP -a*b)/(1+a*a)
     * and yI = (a*a*yP + a*xP + b)/(1+a*a)
     * distance = sqrt((xP-xI)*(xP-xI) + (yP-yI)*(yP-yI))
     * distance = (a*xP - yP + b)/sqrt(1 + a*a)
     */
    return ((uint32_t)((a*pointP.longitude - pointP.latitude + b)/sqrt(1 + a*a)));
}


const char* program_name; //file to sink outputs

/**
 * \fn is_readable (const std::string & file)
 * \brief Check if file can be opened.
 *
 * \param  const std::string & file	-name of the file
 * \return true if file readable.
 */
bool is_readable( const std::string & file )
{
    std::ifstream fi( file.c_str() );
    return !fi.fail();
}

/**
 * \fn print_usage (FILE* stream, int exit_code)
 * \brief Display the available options.
 *
 * \param  const FILE* stream	-name of stream to use
 * \param  int exit_code	-exit code
 * \return void.
 */
void print_usage (FILE* stream, int exit_code)
{
  fprintf (stream, "Use: %s options [database]\n",program_name);
  fprintf (stream,
           " -h --help               Display this message.\n"
           " -f --file database   Open the database.\n");
  exit (exit_code);
}

/**
 * \fn int main (int  argc , char**  argv)
 * \brief POI Server  implements the component of POI Service "POISearch" that includes search and content access.
 *
 * \param  int  argc
 * \param  char**  argv
 * \return EXIT_SUCCESS, EXIT_FAILURE.
 */
int main(int  argc , char**  argv )
{
    GMainLoop * mainloop ;

    // Set the global C and C++ locale to the user-configured locale,
    // so we can use std::cout with UTF-8, via Glib::ustring, without exceptions.
    std::locale::global(std::locale(""));

    //index used for argument analysis
    int next_option;

    /* Valid letters for short options. */
    const char* const short_options = "hf:";
    /* Valid string for long options. */
    const struct option long_options[] = {
        { "help",     0, NULL, 'h' },
        { "file", 2, NULL, 'f' },
        { NULL,       0, NULL, 0   }   /* Always at the end of the table.  */
    };
    char* database_filename = NULL; //database filename passed as first argument
    program_name = argv[0];

    do {
        next_option = getopt_long (argc, argv, short_options,
                                  long_options, NULL);
        switch (next_option)
        {
        case 'h':   /* -h --help */
            print_usage (stdout, 0);
            break;
        case 'f':   /* -f --file database*/
            database_filename = argv[2];
            if (!is_readable(database_filename))
                print_usage (stderr, 1);
            else
            {
                // creating the dispatcher
                dispatcher = new DBus::Glib::BusDispatcher();
                DBus::default_dispatcher = dispatcher;
                dispatcher->attach(NULL);

                // create a connection on the session bus
                dbusConnection = new DBus::Connection(DBus::Connection::SessionBus());
                dbusConnection->setup(dispatcher);

                // create the server for poiContentAccess
                dbusConnection->request_name(poiContentAccess_SERVICE_NAME);
                serverpoiContentAccess=new poiContentAccessServer(*dbusConnection);

                // create the server for POISearch
                dbusConnection->request_name(poiSearch_SERVICE_NAME);
                serverPoiSearch=new poiSearchServer(*dbusConnection,database_filename,serverpoiContentAccess);

                // connect the serverPoiSearch to the serverpoiContentAccess
                serverpoiContentAccess->ConnectTopoiSearchServer(serverPoiSearch);

                // create a client for EnhancedPosition
                clientEnhancedPosition = new EnhancedPosition(*dbusConnection);

                // connect it to the POISearch server
                serverPoiSearch->ConnectToEnhancedPositionClient(clientEnhancedPosition);

                // create a client for Routing
                clientRouting = new Routing(*dbusConnection);

                // connect it to the POISearch server
                serverPoiSearch->ConnectToRoutingClient(clientRouting);

                // Create a new GMainLoop with default context and initial state of "not running "
                mainloop = g_main_loop_new (g_main_context_default() , FALSE );

                // Send a feedback to the user
                cout << "poi server started" << endl;

                // loop listening

                g_main_loop_run ( mainloop );

                // clean memory
                delete serverPoiSearch;
                delete serverpoiContentAccess;
                delete clientEnhancedPosition;
                delete clientRouting;
                delete dbusConnection;
                delete dispatcher;
            }
            break;
        case '?':   /* Invalid option. */
            print_usage (stderr, 1);
        case -1:    /* End of options.  */
            break;
        default:    /* Error  */
            print_usage (stderr, 1);
        }
    }
    while (next_option != -1);

    return EXIT_SUCCESS;
}
