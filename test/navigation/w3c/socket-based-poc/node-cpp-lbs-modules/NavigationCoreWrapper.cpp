/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2016, PCA Peugeot Citroen
*
* \file main.cpp
*
* \brief This file is part of the Navigation Web API proof of concept.
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
#include <node.h>

#include "NavigationCoreWrapper.hpp"

using namespace v8;
using namespace std;


Persistent<FunctionTemplate> NavigationCoreWrapper::constructor;

void NavigationCoreWrapper::ConfigurationChanged(const Handle<Function>& callback, const Handle<Array>& array) {
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

void NavigationCoreWrapper::Init(Handle<Object> target) {
    HandleScope scope;

    Local<FunctionTemplate> tpl = FunctionTemplate::New(New);
    Local<String> name = String::NewSymbol("NavigationCoreWrapper");

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

NavigationCoreWrapper::NavigationCoreWrapper() {
}

NavigationCoreWrapper::~NavigationCoreWrapper() {
}

Handle<Value> NavigationCoreWrapper::New(const Arguments& args) {
    HandleScope scope;

    if (!args.IsConstructCall()) {
        return ThrowException(Exception::TypeError(
            String::New("Use the new operator to create instances of this object."))
        );
    }
    NavigationCoreProxy* proxy = new NavigationCoreProxy();

    // Creates a new instance object of this type and wraps it.
    NavigationCoreWrapper* obj = new NavigationCoreWrapper();
    obj->mp_proxy = proxy;
    obj->Wrap(args.This());

    return args.This();
}

Handle<Value> NavigationCoreWrapper::GetProperty(const Arguments& args) {
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
        NavigationCoreWrapper* obj = ObjectWrap::Unwrap<NavigationCoreWrapper>(args.This());

        Local<Object> ret = Object::New();
        Locale localeValue;
        obj->mp_proxy->mp_configurationProxy->GetLocale(localeValue.languageCode,localeValue.countryCode,localeValue.scriptCode);
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
            NavigationCoreWrapper* obj = ObjectWrap::Unwrap<NavigationCoreWrapper>(args.This());

            Local<Object> ret = Object::New();

            return scope.Close(ret);
        }
        else
        {
            if(propertyName == "CoordinatesFormat") {
                // Retrieves the pointer to the wrapped object instance.
                NavigationCoreWrapper* obj = ObjectWrap::Unwrap<NavigationCoreWrapper>(args.This());

                Local<Object> ret = Object::New();

                return scope.Close(ret);
            }
        }
    }
    return Undefined();
}

Handle<Value> NavigationCoreWrapper::SetProperty(const Arguments& args)
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
        NavigationCoreWrapper* obj = ObjectWrap::Unwrap<NavigationCoreWrapper>(args.This());
        obj->mp_proxy->mp_configurationProxy->SetLocale(localeValue.languageCode,localeValue.countryCode,localeValue.scriptCode);

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

Handle<Value> NavigationCoreWrapper::GetVersion(const Arguments& args) {
    HandleScope scope; //to properly clean up v8 handles

	// Retrieves the pointer to the wrapped object instance.
    NavigationCoreWrapper* obj = ObjectWrap::Unwrap<NavigationCoreWrapper>(args.This());

    ::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > DBus_version = obj->mp_proxy->mp_configurationProxy->GetVersion();

    Local<Object> ret = Object::New();
    ret->Set( 0, Int32::New(DBus_version._1) );
    ret->Set( 1, Int32::New(DBus_version._2) );
    ret->Set( 2, Int32::New(DBus_version._3) );
    ret->Set( 3, String::New(DBus_version._4.c_str()) );

    return scope.Close(ret);
}

Handle<Value> NavigationCoreWrapper::GetSupportedLocales(const Arguments& args) {
    HandleScope scope; //to properly clean up v8 handles

    // Retrieves the pointer to the wrapped object instance.
    NavigationCoreWrapper* obj = ObjectWrap::Unwrap<NavigationCoreWrapper>(args.This());

    std::vector< ::DBus::Struct< std::string, std::string, std::string > > localeList = obj->mp_proxy->mp_configurationProxy->GetSupportedLocales();

    Local<Array> ret = Array::New();
    for (unsigned i=0;i<localeList.size();i++)
    {
        Local<Object> data = Object::New();
        data->Set( 0, String::New(localeList.at(i)._1.c_str()) );
        data->Set( 1, String::New(localeList.at(i)._2.c_str()) );
        data->Set( 2, String::New(localeList.at(i)._3.c_str()) );
        ret->Set(ret->Length(), data);
    }

    return scope.Close(ret);
}

Handle<Value> NavigationCoreWrapper::GetUnitsOfMeasurement(const Arguments& args)
{
    HandleScope scope; //to properly clean up v8 handles

    // Retrieves the pointer to the wrapped object instance.
    NavigationCoreWrapper* obj = ObjectWrap::Unwrap<NavigationCoreWrapper>(args.This());

    NavigationCoreConfigurationProxy::UnitsOfMeasurement unitsOfMeasurement = obj->mp_proxy->mp_configurationProxy->GetUnitsOfMeasurement();

    Local<Array> ret = Array::New();
    for (NavigationCoreConfigurationProxy::UnitsOfMeasurement::iterator iter = unitsOfMeasurement.begin(); iter != unitsOfMeasurement.end(); iter++) {
        Local<Object> data = Object::New();
        NavigationCoreConfigurationProxy::UnitsOfMeasurementValueStruct unitsOfMeasurement;
        unitsOfMeasurement = iter->second;
        data->Set(String::New("key"), Int32::New(iter->first));
        switch (unitsOfMeasurement.type) {
        case NavigationCoreConfigurationProxy::intValue:
            data->Set(String::New("value"), Int32::New(unitsOfMeasurement.value.intValue));
            break;
        case NavigationCoreConfigurationProxy::doubleValue:
        default:
            data->Set(String::New("value"), Number::New(unitsOfMeasurement.value.doubleValue));
            break;
        }
        ret->Set(ret->Length(), data);
    }
    return scope.Close(ret);
}

void RegisterModule(Handle<Object> target) {
    NavigationCoreWrapper::Init(target);
}

NODE_MODULE(NavigationCoreWrapper, RegisterModule);
