project(poi-manager-server)
set(PARENT_API poiservice)
set(ROOT_API navigation)
set(COMMON_API_VERSION CommonAPI-2.1)

set(CMAKE_VERBOSE_MAKEFILE off)
cmake_minimum_required(VERSION 2.8)
set(CMAKE_CXX_FLAGS "-Wall -O0 -std=c++0x")

# DBus Path
if (DBUS_LIB_PATH)
  message(STATUS "DBUS_LIB_PATH = " ${DBUS_LIB_PATH})
else()
  message(FATAL_ERROR "Please specify the path to your patched DBus library using -D DBUS_LIB_PATH=yourPath")
endif()

# CommonAPI
find_package(PkgConfig REQUIRED)
pkg_check_modules (DBUS "dbus-1 >= 1.4")
pkg_check_modules (COMMONAPI "CommonAPI >= 2.1")
pkg_check_modules (COMMONAPI_DBUS "CommonAPI-DBus >= 2.1")

# Source Files
set(PRJ_SRC_PATH .)
set(PRJ_SRC_GEN_PATH ${COMMON_API_PATH_GENERATED_FILES}/org/genivi)
FILE(GLOB PRJ_LOCAL_SRCS ${PRJ_SRC_PATH}/*.cpp)
FILE(GLOB PRJ_STUB_GEN_SRCS ${PRJ_SRC_GEN_PATH}/${ROOT_API}/${PARENT_API}/*Stub*.cpp)
FILE(GLOB PRJ_STUB_GEN_TYPES ${PRJ_SRC_GEN_PATH}/${ROOT_API}/${PARENT_API}/*Types*.cpp ${PRJ_SRC_GEN_PATH}/${ROOT_API}/*Types*.cpp)
FILE(GLOB PRJ_STUB_IMPL_SRCS ${PRJ_SRC_PATH}/*stub*.cpp)
set(PRJ_SRCS ${PRJ_LOCAL_SRCS} ${PRJ_STUB_GEN_SRCS} ${PRJ_STUB_GEN_TYPES} ${PRJ_STUB_IMPL_SRCS})

include_directories(
    ${COMMON_API_PATH_GENERATED_FILES}
    ${DBUS_INCLUDE_DIRS}
    ${COMMONAPI_INCLUDEDIR}/${COMMON_API_VERSION}
    ${COMMONAPI_DBUS_INCLUDEDIR}
)

link_directories(
    ${DBUS_LIB_PATH}
    ${COMMONAPI_LIBDIR}
    ${COMMONAPI_DBUS_LIBDIR}
)

# Build service
add_executable(${PROJECT_NAME} ${PRJ_SRCS})
target_link_libraries(${PROJECT_NAME} ${COMMONAPI_LIBRARIES} ${COMMONAPI_DBUS_LIBRARIES})
