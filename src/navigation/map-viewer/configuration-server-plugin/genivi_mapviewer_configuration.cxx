/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file genivi_mapviewer_configuration.cxx
*
* \brief This file is part of the Navit POC.
*
* \author Martin Schaller <martin.schaller@it-schaller.de>
* \author Philippe Colliot <philippe.colliot@mpsa.com>
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
* 2014-03-18, Philippe Colliot, Add JPN language to locale
*
* @licence end@
*/
#include <locale.h>
#include <stdlib.h>
#include <config.h>
#define USE_PLUGINS 1
#include <navit/debug.h>
#include <navit/plugin.h>
#include <navit/event.h>

#include <CommonAPI/CommonAPI.hpp>
#include <CommonTypes.hpp>
#include <NavigationTypes.hpp>
#include <ConfigurationStubDefault.hpp>

#if (!DEBUG_ENABLED)
#undef dbg
#define dbg(level,...) ;
#endif

using namespace v4::org::genivi::navigation::mapviewer;
using namespace v4::org::genivi::navigation;
using namespace v4::org::genivi;

typedef struct  {
    const char *c3;
    const char *c2;
} map32_t;

static const map32_t language_map[] = {
    {"deu","de"},
    {"eng","en"},
    {"fra","fr"},
    {"jpn","jp"},
};

static const map32_t country_map[] = {
    {"CHE","CH"},
    {"DEU","DE"},
    {"FRA","FR"},
    {"USA","US"},
    {"JPN","JP"},
};

class  MapViewerConfigurationServerStub: public ConfigurationStubDefault
{

public:
    MapViewerConfigurationServerStub();
    ~MapViewerConfigurationServerStub();
    void getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply);
    void setLocale(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _languageCode, std::string _countryCode, std::string _scriptCode, setLocaleReply_t _reply);
    void getLocale(const std::shared_ptr<CommonAPI::ClientId> _client, getLocaleReply_t _reply);
    void getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedLocalesReply_t _reply);
    void setTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, NavigationTypes::TimeFormat _format, setTimeFormatReply_t _reply);
    void getTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getTimeFormatReply_t _reply);
    void getSupportedTimeFormats(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedTimeFormatsReply_t _reply);
    void setCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, Configuration::CoordinatesFormat _coordinatesFormat, setCoordinatesFormatReply_t _reply);
    void getCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getCoordinatesFormatReply_t _reply);
    void getSupportedCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedCoordinatesFormatReply_t _reply);
    void setUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, Configuration::UnitsOfMeasurement _unitsOfMeasurementList, setUnitsOfMeasurementReply_t _reply);
    void getUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getUnitsOfMeasurementReply_t _reply);
    void getSupportedUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedUnitsOfMeasurementReply_t _reply);

private:
    CommonTypes::Version m_version;
    Configuration::UnitsOfMeasurement m_unitsOfMeasurement;
    Configuration::UnitsOfMeasurementList m_SupportedUnitsOfMeasurement;
    std::vector< NavigationTypes::Locale> m_SupportedLocales;
    std::string m_languageCode, m_countryCode, m_scriptCode;
    NavigationTypes::TimeFormat m_timeFormat;
    std::vector<NavigationTypes::TimeFormat> m_SupportedTimeFormats;
    Configuration::CoordinatesFormat m_coordinatesFormat;
    std::vector<Configuration::CoordinatesFormat> m_SupportedCoordinatesFormats;
};

MapViewerConfigurationServerStub::MapViewerConfigurationServerStub()
{
    Configuration::UnitsOfMeasurementListValue valueList;

    m_version.setVersionMajor(3);
    m_version.setVersionMinor(0);
    m_version.setVersionMicro(0);
    m_version.setDate("21-01-2014");

    NavigationTypes::Locale en_US { "eng","USA", "Latn" };
    NavigationTypes::Locale fr_FR { "fra","FRA", "Latn" };
    NavigationTypes::Locale de_DE { "deu","DEU", "Latn" };
    NavigationTypes::Locale jp_JP { "jpn","JPN", "Hrkt" };

    m_SupportedLocales.push_back(en_US);
    m_SupportedLocales.push_back(fr_FR);
    m_SupportedLocales.push_back(de_DE);
    m_SupportedLocales.push_back(jp_JP);

    valueList.push_back(Configuration::UnitsOfMeasurementValue::MILE);
    valueList.push_back(Configuration::UnitsOfMeasurementValue::METER);

    m_SupportedUnitsOfMeasurement[Configuration::UnitsOfMeasurementAttribute::LENGTH]=valueList;

    m_SupportedTimeFormats.push_back(NavigationTypes::TimeFormat::TWELVEH);
    m_SupportedTimeFormats.push_back(NavigationTypes::TimeFormat::TWENTYFOURH);

    m_SupportedCoordinatesFormats.push_back(Configuration::CoordinatesFormat::DEGREES);

    //default init
    m_languageCode = m_SupportedLocales.at(0).getLanguageCode();
    m_countryCode = m_SupportedLocales.at(0).getCountryCode();
    m_scriptCode = m_SupportedLocales.at(0).getScriptCode();
    m_coordinatesFormat = m_SupportedCoordinatesFormats.at(0);

    m_unitsOfMeasurement[Configuration::UnitsOfMeasurementAttribute::LENGTH] = Configuration::UnitsOfMeasurementValue::METER;

    m_timeFormat = m_SupportedTimeFormats.at(0);
}

MapViewerConfigurationServerStub::~MapViewerConfigurationServerStub()
{

}

void MapViewerConfigurationServerStub::getVersion(const std::shared_ptr<CommonAPI::ClientId> _client, getVersionReply_t _reply)
{
    _reply(m_version);
}

void MapViewerConfigurationServerStub::setLocale(const std::shared_ptr<CommonAPI::ClientId> _client, std::string _languageCode, std::string _countryCode, std::string _scriptCode, setLocaleReply_t _reply)
{
    std::vector<Configuration::Settings> changedSettings;

    m_languageCode = _languageCode;
    m_countryCode = _countryCode;
    m_scriptCode = _scriptCode;

    changedSettings.push_back(Configuration::Settings::LOCALE);
    fireConfigurationChangedEvent(changedSettings);
    _reply();
}

void MapViewerConfigurationServerStub::getLocale(const std::shared_ptr<CommonAPI::ClientId> _client, getLocaleReply_t _reply)
{
    _reply(m_languageCode,m_countryCode,m_scriptCode);
}

void MapViewerConfigurationServerStub::getSupportedLocales(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedLocalesReply_t _reply)
{
    _reply(m_SupportedLocales);
}

void MapViewerConfigurationServerStub::setTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, NavigationTypes::TimeFormat _format, setTimeFormatReply_t _reply)
{
    std::vector<Configuration::Settings> changedSettings;

    m_timeFormat = _format;

    changedSettings.push_back(Configuration::Settings::TIME_FORMAT);
    fireConfigurationChangedEvent(changedSettings);
    _reply();
}

void MapViewerConfigurationServerStub::getTimeFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getTimeFormatReply_t _reply)
{
    _reply(m_timeFormat);
}

void MapViewerConfigurationServerStub::getSupportedTimeFormats(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedTimeFormatsReply_t _reply)
{
    _reply(m_SupportedTimeFormats);
}

void MapViewerConfigurationServerStub::setCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, Configuration::CoordinatesFormat _coordinatesFormat, setCoordinatesFormatReply_t _reply)
{
    std::vector<Configuration::Settings> changedSettings;

    m_coordinatesFormat = _coordinatesFormat;

    changedSettings.push_back(Configuration::Settings::COORDINATES_FORMAT);
    fireConfigurationChangedEvent(changedSettings);
    _reply();
}

void MapViewerConfigurationServerStub::getCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getCoordinatesFormatReply_t _reply)
{
    _reply(m_coordinatesFormat);
}

void MapViewerConfigurationServerStub::getSupportedCoordinatesFormat(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedCoordinatesFormatReply_t _reply)
{
    _reply(m_SupportedCoordinatesFormats);
}

void MapViewerConfigurationServerStub::setUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, Configuration::UnitsOfMeasurement _unitsOfMeasurementList, setUnitsOfMeasurementReply_t _reply)
{
    std::vector<Configuration::Settings> changedSettings;

    m_unitsOfMeasurement = _unitsOfMeasurementList;

    changedSettings.push_back(Configuration::Settings::UNITS_OF_MEASUREMENT);
    fireConfigurationChangedEvent(changedSettings);
    _reply();
}

void MapViewerConfigurationServerStub::getUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getUnitsOfMeasurementReply_t _reply)
{
    _reply(m_unitsOfMeasurement);
}

void MapViewerConfigurationServerStub::getSupportedUnitsOfMeasurement(const std::shared_ptr<CommonAPI::ClientId> _client, getSupportedUnitsOfMeasurementReply_t _reply)
{
    _reply(m_SupportedUnitsOfMeasurement);
}

void
plugin_init(void)
{
    event_request_system("glib","genivi_mapviewerconfiguration");

    // Common API data init
    std::shared_ptr < CommonAPI::Runtime > runtime = CommonAPI::Runtime::get();

    const std::string &domain = "local";
    const std::string &instance = "Configuration";

    std::shared_ptr<MapViewerConfigurationServerStub> myServiceConfiguration = std::make_shared<MapViewerConfigurationServerStub>();

    bool successfullyRegistered = runtime->registerService(domain, instance, myServiceConfiguration);
    while (!successfullyRegistered) {
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
        successfullyRegistered = runtime->registerService(domain, instance, myServiceConfiguration);
    }
}

