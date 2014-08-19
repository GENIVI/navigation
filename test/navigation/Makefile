# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file Makefile
#
# \brief This file is part of the Build System.
#
# \author Philippe Colliot <philippe.colliot@mpsa.com>
#
# \version 1.
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
# 19/8/2014, Philippe Colliot, creation
#
# @licence end@

SRC_DIR=$(CURDIR)/src
PATCH_DIR=$(CURDIR)/patches
BIN_DIR=$(CURDIR)/bin

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
	sudo apt-get install $(DEPS)

all2: deps all

clean:
	rm -rf $(BIN_DIR)
