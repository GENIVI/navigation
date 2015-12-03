#!/bin/bash

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

echo 'build the poi server'
cd ../../src/poi-service
./rebuild_all.sh
cd ../../test/poi-service

echo 'build the poi client'

echo 'delete the build folder'
rm -rf build

mkdir build
cd build

echo 'build with CommonAPI'
cmake -DWITH_FRANCA_DBUS_INTERFACE=ON -DWITH_DATABASE_SUPPLIER=ON -DCOMMONAPI_DBUS_TOOL_DIR=$COMMONAPI_DBUS_TOOL_DIR -DCOMMONAPI_TOOL_DIR=$COMMONAPI_TOOL_DIR -DWITH_DEBUG=ON . ../

make

