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

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This predicate checks whether an attribute value is in, or not in, a set of values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.InPredicate#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.InPredicate#getInOperator <em>In Operator</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.InPredicate#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.booleanexpr.FilterexprPackage#getInPredicate()
 * @model
 * @generated
 */
public interface InPredicate extends Predicate {

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
	 * @see org.genivi.booleanexpr.FilterexprPackage#getInPredicate_Attribute()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  ClassAttribute getAttribute();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.InPredicate#getAttribute <em>Attribute</em>}' containment reference.
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
	 * Unsets the value of the '{@link org.genivi.booleanexpr.InPredicate#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAttribute()
	 * @see #getAttribute()
	 * @see #setAttribute(ClassAttribute)
	 * @generated
	 */
  void unsetAttribute();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.InPredicate#getAttribute <em>Attribute</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Attribute</em>' containment reference is set.
	 * @see #unsetAttribute()
	 * @see #getAttribute()
	 * @see #setAttribute(ClassAttribute)
	 * @generated
	 */
  boolean isSetAttribute();

  /**
	 * Returns the value of the '<em><b>In Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.booleanexpr.InOperator}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>In Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.InOperator
	 * @see #isSetInOperator()
	 * @see #unsetInOperator()
	 * @see #setInOperator(InOperator)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getInPredicate_InOperator()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  InOperator getInOperator();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.InPredicate#getInOperator <em>In Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.InOperator
	 * @see #isSetInOperator()
	 * @see #unsetInOperator()
	 * @see #getInOperator()
	 * @generated
	 */
  void setInOperator(InOperator value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.InPredicate#getInOperator <em>In Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetInOperator()
	 * @see #getInOperator()
	 * @see #setInOperator(InOperator)
	 * @generated
	 */
  void unsetInOperator();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.InPredicate#getInOperator <em>In Operator</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>In Operator</em>' attribute is set.
	 * @see #unsetInOperator()
	 * @see #getInOperator()
	 * @see #setInOperator(InOperator)
	 * @generated
	 */
  boolean isSetInOperator();

  /**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.booleanexpr.Literal}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see #isSetLiterals()
	 * @see #unsetLiterals()
	 * @see org.genivi.booleanexpr.FilterexprPackage#getInPredicate_Literals()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<Literal> getLiterals();

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.InPredicate#getLiterals <em>Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLiterals()
	 * @see #getLiterals()
	 * @generated
	 */
  void unsetLiterals();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.InPredicate#getLiterals <em>Literals</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Literals</em>' containment reference list is set.
	 * @see #unsetLiterals()
	 * @see #getLiterals()
	 * @generated
	 */
  boolean isSetLiterals();
} // InPredicate
