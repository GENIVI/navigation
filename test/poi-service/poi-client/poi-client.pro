
QT += dbus

SOURCES += main.cpp mainwindow.cpp \
    about-dialog.cpp \
    poi-client-DBusSearchInterface.cpp \
    poi-client-DBusRoutingInterface.cpp \
    poi-client-DBusGuidanceInterface.cpp \
    poi-client-DBusEnhancedPositionInterface.cpp \
    poi-client-DBusNavigationCoreSessionInterface.cpp \
    poi-client-DBusContentAccessInterface.cpp \
    ../poi-common/poi-marshal-handler.cpp
HEADERS += mainwindow.h \
    poi-client-config.h \
    about-dialog.h \
    poi-client-DBusSearchInterface.h \
    poi-client-DBusRoutingInterface.h \
    poi-client-DBusGuidanceInterface.h \
    poi-client-DBusEnhancedPositionInterface.h \
    poi-client-DBusNavigationCoreSessionInterface.h \
    poi-client-DBusContentAccessInterface.h \
    ../poi-common/poi-marshal-handler.h
FORMS += mainwindow.ui \
    about-dialog.ui


OTHER_FILES += \
    about.txt

RESOURCES += \
    ../poi-common/poi-resource.qrc

TRANSLATIONS    = ../poi-common/poi-client_en.ts \
                  ../poi-common/poi-client_jp.ts
