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
 * A representation of the model object '<em><b>Sub Class Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This predicate is used to evaluate an expression on a subclass of the current class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.SubClassPredicate#getSubClassExpression <em>Sub Class Expression</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.SubClassPredicate#getSubClassAttribute <em>Sub Class Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.booleanexpr.FilterexprPackage#getSubClassPredicate()
 * @model
 * @generated
 */
public interface SubClassPredicate extends Predicate {
  /**
	 * Returns the value of the '<em><b>Sub Class Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Class Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Class Expression</em>' containment reference.
	 * @see #isSetSubClassExpression()
	 * @see #unsetSubClassExpression()
	 * @see #setSubClassExpression(BooleanExpression)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getSubClassPredicate_SubClassExpression()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  BooleanExpression getSubClassExpression();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.SubClassPredicate#getSubClassExpression <em>Sub Class Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Class Expression</em>' containment reference.
	 * @see #isSetSubClassExpression()
	 * @see #unsetSubClassExpression()
	 * @see #getSubClassExpression()
	 * @generated
	 */
  void setSubClassExpression(BooleanExpression value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.SubClassPredicate#getSubClassExpression <em>Sub Class Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSubClassExpression()
	 * @see #getSubClassExpression()
	 * @see #setSubClassExpression(BooleanExpression)
	 * @generated
	 */
  void unsetSubClassExpression();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.SubClassPredicate#getSubClassExpression <em>Sub Class Expression</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sub Class Expression</em>' containment reference is set.
	 * @see #unsetSubClassExpression()
	 * @see #getSubClassExpression()
	 * @see #setSubClassExpression(BooleanExpression)
	 * @generated
	 */
  boolean isSetSubClassExpression();

  /**
	 * Returns the value of the '<em><b>Sub Class Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Class Attribute</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Class Attribute</em>' containment reference.
	 * @see #isSetSubClassAttribute()
	 * @see #unsetSubClassAttribute()
	 * @see #setSubClassAttribute(ClassAttribute)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getSubClassPredicate_SubClassAttribute()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  ClassAttribute getSubClassAttribute();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.SubClassPredicate#getSubClassAttribute <em>Sub Class Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Class Attribute</em>' containment reference.
	 * @see #isSetSubClassAttribute()
	 * @see #unsetSubClassAttribute()
	 * @see #getSubClassAttribute()
	 * @generated
	 */
  void setSubClassAttribute(ClassAttribute value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.SubClassPredicate#getSubClassAttribute <em>Sub Class Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSubClassAttribute()
	 * @see #getSubClassAttribute()
	 * @see #setSubClassAttribute(ClassAttribute)
	 * @generated
	 */
  void unsetSubClassAttribute();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.SubClassPredicate#getSubClassAttribute <em>Sub Class Attribute</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sub Class Attribute</em>' containment reference is set.
	 * @see #unsetSubClassAttribute()
	 * @see #getSubClassAttribute()
	 * @see #setSubClassAttribute(ClassAttribute)
	 * @generated
	 */
  boolean isSetSubClassAttribute();

} // SubClassPredicate
