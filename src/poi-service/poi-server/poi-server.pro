TEMPLATE = app
CONFIG += console
CONFIG -= qt

SOURCES += main.cpp \
    database.cpp

HEADERS += \
    database.h \
    genivi-positioning-enhancedposition_proxy.h \
    genivi-poiservice-poisearch_adaptor.h \
    genivi-poiservice-poicontentaccess_adaptor.h \
    genivi-poiservice-contentaccessmodule_proxy.h \
    poi-server-class.h \
    poi-datamodel.h

INCLUDEPATH += /usr/include/glibmm-2.4 \
    /usr/lib/i386-linux-gnu/glibmm-2.4/include \
    /usr/include/glib-2.0 \
    /usr/lib/i386-linux-gnu/glib-2.0/include \
    /usr/include/dbus-c++-1 \
    /usr/include/dbus-1.0 \
    /usr/lib/i386-linux-gnu/dbus-1.0/include

LIBS += -lglibmm-2.4 \
        -lglib-2.0 \
        -lgobject-2.0 \
        -lsqlite3 \
        -ldbus-c++-glib-1 \
        -ldbus-c++-1 \
        -ldbus-1
