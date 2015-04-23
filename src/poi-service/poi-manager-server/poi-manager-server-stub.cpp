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



sqlRequest::sqlRequest()
{
}

sqlRequest::~sqlRequest()
{
    delete mp_database;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::setDatabase(const char *poiDatabaseFileName)
{
    mp_database = new Database(poiDatabaseFileName);
    return OK; //todo check if database OK
}

void sqlRequest::onError()
{

}

vector<poi_category_common_t> sqlRequest::getAvailableCategories(POIServiceTypes::CategoryID &rootCategory)
{
    std::string sqlQuery; //SQL request on database
    std::ostringstream  strStream; //temporary stream used for transformation into string
    vector<vector<string> > query_result, additionnal_query_result;
    vector<string >  query_line, additionnal_query_line;
    size_t index,sub_index;
    categoryId_t value;
    categoryId_t parent,child;
    category_attribute_common_t attribute;
    uint16_t availableCategories;
    vector<poi_category_common_t> availableCategoryTable;
    poi_category_common_t poiCategory;

    // retrieve the available categories (the ones that have at least one record)
    query_result = mp_database->queryNotUTF(m_SQL_REQUEST_GET_AVAILABLE_CATEGORIES);
    if (query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
    }
    else
    { // Id,name
        availableCategories = query_result.size(); //store the number of categories
        for (index = 0; index < availableCategories; index++)
        {
            // read the result of the query and store it
            query_line = query_result.at(index);
            fromString<categoryId_t>(value,query_line[0], std::dec);
            poiCategory.id = value;

            // retrieve the associated icons (for the moment, just one)
            sqlQuery = m_SQL_REQUEST_GET_CATEGORY_ICONS;
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
                poiCategory.icon = additionnal_query_line[0] + '.' + additionnal_query_line[1];
            }

            poiCategory.name = query_line[1];

            // retrieve the associated attributes
            sqlQuery = m_SQL_REQUEST_GET_CATEGORY_ATTRIBUTES;
            strStream.str("");
            strStream << poiCategory.id;
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
                    poiCategory.attributeList.push_back(attribute);
                }
            }
            poiCategory.top_level = true; //this POC only manages predefined categories
            poiCategory.isSearch = false; //for the moment no categories selected

            availableCategoryTable.push_back(poiCategory);
        }
    }

    //retrieve the parents of the categories
    //root category is the only one that is its own parent
    for (index = 0; index < availableCategories; index++)
    {
        sqlQuery = m_SQL_REQUEST_GET_PARENT_CATEGORIES;
        strStream.str("");
        strStream << availableCategoryTable.at(index).id;
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
                    rootCategory = index; //child is parent, so it's the root
                availableCategoryTable.at(index).parentList.push_back(value);
            }
        }
    }

    //retrieve the children of the categories
    for (index = 0; index < availableCategories; index++)
    {
        sqlQuery = m_SQL_REQUEST_GET_CHILD_CATEGORIES;
        strStream.str("");
        strStream << availableCategoryTable.at(index).id;
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
                availableCategoryTable.at(index).childList.push_back(value);
            }
        }
    }

    return availableCategoryTable;
}

void sqlRequest::getAvailableArea()
{
    vector<vector<string> > query_result;
    vector<string >  query_line;

    //retrieve the available area into the database
    query_result = mp_database->queryNotUTF(m_SQL_REQUEST_GET_AVAILABLE_AREA);
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
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::createCategory(POIServiceTypes::CAMCategory category, POIServiceTypes::CategoryID& unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    size_t index;
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result;
    vector<string >  query_line;
    std::ostringstream  strStream; //temporary stream used for transformation into string

    //Check if all the parent categories exist
    for (index=0;index < category.details.parentsId.size();index++)
    {
        ret = checkIfCategoryIdExist(category.details.parentsId.at(index));
        if (ret != OK)
            return ret;
    }

    //Check if the name doesn't exist into the database to avoid duplications
    ret = checkIfCategoryNameDoesntExist(category.details.name);
    if (ret != OK)
        return ret;

    //Get a free id (poicategory)
    ret = getFreeCategoryId(unique_id);
    if (ret != OK)
        return ret;

    //Create the category
    sqlQuery = m_SQL_REQUEST_INSERT_CATEGORY;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ",'";
    sqlQuery.append(category.details.name);
    sqlQuery += "');";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    //Check the attributes and complete the table if necessary (poiattribute)
    for (index=0;index < category.attributes.size();index++)
    {
        ret = checkIfAttributeExist((category.attributes.at(index)).id);
        if (ret == ATTRIBUTE_ID_NOT_EXIST)
        {
            //Create the attribute
            sqlQuery = m_SQL_REQUEST_INSERT_ATTRIBUTE;
            strStream.str("");
            strStream << (category.attributes.at(index)).id;
            sqlQuery += strStream.str();
            sqlQuery += ",'";
            sqlQuery.append((category.attributes.at(index)).name);
            sqlQuery += "');";
            query_result = mp_database->queryNotUTF(sqlQuery.c_str());
            if (!query_result.empty())
            {
                onError(); //database is not well populated
                //todo something with table ?
                ret = DATABASE_ACCESS_ERROR;
                return ret;
            }

        }
        else
        {
            if (ret != OK)
            return ret;
        }
    }

    //Complete the table of attributes for the category (hasattribute)

    //Complete the table of family categories (poicategorykinship)

    //Complete the table of icons (iconset and isdisplayedas)


    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::checkIfCategoryNameDoesntExist(std::string name)
{
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result;
    vector<string >  query_line;
    std::ostringstream  strStream; //temporary stream used for transformation into string
    sqlRequest::SQL_REQUEST_ERRORS ret;
    bool retSqlRequest;

    sqlQuery = m_SQL_REQUEST_CHECK_IF_CATEGORY_NAME_EXIST;
    strStream.str("");
    strStream << name;
    sqlQuery += "'";
    sqlQuery += strStream.str();
    sqlQuery += "'";
    sqlQuery += ")";
    sqlQuery += m_SQL_RETURN_BOOL_VALUE;
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
    }
    else
    {
        // read the result of the query
        query_line = query_result.at(0);
        fromString<bool>(retSqlRequest,query_line[0], std::dec);
        if (retSqlRequest)
            ret = CATEGORY_NAME_ALREADY_EXIST;
        else
            ret = OK;
    }
    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::checkIfCategoryIdExist(POIServiceTypes::CategoryID unique_id)
{
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result;
    vector<string >  query_line;
    std::ostringstream  strStream; //temporary stream used for transformation into string
    sqlRequest::SQL_REQUEST_ERRORS ret;
    bool retSqlRequest;

    sqlQuery = m_SQL_REQUEST_CHECK_IF_CATEGORY_ID_EXIST;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ")";
    sqlQuery += m_SQL_RETURN_BOOL_VALUE;
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
    }
    else
    {
        // read the result of the query
        query_line = query_result.at(0);
        fromString<bool>(retSqlRequest,query_line[0], std::dec);
        if (retSqlRequest)
            ret = OK;
        else
            ret = CATEGORY_ID_NOT_EXIST;
    }
    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::removeCategory(POIServiceTypes::CategoryID unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;

    ret = OK;

    return ret;

}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::getFreeCategoryId(POIServiceTypes::CategoryID& unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    vector<vector<string> > query_result;
    vector<string >  query_line;

    // retrieve the next free category id
    query_result = mp_database->queryNotUTF(m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_CATEGORY_ID);
    if (query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
    }
    else
    { // Id
        query_line = query_result.at(0);
        fromString<categoryId_t>(unique_id,query_line[0], std::dec);
        ret = OK;
    }

    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::getFreeAttributeId(POIServiceTypes::AttributeID &unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    vector<vector<string> > query_result;
    vector<string >  query_line;

    // retrieve the next free category id
    query_result = mp_database->queryNotUTF(m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_ATTRIBUTE_ID);
    if (query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
    }
    else
    { // Id
        query_line = query_result.at(0);
        fromString<attributeId_t>(unique_id,query_line[0], std::dec);
        ret = OK;
    }

    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::checkIfAttributeExist(POIServiceTypes::AttributeID unique_id)
{
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result;
    vector<string >  query_line;
    std::ostringstream  strStream; //temporary stream used for transformation into string
    sqlRequest::SQL_REQUEST_ERRORS ret;
    bool retSqlRequest;

    sqlQuery = m_SQL_REQUEST_CHECK_IF_ATTRIBUTE_ID_EXIST;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ")";
    sqlQuery += m_SQL_RETURN_BOOL_VALUE;
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
    }
    else
    {
        // read the result of the query
        query_line = query_result.at(0);
        fromString<bool>(retSqlRequest,query_line[0], std::dec);
        if (retSqlRequest)
            ret = OK;
        else
            ret = ATTRIBUTE_ID_NOT_EXIST;
    }
    return ret;
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
    m_centerLocation.latitude = 48.85792; //by default center of Paris
    m_centerLocation.longitude = 2.3383145;
    m_centerLocation.altitude = 0;

    mp_sqlRequest = new sqlRequest;
}

PoiManagerServerStub::~PoiManagerServerStub() {
    delete mp_sqlRequest;
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
        category.uniqueId = m_availableCategoryTable.at(index).id;
        category.topLevel = m_availableCategoryTable.at(index).top_level;
        category.name = m_availableCategoryTable.at(index).name;
        categories.push_back(category);
    }

}

void PoiManagerServerStub::getRootCategory(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CategoryID& category)
{
    category = m_rootCategory;
}

void PoiManagerServerStub::getParentCategories(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CategoryID category, std::vector<POIServiceTypes::CategoryAndLevel>& categories)
{
    uint16_t index;
    POIServiceTypes::CategoryAndLevel categoryAndLevel;
    for (index=0;index<m_availableCategoryTable.at(category).parentList.size();index++)
    {
        categoryAndLevel.uniqueId = m_availableCategoryTable.at(category).parentList[index];
        categoryAndLevel.topLevel = m_availableCategoryTable.at(categoryAndLevel.uniqueId).top_level;
        categories.push_back(categoryAndLevel);
    }
}

void PoiManagerServerStub::getChildrenCategories(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CategoryID category, std::vector<POIServiceTypes::CategoryAndLevel>& categories)
{
    uint16_t index;
    POIServiceTypes::CategoryAndLevel categoryAndLevel;
    for (index=0;index<m_availableCategoryTable.at(category).childList.size();index++)
    {
        categoryAndLevel.uniqueId = m_availableCategoryTable.at(category).childList[index];
        categoryAndLevel.topLevel = m_availableCategoryTable.at(categoryAndLevel.uniqueId).top_level;
        categories.push_back(categoryAndLevel);
    }
}

void PoiManagerServerStub::createCategory(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CAMCategory category, POIServiceTypes::CategoryID& unique_id)
{
    mp_sqlRequest->createCategory(category,unique_id);
    refreshCategoryList();
}

void PoiManagerServerStub::removeCategories(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::CategoryID> categories)
{
    size_t index;

    for(index=0;index<categories.size();index++)
    {
        if (mp_sqlRequest->removeCategory(categories.at(index)) != sqlRequest::OK)
            break;
    }
    if (index<categories.size())
    { //it failed
//to do something
    }
    else
    {
        fireCategoriesRemovedEvent(categories);
        refreshCategoryList();
    }
}

void PoiManagerServerStub::addPOIs(const std::shared_ptr<CommonAPI::ClientId> clientId, POIServiceTypes::CategoryID unique_id, std::vector<POIServiceTypes::PoiAddedDetails> poiList)
{

}

void PoiManagerServerStub::removePOIs(const std::shared_ptr<CommonAPI::ClientId> clientId, std::vector<POIServiceTypes::POI_ID> ids)
{

}

bool PoiManagerServerStub::initDatabase(const char* poiDatabaseFileName)
{
    mp_sqlRequest->setDatabase(poiDatabaseFileName);
    refreshCategoryList(); //read the database and buffer the category list locally

    POIServiceTypes::CAMCategory category;
    POIServiceTypes::CategoryAttribute attribute;
    POIServiceTypes::CategoryID unique_id;

    category.details.name = "recreation";
    attribute.id = 2;
    attribute.name = "phone";
    category.attributes.push_back(attribute);
    attribute.id = 13;
    attribute.name = "credit card";
    category.attributes.push_back(attribute);
    category.details.parentsId.push_back(0);
    mp_sqlRequest->createCategory(category,unique_id);
    refreshCategoryList(); //read the database and buffer the category list locally

    mp_sqlRequest->removeCategory(unique_id);
    refreshCategoryList(); //read the database and buffer the category list locally

    return true; //maybe add some check of the file here
}

// refresh the buffer that contains the categories related data, called each time a category is added or removed
void PoiManagerServerStub::refreshCategoryList()
{
    m_availableCategoryTable.clear();
    m_availableCategoryTable = mp_sqlRequest->getAvailableCategories(m_rootCategory);
    m_availableCategories = m_availableCategoryTable.size();
}
