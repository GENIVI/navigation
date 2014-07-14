#! /bin/bash

###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: GNSSService
# Author: Marco Residori
#
# Copyright (C) 2013, XS Embedded GmbH
# 
# License:
# This Source Code Form is subject to the terms of the
# Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
# this file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
# @licence end@
###########################################################################

API_DIR=../../../api/navigation-core
OUTPUT_DIR=..
OUTPUT_FILE=NavigationCoreAPI.pdf

INPUT_FILE1=NavigationCoreAPI-part1.pdf
INPUT_FILE2=NavigationCoreAPI-part2.pdf

#convert xml files into html files
xsltproc -o ./genivi-navigationcore-session.html             $API_DIR/introspect.xsl    $API_DIR/genivi-navigationcore-session.xml
xsltproc -o ./genivi-navigationcore-configuration.html       $API_DIR/introspect.xsl    $API_DIR/genivi-navigationcore-configuration.xml
xsltproc -o ./genivi-navigationcore-routing.html             $API_DIR/introspect.xsl    $API_DIR/genivi-navigationcore-routing.xml   
xsltproc -o ./genivi-navigationcore-guidance.html            $API_DIR/introspect.xsl    $API_DIR/genivi-navigationcore-guidance.xml 
xsltproc -o ./genivi-navigationcore-locationinput.html       $API_DIR/introspect.xsl    $API_DIR/genivi-navigationcore-locationinput.xml  
xsltproc -o ./genivi-navigationcore-mapmatchedposition.html  $API_DIR/introspect.xsl    $API_DIR/genivi-navigationcore-mapmatchedposition.xml  
xsltproc -o ./genivi-navigationcore-constants.html           $API_DIR/constants.xsl     $API_DIR/genivi-navigationcore-constants.xml  

#concatenate html files into a single pdf file
wkhtmltopdf ./genivi-navigationcore-routing.html ./genivi-navigationcore-session.html ./genivi-navigationcore-configuration.html ./genivi-navigationcore-guidance.html ./genivi-navigationcore-mapmatchedposition.html ./genivi-navigationcore-locationinput.html ./genivi-navigationcore-constants.html $INPUT_FILE2

#remove temporary html files
rm *.html

#concatenate pdf files
pdftk $INPUT_FILE1 $INPUT_FILE2 cat output $OUTPUT_DIR/$OUTPUT_FILE

sleep 1
rm $INPUT_FILE2

