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
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Temporary Speed Limit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitImpl#getTemporarySpeedLimitSections <em>Temporary Speed Limit Sections</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitImpl#isUnitsMPH <em>Units MPH</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitImpl#getApplicability <em>Applicability</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemporarySpeedLimitImpl extends EObjectImpl implements TemporarySpeedLimit {
	/**
	 * The cached value of the '{@link #getTemporarySpeedLimitSections() <em>Temporary Speed Limit Sections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemporarySpeedLimitSections()
	 * @generated
	 * @ordered
	 */
	protected EList<TemporarySpeedLimitSection> temporarySpeedLimitSections;

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
	 * The cached value of the '{@link #getApplicability() <em>Applicability</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicability()
	 * @generated
	 * @ordered
	 */
	protected EList<Applicability> applicability;

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
		return XTrafficIncidentPackage.Literals.TEMPORARY_SPEED_LIMIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemporarySpeedLimitSection> getTemporarySpeedLimitSections() {
		if (temporarySpeedLimitSections == null) {
			temporarySpeedLimitSections = new EObjectContainmentEList<TemporarySpeedLimitSection>(TemporarySpeedLimitSection.class, this, XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__TEMPORARY_SPEED_LIMIT_SECTIONS);
		}
		return temporarySpeedLimitSections;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__UNITS_MPH, oldUnitsMPH, unitsMPH));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__OFFSET, oldOffset, offset, !oldOffsetESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__OFFSET, oldOffset, OFFSET_EDEFAULT, oldOffsetESet));
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
	public EList<Applicability> getApplicability() {
		if (applicability == null) {
			applicability = new EObjectContainmentEList<Applicability>(Applicability.class, this, XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__APPLICABILITY);
		}
		return applicability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__TEMPORARY_SPEED_LIMIT_SECTIONS:
				return ((InternalEList<?>)getTemporarySpeedLimitSections()).basicRemove(otherEnd, msgs);
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__APPLICABILITY:
				return ((InternalEList<?>)getApplicability()).basicRemove(otherEnd, msgs);
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
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__TEMPORARY_SPEED_LIMIT_SECTIONS:
				return getTemporarySpeedLimitSections();
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__UNITS_MPH:
				return isUnitsMPH();
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__OFFSET:
				return getOffset();
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__APPLICABILITY:
				return getApplicability();
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
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__TEMPORARY_SPEED_LIMIT_SECTIONS:
				getTemporarySpeedLimitSections().clear();
				getTemporarySpeedLimitSections().addAll((Collection<? extends TemporarySpeedLimitSection>)newValue);
				return;
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__UNITS_MPH:
				setUnitsMPH((Boolean)newValue);
				return;
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__OFFSET:
				setOffset((Integer)newValue);
				return;
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__APPLICABILITY:
				getApplicability().clear();
				getApplicability().addAll((Collection<? extends Applicability>)newValue);
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
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__TEMPORARY_SPEED_LIMIT_SECTIONS:
				getTemporarySpeedLimitSections().clear();
				return;
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__UNITS_MPH:
				setUnitsMPH(UNITS_MPH_EDEFAULT);
				return;
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__OFFSET:
				unsetOffset();
				return;
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__APPLICABILITY:
				getApplicability().clear();
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
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__TEMPORARY_SPEED_LIMIT_SECTIONS:
				return temporarySpeedLimitSections != null && !temporarySpeedLimitSections.isEmpty();
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__UNITS_MPH:
				return unitsMPH != UNITS_MPH_EDEFAULT;
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__OFFSET:
				return isSetOffset();
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT__APPLICABILITY:
				return applicability != null && !applicability.isEmpty();
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
