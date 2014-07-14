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
import org.freedesktop.dbus.UInt16;

public class VersionStruct extends Struct {
  @Position(0)
  public final UInt16 major;
  
  @Position(1)
  public final UInt16 minor;
  
  @Position(2)
  public final UInt16 micro;
  
  @Position(3)
  public final String date;

  public VersionStruct(UInt16 major, UInt16 minor, UInt16 micro, String date) {
    super();
    this.major = major;
    this.minor = minor;
    this.micro = micro;
    this.date = date;
  }

}
