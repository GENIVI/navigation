# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file poi-server.mk
#
# \brief This file is part of the Build System.
#
# \author Philippe Colliot <philippe.colliot@mpsa.com>
#
# \version 1.0
#
# This Source Code Form is subject to the terms of the
# Mozilla Public License (MPL), v. 2.0.
# If a copy of the MPL was not distributed with this file,
# You can obtain one at http://mozilla.org/MPL/2.0/.
#
# For further information see http://www.genivi.org/.
#
# List of changes:
# 
# <date>, <name>, <description of change>
#
# @licence end@
POI_SERVER_SRC_DIR=$(ROOT_DIR)/poi-server
POI_SERVER_BIN_DIR=$(BIN_DIR)/poi-server-bin
POI_SERVER_DEPS=libsqlite3-dev sqlite3
POI_SERVER_INCPATH=-I$(COMMON_DIR) -I$(POI_SERVER_SRC_DIR) -I/usr/include/glibmm-2.4 -I/usr/lib/i386-linux-gnu/glibmm-2.4/include -I/usr/include/glib-2.0 -I/usr/lib/i386-linux-gnu/glib-2.0/include -I/usr/include/dbus-c++-1 -I/usr/include/dbus-1.0 -I/usr/lib/i386-linux-gnu/dbus-1.0/include
POI_SERVER_LIBS=-lglibmm-2.4 -lglib-2.0 -lgobject-2.0 -lsqlite3 -ldbus-c++-glib-1 -ldbus-c++-1 -ldbus-1 
POI_SERVER_LINK=g++
POI_SERVER_LFLAGS=-Wl,-O1

DEPS+=$(POI_SERVER_DEPS)
ALL+=poi-server
CLEAN+=clean-poi-server

help::
	@echo "poi-server: Build the poi server"

clean-poi-server::
	rm -rf $(POI_SERVER_BIN_DIR)
	rm -rf $(BIN_DIR)/poi-server

poi-server: $(POI_SERVER_BIN_DIR)/main.o $(POI_SERVER_BIN_DIR)/database.o
	$(POI_SERVER_LINK) $(POI_SERVER_LFLAGS) $(POI_SERVER_BIN_DIR)/main.o $(POI_SERVER_BIN_DIR)/database.o $(POI_SERVER_LIBS) -o $(EXE_DIR)/poi-server
	
$(POI_SERVER_BIN_DIR)/main.o: $(POI_SERVER_SRC_DIR)/main.cpp $(POI_SERVER_SRC_DIR)/poi-server-class.h \
		$(COMMON_DIR)/genivi-positioning-constants.h \
		$(COMMON_DIR)/genivi-mapviewer-constants.h \
		$(COMMON_DIR)/genivi-navigationcore-constants.h \
		$(COMMON_DIR)/genivi-poiservice-constants.h \
		$(COMMON_DIR)/genivi-poiservice-poisearch_adaptor.h \
		$(COMMON_DIR)/genivi-poiservice-poicontentaccess_adaptor.h \
		$(COMMON_DIR)/genivi-navigationcore-routing_proxy.h \
		$(COMMON_DIR)/genivi-positioning-enhancedposition_proxy.h \
		$(COMMON_DIR)/genivi-poiservice-contentaccessmodule_proxy.h \
		$(COMMON_DIR)/common-data-model.h \
		$(POI_SERVER_SRC_DIR)/poi-datamodel.h \
		$(POI_SERVER_SRC_DIR)/database.h
	@$(CHK_DIR_EXISTS) $(POI_SERVER_BIN_DIR) || $(MKDIR) $(POI_SERVER_BIN_DIR)
	$(CXX) -c $(CXXFLAGS) $(POI_SERVER_INCPATH) -o $(POI_SERVER_BIN_DIR)/main.o $(POI_SERVER_SRC_DIR)/main.cpp

$(POI_SERVER_BIN_DIR)/database.o: $(POI_SERVER_SRC_DIR)/database.cpp $(POI_SERVER_SRC_DIR)/database.h
	@$(CHK_DIR_EXISTS) $(POI_SERVER_BIN_DIR) || $(MKDIR) $(POI_SERVER_BIN_DIR)
	$(CXX) -c $(CXXFLAGS) $(POI_SERVER_INCPATH) -o $(POI_SERVER_BIN_DIR)/database.o $(POI_SERVER_SRC_DIR)/database.cpp


