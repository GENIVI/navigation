/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.dbus;

public enum LocationType {
  POINT((byte) 1),
  LINEAR((byte) 2),
  AREA((byte) 3);
  
  private Byte value;
  
  LocationType(Byte value) {
    this.value = value;
  }

  public Byte getValue() {
    return value;
  }
  
  public static LocationType getLocationType(Byte value) {
    for (LocationType causeType: values()) {
      if (causeType.value == value) {
        return causeType;
      }
    }
    
    return null;
  }
}
