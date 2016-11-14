/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_navigationcore_mapmatchedposition.cxx
*
* \brief This file is part of the Navit POC.
*
* \author Martin Schaller <martin.schaller@it-schaller.de>
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
#include "callback.h"
#include "navigation.h"
#include "map.h"
#include "transform.h"
#include "track.h"
#include "vehicle.h"
#include "route.h"
#include "config_.h"
#include <CommonAPI/CommonAPI.hpp>
#include <CommonTypes.hpp>
#include <NavigationTypes.hpp>
#include <NavigationCoreTypes.hpp>
#include <MapMatchedPositionStubDefault.hpp>

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

using namespace v4::org::genivi::navigation::navigationcore;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

static struct attr config_cb,navit_cb,tracking_cb;
static struct tracking *tracking;
static struct item last_item;
static char *mp_street_name;
static struct attr vehicle_speed={attr_speed,(char *)40};

static struct navit *
get_navit(void)
{
	struct attr navit;
	if (!config_get_attr(config, attr_navit, &navit, NULL))
		return NULL;
	return navit.u.navit;
}

static struct vehicle *
get_vehicle(const char *source_prefix)
{
	struct navit *navit=get_navit();
	struct attr vehicle;
	struct vehicle *ret=NULL;
	if (!source_prefix) {
		if (navit_get_attr(navit, attr_vehicle, &vehicle, NULL))
			ret=vehicle.u.vehicle;
	} else {
		struct attr_iter *iter=navit_attr_iter_new();
		while (navit_get_attr(navit, attr_vehicle, &vehicle, iter)) {
			struct attr source;
			if (vehicle.u.vehicle && vehicle_get_attr(vehicle.u.vehicle, attr_source, &source, NULL) && 
				!strncmp(source.u.str, source_prefix, strlen(source_prefix))) { 
				ret=vehicle.u.vehicle;
				break;
			}
		}
		navit_attr_iter_destroy(iter);
	}	
	return ret;
}

class  MapMatchedPositionServerStub : public MapMatchedPositionStubDefault
{
	public:
    MapMatchedPositionServerStub()
	{
        m_version.setVersionMajor(3);
        m_version.setVersionMinor(0);
        m_version.setVersionMicro(0);
        m_version.setDate("21-01-2014");

        m_simulationMode = MapMatchedPosition::SimulationStatus::SIMULATION_STATUS_NO_SIMULATION;
    }

    ~MapMatchedPositionServerStub(){}

    /**
     * description: getVersion = This method returns the API version implemented by the server
     *   application
     */
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply) {
        _reply(m_version);
    }

    /**
     * description: setSimulationMode = This method activates or deactivates the simulation mode
     */
    void setSimulationMode(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, bool _activate, setSimulationModeReply_t _reply){
        dbg(lvl_debug,"enter Activate=%d\n",_activate);
        MapMatchedPosition::SimulationStatus newSimulationMode;
        struct attr vehicle;
        vehicle.type=attr_vehicle;
        vehicle.u.vehicle=get_vehicle(_activate ? "demo:":"enhancedposition:");
        if (vehicle.u.vehicle) {
            newSimulationMode = _activate ? MapMatchedPosition::SimulationStatus::SIMULATION_STATUS_FIXED_POSITION : MapMatchedPosition::SimulationStatus::SIMULATION_STATUS_NO_SIMULATION;
            if (newSimulationMode != m_simulationMode) {
                m_simulationMode=newSimulationMode;
                fireSimulationStatusChangedSelective(m_simulationMode);
            }
            demo_update(false);
            struct navit *navit=get_navit();
            navit_set_attr(navit, &vehicle);
        } else {
            dbg(lvl_debug,"Failed to get vehicle\n");
            }

        _reply();
    }

    /**
     * description: getSimulationStatus = This method retrieves the simulation status
     */
    void getSimulationStatus(const std::shared_ptr<CommonAPI::ClientId> _client, getSimulationStatusReply_t _reply){
        _reply(m_simulationMode);
    }

    /**
     * description: setSimulationSpeed = This method sets the speed factor for the simulation mode
     */
    void setSimulationSpeed(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, uint8_t _speedFactor, setSimulationSpeedReply_t _reply){
        int speed=_speedFactor*40/4;
        if (vehicle_speed.u.num != speed) {
            vehicle_speed.u.num=speed;
            fireSimulationSpeedChangedSelective(_speedFactor);
            if (m_simulationMode == MapMatchedPosition::SimulationStatus::SIMULATION_STATUS_RUNNING) {
                demo_update(true);
            }
        }
        _reply();
    }

    /**
     * description: getSimulationSpeed = returns the speed factor for the simulation mode
     */
    void getSimulationSpeed(const std::shared_ptr<CommonAPI::ClientId> _client, getSimulationSpeedReply_t _reply){
        _reply(vehicle_speed.u.num*4/40);
    }

    /**
     * description: startSimulation = This method starts, or resumes, a Follow Active Route
     *   simulation
     */
    void startSimulation(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, startSimulationReply_t _reply){
        if (m_simulationMode == MapMatchedPosition::SimulationStatus::SIMULATION_STATUS_PAUSED || m_simulationMode == MapMatchedPosition::SimulationStatus::SIMULATION_STATUS_FIXED_POSITION ) {
            m_simulationMode=MapMatchedPosition::SimulationStatus::SIMULATION_STATUS_RUNNING;
            fireSimulationStatusChangedSelective(m_simulationMode);
            demo_update(true);
        }
        _reply();
    }

    /**
     * description: pauseSimulation = This method freezes the current location
     */
    void pauseSimulation(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, pauseSimulationReply_t _reply){
        if (m_simulationMode == MapMatchedPosition::SimulationStatus::SIMULATION_STATUS_RUNNING) {
            m_simulationMode=MapMatchedPosition::SimulationStatus::SIMULATION_STATUS_PAUSED;
            fireSimulationStatusChangedSelective(m_simulationMode);
            demo_update(false);
        }
        _reply();
    }

    /**
     * description: getPosition = This method returns the current position
     */
    void getPosition(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector<MapMatchedPosition::PositionItemKey> _valuesToReturn, getPositionReply_t _reply){
        MapMatchedPosition::getPositionError _error = MapMatchedPosition::getPositionError::OK;
        dbg(lvl_debug,"enter\n");
        MapMatchedPosition::PositionItemDict map;
        struct attr attr;
        for (std::size_t i = 0 ; i < _valuesToReturn.size() ; i++) {
            switch (_valuesToReturn[i]) {
            case MapMatchedPosition::PositionItemKey::LATITUDE:
                if (tracking_get_attr(tracking, attr_position_coord_geo, &attr, NULL))
                    map[MapMatchedPosition::PositionItemKey::LATITUDE]=attr.u.coord_geo->lat;
                break;
            case MapMatchedPosition::PositionItemKey::LONGITUDE:
                if (tracking_get_attr(tracking, attr_position_coord_geo, &attr, NULL))
                    map[MapMatchedPosition::PositionItemKey::LONGITUDE]=attr.u.coord_geo->lng;
                break;
            case MapMatchedPosition::PositionItemKey::SPEED:
                if (tracking_get_attr(tracking, attr_position_speed, &attr, NULL))
                    map[MapMatchedPosition::PositionItemKey::SPEED]=*attr.u.numd;
                break;
            case MapMatchedPosition::PositionItemKey::HEADING:
                if (tracking_get_attr(tracking, attr_position_direction, &attr, NULL))
                    map[MapMatchedPosition::PositionItemKey::HEADING]=*attr.u.numd;
                break;
            }
        }
        _reply(_error,map);
    }

    /**
     * description: setPosition = This method sets the position to a specific location
     */
    void setPosition(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, MapMatchedPosition::PositionItemDict _position, setPositionReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getAddress = This method returns the current address
     */
    void getCurrentAddress(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector<MapMatchedPosition::AddressItemKey> _valuesToReturn, getCurrentAddressReply_t _reply){
        MapMatchedPosition::getCurrentAddressError _error = MapMatchedPosition::getCurrentAddressError::OK;
        MapMatchedPosition::AddressItemDict ret;
        std::vector< MapMatchedPosition::AddressItemKey >::const_iterator it;
        for (it = _valuesToReturn.begin(); it < _valuesToReturn.end(); it++) {
            if (*it == MapMatchedPosition::AddressItemKey::STREET && mp_street_name) {
                ret[*it]= std::string(mp_street_name);
            }
        }
        _reply(_error, ret);
    }

    /**
     * description: positionOnSegment = This method returns the vehicle position on a route segment
     */
    void getPositionOnSegment(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector<MapMatchedPosition::PositionOnSegmentKey> _valuesToReturn, getPositionOnSegmentReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getStatus = This method returns the current status
     */
    void getStatus(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector<MapMatchedPosition::PositionStatus> _valuesToReturn, getStatusReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

private:
    CommonTypes::Version m_version;
    MapMatchedPosition::SimulationStatus m_simulationMode;

    void
    demo_update(bool start)
    {
        struct attr vehicle_null_speed={attr_speed,(char *)0};
        struct vehicle *vehicle=get_vehicle("demo:");
        vehicle_set_attr(vehicle, start?&vehicle_speed:&vehicle_null_speed);
    }

};

static std::shared_ptr<MapMatchedPositionServerStub> myServiceMapMatchedPosition;

static void
tracking_attr_position_coord_geo(void)
{
	struct attr position_coord_geo, current_item;
    dbg(lvl_debug,"enter\n");
	if (tracking_get_attr(tracking, attr_position_coord_geo, &position_coord_geo, NULL)) {
        std::vector< MapMatchedPosition::PositionItemKey >changes;
        changes.push_back(MapMatchedPosition::PositionItemKey::LATITUDE);
        changes.push_back(MapMatchedPosition::PositionItemKey::LONGITUDE);
        changes.push_back(MapMatchedPosition::PositionItemKey::SPEED);
        changes.push_back(MapMatchedPosition::PositionItemKey::HEADING);
        myServiceMapMatchedPosition->firePositionUpdateEvent(changes);
	}
	if (tracking_get_attr(tracking, attr_current_item, &current_item, NULL) && current_item.u.item) {
		if (!item_is_equal(last_item, *current_item.u.item)) {
			last_item=*current_item.u.item;
			char *new_street_name=NULL;
			struct map_rect *mr=map_rect_new(last_item.map, NULL);
			struct item *item;
			if (mr && (item = map_rect_get_item_byid(mr, last_item.id_hi, last_item.id_lo))) {
				struct attr label;
				if (item_attr_get(item, attr_label, &label)) 
					new_street_name=label.u.str;
			}
            if (g_strcmp0(new_street_name, mp_street_name)) {
                g_free(mp_street_name);
                mp_street_name=g_strdup(new_street_name);
                std::vector< MapMatchedPosition::AddressItemKey >changes;
                changes.push_back(MapMatchedPosition::AddressItemKey::STREET);
                myServiceMapMatchedPosition->fireAddressUpdateEvent(changes);
			}
			if (mr)
				map_rect_destroy(mr);
		}
	}
}

static void
navit_attr_navit(struct navit *navit)
{
	struct attr tracking_attr;
	if (navit_get_attr(navit, attr_trackingo, &tracking_attr, NULL)) {
		tracking=tracking_attr.u.tracking;
		tracking_cb.type=attr_callback;
		tracking_cb.u.callback=callback_new_attr_0(callback_cast(tracking_attr_position_coord_geo), attr_position_coord_geo);
		tracking_add_attr(tracking, &tracking_cb);
	}
}

static void
config_attr_navit(struct navit *navit, int add)
{
	if (!tracking && !navit_cb.u.callback && add) {
		navit_cb.type=attr_callback;
		navit_cb.u.callback=callback_new_attr_0(callback_cast(navit_attr_navit), attr_navit);
		navit_add_attr(navit, &navit_cb);
	}
}

void
plugin_init(void)
{
    // Common API data init
    std::shared_ptr < CommonAPI::Runtime > runtime = CommonAPI::Runtime::get();

    const std::string &domain = "local";
    const std::string &instance = "MapMatchedPosition";

    myServiceMapMatchedPosition = std::make_shared<MapMatchedPositionServerStub>();

    bool successfullyRegistered = runtime->registerService(domain, instance, myServiceMapMatchedPosition);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instance, myServiceMapMatchedPosition);
    }
	config_cb.type=attr_callback;
	config_cb.u.callback=callback_new_attr_0(callback_cast(config_attr_navit), attr_navit);
	config_add_attr(config, &config_cb);
}
