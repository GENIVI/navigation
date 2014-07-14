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
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linked Cause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LinkedCauseImpl#getCauseTrafficIncidentId <em>Cause Traffic Incident Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkedCauseImpl extends CauseImpl implements LinkedCause {
  /**
	 * The default value of the '{@link #getCauseTrafficIncidentId() <em>Cause Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCauseTrafficIncidentId()
	 * @generated
	 * @ordered
	 */
  protected static final Integer CAUSE_TRAFFIC_INCIDENT_ID_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getCauseTrafficIncidentId() <em>Cause Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCauseTrafficIncidentId()
	 * @generated
	 * @ordered
	 */
  protected Integer causeTrafficIncidentId = CAUSE_TRAFFIC_INCIDENT_ID_EDEFAULT;

  /**
	 * This is true if the Cause Traffic Incident Id attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean causeTrafficIncidentIdESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected LinkedCauseImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return trafficincidentPackage.Literals.LINKED_CAUSE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getCauseTrafficIncidentId() {
		return causeTrafficIncidentId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCauseTrafficIncidentId(Integer newCauseTrafficIncidentId) {
		Integer oldCauseTrafficIncidentId = causeTrafficIncidentId;
		causeTrafficIncidentId = newCauseTrafficIncidentId;
		boolean oldCauseTrafficIncidentIdESet = causeTrafficIncidentIdESet;
		causeTrafficIncidentIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.LINKED_CAUSE__CAUSE_TRAFFIC_INCIDENT_ID, oldCauseTrafficIncidentId, causeTrafficIncidentId, !oldCauseTrafficIncidentIdESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetCauseTrafficIncidentId() {
		Integer oldCauseTrafficIncidentId = causeTrafficIncidentId;
		boolean oldCauseTrafficIncidentIdESet = causeTrafficIncidentIdESet;
		causeTrafficIncidentId = CAUSE_TRAFFIC_INCIDENT_ID_EDEFAULT;
		causeTrafficIncidentIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.LINKED_CAUSE__CAUSE_TRAFFIC_INCIDENT_ID, oldCauseTrafficIncidentId, CAUSE_TRAFFIC_INCIDENT_ID_EDEFAULT, oldCauseTrafficIncidentIdESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetCauseTrafficIncidentId() {
		return causeTrafficIncidentIdESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trafficincidentPackage.LINKED_CAUSE__CAUSE_TRAFFIC_INCIDENT_ID:
				return getCauseTrafficIncidentId();
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
			case trafficincidentPackage.LINKED_CAUSE__CAUSE_TRAFFIC_INCIDENT_ID:
				setCauseTrafficIncidentId((Integer)newValue);
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
			case trafficincidentPackage.LINKED_CAUSE__CAUSE_TRAFFIC_INCIDENT_ID:
				unsetCauseTrafficIncidentId();
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
			case trafficincidentPackage.LINKED_CAUSE__CAUSE_TRAFFIC_INCIDENT_ID:
				return isSetCauseTrafficIncidentId();
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
		result.append(" (causeTrafficIncidentId: ");
		if (causeTrafficIncidentIdESet) result.append(causeTrafficIncidentId); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //LinkedCauseImpl
