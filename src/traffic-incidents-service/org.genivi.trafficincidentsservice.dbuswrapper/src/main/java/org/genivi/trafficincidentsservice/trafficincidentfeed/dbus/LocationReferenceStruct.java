/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus;

import org.freedesktop.dbus.Position;
import org.freedesktop.dbus.Struct;

public class LocationReferenceStruct extends Struct {
  @Position(0)
  public final Byte locationReferenceType;
  
  @Position(1)
  public final byte[] data;
  
  public LocationReferenceStruct(Byte locationReferenceType, byte[] data) {
    super();
    this.locationReferenceType = locationReferenceType;
    this.data = data;
  }
}
