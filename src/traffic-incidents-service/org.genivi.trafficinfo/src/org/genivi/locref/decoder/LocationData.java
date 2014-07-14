/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.locref.decoder;

import org.genivi.location.Location;
import org.genivi.location.LocationInfo;

public class LocationData {
  private Location location;
  private LocationInfo locationInfo;
  
  public LocationData(Location location, LocationInfo locationInfo) {
    super();
    this.location = location;
    this.locationInfo = locationInfo;
  }

  public Location getLocation() {
    return location;
  }
  
  public LocationInfo getLocationInfo() {
    return locationInfo;
  }
}
