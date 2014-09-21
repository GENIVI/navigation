###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-supplier
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
project(poi-supplier)
cmake_minimum_required(VERSION 2.8)

message(STATUS "poi-supplier")

find_package(PkgConfig REQUIRED)

pkg_check_modules(GLIB REQUIRED glib-2.0)
pkg_check_modules(SQLITE3 REQUIRED sqlite3)
pkg_check_modules(GLIBMM glibmm-2.4)
pkg_check_modules(GOBJECT gobject-2.0)
pkg_check_modules(XML2 libxml-2.0)
pkg_check_modules(XMLCPP libxml++-2.6)

include_directories(${CMAKE_CURRENT_BINARY_DIR})
include_directories(${GLIB_INCLUDE_DIRS})
include_directories(${SQLITE3_INCLUDE_DIRS})
include_directories(${GLIBMM_INCLUDE_DIRS})
include_directories(${GOBJECT_INCLUDE_DIRS})
include_directories(${XML2_INCLUDE_DIRS})
include_directories(${XMLCPP_INCLUDE_DIRS})

link_directories(
    ${GLIB_LIBRARY_DIRS}
	${SQLITE3_LIBRARY_DIRS}
	${GLIBMM_LIBRARY_DIRS}
	${GOBJECT_LIBRARY_DIRS}
	${XML2_LIBRARY_DIRS}
	${XMLCPP_LIBRARY_DIRS}
)

add_executable(poi-supplier
	main.cpp 
    database.cpp 
    raw-file-sort.cpp
	database.h 
    raw-file-sort.h 
    poi-datamodel.h
)

set(LIBRARIES 
    ${GLIB_LIBRARIES}
	${SQLITE3_LIBRARIES}
	${GLIBMM_LIBRARIES}
	${GOBJECT_LIBRARIES}
	${XML2_LIBRARIES}
	${XMLCPP_LIBRARIES}
)

target_link_libraries(poi-supplier ${LIBRARIES})


