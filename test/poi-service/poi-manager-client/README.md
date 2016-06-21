# POI service client: CommonAPI based POC

## Synopsis
This folder contains the client part of the proof of concepts (POC) for the POI service interfaces, based on CommonAPI 
These interfaces provide access to a search engine for Point Of Interest with a content access module mechanism to extend to additional sources of data.
NB: The server part is located under ../../src/poi-manager-service

##Tested targets
Desktop: Tested under Ubuntu 16.04 LTS 64 bits

## Prerequisites
You need CommonAPI 3.1.5 and Franca 0.9.1 installed 
For the Ubuntu 64 bits, due to the use of symbol versioning LIBDBUS_1_0 by CommonAPI-DBus, the patched version of DBus has to be >= 1.10.0
NB: the patch common-api-dbus-runtime/src/dbus-patches/capi-dbus-add-support-for-custom-marshalling.patch failed a little bit, it's needed to update the dbus/dbus-string.h manually

## How to build
First it's required to set some paths:
```
export DBUS_LIB_PATH=<path to the patched version of the DBus lib>
export COMMONAPI_DBUS_TOOL_DIR=<path to the common-api-dbus-tools folder>
export COMMONAPI_TOOL_DIR=<path to the common-api-tools folder> 
```
A script allows either:
to clean and rebuild all (including invoking cmake) 
```./build.sh -c```
or to build updated parts
```./build.sh```


## How To Run
```./run.sh```

## How to test 

---Test sequence can be---
```./run.sh```
poi manager client started
languageCode: Version eng countryCode: USA scriptCode: Latn 
1.0.0
Date 19-03-2015
Configuration changed:  0
Change locales
languageCode: fra countryCode: FRA scriptCode: Latn 
id: 0 name: all categories top level: 1
**--> Push button Create category**
Category 1 created
id: 0 name: all categories top level: 1
id: 1 name: recreation top level: 1
**--> Push button Create POI**
POI 1 added
**--> Push button Search**
Search state 1298
Result list size 1
POI id 1
**--> Push button Delete POI**
POI 1 removed
**--> Push button Delete category**
Category 1 removed
id: 0 name: all categories top level: 1
**-> Stop it**
poi manager client closed

## License

Mozilla Public License Version 2.0


