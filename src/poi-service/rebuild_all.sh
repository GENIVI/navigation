#!/bin/bash

if [ ! $COMMON_API_ROOT_DIR ]
then 
	echo 'Set the root dir of the common api tools'
	echo 'You are supposed to build common-api-dbus-tools and common-api-tools under the same root dir'
	echo 'export COMMON_API_ROOT_DIR=<path>'
	exit 1
fi

echo 'delete the build folder'
rm -rf build

mkdir build
cd build

echo 'build with CommonAPI'
cmake -DWITH_FRANCA_DBUS_INTERFACE=ON -DWITH_DBUS_INTERFACE=OFF -DCOMMONAPI_DBUS_TOOL_GENERATOR=$COMMON_API_ROOT_DIR/common-api-dbus-tools/org.genivi.commonapi.dbus.cli.product/target/products/org.genivi.commonapi.dbus.cli.product/linux/gtk/x86/commonapi-dbus-generator-linux-x86 -DCOMMONAPI_TOOL_GENERATOR=$COMMON_API_ROOT_DIR/common-api-tools/org.genivi.commonapi.core.cli.product/target/products/org.genivi.commonapi.core.cli.product/linux/gtk/x86/commonapi-generator-linux-x86 -DWITH_DEBUG=ON . ../

make


