/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.tpegtecfeed.refimpl;

import org.genivi.trafficinfo.tpeg.tec.event.TECMessage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;


public interface TpegTecMessageHandler {

  public void languageChanged(String languageCode, String countryCode);
  
  public void handleMessagesStart(long channelId, String communicationChannelName, ServiceIdentifier originatorSID, byte COID);
  
  public void handleMessage(TECMessage tecMessage);
  
  public void handleMessagesEnd();
}
