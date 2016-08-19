#!/bin/bash

debug="OFF"
clean=0
capi=0
commonapi_tools_option=""

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
 
while getopts cdmh opt
do
	case $opt in
	c)
		clean=1
		;;
	d)
		debug="ON"
		;;
	m)
		capi=1
		;;
	h)
		echo "Usage:"
		echo "$0 [-cdm]"
		echo "-c: build with clean"
		echo "-d: Enable the debug messages"
		echo "-m: build with commonAPI plugins "
		exit 1
	esac
done

if [ "$capi" = 1 ]
then
	check_path_for_capi
fi

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
	if [ "$capi" = 0 ]
	then
		cmake -DWITH_PLUGIN_MIGRATION=0 -DWITH_DEBUG=$debug ../
	else
		cmake -DWITH_PLUGIN_MIGRATION=ON -DWITH_DBUS_INTERFACE=OFF $commonapi_tools_option -DWITH_DEBUG=$debug ../
		echo 'fix a bug in the generation of CommonAPI hpp'
		sed -i -e 's/(const TimeStampedEnum::/(const ::v4::org::genivi::navigation::navigationcore::NavigationCoreTypes::TimeStampedEnum::/' ./poi-server-capi/src-gen/v4/org/genivi/navigation/navigationcore/LocationInput.hpp
		sed -i -e 's/(const TimeStampedEnum::/(const ::v4::org::genivi::navigation::navigationcore::NavigationCoreTypes::TimeStampedEnum::/' ./poi-server-capi/src-gen/v4/org/genivi/navigation/navigationcore/MapMatchedPosition.hpp
	fi
fi
make


