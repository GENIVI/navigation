/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_mapviewer_mapviewercontrol.cxx
*
* \brief This file is part of the Navit POC.
*
* \author Martin Schaller <martin.schaller@it-schaller.de>
* \author Philippe Colliot <philippe.colliot@mpsa.com>
* \author Tanibata, Nobuhiko <NOBUHIKO_TANIBATA@denso.co.jp>
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
* @licence end@
*/
#ifndef DBUS_HAS_RECURSIVE_MUTEX
#define DBUS_HAS_RECURSIVE_MUTEX
#endif
#include <dbus-c++/glib-integration.h>
#include <math.h>
#include <unistd.h>
#include <stdlib.h>

#if LM
#include <ilm/ilm_client.h>
#include <ilm/ilm_control.h>
//Align with Qt Surfaces = 8000 + Layer.
#ifndef FSA_SURFACE
#define SURFACE_OFFSET 8000
#define FSA_SURFACE SURFACE_OFFSET + getpid()
#endif
#endif

#include "genivi-mapviewer-mapviewercontrol_adaptor.h"
#include "genivi-navigationcore-routing_proxy.h"
#include "genivi-navigationcore-session_proxy.h"
#include "genivi-navigationcore-mapmatchedposition_proxy.h"
#include "genivi-navigationcore-constants.h"
#include "genivi-mapviewer-constants.h"
#include <config.h>
#define USE_PLUGINS 1
#include <navit/debug.h>
#include <navit/plugin.h>
#include <navit/item.h>
#include <navit/config_.h>
#include <navit/navit.h>
#include <navit/event.h>
#include <navit/point.h>
#include <navit/graphics.h>
#include <navit/coord.h>
#include <navit/transform.h>
#include <navit/map.h>
#include <navit/mapset.h>
#include <navit/callback.h>
#include <navit/vehicle.h>
#include <navit/attr.h>
#include <navit/xmlconfig.h>
#include <navit/layout.h>

#include "navigation-common-dbus.h"

#include "log.h"

DLT_DECLARE_CONTEXT(gCtx);

enum {
    MAPVIEWER_CONTROL_CONNECTION=0,
    NAVIGATIONCORE_SESSION_CONNECTION,
    NAVIGATIONCORE_ROUTING_CONNECTION,
    NAVIGATIONCORE_MAPMATCHEDPOSITION_CONNECTION,
    CONNECTION_AMOUNT
};

#define ZOOM_ZERO_METER_WIDTH 33250 //width in millimeter of the real area for the minimum zoom
#define ZOOM_ZERO_METER_HEIGHT 21970 //height in millimeter of the real area for the minimum zoom

static DBus::Glib::BusDispatcher dispatchers[CONNECTION_AMOUNT];
static DBus::Connection *conns[CONNECTION_AMOUNT];
static uint32_t navigationcore_session=-1;

static double double_variant(DBus::Variant variant);
class MapViewerControl;
class MapMatchedPosition;
class Routing;

class DisplayedRoute
{
	char *m_filename;
	std::vector <struct coord> m_coordinates;
	struct mapset *m_mapset;
	bool m_shown;

	void AddGeoCoordinateD(double lat, double lon);
	void AddGeoCoordinate(DBus::Variant lat, DBus::Variant lon);
    bool AddSegment(std::map<DBusCommonAPIEnumeration, DBusCommonAPIVariant> map);
	void WriteSegment(FILE *out);
	public:
	uint32_t m_handle;
	struct attr m_map;
    uint32_t RouteHandle();
	void Show();
	void Hide();
    DisplayedRoute(class MapViewerControlObj *mapviewer, uint8_t RouteSession, uint32_t RouteHandle, struct mapset *mapset);
	~DisplayedRoute();
};

class MapViewerControlObj
{
	public:
	struct attr m_navit,m_vehicle,m_graphics;
	struct mapset *m_mapset;
	uint32_t m_handle;
	double m_scrolldirection, m_scrollspeed;
    double m_rotationangle, m_rotationanglepersecond;

	struct callback *m_postdraw_callback;
	struct callback *m_move_callback;
	bool m_force_draw;
	uint16_t m_perspective;
	bool m_follow_car;
	MapViewerControl *m_mapviewercontrol;
	std::vector<DisplayedRoute *> m_displayed_routes;
	MapMatchedPosition *m_mapmatchedposition;
	Routing *m_routing;
	struct point m_pan;
	int m_pan_action;
    uint16_t m_width;
    uint16_t m_height;

	void MoveMap(void);
    void SetFollowCarMode(uint32_t SessionHandle, bool active);
    void GetFollowCarMode(bool& active);
    void SetCameraHeadingAngle(uint32_t sessionHandle, int32_t angle);
    void GetCameraHeading(DBusCommonAPIEnumeration& headingType, int32_t& headingAngle, ::DBus::Struct< double, double >& target);
    void SetCameraTiltAngle(uint32_t sessionHandle, double angle);
    void GetCameraTiltAngle(double &angle);
    void SetCameraRollAngle(uint32_t sessionHandle, double angle);
    void GetCameraRollAngle(double &angle);
    void SetCameraDistanceFromTargetPoint(uint32_t sessionHandle, double distance);
    void GetCameraDistanceFromTargetPoint(double &distance);
    void SetCameraHeight(uint32_t sessionHandle, double height);
    void GetCameraHeight(double &height);
    void SetCameraHeadingTrackUp(uint32_t sessionHandle);
    void SetMapViewPerspective(uint32_t SessionHandle, uint16_t MapViewPerspectiveMode);
    void GetMapViewPerspective(uint16_t &MapViewPerspectiveMode);
    void GetScaleList(std::vector< ::DBus::Struct< uint8_t, uint16_t, DBusCommonAPIEnumeration, uint32_t > >& ScalesList);
    void SetMapViewScale(uint32_t SessionHandle, uint8_t ScaleID);
    void SetMapViewScaleByDelta(uint32_t SessionHandle, int16_t ScaleDelta);
    void GetMapViewScale(uint8_t& ScaleID, DBusCommonAPIEnumeration &IsMinMax);
    void GetMapViewType(uint16_t& MapViewType);
    void SetMapViewTheme(uint32_t sessionHandle, uint16_t mapViewTheme);
    void GetMapViewTheme(uint16_t& mapViewTheme);
    void SetTargetPoint(uint32_t SessionHandle, ::DBus::Struct<double, double, double> target);
    void GetTargetPoint(::DBus::Struct<double, double, double> &target);
    bool SetMapViewPan(uint32_t SessionHandle, int32_t panningAction, ::DBus::Struct< uint16_t, uint16_t >p);
    void GetMapViewPan(const int32_t &panningAction, ::DBus::Struct< uint16_t, uint16_t > &p);
    bool SetMapViewRotation(uint32_t sessionHandle, double rotationAngle, double rotationAnglePerSecond);
    void GetMapViewRotation(int32_t& rotationAngle, int32_t& rotationAnglePerSecond);
    bool SetMapViewBoundingBox(uint32_t sessionHandle, const ::DBus::Struct< ::DBus::Struct< double, double >, ::DBus::Struct< double, double > >& boundingBox);
    void GetMapViewBoundingBox(::DBus::Struct< ::DBus::Struct< double, double >, ::DBus::Struct< double, double > >& boundingBox);
    void GetDisplayedRoutes(std::vector< ::DBus::Struct< uint32_t, bool > >& displayedRoutes);
    void DisplayRoute(uint32_t SessionHandle, uint32_t RouteHandle, bool highlighted);
    void HideRoute(uint32_t SessionHandle, uint32_t RouteHandle);
    void ConvertPixelCoordsToGeoCoords(uint32_t sessionHandle, const std::vector< ::DBus::Struct< uint16_t, uint16_t > >& pixelCoordinates, std::vector< ::DBus::Struct< double, double > >& GeoCoordinates);
    void ConvertGeoCoordsToPixelCoords(uint32_t sessionHandle, const std::vector< ::DBus::Struct< double, double > >& geoCoordinates, std::vector< ::DBus::Struct< uint16_t, uint16_t > >& pixelCoordinates);
    MapViewerControlObj(MapViewerControl *mapviewercontrol, uint32_t handle, const ::DBus::Struct< uint16_t, uint16_t >& MapViewSize);
	~MapViewerControlObj();
};


static std::map<uint32_t, MapViewerControlObj *> handles;


class Routing
: public org::genivi::navigation::navigationcore::Routing_proxy,
  public DBus::ObjectProxy
{
	public:
	MapViewerControlObj *m_mapviewerobj;
	Routing(DBus::Connection &connection, MapViewerControlObj *obj)
	: DBus::ObjectProxy(connection, "/org/genivi/navigationcore","org.genivi.navigation.navigationcore.Routing")
	{
		m_mapviewerobj=obj;
        LOG_INFO_MSG(gCtx,"routing client created");
    }

    ~Routing()
    {
        LOG_INFO_MSG(gCtx,"routing client deleted");
    }

    void RouteDeleted(const uint32_t& routeHandle)
	{
	}

    void RouteCalculationCancelled(const uint32_t& routeHandle)
	{
	}

    void RouteCalculationFailed(const uint32_t& routeHandle, const DBusCommonAPIEnumeration& errorCode, const std::map< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration >& unfullfilledPreferences)
	{
		std::vector<DisplayedRoute *>::iterator it;

		for (it=m_mapviewerobj->m_displayed_routes.begin() ; it < m_mapviewerobj->m_displayed_routes.end(); it++ ) {
			if (*it && (*it)->m_handle == routeHandle) {
				(*it)->Hide();
			}
		}
	}

    void RouteCalculationSuccessful(const uint32_t& RouteHandle, const std::map< DBusCommonAPIEnumeration, DBusCommonAPIEnumeration >& unfullfilledPreferences)
	{
        std::vector<DisplayedRoute *>::iterator it;

		for (it=m_mapviewerobj->m_displayed_routes.begin() ; it < m_mapviewerobj->m_displayed_routes.end(); it++ ) {
			if (*it && (*it)->m_handle == RouteHandle) {
				(*it)->Hide();
				delete(*it);
				*it=new DisplayedRoute(m_mapviewerobj,1,RouteHandle,m_mapviewerobj->m_mapset);
				(*it)->Show();
			}
		}
	}

    void RouteCalculationProgressUpdate(const uint32_t& routeHandle, const DBusCommonAPIEnumeration& status, const uint8_t& percentage)
	{
	}	

     void AlternativeRoutesAvailable(const std::vector< uint32_t >& routeHandlesList)
     {

     }
};

class  NavigationCoreSession
: public org::genivi::navigation::navigationcore::Session_proxy,
  public DBus::ObjectProxy
{
	public:
	NavigationCoreSession(DBus::Connection &connection)
	: DBus::ObjectProxy(connection, "/org/genivi/navigationcore","org.genivi.navigation.navigationcore.Session")
	{
        LOG_INFO_MSG(gCtx,"session client created");
    }
    void SessionDeleted(const uint32_t& sessionHandle)
	{
	}
};

static void position_update(MapMatchedPosition *pos, struct vehicle *v);

class  MapMatchedPosition
: public org::genivi::navigation::navigationcore::MapMatchedPosition_proxy,
  public DBus::ObjectProxy
{
	public:
    struct callback *m_position_callback;
	MapViewerControlObj *m_mapviewerobj;
	MapMatchedPosition(DBus::Connection &connection, struct vehicle *v)
	: DBus::ObjectProxy(connection, "/org/genivi/navigationcore","org.genivi.navigation.navigationcore.MapMatchedPosition")
	{	
        m_position_callback=callback_new_2(callback_cast(position_update), this, v);
        LOG_INFO_MSG(gCtx,"map matched position client created");
    }

    ~MapMatchedPosition()
    {
        callback_destroy(m_position_callback);
        LOG_DEBUG_MSG(gCtx,"map matched position client deleted");
    }

    void PositionUpdate(const std::vector< DBusCommonAPIEnumeration >& changedValues)
	{
        event_add_timeout(0, 0, m_position_callback);
	}

    void AddressUpdate(const std::vector< DBusCommonAPIEnumeration >& changedValues)
	{
	}

    void PositionOnSegmentUpdate(const std::vector< DBusCommonAPIEnumeration >& changedValues)
	{
	}

    void StatusUpdate(const std::vector< DBusCommonAPIEnumeration >& changedValues)
	{
	}

	void
    SimulationStatusChanged(const DBusCommonAPIEnumeration& simulationStatus)
	{
	}

	void
	OffRoadPositionChanged(const uint32_t& distance, const int32_t& direction)
	{
	}

	void
	SimulationSpeedChanged(const uint8_t& speedFactor)
	{
	}
};

static void
position_update(MapMatchedPosition *pos, struct vehicle *v)
{
    std::vector< DBusCommonAPIEnumeration > valuesToReturn;

	valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_LATITUDE);
	valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_LONGITUDE);
	valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_SPEED);
	valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_HEADING);

    int32_t error;
    std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant> map;
    pos->GetPosition(valuesToReturn,error,map);
	if (map.find(GENIVI_NAVIGATIONCORE_SPEED) != map.end()) {
		struct attr position_speed={attr_position_speed};
		double speed;
		position_speed.u.numd=&speed;
        speed=double_variant(map[GENIVI_NAVIGATIONCORE_SPEED]._2);
		vehicle_set_attr(v, &position_speed);
	}
	if (map.find(GENIVI_NAVIGATIONCORE_HEADING) != map.end()) {
		struct attr position_direction={attr_position_direction};
		double direction;
		position_direction.u.numd=&direction;
        direction=double_variant(map[GENIVI_NAVIGATIONCORE_HEADING]._2);
		vehicle_set_attr(v, &position_direction);
	}
	if (map.find(GENIVI_NAVIGATIONCORE_LATITUDE) != map.end() && map.find(GENIVI_NAVIGATIONCORE_LONGITUDE) != map.end()) {
		struct attr position_coord_geo={attr_position_coord_geo};
		struct coord_geo g;
		position_coord_geo.u.coord_geo=&g;
        g.lat=double_variant(map[GENIVI_NAVIGATIONCORE_LATITUDE]._2);
        g.lng=double_variant(map[GENIVI_NAVIGATIONCORE_LONGITUDE]._2);
        LOG_DEBUG(gCtx,"update %f %f",g.lat,g.lng);
		vehicle_set_attr(v, &position_coord_geo);
	}
}

class  MapViewerControl
: public org::genivi::navigation::mapviewer::MapViewerControl_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
	public:
	MapViewerControl(DBus::Connection &connection)
	: DBus::ObjectAdaptor(connection, "/org/genivi/mapviewer")
	{
        LOG_INFO_MSG(gCtx,"map viewer control server");
    }

    void
    CreateMapViewInstance(const uint32_t& sessionHandle, const ::DBus::Struct< uint16_t, uint16_t >& mapViewSize, const DBusCommonAPIEnumeration& mapViewType, int32_t& error, uint32_t& mapViewInstanceHandle)
	{
        error=0; //not used
        mapViewInstanceHandle=0;
        if (mapViewType != GENIVI_MAPVIEWER_MAIN_MAP) {
            throw DBus::ErrorInvalidArgs("Unsupported mapViewType");
        } else {
            mapViewInstanceHandle=1;
            while (handles[mapViewInstanceHandle]) {
                mapViewInstanceHandle++;
                if (mapViewInstanceHandle == 256)
                                    throw DBus::ErrorLimitsExceeded("Out of mapviewinstance handles");
                    }
            handles[mapViewInstanceHandle]=new MapViewerControlObj(this, mapViewInstanceHandle, mapViewSize);
            LOG_INFO(gCtx,"Create map view instance, handle= %d",mapViewInstanceHandle);
        }
    }

    int32_t
    ReleaseMapViewInstance(const uint32_t& SessionHandle, const uint32_t& MapViewInstanceHandle)
    {
        std::map<uint32_t, MapViewerControlObj *>::iterator iter = handles.find(MapViewInstanceHandle);
        if (iter != handles.end())
        {
            MapViewerControlObj *obj=handles[MapViewInstanceHandle];
            delete(obj); //delete the navit mapviewer instance
            //and remove the handle from the dictionary too
            handles.erase(iter);
            LOG_INFO(gCtx,"Release map view instance, handle= %d",MapViewInstanceHandle);
            return(0);
	}
        else {
            return(1);
        }
    }

    void
    SetMapViewPerspective(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const DBusCommonAPIEnumeration& perspective)
	{
        MapViewerControlObj *obj=handles[mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else{
            obj->SetMapViewPerspective(sessionHandle, perspective);
            MapViewPerspectiveChanged(mapViewInstanceHandle,perspective);
        }
	}

    DBusCommonAPIEnumeration
    GetMapViewPerspective(const uint32_t& mapViewInstanceHandle)
	{
                uint16_t MapViewPerspectiveMode=0;
        MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewPerspective(MapViewPerspectiveMode);
		return MapViewPerspectiveMode;
	}

    std::vector< DBusCommonAPIEnumeration >
    GetSupportedMapViewPerspectives()
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    void
    SetMapViewScale(const uint32_t& SessionHandle, const uint32_t& MapViewInstanceHandle, const uint8_t& ScaleID)
    {
        MapViewerControlObj *obj=handles[MapViewInstanceHandle];
        if (!obj)
                throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else {
            obj->SetMapViewScale(SessionHandle, ScaleID);
            uint8_t current_scale;
            DBusCommonAPIEnumeration is_min_max;
            obj->GetMapViewScale(current_scale,is_min_max);
            MapViewScaleChanged(MapViewInstanceHandle,current_scale,is_min_max);
        }
    }

    void
    SetMapViewScaleByDelta(const uint32_t& SessionHandle, const uint32_t& MapViewInstanceHandle, const int16_t& ScaleDelta)
    {
        MapViewerControlObj *obj=handles[MapViewInstanceHandle];
        if (!obj)
                throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else {
            obj->SetMapViewScaleByDelta(SessionHandle, ScaleDelta);
            uint8_t current_scale;
            DBusCommonAPIEnumeration is_min_max;
            obj->GetMapViewScale(current_scale,is_min_max);
            MapViewScaleChanged(MapViewInstanceHandle,current_scale,is_min_max);
        }
    }

	void
    GetMapViewScale(const uint32_t& MapViewInstanceHandle, uint8_t& ScaleID, DBusCommonAPIEnumeration& IsMinMax)
	{
		MapViewerControlObj *obj=handles[MapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewScale(ScaleID, IsMinMax);
	}

    void
    SetMapViewPan(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const DBusCommonAPIEnumeration& panningAction, const ::DBus::Struct< uint16_t, uint16_t >& pixelCoordinates)
    {
        MapViewerControlObj *obj=handles[mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else {
            if(!obj->SetMapViewPan(sessionHandle, panningAction, pixelCoordinates))
              throw DBus::ErrorInvalidArgs("Not allowed if follow car mode is active");
        }
    }

    ::DBus::Struct< uint16_t, uint16_t >
    GetMapViewPan(const uint32_t& mapViewInstanceHandle, const int32_t& valueToReturn)
    {
        ::DBus::Struct< uint16_t, uint16_t > pixelCoordinates;
        MapViewerControlObj *obj=handles[mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewPan(valueToReturn, pixelCoordinates); //limited to one pixel coordinate
        return pixelCoordinates;
    }

	void
    DisplayRoute(const uint32_t& SessionHandle, const uint32_t& MapViewInstanceHandle, const uint32_t& RouteHandle, const bool& highlighted)
	{
		MapViewerControlObj *obj=handles[MapViewInstanceHandle];
        std::vector< ::DBus::Struct< uint32_t, bool > > displayedRoutes;
        ::DBus::Struct< uint32_t, bool > route;
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else{
            obj->DisplayRoute(SessionHandle, RouteHandle, highlighted);
            route._1 = RouteHandle;
            route._2 = highlighted;
            displayedRoutes.push_back(route);
            DisplayedRoutes(MapViewInstanceHandle,displayedRoutes);
        }
	}

	void	
    HideRoute(const uint32_t& SessionHandle, const uint32_t& MapViewInstanceHandle, const uint32_t& RouteHandle)
	{
		MapViewerControlObj *obj=handles[MapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
                else obj->HideRoute(SessionHandle, RouteHandle);
	}

	::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string >
	GetVersion()
	{
		::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string >ret;
		ret._1=3;
		ret._2=0;
		ret._3=0;
		ret._4="07-06-2013";
		return ret;
	}

    DBusCommonAPIEnumeration
    GetMapViewType(const uint32_t& mapViewInstanceHandle)
	{
                uint16_t ret=0;
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewType(ret);
		return ret;
	}

    std::vector< DBusCommonAPIEnumeration >
    GetSupportedMapViewTypes()
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

	void
    SetTargetPoint(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< double, double, double >& targetPoint)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
                else obj->SetTargetPoint(sessionHandle, targetPoint);
	}

    ::DBus::Struct< double, double, double >
    GetTargetPoint(const uint32_t& mapViewInstanceHandle)
	{
        ::DBus::Struct< double, double, double > ret;
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetTargetPoint(ret);
		return ret;
	}

	void
    SetFollowCarMode(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const bool& followCarMode)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
                else obj->SetFollowCarMode(sessionHandle, followCarMode);
	}

	bool
    GetFollowCarMode(const uint32_t& mapViewInstanceHandle)
	{
                bool followCarMode=false;
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetFollowCarMode(followCarMode);
		return followCarMode;
	}

	void
    SetCameraPosition(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< double, double, double >& position)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    ::DBus::Struct< double, double, double >
    GetCameraPosition(const uint32_t& mapViewInstanceHandle)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
    SetCameraHeadingAngle(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const int32_t& heading)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
                else obj->SetCameraHeadingAngle(sessionHandle, heading);
	}

	void
    SetCameraHeadingToTarget(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< double, double >& target)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
    SetCameraTiltAngle(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const int32_t& tilt)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
        if (!obj){
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        }else{
            obj->SetCameraTiltAngle(sessionHandle, tilt);
            CameraTiltAngleChanged(mapViewInstanceHandle,tilt);
        }
	}

	int32_t
    GetCameraTiltAngle(const uint32_t& mapViewInstanceHandle)
	{
                double ret=0;
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetCameraTiltAngle(ret);
		return ret;
	}

	void
	SetCameraRollAngle(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const int32_t& roll)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
                else obj->SetCameraRollAngle(sessionHandle, roll);
	}

	int32_t
    GetCameraRollAngle(const uint32_t& mapViewInstanceHandle)
	{
		double ret;
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        obj->GetCameraRollAngle(ret);
		return ret;
	}

    void
    SetCameraDistanceFromTargetPoint(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const uint32_t& distance)
    {
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
        if (!obj){
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        }else{
            obj->SetCameraDistanceFromTargetPoint(sessionHandle, distance);
            CameraDistanceFromTargetPointChanged(mapViewInstanceHandle,distance);
        }
	}


    uint32_t
    GetCameraDistanceFromTargetPoint(const uint32_t& mapViewInstanceHandle)
    {
        double ret=0;
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetCameraDistanceFromTargetPoint(ret);
		return ret;
	}

    void
    SetMapViewScaleMode(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const DBusCommonAPIEnumeration& scaleMode)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    DBusCommonAPIEnumeration
    GetMapViewScaleMode(const uint32_t& mapViewInstanceHandle)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    std::vector< DBusCommonAPIEnumeration >
    GetSupportedMapViewScaleModes(const uint32_t& mapViewInstanceHandle)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

	void
	SetCameraHeight(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const uint32_t& height)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
        if (!obj){
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        }else{
            obj->SetCameraHeight(sessionHandle, height);
        }
	}

	uint32_t
    GetCameraHeight(const uint32_t& mapViewInstanceHandle)
	{
                double ret=0;
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetCameraHeight(ret);
		return ret;
	}

    std::vector< ::DBus::Struct< uint8_t, uint16_t, DBusCommonAPIEnumeration, uint32_t > >
    GetScaleList(const uint32_t& mapViewInstanceHandle)
	{
        std::vector< ::DBus::Struct< uint8_t, uint16_t, DBusCommonAPIEnumeration, uint32_t > > ret;
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetScaleList(ret);
		return ret;
	}

	void
    SetMapViewScaleByMetersPerPixel(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const double& metersPerPixel)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
    SetMapViewBoundingBox(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< ::DBus::Struct< double, double >, ::DBus::Struct< double, double > >& boundingBox)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
        if (!obj){
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        }else{
            if(!obj->SetMapViewBoundingBox(sessionHandle, boundingBox))
                throw DBus::ErrorInvalidArgs("Not allowed if follow car mode is active");
        }
	}

	::DBus::Struct< ::DBus::Struct< double, double >, ::DBus::Struct< double, double > >
    GetMapViewBoundingBox(const uint32_t& mapViewInstanceHandle)
	{
		::DBus::Struct< ::DBus::Struct< double, double >, ::DBus::Struct< double, double > > ret;
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewBoundingBox(ret);
		return ret;
	}

	void
	SetMapViewRotation(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const int32_t& rotationAngle, const int32_t& rotationAnglePerSecond)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else {
            if(!obj->SetMapViewRotation(sessionHandle, rotationAngle, rotationAnglePerSecond))
                    throw DBus::ErrorInvalidArgs("Not allowed if follow car mode is active");
            else
                MapViewRotated(mapViewInstanceHandle);
        }
	}

	void
    GetMapViewRotation(const uint32_t& mapViewInstanceHandle, int32_t& rotationAngle, int32_t& rotationAnglePerSecond)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewRotation(rotationAngle, rotationAnglePerSecond);
	}

	void
    SetMapViewVisibilityMode(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const DBusCommonAPIEnumeration& visibilityMode)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    DBusCommonAPIEnumeration
    GetMapViewVisibilityMode(const uint32_t& mapViewInstanceHandle)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    std::vector< DBusCommonAPIEnumeration >
    GetSupportedMapViewVisibilityModes()
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    void
    SetMapViewObjectVisibility(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const std::map< DBusCommonAPIEnumeration, bool >& objectVisibilityList)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    std::map< DBusCommonAPIEnumeration, bool >
    GetMapViewObjectVisibility(const uint32_t& mapViewInstanceHandle)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    std::vector< DBusCommonAPIEnumeration >
    GetSupportedMapViewObjectVisibilities(const uint32_t& mapViewInstanceHandle)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

	void
    SetMapViewPerformanceLevel(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const DBusCommonAPIEnumeration& performanceLevel)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    DBusCommonAPIEnumeration
    GetMapViewPerformanceLevel(const uint32_t& mapViewInstanceHandle)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    std::vector< DBusCommonAPIEnumeration >
    GetSupportedMapViewPerformanceLevels()
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    std::vector< ::DBus::Struct< uint32_t, bool > >
    GetDisplayedRoutes(const uint32_t& mapViewInstanceHandle)
	{
        std::vector< ::DBus::Struct< uint32_t, bool > >ret;
                MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetDisplayedRoutes(ret);
		return ret;
	}

	void
    SetMapViewTheme(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const DBusCommonAPIEnumeration& mapViewTheme)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
                else obj->SetMapViewTheme(sessionHandle, mapViewTheme);
	}

    DBusCommonAPIEnumeration
    GetMapViewTheme(const uint32_t& mapViewInstanceHandle)
	{
                uint16_t ret=0;
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewTheme(ret);
		return ret;
	}

    std::vector< DBusCommonAPIEnumeration >
    GetSupportedMapViewThemes()
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    void ConvertPixelCoordsToGeoCoords(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const std::vector< ::DBus::Struct< uint16_t, uint16_t > >& pixelCoordinates, int32_t& error, std::vector< ::DBus::Struct< double, double > >& geoCoordinates)
	{
        MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->ConvertPixelCoordsToGeoCoords(sessionHandle, pixelCoordinates, geoCoordinates);
	}

    void ConvertGeoCoordsToPixelCoords(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const std::vector< ::DBus::Struct< double, double > >& geoCoordinates, int32_t& error, std::vector< ::DBus::Struct< uint16_t, uint16_t > >& pixelCoordinates)
    {
        MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->ConvertGeoCoordsToPixelCoords(sessionHandle, geoCoordinates, pixelCoordinates);
	}

	void
    SetCameraHeadingTrackUp(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle)
	{
		MapViewerControlObj *obj=handles[mapViewInstanceHandle];
		if (!obj)
			throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetCameraHeadingTrackUp(sessionHandle);
	}

	void
    SetMapViewSaveArea(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< double, double, double, double >& saveArea)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	::DBus::Struct< double, double, double, double >
    GetMapViewSaveArea(const uint32_t& mapViewInstanceHandle)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
    GetCameraHeading(const uint32_t& mapViewInstanceHandle, DBusCommonAPIEnumeration& headingType, int32_t& headingAngle, ::DBus::Struct< double, double >& target)
	{
        MapViewerControlObj *obj=handles[mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetCameraHeading(headingType,headingAngle,target);
    }

    std::vector< uint32_t >
    DisplayCustomElements(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const std::vector< ::DBus::Struct< std::string, std::string, ::DBus::Struct< double, double >, ::DBus::Struct< int16_t, int16_t > > >& customElements)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    void HideCustomElements(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const std::vector< uint32_t >& customElementHandles)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    std::map< uint32_t, ::DBus::Struct< std::string, std::string, ::DBus::Struct< double, double >, ::DBus::Struct< int16_t, int16_t > > >
    GetDisplayedCustomElements(const uint32_t& mapViewInstanceHandle)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

	void
    SetPoiCategoriesNotVisible(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const std::vector< uint32_t >& poiCategoryIds)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
	SetTrafficIncidentsVisibility(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const bool& visible)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    std::vector< uint32_t >
	GetPoiCategoriesVisible(const uint32_t& mapViewInstanceHandle)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    std::vector< ::DBus::Struct< int32_t, ::DBus::Struct< double, double >, ::DBus::Struct< uint8_t, ::DBus::Variant > > >
    SelectElementsOnMap(const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< uint16_t, uint16_t >& pixelCoordinate, const std::vector< int32_t >& selectableTypes, const uint16_t& maxNumberOfSelectedElements)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
    SetPoiCategoriesVisible(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const std::vector< uint32_t >& poiCategoryIds)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

	void
    SetPoiCategoriesVisibleWithinLimits(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const std::vector< uint32_t >& poiCategoryIds, const uint8_t& minScaleID, const uint8_t& maxScaleID)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    bool subscribeFormapViewScaleChangedSelective()
    {//not implemented yet, always return true
        return true;
    }

    void unsubscribeFrommapViewScaleChangedSelective()
    {//not implemented yet

    }

    bool subscribeFormapViewScaleByMetersPerPixelChangedSelective()
    {//not implemented yet, always return true
        return true;
    }

    void unsubscribeFrommapViewScaleByMetersPerPixelChangedSelective()
    {//not implemented yet

    }

    int32_t MapViewRotateBegin(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< uint16_t, uint16_t >& anchorPoint)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
        return 0;
    }

    int32_t MapViewRotateUpdate(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< uint16_t, uint16_t >& anchorPoint, const int16_t& rotationAngle)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
        return 0;
    }

    int32_t MapViewRotateEnd(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const uint16_t& velocity)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
        return 0;
    }

    int32_t MapViewPinchBegin(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< uint16_t, uint16_t >& anchorPoint)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
        return 0;
    }

    int32_t MapViewPinchUpdate(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< uint16_t, uint16_t >& anchorPoint, const double& scaleFactor)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
        return 0;
    }

    int32_t MapViewPinchEnd(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const double& velocity)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
        return 0;
    }

    int32_t MapViewTiltBegin(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const ::DBus::Struct< uint16_t, uint16_t >& anchorPoint)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
        return 0;
    }

    int32_t MapViewTiltUpdate(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const int32_t& translation)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
        return 0;
    }

    int32_t MapViewTiltEnd(const uint32_t& sessionHandle, const uint32_t& mapViewInstanceHandle, const uint32_t& velocity)
    {
        throw DBus::ErrorNotSupported("Not yet supported");
        return 0;
    }

};

void
MapViewerControlObj::SetMapViewPerspective(uint32_t SessionHandle, uint16_t MapViewPerspectiveMode)
{
	if (m_perspective != MapViewPerspectiveMode) {
		m_perspective=MapViewPerspectiveMode;
		struct transformation *trans=navit_get_trans(m_navit.u.navit);
		switch (m_perspective) {
		case GENIVI_MAPVIEWER_2D:
			transform_set_pitch(trans, 0);
			break;
		case GENIVI_MAPVIEWER_3D:
			transform_set_pitch(trans, 40);
			break;
		}
        navit_draw(m_navit.u.navit);
	}
}

void
MapViewerControlObj::GetMapViewPerspective(uint16_t& MapViewPerspectiveMode)
{
	MapViewPerspectiveMode=m_perspective;
}

void
MapViewerControlObj::GetScaleList(std::vector< ::DBus::Struct< uint8_t, uint16_t, DBusCommonAPIEnumeration, uint32_t > >& ScalesList)
{
    ::DBus::Struct< uint8_t, uint16_t, DBusCommonAPIEnumeration, uint32_t > scale;
    uint32_t basisPixel = ZOOM_ZERO_METER_WIDTH/m_width;

    scale._1=0;
    scale._2=2;
    scale._3=GENIVI_MAPVIEWER_METER;
    scale._4=basisPixel;
    ScalesList.push_back(scale);
    scale._1=1;
    scale._2=5;
    scale._3=GENIVI_MAPVIEWER_METER;
    scale._4=basisPixel<<1;
    ScalesList.push_back(scale);
    scale._1=2;
    scale._2=10;
    scale._3=GENIVI_MAPVIEWER_METER;
    scale._4=basisPixel<<2;
    ScalesList.push_back(scale);
    scale._1=3;
    scale._2=20;
    scale._3=GENIVI_MAPVIEWER_METER;
    scale._4=basisPixel<<3;
    ScalesList.push_back(scale);
    scale._1=4;
    scale._2=50;
    scale._3=GENIVI_MAPVIEWER_METER;
    scale._4=basisPixel<<4;
    ScalesList.push_back(scale);
    scale._1=5;
    scale._2=100;
    scale._3=GENIVI_MAPVIEWER_METER;
    scale._4=basisPixel<<5;
    ScalesList.push_back(scale);
    scale._1=6;
    scale._2=200;
    scale._3=GENIVI_MAPVIEWER_METER;
    scale._4=basisPixel<<6;
    ScalesList.push_back(scale);
    scale._1=7;
    scale._2=500;
    scale._3=GENIVI_MAPVIEWER_METER;
    scale._4=basisPixel<<7;
    ScalesList.push_back(scale);
    scale._1=8;
    scale._2=1;
    scale._3=GENIVI_MAPVIEWER_KM;
    scale._4=basisPixel<<8;
    ScalesList.push_back(scale);
    scale._1=9;
    scale._2=2;
    scale._3=GENIVI_MAPVIEWER_KM;
    scale._4=basisPixel<<9;
    ScalesList.push_back(scale);
    scale._1=10;
    scale._2=5;
    scale._3=GENIVI_MAPVIEWER_KM;
    scale._4=basisPixel<<10;
    ScalesList.push_back(scale);
    scale._1=11;
    scale._2=10;
    scale._3=GENIVI_MAPVIEWER_KM;
    scale._4=basisPixel<<11;
    ScalesList.push_back(scale);
    scale._1=12;
    scale._2=20;
    scale._3=GENIVI_MAPVIEWER_KM;
    scale._4=basisPixel<<12;
    ScalesList.push_back(scale);
    scale._1=13;
    scale._2=50;
    scale._3=GENIVI_MAPVIEWER_KM;
    scale._4=basisPixel<<13;
    ScalesList.push_back(scale);
    scale._1=14;
    scale._2=100;
    scale._3=GENIVI_MAPVIEWER_KM;
    scale._4=basisPixel<<14;
    ScalesList.push_back(scale);
    scale._1=15;
    scale._2=200;
    scale._3=GENIVI_MAPVIEWER_KM;
    scale._4=basisPixel<<15;
    ScalesList.push_back(scale);
}

void
MapViewerControlObj::SetMapViewScale(uint32_t SessionHandle, uint8_t ScaleID)
{
	long scale=1 << ScaleID;
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	transform_set_scale(trans, scale);
	navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::SetMapViewScaleByDelta(uint32_t SessionHandle, int16_t ScaleDelta)
{
	if (ScaleDelta < 0) 
        navit_zoom_in(m_navit.u.navit,1 << (-ScaleDelta),NULL);
	else if (ScaleDelta > 0) 
        navit_zoom_out(m_navit.u.navit,1 << ScaleDelta,NULL);
}

void
MapViewerControlObj::GetMapViewScale(uint8_t& ScaleID, DBusCommonAPIEnumeration& IsMinMax)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	long scale=transform_get_scale(trans);
    if (scale <= 1)
        IsMinMax=GENIVI_MAPVIEWER_MIN;
	else
        if (scale >= 2097152)
            IsMinMax=GENIVI_MAPVIEWER_MAX;
        else
            IsMinMax=GENIVI_MAPVIEWER_MID;
	ScaleID=0;
	while (scale > 1) {
		scale >>=1;
		ScaleID++;
	}
}

void
MapViewerControlObj::GetMapViewType(uint16_t& MapViewType)
{
	MapViewType=GENIVI_MAPVIEWER_MAIN_MAP;
}

void
MapViewerControlObj::SetMapViewTheme(uint32_t sessionHandle, uint16_t mapViewTheme)
{
	struct attr layout,name;
	struct attr_iter *iter;
	const char *layout_name=NULL;
	switch (mapViewTheme) {
	case GENIVI_MAPVIEWER_THEME_1:
		layout_name="Car";
		break;
	case GENIVI_MAPVIEWER_THEME_2:
		layout_name="Car-dark";
		break;
	default:
        LOG_DEBUG_MSG(gCtx,"Invalid mapViewTheme");
		throw DBus::ErrorInvalidArgs("Invalid mapViewTheme");
	}
    void * unused;
    iter=navit_attr_iter_new(unused);
	while (navit_get_attr(m_navit.u.navit, attr_layout, &layout, iter)) {
		if (!layout_get_attr(layout.u.layout, attr_name, &name, NULL)) {
			navit_attr_iter_destroy(iter);
			throw DBus::ErrorFailed("Internal error: Failed to get layout name");
		}
        LOG_DEBUG(gCtx,"Layout: %s vs %s",name.u.str,layout_name);
		if (!strcmp(name.u.str,layout_name)) {
			navit_set_attr(m_navit.u.navit, &layout);
			navit_attr_iter_destroy(iter);
			return;
		}
	}
	navit_attr_iter_destroy(iter);
	throw DBus::ErrorFailed("Internal error: Failed to get map layout");
}

void
MapViewerControlObj::GetMapViewTheme(uint16_t& mapViewTheme)
{
	struct attr layout,name;
	if (!navit_get_attr(m_navit.u.navit, attr_layout, &layout, NULL))
		throw DBus::ErrorFailed("Internal error: Failed to get map layout");
	if (!layout_get_attr(layout.u.layout, attr_name, &name, NULL)) 
		throw DBus::ErrorFailed("Internal error: Failed to get layout name");
    LOG_DEBUG(gCtx,"Name: %s",name.u.str);
	if (!strcmp(name.u.str,"Car-dark"))
		mapViewTheme=GENIVI_MAPVIEWER_THEME_2;
	else
		mapViewTheme=GENIVI_MAPVIEWER_THEME_1;
}

void
MapViewerControlObj::SetFollowCarMode(uint32_t SessionHandle, bool active)
{
	struct attr follow={attr_follow};
	m_follow_car=active;
	if (active)
		follow.u.num=1;
	else
		follow.u.num=100000;
    LOG_DEBUG(gCtx,"Setting follow to: %d",(int) follow.u.num);
	navit_set_attr(m_navit.u.navit,&follow);
	vehicle_set_attr(m_vehicle.u.vehicle,&follow);
	follow.type=attr_timeout;
	navit_set_attr(m_navit.u.navit,&follow);
}

void
MapViewerControlObj::GetFollowCarMode(bool& active)
{
	active=m_follow_car;
}

void
MapViewerControlObj::SetCameraHeadingAngle(uint32_t sessionHandle, int32_t angle)
{
	struct attr orientation={attr_orientation};
	orientation.u.num=angle;
	navit_set_attr(m_navit.u.navit, &orientation);
    navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::GetCameraHeading(DBusCommonAPIEnumeration& headingType, int32_t& headingAngle, ::DBus::Struct< double, double >& target)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
    headingAngle=transform_get_yaw(trans);
    headingType=GENIVI_MAPVIEWER_INVALID;
    target._1=0;
    target._2=0;
}

void
MapViewerControlObj::SetCameraTiltAngle(uint32_t sessionHandle, double angle)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	transform_set_pitch(trans, angle);
	navit_draw(m_navit.u.navit);
	
}

void
MapViewerControlObj::GetCameraTiltAngle(double &angle)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	angle=transform_get_pitch(trans);
}

void
MapViewerControlObj::SetCameraRollAngle(uint32_t sessionHandle, double angle)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	transform_set_roll(trans, angle);
	navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::GetCameraRollAngle(double &angle)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	angle=transform_get_roll(trans);
}

void
MapViewerControlObj::SetCameraDistanceFromTargetPoint(uint32_t sessionHandle, double distance)
{
	struct transformation *t=navit_get_trans(m_navit.u.navit);
	transform_set_distance(t, distance);
    LOG_DEBUG(gCtx,"Set camera distance from target point %f",distance);
	transform_set_scales(t, 100, 100, 100 << 8);
	navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::GetCameraDistanceFromTargetPoint(double &distance)
{
	struct transformation *t=navit_get_trans(m_navit.u.navit);
	distance=transform_get_distance(t);
}

void
MapViewerControlObj::SetCameraHeight(uint32_t sessionHandle, double height)
{
	struct transformation *t=navit_get_trans(m_navit.u.navit);
	double distance=transform_get_distance(t);
	if (height > distance || height < -distance) 
		throw DBus::ErrorInvalidArgs("Height > Distance");
	double angle=acos(height/distance)*180.0/M_PI;
	transform_set_pitch(t, angle);
    LOG_DEBUG(gCtx,"Set camera: distance %f angle %f height %f",distance,angle,height);
	navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::GetCameraHeight(double &height)
{
	struct transformation *t=navit_get_trans(m_navit.u.navit);
	double distance=transform_get_distance(t);
	double angle=transform_get_pitch(t);
	height=cos(angle*M_PI/180)*distance;
    LOG_DEBUG(gCtx,"Get camera: distance %f angle %f height %f",distance,angle,height);
}

void
MapViewerControlObj::SetCameraHeadingTrackUp(uint32_t sessionHandle)
{
	struct attr orientation={attr_orientation};
	orientation.u.num=-1;
	navit_set_attr(m_navit.u.navit, &orientation);
    navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::SetTargetPoint(uint32_t SessionHandle, ::DBus::Struct< double, double, double >target)
{
	struct coord_geo g;
	struct attr center={attr_center};
	center.u.coord_geo=&g;
	g.lat=target._1;
	g.lng=target._2;
	navit_set_attr(m_navit.u.navit, &center);
    navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::GetTargetPoint(::DBus::Struct< double, double, double >&target)
{
	struct attr center;
	if (!navit_get_attr(m_navit.u.navit, attr_center, &center, NULL) || !center.u.coord_geo) 
		throw DBus::ErrorFailed("Internal error: Failed to get center attribute");
	target._1=center.u.coord_geo->lat;
	target._2=center.u.coord_geo->lng;
	target._3=0;
}

void
MapViewerControlObj::MoveMap(void)
{
    if (m_scrollspeed || m_rotationanglepersecond || m_force_draw) {
		int w,h;
		double refresh_time=0.3; // Time needed to redraw map
		double r=m_scrollspeed*refresh_time;
		struct point p;
		struct transformation *t=navit_get_trans(m_navit.u.navit);
        if (m_rotationanglepersecond) {
			int yaw=transform_get_yaw(t);
			int delta=((int)(m_rotationangle+0.5)-yaw)%360;
			if (delta > 180)
				delta-=180;
			if (delta < -180)
				delta+=180;
            if (delta < 0 && delta < -m_rotationanglepersecond)
                delta=-m_rotationanglepersecond;
            if (delta > 0 && delta > m_rotationanglepersecond)
                delta=m_rotationanglepersecond;
			if (delta)
				transform_set_yaw(t, yaw+delta);
			else
                m_rotationanglepersecond=0;
		}
		transform_get_size(t, &w, &h);
		p.x=w/2+sin(m_scrolldirection*M_PI/180)*r;
		p.y=h/2-cos(m_scrolldirection*M_PI/180)*r;
		navit_set_center_screen(m_navit.u.navit, &p, 1);
		m_force_draw=false;
	}
}

static void
MapViewerControlObj_MoveMap(class MapViewerControlObj *obj)
{
	obj->MoveMap();
}

static void
MapViewerControlObj_PostDraw(class MapViewerControlObj *obj)
{
	event_add_timeout(0, 0, obj->m_move_callback);
}

bool
MapViewerControlObj::SetMapViewPan(uint32_t SessionHandle, int32_t panningAction, ::DBus::Struct< uint16_t, uint16_t > p)
{
    struct transformation *tr;
    struct coord co,cn,c,*cp;
    struct point pan;
    if(m_follow_car) return false; //not allowed if follow car is active
    switch(panningAction)
    {
        case GENIVI_MAPVIEWER_PAN_START:
        break;
        case GENIVI_MAPVIEWER_PAN_TO:
        case GENIVI_MAPVIEWER_PAN_END:
            tr=navit_get_trans(m_navit.u.navit);
            transform_reverse(tr, &m_pan, &co);
            pan.x=p._1;
            pan.y=p._2;
            transform_reverse(tr, &pan, &cn);
            LOG_DEBUG(gCtx,"Pan: %d,%d - %d,%d",m_pan.x,m_pan.y,pan.x,pan.y);
            cp=transform_get_center(tr);
            c.x=cp->x+co.x-cn.x;
            c.y=cp->y+co.y-cn.y;
            transform_set_center(tr, &c);
            navit_draw(m_navit.u.navit);
        default:
            return false;
    }
    m_pan_action=panningAction;
    m_pan.x=p._1;
    m_pan.y=p._2;

    return true;
}

void
MapViewerControlObj::GetMapViewPan(const int32_t& panningAction, ::DBus::Struct< uint16_t, uint16_t >& p)
{
    p._1=m_pan.x;
    p._2=m_pan.y;
}

bool
MapViewerControlObj::SetMapViewRotation(uint32_t sessionHandle, double rotationAngle, double rotationAnglePerSecond)
{
	m_rotationangle=rotationAngle;
    m_rotationanglepersecond=rotationAnglePerSecond;
    if(m_follow_car) return false; //not allowed if follow car is active
    MoveMap();

    return true;
}

void
MapViewerControlObj::GetMapViewRotation(int32_t& rotationAngle, int32_t& rotationAnglePerSecond)
{
	rotationAngle=m_rotationangle;
    rotationAnglePerSecond=m_rotationanglepersecond;
}

bool
MapViewerControlObj::SetMapViewBoundingBox(uint32_t sessionHandle, const ::DBus::Struct< ::DBus::Struct< double, double >, ::DBus::Struct< double, double > >& boundingBox)
{
	struct coord_rect r;
	struct coord_geo g;
    if(m_follow_car) return false; //not allowed if follow car is active
    g.lat=boundingBox._1._1;
	g.lng=boundingBox._1._2;
	transform_from_geo(projection_mg, &g, &r.lu);
	g.lat=boundingBox._2._1;
	g.lng=boundingBox._2._2;
	transform_from_geo(projection_mg, &g, &r.rl);
    LOG_DEBUG(gCtx,"Bounding box: 0x%x,0x%x-0x%x,0x%x",r.lu.x,r.lu.y,r.rl.x,r.rl.y);
	navit_zoom_to_rect(m_navit.u.navit, &r);

    return true;
}

void
MapViewerControlObj::GetMapViewBoundingBox(::DBus::Struct< ::DBus::Struct< double, double >, ::DBus::Struct< double, double > >& boundingBox)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	struct point p;
	struct coord c;
	struct coord_geo g;
	int w,h;
	transform_get_size(trans, &w, &h);
	p.x=0;
	p.y=0;
	transform_reverse(trans, &p, &c);
	transform_to_geo(projection_mg, &c, &g);
	boundingBox._1._1=g.lat;
	boundingBox._1._2=g.lng;
	p.x=w;
	p.y=h;
	transform_reverse(trans, &p, &c);
	transform_to_geo(projection_mg, &c, &g);
	boundingBox._2._1=g.lat;
	boundingBox._2._2=g.lng;
}

void
MapViewerControlObj::GetDisplayedRoutes(std::vector< ::DBus::Struct< uint32_t, bool > >& displayedRoutes)
{
	int i;
	for (i = 0 ; i < m_displayed_routes.size(); i++) {
        ::DBus::Struct< uint32_t, bool> route;
		route._1=m_displayed_routes[i]->RouteHandle();
		route._2=false;
		displayedRoutes.push_back(route);
	}
}

void
MapViewerControlObj::DisplayRoute(uint32_t SessionHandle, uint32_t RouteHandle, bool highlighted)
{
	HideRoute(SessionHandle, RouteHandle);
	if (navigationcore_session == -1) {
        NavigationCoreSession session(*conns[NAVIGATIONCORE_SESSION_CONNECTION]);
        int32_t error;
        session.CreateSession("MapViewerControl",error,navigationcore_session);
	}
	DisplayedRoute *route=new DisplayedRoute(this,navigationcore_session,RouteHandle,m_mapset);
	route->Show();
	m_displayed_routes.push_back(route);
	m_force_draw=true;
	event_add_timeout(0, 0, m_move_callback);
}

void
MapViewerControlObj::HideRoute(uint32_t SessionHandle, uint32_t RouteHandle)
{
	std::vector<DisplayedRoute *>::iterator it;

	for (it=m_displayed_routes.begin() ; it < m_displayed_routes.end(); it++ ) {
		if (*it && (*it)->m_handle == RouteHandle) {
			(*it)->Hide();
			m_displayed_routes.erase(it);
			delete(*it);
			m_force_draw=true;
			event_add_timeout(0, 0, m_move_callback);
		}
	}
}

void
MapViewerControlObj::ConvertPixelCoordsToGeoCoords(uint32_t sessionHandle, const std::vector< ::DBus::Struct< uint16_t, uint16_t > >& pixelCoordinates, std::vector< ::DBus::Struct< double, double > >& geoCoordinates)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	struct coord c;
	struct point p;
	struct coord_geo g;
	std::vector< ::DBus::Struct< uint16_t, uint16_t > >::const_iterator it;
	for (it=pixelCoordinates.begin(); it < pixelCoordinates.end(); it++) {
		::DBus::Struct< double, double >geoCoordinate;
		p.x=it->_1;
		p.y=it->_2;
		transform_reverse(trans, &p, &c);
		transform_to_geo(projection_mg, &c, &g);
		geoCoordinate._1=g.lat;
		geoCoordinate._2=g.lng;
		geoCoordinates.push_back(geoCoordinate);
	}
	
}

void
MapViewerControlObj::ConvertGeoCoordsToPixelCoords(uint32_t sessionHandle, const std::vector< ::DBus::Struct< double, double > >& geoCoordinates, std::vector< ::DBus::Struct< uint16_t, uint16_t > >& pixelCoordinates)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	struct coord c;
	struct point p;
	struct coord_geo g;
	std::vector< ::DBus::Struct< double, double > >::const_iterator it;
	for (it=geoCoordinates.begin(); it < geoCoordinates.end(); it++) {
		::DBus::Struct< uint16_t, uint16_t >pixelCoordinate;
		g.lat=it->_1;
		g.lng=it->_2;
		transform_from_geo(projection_mg, &g, &c);
		transform(trans, projection_mg, &c, &p, 1, 0, 0, NULL);
		pixelCoordinate._1=p.x;
		pixelCoordinate._2=p.y;
		pixelCoordinates.push_back(pixelCoordinate);
	}
}

#if LM
static void callbackFunction(ilmObjectType object, t_ilm_uint surfaceId, t_ilm_bool created, void *user_data)
{
    (void)user_data;

    t_ilm_int pLength = 0;
    t_ilm_layer* ppArray = NULL;
    struct ilmSurfaceProperties pSurfaceProperties;
    t_ilm_layer renderOrder[2];

    if(object == ILM_LAYER) {
        if(created){
            //FIXIT: Need to add tempo
            sleep(1);
        }
    }

    if (object == ILM_SURFACE) {
        if (created) {
            if (surfaceId == FSA_SURFACE) {

                //FIXIT: Need to add tempo
                sleep(2);

                //Grab all the layers - HMI will be pLength-2 and FSA pLength-1
                if (ilm_getLayerIDs(&pLength, &ppArray)  != ILM_SUCCESS) {
                    fprintf(stderr, "error on ilm_getLayerIDs\n");
                }

		//FIXIT: Since we don't know thep id of hmi_launcher and order of start.
                //Guess it is the last one or the one before navit mapviewer PID.
                renderOrder[0] = FSA_SURFACE;
                if (ppArray[pLength - 2] != FSA_SURFACE)
                    renderOrder[1] = SURFACE_OFFSET + ppArray[pLength - 2];
                    if (ilm_layerSetRenderOrder(ppArray[pLength - 2],renderOrder,2) != ILM_SUCCESS) {
                        fprintf(stderr,"error on ilm_layerSetRenderOrder\n");
                    }
                else if (ppArray[pLength - 1] != FSA_SURFACE)
                    renderOrder[1] = SURFACE_OFFSET + ppArray[pLength - 1];
                    if (ilm_layerSetRenderOrder(ppArray[pLength - 1],renderOrder,2) != ILM_SUCCESS) {
                        fprintf(stderr,"error on ilm_layerSetRenderOrder\n");
                    }
                else
                     fprintf(stderr,"error on render order guess\n");

                if (ilm_layerSetRenderOrder(ppArray[pLength - 1],renderOrder,2) != ILM_SUCCESS) {
                    fprintf(stderr,"error on ilm_layerSetRenderOrder\n");
                }

                if (ilm_commitChanges() != ILM_SUCCESS) {
                    fprintf(stderr,"error on ilm_commitChanges\n");
                }
            }
	}
    }
}
#endif

MapViewerControlObj::MapViewerControlObj(MapViewerControl *mapviewercontrol, uint32_t handle, const ::DBus::Struct< uint16_t, uint16_t >& MapViewSize)
{
	m_mapviewercontrol=mapviewercontrol;
	m_handle=handle;
	m_navit.type=attr_navit;
	m_scrollspeed=0;
	m_scrolldirection=0;
	m_force_draw=false;
	m_perspective=GENIVI_MAPVIEWER_2D;
	m_follow_car=true;
    m_routing=new Routing(*conns[NAVIGATIONCORE_ROUTING_CONNECTION], this);
	struct attr navit_template;
	struct attr navit_flags={attr_flags};navit_flags.u.num=2;
	struct attr *navit_attrs[]={&navit_flags,NULL};
	if (!config_get_attr(config, attr_navit, &navit_template, NULL)) {
        LOG_DEBUG_MSG(gCtx,"failed to get navit template from config");
		return;
	}
	m_navit.u.navit=navit_new(NULL,navit_attrs);
	if (!m_navit.u.navit) {
        LOG_DEBUG_MSG(gCtx,"failed to create new navit instance");
		return;
	}
	const char *graphics=getenv("NAVIT_GRAPHICS");
	if (!graphics)
		graphics="gtk_drawing_area";
	struct attr graphics_type={attr_type};graphics_type.u.str=(char *)graphics;
	struct attr graphics_w={attr_w};graphics_w.u.num=MapViewSize._1;
	struct attr graphics_h={attr_h};graphics_h.u.num=MapViewSize._2;
	struct attr graphics_window_title={attr_window_title};graphics_window_title.u.str=g_strdup_printf("Navit-%d",handle);
	struct attr *graphics_attrs[]={&graphics_type,&graphics_w,&graphics_h,&graphics_window_title,NULL};
	m_graphics.type=attr_graphics;
	m_graphics.u.graphics=graphics_new(&m_navit,graphics_attrs);
	g_free(graphics_window_title.u.str);

	if (!m_graphics.u.graphics) {
        LOG_DEBUG_MSG(gCtx,"failed to create new graphics");
		return;
	}
	m_postdraw_callback=callback_new_attr_1(reinterpret_cast<void (*)(void)>(MapViewerControlObj_PostDraw), attr_postdraw, this);
	m_move_callback=callback_new_1(reinterpret_cast<void (*)(void)>(MapViewerControlObj_MoveMap), this);
	graphics_add_callback(m_graphics.u.graphics, m_postdraw_callback);
	navit_add_attr(m_navit.u.navit, &m_graphics);

	struct attr mapset;
	if (!navit_get_attr(navit_template.u.navit, attr_mapset, &mapset, NULL)) {
        LOG_DEBUG_MSG(gCtx,"failed to get mapset");
		return;
	}
	mapset.u.mapset=mapset_dup(mapset.u.mapset);
	m_mapset=mapset.u.mapset;
	navit_add_attr(m_navit.u.navit, &mapset);
    void * unused;
    struct attr_iter *iter=navit_attr_iter_new(unused);
	struct attr layout;
	while (navit_get_attr(navit_template.u.navit, attr_layout, &layout, iter)) {
		navit_add_attr(m_navit.u.navit, &layout);
	}
	navit_attr_iter_destroy(iter);

	struct attr vehicle_source={attr_source};vehicle_source.u.str=(char *)"null:";
	struct attr vehicle_follow={attr_follow};vehicle_follow.u.num=1;
	struct attr *vehicle_attrs[]={&vehicle_source,&vehicle_follow,NULL};
	m_vehicle.type=attr_vehicle;
	m_vehicle.u.vehicle=vehicle_new(&m_navit,vehicle_attrs);
	navit_add_attr(m_navit.u.navit, &m_vehicle);
	navit_set_attr(m_navit.u.navit, &m_vehicle);
    m_mapmatchedposition=new MapMatchedPosition(*conns[NAVIGATIONCORE_MAPMATCHEDPOSITION_CONNECTION], m_vehicle.u.vehicle);

	navit_init(m_navit.u.navit);
	graphics_get_data(m_graphics.u.graphics,"window");

	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	struct map_selection sel;
	memset(&sel, 0, sizeof(sel));
	sel.u.p_rect.rl.x=MapViewSize._1;
	sel.u.p_rect.rl.y=MapViewSize._2;
	transform_set_screen_selection(trans, &sel);

    m_width=MapViewSize._1;
    m_height=MapViewSize._2;


#if LM
    t_ilm_nativedisplay display = (t_ilm_nativedisplay)graphics_get_data(m_graphics.u.graphics, "display");

    if (ilmClient_init(display) != ILM_SUCCESS) {
        fprintf(stderr, "error on ilm_initWidthNativeDisplay\n");
    }

    t_ilm_nativehandle nativehandle=(t_ilm_nativehandle)graphics_get_data(m_graphics.u.graphics,"xwindow_id");
    t_ilm_surface surfaceId=FSA_SURFACE;

    //Register Notification
    if (ilm_registerNotification(callbackFunction, NULL)  != ILM_SUCCESS) {
        fprintf(stderr,"error on ilm_registerNotification\n");
    }

    //Create surface for the map and add notification when created. Note: width, heigh & pixel format are not taking in count at the end.
    if (ilm_surfaceCreate(nativehandle, MapViewSize._1, MapViewSize._2, ILM_PIXELFORMAT_RGBA_8888, &surfaceId) != ILM_SUCCESS) {
        fprintf(stderr,"error on ilm_surfaceCreate\n");
    }

    //Commit all changes
    if (ilm_commitChanges() != ILM_SUCCESS) {
        fprintf(stderr,"error on ilm_commitChanges\n");
    }
#endif

    LOG_DEBUG_MSG(gCtx,"Map viewer control obj created");

}

MapViewerControlObj::~MapViewerControlObj()
{
#if LM
    t_ilm_surface surfaceId=FSA_SURFACE;

    if (ilm_surfaceRemove(surfaceId) != ILM_SUCCESS) {
        fprintf(stderr,"error on ilm_surfaceRemove\n");
    }

    if (ilm_commitChanges() != ILM_SUCCESS) {
        fprintf(stderr,"error on ilm_commitChanges\n");
    }
#endif

	graphics_remove_callback(m_graphics.u.graphics, m_postdraw_callback);
    callback_destroy(m_postdraw_callback);
    callback_destroy(m_move_callback);
	navit_destroy(m_navit.u.navit);
    LOG_DEBUG_MSG(gCtx,"Map viewer control obj deleted");
	delete(m_routing);
	delete(m_mapmatchedposition);
}

static double
double_variant(DBus::Variant variant)
{
	double d;
	DBus::MessageIter iter=variant.reader();
	iter >> d;
	return d;
}

uint32_t
DisplayedRoute::RouteHandle()
{
	return m_handle;
}

void
DisplayedRoute::Show()
{
	if (!m_shown) {
		if (m_map.u.map)
			mapset_add_attr(m_mapset, &m_map);
		m_shown=true;
	}
}

void
DisplayedRoute::Hide()
{
	if (m_shown) {
		if (m_map.u.map)
			mapset_remove_attr(m_mapset, &m_map);
		m_shown=false;
	}
}

void
DisplayedRoute::AddGeoCoordinateD(double lat, double lon)
{
	struct coord_geo g;
	struct coord c;
	g.lat=lat;
	g.lng=lon;
	transform_from_geo(projection_mg, &g, &c);
	m_coordinates.push_back(c);
}

void
DisplayedRoute::AddGeoCoordinate(DBus::Variant lat, DBus::Variant lon)
{
	AddGeoCoordinateD(double_variant(lat), double_variant(lon));
}

bool
DisplayedRoute::AddSegment(std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > map)
{
	if (map.find(GENIVI_NAVIGATIONCORE_START_LATITUDE) != map.end() && map.find(GENIVI_NAVIGATIONCORE_START_LONGITUDE) != map.end()) 
        AddGeoCoordinate(map[GENIVI_NAVIGATIONCORE_START_LATITUDE]._2,map[GENIVI_NAVIGATIONCORE_START_LONGITUDE]._2);
	if (map.find(GENIVI_NAVIGATIONCORE_INTERMEDIATE_POINTS) != map.end()) {
        ::DBus::Variant variant=map[GENIVI_NAVIGATIONCORE_INTERMEDIATE_POINTS]._2;
		std::vector<DBus::Struct<uint16_t, double, double, double> >intermediate_points;
		DBus::MessageIter iter=variant.reader();
		iter >> intermediate_points;
		for (int i = 0 ; i < intermediate_points.size(); i++) {
			AddGeoCoordinateD(intermediate_points[i]._2, intermediate_points[i]._3);
		}
	}
	if (map.find(GENIVI_NAVIGATIONCORE_END_LATITUDE) != map.end() && map.find(GENIVI_NAVIGATIONCORE_END_LONGITUDE) != map.end()) {
        AddGeoCoordinate(map[GENIVI_NAVIGATIONCORE_END_LATITUDE]._2,map[GENIVI_NAVIGATIONCORE_END_LONGITUDE]._2);
		return true;
	}
	return false;
}

void
DisplayedRoute::WriteSegment(FILE *out)
{
	if (m_coordinates.size()) {
		int i;
        uint32_t header[3]={2+2*(uint32_t)m_coordinates.size(),type_street_route,2*(uint32_t)m_coordinates.size()};
		fwrite(header, sizeof(header), 1, out);
		for (i = 0 ; i < m_coordinates.size() ; i++) 
			fwrite(&m_coordinates[i], sizeof(struct coord), 1, out);
	}
}

DisplayedRoute::DisplayedRoute(class MapViewerControlObj *mapviewer, uint8_t RouteSession, uint32_t RouteHandle, struct mapset *mapset)
{	
    std::vector< std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > > RouteShape;
    std::vector< DBusCommonAPIEnumeration > valuesToReturn;
	valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_START_LATITUDE);
	valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_START_LONGITUDE);
	valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_END_LATITUDE);
	valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_END_LONGITUDE);
	valuesToReturn.push_back(GENIVI_NAVIGATIONCORE_INTERMEDIATE_POINTS);
	m_handle=RouteHandle;
	m_map.type=attr_map;
	m_map.u.map=NULL;
	m_filename=NULL;
	m_mapset=mapset;
	m_shown=false;
	uint32_t totalNumberOfSegments;
    mapviewer->m_routing->GetRouteSegments(RouteHandle, 1, valuesToReturn, 0xffffffff, 0, totalNumberOfSegments, RouteShape);
	m_filename=g_strdup_printf("/tmp/genivi_route_map_%d_%d.bin",mapviewer->m_handle,RouteHandle);
	FILE *f=fopen(m_filename,"w");
	int count=RouteShape.size();
	bool complete=true;
	for (int i = 0 ; i < count ; i++) {
        std::map< DBusCommonAPIEnumeration, DBusCommonAPIVariant > map = RouteShape[i];
		if (!complete) {
			if (map.find(GENIVI_NAVIGATIONCORE_START_LATITUDE) != map.end() && map.find(GENIVI_NAVIGATIONCORE_START_LONGITUDE) != map.end()) 
                AddGeoCoordinate(map[GENIVI_NAVIGATIONCORE_START_LATITUDE]._2,map[GENIVI_NAVIGATIONCORE_START_LONGITUDE]._2);
			else
                LOG_DEBUG_MSG(gCtx,"previous segment is missing end, but current segment is missing start also");
			WriteSegment(f);
		}
		complete=AddSegment(map);
	}
	if (!complete)
        LOG_DEBUG_MSG(gCtx,"last segment is missing end");
	WriteSegment(f);
	fclose(f);
	struct attr map_attr_type={attr_type};
	map_attr_type.u.str=(char *)"binfile";
	struct attr map_attr_data={attr_data};
	map_attr_data.u.str=m_filename;
	struct attr *map_attrs[]={&map_attr_type, &map_attr_data, NULL};
	m_map.u.map=map_new(NULL,map_attrs);
}

DisplayedRoute::~DisplayedRoute()
{
	if (m_map.u.map)
		map_destroy(m_map.u.map);
	if (m_filename) {
		unlink(m_filename);
		g_free(m_filename);
	}
}

static class MapViewerControl *server;

void
plugin_init(void)
{
    DLT_REGISTER_APP("MPVS","MAP VIEWER CONTROL SERVER");
    DLT_REGISTER_CONTEXT(gCtx,"MPVS","Global Context");

    event_request_system("glib","genivi_mapviewercontrol");
	int i;
    for (i = 0 ; i < CONNECTION_AMOUNT ; i++) {
        // init the dispatcher
        DBus::default_dispatcher = &dispatchers[i];
        dispatchers[i].attach(NULL);
        // create a connection on the session bus and connect the dispatcher
		conns[i] = new DBus::Connection(DBus::Connection::SessionBus());
		conns[i]->setup(&dispatchers[i]);
	}
    conns[MAPVIEWER_CONTROL_CONNECTION]->request_name("org.genivi.navigation.mapviewer.MapViewerControl");
    server=new MapViewerControl(*conns[MAPVIEWER_CONTROL_CONNECTION]);

#if LM
    if (ilm_init() != ILM_SUCCESS) {
        fprintf(stderr,"error on ilm_init\n");
    }
#endif
}
