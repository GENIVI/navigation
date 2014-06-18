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
# 18/6/2014, Philippe Colliot, APT_GET option for Fedora
#
# @licence end@

ROOT_DIR=$(CURDIR)/..
API_DIR=$(CURDIR)/../../../api
BIN_DIR=$(ROOT_DIR)/bin
COMMON_DIR=$(ROOT_DIR)/poi-common
EXE_DIR=$(BIN_DIR)
SERVER_DIR=$(CURDIR)/../../../src/poi-service/script/
QMAKE=qmake
CXX=g++
CXXFLAGS=-pipe -O2 -Wall
CHK_DIR_EXISTS=test -d
MKDIR=mkdir -p

ifndef $(APT_GET) 
	APT_GET=apt-get
endif

default: help

help::
	@echo "The following targets exist"
	@echo "all: Build $(ALL)"
	@echo "clean: Clean up build dir"
	@echo "src-clean: Clean up all checked out sources"
	@echo "all2: Get $(DEPS) and build $(ALL)"
	@echo "make APT_GET=yum for Fedora, by default APT_GET is set to apt-get"

#Clone the positioning repository for getting the API, generate the proxies and adaptors for the DBus APIs firstly
include get-positioning.mk
include generate-api.mk

include poi-supplier.mk
include poi-client.mk
include poi-contentaccess-module.mk

all: $(ALL)
	
deps::
	sudo $(APT_GET) install $(DEPS)

all2: deps all

src-clean: $(SRC_CLEAN)

clean: $(CLEAN)

