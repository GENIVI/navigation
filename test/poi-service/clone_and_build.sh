#!/bin/bash

positioning_version='9e65831eed02cc8a1b2e2e73787d6007b54214b4'

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



