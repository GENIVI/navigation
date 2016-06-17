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


## License

Mozilla Public License Version 2.0

