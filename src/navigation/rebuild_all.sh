#!/bin/bash

echo 'delete the build folder'
rm -rf build

mkdir build
cd build
mkdir navit
cd navit
mkdir navit
cd navit
echo 'build navit'
cmake -DDISABLE_QT=1 -DSAMPLE_MAP=0 -Dvehicle/null=1 -Dgraphics/qt_qpainter=0 ../../../navit/navit/
make
cd ../../
echo 'build navigation'
cmake ../
make
cd ..


