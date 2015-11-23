###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: whole franca generation
#
# Author: Marco Residori
#
# Copyright (C) 2015, XS Embedded GmbH
# 
# Note:
# The current file is an adaptation of the example file
# http://git.projects.genivi.org/?p=ipc/common-api-tools.git;a=blob;f=CommonAPI-Examples/E01HelloWorld/CMakeLists.txt
#
# License:
# This Source Code Form is subject to the terms of the
# Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
# @licence end@
###########################################################################

cmake_minimum_required (VERSION 2.8.1)

project(whole-franca)

option(COMMONAPI_TOOL_GENERATOR
       "Absolute path to CommonAPI code generator" "")
option(COMMONAPI_DBUS_TOOL_GENERATOR
       "Absolute path to CommonAPI-DBus code generator" "")

set(COMMONAPI_FIDL_DIR "${CMAKE_CURRENT_SOURCE_DIR}")
set(COMMONAPI_FIDL_DIR_NAVIGATION "${COMMONAPI_FIDL_DIR}/navigation")
set(COMMONAPI_GEN_DIR "${CMAKE_CURRENT_BINARY_DIR}/src-gen")

find_package(PkgConfig REQUIRED)

include(FindPkgConfig)

# generate code from fidl files of navigation
file(GLOB FIDL_FILES 
${COMMONAPI_FIDL_DIR_NAVIGATION}/*.fidl
${COMMONAPI_FIDL_DIR_NAVIGATION}/freetextsearch/*.fidl
${COMMONAPI_FIDL_DIR_NAVIGATION}/mapviewer/*.fidl
${COMMONAPI_FIDL_DIR_NAVIGATION}/navigationcore/*.fidl
${COMMONAPI_FIDL_DIR_NAVIGATION}/poiservice/*.fidl
${COMMONAPI_FIDL_DIR_NAVIGATION}/freetextsearch/speech.fidl
${COMMONAPI_FIDL_DIR_NAVIGATION}/freetextsearch/*.fidl
)

if (COMMONAPI_TOOL_GENERATOR)
     execute_process(WORKING_DIRECTORY ${COMMONAPI_FIDL_DIR}
                COMMAND ${COMMONAPI_DBUS_TOOL_GENERATOR} -d ${COMMONAPI_GEN_DIR} ${FIDL_FILES})
else ()
    message (FATAL_ERROR "Set the variable -DCOMMONAPI_TOOL_GENERATOR=<path>")
endif ()

if (COMMONAPI_DBUS_TOOL_GENERATOR)
    execute_process(WORKING_DIRECTORY ${COMMONAPI_FIDL_DIR}
                COMMAND ${COMMONAPI_TOOL_GENERATOR} -sk -d ${COMMONAPI_GEN_DIR} ${FIDL_FILES})
else ()
    message (FATAL_ERROR "Set the variable -DCOMMONAPI_DBUS_TOOL_GENERATOR=<path>")
endif ()

