/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2015, PCA Peugeot Citroen
*
* \file poi-manager-server-stub.cpp
*
* \brief This file is part of the poi proof of concept.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 0.1
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License (MPL), v. 2.0.
* If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* For further information see http://www.genivi.org/.
*
* List of changes:
* <date>, <name>, <description of change>
*
* @licence end@
*/
#include "poi-manager-server-stub.h"

// SQL requests
const char SQL_REQUEST_GET_AVAILABLE_CATEGORIES[] = "SELECT Id,name FROM poicategory WHERE Id IN (SELECT poicategory_Id FROM belongsto GROUP BY poicategory_Id);";
const char SQL_REQUEST_GET_CATEGORY_ATTRIBUTES[] = "SELECT Id,name FROM poiattribute WHERE Id IN (SELECT poiattribute_Id FROM hasattribute WHERE poicategory_Id IS ";
static const char* SQL_REQUEST_GET_AVAILABLE_AREA = "SELECT leftlongitude,bottomlatitude,rightlongitude,toplatitude FROM availablearea;";
static const char* SQL_REQUEST_GET_PARENT_CATEGORIES = "SELECT parentId FROM poicategorykinship WHERE childId IS ";
static const char* SQL_REQUEST_GET_CHILD_CATEGORIES = "SELECT childId FROM poicategorykinship WHERE parentId IS ";
static const char* SQL_REQUEST_GET_CATEGORY_ICONS = "SELECT url,format FROM iconset WHERE Id IS (SELECT iconset_Id FROM isdisplayedas WHERE poicategory_Id IS  ";

// string conversion to numeric: the third parameter of fromString() should be one of std::hex, std::dec or std::oct
template <class T>
bool fromString(T& t, const std::string& s, std::ios_base& (*f)(std::ios_base&))
{
  std::istringstream iss(s);
  return !(iss >> f >> t).fail();
}


PoiManagerServerStub::PoiManagerServerStub() {
    m_version.versionMajor = 1;
    m_version.versionMicro = 0;
    m_version.versionMinor = 0;
    m_version.date = "19-13-2015";
    m_rootCategory = ALL_CATEGORIES; //by default
    m_languageCode = "eng";
    m_countryCode = "USA";
    m_scriptCode = "Latn";

}

PoiManagerServerStub::~PoiManagerServerStub() {
}

void PoiManagerServerStub::getVersion(const std::shared_ptr<CommonAPI::ClientId> clientId, NavigationTypes::Version& version)
{
    version = m_version;
}

void PoiManagerServerStub::setLocale(const std::shared_ptr<CommonAPI::ClientId> clientId, std::string languageCode, std::string countryCode, std::string scriptCode)
{
    m_languageCode = languageCode;
    m_countryCode = countryCode;
    m_scriptCode = scriptCode;
}

void PoiManagerServerStub::getLocale(const std::shared_ptr<CommonAPI::ClientId> clientId, std::string& languageCode, std::string& countryCode, std::string& scriptCode)
{
    languageCode = m_languageCode;
    countryCode = m_countryCode;
    scriptCode = m_scriptCode;
}

void PoiManagerServerStub::getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::Locales>& localeList)
{
    POIServiceTypes::Locales en_US { "eng","USA", "Latn" };
    POIServiceTypes::Locales fr_FR { "fra","FRA", "Latn" };
    localeList.push_back(en_US);
    localeList.push_back(fr_FR);
}

void PoiManagerServerStub::getAvailableCategories(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::CategoryAndName>& categories)
{
    POIServiceTypes::CategoryAndName category;
    uint16_t index;

    // load categories from the embedded database
    for (index = 0; index < m_availableCategories; index++)
    {
        category.uniqueId = m_availableCategoryTable[index].id;
        category.topLevel = m_availableCategoryTable[index].top_level;
        category.name = m_availableCategoryTable[index].name;
        categories.push_back(category);
    }

}


void PoiManagerServerStub::getRootCategory(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CategoryID& category)
{
    category = m_rootCategory;
}

bool PoiManagerServerStub::initDatabase(const char* poiDatabaseFileName)
{
    mp_database = new Database(poiDatabaseFileName);
    refreshCategoryList();
    return true; //maybe add some check of the file here
}

void PoiManagerServerStub::onError()
{

}

// refresh the buffer that contains the categories related data, called each time a category is added or removed
void PoiManagerServerStub::refreshCategoryList()
{
    std::string sqlQuery; //SQL request on database
    std::ostringstream  strStream; //temporary stream used for transformation into string
    vector<vector<string> > query_result, additionnal_query_result;
    vector<string >  query_line, additionnal_query_line;
    size_t index,sub_index;
    categoryId_t value;
    categoryId_t parent,child;
    category_attribute_common_t attribute;

    // retrieve the available categories (the ones that have at least one record)
    query_result = mp_database->queryNotUTF(SQL_REQUEST_GET_AVAILABLE_CATEGORIES);
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
            additionnal_query_result = mp_database->queryNotUTF(sqlQuery.c_str());
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
            additionnal_query_result = mp_database->queryNotUTF(sqlQuery.c_str());
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
        query_result = mp_database->queryNotUTF(sqlQuery.c_str());
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
        query_result = mp_database->queryNotUTF(sqlQuery.c_str());
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

}
