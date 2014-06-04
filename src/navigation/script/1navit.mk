# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file 1navit.mk
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
navit_SRC=$(SRC_DIR)/navit
navit_SRC2=$(navit_SRC)/navit
navit_BIN=$(BIN_DIR)/navit
navit_URL=http://git.navit-project.org/navit.git
navit_VERSION=6d7a8e00a67e133981e322ad13a60c9a6a9896de
navit_DEPS=gtk2.0-dev

DEPS+=$(navit_DEPS)
ALL+=navit navit_map
SRC_CLEAN+=clean-navit_SRC

help::
	@echo "navit: Build navit"
	@echo "navit_map: Download and install navit map"

clean-navit_SRC::
	rm -rf $(navit_SRC)

navit: $(navit_BIN)/navit/navit

$(navit_BIN)/navit/navit: $(navit_BIN)/Makefile
	make -C $(navit_BIN)

$(navit_BIN)/Makefile: $(navit_SRC2)/CMakeLists.txt
	mkdir -p $(navit_BIN)
	cd $(navit_BIN) && cmake -DSAMPLE_MAP=0 -Dvehicle/null=1 -Dgraphics/qt_qpainter=0 $(navit_SRC2)

$(navit_SRC2)/CMakeLists.txt:
	cd $(navit_SRC)/.. && git clone $(navit_URL)
	cd $(navit_SRC) && git checkout $(navit_VERSION)

navit_map: $(navit_BIN)/navit/maps/switzerland.xml

$(navit_BIN)/navit/maps/switzerland.xml: $(MAP_DIR)/switzerland.bin
	echo '<map type="binfile" data="$(MAP_DIR)/switzerland.bin" />' >$(navit_BIN)/navit/maps/switzerland.xml

$(MAP_DIR)/switzerland.bin:
	mkdir -p $(MAP_DIR)
	wget -O $(MAP_DIR)/switzerland.bin.tmp http://www.navit-project.org/switzerland.bin
	mv $(MAP_DIR)/switzerland.bin.tmp $(MAP_DIR)/switzerland.bin
