/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.tpegtecfeed.refimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.genivi.common.CommonFactory;
import org.genivi.common.LocalizedString;
import org.genivi.locref.LocationReference;
import org.genivi.locref.LocationReferenceType;
import org.genivi.locref.locrefFactory;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentFactory;
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
import org.genivi.trafficinfo.tpeg.tec.event.Event;
import org.genivi.trafficinfo.tpeg.tec.event.TECMessage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.Method;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference;
import org.genivi.trafficinfo.tpeg.tpegtables.LanguageCode;


public class TecEventToTrafficIncidentConversion {
  private static final CommonFactory COMMON_FACTORY = CommonFactory.eINSTANCE;
  private static final XTrafficIncidentFactory TI_FACTORY = XTrafficIncidentFactory.eINSTANCE;
  private final static locrefFactory locRefFactory = locrefFactory.eINSTANCE;
  private final static Logger LOGGER = Logger.getLogger(TecEventToTrafficIncidentConversion.class.getName()); 
  
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.EffectCode, EffectCode> effectCodeMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.EffectCode, EffectCode>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.Tendency, Tendency> tendencyMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.Tendency, Tendency>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.CauseCode, CauseCode> causeCodeMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.CauseCode, CauseCode>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.WarningLevel, WarningLevel> warningLevelMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.WarningLevel, WarningLevel>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion, TrafficCongestion> trafficCongestionMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion, TrafficCongestion>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.Accident, Accident> accidentMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.Accident, Accident>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.RoadWorks, RoadWorks> roadWorksMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.RoadWorks, RoadWorks>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes, NarrowLanes> narrowLanesMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes, NarrowLanes>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.Impassibility, Impassibility> impassibilityMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.Impassibility, Impassibility>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad, SlipperyRoad> slipperyRoadMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad, SlipperyRoad>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.Fire, Fire> fireMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.Fire, Fire>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions, HazardousDrivingConditions> hazardousDrivingConditionsMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions, HazardousDrivingConditions>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad, ObjectsOnTheRoad> objectsOnTheRoadMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad, ObjectsOnTheRoad>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway, AnimalsOnRoadway> animalsOnRoadwayMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway, AnimalsOnRoadway>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway, PeopleOnRoadway> peopleOnRoadwayMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway, PeopleOnRoadway>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles, BrokenDownVehicles> brokenDownVehiclesMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles, BrokenDownVehicles>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress, RescueAndRecoveryWorkInProgress> rescueAndRecoveryWorkInProgressMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress, RescueAndRecoveryWorkInProgress>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure, RegulatoryMeasure> regulatoryMeasureMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure, RegulatoryMeasure>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions, ExtremeWeatherConditions> extremeWeatherConditionsMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions, ExtremeWeatherConditions>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced, VisibilityReduced> visibilityReducedMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced, VisibilityReduced>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.Precipitation, Precipitation> precipitationMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.Precipitation, Precipitation>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons, RecklessPersons> recklessPersonsMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons, RecklessPersons>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.MajorEvent, MajorEvent> majorEventMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.MajorEvent, MajorEvent>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating, ServiceNotOperating> serviceNotOperatingMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating, ServiceNotOperating>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable, ServiceNotUsable> serviceNotUsableMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable, ServiceNotUsable>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles, SlowMovingVehicles> slowMovingVehiclesMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles, SlowMovingVehicles>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue, DangerousEndOfQueue> dangerousEndOfQueueMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue, DangerousEndOfQueue>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire, RiskOfFire> riskOfFireMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire, RiskOfFire>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.TimeDelay, TimeDelay> timeDelayMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.TimeDelay, TimeDelay>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint, PoliceCheckpoint> policeCheckpointMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint, PoliceCheckpoint>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment, MalfunctioningRoadsideEquipment> malfunctioningRoadsideEquipmentMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment, MalfunctioningRoadsideEquipment>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType, LaneRestrictionType> laneRestrictionTypeMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType, LaneRestrictionType>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.VehicleType, VehicleType> vehicleTypeMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.VehicleType, VehicleType>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.RestrictionType, RestrictionType> restrictionTypeMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.RestrictionType, RestrictionType>();

  private static Map<org.genivi.trafficinfo.tpeg.tec.event.AdviceCode, AdviceCode> adviceCodeMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.AdviceCode, AdviceCode>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed, OvertakingNotAllowed> overtakingNotAllowedMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed, OvertakingNotAllowed>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed, DrivingNotAllowed> drivingNotAllowedMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed, DrivingNotAllowed>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind, GivingPathVehiclesFromBehind> givingPathVehiclesFromBehindMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind, GivingPathVehiclesFromBehind>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion, FollowDiversion> followDiversionMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion, FollowDiversion>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully, DriveCarefully> driveCarefullyMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully, DriveCarefully>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle, DoNotLeaveYourVehicle> doNotLeaveYourVehicleMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle, DoNotLeaveYourVehicle>();
  private static Map<org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes, UseTollLanes> useTollLanesMap = new HashMap<org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes, UseTollLanes>();
  
  private static Map<Integer, String> languageMap = new HashMap<Integer, String>(); // Maps TPEG LanguageCode to ISO 639-3 code (lower case).
  private static Map<Integer, String> languageCountryMap = new HashMap<Integer, String>();  // Map TPEG LanguageCode to ISO 3166-1 alpha 3 country code (upper case), for the languages where this is applicable.
  
  static {
    fillEffectCodeMap();
    fillTendencyMap();
    fillCauseCodeMap();
    fillWarningLevelMap();
    fillTrafficCongestionMap();
    fillAccidentMap();
    fillRoadWorksMap();
    fillNarrowLanesMap();
    fillImpassibilityMap();
    fillSlipperyRoadMap();
    fillFireMap();
    fillHazardousDrivingConditionsMap();
    fillObjectsOnTheRoadMap();
    fillAnimalsOnRoadwayMap();
    fillPeopleOnRoadwayMap();
    fillBrokenDownVehiclesMap();
    fillRescueAndRecoveryWorkInProgressMap();
    fillRegulatoryMeasureMap();
    fillExtremeWeatherConditionsMap();
    fillVisibilityReducedMap();
    fillPrecipitationMap();
    fillRecklessPersonsMap();
    fillMajorEventMap();
    fillServiceNotOperatingMap();
    fillServiceNotUsableMap();
    fillSlowMovingVehiclesMap();
    fillDangerousEndOfQueueMap();
    fillRiskOfFireMap();
    fillTimeDelayMap();
    fillPoliceCheckpointMap();
    fillMalfunctioningRoadsideEquipmentMap();
    fillLaneRestrictionTypeMap();
    fillVehicleTypeMap();
    fillRestrictionTypeMap();

    fillAdviceCodeMap();
    fillOvertakingNotAllowedMap();
    fillDrivingNotAllowedMap();
    fillGivingPathVehiclesFromBehindMap();
    fillFollowDiversionMap();
    fillDriveCarefullyMap();
    fillDoNotLeaveYourVehicleMap();
    fillUseTollLanesMap();
    
    fillLanguageMap();
    fillLanguageCountryMap();
  }

  public TecEventToTrafficIncidentConversion() {
    LOGGER.setLevel(Level.SEVERE);    
  }
  
  public void setLanguage(String languageCode, String countryCode) {
    LOGGER.info("Ignoring Setting language to: " + languageCode + ", " + countryCode);
    // No action as:
    // - all received texts are passed on to the TrafficIncidentsService.
    // - there is no two way communication to inform the server about the language to use.
  }
  
  public void convertTecMessageToManagedTrafficIncident(TrafficIncident managedTrafficIncident, TECMessage tecMessage) {
    LocationReferencingContainer locationReferencingContainer = tecMessage.getLoc();
    if (locationReferencingContainer == null) {
      throw new RuntimeException("LocationReferenceContainer missing in TEC message with Id " + managedTrafficIncident.getTrafficIncidentId());
    }
    
    for (Method method :locationReferencingContainer.getMethod()) {
      LocationReference locationReference = createLocationReferenceForMethod(method);
      if (locationReference != null) {
        managedTrafficIncident.setLocationReference(locationReference);
      }
    }
    
    convertTecEventToManagedTrafficIncident(managedTrafficIncident, tecMessage.getEvent());
  }
  
  private static LocationReference createLocationReferenceForMethod(Method method) {
    LocationReference locationReference = null;
    
    if (method instanceof OLRLocationReference) {
      LOGGER.info("Message has Open LR location reference");
      OLRLocationReference olrLocationReference = (OLRLocationReference) method;
      locationReference = locRefFactory.createLocationReference();
      locationReference.setLocationReferenceType((Byte) (byte) LocationReferenceType.OPEN_LR.getValue());
      locationReference.setData(olrLocationReference.getLocationData());
    } else {
      LOGGER.info("Message has No Supported location reference");
    }
    
    return locationReference;
  }
  
  public void convertTecEventToManagedTrafficIncident(TrafficIncident managedTrafficIncident, Event event) {
    handleEffectCode(event, managedTrafficIncident);
    handleStartTime(event, managedTrafficIncident);
    handleStopTime(event, managedTrafficIncident);
    handleTendency(event, managedTrafficIncident);
    handleLengthAffected(event, managedTrafficIncident);
    handleAverageSpeedAbsolute(event, managedTrafficIncident);
    handleDelay(event, managedTrafficIncident);
    handleSegmentSpeedLimit(event, managedTrafficIncident);
    handleExpectedSpeedAbsolute(event, managedTrafficIncident);
    for (org.genivi.trafficinfo.tpeg.tec.event.Cause cause: event.getCause()) {
      handleCause(cause, managedTrafficIncident);
    }
    for (org.genivi.trafficinfo.tpeg.tec.event.Advice advice: event.getAdvice()) {
      handleAdvice(advice, managedTrafficIncident);
    }
    for (org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction tecVehicleRestriction: event.getVehicleRestriction()) {
      handleVehicleRestriction(tecVehicleRestriction, managedTrafficIncident);
    }
  }

  private static void fillEffectCodeMap() {
    effectCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.EffectCode.TRAFFIC_FLOW_UNKNOWN, EffectCode.TRAFFIC_FLOW_UNKNOWN);
    effectCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.EffectCode.FREE_TRAFFIC_FLOW, EffectCode.FREE_TRAFFIC_FLOW);
    effectCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.EffectCode.HEAVY_TRAFFIC, EffectCode.HEAVY_TRAFFIC);
    effectCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.EffectCode.SLOW_TRAFFIC, EffectCode.SLOW_TRAFFIC);
    effectCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.EffectCode.QUEUING_TRAFFIC, EffectCode.QUEUING_TRAFFIC);
    effectCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.EffectCode.STATIONARY_TRAFFIC, EffectCode.STATIONARY_TRAFFIC);
    effectCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.EffectCode.NO_TRAFFIC_FLOW, EffectCode.NO_TRAFFIC_FLOW);
  }

  private static void fillTendencyMap() {
    tendencyMap.put(org.genivi.trafficinfo.tpeg.tec.event.Tendency.SLIGHTLY_INCREASING, Tendency.SLIGHTLY_INCREASING);
    tendencyMap.put(org.genivi.trafficinfo.tpeg.tec.event.Tendency.INCREASING, Tendency.INCREASING);
    tendencyMap.put(org.genivi.trafficinfo.tpeg.tec.event.Tendency.STRONGLY_INCREASING, Tendency.STRONGLY_INCREASING);
    tendencyMap.put(org.genivi.trafficinfo.tpeg.tec.event.Tendency.SLIGHTLY_DECREASING, Tendency.SLIGHTLY_DECREASING);
    tendencyMap.put(org.genivi.trafficinfo.tpeg.tec.event.Tendency.DECREASING, Tendency.DECREASING);
    tendencyMap.put(org.genivi.trafficinfo.tpeg.tec.event.Tendency.STRONGLY_DECREASING, Tendency.STRONGLY_DECREASING);
    tendencyMap.put(org.genivi.trafficinfo.tpeg.tec.event.Tendency.CONSTANT, Tendency.CONSTANT);
  }

  private static void fillCauseCodeMap() {
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.TRAFFIC_CONGESTION, CauseCode.TRAFFIC_CONGESTION);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.ACCIDENT, CauseCode.ACCIDENT);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.ROADWORKS, CauseCode.ROADWORKS);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.NARROW_LANES, CauseCode.NARROW_LANES);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.IMPASSIBILITY, CauseCode.IMPASSIBILITY);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.SLIPPERY_ROAD, CauseCode.SLIPPERY_ROAD);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.AQUAPLANING, CauseCode.AQUAPLANING);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.FIRE, CauseCode.FIRE);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.HAZARDOUS_DRIVING_CONDITIONS, CauseCode.HAZARDOUS_DRIVING_CONDITIONS);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.OBJECTS_ON_THE_ROAD, CauseCode.OBJECTS_ON_THE_ROAD);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.ANIMALS_ON_ROADWAY, CauseCode.ANIMALS_ON_ROADWAY);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.PEOPLE_ON_ROADWAY, CauseCode.PEOPLE_ON_ROADWAY);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.BROKEN_DOWN_VEHICLES, CauseCode.BROKEN_DOWN_VEHICLES);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.VEHICLE_ON_WRONG_CARRIAGEWAY, CauseCode.VEHICLE_ON_WRONG_CARRIAGEWAY);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.RESCUE_AND_RECOVERY_WORK_IN_PROGRESS, CauseCode.RESCUE_AND_RECOVERY_WORK_IN_PROGRESS);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.REGULATORY_MEASURE, CauseCode.REGULATORY_MEASURE);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.EXTREME_WEATHER_CONDITIONS, CauseCode.EXTREME_WEATHER_CONDITIONS);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.VISIBILITY_REDUCED, CauseCode.VISIBILITY_REDUCED);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.PRECIPITATION, CauseCode.PRECIPITATION);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.RECKLESS_PERSONS, CauseCode.RECKLESS_PERSONS);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED, CauseCode.OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.TRAFFIC_REGULATIONS_CHANGED, CauseCode.TRAFFIC_REGULATIONS_CHANGED);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.MAJOR_EVENT, CauseCode.MAJOR_EVENT);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.SERVICE_NOT_OPERATING, CauseCode.SERVICE_NOT_OPERATING);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.SERVICE_NOT_USEABLE, CauseCode.SERVICE_NOT_USEABLE);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.SLOW_MOVING_VEHICLES, CauseCode.SLOW_MOVING_VEHICLES);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.DANGEROUS_END_OF_QUEUE, CauseCode.DANGEROUS_END_OF_QUEUE);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.RISK_OF_FIRE, CauseCode.RISK_OF_FIRE);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.TIME_DELAY, CauseCode.TIME_DELAY);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.POLICE_CHECKPOINT, CauseCode.POLICE_CHECKPOINT);
    causeCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.CauseCode.MALFUNCTIONING_ROADSIDE_EQUIPMENT, CauseCode.MALFUNCTIONING_ROADSIDE_EQUIPMENT);
  }

  private static void fillWarningLevelMap() {
    warningLevelMap.put(org.genivi.trafficinfo.tpeg.tec.event.WarningLevel.INFORMATIVE, WarningLevel.INFORMATIVE);
    warningLevelMap.put(org.genivi.trafficinfo.tpeg.tec.event.WarningLevel.DANGER_LEVEL_1, WarningLevel.DANGER_LEVEL_1);
    warningLevelMap.put(org.genivi.trafficinfo.tpeg.tec.event.WarningLevel.DANGER_LEVEL_2, WarningLevel.DANGER_LEVEL_2);
    warningLevelMap.put(org.genivi.trafficinfo.tpeg.tec.event.WarningLevel.DANGER_LEVEL_3, WarningLevel.DANGER_LEVEL_3);
  }

  private static void fillTrafficCongestionMap() {
    trafficCongestionMap.put(org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion.INCREASED_VOLUME_OF_TRAFFIC, TrafficCongestion.INCREASED_VOLUME_OF_TRAFFIC);
  }

  private static void fillAccidentMap() {
    accidentMap.put(org.genivi.trafficinfo.tpeg.tec.event.Accident.MULTI_VEHICLE_ACCIDENT, Accident.MULTI_VEHICLE_ACCIDENT);
    accidentMap.put(org.genivi.trafficinfo.tpeg.tec.event.Accident.HEAVY_ACCIDENT, Accident.HEAVY_ACCIDENT);
    accidentMap.put(org.genivi.trafficinfo.tpeg.tec.event.Accident.ACCIDENT_INVOLVING_LORRY, Accident.ACCIDENT_INVOLVING_LORRY);
    accidentMap.put(org.genivi.trafficinfo.tpeg.tec.event.Accident.ACCIDENT_INVOLVING_BUS, Accident.ACCIDENT_INVOLVING_BUS);
    accidentMap.put(org.genivi.trafficinfo.tpeg.tec.event.Accident.ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS, Accident.ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS);
    accidentMap.put(org.genivi.trafficinfo.tpeg.tec.event.Accident.ACCIDENT_ON_OPPOSITE_LANE, Accident.ACCIDENT_ON_OPPOSITE_LANE);
    accidentMap.put(org.genivi.trafficinfo.tpeg.tec.event.Accident.UNSECURED_ACCIDENT, Accident.UNSECURED_ACCIDENT);
  }

  private static void fillRoadWorksMap() {
    roadWorksMap.put(org.genivi.trafficinfo.tpeg.tec.event.RoadWorks.MAJOR_ROADWORKS, RoadWorks.MAJOR_ROADWORKS);
    roadWorksMap.put(org.genivi.trafficinfo.tpeg.tec.event.RoadWorks.ROAD_MARKING_WORK, RoadWorks.ROAD_MARKING_WORK);
    roadWorksMap.put(org.genivi.trafficinfo.tpeg.tec.event.RoadWorks.SLOW_MOVING_ROAD_MAINTENANCE, RoadWorks.SLOW_MOVING_ROAD_MAINTENANCE);
  }

  private static void fillNarrowLanesMap() {
    narrowLanesMap.put(org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes.CONTRAFLOW, NarrowLanes.CONTRAFLOW);
    narrowLanesMap.put(org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes.HARD_SHOULDER_CLOSED, NarrowLanes.HARD_SHOULDER_CLOSED);
    narrowLanesMap.put(org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes.SLIP_LANE_CLOSED, NarrowLanes.HARD_SHOULDER_CLOSED);
    narrowLanesMap.put(org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes.CRAWLER_LANE_CLOSED, NarrowLanes.HARD_SHOULDER_CLOSED);
  }

  private static void fillImpassibilityMap() {
    impassibilityMap.put(org.genivi.trafficinfo.tpeg.tec.event.Impassibility.FLOODING, Impassibility.FLOODING);
    impassibilityMap.put(org.genivi.trafficinfo.tpeg.tec.event.Impassibility.DANGER_OF_AVALANCHES, Impassibility.DANGER_OF_AVALANCHES);
    impassibilityMap.put(org.genivi.trafficinfo.tpeg.tec.event.Impassibility.BLASTING_OF_AVALANCHES, Impassibility.BLASTING_OF_AVALANCHES);
    impassibilityMap.put(org.genivi.trafficinfo.tpeg.tec.event.Impassibility.LANDSLIPS, Impassibility.LANDSLIPS);
    impassibilityMap.put(org.genivi.trafficinfo.tpeg.tec.event.Impassibility.CHEMICAL_SPILLAGE, Impassibility.CHEMICAL_SPILLAGE);
    impassibilityMap.put(org.genivi.trafficinfo.tpeg.tec.event.Impassibility.WINTER_CLOSURE, Impassibility.WINTER_CLOSURE);
  }

  private static void fillSlipperyRoadMap() {
    slipperyRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad.HEAVY_FROST_ON_ROAD, SlipperyRoad.HEAVY_FROST_ON_ROAD);
    slipperyRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad.FUEL_ON_ROAD, SlipperyRoad.FUEL_ON_ROAD);
    slipperyRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad.MUD_ON_ROAD, SlipperyRoad.MUD_ON_ROAD);
    slipperyRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad.SNOW_ON_ROAD, SlipperyRoad.SNOW_ON_ROAD);
    slipperyRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad.ICE_ON_ROAD, SlipperyRoad.ICE_ON_ROAD);
    slipperyRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad.BLACK_ICE_ON_ROAD, SlipperyRoad.BLACK_ICE_ON_ROAD);
    slipperyRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad.OIL_ON_ROAD, SlipperyRoad.OIL_ON_ROAD);
    slipperyRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad.LOOSE_CHIPPINGS, SlipperyRoad.LOOSE_CHIPPINGS);
    slipperyRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad.INSTANT_BLACK_ICE, SlipperyRoad.INSTANT_BLACK_ICE);
    slipperyRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad.ROADS_SALTED, SlipperyRoad.ROADS_SALTED);
  }

  private static void fillFireMap() {
    fireMap.put(org.genivi.trafficinfo.tpeg.tec.event.Fire.FOREST_FIRE, Fire.FOREST_FIRE);
    fireMap.put(org.genivi.trafficinfo.tpeg.tec.event.Fire.MAJOR_FIRE, Fire.MAJOR_FIRE);
  }

  private static void fillHazardousDrivingConditionsMap() {
    hazardousDrivingConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions.ROCKFALLS, HazardousDrivingConditions.ROCKFALLS);
    hazardousDrivingConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions.EARTHQUAKE_DAMAGE, HazardousDrivingConditions.EARTHQUAKE_DAMAGE);
    hazardousDrivingConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions.SEWER_COLLAPSE, HazardousDrivingConditions.EARTHQUAKE_DAMAGE);
    hazardousDrivingConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions.SUBSIDENCE, HazardousDrivingConditions.SUBSIDENCE);
    hazardousDrivingConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions.SNOW_DRIFTS, HazardousDrivingConditions.SNOW_DRIFTS);
    hazardousDrivingConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions.STORM_DAMAGE, HazardousDrivingConditions.STORM_DAMAGE);
    hazardousDrivingConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions.BURST_PIPE, HazardousDrivingConditions.BURST_PIPE);
    hazardousDrivingConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions.VOLCANO_ERUPTION, HazardousDrivingConditions.VOLCANO_ERUPTION);
    hazardousDrivingConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions.FALLING_ICE, HazardousDrivingConditions.FALLING_ICE);
  }

  private static void fillObjectsOnTheRoadMap() {
    objectsOnTheRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad.SHED_LOAD, ObjectsOnTheRoad.SHED_LOAD);
    objectsOnTheRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad.PARTS_OF_VEHICLES, ObjectsOnTheRoad.PARTS_OF_VEHICLES);
    objectsOnTheRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad.PARTS_OF_TYRES, ObjectsOnTheRoad.PARTS_OF_TYRES);
    objectsOnTheRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad.BIG_OBJECTS, ObjectsOnTheRoad.BIG_OBJECTS);
    objectsOnTheRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad.FALLEN_TREES, ObjectsOnTheRoad.FALLEN_TREES);
    objectsOnTheRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad.HUB_CAPS, ObjectsOnTheRoad.HUB_CAPS);
    objectsOnTheRoadMap.put(org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad.WAITING_VEHICLES, ObjectsOnTheRoad.WAITING_VEHICLES);
  }

  private static void fillAnimalsOnRoadwayMap() {
    animalsOnRoadwayMap.put(org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway.WILD_ANIMALS, AnimalsOnRoadway.WILD_ANIMALS);
    animalsOnRoadwayMap.put(org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway.HERD_OF_ANIMALS, AnimalsOnRoadway.HERD_OF_ANIMALS);
    animalsOnRoadwayMap.put(org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway.SMALL_ANIMALS, AnimalsOnRoadway.SMALL_ANIMALS);
    animalsOnRoadwayMap.put(org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway.LARGE_ANIMALS, AnimalsOnRoadway.LARGE_ANIMALS);
  }

  private static void fillPeopleOnRoadwayMap() {
    peopleOnRoadwayMap.put(org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway.CHILDREN_ON_ROADWAY, PeopleOnRoadway.CHILDREN_ON_ROADWAY);
    peopleOnRoadwayMap.put(org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway.CYCLISTS_ON_ROADWAY, PeopleOnRoadway.CYCLISTS_ON_ROADWAY);
    peopleOnRoadwayMap.put(org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway.MOTOR_CYCLIST_ON_ROADWAY, PeopleOnRoadway.MOTOR_CYCLIST_ON_ROADWAY);
  }

  private static void fillBrokenDownVehiclesMap() {
    brokenDownVehiclesMap.put(org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles.BROKEN_DOWN_UNLIT_VEHICLE, BrokenDownVehicles.BROKEN_DOWN_UNLIT_VEHICLE);
    brokenDownVehiclesMap.put(org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles.BROKEN_DOWN_VEHICLE_BURNING, BrokenDownVehicles.BROKEN_DOWN_VEHICLE_BURNING);
  }

  private static void fillRescueAndRecoveryWorkInProgressMap() {
    rescueAndRecoveryWorkInProgressMap.put(org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress.EMERGENCY_VEHICLES, RescueAndRecoveryWorkInProgress.EMERGENCY_VEHICLES);
    rescueAndRecoveryWorkInProgressMap.put(org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress.RESCUE_HELICOPTER_LANDING, RescueAndRecoveryWorkInProgress.RESCUE_HELICOPTER_LANDING);
    rescueAndRecoveryWorkInProgressMap.put(org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress.POLICE_ACTIVITY_ONGOING, RescueAndRecoveryWorkInProgress.POLICE_ACTIVITY_ONGOING);
    rescueAndRecoveryWorkInProgressMap.put(org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress.MEDICAL_EMERGENCY_ONGOING, RescueAndRecoveryWorkInProgress.MEDICAL_EMERGENCY_ONGOING);
    rescueAndRecoveryWorkInProgressMap.put(org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress.CHILD_ABDUCTION_IN_PROGRESS, RescueAndRecoveryWorkInProgress.CHILD_ABDUCTION_IN_PROGRESS);
  }

  private static void fillRegulatoryMeasureMap() {
    regulatoryMeasureMap.put(org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure.SECURITY_ALERT, RegulatoryMeasure.SECURITY_ALERT);
    regulatoryMeasureMap.put(org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure.CONTAGIOUS_DISEASE, RegulatoryMeasure.CONTAGIOUS_DISEASE);
    regulatoryMeasureMap.put(org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure.ENVIRONMENTAL, RegulatoryMeasure.ENVIRONMENTAL);
    regulatoryMeasureMap.put(org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure.SMOG_ALERT, RegulatoryMeasure.SMOG_ALERT);
    regulatoryMeasureMap.put(org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure.BATCH_SERVICE_IN_PROGRESS, RegulatoryMeasure.BATCH_SERVICE_IN_PROGRESS);
    regulatoryMeasureMap.put(org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure.ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES, RegulatoryMeasure.ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES);
  }

  private static void fillExtremeWeatherConditionsMap() {
    extremeWeatherConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions.STRONG_WINDS, ExtremeWeatherConditions.STRONG_WINDS);
    extremeWeatherConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions.DAMAGING_HAIL, ExtremeWeatherConditions.DAMAGING_HAIL);
    extremeWeatherConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions.HURRICANE, ExtremeWeatherConditions.HURRICANE);
    extremeWeatherConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions.THUNDERSTORM, ExtremeWeatherConditions.THUNDERSTORM);
    extremeWeatherConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions.TORNADO, ExtremeWeatherConditions.TORNADO);
    extremeWeatherConditionsMap.put(org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions.BLIZARD, ExtremeWeatherConditions.BLIZARD);
  }

  private static void fillVisibilityReducedMap() {
    visibilityReducedMap.put(org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_FOG, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_FOG);
    visibilityReducedMap.put(org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_SMOKE, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_SMOKE);
    visibilityReducedMap.put(org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_HEAVY_SNOWFALL, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_HEAVY_SNOWFALL);
    visibilityReducedMap.put(org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_HEAVY_RAIN, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_HEAVY_RAIN);
    visibilityReducedMap.put(org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_HEAVY_HAIL, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_HEAVY_HAIL);
    visibilityReducedMap.put(org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_LOW_SUN_GLARE, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_LOW_SUN_GLARE);
    visibilityReducedMap.put(org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_SANDSTORMS, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_SANDSTORMS);
    visibilityReducedMap.put(org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_SWARMS_OF_INSECTS, VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_SWARMS_OF_INSECTS);
  }

  private static void fillPrecipitationMap() {
    precipitationMap.put(org.genivi.trafficinfo.tpeg.tec.event.Precipitation.HEAVY_RAIN, Precipitation.HEAVY_RAIN);
    precipitationMap.put(org.genivi.trafficinfo.tpeg.tec.event.Precipitation.HEAVY_SNOWFALL, Precipitation.HEAVY_SNOWFALL);
    precipitationMap.put(org.genivi.trafficinfo.tpeg.tec.event.Precipitation.SOFT_HAIL, Precipitation.SOFT_HAIL);
  }

  private static void fillRecklessPersonsMap() {
    recklessPersonsMap.put(org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons.GUNFIRE_ON_ROAD, RecklessPersons.GUNFIRE_ON_ROAD);
    recklessPersonsMap.put(org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons.RECKLESS_DRIVER, RecklessPersons.RECKLESS_DRIVER);
    recklessPersonsMap.put(org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons.STONE_THROWING_PERSONS, RecklessPersons.STONE_THROWING_PERSONS);
  }

  private static void fillMajorEventMap() {
    majorEventMap.put(org.genivi.trafficinfo.tpeg.tec.event.MajorEvent.CONCERT, MajorEvent.CONCERT);
    majorEventMap.put(org.genivi.trafficinfo.tpeg.tec.event.MajorEvent.DEMONSTRATION, MajorEvent.DEMONSTRATION);
    majorEventMap.put(org.genivi.trafficinfo.tpeg.tec.event.MajorEvent.DEMONSTRATION_WITH_VEHICLES, MajorEvent.DEMONSTRATION_WITH_VEHICLES);
    majorEventMap.put(org.genivi.trafficinfo.tpeg.tec.event.MajorEvent.EMERGENCY_TRAINING, MajorEvent.EMERGENCY_TRAINING);
    majorEventMap.put(org.genivi.trafficinfo.tpeg.tec.event.MajorEvent.FAIR, MajorEvent.FAIR);
    majorEventMap.put(org.genivi.trafficinfo.tpeg.tec.event.MajorEvent.FESTIVITY, MajorEvent.FESTIVITY);
    majorEventMap.put(org.genivi.trafficinfo.tpeg.tec.event.MajorEvent.MILITARY_TRAINING, MajorEvent.MILITARY_TRAINING);
    majorEventMap.put(org.genivi.trafficinfo.tpeg.tec.event.MajorEvent.PROCESSION, MajorEvent.PROCESSION);
    majorEventMap.put(org.genivi.trafficinfo.tpeg.tec.event.MajorEvent.SPORTS_EVENT, MajorEvent.SPORTS_EVENT);
  }

  private static void fillServiceNotOperatingMap() {
    serviceNotOperatingMap.put(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating.FERRY_SERVICE_NOT_OPERATING, ServiceNotOperating.FERRY_SERVICE_NOT_OPERATING);
    serviceNotOperatingMap.put(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating.PLANE_SERVICE_NOT_OPERATING, ServiceNotOperating.PLANE_SERVICE_NOT_OPERATING);
    serviceNotOperatingMap.put(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating.TRAIN_SERVICE_NOT_OPERATING, ServiceNotOperating.TRAIN_SERVICE_NOT_OPERATING);
    serviceNotOperatingMap.put(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating.BUS_SERVICE_NOT_OPERATING, ServiceNotOperating.BUS_SERVICE_NOT_OPERATING);
  }

  private static void fillServiceNotUsableMap() {
    serviceNotUsableMap.put(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable.FUEL_STATION_CLOSED, ServiceNotUsable.FUEL_STATION_CLOSED);
    serviceNotUsableMap.put(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable.SERVICE_AREA_CLOSED, ServiceNotUsable.SERVICE_AREA_CLOSED);
    serviceNotUsableMap.put(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable.SERVICE_AREA_BUSY, ServiceNotUsable.SERVICE_AREA_BUSY);
    serviceNotUsableMap.put(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable.PARKING_FULL, ServiceNotUsable.PARKING_FULL);
    serviceNotUsableMap.put(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable.CAR_PARK_CLOSED, ServiceNotUsable.CAR_PARK_CLOSED);
  }

  private static void fillSlowMovingVehiclesMap() {
    slowMovingVehiclesMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles.SLOW_MOVING_MAINTENANCE_VEHICLE, SlowMovingVehicles.SLOW_MOVING_MAINTENANCE_VEHICLE);
    slowMovingVehiclesMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles.VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT, SlowMovingVehicles.VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT);
    slowMovingVehiclesMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles.ABNORMAL_LOAD, SlowMovingVehicles.ABNORMAL_LOAD);
    slowMovingVehiclesMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles.ABNORMAL_WIDE_LOAD, SlowMovingVehicles.ABNORMAL_WIDE_LOAD);
    slowMovingVehiclesMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles.CONVOY, SlowMovingVehicles.CONVOY);
    slowMovingVehiclesMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles.SNOWPLOUGH, SlowMovingVehicles.SNOWPLOUGH);
    slowMovingVehiclesMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles.DEICING, SlowMovingVehicles.DEICING);
    slowMovingVehiclesMap.put(org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles.SALTING_VEHICLES, SlowMovingVehicles.SALTING_VEHICLES);
  }

  private static void fillDangerousEndOfQueueMap() {
    dangerousEndOfQueueMap.put(org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue.SUDDEN_END_OF_QUEUE, DangerousEndOfQueue.SUDDEN_END_OF_QUEUE);
    dangerousEndOfQueueMap.put(org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue.QUEUE_OVER_HILL, DangerousEndOfQueue.QUEUE_OVER_HILL);
    dangerousEndOfQueueMap.put(org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue.QUEUE_AROUND_BEND, DangerousEndOfQueue.QUEUE_AROUND_BEND);
    dangerousEndOfQueueMap.put(org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue.QUEUE_IN_TUNNEL, DangerousEndOfQueue.QUEUE_IN_TUNNEL);
  }

  private static void fillRiskOfFireMap() {
    riskOfFireMap.put(org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire.LEAKAGE_OF_FUEL, RiskOfFire.LEAKAGE_OF_FUEL);
    riskOfFireMap.put(org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire.LEAKAGE_OF_GAS, RiskOfFire.LEAKAGE_OF_GAS);
  }

  private static void fillTimeDelayMap() {
    timeDelayMap.put(org.genivi.trafficinfo.tpeg.tec.event.TimeDelay.TIME_DELAY_AT_FRONTIER, TimeDelay.TIME_DELAY_AT_FRONTIER);
    timeDelayMap.put(org.genivi.trafficinfo.tpeg.tec.event.TimeDelay.TIME_DELAY_AT_FERRY_PORT, TimeDelay.TIME_DELAY_AT_FERRY_PORT);
    timeDelayMap.put(org.genivi.trafficinfo.tpeg.tec.event.TimeDelay.TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL, TimeDelay.TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL);
  }

  private static void fillPoliceCheckpointMap() {
    policeCheckpointMap.put(org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint.PERMANENT_POLICE_CHECKPOINT, PoliceCheckpoint.PERMANENT_POLICE_CHECKPOINT);
    policeCheckpointMap.put(org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint.TEMPORARY_POLICE_CHECKPOINT, PoliceCheckpoint.TEMPORARY_POLICE_CHECKPOINT);
  }

  private static void fillMalfunctioningRoadsideEquipmentMap() {
    malfunctioningRoadsideEquipmentMap.put(org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment.AUTOMATIC_PAYMENT_LANES_NOT_WORKING, MalfunctioningRoadsideEquipment.AUTOMATIC_PAYMENT_LANES_NOT_WORKING);
    malfunctioningRoadsideEquipmentMap.put(org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment.EMERGENCY_TELEPHONES_NOT_WORKING, MalfunctioningRoadsideEquipment.EMERGENCY_TELEPHONES_NOT_WORKING);
    malfunctioningRoadsideEquipmentMap.put(org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment.ROAD_RAIL_CROSSING_FAILURE, MalfunctioningRoadsideEquipment.ROAD_RAIL_CROSSING_FAILURE);
    malfunctioningRoadsideEquipmentMap.put(org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment.TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY, MalfunctioningRoadsideEquipment.TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY);
    malfunctioningRoadsideEquipmentMap.put(org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment.TUNNEL_VENTILATION_NOT_WORKING, MalfunctioningRoadsideEquipment.TUNNEL_VENTILATION_NOT_WORKING);
  }
  
  private static void fillLaneRestrictionTypeMap() {
    laneRestrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType.LANES_CLOSED, LaneRestrictionType.LANES_CLOSED);
    laneRestrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType.LANES_OPEN, LaneRestrictionType.LANES_OPEN);
    laneRestrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType.RIGHT_LANES_CLOSED, LaneRestrictionType.RIGHT_LANES_CLOSED);
    laneRestrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType.LEFT_LANES_CLOSED, LaneRestrictionType.LEFT_LANES_CLOSED);
  }

  private static void fillVehicleTypeMap() {
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.CAR, VehicleType.CAR);
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.LORRY, VehicleType.LORRY);
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.BUS, VehicleType.BUS);
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.TAXI, VehicleType.TAXI);
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.TRAIN, VehicleType.TRAIN);
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.MOTOR_CYCLE, VehicleType.MOTOR_CYCLE);
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.VEHICLE_WITH_TRAILER, VehicleType.VEHICLE_WITH_TRAILER);
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.MOTOR_VEHICLES, VehicleType.MOTOR_VEHICLES);
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.TRANSPORT_OF_DANGEROUS_GOODS, VehicleType.TRANSPORT_OF_DANGEROUS_GOODS);
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.TRANSPORT_OF_ABNORMAL_LOAD, VehicleType.TRANSPORT_OF_ABNORMAL_LOAD);
    vehicleTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.VehicleType.HEAVY_VEHICLE, VehicleType.HEAVY_VEHICLE);
  }

  private static void fillRestrictionTypeMap() {
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WIDTH_LESS_THAN, RestrictionType.WIDTH_LESS_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WIDTH_GREATER_THAN, RestrictionType.WIDTH_GREATER_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.HEIGTH_LESS_THAN, RestrictionType.HEIGTH_LESS_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.HEIGTH_GREATER_THAN, RestrictionType.HEIGTH_GREATER_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WEIGHT_LESS_THAN, RestrictionType.WEIGHT_LESS_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WEIGHT_GREATER_THAN, RestrictionType.WEIGHT_GREATER_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WITHOUT_WINTER_TYRE, RestrictionType.WITHOUT_WINTER_TYRE);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WITHOUT_SNOW_CHAIN, RestrictionType.WITHOUT_SNOW_CHAIN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WITH_TRAILER, RestrictionType.WITH_TRAILER);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WITH_CARAVAN, RestrictionType.WITH_CARAVAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.PERSONS_IN_VEHICLE_LESS_THAN, RestrictionType.PERSONS_IN_VEHICLE_LESS_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.PERSONS_IN_VEHICLE_MORE_THAN, RestrictionType.PERSONS_IN_VEHICLE_MORE_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.EVEN_NUMBER_PLATE, RestrictionType.EVEN_NUMBER_PLATE);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.ODD_NUMBER_PLATE, RestrictionType.ODD_NUMBER_PLATE);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.LENGTH_LESS_THAN, RestrictionType.LENGTH_LESS_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.LENGTH_GREATER_THAN, RestrictionType.LENGTH_GREATER_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.AXLE_LOAD_LESS_THAN, RestrictionType.AXLE_LOAD_LESS_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.AXLE_LOAD_GREATER_THAN, RestrictionType.AXLE_LOAD_GREATER_THAN);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3, RestrictionType.VEHICLE_FULFILLS_EMISSION_STANDARD_EURO3);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4, RestrictionType.VEHICLE_FULFILLS_EMISSION_STANDARD_EURO3D4);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4, RestrictionType.VEHICLE_FULFILLS_EMISSION_STANDARD_EURO4);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5, RestrictionType.VEHICLE_FULFILLS_EMISSION_STANDARD_EURO5);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WITH_PETROL_ENGINE, RestrictionType.WITH_PETROL_ENGINE);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WITH_DIESEL_ENGINE, RestrictionType.WITH_DIESEL_ENGINE);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WITH_LPG_ENGINE, RestrictionType.WITH_LPG_ENGINE);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.THROUGH_TRAFFIC, RestrictionType.THROUGH_TRAFFIC);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.RESIDENTS_TRAFFIC, RestrictionType.RESIDENTS_TRAFFIC);
    restrictionTypeMap.put(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.WITH_DESTINATION_IN_GIVEN_AREA, RestrictionType.WITH_DESTINATION_IN_GIVEN_AREA);
  }

  private static void fillAdviceCodeMap() {
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.AVOID_THE_AREA, AdviceCode.AVOID_THE_AREA);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.DO_NOT_DIVERT, AdviceCode.DO_NOT_DIVERT);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.DO_NOT_LEAVE_YOUR_VEHICLE, AdviceCode.DO_NOT_LEAVE_YOUR_VEHICLE);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.DRIVE_CAREFULLY, AdviceCode.DRIVE_CAREFULLY);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE, AdviceCode.DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.DRIVING_NOT_ALLOWED, AdviceCode.DRIVING_NOT_ALLOWED);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.FOLLOW_DIVERSION, AdviceCode.FOLLOW_DIVERSION);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.FOLLOW_POLICE_INSTRUCTIONS, AdviceCode.FOLLOW_POLICE_INSTRUCTIONS);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.GIVING_PATH_VEHICLES_COMING_FROM_BEHIND, AdviceCode.GIVING_PATH_VEHICLES_COMING_FROM_BEHIND);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.NO_DIVERSION_TO_RECOMMEND, AdviceCode.NO_DIVERSION_TO_RECOMMEND);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.OVERTAKING_NOT_ALLOWED, AdviceCode.OVERTAKING_NOT_ALLOWED);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.SWITCH_ON_RADIO, AdviceCode.SWITCH_ON_RADIO);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.USE_HARD_SHOULDER_AS_LANE, AdviceCode.USE_HARD_SHOULDER_AS_LANE);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.USE_TOLL_LANES, AdviceCode.USE_TOLL_LANES);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.WAIT_FOR_CONVOI, AdviceCode.WAIT_FOR_CONVOI);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.WAIT_FOR_IMPROVED_WEATHER, AdviceCode.WAIT_FOR_IMPROVED_WEATHER);
    adviceCodeMap.put(org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.WAIT_FOR_POLICE_PATROL, AdviceCode.WAIT_FOR_POLICE_PATROL);
  }
  
  private static void fillOvertakingNotAllowedMap() {
    overtakingNotAllowedMap.put(org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed.DO_NOT_USE_OVERTAKING_LANES, OvertakingNotAllowed.DO_NOT_USE_OVERTAKING_LANES);
    overtakingNotAllowedMap.put(org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed.OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE, OvertakingNotAllowed.OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE);
    overtakingNotAllowedMap.put(org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed.OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE, OvertakingNotAllowed.OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE);
    overtakingNotAllowedMap.put(org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed.OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE, OvertakingNotAllowed.OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE);
  }
  
  private static void fillDrivingNotAllowedMap() {
    drivingNotAllowedMap.put(org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed.DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE, DrivingNotAllowed.DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE);
  }
  
  private static void fillGivingPathVehiclesFromBehindMap() {
    givingPathVehiclesFromBehindMap.put(org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind.GIVING_PATH_FOR_RESCUE_VEHICLE, GivingPathVehiclesFromBehind.GIVING_PATH_FOR_RESCUE_VEHICLE);
    givingPathVehiclesFromBehindMap.put(org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind.GIVING_PATH_FOR_SERVICE_VEHICLES, GivingPathVehiclesFromBehind.GIVING_PATH_FOR_SERVICE_VEHICLES);
  }
  
  private static void fillFollowDiversionMap() {
    followDiversionMap.put(org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion.FOLLOW_DIVERSION_SIGNS, FollowDiversion.FOLLOW_DIVERSION_SIGNS);
  }
  
  private static void fillDriveCarefullyMap() {
    driveCarefullyMap.put(org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully.DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD, DriveCarefully.DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD);
    driveCarefullyMap.put(org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully.DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD, DriveCarefully.DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD);
    driveCarefullyMap.put(org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully.DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE, DriveCarefully.DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE);
  }
  
  private static void fillDoNotLeaveYourVehicleMap() {
    doNotLeaveYourVehicleMap.put(org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle.DO_NOT_LEAVE_YOUR_VEHICLE, DoNotLeaveYourVehicle.DO_NOT_LEAVE_YOUR_VEHICLE);
    doNotLeaveYourVehicleMap.put(org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle.DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS, DoNotLeaveYourVehicle.DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS);
  }
  
  private static void fillUseTollLanesMap() {
    useTollLanesMap.put(org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes.USE_AUTOMATIC_PAYMENT_TOLL_LANES, UseTollLanes.USE_AUTOMATIC_PAYMENT_TOLL_LANES);
    useTollLanesMap.put(org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes.USE_MANUAL_PAYMENT_TOLL_LANES, UseTollLanes.USE_MANUAL_PAYMENT_TOLL_LANES);
  }
  
  private static void fillLanguageMap() {
    // TODO PRIO9: FULL_IMPL Add all languages to be supported within GENIVI.
    languageMap.put(LanguageCode.DUTCH.getCode(), "nld");
    languageMap.put(LanguageCode.ENGLISH.getCode(), "eng");
    languageMap.put(LanguageCode.FRENCH.getCode(), "fra");
    languageMap.put(LanguageCode.GERMAN.getCode(), "deu");
  }
  
  private static void fillLanguageCountryMap() {
    // TODO PRIO9: FULL_IMPL For all languages to be supported within GENIVI, add country code if applicable.
    languageCountryMap.put(LanguageCode.DUTCH.getCode(), "nld");
    languageCountryMap.put(LanguageCode.ENGLISH.getCode(), "gbr");
    languageCountryMap.put(LanguageCode.FRENCH.getCode(), "fra");
    languageCountryMap.put(LanguageCode.GERMAN.getCode(), "deu");
  }

  private static void handleEffectCode(Event event, TrafficIncident trafficIncident) {
    // effectCode is mandatory, and all codes are mapped, so no check needed.
    org.genivi.trafficinfo.tpeg.tec.event.EffectCode tecEffectCode = event.getEffectCode();
    EffectCode tiEffectCode = effectCodeMap.get(tecEffectCode);
    trafficIncident.setEffectCode(tiEffectCode);
  }

  private static void handleStartTime(Event event, TrafficIncident trafficIncident) {
    // currently start time is a Java Date in both models, so no conversion needed.
    if (event.getStartTime() != null) {
      trafficIncident.setStartTime(event.getStartTime());
    }
  }

  private static void handleStopTime(Event event, TrafficIncident trafficIncident) {
    // currently stop time is a Java Date in both models, so no conversion needed.
    if (event.getStopTime() != null) {
      trafficIncident.setStopTime(event.getStopTime());
    }
  }

  private static void handleTendency(Event event, TrafficIncident trafficIncident) {
    if (event.isSetTendency()) {
      org.genivi.trafficinfo.tpeg.tec.event.Tendency tecTendency = event.getTendency();
      Tendency tiTendency = tendencyMap.get(tecTendency);
      trafficIncident.setTendency(tiTendency);
    }
  }

  private static void handleLengthAffected(Event event, TrafficIncident trafficIncident) {
    if (event.getLengthAffected() != null) {
      trafficIncident.setLengthAffected(event.getLengthAffected());
    }
  }

  private static void handleAverageSpeedAbsolute(Event event, TrafficIncident trafficIncident) {
    if (event.getAverageSpeedAbsolute() != null) {
      trafficIncident.setAverageSpeedAbsolute(event.getAverageSpeedAbsolute());
    }
  }

  private static void handleDelay(Event event, TrafficIncident trafficIncident) {
    if (event.getDelay() != null) {
      trafficIncident.setDelay(event.getDelay());
    }
  }

  private static void handleSegmentSpeedLimit(Event event, TrafficIncident trafficIncident) {
    if (event.getSegmentSpeedLimit() != null) {
      trafficIncident.setSegmentSpeedLimit(event.getSegmentSpeedLimit());
    }
  }

  private static void handleExpectedSpeedAbsolute(Event event, TrafficIncident trafficIncident) {
    if (event.getExpectedSpeedAbsolute() != null) {
      trafficIncident.setExpectedSpeedAbsolute(event.getExpectedSpeedAbsolute());
    }
  }

  private void handleCause(org.genivi.trafficinfo.tpeg.tec.event.Cause cause, TrafficIncident trafficIncident) {
    CauseCode tiMainCause = convertMainCause(cause);
    
    if (tiMainCause != null) {
      Cause tiCause = null;
      
      if (cause instanceof org.genivi.trafficinfo.tpeg.tec.event.DirectCause) {
        org.genivi.trafficinfo.tpeg.tec.event.DirectCause tecDirectCause = (org.genivi.trafficinfo.tpeg.tec.event.DirectCause) cause;
        DirectCause tiDirectCause = TI_FACTORY.createDirectCause();
        handleWarningLevel(tecDirectCause.getWarningLevel(), tiDirectCause);
        tiDirectCause.setUnverifiedInformation(tecDirectCause.isUnverifiedInformation());
        handleSubCause(tecDirectCause, tiDirectCause);
        if (tecDirectCause.getLengthAffected() != null) {
          tiDirectCause.setLengthAffected(tecDirectCause.getLengthAffected());
        }
        handleLaneRestrictionType(tecDirectCause, tiDirectCause);
        handleCauseFreeText(tecDirectCause, tiDirectCause);
        if (tecDirectCause.getCauseOffset() != null) {
          tiDirectCause.setCauseOffset(tecDirectCause.getLengthAffected());
        }
        
        tiCause = tiDirectCause;
      } else {
        // has to be LinkedCause
        org.genivi.trafficinfo.tpeg.tec.event.LinkedCause tecLinkedCause = (org.genivi.trafficinfo.tpeg.tec.event.LinkedCause) cause;
        String trafficIncidentManagementId = TecUtil.createMessageId(tecLinkedCause.getOriginatorSID(), tecLinkedCause.getCOID(), tecLinkedCause.getLinkedMessage());
        LinkedCause tiManagedLinkedCause = TI_FACTORY.createLinkedCause();
        tiManagedLinkedCause.setCauseTrafficIncidentId(trafficIncidentManagementId);
        tiCause = tiManagedLinkedCause;
      }
      
      if (tiCause != null) {
        List<Cause> tiCauses = trafficIncident.getCauses();
        tiCause.setMainCause(tiMainCause);
        tiCauses.add(tiCause);
      }
      
    }
  }

  private static CauseCode convertMainCause(org.genivi.trafficinfo.tpeg.tec.event.Cause cause) {
    org.genivi.trafficinfo.tpeg.tec.event.CauseCode tecCauseCode = cause.getMainCause();
    
    if (tecCauseCode == null) {
      return null;
    }
    
    if (tecCauseCode == org.genivi.trafficinfo.tpeg.tec.event.CauseCode.TEST_MESSAGE  ||
        tecCauseCode == org.genivi.trafficinfo.tpeg.tec.event.CauseCode.UNDECODABLE_CAUSE) {
      reportMappingProblem("CauseCode " + tecCauseCode.getName() + " received (ignored).", true);
      return null;
    }
    
    CauseCode tiCauseCode = causeCodeMap.get(tecCauseCode);
    
    if (tiCauseCode == null) {
      reportMappingProblem("CauseCode " + tecCauseCode.getName() + " cannot be handled.", false);
    }
    
    return tiCauseCode;
  }

  private static void handleWarningLevel(org.genivi.trafficinfo.tpeg.tec.event.WarningLevel warningLevel, DirectCause tiDirectCause) {
    if (warningLevel != null) {
      // All values are mapped, so no further check needed.
      tiDirectCause.setWarningLevel(warningLevelMap.get(warningLevel));
    }
  }

  private static void handleSubCause(org.genivi.trafficinfo.tpeg.tec.event.DirectCause tecDirectCause, DirectCause tiDirectCause) {
    tiDirectCause.setSubCause(null);
    org.genivi.trafficinfo.tpeg.tec.event.CauseCode tecMainCause = tecDirectCause.getMainCause();
    Object tiSubCause = null;

    if (tecDirectCause.isSetSubCause()) {
      Object tecSubCause = tecDirectCause.getSubCause();
      switch (tecMainCause) {
      case TRAFFIC_CONGESTION:
        tiSubCause = convertSubCauseTrafficCongestion((org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion) tecSubCause);
        break;

      case ACCIDENT:
        tiSubCause = convertSubCauseAccident((org.genivi.trafficinfo.tpeg.tec.event.Accident) tecSubCause);
        break;

      case ROADWORKS:
        tiSubCause = convertSubCauseRoadWorks((org.genivi.trafficinfo.tpeg.tec.event.RoadWorks) tecSubCause);
        break;

      case NARROW_LANES:
        tiSubCause = convertSubCauseNarrowLanes((org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes) tecSubCause);
        break;

      case IMPASSIBILITY:
        tiSubCause = convertSubCauseImpassibility((org.genivi.trafficinfo.tpeg.tec.event.Impassibility) tecSubCause);
        break;

      case SLIPPERY_ROAD:
        tiSubCause = convertSubCauseSlipperyRoad((org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad) tecSubCause);
        break;

      case AQUAPLANING:
        // No SubCause
        break;

      case FIRE:
        tiSubCause = convertSubCauseFire((org.genivi.trafficinfo.tpeg.tec.event.Fire) tecSubCause);
        break;

      case HAZARDOUS_DRIVING_CONDITIONS:
        tiSubCause = convertSubCauseHazardousDrivingConditions((org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions) tecSubCause);
        break;

      case OBJECTS_ON_THE_ROAD:
        tiSubCause = convertSubCauseObjectsOnTheRoad((org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad) tecSubCause);
        break;

      case ANIMALS_ON_ROADWAY:
        tiSubCause = convertSubCauseAnimalsOnRoadway((org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway) tecSubCause);
        break;

      case PEOPLE_ON_ROADWAY:
        tiSubCause = convertSubCausePeopleOnRoadway((org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway) tecSubCause);
        break;

      case BROKEN_DOWN_VEHICLES:
        tiSubCause = convertSubCauseBrokenDownVehicles((org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles) tecSubCause);
        break;

      case VEHICLE_ON_WRONG_CARRIAGEWAY:
        // No SubCause
        break;

      case RESCUE_AND_RECOVERY_WORK_IN_PROGRESS:
        tiSubCause = convertSubCauseRescueAndRecoveryWorkInProgress((org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress) tecSubCause);
        break;

      case REGULATORY_MEASURE:
        tiSubCause = convertSubCauseRegulatoryMeasure((org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure) tecSubCause);
        break;

      case EXTREME_WEATHER_CONDITIONS:
        tiSubCause = convertSubCauseExtremeWeatherConditions((org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions) tecSubCause);
        break;

      case VISIBILITY_REDUCED:
        tiSubCause = convertSubCauseVisibilityReduced((org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced) tecSubCause);
        break;

      case PRECIPITATION:
        tiSubCause = convertSubCausePrecipitation((org.genivi.trafficinfo.tpeg.tec.event.Precipitation) tecSubCause);
        break;

      case RECKLESS_PERSONS:
        tiSubCause = convertSubCauseRecklessPersons((org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons) tecSubCause);
        break;

      case OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED:
        // No SubCause
        break;

      case TRAFFIC_REGULATIONS_CHANGED:
        // No SubCause
        break;

      case MAJOR_EVENT:
        tiSubCause = convertSubCauseMajorEvent((org.genivi.trafficinfo.tpeg.tec.event.MajorEvent) tecSubCause);
        break;

      case SERVICE_NOT_OPERATING:
        tiSubCause = convertSubCauseServiceNotOperating((org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating) tecSubCause);
        break;

      case SERVICE_NOT_USEABLE:
        tiSubCause = convertSubCauseServiceNotUsable((org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable) tecSubCause);
        break;

      case SLOW_MOVING_VEHICLES:
        tiSubCause = convertSubCauseSlowMovingVehicles((org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles) tecSubCause);
        break;

      case DANGEROUS_END_OF_QUEUE:
        tiSubCause = convertSubCauseDangerousEndOfQueue((org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue) tecSubCause);
        break;

      case RISK_OF_FIRE:
        tiSubCause = convertSubCauseRiskOfFire((org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire) tecSubCause);
        break;

      case TIME_DELAY:
        tiSubCause = convertSubCauseTimeDelay((org.genivi.trafficinfo.tpeg.tec.event.TimeDelay) tecSubCause);
        break;

      case POLICE_CHECKPOINT:
        tiSubCause = convertSubCausePoliceCheckpoint((org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint) tecSubCause);
        break;

      case MALFUNCTIONING_ROADSIDE_EQUIPMENT:
        tiSubCause = convertSubCauseMalfunctioningRoadsideEquipment((org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment) tecSubCause);
        break;
        
      case TEST_MESSAGE:
      case UNDECODABLE_CAUSE:
        // No subCause
        break;
      }
    }

    if (tiSubCause != null) {
      tiDirectCause.setSubCause(tiSubCause);
    }
  }

  private static TrafficCongestion convertSubCauseTrafficCongestion(org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion tecTrafficCongestion) {    
    TrafficCongestion tiTrafficCongestion = trafficCongestionMap.get(tecTrafficCongestion);
    
    if (tiTrafficCongestion == null) {
      reportMappingProblem("TrafficCongestion sub cause " + tecTrafficCongestion.getName() + " cannot be handled.", false);
    }
    
    return tiTrafficCongestion;
  }

  private static Accident convertSubCauseAccident(org.genivi.trafficinfo.tpeg.tec.event.Accident tecAccident) {    
    Accident tiAccident = accidentMap.get(tecAccident);
    
    if (tiAccident == null) {
      reportMappingProblem("Accident sub cause " + tecAccident.getName() + " cannot be handled.", false);
    }
    
    return tiAccident;
  }

  private static RoadWorks convertSubCauseRoadWorks(org.genivi.trafficinfo.tpeg.tec.event.RoadWorks tecRoadWorks) {    
    RoadWorks tiRoadWorks = roadWorksMap.get(tecRoadWorks);
    
    if (tiRoadWorks == null) {
      reportMappingProblem("RoadWorks sub cause " + tecRoadWorks.getName() + " cannot be handled.", false);
    }
    
    return tiRoadWorks;
  }

  private static NarrowLanes convertSubCauseNarrowLanes(org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes tecNarrowLanes) {    
    NarrowLanes tiNarrowLanes = narrowLanesMap.get(tecNarrowLanes);
    
    if (tiNarrowLanes == null) {
      reportMappingProblem("NarrowLanes sub cause " + tecNarrowLanes.getName() + " cannot be handled.", false);
    }
    
    return tiNarrowLanes;
  }

  private static Impassibility convertSubCauseImpassibility(org.genivi.trafficinfo.tpeg.tec.event.Impassibility tecImpassibility) {    
    Impassibility tiImpassibility = impassibilityMap.get(tecImpassibility);
    
    if (tiImpassibility == null) {
      reportMappingProblem("Impassibility sub cause " + tecImpassibility.getName() + " cannot be handled.", false);
    }
    
    return tiImpassibility;
  }

  private static SlipperyRoad convertSubCauseSlipperyRoad(org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad tecSlipperyRoad) {    
    SlipperyRoad tiSlipperyRoad = slipperyRoadMap.get(tecSlipperyRoad);
    
    if (tiSlipperyRoad == null) {
      reportMappingProblem("SlipperyRoad sub cause " + tecSlipperyRoad.getName() + " cannot be handled.", false);
    }
    
    return tiSlipperyRoad;
  }

  private static Fire convertSubCauseFire(org.genivi.trafficinfo.tpeg.tec.event.Fire tecFire) {    
    Fire tiFire = fireMap.get(tecFire);
    
    if (tiFire == null) {
      reportMappingProblem("Fire sub cause " + tecFire.getName() + " cannot be handled.", false);
    }
    
    return tiFire;
  }

  private static HazardousDrivingConditions convertSubCauseHazardousDrivingConditions(org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions tecHazardousDrivingConditions) {    
    HazardousDrivingConditions tiHazardousDrivingConditions = hazardousDrivingConditionsMap.get(tecHazardousDrivingConditions);
    
    if (tiHazardousDrivingConditions == null) {
      reportMappingProblem("HazardousDrivingConditions sub cause " + tecHazardousDrivingConditions.getName() + " cannot be handled.", false);
    }
    
    return tiHazardousDrivingConditions;
  }

  private static ObjectsOnTheRoad convertSubCauseObjectsOnTheRoad(org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad tecObjectsOnTheRoad) {    
    ObjectsOnTheRoad tiObstructionsOnTheRoad = objectsOnTheRoadMap.get(tecObjectsOnTheRoad);
    
    if (tiObstructionsOnTheRoad == null) {
      reportMappingProblem("ObjectsOnTheRoad sub cause " + tecObjectsOnTheRoad.getName() + " cannot be handled.", false);
    }
    
    return tiObstructionsOnTheRoad;
  }

  private static AnimalsOnRoadway convertSubCauseAnimalsOnRoadway(org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway tecAnimalsOnRoadway) {    
    AnimalsOnRoadway tiAnimalsOnRoadway = animalsOnRoadwayMap.get(tecAnimalsOnRoadway);
    
    if (tiAnimalsOnRoadway == null) {
      reportMappingProblem("AnimalsOnRoadway sub cause " + tecAnimalsOnRoadway.getName() + " cannot be handled.", false);
    }
    
    return tiAnimalsOnRoadway;
  }

  private static PeopleOnRoadway convertSubCausePeopleOnRoadway(org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway tecPeopleOnRoadway) {    
    PeopleOnRoadway tiPeopleOnRoadway = peopleOnRoadwayMap.get(tecPeopleOnRoadway);
    
    if (tiPeopleOnRoadway == null) {
      reportMappingProblem("PeopleOnRoadway sub cause " + tecPeopleOnRoadway.getName() + " cannot be handled.", false);
    }
    
    return tiPeopleOnRoadway;
  }
  
  private static BrokenDownVehicles convertSubCauseBrokenDownVehicles(org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles tecBrokenDownVehicles) {    
    BrokenDownVehicles tiBrokenDownVehicles = brokenDownVehiclesMap.get(tecBrokenDownVehicles);
    
    if (tiBrokenDownVehicles == null) {
      reportMappingProblem("BrokenDownVehicles sub cause " + tecBrokenDownVehicles.getName() + " cannot be handled.", false);
    }
    
    return tiBrokenDownVehicles;
  }

  private static RescueAndRecoveryWorkInProgress convertSubCauseRescueAndRecoveryWorkInProgress(org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress tecRescueAndRecoveryWorkInProgress) {    
    RescueAndRecoveryWorkInProgress tiRescueAndRecoveryWorkInProgress = rescueAndRecoveryWorkInProgressMap.get(tecRescueAndRecoveryWorkInProgress);
    
    if (tiRescueAndRecoveryWorkInProgress == null) {
      reportMappingProblem("RescueAndRecoveryWorkInProgress sub cause " + tecRescueAndRecoveryWorkInProgress.getName() + " cannot be handled.", false);
    }
    
    return tiRescueAndRecoveryWorkInProgress;
  }

  private static RegulatoryMeasure convertSubCauseRegulatoryMeasure(org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure tecRegulatoryMeasure) {    
    RegulatoryMeasure tiRegulatoryMeasure = regulatoryMeasureMap.get(tecRegulatoryMeasure);
    
    if (tiRegulatoryMeasure == null) {
      reportMappingProblem("RegulatoryMeasure sub cause " + tecRegulatoryMeasure.getName() + " cannot be handled.", false);
    }
    
    return tiRegulatoryMeasure;
  }

  private static ExtremeWeatherConditions convertSubCauseExtremeWeatherConditions(org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions tecExtremeWeatherConditions) {    
    ExtremeWeatherConditions tiExtremeWeatherConditions = extremeWeatherConditionsMap.get(tecExtremeWeatherConditions);
    
    if (tiExtremeWeatherConditions == null) {
      reportMappingProblem("ExtremeWeatherConditions sub cause " + tecExtremeWeatherConditions.getName() + " cannot be handled.", false);
    }
    
    return tiExtremeWeatherConditions;
  }

  private static VisibilityReduced convertSubCauseVisibilityReduced(org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced tecVisibilityReduced) {    
    VisibilityReduced tiVisibilityReduced = visibilityReducedMap.get(tecVisibilityReduced);
    
    if (tiVisibilityReduced == null) {
      reportMappingProblem("VisibilityReduced sub cause " + tecVisibilityReduced.getName() + " cannot be handled.", false);
    }
    
    return tiVisibilityReduced;
  }

  private static Precipitation convertSubCausePrecipitation(org.genivi.trafficinfo.tpeg.tec.event.Precipitation tecPrecipitation) {    
    Precipitation tiPrecipitation = precipitationMap.get(tecPrecipitation);
    
    if (tiPrecipitation == null) {
      reportMappingProblem("Precipitation sub cause " + tecPrecipitation.getName() + " cannot be handled.", false);
    }
    
    return tiPrecipitation;
  }

  private static RecklessPersons convertSubCauseRecklessPersons(org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons tecRecklessPersons) {    
    RecklessPersons tiRecklessPersons = recklessPersonsMap.get(tecRecklessPersons);
    
    if (tiRecklessPersons == null) {
      reportMappingProblem("RecklessPersons sub cause " + tecRecklessPersons.getName() + " cannot be handled.", false);
    }
    
    return tiRecklessPersons;
  }
  
  private static MajorEvent convertSubCauseMajorEvent(org.genivi.trafficinfo.tpeg.tec.event.MajorEvent tecMajorEvent) {    
    MajorEvent tiMajorEvent = majorEventMap.get(tecMajorEvent);
    
    if (tiMajorEvent == null) {
      reportMappingProblem("MajorEvent sub cause " + tecMajorEvent.getName() + " cannot be handled.", false);
    }
    
    return tiMajorEvent;
  }

  private static ServiceNotOperating convertSubCauseServiceNotOperating(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating tecServiceNotOperating) {    
    ServiceNotOperating tiServiceNotOperating = serviceNotOperatingMap.get(tecServiceNotOperating);
    
    if (tiServiceNotOperating == null) {
      reportMappingProblem("ServiceNotOperating sub cause " + tecServiceNotOperating.getName() + " cannot be handled.", false);
    }
    
    return tiServiceNotOperating;
  }

  private static ServiceNotUsable convertSubCauseServiceNotUsable(org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable tecServiceNotUsable) {    
    ServiceNotUsable tiServiceNotUsable = serviceNotUsableMap.get(tecServiceNotUsable);
    
    if (tiServiceNotUsable == null) {
      reportMappingProblem("ServiceNotUsable sub cause " + tecServiceNotUsable.getName() + " cannot be handled.", false);
    }
    
    return tiServiceNotUsable;
  }

  private static SlowMovingVehicles convertSubCauseSlowMovingVehicles(org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles tecSlowMovingVehicles) {    
    SlowMovingVehicles tiSlowMovingVehicles = slowMovingVehiclesMap.get(tecSlowMovingVehicles);
    
    if (tiSlowMovingVehicles == null) {
      reportMappingProblem("SlowMovingVehicles sub cause " + tecSlowMovingVehicles.getName() + " cannot be handled.", false);
    }
    
    return tiSlowMovingVehicles;
  }

  private static DangerousEndOfQueue convertSubCauseDangerousEndOfQueue(org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue tecDangerousEndOfQueue) {    
    DangerousEndOfQueue tiDangerousEndOfQueue = dangerousEndOfQueueMap.get(tecDangerousEndOfQueue);
    
    if (tiDangerousEndOfQueue == null) {
      reportMappingProblem("DangerousEndOfQueue sub cause " + tecDangerousEndOfQueue.getName() + " cannot be handled.", false);
    }
    
    return tiDangerousEndOfQueue;
  }

  private static RiskOfFire convertSubCauseRiskOfFire(org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire tecRiskOfFire) {    
    RiskOfFire tiDangerOfFire = riskOfFireMap.get(tecRiskOfFire);
    
    if (tiDangerOfFire == null) {
      reportMappingProblem("RiskOfFire sub cause " + tecRiskOfFire.getName() + " cannot be handled.", false);
    }
    
    return tiDangerOfFire;
  }

  private static TimeDelay convertSubCauseTimeDelay(org.genivi.trafficinfo.tpeg.tec.event.TimeDelay tecTimeDelay) {    
    TimeDelay tiTimeDelay = timeDelayMap.get(tecTimeDelay);
    
    if (tiTimeDelay == null) {
      reportMappingProblem("TimeDelay sub cause " + tecTimeDelay.getName() + " cannot be handled.", false);
    }
    
    return tiTimeDelay;
  }

  private static PoliceCheckpoint convertSubCausePoliceCheckpoint(org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint tecPoliceCheckpoint) {    
    PoliceCheckpoint tiPoliceCheckpoint = policeCheckpointMap.get(tecPoliceCheckpoint);
    
    if (tiPoliceCheckpoint == null) {
      reportMappingProblem("PoliceCheckpoint sub cause " + tecPoliceCheckpoint.getName() + " cannot be handled.", false);
    }
    
    return tiPoliceCheckpoint;
  }

  private static MalfunctioningRoadsideEquipment convertSubCauseMalfunctioningRoadsideEquipment(org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment tecMalfunctioningRoadsideEquipment) {    
    MalfunctioningRoadsideEquipment tiMalfunctioningRoadsideEquipment = malfunctioningRoadsideEquipmentMap.get(tecMalfunctioningRoadsideEquipment);
    
    if (tiMalfunctioningRoadsideEquipment == null) {
      reportMappingProblem("MalfunctioningRoadsideEquipment sub cause " + tecMalfunctioningRoadsideEquipment.getName() + " cannot be handled.", false);
    }
    
    return tiMalfunctioningRoadsideEquipment;
  }
  
  private static void handleLaneRestrictionType(org.genivi.trafficinfo.tpeg.tec.event.DirectCause tecDirectCause, DirectCause tiDirectCause) {
    if (!tecDirectCause.isSetLaneRestrictionType()) {
      return;
    }
    
    LaneRestrictionType tiLaneRestrictionType = convertLaneRestrictionType(tecDirectCause.getLaneRestrictionType());
    
    if (tiLaneRestrictionType != null) {
      LaneRestrictions laneRestrictions = TI_FACTORY.createLaneRestrictions();
      laneRestrictions.setLaneRestrictionType(tiLaneRestrictionType);
      laneRestrictions.setNumberOfLanes(tecDirectCause.getNumberOfLanes());
      
      tiDirectCause.setLaneRestrictions(laneRestrictions);
    }
  }
  
  private void handleCauseFreeText(org.genivi.trafficinfo.tpeg.tec.event.DirectCause tecDirectCause, DirectCause tiDirectCause) {
    LOGGER.info("=>");
    
    for (LocalisedShortString tecLocalisedShortString: tecDirectCause.getFreeText()) {
      LocalizedString tiLocalisedString = COMMON_FACTORY.createLocalizedString();
      String geniviLanguageCode = languageMap.get(tecLocalisedShortString.getLanguageCode());
      if (geniviLanguageCode != null) {
        tiLocalisedString.setLanguageCode(geniviLanguageCode);
        tiLocalisedString.setCountryCode(languageCountryMap.get(tecLocalisedShortString.getLanguageCode()));
        tiLocalisedString.setString(tecLocalisedShortString.getString());
        tiDirectCause.getFreeText().add(tiLocalisedString);
      } else {
        throw new IllegalArgumentException("TEC LanguageCode " + tecLocalisedShortString.getLanguageCode() + " not supported");
      }
    }
  }
  
  private static LaneRestrictionType convertLaneRestrictionType(org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType tecLaneRestrictionType) {
    LaneRestrictionType tiLaneRestrictionType = laneRestrictionTypeMap.get(tecLaneRestrictionType);
    
    if (tiLaneRestrictionType == null) {
      reportMappingProblem("LaneRestrictionType " + tecLaneRestrictionType.getName() + " cannot be handled.", false);
    }
    
    return tiLaneRestrictionType;
  }


  private void handleAdvice(org.genivi.trafficinfo.tpeg.tec.event.Advice advice, TrafficIncident trafficIncident) {
    Advice tiAdvice = TI_FACTORY.createAdvice();
    
    AdviceCode tiAdviceCode = convertAdviceCode(advice);
    tiAdvice.setMainAdvice(tiAdviceCode);
    handleSubAdviceCode(advice, tiAdvice);
    
    handleAdviceFreeText(advice, tiAdvice);    
    
    trafficIncident.getAdvices().add(tiAdvice);
  }

  private static AdviceCode convertAdviceCode(org.genivi.trafficinfo.tpeg.tec.event.Advice advice) {
    org.genivi.trafficinfo.tpeg.tec.event.AdviceCode tecAdviceCode = advice.getAdviceCode();
    
    if (tecAdviceCode == null) {
      return null;
    }
    
    if (tecAdviceCode == org.genivi.trafficinfo.tpeg.tec.event.AdviceCode.UNDECODABLE_ADVICE) {
      reportMappingProblem("AdviceCode " + tecAdviceCode.getName() + " received (ignored).", true);
      return null;
    }
    
    AdviceCode tiAdviceCode = adviceCodeMap.get(tecAdviceCode);
    
    if (tiAdviceCode == null) {
      reportMappingProblem("AdviceCode " + tecAdviceCode.getName() + " cannot be handled.", false);
    }
    
    return tiAdviceCode;
  }

  private static void handleSubAdviceCode(org.genivi.trafficinfo.tpeg.tec.event.Advice tecAdvice, Advice tiAdvice) {
    org.genivi.trafficinfo.tpeg.tec.event.AdviceCode tecAdviceCode = tecAdvice.getAdviceCode();
    Object tiSubAdviceCode = null;
    Object tecSubAdviceCode = tecAdvice.getSubAdviceCode();

    if (tecSubAdviceCode != null) {
      switch (tecAdviceCode) {
      case AVOID_THE_AREA:
      case DO_NOT_DIVERT:
      case DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE:
      case FOLLOW_POLICE_INSTRUCTIONS:
      case NO_DIVERSION_TO_RECOMMEND:
      case SWITCH_ON_RADIO:
      case UNDECODABLE_ADVICE:
      case USE_HARD_SHOULDER_AS_LANE:
      case WAIT_FOR_CONVOI:
      case WAIT_FOR_IMPROVED_WEATHER:
      case WAIT_FOR_POLICE_PATROL:
        // No SubAdviceCode
        break;

      case DO_NOT_LEAVE_YOUR_VEHICLE:
        tiSubAdviceCode = convertSubAdviceCodeDoNotLeaveYourVehicle((org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle) tecSubAdviceCode);
        break;

      case DRIVE_CAREFULLY:
        tiSubAdviceCode = convertSubAdviceCodeDriveCarefully((org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully) tecSubAdviceCode);
        break;

      case DRIVING_NOT_ALLOWED:
        tiSubAdviceCode = convertSubAdviceCodeDrivingNotAllowed((org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed) tecSubAdviceCode);
        break;

      case FOLLOW_DIVERSION:
        tiSubAdviceCode = convertSubAdviceCodeFollowDiversion((org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion) tecSubAdviceCode);
        break;

      case GIVING_PATH_VEHICLES_COMING_FROM_BEHIND:
        tiSubAdviceCode = convertSubAdviceCodeGivingPathVehiclesComingFromBehind((org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind) tecSubAdviceCode);
        break;

      case OVERTAKING_NOT_ALLOWED:
        tiSubAdviceCode = convertSubAdviceCodeOvertakingNotAllowed((org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed) tecSubAdviceCode);
        break;

      case USE_TOLL_LANES:
        tiSubAdviceCode = convertSubAdviceCodeUseTollLanes((org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes) tecSubAdviceCode);
        break;

      }
    }

    if (tiSubAdviceCode != null) {
      tiAdvice.setSubAdvice(tiSubAdviceCode);
    }
  }
  
  private static DoNotLeaveYourVehicle convertSubAdviceCodeDoNotLeaveYourVehicle(org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle tecDoNotLeaveYourVehicle) {
    DoNotLeaveYourVehicle tiDoNotLeaveYourVehicle = doNotLeaveYourVehicleMap.get(tecDoNotLeaveYourVehicle);
    
    if (tiDoNotLeaveYourVehicle == null) {
      reportMappingProblem("DoNotLeaveYourVehicle sub cause " + tecDoNotLeaveYourVehicle.getName() + " cannot be handled.", false);
    }
    
    return tiDoNotLeaveYourVehicle;
 }

  private static DriveCarefully convertSubAdviceCodeDriveCarefully(org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully tecDriveCarefully) {
    DriveCarefully tiDriveCarefully = driveCarefullyMap.get(tecDriveCarefully);
    
    if (tiDriveCarefully == null) {
      reportMappingProblem("DriveCarefully sub cause " + tecDriveCarefully.getName() + " cannot be handled.", false);
    }
    
    return tiDriveCarefully;
  }

  private static DrivingNotAllowed convertSubAdviceCodeDrivingNotAllowed(org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed tecDrivingNotAllowed) {
    DrivingNotAllowed tiDrivingNotAllowed = drivingNotAllowedMap.get(tecDrivingNotAllowed);
    
    if (tiDrivingNotAllowed == null) {
      reportMappingProblem("DrivingNotAllowed sub cause " + tecDrivingNotAllowed.getName() + " cannot be handled.", false);
    }
    
    return tiDrivingNotAllowed;
  }

  private static FollowDiversion convertSubAdviceCodeFollowDiversion(org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion tecFollowDiversion) {
    FollowDiversion tiFollowDiversion = followDiversionMap.get(tecFollowDiversion);
    
    if (tiFollowDiversion == null) {
      reportMappingProblem("FollowDiversion sub cause " + tecFollowDiversion.getName() + " cannot be handled.", false);
    }
    
    return tiFollowDiversion;
  }

  private static GivingPathVehiclesFromBehind convertSubAdviceCodeGivingPathVehiclesComingFromBehind(org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind tecGivingPathVehiclesFromBehind) {
    GivingPathVehiclesFromBehind tiGivingPathVehiclesFromBehind = givingPathVehiclesFromBehindMap.get(tecGivingPathVehiclesFromBehind);
    
    if (tiGivingPathVehiclesFromBehind == null) {
      reportMappingProblem("GivingPathVehiclesFromBehind sub cause " + tecGivingPathVehiclesFromBehind.getName() + " cannot be handled.", false);
    }
    
    return tiGivingPathVehiclesFromBehind;
  }

  private static OvertakingNotAllowed convertSubAdviceCodeOvertakingNotAllowed(org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed tecOvertakingNotAllowed) {
    OvertakingNotAllowed tiOvertakingNotAllowed = overtakingNotAllowedMap.get(tecOvertakingNotAllowed);
    
    if (tiOvertakingNotAllowed == null) {
      reportMappingProblem("OvertakingNotAllowed sub cause " + tecOvertakingNotAllowed.getName() + " cannot be handled.", false);
    }
    
    return tiOvertakingNotAllowed;
  }

  private static UseTollLanes convertSubAdviceCodeUseTollLanes(org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes tecUseTollLanes) {
    UseTollLanes tiUseTollLanes = useTollLanesMap.get(tecUseTollLanes);
    
    if (tiUseTollLanes == null) {
      reportMappingProblem("UseTollLanes sub cause " + tecUseTollLanes.getName() + " cannot be handled.", false);
    }
    
    return tiUseTollLanes;
  }
  
  private void handleAdviceFreeText(org.genivi.trafficinfo.tpeg.tec.event.Advice tecAdvice, Advice tiAdvice) {
    LOGGER.info("=>");
    
    for (LocalisedShortString tecLocalisedShortString: tecAdvice.getFreeText()) {
      LocalizedString tiLocalisedString = COMMON_FACTORY.createLocalizedString();
      String geniviLanguageCode = languageMap.get(tecLocalisedShortString.getLanguageCode());
      if (geniviLanguageCode != null) {
        tiLocalisedString.setLanguageCode(geniviLanguageCode);
        tiLocalisedString.setCountryCode(languageCountryMap.get(tecLocalisedShortString.getLanguageCode()));
        tiLocalisedString.setString(tecLocalisedShortString.getString());
        tiAdvice.getFreeText().add(tiLocalisedString);
      } else {
        throw new IllegalArgumentException("TEC LanguageCode " + tecLocalisedShortString.getLanguageCode() + " not supported");
      }
    }
  }

  
  private static void handleVehicleRestriction(org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction tecVehicleRestriction, TrafficIncident trafficIncident) {
    VehicleType tiVehicleType = convertVehicleType(tecVehicleRestriction.getVehicleType());
    
    if (tiVehicleType != null) {
      Applicability applicability = TI_FACTORY.createApplicability();
      applicability.setVehicleType(tiVehicleType);
      
      for (org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction tecVehicleRelatedRestriction: tecVehicleRestriction.getRestriction()) {
        handleVehicleRelatedRestriction(tecVehicleRelatedRestriction, applicability.getVehicleRelatedRestrictions());
      }
      
      trafficIncident.getApplicability().add(applicability);
    }
  }
  
  private static void handleVehicleRelatedRestriction(org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction tecVehicleRelatedRestriction,
      EList<org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction> vehicleRelatedRestrictions) {
    RestrictionType tiRestrictionType = convertRestrictionType(tecVehicleRelatedRestriction.getRestrictionType());

    if (tiRestrictionType != null) {
      VehicleRelatedRestriction tiVehicleRelatedRestriction = TI_FACTORY.createVehicleRelatedRestriction();
      tiVehicleRelatedRestriction.setRestrictionType(tiRestrictionType);
      tiVehicleRelatedRestriction.setRestrictionValue(tecVehicleRelatedRestriction.getRestrictionValue());
      
      LocationReferencingContainer locationReferencingContainer = tecVehicleRelatedRestriction.getRestrictionLocation();
      
      if (locationReferencingContainer != null) {
        for (Method method :locationReferencingContainer.getMethod()) {
          LocationReference locationReference = createLocationReferenceForMethod(method);
          if (locationReference != null) {
            tiVehicleRelatedRestriction.setRestrictionLocationReference(locationReference);
          }
        }
      }
      
      vehicleRelatedRestrictions.add(tiVehicleRelatedRestriction);
    }
  }

  private static VehicleType convertVehicleType(org.genivi.trafficinfo.tpeg.tec.event.VehicleType tecVehicleType) {
    if (tecVehicleType == org.genivi.trafficinfo.tpeg.tec.event.VehicleType.UNDECODABLE_VEHICLE_TYPE) {
      reportMappingProblem("VehicleType " + tecVehicleType.getName() + " received (ignored).", true);
      return null;
    }
    
    VehicleType tiVehicleType = vehicleTypeMap.get(tecVehicleType);
    
    if (tiVehicleType == null) {
      reportMappingProblem("VehicleType " + tecVehicleType.getName() + " cannot be handled.", false);
    }
    
    return tiVehicleType;
  }

  private static RestrictionType convertRestrictionType(org.genivi.trafficinfo.tpeg.tec.event.RestrictionType tecRestrictionType) {
    if (tecRestrictionType == org.genivi.trafficinfo.tpeg.tec.event.RestrictionType.UNDECODABLE_RESTRICTION) {
      reportMappingProblem("RestrictionType " + tecRestrictionType.getName() + " received (ignored).", true);
      return null;
    }
    
    RestrictionType tiRestrictionType = restrictionTypeMap.get(tecRestrictionType);
    
    if (tiRestrictionType ==  null) {
      reportMappingProblem("RestrictionType " + tecRestrictionType.getName() + " cannot be handled.", false);
    }
    
    return tiRestrictionType;
  }

  private static void reportMappingProblem(String message, boolean info) {
    if (info) {
      System.out.println("TecEventToTrafficIncidentConversion: " + message);
    } else {
      System.err.println("TecEventToTrafficIncidentConversion: " + message);
    }
  }
}
