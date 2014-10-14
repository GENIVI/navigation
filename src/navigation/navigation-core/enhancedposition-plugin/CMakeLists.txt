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
include(${navit_SOURCE_DIR}/cmake/navit_macros.cmake)
include_directories(${navit_SOURCE_DIR}/..)
include_directories(${CMAKE_CURRENT_BINARY_DIR})
include_directories(${CMAKE_CURRENT_BINARY_DIR}/..)
include_directories(${INCLUDE_DIRECTORIES})
include_directories(.)
include_directories(compat_includes)
link_directories(${CMAKE_CURRENT_SOURCE_DIR}/compat_libs)
add_definitions(-DPLUGIN=1)
pkg_search_module(DBUS_CPP dbus-c++-glib-1 dbus-c++-1)
pkg_search_module(GLIB glib-2.0)
include_directories(${GLIB_INCLUDE_DIRS})
include_directories(${DBUS_CPP_INCLUDE_DIRS})
set(genivi_positioning_enhancedposition_LIBS ${DBUS_CPP_LDFLAGS})
ADD_CUSTOM_COMMAND(OUTPUT genivi_positioning_enhancedposition_proxy.h
		   COMMAND dbusxx-xml2cpp ${positioning_API}/genivi-positioning-enhancedposition.xml --proxy=genivi_positioning_enhancedposition_proxy.h &&
			 sed -i -e "'s/>,  >/> >/g'" -e 's/>::DBus::Struct</>,::DBus::Struct</g' genivi_positioning_enhancedposition_proxy.h
		   DEPENDS ${positioning_API}/genivi-positioning-enhancedposition.xml
		   )
module_add_library(genivi_positioning_enhancedposition genivi_positioning_enhancedposition.cxx genivi_positioning_enhancedposition_proxy.h) 
