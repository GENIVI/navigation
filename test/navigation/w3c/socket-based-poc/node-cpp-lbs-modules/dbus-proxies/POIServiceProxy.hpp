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
#ifndef POISERVICEPROXY_HPP
#define POISERVICEPROXY_HPP

#include <dbus-c++/glib-integration.h>
#include "genivi-poiservice-constants.h"
#include "genivi-poiservice-poisearch_proxy.h"

#include <node.h>
#include <node_buffer.h>

#include <string>
#include <vector>
#include <map>

// Do not include this line. It's generally frowned upon to use namespaces
// in header files as it may cause issues with other code that includes your
// header file.
// using namespace v8;

class POISearchProxy
        : public org::genivi::poiservice::POISearch_proxy,
          public DBus::ObjectProxy
{
public:

    POISearchProxy(DBus::Connection &connection);

    void CategoriesUpdated(const std::vector< ::DBus::Struct< uint32_t, uint16_t > >& poiCategories);
    void PoiStatus(const uint32_t& poiSearchHandle, const int32_t& statusValue);
    void ResultListChanged(const uint32_t& poiSearchHandle, const uint16_t& resultListSize);

private:
};

class POIServiceProxy
{
public:
    POIServiceProxy();
    ~POIServiceProxy();

    POISearchProxy* mp_poiSearchProxy;
};

#endif
