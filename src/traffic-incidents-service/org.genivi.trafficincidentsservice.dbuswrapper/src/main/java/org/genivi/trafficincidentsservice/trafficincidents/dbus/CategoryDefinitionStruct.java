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

public class CategoryDefinitionStruct extends Struct {
  @Position(0)
  public final List<LocalizedStringStruct> localizedNames;
  
  @Position(1)
  public final int categoryId;
  
  @Position(2)
  public final List<IconInfoStruct> icons;
  
  @Position(3)
  public final String expression;

  public CategoryDefinitionStruct(
      List<LocalizedStringStruct> localizedNames,
      int categoryId,
      List<IconInfoStruct> icons,
      String expression) {
    super();
    this.localizedNames = localizedNames;
    this.categoryId = categoryId;
    this.icons = icons;
    this.expression = expression;
  }
}
