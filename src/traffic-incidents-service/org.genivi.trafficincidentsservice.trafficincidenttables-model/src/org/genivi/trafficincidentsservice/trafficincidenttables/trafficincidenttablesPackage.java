/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidenttables;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface trafficincidenttablesPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "trafficincidenttables";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://org.genivi.trafficinfo.trafficincidenttables";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "TrafficIncidentTables";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  trafficincidenttablesPackage eINSTANCE = org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode <em>Effect Code</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getEffectCode()
	 * @generated
	 */
  int EFFECT_CODE = 0;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Tendency <em>Tendency</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Tendency
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getTendency()
	 * @generated
	 */
  int TENDENCY = 1;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.CauseCode <em>Cause Code</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.CauseCode
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getCauseCode()
	 * @generated
	 */
  int CAUSE_CODE = 2;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel <em>Warning Level</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getWarningLevel()
	 * @generated
	 */
  int WARNING_LEVEL = 3;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.TrafficCongestion <em>Traffic Congestion</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.TrafficCongestion
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getTrafficCongestion()
	 * @generated
	 */
  int TRAFFIC_CONGESTION = 4;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Accident <em>Accident</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Accident
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getAccident()
	 * @generated
	 */
  int ACCIDENT = 5;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RoadWorks <em>Road Works</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RoadWorks
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRoadWorks()
	 * @generated
	 */
  int ROAD_WORKS = 6;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.NarrowLanes <em>Narrow Lanes</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.NarrowLanes
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getNarrowLanes()
	 * @generated
	 */
  int NARROW_LANES = 7;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Impassibility <em>Impassibility</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Impassibility
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getImpassibility()
	 * @generated
	 */
  int IMPASSIBILITY = 8;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.SlipperyRoad <em>Slippery Road</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.SlipperyRoad
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getSlipperyRoad()
	 * @generated
	 */
  int SLIPPERY_ROAD = 9;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Fire <em>Fire</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Fire
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getFire()
	 * @generated
	 */
  int FIRE = 10;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.HazardousDrivingConditions <em>Hazardous Driving Conditions</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.HazardousDrivingConditions
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getHazardousDrivingConditions()
	 * @generated
	 */
  int HAZARDOUS_DRIVING_CONDITIONS = 11;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ObjectsOnTheRoad <em>Objects On The Road</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ObjectsOnTheRoad
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getObjectsOnTheRoad()
	 * @generated
	 */
  int OBJECTS_ON_THE_ROAD = 12;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.AnimalsOnRoadway <em>Animals On Roadway</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.AnimalsOnRoadway
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getAnimalsOnRoadway()
	 * @generated
	 */
  int ANIMALS_ON_ROADWAY = 13;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.PeopleOnRoadway <em>People On Roadway</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.PeopleOnRoadway
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getPeopleOnRoadway()
	 * @generated
	 */
  int PEOPLE_ON_ROADWAY = 14;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.BrokenDownVehicles <em>Broken Down Vehicles</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.BrokenDownVehicles
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getBrokenDownVehicles()
	 * @generated
	 */
  int BROKEN_DOWN_VEHICLES = 15;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RescueAndRecoveryWorkInProgress <em>Rescue And Recovery Work In Progress</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RescueAndRecoveryWorkInProgress
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRescueAndRecoveryWorkInProgress()
	 * @generated
	 */
  int RESCUE_AND_RECOVERY_WORK_IN_PROGRESS = 16;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RegulatoryMeasure <em>Regulatory Measure</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RegulatoryMeasure
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRegulatoryMeasure()
	 * @generated
	 */
  int REGULATORY_MEASURE = 17;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType <em>Lane Restriction Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getLaneRestrictionType()
	 * @generated
	 */
  int LANE_RESTRICTION_TYPE = 18;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode <em>Advice Code</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getAdviceCode()
	 * @generated
	 */
  int ADVICE_CODE = 19;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType <em>Vehicle Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getVehicleType()
	 * @generated
	 */
  int VEHICLE_TYPE = 20;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType <em>Restriction Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRestrictionType()
	 * @generated
	 */
  int RESTRICTION_TYPE = 21;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ExtremeWeatherConditions <em>Extreme Weather Conditions</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ExtremeWeatherConditions
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getExtremeWeatherConditions()
	 * @generated
	 */
  int EXTREME_WEATHER_CONDITIONS = 22;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.VisibilityReduced <em>Visibility Reduced</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.VisibilityReduced
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getVisibilityReduced()
	 * @generated
	 */
  int VISIBILITY_REDUCED = 23;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Precipitation <em>Precipitation</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Precipitation
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getPrecipitation()
	 * @generated
	 */
  int PRECIPITATION = 24;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RecklessPersons <em>Reckless Persons</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RecklessPersons
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRecklessPersons()
	 * @generated
	 */
  int RECKLESS_PERSONS = 25;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.MajorEvent <em>Major Event</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.MajorEvent
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getMajorEvent()
	 * @generated
	 */
  int MAJOR_EVENT = 26;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotOperating <em>Service Not Operating</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotOperating
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getServiceNotOperating()
	 * @generated
	 */
  int SERVICE_NOT_OPERATING = 27;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotUsable <em>Service Not Usable</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotUsable
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getServiceNotUsable()
	 * @generated
	 */
  int SERVICE_NOT_USABLE = 28;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.SlowMovingVehicles <em>Slow Moving Vehicles</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.SlowMovingVehicles
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getSlowMovingVehicles()
	 * @generated
	 */
  int SLOW_MOVING_VEHICLES = 29;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DangerousEndOfQueue <em>Dangerous End Of Queue</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DangerousEndOfQueue
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getDangerousEndOfQueue()
	 * @generated
	 */
  int DANGEROUS_END_OF_QUEUE = 30;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RiskOfFire <em>Risk Of Fire</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RiskOfFire
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRiskOfFire()
	 * @generated
	 */
  int RISK_OF_FIRE = 31;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.TimeDelay <em>Time Delay</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.TimeDelay
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getTimeDelay()
	 * @generated
	 */
  int TIME_DELAY = 32;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.PoliceCheckpoint <em>Police Checkpoint</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.PoliceCheckpoint
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getPoliceCheckpoint()
	 * @generated
	 */
  int POLICE_CHECKPOINT = 33;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.MalfunctioningRoadsideEquipment <em>Malfunctioning Roadside Equipment</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.MalfunctioningRoadsideEquipment
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getMalfunctioningRoadsideEquipment()
	 * @generated
	 */
  int MALFUNCTIONING_ROADSIDE_EQUIPMENT = 34;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.OvertakingNotAllowed <em>Overtaking Not Allowed</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.OvertakingNotAllowed
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getOvertakingNotAllowed()
	 * @generated
	 */
  int OVERTAKING_NOT_ALLOWED = 35;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DrivingNotAllowed <em>Driving Not Allowed</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DrivingNotAllowed
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getDrivingNotAllowed()
	 * @generated
	 */
  int DRIVING_NOT_ALLOWED = 36;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.GivingPathVehiclesFromBehind <em>Giving Path Vehicles From Behind</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.GivingPathVehiclesFromBehind
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getGivingPathVehiclesFromBehind()
	 * @generated
	 */
  int GIVING_PATH_VEHICLES_FROM_BEHIND = 37;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.FollowDiversion <em>Follow Diversion</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.FollowDiversion
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getFollowDiversion()
	 * @generated
	 */
  int FOLLOW_DIVERSION = 38;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DriveCarefully <em>Drive Carefully</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DriveCarefully
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getDriveCarefully()
	 * @generated
	 */
  int DRIVE_CAREFULLY = 39;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DoNotLeaveYourVehicle <em>Do Not Leave Your Vehicle</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DoNotLeaveYourVehicle
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getDoNotLeaveYourVehicle()
	 * @generated
	 */
  int DO_NOT_LEAVE_YOUR_VEHICLE = 40;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.UseTollLanes <em>Use Toll Lanes</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.UseTollLanes
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getUseTollLanes()
	 * @generated
	 */
  int USE_TOLL_LANES = 41;


  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode <em>Effect Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Effect Code</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode
	 * @generated
	 */
  EEnum getEffectCode();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Tendency <em>Tendency</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tendency</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Tendency
	 * @generated
	 */
  EEnum getTendency();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.CauseCode <em>Cause Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cause Code</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.CauseCode
	 * @generated
	 */
  EEnum getCauseCode();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel <em>Warning Level</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Warning Level</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel
	 * @generated
	 */
  EEnum getWarningLevel();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.TrafficCongestion <em>Traffic Congestion</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Traffic Congestion</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.TrafficCongestion
	 * @generated
	 */
  EEnum getTrafficCongestion();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Accident <em>Accident</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Accident</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Accident
	 * @generated
	 */
  EEnum getAccident();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RoadWorks <em>Road Works</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Road Works</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RoadWorks
	 * @generated
	 */
  EEnum getRoadWorks();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.NarrowLanes <em>Narrow Lanes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Narrow Lanes</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.NarrowLanes
	 * @generated
	 */
  EEnum getNarrowLanes();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Impassibility <em>Impassibility</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Impassibility</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Impassibility
	 * @generated
	 */
  EEnum getImpassibility();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.SlipperyRoad <em>Slippery Road</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Slippery Road</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.SlipperyRoad
	 * @generated
	 */
  EEnum getSlipperyRoad();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Fire <em>Fire</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fire</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Fire
	 * @generated
	 */
  EEnum getFire();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.HazardousDrivingConditions <em>Hazardous Driving Conditions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Hazardous Driving Conditions</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.HazardousDrivingConditions
	 * @generated
	 */
  EEnum getHazardousDrivingConditions();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ObjectsOnTheRoad <em>Objects On The Road</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Objects On The Road</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ObjectsOnTheRoad
	 * @generated
	 */
  EEnum getObjectsOnTheRoad();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.AnimalsOnRoadway <em>Animals On Roadway</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Animals On Roadway</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.AnimalsOnRoadway
	 * @generated
	 */
  EEnum getAnimalsOnRoadway();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.PeopleOnRoadway <em>People On Roadway</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>People On Roadway</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.PeopleOnRoadway
	 * @generated
	 */
  EEnum getPeopleOnRoadway();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.BrokenDownVehicles <em>Broken Down Vehicles</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Broken Down Vehicles</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.BrokenDownVehicles
	 * @generated
	 */
  EEnum getBrokenDownVehicles();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RescueAndRecoveryWorkInProgress <em>Rescue And Recovery Work In Progress</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rescue And Recovery Work In Progress</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RescueAndRecoveryWorkInProgress
	 * @generated
	 */
  EEnum getRescueAndRecoveryWorkInProgress();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RegulatoryMeasure <em>Regulatory Measure</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Regulatory Measure</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RegulatoryMeasure
	 * @generated
	 */
  EEnum getRegulatoryMeasure();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType <em>Lane Restriction Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Lane Restriction Type</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType
	 * @generated
	 */
  EEnum getLaneRestrictionType();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode <em>Advice Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Advice Code</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode
	 * @generated
	 */
  EEnum getAdviceCode();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType <em>Vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Vehicle Type</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType
	 * @generated
	 */
  EEnum getVehicleType();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType <em>Restriction Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Restriction Type</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType
	 * @generated
	 */
  EEnum getRestrictionType();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ExtremeWeatherConditions <em>Extreme Weather Conditions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Extreme Weather Conditions</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ExtremeWeatherConditions
	 * @generated
	 */
  EEnum getExtremeWeatherConditions();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.VisibilityReduced <em>Visibility Reduced</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility Reduced</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.VisibilityReduced
	 * @generated
	 */
  EEnum getVisibilityReduced();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Precipitation <em>Precipitation</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Precipitation</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Precipitation
	 * @generated
	 */
  EEnum getPrecipitation();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RecklessPersons <em>Reckless Persons</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Reckless Persons</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RecklessPersons
	 * @generated
	 */
  EEnum getRecklessPersons();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.MajorEvent <em>Major Event</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Major Event</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.MajorEvent
	 * @generated
	 */
  EEnum getMajorEvent();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotOperating <em>Service Not Operating</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Not Operating</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotOperating
	 * @generated
	 */
  EEnum getServiceNotOperating();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotUsable <em>Service Not Usable</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Not Usable</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotUsable
	 * @generated
	 */
  EEnum getServiceNotUsable();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.SlowMovingVehicles <em>Slow Moving Vehicles</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Slow Moving Vehicles</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.SlowMovingVehicles
	 * @generated
	 */
  EEnum getSlowMovingVehicles();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DangerousEndOfQueue <em>Dangerous End Of Queue</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dangerous End Of Queue</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DangerousEndOfQueue
	 * @generated
	 */
  EEnum getDangerousEndOfQueue();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RiskOfFire <em>Risk Of Fire</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Risk Of Fire</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RiskOfFire
	 * @generated
	 */
  EEnum getRiskOfFire();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.TimeDelay <em>Time Delay</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Delay</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.TimeDelay
	 * @generated
	 */
  EEnum getTimeDelay();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.PoliceCheckpoint <em>Police Checkpoint</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Police Checkpoint</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.PoliceCheckpoint
	 * @generated
	 */
  EEnum getPoliceCheckpoint();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.MalfunctioningRoadsideEquipment <em>Malfunctioning Roadside Equipment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Malfunctioning Roadside Equipment</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.MalfunctioningRoadsideEquipment
	 * @generated
	 */
  EEnum getMalfunctioningRoadsideEquipment();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.OvertakingNotAllowed <em>Overtaking Not Allowed</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Overtaking Not Allowed</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.OvertakingNotAllowed
	 * @generated
	 */
  EEnum getOvertakingNotAllowed();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DrivingNotAllowed <em>Driving Not Allowed</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Driving Not Allowed</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DrivingNotAllowed
	 * @generated
	 */
  EEnum getDrivingNotAllowed();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.GivingPathVehiclesFromBehind <em>Giving Path Vehicles From Behind</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Giving Path Vehicles From Behind</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.GivingPathVehiclesFromBehind
	 * @generated
	 */
  EEnum getGivingPathVehiclesFromBehind();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.FollowDiversion <em>Follow Diversion</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Follow Diversion</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.FollowDiversion
	 * @generated
	 */
  EEnum getFollowDiversion();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DriveCarefully <em>Drive Carefully</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Drive Carefully</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DriveCarefully
	 * @generated
	 */
  EEnum getDriveCarefully();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DoNotLeaveYourVehicle <em>Do Not Leave Your Vehicle</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Do Not Leave Your Vehicle</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DoNotLeaveYourVehicle
	 * @generated
	 */
  EEnum getDoNotLeaveYourVehicle();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.trafficincidenttables.UseTollLanes <em>Use Toll Lanes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Use Toll Lanes</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.UseTollLanes
	 * @generated
	 */
  EEnum getUseTollLanes();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  trafficincidenttablesFactory gettrafficincidenttablesFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals {
    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode <em>Effect Code</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getEffectCode()
		 * @generated
		 */
    EEnum EFFECT_CODE = eINSTANCE.getEffectCode();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Tendency <em>Tendency</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Tendency
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getTendency()
		 * @generated
		 */
    EEnum TENDENCY = eINSTANCE.getTendency();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.CauseCode <em>Cause Code</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.CauseCode
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getCauseCode()
		 * @generated
		 */
    EEnum CAUSE_CODE = eINSTANCE.getCauseCode();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel <em>Warning Level</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getWarningLevel()
		 * @generated
		 */
    EEnum WARNING_LEVEL = eINSTANCE.getWarningLevel();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.TrafficCongestion <em>Traffic Congestion</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.TrafficCongestion
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getTrafficCongestion()
		 * @generated
		 */
    EEnum TRAFFIC_CONGESTION = eINSTANCE.getTrafficCongestion();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Accident <em>Accident</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Accident
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getAccident()
		 * @generated
		 */
    EEnum ACCIDENT = eINSTANCE.getAccident();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RoadWorks <em>Road Works</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RoadWorks
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRoadWorks()
		 * @generated
		 */
    EEnum ROAD_WORKS = eINSTANCE.getRoadWorks();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.NarrowLanes <em>Narrow Lanes</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.NarrowLanes
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getNarrowLanes()
		 * @generated
		 */
    EEnum NARROW_LANES = eINSTANCE.getNarrowLanes();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Impassibility <em>Impassibility</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Impassibility
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getImpassibility()
		 * @generated
		 */
    EEnum IMPASSIBILITY = eINSTANCE.getImpassibility();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.SlipperyRoad <em>Slippery Road</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.SlipperyRoad
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getSlipperyRoad()
		 * @generated
		 */
    EEnum SLIPPERY_ROAD = eINSTANCE.getSlipperyRoad();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Fire <em>Fire</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Fire
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getFire()
		 * @generated
		 */
    EEnum FIRE = eINSTANCE.getFire();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.HazardousDrivingConditions <em>Hazardous Driving Conditions</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.HazardousDrivingConditions
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getHazardousDrivingConditions()
		 * @generated
		 */
    EEnum HAZARDOUS_DRIVING_CONDITIONS = eINSTANCE.getHazardousDrivingConditions();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ObjectsOnTheRoad <em>Objects On The Road</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ObjectsOnTheRoad
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getObjectsOnTheRoad()
		 * @generated
		 */
    EEnum OBJECTS_ON_THE_ROAD = eINSTANCE.getObjectsOnTheRoad();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.AnimalsOnRoadway <em>Animals On Roadway</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.AnimalsOnRoadway
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getAnimalsOnRoadway()
		 * @generated
		 */
    EEnum ANIMALS_ON_ROADWAY = eINSTANCE.getAnimalsOnRoadway();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.PeopleOnRoadway <em>People On Roadway</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.PeopleOnRoadway
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getPeopleOnRoadway()
		 * @generated
		 */
    EEnum PEOPLE_ON_ROADWAY = eINSTANCE.getPeopleOnRoadway();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.BrokenDownVehicles <em>Broken Down Vehicles</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.BrokenDownVehicles
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getBrokenDownVehicles()
		 * @generated
		 */
    EEnum BROKEN_DOWN_VEHICLES = eINSTANCE.getBrokenDownVehicles();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RescueAndRecoveryWorkInProgress <em>Rescue And Recovery Work In Progress</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RescueAndRecoveryWorkInProgress
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRescueAndRecoveryWorkInProgress()
		 * @generated
		 */
    EEnum RESCUE_AND_RECOVERY_WORK_IN_PROGRESS = eINSTANCE.getRescueAndRecoveryWorkInProgress();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RegulatoryMeasure <em>Regulatory Measure</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RegulatoryMeasure
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRegulatoryMeasure()
		 * @generated
		 */
    EEnum REGULATORY_MEASURE = eINSTANCE.getRegulatoryMeasure();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType <em>Lane Restriction Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getLaneRestrictionType()
		 * @generated
		 */
    EEnum LANE_RESTRICTION_TYPE = eINSTANCE.getLaneRestrictionType();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode <em>Advice Code</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getAdviceCode()
		 * @generated
		 */
    EEnum ADVICE_CODE = eINSTANCE.getAdviceCode();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType <em>Vehicle Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getVehicleType()
		 * @generated
		 */
    EEnum VEHICLE_TYPE = eINSTANCE.getVehicleType();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType <em>Restriction Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRestrictionType()
		 * @generated
		 */
    EEnum RESTRICTION_TYPE = eINSTANCE.getRestrictionType();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ExtremeWeatherConditions <em>Extreme Weather Conditions</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ExtremeWeatherConditions
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getExtremeWeatherConditions()
		 * @generated
		 */
    EEnum EXTREME_WEATHER_CONDITIONS = eINSTANCE.getExtremeWeatherConditions();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.VisibilityReduced <em>Visibility Reduced</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.VisibilityReduced
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getVisibilityReduced()
		 * @generated
		 */
    EEnum VISIBILITY_REDUCED = eINSTANCE.getVisibilityReduced();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.Precipitation <em>Precipitation</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Precipitation
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getPrecipitation()
		 * @generated
		 */
    EEnum PRECIPITATION = eINSTANCE.getPrecipitation();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RecklessPersons <em>Reckless Persons</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RecklessPersons
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRecklessPersons()
		 * @generated
		 */
    EEnum RECKLESS_PERSONS = eINSTANCE.getRecklessPersons();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.MajorEvent <em>Major Event</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.MajorEvent
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getMajorEvent()
		 * @generated
		 */
    EEnum MAJOR_EVENT = eINSTANCE.getMajorEvent();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotOperating <em>Service Not Operating</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotOperating
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getServiceNotOperating()
		 * @generated
		 */
    EEnum SERVICE_NOT_OPERATING = eINSTANCE.getServiceNotOperating();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotUsable <em>Service Not Usable</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.ServiceNotUsable
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getServiceNotUsable()
		 * @generated
		 */
    EEnum SERVICE_NOT_USABLE = eINSTANCE.getServiceNotUsable();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.SlowMovingVehicles <em>Slow Moving Vehicles</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.SlowMovingVehicles
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getSlowMovingVehicles()
		 * @generated
		 */
    EEnum SLOW_MOVING_VEHICLES = eINSTANCE.getSlowMovingVehicles();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DangerousEndOfQueue <em>Dangerous End Of Queue</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DangerousEndOfQueue
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getDangerousEndOfQueue()
		 * @generated
		 */
    EEnum DANGEROUS_END_OF_QUEUE = eINSTANCE.getDangerousEndOfQueue();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.RiskOfFire <em>Risk Of Fire</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RiskOfFire
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getRiskOfFire()
		 * @generated
		 */
    EEnum RISK_OF_FIRE = eINSTANCE.getRiskOfFire();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.TimeDelay <em>Time Delay</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.TimeDelay
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getTimeDelay()
		 * @generated
		 */
    EEnum TIME_DELAY = eINSTANCE.getTimeDelay();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.PoliceCheckpoint <em>Police Checkpoint</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.PoliceCheckpoint
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getPoliceCheckpoint()
		 * @generated
		 */
    EEnum POLICE_CHECKPOINT = eINSTANCE.getPoliceCheckpoint();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.MalfunctioningRoadsideEquipment <em>Malfunctioning Roadside Equipment</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.MalfunctioningRoadsideEquipment
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getMalfunctioningRoadsideEquipment()
		 * @generated
		 */
    EEnum MALFUNCTIONING_ROADSIDE_EQUIPMENT = eINSTANCE.getMalfunctioningRoadsideEquipment();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.OvertakingNotAllowed <em>Overtaking Not Allowed</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.OvertakingNotAllowed
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getOvertakingNotAllowed()
		 * @generated
		 */
    EEnum OVERTAKING_NOT_ALLOWED = eINSTANCE.getOvertakingNotAllowed();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DrivingNotAllowed <em>Driving Not Allowed</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DrivingNotAllowed
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getDrivingNotAllowed()
		 * @generated
		 */
    EEnum DRIVING_NOT_ALLOWED = eINSTANCE.getDrivingNotAllowed();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.GivingPathVehiclesFromBehind <em>Giving Path Vehicles From Behind</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.GivingPathVehiclesFromBehind
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getGivingPathVehiclesFromBehind()
		 * @generated
		 */
    EEnum GIVING_PATH_VEHICLES_FROM_BEHIND = eINSTANCE.getGivingPathVehiclesFromBehind();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.FollowDiversion <em>Follow Diversion</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.FollowDiversion
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getFollowDiversion()
		 * @generated
		 */
    EEnum FOLLOW_DIVERSION = eINSTANCE.getFollowDiversion();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DriveCarefully <em>Drive Carefully</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DriveCarefully
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getDriveCarefully()
		 * @generated
		 */
    EEnum DRIVE_CAREFULLY = eINSTANCE.getDriveCarefully();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.DoNotLeaveYourVehicle <em>Do Not Leave Your Vehicle</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.DoNotLeaveYourVehicle
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getDoNotLeaveYourVehicle()
		 * @generated
		 */
    EEnum DO_NOT_LEAVE_YOUR_VEHICLE = eINSTANCE.getDoNotLeaveYourVehicle();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidenttables.UseTollLanes <em>Use Toll Lanes</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.UseTollLanes
		 * @see org.genivi.trafficincidentsservice.trafficincidenttables.impl.trafficincidenttablesPackageImpl#getUseTollLanes()
		 * @generated
		 */
    EEnum USE_TOLL_LANES = eINSTANCE.getUseTollLanes();

  }

} //trafficincidenttablesPackage
