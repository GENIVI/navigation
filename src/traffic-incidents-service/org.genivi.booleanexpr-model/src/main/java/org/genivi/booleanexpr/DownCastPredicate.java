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
 * A representation of the model object '<em><b>Down Cast Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This predicate is used to handle expressions on classes which extend a base class.
 * Example: Class Person has one attribute 'name'. Class Driver extends Person and adds an attribute 'driversLicenseNo'.
 * Now anywhere that Person can be used in a data model, it may also be a Driver.  But to use a Driver specific attribute, the Person has to be downcast to a Driver.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.DownCastPredicate#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.DownCastPredicate#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.booleanexpr.FilterexprPackage#getDownCastPredicate()
 * @model
 * @generated
 */
public interface DownCastPredicate extends Predicate {
  /**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #isSetClassName()
	 * @see #unsetClassName()
	 * @see #setClassName(String)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getDownCastPredicate_ClassName()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  String getClassName();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.DownCastPredicate#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #isSetClassName()
	 * @see #unsetClassName()
	 * @see #getClassName()
	 * @generated
	 */
  void setClassName(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.DownCastPredicate#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetClassName()
	 * @see #getClassName()
	 * @see #setClassName(String)
	 * @generated
	 */
  void unsetClassName();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.DownCastPredicate#getClassName <em>Class Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Class Name</em>' attribute is set.
	 * @see #unsetClassName()
	 * @see #getClassName()
	 * @see #setClassName(String)
	 * @generated
	 */
  boolean isSetClassName();

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
	 * @see org.genivi.booleanexpr.FilterexprPackage#getDownCastPredicate_Expression()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  BooleanExpression getExpression();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.DownCastPredicate#getExpression <em>Expression</em>}' containment reference.
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
	 * Unsets the value of the '{@link org.genivi.booleanexpr.DownCastPredicate#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetExpression()
	 * @see #getExpression()
	 * @see #setExpression(BooleanExpression)
	 * @generated
	 */
  void unsetExpression();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.DownCastPredicate#getExpression <em>Expression</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expression</em>' containment reference is set.
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @see #setExpression(BooleanExpression)
	 * @generated
	 */
  boolean isSetExpression();

} // DownCastPredicate
