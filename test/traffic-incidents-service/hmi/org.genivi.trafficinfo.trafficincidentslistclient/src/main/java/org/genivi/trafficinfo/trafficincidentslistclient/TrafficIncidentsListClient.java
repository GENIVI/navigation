/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentslistclient;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.EList;
import org.freedesktop.dbus.exceptions.DBusException;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.impl.TrafficIncidentsDBusProxy;
import org.genivi.trafficinfo.trafficincidentsexampleclients.TrafficInfoListDisplay;


public class TrafficIncidentsListClient {
  private final static Logger LOGGER = Logger.getLogger(TrafficIncidentsListClient.class.getName());
  private static final String NEWLINE = System.getProperty("line.separator");
  private final static String TRAFFIC_INCIDENTS_SERVICE_NAME = "org.genivi.trafficinfo.TrafficIncidentsDBus";
  private final static String TRAFFIC_INCIDENTS_SERVICE_OBJECT_PATH = "/java";
  
  private String trafficIncidentsInterfaceName = TRAFFIC_INCIDENTS_SERVICE_NAME;
  private String trafficIncidentsObjectPath = TRAFFIC_INCIDENTS_SERVICE_OBJECT_PATH;
  
  private TrafficIncidents trafficIncidentsService;
  private boolean waitingForReply;
  private EList<CategoryDefinition> categoryDefinitions;
  
  TrafficIncidentsListClient() throws DBusException {
    // Create the Traffic Information Provider Proxy
    trafficIncidentsService = new TrafficIncidentsDBusProxy(
        trafficIncidentsInterfaceName, trafficIncidentsObjectPath);
    
    // Wait for configuration to be ready, checked by category definitions being available.
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {

      @Override
      public void getCategoryDefinitionsReply(EList<CategoryDefinition> categoryDefinitions) {
        LOGGER.info("getCategoryDefinitionsReply => categoryDefinitions = " + categoryDefinitions);
        handleCategoryDefinitionsReceived(categoryDefinitions);
      }
    };
    
    while (categoryDefinitions == null  ||  categoryDefinitions.isEmpty()) {
      LOGGER.info("Waiting for category definitions");
      waitingForReply = true;
      trafficIncidentsService.getCategoryDefinitions(listener);
      
      while (waitingForReply) {
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
        }
      }
    }
    
    // Create the List Display
    TrafficInfoListDisplay trafficIncidentsListDisplay = new TrafficInfoListDisplay(trafficIncidentsService);
    trafficIncidentsListDisplay.setVisible(true);
    
  }
  
  protected void handleCategoryDefinitionsReceived(EList<CategoryDefinition> categoryDefinitions) {
    this.categoryDefinitions = categoryDefinitions;
    waitingForReply = false;
  }

  public static void main(String[] args) throws DBusException {
    LOGGER.setLevel(Level.SEVERE);
    
    // Check the arguments and if not OK, show a message and exit.
    // The TrafficIncidentsListClient has no arguments.
    if (args.length != 0) {
      showUsageInfoDialogAndExit(args);    
    }
    
    @SuppressWarnings("unused")
    TrafficIncidentsListClient trafficIncidentsListClient = new TrafficIncidentsListClient();
  }
  
  private static void showUsageInfoDialogAndExit(final String[] args) {
    StringBuilder argInfo = new StringBuilder();

    argInfo.append("TrafficIncidentsListClient has to be called without arguments.").append(NEWLINE);
    argInfo.append("The following arguments were given:");
    for (int i = 0; i < args.length; i++) {
      argInfo.append(NEWLINE).append(args[i]);
    }

    JOptionPane.showMessageDialog(null,
        argInfo.toString(),
        "Error",
        JOptionPane.ERROR_MESSAGE);
    
    System.exit(0);
  }
}
