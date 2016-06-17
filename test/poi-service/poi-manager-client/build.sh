#!/bin/bash

debug="OFF"
clean=0

while getopts cdh opt
do
	case $opt in
	c)
		clean=1
		;;
	d)
		debug="ON"
		;;
	h)
		echo "Usage:"
		echo "$0 [-cdh]"
		echo "-c: Rebuild with clean"
		echo "-d: Enable the debug messages"
		exit 1
	esac
done
set -e

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



cd ../../../src/poi-service/poi-manager-server
./build.sh "$@"
cd ../.././../test/poi-service/poi-manager-client

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

echo 'build poi-manager-client'
if [ "$clean" = 1 ]
then
	cmake $commonapi_tools_option -DWITH_DEBUG=$debug ../
fi
make
cd ..

