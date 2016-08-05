<?xml version="1.0"?>
<!-- ************************************************************************
* Component Name: Navit POC
* Author: Martin Schaller <martin.schaller@it-schaller.de>
*
* Copyright (C) 2012, GENIVI Alliance, Inc.
* 
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License version 2 as 
* published by the Free Software Foundation.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*
************************************************************************ -->
<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xi="http://www.w3.org/2001/XInclude">
        <xsl:template match="/config/plugins/plugin[1]" priority="1" >
		<xsl:copy><xsl:apply-templates select="@*|node()"/></xsl:copy>
		<xsl:text>&#x0A;                </xsl:text>
		<plugin path="../../navigation-core/configuration-server-plugin/.libs/libgenivi_navigationcore_configuration_server.so" ondemand="no"/>
		<xsl:text>&#x0A;                </xsl:text>
		<plugin path="../../navigation-core/locationinput-server-plugin/.libs/libgenivi_navigationcore_locationinput_server.so" ondemand="no"/>
		<xsl:text>&#x0A;                </xsl:text>
		<plugin path="../../navigation-core/routing-server-plugin/.libs/libgenivi_navigationcore_routing_server.so" ondemand="no"/>
		<xsl:text>&#x0A;                </xsl:text>
		<plugin path="../../navigation-core/session-server-plugin/.libs/libgenivi_navigationcore_session_server.so" ondemand="no"/>
		<xsl:text>&#x0A;                </xsl:text>
		<plugin path="../../navigation-core/guidance-server-plugin/.libs/libgenivi_navigationcore_guidance_server.so" ondemand="no"/>
		<xsl:text>&#x0A;                </xsl:text>
		<plugin path="../../navigation-core/mapmatchedposition-server-plugin/.libs/libgenivi_navigationcore_mapmatchedposition_server.so" ondemand="no"/>
		<xsl:text>&#x0A;                </xsl:text>
		<plugin path="../../navigation-core/enhancedposition-plugin/.libs/libgenivi_positioning_enhancedposition.so" ondemand="no"/>
		<xsl:text>&#x0A;                </xsl:text>
		<plugin path="../../poi-cam/.libs/libgenivi_poiservice_cam_navit.so" ondemand="no"/>
        </xsl:template>
        <xsl:template match="/config/plugins/plugin">
		<xsl:copy><xsl:apply-templates select="@*|node()"/></xsl:copy>
	</xsl:template>
	<xsl:template match="/config/navit">
		<xsl:copy><xsl:attribute name="flags">3</xsl:attribute><xsl:apply-templates select="@*|node()"/></xsl:copy>
	</xsl:template>
	<xsl:template match="/config/navit/graphics">
		<xsl:copy><xsl:attribute name="enabled">no</xsl:attribute><xsl:apply-templates select="@*|node()"/></xsl:copy>
	</xsl:template>
	<xsl:template match="/config/navit/gui">
		<xsl:copy><xsl:attribute name="enabled">no</xsl:attribute><xsl:apply-templates select="@*[not(name()='enabled')]|node()"/></xsl:copy>
	</xsl:template>
	<xsl:template match="/config/navit/vehicle[@name='Local GPS']">
		<xsl:copy><xsl:attribute name="enabled">no</xsl:attribute><xsl:apply-templates select="@*[not(name()='enabled')]|node()"/></xsl:copy>
	</xsl:template>
	<xsl:template match="/config/navit/vehicle[@name='Demo']">
		<vehicle name="EnhancedPosition" profilename="car" active="yes" source="enhancedposition://"/>
		<xsl:text>&#x0A;                </xsl:text>
		<xsl:copy><xsl:attribute name="active">no</xsl:attribute><xsl:apply-templates select="@*[not(name()='enabled' or name()='active')]|node()"/></xsl:copy>
	</xsl:template>
	<xsl:template match="@*|node()"><xsl:copy><xsl:apply-templates select="@*|node()"/></xsl:copy></xsl:template>
</xsl:transform>
