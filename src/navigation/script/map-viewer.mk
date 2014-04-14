# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file map-viewer.mk
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
mapviewer_SRC=$(SRC_DIR)/map-viewer
mapviewer_API=$(API_DIR)/map-viewer
mapviewer-configuration_SRC=$(mapviewer_SRC)/configuration-plugin
mapviewer-configuration_BIN=$(BIN_DIR)/mapviewer-configuration
mapviewer-mapviewercontrol_SRC=$(mapviewer_SRC)/mapviewercontrol-plugin
mapviewer-mapviewercontrol_BIN=$(BIN_DIR)/mapviewer-mapviewercontrol
mapviewer-session_SRC=$(mapviewer_SRC)/session-plugin
mapviewer-session_BIN=$(BIN_DIR)/mapviewer-session

ALL+=mapviewer

help::
	@echo "mapviewer: Build all mapviewer modules"
	@echo "mapviewer-configuration: Build mapviewer configuration module"
	@echo "mapviewer-mapviewercontrol: Build mapviewer mapviewercontrol module"
	@echo "mapviewer-session: Build mapviewer session module"


mapviewer: mapviewer-configuration mapviewer-mapviewercontrol mapviewer-session $(navit_BIN)/navit/navit_genivi_mapviewer.xml


$(navit_BIN)/navit/navit_genivi_mapviewer.xml: $(mapviewer_SRC)/navit_genivi_mapviewer.xsl $(navit_SRC2)/navit/navit_shipped.xml
	xsltproc $(mapviewer_SRC)/navit_genivi_mapviewer.xsl $(navit_SRC2)/navit/navit_shipped.xml > $(navit_BIN)/navit/navit_genivi_mapviewer.xml

mapviewer-configuration: $(mapviewer-configuration_BIN)/.libs/libgenivi_mapviewer_configuration.so

$(mapviewer-configuration_BIN)/.libs/libgenivi_mapviewer_configuration.so: $(mapviewer-configuration_BIN)/Makefile $(CONSTANTS_BIN)/genivi-mapviewer-constants.h
	make -C $(mapviewer-configuration_BIN)
$(mapviewer-configuration_BIN)/Makefile: $(mapviewer-configuration_SRC)/CMakeLists.txt
	mkdir -p $(mapviewer-configuration_BIN)
	cd $(mapviewer-configuration_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dmapviewer_API=$(mapviewer_API) $(mapviewer-configuration_SRC)

mapviewer-mapviewercontrol: $(mapviewer-mapviewercontrol_BIN)/.libs/libgenivi_mapviewer_mapviewercontrol.so 
$(mapviewer-mapviewercontrol_BIN)/.libs/libgenivi_mapviewer_mapviewercontrol.so: $(mapviewer-mapviewercontrol_BIN)/Makefile $(CONSTANTS_BIN)/genivi-mapviewer-constants.h $(CONSTANTS_BIN)/genivi-navigationcore-constants.h
	make -C $(mapviewer-mapviewercontrol_BIN)
$(mapviewer-mapviewercontrol_BIN)/Makefile: $(mapviewer-mapviewercontrol_SRC)/CMakeLists.txt
	mkdir -p $(mapviewer-mapviewercontrol_BIN)
	cd $(mapviewer-mapviewercontrol_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dlayer_management_INST=$(layer_management_INST) -Dmapviewer_API=$(mapviewer_API) -Dnavigationcore_API=$(navigationcore_API) $(mapviewer-mapviewercontrol_SRC)

mapviewer-session: $(mapviewer-session_BIN)/.libs/libgenivi_mapviewer_session.so
$(mapviewer-session_BIN)/.libs/libgenivi_mapviewer_session.so: $(mapviewer-session_BIN)/Makefile $(CONSTANTS_BIN)/genivi-mapviewer-constants.h
	make -C $(mapviewer-session_BIN)
$(mapviewer-session_BIN)/Makefile: $(mapviewer-session_SRC)/CMakeLists.txt
	mkdir -p $(mapviewer-session_BIN)
	cd $(mapviewer-session_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dmapviewer_API=$(mapviewer_API) $(mapviewer-session_SRC)

$(CONSTANTS_BIN)/genivi-mapviewer-constants.h: $(mapviewer_API)/genivi-mapviewer-constants.xml $(mapviewer_API)/enum.xsl
	mkdir -p $(CONSTANTS_BIN)
	xsltproc $(mapviewer_API)/enum.xsl $(mapviewer_API)/genivi-mapviewer-constants.xml >$(CONSTANTS_BIN)/genivi-mapviewer-constants.h
