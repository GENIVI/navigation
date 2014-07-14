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


public interface Async2WayCommunicationChannelClient {
	public long sendRequest(String address, Object data, Async2WayCommunicationChannelDataReceptionListener responseListener);

}