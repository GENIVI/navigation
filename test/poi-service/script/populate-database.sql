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
 * \file PopulateDatabase.sql
 * Modifications:
 * 19-12-2013  Philippe Colliot 
 * change name of a poi category from "gaz station" to "fuel", according to OpenStreetMap amenity:fuel
 * update the poi sample to reflect the new amount of columns
 * add several new attributes
 * 6-01-2014  Philippe Colliot 
 * Align the attributes of all categories
 *
 * For further information see http://www.genivi.org/.
 * @licence end@
 */
/* start of the transaction */
BEGIN TRANSACTION;
/* create providers */
INSERT INTO poiprovider VALUES (0,'OpenStreetMap');
INSERT INTO poiprovider VALUES (1,'TomTom');
INSERT INTO poiprovider VALUES (2,'Navteq');
/* create categories */
INSERT INTO poicategory VALUES (0,'all categories');
INSERT INTO poicategory VALUES (1,'restaurant');
INSERT INTO poicategory VALUES (2,'hotel');
INSERT INTO poicategory VALUES (3,'fuel');
INSERT INTO poicategory VALUES (4,'car park');
INSERT INTO poicategory VALUES (5,'museum');
INSERT INTO poicategory VALUES (6,'station');
INSERT INTO poicategory VALUES (7,'airport');
/* create attributes */
INSERT INTO poiattribute VALUES (0, 'source');
INSERT INTO poiattribute VALUES (1, 'website');
INSERT INTO poiattribute VALUES (2, 'phone');
INSERT INTO poiattribute VALUES (3, 'stars');
INSERT INTO poiattribute VALUES (4, 'openingHours');
INSERT INTO poiattribute VALUES (5, 'addrHouseNumber');
INSERT INTO poiattribute VALUES (6, 'addrStreet');
INSERT INTO poiattribute VALUES (7, 'addrPostCode');
INSERT INTO poiattribute VALUES (8, 'addrCity');
INSERT INTO poiattribute VALUES (9, 'brand');
INSERT INTO poiattribute VALUES (10, 'operateur');
/* create icons */
INSERT INTO iconset VALUES (0,32,37,'../resource/restaurant','png');
INSERT INTO iconset VALUES (1,32,37,'../resource/hotel_0star','png');
INSERT INTO iconset VALUES (2,32,37,'../resource/train','png');
INSERT INTO iconset VALUES (3,32,37,'../resource/museum_art','png');
INSERT INTO iconset VALUES (4,32,37,'../resource/airport','png');
INSERT INTO iconset VALUES (5,32,37,'../resource/car','png');
INSERT INTO iconset VALUES (6,32,37,'../resource/fillingstation','png');
INSERT INTO iconset VALUES (7,32,37,'../resource/world','png');
/* link between categories and attributes */
INSERT INTO hasattribute VALUES (0,0,0);
INSERT INTO hasattribute VALUES (1,0,1);
INSERT INTO hasattribute VALUES (2,0,2);
INSERT INTO hasattribute VALUES (3,0,3);
INSERT INTO hasattribute VALUES (4,0,4);
INSERT INTO hasattribute VALUES (5,0,9);
INSERT INTO hasattribute VALUES (6,0,10);
INSERT INTO hasattribute VALUES (7,1,0);
INSERT INTO hasattribute VALUES (8,1,1);
INSERT INTO hasattribute VALUES (9,1,2);
INSERT INTO hasattribute VALUES (10,2,0);
INSERT INTO hasattribute VALUES (11,2,1);
INSERT INTO hasattribute VALUES (12,2,2);
INSERT INTO hasattribute VALUES (13,2,3);
INSERT INTO hasattribute VALUES (14,3,0);
INSERT INTO hasattribute VALUES (15,3,1);
INSERT INTO hasattribute VALUES (16,3,2);
INSERT INTO hasattribute VALUES (17,3,4);
INSERT INTO hasattribute VALUES (18,3,9);
INSERT INTO hasattribute VALUES (19,3,10);
INSERT INTO hasattribute VALUES (20,4,0);
INSERT INTO hasattribute VALUES (21,4,1);
INSERT INTO hasattribute VALUES (22,4,2);
INSERT INTO hasattribute VALUES (23,5,0);
INSERT INTO hasattribute VALUES (24,5,1);
INSERT INTO hasattribute VALUES (25,5,2);
INSERT INTO hasattribute VALUES (26,6,0);
INSERT INTO hasattribute VALUES (27,6,1);
INSERT INTO hasattribute VALUES (28,6,2);
INSERT INTO hasattribute VALUES (29,7,0);
INSERT INTO hasattribute VALUES (30,7,1);
INSERT INTO hasattribute VALUES (31,7,2);
/* link between icons and categories */
INSERT INTO isdisplayedas VALUES (0,0,7);
INSERT INTO isdisplayedas VALUES (1,1,0);
INSERT INTO isdisplayedas VALUES (2,2,1);
INSERT INTO isdisplayedas VALUES (3,3,6);
INSERT INTO isdisplayedas VALUES (4,4,5);
INSERT INTO isdisplayedas VALUES (5,5,3);
INSERT INTO isdisplayedas VALUES (6,6,2);
INSERT INTO isdisplayedas VALUES (7,7,0);
/* create mediaset */
INSERT INTO mediaset VALUES (0,'audio sample','Helmut Qualtinger - I schupf alles nur mit l amour','mp3');
INSERT INTO mediaset VALUES (1,'video sample','concert','mp4');
/* define an area for being used by the server (to be improved, do it during runtime ?) */
INSERT INTO availablearea VALUES (0,2.246304,48.814551,2.430325,48.901289);
/* define kinship relations */
INSERT INTO poicategorykinship VALUES (0,0,0);
INSERT INTO poicategorykinship VALUES (1,1,0);
INSERT INTO poicategorykinship VALUES (2,2,0);
INSERT INTO poicategorykinship VALUES (3,3,0);
INSERT INTO poicategorykinship VALUES (4,4,0);
INSERT INTO poicategorykinship VALUES (5,5,0);
INSERT INTO poicategorykinship VALUES (6,6,0);
INSERT INTO poicategorykinship VALUES (7,7,0);
/* define the only poi of all categories, it's necessary for the server (root category) */
INSERT INTO poi VALUES (0,'NoWherePoi',0,0,0,0,0,'Genivi','www.genivi.org','0',0,'0','0','0',0,'0','0','0');
INSERT INTO isshownas VALUES (0,0,1);
INSERT INTO belongsto VALUES (0,0,0,0);
COMMIT;
/* to check if database is well populated let's display the database content */
SELECT * FROM poi;
SELECT * FROM poiprovider;
SELECT * FROM poicategory;
SELECT * FROM availablearea;
SELECT * FROM poiattribute;
SELECT * FROM poicategorykinship;
SELECT * FROM iconset;
SELECT * FROM mediaset;



