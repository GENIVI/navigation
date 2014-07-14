/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.location.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.genivi.location.LocationPackage;
import org.genivi.location.PointLocationInfo;
import org.genivi.location.PointLocationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Point Location Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.location.impl.PointLocationInfoImpl#getLocationType <em>Location Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PointLocationInfoImpl extends LocationInfoImpl implements PointLocationInfo {
  /**
	 * The default value of the '{@link #getLocationType() <em>Location Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocationType()
	 * @generated
	 * @ordered
	 */
  protected static final PointLocationType LOCATION_TYPE_EDEFAULT = PointLocationType.MOTORWAY_EXIT;

  /**
	 * The cached value of the '{@link #getLocationType() <em>Location Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocationType()
	 * @generated
	 * @ordered
	 */
  protected PointLocationType locationType = LOCATION_TYPE_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected PointLocationInfoImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return LocationPackage.Literals.POINT_LOCATION_INFO;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PointLocationType getLocationType() {
		return locationType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLocationType(PointLocationType newLocationType) {
		PointLocationType oldLocationType = locationType;
		locationType = newLocationType == null ? LOCATION_TYPE_EDEFAULT : newLocationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.POINT_LOCATION_INFO__LOCATION_TYPE, oldLocationType, locationType));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LocationPackage.POINT_LOCATION_INFO__LOCATION_TYPE:
				return getLocationType();
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
			case LocationPackage.POINT_LOCATION_INFO__LOCATION_TYPE:
				setLocationType((PointLocationType)newValue);
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
			case LocationPackage.POINT_LOCATION_INFO__LOCATION_TYPE:
				setLocationType(LOCATION_TYPE_EDEFAULT);
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
			case LocationPackage.POINT_LOCATION_INFO__LOCATION_TYPE:
				return locationType != LOCATION_TYPE_EDEFAULT;
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
		result.append(" (locationType: ");
		result.append(locationType);
		result.append(')');
		return result.toString();
	}

} //PointLocationInfoImpl
