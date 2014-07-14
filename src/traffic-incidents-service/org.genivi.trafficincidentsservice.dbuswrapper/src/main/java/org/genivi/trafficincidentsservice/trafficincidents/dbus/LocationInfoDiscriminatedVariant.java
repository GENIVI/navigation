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

public class LocationInfoDiscriminatedVariant extends Struct {
  public static final Byte LOCATION_INFO_TYPE_POINT = 1;
  public static final Byte LOCATION_INFO_TYPE_LINEAR = 2;
  public static final Byte LOCATION_INFO_TYPE_AREA = 3;
  
  @Position(0)
  public final Byte locationInfoType;
  
  @Position(1)
  public final Variant<? extends LocationInfoStruct> locationInfo;
  
  
  public LocationInfoDiscriminatedVariant(
      Byte locationInfoType,
      Variant<? extends LocationInfoStruct> locationInfo
      ) {
    super();
    this.locationInfoType = locationInfoType;
    this.locationInfo = locationInfo;
  }
}
