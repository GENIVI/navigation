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

set(cmake_create_dir cmake -E make_directory)

#settings for Qt
set(CMAKE_CXX_FLAGS ${CMAKE_CXX_FLAGS} ${QT5_EXECUTABLE_COMPILE_FLAGS})
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

#common files shared with poi server
file(GLOB PRJ_COMMON_SRCS ${COMMON_DIR_POI_SERVER}/*.cpp)

# for some reason, automoc doesn't run, so moc is made manually
file(GLOB SRC_TO_MOC ${CMAKE_CURRENT_SOURCE_DIR}/mainwindow.h
)

execute_process(
	WORKING_DIRECTORY "${CMAKE_CURRENT_BINARY_DIR}"
	COMMAND ${cmake_create_dir} ${MOC}
)

foreach(RAW_FILE ${SRC_TO_MOC})
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
file(GLOB DEF_TO_UIC ${CMAKE_CURRENT_SOURCE_DIR}/mainwindow.ui
)
foreach(RAW_FILE ${DEF_TO_UIC})
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
file(GLOB TS_TO_RELEASE
    ${COMMON_DIR}/poi-contentaccess-module_en.ts
    ${COMMON_DIR}/poi-contentaccess-module_jp.ts
)
foreach(RAW_FILE ${TS_TO_RELEASE})
    get_filename_component(FILE ${RAW_FILE} NAME_WE)
    if(NOT EXISTS ${CMAKE_CURRENT_BINARY_DIR}/${FILE}.qm)
        execute_process(
            COMMAND ${qt_release} ${RAW_FILE} -qm ${CMAKE_CURRENT_BINARY_DIR}/${FILE}.qm
        )
    else()
        if(${RAW_FILE} IS_NEWER_THAN ${CMAKE_CURRENT_BINARY_DIR}/${FILE}.qm)
            execute_process(
                COMMAND ${qt_release} ${RAW_FILE} -qm ${CMAKE_CURRENT_BINARY_DIR}/${FILE}.qm
            )
        endif()
    endif()
endforeach()

#generate resource file
get_filename_component(FILE ${COMMON_DIR}/poi-cam-resource.qrc NAME_WE)
if(NOT EXISTS ${CMAKE_CURRENT_BINARY_DIR}/${FILE}.rcc)
    execute_process(
        OUTPUT_FILE ${CMAKE_CURRENT_BINARY_DIR}/${FILE}.rcc
        COMMAND ${qt_rcc} ${COMMON_DIR}/poi-cam-resource.qrc
    )
else()
    if(${COMMON_DIR}/poi-cam-resource.qrc IS_NEWER_THAN ${CMAKE_CURRENT_BINARY_DIR}/${FILE}.rcc)
        execute_process(
            OUTPUT_FILE ${CMAKE_CURRENT_BINARY_DIR}/${FILE}.rcc
            COMMAND ${qt_rcc} ${COMMON_DIR}/poi-cam-resource.qrc
        )
    endif()
endif()

include_directories(
    ${CMAKE_CURRENT_SOURCE_DIR}
    ${COMMON_DIR}
    ${COMMON_DIR_POI_SERVER}
    ${CMAKE_CURRENT_BINARY_DIR}
    ${DBUS_GENERATED_INCLUDE_DIR}/navigation-core
    ${DBUS_GENERATED_INCLUDE_DIR}/map-viewer
    ${DBUS_GENERATED_INCLUDE_DIR}/poi-service
    ${DBUS_CPP_INCLUDE_DIRS}
    ${GLIB_INCLUDE_DIRS}
    ${SQLITE3_INCLUDE_DIRS}
    ${GLIBMM_INCLUDE_DIRS}
    ${GOBJECT_INCLUDE_DIRS}
    ${DBUS_INCLUDE_DIRS}
    ${DBUS_CPP_GLIB_INCLUDE_DIRS}
    ${QT5_CORE_INCLUDE_DIRS}
    ${QT5_QUICK_INCLUDE_DIRS}
    ${QT5_DBUS_INCLUDE_DIRS}
    ${QT5_WIDGETS_INCLUDE_DIRS}
    ${QT5_GUI_INCLUDE_DIRS}
)

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

add_executable(poi-contentaccess-module
    ${MOC_SOURCES}
    ${UI_FILES}
    main.cpp
    mainwindow.cpp
    ${PRJ_COMMON_SRCS}
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

target_link_libraries(poi-contentaccess-module ${LIBRARIES})

install(TARGETS poi-contentaccess-module DESTINATION ${CMAKE_RUNTIME_OUTPUT_DIRECTORY})

file(GLOB FILES_TO_INSTALL "${CMAKE_CURRENT_BINARY_DIR}/*.qm" "${CMAKE_CURRENT_BINARY_DIR}/*.rcc")

foreach(RAW_FILE ${FILES_TO_INSTALL})
    add_custom_command(TARGET poi-contentaccess-module
                       POST_BUILD
                       COMMAND cp ${RAW_FILE} ${CMAKE_RUNTIME_OUTPUT_DIRECTORY}
    )
endforeach()
