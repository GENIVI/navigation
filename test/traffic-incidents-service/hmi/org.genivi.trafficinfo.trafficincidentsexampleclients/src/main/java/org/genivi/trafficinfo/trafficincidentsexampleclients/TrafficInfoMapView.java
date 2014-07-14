/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentsexampleclients;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import openlr.map.MapDatabase;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.genivi.common.CommonFactory;
import org.genivi.common.Coordinate;
import org.genivi.common.RectangularArea;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;
import org.jdesktop.swingx.JXMapViewer;
import org.jdesktop.swingx.mapviewer.GeoPosition;


public class TrafficInfoMapView extends Thread {
  private final static Logger LOGGER = Logger.getLogger(TrafficInfoMapView.class.getName());
  private static final String WINDOW_TITLE = "GENIVI Traffic Information Map View";
  private static final CommonFactory COMMON_FACTORY = CommonFactory.eINSTANCE;
  private static EList<RectangularArea> areas;

  private static final String locationString = "location";
  private static final String locationInfoString = "locationInfo";
  
  private JFrame frame;
  private MapDatabase mapDataBase;
  private TrafficIncidents trafficIncidentsService = null;
  private TrafficIncidentsListener trafficIncidentsListener;
  private org.jdesktop.swingx.JXMapKit jXMapKit;
  private JRadioButton locationButton;
  private JRadioButton locationInfoButton;
  private ButtonGroup buttonGroup;
  private JCheckBox boundingBoxCheckBox;
  private JCheckBox areaFilterCheckBox;
  private JCheckBox showFilterAreasCheckBox;
  
  static {
    areas = new BasicEList<RectangularArea>();
    
    RectangularArea area = COMMON_FACTORY.createRectangularArea();
    Coordinate bottomLeft = COMMON_FACTORY.createCoordinate();
    bottomLeft.setAltitude(0);
    bottomLeft.setLongitude(5.06d);
    bottomLeft.setLatitude(52.08d);
    Coordinate topRight = COMMON_FACTORY.createCoordinate();
    topRight.setAltitude(0);
    topRight.setLongitude(5.10d);
    topRight.setLatitude(52.11d);
    area.setBottomLeft(bottomLeft);
    area.setTopRight(topRight);
    areas.add(area);
    
    area = COMMON_FACTORY.createRectangularArea();
    bottomLeft = COMMON_FACTORY.createCoordinate();
    bottomLeft.setAltitude(0);
    bottomLeft.setLongitude(5.07d);
    bottomLeft.setLatitude(52.07d);
    topRight = COMMON_FACTORY.createCoordinate();
    topRight.setAltitude(0);
    topRight.setLongitude(5.15d);
    topRight.setLatitude(52.09d);
    area.setBottomLeft(bottomLeft);
    area.setTopRight(topRight);
    areas.add(area);
  }

  public TrafficInfoMapView(MapDatabase mapDataBase, TrafficIncidents trafficIncidentsService) {
    LOGGER.setLevel(Level.SEVERE);
    LOGGER.info("Creating TrafficInfoMapView");
    this.mapDataBase = mapDataBase;
    this.trafficIncidentsService = trafficIncidentsService;

    trafficIncidentsListener = new DefaultTrafficIncidentsListener() {

      @Override
      public void getTrafficIncidentIdsReply(EList<Integer> incidentIds) {
        LOGGER.info("getTrafficIncidentIdsReply called.");
        getAndShowTrafficInfoStep2(incidentIds);
      }

      @Override
      public void getTrafficIncidentsReply(EList<TrafficIncident> trafficIncidents) {
        LOGGER.info("getTrafficIncidentsReply called.");
        getAndShowTrafficInfoStep3(trafficIncidents);
      }
    };

    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle(WINDOW_TITLE);

    jXMapKit = new org.jdesktop.swingx.JXMapKit();
    jXMapKit.setDefaultProvider(org.jdesktop.swingx.JXMapKit.DefaultProviders.OpenStreetMaps);
    jXMapKit.setDataProviderCreditShown(true);
    jXMapKit.setPreferredSize(new Dimension(600, 500));
    jXMapKit.setZoom(3);
    jXMapKit.setAddressLocationShown(false);
    jXMapKit.setAddressLocation(new GeoPosition(52.095,5.088));
    frame.getContentPane().add(jXMapKit);

    frame.getContentPane().add(createControlPanel(), BorderLayout.NORTH);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
    getAndShowTrafficInfoStep3(null);
    start();
  }

  private JPanel createControlPanel() {
    JPanel panel = new JPanel();
    panel.add(createLocationControlPanel());
    panel.add(createBoundingBoxPanel());
    panel.add(createFilterPanel());

    return panel;
  }

  private JPanel createLocationControlPanel() {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEtchedBorder());

    JLabel label = new JLabel("draw location from: ");
    panel.add(label);

    locationButton = new JRadioButton(locationString);
    locationButton.setSelected(true);
    panel.add(locationButton);
    locationInfoButton = new JRadioButton(locationInfoString);
    panel.add(locationInfoButton);

    buttonGroup = new ButtonGroup();
    buttonGroup.add(locationButton);
    buttonGroup.add(locationInfoButton);
    
    return panel;
  }


  private JPanel createBoundingBoxPanel() {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEtchedBorder());
   
    boundingBoxCheckBox = new JCheckBox("bounding box");
    panel.add(boundingBoxCheckBox);

    return panel;
  }

  private JPanel createFilterPanel() {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEtchedBorder());

    areaFilterCheckBox = new JCheckBox("area filter");
    panel.add(areaFilterCheckBox);
    
    showFilterAreasCheckBox = new JCheckBox("show filter areas");
    panel.add(showFilterAreasCheckBox);

    return panel;
  }

  public void run() {
    for ( ; ; ) {
      if (trafficIncidentsService != null) {
        getAndShowTrafficInfoStep1();
      } else {
        System.out.println("TrafficInfoMapView: No Traffic Incidents Service");
      }

      try {
        sleep(1000 * 3);
      } catch (InterruptedException e) {
        System.out.println("TrafficInfoMapView woke up too early");
      }
    }
  }

  private void getAndShowTrafficInfoStep1() {
    LOGGER.info("Polling; calling getTrafficIncidentIds()");
    if (areaFilterCheckBox.isSelected()) {
      trafficIncidentsService.getTrafficIncidentIdsInAreas(trafficIncidentsListener, new BasicEList<WarningLevel>(), new BasicEList<Integer>(), areas);      
    } else {
      trafficIncidentsService.getTrafficIncidentIds(trafficIncidentsListener, new BasicEList<WarningLevel>(), new BasicEList<Integer>());
    }
  }

  private void getAndShowTrafficInfoStep2(EList<Integer> incidentIds) {
    if (incidentIds != null  &&  incidentIds.size() > 0) {
      LOGGER.info("There are incidents, calling getTrafficIncidents().");
      trafficIncidentsService.getTrafficIncidents(trafficIncidentsListener, incidentIds, false);
    } else {
      LOGGER.info("No incidents.");
      getAndShowTrafficInfoStep3(null);
    }
  }

  public void getAndShowTrafficInfoStep3(EList<TrafficIncident> incidents) {
    TrafficIncidentsPainter<JXMapViewer> painter = new TrafficIncidentsPainter<JXMapViewer>(mapDataBase);

    painter.setIncidents(incidents);
    boolean useCoordinates;
    if (locationButton.isSelected()) {
      LOGGER.info("useCoordinates = true");
      useCoordinates = true;
    } else {
      LOGGER.info("useCoordinates = false");
      useCoordinates = false;
    }

    painter.setUseCoordinates(useCoordinates);
    
    painter.setDrawBoundingBox(boundingBoxCheckBox.isSelected());
    
    if (showFilterAreasCheckBox.isSelected()) {
      painter.setAreas(areas);
    }

    jXMapKit.getMainMap().setOverlayPainter(painter);
  }

  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event-dispatching thread.
   */
  private static void createAndShowGUI() {
    TrafficInfoMapView trafficInfoMapView = new TrafficInfoMapView(null, null);

    trafficInfoMapView.getAndShowTrafficInfoStep3(null);
  }

  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
