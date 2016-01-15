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
	commonapi_tools_option="-DCOMMONAPI_DBUS_TOOL_DIR="$COMMONAPI_DBUS_TOOL_DIR" -DCOMMONAPI_TOOL_DIR="$COMMONAPI_TOOL_DIR
fi

echo 'build the poi server'
cd ../../src/poi-service
./rebuild_all.sh "$@"
cd ../../test/poi-service

echo 'build the poi client'

echo 'delete the build folder'
rm -rf build

mkdir build
cd build

echo 'build poi-client'
# Important notice: for the time being, it's just poi manager client that can be built against common api, 
# so it's needed to set WITH_DBUS_INTERFACE=ON for positioning
cmake -DWITH_DATABASE_SUPPLIER=ON -DWITH_FRANCA_DBUS_INTERFACE=$franca -DWITH_DBUS_INTERFACE=ON $commonapi_tools_option -DWITH_DEBUG=$debug ../
make
cd ..

echo 'populate the database with POIs of Paris'
./prepare -c paris
 


