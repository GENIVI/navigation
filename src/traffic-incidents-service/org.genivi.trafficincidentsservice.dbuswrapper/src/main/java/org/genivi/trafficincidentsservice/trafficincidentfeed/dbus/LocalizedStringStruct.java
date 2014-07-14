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

public class LocalizedStringStruct extends Struct {
  @Position(0)
  public final String languageCode;
  
  @Position(1)
  public final String countryCode;
  
  @Position(2)
  public final String string;

  public LocalizedStringStruct(String languageCode, String countryCode,
      String string) {
    super();
    this.languageCode = languageCode;
    this.countryCode = countryCode;
    this.string = string;
  }
}
