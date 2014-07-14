/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.genivi.common.RectangularArea;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;

public class AreasFilter extends Filter {
  private final static Logger LOGGER = Logger.getLogger(ExpressionFilter.class.getName());
  
  private List<RectangularArea> areas;
  
  public AreasFilter(List<RectangularArea> areas) {
    super();
    
    LOGGER.setLevel(Level.SEVERE);
    
    this.areas = areas;
  }

  @Override
  public boolean filter(EObject object) {
    LOGGER.info("=>");
    
    boolean returnValue = false;
    
    if (!(object instanceof TrafficIncident)) {
      LOGGER.info("<= Object is not a TrafficIncident" + returnValue);
      return returnValue;
    }
    
    TrafficIncident trafficIncident = (TrafficIncident) object;
    RectangularArea incidentArea = trafficIncident.getLocationBoundingBox();
    
    for (RectangularArea area: areas) {
      if (!RectangularAreaUtils.areaIsOutsideArea(area, incidentArea)) {
        returnValue = true;
        break;
      }
    }
        
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }
}
