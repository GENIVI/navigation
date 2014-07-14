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
import org.freedesktop.dbus.Struct;

public class VehicleRelatedRestrictionStruct extends Struct {
  @Position(0)
  public final Byte restrictionType;  // RestrictionType
  
  @Position(1)
  // Actually an optional value, which is represented by an array of length 0 or 1.
  public final List<Integer> restrictionValue;
  
  @Position(2)
  // Actually an optional value, which is represented by an array of length 0 or 1.
  public final List<LocationReferenceStruct> restrictionLocationReference;

  public VehicleRelatedRestrictionStruct(Byte restrictionType,
      List<Integer> restrictionValue,
      List<LocationReferenceStruct> restrictionLocationReference
      ) {
    super();
    this.restrictionType = restrictionType;
    this.restrictionValue = restrictionValue;
    this.restrictionLocationReference = restrictionLocationReference;
  }
}
