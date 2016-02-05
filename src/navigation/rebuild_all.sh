#!/bin/bash

echo 'clean up the build folder'
find ./build ! -name '*.cbp' -type f -exec rm -f {} +

mkdir -p build
cd build
mkdir -p navit
cd navit
mkdir -p navit
cd navit
echo 'build navit'
cmake -DDISABLE_QT=1 -DSAMPLE_MAP=0 -Dvehicle/null=1 -Dgraphics/qt_qpainter=0 ../../../navit/navit/
make
cd ../../
echo 'build navigation'
cmake ../
make
cd ..


