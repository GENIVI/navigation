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
find_program(XSLTPROC xsltproc REQUIRED)
find_program(DBUSXML2CPP dbusxx-xml2cpp REQUIRED)

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

set (git_get_src_version git rev-parse HEAD)
set (git_executable git)
set(cmake_create_dir cmake -E make_directory)

include_directories(${generated_api_DIR})

ADD_CUSTOM_COMMAND(OUTPUT ${generated_api_DIR}/genivi-positioning-enhancedposition_proxy.h
		   COMMAND dbusxx-xml2cpp ${positioning_API}/genivi-positioning-enhancedposition.xml --proxy=${generated_api_DIR}/genivi-positioning-enhancedposition_proxy.h 
		   DEPENDS ${positioning_API}/genivi-positioning-enhancedposition.xml
		   )

if(NOT EXISTS ${generated_api_DIR}/genivi-positioning-constants.h)
	execute_process(
		OUTPUT_FILE ${generated_api_DIR}/genivi-positioning-constants.h
		COMMAND xsltproc ${api_DIR}/poi-service/enum.xsl ${positioning_API}/genivi-positioning-constants.xml   
	)
else()
	if(${positioning_API}/genivi-positioning-constants.xml IS_NEWER_THAN ${generated_api_DIR}/genivi-positioning-constants.h)
		execute_process(
			OUTPUT_FILE ${generated_api_DIR}/genivi-positioning-constants.h
			COMMAND xsltproc ${api_DIR}/poi-service/enum.xsl ${positioning_API}/genivi-positioning-constants.xml   #use another enum.xsl for radix consistency
		)
	endif()
endif()


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
    main.cpp
    database.cpp
	database.h
    poi-server-class.h
    poi-datamodel.h
	../poi-common/common-data-model.h
	${generated_api_DIR}/genivi-positioning-enhancedposition_proxy.h
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



