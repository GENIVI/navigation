# W3C proof of concept

## Synopsis
This folder contains a preliminary code for testing the implementation of a set of navigation Web API based on GENIVI API. The example used is the configuration API. It's based on nodejs

##Tested targets
Desktop: Tested under Ubuntu 16.04 LTS 64 bits
nodejs version: 4.2.6

## Third parties software
For nodejs you need to install some modules:
npm install http url fs path webidl2 escodegen socket.io gcontext

### Special thanks
Thanks to Fred Chien (the node-gcontext maintainer) who has kindly and quickly updated his module to fit the nodejs version.
 
## Prerequisites
You need navigation being built and running

## How to build
To build the c++ add-on in C++ and install the module localy for nodejs:
cd ./node-cpp-lbs-modules 
make all
cd ..
npm install node-cpp-lbs-modules/node-cpp-lbs-modules-0.1.0.tgz

## How to test
Launch the navigation
nodejs server.js poll silent
In your browser open the file ./navigation-settings-language-and-units.html

##Known issues
To fix bug name of Debian (/bin/sh: 1: node: not found)
sudo apt-get install nodejs-legacy

