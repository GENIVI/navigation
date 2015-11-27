###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-manager-server
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
project(poi-manager-server)
message(STATUS ${PROJECT_NAME})

set(CMAKE_VERBOSE_MAKEFILE on)
set(CMAKE_CXX_FLAGS "-Wall -std=c++0x")

set(PARENT_API poiservice)
set(ROOT_API navigation)
set(API_VERSION_MAJOR 0)
set(API_VERSION_MINOR 1)
set(API_VERSION "v${API_VERSION_MAJOR}_${API_VERSION_MINOR}")
set(COMMONAPI_GEN_DIR "${CMAKE_CURRENT_BINARY_DIR}/src-gen")
set(PRJ_SRC_GEN_PATH ${COMMONAPI_GEN_DIR}/${API_VERSION}/org/genivi/${ROOT_API}/${PARENT_API})
set(PRJ_SRC_GEN_NAVIGATION_TYPES_PATH ${COMMONAPI_GEN_DIR}/org/genivi/${ROOT_API})
set(PRJ_SRC_GEN_POISERVICE_TYPES_PATH ${COMMONAPI_GEN_DIR}/v1_0/org/genivi/${ROOT_API}/${PARENT_API})

# Packages
find_package(PkgConfig REQUIRED)
find_package(CommonAPI 3.1.2 REQUIRED)
find_package(CommonAPI-DBus 3.1.2 REQUIRED)

pkg_check_modules(DBUS "dbus-1 >= 1.4")
pkg_check_modules(COMMONAPI "CommonAPI >= 3.1")
pkg_check_modules(COMMONAPI_DBUS "CommonAPI-DBus >= 3.1")
pkg_check_modules(SQLITE3 REQUIRED sqlite3)
pkg_check_modules(GOBJECT gobject-2.0)
pkg_check_modules(GLIB REQUIRED glib-2.0)

# Source Files
FILE(GLOB PRJ_LOCAL_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/*.cpp)
FILE(GLOB PRJ_COMMON_SRCS ${COMMON_DIR}/poi-common-database.cpp ${COMMON_DIR}/poi-common-math.cpp)

add_subdirectory(${FRANCA_DIR}/poiservice "${CMAKE_CURRENT_BINARY_DIR}/franca")

FILE(GLOB PRJ_STUB_GEN_SRCS ${PRJ_SRC_GEN_PATH}/*Stub*.cpp)
FILE(GLOB PRJ_STUB_GEN_TYPES ${PRJ_SRC_GEN_NAVIGATION_TYPES_PATH}/*Types*.cpp ${PRJ_SRC_GEN_POISERVICE_TYPES_PATH}/*Types*.cpp)
set(PRJ_SRCS ${PRJ_LOCAL_SRCS} ${PRJ_COMMON_SRCS} ${PRJ_STUB_GEN_SRCS} ${PRJ_STUB_GEN_TYPES})

include_directories(
    ${COMMON_DIR}
    ${PRJ_SRC_GEN_PATH}
    ${DBUS_INCLUDE_DIRS}
    ${COMMONAPI_GEN_DIR}
    ${COMMONAPI_INCLUDE_DIRS}
    ${COMMONAPI_DBUS_INCLUDE_DIRS}
    ${GOBJECT_INCLUDE_DIRS}
    ${GLIB_INCLUDE_DIRS}
    ${SQLITE3_INCLUDE_DIRS}
)

link_directories(
    ${DBUS_LIBDIR}
    ${COMMONAPI_LIBDIR}
    ${COMMONAPI_DBUS_LIBDIR}
    ${GOBJECT_LIBRARY_DIRS}
    ${GLIB_LIBRARY_DIRS}
    ${SQLITE3_LIBRARY_DIRS}
)

set(LIBRARIES
    ${DBUS_LIBRARIES}
    ${COMMONAPI_LIBRARIES}
    ${COMMONAPI_DBUS_LIBRARIES}
    ${GOBJECT_LIBRARIES}
    ${GLIB_LIBRARIES}
    ${SQLITE3_LIBRARIES}
)

# Build service
add_executable(${PROJECT_NAME} ${PRJ_SRCS})
target_link_libraries(${PROJECT_NAME} ${LIBRARIES})
install(TARGETS ${PROJECT_NAME} DESTINATION ${CMAKE_RUNTIME_OUTPUT_DIRECTORY})
