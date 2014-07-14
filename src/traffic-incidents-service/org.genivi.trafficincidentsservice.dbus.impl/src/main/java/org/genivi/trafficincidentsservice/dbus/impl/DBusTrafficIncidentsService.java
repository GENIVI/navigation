/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.dbus.impl;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import openlr.map.MapDatabase;
import openlr.map.teleatlas.sqlite.impl.MapDatabaseImpl;

import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;
import org.genivi.locref.LocationReferenceType;
import org.genivi.locref.decoder.openlr.OpenLRDecoder;
import org.genivi.locref.refimpl.LocationReferenceDecodingHandlerRefImpl;
import org.genivi.trafficincidentsservice.TrafficIncidentFeed;
import org.genivi.trafficincidentsservice.refimpl.TrafficIncidentsService;
import org.genivi.trafficincidentsservice.textgenerator.basictextgenerator.BasicTextGenerator;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.impl.TrafficIncidentsUpdatesAdaptor;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.impl.TrafficIncidentsAdaptor;

public class DBusTrafficIncidentsService {
  private final static Logger LOGGER = Logger.getLogger(DBusTrafficIncidentsService.class.getName());
  private final static String TRAFFIC_INCIDENTS_SERVICE_NAME = "org.genivi.trafficinfo.TrafficIncidentsDBus";
  private final static String TRAFFIC_INCIDENT_FEED_SERVICE_NAME = "org.genivi.trafficinfo.TrafficIncidentsUpdatesDBus";
  private final static String MAP_PATH = "../resources/tomtom_utrecht_2008_04.db3";

  //settings to control what to run and what not
  private final static Level logLevel = Level.SEVERE;
  
  DBusTrafficIncidentsService() throws DBusException {
    
    logSetup();

    // Create the Traffic Incidents Service
    TrafficIncidentsService trafficIncidentsService = createTrafficIncidentsService();
    
    // Create the Traffic Incident Feed Adaptor
    createTrafficIncidentFeedAdaptor(trafficIncidentsService);
    
    // Create the Traffic Incidents Adaptor
    createTrafficIncidentsAdaptor(trafficIncidentsService);    
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
    consoleHandler.setLevel(Level.INFO);
  }

  private TrafficIncidentsService createTrafficIncidentsService() {
    // Create a Location Reference Decoding Handler to be used by the Traffic Incidents Service
    LocationReferenceDecodingHandlerRefImpl locationReferenceDecodingHandlerRefImpl = new LocationReferenceDecodingHandlerRefImpl();

    // Open a map database to be used by the location decoders
    MapDatabase mapDataBase = new MapDatabaseImpl(MAP_PATH);

    // Create an OpenLR decoder and register it on the LocationReferenceDecodingHandlerRefImpl
    OpenLRDecoder openLRDecoder = new OpenLRDecoder(mapDataBase);
    locationReferenceDecodingHandlerRefImpl.addDecoder((Byte) (byte) LocationReferenceType.OPEN_LR.getValue(), openLRDecoder);

    // Create the Traffic Incidents Service
    TrafficIncidentsService trafficIncidentsService = new TrafficIncidentsService(locationReferenceDecodingHandlerRefImpl, new BasicTextGenerator());
    
    return trafficIncidentsService;
  }

  private void createTrafficIncidentFeedAdaptor(TrafficIncidentFeed trafficIncidentFeed) throws DBusException {
    DBusConnection conn = DBusConnection.getConnection(DBusConnection.SESSION);
    LOGGER.info("DBusConnection obtained");
        
    conn.requestBusName(TRAFFIC_INCIDENT_FEED_SERVICE_NAME);
    conn.exportObject("/trafficincidentfeed", new TrafficIncidentsUpdatesAdaptor(conn, trafficIncidentFeed));
    LOGGER.info("D-Bus Service TrafficIncidentsUpdatesDBus running");
  }

  private void createTrafficIncidentsAdaptor(TrafficIncidentsService trafficIncidentsService) throws DBusException {
    DBusConnection conn = DBusConnection.getConnection(DBusConnection.SESSION);
    LOGGER.info("DBusConnection obtained");
    
    conn.requestBusName(TRAFFIC_INCIDENTS_SERVICE_NAME);
    
    conn.exportObject("/java", new TrafficIncidentsAdaptor(conn, trafficIncidentsService));
    LOGGER.info("D-Bus Service TrafficIncidentsDBus running");
  }
  
  public static void main(String[] args) throws DBusException {
    @SuppressWarnings("unused")
    DBusTrafficIncidentsService dBusTrafficIncidentsService = new DBusTrafficIncidentsService();
    LOGGER.info("DBusTrafficIncidentsService running");
  }
  
}
