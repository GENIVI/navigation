/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_navigationcore_routing.cxx
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
#include "coord.h"
#include "config_.h"
#include "navit.h"
#include "route.h"
#include "transform.h"
#include "command.h"
#include "callback.h"
#include "vehicle.h"
#include "xmlconfig.h"
#include "vehicleprofile.h"
#include "roadprofile.h"
#include "map.h"
#include "event.h"

#include <CommonAPI/CommonAPI.hpp>
#include <CommonTypes.hpp>
#include <NavigationTypes.hpp>
#include <NavigationCoreTypes.hpp>
#include <RoutingStubDefault.hpp>

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

using namespace v4::org::genivi::navigation::navigationcore;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

struct vehicleprofile_settings {
	int flags_forward_mask,flags_reverse_mask;
	int ferry_weight;
	int highway_city_weight;
	int highway_land_weight;
};

class RoutingServerStub;

class RoutingObj
{
public:
    RoutingObj(RoutingServerStub *routing, uint32_t session, uint32_t handle);
    ~RoutingObj();
    void map_to_pcoord(Routing::WayPoint map, struct pcoord *pc);
    void SetCostModel(uint32_t SessionHandle, Routing::CostModel CostModel);
    void GetCostModel(Routing::CostModel &CostModel);
    void SetWaypoints(uint32_t SessionHandle, bool StartFromCurrentPosition, std::vector< Routing::WayPoint > Waypoints);
    void GetWaypoints(bool& StartFromCurrentPosition, std::vector<Routing::WayPoint> &Waypoints);
    void CalculateRoute(uint32_t SessionHandle);
    void GetRouteSegments(int16_t detailLevel , const std::vector< Routing::RouteSegmentType >& valuesToReturn, const uint32_t& numberOfSegments, const uint32_t& offset, uint32_t& totalNumberOfSegments, std::vector<Routing::RouteSegment>& RouteSegments);
    void GetRouteOverview(uint32_t routeHandle , Routing::RouteOverview &routeOverview);
    void GetRouteBoundingBox(NavigationTypes::Rectangle &boundingBox);
    void CancelRouteCalculation(uint32_t sessionHandle);
    bool RoutePreference(Routing::PreferenceMode preferenceMode,Routing::RoutePreferenceSource preferenceSource);
    void SetRoutePreferences(uint32_t sessionHandle, const std::string& country, const std::vector< Routing::RoutePreference >& routePreferencesList);
    void GetRoutePreferences(const std::string& country, std::vector< Routing::RoutePreference >& roadPreferenceList);

    uint32_t m_handle;
    RoutingServerStub *mp_routing;
    int m_route_status;
    struct attr m_route,m_vehicleprofile;

private:
    struct search_list *m_sl;
    uint32_t m_session;
    Routing::CostModel m_costmodel;
    std::vector< Routing::RoutePreference > m_route_preferences_list[2];
    std::vector< Routing::WayPoint > m_waypoints;
    bool m_startfromcurrentposition;
    int m_vehicleprofile_idx;
    struct vehicleprofile_settings m_vehicleprofile_settings[2];
    struct callback *m_callback;
    struct navit *get_navit(void);
    struct mapset *get_mapset(struct navit *navit);
    struct route *get_route(struct navit *navit);
    struct vehicle *get_vehicle(struct navit *navit);
    struct tracking *get_tracking(void);
};

static std::map<uint32_t, RoutingObj *> mp_handles;

static bool commands_registered;

static void
navit_genivi_get_route(struct navit *nav, char *function, struct attr **in, struct attr ***out, int *valid)
{
	if (!out || !in || !in[0])
		return;
	if (!ATTR_IS_INT(in[0]->type))
		return;
    RoutingObj *obj=mp_handles[in[0]->u.num];
	if (!obj)
		return;
	*out=attr_generic_add_attr(*out, &obj->m_route);
	*out=attr_generic_add_attr(*out, &obj->m_vehicleprofile);
}

static struct command_table commands[] = {
	{"navit_genivi_get_route",command_cast(navit_genivi_get_route)},
};

class  RoutingServerStub : public RoutingStubDefault
{
	public:

#define MAX_ROUTE_HANDLES 256

    RoutingServerStub()
	{
        m_version.setVersionMajor(3);
        m_version.setVersionMinor(0);
        m_version.setVersionMicro(0);
        m_version.setDate("21-01-2014");
    }

    /**
     * description: This method returns the API version implemented by the server application
     */
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply) {
        _reply(m_version);
    }

    /**
     * description: This method creates a route
     */
    void createRoute(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, createRouteReply_t _reply){
        dbg(lvl_debug,"enter\n");
        NavigationTypes::Handle routeHandle=1;
        while (mp_handles[routeHandle]) {
            routeHandle++;
            if (routeHandle == MAX_ROUTE_HANDLES)
                throw DBus::ErrorLimitsExceeded("Out of route handles");
        }
        mp_handles[routeHandle]=new RoutingObj(this, _sessionHandle, routeHandle);
        _reply(routeHandle);
    }

    /**
     * description: This method deletes a route and its associated resources
     */
    void deleteRoute(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, deleteRouteReply_t _reply){
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        delete(obj);
        mp_handles[_routeHandle]=NULL;
        fireRouteDeletedEvent(_routeHandle);
        _reply();
    }

    /**
     * description: This method sets the cost model
     */
    void setCostModel(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, Routing::CostModel _costModel, setCostModelReply_t _reply){
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->SetCostModel(_sessionHandle, _costModel);
        _reply();
    }

    /**
     * description: This method retrieves the selected cost model
     */
    void getCostModel(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, getCostModelReply_t _reply){
        Routing::CostModel costModel;
        dbg(lvl_debug,"enter\n");
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetCostModel(costModel);
        _reply(costModel);
    }

    /**
     * description: This method retrieves a list of supported cost models
     */
    void getSupportedCostModels(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedCostModelsReply_t _reply){
        std::vector< Routing::CostModel > costModels;
        costModels.resize(2);
        costModels[0]=Routing::CostModel::FASTEST;
        costModels[1]=Routing::CostModel::SHORTEST;
        _reply(costModels);
    }

    /**
     * description: This method sets a list of route preferences
     */
    void setRoutePreferences(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, std::string _countryCode, std::vector<Routing::RoutePreference> _roadPreferenceList, std::vector<Routing::ConditionPreference> _conditionPreferenceList, setRoutePreferencesReply_t _reply){
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->SetRoutePreferences(_sessionHandle, _countryCode, _roadPreferenceList);
        _reply();
    }

    /**
     * description: This method retrieves a list of selected route preferences
     */
    void getRoutePreferences(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, std::string _countryCode, getRoutePreferencesReply_t _reply){
        Routing::RoutePreference routePreference;
        std::vector<Routing::RoutePreference> _roadPreferenceList;
        Routing::ConditionPreference conditionPreference;
        std::vector<Routing::ConditionPreference> _conditionPreferenceList;

        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetRoutePreferences(_countryCode, _roadPreferenceList);
        if (_roadPreferenceList.size() == 0)
        { //add a default value (bug in qml to be fixed)
            routePreference.setMode(Routing::PreferenceMode::INVALID);
            routePreference.setSource(Routing::RoutePreferenceSource::INVALID);
            _roadPreferenceList.push_back(routePreference);
        }
        conditionPreference.setMode(Routing::PreferenceMode::USE);
        conditionPreference.setSource(Routing::ConditionPreferenceSource::TRAFFIC_REALTIME);
        _conditionPreferenceList.push_back(conditionPreference); //by default
        _reply(_roadPreferenceList,_conditionPreferenceList);
    }

    /**
     * description: This method retrieves a list of supported route preferences
     */
    void getSupportedRoutePreferences(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedRoutePreferencesReply_t _reply){
        Routing::RoutePreference routePreference;
        std::vector<Routing::RoutePreference> _routePreferencesList;
        Routing::ConditionPreference conditionPreference;
        std::vector<Routing::ConditionPreference> _conditionPreferenceList;
        routePreference.setMode(Routing::PreferenceMode::AVOID);
        routePreference.setSource(Routing::RoutePreferenceSource::HIGHWAYS_MOTORWAYS);
        _routePreferencesList.push_back(routePreference);
        routePreference.setMode(Routing::PreferenceMode::AVOID);
        routePreference.setSource(Routing::RoutePreferenceSource::TOLL_ROADS);
        _routePreferencesList.push_back(routePreference);
        routePreference.setMode(Routing::PreferenceMode::AVOID);
        routePreference.setSource(Routing::RoutePreferenceSource::FERRY);
        _routePreferencesList.push_back(routePreference);
        conditionPreference.setMode(Routing::PreferenceMode::USE);
        conditionPreference.setSource(Routing::ConditionPreferenceSource::TRAFFIC_REALTIME);
        _conditionPreferenceList.push_back(conditionPreference);
        _reply(_routePreferencesList,_conditionPreferenceList);
    }

    /**
     * description: This method sets the time schedule for the route to be calculated
     */
    void setRouteSchedule(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, Routing::RouteSchedule _routeSchedule, setRouteScheduleReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
        _reply();
    }

    /**
     * description: This method gets the time schedule for the route to be calculated
     */
    void getRouteSchedule(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, std::vector<Routing::Schedule> _valuesToReturn, getRouteScheduleReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: This method sets a list of means of transportation that must be considered when
     *   calculating a route
     */
    void setTransportationMeans(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, std::vector<Routing::TransportationMeans> _transportationMeansList, setTransportationMeansReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
        _reply();
    }

    /**
     * description: getTransportationMeans = This method retrieves the selected means of
     *   transportation
     */
    void getTransportationMeans(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, getTransportationMeansReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getSupportedTransportationMeans = This method retrieves a list of supported
     *   means of transportation
     */
    void getSupportedTransportationMeans(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedTransportationMeansReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setExcludedAreas = This method sets the areas to be excluded when calculating a
     *   route
     */
    void setExcludedAreas(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, std::vector< ::v4::org::genivi::navigation::NavigationTypes::Polygon> _excludedAreas, setExcludedAreasReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
        _reply();
    }

    /**
     * description: getExcludedAreas = This method retrieves the areas to be excluded when
     *   calculating a route
     */
    void getExcludedAreas(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, getExcludedAreasReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setWaypoints = This method sets a list of waypoints
     */
    void setWaypoints(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, bool _startFromCurrentPosition, std::vector<Routing::WayPoint> _waypointsList, setWaypointsReply_t _reply){
        dbg(lvl_debug,"enter\n");
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->SetWaypoints(_sessionHandle, _startFromCurrentPosition, _waypointsList);
        _reply();
    }

    /**
     * description: getWaypoints = This method retrieves a list of waypoints
     */
    void getWaypoints(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, getWaypointsReply_t _reply){
        dbg(lvl_debug,"enter\n");
        bool _startFromCurrentPosition;
        std::vector<Routing::WayPoint> _waypointsList;
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetWaypoints(_startFromCurrentPosition, _waypointsList);
        _reply(_startFromCurrentPosition,_waypointsList);
    }

    /**
     * description: calculateRoute = This method starts a route calculation
     */
    void calculateRoute(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, calculateRouteReply_t _reply){
        dbg(lvl_debug,"enter\n");
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->CalculateRoute(_sessionHandle);
        _reply();
    }

    /**
     * description: cancelRouteCalculation = This method cancels a route calculation
     */
    void cancelRouteCalculation(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, cancelRouteCalculationReply_t _reply){
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->CancelRouteCalculation(_sessionHandle);
        fireRouteCalculationCancelledEvent(_routeHandle);
        _reply();
    }

    /**
     * description: calculateRoutes = This method allows a client to calculate alternative routes
     *   that differs from a list of already calculated routes
     */
    void calculateRoutes(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, std::vector< ::v4::org::genivi::navigation::NavigationTypes::Handle> _calculatedRoutesList, calculateRoutesReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getRouteSegments = This method retrieves a list of segments for a given route
     *   starting from the one closest to the current position to the one closest to
     *   the destination
     */
    void getRouteSegments(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, int16_t _detailLevel, std::vector<Routing::RouteSegmentType> _valuesToReturn, uint32_t _numberOfSegments, uint32_t _offset, getRouteSegmentsReply_t _reply){
        dbg(lvl_debug,"enter\n");
        uint32_t _totalNumberOfSegments;
        std::vector<Routing::RouteSegment> _routeSegments;
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetRouteSegments(_detailLevel,_valuesToReturn, _numberOfSegments, _offset, _totalNumberOfSegments, _routeSegments);
        _reply(_totalNumberOfSegments,_routeSegments);
    }

    /**
     * description: getRouteOverview = This method retrieves general information about a given route
     */
    void getRouteOverview(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, std::vector<Routing::RouteOverviewType> _valuesToReturn, getRouteOverviewReply_t _reply){
        Routing::RouteOverview _routeOverview;
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetRouteOverview(_routeHandle, _routeOverview);
        _reply(_routeOverview);

    }

    /**
     * description: getRouteBoundingBox = This method retrieves the bounding box containing a
     *   calculated route
     */
    void getRouteBoundingBox(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, getRouteBoundingBoxReply_t _reply){
        NavigationTypes::Rectangle _boundingBox;
        RoutingObj *obj=mp_handles[_routeHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetRouteBoundingBox(_boundingBox);
        _reply(_boundingBox);

    }

    /**
     * description: getAllRoutes = This method retrieves the handles of all created routes
     */
    void getAllRoutes(const std::shared_ptr<CommonAPI::ClientId> _client, getAllRoutesReply_t _reply){
        std::vector< NavigationTypes::Handle >_routesList;
        std::map<uint32_t, RoutingObj *>::const_iterator itr;

        for(itr = mp_handles.begin(); itr != mp_handles.end(); itr++)
            _routesList.push_back((*itr).first);
        _reply(_routesList);
    }

    /**
     * description: setBlockedRouteStretches = This method sets blocked streches on a given route
     */
    void setBlockedRouteStretches(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, std::vector<Routing::BlockedRouteElement> _blockParameters, setBlockedRouteStretchesReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
        _reply();
    }

    /**
     * description: getBlockedRouteStretches = This method retrieves all blocked streches on a
     *   given route
     */
    void getBlockedRouteStretches(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, getBlockedRouteStretchesReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }
	
private:
    CommonTypes::Version m_version;
    std::map<NavigationTypes::Handle, RoutingObj *> mp_handles;

};

struct navit *
RoutingObj::get_navit(void)
{
    struct attr navit,callback_list;
    if (!config_get_attr(config, attr_navit, &navit, NULL))
        return NULL;

    if (!commands_registered && navit_get_attr(navit.u.navit, attr_callback_list, &callback_list, NULL)) {
        command_add_table(callback_list.u.callback_list, commands, sizeof(commands)/sizeof(struct command_table), navit.u.navit);
        commands_registered=true;
    }

    return navit.u.navit;
}

struct mapset *
RoutingObj::get_mapset(struct navit *navit)
{
    struct attr mapset;
    if (!navit_get_attr(navit, attr_mapset, &mapset, NULL))
        return NULL;
    return mapset.u.mapset;
}

struct route *
RoutingObj::get_route(struct navit *navit)
{
    struct attr route;
    if (!navit_get_attr(navit, attr_route, &route, NULL))
        return NULL;
    return route.u.route;
}

struct vehicle *
RoutingObj::get_vehicle(struct navit *navit)
{
    struct attr vehicle;
    if (!navit_get_attr(navit, attr_vehicle, &vehicle, NULL))
        return NULL;
    return vehicle.u.vehicle;
}

struct tracking *
RoutingObj::get_tracking(void)
{
    struct navit *navit=get_navit();
    struct attr tracking;
    if (!navit)
        return NULL;
    if (!navit_get_attr(navit, attr_trackingo, &tracking, NULL))
        return NULL;
    return tracking.u.tracking;
}

void
RoutingObj_Callback(struct RoutingObj *obj)
{
    struct attr route_status;
    if (!route_get_attr(obj->m_route.u.route, attr_route_status, &route_status, NULL)) {
        dbg(lvl_debug,"failed to get route status\n");
        return;
    }
    if (route_status.u.num == route_status_destination_set) {
        obj->mp_routing->fireRouteCalculationProgressUpdateEvent(obj->m_handle, Routing::CalculationStatus::CALCULATION_OK, 5);
        obj->m_route_status=route_status.u.num;
    }
    if (route_status.u.num == route_status_building_graph) {
        obj->m_route_status=route_status.u.num;
    }
    if (route_status.u.num == route_status_building_path && obj->m_route_status == route_status_building_graph) {
        obj->mp_routing->fireRouteCalculationProgressUpdateEvent(obj->m_handle, Routing::CalculationStatus::CALCULATION_OK, 50);
        obj->m_route_status=route_status.u.num;
    }
    if (route_status.u.num == route_status_path_done_new ||
        (obj->m_route_status==route_status_destination_set && route_status.u.num == route_status_path_done_incremental)) {
        if (route_status.u.num == route_status_path_done_new)
            obj->mp_routing->fireRouteCalculationProgressUpdateEvent(obj->m_handle, Routing::CalculationStatus::CALCULATION_OK, 100);
        obj->m_route_status=route_status.u.num;
        dbg(lvl_debug,"callback routing ok\n");
        Routing::UnfullfilledRoutePreference unfulfilled_preferences;
        //tbd complete the unfulfilled_preferences
        obj->mp_routing->fireRouteCalculationSuccessfulEvent(obj->m_handle, unfulfilled_preferences);
    }
    if (route_status.u.num == route_status_not_found) {
        obj->m_route_status=route_status.u.num;
        dbg(lvl_debug,"callback routing failed\n");
        Routing::UnfullfilledRoutePreference unfulfilled_preferences;
        //tbd complete the unfulfilled_preferences
        obj->mp_routing->fireRouteCalculationFailedEvent(obj->m_handle, Routing::CalculationError::UNREACHABLE_DESTINATION, unfulfilled_preferences);
    }
}

RoutingObj::RoutingObj(RoutingServerStub *routing, uint32_t session, uint32_t handle)
{
    struct attr callback;

    mp_routing=routing;
    m_session=session;
    m_handle=handle;
    m_route.type=attr_route;
    m_route.u.route=route_new(NULL, NULL);
    m_vehicleprofile.type=attr_vehicleprofile;
    m_vehicleprofile.u.vehicleprofile=NULL;
    m_callback=callback_new_attr_1(reinterpret_cast<void (*)(void)>(RoutingObj_Callback), attr_route_status, this);
    memset(m_vehicleprofile_settings, 0, sizeof(m_vehicleprofile_settings));
    SetCostModel(handle, Routing::CostModel::FASTEST);
    callback.type=attr_callback;
    callback.u.callback=m_callback;
    route_add_attr(m_route.u.route, &callback);
    route_set_mapset(m_route.u.route, get_mapset(get_navit()));
}

RoutingObj::~RoutingObj()
{
    struct attr callback;

    callback.type=attr_callback;
    callback.u.callback=m_callback;
    route_remove_attr(m_route.u.route, &callback);
    callback_destroy(m_callback);
    route_destroy(m_route.u.route);
}

void
RoutingObj::SetCostModel(uint32_t SessionHandle, Routing::CostModel CostModel)
{
    const char *vehicleprofile_name;
    switch (CostModel) {
    case Routing::CostModel::FASTEST:
        vehicleprofile_name="car";
        m_vehicleprofile_idx=0;
        break;
    case Routing::CostModel::SHORTEST:
        vehicleprofile_name="car_shortest";
        m_vehicleprofile_idx=1;
        break;
    default:
        throw DBus::ErrorInvalidArgs("Invalid cost model");
    }
    m_costmodel=CostModel;
    m_vehicleprofile.u.vehicleprofile=NULL;
    GList *vehicleprofiles=navit_get_vehicleprofiles(get_navit());

    while (vehicleprofiles) {
        struct attr name;
        if (vehicleprofile_get_attr((struct vehicleprofile *)vehicleprofiles->data, attr_name, &name, NULL)) {
            if ((!strcmp(name.u.str,vehicleprofile_name))) {
                m_vehicleprofile.u.vehicleprofile=(struct vehicleprofile *)vehicleprofiles->data;
                break;
            }
        }
        vehicleprofiles=g_list_next(vehicleprofiles);
    }
    if (!m_vehicleprofile.u.vehicleprofile)
        throw DBus::ErrorFailed("internal error:no vehicleprofile found");
}

void
RoutingObj::GetCostModel(Routing::CostModel &CostModel)
{
    CostModel=m_costmodel;
}

void
RoutingObj::SetWaypoints(uint32_t SessionHandle, bool StartFromCurrentPosition, std::vector<Routing::WayPoint> Waypoints)
{
    if (StartFromCurrentPosition) {
        if (Waypoints.size() != 1)
            throw DBus::ErrorFailed("StartFromCurrentPosition is set, but Waypoint size is not 1");
    } else {
        if (Waypoints.size() != 2)
            throw DBus::ErrorFailed("StartFromCurrentPosition is not set, but Waypoint size is not 2");
    }
    for (size_t i=0 ; i < Waypoints.size(); i++) {
        if (Waypoints[i].find(Routing::WaypointElementType::LATITUDE) == Waypoints[i].end())
            throw DBus::ErrorInvalidArgs("Waypoint doesn't contain Latitude");
        if (Waypoints[i].find(Routing::WaypointElementType::LONGITUDE) == Waypoints[i].end())
            throw DBus::ErrorInvalidArgs("Waypoint doesn't contain Longitude");
    }
    m_startfromcurrentposition=StartFromCurrentPosition;
    m_waypoints=Waypoints;

}

void
RoutingObj::GetWaypoints(bool& StartFromCurrentPosition, std::vector< Routing::WayPoint >& Waypoints)
{
    StartFromCurrentPosition=m_startfromcurrentposition;
    Waypoints=m_waypoints;
}

void
RoutingObj::map_to_pcoord(Routing::WayPoint map, struct pcoord *pc)
{
    struct coord_geo g;
    struct coord c;
    g.lat=(map[Routing::WaypointElementType::LATITUDE]).get<double>();
    g.lng=(map[Routing::WaypointElementType::LONGITUDE]).get<double>();
    transform_from_geo(projection_mg, &g, &c);
    pc->pro=projection_mg;
    pc->x=c.x;
    pc->y=c.y;
    dbg(lvl_debug,"lat %f lon %f is 0x%x,0x%x\n",g.lat,g.lng,pc->x,pc->y);

}

void
RoutingObj::CalculateRoute(uint32_t SessionHandle)
{
    struct pcoord pc;

    if (!m_waypoints.size())
        throw DBus::ErrorFailed("no waipoints set");
    route_set_profile(m_route.u.route,m_vehicleprofile.u.vehicleprofile);
    if (!m_startfromcurrentposition) {
        route_set_destination(m_route.u.route, NULL, 0);
        map_to_pcoord(m_waypoints[0], &pc);
        route_set_position(m_route.u.route, &pc);
        map_to_pcoord(m_waypoints[1], &pc);
    } else {
        struct tracking *tracking=get_tracking();
        if (tracking)
            route_set_position_from_tracking(m_route.u.route, tracking, projection_mg);
        map_to_pcoord(m_waypoints[0], &pc);
    }
    m_route_status = route_status_destination_set;
    route_set_destination(m_route.u.route, &pc, 1);
}

static bool
vector_contains(const std::vector< Routing::RouteSegmentType >& vector, Routing::RouteSegmentType val)
{
    size_t i;
	for (i = 0 ; i < vector.size() ; i++) {
		if (vector[i] == val)
			return true;
	}
	return false;
}

static void
get_map(struct coord *c, struct item *item, int is_end, const std::vector< Routing::RouteSegmentType >& valuesToReturn, Routing::RouteSegment &map)
{
    Routing::RouteSegmentType lat_key=is_end?Routing::RouteSegmentType::END_LATITUDE:Routing::RouteSegmentType::START_LATITUDE;
    Routing::RouteSegmentType lon_key=is_end?Routing::RouteSegmentType::END_LONGITUDE:Routing::RouteSegmentType::START_LONGITUDE;
	if (vector_contains(valuesToReturn, lat_key) || vector_contains(valuesToReturn, lon_key)) {
		struct coord_geo g;
		transform_to_geo(projection_mg, c, &g);
		if (vector_contains(valuesToReturn, lat_key))
            map[lat_key]=(double)g.lat;
		if (vector_contains(valuesToReturn, lon_key))
            map[lon_key]=g.lng;
	}
    if (item && (vector_contains(valuesToReturn, Routing::RouteSegmentType::DISTANCE) || vector_contains(valuesToReturn, Routing::RouteSegmentType::TIME) || vector_contains(valuesToReturn, Routing::RouteSegmentType::SPEED))) {
		struct attr length, time, speed;
        if (item_attr_get(item, attr_length, &length) && vector_contains(valuesToReturn, Routing::RouteSegmentType::DISTANCE)) {
            map[Routing::RouteSegmentType::DISTANCE]=(double)length.u.num;
		}
        if (item_attr_get(item, attr_time, &time) && vector_contains(valuesToReturn, Routing::RouteSegmentType::TIME)) {
            map[Routing::RouteSegmentType::TIME]=(uint32_t)((time.u.num+5)/10);
		}
        if (item_attr_get(item, attr_speed, &speed) && vector_contains(valuesToReturn, Routing::RouteSegmentType::SPEED)) {
            map[Routing::RouteSegmentType::SPEED]=(uint32_t)speed.u.num;
		}
	}
    if (item && vector_contains(valuesToReturn, Routing::RouteSegmentType::ROAD_NAME)) {
		struct attr street_item;
		if (item_attr_get(item, attr_street_item, &street_item)) {
			struct map_rect *mr=map_rect_new(street_item.u.item->map, NULL);
			struct item *item2=map_rect_get_item_byid(mr, street_item.u.item->id_hi, street_item.u.item->id_lo);
			struct attr label;
			if (item2 && item_attr_get(item2, attr_label, &label)) 
                map[Routing::RouteSegmentType::ROAD_NAME]=std::string(label.u.str);
			map_rect_destroy(mr);
		}
	}
}

void RoutingObj::GetRouteSegments(int16_t detailLevel , const std::vector< Routing::RouteSegmentType >& valuesToReturn, const uint32_t& numberOfSegments, const uint32_t& offset, uint32_t& totalNumberOfSegments, std::vector<Routing::RouteSegment>& RouteSegments)
{
    struct map *m=route_get_map(m_route.u.route);
    if (!m)
        throw DBus::ErrorFailed("internal error:failed to get route map");
    struct map_rect *mr=map_rect_new(m, NULL);
    if (!mr)
        throw DBus::ErrorFailed("internal error:failed to create route map rect");
    struct item *item;
    struct coord c[128],last;
    int count,i;
    int pos;
    bool intermediate=vector_contains(valuesToReturn, Routing::RouteSegmentType::INTERMEDIATE_POINTS);
    totalNumberOfSegments=0;
    while ((item=map_rect_get_item(mr))) {
        if (item->type == type_street_route) {
            pos=0;
            if (totalNumberOfSegments >= offset && totalNumberOfSegments < offset+numberOfSegments) {
                std::vector<DBus::Struct<uint16_t, double, double, double> >intermediate_points;
                do {
                    count=item_coord_get(item, c, 128);
                    for (i = 0 ; i < count ; i++) {
                        switch (pos) {
                        case 0: /* last not valid */
                            pos++;
                            break;
                        case 1: /* last is start coordinates */
                            {
                                Routing::RouteSegment map;
                                get_map(&last, item, 0, valuesToReturn, map);
                                RouteSegments.push_back(map);
                                pos++;
                            }
                            break;
                        case 2: /* last is intermediate coordinates */
                            if (intermediate)  {
                                struct coord_geo g;
                                transform_to_geo(projection_mg, &last, &g);
                                DBus::Struct<uint16_t, double, double, double> point;
                                point._1=0;
                                point._2=g.lat;
                                point._3=g.lng;
                                point._4=0;
                                intermediate_points.push_back(point);
                            }
                        }
                        last=c[i];
                    }
                } while (count == 128);
#if 0
                if (intermediate_points.size()) {
                    DBus::Variant variant;
                    DBus::MessageIter iter=variant.writer();
                    iter << intermediate_points;
                    RouteSegments.back()[GENIVI_NAVIGATIONCORE_INTERMEDIATE_POINTS]=variant;
                }
#endif
            }
            totalNumberOfSegments++;
        }
    }
    if (pos == 2) /* last is final coordinates */
        get_map(&last, NULL, 1, valuesToReturn, RouteSegments.back());
    map_rect_destroy(mr);
}

void
RoutingObj::GetRouteOverview(uint32_t routeHandle , Routing::RouteOverview &routeOverview)
{
    struct attr destination_length, destination_time;
    if (!route_get_attr(m_route.u.route,attr_destination_length, &destination_length, NULL))
        throw DBus::ErrorFailed("internal error:failed to get attribute destination_length");
    if (!route_get_attr(m_route.u.route,attr_destination_time, &destination_time, NULL))
        throw DBus::ErrorFailed("internal error:failed to get attribute destination_time");

    routeOverview[Routing::RouteOverviewType::TOTAL_DISTANCE] = (uint32_t)destination_length.u.num;
    routeOverview[Routing::RouteOverviewType::TOTAL_TIME] = (uint32_t)(destination_time.u.num/10);
}

void
RoutingObj::GetRouteBoundingBox(NavigationTypes::Rectangle &boundingBox)
{
    struct coord_rect r;
    struct coord_geo g;
    bool first=true;
    struct map *m=route_get_map(m_route.u.route);
    struct item *item;
    NavigationTypes::Coordinate2D value;
    if (!m)
        throw DBus::ErrorFailed("internal error:failed to get route map");
    struct map_rect *mr=map_rect_new(m, NULL);
    if (!mr)
        throw DBus::ErrorFailed("internal error:failed to create route map rect");
    while ((item=map_rect_get_item(mr))) {
        struct coord c[128];
        int count,i;
        do {
            count=item_coord_get(item, c, 128);
            for (i = 0 ; i < count ; i++) {
                if (first) {
                    first=0;
                    r.lu=c[i];
                    r.rl=c[i];
                } else
                    coord_rect_extend(&r, &c[i]);
            }
        } while (count == 128);
    }
    map_rect_destroy(mr);
    if (first)
        throw DBus::ErrorFailed("no route available");
    dbg(lvl_debug,"bounding box 0x%x,0x%x-0x%x,0x%x\n",r.lu.x,r.lu.y,r.rl.x,r.rl.y);
    transform_to_geo(projection_mg, &r.lu, &g);
    value.setLatitude(g.lat);
    value.setLongitude(g.lng);
    boundingBox.setTopLeft(value);
    dbg(lvl_debug,"%f,%f\n",g.lat,g.lng);
    transform_to_geo(projection_mg, &r.rl, &g);
    value.setLatitude(g.lat);
    value.setLongitude(g.lng);
    boundingBox.setBottomRight(value);
    dbg(lvl_debug,"-%f,%f\n",g.lat,g.lng);
}

void
RoutingObj::CancelRouteCalculation(uint32_t sessionHandle)
{
    route_set_destination(m_route.u.route, NULL, 0);
}

bool
RoutingObj::RoutePreference(Routing::PreferenceMode preferenceMode,Routing::RoutePreferenceSource preferenceSource)
{
    size_t index;

    for (index=0;index<m_route_preferences_list[m_vehicleprofile_idx].size();index++)
    {
        if (((m_route_preferences_list[m_vehicleprofile_idx].at(index)).getSource() == preferenceSource) && ((m_route_preferences_list[m_vehicleprofile_idx].at(index)).getMode() == preferenceMode))
            return true;
    }

    return false;
}

void
RoutingObj::SetRoutePreferences(uint32_t sessionHandle, const std::string& country, const std::vector< Routing::RoutePreference >& routePreferencesList)
{
    int idx;
    struct attr flags_forward_mask,flags_reverse_mask,roadprofile,item_types,route_weight;
    m_route_preferences_list[m_vehicleprofile_idx]=routePreferencesList;
    struct vehicleprofile_settings *s=&m_vehicleprofile_settings[m_vehicleprofile_idx];

    if (!s->flags_forward_mask) {
        vehicleprofile_get_attr(m_vehicleprofile.u.vehicleprofile, attr_flags_forward_mask, &flags_forward_mask, NULL);
        vehicleprofile_get_attr(m_vehicleprofile.u.vehicleprofile, attr_flags_reverse_mask, &flags_reverse_mask, NULL);
        s->flags_forward_mask=flags_forward_mask.u.num;
        s->flags_reverse_mask=flags_reverse_mask.u.num;
    }
    flags_forward_mask.type=attr_flags_forward_mask;
    flags_reverse_mask.type=attr_flags_reverse_mask;
    if (RoutePreference(Routing::PreferenceMode::AVOID, Routing::RoutePreferenceSource::TOLL_ROADS)) {
        flags_forward_mask.u.num=s->flags_forward_mask | AF_TOLL;
        flags_reverse_mask.u.num=s->flags_reverse_mask | AF_TOLL;
    } else {
        flags_forward_mask.u.num=s->flags_forward_mask;
        flags_reverse_mask.u.num=s->flags_reverse_mask;
    }
    vehicleprofile_set_attr(m_vehicleprofile.u.vehicleprofile, &flags_forward_mask);
    vehicleprofile_set_attr(m_vehicleprofile.u.vehicleprofile, &flags_reverse_mask);
    struct attr_iter *iter=vehicleprofile_attr_iter_new();
    while (vehicleprofile_get_attr(m_vehicleprofile.u.vehicleprofile, attr_roadprofile, &roadprofile, iter)) {
        if (roadprofile_get_attr(roadprofile.u.roadprofile, attr_item_types, &item_types, NULL)) {
            int *par=NULL;
            bool active=false;
            switch (item_types.u.item_types[0]) {
            case type_ferry:
                par=&s->ferry_weight;
                active=RoutePreference(Routing::PreferenceMode::AVOID, Routing::RoutePreferenceSource::FERRY);
                break;
            case type_highway_city:
                par=&s->highway_city_weight;
                active=RoutePreference(Routing::PreferenceMode::AVOID, Routing::RoutePreferenceSource::HIGHWAYS_MOTORWAYS);
                break;
            case type_highway_land:
                par=&s->highway_land_weight;
                active=RoutePreference(Routing::PreferenceMode::AVOID, Routing::RoutePreferenceSource::HIGHWAYS_MOTORWAYS);
                break;
            }
            if (par) {
                if (!*par) {
                    roadprofile_get_attr(roadprofile.u.roadprofile, attr_route_weight, &route_weight, NULL);
                    *par=route_weight.u.num;
                }
                route_weight.type=attr_route_weight;
                route_weight.u.num=active?0:*par;
                roadprofile_set_attr(roadprofile.u.roadprofile, &route_weight);
            }
        }
    }
    vehicleprofile_attr_iter_destroy(iter);

}

void
RoutingObj::GetRoutePreferences(const std::string& country, std::vector< Routing::RoutePreference >& roadPreferenceList)
{
    roadPreferenceList=m_route_preferences_list[m_vehicleprofile_idx];
}

static std::shared_ptr<RoutingServerStub> myServiceRouting;

void
plugin_init(void)
{
    // Common API data init
    std::shared_ptr < CommonAPI::Runtime > runtime = CommonAPI::Runtime::get();

    const std::string &domain = "local";
    const std::string &instance = "Routing";

    myServiceRouting = std::make_shared<RoutingServerStub>();

    bool successfullyRegistered = runtime->registerService(domain, instance, myServiceRouting);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instance, myServiceRouting);
    }
}
