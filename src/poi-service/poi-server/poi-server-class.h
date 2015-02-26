/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-server-class.h
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
#ifndef POIPOCSERVERCLASS_H
#define POIPOCSERVERCLASS_H

#include "../../../api/include/genivi-mapviewer-constants.h"
#include "../../../api/include/genivi-navigationcore-constants.h"
#include "../../../api/include/genivi-poiservice-constants.h"
#include "../../../api/include/genivi-poiservice-poisearch_adaptor.h"
#include "../../../api/include/genivi-poiservice-poicontentaccess_adaptor.h"
#include "../../../api/include/genivi-navigationcore-routing_proxy.h"
#include "../../../api/include/genivi-poiservice-contentaccessmodule_proxy.h"
#include "../poi-common/common-data-model.h"
#include <dbus-c++/glib-integration.h>

#include "poi-datamodel.h"
#include "database.h"


// string conversion to numeric: the third parameter of fromString() should be one of std::hex, std::dec or std::oct
template <class T>
bool fromString(T& t, const std::string& s, std::ios_base& (*f)(std::ios_base&))
{
  std::istringstream iss(s);
  return !(iss >> f >> t).fail();
}


using namespace DBus;
using namespace Glib;

class Routing;
class contentAccessModule;
class poiSearchServer;
class poiContentAccessServer;

class Routing
: public org::genivi::navigationcore::Routing_proxy,
  public DBus::IntrospectableProxy,
  public DBus::ObjectProxy
{
    public:

    Routing(DBus::Connection &connection);

    ~Routing();

    void RouteDeleted(const uint32_t& routeHandle);

    void RouteCalculationCancelled(const uint32_t& routeHandle);

    void RouteCalculationSuccessful(const uint32_t& routeHandle, const std::map< uint16_t, uint16_t >& unfullfilledPreferences);

    void RouteCalculationFailed(const uint32_t& routeHandle, const uint16_t& errorCode,const std::map< uint16_t, uint16_t >& unfullfilledPreferences);

    void RouteCalculationProgressUpdate(const uint32_t& routeHandle, const uint16_t& status, const uint8_t& percentage);

    void AlternativeRoutesAvailable (const std::vector<uint32_t>& routeHandlesList);

};

class  contentAccessModule
: public org::genivi::poiservice::POIContentAccessModule_proxy,
  public DBus::IntrospectableProxy,
  public DBus::ObjectProxy
{

public:

    contentAccessModule(DBus::Connection &connection, const std::string& service);

    ~contentAccessModule();

private:

};

class  poiContentAccessServer
: public org::genivi::poiservice::POIContentAccess_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
    enum {
        INVALID_HANDLE = 0xFF,
        VALID_HANDLE = 1 //the POC manages only one handle !
    } CONSTANTS;

public:

    poiContentAccessServer(DBus::Connection &connection);

    ~poiContentAccessServer();

    void ConnectTopoiSearchServer(poiSearchServer *poiSearch);

    //connection to the DBus proxy clients

    void ConnectTocontentAccessModuleClient(contentAccessModule *client);

    // DBus methods

    uint8_t RegisterContentAccessModule(const std::string& moduleName);

    void UnRegisterContentAccessModule(const uint8_t& camId);

    void RegisterPoiCategories(const uint8_t& camId, const std::vector< uint16_t >& poiCategories);

    std::vector< uint16_t > AddCategories(const uint8_t& camId, const std::vector< DBus_CAMcategory::DBus_CAMcategory_t >& poiCategories);

    void UpdateCategories(const uint8_t& camId, const std::vector< DBus_CAMcategoryUpdate::DBus_CAMcategoryUpdate_t >& poiCategories);

    void RemoveCategories(const uint8_t& camId, const std::vector< uint16_t >& poiCategories);

// Specific methods

    bool GetRegisteredContentAccessModule(cam_t *cam);

    bool GetRegisteredCategories(uint8_t camId, std::vector< DBus_categoryIdName::DBus_categoryIdName_t > *categoryList);

    bool GetRegisteredCategoriesDetails(uint8_t camId, std::vector<DBus_category> *categoryList);

    void ResetRegisteredSearchCategoriesFlags(uint8_t camId);

    void ResetRegisteredAttributeCategoriesFlags(uint8_t camId);

    void SetRegisteredSearchCategory(uint8_t camId,DBus_categoryRadius::categoryRadius_t category);

    void SetRegisteredAttributeCategoryFlag(uint8_t camId,uint32_t categoryId, std::string attributeName, uint16_t attributeId);

    void SetLanguage(std::string LanguageCode, std::string CountryCode);

    uint16_t searchAroundALocation(DBus_geoCoordinate3D::geoCoordinate3D_t location,const std::string* inputString, uint16_t sortOption);

    void SetPoiSearchHandle(uint32_t poiSearchHandle);

    void ResetPoiSearchHandle();

    void PoiSearchCanceled(uint32_t poiSearchHandle);

    DBus_poiCAMDetails::DBus_poiCAMDetails_t GetResultPoi(uint16_t index);

    DBus_searchResultDetails::DBus_searchResultDetails_t GetPoiDetails(uint32_t id);

    bool isAttributeAvailable(std::string attributeName);

    bool removeCategoryFromTables(uint16_t id);

private:

    // data conversion routines

    DBus::Variant createVariantString(std::string str);

    DBus::Variant createVariantUint16(uint16_t value);

    void sendDBusError(const char* message);

    uint32_t m_poiSearchHandle; // the POC is limited to the management of one handle !

    contentAccessModule *mp_contentAccessModule;
    poiSearchServer *mp_poiSearch;
    ::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > m_version;
    std::string m_camName;
    uint8_t m_camId;
    contentAccessModule *mp_clientcontentAccessModule;
    std::vector< poi_category_t > m_poiCategoriesRegistered;
    std::vector< poi_category_t > m_poiCategoriesAdded;

    //DBus data
    std::vector< DBus_poiCAMDetails::DBus_poiCAMDetails_t > m_poiTable;
    std::vector< DBus_searchResultDetails::DBus_searchResultDetails_t > m_poiDetailsTable;
    std::vector< DBus_categoryRadius::DBus_categoryRadius_t > m_poiCategories;
    std::vector< DBus_attributeDetails::DBus_attributeDetails_t > m_poiAttributes;

};

class  poiSearchServer
: public org::genivi::poiservice::POISearch_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
    enum {
        INVALID_HANDLE = 0xFF,
        VALID_HANDLE = 1 //the POC manages only one handle !
    } CONSTANTS;

public:

    poiSearchServer(DBus::Connection &connection, const char* poiDatabaseFileName, poiContentAccessServer* poiContentAccess);

    ~poiSearchServer();


//connection to the DBus proxy clients

    void ConnectToRoutingClient(Routing *client);


//implementation of the DBus methods of the POISearch component

    DBus_version::DBus_version_t GetVersion();

    void GetLanguage(std::string& languageCode, std::string& countryCode);

    void SetLanguage(const std::string& languageCode, const std::string& countryCode);

    std::vector< ::DBus::Struct< uint16_t, bool > > ValidateCategories(const std::vector< uint16_t >& categories);

    std::vector< DBus_categoryIdName::DBus_categoryIdName_t > GetAvailableCategories();

    uint16_t GetRootCategory();

    std::vector< DBus_categoryId::DBus_categoryId_t > GetChildrenCategories(const uint16_t& category);

    std::vector< DBus_categoryId::DBus_categoryId_t > GetParentCategories(const uint16_t& category);

    std::vector< DBus_category::DBus_category_t > GetCategoriesDetails(const std::vector< uint16_t >& categories);

    uint32_t CreatePoiSearchHandle();

    void DeletePoiSearchHandle(const uint32_t& poiSearchHandle);

    void SetRouteHandle(const uint32_t& poiSearchHandle, const uint8_t& sessionHandle, const uint8_t& routeHandle, const uint32_t& startSearchOffset, const uint32_t& endSearchOffset);

    void SetCategories(const uint32_t& poiSearchHandle, const std::vector< DBus_categoryRadius::DBus_categoryRadius_t >& poiCategories);

    void SetAttributes(const uint32_t& poiSearchHandle, const std::vector< DBus_attributeDetails::DBus_attributeDetails_t >& poiAttributes);

    void StartPoiSearch(const uint32_t& poiSearchHandle, const std::string& inputString, const uint16_t& sortOption);

    void CancelPoiSearch(const uint32_t& poiSearchHandle);

    void SetCenter(const uint32_t& poiSearchHandle, const DBus_geoCoordinate3D::DBus_geoCoordinate3D_t& location);

    void StartPoiProximityAlert(const uint32_t& poiSearchHandle, const std::string& inputString, const uint16_t& sortOption);

    void CancelPoiProximityAlert(const uint32_t& poiSearchHandle);

    void RequestResultList(const uint32_t& poiSearchHandle, const uint16_t& offset, const uint16_t& maxWindowSize, const std::vector< std::string >& attributes, uint16_t& statusValue, uint16_t& resultListSize, std::vector< DBus_searchResult::DBus_searchResult_t >& resultListWindow);

    std::vector< DBus_searchResultDetails::DBus_searchResultDetails_t > GetPoiDetails(const std::vector< uint32_t >& id);

private:

// data conversion routines

    DBus::Variant createVariantString(std::string str);

    DBus::Variant createVariantUint16(uint16_t value);

// error management

    void sendDBusError(const char* message);
    void onError();

// search routines

    uint16_t searchAroundALocation(DBus_geoCoordinate3D::geoCoordinate3D_t location,const std::string* inputString);

    uint16_t searchPOIRequest(uint16_t categoryIndex, std::string search_string,DBus_geoCoordinate3D::geoCoordinate3D_t left_bottom_location,DBus_geoCoordinate3D::geoCoordinate3D_t right_top_location);

// category and attribute routines

    bool isCategoryAvailable(uint16_t id, uint16_t *category_id);

    bool isAllCategoriesSelected(uint16_t* index);

    bool isAttributeRequired(std::string attribute,std::vector< std::string > attributes);

// geometrical routines

    uint32_t calculateDistance(const DBus_geoCoordinate3D::geoCoordinate3D_t origin, const DBus_geoCoordinate3D::geoCoordinate3D_t target);

    double calculateAngle(const uint32_t radius);

    bool calculateLineCoefficient(double* a,double* b,const DBus_geoCoordinate3D::geoCoordinate3D_t pointA,const DBus_geoCoordinate3D::geoCoordinate3D_t pointB);

    uint32_t calculateOrthoDistance(const double a,const double b,const DBus_geoCoordinate3D::geoCoordinate3D_t pointP);

// private data

// DBus data
    DBus_version m_version;
    std::string m_languageCode, m_countryCode;
    uint32_t m_poiSearchHandle; // the POC is limited to the management of one handle !
    uint16_t m_rootCategory;
    uint8_t m_sessionHandle;
    uint32_t m_routeHandle;
    uint16_t m_startSearchOffset;
    uint16_t m_endSearchOffset;
    ushort m_searchStatus;
    uint32_t m_totalNumberOfSegments;
    Routing *mp_Routing;
    poiContentAccessServer *mp_poiContentAccess;

    uint16_t m_totalSize;

    DBus_geoCoordinate3D::geoCoordinate3D_t m_centerLocation;
    bool m_poiSearchProximity; // boolean set if search for proximity is chosen
    DBus::Connection *mp_dbusConnection;

// buffers
    std::vector<poi_t> m_poiTable;
    std::vector<route_vector_t> m_route;

// database access
    Database *mp_database;
    DBus_geoCoordinate3D::geoCoordinate3D_t m_leftBottomLocation;
    DBus_geoCoordinate3D::geoCoordinate3D_t m_rightTopLocation;

// category and attribute management
    uint16_t m_availableCategories;
    poi_category_t m_availableCategoryTable[MAX_CATEGORIES];
};


#endif // POIPOCSERVERCLASS_H
