#ifndef NAVIGATIONCORECONFIGURATIONWRAPPER_HPP
#define NAVIGATIONCORECONFIGURATIONWRAPPER_HPP

#include <dbus-c++/glib-integration.h>
#include "genivi-navigationcore-constants.h"
#include "genivi-navigationcore-configuration_proxy.h"

#include <node.h>
#include <node_buffer.h>

#include <string>
#include <vector>
#include <map>

// Do not include this line. It's generally frowned upon to use namespaces
// in header files as it may cause issues with other code that includes your
// header file.
// using namespace v8;

class Version {
public:
    Version() {
        versionMajor = 1;
        versionMinor = 0;
        versionMicro = 0;
        date = "19:02:2016";
	}
    uint16_t versionMajor;
    uint16_t versionMinor;
    uint16_t versionMicro;
    std::string date;
};

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

    NavigationCoreConfigurationProxy(DBus::Connection &connection)
        : DBus::ObjectProxy(connection,
                                    "/org/genivi/navigationcore/Configuration",
                                    "org.genivi.navigationcore.Configuration")
    {
        Locale en_US { "eng","USA", "Latn" };
        Locale de_DE { "deu","DEU", "Latn" };
        Locale fr_FR { "fra","FRA", "Latn" };
        Locale jp_JP { "jpn","JPN", "Hrkt" };
        m_locale_list.push_back(en_US);
        m_locale_list.push_back(de_DE);
        m_locale_list.push_back(fr_FR);
//        m_locale_list.push_back(jp_JP); //For the test Japanese is not supported

        UnitsOfMeasurementValueStruct value {intValue,METER};

        m_units_of_measurement[LENGTH] = value;
    }

    void ConfigurationChanged(const std::vector< int32_t >& changedSettings)
    {

    }

    Version GetVersion()
    {
        return m_version;
    }

    Locale GetLocale()
    {
        return m_locale;
    }
    std::vector<Locale > GetSupportedLocales()
    {
        return m_locale_list;
    }

    void SetLocale(Locale& locale)
    {
        m_locale = locale;
    }

    UnitsOfMeasurement GetUnitsOfMeasurement()
    {
        return m_units_of_measurement;
    }

public:
private:
    Version m_version;
    Locale m_locale;
    std::vector<Locale > m_locale_list;
    UnitsOfMeasurement m_units_of_measurement;
};

class NavigationCoreConfigurationWrapper : public node::ObjectWrap {
public:
    static v8::Persistent<v8::FunctionTemplate> constructor;
    static void Init(v8::Handle<v8::Object> target);

protected:
    NavigationCoreConfigurationWrapper();

    static v8::Handle<v8::Value> New(const v8::Arguments& args);
    static v8::Handle<v8::Value> GetVersion(const v8::Arguments& args);
    static v8::Handle<v8::Value> GetSupportedLocales(const v8::Arguments& args);
    static v8::Handle<v8::Value> GetUnitsOfMeasurement(const v8::Arguments& args);

    static v8::Handle<v8::Value> GetProperty(const v8::Arguments& args);
    static v8::Handle<v8::Value> SetProperty(const v8::Arguments& args);

    static void ConfigurationChanged(const v8::Handle<v8::Function> &callback, const v8::Handle<v8::Array>& array);

private:
    NavigationCoreConfigurationProxy* mp_proxy;
};

#endif
