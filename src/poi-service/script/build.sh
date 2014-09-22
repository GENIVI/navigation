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
TOP_BIN_DIR=$PWD/../bin

POI_SERVER=poi-server
POI_SERVER_SRC_DIR=$TOP_DIR/$POI_SERVER
POI_SERVER_BIN_DIR=$TOP_BIN_DIR
POSITIONING_SRC_DIR=$TOP_DIR/positioning

POI_COMMON=poi-common
POI_COMMON_SRC_DIR=$TOP_DIR/$POI_COMMON

usage() {
    echo "Usage: ./build.sh Build poi-server"
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
    echo 'Building poi-server' 
    mkdir -p $POI_SERVER_BIN_DIR
    cd $POI_SERVER_BIN_DIR 
    cmake $POI_SERVER_SRC_DIR && make
}

clean() {
	echo 'delete' $POI_SERVER_BIN_DIR 
    rm -rf $POI_SERVER_BIN_DIR
	echo 'delete dbus generated files'
	rm -f $POI_COMMON_SRC_DIR/*_adaptor.h $POI_COMMON_SRC_DIR/*_proxy.h $POI_COMMON_SRC_DIR/*-constants.h
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
    else
        usage
    fi
elif [ $# -eq 0 ]; then
    build
else
    usage
fi
