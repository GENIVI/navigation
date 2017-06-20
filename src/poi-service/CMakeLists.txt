###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-service-server
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
project(poi-service-server)
cmake_minimum_required(VERSION 2.8)
find_package(PkgConfig)

message(STATUS ${PROJECT_NAME})

option(WITH_DBUS_INTERFACE
       "Build using the D-Bus interfaces" ON)
option(WITH_DEBUG
        "Enable the debug messages" OFF)
option(WITH_DLT
        "Enable DLT logging" OFF)
option(WITH_PLUGIN_MIGRATION
        "Enable navit plugin migration to commonapi" OFF)

message(STATUS "WITH_DBUS_INTERFACE = ${WITH_DBUS_INTERFACE}")
message(STATUS "WITH_DEBUG = ${WITH_DEBUG}")
message(STATUS "WITH_DLT = ${WITH_DLT}")
message(STATUS "WITH_PLUGIN_MIGRATION = ${WITH_PLUGIN_MIGRATION}")

set(API_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../api")
set(DBUS_GENERATED_INCLUDE_DIR "${CMAKE_CURRENT_BINARY_DIR}/dbus-include")
set(COMMON_DIR "${CMAKE_CURRENT_SOURCE_DIR}/poi-common")

set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/lib)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/bin)

if(${WITH_DLT})
    add_definitions("-DDLT_ENABLED=1")
    pkg_check_modules(DLT REQUIRED automotive-dlt)
    include_directories( ${DLT_INCLUDE_DIRS} )
    set(LIBRARIES ${LIBRARIES} ${DLT_LIBRARIES})
endif()

if(WITH_DEBUG)
    add_definitions("-DDEBUG_ENABLED=1")
endif()

if (WITH_PLUGIN_MIGRATION)
    add_subdirectory(poi-server-capi)
else()
    #generates the GLib DBus proxies and adaptors
    add_subdirectory(${API_DIR}/navigation-core "${DBUS_GENERATED_INCLUDE_DIR}/navigation-core")
    add_subdirectory(${API_DIR}/map-viewer "${DBUS_GENERATED_INCLUDE_DIR}/map-viewer")
    add_subdirectory(${API_DIR}/poi-service "${DBUS_GENERATED_INCLUDE_DIR}/poi-service")
    add_subdirectory(poi-server)
endif()


