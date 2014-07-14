/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus;

import org.freedesktop.dbus.Position;

public class LinkedCauseStruct extends CauseStruct {
  @Position(0)
  public final Byte mainCause;

  @Position(1)
  public final String causeTrafficIncidentId;

  public LinkedCauseStruct(Byte mainCause, String causeTrafficIncidentId) {
    super();
    this.mainCause = mainCause;
    this.causeTrafficIncidentId = causeTrafficIncidentId;
  }

}
