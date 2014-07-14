/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.genivi.trafficinfo.tpeg.tec.event.EventPackage;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vehicle Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRestrictionImpl#getVehicleType <em>Vehicle Type</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRestrictionImpl#getRestriction <em>Restriction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VehicleRestrictionImpl extends EObjectImpl implements VehicleRestriction {
  /**
	 * The default value of the '{@link #getVehicleType() <em>Vehicle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVehicleType()
	 * @generated
	 * @ordered
	 */
  protected static final VehicleType VEHICLE_TYPE_EDEFAULT = VehicleType.CAR;

  /**
	 * The cached value of the '{@link #getVehicleType() <em>Vehicle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVehicleType()
	 * @generated
	 * @ordered
	 */
  protected VehicleType vehicleType = VEHICLE_TYPE_EDEFAULT;

  /**
	 * This is true if the Vehicle Type attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean vehicleTypeESet;

  /**
	 * The cached value of the '{@link #getRestriction() <em>Restriction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRestriction()
	 * @generated
	 * @ordered
	 */
  protected EList<VehicleRelatedRestriction> restriction;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected VehicleRestrictionImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return EventPackage.Literals.VEHICLE_RESTRICTION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VehicleType getVehicleType() {
		return vehicleType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setVehicleType(VehicleType newVehicleType) {
		VehicleType oldVehicleType = vehicleType;
		vehicleType = newVehicleType == null ? VEHICLE_TYPE_EDEFAULT : newVehicleType;
		boolean oldVehicleTypeESet = vehicleTypeESet;
		vehicleTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.VEHICLE_RESTRICTION__VEHICLE_TYPE, oldVehicleType, vehicleType, !oldVehicleTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetVehicleType() {
		VehicleType oldVehicleType = vehicleType;
		boolean oldVehicleTypeESet = vehicleTypeESet;
		vehicleType = VEHICLE_TYPE_EDEFAULT;
		vehicleTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.VEHICLE_RESTRICTION__VEHICLE_TYPE, oldVehicleType, VEHICLE_TYPE_EDEFAULT, oldVehicleTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetVehicleType() {
		return vehicleTypeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<VehicleRelatedRestriction> getRestriction() {
		if (restriction == null) {
			restriction = new EObjectContainmentEList<VehicleRelatedRestriction>(VehicleRelatedRestriction.class, this, EventPackage.VEHICLE_RESTRICTION__RESTRICTION);
		}
		return restriction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventPackage.VEHICLE_RESTRICTION__RESTRICTION:
				return ((InternalEList<?>)getRestriction()).basicRemove(otherEnd, msgs);
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
			case EventPackage.VEHICLE_RESTRICTION__VEHICLE_TYPE:
				return getVehicleType();
			case EventPackage.VEHICLE_RESTRICTION__RESTRICTION:
				return getRestriction();
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
			case EventPackage.VEHICLE_RESTRICTION__VEHICLE_TYPE:
				setVehicleType((VehicleType)newValue);
				return;
			case EventPackage.VEHICLE_RESTRICTION__RESTRICTION:
				getRestriction().clear();
				getRestriction().addAll((Collection<? extends VehicleRelatedRestriction>)newValue);
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
			case EventPackage.VEHICLE_RESTRICTION__VEHICLE_TYPE:
				unsetVehicleType();
				return;
			case EventPackage.VEHICLE_RESTRICTION__RESTRICTION:
				getRestriction().clear();
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
			case EventPackage.VEHICLE_RESTRICTION__VEHICLE_TYPE:
				return isSetVehicleType();
			case EventPackage.VEHICLE_RESTRICTION__RESTRICTION:
				return restriction != null && !restriction.isEmpty();
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
		result.append(" (vehicleType: ");
		if (vehicleTypeESet) result.append(vehicleType); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //VehicleRestrictionImpl
