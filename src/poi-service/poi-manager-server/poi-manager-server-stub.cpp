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
                poiCategory.attributeList.clear();
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
    double doubleValue;

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
        fromString<double>(doubleValue,query_line[0], std::dec);
        m_leftBottomLocation.setLatitude(doubleValue);
        fromString<double>(doubleValue,query_line[1], std::dec);
        m_leftBottomLocation.setLongitude(doubleValue);
        fromString<double>(doubleValue,query_line[2], std::dec);
        m_rightTopLocation.setLatitude(doubleValue);
        fromString<double>(doubleValue,query_line[3], std::dec);
        m_rightTopLocation.setLongitude(doubleValue);
    }
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::createCategory(POIServiceTypes::CAMCategory category, POIServiceTypes::CategoryID& unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    size_t index;
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result;
    std::ostringstream  strStream; //temporary stream used for transformation into string
    recordId_t recordId;
    iconId_t iconId;

    //Check if the name doesn't exist into the database to avoid duplications
    ret = checkIfCategoryNameDoesntExist(category.getDetails().getName());
    if (ret != OK)
        return ret;

    //Get a free id (poicategory)
    ret = getFreeCategoryId(unique_id);
    if (ret != OK)
        return ret;

    //Create the category
    // example INSERT INTO poicategory VALUES (8,'recreation');
    sqlQuery = m_SQL_REQUEST_INSERT_CATEGORY;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ",'";
    sqlQuery.append(category.getDetails().getName());
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
    for (index=0;index < category.getAttributes().size();index++)
    {
        ret = checkIfAttributeExist((category.getAttributes().at(index)).getId(),(category.getAttributes().at(index)).getName());
        if (ret == ATTRIBUTE_ID_NOT_EXIST)
        {
            //Create the attribute
            sqlQuery = m_SQL_REQUEST_INSERT_ATTRIBUTE;
            strStream.str("");
            strStream << (category.getAttributes().at(index)).getId();
            sqlQuery += strStream.str();
            sqlQuery += ",'";
            sqlQuery.append((category.getAttributes().at(index)).getName());
            sqlQuery += "');";
            query_result = mp_database->queryNotUTF(sqlQuery.c_str());
            if (!query_result.empty())
            {
                onError(); //database is not well populated
                //todo something with table ?
                ret = DATABASE_ACCESS_ERROR;
                return ret;
            }

/*            //Extend the fields of poi with this new attribute
              // to be added later: DROP management (not available in sqlite, so need a buffer table)
              //                    how to populate poi with a more dynamically way ...
            sqlQuery = m_SQL_REQUEST_EXTEND_TABLE_POI;
            sqlQuery.append((category.attributes.at(index)).name);
            sqlQuery += "' text;";
            query_result = mp_database->queryNotUTF(sqlQuery.c_str());
            if (!query_result.empty())
            {
                onError(); //database is not well populated
                //todo something with table ?
                ret = DATABASE_ACCESS_ERROR;
                return ret;
            } */
        }
        else
        {
            if (ret != OK)
                return ret;
        }

        //Complete the table of attributes for the category (hasattribute)
        ret = getFreeRecordId(m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_HAS_ATTRIBUTE,recordId);
        if (ret != OK)
            return ret;
        //Create the entry into the table hasattribute
        sqlQuery = m_SQL_REQUEST_INSERT_HAS_ATTRIBUTE;
        strStream.str("");
        strStream << recordId;
        sqlQuery += strStream.str();
        sqlQuery += ",";
        strStream.str("");
        strStream << unique_id;
        sqlQuery += strStream.str();
        sqlQuery += ",";
        strStream.str("");
        strStream << (category.getAttributes().at(index)).getId();
        sqlQuery += strStream.str();
        sqlQuery += ");";
        query_result = mp_database->queryNotUTF(sqlQuery.c_str());
        if (!query_result.empty())
        {
            onError(); //database is not well populated
            //todo something with table ?
            ret = DATABASE_ACCESS_ERROR;
            return ret;
        }
    }

    //Check if all the parent categories exist and complete the table of family categories (poicategorykinship)
    for (index=0;index < category.getDetails().getParentsId().size();index++)
    {
        ret = checkIfCategoryExist(category.getDetails().getParentsId().at(index));
        if (ret != OK)
            return ret;

        ret = getFreeRecordId(m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_POI_CATEGORY_KINSHIP,recordId);
        if (ret != OK)
            return ret;
        //Create the entry into the table poicategorykinship
        sqlQuery = m_SQL_REQUEST_INSERT_POI_CATEGORY_KINSHIP;
        strStream.str("");
        strStream << recordId;
        sqlQuery += strStream.str();
        sqlQuery += ",";
        strStream.str("");
        strStream << unique_id;
        sqlQuery += strStream.str();
        sqlQuery += ",";
        strStream.str("");
        strStream << category.getDetails().getParentsId().at(index);
        sqlQuery += strStream.str();
        sqlQuery += ");";
        query_result = mp_database->queryNotUTF(sqlQuery.c_str());
        if (!query_result.empty())
        {
            onError(); //database is not well populated
            //todo something with table ?
            ret = DATABASE_ACCESS_ERROR;
            return ret;
        }
    }

    //Complete the table of icons (iconset and isdisplayedas)
    //Get a free id (iconset)
    ret = getFreeIconId(iconId);
    if (ret != OK)
        return ret;

    //Create the icon
    sqlQuery = m_SQL_REQUEST_INSERT_ICON;
    strStream.str("");
    strStream << iconId;
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << ICON_WIDTH;
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << ICON_HEIGHT;
    sqlQuery += strStream.str();
    sqlQuery += ",'";
    sqlQuery.append(ICON_URL);
    strStream.str("");
    strStream << iconId;
    sqlQuery += strStream.str();
    sqlQuery += "','";
    sqlQuery.append(ICON_FORMAT);
    sqlQuery += "');";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    ret = getFreeRecordId(m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_IS_DISPLAYED_HAS,recordId);
    if (ret != OK)
        return ret;
    //Create the entry into the table isdisplayedas
    sqlQuery = m_SQL_REQUEST_INSERT_IS_DISPLAYED_HAS;
    strStream.str("");
    strStream << recordId;
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << iconId;
    sqlQuery += strStream.str();
    sqlQuery += ");";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

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

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::checkIfCategoryExist(POIServiceTypes::CategoryID unique_id)
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

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::checkIfPoiExist(POIServiceTypes::POI_ID unique_id)
{
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result;
    vector<string >  query_line;
    std::ostringstream  strStream; //temporary stream used for transformation into string
    sqlRequest::SQL_REQUEST_ERRORS ret;
    bool retSqlRequest;

    sqlQuery = m_SQL_REQUEST_CHECK_IF_POI_ID_EXIST;
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
            ret = POI_ID_NOT_EXIST;
    }
    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::removeCategory(POIServiceTypes::CategoryID unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result;
    vector<string>  query_line;
    std::ostringstream  strStream; //temporary stream used for transformation into string
    POIServiceTypes::POI_ID poi_id;
    size_t index;

    //Check if the id exists into the database
    ret = checkIfCategoryExist(unique_id);
    if (ret != OK)
        return ret;

    // Remove category (poicategory)
    sqlQuery = m_SQL_REQUEST_DELETE_CATEGORY;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ";";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    // Clean up poicategorykinship
    sqlQuery = m_SQL_REQUEST_CLEAN_UP_CATEGORY_POI_CATEGORY_KINSHIP;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ";";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    // Clean up iconset
    sqlQuery = m_SQL_REQUEST_CLEAN_UP_CATEGORY_ICON;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ";";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    // Clean up hasattribute
    sqlQuery = m_SQL_REQUEST_CLEAN_UP_CATEGORY_HAS_ATTRIBUTE;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ";";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    // Clean up orphan attributes (the ones that have no category)
    sqlQuery = m_SQL_REQUEST_CLEAN_UP_ORPHAN_ATTRIBUTES;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ";";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    // Clean up isdisplayedas
    sqlQuery = m_SQL_REQUEST_CLEAN_UP_CATEGORY_IS_DISPLAYED_HAS;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ";";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    // Clean up orphan pois
    // Select orphans
    sqlQuery = m_SQL_REQUEST_SELECT_ORPHAN_POIS;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ";";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    // and remove it if necessary
    if (query_result.size() != 0)
    {
        for (index = 0; index < query_result.size(); index++)
        {
            query_line = query_result.at(index);
            fromString<POIServiceTypes::POI_ID>(poi_id,query_line.at(0), std::dec);
            ret = removePoi(poi_id);
            if (ret != OK)
                return ret;
        }
    }

    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::getFreePoiId(POIServiceTypes::POI_ID &unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    vector<vector<string> > query_result;
    vector<string >  query_line;

    // retrieve the next free category id
    query_result = mp_database->queryNotUTF(m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_POI_ID);
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

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::getFreeIconId(iconId_t &unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    vector<vector<string> > query_result;
    vector<string >  query_line;

    // retrieve the next free category id
    query_result = mp_database->queryNotUTF(m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_ICON_ID);
    if (query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
    }
    else
    { // Id
        query_line = query_result.at(0);
        fromString<iconId_t>(unique_id,query_line[0], std::dec);
        ret = OK;
    }

    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::getFreeRecordId(const char* request, recordId_t &unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    vector<vector<string> > query_result;
    vector<string >  query_line;

    // retrieve the next free category id
    query_result = mp_database->queryNotUTF(request);
    if (query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
    }
    else
    { // Id
        query_line = query_result.at(0);
        fromString<recordId_t>(unique_id,query_line[0], std::dec);
        ret = OK;
    }

    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::checkIfAttributeExist(POIServiceTypes::AttributeID unique_id, std::string name)
{
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result;
    vector<string >  query_line;
    std::ostringstream  strStream; //temporary stream used for transformation into string
    sqlRequest::SQL_REQUEST_ERRORS ret;
    bool retSqlRequest;

    // check if id exists
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
        {
            // check if name exists (that'd be an error, name must be unique)
            sqlQuery = m_SQL_REQUEST_CHECK_IF_ATTRIBUTE_NAME_EXIST;
            sqlQuery += name;
            sqlQuery += "')";
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
                    ret = ATTRIBUTE_NAME_ALREADY_EXIST;
                else
                    ret = ATTRIBUTE_ID_NOT_EXIST;
            }
        }
    }

    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::createPoi(POIServiceTypes::CategoryID categoryId, POIServiceTypes::PoiAddedDetails poi, POIServiceTypes::POI_ID &unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result;
    vector<string >  query_line;
    std::ostringstream  strStream; //temporary stream used for transformation into string
    recordId_t recordId;
    poiproviderId_t poiproviderId;
    poiRecorded_t  poiRecorded;
    size_t index;

    //Get a free id (poi)
    ret = getFreePoiId(unique_id);
    if (ret != OK)
        return ret;

    //Extract the attributes

    //First set default values
    poiRecorded.addr_city = "";
    poiRecorded.addr_house_number = "";
    poiRecorded.addr_postcode = 0;
    poiRecorded.addr_street = "";
    poiRecorded.brand = "";
    poiRecorded.openinghours = "";
    poiRecorded.operateur = "";
    poiRecorded.phone = "";
    poiRecorded.source = "";
    poiRecorded.stars = 0;
    poiRecorded.website = "";

    //and scan the poi attributes
    for (index=0; index < poi.getAttributes().size();index++)
    {
        switch ((poi.getAttributes().at(index)).getId())
        {
        case ATTRIBUTE_SOURCE:
            poiRecorded.source = (poi.getAttributes().at(index)).getValue().get<std::string>();
            break;
        case ATTRIBUTE_WEBSITE:
            poiRecorded.website = (poi.getAttributes().at(index)).getValue().get<std::string>();
            break;
        case ATTRIBUTE_PHONE :
            poiRecorded.phone = (poi.getAttributes().at(index)).getValue().get<std::string>();
            break;
        case ATTRIBUTE_STARS:
            poiRecorded.stars = (poi.getAttributes().at(index)).getValue().get<int>();
            break;
        case ATTRIBUTE_OPENINGHOURS:
            poiRecorded.openinghours = (poi.getAttributes().at(index)).getValue().get<std::string>();
            break;
        case ATTRIBUTE_ADDRHOUSENUMBER:
            poiRecorded.addr_house_number = (poi.getAttributes().at(index)).getValue().get<std::string>();
            break;
        case ATTRIBUTE_ADDRSTREET:
            poiRecorded.addr_street = (poi.getAttributes().at(index)).getValue().get<std::string>();
            break;
        case ATTRIBUTE_ADDRPOSTCODE:
            poiRecorded.addr_postcode = (poi.getAttributes().at(index)).getValue().get<int>();
            break;
        case ATTRIBUTE_ADDRCITY:
            poiRecorded.addr_city = (poi.getAttributes().at(index)).getValue().get<std::string>();
            break;
        case ATTRIBUTE_BRAND:
            poiRecorded.brand = (poi.getAttributes().at(index)).getValue().get<std::string>();
            break;
        case ATTRIBUTE_OPERATEUR:
            poiRecorded.operateur = (poi.getAttributes().at(index)).getValue().get<std::string>();
            break;
        case ATTRIBUTE_CREDIT_CARD:
            poiRecorded.credit_card = (poi.getAttributes().at(index)).getValue().get<std::string>();
            break;
        default:
            return ATTRIBUTE_ID_NOT_EXIST;
        }
    }

    //Create the poi with the associated data
    //CREDIT_CARD and later not implemented yet, limited to 18 column
    //Example INSERT INTO poi VALUES (1,'mySweetHome',48.7798390,2.2172600,120,0,0,'Genivi','','',5,'','','',0,'Velizy','','');
    sqlQuery = m_SQL_REQUEST_INSERT_POI;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ",'";
    sqlQuery.append(poi.getName());
    sqlQuery += "',";
    strStream.str("");
    strStream.precision(7);
    strStream << fixed << poi.getLocation().getLatitude();
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream.precision(7);
    strStream << fixed << poi.getLocation().getLongitude();
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << poi.getLocation().getAltitude();
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << 0; //segment not used
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << 0; //offset not used
    sqlQuery += strStream.str();
    sqlQuery += ",'";
    sqlQuery.append(poiRecorded.source); //source
    sqlQuery += "','";
    sqlQuery.append(poiRecorded.website); //web site
    sqlQuery += "','";
    sqlQuery.append(poiRecorded.phone); //phone
    sqlQuery += "',";
    strStream.str("");
    strStream << poiRecorded.stars; //stars
    sqlQuery += strStream.str();
    sqlQuery += ",'";
    sqlQuery.append(poiRecorded.openinghours); //opening hours
    sqlQuery += "','";
    sqlQuery.append(poiRecorded.addr_house_number); //house number
    sqlQuery += "','";
    sqlQuery.append(poiRecorded.addr_street); //addr street
    sqlQuery += "',";
    strStream.str("");
    strStream << poiRecorded.addr_postcode; // addr postcode
    sqlQuery += strStream.str();
    sqlQuery += ",'";
    sqlQuery.append(poiRecorded.addr_city); // addr city
    sqlQuery += "','";
    sqlQuery.append(poiRecorded.brand); // brand
    sqlQuery += "','";
    sqlQuery.append(poiRecorded.operateur); // operateur
    sqlQuery += "');";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    //Complete the table belongsto

    // Get the id of the default POI_PROVIDER
    // example SELECT Id FROM poiprovider WHERE name='OpenStreetMap';
    sqlQuery = m_SQL_REQUEST_GET_POI_PROVIDER_ID;
    sqlQuery += "'";
    sqlQuery.append(POI_PROVIDER);
    sqlQuery += "';";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }
    else
    { // Id
        query_line = query_result.at(0);
        fromString<poiproviderId_t>(poiproviderId,query_line[0], std::dec);
    }

    ret = getFreeRecordId(m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_BELONGS_TO,recordId);
    if (ret != OK)
        return ret;
    //Create the entry into the table belongsto
    // example INSERT INTO belongsto (Id,poi_Id,poicategory_Id,poiprovider_Id) VALUES (1,1,8,0);
    sqlQuery = m_SQL_REQUEST_INSERT_BELONGSTO;
    strStream.str("");
    strStream << recordId;
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << categoryId;
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << poiproviderId;
    sqlQuery += strStream.str();
    sqlQuery += ");";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    // Complete the table isshownas
    ret = getFreeRecordId(m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_IS_SHOWN_HAS,recordId);
    if (ret != OK)
        return ret;
    //Create the entry into the table isshownas
    sqlQuery = m_SQL_REQUEST_INSERT_IS_SHOWN_HAS;
    strStream.str("");
    strStream << recordId;
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ",";
    strStream.str("");
    strStream << MEDIASET;
    sqlQuery += strStream.str();
    sqlQuery += ");";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::removePoi(POIServiceTypes::POI_ID unique_id)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result;
    std::ostringstream  strStream; //temporary stream used for transformation into string

    //Check if the id exists into the database
    ret = checkIfPoiExist(unique_id);
    if (ret != OK)
        return ret;

    // Remove poi
    sqlQuery = m_SQL_REQUEST_DELETE_POI;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ";";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    // Clean up belongsto
    sqlQuery = m_SQL_REQUEST_CLEAN_UP_POI_BELONGSTO;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ";";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }


    // Clean up isshownas
    sqlQuery = m_SQL_REQUEST_CLEAN_UP_POI_IS_SHOWN_HAS;
    strStream.str("");
    strStream << unique_id;
    sqlQuery += strStream.str();
    sqlQuery += ";";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    if (!query_result.empty())
    {
        onError(); //database is not well populated
        //todo something with table ?
        ret = DATABASE_ACCESS_ERROR;
        return ret;
    }

    return ret;
}

sqlRequest::SQL_REQUEST_ERRORS sqlRequest::searchPoi(const string &categoryName,const string &search_string, NavigationTypes::Coordinate3D &left_bottom_location, NavigationTypes::Coordinate3D &right_top_location, std::vector<POIServiceTypes::POI_ID> &poi_id_list)
{
    sqlRequest::SQL_REQUEST_ERRORS ret;
    std::string sqlQuery; //SQL request on database
    vector<vector<string> > query_result; //result of the query on database
    vector<string>  query_line;
    std::ostringstream  strStream; //temporary stream used for transformation into string
    size_t index;
    NavigationTypes::Coordinate3D recordedBottom, recordedTop;
    POIServiceTypes::POI_ID poi_id;

    // example of query     SELECT Id FROM poi
    //                      WHERE (Id IN (SELECT poi_Id FROM belongsto,poicategory
    //                      WHERE (belongsto.poicategory_Id = poicategory.Id)
    //                      AND (poicategory.name = 'recreation')))
    //                      AND ((latitude > 48.76) AND (latitude < 48.78))
    //                      AND ((longitude > 2.20) AND (longitude < 2.22))
    //                      AND (name LIKE '%Sweet%');

    // it's needed to reorder the latitude and longitude for the test coherency
    if (left_bottom_location.getLatitude() > right_top_location.getLatitude())
    {
        recordedBottom.setLatitude(right_top_location.getLatitude());
        recordedTop.setLatitude(left_bottom_location.getLatitude());
    }
    else
    {
        recordedBottom.setLatitude(left_bottom_location.getLatitude());
        recordedTop.setLatitude(right_top_location.getLatitude());
    }
    if (left_bottom_location.getLongitude() > right_top_location.getLongitude())
    {
        recordedBottom.setLongitude(right_top_location.getLongitude());
        recordedTop.setLongitude(left_bottom_location.getLongitude());
    }
    else
    {
        recordedBottom.setLongitude(left_bottom_location.getLongitude());
        recordedTop.setLongitude(right_top_location.getLongitude());
    }
    sqlQuery = m_SQL_REQUEST_SEARCH_POI;
    sqlQuery += categoryName;
    sqlQuery += "'))) AND ((latitude > ";
    strStream.str("");
    strStream << recordedBottom.getLatitude();
    sqlQuery += strStream.str();
    sqlQuery += ") AND (latitude < ";
    strStream.str("");
    strStream << recordedTop.getLatitude();
    sqlQuery += strStream.str();
    sqlQuery += ")) AND ((longitude > ";
    strStream.str("");
    strStream << recordedBottom.getLongitude();
    sqlQuery += strStream.str();
    sqlQuery += ") AND (longitude < ";
    strStream.str("");
    strStream << recordedTop.getLongitude();
    sqlQuery += strStream.str();
    sqlQuery += ")) AND (name LIKE '%";
    sqlQuery += search_string;
    sqlQuery += "%');";
    query_result = mp_database->queryNotUTF(sqlQuery.c_str());
    // read the result of the query
    if (query_result.size() == 0) //get the amount of poi searched
    {
        ret = POI_ID_NOT_EXIST;
    }
    else
    {
        for (index = 0; index < query_result.size(); index++)
        {
            query_line = query_result.at(index);
            fromString<POIServiceTypes::POI_ID>(poi_id,query_line.at(0), std::dec);
            poi_id_list.push_back(poi_id);
        }
        ret = OK;
    }

    return ret;
}


PoiManagerServerStub::PoiManagerServerStub() {
    m_version.setVersionMajor(1);
    m_version.setVersionMinor(0);
    m_version.setVersionMicro(0);
    m_version.setDate("19-03-2015");
    m_rootCategory = ALL_CATEGORIES; //by default
    m_languageCode = "eng";
    m_countryCode = "USA";
    m_scriptCode = "Latn";
    m_centerLocation.setLatitude(48.85792); //by default center of Paris
    m_centerLocation.setLongitude(2.3383145);
    m_centerLocation.setAltitude(30);

    mp_sqlRequest = new sqlRequest;

    m_search_handle = NO_HANDLE;
}

PoiManagerServerStub::~PoiManagerServerStub() {
    delete mp_sqlRequest;
}

void PoiManagerServerStub::getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply)
{
     NavigationTypes::Version POIContentManagerVersion(m_version);

    _reply(POIContentManagerVersion);
}

void PoiManagerServerStub::setLocale(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _languageCode, std::string _countryCode, std::string _scriptCode, setLocaleReply_t _reply)
{
    std::vector<uint16_t> changedSettings;

    m_languageCode = _languageCode;
    m_countryCode = _countryCode;
    m_scriptCode = _scriptCode;

    changedSettings.push_back(POIServiceTypes::ConfigurationChangedReason::LOCALES);

    fireConfigurationChangedEvent(changedSettings);
}

void PoiManagerServerStub::getLocale(const std::shared_ptr<CommonAPI::ClientId> _client, getLocaleReply_t _reply)
{
    _reply(m_languageCode,m_countryCode,m_scriptCode);
}

void PoiManagerServerStub::getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedLocalesReply_t _reply)
{
    std::vector< POIServiceTypes::Locales> localeList;
    POIServiceTypes::Locales en_US { "eng","USA", "Latn" };
    POIServiceTypes::Locales fr_FR { "fra","FRA", "Latn" };
    localeList.push_back(en_US);
    localeList.push_back(fr_FR);

    _reply(localeList);
}

void PoiManagerServerStub::getAvailableCategories(const std::shared_ptr<CommonAPI::ClientId> _client, getAvailableCategoriesReply_t _reply)
{
    POIServiceTypes::CategoryAndName category;
    std::vector< POIServiceTypes::CategoryAndName> categories;

    uint16_t index;

    // load categories from the embedded database
    for (index = 0; index < m_availableCategories; index++)
    {
        category.setUniqueId(m_availableCategoryTable.at(index).id);
        category.setTopLevel(m_availableCategoryTable.at(index).top_level);
        category.setName(m_availableCategoryTable.at(index).name);
        categories.push_back(category);
    }

    _reply(categories);
}

void PoiManagerServerStub::getRootCategory(const std::shared_ptr<CommonAPI::ClientId> _client, getRootCategoryReply_t _reply)
{
    _reply(m_rootCategory);
}

void PoiManagerServerStub::getParentCategories(const std::shared_ptr<CommonAPI::ClientId> _client, POIServiceTypes::CategoryID _category, getParentCategoriesReply_t _reply)
{
    uint16_t index;
    POIServiceTypes::CategoryAndLevel categoryAndLevel;
    std::vector< POIServiceTypes::CategoryAndLevel> categories;

    for (index=0;index<m_availableCategoryTable.at(_category).parentList.size();index++)
    {
        categoryAndLevel.setUniqueId(m_availableCategoryTable.at(_category).parentList[index]);
        categoryAndLevel.setTopLevel(m_availableCategoryTable.at(categoryAndLevel.getUniqueId()).top_level);
        categories.push_back(categoryAndLevel);
    }

    _reply(categories);
}

void PoiManagerServerStub::getChildrenCategories(const std::shared_ptr<CommonAPI::ClientId> _client, POIServiceTypes::CategoryID _category, getChildrenCategoriesReply_t _reply)
{
    uint16_t index;
    POIServiceTypes::CategoryAndLevel categoryAndLevel;
    std::vector< POIServiceTypes::CategoryAndLevel> categories;

    for (index=0;index<m_availableCategoryTable.at(_category).childList.size();index++)
    {
        categoryAndLevel.setUniqueId(m_availableCategoryTable.at(_category).childList[index]);
        categoryAndLevel.setTopLevel(m_availableCategoryTable.at(categoryAndLevel.getUniqueId()).top_level);
        categories.push_back(categoryAndLevel);
    }

    _reply(categories);
}

void PoiManagerServerStub::createCategory(const std::shared_ptr<CommonAPI::ClientId> _client, POIServiceTypes::CAMCategory _category, createCategoryReply_t _reply)
{
    POIServiceTypes::CategoryID unique_id;

    mp_sqlRequest->createCategory(_category,unique_id);
    refreshCategoryList();

    _reply(unique_id);
}

void PoiManagerServerStub::removeCategories(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< POIServiceTypes::CategoryID> _categories, removeCategoriesReply_t _reply)
{
    size_t index;

    for(index=0;index<_categories.size();index++)
    {
        if (mp_sqlRequest->removeCategory(_categories.at(index)) != sqlRequest::OK)
            break;
    }
    if (index<_categories.size())
    { //it failed
//to do something
    }
    else
    {
        fireCategoriesRemovedEvent(_categories);
        refreshCategoryList();
    }
}

void PoiManagerServerStub::addPOIs(const std::shared_ptr<CommonAPI::ClientId> _client, POIServiceTypes::CategoryID _unique_id, std::vector< POIServiceTypes::PoiAddedDetails> _poiList, addPOIsReply_t _reply)
{
    size_t index;
    std::vector<POIServiceTypes::POI_ID> addedPoiList;
    POIServiceTypes::POI_ID poiId;

    for(index=0;index<_poiList.size();index++)
    {
        if (mp_sqlRequest->createPoi(_unique_id,_poiList.at(index),poiId) != sqlRequest::OK)
            break;
        addedPoiList.push_back(poiId);
    }
    if (index<_poiList.size())
    { //it failed
//to do something
    }
    else
    {
        firePOIAddedEvent(addedPoiList);
    }

}

void PoiManagerServerStub::removePOIs(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< POIServiceTypes::POI_ID> _ids, removePOIsReply_t _reply)
{
    size_t index;

    for(index=0;index<_ids.size();index++)
    {
        if (mp_sqlRequest->removePoi(_ids.at(index)) != sqlRequest::OK)
            break;
    }
    if (index<_ids.size())
    { //it failed
//to do something
    }
    else
    {
        firePOIRemovedEvent(_ids);
    }
}

void PoiManagerServerStub::poiSearchStarted(const std::shared_ptr<CommonAPI::ClientId> _client, ::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, uint16_t _maxSize, ::org::genivi::navigation::NavigationTypes::Coordinate3D _location, std::vector< ::v0_1::org::genivi::navigation::poiservice::POIServiceTypes::CategoryAndRadius> _poiCategories, std::vector< ::v0_1::org::genivi::navigation::poiservice::POIServiceTypes::AttributeDetails> _poiAttributes, std::string _inputString, uint16_t _sortOption, poiSearchStartedReply_t _reply)
{
    POIServiceTypes::CategoryAndRadius categoryAndRadius;
    size_t index;
    string categoryName;
    double angle;
    NavigationTypes::Coordinate3D leftBottomLocation, rightTopLocation;
    std::vector<POIServiceTypes::POI_ID> poiIDList;

    //For the moment, just search for one category
    categoryAndRadius = _poiCategories.at(0);

    //First step is to check the consistency of the request
    for(index=0;index<m_availableCategoryTable.size();index++)
    {
        if ((m_availableCategoryTable.at(index)).id == categoryAndRadius.getId())
        {
            categoryName = (m_availableCategoryTable.at(index)).name;
            break;
        }
    }
    if (index>=m_availableCategoryTable.size())
    {
        //no id found, error to be sent
        fireSearchStatusChangedEvent(_poiSearchHandle,POIServiceTypes::SearchStatusState::INVALID);
        return;
    }

    //calculate the angle
    angle = calculateAngle(categoryAndRadius.getRadius()*10); // radius unit is 10 m

    leftBottomLocation.setLatitude(_location.getLatitude() - angle);
    leftBottomLocation.setLongitude(_location.getLongitude() - angle);
    rightTopLocation.setLatitude(_location.getLatitude() + angle);
    rightTopLocation.setLongitude(_location.getLongitude() + angle);


    m_search_handle = _poiSearchHandle; //for the moment, only one handle is managed

    fireSearchStatusChangedEvent(_poiSearchHandle,POIServiceTypes::SearchStatusState::SEARCHING);

    mp_sqlRequest->searchPoi(categoryName,_inputString, leftBottomLocation, rightTopLocation, poiIDList);

    fireSearchStatusChangedEvent(_poiSearchHandle,POIServiceTypes::SearchStatusState::FINISHED);

}

void PoiManagerServerStub::poiSearchCanceled(const std::shared_ptr<CommonAPI::ClientId> _client, ::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, poiSearchCanceledReply_t _reply)
{
    m_search_handle = NO_HANDLE;
    fireSearchStatusChangedEvent(_poiSearchHandle,POIServiceTypes::SearchStatusState::NOT_STARTED);
}

void PoiManagerServerStub::resultListRequested(const std::shared_ptr<CommonAPI::ClientId> _client, uint8_t _camId, ::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, std::vector< ::v0_1::org::genivi::navigation::poiservice::POIServiceTypes::AttributeID> _attributes, resultListRequestedReply_t _reply)
{

}

void PoiManagerServerStub::poiDetailsRequested(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< ::v0_1::org::genivi::navigation::poiservice::POIServiceTypes::POI_ID> _source_id, poiDetailsRequestedReply_t _reply)
{

}

void PoiManagerServerStub::run()
{
}

bool PoiManagerServerStub::initDatabase(const char* poiDatabaseFileName)
{
    mp_sqlRequest->setDatabase(poiDatabaseFileName);
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
