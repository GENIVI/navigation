/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.clientside.broadcastadaptionlayer.refimpl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.genivi.trafficinfo.demo.communicationchannel.DataReceptionListener;
import org.genivi.trafficinfo.demo.communicationchannel.broadcastchannel.BroadcastReception;
import org.genivi.trafficinfo.demo.communicationchannel.broadcastchannel.impl.DummyBroadcastChannel;
import org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.TpegSfwAdaptationLayers;

public class BroadcastAdaptationLayerImplementation implements DataReceptionListener {
  private final static Logger LOGGER = Logger.getLogger(BroadcastAdaptationLayerImplementation.class.getName()); 
  
  private TpegSfwAdaptationLayers tpegSfwAdaptationLayers;
  private long channelId;
  
  // Broadcast specific attributes.
  private BroadcastReception broadcastReception;
  

  public BroadcastAdaptationLayerImplementation(String communicationChannelName, TpegSfwAdaptationLayers tpegSfwAdaptationLayers) {
    LOGGER.setLevel(Level.SEVERE);
    LOGGER.info("Creating BroadcastAdaptationLayer");
    this.tpegSfwAdaptationLayers = tpegSfwAdaptationLayers;
    
    channelId  = tpegSfwAdaptationLayers.registerAdaptationLayer(this, communicationChannelName);
    
    broadcastReception = DummyBroadcastChannel.getInstance();
    broadcastReception.addBroadcastReceptionListener(this);
  }


  @Override
  public void dataReceived(Object data) {
    LOGGER.info("Data received.");
    
    tpegSfwAdaptationLayers.transportFrameReceived(channelId, data);
  }


}
