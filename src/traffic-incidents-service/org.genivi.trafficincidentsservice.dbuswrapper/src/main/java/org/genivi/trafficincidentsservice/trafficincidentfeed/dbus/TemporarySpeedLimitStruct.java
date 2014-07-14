/**
 * Copyright (C) 2014 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus;

import java.util.List;

import org.freedesktop.dbus.Position;
import org.freedesktop.dbus.Struct;

public class TemporarySpeedLimitStruct extends Struct {
  @Position(0)
  public final Boolean unitsMPH;

  @Position(1)
  public final Integer offset;
  
  @Position(2)
  public final List<TemporarySpeedLimitSectionStruct> temporarySpeedLimitSections;
  
  @Position(3)
  public final List<ApplicabilityStruct> applicability;

  
  public TemporarySpeedLimitStruct(Boolean unitsMPH, Integer offset,
      List<TemporarySpeedLimitSectionStruct> temporarySpeedLimitSections,
      List<ApplicabilityStruct> applicability) {
    super();
    this.unitsMPH = unitsMPH;
    this.offset = offset;
    this.temporarySpeedLimitSections = temporarySpeedLimitSections;
    this.applicability = applicability;
  }
}
