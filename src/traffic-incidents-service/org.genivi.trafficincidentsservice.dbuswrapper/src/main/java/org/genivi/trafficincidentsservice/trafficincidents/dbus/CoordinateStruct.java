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

public class CoordinateStruct extends Struct {
  @Position(0)
  public final Double latitude;
  
  @Position(1)
  public final Double longitude;
  
  @Position(2)
  public final int altitude;

  public CoordinateStruct(Double latitude, Double longitude, int altitude) {
    super();
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitude = altitude;
  }
}
