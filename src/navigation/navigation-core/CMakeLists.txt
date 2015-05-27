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

find_program(XSLTPROC xsltproc REQUIRED)

# Generate the config file for navit/navigation-core
execute_process(
		OUTPUT_FILE ${NAVIT_BIN_DIR}/navit_genivi_navigationcore.xml
		COMMAND ${XSLTPROC} ${CMAKE_CURRENT_SOURCE_DIR}/navit_genivi_navigationcore.xsl ${NAVIT_SRC_DIR}/navit/navit/navit_shipped.xml        
	)

# Add sub directories for the plugins
add_definitions(-DPLUGIN=1)
if(WITH_DEBUG)
    add_definitions("-DDEBUG_ENABLED=1")
endif()

add_subdirectory(configuration-plugin)

add_subdirectory(guidance-plugin)

add_subdirectory(locationinput-plugin)

add_subdirectory(mapmatchedposition-plugin)

add_subdirectory(routing-plugin)

add_subdirectory(session-plugin)

add_subdirectory(enhancedposition-plugin)


