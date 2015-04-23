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
POI_MANAGER_SERVER=poi-manager-server

target_root=$PWD/..
target_bin=$PWD/../bin #by default

set-path()
{
	TOP_DIR=$target_root
	TOP_BIN_DIR=$target_bin
	POI_MANAGER_SERVER_SRC_DIR=$TOP_DIR/$POI_MANAGER_SERVER
	POI_MANAGER_SERVER_BIN_DIR=$TOP_BIN_DIR/$POI_MANAGER_SERVER
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
    echo 'Building poi-manager-server' 

    cd $TOP_BIN_DIR 
    mkdir -p $POI_MANAGER_SERVER
    cd $POI_MANAGER_SERVER_BIN_DIR
	cmake -DCOMMON_API_PATH_GENERATED_FILES=../../../api/franca/navigation/src-gen -DDBUS_LIB_PATH=/usr/local/lib  $POI_MANAGER_SERVER_SRC_DIR && make

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
