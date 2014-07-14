/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

import org.genivi.common.RectangularArea;


public class RectangularAreaUtils {

  /**
   * Determine if one area (area2) is completely outside of another area (area1).
   * 
   * @param area1
   * @param area2 
   * @return true if area2 is completely outside of area1.
   */
  public static boolean areaIsOutsideArea(RectangularArea rectangle1, RectangularArea rectangle2) {
      boolean leftOfOne =
              rectangle2.getTopRight().getLongitude() < rectangle1.getBottomLeft().getLongitude();
      boolean rightOfOne =
              rectangle2.getBottomLeft().getLongitude() > rectangle1.getTopRight().getLongitude();
      boolean aboveOne =
              rectangle2.getBottomLeft().getLatitude() > rectangle1.getTopRight().getLatitude();
      boolean belowOne =
              rectangle2.getTopRight().getLatitude() < rectangle1.getBottomLeft().getLatitude();
      return (leftOfOne || rightOfOne || aboveOne || belowOne);
  }

}
