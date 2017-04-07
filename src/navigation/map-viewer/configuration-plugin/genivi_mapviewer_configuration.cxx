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
#include <dbus-c++/glib-integration.h>
#include <locale.h>
#include <stdlib.h>
#include "genivi-mapviewer-constants.h"
#include "genivi-mapviewer-configuration_adaptor.h"
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

static struct map32 {
	const char *c3;
	const char *c2;
} language_map[] = {
	{"deu","de"},
	{"eng","en"},
	{"fra","fr"},
	{"jpn","jp"},
};

static struct map32 country_map[] = {
	{"CHE","CH"},
	{"DEU","DE"},
	{"FRA","FR"},
	{"USA","US"},
	{"JPN","JP"},
};

static std::string scriptCode = "Latn";

static DBus::Variant
variant_array_uint16(std::vector< uint16_t > i)
{
	DBus::Variant variant;
	DBus::MessageIter iter=variant.writer();
	iter << i;
	return variant;
}

static const char *
map_3_to_2(struct map32 *map, int len, const char *in)
{
	int i;
	for (i = 0 ; i < len ; i++)
		if (!strcmp(map[i].c3,in))
			return map[i].c2;
	return "";
}

static const char *
map_2_to_3(struct map32 *map, int len, const char *in)
{
	int i;
	for (i = 0 ; i < len ; i++)
		if (!strcmp(map[i].c2,in))
			return map[i].c3;
	return "";
}

static const char *
language_3_to_2(const char *in)
{
	return map_3_to_2(language_map, sizeof(language_map)/sizeof(language_map[0]), in);
}

static const char *
language_2_to_3(const char *in)
{
	return map_2_to_3(language_map, sizeof(language_map)/sizeof(language_map[0]), in);
}

static const char *
country_3_to_2(const char *in)
{
	return map_3_to_2(country_map, sizeof(country_map)/sizeof(country_map[0]), in);
}

static const char *
country_2_to_3(const char *in)
{
	return map_2_to_3(country_map, sizeof(country_map)/sizeof(country_map[0]), in);
}

std::map< int32_t, int32_t > m_unitsOfMeasurement;

class  Configuration
: public org::genivi::navigation::mapviewer::Configuration_adaptor,
  public DBus::IntrospectableAdaptor,
  public DBus::ObjectAdaptor
{
	public:
	Configuration(DBus::Connection &connection)
	: DBus::ObjectAdaptor(connection, "/org/genivi/mapviewer")
	{
	}

	::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string >
	GetVersion()
	{
		::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string >ret;
		ret._1=2;
		ret._2=0;
		ret._3=0;
		ret._4="07-06-2013";
		return ret;
	}

    void
    SetUnitsOfMeasurement(const std::map< int32_t, int32_t >& unitsOfMeasurement)
    {
        m_unitsOfMeasurement=unitsOfMeasurement;
        std::vector< int32_t > changed;
        changed.push_back(GENIVI_MAPVIEWER_UNITS_OF_MEASUREMENT);
        ConfigurationChanged(changed);
    }

    std::map< int32_t, int32_t >
    GetUnitsOfMeasurement()
    {
        return m_unitsOfMeasurement;
    }

    std::map< int32_t, std::vector< int32_t > >
    GetSupportedUnitsOfMeasurement()
    {
        std::map< int32_t, std::vector< int32_t > > ret;
        std::vector< int32_t > length;
        length.push_back(GENIVI_MAPVIEWER_MILE);
        length.push_back(GENIVI_MAPVIEWER_METER);
        ret[GENIVI_MAPVIEWER_LENGTH]=length;
        return ret;
     }

	void
    SetTimeFormat(const DBusCommonAPIEnumeration& timeFormat)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    DBusCommonAPIEnumeration
	GetTimeFormat()
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    std::vector< DBusCommonAPIEnumeration >
    GetSupportedTimeFormats()
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }

	void
    SetLocale(const std::string& language, const std::string& country, const std::string& script)
    {
		char *lang=g_strdup_printf("%s_%s.UTF-8",language_3_to_2(language.c_str()),country_3_to_2(country.c_str()));
		setenv("LANG",lang,1);
		setlocale(LC_ALL,"");
        scriptCode = script;
        std::vector< DBusCommonAPIEnumeration > changed;
		changed.push_back(GENIVI_MAPVIEWER_LOCALE);
		ConfigurationChanged(changed);
	}

	void
    GetLocale(std::string& language, std::string& country, std::string& script)
    {
		char *lang=g_strdup(getenv("LANG"));
		char *sep,*dot;
		if (!lang || !(sep=strchr(lang,'_'))) {
			g_free(lang);
			throw DBus::ErrorFailed("LANG doesn't exist or doesn't contain a _");
		}
		*sep++='\0';
		language=language_2_to_3(lang);
		dot=strchr(sep,'.');
		if (dot)
			*dot='\0';
		country=country_2_to_3(sep);
        script = scriptCode;
        g_free(lang);
	}

    std::vector< ::DBus::Struct< std::string, std::string, std::string > >
    GetSupportedLocales()
    {
        std::vector< ::DBus::Struct< std::string, std::string, std::string > > ret;
        ::DBus::Struct< std::string, std::string, std::string > en_US { "eng","USA", "Latn" };
        ::DBus::Struct< std::string, std::string, std::string > de_DE { "deu","DEU", "Latn" };
        ::DBus::Struct< std::string, std::string, std::string > fr_FR { "fra","FRA", "Latn" };
        ::DBus::Struct< std::string, std::string, std::string > jp_JP { "jpn","JPN", "Hrkt" };
        ret.push_back(en_US);
        ret.push_back(de_DE);
        ret.push_back(fr_FR);
        ret.push_back(jp_JP);
        return ret;
    }

	void
    SetCoordinatesFormat(const DBusCommonAPIEnumeration& coordinatesFormat)
	{
		throw DBus::ErrorNotSupported("Not yet supported");
	}

    DBusCommonAPIEnumeration
	GetCoordinatesFormat()
	{
		throw DBus::ErrorNotSupported("Not yet supported");
    }

    std::vector< DBusCommonAPIEnumeration >
    GetSupportedCoordinatesFormats()
    {
        throw DBus::ErrorNotSupported("Not yet supported");
    }
};

static class Configuration *server;

static DBus::Variant
variant_enumeration(DBusCommonAPIEnumeration i)
{
	DBus::Variant variant;
	DBus::MessageIter iter=variant.writer();
	iter << i;
	return variant;
}


void
plugin_init(void)
{
	event_request_system("glib","genivi_mapviewerconfiguration");
	dispatcher.attach(NULL);
	DBus::default_dispatcher = &dispatcher;
	conn = new DBus::Connection(DBus::Connection::SessionBus());
	conn->setup(&dispatcher);
    conn->request_name("org.genivi.navigation.mapviewer.Configuration");
    m_unitsOfMeasurement[GENIVI_MAPVIEWER_LENGTH]=GENIVI_MAPVIEWER_KM;
	server=new Configuration(*conn);
}
