# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file CMakeLists.txt
#
# \brief This file is part of the build system.
#
# \author Martin Schaller <martin.schaller@it-schaller.de>
#
# \version 1.0
#
# This Source Code Form is subject to the terms of the
# Mozilla Public License (MPL), v. 2.0.
# If a copy of the MPL was not distributed with this file,
# You can obtain one at http://mozilla.org/MPL/2.0/.
#
# For further information see http://www.genivi.org/.
#
# List of changes:
# 
# <date>, <name>, <description of change>
#
# @licence end@
cmake_minimum_required(VERSION 2.8)

include(FindPkgConfig)

include(${navit_SRC_DIR}/navit/cmake/navit_macros.cmake)

add_definitions(-DPLUGIN=1)

message(STATUS "WITH_DEBUG = ${WITH_DEBUG}")

if(WITH_DEBUG)
    add_definitions("-DDEBUG_ENABLED=1")
endif()

pkg_search_module(DBUS_CPP dbus-c++-glib-1 dbus-c++-1)
pkg_search_module(GLIB glib-2.0)
include_directories(${GLIB_INCLUDE_DIRS})
include_directories(${DBUS_CPP_INCLUDE_DIRS})

include_directories(${INCLUDE_DIRECTORIES})
include_directories(.)
include_directories(${navit_SRC_DIR}/navit)
include_directories(${CMAKE_CURRENT_BINARY_DIR})
include_directories(${CMAKE_CURRENT_BINARY_DIR}/..)

include_directories(${generated_api_DIR})

set(genivi_poiservice_cam_navit_LIBS ${DBUS_CPP_LDFLAGS})

module_add_library(genivi_poiservice_cam_navit genivi_poiservice_cam_navit.cxx ${generated_api_DIR}/genivi-poiservice-poicontentaccess_proxy.h ${generated_api_DIR}/genivi-poiservice-contentaccessmodule_adaptor.h)
