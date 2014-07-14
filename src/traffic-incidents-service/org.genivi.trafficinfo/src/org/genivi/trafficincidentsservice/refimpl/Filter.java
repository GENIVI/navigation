/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public abstract class Filter {
  private final static Logger LOGGER = Logger.getLogger(Filter.class.getName()); 
  
  public Filter() {
    LOGGER.setLevel(Level.SEVERE);    
  }
  
  public abstract boolean filter(EObject object);

  public static EList<EObject> applyFilters(Collection<? extends EObject> values, EList<Filter> filters) {
    EList<EObject> filteredList = new BasicEList<EObject>(values);
    for (Filter filter: filters) {
      filteredList = applyAcceptFilter(filteredList, filter);
    }
    return filteredList;
  }

  public static <T extends EObject> EList<T> applyAcceptFilter(Collection<T> values, Filter filter) {
    LOGGER.info("=>");
    EList<T> filteredList = new BasicEList<T>();
    
    for (T object: values) {
      if (filter.filter(object)) {
        LOGGER.info("Adding object to filteredList: " + object);
        filteredList.add(object);
      } else {
        LOGGER.info("Object NOT added to filteredList: " + object);
      }
    }
    
    LOGGER.info("<=");
    return filteredList;
  }

  public static <T extends EObject> EList<T> applyRejectFilter(Collection<T> values, Filter filter) {
    LOGGER.info("=>");
    EList<T> filteredList = new BasicEList<T>();
    
    for (T object: values) {
      if (!filter.filter(object)) {
        LOGGER.info("Adding object to filteredList: " + object);
        filteredList.add(object);
      } else {
        LOGGER.info("Object NOT added to filteredList: " + object);
      }
    }
    
    return filteredList;
  }
}
