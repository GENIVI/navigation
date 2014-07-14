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
 * A representation of the model object '<em><b>Multiplicity Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.MultiplicityPredicate#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.MultiplicityPredicate#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.MultiplicityPredicate#getListOperator <em>List Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.booleanexpr.FilterexprPackage#getMultiplicityPredicate()
 * @model
 * @generated
 */
public interface MultiplicityPredicate extends Predicate {
  /**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #setExpression(BooleanExpression)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getMultiplicityPredicate_Expression()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  BooleanExpression getExpression();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.MultiplicityPredicate#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @generated
	 */
  void setExpression(BooleanExpression value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.MultiplicityPredicate#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetExpression()
	 * @see #getExpression()
	 * @see #setExpression(BooleanExpression)
	 * @generated
	 */
  void unsetExpression();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.MultiplicityPredicate#getExpression <em>Expression</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expression</em>' containment reference is set.
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @see #setExpression(BooleanExpression)
	 * @generated
	 */
  boolean isSetExpression();

  /**
	 * Returns the value of the '<em><b>List Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.booleanexpr.ListOperator}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>List Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>List Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.ListOperator
	 * @see #isSetListOperator()
	 * @see #unsetListOperator()
	 * @see #setListOperator(ListOperator)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getMultiplicityPredicate_ListOperator()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  ListOperator getListOperator();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.MultiplicityPredicate#getListOperator <em>List Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.ListOperator
	 * @see #isSetListOperator()
	 * @see #unsetListOperator()
	 * @see #getListOperator()
	 * @generated
	 */
  void setListOperator(ListOperator value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.MultiplicityPredicate#getListOperator <em>List Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetListOperator()
	 * @see #getListOperator()
	 * @see #setListOperator(ListOperator)
	 * @generated
	 */
  void unsetListOperator();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.MultiplicityPredicate#getListOperator <em>List Operator</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>List Operator</em>' attribute is set.
	 * @see #unsetListOperator()
	 * @see #getListOperator()
	 * @see #setListOperator(ListOperator)
	 * @generated
	 */
  boolean isSetListOperator();

  /**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference.
	 * @see #isSetAttribute()
	 * @see #unsetAttribute()
	 * @see #setAttribute(ClassAttribute)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getMultiplicityPredicate_Attribute()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  ClassAttribute getAttribute();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.MultiplicityPredicate#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' containment reference.
	 * @see #isSetAttribute()
	 * @see #unsetAttribute()
	 * @see #getAttribute()
	 * @generated
	 */
  void setAttribute(ClassAttribute value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.MultiplicityPredicate#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAttribute()
	 * @see #getAttribute()
	 * @see #setAttribute(ClassAttribute)
	 * @generated
	 */
  void unsetAttribute();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.MultiplicityPredicate#getAttribute <em>Attribute</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Attribute</em>' containment reference is set.
	 * @see #unsetAttribute()
	 * @see #getAttribute()
	 * @see #setAttribute(ClassAttribute)
	 * @generated
	 */
  boolean isSetAttribute();

} // MultiplicityPredicate
