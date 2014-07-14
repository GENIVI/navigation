/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.booleanexpr;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.booleanexpr.FilterexprPackage
 * @generated
 */
public interface FilterexprFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  FilterexprFactory eINSTANCE = org.genivi.booleanexpr.impl.FilterexprFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Expression</em>'.
	 * @generated
	 */
  UnaryExpression createUnaryExpression();

  /**
	 * Returns a new object of class '<em>Dyadic Expression</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dyadic Expression</em>'.
	 * @generated
	 */
  DyadicExpression createDyadicExpression();

  /**
	 * Returns a new object of class '<em>Comparison Predicate</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comparison Predicate</em>'.
	 * @generated
	 */
  ComparisonPredicate createComparisonPredicate();

  /**
	 * Returns a new object of class '<em>In Predicate</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Predicate</em>'.
	 * @generated
	 */
  InPredicate createInPredicate();

  /**
	 * Returns a new object of class '<em>Signed Integer Literal</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signed Integer Literal</em>'.
	 * @generated
	 */
  SignedIntegerLiteral createSignedIntegerLiteral();

  /**
	 * Returns a new object of class '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal</em>'.
	 * @generated
	 */
  StringLiteral createStringLiteral();

  /**
	 * Returns a new object of class '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal</em>'.
	 * @generated
	 */
  BooleanLiteral createBooleanLiteral();

  /**
	 * Returns a new object of class '<em>Sub Class Predicate</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Class Predicate</em>'.
	 * @generated
	 */
  SubClassPredicate createSubClassPredicate();

  /**
	 * Returns a new object of class '<em>Class Attribute</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Attribute</em>'.
	 * @generated
	 */
  ClassAttribute createClassAttribute();

  /**
	 * Returns a new object of class '<em>Down Cast Predicate</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Down Cast Predicate</em>'.
	 * @generated
	 */
  DownCastPredicate createDownCastPredicate();

  /**
	 * Returns a new object of class '<em>Multiplicity Predicate</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicity Predicate</em>'.
	 * @generated
	 */
  MultiplicityPredicate createMultiplicityPredicate();

  /**
	 * Returns a new object of class '<em>Is Set Predicate</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Set Predicate</em>'.
	 * @generated
	 */
  IsSetPredicate createIsSetPredicate();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  FilterexprPackage getFilterexprPackage();

} //FilterexprFactory
