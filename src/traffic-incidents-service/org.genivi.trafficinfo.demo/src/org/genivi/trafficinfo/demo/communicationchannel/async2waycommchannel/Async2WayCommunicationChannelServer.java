/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.trafficinfo.demo.communicationchannel.async2waycommchannel;


public interface Async2WayCommunicationChannelServer {
	public void sendResponse(long messageId, Object data);

	public void addRequestListener(String address, Async2WayCommunicationChannelDataReceptionListener requestListener);
	
    public void removeRequestListener(String address);
    
    public void removeRequestListener(Async2WayCommunicationChannelDataReceptionListener requestListener);
}
