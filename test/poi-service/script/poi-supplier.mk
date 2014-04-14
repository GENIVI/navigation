# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file poi-supplier.mk
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
POI_SUPPLIER_SRC_DIR=$(ROOT_DIR)/poi-supplier
POI_SUPPLIER_COMMON_DIR=$(ROOT_DIR)/poi-common
POI_SUPPLIER_BIN_DIR=$(BIN_DIR)/poi-supplier-bin
POI_SUPPLIER_DEPS=libxml2-dev POI_SUPPLIER_LIBSqlite3-dev sqlite3
POI_SUPPLIER_INCPATH=-I$(POI_SUPPLIER_COMMON_DIR) -I$(POI_SUPPLIER_SRC_DIR) -I/usr/include/libxml++-2.6 -I/usr/lib/libxml++-2.6/include -I/usr/include/libxml2 -I/usr/include/glibmm-2.4 -I/usr/lib/i386-linux-gnu/glibmm-2.4/include -I/usr/include/glib-2.0 -I/usr/lib/i386-linux-gnu/glib-2.0/include 
POI_SUPPLIER_LIBS=-lxml++-2.6 -lxml2 -lglibmm-2.4 -lglib-2.0 -lgobject-2.0 -lsqlite3
POI_SUPPLIER_LINK=g++
POI_SUPPLIER_LFLAGS=-Wl,-O1

DEPS+=$(POI_SUPPLIER_DEPS)
ALL+=poi-supplier
CLEAN+=clean-poi-supplier

help::
	@echo "poi-supplier: Build the poi supplier"

clean-poi-supplier::
	rm -rf $(POI_SUPPLIER_BIN_DIR)
	rm -rf poi-supplier

poi-supplier: $(POI_SUPPLIER_BIN_DIR)/main.o $(POI_SUPPLIER_BIN_DIR)/database.o $(POI_SUPPLIER_BIN_DIR)/raw-file-sort.o
	$(POI_SUPPLIER_LINK) $(POI_SUPPLIER_LFLAGS) $(POI_SUPPLIER_BIN_DIR)/main.o $(POI_SUPPLIER_BIN_DIR)/database.o $(POI_SUPPLIER_BIN_DIR)/raw-file-sort.o $(POI_SUPPLIER_LIBS) -o $(EXE_DIR)/poi-supplier
	
$(POI_SUPPLIER_BIN_DIR)/main.o: $(POI_SUPPLIER_SRC_DIR)/main.cpp $(POI_SUPPLIER_SRC_DIR)/poi-datamodel.h \
		$(POI_SUPPLIER_SRC_DIR)/raw-file-sort.h \
		$(POI_SUPPLIER_SRC_DIR)/database.h
	@$(CHK_DIR_EXISTS) $(POI_SUPPLIER_BIN_DIR) || $(MKDIR) $(POI_SUPPLIER_BIN_DIR)
	$(CXX) -c $(CXXFLAGS) $(POI_SUPPLIER_INCPATH) -o $(POI_SUPPLIER_BIN_DIR)/main.o $(POI_SUPPLIER_SRC_DIR)/main.cpp

$(POI_SUPPLIER_BIN_DIR)/database.o: $(POI_SUPPLIER_SRC_DIR)/database.cpp $(POI_SUPPLIER_SRC_DIR)/database.h
	@$(CHK_DIR_EXISTS) $(POI_SUPPLIER_BIN_DIR) || $(MKDIR) $(POI_SUPPLIER_BIN_DIR)
	$(CXX) -c $(CXXFLAGS) $(POI_SUPPLIER_INCPATH) -o $(POI_SUPPLIER_BIN_DIR)/database.o $(POI_SUPPLIER_SRC_DIR)/database.cpp

$(POI_SUPPLIER_BIN_DIR)/raw-file-sort.o: $(POI_SUPPLIER_SRC_DIR)/raw-file-sort.cpp $(POI_SUPPLIER_SRC_DIR)/poi-datamodel.h \
		$(POI_SUPPLIER_SRC_DIR)/raw-file-sort.h
	$(CXX) -c $(CXXFLAGS) $(POI_SUPPLIER_INCPATH) -o $(POI_SUPPLIER_BIN_DIR)/raw-file-sort.o $(POI_SUPPLIER_SRC_DIR)/raw-file-sort.cpp

