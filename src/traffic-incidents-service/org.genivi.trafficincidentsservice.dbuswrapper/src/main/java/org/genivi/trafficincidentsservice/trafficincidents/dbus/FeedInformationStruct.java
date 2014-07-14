/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.dbus;

import org.freedesktop.dbus.Position;
import org.freedesktop.dbus.Struct;

public class FeedInformationStruct extends Struct {
  @Position(0)
  public final String dataProviderName;
  
  @Position(1)
  public final String protocolName;
  
  @Position(2)
  public final String communicationChannelName;
  
  @Position(3)
  public final Byte feedStatus;
  
  @Position(4)
  public final Byte trafficIncidentsStatus;

  public FeedInformationStruct(String dataProviderName, String protocolName,
      String communicationChannelName,
      Byte feedStatus,
      Byte trafficIncidentsStatus) {
    super();
    this.dataProviderName = dataProviderName;
    this.protocolName = protocolName;
    this.communicationChannelName = communicationChannelName;
    this.feedStatus = feedStatus;
    this.trafficIncidentsStatus = trafficIncidentsStatus;
  }
}
