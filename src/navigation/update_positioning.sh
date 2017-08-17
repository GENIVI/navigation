#!/bin/bash

if [ $# -eq 0 ]
 then
  echo "Need positioning commit version"
  exit
fi

positioning_version=$1

if [ -d "./build" ]
then
	find ./build/positioning ! -name '*.cbp' -type f -exec rm -f {} +
fi

rm -rf positioning

git clone https://github.com/GENIVI/positioning.git ./positioning
cd positioning
git checkout $positioning_version
cd ..


