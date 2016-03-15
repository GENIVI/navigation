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
    UnitsOfMeasurement GetUnitsOfMeasurement();

private:
    UnitsOfMeasurement m_units_of_measurement;
};

class NavigationCoreProxy
{
public:
    NavigationCoreProxy();
    ~NavigationCoreProxy();

    NavigationCoreConfigurationProxy* mp_configurationProxy;
};

#endif
