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

message(STATUS "guidance")

if(WITH_SPEECH)
    add_definitions("-DSPEECH_ENABLED=1")
    include_directories(${DBUS_GENERATED_INCLUDE_DIR}/speech-service)
endif()

if(WITH_DLT)
    pkg_check_modules(DLT REQUIRED automotive-dlt)
    add_definitions("-DDLT_ENABLED=1")
    include_directories( ${DLT_INCLUDE_DIRS} )
    set(LIBRARIES ${LIBRARIES} ${DLT_LIBRARIES})
endif()

include_directories(${DBUS_GENERATED_INCLUDE_DIR}/navigation-core)

set(genivi_navigationcore_guidance_LIBS ${PLUGIN_LDFLAGS})
set(genivi_navigationcore_guidance_LIBRARY_DIRS ${PLUGIN_LIBRARIES})

module_add_library(genivi_navigationcore_guidance genivi_navigationcore_guidance.cxx ${DBUS_GENERATED_INCLUDE_DIR}/navigation-core/genivi-navigationcore-guidance_adaptor.h)
target_link_libraries(genivi_navigationcore_guidance ${LIBRARIES})
