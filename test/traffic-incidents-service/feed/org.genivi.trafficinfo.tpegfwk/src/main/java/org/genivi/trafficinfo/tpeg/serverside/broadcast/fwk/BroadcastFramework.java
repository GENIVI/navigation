/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.serverside.broadcast.fwk;

import org.genivi.trafficinfo.tpeg.serverside.broadcast.app.fwk.ApplicationServer;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;



/**
 * This interface is used by the server side applications.
 */
public interface BroadcastFramework {

  /**
   * Register an application server
   * @param applicationId The kind of application
   * @param contentId The content identifier (unclear what this is)
   * @param serviceId An optional service identifier.
   * @param applicationServer The implementing class.
   * @return The serviceComponentId assigned to this application server.
   */
  public abstract byte registerApplicationServer(byte applicationId, byte contentId, ServiceIdentifier serviceId, ApplicationServer applicationServer);

  /**
   * Unregister an application server.
   * @param serviceComponentId The serviceComponentId that was assigned during registration.
   */
  public abstract void unregisterApplicationServer(byte serviceComponentId);
}
