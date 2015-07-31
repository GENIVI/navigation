/**
* @licence app begin@
* SPDX-License-Identifier: MPL-2.0
*
* \copyright Copyright (C) 2013-2015, PCA Peugeot Citroen
*
* \file poi-common-math.cpp
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
* <date>, <name>, <description of change>
*
* @licence end@
*/

#include "poi-common-math.h"

double calculateAngle(const uint32_t radius)
    {
        //N is the point on the sphere for the origin
        //M is a point of the sphere at the distance radius (NM = radius)
        //O is the center of the earth
        //ON=OM so the triangle is isosceles
        //alpha is the angle ON,OM
        //beta is the angle NM,NO
        //OM*sin(alpha)=NM*sin(beta)
        //alpha+beta+beta=PI (because of isoceles)
        //beta=(PI-alpha)/2
        //sin(beta) = cos(alpha/2)
        //sin(alpha)=2*sin(alpha/2)*cos(alpha/2)
        //alpha=2*arcsin(NM/(2*OM))

        //earth is considered to be a perfect spĥere, in order to simplify calculation
        const double PI = 4.0*atan(1.0);
        const double earth=6378137; //IUGG value for the equatorial radius of the Earth in m
        double angle;
        angle=2*asin(radius/(2*earth));
        angle = (angle*180)/PI; //in degrees
        return(angle);
    }

uint32_t calculateDistance(const geocoordinate3D_t origin, const geocoordinate3D_t target)
    {
        //this piece of software is based on an haversine formula given by:
        // - Doctors Rick and Peterson, The Math Forum
        // http://mathforum.org/dr.math/
        // haversine of angle A is (1-cos(A))/2 that is equal to sin^2(A/2)

        //earth is considered to be a perfect spĥere, in order to simplify calculation
        const double PI = 4.0*atan(1.0);
        const double earth=6378137; //IUGG value for the equatorial radius of the Earth in m
        geocoordinate3D_t pointA, pointB;
        double buffer;

        pointA.latitude = origin.latitude * (PI/180);
        pointA.longitude = origin.longitude * (PI/180);
        pointB.latitude = target.latitude * (PI/180);
        pointB.longitude = target.longitude * (PI/180);

        buffer= pow(sin((pointA.latitude-pointB.latitude)/2.0),2.0)+cos(pointA.latitude)*cos(pointB.latitude)*pow(sin((pointA.longitude-pointB.longitude)/2),2);
        buffer = 2*atan2(sqrt(buffer),sqrt(1.0-buffer));
        buffer=earth*buffer;
        return ((uint32_t) buffer); //return distance in meters
    }

