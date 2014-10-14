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

set (svn_executable ${SVN})
set (svn_get_src_version svnversion)

set(cmake_create_dir cmake -E make_directory)

# Check if ivi layer management stuff with the right version has been cloned and do it if necessary
set(layer-management_URL http://git.projects.genivi.org/wayland-ivi-extension.git)
set(layer-management_VERSION 278437417d1ac0958a800eecfebd2a388d6d9ca7)
set(layer-management_PATCH_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/patches)
set(layer-management_PATCH_DUMMY_FILE ${layer-management_SRC_DIR}/.patched)

if (EXISTS ${layer-management_SRC_DIR})
	execute_process(	
		COMMAND ${git_get_src_version}  
		WORKING_DIRECTORY "${layer-management_SRC_DIR}"
		RESULT_VARIABLE result
		OUTPUT_VARIABLE version
	)
	if (${version} MATCHES ${layer-management_VERSION})
		message(STATUS "version of layer-management up to date")	
	else()
		message(STATUS "get the right version")
	 	execute_process(
			COMMAND "${git_executable}" pull
			COMMAND "${git_executable}" checkout ${layer-management_VERSION}
			WORKING_DIRECTORY "${layer-management_SRC_DIR}"
			RESULT_VARIABLE error_code
		)
		if(error_code)
			message(FATAL_ERROR "Failed to checkout version: '${layer-management_VERSION}'")
		endif()	
	endif()
else()
	message(STATUS "clone layer-management")
	execute_process(
		COMMAND "${git_executable}" clone "${layer-management_URL}" "${layer-management_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
 	if(error_code)
		message(FATAL_ERROR "Failed to clone repository: '${layer-management_URL}'")
	endif()
	message(STATUS "get the right version")
 	execute_process(
		COMMAND "${git_executable}" pull
		COMMAND "${git_executable}" checkout ${layer-management_VERSION}
		WORKING_DIRECTORY "${layer-management_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
	if(error_code)
		message(FATAL_ERROR "Failed to checkout version: '${layer-management_VERSION}'")
	endif()	
endif()

set (PATCH_EXECUTABLE patch -p1 -s) 
if (EXISTS ${layer-management_PATCH_DUMMY_FILE})
	message(STATUS "patch already applied")
else()
	message(STATUS "apply the patches")
	execute_process(
		COMMAND ${PATCH_EXECUTABLE} -i ${layer-management_PATCH_SRC_DIR}/0001-client.pro-Disable-create_cmake-configuration.patch
		COMMAND ${PATCH_EXECUTABLE} -i ${layer-management_PATCH_SRC_DIR}/0002-Update-ivi-application.xml-and-fix-inplementation-of.patch
		COMMAND ${create_file} ${layer-management_PATCH_DUMMY_FILE}
		TIMEOUT 0.1 #cmake -E touch never ends so add a timeout here
		WORKING_DIRECTORY "${layer-management_SRC_DIR}"
		RESULT_VARIABLE error_code
	)
	message( STATUS "Patch result: ${error_code}, PROF SOURCE DIR: ${layer-management_SRC_DIR}" )
endif()


# Check if positioning stuff with the right version has been cloned and do it if necessary
# positioning_SRC_DIR is set by cmake -Dpositioning_SRC_DIR=<path to positioning src dir> 
set(positioning_URL http://git.projects.genivi.org/lbs/positioning.git)
set(positioning_VERSION 09698f63ea27a24c533b4c015155ee9ebd7a3026)

if (EXISTS ${positioning_SRC_DIR})
	execute_process(COMMAND ${git_get_src_version}  
					WORKING_DIRECTORY "${positioning_SRC_DIR}"
					RESULT_VARIABLE result
					OUTPUT_VARIABLE version)
	if (${version} MATCHES ${positioning_VERSION})
		message(STATUS "version of positioning up to date")	
	else()
		message(STATUS "get the right version")
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

	message(STATUS "get the right version")
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

# Check if navit stuff with the right version has been cloned and do it if necessary
set(navit_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/navit)
set(navit_URL http://svn.code.sf.net/p/navit/code/trunk)
set(navit_VERSION 5532)

if (EXISTS ${navit_SRC_DIR})
	execute_process(COMMAND ${svn_get_src_version}  
					WORKING_DIRECTORY "${navit_SRC_DIR}"
					RESULT_VARIABLE result
					OUTPUT_VARIABLE version)
	if (${version} MATCHES ${navit_VERSION})
		message(STATUS "version of navit up to date")	
	else()
		message(STATUS "get the right version")
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

# Check if the map has been got and do it if necessary (no version checked for the moment)
set(map_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/map)
set(MAP_FILE switzerland.bin)
set(MAP_XML_FILE switzerland.xml)
set(map_URL http://www.navit-project.org/${MAP_FILE})
set(NAVIT_BIN_DIR ${CMAKE_CURRENT_BINARY_DIR}/navit)
set(wget wget -O)
execute_process(
	WORKING_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}"
	COMMAND ${cmake_create_dir} map
)

if (NOT EXISTS ${map_SRC_DIR}/${MAP_FILE})
	message(STATUS "get the map")
	execute_process(
		COMMAND ${wget} "${map_SRC_DIR}/${MAP_FILE}.tmp" "${map_URL}"
		COMMAND mv "${map_SRC_DIR}/${MAP_FILE}.tmp" ${map_SRC_DIR}/${MAP_FILE}
		RESULT_VARIABLE error_code
	)
 	if(error_code)
		message(FATAL_ERROR "Failed to get map: '${MAP_FILE}', what about your proxy ?")
	endif()
endif()

if (NOT EXISTS ${NAVIT_BIN_DIR}/navit/maps/${MAP_XML_FILE})
	message(STATUS "generate xml file for the map")
	file(WRITE ${NAVIT_BIN_DIR}/navit/maps/${MAP_XML_FILE} "<map type=\"binfile\" data=\"${map_SRC_DIR}/${MAP_FILE}\" />")
endif()

# Generate the DBus files used by the plugins before building the code
set(API_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../api)
execute_process(
	COMMAND ${cmake_create_dir} navit
)
execute_process(
	WORKING_DIRECTORY "${NAVIT_BIN_DIR}"
	COMMAND ${cmake_create_dir} navit
)
set(CONSTANTS_BIN_DIR ${CMAKE_CURRENT_BINARY_DIR}/constants)
execute_process(
	COMMAND ${cmake_create_dir} constants
)

# Do it for navigation-core
set(NAVIGATION_CORE_SRC ${CMAKE_CURRENT_SOURCE_DIR}/navigation-core)
set(positioning_API_DIR ${positioning_SRC}/enhanced-position-service/api)

if(NOT EXISTS ${NAVIT_BIN_DIR}/navit/navit_genivi_navigationcore.xml)
	execute_process(
		OUTPUT_FILE ${NAVIT_BIN_DIR}/navit/navit_genivi_navigationcore.xml
		COMMAND ${XSLTPROC} ${NAVIGATION_CORE_SRC}/navit_genivi_navigationcore.xsl ${navit_SRC_DIR}/navit/navit/navit_shipped.xml        
	)
else()
	if(${NAVIGATION_CORE_SRC}/navit_genivi_navigationcore.xsl IS_NEWER_THAN ${NAVIT_BIN_DIR}/navit/navit_genivi_navigationcore.xml)
		execute_process(
			OUTPUT_FILE ${NAVIT_BIN_DIR}/navit/navit_genivi_navigationcore.xml
			COMMAND ${XSLTPROC} ${NAVIGATION_CORE_SRC}/navit_genivi_navigationcore.xsl ${navit_SRC_DIR}/navit/navit/navit_shipped.xml        
		)
	endif()
endif()

file (GLOB XML_TO_DBUS_CONSTANT
	${API_DIR}/navigation-core/genivi-navigationcore-constants.xml
)
foreach (RAW_FILE ${XML_TO_DBUS_CONSTANT})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${CONSTANTS_BIN_DIR}/${FILE}.h)
		execute_process(
			OUTPUT_FILE ${CONSTANTS_BIN_DIR}/${FILE}.h
			COMMAND ${XSLTPROC} ${API_DIR}/navigation-core/enum.xsl ${RAW_FILE}        
		)
	else()
		if(${RAW_FILE} IS_NEWER_THAN ${CONSTANTS_BIN_DIR}/${FILE}.h)
			execute_process(
				OUTPUT_FILE ${CONSTANTS_BIN_DIR}/${FILE}.h
				COMMAND ${XSLTPROC} ${API_DIR}/navigation-core/enum.xsl ${RAW_FILE}        
			)
		endif()
	endif()
endforeach()

file (GLOB XML_TO_DBUS_CONSTANT_FROM_POSITIONING
	${positioning_SRC_DIR}/enhanced-position-service/api/genivi-positioning-constants.xml
)
foreach (RAW_FILE ${XML_TO_DBUS_CONSTANT_FROM_POSITIONING})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${CONSTANTS_BIN_DIR}/${FILE}.h)
		execute_process(
			OUTPUT_FILE ${CONSTANTS_BIN_DIR}/${FILE}.h
			COMMAND ${XSLTPROC} ${API_DIR}/navigation-core/enum.xsl ${RAW_FILE}   
		)
	else()
		if(${RAW_FILE} IS_NEWER_THAN ${CONSTANTS_BIN_DIR}/${FILE}.h)
			execute_process(
				OUTPUT_FILE ${CONSTANTS_BIN_DIR}/${FILE}.h
				COMMAND ${XSLTPROC} ${API_DIR}/navigation-core/enum.xsl ${RAW_FILE}   
			)
		endif()
	endif()
endforeach()

# Do it for map-viewer
set(MAP_VIEWER_SRC ${CMAKE_CURRENT_SOURCE_DIR}/map-viewer)

if(NOT EXISTS ${NAVIT_BIN_DIR}/navit/navit_genivi_mapviewer.xml)
	execute_process(
		OUTPUT_FILE ${NAVIT_BIN_DIR}/navit/navit_genivi_mapviewer.xml
		COMMAND ${XSLTPROC} ${MAP_VIEWER_SRC}/navit_genivi_mapviewer.xsl ${navit_SRC_DIR}/navit/navit/navit_shipped.xml        
	)
else()
	if(${MAP_VIEWER_SRC}/navit_genivi_mapviewer.xsl IS_NEWER_THAN ${NAVIT_BIN_DIR}/navit/navit_genivi_mapviewer.xml)
		execute_process(
			OUTPUT_FILE ${NAVIT_BIN_DIR}/navit/navit_genivi_mapviewer.xml
			COMMAND ${XSLTPROC} ${MAP_VIEWER_SRC}/navit_genivi_mapviewer.xsl ${navit_SRC_DIR}/navit/navit/navit_shipped.xml        
		)
	endif()
endif()

file (GLOB XML_TO_DBUS_CONSTANT
	${API_DIR}/map-viewer/genivi-mapviewer-constants.xml
)
foreach (RAW_FILE ${XML_TO_DBUS_CONSTANT})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${CONSTANTS_BIN_DIR}/${FILE}.h)
		execute_process(
			OUTPUT_FILE ${CONSTANTS_BIN_DIR}/${FILE}.h
			COMMAND ${XSLTPROC} ${API_DIR}/map-viewer/enum.xsl ${RAW_FILE}        
		)
	else()
		if(${RAW_FILE} IS_NEWER_THAN ${CONSTANTS_BIN_DIR}/${FILE}.h)
			execute_process(
				OUTPUT_FILE ${CONSTANTS_BIN_DIR}/${FILE}.h
				COMMAND ${XSLTPROC} ${API_DIR}/map-viewer/enum.xsl ${RAW_FILE}        
			)
		endif()
	endif()
endforeach()

# Do it for poi-service
file (GLOB XML_TO_DBUS_CONSTANT
	${API_DIR}/poi-service/genivi-poiservice-constants.xml
)
foreach (RAW_FILE ${XML_TO_DBUS_CONSTANT})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${CONSTANTS_BIN_DIR}/${FILE}.h)
		execute_process(
			OUTPUT_FILE ${CONSTANTS_BIN_DIR}/${FILE}.h
			COMMAND ${XSLTPROC} ${API_DIR}/poi-service/enum.xsl ${RAW_FILE}        
		)
	else()
		if(${RAW_FILE} IS_NEWER_THAN ${CONSTANTS_BIN_DIR}/${FILE}.h)
			execute_process(
				OUTPUT_FILE ${CONSTANTS_BIN_DIR}/${FILE}.h
				COMMAND ${XSLTPROC} ${API_DIR}/poi-service/enum.xsl ${RAW_FILE}        
			)
		endif()
	endif()
endforeach()
