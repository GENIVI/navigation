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

#include "poi-contentaccess-module-class.h"

#include <QApplication>
#include <QTranslator>
#include <QResource>
#include "mainwindow.h"

#include <QSettings>

static const char* contentAccessModule_SERVICE_NAME = "org.genivi.poiservice.POIContentAccessModule";
static const char* contentAccessModule_OBJECT_PATH = "/org/genivi/poiservice/POIContentAccessModule";
static const char* poiContentAccess_SERVICE_NAME = "org.genivi.poiservice.POIContentAccess";
static const char* poiContentAccess_OBJECT_PATH = "/org/genivi/poiservice/POIContentAccess";

// SQL requests
static const char* SQL_REQUEST_GET_AVAILABLE_CATEGORIES = "SELECT Id,name FROM poicategory WHERE Id IN (SELECT poicategory_Id FROM belongsto GROUP BY poicategory_Id);";
static const char* SQL_REQUEST_GET_VALIDATE_CATEGORIES = "SELECT Id,name FROM poicategory;";
static const char* SQL_REQUEST_GET_CATEGORY_ATTRIBUTES = "SELECT Id,name FROM poiattribute WHERE Id IN (SELECT poiattribute_Id FROM hasattribute WHERE poicategory_Id IS ";
static const char* SQL_REQUEST_GET_AVAILABLE_AREA = "SELECT leftlongitude,bottomlatitude,rightlongitude,toplatitude FROM availablearea;";
static const char* SQL_REQUEST_GET_PARENT_CATEGORIES = "SELECT parentId FROM poicategorykinship WHERE childId IS ";
static const char* SQL_REQUEST_GET_CHILD_CATEGORIES = "SELECT childId FROM poicategorykinship WHERE parentId IS ";
static const char* SQL_REQUEST_GET_CATEGORY_ICONS = "SELECT url,format FROM iconset WHERE Id IS (SELECT iconset_Id FROM isdisplayedas WHERE poicategory_Id IS  ";

// DBus instances
static DBus::Glib::BusDispatcher *dispatcher;
static DBus::Connection *dbusConnection;
static contentAccessModuleServer *servercontentAccessModule;
static poiContentAccess *clientpoiContentAccess;


// class  poiContentAccess

poiContentAccess::poiContentAccess(DBus::Connection &connection)
        : DBus::ObjectProxy(connection,poiContentAccess_OBJECT_PATH,poiContentAccess_SERVICE_NAME)
    {

    }

poiContentAccess::~poiContentAccess()
    {

    }

// class  contentAccessModuleServer

contentAccessModuleServer::contentAccessModuleServer(DBus::Connection &connection, const char* poiDatabaseFileName)
    : DBus::ObjectAdaptor(connection, contentAccessModule_OBJECT_PATH)
    {        
        std::string sqlQuery; //SQL request on database
        std::ostringstream  strStream; //temporary stream used for transformation into string
        vector<vector<string> > query_result, additionnal_query_result;
        vector<string>  query_line, additionnal_query_line;
        size_t index,sub_index;
        category_attribute_common_t attribute;
        categoryId_t value;
        categoryId_t parent,child;

        //version is hard coded
        DBus_version::version_t version;
        version.major = 1;
        version.minor = 0;
        version.micro = 0;
        version.date = "19-12-2012";
        m_version.set(version);

        // language code is hard coded
        m_languageCode = "eng";
        m_countryCode = "USA";
        m_scriptCode = "Latn";

        //status
        m_poiSearchHandle = INVALID_HANDLE;
        m_camId = INVALID_HANDLE;
        m_searchStatus = GENIVI_POISERVICE_NOT_STARTED;

        //database
        mp_database = new Database(poiDatabaseFileName);

        m_availableCategories = 0;

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
                fromString<categoryId_t>(value,query_line[0], std::dec);
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
                        fromString<attributeId_t>(attribute.id,additionnal_query_line[0], std::dec);
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
                    fromString<categoryId_t>(value,query_line[0], std::dec);
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
                    fromString<categoryId_t>(value,query_line[0], std::dec);
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

contentAccessModuleServer::~contentAccessModuleServer()
    {
        delete mp_database;
    }

DBus_version::DBus_version_t contentAccessModuleServer::GetVersion()
    {
        return(m_version.getDBus());
    }

void contentAccessModuleServer::SetLocale(const std::string& languageCode, const std::string& countryCode, const std::string &scriptCode)
    {
        m_languageCode = languageCode;
        m_countryCode = countryCode;
        m_scriptCode = scriptCode;
        mp_HMI->on_SetLocale(languageCode,countryCode,scriptCode);
    }

void contentAccessModuleServer::GetLocale(std::string& languageCode, std::string& countryCode, std::string& scriptCode)
{
    languageCode = m_languageCode;
    countryCode = m_countryCode;
    scriptCode = m_scriptCode;
}

std::vector< ::DBus::Struct< std::string, std::string , std::string> > contentAccessModuleServer::GetSupportedLocales()
{
    std::vector< ::DBus::Struct< std::string, std::string, std::string > > ret;
    ::DBus::Struct< std::string, std::string, std::string > en_US { "eng","USA", "Latn" };
    ::DBus::Struct< std::string, std::string, std::string > fr_FR { "fra","FRA", "Latn" };
    ret.push_back(en_US);
    ret.push_back(fr_FR);
    return ret;
}


void contentAccessModuleServer::PoiSearchStarted(const handleId_t& poiSearchHandle, const uint16_t& maxSize, const DBus_geoCoordinate3D::DBus_geoCoordinate3D_t& location, const std::vector< DBus_categoryRadius::DBus_categoryRadius_t >& poiCategories, const std::vector< DBus_attributeDetails::DBus_attributeDetails_t >& poiAttributes, const std::string& inputString, const uint16_t& sortOption)
    {
        uint16_t index,sub_index;
        categoryId_t category_index;
        bool isCategoryFound, isAttributeFound;
        DBus_attributeDetails attribDet;
        DBus_attributeDetails::attributeDetails_t attribDetails;
        DBus_geoCoordinate3D geoCoord;
        DBus_geoCoordinate3D::geoCoordinate3D_t geoCoordinate;
        DBus_categoryRadius catRad;
        DBus_categoryRadius::categoryRadius_t catRadius;

        //todo: limit the search to maxSize, manage sortOption

        if (m_poiSearchHandle != INVALID_HANDLE)
            // new search launched before end of the last one
            sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
        else
        {
            //preliminary reset of flags for categories
            for (index=0;index<m_availableCategories;index++)
            {
                m_availableCategoryTable[index].isSearch = false;
                //reset flags for all the attributes of the category
                for (category_index=0;category_index<((m_availableCategoryTable[index]).attributeList).size();category_index++)
                    (m_availableCategoryTable[index]).attributeList.at(category_index).isSearched =false;
            }

            //now scan the flags to set and set the flag into the m_availableCategoryTable
            for (index=0;index<poiCategories.size();index++)
            {
                catRad.setDBus(poiCategories.at(index));
                catRadius = catRad.get();
                sub_index = 0;
                isCategoryFound = false;
                do
                {
                    if (catRadius.id == (m_availableCategoryTable[sub_index].alias_id))
                    { //the content access server is using alias !
                        isCategoryFound = true;
                        m_availableCategoryTable[sub_index].isSearch = true;
                        m_availableCategoryTable[sub_index].radius = (catRadius.radius)*10; //get the radius (unit is 10 m)
                        m_availableCategoryTable[sub_index].angle = calculateAngle(m_availableCategoryTable[sub_index].radius);
                    }
                    else
                        ++sub_index;
                } while((isCategoryFound == false) && (sub_index<m_availableCategories));
            }

            //reset flags for all the attributes of the categories into the database
            for (index=0;index<m_availableCategories;index++)
            {
                for (category_index=0;category_index<((m_availableCategoryTable[index]).attributeList).size();category_index++)
                    (m_availableCategoryTable[index]).attributeList.at(category_index).isSearched =false;
            }

            //now scan the flags to be set
            for (index=0;index<poiAttributes.size();index++)
            {
                sub_index = 0;
                isAttributeFound = false;
                attribDet.setDBus(poiAttributes.at(index));
                attribDetails = attribDet.get();
                if ( isCategoryAvailable(attribDetails.categoryId,&category_index) == true)
                { //category found into the database!
                    if (m_availableCategoryTable[category_index].isSearch)
                    { //category selected for the search
                        for (sub_index=0;sub_index<(m_availableCategoryTable[category_index].attributeList.size());sub_index++)
                        { //check attribute by id
                            if ((m_availableCategoryTable[category_index].attributeList.at(sub_index)).id == attribDetails.attribute.id)
                                (m_availableCategoryTable[category_index].attributeList.at(sub_index)).isSearched =true;
                        }
                    }
                }
            }

            m_poiSearchHandle = poiSearchHandle;
            geoCoord.setDBus(location);
            geoCoordinate = geoCoord.get();
            m_centerLocation.latitude = geoCoordinate.latitude;
            m_centerLocation.longitude = geoCoordinate.longitude;
            m_centerLocation.altitude = geoCoordinate.altitude;
            m_searchStatus = GENIVI_POISERVICE_SEARCHING;
            //sortOption is not used
            //maxSize is not used
            m_totalSize = searchAroundALocation(m_centerLocation,&inputString);
            m_searchStatus = GENIVI_POISERVICE_FINISHED;
        }
    }

void contentAccessModuleServer::PoiSearchCanceled(const handleId_t& poiSearchHandle)
    {
        if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
            // try to cancel an unavailable handle
            sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
        else
        {
            m_poiSearchHandle = INVALID_HANDLE;
            m_totalSize = 0;
            m_poiTable.clear();
        }
    }

void contentAccessModuleServer::ResultListRequested(const camId_t& camId, const handleId_t& poiSearchHandle, const std::vector< attributeId_t >& attributes, uint16_t& statusValue, uint16_t& resultListSize, std::vector< DBus_poiCAMDetails::DBus_poiCAMDetails_t >& resultList)
    {

        //this method is supposed to check the camId, but into the POC, it's the HMI that declares the CAM (for the moment)

        //todo: manage attributes
        if ((m_poiSearchHandle == INVALID_HANDLE) || (poiSearchHandle != m_poiSearchHandle))
            // to do send an error message
            sendDBusError("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
        else
        {
            resultListSize = m_totalSize;
            resultList.insert(resultList.end(),m_poiTable.begin(),m_poiTable.end());
            statusValue = m_searchStatus;
            m_poiSearchHandle = INVALID_HANDLE; //search is considered to be finished ?
        }
    }

std::vector< DBus_searchResultDetails::DBus_searchResultDetails_t > contentAccessModuleServer::PoiDetailsRequested(const std::vector< poiId_t >& source_id)
    {
        std::vector< DBus_searchResultDetails::DBus_searchResultDetails_t >  return_value;
        DBus_searchResultDetails searchDet;
        DBus_searchResultDetails::searchResultDetails_t searchDetails;
        uint16_t index,indexPOIList;
        bool isPOIFound;

        return_value.clear();
        for (index=0;index<source_id.size();index++)
        { //scan the list of poi to detail
            isPOIFound = false;
            //scan the table
            indexPOIList=0;
            while((isPOIFound == false) && (indexPOIList<m_poiDetailsTable.size()))
            {
                searchDet.setDBus(m_poiDetailsTable.at(indexPOIList));
                searchDetails = searchDet.get();
                if (searchDetails.details.id == source_id.at(index))
                {
                    isPOIFound = true;
                    return_value.push_back(m_poiDetailsTable.at(indexPOIList));
                }
                else
                    ++indexPOIList;
            }
        }
        return (return_value);
    }

// Specific methods

DBus::Variant contentAccessModuleServer::createVariantString(std::string str)
{
    DBus::Variant var;
    DBus::MessageIter iter = var.writer();
    iter.append_string(str.c_str());
    return var;
}

DBus::Variant contentAccessModuleServer::createVariantUint16(uint16_t value)
{
    DBus::Variant var;
    DBus::MessageIter iter = var.writer();
    iter.append_uint16(value);
    return var;
}

void contentAccessModuleServer::connectToHMI(MainWindow *w)
{
    mp_HMI = w;
}

void contentAccessModuleServer::connectCAM(camId_t camId)
{
    m_camId = camId;
}

void contentAccessModuleServer::disconnectCAM()
{
    m_camId = INVALID_HANDLE;
}

std::vector<DBus_CAMcategory::DBus_CAMcategory_t> contentAccessModuleServer::getCategories()
{
    std::vector< DBus_CAMcategory::DBus_CAMcategory_t > return_value;
    DBus_CAMcategory CAMcat;
    DBus_CAMcategory::CAMcategory_t CAMCategory;
    DBus_categoryAttribute::categoryAttribute_t categoryAttribute;
    DBus_categoryOperator::categoryOperator_t categoryOperator;
    size_t index,sub_index;

    for (index=0;index<m_availableCategories;index++)
    {
        CAMCategory.details.name = m_availableCategoryTable[index].name;
        for (sub_index=0;sub_index<m_availableCategoryTable[index].parentList.size();sub_index++)
        {
            CAMCategory.details.parents_id.push_back(m_availableCategoryTable[index].parentList.at(sub_index));
        }
        CAMCategory.details.media = "";
        CAMCategory.details.icons = m_availableCategoryTable[index].icon;
        CAMCategory.details.short_desc = "";
        //scan the attributes
        CAMCategory.attributes.clear();
        for (sub_index=0;sub_index<m_availableCategoryTable[index].attributeList.size();sub_index++)
        {
            categoryAttribute.id = (m_availableCategoryTable[index].attributeList.at(sub_index)).id;
            categoryAttribute.name = (m_availableCategoryTable[index].attributeList.at(sub_index)).name;
            categoryAttribute.type = 0;
            categoryAttribute.oper.clear();
            categoryOperator.type = GENIVI_POISERVICE_EQUAL;
            categoryOperator.name = "EQUAL";
            categoryOperator.value = "";
            categoryAttribute.oper.push_back(categoryOperator);
            CAMCategory.attributes.push_back(categoryAttribute);
        }

        CAMcat.set(CAMCategory);
        return_value.push_back(CAMcat.getDBus());
    }

    return(return_value);
}

void contentAccessModuleServer::setCategoriesID(std::vector<categoryId_t> categoryIDList)
{
    size_t index;
    for (index=0;index<m_availableCategories;index++)
    { //consider the given ID are in the same order as the registered ones
        m_availableCategoryTable[index].alias_id = categoryIDList.at(index);
    }
}

std::string contentAccessModuleServer::getCAMName()
{
    std::string str = contentAccessModule_SERVICE_NAME;
    return(str);
}

camId_t contentAccessModuleServer::getCAMId()
{
    return(m_camId);
}

uint16_t contentAccessModuleServer::searchAroundALocation(DBus_geoCoordinate3D::geoCoordinate3D_t location,const std::string* inputString)
    {
        uint16_t index;
        uint16_t total_size;
        DBus_geoCoordinate3D::geoCoordinate3D_t left_bottom_location,right_top_location;

        total_size = 0;
        m_poiTable.clear(); //clean the table of poi

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

        return(total_size);
    }

uint16_t contentAccessModuleServer::searchPOIRequest(uint16_t categoryIndex, std::string search_string, DBus_geoCoordinate3D::geoCoordinate3D_t left_bottom_location,DBus_geoCoordinate3D::geoCoordinate3D_t right_top_location)
    {
        std::string sqlQuery; //SQL request on database
        vector<vector<string> > sqlQueryResult; //result of the query on database
        vector<string>  sqlQueryLine;
        std::ostringstream  strStream; //temporary stream used for transformation into string
        size_t index,sub_index,attribute_index;
        DBus_poiCAMDetails poiCAMDet;
        DBus_poiCAMDetails::poiCAMDetails_t poi; //source_id, name, category, location, distance, attributes
        DBus_poiAttribute::poiAttribute_t  poiAttrib;
        DBus_searchResultDetails poiDet;
        DBus_searchResultDetails::searchResultDetails_t poiDetails; //details(unique id, name, lat, lon, alt), categories, attributes(name, type, value)
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

        //populate the tables of poi
        poi.category = categoryIndex; //category
        poiDetails.categories.push_back(m_availableCategoryTable[categoryIndex].alias_id); //categories for the table of details

        for (index=0;index<sqlQueryResult.size();index++)
        {
            sqlQueryLine = sqlQueryResult.at(index);
            fromString<poiId_t>(poi.source_id,sqlQueryLine[1], std::dec); //source_id
            fromString<poiId_t>(poiDetails.details.id,sqlQueryLine[1], std::dec); //source_id for the table of details
            poi.name = sqlQueryLine[0]; //name
            poiDetails.details.name = sqlQueryLine[0]; //name for the table of details
            fromString<double>(poi.location.latitude,sqlQueryLine[2], std::dec); //location lat
            fromString<double>(poi.location.longitude,sqlQueryLine[3], std::dec); //location lon
            fromString<int>(poi.location.altitude,sqlQueryLine[4], std::dec); //location alt

            fromString<double>(poiDetails.details.location.latitude,sqlQueryLine[2], std::dec); //location lat for the table of details
            fromString<double>(poiDetails.details.location.longitude,sqlQueryLine[3], std::dec); //location lon for the table of details
            fromString<int>(poiDetails.details.location.altitude,sqlQueryLine[4], std::dec); //location alt for the table of details

            sub_index = 5; //next index to scan into the query line
            for (attribute_index=0;attribute_index<m_availableCategoryTable[categoryIndex].attributeList.size();attribute_index++)
            {
                if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).isSearched == true)
                {
                    if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_SOURCE)
                    {
                        poiAttrib.id = (m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id;
                        poiAttrib.type = GENIVI_POISERVICE_STRING;
                        poiAttrib.value = sqlQueryLine[sub_index];
                        poi.attributes.push_back(poiAttrib);
                        poiDetails.attributes.push_back(poiAttrib); //for the table of details
                    }
                    else
                        if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_WEBSITE)
                        {
                            poiAttrib.id = (m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id;
                            poiAttrib.type = GENIVI_POISERVICE_STRING;
                            poiAttrib.value = sqlQueryLine[sub_index];
                            poi.attributes.push_back(poiAttrib);
                            poiDetails.attributes.push_back(poiAttrib); //for the table of details
                        }
                        else
                            if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_PHONE)
                            {
                                poiAttrib.id = (m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id;
                                poiAttrib.type = GENIVI_POISERVICE_STRING;
                                poiAttrib.value = sqlQueryLine[sub_index];
                                poi.attributes.push_back(poiAttrib);
                                poiDetails.attributes.push_back(poiAttrib); //for the table of details
                            }
                            else
                                if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_STARS)
                                {
                                    poiAttrib.id = (m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id;
                                    poiAttrib.type = GENIVI_POISERVICE_INTEGER;
                                    poiAttrib.value = sqlQueryLine[sub_index];
                                    poi.attributes.push_back(poiAttrib);
                                    poiDetails.attributes.push_back(poiAttrib); //for the table of details
                                }
                                else
                                    if ((m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_OPENINGHOURS)
                                    {
                                        poiAttrib.id = (m_availableCategoryTable[categoryIndex].attributeList.at(attribute_index)).id;
                                        poiAttrib.type = GENIVI_POISERVICE_STRING;
                                        poiAttrib.value = sqlQueryLine[sub_index];
                                        poi.attributes.push_back(poiAttrib);
                                        poiDetails.attributes.push_back(poiAttrib); //for the table of details
                                    }
                    sub_index++;
                }

            }

            //calculate distance from the center location
            poi.distance = calculateDistance(m_centerLocation,poi.location);
            poiCAMDet.set(poi);
            m_poiTable.push_back(poiCAMDet.getDBus());
            poiDet.set(poiDetails);
            m_poiDetailsTable.push_back(poiDet.getDBus());
        }

        return(sqlQueryResult.size());
    }

void contentAccessModuleServer::sendDBusError(const char* message)
    {
        throw DBus::ErrorFailed(message);
    }

void contentAccessModuleServer::onError()
{
}

bool contentAccessModuleServer::isCategoryAvailable(categoryId_t id, categoryId_t *category_id)
{
    bool isFound = false;
    uint16_t index = 0;
    do
    {
        if (m_availableCategoryTable[index].alias_id == id)
        {
            *category_id = index;
            isFound = true;
        }
        else
            ++index;
    } while ((isFound==false) && (index < m_availableCategories));

    return(isFound);
}

uint32_t contentAccessModuleServer::calculateDistance(const DBus_geoCoordinate3D::geoCoordinate3D_t origin, const DBus_geoCoordinate3D::geoCoordinate3D_t target)
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

double contentAccessModuleServer::calculateAngle(const uint32_t radius)
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
           " -f --file database      Open the database (by default language is english).\n"
           " -f --file database -i --internationalisation language(en,jp)    Open the database and set the language.\n");
  fprintf (stream, "Error code %d\n",exit_code);
  exit (exit_code);
}

/**
 * \fn int main (int  argc , char**  argv)
 * \brief POI Server which implements the components of POI Service (search, contentaccess and content access module).
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
    const char* const short_options = "hf:i:";
    /* Valid string for long options. */
    const struct option long_options[] = {
        { "help",     0, NULL, 'h' },
        { "file", 1, NULL, 'f' },
        { "internationalisation", 2, NULL, 'i' },
        { NULL,       0, NULL, 0   }   /* Always at the end of the table.  */
    };
    char* database_filename = NULL; //database filename
    QString language = "en"; //english by default

    program_name = argv[0];

    do {
        next_option = getopt_long (argc, argv, short_options,
                                  long_options, NULL);
        switch (next_option)
        {
        case 'h':   /* -h --help */
            print_usage (stdout, 0);
            break;
        case 'f':   /* -f --file database */
            database_filename = argv[2];
            if (!is_readable(database_filename))
                print_usage (stderr, 1);
            break;
        case 'i':   /* -i --internationalisation language */
            language = argv[4];
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

    QApplication a(argc, argv);
    QTranslator translator;
    if (QResource::registerResource("poi-client-resource.rcc","./"))
    {
        if (translator.load("poi-contentaccess-module_"+ language))
        {
            a.installTranslator(&translator);
            MainWindow mainWindow;

            // creating the dispatcher
            dispatcher = new DBus::Glib::BusDispatcher();
            DBus::default_dispatcher = dispatcher;
            dispatcher->attach(NULL);

            // create a connection on the session bus
            dbusConnection = new DBus::Connection(DBus::Connection::SessionBus());
            dbusConnection->setup(dispatcher);

            // create the server for contentAccessModule
            dbusConnection->request_name(contentAccessModule_SERVICE_NAME);
            servercontentAccessModule=new contentAccessModuleServer(*dbusConnection,database_filename);

            // connect it to the HMI panel
            mainWindow.ConnectTocontentAccessModuleServer(servercontentAccessModule);

            // connect the HMI panel to it
            servercontentAccessModule->connectToHMI(&mainWindow);

            // create a client for poiContentAccess
            clientpoiContentAccess = new poiContentAccess(*dbusConnection);

            // connect it to the HMI panel
            mainWindow.ConnectTopoiContentAccessClient(clientpoiContentAccess);

            // Create a new GMainLoop with default context and initial state of "not running "
            mainloop = g_main_loop_new (g_main_context_default() , FALSE );

           // loop listening
            mainWindow.InitUi();
            mainWindow.show();

            int ret = a.exec();

            // clean memory
            delete servercontentAccessModule;
            delete dbusConnection;
            delete dispatcher;
        }
        else
        {
            print_usage (stderr, 2);
        }
    }
    else
    {
        print_usage (stderr, 3);
    }
    return EXIT_SUCCESS;
}

