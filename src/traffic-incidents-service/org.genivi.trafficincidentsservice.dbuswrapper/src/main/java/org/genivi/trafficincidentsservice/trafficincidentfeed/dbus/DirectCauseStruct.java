/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus;

import java.util.List;

import org.freedesktop.dbus.Position;

public class DirectCauseStruct extends CauseStruct {
  @Position(0)
  public final Byte mainCause;

  @Position(1)
  public final Byte warningLevel;
  
  @Position(2)
  public final Boolean unverifiedInformation;
  
  @Position(3)
  public final Byte subCause;
  
  @Position(4)
  public final Integer lengthAffected;
  
  @Position(5)
  public final Integer causeOffset;
  
  @Position(6)
  // Actually an optional value, which is represented by an array of length 0 or 1.
  public final List<LaneRestrictionsStruct> laneRestrictions;
  
  @Position(7)
  public final List<LocalizedStringStruct> freeText;

  public DirectCauseStruct(Byte mainCause, Byte warningLevel,
      Boolean unverifiedInformation, Byte subCause, Integer lengthAffected, Integer causeOffset,
      List<LaneRestrictionsStruct> laneRestrictions, List<LocalizedStringStruct> freeText) {
    super();
    this.mainCause = mainCause;
    this.warningLevel = warningLevel;
    this.unverifiedInformation = unverifiedInformation;
    this.subCause = subCause;
    this.lengthAffected = lengthAffected;
    this.causeOffset = causeOffset;
    this.laneRestrictions = laneRestrictions;
    this.freeText = freeText;
  }

}
