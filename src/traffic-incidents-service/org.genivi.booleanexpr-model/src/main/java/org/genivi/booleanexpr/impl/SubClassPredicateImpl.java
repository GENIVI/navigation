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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.genivi.booleanexpr.BooleanExpression;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.FilterexprPackage;
import org.genivi.booleanexpr.SubClassPredicate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Class Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.impl.SubClassPredicateImpl#getSubClassExpression <em>Sub Class Expression</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.SubClassPredicateImpl#getSubClassAttribute <em>Sub Class Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubClassPredicateImpl extends PredicateImpl implements SubClassPredicate {
  private final static Logger LOGGER = Logger.getLogger(SubClassPredicateImpl.class.getName());
  private static final String NEW_LINE = System.getProperty("line.separator");
  
  /**
	 * The cached value of the '{@link #getSubClassExpression() <em>Sub Class Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSubClassExpression()
	 * @generated
	 * @ordered
	 */
  protected BooleanExpression subClassExpression;

  /**
	 * This is true if the Sub Class Expression containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean subClassExpressionESet;

  /**
	 * The cached value of the '{@link #getSubClassAttribute() <em>Sub Class Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSubClassAttribute()
	 * @generated
	 * @ordered
	 */
  protected ClassAttribute subClassAttribute;

  /**
	 * This is true if the Sub Class Attribute containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean subClassAttributeESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected SubClassPredicateImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FilterexprPackage.Literals.SUB_CLASS_PREDICATE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BooleanExpression getSubClassExpression() {
		return subClassExpression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetSubClassExpression(BooleanExpression newSubClassExpression, NotificationChain msgs) {
		BooleanExpression oldSubClassExpression = subClassExpression;
		subClassExpression = newSubClassExpression;
		boolean oldSubClassExpressionESet = subClassExpressionESet;
		subClassExpressionESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION, oldSubClassExpression, newSubClassExpression, !oldSubClassExpressionESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSubClassExpression(BooleanExpression newSubClassExpression) {
		if (newSubClassExpression != subClassExpression) {
			NotificationChain msgs = null;
			if (subClassExpression != null)
				msgs = ((InternalEObject)subClassExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION, null, msgs);
			if (newSubClassExpression != null)
				msgs = ((InternalEObject)newSubClassExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION, null, msgs);
			msgs = basicSetSubClassExpression(newSubClassExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubClassExpressionESet = subClassExpressionESet;
			subClassExpressionESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION, newSubClassExpression, newSubClassExpression, !oldSubClassExpressionESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetSubClassExpression(NotificationChain msgs) {
		BooleanExpression oldSubClassExpression = subClassExpression;
		subClassExpression = null;
		boolean oldSubClassExpressionESet = subClassExpressionESet;
		subClassExpressionESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION, oldSubClassExpression, null, oldSubClassExpressionESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetSubClassExpression() {
		if (subClassExpression != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)subClassExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION, null, msgs);
			msgs = basicUnsetSubClassExpression(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubClassExpressionESet = subClassExpressionESet;
			subClassExpressionESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION, null, null, oldSubClassExpressionESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetSubClassExpression() {
		return subClassExpressionESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ClassAttribute getSubClassAttribute() {
		return subClassAttribute;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetSubClassAttribute(ClassAttribute newSubClassAttribute, NotificationChain msgs) {
		ClassAttribute oldSubClassAttribute = subClassAttribute;
		subClassAttribute = newSubClassAttribute;
		boolean oldSubClassAttributeESet = subClassAttributeESet;
		subClassAttributeESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE, oldSubClassAttribute, newSubClassAttribute, !oldSubClassAttributeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSubClassAttribute(ClassAttribute newSubClassAttribute) {
		if (newSubClassAttribute != subClassAttribute) {
			NotificationChain msgs = null;
			if (subClassAttribute != null)
				msgs = ((InternalEObject)subClassAttribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE, null, msgs);
			if (newSubClassAttribute != null)
				msgs = ((InternalEObject)newSubClassAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE, null, msgs);
			msgs = basicSetSubClassAttribute(newSubClassAttribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubClassAttributeESet = subClassAttributeESet;
			subClassAttributeESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE, newSubClassAttribute, newSubClassAttribute, !oldSubClassAttributeESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetSubClassAttribute(NotificationChain msgs) {
		ClassAttribute oldSubClassAttribute = subClassAttribute;
		subClassAttribute = null;
		boolean oldSubClassAttributeESet = subClassAttributeESet;
		subClassAttributeESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE, oldSubClassAttribute, null, oldSubClassAttributeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetSubClassAttribute() {
		if (subClassAttribute != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)subClassAttribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE, null, msgs);
			msgs = basicUnsetSubClassAttribute(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubClassAttributeESet = subClassAttributeESet;
			subClassAttributeESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE, null, null, oldSubClassAttributeESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetSubClassAttribute() {
		return subClassAttributeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION:
				return basicUnsetSubClassExpression(msgs);
			case FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE:
				return basicUnsetSubClassAttribute(msgs);
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
			case FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION:
				return getSubClassExpression();
			case FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE:
				return getSubClassAttribute();
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
			case FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION:
				setSubClassExpression((BooleanExpression)newValue);
				return;
			case FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE:
				setSubClassAttribute((ClassAttribute)newValue);
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
			case FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION:
				unsetSubClassExpression();
				return;
			case FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE:
				unsetSubClassAttribute();
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
			case FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_EXPRESSION:
				return isSetSubClassExpression();
			case FilterexprPackage.SUB_CLASS_PREDICATE__SUB_CLASS_ATTRIBUTE:
				return isSetSubClassAttribute();
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
    
    // ClassAttribute
    if (subClassAttribute != null) {
      result.append(subClassAttribute.toString());
    } else {
      result.append("@");
    }
    
    // Expression
    result.append(" (");
    result.append(subClassExpression.toString());
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
    
    // ClassAttribute
    if (subClassAttribute != null) {
      result.append(subClassAttribute.toString());
    } else {
      result.append("@");
    }
    
    // Expression
    result.append(" (");
    result.append(NEW_LINE);
    
    indent += indentSize;

    result.append(subClassExpression.format(indent, indentSize));
    result.append(NEW_LINE);
    
    indent = indent.substring(0, indent.lastIndexOf(indentSize));

    result.append(indent);
    result.append(')');
    result.append(NEW_LINE);
    
    return result.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean evaluate(Object object) {
    LOGGER.info("evaluate => " + toString());
    
    String subClassAttributeName = "<null>";
    if (subClassAttribute != null) {
      subClassAttributeName =subClassAttribute.getAttributeName();
    }
    LOGGER.info("=> attributeName = " + subClassAttributeName);
    
    boolean returnValue = false;
    
    Object subClassObject;
    if (subClassAttribute != null) {
      subClassObject = subClassAttribute.getValue((EObject) object);
    } else {
      subClassObject = object;  // TODO throw exception
    }
    
    returnValue = subClassExpression.evaluate(subClassObject);
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }
} //SubClassPredicateImpl
