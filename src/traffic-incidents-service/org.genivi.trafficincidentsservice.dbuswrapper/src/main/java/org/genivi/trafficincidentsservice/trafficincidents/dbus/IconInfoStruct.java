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

public class IconInfoStruct extends Struct {
  @Position(0)
  public final int iconSetId;
  
  @Position(1)
  public final int iconId;

  public IconInfoStruct(int iconSetId, int iconId) {
    super();
    this.iconSetId = iconSetId;
    this.iconId = iconId;
  }
}
