/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.trafficinfo.demo.communicationchannel.broadcastchannel;

import org.genivi.trafficinfo.demo.communicationchannel.DataReceptionListener;

public interface BroadcastReception {
    public void addBroadcastReceptionListener(DataReceptionListener broadcastReceptionListener);
    public void removeBroadcastReceptionListener(DataReceptionListener broadcastReceptionListener);
}
