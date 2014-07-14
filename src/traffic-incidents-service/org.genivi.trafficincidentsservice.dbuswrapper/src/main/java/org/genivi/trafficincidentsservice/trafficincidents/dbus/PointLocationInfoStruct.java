/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.dbus;

import java.util.List;

import org.freedesktop.dbus.Position;

public class PointLocationInfoStruct extends LocationInfoStruct {
  @Position(0)
  public final String name;
  
  @Position(1)
  // Actually an optional value, which is represented by an array of length 0 or 1.
  public final List<CoordinateStruct> mainLocation;

  @Position(2)
  public final int locationType;  // PointLocationType

  public PointLocationInfoStruct(String name, List<CoordinateStruct> mainLocation,
      int locationType) {
    super();
    this.name = name;
    this.mainLocation = mainLocation;
    this.locationType = locationType;
  }
}
