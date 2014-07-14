/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage
 * @generated
 */
public interface XTrafficIncidentFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  XTrafficIncidentFactory eINSTANCE = org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Traffic Incident</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traffic Incident</em>'.
	 * @generated
	 */
  TrafficIncident createTrafficIncident();

  /**
	 * Returns a new object of class '<em>Cause</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cause</em>'.
	 * @generated
	 */
  Cause createCause();

  /**
	 * Returns a new object of class '<em>Linked Cause</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linked Cause</em>'.
	 * @generated
	 */
  LinkedCause createLinkedCause();

  /**
	 * Returns a new object of class '<em>Direct Cause</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Direct Cause</em>'.
	 * @generated
	 */
  DirectCause createDirectCause();

  /**
	 * Returns a new object of class '<em>Lane Restrictions</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lane Restrictions</em>'.
	 * @generated
	 */
  LaneRestrictions createLaneRestrictions();

  /**
	 * Returns a new object of class '<em>Advice</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Advice</em>'.
	 * @generated
	 */
  Advice createAdvice();

  /**
	 * Returns a new object of class '<em>Applicability</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Applicability</em>'.
	 * @generated
	 */
  Applicability createApplicability();

  /**
	 * Returns a new object of class '<em>Vehicle Related Restriction</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vehicle Related Restriction</em>'.
	 * @generated
	 */
  VehicleRelatedRestriction createVehicleRelatedRestriction();

  /**
	 * Returns a new object of class '<em>Temporary Speed Limit Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Temporary Speed Limit Section</em>'.
	 * @generated
	 */
	TemporarySpeedLimitSection createTemporarySpeedLimitSection();

		/**
	 * Returns a new object of class '<em>Temporary Speed Limit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Temporary Speed Limit</em>'.
	 * @generated
	 */
	TemporarySpeedLimit createTemporarySpeedLimit();

		/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  XTrafficIncidentPackage getXTrafficIncidentPackage();

} //XTrafficIncidentFactory
