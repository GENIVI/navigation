/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genivi.common.CommonPackage;

import org.genivi.locref.locrefPackage;

import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentFactory;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XTrafficIncidentPackageImpl extends EPackageImpl implements XTrafficIncidentPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass trafficIncidentEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass causeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass linkedCauseEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass directCauseEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass laneRestrictionsEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass adviceEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass applicabilityEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass vehicleRelatedRestrictionEClass = null;

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass temporarySpeedLimitSectionEClass = null;

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass temporarySpeedLimitEClass = null;

		/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private XTrafficIncidentPackageImpl() {
		super(eNS_URI, XTrafficIncidentFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link XTrafficIncidentPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static XTrafficIncidentPackage init() {
		if (isInited) return (XTrafficIncidentPackage)EPackage.Registry.INSTANCE.getEPackage(XTrafficIncidentPackage.eNS_URI);

		// Obtain or create and register package
		XTrafficIncidentPackageImpl theXTrafficIncidentPackage = (XTrafficIncidentPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XTrafficIncidentPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XTrafficIncidentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		locrefPackage.eINSTANCE.eClass();
		trafficincidenttablesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theXTrafficIncidentPackage.createPackageContents();

		// Initialize created meta-data
		theXTrafficIncidentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXTrafficIncidentPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XTrafficIncidentPackage.eNS_URI, theXTrafficIncidentPackage);
		return theXTrafficIncidentPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTrafficIncident() {
		return trafficIncidentEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_EffectCode() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_StartTime() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_StopTime() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_Tendency() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_LengthAffected() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_AverageSpeedAbsolute() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_Delay() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_SegmentSpeedLimit() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTrafficIncident_Causes() {
		return (EReference)trafficIncidentEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTrafficIncident_Advices() {
		return (EReference)trafficIncidentEClass.getEStructuralFeatures().get(9);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTrafficIncident_Applicability() {
		return (EReference)trafficIncidentEClass.getEStructuralFeatures().get(10);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_TrafficIncidentId() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(11);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrafficIncident_ExpectedSpeedAbsolute() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(12);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_ExpirationTime() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(13);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTrafficIncident_UpdateTime() {
		return (EAttribute)trafficIncidentEClass.getEStructuralFeatures().get(14);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTrafficIncident_LocationReference() {
		return (EReference)trafficIncidentEClass.getEStructuralFeatures().get(15);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrafficIncident_TemporarySpeedLimit() {
		return (EReference)trafficIncidentEClass.getEStructuralFeatures().get(16);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getCause() {
		return causeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCause_MainCause() {
		return (EAttribute)causeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getLinkedCause() {
		return linkedCauseEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLinkedCause_CauseTrafficIncidentId() {
		return (EAttribute)linkedCauseEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDirectCause() {
		return directCauseEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDirectCause_WarningLevel() {
		return (EAttribute)directCauseEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDirectCause_UnverifiedInformation() {
		return (EAttribute)directCauseEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDirectCause_SubCause() {
		return (EAttribute)directCauseEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDirectCause_LengthAffected() {
		return (EAttribute)directCauseEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDirectCause_LaneRestrictions() {
		return (EReference)directCauseEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDirectCause_FreeText() {
		return (EReference)directCauseEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDirectCause_CauseOffset() {
		return (EAttribute)directCauseEClass.getEStructuralFeatures().get(6);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getLaneRestrictions() {
		return laneRestrictionsEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLaneRestrictions_LaneRestrictionType() {
		return (EAttribute)laneRestrictionsEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLaneRestrictions_NumberOfLanes() {
		return (EAttribute)laneRestrictionsEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getAdvice() {
		return adviceEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getAdvice_MainAdvice() {
		return (EAttribute)adviceEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getAdvice_SubAdvice() {
		return (EAttribute)adviceEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAdvice_FreeText() {
		return (EReference)adviceEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAdvice_Applicability() {
		return (EReference)adviceEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getApplicability() {
		return applicabilityEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getApplicability_VehicleType() {
		return (EAttribute)applicabilityEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getApplicability_VehicleRelatedRestrictions() {
		return (EReference)applicabilityEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getVehicleRelatedRestriction() {
		return vehicleRelatedRestrictionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVehicleRelatedRestriction_RestrictionType() {
		return (EAttribute)vehicleRelatedRestrictionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVehicleRelatedRestriction_RestrictionValue() {
		return (EAttribute)vehicleRelatedRestrictionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getVehicleRelatedRestriction_RestrictionLocationReference() {
		return (EReference)vehicleRelatedRestrictionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemporarySpeedLimitSection() {
		return temporarySpeedLimitSectionEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemporarySpeedLimitSection_SpeedLimitValue() {
		return (EAttribute)temporarySpeedLimitSectionEClass.getEStructuralFeatures().get(0);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemporarySpeedLimitSection_SpeedLimitValueWet() {
		return (EAttribute)temporarySpeedLimitSectionEClass.getEStructuralFeatures().get(1);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemporarySpeedLimitSection_SpeedLimitLength() {
		return (EAttribute)temporarySpeedLimitSectionEClass.getEStructuralFeatures().get(2);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemporarySpeedLimit() {
		return temporarySpeedLimitEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemporarySpeedLimit_TemporarySpeedLimitSections() {
		return (EReference)temporarySpeedLimitEClass.getEStructuralFeatures().get(0);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemporarySpeedLimit_UnitsMPH() {
		return (EAttribute)temporarySpeedLimitEClass.getEStructuralFeatures().get(1);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemporarySpeedLimit_Offset() {
		return (EAttribute)temporarySpeedLimitEClass.getEStructuralFeatures().get(2);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemporarySpeedLimit_Applicability() {
		return (EReference)temporarySpeedLimitEClass.getEStructuralFeatures().get(3);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public XTrafficIncidentFactory getXTrafficIncidentFactory() {
		return (XTrafficIncidentFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		trafficIncidentEClass = createEClass(TRAFFIC_INCIDENT);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__EFFECT_CODE);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__START_TIME);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__STOP_TIME);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__TENDENCY);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__LENGTH_AFFECTED);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__DELAY);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT);
		createEReference(trafficIncidentEClass, TRAFFIC_INCIDENT__CAUSES);
		createEReference(trafficIncidentEClass, TRAFFIC_INCIDENT__ADVICES);
		createEReference(trafficIncidentEClass, TRAFFIC_INCIDENT__APPLICABILITY);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__EXPIRATION_TIME);
		createEAttribute(trafficIncidentEClass, TRAFFIC_INCIDENT__UPDATE_TIME);
		createEReference(trafficIncidentEClass, TRAFFIC_INCIDENT__LOCATION_REFERENCE);
		createEReference(trafficIncidentEClass, TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT);

		causeEClass = createEClass(CAUSE);
		createEAttribute(causeEClass, CAUSE__MAIN_CAUSE);

		linkedCauseEClass = createEClass(LINKED_CAUSE);
		createEAttribute(linkedCauseEClass, LINKED_CAUSE__CAUSE_TRAFFIC_INCIDENT_ID);

		directCauseEClass = createEClass(DIRECT_CAUSE);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__WARNING_LEVEL);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__UNVERIFIED_INFORMATION);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__SUB_CAUSE);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__LENGTH_AFFECTED);
		createEReference(directCauseEClass, DIRECT_CAUSE__LANE_RESTRICTIONS);
		createEReference(directCauseEClass, DIRECT_CAUSE__FREE_TEXT);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__CAUSE_OFFSET);

		laneRestrictionsEClass = createEClass(LANE_RESTRICTIONS);
		createEAttribute(laneRestrictionsEClass, LANE_RESTRICTIONS__LANE_RESTRICTION_TYPE);
		createEAttribute(laneRestrictionsEClass, LANE_RESTRICTIONS__NUMBER_OF_LANES);

		adviceEClass = createEClass(ADVICE);
		createEAttribute(adviceEClass, ADVICE__MAIN_ADVICE);
		createEAttribute(adviceEClass, ADVICE__SUB_ADVICE);
		createEReference(adviceEClass, ADVICE__FREE_TEXT);
		createEReference(adviceEClass, ADVICE__APPLICABILITY);

		applicabilityEClass = createEClass(APPLICABILITY);
		createEAttribute(applicabilityEClass, APPLICABILITY__VEHICLE_TYPE);
		createEReference(applicabilityEClass, APPLICABILITY__VEHICLE_RELATED_RESTRICTIONS);

		vehicleRelatedRestrictionEClass = createEClass(VEHICLE_RELATED_RESTRICTION);
		createEAttribute(vehicleRelatedRestrictionEClass, VEHICLE_RELATED_RESTRICTION__RESTRICTION_TYPE);
		createEAttribute(vehicleRelatedRestrictionEClass, VEHICLE_RELATED_RESTRICTION__RESTRICTION_VALUE);
		createEReference(vehicleRelatedRestrictionEClass, VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION_REFERENCE);

		temporarySpeedLimitSectionEClass = createEClass(TEMPORARY_SPEED_LIMIT_SECTION);
		createEAttribute(temporarySpeedLimitSectionEClass, TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE);
		createEAttribute(temporarySpeedLimitSectionEClass, TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE_WET);
		createEAttribute(temporarySpeedLimitSectionEClass, TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_LENGTH);

		temporarySpeedLimitEClass = createEClass(TEMPORARY_SPEED_LIMIT);
		createEReference(temporarySpeedLimitEClass, TEMPORARY_SPEED_LIMIT__TEMPORARY_SPEED_LIMIT_SECTIONS);
		createEAttribute(temporarySpeedLimitEClass, TEMPORARY_SPEED_LIMIT__UNITS_MPH);
		createEAttribute(temporarySpeedLimitEClass, TEMPORARY_SPEED_LIMIT__OFFSET);
		createEReference(temporarySpeedLimitEClass, TEMPORARY_SPEED_LIMIT__APPLICABILITY);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		trafficincidenttablesPackage thetrafficincidenttablesPackage = (trafficincidenttablesPackage)EPackage.Registry.INSTANCE.getEPackage(trafficincidenttablesPackage.eNS_URI);
		locrefPackage thelocrefPackage = (locrefPackage)EPackage.Registry.INSTANCE.getEPackage(locrefPackage.eNS_URI);
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		linkedCauseEClass.getESuperTypes().add(this.getCause());
		directCauseEClass.getESuperTypes().add(this.getCause());

		// Initialize classes and features; add operations and parameters
		initEClass(trafficIncidentEClass, TrafficIncident.class, "TrafficIncident", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTrafficIncident_EffectCode(), thetrafficincidenttablesPackage.getEffectCode(), "effectCode", null, 1, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_StartTime(), ecorePackage.getEDate(), "startTime", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_StopTime(), ecorePackage.getEDate(), "stopTime", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_Tendency(), thetrafficincidenttablesPackage.getTendency(), "tendency", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_LengthAffected(), ecorePackage.getEIntegerObject(), "lengthAffected", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_AverageSpeedAbsolute(), ecorePackage.getEIntegerObject(), "averageSpeedAbsolute", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_Delay(), ecorePackage.getEIntegerObject(), "delay", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_SegmentSpeedLimit(), ecorePackage.getEIntegerObject(), "segmentSpeedLimit", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrafficIncident_Causes(), this.getCause(), null, "causes", null, 0, -1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrafficIncident_Advices(), this.getAdvice(), null, "advices", null, 0, -1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrafficIncident_Applicability(), this.getApplicability(), null, "applicability", null, 0, -1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_TrafficIncidentId(), ecorePackage.getEString(), "trafficIncidentId", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_ExpectedSpeedAbsolute(), ecorePackage.getEIntegerObject(), "expectedSpeedAbsolute", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_ExpirationTime(), ecorePackage.getEDate(), "expirationTime", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrafficIncident_UpdateTime(), ecorePackage.getEDate(), "updateTime", null, 0, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrafficIncident_LocationReference(), thelocrefPackage.getLocationReference(), null, "locationReference", null, 1, 1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrafficIncident_TemporarySpeedLimit(), this.getTemporarySpeedLimit(), null, "temporarySpeedLimit", null, 0, -1, TrafficIncident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(causeEClass, Cause.class, "Cause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCause_MainCause(), thetrafficincidenttablesPackage.getCauseCode(), "mainCause", null, 0, 1, Cause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkedCauseEClass, LinkedCause.class, "LinkedCause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinkedCause_CauseTrafficIncidentId(), ecorePackage.getEString(), "causeTrafficIncidentId", null, 0, 1, LinkedCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directCauseEClass, DirectCause.class, "DirectCause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDirectCause_WarningLevel(), thetrafficincidenttablesPackage.getWarningLevel(), "warningLevel", null, 1, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectCause_UnverifiedInformation(), ecorePackage.getEBoolean(), "unverifiedInformation", null, 1, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectCause_SubCause(), ecorePackage.getEJavaObject(), "subCause", null, 0, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectCause_LengthAffected(), ecorePackage.getEIntegerObject(), "lengthAffected", null, 0, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDirectCause_LaneRestrictions(), this.getLaneRestrictions(), null, "laneRestrictions", null, 0, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDirectCause_FreeText(), theCommonPackage.getLocalizedString(), null, "freeText", null, 0, -1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectCause_CauseOffset(), ecorePackage.getEIntegerObject(), "causeOffset", null, 0, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(laneRestrictionsEClass, LaneRestrictions.class, "LaneRestrictions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLaneRestrictions_LaneRestrictionType(), thetrafficincidenttablesPackage.getLaneRestrictionType(), "laneRestrictionType", null, 0, 1, LaneRestrictions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLaneRestrictions_NumberOfLanes(), ecorePackage.getEIntegerObject(), "numberOfLanes", null, 0, 1, LaneRestrictions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adviceEClass, Advice.class, "Advice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdvice_MainAdvice(), thetrafficincidenttablesPackage.getAdviceCode(), "mainAdvice", null, 0, 1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdvice_SubAdvice(), ecorePackage.getEJavaObject(), "subAdvice", null, 0, 1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdvice_FreeText(), theCommonPackage.getLocalizedString(), null, "freeText", null, 0, -1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdvice_Applicability(), this.getApplicability(), null, "applicability", null, 0, -1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(applicabilityEClass, Applicability.class, "Applicability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApplicability_VehicleType(), thetrafficincidenttablesPackage.getVehicleType(), "vehicleType", null, 0, 1, Applicability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicability_VehicleRelatedRestrictions(), this.getVehicleRelatedRestriction(), null, "vehicleRelatedRestrictions", null, 0, -1, Applicability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vehicleRelatedRestrictionEClass, VehicleRelatedRestriction.class, "VehicleRelatedRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVehicleRelatedRestriction_RestrictionType(), thetrafficincidenttablesPackage.getRestrictionType(), "restrictionType", null, 1, 1, VehicleRelatedRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicleRelatedRestriction_RestrictionValue(), ecorePackage.getEIntegerObject(), "restrictionValue", null, 0, 1, VehicleRelatedRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVehicleRelatedRestriction_RestrictionLocationReference(), thelocrefPackage.getLocationReference(), null, "restrictionLocationReference", null, 0, 1, VehicleRelatedRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(temporarySpeedLimitSectionEClass, TemporarySpeedLimitSection.class, "TemporarySpeedLimitSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemporarySpeedLimitSection_SpeedLimitValue(), ecorePackage.getEShort(), "speedLimitValue", null, 1, 1, TemporarySpeedLimitSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemporarySpeedLimitSection_SpeedLimitValueWet(), ecorePackage.getEShort(), "speedLimitValueWet", null, 0, 1, TemporarySpeedLimitSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemporarySpeedLimitSection_SpeedLimitLength(), ecorePackage.getEIntegerObject(), "speedLimitLength", null, 0, 1, TemporarySpeedLimitSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(temporarySpeedLimitEClass, TemporarySpeedLimit.class, "TemporarySpeedLimit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemporarySpeedLimit_TemporarySpeedLimitSections(), this.getTemporarySpeedLimitSection(), null, "temporarySpeedLimitSections", null, 1, -1, TemporarySpeedLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemporarySpeedLimit_UnitsMPH(), ecorePackage.getEBoolean(), "unitsMPH", null, 1, 1, TemporarySpeedLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemporarySpeedLimit_Offset(), ecorePackage.getEIntegerObject(), "offset", null, 0, 1, TemporarySpeedLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemporarySpeedLimit_Applicability(), this.getApplicability(), null, "applicability", null, 0, -1, TemporarySpeedLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// GenModel
		createGenModelAnnotations();
	}

  /**
	 * Initializes the annotations for <b>GenModel</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createGenModelAnnotations() {
		String source = "GenModel";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "documentation", "Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/."
		   });				
	}

} //XTrafficIncidentPackageImpl
