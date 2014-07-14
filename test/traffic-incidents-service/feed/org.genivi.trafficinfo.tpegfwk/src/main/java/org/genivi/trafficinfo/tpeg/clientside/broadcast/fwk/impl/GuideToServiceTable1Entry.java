/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.impl;

import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;

public class GuideToServiceTable1Entry {
  private byte applicationId;           // AID
  private byte contentId;               // COID
  private ServiceIdentifier serviceId;  // SID
  private byte serviceComponentId;      // SCID
  
  
  public GuideToServiceTable1Entry(byte applicationId, byte contentId,
      ServiceIdentifier serviceId, byte serviceComponentId) {
    super();
    this.applicationId = applicationId;
    this.contentId = contentId;
    this.serviceId = serviceId;
    this.serviceComponentId = serviceComponentId;
  }

  public byte getApplicationId() {
    return applicationId;
  }


  public byte getContentId() {
    return contentId;
  }


  public ServiceIdentifier getServiceId() {
    return serviceId;
  }


  public byte getServiceComponentId() {
    return serviceComponentId;
  }
  
  
}
