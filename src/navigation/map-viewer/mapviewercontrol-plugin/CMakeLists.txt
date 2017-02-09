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

message(STATUS "mapviewer control")

if(${YOCTO_CONFIG})
    add_definitions(-DLM=1)
    message(STATUS "Build with layer manager")
    include_directories(${STAGING_INCDIR})
    link_directories(${STAGING_LIBDIR})
    set(genivi_mapviewer_mapviewercontrol_LIBS ${PLUGIN_LDFLAGS} "-lilmCommon" "-lilmClient" "-lilmControl")

else()
    add_definitions(-DLM=0)
    message(STATUS "Build without layer manager")
    set(genivi_mapviewer_mapviewercontrol_LIBS ${PLUGIN_LDFLAGS})
endif()


include_directories(${DBUS_GENERATED_INCLUDE_DIR}/map-viewer)
include_directories(${DBUS_GENERATED_INCLUDE_DIR}/navigation-core)

set(genivi_mapviewer_mapviewercontrol_LIBRARY_DIRS ${PLUGIN_LIBRARIES})

module_add_library(genivi_mapviewer_mapviewercontrol genivi_mapviewer_mapviewercontrol.cxx ${DBUS_GENERATED_INCLUDE_DIR}/map-viewer/genivi-mapviewer-mapviewercontrol_adaptor.h ${DBUS_GENERATED_INCLUDE_DIR}/navigation-core/genivi-navigationcore-routing_proxy.h ${DBUS_GENERATED_INCLUDE_DIR}/navigation-core/genivi-navigationcore-session_proxy.h ${DBUS_GENERATED_INCLUDE_DIR}/navigation-core/genivi-navigationcore-mapmatchedposition_proxy.h)
add_dependencies(genivi_mapviewer_mapviewercontrol ${API_DIR}/map-viewer)

