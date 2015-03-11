/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-client-DBusConfigurationInterface.h
*
* \brief This file is part of the poi proof of concept.
*
* \author Philippe Colliot <philippe.colliot@mpsa.com>
*
* \version 1.1
*
* This Source Code Form is subject to the terms of the
* Mozilla Public License (MPL), v. 2.0.
* If a copy of the MPL was not distributed with this file,
* You can obtain one at http://mozilla.org/MPL/2.0/.
*
* For further information see http://www.genivi.org/.
*
* List of changes:
* 10-02-2014, Philippe Colliot, refinement and migration to the new repository
* <date>, <name>, <description of change>
*
* @licence end@
*/

#ifndef POICLIENTDBUSCONFIGURATIONINTERFACE
#define POICLIENTDBUSCONFIGURATIONINTERFACE

#include <QtCore/QObject>
#include <QtCore/QMetaObject>
#include <QtCore/QVariant>
#include <QtDBus/QtDBus>
#include <QtCore/QByteArray>
#include <QtCore/QList>
#include <QtCore/QMap>
#include <QtCore/QString>
#include <QtCore/QStringList>
#include <QtCore/QVariant>

#include "poi-client-config.h"

#include "../poi-common/poi-marshal-handler.h"


/*
 * Proxy class for interface DBusConfigurationInterface
 */
class DBusConfigurationInterface: public QDBusAbstractInterface
{
    Q_OBJECT
public:
    static inline const char *staticInterfaceName()
    { return "org.genivi.poiservice.Configuration"; }

public:
    DBusConfigurationInterface(const QString &service, const QString &path, const QDBusConnection &connection, QObject *parent = 0);

    ~DBusConfigurationInterface();

public Q_SLOTS: // METHODS

    inline QDBusPendingReply<version_t> GetVersion()
    { //"(qqqs)" out
        return asyncCall(QLatin1String("GetVersion"));
    }

    inline QDBusPendingReply<>SetUnitsOfMeasurement(tupleUshortVariant unitsOfMeasurementList)
    { // "a{qv}" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(unitsOfMeasurementList);
        return asyncCallWithArgumentList(QLatin1String("SetUnitsOfMeasurement"), argumentList);
    }

    inline QDBusPendingReply<tupleUshortVariant> GetUnitsOfMeasurement()
    { // "a{qv}" out
        return asyncCall(QLatin1String("GetUnitsOfMeasurement"));
    }

    inline QDBusPendingReply<tupleUshortVariant> GetSupportedUnitsOfMeasurement()
    { // "a{qv}" out
        return asyncCall(QLatin1String("GetSupportedUnitsOfMeasurement"));
    }

    inline QDBusPendingReply<>SetTimeFormat(ushort timeFormat)
    { // "q" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(timeFormat);
        return asyncCallWithArgumentList(QLatin1String("SetTimeFormat"), argumentList);
    }

    inline QDBusPendingReply<ushort> GetTimeFormat()
    { //"q" out
        return asyncCall(QLatin1String("GetTimeFormat"));
    }

    inline QDBusPendingReply<QList<ushort> > GetSupportedTimeFormats()
    { //"a(q)" out
        return asyncCall(QLatin1String("GetSupportedTimeFormats"));
    }

    inline QDBusPendingReply<>SetCoordinatesFormat(ushort coordinatesFormat)
    { // "q" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(coordinatesFormat);
        return asyncCallWithArgumentList(QLatin1String("SetCoordinatesFormat"), argumentList);
    }

    inline QDBusPendingReply<ushort> GetCoordinatesFormat()
    { //"q" out
        return asyncCall(QLatin1String("GetCoordinatesFormat"));
    }

    inline QDBusPendingReply<QList<ushort> > GetSupportedCoordinatesFormats()
    { //"a(q)" out
        return asyncCall(QLatin1String("GetSupportedCoordinatesFormats"));
    }

    inline QDBusPendingReply<>SetLocale(QString languageCode,QString countryCode,QString scriptCode)
    { // "s" "s" "s" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(languageCode) << qVariantFromValue(countryCode) << qVariantFromValue(scriptCode);
        return asyncCallWithArgumentList(QLatin1String("SetLocale"), argumentList);
    }

    inline QDBusPendingReply<QString,QString,QString> GetLocale()
    { //"s" "s" "s" out
        return asyncCall(QLatin1String("GetLocale"));
    }

    inline QDBusPendingReply<QList<configurationLocale_t> > GetSupportedLocales()
    { //"a(sss)" out
        return asyncCall(QLatin1String("GetSupportedLocales"));
    }


Q_SIGNALS: // SIGNALS
    void ConfigurationChanged(QList<ushort>); // "aq" out
private:

};

namespace org {
  namespace genivi {
    namespace poiservice {
        namespace poiSearch {
      typedef ::DBusConfigurationInterface DBusConfigurationInterface;
        }
    }
  }
}
#endif
