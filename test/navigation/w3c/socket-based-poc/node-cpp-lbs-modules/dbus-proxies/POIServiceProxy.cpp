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

#include "POIServiceProxy.hpp"

using namespace v8;
using namespace std;

static DBus::Glib::BusDispatcher *dispatcher;
static DBus::Connection *connection;

POISearchProxy::POISearchProxy(DBus::Connection &connection)
    :    DBus::ObjectProxy(connection,
                           "/org/genivi/poiservice",
                           "org.genivi.poiservice.POISearch")
{

}

void POISearchProxy::CategoriesUpdated(const std::vector< ::DBus::Struct< uint32_t, uint16_t > >& poiCategories)
{

}

void POISearchProxy::PoiStatus(const uint32_t& poiSearchHandle, const int32_t& statusValue)
{

}

void POISearchProxy::ResultListChanged(const uint32_t& poiSearchHandle, const uint16_t& resultListSize)
{

}

POIServiceProxy::POIServiceProxy()
{
    dispatcher = new DBus::Glib::BusDispatcher();
    DBus::default_dispatcher = dispatcher;
    dispatcher->attach(NULL);
    connection = new DBus::Connection(DBus::Connection::SessionBus());
    connection->setup(dispatcher);
    mp_poiSearchProxy = new POISearchProxy(*connection);
}


POIServiceProxy::~POIServiceProxy()
{
    delete connection;
    delete dispatcher;
}
