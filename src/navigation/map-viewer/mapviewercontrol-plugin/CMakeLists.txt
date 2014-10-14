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
include(CheckIncludeFiles)
include(FindPkgConfig)
include(${navit_SOURCE_DIR}/cmake/navit_macros.cmake)
include_directories(${navit_SOURCE_DIR}/..)
include_directories(${CMAKE_CURRENT_BINARY_DIR})
include_directories(${CMAKE_CURRENT_BINARY_DIR}/..)
include_directories(${INCLUDE_DIRECTORIES})
include_directories(.)
include_directories(compat_includes)
include_directories(${layer_management_INST}/include)
include_directories(${layer_management_INST}/include/ilm)
include_directories(${layer_management_INST}/include/layermanager)
set(CMAKE_REQUIRED_INCLUDES ${layer_management_INST}/include;${layer_management_INST}/include/ilm;${layer_management_INST}/include/layermanager)
link_directories(${CMAKE_CURRENT_SOURCE_DIR}/compat_libs ${layer_management_INST}/lib)
add_definitions(-DPLUGIN=1)
pkg_search_module(DBUS_CPP dbus-c++-glib-1 dbus-c++-1)
pkg_search_module(GLIB glib-2.0)
include_directories(${GLIB_INCLUDE_DIRS})
include_directories(${DBUS_CPP_INCLUDE_DIRS})
check_include_files (ilm/ilm_client.h LM)
if (LM)
	message("building with layer management")
	set(genivi_mapviewer_mapviewercontrol_LIBS ${DBUS_CPP_LDFLAGS} "-lilmCommon" "-lilmClient" "-lilmControl")
	add_definitions(-DLM=1)
else()
	message("building without layer management")
	set(genivi_mapviewer_mapviewercontrol_LIBS ${DBUS_CPP_LDFLAGS})
	add_definitions(-DLM=0)
endif()
ADD_CUSTOM_COMMAND(OUTPUT genivi_mapviewer_mapviewercontrol_adaptor.h
		   COMMAND dbusxx-xml2cpp ${mapviewer_API}/genivi-mapviewer-mapviewercontrol.xml --adaptor=genivi_mapviewer_mapviewercontrol_adaptor.h &&
		   sed -i -e "'s/>,  >/> >/g'" -e "'s/>,  >/> >/g'" -e 's/>::DBus::Struct</>,::DBus::Struct</g' -e 's/>::DBus::Variant/>,::DBus::Variant/g' genivi_mapviewer_mapviewercontrol_adaptor.h
		   DEPENDS ${mapviewer_API}/genivi-mapviewer-mapviewercontrol.xml
		   )
ADD_CUSTOM_COMMAND(OUTPUT genivi_navigationcore_routing_proxy.h
		   COMMAND dbusxx-xml2cpp ${navigationcore_API}/genivi-navigationcore-routing.xml --proxy=genivi_navigationcore_routing_proxy.h &&
			 sed -i -e "'s/>,  >/> >/g'" -e 's/>::DBus::Struct</>,::DBus::Struct</g' genivi_navigationcore_routing_proxy.h
		   DEPENDS ${navigationcore_API}/genivi-navigationcore-routing.xml
		   )
ADD_CUSTOM_COMMAND(OUTPUT genivi_navigationcore_session_proxy.h
		   COMMAND dbusxx-xml2cpp ${navigationcore_API}/genivi-navigationcore-session.xml --proxy=genivi_navigationcore_session_proxy.h
		   DEPENDS ${navigationcore_API}/genivi-navigationcore-session.xml
		   )
ADD_CUSTOM_COMMAND(OUTPUT genivi_navigationcore_mapmatchedposition_proxy.h
		   COMMAND dbusxx-xml2cpp ${navigationcore_API}/genivi-navigationcore-mapmatchedposition.xml --proxy=genivi_navigationcore_mapmatchedposition_proxy.h
		   DEPENDS ${navigationcore_API}/genivi-navigationcore-mapmatchedposition.xml
		   )
module_add_library(genivi_mapviewer_mapviewercontrol genivi_mapviewer_mapviewercontrol.cxx genivi_mapviewer_mapviewercontrol_adaptor.h genivi_navigationcore_routing_proxy.h genivi_navigationcore_session_proxy.h genivi_navigationcore_mapmatchedposition_proxy.h) 
