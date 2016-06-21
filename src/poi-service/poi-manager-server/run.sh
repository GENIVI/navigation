#!/bin/bash
RESOURCE=../resource
cp $RESOURCE/poi-database-managed.db ./bin
COMMONAPI_DEFAULT_CONFIG=$RESOURCE/commonapi4dbus.ini \
COMMONAPI_DBUS_DEFAULT_CONFIG=$RESOURCE/commonapi-dbus.ini \
./bin/poi-manager-server -f ./bin/poi-database-managed.db &
