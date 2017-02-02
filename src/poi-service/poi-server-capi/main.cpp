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

#include <CommonAPI/CommonAPI.hpp>
#include <CommonTypes.hpp>
#include <NavigationTypes.hpp>
#include <NavigationCoreTypes.hpp>
#include <POISearchStubDefault.hpp>
#include <POIContentAccessStubDefault.hpp>
#include <POIConfigurationStubDefault.hpp>
#include <POIContentAccessModuleProxy.hpp>
#include <RoutingProxy.hpp>

#include "poi-common-database.h"
#include "poi-common-data-model.h"
#include "poi-datamodel.h"

using namespace v4::org::genivi::navigation::navigationcore;
using namespace v4::org::genivi::navigation::poiservice;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

// string conversion to numeric: the third parameter of fromString() should be one of std::hex, std::dec or std::oct
template <class T>
bool fromString(T& t, const std::string& s, std::ios_base& (*f)(std::ios_base&))
{
  std::istringstream iss(s);
  return !(iss >> f >> t).fail();
}

static std::shared_ptr < CommonAPI::Runtime > runtime;
static const std::string domain = "local";

class  POISearchServerStub;

class RoutingClientProxy
{
    public:

    std::shared_ptr<RoutingProxyDefault> myServiceRouting;

    RoutingClientProxy(const std::string domain, const std::string instance)
    {
        myServiceRouting = runtime->buildProxy<RoutingProxy>(domain, instance);

// not working correctly (blocked) so removed for the moment
//        while (!myServiceEnhancedPosition->isAvailable()) {
//            usleep(10);
//        }
    }

    void setListeners()
    {
        myServiceRouting->getRouteDeletedEvent().subscribe([&](const uint32_t& routeHandle) {
            routeDeleted(routeHandle);});
        myServiceRouting->getRouteCalculationCancelledEvent().subscribe([&](const uint32_t& routeHandle) {
            routeCalculationCancelled(routeHandle);});
        myServiceRouting->getRouteCalculationSuccessfulEvent().subscribe([&](const uint32_t& routeHandle, const Routing::UnfullfilledRoutePreference& unfullfilledPreferences) {
            routeCalculationSuccessful(routeHandle,unfullfilledPreferences);});
        myServiceRouting->getRouteCalculationFailedEvent().subscribe([&](const uint32_t& routeHandle, const Routing::CalculationError errorCode, const Routing::UnfullfilledRoutePreference& unfullfilledPreferences) {
            routeCalculationFailed(routeHandle,errorCode,unfullfilledPreferences);});
        myServiceRouting->getRouteCalculationProgressUpdateEvent().subscribe([&](const uint32_t& routeHandle, const Routing::CalculationStatus& status, const uint8_t& percentage) {
            routeCalculationProgressUpdate(routeHandle,status,percentage);});
        myServiceRouting->getAlternativeRoutesAvailableEvent().subscribe([&](const std::vector<NavigationTypes::Handle>& routeHandlesList) {
            alternativeRoutesAvailable(routeHandlesList);});
    }

    void routeDeleted(const uint32_t& routeHandle)
    {

    }

    void routeCalculationCancelled(const uint32_t& routeHandle)
    {

    }

    void routeCalculationSuccessful(const uint32_t& routeHandle, const Routing::UnfullfilledRoutePreference& unfullfilledPreferences)
    {

    }

    void routeCalculationFailed(const uint32_t& routeHandle, const Routing::CalculationError& errorCode,const Routing::UnfullfilledRoutePreference& unfullfilledPreferences)
    {

    }

    void routeCalculationProgressUpdate(const uint32_t& routeHandle, const Routing::CalculationStatus& status, const uint8_t& percentage)
    {

    }

    void alternativeRoutesAvailable (const std::vector<NavigationTypes::Handle>& routeHandlesList)
    {

    }

};

class  POIContentAccessModuleClientProxy
{

public:

    std::shared_ptr<POIContentAccessModuleProxyDefault> myServicePOIContentAccessModule;

    POIContentAccessModuleClientProxy(const std::string domain, const std::string instance, const std::string& service)
    {
        myServicePOIContentAccessModule = runtime->buildProxy<POIContentAccessModuleProxy>(domain, instance);

// not working correctly (blocked) so removed for the moment
//        while (!myServiceEnhancedPosition->isAvailable()) {
//            usleep(10);
//        }
    }

    void setListeners()
    {
        myServicePOIContentAccessModule->getConfigurationChangedEvent().subscribe([&](const std::vector< POIServiceTypes::Settings >& changedSettings) {
            configurationChanged(changedSettings);});
        myServicePOIContentAccessModule->getCategoriesRemovedEvent().subscribe([&](const std::vector< CommonTypes::CategoryID >& categories) {
            categoriesRemoved(categories);});
        myServicePOIContentAccessModule->getPOIAddedEvent().subscribe([&](const std::vector< POIServiceTypes::POI_ID >& pois) {
            POIAdded(pois);});
        myServicePOIContentAccessModule->getPOIRemovedEvent().subscribe([&](const std::vector< POIServiceTypes::POI_ID >& pois) {
            POIRemoved(pois);});
        myServicePOIContentAccessModule->getSearchStatusChangedEvent().subscribe([&](const NavigationTypes::Handle& poiSearchHandle, const POIServiceTypes::SearchStatusState& statusValue, const std::vector< POIServiceTypes::POI_ID >& pois) {
            searchStatusChanged(poiSearchHandle,statusValue,pois);});
    }

    void configurationChanged(const std::vector< POIServiceTypes::Settings >& changedSettings)
    {

    }

    void categoriesRemoved(const std::vector< CommonTypes::CategoryID >& categories)
    {

    }

    void POIAdded(const std::vector< POIServiceTypes::POI_ID >& pois)
    {

    }

    void POIRemoved(const std::vector< POIServiceTypes::POI_ID >& pois)
    {

    }

    void searchStatusChanged(const NavigationTypes::Handle& poiSearchHandle, const POIServiceTypes::SearchStatusState& statusValue, const std::vector< POIServiceTypes::POI_ID >& pois)
    {

    }

private:

};

class  POIContentAccessServerStub
: public POIContentAccessStubDefault
{
    enum {
        INVALID_HANDLE = 0xFF,
        VALID_HANDLE = 1 //the POC manages only one handle !
    } CONSTANTS;

public:

    POIContentAccessServerStub();

    ~POIContentAccessServerStub();

    void ConnectToPOISearchServer(std::shared_ptr<POISearchServerStub> poiSearch);

    void ConnectTocontentAccessModuleClient(POIContentAccessModuleClientProxy *client);

    /**
     * description: Register to the POI provider module          When the CAM registers, it
     *   provides a name and then get a unique id. This id must be used everytime the
     *   CAM communicates with the POI service component.         After the
     *   registration is done, the CAM can start to update POI categories and POI
     *   attributes as well as registers POI categories to search for.
     */
    void registerContentAccessModule(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _moduleName, registerContentAccessModuleReply_t _reply);

    /**
     * description: Remove CAM from POI provider module.
     */
    void unRegisterContentAccessModule(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, unRegisterContentAccessModuleReply_t _reply);

    /**
     * description: Register to the POI provider module the categories you can search for POI.
     *      The categories could be predifined one or customized ones. In order to
     *   register a customized category, you might need to create it before and add it
     *   to the POI service component.
     */
    void registerPoiCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _poiCategories, registerPoiCategoriesReply_t _reply);

    /**
     * description: Update categories in the POI service component. It could be a predifined or a
     *   customed one.         The CAM provides for each categories the list of
     *   attributes (mandatories like name or optional) it wants to update.
     *   Depending on the local database write policy, the CAM might only be able to
     *   update customized attributes for a category and not the predefined ones so
     *   some update could be rejected.
     */
    void updateCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::CAMCategoryUpdate> _poiCategories, updateCategoriesReply_t _reply);

    /**
     * description: Add new categories to the POI service component.         The CAM provides for
     *   each categories the name, the parent categories, the top level attribute, the
     *   list of attributes, the icons, ...  .
     */
    void addCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::CAMCategory> _poiCategories, addCategoriesReply_t _reply);

    /**
     * description: Remove categories from the POI service component. It could be a predifined or a
     *   customed one.         Depending on the local database write policy, the CAM
     *   might only not be able to remove some categories.
     */
    void removeCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _poiCategories, removeCategoriesReply_t _reply);


// Specific methods

    bool GetRegisteredContentAccessModule(camIdName_t *cam);

    bool GetRegisteredCategories(POIServiceTypes::ContentAccessModuleID camId, std::vector< POIServiceTypes::CategoryAndName > *categoryList);

    bool GetRegisteredCategoriesDetails(POIServiceTypes::ContentAccessModuleID camId, std::vector<POIServiceTypes::Category> *categoryList);

    void ResetRegisteredSearchCategoriesFlags(POIServiceTypes::ContentAccessModuleID camId);

    void ResetRegisteredAttributeCategoriesFlags(POIServiceTypes::ContentAccessModuleID camId);

    void SetRegisteredSearchCategory(POIServiceTypes::ContentAccessModuleID camId, POIServiceTypes::CategoryAndRadius category);

    void SetRegisteredAttributeCategoryFlag(POIServiceTypes::ContentAccessModuleID camId, CommonTypes::CategoryID categoryId, POIServiceTypes::AttributeID attributeId);

    void SetLocale(std::string languageCode, std::string countryCode, std::string scriptCode);

    uint16_t searchAroundALocation(NavigationTypes::Coordinate3D location, const std::string* inputString, POIServiceTypes::SortOption sortOption);

    void SetPoiSearchHandle(NavigationTypes::Handle poiSearchHandle);

    void ResetPoiSearchHandle();

    void PoiSearchCanceled(NavigationTypes::Handle poiSearchHandle);

    POIServiceTypes::PoiCAMDetails GetResultPoi(uint16_t index);

    POIServiceTypes::SearchResultDetails GetPoiDetails(POIServiceTypes::POI_ID id);

    bool isAttributeAvailable(POIServiceTypes::AttributeID attributeId);

    bool removeCategoryFromTables(CommonTypes::CategoryID id);

private:

    // data conversion routines

    uint32_t m_poiSearchHandle; // the POC is limited to the management of one handle !

    POIContentAccessModuleClientProxy *mp_contentAccessModule;
    std::shared_ptr<POISearchServerStub> mp_poiSearch;
    CommonTypes::Version m_version;
    std::string m_camName;
    POIServiceTypes::ContentAccessModuleID m_camId;
    POIContentAccessModuleClientProxy *mp_clientcontentAccessModule;
    std::vector< poi_category_t > m_poiCategoriesRegistered;
    std::vector< poi_category_t > m_poiCategoriesAdded;

    //DBus data
    std::vector< POIServiceTypes::PoiCAMDetails > m_poiTable;
    std::vector< POIServiceTypes::SearchResultDetails > m_poiDetailsTable;
    std::vector< POIServiceTypes::CategoryAndRadius > m_poiCategories;
    std::vector< POIServiceTypes::AttributeDetails > m_poiAttributes;

};

class  POISearchServerStub
: public POISearchStubDefault
{
    enum {
        INVALID_HANDLE = 0xFF,
        VALID_HANDLE = 1 //the POC manages only one handle !
    } CONSTANTS;

public:

    POISearchServerStub();

    ~POISearchServerStub();

    void InitDatabase(const char* poiDatabaseFileName);

    void ConnectToContentAccessServer(std::shared_ptr<POIContentAccessServerStub> poiContentAccess);

    void ConnectToRoutingClient(RoutingClientProxy *client);

    /**
     * description: This method returns the API version implemented by the content access module.
     */
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply);

    /**
     * description: This method allows the application to validate that POI categories are
     *   supported by the POI component and the Content access modules.
     */
    void validateCategories(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _categories, validateCategoriesReply_t _reply);

    /**
     * description: This method retrieves the list od POI categories available (pre-defined and
     *   custom).
     */
    void getAvailableCategories(const std::shared_ptr<CommonAPI::ClientId> _client, getAvailableCategoriesReply_t _reply);

    /**
     * description: Get the root category id. That would be ALL_CATEGORIES.
     */
    void getRootCategory(const std::shared_ptr<CommonAPI::ClientId> _client, getRootCategoryReply_t _reply);

    /**
     * description: Get the children categories id and type (top level) from the a parent unique id.
     */
    void getChildrenCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::CommonTypes::CategoryID _category, getChildrenCategoriesReply_t _reply);

    /**
     * description: Get the parent categories id and type (top level) from the a unique id.
     */
    void getParentCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::CommonTypes::CategoryID _category, getParentCategoriesReply_t _reply);

    /**
     * description: Get the categories that are marked with the given standard category.
     */
    void getCategoriesWithStandardCategoryId(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::StandardCategory _standardCategoryId, getCategoriesWithStandardCategoryIdReply_t _reply);

    /**
     * description: This method retrieves the details associated to one or more POI categories.
     *       It contains the name, the parent categories, the top level attribute, the
     *   list of attributes, the icons, ... .
     */
    void getCategoriesDetails(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _categories, getCategoriesDetailsReply_t _reply);

    /**
     * description: This method creates a new search input and retrieves a handle .
     */
    void createPoiSearchHandle(const std::shared_ptr<CommonAPI::ClientId> _client, createPoiSearchHandleReply_t _reply);

    /**
     * description: This method deletes a search input and its associated resources.
     */
    void deletePoiSearchHandle(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, deletePoiSearchHandleReply_t _reply);

    /**
     * description: This method sets the location to start the search around.         If a route
     *   handle was defined before, it will be replaced by this location.
     */
    void setCenter(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, ::v4::org::genivi::navigation::NavigationTypes::Coordinate3D _location, setCenterReply_t _reply);

    /**
     * description: This method allows to start a POI search along a guided route.         The
     *   route handle must be valid or the POI search will failed.         If a search
     *   location was defined before, it will be replaced by the route.
     */
    void setRouteHandle(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, uint32_t _startSearchOffset, uint32_t _endSearchOffset, setRouteHandleReply_t _reply);

    /**
     * description: This method sets the POI categories for the current search input and the
     *   corresponding result-lists for the current session .
     */
    void setCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::CategoryAndRadius> _poiCategories, setCategoriesReply_t _reply);

    /**
     * description: This method set POI attributes (optional) for the current search input and the
     *   corresponding result-lists for the current session         An attribute is
     *   attached to a category.
     */
    void setAttributes(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::AttributeDetails> _poiAttributes, setAttributesReply_t _reply);

    /**
     * description: This method sends the search input for the search handle.         The search
     *   will start with the either the location or the route handle.         If no
     *   positon or route handle were configured, the search will use the vehicle
     *   position are center location.
     */
    void startPoiSearch(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, std::string _inputString, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::SortOption _sortOption, startPoiSearchReply_t _reply);

    /**
     * description: This method cancels the search for the current session.
     */
    void cancelPoiSearch(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, cancelPoiSearchReply_t _reply);

    /**
     * description: This method starts to check for POI aound vehicle according to the criteria
     *   defined with the unique handle.         By default, it will search for POI
     *   around vehicle position with default radius defined for each categories.
     *     If a route handle was defined, it will search along the route with default
     *   categorie's radius.
     */
    void startPoiProximityAlert(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, std::string _inputString, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::SortOption _sortOption, startPoiProximityAlertReply_t _reply);

    /**
     * description: This method cancels the search for the current session.
     */
    void cancelPoiProximityAlert(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, cancelPoiProximityAlertReply_t _reply);

    /**
     * description: This method gets the poi result list (e.g. after a Search/Scroll call) .
     */
    void requestResultList(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, uint16_t _offset, uint16_t _maxWindowSize, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::AttributeID> _attributeList, requestResultListReply_t _reply);
    /**
     * description: This method retrieves the details associated to one or more POI.         It
     *   contains the name, the parent categories, the list of attributes, the icons,
     *   ... ..
     */
    void getPoiDetails(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::POI_ID> _id, getPoiDetailsReply_t _reply);

    // Specific methods

    void SetLocale(std::string languageCode, std::string countryCode, std::string scriptCode);


private:

// error management

    void onError();

// search routines

    uint16_t searchAroundALocation(NavigationTypes::Coordinate3D location,const std::string* inputString);

    uint16_t searchPOIRequest(uint16_t categoryIndex, std::string search_string, NavigationTypes::Coordinate3D left_bottom_location, NavigationTypes::Coordinate3D right_top_location);

// category and attribute routines

    bool isCategoryAvailable(categoryId_t id, categoryId_t *categoryId_t);

    bool isAllCategoriesSelected(uint16_t* index);

    bool isAttributeRequired(POIServiceTypes::AttributeID attribute, std::vector<POIServiceTypes::AttributeID> attributes);

// geometrical routines

    uint32_t calculateDistance(const NavigationTypes::Coordinate3D origin, const NavigationTypes::Coordinate3D target);

    double calculateAngle(const uint32_t radius);

    bool calculateLineCoefficient(double* a, double* b, const NavigationTypes::Coordinate3D pointA, const NavigationTypes::Coordinate3D pointB);

    uint32_t calculateOrthoDistance(const double a,const double b,const NavigationTypes::Coordinate3D pointP);

// private data

// DBus data
    CommonTypes::Version m_version;
    std::string m_languageCode, m_countryCode, m_scriptCode;
    NavigationTypes::Handle m_poiSearchHandle; // the POC is limited to the management of one handle !
    CommonTypes::CategoryID m_rootCategory;
    uint8_t m_sessionHandle;
    NavigationTypes::Handle m_routeHandle;
    uint16_t m_startSearchOffset;
    uint16_t m_endSearchOffset;
    POIServiceTypes::SearchStatusState m_searchStatus;
    uint32_t m_totalNumberOfSegments;
    RoutingClientProxy *mp_Routing;
    std::shared_ptr<POIContentAccessServerStub> mp_poiContentAccess;

    uint16_t m_totalSize;

    NavigationTypes::Coordinate3D m_centerLocation;
    bool m_poiSearchProximity; // boolean set if search for proximity is chosen

// buffers
    std::vector<poi_t> m_poiTable;
    std::vector<route_vector_t> m_route;

// database access
    Database *mp_database;
    NavigationTypes::Coordinate3D m_leftBottomLocation;
    NavigationTypes::Coordinate3D m_rightTopLocation;

// category and attribute management
    uint16_t m_availableCategories;
    poi_category_t m_availableCategoryTable[MAX_CATEGORIES];
};

typedef struct  {
    const char *c3;
    const char *c2;
} map32_t;

static const map32_t language_map[] = {
    {"deu","de"},
    {"eng","en"},
    {"fra","fr"},
    {"jpn","jp"},
};

static const map32_t country_map[] = {
    {"CHE","CH"},
    {"DEU","DE"},
    {"FRA","FR"},
    {"USA","US"},
    {"JPN","JP"},
};

class  POIConfigurationServerStub
: public POIConfigurationStubDefault
{

public:

    POIConfigurationServerStub();

    ~POIConfigurationServerStub();

    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply);
    void setLocale(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _languageCode, std::string _countryCode, std::string _scriptCode, setLocaleReply_t _reply);
    void getLocale(const std::shared_ptr<CommonAPI::ClientId> _client, getLocaleReply_t _reply);
    void getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedLocalesReply_t _reply);
    void setTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, NavigationTypes::TimeFormat _format, setTimeFormatReply_t _reply);
    void getTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getTimeFormatReply_t _reply);
    void getSupportedTimeFormats(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedTimeFormatsReply_t _reply);
    void setCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, POIConfiguration::CoordinatesFormat _coordinatesFormat, setCoordinatesFormatReply_t _reply);
    void getCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getCoordinatesFormatReply_t _reply);
    void getSupportedCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedCoordinatesFormatReply_t _reply);
    void setUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, POIConfiguration::UnitsOfMeasurement _unitsOfMeasurementList, setUnitsOfMeasurementReply_t _reply);
    void getUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getUnitsOfMeasurementReply_t _reply);
    void getSupportedUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedUnitsOfMeasurementReply_t _reply);

// specific methods

    void ConnectToPOISearchServer(std::shared_ptr<POISearchServerStub> poiSearch);

private:
    std::shared_ptr<POISearchServerStub> mp_poiSearch;
    CommonTypes::Version m_version;
    POIConfiguration::UnitsOfMeasurement m_unitsOfMeasurement;
    POIConfiguration::UnitsOfMeasurementList m_SupportedUnitsOfMeasurement;
    std::vector< NavigationTypes::Locale> m_SupportedLocales;
    std::string m_languageCode, m_countryCode, m_scriptCode;
    NavigationTypes::TimeFormat m_timeFormat;
    std::vector<NavigationTypes::TimeFormat> m_SupportedTimeFormats;
    POIConfiguration::CoordinatesFormat m_coordinatesFormat;
    std::vector<POIConfiguration::CoordinatesFormat> m_SupportedCoordinatesFormats;
};

// SQL requests
static const char* SQL_REQUEST_GET_AVAILABLE_CATEGORIES = "SELECT Id,name FROM poicategory WHERE Id IN (SELECT poicategory_Id FROM belongsto GROUP BY poicategory_Id);";
static const char* SQL_REQUEST_GET_CATEGORY_ATTRIBUTES = "SELECT Id,name FROM poiattribute WHERE Id IN (SELECT poiattribute_Id FROM hasattribute WHERE poicategory_Id IS ";
static const char* SQL_REQUEST_GET_AVAILABLE_AREA = "SELECT leftlongitude,bottomlatitude,rightlongitude,toplatitude FROM availablearea;";
static const char* SQL_REQUEST_GET_PARENT_CATEGORIES = "SELECT parentId FROM poicategorykinship WHERE childId IS ";
static const char* SQL_REQUEST_GET_CHILD_CATEGORIES = "SELECT childId FROM poicategorykinship WHERE parentId IS ";
static const char* SQL_REQUEST_GET_CATEGORY_ICONS = "SELECT url,format FROM iconset WHERE Id IS (SELECT iconset_Id FROM isdisplayedas WHERE poicategory_Id IS  ";

// class  poiContentAccessServer

POIContentAccessServerStub::POIContentAccessServerStub()
{
    //version is hard coded
    m_version.setVersionMajor(3);
    m_version.setVersionMinor(0);
    m_version.setVersionMicro(0);
    m_version.setDate("21-01-2014");
    m_camName = "";
    m_camId = INVALID_HANDLE;
    mp_clientcontentAccessModule = NULL;
    m_poiSearchHandle = INVALID_HANDLE;
    m_poiCategoriesAdded.clear();
    m_poiCategoriesRegistered.clear();
}

POIContentAccessServerStub::~POIContentAccessServerStub()
{
    if (mp_clientcontentAccessModule)
	delete(mp_clientcontentAccessModule);
}

void POIContentAccessServerStub::registerContentAccessModule(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _moduleName, registerContentAccessModuleReply_t _reply)
{
    // the POC is limited to the management of one CAM !
    if (m_camId != INVALID_HANDLE)
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {
        m_camName = _moduleName;
        m_camId = CAM_ID;

        // create a client for contentAccessModule
        const std::string instancePOIContentAccessModule = "POIContentAccessModule";
        mp_clientcontentAccessModule = new POIContentAccessModuleClientProxy(domain,instancePOIContentAccessModule,_moduleName);
        mp_clientcontentAccessModule->setListeners();

        // connect it to the POISearch server
        ConnectTocontentAccessModuleClient(mp_clientcontentAccessModule);
    }
    _reply(m_camId);
}

void POIContentAccessServerStub::unRegisterContentAccessModule(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, unRegisterContentAccessModuleReply_t _reply)
{
    if ((m_camId == INVALID_HANDLE) || (_camId != m_camId))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
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

void POIContentAccessServerStub::registerPoiCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _poiCategories, registerPoiCategoriesReply_t _reply)
{
    std::vector< POIServiceTypes::CategoryAndReason > poiCategoriesAndReason;
    POIServiceTypes::CategoryAndReason categoryAndReason;
    size_t category_index;

    if ((m_camId == INVALID_HANDLE) || (_camId != m_camId))
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {
        if (m_poiCategoriesRegistered.size() < MAX_CATEGORIES)
        { //limitation of categories managed
            for (category_index=0;category_index<_poiCategories.size();category_index++)
            {
                if (_poiCategories.at(category_index) == (m_poiCategoriesAdded.at(category_index).id))
                { //category id has been added before, so register it
                    m_poiCategoriesRegistered.push_back(m_poiCategoriesAdded.at(category_index));
                    categoryAndReason.setUnique_id(m_poiCategoriesAdded.at(category_index).id);
                    categoryAndReason.setReason(POIServiceTypes::UpdateReason::ATTR_ADDED);
                    poiCategoriesAndReason.push_back(categoryAndReason);
                }
            }
            mp_poiSearch->fireCategoriesUpdatedEvent(poiCategoriesAndReason);
        }
        else
           throw DBus::ErrorFailed("org.genivi.poiprovider.poiContentAccess.Error.CAMCategoryNotAvailable"); //to be discussed !
    }
    _reply();
}

void POIContentAccessServerStub::updateCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::CAMCategoryUpdate> _poiCategories, updateCategoriesReply_t _reply)
{
    if ((m_camId == INVALID_HANDLE) || (_camId != m_camId))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {

    }
    _reply();
}

void POIContentAccessServerStub::addCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::CAMCategory> _poiCategories, addCategoriesReply_t _reply)
{
    POIServiceTypes::CAMCategory CAMCategory;
    std::vector<POIServiceTypes::CategoryAttribute> CAMCategoryAttributes;
    POIServiceTypes::Details details;
    poi_category_t category;
    category_attribute_t attribute;
    std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _poiCategoriesId;
    size_t category_index,attribute_index;

    _poiCategoriesId.clear();

    if ((m_camId == INVALID_HANDLE) || (_camId != m_camId))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {
        if (m_poiCategoriesAdded.size() < MAX_CATEGORIES)
        { //limitation of categories managed
            for (category_index=0;category_index<_poiCategories.size();category_index++)
            {
                CAMCategory = _poiCategories.at(category_index);

                details = CAMCategory.getDetails();

                category.id = (_camId*CAM_CATEGORY_OFFSET) + category_index; //create an alias
                category.name = details.getName(); // get the category name
                category.icon = details.getIcons().get<std::string>();
                category.top_level = false; //additional categories, so false
                category.attributeList.clear();
                CAMCategoryAttributes = CAMCategory.getAttributeList();
                for (attribute_index=0;attribute_index<CAMCategoryAttributes.size();attribute_index++)
                {
                    attribute.name = (CAMCategoryAttributes.at(attribute_index)).getName();
                    attribute.id = (CAMCategoryAttributes.at(attribute_index)).getId();
                    attribute.isSearched = false;
                    category.attributeList.push_back(attribute);
                }
                m_poiCategoriesAdded.push_back(category);
                _poiCategoriesId.push_back(category.id);
            }
        }
        else
            throw DBus::ErrorFailed("org.genivi.poiprovider.poiContentAccess.Error.CAMCategoriesOverflow"); //to be discussed !
    }
    _reply(_poiCategoriesId);
}

void POIContentAccessServerStub::removeCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _poiCategories, removeCategoriesReply_t _reply)
{
    std::vector< POIServiceTypes::CategoryAndReason > poiCategoriesAndReason;
    POIServiceTypes::CategoryAndReason categoryAndReason;
    size_t category_index;

    if ((m_camId == INVALID_HANDLE) || (_camId != m_camId))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiContentAccess.Error.CAMNotAvailable"); //to be discussed !
    else
    {
        if ((m_poiCategoriesAdded.size() > 0) && (_poiCategories.size() > 0))
        {
            if (_poiCategories.size() > m_poiCategoriesAdded.size())
                throw DBus::ErrorFailed("org.genivi.poiprovider.poiContentAccess.Error.CategoryError"); //to be discussed !
            else
            {
                for (category_index=0;category_index<_poiCategories.size();category_index++)
                {
                    categoryAndReason.setUnique_id(_poiCategories.at(category_index)); //prepare it before, because after it'll be erased !
                    categoryAndReason.setReason(POIServiceTypes::UpdateReason::ATTR_REMOVED);
                    if (removeCategoryFromTables(_poiCategories.at(category_index)) == true)
                        poiCategoriesAndReason.push_back(categoryAndReason);
                }
                //warn the clients
                mp_poiSearch->fireCategoriesUpdatedEvent(poiCategoriesAndReason);
            }
        }
    }
    _reply();
}

// Specific methods

void POIContentAccessServerStub::ConnectToPOISearchServer(std::shared_ptr<POISearchServerStub> poiSearch)
{
    mp_poiSearch = poiSearch; //link to the instance of poi search
}

void POIContentAccessServerStub::ConnectTocontentAccessModuleClient(POIContentAccessModuleClientProxy *client)
{
    mp_contentAccessModule = client; //link to the instance of contentAccessModule
}

bool POIContentAccessServerStub::GetRegisteredContentAccessModule(camIdName_t *cam)
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

bool POIContentAccessServerStub::GetRegisteredCategories(POIServiceTypes::ContentAccessModuleID camId, std::vector<POIServiceTypes::CategoryAndName> *categoryList)
{
    POIServiceTypes::CategoryAndName category;
    size_t category_index;

    if (camId != m_camId)
        return(false);
    else
    { //only one cam managed
        for (category_index=0;category_index<m_poiCategoriesRegistered.size();category_index++)
        {
            category.setUniqueId((m_poiCategoriesRegistered.at(category_index)).id);
            category.setName((m_poiCategoriesRegistered.at(category_index)).name);
            category.setTopLevel((m_poiCategoriesRegistered.at(category_index)).top_level);
            categoryList->push_back(category);
        }
        return(true);
    }
}

bool POIContentAccessServerStub::GetRegisteredCategoriesDetails(POIServiceTypes::ContentAccessModuleID camId, std::vector<POIServiceTypes::Category> *categoryList)
{
    POIServiceTypes::Category category;
    POIServiceTypes::CategoryDetails categoryDetails;
    std::vector<POIServiceTypes::CategoryAttribute> categoryAttributeList;
    POIServiceTypes::CategoryAttribute categoryAttribute;
    std::vector<POIServiceTypes::Operator> operatorList;
    POIServiceTypes::Operator categoryOperator;
    std::vector<POIServiceTypes::CategorySortOption> categorySortOptionList;;
    POIServiceTypes::CategorySortOption categorySortOption;;
    std::vector<CommonTypes::CategoryID> parentsId;
    uint16_t index;
    size_t category_index;

    if (camId != m_camId)
        return(false);
    else
    { //only one cam managed
        for (category_index=0;category_index<m_poiCategoriesRegistered.size();category_index++)
        {
            categoryDetails.setUniqueId((m_poiCategoriesRegistered.at(category_index)).id);
            parentsId.clear();

            for (index=0;index<(m_poiCategoriesRegistered.at(category_index)).parentList.size();index++)
            { //parents
                parentsId.push_back((m_poiCategoriesRegistered.at(category_index)).parentList.at(index));
            }
            categoryDetails.setParentsId(parentsId);
            categoryDetails.setIcons((m_poiCategoriesRegistered.at(category_index)).icon);
            categoryDetails.setName((m_poiCategoriesRegistered.at(category_index)).name);
            categoryDetails.setTopLevel((m_poiCategoriesRegistered.at(category_index)).top_level);
            categoryDetails.setDescription("no description available");
            categoryDetails.setMedia(std::string("no media"));
            categoryAttributeList.clear();
            for (index=0;index<((m_poiCategoriesRegistered.at(category_index)).attributeList.size());index++)
            {
                categoryAttribute.setName(((m_poiCategoriesRegistered.at(category_index)).attributeList.at(index)).name);
                categoryAttribute.setId(((m_poiCategoriesRegistered.at(category_index)).attributeList.at(index)).id);
                categoryAttribute.setType(POIServiceTypes::AttributeType::BOOLEAN);
                categoryOperator.setType(POIServiceTypes::OperatorType::EQUAL);
                categoryOperator.setName("EQUAL"); //redondancy
                categoryOperator.setValue(std::string(""));
                operatorList.push_back(categoryOperator);
                categoryAttribute.setOperators(operatorList);
                categoryAttributeList.push_back(categoryAttribute);
            }
            categorySortOptionList.clear();
            categorySortOption.setId(POIServiceTypes::SortOption::SORT_DEFAULT);
            categorySortOption.setName("DEFAULT"); //redondancy
            categorySortOptionList.push_back(categorySortOption);

            category.setDetails(categoryDetails);
            category.setAttributeList(categoryAttributeList);
            category.setSortOptions(categorySortOptionList);
            categoryList->push_back(category);
        }
        return(true);
    }
}

void POIContentAccessServerStub::ResetRegisteredSearchCategoriesFlags(POIServiceTypes::ContentAccessModuleID camId)
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

void POIContentAccessServerStub::ResetRegisteredAttributeCategoriesFlags(POIServiceTypes::ContentAccessModuleID camId)
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

void POIContentAccessServerStub::SetRegisteredSearchCategory(POIServiceTypes::ContentAccessModuleID camId, POIServiceTypes::CategoryAndRadius category)
{
    size_t index;

    if (camId == m_camId)
    { //only one cam managed
        //firstly clean up the list used for the search
        m_poiCategories.clear();
        for (index=0;index<m_poiCategoriesRegistered.size();index++)
        {
            if ((m_poiCategoriesRegistered.at(index)).id == category.getId())
            {
                (m_poiCategoriesRegistered.at(index)).isSearch = true;
                (m_poiCategoriesRegistered.at(index)).id= category.getId();
                (m_poiCategoriesRegistered.at(index)).radius = category.getRadius();
                m_poiCategories.push_back(category); //populate the list used for the search
            }
        }
    }
}

void POIContentAccessServerStub::SetRegisteredAttributeCategoryFlag(POIServiceTypes::ContentAccessModuleID camId, CommonTypes::CategoryID categoryId, POIServiceTypes::AttributeID attributeId)
{
    size_t index, sub_index;
    POIServiceTypes::AttributeDetails attribute;

    if (camId == m_camId)
    { //only one cam managed
        for (index=0;index<m_poiCategoriesRegistered.size();index++)
        {
            if ((m_poiCategoriesRegistered.at(index)).id == categoryId)
            {
                for (sub_index=0;sub_index<((m_poiCategoriesRegistered.at(index)).attributeList).size();sub_index++)
                {
                    if ((m_poiCategoriesRegistered.at(index)).attributeList.at(sub_index).id == attributeId)
                    {
                        (m_poiCategoriesRegistered.at(index)).attributeList.at(sub_index).isSearched =true;
                        attribute.setId(attributeId);
                        attribute.setCategoryId(categoryId);
                        attribute.setMandatory(TRUE);
                        attribute.setOper(POIServiceTypes::OperatorType::INVALID);
                        attribute.setType(POIServiceTypes::AttributeType::BOOLEAN);
                        attribute.setValue(TRUE);
                        m_poiAttributes.push_back(attribute);
                    }
                }
            }
        }
    }
}

void POIContentAccessServerStub::SetLocale(std::string languageCode, std::string countryCode, string scriptCode)
{
    if (m_camId != INVALID_HANDLE)
    { //only one cam managed
        CommonAPI::CallStatus _internalCallStatus;
        mp_contentAccessModule->myServicePOIContentAccessModule->setLocale(languageCode,countryCode, scriptCode,_internalCallStatus);
    }
}

void POIContentAccessServerStub::SetPoiSearchHandle(NavigationTypes::Handle poiSearchHandle)
{
    m_poiSearchHandle =  poiSearchHandle;
}

void POIContentAccessServerStub::ResetPoiSearchHandle()
{
    m_poiSearchHandle = INVALID_HANDLE;
}

void POIContentAccessServerStub::PoiSearchCanceled(NavigationTypes::Handle poiSearchHandle)
{
    m_poiTable.clear();
    m_poiDetailsTable.clear();
    CommonAPI::CallStatus _internalCallStatus;
    mp_contentAccessModule->myServicePOIContentAccessModule->poiSearchCanceled(poiSearchHandle,_internalCallStatus);
}

POIServiceTypes::PoiCAMDetails POIContentAccessServerStub::GetResultPoi(uint16_t index)
{
    return(m_poiTable.at(index));
}

POIServiceTypes::SearchResultDetails POIContentAccessServerStub::GetPoiDetails(POIServiceTypes::POI_ID id)
{
    uint16_t index;
    bool isPOIFound;
    POIServiceTypes::SearchResultDetails searchResDetails;
    isPOIFound = false;
    index=0;
    while ((isPOIFound == false) && (index<m_poiDetailsTable.size()))
    {
        searchResDetails = m_poiDetailsTable.at(index);
        if (searchResDetails.getDetails().getId() == id)
            isPOIFound = true;
        else
            index++;
    }
    return(m_poiDetailsTable.at(index));
}

uint16_t POIContentAccessServerStub::searchAroundALocation(NavigationTypes::Coordinate3D location, const std::string* inputString, POIServiceTypes::SortOption sortOption)
{
    uint16_t maxSize;
    std::vector< POIServiceTypes::AttributeID > attributes;
    POIServiceTypes::SearchStatusState statusValue;
    uint16_t resultListSize;
    std::vector<POIServiceTypes::POI_ID > poiList;
    uint16_t index;
    CommonAPI::CallStatus _internalCallStatus;

    resultListSize = 0;

    if (m_camId != INVALID_HANDLE)
    { //only one cam managed
        m_poiTable.clear(); //clean up the table of poi
        m_poiDetailsTable.clear(); //clean up the table of details

        //prepare the data for the Poi Search on the CAM
        maxSize = 255; //by default, to be discussed why it's needed to define it ?
        mp_contentAccessModule->myServicePOIContentAccessModule->poiSearchStarted(m_poiSearchHandle,maxSize,location,m_poiCategories,m_poiAttributes,*inputString,sortOption,_internalCallStatus);

        //wait for end of search on the CAM
        do
        {
           mp_contentAccessModule->myServicePOIContentAccessModule->resultListRequested(m_camId,m_poiSearchHandle,attributes,_internalCallStatus, statusValue,resultListSize,m_poiTable);
        } while(statusValue == POIServiceTypes::SearchStatusState::SEARCHING);

        //get details now !
        //build list of poi to get
        for (index=0;index<resultListSize;index++)
            poiList.push_back(m_poiTable.at(index).getSourceId());

        mp_contentAccessModule->myServicePOIContentAccessModule->poiDetailsRequested(poiList,_internalCallStatus,m_poiDetailsTable);
    }

    return(resultListSize);
}

bool POIContentAccessServerStub::isAttributeAvailable(POIServiceTypes::AttributeID attributeId)
{
    //to do
    return(true);
}

bool POIContentAccessServerStub::removeCategoryFromTables(CommonTypes::CategoryID id)
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

// class  POISearchServerStub

POISearchServerStub::POISearchServerStub()
{
        //version is hard coded
        m_version.setVersionMajor(1);
        m_version.setVersionMinor(0);
        m_version.setVersionMicro(0);
        m_version.setDate("19-12-2012");
        m_poiSearchHandle = INVALID_HANDLE;
        m_poiSearchProximity = false; //by default search around the current location
        m_availableCategories = 0;
        m_rootCategory = 0;
        m_searchStatus = POIServiceTypes::SearchStatusState::NOT_STARTED;
        m_routeHandle = INVALID_HANDLE;
        m_languageCode = "eng";
        m_countryCode = "USA";
        m_scriptCode = "Latn";

    }

POISearchServerStub::~POISearchServerStub()
    {
        delete mp_database;
    }

void POISearchServerStub::InitDatabase(const char* poiDatabaseFileName)
{
    std::string sqlQuery; //SQL request on database
    std::ostringstream  strStream; //temporary stream used for transformation into string
    vector<vector<string> > query_result, additionnal_query_result;
    vector<string >  query_line, additionnal_query_line;
    size_t index,sub_index;
    category_attribute_t attribute;
    categoryId_t value;
    categoryId_t parent,child;

    // all the pois and the related stuff are included into the database at the startup
    // so we can update some tables into the constructor
    mp_database = new Database(poiDatabaseFileName);

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
        double value;
        fromString<double>(value,query_line[0], std::dec);
        m_leftBottomLocation.setLatitude(value);
        fromString<double>(value,query_line[1], std::dec);
        m_leftBottomLocation.setLongitude(value);
        fromString<double>(value,query_line[2], std::dec);
        m_rightTopLocation.setLatitude(value);
        fromString<double>(value,query_line[3], std::dec);
        m_rightTopLocation.setLongitude(value);
    }
    m_centerLocation.setLatitude(48.85792); //by default center of Paris
    m_centerLocation.setLongitude(2.3383145);
    m_centerLocation.setAltitude(0);
}

void POISearchServerStub::ConnectToContentAccessServer(std::shared_ptr<POIContentAccessServerStub> poiContentAccessServer)
{
    mp_poiContentAccess = poiContentAccessServer;
}

void POISearchServerStub::getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply)
{
    _reply(m_version);
}

void POISearchServerStub::validateCategories(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _categories, validateCategoriesReply_t _reply){
    std::vector< POIServiceTypes::CategoryAndStatus > _results;
    POIServiceTypes::CategoryAndStatus categoryAndStatus;
    size_t index;
    categoryAndStatus.setStatus(TRUE); //by default
    for(index=0;index<_categories.size();index++)
    {
        categoryAndStatus.setUniqueId(_categories[index]);
        _results.push_back(categoryAndStatus);
    }
    _reply(_results);
}

void POISearchServerStub::getAvailableCategories(const std::shared_ptr<CommonAPI::ClientId> _client, getAvailableCategoriesReply_t _reply)
{
    std::vector< POIServiceTypes::CategoryAndName> _categories;
    std::vector< POIServiceTypes::CategoryAndName > categoryCAMList;
    POIServiceTypes::CategoryAndName category;
    uint16_t index;
    camIdName_t cam;

    // load categories from the embedded database
    for (index = 0; index < m_availableCategories; index++)
    {
        category.setUniqueId(m_availableCategoryTable[index].id);
        category.setTopLevel(m_availableCategoryTable[index].top_level);
        category.setName(m_availableCategoryTable[index].name);
        _categories.push_back(category);
    }

    // load categories from the additional database
    if (mp_poiContentAccess->GetRegisteredContentAccessModule(&cam))
    {
        if (mp_poiContentAccess->GetRegisteredCategories(cam.id,&categoryCAMList) == true)
        {
            _categories.insert(_categories.end(),categoryCAMList.begin(),categoryCAMList.end());
        }
    }

    _reply(_categories);
}

void POISearchServerStub::getRootCategory(const std::shared_ptr<CommonAPI::ClientId> _client, getRootCategoryReply_t _reply)
{
    _reply(m_rootCategory);
}

void POISearchServerStub::getChildrenCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::CommonTypes::CategoryID _category, getChildrenCategoriesReply_t _reply)
{
    std::vector< POIServiceTypes::CategoryAndLevel> _categories;
    POIServiceTypes::CategoryAndLevel child_category;
    size_t index;

    for (index=0;index<m_availableCategoryTable[_category].childList.size();index++)
    {
        child_category.setUniqueId(m_availableCategoryTable[_category].childList[index]);
        child_category.setTopLevel(m_availableCategoryTable[child_category.getUniqueId()].top_level);
        _categories.push_back(child_category);
    }
    _reply(_categories);
}

void POISearchServerStub::getParentCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::CommonTypes::CategoryID _category, getParentCategoriesReply_t _reply)
{
    std::vector< POIServiceTypes::CategoryAndLevel> _categories;
    POIServiceTypes::CategoryAndLevel parent_category;
    size_t index;

    for (index=0;index<m_availableCategoryTable[_category].parentList.size();index++)
    {
        parent_category.setUniqueId(m_availableCategoryTable[_category].parentList[index]);
        parent_category.setTopLevel(m_availableCategoryTable[parent_category.getUniqueId()].top_level);
        _categories.push_back(parent_category);
    }
    _reply(_categories);
}

void POISearchServerStub::getCategoriesDetails(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _categories, getCategoriesDetailsReply_t _reply)
{
    std::vector<POIServiceTypes::Category> _results;
    std::vector<POIServiceTypes::Category> categoryCAMList;
    POIServiceTypes::Category category;
    POIServiceTypes::CategoryDetails categoryDetails;
    std::vector<POIServiceTypes::CategoryAttribute> categoryAttributeList;
    POIServiceTypes::CategoryAttribute categoryAttribute;
    std::vector<POIServiceTypes::Operator> operatorList;
    POIServiceTypes::Operator categoryOperator;
    std::vector<POIServiceTypes::CategorySortOption> categorySortOptionList;;
    POIServiceTypes::CategorySortOption categorySortOption;;
    std::vector<CommonTypes::CategoryID> parentsId;
    size_t index,sub_index;
    CommonTypes::CategoryID category_index;
    camIdName_t cam;

    // load categories details from the embedded database
    index=0;

    while ((index<_categories.size())&&(index < m_availableCategories))
    {
        if ( isCategoryAvailable(_categories.at(index),&category_index) == true)
        { //category found into the embedded data!
            categoryDetails.setUniqueId(m_availableCategoryTable[category_index].id);
            categoryDetails.setStandardCategoryId(POIServiceTypes::StandardCategory::NOT_STANDARD_CATEGORY);
            parentsId.clear();

            for (sub_index=0;sub_index<m_availableCategoryTable[category_index].parentList.size();sub_index++)
            { //parents
                parentsId.push_back(m_availableCategoryTable[category_index].parentList.at(sub_index));
            }
            categoryDetails.setParentsId(parentsId);
            categoryDetails.setIcons(m_availableCategoryTable[category_index].icon);
            categoryDetails.setName(m_availableCategoryTable[category_index].name);
            categoryDetails.setTopLevel(m_availableCategoryTable[category_index].top_level);
            categoryDetails.setDescription("no description available");
            categoryDetails.setMedia(std::string("no media"));
            categoryAttributeList.clear();
            //scan the attributes
            for (sub_index=0;sub_index<m_availableCategoryTable[category_index].attributeList.size();sub_index++)
            {
                categoryAttribute.setId((m_availableCategoryTable[category_index].attributeList.at(sub_index)).id);
                categoryAttribute.setName((m_availableCategoryTable[category_index].attributeList.at(sub_index)).name);
                categoryAttribute.setType(POIServiceTypes::AttributeType::BOOLEAN);
                operatorList.clear();
                categoryOperator.setType(POIServiceTypes::OperatorType::EQUAL);
                categoryOperator.setName("EQUAL"); //redondancy
                categoryOperator.setValue(std::string(""));
                operatorList.push_back(categoryOperator);
                categoryAttribute.setOperators(operatorList);
                categoryAttributeList.push_back(categoryAttribute);
            }

            categorySortOptionList.clear();
            categorySortOption.setId(POIServiceTypes::SortOption::SORT_DEFAULT);
            categorySortOption.setName("DEFAULT");
            categorySortOptionList.push_back(categorySortOption);

            category.setDetails(categoryDetails);
            category.setAttributeList(categoryAttributeList);
            category.setSortOptions(categorySortOptionList);
            _results.push_back(category);
        }
        index++;
    }

    // load categories details from the additional database
    if (mp_poiContentAccess->GetRegisteredContentAccessModule(&cam))
    {
        if (mp_poiContentAccess->GetRegisteredCategoriesDetails(cam.id,&categoryCAMList) == true)
        {
            for (index=0;index<categoryCAMList.size();index++)
                _results.push_back(categoryCAMList.at(index));
        }
    }

    _reply(_results);
}

void POISearchServerStub::getCategoriesWithStandardCategoryId(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::StandardCategory _standardCategoryId, getCategoriesWithStandardCategoryIdReply_t _reply)
{
    std::vector< CommonTypes::CategoryID > _categories;
    _reply(_categories);
}

void POISearchServerStub::createPoiSearchHandle(const std::shared_ptr<CommonAPI::ClientId> _client, createPoiSearchHandleReply_t _reply)
{
    // the POC is limited to the management of one handle !
    if (m_poiSearchHandle != INVALID_HANDLE)
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        m_poiSearchHandle = VALID_HANDLE;
        //set the handle for the content access server
        mp_poiContentAccess->SetPoiSearchHandle(m_poiSearchHandle);
        //set the language used by the content access server
         mp_poiContentAccess->SetLocale(m_languageCode,m_countryCode, m_scriptCode);
    }
    _reply(m_poiSearchHandle);
}

void POISearchServerStub::deletePoiSearchHandle(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, deletePoiSearchHandleReply_t _reply)
{
    camIdName_t cam;
    bool status;
    if ((m_poiSearchHandle == INVALID_HANDLE) || (_poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
   {
        m_poiSearchHandle = INVALID_HANDLE;
        status = mp_poiContentAccess->GetRegisteredContentAccessModule(&cam);
        if (status == true)
        {
             //reset the handle
             mp_poiContentAccess->ResetPoiSearchHandle();
        }

    }
    _reply();
}

void POISearchServerStub::setCenter(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, ::v4::org::genivi::navigation::NavigationTypes::Coordinate3D _location, setCenterReply_t _reply)
{
    if ((m_poiSearchHandle == INVALID_HANDLE) || (_poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        m_centerLocation = _location;
    }
    _reply();
}

void POISearchServerStub::setRouteHandle(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, uint32_t _startSearchOffset, uint32_t _endSearchOffset, setRouteHandleReply_t _reply)
{
    uint32_t index;
    int16_t detailLevel;
    std::vector< Routing::RouteSegmentType > valuesToReturn;
    uint32_t numberOfSegments;
    uint32_t offset;
    uint32_t totalNumberOfSegments;
    std::vector< Routing::RouteSegment > routeSegments;
    Routing::RouteSegment element;
    Routing::RouteSegment::iterator iter;
    route_vector_t routeVector;

    if ((m_poiSearchHandle == INVALID_HANDLE) || (_poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        m_sessionHandle = _sessionHandle;
        m_routeHandle = _routeHandle;
        m_startSearchOffset = _startSearchOffset;
        m_endSearchOffset = _endSearchOffset;

        //Get the route segments
        m_route.clear(); //clear the existing route
        detailLevel = 0; //to be clarified
        valuesToReturn.push_back(Routing::RouteSegmentType::START_LATITUDE);
        valuesToReturn.push_back(Routing::RouteSegmentType::END_LATITUDE);
        valuesToReturn.push_back(Routing::RouteSegmentType::START_LONGITUDE);
        valuesToReturn.push_back(Routing::RouteSegmentType::END_LONGITUDE);
        offset = 0;

        //First get the total amount of segments
        numberOfSegments = 0;
        CommonAPI::CallStatus _internalCallStatus;
        mp_Routing->myServiceRouting->getRouteSegments(m_routeHandle,detailLevel,valuesToReturn,numberOfSegments,offset,_internalCallStatus, totalNumberOfSegments,routeSegments);
        m_totalNumberOfSegments = totalNumberOfSegments;

        // Get all the segments
        numberOfSegments = m_totalNumberOfSegments;
        mp_Routing->myServiceRouting->getRouteSegments(m_routeHandle,detailLevel,valuesToReturn,numberOfSegments,offset,_internalCallStatus,totalNumberOfSegments,routeSegments);
        for (index=0;index<routeSegments.size();index++)
        {
            element = routeSegments.at(index);
            iter = element.find(Routing::RouteSegmentType::START_LATITUDE);
            if (iter != element.end())
                routeVector.startPoint.setLatitude(element.at(Routing::RouteSegmentType::START_LATITUDE).get<double>());
            iter = element.find(Routing::RouteSegmentType::START_LONGITUDE);
            if (iter != element.end())
                routeVector.startPoint.setLongitude(element.at(Routing::RouteSegmentType::START_LONGITUDE).get<double>());
            iter = element.find(Routing::RouteSegmentType::END_LATITUDE);
            if (iter != element.end())
                routeVector.endPoint.setLatitude(element.at(Routing::RouteSegmentType::END_LATITUDE).get<double>());
            iter = element.find(Routing::RouteSegmentType::END_LONGITUDE);
            if (iter != element.end())
                routeVector.endPoint.setLongitude(element.at(Routing::RouteSegmentType::END_LONGITUDE).get<double>());
            m_route.push_back(routeVector);
        }
    }
    _reply();
}

void POISearchServerStub::setCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::CategoryAndRadius> _poiCategories, setCategoriesReply_t _reply)
{
    size_t index;
    CommonTypes::CategoryID category_index;
    camIdName_t cam;
    POIServiceTypes::CategoryAndRadius categoryRadius;

    if ((m_poiSearchHandle == INVALID_HANDLE) || (_poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
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

        for (index=0; index < _poiCategories.size();index++)
        {
            categoryRadius = _poiCategories.at(index);
            if ( isCategoryAvailable(categoryRadius.getId() ,&category_index) == true)
            { //category found into the embedded data !
                m_availableCategoryTable[category_index].isSearch = true;
                m_availableCategoryTable[category_index].radius = (categoryRadius.getRadius())*10; //get the radius (unit is 10 m)
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
    _reply();
}

void POISearchServerStub::setAttributes(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::AttributeDetails> _poiAttributes, setAttributesReply_t _reply)
{
    POIServiceTypes::AttributeDetails attributeDetails;
    size_t index,sub_index;
    CommonTypes::CategoryID category_index;
    camIdName_t cam;

    if ((m_poiSearchHandle == INVALID_HANDLE) || (_poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
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
        for (index=0;index<_poiAttributes.size();index++)
        {
            attributeDetails = _poiAttributes[index];
            if ( isCategoryAvailable(attributeDetails.getCategoryId(),&category_index) == true)
            { //category found into the embedded database!
                for (sub_index=0;sub_index<(m_availableCategoryTable[category_index].attributeList.size());sub_index++)
                { //check attribute by name
                    if ((m_availableCategoryTable[category_index].attributeList.at(sub_index)).id == attributeDetails.getId())
                        (m_availableCategoryTable[category_index].attributeList.at(sub_index)).isSearched =true;
                }
            }
            else
            { //set the flags of attributes to be searched into the additional database
                if ((mp_poiContentAccess->GetRegisteredContentAccessModule(&cam)) == true)
                {
                    mp_poiContentAccess->SetRegisteredAttributeCategoryFlag(cam.id,attributeDetails.getCategoryId(),attributeDetails.getId());
                }
            }
        }
    }
    _reply();
}

void POISearchServerStub::startPoiSearch(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, std::string _inputString, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::SortOption _sortOption, startPoiSearchReply_t _reply)
{

    if ((m_poiSearchHandle == INVALID_HANDLE) || (_poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        m_totalSize = 0;
        if (m_poiSearchProximity == false)
        { //no proximity search started on this session !
            m_searchStatus = POIServiceTypes::SearchStatusState::SEARCHING;
            firePoiStatusEvent(_poiSearchHandle,m_searchStatus);
            //sortOption is not used yet
            //for the moment, no thread used, because just one handle managed
            // search on the embedded database first
            m_totalSize = searchAroundALocation(m_centerLocation,&_inputString); //search around the current location of the vehicle
            //and now search on the additional database if the cam has been registered before the creation of the poi search handle
            m_totalSize += mp_poiContentAccess->searchAroundALocation(m_centerLocation,&_inputString,_sortOption);
            m_searchStatus = POIServiceTypes::SearchStatusState::FINISHED;
            firePoiStatusEvent(_poiSearchHandle,m_searchStatus);
            fireResultListChangedEvent(_poiSearchHandle,m_totalSize);
        }
    }
    _reply();
}

void POISearchServerStub::cancelPoiSearch(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, cancelPoiSearchReply_t _reply)
{
    if ((m_poiSearchHandle == INVALID_HANDLE) || (_poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        if (m_poiSearchProximity == false)
        { //no proximity search started on this session !
            m_searchStatus = POIServiceTypes::SearchStatusState::NOT_STARTED;
            firePoiStatusEvent(_poiSearchHandle,m_searchStatus);
        }
    }
    _reply();
}

void POISearchServerStub::startPoiProximityAlert(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, std::string _inputString, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::SortOption _sortOption, startPoiProximityAlertReply_t _reply)
{
    if ((m_poiSearchHandle == INVALID_HANDLE) || (_poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        if (m_poiSearchProximity == false)
        {
            m_poiSearchProximity = true; //start proximity search !
            m_searchStatus = POIServiceTypes::SearchStatusState::SEARCHING;
            firePoiStatusEvent(_poiSearchHandle,m_searchStatus);
        }
    }
    _reply();
}

void POISearchServerStub::cancelPoiProximityAlert(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, cancelPoiProximityAlertReply_t _reply)
{
    if ((m_poiSearchHandle == INVALID_HANDLE) || (_poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        if (m_poiSearchProximity == true)
        {
            m_poiSearchProximity = false; //stop proximity search !
            m_searchStatus = POIServiceTypes::SearchStatusState::NOT_STARTED;
            firePoiStatusEvent(_poiSearchHandle,m_searchStatus);
        }
    }
    _reply();
}

void POISearchServerStub::requestResultList(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, uint16_t _offset, uint16_t _maxWindowSize, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::AttributeID> _attributeList, requestResultListReply_t _reply)
{
    POIServiceTypes::SearchStatusState _statusValue;
    uint16_t _resultListSize;
    std::vector< POIServiceTypes::SearchResult> _resultListWindow;
    POIServiceTypes::SearchResult element; //id distance status attributes[]
    POIServiceTypes::PoiCAMDetails camElement; //id name category location distance attributes[]
    std::vector<POIServiceTypes::PoiAttribute> attributes;
    POIServiceTypes::PoiAttribute attribute; //name type value
    size_t index,size,sub_index;
    size_t attribute_index;
    poi_t poi;

    if ((m_poiSearchHandle == INVALID_HANDLE) || (_poiSearchHandle != m_poiSearchHandle))
        // to do send an error message
        throw DBus::ErrorFailed("org.genivi.poiprovider.poiSearch.Error.HandleNotAvailable"); //to be discussed !
    else
    {
        _statusValue = m_searchStatus;
        if (m_searchStatus == POIServiceTypes::SearchStatusState::FINISHED)
        { //consider that the search is finished for the CAM too

            if ((_offset+1)>m_totalSize)
                index=0;
            else
                index=_offset;
            if ((index+_maxWindowSize)>m_totalSize)
                size=m_totalSize-index;
            else
                size=_maxWindowSize;
            _resultListSize = size;

            while (size>0)
            { //load the poi into the vector
                if ((index+1)>m_poiTable.size())
                {
                    //no more data into the embedded table, so pick data from the additional table
                    camElement = mp_poiContentAccess->GetResultPoi(index-m_poiTable.size());
                    element.setId(camElement.getSourceId()); //id
                    element.setDistance(camElement.getDistance()); //distance
                    element.setRouteStatus(POIServiceTypes::RouteStatus::OFF_ROUTE);
                    attributes = camElement.getAttributeList();
                    element.setAttributeList(attributes);
                    _resultListWindow.push_back(element);
                    index++;
                    size-=1;
                }
                else
                { // pick data from the embedded table
                    poi = m_poiTable.at(index);
                    element.setId(poi.segment);
                    element.setDistance(poi.distance);
                    element.setRouteStatus(POIServiceTypes::RouteStatus::OFF_ROUTE);
                    attributes.clear(); //clean list of attributes

                    for (attribute_index=0;attribute_index<m_availableCategoryTable[poi.categoryIndex].attributeList.size();attribute_index++)
                    { //scan the attributes for the category
                        if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_SOURCE)
                        {
                            attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                            if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                            {
                                attribute.setType(POIServiceTypes::AttributeType::STRING);
                                attribute.setValue(poi.source);
                                attributes.push_back(attribute);
                            }
                        }
                        else
                        {
                            if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_WEBSITE)
                            {
                                attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                                {
                                    attribute.setType(POIServiceTypes::AttributeType::STRING);
                                    attribute.setValue(poi.website);
                                    attributes.push_back(attribute);
                                }
                            }
                            else
                            {
                                if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_PHONE)
                                {
                                    attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                    if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                                    {
                                        attribute.setType(POIServiceTypes::AttributeType::STRING);
                                        attribute.setValue(poi.phone);
                                        attributes.push_back(attribute);
                                    }
                                }
                                else
                                {
                                    if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_STARS)
                                    {
                                        attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                        if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                                        {
                                            attribute.setType(POIServiceTypes::AttributeType::INTEGER);
                                            attribute.setValue((int32_t)poi.stars);
                                            attributes.push_back(attribute);
                                        }
                                    }
                                    else
                                    {
                                        if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_OPENINGHOURS)
                                        {
                                            attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                            if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                                            {
                                                attribute.setType(POIServiceTypes::AttributeType::STRING);
                                                attribute.setValue(poi.openinghours);
                                                attributes.push_back(attribute);
                                            }
                                        }
                                        else
                                        {
                                            if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRHOUSENUMBER)
                                            {
                                                attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                                if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                                                {
                                                    attribute.setType(POIServiceTypes::AttributeType::STRING);
                                                    attribute.setValue(poi.addr_house_number);
                                                    attributes.push_back(attribute);
                                                }
                                            }
                                            else
                                            {
                                                if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRSTREET)
                                                {
                                                    attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                                    if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                                                    {
                                                        attribute.setType(POIServiceTypes::AttributeType::STRING);
                                                        attribute.setValue(poi.addr_street);
                                                        attributes.push_back(attribute);
                                                    }
                                                }
                                                else
                                                {
                                                    if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRPOSTCODE)
                                                    {
                                                        attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                                        if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                                                        {
                                                            attribute.setType(POIServiceTypes::AttributeType::INTEGER);
                                                            attribute.setValue((int32_t)poi.addr_postcode);
                                                            attributes.push_back(attribute);
                                                        }
                                                    }
                                                    else
                                                    {
                                                        if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_ADDRCITY)
                                                        {
                                                            attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                                            if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                                                            {
                                                                attribute.setType(POIServiceTypes::AttributeType::STRING);
                                                                attribute.setValue(poi.addr_city);
                                                                attributes.push_back(attribute);
                                                            }
                                                        }
                                                        else
                                                        {
                                                            if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_BRAND)
                                                            {
                                                                attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                                                if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                                                                {
                                                                    attribute.setType(POIServiceTypes::AttributeType::STRING);
                                                                    attribute.setValue(poi.brand);
                                                                    attributes.push_back(attribute);
                                                                }
                                                            }
                                                            else
                                                            {
                                                                if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_OPERATEUR)
                                                                {
                                                                    attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                                                    if (isAttributeRequired(attribute.getId(),_attributeList)==true)
                                                                    {
                                                                        attribute.setType(POIServiceTypes::AttributeType::STRING);
                                                                        attribute.setValue(poi.operateur);
                                                                        attributes.push_back(attribute);
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

                    element.setAttributeList(attributes);
                    _resultListWindow.push_back(element);
                    index++;
                    size-=1;
                }
            }
        }        
    }
    _reply(_statusValue,_resultListSize,_resultListWindow);
}

void POISearchServerStub::getPoiDetails(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::POI_ID> _id, getPoiDetailsReply_t _reply)
{
    std::vector< POIServiceTypes::SearchResultDetails> _results;
    POIServiceTypes::SearchResultDetails searchResDetails;
    POIServiceTypes::PoiDetails poiDetails;
    NavigationTypes::Coordinate3D coordinate3D;
    std::vector<POIServiceTypes::PoiAttribute> attributes;
    POIServiceTypes::PoiAttribute attribute;
    std::vector<CommonTypes::CategoryID> categories;
    uint16_t indexPOIList,indexIDList;
    size_t attribute_index;
    poi_t poi;
    bool isPOIFound;
    std::ostringstream  strStream; //temporary stream used for transformation into string

    //for the moment, no optimization so it needs to be improved a little :-)

    for (indexIDList=0;indexIDList<_id.size();indexIDList++)
    { //scan the list of poi to detail
        isPOIFound = false;

        //scan the embedded table
        //'while' first because the table could be empty in case of additional data only !
        indexPOIList=0;
        while((isPOIFound == false) && (indexPOIList<m_poiTable.size()))
        {
            poi = m_poiTable.at(indexPOIList);
            if (poi.segment == _id.at(indexIDList))
            {
                isPOIFound = true;
                poiDetails.setId(poi.segment);
                poiDetails.setName(poi.name);
                coordinate3D.setLatitude(poi.coordinate.getLatitude());
                coordinate3D.setLongitude(poi.coordinate.getLongitude());
                coordinate3D.setAltitude(poi.coordinate.getAltitude());
                poiDetails.setLocation(coordinate3D);
                searchResDetails.setDetails(poiDetails);
                categories.clear();
                categories.push_back(m_availableCategoryTable[poi.categoryIndex].id); //POI only owns to one category for the moment !
                searchResDetails.setCategories(categories);

                // check the attributes for the category and get the value
                for (attribute_index=0;attribute_index<m_availableCategoryTable[poi.categoryIndex].attributeList.size();attribute_index++)
                { //scan the attributes for the category
                    if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_SOURCE)
                    {
                        attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                        attribute.setType(POIServiceTypes::AttributeType::STRING);
                        attribute.setValue(poi.source);
                        attributes.push_back(attribute);
                    }
                    else
                    {
                        if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_WEBSITE)
                        {
                            attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                            attribute.setType(POIServiceTypes::AttributeType::STRING);
                            attribute.setValue(poi.website);
                            attributes.push_back(attribute);
                        }
                        else
                        {
                            if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_PHONE)
                            {
                                attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                attribute.setType(POIServiceTypes::AttributeType::STRING);
                                attribute.setValue(poi.phone);
                                attributes.push_back(attribute);
                            }
                            else
                            {
                                if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_STARS)
                                {
                                    attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                    attribute.setType(POIServiceTypes::AttributeType::INTEGER);
                                    attribute.setValue((int32_t)poi.stars);
                                    attributes.push_back(attribute);
                                }
                                else
                                {
                                    if ((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id == ATTRIBUTE_OPENINGHOURS)
                                    {
                                        attribute.setId((m_availableCategoryTable[poi.categoryIndex].attributeList.at(attribute_index)).id);
                                        attribute.setType(POIServiceTypes::AttributeType::STRING);
                                        attribute.setValue(poi.openinghours);
                                        attributes.push_back(attribute);
                                    }
                                }
                            }
                        }
                    }
                }

                searchResDetails.setAttributeList(attributes);
                _results.push_back(searchResDetails);
            }
            else
                ++indexPOIList;
        }

        if (isPOIFound == false)
        {
            //not found in embedded table, so get it into  the additional data
            //we consider that the element exists into the additional data (no check)
            _results.push_back(mp_poiContentAccess->GetPoiDetails(_id.at(indexIDList)));
        }
    }

    _reply(_results);
}

// Specific methods

void POISearchServerStub::SetLocale(std::string languageCode, std::string countryCode, std::string scriptCode)
{
    m_languageCode = languageCode;
    m_countryCode = countryCode;
    m_scriptCode = scriptCode;

    mp_poiContentAccess->SetLocale(languageCode,countryCode,scriptCode); //update poi content access data (to set the cam data)
}

void POISearchServerStub::ConnectToRoutingClient(RoutingClientProxy *client)
{
    mp_Routing = client; //link to the instance of routing
}

void POISearchServerStub::onError()
{
}

uint16_t POISearchServerStub::searchAroundALocation(NavigationTypes::Coordinate3D location,const std::string* inputString)
{
    uint16_t index, all_categories_index;
    uint16_t total_size;
    NavigationTypes::Coordinate3D left_bottom_location,right_top_location;

    total_size = 0;

    m_poiTable.clear(); //clean the table of poi

    if (isAllCategoriesSelected(&all_categories_index))
    {
        left_bottom_location.setLatitude(location.getLatitude() - m_availableCategoryTable[all_categories_index].angle);
        left_bottom_location.setLongitude(location.getLongitude() - m_availableCategoryTable[all_categories_index].angle);
        right_top_location.setLatitude(location.getLatitude() + m_availableCategoryTable[all_categories_index].angle);
        right_top_location.setLongitude(location.getLongitude() + m_availableCategoryTable[all_categories_index].angle);
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
                left_bottom_location.setLatitude(location.getLatitude() - m_availableCategoryTable[index].angle);
                left_bottom_location.setLongitude(location.getLongitude() - m_availableCategoryTable[index].angle);
                right_top_location.setLatitude(location.getLatitude() + m_availableCategoryTable[index].angle);
                right_top_location.setLongitude(location.getLongitude() + m_availableCategoryTable[index].angle);
                total_size += searchPOIRequest(index, *inputString,left_bottom_location,right_top_location);
            }
        }

    }
    return(total_size);
}

uint16_t POISearchServerStub::searchPOIRequest(uint16_t categoryIndex, std::string search_string, NavigationTypes::Coordinate3D left_bottom_location,NavigationTypes::Coordinate3D right_top_location)
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
    strStream << left_bottom_location.getLatitude();
    sqlQuery += strStream.str();
    sqlQuery += ") AND (latitude < ";
    strStream.str(""); //to clean before !
    strStream << right_top_location.getLatitude();
    sqlQuery += strStream.str();
    sqlQuery += ")) AND ((longitude > ";
    strStream.str(""); //to clean before !
    strStream << left_bottom_location.getLongitude();
    sqlQuery += strStream.str();
    sqlQuery += ") AND (longitude < ";
    strStream.str(""); //to clean before !
    strStream << right_top_location.getLongitude();
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
        double value;
        fromString<double>(value,sqlQueryLine[2], std::dec);
        poi.coordinate.setLatitude(value);
        fromString<double>(value,sqlQueryLine[3], std::dec);
        poi.coordinate.setLongitude(value);
        fromString<double>(value,sqlQueryLine[4], std::dec);
        poi.coordinate.setAltitude(value);
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

bool POISearchServerStub::isCategoryAvailable(categoryId_t id, categoryId_t *category_id)
{
    bool isFound = false;
    categoryId_t index = 0;
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

bool POISearchServerStub::isAllCategoriesSelected(uint16_t* index)
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

bool POISearchServerStub::isAttributeRequired(POIServiceTypes::AttributeID attribute,std::vector<POIServiceTypes::AttributeID> attributes)
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

uint32_t POISearchServerStub::calculateDistance(const NavigationTypes::Coordinate3D origin, const NavigationTypes::Coordinate3D target)
{
    //this piece of software is based on an haversine formula given by:
    // - Doctors Rick and Peterson, The Math Forum
    // http://mathforum.org/dr.math/
    // haversine of angle A is (1-cos(A))/2 that is equal to sin^2(A/2)

    //earth is considered to be a perfect spĥere, in order to simplify calculation
    const double PI = 4.0*atan(1.0);
    const double earth=6378137; //IUGG value for the equatorial radius of the Earth in m
    NavigationTypes::Coordinate3D pointA, pointB;
    double buffer;

    pointA.setLatitude(origin.getLatitude() * (PI/180));
    pointA.setLongitude(origin.getLongitude() * (PI/180));
    pointB.setLatitude(target.getLatitude() * (PI/180));
    pointB.setLongitude(target.getLongitude() * (PI/180));

    buffer= pow(sin((pointA.getLatitude()-pointB.getLatitude())/2.0),2.0)+cos(pointA.getLatitude())*cos(pointB.getLatitude())*pow(sin((pointA.getLongitude()-pointB.getLongitude())/2),2);
    buffer = 2*atan2(sqrt(buffer),sqrt(1.0-buffer));
    buffer=earth*buffer;
    return ((uint32_t) buffer); //return distance in meters
}

double POISearchServerStub::calculateAngle(const uint32_t radius)
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

bool POISearchServerStub::calculateLineCoefficient(double* a,double* b,const NavigationTypes::Coordinate3D pointA,const NavigationTypes::Coordinate3D pointB)
{
   /* longitude on the x axis, latitude on the y axis
    * segment line y = a*x + b
    * pointA and pointB points of the segment
    * if xA is different of xB
    * a = (yA-yB)/(xA-xB)
    * b = (xA*yB - xB*yA)/(xA-xB)
    */
    if (pointA.getLongitude() == pointB.getLongitude())
    { //equation x = constant
        *b = pointA.getLongitude(); //constant into *b
        return(false);
    }
    else
    {
        *a = (pointA.getLatitude()-pointB.getLatitude())/(pointA.getLongitude()-pointB.getLongitude());
        *b = (pointA.getLongitude()*pointB.getLatitude() - pointB.getLongitude()*pointA.getLatitude())/(pointA.getLongitude()-pointB.getLongitude());
        return(true);
    }
}

/**
 * \fn double calculateOrthoDistance(const double a,const double b,const DBus_geoCoordinate3D::geoCoordinate3D_t pointP)
 * \brief calculate ortho distance between a point P and a line defined by the slope a and the y intercept b.
 *
 * \param  double a -slope
 * \param  double b -y intercept
 * \param  NavigationTypes::Coordinate3D pointP -point
 * \return uint32_t distance.
 */
uint32_t POISearchServerStub::calculateOrthoDistance(const double a, const double b, const NavigationTypes::Coordinate3D pointP)
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
    return ((uint32_t)((a*pointP.getLongitude() - pointP.getLatitude() + b)/sqrt(1 + a*a)));
}

// class  POIConfigurationServerStub

POIConfigurationServerStub::POIConfigurationServerStub()
{
    POIConfiguration::UnitsOfMeasurementListValue valueList;

    m_version.setVersionMajor(3);
    m_version.setVersionMinor(0);
    m_version.setVersionMicro(0);
    m_version.setDate("21-01-2014");

    NavigationTypes::Locale en_US { "eng","USA", "Latn" };
    NavigationTypes::Locale fr_FR { "fra","FRA", "Latn" };
    NavigationTypes::Locale de_DE { "deu","DEU", "Latn" };
    NavigationTypes::Locale jp_JP { "jpn","JPN", "Hrkt" };

    m_SupportedLocales.push_back(en_US);
    m_SupportedLocales.push_back(fr_FR);
    m_SupportedLocales.push_back(de_DE);
    m_SupportedLocales.push_back(jp_JP);

    valueList.push_back(POIConfiguration::UnitsOfMeasurementValue::MILE);
    valueList.push_back(POIConfiguration::UnitsOfMeasurementValue::METER);

    m_SupportedUnitsOfMeasurement[POIConfiguration::UnitsOfMeasurementAttribute::LENGTH]=valueList;

    m_SupportedTimeFormats.push_back(NavigationTypes::TimeFormat::TWELVEH);
    m_SupportedTimeFormats.push_back(NavigationTypes::TimeFormat::TWENTYFOURH);

    m_SupportedCoordinatesFormats.push_back(POIConfiguration::CoordinatesFormat::DEGREES);

    //default init
    m_languageCode = m_SupportedLocales.at(0).getLanguageCode();
    m_countryCode = m_SupportedLocales.at(0).getCountryCode();
    m_scriptCode = m_SupportedLocales.at(0).getScriptCode();
    m_coordinatesFormat = m_SupportedCoordinatesFormats.at(0);

    m_unitsOfMeasurement[POIConfiguration::UnitsOfMeasurementAttribute::LENGTH] = POIConfiguration::UnitsOfMeasurementValue::METER;

    m_timeFormat = m_SupportedTimeFormats.at(0);
}

POIConfigurationServerStub::~POIConfigurationServerStub()
{

}

void POIConfigurationServerStub::getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply)
{
    _reply(m_version);
}

void POIConfigurationServerStub::setLocale(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _languageCode, std::string _countryCode, std::string _scriptCode, setLocaleReply_t _reply)
{
    std::vector<POIServiceTypes::Settings> changedSettings;

    m_languageCode = _languageCode;
    m_countryCode = _countryCode;
    m_scriptCode = _scriptCode;

    changedSettings.push_back(POIServiceTypes::Settings::LOCALE);
    fireConfigurationChangedEvent(changedSettings);
    _reply();
}

void POIConfigurationServerStub::getLocale(const std::shared_ptr<CommonAPI::ClientId> _client, getLocaleReply_t _reply)
{
    _reply(m_languageCode,m_countryCode,m_scriptCode);
}

void POIConfigurationServerStub::getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedLocalesReply_t _reply)
{
    _reply(m_SupportedLocales);
}

void POIConfigurationServerStub::setTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, NavigationTypes::TimeFormat _format, setTimeFormatReply_t _reply)
{
    std::vector<POIServiceTypes::Settings> changedSettings;

    m_timeFormat = _format;

    changedSettings.push_back(POIServiceTypes::Settings::TIME_FORMAT);
    fireConfigurationChangedEvent(changedSettings);
    _reply();
}

void POIConfigurationServerStub::getTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getTimeFormatReply_t _reply)
{
    _reply(m_timeFormat);
}

void POIConfigurationServerStub::getSupportedTimeFormats(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedTimeFormatsReply_t _reply)
{
    _reply(m_SupportedTimeFormats);
}

void POIConfigurationServerStub::setCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, POIConfiguration::CoordinatesFormat _coordinatesFormat, setCoordinatesFormatReply_t _reply)
{
    std::vector<POIServiceTypes::Settings> changedSettings;

    m_coordinatesFormat = _coordinatesFormat;

    changedSettings.push_back(POIServiceTypes::Settings::COORDINATES_FORMAT);
    fireConfigurationChangedEvent(changedSettings);
    _reply();
}

void POIConfigurationServerStub::getCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getCoordinatesFormatReply_t _reply)
{
    _reply(m_coordinatesFormat);
}

void POIConfigurationServerStub::getSupportedCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedCoordinatesFormatReply_t _reply)
{
    _reply(m_SupportedCoordinatesFormats);
}

void POIConfigurationServerStub::setUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, POIConfiguration::UnitsOfMeasurement _unitsOfMeasurementList, setUnitsOfMeasurementReply_t _reply)
{
    std::vector<POIServiceTypes::Settings> changedSettings;

    m_unitsOfMeasurement = _unitsOfMeasurementList;

    changedSettings.push_back(POIServiceTypes::Settings::UNITS_OF_MEASUREMENT);
    fireConfigurationChangedEvent(changedSettings);
    _reply();
}

void POIConfigurationServerStub::getUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getUnitsOfMeasurementReply_t _reply)
{
    _reply(m_unitsOfMeasurement);
}

void POIConfigurationServerStub::getSupportedUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedUnitsOfMeasurementReply_t _reply)
{
    _reply(m_SupportedUnitsOfMeasurement);
}

//specific methods

void POIConfigurationServerStub::ConnectToPOISearchServer(std::shared_ptr<POISearchServerStub> poiSearch)
{
    mp_poiSearch = poiSearch;  //link to the instance of poi search
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

    // Common API data init
    runtime = CommonAPI::Runtime::get();
    bool successfullyRegistered;

    const std::string instancePOISearch = "POISearch";
    std::shared_ptr<POISearchServerStub> myServicePOISearch = std::make_shared<POISearchServerStub>();
    successfullyRegistered = runtime->registerService(domain, instancePOISearch, myServicePOISearch);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instancePOISearch, myServicePOISearch);
    }

    const std::string instancePOIConfiguration = "POIConfiguration";
    std::shared_ptr<POIConfigurationServerStub> myServicePOIConfiguration = std::make_shared<POIConfigurationServerStub>();
    successfullyRegistered = runtime->registerService(domain, instancePOIConfiguration, myServicePOIConfiguration);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instancePOIConfiguration, myServicePOIConfiguration);
    }

    const std::string instancePOIContentAccess = "POIContentAccess";
    std::shared_ptr<POIContentAccessServerStub> myServicePOIContentAccess = std::make_shared<POIContentAccessServerStub>();
    successfullyRegistered = runtime->registerService(domain, instancePOIContentAccess, myServicePOIContentAccess);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instancePOIContentAccess, myServicePOIContentAccess);
    }

    const std::string instanceRouting = "Routing";
    RoutingClientProxy* mp_routingClientProxy = new RoutingClientProxy(domain,instanceRouting);
    mp_routingClientProxy->setListeners();

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
                // init the database
                myServicePOISearch->InitDatabase(database_filename);

                // connect myServicePOISearch to myServicePOIContentAccess
                myServicePOIContentAccess->ConnectToPOISearchServer(myServicePOISearch);
                myServicePOISearch->ConnectToContentAccessServer(myServicePOIContentAccess);

                // connect myServicePOISearch to myServicePOIConfiguration
                myServicePOIConfiguration->ConnectToPOISearchServer(myServicePOISearch);

                // connect mp_routingClientProxy to myServicePOISearch
                myServicePOISearch->ConnectToRoutingClient(mp_routingClientProxy);

                // Create a new GMainLoop with default context and initial state of "not running "
                mainloop = g_main_loop_new (g_main_context_default() , FALSE );

                // Send a feedback to the user
                cout << "poi server started" << endl;

                // loop listening

                g_main_loop_run ( mainloop );

                // clean memory
                delete mp_routingClientProxy;
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
