#!/bin/bash

build_option=""
positioning_version='9725fe1f553197042d6445997690d452a73490c0'
navit_version='1e71b5fd4c0bf5ac96e5207c51db7d17057ed798'

echo "version of positioning is: $positioning_version"
echo "version of navit is: $navit_version"

echo -n "This script deletes, reloads and builds everything, are you sure ? (y or n) "
read input

if [ ! "$input" = 'y' ]
then
	exit 1
fi

while getopts m opt
do
	case $opt in
	m)
		build_option="-m"
		;;
	\?)
		echo "Usage:"
		echo "$0 [-m]"
		echo "-m: build with commonAPI plugins "
		exit 1
	esac
done


if [ -d "./build" ]
then
	find ./build ! -name '*.cbp' -type f -exec rm -f {} +
fi
rm -rf navit
rm -rf positioning

git clone https://github.com/GENIVI/positioning.git ./positioning
cd positioning
git checkout $positioning_version
cd ..
git clone https://github.com/navit-gps/navit.git
cd navit
git checkout $navit_version
patch -p0 -i ../patches/search_list_get_unique.diff
patch -p0 -i ../patches/fsa_issue_padding.diff
cd ..

./build.sh -c $build_option



