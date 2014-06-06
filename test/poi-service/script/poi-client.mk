# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file poi-client.mk
#
# \brief This file is part of the Build System.
#
# \author Philippe Colliot <philippe.colliot@mpsa.com>
#
# \version 1.1
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
# 04/06/2014, Philippe Colliot, Migration to Qt5.2
#
# @licence end@
POI_CLIENT_SRC_DIR=$(ROOT_DIR)/poi-client
POI_CLIENT_DEPS=qt4-qmlviewer libqt5widgets5 libqt5dbus5 libqt5core5a libqt5gui5 qtbase5-dev-tools
POI_CLIENT_BIN_DIR=$(BIN_DIR)/poi-client-bin

DEPS+=$(POI_CLIENT_DEPS)
ALL+=poi-client
CLEAN+=clean-poi-client

help::
	@echo "poi-client: Build the poi client"

clean-poi-client::
	rm -rf $(POI_CLIENT_BIN_DIR)
	rm -rf poi-client

poi-client: $(POI_CLIENT_BIN_DIR)/Makefile-poi-client
	$(MAKE) -C $(POI_CLIENT_BIN_DIR)
	mv $(POI_CLIENT_BIN_DIR)/poi-client $(EXE_DIR)

$(POI_CLIENT_BIN_DIR)/Makefile-poi-client: $(POI_CLIENT_SRC_DIR)/poi-client.pro 
	@$(CHK_DIR_EXISTS) $(POI_CLIENT_BIN_DIR) || $(MKDIR) $(POI_CLIENT_BIN_DIR)
	cd $(POI_CLIENT_BIN_DIR) && $(QMAKE) $(POI_CLIENT_SRC_DIR)/poi-client.pro

