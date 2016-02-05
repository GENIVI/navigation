#!/bin/bash

debug="OFF"
franca="OFF"
dbus="ON"
commonapi_tools_option=""

while getopts df opt
do
	case $opt in
	d)
		debug="ON"
		;;
	f)
		franca="ON"
		dbus="OFF"
		;;
	\?)
		echo "Usage:"
		echo "$0 [-df]"
		echo "-d: Enable the debug messages"
		echo "-f: Build using the Franca interfaces"
		exit 1
	esac
done
set -e

if [ $franca="ON" ]
then
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
fi

echo 'clean up the build folder'
find ./build ! -name '*.cbp' -type f -exec rm -f {} +

mkdir -p build
cd build

echo 'build poi-server'
cmake -DWITH_FRANCA_DBUS_INTERFACE=$franca -DWITH_DBUS_INTERFACE=$dbus $commonapi_tools_option -DWITH_DEBUG=$debug ../

make


