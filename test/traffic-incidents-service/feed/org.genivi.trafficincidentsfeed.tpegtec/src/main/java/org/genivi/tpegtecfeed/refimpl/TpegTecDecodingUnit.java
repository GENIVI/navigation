/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.tpegtecfeed.refimpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.TpegDecodingUnit;
import org.genivi.trafficinfo.tpeg.tec.event.TECMessage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;


public class TpegTecDecodingUnit implements TpegDecodingUnit {    
    private final static Logger LOGGER = Logger.getLogger(TpegTecDecodingUnit.class.getName()); 
  
    private TpegTecMessageHandler tpegTecMessageHandler;
	

	public TpegTecDecodingUnit(TpegTecMessageHandler tpegTecMessageHandler) {
	    LOGGER.setLevel(Level.SEVERE);
	    
		this.tpegTecMessageHandler = tpegTecMessageHandler;
	}

	@Override
	public void handleServiceComponentFrame(long channelId, String communicationChannelName, ServiceIdentifier originatorSID, byte COID, Object object) {
	  LOGGER.info("Received Service Component Frame");
		
		ServCompFramePrioritisedCountedProtected serviceComponentFrame = (ServCompFramePrioritisedCountedProtected) object;
		serviceComponentFrame.getDataCRC();  // NOTE nothing done with data CRC
		serviceComponentFrame.getFieldLength();  // NOTE nothing done with fieldLength
		serviceComponentFrame.getGroupPriority(); // NOTE nothing done with groupPriority
		serviceComponentFrame.getMessageCount();  // NOTE nothing done with messageCount
		serviceComponentFrame.getScHeaderCRC();   // NOTE nothing done with header CRC
		serviceComponentFrame.getSCID(); // NOTE nothing done with SCID
		@SuppressWarnings("unchecked")
		List<TECMessage> tecMessages = (List<TECMessage>) serviceComponentFrame.getApplicationContent();
        tpegTecMessageHandler.handleMessagesStart(channelId, communicationChannelName, originatorSID, COID);
        
        for (TECMessage tecMessage: tecMessages) {
          tpegTecMessageHandler.handleMessage(tecMessage);          
        }
        
        tpegTecMessageHandler.handleMessagesEnd();
				
        LOGGER.info("<=");
	}
}
