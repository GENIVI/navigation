/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

import org.eclipse.emf.common.util.EList;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.DownCastPredicate;
import org.genivi.booleanexpr.FilterexprFactory;
import org.genivi.booleanexpr.InOperator;
import org.genivi.booleanexpr.InPredicate;
import org.genivi.booleanexpr.ListOperator;
import org.genivi.booleanexpr.Literal;
import org.genivi.booleanexpr.MultiplicityPredicate;
import org.genivi.booleanexpr.SignedIntegerLiteral;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;

public class TrafficIncidentFilterUtils {
  private final static FilterexprFactory FILTER_EXPR_FACTORY = FilterexprFactory.eINSTANCE;
  private final static trafficincidentPackage TRAFFIC_INCIDENT_PACKAGE = trafficincidentPackage.eINSTANCE;

  public static Filter createWarningLevelFilter(EList<WarningLevel> warningLevels) {

    // In Predicate: warningLevel IN warningLevels
    InPredicate warningLevelAttributeCheck = FILTER_EXPR_FACTORY.createInPredicate();
    ClassAttribute warningLevelAttribute = FILTER_EXPR_FACTORY.createClassAttribute();
    warningLevelAttribute.setAttributeName(TRAFFIC_INCIDENT_PACKAGE.getDirectCause_WarningLevel().getName());
    warningLevelAttributeCheck.setAttribute(warningLevelAttribute);
    warningLevelAttributeCheck.setInOperator(InOperator.IN);
    EList<Literal> literals = warningLevelAttributeCheck.getLiterals();
    for (WarningLevel warningLevel: warningLevels) {
      SignedIntegerLiteral warningLevelEnumValue = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
      warningLevelEnumValue.setValue(warningLevel.getValue());
      literals.add(warningLevelEnumValue);
    }
          
    // Downcast: to DirectCause where (warningLevel IN warningLevels)
    DownCastPredicate directCauseDownCast = FILTER_EXPR_FACTORY.createDownCastPredicate();
    directCauseDownCast.setClassName(TRAFFIC_INCIDENT_PACKAGE.getDirectCause().getName());
    directCauseDownCast.setExpression(warningLevelAttributeCheck);
    
    // Subclass Predicate: ANY cause instanceof DirectCause where (warningLevel IN warningLevels)
    MultiplicityPredicate anyCausePredicate = FILTER_EXPR_FACTORY.createMultiplicityPredicate();
    anyCausePredicate.setListOperator(ListOperator.ANY);
    ClassAttribute causes = FILTER_EXPR_FACTORY.createClassAttribute();
    causes.setAttributeName(TRAFFIC_INCIDENT_PACKAGE.getTrafficIncident_Causes().getName());
    anyCausePredicate.setAttribute(causes);
    anyCausePredicate.setExpression(directCauseDownCast);
//    System.out.println(anyCausePredicate.toString());
    
    Filter filter = new ExpressionFilter(anyCausePredicate);
    
    return filter;
  }

  public static Filter createCategoryIdsFilter(EList<Integer> categoryIds) {
    // In Predicate: categoryId IN categoryIds
    InPredicate categoryIdCheck = FILTER_EXPR_FACTORY.createInPredicate();
    categoryIdCheck.setInOperator(InOperator.IN);
    EList<Literal> literals = categoryIdCheck.getLiterals();
    for (Integer categoryId: categoryIds) {
      SignedIntegerLiteral categoryIdLiteral = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
      categoryIdLiteral.setValue(categoryId);
      literals.add(categoryIdLiteral);
    }

    // Multiplicity Predicate: ANY categoryId where (categoryId IN categoryIds)
    MultiplicityPredicate anyCategoryIdPredicate = FILTER_EXPR_FACTORY.createMultiplicityPredicate();
    anyCategoryIdPredicate.setListOperator(ListOperator.ANY);
    ClassAttribute categoryIdsAttribute = FILTER_EXPR_FACTORY.createClassAttribute();
    categoryIdsAttribute.setAttributeName(TRAFFIC_INCIDENT_PACKAGE.getTrafficIncident_CategoryIds().getName());
    anyCategoryIdPredicate.setAttribute(categoryIdsAttribute);
    anyCategoryIdPredicate.setExpression(categoryIdCheck);
        
//    System.out.println(anyCategoryIdPredicate.toString());
    Filter filter = new ExpressionFilter(anyCategoryIdPredicate);
    
    return filter;
  }
}
