/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_poiservice_cam_navit.cxx
*
* \brief This file is part of the Navit POC.
*
* \author Martin Schaller <martin.schaller@it-schaller.de>
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.0
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License (MPL), v. 2.0.
* If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* For further information see http://www.genivi.org/.
*
* List of changes:
* 
* <date>, <name>, <description of change>
*
* @licence end@
*/
#include <dbus-c++/glib-integration.h>
#include "config.h"
#define USE_PLUGINS 1
#include "debug.h"
#include "plugin.h"
#include "item.h"
#include "config_.h"
#include "navit.h"
#include "search.h"
#include "callback.h"
#include "event.h"
#include "coord.h"
#include "transform.h"
#include "map.h"
#include "mapset.h"
#include <algorithm>
#include <unistd.h>

#include <CommonAPI/CommonAPI.hpp>
#include <CommonTypes.hpp>
#include <NavigationTypes.hpp>
#include <POIContentAccessModuleStubDefault.hpp>
#include <POIContentAccessProxy.hpp>

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

using namespace v4::org::genivi::navigation::poiservice;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

static bool
do_sort_distance(POIServiceTypes::PoiCAMDetails a, POIServiceTypes::PoiCAMDetails b)
{
    return a.getDistance() < b.getDistance();
}

static std::shared_ptr<POIContentAccessProxyDefault> myServicePOIContentAccess;

class POIContentAccessModuleServerStub : public POIContentAccessModuleStubDefault
{
public:

#define MAX_POI_SEARCH_SIZE 256

POIContentAccessModuleServerStub()
{
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

    m_languageCode = m_SupportedLocales.at(0).getLanguageCode();
    m_countryCode = m_SupportedLocales.at(0).getCountryCode();
    m_scriptCode = m_SupportedLocales.at(0).getScriptCode();

    m_mapset=NULL;
    m_msh=NULL;
    m_map_rect=NULL;
}

/**
 * description: This method returns the API version implemented by the content access module.
 */
void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply){
    _reply(m_version);
}

/**
 * description: Set the current language set for the search by poi provider module.         The
 *   language defines the poi and categories name and details language. If the
 *   language is not supported, the default details will be returned in the native
 *   language.
 */
void setLocale(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _languageCode, std::string _countryCode, std::string _scriptCode, setLocaleReply_t _reply){
    std::vector<POIServiceTypes::Settings> changedSettings;

    m_languageCode = _languageCode;
    m_countryCode = _countryCode;
    m_scriptCode = _scriptCode;

    m_maxSize = MAX_POI_SEARCH_SIZE;

    changedSettings.push_back(POIServiceTypes::Settings::LOCALE);

    fireConfigurationChangedEvent(changedSettings);
}

/**
 * description: Get the current language set for the search by poi provider module.
 */
void getLocale(const std::shared_ptr<CommonAPI::ClientId> _client, getLocaleReply_t _reply){
    _reply(m_languageCode,m_countryCode,m_scriptCode);
}

/**
 * description: Get the supported set of locales for the search by poi provider module.
 */
void getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedLocalesReply_t _reply){
    _reply(m_SupportedLocales);
}

/**
 * description: This method retrieves the list od POI categories available (pre-defined and
 *   custom).
 */
void getAvailableCategories(const std::shared_ptr<CommonAPI::ClientId> _client, getAvailableCategoriesReply_t _reply){
    throw DBus::ErrorNotSupported("Not yet supported");
}

/**
 * description: Get the root category id. That would be ALL_CATEGORIES.
 */
void getRootCategory(const std::shared_ptr<CommonAPI::ClientId> _client, getRootCategoryReply_t _reply){
    throw DBus::ErrorNotSupported("Not yet supported");
}

/**
 * description: Get the children categories id and type (top level) from the a parent unique id.
 */
void getChildrenCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::CommonTypes::CategoryID _category, getChildrenCategoriesReply_t _reply){
    throw DBus::ErrorNotSupported("Not yet supported");
}

/**
 * description: Get the parent categories id and type (top level) from the a unique id.
 */
void getParentCategories(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::CommonTypes::CategoryID _category, getParentCategoriesReply_t _reply){
    throw DBus::ErrorNotSupported("Not yet supported");
}

/**
 * description: Creates a category by name and return an unique id.
 */
void createCategory(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::CAMCategory _category, createCategoryReply_t _reply){
    throw DBus::ErrorNotSupported("Not yet supported");
}

/**
 * description: Removes a list of categories. Because of required time to remove it from the
 *   database, a signal is emitted when the deletion is done.
 */
void removeCategories(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _categories, removeCategoriesReply_t _reply){
    throw DBus::ErrorNotSupported("Not yet supported");
}

/**
 * description: Adds a list of POIs to a category. Because of required time to add it to the
 *   database, a signal is emitted when the update is done, that gives the id of
 *   the elements added
 */
void addPOIs(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::CommonTypes::CategoryID _unique_id, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::PoiAddedDetails> _poiList, addPOIsReply_t _reply){
    throw DBus::ErrorNotSupported("Not yet supported");
}

/**
 * description: Removes a list of POIs to a category. Because of required time to remove it
 *   from the database, a signal is emitted when the update is done.
 */
void removePOIs(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::POI_ID> _ids, removePOIsReply_t _reply){
    throw DBus::ErrorNotSupported("Not yet supported");
}

/**
 * description: This method is sent by the POI service component to inform all the CAM that a
 *   new POI search was started.         It provides all the relevant search
 *   parameters. Of course the CAM will only be aware of the search if it registers
 *   one of the search categories.
 */
void poiSearchStarted(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, uint16_t _maxSize, ::v4::org::genivi::navigation::NavigationTypes::Coordinate3D _location, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::CategoryAndRadius> _poiCategories, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::AttributeDetails> _poiAttributes, std::string _inputString, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::SortOption _sortOption, poiSearchStartedReply_t _reply){
    struct attr navit;
    struct coord_geo g;
    dbg(lvl_debug,"enter handle=%d size=%d location=%f,%f,%d string='%s' sortOption=%d\n",_poiSearchHandle, _maxSize, _location.getLatitude(),_location.getLongitude(),_location.getAltitude(), _inputString.c_str(), _sortOption);
    m_maxSize = _maxSize;
    m_resultList.resize(0);
    m_max_radius=0;
    for (size_t i = 0 ; i < _poiCategories.size(); i++) {
        dbg(lvl_debug,"category %d %d\n",_poiCategories[i].getId(),_poiCategories[i].getRadius());
        if (m_max_radius < _poiCategories[i].getRadius())
            m_max_radius=_poiCategories[i].getRadius();
    }
    for (size_t i = 0 ; i < _poiAttributes.size(); i++) {
        dbg(lvl_debug,"attribute %d %d %d %d %d\n",_poiAttributes[i].getId(), _poiAttributes[i].getCategoryId(), _poiAttributes[i].getType(), _poiAttributes[i].getValue(), _poiAttributes[i].getOper());
    }
    dbg(lvl_debug,"max radius %d\n",m_max_radius);
    if (!m_mapset) {
        if (!config_get_attr(config, attr_navit, &navit, NULL)) {
            dbg(lvl_debug,"failed to get navit\n");
            return;
        }
        m_mapset=navit_get_mapset(navit.u.navit);
    }
    dbg(lvl_debug,"mapset %p\n",m_mapset);
    g.lat=_location.getLatitude();
    g.lng=_location.getLongitude();
    transform_from_geo(projection_mg, &g, &m_center);
    dbg(lvl_debug,"c 0x%x,0x%x\n",m_center.x,m_center.y);
    m_scale=transform_scale(m_center.y);
    int d=m_max_radius*10/m_scale;
    m_selection.next=NULL;
    m_selection.u.c_rect.rl=m_center;
    m_selection.u.c_rect.rl.x+=d;
    m_selection.u.c_rect.rl.y-=d;
    m_selection.u.c_rect.lu=m_center;
    m_selection.u.c_rect.lu.x-=d;
    m_selection.u.c_rect.lu.y+=d;
    m_selection.order=18;
    m_selection.range.min=type_poi_fuel;
    m_selection.range.max=type_poi_fuel;
    dbg(lvl_debug,"rect 0x%x,0x%x-0x%x,0x%x\n",m_selection.u.c_rect.lu.x,m_selection.u.c_rect.lu.y,m_selection.u.c_rect.rl.x,m_selection.u.c_rect.rl.y);
    if (m_msh)
        mapset_close(m_msh);
    m_msh=mapset_open(m_mapset);
    map_next();
    if (_sortOption == POIServiceTypes::SortOption::SORT_BY_DISTANCE)
        m_sort_func=do_sort_distance;
    else
        m_sort_func=NULL;

}

/**
 * description: This method cancels the search for the current id.
 */
void poiSearchCanceled(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, poiSearchCanceledReply_t _reply){
    dbg(lvl_debug,"enter\n");
}

/**
 * description: This method provides the poi results list found by the CAM.         As the POI
 *   unique id is managed by the POI component, the CAM only provides the POI name,
 *   the category and coordinates as well as all the relevant detailed information.
 */
void resultListRequested(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::poiservice::POIServiceTypes::ContentAccessModuleID _camId, ::v4::org::genivi::navigation::NavigationTypes::Handle _poiSearchHandle, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::AttributeID> _attributeList, resultListRequestedReply_t _reply){
    struct item *item;
    int count=0;
    POIServiceTypes::SearchStatusState _statusValue;
    std::vector<POIServiceTypes::PoiAttribute> attributeList;

    m_resultList.clear();
    dbg(lvl_debug,"enter camId=%d handle=%d\n", _camId, _poiSearchHandle);
    while (m_resultList.size() < m_maxSize && m_map_rect) {
        while (m_resultList.size() < m_maxSize && (item=map_rect_get_item(m_map_rect))) {
            if (item->type == type_poi_fuel)
            {
                struct attr label;
                struct coord c;
                dbg(lvl_debug,"adding poi\n");
                POIServiceTypes::PoiCAMDetails  result;
                POIServiceTypes::PoiAttribute attribute;
                NavigationTypes::Coordinate3D location;
                result.setSourceId(m_resultList.size());
                if (item_attr_get(item, attr_label, &label))
                    result.setName(std::string(label.u.str));
                else
                    result.setName(std::string(""));
                result.setCategory(m_poiCategoriesId[0]);
                if (item_coord_get(item, &c, 1)) {
                    struct coord_geo g;
                    transform_to_geo(projection_mg, &c, &g);
                    location.setLatitude(g.lat);
                    location.setLongitude(g.lng);
                    location.setAltitude(0);
                    result.setLocation(location);
                    double distance=transform_distance(projection_mg, &m_center, &c)/m_scale;
            #if 0
                    if (distance > m_max_radius)
                        return;
            #endif
                    result.setDistance(distance);
                } else {
                    location.setLatitude(0);
                    location.setLongitude(0);
                    location.setAltitude(0);
                    result.setLocation(location);
                    result.setDistance(0);
                }
                /* result._6 attributes */
                attribute.setId(0);
                attribute.setType(POIServiceTypes::AttributeType::STRING);
                attribute.setValue(std::string(""));
                attributeList.push_back(attribute);
                result.setAttributeList(attributeList);
                m_resultList.push_back(result);
            }
            count++;
        }
        map_next();
    }
    dbg(lvl_debug,"got %d items\n",count);
    _statusValue=POIServiceTypes::SearchStatusState::FINISHED;
    if (m_sort_func)
        std::sort(m_resultList.begin(), m_resultList.end(), m_sort_func);

    _reply(_statusValue,m_resultList.size(),m_resultList);
}

/**
 * description: This method retrieves the details associated to one or more POI. It
 *   contains the name, the parent categories, the list of attributes, the icons,
 *   ... .
 */
void poiDetailsRequested(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector< ::v4::org::genivi::navigation::poiservice::POIServiceTypes::POI_ID> _source_id, poiDetailsRequestedReply_t _reply){
    dbg(lvl_debug,"enter\n");
    std::vector< POIServiceTypes::SearchResultDetails> _results;
    NavigationTypes::Coordinate3D location;
    POIServiceTypes::PoiDetails details;
    std::vector<POIServiceTypes::PoiAttribute> attributeList;
    std::vector< CommonTypes::CategoryID > poiCategoriesId;
    poiCategoriesId.push_back(m_poiCategoriesId[0]);
    for (size_t i = 0 ; i < _source_id.size() ; i++) {
        int sid=_source_id[i];
        POIServiceTypes::SearchResultDetails result;
        details.setId(sid);
        details.setName(m_resultList[sid].getName());
        location = m_resultList[sid].getLocation();
        details.setLocation(location);
        result.setDetails(details);
        result.setCategories(poiCategoriesId);
        _results.push_back(result);
    }
    _reply(_results);
}

void
map_next(void)
{
    m_map=mapset_next(m_msh, 1);
    if (m_map_rect)
        map_rect_destroy(m_map_rect);
    if (m_map)
        m_map_rect=map_rect_new(m_map, &m_selection);
    else
        m_map_rect=NULL;
}

void
register_cam(void)
{
    CommonAPI::CallStatus status;
    POIServiceTypes::ContentAccessModuleID camId;

    myServicePOIContentAccess->registerContentAccessModule(std::string("org.genivi.poiservice.POIContentAccessModuleNavit"),status,camId);
    dbg(lvl_debug,"camid=%d\n",camId);

    std::vector<POIServiceTypes::CAMCategory> poiCategories;
    POIServiceTypes::CAMCategory poiCategory;
    POIServiceTypes::Details poiDetails;
    poiDetails.setIcons(std::string(""));
    poiDetails.setName("fuel");
    poiDetails.setMedia(std::string(""));
    poiCategory.setDetails(poiDetails);
    poiCategories.push_back(poiCategory);

    myServicePOIContentAccess->addCategories(camId,poiCategories,status,m_poiCategoriesId);

    myServicePOIContentAccess->registerPoiCategories(camId,m_poiCategoriesId,status);
}

private:

    CommonTypes::Version m_version;
    std::vector< CommonTypes::CategoryID > m_poiCategoriesId;
    std::vector<POIServiceTypes::PoiCAMDetails> m_resultList;
    uint32_t m_max_radius;
    bool (*m_sort_func)(POIServiceTypes::PoiCAMDetails a, POIServiceTypes::PoiCAMDetails b);
    struct coord m_center;
    double m_scale;
    struct mapset *m_mapset;
    struct mapset_handle *m_msh;
    struct map *m_map;
    struct map_rect *m_map_rect;
    struct map_selection m_selection;
    std::vector< NavigationTypes::Locale> m_SupportedLocales;
    std::string m_languageCode, m_countryCode, m_scriptCode;
    uint16_t m_maxSize;

};

void
plugin_init(void)
{
	dbg(lvl_debug,"enter\n");
    event_request_system("glib","genivi_poiservice");

    // Common API data init
    std::shared_ptr < CommonAPI::Runtime > runtime = CommonAPI::Runtime::get();

    const std::string domain = "local";
    const std::string instancePOIContentAccessModule = "POIContentAccessModuleService";

    std::shared_ptr<POIContentAccessModuleServerStub> myServicePOIContentAccessModule = std::make_shared<POIContentAccessModuleServerStub>();

    bool successfullyRegistered = runtime->registerService(domain, instancePOIContentAccessModule, myServicePOIContentAccessModule);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instancePOIContentAccessModule, myServicePOIContentAccessModule);
    }

    const std::string instancePOIContentAccess = "POIContentAccess";

/*    myServicePOIContentAccess = runtime->buildProxy<POIContentAccessProxy>(domain, instancePOIContentAccess);

    while (!myServicePOIContentAccess->isAvailable()) {
        usleep(10);
    }

    myServicePOIContentAccessModule->register_cam();
*/
}
