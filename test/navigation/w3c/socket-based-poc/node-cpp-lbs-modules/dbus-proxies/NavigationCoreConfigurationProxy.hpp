#ifndef NAVIGATIONCORECONFIGURATIONPROXY_HPP
#define NAVIGATIONCORECONFIGURATIONPROXY_HPP

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

    NavigationCoreConfigurationProxy(DBus::Connection &connection);
    void ConfigurationChanged(const std::vector< int32_t >& changedSettings);
    Version GetVersion();
    Locale GetLocale();
    std::vector<Locale > GetSupportedLocales();
    void SetLocale(Locale& locale);
    UnitsOfMeasurement GetUnitsOfMeasurement();

public:
private:
    Version m_version;
    Locale m_locale;
    std::vector<Locale > m_locale_list;
    UnitsOfMeasurement m_units_of_measurement;
};

#endif
