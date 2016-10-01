/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_positioning_enhancedposition.cxx
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
#include <glib.h>
#include <string.h>
#include <stdbool.h>
#include <assert.h>
#include <math.h>
#define USE_PLUGINS 1
#include "debug.h"
#include "item.h"
#include "navit.h"
#include "map.h"
#include "callback.h"
#include "transform.h"
#include "plugin.h"
#include "event.h"
#include "vehicle.h"
#include "time.h"
#include <unistd.h>

#include <CommonAPI/CommonAPI.hpp>
#include <EnhancedPositionProxy.hpp>
#include <EnhancedPositionServiceTypes.hpp>

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

using namespace org::genivi::EnhancedPositionService;

static std::shared_ptr < CommonAPI::Runtime > runtime;

class EnhancedPositionClientProxy;

struct vehicle_priv {
    class EnhancedPositionClientProxy *enhanced_position;
	struct callback_list *cbl;
	struct callback *cb;
	int cb_pending;
	struct coord_geo geo;
	double speed;
	double direction;
	double height;
	int fix_type;
	time_t fix_time;
	char fixiso8601[128];
	double hdop;
	int sats;
	int sats_signal;
	int sats_used;
};

class EnhancedPositionClientProxy
{
	public:

    struct vehicle_priv *mp_priv;
    std::shared_ptr<EnhancedPositionProxyDefault> myServiceEnhancedPosition;

    EnhancedPositionClientProxy(const std::string domain, const std::string instance)
	{
        myServiceEnhancedPosition = runtime->buildProxy<EnhancedPositionProxy>(domain, instance);

// not working correctly (blocked) so removed for the moment
//        while (!myServiceEnhancedPosition->isAvailable()) {
//            usleep(10);
//        }
    }

    void connectToVehicle(struct vehicle_priv *priv)
    {
        mp_priv=priv;
    }

    void setListeners()
    {
        myServiceEnhancedPosition->getPositionUpdateEvent().subscribe([&](const uint64_t& changedValues) {
            positionUpdate(changedValues);});
    }

	void
    positionUpdate(const uint64_t& changedValues)
	{
        dbg(lvl_debug,"enter\n");
		bool position_found=false;
        if ((changedValues & (EnhancedPositionServiceTypes::PositionInfoKey::LATITUDE | EnhancedPositionServiceTypes::PositionInfoKey::LONGITUDE)) == (EnhancedPositionServiceTypes::PositionInfoKey::LATITUDE | EnhancedPositionServiceTypes::PositionInfoKey::LONGITUDE))
        {
            position_found=true;
		}
        if (position_found && !mp_priv->cb_pending) {
            event_add_timeout(0, 0, mp_priv->cb);
            mp_priv->cb_pending=1;
		}
	}
};

/**
 * @see vehicle_enhancedposition_methods
 */
static void vehicle_enhancedposition_destroy(struct vehicle_priv *priv)
{
    dbg(lvl_debug,"enter\n");
	delete(priv->enhanced_position);
	callback_destroy(priv->cb);
	g_free(priv);
}

/**
 * This function is used to really fetch the changed attribute, e.g. Position,
 * into navit core.
 *
 * @see vehicle_enhancedposition_methods
 */
static int vehicle_enhancedposition_position_attr_get(struct vehicle_priv *priv, enum attr_type type, struct attr *attr)
{
    dbg(lvl_debug, "enter\n");

	switch (type) {
	case attr_position_fix_type:
		// printf("fix_type\n");
		attr->u.num = priv->fix_type;
		break;
	case attr_position_height:
		// printf("height\n");
		attr->u.numd = &priv->height;
		break;
	case attr_position_speed:
		// printf("speed\n");
		attr->u.numd = &priv->speed;
		break;
	case attr_position_direction:
		// printf("direction\n");
		attr->u.numd = &priv->direction;
		break;
#if 0
	case attr_position_hdop:
		// printf("hdop\n");
		attr->u.numd = &priv->hdop;
		break;
	case attr_position_qual:
		// printf("qual\n");
		attr->u.num = priv->sats;
		break;
	case attr_position_sats_signal:
		// printf("sats signal\n");
		attr->u.num = priv->sats_signal;
		break;
	case attr_position_sats_used:
		// printf("sats used\n");
		attr->u.num = priv->sats_used;
		break;
#endif
	case attr_position_coord_geo:
		attr->u.coord_geo = &priv->geo;
		break;
	case attr_position_time_iso8601: {
		struct tm tm;
		if (!priv->fix_time) {
            dbg(lvl_debug,"no fix time\n");
		    	return 0;
		}
		if (gmtime_r(&priv->fix_time, &tm)) {
			strftime(priv->fixiso8601, sizeof(priv->fixiso8601), "%Y-%m-%dT%TZ", &tm);
			attr->u.str = priv->fixiso8601;
		} else
			return 0;
		break;
	}
	default:
		// printf("other attribute\n");
		return 0;
	}
	return 1;
}

static int vehicle_enhancedposition_set_attr(struct vehicle_priv *priv, struct attr *attr)
{
    dbg(lvl_debug, "enter\n");
    return 1;
}

// navit plugin callbacks
struct vehicle_methods vehicle_enhancedposition_methods = {
	vehicle_enhancedposition_destroy,
	vehicle_enhancedposition_position_attr_get,
	vehicle_enhancedposition_set_attr,
};

static void
vehicle_process_map(struct vehicle_priv *priv, EnhancedPositionServiceTypes::PositionInfo& map)
{
    EnhancedPositionServiceTypes::PositionInfo::const_iterator itr;

    for(itr = map.begin(); itr != map.end(); ++itr) {
        switch ((*itr).first) {
        case EnhancedPositionServiceTypes::PositionInfoKey::LATITUDE:
            priv->geo.lat=(*itr).second.get<double>();
			break;
        case EnhancedPositionServiceTypes::PositionInfoKey::LONGITUDE:
            priv->geo.lng=(*itr).second.get<double>();
			break;
        case EnhancedPositionServiceTypes::PositionInfoKey::ALTITUDE:
//			priv->height=(*itr).second.get<double>();
			break;
        case EnhancedPositionServiceTypes::PositionInfoKey::HEADING:
//			priv->direction=(*itr).second.get<float>();
			break;
        case EnhancedPositionServiceTypes::PositionInfoKey::SPEED:
            priv->speed=floor((*itr).second.get<double>()*360+0.5)/100;
			break;
		}
	}
}

static void
vehicle_enhancedposition_callback(struct vehicle_priv *priv)
{
    EnhancedPositionServiceTypes::Bitmask valuesToReturn = (EnhancedPositionServiceTypes::PositionInfoKey::LATITUDE | EnhancedPositionServiceTypes::PositionInfoKey::LONGITUDE | EnhancedPositionServiceTypes::PositionInfoKey::SPEED);
    EnhancedPositionServiceTypes::PositionInfo position;
    EnhancedPositionServiceTypes::Timestamp timestamp;
    CommonAPI::CallStatus status;
    priv->enhanced_position->myServiceEnhancedPosition->GetPositionInfo(valuesToReturn,status,timestamp,position);
    dbg(lvl_debug,"enter GetPositionInfo\n");
    vehicle_process_map(priv, position);
	time(&priv->fix_time); /* FIXME: Use actual value */
	priv->fix_type=2; /* 3d, FIXME: Use actual value */
	callback_list_call_attr_0(priv->cbl, attr_position_coord_geo);
	priv->cb_pending=0;
}

/**
 * vehicle_enhancedposition Constructor.
 *
 * @see plugin_init
 */
static struct vehicle_priv *
vehicle_enhancedposition_new(struct vehicle_methods *meth,
        struct callback_list *cbl, struct attr **attrs)
{
	struct vehicle_priv *ret;

    dbg(lvl_debug, "enter\n");

	*meth=vehicle_enhancedposition_methods;
	ret = g_new0(struct vehicle_priv, 1);
    //init the enhanced position service client
    const std::string domain = "local";
    const std::string instanceEnhancedposition = "EnhancedPositionService";
    ret->enhanced_position = new EnhancedPositionClientProxy(domain,instanceEnhancedposition);
    ret->enhanced_position->setListeners();
    ret->enhanced_position->connectToVehicle(ret);
	ret->cb=callback_new_1(callback_cast(vehicle_enhancedposition_callback), ret);
    ret->cbl=cbl;

	return ret;
}


void plugin_init(void)
{
	event_request_system("glib","genivi_navigationcore_enhpos");

    // Common API data init
    runtime = CommonAPI::Runtime::get();

	plugin_register_vehicle_type("enhancedposition", vehicle_enhancedposition_new);
}
