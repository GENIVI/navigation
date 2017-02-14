# Test files for Navigation
## Synopsis
These folders contain several files that allow to test the navigation.
Some are for the GlibDBus version:
test-location-input.py
test-address-input.py 
test-map-viewer-control.py
test-guidance.py
test-route-calculation.py
test-all
and others (*-capi.py) are for the CommonAPI version
NB: For the time being, only the GlibDBus version of navigation runs well

There's a mechanism to trig with DLT, so it's necessary to build some stuff before.

##How to build the trigger
Under ./dlt-triggers
```
mkdir build
cd build
cmake ../
make 
make install
```
##Tested targets
Desktop: Tested under Ubuntu 16.04 LTS 64 bits
##How-to test 
First, open a new terminal and launch the navigation by entering:
```
./run -r
```
Unitary tests:
```
./test-location-input.py -l locations.xml
./test-route-calculation.py -r routes.xml
./test-address-input.py -l location.xml
./test-guidance.py -r route.xml
./test-map-viewer-control.py
```
To launch all the tests:
```
./test-all
```
NB: The locations and the routes are defined for the map database around Geneva (the reference map database into the repository). 

##Sequence charts
In order to illustrate the DBus exchanges, some sequence diagrams are available:
location-input.pdf -->  ./test-location-input.py -l location.xml
route-calculation.pdf --> ./test-route-calculation.py -r route.xml
guidance.pdf --> ./test-guidance.py -r route.xml (partial)
map-viewer-control.pdf --> ./test-map-viewer-control.py

NB: The sequence charts have been caught and generated with an Elektrobit tool (EBSolys)

