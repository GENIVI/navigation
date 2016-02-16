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
#include "navigation-common-dbus.h"

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

enum {
    POI_CONTENTACCESSMODULE_CONNECTION=0,
    POI_CONTENTACCESS_CONNECTION,
    CONNECTION_AMOUNT
};

#include "genivi-poiservice-constants.h"
#include "genivi-poiservice-poicontentaccess_proxy.h"
#include "genivi-poiservice-contentaccessmodule_adaptor.h"

#include <algorithm>

static DBus::Glib::BusDispatcher dispatchers[CONNECTION_AMOUNT];
static DBus::Connection *conns[CONNECTION_AMOUNT];
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
do_sort_distance(::DBus::Struct< uint32_t, std::string, uint32_t, ::DBus::Struct< double, double, double >, uint16_t, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > > a, ::DBus::Struct< uint32_t, std::string, uint32_t, ::DBus::Struct< double, double, double >, uint16_t, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > > b)
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
        std::vector< uint32_t > m_poiCategoriesId;
        std::vector< ::DBus::Struct< uint32_t, std::string, uint32_t, ::DBus::Struct< double, double, double >, uint16_t, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > > > m_resultList;
        int m_max_radius;
        bool (*m_sort_func)(::DBus::Struct< uint32_t, std::string, uint32_t, ::DBus::Struct< double, double, double >, uint16_t, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > > a, ::DBus::Struct< uint32_t, std::string, uint32_t, ::DBus::Struct< double, double, double >, uint16_t, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > > b);
		struct coord m_center;
		double m_scale;
		struct mapset *m_mapset;
		struct mapset_handle *m_msh;
		struct map *m_map;
		struct map_rect *m_map_rect;
		struct map_selection m_selection;
        std::string m_languageCode,m_countryCode,m_scriptCode;

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
        pca=new PoiContentAccess(*conns[POI_CONTENTACCESS_CONNECTION]);
		int camid=pca->RegisterContentAccessModule(cam_name);
		dbg(lvl_debug,"camid=%d\n",camid);

        std::vector< ::DBus::Struct< ::DBus::Struct< std::vector< uint32_t >, DBusCommonAPIVariant, std::string, std::string, DBusCommonAPIVariant >, std::vector< ::DBus::Struct< uint32_t, std::string, int32_t, std::vector< ::DBus::Struct< int32_t, std::string, DBusCommonAPIVariant > > > >, std::vector< ::DBus::Struct< uint32_t, std::string > > > > poiCategories1;
        ::DBus::Struct< ::DBus::Struct< std::vector< uint32_t >, DBusCommonAPIVariant, std::string, std::string, DBusCommonAPIVariant >, std::vector< ::DBus::Struct< uint32_t, std::string, int32_t, std::vector< ::DBus::Struct< int32_t, std::string, DBusCommonAPIVariant > > > >, std::vector< ::DBus::Struct< uint32_t, std::string > > > poiCategory;
		/* poiCategory._1._1 parents_id */;
        poiCategory._1._2._2=variant_string(""); /* icons */
		poiCategory._1._3="fuel"; /* name */
		/* poiCategory,_1._4 short_desc */
        poiCategory._1._5._2=variant_string(""); /* media */

		/* poiCategory,_2 attributes */
		/* poiCategory,_3 sortOptions */

		poiCategories1.push_back(poiCategory);
		
		m_poiCategoriesId=pca->AddCategories(camid, poiCategories1);
		for (int i = 0 ; i < m_poiCategoriesId.size(); i++) {
			dbg(lvl_debug,"Added category id %d\n",m_poiCategoriesId[i]);
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

    void
    add_poi(struct item *item)
    {
        struct attr label;
        struct coord c;
        dbg(lvl_debug,"adding poi\n");
        ::DBus::Struct< uint32_t, std::string, uint32_t, ::DBus::Struct< double, double, double >, uint16_t, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > >  result;
        ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > attribute;

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
        attribute._1 = 0;
        attribute._2 = 0;
        attribute._3._1 = 0;
        attribute._3._2 = variant_string(std::string("")); /* value */
        result._6.push_back(attribute);
        m_resultList.push_back(result);
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
    SetLocale(const std::string& languageCode, const std::string& countryCode, const std::string &scriptCode)
        {
            m_languageCode = languageCode;
            m_countryCode = countryCode;
            m_scriptCode = scriptCode;
        }

    void
    GetLocale(std::string& languageCode, std::string& countryCode, std::string& scriptCode)
    {
        languageCode = m_languageCode;
        countryCode = m_countryCode;
        scriptCode = m_scriptCode;
    }

    std::vector< ::DBus::Struct< std::string, std::string , std::string> >
    GetSupportedLocales()
    {
        std::vector< ::DBus::Struct< std::string, std::string, std::string > > ret;
        ::DBus::Struct< std::string, std::string, std::string > en_US { "eng","USA", "Latn" };
        ::DBus::Struct< std::string, std::string, std::string > fr_FR { "fra","FRA", "Latn" };
        ret.push_back(en_US);
        ret.push_back(fr_FR);
        return ret;
    }

    std::vector< ::DBus::Struct< uint32_t, std::string, bool > >
    GetAvailableCategories()
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    uint32_t
    GetRootCategory()
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    std::vector< ::DBus::Struct< uint32_t, bool > >
    GetChildrenCategories(const uint32_t& category)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    std::vector< ::DBus::Struct< uint32_t, bool > >
    GetParentCategories(const uint32_t& category)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    uint32_t
    createCategory(const ::DBus::Struct< ::DBus::Struct< std::vector< uint32_t >, DBusCommonAPIVariant, std::string, std::string, DBusCommonAPIVariant >, std::vector< ::DBus::Struct< uint32_t, std::string, int32_t, std::vector< ::DBus::Struct< int32_t, std::string, DBusCommonAPIVariant > > > >, std::vector< ::DBus::Struct< uint32_t, std::string > > >& category)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    void
    removeCategories(const std::vector< uint32_t >& categories)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    void
    addPOIs(const uint32_t& unique_id, const std::vector< ::DBus::Struct< std::string, ::DBus::Struct< double, double, double >, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > > >& poiList)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    void
    removePOIs(const std::vector< uint32_t >& ids)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    void
    PoiSearchStarted(const uint32_t& poiSearchHandle, const uint16_t& maxSize, const ::DBus::Struct< double, double, double >& location, const std::vector< ::DBus::Struct< uint32_t, uint32_t > >& poiCategories, const std::vector< ::DBus::Struct< uint32_t, uint32_t, int32_t, DBusCommonAPIVariant, int32_t, bool > >& poiAttributes, const std::string& inputString, const int32_t& sortOption)
    {
		struct attr navit;
		struct coord_geo g;
		dbg(lvl_debug,"enter handle=%d size=%d location=%f,%f,%d string='%s' sortOption=%d\n",poiSearchHandle, maxSize, location._1,location._2,location._3, inputString.c_str(), sortOption);
		m_resultList.resize(0);
		m_max_radius=0;
		for (int i = 0 ; i < poiCategories.size(); i++) {
			dbg(lvl_debug,"category %d %d\n",poiCategories[i]._1,poiCategories[i]._2);
			if (m_max_radius < poiCategories[i]._2)
				m_max_radius=poiCategories[i]._2;
		}
		for (int i = 0 ; i < poiAttributes.size(); i++) {
            dbg(lvl_debug,"attribute %d %d %d %d %d\n",poiAttributes[i]._1, poiAttributes[i]._2, poiAttributes[i]._3, poiAttributes[i]._5, poiAttributes[i]._6);
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
		g.lat=location._1;
		g.lng=location._2;
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
		if (sortOption == GENIVI_POISERVICE_SORT_BY_DISTANCE)
			m_sort_func=do_sort_distance;
		else
			m_sort_func=NULL;
	}

    void
    PoiSearchCanceled(const uint32_t& poiSearchHandle)
	{
		dbg(lvl_debug,"enter\n");
	}

    void
    ResultListRequested(const uint8_t& camId, const uint32_t& poiSearchHandle, const std::vector< uint32_t >& attributeList, int32_t& statusValue, uint16_t& resultListSize, std::vector< ::DBus::Struct< uint32_t, std::string, uint32_t, ::DBus::Struct< double, double, double >, uint16_t, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > > >& resultList)
	{
		struct item *item;
		int count=0;
		dbg(lvl_debug,"enter camId=%d handle=%d\n", camId, poiSearchHandle);
		while (resultList.size() < 256 && m_map_rect) {
			while (resultList.size() < 256 && (item=map_rect_get_item(m_map_rect))) {
				if (item->type == type_poi_fuel)
					add_poi(item);
				count++;
			}
			map_next();
		}
		dbg(lvl_debug,"got %d items\n",count);
		statusValue=GENIVI_POISERVICE_FINISHED;
		if (m_sort_func) 
			std::sort(m_resultList.begin(), m_resultList.end(), m_sort_func);
		resultList=m_resultList;
		resultListSize=resultList.size();
	}

    std::vector< ::DBus::Struct< ::DBus::Struct< uint32_t, std::string, ::DBus::Struct< double, double, double > >, std::vector< uint32_t >, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > > >
	PoiDetailsRequested(const std::vector< uint32_t >& source_id)
	{
		dbg(lvl_debug,"enter\n");
        std::vector< ::DBus::Struct< ::DBus::Struct< uint32_t, std::string, ::DBus::Struct< double, double, double > >, std::vector< uint32_t >, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > > > ret;
		for (int i = 0 ; i < source_id.size() ; i++) {
			int sid=source_id[i];
            ::DBus::Struct< ::DBus::Struct< uint32_t, std::string, ::DBus::Struct< double, double, double > >, std::vector< uint32_t >, std::vector< ::DBus::Struct< uint32_t, int32_t, DBusCommonAPIVariant > > > result;
			result._1._1=sid; /* source id */
			result._1._2=m_resultList[sid]._2; /* name */
            result._1._3._1=m_resultList[sid]._4._1; /* lat */
            result._1._3._2=m_resultList[sid]._4._2; /* lon */
            result._1._3._3=0; /* alt */
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
	dbg(lvl_debug,"enter\n");
    event_request_system("glib","genivi_poiservice");
    int i;
    for (i = 0 ; i < CONNECTION_AMOUNT ; i++) {
        // init the dispatcher
        DBus::default_dispatcher = &dispatchers[i];
        dispatchers[i].attach(NULL);
        // create a connection on the session bus and connect the dispatcher
        conns[i] = new DBus::Connection(DBus::Connection::SessionBus());
        conns[i]->setup(&dispatchers[i]);
    }
    conns[POI_CONTENTACCESSMODULE_CONNECTION]->request_name(cam_name);
    server=new ContentAccessModule(*conns[POI_CONTENTACCESSMODULE_CONNECTION]);
	try {
		server->register_cam();
	} catch(...) {
		dbg(lvl_debug,"Exception during register_cam\n");
	}
}
