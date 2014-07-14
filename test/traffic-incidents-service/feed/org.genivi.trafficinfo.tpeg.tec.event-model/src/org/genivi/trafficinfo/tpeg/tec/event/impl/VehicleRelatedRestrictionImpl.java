/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event.impl;



import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.trafficinfo.tpeg.tec.event.EventPackage;
import org.genivi.trafficinfo.tpeg.tec.event.RestrictionType;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vehicle Related Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRelatedRestrictionImpl#getRestrictionType <em>Restriction Type</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRelatedRestrictionImpl#getRestrictionValue <em>Restriction Value</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRelatedRestrictionImpl#getRestrictionLocation <em>Restriction Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VehicleRelatedRestrictionImpl extends EObjectImpl implements VehicleRelatedRestriction {
  /**
	 * The default value of the '{@link #getRestrictionType() <em>Restriction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRestrictionType()
	 * @generated
	 * @ordered
	 */
  protected static final RestrictionType RESTRICTION_TYPE_EDEFAULT = RestrictionType.WIDTH_LESS_THAN;

  /**
	 * The cached value of the '{@link #getRestrictionType() <em>Restriction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRestrictionType()
	 * @generated
	 * @ordered
	 */
  protected RestrictionType restrictionType = RESTRICTION_TYPE_EDEFAULT;

  /**
	 * This is true if the Restriction Type attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean restrictionTypeESet;

  /**
	 * The default value of the '{@link #getRestrictionValue() <em>Restriction Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRestrictionValue()
	 * @generated
	 * @ordered
	 */
  protected static final Integer RESTRICTION_VALUE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getRestrictionValue() <em>Restriction Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRestrictionValue()
	 * @generated
	 * @ordered
	 */
  protected Integer restrictionValue = RESTRICTION_VALUE_EDEFAULT;

  /**
	 * This is true if the Restriction Value attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean restrictionValueESet;

  /**
	 * The cached value of the '{@link #getRestrictionLocation() <em>Restriction Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRestrictionLocation()
	 * @generated
	 * @ordered
	 */
  protected LocationReferencingContainer restrictionLocation;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected VehicleRelatedRestrictionImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return EventPackage.Literals.VEHICLE_RELATED_RESTRICTION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RestrictionType getRestrictionType() {
		return restrictionType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRestrictionType(RestrictionType newRestrictionType) {
		RestrictionType oldRestrictionType = restrictionType;
		restrictionType = newRestrictionType == null ? RESTRICTION_TYPE_EDEFAULT : newRestrictionType;
		boolean oldRestrictionTypeESet = restrictionTypeESet;
		restrictionTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_TYPE, oldRestrictionType, restrictionType, !oldRestrictionTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetRestrictionType() {
		RestrictionType oldRestrictionType = restrictionType;
		boolean oldRestrictionTypeESet = restrictionTypeESet;
		restrictionType = RESTRICTION_TYPE_EDEFAULT;
		restrictionTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_TYPE, oldRestrictionType, RESTRICTION_TYPE_EDEFAULT, oldRestrictionTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetRestrictionType() {
		return restrictionTypeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getRestrictionValue() {
		return restrictionValue;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRestrictionValue(Integer newRestrictionValue) {
		Integer oldRestrictionValue = restrictionValue;
		restrictionValue = newRestrictionValue;
		boolean oldRestrictionValueESet = restrictionValueESet;
		restrictionValueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_VALUE, oldRestrictionValue, restrictionValue, !oldRestrictionValueESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetRestrictionValue() {
		Integer oldRestrictionValue = restrictionValue;
		boolean oldRestrictionValueESet = restrictionValueESet;
		restrictionValue = RESTRICTION_VALUE_EDEFAULT;
		restrictionValueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_VALUE, oldRestrictionValue, RESTRICTION_VALUE_EDEFAULT, oldRestrictionValueESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetRestrictionValue() {
		return restrictionValueESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LocationReferencingContainer getRestrictionLocation() {
		return restrictionLocation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetRestrictionLocation(LocationReferencingContainer newRestrictionLocation, NotificationChain msgs) {
		LocationReferencingContainer oldRestrictionLocation = restrictionLocation;
		restrictionLocation = newRestrictionLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION, oldRestrictionLocation, newRestrictionLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRestrictionLocation(LocationReferencingContainer newRestrictionLocation) {
		if (newRestrictionLocation != restrictionLocation) {
			NotificationChain msgs = null;
			if (restrictionLocation != null)
				msgs = ((InternalEObject)restrictionLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION, null, msgs);
			if (newRestrictionLocation != null)
				msgs = ((InternalEObject)newRestrictionLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION, null, msgs);
			msgs = basicSetRestrictionLocation(newRestrictionLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION, newRestrictionLocation, newRestrictionLocation));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION:
				return basicSetRestrictionLocation(null, msgs);
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
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_TYPE:
				return getRestrictionType();
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_VALUE:
				return getRestrictionValue();
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION:
				return getRestrictionLocation();
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
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_TYPE:
				setRestrictionType((RestrictionType)newValue);
				return;
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_VALUE:
				setRestrictionValue((Integer)newValue);
				return;
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION:
				setRestrictionLocation((LocationReferencingContainer)newValue);
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
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_TYPE:
				unsetRestrictionType();
				return;
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_VALUE:
				unsetRestrictionValue();
				return;
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION:
				setRestrictionLocation((LocationReferencingContainer)null);
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
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_TYPE:
				return isSetRestrictionType();
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_VALUE:
				return isSetRestrictionValue();
			case EventPackage.VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION:
				return restrictionLocation != null;
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
		result.append(" (restrictionType: ");
		if (restrictionTypeESet) result.append(restrictionType); else result.append("<unset>");
		result.append(", restrictionValue: ");
		if (restrictionValueESet) result.append(restrictionValue); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //VehicleRelatedRestrictionImpl
