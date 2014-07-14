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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genivi.common.Coordinate;

import org.genivi.location.LinearLocationInfo;
import org.genivi.location.LocationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linear Location Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.location.impl.LinearLocationInfoImpl#getFromLocationName <em>From Location Name</em>}</li>
 *   <li>{@link org.genivi.location.impl.LinearLocationInfoImpl#getFromLocationParentName <em>From Location Parent Name</em>}</li>
 *   <li>{@link org.genivi.location.impl.LinearLocationInfoImpl#getToLocationName <em>To Location Name</em>}</li>
 *   <li>{@link org.genivi.location.impl.LinearLocationInfoImpl#getToLocationParentName <em>To Location Parent Name</em>}</li>
 *   <li>{@link org.genivi.location.impl.LinearLocationInfoImpl#getCoordinates <em>Coordinates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinearLocationInfoImpl extends LocationInfoImpl implements LinearLocationInfo {
  /**
	 * The default value of the '{@link #getFromLocationName() <em>From Location Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFromLocationName()
	 * @generated
	 * @ordered
	 */
  protected static final String FROM_LOCATION_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getFromLocationName() <em>From Location Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFromLocationName()
	 * @generated
	 * @ordered
	 */
  protected String fromLocationName = FROM_LOCATION_NAME_EDEFAULT;

  /**
	 * The default value of the '{@link #getFromLocationParentName() <em>From Location Parent Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFromLocationParentName()
	 * @generated
	 * @ordered
	 */
  protected static final String FROM_LOCATION_PARENT_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getFromLocationParentName() <em>From Location Parent Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFromLocationParentName()
	 * @generated
	 * @ordered
	 */
  protected String fromLocationParentName = FROM_LOCATION_PARENT_NAME_EDEFAULT;

  /**
	 * The default value of the '{@link #getToLocationName() <em>To Location Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getToLocationName()
	 * @generated
	 * @ordered
	 */
  protected static final String TO_LOCATION_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getToLocationName() <em>To Location Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getToLocationName()
	 * @generated
	 * @ordered
	 */
  protected String toLocationName = TO_LOCATION_NAME_EDEFAULT;

  /**
	 * The default value of the '{@link #getToLocationParentName() <em>To Location Parent Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getToLocationParentName()
	 * @generated
	 * @ordered
	 */
  protected static final String TO_LOCATION_PARENT_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getToLocationParentName() <em>To Location Parent Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getToLocationParentName()
	 * @generated
	 * @ordered
	 */
  protected String toLocationParentName = TO_LOCATION_PARENT_NAME_EDEFAULT;

  /**
	 * The cached value of the '{@link #getCoordinates() <em>Coordinates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCoordinates()
	 * @generated
	 * @ordered
	 */
  protected EList<Coordinate> coordinates;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected LinearLocationInfoImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return LocationPackage.Literals.LINEAR_LOCATION_INFO;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getFromLocationName() {
		return fromLocationName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFromLocationName(String newFromLocationName) {
		String oldFromLocationName = fromLocationName;
		fromLocationName = newFromLocationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LINEAR_LOCATION_INFO__FROM_LOCATION_NAME, oldFromLocationName, fromLocationName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getFromLocationParentName() {
		return fromLocationParentName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFromLocationParentName(String newFromLocationParentName) {
		String oldFromLocationParentName = fromLocationParentName;
		fromLocationParentName = newFromLocationParentName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LINEAR_LOCATION_INFO__FROM_LOCATION_PARENT_NAME, oldFromLocationParentName, fromLocationParentName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getToLocationName() {
		return toLocationName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setToLocationName(String newToLocationName) {
		String oldToLocationName = toLocationName;
		toLocationName = newToLocationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LINEAR_LOCATION_INFO__TO_LOCATION_NAME, oldToLocationName, toLocationName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getToLocationParentName() {
		return toLocationParentName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setToLocationParentName(String newToLocationParentName) {
		String oldToLocationParentName = toLocationParentName;
		toLocationParentName = newToLocationParentName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LINEAR_LOCATION_INFO__TO_LOCATION_PARENT_NAME, oldToLocationParentName, toLocationParentName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Coordinate> getCoordinates() {
		if (coordinates == null) {
			coordinates = new EObjectContainmentEList<Coordinate>(Coordinate.class, this, LocationPackage.LINEAR_LOCATION_INFO__COORDINATES);
		}
		return coordinates;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LocationPackage.LINEAR_LOCATION_INFO__COORDINATES:
				return ((InternalEList<?>)getCoordinates()).basicRemove(otherEnd, msgs);
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
			case LocationPackage.LINEAR_LOCATION_INFO__FROM_LOCATION_NAME:
				return getFromLocationName();
			case LocationPackage.LINEAR_LOCATION_INFO__FROM_LOCATION_PARENT_NAME:
				return getFromLocationParentName();
			case LocationPackage.LINEAR_LOCATION_INFO__TO_LOCATION_NAME:
				return getToLocationName();
			case LocationPackage.LINEAR_LOCATION_INFO__TO_LOCATION_PARENT_NAME:
				return getToLocationParentName();
			case LocationPackage.LINEAR_LOCATION_INFO__COORDINATES:
				return getCoordinates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LocationPackage.LINEAR_LOCATION_INFO__FROM_LOCATION_NAME:
				setFromLocationName((String)newValue);
				return;
			case LocationPackage.LINEAR_LOCATION_INFO__FROM_LOCATION_PARENT_NAME:
				setFromLocationParentName((String)newValue);
				return;
			case LocationPackage.LINEAR_LOCATION_INFO__TO_LOCATION_NAME:
				setToLocationName((String)newValue);
				return;
			case LocationPackage.LINEAR_LOCATION_INFO__TO_LOCATION_PARENT_NAME:
				setToLocationParentName((String)newValue);
				return;
			case LocationPackage.LINEAR_LOCATION_INFO__COORDINATES:
				getCoordinates().clear();
				getCoordinates().addAll((Collection<? extends Coordinate>)newValue);
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
			case LocationPackage.LINEAR_LOCATION_INFO__FROM_LOCATION_NAME:
				setFromLocationName(FROM_LOCATION_NAME_EDEFAULT);
				return;
			case LocationPackage.LINEAR_LOCATION_INFO__FROM_LOCATION_PARENT_NAME:
				setFromLocationParentName(FROM_LOCATION_PARENT_NAME_EDEFAULT);
				return;
			case LocationPackage.LINEAR_LOCATION_INFO__TO_LOCATION_NAME:
				setToLocationName(TO_LOCATION_NAME_EDEFAULT);
				return;
			case LocationPackage.LINEAR_LOCATION_INFO__TO_LOCATION_PARENT_NAME:
				setToLocationParentName(TO_LOCATION_PARENT_NAME_EDEFAULT);
				return;
			case LocationPackage.LINEAR_LOCATION_INFO__COORDINATES:
				getCoordinates().clear();
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
			case LocationPackage.LINEAR_LOCATION_INFO__FROM_LOCATION_NAME:
				return FROM_LOCATION_NAME_EDEFAULT == null ? fromLocationName != null : !FROM_LOCATION_NAME_EDEFAULT.equals(fromLocationName);
			case LocationPackage.LINEAR_LOCATION_INFO__FROM_LOCATION_PARENT_NAME:
				return FROM_LOCATION_PARENT_NAME_EDEFAULT == null ? fromLocationParentName != null : !FROM_LOCATION_PARENT_NAME_EDEFAULT.equals(fromLocationParentName);
			case LocationPackage.LINEAR_LOCATION_INFO__TO_LOCATION_NAME:
				return TO_LOCATION_NAME_EDEFAULT == null ? toLocationName != null : !TO_LOCATION_NAME_EDEFAULT.equals(toLocationName);
			case LocationPackage.LINEAR_LOCATION_INFO__TO_LOCATION_PARENT_NAME:
				return TO_LOCATION_PARENT_NAME_EDEFAULT == null ? toLocationParentName != null : !TO_LOCATION_PARENT_NAME_EDEFAULT.equals(toLocationParentName);
			case LocationPackage.LINEAR_LOCATION_INFO__COORDINATES:
				return coordinates != null && !coordinates.isEmpty();
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
		result.append(" (fromLocationName: ");
		result.append(fromLocationName);
		result.append(", fromLocationParentName: ");
		result.append(fromLocationParentName);
		result.append(", toLocationName: ");
		result.append(toLocationName);
		result.append(", toLocationParentName: ");
		result.append(toLocationParentName);
		result.append(')');
		return result.toString();
	}

} //LinearLocationInfoImpl
