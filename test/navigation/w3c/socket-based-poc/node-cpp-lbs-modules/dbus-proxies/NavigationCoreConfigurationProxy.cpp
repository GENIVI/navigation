#include <node.h>

#include "NavigationCoreConfigurationProxy.hpp"

using namespace v8;
using namespace std;

NavigationCoreConfigurationProxy::NavigationCoreConfigurationProxy(DBus::Connection &connection)
    :    DBus::ObjectProxy(connection,
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

void NavigationCoreConfigurationProxy::ConfigurationChanged(const std::vector< int32_t >& changedSettings)
{

}

Version NavigationCoreConfigurationProxy::GetVersion()
{
    ::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > DBus_version;
    Version version;
    DBus_version = Configuration_proxy::GetVersion();
    version.versionMajor = DBus_version._1;
    version.versionMinor = DBus_version._2;
    version.versionMicro = DBus_version._3;
    version.date = DBus_version._4;
    return version;
}

Locale NavigationCoreConfigurationProxy::GetLocale()
{
    return m_locale;
}
std::vector<Locale > NavigationCoreConfigurationProxy::GetSupportedLocales()
{
    return m_locale_list;
}

void NavigationCoreConfigurationProxy::SetLocale(Locale& locale)
{
    m_locale = locale;
}

NavigationCoreConfigurationProxy::UnitsOfMeasurement NavigationCoreConfigurationProxy::GetUnitsOfMeasurement()
{
    return m_units_of_measurement;
}

