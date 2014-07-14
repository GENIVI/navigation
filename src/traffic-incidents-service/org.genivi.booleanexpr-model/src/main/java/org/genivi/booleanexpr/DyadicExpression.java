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
 * A representation of the model object '<em><b>Dyadic Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is an expression of the form 'expression' DyadicLogicalOperator 'expression', like 'expression' AND 'expression'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.DyadicExpression#getLogicalOperator <em>Logical Operator</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.DyadicExpression#getLeftHandTerm <em>Left Hand Term</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.DyadicExpression#getRightHandTerm <em>Right Hand Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.booleanexpr.FilterexprPackage#getDyadicExpression()
 * @model
 * @generated
 */
public interface DyadicExpression extends BooleanExpression {
  /**
	 * Returns the value of the '<em><b>Logical Operator</b></em>' attribute.
	 * The default value is <code>"AND"</code>.
	 * The literals are from the enumeration {@link org.genivi.booleanexpr.DyadicLogicalOperator}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Logical Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Logical Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.DyadicLogicalOperator
	 * @see #isSetLogicalOperator()
	 * @see #unsetLogicalOperator()
	 * @see #setLogicalOperator(DyadicLogicalOperator)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getDyadicExpression_LogicalOperator()
	 * @model default="AND" unsettable="true" required="true"
	 * @generated
	 */
  DyadicLogicalOperator getLogicalOperator();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.DyadicExpression#getLogicalOperator <em>Logical Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logical Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.DyadicLogicalOperator
	 * @see #isSetLogicalOperator()
	 * @see #unsetLogicalOperator()
	 * @see #getLogicalOperator()
	 * @generated
	 */
  void setLogicalOperator(DyadicLogicalOperator value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.DyadicExpression#getLogicalOperator <em>Logical Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLogicalOperator()
	 * @see #getLogicalOperator()
	 * @see #setLogicalOperator(DyadicLogicalOperator)
	 * @generated
	 */
  void unsetLogicalOperator();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.DyadicExpression#getLogicalOperator <em>Logical Operator</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Logical Operator</em>' attribute is set.
	 * @see #unsetLogicalOperator()
	 * @see #getLogicalOperator()
	 * @see #setLogicalOperator(DyadicLogicalOperator)
	 * @generated
	 */
  boolean isSetLogicalOperator();

  /**
	 * Returns the value of the '<em><b>Left Hand Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Hand Term</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Hand Term</em>' containment reference.
	 * @see #isSetLeftHandTerm()
	 * @see #unsetLeftHandTerm()
	 * @see #setLeftHandTerm(BooleanExpression)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getDyadicExpression_LeftHandTerm()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  BooleanExpression getLeftHandTerm();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.DyadicExpression#getLeftHandTerm <em>Left Hand Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Hand Term</em>' containment reference.
	 * @see #isSetLeftHandTerm()
	 * @see #unsetLeftHandTerm()
	 * @see #getLeftHandTerm()
	 * @generated
	 */
  void setLeftHandTerm(BooleanExpression value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.DyadicExpression#getLeftHandTerm <em>Left Hand Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLeftHandTerm()
	 * @see #getLeftHandTerm()
	 * @see #setLeftHandTerm(BooleanExpression)
	 * @generated
	 */
  void unsetLeftHandTerm();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.DyadicExpression#getLeftHandTerm <em>Left Hand Term</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Left Hand Term</em>' containment reference is set.
	 * @see #unsetLeftHandTerm()
	 * @see #getLeftHandTerm()
	 * @see #setLeftHandTerm(BooleanExpression)
	 * @generated
	 */
  boolean isSetLeftHandTerm();

  /**
	 * Returns the value of the '<em><b>Right Hand Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Hand Term</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Hand Term</em>' containment reference.
	 * @see #isSetRightHandTerm()
	 * @see #unsetRightHandTerm()
	 * @see #setRightHandTerm(BooleanExpression)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getDyadicExpression_RightHandTerm()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  BooleanExpression getRightHandTerm();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.DyadicExpression#getRightHandTerm <em>Right Hand Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Hand Term</em>' containment reference.
	 * @see #isSetRightHandTerm()
	 * @see #unsetRightHandTerm()
	 * @see #getRightHandTerm()
	 * @generated
	 */
  void setRightHandTerm(BooleanExpression value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.DyadicExpression#getRightHandTerm <em>Right Hand Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetRightHandTerm()
	 * @see #getRightHandTerm()
	 * @see #setRightHandTerm(BooleanExpression)
	 * @generated
	 */
  void unsetRightHandTerm();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.DyadicExpression#getRightHandTerm <em>Right Hand Term</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Right Hand Term</em>' containment reference is set.
	 * @see #unsetRightHandTerm()
	 * @see #getRightHandTerm()
	 * @see #setRightHandTerm(BooleanExpression)
	 * @generated
	 */
  boolean isSetRightHandTerm();

} // DyadicExpression
