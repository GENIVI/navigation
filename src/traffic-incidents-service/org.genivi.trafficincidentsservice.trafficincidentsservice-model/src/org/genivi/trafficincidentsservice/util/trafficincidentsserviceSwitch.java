/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.genivi.trafficincidentsservice.*;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.FeedInformation;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TrafficIncidentFeed;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedListener;
import org.genivi.trafficincidentsservice.trafficincidentsservicePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage
 * @generated
 */
public class trafficincidentsserviceSwitch<T> extends Switch<T> {
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static trafficincidentsservicePackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public trafficincidentsserviceSwitch() {
		if (modelPackage == null) {
			modelPackage = trafficincidentsservicePackage.eINSTANCE;
		}
	}

  /**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case trafficincidentsservicePackage.TRAFFIC_INCIDENTS: {
				TrafficIncidents trafficIncidents = (TrafficIncidents)theEObject;
				T result = caseTrafficIncidents(trafficIncidents);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trafficincidentsservicePackage.TRAFFIC_INCIDENTS_LISTENER: {
				TrafficIncidentsListener trafficIncidentsListener = (TrafficIncidentsListener)theEObject;
				T result = caseTrafficIncidentsListener(trafficIncidentsListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trafficincidentsservicePackage.TRAFFIC_INCIDENT_FEED: {
				TrafficIncidentFeed trafficIncidentFeed = (TrafficIncidentFeed)theEObject;
				T result = caseTrafficIncidentFeed(trafficIncidentFeed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trafficincidentsservicePackage.TRAFFIC_INCIDENT_FEED_LISTENER: {
				TrafficIncidentFeedListener trafficIncidentFeedListener = (TrafficIncidentFeedListener)theEObject;
				T result = caseTrafficIncidentFeedListener(trafficIncidentFeedListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trafficincidentsservicePackage.FEED_INFORMATION: {
				FeedInformation feedInformation = (FeedInformation)theEObject;
				T result = caseFeedInformation(feedInformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trafficincidentsservicePackage.CATEGORY_DEFINITION: {
				CategoryDefinition categoryDefinition = (CategoryDefinition)theEObject;
				T result = caseCategoryDefinition(categoryDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Traffic Incidents</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traffic Incidents</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTrafficIncidents(TrafficIncidents object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Traffic Incidents Listener</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traffic Incidents Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTrafficIncidentsListener(TrafficIncidentsListener object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Traffic Incident Feed</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traffic Incident Feed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTrafficIncidentFeed(TrafficIncidentFeed object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Traffic Incident Feed Listener</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traffic Incident Feed Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTrafficIncidentFeedListener(TrafficIncidentFeedListener object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Feed Information</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feed Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseFeedInformation(FeedInformation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Category Definition</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCategoryDefinition(CategoryDefinition object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  @Override
  public T defaultCase(EObject object) {
		return null;
	}

} //trafficincidentsserviceSwitch
