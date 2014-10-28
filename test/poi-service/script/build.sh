#!/bin/bash

###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: poi-service
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

POI_COMMON=poi-common
POI_COMMON_SRC_DIR=$TOP_DIR/$POI_COMMON

POI_CLIENT=poi-client
POI_CLIENT_SRC_DIR=$TOP_DIR/$POI_CLIENT
POI_CLIENT_BIN_DIR=$TOP_BIN_DIR/$POI_CLIENT

POI_CONTENTACCESS_MODULE=poi-contentaccess-module
POI_CONTENTACCESS_MODULE_SRC_DIR=$TOP_DIR/$POI_CONTENTACCESS_MODULE
POI_CONTENTACCESS_MODULE_BIN_DIR=$TOP_BIN_DIR/$POI_CONTENTACCESS_MODULE

POI_SUPPLIER=poi-supplier
POI_SUPPLIER_SRC_DIR=$TOP_DIR/$POI_SUPPLIER
POI_SUPPLIER_BIN_DIR=$TOP_BIN_DIR/$POI_SUPPLIER

NAVIGATION_SERVICE_API_DIR=$TOP_DIR/../../api

POI_SERVER_TOP_DIR=$TOP_DIR/../../src/poi-service
POI_SERVER_SRC_DIR=$POI_SERVER_TOP_DIR/poi-server
POI_SERVER_BIN_DIR=$POI_SERVER_TOP_DIR/bin
POI_SERVER_SCRIPT_DIR=$POI_SERVER_TOP_DIR/script
POI_SERVER_BUILD_SCRIPT=./build.sh

API_DIR=$TOP_DIR/../../api

NAVIGATION_CORE=navigation-core
MAP_VIEWER=map-viewer
POI_SERVICE=poi-service

#--------------------------------------------------------------------------
# Compiler Flags
#--------------------------------------------------------------------------
# modify the following flags as needed:

#--------------------------------------------------------------------------

usage() {
    echo "Usage: ./build.sh Build poi-service"
    echo "   or: ./build.sh [command]"
    echo
    echo "command:"
    echo "  make            Build"
    echo "  clean           Clean"
    echo "  src-clean       Clean the cloned sources"
    echo "  help            Print Help"
    echo
    echo
}

build() {
    echo ''
    echo 'Building poi-service'

    echo 'Generate DBus include files'

	cmake $API_DIR/$NAVIGATION_CORE
	cmake $API_DIR/$MAP_VIEWER
	cmake $API_DIR/$POI_SERVICE

    echo 'Check and build poi-server if needed'
    cd $POI_SERVER_SCRIPT_DIR && bash $POI_SERVER_BUILD_SCRIPT make

    cd $TOP_DIR 
    mkdir -p bin

    cd $TOP_BIN_DIR
    mkdir -p $POI_CLIENT
    cd $POI_CLIENT_BIN_DIR 
    cmake $POI_CLIENT_SRC_DIR && make

    cd $TOP_BIN_DIR
    mkdir -p $POI_SUPPLIER
    cd $POI_SUPPLIER_BIN_DIR 
    cmake $POI_SUPPLIER_SRC_DIR && make

    cd $TOP_BIN_DIR
    mkdir -p $POI_CONTENTACCESS_MODULE
    cd $POI_CONTENTACCESS_MODULE_BIN_DIR 
    cmake $POI_CONTENTACCESS_MODULE_SRC_DIR && make

}

clean() {
    cd $POI_SERVER_SCRIPT_DIR && bash $POI_SERVER_BUILD_SCRIPT clean
	echo 'delete' $TOP_BIN_DIR 
	rm -rf $TOP_BIN_DIR
	echo 'delete qm generated files'
	rm -f $POI_COMMON_SRC_DIR/*.qm 
}

src-clean() {
    cd $POI_SERVER_SCRIPT_DIR && bash $POI_SERVER_BUILD_SCRIPT src-clean
	echo 'delete' $TOP_BIN_DIR 
	rm -rf $TOP_BIN_DIR
	echo 'delete qm generated files'
	rm -f $POI_COMMON_SRC_DIR/*.qm 
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
    else
        usage
    fi
elif [ $# -eq 0 ]; then
    build
else
    usage
fi

