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
First it's required to set a config file:
Copy the configuration file ../resource/commonapi-dbus.ini in a directory of your choice

Set the environment variable COMMONAPI_DBUS_DEFAULT_CONFIG before starting the poi-manager-server.

Example:
```export COMMONAPI_DBUS_DEFAULT_CONFIG=<your path>/commonapi-dbus.ini```

./run

## How to test 

---Test sequence can be---
NB: no DLT started

DLT| WARNING:   Loging disabled, FIFO /tmp/dlt cannot be opened with open()!
[CAPI][INFO] Using default binding 'dbus'
[CAPI][INFO] Using default shared library folder '/usr/local/lib/commonapi'
[CAPI][INFO] Using default configuration file '/etc/commonapi.ini'
[CAPI][DEBUG] Registering factory for binding=dbus
poi manager server started

DLT| WARNING:   Loging disabled, FIFO /tmp/dlt cannot be opened with open()!
[CAPI][INFO] Using default binding 'dbus'
[CAPI][INFO] Using default shared library folder '/usr/local/lib/commonapi'
[CAPI][INFO] Using default configuration file '/etc/commonapi.ini'
[CAPI][DEBUG] Registering factory for binding=dbus
poi manager client started
Version 1.0.0
Date 19-03-2015
languageCode: eng countryCode: USA scriptCode: Latn 
Configuration changed:  0
Change locales
languageCode: fra countryCode: FRA scriptCode: Latn 
id: 0 name: all categories top level: 1

Create category

Category 1 created
id: 0 name: all categories top level: 1
id: 1 name: recreation top level: 1

Create POI

POI 1 added

Search

Search state 1298
Result list size 1
POI id 1

Delete POI

POI 1 removed

Delete category

Category 1 removed
id: 0 name: all categories top level: 1

Exit
poi manager client closed
DLT| ERROR:     Lost log messages in user buffer when exiting: 2

## License

Mozilla Public License Version 2.0


