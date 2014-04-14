TEMPLATE = app
CONFIG += console
CONFIG -= qt

SOURCES += main.cpp \
    database.cpp \
    raw-file-sort.cpp

HEADERS += \
    database.h \
    raw-file-sort.h \
    poi-datamodel.h
INCLUDEPATH += /usr/include/libxml++-2.6 \
    /usr/lib/libxml++-2.6/include \
    /usr/include/libxml2 \
    /usr/include/glibmm-2.4 \
    /usr/lib/i386-linux-gnu/glibmm-2.4/include \
    /usr/include/glib-2.0 \
    /usr/lib/i386-linux-gnu/glib-2.0/include

LIBS += -lxml++-2.6 \
        -lxml2 \
        -lglibmm-2.4 \
        -lglib-2.0 \
        -lgobject-2.0 \
        -lsqlite3

