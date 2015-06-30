/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2014, PCA Peugeot Citroen
*
* \file poi-common-dbus-data-model.h
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
#ifndef __POICOMMONDBUSDATAMODEL_H__
#define __POICOMMONDBUSDATAMODEL_H__

#include <stdbool.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <iostream>
#include <fstream>


#include <dbus-c++/dbus.h>

#include "poi-common-data-model.h"

/* How to
  The below classes are gateways between internal data and DBus data
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

    DBus::Variant createVariantBool(bool value)
    {
        DBus::Variant var;
        DBus::MessageIter iter = var.writer();
        iter.append_bool(value);
        return var;
    }

    DBus::Variant createVariantUint16(uint16_t value)
    {
        DBus::Variant var;
        DBus::MessageIter iter = var.writer();
        iter.append_uint16(value);
        return var;
    }

    DBus::Variant createVariantInt32(int32_t value)
    {
        DBus::Variant var;
        DBus::MessageIter iter = var.writer();
        iter.append_int32(value);
        return var;
    }

    DBus::Variant createVariantArrayUint16(std::vector< uint16_t > value)
    {
        DBus::Variant var;
        DBus::MessageIter iter=var.writer();
        iter << value;
        return var;
    }

    DBus::Variant createVariantUint32(uint32_t value)
    {
        DBus::Variant var;
        DBus::MessageIter iter = var.writer();
        iter.append_uint32(value);
        return var;
    }

    DBus::Variant createVariantArrayUint32(std::vector< uint32_t > value)
    {
        DBus::Variant var;
        DBus::MessageIter iter=var.writer();
        iter << value;
        return var;
    }

};

class DBus_variantIcon : DBus_dataFormatConverter // (yv)
{
public:
    enum {
        AS_VECTOR_OF_ID = 0,
        AS_STRING = 1,
    };

    struct Icon_t
    {
        std::vector<resourceId_t> id;
        std::string url;
    };

    struct variantIcon_t
    {
        uint8_t index;
        Icon_t content;
    };

    typedef ::DBus::Struct< uint8_t, ::DBus::Variant > DBus_variantIcon_t;


    DBus_variantIcon(){
        m_variantIcon.index = AS_STRING;
        m_variantIcon.content.id.clear();
        m_variantIcon.content.url = "";
    }

    ~DBus_variantIcon(){}

    void set(variantIcon_t value){
        size_t index;

        switch (value.index) {
        case 0:
            m_variantIcon.content.id.clear();
            for (index=0;index<value.content.id.size();index++)
            {
                m_variantIcon.content.id.push_back(value.content.id.at(index));
            }
            break;
        case 1:
            m_variantIcon.content.url = value.content.url;
        default:
            break;
        }
    }

    variantIcon_t get(){
        return(m_variantIcon);
    }

    void setDBus(DBus_variantIcon_t value){
        size_t index;
        std::string *str;

        m_variantIcon.index = value._1;
        switch (value._1) {
        case 0:
            value._2.reader().get_array(str);
            m_variantIcon.content.id.clear();

            for (index=0;index<str->size();index++)
            {
                m_variantIcon.content.id.push_back(str->at(index));
            }
            break;
        case 1:
            m_variantIcon.content.url = value._2.reader().get_string();
        default:
            break;
        }
    }

    DBus_variantIcon_t getDBus(){
        size_t index;
        DBus_variantIcon_t return_value;

        return_value._1 = m_variantIcon.index;

        switch (m_variantIcon.index) {
        case 0:
            return_value._2.clear();
            for (index=0;index<m_variantIcon.content.id.size();index++)
            {
                return_value._2 = createVariantArrayUint32(m_variantIcon.content.id);
            }
            break;
        case 1:
            return_value._2 = createVariantString(m_variantIcon.content.url);
        default:
            break;
        }

        return(return_value);
    }

private:
    variantIcon_t m_variantIcon;
};

class DBus_variantMedia : DBus_dataFormatConverter // (yv)
{
public:
    enum {
        AS_VECTOR_OF_ID = 0,
        AS_STRING = 1,
    };

    struct Media_t
    {
        std::vector<resourceId_t> id;
        std::string url;
    };

    struct variantMedia_t
    {
        uint8_t index;
        Media_t content;
    };

    typedef ::DBus::Struct< uint8_t, ::DBus::Variant > DBus_variantMedia_t;

    DBus_variantMedia(){
        m_variantMedia.index = AS_STRING;
        m_variantMedia.content.id.clear();
        m_variantMedia.content.url = "";
    }

    ~DBus_variantMedia(){}

    void set(variantMedia_t value){
        size_t index;

        switch (value.index) {
        case 0:
            m_variantMedia.content.id.clear();
            for (index=0;index<value.content.id.size();index++)
            {
                m_variantMedia.content.id.push_back(value.content.id.at(index));
            }
            break;
        case 1:
            m_variantMedia.content.url = value.content.url;
        default:
            break;
        }
    }

    variantMedia_t get(){
        return(m_variantMedia);
    }

    void setDBus(DBus_variantMedia_t value){
        size_t index;
        std::string *str;

        m_variantMedia.index = value._1;
        switch (value._1) {
        case 0:
            value._2.reader().get_array(str);
            m_variantMedia.content.id.clear();

            for (index=0;index<str->size();index++)
            {
                m_variantMedia.content.id.push_back(str->at(index));
            }
            break;
        case 1:
            m_variantMedia.content.url = value._2.reader().get_string();
        default:
            break;
        }
    }

    DBus_variantMedia_t getDBus(){
        size_t index;
        DBus_variantMedia_t return_value;

        return_value._1 = m_variantMedia.index;

        switch (m_variantMedia.index) {
        case 0:
            return_value._2.clear();
            for (index=0;index<m_variantMedia.content.id.size();index++)
            {
                return_value._2 = createVariantArrayUint32(m_variantMedia.content.id);
            }
            break;
        case 1:
            return_value._2 = createVariantString(m_variantMedia.content.url);
        default:
            break;
        }

        return(return_value);
    }

private:
    variantMedia_t m_variantMedia;
};

class DBus_variantAttributeValue : DBus_dataFormatConverter // (yv)
{
public:
    enum {
        AS_INT32 = 0,
        AS_STRING = 1,
        AS_BOOL = 2
    };

    struct AttributeValue_t
    {
        int32_t intValue;
        std::string stringValue;
        bool boolValue;
    };

    struct variantAttributeValue_t
    {
        uint8_t index;
        AttributeValue_t content;
    };

    typedef ::DBus::Struct< uint8_t, ::DBus::Variant > DBus_variantAttributeValue_t;

    DBus_variantAttributeValue(){
        m_variantAttributeValue.index = AS_INT32;
        m_variantAttributeValue.content.intValue = 0;
        m_variantAttributeValue.content.stringValue = "";
        m_variantAttributeValue.content.boolValue = false;
    }

    ~DBus_variantAttributeValue(){}

    void set(variantAttributeValue_t value){

        switch (value.index) {
        case 0:
            m_variantAttributeValue.content.intValue = value.content.intValue;
            break;
        case 1:
            m_variantAttributeValue.content.stringValue = value.content.stringValue;
        case 2:
            m_variantAttributeValue.content.boolValue = value.content.boolValue;
        default:
            break;
        }
    }

    variantAttributeValue_t get(){
        return(m_variantAttributeValue);
    }

    void setDBus(DBus_variantAttributeValue_t value){
        m_variantAttributeValue.index = value._1;
        switch (value._1) {
        case 0:
            m_variantAttributeValue.content.intValue = value._2.reader().get_int32();
            break;
        case 1:
            m_variantAttributeValue.content.stringValue = value._2.reader().get_string();
        case 2:
            m_variantAttributeValue.content.boolValue = value._2.reader().get_bool();
        default:
            break;
        }
    }

    DBus_variantAttributeValue_t getDBus(){
        DBus_variantAttributeValue_t return_value;

        return_value._1 = m_variantAttributeValue.index;

        switch (m_variantAttributeValue.index) {
        case 0:
            return_value._2 = createVariantInt32(m_variantAttributeValue.content.intValue);
            break;
        case 1:
            return_value._2 = createVariantString(m_variantAttributeValue.content.stringValue);
        case 2:
            return_value._2 = createVariantBool(m_variantAttributeValue.content.boolValue);
        default:
            break;
        }

        return(return_value);
    }

private:
    variantAttributeValue_t m_variantAttributeValue;
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

class DBus_categoryDetails : DBus_dataFormatConverter // (uau(yv)sbs(yv))
{
public:
    struct categoryDetails_t
    {
        categoryId_t id; //Category unique id
        std::vector<categoryId_t> parents_id; //list of parent categories unique id
        DBus_variantIcon::variantIcon_t icons; //visual icons set
        std::string name;
        bool top_level; //false if predefined, true if created by plugin
        std::string description; //short category description (optional)
        DBus_variantMedia::variantMedia_t media; //media associated (html web site, audio, video, ...) (optional)
    };

    typedef ::DBus::Struct< uint32_t, std::vector< uint32_t >, ::DBus::Struct< uint8_t, ::DBus::Variant >, std::string, bool, std::string, ::DBus::Struct< uint8_t, ::DBus::Variant > > DBus_categoryDetails_t;

    DBus_categoryDetails()
    {
        DBus_variantIcon icons;
        DBus_variantMedia media;

        m_categoryDetails.id = 0;
        m_categoryDetails.parents_id.clear();
        m_categoryDetails.icons = icons.get();
        m_categoryDetails.name = "";
        m_categoryDetails.top_level = true;
        m_categoryDetails.description = "";
        m_categoryDetails.media = media.get();
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
        DBus_variantIcon icons;
        DBus_variantMedia media;

        m_categoryDetails.id =  value._1;
        m_categoryDetails.parents_id.clear();
        for (index=0;index<value._2.size();index++)
        {
            m_categoryDetails.parents_id.push_back(value._2.at(index));
        }
        icons.setDBus(value._3);
        m_categoryDetails.icons = icons.get();
        m_categoryDetails.name = value._4;
        m_categoryDetails.top_level = value._5;
        m_categoryDetails.description = value._6;
        media.setDBus(value._7);
        m_categoryDetails.media = media.get();
    }

    DBus_categoryDetails_t getDBus()
    {
        size_t index;
        DBus_variantIcon icons;
        DBus_variantMedia media;
        DBus_categoryDetails_t return_value;

        return_value._1 = m_categoryDetails.id;
        return_value._2.clear();
        for (index=0;index<m_categoryDetails.parents_id.size();index++)
        {
            return_value._2.push_back(m_categoryDetails.parents_id.at(index));
        }
        icons.set(m_categoryDetails.icons);
        return_value._3 = icons.getDBus();
        return_value._4 = m_categoryDetails.name;
        return_value._5 = m_categoryDetails.top_level;
        return_value._6 = m_categoryDetails.description;
        media.set(m_categoryDetails.media);
        return_value._7 = media.getDBus();
        return(return_value);
    }

private:
    categoryDetails_t m_categoryDetails;
};

class DBus_categoryOperator : DBus_dataFormatConverter // (is(yv))
{
public:
    struct categoryOperator_t
    {
        int32_t type; //attribute operator type enum(INVALID,MORE_THAN,LESS_THAN,EQUAL, ....)
        std::string name; //attribute operator name
        DBus_variantAttributeValue::variantAttributeValue_t value; //attribute operator value
    };

    typedef ::DBus::Struct< int32_t, std::string, ::DBus::Struct< uint8_t, ::DBus::Variant > > DBus_categoryOperator_t;

    DBus_categoryOperator(){
        DBus_variantAttributeValue attributeValue;

        m_categoryOperator.type = 0;
        m_categoryOperator.name = "";
        m_categoryOperator.value = attributeValue.get();
    }

    ~DBus_categoryOperator(){
    }

    void set(categoryOperator_t value){
        m_categoryOperator.type = value.type;
        m_categoryOperator.name = value.name;
        m_categoryOperator.value = value.value;
    }

    categoryOperator_t get(){
        return(m_categoryOperator);
    }

    void setDBus(DBus_categoryOperator_t value){
        DBus_variantAttributeValue attributeValue;

        m_categoryOperator.type = value._1;
        m_categoryOperator.name = value._2;

        attributeValue.setDBus(value._3);
        m_categoryOperator.value = attributeValue.get();
    }

    DBus_categoryOperator_t getDBus(){
        DBus_categoryOperator_t return_value;
        DBus_variantAttributeValue attributeValue;

        return_value._1 = m_categoryOperator.type;
        return_value._2 = m_categoryOperator.name;

        attributeValue.set(m_categoryOperator.value);
        return_value._3 = attributeValue.getDBus();

        return(return_value);
    }

private:
    categoryOperator_t m_categoryOperator;
};

class DBus_categoryAttribute : DBus_dataFormatConverter // (usia(is(yv)))
{
public:
    struct categoryAttribute_t
    {
        attributeId_t id; //attribute unique id
        std::string name; //attribute unique name
        int32_t type; //enum(INVALID,STRING,INTEGER,COORDINATES ...)
        std::vector<DBus_categoryOperator::categoryOperator_t > oper;
    };

    typedef ::DBus::Struct< uint32_t, std::string, int32_t, std::vector< ::DBus::Struct< int32_t, std::string, ::DBus::Struct< uint8_t, ::DBus::Variant > > > > DBus_categoryAttribute_t;

    DBus_categoryAttribute(){
        m_categoryAttribute.id = 0;
        m_categoryAttribute.name = "";
        m_categoryAttribute.type = 0;
        m_categoryAttribute.oper.clear();
    }

    ~DBus_categoryAttribute(){
    }

    void set(categoryAttribute_t value){
        size_t index;
        m_categoryAttribute.id = value.id;
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
        m_categoryAttribute.id = value._1;
        m_categoryAttribute.name = value._2;
        m_categoryAttribute.type = value._3;
        m_categoryAttribute.oper.clear();
        for (index=0;index<value._4.size();index++)
        {
            op.setDBus(value._4.at(index));
            m_categoryAttribute.oper.push_back(op.get());
        }
    }

    DBus_categoryAttribute_t getDBus(){
        DBus_categoryAttribute_t return_value;
        size_t index;
        DBus_categoryOperator op;
        return_value._1 = m_categoryAttribute.id;
        return_value._2 = m_categoryAttribute.name;
        return_value._3 = m_categoryAttribute.type;
        return_value._4.clear();
        for (index=0;index<m_categoryAttribute.oper.size();index++)
        {
            op.set(m_categoryAttribute.oper.at(index));
            return_value._4.push_back(op.getDBus());
        }
        return(return_value);
    }

private:
    categoryAttribute_t m_categoryAttribute;
};

class DBus_categorySortOption : DBus_dataFormatConverter // (us)
{
public:
    struct categorySortOption_t
    {
        uint32_t id; //enum(GENIVI_POISERVICE_SORT_DEFAULT,GENIVI_POISERVICE_SORT_BY_DISTANCE,GENIVI_POISERVICE_SORT_BY_TIME ... )
        std::string name; //name to be displayed by application
    };

    typedef ::DBus::Struct< uint32_t, std::string > DBus_categorySortOption_t;

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

class DBus_category : DBus_dataFormatConverter // ( (uau(yv)sbs(yv)) a(usia(is(yv))) a(us) )
{
public:
    struct category_t
    {
        DBus_categoryDetails::categoryDetails_t details;
        std::vector<DBus_categoryAttribute::categoryAttribute_t> attributes;
        std::vector<DBus_categorySortOption::categorySortOption_t> sortOptions;
    };

    typedef ::DBus::Struct< ::DBus::Struct< uint32_t, std::vector< uint32_t >, ::DBus::Struct< uint8_t, ::DBus::Variant >, std::string, bool, std::string, ::DBus::Struct< uint8_t, ::DBus::Variant > >, std::vector< ::DBus::Struct< uint32_t, std::string, int32_t, std::vector< ::DBus::Struct< int32_t, std::string, ::DBus::Struct< uint8_t, ::DBus::Variant > > > > >, std::vector< ::DBus::Struct< uint32_t, std::string > > > DBus_category_t;

    DBus_category()
    {
        DBus_categoryDetails details;

        m_category.details = details.get();
        m_category.attributes.clear();
        m_category.sortOptions.clear();
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

class DBus_categoryIdLevel : DBus_dataFormatConverter // (ub)
{
public:
    struct categoryIdLevel_t
    {
        categoryId_t id;
        bool top_level; //false if predefined, true if created by plugin
    };

    typedef ::DBus::Struct< uint32_t, bool > DBus_categoryIdLevel_t;


    DBus_categoryIdLevel(){
        m_categoryIdLevel.id = 0;
        m_categoryIdLevel.top_level = true;
    }

    ~DBus_categoryIdLevel(){}

    void set(categoryIdLevel_t value){
        m_categoryIdLevel.id = value.id;
        m_categoryIdLevel.top_level = value.top_level;
    }

    categoryIdLevel_t get(){
        return(m_categoryIdLevel);
    }

    void setDBus(DBus_categoryIdLevel_t value){
        m_categoryIdLevel.id = value._1;
        m_categoryIdLevel.top_level = value._2;
    }

    DBus_categoryIdLevel_t getDBus(){
        DBus_categoryIdLevel_t return_value;
        return_value._1 = m_categoryIdLevel.id;
        return_value._2 = m_categoryIdLevel.top_level;
        return(return_value);
    }

private:
    categoryIdLevel_t m_categoryIdLevel;
};

class DBus_categoryReason : DBus_dataFormatConverter // (uq)
{
public:
    struct categoryReason_t
    {
        categoryId_t id;
        ushort reason; //enum(ADDED,REMOVED,ATTR_ADDED,ATTR_MODIFIED,ATTR_REMOVED, ... )
    };

    typedef ::DBus::Struct< uint32_t,  uint16_t > DBus_categoryReason_t;


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

class DBus_categoryIdName : DBus_categoryIdLevel // (usb)
{
public:

    struct categoryIdName_t
    {
        DBus_categoryIdLevel::categoryIdLevel_t id;
        std::string name;
    };

    typedef ::DBus::Struct< uint32_t, std::string, bool > DBus_categoryIdName_t;


    DBus_categoryIdName(){
        m_categoryIdName = "";
    }

    ~DBus_categoryIdName(){}

    void set(categoryIdName_t value){
        DBus_categoryIdLevel::set(value.id);
        m_categoryIdName = value.name;
    }

    categoryIdName_t get(){
        categoryIdName_t return_value;
        return_value.id = DBus_categoryIdLevel::get();
        return_value.name = m_categoryIdName;
        return(return_value);
    }

    void setDBus(DBus_categoryIdName_t value){
        DBus_categoryIdLevel::DBus_categoryIdLevel_t id;
        id._1 = value._1;
        id._2 = value._3;
        DBus_categoryIdLevel::setDBus(id);
        m_categoryIdName = value._2;
    }

    DBus_categoryIdName_t getDBus(){
        DBus_categoryIdName_t return_value;
        DBus_categoryIdLevel::DBus_categoryIdLevel_t id;
        id = DBus_categoryIdLevel::getDBus();
        return_value._1 = id._1;
        return_value._2 = m_categoryIdName;
        return_value._3 = id._2;
        return(return_value);
    }

private:
    std::string m_categoryIdName;
};

class DBus_categoryRadius : DBus_dataFormatConverter // (uu)
{
public:
    struct categoryRadius_t
    {
        categoryId_t id;
        uint radius;
    };

    typedef ::DBus::Struct< uint32_t, uint32_t > DBus_categoryRadius_t;

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

class DBus_poiAttribute : DBus_dataFormatConverter // (ui(yv))
{
public:
    struct poiAttribute_t
    {
        attributeId_t id;
        int32_t type;
        DBus_variantAttributeValue::variantAttributeValue_t value;
    };

    typedef ::DBus::Struct< uint32_t, int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant  > > DBus_poiAttribute_t;


    DBus_poiAttribute(){
        DBus_variantAttributeValue attributeValue;

        m_attribute.id = 0;
        m_attribute.type = 0;
        m_attribute.value = attributeValue.get();
    }

    ~DBus_poiAttribute(){}

    void set(poiAttribute_t value){
        m_attribute.id = value.id;
        m_attribute.type = value.type;
        m_attribute.value = value.value;
    }

    poiAttribute_t get(){
        return(m_attribute);
    }

    void setDBus(DBus_poiAttribute_t value){
        DBus_variantAttributeValue attributeValue;

        m_attribute.id = value._1;
        m_attribute.type = value._2;
        attributeValue.setDBus(value._3);
        m_attribute.value = attributeValue.get();
    }

    DBus_poiAttribute_t getDBus(){
        DBus_poiAttribute_t return_value;
        DBus_variantAttributeValue attributeValue;

        return_value._1 = m_attribute.id;
        return_value._2 = m_attribute.type;
        attributeValue.set(m_attribute.value);
        return_value._3 = attributeValue.getDBus();
        return(return_value);
    }

private:
    poiAttribute_t m_attribute;
};

class DBus_attributeDetails : DBus_poiAttribute //(uui(yv)ib)
{
public:
    struct attributeDetails_t
    {
        DBus_poiAttribute::poiAttribute_t attribute;
        categoryId_t categoryId; //Category unique id
        int32_t oper; //enum(INVALID,MORE_THAN,LESS_THAN,EQUAL, ....)
        bool mandatory; //true if the attribute is mandatory for the search and false for optional
    };

    typedef ::DBus::Struct< uint32_t, uint32_t, int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant >, int32_t, bool > DBus_attributeDetails_t;


    DBus_attributeDetails(){
        DBus_poiAttribute attribute;

        m_attributeDetails.attribute = attribute.get();
        m_attributeDetails.categoryId = 0;
        m_attributeDetails.oper = 0;
        m_attributeDetails.mandatory = true;
    }

    ~DBus_attributeDetails(){}

    void set(attributeDetails_t value){
        DBus_poiAttribute::set(value.attribute);
        m_attributeDetails.categoryId = value.categoryId;
        m_attributeDetails.oper = value.oper;
        m_attributeDetails.mandatory = value.mandatory;
    }

    attributeDetails_t get(){
        attributeDetails_t return_value;
        return_value.attribute = DBus_poiAttribute::get();
        return_value.categoryId = m_attributeDetails.categoryId;
        return_value.oper = m_attributeDetails.oper;
        return_value.mandatory = m_attributeDetails.mandatory;
        return(return_value);
    }

    void setDBus(DBus_attributeDetails_t value){
        DBus_poiAttribute::DBus_poiAttribute_t attribute;
        attribute._1 = value._1;
        attribute._2 = value._3;
        attribute._3 = value._4;
        DBus_poiAttribute::setDBus(attribute);
        m_attributeDetails.categoryId = value._2;
        m_attributeDetails.oper = value._5;
        m_attributeDetails.mandatory = value._6;
    }

    DBus_attributeDetails_t getDBus(){
        DBus_attributeDetails_t return_value;
        DBus_poiAttribute::DBus_poiAttribute_t attribute;
        attribute = DBus_poiAttribute::getDBus();
        return_value._1 = attribute._1;
        return_value._2 = m_attributeDetails.categoryId;
        return_value._3 = attribute._2;
        return_value._4 = attribute._3;
        return_value._5 = m_attributeDetails.oper;
        return_value._6 = m_attributeDetails.mandatory;
        return(return_value);
    }

private:
    attributeDetails_t m_attributeDetails;
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

class DBus_poiDetails : DBus_dataFormatConverter //(us(ddi))
{
public:
    struct poiDetails_t
    {
        poiId_t id;
        std::string name;
        DBus_geoCoordinate3D::geoCoordinate3D_t location;
    };
    typedef ::DBus::Struct< uint32_t, std::string, ::DBus::Struct< double, double, int32_t > > DBus_poiDetails_t;

    DBus_poiDetails(){
        DBus_geoCoordinate3D loc;

        m_poiDetails.id = 0;
        m_poiDetails.name = "";
        m_poiDetails.location = loc.get();
    }

    ~DBus_poiDetails(){}

    void set(poiDetails_t value){
        m_poiDetails.id = value.id;
        m_poiDetails.name = value.name;
        m_poiDetails.location = value.location;
    }

    poiDetails_t get(){
        return(m_poiDetails);
    }

    void setDBus(DBus_poiDetails_t value){
        DBus_geoCoordinate3D loc;

        m_poiDetails.id = value._1;
        m_poiDetails.name = value._2;
        loc.setDBus(value._3);
        m_poiDetails.location = loc.get();
    }

    DBus_poiDetails_t getDBus(){
        DBus_geoCoordinate3D loc;
        DBus_poiDetails_t return_value;
        return_value._1 = m_poiDetails.id;
        return_value._2 = m_poiDetails.name;
        loc.set(m_poiDetails.location);
        return_value._3 = loc.getDBus();
        return(return_value);
    }

private:
    poiDetails_t m_poiDetails;
};

class DBus_searchResult : DBus_dataFormatConverter //(uuqa(ui(yv)))
{
public:
    struct searchResult_t
    {
        poiId_t id;
        uint distance;
        ushort route_status;
        std::vector<DBus_poiAttribute::poiAttribute_t> attributes;
    };

    typedef ::DBus::Struct< uint32_t, uint32_t, uint16_t, std::vector< ::DBus::Struct< uint32_t, int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant > > > > DBus_searchResult_t;

    DBus_searchResult(){
        m_searchResult.id = 0;
        m_searchResult.distance = 0;
        m_searchResult.route_status = 0;
        m_searchResult.attributes.clear();
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

class DBus_searchResultDetails : DBus_dataFormatConverter // ((us(ddi))aua(ui(yv)))
{
public:
    struct searchResultDetails_t
    {
        DBus_poiDetails::poiDetails_t details;
        std::vector<categoryId_t> categories;
        std::vector<DBus_poiAttribute::poiAttribute_t> attributes;
    };

    typedef ::DBus::Struct< ::DBus::Struct< uint32_t, std::string, ::DBus::Struct< double, double, int32_t > >, std::vector< uint32_t >, std::vector< ::DBus::Struct< uint32_t, int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant > > > > DBus_searchResultDetails_t;


    DBus_searchResultDetails(){
        DBus_poiDetails details;

        m_searchResultDetails.details = details.get();
        m_searchResultDetails.categories.clear();
        m_searchResultDetails.attributes.clear();
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

class DBus_poiCAMDetails : DBus_dataFormatConverter // (usq(ddi)qa(ui(yv)))
{
public:
    struct poiCAMDetails_t
    {
        poiId_t source_id;
        std::string name;
        categoryId_t category;
        DBus_geoCoordinate3D::geoCoordinate3D_t location;
        ushort distance;
        std::vector<DBus_poiAttribute::poiAttribute_t> attributes;
    };

    typedef ::DBus::Struct< uint32_t, std::string, uint32_t, ::DBus::Struct< double, double, int32_t >, uint16_t, std::vector< ::DBus::Struct< uint32_t, int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant > > > > DBus_poiCAMDetails_t;

    DBus_poiCAMDetails(){
        DBus_geoCoordinate3D loc;

        m_poiCAMDetails.source_id = 0;
        m_poiCAMDetails.name = "";
        m_poiCAMDetails.category = 0;
        m_poiCAMDetails.location = loc.get();
        m_poiCAMDetails.distance = 0;
        m_poiCAMDetails.attributes.clear();
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

class DBus_CAMcategoryDetails : DBus_dataFormatConverter // (au(yv)ss(yv))
{
public:
    struct CAMcategoryDetails_t
    {
        std::vector<categoryId_t> parents_id;
        DBus_variantIcon::variantIcon_t icons;
        std::string name;
        std::string short_desc;
        DBus_variantMedia::variantMedia_t media;
    };

    typedef ::DBus::Struct< std::vector< uint32_t >, ::DBus::Struct< uint8_t, ::DBus::Variant >, std::string, std::string, ::DBus::Struct< uint8_t, ::DBus::Variant > > DBus_CAMcategoryDetails_t;

    DBus_CAMcategoryDetails(){
        DBus_variantIcon icons;
        DBus_variantMedia media;

        m_CAMcategoryDetails.parents_id.clear();
        m_CAMcategoryDetails.icons = icons.get();
        m_CAMcategoryDetails.name = "";
        m_CAMcategoryDetails.short_desc = "";
        m_CAMcategoryDetails.media = media.get();
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
        DBus_variantIcon icons;
        DBus_variantMedia media;

        m_CAMcategoryDetails.parents_id.clear();
        for (index=0;index<value._1.size();index++)
        {
            m_CAMcategoryDetails.parents_id.push_back(value._1.at(index));
        }

        icons.setDBus(value._2);
        m_CAMcategoryDetails.icons = icons.get();

        m_CAMcategoryDetails.name = value._3;
        m_CAMcategoryDetails.short_desc = value._4;

        media.setDBus(value._5);
        m_CAMcategoryDetails.media = media.get();
    }

    DBus_CAMcategoryDetails_t getDBus(){
        DBus_CAMcategoryDetails_t return_value;
        size_t index;
        DBus_variantIcon icons;
        DBus_variantMedia media;

        return_value._1.clear();
        for (index=0;index<m_CAMcategoryDetails.parents_id.size();index++)
        {
            return_value._1.push_back(m_CAMcategoryDetails.parents_id.at(index));
        }

        icons.set(m_CAMcategoryDetails.icons);
        return_value._2 = icons.getDBus();
        return_value._3 = m_CAMcategoryDetails.name;
        return_value._4 = m_CAMcategoryDetails.short_desc;

        media.set(m_CAMcategoryDetails.media);
        return_value._5 = media.getDBus();
        return(return_value);
    }

private:
    CAMcategoryDetails_t m_CAMcategoryDetails;
};

class DBus_CAMcategory : DBus_dataFormatConverter // ((au(yv)ss(yv))a(usia(is(yv)))a(us)) -->in this implementation, the variant data is string
{
public:
    struct CAMcategory_t //no class used into this public structure
    {
        DBus_CAMcategoryDetails::CAMcategoryDetails_t details;
        std::vector<DBus_categoryAttribute::categoryAttribute_t> attributes;
        std::vector<DBus_categorySortOption::categorySortOption_t> sortOptions;
    };

    typedef ::DBus::Struct< ::DBus::Struct< std::vector< uint32_t >, ::DBus::Struct< uint8_t, ::DBus::Variant >, std::string, std::string, ::DBus::Struct< uint8_t, ::DBus::Variant > >, std::vector< ::DBus::Struct< uint32_t, std::string, int32_t, std::vector< ::DBus::Struct< int32_t, std::string, ::DBus::Struct< uint8_t, ::DBus::Variant > > > > >, std::vector< ::DBus::Struct< uint32_t, std::string > > > DBus_CAMcategory_t;

    DBus_CAMcategory(){
        DBus_CAMcategoryDetails details;
        DBus_categoryAttribute attrib;
        DBus_categorySortOption sortOption;

        m_CAMcategory.details = details.get();
        m_CAMcategory.attributes.clear();
        m_CAMcategory.sortOptions.clear();
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

class DBus_CAMcategoryUpdate : DBus_dataFormatConverter // (ua(usia(is(yv)))a(us))
{
public:
    struct CAMcategoryUpdate_t
    {
        categoryId_t unique_id;
        std::vector<DBus_categoryAttribute::categoryAttribute_t> attributes;
        std::vector<DBus_categorySortOption::categorySortOption_t> sortOptions;
    };

    typedef ::DBus::Struct< uint32_t, std::vector< ::DBus::Struct< uint32_t, std::string, int32_t, std::vector< ::DBus::Struct< int32_t, std::string, ::DBus::Struct< uint8_t, ::DBus::Variant > > > > >, std::vector< ::DBus::Struct< uint32_t, std::string > > > DBus_CAMcategoryUpdate_t;

    DBus_CAMcategoryUpdate(){
        m_CAMcategoryUpdate.unique_id = 0;
        m_CAMcategoryUpdate.attributes.clear();
        m_CAMcategoryUpdate.sortOptions.clear();
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

class DBus_PoiAddedDetails : DBus_dataFormatConverter // (s(ddi)a(ui(yv)))
{
public:
    struct PoiAddedDetails_t
    {
        std::string name;
        DBus_geoCoordinate3D::geoCoordinate3D_t location;
        std::vector<DBus_poiAttribute::poiAttribute_t> attributes;
    };

    typedef ::DBus::Struct< std::string, ::DBus::Struct< double, double, int32_t >, std::vector< ::DBus::Struct< uint32_t, int32_t, ::DBus::Struct< uint8_t, ::DBus::Variant > > > > DBus_PoiAddedDetails_t;


    DBus_PoiAddedDetails(){
        DBus_geoCoordinate3D loc;

        m_PoiAddedDetails.name = "";
        m_PoiAddedDetails.location = loc.get();
        m_PoiAddedDetails.attributes.clear();
    }

    ~DBus_PoiAddedDetails(){}

    void set(PoiAddedDetails_t value){
        size_t index;
        m_PoiAddedDetails.name = value.name;
        m_PoiAddedDetails.location = value.location;

        m_PoiAddedDetails.attributes.clear();
        for (index=0;index<value.attributes.size();index++)
        {
            m_PoiAddedDetails.attributes.push_back(value.attributes.at(index));
        }
    }

    PoiAddedDetails_t get(){
        return(m_PoiAddedDetails);
    }

    void setDBus(DBus_PoiAddedDetails_t value){
        DBus_geoCoordinate3D loc;
        size_t index;
        DBus_poiAttribute attrib;

        m_PoiAddedDetails.name = value._1;
        loc.setDBus(value._2);
        m_PoiAddedDetails.location = loc.get();

        m_PoiAddedDetails.attributes.clear();
        for (index=0;index<value._3.size();index++)
        {
            attrib.setDBus(value._3.at(index));
            m_PoiAddedDetails.attributes.push_back(attrib.get());
        }
    }

    DBus_PoiAddedDetails_t getDBus(){
        DBus_PoiAddedDetails_t return_value;
        size_t index;
        DBus_poiAttribute attrib;
        DBus_geoCoordinate3D loc;

        return_value._1 = m_PoiAddedDetails.name;

        loc.set(m_PoiAddedDetails.location);
        return_value._2 = loc.getDBus();

        return_value._3.clear();
        for (index=0;index<m_PoiAddedDetails.attributes.size();index++)
        {
            attrib.set(m_PoiAddedDetails.attributes.at(index));
            return_value._3.push_back(attrib.getDBus());
        }

        return(return_value);
    }

private:
    PoiAddedDetails_t m_PoiAddedDetails;
};


#endif
