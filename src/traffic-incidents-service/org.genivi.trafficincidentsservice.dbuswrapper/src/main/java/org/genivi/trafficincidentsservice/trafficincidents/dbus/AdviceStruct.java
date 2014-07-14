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

public class AdviceStruct extends Struct {
  @Position(0)
  public final Byte mainAdvice;  // AdviceCode
  
  @Position(1)
  public final Byte subAdvice;
  
  @Position(2)
  public final String freeText;
  
  @Position(3)
  public final List<ApplicabilityStruct> applicability;

  public AdviceStruct(Byte mainAdvice, Byte subAdvice,
      String freeText, List<ApplicabilityStruct> applicability) {
    super();
    this.mainAdvice = mainAdvice;
    this.subAdvice = subAdvice;
    this.freeText = freeText;
    this.applicability = applicability;
  }
}
