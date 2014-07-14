/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XTrafficIncidentFactoryImpl extends EFactoryImpl implements XTrafficIncidentFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static XTrafficIncidentFactory init() {
		try {
			XTrafficIncidentFactory theXTrafficIncidentFactory = (XTrafficIncidentFactory)EPackage.Registry.INSTANCE.getEFactory(XTrafficIncidentPackage.eNS_URI);
			if (theXTrafficIncidentFactory != null) {
				return theXTrafficIncidentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XTrafficIncidentFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public XTrafficIncidentFactoryImpl() {
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
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT: return createTrafficIncident();
			case XTrafficIncidentPackage.CAUSE: return createCause();
			case XTrafficIncidentPackage.LINKED_CAUSE: return createLinkedCause();
			case XTrafficIncidentPackage.DIRECT_CAUSE: return createDirectCause();
			case XTrafficIncidentPackage.LANE_RESTRICTIONS: return createLaneRestrictions();
			case XTrafficIncidentPackage.ADVICE: return createAdvice();
			case XTrafficIncidentPackage.APPLICABILITY: return createApplicability();
			case XTrafficIncidentPackage.VEHICLE_RELATED_RESTRICTION: return createVehicleRelatedRestriction();
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT_SECTION: return createTemporarySpeedLimitSection();
			case XTrafficIncidentPackage.TEMPORARY_SPEED_LIMIT: return createTemporarySpeedLimit();
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
	public TemporarySpeedLimitSection createTemporarySpeedLimitSection() {
		TemporarySpeedLimitSectionImpl temporarySpeedLimitSection = new TemporarySpeedLimitSectionImpl();
		return temporarySpeedLimitSection;
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
  public XTrafficIncidentPackage getXTrafficIncidentPackage() {
		return (XTrafficIncidentPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static XTrafficIncidentPackage getPackage() {
		return XTrafficIncidentPackage.eINSTANCE;
	}

} //XTrafficIncidentFactoryImpl
