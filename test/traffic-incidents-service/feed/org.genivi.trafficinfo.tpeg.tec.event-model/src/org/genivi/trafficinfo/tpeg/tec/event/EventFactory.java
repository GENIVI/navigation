/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage
 * @generated
 */
public interface EventFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  EventFactory eINSTANCE = org.genivi.trafficinfo.tpeg.tec.event.impl.EventFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
  Event createEvent();

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
	 * Returns a new object of class '<em>Advice</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Advice</em>'.
	 * @generated
	 */
  Advice createAdvice();

  /**
	 * Returns a new object of class '<em>Vehicle Restriction</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vehicle Restriction</em>'.
	 * @generated
	 */
  VehicleRestriction createVehicleRestriction();

  /**
	 * Returns a new object of class '<em>Vehicle Related Restriction</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vehicle Related Restriction</em>'.
	 * @generated
	 */
  VehicleRelatedRestriction createVehicleRelatedRestriction();

  /**
	 * Returns a new object of class '<em>TEC Message</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>TEC Message</em>'.
	 * @generated
	 */
  TECMessage createTECMessage();

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
  EventPackage getEventPackage();

} //EventFactory
