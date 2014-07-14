/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.genivi.booleanexpr.BooleanExpression;

public class ExpressionFilter extends Filter {
  private final static Logger LOGGER = Logger.getLogger(ExpressionFilter.class.getName());
  
  private BooleanExpression expression;
  
  public ExpressionFilter(BooleanExpression expression) {
    super();
    
    LOGGER.setLevel(Level.SEVERE);
    
    this.expression = expression;
  }

  @Override
  public boolean filter(EObject object) {
    LOGGER.info("=> Object = " + object.toString());
    LOGGER.info("=> FilterExpression = " + expression.toString());
    
    boolean returnValue = expression.evaluate(object);
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }

  public BooleanExpression getExpression() {
    return expression;
  }

}
