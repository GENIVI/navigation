# Location Based Services middleware

## Synopsis

This repository gathers several sub projects developped on behalf of the GENIVI Allliance, based on a set of Location Based Services (LBS) APIs.
These projects are proof of concepts (POC) for demonstrating the main features covered by the APIs (server part to simulate the behaviour of the component that implements the APIs, and a client to test it).
The server part of the POCs is also used by the [navigation applications](https://github.com/GENIVI/navigation-application) . 

## Motivation

The GENIVI Alliance standardizes the non differentiating part of the In Vehicle Infotainment (IVI) middleware by delivering requirements, interfaces and code. The LBS deliveries are requirements and interfaces. 
An open source API for navigation allows to easily plug HMI or application coming from different vendors on top of the navigation middleware, by limiting the porting workload and providing reused tools for unitary and integration testing.


## API Reference

The code is based on the current version of the LBS APIs. For more detailed description of the GENIVI activity for navigation, please see [the wiki.](https://at.projects.genivi.org/wiki/display/NAV/IVI+Navigation+Home) 

## Sub projects

See the README for each of the projects for build, run and test the code

The APIs are located in these folders:

./api
APIs in DBus xml. 

./api/franca
APIs in Franca IDL

Proof of concept for traffic-incidents is split between
./src/traffic-incidents-service
./test/traffic-incidents-service

Proof of concept of poi-service is split between
./src/poi-service
./test/poi-service

The navigation middleware is located here
./src/navigation

Some test scripts for navigation are available here
./test/navigation

## Map data
The map database used by the POCs is provided by [Open Street Map](https://www.openstreetmap.org/) 

## Third parties software

The POCs are using:
- [Navit](https://github.com/navit-gps/navit/)  core with plugins that implement the GENIVI APIs
- enhanced position from the [positioning](https://github.com/GENIVI/positioning)  project
- log replayer (i.e. to simulate some sensor inputs) from the [positioning](https://github.com/GENIVI/positioning)  project

## Contributors
[asanoaozora](https://github.com/asanoaozora) 

<martin.schaller@it-schaller.de>

## License

Mozilla Public License Version 2.0

