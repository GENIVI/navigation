/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.trafficinfo.demo.communicationchannel.async2waycommchannel.impl;

import java.util.HashMap;
import java.util.Map;

import org.genivi.trafficinfo.demo.communicationchannel.async2waycommchannel.Async2WayCommunicationChannelClient;
import org.genivi.trafficinfo.demo.communicationchannel.async2waycommchannel.Async2WayCommunicationChannelDataReceptionListener;
import org.genivi.trafficinfo.demo.communicationchannel.async2waycommchannel.Async2WayCommunicationChannelServer;


public class DummyAsyn2WayCommunicationChannel implements Async2WayCommunicationChannelClient, Async2WayCommunicationChannelServer {
  private static DummyAsyn2WayCommunicationChannel broadcastChannel = null;

  private Map<String, Async2WayCommunicationChannelDataReceptionListener> requestListeners =
      new HashMap<String, Async2WayCommunicationChannelDataReceptionListener>();
  private Map<Long, Async2WayCommunicationChannelDataReceptionListener> openRequests =
      new HashMap<Long, Async2WayCommunicationChannelDataReceptionListener>();
  private long nextMessageId = 1l;

  public static DummyAsyn2WayCommunicationChannel getInstance() {
    if (broadcastChannel == null) {
      broadcastChannel = new DummyAsyn2WayCommunicationChannel();
    }

    return broadcastChannel;
  }

  @Override
  public void addRequestListener(String address, Async2WayCommunicationChannelDataReceptionListener requestListener) {
    requestListeners.put(address, requestListener);
  }
  
  public void removeRequestListener(String address) {
    requestListeners.remove(address);
  }
  
  public void removeRequestListener(Async2WayCommunicationChannelDataReceptionListener requestListener) {
    for (String address: requestListeners.keySet()) {
      if (requestListeners.get(address).equals(requestListener)) {
        requestListeners.remove(address);
      }
    }
  }

  @Override
  public long sendRequest(String address, Object data, Async2WayCommunicationChannelDataReceptionListener responseListener) {
    Async2WayCommunicationChannelDataReceptionListener requestListener = getRequestListenerForAddress(address);
    if (requestListener == null) {
      throw new RuntimeException("No request listener for request sent to address: " + address);
    }
    long messageId = generateMessageId();
    openRequests.put(messageId, responseListener);
    requestListener.dataReceived(messageId, data);
    System.out.println("DummyAsyn2WayCommunicationChannel: sending request");
    
    return messageId;
  }


  @Override
  public void sendResponse(long messageId, Object data) {
    System.out.println("DummyAsyn2WayCommunicationChannel: sending response");
    Async2WayCommunicationChannelDataReceptionListener dataReceptionListener = openRequests.remove(messageId);
    dataReceptionListener.dataReceived(messageId, data);
  }

  private long generateMessageId() {
    return nextMessageId++;
  }

  private Async2WayCommunicationChannelDataReceptionListener getRequestListenerForAddress(String address) {
    return requestListeners.get(address);
  }
}
