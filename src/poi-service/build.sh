#!/bin/bash

debug="OFF"
dbus="ON"
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
		echo "$0 [-cd]"
		echo "-c: Rebuild with clean"
		echo "-d: Enable the debug messages"
		exit 1
	esac
done
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
	cmake -DWITH_DEBUG=$debug ../
fi
make


