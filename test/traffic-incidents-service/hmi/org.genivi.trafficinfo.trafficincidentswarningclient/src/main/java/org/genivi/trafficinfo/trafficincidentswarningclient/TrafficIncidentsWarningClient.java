/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentswarningclient;

import javax.swing.JOptionPane;

import org.freedesktop.dbus.exceptions.DBusException;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.impl.TrafficIncidentsDBusProxy;
import org.genivi.trafficinfo.trafficincidentsexampleclients.WarningClient;

public class TrafficIncidentsWarningClient {
  private static final String NEWLINE = System.getProperty("line.separator");
  private final static String TRAFFIC_INCIDENTS_SERVICE_NAME = "org.genivi.trafficinfo.TrafficIncidentsDBus";
  private final static String OBJECT_PATH_SERVICE = "/java";
  private String objectPath = OBJECT_PATH_SERVICE;
  private String interfaceName = TRAFFIC_INCIDENTS_SERVICE_NAME;
  
  private TrafficIncidents trafficIncidentsService;
  
  TrafficIncidentsWarningClient() throws DBusException {
    // Create the Traffic Information Provider Proxy
    trafficIncidentsService = new TrafficIncidentsDBusProxy(interfaceName, objectPath);
    
    // Create the Warning Client
    @SuppressWarnings("unused")
    WarningClient trafficInfoMapView = new WarningClient(trafficIncidentsService);    
  }
  
  public static void main(String[] args) throws DBusException {
    // Check the arguments and if not OK, show a message and exit.
    // The TrafficIncidentsWarningClient has no arguments.
    if (args.length != 0) {
      showUsageInfoDialogAndExit(args);    
    }
    
    @SuppressWarnings("unused")
    TrafficIncidentsWarningClient trafficIncidentsWarningClient = new TrafficIncidentsWarningClient();
  }
  
  private static void showUsageInfoDialogAndExit(final String[] args) {
    StringBuilder argInfo = new StringBuilder();

    argInfo.append("TrafficIncidentsWarningClient has to be called without arguments.").append(NEWLINE);
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
