###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: franca navigation generation
#
# Author: Philippe Colliot
#
# Copyright (C) 2015, PCA Peugeot Citroen 
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

project(franca-navigation)

get_directory_property(hasParent PARENT_DIRECTORY)

if(hasParent)
    set(COMMONAPI_GEN_DIR "${COMMONAPI_GEN_DIR}" PARENT_SCOPE)
else()
    set(COMMONAPI_GEN_DIR "${CMAKE_CURRENT_BINARY_DIR}/src-gen")
endif()

add_subdirectory(freetextsearchservice)
add_subdirectory(mapviewer)
add_subdirectory(navigationcore)
add_subdirectory(poiservice)
