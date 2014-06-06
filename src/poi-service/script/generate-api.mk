# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
#
# \file generate-api.mk
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
COMMON_DIR=$(ROOT_DIR)/poi-common
TARGET_GENERATED_API_DIR=$(COMMON_DIR)
GENERATE_API_DEPS=libdbus-c++-dev xsltproc

ALL+=generate-api
CLEAN+=clean-generate-api
DEPS+=$(GENERATE_API_DEPS)

help::
	@echo "generate-api: Generate the proxies and adaptors"

generate-api: generate-api-poi generate-api-other

clean-generate-api:: 
	rm -rf ${TARGET_GENERATED_API_DIR}/*_adaptor.h
	rm -rf ${TARGET_GENERATED_API_DIR}/*_proxy.h
	rm -rf ${TARGET_GENERATED_API_DIR}/*_constants.h

generate-api-poi:: ${TARGET_GENERATED_API_DIR}/genivi-poiservice-contentaccessmodule_adaptor.h ${TARGET_GENERATED_API_DIR}/genivi-poiservice-contentaccessmodule_proxy.h ${TARGET_GENERATED_API_DIR}/genivi-poiservice-poicontentaccess_adaptor.h ${TARGET_GENERATED_API_DIR}/genivi-poiservice-poicontentaccess_proxy.h ${TARGET_GENERATED_API_DIR}/genivi-poiservice-poisearch_adaptor.h ${TARGET_GENERATED_API_DIR}/genivi-poiservice-poisearch_proxy.h ${TARGET_GENERATED_API_DIR}/genivi-poiservice-constants.h

${TARGET_GENERATED_API_DIR}/genivi-poiservice-contentaccessmodule_adaptor.h: ${API_DIR}/poi-service/genivi-poiservice-contentaccessmodule.xml 
	dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-contentaccessmodule.xml --adaptor=${TARGET_GENERATED_API_DIR}/genivi-poiservice-contentaccessmodule_adaptor.h

${TARGET_GENERATED_API_DIR}/genivi-poiservice-contentaccessmodule_proxy.h: ${API_DIR}/poi-service/genivi-poiservice-contentaccessmodule.xml 	
	dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-contentaccessmodule.xml --proxy=${TARGET_GENERATED_API_DIR}/genivi-poiservice-contentaccessmodule_proxy.h

${TARGET_GENERATED_API_DIR}/genivi-poiservice-poicontentaccess_adaptor.h: ${API_DIR}/poi-service/genivi-poiservice-poicontentaccess.xml 
	dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-poicontentaccess.xml --adaptor=${TARGET_GENERATED_API_DIR}/genivi-poiservice-poicontentaccess_adaptor.h

${TARGET_GENERATED_API_DIR}/genivi-poiservice-poicontentaccess_proxy.h: ${API_DIR}/poi-service/genivi-poiservice-poicontentaccess.xml 
	dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-poicontentaccess.xml --proxy=${TARGET_GENERATED_API_DIR}/genivi-poiservice-poicontentaccess_proxy.h

${TARGET_GENERATED_API_DIR}/genivi-poiservice-poisearch_adaptor.h: ${API_DIR}/poi-service/genivi-poiservice-poisearch.xml
	dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-poisearch.xml --adaptor=${TARGET_GENERATED_API_DIR}/genivi-poiservice-poisearch_adaptor.h

${TARGET_GENERATED_API_DIR}/genivi-poiservice-poisearch_proxy.h: ${API_DIR}/poi-service/genivi-poiservice-poisearch.xml
	dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-poisearch.xml --proxy=${TARGET_GENERATED_API_DIR}/genivi-poiservice-poisearch_proxy.h

${TARGET_GENERATED_API_DIR}/genivi-poiservice-constants.h: ${API_DIR}/poi-service/genivi-poiservice-constants.xml 
	xsltproc ${API_DIR}/poi-service/enum.xsl ${API_DIR}/poi-service/genivi-poiservice-constants.xml > ${TARGET_GENERATED_API_DIR}/genivi-poiservice-constants.h

generate-api-other:: ${TARGET_GENERATED_API_DIR}/genivi-navigationcore-guidance_adaptor.h ${TARGET_GENERATED_API_DIR}/genivi-navigationcore-guidance_proxy.h ${TARGET_GENERATED_API_DIR}/genivi-navigationcore-routing_adaptor.h ${TARGET_GENERATED_API_DIR}/genivi-navigationcore-routing_proxy.h ${TARGET_GENERATED_API_DIR}/genivi-positioning-enhancedposition_adaptor.h ${TARGET_GENERATED_API_DIR}/genivi-positioning-enhancedposition_proxy.h ${TARGET_GENERATED_API_DIR}/genivi-navigationcore-constants.h ${TARGET_GENERATED_API_DIR}/genivi-positioning-constants.h ${TARGET_GENERATED_API_DIR}/genivi-mapviewer-constants.h

${TARGET_GENERATED_API_DIR}/genivi-navigationcore-guidance_adaptor.h: ${API_DIR}/navigation-core/genivi-navigationcore-guidance.xml
	dbusxx-xml2cpp ${API_DIR}/navigation-core/genivi-navigationcore-guidance.xml --adaptor=${TARGET_GENERATED_API_DIR}/genivi-navigationcore-guidance_adaptor.h

${TARGET_GENERATED_API_DIR}/genivi-navigationcore-guidance_proxy.h: ${API_DIR}/navigation-core/genivi-navigationcore-guidance.xml
	dbusxx-xml2cpp ${API_DIR}/navigation-core/genivi-navigationcore-guidance.xml --proxy=${TARGET_GENERATED_API_DIR}/genivi-navigationcore-guidance_proxy.h

${TARGET_GENERATED_API_DIR}/genivi-navigationcore-routing_adaptor.h: ${API_DIR}/navigation-core/genivi-navigationcore-routing.xml
	dbusxx-xml2cpp ${API_DIR}/navigation-core/genivi-navigationcore-routing.xml --adaptor=${TARGET_GENERATED_API_DIR}/genivi-navigationcore-routing_adaptor.h

${TARGET_GENERATED_API_DIR}/genivi-navigationcore-routing_proxy.h: ${API_DIR}/navigation-core/genivi-navigationcore-routing.xml
	dbusxx-xml2cpp ${API_DIR}/navigation-core/genivi-navigationcore-routing.xml --proxy=${TARGET_GENERATED_API_DIR}/genivi-navigationcore-routing_proxy.h

${TARGET_GENERATED_API_DIR}/genivi-positioning-enhancedposition_adaptor.h: ${positioning_API}/genivi-positioning-enhancedposition.xml
	dbusxx-xml2cpp ${positioning_API}/genivi-positioning-enhancedposition.xml --adaptor=${TARGET_GENERATED_API_DIR}/genivi-positioning-enhancedposition_adaptor.h

${TARGET_GENERATED_API_DIR}/genivi-positioning-enhancedposition_proxy.h: ${positioning_API}/genivi-positioning-enhancedposition.xml
	dbusxx-xml2cpp ${positioning_API}/genivi-positioning-enhancedposition.xml --proxy=${TARGET_GENERATED_API_DIR}/genivi-positioning-enhancedposition_proxy.h

${TARGET_GENERATED_API_DIR}/genivi-navigationcore-constants.h: ${API_DIR}/navigation-core/genivi-navigationcore-constants.xml
	xsltproc ${API_DIR}/navigation-core/enum.xsl ${API_DIR}/navigation-core/genivi-navigationcore-constants.xml > ${TARGET_GENERATED_API_DIR}/genivi-navigationcore-constants.h

#use the enum.xsl of navigation-core to generate the positioning constants
${TARGET_GENERATED_API_DIR}/genivi-positioning-constants.h: ${positioning_API}/genivi-positioning-constants.xml
	xsltproc ${API_DIR}/navigation-core/enum.xsl ${positioning_API}/genivi-positioning-constants.xml > ${TARGET_GENERATED_API_DIR}/genivi-positioning-constants.h

${TARGET_GENERATED_API_DIR}/genivi-mapviewer-constants.h: ${API_DIR}/map-viewer/genivi-mapviewer-constants.xml
	xsltproc ${API_DIR}/map-viewer/enum.xsl ${API_DIR}/map-viewer/genivi-mapviewer-constants.xml > ${TARGET_GENERATED_API_DIR}/genivi-mapviewer-constants.h

