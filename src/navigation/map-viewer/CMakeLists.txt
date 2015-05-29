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

find_program(XSLTPROC xsltproc REQUIRED)

# Generate the config file for navit/mapviewer
execute_process(
		OUTPUT_FILE ${NAVIT_BIN_DIR}/navit_genivi_mapviewer.xml
		COMMAND ${XSLTPROC} ${CMAKE_CURRENT_SOURCE_DIR}/navit_genivi_mapviewer.xsl ${NAVIT_SRC_DIR}/navit/navit/navit_shipped.xml        
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

add_subdirectory(configuration-plugin)

add_subdirectory(mapviewercontrol-plugin)

add_subdirectory(session-plugin)
