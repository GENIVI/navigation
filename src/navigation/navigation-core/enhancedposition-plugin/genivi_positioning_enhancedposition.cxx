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

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

#include "positioning-constants.h"
#include "enhanced-position-proxy.h"

DBus::Glib::BusDispatcher dispatcher;
DBus::Connection *conn;

struct vehicle_priv {
	class EnhancedPosition *enhanced_position;
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

class EnhancedPosition
: public org::genivi::positioning::EnhancedPosition_proxy,
  public DBus::ObjectProxy
{
	public:
	struct vehicle_priv *m_priv;
	EnhancedPosition(DBus::Connection &connection, struct vehicle_priv *priv)
		: DBus::ObjectProxy(connection, 
                                    "/org/genivi/positioning/EnhancedPosition",
                                    "org.genivi.positioning.EnhancedPosition")
	{
		m_priv=priv;
	}

	void
    PositionUpdate(const uint64_t& changedValues)
	{
        dbg(lvl_debug,"enter\n");
		int i;
		bool position_found=false;
        if ((changedValues & (GENIVI_ENHANCEDPOSITIONSERVICE_LATITUDE | GENIVI_ENHANCEDPOSITIONSERVICE_LONGITUDE)) == (GENIVI_ENHANCEDPOSITIONSERVICE_LATITUDE | GENIVI_ENHANCEDPOSITIONSERVICE_LONGITUDE))
        {
            position_found=true;
		}
		if (position_found && !m_priv->cb_pending) {
			event_add_timeout(0, 0, m_priv->cb);
			m_priv->cb_pending=1;
		}
	}
};

/**
 * @see vehicle_enhancedposition_methods
 */
static void vehicle_enhancedposition_destroy(struct vehicle_priv *priv)
{
    dbg(lvl_debug,"enter\n");
	DBus::default_dispatcher = &dispatcher;
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
}

// navit plugin callbacks
struct vehicle_methods vehicle_enhancedposition_methods = {
	vehicle_enhancedposition_destroy,
	vehicle_enhancedposition_position_attr_get,
	vehicle_enhancedposition_set_attr,
};

static double
double_variant(DBus::Variant variant)
{
	double d;
	DBus::MessageIter iter=variant.reader();
	iter >> d;
	return d;
}


static void
vehicle_process_map(struct vehicle_priv *priv, std::map< uint64_t, ::DBus::Variant >&map)
{
    std::map< uint64_t, ::DBus::Variant >::const_iterator itr;
	for(itr = map.begin(); itr != map.end(); ++itr) {
		switch ((*itr).first) {
		case GENIVI_ENHANCEDPOSITIONSERVICE_LATITUDE:
			priv->geo.lat=double_variant((*itr).second);
			break;
		case GENIVI_ENHANCEDPOSITIONSERVICE_LONGITUDE:
			priv->geo.lng=double_variant((*itr).second);
			break;
        case GENIVI_ENHANCEDPOSITIONSERVICE_ALTITUDE:
//			priv->height=double_variant((*itr).second);
			break;
		case GENIVI_ENHANCEDPOSITIONSERVICE_HEADING:
//			priv->direction=double_variant((*itr).second);
			break;
		case GENIVI_ENHANCEDPOSITIONSERVICE_SPEED:
			priv->speed=floor(double_variant((*itr).second)*360+0.5)/100;
			break;
		}
	}
}

static void
vehicle_enhancedposition_callback(struct vehicle_priv *priv)
{
    uint64_t valuesToReturn = (GENIVI_ENHANCEDPOSITIONSERVICE_LATITUDE | GENIVI_ENHANCEDPOSITIONSERVICE_LONGITUDE | GENIVI_ENHANCEDPOSITIONSERVICE_SPEED);
    std::map< uint64_t, ::DBus::Variant > position;
    uint64_t timestamp;
    priv->enhanced_position->GetPositionInfo(valuesToReturn,timestamp,position);
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
	ret->enhanced_position = new EnhancedPosition(*conn,ret);
	ret->cb=callback_new_1(callback_cast(vehicle_enhancedposition_callback), ret);
	ret->cbl=cbl;

	return ret;
}

void plugin_init(void)
{
	event_request_system("glib","genivi_navigationcore_enhpos");
	dispatcher.attach(NULL);
	DBus::default_dispatcher = &dispatcher;
	conn = new DBus::Connection(DBus::Connection::SessionBus());
	conn->setup(&dispatcher);
    dbg(lvl_debug,"enter\n");

	plugin_register_vehicle_type("enhancedposition", vehicle_enhancedposition_new);
}
