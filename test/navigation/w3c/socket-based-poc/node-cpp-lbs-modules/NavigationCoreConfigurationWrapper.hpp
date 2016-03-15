#ifndef NAVIGATIONCORECONFIGURATIONWRAPPER_HPP
#define NAVIGATIONCORECONFIGURATIONWRAPPER_HPP

#define USE_DBUS 0

#include <node.h>
#include <node_buffer.h>

#include "./dbus-proxies/NavigationCoreConfigurationProxy.hpp"

#include <string>
#include <vector>
#include <map>

// Do not include this line. It's generally frowned upon to use namespaces
// in header files as it may cause issues with other code that includes your
// header file.
// using namespace v8;

class NavigationCoreConfigurationWrapper : public node::ObjectWrap {
public:
    static v8::Persistent<v8::FunctionTemplate> constructor;
    static void Init(v8::Handle<v8::Object> target);

protected:
    NavigationCoreConfigurationWrapper();
    ~NavigationCoreConfigurationWrapper();

    static v8::Handle<v8::Value> New(const v8::Arguments& args);
    static v8::Handle<v8::Value> GetVersion(const v8::Arguments& args);
    static v8::Handle<v8::Value> GetSupportedLocales(const v8::Arguments& args);
    static v8::Handle<v8::Value> GetUnitsOfMeasurement(const v8::Arguments& args);

    static v8::Handle<v8::Value> GetProperty(const v8::Arguments& args);
    static v8::Handle<v8::Value> SetProperty(const v8::Arguments& args);

    static void ConfigurationChanged(const v8::Handle<v8::Function> &callback, const v8::Handle<v8::Array>& array);

private:

    NavigationCoreProxy* mp_proxy;
};

#endif
