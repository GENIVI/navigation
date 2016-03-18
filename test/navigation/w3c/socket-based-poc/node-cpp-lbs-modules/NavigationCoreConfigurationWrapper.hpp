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
#ifndef NAVIGATIONCOREWRAPPER_HPP
#define NAVIGATIONCOREWRAPPER_HPP

#define USE_DBUS 0

#include <node.h>
#include <node_buffer.h>

#include "./dbus-proxies/NavigationCoreProxy.hpp"

#include <string>
#include <vector>
#include <map>

// Do not include this line. It's generally frowned upon to use namespaces
// in header files as it may cause issues with other code that includes your
// header file.
// using namespace v8;

class NavigationCoreConfigurationWrapper : public node::ObjectWrap {
    friend void NavigationCoreProxy::ConfigurationChanged(const std::vector< int32_t >& changedSettings);

public:
    static v8::Persistent<v8::FunctionTemplate> constructor;
    static void Init(v8::Handle<v8::Object> target);
    static v8::Persistent<v8::Function> callbackConfigurationChanged;

protected:
    NavigationCoreConfigurationWrapper();
    ~NavigationCoreConfigurationWrapper();

    static v8::Handle<v8::Value> New(const v8::Arguments& args);
    static v8::Handle<v8::Value> GetVersion(const v8::Arguments& args);
    static v8::Handle<v8::Value> GetSupportedLocales(const v8::Arguments& args);
    static v8::Handle<v8::Value> GetUnitsOfMeasurement(const v8::Arguments& args);

    static v8::Handle<v8::Value> GetProperty(const v8::Arguments& args);
    static v8::Handle<v8::Value> SetProperty(const v8::Arguments& args);

    static v8::Handle<v8::Value> SetConfigurationChangedListener(const v8::Arguments& args);
    static void ConfigurationChanged(const std::vector<int32_t> &changedSettings);

private:
    NavigationCoreProxy* mp_navigationCoreProxy;
};

#endif
