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

#include "PositioningEnhancedPositionWrapper.hpp"

using namespace std;


v8::Persistent<v8::FunctionTemplate> PositioningEnhancedPositionWrapper::constructor;
v8::Persistent<v8::Function> PositioningEnhancedPositionWrapper::signalPositionUpdate;


void PositioningEnhancedPositionWrapper::PositionUpdate(const uint64_t& changedValues) {
    v8::HandleScope scope;

    const unsigned argc = 2;
    union {
        uint32_t msb;
        uint32_t lsb;
    };
    msb = changedValues & 0xFFFF0000; //dirty but quick, to be enhanced !
    lsb = changedValues & 0x0000FFFF;
    v8::Local<v8::Value> argv[argc];
    argv[0] = v8::Local<v8::Value>::New(v8::Uint32::New(msb));
    argv[1] = v8::Local<v8::Value>::New(v8::Uint32::New(lsb));

    signalPositionUpdate->Call(v8::Context::GetCurrent()->Global(), argc, argv);

}

v8::Handle<v8::Value> PositioningEnhancedPositionWrapper::SetPositionUpdateListener(const v8::Arguments& args)
{
    v8::HandleScope scope; //to properly clean up v8 handles

    if (!args[0]->IsFunction()) {
        return v8::ThrowException(
        v8::Exception::TypeError(v8::String::New("Requires a function as parameter"))
        );
    }

    v8::Persistent<v8::Function> callback(v8::Local<v8::Function>::Cast(args[0]));
    signalPositionUpdate = callback;

    v8::Local<v8::Object> ret = v8::Object::New();
    ret->Set( 0, v8::Boolean::New(signalPositionUpdate->IsFunction()) );

    return scope.Close(ret);
}

void PositioningEnhancedPositionWrapper::Init(v8::Handle<v8::Object> target) {
    v8::HandleScope scope;

    v8::Local<v8::FunctionTemplate> tpl = v8::FunctionTemplate::New(New);
    v8::Local<v8::String> name = v8::String::NewSymbol("PositioningWrapper");

    constructor = v8::Persistent<v8::FunctionTemplate>::New(tpl);
    // ObjectWrap uses the first internal field to store the wrapped pointer.
    constructor->InstanceTemplate()->SetInternalFieldCount(1);
    constructor->SetClassName(name);

    // Add all prototype methods, getters and setters here.
    NODE_SET_PROTOTYPE_METHOD(constructor, "getVersion", GetVersion);
    NODE_SET_PROTOTYPE_METHOD(constructor, "setPositionUpdateListener", SetPositionUpdateListener);

    // This has to be last, otherwise the properties won't show up on the
    // object in JavaScript.
    target->Set(name, constructor->GetFunction());
}

PositioningEnhancedPositionWrapper::PositioningEnhancedPositionWrapper() {
}

PositioningEnhancedPositionWrapper::~PositioningEnhancedPositionWrapper() {
}

v8::Handle<v8::Value> PositioningEnhancedPositionWrapper::New(const v8::Arguments& args) {
    v8::HandleScope scope;

    if (!args.IsConstructCall()) {
        return v8::ThrowException(v8::Exception::TypeError(
            v8::String::New("Use the new operator to create instances of this object."))
        );
    }

    // Creates a new instance object of this type and wraps it.
    PositioningEnhancedPositionWrapper* obj = new PositioningEnhancedPositionWrapper();

    PositioningProxy* proxy = new PositioningProxy(obj);
    obj->mp_positioningProxy = proxy;
    obj->Wrap(args.This());

    return args.This();
}

v8::Handle<v8::Value> PositioningEnhancedPositionWrapper::GetVersion(const v8::Arguments& args) {
    v8::HandleScope scope; //to properly clean up v8 handles

    // Retrieves the pointer to the wrapped object instance.
    PositioningEnhancedPositionWrapper* obj = ObjectWrap::Unwrap<PositioningEnhancedPositionWrapper>(args.This());

    ::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > DBus_version = obj->mp_positioningProxy->mp_enhancedPositionProxy->GetVersion();

    v8::Local<v8::Object> ret = v8::Object::New();
    ret->Set( 0, v8::Int32::New(DBus_version._1) );
    ret->Set( 1, v8::Int32::New(DBus_version._2) );
    ret->Set( 2, v8::Int32::New(DBus_version._3) );
    ret->Set( 3, v8::String::New(DBus_version._4.c_str()) );

    return scope.Close(ret);
}

v8::Handle<v8::Value> PositioningEnhancedPositionWrapper::GetPositionInfo(const v8::Arguments& args) {
    v8::HandleScope scope; //to properly clean up v8 handles

    // Retrieves the pointer to the wrapped object instance.
    PositioningEnhancedPositionWrapper* obj = ObjectWrap::Unwrap<PositioningEnhancedPositionWrapper>(args.This());
    uint64_t valuesToReturn;
    uint64_t timestamp;
    std::map< uint64_t, ::DBus::Variant > data;
    obj->mp_positioningProxy->mp_enhancedPositionProxy->GetPositionInfo(valuesToReturn, timestamp, data);
}


void RegisterModule(v8::Handle<v8::Object> target) {
    PositioningEnhancedPositionWrapper::Init(target);
}

NODE_MODULE(PositioningEnhancedPositionWrapper, RegisterModule);
