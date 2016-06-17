# POI service client

## Synopsis
This folder contains the client part of the proof of concepts (POC) for the POI service interfaces. 
These interfaces provide access to a search engine for Point Of Interest with a content access module mechanism to extend to additional sources of data.
NB: The server part is located under ../../src/poi-service
This folder contains scripts for building poi-supplier, poi-contentaccess-module and poi-client, generating the databases and launching the whole stuff (all the stuff can be built from here)
NB: See the README.md into the sub folder poi-manager-client for the CommonAPI based POC

##Tested targets
Desktop: Tested under Ubuntu 16.04 LTS 64 bits

## Third parties software
Positioning from [https://github.com/GENIVI/positioning](https://github.com/GENIVI/positioning) 

## About the POI service interfaces project
The project is made of sub parts:
- poi-supplier that populates a sqlite3 based database from OSM data in xml format
- poi-server that implements the poi search API and access an embedded database
- poi-contentaccess-module that implements a content access module that access an additional database, and a simple HMI 
- poi-client that implements a client with a test HMI 
- poi-manager-server and poi-manager-client that implements a  proof of concept of an extension of the poi-contentaccess-module (separate build)

## Prerequisites
Qt version:
Qt5 (to get the version -> qtchooser -print-env, to set the version -> export QT-SELECT=<version>)

## How to build
Important notice before building the POC:
- The software is using stream conversion, so please care if your local settings are right
- There could be a potential runtime error due to a wrong sql request (problem with the use of ',' in place of '.')
so, if you enter 
locale | grep 'LC_NUMERIC' 
you must get
LC_NUMERIC="en_US.UTF-8"
### From scratch
A script allows to clone the third parties code (i.e. positioning and navit) and rebuild all
./clone_and_build.sh
### Build

A script allows either:
to clean and rebuild all (including invoking cmake) 
```./build.sh -c```
or to build updated parts
```./build.sh```

## How To Run
./run 

## How to test 

On main panel:
CREATE

On additional panel:
REGISTER
ADDandREG

On main panel
Categories
all categories with Radius set to 2000
bicycle with Radius set to 5000
replace 'enter text to search' with 'Saint'
SEARCH
You see FINISHED with 32 records
Result list
TOP/PREV/NEXT to watch the result
For a new search, click on CANCEL first
 


## How To prepare the database and the configuration for a country
NB: You need to get the poi-supplier being built first:
cd build
cmake -DWITH_DATABASE_SUPPLIER=ON ../
make
cd ..

---To generate the database for Paris---
./prepare -c paris

NB:
As examples, three databases can be generated for Paris, Tokyo and San-Diego
The input stuff is taken from the OSM, by using this site:
http://www.overpass-api.de

For instance, in Paris area, the bounding box used for the demo is
bbox=2.246304,48.814551,2.430325,48.901289
In case we want to get the hotels and the museums located inside the area defined, request is:
http://www.overpass-api.de/api/xapi?*[bbox=2.246304,48.814551,2.430325,48.901289][tourism=museum|hotel]
for the stations:
http://www.overpass-api.de/api/xapi?*[bbox=2.246304,48.814551,2.430325,48.901289][railway=station]
for the bicycle
http://www.overpass-api.de/api/xapi?*[bbox=2.246304,48.814551,2.430325,48.901289][shop=bicycle]
for the fuel stations
http://www.overpass-api.de/api/xapi?*[bbox=2.246304,48.814551,2.430325,48.901289][amenity=fuel]

For Tokyo, the bounding box is 139.691048,35.631628,139.832497,35.738153

NB: In case you get such error message during runtime:
D-Bus library appears to be incorrectly set up; failed to read machine uuid: Failed to open "/etc/machine-id": No such file or directory
You need to fix it by:
sudo su
dbus-uuidgen  > /etc/machine-id

## License

Mozilla Public License Version 2.0


