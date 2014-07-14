/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.genivi.common.RectangularArea;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;


public class UpdateListenerInfo {
  private Filter                   severitiesFilter = null;
  private Filter                   categoriesFilter = null;
  private Filter                   areasFilter = null;
  private Date                     updateTime = null;
  private List<Integer>            incidentIdsToListener = null;
  
  public UpdateListenerInfo(
      EList<WarningLevel> severities,
      EList<Integer> categoryIds,
      EList<RectangularArea> areas) {
    
    if (!severities.isEmpty()) {
      severitiesFilter = TrafficIncidentFilterUtils.createWarningLevelFilter(severities);
    }
    
    if (!categoryIds.isEmpty()) {
      categoriesFilter = TrafficIncidentFilterUtils.createCategoryIdsFilter(categoryIds);
    }
    
    if (!areas.isEmpty()) {
      areasFilter = new AreasFilter(areas);
    }
  }

  public List<Integer> getIncidentIdsToListener() {
    return incidentIdsToListener;
  }

  public void setIncidentIdsToListener(List<Integer> incidentIdsToListener) {
    this.incidentIdsToListener = incidentIdsToListener;
  }

  public Filter getSeveritiesFilter() {
    return severitiesFilter;
  }

  public Filter getCategoriesFilter() {
    return categoriesFilter;
  }

  public Filter getAreasFilter() {
    return areasFilter;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}