###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-client
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
project(poi-client)
cmake_minimum_required(VERSION 2.8)

message(STATUS "poi-client")

find_package(PkgConfig REQUIRED)
find_program(XSLTPROC xsltproc REQUIRED)
find_program(QTUIC uic REQUIRED)
find_program(QTMOC moc REQUIRED)
find_program(QTLRELEASE lrelease REQUIRED)
find_program(QTRCC rcc REQUIRED)

pkg_check_modules(QT5_CORE REQUIRED Qt5Core)
pkg_check_modules(QT5_DBUS REQUIRED Qt5DBus)
pkg_check_modules(QT5_WIDGETS REQUIRED Qt5Widgets)
pkg_check_modules(QT5_GUI REQUIRED Qt5Gui)

include_directories(${CMAKE_CURRENT_BINARY_DIR})
include_directories(${QT5_CORE_INCLUDE_DIRS})
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
set(qt_rcc ${QTRCC} -binary)

set(API_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../api)
set(TARGET_GENERATED_API_DIR ${API_DIR}/include)

file(GLOB DBUS_DEF_INCLUDE ${TARGET_GENERATED_API_DIR}/*-constants.h)

link_directories(
	${QT5_CORE_LIBRARY_DIRS}
	${QT5_DBUS_LIBRARY_DIRS}
	${QT5_WIDGETS_LIBRARY_DIRS}
	${QT5_GUI_LIBRARY_DIRS}
)

set(LIBRARIES 
    ${QT5_CORE_LIBRARIES}
    ${QT5_DBUS_LIBRARIES}
    ${QT5_WIDGETS_LIBRARIES}
    ${QT5_GUI_LIBRARIES}
)

# for some reason, automoc doesn't run, so moc is made manually
file (GLOB SRC_TO_MOC ${CMAKE_CURRENT_SOURCE_DIR}/mainwindow.h
	${CMAKE_CURRENT_SOURCE_DIR}/about-dialog.h
    ${CMAKE_CURRENT_SOURCE_DIR}/poi-client-DBusSearchInterface.h 
    ${CMAKE_CURRENT_SOURCE_DIR}/poi-client-DBusRoutingInterface.h 
    ${CMAKE_CURRENT_SOURCE_DIR}/poi-client-DBusGuidanceInterface.h 
    ${CMAKE_CURRENT_SOURCE_DIR}/poi-client-DBusEnhancedPositionInterface.h 
    ${CMAKE_CURRENT_SOURCE_DIR}/poi-client-DBusNavigationCoreSessionInterface.h 
    ${CMAKE_CURRENT_SOURCE_DIR}/poi-client-DBusContentAccessInterface.h 
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
					  ${CMAKE_CURRENT_SOURCE_DIR}/about-dialog.ui
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
file (GLOB TS_TO_RELEASE ${COMMON_DIR}/poi-client_en.ts
	${COMMON_DIR}/poi-client_jp.ts
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

add_executable(poi-client
    ${MOC_SOURCES}
    ${DBUS_DEF_INCLUDE}
    ${UI_FILES}
    main.cpp
    mainwindow.cpp
    about-dialog.cpp
    poi-client-DBusSearchInterface.cpp
    poi-client-DBusRoutingInterface.cpp
    poi-client-DBusGuidanceInterface.cpp
    poi-client-DBusEnhancedPositionInterface.cpp
    poi-client-DBusNavigationCoreSessionInterface.cpp
    poi-client-DBusContentAccessInterface.cpp
    ../poi-common/poi-marshal-handler.cpp
    mainwindow.h
    poi-client-config.h
    about-dialog.h
    poi-client-DBusSearchInterface.h
    poi-client-DBusRoutingInterface.h
    poi-client-DBusGuidanceInterface.h
    poi-client-DBusEnhancedPositionInterface.h
    poi-client-DBusNavigationCoreSessionInterface.h
    poi-client-DBusContentAccessInterface.h
    ../poi-common/poi-marshal-handler.h
)

target_link_libraries(poi-client ${LIBRARIES})


