#include <node.h>

#include "NavigationCoreConfigurationProxy.hpp"

using namespace v8;
using namespace std;

static DBus::Glib::BusDispatcher *dispatcher;
static DBus::Connection *connection;

NavigationCoreConfigurationProxy::NavigationCoreConfigurationProxy(DBus::Connection &connection)
    :    DBus::ObjectProxy(connection,
                           "/org/genivi/navigationcore",
                           "org.genivi.navigationcore.Configuration")
{

    UnitsOfMeasurementValueStruct value {intValue,METER};

    m_units_of_measurement[LENGTH] = value;
}

void NavigationCoreConfigurationProxy::ConfigurationChanged(const std::vector< int32_t >& changedSettings)
{

}

NavigationCoreConfigurationProxy::UnitsOfMeasurement NavigationCoreConfigurationProxy::GetUnitsOfMeasurement()
{
    return m_units_of_measurement;
}

NavigationCoreProxy::NavigationCoreProxy()
{
    dispatcher = new DBus::Glib::BusDispatcher();
    DBus::default_dispatcher = dispatcher;
    dispatcher->attach(NULL);
    connection = new DBus::Connection(DBus::Connection::SessionBus());
    connection->setup(dispatcher);
    mp_configurationProxy = new NavigationCoreConfigurationProxy(*connection);
}

NavigationCoreProxy::~NavigationCoreProxy()
{
    delete connection;
    delete dispatcher;
}
