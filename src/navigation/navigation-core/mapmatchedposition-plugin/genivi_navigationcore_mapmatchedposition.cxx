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
#ifndef DBUS_HAS_RECURSIVE_MUTEX
#define DBUS_HAS_RECURSIVE_MUTEX
#endif
#include <dbus-c++/glib-integration.h>
#include "genivi-navigationcore-constants.h"
#include "genivi-navigationcore-mapmatchedposition_adaptor.h"
#include <config.h>
#define USE_PLUGINS 1
#include <navit/debug.h>
#include <navit/plugin.h>
#include <navit/item.h>
#include <navit/config_.h>
#include <navit/navit.h>
#include <navit/callback.h>
#include <navit/navigation.h>
#include <navit/map.h>
#include <navit/transform.h>
#include <navit/track.h>
#include <navit/vehicle.h>
#include <navit/route.h>
#include <navit/config_.h>

#include "navigation-common-dbus.h"

#include "log.h"

DLT_DECLARE_CONTEXT(gCtx);

static DBus::Glib::BusDispatcher dispatcher;
static DBus::Connection *conn;
static class MapMatchedPosition *server;
static struct attr config_cb,navit_cb,tracking_cb;
static struct tracking *tracking;
static struct item last_item;
static char *street_name;
static struct attr vehicle_speed={attr_speed,(char *)40};
static uint16_t simulationMode=GENIVI_NAVIGATIONCORE_SIMULATION_STATUS_NO_SIMULATION;

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
        void * unused;
        struct attr_iter *iter=navit_attr_iter_new(unused);
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

void
demo_update(bool start)
{
	struct attr vehicle_null_speed={attr_speed,(char *)0};
	struct vehicle *vehicle=get_vehicle("demo:");
	vehicle_set_attr(vehicle, start?&vehicle_speed:&vehicle_null_speed);
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
variant_string(std::string s)
{
	DBus::Variant variant;
	DBus::MessageIter iter=variant.writer();
	iter << s;
	return variant;
}


class  MapMatchedPosition
: public org::genivi::navigation::navigationcore::MapMatchedPosition_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
	public:
	MapMatchedPosition(DBus::Connection &connection)
	: DBus::ObjectAdaptor(connection, "/org/genivi/navigationcore")
	{
        m_position_set=false;
    }

	::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string >
	GetVersion()
	{
		::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > Version;
		Version._1=3;
		Version._2=0;
		Version._3=0;
		Version._4=std::string("23-10-2013");
		return Version;
	}

    void
    GetPosition(const std::vector< int32_t >& valuesToReturn, int32_t& error, std::map< int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant > >& position)
    {
        LOG_INFO_MSG(gCtx,"Get position");
        if(simulationMode==GENIVI_NAVIGATIONCORE_SIMULATION_STATUS_FIXED_POSITION){
            if(m_position_set){
                for (int i = 0 ; i < valuesToReturn.size() ; i++) {
                    switch (valuesToReturn[i]) {
                    case GENIVI_NAVIGATIONCORE_LATITUDE:
                        position[GENIVI_NAVIGATIONCORE_LATITUDE]=m_position[GENIVI_NAVIGATIONCORE_LATITUDE];
                        break;
                    case GENIVI_NAVIGATIONCORE_LONGITUDE:
                        position[GENIVI_NAVIGATIONCORE_LONGITUDE]=m_position[GENIVI_NAVIGATIONCORE_LONGITUDE];
                        break;
                    case GENIVI_NAVIGATIONCORE_SPEED:
                        position[GENIVI_NAVIGATIONCORE_SPEED]=m_position[GENIVI_NAVIGATIONCORE_SPEED];
                        break;
                    case GENIVI_NAVIGATIONCORE_HEADING:
                        position[GENIVI_NAVIGATIONCORE_HEADING]=m_position[GENIVI_NAVIGATIONCORE_HEADING];
                        break;
                    }
                }
                error=GENIVI_NAVIGATIONCORE_OK;
            }
            else error=GENIVI_NAVIGATIONCORE_NO_POSITION; //setposition has not been invoked, so vehicle is nowhere
        }else{
            struct attr attr;
            for (int i = 0 ; i < valuesToReturn.size() ; i++) {
                switch (valuesToReturn[i]) {
                case GENIVI_NAVIGATIONCORE_LATITUDE:
                    if (tracking_get_attr(tracking, attr_position_coord_geo, &attr, NULL))
                        position[GENIVI_NAVIGATIONCORE_LATITUDE]._2=variant_double(attr.u.coord_geo->lat);
                    break;
                case GENIVI_NAVIGATIONCORE_LONGITUDE:
                    if (tracking_get_attr(tracking, attr_position_coord_geo, &attr, NULL))
                        position[GENIVI_NAVIGATIONCORE_LONGITUDE]._2=variant_double(attr.u.coord_geo->lng);
                    break;
                case GENIVI_NAVIGATIONCORE_SPEED:
                    if (tracking_get_attr(tracking, attr_position_speed, &attr, NULL))
                        position[GENIVI_NAVIGATIONCORE_SPEED]._2=variant_double(*attr.u.numd);
                    break;
                case GENIVI_NAVIGATIONCORE_HEADING:
                    if (tracking_get_attr(tracking, attr_position_direction, &attr, NULL))
                        position[GENIVI_NAVIGATIONCORE_HEADING]._2=variant_double(*attr.u.numd);
                    break;
                }
            }
            error=GENIVI_NAVIGATIONCORE_OK;
        }
	}

    void
    GetCurrentAddress(const std::vector< int32_t >& valuesToReturn, int32_t& error, std::map< int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant > >& address)
    {
        std::vector< int32_t >::const_iterator it;
        for (it = valuesToReturn.begin(); it < valuesToReturn.end(); it++) {
            if (*it == GENIVI_NAVIGATIONCORE_STREET && street_name) {
                address[*it]._2=variant_string(street_name);
            }
        }
        error=0; //not implemented yet
    }

    std::map< int32_t, DBusCommonAPIVariant >
    GetPositionOnSegment(const std::vector< int32_t >& valuesToReturn)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    std::map< int32_t, DBusCommonAPIVariant >
    GetStatus(const std::vector< int32_t >& valuesToReturn)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    int32_t
	GetSimulationStatus()
	{
		return simulationMode;
	}

    bool subscribeForsimulationStatusChangedSelective()
    { //not implemented yet, always return true
        return true;
    }

    void unsubscribeFromsimulationStatusChangedSelective()
    { //not implemented yet

    }

    bool subscribeForsimulationSpeedChangedSelective()
    { //not implemented yet, always return true
        return true;
    }

    void unsubscribeFromsimulationSpeedChangedSelective()
    { //not implemented yet

    }

    void
    SetPosition(const uint32_t& sessionHandle, const std::map< int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant > >& position)
	{
        m_position_set=true;
        m_position=position;
        //set position is just used to set latitude and longitude in this application
        m_position[GENIVI_NAVIGATIONCORE_SPEED]._2=variant_double(0);
        m_position[GENIVI_NAVIGATIONCORE_HEADING]._2=variant_double(0);
    }

	void
	StartSimulation(const uint32_t& sessionHandle)
	{
		if (simulationMode == GENIVI_NAVIGATIONCORE_SIMULATION_STATUS_PAUSED || simulationMode == GENIVI_NAVIGATIONCORE_SIMULATION_STATUS_FIXED_POSITION ) {
			simulationMode=GENIVI_NAVIGATIONCORE_SIMULATION_STATUS_RUNNING;
			SimulationStatusChanged(simulationMode);
			demo_update(true); 
		}
	}

	void
	PauseSimulation(const uint32_t& sessionHandle)
	{
		if (simulationMode == GENIVI_NAVIGATIONCORE_SIMULATION_STATUS_RUNNING) {
			simulationMode=GENIVI_NAVIGATIONCORE_SIMULATION_STATUS_PAUSED;
			SimulationStatusChanged(simulationMode);
			demo_update(false);
		}
	}


	void
    SetSimulationMode(const uint32_t& SessionHandle, const bool& Activate)
	{
        LOG_DEBUG(gCtx,"Set simulation mode to: %d",Activate);
		uint16_t newSimulationMode;
		struct attr vehicle;
		vehicle.type=attr_vehicle;
		vehicle.u.vehicle=get_vehicle(Activate?"demo:":"enhancedposition:");
		if (vehicle.u.vehicle) {
			newSimulationMode = Activate ? GENIVI_NAVIGATIONCORE_SIMULATION_STATUS_FIXED_POSITION : GENIVI_NAVIGATIONCORE_SIMULATION_STATUS_NO_SIMULATION;
			if (newSimulationMode != simulationMode) {
				simulationMode=newSimulationMode;
				SimulationStatusChanged(simulationMode);
			}
			demo_update(false);
			struct navit *navit=get_navit();
			navit_set_attr(navit, &vehicle);
		} else {
             LOG_ERROR_MSG(gCtx,"Failed to get vehicle");
        	}
	}

	void
    SetSimulationSpeed(const uint32_t& sessionHandle, const uint8_t& speedFactor)
	{
		int speed=speedFactor*40/4;
		if (vehicle_speed.u.num != speed) {
			vehicle_speed.u.num=speed;
			SimulationSpeedChanged(speedFactor);
			if (simulationMode == GENIVI_NAVIGATIONCORE_SIMULATION_STATUS_RUNNING) {
				demo_update(true);
			}
		}
	}

	uint8_t
	GetSimulationSpeed()
	{
		return vehicle_speed.u.num*4/40;
	}

    bool m_position_set;
    std::map< int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant > > m_position;
};

static void
tracking_attr_position_coord_geo(void)
{
	struct attr position_coord_geo, current_item;
    LOG_INFO_MSG(gCtx,"Position updated");
	if (tracking_get_attr(tracking, attr_position_coord_geo, &position_coord_geo, NULL)) {
        std::vector< int32_t >changes;
		changes.push_back(GENIVI_NAVIGATIONCORE_LATITUDE);
		changes.push_back(GENIVI_NAVIGATIONCORE_LONGITUDE);
		changes.push_back(GENIVI_NAVIGATIONCORE_SPEED);
		changes.push_back(GENIVI_NAVIGATIONCORE_HEADING);
		server->PositionUpdate(changes);
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
			if (g_strcmp0(new_street_name, street_name)) {
				g_free(street_name);
				street_name=g_strdup(new_street_name);
                std::vector< int32_t >changes;
				changes.push_back(GENIVI_NAVIGATIONCORE_STREET);
				server->AddressUpdate(changes);
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
    DLT_REGISTER_APP("MMPS","MAP MATCHED POSITION SERVER");
    DLT_REGISTER_CONTEXT(gCtx,"MMPS","Global Context");

    dispatcher.attach(NULL);
	DBus::default_dispatcher = &dispatcher;
	conn = new DBus::Connection(DBus::Connection::SessionBus());
	conn->setup(&dispatcher);
	conn->request_name("org.genivi.navigation.navigationcore.MapMatchedPosition");
	server=new MapMatchedPosition(*conn);
	config_cb.type=attr_callback;
	config_cb.u.callback=callback_new_attr_0(callback_cast(config_attr_navit), attr_navit);
	config_add_attr(config, &config_cb);
}
