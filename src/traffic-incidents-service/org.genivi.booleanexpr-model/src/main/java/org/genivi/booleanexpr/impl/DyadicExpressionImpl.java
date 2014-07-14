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
import org.genivi.booleanexpr.DyadicExpression;
import org.genivi.booleanexpr.DyadicLogicalOperator;
import org.genivi.booleanexpr.FilterexprPackage;
import org.genivi.booleanexpr.util.FilterExprUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dyadic Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.impl.DyadicExpressionImpl#getLogicalOperator <em>Logical Operator</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.DyadicExpressionImpl#getLeftHandTerm <em>Left Hand Term</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.DyadicExpressionImpl#getRightHandTerm <em>Right Hand Term</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DyadicExpressionImpl extends BooleanExpressionImpl implements DyadicExpression {
  private final static Logger LOGGER = Logger.getLogger(DyadicExpressionImpl.class.getName());
  private static final String NEW_LINE = System.getProperty("line.separator");

  /**
	 * The default value of the '{@link #getLogicalOperator() <em>Logical Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLogicalOperator()
	 * @generated
	 * @ordered
	 */
  protected static final DyadicLogicalOperator LOGICAL_OPERATOR_EDEFAULT = DyadicLogicalOperator.AND;

  /**
	 * The cached value of the '{@link #getLogicalOperator() <em>Logical Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLogicalOperator()
	 * @generated
	 * @ordered
	 */
  protected DyadicLogicalOperator logicalOperator = LOGICAL_OPERATOR_EDEFAULT;

  /**
	 * This is true if the Logical Operator attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean logicalOperatorESet;

  /**
	 * The cached value of the '{@link #getLeftHandTerm() <em>Left Hand Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLeftHandTerm()
	 * @generated
	 * @ordered
	 */
  protected BooleanExpression leftHandTerm;

  /**
	 * This is true if the Left Hand Term containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean leftHandTermESet;

  /**
	 * The cached value of the '{@link #getRightHandTerm() <em>Right Hand Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRightHandTerm()
	 * @generated
	 * @ordered
	 */
  protected BooleanExpression rightHandTerm;

  /**
	 * This is true if the Right Hand Term containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean rightHandTermESet;
  
  static {
    LOGGER.setLevel(Level.SEVERE);
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DyadicExpressionImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FilterexprPackage.Literals.DYADIC_EXPRESSION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DyadicLogicalOperator getLogicalOperator() {
		return logicalOperator;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLogicalOperator(DyadicLogicalOperator newLogicalOperator) {
		DyadicLogicalOperator oldLogicalOperator = logicalOperator;
		logicalOperator = newLogicalOperator == null ? LOGICAL_OPERATOR_EDEFAULT : newLogicalOperator;
		boolean oldLogicalOperatorESet = logicalOperatorESet;
		logicalOperatorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.DYADIC_EXPRESSION__LOGICAL_OPERATOR, oldLogicalOperator, logicalOperator, !oldLogicalOperatorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLogicalOperator() {
		DyadicLogicalOperator oldLogicalOperator = logicalOperator;
		boolean oldLogicalOperatorESet = logicalOperatorESet;
		logicalOperator = LOGICAL_OPERATOR_EDEFAULT;
		logicalOperatorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.DYADIC_EXPRESSION__LOGICAL_OPERATOR, oldLogicalOperator, LOGICAL_OPERATOR_EDEFAULT, oldLogicalOperatorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLogicalOperator() {
		return logicalOperatorESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BooleanExpression getLeftHandTerm() {
		return leftHandTerm;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLeftHandTerm(BooleanExpression newLeftHandTerm, NotificationChain msgs) {
		BooleanExpression oldLeftHandTerm = leftHandTerm;
		leftHandTerm = newLeftHandTerm;
		boolean oldLeftHandTermESet = leftHandTermESet;
		leftHandTermESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM, oldLeftHandTerm, newLeftHandTerm, !oldLeftHandTermESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLeftHandTerm(BooleanExpression newLeftHandTerm) {
		if (newLeftHandTerm != leftHandTerm) {
			NotificationChain msgs = null;
			if (leftHandTerm != null)
				msgs = ((InternalEObject)leftHandTerm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM, null, msgs);
			if (newLeftHandTerm != null)
				msgs = ((InternalEObject)newLeftHandTerm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM, null, msgs);
			msgs = basicSetLeftHandTerm(newLeftHandTerm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLeftHandTermESet = leftHandTermESet;
			leftHandTermESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM, newLeftHandTerm, newLeftHandTerm, !oldLeftHandTermESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetLeftHandTerm(NotificationChain msgs) {
		BooleanExpression oldLeftHandTerm = leftHandTerm;
		leftHandTerm = null;
		boolean oldLeftHandTermESet = leftHandTermESet;
		leftHandTermESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM, oldLeftHandTerm, null, oldLeftHandTermESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLeftHandTerm() {
		if (leftHandTerm != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)leftHandTerm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM, null, msgs);
			msgs = basicUnsetLeftHandTerm(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLeftHandTermESet = leftHandTermESet;
			leftHandTermESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM, null, null, oldLeftHandTermESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLeftHandTerm() {
		return leftHandTermESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BooleanExpression getRightHandTerm() {
		return rightHandTerm;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetRightHandTerm(BooleanExpression newRightHandTerm, NotificationChain msgs) {
		BooleanExpression oldRightHandTerm = rightHandTerm;
		rightHandTerm = newRightHandTerm;
		boolean oldRightHandTermESet = rightHandTermESet;
		rightHandTermESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM, oldRightHandTerm, newRightHandTerm, !oldRightHandTermESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRightHandTerm(BooleanExpression newRightHandTerm) {
		if (newRightHandTerm != rightHandTerm) {
			NotificationChain msgs = null;
			if (rightHandTerm != null)
				msgs = ((InternalEObject)rightHandTerm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM, null, msgs);
			if (newRightHandTerm != null)
				msgs = ((InternalEObject)newRightHandTerm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM, null, msgs);
			msgs = basicSetRightHandTerm(newRightHandTerm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldRightHandTermESet = rightHandTermESet;
			rightHandTermESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM, newRightHandTerm, newRightHandTerm, !oldRightHandTermESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetRightHandTerm(NotificationChain msgs) {
		BooleanExpression oldRightHandTerm = rightHandTerm;
		rightHandTerm = null;
		boolean oldRightHandTermESet = rightHandTermESet;
		rightHandTermESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM, oldRightHandTerm, null, oldRightHandTermESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetRightHandTerm() {
		if (rightHandTerm != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)rightHandTerm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM, null, msgs);
			msgs = basicUnsetRightHandTerm(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldRightHandTermESet = rightHandTermESet;
			rightHandTermESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM, null, null, oldRightHandTermESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetRightHandTerm() {
		return rightHandTermESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM:
				return basicUnsetLeftHandTerm(msgs);
			case FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM:
				return basicUnsetRightHandTerm(msgs);
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
			case FilterexprPackage.DYADIC_EXPRESSION__LOGICAL_OPERATOR:
				return getLogicalOperator();
			case FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM:
				return getLeftHandTerm();
			case FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM:
				return getRightHandTerm();
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
			case FilterexprPackage.DYADIC_EXPRESSION__LOGICAL_OPERATOR:
				setLogicalOperator((DyadicLogicalOperator)newValue);
				return;
			case FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM:
				setLeftHandTerm((BooleanExpression)newValue);
				return;
			case FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM:
				setRightHandTerm((BooleanExpression)newValue);
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
			case FilterexprPackage.DYADIC_EXPRESSION__LOGICAL_OPERATOR:
				unsetLogicalOperator();
				return;
			case FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM:
				unsetLeftHandTerm();
				return;
			case FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM:
				unsetRightHandTerm();
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
			case FilterexprPackage.DYADIC_EXPRESSION__LOGICAL_OPERATOR:
				return isSetLogicalOperator();
			case FilterexprPackage.DYADIC_EXPRESSION__LEFT_HAND_TERM:
				return isSetLeftHandTerm();
			case FilterexprPackage.DYADIC_EXPRESSION__RIGHT_HAND_TERM:
				return isSetRightHandTerm();
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
    
    // Left hand Expression
    result.append('(');
    if (leftHandTerm != null) {
      result.append(leftHandTerm.toString());
    } else {
      result.append("null");
    }
    result.append(") ");

    // DyadicLogicalOperator
    if (logicalOperatorESet)
      result.append(FilterExprUtil.dyadicLogicalOperatorToString(logicalOperator));
    else
      result.append("<unset>");
    
    // Right hand Expression
    result.append(" (");
    if (rightHandTerm != null) {
      result.append(rightHandTerm.toString());
    } else {
      result.append("null");
    }
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
    
    // Left hand Expression
    result.append(indent);
    result.append('(');
    result.append(NEW_LINE);
    
    indent += indentSize;

    if (leftHandTerm != null) {
      result.append(leftHandTerm.format(indent, indentSize));
    } else {
      result.append("null");
    }
    result.append(NEW_LINE);
    
    indent = indent.substring(0, indent.lastIndexOf(indentSize));

    result.append(indent);
    result.append(") ");

    // DyadicLogicalOperator
    if (logicalOperatorESet)
      result.append(FilterExprUtil.dyadicLogicalOperatorToString(logicalOperator));
    else
      result.append("<unset>");
    
    // Right hand Expression
    result.append(" (");
    result.append(NEW_LINE);
    
    indent += indentSize;

    if (rightHandTerm != null) {
      result.append(rightHandTerm.format(indent, indentSize));
    } else {
      result.append("null");
    }
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
    
    LOGGER.info("Going to evaluate left hand side");
    boolean result = false;
    boolean leftHandResult = leftHandTerm.evaluate(object);
    boolean rightHandResult;
        
    switch (logicalOperator) {
    case AND:
      LOGGER.info("Operator is AND");
      if (leftHandResult) {
        LOGGER.info("Needed to evaluate right hand side");
        rightHandResult = rightHandTerm.evaluate(object);
        result = leftHandResult && rightHandResult;
      }
      break;
      
    case OR:
      LOGGER.info("Operator is OR");
      if (leftHandResult) {
        result = true;
      } else {
        LOGGER.info("Needed to evaluate right hand side");
        rightHandResult = rightHandTerm.evaluate(object);
        result = leftHandResult || rightHandResult;
      }
    }
    
    LOGGER.info("evaluate <= " + result);
    return result;
  }
} //DyadicExpressionImpl
