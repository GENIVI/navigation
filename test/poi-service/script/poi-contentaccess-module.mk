# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file poi-contentaccess-module.mk
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
POI_CONTENTACCESS_MODULE_SRC_DIR=$(ROOT_DIR)/poi-contentaccess-module
POI_CONTENTACCESS_MODULE_DEPS=qt4-qmlviewer libqt5widgets5 libqt5dbus5 libqt5core5a libqt5gui5 libsqlite3-dev sqlite3 qtbase5-dev-tools
POI_CONTENTACCESS_MODULE_BIN_DIR=$(BIN_DIR)/poi-contentaccess-module-bin

DEPS+=$(POI_CONTENTACCESS_MODULE_DEPS)
ALL+=poi-contentaccess-module
CLEAN+=clean-poi-contentaccess-module

help::
	@echo "poi-contentaccess-module: Build the poi content access module"

clean-poi-contentaccess-module::
	rm -rf $(POI_CONTENTACCESS_MODULE_BIN_DIR)
	rm -rf poi-contentaccess-module

poi-contentaccess-module: $(POI_CONTENTACCESS_MODULE_BIN_DIR)/Makefile-poi-contentaccess-module
	$(MAKE) -C $(POI_CONTENTACCESS_MODULE_BIN_DIR)
	mv $(POI_CONTENTACCESS_MODULE_BIN_DIR)/poi-contentaccess-module $(EXE_DIR)

$(POI_CONTENTACCESS_MODULE_BIN_DIR)/Makefile-poi-contentaccess-module: $(POI_CONTENTACCESS_MODULE_SRC_DIR)/poi-contentaccess-module.pro 
	@$(CHK_DIR_EXISTS) $(POI_CONTENTACCESS_MODULE_BIN_DIR) || $(MKDIR) $(POI_CONTENTACCESS_MODULE_BIN_DIR)
	cd $(POI_CONTENTACCESS_MODULE_BIN_DIR) && $(QMAKE) $(POI_CONTENTACCESS_MODULE_SRC_DIR)/poi-contentaccess-module.pro

