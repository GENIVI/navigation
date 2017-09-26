###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: speech-server
#
# Author: Philippe Colliot
#
# Copyright (C) 2017, PSA GROUP
# 
# License:
# This Source Code Form is subject to the terms of the
# Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
# @licence end@
###########################################################################
project(speech-server)
cmake_minimum_required(VERSION 2.8)
find_package(PkgConfig REQUIRED)

message(STATUS ${PROJECT_NAME})

add_definitions("-std=gnu++11")

option(WITH_DEBUG
        "Enable the debug messages" OFF)
option(WITH_DLT
        "Enable DLT logging" OFF)

message(STATUS "WITH_DEBUG = ${WITH_DEBUG}")
message(STATUS "WITH_DLT = ${WITH_DLT}")

set(API_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../api")
set(DBUS_GENERATED_INCLUDE_DIR "${CMAKE_CURRENT_BINARY_DIR}/dbus-include")

set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/lib)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/bin)

if(${WITH_DLT})
    add_definitions("-DDLT_ENABLED=1")
    pkg_check_modules(DLT REQUIRED automotive-dlt)
    include_directories( ${DLT_INCLUDE_DIRS} )
    set(LIBRARIES ${LIBRARIES} ${DLT_LIBRARIES})
endif()

if(WITH_DEBUG)
    add_definitions("-DDEBUG_ENABLED=1")
endif()

pkg_check_modules(DBUS_CPP dbus-c++-1)
pkg_check_modules(GLIB REQUIRED glib-2.0)
pkg_check_modules(GOBJECT gobject-2.0)
pkg_check_modules(DBUS dbus-1)
pkg_check_modules(DBUS_CPP_GLIB dbus-c++-glib-1)

#generates the GLib DBus proxies and adaptors
add_subdirectory(${API_DIR}/speech-service "${DBUS_GENERATED_INCLUDE_DIR}/speech-service")

#add flite dependencies
set(FLITE_INCLUDE_DIRS /usr/include/flite)
set(FLITE_LIBDIR /usr/lib/x86_64-linux-gnu/)
set(FLITE_LIBRARIES /usr/lib/x86_64-linux-gnu/libflite.so /usr/lib/x86_64-linux-gnu/libflite_cmu_us_kal.so)

include_directories(
    ${CMAKE_CURRENT_SOURCE_DIR}
    ${COMMON_DIR}
    ${DBUS_GENERATED_INCLUDE_DIR}/speech-service
    ${DBUS_CPP_INCLUDE_DIRS}
    ${GLIB_INCLUDE_DIRS}
    ${GOBJECT_INCLUDE_DIRS}
    ${DBUS_INCLUDE_DIRS}
    ${DBUS_CPP_GLIB_INCLUDE_DIRS}
    ${FLITE_INCLUDE_DIRS}
)

link_directories(
    ${DBUS_CPP_LIBRARY_DIRS}
    ${GLIB_LIBRARY_DIRS}
    ${GOBJECT_LIBRARY_DIRS}
    ${DBUS_LIBRARY_DIRS}
    ${DBUS_CPP_GLIB_DIRS}
    ${FLITE_LIBDIR}
)

set(LIBRARIES 
    ${LIBRARIES}
    ${DBUS_CPP_LIBRARIES}
    ${GLIB_LIBRARIES}
    ${GOBJECT_LIBRARIES}
    ${DBUS_LIBRARIES}
    ${DBUS_CPP_GLIB_LIBRARIES}
    ${FLITE_LIBRARIES}
)

add_executable(${PROJECT_NAME}
    main.cpp
)

target_link_libraries(${PROJECT_NAME} ${LIBRARIES})

