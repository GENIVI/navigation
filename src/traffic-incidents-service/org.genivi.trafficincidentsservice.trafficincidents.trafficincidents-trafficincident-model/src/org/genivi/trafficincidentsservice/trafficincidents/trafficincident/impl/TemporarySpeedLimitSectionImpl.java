/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Temporary Speed Limit Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitSectionImpl#getSpeedLimitValue <em>Speed Limit Value</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitSectionImpl#getSpeedLimitValueWet <em>Speed Limit Value Wet</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitSectionImpl#getSpeedLimitLength <em>Speed Limit Length</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemporarySpeedLimitSectionImpl extends EObjectImpl implements TemporarySpeedLimitSection {
	/**
	 * The default value of the '{@link #getSpeedLimitValue() <em>Speed Limit Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedLimitValue()
	 * @generated
	 * @ordered
	 */
	protected static final short SPEED_LIMIT_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSpeedLimitValue() <em>Speed Limit Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedLimitValue()
	 * @generated
	 * @ordered
	 */
	protected short speedLimitValue = SPEED_LIMIT_VALUE_EDEFAULT;

	/**
	 * This is true if the Speed Limit Value attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean speedLimitValueESet;

	/**
	 * The default value of the '{@link #getSpeedLimitValueWet() <em>Speed Limit Value Wet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedLimitValueWet()
	 * @generated
	 * @ordered
	 */
	protected static final short SPEED_LIMIT_VALUE_WET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSpeedLimitValueWet() <em>Speed Limit Value Wet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedLimitValueWet()
	 * @generated
	 * @ordered
	 */
	protected short speedLimitValueWet = SPEED_LIMIT_VALUE_WET_EDEFAULT;

	/**
	 * This is true if the Speed Limit Value Wet attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean speedLimitValueWetESet;

	/**
	 * The default value of the '{@link #getSpeedLimitLength() <em>Speed Limit Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedLimitLength()
	 * @generated
	 * @ordered
	 */
	protected static final Integer SPEED_LIMIT_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpeedLimitLength() <em>Speed Limit Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedLimitLength()
	 * @generated
	 * @ordered
	 */
	protected Integer speedLimitLength = SPEED_LIMIT_LENGTH_EDEFAULT;

	/**
	 * This is true if the Speed Limit Length attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean speedLimitLengthESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemporarySpeedLimitSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trafficincidentPackage.Literals.TEMPORARY_SPEED_LIMIT_SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getSpeedLimitValue() {
		return speedLimitValue;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSpeedLimitValue(short newSpeedLimitValue) {
		short oldSpeedLimitValue = speedLimitValue;
		speedLimitValue = newSpeedLimitValue;
		boolean oldSpeedLimitValueESet = speedLimitValueESet;
		speedLimitValueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE, oldSpeedLimitValue, speedLimitValue, !oldSpeedLimitValueESet));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpeedLimitValue() {
		short oldSpeedLimitValue = speedLimitValue;
		boolean oldSpeedLimitValueESet = speedLimitValueESet;
		speedLimitValue = SPEED_LIMIT_VALUE_EDEFAULT;
		speedLimitValueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE, oldSpeedLimitValue, SPEED_LIMIT_VALUE_EDEFAULT, oldSpeedLimitValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpeedLimitValue() {
		return speedLimitValueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getSpeedLimitValueWet() {
		return speedLimitValueWet;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSpeedLimitValueWet(short newSpeedLimitValueWet) {
		short oldSpeedLimitValueWet = speedLimitValueWet;
		speedLimitValueWet = newSpeedLimitValueWet;
		boolean oldSpeedLimitValueWetESet = speedLimitValueWetESet;
		speedLimitValueWetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE_WET, oldSpeedLimitValueWet, speedLimitValueWet, !oldSpeedLimitValueWetESet));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpeedLimitValueWet() {
		short oldSpeedLimitValueWet = speedLimitValueWet;
		boolean oldSpeedLimitValueWetESet = speedLimitValueWetESet;
		speedLimitValueWet = SPEED_LIMIT_VALUE_WET_EDEFAULT;
		speedLimitValueWetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE_WET, oldSpeedLimitValueWet, SPEED_LIMIT_VALUE_WET_EDEFAULT, oldSpeedLimitValueWetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpeedLimitValueWet() {
		return speedLimitValueWetESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getSpeedLimitLength() {
		return speedLimitLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeedLimitLength(Integer newSpeedLimitLength) {
		Integer oldSpeedLimitLength = speedLimitLength;
		speedLimitLength = newSpeedLimitLength;
		boolean oldSpeedLimitLengthESet = speedLimitLengthESet;
		speedLimitLengthESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_LENGTH, oldSpeedLimitLength, speedLimitLength, !oldSpeedLimitLengthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpeedLimitLength() {
		Integer oldSpeedLimitLength = speedLimitLength;
		boolean oldSpeedLimitLengthESet = speedLimitLengthESet;
		speedLimitLength = SPEED_LIMIT_LENGTH_EDEFAULT;
		speedLimitLengthESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_LENGTH, oldSpeedLimitLength, SPEED_LIMIT_LENGTH_EDEFAULT, oldSpeedLimitLengthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpeedLimitLength() {
		return speedLimitLengthESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE:
				return getSpeedLimitValue();
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE_WET:
				return getSpeedLimitValueWet();
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_LENGTH:
				return getSpeedLimitLength();
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
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE:
				setSpeedLimitValue((Short)newValue);
				return;
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE_WET:
				setSpeedLimitValueWet((Short)newValue);
				return;
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_LENGTH:
				setSpeedLimitLength((Integer)newValue);
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
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE:
				unsetSpeedLimitValue();
				return;
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE_WET:
				unsetSpeedLimitValueWet();
				return;
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_LENGTH:
				unsetSpeedLimitLength();
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
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE:
				return isSetSpeedLimitValue();
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE_WET:
				return isSetSpeedLimitValueWet();
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_LENGTH:
				return isSetSpeedLimitLength();
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
		result.append(" (speedLimitValue: ");
		if (speedLimitValueESet) result.append(speedLimitValue); else result.append("<unset>");
		result.append(", speedLimitValueWet: ");
		if (speedLimitValueWetESet) result.append(speedLimitValueWet); else result.append("<unset>");
		result.append(", speedLimitLength: ");
		if (speedLimitLengthESet) result.append(speedLimitLength); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TemporarySpeedLimitSectionImpl
