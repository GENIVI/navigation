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
# \author Philippe Colliot <philippe.colliot@mpsa.com>
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

message(STATUS "speech-output")

include_directories(${DBUS_GENERATED_INCLUDE_DIR_SPEECH})

set(genivi_navigationcore_speechoutput_LIBS ${PLUGIN_LDFLAGS})
set(genivi_navigationcore_speechoutput_LIBRARY_DIRS ${PLUGIN_LIBRARIES})

module_add_library(genivi_navigationcore_speechoutput genivi_navigationcore_speechoutput.cxx ${DBUS_GENERATED_INCLUDE_DIR_SPEECH}/genivi-speechservice-speechoutput_proxy.h ${DBUS_GENERATED_INCLUDE_DIR_SPEECH}/genivi-speechservice-constants.h)

