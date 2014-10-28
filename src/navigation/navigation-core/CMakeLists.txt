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

message(STATUS "navigation")

find_program(XSLTPROC xsltproc REQUIRED)

# Generate the config file for navit/navigation-core
set(NAVIGATION_CORE_SRC ${CMAKE_CURRENT_SOURCE_DIR})

if(NOT EXISTS ${CMAKE_CURRENT_BINARY_DIR}/../navit/navit/navit_genivi_navigationcore.xml)
	execute_process(
		OUTPUT_FILE ${CMAKE_CURRENT_BINARY_DIR}/../navit/navit/navit_genivi_navigationcore.xml
		COMMAND ${XSLTPROC} ${NAVIGATION_CORE_SRC}/navit_genivi_navigationcore.xsl ${navit_SRC_DIR}/navit/navit/navit_shipped.xml        
	)
else()
	if(${NAVIGATION_CORE_SRC}/navit_genivi_navigationcore.xsl IS_NEWER_THAN ${CMAKE_CURRENT_BINARY_DIR}/../navit/navit/navit_genivi_navigationcore.xml)
		execute_process(
			OUTPUT_FILE ${CMAKE_CURRENT_BINARY_DIR}/../navit/navit/navit_genivi_navigationcore.xml
			COMMAND ${XSLTPROC} ${NAVIGATION_CORE_SRC}/navit_genivi_navigationcore.xsl ${navit_SRC_DIR}/navit/navit/navit_shipped.xml        
		)
	endif()
endif()

