###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-server-capi
#
# Author: Philippe Colliot
#
# Copyright (C) 2015, PCA Peugeot Citroën
#
# License:
# This Source Code Form is subject to the terms of the
# Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
# @licence end@
###########################################################################
project(poi-server)
cmake_minimum_required(VERSION 2.8)

message(STATUS ${PROJECT_NAME})

set(CMAKE_VERBOSE_MAKEFILE on)
set(CMAKE_CXX_FLAGS "-Wall -std=c++0x")

set(API_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../../api")
set(FRANCA_DIR "${API_DIR}/franca")
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/lib)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/bin)
set(COMMON_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../poi-common")

# DBus Path
if(DBUS_LIB_PATH)
  message(STATUS "DBUS_LIB_PATH = " ${DBUS_LIB_PATH})
  set(DBUS_INCLUDE_DIRS ${DBUS_LIB_PATH}/include/dbus-1.0 ${DBUS_LIB_PATH}/lib/dbus-1.0/include)
  set(DBUS_LIBDIR ${DBUS_LIB_PATH}/lib)
  set(DBUS_LIBRARIES ${DBUS_LIB_PATH}/lib/libdbus-1.so)
else()
  message(FATAL_ERROR "Please specify the path to your patched DBus library using -DDBUS_LIB_PATH=yourPath")
endif()

# Packages
find_package(PkgConfig REQUIRED)
find_package(CommonAPI 3.1.5 REQUIRED)
find_package(CommonAPI-DBus 3.1.5 REQUIRED)

#pkg_check_modules(DBUS "dbus-1 >= 1.8.4") // #to be fixed, it doesn't work so the paths are set manually (see above)
pkg_check_modules(COMMONAPI "CommonAPI >= 3.1.5")
pkg_check_modules(COMMONAPI_DBUS "CommonAPI-DBus >= 3.1.5")
pkg_check_modules(SQLITE3 REQUIRED sqlite3)
pkg_check_modules(GOBJECT gobject-2.0)
pkg_check_modules(GLIB REQUIRED glib-2.0)
pkg_check_modules(DBUS_CPP_GLIB dbus-c++-glib-1)

# Add the Franca files (that will generate the CommonAPI stuff)
set(COMMONAPI_GEN_DIR "${CMAKE_CURRENT_BINARY_DIR}/src-gen")
add_subdirectory(${FRANCA_DIR}/navigation "${CMAKE_CURRENT_BINARY_DIR}/franca")

# Path to the generated files
set(API_VERSION_NAVIGATION_MAJOR 4)
set(API_VERSION_NAVIGATION "v${API_VERSION_NAVIGATION_MAJOR}")
set(API_VERSION_POISERVICE_MAJOR 2)
set(API_VERSION_POISERVICE "v${API_VERSION_POISERVICE_MAJOR}")
set(PRJ_SRC_GEN_COMMON_PATH ${COMMONAPI_GEN_DIR}/${API_VERSION_NAVIGATION}/org/genivi) #files shared by all the APIs
set(PRJ_SRC_GEN_NAVIGATION_PATH ${COMMONAPI_GEN_DIR}/${API_VERSION_NAVIGATION}/org/genivi/navigation) #files shared by the navigation APIs
set(PRJ_SRC_GEN_NAVIGATIONCORE_PATH ${PRJ_SRC_GEN_NAVIGATION_PATH}/navigationcore) #files shared by the navigationcore APIs
set(PRJ_SRC_GEN_POISERVICE_PATH ${COMMONAPI_GEN_DIR}/${API_VERSION_POISERVICE}/org/genivi/navigation/poiservice) #files shared by the poiservice APIs

# Source Files
FILE(GLOB PRJ_LOCAL_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/*.cpp)
FILE(GLOB PRJ_COMMON_SRCS ${COMMON_DIR}/poi-common-database.cpp ${COMMON_DIR}/poi-common-math.cpp)
FILE(GLOB PRJ_STUB_GEN_SRCS
    ${PRJ_SRC_GEN_COMMON_PATH}/*DBusStub*.cpp ${PRJ_SRC_GEN_COMMON_PATH}/*Types.cpp ${PRJ_SRC_GEN_COMMON_PATH}/*DBusDeployment.cpp ${PRJ_SRC_GEN_COMMON_PATH}/*StubDefault.cpp
    ${PRJ_SRC_GEN_NAVIGATION_PATH}/*DBusStub*.cpp ${PRJ_SRC_GEN_NAVIGATION_PATH}/*Types.cpp ${PRJ_SRC_GEN_NAVIGATION_PATH}/*DBusDeployment.cpp ${PRJ_SRC_GEN_NAVIGATION_PATH}/*StubDefault.cpp
    ${PRJ_SRC_GEN_POISERVICE_PATH}/*DBusStub*.cpp ${PRJ_SRC_GEN_POISERVICE_PATH}/*Types.cpp ${PRJ_SRC_GEN_POISERVICE_PATH}/*DBusDeployment.cpp ${PRJ_SRC_GEN_POISERVICE_PATH}/*StubDefault.cpp
    )
FILE(GLOB PRJ_STUB_IMPL_SRCS
    ${PRJ_SRC_GEN_COMMON_PATH}/*Stub*.cpp
    ${PRJ_SRC_GEN_NAVIGATION_PATH}/*Stub*.cpp
    ${PRJ_SRC_GEN_POISERVICE_PATH}/*Stub*.cpp
    )
FILE(GLOB PRJ_PROXY_GEN_SRCS
    ${PRJ_SRC_GEN_COMMON_PATH}/*DBusProxy.cpp ${PRJ_SRC_GEN_COMMON_PATH}/*Types.cpp ${PRJ_SRC_GEN_COMMON_PATH}/*DBusDeployment.cpp
    ${PRJ_SRC_GEN_NAVIGATION_PATH}/*DBusProxy.cpp ${PRJ_SRC_GEN_NAVIGATION_PATH}/*Types.cpp ${PRJ_SRC_GEN_NAVIGATION_PATH}/*DBusDeployment.cpp
    ${PRJ_SRC_GEN_NAVIGATIONCORE_PATH}/*DBusProxy.cpp ${PRJ_SRC_GEN_NAVIGATIONCORE_PATH}/*Types.cpp ${PRJ_SRC_GEN_NAVIGATIONCORE_PATH}/*DBusDeployment.cpp
    ${PRJ_SRC_GEN_POISERVICE_PATH}/*DBusProxy.cpp ${PRJ_SRC_GEN_POISERVICE_PATH}/*Types.cpp ${PRJ_SRC_GEN_POISERVICE_PATH}/*DBusDeployment.cpp
    )

set(PRJ_SRCS ${PRJ_LOCAL_SRCS} ${PRJ_COMMON_SRCS} ${PRJ_STUB_GEN_SRCS} ${PRJ_PROXY_GEN_SRCS} ${PRJ_STUB_IMPL_SRCS})

include_directories(
    ${COMMON_DIR}
    ${COMMONAPI_GEN_DIR}
    ${PRJ_SRC_GEN_COMMON_PATH}
    ${PRJ_SRC_GEN_NAVIGATION_PATH}
    ${PRJ_SRC_GEN_NAVIGATIONCORE_PATH}
    ${PRJ_SRC_GEN_POISERVICE_PATH}
    ${DBUS_INCLUDE_DIRS}
    ${COMMONAPI_INCLUDE_DIRS}
    ${COMMONAPI_DBUS_INCLUDE_DIRS}
    ${GOBJECT_INCLUDE_DIRS}
    ${GLIB_INCLUDE_DIRS}
    ${DBUS_CPP_GLIB_INCLUDE_DIRS}
    ${SQLITE3_INCLUDE_DIRS}
)

link_directories(
    ${DBUS_LIBDIR}
    ${COMMONAPI_LIBDIR}
    ${COMMONAPI_DBUS_LIBDIR}
    ${GOBJECT_LIBRARY_DIRS}
    ${GLIB_LIBRARY_DIRS}
    ${DBUS_CPP_GLIB_DIRS}
    ${SQLITE3_LIBRARY_DIRS}
)

set(LIBRARIES
    ${DBUS_LIBRARIES}
    ${COMMONAPI_LIBRARIES}
    ${COMMONAPI_DBUS_LIBRARIES}
    ${GOBJECT_LIBRARIES}
    ${GLIB_LIBRARIES}
    ${DBUS_CPP_GLIB_LIBRARIES}
    ${SQLITE3_LIBRARIES}
)

# Build service
add_executable(${PROJECT_NAME} ${PRJ_SRCS})
target_link_libraries(${PROJECT_NAME} ${LIBRARIES})
install(TARGETS ${PROJECT_NAME} DESTINATION ${CMAKE_RUNTIME_OUTPUT_DIRECTORY})
