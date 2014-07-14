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

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.genivi.booleanexpr.BooleanExpression;
import org.genivi.booleanexpr.DownCastPredicate;
import org.genivi.booleanexpr.FilterexprPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Down Cast Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.impl.DownCastPredicateImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.DownCastPredicateImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DownCastPredicateImpl extends PredicateImpl implements DownCastPredicate {
  private final static Logger LOGGER = Logger.getLogger(DownCastPredicateImpl.class.getName());
  private static final String NEW_LINE = System.getProperty("line.separator");

  /**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
  protected static final String CLASS_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
  protected String className = CLASS_NAME_EDEFAULT;

  /**
	 * This is true if the Class Name attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean classNameESet;

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
	 * This is true if the Expression containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean expressionESet;
  
  static {
    LOGGER.setLevel(Level.SEVERE);
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DownCastPredicateImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FilterexprPackage.Literals.DOWN_CAST_PREDICATE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getClassName() {
		return className;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		boolean oldClassNameESet = classNameESet;
		classNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.DOWN_CAST_PREDICATE__CLASS_NAME, oldClassName, className, !oldClassNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetClassName() {
		String oldClassName = className;
		boolean oldClassNameESet = classNameESet;
		className = CLASS_NAME_EDEFAULT;
		classNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.DOWN_CAST_PREDICATE__CLASS_NAME, oldClassName, CLASS_NAME_EDEFAULT, oldClassNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetClassName() {
		return classNameESet;
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
		boolean oldExpressionESet = expressionESet;
		expressionESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION, oldExpression, newExpression, !oldExpressionESet);
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
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldExpressionESet = expressionESet;
			expressionESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION, newExpression, newExpression, !oldExpressionESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetExpression(NotificationChain msgs) {
		BooleanExpression oldExpression = expression;
		expression = null;
		boolean oldExpressionESet = expressionESet;
		expressionESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION, oldExpression, null, oldExpressionESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetExpression() {
		if (expression != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION, null, msgs);
			msgs = basicUnsetExpression(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldExpressionESet = expressionESet;
			expressionESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION, null, null, oldExpressionESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetExpression() {
		return expressionESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION:
				return basicUnsetExpression(msgs);
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
			case FilterexprPackage.DOWN_CAST_PREDICATE__CLASS_NAME:
				return getClassName();
			case FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION:
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
			case FilterexprPackage.DOWN_CAST_PREDICATE__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION:
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
			case FilterexprPackage.DOWN_CAST_PREDICATE__CLASS_NAME:
				unsetClassName();
				return;
			case FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION:
				unsetExpression();
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
			case FilterexprPackage.DOWN_CAST_PREDICATE__CLASS_NAME:
				return isSetClassName();
			case FilterexprPackage.DOWN_CAST_PREDICATE__EXPRESSION:
				return isSetExpression();
		}
		return super.eIsSet(featureID);
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String toString() {
    StringBuffer result = new StringBuffer();
    
    // 'DownCast to' class between '[' and ']'
    result.append("[");
    if (classNameESet)
      result.append(className);
    else
      result.append("<unset>");
    result.append("]");
    
    // Expression
    result.append('(');
    result.append(expression.toString());
    result.append(')');
    
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
    
    // 'DownCast to' class between '[' and ']'
    result.append("[");
    if (classNameESet)
      result.append(className);
    else
      result.append("<unset>");
    result.append("]");
    
    // Expression
    result.append(" (");
    result.append(NEW_LINE);
    
    indent += indentSize;

    result.append(expression.format(indent, indentSize));
    result.append(NEW_LINE);
    
    indent = indent.substring(0, indent.lastIndexOf(indentSize));

    result.append(indent);
    result.append(')');
    
    return result.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean evaluate(Object object) {
    LOGGER.info("evaluate => " + toString());
    
    boolean returnValue;
    
    returnValue = expression.evaluate(object);

    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }
} //DownCastPredicateImpl
