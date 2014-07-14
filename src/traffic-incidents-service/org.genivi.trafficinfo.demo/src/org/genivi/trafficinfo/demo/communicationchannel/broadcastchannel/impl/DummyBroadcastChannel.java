/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.trafficinfo.demo.communicationchannel.broadcastchannel.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.genivi.trafficinfo.demo.communicationchannel.DataReceptionListener;
import org.genivi.trafficinfo.demo.communicationchannel.broadcastchannel.Broadcast;
import org.genivi.trafficinfo.demo.communicationchannel.broadcastchannel.BroadcastReception;


public class DummyBroadcastChannel implements Broadcast, BroadcastReception {
    private final static Logger LOGGER = Logger.getLogger(DummyBroadcastChannel.class.getName()); 
  
	private static DummyBroadcastChannel broadcastChannel = null;
	
	private List<DataReceptionListener> broadcastReceptionListeners = new ArrayList<DataReceptionListener>();

	private DummyBroadcastChannel() {
	    LOGGER.setLevel(Level.SEVERE);
	}
	
	public static DummyBroadcastChannel getInstance() {
		if (broadcastChannel == null) {
			broadcastChannel = new DummyBroadcastChannel();
		}
		
		return broadcastChannel;
	}
	
	@Override
	public void broadcast(Object data) {
	    LOGGER.info("DummyBroadcastChannel going to broadcasting data");
		for (DataReceptionListener broadcastReceptionListener: broadcastReceptionListeners) {
			broadcastReceptionListener.dataReceived(data);
		}
	}

	@Override
	public void addBroadcastReceptionListener(
			DataReceptionListener broadcastReceptionListener) {
		broadcastReceptionListeners.add(broadcastReceptionListener);
		
	    LOGGER.info("DataReceptionListenerAdded(" +
		    broadcastReceptionListener.getClass().getName() +
		    ") : number of listeners = " + broadcastReceptionListeners.size());
	}

	@Override
	public void removeBroadcastReceptionListener(
			DataReceptionListener broadcastReceptionListener) {
		broadcastReceptionListeners.remove(broadcastReceptionListener);
	}

}
