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

message(STATUS "configuration")

include(FindPkgConfig)

include(${NAVIT_SRC_DIR}/navit/cmake/navit_macros.cmake)

pkg_search_module(DBUS_CPP dbus-c++-glib-1 dbus-c++-1)
pkg_search_module(GLIB glib-2.0)
include_directories(${GLIB_INCLUDE_DIRS})
include_directories(${DBUS_CPP_INCLUDE_DIRS})

include_directories(${NAVIT_SRC_DIR}/navit/navit)

include_directories(${NAVIT_BIN_DIR}) # this one contains config.h that is generated

include_directories(${DBUS_GENERATED_INCLUDE_DIR}/navigation-core)

set(genivi_navigationcore_configuration_LIBS ${DBUS_CPP_LDFLAGS})

module_add_library(genivi_navigationcore_configuration genivi_navigationcore_configuration.cxx ${DBUS_GENERATED_INCLUDE_DIR}/navigation-core/genivi-navigationcore-configuration_adaptor.h) 


