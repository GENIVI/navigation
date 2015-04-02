#!/bin/bash

###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: navigation
# Author: Philippe Colliot <philippe.colliot@mpsa.com>
#
# Copyright (C) 2013-2014, PCA Peugeot Citroen
# 
# License:
# This Source Code Form is subject to the terms of the
# Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
# @licence end@
###########################################################################

NAVIGATION_CORE=navigation-core
MAP_VIEWER=map-viewer
POI_SERVICE=poi-service
POI_CAM=poi-cam
NAVIGATION_CORE_CONFIGURATION=navigationcore-configuration
NAVIGATION_CORE_GUIDANCE=navigationcore-guidance
NAVIGATION_CORE_LOCATIONINPUT=navigationcore-locationinput
NAVIGATION_CORE_MAPMATCHEDPOSITION=navigationcore-mapmatchedposition
NAVIGATION_CORE_ROUTING=navigationcore-routing
NAVIGATION_CORE_SESSION=navigationcore-session
NAVIGATION_CORE_ENHANCEDPOSITION=navigationcore-enhancedposition
MAP_VIEWER_CONFIGURATION=mapviewer-configuration
MAP_VIEWER_MAPVIEWERCONTROL=mapviewer-mapviewercontrol
MAP_VIEWER_SESSION=mapviewer-session
POSITIONING=positioning
LOG_REPLAYER=log-replayer
GNSS_SERVICE=gnss-service
SENSORS_SERVICE=sensors-service
ENHANCED_POSITION_SERVICE=enhanced-position-service
NAVIT=navit
IVI_LAYER_MANAGER=ilm
WAYLAND_IVI_EXTENSION=wayland-ivi-extension
WESTON_IVI_SHELL=weston-ivi-shell

SCRIPT_DIR=$PWD
target_root=$PWD/..
target_bin=$PWD/../bin #by default
target_positioning=$PWD/../$POSITIONING #by default
target_ilm=$PWD/../$IVI_LAYER_MANAGER #by default

#--------------------------------------------------------------------------
# Compiler Flags
#--------------------------------------------------------------------------
# modify the following flags as needed:
NAVIT_FLAGS='-DDISABLE_QT=1 -DSAMPLE_MAP=0 -Dvehicle/null=1 -Dgraphics/qt_qpainter=0'
GNSS_SERVICE_FLAGS='-DWITH_DLT=OFF -DWITH_GPSD=OFF -DWITH_REPLAYER=ON -DWITH_TESTS=ON'
SENSORS_SERVICE_FLAGS='-DWITH_DLT=OFF -DWITH_REPLAYER=ON -DWITH_IPHONE=OFF -DWITH_TESTS=ON'
ENHANCED_POSITION_SERVICE_FLAGS='-DWITH_DLT=OFF -DWITH_GPSD=OFF -DWITH_REPLAYER=ON -DWITH_IPHONE=OFF -DWITH_TESTS=ON'
LOG_REPLAYER_FLAGS='-DWITH_DLT=OFF -DWITH_TESTS=ON'
#

# by default no ilm 
lm=0

set-path()
{
	TOP_DIR=$target_root
	TOP_BIN_DIR=$target_bin
	API_DIR=$TOP_DIR/../../api
	GENERATED_API_DIR=$API_DIR/include
	
	NAVIGATION_CORE_SRC_DIR=$TOP_DIR/$NAVIGATION_CORE
	NAVIGATION_CORE_BIN_DIR=$TOP_BIN_DIR/$NAVIGATION_CORE
	NAVIGATION_CORE_API_DIR=$TOP_DIR/../../api/$NAVIGATION_CORE

	MAP_VIEWER_SRC_DIR=$TOP_DIR/$MAP_VIEWER
	MAP_VIEWER_BIN_DIR=$TOP_BIN_DIR/$MAP_VIEWER
	MAP_VIEWER_API_DIR=$TOP_DIR/../../api/$MAP_VIEWER

	POI_SERVICE_API_DIR=$TOP_DIR/../../api/$POI_SERVICE

	POI_CAM_SRC_DIR=$TOP_DIR/$POI_CAM
	POI_CAM_BIN_DIR=$TOP_BIN_DIR/$POI_CAM

	NAVIGATION_CORE_CONFIGURATION_SRC_DIR=$NAVIGATION_CORE_SRC_DIR/configuration-plugin
	NAVIGATION_CORE_CONFIGURATION_BIN_DIR=$NAVIGATION_CORE_BIN_DIR/$NAVIGATION_CORE_CONFIGURATION

	NAVIGATION_CORE_GUIDANCE_SRC_DIR=$NAVIGATION_CORE_SRC_DIR/guidance-plugin
	NAVIGATION_CORE_GUIDANCE_BIN_DIR=$NAVIGATION_CORE_BIN_DIR/$NAVIGATION_CORE_GUIDANCE

	NAVIGATION_CORE_LOCATIONINPUT_SRC_DIR=$NAVIGATION_CORE_SRC_DIR/locationinput-plugin
	NAVIGATION_CORE_LOCATIONINPUT_BIN_DIR=$NAVIGATION_CORE_BIN_DIR/$NAVIGATION_CORE_LOCATIONINPUT

	NAVIGATION_CORE_MAPMATCHEDPOSITION_SRC_DIR=$NAVIGATION_CORE_SRC_DIR/mapmatchedposition-plugin
	NAVIGATION_CORE_MAPMATCHEDPOSITION_BIN_DIR=$NAVIGATION_CORE_BIN_DIR/$NAVIGATION_CORE_MAPMATCHEDPOSITION

	NAVIGATION_CORE_ROUTING_SRC_DIR=$NAVIGATION_CORE_SRC_DIR/routing-plugin
	NAVIGATION_CORE_ROUTING_BIN_DIR=$NAVIGATION_CORE_BIN_DIR/$NAVIGATION_CORE_ROUTING

	NAVIGATION_CORE_SESSION_SRC_DIR=$NAVIGATION_CORE_SRC_DIR/session-plugin
	NAVIGATION_CORE_SESSION_BIN_DIR=$NAVIGATION_CORE_BIN_DIR/$NAVIGATION_CORE_SESSION

	NAVIGATION_CORE_ENHANCEDPOSITION_SRC_DIR=$NAVIGATION_CORE_SRC_DIR/enhancedposition-plugin
	NAVIGATION_CORE_ENHANCEDPOSITION_BIN_DIR=$NAVIGATION_CORE_BIN_DIR/$NAVIGATION_CORE_ENHANCEDPOSITION

	MAP_VIEWER_CONFIGURATION_SRC_DIR=$MAP_VIEWER_SRC_DIR/configuration-plugin
	MAP_VIEWER_CONFIGURATION_BIN_DIR=$MAP_VIEWER_BIN_DIR/$MAP_VIEWER_CONFIGURATION

	MAP_VIEWER_MAPVIEWERCONTROL_SRC_DIR=$MAP_VIEWER_SRC_DIR/mapviewercontrol-plugin
	MAP_VIEWER_MAPVIEWERCONTROL_BIN_DIR=$MAP_VIEWER_BIN_DIR/$MAP_VIEWER_MAPVIEWERCONTROL

	MAP_VIEWER_SESSION_SRC_DIR=$MAP_VIEWER_SRC_DIR/session-plugin
	MAP_VIEWER_SESSION_BIN_DIR=$MAP_VIEWER_BIN_DIR/$MAP_VIEWER_SESSION

	POSITIONING_SRC_DIR=$target_positioning
	POSITIONING_BIN_DIR=$TOP_BIN_DIR/$POSITIONING
	LOG_REPLAYER_SRC_DIR=$POSITIONING_SRC_DIR/$LOG_REPLAYER
	LOG_REPLAYER_BIN_DIR=$POSITIONING_BIN_DIR/$LOG_REPLAYER
	GNSS_SERVICE_SRC_DIR=$POSITIONING_SRC_DIR/$GNSS_SERVICE
	GNSS_SERVICE_BIN_DIR=$POSITIONING_BIN_DIR/$GNSS_SERVICE
	SENSORS_SERVICE_SRC_DIR=$POSITIONING_SRC_DIR/$SENSORS_SERVICE
	SENSORS_SERVICE_BIN_DIR=$POSITIONING_BIN_DIR/$SENSORS_SERVICE
	ENHANCED_POSITION_SERVICE_SRC_DIR=$POSITIONING_SRC_DIR/$ENHANCED_POSITION_SERVICE
	ENHANCED_POSITION_SERVICE_BIN_DIR=$POSITIONING_BIN_DIR/$ENHANCED_POSITION_SERVICE
	ENHANCED_POSITION_SERVICE_API_DIR=$POSITIONING_SRC_DIR/$ENHANCED_POSITION_SERVICE/api
	ENHANCED_POSITION_SERVICE_GENERATED_API_DIR=$ENHANCED_POSITION_SERVICE_API_DIR/include

	NAVIT_SRC_DIR=$TOP_DIR/$NAVIT
	NAVIT_BIN_DIR=$TOP_BIN_DIR/$NAVIT

	MAP_DIR=$TOP_DIR/map

	IVI_LAYER_MANAGER_SRC_DIR=$target_ilm
	IVI_LAYER_MANAGER_BIN_DIR=$TOP_BIN_DIR/$IVI_LAYER_MANAGER
	WAYLAND_IVI_EXTENSION_SRC_DIR=$IVI_LAYER_MANAGER_SRC_DIR/$WAYLAND_IVI_EXTENSION
	WAYLAND_IVI_EXTENSION_BIN_DIR=$IVI_LAYER_MANAGER_BIN_DIR/$WAYLAND_IVI_EXTENSION
	WESTON_IVI_SHELL_SRC_DIR=$IVI_LAYER_MANAGER_SRC_DIR/$WESTON_IVI_SHELL
	WESTON_IVI_SHELL_BIN_DIR=$IVI_LAYER_MANAGER_BIN_DIR/$WESTON_IVI_SHELL

}


usage() {
    echo "Usage: ./build.sh [command]"
    echo "   or: ./build.sh [command] [paths]"
    echo
    echo "command:"
    echo "  make        Build"
    echo "  makelm      Build with layer manager"
    echo "  maked       Build in debug mode"
    echo "  clean       Clean the bin"
    echo "  src-clean   Clean the cloned sources and the bin"
    echo "  clone       Clone the sources"
    echo "  help        Print Help"
    echo "paths:" 
	echo "(used for remote build)"
    echo "  <target bin>         Path of the binaries"
    echo "  <target positioning> Path of the positioning code"
    echo "  <target ilm>         Path of the ilm code"
}

clone() {
    echo ''
    echo 'Clone/update version of additional sources if needed, get maps'
    cd $TOP_DIR 
	cmake -Dpositioning_SRC_DIR=$target_positioning -Dlayer-management_SRC_DIR=$target_ilm $TOP_DIR
}

build() {
    echo ''
    echo 'Building navigation'

	if [ ! -d "$NAVIT_SRC_DIR" ]; then
	  	echo 'Do clone first'
		exit 1
	fi

    cd $TOP_DIR 
    mkdir -p bin
    cd $TOP_BIN_DIR

	if [ $lm -eq 1 ]; then
		echo ''
		echo 'Building layer manager'

		if [ -z $WLD ]; then
			echo 'need to build QtWayland first'
			echo 'see the README file for details'
			exit 1
		fi
		cd $TOP_BIN_DIR 
		mkdir -p $IVI_LAYER_MANAGER

		cd $IVI_LAYER_MANAGER_BIN_DIR
		mkdir -p $WAYLAND_IVI_EXTENSION
		cd $WAYLAND_IVI_EXTENSION_BIN_DIR
		cp $SCRIPT_DIR/toolchain.cmake $WAYLAND_IVI_EXTENSION_SRC_DIR
		cmake -DCMAKE_TOOLCHAIN_FILE=$WAYLAND_IVI_EXTENSION_SRC_DIR/toolchain.cmake $WAYLAND_IVI_EXTENSION_SRC_DIR
		cmake -DCMAKE_TOOLCHAIN_FILE=$WAYLAND_IVI_EXTENSION_SRC_DIR/toolchain.cmake $WAYLAND_IVI_EXTENSION_SRC_DIR
		make -j4
		sudo make install

		cd $IVI_LAYER_MANAGER_BIN_DIR
		mkdir -p $WESTON_IVI_SHELL
		cd $WESTON_IVI_SHELL_SRC_DIR
		./autogen.sh --prefix=$WESTON_IVI_SHELL_BIN_DIR
		make -j4 
		sudo make install

	fi

	# make navit first, because plugins need navit built stuff
    echo ''
    echo 'Building navit'
	cd $TOP_BIN_DIR
	mkdir -p $NAVIT
	cd $NAVIT_BIN_DIR
  	cmake $NAVIT_FLAGS $NAVIT_SRC_DIR/navit && make 

    echo ''
    echo 'Create maps xml files for navit'
	cd $MAP_DIR
  	cmake -DNAVIT_MAPS_DIR=$NAVIT_BIN_DIR/navit/maps ./

    echo 'Generate DBus include files for positioning'
	cd $ENHANCED_POSITION_SERVICE_API_DIR
	cmake .
    echo ''
    echo 'Building positioning'
	cd $TOP_BIN_DIR
	mkdir -p $POSITIONING

	cd $POSITIONING_BIN_DIR
	mkdir -p $GNSS_SERVICE
	cd $GNSS_SERVICE_BIN_DIR
	cmake $GNSS_SERVICE_FLAGS $DEBUG_FLAG $GNSS_SERVICE_SRC_DIR && make

	cd $POSITIONING_BIN_DIR
	mkdir -p $SENSORS_SERVICE
	cd $SENSORS_SERVICE_BIN_DIR
	cmake $SENSORS_SERVICE_FLAGS $DEBUG_FLAG $SENSORS_SERVICE_SRC_DIR && make

	cd $POSITIONING_BIN_DIR
	mkdir -p $LOG_REPLAYER
	cd $LOG_REPLAYER_BIN_DIR
	cmake $LOG_REPLAYER_FLAGS $DEBUG_FLAG $LOG_REPLAYER_SRC_DIR && make

	cd $POSITIONING_BIN_DIR
	mkdir -p $ENHANCED_POSITION_SERVICE
	cd $ENHANCED_POSITION_SERVICE_BIN_DIR
	cmake $ENHANCED_POSITION_SERVICE_FLAGS $DEBUG_FLAG $ENHANCED_POSITION_SERVICE_SRC_DIR && make

    echo ''
    echo 'Generate DBus include files for navigation, mapviewer and poiservice'

	cd $API_DIR
	mkdir -p include
	cd $API_DIR/$NAVIGATION_CORE && cmake .
	cd $API_DIR/$MAP_VIEWER && cmake .
	cd $API_DIR/$POI_SERVICE && cmake .

    echo ''
    echo 'Building plugins'

	cd $TOP_BIN_DIR
	mkdir -p $NAVIGATION_CORE
	cd $NAVIGATION_CORE_BIN_DIR
	cmake -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $NAVIGATION_CORE_SRC_DIR

    cd $NAVIGATION_CORE_BIN_DIR
    mkdir -p $NAVIGATION_CORE_CONFIGURATION
    cd $NAVIGATION_CORE_CONFIGURATION_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -Dgenerated_api_DIR=$GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $NAVIGATION_CORE_CONFIGURATION_SRC_DIR && make 

    cd $NAVIGATION_CORE_BIN_DIR
    mkdir -p $NAVIGATION_CORE_GUIDANCE
    cd $NAVIGATION_CORE_GUIDANCE_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -Dgenerated_api_DIR=$GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $NAVIGATION_CORE_GUIDANCE_SRC_DIR && make 

    cd $NAVIGATION_CORE_BIN_DIR
    mkdir -p $NAVIGATION_CORE_LOCATIONINPUT
    cd $NAVIGATION_CORE_LOCATIONINPUT_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -Dgenerated_api_DIR=$GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $NAVIGATION_CORE_LOCATIONINPUT_SRC_DIR && make 

    cd $NAVIGATION_CORE_BIN_DIR
    mkdir -p $NAVIGATION_CORE_MAPMATCHEDPOSITION
    cd $NAVIGATION_CORE_MAPMATCHEDPOSITION_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -Dgenerated_api_DIR=$GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $NAVIGATION_CORE_MAPMATCHEDPOSITION_SRC_DIR && make 

    cd $NAVIGATION_CORE_BIN_DIR
    mkdir -p $NAVIGATION_CORE_ROUTING
    cd $NAVIGATION_CORE_ROUTING_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -Dgenerated_api_DIR=$GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $NAVIGATION_CORE_ROUTING_SRC_DIR && make 

    cd $NAVIGATION_CORE_BIN_DIR
    mkdir -p $NAVIGATION_CORE_SESSION
    cd $NAVIGATION_CORE_SESSION_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -Dgenerated_api_DIR=$GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $NAVIGATION_CORE_SESSION_SRC_DIR && make 

    cd $NAVIGATION_CORE_BIN_DIR
    mkdir -p $NAVIGATION_CORE_ENHANCEDPOSITION
    cd $NAVIGATION_CORE_ENHANCEDPOSITION_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -Dpositioning_API=$ENHANCED_POSITION_SERVICE_GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $NAVIGATION_CORE_ENHANCEDPOSITION_SRC_DIR && make 

	cd $TOP_BIN_DIR
	mkdir -p $MAP_VIEWER
	cd $MAP_VIEWER_BIN_DIR
	cmake -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $MAP_VIEWER_SRC_DIR

    cd $MAP_VIEWER_BIN_DIR
    mkdir -p $MAP_VIEWER_CONFIGURATION
    cd $MAP_VIEWER_CONFIGURATION_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -Dgenerated_api_DIR=$GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $MAP_VIEWER_CONFIGURATION_SRC_DIR && make 

    cd $MAP_VIEWER_BIN_DIR
    mkdir -p $MAP_VIEWER_MAPVIEWERCONTROL
    cd $MAP_VIEWER_MAPVIEWERCONTROL_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -DLM=$lm -Dlayer_management_INST=$target_ilm -Dgenerated_api_DIR=$GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $MAP_VIEWER_MAPVIEWERCONTROL_SRC_DIR && make 

    cd $MAP_VIEWER_BIN_DIR
    mkdir -p $MAP_VIEWER_SESSION
    cd $MAP_VIEWER_SESSION_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -Dgenerated_api_DIR=$GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $MAP_VIEWER_SESSION_SRC_DIR && make 

    cd $TOP_BIN_DIR
    mkdir -p $POI_CAM
    cd $POI_CAM_BIN_DIR 
    cmake -Wno-dev -C $NAVIT_BIN_DIR/cmake_plugin_settings.txt -Dgenerated_api_DIR=$GENERATED_API_DIR -Dnavit_SRC_DIR=$NAVIT_SRC_DIR $DEBUG_FLAG $POI_CAM_SRC_DIR && make 

}

clean() {
	echo 'delete' $TOP_BIN_DIR 

	if [ -d "$IVI_LAYER_MANAGER_BIN_DIR" ]; then
	  sudo rm -rf $IVI_LAYER_MANAGER_BIN_DIR
	fi

	rm -rf $TOP_BIN_DIR
}

src-clean() {
	echo 'delete' $POSITIONING_SRC_DIR 
    rm -rf $POSITIONING_SRC_DIR
	echo 'delete' $NAVIT_SRC_DIR 
    rm -rf $NAVIT_SRC_DIR
	echo 'delete' $IVI_LAYER_MANAGER_SRC_DIR 
    rm -rf $IVI_LAYER_MANAGER_SRC_DIR
    clean
}

set -e

if [ $# -ge 1 ]; then
    if [ $1 = help ]; then
        usage
    elif [ $1 = make ]; then
		if [ $# -eq 4 ]; then
			#use for remote build
			target_bin=$(readlink -f $2)
			target_positioning=$(readlink -f $3)
			target_ilm=$(readlink -f $4)
		fi
		set-path
		DEBUG_FLAG='-DWITH_DEBUG=OFF'
        build
    elif [ $1 = maked ]; then
		if [ $# -eq 4 ]; then
			#use for remote build
			target_bin=$(readlink -f $2)
			target_positioning=$(readlink -f $3)
			target_ilm=$(readlink -f $4)
		fi
		set-path
		DEBUG_FLAG='-DWITH_DEBUG=ON'
        build
    elif [ $1 = makelm ]; then
		lm=1
		if [ $# -eq 4 ]; then
			#use for remote build
			target_bin=$(readlink -f $2)
			target_positioning=$(readlink -f $3)
			target_ilm=$(readlink -f $4)
		fi
		set-path
		DEBUG_FLAG='-DWITH_DEBUG=OFF'
        build
    elif [ $1 = clean ]; then
		set-path
        clean
    elif [ $1 = src-clean ]; then
		if [ $# -eq 4 ]; then
			#use for remote build
			target_bin=$(readlink -f $2)
			target_positioning=$(readlink -f $3)
			target_ilm=$(readlink -f $4)
		fi
		set-path
        src-clean
    elif [ $1 = clone ]; then
		if [ $# -eq 4 ]; then
			#use for remote build
			target_bin=$(readlink -f $2)
			target_positioning=$(readlink -f $3)
			target_ilm=$(readlink -f $4)
		fi
		set-path
        clone
    else
        usage
    fi
else
    usage
fi
