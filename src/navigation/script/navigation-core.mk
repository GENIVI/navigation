# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file navigation-core.mk
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
navigationcore_SRC=$(SRC_DIR)/navigation-core
navigationcore_API=$(API_DIR)/navigation-core
navigationcore-configuration_SRC=$(navigationcore_SRC)/configuration-plugin
navigationcore-configuration_BIN=$(BIN_DIR)/navigationcore-configuration
navigationcore-guidance_SRC=$(navigationcore_SRC)/guidance-plugin
navigationcore-guidance_BIN=$(BIN_DIR)/navigationcore-guidance
navigationcore-locationinput_SRC=$(navigationcore_SRC)/locationinput-plugin
navigationcore-locationinput_BIN=$(BIN_DIR)/navigationcore-locationinput
navigationcore-mapmatchedposition_SRC=$(navigationcore_SRC)/mapmatchedposition-plugin
navigationcore-mapmatchedposition_BIN=$(BIN_DIR)/navigationcore-mapmatchedposition
navigationcore-routing_SRC=$(navigationcore_SRC)/routing-plugin
navigationcore-routing_BIN=$(BIN_DIR)/navigationcore-routing
navigationcore-session_SRC=$(navigationcore_SRC)/session-plugin
navigationcore-session_BIN=$(BIN_DIR)/navigationcore-session
navigationcore-enhancedposition_SRC=$(navigationcore_SRC)/enhancedposition-plugin
navigationcore-enhancedposition_BIN=$(BIN_DIR)/navigationcore-enhancedposition

ALL+=navigationcore

help::
	@echo "navigationcore: Build all navigationcore modules"
	@echo "navigationcore-configuration: Build navigationcore configuration module"
	@echo "navigationcore-guidance: Build navigationcore guidance module"
	@echo "navigationcore-locationinput: Build navigationcore locationinput module"
	@echo "navigationcore-mapmatchedposition: Build navigationcore mapmatchedposition module"
	@echo "navigationcore-routing: Build navigationcore routing module"
	@echo "navigationcore-session: Build navigationcore session module"
	@echo "navigationcore-enhancedposition: Build navigationcore enhancedposition module"

navigationcore: navigationcore-configuration navigationcore-guidance navigationcore-locationinput navigationcore-mapmatchedposition navigationcore-routing navigationcore-session navigationcore-enhancedposition $(navit_BIN)/navit/navit_genivi_navigationcore.xml

$(navit_BIN)/navit/navit_genivi_navigationcore.xml: $(navigationcore_SRC)/navit_genivi_navigationcore.xsl $(navit_SRC2)/navit/navit_shipped.xml
	xsltproc $(navigationcore_SRC)/navit_genivi_navigationcore.xsl $(navit_SRC2)/navit/navit_shipped.xml > $(navit_BIN)/navit/navit_genivi_navigationcore.xml

$(CONSTANTS_BIN)/genivi-navigationcore-constants.h: $(navigationcore_API)/genivi-navigationcore-constants.xml $(navigationcore_API)/enum.xsl
	mkdir -p $(CONSTANTS_BIN)
	xsltproc $(navigationcore_API)/enum.xsl $(navigationcore_API)/genivi-navigationcore-constants.xml >$(CONSTANTS_BIN)/genivi-navigationcore-constants.h

$(CONSTANTS_BIN)/genivi-enhancedpositionservice-constants.h: positioning $(positioning_API)/genivi-positioning-constants.xml $(navigationcore_API)/enum.xsl
	mkdir -p $(CONSTANTS_BIN)
	xsltproc $(navigationcore_API)/enum.xsl $(positioning_API)/genivi-positioning-constants.xml >$(CONSTANTS_BIN)/genivi-enhancedpositionservice-constants.h

navigationcore-configuration: $(navigationcore-configuration_BIN)/.libs/libgenivi-navigationcore-configuration.so 

navigationcore-configuration: $(navigationcore-configuration_BIN)/.libs/libgenivi-navigationcore-configuration.so 
$(navigationcore-configuration_BIN)/.libs/libgenivi-navigationcore-configuration.so: $(navigationcore-configuration_BIN)/Makefile
	make -C $(navigationcore-configuration_BIN)
$(navigationcore-configuration_BIN)/Makefile: $(navigationcore-configuration_SRC)/CMakeLists.txt $(CONSTANTS_BIN)/genivi-navigationcore-constants.h
	mkdir -p $(navigationcore-configuration_BIN)
	cd $(navigationcore-configuration_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dnavigationcore_API=$(navigationcore_API) $(navigationcore-configuration_SRC)

navigationcore-guidance: $(navigationcore-guidance_BIN)/.libs/libgenivi-navigationcore-guidance.so
$(navigationcore-guidance_BIN)/.libs/libgenivi-navigationcore-guidance.so: $(navigationcore-guidance_BIN)/Makefile
	make -C $(navigationcore-guidance_BIN)
$(navigationcore-guidance_BIN)/Makefile: $(navigationcore-guidance_SRC)/CMakeLists.txt $(CONSTANTS_BIN)/genivi-navigationcore-constants.h
	mkdir -p $(navigationcore-guidance_BIN)
	cd $(navigationcore-guidance_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dnavigationcore_API=$(navigationcore_API) $(navigationcore-guidance_SRC)

navigationcore-locationinput: $(navigationcore-locationinput_BIN)/.libs/libgenivi-navigationcore-locationinput.so
$(navigationcore-locationinput_BIN)/.libs/libgenivi-navigationcore-locationinput.so: $(navigationcore-locationinput_BIN)/Makefile
	make -C $(navigationcore-locationinput_BIN)
$(navigationcore-locationinput_BIN)/Makefile: $(navigationcore-locationinput_SRC)/CMakeLists.txt $(CONSTANTS_BIN)/genivi-navigationcore-constants.h
	mkdir -p $(navigationcore-locationinput_BIN)
	cd $(navigationcore-locationinput_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dnavigationcore_API=$(navigationcore_API) $(navigationcore-locationinput_SRC)

navigationcore-mapmatchedposition: $(navigationcore-mapmatchedposition_BIN)/.libs/libgenivi-navigationcore-mapmatchedposition.so
$(navigationcore-mapmatchedposition_BIN)/.libs/libgenivi-navigationcore-mapmatchedposition.so: $(navigationcore-mapmatchedposition_BIN)/Makefile
	make -C $(navigationcore-mapmatchedposition_BIN)
$(navigationcore-mapmatchedposition_BIN)/Makefile: $(navigationcore-mapmatchedposition_SRC)/CMakeLists.txt $(CONSTANTS_BIN)/genivi-navigationcore-constants.h
	mkdir -p $(navigationcore-mapmatchedposition_BIN)
	cd $(navigationcore-mapmatchedposition_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dnavigationcore_API=$(navigationcore_API) $(navigationcore-mapmatchedposition_SRC)

navigationcore-routing: $(navigationcore-routing_BIN)/.libs/libgenivi-navigationcore-routing.so
$(navigationcore-routing_BIN)/.libs/libgenivi-navigationcore-routing.so: $(navigationcore-routing_BIN)/Makefile
	make -C $(navigationcore-routing_BIN)
$(navigationcore-routing_BIN)/Makefile: $(navigationcore-routing_SRC)/CMakeLists.txt $(CONSTANTS_BIN)/genivi-navigationcore-constants.h
	mkdir -p $(navigationcore-routing_BIN)
	cd $(navigationcore-routing_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dnavigationcore_API=$(navigationcore_API) $(navigationcore-routing_SRC)

navigationcore-session: $(navigationcore-session_BIN)/.libs/libgenivi-navigationcore-session.so
$(navigationcore-session_BIN)/.libs/libgenivi-navigationcore-session.so: $(navigationcore-session_BIN)/Makefile
	make -C $(navigationcore-session_BIN)
$(navigationcore-session_BIN)/Makefile: $(navigationcore-session_SRC)/CMakeLists.txt $(CONSTANTS_BIN)/genivi-navigationcore-constants.h
	mkdir -p $(navigationcore-session_BIN)
	cd $(navigationcore-session_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dnavigationcore_API=$(navigationcore_API) $(navigationcore-session_SRC)

# NOTE: extended by thomas.bader@bmw.de
navigationcore-enhancedposition: $(navigationcore-enhancedposition_BIN)/.libs/libgenivi_positioning_enhancedposition.so

$(navigationcore-enhancedposition_BIN)/.libs/libgenivi_positioning_enhancedposition.so: $(navigationcore-enhancedposition_BIN)/Makefile
	make -C $(navigationcore-enhancedposition_BIN)

$(navigationcore-enhancedposition_BIN)/Makefile: $(navigationcore-enhancedposition_SRC)/CMakeLists.txt $(CONSTANTS_BIN)/genivi-navigationcore-constants.h $(CONSTANTS_BIN)/genivi-enhancedpositionservice-constants.h
	mkdir -p $(navigationcore-enhancedposition_BIN)
	cd $(navigationcore-enhancedposition_BIN) && cmake -C $(navit_BIN)/cmake_plugin_settings.txt -Dpositioning_API=$(positioning_API) $(navigationcore-enhancedposition_SRC)
