###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: test-trigger
#
# Author: Philippe Colliot
#
# Copyright (C) 2017, PSA GROUPE
#
# License:
# This Source Code Form is subject to the terms of the
# Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
# @licence end@
###########################################################################

cmake_minimum_required( VERSION 2.6 )
project( test-trigger )

#
# find dependency packages
#

find_package(PkgConfig)
pkg_check_modules(DLT REQUIRED automotive-dlt)

#
# include directories
#

include_directories(
    ${DLT_INCLUDE_DIRS}
)

#
# build project
#

set(SRCS test-trigger.c)
add_executable(test-trigger ${SRCS})
target_link_libraries(test-trigger ${DLT_LIBRARIES})
set_target_properties(test-trigger PROPERTIES LINKER_LANGUAGE C)

install(TARGETS test-trigger
        DESTINATION ${CMAKE_CURRENT_SOURCE_DIR}/bin)
