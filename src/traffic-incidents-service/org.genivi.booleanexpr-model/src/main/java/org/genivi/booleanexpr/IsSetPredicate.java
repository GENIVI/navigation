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
 * A representation of the model object '<em><b>Is Set Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This predicate checks whether an optional value is set or not.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.IsSetPredicate#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.booleanexpr.FilterexprPackage#getIsSetPredicate()
 * @model
 * @generated
 */
public interface IsSetPredicate extends Predicate {
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
	 * @see org.genivi.booleanexpr.FilterexprPackage#getIsSetPredicate_Attribute()
	 * @model containment="true" required="true"
	 * @generated
	 */
  ClassAttribute getAttribute();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.IsSetPredicate#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' containment reference.
	 * @see #getAttribute()
	 * @generated
	 */
  void setAttribute(ClassAttribute value);

} // IsSetPredicate
