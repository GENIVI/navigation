# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file poi-cam.mk
#
# \brief This file is part of the Build System.
#
# \author Martin Schaller <martin.schaller@it-schaller.de>
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
poiservice_SRC=$(SRC_DIR)/poi-cam
poiservice_BIN=$(BIN_DIR)/poi-cam
poi-service_API=

ifneq ($(poi-service_API),)
ALL+=poiservice

help::
	@echo "poiservice: Build poiservice module"

poiservice: $(poiservice_BIN)/.libs/libgenivi_poiservice_configuration.so

$(poiservice_BIN)/.libs/libgenivi_poiservice_configuration.so: $(poiservice_BIN)/Makefile $(CONSTANTS_BIN)/genivi-poiservice-constants.h
	make -C $(poiservice_BIN)
$(poiservice_BIN)/Makefile: $(poiservice_SRC)/CMakeLists.txt
	mkdir -p $(poiservice_BIN)
	cd $(poiservice_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dpoi-service_API=$(poi-service_API) $(poiservice_SRC)

$(CONSTANTS_BIN)/genivi-poiservice-constants.h: $(poi-service_API)/genivi-poiservice-constants.xml $(poi-service_API)/enum.xsl
	mkdir -p $(CONSTANTS_BIN)
	xsltproc $(poi-service_API)/enum.xsl $(poi-service_API)/genivi-poiservice-constants.xml >$(CONSTANTS_BIN)/genivi-poiservice-constants.h
endif
