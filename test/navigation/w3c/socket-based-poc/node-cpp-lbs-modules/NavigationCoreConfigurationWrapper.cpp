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
#include <string>

#include "./common/debug.h"

#include "NavigationCoreConfigurationWrapper.hpp"

v8::Persistent<v8::Function> NavigationCoreConfigurationWrapper::constructor;
v8::Persistent<v8::Function> NavigationCoreConfigurationWrapper::signalConfigurationChanged;

void NavigationCoreConfigurationWrapper::ConfigurationChanged(const std::vector< int32_t >& changedSettings) {
    printTimeStamp("ConfigurationChanged wrapper");
    v8::Isolate* isolate = v8::Isolate::GetCurrent();
    v8::HandleScope handleScope(isolate);
    const unsigned argc = changedSettings.size();
    v8::Local<v8::Value> argv[argc];
    for(unsigned i=0;i<changedSettings.size();i++)
    {
        argv[i]=v8::Local<v8::Value>::New(isolate,v8::Int32::New(isolate,changedSettings.at(i)));
    }
    v8::Local<v8::Function> fct = v8::Local<v8::Function>::New(isolate,signalConfigurationChanged);
    fct->Call(isolate->GetCurrentContext()->Global(), argc, argv);
}

void NavigationCoreConfigurationWrapper::SetConfigurationChangedListener(const v8::FunctionCallbackInfo<v8::Value>& args)
{
    v8::Isolate* isolate = args.GetIsolate();

    if (!args[0]->IsFunction()) {
        isolate->ThrowException(
        v8::Exception::TypeError(v8::String::NewFromUtf8(isolate,"Requires a function as parameter"))
        );
    }

    v8::Local<v8::Function> fct = v8::Local<v8::Function>::Cast(args[0]);
    v8::Persistent<v8::Function> persfct(isolate,fct);
    signalConfigurationChanged.Reset(isolate,persfct);;

    v8::Local<v8::Object> ret = v8::Object::New(isolate);
    ret->Set( 0, v8::Boolean::New(isolate, v8::True) );

    args.GetReturnValue().Set(ret);
}

void NavigationCoreConfigurationWrapper::Init(v8::Local<v8::Object> target) {
    v8::Isolate* isolate = target->GetIsolate();

    // Prepare constructor template
    v8::Local<v8::FunctionTemplate> tpl = v8::FunctionTemplate::New(isolate, New);
    tpl->SetClassName(v8::String::NewFromUtf8(isolate, "NavigationCoreConfigurationWrapper"));
    tpl->InstanceTemplate()->SetInternalFieldCount(1);

    // Add all prototype methods, getters and setters here.
    NODE_SET_PROTOTYPE_METHOD(tpl, "getVersion", GetVersion);
    NODE_SET_PROTOTYPE_METHOD(tpl, "getSupportedLocales", GetSupportedLocales);
    NODE_SET_PROTOTYPE_METHOD(tpl, "getProperty", GetProperty);
    NODE_SET_PROTOTYPE_METHOD(tpl, "setProperty", SetProperty);
    NODE_SET_PROTOTYPE_METHOD(tpl, "getUnitsOfMeasurement", GetUnitsOfMeasurement);
    NODE_SET_PROTOTYPE_METHOD(tpl, "setUnitsOfMeasurement", SetUnitsOfMeasurement);
    NODE_SET_PROTOTYPE_METHOD(tpl, "setConfigurationChangedListener", SetConfigurationChangedListener);

    // This has to be last, otherwise the properties won't show up on the
    // object in JavaScript.
    constructor.Reset(isolate, tpl->GetFunction());
    target->Set(v8::String::NewFromUtf8(isolate, "NavigationCoreConfigurationWrapper"),
                 tpl->GetFunction());
}

NavigationCoreConfigurationWrapper::NavigationCoreConfigurationWrapper() {
}

NavigationCoreConfigurationWrapper::~NavigationCoreConfigurationWrapper() {
}

void NavigationCoreConfigurationWrapper::New(const v8::FunctionCallbackInfo<v8::Value>& args) {
    v8::Isolate* isolate = args.GetIsolate();

    if (args.IsConstructCall()) {
      // Invoked as constructor: `new MyObject(...)`
//      double value = args[0]->IsUndefined() ? 0 : args[0]->NumberValue(); //no parameters
      NavigationCoreConfigurationWrapper* obj = new NavigationCoreConfigurationWrapper();
      obj->Wrap(args.This());
      args.GetReturnValue().Set(args.This());

      NavigationCoreProxy* proxy = new NavigationCoreProxy(obj);
      obj->mp_navigationCoreProxy = proxy;
    } else { // not tested yet
      // Invoked as plain function `MyObject(...)`, turn into construct call.
      const int argc = 1;
      v8::Local<v8::Value> argv[argc] = { args[0] };
      v8::Local<v8::Context> context = isolate->GetCurrentContext();
      v8::Local<v8::Function> cons = v8::Local<v8::Function>::New(isolate, constructor);
      v8::Local<v8::Object> result = cons->NewInstance(context, argc, argv).ToLocalChecked();
      args.GetReturnValue().Set(result);

//      NavigationCoreProxy* proxy = new NavigationCoreProxy(result);
//      result->mp_navigationCoreProxy = proxy;
    }
}

void NavigationCoreConfigurationWrapper::NewInstance(const v8::FunctionCallbackInfo<v8::Value>& args) {
  v8::Isolate* isolate = args.GetIsolate();

  const unsigned argc = 1;
  v8::Local<v8::Value> argv[argc] = { args[0] };
  v8::Local<v8::Function> cons = v8::Local<v8::Function>::New(isolate, constructor);
  v8::Local<v8::Context> context = isolate->GetCurrentContext();
  v8::Local<v8::Object> instance =
      cons->NewInstance(context, argc, argv).ToLocalChecked();

  args.GetReturnValue().Set(instance);
}

void NavigationCoreConfigurationWrapper::GetProperty(const v8::FunctionCallbackInfo<v8::Value>& args) {
    v8::Isolate* isolate = args.GetIsolate();

    if (args.Length() < 1) {
        isolate->ThrowException(
        v8::Exception::TypeError(v8::String::NewFromUtf8(isolate,"getProperty requires at least 1 argument"))
        );
    }
    v8::String::Utf8Value str(args[0]->ToString());
    std::string propertyName = std::string(*str);

    if(propertyName == "Locale") {
        // Retrieves the pointer to the wrapped object instance.
        NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.Holder());

        v8::Local<v8::Object> ret = v8::Object::New(isolate);
        Locale localeValue;
        obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->GetLocale(localeValue.languageCode,localeValue.countryCode,localeValue.scriptCode);
        ret->Set( 0, v8::String::NewFromUtf8(isolate,propertyName.c_str()) );
        ret->Set( 1, v8::String::NewFromUtf8(isolate,localeValue.languageCode.c_str()) );
        ret->Set( 2, v8::String::NewFromUtf8(isolate,localeValue.countryCode.c_str()) );
        ret->Set( 3, v8::String::NewFromUtf8(isolate,localeValue.scriptCode.c_str()) );
        args.GetReturnValue().Set(ret);
    }
    else
    {
        if(propertyName == "TimeFormat") {
            // Retrieves the pointer to the wrapped object instance.
            NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

            v8::Local<v8::Object> ret = v8::Object::New(isolate);
            int32_t value = obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->GetTimeFormat();
            ret->Set( 0, v8::String::NewFromUtf8(isolate,propertyName.c_str()) );
            ret->Set( 1, v8::Int32::New(isolate,value) );
            args.GetReturnValue().Set(ret);
        }
        else
        {
            if(propertyName == "CoordinatesFormat") {
                // Retrieves the pointer to the wrapped object instance.
                NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

                v8::Local<v8::Object> ret = v8::Object::New(isolate);
                int32_t value = obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->GetCoordinatesFormat();
                ret->Set( 0, v8::String::NewFromUtf8(isolate,propertyName.c_str()) );
                ret->Set( 1, v8::Int32::New(isolate,value) );
                args.GetReturnValue().Set(ret);
            }
        }
    }
}

void NavigationCoreConfigurationWrapper::SetProperty(const v8::FunctionCallbackInfo<v8::Value>& args)
{
    printTimeStamp("SetProperty");
    v8::Isolate* isolate = args.GetIsolate();

    if (args.Length() < 1) {
        isolate->ThrowException(
        v8::Exception::TypeError(v8::String::NewFromUtf8(isolate,"setProperty requires at least 1 argument"))
        );
    }
    v8::Local<v8::Object> property_obj = v8::Local<v8::Object>::Cast(args[0]);

    v8::Local<v8::Value> property = property_obj->Get(v8::String::NewFromUtf8(isolate,"property"));

    v8::String::Utf8Value str(property->ToString());

    if(std::string(*str) == "Locale")
    {
        Locale localeValue;
        v8::Local<v8::Value> languageCodeValue = property_obj->Get(v8::String::NewFromUtf8(isolate,"languageCode"));
        v8::String::Utf8Value languageCode(languageCodeValue->ToString());
        localeValue.languageCode = std::string(*languageCode);
        v8::Local<v8::Value> countryCodeValue = property_obj->Get(v8::String::NewFromUtf8(isolate,"countryCode"));
        v8::String::Utf8Value countryCode(countryCodeValue->ToString());
        localeValue.countryCode = std::string(*countryCode);
        v8::Local<v8::Value> scriptCodeValue = property_obj->Get(v8::String::NewFromUtf8(isolate,"scriptCode"));
        v8::String::Utf8Value scriptCode(scriptCodeValue->ToString());
        localeValue.scriptCode = std::string(*scriptCode);

        // Retrieves the pointer to the wrapped object instance.
        NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());
        obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->SetLocale(localeValue.languageCode,localeValue.countryCode,localeValue.scriptCode);
    }
    else
    {
        if(std::string(*str) == "TimeFormat") {
            v8::Local<v8::Value> timeFormatValue = property_obj->Get(v8::String::NewFromUtf8(isolate,"value"));
            int32_t timeFormat = timeFormatValue->ToInt32()->Int32Value();

            // Retrieves the pointer to the wrapped object instance.
            NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());
            obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->SetTimeFormat(timeFormat);
        }
        else
        {
            if(std::string(*str) == "CoordinatesFormat") {
                v8::Local<v8::Value> coordinatesFormatValue = property_obj->Get(v8::String::NewFromUtf8(isolate,"value"));
                int32_t coordinatesFormat = coordinatesFormatValue->ToInt32()->Int32Value();

                // Retrieves the pointer to the wrapped object instance.
                NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());
                obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->SetCoordinatesFormat(coordinatesFormat);
            }
        }
    }

    args.GetReturnValue().Set(v8::DEFAULT);
}

void NavigationCoreConfigurationWrapper::GetVersion(const v8::FunctionCallbackInfo<v8::Value>& args) {
    v8::Isolate* isolate = args.GetIsolate();

	// Retrieves the pointer to the wrapped object instance.
    NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

    ::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > DBus_version = obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->GetVersion();

    v8::Local<v8::Object> ret = v8::Object::New(isolate);
    ret->Set( 0, v8::Int32::New(isolate,DBus_version._1) );
    ret->Set( 1, v8::Int32::New(isolate,DBus_version._2) );
    ret->Set( 2, v8::Int32::New(isolate,DBus_version._3) );
    ret->Set( 3, v8::String::NewFromUtf8(isolate,DBus_version._4.c_str()) );

    args.GetReturnValue().Set(ret);
}

void NavigationCoreConfigurationWrapper::GetSupportedLocales(const v8::FunctionCallbackInfo<v8::Value>& args) {
    v8::Isolate* isolate = args.GetIsolate();

    // Retrieves the pointer to the wrapped object instance.
    NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

    std::vector< ::DBus::Struct< std::string, std::string, std::string > > localeList = obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->GetSupportedLocales();

    v8::Local<v8::Array> ret = v8::Array::New(isolate);
    for (unsigned i=0;i<localeList.size();i++)
    {
        v8::Local<v8::Object> data = v8::Object::New(isolate);
        data->Set( 0, v8::String::NewFromUtf8(isolate,localeList.at(i)._1.c_str()) );
        data->Set( 1, v8::String::NewFromUtf8(isolate,localeList.at(i)._2.c_str()) );
        data->Set( 2, v8::String::NewFromUtf8(isolate,localeList.at(i)._3.c_str()) );
        ret->Set(ret->Length(), data);
    }

    args.GetReturnValue().Set(ret);
}

void NavigationCoreConfigurationWrapper::GetUnitsOfMeasurement(const v8::FunctionCallbackInfo<v8::Value>& args)
{
    v8::Isolate* isolate = args.GetIsolate();

    // Retrieves the pointer to the wrapped object instance.
    NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());

    std::map< int32_t, int32_t > unitsOfMeasurement = obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->GetUnitsOfMeasurement();

    v8::Local<v8::Array> ret = v8::Array::New(isolate);
    for (std::map< int32_t, int32_t >::iterator iter = unitsOfMeasurement.begin(); iter != unitsOfMeasurement.end(); iter++) {
        v8::Local<v8::Object> data = v8::Object::New(isolate);
        data->Set(v8::String::NewFromUtf8(isolate,"key"), v8::Int32::New(isolate,iter->first));
        data->Set(v8::String::NewFromUtf8(isolate,"value"), v8::Int32::New(isolate,iter->second));
        ret->Set(ret->Length(), data);
    }
    args.GetReturnValue().Set(ret);
}

void NavigationCoreConfigurationWrapper::SetUnitsOfMeasurement(const v8::FunctionCallbackInfo<v8::Value>& args)
{
    v8::Isolate* isolate = args.GetIsolate();

    if (args.Length() < 1) {
        isolate->ThrowException(
        v8::Exception::TypeError(v8::String::NewFromUtf8(isolate,"setUnitsOfMeasurement requires at least 1 argument"))
        );
    }

    if (args[0]->IsArray()) {
        std::map< int32_t, int32_t > unitsOfMeasurementList;
        int32_t value;
        v8::Local<v8::Array> array = v8::Local<v8::Array>::Cast(args[0]);
        for (uint32_t i = 0; i < array->Length(); i++) {
            v8::Local<v8::Object> unitsOfMeasurement_obj = v8::Local<v8::Object>::Cast(array->Get(i));

            v8::Local<v8::Value> attributeCodeValue = unitsOfMeasurement_obj->Get(v8::String::NewFromUtf8(isolate,"attributeCode"));
            v8::Local<v8::Value> unitCodeValue = unitsOfMeasurement_obj->Get(v8::String::NewFromUtf8(isolate,"unitCode"));
            switch (attributeCodeValue->ToInt32()->Int32Value()) {
            case GENIVI_NAVIGATIONCORE_LENGTH:
                value = unitCodeValue->ToInt32()->Int32Value();
                unitsOfMeasurementList[GENIVI_NAVIGATIONCORE_LENGTH] = value;
                break;
            default:
                break;
            }

        }
        // Retrieves the pointer to the wrapped object instance.
        NavigationCoreConfigurationWrapper* obj = ObjectWrap::Unwrap<NavigationCoreConfigurationWrapper>(args.This());
        obj->mp_navigationCoreProxy->mp_navigationCoreConfigurationProxy->SetUnitsOfMeasurement(unitsOfMeasurementList);
    }

    args.GetReturnValue().Set(v8::DEFAULT);
}

void RegisterModule(v8::Handle<v8::Object> target) {
    NavigationCoreConfigurationWrapper::Init(target);
}

NODE_MODULE(NavigationCoreConfigurationWrapper, RegisterModule)
