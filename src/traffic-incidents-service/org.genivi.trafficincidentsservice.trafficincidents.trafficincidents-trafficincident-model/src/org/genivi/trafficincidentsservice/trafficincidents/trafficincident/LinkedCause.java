/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linked Cause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause#getCauseTrafficIncidentId <em>Cause Traffic Incident Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getLinkedCause()
 * @model
 * @generated
 */
public interface LinkedCause extends Cause {
  /**
	 * Returns the value of the '<em><b>Cause Traffic Incident Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There can be a LinkedCause for which the linked TrafficIncident isn't available (to the application) yet. Therefore this atttibute is optional.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cause Traffic Incident Id</em>' attribute.
	 * @see #isSetCauseTrafficIncidentId()
	 * @see #unsetCauseTrafficIncidentId()
	 * @see #setCauseTrafficIncidentId(Integer)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getLinkedCause_CauseTrafficIncidentId()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getCauseTrafficIncidentId();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause#getCauseTrafficIncidentId <em>Cause Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cause Traffic Incident Id</em>' attribute.
	 * @see #isSetCauseTrafficIncidentId()
	 * @see #unsetCauseTrafficIncidentId()
	 * @see #getCauseTrafficIncidentId()
	 * @generated
	 */
  void setCauseTrafficIncidentId(Integer value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause#getCauseTrafficIncidentId <em>Cause Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetCauseTrafficIncidentId()
	 * @see #getCauseTrafficIncidentId()
	 * @see #setCauseTrafficIncidentId(Integer)
	 * @generated
	 */
  void unsetCauseTrafficIncidentId();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause#getCauseTrafficIncidentId <em>Cause Traffic Incident Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cause Traffic Incident Id</em>' attribute is set.
	 * @see #unsetCauseTrafficIncidentId()
	 * @see #getCauseTrafficIncidentId()
	 * @see #setCauseTrafficIncidentId(Integer)
	 * @generated
	 */
  boolean isSetCauseTrafficIncidentId();

} // LinkedCause
