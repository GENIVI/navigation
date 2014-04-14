/**
 * @licence app begin@
 * Copyright (C) 2011-2012  PCA Peugeot Citroën
 *
 * This file is part of GENIVI Project POISearch Proof Of Concept [POIPOCSupplier].
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
 * \file CreateScheme.sql
 * Modifications:
 * 19-12-2013  Philippe Colliot 
 * add new fields to poi (brand and operateur)
 *
 * For further information see http://www.genivi.org/.
 * @licence end@
 */

/*
* Table of available area
*/
DROP TABLE IF EXISTS availablearea;
CREATE TABLE availablearea (
  Id int NOT NULL,
  leftlongitude double DEFAULT NULL,
  bottomlatitude double DEFAULT NULL,
  rightlongitude double DEFAULT NULL,
  toplatitude double DEFAULT NULL,
  PRIMARY KEY (Id)
);

/*
* Table of available attribute 
*/
DROP TABLE IF EXISTS poiattribute;
CREATE TABLE poiattribute (
  Id int NOT NULL,
  name text UNIQUE,
  PRIMARY KEY (Id)
);

/*
* Table of poi
*/
DROP TABLE IF EXISTS poi;
CREATE TABLE poi (
  Id int NOT NULL,
  name text UNIQUE,
  latitude double DEFAULT NULL,
  longitude double DEFAULT NULL,
  altitude int DEFAULT NULL,
  segment int DEFAULT NULL,
  offset int DEFAULT NULL,
  source text,
  website text,
  phone text,
  stars int,
  openingHours text,
  addrHouseNumber text,
  addrStreet text,
  addrPostCode int,
  addrCity text,
  brand text,
  operateur text,
  PRIMARY KEY (Id)
);

/*
* Table of category
*/
DROP TABLE IF EXISTS poicategory;
CREATE TABLE poicategory (
  Id int NOT NULL,
  name text UNIQUE,
  PRIMARY KEY (Id)
);

/*
* Table of kinship between categories
*/
DROP TABLE IF EXISTS poicategorykinship;
CREATE TABLE poicategorykinship (
  Id int NOT NULL,
  childId int NOT NULL,
  parentId int NOT NULL,
  PRIMARY KEY (Id)
);

/*
* Table of provider
*/
DROP TABLE IF EXISTS poiprovider;
CREATE TABLE poiprovider (
  Id int NOT NULL,
  name text UNIQUE,
  PRIMARY KEY (Id)
);

/*
* Table of icons
*/
DROP TABLE IF EXISTS iconset;
CREATE TABLE iconset (
  Id int NOT NULL,
  width int DEFAULT NULL,
  height int DEFAULT NULL,
  url text DEFAULT NULL,
  format text DEFAULT NULL, 	
  PRIMARY KEY (Id)
);

/*
* Table of media files
*/
DROP TABLE IF EXISTS mediaset;
CREATE TABLE mediaset (
  Id int NOT NULL,
  description text DEFAULT NULL,
  url text DEFAULT NULL,
  format text DEFAULT NULL, 	
  PRIMARY KEY (Id)
);

/*
* Link between a poicategory and an attribute
* (followed by the associated triggers)
*/
DROP TABLE IF EXISTS hasattribute;
CREATE TABLE hasattribute (
  Id int NOT NULL,
  poicategory_Id int NOT NULL,
  poiattribute_Id int NOT NULL,
  PRIMARY KEY (Id,poiattribute_Id,poicategory_Id),
  FOREIGN KEY (poicategory_Id)
    REFERENCES poicategory(Id)    
  FOREIGN KEY (poiattribute_Id)
    REFERENCES poiattribute(Id)
);
DROP TRIGGER IF EXISTS trig_poiattribute_Id;
CREATE TRIGGER trig_poiattribute_Id
BEFORE INSERT ON [hasattribute]
FOR EACH ROW BEGIN
  SELECT RAISE(ROLLBACK, 'key violation...')
  WHERE (SELECT Id FROM poiattribute WHERE Id = NEW.poiattribute_Id) IS NULL;
END;
DROP TRIGGER IF EXISTS trig_poicategory1_Id;
CREATE TRIGGER trig_poicategory1_Id
BEFORE INSERT ON [hasattribute]
FOR EACH ROW BEGIN
  SELECT RAISE(ROLLBACK, 'key violation...')
  WHERE (SELECT Id FROM poicategory WHERE Id = NEW.poicategory_Id) IS NULL;
END;

/*
* Link between a poicategory and an icon (restricted to only one icon per category)
* (followed by the associated triggers)
*/
DROP TABLE IF EXISTS isdisplayedas;
CREATE TABLE isdisplayedas (
  Id int NOT NULL,
  poicategory_Id int NOT NULL,
  iconset_Id int NOT NULL,
  PRIMARY KEY (Id,poicategory_Id,iconset_Id),
  FOREIGN KEY (poicategory_Id)
    REFERENCES poicategory(Id)    
  FOREIGN KEY (iconset_Id)
    REFERENCES iconset(Id)
);
DROP TRIGGER IF EXISTS trig_iconset_Id;
CREATE TRIGGER trig_iconset_Id
BEFORE INSERT ON [isdisplayedas]
FOR EACH ROW BEGIN
  SELECT RAISE(ROLLBACK, 'key violation...')
  WHERE (SELECT Id FROM iconset WHERE Id = NEW.iconset_Id) IS NULL;
END;
DROP TRIGGER IF EXISTS trig_poicategory_Id;
CREATE TRIGGER trig_poicategory_Id
BEFORE INSERT ON [isdisplayedas]
FOR EACH ROW BEGIN
  SELECT RAISE(ROLLBACK, 'key violation...')
  WHERE (SELECT Id FROM poicategory WHERE Id = NEW.poicategory_Id) IS NULL;
END;

/*
* Link between a poi, a poicategory and a poiprovider
* (followed by the associated triggers)
*/
DROP TABLE IF EXISTS belongsto;
CREATE TABLE belongsto (
  Id int NOT NULL,
  poi_Id int NOT NULL,
  poicategory_Id int NOT NULL,
  poiprovider_Id int NOT NULL,
  PRIMARY KEY (Id,poi_Id,poicategory_Id,poiprovider_Id),
  FOREIGN KEY (poiprovider_Id)
    REFERENCES poiprovider(Id)
  FOREIGN KEY (poicategory_Id)
    REFERENCES poicategory(Id)
  FOREIGN KEY (poi_Id)
    REFERENCES poi(Id)
);
DROP TRIGGER IF EXISTS trig_poiprovider_Id;
CREATE TRIGGER trig_poiprovider_Id
BEFORE INSERT ON [belongsto]
FOR EACH ROW BEGIN
  SELECT RAISE(ROLLBACK, 'key violation...')
  WHERE (SELECT Id FROM poiprovider WHERE Id = NEW.poiprovider_Id) IS NULL;
END;
DROP TRIGGER IF EXISTS trig_poicategory_Id;
CREATE TRIGGER trig_poicategory_Id
BEFORE INSERT ON [belongsto]
FOR EACH ROW BEGIN
  SELECT RAISE(ROLLBACK, 'key violation...')
  WHERE (SELECT Id FROM poicategory WHERE Id = NEW.poicategory_Id) IS NULL;
END;
DROP TRIGGER IF EXISTS trig_poi_Id;
CREATE TRIGGER trig_poi_Id
BEFORE INSERT ON [belongsto]
FOR EACH ROW BEGIN
  SELECT RAISE(ROLLBACK, 'key violation...')
  WHERE (SELECT Id FROM poi WHERE Id = NEW.poi_Id) IS NULL;
END;

/*
* Link between a poi and an media file (restricted to only one media file per poi)
* (followed by the associated triggers)
*/
DROP TABLE IF EXISTS isshownas;
CREATE TABLE isshownas (
  Id int NOT NULL,
  poi_Id int NOT NULL,
  mediaset_Id int NOT NULL,
  PRIMARY KEY (Id,poi_Id,mediaset_Id),
  FOREIGN KEY (poi_Id)
    REFERENCES poi(Id)    
  FOREIGN KEY (mediaset_Id)
    REFERENCES mediaset(Id)
);
DROP TRIGGER IF EXISTS trig_mediaset_Id;
CREATE TRIGGER trig_mediaset_Id
BEFORE INSERT ON [isshownas]
FOR EACH ROW BEGIN
  SELECT RAISE(ROLLBACK, 'key violation...')
  WHERE (SELECT Id FROM mediaset WHERE Id = NEW.mediaset_Id) IS NULL;
END;
DROP TRIGGER IF EXISTS trig_poi1_Id;
CREATE TRIGGER trig_poi1_Id
BEFORE INSERT ON [isshownas]
FOR EACH ROW BEGIN
  SELECT RAISE(ROLLBACK, 'key violation...')
  WHERE (SELECT Id FROM poi WHERE Id = NEW.poi_Id) IS NULL;
END;

  
 
