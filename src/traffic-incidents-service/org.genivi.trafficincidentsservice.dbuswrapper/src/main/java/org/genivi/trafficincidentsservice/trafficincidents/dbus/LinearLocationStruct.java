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
import org.freedesktop.dbus.UInt32;

public class LinearLocationStruct extends LocationStruct {
  @Position(0)
  public final List<Long> segments;
  
  @Position(1)
  public final UInt32 positiveOffset;
  
  @Position(2)
  public final UInt32 negativeOffset;

  public LinearLocationStruct(List<Long> segments, UInt32 positiveOffset,
      UInt32 negativeOffset) {
    super();
    this.segments = segments;
    this.positiveOffset = positiveOffset;
    this.negativeOffset = negativeOffset;
  }

}
