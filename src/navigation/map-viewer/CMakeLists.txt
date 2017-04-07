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

message(STATUS "map-viewer")

include(FindPkgConfig)

pkg_search_module(DBUS_CPP_GLIB dbus-c++-glib-1)
pkg_search_module(DBUS_CPP dbus-c++-1)
pkg_search_module(GLIB glib-2.0)

include_directories(${GLIB_INCLUDE_DIRS})
include_directories(${DBUS_CPP_INCLUDE_DIRS})
include_directories(${DBUS_CPP_GLIB_INCLUDE_DIRS})

include(${PRELOAD_CACHE_FOR_PLUGINS})

include_directories(${NAVIT_DIR})
include_directories(.)
include_directories(${CMAKE_CURRENT_BINARY_DIR})

include_directories(${NAVIT_CONFIG_H_DIR}) # this one contains config.h that is generated

include_directories(${NAVIGATION_COMMON_DIR})

find_program(XSLTPROC xsltproc REQUIRED)

# Generate the config file for navit/mapviewer
if(NOT ${YOCTO_CONFIG})
    if (WITH_PLUGIN_MIGRATION)
        execute_process(
            OUTPUT_FILE ${NAVIT_BIN_DIR}/navit_genivi_mapviewer.xml
            COMMAND ${XSLTPROC} ${CMAKE_CURRENT_SOURCE_DIR}/navit_genivi_mapviewer_capi.xsl ${navit_SOURCE_DIR}/navit/navit_shipped.xml
        )
    else()
        execute_process(
            OUTPUT_FILE ${NAVIT_BIN_DIR}/navit_genivi_mapviewer.xml
            COMMAND ${XSLTPROC} ${CMAKE_CURRENT_SOURCE_DIR}/navit_genivi_mapviewer.xsl ${navit_SOURCE_DIR}/navit/navit_shipped.xml
        )
    endif()
else()
    if (WITH_PLUGIN_MIGRATION)
        execute_process(
            OUTPUT_FILE ${CMAKE_CURRENT_BINARY_DIR}/navit_genivi_mapviewer.xml
            COMMAND ${XSLTPROC} ${CMAKE_CURRENT_SOURCE_DIR}/navit_genivi_mapviewer_capi.xsl ${NAVIT_CMAKE_DIR}/../navit/navit_shipped.xml
        )
    else()
        execute_process(
            OUTPUT_FILE ${CMAKE_CURRENT_BINARY_DIR}/navit_genivi_mapviewer.xml
            COMMAND ${XSLTPROC} ${CMAKE_CURRENT_SOURCE_DIR}/navit_genivi_mapviewer.xsl ${NAVIT_CMAKE_DIR}/../navit/navit_shipped.xml
        )
    endif()
endif()

add_definitions(-DPLUGIN=1)
if(WITH_DEBUG)
    add_definitions("-DDEBUG_ENABLED=1")
endif()

# Suppress dev warnings
if(NOT DEFINED CMAKE_SUPPRESS_DEVELOPER_WARNINGS)
	set(CMAKE_SUPPRESS_DEVELOPER_WARNINGS 1 CACHE INTERNAL "No dev warnings")
endif()

# Add sub directories for the plugins

set(PLUGIN_LDFLAGS ${DBUS_CPP_LDFLAGS} ${DBUS_CPP_GLIB_LDFLAGS} ${GLIB_LDFLAGS})
set(PLUGIN_LIBRARIES ${DBUS_CPP_LIBRARY_DIRS} ${GLIB_LIBRARY_DIRS} ${DBUS_CPP_GLIB_LIBRARY_DIRS})

if(${YOCTO_CONFIG})
    include_directories(${STAGING_INCDIR}/navit)
endif()

if (WITH_PLUGIN_MIGRATION)
    # DBus Path
    if(DBUS_LIB_PATH)
      set(DBUS_INCLUDE_DIRS ${DBUS_LIB_PATH}/include/dbus-1.0 ${DBUS_LIB_PATH}/lib/dbus-1.0/include)
      set(DBUS_LIBDIR ${DBUS_LIB_PATH}/lib)
      set(DBUS_LIBRARIES ${DBUS_LIB_PATH}/lib/libdbus-1.so)
    else()
      message(FATAL_ERROR "Please specify the path to your patched DBus library using -DDBUS_LIB_PATH=yourPath")
    endif()

    # Packages
    find_package(CommonAPI)
    find_package(CommonAPI-DBus)

    #pkg_check_modules(DBUS "dbus-1 >= 1.8.4") // #to be fixed, it doesn't work so the paths are set manually (see above)
    pkg_check_modules(COMMONAPI "CommonAPI >= 3.1.5")
    pkg_check_modules(COMMONAPI_DBUS "CommonAPI-DBus >= 3.1.5")
    pkg_check_modules(GOBJECT gobject-2.0)
    pkg_check_modules(GLIB REQUIRED glib-2.0)
    pkg_check_modules(DBUS_CPP_GLIB dbus-c++-glib-1)

    set(FRANCA_DIR "${API_DIR}/franca")
    add_subdirectory(configuration-server-plugin)
    add_subdirectory(mapviewercontrol-server-plugin)
    add_subdirectory(session-server-plugin)
else()
    add_subdirectory(configuration-plugin)
    add_subdirectory(mapviewercontrol-plugin)
    add_subdirectory(session-plugin)
endif()
