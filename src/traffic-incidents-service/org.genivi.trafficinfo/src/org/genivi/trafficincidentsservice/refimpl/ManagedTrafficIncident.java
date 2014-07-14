/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

import java.util.Date;

import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;

public class ManagedTrafficIncident {
  private org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident xTrafficIncident;
  private TrafficIncident trafficIncident;
  private Date receivedAt;

  public ManagedTrafficIncident(
      org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident xTrafficIncident,
      TrafficIncident trafficIncident,
      Date receivedAt) {
    super();
    this.xTrafficIncident = xTrafficIncident;
    this.trafficIncident = trafficIncident;
    this.receivedAt = receivedAt;
  }
  
  public org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident getxTrafficIncident() {
    return xTrafficIncident;
  }

  public TrafficIncident getTrafficIncident() {
    return trafficIncident;
  }

  public Date getReceivedAt() {
    return receivedAt;
  }
}