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
import org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit;
import org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Temporary Speed Limit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitImpl#getSpeedLimitSection <em>Speed Limit Section</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitImpl#isUnitsMPH <em>Units MPH</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitImpl#getVehicleRestriction <em>Vehicle Restriction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemporarySpeedLimitImpl extends EObjectImpl implements TemporarySpeedLimit {
	/**
	 * The cached value of the '{@link #getSpeedLimitSection() <em>Speed Limit Section</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedLimitSection()
	 * @generated
	 * @ordered
	 */
	protected EList<TemporarySpeedLimitSection> speedLimitSection;

	/**
	 * The default value of the '{@link #isUnitsMPH() <em>Units MPH</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnitsMPH()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNITS_MPH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnitsMPH() <em>Units MPH</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnitsMPH()
	 * @generated
	 * @ordered
	 */
	protected boolean unitsMPH = UNITS_MPH_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final Integer OFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected Integer offset = OFFSET_EDEFAULT;

	/**
	 * This is true if the Offset attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean offsetESet;

	/**
	 * The cached value of the '{@link #getVehicleRestriction() <em>Vehicle Restriction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleRestriction()
	 * @generated
	 * @ordered
	 */
	protected EList<VehicleRestriction> vehicleRestriction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemporarySpeedLimitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventPackage.Literals.TEMPORARY_SPEED_LIMIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemporarySpeedLimitSection> getSpeedLimitSection() {
		if (speedLimitSection == null) {
			speedLimitSection = new EObjectContainmentEList<TemporarySpeedLimitSection>(TemporarySpeedLimitSection.class, this, EventPackage.TEMPORARY_SPEED_LIMIT__SPEED_LIMIT_SECTION);
		}
		return speedLimitSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnitsMPH() {
		return unitsMPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitsMPH(boolean newUnitsMPH) {
		boolean oldUnitsMPH = unitsMPH;
		unitsMPH = newUnitsMPH;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.TEMPORARY_SPEED_LIMIT__UNITS_MPH, oldUnitsMPH, unitsMPH));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffset(Integer newOffset) {
		Integer oldOffset = offset;
		offset = newOffset;
		boolean oldOffsetESet = offsetESet;
		offsetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.TEMPORARY_SPEED_LIMIT__OFFSET, oldOffset, offset, !oldOffsetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOffset() {
		Integer oldOffset = offset;
		boolean oldOffsetESet = offsetESet;
		offset = OFFSET_EDEFAULT;
		offsetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.TEMPORARY_SPEED_LIMIT__OFFSET, oldOffset, OFFSET_EDEFAULT, oldOffsetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOffset() {
		return offsetESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VehicleRestriction> getVehicleRestriction() {
		if (vehicleRestriction == null) {
			vehicleRestriction = new EObjectContainmentEList<VehicleRestriction>(VehicleRestriction.class, this, EventPackage.TEMPORARY_SPEED_LIMIT__VEHICLE_RESTRICTION);
		}
		return vehicleRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventPackage.TEMPORARY_SPEED_LIMIT__SPEED_LIMIT_SECTION:
				return ((InternalEList<?>)getSpeedLimitSection()).basicRemove(otherEnd, msgs);
			case EventPackage.TEMPORARY_SPEED_LIMIT__VEHICLE_RESTRICTION:
				return ((InternalEList<?>)getVehicleRestriction()).basicRemove(otherEnd, msgs);
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
			case EventPackage.TEMPORARY_SPEED_LIMIT__SPEED_LIMIT_SECTION:
				return getSpeedLimitSection();
			case EventPackage.TEMPORARY_SPEED_LIMIT__UNITS_MPH:
				return isUnitsMPH();
			case EventPackage.TEMPORARY_SPEED_LIMIT__OFFSET:
				return getOffset();
			case EventPackage.TEMPORARY_SPEED_LIMIT__VEHICLE_RESTRICTION:
				return getVehicleRestriction();
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
			case EventPackage.TEMPORARY_SPEED_LIMIT__SPEED_LIMIT_SECTION:
				getSpeedLimitSection().clear();
				getSpeedLimitSection().addAll((Collection<? extends TemporarySpeedLimitSection>)newValue);
				return;
			case EventPackage.TEMPORARY_SPEED_LIMIT__UNITS_MPH:
				setUnitsMPH((Boolean)newValue);
				return;
			case EventPackage.TEMPORARY_SPEED_LIMIT__OFFSET:
				setOffset((Integer)newValue);
				return;
			case EventPackage.TEMPORARY_SPEED_LIMIT__VEHICLE_RESTRICTION:
				getVehicleRestriction().clear();
				getVehicleRestriction().addAll((Collection<? extends VehicleRestriction>)newValue);
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
			case EventPackage.TEMPORARY_SPEED_LIMIT__SPEED_LIMIT_SECTION:
				getSpeedLimitSection().clear();
				return;
			case EventPackage.TEMPORARY_SPEED_LIMIT__UNITS_MPH:
				setUnitsMPH(UNITS_MPH_EDEFAULT);
				return;
			case EventPackage.TEMPORARY_SPEED_LIMIT__OFFSET:
				unsetOffset();
				return;
			case EventPackage.TEMPORARY_SPEED_LIMIT__VEHICLE_RESTRICTION:
				getVehicleRestriction().clear();
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
			case EventPackage.TEMPORARY_SPEED_LIMIT__SPEED_LIMIT_SECTION:
				return speedLimitSection != null && !speedLimitSection.isEmpty();
			case EventPackage.TEMPORARY_SPEED_LIMIT__UNITS_MPH:
				return unitsMPH != UNITS_MPH_EDEFAULT;
			case EventPackage.TEMPORARY_SPEED_LIMIT__OFFSET:
				return isSetOffset();
			case EventPackage.TEMPORARY_SPEED_LIMIT__VEHICLE_RESTRICTION:
				return vehicleRestriction != null && !vehicleRestriction.isEmpty();
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
		result.append(" (unitsMPH: ");
		result.append(unitsMPH);
		result.append(", offset: ");
		if (offsetESet) result.append(offset); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TemporarySpeedLimitImpl
