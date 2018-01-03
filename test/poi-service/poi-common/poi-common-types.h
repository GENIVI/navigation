/**
 * @licence app begin@
 * Copyright (C) 2011-2012  PCA Peugeot Citroën
 *
 * This file is part of GENIVI Project POISearch Proof Of Concept [POIPOCClient].
 *
 * Contributions are licensed to the GENIVI Alliance under one or more
 * Contribution License Agreements.
 *
 * \copyright
 * This Source Code Form is subject to the terms of the
 * Mozilla Public License, v. 2.0. If a  copy of the MPL was not distributed with
 * this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * \author Philippe Colliot <philippe.colliot@mpsa.com
 *
 * \file POIPOCCommonTypes.h
 * For further information see http://www.genivi.org/.
 * @licence end@
 */
#ifndef POIPOCCOMMONTYPES_H
#define POIPOCCOMMONTYPES_H

#include <QtCore/QString>
#include <QDBusArgument>

typedef qulonglong poiId_t;
typedef uint categoryId_t;
typedef uint resourceId_t;
typedef uint attributeId_t;
typedef uint handleId_t;
typedef uchar camId_t;

struct DBusCommonAPIVariant_t //(yv)
{
    uchar index;
    QDBusVariant value;
};

struct geoCoordinate2D_t //(dd)
{
    double latitude;
    double longitude;
};

struct geoCoordinate3D_t //(ddd)
{
    double latitude;
    double longitude;
    double altitude;
};

struct poiCategoryAndReason_t //(uq)
{
    categoryId_t id;
    ushort reason;
};

struct boundingBox_t //(dd)(dd)
{
    geoCoordinate2D_t topLeftCorner;
    geoCoordinate2D_t bottomRightCorner;
};

struct results_t //(ub)
{
    categoryId_t id;
    bool status;
};

struct sessions_t //(ys)
{
   uchar sessionHandle;
   std::string client;
};

struct poiCategory_t //(ub)
{
    categoryId_t id;
    bool top_level; //false if predefined, true if created by plugin
};

struct poiCategoryFull_t //(usb)
{
    categoryId_t id;
    std::string name;
    bool top_level; //false if predefined, true if created by plugin
};

struct poiSearch_t //(uu)
{
    categoryId_t id;
    uint radius;
};

struct version_t //(qqqs)
{
    ushort major;
    ushort minor;
    ushort micro;
    std::string date;
};

struct poiAttribute_t //(ui(yv))
{
    attributeId_t id;
    int type;
    DBusCommonAPIVariant_t value;
};

struct poiAttributeFull_t //(uui(yv)ib)
{
    attributeId_t id;
    categoryId_t poiCategory; //Category unique id
    int type;
    DBusCommonAPIVariant_t value;
    int oper; //enum(INVALID,MORE_THAN,LESS_THAN,EQUAL, ....)
    bool mandatory; //true if the attribute is mandatory for the search and false for optional
};

struct resultSearch_t //(tuia(ui(yv)))
{
    poiId_t id;
    uint distance;
    int route_status;
    QList<poiAttribute_t> attributes;
};

struct detailsPOISearch_t //(ts(ddd))
{
    poiId_t id;
    QString name; //need to be a QString for UTF8
    geoCoordinate3D_t location;
};

struct resultSearchDetails_t //((ts(ddd))aua(ui(yv)))
{
    detailsPOISearch_t details;
    QList<categoryId_t> categories;
    QList<poiAttribute_t> attributes;
};

struct categoryDetails_t //(uiau(yv)sbs(yv))
{
    categoryId_t id; //Category unique id
    int standardCategoryId; //standard Category Id
    QList<categoryId_t> parents_id; //list of parent categories unique id
    DBusCommonAPIVariant_t icons; //visual icons set
    QString name; //need to be a QString for UTF8
    bool top_level; //false if predefined, true if created by plugin
    std::string description; //short category description (optional)
    DBusCommonAPIVariant_t media; //media associated (html web site, audio, video, ...) (optional)
};

struct categoryOperator_t //(is(yv))
{
    int type; //enum(INVALID,MORE_THAN,LESS_THAN,EQUAL, ....)
    std::string name; //attribute operator name
    DBusCommonAPIVariant_t value; //attribute operator value
};

struct categoryAttribute_t //(usia(is(yv)))
{
    attributeId_t id; //attribute unique id
    std::string name; //attribute unique name
    int type; //enum(INVALID,STRING,INTEGER,COORDINATES ...)
    QList<categoryOperator_t> oper;
};

struct categorySortOption_t //(us)
{
    uint id; //enum(GENIVI_POISERVICE_SORT_DEFAULT,GENIVI_POISERVICE_SORT_BY_DISTANCE,GENIVI_POISERVICE_SORT_BY_TIME ... )
    std::string name; //name to be displayed by application
};

struct categoryDetailsList_t //((uiau(yv)sbs(yv)) a(usia(is(yv))) a(us))
{
    categoryDetails_t details;
    QList<categoryAttribute_t> attributes;
    QList<categorySortOption_t> sortOptions;
};

typedef QMap<ushort,QDBusVariant> tupleUshortVariant;

typedef QMap<qulonglong,QDBusVariant> tupleUlongVariant;

typedef QMap<ushort,ushort> tupleUshortUshort;

struct resultCamSearch_t //(tsu(ddd)qa(ui(yv)))
{
    poiId_t source_id;
    std::string name;
    categoryId_t category;
    geoCoordinate3D_t location;
    ushort distance;
    QList<poiAttribute_t> attributes;
};

struct resultCamSearchDetails_t //((ts(ddd))aua(ui(yv)))
{
    detailsPOISearch_t details;
    QList<categoryId_t> categories;
    QList<poiAttribute_t> attributes;
};

struct detailsCamCategory_t //(au(yv)ss(yv))
{
    QList<categoryId_t> parents_id;
    QDBusVariant icons;
    std::string name;
    std::string short_desc;
    DBusCommonAPIVariant_t media;
};

struct poiCategoryCamAdd_t //((au(yv)ss(yv))a(usia(is(yv)))a(us))
{
    detailsCamCategory_t details;
    QList<categoryAttribute_t> attributes;
    QList<categorySortOption_t> sortOptions;
};

struct poiCategoryCamUpdate_t //(ua(usia(is(yv)))a(us))
{
   categoryId_t unique_id;
   QList<categoryAttribute_t> attributes;
   QList<categorySortOption_t> sortOptions;
};

struct poiCamAdd_t //(s(ddd)a(ui(yv)))
{
   std::string name;
   geoCoordinate3D_t location;
   QList<poiAttribute_t> attributes;
};

struct satelliteInfo_t //(qqqqqb)
{
    ushort system;
    ushort satelliteId;
    ushort azimuth;
    ushort elevation;
    ushort snr;
    bool inUse;
};

struct route_vector_t //(dd)(dd)
{
    geoCoordinate2D_t startPoint;
    geoCoordinate2D_t endPoint;
};

struct configurationLocale_t //(sss)
{
    std::string languageCode;
    std::string countryCode;
    std::string scriptCode;
};

#endif // POIPOCCOMMONTYPES_H
