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

#if (SPEECH_ENABLED)
#include "genivi-speechservice-constants.h"
#include "genivi-speechservice-speechoutput_proxy.h"
#endif

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

#include <CommonAPI/CommonAPI.hpp>
#include <CommonTypes.hpp>
#include <NavigationTypes.hpp>
#include <NavigationCoreTypes.hpp>
#include <GuidanceStubDefault.hpp>

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

using namespace v4::org::genivi::navigation::navigationcore;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

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

class GuidanceServerStub;

class GuidanceObj
{
	public:
	struct callback *m_guidance_callback;
	struct attr m_route, m_vehicleprofile, m_tracking_callback;
	uint32_t m_session,m_route_handle;
    GuidanceServerStub *m_guidance;
#if (SPEECH_ENABLED)
    SpeechOutput *m_speechoutput;
#endif
    bool m_paused;
	bool m_voice_guidance;
    Guidance::PromptMode m_prompt_mode;
    std::string m_kind_of_voice;
	struct item *get_item(struct map_rect *mr);
	struct map_rect *get_map_rect(void);
	void SetVoiceGuidance(const bool& activate, const std::string& voice);
    void SetVoiceGuidanceSettings(const Guidance::PromptMode &promptMode);
    Guidance::PromptMode GetVoiceGuidanceSettings();
	void PlayVoiceManeuver();
    void GetGuidanceStatus(Guidance::GuidanceStatus &guidanceStatus, NavigationTypes::Handle &routeHandle);
	void GetDestinationInformation(uint32_t& offset, uint32_t& TravelTime, int32_t& Direction, int16_t& TimeZone);
    void GetManeuver(struct item *item, uint32_t& offsetOfManeuver, Guidance::ManeuverType &maneuverType, std::string& roadNameAfterManeuver, Guidance::ManeuverData &maneuverData);
    void GetManeuversList(const uint16_t& requestedNumberOfManeuvers, const uint32_t& maneuverOffset, uint16_t& numberOfManeuvers, std::vector<Guidance::Maneuver> &maneuversList);
    void GetGuidanceDetails(bool& voiceGuidance, bool& vehicleOnTheRoad, bool& isDestinationReached, Guidance::ManeuverPhase &maneuver);
    GuidanceObj(class GuidanceServerStub *guidance, uint32_t SessionHandle, uint32_t RouteHandle);
	~GuidanceObj();
};

void GuidanceObj_Callback(GuidanceObj *obj);
static class GuidanceObj *mp_guidance;
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

class  GuidanceServerStub : public GuidanceStubDefault
{
	public:
    GuidanceServerStub()
	{
        m_version.setVersionMajor(3);
        m_version.setVersionMinor(0);
        m_version.setVersionMicro(0);
        m_version.setDate("21-01-2014");

        mp_guidance = NULL;
	}

    ~GuidanceServerStub() {
        delete mp_guidance;
    }

    /**
     * description: getVersion = This method returns the API version implemented by the server
     *   application
     */
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply) {
        _reply(m_version);
    }

    /**
     * description: startGuidance = This method starts the guidance for a given route
     */
    void startGuidance(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, startGuidanceReply_t _reply){
        dbg(lvl_debug,"enter\n");
        if (mp_guidance) {
            dbg(lvl_debug,"guidance already active\n");
            throw DBus::ErrorFailed("guidance already active");
        }
        mp_guidance=new GuidanceObj(this, _sessionHandle, _routeHandle);
        fireGuidanceStatusChangedEvent(Guidance::GuidanceStatus::ACTIVE, _routeHandle);
        _reply();
    }

    /**
     * description: stopGuidance = This method stops the guidance
     */
    void stopGuidance(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, stopGuidanceReply_t _reply){
        dbg(lvl_debug,"enter\n");
        if (!mp_guidance) {
            dbg(lvl_debug,"no guidance active\n");
            throw DBus::ErrorFailed("no guidance active");
        }
        Guidance::GuidanceStatus _guidanceStatus;
        NavigationTypes::Handle _routeHandle;
        mp_guidance->GetGuidanceStatus(_guidanceStatus,_routeHandle);
        delete(mp_guidance);
        mp_guidance = NULL;
        fireGuidanceStatusChangedEvent(Guidance::GuidanceStatus::INACTIVE, _routeHandle);
        _reply();
    }

    /**
     * description: setVoiceGuidance = This method switch on/off the voice guidance
     */
    void setVoiceGuidance(const std::shared_ptr<CommonAPI::ClientId> _client, bool _activate, std::string _voice, setVoiceGuidanceReply_t _reply){
        Guidance::setVoiceGuidanceError _error = Guidance::setVoiceGuidanceError::OK;
        mp_guidance->SetVoiceGuidance(_activate,_voice);
        _reply(_error);
    }

    /**
     * description: getGuidanceDetails = This method retrieves guidance information
     */
    void getGuidanceDetails(const std::shared_ptr<CommonAPI::ClientId> _client, getGuidanceDetailsReply_t _reply){
        if (!mp_guidance) {
            dbg(lvl_debug,"no guidance active\n");
            throw DBus::ErrorFailed("no guidance active");
        }

        bool _voiceGuidance;
        bool _vehicleOnTheRoad;
        bool _isDestinationReached;
        Guidance::ManeuverPhase _maneuver;
        mp_guidance->GetGuidanceDetails(_voiceGuidance, _vehicleOnTheRoad, _isDestinationReached, _maneuver);

        _reply(_voiceGuidance,_vehicleOnTheRoad,_isDestinationReached,_maneuver);
    }

    /**
     * description: playVoiceManeuver = This method plays or repeats the last voice guidance
     */
    void playVoiceManeuver(const std::shared_ptr<CommonAPI::ClientId> _client, playVoiceManeuverReply_t _reply){
        Guidance::playVoiceManeuverError _error = Guidance::playVoiceManeuverError::OK;
        if (!mp_guidance) {
            dbg(lvl_debug,"no guidance active\n");
            _error = Guidance::playVoiceManeuverError::GUIDANCE_ERROR_VOICENOTALLOWED;
        }

        mp_guidance->PlayVoiceManeuver();
        _reply(_error);
    }

    /**
     * description: getWaypointInformation = This method retrieves the information on the remaining
     *   way points of the route. A point can be the final destination as well as a
     *   stage defined by the user. The returned waypoints are ordered by their
     *   'number'.
     */
    void getWaypointInformation(const std::shared_ptr<CommonAPI::ClientId> _client, uint16_t _requestedNumberOfWaypoints, getWaypointInformationReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: This method retrieves the information on the final destination
     */
    void getDestinationInformation(const std::shared_ptr<CommonAPI::ClientId> _client, getDestinationInformationReply_t _reply){
        dbg(lvl_debug,"enter\n");
        if (!mp_guidance) {
            dbg(lvl_debug,"no guidance active\n");
            throw DBus::ErrorFailed("no guidance active");
        }

        uint32_t _offset;
        uint32_t _travelTime;
        int32_t _direction;
        Guidance::Side _side = Guidance::Side::NOT_AVAILABLE;
        int16_t _timeZone;
        int16_t _daylightSavingTime = 0;
        mp_guidance->GetDestinationInformation(_offset, _travelTime, _direction, _timeZone);
        _reply(_offset, _travelTime, _direction, _side, _timeZone, _daylightSavingTime);
    }

    /**
     * description: getManeuversList = This method retrieves the list of next maneuvers
     */
    void getManeuversList(const std::shared_ptr<CommonAPI::ClientId> _client, uint16_t _requestedNumberOfManeuvers, uint32_t _maneuverOffset, getManeuversListReply_t _reply){
        Guidance::getManeuversListError _error = Guidance::getManeuversListError::OK;
        if (!mp_guidance) {
            dbg(lvl_debug,"no guidance active\n");
            _error = Guidance::getManeuversListError::GUIDANCE_ERROR_NOMANEUVER;
        }

        uint16_t _numberOfManeuvers;
        std::vector<Guidance::Maneuver> _maneuversList;
        mp_guidance->GetManeuversList(_requestedNumberOfManeuvers, _maneuverOffset, _numberOfManeuvers, _maneuversList);
        _reply(_error,_numberOfManeuvers,_maneuversList);
    }

    /**
     * description: setRouteCalculationMode = This method configures the way the navigation
     *   application wants the navigation core to behave of reroute trigger
     */
    void setRouteCalculationMode(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, Guidance::CalculationMode _routeCalculationMode, setRouteCalculationModeReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: skipNextManeuver = This method allows to jump behind the current maneuver
     */
    void skipNextManeuver(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, skipNextManeuverReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getGuidanceStatus = This method retrieves the guidance status
     */
    void getGuidanceStatus(const std::shared_ptr<CommonAPI::ClientId> _client, getGuidanceStatusReply_t _reply){
        Guidance::GuidanceStatus _guidanceStatus;
        NavigationTypes::Handle _routeHandle;
        if (mp_guidance) {
            mp_guidance->GetGuidanceStatus(_guidanceStatus, _routeHandle);
        } else {
            _guidanceStatus=Guidance::GuidanceStatus::INACTIVE;
            _routeHandle=0;
        }
        _reply(_guidanceStatus,_routeHandle);
    }

    /**
     * description: setVoiceGuidanceSettings = This method sets the voice guidance settings
     */
    void setVoiceGuidanceSettings(const std::shared_ptr<CommonAPI::ClientId> _client, Guidance::PromptMode _promptMode, setVoiceGuidanceSettingsReply_t _reply){
        Guidance::setVoiceGuidanceSettingsError _error = Guidance::setVoiceGuidanceSettingsError::OK;
        mp_guidance->SetVoiceGuidanceSettings(_promptMode);
        _reply(_error);
    }

    /**
     * description: getVoiceGuidanceSettings = This method returns the used voice guidance settings
     */
    void getVoiceGuidanceSettings(const std::shared_ptr<CommonAPI::ClientId> _client, getVoiceGuidanceSettingsReply_t _reply){
        _reply(mp_guidance->GetVoiceGuidanceSettings());
    }

private:
    CommonTypes::Version m_version;
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
    while ((item=map_rect_get_item(mr))) {
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
GuidanceObj::GetManeuver(struct item *item, uint32_t& offsetOfManeuver, Guidance::ManeuverType& maneuverType, std::string& roadNameAfterManeuver, Guidance::ManeuverData& maneuverData)
{
	struct attr length, street_name;
    Guidance::ManeuverDataAttribute maneuverDataAttribute;
    Guidance::ManeuverDataValue maneuverDataValue;

    if (item_attr_get(item, attr_length, &length)) {
        offsetOfManeuver=length.u.num;
	}
	if (item_attr_get(item, attr_street_name, &street_name)) {
        roadNameAfterManeuver=std::string(street_name.u.str);
	}

    maneuverDataAttribute = Guidance::ManeuverDataAttribute::DIRECTION;
	switch (item->type) {
	case type_nav_straight:
        maneuverType=Guidance::ManeuverType::CROSSROAD;
        maneuverDataValue = Guidance::ManeuverDirection::STRAIGHT_ON;
		break;
	case type_nav_turnaround:
        maneuverType=Guidance::ManeuverType::CROSSROAD;
        maneuverDataValue = Guidance::ManeuverDirection::UTURN_LEFT;
		break;
	case type_nav_right_1:
        maneuverType=Guidance::ManeuverType::CROSSROAD;
        maneuverDataValue = Guidance::ManeuverDirection::SLIGHT_RIGHT;
		break;
	case type_nav_right_2:
        maneuverType=Guidance::ManeuverType::CROSSROAD;
        maneuverDataValue = Guidance::ManeuverDirection::RIGHT;
		break;
	case type_nav_right_3:
        maneuverType=Guidance::ManeuverType::CROSSROAD;
        maneuverDataValue = Guidance::ManeuverDirection::HARD_RIGHT;
		break;
	case type_nav_left_1:
        maneuverType=Guidance::ManeuverType::CROSSROAD;
        maneuverDataValue = Guidance::ManeuverDirection::SLIGHT_LEFT;
		break;
	case type_nav_left_2:
        maneuverType=Guidance::ManeuverType::CROSSROAD;
        maneuverDataValue = Guidance::ManeuverDirection::LEFT;
		break;
	case type_nav_left_3:
        maneuverType=Guidance::ManeuverType::CROSSROAD;
        maneuverDataValue = Guidance::ManeuverDirection::HARD_LEFT;
		break;
	// FIXME: Are ManeuverDirection values right here?
	case type_nav_roundabout_r1:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::HARD_RIGHT;
		break;
	case type_nav_roundabout_r2:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::RIGHT;
		break;
	case type_nav_roundabout_r3:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::SLIGHT_RIGHT;
		break;
	case type_nav_roundabout_r4:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::STRAIGHT_ON;
		break;
	case type_nav_roundabout_r5:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::SLIGHT_LEFT;
		break;
	case type_nav_roundabout_r6:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::LEFT;
		break;
	case type_nav_roundabout_r7:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::HARD_LEFT;
		break;
	case type_nav_roundabout_r8:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::UTURN_LEFT;
		break;
	// FIXME: Distinguish between clockwise and counterclockwise roundabout?
	case type_nav_roundabout_l1:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::HARD_LEFT;
		break;
	case type_nav_roundabout_l2:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::LEFT;
		break;
	case type_nav_roundabout_l3:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::SLIGHT_LEFT;
		break;
	case type_nav_roundabout_l4:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::STRAIGHT_ON;
		break;
	case type_nav_roundabout_l5:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::SLIGHT_RIGHT;
		break;
	case type_nav_roundabout_l6:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::RIGHT;
		break;
	case type_nav_roundabout_l7:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::HARD_RIGHT;
		break;
	case type_nav_roundabout_l8:
        maneuverType=Guidance::ManeuverType::ROUNDABOUT;
        maneuverDataValue = Guidance::ManeuverDirection::UTURN_RIGHT;
		break;
	case type_nav_destination:
        maneuverType=Guidance::ManeuverType::DESTINATION;
        maneuverDataValue = Guidance::ManeuverDirection::STRAIGHT_ON;
		break;
	default:
        dbg(lvl_error,"Unable to convert type %s\n",item_to_name(item->type));
        maneuverType=Guidance::ManeuverType::INVALID;
        maneuverDataAttribute = Guidance::ManeuverDataAttribute::INVALID;
        maneuverDataValue = Guidance::ManeuverDirection::INVALID;
	}
    maneuverData[maneuverDataAttribute] = maneuverDataValue;
}

void
GuidanceObj::GetGuidanceDetails(bool& voiceGuidance, bool& vehicleOnTheRoad, bool& isDestinationReached, Guidance::ManeuverPhase& maneuver)
{
    struct map_rect *mr=get_map_rect();
    struct item *item;
    item=get_item(mr);
    struct attr level;

    voiceGuidance = m_voice_guidance;
    vehicleOnTheRoad = true; //by default, no off-road managed
    isDestinationReached = false; //to be done
    if (item && item_attr_get(item, attr_level, &level)) {
        dbg(lvl_debug,"level=%d\n",(int) level.u.num);
        switch(level.u.num) {
        case 3:
            maneuver=Guidance::ManeuverPhase::CRUISE;
            break;
        case 2:
            maneuver=Guidance::ManeuverPhase::MANEUVER_APPEARED;
            break;
        case 1:
            maneuver=Guidance::ManeuverPhase::PRE_ADVICE;
            break;
        case 0:
            maneuver=Guidance::ManeuverPhase::ADVICE;
            break;
        default:
            maneuver=Guidance::ManeuverPhase::INVALID;
        }
    } else {
        dbg(lvl_debug,"failed to get level item=%p\n",item);
    }

}

void
GuidanceObj::GetManeuversList(const uint16_t& requestedNumberOfManeuvers, const uint32_t& maneuverOffset, uint16_t& numberOfManeuvers, std::vector<Guidance::Maneuver>& maneuversList)
{
	struct map_rect *mr=get_map_rect();
	struct item *item;
    uint16_t maneuverIndex;
    Guidance::ManeuverData::iterator it;

    numberOfManeuvers = 0;
    maneuverIndex = 0;
    while ((item=get_item(mr))) { //scan the list of maneuvers of the route
        if (maneuverIndex >= maneuverOffset && maneuverIndex < maneuverOffset+requestedNumberOfManeuvers) {
            Guidance::Maneuver maneuver;
            std::vector<Guidance::ManeuverItem> items;
            Guidance::ManeuverItem sub_maneuver;
            Guidance::ManeuverData maneuverData;
            maneuver.setRoadNumberAfterManeuver(""); //roadNumberAfterManeuver not managed yet
            maneuver.setRoadPropertyAfterManeuver(Guidance::RoadProperty::INVALID); //roadPropertyAfterManeuver not managed yet
            maneuver.setDrivingSide(Guidance::Side::RIGHT); //drivingSide not managed yet
            maneuver.setOffsetOfNextManeuver(0); //offsetOfNextManeuver not managed yet
            //get infos about maneuver: sub_maneuver._1: DistanceToManeuver, sub_maneuver._4: Maneuver, maneuver._2: RoadAfterManeuver
            //maneuver_data is a map of attribute and value (e.g. DIRECTION STRAIGHT_ON )
            uint32_t offsetOfManeuver;
            Guidance::ManeuverType maneuverType;
            std::string roadNameAfterManeuver;
            GetManeuver(item, offsetOfManeuver, maneuverType, roadNameAfterManeuver, maneuverData);
            maneuver.setRoadNameAfterManeuver(roadNameAfterManeuver);
            sub_maneuver.setOffsetOfManeuver(offsetOfManeuver);
            sub_maneuver.setManeuver(maneuverType);
            sub_maneuver.setManeuverData(maneuverData);
            items.push_back(sub_maneuver);
            maneuver.setItems(items);
            if (maneuversList.size())
                maneuversList.back().setOffsetOfNextManeuver(offsetOfManeuver); //offsetOfNextManeuver of the last record is the offsetOfManeuver  of this one
			maneuversList.push_back(maneuver);
            numberOfManeuvers++;
		}
        maneuverIndex++;
	}
	map_rect_destroy(mr);
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

void GuidanceObj::SetVoiceGuidanceSettings(const Guidance::PromptMode& promptMode)
{
    m_prompt_mode = promptMode;
}

Guidance::PromptMode GuidanceObj::GetVoiceGuidanceSettings()
{
    return m_prompt_mode;
}

void
GuidanceObj::GetGuidanceStatus(Guidance::GuidanceStatus &guidanceStatus, NavigationTypes::Handle& routeHandle)
{
	if (m_paused)
        guidanceStatus = Guidance::GuidanceStatus::INACTIVE;
    else
        guidanceStatus = Guidance::GuidanceStatus::ACTIVE;
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
        Guidance::ManeuverPhase maneuver;
        dbg(lvl_debug,"level=%d\n",(int) level.u.num);
		switch(level.u.num) {
		case 3:
            maneuver=Guidance::ManeuverPhase::CRUISE;
			break;
		case 2:
            maneuver=Guidance::ManeuverPhase::MANEUVER_APPEARED;
			break;
		case 1:
            maneuver=Guidance::ManeuverPhase::PRE_ADVICE;
			break;
		case 0:
            maneuver=Guidance::ManeuverPhase::ADVICE;
			break;
		default:
            maneuver=Guidance::ManeuverPhase::INVALID;
		}
        obj->m_guidance->fireManeuverChangedEvent(maneuver);
	} else {
        dbg(lvl_debug,"failed to get level item=%p\n",item);
	}
}


void
GuidanceObj_TrackingCallback(GuidanceObj *obj)
{
    dbg(lvl_debug,"enter\n");
	struct attr attr;
	route_set_position_from_tracking(obj->m_route.u.route, get_tracking(), projection_mg);
	if (!obj->m_paused)
        obj->m_guidance->firePositionOnRouteChangedEvent(0); //to do return the current offset on the route in meters from the beginning of the route

	int destreached=route_destination_reached(obj->m_route.u.route);
	if (destreached)
        obj->m_guidance->fireWaypointReachedEvent(destreached == 2);
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

GuidanceObj::GuidanceObj(GuidanceServerStub *guidance, uint32_t SessionHandle, uint32_t RouteHandle)
{
	m_guidance=guidance;
	m_session=SessionHandle;
	m_route_handle=RouteHandle;
	m_guidance_callback=callback_new_1(reinterpret_cast<void (*)(void)>(GuidanceObj_Callback), this);
	m_paused=false;
	m_voice_guidance=false;
    m_kind_of_voice="DEFAULT";
    m_prompt_mode=Guidance::PromptMode::MANUAL_PROMPT;
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
#if (SPEECH_ENABLED)
    delete(m_speechoutput);
#endif

}

void
plugin_init(void)
{
    // Common API data init
    std::shared_ptr < CommonAPI::Runtime > runtime = CommonAPI::Runtime::get();

    const std::string &domain = "local";
    const std::string &instance = "Guidance";

    std::shared_ptr<GuidanceServerStub> myServiceGuidance = std::make_shared<GuidanceServerStub>();

    bool successfullyRegistered = runtime->registerService(domain, instance, myServiceGuidance);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instance, myServiceGuidance);
    }
}
