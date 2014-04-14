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
include_directories(${INCLUDE_DIRECTORIES})
include_directories(.)
include_directories(../../..)
include_directories(compat_includes)
include_directories(${navit_SOURCE_DIR}/..)
include_directories(${CMAKE_CURRENT_BINARY_DIR})
include_directories(${CMAKE_CURRENT_BINARY_DIR}/..)
link_directories(${CMAKE_CURRENT_SOURCE_DIR}/compat_libs)
add_definitions(-DPLUGIN=1)
pkg_search_module(DBUS_CPP dbus-c++-glib-1 dbus-c++-1)
include_directories(${DBUS_CPP_INCLUDE_DIRS})
set(genivi_poiservice_cam_navit_LIBS ${DBUS_CPP_LDFLAGS})
ADD_CUSTOM_COMMAND(OUTPUT genivi_poiservice_poicontentaccess_proxy.h
		   COMMAND dbusxx-xml2cpp ${poi-service_API}/genivi-poiservice-poicontentaccess.xml --proxy=genivi_poiservice_poicontentaccess_proxy.h
		   DEPENDS ${poi-service_API}/genivi-poiservice-poicontentaccess.xml
		   )
ADD_CUSTOM_COMMAND(OUTPUT genivi_poiservice_contentaccessmodule_adaptor.h
		   COMMAND dbusxx-xml2cpp ${poi-service_API}/genivi-poiservice-contentaccessmodule.xml --adaptor=genivi_poiservice_contentaccessmodule_adaptor.h
		   DEPENDS ${poi-service_API}/genivi-poiservice-contentaccessmodule.xml
		   )
module_add_library(genivi_poiservice_cam_navit genivi_poiservice_cam_navit.cxx genivi_poiservice_poicontentaccess_proxy.h genivi_poiservice_contentaccessmodule_adaptor.h)
