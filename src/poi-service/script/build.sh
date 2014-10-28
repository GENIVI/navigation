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
TOP_DIR=$PWD/..
TOP_BIN_DIR=$TOP_DIR/bin

POI_SERVER=poi-server
POI_SERVER_SRC_DIR=$TOP_DIR/$POI_SERVER
POI_SERVER_BIN_DIR=$TOP_BIN_DIR
POSITIONING_SRC_DIR=$TOP_DIR/positioning

POI_COMMON=poi-common
POI_COMMON_SRC_DIR=$TOP_DIR/$POI_COMMON

API_DIR=$TOP_DIR/../../api

NAVIGATION_CORE=navigation-core
MAP_VIEWER=map-viewer
POI_SERVICE=poi-service

usage() {
    echo "Usage: ./build.sh Build poi-server"
    echo "   or: ./build.sh [command]"
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

	cmake $API_DIR/$NAVIGATION_CORE
	cmake $API_DIR/$MAP_VIEWER
	cmake $API_DIR/$POI_SERVICE

	make
}

clone() {
    echo ''
    echo 'Clone/update version of additional sources if needed'
    cd $TOP_DIR 
    mkdir -p bin
    cd $TOP_BIN_DIR
	cmake -Dpositioning_SRC_DIR=$POSITIONING_SRC_DIR $POI_SERVER_SRC_DIR
}

clean() {
	echo 'delete' $POI_SERVER_BIN_DIR 
    rm -rf $POI_SERVER_BIN_DIR
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
        build
    elif [ $1 = clean ]; then
        clean
    elif [ $1 = src-clean ]; then
        src-clean
    elif [ $1 = clone ]; then
        clone
    else
        usage
    fi
elif [ $# -eq 0 ]; then
    build
else
    usage
fi
