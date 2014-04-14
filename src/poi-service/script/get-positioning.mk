# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file get-positioning.mk
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
positioning_SRC=$(ROOT_DIR)/positioning
positioning_API=$(positioning_SRC)/enhanced-position-service/api
positioning_URL=https://git.genivi.org/srv/git/positioning
positioning_VERSION=7cd257d8fdfcd35ca4d0757cc269c2f9925009a0

ALL+=positioning

help::
	@echo "positioning: Get positioning"


positioning: $(positioning_API)/genivi-positioning-enhancedposition.xml


$(positioning_API)/genivi-positioning-enhancedposition.xml:
	cd $(positioning_SRC)/.. && git clone $(positioning_URL)
	cd $(positioning_SRC) && git checkout $(positioning_VERSION)
