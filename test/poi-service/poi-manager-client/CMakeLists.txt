###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-manager-client
#
# Author: Philippe Colliot
#
# Copyright (C) 2015, PCA Peugeot Citroën
#
# License:
# This Source Code Form is subject to the terms of the
# Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
# @licence end@
###########################################################################
project(poi-manager-client)
set(COMMON_API_VERSION CommonAPI-2.1)

set(CMAKE_VERBOSE_MAKEFILE off)
cmake_minimum_required(VERSION 2.8)

message(STATUS "poi-manager-client")

find_package(PkgConfig REQUIRED)

pkg_check_modules(DBUS_CPP dbus-c++-1)
pkg_check_modules(GLIB REQUIRED glib-2.0)
pkg_check_modules(GLIBMM glibmm-2.4)
pkg_check_modules(GOBJECT gobject-2.0)
pkg_check_modules(DBUS dbus-1)
pkg_check_modules(DBUS_CPP_GLIB dbus-c++-glib-1)
pkg_check_modules(GTK gtk+-3.0)

FILE(GLOB PRJ_LOCAL_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/*.cpp)
set(PRJ_SRCS ${PRJ_LOCAL_SRCS})

include_directories(
    ${CMAKE_CURRENT_SOURCE_DIR}
    ${COMMON_DIR}
    ${COMMON_DIR_POI_SERVER}
    ${DBUS_GENERATED_INCLUDE_DIR}/poi-service
    ${DBUS_CPP_INCLUDE_DIRS}
    ${GLIB_INCLUDE_DIRS}
    ${SQLITE3_INCLUDE_DIRS}
    ${GLIBMM_INCLUDE_DIRS}
    ${GOBJECT_INCLUDE_DIRS}
    ${DBUS_INCLUDE_DIRS}
    ${DBUS_CPP_GLIB_INCLUDE_DIRS}
    ${GTK_INCLUDE_DIRS}
)

link_directories(
    ${DBUS_CPP_LIBRARY_DIRS}
    ${GLIB_LIBRARY_DIRS}
    ${SQLITE3_LIBRARY_DIRS}
    ${GLIBMM_LIBRARY_DIRS}
    ${GOBJECT_LIBRARY_DIRS}
    ${DBUS_LIBRARY_DIRS}
    ${DBUS_CPP_GLIB_DIRS}
    ${GTK_DIRS}
)

add_executable(${PROJECT_NAME}
    ${PRJ_SRCS}
)

set(LIBRARIES
    ${DBUS_CPP_LIBRARIES}
    ${GLIB_LIBRARIES}
    ${SQLITE3_LIBRARIES}
    ${GLIBMM_LIBRARIES}
    ${GOBJECT_LIBRARIES}
    ${DBUS_LIBRARIES}
    ${DBUS_CPP_GLIB_LIBRARIES}
    ${GTK_LIBRARIES}
)

target_link_libraries(${PROJECT_NAME} ${LIBRARIES})
