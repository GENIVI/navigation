/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-marshal-handler.h
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
#ifndef MARSHALHANDLER_H
#define MARSHALHANDLER_H

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

#include "poi-common-types.h"

class MarshalHandler
{
public:
    MarshalHandler();
    static void registerMetaType();
};
Q_DECLARE_METATYPE(std::string)
const QDBusArgument &operator>>(const QDBusArgument  &argument, std::string &dest);
QDBusArgument &operator << (QDBusArgument &argument, const std::string &source);
Q_DECLARE_METATYPE(QList<std::string>)
Q_DECLARE_METATYPE(QList<ushort>)
Q_DECLARE_METATYPE(QList<uint>)
Q_DECLARE_METATYPE(DBusCommonAPIVariant_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,DBusCommonAPIVariant_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const DBusCommonAPIVariant_t &source);
Q_DECLARE_METATYPE(geoCoordinate2D_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,geoCoordinate2D_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const geoCoordinate2D_t &source);
Q_DECLARE_METATYPE(geoCoordinate3D_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,geoCoordinate3D_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const geoCoordinate3D_t &source);
Q_DECLARE_METATYPE(poiCamAdd_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,poiCamAdd_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const poiCamAdd_t &source);
Q_DECLARE_METATYPE(poiCategoryAndReason_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,poiCategoryAndReason_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const poiCategoryAndReason_t &source);
Q_DECLARE_METATYPE(QList<poiCategoryAndReason_t>)
Q_DECLARE_METATYPE(boundingBox_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,boundingBox_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const boundingBox_t &source);
Q_DECLARE_METATYPE(results_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,results_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const results_t &source);
Q_DECLARE_METATYPE(QList<results_t>)
Q_DECLARE_METATYPE(sessions_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,sessions_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const sessions_t &source);
Q_DECLARE_METATYPE(QList<sessions_t>)
Q_DECLARE_METATYPE(poiCategory_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,poiCategory_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const poiCategory_t &source);
Q_DECLARE_METATYPE(QList<poiCategory_t>)
Q_DECLARE_METATYPE(poiCategoryFull_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,poiCategoryFull_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const poiCategoryFull_t &source);
Q_DECLARE_METATYPE(QList<poiCategoryFull_t>)
Q_DECLARE_METATYPE(poiSearch_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,poiSearch_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const poiSearch_t &source);
Q_DECLARE_METATYPE(QList<poiSearch_t>)
Q_DECLARE_METATYPE(version_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,version_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const version_t &source);
Q_DECLARE_METATYPE(poiAttribute_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,poiAttribute_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const poiAttribute_t &source);
Q_DECLARE_METATYPE(QList<poiAttribute_t>)
Q_DECLARE_METATYPE(poiAttributeFull_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,poiAttributeFull_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const poiAttributeFull_t &source);
Q_DECLARE_METATYPE(QList<poiAttributeFull_t>)
Q_DECLARE_METATYPE(resultSearch_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,resultSearch_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const resultSearch_t &source);
Q_DECLARE_METATYPE(QList<resultSearch_t>)
Q_DECLARE_METATYPE(detailsPOISearch_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,detailsPOISearch_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const detailsPOISearch_t &source);
Q_DECLARE_METATYPE(resultSearchDetails_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,resultSearchDetails_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const resultSearchDetails_t &source);
Q_DECLARE_METATYPE(QList<resultSearchDetails_t>)
Q_DECLARE_METATYPE(categoryDetails_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,categoryDetails_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const categoryDetails_t &source);
Q_DECLARE_METATYPE(categoryOperator_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,categoryOperator_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const categoryOperator_t &source);
Q_DECLARE_METATYPE(QList<categoryOperator_t>)
Q_DECLARE_METATYPE(categoryAttribute_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,categoryAttribute_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const categoryAttribute_t &source);
Q_DECLARE_METATYPE(QList<categoryAttribute_t>)
Q_DECLARE_METATYPE(categorySortOption_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,categorySortOption_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const categorySortOption_t &source);
Q_DECLARE_METATYPE(QList<categorySortOption_t>)
Q_DECLARE_METATYPE(categoryDetailsList_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,categoryDetailsList_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const categoryDetailsList_t &source);
Q_DECLARE_METATYPE(QList<categoryDetailsList_t>)
Q_DECLARE_METATYPE(tupleUshortVariant)
Q_DECLARE_METATYPE(tupleUlongVariant)
Q_DECLARE_METATYPE(tupleUshortUshort)
Q_DECLARE_METATYPE(resultCamSearch_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,resultCamSearch_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const resultCamSearch_t &source);
Q_DECLARE_METATYPE(QList<resultCamSearch_t>)
Q_DECLARE_METATYPE(resultCamSearchDetails_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,resultCamSearchDetails_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const resultCamSearchDetails_t &source);
Q_DECLARE_METATYPE(QList<resultCamSearchDetails_t>)
Q_DECLARE_METATYPE(detailsCamCategory_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,detailsCamCategory_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const detailsCamCategory_t &source);
Q_DECLARE_METATYPE(poiCategoryCamAdd_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,poiCategoryCamAdd_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const poiCategoryCamAdd_t &source);
Q_DECLARE_METATYPE(QList<poiCategoryCamAdd_t>)
Q_DECLARE_METATYPE(poiCategoryCamUpdate_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,poiCategoryCamUpdate_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const poiCategoryCamUpdate_t &source);
Q_DECLARE_METATYPE(QList<poiCategoryCamUpdate_t>)
Q_DECLARE_METATYPE(satelliteInfo_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,satelliteInfo_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const satelliteInfo_t &source);
Q_DECLARE_METATYPE(QList<satelliteInfo_t>)
Q_DECLARE_METATYPE(configurationLocale_t)
const QDBusArgument &operator >> (const QDBusArgument &argument,configurationLocale_t &dest);
QDBusArgument &operator << (QDBusArgument &argument, const configurationLocale_t &source);
Q_DECLARE_METATYPE(QList<configurationLocale_t>)

#endif // MARSHALHANDLER_H
