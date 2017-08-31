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
#include "genivi-navigationcore-constants.h"
#include "genivi-navigationcore-locationinput_adaptor.h"
#include <config.h>
#define USE_PLUGINS 1
#include <navit/debug.h>
#include <navit/plugin.h>
#include <navit/item.h>
#include <navit/config_.h>
#include <navit/navit.h>
#include <navit/search.h>
#include <navit/callback.h>
#include <navit/event.h>
#include <navit/coord.h>
#include <navit/transform.h>

#include "navigation-common-dbus.h"

#include "log.h"

DLT_DECLARE_CONTEXT(gCtx);

static DBus::Glib::BusDispatcher dispatcher;
static DBus::Connection *conn;

class LocationInput;

class LocationInputObj
{
	public:
	struct search_list *m_sl;
	uint8_t m_handle;
	uint8_t m_session;
	uint32_t m_criterion;
	uint32_t m_windowsize;
	struct attr m_search;
	LocationInput *m_locationinput;
	struct callback *m_callback;
	struct event_idle *m_event;
	bool m_spell;
	bool m_spell_backspace;
    std::vector< std::vector< std::map< int32_t, DBusCommonAPIVariant > > > m_data;
    int m_chunk;
    int m_count;
    void SetSelectionCriterion(uint32_t SessionHandle, uint32_t SelectionCriterion);
    void Search(uint32_t SessionHandle, const std::string& InputString, uint32_t MaxWindowSize);
    void SelectEntry(const uint32_t& SessionHandle, const uint32_t& Index);
	struct navit *get_navit(void);
	struct mapset *get_mapset(struct navit *navit);
	void IdleStop(void);
	void Idle(void);
    void Spell(uint32_t SessionHandle, const std::string& InputCharacter, uint32_t MaxWindowSize);
    void RequestListUpdate(uint32_t sessionHandle, const uint16_t& offset, uint16_t maxWindowSize);
    void GetEntry(uint16_t index, std::map<int32_t, DBusCommonAPIVariant> &entry);
    void ValidateAddress(uint32_t sessionHandle, const std::map<int32_t, DBusCommonAPIVariant> &inputAddress);
    LocationInputObj(LocationInput *locationinput, uint32_t handle);
	~LocationInputObj();
};

static std::map<uint32_t, LocationInputObj *> handles;



class  LocationInput
: public org::genivi::navigation::navigationcore::LocationInput_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
	public:
	LocationInput(DBus::Connection &connection)
	: DBus::ObjectAdaptor(connection, "/org/genivi/navigationcore")
	{
	}

    void CreateLocationInput(const uint32_t& sessionHandle, int32_t& error, uint32_t& locationInputHandle)
	{
        LOG_INFO_MSG(gCtx,"Creation location input");
        locationInputHandle=1;
        while (handles[locationInputHandle]) {
            locationInputHandle++;
            if (locationInputHandle == 256)
				throw DBus::ErrorLimitsExceeded("Out of location handles");
		}
        handles[locationInputHandle]=new LocationInputObj(this, locationInputHandle);
        error=0; //not implemented yet
	}

    int32_t DeleteLocationInput(const uint32_t& SessionHandle, const uint32_t& LocationInputHandle)
	{
        LOG_INFO_MSG(gCtx,"Delete location input");
        LocationInputObj *obj=handles[LocationInputHandle];
		if (!obj)
			 throw DBus::ErrorInvalidArgs("location handle invalid");
		delete(obj);
		handles[LocationInputHandle]=NULL;
        return(0); //not implemented yet
	}

    std::vector< int32_t > GetSupportedAddressAttributes()
    {
        std::vector< int32_t > AddressAttributes;
		AddressAttributes.resize(5);
		AddressAttributes[0]=GENIVI_NAVIGATIONCORE_COUNTRY; 
		AddressAttributes[1]=GENIVI_NAVIGATIONCORE_CITY; 
        AddressAttributes[2]=GENIVI_NAVIGATIONCORE_STREET;
        AddressAttributes[3]=GENIVI_NAVIGATIONCORE_HOUSENUMBER;
        AddressAttributes[4]=GENIVI_NAVIGATIONCORE_FULL_ADDRESS;
        return AddressAttributes;
    }

    void SetAddress(const uint32_t& sessionHandle, const uint32_t& locationInputHandle, const std::map< int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant > >& address)
	{
        LOG_INFO_MSG(gCtx,"Set address");
        LocationInputObj *obj=handles[locationInputHandle];
		if (!obj)
			 throw DBus::ErrorInvalidArgs("location handle invalid");
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    void SetSelectionCriterion(const uint32_t& sessionHandle, const uint32_t& locationInputHandle, const int32_t& selectionCriterion)
	{
        LOG_INFO_MSG(gCtx,"Set selection criterion");
        LocationInputObj *obj=handles[locationInputHandle];
		if (!obj)
			 throw DBus::ErrorInvalidArgs("location handle invalid");
        obj->SetSelectionCriterion(sessionHandle, selectionCriterion);
	}

    void Search(const uint32_t& SessionHandle, const uint32_t& LocationInputHandle, const std::string& InputString, const uint16_t& MaxWindowSize)
	{
        LOG_INFO_MSG(gCtx,"Search");
        LocationInputObj *obj=handles[LocationInputHandle];
		if (!obj)
			 throw DBus::ErrorInvalidArgs("location handle invalid");
		obj->Search(SessionHandle, InputString, MaxWindowSize);
	}

    void SelectEntry(const uint32_t& SessionHandle, const uint32_t& LocationInputHandle, const uint16_t& Index)
	{
        LOG_INFO_MSG(gCtx,"Select entry");
        LocationInputObj *obj=handles[LocationInputHandle];
		if (!obj)
			 throw DBus::ErrorInvalidArgs("location handle invalid");
		obj->SelectEntry(SessionHandle, Index);
	}

	::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > GetVersion()
	{
		DBus::Struct<uint16_t, uint16_t, uint16_t, std::string> Version;
		Version._1=3;
		Version._2=0;
		Version._3=0;
		Version._4=std::string("07-06-2013");
		return Version;
	}

    void Spell(const uint32_t& sessionHandle, const uint32_t& locationInputHandle, const std::string& inputCharacter, const uint16_t& maxWindowSize)
	{
		LocationInputObj *obj=handles[locationInputHandle];
		if (!obj)
			 throw DBus::ErrorInvalidArgs("location handle invalid");
		obj->Spell(sessionHandle, inputCharacter, maxWindowSize);
	}

    void RequestListUpdate(const uint32_t& sessionHandle, const uint32_t& locationInputHandle, const uint16_t& offset, const uint16_t& maxWindowSize)
	{
        LocationInputObj *obj=handles[locationInputHandle];
        if (!obj)
             throw DBus::ErrorInvalidArgs("location handle invalid");

        obj->RequestListUpdate(sessionHandle, offset, maxWindowSize);
	}

    std::map< int32_t, DBusCommonAPIVariant > GetEntry(const uint32_t& locationInputHandle, const uint16_t& index)
	{
        std::map< int32_t, DBusCommonAPIVariant > ret;
		LocationInputObj *obj=handles[locationInputHandle];
		if (!obj)
			 throw DBus::ErrorInvalidArgs("location handle invalid");
		obj->GetEntry(index, ret);
		return ret;
	}

    void ValidateAddress(const uint32_t& sessionHandle, const uint32_t& locationInputHandle, const std::map< int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant > >& inputAddress)
	{
		LocationInputObj *obj=handles[locationInputHandle];
		if (!obj)
			 throw DBus::ErrorInvalidArgs("location handle invalid");
		obj->ValidateAddress(sessionHandle, inputAddress);
	}

    void ReverseGeocode(const uint32_t& sessionHandle, const uint32_t& locationInputHandle, const ::DBus::Struct< double, double >& coordinate)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

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
LocationInputObj::SetSelectionCriterion(uint32_t SessionHandle, uint32_t SelectionCriterion)
{
	m_criterion=SelectionCriterion;
	switch(m_criterion) {
	case GENIVI_NAVIGATIONCORE_COUNTRY:
		m_search.type=attr_country_name;
		break;
	case GENIVI_NAVIGATIONCORE_CITY:
		m_search.type=attr_town_name;
		break;
	case GENIVI_NAVIGATIONCORE_STREET:
		m_search.type=attr_street_name;
		break;
	case GENIVI_NAVIGATIONCORE_HOUSENUMBER:
		m_search.type=attr_house_number;
		break;
	case GENIVI_NAVIGATIONCORE_FULL_ADDRESS:
		m_search.type=attr_address;
		break;
	default:
		throw DBus::ErrorInvalidArgs("Invalid selection criterion");
	}
	g_free(m_search.u.str);
	m_search.u.str=NULL;
	m_locationinput->CurrentSelectionCriterion(m_handle, SelectionCriterion);
}

void
LocationInputObj::Search(uint32_t SessionHandle, const std::string& InputString, uint32_t MaxWindowSize)
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
LocationInputObj::Spell(uint32_t SessionHandle, const std::string& InputCharacter, uint32_t MaxWindowSize)
{
	IdleStop();

	m_spell=true;
	m_spell_backspace=false;
	m_session=SessionHandle;
	char *newstr;
	const char *input=InputCharacter.c_str();
	int len=strlen(input)+1;
    LOG_DEBUG(gCtx,"Input '%s' (%lu)",input,strlen(input));
	if (m_search.u.str && strlen(m_search.u.str)) {
		const char *i=input;
		char c;
		newstr=g_strdup(m_search.u.str);
            LOG_DEBUG(gCtx,"String %s",newstr);
		while ((c=*i++)) {
			if (c == '\b') {
				m_spell_backspace=true;
				*g_utf8_prev_char(newstr+strlen(newstr))='\0';
			} else {
				int len=strlen(newstr);
				newstr=g_renew(char,newstr,len+2);
				newstr[len]=c;
				newstr[len+1]='\0';
			}
		}
	} else { 
		if (strcmp(input,"\b")) 
			newstr=g_strdup(input);
		else
			newstr=NULL;
	}
	g_free(m_search.u.str);
    LOG_DEBUG(gCtx,"Search string '%s' (%lu)",newstr,strlen(newstr));
	m_search.u.str=newstr;
	m_windowsize=MaxWindowSize;

	search_list_search(m_sl, &m_search, 1);
    LOG_DEBUG(gCtx,"backspace %d",m_spell_backspace);
	m_event=event_add_idle(0, m_callback);

}

void
LocationInputObj::RequestListUpdate(uint32_t sessionHandle, const uint16_t& offset, uint16_t maxWindowSize)
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
        m_locationinput->SearchResultList(m_handle, m_count, (offset-shift), window, m_data[i]);
    }
}

void
LocationInputObj::SelectEntry(const uint32_t& SessionHandle, const uint32_t& Index)
{
    std::map< int32_t, DBusCommonAPIVariant > *res=NULL;
    std::vector< int32_t> next;
	int window=0;
	bool guidable=false;
	for (int i = 0 ; i < m_data.size() ; i++) {
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
	case GENIVI_NAVIGATIONCORE_COUNTRY:
		next.push_back(GENIVI_NAVIGATIONCORE_COUNTRY);
		next.push_back(GENIVI_NAVIGATIONCORE_CITY);
		break;
	case GENIVI_NAVIGATIONCORE_CITY:
		next.push_back(GENIVI_NAVIGATIONCORE_COUNTRY);
		next.push_back(GENIVI_NAVIGATIONCORE_CITY);
		next.push_back(GENIVI_NAVIGATIONCORE_STREET);
		break;
	case GENIVI_NAVIGATIONCORE_STREET:
	case GENIVI_NAVIGATIONCORE_HOUSENUMBER:
		next.push_back(GENIVI_NAVIGATIONCORE_COUNTRY);
		next.push_back(GENIVI_NAVIGATIONCORE_CITY);
		next.push_back(GENIVI_NAVIGATIONCORE_STREET);
		next.push_back(GENIVI_NAVIGATIONCORE_HOUSENUMBER);
		break;
	}
	if (res->find(GENIVI_NAVIGATIONCORE_LATITUDE) != res->end())
		guidable=true;
	m_locationinput->ContentUpdated(m_handle, guidable, next, *res);
}

void
LocationInputObj::IdleStop(void)
{
	if (m_event) {
		event_remove_idle(m_event);
		m_event=NULL;
	}
}

static DBus::Variant
variant_string(std::string s)
{
	DBus::Variant variant;
	DBus::MessageIter iter=variant.writer();
	iter << s;
	return variant;
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
LocationInputObj::Idle(void)
{
    LOG_INFO_MSG(gCtx,"Idle callback");
    m_locationinput->SearchStatus(m_handle, GENIVI_NAVIGATIONCORE_SEARCHING);
	struct search_list_result *res;
	int chunk=0;
	uint16_t count=0,offset=0;
	m_data.resize(0);
	m_data.resize(1);
	while ((res=search_list_get_result(m_sl))) {
        std::map< int32_t, DBusCommonAPIVariant> entry;
		if (res->country && res->country->name) {
            entry[GENIVI_NAVIGATIONCORE_COUNTRY]._1 = 0;
            entry[GENIVI_NAVIGATIONCORE_COUNTRY]._2=variant_string(std::string(res->country->name));
		}
		if (res->town && res->town->common.town_name) {
            entry[GENIVI_NAVIGATIONCORE_CITY]._1 = 0;
            entry[GENIVI_NAVIGATIONCORE_CITY]._2=variant_string(std::string(res->town->common.town_name));
		}
		if (res->street && res->street->name) {
            entry[GENIVI_NAVIGATIONCORE_STREET]._1 = 0;
            entry[GENIVI_NAVIGATIONCORE_STREET]._2=variant_string(std::string(res->street->name));
		}
		if (res->house_number && res->house_number->house_number) {
            entry[GENIVI_NAVIGATIONCORE_HOUSENUMBER]._1 = 0;
            entry[GENIVI_NAVIGATIONCORE_HOUSENUMBER]._2=variant_string(std::string(res->house_number->house_number));
		}
		if (res->c) {
			struct coord_geo g;
			struct coord c;
			c.x=res->c->x;
			c.y=res->c->y;
			transform_to_geo(res->c->pro, &c, &g);
            entry[GENIVI_NAVIGATIONCORE_LATITUDE]._1 = 0;
            entry[GENIVI_NAVIGATIONCORE_LATITUDE]._2=variant_double(g.lat);
            entry[GENIVI_NAVIGATIONCORE_LONGITUDE]._1 = 0;
            entry[GENIVI_NAVIGATIONCORE_LONGITUDE]._2=variant_double(g.lng);
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
				m_locationinput->SpellResult(m_handle, unique, next, false);
				g_free(next);
			}
        }
        else
			m_locationinput->SpellResult(m_handle, "", "\b", false);
    } 

    m_count = count; //amount of data
    m_chunk = chunk; //amount of lists of data

	m_locationinput->SearchStatus(m_handle, GENIVI_NAVIGATIONCORE_FINISHED);
	IdleStop();

}

static void
LocationInputObj_Idle(LocationInputObj *obj)
{
	obj->Idle();
}

void
LocationInputObj::GetEntry(uint16_t index, std::map<int32_t, DBusCommonAPIVariant> &entry)
{
}

void
LocationInputObj::ValidateAddress(uint32_t sessionHandle, const std::map< int32_t, DBusCommonAPIVariant >& inputAddress)
{
}

LocationInputObj::LocationInputObj(LocationInput *locationinput, uint32_t handle)
{
	m_locationinput=locationinput;
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

static class LocationInput *server;

void
plugin_init(void)
{
    DLT_REGISTER_APP("LOIS","LOCATION INPUT SERVER");
    DLT_REGISTER_CONTEXT(gCtx,"LOIS","Global Context");

    dispatcher.attach(NULL);
	DBus::default_dispatcher = &dispatcher;
	conn = new DBus::Connection(DBus::Connection::SessionBus());
	conn->setup(&dispatcher);
	conn->request_name("org.genivi.navigation.navigationcore.LocationInput");
	server=new LocationInput(*conn);
}
