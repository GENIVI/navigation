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
import org.freedesktop.dbus.Variant;

public class LocationDiscriminatedVariant extends Struct {
  @Position(0)
  public final Byte locationType;
  
  @Position(1)
  public final Variant<? extends LocationStruct> location;
  
  
  public LocationDiscriminatedVariant(
      Byte locationType,
      Variant<? extends LocationStruct> location
      ) {
    super();
    this.locationType = locationType;
    this.location = location;
  }
}
