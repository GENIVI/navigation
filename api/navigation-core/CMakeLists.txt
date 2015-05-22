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

message(STATUS "generation of DBus files for navigation-core")

find_program(XSLTPROC xsltproc REQUIRED)
find_program(DBUSXML2CPP dbusxx-xml2cpp REQUIRED)

file (GLOB XML_TO_DBUS 
	${CMAKE_CURRENT_SOURCE_DIR}/genivi-navigationcore-configuration.xml
	${CMAKE_CURRENT_SOURCE_DIR}/genivi-navigationcore-guidance.xml
	${CMAKE_CURRENT_SOURCE_DIR}/genivi-navigationcore-locationinput.xml
	${CMAKE_CURRENT_SOURCE_DIR}/genivi-navigationcore-mapmatchedposition.xml
	${CMAKE_CURRENT_SOURCE_DIR}/genivi-navigationcore-routing.xml
	${CMAKE_CURRENT_SOURCE_DIR}/genivi-navigationcore-session.xml
)
foreach (RAW_FILE ${XML_TO_DBUS})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	execute_process(
		COMMAND ${DBUSXML2CPP} ${RAW_FILE} --proxy=${CMAKE_CURRENT_BINARY_DIR}/${FILE}_proxy.h  
		COMMAND ${DBUSXML2CPP} ${RAW_FILE} --adaptor=${CMAKE_CURRENT_BINARY_DIR}/${FILE}_adaptor.h  
	)
endforeach()

file (GLOB XML_TO_DBUS_CONSTANT
	${CMAKE_CURRENT_SOURCE_DIR}/genivi-navigationcore-constants.xml
)
foreach (RAW_FILE ${XML_TO_DBUS_CONSTANT})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	execute_process(
		OUTPUT_FILE ${CMAKE_CURRENT_BINARY_DIR}/${FILE}.h
		COMMAND ${XSLTPROC} ${CMAKE_CURRENT_SOURCE_DIR}/enum.xsl ${RAW_FILE}        
	)
endforeach()
