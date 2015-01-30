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

target_root=$PWD/..
target_bin=$PWD/../bin #by default

set-path()
{
	TOP_DIR=$target_root
	TOP_BIN_DIR=$target_bin
	API_DIR=$TOP_DIR/../../api

	POI_SERVER_SRC_DIR=$TOP_DIR/$POI_SERVER
	POI_SERVER_BIN_DIR=$TOP_BIN_DIR/$POI_SERVER
	POI_COMMON_SRC_DIR=$TOP_DIR/$POI_COMMON
}

usage() {
    echo "Usage: ./build.sh [command]"
    echo
    echo "command:"
    echo "  make            Build"
    echo "  clean           Clean"
    echo "  help            Print Help"
    echo
    echo
}

build() {
    echo ''
    echo 'Building poi-server' 

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
	cmake -Dapi_DIR=$API_DIR -Dgenerated_api_DIR=$GENERATED_API_DIR  $POI_SERVER_SRC_DIR && make
}

clean() {
	echo 'delete' $TOP_BIN_DIR 
    rm -rf $TOP_BIN_DIR
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
    else
        usage
    fi
else
    usage
fi