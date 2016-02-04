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
#include "genivi-navigationcore-constants.h"
#include "genivi-navigationcore-routing_adaptor.h"
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

#include "navigation-common-dbus.h"

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

static DBus::Glib::BusDispatcher dispatcher;
static DBus::Connection *conn;

struct vehicleprofile_settings {
	int flags_forward_mask,flags_reverse_mask;
	int ferry_weight;
	int highway_city_weight;
	int highway_land_weight;
};

class Routing;

class RoutingObj
{
	public:
	struct search_list *m_sl;
    uint32_t m_handle;
    uint32_t m_session;
	uint32_t m_costmodel;
	Routing *m_routing;
	bool m_startfromcurrentposition;
	int m_route_status;
	int m_vehicleprofile_idx;
	struct vehicleprofile_settings m_vehicleprofile_settings[2];
    std::vector< ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > > m_route_preferences_list[2];
    std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > > m_waypoints;
	struct callback *m_callback;
	struct attr m_route,m_vehicleprofile;
	struct navit *get_navit(void);
	struct mapset *get_mapset(struct navit *navit);
	struct route *get_route(struct navit *navit);
	struct vehicle *get_vehicle(struct navit *navit);
	struct tracking *get_tracking(void);
    void map_to_pcoord(std::map<DBusCommonAPIEnumeration, DBusCommonAPIVariant> map, struct pcoord *pc);
    void SetCostModel(uint32_t SessionHandle, uint16_t CostModel);
    void GetCostModel(uint16_t &CostModel);
    void SetWaypoints(uint32_t SessionHandle, bool StartFromCurrentPosition, std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > > Waypoints);
    void GetWaypoints(bool& StartFromCurrentPosition, std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > >& Waypoints);
    void CalculateRoute(uint32_t SessionHandle);
    void GetRouteSegments(int16_t detailLevel , const std::vector< DBusCommonAPIEnumeration >& valuesToReturn, const uint32_t& numberOfSegments, const uint32_t& offset, uint32_t& totalNumberOfSegments, std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > >& RouteSegments);
    void GetRouteOverview(uint32_t routeHandle , std::map<DBusCommonAPIEnumeration, DBusCommonAPIVariant> &routeOverview);
    void GetRouteBoundingBox(::DBus::Struct< ::DBus::Struct< double, double >,::DBus::Struct< double, double > > &boundingBox);
    void CancelRouteCalculation(uint32_t sessionHandle);
    bool RoutePreference(uint16_t preferenceSource, uint16_t preferenceMode);
    void SetRoutePreferences(uint32_t sessionHandle, const std::string& country, const std::vector< ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > >& routePreferencesList);
    void GetRoutePreferences(const std::string& country, std::vector< ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > >& roadPreferenceList);
    RoutingObj(Routing *routing, uint32_t session, uint32_t handle);
	~RoutingObj();
};

static std::map<uint32_t, RoutingObj *> handles;

static bool commands_registered;

static void
navit_genivi_get_route(struct navit *nav, char *function, struct attr **in, struct attr ***out, int *valid)
{
	if (!out || !in || !in[0])
		return;
	if (!ATTR_IS_INT(in[0]->type))
		return;
	RoutingObj *obj=handles[in[0]->u.num];
	if (!obj)
		return;
	*out=attr_generic_add_attr(*out, &obj->m_route);
	*out=attr_generic_add_attr(*out, &obj->m_vehicleprofile);
}

static struct command_table commands[] = {
	{"navit_genivi_get_route",command_cast(navit_genivi_get_route)},
};


class  Routing
: public org::genivi::navigationcore::Routing_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
	public:
	Routing(DBus::Connection &connection)
	: DBus::ObjectAdaptor(connection, "/org/genivi/navigationcore")
	{
	}

    uint32_t
    CreateRoute(const uint32_t& SessionHandle)
	{
                dbg(lvl_debug,"enter\n");
		uint32_t RouteHandle=1;
		while (handles[RouteHandle]) {
			RouteHandle++;
			if (RouteHandle == 256)
				throw DBus::ErrorLimitsExceeded("Out of route handles");
		}
		handles[RouteHandle]=new RoutingObj(this, SessionHandle, RouteHandle);
		return RouteHandle;
	}

	void	
    DeleteRoute(const uint32_t& SessionHandle, const uint32_t& RouteHandle)
	{
		RoutingObj *obj=handles[RouteHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
		delete(obj);
		handles[RouteHandle]=NULL;
        RouteDeleted(RouteHandle);
	}

	void	
    SetCostModel(const uint32_t& SessionHandle, const uint32_t& RouteHandle, const DBusCommonAPIEnumeration& CostModel)
	{
		RoutingObj *obj=handles[RouteHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
		obj->SetCostModel(SessionHandle, CostModel);
	}

    DBusCommonAPIEnumeration
    GetCostModel(const uint32_t& RouteHandle)
	{
		uint16_t CostModel;
		dbg(lvl_debug,"enter\n");
		RoutingObj *obj=handles[RouteHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetCostModel(CostModel);
		return CostModel;
	}
	
    std::vector< DBusCommonAPIEnumeration >
    GetSupportedCostModels()
	{
        std::vector< DBusCommonAPIEnumeration > CostModels;
		CostModels.resize(2);
		CostModels[0]=GENIVI_NAVIGATIONCORE_FASTEST; 
		CostModels[1]=GENIVI_NAVIGATIONCORE_SHORTEST; 
		return CostModels;
	}
	    	
	void	
    SetWaypoints(const uint32_t& SessionHandle , const uint32_t& RouteHandle , const bool& StartFromCurrentPosition , const std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > >& Waypoints)
	{
		dbg(lvl_debug,"enter\n");
		RoutingObj *obj=handles[RouteHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
		obj->SetWaypoints(SessionHandle, StartFromCurrentPosition, Waypoints);
	}

	void
    GetWaypoints(const uint32_t& RouteHandle , bool& StartFromCurrentPosition , std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > >& Waypoints)
	{
		dbg(lvl_debug,"enter\n");
		RoutingObj *obj=handles[RouteHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetWaypoints(StartFromCurrentPosition, Waypoints);
	}

	void	
    CalculateRoute(const uint32_t& SessionHandle , const uint32_t& RouteHandle )
	{
		dbg(lvl_debug,"enter\n");
		RoutingObj *obj=handles[RouteHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
		obj->CalculateRoute(SessionHandle);
	}

	void
    GetRouteSegments(const uint32_t& routeHandle, const int16_t& detailLevel, const std::vector< DBusCommonAPIEnumeration >& valuesToReturn, const uint32_t& numberOfSegments, const uint32_t& offset, uint32_t& totalNumberOfSegments, std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > >& routeSegments)
	{
		dbg(lvl_debug,"enter\n");
		RoutingObj *obj=handles[routeHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetRouteSegments(detailLevel, valuesToReturn, numberOfSegments, offset, totalNumberOfSegments, routeSegments);
	}

	DBus::Struct<uint16_t, uint16_t, uint16_t, std::string> GetVersion()
	{
		DBus::Struct<uint16_t, uint16_t, uint16_t, std::string>Version;
		Version._1=3;
		Version._2=0;
		Version._3=0;
		Version._4=std::string("07-06-2013");
		return Version;
	}

	void
    SetRoutePreferences(const uint32_t& sessionHandle, const uint32_t& routeHandle, const std::string& country, const std::vector< ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > >& roadPreferenceList, const std::vector< ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > >& conditionPreferenceList)
	{
		RoutingObj *obj=handles[routeHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->SetRoutePreferences(sessionHandle, country, roadPreferenceList);
	}

    void
    GetRoutePreferences(const uint32_t& routeHandle, const std::string& country, std::vector< ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > >& roadPreferenceList, std::vector< ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > >& conditionPreferenceList)
	{
        ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > roadPreference;
        ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > conditionPreference;

        conditionPreference._1 = GENIVI_NAVIGATIONCORE_USE;
        conditionPreference._2 = GENIVI_NAVIGATIONCORE_TRAFFIC_REALTIME;

        conditionPreferenceList.push_back(conditionPreference); //by default

		RoutingObj *obj=handles[routeHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetRoutePreferences(country, roadPreferenceList);
        if (roadPreferenceList.size() == 0)
        { //add a default value (bug in qml to be fixed)
            roadPreference._1 = GENIVI_NAVIGATIONCORE_DEFAULT;
            roadPreference._2 = GENIVI_NAVIGATIONCORE_DEFAULT;
            roadPreferenceList.push_back(roadPreference);
        }
	}

    void
    GetSupportedRoutePreferences(std::vector< ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > >& routePreferencesList, std::vector< ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > >& conditionPreferenceList)
	{
        ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > routePreference;
        ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > conditionPreference;
        routePreference._1 = GENIVI_NAVIGATIONCORE_AVOID;
        routePreference._2 = GENIVI_NAVIGATIONCORE_HIGHWAYS_MOTORWAYS;
        routePreferencesList.push_back(routePreference);
        routePreference._1 = GENIVI_NAVIGATIONCORE_AVOID;
        routePreference._2 = GENIVI_NAVIGATIONCORE_TOLL_ROADS;
        routePreferencesList.push_back(routePreference);
        routePreference._1 = GENIVI_NAVIGATIONCORE_AVOID;
        routePreference._2 = GENIVI_NAVIGATIONCORE_FERRY;
        routePreferencesList.push_back(routePreference);
        conditionPreference._1 = GENIVI_NAVIGATIONCORE_USE;
        conditionPreference._2 = GENIVI_NAVIGATIONCORE_TRAFFIC_REALTIME;
        conditionPreferenceList.push_back(conditionPreference);
    }

    void SetRouteSchedule(const uint32_t& sessionHandle, const uint32_t& routeHandle, const std::map< int32_t, uint32_t >& routeSchedule)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    std::map< int32_t, uint32_t > GetRouteSchedule(const uint32_t& routeHandle, const std::vector< int32_t >& valuesToReturn)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

	void
    SetTransportationMeans(const uint32_t& sessionHandle, const uint32_t& routeHandle, const std::vector< int32_t >& transportationMeansList)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    std::vector< DBusCommonAPIEnumeration >
    GetTransportationMeans(const uint32_t& routeHandle)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    std::vector< DBusCommonAPIEnumeration >
    GetSupportedTransportationMeans()
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
    SetExcludedAreas(const uint32_t& sessionHandle, const uint32_t& routeHandle, const std::vector< std::vector< ::DBus::Struct< double, double > > >& excludedAreas)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	std::vector< std::vector< ::DBus::Struct< double, double > > >
    GetExcludedAreas(const uint32_t& routeHandle)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
    CancelRouteCalculation(const uint32_t& sessionHandle, const uint32_t& routeHandle)
	{
		RoutingObj *obj=handles[routeHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
		obj->CancelRouteCalculation(sessionHandle);
        RouteCalculationCancelled(routeHandle);
	}

    std::vector< uint32_t >
    CalculateRoutes(const uint32_t& sessionHandle, const std::vector< uint32_t >& calculatedRoutesList)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    std::map< int32_t, DBusCommonAPIVariant >
    GetRouteOverview(const uint32_t& routeHandle, const std::vector< DBusCommonAPIEnumeration >& valuesToReturn )
	{
        std::map< int32_t, DBusCommonAPIVariant > ret;
		RoutingObj *obj=handles[routeHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetRouteOverview(routeHandle, ret);
        return ret;
	}

    std::vector< uint32_t >
    GetAllRoutes()
	{
        std::vector< uint32_t >ret;
		std::map<uint32_t, RoutingObj *>::const_iterator itr;
		
		for(itr = handles.begin(); itr != handles.end(); itr++) 
			ret.push_back((*itr).first);
		return ret;
    }

	::DBus::Struct< ::DBus::Struct< double, double >,::DBus::Struct< double, double > >
    GetRouteBoundingBox(const uint32_t& routeHandle)
	{
		::DBus::Struct< ::DBus::Struct< double, double >,::DBus::Struct< double, double > > ret;
		RoutingObj *obj=handles[routeHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Route handle invalid");
        obj->GetRouteBoundingBox(ret);
		return ret;
	}

	void
	SetBlockedRouteStretches(const uint32_t& sessionHandle, const uint32_t& routeHandle, const std::vector< ::DBus::Struct< uint32_t, uint32_t > >& blockParameters)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	std::vector< ::DBus::Struct< uint32_t, uint32_t > >
	GetBlockedRouteStretches(const uint32_t& routeHandle)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}
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
RoutingObj::SetCostModel(uint32_t SessionHandle, uint16_t CostModel)
{
	const char *vehicleprofile_name;
	switch (CostModel) {
	case GENIVI_NAVIGATIONCORE_FASTEST:
		vehicleprofile_name="car";
		m_vehicleprofile_idx=0;
		break;
	case GENIVI_NAVIGATIONCORE_SHORTEST:
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
RoutingObj::GetCostModel(uint16_t& CostModel)
{
	CostModel=m_costmodel;
}

void
RoutingObj::SetWaypoints(uint32_t SessionHandle, bool StartFromCurrentPosition, std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > > Waypoints)
{
	if (StartFromCurrentPosition) {
		if (Waypoints.size() != 1)
			throw DBus::ErrorFailed("StartFromCurrentPosition is set, but Waypoint size is not 1");
	} else {
		if (Waypoints.size() != 2)
			throw DBus::ErrorFailed("StartFromCurrentPosition is not set, but Waypoint size is not 2");
	}
	for (int i=0 ; i < Waypoints.size(); i++) {
		if (Waypoints[i].find(GENIVI_NAVIGATIONCORE_LATITUDE) == Waypoints[i].end()) 
			throw DBus::ErrorInvalidArgs("Waypoint doesn't contain Latitude");
		if (Waypoints[i].find(GENIVI_NAVIGATIONCORE_LONGITUDE) == Waypoints[i].end()) 
			throw DBus::ErrorInvalidArgs("Waypoint doesn't contain Longitude");
	}
	m_startfromcurrentposition=StartFromCurrentPosition;
	m_waypoints=Waypoints;

}

void
RoutingObj::GetWaypoints(bool& StartFromCurrentPosition, std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > >& Waypoints)
{
	StartFromCurrentPosition=m_startfromcurrentposition;
	Waypoints=m_waypoints;
}

void
RoutingObj::map_to_pcoord(std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant >map, struct pcoord *pc)
{
	struct coord_geo g;
	struct coord c;

    g.lat=map[GENIVI_NAVIGATIONCORE_LATITUDE]._2;
    g.lng=map[GENIVI_NAVIGATIONCORE_LONGITUDE]._2;
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

static DBus::Variant
variant_double(double d)
{
	DBus::Variant variant;
	DBus::MessageIter iter=variant.writer();
	iter << d;
	return variant;
}

static DBus::Variant
variant_uint16(uint16_t i)
{
	DBus::Variant variant;
	DBus::MessageIter iter=variant.writer();
	iter << i;
	return variant;
}

static DBus::Variant
variant_string(std::string s)
{
	DBus::Variant variant;
	DBus::MessageIter iter=variant.writer();
	iter << s;
	return variant;
}

static bool
vector_contains(const std::vector< DBusCommonAPIEnumeration >& vector, uint16_t val)
{
	int i;
	for (i = 0 ; i < vector.size() ; i++) {
		if (vector[i] == val)
			return true;
	}
	return false;
}

static void
get_map(struct coord *c, struct item *item, int is_end, const std::vector< DBusCommonAPIEnumeration >& valuesToReturn, std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > &map)
{
	uint16_t lat_key=is_end?GENIVI_NAVIGATIONCORE_END_LATITUDE:GENIVI_NAVIGATIONCORE_START_LATITUDE;
	uint16_t lon_key=is_end?GENIVI_NAVIGATIONCORE_END_LONGITUDE:GENIVI_NAVIGATIONCORE_START_LONGITUDE;
	if (vector_contains(valuesToReturn, lat_key) || vector_contains(valuesToReturn, lon_key)) {
		struct coord_geo g;
		transform_to_geo(projection_mg, c, &g);
		if (vector_contains(valuesToReturn, lat_key))
			map[lat_key]=variant_double(g.lat);
		if (vector_contains(valuesToReturn, lon_key))
			map[lon_key]=variant_double(g.lng);
	}
	if (item && (vector_contains(valuesToReturn, GENIVI_NAVIGATIONCORE_DISTANCE) || vector_contains(valuesToReturn, GENIVI_NAVIGATIONCORE_TIME) || vector_contains(valuesToReturn, GENIVI_NAVIGATIONCORE_SPEED))) {
		struct attr length, time, speed;
		if (item_attr_get(item, attr_length, &length) && vector_contains(valuesToReturn, GENIVI_NAVIGATIONCORE_DISTANCE)) {
			map[GENIVI_NAVIGATIONCORE_DISTANCE]=variant_double(length.u.num);
		}
		if (item_attr_get(item, attr_time, &time) && vector_contains(valuesToReturn, GENIVI_NAVIGATIONCORE_TIME)) {
			map[GENIVI_NAVIGATIONCORE_TIME]=variant_uint16((time.u.num+5)/10);
		}
		if (item_attr_get(item, attr_speed, &speed) && vector_contains(valuesToReturn, GENIVI_NAVIGATIONCORE_SPEED)) {
			map[GENIVI_NAVIGATIONCORE_SPEED]=variant_uint16(speed.u.num);
		}
	}
	if (item && vector_contains(valuesToReturn, GENIVI_NAVIGATIONCORE_ROAD_NAME)) {
		struct attr street_item;
		if (item_attr_get(item, attr_street_item, &street_item)) {
			struct map_rect *mr=map_rect_new(street_item.u.item->map, NULL);
			struct item *item2=map_rect_get_item_byid(mr, street_item.u.item->id_hi, street_item.u.item->id_lo);
			struct attr label;
			if (item2 && item_attr_get(item2, attr_label, &label)) 
				map[GENIVI_NAVIGATIONCORE_ROAD_NAME]=variant_string(label.u.str);
			map_rect_destroy(mr);
		}
	}
}


void
RoutingObj::GetRouteSegments(int16_t detailLevel , const std::vector< DBusCommonAPIEnumeration >& valuesToReturn, const uint32_t& numberOfSegments, const uint32_t& offset, uint32_t& totalNumberOfSegments, std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > >& RouteSegments)
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
	bool intermediate=vector_contains(valuesToReturn, GENIVI_NAVIGATIONCORE_INTERMEDIATE_POINTS);
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
                                std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > map;
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
RoutingObj::GetRouteOverview(uint32_t routeHandle , std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant >& routeOverview)
{
	struct attr destination_length, destination_time;
	if (!route_get_attr(m_route.u.route,attr_destination_length, &destination_length, NULL))
		throw DBus::ErrorFailed("internal error:failed to get attribute destination_length");
	if (!route_get_attr(m_route.u.route,attr_destination_time, &destination_time, NULL))
		throw DBus::ErrorFailed("internal error:failed to get attribute destination_time");

    DBusCommonAPIVariant var1,var2;
    DBus::MessageIter iter1 = var1._2.writer();
    DBus::MessageIter iter2 = var2._2.writer();
    iter1.append_uint32(destination_length.u.num);
    iter2.append_uint32(destination_time.u.num/10);
    var1._1 = 0;
    var2._1 = 0;
    routeOverview[GENIVI_NAVIGATIONCORE_TOTAL_DISTANCE] = var1;
    routeOverview[GENIVI_NAVIGATIONCORE_TOTAL_TIME] = var2;
}

void
RoutingObj::GetRouteBoundingBox(::DBus::Struct< ::DBus::Struct< double, double >,::DBus::Struct< double, double > > &boundingBox)
{
	struct coord_rect r;
	struct coord_geo g;
	bool first=true;
	struct map *m=route_get_map(m_route.u.route);
	struct item *item;

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
	boundingBox._1._1=g.lat;
	boundingBox._1._2=g.lng;
	dbg(lvl_debug,"%f,%f\n",g.lat,g.lng);
	transform_to_geo(projection_mg, &r.rl, &g);
	boundingBox._2._1=g.lat;
	boundingBox._2._2=g.lng;
	dbg(lvl_debug,"-%f,%f\n",g.lat,g.lng);
}

void
RoutingObj::CancelRouteCalculation(uint32_t sessionHandle)
{
	route_set_destination(m_route.u.route, NULL, 0);
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
        obj->m_routing->RouteCalculationProgressUpdate(obj->m_handle, GENIVI_NAVIGATIONCORE_OK, 5);
		obj->m_route_status=route_status.u.num;
	}
	if (route_status.u.num == route_status_building_graph) {
		obj->m_route_status=route_status.u.num;
	}
	if (route_status.u.num == route_status_building_path && obj->m_route_status == route_status_building_graph) {
        obj->m_routing->RouteCalculationProgressUpdate(obj->m_handle, GENIVI_NAVIGATIONCORE_OK, 50);
		obj->m_route_status=route_status.u.num;
	}
	if (route_status.u.num == route_status_path_done_new || 
		(obj->m_route_status==route_status_destination_set && route_status.u.num == route_status_path_done_incremental)) {
		if (route_status.u.num == route_status_path_done_new)
            obj->m_routing->RouteCalculationProgressUpdate(obj->m_handle, GENIVI_NAVIGATIONCORE_OK, 100);
		obj->m_route_status=route_status.u.num;
		dbg(lvl_debug,"callback routing ok\n");
        std::map< int32_t, int32_t > unfulfilled_preferences;
        obj->m_routing->RouteCalculationSuccessful(obj->m_handle, unfulfilled_preferences);
	}
	if (route_status.u.num == route_status_not_found) {
		obj->m_route_status=route_status.u.num;
		dbg(lvl_debug,"callback routing failed\n");
        std::map< int32_t, int32_t > unfulfilled_preferences;
        obj->m_routing->RouteCalculationFailed(obj->m_handle, GENIVI_NAVIGATIONCORE_UNREACHABLE_DESTINATION, unfulfilled_preferences);
	}
}


bool
RoutingObj::RoutePreference(uint16_t preferenceSource,uint16_t preferenceMode)
{
    int index;

    for (index=0;index<m_route_preferences_list[m_vehicleprofile_idx].size();index++)
    {
        if (((m_route_preferences_list[m_vehicleprofile_idx].at(index))._1 == preferenceSource) && ((m_route_preferences_list[m_vehicleprofile_idx].at(index))._2 == preferenceMode))
            return true;
    }

    return false;
}

void
RoutingObj::SetRoutePreferences(uint32_t sessionHandle, const std::string& country, const std::vector< ::DBus::Struct< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > >& routePreferencesList)
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
    if (RoutePreference(GENIVI_NAVIGATIONCORE_AVOID, GENIVI_NAVIGATIONCORE_TOLL_ROADS)) {
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
                active=RoutePreference(GENIVI_NAVIGATIONCORE_AVOID, GENIVI_NAVIGATIONCORE_FERRY);
				break;
			case type_highway_city:
				par=&s->highway_city_weight;
                active=RoutePreference(GENIVI_NAVIGATIONCORE_AVOID, GENIVI_NAVIGATIONCORE_HIGHWAYS_MOTORWAYS);
				break;
			case type_highway_land:
				par=&s->highway_land_weight;
                active=RoutePreference(GENIVI_NAVIGATIONCORE_AVOID, GENIVI_NAVIGATIONCORE_HIGHWAYS_MOTORWAYS);
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
RoutingObj::GetRoutePreferences(const std::string& country, std::vector< ::DBus::Struct<DBusCommonAPIEnumeration, DBusCommonAPIEnumeration > > &roadPreferenceList)
{
    roadPreferenceList=m_route_preferences_list[m_vehicleprofile_idx];
}


RoutingObj::RoutingObj(Routing *routing, uint32_t session, uint32_t handle)
{
	struct attr callback;
           
	m_routing=routing;
        m_session=session; 
	m_handle=handle;
	m_route.type=attr_route;
	m_route.u.route=route_new(NULL, NULL);
	m_vehicleprofile.type=attr_vehicleprofile;
	m_vehicleprofile.u.vehicleprofile=NULL;
	m_callback=callback_new_attr_1(reinterpret_cast<void (*)(void)>(RoutingObj_Callback), attr_route_status, this);
	memset(m_vehicleprofile_settings, 0, sizeof(m_vehicleprofile_settings));
	SetCostModel(handle, GENIVI_NAVIGATIONCORE_FASTEST);
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

static class Routing *server;


void
plugin_init(void)
{
	event_request_system("glib","genivi_routing");
	dispatcher.attach(NULL);
	DBus::default_dispatcher = &dispatcher;
	conn = new DBus::Connection(DBus::Connection::SessionBus());
	conn->setup(&dispatcher);
	conn->request_name("org.genivi.navigationcore.Routing");
	server=new Routing(*conn);
}
