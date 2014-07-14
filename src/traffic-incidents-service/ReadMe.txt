Introduction
============
This folder contains a Java Proof of Concept implementation of the GENIVI TrafficIncidentsService, and a proxy library as a convenience for Java clients of this service.
See 'ivi-navigation/test/traffic-incidents-service' for examples of running this service (without D-Bus) with a test Feed and several clients within Eclipse, and for running the same (with D-Bus) on Linux.


Project structure
=================
This project consists of a number of Eclipse projects.
Data models are created with the Eclipse Modeling Framework (EMF), so EMF has to be installed in your Eclipse in order to compile and run the projects. All projects which contain an EMF model, have an extension '-model'.
Each project has a 'ReadMe.confluence' file, which provides basic information on the project.
The following package naming convention is used:

org.genivi:
Basename for all packages.

    trafficincidentsservice:
    All files related to the TrafficIncidentsService (interfaces, data models and implementation).

    booleanexpr, common, iconset, location, locref:
    Classes that could be re-used in GENIVI.

    trafficinfo:
    All other code of this PoC, i.e. code to demonstrate the use of the TrafficIncidentsService.


Building the complete PoC in Eclipse (no D-Bus)
===========================================================
The repository contains the Eclipse projects, but not an Eclipse WorkSpace. So this has to be created manually.
Start Eclipse and chose your 'ivi-navigation/src/traffic-incidents-service' folder as WorkSpace. Import all the projects.



Eclipse projects
================

org.genivi.basetypes-model
--------------------------
This project defines basic data types, which should become generic GENIVI data types.
Packages:

org.genivi.common
Common classes: Coordinate, LocalizedString, RectangularArea.

org.genivi.common.impl
Implementation of org.genivi.common

org.genivi.common.util
Utility classes related to org.genivi.common

org.genivi.location
Classes describing locations.

org.genivi.location.impl
Implementation of org.genivi.location

org.genivi.location.util
Utility classes related to org.genivi.location


org.genivi.booleanexpr-model
----------------------------
This project defines a Boolean Expression. These expressions are used in the TrafficIncidents interface, but can also be used in other locations where hierarchical data is used.
Packages:

org.genivi.booleanexpr
The interface definition for Boolean Expressions.

org.genivi.booleanexpr.impl
Implementation of org.genivi.booleanexpr

org.genivi.booleanexpr.util
Utility classes related to org.genivi.booleanexpr


org.genivi.iconset-model
------------------------
This project defines an Icon Set. Icon Sets are used in the TrafficIncidents interface, but can also be used in other locations where icons are used.
Packages:

org.genivi.iconset
The interface definition for Icon Sets.

org.genivi.iconset.impl
Implementation of org.genivi.iconset

org.genivi.iconset.util
Utility classes related to org.genivi.iconset


org.genivi.locref-model
-----------------------
This project defines an interface for decoding Location References. Currently this is an internal interface within the TrafficIncidentsService. However, in the future, they may be a separate component for decoding Location References (as part of Map Data Access).
Packages:

org.genivi.locref
The interface definition for decoding Location References.

org.genivi.locref.impl
Implementation of org.genivi.locref

org.genivi.locref.util
Utility classes related to org.genivi.locref


org.genivi.trafficincidentsservice-model
----------------------------------------
This project defines the main interfaces of the TrafficIncidentsService. The data models for traffic incidents are in sub packages.
Packages:

org.genivi.trafficincidentsservice
The main interfaces of the TrafficIncidentsService.

org.genivi.trafficincidentsservice.impl
The generated implementation of org.genivi.trafficincidentsservice. From here the generated implementations TrafficIncidentsImpl.java and TrafficIncidentFeed.java are not used.

org.genivi.trafficincidentsservice.util
Utility classes related to org.genivi.trafficincidentsservice.


org.genivi.trafficincidentsservice.dbus.impl
--------------------------------------------
This project contains a class to wrap the TrafficIncidentsService from org.genivi.trafficincidentsservice.refimpl into a D-Bus service.
Packages:

org.genivi.trafficincidentsservice.dbus.impl
The class to wrap the TrafficIncidentsService into a D-Bus service.


org.genivi.trafficincidentsservice.dbuswrapper
----------------------------------------------
This project defines the D-Bus version of the interfaces of the TrafficIncidentsService and it contains the Proxies and Adaptors to connect the D-Bus interfaces to the plain java interfaces.
Packages:

org.genivi.trafficincidentsservice.trafficincidents.dbus
D-Bus interface definition for the TrafficIncidents interface.

org.genivi.trafficincidentsservice.trafficincidents.dbus.impl
Glue between the java version and the D-Bus version of the TrafficIncidents interface (Proxy and Adaptor).

org.genivi.trafficincidentsservice.trafficincidentfeed.dbus
D-Bus interface definition for the TrafficIncidentFeed interface.

org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.impl
Glue between the java version and the D-Bus version of the TrafficIncidentFeed interface (Proxy and Adaptor).


org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincidentfeed-trafficincident-model
------------------------------------------------------------------------------------------------
This project defines the TrafficIncident data model as used in the TrafficIncidentFeed interface.
Packages:

org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident
The TrafficIncident data model.

org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl
Implementation of the TrafficIncident data model.

org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.util
Utility classes related to the TrafficIncident data model.


org.genivi.trafficincidentsservice.trafficincidents.trafficincidents-trafficincident-model
------------------------------------------------------------------------------------------
This project defines the TrafficIncident data model as used in the TrafficIncidents interface.
Packages:

org.genivi.trafficincidentsservice.trafficincidents.trafficincident
The TrafficIncident data model.

org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl
Implementation of the TrafficIncident data model.

org.genivi.trafficincidentsservice.trafficincidents.trafficincident.util
Utility classes related to the TrafficIncident data model.


org.genivi.trafficincidentsservice.trafficincidenttables-model
--------------------------------------------------------------
This project defines the tables that are used in the Traffic Incident definitions of both the TrafficIncidents interface and the TrafficIncidentFeed interface.
Packages:

org.genivi.trafficincidentsservice.trafficincidenttables
The tables that are used in the Traffic Incident definitions.

org.genivi.trafficincidentsservice.trafficincidenttables.impl
Implementation related to org.genivi.trafficincidentsservice.trafficincidenttables.


org.genivi.trafficinfo
----------------------
This project contains the main part of the Java only PoC for the TrafficIncidentsService. It makes use of several data models which are defined in other packages.
On top of this there are projects to add D-Bus layers between the components.
Packages

org.genivi.locref.decoder
Interface definition for Location Reference decoders. This interface is used in the implementation of org.genivi.locref.LocationReferenceDecodingService.

org.genivi.locref.decoder.openlr
OpenLR implementation of decoder interface defined in org.genivi.locref.decoder.

org.genivi.locref.refimpl
Reference implementation of org.genivi.locref.LocationReferenceDecodingService

org.genivi.trafficincidentsservice
Contains default implementations for TrafficIncidentsListener and TrafficIncidentFeedListener.

org.genivi.trafficincidentsservice.refimpl
Reference implementation of a TrafficIncidentsService (without any D-Bus binding).

org.genivi.trafficincidentsservice.textgenerator
Defines an interface for a text generator, as a sub component of the TrafficIncidentsService.

org.genivi.trafficincidentsservice.textgenerator.basictextgenerator
Basic implementation of a textgenerator.


org.genivi.trafficinfo.dbus-java
--------------------------------
This project is a copy of the dbus-java project by Matthew Johnson, with small modifications needed to get the TrafficIncidentsService PoC running. Therefore there is no further description of this project.


org.genivi.trafficinfo.demo
---------------------------
This project contains classes which can be used in demo's and prototypes.
Packages:

org.genivi.trafficinfo.demo.communicationchannel
Contains classes for communication channels (Used to simulation the communication channels between the server and the client)

org.genivi.trafficinfo.demo.communicationchannel.async2waycommchannel
Defines the interfaces for a 2 way communication channel (currently not used in this PoC).

org.genivi.trafficinfo.demo.communicationchannel.async2waycommchannel.impl
Provides a dummy implementation for a 2 way communication channel.

org.genivi.trafficinfo.demo.communicationchannel.broadcastchannel
Defines the interfaces for a broadcast channel.

org.genivi.trafficinfo.demo.communicationchannel.broadcastchannel.impl
Provides a dummy implementation for a broadcast channel.

org.genivi.trafficinfo.demo.logging
Provides a formatter, which creates a link to the Java code in Eclipse console output.


org.genivi.trafficinfo.libmatthew
---------------------------------
This is an unmodified copy of the 'libmatthew' project by Matthew Johnson. Therefore there is no further description of this project.
This project is copied here as it is used by the dbus-java project.