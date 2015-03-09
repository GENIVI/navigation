/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-client-DBusSearchInterface.h
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

#ifndef POICLIENTDBUSSEARCHINTERFACE
#define POICLIENTDBUSSEARCHINTERFACE

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
 * Proxy class for interface DBusSearchInterface
 */
class DBusSearchInterface: public QDBusAbstractInterface
{
    Q_OBJECT
public:
    static inline const char *staticInterfaceName()
    { return "org.genivi.poiservice.POISearch"; }

public:
    DBusSearchInterface(const QString &service, const QString &path, const QDBusConnection &connection, QObject *parent = 0);

    ~DBusSearchInterface();

public Q_SLOTS: // METHODS

    inline QDBusPendingReply<version_t> GetVersion()
    { //"(qqqs)" out
        return asyncCall(QLatin1String("GetVersion"));
    }

    inline QDBusPendingReply<QString,QString> GetLanguage()
    { //"s" "s" out
        return asyncCall(QLatin1String("GetLanguage"));
    }

    inline QDBusPendingReply<>SetLanguage(QString languageCode,QString countryCode)
    { // "s" "s" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(languageCode) << qVariantFromValue(countryCode);
        return asyncCallWithArgumentList(QLatin1String("SetLanguage"), argumentList);
    }

    inline QDBusPendingReply<QList<categoryId_t> >ValidateCategories(QList<categoryId_t> categories)
    {// "au" in "a(ub)" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(categories);
        return asyncCallWithArgumentList(QLatin1String("ValidateCategories"), argumentList);
    }

    inline QDBusPendingReply<QList<poiCategoryFull_t> > GetAvailableCategories()
    { // "a(usb)" out
        return asyncCall(QLatin1String("GetAvailableCategories"));
    }

    inline QDBusPendingReply<categoryId_t> GetRootCategory()
    { // "u" out
        return asyncCall(QLatin1String("GetRootCategory"));
    }

    inline QDBusPendingReply<QList<poiCategory_t> > GetChildrenCategories(categoryId_t category)
    { // "u" in "a(ub)" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(category);
        return asyncCallWithArgumentList(QLatin1String("GetChildrenCategories"), argumentList);
    }

    inline QDBusPendingReply<QList<poiCategory_t> > GetParentCategories(categoryId_t category)
    { // "u" in "a(ub)" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(category);
        return asyncCallWithArgumentList(QLatin1String("GetParentCategories"), argumentList);
    }

    inline QDBusPendingReply<QList<categoryDetailsList_t> >GetCategoriesDetails(QList<categoryId_t> categories)
    { // "au" in "a((uauvsbsv)a(usia(isv))a(us))" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(categories);
        return asyncCallWithArgumentList(QLatin1String("GetCategoriesDetails"), argumentList);
    }

    inline QDBusPendingReply<handleId_t> CreatePoiSearchHandle()
    { //"u" out
        return asyncCall(QLatin1String("CreatePoiSearchHandle"));
    }

    inline QDBusPendingReply<> DeletePoiSearchHandle(handleId_t poiSearchHandle)
    { //"u" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle);
        return asyncCallWithArgumentList(QLatin1String("DeletePoiSearchHandle"), argumentList);
    }

    inline QDBusPendingReply<> SetCategories(handleId_t poiSearchHandle, QList<poiSearch_t> poiSearchCategories)
    { // "u" "a(uu)" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle) << qVariantFromValue(poiSearchCategories);
        return asyncCallWithArgumentList(QLatin1String("SetCategories"), argumentList);
    }

    inline QDBusPendingReply<>SetRouteHandle(handleId_t poiSearchHandle, uchar sessionHandle, uchar routeHandle, uint startSearchOffset, uint endSearchOffset)
    { // "u" "y" "y" "u" "u" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle) << qVariantFromValue(sessionHandle) << qVariantFromValue(routeHandle) << qVariantFromValue(startSearchOffset) << qVariantFromValue(endSearchOffset);
        return asyncCallWithArgumentList(QLatin1String("SetRouteHandle"), argumentList);
    }

    inline QDBusPendingReply<>StartPoiSearch(handleId_t poiSearchHandle, const QString &inputString, ushort sortOption)
    { // "u" "s" "q" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle) << qVariantFromValue(inputString) << qVariantFromValue(sortOption);
        return asyncCallWithArgumentList(QLatin1String("StartPoiSearch"), argumentList);
    }

    inline QDBusPendingReply<>CancelPoiSearch(handleId_t poiSearchHandle)
    { // "u" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle);
        return asyncCallWithArgumentList(QLatin1String("CancelPoiSearch"), argumentList);
    }

    inline QDBusPendingReply<>StartPoiProximityAlert(handleId_t poiSearchHandle, const QString &inputString, ushort sortOption)
    { // "u" "s" "q" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle) << qVariantFromValue(inputString) << qVariantFromValue(sortOption);
        return asyncCallWithArgumentList(QLatin1String("StartPoiProximityAlert"), argumentList);
    }

    inline QDBusPendingReply<>CancelPoiProximityAlert(handleId_t poiSearchHandle)
    { // "u" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle);
        return asyncCallWithArgumentList(QLatin1String("CancelPoiProximityAlert"), argumentList);
    }

    inline QDBusPendingReply<ushort, ushort, QList<resultSearch_t> >RequestResultList(handleId_t poiSearchHandle, ushort offset, ushort maxWindowSize, QList<attributeId_t> attributes)
    { // "u" "q" "q" "au" in "q" "q" "a(uuqa(uiv))" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle) << qVariantFromValue(offset) << qVariantFromValue(maxWindowSize) << qVariantFromValue(attributes);
        return asyncCallWithArgumentList(QLatin1String("RequestResultList"), argumentList);
    }

    inline QDBusPendingReply<>SetCenter(handleId_t poiSearchHandle, geoCoordinate3D_t location)
    { // "u" "(ddi)" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle) << qVariantFromValue(location);
        return asyncCallWithArgumentList(QLatin1String("SetCenter"), argumentList);
    }

    inline QDBusPendingReply<QList<resultSearchDetails_t> >GetPoiDetails(QList<poiId_t> idList)
    { // "au" in "a((us(ddi))aua(uiv))" out
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(idList);
        return asyncCallWithArgumentList(QLatin1String("GetPoiDetails"), argumentList);
    }

    inline QDBusPendingReply<>SetAttributes(handleId_t poiSearchHandle,QList<poiAttributeFull_t> poiAttributes)
    { // "u" "a(uuivib)" in
        QList<QVariant> argumentList;
        argumentList << qVariantFromValue(poiSearchHandle) << qVariantFromValue(poiAttributes);
        return asyncCallWithArgumentList(QLatin1String("SetAttributes"), argumentList);
    }


Q_SIGNALS: // SIGNALS
    void crashed();
    void PoiStatus(uint,int); // "u" "i" out
    void ResultListChanged(uint,ushort); // "u" "q" out
    void CategoriesUpdated(QList<poiCategoryAndReason_t>); // "a(uq)" out
private:

};

namespace org {
  namespace genivi {
    namespace poiservice {
        namespace poiSearch {
      typedef ::DBusSearchInterface DBusSearchInterface;
        }
    }
  }
}
#endif
