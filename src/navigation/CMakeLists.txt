###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: navigation
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
project(navigation)
cmake_minimum_required(VERSION 2.8)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

option(WITH_FRANCA_INTERFACE
       "Build using the Franca interfaces" OFF)
option(WITH_DBUS_INTERFACE
       "Build using the D-Bus interfaces" ON)
option(WITH_DEBUG
        "Enable the debug messages" OFF)
option(YOCTO_CONFIG
        "Build using Yocto" OFF)
option(NAVIT_DISABLE_QT
        "Disable Qt to build navit" 1)
option(NAVIT_SAMPLE_MAP
        "Use a sample map for navit" 0)
option(NAVIT_NULL_VEHICLE
        "Vehicle null for navit" 1)
option(NAVIT_QTPAINTER
        "qtqpainter for navit" 0)

message(STATUS "WITH_FRANCA_INTERFACE = ${WITH_FRANCA_INTERFACE}")
message(STATUS "WITH_DBUS_INTERFACE = ${WITH_DBUS_INTERFACE}")
message(STATUS "WITH_DEBUG = ${WITH_DEBUG}")
message(STATUS "YOCTO_CONFIG = ${YOCTO_CONFIG}")
message(STATUS "NAVIT_DISABLE_QT = ${NAVIT_DISABLE_QT}")
message(STATUS "NAVIT_SAMPLE_MAP = ${NAVIT_SAMPLE_MAP}")
message(STATUS "NAVIT_NULL_VEHICLE = ${NAVIT_NULL_VEHICLE}")
message(STATUS "NAVIT_QTPAINTER = ${NAVIT_QTPAINTER}")

set(DISABLE_QT "${NAVIT_DISABLE_QT}")
set(SAMPLE_MAP "${NAVIT_SAMPLE_MAP}")
set(vehicle/null "${NAVIT_NULL_VEHICLE}")
set(graphics/qt_qpainter "${NAVIT_QTPAINTER}")

set(API_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../api")

if(NOT ${YOCTO_CONFIG})
    set(NAVIT_CMAKE_DIR "${CMAKE_CURRENT_SOURCE_DIR}/navit/navit/cmake")
    set(DBUS_GENERATED_INCLUDE_DIR_POSITIONING "${CMAKE_CURRENT_BINARY_DIR}/enhanced-position-service/dbus/api") # this one is for positioning
    set(NAVIT_CONFIG_H_DIR "${CMAKE_CURRENT_BINARY_DIR}/navit/navit")
else()
    set(NAVIT_CMAKE_DIR "${STAGING_LIBDIR}/navit/cmake")
    set(DBUS_GENERATED_INCLUDE_DIR_POSITIONING "${STAGING_INCDIR}/positioning") # this one is for positioning
    set(NAVIT_CONFIG_H_DIR "${STAGING_DATADIR}")
endif()

set(NAVIT_BIN_DIR "${CMAKE_CURRENT_BINARY_DIR}/navit/navit/navit")
set(NAVIT_MAPS_DIR "${NAVIT_BIN_DIR}/maps")

set(DBUS_GENERATED_INCLUDE_DIR "${CMAKE_CURRENT_BINARY_DIR}/dbus-include")
set(PRELOAD_CACHE_FOR_PLUGINS "${NAVIT_CONFIG_H_DIR}/cmake_plugin_settings.txt")

get_directory_property(hasParent PARENT_DIRECTORY)
if(hasParent)
set(API_DIR_PARENT_SCOPE ${API_DIR} PARENT_SCOPE)
set(POSITIONING_API_DIR_PARENT_SCOPE ${CMAKE_CURRENT_SOURCE_DIR}/positioning/enhanced-position-service/dbus/api PARENT_SCOPE)
set(DBUS_GENERATED_INCLUDE_DIR_PARENT_SCOPE ${DBUS_GENERATED_INCLUDE_DIR} PARENT_SCOPE)
set(DBUS_GENERATED_INCLUDE_DIR_POSITIONING_PARENT_SCOPE ${DBUS_GENERATED_INCLUDE_DIR_POSITIONING} PARENT_SCOPE)
endif(hasParent)

if(NOT ${YOCTO_CONFIG})
    if(NOT EXISTS "${CMAKE_CURRENT_SOURCE_DIR}/positioning")
        message(FATAL_ERROR "Don't you forget to download additional code ? Please see README first")
    endif()
    set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/lib)
    set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/bin)
        add_subdirectory(positioning)
    unset(CMAKE_LIBRARY_OUTPUT_DIRECTORY)
    unset(CMAKE_RUNTIME_OUTPUT_DIRECTORY)
endif()


if(NOT ${YOCTO_CONFIG})
    if(NOT EXISTS "${PRELOAD_CACHE_FOR_PLUGINS}")
        message(FATAL_ERROR "Build navit first, see README")
    endif()
endif()

# For the moment, there's still an issue there
#add_subdirectory(navit/navit)

add_subdirectory(map)

add_subdirectory(${API_DIR}/navigation-core "${DBUS_GENERATED_INCLUDE_DIR}/navigation-core")

add_subdirectory(${API_DIR}/map-viewer "${DBUS_GENERATED_INCLUDE_DIR}/map-viewer")

add_subdirectory(${API_DIR}/poi-service "${DBUS_GENERATED_INCLUDE_DIR}/poi-service")

include(${NAVIT_CMAKE_DIR}/navit_macros.cmake)

add_subdirectory(navigation-core)

add_subdirectory(map-viewer)

add_subdirectory(poi-cam)



