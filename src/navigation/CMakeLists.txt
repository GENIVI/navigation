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
find_package(PkgConfig)

option(WITH_DBUS_INTERFACE
       "Build using the D-Bus interfaces" ON)
option(WITH_DEBUG
        "Enable the debug messages" OFF)
option(WITH_DLT
        "Enable DLT logging" OFF)
option(WITH_SPEECH
        "Enable the voice messages" OFF)
option(WITH_PLUGIN_MIGRATION
        "Enable navit plugin migration to commonapi" OFF)
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

message(STATUS "WITH_DBUS_INTERFACE = ${WITH_DBUS_INTERFACE}")
message(STATUS "WITH_DEBUG = ${WITH_DEBUG}")
message(STATUS "WITH_DLT = ${WITH_DLT}")
message(STATUS "WITH_SPEECH = ${WITH_SPEECH}")
message(STATUS "WITH_PLUGIN_MIGRATION = ${WITH_PLUGIN_MIGRATION}")
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
set(NAVIGATION_COMMON_DIR "${CMAKE_CURRENT_SOURCE_DIR}/navigation-common")

if(NOT ${YOCTO_CONFIG})
    set(NAVIT_DIR "${CMAKE_CURRENT_SOURCE_DIR}/navit")
    set(NAVIT_CMAKE_DIR "${NAVIT_DIR}/cmake")
    set(DBUS_GENERATED_INCLUDE_DIR_POSITIONING "${CMAKE_BINARY_DIR}/enhanced-position-service/dbus/api") # this one is for positioning, NB: it uses CMAKE_BINARY_DIR
    set(NAVIT_CONFIG_H_DIR "${CMAKE_CURRENT_BINARY_DIR}/navit")
else()
    set(NAVIT_DIR "${STAGING_LIBDIR}/navit")
    set(NAVIT_CMAKE_DIR "${NAVIT_DIR}/cmake")
    set(DBUS_GENERATED_INCLUDE_DIR_POSITIONING "${STAGING_INCDIR}/positioning") # this one is for positioning
    set(NAVIT_CONFIG_H_DIR "${STAGING_DATADIR}")
endif()

set(NAVIT_BIN_DIR "${CMAKE_CURRENT_BINARY_DIR}/navit/navit")
set(NAVIT_MAPS_DIR "${NAVIT_BIN_DIR}/maps")

set(DBUS_GENERATED_INCLUDE_DIR "${CMAKE_CURRENT_BINARY_DIR}/dbus-include")
set(PRELOAD_CACHE_FOR_PLUGINS "${NAVIT_CONFIG_H_DIR}/cmake_plugin_settings.txt")

get_directory_property(hasParent PARENT_DIRECTORY)

if(NOT ${YOCTO_CONFIG})
    # for enhanced position service
    if(NOT EXISTS "${CMAKE_CURRENT_SOURCE_DIR}/positioning")
        message(FATAL_ERROR "Don't you forget to download additional code ? Please see README first")
    endif()
    set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/lib)
    set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/bin)
    if (${WITH_PLUGIN_MIGRATION})
        set(FRANCA_POSITIONING_DIR "${CMAKE_CURRENT_SOURCE_DIR}/positioning/enhanced-position-service/franca/api")
        execute_process(COMMAND uname -i OUTPUT_VARIABLE OS_VERSION)
        if("${OS_VERSION}" MATCHES "i686")
          set(OS_VERSION "x86")
        else()
          set(OS_VERSION "x86_64")
        endif()
        set(WITH_FRANCA_DBUS_INTERFACE "ON" CACHE INTERNAL "")
        set(WITH_DBUS_INTERFACE "OFF" CACHE INTERNAL "")
        set(COMMONAPI_TOOL_GENERATOR "${COMMONAPI_TOOL_DIR}/org.genivi.commonapi.core.cli.product/target/products/org.genivi.commonapi.core.cli.product/linux/gtk/${OS_VERSION}/commonapi-generator-linux-${OS_VERSION}" CACHE INTERNAL "")
        set(COMMONAPI_DBUS_TOOL_GENERATOR "${COMMONAPI_DBUS_TOOL_DIR}/org.genivi.commonapi.dbus.cli.product/target/products/org.genivi.commonapi.dbus.cli.product/linux/gtk/${OS_VERSION}/commonapi-dbus-generator-linux-${OS_VERSION}" CACHE INTERNAL "")
        if(hasParent)
            set(COMMONAPI_GEN_DIR_POSITIONING "${COMMONAPI_GEN_DIR}" PARENT_SCOPE)
        else()
            set(COMMONAPI_GEN_DIR_POSITIONING "${CMAKE_CURRENT_BINARY_DIR}/enhanced-position-service/franca/api")
        endif(hasParent)
    endif()
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
# so cmake for navit has to be invoked manually

add_subdirectory(map)


if(${WITH_SPEECH})
    add_subdirectory(${API_DIR}/speech-service "${DBUS_GENERATED_INCLUDE_DIR}/speech-service")
endif()

include(${NAVIT_CMAKE_DIR}/navit_macros.cmake)

if (${WITH_PLUGIN_MIGRATION})
    # generates the CommonAPI templates from the Franca files
    set(COMMONAPI_GEN_DIR "${CMAKE_CURRENT_BINARY_DIR}/franca/src-gen")
    # for hmi and navigation
    set(FRANCA_DIR "${API_DIR}/franca")
    add_subdirectory(${FRANCA_DIR} "${CMAKE_CURRENT_BINARY_DIR}/franca")
else()
    #generates the GLib DBus proxies and adaptors
    add_subdirectory(${API_DIR}/navigation-core "${DBUS_GENERATED_INCLUDE_DIR}/navigation-core")
    add_subdirectory(${API_DIR}/map-viewer "${DBUS_GENERATED_INCLUDE_DIR}/map-viewer")
    add_subdirectory(${API_DIR}/poi-service "${DBUS_GENERATED_INCLUDE_DIR}/poi-service")
endif()

if(${WITH_DLT})
    add_definitions("-DDLT_ENABLED=1")
    pkg_check_modules(DLT REQUIRED automotive-dlt)
    include_directories( ${DLT_INCLUDE_DIRS} )
    set(LIBRARIES ${LIBRARIES} ${DLT_LIBRARIES})
endif()

add_subdirectory(navigation-core)

add_subdirectory(map-viewer)

if (NOT WITH_PLUGIN_MIGRATION)
    add_subdirectory(poi-cam)
endif()
