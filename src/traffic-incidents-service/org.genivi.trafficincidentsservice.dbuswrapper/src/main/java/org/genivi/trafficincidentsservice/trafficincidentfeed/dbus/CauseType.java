/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus;

public enum CauseType {
  DIRECT((byte) 1),
  LINKED((byte) 2);
  
  private Byte value;
  
  CauseType(Byte value) {
    this.value = value;
  }

  public Byte getValue() {
    return value;
  }
  
  public static CauseType getCauseType(Byte value) {
    for (CauseType causeType: values()) {
      if (causeType.value == value) {
        return causeType;
      }
    }
    
    return null;
  }
}
