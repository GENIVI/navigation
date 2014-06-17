# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file Makefile
#
# \brief This file is part of the Build System.
#
# \author Martin Schaller <martin.schaller@it-schaller.de>
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
# 4/6/2014, Philippe Colliot, complete src-clean option
#
# @licence end@
SRC_DIR=$(CURDIR)/../../navigation
PATCH_DIR=$(SRC_DIR)/patches
API_DIR=$(CURDIR)/../../../api
BIN_DIR=$(CURDIR)/../bin
MAP_DIR=$(CURDIR)/../../map
CONSTANTS_BIN=$(BIN_DIR)/constants

QMAKE=qmake
APT_GET=apt-get

default: help

help::
	@echo "The following targets exist"
	@echo "all: Build $(ALL)"
	@echo "all2: Install all necessary dependencies and build all"
	@echo "clean: Clean up build dir"
	@echo "src-clean: Clean up all checked out sources"


include *.mk

all: $(ALL)

src-clean: $(SRC_CLEAN)

deps::
	sudo $(APT_GET) install $(DEPS)
	# See https://bugs.launchpad.net/ubuntu/+source/freetype/+bug/1319642 why this is necessary
	[ -e /usr/include/freetype2/freetype ] || sudo ln -s . /usr/include/freetype2/freetype


all2: deps all

navit-plugins: all

clean:
	rm -rf $(BIN_DIR)
