###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-contentaccess-module
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
project(poi-contentaccess-module)
cmake_minimum_required(VERSION 2.8)

message(STATUS "poi-contentaccess-module")

find_package(PkgConfig REQUIRED)
find_program(XSLTPROC xsltproc REQUIRED)
find_program(DBUSXML2CPP dbusxx-xml2cpp REQUIRED)
find_program(QTUIC uic REQUIRED)
find_program(QTMOC moc REQUIRED)
find_program(QTLRELEASE lrelease REQUIRED)
find_program(QTRCC rcc REQUIRED)

pkg_check_modules(DBUS_CPP dbus-c++-1)
pkg_check_modules(GLIB REQUIRED glib-2.0)
pkg_check_modules(SQLITE3 REQUIRED sqlite3)
pkg_check_modules(GLIBMM glibmm-2.4)
pkg_check_modules(GOBJECT gobject-2.0)
pkg_check_modules(DBUS dbus-1)
pkg_check_modules(DBUS_CPP_GLIB dbus-c++-glib-1)
pkg_check_modules(QT5_CORE REQUIRED Qt5Core)
pkg_check_modules(QT5_QUICK REQUIRED Qt5Quick)
pkg_check_modules(QT5_DBUS REQUIRED Qt5DBus)
pkg_check_modules(QT5_WIDGETS REQUIRED Qt5Widgets)
pkg_check_modules(QT5_GUI REQUIRED Qt5Gui)

include_directories(${CMAKE_CURRENT_BINARY_DIR})
include_directories(${DBUS_CPP_INCLUDE_DIRS})
include_directories(${GLIB_INCLUDE_DIRS})
include_directories(${SQLITE3_INCLUDE_DIRS})
include_directories(${GLIBMM_INCLUDE_DIRS})
include_directories(${GOBJECT_INCLUDE_DIRS})
include_directories(${DBUS_INCLUDE_DIRS})
include_directories(${DBUS_CPP_GLIB_INCLUDE_DIRS})
include_directories(${QT5_CORE_INCLUDE_DIRS})
include_directories(${QT5_QUICK_INCLUDE_DIRS})
include_directories(${QT5_DBUS_INCLUDE_DIRS})
include_directories(${QT5_WIDGETS_INCLUDE_DIRS})
include_directories(${QT5_GUI_INCLUDE_DIRS})

set(cmake_create_dir cmake -E make_directory)

#settings for Qt
set(CMAKE_XXX_FLAGS "${CMAKE_XXX_FLAGS} ${QT5_EXECUTABLE_COMPILE_FLAGS}")
set(CMAKE_POSITION_INDEPENDENT_CODE ON)
set(CMAKE_INCLUDE_CURRENT_DIR ON)
add_definitions(${QT5_CORE_DEFINITIONS})
add_definitions(-DQT_PLUGIN)
add_definitions(-DQT_NO_DEBUG)
set(qt_moc ${QTMOC} -o)
set(MOC moc)
set(MOC_DIR ${CMAKE_CURRENT_BINARY_DIR}/${MOC})
set(qt_uic ${QTUIC} -o)
set(qt_release ${QTLRELEASE})
set(qt_rcc ${QTRCC})

set(positioning_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../src/poi-service/positioning)
if (NOT IS_DIRECTORY ${positioning_SRC_DIR})
  message(FATAL_ERROR "positioning has not been cloned before")
endif()

# Generate the DBus adaptors and proxy before building the client
set(API_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../api)
set(TARGET_GENERATED_API_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../poi-common)
set(positioning_API_DIR ${positioning_SRC}/enhanced-position-service/api)

file (GLOB XML_TO_DBUS_PROXY 
	${API_DIR}/poi-service/genivi-poiservice-poisearch.xml
	${API_DIR}/poi-service/genivi-poiservice-poicontentaccess.xml
	${API_DIR}/poi-service/genivi-poiservice-contentaccessmodule.xml
	${positioning_SRC_DIR}/enhanced-position-service/api/genivi-positioning-enhancedposition.xml
	${API_DIR}/navigation-core/genivi-navigationcore-routing.xml
	${API_DIR}/navigation-core/genivi-navigationcore-guidance.xml
)
foreach (RAW_FILE ${XML_TO_DBUS_PROXY})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${TARGET_GENERATED_API_DIR}/${FILE}_proxy.h)
		execute_process(
			COMMAND ${DBUSXML2CPP} ${RAW_FILE} --proxy=${TARGET_GENERATED_API_DIR}/${FILE}_proxy.h  
		)
	else()
		if(${RAW_FILE} IS_NEWER_THAN ${TARGET_GENERATED_API_DIR}/${FILE}_proxy.h)
			execute_process(
				COMMAND ${DBUSXML2CPP} ${RAW_FILE} --proxy=${TARGET_GENERATED_API_DIR}/${FILE}_proxy.h  
			)
		endif()
	endif()
endforeach()

file (GLOB XML_TO_DBUS_ADAPTOR
	${API_DIR}/poi-service/genivi-poiservice-poisearch.xml
	${API_DIR}/poi-service/genivi-poiservice-poicontentaccess.xml
	${API_DIR}/poi-service/genivi-poiservice-contentaccessmodule.xml
	${positioning_SRC_DIR}/enhanced-position-service/api/genivi-positioning-enhancedposition.xml
	${API_DIR}/navigation-core/genivi-navigationcore-routing.xml
	${API_DIR}/navigation-core/genivi-navigationcore-guidance.xml
)
foreach (RAW_FILE ${XML_TO_DBUS_ADAPTOR})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${TARGET_GENERATED_API_DIR}/${FILE}_adaptor.h)
		execute_process(
			COMMAND ${DBUSXML2CPP} ${RAW_FILE} --adaptor=${TARGET_GENERATED_API_DIR}/${FILE}_adaptor.h  
		)
	else()
		if(${RAW_FILE} IS_NEWER_THAN ${TARGET_GENERATED_API_DIR}/${FILE}_adaptor.h)
			execute_process(
				COMMAND ${DBUSXML2CPP} ${RAW_FILE} --adaptor=${TARGET_GENERATED_API_DIR}/${FILE}_adaptor.h  
			)
		endif()
	endif()
endforeach()

file (GLOB XML_TO_DBUS_CONSTANT
	${API_DIR}/poi-service/genivi-poiservice-constants.xml
	${API_DIR}/map-viewer/genivi-mapviewer-constants.xml
	${API_DIR}/navigation-core/genivi-navigationcore-constants.xml
)
foreach (RAW_FILE ${XML_TO_DBUS_CONSTANT})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${TARGET_GENERATED_API_DIR}/${FILE}.h)
		execute_process(
			OUTPUT_FILE ${TARGET_GENERATED_API_DIR}/${FILE}.h
			COMMAND ${XSLTPROC} ${API_DIR}/poi-service/enum.xsl ${RAW_FILE}        
		)
	else()
		if(${RAW_FILE} IS_NEWER_THAN ${TARGET_GENERATED_API_DIR}/${FILE}.h)
			execute_process(
				OUTPUT_FILE ${TARGET_GENERATED_API_DIR}/${FILE}.h
				COMMAND ${XSLTPROC} ${API_DIR}/poi-service/enum.xsl ${RAW_FILE}        
			)
		endif()
	endif()
endforeach()

file (GLOB XML_TO_DBUS_CONSTANT_FROM_POSITIONING
	${positioning_SRC_DIR}/enhanced-position-service/api/genivi-positioning-constants.xml
)
foreach (RAW_FILE ${XML_TO_DBUS_CONSTANT_FROM_POSITIONING})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${TARGET_GENERATED_API_DIR}/${FILE}.h)
		execute_process(
			OUTPUT_FILE ${TARGET_GENERATED_API_DIR}/${FILE}.h
			COMMAND ${XSLTPROC} ${API_DIR}/poi-service/enum.xsl ${RAW_FILE}   
		)
	else()
		if(${RAW_FILE} IS_NEWER_THAN ${TARGET_GENERATED_API_DIR}/${FILE}.h)
			execute_process(
				OUTPUT_FILE ${TARGET_GENERATED_API_DIR}/${FILE}.h
				COMMAND ${XSLTPROC} ${API_DIR}/poi-service/enum.xsl ${RAW_FILE}   
			)
		endif()
	endif()
endforeach()

file(GLOB DBUS_DEF_INCLUDE ${DBUS_DEF_DIR}/*_proxy.h ${DBUS_DEF_DIR}/*_adaptor.h ${DBUS_DEF_DIR}/*-constants.h)

link_directories(
    ${DBUS_CPP_LIBRARY_DIRS}
    ${GLIB_LIBRARY_DIRS}
	${SQLITE3_LIBRARY_DIRS}
	${GLIBMM_LIBRARY_DIRS}
	${GOBJECT_LIBRARY_DIRS}
	${DBUS_LIBRARY_DIRS}
	${DBUS_CPP_GLIB_DIRS}
	${QT5_CORE_LIBRARY_DIRS}
	${QT5_QUICK_LIBRARY_DIRS}
	${QT5_DBUS_LIBRARY_DIRS}
	${QT5_WIDGETS_LIBRARY_DIRS}
	${QT5_GUI_LIBRARY_DIRS}
)

set(LIBRARIES 
    ${DBUS_CPP_LIBRARIES}
    ${GLIB_LIBRARIES}
	${SQLITE3_LIBRARIES}
	${GLIBMM_LIBRARIES}
	${GOBJECT_LIBRARIES}
	${DBUS_LIBRARIES}
	${DBUS_CPP_GLIB_LIBRARIES}
    ${QT5_CORE_LIBRARIES}
    ${QT5_QUICK_LIBRARIES}
    ${QT5_DBUS_LIBRARIES}
    ${QT5_WIDGETS_LIBRARIES}
    ${QT5_GUI_LIBRARIES}
)

# for some reason, automoc doesn't run, so moc is made manually
file (GLOB SRC_TO_MOC ${CMAKE_CURRENT_SOURCE_DIR}/mainwindow.h
)
execute_process(
	COMMAND ${cmake_create_dir} ${MOC}
)
foreach (RAW_FILE ${SRC_TO_MOC})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${MOC_DIR}/moc_${FILE}.cpp)
		execute_process(
			COMMAND ${qt_moc} "${MOC_DIR}/moc_${FILE}.cpp" ${RAW_FILE} 
		)
	else()
		if(${RAW_FILE} IS_NEWER_THAN ${MOC_DIR}/moc_${FILE}.cpp)
			execute_process(
				COMMAND ${qt_moc} "${MOC_DIR}/moc_${FILE}.cpp" ${RAW_FILE} 
			)
		endif()
	endif()
endforeach()
file(GLOB MOC_SOURCES ${MOC_DIR}/moc_*.cpp)

#generate ui files
file (GLOB DEF_TO_UIC ${CMAKE_CURRENT_SOURCE_DIR}/mainwindow.ui
)

foreach (RAW_FILE ${DEF_TO_UIC})
	get_filename_component(FILE ${RAW_FILE} NAME_WE)
	if(NOT EXISTS ${CMAKE_CURRENT_BINARY_DIR}/ui_${FILE}.h)
		execute_process(
			COMMAND ${qt_uic} "${CMAKE_CURRENT_BINARY_DIR}/ui_${FILE}.h" ${RAW_FILE} 
		)
	else()
		if(${RAW_FILE} IS_NEWER_THAN ${CMAKE_CURRENT_BINARY_DIR}/ui_${FILE}.h)
			execute_process(
				COMMAND ${qt_uic} "${CMAKE_CURRENT_BINARY_DIR}/ui_${FILE}.h" ${RAW_FILE} 
			)
		endif()
	endif()
endforeach()
file(GLOB UI_FILES ${CMAKE_CURRENT_BINARY_DIR}/ui_*.h)

#generate qm files
set(COMMON_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../poi-common)
file (GLOB TS_TO_RELEASE ${COMMON_DIR}/poi-contentaccess-module_en.ts
        ${COMMON_DIR}/poi-contentaccess-module_jp.ts
)

foreach (RAW_FILE ${TS_TO_RELEASE})
    get_filename_component(FILE ${RAW_FILE} NAME_WE)
    if(NOT EXISTS ${COMMON_DIR}/${FILE}.qm)
        execute_process(
                OUTPUT_FILE ${COMMON_DIR}/${FILE}.qm
                COMMAND ${qt_release} ${RAW_FILE}
        )
    else()
        if(${RAW_FILE} IS_NEWER_THAN ${COMMON_DIR}/${FILE}.qm)
            execute_process(
                    OUTPUT_FILE ${COMMON_DIR}/${FILE}.qm
                    COMMAND ${qt_release} ${RAW_FILE}
            )
        endif()
    endif()
endforeach()

#generate resource file
get_filename_component(FILE ${COMMON_DIR}/poi-resource.qrc NAME_WE)
if(NOT EXISTS ${CMAKE_CURRENT_BINARY_DIR}/../${FILE}.rcc)
    execute_process(
        OUTPUT_FILE ${CMAKE_CURRENT_BINARY_DIR}/../${FILE}.rcc
        COMMAND ${qt_rcc} ${COMMON_DIR}/poi-resource.qrc
    )
else()
    if(${COMMON_DIR}/poi-resource.qrc IS_NEWER_THAN ${CMAKE_CURRENT_BINARY_DIR}/../${FILE}.rcc)
        execute_process(
            OUTPUT_FILE ${CMAKE_CURRENT_BINARY_DIR}/../${FILE}.rcc
            COMMAND ${qt_rcc} ${COMMON_DIR}/poi-resource.qrc
        )
    endif()
endif()

add_executable(poi-contentaccess-module
    ${MOC_SOURCES}
    ${DBUS_DEF_INCLUDE}
    ${UI_FILES}
    main.cpp
    database.cpp
    mainwindow.cpp
)

target_link_libraries(poi-contentaccess-module ${LIBRARIES})


