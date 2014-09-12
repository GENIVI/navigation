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
POI_SERVER_SRC_DIR=$PWD/../poi-server
POI_SERVER_BIN_DIR=$PWD/../bin
POSITIONING_SRC_DIR=$PWD/../positioning

usage() {
    echo "Usage: ./build.sh Build poi-server"
    echo "   or: ./build.sh [command]"
    echo
    echo "command:"
    echo "  make            Build"
    echo "  clean           Clean"
    echo "  src-clean       Clean the cloned sources of positioning"
    echo "  help            Print Help"
    echo
    echo
}

build() {
    echo ''
    echo 'Building poi-server ->' $POI_SERVER_SRC_DIR
    mkdir -p $POI_SERVER_BIN_DIR
    cd $POI_SERVER_BIN_DIR 
    cmake $POI_SERVER_SRC_DIR && make
}

clean() {
    rm -rf $POI_SERVER_BIN_DIR
}

src-clean() {
    rm -rf $POSITIONING_SRC_DIR
}

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
