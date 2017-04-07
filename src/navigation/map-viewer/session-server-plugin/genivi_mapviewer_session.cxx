/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_mapviewer_session.cxx
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
#include <config.h>
#define USE_PLUGINS 1
#include <navit/debug.h>
#include <navit/plugin.h>
#include <navit/event.h>

#include <CommonAPI/CommonAPI.hpp>
#include <CommonTypes.hpp>
#include <NavigationTypes.hpp>
#include <SessionStubDefault.hpp>

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

using namespace v4::org::genivi::navigation::mapviewer;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

class  SessionServerStub : public SessionStubDefault
{
	public:

#define MAX_SESSION_HANDLES 256

    SessionServerStub()
    {
        m_version.setVersionMajor(3);
        m_version.setVersionMinor(0);
        m_version.setVersionMicro(0);
        m_version.setDate("21-01-2014");
    }

    ~SessionServerStub(){}

    /**
     * description: getVersion = This method returns the API version implemented by the server
     *   application
     */
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply) {
        _reply(m_version);
    }

    /**
     * description: createSession = This method creates a new session and retrieves a handle .
     */
    void createSession(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _clientApp, createSessionReply_t _reply){
        Session::createSessionError _error = Session::createSessionError::OK;
        dbg(lvl_debug,"enter\n");
        NavigationTypes::Handle _sessionHandle=1;
        while (mp_handles[_sessionHandle]) {
            _sessionHandle++;
            if (_sessionHandle == MAX_SESSION_HANDLES)
               _error = Session::createSessionError::SESSION_ERROR_NOMORESESSIONHANDLES;
        }
        mp_handles[_sessionHandle]=new std::string(_clientApp);
        _reply(_error,_sessionHandle);
    }

    /**
     * description: deleteSession = This method deletes a session and its associated resources .
     */
    void deleteSession(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, deleteSessionReply_t _reply){
        Session::deleteSessionError _error = Session::deleteSessionError::OK;
        dbg(lvl_debug,"enter\n");
        if (!mp_handles[_sessionHandle])
           _error = Session::deleteSessionError::SESSION_ERROR_SESSIONNOTAVAILABLE;
        else
            delete(mp_handles[_sessionHandle]);
        mp_handles[_sessionHandle]=NULL;
        fireSessionDeletedEvent(_sessionHandle);
        _reply(_error);
    }

    /**
     * description: This method returns whether a given session handle is available or not (for
     *   example because it was deleted) .
     */
    void getSessionStatus(const std::shared_ptr<CommonAPI::ClientId> _client, ::v4::org::genivi::navigation::NavigationTypes::Handle _sessionHandle, getSessionStatusReply_t _reply){
        if (mp_handles[_sessionHandle])
            _reply(NavigationTypes::SessionStatus::AVAILABLE);
        else
            _reply(NavigationTypes::SessionStatus::NOT_AVAILABLE);
    }

    /**
     * description: This method returns a list of all available sessions .
     */
    void getAllSessions(const std::shared_ptr<CommonAPI::ClientId> _client, getAllSessionsReply_t _reply){
        std::vector< NavigationTypes::Session > _sessionsList;
        std::map<NavigationTypes::Handle, std::string *>::const_iterator it;
        for(it = mp_handles.begin(); it != mp_handles.end(); it++) {
            NavigationTypes::Session session;
            if (it->second) {
                session.setSessionHandle(it->first);
                session.setClientApp(*it->second);
                _sessionsList.push_back(session);
            }

        }
        _reply(_sessionsList);
    }

private:
    CommonTypes::Version m_version;
    std::map<NavigationTypes::Handle, std::string *> mp_handles;

};

void
plugin_init(void)
{
    // Common API data init
    std::shared_ptr < CommonAPI::Runtime > runtime = CommonAPI::Runtime::get();

    const std::string &domain = "local";
    const std::string &instance = "Session";

    std::shared_ptr<SessionServerStub> myServiceSession = std::make_shared<SessionServerStub>();

    bool successfullyRegistered = runtime->registerService(domain, instance, myServiceSession);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instance, myServiceSession);
    }
}
