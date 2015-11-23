#!/bin/bash

if [ ! $COMMON_API_ROOT_DIR ]
then 
	echo 'Set the root dir of the common api tools'
	echo 'export COMMON_API_ROOT_DIR=<path>'
	exit 1
fi

echo 'delete the build folder'
rm -rf build

mkdir build
cd build

echo 'generate all the templates for CommonAPI'
cmake -DCOMMONAPI_DBUS_TOOL_GENERATOR=$COMMON_API_ROOT_DIR/common-api-dbus-tools/org.genivi.commonapi.dbus.cli.product/target/products/org.genivi.commonapi.dbus.cli.product/linux/gtk/x86/commonapi-dbus-generator-linux-x86 -DCOMMONAPI_TOOL_GENERATOR=$COMMON_API_ROOT_DIR/genivi/common-api-tools/org.genivi.commonapi.core.cli.product/target/products/org.genivi.commonapi.core.cli.product/linux/gtk/x86/commonapi-generator-linux-x86 ../franca/

