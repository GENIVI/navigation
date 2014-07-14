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

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.common.Version;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsUpdatesListener;
import org.genivi.trafficincidentsservice.TrafficIncidentFeed;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedListener;
import org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.TpegDecodingUnit;
import org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.TpegSfwClients;
import org.genivi.trafficinfo.tpeg.registeredvalues.ApplicationId;


public class TpegTecFeedRefImpl extends EObjectImpl {
  // Version information
  private static final int REQUIRED_TIS_MAJOR_VERSION_NUMBER = 1;
  private static final int REQUIRED_TIS_MINOR_VERSION_NUMBER = 0;
  private static String COMMUNICATION_CHANNEL_NAME = "some tuner";
  
  private final static Logger LOGGER = Logger.getLogger(TpegTecFeedRefImpl.class.getName());

  
  private TrafficIncidentFeed trafficIncidentFeed;
  private TpegSfwClients tpegSfwClients;
  private TpegTecMessageHandler tpegTecMessageHandler;
  private TpegDecodingUnit tpegTecDecodingUnit;
  private boolean registeredToSfw = false;
      
  public TpegTecFeedRefImpl(TpegSfwClients tpegSfwClients, TrafficIncidentFeed trafficIncidentFeed) {
    LOGGER.setLevel(Level.SEVERE);
    LOGGER.info("Creating TpegTecFeed");
    
    this.trafficIncidentFeed = trafficIncidentFeed;
    this.tpegSfwClients = tpegSfwClients;
    
    sendTrafficIncidentsUpdatesVersionRequest();
    
  }

  private void sendTrafficIncidentsUpdatesVersionRequest() {
    LOGGER.info("Step 1: Get the version of the Traffic Incidents Service");
    TrafficIncidentFeedListener listener = new VersionListener();
    trafficIncidentFeed.getVersion(listener);
  }
  
  private void handleTrafficIncidentsUpdatesVersionReply(Version version) {
    LOGGER.info("Step 1a: Version received: version = " + version);
    if (version.getMajor() != REQUIRED_TIS_MAJOR_VERSION_NUMBER  ||
        version.getMinor() != REQUIRED_TIS_MINOR_VERSION_NUMBER) {
      LOGGER.severe("Step 1b: Unsupported version");
      throw new RuntimeException("Incompatible version of TrafficIncidentFeed");
    }
    // TODO extend the interface to the service framework:
    // - first register there as Decoding Unit
    // - register there as channel listener
    // - when a channel is received, register as feed to the service
    // - then register for that specific channel at the framework
    // - only then data for that channel will be recieved.
    // For now we use a fixed channel name.
    LOGGER.info("Step 1c: Supported version, continue with next step");
    registerToTrafficIncidentsService(COMMUNICATION_CHANNEL_NAME);
  }

  private void registerToTrafficIncidentsService(String communicationChannelName) {
    LOGGER.info("Step 2: Register as a Feed to the Traffic Incidents Service");
    TrafficIncidentFeedListener listener = new RegisterFeedReplyListener();
    trafficIncidentFeed.registerFeed(listener, "TomTom", "TPEG-TEC", communicationChannelName);
  }
  
  private void handleTrafficIncidentsUpdatesRegisterFeedReply(int feedId) {
    LOGGER.info("Step 2a: feedId received, feedId = " + feedId);
    
    tpegTecMessageHandler = new TpegTecMessageHandlerRefImpl(trafficIncidentFeed, COMMUNICATION_CHANNEL_NAME, feedId);
    tpegTecDecodingUnit = new TpegTecDecodingUnit(tpegTecMessageHandler);
    
    
    tpegSfwClients.registerApplication(ApplicationId.TEC.getAid(), tpegTecDecodingUnit);
    registeredToSfw = true;
    
    registerLanguageListener();
  }
  
  private void registerLanguageListener() {
    LOGGER.info("Step 3: Register as a Language Listener to the Traffic Incidents Service");
    TrafficIncidentFeedListener listener = new GetLanguageReplyListener();
    trafficIncidentFeed.addLanguageListener(listener, listener);
  }

  private void handleLanguageChanged(String languageCode, String countryCode) {
    LOGGER.info("Step 3a: language received: languageCode = " + languageCode + ", countryCode = " + countryCode);
    tpegTecMessageHandler.languageChanged(languageCode, countryCode);
    
    LOGGER.info("Step 4: Ready to handle data, register as application to the Sfw");
    if (!registeredToSfw) {
      tpegSfwClients.registerApplication(ApplicationId.TEC.getAid(), tpegTecDecodingUnit);
      registeredToSfw = true;
    }
  }
  
  private class VersionListener extends DefaultTrafficIncidentsUpdatesListener {

    @Override
    public void getVersionReply(Version version) {
      handleTrafficIncidentsUpdatesVersionReply(version);      
    }
  }

  private class RegisterFeedReplyListener extends DefaultTrafficIncidentsUpdatesListener {

    @Override
    public void registerFeedReply(int feedId) {
      LOGGER.info("registerFeedReply() called, feedId = " + feedId);
      handleTrafficIncidentsUpdatesRegisterFeedReply(feedId);
    }
  }

  private class GetLanguageReplyListener extends DefaultTrafficIncidentsUpdatesListener {

    @Override
    public void getLanguageReply(String languageCode, String countryCode) {   
      LOGGER.info("getLanguageReply: " + languageCode + ", " + countryCode);
      handleLanguageChanged(languageCode, countryCode);
    }

    @Override
    public void addLanguageListenerReply() {
      // No action.
      LOGGER.info("Call to addLanguageListenerReply ignored!");
    }
  }
}
