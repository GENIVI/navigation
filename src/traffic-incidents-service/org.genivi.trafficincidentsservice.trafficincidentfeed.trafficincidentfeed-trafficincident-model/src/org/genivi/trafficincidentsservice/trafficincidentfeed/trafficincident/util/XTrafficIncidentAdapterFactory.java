/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage
 * @generated
 */
public class XTrafficIncidentAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static XTrafficIncidentPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public XTrafficIncidentAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = XTrafficIncidentPackage.eINSTANCE;
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
  protected XTrafficIncidentSwitch<Adapter> modelSwitch =
    new XTrafficIncidentSwitch<Adapter>() {
			@Override
			public Adapter caseTrafficIncident(TrafficIncident object) {
				return createTrafficIncidentAdapter();
			}
			@Override
			public Adapter caseCause(Cause object) {
				return createCauseAdapter();
			}
			@Override
			public Adapter caseLinkedCause(LinkedCause object) {
				return createLinkedCauseAdapter();
			}
			@Override
			public Adapter caseDirectCause(DirectCause object) {
				return createDirectCauseAdapter();
			}
			@Override
			public Adapter caseLaneRestrictions(LaneRestrictions object) {
				return createLaneRestrictionsAdapter();
			}
			@Override
			public Adapter caseAdvice(Advice object) {
				return createAdviceAdapter();
			}
			@Override
			public Adapter caseApplicability(Applicability object) {
				return createApplicabilityAdapter();
			}
			@Override
			public Adapter caseVehicleRelatedRestriction(VehicleRelatedRestriction object) {
				return createVehicleRelatedRestrictionAdapter();
			}
			@Override
			public Adapter caseTemporarySpeedLimitSection(TemporarySpeedLimitSection object) {
				return createTemporarySpeedLimitSectionAdapter();
			}
			@Override
			public Adapter caseTemporarySpeedLimit(TemporarySpeedLimit object) {
				return createTemporarySpeedLimitAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident <em>Traffic Incident</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident
	 * @generated
	 */
  public Adapter createTrafficIncidentAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause
	 * @generated
	 */
  public Adapter createCauseAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause <em>Linked Cause</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause
	 * @generated
	 */
  public Adapter createLinkedCauseAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause <em>Direct Cause</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause
	 * @generated
	 */
  public Adapter createDirectCauseAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions <em>Lane Restrictions</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions
	 * @generated
	 */
  public Adapter createLaneRestrictionsAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice
	 * @generated
	 */
  public Adapter createAdviceAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability
	 * @generated
	 */
  public Adapter createApplicabilityAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction <em>Vehicle Related Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction
	 * @generated
	 */
  public Adapter createVehicleRelatedRestrictionAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection <em>Temporary Speed Limit Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection
	 * @generated
	 */
	public Adapter createTemporarySpeedLimitSectionAdapter() {
		return null;
	}

		/**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit <em>Temporary Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit
	 * @generated
	 */
	public Adapter createTemporarySpeedLimitAdapter() {
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

} //XTrafficIncidentAdapterFactory
