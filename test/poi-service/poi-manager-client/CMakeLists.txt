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
set(PARENT_API poiservice)
set(ROOT_API navigation)
set(COMMON_API_VERSION CommonAPI-2.1)

set(CMAKE_VERBOSE_MAKEFILE off)
cmake_minimum_required(VERSION 2.8)
set(CMAKE_CXX_FLAGS "-Wall -O0 -std=c++0x")

# DBus Path
if (DBUS_LIB_PATH)
  message(STATUS "DBUS_LIB_PATH = " ${DBUS_LIB_PATH})
else()
  message(FATAL_ERROR "Please specify the path to your patched DBus library using -D DBUS_LIB_PATH=yourPath")
endif()

# Packages
find_package(PkgConfig REQUIRED)
pkg_check_modules(DBUS "dbus-1 >= 1.4")
pkg_check_modules(COMMONAPI "CommonAPI >= 2.1")
pkg_check_modules(COMMONAPI_DBUS "CommonAPI-DBus >= 2.1")
pkg_check_modules(SQLITE3 REQUIRED sqlite3)
pkg_check_modules(GLIBMM glibmm-2.4)

# Source Files
set(PRJ_SRC_PATH .)
set(PRJ_SRC_GEN_PATH ${COMMON_API_GENERATED_INCLUDE_DIR}/org/genivi)
FILE(GLOB PRJ_LOCAL_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/*.cpp)
FILE(GLOB PRJ_STUB_GEN_SRCS ${PRJ_SRC_GEN_PATH}/${ROOT_API}/${PARENT_API}/*Stub*.cpp)
FILE(GLOB PRJ_STUB_GEN_TYPES ${PRJ_SRC_GEN_PATH}/${ROOT_API}/${PARENT_API}/*Types*.cpp ${PRJ_SRC_GEN_PATH}/${ROOT_API}/*Types*.cpp)
FILE(GLOB PRJ_STUB_IMPL_SRCS ${PRJ_SRC_PATH}/*stub*.cpp)
set(PRJ_SRCS ${PRJ_LOCAL_SRCS} ${PRJ_STUB_GEN_SRCS} ${PRJ_STUB_GEN_TYPES} ${PRJ_STUB_IMPL_SRCS})

include_directories(
    ${PRJ_SRC_PATH}
    ${COMMON_API_GENERATED_INCLUDE_DIR}
    ${DBUS_INCLUDE_DIRS}
    ${COMMONAPI_INCLUDEDIR}/${COMMON_API_VERSION}
    ${COMMONAPI_DBUS_INCLUDEDIR}
    ${GLIBMM_INCLUDE_DIRS}
    ${SQLITE3_INCLUDE_DIRS}
)

link_directories(
    ${DBUS_LIB_PATH}
    ${COMMONAPI_LIBDIR}
    ${COMMONAPI_DBUS_LIBDIR}
    ${GLIBMM_LIBRARY_DIRS}
    ${SQLITE3_LIBRARY_DIRS}
)

set(LIBRARIES
    ${COMMONAPI_LIBRARIES}
    ${COMMONAPI_DBUS_LIBRARIES}
    ${GLIBMM_LIBRARIES}
    ${SQLITE3_LIBRARIES}
)

# Build service
add_executable(${PROJECT_NAME} ${PRJ_SRCS})
target_link_libraries(${PROJECT_NAME} ${LIBRARIES})

