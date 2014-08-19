# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file bustle.mk
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
bustle_URL="http://anongit.freedesktop.org/git/bustle.git"
bustle_VERSION=61ac45d195476edb810a1c2345c886fdc51a20cc
bustle_SRC=$(SRC_DIR)/bustle_$(bustle_VERSION)
bustle_BIN=$(BIN_DIR)/bustle
bustle_DEPS+= gtk2.0-dev haskell-platform libghc-gtk-dev libghc-glade-dev libpcap-dev language-pack-de language-pack-fr gtk2hs-buildtools libdbus-1-dev

DEPS+=$(bustle_DEPS)
ALL+=bustle
SRC_CLEAN+=clean-bustle_SRC

help::
	@echo "bustle: Build bustle with patches"

clean-bustle_SRC::
	rm -rf $(SRC_DIR)/bustle_*

$(bustle_SRC)/Makefile:
	cd $(bustle_SRC)/.. && git clone $(bustle_URL) $(bustle_SRC)
	cd $(bustle_SRC) && git checkout $(bustle_VERSION)

$(bustle_SRC)/.patched: $(bustle_SRC)/Makefile
	patch -d $(bustle_SRC) -p1 -s <$(PATCH_DIR)/bustle_filter.patch
	touch $(bustle_SRC)/.patched

$(HOME)/.cabal/packages/hackage.haskell.org/00-index.tar:
	cabal update

$(bustle_BIN)/bustle: $(bustle_SRC)/.patched $(HOME)/.cabal/packages/hackage.haskell.org/00-index.tar
	cd $(bustle_SRC) && cabal install --builddir=$(bustle_BIN) && cabal build --builddir=$(bustle_BIN)

bustle: $(bustle_BIN)/bustle

