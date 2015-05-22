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

set(API_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../api")
set(navit_SRC_DIR "${CMAKE_CURRENT_SOURCE_DIR}/navit")

option(WITH_FRANCA_INTERFACE
       "Build using the Franca interfaces" OFF)
option(WITH_DBUS_INTERFACE
       "Build using the D-Bus interfaces" ON)
option(WITH_DEBUG
        "Enable the debug messages" OFF)
option(NAVIT_DISABLE_QT
	"Disable Qt to build navit" 1)
option(NAVIT_SAMPLE_MAP
	"Use a sample map for navit" 0)
option(NAVIT_NULL_VEHICLE
	"Vehicle null for navit" 1)
option(NAVIT_QTPAINTER
	"qtqpainter for navit" 0)

set(DISABLE_QT "${NAVIT_DISABLE_QT}")
set(SAMPLE_MAP "${NAVIT_SAMPLE_MAP}")
set(vehicle/null "${NAVIT_NULL_VEHICLE}")
set(graphics/qt_qpainter "${NAVIT_QTPAINTER}")

add_subdirectory(navit/navit)

set(NAVIT_MAPS_DIR "${CMAKE_CURRENT_BINARY_DIR}/navit/navit/navit/maps")

add_subdirectory(map)

add_subdirectory(positioning)

add_subdirectory(${API_DIR}/navigation-core "${CMAKE_CURRENT_BINARY_DIR}/navigation-core")

add_subdirectory(${API_DIR}/map-viewer "${CMAKE_CURRENT_BINARY_DIR}/map-viewer")

add_subdirectory(${API_DIR}/poi-service "${CMAKE_CURRENT_BINARY_DIR}/poi-service")

add_subdirectory(navigation-core)


