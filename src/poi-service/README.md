# POI service middleware

## Synopsis
This folder contains the server part of the proof of concepts (POC) for the POI service interfaces. 
These interfaces provide access to a search engine for Point Of Interest with a content access module mechanism to extend to additional sources of data.
NB: The client part is located under ../../test/poi-service
NB: See the README.md into the sub folder poi-manager-server for the CommonAPI based POC

##Tested targets
Desktop: Tested under Ubuntu 16.04 LTS 64 bits
## About the POI service interfaces project
The project is made of sub parts:
- poi-supplier that populates a sqlite3 based database from OSM data in xml format
- poi-server that implements the poi search API and access an embedded database
- poi-contentaccess-module that implements a content access module that access an additional database, and a simple HMI 
- poi-client that implements a client with a test HMI 
- poi-manager-server and poi-manager-client that implements a  proof of concept of an extension of the poi-contentaccess-module (separate build)

## Prerequisites

## How to build
A script allows either:
to clean and rebuild all (including invoking cmake) 
```./build.sh -c```
or to build updated parts
```./build.sh```

## How To Run
```./bin/poi-server  -f ./resource/poi-database-sample.db```

## How to for the CommonAPI based version (draft)
The former version of the POCs is based on GLib DBus. A migration to CommonAPI is under progress. 

###Prerequisites
You need CommonAPI 3.1.5 and Franca 0.9.1 installed 
For the Ubuntu 64 bits, due to the use of symbol versioning LIBDBUS_1_0 by CommonAPI-DBus, the patched version of DBus has to be >= 1.10.0
NB: the patch common-api-dbus-runtime/src/dbus-patches/capi-dbus-add-support-for-custom-marshalling.patch failed a little bit, it's needed to update the dbus/dbus-string.h manually

### How to build
First it's required to set some paths:
```
export DBUS_LIB_PATH=<path to the patched version of the DBus lib>
export COMMONAPI_DBUS_TOOL_DIR=<path to the common-api-dbus-tools folder>
export COMMONAPI_TOOL_DIR=<path to the common-api-tools folder> 
```
A script allows either:
to clean and rebuild all (including invoking cmake) 
```./build.sh -cm```
or to build updated parts
```./build.sh -m```

NB: in case you didn't build the whole code yet, you can also invoke
```./clone_and_build.sh -m```

## How To Test
```./run-capi &```
```../../test/poi-service/test-poi-capi.py```
If everything is OK, you must see:
Search for hotel and station with keyword: Saint-Germain
Category ID: 2
Name: hotel
Category ID: 6
Name: station
Search handle: 1
language: fra
country: FRA
script: Latn
Search finished
Results: 2
Hotel: Au Manoir Saint-Germain des Prés
Station: Saint-Germain des Prés
Test PASSED


## License

Mozilla Public License Version 2.0

