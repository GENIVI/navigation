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
		echo "$0 [-cdh]"
		echo "-c: Rebuild with clean"
		echo "-d: Enable the debug messages"
		exit 1
	esac
done
set -e

cd ../../src/poi-service
./build.sh "$@"
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
if [ "$clean" = 1 ]
then
	cmake -DWITH_DATABASE_SUPPLIER=ON -DWITH_DEBUG=$debug ../
fi
make
cd ..

if [ "$clean" = 1 ]
then
	echo 'populate the database with POIs of Paris'
	./prepare -c paris
fi
 


