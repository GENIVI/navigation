###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-server
#
# Author: Philippe Colliot
#
# Copyright (C) 2014, PCA Peugeot Citroën
# 
# License:
# This Source Code Form is subject to the terms of the
# Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
# @licence end@
###########################################################################
project(poi-server)
cmake_minimum_required(VERSION 2.8)

message(STATUS "poi-server")

find_package(PkgConfig REQUIRED)

pkg_check_modules(DBUS_CPP dbus-c++-1)
pkg_check_modules(GLIB REQUIRED glib-2.0)
pkg_check_modules(SQLITE3 REQUIRED sqlite3)
pkg_check_modules(GLIBMM glibmm-2.4)
pkg_check_modules(GOBJECT gobject-2.0)
pkg_check_modules(DBUS dbus-1)
pkg_check_modules(DBUS_CPP_GLIB dbus-c++-glib-1)

include_directories(${CMAKE_CURRENT_BINARY_DIR})
include_directories(${DBUS_CPP_INCLUDE_DIRS})
include_directories(${GLIB_INCLUDE_DIRS})
include_directories(${SQLITE3_INCLUDE_DIRS})
include_directories(${GLIBMM_INCLUDE_DIRS})
include_directories(${GOBJECT_INCLUDE_DIRS})
include_directories(${DBUS_INCLUDE_DIRS})
include_directories(${DBUS_CPP_GLIB_INCLUDE_DIRS})

set(API_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../api)
set(TARGET_GENERATED_API_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../poi-common)
set (git_get_src_version git rev-parse HEAD)
set (git_executable git)

# Check if positioning stuff with the right version has been cloned and make it if necessary
set(positioning_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../positioning)
set(positioning_API_DIR ${positioning_SRC}/enhanced-position-service/api)
set(positioning_URL http://git.projects.genivi.org/lbs/positioning.git)
set(positioning_VERSION 09698f63ea27a24c533b4c015155ee9ebd7a3026)

if (EXISTS ${positioning_SRC_DIR})
	execute_process(COMMAND ${git_get_src_version}  
					WORKING_DIRECTORY "${positioning_SRC_DIR}"
					RESULT_VARIABLE result
					OUTPUT_VARIABLE version)
	if (${version} MATCHES ${positioning_VERSION})
		message(STATUS "version of positioning up to date")	
	else()
		message(STATUS "get the right version")
	 	execute_process(
			COMMAND "${git_executable}" checkout ${positioning_VERSION}
			WORKING_DIRECTORY "${positioning_SRC_DIR}"
			RESULT_VARIABLE error_code
		)
		if(error_code)
			message(FATAL_ERROR "Failed to checkout version: '${positioning_VERSION}'")
		endif()	
	endif()
else()
	message(STATUS "clone positioning")
	execute_process(
		COMMAND "${git_executable}" clone "${positioning_URL}" "${positioning_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
 	if(error_code)
		message(FATAL_ERROR "Failed to clone repository: '${positioning_URL}'")
	endif()

	message(STATUS "get the right version")
 	execute_process(
		COMMAND "${git_executable}" checkout ${positioning_VERSION}
		WORKING_DIRECTORY "${positioning_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
	if(error_code)
		message(FATAL_ERROR "Failed to checkout version: '${positioning_VERSION}'")
	endif()	
endif()

# Generate the DBus adaptors and proxy before building the client
add_custom_command(
  OUTPUT  genivi-poiservice-poisearch_adaptor.h 
  COMMAND dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-poisearch.xml 
  --adaptor=${TARGET_GENERATED_API_DIR}/genivi-poiservice-poisearch_adaptor.h
  OUTPUT  genivi-poiservice-poicontentaccess_adaptor.h 
  COMMAND dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-poicontentaccess.xml 
  --adaptor=${TARGET_GENERATED_API_DIR}/genivi-poiservice-poicontentaccess_adaptor.h
  OUTPUT  genivi-poiservice-contentaccessmodule_proxy.h 
  COMMAND dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-contentaccessmodule.xml
  --proxy=${TARGET_GENERATED_API_DIR}/genivi-poiservice-contentaccessmodule_proxy.h
  OUTPUT genivi-poiservice-constants.h 
  COMMAND xsltproc ${API_DIR}/poi-service/enum.xsl ${API_DIR}/poi-service/genivi-poiservice-constants.xml > ${TARGET_GENERATED_API_DIR}/genivi-poiservice-constants.h

  OUTPUT genivi-positioning-constants.h 
  COMMAND xsltproc ${positioning_SRC_DIR}/enhanced-position-service/api/enum.xsl ${positioning_SRC_DIR}/enhanced-position-service/api/genivi-positioning-constants.xml > ${TARGET_GENERATED_API_DIR}/genivi-positioning-constants.h
  OUTPUT  genivi-positioning-enhancedposition_proxy.h 
  COMMAND dbusxx-xml2cpp ${positioning_SRC_DIR}/enhanced-position-service/api/genivi-positioning-enhancedposition.xml
  --proxy=${TARGET_GENERATED_API_DIR}/genivi-positioning-enhancedposition_proxy.h

  OUTPUT genivi-mapviewer-constants.h 
  COMMAND xsltproc ${API_DIR}/map-viewer/enum.xsl ${API_DIR}/map-viewer/genivi-mapviewer-constants.xml > ${TARGET_GENERATED_API_DIR}/genivi-mapviewer-constants.h

  OUTPUT genivi-navigationcore-constants.h 
  COMMAND xsltproc ${API_DIR}/navigation-core/enum.xsl ${API_DIR}/navigation-core/genivi-navigationcore-constants.xml > ${TARGET_GENERATED_API_DIR}/genivi-navigationcore-constants.h
  OUTPUT  genivi-navigationcore-routing_proxy.h 
  COMMAND dbusxx-xml2cpp ${API_DIR}/navigation-core/genivi-navigationcore-routing.xml
  --proxy=${TARGET_GENERATED_API_DIR}/genivi-navigationcore-routing_proxy.h

)

link_directories(
    ${DBUS_CPP_LIBRARY_DIRS}
    ${GLIB_LIBRARY_DIRS}
	${SQLITE3_LIBRARY_DIRS}
	${GLIBMM_LIBRARY_DIRS}
	${GOBJECT_LIBRARY_DIRS}
	${DBUS_LIBRARY_DIRS}
	${DBUS_CPP_GLIB_DIRS}
)

add_executable(poi-server
	genivi-poiservice-poisearch_adaptor.h
	genivi-poiservice-poicontentaccess_adaptor.h
	genivi-poiservice-contentaccessmodule_proxy.h
	genivi-poiservice-constants.h
	genivi-positioning-constants.h
	genivi-mapviewer-constants.h
	genivi-navigationcore-constants.h
	genivi-navigationcore-routing_proxy.h
	genivi-positioning-enhancedposition_proxy.h
    main.cpp
    database.cpp
	database.h
    poi-server-class.h
    poi-datamodel.h
	../poi-common/common-data-model.h
)

set(LIBRARIES 
    ${DBUS_CPP_LIBRARIES}
    ${GLIB_LIBRARIES}
	${SQLITE3_LIBRARIES}
	${GLIBMM_LIBRARIES}
	${GOBJECT_LIBRARIES}
	${DBUS_LIBRARIES}
	${DBUS_CPP_GLIB_LIBRARIES}
)

target_link_libraries(poi-server ${LIBRARIES})



