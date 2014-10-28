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
#include "navit/config.h"
#define USE_PLUGINS 1
#include "navit/debug.h"
#include "navit/plugin.h"
#include "navit/item.h"
#include "navit/config_.h"
#include "navit/navit.h"
#include "navit/search.h"
#include "navit/callback.h"
#include "navit/event.h"
#include "navit/coord.h"
#include "navit/transform.h"
#include "navit/map.h"
#include "navit/mapset.h"
#include "genivi-poiservice-constants.h"
#include "genivi-poiservice-poicontentaccess_proxy.h"
#include "genivi-poiservice-contentaccessmodule_adaptor.h"

#include <algorithm>

static DBus::Glib::BusDispatcher dispatchers[2];
static DBus::Connection *conns[2];
static const char *cam_name="org.genivi.poiservice.POIContentAccessModuleNavit";

static DBus::Variant
variant_string(std::string s)
{
	DBus::Variant variant;
	DBus::MessageIter iter=variant.writer();
	iter << s;
	return variant;
}

static bool
do_sort_distance(::DBus::Struct< uint32_t, std::string, uint16_t, ::DBus::Struct< double, double, int32_t >, uint16_t, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > a, ::DBus::Struct< uint32_t, std::string, uint16_t, ::DBus::Struct< double, double, int32_t >, uint16_t, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > b)
{
	return a._5 < b._5;
}


class PoiContentAccess
: public org::genivi::poiservice::POIContentAccess_proxy,
  public DBus::ObjectProxy
{
	public:

        PoiContentAccess(DBus::Connection &connection)
        : DBus::ObjectProxy(connection, "/org/genivi/poiservice/POIContentAccess","org.genivi.poiservice.POIContentAccess")
        {
        }

};

class ContentAccessModule
: public org::genivi::poiservice::POIContentAccessModule_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
	private:
		std::vector< uint16_t > m_poiCategoriesId;
		std::vector< ::DBus::Struct< uint32_t, std::string, uint16_t, ::DBus::Struct< double, double, int32_t >, uint16_t, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > > m_resultList;
		int m_max_radius;
		bool (*m_sort_func)(::DBus::Struct< uint32_t, std::string, uint16_t, ::DBus::Struct< double, double, int32_t >, uint16_t, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > a, ::DBus::Struct< uint32_t, std::string, uint16_t, ::DBus::Struct< double, double, int32_t >, uint16_t, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > b);
		struct coord m_center;
		double m_scale;
		struct mapset *m_mapset;
		struct mapset_handle *m_msh;
		struct map *m_map;
		struct map_rect *m_map_rect;
		struct map_selection m_selection;
	public:

        ContentAccessModule(DBus::Connection &connection)
        : DBus::ObjectAdaptor(connection, "/org/genivi/poiservice/POIContentAccessModule")
        {
		m_mapset=NULL;
		m_msh=NULL;
		m_map_rect=NULL;
        }
	
	void
	register_cam(void)
	{
		class PoiContentAccess *pca;
		pca=new PoiContentAccess(*conns[1]);
		int camid=pca->RegisterContentAccessModule(cam_name);
		dbg(0,"camid=%d\n",camid);

		std::vector< ::DBus::Struct< ::DBus::Struct< std::vector< uint16_t >, ::DBus::Variant, std::string, std::string, ::DBus::Variant >, std::vector< ::DBus::Struct< std::string, uint16_t, std::vector< ::DBus::Struct< uint16_t, std::string > > > >, std::vector< ::DBus::Struct< uint16_t, std::string > > > > poiCategories1;
		::DBus::Struct< ::DBus::Struct< std::vector< uint16_t >, ::DBus::Variant, std::string, std::string, ::DBus::Variant >, std::vector< ::DBus::Struct< std::string, uint16_t, std::vector< ::DBus::Struct< uint16_t, std::string > > > >, std::vector< ::DBus::Struct< uint16_t, std::string > > > poiCategory;

		/* poiCategory._1._1 parents_id */;
		poiCategory._1._2=variant_string(""); /* icons */
		poiCategory._1._3="fuel"; /* name */
		/* poiCategory,_1._4 short_desc */
		poiCategory._1._5=variant_string(""); /* media */

		/* poiCategory,_2 attributes */
		/* poiCategory,_3 sortOptions */

		poiCategories1.push_back(poiCategory);
		
		m_poiCategoriesId=pca->AddCategories(camid, poiCategories1);
		for (int i = 0 ; i < m_poiCategoriesId.size(); i++) {
			dbg(0,"Added category id %d\n",m_poiCategoriesId[i]);
		}
		pca->RegisterPoiCategories(camid, m_poiCategoriesId);
		delete(pca);
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
	SetLanguage(const std::string& languageCode, const std::string& countryCode)
	{
	}

	void
	PoiSearchStarted(const uint8_t& poiSearchHandle, const uint16_t& maxSize, const ::DBus::Struct< double, double, int32_t >& location, const std::vector< ::DBus::Struct< uint16_t, uint32_t > >& poiCategories, const std::vector< ::DBus::Struct< std::string, uint16_t, uint16_t, ::DBus::Variant, uint16_t, bool > >& poiAttributes, const std::string& inputString, const uint16_t& sortOption)
	{
		struct attr navit;
		struct coord_geo g;
		dbg(0,"enter handle=%d size=%d location=%f,%f,%d string='%s' sortOption=%d\n",poiSearchHandle, maxSize, location._1,location._2,location._3, inputString.c_str(), sortOption);
		m_resultList.resize(0);
		m_max_radius=0;
		for (int i = 0 ; i < poiCategories.size(); i++) {
			dbg(0,"category %d %d\n",poiCategories[i]._1,poiCategories[i]._2);
			if (m_max_radius < poiCategories[i]._2)
				m_max_radius=poiCategories[i]._2;
		}
		for (int i = 0 ; i < poiAttributes.size(); i++) {
			dbg(0,"attribute %s %d %d %d %d\n",poiAttributes[i]._1.c_str(), poiAttributes[i]._2, poiAttributes[i]._3, poiAttributes[i]._5, poiAttributes[i]._6);
		}
		dbg(0,"max radius %d\n",m_max_radius);
		if (!m_mapset) {
			if (!config_get_attr(config, attr_navit, &navit, NULL)) {
				dbg(0,"failed to get navit\n");
				return;
			}
			m_mapset=navit_get_mapset(navit.u.navit);
		}
		dbg(0,"mapset %p\n",m_mapset);
		g.lat=location._1;
		g.lng=location._2;
		transform_from_geo(projection_mg, &g, &m_center);
		dbg(0,"c 0x%x,0x%x\n",m_center.x,m_center.y);
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
		dbg(0,"rect 0x%x,0x%x-0x%x,0x%x\n",m_selection.u.c_rect.lu.x,m_selection.u.c_rect.lu.y,m_selection.u.c_rect.rl.x,m_selection.u.c_rect.rl.y);
		if (m_msh)
			mapset_close(m_msh);
		m_msh=mapset_open(m_mapset);
		map_next();
		if (sortOption == GENIVI_POISERVICE_SORT_BY_DISTANCE)
			m_sort_func=do_sort_distance;
		else
			m_sort_func=NULL;
	}

	void
	PoiSearchCanceled(const uint8_t& poiSearchHandle)
	{
		dbg(0,"enter\n");
	}
		
	void
	add_poi(struct item *item)
	{
		struct attr label;
		struct coord c;
		dbg(0,"adding poi\n");
		::DBus::Struct< uint32_t, std::string, uint16_t, ::DBus::Struct< double, double, int32_t >, uint16_t, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > result;
		result._1=m_resultList.size(); /* source_id */
		if (item_attr_get(item, attr_label, &label))
			result._2=std::string(label.u.str); /* name */
		else
			result._2=std::string(""); /* name */
		result._3=m_poiCategoriesId[0]; /* category */
		if (item_coord_get(item, &c, 1)) {
			struct coord_geo g;
			transform_to_geo(projection_mg, &c, &g);
			result._4._1=g.lat; /* lat */
			result._4._2=g.lng; /* lon */
			double distance=transform_distance(projection_mg, &m_center, &c)/m_scale;
#if 0
			if (distance > m_max_radius)
				return;
#endif
			result._5=distance; /* distance */
		} else {
			result._4._1=0; /* lat */
			result._4._2=0; /* lon */
			result._5=0; /* distance */
		}
		result._4._3=0; /* altitude */
		/* result._6 attributes */
		result._7=variant_string(std::string("")); /* value */
		m_resultList.push_back(result);
	}

	void
	ResultListRequested(const uint8_t& camId, const uint8_t& poiSearchHandle, const std::vector< std::string >& attributes, uint16_t& statusValue, uint16_t& resultListSize, std::vector< ::DBus::Struct< uint32_t, std::string, uint16_t, ::DBus::Struct< double, double, int32_t >, uint16_t, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > >& resultList)
	{
		struct item *item;
		int count=0;
		dbg(0,"enter camId=%d handle=%d\n", camId, poiSearchHandle);
		while (resultList.size() < 256 && m_map_rect) {
			while (resultList.size() < 256 && (item=map_rect_get_item(m_map_rect))) {
				if (item->type == type_poi_fuel)
					add_poi(item);
				count++;
			}
			map_next();
		}
		dbg(0,"got %d items\n",count);
		statusValue=GENIVI_POISERVICE_FINISHED;
		if (m_sort_func) 
			std::sort(m_resultList.begin(), m_resultList.end(), m_sort_func);
		resultList=m_resultList;
		resultListSize=resultList.size();
	}

	std::vector< ::DBus::Struct< ::DBus::Struct< uint32_t, std::string, double, double, int32_t >, std::vector< uint16_t >, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > >
	PoiDetailsRequested(const std::vector< uint32_t >& source_id)
	{
		dbg(0,"enter\n");
		std::vector< ::DBus::Struct< ::DBus::Struct< uint32_t, std::string, double, double, int32_t >, std::vector< uint16_t >, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > > ret;
		for (int i = 0 ; i < source_id.size() ; i++) {
			int sid=source_id[i];
			::DBus::Struct< ::DBus::Struct< uint32_t, std::string, double, double, int32_t >, std::vector< uint16_t >, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > result;
			result._1._1=sid; /* source id */
			result._1._2=m_resultList[sid]._2; /* name */
			result._1._3=m_resultList[sid]._4._1; /* lat */
			result._1._4=m_resultList[sid]._4._2; /* lon */
			result._1._5=0; /* alt */
			result._2.push_back(m_poiCategoriesId[0]);
			ret.push_back(result);
		}
		return ret;
	}
};


static class ContentAccessModule *server;

void
plugin_init(void)
{
	dbg(0,"enter\n");
        event_request_system("glib","genivi_poiservice");
        int i;
        for (i = 0 ; i < 2 ; i++) {
                conns[i] = new DBus::Connection(DBus::Connection::SessionBus());
                dispatchers[i].attach(NULL);
                DBus::default_dispatcher = &dispatchers[i];
                conns[i]->setup(&dispatchers[i]);
        }
        conns[0]->request_name(cam_name);
        server=new ContentAccessModule(*conns[0]);
	try {
		server->register_cam();
	} catch(...) {
		dbg(0,"Exception during register_cam\n");
	}
}
