#!/bin/sh
API_DIR=${1-../../../api}
TARGET_DIR=${2-../poi-common}
POSITIONING_API_DIR=${3-../../../api/enhanced-position-service}
echo 'clean up'

echo "generate the adaptors and the proxys for the POI APIs from $API_DIR to $TARGET_DIR"
dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-contentaccessmodule.xml --adaptor=${TARGET_DIR}/genivi-poiservice-contentaccessmodule_adaptor.h
dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-contentaccessmodule.xml --proxy=${TARGET_DIR}/genivi-poiservice-contentaccessmodule_proxy.h
dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-poicontentaccess.xml --adaptor=${TARGET_DIR}/genivi-poiservice-poicontentaccess_adaptor.h
dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-poicontentaccess.xml --proxy=${TARGET_DIR}/genivi-poiservice-poicontentaccess_proxy.h
dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-poisearch.xml --adaptor=${TARGET_DIR}/genivi-poiservice-poisearch_adaptor.h
dbusxx-xml2cpp ${API_DIR}/poi-service/genivi-poiservice-poisearch.xml --proxy=${TARGET_DIR}/genivi-poiservice-poisearch_proxy.h

echo 'generate the constants for the POI APIs'
xsltproc ${API_DIR}/poi-service/enum.xsl ${API_DIR}/poi-service/genivi-poiservice-constants.xml > ${TARGET_DIR}/genivi-poiservice-constants.h

echo 'generate the adaptors and the proxys for the other APIs'
dbusxx-xml2cpp ${API_DIR}/navigation-core/genivi-navigationcore-guidance.xml --adaptor=${TARGET_DIR}/genivi-navigationcore-guidance_adaptor.h
dbusxx-xml2cpp ${API_DIR}/navigation-core/genivi-navigationcore-guidance.xml --proxy=${TARGET_DIR}/genivi-navigationcore-guidance_proxy.h
dbusxx-xml2cpp ${API_DIR}/navigation-core/genivi-navigationcore-routing.xml --adaptor=${TARGET_DIR}/genivi-navigationcore-routing_adaptor.h
dbusxx-xml2cpp ${API_DIR}/navigation-core/genivi-navigationcore-routing.xml --proxy=${TARGET_DIR}/genivi-navigationcore-routing_proxy.h
dbusxx-xml2cpp ${POSITIONING_API_DIR}/genivi-positioning-enhancedposition.xml --adaptor=${TARGET_DIR}/genivi-positioning-enhancedposition_adaptor.h
dbusxx-xml2cpp ${POSITIONING_API_DIR}/genivi-positioning-enhancedposition.xml --proxy=${TARGET_DIR}/genivi-positioning-enhancedposition_proxy.h

echo 'generate the constants for the other APIs'
xsltproc ${API_DIR}/navigation-core/enum.xsl ${API_DIR}/navigation-core/genivi-navigationcore-constants.xml > ${TARGET_DIR}/genivi-navigationcore-constants.h
xsltproc ${API_DIR}/poi-service/enum.xsl ${POSITIONING_API_DIR}/genivi-positioning-constants.xml > ${TARGET_DIR}/genivi-positioning-constants.h
xsltproc ${API_DIR}/map-viewer/enum.xsl ${API_DIR}/map-viewer/genivi-mapviewer-constants.xml > ${TARGET_DIR}/genivi-mapviewer-constants.h


