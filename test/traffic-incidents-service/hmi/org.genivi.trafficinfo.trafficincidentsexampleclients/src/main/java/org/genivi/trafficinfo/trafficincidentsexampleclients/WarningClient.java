/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentsexampleclients;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.genivi.location.LinearLocationInfo;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TrafficIncidentField;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;

@SuppressWarnings("serial")
public class WarningClient extends JFrame{
  private final static Logger LOGGER = Logger.getLogger(TrafficInfoMapView.class.getName());
  private static final String TITLE = "Traffic Incident Warning";
  private static final BasicEList<WarningLevel> severities = new BasicEList<WarningLevel>();
  private static final BasicEList<TrafficIncidentField> trafficIncidentFields = new BasicEList<TrafficIncidentField>();

  private TrafficIncidents trafficIncidentsService;
  private TrafficIncidentsListener trafficIncidentsListener;
  private JPanel warningPanel;
  
  static {
    severities.add(WarningLevel.DANGER_LEVEL_1);
    severities.add(WarningLevel.DANGER_LEVEL_2);
    severities.add(WarningLevel.DANGER_LEVEL_3);
    trafficIncidentFields.add(TrafficIncidentField.CAUSES);
    trafficIncidentFields.add(TrafficIncidentField.LOCATION_INFO);
    trafficIncidentFields.add(TrafficIncidentField.CAUSE_TEXTS);
  }
  
  public WarningClient(TrafficIncidents trafficIncidents) {
    super(TITLE);
    
    LOGGER.setLevel(Level.SEVERE);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    this.trafficIncidentsService = trafficIncidents;
    
    trafficIncidentsListener = new DefaultTrafficIncidentsListener() {

      @Override
      public void updates(EList<Integer> unchangedTrafficIncidentIds, EList<Integer> changedTrafficIncidentIds, EList<Integer> newTrafficIncidentIds, EList<Integer> deletedTrafficIncidentIds) {
        LOGGER.info("updates() called.");
        
        EList<Integer> incidentIds = new BasicEList<>(unchangedTrafficIncidentIds);
        incidentIds.addAll(changedTrafficIncidentIds);
        incidentIds.addAll(newTrafficIncidentIds);
        
        // Update text pane with the new information.
        handleTrafficIncidentIdsReply(incidentIds);
      }

      @Override
      public void getTrafficIncidentsReply(EList<TrafficIncident> trafficIncidents) {
        LOGGER.info("getTrafficIncidentsReply() called.");
        updateWarningPanel(trafficIncidents);
      }

      @Override
      public void addUpdateListenerReply() {
        // No action.
        LOGGER.info("Call to addUpdateListenerReply ignored.");
      }
    };
    
    Container contentPane = getContentPane();
    contentPane.add(createTextPanel());
    pack();
    
    trafficIncidentsService.addUpdateListener(trafficIncidentsListener, severities, new BasicEList<Integer>(), trafficIncidentsListener);
  }
  

  /**
   * Create a panel for the Full message texts.
   */
  private JPanel createTextPanel() {
    warningPanel = new JPanel();
    warningPanel.setLayout(new FlowLayout());
    Dimension warningPanelSize = new Dimension(1000, 500);
    warningPanel.setMinimumSize(warningPanelSize);
    warningPanel.setPreferredSize(warningPanelSize);
    
    return warningPanel;
  }

  
  /**
   * First step in updating the text panel:
   * - hide the Frame if there are no incidents.
   * - otherwise send a request for the texts, with textListener as listener.
   */
  private void handleTrafficIncidentIdsReply(EList<Integer> incidentIds) {
    LOGGER.info("=>");
    if (incidentIds == null  ||  incidentIds.size() == 0) {
      LOGGER.info("<= No Traffic Incidents.");
      warningPanel.removeAll();
      setVisible(false);
      return;
    }
    
    trafficIncidentsService.getTrafficIncidentsFields(trafficIncidentsListener, incidentIds, trafficIncidentFields);
    LOGGER.info("<= Traffic Incidents.");
  }
  
  /**
   * Second step in updating the Full text panel:
   * - display the received texts.
   */
  private void updateWarningPanel(EList<TrafficIncident> trafficIncidents) {
    LOGGER.info("=>");
    warningPanel.removeAll();
    
    for (TrafficIncident trafficIncident: trafficIncidents) {
      StringBuffer buf = new StringBuffer();
      
      EList<Cause> causes = trafficIncident.getCauses();
      EList<String> causeTexts = trafficIncident.getCauseTexts();
      
      if (causes.size() != causeTexts.size()) {
        throw new RuntimeException("Unequal sizes of causes and cause texts");
      }
      
      for (int i = 0; i < causes.size(); i++) {
        // Only if it is a DirectCause there can be a WarningLevel, so it may have to be shown.
        Cause cause = causes.get(i);
        if (cause instanceof DirectCause) {
          DirectCause directCause = (DirectCause) cause;
          WarningLevel warningLevel = null;
          if (directCause.isSetWarningLevel()) {
            warningLevel = directCause.getWarningLevel();
          }
          if (warningLevel != null && severities.contains(warningLevel)) {
            buf.setLength(0);
            generateLocationText(buf, trafficIncident);
            buf.append(" ");

            String causeText = causeTexts.get(i);
            buf.append(causeText);
            warningPanel.add(createWarningPanel(buf.toString(), warningLevel));
          }
        }
      }
    }
    
    this.repaint();
    setVisible(true);
    LOGGER.info("<= visible");
  }
  
  private void generateLocationText(StringBuffer buf, TrafficIncident trafficIncident) {
    
    if (trafficIncident.isSetLocationInfo()) {
      LinearLocationInfo linearLocationInfo = (LinearLocationInfo) trafficIncident.getLocationInfo();
      buf.append("on the ");
      buf.append(linearLocationInfo.getName());
      buf.append(" from ");
      buf.append(linearLocationInfo.getFromLocationParentName());
      buf.append(" to ");
      buf.append(linearLocationInfo.getFromLocationName());
      buf.append(" between ");
      buf.append(linearLocationInfo.getToLocationName());
      buf.append(" and ");
      buf.append(linearLocationInfo.getToLocationParentName());
    }
  }
  
  private JPanel createWarningPanel(String text, WarningLevel warningLevel) {
    JPanel panel = new JPanel();
    
    String title;
    if (warningLevel != null) {
      title = warningLevel.getName();
    } else {
      title = "No warning level available in the Traffic Incident";
    }
    
    panel.setBorder(BorderFactory.createTitledBorder(title));
    
    JTextArea textArea = new JTextArea(6, 80);
    textArea.setLineWrap(true);
    textArea.setEditable(false);
    textArea.setText(text);
    JScrollPane scrollPane = new JScrollPane(textArea);
    
    Color backgroundColor = null;
    if (warningLevel != null) {
      switch (warningLevel) {
      case DANGER_LEVEL_1:
        backgroundColor = Color.YELLOW;
        break;

      case DANGER_LEVEL_2:
        backgroundColor = Color.ORANGE;
        break;

      case DANGER_LEVEL_3:
        backgroundColor = Color.RED;
        break;
        
      default:
        // should not occur, no specific background color.
        break;
      }
    }
    
    if (backgroundColor != null) {
      panel.setBackground(backgroundColor);
    }
    
    panel.add(scrollPane);
    
    return panel;
  }
}
