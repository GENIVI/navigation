/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage
 * @generated
 */
public interface trafficincidentsserviceFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  trafficincidentsserviceFactory eINSTANCE = org.genivi.trafficincidentsservice.impl.trafficincidentsserviceFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Traffic Incidents</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traffic Incidents</em>'.
	 * @generated
	 */
  TrafficIncidents createTrafficIncidents();

  /**
	 * Returns a new object of class '<em>Traffic Incidents Listener</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traffic Incidents Listener</em>'.
	 * @generated
	 */
  TrafficIncidentsListener createTrafficIncidentsListener();

  /**
	 * Returns a new object of class '<em>Traffic Incident Feed</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traffic Incident Feed</em>'.
	 * @generated
	 */
  TrafficIncidentFeed createTrafficIncidentFeed();

  /**
	 * Returns a new object of class '<em>Traffic Incident Feed Listener</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traffic Incident Feed Listener</em>'.
	 * @generated
	 */
  TrafficIncidentFeedListener createTrafficIncidentFeedListener();

  /**
	 * Returns a new object of class '<em>Feed Information</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feed Information</em>'.
	 * @generated
	 */
  FeedInformation createFeedInformation();

  /**
	 * Returns a new object of class '<em>Category Definition</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category Definition</em>'.
	 * @generated
	 */
  CategoryDefinition createCategoryDefinition();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  trafficincidentsservicePackage gettrafficincidentsservicePackage();

} //trafficincidentsserviceFactory
