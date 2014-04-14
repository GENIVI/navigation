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
 * \file PopulateDatabaseAdditional.sql
 * Modifications:
 * 19-12-2013  Philippe Colliot 
 * update the poi sample to reflect the new amount of columns
 * update a comment
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
/* create categories */
INSERT INTO poicategory VALUES (0,'all categories');
INSERT INTO poicategory VALUES (55,'bicycle');
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
INSERT INTO iconset VALUES (0,32,37,'../resource/bicycle_shop','png');
INSERT INTO iconset VALUES (1,32,37,'../resource/world','png');
/* link between categories and attributes */
INSERT INTO hasattribute VALUES (0,0,2);
INSERT INTO hasattribute VALUES (1,0,4);
INSERT INTO hasattribute VALUES (2,55,2);
INSERT INTO hasattribute VALUES (3,55,4);
/* link between icons and categories */
INSERT INTO isdisplayedas VALUES (0,0,1);
INSERT INTO isdisplayedas VALUES (0,55,0);
/* create mediaset */
INSERT INTO mediaset VALUES (0,'audio sample','Helmut Qualtinger - I schupf alles nur mit l amour','mp3');
INSERT INTO mediaset VALUES (1,'video sample','concert','mp4');
/* define an area for being used by the server (to be improved, do it during runtime ?) */
INSERT INTO availablearea VALUES (0,2.246304,48.814551,2.430325,48.901289);
/* define kinship relations */
INSERT INTO poicategorykinship VALUES (0,0,0);
INSERT INTO poicategorykinship VALUES (1,55,0);
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

