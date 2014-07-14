/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.CauseCode;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.CauseImpl#getMainCause <em>Main Cause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CauseImpl extends EObjectImpl implements Cause {
  /**
	 * The default value of the '{@link #getMainCause() <em>Main Cause</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMainCause()
	 * @generated
	 * @ordered
	 */
  protected static final CauseCode MAIN_CAUSE_EDEFAULT = CauseCode.TRAFFIC_CONGESTION;

  /**
	 * The cached value of the '{@link #getMainCause() <em>Main Cause</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMainCause()
	 * @generated
	 * @ordered
	 */
  protected CauseCode mainCause = MAIN_CAUSE_EDEFAULT;

  /**
	 * This is true if the Main Cause attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean mainCauseESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CauseImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return XTrafficIncidentPackage.Literals.CAUSE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CauseCode getMainCause() {
		return mainCause;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMainCause(CauseCode newMainCause) {
		CauseCode oldMainCause = mainCause;
		mainCause = newMainCause == null ? MAIN_CAUSE_EDEFAULT : newMainCause;
		boolean oldMainCauseESet = mainCauseESet;
		mainCauseESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.CAUSE__MAIN_CAUSE, oldMainCause, mainCause, !oldMainCauseESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetMainCause() {
		CauseCode oldMainCause = mainCause;
		boolean oldMainCauseESet = mainCauseESet;
		mainCause = MAIN_CAUSE_EDEFAULT;
		mainCauseESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.CAUSE__MAIN_CAUSE, oldMainCause, MAIN_CAUSE_EDEFAULT, oldMainCauseESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetMainCause() {
		return mainCauseESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XTrafficIncidentPackage.CAUSE__MAIN_CAUSE:
				return getMainCause();
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
			case XTrafficIncidentPackage.CAUSE__MAIN_CAUSE:
				setMainCause((CauseCode)newValue);
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
			case XTrafficIncidentPackage.CAUSE__MAIN_CAUSE:
				unsetMainCause();
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
			case XTrafficIncidentPackage.CAUSE__MAIN_CAUSE:
				return isSetMainCause();
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
		result.append(" (mainCause: ");
		if (mainCauseESet) result.append(mainCause); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //CauseImpl
