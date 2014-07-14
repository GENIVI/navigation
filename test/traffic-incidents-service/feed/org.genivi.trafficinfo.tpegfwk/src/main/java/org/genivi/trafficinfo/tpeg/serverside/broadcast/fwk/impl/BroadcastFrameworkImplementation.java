/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.serverside.broadcast.fwk.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.BasicEList;
import org.genivi.trafficinfo.demo.communicationchannel.broadcastchannel.Broadcast;
import org.genivi.trafficinfo.demo.communicationchannel.broadcastchannel.impl.DummyBroadcastChannel;
import org.genivi.trafficinfo.tpeg.registeredvalues.ApplicationId;
import org.genivi.trafficinfo.tpeg.serverside.broadcast.app.fwk.ApplicationServer;
import org.genivi.trafficinfo.tpeg.serverside.broadcast.fwk.BroadcastFramework;
import org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1;
import org.genivi.trafficinfo.tpeg.snitypes.SniComponent;
import org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning;
import org.genivi.trafficinfo.tpeg.snitypes.SnitypesFactory;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesFactory;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType1;



public class BroadcastFrameworkImplementation extends Thread implements BroadcastFramework {
  private static final Logger LOGGER = Logger.getLogger(BroadcastFrameworkImplementation.class.getName()); 
  private static final TpegfwktypesFactory FACTORY = TpegfwktypesFactory.eINSTANCE;
  private static final SnitypesFactory SNI_FACTORY = SnitypesFactory.eINSTANCE;
  private static final ServiceIdentifier MY_SID = FACTORY.createServiceIdentifier();
  private static final byte GUIDE_TO_SERVICE_TABLE1_INC_VERSION_NUMBER = 1;

  private byte nextServiceComponentId = (byte) 1;
  private Map<GuideToServiceTable1Entry, ApplicationServer> applicationServers = new HashMap<GuideToServiceTable1Entry, ApplicationServer>();
  private Broadcast broadcast = DummyBroadcastChannel.getInstance();

  static {
    MY_SID.setSidA((byte) 99);
    MY_SID.setSidB((byte) 66);
    MY_SID.setSidC((byte) 33);
  }

  public BroadcastFrameworkImplementation() {
    LOGGER.setLevel(Level.SEVERE);
    LOGGER.info("Creating broadcast framework");
  }

  public void run() {
    while(true) {
      // create a TransportFrame
      // TODO handle situation where more than 1 frame is needed.
      TransportFrameType1 transportFrame = FACTORY.createTransportFrameType1();
      boolean broadcastNeeded = false;
      ServiceFrame serviceFrame = FACTORY.createServiceFrame();
      serviceFrame.setServEncID(0); // No encryption
      serviceFrame.setSID(MY_SID);
      ServCompMultiplex servCompMultiplex = FACTORY.createServCompMultiplex();
      List<ServiceComponentFrame> serviceComponentFrames = servCompMultiplex.getMultiplexContent();
      serviceFrame.setServiceFrameContent(servCompMultiplex);
      transportFrame.setTransportFrameContent(serviceFrame);

      // start with SNI service component frame
      ServiceComponentFrame sniServiceComponentFrame = getSniServiceComponentFrame();
      if (sniServiceComponentFrame != null) {
        serviceComponentFrames.add(sniServiceComponentFrame);
        broadcastNeeded = true;
      }

      // get latest information from all registered services.
      for (GuideToServiceTable1Entry entry: applicationServers.keySet()) {
        byte applicationId = entry.getApplicationId();
        // TODO pass on driveId, so service specific access can be checked.
        ApplicationServer applicationServer = applicationServers.get(entry);
        ServiceComponentFrame serviceComponentFrame = applicationServer.getApplicationData();
        LOGGER.info("Obtained data for service - " +
            applicationId + " (" + ApplicationId.getApplicationIdForId(applicationId).name() + ")");
        if (serviceComponentFrame != null) {
          serviceComponentFrame.setSCID(entry.getServiceComponentId());
          serviceComponentFrame.setFieldLength(0); // NOTE dummy fieldlength.
          serviceComponentFrame.setScHeaderCRC(0);  // NOTE dummy Service Component Header CRC.
          serviceComponentFrames.add(serviceComponentFrame);
          broadcastNeeded = true;
        }
      }

      // broadcast the TransportFrame
      if (broadcastNeeded) {
        LOGGER.info("Going to broadcast data");
        broadcast.broadcast(transportFrame);
      } else {
        LOGGER.info("Nothing to broadcast");
      }

      try {
        sleep(1000 * 5);
      } catch (InterruptedException e) {
        // no action.
      }
    }
  }

  @Override
  public byte registerApplicationServer(byte applicationId, byte contentId, ServiceIdentifier serviceId, ApplicationServer applicationServer) {
    StringBuilder buf = new StringBuilder();
    buf.append("registering application Id: ");
    buf.append(applicationId);
    buf.append(", applicationServer = ");
    buf.append(applicationServer.getClass().getName());
    LOGGER.info(buf.toString());
    
    byte serviceComponentId = createServiceComponentId();
    if ((serviceId != null)  &&  serviceId.equals(MY_SID)) {
      // Only story serviceId's different than the 'Carrier ServiceID'.
      serviceId = null;
    }
    GuideToServiceTable1Entry entry = new GuideToServiceTable1Entry(applicationId, contentId, serviceId, serviceComponentId);
    applicationServers.put(entry, applicationServer);
    
    return serviceComponentId;
  }

  @Override
  public void unregisterApplicationServer(byte serviceComponentId) {
    for (GuideToServiceTable1Entry entry: applicationServers.keySet()) {
      if (entry.getServiceComponentId() == serviceComponentId) {
        applicationServers.remove(entry);
        break;
      }
    }
  }

  private ServiceComponentFrame getSniServiceComponentFrame() {
    ServCompFrameCountedProtected serviceComponentFrame = FACTORY.createServCompFrameCountedProtected();

    List<SniComponent> sniComponents = new BasicEList<SniComponent>();

    /*
     * Guide to the service table 1 (Fast Tuning)
     */
    SniComponentFastTuning sniComponentFastTuning = SNI_FACTORY.createSniComponentFastTuning();
    sniComponentFastTuning.setId((byte) 0x01);
    sniComponentFastTuning.setN(0);   // NOTE Length not filled in.
    sniComponentFastTuning.setTableIncrementalVersionNumber(GUIDE_TO_SERVICE_TABLE1_INC_VERSION_NUMBER);
    sniComponentFastTuning.setCharTab((byte) 0);  // NOTE No idea what this is.
    for (GuideToServiceTable1Entry entry: applicationServers.keySet()) {
      LineOfTable1 lineOfTable1 = SNI_FACTORY.createLineOfTable1();
      lineOfTable1.setServiceComponentId(entry.getServiceComponentId());
      byte selector = (byte) 0;
      if (entry.getServiceId() != null) {
        selector |= (byte) 0x01;
        lineOfTable1.setOriginatorServiceIdentifier(entry.getServiceId());
      }
      lineOfTable1.setContentId(entry.getContentId());
      lineOfTable1.setApplicationId(entry.getApplicationId());
      lineOfTable1.setSelector(selector);
      
      sniComponentFastTuning.getLinesOfTable1().add(lineOfTable1);
    }
    sniComponents.add(sniComponentFastTuning);
    
    serviceComponentFrame.setApplicationContent(sniComponents);

    serviceComponentFrame.setSCID(ApplicationId.SNI.getAid());
    serviceComponentFrame.setFieldLength(0);  // NOTE Field Length not filled in.
    serviceComponentFrame.setScHeaderCRC(0); // NOTE Service component Header CRC not filled in.
    serviceComponentFrame.setMessageCount(sniComponents.size());
    serviceComponentFrame.setApplicationContent(sniComponents);
    serviceComponentFrame.setDataCRC(0);  // NOTE Data CRC not filled in.

    LOGGER.info(serviceComponentFrame.toString());
    return serviceComponentFrame;
  }

  private byte createServiceComponentId() {
    return nextServiceComponentId++;
  }
}
