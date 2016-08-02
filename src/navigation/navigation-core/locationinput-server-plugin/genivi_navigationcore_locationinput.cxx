/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_navigationcore_locationinput.cxx
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

#include <CommonAPI/CommonAPI.hpp>
#include <CommonTypes.hpp>
#include <NavigationTypes.hpp>
#include <NavigationCoreTypes.hpp>
#include <LocationInputStubDefault.hpp>

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

using namespace v4::org::genivi::navigation::navigationcore;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

class LocationInputServerStub;

class LocationInputObj
{
    public:
    struct search_list *m_sl;
    NavigationTypes::Handle m_handle;
    NavigationTypes::Handle m_session;
    LocationInput::AddressAttribute m_criterion;
    uint32_t m_windowsize;
    struct attr m_search;
    LocationInputServerStub *mp_locationinput;
    struct callback *m_callback;
    struct event_idle *m_event;
    bool m_spell;
    bool m_spell_backspace;
    std::vector< std::vector< LocationInput::Address > > m_data;
    int m_chunk;
    int m_count;
    void SetSelectionCriterion(NavigationTypes::Handle SessionHandle, LocationInput::AddressAttribute SelectionCriterion);
    void Search(NavigationTypes::Handle SessionHandle, const std::string& InputString, uint32_t MaxWindowSize);
    void SelectEntry(const NavigationTypes::Handle& SessionHandle, const uint32_t& Index);
    struct navit *get_navit(void);
    struct mapset *get_mapset(struct navit *navit);
    void IdleStop(void);
    void Idle(void);
    void Spell(NavigationTypes::Handle SessionHandle, const std::string& InputCharacter, uint32_t MaxWindowSize);
    void RequestListUpdate(NavigationTypes::Handle sessionHandle, const uint16_t& offset, uint16_t maxWindowSize);
    void GetEntry(uint16_t index, LocationInput::Address &entry);
    void ValidateAddress(NavigationTypes::Handle sessionHandle, const LocationInput::Address &inputAddress);
    LocationInputObj(LocationInputServerStub *locationinput, uint32_t handle);
    ~LocationInputObj();
};

class  LocationInputServerStub : public LocationInputStubDefault {

public:

#define MAX_LOCATION_HANDLES 256
#define FIRST_LOCATION_HANDLE 1

    LocationInputServerStub(){
        mp_handles[FIRST_LOCATION_HANDLE]=NULL;
        m_version.setVersionMajor(3);
        m_version.setVersionMinor(0);
        m_version.setVersionMicro(0);
        m_version.setDate("21-01-2014");
    }

    ~LocationInputServerStub(){}

    /**
     * description: getVersion = This method returns the API version implemented by the server
     *   application
     */
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply) {
        _reply(m_version);
    }

    /**
     * description: createLocationInput = This method creates a new location input and retrieves a
     *   handle
     */
    void createLocationInput(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, createLocationInputReply_t _reply){
        uint32_t LocationInputHandle;
        dbg(lvl_debug,"enter\n");
        LocationInputHandle=FIRST_LOCATION_HANDLE;
        while (mp_handles.count(LocationInputHandle)>0 ) {
            LocationInputHandle++;
            if (LocationInputHandle == MAX_LOCATION_HANDLES)
                throw DBus::ErrorLimitsExceeded("Out of location handles");
        }
        mp_handles[LocationInputHandle]=new LocationInputObj(this, LocationInputHandle);
        _reply(LocationInputHandle);
    }

    /**
     * description: deleteLocationInput = This method deletes a location input and its associated
     *   resources
     */
    void deleteLocationInput(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::LocationHandle _locationInputHandle, deleteLocationInputReply_t _reply){
        dbg(lvl_debug,"enter\n");
        if (mp_handles.find(_locationInputHandle) != mp_handles.end())
        {
            LocationInputObj *obj=mp_handles[_locationInputHandle];
            delete(obj);
        }
        else {
            throw DBus::ErrorInvalidArgs("location handle invalid");
        }
        _reply();
    }

    /**
     * description: getSupportedAddressAttributes = This method retrieves the supported address
     *   attributes
     */
    void getSupportedAddressAttributes(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedAddressAttributesReply_t _reply){
        LocationInput::AddressAttributeList addressAttributes;
        addressAttributes.resize(5);
        addressAttributes[0]=LocationInput::AddressAttribute::COUNTRY;
        addressAttributes[1]=LocationInput::AddressAttribute::CITY;
        addressAttributes[2]=LocationInput::AddressAttribute::STREET;
        addressAttributes[3]=LocationInput::AddressAttribute::HOUSENUMBER;
        addressAttributes[4]=LocationInput::AddressAttribute::FULL_ADDRESS;
        _reply(addressAttributes);
    }

    /**
     * description: setAddress = This method sets the address to start with for the LocationInput
     *   identified by the given handle
     */
    void setAddress(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::LocationHandle _locationInputHandle, LocationInput::Address _address, setAddressReply_t _reply){
        dbg(lvl_debug,"enter\n");
        LocationInputObj *obj=mp_handles[_locationInputHandle];
        if (!obj)
             throw DBus::ErrorInvalidArgs("location handle invalid");
        throw DBus::ErrorNotSupported("Not yet supported");
        _reply();
    }

    /**
     * description: setSelectionCriterion = This method sets the selection criterion for the
     *   current speller, search input and the corresponding result-lists for the
     *   current session
     */
    void setSelectionCriterion(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::LocationHandle _locationInputHandle, LocationInput::AddressAttribute _selectionCriterion, setSelectionCriterionReply_t _reply){
        dbg(lvl_debug,"enter\n");
        LocationInputObj *obj=mp_handles[_locationInputHandle];
        if (!obj)
             throw DBus::ErrorInvalidArgs("location handle invalid");
        obj->SetSelectionCriterion(_sessionHandle, _selectionCriterion);
        _reply();
    }

    /**
     * description: spell = This method sends the next spell input for the current session
     */
    void spell(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::LocationHandle _locationInputHandle, std::string _inputCharacter, uint16_t _maxWindowSize, spellReply_t _reply){
        LocationInputObj *obj=mp_handles[_locationInputHandle];
        if (!obj)
             throw DBus::ErrorInvalidArgs("location handle invalid");
        obj->Spell(_sessionHandle, _inputCharacter, _maxWindowSize);
        _reply();
    }

    /**
     * description: search = This method sends the search input for the current session
     */
    void search(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::LocationHandle _locationInputHandle, std::string _inputString, uint16_t _maxWindowSize, searchReply_t _reply){
        dbg(lvl_debug,"enter\n");
        LocationInputObj *obj=mp_handles[_locationInputHandle];
        if (!obj)
             throw DBus::ErrorInvalidArgs("location handle invalid");
        obj->Search(_sessionHandle, _inputString, _maxWindowSize);
        _reply();
    }

    /**
     * description: requestListUpdate = This method sends a request for more list elements for the
     *   current session
     */
    void requestListUpdate(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::LocationHandle _locationInputHandle, uint16_t _offset, uint16_t _maxWindowSize, requestListUpdateReply_t _reply){
        LocationInputObj *obj=mp_handles[_locationInputHandle];
        if (!obj)
             throw DBus::ErrorInvalidArgs("location handle invalid");

        obj->RequestListUpdate(_sessionHandle, _offset, _maxWindowSize);
        _reply();
    }

    /**
     * description: selectEntry = This method triggers selection of a result list entry by index
     */
    void selectEntry(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::LocationHandle _locationInputHandle, uint16_t _index, selectEntryReply_t _reply){
        dbg(lvl_debug,"enter\n");
        LocationInputObj *obj=mp_handles[_locationInputHandle];
        if (!obj)
             throw DBus::ErrorInvalidArgs("location handle invalid");
        obj->SelectEntry(_sessionHandle, _index);
        _reply();
    }

    /**
     * description: getEntry = This method synchronously gets the address for the given result list
     *   entry
     */
    void getEntry(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::LocationHandle _locationInputHandle, uint16_t _index, getEntryReply_t _reply){
        LocationInput::Address ret;
        LocationInputObj *obj=mp_handles[_locationInputHandle];
        if (!obj)
             throw DBus::ErrorInvalidArgs("location handle invalid");
        obj->GetEntry(_index, ret);
        _reply(ret);
    }

    /**
     * description: validateAddress = This method validates an address from different sources than
     *   Navigation
     */
    void validateAddress(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::LocationHandle _locationInputHandle, LocationInput::Address _inputAddress, validateAddressReply_t _reply){
        LocationInputObj *obj=mp_handles[_locationInputHandle];
        if (!obj)
             throw DBus::ErrorInvalidArgs("location handle invalid");
        obj->ValidateAddress(_sessionHandle, _inputAddress);
        _reply();
    }

    /**
     * description: reverseGeocode = This method transforms a geocoordinate into an address
     */
    void reverseGeocode(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, ::v4::org::genivi::navigation::NavigationTypes::LocationHandle _locationInputHandle, ::v4::org::genivi::navigation::NavigationTypes::Coordinate2D _coordinate, reverseGeocodeReply_t _reply){
        throw DBus::ErrorNotSupported("Not yet supported");
    }

private:
    CommonTypes::Version m_version;
    std::map<uint32_t, LocationInputObj *> mp_handles;

};

struct navit *
LocationInputObj::get_navit(void)
{
    struct attr navit;
    if (!config_get_attr(config, attr_navit, &navit, NULL))
        return NULL;
    return navit.u.navit;
}
struct mapset *
LocationInputObj::get_mapset(struct navit *navit)
{
    struct attr mapset;
    if (!navit_get_attr(navit, attr_mapset, &mapset, NULL))
        return NULL;
    return mapset.u.mapset;
}

void
LocationInputObj::SetSelectionCriterion(NavigationTypes::Handle SessionHandle, LocationInput::AddressAttribute SelectionCriterion)
{
    m_criterion=SelectionCriterion;
    switch(m_criterion) {
    case LocationInput::AddressAttribute::COUNTRY:
        m_search.type=attr_country_name;
        break;
    case LocationInput::AddressAttribute::CITY:
        m_search.type=attr_town_name;
        break;
    case LocationInput::AddressAttribute::STREET:
        m_search.type=attr_street_name;
        break;
    case LocationInput::AddressAttribute::HOUSENUMBER:
        m_search.type=attr_house_number;
        break;
    case LocationInput::AddressAttribute::FULL_ADDRESS:
        m_search.type=attr_address;
        break;
    default:
        throw DBus::ErrorInvalidArgs("Invalid selection criterion");
    }
    g_free(m_search.u.str);
    m_search.u.str=NULL;
    mp_locationinput->fireCurrentSelectionCriterionEvent(m_handle, m_criterion);
}

void
LocationInputObj::Search(NavigationTypes::Handle SessionHandle, const std::string& InputString, uint32_t MaxWindowSize)
{
    IdleStop();
    g_free(m_search.u.str);

    m_session=SessionHandle;
    m_search.u.str=g_strdup(InputString.c_str());
    m_windowsize=MaxWindowSize;
    m_spell=false;

    search_list_search(m_sl, &m_search, 0);
    m_event=event_add_idle(0, m_callback);
}

void
LocationInputObj::Spell(NavigationTypes::Handle SessionHandle, const std::string& InputCharacter, uint32_t MaxWindowSize)
{
    IdleStop();

    m_spell=true;
    m_spell_backspace=false;
    m_session=SessionHandle;
    char *newstr;
    const char *input=InputCharacter.c_str();
    int len=strlen(input)+1;
    dbg(lvl_debug,"input '%s' (%d)\n",input,strlen(input));
    if (m_search.u.str && strlen(m_search.u.str)) {
        const char *i=input;
        char c;
        newstr=g_strdup(m_search.u.str);
        dbg(lvl_debug,"string %s\n",newstr);
        while ((c=*i++)) {
            dbg(lvl_debug,"char '%c'\n",c);
            if (c == '\b') {
                m_spell_backspace=true;
                *g_utf8_prev_char(newstr+strlen(newstr))='\0';
            } else {
                int len=strlen(newstr);
                newstr=g_renew(char,newstr,len+2);
                newstr[len]=c;
                newstr[len+1]='\0';
            }
            dbg(lvl_debug,"string now %s\n",newstr);
        }
    } else {
        if (strcmp(input,"\b"))
            newstr=g_strdup(input);
        else
            newstr=NULL;
    }
    g_free(m_search.u.str);
    dbg(lvl_debug,"search string '%s' (%d)\n",newstr,strlen(newstr));
    m_search.u.str=newstr;
    m_windowsize=MaxWindowSize;

    search_list_search(m_sl, &m_search, 1);
    dbg(lvl_debug,"backspace %d\n",m_spell_backspace);
    m_event=event_add_idle(0, m_callback);

}

void
LocationInputObj::RequestListUpdate(NavigationTypes::Handle sessionHandle, const uint16_t& offset, uint16_t maxWindowSize)
{
    //for the time being, maxWindowSize is not used, the size is set during the Spell or the Search
    //note that it gets all the results in one shot (to be improved!), per bunch of maxWindowSize data
    //not really what is specified..
    //offset is supposed to be n*maxWindowSize in that case

    if (m_windowsize > 0)
    {
        int i = offset/m_windowsize;
        int shift = offset%m_windowsize;
        uint16_t window=m_data[i].size();
        mp_locationinput->fireSearchResultListEvent(m_handle, m_count, (offset-shift), window, m_data[i]);
    }
}

void
LocationInputObj::SelectEntry(const NavigationTypes::Handle &SessionHandle, const uint32_t& Index)
{
    LocationInput::Address *res=NULL;
    std::vector<LocationInput::AddressAttribute> next;
    std::size_t window=0;
    bool guidable=false;
    for (std::size_t i = 0 ; i < m_data.size() ; i++) {
        if (Index >= window && Index < window+m_data[i].size()) {
            res=&m_data[i][Index-window];
            break;
        }
        window+=m_data[i].size();
    }
    if (!res)
        throw DBus::ErrorInvalidArgs("Invalid index");
    search_list_select(m_sl, m_search.type, Index+1, 1);
    switch(m_criterion) {
    case LocationInput::AddressAttribute::COUNTRY:
        next.push_back(LocationInput::AddressAttribute::COUNTRY);
        next.push_back(LocationInput::AddressAttribute::CITY);
        break;
    case LocationInput::AddressAttribute::CITY:
        next.push_back(LocationInput::AddressAttribute::COUNTRY);
        next.push_back(LocationInput::AddressAttribute::CITY);
        next.push_back(LocationInput::AddressAttribute::STREET);
        break;
    case LocationInput::AddressAttribute::STREET:
    case LocationInput::AddressAttribute::HOUSENUMBER:
        next.push_back(LocationInput::AddressAttribute::COUNTRY);
        next.push_back(LocationInput::AddressAttribute::CITY);
        next.push_back(LocationInput::AddressAttribute::STREET);
        next.push_back(LocationInput::AddressAttribute::HOUSENUMBER);
        break;
    }
    if (res->find(LocationInput::AddressAttribute::LATITUDE) != res->end())
        guidable=true;
    mp_locationinput->fireContentUpdatedEvent(m_handle, guidable, next, *res);
}

void
LocationInputObj::IdleStop(void)
{
    if (m_event) {
        event_remove_idle(m_event);
        m_event=NULL;
    }
}

void
LocationInputObj::Idle(void)
{
    dbg(lvl_debug,"enter\n");
    mp_locationinput->fireSearchStatusEvent(m_handle, LocationInput::SearchStatus::SEARCHING);
    struct search_list_result *res;
    int chunk=0;
    uint16_t count=0;
    m_data.resize(0);
    m_data.resize(1);
    while ((res=search_list_get_result(m_sl))) {
        LocationInput::Address entry;
        if (res->country && res->country->name) {
            dbg(lvl_debug,"country %s\n",res->country->name);
            entry[LocationInput::AddressAttribute::COUNTRY] = std::string(res->country->name);
        }
        if (res->town && res->town->common.town_name) {
            dbg(lvl_debug,"town %s\n",res->town->common.town_name);
            entry[LocationInput::AddressAttribute::CITY] = std::string(res->town->common.town_name);
        }
        if (res->street && res->street->name) {
            dbg(lvl_debug,"street %s\n",res->street->name);
            entry[LocationInput::AddressAttribute::STREET] = std::string(res->street->name);
        }
        if (res->house_number && res->house_number->house_number) {
            dbg(lvl_debug,"house number %s\n",res->house_number->house_number);
            entry[LocationInput::AddressAttribute::HOUSENUMBER] = std::string(res->house_number->house_number);
        }
        if (res->c) {
            struct coord_geo g;
            struct coord c;
            c.x=res->c->x;
            c.y=res->c->y;
            transform_to_geo(res->c->pro, &c, &g);
            entry[LocationInput::AddressAttribute::LATITUDE] = g.lat;
            entry[LocationInput::AddressAttribute::LONGITUDE] = g.lng;
        }
        m_data[chunk].push_back(entry);
        if (m_data[chunk].size() >= m_windowsize) {
            chunk++;
            m_data.resize(chunk+1);
        }
        count++;
    }

    // the search_list_get_unique has been removed from the svn in the r5549, so navit needs to be patched for upper versions
    if (m_spell) {
        char *unique;
        if (m_spell_backspace)
            unique=g_strdup(m_search.u.str);
        else
            unique=search_list_get_unique(m_sl, NULL);
        m_spell_backspace=false;
        if (unique) {
            g_free(m_search.u.str);
            m_search.u.str=unique;
            char *next=search_list_get_unique(m_sl, unique);
            if (next) {
                mp_locationinput->fireSpellResultEvent(m_handle, unique, next, false);
                g_free(next);
            }
        }
        else
            mp_locationinput->fireSpellResultEvent(m_handle, "", "\b", false);
    }

    m_count = count; //amount of data
    m_chunk = chunk; //amount of lists of data

    mp_locationinput->fireSearchStatusEvent(m_handle, LocationInput::SearchStatus::FINISHED);
    IdleStop();

}

static void
LocationInputObj_Idle(LocationInputObj *obj)
{
    obj->Idle();
}

void
LocationInputObj::GetEntry(uint16_t index, LocationInput::Address &entry)
{
}

void
LocationInputObj::ValidateAddress(NavigationTypes::Handle sessionHandle, const LocationInput::Address &inputAddress)
{
}

LocationInputObj::LocationInputObj(LocationInputServerStub *locationinput, uint32_t handle)
{
    mp_locationinput=locationinput;
    m_handle=handle;
    m_sl=search_list_new(get_mapset(get_navit()));
    m_count=0;
    m_chunk=0;
    m_search.type=attr_none;
    m_search.u.str=NULL;
    m_event=NULL;
    m_callback=callback_new_1(reinterpret_cast<void (*)(void)>(LocationInputObj_Idle), this);
}

LocationInputObj::~LocationInputObj()
{
    IdleStop();
    callback_destroy(m_callback);
    g_free(m_search.u.str);
    search_list_destroy(m_sl);
}

void
plugin_init(void)
{
    // Common API data init
    std::shared_ptr < CommonAPI::Runtime > runtime = CommonAPI::Runtime::get();

    const std::string &domain = "local";
    const std::string &instance = "LocationInput";

    std::shared_ptr<LocationInputServerStub> myServiceLocationInput = std::make_shared<LocationInputServerStub>();

    bool successfullyRegistered = runtime->registerService(domain, instance, myServiceLocationInput);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instance, myServiceLocationInput);
    }
}
