TEMPLATE = app
CONFIG += console
QT       += core gui widgets

RESOURCES += \
    ../poi-common/poi-resource.qrc

SOURCES += main.cpp \
    database.cpp \
    mainwindow.cpp

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

HEADERS += \
    database.h \
    mainwindow.h \
    poi-datamodel.h \
    poi-contentaccess-module-class.h \
    ../poi-common/poi-common-data-model.h

FORMS += \
    mainwindow.ui

TRANSLATIONS    = ../poi-common/poi-content-access-module_en.ts \
                  ../poi-common/poi-content-access-module_jp.ts

OTHER_FILES +=


