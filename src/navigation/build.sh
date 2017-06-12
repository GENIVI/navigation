#!/bin/bash

clean=0
capi=0
navit=0
poi=0
dlt_option="-DWITH_DLT=OFF"
commonapi_tools_option="-DWITH_PLUGIN_MIGRATION=OFF"

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
 
while getopts cdmnp opt
do
	case $opt in
	c)
		clean=1
		;;
	d)
		dlt_option="-DWITH_DLT=ON"
		;;
	m)
		capi=1
		;;
	n)
		navit=1
		;;
	p)
		poi=1
		;;
	\?)
		echo "Usage:"
		echo "$0 [-cdmnp]"
		echo "-c: clean and build"
		echo "-d: build with dlt (only with -c)"
		echo "-m: build with commonAPI plugins (only with -c) "
		echo "-n: build navit"
		echo "-p: build poi"
		exit 1
	esac
done

#check commonapi settings
if [ "$capi" = 1 ]
then
	check_path_for_capi
fi

#clean
if [ "$clean" = 1 ] && [ -d "./build" ]
then
	echo 'clean up navigation and positioning'
	rm ./build/CMakeCache.txt
	rm ./build/cmake_install.cmake
	rm ./build/Makefile
	rm ./build/positioning/cmake_install.cmake
	rm ./build/positioning/Makefile
	if [ "$navit" = 1 ]
	then
		echo 'clean up navit'
		rm ./build/navit/CMakeCache.txt
		rm ./build/navit/cmake_install.cmake
		rm ./build/navit/Makefile
	fi
	if [ "$poi" = 1 ] && [ -d "../poi-service/build" ]
	then
		echo 'clean up poi'
		rm ../poi-service/build/CMakeCache.txt
		rm ../poi-service/build/cmake_install.cmake
		rm ../poi-service/build/Makefile
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
	cmake $dlt_option $commonapi_tools_option ../
	echo 'replace a missing font in the configuration file of navit instances'
	sed -i -e 's/Liberation Sans/TakaoPGothic/' ./navit/navit/navit_genivi_mapviewer.xml
	sed -i -e 's/Liberation Sans/TakaoPGothic/' ./navit/navit/navit_genivi_navigationcore.xml
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
		cmake -DWITH_PLUGIN_MIGRATION=0 ../
	fi
	make
fi
cd ../../navigation

