/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-marshal-handler.cpp
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
#include "poi-marshal-handler.h"

const QDBusArgument &operator>>(const QDBusArgument  &argument, std::string &dest) {
        QString str;
        argument >> str;
        dest = str.toStdString();
        return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const std::string &source)
{
    QString str = QString::fromStdString(source);
     argument << str;
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,poiCategoryAndReason_t &dest)
{
    argument.beginStructure();
    argument >> dest.id >> dest.reason;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const poiCategoryAndReason_t &source)
{
    argument.beginStructure();
    argument << source.id << source.reason;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,poiCategory_t &dest)
{
    argument.beginStructure();
    argument >> dest.id >> dest.top_level;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const poiCategory_t &source)
{
    argument.beginStructure();
    argument << source.id << source.top_level;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,poiCategoryFull_t &dest)
{
    argument.beginStructure();
    argument >> dest.id >> dest.name >> dest.top_level;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const poiCategoryFull_t &source)
{
    argument.beginStructure();
    argument << source.id << source.name << source.top_level;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,poiSearch_t &dest)
{
    argument.beginStructure();
    argument >> dest.id >> dest.radius;
    argument.endStructure();
    return argument;

}

QDBusArgument &operator << (QDBusArgument &argument, const poiSearch_t &source)
{
    argument.beginStructure();
    argument << source.id << source.radius;
    argument.endStructure();
    return argument;
}


const QDBusArgument &operator >> (const QDBusArgument &argument,version_t &dest)
{
    argument.beginStructure();
    argument >> dest.major >> dest.minor >> dest.micro >> dest.date;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const version_t &source)
{
    argument.beginStructure();
    argument << source.major << source.minor << source.micro << source.date;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,DBusCommonAPIVariant_t &dest)
{
    argument.beginStructure();
    argument >> dest.index >> dest.value;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const DBusCommonAPIVariant_t &source)
{
    argument.beginStructure();
    argument << source.index << source.value;
    argument.endStructure();
    return argument;
}


const QDBusArgument &operator >> (const QDBusArgument &argument,geoCoordinate2D_t &dest)
{
    argument.beginStructure();
    argument >> dest.latitude >> dest.longitude;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const geoCoordinate2D_t &source)
{
    argument.beginStructure();
    argument << source.latitude << source.longitude;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,geoCoordinate3D_t &dest)
{
    argument.beginStructure();
    argument >> dest.latitude >> dest.longitude >> dest.altitude;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const geoCoordinate3D_t &source)
{
    argument.beginStructure();
    argument << source.latitude << source.longitude << source.altitude;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,poiCamAdd_t &dest)
{
    argument.beginStructure();
    argument >> dest.name >> dest.location >> dest.attributes;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const poiCamAdd_t &source)
{
    argument.beginStructure();
    argument << source.name << source.location << source.attributes;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,poiAttribute_t &dest)
{
    argument.beginStructure();
    argument >> dest.id >> dest.type >> dest.value;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const poiAttribute_t &source)
{
    argument.beginStructure();
    argument << source.id << source.type << source.value;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,poiAttributeFull_t &dest)
{
    argument.beginStructure();
    argument >> dest.id >> dest.poiCategory >> dest.type >> dest.value >> dest.oper >> dest.mandatory;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const poiAttributeFull_t &source)
{
    argument.beginStructure();
    argument << source.id << source.poiCategory << source.type << source.value << source.oper << source.mandatory;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,resultSearch_t &dest)
{
    argument.beginStructure();
    argument >> dest.id >> dest.distance >> dest.route_status >> dest.attributes;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const resultSearch_t &source)
{
    argument.beginStructure();
    argument << source.id << source.distance << source.route_status << source.attributes;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,categoryDetails_t &dest)
{
    argument.beginStructure();
    argument >> dest.id >> dest.parents_id >> dest.icons >> dest.name >> dest.top_level >> dest.description >> dest.media;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const categoryDetails_t &source)
{
    argument.beginStructure();
    argument << source.id << source.parents_id << source.icons << source.name << source.top_level << source.description << source.media;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,categoryOperator_t &dest)
{
    argument.beginStructure();
    argument  >> dest.type >> dest.name >> dest.value;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const categoryOperator_t &source)
{
    argument.beginStructure();
    argument << source.type << source.name << source.value;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,categoryAttribute_t &dest)
{
    argument.beginStructure();
    argument >> dest.id >> dest.name >> dest.type >> dest.oper;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const categoryAttribute_t &source)
{
    argument.beginStructure();
    argument << source.id << source.name << source.type << source.oper ;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,categorySortOption_t &dest)
{
    argument.beginStructure();
    argument >> dest.id >> dest.name  ;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const categorySortOption_t &source)
{
    argument.beginStructure();
    argument << source.id << source.name;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,categoryDetailsList_t &dest)
{
    argument.beginStructure();
    argument >> dest.details  >> dest.attributes >> dest.sortOptions;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const categoryDetailsList_t &source)
{
    argument.beginStructure();
    argument << source.details << source.attributes  << source.sortOptions;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,detailsPOISearch_t &dest)
{
    argument.beginStructure();
    argument >> dest.id  >> dest.name >> dest.location;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const detailsPOISearch_t &source)
{
    argument.beginStructure();
    argument << source.id << source.name  << source.location;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,resultSearchDetails_t &dest)
{
    argument.beginStructure();
    argument >> dest.details  >> dest.categories >> dest.attributes;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const resultSearchDetails_t &source)
{
    argument.beginStructure();
    argument << source.details << source.categories  << source.attributes;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,results_t &dest)
{
    argument.beginStructure();
    argument >> dest.id  >> dest.status;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const results_t &source)
{
    argument.beginStructure();
    argument << source.id << source.status;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,satelliteInfo_t &dest)
{
    argument.beginStructure();
    argument >> dest.system >> dest.satelliteId >> dest.azimuth >> dest.elevation >> dest.snr >> dest.inUse;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const satelliteInfo_t &source)
{
    argument.beginStructure();
    argument << source.system << source.satelliteId << source.azimuth << source.elevation << source.snr << source.inUse;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,sessions_t &dest)
{
    argument.beginStructure();
    argument >> dest.sessionHandle >> dest.client;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const sessions_t &source)
{
    argument.beginStructure();
    argument << source.sessionHandle << source.client;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,boundingBox_t &dest)
{
    argument.beginStructure();
    argument >> dest.topLeftCorner >> dest.bottomRightCorner;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const boundingBox_t &source)
{
    argument.beginStructure();
    argument << source.topLeftCorner << source.bottomRightCorner;
    argument.endStructure();
    return argument;
}


const QDBusArgument &operator >> (const QDBusArgument &argument,detailsCamCategory_t &dest)
{
    argument.beginStructure();
    argument >> dest.parents_id >> dest.icons >> dest.name >> dest.short_desc >> dest.media;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const detailsCamCategory_t &source)
{
    argument.beginStructure();
    argument << source.parents_id << source.icons << source.name << source.short_desc << source.media;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,poiCategoryCamAdd_t &dest)
{
    argument.beginStructure();
    argument >> dest.details >> dest.attributes >> dest.sortOptions;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const poiCategoryCamAdd_t &source)
{
    argument.beginStructure();
    argument << source.details << source.attributes << source.sortOptions;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,poiCategoryCamUpdate_t &dest)
{
    argument.beginStructure();
    argument >> dest.unique_id >> dest.attributes >> dest.sortOptions;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const poiCategoryCamUpdate_t &source)
{
    argument.beginStructure();
    argument << source.unique_id << source.attributes << source.sortOptions;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,resultCamSearch_t &dest)
{
    argument.beginStructure();
    argument >> dest.source_id >> dest.name >> dest.category >> dest.location >> dest.distance >> dest.attributes;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const resultCamSearch_t &source)
{
    argument.beginStructure();
    argument << source.source_id << source.name << source.category << source.location << source.distance << source.attributes;
    argument.endStructure();
    return argument;
}

const QDBusArgument &operator >> (const QDBusArgument &argument,resultCamSearchDetails_t &dest)
{
    argument.beginStructure();
    argument >> dest.details >> dest.categories >> dest.attributes;
    argument.endStructure();
    return argument;
}

QDBusArgument &operator << (QDBusArgument &argument, const resultCamSearchDetails_t &source)
{
    argument.beginStructure();
    argument << source.details << source.categories << source.attributes;
    argument.endStructure();
    return argument;
}

MarshalHandler::MarshalHandler()
{
}

void MarshalHandler::registerMetaType()
{
    qDBusRegisterMetaType<results_t>();
    qDBusRegisterMetaType<QList<results_t> >();
    qDBusRegisterMetaType<poiCategoryAndReason_t>();
    qDBusRegisterMetaType<QList<poiCategoryAndReason_t> >();
    qDBusRegisterMetaType<detailsPOISearch_t>();
    qDBusRegisterMetaType<resultSearchDetails_t>();
    qDBusRegisterMetaType<QList<resultSearchDetails_t> >();
    qDBusRegisterMetaType<poiAttributeFull_t>();
    qDBusRegisterMetaType<QList<poiAttributeFull_t> >();
    qDBusRegisterMetaType<poiCategory_t>();
    qDBusRegisterMetaType<QList<poiCategory_t> >();
    qDBusRegisterMetaType<version_t>();
    qDBusRegisterMetaType<geoCoordinate3D_t>();
    qDBusRegisterMetaType<std::string>();
    qDBusRegisterMetaType<QList<std::string> >();
    qDBusRegisterMetaType<QList<ushort> >();
    qDBusRegisterMetaType<QList<uint> >();
    qDBusRegisterMetaType<poiCategoryFull_t>();
    qDBusRegisterMetaType<QList<poiCategoryFull_t> >();
    qDBusRegisterMetaType<poiSearch_t>();
    qDBusRegisterMetaType<QList<poiSearch_t> >();
    qDBusRegisterMetaType<poiAttribute_t>();
    qDBusRegisterMetaType<QList<poiAttribute_t> >();
    qDBusRegisterMetaType<resultSearch_t>();
    qDBusRegisterMetaType<QList<resultSearch_t> >();
    qDBusRegisterMetaType<categoryDetails_t>();
    qDBusRegisterMetaType<categoryOperator_t>();
    qDBusRegisterMetaType<QList<categoryOperator_t> >();
    qDBusRegisterMetaType<categoryAttribute_t>();
    qDBusRegisterMetaType<QList<categoryAttribute_t> >();
    qDBusRegisterMetaType<categorySortOption_t>();
    qDBusRegisterMetaType<QList<categorySortOption_t> >();
    qDBusRegisterMetaType<categoryDetailsList_t>();
    qDBusRegisterMetaType<QList<categoryDetailsList_t> >();
    qDBusRegisterMetaType<tupleUshortVariant>();
    qDBusRegisterMetaType<QList<tupleUshortVariant> >();
    qDBusRegisterMetaType<tupleUlongVariant>();
    qDBusRegisterMetaType<QList<tupleUlongVariant> >();
    qDBusRegisterMetaType<tupleUshortUshort>();
    qDBusRegisterMetaType<sessions_t>();
    qDBusRegisterMetaType<QList<sessions_t> >();
    qDBusRegisterMetaType<detailsCamCategory_t>();
    qDBusRegisterMetaType<poiCategoryCamAdd_t>();
    qDBusRegisterMetaType<QList<poiCategoryCamAdd_t> >();
    qDBusRegisterMetaType<poiCategoryCamUpdate_t>();
    qDBusRegisterMetaType<QList<poiCategoryCamUpdate_t> >();
    qDBusRegisterMetaType<resultCamSearch_t>();
    qDBusRegisterMetaType<QList<resultCamSearch_t> >();
    qDBusRegisterMetaType<resultCamSearchDetails_t>();
    qDBusRegisterMetaType<QList<resultCamSearchDetails_t> >();
    qRegisterMetaType<results_t>();
    qRegisterMetaType<QList<results_t> >();
    qRegisterMetaType<poiCategoryAndReason_t>();
    qRegisterMetaType<QList<poiCategoryAndReason_t> >();
    qRegisterMetaType<detailsPOISearch_t>();
    qRegisterMetaType<resultSearchDetails_t>();
    qRegisterMetaType<QList<resultSearchDetails_t> >();
    qRegisterMetaType<poiAttributeFull_t>();
    qRegisterMetaType<QList<poiAttributeFull_t> >();
    qRegisterMetaType<poiCategory_t>();
    qRegisterMetaType<QList<poiCategory_t> >();
    qRegisterMetaType<version_t>();
    qRegisterMetaType<geoCoordinate3D_t>();
    qRegisterMetaType<std::string>();
    qRegisterMetaType<QList<std::string> >();
    qRegisterMetaType<QList<ushort> >();
    qRegisterMetaType<QList<uint> >();
    qRegisterMetaType<poiCategoryFull_t>();
    qRegisterMetaType<QList<poiCategoryFull_t> >();
    qRegisterMetaType<poiSearch_t>();
    qRegisterMetaType<QList<poiSearch_t> >();
    qRegisterMetaType<poiAttribute_t>();
    qRegisterMetaType<QList<poiAttribute_t> >();
    qRegisterMetaType<resultSearch_t>();
    qRegisterMetaType<QList<resultSearch_t> >();
    qRegisterMetaType<categoryDetails_t>();
    qRegisterMetaType<categoryOperator_t>();
    qRegisterMetaType<QList<categoryOperator_t> >();
    qRegisterMetaType<categoryAttribute_t>();
    qRegisterMetaType<QList<categoryAttribute_t> >();
    qRegisterMetaType<categorySortOption_t>();
    qRegisterMetaType<QList<categorySortOption_t> >();
    qRegisterMetaType<categoryDetailsList_t>();
    qRegisterMetaType<QList<categoryDetailsList_t> >();
    qRegisterMetaType<satelliteInfo_t>();
    qRegisterMetaType<QList<satelliteInfo_t> >();
    qRegisterMetaType<sessions_t>();
    qRegisterMetaType<QList<sessions_t> >();
    qRegisterMetaType<detailsCamCategory_t>();
    qRegisterMetaType<poiCategoryCamAdd_t>();
    qRegisterMetaType<QList<poiCategoryCamAdd_t> >();
    qRegisterMetaType<poiCategoryCamUpdate_t>();
    qRegisterMetaType<QList<poiCategoryCamUpdate_t> >();
    qRegisterMetaType<resultCamSearch_t>();
    qRegisterMetaType<QList<resultCamSearch_t> >();
    qRegisterMetaType<resultCamSearchDetails_t>();
    qRegisterMetaType<QList<resultCamSearchDetails_t> >();

}

