Introduction
============
This folder contains:

feed
----
This folder contains all code to feed test TrafficIncidents into a TrafficIncidentsService.

hmi
---
This folder contains:
- Example clients for the TrafficIncidentsService.
- A 'main' to run the test feed, the service and the clients (without D-Bus) within Eclipse.
- A project to create an installer for running the test feed, the service and the clients (with D-Bus) on Linux.
  


Project structure
=================
This project consists of a number of Eclipse projects.
Data models are created with the Eclipse Modeling Framework (EMF), so EMF has to be installed in your Eclipse in order to compile and run the projects. All projects which contain an EMF model, have an extension '-model'.
Each project has a 'ReadMe.confluence' file, which provides basic information on the project.
The following package naming convention is used:

org.genivi:
Basename for all packages.

    tpegtecfeed:
    Classes that could be re-used in GENIVI.

    trafficinfo:
    All other code of this PoC, i.e. code to demonstrate the use of the TrafficIncidentsService.

        tpeg:
        TPEG related classes.


Building and running the complete PoC in Eclipse (no D-Bus)
===========================================================
The repository contains the Eclipse projects, but not an Eclipse WorkSpace. So this has to be created manually.
Start Eclipse and chose your 'ivi-navigation/test/traffic-incidents-service' folder as WorkSpace. Import all the projects.

Database:
The PoC uses a small database: tomtom_utrecht_2008_04.db3
This database can be downloaded from http://www.openlr.org/testdata.html, using the link below the map picture.
The database is part of the archive: tomtom-openlr-testdata-utrecht.zip
The database has to be installed in: 'ivi-navigation/src/traffic-incidents-service/org.genivi.trafficinfo/resources


Eclipse projects - feed
=======================

org.genivi.trafficincidentsfeed.tpegtec
---------------------------------------
Reference implementation of a TPEG-TEC Feed.
Packages:

org.genivi.tpegtecfeed.refimpl
Reference implementation of a TPEG-TEC Feed. This Feed receives TPEG Service Component Frames from the TPEG Framework and translates the information to TrafficIncidents which are handed over to the TrafficIncidents service, via the TrafficIncidentUpdates interface.


org.genivi.trafficinfo.tpeg.sni-model
-------------------------------------
This project contains the data model of the TPEG-SNI application.
Packages:

org.genivi.trafficinfo.tpeg.snitypes
The TPEG-SNI data model

org.genivi.trafficinfo.tpeg.snitypes.impl
Implementation of org.genivi.trafficinfo.tpeg.snitypes.

org.genivi.trafficinfo.tpeg.snitypes.util
Utility classes related to org.genivi.trafficinfo.tpeg.snitypes.


org.genivi.trafficinfo.tpeg.tec.event-model
-------------------------------------------
This project defines TPEG-TEC Event data model. This model is used to generate TEC Events on the server side and send these events to the client.
This model is not part of any GENIVI interface, it is only used as part of the Proof of Concept.
Packages:

org.genivi.trafficinfo.tpeg.tec.event
The PEG-TEC Event data model.

org.genivi.trafficinfo.tpeg.tec.event.impl
Implementation of org.genivi.trafficinfo.tpeg.tec.event.

org.genivi.trafficinfo.tpeg.tec.event.util
Utility classes related to org.genivi.trafficinfo.tpeg.tec.event.


org.genivi.trafficinfo.tpeg.tecservice
--------------------------------------
This project contains a TPEG TEC service implementation for testing purposes. The TestPlayerTecService cycles through a small set of TEC messages.
Packages:

org.genivi.trafficinfo.tpeg.tecservice.testsetplayer
Contains the TestPlayerTecService.


org.genivi.trafficinfo.tpegfwk
------------------------------
Packages:

org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk
TPEG framework interfaces for the client side.

org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.impl
Mininal implementation of the client side service framework.

org.genivi.trafficinfo.tpeg.clientside.broadcastadaptationlayer.refimpl
Reference implementation for a client side Broadcast adaptation layer.

org.genivi.trafficinfo.tpeg.registeredvalues
Contains TPEG services related values registered with TISA. For now it contains the registered Application Ids (for testing only).

org.genivi.trafficinfo.tpeg.serverside.broadcast.app.fwk
Interface for a TPEG application on the server side, in a broadcast framework.

org.genivi.trafficinfo.tpeg.serverside.broadcast.fwk
Interface for a TPEG framework on the server side, in a broadcast framework.

org.genivi.trafficinfo.tpeg.serverside.broadcast.fwk.impl
Minimal implementation of the server side service framework.


org.genivi.trafficinfo.tpegfwktypes-model
-----------------------------------------
This project defines datatypes related to the TPEG framework.
Packages:

org.genivi.trafficinfo.tpeg.tpegfwktypes
Datatypes related to the TPEG framework.

org.genivi.trafficinfo.tpeg.tpegfwktypes.impl
Implementation of org.genivi.trafficinfo.tpeg.tpegfwktypes.

org.genivi.trafficinfo.tpeg.tpegfwktypes.util
Utility classes related to org.genivi.trafficinfo.tpeg.tpegfwktypes.


org.genivi.trafficinfo.tpegtables
---------------------------------
This project contains a minimal set (as needed for the TrafficIncidentsService PoC) of tables defined by TPEG.
Packages:

org.genivi.trafficinfo.tpeg.tpegtables
Tables defined by TPEG.


org.genivi.trafficinfo.trafficincidenttestfeed
----------------------------------------------
This project contains a class to start the whole chain for TPEG-TEC messages; from generating them on the server side to injecting them in the TrafficIncidentsService (using a D-Bus interface).
Packages:

org.genivi.trafficinfo.trafficincidenttestfeed
Contans the class that starts the TPEG-TEC chain.



Eclipse projects - hmi
======================

org.genivi.trafficinfo.trafficincidentsexampleclients
-----------------------------------------------------
This project contains example client applications and a 'main' to run the whole PoC within Eclipse.
Packages:

org.genivi.trafficinfo.pocmain
Contains the Main class for starting the Proof of Concept (without D-Bus IPC).

org.genivi.trafficinfo.trafficincidentsexampleclients
Contains the example clients of the TrafficIncidentsService.


org.genivi.trafficinfo.poc
--------------------------
This project contains:
* An NSIS script to generate the installer of the Traffic Incidents PoC (folder nsis)
* Scripts to start the processes of the PoC (folder scripts)


org.genivi.trafficinfo.trafficincidentsconfiguration
----------------------------------------------------
This project contains a client of the TrafficIncidentsService, which configures this service (using a D-Bus interface). It defines icons and categories which use these icons.
Packages:

org.genivi.trafficinfo.trafficincidentsconfiguration
The configuration client.


org.genivi.trafficinfo.trafficincidentslistclient
-------------------------------------------------
This project contains a class to start the TrafficInfoListDisplay from org.genivi.trafficinfo.trafficincidentsexampleclients on top of a D-Bus proxy.
Packages:

org.genivi.trafficinfo.trafficincidentslistclient
The class to start the TrafficInfoListDisplay.


org.genivi.trafficinfo.trafficincidentsmapclient
------------------------------------------------
This project contains a class to start the TrafficInfoMapView from org.genivi.trafficinfo.trafficincidentsexampleclients on top of a D-Bus proxy.
Packages:

org.genivi.trafficinfo.trafficincidentsmapclient
Contains the class to start the TrafficInfoMapView.


org.genivi.trafficinfo.trafficincidentswarningclient
----------------------------------------------------
This project contains a class to start the WarningClient from org.genivi.trafficinfo.trafficincidentsexampleclients on top of a D-Bus proxy.
Packages:

org.genivi.trafficinfo.trafficincidentswarningclient
The class to start the WarningClient.


