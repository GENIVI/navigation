#!/bin/bash

debug="OFF"
franca="OFF"
dbus="ON"
commonapi_tools_option=""
clean=0

while getopts cdf opt
do
	case $opt in
	c)
		clean=1
		;;
	d)
		debug="ON"
		;;
	f)
		franca="ON"
		dbus="OFF"
		;;
	\?)
		echo "Usage:"
		echo "$0 [-cdf]"
		echo "-c: Rebuild with clean"
		echo "-d: Enable the debug messages"
		echo "-f: Build using the Franca interfaces"
		exit 1
	esac
done
set -e

if [ "$franca" = "ON" ]
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

cd ../../src/poi-service
./rebuild_all.sh "$@"
cd ../../test/poi-service

if [ "$clean" = 1 ]
then
	echo 'clean up the build folder'
	if [ -d "./build" ]
	then
		find ./build ! -name '*.cbp' -type f -exec rm -f {} +
	fi
else
	echo 'just build without generation of the database'
fi


mkdir -p build

cd build

echo 'build poi-client'
# Important notice: for the time being, it's just poi manager client that can be built against common api, 
# so it's needed to set WITH_DBUS_INTERFACE=ON for positioning
if [ "$clean" = 1 ]
then
	cmake -DWITH_DATABASE_SUPPLIER=ON -DWITH_FRANCA_DBUS_INTERFACE=$franca -DWITH_DBUS_INTERFACE=ON $commonapi_tools_option -DWITH_DEBUG=$debug ../
fi
make
cd ..

if [ "$clean" = 1 ]
then
	echo 'populate the database with POIs of Paris'
	./prepare -c paris
fi
 

