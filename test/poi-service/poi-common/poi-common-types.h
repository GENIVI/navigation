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

struct geoCoordinate2D_t
{ //(dd)
    double latitude;
    double longitude;
};

struct geoCoordinate3D_t
{ //(ddi)
    double latitude;
    double longitude;
    int altitude;
};

struct poiCategoryAndReason_t
{ //(qq)
    ushort id;
    ushort reason;
};

struct boundingBox_t
{ //(dd)(dd)
    geoCoordinate2D_t topLeftCorner;
    geoCoordinate2D_t bottomRightCorner;
};

struct results_t
{ //(qb)
    ushort id;
    bool status;
};

struct sessions_t
{ //(ys)
   uchar sessionHandle;
   std::string client;
};

struct poiCategory_t
{ //(qb)
    ushort id;
    bool top_level; //false if predefined, true if created by plugin
};

struct poiCategoryFull_t
{ //(qsb)
    ushort id;
    std::string name;
    bool top_level; //false if predefined, true if created by plugin
};

struct poiSearch_t
{ //(qu)
    ushort id;
    uint radius;
};

struct version_t
{ //(qqqs)
    ushort major;
    ushort minor;
    ushort micro;
    std::string date;
};

struct poiAttribute_t
{ //(sqv)
    std::string name;
    ushort type;
    QDBusVariant value;
};

struct poiAttributeFull_t
{ //(sqqvqb)
    std::string name;
    ushort poiCategory; //Category unique id
    ushort type;
    QDBusVariant value;
    ushort id; //enum(INVALID,MORE_THAN,LESS_THAN,EQUAL, ....)
    bool mandatory; //true if the attribute is mandatory for the search and false for optional
};

struct resultSearch_t
{ //(uuqa(sqv))
    uint id;
    uint distance;
    ushort route_status;
    QList<poiAttribute_t> attributes;
};

struct detailsPOISearch_t
{ //(usddi)
    uint id;
    QString name; //need to be a QString for UTF8
    double latitude;
    double longitude;
    int altitude;
};

struct resultSearchDetails_t
{ //((usddi)aqa(sqv))
    detailsPOISearch_t details;
    QList<ushort> categories;
    QList<poiAttribute_t> attributes;
};

struct categoryDetails_t
{ //(qaqvsbsv)
    ushort id; //Category unique id
    QList<ushort> parents_id; //list of parent categories unique id
    QDBusVariant icons; //visual icons set
    QString name; //need to be a QString for UTF8
    bool top_level; //false if predefined, true if created by plugin
    std::string description; //short category description (optional)
    QDBusVariant media; //media associated (html web site, audio, video, ...) (optional)
};

struct categoryOperator_t
{ //(qs)
    ushort id; //enum(INVALID,MORE_THAN,LESS_THAN,EQUAL, ....)
    std::string name; //attribute operator name
};

struct categoryAttribute_t
{ //(sqa(qs))
    std::string name; //attribute unique name
    ushort type; //enum(INVALID,STRING,INTEGER,COORDINATES ...)
    QList<categoryOperator_t> oper;
};

struct categorySortOption_t
{ //(qs)
    ushort id; //enum(GENIVI_POISERVICE_SORT_DEFAULT,GENIVI_POISERVICE_SORT_BY_DISTANCE,GENIVI_POISERVICE_SORT_BY_TIME ... )
    std::string name; //name to be displayed by application
};

struct categoryDetailsList_t
{ //((qaqvsbsv)a(sqa(qs))a(qs))
    categoryDetails_t details;
    QList<categoryAttribute_t> attributes;
    QList<categorySortOption_t> sortOptions;
};

typedef QMap<ushort,QDBusVariant> tupleVariant_t;

typedef QMap<ushort,ushort> tupleUshort_t;

struct resultCamSearch_t
{ //(usq(ddi)qa(sqv))
    uint source_id;
    std::string name;
    ushort category;
    geoCoordinate3D_t location;
    ushort distance;
    QList<poiAttribute_t> attributes;
};

struct resultCamSearchDetails_t
{ //((usddi)aqa(sqv))
    detailsPOISearch_t details;
    QList<ushort> categories;
    QList<poiAttribute_t> attributes;
};

struct detailsCamCategory_t
{ //(aqvssv)
    QList<ushort> parents_id;
    QDBusVariant icons;
    std::string name;
    std::string short_desc;
    QDBusVariant media;
};

struct poiCategoryCamAdd_t
{ //((aqvssv)a(sqa(qs))a(qs))
    detailsCamCategory_t details;
    QList<categoryAttribute_t> attributes;
    QList<categorySortOption_t> sortOptions;
};

struct poiCategoryCamUpdate_t
{ //(qa(sqa(qs))a(qs))
   ushort unique_id;
   QList<categoryAttribute_t> attributes;
   QList<categorySortOption_t> sortOptions;
};

struct satellitedetails_t
{ //(ubuuu)
    uint satId;
    bool inUse;
    uint elevation;
    uint azimuth;
    uint snr;
};

struct route_vector_t
{ //(dd)(dd)
    geoCoordinate2D_t startPoint;
    geoCoordinate2D_t endPoint;
};

#endif // POIPOCCOMMONTYPES_H
