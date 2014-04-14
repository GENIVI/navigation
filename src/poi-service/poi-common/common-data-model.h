/**
 * @licence app begin@
 * Copyright (C) 2011-2012  PCA Peugeot Citroën
 *
 * This file is part of GENIVI Project POISearch Proof Of Concept [common data model].
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
 * \file POIPOCCommonDataModel.h
 * For further information see http://www.genivi.org/.
 * @licence end@
 */
#ifndef __POIPOCCOMMONDATAMODEL_H__
#define __POIPOCCOMMONDATAMODEL_H__

#include <dbus-c++/dbus.h>

/* How to
  These classes are gateways between internal data and DBus data
  Internal access is provided by set and get
  DBus access is provided by setDBus and getDBus
  Code rules:
  if data name is MYNAME:
class DBus_MYNAME // DBus data type ex:(qqqs)
{
public:
    struct MYNAME_t //no class used into this public structure
    {
...
    };

    typedef ... DBus_MYNAME_t;

    DBus_MYNAME(){
...
    }

    ~DBus_MYNAME(){}

    void set(MYNAME_t value){
...
    }

    MYNAME_t get(){
...
        return(m_MYNAME);
    }

    void setDBus(DBus_MYNAME_t value){
...
    }

    DBus_MYNAME_t getDBus(){
        DBus_MYNAME_t return_value;
...
        return(return_value);
    }

private:
    MYNAME_t m_MYNAME;
};

*/

class DBus_dataFormatConverter
{
public:
    DBus_dataFormatConverter()
    {
    }
    ~ DBus_dataFormatConverter()
    {
    }
    DBus::Variant createVariantString(std::string str)
    {
        DBus::Variant var;
        DBus::MessageIter iter = var.writer();
        iter.append_string(str.c_str());
        return var;
    }

    DBus::Variant createVariantUint16(uint16_t value)
    {
        DBus::Variant var;
        DBus::MessageIter iter = var.writer();
        iter.append_uint16(value);
        return var;
    }
};

class DBus_version : DBus_dataFormatConverter // (qqqs)
{
public:
    struct version_t
    {
        ushort major;
        ushort minor;
        ushort micro;
        std::string date;
    };

    typedef ::DBus::Struct< uint16_t, uint16_t, uint16_t, std::string > DBus_version_t;

    DBus_version(){
        m_version.major = 0;
        m_version.minor = 0;
        m_version.micro = 0;
        m_version.date = "";
    }

    ~DBus_version(){}

    void set(version_t value){
        m_version.major = value.major;
        m_version.minor = value.minor;
        m_version.micro = value.micro;
        m_version.date = value.date;
    }

    version_t get(){
        return(m_version);
    }

    void setDBus(DBus_version_t value){
        m_version.major = value._1;
        m_version.minor = value._2;
        m_version.micro = value._3;
        m_version.date = value._4;
    }

    DBus_version_t getDBus(){
        DBus_version_t return_value;
        return_value._1 = m_version.major;
        return_value._2 = m_version.minor;
        return_value._3 = m_version.micro;
        return_value._4 = m_version.date;
        return(return_value);
    }

private:
    version_t m_version;
};

class DBus_categoryDetails : DBus_dataFormatConverter // (qaqvsbsv) -->in this implementation, the two variant data are string
{
public:
    struct categoryDetails_t
    {
        uint16_t id; //Category unique id
        bool top_level; //false if predefined, true if created by plugin
        std::string name;
        std::vector<uint16_t> parents_id; //list of parent categories unique id
        std::string icons; //visual icons set
        std::string description; //short category description (optional)
        std::string media; //media associated (html web site, audio, video, ...) (optional)
    };

    typedef ::DBus::Struct< uint16_t, std::vector< uint16_t >, ::DBus::Variant, std::string, bool, std::string, ::DBus::Variant > DBus_categoryDetails_t;

    DBus_categoryDetails()
    {
        m_categoryDetails.id = 0;
        m_categoryDetails.parents_id.clear();
        m_categoryDetails.parents_id.push_back(0); //one element by default
        m_categoryDetails.icons = "";
        m_categoryDetails.name = "";
        m_categoryDetails.top_level = true;
        m_categoryDetails.description = "";
        m_categoryDetails.media = "";
    }

    ~DBus_categoryDetails(){}

    void set(categoryDetails_t value)
    {
        size_t index;
        m_categoryDetails.id = value.id;
        m_categoryDetails.parents_id.clear();
        for (index=0;index<value.parents_id.size();index++)
        {
            m_categoryDetails.parents_id.push_back(value.parents_id.at(index));
        }
        m_categoryDetails.icons = value.icons;
        m_categoryDetails.name = value.name;
        m_categoryDetails.top_level = value.top_level;
        m_categoryDetails.description = value.description;
        m_categoryDetails.media = value.media;
    }

    categoryDetails_t get()
    {
        return(m_categoryDetails);
    }

    void setDBus(DBus_categoryDetails_t value)
    {
        size_t index;
        m_categoryDetails.id =  value._1;
        m_categoryDetails.parents_id.clear();
        for (index=0;index<value._2.size();index++)
        {
            m_categoryDetails.parents_id.push_back(value._2.at(index));
        }
        m_categoryDetails.icons = value._3.reader().get_string();
        m_categoryDetails.name = value._4;
        m_categoryDetails.top_level = value._5;
        m_categoryDetails.description = value._6;
        m_categoryDetails.description = value._7.reader().get_string();
    }

    DBus_categoryDetails_t getDBus()
    {
        size_t index;
        DBus_categoryDetails_t return_value;

        return_value._1 = m_categoryDetails.id;
        return_value._2.clear();
        for (index=0;index<m_categoryDetails.parents_id.size();index++)
        {
            return_value._2.push_back(m_categoryDetails.parents_id.at(index));
        }
        return_value._3 = createVariantString(m_categoryDetails.icons);
        return_value._4 = m_categoryDetails.name;
        return_value._5 = m_categoryDetails.top_level;
        return_value._6 = m_categoryDetails.description;
        return_value._7 = createVariantString(m_categoryDetails.media);
        return(return_value);
    }

private:
    categoryDetails_t m_categoryDetails;
};

class DBus_categoryOperator : DBus_dataFormatConverter // (qs)
{
public:
    struct categoryOperator_t
    {
        uint16_t id; //enum(INVALID,MORE_THAN,LESS_THAN,EQUAL, ....)
        std::string name; //attribute operator name
    };

    typedef::DBus::Struct< uint16_t, std::string > DBus_categoryOperator_t;

    DBus_categoryOperator(){
        m_categoryOperator.id = 0;
        m_categoryOperator.name = "";
    }

    ~DBus_categoryOperator(){
    }

    void set(categoryOperator_t value){
        m_categoryOperator.id = value.id;
        m_categoryOperator.name = value.name;
    }

    categoryOperator_t get(){
        return(m_categoryOperator);
    }

    void setDBus(DBus_categoryOperator_t value){
        m_categoryOperator.id = value._1;
        m_categoryOperator.name = value._2;
    }

    DBus_categoryOperator_t getDBus(){
        DBus_categoryOperator_t return_value;
        return_value._1 = m_categoryOperator.id;
        return_value._2 = m_categoryOperator.name;
        return(return_value);
    }

private:
    categoryOperator_t m_categoryOperator;
};

class DBus_categoryAttribute : DBus_dataFormatConverter // (sqa(qs))
{
public:
    struct categoryAttribute_t
    {
        std::string name; //attribute unique name
        uint16_t type; //enum(INVALID,STRING,INTEGER,COORDINATES ...)
        std::vector<DBus_categoryOperator::categoryOperator_t > oper;
    };

    typedef ::DBus::Struct< std::string, uint16_t, std::vector< ::DBus::Struct< uint16_t, std::string > > > DBus_categoryAttribute_t;

    DBus_categoryAttribute(){
        DBus_categoryOperator op;
        m_categoryAttribute.name = "";
        m_categoryAttribute.type = 0;
        m_categoryAttribute.oper.clear();
        m_categoryAttribute.oper.push_back(op.get()); //one element by default
    }

    ~DBus_categoryAttribute(){
    }

    void set(categoryAttribute_t value){
        size_t index;
        m_categoryAttribute.name = value.name;
        m_categoryAttribute.type = value.type;
        m_categoryAttribute.oper.clear();
        for (index=0;index<value.oper.size();index++)
        {
            m_categoryAttribute.oper.push_back(value.oper.at(index));
        }
    }

    categoryAttribute_t get(){
        return(m_categoryAttribute);
    }

    void setDBus(DBus_categoryAttribute_t value){
        size_t index;
        DBus_categoryOperator op;
        m_categoryAttribute.name = value._1;
        m_categoryAttribute.type = value._2;
        m_categoryAttribute.oper.clear();
        for (index=0;index<value._3.size();index++)
        {
            op.setDBus(value._3.at(index));
            m_categoryAttribute.oper.push_back(op.get());
        }
    }

    DBus_categoryAttribute_t getDBus(){
        DBus_categoryAttribute_t return_value;
        size_t index;
        DBus_categoryOperator op;
        return_value._1 = m_categoryAttribute.name;
        return_value._2 = m_categoryAttribute.type;
        return_value._3.clear();
        for (index=0;index<m_categoryAttribute.oper.size();index++)
        {
            op.set(m_categoryAttribute.oper.at(index));
            return_value._3.push_back(op.getDBus());
        }
        return(return_value);
    }

private:
    categoryAttribute_t m_categoryAttribute;
};

class DBus_categorySortOption : DBus_dataFormatConverter // (qs)
{
public:
    struct categorySortOption_t
    {
        ushort id; //enum(GENIVI_POISERVICE_SORT_DEFAULT,GENIVI_POISERVICE_SORT_BY_DISTANCE,GENIVI_POISERVICE_SORT_BY_TIME ... )
        std::string name; //name to be displayed by application
    };

    typedef ::DBus::Struct< uint16_t, std::string > DBus_categorySortOption_t;

    DBus_categorySortOption(){
        m_categorySortOption.id = 0;
        m_categorySortOption.name = "";
    }

    ~DBus_categorySortOption(){
    }

    void set(categorySortOption_t value){
        m_categorySortOption.id = value.id;
        m_categorySortOption.name = value.name;
    }

    categorySortOption_t get(){
        return(m_categorySortOption);
    }

    void setDBus(DBus_categorySortOption_t value){
        m_categorySortOption.id = value._1;
        m_categorySortOption.name = value._2;
    }

    DBus_categorySortOption_t getDBus(){
        DBus_categorySortOption_t return_value;
        return_value._1 = m_categorySortOption.id;
        return_value._2 = m_categorySortOption.name;
        return(return_value);
    }

private:
    categorySortOption_t m_categorySortOption;
};

class DBus_category : DBus_dataFormatConverter // ((qaqvsbsv)a(sqa(qs))a(qs))
{
public:
    struct category_t
    {
        DBus_categoryDetails::categoryDetails_t details;
        std::vector<DBus_categoryAttribute::categoryAttribute_t> attributes;
        std::vector<DBus_categorySortOption::categorySortOption_t> sortOptions;
    };

    typedef ::DBus::Struct< ::DBus::Struct< uint16_t, std::vector< uint16_t >, ::DBus::Variant, std::string, bool, std::string, ::DBus::Variant >, std::vector< ::DBus::Struct< std::string, uint16_t, std::vector< ::DBus::Struct< uint16_t, std::string > > > >, std::vector< ::DBus::Struct< uint16_t, std::string > > > DBus_category_t;

    DBus_category()
    {
        DBus_categoryDetails details;
        DBus_categoryAttribute attrib;
        DBus_categorySortOption sortOption;

        m_category.details = details.get();
        m_category.attributes.clear();
        m_category.attributes.push_back(attrib.get()); //one element by default
        m_category.sortOptions.clear();
        m_category.sortOptions.push_back(sortOption.get()); //one element by default
    }

    ~ DBus_category(){}

    void set(category_t value)
    {
        size_t index;
        m_category.details = value.details;
        m_category.attributes.clear();
        for (index=0;index<value.attributes.size();index++)
        {
            m_category.attributes.push_back(value.attributes.at(index));
        }
        m_category.sortOptions.clear();
        for (index=0;index<value.sortOptions.size();index++)
        {
            m_category.sortOptions.push_back(value.sortOptions.at(index));
        }
    }

    category_t get()
    {
        return(m_category);
    }

    void setDBus(DBus_category_t value)
    {
        size_t index;
        DBus_categoryDetails details;
        DBus_categoryAttribute attrib;
        DBus_categorySortOption sortOption;

        details.setDBus(value._1);
        m_category.details = details.get();
        m_category.attributes.clear();
        for (index=0;index<value._2.size();index++)
        {
            attrib.setDBus(value._2.at(index));
            m_category.attributes.push_back(attrib.get());
        }
        m_category.sortOptions.clear();
        for (index=0;index<value._3.size();index++)
        {
            sortOption.setDBus(value._3.at(index));
            m_category.sortOptions.push_back(sortOption.get());
        }
    }

    DBus_category_t getDBus()
    {
        DBus_category_t return_value;
        size_t index;
        DBus_categoryDetails details;
        DBus_categoryAttribute attrib;
        DBus_categorySortOption sortOption;

        details.set(m_category.details);
        return_value._1 = details.getDBus();
        return_value._2.clear();
        for(index=0;index<m_category.attributes.size();index++)
        {
            attrib.set(m_category.attributes.at(index));
            return_value._2.push_back(attrib.getDBus());
        }
        return_value._3.clear();
        for(index=0;index<m_category.sortOptions.size();index++)
        {
            sortOption.set(m_category.sortOptions.at(index));
            return_value._3.push_back(sortOption.getDBus());
        }
        return(return_value);
    }

private:
    category_t m_category;
};

class DBus_categoryId : DBus_dataFormatConverter // (qb)
{
public:
    struct categoryId_t
    {
        ushort id;
        bool top_level; //false if predefined, true if created by plugin
    };

    typedef ::DBus::Struct< uint16_t, bool > DBus_categoryId_t;


    DBus_categoryId(){
        m_categoryId.id = 0;
        m_categoryId.top_level = true;
    }

    ~DBus_categoryId(){}

    void set(categoryId_t value){
        m_categoryId.id = value.id;
        m_categoryId.top_level = value.top_level;
    }

    categoryId_t get(){
        return(m_categoryId);
    }

    void setDBus(DBus_categoryId_t value){
        m_categoryId.id = value._1;
        m_categoryId.top_level = value._2;
    }

    DBus_categoryId_t getDBus(){
        DBus_categoryId_t return_value;
        return_value._1 = m_categoryId.id;
        return_value._2 = m_categoryId.top_level;
        return(return_value);
    }

private:
    categoryId_t m_categoryId;
};

class DBus_categoryReason : DBus_dataFormatConverter // (qq)
{
public:
    struct categoryReason_t
    {
        ushort id;
        ushort reason; //enum(ADDED,REMOVED,ATTR_ADDED,ATTR_MODIFIED,ATTR_REMOVED, ... )
    };

    typedef ::DBus::Struct< uint16_t,  uint16_t > DBus_categoryReason_t;


    DBus_categoryReason(){
        m_categoryReason.id = 0;
        m_categoryReason.reason = true;
    }

    ~DBus_categoryReason(){}

    void set(categoryReason_t value){
        m_categoryReason.id = value.id;
        m_categoryReason.reason = value.reason;
    }

    categoryReason_t get(){
        return(m_categoryReason);
    }

    void setDBus(DBus_categoryReason_t value){
        m_categoryReason.id = value._1;
        m_categoryReason.reason = value._2;
    }

    DBus_categoryReason_t getDBus(){
        DBus_categoryReason_t return_value;
        return_value._1 = m_categoryReason.id;
        return_value._2 = m_categoryReason.reason;
        return(return_value);
    }

private:
    categoryReason_t m_categoryReason;
};

class DBus_categoryIdName : DBus_categoryId // (qsb)
{
public:

    struct categoryIdName_t
    {
        DBus_categoryId::categoryId_t id;
        std::string name;
    };

    typedef ::DBus::Struct< uint16_t, std::string, bool > DBus_categoryIdName_t;


    DBus_categoryIdName(){
        m_categoryIdName = "";
    }

    ~DBus_categoryIdName(){}

    void set(categoryIdName_t value){
        DBus_categoryId::set(value.id);
        m_categoryIdName = value.name;
    }

    categoryIdName_t get(){
        categoryIdName_t return_value;
        return_value.id = DBus_categoryId::get();
        return_value.name = m_categoryIdName;
        return(return_value);
    }

    void setDBus(DBus_categoryIdName_t value){
        DBus_categoryId::DBus_categoryId_t id;
        id._1 = value._1;
        id._2 = value._3;
        DBus_categoryId::setDBus(id);
        m_categoryIdName = value._2;
    }

    DBus_categoryIdName_t getDBus(){
        DBus_categoryIdName_t return_value;
        DBus_categoryId::DBus_categoryId_t id;
        id = DBus_categoryId::getDBus();
        return_value._1 = id._1;
        return_value._2 = m_categoryIdName;
        return_value._3 = id._2;
        return(return_value);
    }

private:
    std::string m_categoryIdName;
};

class DBus_categoryRadius : DBus_dataFormatConverter // (qu)
{
public:
    struct categoryRadius_t
    {
        ushort id;
        uint radius;
    };

    typedef ::DBus::Struct< uint16_t, uint32_t > DBus_categoryRadius_t;

    DBus_categoryRadius(){
        m_categoryRadius.id = 0;
        m_categoryRadius.radius = 0;
    }

    ~DBus_categoryRadius(){}

    void set(categoryRadius_t value){
        m_categoryRadius.id = value.id;
        m_categoryRadius.radius = value.radius;
    }

    categoryRadius_t get(){
        return(m_categoryRadius);
    }

    void setDBus(DBus_categoryRadius_t value){
        m_categoryRadius.id = value._1;
        m_categoryRadius.radius = value._2;
    }

    DBus_categoryRadius_t getDBus(){
        DBus_categoryRadius_t return_value;
        return_value._1 = m_categoryRadius.id;
        return_value._2 = m_categoryRadius.radius;
        return(return_value);
    }

private:
    categoryRadius_t m_categoryRadius;
};

class DBus_attribute : DBus_dataFormatConverter // (sqv) -->in this implementation, the variant data is a string
{
public:
    struct attribute_t
    {
        std::string name;
        ushort type;
        std::string value;
    };

    typedef ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > DBus_attribute_t;


    DBus_attribute(){
        m_attribute.name = "";
        m_attribute.type = 0;
        m_attribute.value = "";
    }

    ~DBus_attribute(){}

    void set(attribute_t value){
        m_attribute.name = value.name;
        m_attribute.type = value.type;
        m_attribute.value = value.value;
    }

    attribute_t get(){
        return(m_attribute);
    }

    void setDBus(DBus_attribute_t value){
        m_attribute.name = value._1;
        m_attribute.type = value._2;
        m_attribute.value = value._3.reader().get_string();
    }

    DBus_attribute_t getDBus(){
        DBus_attribute_t return_value;
        return_value._1 = m_attribute.name;
        return_value._2 = m_attribute.type;
        return_value._3 = createVariantString(m_attribute.value);
        return(return_value);
    }

private:
    attribute_t m_attribute;
};

class DBus_attributeDetails : DBus_attribute //(sqqvqb) -->in this implementation, the variant data is string
{
public:
    struct attributeDetails_t
    {
        DBus_attribute::attribute_t attribute;
        ushort poiCategory; //Category unique id
        ushort id; //enum(INVALID,MORE_THAN,LESS_THAN,EQUAL, ....)
        bool mandatory; //true if the attribute is mandatory for the search and false for optional
    };

    typedef ::DBus::Struct< std::string, uint16_t, uint16_t, ::DBus::Variant, uint16_t, bool > DBus_attributeDetails_t;


    DBus_attributeDetails(){
        m_attributeDetails.poiCategory = 0;
        m_attributeDetails.id = 0;
        m_attributeDetails.mandatory = true;
    }

    ~DBus_attributeDetails(){}

    void set(attributeDetails_t value){
        DBus_attribute::set(value.attribute);
        m_attributeDetails.poiCategory = value.poiCategory;
        m_attributeDetails.id = value.id;
        m_attributeDetails.mandatory = value.mandatory;
    }

    attributeDetails_t get(){
        attributeDetails_t return_value;
        return_value.attribute = DBus_attribute::get();
        return_value.poiCategory = m_attributeDetails.poiCategory;
        return_value.id = m_attributeDetails.id;
        return_value.mandatory = m_attributeDetails.mandatory;
        return(return_value);
    }

    void setDBus(DBus_attributeDetails_t value){
        DBus_attribute::DBus_attribute_t attribute;
        attribute._1 = value._1;
        attribute._2 = value._3;
        attribute._3 = value._4;
        DBus_attribute::setDBus(attribute);
        m_attributeDetails.poiCategory = value._2;
        m_attributeDetails.id = value._5;
        m_attributeDetails.mandatory = value._6;
    }

    DBus_attributeDetails_t getDBus(){
        DBus_attributeDetails_t return_value;
        DBus_attribute::DBus_attribute_t attribute;
        attribute = DBus_attribute::getDBus();
        return_value._1 = attribute._1;
        return_value._2 = m_attributeDetails.poiCategory;
        return_value._3 = attribute._2;
        return_value._4 = attribute._3;
        return_value._5 = m_attributeDetails.id;
        return_value._6 = m_attributeDetails.mandatory;
        return(return_value);
    }

private:
    attributeDetails_t m_attributeDetails;
};

class DBus_poiAttribute : DBus_dataFormatConverter // (sqv) -->in this implementation, the variant data depends on the value of 'type'
{
public:
    struct poiAttribute_t
    {
        std::string name;
        ushort type;
        std::string value;
    };

    typedef ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > DBus_poiAttribute_t;


    DBus_poiAttribute(){
        m_poiAttribute.name = "";
        m_poiAttribute.type = 0;
        m_poiAttribute.value = "";
    }

    ~DBus_poiAttribute(){}

    void set(poiAttribute_t value){
        m_poiAttribute.name = value.name;
        m_poiAttribute.type = value.type;
        m_poiAttribute.value = value.value;
    }

    poiAttribute_t get(){
        return(m_poiAttribute);
    }

    void setDBus(DBus_poiAttribute_t value){
        std::ostringstream oss;
        uint16_t number;
        m_poiAttribute.name = value._1;
        m_poiAttribute.type = value._2;
        if (m_poiAttribute.type == GENIVI_POISERVICE_STRING)
            m_poiAttribute.value = value._3.reader().get_string();
        else
        { // it's a GENIVI_POISERVICE_INTEGER
           number =  value._3.reader().get_uint16();
           oss << number;
           m_poiAttribute.value = oss.str(); //convert to a string
        }
    }

    DBus_poiAttribute_t getDBus(){
        DBus_poiAttribute_t return_value;
        std::istringstream iss;
        uint16_t number;
        return_value._1 = m_poiAttribute.name;
        return_value._2 = m_poiAttribute.type;
        if (m_poiAttribute.type == GENIVI_POISERVICE_STRING)
            return_value._3 = createVariantString(m_poiAttribute.value);
        else
        {
            iss.str(m_poiAttribute.value);
            iss >> number; //get the numeric value
            return_value._3 = createVariantUint16(number);
        }

        return(return_value);
    }

private:
    poiAttribute_t m_poiAttribute;
};

class DBus_poiDetails : DBus_dataFormatConverter //(usddi)
{
public:
    struct poiDetails_t
    {
        uint id;
        std::string name;
        double latitude;
        double longitude;
        int altitude;
    };
    typedef ::DBus::Struct< uint32_t, std::string, double, double, int32_t > DBus_poiDetails_t;

    DBus_poiDetails(){
        m_poiDetails.id = 0;
        m_poiDetails.name = "";
        m_poiDetails.latitude = 48.85792; //by default center of Paris
        m_poiDetails.longitude = 2.3383145;
        m_poiDetails.altitude = 0;
    }

    ~DBus_poiDetails(){}

    void set(poiDetails_t value){
        m_poiDetails.id = value.id;
        m_poiDetails.name = value.name;
        m_poiDetails.latitude = value.latitude;
        m_poiDetails.longitude = value.longitude;
        m_poiDetails.altitude = value.altitude;
    }

    poiDetails_t get(){
        return(m_poiDetails);
    }

    void setDBus(DBus_poiDetails_t value){
        m_poiDetails.id = value._1;
        m_poiDetails.name = value._2;
        m_poiDetails.latitude = value._3;
        m_poiDetails.longitude = value._4;
        m_poiDetails.altitude = value._5;
    }

    DBus_poiDetails_t getDBus(){
        DBus_poiDetails_t return_value;
        return_value._1 = m_poiDetails.id;
        return_value._2 = m_poiDetails.name;
        return_value._3 = m_poiDetails.latitude;
        return_value._4 = m_poiDetails.longitude;
        return_value._5 = m_poiDetails.altitude;
        return(return_value);
    }

private:
    poiDetails_t m_poiDetails;
};

class DBus_searchResult : DBus_dataFormatConverter //(uuqa(sqv)) -->in this implementation, the variant data depends on the value of 'type'
{
public:
    struct searchResult_t
    {
        uint id;
        uint distance;
        ushort route_status;
        std::vector<DBus_poiAttribute::poiAttribute_t> attributes;
    };

    typedef ::DBus::Struct< uint32_t, uint32_t, uint16_t, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > DBus_searchResult_t;

    DBus_searchResult(){
        DBus_poiAttribute attrib;
        m_searchResult.id = 0;
        m_searchResult.distance = 0;
        m_searchResult.route_status = 0;
        m_searchResult.attributes.clear();
        m_searchResult.attributes.push_back(attrib.get());
    }

    ~DBus_searchResult(){
    }

    void set(searchResult_t value){
        size_t index;
        m_searchResult.id = value.id;
        m_searchResult.distance = value.distance;
        m_searchResult.route_status = value.route_status;
        m_searchResult.attributes.clear();
        for (index=0;index<value.attributes.size();index++)
        {
            m_searchResult.attributes.push_back(value.attributes.at(index));
        }
    }

    searchResult_t get(){
        return(m_searchResult);
    }

    void setDBus(DBus_searchResult_t value){
        size_t index;
        DBus_poiAttribute attrib;
        m_searchResult.id = value._1;
        m_searchResult.distance = value._2;
        m_searchResult.route_status = value._3;
        m_searchResult.attributes.clear();
        for (index=0;index<value._4.size();index++)
        {
            attrib.setDBus(value._4.at(index));
            m_searchResult.attributes.push_back(attrib.get());
        }
    }

    DBus_searchResult_t getDBus(){
        DBus_searchResult_t return_value;
        size_t index;
        DBus_poiAttribute attrib;
        return_value._1 = m_searchResult.id;
        return_value._2 = m_searchResult.distance;
        return_value._3 = m_searchResult.route_status;
        return_value._4.clear();
        for (index=0;index<m_searchResult.attributes.size();index++)
        {
            attrib.set(m_searchResult.attributes.at(index));
            return_value._4.push_back(attrib.getDBus());
        }
        return(return_value);
    }

private:
    searchResult_t m_searchResult;
};

class DBus_searchResultDetails : DBus_dataFormatConverter // ((usddi)aqa(sqv)) -->in this implementation, the variant data depends on the value of 'type'
{
public:
    struct searchResultDetails_t
    {
        DBus_poiDetails::poiDetails_t details;
        std::vector<ushort> categories;
        std::vector<DBus_poiAttribute::poiAttribute_t> attributes;
    };

    typedef ::DBus::Struct< ::DBus::Struct< uint32_t, std::string, double, double, int32_t >, std::vector< uint16_t >, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > DBus_searchResultDetails_t;

    DBus_searchResultDetails(){
        DBus_poiDetails details;
        DBus_poiAttribute attrib;
        m_searchResultDetails.details = details.get();
        m_searchResultDetails.categories.clear();
        m_searchResultDetails.categories.push_back(0); //one element by default
        m_searchResultDetails.attributes.clear();
        m_searchResultDetails.attributes.push_back(attrib.get()); //one element by default
    }

    ~DBus_searchResultDetails(){}

    void set(searchResultDetails_t value){
        size_t index;
        m_searchResultDetails.details = value.details;
        m_searchResultDetails.categories.clear();
        for (index=0;index<value.categories.size();index++)
        {
            m_searchResultDetails.categories.push_back(value.categories.at(index));
        }
        m_searchResultDetails.attributes.clear();
        for (index=0;index<value.attributes.size();index++)
        {
            m_searchResultDetails.attributes.push_back(value.attributes.at(index));
        }
    }

    searchResultDetails_t get(){
        return(m_searchResultDetails);
    }

    void setDBus(DBus_searchResultDetails_t value){
        size_t index;
        DBus_poiDetails details;
        DBus_poiAttribute attrib;

        details.setDBus(value._1);
        m_searchResultDetails.details = details.get();
        m_searchResultDetails.categories.clear();
        for (index=0;index<value._2.size();index++)
        {
            m_searchResultDetails.categories.push_back(value._2.at(index));
        }
        m_searchResultDetails.attributes.clear();
        for (index=0;index<value._3.size();index++)
        {
            attrib.setDBus(value._3.at(index));
            m_searchResultDetails.attributes.push_back(attrib.get());
        }
    }

    DBus_searchResultDetails_t getDBus(){
        DBus_searchResultDetails_t return_value;
        size_t index;
        DBus_poiDetails details;
        DBus_poiAttribute attrib;

        details.set(m_searchResultDetails.details);
        return_value._1 = details.getDBus();
        return_value._2.clear();
        for (index=0;index<m_searchResultDetails.categories.size();index++)
        {
            return_value._2.push_back(m_searchResultDetails.categories.at(index));
        }
        return_value._3.clear();
        for (index=0;index<m_searchResultDetails.attributes.size();index++)
        {
            attrib.set(m_searchResultDetails.attributes.at(index));
            return_value._3.push_back(attrib.getDBus());
        }

        return(return_value);
    }

private:
    searchResultDetails_t m_searchResultDetails;
};

class DBus_geoCoordinate3D : DBus_dataFormatConverter //(ddi)
{
public:
    struct geoCoordinate3D_t
    {
        double latitude;
        double longitude;
        int altitude;
    };
    typedef ::DBus::Struct< double, double, int32_t > DBus_geoCoordinate3D_t;

    DBus_geoCoordinate3D(){
        m_geoCoordinate3D.latitude = 48.85792; //by default center of Paris
        m_geoCoordinate3D.longitude = 2.3383145;
        m_geoCoordinate3D.altitude = 0;
    }

    ~DBus_geoCoordinate3D(){}

    void set(geoCoordinate3D_t value){
        m_geoCoordinate3D.latitude = value.latitude;
        m_geoCoordinate3D.longitude = value.longitude;
        m_geoCoordinate3D.altitude = value.altitude;
    }

    geoCoordinate3D_t get(){
        return(m_geoCoordinate3D);
    }

    void setDBus(DBus_geoCoordinate3D_t value){
        m_geoCoordinate3D.latitude = value._1;
        m_geoCoordinate3D.longitude = value._2;
        m_geoCoordinate3D.altitude = value._3;
    }

    DBus_geoCoordinate3D_t getDBus(){
        DBus_geoCoordinate3D_t return_value;
        return_value._1 = m_geoCoordinate3D.latitude;
        return_value._2 = m_geoCoordinate3D.longitude;
        return_value._3 = m_geoCoordinate3D.altitude;
        return(return_value);
    }

private:
    geoCoordinate3D_t m_geoCoordinate3D;
};

class DBus_poiCAMDetails : DBus_dataFormatConverter // (usq(ddi)qa(sqv)) -->in this implementation, the variant data depends on the value of 'type'
{
public:
    struct poiCAMDetails_t //no class used into this public structure
    {
        uint source_id;
        std::string name;
        ushort category;
        DBus_geoCoordinate3D::geoCoordinate3D_t location;
        ushort distance;
        std::vector<DBus_poiAttribute::poiAttribute_t> attributes;
    };

    typedef ::DBus::Struct< uint32_t, std::string, uint16_t, ::DBus::Struct< double, double, int32_t >, uint16_t, std::vector< ::DBus::Struct< std::string, uint16_t, ::DBus::Variant > > > DBus_poiCAMDetails_t;

    DBus_poiCAMDetails(){
        DBus_poiAttribute attrib;
        DBus_geoCoordinate3D loc;

        m_poiCAMDetails.source_id = 0;
        m_poiCAMDetails.name = "";
        m_poiCAMDetails.category = 0;
        m_poiCAMDetails.location = loc.get();
        m_poiCAMDetails.distance = 0;
        m_poiCAMDetails.attributes.clear();
        m_poiCAMDetails.attributes.push_back(attrib.get());
    }

    ~DBus_poiCAMDetails(){}

    void set(poiCAMDetails_t value){
        size_t index;

        m_poiCAMDetails.source_id = value.source_id;
        m_poiCAMDetails.name = value.name;
        m_poiCAMDetails.category = value.category;
        m_poiCAMDetails.location = value.location;
        m_poiCAMDetails.distance = value.distance;
        m_poiCAMDetails.attributes.clear();
        for (index=0;index<value.attributes.size();index++)
        {
            m_poiCAMDetails.attributes.push_back(value.attributes.at(index));
        }
    }

    poiCAMDetails_t get(){
        return(m_poiCAMDetails);
    }

    void setDBus(DBus_poiCAMDetails_t value){
        size_t index;
        DBus_geoCoordinate3D loc;
        DBus_poiAttribute attrib;

        m_poiCAMDetails.source_id = value._1;
        m_poiCAMDetails.name = value._2;
        m_poiCAMDetails.category = value._3;
        loc.setDBus(value._4);
        m_poiCAMDetails.location = loc.get();
        m_poiCAMDetails.distance = value._5,
        m_poiCAMDetails.attributes.clear();
        for (index=0;index<value._6.size();index++)
        {
            attrib.setDBus(value._6.at(index));
            m_poiCAMDetails.attributes.push_back(attrib.get());
        }
    }

    DBus_poiCAMDetails_t getDBus(){
        DBus_poiCAMDetails_t return_value;
        size_t index;
        DBus_geoCoordinate3D loc;
        DBus_poiAttribute attrib;

        return_value._1 = m_poiCAMDetails.source_id;
        return_value._2 = m_poiCAMDetails.name;
        return_value._3 = m_poiCAMDetails.category;
        loc.set(m_poiCAMDetails.location);
        return_value._4 = loc.getDBus();
        return_value._5 = m_poiCAMDetails.distance;
        return_value._6.clear();
        for (index=0;index<m_poiCAMDetails.attributes.size();index++)
        {
            attrib.set(m_poiCAMDetails.attributes.at(index));
            return_value._6.push_back(attrib.getDBus());
        }
        return(return_value);
    }

private:
    poiCAMDetails_t m_poiCAMDetails;
};

class DBus_CAMcategoryDetails : DBus_dataFormatConverter // (aqvssv) -->in this implementation, the variant data is string
{
public:
    struct CAMcategoryDetails_t
    {
        std::vector<ushort> parents_id;
        std::string icons;
        std::string name;
        std::string short_desc;
        std::string media;
    };

    typedef ::DBus::Struct< std::vector< uint16_t >, ::DBus::Variant, std::string, std::string, ::DBus::Variant > DBus_CAMcategoryDetails_t;

    DBus_CAMcategoryDetails(){
        m_CAMcategoryDetails.parents_id.clear();
        m_CAMcategoryDetails.parents_id.push_back(0); //one element by default
        m_CAMcategoryDetails.icons = "";
        m_CAMcategoryDetails.name = "";
        m_CAMcategoryDetails.short_desc = "";
        m_CAMcategoryDetails.media = "";
    }

    ~DBus_CAMcategoryDetails(){}

    void set(CAMcategoryDetails_t value){
        size_t index;
        m_CAMcategoryDetails.parents_id.clear();
        for (index=0;index<value.parents_id.size();index++)
        {
            m_CAMcategoryDetails.parents_id.push_back(value.parents_id.at(index));
        }
        m_CAMcategoryDetails.icons = value.icons;
        m_CAMcategoryDetails.name = value.name;
        m_CAMcategoryDetails.short_desc = value.short_desc;
        m_CAMcategoryDetails.media = value.media;
    }

   CAMcategoryDetails_t get(){
        return(m_CAMcategoryDetails);
    }

    void setDBus(DBus_CAMcategoryDetails_t value){
        size_t index;
        m_CAMcategoryDetails.parents_id.clear();
        for (index=0;index<value._1.size();index++)
        {
            m_CAMcategoryDetails.parents_id.push_back(value._1.at(index));
        }
        m_CAMcategoryDetails.icons = value._2.reader().get_string();
        m_CAMcategoryDetails.name = value._3;
        m_CAMcategoryDetails.short_desc = value._4;
        m_CAMcategoryDetails.media = value._5.reader().get_string();
    }

    DBus_CAMcategoryDetails_t getDBus(){
        DBus_CAMcategoryDetails_t return_value;
        size_t index;
        return_value._1.clear();
        for (index=0;index<m_CAMcategoryDetails.parents_id.size();index++)
        {
            return_value._1.push_back(m_CAMcategoryDetails.parents_id.at(index));
        }
        return_value._2 = createVariantString(m_CAMcategoryDetails.icons);
        return_value._3 = m_CAMcategoryDetails.name;
        return_value._4 = m_CAMcategoryDetails.short_desc;
        return_value._5 = createVariantString(m_CAMcategoryDetails.media);
        return(return_value);
    }

private:
    CAMcategoryDetails_t m_CAMcategoryDetails;
};

class DBus_CAMcategory : DBus_dataFormatConverter // ((aqvssv)a(sqa(qs))a(qs))) -->in this implementation, the variant data is string
{
public:
    struct CAMcategory_t //no class used into this public structure
    {
        DBus_CAMcategoryDetails::CAMcategoryDetails_t details;
        std::vector<DBus_categoryAttribute::categoryAttribute_t> attributes;
        std::vector<DBus_categorySortOption::categorySortOption_t> sortOptions;
    };

    typedef ::DBus::Struct< ::DBus::Struct< std::vector< uint16_t >, ::DBus::Variant, std::string, std::string, ::DBus::Variant >, std::vector< ::DBus::Struct< std::string, uint16_t, std::vector< ::DBus::Struct< uint16_t, std::string > > > >, std::vector< ::DBus::Struct< uint16_t, std::string > > > DBus_CAMcategory_t;

    DBus_CAMcategory(){
        DBus_CAMcategoryDetails details;
        DBus_categoryAttribute attrib;
        DBus_categorySortOption sortOption;

        m_CAMcategory.details = details.get();
        m_CAMcategory.attributes.clear();
        m_CAMcategory.attributes.push_back(attrib.get()); //one element by default
        m_CAMcategory.sortOptions.clear();
        m_CAMcategory.sortOptions.push_back(sortOption.get()); //one element by default
    }

    ~DBus_CAMcategory(){}

    void set(CAMcategory_t value){
        size_t index;
        m_CAMcategory.details = value.details;
        m_CAMcategory.attributes.clear();
        for (index=0;index<value.attributes.size();index++)
        {
            m_CAMcategory.attributes.push_back(value.attributes.at(index));
        }
        m_CAMcategory.sortOptions.clear();
        for (index=0;index<value.sortOptions.size();index++)
        {
            m_CAMcategory.sortOptions.push_back(value.sortOptions.at(index));
        }
    }

    CAMcategory_t get(){
        return(m_CAMcategory);
    }

    void setDBus(DBus_CAMcategory_t value){
        size_t index;
        DBus_CAMcategoryDetails details;
        DBus_categoryAttribute attrib;
        DBus_categorySortOption sortOption;

        details.setDBus(value._1);
        m_CAMcategory.details = details.get();
        m_CAMcategory.attributes.clear();
        for (index=0;index<value._2.size();index++)
        {
            attrib.setDBus(value._2.at(index));
            m_CAMcategory.attributes.push_back(attrib.get());
        }
        m_CAMcategory.sortOptions.clear();
        for (index=0;index<value._3.size();index++)
        {
            sortOption.setDBus(value._3.at(index));
            m_CAMcategory.sortOptions.push_back(sortOption.get());
        }
    }

    DBus_CAMcategory_t getDBus(){
        DBus_CAMcategory_t return_value;
        size_t index;
        DBus_CAMcategoryDetails details;
        DBus_categoryAttribute attrib;
        DBus_categorySortOption sortOption;

        details.set(m_CAMcategory.details);
        return_value._1 = details.getDBus();
        return_value._2.clear();
        for(index=0;index<m_CAMcategory.attributes.size();index++)
        {
            attrib.set(m_CAMcategory.attributes.at(index));
            return_value._2.push_back(attrib.getDBus());
        }
        return_value._3.clear();
        for(index=0;index<m_CAMcategory.sortOptions.size();index++)
        {
            sortOption.set(m_CAMcategory.sortOptions.at(index));
            return_value._3.push_back(sortOption.getDBus());
        }
        return(return_value);
    }

private:
    CAMcategory_t m_CAMcategory;
};

class DBus_CAMcategoryUpdate : DBus_dataFormatConverter // (qa(sqa(qs))a(qs)) -->in this implementation, the variant data is string
{
public:
    struct CAMcategoryUpdate_t //no class used into this public structure
    {
        ushort unique_id;
        std::vector<DBus_categoryAttribute::categoryAttribute_t> attributes;
        std::vector<DBus_categorySortOption::categorySortOption_t> sortOptions;
    };

    typedef ::DBus::Struct< uint16_t, std::vector< ::DBus::Struct< std::string, uint16_t, std::vector< ::DBus::Struct< uint16_t, std::string > > > >, std::vector< ::DBus::Struct< uint16_t, std::string > > > DBus_CAMcategoryUpdate_t;

    DBus_CAMcategoryUpdate(){
        DBus_categoryAttribute attrib;
        DBus_categorySortOption sortOption;

        m_CAMcategoryUpdate.unique_id = 0;
        m_CAMcategoryUpdate.attributes.clear();
        m_CAMcategoryUpdate.attributes.push_back(attrib.get()); //one element by default
        m_CAMcategoryUpdate.sortOptions.clear();
        m_CAMcategoryUpdate.sortOptions.push_back(sortOption.get()); //one element by default
    }

    ~DBus_CAMcategoryUpdate(){}

    void set(CAMcategoryUpdate_t value){
        size_t index;
        m_CAMcategoryUpdate.unique_id = value.unique_id;
        m_CAMcategoryUpdate.attributes.clear();
        for (index=0;index<value.attributes.size();index++)
        {
            m_CAMcategoryUpdate.attributes.push_back(value.attributes.at(index));
        }
        m_CAMcategoryUpdate.sortOptions.clear();
        for (index=0;index<value.sortOptions.size();index++)
        {
            m_CAMcategoryUpdate.sortOptions.push_back(value.sortOptions.at(index));
        }
    }

    CAMcategoryUpdate_t get(){
        return(m_CAMcategoryUpdate);
    }

    void setDBus(DBus_CAMcategoryUpdate_t value){
        size_t index;
        DBus_categoryAttribute attrib;
        DBus_categorySortOption sortOption;

        m_CAMcategoryUpdate.unique_id = value._1;
        m_CAMcategoryUpdate.attributes.clear();
        for (index=0;index<value._2.size();index++)
        {
            attrib.setDBus(value._2.at(index));
            m_CAMcategoryUpdate.attributes.push_back(attrib.get());
        }
        m_CAMcategoryUpdate.sortOptions.clear();
        for (index=0;index<value._3.size();index++)
        {
            sortOption.setDBus(value._3.at(index));
            m_CAMcategoryUpdate.sortOptions.push_back(sortOption.get());
        }
    }

    DBus_CAMcategoryUpdate_t getDBus(){
        DBus_CAMcategoryUpdate_t return_value;
        size_t index;
        DBus_categoryAttribute attrib;
        DBus_categorySortOption sortOption;

        return_value._1 = m_CAMcategoryUpdate.unique_id;
        return_value._2.clear();
        for(index=0;index<m_CAMcategoryUpdate.attributes.size();index++)
        {
            attrib.set(m_CAMcategoryUpdate.attributes.at(index));
            return_value._2.push_back(attrib.getDBus());
        }
        return_value._3.clear();
        for(index=0;index<m_CAMcategoryUpdate.sortOptions.size();index++)
        {
            sortOption.set(m_CAMcategoryUpdate.sortOptions.at(index));
            return_value._3.push_back(sortOption.getDBus());
        }
        return(return_value);
    }

private:
    CAMcategoryUpdate_t m_CAMcategoryUpdate;
};

#define ALL_CATEGORIES 0
#define INVALID_CATEGORY 0x00
#define MAX_CATEGORIES 256 //to be improved
#define CAM_CATEGORY_OFFSET 0x0100 //offset added to create the id of a category provided by a CAM (to be multiplied by the camId)
#define CAM_ATTRIBUTE_OFFSET 0x0100 //offset added to create the id of an attribute provided by a CAM (to be multiplied by the camId)

#endif
