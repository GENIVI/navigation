/**
 * Copyright (C) 2014 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus;

import org.freedesktop.dbus.Position;
import org.freedesktop.dbus.Struct;

public class TemporarySpeedLimitSectionStruct extends Struct {
  @Position(0)
  public final Short speedLimitValue;

  @Position(1)
  public final Short speedLimitValueWet;

  @Position(2)
  public final Integer speedLimitLength;

  
  public TemporarySpeedLimitSectionStruct(Short speedLimitValue,
      Short speedLimitValueWet, Integer speedLimitLength) {
    super();
    this.speedLimitValue = speedLimitValue;
    this.speedLimitValueWet = speedLimitValueWet;
    this.speedLimitLength = speedLimitLength;
  }

}
