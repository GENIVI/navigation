<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml" version="1.0">
<!-- SPDX-License-Identifier: MPL-2.0
     Copyright (C) 2014, BMW Car IT GmbH, Continental Automotive GmbH, PCA Peugeot Citroën, XS Embedded GmbH, TomTom International B.V., Alpine Electronics R&D Europe GmbH, AISIN AW CO., LTD.,  Neusoft Technology Solutions GmbH, Jaguar Land Rover Limited, Visteon Corporation
     This Source Code Form is subject to the terms of the
     Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with
     this file, you can obtain one at http://mozilla.org/MPL/2.0/.
-->
<!-- 09.3.2011 Marco Residori: First Draft -->
<!-- 14.3.2011 Marco Residori: Improved layout -->
<xsl:output method="xml" version="1.0" encoding="iso-8859-15" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" indent="yes"/>
  <xsl:template match="/">
    <html>
      <!-- head -->
      <head>
        <title>DBUS Introspection Data</title>
        <style type="text/css">
        body { color: black; background-color: white } 
        h1 { font-family: sans-serif }
        ul { list-style-type: none; margin-bottom: 10px }
        li { font-family: sans-serif }
        .keyword { font-style: italic }
        .id { font-style: italic; font-size:8pt; }
        .title { font-style: italic; color: blue }
        .line { font-style: italic; font-size:8pt; color: green}
        .version { font-family: monospace }
      </style>
      </head>
      <!-- body -->
      <body>
        <!-- definitions -->
        <xsl:apply-templates select="constants"/>
      </body>
    </html>
  </xsl:template>
  <xsl:template match="constants">
    <div class="constants">
      <h1>
        <span class="keyword">constants</span>
        <xsl:text> </xsl:text>
        <span class="title">
          <xsl:value-of select="@name"/>
        </span>
        <xsl:text> </xsl:text>
        <span class="version">version</span>
        <xsl:text> </xsl:text>
        <span class="version">
          <xsl:value-of select="version"/>
        </span>
      </h1>
      <xsl:apply-templates select="doc"/>
      <xsl:for-each select="id">
        <hr/>
        <li>
          <xsl:apply-templates select="doc"/>
          <span class="id"><xsl:value-of select="@name"/> = <xsl:value-of select="@value"/></span>
        </li>
      </xsl:for-each>
    </div>
  </xsl:template>
  <xsl:template match="doc">
    <li>
      <span class="line">
        <xsl:for-each select="line">
          <xsl:value-of select="."/>
          <xsl:element name="br"/>
        </xsl:for-each>
      </span>
    </li>
  </xsl:template>
</xsl:stylesheet>
