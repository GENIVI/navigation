#!/bin/bash

###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-server
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
POI_SERVER=poi-server
POI_COMMON=poi-common
NAVIGATION_CORE=navigation-core
MAP_VIEWER=map-viewer
POI_SERVICE=poi-service
POSITIONING=positioning
ENHANCED_POSITION_SERVICE=enhanced-position-service

target_root=$PWD/..
target_bin=$PWD/../bin #by default
target_positioning=$PWD/../$POSITIONING #by default

set-path()
{
	TOP_DIR=$target_root
	TOP_BIN_DIR=$target_bin
	API_DIR=$TOP_DIR/../../api
	GENERATED_API_DIR=$API_DIR/include

	POI_SERVER_SRC_DIR=$TOP_DIR/$POI_SERVER
	POI_SERVER_BIN_DIR=$TOP_BIN_DIR/$POI_SERVER
	POI_COMMON_SRC_DIR=$TOP_DIR/$POI_COMMON
	POSITIONING_SRC_DIR=$target_positioning
	POSITIONING_API_DIR=$POSITIONING_SRC_DIR/$ENHANCED_POSITION_SERVICE/api
}

usage() {
    echo "Usage: ./build.sh [command]"
    echo
    echo "command:"
    echo "  make            Build"
    echo "  clean           Clean"
    echo "  src-clean       Clean the cloned sources"
    echo "  clone           Clone the sources"
    echo "  help            Print Help"
    echo
    echo
}

build() {
    echo ''
    echo 'Building poi-server' 

	if [ ! -d "$POSITIONING_SRC_DIR" ]; then
	  	echo 'Do clone first'
		exit 1
	fi

    echo 'Generate DBus include files'

	cd $API_DIR
	mkdir -p include
	cmake $API_DIR/$NAVIGATION_CORE
	cmake $API_DIR/$MAP_VIEWER
	cmake $API_DIR/$POI_SERVICE

    cd $TOP_DIR 
    mkdir -p bin
    cd $TOP_BIN_DIR 
    mkdir -p $POI_SERVER
    cd $POI_SERVER_BIN_DIR
	cmake -Dapi_DIR=$API_DIR -Dpositioning_API=$POSITIONING_API_DIR -Dgenerated_api_DIR=$GENERATED_API_DIR  $POI_SERVER_SRC_DIR && make
}

clone() {
    echo ''
    echo 'Clone/update version of additional sources if needed'
    cd $TOP_DIR 
    mkdir -p bin
    cd $TOP_BIN_DIR
	cmake -Dpositioning_SRC_DIR=$POSITIONING_SRC_DIR $TOP_DIR
}

clean() {
	echo 'delete' $TOP_BIN_DIR 
    rm -rf $TOP_BIN_DIR
}

src-clean() {
	echo 'delete' $POSITIONING_SRC_DIR 
    rm -rf $POSITIONING_SRC_DIR
    clean
}

set -e

if [ $# -ge 1 ]; then
    if [ $1 = help ]; then
        usage
    elif [ $1 = make ]; then
		set-path
        build
    elif [ $1 = clean ]; then
		set-path
        clean
    elif [ $1 = src-clean ]; then
		set-path
        src-clean
    elif [ $1 = clone ]; then
		set-path
        clone
    else
        usage
    fi
else
    usage
fi
