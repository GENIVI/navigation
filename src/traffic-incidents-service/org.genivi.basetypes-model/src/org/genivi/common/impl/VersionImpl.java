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
import org.genivi.common.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.common.impl.VersionImpl#getMajor <em>Major</em>}</li>
 *   <li>{@link org.genivi.common.impl.VersionImpl#getMinor <em>Minor</em>}</li>
 *   <li>{@link org.genivi.common.impl.VersionImpl#getMicro <em>Micro</em>}</li>
 *   <li>{@link org.genivi.common.impl.VersionImpl#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VersionImpl extends EObjectImpl implements Version {
  /**
	 * The default value of the '{@link #getMajor() <em>Major</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMajor()
	 * @generated
	 * @ordered
	 */
  protected static final int MAJOR_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getMajor() <em>Major</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMajor()
	 * @generated
	 * @ordered
	 */
  protected int major = MAJOR_EDEFAULT;

  /**
	 * This is true if the Major attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean majorESet;

  /**
	 * The default value of the '{@link #getMinor() <em>Minor</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMinor()
	 * @generated
	 * @ordered
	 */
  protected static final int MINOR_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getMinor() <em>Minor</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMinor()
	 * @generated
	 * @ordered
	 */
  protected int minor = MINOR_EDEFAULT;

  /**
	 * This is true if the Minor attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean minorESet;

  /**
	 * The default value of the '{@link #getMicro() <em>Micro</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMicro()
	 * @generated
	 * @ordered
	 */
  protected static final int MICRO_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getMicro() <em>Micro</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMicro()
	 * @generated
	 * @ordered
	 */
  protected int micro = MICRO_EDEFAULT;

  /**
	 * This is true if the Micro attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean microESet;

  /**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
  protected static final String DATE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
  protected String date = DATE_EDEFAULT;

  /**
	 * This is true if the Date attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean dateESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected VersionImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return CommonPackage.Literals.VERSION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getMajor() {
		return major;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMajor(int newMajor) {
		int oldMajor = major;
		major = newMajor;
		boolean oldMajorESet = majorESet;
		majorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.VERSION__MAJOR, oldMajor, major, !oldMajorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetMajor() {
		int oldMajor = major;
		boolean oldMajorESet = majorESet;
		major = MAJOR_EDEFAULT;
		majorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CommonPackage.VERSION__MAJOR, oldMajor, MAJOR_EDEFAULT, oldMajorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetMajor() {
		return majorESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getMinor() {
		return minor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMinor(int newMinor) {
		int oldMinor = minor;
		minor = newMinor;
		boolean oldMinorESet = minorESet;
		minorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.VERSION__MINOR, oldMinor, minor, !oldMinorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetMinor() {
		int oldMinor = minor;
		boolean oldMinorESet = minorESet;
		minor = MINOR_EDEFAULT;
		minorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CommonPackage.VERSION__MINOR, oldMinor, MINOR_EDEFAULT, oldMinorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetMinor() {
		return minorESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getMicro() {
		return micro;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMicro(int newMicro) {
		int oldMicro = micro;
		micro = newMicro;
		boolean oldMicroESet = microESet;
		microESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.VERSION__MICRO, oldMicro, micro, !oldMicroESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetMicro() {
		int oldMicro = micro;
		boolean oldMicroESet = microESet;
		micro = MICRO_EDEFAULT;
		microESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CommonPackage.VERSION__MICRO, oldMicro, MICRO_EDEFAULT, oldMicroESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetMicro() {
		return microESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getDate() {
		return date;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDate(String newDate) {
		String oldDate = date;
		date = newDate;
		boolean oldDateESet = dateESet;
		dateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.VERSION__DATE, oldDate, date, !oldDateESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetDate() {
		String oldDate = date;
		boolean oldDateESet = dateESet;
		date = DATE_EDEFAULT;
		dateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CommonPackage.VERSION__DATE, oldDate, DATE_EDEFAULT, oldDateESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetDate() {
		return dateESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.VERSION__MAJOR:
				return getMajor();
			case CommonPackage.VERSION__MINOR:
				return getMinor();
			case CommonPackage.VERSION__MICRO:
				return getMicro();
			case CommonPackage.VERSION__DATE:
				return getDate();
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
			case CommonPackage.VERSION__MAJOR:
				setMajor((Integer)newValue);
				return;
			case CommonPackage.VERSION__MINOR:
				setMinor((Integer)newValue);
				return;
			case CommonPackage.VERSION__MICRO:
				setMicro((Integer)newValue);
				return;
			case CommonPackage.VERSION__DATE:
				setDate((String)newValue);
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
			case CommonPackage.VERSION__MAJOR:
				unsetMajor();
				return;
			case CommonPackage.VERSION__MINOR:
				unsetMinor();
				return;
			case CommonPackage.VERSION__MICRO:
				unsetMicro();
				return;
			case CommonPackage.VERSION__DATE:
				unsetDate();
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
			case CommonPackage.VERSION__MAJOR:
				return isSetMajor();
			case CommonPackage.VERSION__MINOR:
				return isSetMinor();
			case CommonPackage.VERSION__MICRO:
				return isSetMicro();
			case CommonPackage.VERSION__DATE:
				return isSetDate();
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
		result.append(" (major: ");
		if (majorESet) result.append(major); else result.append("<unset>");
		result.append(", minor: ");
		if (minorESet) result.append(minor); else result.append("<unset>");
		result.append(", micro: ");
		if (microESet) result.append(micro); else result.append("<unset>");
		result.append(", date: ");
		if (dateESet) result.append(date); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //VersionImpl
