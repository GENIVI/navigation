/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentsmapclient;

import javax.swing.JOptionPane;

import openlr.map.MapDatabase;
import openlr.map.teleatlas.sqlite.impl.MapDatabaseImpl;

import org.freedesktop.dbus.exceptions.DBusException;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.impl.TrafficIncidentsDBusProxy;
import org.genivi.trafficinfo.trafficincidentsexampleclients.TrafficInfoMapView;

public class TrafficIncidentsMapClient {
  private final static String MAP_PATH = "../resources/tomtom_utrecht_2008_04.db3";
  private static final String NEWLINE = System.getProperty("line.separator");
  private final static String TRAFFIC_INCIDENTS_SERVICE_NAME = "org.genivi.trafficinfo.TrafficIncidentsDBus";
  private final static String TRAFFIC_INCIDENTS_GATEWAY_NAME = "org.genivi.trafficinfo.TrafficIncidentsGateway";
  private final static String OBJECT_PATH_SERVICE = "/java";
  private final static String OBJECT_PATH_GATEWAY = "/cpp";
  private String objectPath = OBJECT_PATH_SERVICE;
  private String interfaceName = TRAFFIC_INCIDENTS_SERVICE_NAME;
  
  private MapDatabase mapDataBase;
  private TrafficIncidents trafficIncidentsService;
  
  TrafficIncidentsMapClient(boolean useCppGateway) throws DBusException {
    if (useCppGateway) {
      objectPath = OBJECT_PATH_GATEWAY;
      interfaceName = TRAFFIC_INCIDENTS_GATEWAY_NAME;
    }

    // Open a map database to be used by the Map Display
    mapDataBase = new MapDatabaseImpl(MAP_PATH);

    // Create the Traffic Information Provider Proxy
//    trafficIncidentsService = createTrafficIncidentsServiceProxy();
    trafficIncidentsService = new TrafficIncidentsDBusProxy(interfaceName, objectPath);
    
    // Create the Map Display
    @SuppressWarnings("unused")
    TrafficInfoMapView trafficInfoMapView = new TrafficInfoMapView(mapDataBase, trafficIncidentsService);    
  }
  
//  private TrafficIncidents createTrafficIncidentsServiceProxy() throws DBusException {
//    DBusConnection conn = DBusConnection.getConnection(DBusConnection.SESSION);
//    
//    // Show the D-Bus xml interface definition
//    Introspectable introSpectable = (Introspectable) conn.getRemoteObject(interfaceName, objectPath, Introspectable.class);
//    boolean introspectOk = false;
//    while (!introspectOk) {
//      LOGGER.info("Waiting for service to become available ...");
//      try {
//        String data = introSpectable.Introspect();
//        LOGGER.info("Introspectable: " + data);
//        introspectOk = true;
//      } catch (Exception e) {
//        LOGGER.severe(e.getMessage());
//      }
//      try {
//        Thread.sleep(500);
//      } catch (InterruptedException e) {
//      }
//    }
//    
//    TrafficIncidentsDBus trafficIncidentsDBus = (TrafficIncidentsDBus) conn.getRemoteObject(interfaceName, objectPath, TrafficIncidentsDBus.class);
//    LOGGER.info("TrafficIncidentsDBus obtained");
//   
//    TrafficIncidentsDBusProxy trafficIncidentsDBusProxy = new TrafficIncidentsDBusProxy(conn, trafficIncidentsDBus, null);
//
//    return trafficIncidentsDBusProxy;
//  }

  public static void main(String[] args) throws DBusException {
    boolean useGateway = false;
    
    // Check the arguments and if not OK, show a message and exit.
    // The TrafficIncidentsMapClient has 1 optional argument: to use the C++ gateway.
    if ((args.length != 0  &&  args.length != 1)  ||
        (args.length != 0 && !args[0].equals("useGateway"))) {
      showUsageInfoDialogAndExit(args);    
    }
    
    if (args.length != 0  &&  args[0].equals("useGateway")) {
      useGateway = true;
    }
    
    @SuppressWarnings("unused")
    TrafficIncidentsMapClient trafficIncidentsListClient = new TrafficIncidentsMapClient(useGateway);
  }
  
  private static void showUsageInfoDialogAndExit(final String[] args) {
    StringBuilder argInfo = new StringBuilder();

    argInfo.append("TrafficIncidentsMapClient has one optional argument: useGateway.").append(NEWLINE);
    argInfo.append("By default this client directly talks to the Java server").append(NEWLINE);
    argInfo.append("If 'useGateway' is specified, it will talk to the C++ gateway.").append(NEWLINE);
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
