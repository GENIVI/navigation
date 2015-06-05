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

message(STATUS "navigation-core")

include(FindPkgConfig)

pkg_search_module(DBUS_CPP_GLIB dbus-c++-glib-1)
pkg_search_module(DBUS_CPP dbus-c++-1)
pkg_search_module(GLIB glib-2.0)

include_directories(${GLIB_INCLUDE_DIRS})
include_directories(${DBUS_CPP_INCLUDE_DIRS})
include_directories(${DBUS_CPP_GLIB_INCLUDE_DIRS})

include(${PRELOAD_CACHE_FOR_PLUGINS})

include_directories(${INCLUDE_DIRECTORIES})
include_directories(.)
include_directories(${navit_SOURCE_DIR}/navit)
include_directories(${CMAKE_CURRENT_BINARY_DIR})

include_directories(${NAVIT_CONFIG_H_DIR}) # this one contains config.h that is generated

find_program(XSLTPROC xsltproc REQUIRED)

# Generate the config file for navit/navigation-core
execute_process(
                OUTPUT_FILE ${NAVIT_BIN_DIR}/navit_genivi_navigationcore.xml
                COMMAND ${XSLTPROC} ${CMAKE_CURRENT_SOURCE_DIR}/navit_genivi_navigationcore.xsl ${navit_SOURCE_DIR}/navit/navit_shipped.xml
	)

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
set(PLUGIN_LIBRARIES ${DBUS_CPP_LIBRARY_DIRS} ${GLIB_LIBRARY_DIRS} ${DBUS_CPP_GLIB_DIRS})

add_subdirectory(configuration-plugin)

add_subdirectory(guidance-plugin)

add_subdirectory(locationinput-plugin)

add_subdirectory(mapmatchedposition-plugin)

add_subdirectory(routing-plugin)

add_subdirectory(session-plugin)

add_subdirectory(enhancedposition-plugin)


