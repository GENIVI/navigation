###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: navigation
#
# Author: Philippe Colliot
#
# Copyright (C) 2014, PCA Peugeot Citroën
# 
# License:
# This Source Code Form is subject to the terms of the
# Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
# @licence end@
###########################################################################
project(navigation)
cmake_minimum_required(VERSION 2.8)

message(STATUS "navigation")

find_package(PkgConfig REQUIRED)
find_program(XSLTPROC xsltproc REQUIRED)
find_program(GIT git)
find_program(SVN svn)

include_directories(${CMAKE_CURRENT_BINARY_DIR})

set (git_get_src_version git rev-parse HEAD)
set (git_executable ${GIT})
set (create_file cmake -E touch)
set (remove_file cmake -E rm)

set (svn_executable ${SVN})
set (svn_get_src_version svnversion)

set(cmake_create_dir cmake -E make_directory)
set (apply_patch_git patch -p1 -s) 
set (apply_patch_svn patch -p0 -s) 

set(WITH_LM $ENV{WLD}) 

# ..............................Get the wayland-ivi-extension code..............................

# Check if ivi layer management stuff with the right version has been cloned and do it if necessary
# ilm is cloned into sub dir
set(wayland-ivi-extension_SRC_DIR ${layer-management_SRC_DIR}/wayland-ivi-extension)
set(weston-ivi-shell_SRC_DIR ${layer-management_SRC_DIR}/weston-ivi-shell)
set(wayland-ivi-extension_URL http://git.projects.genivi.org/wayland-ivi-extension.git)
set(wayland-ivi-extension_VERSION 278437417d1ac0958a800eecfebd2a388d6d9ca7)

if (EXISTS ${wayland-ivi-extension_SRC_DIR})
	execute_process(	
		COMMAND ${git_get_src_version}  
		WORKING_DIRECTORY "${wayland-ivi-extension_SRC_DIR}"
		RESULT_VARIABLE result
		OUTPUT_VARIABLE version
	)
	if (${version} MATCHES ${wayland-ivi-extension_VERSION})
		message(STATUS "version of wayland-ivi-extension up to date")	
	else()
		message(STATUS "get the right version of wayland-ivi-extension")
	 	execute_process(
			COMMAND "${git_executable}" pull
			COMMAND "${git_executable}" checkout ${wayland-ivi-extension_VERSION}
			WORKING_DIRECTORY "${wayland-ivi-extension_SRC_DIR}"
			RESULT_VARIABLE error_code
		)
		if(error_code)
			message(FATAL_ERROR "Failed to checkout version: '${wayland-ivi-extension_VERSION}'")
		endif()	
	endif()
else()
	message(STATUS "clone wayland-ivi-extension")
	execute_process(
		COMMAND "${git_executable}" clone "${wayland-ivi-extension_URL}" "${wayland-ivi-extension_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
 	if(error_code)
		message(FATAL_ERROR "Failed to clone repository: '${wayland-ivi-extension_URL}'")
	endif()
	message(STATUS "get the right version of wayland-ivi-extension")
 	execute_process(
		COMMAND "${git_executable}" pull
		COMMAND "${git_executable}" checkout ${wayland-ivi-extension_VERSION}
		WORKING_DIRECTORY "${wayland-ivi-extension_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
	if(error_code)
		message(FATAL_ERROR "Failed to checkout version: '${wayland-ivi-extension_VERSION}'")
	endif()	
endif()

# ..............................Get the weston-ivi-shell code..............................

set(weston-ivi-shell_URL https://github.com/ntanibata/weston-ivi-shell.git)
set(weston-ivi-shell_VERSION a3dd3192343e573e9cbf349022cb81b77bfbdaca)
set(weston-ivi-shell_PATCH_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/patches)
set(weston-ivi-shell_PATCH_DUMMY_FILE ${weston-ivi-shell_SRC_DIR}/.patched)

if (EXISTS ${weston-ivi-shell_SRC_DIR})
	execute_process(	
		COMMAND ${git_get_src_version}  
		WORKING_DIRECTORY "${weston-ivi-shell_SRC_DIR}"
		RESULT_VARIABLE result
		OUTPUT_VARIABLE version
	)
	if (${version} MATCHES ${weston-ivi-shell_VERSION})
		message(STATUS "version of weston-ivi-shell up to date")	
	else()
		message(STATUS "get the right version of weston-ivi-shell")
	 	execute_process(
			COMMAND "${git_executable}" pull
			COMMAND "${git_executable}" checkout ${weston-ivi-shell_VERSION}
			WORKING_DIRECTORY "${weston-ivi-shell_SRC_DIR}"
			RESULT_VARIABLE error_code
		)
		if(error_code)
			message(FATAL_ERROR "Failed to checkout version: '${weston-ivi-shell_VERSION}'")
		endif()	
	endif()
else()
	message(STATUS "clone weston-ivi-shell")
	execute_process(
		COMMAND "${git_executable}" clone "${weston-ivi-shell_URL}" "${weston-ivi-shell_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
 	if(error_code)
		message(FATAL_ERROR "Failed to clone repository: '${weston-ivi-shell_URL}'")
	endif()
	message(STATUS "get the right version of weston-ivi-shell")
 	execute_process(
		COMMAND "${git_executable}" pull
		COMMAND "${git_executable}" checkout ${weston-ivi-shell_VERSION}
		WORKING_DIRECTORY "${weston-ivi-shell_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
	if(error_code)
		message(FATAL_ERROR "Failed to checkout version: '${weston-ivi-shell_VERSION}'")
	endif()	
endif()

if (EXISTS ${weston-ivi-shell_PATCH_DUMMY_FILE})
	message(STATUS "patch already applied to weston-ivi-shell")
else()
	message(STATUS "apply the patches to weston-ivi-shell")
	execute_process(
		COMMAND ${apply_patch_git} -i ${weston-ivi-shell_PATCH_SRC_DIR}/0001-client.pro-Disable-create_cmake-configuration.patch
		COMMAND ${apply_patch_git} -i ${weston-ivi-shell_PATCH_SRC_DIR}/0002-Update-ivi-application.xml-and-fix-inplementation-of.patch
		COMMAND ${create_file} ${weston-ivi-shell_PATCH_DUMMY_FILE}
		TIMEOUT 0.1 #cmake -E touch never ends so add a timeout here
		WORKING_DIRECTORY "${weston-ivi-shell_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
	if(error_code)
		message(FATAL_ERROR "Failed to apply the patch")
	endif()	
endif()

# ..............................Get the positioning code..............................

# Check if positioning stuff with the right version has been cloned and do it if necessary
# positioning_SRC_DIR is set by cmake -Dpositioning_SRC_DIR=<path to positioning src dir> 
set(positioning_URL http://git.projects.genivi.org/lbs/positioning.git)
set(positioning_VERSION 3a1254f9ac4f5e2d088d24598e76764874a40b99)

if (EXISTS ${positioning_SRC_DIR})
	execute_process(COMMAND ${git_get_src_version}  
					WORKING_DIRECTORY "${positioning_SRC_DIR}"
					RESULT_VARIABLE result
					OUTPUT_VARIABLE version)
	if (${version} MATCHES ${positioning_VERSION})
		message(STATUS "version of positioning up to date")	
	else()
		message(STATUS "get the right version of positioning")
	 	execute_process(
			COMMAND "${git_executable}" pull
			COMMAND "${git_executable}" checkout ${positioning_VERSION}
			WORKING_DIRECTORY "${positioning_SRC_DIR}"
			RESULT_VARIABLE error_code
		)
		if(error_code)
			message(FATAL_ERROR "Failed to checkout version: '${positioning_VERSION}'")
		endif()	
	endif()
else()
	message(STATUS "clone positioning")
	execute_process(
		COMMAND "${git_executable}" clone "${positioning_URL}" "${positioning_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
 	if(error_code)
		message(FATAL_ERROR "Failed to clone repository: '${positioning_URL}'")
	endif()

	message(STATUS "get the right version of positioning")
 	execute_process(
		COMMAND "${git_executable}" pull
		COMMAND "${git_executable}" checkout ${positioning_VERSION}
		WORKING_DIRECTORY "${positioning_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
	if(error_code)
		message(FATAL_ERROR "Failed to checkout version: '${positioning_VERSION}'")
	endif()	
endif()

# ..............................Get the navit code..............................

# Check if navit stuff with the right version has been cloned and do it if necessary
set(navit_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/navit)
set(navit_URL http://svn.code.sf.net/p/navit/code/trunk)
set(navit_VERSION 6025)
set(navit_PATCH_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/patches)
set(navit_PATCH_DUMMY_FILE_SPELL ${navit_SRC_DIR}/.patched-spell)
set(navit_PATCH_DUMMY_FILE_LM ${navit_SRC_DIR}/.patched-lm)

if (EXISTS ${navit_SRC_DIR})
	execute_process(COMMAND ${svn_get_src_version}  
					WORKING_DIRECTORY "${navit_SRC_DIR}"
					RESULT_VARIABLE result
					OUTPUT_VARIABLE version)
	if (${version} MATCHES ${navit_VERSION})
		message(STATUS "version of navit up to date")	
	else()
		message(STATUS "get the right version of navit")
	 	execute_process(
			COMMAND "${svn_executable}" checkout ${navit_URL} navit -r ${navit_VERSION}
			WORKING_DIRECTORY "${navit_SRC_DIR}/.."
			RESULT_VARIABLE error_code
		)
		if(error_code)
			message(FATAL_ERROR "Failed to checkout version: '${navit_VERSION}'")
		endif()	
	endif()
else()
	message(STATUS "clone navit")
	execute_process(
		COMMAND "${svn_executable}" checkout ${navit_URL} navit -r ${navit_VERSION}
		WORKING_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}"
		RESULT_VARIABLE error_code
	)
 	if(error_code)
		message(FATAL_ERROR "Failed to clone repository: '${navit_URL}'")
	endif()
endif()

# apply spell patch if necessary
if (EXISTS ${navit_PATCH_DUMMY_FILE_SPELL})
	message(STATUS "patch spell already applied to navit")
else()
	message(STATUS "apply the patch spell to navit")
	execute_process(
		COMMAND ${apply_patch_svn} -i ${navit_PATCH_SRC_DIR}/search_list_get_unique.diff
		COMMAND ${create_file} ${navit_PATCH_DUMMY_FILE_SPELL}
		TIMEOUT 0.1 #cmake -E touch never ends so add a timeout here
		WORKING_DIRECTORY "${navit_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
	if(error_code)
		message(FATAL_ERROR "Failed to apply the patch spell")
	endif()	
endif()

# apply layer manager patch if necessary
if (WITH_LM)
	if (EXISTS ${navit_PATCH_DUMMY_FILE_LM})
		message(STATUS "patch lm already applied to navit")
	else()
		message(STATUS "apply the patches to navit")
		execute_process(
			COMMAND ${apply_patch_git} -i ${navit_PATCH_SRC_DIR}/0001-add-wayland-ilm-support-navit.patch
			COMMAND ${create_file} ${navit_PATCH_DUMMY_FILE_LM}
			TIMEOUT 0.1 #cmake -E touch never ends so add a timeout here
			WORKING_DIRECTORY "${navit_SRC_DIR}"
			RESULT_VARIABLE error_code
		)
		if(error_code)
			message(FATAL_ERROR "Failed to apply the patch lm")
		endif()	
	endif()
endif()

# ..............................Get the database..............................

# Check if the map data base have been got and do it if necessary (no version checked for the moment)
set(map_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/map)
set(MAP_FILE switzerland.bin)
set(map_URL http://www.navit-project.org/${MAP_FILE})
set(wget wget -O)

if (NOT EXISTS ${map_SRC_DIR}/${MAP_FILE})
	message(STATUS "get the map")
	execute_process(
		COMMAND ${wget} "${map_SRC_DIR}/${MAP_FILE}.tmp" "${map_URL}"
		RESULT_VARIABLE error_code
	)
 	if(error_code)
		message(FATAL_ERROR "Failed to get map: '${MAP_FILE}', what about your proxy ?")
	endif()
	execute_process(
		COMMAND mv "${map_SRC_DIR}/${MAP_FILE}.tmp" ${map_SRC_DIR}/${MAP_FILE}
	)
endif()



