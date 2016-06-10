/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2016, PCA Peugeot Citroen
*
* \file main.cpp
*
* \brief This file is part of the Navigation Web API proof of concept.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 0.1
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License (MPL), v. 2.0.
* If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* For further information see http://www.genivi.org/.
*
* List of changes:
* <date>, <name>, <description of change>
*
* @licence end@
*/
#include <node.h>

#include "NavigationCoreProxy.hpp"
#include "../NavigationCoreConfigurationWrapper.hpp"

#include "../common/debug.h"

using namespace v8;
using namespace std;

static DBus::Glib::BusDispatcher *dispatcher;
static DBus::Connection *connection;

NavigationCoreConfigurationProxy::NavigationCoreConfigurationProxy(DBus::Connection &connection, NavigationCoreProxy *navigationCoreProxy)
    :    DBus::ObjectProxy(connection,
                           "/org/genivi/navigationcore",
                           "org.genivi.navigationcore.Configuration")
{
    mp_navigationCoreProxy = navigationCoreProxy;
}

void NavigationCoreConfigurationProxy::ConfigurationChanged(const std::vector< int32_t >& changedSettings)
{
    printTimeStamp("ConfigurationChanged proxy");
    mp_navigationCoreProxy->ConfigurationChanged(changedSettings);
}

NavigationCoreProxy::NavigationCoreProxy(NavigationCoreConfigurationWrapper *navigationCoreConfigurationWrapper)
{
    dispatcher = new DBus::Glib::BusDispatcher();
    DBus::default_dispatcher = dispatcher;
    dispatcher->attach(NULL);
    connection = new DBus::Connection(DBus::Connection::SessionBus());
    connection->setup(dispatcher);
    mp_navigationCoreConfigurationWrapper = navigationCoreConfigurationWrapper;
    mp_navigationCoreConfigurationProxy = new NavigationCoreConfigurationProxy(*connection,this);
}

NavigationCoreProxy::~NavigationCoreProxy()
{
    delete mp_navigationCoreConfigurationProxy;
    delete connection;
    delete dispatcher;
}

void NavigationCoreProxy::ConfigurationChanged(const std::vector< int32_t >& changedSettings)
{
    mp_navigationCoreConfigurationWrapper->ConfigurationChanged(changedSettings);
}
