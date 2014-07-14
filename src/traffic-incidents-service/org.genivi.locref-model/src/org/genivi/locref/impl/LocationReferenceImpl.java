/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.locref.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.locref.LocationReference;
import org.genivi.locref.locrefPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Location Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.locref.impl.LocationReferenceImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.genivi.locref.impl.LocationReferenceImpl#getLocationReferenceType <em>Location Reference Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocationReferenceImpl extends EObjectImpl implements LocationReference {
  /**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
  protected static final Object DATA_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
  protected Object data = DATA_EDEFAULT;

  /**
	 * This is true if the Data attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean dataESet;

  /**
	 * The default value of the '{@link #getLocationReferenceType() <em>Location Reference Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocationReferenceType()
	 * @generated
	 * @ordered
	 */
  protected static final byte LOCATION_REFERENCE_TYPE_EDEFAULT = 0x00;

  /**
	 * The cached value of the '{@link #getLocationReferenceType() <em>Location Reference Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocationReferenceType()
	 * @generated
	 * @ordered
	 */
  protected byte locationReferenceType = LOCATION_REFERENCE_TYPE_EDEFAULT;

  /**
	 * This is true if the Location Reference Type attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean locationReferenceTypeESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected LocationReferenceImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return locrefPackage.Literals.LOCATION_REFERENCE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object getData() {
		return data;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setData(Object newData) {
		Object oldData = data;
		data = newData;
		boolean oldDataESet = dataESet;
		dataESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, locrefPackage.LOCATION_REFERENCE__DATA, oldData, data, !oldDataESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetData() {
		Object oldData = data;
		boolean oldDataESet = dataESet;
		data = DATA_EDEFAULT;
		dataESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, locrefPackage.LOCATION_REFERENCE__DATA, oldData, DATA_EDEFAULT, oldDataESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetData() {
		return dataESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public byte getLocationReferenceType() {
		return locationReferenceType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLocationReferenceType(byte newLocationReferenceType) {
		byte oldLocationReferenceType = locationReferenceType;
		locationReferenceType = newLocationReferenceType;
		boolean oldLocationReferenceTypeESet = locationReferenceTypeESet;
		locationReferenceTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, locrefPackage.LOCATION_REFERENCE__LOCATION_REFERENCE_TYPE, oldLocationReferenceType, locationReferenceType, !oldLocationReferenceTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLocationReferenceType() {
		byte oldLocationReferenceType = locationReferenceType;
		boolean oldLocationReferenceTypeESet = locationReferenceTypeESet;
		locationReferenceType = LOCATION_REFERENCE_TYPE_EDEFAULT;
		locationReferenceTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, locrefPackage.LOCATION_REFERENCE__LOCATION_REFERENCE_TYPE, oldLocationReferenceType, LOCATION_REFERENCE_TYPE_EDEFAULT, oldLocationReferenceTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLocationReferenceType() {
		return locationReferenceTypeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case locrefPackage.LOCATION_REFERENCE__DATA:
				return getData();
			case locrefPackage.LOCATION_REFERENCE__LOCATION_REFERENCE_TYPE:
				return getLocationReferenceType();
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
			case locrefPackage.LOCATION_REFERENCE__DATA:
				setData(newValue);
				return;
			case locrefPackage.LOCATION_REFERENCE__LOCATION_REFERENCE_TYPE:
				setLocationReferenceType((Byte)newValue);
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
			case locrefPackage.LOCATION_REFERENCE__DATA:
				unsetData();
				return;
			case locrefPackage.LOCATION_REFERENCE__LOCATION_REFERENCE_TYPE:
				unsetLocationReferenceType();
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
			case locrefPackage.LOCATION_REFERENCE__DATA:
				return isSetData();
			case locrefPackage.LOCATION_REFERENCE__LOCATION_REFERENCE_TYPE:
				return isSetLocationReferenceType();
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (data: ");
		if (dataESet) result.append(data); else result.append("<unset>");
		result.append(", locationReferenceType: ");
		if (locationReferenceTypeESet) result.append(locationReferenceType); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //LocationReferenceImpl
