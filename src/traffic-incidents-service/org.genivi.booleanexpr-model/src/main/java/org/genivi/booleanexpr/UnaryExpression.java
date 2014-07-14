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
 * A representation of the model object '<em><b>unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is an expression of the form UnaryLogicalOperator 'expression', like: NOT 'expression'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.UnaryExpression#getUnaryOperator <em>Unary Operator</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.UnaryExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.booleanexpr.FilterexprPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends BooleanExpression {
  /**
	 * Returns the value of the '<em><b>Unary Operator</b></em>' attribute.
	 * The default value is <code>"NOT"</code>.
	 * The literals are from the enumeration {@link org.genivi.booleanexpr.UnaryLogicalOperator}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unary Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Unary Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.UnaryLogicalOperator
	 * @see #setUnaryOperator(UnaryLogicalOperator)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getUnaryExpression_UnaryOperator()
	 * @model default="NOT" required="true"
	 * @generated
	 */
  UnaryLogicalOperator getUnaryOperator();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.UnaryExpression#getUnaryOperator <em>Unary Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unary Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.UnaryLogicalOperator
	 * @see #getUnaryOperator()
	 * @generated
	 */
  void setUnaryOperator(UnaryLogicalOperator value);

  /**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(BooleanExpression)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getUnaryExpression_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
  BooleanExpression getExpression();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.UnaryExpression#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
  void setExpression(BooleanExpression value);

} // unaryExpression
