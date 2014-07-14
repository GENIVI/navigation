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
import org.freedesktop.dbus.Struct;

public class ApplicabilityStruct extends Struct {
  @Position(0)
  public final Byte vehicleType;   // VehicleType
  
  @Position(1)
  public final List<VehicleRelatedRestrictionStruct> vehicleRelatedRestrictions;

  public ApplicabilityStruct(Byte vehicleType,
      List<VehicleRelatedRestrictionStruct> vehicleRelatedRestrictions) {
    super();
    this.vehicleType = vehicleType;
    this.vehicleRelatedRestrictions = vehicleRelatedRestrictions;
  }
}
