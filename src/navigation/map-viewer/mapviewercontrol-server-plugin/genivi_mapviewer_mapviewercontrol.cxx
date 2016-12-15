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
#include <dbus-c++/glib-integration.h>
#include <math.h>
#include <unistd.h>
#include <stdlib.h>
#if LM
#include <ilm/ilm_client.h>
#include <ilm/ilm_client.h>
#include <ilm/ilm_control.h>
//Align with Qt Surfaces = 8000 + Layer.
#ifndef FSA_SURFACE
#define SURFACE_OFFSET 8000
#define FSA_SURFACE SURFACE_OFFSET + getpid()
#endif
#endif

#include "config.h"
#define USE_PLUGINS 1
#include "debug.h"
#include "plugin.h"
#include "item.h"
#include "config_.h"
#include "navit.h"
#include "event.h"
#include "point.h"
#include "graphics.h"
#include "coord.h"
#include "transform.h"
#include "map.h"
#include "mapset.h"
#include "callback.h"
#include "vehicle.h"
#include "attr.h"
#include "xmlconfig.h"
#include "layout.h"

#include <CommonAPI/CommonAPI.hpp>
#include <CommonTypes.hpp>
#include <NavigationTypes.hpp>
#include <MapViewerControlStubDefault.hpp>
#include <MapMatchedPositionProxy.hpp>
#include <RoutingProxy.hpp>
#include <navigationcore/SessionProxy.hpp>

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

using namespace v4::org::genivi::navigation::mapviewer;
using namespace v4::org::genivi::navigation::navigationcore;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

class MapViewerControlServerStub;
class MapMatchedPositionClientProxy;
class RoutingClientProxy;
class NavigationCoreSessionClientProxy;

static std::shared_ptr < CommonAPI::Runtime > runtime;
static NavigationTypes::Handle m_navigationcore_session;
static MapMatchedPositionClientProxy *mp_mapMatchedPositionClientProxy;
static RoutingClientProxy* mp_routingClientProxy;
static NavigationCoreSessionClientProxy* mp_navigationCoreSessionClientProxy;

class DisplayedRoute
{
	char *m_filename;
	std::vector <struct coord> m_coordinates;
	struct mapset *m_mapset;
	bool m_shown;

	void AddGeoCoordinateD(double lat, double lon);
    bool AddSegment(Routing::RouteSegment map);
	void WriteSegment(FILE *out);
	public:
	uint32_t m_handle;
	struct attr m_map;
    NavigationTypes::Handle RouteHandle();
	void Show();
	void Hide();
    DisplayedRoute(class MapViewerControlObj *mapviewer, uint8_t RouteSession, NavigationTypes::Handle RouteHandle, struct mapset *mapset);
	~DisplayedRoute();
};

class MapViewerControlObj
{
	public:
	struct attr m_navit,m_vehicle,m_graphics;
	struct mapset *m_mapset;
	uint32_t m_handle;
	double m_scrolldirection, m_scrollspeed;
	double m_rotationangle, m_rotationangleperframe;

	struct callback *m_postdraw_callback;
	struct callback *m_move_callback;
	bool m_force_draw;
    MapViewerControl::MapPerspective m_perspective;
	bool m_follow_car;
    MapViewerControlServerStub *mp_mapviewercontrol;
	std::vector<DisplayedRoute *> m_displayed_routes;
    struct point m_pan;
	int m_pan_action;

	void MoveMap(void);
    void SetFollowCarMode(NavigationTypes::Handle SessionHandle, bool active);
    void GetFollowCarMode(bool& active);
    void SetCameraHeadingAngle(NavigationTypes::Handle SessionHandle, double angle);
    void GetCameraHeadingAngle(double &angle);
    void SetCameraTiltAngle(NavigationTypes::Handle SessionHandle, double angle);
    void GetCameraTiltAngle(int32_t &angle);
    void SetCameraRollAngle(NavigationTypes::Handle SessionHandle, double angle);
    void GetCameraRollAngle(int32_t &angle);
    void SetCameraDistanceFromTargetPoint(NavigationTypes::Handle SessionHandle, double distance);
    void GetCameraDistanceFromTargetPoint(uint32_t &distance);
    void SetCameraHeight(NavigationTypes::Handle SessionHandle, double height);
    void GetCameraHeight(uint32_t &height);
    void SetCameraHeadingTrackUp(NavigationTypes::Handle SessionHandle);
    void SetMapViewPerspective(NavigationTypes::Handle SessionHandle, MapViewerControl::MapPerspective MapViewPerspectiveMode);
    void GetMapViewPerspective(MapViewerControl::MapPerspective &MapViewPerspectiveMode);
    void GetScaleList(std::vector< MapViewerControl::MapScale >& ScalesList);
    void SetMapViewScale(NavigationTypes::Handle SessionHandle, uint32_t ScaleID);
    void SetMapViewScaleByDelta(NavigationTypes::Handle SessionHandle, int16_t ScaleDelta);
    void GetMapViewScale(uint8_t& ScaleID, MapViewerControl::MapScaleType &IsMinMax);
    void GetMapViewType(MapViewerControl::MapViewType &MapViewType);
    void SetMapViewTheme(NavigationTypes::Handle SessionHandle, MapViewerControl::MapTheme mapViewTheme);
    void GetMapViewTheme(MapViewerControl::MapTheme &mapViewTheme);
    void SetTargetPoint(NavigationTypes::Handle SessionHandle, NavigationTypes::Coordinate3D target);
    void GetTargetPoint(NavigationTypes::Coordinate3D &target);
    void SetMapViewPan(NavigationTypes::Handle SessionHandle, MapViewerControl::PanAction panningAction, MapViewerControl::Pixel p);
    void GetMapViewPan(const int32_t &panningAction, MapViewerControl::Pixel &p);
    void SetMapViewRotation(NavigationTypes::Handle SessionHandle, double rotationAngle, double rotationAnglePerFrame);
    void GetMapViewRotation(int32_t& rotationAngle, int32_t& rotationAnglePerFrame);
    void SetMapViewBoundingBox(NavigationTypes::Handle SessionHandle, const NavigationTypes::Rectangle& boundingBox);
    void GetMapViewBoundingBox(NavigationTypes::Rectangle& boundingBox);
    void GetDisplayedRoutes(std::vector<MapViewerControl::DisplayedRoute> &displayedRoutes);
    void DisplayRoute(NavigationTypes::Handle SessionHandle, NavigationTypes::Handle RouteHandle, bool highlighted);
    void HideRoute(NavigationTypes::Handle SessionHandle, NavigationTypes::Handle RouteHandle);
    void ConvertPixelCoordsToGeoCoords(NavigationTypes::Handle SessionHandle, const std::vector<MapViewerControl::Pixel> &pixelCoordinates, std::vector<NavigationTypes::Coordinate2D> &GeoCoordinates);
    void ConvertGeoCoordsToPixelCoords(NavigationTypes::Handle SessionHandle, const std::vector<NavigationTypes::Coordinate2D> &geoCoordinates, std::vector<MapViewerControl::Pixel> &pixelCoordinates);
    MapViewerControlObj(MapViewerControlServerStub *mapviewercontrol, NavigationTypes::Handle handle, const MapViewerControl::Dimension &MapViewSize);
	~MapViewerControlObj();
};

static std::map<uint32_t, MapViewerControlObj *> mp_handles;

static void positionVehicleNavitUpdate(std::shared_ptr<MapMatchedPositionProxyDefault> pos, struct vehicle *v);

class  MapMatchedPositionClientProxy
{
    public:

    struct callback *mp_callback;
    MapViewerControlObj *m_mapviewerobj;
    std::shared_ptr<MapMatchedPositionProxyDefault> myServiceMapMatchedPosition;

    void connectToMapViewer(MapViewerControlObj *obj)
    {
        m_mapviewerobj=obj;
    }

    void connectToVehicle(struct vehicle *v)
    {
        mp_callback=callback_new_2(callback_cast(positionVehicleNavitUpdate), myServiceMapMatchedPosition, v);
    }

    MapMatchedPositionClientProxy(const std::string domain, const std::string instance)
    {
        myServiceMapMatchedPosition = runtime->buildProxy<MapMatchedPositionProxy>(domain, instance);

        while (!myServiceMapMatchedPosition->isAvailable()) {
            usleep(10);
        }
    }

    void setListeners()
    {
        myServiceMapMatchedPosition->getPositionUpdateEvent().subscribe([&](const std::vector<MapMatchedPosition::PositionItemKey>& changedValues) {
            positionUpdate(changedValues);});
    }

    void positionUpdate(const std::vector<MapMatchedPosition::PositionItemKey>& changedValues)
    {
        event_add_timeout(0, 0, mp_callback);
    }
};

static void positionVehicleNavitUpdate(std::shared_ptr<MapMatchedPositionProxyDefault> pos, struct vehicle *v)
{
    std::vector< MapMatchedPosition::PositionItemKey > valuesToReturn;
    CommonAPI::CallStatus status;
    MapMatchedPosition::getPositionError _error;
    MapMatchedPosition::PositionItemDict _position;
    valuesToReturn.push_back(MapMatchedPosition::PositionItemKey::LATITUDE);
    valuesToReturn.push_back(MapMatchedPosition::PositionItemKey::LONGITUDE);
    valuesToReturn.push_back(MapMatchedPosition::PositionItemKey::SPEED);
    valuesToReturn.push_back(MapMatchedPosition::PositionItemKey::HEADING);

    pos->getPosition(valuesToReturn,status,_error,_position);
    if (_position.find(MapMatchedPosition::PositionItemKey::SPEED) != _position.end()) {
        struct attr position_speed={attr_position_speed};
        double speed;
        position_speed.u.numd=&speed;
        speed=_position[MapMatchedPosition::PositionItemKey::SPEED].get<double>();
        vehicle_set_attr(v, &position_speed);
    }
    if (_position.find(MapMatchedPosition::PositionItemKey::HEADING) != _position.end()) {
        struct attr position_direction={attr_position_direction};
        double direction;
        position_direction.u.numd=&direction;
        direction=_position[MapMatchedPosition::PositionItemKey::HEADING].get<double>();
        vehicle_set_attr(v, &position_direction);
    }
    if (_position.find(MapMatchedPosition::PositionItemKey::LATITUDE) != _position.end() && _position.find(MapMatchedPosition::PositionItemKey::LONGITUDE) != _position.end()) {
        struct attr position_coord_geo={attr_position_coord_geo};
        struct coord_geo g;
        position_coord_geo.u.coord_geo=&g;
        g.lat=_position[MapMatchedPosition::PositionItemKey::LATITUDE].get<double>();
        g.lng=_position[MapMatchedPosition::PositionItemKey::LONGITUDE].get<double>();
        dbg(lvl_debug,"update %f %f\n",g.lat,g.lng);
        vehicle_set_attr(v, &position_coord_geo);
    }
}

class RoutingClientProxy
{
    public:

    MapViewerControlObj *m_mapviewerobj;
    std::shared_ptr<RoutingProxyDefault> myServiceRouting;

    RoutingClientProxy(const std::string & domain, const std::string & instance)
    {
        myServiceRouting = runtime->buildProxy<RoutingProxy>(domain, instance);
        while (!myServiceRouting->isAvailable()) {
            usleep(10);
        }
    }

    void connectToMapViewer(MapViewerControlObj *obj)
    {
        m_mapviewerobj=obj;
    }

    void setListeners()
    {
        myServiceRouting->getRouteCalculationFailedEvent().subscribe([&](const NavigationTypes::Handle& routeHandle, const Routing::CalculationError& errorCode, const Routing::UnfullfilledRoutePreference& unfullfilledPreferences) {
            routeCalculationFailed(routeHandle,errorCode,unfullfilledPreferences);});
        myServiceRouting->getRouteCalculationSuccessfulEvent().subscribe([&](const NavigationTypes::Handle& routeHandle, const Routing::UnfullfilledRoutePreference& unfullfilledPreferences) {
            routeCalculationSuccessful(routeHandle,unfullfilledPreferences);});
    }

    void routeCalculationFailed(const NavigationTypes::Handle& routeHandle, const Routing::CalculationError& errorCode, const Routing::UnfullfilledRoutePreference& unfullfilledPreferences)
    {
        std::vector<DisplayedRoute *>::iterator it;

        for (it=m_mapviewerobj->m_displayed_routes.begin() ; it < m_mapviewerobj->m_displayed_routes.end(); it++ ) {
            if (*it && (*it)->m_handle == routeHandle) {
                (*it)->Hide();
            }
        }
    }

    void routeCalculationSuccessful(const NavigationTypes::Handle& RouteHandle, const Routing::UnfullfilledRoutePreference& unfullfilledPreferences)
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

};

class  NavigationCoreSessionClientProxy
{
    public:
    std::shared_ptr<SessionProxyDefault> myServiceNavigationCoreSession;

    NavigationCoreSessionClientProxy(const std::string domain, const std::string instance)
    {
        myServiceNavigationCoreSession = runtime->buildProxy<SessionProxy>(domain, instance);

        while (!myServiceNavigationCoreSession->isAvailable()) {
            usleep(10);
        }
    }
};

class  MapViewerControlServerStub : public MapViewerControlStubDefault
{
	public:
#define MAX_SESSION_HANDLE 256
#define FIRST_SESSION_HANDLE 1

    MapViewerControlServerStub()
	{
        mp_handles[FIRST_SESSION_HANDLE]=NULL;
        m_version.setVersionMajor(3);
        m_version.setVersionMinor(0);
        m_version.setVersionMicro(0);
        m_version.setDate("21-01-2014");

    }

    /**
     * description: getVersion = This method returns the API version implemented by the server
     *   application
     */
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply){
        _reply(m_version);
    }

    /**
     * description: createMapViewInstance = This method creates a new map instance
     */
    void createMapViewInstance(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, MapViewerControl::Dimension _mapViewSize, MapViewerControl::MapViewType _mapViewType, createMapViewInstanceReply_t _reply)
    {
        MapViewerControl::createMapViewInstanceError _error = MapViewerControl::createMapViewInstanceError::OK;
        NavigationTypes::Handle  _mapViewInstanceHandle=0;
        dbg(lvl_debug,"enter\n");
        if (_mapViewType != MapViewerControl::MapViewType::MAIN_MAP)
            _error = MapViewerControl::createMapViewInstanceError::MAPVIEWERCONTROL_ERROR_NOMOREMAPVIEWINSTANCEHANDLES;
        else {
            _mapViewInstanceHandle=FIRST_SESSION_HANDLE;
            while ((mp_handles.count(_mapViewInstanceHandle)>0 ) && (mp_handles[_mapViewInstanceHandle] != NULL)) {
                _mapViewInstanceHandle++;
                if (_mapViewInstanceHandle == MAX_SESSION_HANDLE)
                    _error = MapViewerControl::createMapViewInstanceError::MAPVIEWERCONTROL_ERROR_NOMOREMAPVIEWINSTANCEHANDLES;
            }
            mp_handles[_mapViewInstanceHandle]=new MapViewerControlObj(this, _mapViewInstanceHandle, _mapViewSize);
        }
        _reply(_error,_mapViewInstanceHandle);
	}

    /**
     * description: releaseMapViewInstance = This method releases (i.e. destroys) a given map
     *   instance. Only invisible map instances can be released
     */
    void releaseMapViewInstance(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, releaseMapViewInstanceReply_t _reply)
	{
        MapViewerControl::releaseMapViewInstanceError _error = MapViewerControl::releaseMapViewInstanceError::OK;
        std::map<uint32_t, MapViewerControlObj *>::iterator iter = mp_handles.find(_mapViewInstanceHandle);
        if (iter != mp_handles.end())
        {
            MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
            delete(obj); //delete the navit mapviewer instance
            //and remove the handle from the dictionary too
            mp_handles.erase(iter);
        }
        else {
           _error = MapViewerControl::releaseMapViewInstanceError::MAPVIEWERCONTROL_ERROR_MAPVIEWINSTANCENOTAVAILABLE;
        }

        _reply(_error);
	}

    /**
     * description: getMapViewType = This method returns the map type of a map instance as it was
     *   set using CreateMapViewInstance
     */
    void getMapViewType(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewTypeReply_t _reply){
        MapViewerControl::MapViewType _mapViewType=MapViewerControl::MapViewType::INVALID;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewType(_mapViewType);
        _reply(_mapViewType);

    }

    /**
     * description: getSupportedMapViewTypes = This method retrieves the supported map view types
     */
    void getSupportedMapViewTypes(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedMapViewTypesReply_t _reply){
        std::vector<MapViewerControl::MapViewType> _mapViewTypeList;
        _mapViewTypeList.push_back(MapViewerControl::MapViewType::MAIN_MAP);
        _reply(_mapViewTypeList);
    }

    /**
     * description: setTargetPoint = This method sets the position of the point the camera is
     *   always aimed at
     */
    void setTargetPoint(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, ::v4::org::genivi::navigation::NavigationTypes::Coordinate3D _targetPoint, setTargetPointReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetTargetPoint(_sessionHandle, _targetPoint);
        _reply();
    }

    /**
     * description: getTargetPoint = This method retrieves the target point position
     */
    void getTargetPoint(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getTargetPointReply_t _reply){
        NavigationTypes::Coordinate3D _targetPoint;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetTargetPoint(_targetPoint);
        _reply(_targetPoint);

    }

    /**
     * description: setFollowCarMode = This method sets the FollowCar mode
     */
    void setFollowCarMode(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, bool _followCarMode, setFollowCarModeReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetFollowCarMode(_sessionHandle, _followCarMode);
        _reply();
    }

    /**
     * description: getFollowCarMode = This method returns the current FollowCar-mode
     */
    void getFollowCarMode(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getFollowCarModeReply_t _reply){
        bool _followCarMode=false;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetFollowCarMode(_followCarMode);
        _reply(_followCarMode);

    }

    /**
     * description: setCameraPosition = This method sets the coordinates of the point at which the
     *   camera must be positioned
            Note: the camera heading will be automatically set
     *   in such a way, that the camera is aimed at the view point
     */
    void setCameraPosition(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, ::v4::org::genivi::navigation::NavigationTypes::Coordinate3D _position, setCameraPositionReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getCameraPosition = This method returns the coordinates of the point at which
     *   the camera is positioned
     */
    void getCameraPosition(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getCameraPositionReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setCameraHeadingAngle = This method sets the map view heading angle
            Note: the
     *   camera position will be automatically set in such a way, that it looks at the
     *   currently selected target point
     */
    void setCameraHeadingAngle(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, int32_t _heading, setCameraHeadingAngleReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetCameraHeadingAngle(_sessionHandle, _heading);
        _reply();
    }

    /**
     * description: setCameraHeadingToTarget = This method sets the camera heading in such a way,
     *   that the camera always looks at a given target
     */
    void setCameraHeadingToTarget(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, ::v4::org::genivi::navigation::NavigationTypes::Coordinate2D _target, setCameraHeadingToTargetReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setCameraHeadingTrackUp = This method sets the camera heading in such a way,
     *   that the camera always looks in the direction in which the car is moving
     */
    void setCameraHeadingTrackUp(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, setCameraHeadingTrackUpReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetCameraHeadingTrackUp(_sessionHandle);
        _reply();
    }

    /**
     * description: getCameraHeading = This method returns the current camera heading
     */
    void getCameraHeading(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getCameraHeadingReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setCameraTiltAngle = This method sets the camera tilt angle
     */
    void setCameraTiltAngle(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, int32_t _tilt, setCameraTiltAngleReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetCameraTiltAngle(_sessionHandle, _tilt);
        _reply();
    }

    /**
     * description: getCameraTiltAngle = This method returns the camera tilt angle
     */
    void getCameraTiltAngle(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getCameraTiltAngleReply_t _reply){
        int32_t _tilt;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetCameraTiltAngle(_tilt);
        _reply(_tilt);

    }

    /**
     * description: setCameraRollAngle = This method sets the camera roll angle
     */
    void setCameraRollAngle(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, int32_t _roll, setCameraRollAngleReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetCameraRollAngle(_sessionHandle, _roll);
        _reply();
    }

    /**
     * description: getCameraRollAngle = This method returns the camera roll angle
     */
    void getCameraRollAngle(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getCameraRollAngleReply_t _reply){
        int32_t _roll;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetCameraRollAngle(_roll);
        _reply(_roll);

    }

    /**
     * description: setCameraDistanceFromTargetPoint = This method sets the mode and the camera
     *   distance from the target point
     */
    void setCameraDistanceFromTargetPoint(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, uint32_t _distance, setCameraDistanceFromTargetPointReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetCameraDistanceFromTargetPoint(_sessionHandle, _distance);
        _reply();
    }

    /**
     * description: getCameraDistanceFromTargetPoint = This method gets the mode and the camera
     *   distance from the target point
     */
    void getCameraDistanceFromTargetPoint(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getCameraDistanceFromTargetPointReply_t _reply){
        uint32_t _distance=0;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetCameraDistanceFromTargetPoint(_distance);
        _reply(_distance);
    }

    /**
     * description: setMapViewScaleMode = This method sets the scaling mode.
     */
    void setMapViewScaleMode(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, MapViewerControl::MapScaleMode _scaleMode, setMapViewScaleModeReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getMapViewScaleMode = This method gets the scaling mode.
     */
    void getMapViewScaleMode(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewScaleModeReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getSupportedMapViewScaleModes = This method gets the supported scaling modes.
     */
    void getSupportedMapViewScaleModes(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getSupportedMapViewScaleModesReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setCameraHeight = This method sets the camera height
     */
    void setCameraHeight(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, uint32_t _height, setCameraHeightReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetCameraHeight(_sessionHandle, _height);
        _reply();
    }

    /**
     * description: getCameraHeight = This method gets the camera height
     */
    void getCameraHeight(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getCameraHeightReply_t _reply){
        uint32_t _height;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetCameraHeight(_height);
        _reply(_height);
    }

    /**
     * description: setMapViewPerspective = This method sets the map perspective
     */
    void setMapViewPerspective(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, MapViewerControl::MapPerspective _perspective, setMapViewPerspectiveReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetMapViewPerspective(_sessionHandle, _perspective);
        _reply();
    }

    /**
     * description: getMapViewPerspective = This method returns the current map perspective
     */
    void getMapViewPerspective(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewPerspectiveReply_t _reply){
        MapViewerControl::MapPerspective _perspective=MapViewerControl::MapPerspective::INVALID;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewPerspective(_perspective);
        _reply(_perspective);
    }

    /**
     * description: getSupportedMapViewPerspectives = This method retrieves the supported mapview
     *   perspectives
     */
    void getSupportedMapViewPerspectives(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedMapViewPerspectivesReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setMapViewObjectVisibility = This method specifies the type of objects to show
     *   on the map.
     */
    void setMapViewObjectVisibility(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, MapViewerControl::MapObjectVisibility _objectVisibilityList, setMapViewObjectVisibilityReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getMapViewObjectVisibility = This method gets the type of objects shown on the
     *   map.
     */
    void getMapViewObjectVisibility(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewObjectVisibilityReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getSupportedMapViewObjectVisibilities = This method gets the supported object
     *   visibilities.
     */
    void getSupportedMapViewObjectVisibilities(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getSupportedMapViewObjectVisibilitiesReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getScaleList = This method returns a list of supported map scales
     */
    void getScaleList(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getScaleListReply_t _reply){
        std::vector<MapViewerControl::MapScale> _scaleList;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetScaleList(_scaleList);
        _reply(_scaleList);
    }

    /**
     * description: setMapViewScale = This method sets the map scale by specifying a ScaleID
     */
    void setMapViewScale(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, uint16_t _scaleID, setMapViewScaleReply_t _reply){
        dbg(lvl_debug,"enter\n");
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else  {
            obj->SetMapViewScale(_sessionHandle, _scaleID);
            uint8_t current_scale;
            MapViewerControl::MapScaleType is_min_max;
            obj->GetMapViewScale(current_scale,is_min_max);
            fireMapViewScaleChangedSelective(_mapViewInstanceHandle,current_scale,is_min_max);
        }
        _reply();
    }

    /**
     * description: setMapViewScaleByDelta = This method sets the map scale by specifying a delta
     *   value with respect to the currently set ScaleID
     */
    void setMapViewScaleByDelta(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, int16_t _scaleDelta, setMapViewScaleByDeltaReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else {
            obj->SetMapViewScaleByDelta(_sessionHandle, _scaleDelta);
            uint8_t current_scale;
            MapViewerControl::MapScaleType is_min_max;
            obj->GetMapViewScale(current_scale,is_min_max);
            fireMapViewScaleChangedSelective(_mapViewInstanceHandle,current_scale,is_min_max);
        }
        _reply();
    }

    /**
     * description: setMapViewScaleByMetersPerPixel = This method sets the map scale by specifying
     *   the number of meters that a pixel represents
     */
    void setMapViewScaleByMetersPerPixel(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, double _metersPerPixel, setMapViewScaleByMetersPerPixelReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getMapViewScale = This method returns the currently used map scale
     */
    void getMapViewScale(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewScaleReply_t _reply){
        uint8_t _scaleID=0;
        MapViewerControl::MapScaleType _isMinMax=MapViewerControl::MapScaleType::INVALID;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewScale(_scaleID, _isMinMax);
        _reply(_scaleID,_isMinMax);
    }

    /**
     * description: setMapViewBoundingBox = This method sets the map bounding box
     */
    void setMapViewBoundingBox(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, ::v4::org::genivi::navigation::NavigationTypes::Rectangle _boundingBox, setMapViewBoundingBoxReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetMapViewBoundingBox(_sessionHandle, _boundingBox);
        _reply();
    }

    /**
     * description: getMapViewBoundingBox = This method returns the bounding box of a given map
     *   instance
     */
    void getMapViewBoundingBox(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewBoundingBoxReply_t _reply){
        NavigationTypes::Rectangle _boundingBox;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewBoundingBox(_boundingBox);
        _reply(_boundingBox);
    }

    /**
     * description: setMapViewSaveArea = This methods defines the area that the HMI guarantees not
     *   to cover with other windows or user interface elements
     */
    void setMapViewSaveArea(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, MapViewerControl::MapViewArea _saveArea, setMapViewSaveAreaReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getMapViewSaveArea = This methods defines the area that the HMI guarantees not
     *   to cover with other windows or user interface elements
     */
    void getMapViewSaveArea(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewSaveAreaReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setMapViewPan = This method pans a given map instance
     */
    void setMapViewPan(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, MapViewerControl::PanAction _panningAction, std::vector<MapViewerControl::Pixel> _pixelCoordinates, setMapViewPanReply_t _reply){
        MapViewerControl::Pixel pixel;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else {
            if (_pixelCoordinates.size())
            {
                pixel = _pixelCoordinates.at(0);
                obj->SetMapViewPan(_sessionHandle, _panningAction, pixel);
            }
        }
        _reply();
    }

    /**
     * description: getMapViewPan
     */
    void getMapViewPan(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, MapViewerControl::PanAction _valueToReturn, getMapViewPanReply_t _reply){
        MapViewerControl::Pixel pixel;
        std::vector<MapViewerControl::Pixel> _pixelCoordinates;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewPan(_valueToReturn, pixel); //limited to one pixel coordinate
        _pixelCoordinates.push_back(pixel);
        _reply(_pixelCoordinates);
    }

    /**
     * description: setMapViewRotation = This method rotates the map
     */
    void setMapViewRotation(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, int32_t _rotationAngle, int32_t _rotationAnglePerSecond, setMapViewRotationReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetMapViewRotation(_sessionHandle, _rotationAngle, _rotationAnglePerSecond);
        _reply();
    }

    /**
     * description: getMapViewRotation = This method is particularly interesting for debugging
     *   purposes
     */
    void getMapViewRotation(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewRotationReply_t _reply){
        int32_t _rotationAngle=0;
        int32_t _rotationAnglePerFrame=0;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewRotation(_rotationAngle, _rotationAnglePerFrame);
        _reply(_rotationAngle,_rotationAnglePerFrame);
    }

    /**
     * description: setMapViewVisibilityMode = This method sets the current visibility mode
     */
    void setMapViewVisibilityMode(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, MapViewerControl::Visibility _visibilityMode, setMapViewVisibilityModeReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getMapViewVisibilityMode = This method returns the current visibility mode
     */
    void getMapViewVisibilityMode(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewVisibilityModeReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getSupportedMapViewVisibilityModes = This method retrieves the supported
     *   mapview visibility modes
     */
    void getSupportedMapViewVisibilityModes(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedMapViewVisibilityModesReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setMapViewPerformanceLevel = This method sets the perfomance level of a given
     *   map instance
     */
    void setMapViewPerformanceLevel(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, MapViewerControl::Level _performanceLevel, setMapViewPerformanceLevelReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getMapViewPerformanceLevel = This method returns the perfomance level of a
     *   given map instance
     */
    void getMapViewPerformanceLevel(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewPerformanceLevelReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getSupportedMapViewPerformanceLevels = This method retrieves the supported
     *   perfomance levels
     */
    void getSupportedMapViewPerformanceLevels(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedMapViewPerformanceLevelsReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: displayRoute = This method visualizes one of the calculated routes
     */
    void displayRoute(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, bool _highlighted, displayRouteReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->DisplayRoute(_sessionHandle, _routeHandle, _highlighted);
        _reply();
    }

    /**
     * description: hideRoute = This method hides one of the visible routes
     */
    void hideRoute(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _routeHandle, hideRouteReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->HideRoute(_sessionHandle, _routeHandle);
        _reply();
    }

    /**
     * description: getDisplayedRoutes = This method returns a list of displayed routes
     */
    void getDisplayedRoutes(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getDisplayedRoutesReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        std::vector<MapViewerControl::DisplayedRoute> _displayedRoutes;
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetDisplayedRoutes(_displayedRoutes);
        _reply(_displayedRoutes);
    }

    /**
     * description: getPoiCategoriesVisible = Get the set of POI categories displayed on the map.
     */
    void getPoiCategoriesVisible(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getPoiCategoriesVisibleReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setPoiCategoriesVisible = Add POI categories to the set of POI categories
     *   displayed on the map.
                       Any specified category that until now
     *   was displayed with scale limits is now displayed without limits.
     */
    void setPoiCategoriesVisible(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _poiCategoryIds, setPoiCategoriesVisibleReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setPoiCategoriesVisible = Add POI categories to the set of POI categories
     *   displayed on the map, where the POI's are only displayed in a specific range
     *   of scales.
                       Any specified category that until now was
     *   displayed without scale limits is now displayed with limits.
     */
    void setPoiCategoriesVisibleWithinLimits(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _poiCategoryIds, uint8_t _minScaleID, uint8_t _maxScaleID, setPoiCategoriesVisibleWithinLimitsReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setPoiCategoriesNotVisible = Remove POI categories from the set of POI
     *   categories displayed on the map.
     */
    void setPoiCategoriesNotVisible(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, std::vector< ::v4::org::genivi::CommonTypes::CategoryID> _poiCategoryIds, setPoiCategoriesNotVisibleReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setTrafficIncidentsVisibility = Set the visibility of Traffic Incidents on the
     *   map.
     */
    void setTrafficIncidentsVisibility(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, bool _visible, setTrafficIncidentsVisibilityReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: setMapViewTheme = This method configures the theme of a given map view instance
     */
    void setMapViewTheme(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, MapViewerControl::MapTheme _mapViewTheme, setMapViewThemeReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->SetMapViewTheme(_sessionHandle, _mapViewTheme);
        _reply();
    }

    /**
     * description: getMapViewTheme = This method returns the current theme of a given map view
     *   instance
     */
    void getMapViewTheme(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getMapViewThemeReply_t _reply){
        MapViewerControl::MapTheme _mapViewTheme=MapViewerControl::MapTheme::INVALID;
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->GetMapViewTheme(_mapViewTheme);
        _reply(_mapViewTheme);

    }

    /**
     * description: getSupportedMapViewThemes = This method retrieves the supported mapview themes
     */
    void getSupportedMapViewThemes(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedMapViewThemesReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: convertPixelCoordsToGeoCoords = This method converts pixel coordinates to
     *   geographical coordinates
     */
    void convertPixelCoordsToGeoCoords(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, std::vector<MapViewerControl::Pixel> _pixelCoordinates, convertPixelCoordsToGeoCoordsReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        std::vector< ::v4::org::genivi::navigation::NavigationTypes::Coordinate2D> _geoCoordinates;
        MapViewerControl::convertPixelCoordsToGeoCoordsError _error = MapViewerControl::convertPixelCoordsToGeoCoordsError::OK;
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->ConvertPixelCoordsToGeoCoords(_sessionHandle, _pixelCoordinates, _geoCoordinates);
        _reply(_error,_geoCoordinates);
    }

    /**
     * description: convertGeoCoordsToPixelCoords = This method converts geographical coordinates
     *   into pixel coordinates
     */
    void convertGeoCoordsToPixelCoords(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, std::vector< ::v4::org::genivi::navigation::NavigationTypes::Coordinate2D> _geoCoordinates, convertGeoCoordsToPixelCoordsReply_t _reply){
        MapViewerControlObj *obj=mp_handles[_mapViewInstanceHandle];
        std::vector<MapViewerControl::Pixel> _pixelCoordinates;
        MapViewerControl::convertGeoCoordsToPixelCoordsError _error = MapViewerControl::convertGeoCoordsToPixelCoordsError::OK;
        if (!obj)
            throw DBus::ErrorInvalidArgs("Invalid mapviewinstance handle");
        else obj->ConvertGeoCoordsToPixelCoords(_sessionHandle, _geoCoordinates, _pixelCoordinates);
        _reply(_error,_pixelCoordinates);
    }

    /**
     * description: displayCustomElements = This method visualizes a set of custom elements on the
     *   map
     */
    void displayCustomElements(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, std::vector<MapViewerControl::CustomElement> _customElements, displayCustomElementsReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: hideCustomElements = This method hides a set of custom elements which were
     *   visualized by DisplayCustomElements
     */
    void hideCustomElements(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, std::vector< ::v4::org::genivi::navigation::NavigationTypes::Handle> _customElementhandles, hideCustomElementsReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: getDisplayedCustomElements = This method retrieves the visualized custom
     *   elements on the map
     */
    void getDisplayedCustomElements(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, getDisplayedCustomElementsReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

    /**
     * description: selectElementsOnMap = This method selects elements on the map view which are at
     *   the position specified by user input
     */
    void selectElementsOnMap(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _mapViewInstanceHandle, MapViewerControl::Pixel _pixelCoordinate, std::vector<MapViewerControl::SelectableMapType> _selectableTypes, uint16_t _maxNumberOfSelectedElements, selectElementsOnMapReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }


private:
    CommonTypes::Version m_version;

};

void
MapViewerControlObj::SetMapViewPerspective(NavigationTypes::Handle SessionHandle, MapViewerControl::MapPerspective MapViewPerspectiveMode)
{
	if (m_perspective != MapViewPerspectiveMode) {
		m_perspective=MapViewPerspectiveMode;
		struct transformation *trans=navit_get_trans(m_navit.u.navit);
		switch (m_perspective) {
        case MapViewerControl::MapPerspective::PERSPECTIVE_2D:
			transform_set_pitch(trans, 0);
			break;
        case MapViewerControl::MapPerspective::PERSPECTIVE_3D:
			transform_set_pitch(trans, 40);
			break;
		}
		navit_draw_async(m_navit.u.navit, 1);
	}
}

void
MapViewerControlObj::GetMapViewPerspective(MapViewerControl::MapPerspective& MapViewPerspectiveMode)
{
	MapViewPerspectiveMode=m_perspective;
}

void
MapViewerControlObj::GetScaleList(std::vector<MapViewerControl::MapScale> &ScalesList)
{
	throw DBus::ErrorNotSupported("Not yet supported");
}

void
MapViewerControlObj::SetMapViewScale(NavigationTypes::Handle SessionHandle, uint32_t ScaleID)
{
	long scale=1 << ScaleID;
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	transform_set_scale(trans, scale);
	navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::SetMapViewScaleByDelta(NavigationTypes::Handle SessionHandle, int16_t ScaleDelta)
{
    if (!ScaleDelta)
		throw DBus::ErrorInvalidArgs("ScaleDelta must not be 0");
    else {
        if (ScaleDelta < 0)
            navit_zoom_out(m_navit.u.navit,1 << (-ScaleDelta),NULL);
        else navit_zoom_in(m_navit.u.navit,1 << ScaleDelta,NULL);
    }
}

void
MapViewerControlObj::GetMapViewScale(uint8_t& ScaleID, MapViewerControl::MapScaleType &IsMinMax)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	long scale=transform_get_scale(trans);
    if (scale >= 2097152)
        IsMinMax=MapViewerControl::MapScaleType::MAX;
    else {
        if (scale <= 1) {
            IsMinMax=MapViewerControl::MapScaleType::MIN;
        } else {
            IsMinMax=MapViewerControl::MapScaleType::MID;
            ScaleID=0;
            while (scale > 1) { //strange code here, to be investigated ?
                scale >>=1;
                ScaleID++;
            }
        }
    }

}

void
MapViewerControlObj::GetMapViewType(MapViewerControl::MapViewType& MapViewType)
{
    MapViewType=MapViewerControl::MapViewType::MAIN_MAP;
}

void
MapViewerControlObj::SetMapViewTheme(NavigationTypes::Handle SessionHandle, MapViewerControl::MapTheme mapViewTheme)
{
	struct attr layout,name;
	struct attr_iter *iter;
	const char *layout_name=NULL;
    dbg(lvl_debug,"Theme %d\n",mapViewTheme);
	switch (mapViewTheme) {
    case MapViewerControl::MapTheme::THEME_1:
		layout_name="Car";
		break;
    case MapViewerControl::MapTheme::THEME_2:
		layout_name="Car-dark";
		break;
	default:
        dbg(lvl_debug,"Invalid mapViewTheme\n");
		throw DBus::ErrorInvalidArgs("Invalid mapViewTheme");
	}
	iter=navit_attr_iter_new();
	while (navit_get_attr(m_navit.u.navit, attr_layout, &layout, iter)) {
        dbg(lvl_debug,"layout\n");
		if (!layout_get_attr(layout.u.layout, attr_name, &name, NULL)) {
			navit_attr_iter_destroy(iter);
			throw DBus::ErrorFailed("Internal error: Failed to get layout name");
		}
        dbg(lvl_debug,"%s vs %s\n",name.u.str,layout_name);
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
MapViewerControlObj::GetMapViewTheme(MapViewerControl::MapTheme& mapViewTheme)
{
	struct attr layout,name;
	if (!navit_get_attr(m_navit.u.navit, attr_layout, &layout, NULL))
		throw DBus::ErrorFailed("Internal error: Failed to get map layout");
	if (!layout_get_attr(layout.u.layout, attr_name, &name, NULL)) 
		throw DBus::ErrorFailed("Internal error: Failed to get layout name");
    dbg(lvl_debug,"name %s\n",name.u.str);
	if (!strcmp(name.u.str,"Car-dark"))
        mapViewTheme=MapViewerControl::MapTheme::THEME_2;
	else
        mapViewTheme=MapViewerControl::MapTheme::THEME_1;
}

void
MapViewerControlObj::SetFollowCarMode(NavigationTypes::Handle SessionHandle, bool active)
{
	struct attr follow={attr_follow};
	m_follow_car=active;
	if (active)
		follow.u.num=1;
	else
		follow.u.num=100000;
    dbg(lvl_debug,"setting follow to %d\n",(int) follow.u.num);
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
MapViewerControlObj::SetCameraHeadingAngle(NavigationTypes::Handle SessionHandle, double angle)
{
	struct attr orientation={attr_orientation};
	orientation.u.num=angle;
	navit_set_attr(m_navit.u.navit, &orientation);
	navit_draw_async(m_navit.u.navit, 1);
}

void
MapViewerControlObj::GetCameraHeadingAngle(double &angle)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	angle=transform_get_yaw(trans);
}

void
MapViewerControlObj::SetCameraTiltAngle(NavigationTypes::Handle SessionHandle, double angle)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	transform_set_pitch(trans, angle);
	navit_draw(m_navit.u.navit);
	
}

void
MapViewerControlObj::GetCameraTiltAngle(int32_t &angle)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	angle=transform_get_pitch(trans);
}

void
MapViewerControlObj::SetCameraRollAngle(NavigationTypes::Handle SessionHandle, double angle)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	transform_set_roll(trans, angle);
	navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::GetCameraRollAngle(int32_t &angle)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	angle=transform_get_roll(trans);
}

void
MapViewerControlObj::SetCameraDistanceFromTargetPoint(NavigationTypes::Handle SessionHandle, double distance)
{
	struct transformation *t=navit_get_trans(m_navit.u.navit);
	transform_set_distance(t, distance);
    dbg(lvl_debug,"distance %f\n",distance);
	transform_set_scales(t, 100, 100, 100 << 8);
	navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::GetCameraDistanceFromTargetPoint(uint32_t &distance)
{
	struct transformation *t=navit_get_trans(m_navit.u.navit);
	distance=transform_get_distance(t);
}

void
MapViewerControlObj::SetCameraHeight(NavigationTypes::Handle SessionHandle, double height)
{
	struct transformation *t=navit_get_trans(m_navit.u.navit);
	double distance=transform_get_distance(t);
	if (height > distance || height < -distance) 
		throw DBus::ErrorInvalidArgs("Height > Distance");
	double angle=acos(height/distance)*180.0/M_PI;
	transform_set_pitch(t, angle);
    dbg(lvl_debug,"distance %f angle %f height %f\n",distance,angle,height);
	navit_draw(m_navit.u.navit);
}

void
MapViewerControlObj::GetCameraHeight(uint32_t &height)
{
	struct transformation *t=navit_get_trans(m_navit.u.navit);
	double distance=transform_get_distance(t);
	double angle=transform_get_pitch(t);
	height=cos(angle*M_PI/180)*distance;
    dbg(lvl_debug,"distance %f angle %f height %f\n",distance,angle,height);
}

void
MapViewerControlObj::SetCameraHeadingTrackUp(NavigationTypes::Handle SessionHandle)
{
	struct attr orientation={attr_orientation};
	orientation.u.num=-1;
	navit_set_attr(m_navit.u.navit, &orientation);
	navit_draw_async(m_navit.u.navit, 1);
}

void
MapViewerControlObj::SetTargetPoint(NavigationTypes::Handle SessionHandle, NavigationTypes::Coordinate3D target)
{
	struct coord_geo g;
	struct attr center={attr_center};
	center.u.coord_geo=&g;
    g.lat=target.getLatitude();
    g.lng=target.getLongitude();
	navit_set_attr(m_navit.u.navit, &center);
	navit_draw_async(m_navit.u.navit, 1);
}

void
MapViewerControlObj::GetTargetPoint(NavigationTypes::Coordinate3D&target)
{
	struct attr center;
	if (!navit_get_attr(m_navit.u.navit, attr_center, &center, NULL) || !center.u.coord_geo) 
		throw DBus::ErrorFailed("Internal error: Failed to get center attribute");
    target.setLatitude(center.u.coord_geo->lat);
    target.setLongitude(center.u.coord_geo->lng);
    target.setAltitude(0);
}

void
MapViewerControlObj::MoveMap(void)
{
	if (m_scrollspeed || m_rotationangleperframe || m_force_draw) {
		int w,h;
		double refresh_time=0.3; // Time needed to redraw map
		double r=m_scrollspeed*refresh_time;
		struct point p;
		struct transformation *t=navit_get_trans(m_navit.u.navit);
		if (m_rotationangleperframe) {
			int yaw=transform_get_yaw(t);
			int delta=((int)(m_rotationangle+0.5)-yaw)%360;
			if (delta > 180)
				delta-=180;
			if (delta < -180)
				delta+=180;
			if (delta < 0 && delta < -m_rotationangleperframe)
				delta=-m_rotationangleperframe;
			if (delta > 0 && delta > m_rotationangleperframe)
				delta=m_rotationangleperframe;
			if (delta)
				transform_set_yaw(t, yaw+delta);
			else
				m_rotationangleperframe=0;
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

void
MapViewerControlObj::SetMapViewPan(NavigationTypes::Handle SessionHandle, MapViewerControl::PanAction panningAction, MapViewerControl::Pixel p)
{
    struct transformation *tr;
    struct coord co,cn,c,*cp;
    struct point pan;
    SetFollowCarMode(SessionHandle, false);
    dbg(lvl_debug,"enter %d\n",panningAction);
    switch(panningAction) {
    case MapViewerControl::PanAction::PAN_START:
	break;
    case MapViewerControl::PanAction::PAN_END:
	tr=navit_get_trans(m_navit.u.navit);
	transform_reverse(tr, &m_pan, &co);
    pan.x=p.getX();
    pan.y=p.getY();
	transform_reverse(tr, &pan, &cn);
    dbg(lvl_debug,"%d,%d - %d,%d\n",m_pan.x,m_pan.y,pan.x,pan.y);
	cp=transform_get_center(tr);
	c.x=cp->x+co.x-cn.x;
	c.y=cp->y+co.y-cn.y;
	transform_set_center(tr, &c);
	navit_draw(m_navit.u.navit);
    default:
	return;
    }
    m_pan_action=panningAction;
    m_pan.x=p.getX();
    m_pan.y=p.getY();
}

void
MapViewerControlObj::GetMapViewPan(const int32_t& panningAction, MapViewerControl::Pixel& p)
{
    p.setX(m_pan.x);
    p.setY(m_pan.y);
}

void
MapViewerControlObj::SetMapViewRotation(NavigationTypes::Handle SessionHandle, double rotationAngle, double rotationAnglePerFrame)
{
	m_rotationangle=rotationAngle;
	m_rotationangleperframe=rotationAnglePerFrame;
    SetFollowCarMode(SessionHandle, false);
	MoveMap();

}

void
MapViewerControlObj::GetMapViewRotation(int32_t& rotationAngle, int32_t& rotationAnglePerFrame)
{
	rotationAngle=m_rotationangle;
	rotationAnglePerFrame=m_rotationangleperframe;
}

void
MapViewerControlObj::SetMapViewBoundingBox(NavigationTypes::Handle SessionHandle, const NavigationTypes::Rectangle& boundingBox)
{
	struct coord_rect r;
	struct coord_geo g;
    SetFollowCarMode(SessionHandle, false);
    g.lat=boundingBox.getTopLeft().getLatitude();
    g.lng=boundingBox.getTopLeft().getLongitude();
    transform_from_geo(projection_mg, &g, &r.lu);
    g.lat=boundingBox.getBottomRight().getLatitude();
    g.lng=boundingBox.getBottomRight().getLongitude();
    transform_from_geo(projection_mg, &g, &r.rl);
    dbg(lvl_debug,"0x%x,0x%x-0x%x,0x%x\n",r.lu.x,r.lu.y,r.rl.x,r.rl.y);
    navit_zoom_to_rect(m_navit.u.navit, &r);
}

void
MapViewerControlObj::GetMapViewBoundingBox(NavigationTypes::Rectangle& boundingBox)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	struct point p;
	struct coord c;
	struct coord_geo g;
	int w,h;
    NavigationTypes::Coordinate2D coordinate;

    transform_get_size(trans, &w, &h);
	p.x=0;
	p.y=0;
	transform_reverse(trans, &p, &c);
	transform_to_geo(projection_mg, &c, &g);
    coordinate.setLatitude(g.lat);
    coordinate.setLongitude(g.lng);
    boundingBox.setTopLeft(coordinate);
	p.x=w;
	p.y=h;
	transform_reverse(trans, &p, &c);
	transform_to_geo(projection_mg, &c, &g);
    coordinate.setLatitude(g.lat);
    coordinate.setLongitude(g.lng);
    boundingBox.setBottomRight(coordinate);
}

void
MapViewerControlObj::GetDisplayedRoutes(std::vector<MapViewerControl::DisplayedRoute>& displayedRoutes)
{
    size_t i;
	for (i = 0 ; i < m_displayed_routes.size(); i++) {
        MapViewerControl::DisplayedRoute route;
        route.setRouteHandle(m_displayed_routes[i]->RouteHandle());
        route.setHighlighted(false);
		displayedRoutes.push_back(route);
	}
}

void
MapViewerControlObj::DisplayRoute(NavigationTypes::Handle SessionHandle, NavigationTypes::Handle RouteHandle, bool highlighted)
{
	HideRoute(SessionHandle, RouteHandle);

    if (m_navigationcore_session == NavigationTypes::BasicEnum::INVALID)
    {
        CommonAPI::CallStatus status;
        Session::createSessionError _error;
        mp_navigationCoreSessionClientProxy->myServiceNavigationCoreSession->createSession(std::string("MapViewerControl"),status,_error, m_navigationcore_session);
    }

    DisplayedRoute *route=new DisplayedRoute(this,m_navigationcore_session,RouteHandle,m_mapset);
	route->Show();
	m_displayed_routes.push_back(route);
	m_force_draw=true;
	event_add_timeout(0, 0, m_move_callback);
}

void
MapViewerControlObj::HideRoute(NavigationTypes::Handle SessionHandle, NavigationTypes::Handle RouteHandle)
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
    dbg(lvl_debug,"Route not displayed\n");
}

void
MapViewerControlObj::ConvertPixelCoordsToGeoCoords(NavigationTypes::Handle SessionHandle, const std::vector< MapViewerControl::Pixel >& pixelCoordinates, std::vector< NavigationTypes::Coordinate2D >& geoCoordinates)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	struct coord c;
	struct point p;
	struct coord_geo g;
    std::vector< MapViewerControl::Pixel >::const_iterator it;
	for (it=pixelCoordinates.begin(); it < pixelCoordinates.end(); it++) {
        NavigationTypes::Coordinate2D geoCoordinate;
        p.x=it->getX();
        p.y=it->getY();
		transform_reverse(trans, &p, &c);
		transform_to_geo(projection_mg, &c, &g);
        geoCoordinate.setLatitude(g.lat);
        geoCoordinate.setLongitude(g.lng);
		geoCoordinates.push_back(geoCoordinate);
	}
	
}

void
MapViewerControlObj::ConvertGeoCoordsToPixelCoords(NavigationTypes::Handle SessionHandle, const std::vector< NavigationTypes::Coordinate2D >& geoCoordinates, std::vector< MapViewerControl::Pixel >& pixelCoordinates)
{
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	struct coord c;
	struct point p;
	struct coord_geo g;
    std::vector< NavigationTypes::Coordinate2D >::const_iterator it;
	for (it=geoCoordinates.begin(); it < geoCoordinates.end(); it++) {
        MapViewerControl::Pixel pixelCoordinate;
        g.lat=it->getLatitude();
        g.lng=it->getLongitude();
		transform_from_geo(projection_mg, &g, &c);
		transform(trans, projection_mg, &c, &p, 1, 0, 0, NULL);
        pixelCoordinate.setX(p.x);
        pixelCoordinate.setY(p.y);
		pixelCoordinates.push_back(pixelCoordinate);
	}
}

#if LM
static void callbackFunction(ilmObjectType object, t_ilm_uint surfaceId, t_ilm_bool created, void *user_data)
{
    (void)user_data;
    struct ilmSurfaceProperties sp;

    t_ilm_int pLength = 0;
    t_ilm_layer* ppArray = NULL;
    struct ilmSurfaceProperties pSurfaceProperties;
    t_ilm_layer renderOrder[2];

    if (object == ILM_SURFACE) {
        if (created) {
            if (surfaceId == FSA_SURFACE) {
                //Configure map surface
                if (ilm_getPropertiesOfSurface(surfaceId, &sp) != ILM_SUCCESS) {
                    dbg(lvl_error,"error on ilm_getPropertiesOfSurface\n");
                }

                if (ilm_surfaceSetSourceRectangle(surfaceId, 0, 0, sp.origSourceWidth, sp.origSourceHeight)  != ILM_SUCCESS) {
                    dbg(lvl_error,"error on ilm_surfaceSetSourceRectangle\n");
                }

                //RenderOrder with the hmi-launcher Qt surface
                /*
                 * ilm_getLayerIDsOnScreen will give the layer attached
                 * to the hmi-launcher Qt surface following hmi-launcher Qt surface
                 */
                if (ilm_getLayerIDsOnScreen(0, &pLength, &ppArray)  != ILM_SUCCESS) {
                    dbg(lvl_error, "error on ilm_getLayerIDsOnScreen\n");
                }

                /* The last one is the hmi-launcher layer and thus surface.
                 * Then hmi-launcher surface toped the map surface into the hmi-launcher layer.
                 */
                renderOrder[1] = SURFACE_OFFSET + ppArray[pLength - 1];
                renderOrder[0] = FSA_SURFACE;

                if (ilm_layerSetRenderOrder(ppArray[pLength - 1],renderOrder,2) != ILM_SUCCESS) {
                    dbg(lvl_error,"error on ilm_layerSetRenderOrder\n");
                }

                //Put the map at the same resolution as the hmi-launcher
                if (ilm_getPropertiesOfSurface(SURFACE_OFFSET + ppArray[pLength - 1], &pSurfaceProperties) != ILM_SUCCESS) {
                    dbg(lvl_error,"error on ilm_getPropertiesOfSurface\n");
                }

                if (ilm_surfaceSetDestinationRectangle(surfaceId, pSurfaceProperties.destX, pSurfaceProperties.destY,
                                                                  pSurfaceProperties.destWidth, pSurfaceProperties.destHeight) != ILM_SUCCESS) {
                    dbg(lvl_error,"error on ilm_surfaceSetDestinationRectangle\n");
                }

                if (ilm_surfaceSetVisibility(surfaceId, ILM_TRUE) != ILM_SUCCESS) {
                    dbg(lvl_error,"error on ilm_surfaceSetVisibility\n");
                }

                if (ilm_commitChanges() != ILM_SUCCESS) {
                    dbg(lvl_error,"error on ilm_commitChanges\n");
                }
            }
        }
    }
}
#endif

class  MapMatchedPositionClientProxy;
class RoutingClientProxy;

MapViewerControlObj::MapViewerControlObj(MapViewerControlServerStub *mapviewercontrol, NavigationTypes::Handle handle, const MapViewerControl::Dimension &MapViewSize)
{
	mp_mapviewercontrol=mapviewercontrol;
	m_handle=handle;
	m_navit.type=attr_navit;
	m_scrollspeed=0;
	m_scrolldirection=0;
	m_force_draw=false;
    m_perspective=MapViewerControl::MapPerspective::PERSPECTIVE_2D;
	m_follow_car=true;
    m_navigationcore_session = NavigationTypes::BasicEnum::INVALID;
    //connect the routing client to map viewer
    mp_routingClientProxy->connectToMapViewer(this);
    struct attr navit_template;
	struct attr navit_flags={attr_flags};navit_flags.u.num=2;
	struct attr *navit_attrs[]={&navit_flags,NULL};
	if (!config_get_attr(config, attr_navit, &navit_template, NULL)) {
        dbg(lvl_debug,"failed to get navit template from config\n");
		return;
	}
	m_navit.u.navit=navit_new(NULL,navit_attrs);
	if (!m_navit.u.navit) {
        dbg(lvl_debug,"failed to create new navit instance\n");
        return;
	}
    const char *graphics=getenv("NAVIT_GRAPHICS");
	if (!graphics)
		graphics="gtk_drawing_area";
	struct attr graphics_type={attr_type};graphics_type.u.str=(char *)graphics;
    struct attr graphics_w={attr_w};graphics_w.u.num=MapViewSize.getHorizontalSize();
    struct attr graphics_h={attr_h};graphics_h.u.num=MapViewSize.getVerticalSize();
	struct attr graphics_window_title={attr_window_title};graphics_window_title.u.str=g_strdup_printf("Navit-%d",handle);
	struct attr *graphics_attrs[]={&graphics_type,&graphics_w,&graphics_h,&graphics_window_title,NULL};
	m_graphics.type=attr_graphics;
	m_graphics.u.graphics=graphics_new(&m_navit,graphics_attrs);
    g_free(graphics_window_title.u.str);

	if (!m_graphics.u.graphics) {
        dbg(lvl_debug,"failed to create new graphics\n");
		return;
	}
    m_postdraw_callback=callback_new_attr_1(reinterpret_cast<void (*)(void)>(MapViewerControlObj_PostDraw), attr_postdraw, this);
	m_move_callback=callback_new_1(reinterpret_cast<void (*)(void)>(MapViewerControlObj_MoveMap), this);
	graphics_add_callback(m_graphics.u.graphics, m_postdraw_callback);
	navit_add_attr(m_navit.u.navit, &m_graphics);

	struct attr mapset;
	if (!navit_get_attr(navit_template.u.navit, attr_mapset, &mapset, NULL)) {
        dbg(lvl_debug,"failed to get mapset\n");
		return;
	}
    mapset.u.mapset=mapset_dup(mapset.u.mapset);
	m_mapset=mapset.u.mapset;
	navit_add_attr(m_navit.u.navit, &mapset);

	struct attr_iter *iter=navit_attr_iter_new();
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
    //connect the map matched position client to map viewer
    mp_mapMatchedPositionClientProxy->connectToMapViewer(this);
    // and connect it to the vehicle
    mp_mapMatchedPositionClientProxy->connectToVehicle(m_vehicle.u.vehicle);
	navit_init(m_navit.u.navit);
	graphics_get_data(m_graphics.u.graphics,"window");
	struct transformation *trans=navit_get_trans(m_navit.u.navit);
	struct map_selection sel;
	memset(&sel, 0, sizeof(sel));
    sel.u.p_rect.rl.x=MapViewSize.getHorizontalSize();
    sel.u.p_rect.rl.y=MapViewSize.getVerticalSize();
	transform_set_screen_selection(trans, &sel);

#if LM
    t_ilm_nativedisplay display = (t_ilm_nativedisplay)graphics_get_data(m_graphics.u.graphics, "display");

    if (ilmClient_init(display) != ILM_SUCCESS) {
        dbg(lvl_error, "error on ilm_initWidthNativeDisplay\n");
    }

    t_ilm_nativehandle nativehandle=(t_ilm_nativehandle)graphics_get_data(m_graphics.u.graphics,"xwindow_id");
    t_ilm_surface surfaceId=FSA_SURFACE;

    //Register Notification
    if (ilm_registerNotification(callbackFunction, NULL)  != ILM_SUCCESS) {
        dbg(lvl_error,"error on ilm_registerNotification\n");
    }

    //Create surface for the map and add notification when created
    if (ilm_surfaceCreate(nativehandle, MapViewSize._1, MapViewSize._2, ILM_PIXELFORMAT_RGBA_8888, &surfaceId) != ILM_SUCCESS) {
        dbg(lvl_error,"error on ilm_surfaceCreate\n");
    }

    //Commit all changes
    if (ilm_commitChanges() != ILM_SUCCESS) {
        dbg(lvl_error,"error on ilm_commitChanges\n");
    }
#endif

}

MapViewerControlObj::~MapViewerControlObj()
{
#if LM
    t_ilm_surface surfaceId=FSA_SURFACE;

    if (ilm_surfaceRemove(surfaceId) != ILM_SUCCESS) {
        dbg(lvl_error,"error on ilm_surfaceRemove\n");
    }

    if (ilm_commitChanges() != ILM_SUCCESS) {
        dbg(lvl_error,"error on ilm_commitChanges\n");
    }
#endif

	graphics_remove_callback(m_graphics.u.graphics, m_postdraw_callback);
#if 0
	graphics_free(m_graphics.u.graphics);
	vehicle_destroy(m_vehicle.u.vehicle);
#endif
	navit_destroy(m_navit.u.navit);
    delete(mp_routingClientProxy);
    delete(mp_mapMatchedPositionClientProxy);
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

bool
DisplayedRoute::AddSegment(Routing::RouteSegment map)
{
    if (map.find(Routing::RouteSegmentType::START_LATITUDE) != map.end() && map.find(Routing::RouteSegmentType::START_LONGITUDE) != map.end())
        AddGeoCoordinateD(map[Routing::RouteSegmentType::START_LATITUDE].get<double>(),map[Routing::RouteSegmentType::START_LONGITUDE].get<double>());
    if (map.find(Routing::RouteSegmentType::INTERMEDIATE_POINTS) != map.end()) {
        std::vector<Routing::IntermediatePoint> intermediate_points=map[Routing::RouteSegmentType::INTERMEDIATE_POINTS].get<std::vector<Routing::IntermediatePoint>>();
        Routing::IntermediatePoint intermediate_point;
        for (size_t i = 0 ; i < intermediate_points.size(); i++) {
            intermediate_point = intermediate_points[i];
            AddGeoCoordinateD(intermediate_point.getLatitude(), intermediate_point.getLongitude());
		}
	}
    if (map.find(Routing::RouteSegmentType::END_LATITUDE) != map.end() && map.find(Routing::RouteSegmentType::END_LONGITUDE) != map.end()) {
        AddGeoCoordinateD(map[Routing::RouteSegmentType::END_LATITUDE].get<double>(),map[Routing::RouteSegmentType::END_LONGITUDE].get<double>());
		return true;
	}
	return false;
}

void
DisplayedRoute::WriteSegment(FILE *out)
{
	if (m_coordinates.size()) {
        size_t i;
		uint32_t header[3]={2+2*m_coordinates.size(),type_street_route,2*m_coordinates.size()};
		fwrite(header, sizeof(header), 1, out);
		for (i = 0 ; i < m_coordinates.size() ; i++) 
			fwrite(&m_coordinates[i], sizeof(struct coord), 1, out);
	}
}

DisplayedRoute::DisplayedRoute(class MapViewerControlObj *mapviewer, uint8_t RouteSession, NavigationTypes::Handle RouteHandle, struct mapset *mapset)
{	
    dbg(lvl_debug,"enter\n");
    std::vector<Routing::RouteSegment> RouteShape;
    std::vector<Routing::RouteSegmentType> valuesToReturn;
    valuesToReturn.push_back(Routing::RouteSegmentType::START_LATITUDE);
    valuesToReturn.push_back(Routing::RouteSegmentType::START_LONGITUDE);
    valuesToReturn.push_back(Routing::RouteSegmentType::END_LATITUDE);
    valuesToReturn.push_back(Routing::RouteSegmentType::END_LONGITUDE);
    valuesToReturn.push_back(Routing::RouteSegmentType::INTERMEDIATE_POINTS);
	m_handle=RouteHandle;
	m_map.type=attr_map;
	m_map.u.map=NULL;
	m_filename=NULL;
	m_mapset=mapset;
	m_shown=false;
	uint32_t totalNumberOfSegments;
    CommonAPI::CallStatus status;
    mp_routingClientProxy->myServiceRouting->getRouteSegments(RouteHandle, 1, valuesToReturn, 0xffffffff, 0, status,totalNumberOfSegments, RouteShape);
    m_filename=g_strdup_printf("/tmp/genivi_route_map_%d_%d.bin",mapviewer->m_handle,RouteHandle);
	FILE *f=fopen(m_filename,"w");
	int count=RouteShape.size();
	bool complete=true;
	for (int i = 0 ; i < count ; i++) {
        Routing::RouteSegment map = RouteShape[i];
		if (!complete) {
            if (map.find(Routing::RouteSegmentType::START_LATITUDE) != map.end() && map.find(Routing::RouteSegmentType::START_LONGITUDE) != map.end())
                AddGeoCoordinateD(map[Routing::RouteSegmentType::START_LATITUDE].get<double>(),map[Routing::RouteSegmentType::START_LONGITUDE].get<double>());
			else
                dbg(lvl_debug,"previous segment is missing end, but current segment is missing start also");
			WriteSegment(f);
		}
		complete=AddSegment(map);
	}
	if (!complete)
        dbg(lvl_debug,"last segment is missing end");
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
    dbg(lvl_debug,"enter\n");
	if (m_map.u.map)
		map_destroy(m_map.u.map);
	if (m_filename) {
		unlink(m_filename);
		g_free(m_filename);
	}
}

void
plugin_init(void)
{
    dbg(lvl_debug,"enter\n");
    event_request_system("glib","genivi_mapviewercontrol");

    // Common API data init
    runtime = CommonAPI::Runtime::get();

    // init the map viewer control server
    const std::string domain = "local";
    const std::string instanceMapViewerControl = "MapViewerControl";

    std::shared_ptr<MapViewerControlServerStub> myServiceMapViewerControl = std::make_shared<MapViewerControlServerStub>();

    bool successfullyRegistered = runtime->registerService(domain, instanceMapViewerControl, myServiceMapViewerControl);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instanceMapViewerControl, myServiceMapViewerControl);
    }

    //init the session client
    const std::string instanceNavigationCoreSession = "Session";
    mp_navigationCoreSessionClientProxy = new NavigationCoreSessionClientProxy(domain,instanceNavigationCoreSession);

    //init the routing client
    const std::string instanceRouting = "Routing";
    mp_routingClientProxy = new RoutingClientProxy(domain,instanceRouting);
    mp_routingClientProxy->setListeners();

    // init the map matched position client
    const std::string instanceMapMatchedPosition = "MapMatchedPosition";
    mp_mapMatchedPositionClientProxy = new MapMatchedPositionClientProxy(domain,instanceMapMatchedPosition);
    mp_mapMatchedPositionClientProxy->setListeners();

#if LM
    if (ilm_init() != ILM_SUCCESS) {
        dbg(lvl_error,"error on ilm_init\n");
    }
#endif

}

