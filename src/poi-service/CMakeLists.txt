###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-server
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
project(poi-server)
cmake_minimum_required(VERSION 2.8)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

message(STATUS "poi-server")

option(WITH_FRANCA_INTERFACE
       "Build using the Franca interfaces" OFF)
option(WITH_DBUS_INTERFACE
       "Build using the D-Bus interfaces" ON)
option(WITH_DEBUG
        "Enable the debug messages" OFF)

message(STATUS "WITH_FRANCA_INTERFACE = ${WITH_FRANCA_INTERFACE}")
message(STATUS "WITH_DBUS_INTERFACE = ${WITH_DBUS_INTERFACE}")
message(STATUS "WITH_DEBUG = ${WITH_DEBUG}")

set(COMMON_DIR "${CMAKE_CURRENT_SOURCE_DIR}/poi-common")
set(API_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../api")
set(DBUS_GENERATED_INCLUDE_DIR "${CMAKE_CURRENT_BINARY_DIR}/dbus-include")
set(COMMON_API_GENERATED_INCLUDE_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../api/franca/navigation/src-gen")
set(DBUS_LIB_PATH "/usr/local/lib")

add_subdirectory(${API_DIR}/navigation-core "${DBUS_GENERATED_INCLUDE_DIR}/navigation-core")

add_subdirectory(${API_DIR}/map-viewer "${DBUS_GENERATED_INCLUDE_DIR}/map-viewer")

add_subdirectory(${API_DIR}/poi-service "${DBUS_GENERATED_INCLUDE_DIR}/poi-service")

add_subdirectory(poi-server)

if (WITH_FRANCA_INTERFACE)
   add_subdirectory(poi-manager-server)
endif()
