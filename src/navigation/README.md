# Navigation middleware

## Synopsis
This folder contains a navigation software based on Navit and compliant with the Navigation APIs standardized by the GENIVI Alliance. Some test scripts are available into the ../../test/navigation folder. 
The GENIVI APIs are implemented by navit plugins, running on DBus. 

##Tested targets
Desktop: Tested under Ubuntu 16.04 LTS 64 bits
Hardware: Code is running on the [Genivi Demo Platform](https://github.com/GENIVI/genivi-dev-platform)  (Yocto based)

## Third parties software
Positioning from [https://github.com/GENIVI/positioning](https://github.com/GENIVI/positioning) 
Navit from [https://github.com/navit-gps/navit/](https://github.com/navit-gps/navit/) 
NB: Patches are applied to navit:
search_list_get_unique.diff features used by GetSpell
fsa_issue_padding.diff required to run on the GDP
NB: For displaying current versions used by the code type ./clone_and_build.sh in command line 
The code is regularly aligned with the latest versions of the third parties software

## Prerequisites
Under Ubuntu, some packets are needed to be installed:
sudo apt-get install xsltproc libdbus-cpp-dev libdbus-c++-dev libglib2.0-dev gtk+-2.0 libglibmm-2.4-dev libxml++2.6-dev libgtk-3-dev libdbus-1-dev libsdl1.2-dev libsdl-image1.2-dev libsdl-ttf2.0-dev inkscape qt5-qmake qtbase5-dev-tools qtbase5-dev qttools5-dev-tools qtdeclarative5-dev 

## How to build
### From scratch
A script allows to clone the third parties code (i.e. positioning and navit) and rebuild all
./clone_and_build.sh
### Build
A script allows either:
to clean and rebuild all (including invoking cmake) 
./build.sh -c
or to build updated parts
./build.sh

## How to test
Some python scripts can be used for test. 
Goto ../../test/navigation
For Python, you need to install some modules
sudo apt-get install python-pip python-dbus python-gobject python-pil
sudo pip install --upgrade pip

To test, launch the navigation middleware by entering:
./run -r
test files:
./test-route-calculation.py
./test-location-input.py
./test-map-viewer-control.py
NB: there's a bug when the map is closed, so you need to restart the navigation after the last one

If everything is OK, you must see:

Test PASSED

##Directory Structure

map-viewer/
the plugins for the map rendering and manipulation (zoom, scroll..)
navigation-core/
the plugins for basic navigation features (location input, route calculation...)
poi-cam/
the plugins for poi content access module 
patches/
some patches to complete the navit code
map/
the map
navit/
basic code of navit
positioning/
the code of positioning

##Known issues

There's an issue with navit against gtk. 
If the env variable NAVIT_GRAPHICS is not set, by default the graphics are gtk based.
- for gtk, navit checks for freetype. Because of a missing symbolic link, it's necessary to do ln -s /usr/include/freetype2/ /usr/include/freetype 
- despite navit enables gtk_drawing, there's a pb during runtime (to be fixed)
So, for the time being, export NAVIT_GRAPHICS='sdl' is set into the run script

There's an issue with the svg to png  library so inkscape is used. It seems to be necessary to do:
export NO_AT_BRIDGE=1

## License

Mozilla Public License Version 2.0

