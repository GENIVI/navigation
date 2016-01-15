/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2015, PCA Peugeot Citroen
*
* \file configuration-server-plugin.h
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
#ifndef CONFIGURATIONSERVERSTUBIMPL_H_
#define CONFIGURATIONSERVERSTUBIMPL_H_

#include <CommonAPI/CommonAPI.hpp>

#include <org/genivi/CommonTypes.hpp>
#include <org/genivi/navigation/NavigationTypes.hpp>
#include <org/genivi/navigation/navigationcore/NavigationCoreTypes.hpp>
#include <v0_1/org/genivi/navigation/navigationcore/NavigationCoreConfigurationStubDefault.hpp>

using namespace std;
using namespace v0_1::org::genivi::navigation::navigationcore;
using namespace org::genivi::navigation;
using namespace org::genivi;


class NavigationCoreConfigurationServerStub: public NavigationCoreConfigurationStubDefault {

public:
    NavigationCoreConfigurationServerStub();
    ~NavigationCoreConfigurationServerStub();
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply);
    void setLocale(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _languageCode, std::string _countryCode, std::string _scriptCode, setLocaleReply_t _reply);
    void getLocale(const std::shared_ptr<CommonAPI::ClientId> _client, getLocaleReply_t _reply);
    void getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedLocalesReply_t _reply);
    void setTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, ::org::genivi::navigation::NavigationTypes::TimeFormat _format, setTimeFormatReply_t _reply);
    void getTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getTimeFormatReply_t _reply);
    void getSupportedTimeFormats(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedTimeFormatsReply_t _reply);
    void setCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, NavigationCoreConfiguration::CoordinatesFormat _coordinatesFormat, setCoordinatesFormatReply_t _reply);
    void getCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getCoordinatesFormatReply_t _reply);
    void getSupportedCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedCoordinatesFormatReply_t _reply);
    void setUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, NavigationCoreConfiguration::UnitsOfMeasurement _unitsOfMeasurementList, setUnitsOfMeasurementReply_t _reply);
    void getUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getUnitsOfMeasurementReply_t _reply);
    void getSupportedUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedUnitsOfMeasurementReply_t _reply);

private:

};

#endif /* CONFIGURATIONSERVERSTUBIMPL_H_ */
