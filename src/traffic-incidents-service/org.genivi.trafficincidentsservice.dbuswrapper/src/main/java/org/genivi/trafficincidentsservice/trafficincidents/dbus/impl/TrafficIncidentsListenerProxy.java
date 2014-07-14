/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.dbus.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;
import org.genivi.common.RectangularArea;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsListener;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.RectangularAreaStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TrafficIncidentsDBus;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TrafficIncidentsDBus.Updates;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TrafficIncidentsDBus.UpdatesInAreas;

public class TrafficIncidentsListenerProxy extends DefaultTrafficIncidentsListener {
  private final static Logger LOGGER = Logger.getLogger(TrafficIncidentsListenerProxy.class.getName());

  private DBusConnection conn;
  private Integer listenerId;
  private String destination;
  
  public TrafficIncidentsListenerProxy(String destination, Integer listenerId) {
    this.listenerId = listenerId;
    this.destination = destination;
    
    try {
      conn = DBusConnection.getConnection(DBusConnection.SESSION);
    } catch (DBusException e) {
      e.printStackTrace();
    }
    
    LOGGER.setLevel(Level.SEVERE);
  }
  

  @Override
  public void updates(EList<Integer> eListUnchangedTrafficIncidentIds,
      EList<Integer> eListChangedTrafficIncidentIds, EList<Integer> eListNewTrafficIncidentIds,
      EList<Integer> eListDeletedTrafficIncidentIds) {
    LOGGER.info("TrafficIncidentsListenerProxy:updates => eListUnchangedTrafficIncidentIds = " + eListUnchangedTrafficIncidentIds +
        ", eListChangedTrafficIncidentIds = " + eListChangedTrafficIncidentIds +
        ", eListNewTrafficIncidentIds = " + eListNewTrafficIncidentIds +
        ", eListDeletedTrafficIncidentIds = " + eListDeletedTrafficIncidentIds);
    
    sendSignalUpdates(listenerId, eListUnchangedTrafficIncidentIds, eListChangedTrafficIncidentIds, eListNewTrafficIncidentIds, eListDeletedTrafficIncidentIds);
  }

  @Override
  public void updatesInAreas(EList<RectangularArea> areas) {
    LOGGER.info("TrafficIncidentsListenerProxy:updatesInAreas => areas = " + areas);
    sendSignalUpdatesInAreas(listenerId, areas);
  }

  public Integer getListenerId() {
    return listenerId;
  }

  public String getDestination() {
    return destination;
  }

  public void sendSignalUpdates(Integer listenerId, EList<Integer> eListUnchangedTrafficIncidentIds, EList<Integer> eListChangedTrafficIncidentIds, EList<Integer> eListNewTrafficIncidentIds, EList<Integer> eListDeletedTrafficIncidentIds) {
    List<Integer> unchangedTrafficIncidentIds = new ArrayList<>();
    for (Integer id: eListUnchangedTrafficIncidentIds) {
      unchangedTrafficIncidentIds.add(id);
    }

    List<Integer> changedTrafficIncidentIds = new ArrayList<>();
    for (Integer id: eListChangedTrafficIncidentIds) {
      changedTrafficIncidentIds.add(id);
    }

    List<Integer> newTrafficIncidentIds = new ArrayList<>();
    for (Integer id: eListNewTrafficIncidentIds) {
      newTrafficIncidentIds.add(id);
    }

    List<Integer> deletedTrafficIncidentIds = new ArrayList<>();
    for (Integer id: eListDeletedTrafficIncidentIds) {
      deletedTrafficIncidentIds.add(id);
    }

    try {
      String path = addDestinationInfoToPath();
      Updates updates = new TrafficIncidentsDBus.Updates(path, listenerId, unchangedTrafficIncidentIds, changedTrafficIncidentIds, newTrafficIncidentIds, deletedTrafficIncidentIds);
      LOGGER.info("going to send Updates signal to: " + destination);
      conn.sendSignal(updates);
    } catch (DBusException e) {
      e.printStackTrace();
    }
  }

  public void sendSignalUpdatesInAreas(Integer listenerId, EList<RectangularArea> areas) {
    List<RectangularAreaStruct> areaStructs = new ArrayList<>();
    
    for (RectangularArea area: areas) {
      RectangularAreaStruct areaStruct = StructUtil.rectangularAreaToRectangularAreaStruct(area);
      areaStructs.add(areaStruct);
    }
    
    LOGGER.info("going to send UpdatesInAreas signal to: " + destination);
    
    try {
      String path = addDestinationInfoToPath();
      UpdatesInAreas updatesInAreas = new TrafficIncidentsDBus.UpdatesInAreas(path, listenerId, areaStructs);
      conn.sendSignal(updatesInAreas);
    } catch (DBusException e) {
      e.printStackTrace();
    }
  }
  
  String addDestinationInfoToPath() {
    String destinationPatched = destination.replaceAll(":", "/p");
    destinationPatched = destinationPatched.replaceAll("\\.", "/p");
    String path = "/java" + destinationPatched + "id" + listenerId;
    path = path + "&" + destination;
    LOGGER.info("addDestinationInfoToPath: path (2) = " + path);
    
    return path;
  }
}
