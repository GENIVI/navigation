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
include_directories(${CMAKE_CURRENT_BINARY_DIR}/../..)

include_directories(${generated_api_DIR})

set(genivi_positioning_enhancedposition_LIBS ${DBUS_CPP_LDFLAGS})

message(STATUS "${positioning_API}")

ADD_CUSTOM_COMMAND(OUTPUT ${generated_api_DIR}/genivi-positioning-enhancedposition_proxy.h
		   COMMAND dbusxx-xml2cpp ${positioning_API}/genivi-positioning-enhancedposition.xml --proxy=${generated_api_DIR}/genivi-positioning-enhancedposition_proxy.h 
		   DEPENDS ${positioning_API}/genivi-positioning-enhancedposition.xml
		   )

if(NOT EXISTS ${generated_api_DIR}/genivi-positioning-constants.h)
	execute_process(
		OUTPUT_FILE ${generated_api_DIR}/genivi-positioning-constants.h
		COMMAND xsltproc ${api_DIR}/poi-service/enum.xsl ${positioning_API}/genivi-positioning-constants.xml   
	)
else()
	if(${positioning_API}/genivi-positioning-constants.xml IS_NEWER_THAN ${generated_api_DIR}/genivi-positioning-constants.h)
		execute_process(
			OUTPUT_FILE ${generated_api_DIR}/genivi-positioning-constants.h
			COMMAND xsltproc ${api_DIR}/poi-service/enum.xsl ${positioning_API}/genivi-positioning-constants.xml   #use another enum.xsl for radix consistency
		)
	endif()
endif()

module_add_library(genivi_positioning_enhancedposition genivi_positioning_enhancedposition.cxx ${generated_api_DIR}/genivi-positioning-enhancedposition_proxy.h) 
