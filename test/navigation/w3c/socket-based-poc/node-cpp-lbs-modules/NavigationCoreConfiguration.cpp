#include <node.h>

#include "NavigationCoreConfiguration.hpp"

using namespace v8;
using namespace std;
using namespace org::genivi::navigationcore;

Persistent<FunctionTemplate> NavigationCoreConfiguration::constructor;

void NavigationCoreConfiguration::ConfigurationChanged(const Handle<Function>& callback, const Handle<Array>& array) {
    HandleScope scope;
    // In case the operation succeeded, convention is to pass null as the
    // first argument before the result arguments.
    const unsigned argc = array->Length() + 1;
    Local<Value> argv[argc];
    argv[0] = Local<Value>::New(Null());

    String::Utf8Value str(argv[argc]->ToString());

    // Note: When calling this in an asynchronous function that just returned
    // from the threadpool, you have to wrap this in a v8::TryCatch.
    // You can also pass another handle as the "this" parameter.
    callback->Call(Context::GetCurrent()->Global(), argc, argv);
}

void NavigationCoreConfiguration::Init(Handle<Object> target) {
    HandleScope scope;

    Local<FunctionTemplate> tpl = FunctionTemplate::New(New);
    Local<String> name = String::NewSymbol("NavigationCoreConfiguration");

    constructor = Persistent<FunctionTemplate>::New(tpl);
    // ObjectWrap uses the first internal field to store the wrapped pointer.
    constructor->InstanceTemplate()->SetInternalFieldCount(1);
    constructor->SetClassName(name);

    // Add all prototype methods, getters and setters here.
    NODE_SET_PROTOTYPE_METHOD(constructor, "getVersion", GetVersion);
    NODE_SET_PROTOTYPE_METHOD(constructor, "getSupportedLocales", GetSupportedLocales);
    NODE_SET_PROTOTYPE_METHOD(constructor, "getProperty", GetProperty);
    NODE_SET_PROTOTYPE_METHOD(constructor, "setProperty", SetProperty);
    NODE_SET_PROTOTYPE_METHOD(constructor, "getUnitsOfMeasurement", GetUnitsOfMeasurement);

    // This has to be last, otherwise the properties won't show up on the
    // object in JavaScript.
    target->Set(name, constructor->GetFunction());
}

NavigationCoreConfiguration::NavigationCoreConfiguration() : ObjectWrap() {}

Handle<Value> NavigationCoreConfiguration::New(const Arguments& args) {
    HandleScope scope;

    if (!args.IsConstructCall()) {
        return ThrowException(Exception::TypeError(
            String::New("Use the new operator to create instances of this object."))
        );
    }

    // Creates a new instance object of this type and wraps it.
    NavigationCoreConfiguration* obj = new NavigationCoreConfiguration();
    obj->Wrap(args.This());

    return args.This();
}

Handle<Value> NavigationCoreConfiguration::GetProperty(const Arguments& args) {
    HandleScope scope; //to properly clean up v8 handles

    if (args.Length() < 1) {
        return ThrowException(
        Exception::TypeError(String::New("getProperty requires at least 1 argument"))
        );
    }
    String::Utf8Value str(args[0]->ToString());
    string propertyName = std::string(*str);

    if(propertyName == "Locale") {
        // Retrieves the pointer to the wrapped object instance.
        NavigationCoreConfiguration* obj = ObjectWrap::Unwrap<NavigationCoreConfiguration>(args.This());

        Local<Object> ret = Object::New();

        Locale localeValue = obj->m_proxy.GetLocale();
        ret->Set( 0, String::New(propertyName.c_str()) );
        ret->Set( 1, String::New(localeValue.languageCode.c_str()) );
        ret->Set( 2, String::New(localeValue.countryCode.c_str()) );
        ret->Set( 3, String::New(localeValue.scriptCode.c_str()) );
        return scope.Close(ret);
    }
    else
    {
        if(propertyName == "TimeFormat") {
            // Retrieves the pointer to the wrapped object instance.
            NavigationCoreConfiguration* obj = ObjectWrap::Unwrap<NavigationCoreConfiguration>(args.This());

            Local<Object> ret = Object::New();

            return scope.Close(ret);
        }
        else
        {
            if(propertyName == "CoordinatesFormat") {
                // Retrieves the pointer to the wrapped object instance.
                NavigationCoreConfiguration* obj = ObjectWrap::Unwrap<NavigationCoreConfiguration>(args.This());

                Local<Object> ret = Object::New();

                return scope.Close(ret);
            }
        }
    }
    return Undefined();
}

Handle<Value> NavigationCoreConfiguration::SetProperty(const Arguments& args)
{
    HandleScope scope; //to properly clean up v8 handles

    if (args.Length() < 1) {
        return ThrowException(
        Exception::TypeError(String::New("setProperty requires at least 1 argument"))
        );
    }
    Handle<Object> property_obj = Handle<Object>::Cast(args[0]);

    Handle<Value> property = property_obj->Get(String::New("property"));

    String::Utf8Value str(property->ToString());

    if(std::string(*str) == "Locale")
    {
        Locale localeValue;
        Handle<Value> languageCodeValue = property_obj->Get(String::New("languageCode"));
        String::Utf8Value languageCode(languageCodeValue->ToString());
        localeValue.languageCode = std::string(*languageCode);
        Handle<Value> countryCodeValue = property_obj->Get(String::New("countryCode"));
        String::Utf8Value countryCode(countryCodeValue->ToString());
        localeValue.countryCode = std::string(*countryCode);
        Handle<Value> scriptCodeValue = property_obj->Get(String::New("scriptCode"));
        String::Utf8Value scriptCode(scriptCodeValue->ToString());
        localeValue.scriptCode = std::string(*scriptCode);

        // Retrieves the pointer to the wrapped object instance.
        NavigationCoreConfiguration* obj = ObjectWrap::Unwrap<NavigationCoreConfiguration>(args.This());
        obj->m_proxy.SetLocale(localeValue);

        Handle<Value> callBackValue = property_obj->Get(String::New("callBack"));

        if (callBackValue->IsFunction()) { //callback used
            Handle<Function> callBackFunction = Handle<Function>::Cast(callBackValue);
            Handle<Array> array = Array::New(1);
            Local<String> v = String::New("LOCALE");
            array->Set(0, v);
            ConfigurationChanged(callBackFunction,array);
        }
    }

    return Undefined();
}

Handle<Value> NavigationCoreConfiguration::GetVersion(const Arguments& args) {
    HandleScope scope; //to properly clean up v8 handles

	// Retrieves the pointer to the wrapped object instance.
    NavigationCoreConfiguration* obj = ObjectWrap::Unwrap<NavigationCoreConfiguration>(args.This());

    Version version = obj->m_proxy.GetVersion();

    Local<Object> ret = Object::New();
    ret->Set( 0, Int32::New(version.versionMajor) );
    ret->Set( 1, Int32::New(version.versionMinor) );
    ret->Set( 2, Int32::New(version.versionMicro) );
    ret->Set( 3, String::New(version.date.c_str()) );

    return scope.Close(ret);
}

Handle<Value> NavigationCoreConfiguration::GetSupportedLocales(const Arguments& args) {
    HandleScope scope; //to properly clean up v8 handles

    // Retrieves the pointer to the wrapped object instance.
    NavigationCoreConfiguration* obj = ObjectWrap::Unwrap<NavigationCoreConfiguration>(args.This());

    std::vector<Locale > localeList = obj->m_proxy.GetSupportedLocales();

    Local<Array> ret = Array::New();
    for (unsigned i=0;i<localeList.size();i++)
    {
        Local<Object> data = Object::New();
        data->Set( 0, String::New(localeList.at(i).languageCode.c_str()) );
        data->Set( 1, String::New(localeList.at(i).countryCode.c_str()) );
        data->Set( 2, String::New(localeList.at(i).scriptCode.c_str()) );
        ret->Set(ret->Length(), data);
    }

    return scope.Close(ret);
}

Handle<Value> NavigationCoreConfiguration::GetUnitsOfMeasurement(const Arguments& args)
{
    HandleScope scope; //to properly clean up v8 handles

    // Retrieves the pointer to the wrapped object instance.
    NavigationCoreConfiguration* obj = ObjectWrap::Unwrap<NavigationCoreConfiguration>(args.This());

    Configuration_proxy::UnitsOfMeasurement unitsOfMeasurement = obj->m_proxy.GetUnitsOfMeasurement();

    Local<Array> ret = Array::New();
    for (Configuration_proxy::UnitsOfMeasurement::iterator iter = unitsOfMeasurement.begin(); iter != unitsOfMeasurement.end(); iter++) {
        Local<Object> data = Object::New();
        Configuration_proxy::UnitsOfMeasurementValueStruct unitsOfMeasurement;
        unitsOfMeasurement = iter->second;
        data->Set(String::New("key"), Int32::New(iter->first));
        switch (unitsOfMeasurement.type) {
        case Configuration_proxy::intValue:
            data->Set(String::New("value"), Int32::New(unitsOfMeasurement.value.intValue));
            break;
        case Configuration_proxy::doubleValue:
        default:
            data->Set(String::New("value"), Number::New(unitsOfMeasurement.value.doubleValue));
            break;
        }
        ret->Set(ret->Length(), data);
    }
    return scope.Close(ret);
}

void RegisterModule(Handle<Object> target) {
    NavigationCoreConfiguration::Init(target);
}

NODE_MODULE(NavigationCoreConfiguration, RegisterModule);
