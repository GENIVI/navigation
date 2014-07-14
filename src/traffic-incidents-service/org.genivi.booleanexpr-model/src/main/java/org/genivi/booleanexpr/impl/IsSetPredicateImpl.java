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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.FilterexprPackage;
import org.genivi.booleanexpr.IsSetPredicate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Is Set Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.impl.IsSetPredicateImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IsSetPredicateImpl extends PredicateImpl implements IsSetPredicate {
  private final static Logger LOGGER = Logger.getLogger(IsSetPredicateImpl.class.getName());

  /**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
  protected ClassAttribute attribute;
  
  static {
    LOGGER.setLevel(Level.SEVERE);
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected IsSetPredicateImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FilterexprPackage.Literals.IS_SET_PREDICATE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ClassAttribute getAttribute() {
		return attribute;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetAttribute(ClassAttribute newAttribute, NotificationChain msgs) {
		ClassAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.IS_SET_PREDICATE__ATTRIBUTE, oldAttribute, newAttribute);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAttribute(ClassAttribute newAttribute) {
		if (newAttribute != attribute) {
			NotificationChain msgs = null;
			if (attribute != null)
				msgs = ((InternalEObject)attribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.IS_SET_PREDICATE__ATTRIBUTE, null, msgs);
			if (newAttribute != null)
				msgs = ((InternalEObject)newAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.IS_SET_PREDICATE__ATTRIBUTE, null, msgs);
			msgs = basicSetAttribute(newAttribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.IS_SET_PREDICATE__ATTRIBUTE, newAttribute, newAttribute));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FilterexprPackage.IS_SET_PREDICATE__ATTRIBUTE:
				return basicSetAttribute(null, msgs);
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
			case FilterexprPackage.IS_SET_PREDICATE__ATTRIBUTE:
				return getAttribute();
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
			case FilterexprPackage.IS_SET_PREDICATE__ATTRIBUTE:
				setAttribute((ClassAttribute)newValue);
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
			case FilterexprPackage.IS_SET_PREDICATE__ATTRIBUTE:
				setAttribute((ClassAttribute)null);
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
			case FilterexprPackage.IS_SET_PREDICATE__ATTRIBUTE:
				return attribute != null;
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
    
    // isSet operator
    result.append("isSet ");
    
    // ClassAttribute
    if (attribute != null) {
      result.append(attribute.toString());
    } else {
      result.append("<attribute is null>");
    }
    
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
    result.append(toString());
    
    return result.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean evaluate(Object object) {
    LOGGER.info("evaluate => " + toString());

    boolean returnValue = false;
    if (object instanceof EObject) {
      returnValue = attribute.isSet((EObject) object);
    } else {
      throw new IllegalArgumentException("Unsupported attribute in IsSetPredicate. Attribute = " + object);
    }
    
    LOGGER.info("evaluate <= " + returnValue);
    
    return returnValue;
  }
} //IsSetPredicateImpl
