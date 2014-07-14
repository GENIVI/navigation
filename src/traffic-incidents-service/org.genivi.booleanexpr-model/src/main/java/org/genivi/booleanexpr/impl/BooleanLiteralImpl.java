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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.genivi.booleanexpr.BooleanLiteral;
import org.genivi.booleanexpr.FilterexprPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.impl.BooleanLiteralImpl#isValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanLiteralImpl extends LiteralImpl implements BooleanLiteral {
  /**
	 * The default value of the '{@link #isValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isValue()
	 * @generated
	 * @ordered
	 */
  protected static final boolean VALUE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isValue()
	 * @generated
	 * @ordered
	 */
  protected boolean value = VALUE_EDEFAULT;

  /**
	 * This is true if the Value attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean valueESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected BooleanLiteralImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FilterexprPackage.Literals.BOOLEAN_LITERAL;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isValue() {
		return value;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setValue(boolean newValue) {
		boolean oldValue = value;
		value = newValue;
		boolean oldValueESet = valueESet;
		valueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.BOOLEAN_LITERAL__VALUE, oldValue, value, !oldValueESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetValue() {
		boolean oldValue = value;
		boolean oldValueESet = valueESet;
		value = VALUE_EDEFAULT;
		valueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.BOOLEAN_LITERAL__VALUE, oldValue, VALUE_EDEFAULT, oldValueESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetValue() {
		return valueESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FilterexprPackage.BOOLEAN_LITERAL__VALUE:
				return isValue();
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
			case FilterexprPackage.BOOLEAN_LITERAL__VALUE:
				setValue((Boolean)newValue);
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
			case FilterexprPackage.BOOLEAN_LITERAL__VALUE:
				unsetValue();
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
			case FilterexprPackage.BOOLEAN_LITERAL__VALUE:
				return isSetValue();
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
    
    if (valueESet)
      result.append(value);
    else
      result.append("<unset>");
    
    return result.toString();
  }

} //BooleanLiteralImpl
