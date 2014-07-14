/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus;

import org.freedesktop.dbus.Position;
import org.freedesktop.dbus.Struct;
import org.freedesktop.dbus.Variant;

public class CauseDiscriminatedVariant extends Struct {
  @Position(0)
  public final Byte causeType;
  
  @Position(1)
  public final Variant<? extends CauseStruct> cause;
  
  public CauseDiscriminatedVariant(
      Byte causeType,
      Variant<? extends CauseStruct> cause
      ) {
    super();
    this.causeType = causeType;
    this.cause = cause;
  }
}
