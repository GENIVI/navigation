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

message(STATUS "maps")

file (GLOB MAP_FILE_LIST 
	${CMAKE_CURRENT_SOURCE_DIR}/*.bin
)

foreach (RAW_FILE ${MAP_FILE_LIST})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${NAVIT_MAPS_DIR}/${FILE}.xml)
	message(STATUS "generate xml file for the map of '${FILE}'")
	file(WRITE ${NAVIT_MAPS_DIR}/${FILE}.xml "<map type=\"binfile\" data=\"${RAW_FILE}\" />")
	endif()
endforeach()
