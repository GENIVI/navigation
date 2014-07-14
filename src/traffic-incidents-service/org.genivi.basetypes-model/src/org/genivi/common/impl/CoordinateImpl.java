/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.common.CommonPackage;
import org.genivi.common.Coordinate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Coordinate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.common.impl.CoordinateImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link org.genivi.common.impl.CoordinateImpl#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link org.genivi.common.impl.CoordinateImpl#getAltitude <em>Altitude</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoordinateImpl extends EObjectImpl implements Coordinate {
	/**
	 * The default value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
  protected static final double LATITUDE_EDEFAULT = 0.0;
  /**
	 * The cached value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
  protected double latitude = LATITUDE_EDEFAULT;
  /**
	 * The default value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
  protected static final double LONGITUDE_EDEFAULT = 0.0;
  /**
	 * The cached value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
  protected double longitude = LONGITUDE_EDEFAULT;
  /**
	 * The default value of the '{@link #getAltitude() <em>Altitude</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAltitude()
	 * @generated
	 * @ordered
	 */
  protected static final int ALTITUDE_EDEFAULT = 0;
  /**
	 * The cached value of the '{@link #getAltitude() <em>Altitude</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAltitude()
	 * @generated
	 * @ordered
	 */
  protected int altitude = ALTITUDE_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoordinateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.COORDINATE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public double getLatitude() {
		return latitude;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLatitude(double newLatitude) {
		double oldLatitude = latitude;
		latitude = newLatitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COORDINATE__LATITUDE, oldLatitude, latitude));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public double getLongitude() {
		return longitude;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLongitude(double newLongitude) {
		double oldLongitude = longitude;
		longitude = newLongitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COORDINATE__LONGITUDE, oldLongitude, longitude));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getAltitude() {
		return altitude;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAltitude(int newAltitude) {
		int oldAltitude = altitude;
		altitude = newAltitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.COORDINATE__ALTITUDE, oldAltitude, altitude));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.COORDINATE__LATITUDE:
				return getLatitude();
			case CommonPackage.COORDINATE__LONGITUDE:
				return getLongitude();
			case CommonPackage.COORDINATE__ALTITUDE:
				return getAltitude();
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
			case CommonPackage.COORDINATE__LATITUDE:
				setLatitude((Double)newValue);
				return;
			case CommonPackage.COORDINATE__LONGITUDE:
				setLongitude((Double)newValue);
				return;
			case CommonPackage.COORDINATE__ALTITUDE:
				setAltitude((Integer)newValue);
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
			case CommonPackage.COORDINATE__LATITUDE:
				setLatitude(LATITUDE_EDEFAULT);
				return;
			case CommonPackage.COORDINATE__LONGITUDE:
				setLongitude(LONGITUDE_EDEFAULT);
				return;
			case CommonPackage.COORDINATE__ALTITUDE:
				setAltitude(ALTITUDE_EDEFAULT);
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
			case CommonPackage.COORDINATE__LATITUDE:
				return latitude != LATITUDE_EDEFAULT;
			case CommonPackage.COORDINATE__LONGITUDE:
				return longitude != LONGITUDE_EDEFAULT;
			case CommonPackage.COORDINATE__ALTITUDE:
				return altitude != ALTITUDE_EDEFAULT;
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
		result.append(" (latitude: ");
		result.append(latitude);
		result.append(", longitude: ");
		result.append(longitude);
		result.append(", altitude: ");
		result.append(altitude);
		result.append(')');
		return result.toString();
	}

} //CoordinateImpl
