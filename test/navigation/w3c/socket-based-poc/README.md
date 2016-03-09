Preliminary code for testing the implementation of a set of navigation Web API based on GENIVI API 
Technology used: nodejs

To get nodejs:
sudo apt-get install nodejs npm

To build the module in C++ and install the module localy for nodejs:
cd ./node-cpp-lbs-modules 
npm build .
npm pack
cd ..
npm install node-cpp-lbs-modules/node-cpp-based-modules-0.1.0.tgz

To test:
Intall additional modules for nodejs:
npm install http url fs path webidl2 escodegen socket.io

Run the server:

nodejs server.js

In your browser open the file ./index.html

