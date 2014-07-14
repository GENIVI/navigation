/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidenttables.impl;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genivi.common.CommonPackage;

import org.genivi.location.LocationPackage;

import org.genivi.trafficincidentsservice.trafficincidenttables.Accident;
import org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode;
import org.genivi.trafficincidentsservice.trafficincidenttables.AnimalsOnRoadway;
import org.genivi.trafficincidentsservice.trafficincidenttables.BrokenDownVehicles;
import org.genivi.trafficincidentsservice.trafficincidenttables.CauseCode;
import org.genivi.trafficincidentsservice.trafficincidenttables.DangerousEndOfQueue;
import org.genivi.trafficincidentsservice.trafficincidenttables.DoNotLeaveYourVehicle;
import org.genivi.trafficincidentsservice.trafficincidenttables.DriveCarefully;
import org.genivi.trafficincidentsservice.trafficincidenttables.DrivingNotAllowed;
import org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode;
import org.genivi.trafficincidentsservice.trafficincidenttables.ExtremeWeatherConditions;
import org.genivi.trafficincidentsservice.trafficincidenttables.Fire;
import org.genivi.trafficincidentsservice.trafficincidenttables.FollowDiversion;
import org.genivi.trafficincidentsservice.trafficincidenttables.GivingPathVehiclesFromBehind;
import org.genivi.trafficincidentsservice.trafficincidenttables.HazardousDrivingConditions;
import org.genivi.trafficincidentsservice.trafficincidenttables.Impassibility;
import org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType;
import org.genivi.trafficincidentsservice.trafficincidenttables.MajorEvent;
import org.genivi.trafficincidentsservice.trafficincidenttables.MalfunctioningRoadsideEquipment;
import org.genivi.trafficincidentsservice.trafficincidenttables.NarrowLanes;
import org.genivi.trafficincidentsservice.trafficincidenttables.ObjectsOnTheRoad;
import org.genivi.trafficincidentsservice.trafficincidenttables.OvertakingNotAllowed;
import org.genivi.trafficincidentsservice.trafficincidenttables.PeopleOnRoadway;
import org.genivi.trafficincidentsservice.trafficincidenttables.PoliceCheckpoint;
import org.genivi.trafficincidentsservice.trafficincidenttables.Precipitation;
import org.genivi.trafficincidentsservice.trafficincidenttables.RecklessPersons;
import org.genivi.trafficincidentsservice.trafficincidenttables.RegulatoryMeasure;
import org.genivi.trafficincidentsservice.trafficincidenttables.RescueAndRecoveryWorkInProgress;
import org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType;
import org.genivi.trafficincidentsservice.trafficincidenttables.RiskOfFire;
import org.genivi.trafficincidentsservice.trafficincidenttables.RoadWorks;
import org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotOperating;
import org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotUsable;
import org.genivi.trafficincidentsservice.trafficincidenttables.SlipperyRoad;
import org.genivi.trafficincidentsservice.trafficincidenttables.SlowMovingVehicles;
import org.genivi.trafficincidentsservice.trafficincidenttables.Tendency;
import org.genivi.trafficincidentsservice.trafficincidenttables.TimeDelay;
import org.genivi.trafficincidentsservice.trafficincidenttables.TrafficCongestion;
import org.genivi.trafficincidentsservice.trafficincidenttables.UseTollLanes;
import org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType;
import org.genivi.trafficincidentsservice.trafficincidenttables.VisibilityReduced;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;
import org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesFactory;
import org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class trafficincidenttablesPackageImpl extends EPackageImpl implements trafficincidenttablesPackage {
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
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private trafficincidenttablesPackageImpl() {
		super(eNS_URI, trafficincidenttablesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link trafficincidenttablesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static trafficincidenttablesPackage init() {
		if (isInited) return (trafficincidenttablesPackage)EPackage.Registry.INSTANCE.getEPackage(trafficincidenttablesPackage.eNS_URI);

		// Obtain or create and register package
		trafficincidenttablesPackageImpl thetrafficincidenttablesPackage = (trafficincidenttablesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof trafficincidenttablesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new trafficincidenttablesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		LocationPackage.eINSTANCE.eClass();
		CommonPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thetrafficincidenttablesPackage.createPackageContents();

		// Initialize created meta-data
		thetrafficincidenttablesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thetrafficincidenttablesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(trafficincidenttablesPackage.eNS_URI, thetrafficincidenttablesPackage);
		return thetrafficincidenttablesPackage;
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
  public trafficincidenttablesFactory gettrafficincidenttablesFactory() {
		return (trafficincidenttablesFactory)getEFactoryInstance();
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

		initEEnum(vehicleTypeEEnum, VehicleType.class, "VehicleType");
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.CAR);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.LORRY);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.BUS);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.TAXI);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.TRAIN);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.MOTOR_CYCLE);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.VEHICLE_WITH_TRAILER);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.MOTOR_VEHICLES);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.TRANSPORT_OF_DANGEROUS_GOODS);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.TRANSPORT_OF_ABNORMAL_LOAD);
		addEEnumLiteral(vehicleTypeEEnum, VehicleType.HEAVY_VEHICLE);

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
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.VEHICLE_FULFILLS_EMISSION_STANDARD_EURO3);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.VEHICLE_FULFILLS_EMISSION_STANDARD_EURO3D4);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.VEHICLE_FULFILLS_EMISSION_STANDARD_EURO4);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.VEHICLE_FULFILLS_EMISSION_STANDARD_EURO5);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITH_PETROL_ENGINE);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITH_DIESEL_ENGINE);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITH_LPG_ENGINE);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.THROUGH_TRAFFIC);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.RESIDENTS_TRAFFIC);
		addEEnumLiteral(restrictionTypeEEnum, RestrictionType.WITH_DESTINATION_IN_GIVEN_AREA);

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

} //trafficincidenttablesPackageImpl
