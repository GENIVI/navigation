/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-client-DBusContentAccessInterface.h
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
#ifndef POICLIENTDBUSCONTENTACCESSINTERFACE_H
#define POICLIENTDBUSCONTENTACCESSINTERFACE_H

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
 * Proxy class for interface POIPOCDBusContentAccessInterface
 */
class DBusContentAccessInterface: public QDBusAbstractInterface
{
    Q_OBJECT
public:
    static inline const char *staticInterfaceName()
    { return "org.genivi.poiservice.POIContentAccess"; }

public:
    DBusContentAccessInterface(const QString &service, const QString &path, const QDBusConnection &connection, QObject *parent = 0);

    ~DBusContentAccessInterface();

public Q_SLOTS: // METHODS

    inline QDBusPendingReply<uchar> RegisterContentAccessModule(QString moduleName)
    { //"s" in "y" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(moduleName);
        return asyncCallWithArgumentList(QLatin1String("RegisterContentAccessModule"), argumentList);
    }

    inline QDBusPendingReply<> UnRegisterContentAccessModule(uchar camId)
    { // "y" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId);
        return asyncCallWithArgumentList(QLatin1String("UnRegisterContentAccessModule"), argumentList);
    }

    inline QDBusPendingReply<> RegisterPoiCategories(uchar camId, QList<ushort> poiCategories)
    { // "y" "aq" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId) << qVariantFromValue(poiCategories);
        return asyncCallWithArgumentList(QLatin1String("RegisterPoiCategories"), argumentList);
    }

    inline QDBusPendingReply<QList<ushort> > AddCategories(uchar camId, QList<poiCategoryCamAdd_t> poiCategories)
    { // "y" "a((aqvssv)a(sqa(qs))a(qs))" in "aq" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId) << qVariantFromValue(poiCategories);
        return asyncCallWithArgumentList(QLatin1String("AddCategories"), argumentList);
    }

    inline QDBusPendingReply<> UpdateCategories(uchar camId, poiCategoryCamUpdate_t poiCategories)
    { // "y" "(qa(sqa(qs))a(qs))" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId) << qVariantFromValue(poiCategories);
        return asyncCallWithArgumentList(QLatin1String("UpdateCategories"), argumentList);
    }

    inline QDBusPendingReply<> RemoveCategories(uchar camId, QList<ushort> poiCategories)
    { // "y" "aq" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId) << qVariantFromValue(poiCategories);
        return asyncCallWithArgumentList(QLatin1String("RemoveCategories"), argumentList);
    }

Q_SIGNALS: // SIGNALS
private:

};

namespace org {
  namespace genivi {
    namespace poiservice {
        namespace poiContentAccess {
      typedef ::DBusContentAccessInterface DBusContentAccessInterface;
        }
    }
  }
}

/*
 * Proxy class for interface DBusContentAccessModuleInterface
 */
class DBusContentAccessModuleInterface: public QDBusAbstractInterface
{
    Q_OBJECT
public:
    static inline const char *staticInterfaceName()
    { return "org.genivi.poiservice.POIContentAccessModule"; }

public:
    DBusContentAccessModuleInterface(const QString &service, const QString &path, const QDBusConnection &connection, QObject *parent = 0);

    ~DBusContentAccessModuleInterface();

public Q_SLOTS: // METHODS

    inline QDBusPendingReply<version_t> GetVersion()
    { //"(qqqs)" out
        return asyncCall(QLatin1String("GetVersion"));
    }

    inline QDBusPendingReply<>SetLanguage(QString languageCode,QString countryCode)
    { // "s" "s" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(languageCode) << qVariantFromValue(countryCode);
        return asyncCallWithArgumentList(QLatin1String("SetLanguage"), argumentList);
    }

    inline QDBusPendingReply<>PoiSearchStarted(uchar poiSearchHandle,ushort maxSize, geoCoordinate3D_t location, QList<poiSearch_t> poiCategories, QList<poiAttributeFull_t> poiAttributes, std::string inputString, ushort sortOption)
    { // "y" "q" "(ddi)" "a(qu)" "a(sqqvqb)" "s" "q" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle) << qVariantFromValue(maxSize) << qVariantFromValue(location) << qVariantFromValue(poiCategories) << qVariantFromValue(poiAttributes) << qVariantFromValue(inputString) << qVariantFromValue(sortOption);
        return asyncCallWithArgumentList(QLatin1String("PoiSearchStarted"), argumentList);
    }

    inline QDBusPendingReply<> PoiSearchCanceled(uchar poiSearchHandle)
    { //"y" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle);
        return asyncCallWithArgumentList(QLatin1String("PoiSearchCanceled"), argumentList);
    }

    inline QDBusPendingReply<ushort, ushort, QList<resultCamSearch_t> >ResultListRequested(uchar camId, uchar poiSearchHandle, QList<std::string> attributes)
    { // "y" "y" "as" in "q" "q" "a(usq(ddi)qa(sqv))" out
        QList<QVariant> argumentList;
        QStringList dst;
        foreach(const std::string &s,attributes)
            dst.append(QString::fromStdString(s));
        argumentList << qVariantFromValue(camId) << qVariantFromValue(poiSearchHandle) << qVariantFromValue(dst);
        return asyncCallWithArgumentList(QLatin1String("ResultListRequested"), argumentList);
    }

    inline QDBusPendingReply<QList<resultCamSearchDetails_t> >PoiDetailsRequested(QList<ushort> source_id)
    { // "aq" in "a((usddi)aqa(sqv))" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(source_id);
        return asyncCallWithArgumentList(QLatin1String("PoiDetailsRequested"), argumentList);
    }

Q_SIGNALS: // SIGNALS
private:

};

namespace org {
  namespace genivi {
    namespace poiservice {
        namespace contentAccessModule {
      typedef ::DBusContentAccessModuleInterface DBusContentAccessModuleInterface;
        }
    }
  }
}

#endif // POICLIENTDBUSCONTENTACCESSINTERFACE_H
