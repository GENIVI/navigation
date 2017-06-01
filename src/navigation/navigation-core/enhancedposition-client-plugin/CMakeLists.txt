###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: enhancedposition-client-plugin
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
project(positioning-enhancedposition-client-plugin)
cmake_minimum_required(VERSION 2.8)

message(STATUS ${PROJECT_NAME})

set(CMAKE_VERBOSE_MAKEFILE on)
set(CMAKE_CXX_FLAGS "-Wall -std=c++0x")



set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/lib)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/bin)

# Path to the generated files
set(PRJ_SRC_GEN_ENHANCEDPOSITIONSERVICE_PATH_SRC "${COMMONAPI_GEN_DIR_POSITIONING}/v5/org/genivi/EnhancedPositionService") #files shared by the enhanced position service APIs
set(PRJ_SRC_GEN_ENHANCEDPOSITIONSERVICE_PATH_INC "${COMMONAPI_GEN_DIR_POSITIONING}/org/genivi/EnhancedPositionService")

# Source Files
FILE(GLOB PRJ_LOCAL_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/*.cxx)
FILE(GLOB PRJ_PROXY_GEN_SRCS
    ${PRJ_SRC_GEN_ENHANCEDPOSITIONSERVICE_PATH_SRC}/EnhancedPositionDBusProxy.cpp
)

set(PRJ_SRCS ${PRJ_LOCAL_SRCS} ${PRJ_PROXY_GEN_SRCS})

include_directories(
    ${COMMONAPI_GEN_DIR}
    ${COMMONAPI_GEN_DIR_POSITIONING}
    ${PRJ_SRC_GEN_ENHANCEDPOSITIONSERVICE_PATH_INC}
    ${PRJ_SRC_GEN_ENHANCEDPOSITIONSERVICE_PATH_SRC}
    ${DBUS_INCLUDE_DIRS}
    ${COMMONAPI_INCLUDE_DIRS}
    ${COMMONAPI_DBUS_INCLUDE_DIRS}
    ${GOBJECT_INCLUDE_DIRS}
    ${GLIB_INCLUDE_DIRS}
    ${DBUS_CPP_GLIB_INCLUDE_DIRS}
)

link_directories(
    ${DBUS_LIBDIR}
    ${COMMONAPI_LIBDIR}
    ${COMMONAPI_DBUS_LIBDIR}
    ${GOBJECT_LIBRARY_DIRS}
    ${GLIB_LIBRARY_DIRS}
    ${DBUS_CPP_GLIB_DIRS}
)

set(LIBRARIES
    ${LIBRARIES}
    ${DBUS_LIBRARIES}
    ${COMMONAPI_LIBRARIES}
    ${COMMONAPI_DBUS_LIBRARIES}
    ${GOBJECT_LIBRARIES}
    ${GLIB_LIBRARIES}
    ${DBUS_CPP_GLIB_LIBRARIES}
)

# Build service
module_add_library(genivi_positioning_enhancedposition_client ${PRJ_SRCS})
target_link_libraries(genivi_positioning_enhancedposition_client ${LIBRARIES})

