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

public class IconSetStruct extends Struct {
  @Position(0)
  public final Integer iconSetId;
  
  @Position(1)
  public final Byte colorType;  // ColorType
  
  @Position(2)
  public final Byte dimension;  // IconDimension
  
  @Position(3)
  // Actually an optional value, which is represented by an array of length 0 or 1.
  public final IconSizeStruct[] size;  
  
  @Position(4)
  public final Boolean dayTimeIcon;
  
  @Position(5)
  public final Integer themeId;
  
  @Position(6)
  public final String mediumType;
  
  @Position(7)
  public final IconDescriptorStruct[] iconDescriptors;

  public IconSetStruct(int iconSetId, byte colorType, byte dimension,
      IconSizeStruct[] size, Boolean dayTimeIcon, int themeId, String mediumType,
      IconDescriptorStruct[] iconDescriptors) {
    super();
    this.iconSetId = iconSetId;
    this.colorType = colorType;
    this.dimension = dimension;
    this.size = size;
    this.dayTimeIcon = dayTimeIcon;
    this.themeId = themeId;
    this.mediumType = mediumType;
    this.iconDescriptors = iconDescriptors;
  }
}
