#!/bin/bash

###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2017, PSA Group
#
# \file build.sh
#
# \brief This file is part of the Build System for navigation.
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
navit=0 #no build of navit -> -n option
poi=0 #no build of poi -> -p option 
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
	commonapi_tools_option="-DWITH_PLUGIN_MIGRATION=ON -DWITH_DBUS_INTERFACE=OFF -DDBUS_LIB_PATH="$DBUS_LIB_PATH" -DCOMMONAPI_DBUS_TOOL_DIR="$COMMONAPI_DBUS_TOOL_DIR" -DCOMMONAPI_TOOL_DIR="$COMMONAPI_TOOL_DIR
}
 
while getopts cdlmhnp opt
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
	n)
		navit=1
		;;
	p)
		poi=1
		;;
	h)
		echo "Usage:"
		echo "$0 [-cdhlmnp]"
		echo "-c: Rebuild with clean"
		echo "-d: Enable the debug messages"
		echo "-h: Help"
		echo "-l: Build with dlt (only with -c)"
		echo "-m: Build with commonAPI plugins (only with -c)"
		echo "-n: Build navit"
		echo "-p: Build poi"
		exit 1
	esac
done

#clean
if [ "$clean" = 1 ] && [ -d "./build" ]
then
	echo 'clean up navigation and positioning'
	rm -f ./build/CMakeCache.txt
	rm -f ./build/cmake_install.cmake
	rm -f ./build/Makefile
	rm -f ./build/positioning/cmake_install.cmake
	rm -f ./build/positioning/Makefile
	if [ "$navit" = 1 ]
	then
		echo 'clean up navit'
		rm -f ./build/navit/CMakeCache.txt
		rm -f ./build/navit/cmake_install.cmake
		rm -f ./build/navit/Makefile
	fi
	if [ "$poi" = 1 ] && [ -d "../poi-service/build" ]
	then
		echo 'clean up poi'
		rm -f ../poi-service/build/CMakeCache.txt
		rm -f ../poi-service/build/cmake_install.cmake
		rm -f ../poi-service/build/Makefile
	fi
fi

#navit
mkdir -p build
cd build
mkdir -p navit
cd navit
if [ "$navit" = 1 ]
then
	echo 'build navit'
	if [ "$clean" = 1 ]
	then
		cmake -DDISABLE_QT=1 -DSAMPLE_MAP=0 -DBUILD_MAPTOOL=0 -Dvehicle/null=1 -Dgraphics/qt_qpainter=0 ../../navit/
	fi
	make
fi
cd ..

#navigation
echo 'build navigation'
if [ "$clean" = 1 ]
then
	cmake -DWITH_DLT=$dlt_option $commonapi_tools_option -DWITH_DEBUG=$debug ../
	echo 'Allow to display Korean and Japanese by replacing a font in the configuration file of navit instances'
	sed -i -e 's/Liberation Sans/NanumGothic/' ./navit/navit/navit_genivi_mapviewer.xml
	sed -i -e 's/Liberation Sans/NanumGothic/' ./navit/navit/navit_genivi_navigationcore.xml
fi
make
cd ..

#poi
cd ../poi-service
mkdir -p build
cd build
if [ "$poi" = 1 ]
then
	echo 'build poi'
	if [ "$clean" = 1 ]
	then
		cmake -DWITH_DLT=$dlt_option -DWITH_DEBUG=$debug -DWITH_PLUGIN_MIGRATION=0 ../
	fi
	make
fi
cd ../../navigation

