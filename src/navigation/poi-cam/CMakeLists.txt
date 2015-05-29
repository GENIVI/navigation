###########################################################################
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
###########################################################################
project(navigation)
cmake_minimum_required(VERSION 2.8)

message(STATUS "poi cam")

include(FindPkgConfig)

pkg_search_module(DBUS_CPP dbus-c++-glib-1 dbus-c++-1)
pkg_search_module(GLIB glib-2.0)
include_directories(${GLIB_INCLUDE_DIRS})
include_directories(${DBUS_CPP_INCLUDE_DIRS})

include_directories(${NAVIT_SRC_DIR}/navit/navit)

include_directories(${NAVIT_CONFIG_H_DIR}) # this one contains config.h that is generated

include_directories(${DBUS_GENERATED_INCLUDE_DIR}/poi-service)

set(genivi_poiservice_cam_navit_LIBS ${DBUS_CPP_LDFLAGS})

add_definitions(-DPLUGIN=1)
if(WITH_DEBUG)
    add_definitions("-DDEBUG_ENABLED=1")
endif()

# Suppress dev warnings
if(NOT DEFINED CMAKE_SUPPRESS_DEVELOPER_WARNINGS)
	set(CMAKE_SUPPRESS_DEVELOPER_WARNINGS 1 CACHE INTERNAL "No dev warnings")
endif()

#preload the cache with some navit settings
LOAD_CACHE(${PRELOAD_CACHE_FOR_PLUGINS})

include(${NAVIT_SRC_DIR}/navit/cmake/navit_macros.cmake)

module_add_library(genivi_poiservice_cam_navit genivi_poiservice_cam_navit.cxx ${DBUS_GENERATED_INCLUDE_DIR}/poi-service/genivi-poiservice-poicontentaccess_proxy.h ${DBUS_GENERATED_INCLUDE_DIR}/poi-service/genivi-poiservice-contentaccessmodule_adaptor.h)


