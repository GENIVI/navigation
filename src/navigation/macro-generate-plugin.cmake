###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file macro-generate-plugin.cmake
#
# \brief This file is part of the build system, 
# \brief it's used to generate the lib for the plugins in the ./bin folder.
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
macro(set_feature_switch_default VARIABLE REASON ENABLE)
   if ((NOT DEFINED ${VARIABLE})                        # variable not in cache (first run)
      OR ((DEFINED ${VARIABLE}_AUTODETECTED_VALUE) AND  # variable in cache -> different from autodetected value?
      ((${VARIABLE}_AUTODETECTED_VALUE AND ${VARIABLE}) OR      # poor man's boolean equal
     (NOT ${VARIABLE}_AUTODETECTED_VALUE AND NOT ${VARIABLE}))))
      set(${VARIABLE}_REASON ${REASON})
      set(${VARIABLE} ${ENABLE} CACHE BOOL "feature switch" FORCE)
   else()
      set(${VARIABLE}_REASON "User defined")
   endif()
   set(${VARIABLE}_AUTODETECTED_VALUE ${ENABLE} CACHE INTERNAL "value autodetected by build script")
endmacro()

macro(set_with_reason VARIABLE REASON ENABLE)
   if (DEFINED ${VARIABLE}_REASON AND NOT ${VARIABLE}_REASON STREQUAL "User defined")
      set(${VARIABLE} ${ENABLE} CACHE BOOL "feature switch" FORCE)
      set(${VARIABLE}_REASON ${REASON})
      string(REPLACE "/" "_" VARIABLE_NAMES ${VARIABLE})
      set(${VARIABLE_NAMES}_LIBS ${ARGN})
   endif()
   set(${VARIABLE}_AUTODETECTED_VALUE ${ENABLE} CACHE INTERNAL "value autodetected by build script")
endmacro()

macro(add_feature FEATURE REASON ENABLE)
   list(APPEND ALL_FEATURES ${FEATURE})
   set_feature_switch_default(${FEATURE} ${REASON} ${ENABLE})
endmacro()

macro(cfg_feature FEATURE REASON ENABLE)
   set(${FEATURE} ${ENABLE})
   if (${FEATURE}_REASON STREQUAL "User defined")
      set(${FEATURE}_REASON "${REASON} *user setting overridden*")
   else()
      set(${FEATURE}_REASON ${REASON})
   endif()
endmacro()

macro(add_module MODULE_PATH REASON ENABLE)
   list(APPEND ALL_MODULES ${MODULE_PATH})
   set_feature_switch_default(${MODULE_PATH} ${REASON} ${ENABLE})
endmacro()

# plugins are always linked static
macro(add_plugin PLUGIN_PATH REASON ENABLE)
   list(APPEND ALL_PLUGINS ${PLUGIN_PATH})
   set_feature_switch_default(${PLUGIN_PATH} ${REASON} ${ENABLE})
endmacro()

# module plugins are always linked static
macro(add_module_plugin PLUGIN_PATH REASON ENABLE)
   list(APPEND ALL_MODULE_PLUGINS ${PLUGIN_PATH})
   set_feature_switch_default(${PLUGIN_PATH} ${REASON} ${ENABLE})
endmacro()

macro(add_library_plugin MODULE_NAME )
   LINK_DIRECTORIES(${${MODULE_NAME}_LIBRARY_DIRS})
   add_library(${MODULE_NAME} ${MODULE_BUILD_TYPE} ${ARGN})
   SET_TARGET_PROPERTIES(${MODULE_NAME} PROPERTIES COMPILE_DEFINITIONS "MODULE=${MODULE_NAME}")
   TARGET_LINK_LIBRARIES(${MODULE_NAME} ${${MODULE_NAME}_LIBS})
   SET_TARGET_PROPERTIES( ${MODULE_NAME} PROPERTIES COMPILE_FLAGS "${NAVIT_COMPILE_FLAGS} ${${MODULE_NAME}_FLAGS}")
   INCLUDE_DIRECTORIES(${${MODULE_NAME}_INCLUDES})
   if (USE_PLUGINS)
       if (ANDROID)
           TARGET_LINK_LIBRARIES(${MODULE_NAME} ${NAVIT_LIBNAME})
       endif()
       if (APPLE)
           set_target_properties( ${MODULE_NAME} PROPERTIES LINK_FLAGS "-Wl,-undefined -Wl,dynamic_lookup")
       endif()
      # all the lib files are generated into the same folder
      set_target_properties( ${MODULE_NAME} PROPERTIES LIBRARY_OUTPUT_DIRECTORY "${CMAKE_LIBRARY_OUTPUT_DIRECTORY}")

      install(TARGETS ${MODULE_NAME}
              DESTINATION ${LIB_DIR}/navit/${${MODULE_NAME}_TYPE}
              PERMISSIONS OWNER_READ OWNER_WRITE OWNER_EXECUTE GROUP_READ GROUP_EXECUTE WORLD_READ WORLD_EXECUTE)
   endif()
endmacro(add_library_plugin)

macro(supportlib_add_library LIB_NAME )
   add_library(${LIB_NAME} ${ARGN})
   TARGET_LINK_LIBRARIES(${LIB_NAME} ${${LIB_NAME}_LIBS})
   SET_TARGET_PROPERTIES( ${LIB_NAME} PROPERTIES COMPILE_FLAGS "${NAVIT_COMPILE_FLAGS}")
   SET_TARGET_PROPERTIES(${LIB_NAME} PROPERTIES COMPILE_DEFINITIONS "MODULE=${LIB_NAME}")
endmacro(supportlib_add_library)

macro(message_error)
   set(NAVIT_DEPENDENCY_ERROR 1)
   message( SEND_ERROR ${ARGN})
endmacro(message_error)

include(CheckCCompilerFlag)
include(CheckCXXCompilerFlag)
function(add_compiler_flag_if_available FLAG)
   set(VAR_FLAG_AVAILABLE_C "FLAG_AVAILABLE_C_${FLAG}")
   check_c_compiler_flag(${FLAG} ${VAR_FLAG_AVAILABLE_C})
   if (${${VAR_FLAG_AVAILABLE_C}})
      set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} ${FLAG} ")
   endif()
   if(CMAKE_CXX_COMPILER_LOADED) # C++ compiler is optional
      set(VAR_FLAG_AVAILABLE_CXX "FLAG_AVAILABLE_CXX_${FLAG}")
      check_cxx_compiler_flag(${FLAG} ${VAR_FLAG_AVAILABLE_CXX})
      if (${${VAR_FLAG_AVAILABLE_CXX}})
         set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} ${FLAG} ")
      endif()
   endif()
endfunction(add_compiler_flag_if_available)
