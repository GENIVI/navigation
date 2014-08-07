TEMPLATE = app
CONFIG += console
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += \
    map-viewer/configuration-plugin/genivi_mapviewer_configuration.cxx \
    map-viewer/mapviewercontrol-plugin/genivi_mapviewer_mapviewercontrol.cxx \
    map-viewer/session-plugin/genivi_mapviewer_session.cxx \
    navigation-core/configuration-plugin/genivi_navigationcore_configuration.cxx \
    navigation-core/enhancedposition-plugin/genivi_positioning_enhancedposition.cxx \
    navigation-core/guidance-plugin/genivi_navigationcore_guidance.cxx \
    navigation-core/locationinput-plugin/genivi_navigationcore_locationinput.cxx \
    navigation-core/mapmatchedposition-plugin/genivi_navigationcore_mapmatchedposition.cxx \
    navigation-core/routing-plugin/genivi_navigationcore_routing.cxx \
    navigation-core/session-plugin/genivi_navigationcore_session.cxx

INCLUDEPATH += ./bin/mapviewer-configuration \
                ./bin/mapviewer-mapviewercontrol \
                ./bin/mapviewer-session \
                ./bin/navigationcore-configuration \
                ./bin/navigationcore-guidance \
                ./bin \
                navit/navit
