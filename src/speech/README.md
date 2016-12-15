# Speech Output Service middleware: CommonAPI based POC

## Synopsis
This folder contains the server part of the proof of concepts (POC) for the Speech Output Service interfaces, based on CommonAPI

##Tested targets
Desktop: Tested under Ubuntu 16.04 LTS 64 bits

## Prerequisites
You need CommonAPI 3.1.9 and Franca 0.9.1 installed 
For the Ubuntu 64 bits, due to the use of symbol versioning LIBDBUS_1_0 by CommonAPI-DBus, the patched version of DBus has to be >= 1.10.0
NB: In case you migrate from 3.1.5 to 3.1.9, due to a cmake issue (wrong management of micro version), it's necessary to do:
```
sudo mv /usr/local/lib/cmake/CommonAPI-3.1.5 /usr/local/lib/cmake/oldCommonAPI-3.1.5 
``` 
Symbolic links are also not well managed, so you need to fix it:
```
sudo ln -sfn /usr/local/lib/libCommonAPI.so.3.1.9 /usr/local/lib/libCommonAPI.so.3
sudo ln -sfn /usr/local/lib/libCommonAPI-DBus.so.3.1.9 /usr/local/lib/libCommonAPI-DBus.so.3
```

NB: the patch common-api-dbus-runtime/src/dbus-patches/capi-dbus-add-support-for-custom-marshalling.patch may fail a little bit, in that case it's needed to update the dbus/dbus-string.h manually

## How to build
First it's required to set some paths:
```
export DBUS_LIB_PATH=<path to the patched version of the DBus lib>
export COMMONAPI_DBUS_TOOL_DIR=<path to the common-api-dbus-tools folder>
export COMMONAPI_TOOL_DIR=<path to the common-api-tools folder> 
```
A script allows either:
to clean and rebuild all (including invoking cmake) 
```./build.sh -c```
or to build updated parts
```./build.sh```

## How To Run
```./run.sh &```

## How To Test
```./test-speech-capi.py```

## License

Mozilla Public License Version 2.0
