#!/bin/bash

clean=0

while getopts c opt
do
	case $opt in
	c)
		clean=1
		;;
	\?)
		echo "Usage:"
		echo "$0 [-c ]"
		echo "-c: Rebuild with clean"
		exit 1
	esac
done

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
mkdir -p navit
cd navit
mkdir -p navit
cd navit
echo 'build navit'
if [ "$clean" = 1 ]
then
	cmake -DDISABLE_QT=1 -DSAMPLE_MAP=0 -Dvehicle/null=1 -Dgraphics/qt_qpainter=0 ../../../navit/navit/
fi
make
cd ../../
echo 'build navigation'
if [ "$clean" = 1 ]
then
	cmake ../
fi
make
cd ..


