#!/bin/bash

###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2017, PSA Group
#
# \file build.sh
#
# \brief This file is part of the Build System for poi.
#
# \author Philippe Colliot <philippe.colliot@mpsa.com>
#
# \version 1.0
#
# This Source Code Form is subject to the terms of the
# Mozilla Public License (MPL), v. 2.0.
# If a copy of the MPL was not distributed with this file,
# You can obtain one at http://mozilla.org/MPL/2.0/.
#
# For further information see http://www.genivi.org/.
#
# List of changes:
# 
#
# @licence end@
###########################################################################

clean=0 #no clean (means no cmake) -> -c option
capi=0 #no common api -> -m option
commonapi_tools_option="-DWITH_PLUGIN_MIGRATION=OFF" 
dlt_option="OFF" #no DLT -> -l option
debug="OFF" #no debug -> -d option

function check_path_for_capi
{
	echo 'check path for CommonAPI'
	if [ ! $COMMONAPI_TOOL_DIR ]
	then 
		echo 'Set the dir of the common api tools'
		echo 'export COMMONAPI_TOOL_DIR=<path>'
		exit 1
	fi

	if [ ! $COMMONAPI_DBUS_TOOL_DIR ]
	then 
		echo 'Set the dir of the common api dbus tools'
		echo 'export COMMONAPI_DBUS_TOOL_DIR=<path>'
		exit 1
	fi

	if [ ! $DBUS_LIB_PATH ]
	then 
		echo 'Set the dir of the patched dbus'
		echo 'export DBUS_LIB_PATH=<path>'
		exit 1
	fi
	commonapi_tools_option="-DDBUS_LIB_PATH="$DBUS_LIB_PATH" -DCOMMONAPI_DBUS_TOOL_DIR="$COMMONAPI_DBUS_TOOL_DIR" -DCOMMONAPI_TOOL_DIR="$COMMONAPI_TOOL_DIR
}
 
while getopts cdhlmh opt
do
	case $opt in
	c)
		clean=1
		;;
	d)
		debug="ON"
		;;
	l)
		dlt_option="ON"
		;;
	m)
		capi=1
		#check commonapi settings
		check_path_for_capi
		;;
	h)
		echo "Usage:"
		echo "$0 [-cdhlm]"
		echo "-c: Rebuild with clean"
		echo "-d: Enable the debug messages"
		echo "-h: Help"
		echo "-l: Build with dlt (only with -c)"
		echo "-m: Build with commonAPI plugins (only with -c)"
		exit 1
	esac
done

set -e

if [ "$clean" = 1 ]
then
	echo 'clean up the build folder'
	if [ -d "./build" ]
	then
		find ./build ! -name '*.cbp' -type f -exec rm -f {} +
	fi
fi

mkdir -p build
cd build

echo 'build poi-server'
if [ "$clean" = 1 ]
then
	cmake -DWITH_DLT=$dlt_option $commonapi_tools_option -DWITH_DEBUG=$debug ../
fi
make


