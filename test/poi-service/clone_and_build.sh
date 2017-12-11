#!/bin/bash

positioning_version='d4c46f13019aefb11aebd0fc1210a29a46f0b521'

echo "version of positioning is: $positioning_version"

echo -n "This script deletes, reloads and builds everything, are you sure ? (y or n) "
read input

if [ ! "$input" = 'y' ]
then
	exit 1
fi

if [ -d "./build" ]
then
	find ./build ! -name '*.cbp' -type f -exec rm -f {} +
fi
rm -rf positioning

git clone https://github.com/GENIVI/positioning.git ./positioning
cd positioning
git checkout $positioning_version
cd ..

./build.sh -c



