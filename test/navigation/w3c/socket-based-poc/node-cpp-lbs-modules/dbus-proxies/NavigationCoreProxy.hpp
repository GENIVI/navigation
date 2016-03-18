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
#ifndef NAVIGATIONCOREPROXY_HPP
#define NAVIGATIONCOREPROXY_HPP

#include "genivi-dbus-model.h"

#include <node.h>
#include <node_buffer.h>

#include <string>
#include <vector>
#include <map>

// Do not include this line. It's generally frowned upon to use namespaces
// in header files as it may cause issues with other code that includes your
// header file.
// using namespace v8;


class Locale {

public:
    Locale() {
        languageCode = "eng";
        countryCode = "USA";
        scriptCode = "Latn";
    }
    Locale(std::string language, std::string country, std::string script) {
        languageCode = language;
        countryCode = country;
        scriptCode = script;
    }

    std::string languageCode;
    std::string countryCode;
    std::string scriptCode;
};

class NavigationCoreProxy;
class NavigationCoreConfigurationProxy
        : public org::genivi::navigationcore::Configuration_proxy,
          public DBus::ObjectProxy
{

public:

    union UnitsOfMeasurementValue {
        int32_t intValue;
        double doubleValue;
    };

    enum UnitsOfMeasurementValueType {
        intValue=0,
        doubleValue=1
    };

    typedef struct {
        UnitsOfMeasurementValueType type;
        UnitsOfMeasurementValue value;
    } UnitsOfMeasurementValueStruct;

    enum UnitsOfMeasurementAttribute {
        INVALID,
        LENGTH=1
    };

    enum Units {
        METER		= 50,
        MILE		= 51,
        KM			= 52,
        YARD		= 53,
        FOOT		= 54
    };

    typedef std::map<UnitsOfMeasurementAttribute,UnitsOfMeasurementValueStruct > UnitsOfMeasurement;

    NavigationCoreConfigurationProxy(DBus::Connection &connection,NavigationCoreProxy* navigationCoreProxy);
    void ConfigurationChanged(const std::vector< int32_t >& changedSettings);
    UnitsOfMeasurement GetUnitsOfMeasurement();

private:
    NavigationCoreProxy* mp_navigationCoreProxy;
    UnitsOfMeasurement m_units_of_measurement;
};

class NavigationCoreConfigurationWrapper;
class NavigationCoreProxy
{

public:
    NavigationCoreProxy(NavigationCoreConfigurationWrapper *navigationCoreConfigurationWrapper);
    ~NavigationCoreProxy();
    NavigationCoreConfigurationProxy* mp_navigationCoreConfigurationProxy;
    void ConfigurationChanged(const std::vector< int32_t >& changedSettings);

private:
    NavigationCoreConfigurationWrapper* mp_navigationCoreConfigurationWrapper;
};

#endif
