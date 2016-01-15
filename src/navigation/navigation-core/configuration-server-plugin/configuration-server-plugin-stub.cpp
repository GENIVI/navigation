/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2015, PCA Peugeot Citroen
*
* \file configuration-server-plugin-stub.cpp
*
* \brief This file is part of the poi proof of concept.
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
#include "configuration-server-plugin-stub.h"

NavigationCoreConfigurationServerStub::NavigationCoreConfigurationServerStub()
{

}

NavigationCoreConfigurationServerStub::~NavigationCoreConfigurationServerStub()
{

}

void NavigationCoreConfigurationServerStub::getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::setLocale(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _languageCode, std::string _countryCode, std::string _scriptCode, setLocaleReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::getLocale(const std::shared_ptr<CommonAPI::ClientId> _client, getLocaleReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedLocalesReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::setTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, ::org::genivi::navigation::NavigationTypes::TimeFormat _format, setTimeFormatReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::getTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getTimeFormatReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::getSupportedTimeFormats(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedTimeFormatsReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::setCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, NavigationCoreConfiguration::CoordinatesFormat _coordinatesFormat, setCoordinatesFormatReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::getCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getCoordinatesFormatReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::getSupportedCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedCoordinatesFormatReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::setUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, NavigationCoreConfiguration::UnitsOfMeasurement _unitsOfMeasurementList, setUnitsOfMeasurementReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::getUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getUnitsOfMeasurementReply_t _reply)
{

}

void NavigationCoreConfigurationServerStub::getSupportedUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedUnitsOfMeasurementReply_t _reply)
{

}

