/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.TpegDecodingUnit;
import org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.TpegSfwAdaptationLayers;
import org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.TpegSfwClients;
import org.genivi.trafficinfo.tpeg.registeredvalues.ApplicationId;
import org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1;
import org.genivi.trafficinfo.tpeg.snitypes.SniComponent;
import org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType1;




public class TpegSfwRefImpl implements TpegSfwClients, TpegSfwAdaptationLayers {
  private final static Logger LOGGER = Logger.getLogger(TpegSfwRefImpl.class.getName()); 

  private long nextChannelId = 1;
  
  // The adaptation layers via which data is received.
//  private List<Object> adaptersBroadcast = new ArrayList<Object>();
  private Map<Long, String> adaptationLayerNames = new HashMap<Long, String>();
  
  GuideToServiceTable1 guideToServiceTable1 = null;

  // The decoding units per TPEG application.
  private Map<Integer, TpegDecodingUnit> decodingUnits = new HashMap<Integer, TpegDecodingUnit>();

  public TpegSfwRefImpl() {
    LOGGER.setLevel(Level.SEVERE);
    LOGGER.info("Creating TpegSfw.");
    //		this.use2WayCommunication = use2WayCommunication;

    // TODO PRIO 1 create controller when adapter registers
    //		if (use2WayCommunication) {
    //			clientTpegFrameworkController = new ClientTpegFrameworkController(this);
    //			clientTpegFrameworkController.start();
    //		} else {
    //			broadcastReception = DummyBroadcastChannel.getInstance();
    //			broadcastReception.addBroadcastReceptionListener(this);
    //		}
  }

  @Override
  public void registerApplication(int applicationId, TpegDecodingUnit decodingUnit) {
    StringBuilder buf = new StringBuilder();
    buf.append("registering application Id: ");
    buf.append(applicationId);
    if (decodingUnit != null) {
      buf.append(", decodingUnit = ");
      buf.append(decodingUnit.getClass().getName());
    }
    LOGGER.info(buf.toString());

    decodingUnits.put(applicationId, decodingUnit);
  }

  @Override
  public void unregisterApplication(int applicationId) {
    decodingUnits.remove(applicationId);
  }

  @Override
  public void transportFrameReceived(long channelId, Object data) {
    LOGGER.info("Received TransportFrame");
    TransportFrameTemplate transportFrameTemplate = (TransportFrameTemplate) data;

    if (transportFrameTemplate instanceof TransportFrameType1) {
      handleTransportFrameType1(channelId, (TransportFrameType1) transportFrameTemplate);
    }
  }

  private void handleTransportFrameType1(long channelId, TransportFrameType1 transportFrameType1) {
    ServiceFrame serviceFrame = transportFrameType1.getTransportFrameContent();
    ServCompMultiplex servCompMultiplex = serviceFrame.getServiceFrameContent();
    for (ServiceComponentFrame serviceData: servCompMultiplex.getMultiplexContent()) {
      LOGGER.info("Handling ServiceComponentFrame for ServiceComponentId: " + serviceData.getSCID());
      String communicationChannelName = adaptationLayerNames.get(channelId);
      if (serviceData.getSCID() == ApplicationId.SNI.getAid()) {
        handleSniServiceComponentFrame(channelId, communicationChannelName, serviceData);
      } else {
        handleNonSniServiceComponentFrame(channelId, communicationChannelName, serviceFrame.getSID(), serviceData);
      }
    }
  }
  
  private void handleSniServiceComponentFrame(long channelId, String communicationChannelName, ServiceComponentFrame serviceComponentFrame) {
    if (serviceComponentFrame instanceof ServCompFrameCountedProtected) {
      ServCompFrameCountedProtected serviceComponentFrameCountedProtected = (ServCompFrameCountedProtected) serviceComponentFrame;
      @SuppressWarnings("unchecked")
      List<SniComponent> sniComponents = (List<SniComponent>) serviceComponentFrameCountedProtected.getApplicationContent();
      for (SniComponent sniComponent: sniComponents) {
        if (sniComponent instanceof SniComponentFastTuning) {
          handleFastTuningComponent((SniComponentFastTuning) sniComponent);
        } else {
          new RuntimeException("Unexpected SNI component");
        }
      }
    } else {
      throw new RuntimeException("Wrong frametype for SNI frame");
    }
  }
  
  private void handleFastTuningComponent(SniComponentFastTuning sniComponent) {
    guideToServiceTable1 = new GuideToServiceTable1();
    
    for (LineOfTable1 lineOfTable1: sniComponent.getLinesOfTable1()) {
      addEntryToGuideToServiceTable1(lineOfTable1);
    }
    
    LOGGER.info("New content of the Guide To The Service Table");
    Iterator<GuideToServiceTable1Entry> iterator = guideToServiceTable1.iterator();
    while(iterator.hasNext()) {
      GuideToServiceTable1Entry entry = iterator.next();
      LOGGER.info("ServiceComponentId: " + entry.getServiceComponentId() +
          ", Originator service ID: " + entry.getServiceId() +
          ", ContentId: " + entry.getContentId() +
          ", ApplicationId: " + entry.getApplicationId());
    }
  }

  private void addEntryToGuideToServiceTable1(LineOfTable1 lineOfTable1) {
    GuideToServiceTable1Entry entry = new GuideToServiceTable1Entry(
        lineOfTable1.getApplicationId(),
        lineOfTable1.getContentId(),
        lineOfTable1.getOriginatorServiceIdentifier(),
        lineOfTable1.getServiceComponentId());
    
    guideToServiceTable1.add(entry);
  }

  private void handleNonSniServiceComponentFrame(long channelId, String communicationChannelName, ServiceIdentifier sid, ServiceComponentFrame serviceData) {
    GuideToServiceTable1Entry entry = guideToServiceTable1.getEntryForServiceComponentId(serviceData.getSCID());
    if (entry == null) {
      LOGGER.info("No entry in Guide To The Service Table for ServiceComponentId " +
          serviceData.getSCID());
      return;
    }
    int applicationId = entry.getApplicationId();
    LOGGER.info("ApplicationId = " + applicationId);

    TpegDecodingUnit tpegDecodingUnit = decodingUnits.get(applicationId);
    if (tpegDecodingUnit != null) {
      ServiceIdentifier sidToUse = entry.getServiceId();
      if (sidToUse == null) {
        sidToUse = sid;
      }
      tpegDecodingUnit.handleServiceComponentFrame(channelId, communicationChannelName, sidToUse, entry.getContentId(), serviceData);
    } else {
      LOGGER.info("No decoding unit for applicationId " +
          applicationId + " (" + ApplicationId.getApplicationIdForId(applicationId).name() + ")");
    }
  }

  @Override
  public long registerAdaptationLayer(Object adaptationLayer, String communicationChannelName) {
    LOGGER.info("Registrating adaptation layer (" + adaptationLayer.getClass().getName() + ")");
//    adaptersBroadcast.add(adaptationLayer);
    long channelId = generateChannelId();
    adaptationLayerNames.put(channelId, communicationChannelName);
    
    return channelId;
  }

  @Override
  public void unregisterAdaptationLayer(long channelId) {
//    adaptersBroadcast.remove(adaptationLayer);
    adaptationLayerNames.remove(channelId);
  }

  public long generateChannelId() {
    return nextChannelId++;
  }
  
}
