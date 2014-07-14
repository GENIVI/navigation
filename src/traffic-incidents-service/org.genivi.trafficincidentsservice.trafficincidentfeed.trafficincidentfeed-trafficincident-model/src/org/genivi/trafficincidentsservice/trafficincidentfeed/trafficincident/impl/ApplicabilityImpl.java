/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl;

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

import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Applicability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.ApplicabilityImpl#getVehicleType <em>Vehicle Type</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.ApplicabilityImpl#getVehicleRelatedRestrictions <em>Vehicle Related Restrictions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicabilityImpl extends EObjectImpl implements Applicability {
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
	 * The cached value of the '{@link #getVehicleRelatedRestrictions() <em>Vehicle Related Restrictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVehicleRelatedRestrictions()
	 * @generated
	 * @ordered
	 */
  protected EList<VehicleRelatedRestriction> vehicleRelatedRestrictions;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ApplicabilityImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return XTrafficIncidentPackage.Literals.APPLICABILITY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.APPLICABILITY__VEHICLE_TYPE, oldVehicleType, vehicleType, !oldVehicleTypeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.APPLICABILITY__VEHICLE_TYPE, oldVehicleType, VEHICLE_TYPE_EDEFAULT, oldVehicleTypeESet));
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
  public EList<VehicleRelatedRestriction> getVehicleRelatedRestrictions() {
		if (vehicleRelatedRestrictions == null) {
			vehicleRelatedRestrictions = new EObjectContainmentEList.Unsettable<VehicleRelatedRestriction>(VehicleRelatedRestriction.class, this, XTrafficIncidentPackage.APPLICABILITY__VEHICLE_RELATED_RESTRICTIONS);
		}
		return vehicleRelatedRestrictions;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetVehicleRelatedRestrictions() {
		if (vehicleRelatedRestrictions != null) ((InternalEList.Unsettable<?>)vehicleRelatedRestrictions).unset();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetVehicleRelatedRestrictions() {
		return vehicleRelatedRestrictions != null && ((InternalEList.Unsettable<?>)vehicleRelatedRestrictions).isSet();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XTrafficIncidentPackage.APPLICABILITY__VEHICLE_RELATED_RESTRICTIONS:
				return ((InternalEList<?>)getVehicleRelatedRestrictions()).basicRemove(otherEnd, msgs);
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
			case XTrafficIncidentPackage.APPLICABILITY__VEHICLE_TYPE:
				return getVehicleType();
			case XTrafficIncidentPackage.APPLICABILITY__VEHICLE_RELATED_RESTRICTIONS:
				return getVehicleRelatedRestrictions();
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
			case XTrafficIncidentPackage.APPLICABILITY__VEHICLE_TYPE:
				setVehicleType((VehicleType)newValue);
				return;
			case XTrafficIncidentPackage.APPLICABILITY__VEHICLE_RELATED_RESTRICTIONS:
				getVehicleRelatedRestrictions().clear();
				getVehicleRelatedRestrictions().addAll((Collection<? extends VehicleRelatedRestriction>)newValue);
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
			case XTrafficIncidentPackage.APPLICABILITY__VEHICLE_TYPE:
				unsetVehicleType();
				return;
			case XTrafficIncidentPackage.APPLICABILITY__VEHICLE_RELATED_RESTRICTIONS:
				unsetVehicleRelatedRestrictions();
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
			case XTrafficIncidentPackage.APPLICABILITY__VEHICLE_TYPE:
				return isSetVehicleType();
			case XTrafficIncidentPackage.APPLICABILITY__VEHICLE_RELATED_RESTRICTIONS:
				return isSetVehicleRelatedRestrictions();
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

} //ApplicabilityImpl
