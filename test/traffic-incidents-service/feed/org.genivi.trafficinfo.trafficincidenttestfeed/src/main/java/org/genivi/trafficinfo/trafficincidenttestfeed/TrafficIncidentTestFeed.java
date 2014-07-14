/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidenttestfeed;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.freedesktop.DBus.Introspectable;
import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;
import org.genivi.tpegtecfeed.refimpl.TpegTecFeedRefImpl;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsUpdatesListener;
import org.genivi.trafficincidentsservice.TrafficIncidentFeed;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedListener;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.TrafficIncidentFeedDBus;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.impl.TrafficIncidentFeedDBusProxy;
import org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.impl.TpegSfwRefImpl;
import org.genivi.trafficinfo.tpeg.clientside.broadcastadaptionlayer.refimpl.BroadcastAdaptationLayerImplementation;
import org.genivi.trafficinfo.tpeg.serverside.broadcast.fwk.impl.BroadcastFrameworkImplementation;
import org.genivi.trafficinfo.tpeg.tecservice.testsetplayer.TestPlayerTecService;


public class TrafficIncidentTestFeed {
  private final static Logger LOGGER = Logger.getLogger(TrafficIncidentTestFeed.class.getName());
  private final static String TRAFFIC_INCIDENTS_SERVICE_NAME = "org.genivi.trafficinfo.TrafficIncidentsUpdatesDBus";
  private final static String OBJECT_PATH_SERVICE = "/trafficincidentfeed";

  
  private String objectPath = OBJECT_PATH_SERVICE;
  private String interfaceName = TRAFFIC_INCIDENTS_SERVICE_NAME;

  //settings to control what to run and what not
  private final static Level logLevel = Level.SEVERE;
  
  private TrafficIncidentFeed trafficIncidentsService;
  
  TrafficIncidentTestFeed() throws DBusException {
    
    logSetup();

    // Create the Traffic Information Service Proxy
    trafficIncidentsService = createTrafficIncidentsServiceProxy();
    
    createTpegTecFeeds(trafficIncidentsService);
  }

  private void logSetup() {
    // Create Logger
    Logger logger = Logger.getLogger("");
    logger.setLevel(logLevel);
    
    Handler consoleHandler = null;
    for (Handler handler: logger.getHandlers()) {
      if (handler.getClass().getName().equals("java.util.logging.ConsoleHandler")) {
        consoleHandler = handler;
        break;
      }
    }
    consoleHandler.setLevel(logLevel);
  }

  
  private TrafficIncidentFeed createTrafficIncidentsServiceProxy() throws DBusException {
    DBusConnection conn = DBusConnection.getConnection(DBusConnection.SESSION);
    
    // Show the D-Bus xml interface definition
    Introspectable introSpectable = (Introspectable) conn.getRemoteObject(interfaceName, objectPath, Introspectable.class);
    boolean introspectOk = false;
    while (!introspectOk) {
      LOGGER.info("Waiting for service to become available ...");
      try {
        String data = introSpectable.Introspect();
        LOGGER.severe("Connected to interface with following specification:");
        LOGGER.severe(data);
        introspectOk = true;
      } catch (Exception e) {
        LOGGER.info(e.getMessage());
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
    
    TrafficIncidentFeedDBus trafficIncidentFeedDBus = (TrafficIncidentFeedDBus) conn.getRemoteObject(interfaceName, objectPath, TrafficIncidentFeedDBus.class);
    LOGGER.info("TrafficIncidentsUpdatesDBus obtained");
   
    TrafficIncidentFeedDBusProxy trafficIncidentFeedDBusProxy = new TrafficIncidentFeedDBusProxy(conn, trafficIncidentFeedDBus);

    return trafficIncidentFeedDBusProxy;
  }

  private void createTpegTecFeeds(TrafficIncidentFeed trafficIncidentsService) {
    /*
     * Initialise server side broadcast, and a TPEG-TEC Service.
     */

    // Create and start Server Side framework
    BroadcastFrameworkImplementation serverSideBroadcastFramework = new BroadcastFrameworkImplementation();
    serverSideBroadcastFramework.start();

    @SuppressWarnings("unused")
    TestPlayerTecService tecService = new TestPlayerTecService(serverSideBroadcastFramework);

    /*
     * Initialize client side TPEG framework for broadcast reception, and a Time Application.
     */

    // Create client side TPEG framework.
    TpegSfwRefImpl clientSideTpegFrameworkImplementationBroadcast = new TpegSfwRefImpl();
    @SuppressWarnings("unused")
    BroadcastAdaptationLayerImplementation broadcastAdaptationLayerImplementation = new BroadcastAdaptationLayerImplementation("some tuner", clientSideTpegFrameworkImplementationBroadcast);


    // Create TPEG-TEC Feed (TEC Application in TISA terms)
    new TpegTecFeedRefImpl(clientSideTpegFrameworkImplementationBroadcast, trafficIncidentsService);
    
    // Register a dummy feed for extra status information.
    TrafficIncidentFeedListener dummyTrafficIncidentsUpdatesListener = new DefaultTrafficIncidentsUpdatesListener();
    trafficIncidentsService.registerFeed(dummyTrafficIncidentsUpdatesListener , "GENIVI", "RDS-TMC", "TMC bridge");

  }
  
  public static void main(String[] args) throws DBusException {
    @SuppressWarnings("unused")
    TrafficIncidentTestFeed trafficIncidentTestFeed = new TrafficIncidentTestFeed();
    LOGGER.info("TrafficIncidentsFeed running");
  }  
}
