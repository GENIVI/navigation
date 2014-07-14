/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentsexampleclients;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.logging.Logger;

import openlr.map.Line;
import openlr.map.MapDatabase;
import openlr.map.Node;

import org.eclipse.emf.common.util.EList;
import org.genivi.common.Coordinate;
import org.genivi.common.RectangularArea;
import org.genivi.location.LinearLocation;
import org.genivi.location.LinearLocationInfo;
import org.genivi.location.Location;
import org.genivi.location.LocationInfo;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.jdesktop.swingx.JXMapViewer;
import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.jdesktop.swingx.painter.AbstractPainter;


/**
 * Painter that only can draw on to JXMapViewers.
 * Based on code from rbair.
 */
public class TrafficIncidentsPainter<T extends JXMapViewer> extends AbstractPainter<T> {
  private final static Logger LOGGER = Logger.getLogger(TrafficIncidentsPainter.class.getName());

  private MapDatabase mapDataBase;
  private EList<TrafficIncident> incidents;
  private boolean drawBoundingBox = false;
  private boolean useCoordinates = false;  // If true, the location from getLocation() is used, else the coordinates from LocatinInfo are used.
  private EList<RectangularArea> areas = null;    // If not null, areas are drawn

  /**
   * Creates a new instance of WaypointPainter
   */
  public TrafficIncidentsPainter(MapDatabase mapDataBase) {
    this.mapDataBase = mapDataBase;

    setAntialiasing(true);
    setCacheable(false);
  }

  public EList<TrafficIncident> getIncidents() {
    return incidents;
  }

  public void setIncidents(EList<TrafficIncident> incidents) {
    this.incidents = incidents;
  }
  
  public void setUseCoordinates(boolean useCoordinates) {
    this.useCoordinates = useCoordinates;
  }
  
  public void setDrawBoundingBox(boolean drawBoundingBox) {
    this.drawBoundingBox = drawBoundingBox;
  }
  
  public void setAreas(EList<RectangularArea> areas) {
    this.areas = areas;
  }

  /**
   * {@inheritDoc}
   * @param g
   * @param map
   * @param width
   * @param height
   */
  @Override
  protected void doPaint(Graphics2D g, T map, int width, int height) {
    LOGGER.fine("=>");
    if (areas != null) {
      for (RectangularArea area: areas) {
        drawRectangle(g, map, area);
      }
    }
    
    if (incidents == null) {
      LOGGER.fine("<= No Traffic Incidents.");
      return;
    }

    LOGGER.fine("Number of Traffic Incidents = " + incidents.size());
    for (TrafficIncident incident: incidents) {
      paintIncident(g, map, width, height, incident);
    }
    LOGGER.fine("<=");
  }

  private void paintIncident(Graphics2D g, T map, int width, int height, TrafficIncident incident) {
    LOGGER.fine("=>");
    if (useCoordinates) {
      paintLocation(g, map, incident.getLocation());
    } else {
      paintLocationInfo(g, map, incident.getLocationInfo());
    }
    
    if (drawBoundingBox  &&  incident.getLocationBoundingBox() != null) {
      drawRectangle(g, map, incident.getLocationBoundingBox());
    }
    LOGGER.fine("<=");
  }

  private void paintLocation(Graphics2D g, T map, Location location) {
    LOGGER.fine("=>");
    if (location instanceof LinearLocation) {
      LOGGER.fine("location is LinearLocation");
      LinearLocation linearLocation = (LinearLocation) location;
      List<Long> segments = linearLocation.getSegments();

      for (long segment: segments) {
        Line line = mapDataBase.getLine(segment);             
        Node startNode = line.getStartNode();
        Node endNode = line.getEndNode();
        paintLine(g, map, startNode.getLongitudeDeg(), startNode.getLatitudeDeg(), endNode.getLongitudeDeg(), endNode.getLatitudeDeg(), Color.BLUE, 3f);
      }
    } else {
      LOGGER.fine("location is not a linearLocation, this type is not supported");
    }
    LOGGER.fine("<=");
  }
  
  private void paintLocationInfo(Graphics2D g, T map, LocationInfo locationInfo) {
    LOGGER.fine("=>");
    if (locationInfo instanceof LinearLocationInfo) {
      LinearLocationInfo linearLocationInfo = (LinearLocationInfo) locationInfo;
      EList<Coordinate> coordinates = linearLocationInfo.getCoordinates();
      LOGGER.fine("linear location, size = " + coordinates.size());
      
      for (int i = 1; i < coordinates.size(); i++) {
        Coordinate startCoordinate = coordinates.get(i - 1);
        Coordinate endCoordinate = coordinates.get(i);
        paintLine(g, map, startCoordinate.getLongitude(), startCoordinate.getLatitude(), endCoordinate.getLongitude(), endCoordinate.getLatitude(), Color.RED, 3f);
      }
    } else {
      LOGGER.fine("location is not a linearLocation, this type is not supported");
    }
    LOGGER.fine("=>");
  }
  
  private void drawRectangle(Graphics2D g, T map, RectangularArea locationBoundingBox) {
    Coordinate bottomLeft = locationBoundingBox.getBottomLeft();
    Coordinate topRight = locationBoundingBox.getTopRight();
    paintLine(g, map, bottomLeft.getLongitude(), topRight.getLatitude(), topRight.getLongitude(), topRight.getLatitude(), Color.BLACK, 1f);
    paintLine(g, map, topRight.getLongitude(), topRight.getLatitude(), topRight.getLongitude(), bottomLeft.getLatitude(), Color.BLACK, 1f);
    paintLine(g, map, topRight.getLongitude(), bottomLeft.getLatitude(), bottomLeft.getLongitude(), bottomLeft.getLatitude(), Color.BLACK, 1f);
    paintLine(g, map, bottomLeft.getLongitude(), bottomLeft.getLatitude(), bottomLeft.getLongitude(), topRight.getLatitude(), Color.BLACK, 1f);
  }

  private void paintLine(Graphics2D g, T map, double longitude1,
      double latitude1, double longitude2, double latitude2,
      Color color, Float lineWidth) {
    LOGGER.fine("=> coordinates: (" + longitude1 + ", " + latitude1 + ") (" + longitude2 + ", " + latitude2 + ")");
    
    // figure out whether the line is within this map viewport
    // so, get the bounds
    Rectangle viewportBounds = map.getViewportBounds();
    int zoom = map.getZoom();
    Dimension sizeInTiles = map.getTileFactory().getMapSize(zoom);
    int tileSize = map.getTileFactory().getTileSize(zoom);
    Dimension sizeInPixels = new Dimension(sizeInTiles.width*tileSize, sizeInTiles.height*tileSize);

    double vpx = viewportBounds.getX();
    // normalize the left edge of the viewport to be positive
    while(vpx < 0) {
      vpx += sizeInPixels.getWidth();
    }
    // normalize the left edge of the viewport to no wrap around the world
    while(vpx > sizeInPixels.getWidth()) {
      vpx -= sizeInPixels.getWidth();
    }

    // create two new viewports next to eachother
    Rectangle2D vp2 = new Rectangle2D.Double(vpx,
        viewportBounds.getY(),viewportBounds.getWidth(),viewportBounds.getHeight());

    GeoPosition startNodeGeoPosition = new GeoPosition(latitude1, longitude1);
    Point2D point0 = map.getTileFactory().geoToPixel(startNodeGeoPosition, map.getZoom());
    GeoPosition endNodeGeoPosition = new GeoPosition(latitude2, longitude2);
    Point2D point1 = map.getTileFactory().geoToPixel(endNodeGeoPosition, map.getZoom());
    int x0 = (int)(point0.getX() - vp2.getX());
    int y0 = (int)(point0.getY() - vp2.getY());
    int x1 = (int)(point1.getX() - vp2.getX());
    int y1 = (int)(point1.getY() - vp2.getY());
    g.setStroke(new BasicStroke(lineWidth));
    g.setColor(color);
    g.drawLine(x0, y0, x1, y1);

    LOGGER.fine("<=");
  }
}