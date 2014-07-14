/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event.impl;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.genivi.trafficinfo.tpeg.tec.event.Accident;
import org.genivi.trafficinfo.tpeg.tec.event.Advice;
import org.genivi.trafficinfo.tpeg.tec.event.AdviceCode;
import org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway;
import org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles;
import org.genivi.trafficinfo.tpeg.tec.event.Cause;
import org.genivi.trafficinfo.tpeg.tec.event.CauseCode;
import org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue;
import org.genivi.trafficinfo.tpeg.tec.event.DirectCause;
import org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle;
import org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully;
import org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed;
import org.genivi.trafficinfo.tpeg.tec.event.EffectCode;
import org.genivi.trafficinfo.tpeg.tec.event.Event;
import org.genivi.trafficinfo.tpeg.tec.event.EventFactory;
import org.genivi.trafficinfo.tpeg.tec.event.EventPackage;
import org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions;
import org.genivi.trafficinfo.tpeg.tec.event.Fire;
import org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion;
import org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind;
import org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions;
import org.genivi.trafficinfo.tpeg.tec.event.Impassibility;
import org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType;
import org.genivi.trafficinfo.tpeg.tec.event.LinkedCause;
import org.genivi.trafficinfo.tpeg.tec.event.MajorEvent;
import org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment;
import org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes;
import org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad;
import org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed;
import org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway;
import org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint;
import org.genivi.trafficinfo.tpeg.tec.event.Precipitation;
import org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons;
import org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure;
import org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress;
import org.genivi.trafficinfo.tpeg.tec.event.RestrictionType;
import org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire;
import org.genivi.trafficinfo.tpeg.tec.event.RoadWorks;
import org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating;
import org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable;
import org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad;
import org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles;
import org.genivi.trafficinfo.tpeg.tec.event.TECMessage;
import org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit;
import org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection;
import org.genivi.trafficinfo.tpeg.tec.event.Tendency;
import org.genivi.trafficinfo.tpeg.tec.event.TimeDelay;
import org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion;
import org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleType;
import org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced;
import org.genivi.trafficinfo.tpeg.tec.event.WarningLevel;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventPackageImpl extends EPackageImpl implements EventPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass eventEClass = null;

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
  private EClass adviceEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass vehicleRestrictionEClass = null;

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
  private EClass tecMessageEClass = null;

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
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum effectCodeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum tendencyEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum causeCodeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum warningLevelEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum trafficCongestionEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum accidentEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum roadWorksEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum narrowLanesEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum impassibilityEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum slipperyRoadEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum fireEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum hazardousDrivingConditionsEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum objectsOnTheRoadEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum animalsOnRoadwayEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum peopleOnRoadwayEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum brokenDownVehiclesEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum rescueAndRecoveryWorkInProgressEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum regulatoryMeasureEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum laneRestrictionTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum adviceCodeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum vehicleTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum restrictionTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum extremeWeatherConditionsEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum visibilityReducedEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum precipitationEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum recklessPersonsEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum majorEventEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum serviceNotOperatingEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum serviceNotUsableEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum slowMovingVehiclesEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum dangerousEndOfQueueEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum riskOfFireEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum timeDelayEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum policeCheckpointEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum malfunctioningRoadsideEquipmentEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum overtakingNotAllowedEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum drivingNotAllowedEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum givingPathVehiclesFromBehindEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum followDiversionEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum driveCarefullyEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum doNotLeaveYourVehicleEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum useTollLanesEEnum = null;

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
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private EventPackageImpl() {
		super(eNS_URI, EventFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EventPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static EventPackage init() {
		if (isInited) return (EventPackage)EPackage.Registry.INSTANCE.getEPackage(EventPackage.eNS_URI);

		// Obtain or create and register package
		EventPackageImpl theEventPackage = (EventPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EventPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EventPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TpegfwktypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEventPackage.createPackageContents();

		// Initialize created meta-data
		theEventPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEventPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EventPackage.eNS_URI, theEventPackage);
		return theEventPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getEvent() {
		return eventEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getEvent_EffectCode() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getEvent_StartTime() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getEvent_StopTime() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getEvent_Tendency() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getEvent_LengthAffected() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getEvent_AverageSpeedAbsolute() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getEvent_Delay() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getEvent_SegmentSpeedLimit() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getEvent_Cause() {
		return (EReference)eventEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getEvent_Advice() {
		return (EReference)eventEClass.getEStructuralFeatures().get(9);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getEvent_VehicleRestriction() {
		return (EReference)eventEClass.getEStructuralFeatures().get(10);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_ExpectedSpeedAbsolute() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(11);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_TemporarySpeedLimit() {
		return (EReference)eventEClass.getEStructuralFeatures().get(12);
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
  public EAttribute getLinkedCause_LinkedMessage() {
		return (EAttribute)linkedCauseEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLinkedCause_COID() {
		return (EAttribute)linkedCauseEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getLinkedCause_OriginatorSID() {
		return (EReference)linkedCauseEClass.getEStructuralFeatures().get(2);
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
  public EAttribute getDirectCause_LaneRestrictionType() {
		return (EAttribute)directCauseEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDirectCause_NumberOfLanes() {
		return (EAttribute)directCauseEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDirectCause_FreeText() {
		return (EReference)directCauseEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDirectCause_CauseOffset() {
		return (EAttribute)directCauseEClass.getEStructuralFeatures().get(7);
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
  public EAttribute getAdvice_AdviceCode() {
		return (EAttribute)adviceEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getAdvice_SubAdviceCode() {
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
  public EReference getAdvice_VehicleRestriction() {
		return (EReference)adviceEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getVehicleRestriction() {
		return vehicleRestrictionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVehicleRestriction_VehicleType() {
		return (EAttribute)vehicleRestrictionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getVehicleRestriction_Restriction() {
		return (EReference)vehicleRestrictionEClass.getEStructuralFeatures().get(1);
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
  public EReference getVehicleRelatedRestriction_RestrictionLocation() {
		return (EReference)vehicleRelatedRestrictionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTECMessage() {
		return tecMessageEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTECMessage_Mmt() {
		return (EReference)tecMessageEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTECMessage_Event() {
		return (EReference)tecMessageEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTECMessage_Loc() {
		return (EReference)tecMessageEClass.getEStructuralFeatures().get(2);
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
	public EReference getTemporarySpeedLimit_SpeedLimitSection() {
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
	public EReference getTemporarySpeedLimit_VehicleRestriction() {
		return (EReference)temporarySpeedLimitEClass.getEStructuralFeatures().get(3);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getEffectCode() {
		return effectCodeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getTendency() {
		return tendencyEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getCauseCode() {
		return causeCodeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getWarningLevel() {
		return warningLevelEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getTrafficCongestion() {
		return trafficCongestionEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getAccident() {
		return accidentEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getRoadWorks() {
		return roadWorksEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getNarrowLanes() {
		return narrowLanesEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getImpassibility() {
		return impassibilityEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getSlipperyRoad() {
		return slipperyRoadEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getFire() {
		return fireEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getHazardousDrivingConditions() {
		return hazardousDrivingConditionsEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getObjectsOnTheRoad() {
		return objectsOnTheRoadEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getAnimalsOnRoadway() {
		return animalsOnRoadwayEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getPeopleOnRoadway() {
		return peopleOnRoadwayEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getBrokenDownVehicles() {
		return brokenDownVehiclesEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getRescueAndRecoveryWorkInProgress() {
		return rescueAndRecoveryWorkInProgressEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getRegulatoryMeasure() {
		return regulatoryMeasureEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getLaneRestrictionType() {
		return laneRestrictionTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getAdviceCode() {
		return adviceCodeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getVehicleType() {
		return vehicleTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getRestrictionType() {
		return restrictionTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getExtremeWeatherConditions() {
		return extremeWeatherConditionsEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getVisibilityReduced() {
		return visibilityReducedEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getPrecipitation() {
		return precipitationEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getRecklessPersons() {
		return recklessPersonsEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getMajorEvent() {
		return majorEventEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getServiceNotOperating() {
		return serviceNotOperatingEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getServiceNotUsable() {
		return serviceNotUsableEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getSlowMovingVehicles() {
		return slowMovingVehiclesEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getDangerousEndOfQueue() {
		return dangerousEndOfQueueEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getRiskOfFire() {
		return riskOfFireEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getTimeDelay() {
		return timeDelayEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getPoliceCheckpoint() {
		return policeCheckpointEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getMalfunctioningRoadsideEquipment() {
		return malfunctioningRoadsideEquipmentEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getOvertakingNotAllowed() {
		return overtakingNotAllowedEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getDrivingNotAllowed() {
		return drivingNotAllowedEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getGivingPathVehiclesFromBehind() {
		return givingPathVehiclesFromBehindEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getFollowDiversion() {
		return followDiversionEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getDriveCarefully() {
		return driveCarefullyEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getDoNotLeaveYourVehicle() {
		return doNotLeaveYourVehicleEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getUseTollLanes() {
		return useTollLanesEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EventFactory getEventFactory() {
		return (EventFactory)getEFactoryInstance();
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
		eventEClass = createEClass(EVENT);
		createEAttribute(eventEClass, EVENT__EFFECT_CODE);
		createEAttribute(eventEClass, EVENT__START_TIME);
		createEAttribute(eventEClass, EVENT__STOP_TIME);
		createEAttribute(eventEClass, EVENT__TENDENCY);
		createEAttribute(eventEClass, EVENT__LENGTH_AFFECTED);
		createEAttribute(eventEClass, EVENT__AVERAGE_SPEED_ABSOLUTE);
		createEAttribute(eventEClass, EVENT__DELAY);
		createEAttribute(eventEClass, EVENT__SEGMENT_SPEED_LIMIT);
		createEReference(eventEClass, EVENT__CAUSE);
		createEReference(eventEClass, EVENT__ADVICE);
		createEReference(eventEClass, EVENT__VEHICLE_RESTRICTION);
		createEAttribute(eventEClass, EVENT__EXPECTED_SPEED_ABSOLUTE);
		createEReference(eventEClass, EVENT__TEMPORARY_SPEED_LIMIT);

		causeEClass = createEClass(CAUSE);
		createEAttribute(causeEClass, CAUSE__MAIN_CAUSE);

		linkedCauseEClass = createEClass(LINKED_CAUSE);
		createEAttribute(linkedCauseEClass, LINKED_CAUSE__LINKED_MESSAGE);
		createEAttribute(linkedCauseEClass, LINKED_CAUSE__COID);
		createEReference(linkedCauseEClass, LINKED_CAUSE__ORIGINATOR_SID);

		directCauseEClass = createEClass(DIRECT_CAUSE);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__WARNING_LEVEL);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__UNVERIFIED_INFORMATION);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__SUB_CAUSE);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__LENGTH_AFFECTED);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__LANE_RESTRICTION_TYPE);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__NUMBER_OF_LANES);
		createEReference(directCauseEClass, DIRECT_CAUSE__FREE_TEXT);
		createEAttribute(directCauseEClass, DIRECT_CAUSE__CAUSE_OFFSET);

		adviceEClass = createEClass(ADVICE);
		createEAttribute(adviceEClass, ADVICE__ADVICE_CODE);
		createEAttribute(adviceEClass, ADVICE__SUB_ADVICE_CODE);
		createEReference(adviceEClass, ADVICE__FREE_TEXT);
		createEReference(adviceEClass, ADVICE__VEHICLE_RESTRICTION);

		vehicleRestrictionEClass = createEClass(VEHICLE_RESTRICTION);
		createEAttribute(vehicleRestrictionEClass, VEHICLE_RESTRICTION__VEHICLE_TYPE);
		createEReference(vehicleRestrictionEClass, VEHICLE_RESTRICTION__RESTRICTION);

		vehicleRelatedRestrictionEClass = createEClass(VEHICLE_RELATED_RESTRICTION);
		createEAttribute(vehicleRelatedRestrictionEClass, VEHICLE_RELATED_RESTRICTION__RESTRICTION_TYPE);
		createEAttribute(vehicleRelatedRestrictionEClass, VEHICLE_RELATED_RESTRICTION__RESTRICTION_VALUE);
		createEReference(vehicleRelatedRestrictionEClass, VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION);

		tecMessageEClass = createEClass(TEC_MESSAGE);
		createEReference(tecMessageEClass, TEC_MESSAGE__MMT);
		createEReference(tecMessageEClass, TEC_MESSAGE__EVENT);
		createEReference(tecMessageEClass, TEC_MESSAGE__LOC);

		temporarySpeedLimitSectionEClass = createEClass(TEMPORARY_SPEED_LIMIT_SECTION);
		createEAttribute(temporarySpeedLimitSectionEClass, TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE);
		createEAttribute(temporarySpeedLimitSectionEClass, TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE_WET);
		createEAttribute(temporarySpeedLimitSectionEClass, TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_LENGTH);

		temporarySpeedLimitEClass = createEClass(TEMPORARY_SPEED_LIMIT);
		createEReference(temporarySpeedLimitEClass, TEMPORARY_SPEED_LIMIT__SPEED_LIMIT_SECTION);
		createEAttribute(temporarySpeedLimitEClass, TEMPORARY_SPEED_LIMIT__UNITS_MPH);
		createEAttribute(temporarySpeedLimitEClass, TEMPORARY_SPEED_LIMIT__OFFSET);
		createEReference(temporarySpeedLimitEClass, TEMPORARY_SPEED_LIMIT__VEHICLE_RESTRICTION);

		// Create enums
		effectCodeEEnum = createEEnum(EFFECT_CODE);
		tendencyEEnum = createEEnum(TENDENCY);
		causeCodeEEnum = createEEnum(CAUSE_CODE);
		warningLevelEEnum = createEEnum(WARNING_LEVEL);
		trafficCongestionEEnum = createEEnum(TRAFFIC_CONGESTION);
		accidentEEnum = createEEnum(ACCIDENT);
		roadWorksEEnum = createEEnum(ROAD_WORKS);
		narrowLanesEEnum = createEEnum(NARROW_LANES);
		impassibilityEEnum = createEEnum(IMPASSIBILITY);
		slipperyRoadEEnum = createEEnum(SLIPPERY_ROAD);
		fireEEnum = createEEnum(FIRE);
		hazardousDrivingConditionsEEnum = createEEnum(HAZARDOUS_DRIVING_CONDITIONS);
		objectsOnTheRoadEEnum = createEEnum(OBJECTS_ON_THE_ROAD);
		animalsOnRoadwayEEnum = createEEnum(ANIMALS_ON_ROADWAY);
		peopleOnRoadwayEEnum = createEEnum(PEOPLE_ON_ROADWAY);
		brokenDownVehiclesEEnum = createEEnum(BROKEN_DOWN_VEHICLES);
		rescueAndRecoveryWorkInProgressEEnum = createEEnum(RESCUE_AND_RECOVERY_WORK_IN_PROGRESS);
		regulatoryMeasureEEnum = createEEnum(REGULATORY_MEASURE);
		laneRestrictionTypeEEnum = createEEnum(LANE_RESTRICTION_TYPE);
		adviceCodeEEnum = createEEnum(ADVICE_CODE);
		vehicleTypeEEnum = createEEnum(VEHICLE_TYPE);
		restrictionTypeEEnum = createEEnum(RESTRICTION_TYPE);
		extremeWeatherConditionsEEnum = createEEnum(EXTREME_WEATHER_CONDITIONS);
		visibilityReducedEEnum = createEEnum(VISIBILITY_REDUCED);
		precipitationEEnum = createEEnum(PRECIPITATION);
		recklessPersonsEEnum = createEEnum(RECKLESS_PERSONS);
		majorEventEEnum = createEEnum(MAJOR_EVENT);
		serviceNotOperatingEEnum = createEEnum(SERVICE_NOT_OPERATING);
		serviceNotUsableEEnum = createEEnum(SERVICE_NOT_USABLE);
		slowMovingVehiclesEEnum = createEEnum(SLOW_MOVING_VEHICLES);
		dangerousEndOfQueueEEnum = createEEnum(DANGEROUS_END_OF_QUEUE);
		riskOfFireEEnum = createEEnum(RISK_OF_FIRE);
		timeDelayEEnum = createEEnum(TIME_DELAY);
		policeCheckpointEEnum = createEEnum(POLICE_CHECKPOINT);
		malfunctioningRoadsideEquipmentEEnum = createEEnum(MALFUNCTIONING_ROADSIDE_EQUIPMENT);
		overtakingNotAllowedEEnum = createEEnum(OVERTAKING_NOT_ALLOWED);
		drivingNotAllowedEEnum = createEEnum(DRIVING_NOT_ALLOWED);
		givingPathVehiclesFromBehindEEnum = createEEnum(GIVING_PATH_VEHICLES_FROM_BEHIND);
		followDiversionEEnum = createEEnum(FOLLOW_DIVERSION);
		driveCarefullyEEnum = createEEnum(DRIVE_CAREFULLY);
		doNotLeaveYourVehicleEEnum = createEEnum(DO_NOT_LEAVE_YOUR_VEHICLE);
		useTollLanesEEnum = createEEnum(USE_TOLL_LANES);
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
		TpegfwktypesPackage theTpegfwktypesPackage = (TpegfwktypesPackage)EPackage.Registry.INSTANCE.getEPackage(TpegfwktypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		linkedCauseEClass.getESuperTypes().add(this.getCause());
		directCauseEClass.getESuperTypes().add(this.getCause());

		// Initialize classes and features; add operations and parameters
		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvent_EffectCode(), this.getEffectCode(), "effectCode", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_StartTime(), ecorePackage.getEDate(), "startTime", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_StopTime(), ecorePackage.getEDate(), "stopTime", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Tendency(), this.getTendency(), "tendency", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_LengthAffected(), ecorePackage.getEIntegerObject(), "lengthAffected", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_AverageSpeedAbsolute(), ecorePackage.getEIntegerObject(), "averageSpeedAbsolute", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Delay(), ecorePackage.getEIntegerObject(), "delay", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_SegmentSpeedLimit(), ecorePackage.getEIntegerObject(), "segmentSpeedLimit", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Cause(), this.getCause(), null, "cause", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Advice(), this.getAdvice(), null, "advice", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_VehicleRestriction(), this.getVehicleRestriction(), null, "vehicleRestriction", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_ExpectedSpeedAbsolute(), ecorePackage.getEIntegerObject(), "expectedSpeedAbsolute", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_TemporarySpeedLimit(), this.getTemporarySpeedLimit(), null, "temporarySpeedLimit", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(causeEClass, Cause.class, "Cause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCause_MainCause(), this.getCauseCode(), "mainCause", null, 0, 1, Cause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkedCauseEClass, LinkedCause.class, "LinkedCause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinkedCause_LinkedMessage(), ecorePackage.getEIntegerObject(), "linkedMessage", null, 1, 1, LinkedCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkedCause_COID(), ecorePackage.getEByte(), "COID", null, 0, 1, LinkedCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinkedCause_OriginatorSID(), theTpegfwktypesPackage.getServiceIdentifier(), null, "originatorSID", null, 0, 1, LinkedCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directCauseEClass, DirectCause.class, "DirectCause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDirectCause_WarningLevel(), this.getWarningLevel(), "warningLevel", null, 1, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectCause_UnverifiedInformation(), ecorePackage.getEBoolean(), "unverifiedInformation", null, 1, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectCause_SubCause(), ecorePackage.getEJavaObject(), "subCause", null, 0, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectCause_LengthAffected(), ecorePackage.getEIntegerObject(), "lengthAffected", null, 0, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectCause_LaneRestrictionType(), this.getLaneRestrictionType(), "laneRestrictionType", null, 0, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectCause_NumberOfLanes(), ecorePackage.getEIntegerObject(), "numberOfLanes", null, 0, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDirectCause_FreeText(), theTpegfwktypesPackage.getLocalisedShortString(), null, "freeText", null, 0, -1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectCause_CauseOffset(), ecorePackage.getEIntegerObject(), "causeOffset", null, 0, 1, DirectCause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adviceEClass, Advice.class, "Advice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdvice_AdviceCode(), this.getAdviceCode(), "adviceCode", null, 0, 1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdvice_SubAdviceCode(), ecorePackage.getEJavaObject(), "subAdviceCode", null, 0, 1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdvice_FreeText(), theTpegfwktypesPackage.getLocalisedShortString(), null, "freeText", null, 0, -1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdvice_VehicleRestriction(), this.getVehicleRestriction(), null, "vehicleRestriction", null, 0, -1, Advice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vehicleRestrictionEClass, VehicleRestriction.class, "VehicleRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVehicleRestriction_VehicleType(), this.getVehicleType(), "vehicleType", null, 0, 1, VehicleRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVehicleRestriction_Restriction(), this.getVehicleRelatedRestriction(), null, "restriction", null, 0, -1, VehicleRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vehicleRelatedRestrictionEClass, VehicleRelatedRestriction.class, "VehicleRelatedRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVehicleRelatedRestriction_RestrictionType(), this.getRestrictionType(), "restrictionType", null, 1, 1, VehicleRelatedRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVehicleRelatedRestriction_RestrictionValue(), ecorePackage.getEIntegerObject(), "restrictionValue", null, 0, 1, VehicleRelatedRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVehicleRelatedRestriction_RestrictionLocation(), theTpegfwktypesPackage.getLocationReferencingContainer(), null, "restrictionLocation", null, 0, 1, VehicleRelatedRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tecMessageEClass, TECMessage.class, "TECMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTECMessage_Mmt(), theTpegfwktypesPackage.getMMCSwitch(), null, "mmt", null, 1, 1, TECMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTECMessage_Event(), this.getEvent(), null, "event", null, 0, 1, TECMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTECMessage_Loc(), theTpegfwktypesPackage.getLocationReferencingContainer(), null, "loc", null, 0, 1, TECMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(temporarySpeedLimitSectionEClass, TemporarySpeedLimitSection.class, "TemporarySpeedLimitSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemporarySpeedLimitSection_SpeedLimitValue(), ecorePackage.getEByte(), "speedLimitValue", null, 1, 1, TemporarySpeedLimitSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemporarySpeedLimitSection_SpeedLimitValueWet(), ecorePackage.getEByte(), "speedLimitValueWet", null, 0, 1, TemporarySpeedLimitSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemporarySpeedLimitSection_SpeedLimitLength(), ecorePackage.getEIntegerObject(), "speedLimitLength", null, 0, 1, TemporarySpeedLimitSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(temporarySpeedLimitEClass, TemporarySpeedLimit.class, "TemporarySpeedLimit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemporarySpeedLimit_SpeedLimitSection(), this.getTemporarySpeedLimitSection(), null, "speedLimitSection", null, 1, -1, TemporarySpeedLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemporarySpeedLimit_UnitsMPH(), ecorePackage.getEBoolean(), "unitsMPH", null, 1, 1, TemporarySpeedLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemporarySpeedLimit_Offset(), ecorePackage.getEIntegerObject(), "offset", null, 0, 1, TemporarySpeedLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemporarySpeedLimit_VehicleRestriction(), this.getVehicleRestriction(), null, "vehicleRestriction", null, 0, -1, TemporarySpeedLimit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(effectCodeEEnum, EffectCode.class, "EffectCode");
		addEEnumLiteral(effectCodeEEnum, EffectCode.TRAFFIC_FLOW_UNKNOWN);
		addEEnumLiteral(effectCodeEEnum, EffectCode.FREE_TRAFFIC_FLOW);
		addEEnumLiteral(effectCodeEEnum, EffectCode.HEAVY_TRAFFIC);
		addEEnumLiteral(effectCodeEEnum, EffectCode.SLOW_TRAFFIC);
		addEEnumLiteral(effectCodeEEnum, EffectCode.QUEUING_TRAFFIC);
		addEEnumLiteral(effectCodeEEnum, EffectCode.STATIONARY_TRAFFIC);
		addEEnumLiteral(effectCodeEEnum, EffectCode.NO_TRAFFIC_FLOW);

		initEEnum(tendencyEEnum, Tendency.class, "Tendency");
		addEEnumLiteral(tendencyEEnum, Tendency.SLIGHTLY_INCREASING);
		addEEnumLiteral(tendencyEEnum, Tendency.INCREASING);
		addEEnumLiteral(tendencyEEnum, Tendency.STRONGLY_INCREASING);
		addEEnumLiteral(tendencyEEnum, Tendency.SLIGHTLY_DECREASING);
		addEEnumLiteral(tendencyEEnum, Tendency.DECREASING);
		addEEnumLiteral(tendencyEEnum, Tendency.STRONGLY_DECREASING);
		addEEnumLiteral(tendencyEEnum, Tendency.CONSTANT);

		initEEnum(causeCodeEEnum, CauseCode.class, "CauseCode");
		addEEnumLiteral(causeCodeEEnum, CauseCode.TRAFFIC_CONGESTION);
		addEEnumLiteral(causeCodeEEnum, CauseCode.ACCIDENT);
		addEEnumLiteral(causeCodeEEnum, CauseCode.ROADWORKS);
		addEEnumLiteral(causeCodeEEnum, CauseCode.NARROW_LANES);
		addEEnumLiteral(causeCodeEEnum, CauseCode.IMPASSIBILITY);
		addEEnumLiteral(causeCodeEEnum, CauseCode.SLIPPERY_ROAD);
		addEEnumLiteral(causeCodeEEnum, CauseCode.AQUAPLANING);
		addEEnumLiteral(causeCodeEEnum, CauseCode.FIRE);
		addEEnumLiteral(causeCodeEEnum, CauseCode.HAZARDOUS_DRIVING_CONDITIONS);
		addEEnumLiteral(causeCodeEEnum, CauseCode.OBJECTS_ON_THE_ROAD);
		addEEnumLiteral(causeCodeEEnum, CauseCode.ANIMALS_ON_ROADWAY);
		addEEnumLiteral(causeCodeEEnum, CauseCode.PEOPLE_ON_ROADWAY);
		addEEnumLiteral(causeCodeEEnum, CauseCode.BROKEN_DOWN_VEHICLES);
		addEEnumLiteral(causeCodeEEnum, CauseCode.VEHICLE_ON_WRONG_CARRIAGEWAY);
		addEEnumLiteral(causeCodeEEnum, CauseCode.RESCUE_AND_RECOVERY_WORK_IN_PROGRESS);
		addEEnumLiteral(causeCodeEEnum, CauseCode.REGULATORY_MEASURE);
		addEEnumLiteral(causeCodeEEnum, CauseCode.EXTREME_WEATHER_CONDITIONS);
		addEEnumLiteral(causeCodeEEnum, CauseCode.VISIBILITY_REDUCED);
		addEEnumLiteral(causeCodeEEnum, CauseCode.PRECIPITATION);
		addEEnumLiteral(causeCodeEEnum, CauseCode.RECKLESS_PERSONS);
		addEEnumLiteral(causeCodeEEnum, CauseCode.OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED);
		addEEnumLiteral(causeCodeEEnum, CauseCode.TRAFFIC_REGULATIONS_CHANGED);
		addEEnumLiteral(causeCodeEEnum, CauseCode.MAJOR_EVENT);
		addEEnumLiteral(causeCodeEEnum, CauseCode.SERVICE_NOT_OPERATING);
		addEEnumLiteral(causeCodeEEnum, CauseCode.SERVICE_NOT_USEABLE);
		addEEnumLiteral(causeCodeEEnum, CauseCode.SLOW_MOVING_VEHICLES);
		addEEnumLiteral(causeCodeEEnum, CauseCode.DANGEROUS_END_OF_QUEUE);
		addEEnumLiteral(causeCodeEEnum, CauseCode.RISK_OF_FIRE);
		addEEnumLiteral(causeCodeEEnum, CauseCode.TIME_DELAY);
		addEEnumLiteral(causeCodeEEnum, CauseCode.POLICE_CHECKPOINT);
		addEEnumLiteral(causeCodeEEnum, CauseCode.MALFUNCTIONING_ROADSIDE_EQUIPMENT);
		addEEnumLiteral(causeCodeEEnum, CauseCode.TEST_MESSAGE);
		addEEnumLiteral(causeCodeEEnum, CauseCode.UNDECODABLE_CAUSE);

		initEEnum(warningLevelEEnum, WarningLevel.class, "WarningLevel");
		addEEnumLiteral(warningLevelEEnum, WarningLevel.INFORMATIVE);
		addEEnumLiteral(warningLevelEEnum, WarningLevel.DANGER_LEVEL_1);
		addEEnumLiteral(warningLevelEEnum, WarningLevel.DANGER_LEVEL_2);
		addEEnumLiteral(warningLevelEEnum, WarningLevel.DANGER_LEVEL_3);

		initEEnum(trafficCongestionEEnum, TrafficCongestion.class, "TrafficCongestion");
		addEEnumLiteral(trafficCongestionEEnum, TrafficCongestion.INCREASED_VOLUME_OF_TRAFFIC);

		initEEnum(accidentEEnum, Accident.class, "Accident");
		addEEnumLiteral(accidentEEnum, Accident.MULTI_VEHICLE_ACCIDENT);
		addEEnumLiteral(accidentEEnum, Accident.HEAVY_ACCIDENT);
		addEEnumLiteral(accidentEEnum, Accident.ACCIDENT_INVOLVING_LORRY);
		addEEnumLiteral(accidentEEnum, Accident.ACCIDENT_INVOLVING_BUS);
		addEEnumLiteral(accidentEEnum, Accident.ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS);
		addEEnumLiteral(accidentEEnum, Accident.ACCIDENT_ON_OPPOSITE_LANE);
		addEEnumLiteral(accidentEEnum, Accident.UNSECURED_ACCIDENT);

		initEEnum(roadWorksEEnum, RoadWorks.class, "RoadWorks");
		addEEnumLiteral(roadWorksEEnum, RoadWorks.MAJOR_ROADWORKS);
		addEEnumLiteral(roadWorksEEnum, RoadWorks.ROAD_MARKING_WORK);
		addEEnumLiteral(roadWorksEEnum, RoadWorks.SLOW_MOVING_ROAD_MAINTENANCE);

		initEEnum(narrowLanesEEnum, NarrowLanes.class, "NarrowLanes");
		addEEnumLiteral(narrowLanesEEnum, NarrowLanes.CONTRAFLOW);
		addEEnumLiteral(narrowLanesEEnum, NarrowLanes.HARD_SHOULDER_CLOSED);
		addEEnumLiteral(narrowLanesEEnum, NarrowLanes.SLIP_LANE_CLOSED);
		addEEnumLiteral(narrowLanesEEnum, NarrowLanes.CRAWLER_LANE_CLOSED);

		initEEnum(impassibilityEEnum, Impassibility.class, "Impassibility");
		addEEnumLiteral(impassibilityEEnum, Impassibility.FLOODING);
		addEEnumLiteral(impassibilityEEnum, Impassibility.DANGER_OF_AVALANCHES);
		addEEnumLiteral(impassibilityEEnum, Impassibility.BLASTING_OF_AVALANCHES);
		addEEnumLiteral(impassibilityEEnum, Impassibility.LANDSLIPS);
		addEEnumLiteral(impassibilityEEnum, Impassibility.CHEMICAL_SPILLAGE);
		addEEnumLiteral(impassibilityEEnum, Impassibility.WINTER_CLOSURE);

		initEEnum(slipperyRoadEEnum, SlipperyRoad.class, "SlipperyRoad");
		addEEnumLiteral(slipperyRoadEEnum, SlipperyRoad.HEAVY_FROST_ON_ROAD);
		addEEnumLiteral(slipperyRoadEEnum, SlipperyRoad.FUEL_ON_ROAD);
		addEEnumLiteral(slipperyRoadEEnum, SlipperyRoad.MUD_ON_ROAD);
		addEEnumLiteral(slipperyRoadEEnum, SlipperyRoad.SNOW_ON_ROAD);
		addEEnumLiteral(slipperyRoadEEnum, SlipperyRoad.ICE_ON_ROAD);
		addEEnumLiteral(slipperyRoadEEnum, SlipperyRoad.BLACK_ICE_ON_ROAD);
		addEEnumLiteral(slipperyRoadEEnum, SlipperyRoad.OIL_ON_ROAD);
		addEEnumLiteral(slipperyRoadEEnum, SlipperyRoad.LOOSE_CHIPPINGS);
		addEEnumLiteral(slipperyRoadEEnum, SlipperyRoad.INSTANT_BLACK_ICE);
		addEEnumLiteral(slipperyRoadEEnum, SlipperyRoad.ROADS_SALTED);

		initEEnum(fireEEnum, Fire.class, "Fire");
		addEEnumLiteral(fireEEnum, Fire.MAJOR_FIRE);
		addEEnumLiteral(fireEEnum, Fire.FOREST_FIRE);

		initEEnum(hazardousDrivingConditionsEEnum, HazardousDrivingConditions.class, "HazardousDrivingConditions");
		addEEnumLiteral(hazardousDrivingConditionsEEnum, HazardousDrivingConditions.ROCKFALLS);
		addEEnumLiteral(hazardousDrivingConditionsEEnum, HazardousDrivingConditions.EARTHQUAKE_DAMAGE);
		addEEnumLiteral(hazardousDrivingConditionsEEnum, HazardousDrivingConditions.SEWER_COLLAPSE);
		addEEnumLiteral(hazardousDrivingConditionsEEnum, HazardousDrivingConditions.SUBSIDENCE);
		addEEnumLiteral(hazardousDrivingConditionsEEnum, HazardousDrivingConditions.SNOW_DRIFTS);
		addEEnumLiteral(hazardousDrivingConditionsEEnum, HazardousDrivingConditions.STORM_DAMAGE);
		addEEnumLiteral(hazardousDrivingConditionsEEnum, HazardousDrivingConditions.BURST_PIPE);
		addEEnumLiteral(hazardousDrivingConditionsEEnum, HazardousDrivingConditions.VOLCANO_ERUPTION);
		addEEnumLiteral(hazardousDrivingConditionsEEnum, HazardousDrivingConditions.FALLING_ICE);

		initEEnum(objectsOnTheRoadEEnum, ObjectsOnTheRoad.class, "ObjectsOnTheRoad");
		addEEnumLiteral(objectsOnTheRoadEEnum, ObjectsOnTheRoad.SHED_LOAD);
		addEEnumLiteral(objectsOnTheRoadEEnum, ObjectsOnTheRoad.PARTS_OF_VEHICLES);
		addEEnumLiteral(objectsOnTheRoadEEnum, ObjectsOnTheRoad.PARTS_OF_TYRES);
		addEEnumLiteral(objectsOnTheRoadEEnum, ObjectsOnTheRoad.BIG_OBJECTS);
		addEEnumLiteral(objectsOnTheRoadEEnum, ObjectsOnTheRoad.FALLEN_TREES);
		addEEnumLiteral(objectsOnTheRoadEEnum, ObjectsOnTheRoad.HUB_CAPS);
		addEEnumLiteral(objectsOnTheRoadEEnum, ObjectsOnTheRoad.WAITING_VEHICLES);

		initEEnum(animalsOnRoadwayEEnum, AnimalsOnRoadway.class, "AnimalsOnRoadway");
		addEEnumLiteral(animalsOnRoadwayEEnum, AnimalsOnRoadway.WILD_ANIMALS);
		addEEnumLiteral(animalsOnRoadwayEEnum, AnimalsOnRoadway.HERD_OF_ANIMALS);
		addEEnumLiteral(animalsOnRoadwayEEnum, AnimalsOnRoadway.SMALL_ANIMALS);
		addEEnumLiteral(animalsOnRoadwayEEnum, AnimalsOnRoadway.LARGE_ANIMALS);

		initEEnum(peopleOnRoadwayEEnum, PeopleOnRoadway.class, "PeopleOnRoadway");
		addEEnumLiteral(peopleOnRoadwayEEnum, PeopleOnRoadway.CHILDREN_ON_ROADWAY);
		addEEnumLiteral(peopleOnRoadwayEEnum, PeopleOnRoadway.CYCLISTS_ON_ROADWAY);
		addEEnumLiteral(peopleOnRoadwayEEnum, PeopleOnRoadway.MOTOR_CYCLIST_ON_ROADWAY);

		initEEnum(brokenDownVehiclesEEnum, BrokenDownVehicles.class, "BrokenDownVehicles");
		addEEnumLiteral(brokenDownVehiclesEEnum, BrokenDownVehicles.BROKEN_DOWN_VEHICLE_BURNING);
		addEEnumLiteral(brokenDownVehiclesEEnum, BrokenDownVehicles.BROKEN_DOWN_UNLIT_VEHICLE);

		initEEnum(rescueAndRecoveryWorkInProgressEEnum, RescueAndRecoveryWorkInProgress.class, "RescueAndRecoveryWorkInProgress");
		addEEnumLiteral(rescueAndRecoveryWorkInProgressEEnum, RescueAndRecoveryWorkInProgress.EMERGENCY_VEHICLES);
		addEEnumLiteral(rescueAndRecoveryWorkInProgressEEnum, RescueAndRecoveryWorkInProgress.RESCUE_HELICOPTER_LANDING);
		addEEnumLiteral(rescueAndRecoveryWorkInProgressEEnum, RescueAndRecoveryWorkInProgress.POLICE_ACTIVITY_ONGOING);
		addEEnumLiteral(rescueAndRecoveryWorkInProgressEEnum, RescueAndRecoveryWorkInProgress.MEDICAL_EMERGENCY_ONGOING);
		addEEnumLiteral(rescueAndRecoveryWorkInProgressEEnum, RescueAndRecoveryWorkInProgress.CHILD_ABDUCTION_IN_PROGRESS);

		initEEnum(regulatoryMeasureEEnum, RegulatoryMeasure.class, "RegulatoryMeasure");
		addEEnumLiteral(regulatoryMeasureEEnum, RegulatoryMeasure.SECURITY_ALERT);
		addEEnumLiteral(regulatoryMeasureEEnum, RegulatoryMeasure.CONTAGIOUS_DISEASE);
		addEEnumLiteral(regulatoryMeasureEEnum, RegulatoryMeasure.ENVIRONMENTAL);
		addEEnumLiteral(regulatoryMeasureEEnum, RegulatoryMeasure.SMOG_ALERT);
		addEEnumLiteral(regulatoryMeasureEEnum, RegulatoryMeasure.BATCH_SERVICE_IN_PROGRESS);
		addEEnumLiteral(regulatoryMeasureEEnum, RegulatoryMeasure.ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES);

		initEEnum(laneRestrictionTypeEEnum, LaneRestrictionType.class, "LaneRestrictionType");
		addEEnumLiteral(laneRestrictionTypeEEnum, LaneRestrictionType.LANES_CLOSED);
		addEEnumLiteral(laneRestrictionTypeEEnum, LaneRestrictionType.LANES_OPEN);
		addEEnumLiteral(laneRestrictionTypeEEnum, LaneRestrictionType.RIGHT_LANES_CLOSED);
		addEEnumLiteral(laneRestrictionTypeEEnum, LaneRestrictionType.LEFT_LANES_CLOSED);

		initEEnum(adviceCodeEEnum, AdviceCode.class, "AdviceCode");
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.OVERTAKING_NOT_ALLOWED);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.DRIVING_NOT_ALLOWED);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.USE_HARD_SHOULDER_AS_LANE);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.WAIT_FOR_POLICE_PATROL);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.WAIT_FOR_IMPROVED_WEATHER);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.GIVING_PATH_VEHICLES_COMING_FROM_BEHIND);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.FOLLOW_DIVERSION);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.NO_DIVERSION_TO_RECOMMEND);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.DO_NOT_DIVERT);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.FOLLOW_POLICE_INSTRUCTIONS);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.AVOID_THE_AREA);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.DRIVE_CAREFULLY);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.DO_NOT_LEAVE_YOUR_VEHICLE);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.SWITCH_ON_RADIO);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.USE_TOLL_LANES);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.WAIT_FOR_CONVOI);
		addEEnumLiteral(adviceCodeEEnum, AdviceCode.UNDECODABLE_ADVICE);

		initEEnum(vehicleTypeEEnum, VehicleType.class, "VehicleType");
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.CAR);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.LORRY);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.BUS);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.TAXI);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.TRAIN);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.MOTOR_CYCLE);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.VEHICLE_WITH_TRAILER);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.MOTOR_VEHICLES);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.HEAVY_VEHICLE);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.TRANSPORT_OF_DANGEROUS_GOODS);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.TRANSPORT_OF_ABNORMAL_LOAD);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.UNDECODABLE_VEHICLE_TYPE);

		initEEnum(restrictionTypeEEnum, RestrictionType.class, "RestrictionType");
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WIDTH_LESS_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WIDTH_GREATER_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.HEIGTH_LESS_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.HEIGTH_GREATER_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WEIGHT_LESS_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WEIGHT_GREATER_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITHOUT_WINTER_TYRE);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITHOUT_SNOW_CHAIN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITH_TRAILER);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITH_CARAVAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.PERSONS_IN_VEHICLE_LESS_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.PERSONS_IN_VEHICLE_MORE_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.EVEN_NUMBER_PLATE);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.ODD_NUMBER_PLATE);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.LENGTH_LESS_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.LENGTH_GREATER_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.AXLE_LOAD_LESS_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.AXLE_LOAD_GREATER_THAN);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITH_PETROL_ENGINE);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITH_LPG_ENGINE);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITH_DIESEL_ENGINE);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.THROUGH_TRAFFIC);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.RESIDENTS_TRAFFIC);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITH_DESTINATION_IN_GIVEN_AREA);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.UNDECODABLE_RESTRICTION);

		initEEnum(extremeWeatherConditionsEEnum, ExtremeWeatherConditions.class, "ExtremeWeatherConditions");
		addEEnumLiteral(extremeWeatherConditionsEEnum, ExtremeWeatherConditions.STRONG_WINDS);
		addEEnumLiteral(extremeWeatherConditionsEEnum, ExtremeWeatherConditions.DAMAGING_HAIL);
		addEEnumLiteral(extremeWeatherConditionsEEnum, ExtremeWeatherConditions.HURRICANE);
		addEEnumLiteral(extremeWeatherConditionsEEnum, ExtremeWeatherConditions.THUNDERSTORM);
		addEEnumLiteral(extremeWeatherConditionsEEnum, ExtremeWeatherConditions.TORNADO);
		addEEnumLiteral(extremeWeatherConditionsEEnum, ExtremeWeatherConditions.BLIZARD);

		initEEnum(visibilityReducedEEnum, VisibilityReduced.class, "VisibilityReduced");
		addEEnumLiteral(visibilityReducedEEnum, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_FOG);
		addEEnumLiteral(visibilityReducedEEnum, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_SMOKE);
		addEEnumLiteral(visibilityReducedEEnum, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_HEAVY_SNOWFALL);
		addEEnumLiteral(visibilityReducedEEnum, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_HEAVY_RAIN);
		addEEnumLiteral(visibilityReducedEEnum, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_HEAVY_HAIL);
		addEEnumLiteral(visibilityReducedEEnum, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_LOW_SUN_GLARE);
		addEEnumLiteral(visibilityReducedEEnum, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_SANDSTORMS);
		addEEnumLiteral(visibilityReducedEEnum, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_SWARMS_OF_INSECTS);

		initEEnum(precipitationEEnum, Precipitation.class, "Precipitation");
		addEEnumLiteral(precipitationEEnum, Precipitation.HEAVY_RAIN);
		addEEnumLiteral(precipitationEEnum, Precipitation.HEAVY_SNOWFALL);
		addEEnumLiteral(precipitationEEnum, Precipitation.SOFT_HAIL);

		initEEnum(recklessPersonsEEnum, RecklessPersons.class, "RecklessPersons");
		addEEnumLiteral(recklessPersonsEEnum, RecklessPersons.RECKLESS_DRIVER);
		addEEnumLiteral(recklessPersonsEEnum, RecklessPersons.GUNFIRE_ON_ROAD);
		addEEnumLiteral(recklessPersonsEEnum, RecklessPersons.STONE_THROWING_PERSONS);

		initEEnum(majorEventEEnum, MajorEvent.class, "MajorEvent");
		addEEnumLiteral(majorEventEEnum, MajorEvent.SPORTS_EVENT);
		addEEnumLiteral(majorEventEEnum, MajorEvent.DEMONSTRATION);
		addEEnumLiteral(majorEventEEnum, MajorEvent.DEMONSTRATION_WITH_VEHICLES);
		addEEnumLiteral(majorEventEEnum, MajorEvent.CONCERT);
		addEEnumLiteral(majorEventEEnum, MajorEvent.FAIR);
		addEEnumLiteral(majorEventEEnum, MajorEvent.MILITARY_TRAINING);
		addEEnumLiteral(majorEventEEnum, MajorEvent.EMERGENCY_TRAINING);
		addEEnumLiteral(majorEventEEnum, MajorEvent.FESTIVITY);
		addEEnumLiteral(majorEventEEnum, MajorEvent.PROCESSION);

		initEEnum(serviceNotOperatingEEnum, ServiceNotOperating.class, "ServiceNotOperating");
		addEEnumLiteral(serviceNotOperatingEEnum, ServiceNotOperating.FERRY_SERVICE_NOT_OPERATING);
		addEEnumLiteral(serviceNotOperatingEEnum, ServiceNotOperating.PLANE_SERVICE_NOT_OPERATING);
		addEEnumLiteral(serviceNotOperatingEEnum, ServiceNotOperating.TRAIN_SERVICE_NOT_OPERATING);
		addEEnumLiteral(serviceNotOperatingEEnum, ServiceNotOperating.BUS_SERVICE_NOT_OPERATING);

		initEEnum(serviceNotUsableEEnum, ServiceNotUsable.class, "ServiceNotUsable");
		addEEnumLiteral(serviceNotUsableEEnum, ServiceNotUsable.FUEL_STATION_CLOSED);
		addEEnumLiteral(serviceNotUsableEEnum, ServiceNotUsable.SERVICE_AREA_CLOSED);
		addEEnumLiteral(serviceNotUsableEEnum, ServiceNotUsable.SERVICE_AREA_BUSY);
		addEEnumLiteral(serviceNotUsableEEnum, ServiceNotUsable.PARKING_FULL);
		addEEnumLiteral(serviceNotUsableEEnum, ServiceNotUsable.CAR_PARK_CLOSED);

		initEEnum(slowMovingVehiclesEEnum, SlowMovingVehicles.class, "SlowMovingVehicles");
		addEEnumLiteral(slowMovingVehiclesEEnum, SlowMovingVehicles.SLOW_MOVING_MAINTENANCE_VEHICLE);
		addEEnumLiteral(slowMovingVehiclesEEnum, SlowMovingVehicles.VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT);
		addEEnumLiteral(slowMovingVehiclesEEnum, SlowMovingVehicles.ABNORMAL_LOAD);
		addEEnumLiteral(slowMovingVehiclesEEnum, SlowMovingVehicles.ABNORMAL_WIDE_LOAD);
		addEEnumLiteral(slowMovingVehiclesEEnum, SlowMovingVehicles.CONVOY);
		addEEnumLiteral(slowMovingVehiclesEEnum, SlowMovingVehicles.SNOWPLOUGH);
		addEEnumLiteral(slowMovingVehiclesEEnum, SlowMovingVehicles.DEICING);
		addEEnumLiteral(slowMovingVehiclesEEnum, SlowMovingVehicles.SALTING_VEHICLES);

		initEEnum(dangerousEndOfQueueEEnum, DangerousEndOfQueue.class, "DangerousEndOfQueue");
		addEEnumLiteral(dangerousEndOfQueueEEnum, DangerousEndOfQueue.SUDDEN_END_OF_QUEUE);
		addEEnumLiteral(dangerousEndOfQueueEEnum, DangerousEndOfQueue.QUEUE_OVER_HILL);
		addEEnumLiteral(dangerousEndOfQueueEEnum, DangerousEndOfQueue.QUEUE_AROUND_BEND);
		addEEnumLiteral(dangerousEndOfQueueEEnum, DangerousEndOfQueue.QUEUE_IN_TUNNEL);

		initEEnum(riskOfFireEEnum, RiskOfFire.class, "RiskOfFire");
		addEEnumLiteral(riskOfFireEEnum, RiskOfFire.LEAKAGE_OF_FUEL);
		addEEnumLiteral(riskOfFireEEnum, RiskOfFire.LEAKAGE_OF_GAS);

		initEEnum(timeDelayEEnum, TimeDelay.class, "TimeDelay");
		addEEnumLiteral(timeDelayEEnum, TimeDelay.TIME_DELAY_AT_FRONTIER);
		addEEnumLiteral(timeDelayEEnum, TimeDelay.TIME_DELAY_AT_FERRY_PORT);
		addEEnumLiteral(timeDelayEEnum, TimeDelay.TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL);

		initEEnum(policeCheckpointEEnum, PoliceCheckpoint.class, "PoliceCheckpoint");
		addEEnumLiteral(policeCheckpointEEnum, PoliceCheckpoint.PERMANENT_POLICE_CHECKPOINT);
		addEEnumLiteral(policeCheckpointEEnum, PoliceCheckpoint.TEMPORARY_POLICE_CHECKPOINT);

		initEEnum(malfunctioningRoadsideEquipmentEEnum, MalfunctioningRoadsideEquipment.class, "MalfunctioningRoadsideEquipment");
		addEEnumLiteral(malfunctioningRoadsideEquipmentEEnum, MalfunctioningRoadsideEquipment.ROAD_RAIL_CROSSING_FAILURE);
		addEEnumLiteral(malfunctioningRoadsideEquipmentEEnum, MalfunctioningRoadsideEquipment.TUNNEL_VENTILATION_NOT_WORKING);
		addEEnumLiteral(malfunctioningRoadsideEquipmentEEnum, MalfunctioningRoadsideEquipment.TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY);
		addEEnumLiteral(malfunctioningRoadsideEquipmentEEnum, MalfunctioningRoadsideEquipment.EMERGENCY_TELEPHONES_NOT_WORKING);
		addEEnumLiteral(malfunctioningRoadsideEquipmentEEnum, MalfunctioningRoadsideEquipment.AUTOMATIC_PAYMENT_LANES_NOT_WORKING);

		initEEnum(overtakingNotAllowedEEnum, OvertakingNotAllowed.class, "OvertakingNotAllowed");
		addEEnumLiteral(overtakingNotAllowedEEnum, OvertakingNotAllowed.DO_NOT_USE_OVERTAKING_LANES);
		addEEnumLiteral(overtakingNotAllowedEEnum, OvertakingNotAllowed.OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE);
		addEEnumLiteral(overtakingNotAllowedEEnum, OvertakingNotAllowed.OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE);
		addEEnumLiteral(overtakingNotAllowedEEnum, OvertakingNotAllowed.OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE);

		initEEnum(drivingNotAllowedEEnum, DrivingNotAllowed.class, "DrivingNotAllowed");
		addEEnumLiteral(drivingNotAllowedEEnum, DrivingNotAllowed.DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE);

		initEEnum(givingPathVehiclesFromBehindEEnum, GivingPathVehiclesFromBehind.class, "GivingPathVehiclesFromBehind");
		addEEnumLiteral(givingPathVehiclesFromBehindEEnum, GivingPathVehiclesFromBehind.GIVING_PATH_FOR_RESCUE_VEHICLE);
		addEEnumLiteral(givingPathVehiclesFromBehindEEnum, GivingPathVehiclesFromBehind.GIVING_PATH_FOR_SERVICE_VEHICLES);

		initEEnum(followDiversionEEnum, FollowDiversion.class, "FollowDiversion");
		addEEnumLiteral(followDiversionEEnum, FollowDiversion.FOLLOW_DIVERSION_SIGNS);

		initEEnum(driveCarefullyEEnum, DriveCarefully.class, "DriveCarefully");
		addEEnumLiteral(driveCarefullyEEnum, DriveCarefully.DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD);
		addEEnumLiteral(driveCarefullyEEnum, DriveCarefully.DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD);
		addEEnumLiteral(driveCarefullyEEnum, DriveCarefully.DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE);

		initEEnum(doNotLeaveYourVehicleEEnum, DoNotLeaveYourVehicle.class, "DoNotLeaveYourVehicle");
		addEEnumLiteral(doNotLeaveYourVehicleEEnum, DoNotLeaveYourVehicle.DO_NOT_LEAVE_YOUR_VEHICLE);
		addEEnumLiteral(doNotLeaveYourVehicleEEnum, DoNotLeaveYourVehicle.DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS);

		initEEnum(useTollLanesEEnum, UseTollLanes.class, "UseTollLanes");
		addEEnumLiteral(useTollLanesEEnum, UseTollLanes.USE_MANUAL_PAYMENT_TOLL_LANES);
		addEEnumLiteral(useTollLanesEEnum, UseTollLanes.USE_AUTOMATIC_PAYMENT_TOLL_LANES);

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

} //EventPackageImpl
