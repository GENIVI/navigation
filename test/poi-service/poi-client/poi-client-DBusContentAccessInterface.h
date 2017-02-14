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
    { return "org.genivi.navigation.poiservice.POIContentAccess"; }

public:
    DBusContentAccessInterface(const QString &service, const QString &path, const QDBusConnection &connection, QObject *parent = 0);

    ~DBusContentAccessInterface();

public Q_SLOTS: // METHODS

    inline QDBusPendingReply<camId_t> RegisterContentAccessModule(QString moduleName)
    { //"s" in "y" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(moduleName);
        return asyncCallWithArgumentList(QLatin1String("RegisterContentAccessModule"), argumentList);
    }

    inline QDBusPendingReply<> UnRegisterContentAccessModule(camId_t camId)
    { // "y" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId);
        return asyncCallWithArgumentList(QLatin1String("UnRegisterContentAccessModule"), argumentList);
    }

    inline QDBusPendingReply<> RegisterPoiCategories(camId_t camId, QList<categoryId_t> poiCategories)
    { // "y" "au" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId) << qVariantFromValue(poiCategories);
        return asyncCallWithArgumentList(QLatin1String("RegisterPoiCategories"), argumentList);
    }

    inline QDBusPendingReply<QList<ushort> > AddCategories(camId_t camId, QList<poiCategoryCamAdd_t> poiCategories)
    { // "y" "a((auvssv)a(usia(isv))a(us))" in "au" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId) << qVariantFromValue(poiCategories);
        return asyncCallWithArgumentList(QLatin1String("AddCategories"), argumentList);
    }

    inline QDBusPendingReply<> UpdateCategories(camId_t camId, QList<poiCategoryCamUpdate_t> poiCategories)
    { // "y" "a(ua(usia(isv))a(us))" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId) << qVariantFromValue(poiCategories);
        return asyncCallWithArgumentList(QLatin1String("UpdateCategories"), argumentList);
    }

    inline QDBusPendingReply<> RemoveCategories(camId_t camId, QList<categoryId_t> poiCategories)
    { // "y" "au" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId) << qVariantFromValue(poiCategories);
        return asyncCallWithArgumentList(QLatin1String("RemoveCategories"), argumentList);
    }

Q_SIGNALS: // SIGNALS
private:

};

namespace org {
  namespace genivi {
    namespace navigation {
        namespace poiservice {
            namespace poiContentAccess {
        typedef ::DBusContentAccessInterface DBusContentAccessInterface;
            }
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
    { return "org.genivi.navigation.poiservice.POIContentAccessModule"; }

public:
    DBusContentAccessModuleInterface(const QString &service, const QString &path, const QDBusConnection &connection, QObject *parent = 0);

    ~DBusContentAccessModuleInterface();

public Q_SLOTS: // METHODS

    inline QDBusPendingReply<version_t> GetVersion()
    { //"(qqqs)" out
        return asyncCall(QLatin1String("GetVersion"));
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

    inline QDBusPendingReply<QList<poiCategoryFull_t > >GetAvailableCategories()
    { //"a(usb)" out
        return asyncCall(QLatin1String("GetAvailableCategories"));
    }

    inline QDBusPendingReply<categoryId_t>GetRootCategory()
    { //"u" out
        return asyncCall(QLatin1String("GetRootCategory"));
    }

    inline QDBusPendingReply<QList<poiCategory_t > >GetChildrenCategories(categoryId_t category)
    { //"u" in "a(ub)" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(category);
        return asyncCallWithArgumentList(QLatin1String("GetChildrenCategories"), argumentList);
    }


    inline QDBusPendingReply<QList<poiCategory_t > >GetParentCategories(categoryId_t category)
    {//"u" in "a(ub)" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(category);
        return asyncCallWithArgumentList(QLatin1String("GetParentCategories"), argumentList);
    }

    inline QDBusPendingReply<categoryId_t>createCategory(poiCategoryCamAdd_t category)
    {//"((au(yv)ss(yv))a(usia(is(yv)))a(us))" in "u" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(category);
        return asyncCallWithArgumentList(QLatin1String("createCategory"), argumentList);
    }

    inline QDBusPendingReply<>removeCategories(QList<categoryId_t > categories)
    {//"au" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(categories);
        return asyncCallWithArgumentList(QLatin1String("removeCategories"), argumentList);
    }

    inline QDBusPendingReply<>addPOIs(categoryId_t unique_id, QList<poiCamAdd_t > poiList)
    {//"u,a(s(ddd)a(ui(yv)))" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(unique_id) << qVariantFromValue(poiList);
        return asyncCallWithArgumentList(QLatin1String("addPOIs"), argumentList);
    }

    inline QDBusPendingReply<>removePOIs(QList<poiId_t > ids)
    {//"au" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(ids);
        return asyncCallWithArgumentList(QLatin1String("removeCategories"), argumentList);
    }

    inline QDBusPendingReply<>PoiSearchStarted(handleId_t poiSearchHandle,ushort maxSize, geoCoordinate3D_t location, QList<poiSearch_t> poiCategories, QList<poiAttributeFull_t> poiAttributes, std::string inputString, ushort sortOption)
    { // "u" "q" "(ddd)" "a(uu)" "a(uui(yv)qb)" "s" "q" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle) << qVariantFromValue(maxSize) << qVariantFromValue(location) << qVariantFromValue(poiCategories) << qVariantFromValue(poiAttributes) << qVariantFromValue(inputString) << qVariantFromValue(sortOption);
        return asyncCallWithArgumentList(QLatin1String("PoiSearchStarted"), argumentList);
    }

    inline QDBusPendingReply<> PoiSearchCanceled(handleId_t poiSearchHandle)
    { //"u" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle);
        return asyncCallWithArgumentList(QLatin1String("PoiSearchCanceled"), argumentList);
    }

    inline QDBusPendingReply<ushort, ushort, QList<resultCamSearch_t> >ResultListRequested(camId_t camId, handleId_t poiSearchHandle, QList<attributeId_t> attributes)
    { // "y" "u" "au" in "q" "q" "a(usu(ddd)qa(ui(yv)))" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(camId) << qVariantFromValue(poiSearchHandle) << qVariantFromValue(attributes);
        return asyncCallWithArgumentList(QLatin1String("ResultListRequested"), argumentList);
    }

    inline QDBusPendingReply<QList<resultCamSearchDetails_t> >PoiDetailsRequested(QList<poiId_t> source_id)
    { // "au" in "a((us(ddd))aua(ui(yv)))" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(source_id);
        return asyncCallWithArgumentList(QLatin1String("PoiDetailsRequested"), argumentList);
    }

Q_SIGNALS: // SIGNALS
private:

};

namespace org {
  namespace genivi {
    namespace navigation {
        namespace poiservice {
            namespace contentAccessModule {
        typedef ::DBusContentAccessModuleInterface DBusContentAccessModuleInterface;
            }
        }
    }
  }
}

#endif // POICLIENTDBUSCONTENTACCESSINTERFACE_H
