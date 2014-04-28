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
# 28-04-2014, Philippe Colliot, link to the public repos of positioning, add clean feature
# 
# @licence end@
positioning_SRC=$(ROOT_DIR)/positioning
positioning_API=$(positioning_SRC)/enhanced-position-service/api
positioning_URL=http://git.projects.genivi.org/lbs/positioning.git
positioning_VERSION=183d134e734e157c498f6cff367d104e4c5ad670

ALL+=positioning
CLEAN+=clean-get-positioning

help::
	@echo "positioning: Get positioning"

positioning: $(positioning_API)/genivi-positioning-enhancedposition.xml

clean-get-positioning:: 
	rm -rf $(positioning_SRC)

$(positioning_API)/genivi-positioning-enhancedposition.xml:
	cd $(positioning_SRC)/.. && git clone $(positioning_URL)
	cd $(positioning_SRC) && git checkout $(positioning_VERSION)
