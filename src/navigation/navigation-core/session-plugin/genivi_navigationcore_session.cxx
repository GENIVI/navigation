/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_navigationcore_session.cxx
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
#include "genivi-navigationcore-session_adaptor.h"
#include <config.h>
#define USE_PLUGINS 1
#include <navit/debug.h>
#include <navit/plugin.h>
#include <navit/event.h>

#include "navigation-common-dbus.h"

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

static DBus::Glib::BusDispatcher dispatcher;
static DBus::Connection *conn;

static std::map<uint32_t, std::string *> handles;

class  Session
: public org::genivi::navigation::navigationcore::Session_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
	public:
	Session(DBus::Connection &connection)
	: DBus::ObjectAdaptor(connection, "/org/genivi/navigationcore")
	{
	}

	::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > GetVersion()
	{
		::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > Version;
		dbg(lvl_debug,"enter\n");
		Version._1=3;
		Version._2=0;
		Version._3=0;
		Version._4=std::string("07-06-2013");
		return Version;
	}

    void CreateSession(const std::string& client, int32_t& error, uint32_t& sessionHandle)
	{
		dbg(lvl_debug,"enter\n");
        sessionHandle=1;
        while (handles[sessionHandle]) {
            sessionHandle++;
            if (sessionHandle == 256)
				throw DBus::Error("org.genivi.navigation.navigationcore.Session.Error.NoMoreSessionHandles","Out of session handles");
		}
        handles[sessionHandle]=new std::string(client);
        error=0; //not implemented yet
	}

    DBusCommonAPIEnumeration GetSessionStatus(const uint32_t& SessionHandle)
	{
		if (handles[SessionHandle])
			return GENIVI_NAVIGATIONCORE_AVAILABLE;
		else
			return GENIVI_NAVIGATIONCORE_NOT_AVAILABLE;
	}

    int32_t DeleteSession(const uint32_t& SessionHandle)
	{
		dbg(lvl_debug,"enter\n");
		if (!handles[SessionHandle])
			throw DBus::Error("org.genivi.navigation.navigationcore.Session.Error.NotAvailableSessionHandle","Session handle invalid");
		delete(handles[SessionHandle]);
		handles[SessionHandle]=NULL;
		SessionDeleted(SessionHandle);
        return(0); //not implemented yet
	}

    std::vector< ::DBus::Struct< uint32_t, std::string > >
	GetAllSessions()
	{
        std::vector< ::DBus::Struct< uint32_t, std::string > > ret;
		std::map<uint32_t, std::string *>::const_iterator it;
		for(it = handles.begin(); it != handles.end(); it++) {
            ::DBus::Struct< uint32_t, std::string > session;
			if (it->second) {
				session._1=it->first;
				session._2=*it->second;
				ret.push_back(session);
			}
			
		}
		return ret;
	}

};

static class Session *server;


void
plugin_init(void)
{
	event_request_system("glib","genivi_navigationcoresession");
	dispatcher.attach(NULL);
	DBus::default_dispatcher = &dispatcher;
	conn = new DBus::Connection(DBus::Connection::SessionBus());
	conn->setup(&dispatcher);
	conn->request_name("org.genivi.navigation.navigationcore.Session");
	server=new Session(*conn);
}
