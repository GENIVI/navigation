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
# 4/6/2014, Philippe Colliot, complete src-clean option
#
# @licence end@

ROOT_DIR=$(CURDIR)/..
API_DIR=$(CURDIR)/../../../api
BIN_DIR=$(ROOT_DIR)/bin
COMMON_DIR=$(ROOT_DIR)/poi-common
EXE_DIR=$(BIN_DIR)
QMAKE=qmake
CXX=g++
CXXFLAGS=-pipe -O2 -Wall
CHK_DIR_EXISTS=test -d
MKDIR=mkdir -p

default: help

help::
	@echo "The following targets exist"
	@echo "all: Build $(ALL)"
	@echo "clean: Clean up build dir"
	@echo "src-clean: Clean up all checked out sources"

#Clone the positioning repository for getting the API, generate the proxies and adaptors for the DBus APIs firstly
include get-positioning.mk
include generate-api.mk

include poi-server.mk

all: $(ALL)

src-clean: $(SRC_CLEAN)

deps::
	sudo apt-get install $(DEPS)

all2: deps all

clean: $(CLEAN)


