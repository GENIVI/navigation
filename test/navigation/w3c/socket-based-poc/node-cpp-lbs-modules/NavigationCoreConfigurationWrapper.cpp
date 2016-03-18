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

#include "NavigationCoreConfigurationWrapper.hpp"


v8::Persistent<v8::FunctionTemplate> NavigationCoreConfigurationWrapper::constructor;
v8::Persistent<v8::Function> NavigationCoreConfigurationWrapper::callbackConfigurationChanged;

void NavigationCoreConfigurationWrapper::ConfigurationChanged(const std::vector< int32_t >& changedSettings) {
    v8::HandleScope scope;

    const unsigned argc = changedSettings.size();
    v8::Local<v8::Value> argv[argc];
    for(unsigned i=0;i<changedSettings.size();i++)
    {
        argv[i]=v8::Int32::New(changedSettings.at(i));
    }

    callbackConfigurationChanged->Call(v8::Context::GetCurrent()->Global(), argc, argv);
}

void NavigationCoreConfigurationWrapper::Init(v8::Handle<v8::Object> target) {
    v8::HandleScope scope;

    v8::Local<v8::FunctionTemplate> tpl = v8::FunctionTemplate::New(New);
    v8::Local<v8::String> name = v8::String::NewSymbol("NavigationCoreConfigurationWrapper");

    constructor = v8::Persistent<v8::FunctionTemplate>::New(tpl);
    // ObjectWrap uses the first internal field to store the wrapped pointer.
    constructor->InstanceTemplate()->SetInternalFieldCount(1);
    constructor->SetClassName(name);

    // Add all prototype methods, getters and setters here.
    NODE_SET_PROTOTYPE_METHOD(constructor, "getVersion", GetVersion);
    NODE_SET_PROTOTYPE_METHOD(constructor, "getSupportedLocales", GetSupportedLocales);
    NODE_SET_PROTOTYPE_METHOD(constructor, "getProperty", GetProperty);
    NODE_SET_PROTOTYPE_METHOD(constructor, "setProperty", SetProperty);
    NODE_SET_PROTOTYPE_METHOD(constructor, "getUnitsOfMeasurement", GetUnitsOfMeasurement);
    NODE_SET_PROTOTYPE_METHOD(constructor, "setConfigurationChangedListener", SetConfigurationChangedListener);

    // This has to be last, otherwise the properties won't show up on the
    // object in JavaScript.
    target->Set(name, constructor->GetFunction());
}

NavigationCoreConfigurationWrapper::NavigationCoreConfigurationWrapper() {
}

NavigationCoreConfigurationWrapper::~NavigationCoreConfigurationWrapper() {
}

v8::Handle<v8::Value> NavigationCoreConfigurationWrapper::New(const v8::Arguments& args) {
    v8::HandleScope scope;

    if (!args.IsConstructCall()) {
        return v8::ThrowException(v8::Exception::TypeError(
            v8::String::New("Use the new operator to create instances of this object."))
        );
    }
    // Creates a new instance object of this type and wraps it.
    NavigationCoreConfigurationWrapper* obj = new NavigationCoreConfigurationWrapper();

    NavigationCoreProxy* proxy = new NavigationCoreProxy(obj);

    obj->mp_navigationCoreProxy = proxy;
    obj->Wrap(args.This());

    return args.This();
}

v8::Handle<v8::Value> NavigationCoreConfigurationWrapper::GetProperty(const v8::Arguments& args) {
    v8::HandleScope scope; //to properly clean up v8 handles

    if (args.Length() < 1) {
        return v8::ThrowException(
        v8::Exception::TypeError(v8::String::New("getProperty requires at least 1 argument"))
        );
    }
    v8::String::Utf8Value str(args[0]->ToString());
    std::string propertyName = std::string(*str);

    if(propertyName == "Locale") {
        // Retrieves the pointer to the wrapped object instance.
        NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

        v8::Local<v8::Object> ret = v8::Object::New();
        Locale localeValue;
        obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->GetLocale(localeValue.languageCode,localeValue.countryCode,localeValue.scriptCode);
        ret->Set( 0, v8::String::New(propertyName.c_str()) );
        ret->Set( 1, v8::String::New(localeValue.languageCode.c_str()) );
        ret->Set( 2, v8::String::New(localeValue.countryCode.c_str()) );
        ret->Set( 3, v8::String::New(localeValue.scriptCode.c_str()) );
        return scope.Close(ret);
    }
    else
    {
        if(propertyName == "TimeFormat") {
            // Retrieves the pointer to the wrapped object instance.
            NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

            v8::Local<v8::Object> ret = v8::Object::New();

            return scope.Close(ret);
        }
        else
        {
            if(propertyName == "CoordinatesFormat") {
                // Retrieves the pointer to the wrapped object instance.
                NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

                v8::Local<v8::Object> ret = v8::Object::New();

                return scope.Close(ret);
            }
        }
    }
    return v8::Undefined();
}

v8::Handle<v8::Value> NavigationCoreConfigurationWrapper::SetProperty(const v8::Arguments& args)
{
    v8::HandleScope scope; //to properly clean up v8 handles

    if (args.Length() < 1) {
        return v8::ThrowException(
        v8::Exception::TypeError(v8::String::New("setProperty requires at least 1 argument"))
        );
    }
    v8::Handle<v8::Object> property_obj = v8::Handle<v8::Object>::Cast(args[0]);

    v8::Handle<v8::Value> property = property_obj->Get(v8::String::New("property"));

    v8::String::Utf8Value str(property->ToString());

    if(std::string(*str) == "Locale")
    {
        Locale localeValue;
        v8::Handle<v8::Value> languageCodeValue = property_obj->Get(v8::String::New("languageCode"));
        v8::String::Utf8Value languageCode(languageCodeValue->ToString());
        localeValue.languageCode = std::string(*languageCode);
        v8::Handle<v8::Value> countryCodeValue = property_obj->Get(v8::String::New("countryCode"));
        v8::String::Utf8Value countryCode(countryCodeValue->ToString());
        localeValue.countryCode = std::string(*countryCode);
        v8::Handle<v8::Value> scriptCodeValue = property_obj->Get(v8::String::New("scriptCode"));
        v8::String::Utf8Value scriptCode(scriptCodeValue->ToString());
        localeValue.scriptCode = std::string(*scriptCode);

        // Retrieves the pointer to the wrapped object instance.
        NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());
        obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->SetLocale(localeValue.languageCode,localeValue.countryCode,localeValue.scriptCode);
    }

    return v8::Undefined();
}

v8::Handle<v8::Value> NavigationCoreConfigurationWrapper::GetVersion(const v8::Arguments& args) {
    v8::HandleScope scope; //to properly clean up v8 handles

	// Retrieves the pointer to the wrapped object instance.
    NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

    ::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > DBus_version = obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->GetVersion();

    v8::Local<v8::Object> ret = v8::Object::New();
    ret->Set( 0, v8::Int32::New(DBus_version._1) );
    ret->Set( 1, v8::Int32::New(DBus_version._2) );
    ret->Set( 2, v8::Int32::New(DBus_version._3) );
    ret->Set( 3, v8::String::New(DBus_version._4.c_str()) );

    return scope.Close(ret);
}

v8::Handle<v8::Value> NavigationCoreConfigurationWrapper::GetSupportedLocales(const v8::Arguments& args) {
    v8::HandleScope scope; //to properly clean up v8 handles

    // Retrieves the pointer to the wrapped object instance.
    NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

    std::vector< ::DBus::Struct< std::string, std::string, std::string > > localeList = obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->GetSupportedLocales();

    v8::Local<v8::Array> ret = v8::Array::New();
    for (unsigned i=0;i<localeList.size();i++)
    {
        v8::Local<v8::Object> data = v8::Object::New();
        data->Set( 0, v8::String::New(localeList.at(i)._1.c_str()) );
        data->Set( 1, v8::String::New(localeList.at(i)._2.c_str()) );
        data->Set( 2, v8::String::New(localeList.at(i)._3.c_str()) );
        ret->Set(ret->Length(), data);
    }

    return scope.Close(ret);
}

v8::Handle<v8::Value> NavigationCoreConfigurationWrapper::GetUnitsOfMeasurement(const v8::Arguments& args)
{
    v8::HandleScope scope; //to properly clean up v8 handles

    // Retrieves the pointer to the wrapped object instance.
    NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

    NavigationCoreConfigurationProxy::UnitsOfMeasurement unitsOfMeasurement = obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->GetUnitsOfMeasurement();

    v8::Local<v8::Array> ret = v8::Array::New();
    for (NavigationCoreConfigurationProxy::UnitsOfMeasurement::iterator iter = unitsOfMeasurement.begin(); iter != unitsOfMeasurement.end(); iter++) {
        v8::Local<v8::Object> data = v8::Object::New();
        NavigationCoreConfigurationProxy::UnitsOfMeasurementValueStruct unitsOfMeasurement;
        unitsOfMeasurement = iter->second;
        data->Set(v8::String::New("key"), v8::Int32::New(iter->first));
        switch (unitsOfMeasurement.type) {
        case NavigationCoreConfigurationProxy::intValue:
            data->Set(v8::String::New("value"), v8::Int32::New(unitsOfMeasurement.value.intValue));
            break;
        case NavigationCoreConfigurationProxy::doubleValue:
        default:
            data->Set(v8::String::New("value"), v8::Number::New(unitsOfMeasurement.value.doubleValue));
            break;
        }
        ret->Set(ret->Length(), data);
    }
    return scope.Close(ret);
}

v8::Handle<v8::Value> NavigationCoreConfigurationWrapper::SetConfigurationChangedListener(const v8::Arguments& args)
{
    v8::HandleScope scope; //to properly clean up v8 handles

    if (!args[0]->IsFunction()) {
        return v8::ThrowException(
        v8::Exception::TypeError(v8::String::New("SetConfigurationChangedListener requires a function as parameter"))
        );
    }

    v8::Persistent<v8::Function> callback(v8::Local<v8::Function>::Cast(args[0]));
    callbackConfigurationChanged = callback;

    v8::Local<v8::Object> ret = v8::Object::New();
    ret->Set( 0, v8::Boolean::New(callbackConfigurationChanged->IsFunction()) );

    return scope.Close(ret);
}

void RegisterModule(v8::Handle<v8::Object> target) {
    NavigationCoreConfigurationWrapper::Init(target);
}

NODE_MODULE(NavigationCoreConfigurationWrapper, RegisterModule);
