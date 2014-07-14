/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.tpegtecfeed.refimpl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentFeed;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentFactory;
import org.genivi.trafficinfo.tpeg.tec.event.TECMessage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MessageManagementContainer;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;


public class TpegTecMessageHandlerRefImpl extends EObjectImpl implements TpegTecMessageHandler {
  private final static Logger LOGGER = Logger.getLogger(TpegTecMessageHandlerRefImpl.class.getName()); 
  private final static XTrafficIncidentFactory factory = XTrafficIncidentFactory.eINSTANCE;
  
  private int feedId;
  private String communicationChannelName;
  TrafficIncidentsStatus trafficIncidentsStatus = TrafficIncidentsStatus.UNAVAILABLE;
  private TrafficIncidentFeed trafficIncidentFeed;
  private TecEventToTrafficIncidentConversion tecEventToTrafficIncidentConversion;
  private ServiceIdentifier originatorSID;
  private byte COID;
  private EList<String> cancels;
  private EList<TrafficIncident> updates;
  
  public TpegTecMessageHandlerRefImpl(TrafficIncidentFeed trafficIncidentFeed, String communicationChannelName, int feedId) {
    LOGGER.setLevel(Level.SEVERE);
    LOGGER.info("=> trafficIncidentFeed = " + trafficIncidentFeed +
        ", communicationChannelName = " + communicationChannelName + ", feedId = " + feedId);
    
    this.trafficIncidentFeed = trafficIncidentFeed;
    this.feedId = feedId;
    this.communicationChannelName = communicationChannelName;
    tecEventToTrafficIncidentConversion = new TecEventToTrafficIncidentConversion();
  }
  
  public void languageChanged(String languageCode, String countryCode) {
    LOGGER.info("=> languageCode = " + languageCode + ", countryCode = " + countryCode);
    tecEventToTrafficIncidentConversion.setLanguage(languageCode, countryCode);
  }

  @Override
  public void handleMessagesStart(long channelId, String communicationChannelName, ServiceIdentifier originatorSID, byte COID) {
    LOGGER.info("handleMessagesStart => communicationChannelName = " + communicationChannelName);
    if (!communicationChannelName.equals(this.communicationChannelName)) {
      LOGGER.severe("Unexpected communicationChannelName: " + communicationChannelName);
    }
    
    updateStatus();
    
    this.originatorSID = originatorSID;
    this.COID = COID;
    cancels = new BasicEList<String>();
    updates = new BasicEList<TrafficIncident>();
  }

  private void updateStatus() {
    LOGGER.info("=>");
    if (trafficIncidentsStatus == TrafficIncidentsStatus.UNAVAILABLE) {
      trafficIncidentsStatus = TrafficIncidentsStatus.PARTLY_AVAILABLE;
      LOGGER.info("Switching to PARTLY_AVAILABLE.");
   } else {
      trafficIncidentsStatus = TrafficIncidentsStatus.AVAILABLE;
      LOGGER.info("Switching to AVAILABLE.");
    }
    
    trafficIncidentFeed.updateStatus(feedId, TrafficIncidentFeedStatus.CONNECTED, trafficIncidentsStatus);
    LOGGER.info("<=");
  }
  
  @Override
  public void handleMessage(TECMessage tecMessage) {
    LOGGER.info("Going to handle TECMessage.");
    
    MMCSwitch mmcSwitch = tecMessage.getMmt();
    String trafficIncidentManagementId = TecUtil.createMessageId(originatorSID, COID, mmcSwitch.getMessageID());
    MessageManagementContainer messageManagementContainer = (MessageManagementContainer) mmcSwitch;
    if (messageManagementContainer.isCancelFlag()) {
      cancels.add(trafficIncidentManagementId);
    } else {
      TrafficIncident managedTrafficIncident = factory.createTrafficIncident();

      managedTrafficIncident.setTrafficIncidentId(trafficIncidentManagementId);
      managedTrafficIncident.setExpirationTime(mmcSwitch.getMessageExpiryTime());
      
      tecEventToTrafficIncidentConversion.convertTecMessageToManagedTrafficIncident(managedTrafficIncident, tecMessage);
      
      updates.add(managedTrafficIncident);
    }
  }

  @Override
  public void handleMessagesEnd() {
    LOGGER.info("=> feedId = " + feedId);
    if (!cancels.isEmpty()  ||  !updates.isEmpty()) {
      trafficIncidentFeed.updateIncidents(feedId, cancels, updates);
    }
  }
}
