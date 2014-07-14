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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comparison Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This predicate compares the value of an attribute of a class to a literal value (a constant).
 * For example "myAttribute == 22".
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.ComparisonPredicate#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.ComparisonPredicate#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.ComparisonPredicate#getComparisonOperator <em>Comparison Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.booleanexpr.FilterexprPackage#getComparisonPredicate()
 * @model
 * @generated
 */
public interface ComparisonPredicate extends Predicate {
  /**
	 * Returns the value of the '<em><b>Comparison Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.booleanexpr.ComparisonOperator}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comparison Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparison Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.ComparisonOperator
	 * @see #setComparisonOperator(ComparisonOperator)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getComparisonPredicate_ComparisonOperator()
	 * @model required="true"
	 * @generated
	 */
  ComparisonOperator getComparisonOperator();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.ComparisonPredicate#getComparisonOperator <em>Comparison Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comparison Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.ComparisonOperator
	 * @see #getComparisonOperator()
	 * @generated
	 */
  void setComparisonOperator(ComparisonOperator value);

  /**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' containment reference.
	 * @see #setLiteral(Literal)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getComparisonPredicate_Literal()
	 * @model containment="true" required="true"
	 * @generated
	 */
  Literal getLiteral();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.ComparisonPredicate#getLiteral <em>Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' containment reference.
	 * @see #getLiteral()
	 * @generated
	 */
  void setLiteral(Literal value);

  /**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference.
	 * @see #setAttribute(ClassAttribute)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getComparisonPredicate_Attribute()
	 * @model containment="true" required="true"
	 * @generated
	 */
  ClassAttribute getAttribute();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.ComparisonPredicate#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' containment reference.
	 * @see #getAttribute()
	 * @generated
	 */
  void setAttribute(ClassAttribute value);

} // ComparisonPredicate
