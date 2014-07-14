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
 * A representation of the model object '<em><b>Boolean Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class represents the boolean literal values 'true' and 'false'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.BooleanLiteral#isValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.booleanexpr.FilterexprPackage#getBooleanLiteral()
 * @model
 * @generated
 */
public interface BooleanLiteral extends Literal {
  /**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #isSetValue()
	 * @see #unsetValue()
	 * @see #setValue(boolean)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getBooleanLiteral_Value()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  boolean isValue();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.BooleanLiteral#isValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #isSetValue()
	 * @see #unsetValue()
	 * @see #isValue()
	 * @generated
	 */
  void setValue(boolean value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.BooleanLiteral#isValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetValue()
	 * @see #isValue()
	 * @see #setValue(boolean)
	 * @generated
	 */
  void unsetValue();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.BooleanLiteral#isValue <em>Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Value</em>' attribute is set.
	 * @see #unsetValue()
	 * @see #isValue()
	 * @see #setValue(boolean)
	 * @generated
	 */
  boolean isSetValue();

} // BooleanLiteral
