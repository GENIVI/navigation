/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.serverside.broadcast.app.fwk;

import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame;


public interface ApplicationServer {
  public ServiceComponentFrame getApplicationData();
  
  public void stopServer();
}
