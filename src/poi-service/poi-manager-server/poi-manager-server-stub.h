/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2015, PCA Peugeot Citroen
*
* \file poi-manager-server-stub.h
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
#ifndef POIMANAGERSERVERSTUBIMPL_H_
#define POIMANAGERSERVERSTUBIMPL_H_

#include <CommonAPI/CommonAPI.hpp>

#include <v0_1/org/genivi/navigation/poiservice/POIServiceTypes.hpp>
#include <org/genivi/navigation/NavigationTypes.hpp>
#include <v0_1/org/genivi/navigation/poiservice/POIContentManagerStubDefault.hpp>

#include "poi-common-database.h"

#include "poi-common-data-model.h"

using namespace std;
using namespace v0_1::org::genivi::navigation::poiservice;
using namespace org::genivi::navigation;

class sqlRequest
{
public:

    typedef enum
    {
        CATEGORY_NOT_EXIST,
        CATEGORY_NAME_ALREADY_EXIST,
        CATEGORY_ID_NOT_EXIST,
        ATTRIBUTE_ID_NOT_EXIST,
        ATTRIBUTE_NAME_ALREADY_EXIST,
        PARENT_CATEGORY_NOT_EXIST,
        POI_ID_NOT_EXIST,
        DATABASE_ACCESS_ERROR,
        OK
    } SQL_REQUEST_ERRORS;

    typedef uint32_t recordId_t;
    typedef uint32_t iconId_t;
    typedef uint32_t poiproviderId_t;

    typedef struct {
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
        std::string credit_card;
    } poiRecorded_t;

    sqlRequest();
    ~sqlRequest();
    SQL_REQUEST_ERRORS setDatabase(const char* poiDatabaseFileName);
    vector<poi_category_common_t> getAvailableCategories(POIServiceTypes::CategoryID& rootCategory);
    SQL_REQUEST_ERRORS createCategory(POIServiceTypes::CAMCategory category,POIServiceTypes::CategoryID& unique_id);
    SQL_REQUEST_ERRORS removeCategory(POIServiceTypes::CategoryID unique_id);
    SQL_REQUEST_ERRORS createPoi(POIServiceTypes::CategoryID categoryId, POIServiceTypes::PoiAddedDetails poi, POIServiceTypes::POI_ID& unique_id);
    SQL_REQUEST_ERRORS removePoi(POIServiceTypes::POI_ID unique_id);
    SQL_REQUEST_ERRORS searchPoi(const string &categoryName, const string &search_string, NavigationTypes::Coordinate3D &left_bottom_location, NavigationTypes::Coordinate3D &right_top_location, std::vector<POIServiceTypes::POI_ID> &poi_id_list);

private:
    const char* m_SQL_REQUEST_GET_AVAILABLE_CATEGORIES = "SELECT Id,name FROM poicategory;";
    const char* m_SQL_REQUEST_GET_CATEGORIES_USED_BY_POI = "SELECT Id,name FROM poicategory WHERE Id IN (SELECT poicategory_Id FROM belongsto GROUP BY poicategory_Id);";
    const char* m_SQL_REQUEST_GET_CATEGORY_ATTRIBUTES = "SELECT Id,name FROM poiattribute WHERE Id IN (SELECT poiattribute_Id FROM hasattribute WHERE poicategory_Id IS ";
    const char* m_SQL_REQUEST_GET_AVAILABLE_AREA = "SELECT leftlongitude,bottomlatitude,rightlongitude,toplatitude FROM availablearea;";
    const char* m_SQL_REQUEST_GET_PARENT_CATEGORIES = "SELECT parentId FROM poicategorykinship WHERE childId IS ";
    const char* m_SQL_REQUEST_GET_CHILD_CATEGORIES = "SELECT childId FROM poicategorykinship WHERE parentId IS ";
    const char* m_SQL_REQUEST_GET_CATEGORY_ICONS = "SELECT url,format FROM iconset WHERE Id IS (SELECT iconset_Id FROM isdisplayedas WHERE poicategory_Id IS  ";

    const char* m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_CATEGORY_ID = "SELECT a.id+1 FROM poicategory a WHERE NOT EXISTS (SELECT * FROM poicategory b WHERE a.id+1 = b.id) ORDER BY a.id";
    const char* m_SQL_REQUEST_INSERT_CATEGORY = "INSERT INTO poicategory VALUES (";
    const char* m_SQL_REQUEST_DELETE_CATEGORY = "DELETE from poicategory WHERE id = ";
    const char* m_SQL_REQUEST_CHECK_IF_CATEGORY_ID_EXIST = "SELECT CASE WHEN EXISTS (SELECT * FROM poicategory WHERE id = ";
    const char* m_SQL_REQUEST_CHECK_IF_CATEGORY_NAME_EXIST = "SELECT CASE WHEN EXISTS (SELECT * FROM poicategory WHERE name = ";

    const char* m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_POI_ID = "SELECT a.id+1 FROM poi a WHERE NOT EXISTS (SELECT * FROM poi b WHERE a.id+1 = b.id) ORDER BY a.id";
    const char* m_SQL_REQUEST_INSERT_POI = "INSERT INTO poi VALUES (";
    const char* m_SQL_REQUEST_DELETE_POI = "DELETE from poi WHERE Id = ";
    const char* m_SQL_REQUEST_CHECK_IF_POI_ID_EXIST = "SELECT CASE WHEN EXISTS (SELECT * FROM poi WHERE id = ";
    const char* m_SQL_REQUEST_SEARCH_POI = "SELECT Id FROM poi WHERE (Id IN (SELECT poi_Id FROM belongsto,poicategory WHERE (belongsto.poicategory_Id = poicategory.Id) AND (poicategory.name = '";
    const char* m_SQL_REQUEST_SELECT_ORPHAN_POIS = "SELECT poi_Id FROM belongsto WHERE (belongsto.poicategory_Id NOT IN (SELECT Id FROM poicategory));";
    const char* m_SQL_REQUEST_EXTEND_TABLE_POI = "ALTER TABLE poi ADD COLUMN '";

    const char* m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_ATTRIBUTE_ID = "SELECT a.id+1 FROM poiattribute a WHERE NOT EXISTS (SELECT * FROM poiattribute b WHERE a.id+1 = b.id) ORDER BY a.id";
    const char* m_SQL_REQUEST_INSERT_ATTRIBUTE = "INSERT INTO poiattribute VALUES (";
    const char* m_SQL_REQUEST_DELETE_ATTRIBUTE = "DELETE from poiattribute WHERE id = ";
    const char* m_SQL_REQUEST_CHECK_IF_ATTRIBUTE_ID_EXIST = "SELECT CASE WHEN EXISTS (SELECT * FROM poiattribute WHERE id = ";
    const char* m_SQL_REQUEST_CHECK_IF_ATTRIBUTE_NAME_EXIST = "SELECT CASE WHEN EXISTS (SELECT * FROM poiattribute WHERE name = '";
    const char* m_SQL_REQUEST_CLEAN_UP_ORPHAN_ATTRIBUTES = "DELETE FROM poiattribute WHERE  Id NOT IN (SELECT Id FROM poiattribute WHERE (Id IN (SELECT poiattribute_Id FROM hasattribute)));";

    const char* m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_ICON_ID = "SELECT a.id+1 FROM iconset a WHERE NOT EXISTS (SELECT * FROM iconset b WHERE a.id+1 = b.id) ORDER BY a.id";
    const char* m_SQL_REQUEST_INSERT_ICON = "INSERT INTO iconset VALUES (";
    const char* m_SQL_REQUEST_CLEAN_UP_CATEGORY_ICON = "DELETE from iconset WHERE Id = ";

    const char* m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_HAS_ATTRIBUTE = "SELECT a.id+1 FROM hasattribute a WHERE NOT EXISTS (SELECT * FROM hasattribute b WHERE a.id+1 = b.id) ORDER BY a.id";
    const char* m_SQL_REQUEST_INSERT_HAS_ATTRIBUTE = "INSERT INTO hasattribute VALUES (";
    const char* m_SQL_REQUEST_CLEAN_UP_CATEGORY_HAS_ATTRIBUTE = "DELETE from hasattribute WHERE poicategory_Id = ";

    const char* m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_POI_CATEGORY_KINSHIP = "SELECT a.id+1 FROM poicategorykinship a WHERE NOT EXISTS (SELECT * FROM poicategorykinship b WHERE a.id+1 = b.id) ORDER BY a.id";
    const char* m_SQL_REQUEST_INSERT_POI_CATEGORY_KINSHIP = "INSERT INTO poicategorykinship VALUES (";
    const char* m_SQL_REQUEST_CLEAN_UP_CATEGORY_POI_CATEGORY_KINSHIP = "DELETE from poicategorykinship WHERE childId = ";

    const char* m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_IS_DISPLAYED_HAS = "SELECT a.id+1 FROM isdisplayedas a WHERE NOT EXISTS (SELECT * FROM isdisplayedas b WHERE a.id+1 = b.id) ORDER BY a.id";
    const char* m_SQL_REQUEST_INSERT_IS_DISPLAYED_HAS = "INSERT INTO isdisplayedas VALUES (";
    const char* m_SQL_REQUEST_CLEAN_UP_CATEGORY_IS_DISPLAYED_HAS = "DELETE from isdisplayedas WHERE poicategory_Id = ";

    const char* m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_IS_SHOWN_HAS = "SELECT a.id+1 FROM isshownas a WHERE NOT EXISTS (SELECT * FROM isshownas b WHERE a.id+1 = b.id) ORDER BY a.id";
    const char* m_SQL_REQUEST_INSERT_IS_SHOWN_HAS = "INSERT INTO isshownas VALUES (";
    const char* m_SQL_REQUEST_CLEAN_UP_POI_IS_SHOWN_HAS = "DELETE from isshownas WHERE poi_Id = ";

    const char* m_SQL_REQUEST_GET_AVAILABLE_NEXT_FREE_BELONGS_TO = "SELECT a.id+1 FROM belongsto a WHERE NOT EXISTS (SELECT * FROM belongsto b WHERE a.id+1 = b.id) ORDER BY a.id";
    const char* m_SQL_REQUEST_INSERT_BELONGSTO = "INSERT INTO belongsto (Id,poi_Id,poicategory_Id,poiprovider_Id) VALUES (";
    const char* m_SQL_REQUEST_CLEAN_UP_POI_BELONGSTO = "DELETE from belongsto WHERE poi_Id = ";
    const char* m_SQL_REQUEST_CLEAN_UP_CATEGORY_BELONGSTO = "DELETE from belongsto WHERE poicategory_Id = ";

    const char* m_SQL_REQUEST_GET_POI_PROVIDER_ID = "SELECT Id FROM poiprovider WHERE name=";

    const char* m_SQL_RETURN_BOOL_VALUE = " THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END;";

    Database *mp_database; // database access

    // string conversion to numeric: the third parameter of fromString() should be one of std::hex, std::dec or std::oct
    template <class T>
    bool fromString(T& t, const std::string& s, std::ios_base& (*f)(std::ios_base&))
    {
      std::istringstream iss(s);
      return !(iss >> f >> t).fail();
    }

    void onError();

    SQL_REQUEST_ERRORS checkIfCategoryNameDoesntExist(std::string name);

    SQL_REQUEST_ERRORS checkIfCategoryExist(POIServiceTypes::CategoryID unique_id);

    SQL_REQUEST_ERRORS checkIfAttributeExist(POIServiceTypes::AttributeID unique_id, string name);

    SQL_REQUEST_ERRORS checkIfPoiExist(POIServiceTypes::POI_ID unique_id);

    SQL_REQUEST_ERRORS getFreePoiId(POIServiceTypes::POI_ID &unique_id);

    SQL_REQUEST_ERRORS getFreeCategoryId(POIServiceTypes::CategoryID &unique_id);

    SQL_REQUEST_ERRORS getFreeAttributeId(POIServiceTypes::AttributeID &unique_id);

    SQL_REQUEST_ERRORS getFreeRecordId(const char* request, recordId_t &unique_id);

    SQL_REQUEST_ERRORS getFreeIconId(iconId_t &unique_id);

    void getAvailableArea();

    NavigationTypes::Coordinate2D m_leftBottomLocation,m_rightTopLocation;

};

class PoiManagerServerStub: public POIContentManagerStubDefault {

public:
    PoiManagerServerStub();
    ~PoiManagerServerStub();
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply);
    void setLocale(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _languageCode, std::string _countryCode, std::string _scriptCode, setLocaleReply_t _reply);
    void getLocale(const std::shared_ptr<CommonAPI::ClientId> _client, getLocaleReply_t _reply);
    void getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedLocalesReply_t _reply);
    void getAvailableCategories(const std::shared_ptr<CommonAPI::ClientId> _client, getAvailableCategoriesReply_t _reply);
    void getRootCategory(const std::shared_ptr<CommonAPI::ClientId> _client, getRootCategoryReply_t _reply);
    void getChildrenCategories(const std::shared_ptr<CommonAPI::ClientId> _client, POIServiceTypes::CategoryID _category, getChildrenCategoriesReply_t _reply);
    void getParentCategories(const std::shared_ptr<CommonAPI::ClientId> _client, POIServiceTypes::CategoryID _category, getParentCategoriesReply_t _reply);
    void createCategory(const std::shared_ptr<CommonAPI::ClientId> _client, POIServiceTypes::CAMCategory _category, createCategoryReply_t _reply);
    void removeCategories(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< POIServiceTypes::CategoryID> _categories, removeCategoriesReply_t _reply);
    void addPOIs(const std::shared_ptr<CommonAPI::ClientId> _client, POIServiceTypes::CategoryID _unique_id, std::vector< POIServiceTypes::PoiAddedDetails> _poiList, addPOIsReply_t _reply);
    void removePOIs(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< POIServiceTypes::POI_ID> _ids, removePOIsReply_t _reply);

    void run();

    bool initDatabase(const char* poiDatabaseFileName);


private:
    NavigationTypes::Version m_version;
    std::string m_languageCode, m_countryCode, m_scriptCode;

    uint16_t m_availableCategories;
    vector<poi_category_common_t> m_availableCategoryTable;
    POIServiceTypes::CategoryID m_rootCategory;
    NavigationTypes::Coordinate3D m_centerLocation;

    sqlRequest* mp_sqlRequest;
    void refreshCategoryList();

    // string conversion to numeric: the third parameter of fromString() should be one of std::hex, std::dec or std::oct
    template <class T>
    bool fromString(T& t, const std::string& s, std::ios_base& (*f)(std::ios_base&))
    {
      std::istringstream iss(s);
      return !(iss >> f >> t).fail();
    }

    bool test();
};

#endif /* POIMANAGERSERVERSTUBIMPL_H_ */
