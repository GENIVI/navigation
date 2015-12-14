/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_navigationcore_guidance.cxx
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
#include "genivi-navigationcore-guidance_adaptor.h"

#include "genivi-speechservice-constants.h"
#include "genivi-speechservice-speechoutput_proxy.h"

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

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

static DBus::Glib::BusDispatcher dispatcher;
static DBus::Connection *conn;

#if (SPEECH_ENABLED)
class SpeechOutput
: public org::genivi::hmi::speechservice::SpeechOutput_proxy,
  public DBus::ObjectProxy
{
    public:
    SpeechOutput(DBus::Connection &connection)
        : DBus::ObjectProxy(connection,
                                    "/org/genivi/hmi/speechservice/SpeechOutput",
                                    "org.genivi.hmi.speechservice.SpeechOutput")
    {
    }

    void notifyConnectionStatus(const uint32_t& connectionStatus)
    {

    }

    void notifyMarkerReached(const uint32_t& chunkID, const std::string& marker)
    {

    }

    void notifyQueueStatus(const uint32_t& queueStatus)
    {

    }

    void notifyTTSStatus(const uint32_t& ttsStatus)
    {

    }
};
#endif

class Guidance;

class GuidanceObj
{
	public:
	struct callback *m_guidance_callback;
	struct attr m_route, m_vehicleprofile, m_tracking_callback;
	uint32_t m_session,m_route_handle;
	Guidance *m_guidance;
#if (SPEECH_ENABLED)
    SpeechOutput *m_speechoutput;
#endif
    bool m_paused;
	bool m_voice_guidance;
    uint16_t m_prompt_mode;
    std::string m_kind_of_voice;
	struct item *get_item(struct map_rect *mr);
	struct map_rect *get_map_rect(void);
    void SetSimulationMode(uint32_t SessionHandle, bool Activate);
    void GetSimulationMode(bool& SimulationMode);
    void SetSimulationSpeed(uint32_t sessionHandle);
    void PauseGuidance(uint32_t sessionHandle);
    void ResumeGuidance(uint32_t sessionHandle);
	void SetVoiceGuidance(const bool& activate, const std::string& voice);
    void SetVoiceGuidanceSettings(const uint16_t& promptMode);
    uint16_t GetVoiceGuidanceSettings();
	void PlayVoiceManeuver();
	void GetGuidanceStatus(uint16_t& guidanceStatus, uint32_t& routeHandle);
	void GetDestinationInformation(uint32_t& offset, uint32_t& TravelTime, int32_t& Direction, int16_t& TimeZone);
    void GetManeuver(struct item *item, uint32_t& DistanceToManeuver, uint16_t& Maneuver, std::string& RoadAfterManeuver, ::DBus::Struct< uint16_t, ::DBus::Variant >& ManeuverData);
    void GetManeuversList(const uint16_t& requestedNumberOfManeuvers, const uint32_t& maneuverOffset, uint16_t& numberOfManeuvers, std::vector< ::DBus::Struct< std::string, std::string, uint16_t, uint16_t, uint32_t, std::vector< ::DBus::Struct< uint32_t, uint32_t, int32_t, uint16_t, std::vector< ::DBus::Struct< uint16_t, ::DBus::Variant > > > > > >& maneuversList);
	void GetGuidanceDetails(bool& voiceGuidance, bool& vehicleOnTheRoad, bool& isDestinationReached, uint16_t& maneuver);
	GuidanceObj(class Guidance *guidance, uint32_t SessionHandle, uint32_t RouteHandle);
	~GuidanceObj();
};

void GuidanceObj_Callback(GuidanceObj *obj);
static class GuidanceObj *guidance;
static struct attr vehicle_speed={attr_speed,(char *)40};

static struct navit *
get_navit(void)
{
	struct attr navit;
	if (!config_get_attr(config, attr_navit, &navit, NULL))
		return NULL;
	return navit.u.navit;
}

static struct navigation *
get_navigation(void)
{
	struct navit *navit=get_navit();
	struct attr navigation;
	if (!navit)
		return NULL;
	if (!navit_get_attr(navit, attr_navigation, &navigation, NULL))
		return NULL;
	return navigation.u.navigation;
}

static struct tracking *
get_tracking(void)
{
	struct navit *navit=get_navit();
	struct attr tracking;
	if (!navit)
		return NULL;
	if (!navit_get_attr(navit, attr_trackingo, &tracking, NULL))
		return NULL;
	return tracking.u.tracking;
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

static DBus::Variant
variant_uint16(uint16_t i)
{
    DBus::Variant variant;
    DBus::MessageIter iter=variant.writer();
    iter << i;
    return variant;
}

class  Guidance
: public org::genivi::navigationcore::Guidance_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
	public:
	Guidance(DBus::Connection &connection)
	: DBus::ObjectAdaptor(connection, "/org/genivi/navigationcore")
	{
        simulationMode = true; //by default
	}

	void
    SetSimulationMode(const uint32_t& SessionHandle, const bool& Activate)
	{
        dbg(lvl_debug,"enter Activate=%d\n",Activate);
		struct attr vehicle;
		vehicle.type=attr_vehicle;
        vehicle.u.vehicle=get_vehicle(Activate?"enhancedposition:":"demo:");
		if (vehicle.u.vehicle) {
            simulationMode = Activate;
			struct navit *navit=get_navit();
			navit_set_attr(navit, &vehicle);
		} else {
            dbg(lvl_debug,"Failed to get vehicle\n");
        }
	}

	bool
    GetSimulationMode()
    {
        return (simulationMode);
    }

	void	
    StartGuidance(const uint32_t& SessionHandle, const uint32_t& RouteHandle)
	{
        dbg(lvl_debug,"enter\n");
		if (guidance) {
            dbg(lvl_debug,"guidance already active\n");
			throw DBus::ErrorFailed("guidance already active");
		}
		guidance=new GuidanceObj(this, SessionHandle, RouteHandle);
	}

	void	
    StopGuidance(const uint32_t& SessionHandle)
	{
        dbg(lvl_debug,"enter\n");
		if (!guidance) {
            dbg(lvl_debug,"no guidance active\n");
			throw DBus::ErrorFailed("no guidance active");
		}
		delete(guidance);
		guidance=NULL;
	}

    void
    GetDestinationInformation(uint32_t& offset, uint32_t& travelTime, int32_t& direction, uint16_t& side, int16_t& timeZone, int16_t& daylightSavingTime)
	{
        dbg(lvl_debug,"enter\n");
		if (!guidance) {
            dbg(lvl_debug,"no guidance active\n");
			throw DBus::ErrorFailed("no guidance active");
		}
        guidance->GetDestinationInformation(offset, travelTime, direction, timeZone);
	}

	::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string >
	GetVersion()
	{
		DBus::Struct<uint16_t, uint16_t, uint16_t, std::string> Version;
		Version._1=3;
		Version._2=0;
		Version._3=0;
		Version._4=std::string("23-10-2013");
		return Version;
	}

	void
    SetSimulationSpeed(const uint32_t& sessionHandle, const uint8_t& speedFactor)
	{
		vehicle_speed.u.num=speedFactor*40/4;
		if (guidance)
			guidance->SetSimulationSpeed(sessionHandle);
	}

	uint8_t
	GetSimulationSpeed()
	{
		return vehicle_speed.u.num*4/40;
	}

	void
    PauseGuidance(const uint32_t& sessionHandle)
	{
		if (!guidance) {
            dbg(lvl_debug,"no guidance active\n");
			throw DBus::ErrorFailed("no guidance active");
		}
		guidance->PauseGuidance(sessionHandle);
	}

	void
    ResumeGuidance(const uint32_t& sessionHandle)
	{
		if (!guidance) {
            dbg(lvl_debug,"no guidance active\n");
			throw DBus::ErrorFailed("no guidance active");
		}
		guidance->ResumeGuidance(sessionHandle);
	}

	void
	SetVoiceGuidance(const bool& activate, const std::string& voice)
	{
        guidance->SetVoiceGuidance(activate,voice);
	}

	void
	GetGuidanceDetails(bool& voiceGuidance, bool& vehicleOnTheRoad, bool& isDestinationReached, uint16_t& maneuver)
	{
		if (!guidance) {
            dbg(lvl_debug,"no guidance active\n");
			throw DBus::ErrorFailed("no guidance active");
		}
		guidance->GetGuidanceDetails(voiceGuidance, vehicleOnTheRoad, isDestinationReached, maneuver);
	}

	void
	PlayVoiceManeuver()
	{
        if (!guidance) {
            dbg(lvl_debug,"no guidance active\n");
            throw DBus::ErrorFailed("no guidance active");
        }
        guidance->PlayVoiceManeuver();
	}


    void
    GetWaypointInformation(const uint16_t& requestedNumberOfWaypoints, uint16_t& numberOfWaypoints, std::vector< ::DBus::Struct< uint32_t, uint32_t, int32_t, uint16_t, int16_t, int16_t, bool, uint16_t > >& waypointsList)
    {
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    void
    GetManeuversList(const uint16_t& requestedNumberOfManeuvers, const uint32_t& maneuverOffset, uint16_t& numberOfManeuvers, std::vector< ::DBus::Struct< std::string, std::string, uint16_t, uint16_t, uint32_t, std::vector< ::DBus::Struct< uint32_t, uint32_t, int32_t, uint16_t, std::vector< ::DBus::Struct< uint16_t, ::DBus::Variant > > > > > >& maneuversList)
	{
		if (!guidance) {
            dbg(lvl_debug,"no guidance active\n");
			throw DBus::ErrorFailed("no guidance active");
		}
		guidance->GetManeuversList(requestedNumberOfManeuvers, maneuverOffset, numberOfManeuvers, maneuversList);
	}

	void
    SetRouteCalculationMode(const uint32_t& sessionHandle, const uint16_t& routeCalculationMode)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
    SkipNextManeuver(const uint32_t& sessionHandle)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
	GetGuidanceStatus(uint16_t& guidanceStatus, uint32_t& routeHandle)
	{
		if (guidance) {
			guidance->GetGuidanceStatus(guidanceStatus, routeHandle);
		} else {
			guidanceStatus=GENIVI_NAVIGATIONCORE_INACTIVE;
			routeHandle=0;
		}
	}

	void
	SetVoiceGuidanceSettings(const uint16_t& promptMode)
	{
        guidance->SetVoiceGuidanceSettings(promptMode);
	}

	uint16_t
	GetVoiceGuidanceSettings()
	{
        return guidance->GetVoiceGuidanceSettings();
	}

    void
    GetNearestRouteLocation(double& distance, double& direction)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    void
    GetNearestRoadLocation(double& distance, int32_t& direction)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    bool simulationMode;
};

void
GuidanceObj::GetDestinationInformation(uint32_t& Distance, uint32_t& TravelTime, int32_t& Direction, int16_t &TimeZone)
{
	struct coord c[2];
	int idx=0;
	struct attr destination_time, destination_length;
	struct map_rect *mr=get_map_rect();
	struct item *item;
	if (!mr) 
		throw DBus::ErrorFailed("internal error:failed to get map rect");
	while (item=map_rect_get_item(mr)) {
		if (item_coord_get(item, &c[idx], 1)) {
			if (!idx) {
				if (!item_attr_get(item, attr_destination_time, &destination_time))
					destination_time.u.num=-1;
				if (!item_attr_get(item, attr_destination_length, &destination_length))
					destination_length.u.num=-1;
				idx=1;
			}
		}
	}
	if (!idx)
		throw DBus::ErrorFailed("internal error:navigation has only one coordinate");
	if (destination_time.u.num == -1 || destination_length.u.num == -1) {
        dbg(lvl_debug,"time %d length %d\n",(int) destination_time.u.num, (int) destination_length.u.num);
		throw DBus::ErrorFailed("internal error:failed to get time or length");
	}
	Distance=destination_length.u.num;
	TravelTime=destination_time.u.num/10;
	Direction=transform_get_angle_delta(&c[0], &c[1], 0);
	TimeZone=0;
}

void
GuidanceObj::GetManeuver(struct item *item, uint32_t& DistanceToManeuver, uint16_t& Maneuver, std::string& RoadAfterManeuver, ::DBus::Struct< uint16_t, ::DBus::Variant >& ManeuverData)
{
	struct attr length, street_name;
	if (item_attr_get(item, attr_length, &length)) {
		DistanceToManeuver=length.u.num;
	}
	if (item_attr_get(item, attr_street_name, &street_name)) {
		RoadAfterManeuver=std::string(street_name.u.str);
	}
    ManeuverData._1 = GENIVI_NAVIGATIONCORE_DIRECTION;
	switch (item->type) {
	case type_nav_straight:
        Maneuver=GENIVI_NAVIGATIONCORE_CROSSROAD;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_STRAIGHT_ON);
		break;
	case type_nav_turnaround:
        Maneuver=GENIVI_NAVIGATIONCORE_CROSSROAD;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_UTURN_LEFT);
		break;
	case type_nav_right_1:
        Maneuver=GENIVI_NAVIGATIONCORE_CROSSROAD;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_SLIGHT_RIGHT);
		break;
	case type_nav_right_2:
        Maneuver=GENIVI_NAVIGATIONCORE_CROSSROAD;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_RIGHT);
		break;
	case type_nav_right_3:
        Maneuver=GENIVI_NAVIGATIONCORE_CROSSROAD;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_HARD_RIGHT);
		break;
	case type_nav_left_1:
        Maneuver=GENIVI_NAVIGATIONCORE_CROSSROAD;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_SLIGHT_LEFT);
		break;
	case type_nav_left_2:
        Maneuver=GENIVI_NAVIGATIONCORE_CROSSROAD;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_LEFT);
		break;
	case type_nav_left_3:
        Maneuver=GENIVI_NAVIGATIONCORE_CROSSROAD;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_HARD_LEFT);
		break;
	// FIXME: Are ManeuverDirection values right here?
	case type_nav_roundabout_r1:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_HARD_RIGHT);
		break;
	case type_nav_roundabout_r2:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_RIGHT);
		break;
	case type_nav_roundabout_r3:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_SLIGHT_RIGHT);
		break;
	case type_nav_roundabout_r4:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_STRAIGHT_ON);
		break;
	case type_nav_roundabout_r5:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_SLIGHT_LEFT);
		break;
	case type_nav_roundabout_r6:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_LEFT);
		break;
	case type_nav_roundabout_r7:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_HARD_LEFT);
		break;
	case type_nav_roundabout_r8:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_UTURN_LEFT);
		break;
	// FIXME: Distinguish between clockwise and counterclockwise roundabout?
	case type_nav_roundabout_l1:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_HARD_LEFT);
		break;
	case type_nav_roundabout_l2:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_LEFT);
		break;
	case type_nav_roundabout_l3:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_SLIGHT_LEFT);
		break;
	case type_nav_roundabout_l4:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_STRAIGHT_ON);
		break;
	case type_nav_roundabout_l5:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_SLIGHT_RIGHT);
		break;
	case type_nav_roundabout_l6:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_RIGHT);
		break;
	case type_nav_roundabout_l7:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_HARD_RIGHT);
		break;
	case type_nav_roundabout_l8:
        Maneuver=GENIVI_NAVIGATIONCORE_ROUNDABOUT;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_UTURN_RIGHT);
		break;
	case type_nav_destination:
        Maneuver=GENIVI_NAVIGATIONCORE_DESTINATION;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_STRAIGHT_ON);
		break;
	default:
        dbg(lvl_error,"Unable to convert type %s\n",item_to_name(item->type));
        Maneuver=GENIVI_NAVIGATIONCORE_INVALID;
        ManeuverData._2=variant_uint16(GENIVI_NAVIGATIONCORE_INVALID);
	}
}


void
GuidanceObj::GetGuidanceDetails(bool& voiceGuidance, bool& vehicleOnTheRoad, bool& isDestinationReached, uint16_t& maneuver)
{
    struct map_rect *mr=get_map_rect();
    struct item *item;
    item=get_item(mr);
    std::string road_name_after_maneuver;
    uint32_t offset_maneuver;
    ::DBus::Struct< uint16_t, ::DBus::Variant > maneuver_data;

    voiceGuidance = m_voice_guidance;
    vehicleOnTheRoad = true; //by default, no off-road managed
    isDestinationReached = false; //to be done

    GetManeuver(item, offset_maneuver, maneuver, road_name_after_maneuver, maneuver_data);

}

void
GuidanceObj::GetManeuversList(const uint16_t& requestedNumberOfManeuvers, const uint32_t& maneuverOffset, uint16_t& numberOfManeuvers, std::vector< ::DBus::Struct< std::string, std::string, uint16_t, uint16_t, uint32_t, std::vector< ::DBus::Struct< uint32_t, uint32_t, int32_t, uint16_t, std::vector< ::DBus::Struct< uint16_t, ::DBus::Variant > > > > > >& maneuversList)
{
	struct map_rect *mr=get_map_rect();
	struct item *item;
    uint16_t maneuverIndex;
    numberOfManeuvers = 0;
    maneuverIndex = 0;
    while (item=get_item(mr)) { //scan the list of maneuvers of the route
        if (maneuverIndex >= maneuverOffset && maneuverIndex < maneuverOffset+requestedNumberOfManeuvers) {
            ::DBus::Struct< std::string, std::string, uint16_t, uint16_t, uint32_t, std::vector< ::DBus::Struct< uint32_t, uint32_t, int32_t, uint16_t, std::vector< ::DBus::Struct< uint16_t, ::DBus::Variant > > > > >maneuver;
            ::DBus::Struct< uint32_t, uint32_t, int32_t, uint16_t, std::vector< ::DBus::Struct< uint16_t, ::DBus::Variant > > > sub_maneuver;
            ::DBus::Struct< uint16_t, ::DBus::Variant > maneuver_data;
            maneuver._1 = ""; //roadNumberAfterManeuver
            maneuver._3 = GENIVI_NAVIGATIONCORE_DEFAULT; //roadPropertyAfterManeuver
            maneuver._4 = GENIVI_NAVIGATIONCORE_RIGHT; //drivingSide
            maneuver._5 = 0; //offsetOfNextManeuver
            GetManeuver(item, sub_maneuver._1, sub_maneuver._4, maneuver._2, maneuver_data);
            sub_maneuver._5.push_back(maneuver_data);
            maneuver._6.push_back(sub_maneuver);
            if (maneuversList.size())
                maneuversList.back()._5 = sub_maneuver._1; //offsetOfNextManeuver of the last record is the offsetOfManeuver  of this one
			maneuversList.push_back(maneuver);
            numberOfManeuvers++;
		}
        maneuverIndex++;
	}
	map_rect_destroy(mr);
}

void
GuidanceObj::SetSimulationSpeed(uint32_t sessionHandle)
{
	struct vehicle *vehicle=get_vehicle("demo:");
	if (vehicle && !m_paused) 
		vehicle_set_attr(vehicle, &vehicle_speed);
}

void
GuidanceObj::PauseGuidance(uint32_t sessionHandle)
{
	struct vehicle *vehicle=get_vehicle("demo:");
	if (vehicle) {
		struct attr vehicle_speed0={attr_speed,(char *)0};
		vehicle_set_attr(vehicle, &vehicle_speed0);
	}
	m_paused=true;
}

void
GuidanceObj::ResumeGuidance(uint32_t sessionHandle)
{
	struct vehicle *vehicle=get_vehicle("demo:");
	GuidanceObj_Callback(this);
	if (vehicle) 
    {
		vehicle_set_attr(vehicle, &vehicle_speed);
    }
    m_paused=false;
}

void GuidanceObj::SetVoiceGuidance(const bool& activate, const std::string& voice)
{
    m_voice_guidance = activate;
    m_kind_of_voice.clear();
    m_kind_of_voice.append(voice);
}

void GuidanceObj::PlayVoiceManeuver()
{
    message *messages;
    messages = navit_get_messages(get_navit());
#if (SPEECH_ENABLED)
    m_speechoutput->openPrompter(GENIVI_SPEECHSERVICE_CT_NAVIGATION,GENIVI_SPEECHSERVICE_PPT_NAVIGATION);
    m_speechoutput->addTextChunk(messages);
    m_speechoutput->closePrompter();
#endif
}

void GuidanceObj::SetVoiceGuidanceSettings(const uint16_t& promptMode)
{
    m_prompt_mode = promptMode;
}

uint16_t GuidanceObj::GetVoiceGuidanceSettings()
{
    return m_prompt_mode;
}

void
GuidanceObj::GetGuidanceStatus(uint16_t& guidanceStatus, uint32_t& routeHandle)
{
	if (m_paused)
        guidanceStatus = GENIVI_NAVIGATIONCORE_INACTIVE;
    else
        guidanceStatus = GENIVI_NAVIGATIONCORE_ACTIVE;
	routeHandle=m_route_handle;
}


void
GuidanceObj_Callback(GuidanceObj *obj)
{
	struct attr level;
	struct map_rect *mr;
	struct item *item;
    dbg(lvl_debug,"enter\n");
	if (obj->m_paused)
		return;
	mr=obj->get_map_rect();
	if (!mr) {
        dbg(lvl_debug,"failed to get map rect\n");
		return;
	}
	item=obj->get_item(mr);
	if (item && item_attr_get(item, attr_level, &level)) {
		int maneuver;
        dbg(lvl_debug,"level=%d\n",(int) level.u.num);
		switch(level.u.num) {
		case 3:
			maneuver=GENIVI_NAVIGATIONCORE_CRUISE;
			break;
		case 2:
			maneuver=GENIVI_NAVIGATIONCORE_MANEUVER_APPEARED;
			break;
		case 1:
			maneuver=GENIVI_NAVIGATIONCORE_PRE_ADVICE;
			break;
		case 0:
			maneuver=GENIVI_NAVIGATIONCORE_ADVICE;
			break;
		default:
			maneuver=GENIVI_NAVIGATIONCORE_INVALID;
		}
		obj->m_guidance->ManeuverChanged(maneuver);
	} else {
        dbg(lvl_debug,"failed to get level item=%p\n",item);
	}
}

static DBus::Variant
variant_double(double d)
{
	DBus::Variant variant;
	DBus::MessageIter iter=variant.writer();
	iter << d;
	return variant;
}


void
GuidanceObj_TrackingCallback(GuidanceObj *obj)
{
    dbg(lvl_debug,"enter\n");
	struct attr attr;
	route_set_position_from_tracking(obj->m_route.u.route, get_tracking(), projection_mg);
	if (!obj->m_paused)
        obj->m_guidance->PositionOnRouteChanged(0); //to do return the current offset on the route in meters from the beginning of the route

	int destreached=route_destination_reached(obj->m_route.u.route);
	if (destreached)
		obj->m_guidance->WaypointReached(destreached == 2);
	if (destreached == 2) 
		route_set_destination(obj->m_route.u.route, NULL, 0);
}

struct item *
GuidanceObj::get_item(struct map_rect *mr)
{
	struct item *ret;
	while (mr && (ret = map_rect_get_item(mr))) {
		if (ret->type != type_nav_position && ret->type != type_nav_none)
			break;
	}
	return ret;
}

struct map_rect *
GuidanceObj::get_map_rect(void)
{
	struct map *map=navigation_get_map(get_navigation());
	if (!map)
		return NULL;
	return map_rect_new(map, NULL);
}

GuidanceObj::GuidanceObj(Guidance *guidance, uint32_t SessionHandle, uint32_t RouteHandle)
{
	m_guidance=guidance;
	m_session=SessionHandle;
	m_route_handle=RouteHandle;
	m_guidance_callback=callback_new_1(reinterpret_cast<void (*)(void)>(GuidanceObj_Callback), this);
	m_paused=false;
	m_voice_guidance=false;
    m_kind_of_voice="DEFAULT";
    m_prompt_mode=GENIVI_NAVIGATIONCORE_MANUAL_PROMPT;
	m_tracking_callback.type=attr_callback;
	m_tracking_callback.u.callback=NULL;
	struct attr id={attr_id};
	id.u.num=RouteHandle;
	struct attr *in[]={&id, NULL};
	struct attr **ret=NULL;
	struct attr callback_list;
	struct navit *navit=get_navit();

#if (SPEECH_ENABLED)
    m_speechoutput=new SpeechOutput(*conn);
#endif
	if (navit_get_attr(navit, attr_callback_list, &callback_list, NULL)) {
		callback_list_call_attr_4(callback_list.u.callback_list, attr_command, "navit_genivi_get_route", in, &ret, NULL);
		if (ret && ret[0] && ret[1] && ret[0]->type == attr_route && ret[1]->type == attr_vehicleprofile) {
			struct tracking *tracking=get_tracking();
			m_route=*ret[0];
			m_vehicleprofile=*ret[1];
			m_tracking_callback.u.callback=callback_new_attr_1(reinterpret_cast<void (*)(void)>(GuidanceObj_TrackingCallback), attr_position_coord_geo, this);
			tracking_add_attr(tracking, &m_tracking_callback);
			struct vehicle *demo=get_vehicle("demo:");
			if (demo) {
				vehicle_set_attr(demo, &m_route);
				vehicle_set_attr(demo, &vehicle_speed);
			}
			navigation_set_route(get_navigation(), m_route.u.route);
			tracking_set_route(get_tracking(), m_route.u.route);
			navigation_register_callback(get_navigation(), attr_navigation_speech, m_guidance_callback);
			GuidanceObj_Callback(this);
		}
		g_free(ret);
	}
	m_guidance->GuidanceStatusChanged(GENIVI_NAVIGATIONCORE_ACTIVE, RouteHandle);
}

GuidanceObj::~GuidanceObj()
{
	if (m_tracking_callback.u.callback) {
		struct tracking *tracking=get_tracking();
		if (tracking)
			tracking_remove_attr(tracking, &m_tracking_callback);
		callback_destroy(m_tracking_callback.u.callback);
	}
	if (m_guidance_callback) {
		navigation_unregister_callback(get_navigation(), attr_navigation_speech, m_guidance_callback);
		callback_destroy(m_guidance_callback);
	}
	m_guidance->GuidanceStatusChanged(GENIVI_NAVIGATIONCORE_INACTIVE, 0);
#if (SPEECH_ENABLED)
    delete(m_speechoutput);
#endif

}

static class Guidance *server;

void
plugin_init(void)
{
    dispatcher.attach(NULL);
	DBus::default_dispatcher = &dispatcher;
	// FIXME: What dbus address to use? 
	conn = new DBus::Connection(DBus::Connection::SessionBus());
	conn->setup(&dispatcher);
	conn->request_name("org.genivi.navigationcore.Guidance");
	server=new Guidance(*conn);
}
