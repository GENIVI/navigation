/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage
 * @generated
 */
public class trafficincidentsserviceAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static trafficincidentsservicePackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public trafficincidentsserviceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = trafficincidentsservicePackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected trafficincidentsserviceSwitch<Adapter> modelSwitch =
    new trafficincidentsserviceSwitch<Adapter>() {
			@Override
			public Adapter caseTrafficIncidents(TrafficIncidents object) {
				return createTrafficIncidentsAdapter();
			}
			@Override
			public Adapter caseTrafficIncidentsListener(TrafficIncidentsListener object) {
				return createTrafficIncidentsListenerAdapter();
			}
			@Override
			public Adapter caseTrafficIncidentFeed(TrafficIncidentFeed object) {
				return createTrafficIncidentFeedAdapter();
			}
			@Override
			public Adapter caseTrafficIncidentFeedListener(TrafficIncidentFeedListener object) {
				return createTrafficIncidentFeedListenerAdapter();
			}
			@Override
			public Adapter caseFeedInformation(FeedInformation object) {
				return createFeedInformationAdapter();
			}
			@Override
			public Adapter caseCategoryDefinition(CategoryDefinition object) {
				return createCategoryDefinitionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.TrafficIncidents <em>Traffic Incidents</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidents
	 * @generated
	 */
  public Adapter createTrafficIncidentsAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.TrafficIncidentsListener <em>Traffic Incidents Listener</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentsListener
	 * @generated
	 */
  public Adapter createTrafficIncidentsListenerAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.TrafficIncidentFeed <em>Traffic Incident Feed</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentFeed
	 * @generated
	 */
  public Adapter createTrafficIncidentFeedAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.TrafficIncidentFeedListener <em>Traffic Incident Feed Listener</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentFeedListener
	 * @generated
	 */
  public Adapter createTrafficIncidentFeedListenerAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.CategoryDefinition <em>Category Definition</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.CategoryDefinition
	 * @generated
	 */
  public Adapter createCategoryDefinitionAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.FeedInformation <em>Feed Information</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.FeedInformation
	 * @generated
	 */
  public Adapter createFeedInformationAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter() {
		return null;
	}

} //trafficincidentsserviceAdapterFactory
