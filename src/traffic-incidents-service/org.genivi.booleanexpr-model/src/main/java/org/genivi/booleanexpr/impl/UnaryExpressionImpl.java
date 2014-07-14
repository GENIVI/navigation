/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.booleanexpr.impl;

import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.genivi.booleanexpr.BooleanExpression;
import org.genivi.booleanexpr.FilterexprPackage;
import org.genivi.booleanexpr.UnaryExpression;
import org.genivi.booleanexpr.UnaryLogicalOperator;
import org.genivi.booleanexpr.util.FilterExprUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>unary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.impl.UnaryExpressionImpl#getUnaryOperator <em>Unary Operator</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.UnaryExpressionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnaryExpressionImpl extends BooleanExpressionImpl implements UnaryExpression {
  private final static Logger LOGGER = Logger.getLogger(UnaryExpressionImpl.class.getName());
  private static final String NEW_LINE = System.getProperty("line.separator");

  /**
	 * The default value of the '{@link #getUnaryOperator() <em>Unary Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUnaryOperator()
	 * @generated
	 * @ordered
	 */
  protected static final UnaryLogicalOperator UNARY_OPERATOR_EDEFAULT = UnaryLogicalOperator.NOT;

  /**
	 * The cached value of the '{@link #getUnaryOperator() <em>Unary Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUnaryOperator()
	 * @generated
	 * @ordered
	 */
  protected UnaryLogicalOperator unaryOperator = UNARY_OPERATOR_EDEFAULT;

  /**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
  protected BooleanExpression expression;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected UnaryExpressionImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FilterexprPackage.Literals.UNARY_EXPRESSION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public UnaryLogicalOperator getUnaryOperator() {
		return unaryOperator;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setUnaryOperator(UnaryLogicalOperator newUnaryOperator) {
		UnaryLogicalOperator oldUnaryOperator = unaryOperator;
		unaryOperator = newUnaryOperator == null ? UNARY_OPERATOR_EDEFAULT : newUnaryOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.UNARY_EXPRESSION__UNARY_OPERATOR, oldUnaryOperator, unaryOperator));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BooleanExpression getExpression() {
		return expression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetExpression(BooleanExpression newExpression, NotificationChain msgs) {
		BooleanExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.UNARY_EXPRESSION__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setExpression(BooleanExpression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.UNARY_EXPRESSION__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.UNARY_EXPRESSION__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.UNARY_EXPRESSION__EXPRESSION, newExpression, newExpression));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FilterexprPackage.UNARY_EXPRESSION__EXPRESSION:
				return basicSetExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FilterexprPackage.UNARY_EXPRESSION__UNARY_OPERATOR:
				return getUnaryOperator();
			case FilterexprPackage.UNARY_EXPRESSION__EXPRESSION:
				return getExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FilterexprPackage.UNARY_EXPRESSION__UNARY_OPERATOR:
				setUnaryOperator((UnaryLogicalOperator)newValue);
				return;
			case FilterexprPackage.UNARY_EXPRESSION__EXPRESSION:
				setExpression((BooleanExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case FilterexprPackage.UNARY_EXPRESSION__UNARY_OPERATOR:
				setUnaryOperator(UNARY_OPERATOR_EDEFAULT);
				return;
			case FilterexprPackage.UNARY_EXPRESSION__EXPRESSION:
				setExpression((BooleanExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FilterexprPackage.UNARY_EXPRESSION__UNARY_OPERATOR:
				return unaryOperator != UNARY_OPERATOR_EDEFAULT;
			case FilterexprPackage.UNARY_EXPRESSION__EXPRESSION:
				return expression != null;
		}
		return super.eIsSet(featureID);
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean evaluate(Object object) {
    LOGGER.info("evaluate => " + toString());
    
    LOGGER.info("Going to evaluate expression.");
    boolean result = expression.evaluate(object);
    
    switch (unaryOperator) {
    case NOT:
      LOGGER.fine("applying unary operator NOT.");
      result = !result;
      break;
    }
    
    LOGGER.info("evaluate <= " + result);
    return result;
  }


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String toString() {
    StringBuffer result = new StringBuffer();
    result.append(FilterExprUtil.unaryLogicalOperatorToString(unaryOperator));
    result.append(" (");
    
    result.append(expression.toString());
    result.append(")");

    return result.toString();
  }


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String format(String indent, String indentSize) {
    StringBuffer result = new StringBuffer();
    result.append(indent);
    result.append(FilterExprUtil.unaryLogicalOperatorToString(unaryOperator));
    result.append(" (");
    result.append(NEW_LINE);
    
    indent += indentSize;
    
    result.append(expression.format(indent, indentSize));
    indent = indent.substring(0, indent.lastIndexOf(indentSize));
    result.append(NEW_LINE);

    result.append(indent);
    result.append(")");
    result.append(NEW_LINE);

    return result.toString();
  }
} //unaryExpressionImpl
