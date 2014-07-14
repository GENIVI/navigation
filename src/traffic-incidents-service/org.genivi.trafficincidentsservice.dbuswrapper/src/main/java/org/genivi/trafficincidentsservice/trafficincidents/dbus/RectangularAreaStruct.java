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

public class RectangularAreaStruct extends Struct {
  @Position(0)
  public final CoordinateStruct bottomLeft;
  
  @Position(1)
  public final CoordinateStruct topRight;

  public RectangularAreaStruct(CoordinateStruct bottomLeft,
      CoordinateStruct topRight) {
    super();
    this.bottomLeft = bottomLeft;
    this.topRight = topRight;
  }
}
