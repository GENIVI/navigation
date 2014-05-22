#! /bin/bash

###########################################################################
# @licence app begin@
# SPDX-License-Identifier: MPL-2.0
#
# Component Name: MapViewer
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

API_DIR=../../../api/map-viewer
OUTPUT_DIR=..
OUTPUT_FILE=MapViewerAPI.pdf

INPUT_FILE1=MapViewerAPI-part1.pdf
INPUT_FILE2=MapViewerAPI-part2.pdf

#convert xml files into html files
xsltproc -o ./genivi-mapviewer-session.html                  $API_DIR/introspect.xsl    $API_DIR/genivi-mapviewer-session.xml
xsltproc -o ./genivi-mapviewer-configuration.html            $API_DIR/introspect.xsl    $API_DIR/genivi-mapviewer-configuration.xml
xsltproc -o ./genivi-mapviewer-mapviewercontrol.html         $API_DIR/introspect.xsl    $API_DIR/genivi-mapviewer-mapviewercontrol.xml     
xsltproc -o ./genivi-mapviewer-constants.html                $API_DIR/constants.xsl     $API_DIR/genivi-mapviewer-constants.xml  

#concatenate html files into a single pdf file
wkhtmltopdf ./genivi-mapviewer-mapviewercontrol.html ./genivi-mapviewer-session.html ./genivi-mapviewer-configuration.html ./genivi-mapviewer-constants.html $INPUT_FILE2 

#remove temporary html files
rm *.html

#concatenate pdf files
pdftk $INPUT_FILE1 $INPUT_FILE2 cat output $OUTPUT_DIR/$OUTPUT_FILE

