/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class trafficincidentFactoryImpl extends EFactoryImpl implements trafficincidentFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static trafficincidentFactory init() {
		try {
			trafficincidentFactory thetrafficincidentFactory = (trafficincidentFactory)EPackage.Registry.INSTANCE.getEFactory(trafficincidentPackage.eNS_URI);
			if (thetrafficincidentFactory != null) {
				return thetrafficincidentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new trafficincidentFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public trafficincidentFactoryImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case trafficincidentPackage.TRAFFIC_INCIDENT: return createTrafficIncident();
			case trafficincidentPackage.CAUSE: return createCause();
			case trafficincidentPackage.LINKED_CAUSE: return createLinkedCause();
			case trafficincidentPackage.DIRECT_CAUSE: return createDirectCause();
			case trafficincidentPackage.LANE_RESTRICTIONS: return createLaneRestrictions();
			case trafficincidentPackage.ADVICE: return createAdvice();
			case trafficincidentPackage.APPLICABILITY: return createApplicability();
			case trafficincidentPackage.VEHICLE_RELATED_RESTRICTION: return createVehicleRelatedRestriction();
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT: return createTemporarySpeedLimit();
			case trafficincidentPackage.TEMPORARY_SPEED_LIMIT_SECTION: return createTemporarySpeedLimitSection();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficIncident createTrafficIncident() {
		TrafficIncidentImpl trafficIncident = new TrafficIncidentImpl();
		return trafficIncident;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Cause createCause() {
		CauseImpl cause = new CauseImpl();
		return cause;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LinkedCause createLinkedCause() {
		LinkedCauseImpl linkedCause = new LinkedCauseImpl();
		return linkedCause;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DirectCause createDirectCause() {
		DirectCauseImpl directCause = new DirectCauseImpl();
		return directCause;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LaneRestrictions createLaneRestrictions() {
		LaneRestrictionsImpl laneRestrictions = new LaneRestrictionsImpl();
		return laneRestrictions;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Advice createAdvice() {
		AdviceImpl advice = new AdviceImpl();
		return advice;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Applicability createApplicability() {
		ApplicabilityImpl applicability = new ApplicabilityImpl();
		return applicability;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VehicleRelatedRestriction createVehicleRelatedRestriction() {
		VehicleRelatedRestrictionImpl vehicleRelatedRestriction = new VehicleRelatedRestrictionImpl();
		return vehicleRelatedRestriction;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemporarySpeedLimit createTemporarySpeedLimit() {
		TemporarySpeedLimitImpl temporarySpeedLimit = new TemporarySpeedLimitImpl();
		return temporarySpeedLimit;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemporarySpeedLimitSection createTemporarySpeedLimitSection() {
		TemporarySpeedLimitSectionImpl temporarySpeedLimitSection = new TemporarySpeedLimitSectionImpl();
		return temporarySpeedLimitSection;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public trafficincidentPackage gettrafficincidentPackage() {
		return (trafficincidentPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static trafficincidentPackage getPackage() {
		return trafficincidentPackage.eINSTANCE;
	}

} //trafficincidentFactoryImpl
