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

message(STATUS "session")

include_directories(${DBUS_GENERATED_INCLUDE_DIR}/map-viewer)

set(genivi_mapviewer_session_LIBS ${PLUGIN_LDFLAGS})
set(genivi_mapviewer_session_LIBRARY_DIRS ${PLUGIN_LIBRARIES})

module_add_library(genivi_mapviewer_session genivi_mapviewer_session.cxx ${DBUS_GENERATED_INCLUDE_DIR}/map-viewer/genivi-mapviewer-session_adaptor.h)

