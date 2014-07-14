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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.common.Coordinate;

import org.genivi.location.LocationInfo;
import org.genivi.location.LocationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.location.impl.LocationInfoImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.genivi.location.impl.LocationInfoImpl#getMainLocation <em>Main Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocationInfoImpl extends EObjectImpl implements LocationInfo {
  /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
  protected static final String NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
  protected String name = NAME_EDEFAULT;

  /**
	 * The cached value of the '{@link #getMainLocation() <em>Main Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMainLocation()
	 * @generated
	 * @ordered
	 */
  protected Coordinate mainLocation;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected LocationInfoImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return LocationPackage.Literals.LOCATION_INFO;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getName() {
		return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION_INFO__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Coordinate getMainLocation() {
		return mainLocation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetMainLocation(Coordinate newMainLocation, NotificationChain msgs) {
		Coordinate oldMainLocation = mainLocation;
		mainLocation = newMainLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION_INFO__MAIN_LOCATION, oldMainLocation, newMainLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMainLocation(Coordinate newMainLocation) {
		if (newMainLocation != mainLocation) {
			NotificationChain msgs = null;
			if (mainLocation != null)
				msgs = ((InternalEObject)mainLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LocationPackage.LOCATION_INFO__MAIN_LOCATION, null, msgs);
			if (newMainLocation != null)
				msgs = ((InternalEObject)newMainLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LocationPackage.LOCATION_INFO__MAIN_LOCATION, null, msgs);
			msgs = basicSetMainLocation(newMainLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION_INFO__MAIN_LOCATION, newMainLocation, newMainLocation));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LocationPackage.LOCATION_INFO__MAIN_LOCATION:
				return basicSetMainLocation(null, msgs);
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
			case LocationPackage.LOCATION_INFO__NAME:
				return getName();
			case LocationPackage.LOCATION_INFO__MAIN_LOCATION:
				return getMainLocation();
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
			case LocationPackage.LOCATION_INFO__NAME:
				setName((String)newValue);
				return;
			case LocationPackage.LOCATION_INFO__MAIN_LOCATION:
				setMainLocation((Coordinate)newValue);
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
			case LocationPackage.LOCATION_INFO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LocationPackage.LOCATION_INFO__MAIN_LOCATION:
				setMainLocation((Coordinate)null);
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
			case LocationPackage.LOCATION_INFO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LocationPackage.LOCATION_INFO__MAIN_LOCATION:
				return mainLocation != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LocationInfoImpl
