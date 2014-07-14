/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.dbus.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.freedesktop.dbus.UInt16;
import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.Variant;
import org.genivi.common.CommonFactory;
import org.genivi.common.Coordinate;
import org.genivi.common.LocalizedString;
import org.genivi.common.RectangularArea;
import org.genivi.common.Version;
import org.genivi.iconset.ColorType;
import org.genivi.iconset.IconData;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconDescriptor;
import org.genivi.iconset.IconDimension;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.iconset.IconSize;
import org.genivi.iconset.IconsetFactory;
import org.genivi.location.AreaLocation;
import org.genivi.location.AreaLocationInfo;
import org.genivi.location.LinearLocation;
import org.genivi.location.LinearLocationInfo;
import org.genivi.location.Location;
import org.genivi.location.LocationFactory;
import org.genivi.location.LocationInfo;
import org.genivi.location.PointLocation;
import org.genivi.location.PointLocationInfo;
import org.genivi.location.PointLocationType;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.FeedInformation;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.trafficincidentsserviceFactory;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.AdviceStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.ApplicabilityStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.AreaLocationInfoStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.AreaLocationStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.CategoryDefinitionStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.CauseDiscriminatedVariant;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.CauseStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.CauseType;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.CoordinateStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.DirectCauseStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.FeedInformationStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.IconDataStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.IconDefinitionStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.IconDescriptorStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.IconInfoStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.IconSetStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.IconSizeStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LaneRestrictionsStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LinearLocationInfoStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LinearLocationStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LinkedCauseStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LocalizedStringStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LocationDiscriminatedVariant;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LocationInfoDiscriminatedVariant;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LocationInfoStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LocationInfoType;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LocationStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.LocationType;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.PointLocationInfoStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.PointLocationStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.RectangularAreaStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TemporarySpeedLimitSectionStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TemporarySpeedLimitStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TrafficIncidentStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.VehicleRelatedRestrictionStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.VersionStruct;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentFactory;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction;
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

public class StructUtil {
  private final static Logger LOGGER = Logger.getLogger(StructUtil.class.getName());
  private final static CommonFactory COMMON_FACTORY = CommonFactory.eINSTANCE;
  private final static LocationFactory LOCATION_FACTORY = LocationFactory.eINSTANCE;
  private final static trafficincidentFactory TRAFFIC_INCIDENT_FACTORY = trafficincidentFactory.eINSTANCE;
  private final static trafficincidentsserviceFactory TRAFFIC_INCIDENTS_SVC_FACTORY = trafficincidentsserviceFactory.eINSTANCE;
  private final static IconsetFactory ICON_SET_FACTORY = IconsetFactory.eINSTANCE;
  
  static {
    LOGGER.setLevel(Level.SEVERE);
  }
  
  public static Version versionStructToVersion(VersionStruct versionStruct) {
    Version version = COMMON_FACTORY.createVersion();
    
    version.setMajor(versionStruct.major.intValue());
    version.setMinor(versionStruct.minor.intValue());
    version.setMicro(versionStruct.micro.intValue());
    version.setDate(versionStruct.date);
    
    return version;
  }
  
  public static VersionStruct versionToVersionStruct(Version version) {
    UInt16 major = new UInt16(version.getMajor());
    UInt16 minor = new UInt16(version.getMinor());
    UInt16 micro = new UInt16(version.getMicro());
    
    VersionStruct versionStruct = new VersionStruct(major, minor, micro, version.getDate());
    
    return versionStruct;
  }

  public static TrafficIncident trafficIncidentStructToTrafficIncident(TrafficIncidentStruct trafficIncidentStruct) {
    TrafficIncident trafficIncident = TRAFFIC_INCIDENT_FACTORY.createTrafficIncident();
    
    if (trafficIncidentStruct.effectCode != 0) {
      EffectCode effectCode = EffectCode.get(trafficIncidentStruct.effectCode);
      trafficIncident.setEffectCode(effectCode);
    }
    
    if (!trafficIncidentStruct.effectText.isEmpty()) {
      trafficIncident.setEffectText(trafficIncidentStruct.effectText);
    }
    
    long startTimeValue = trafficIncidentStruct.startTime;
    if (startTimeValue != -1) {
      Date startTime = new Date(startTimeValue * 1000 * 60);
      trafficIncident.setStartTime(startTime);
    }
    
    long stopTimeValue = trafficIncidentStruct.stopTime;
    if (stopTimeValue != -1) {
      Date stopTime = new Date(stopTimeValue * 1000 * 60);
      trafficIncident.setStopTime(stopTime);
    }
    
    if (trafficIncidentStruct.tendency != 0) {
      Tendency tendency = Tendency.get(trafficIncidentStruct.tendency);
      trafficIncident.setTendency(tendency);
    }

    if (!trafficIncidentStruct.tendencyText.isEmpty()) {
      trafficIncident.setTendencyText(trafficIncidentStruct.tendencyText);
    }
    
    if (trafficIncidentStruct.lengthAffected != -1) {
      trafficIncident.setLengthAffected(trafficIncidentStruct.lengthAffected);
    }
    
    if (trafficIncidentStruct.averageSpeedAbsolute != -1) {
      trafficIncident.setAverageSpeedAbsolute(trafficIncidentStruct.averageSpeedAbsolute);
    }
    
    if (trafficIncidentStruct.delay != -1) {
      trafficIncident.setDelay(trafficIncidentStruct.delay);
    }
    
    if (trafficIncidentStruct.segmentSpeedLimit != -1) {
      trafficIncident.setSegmentSpeedLimit(trafficIncidentStruct.segmentSpeedLimit);
    }
    
    if (trafficIncidentStruct.expectedSpeedAbsolute != -1) {
      trafficIncident.setExpectedSpeedAbsolute(trafficIncidentStruct.expectedSpeedAbsolute);
    }
    
    for (CauseDiscriminatedVariant causeDiscriminatedVariant: trafficIncidentStruct.causes) {
      Cause cause = causeDiscriminatedVariantToCause(causeDiscriminatedVariant);
      trafficIncident.getCauses().add(cause);
    }
        
    if (trafficIncidentStruct.location.size() == 1) {
      Location location = locationDiscriminatedVariantToLocation(trafficIncidentStruct.location.get(0));
      trafficIncident.setLocation(location);
    } else if (trafficIncidentStruct.location.size() == 0) {
      // No action
    } else {
      throw new RuntimeException("Illegal size for location: " + trafficIncidentStruct.location.size());
    }
    
    for (AdviceStruct adviceStruct: trafficIncidentStruct.advices) {
      Advice advice = adviceStructToAdvice(adviceStruct);
      trafficIncident.getAdvices().add(advice);
    }
    
    for (ApplicabilityStruct applicabilityStruct: trafficIncidentStruct.applicability) {
      Applicability applicability = applicabilityStructToApplicability(applicabilityStruct);
      trafficIncident.getApplicability().add(applicability);
    }

    for (TemporarySpeedLimitStruct temporarySpeedLimitStruct: trafficIncidentStruct.temporarySpeedLimits) {
      TemporarySpeedLimit temporarySpeedLimit = temporarySpeedLimitStructToTemporarySpeedLimit(temporarySpeedLimitStruct);
      trafficIncident.getTemporarySpeedLimit().add(temporarySpeedLimit);
      LOGGER.info("temporarySpeedLimit added: " + temporarySpeedLimit);
    }
    
    trafficIncident.setTrafficIncidentId(trafficIncidentStruct.trafficIncidentId);
    
    if (trafficIncidentStruct.locationInfo.size() == 1) {
      LocationInfo locationInfo = locationInfoDiscriminatedVariantToLocationInfo(trafficIncidentStruct.locationInfo.get(0));
      trafficIncident.setLocationInfo(locationInfo);
    } else if (trafficIncidentStruct.locationInfo.size() == 0) {
      // No action
    } else {
      throw new RuntimeException("Illegal size for locationInfo: " + trafficIncidentStruct.locationInfo.size());
    }
    
    for (String string: trafficIncidentStruct.causeTexts) {
      trafficIncident.getCauseTexts().add(string);
    }

    for (String string: trafficIncidentStruct.applicabilityTexts) {
      trafficIncident.getApplicabilityTexts().add(string);
    }
    
    for (String string: trafficIncidentStruct.adviceTexts) {
      trafficIncident.getAdviceTexts().add(string);
    }
    
    if (trafficIncidentStruct.locationBoundingBox.size() == 1) {
      RectangularArea locationBoundingBox = rectangularAreaStructToRectangularArea(trafficIncidentStruct.locationBoundingBox.get(0));
      trafficIncident.setLocationBoundingBox(locationBoundingBox);
    } else if (trafficIncidentStruct.locationBoundingBox.size() != 0) {
      throw new RuntimeException("Illegal size for locationBoundingBox: " + trafficIncidentStruct.locationBoundingBox.size());
    }
    
    for (Integer categoryId: trafficIncidentStruct.categoryIds) {
      trafficIncident.getCategoryIds().add(categoryId);
    }
    
    return trafficIncident;
  }

  public static TrafficIncidentStruct trafficIncidentToTrafficIncidentStruct(TrafficIncident trafficIncident) {
    Integer trafficIncidentId = trafficIncident.getTrafficIncidentId();
    
    byte effectCodeId = 0;
    EffectCode effectCode = trafficIncident.getEffectCode();
    if (effectCode != null) {
      effectCodeId = (byte) effectCode.getValue();
    }
    
    String effectText;
    if (trafficIncident.getEffectText() != null) {
    effectText = trafficIncident.getEffectText();
    } else {
      effectText = "";
    }
    
    Integer startTime;
    if (trafficIncident.isSetStartTime()) {
      startTime = (int) (trafficIncident.getStartTime().getTime() / (1000 * 60));
    } else {
      startTime = -1;
    }
    
    Integer stopTime;
    if (trafficIncident.getStopTime() != null) {
      stopTime = (int) (trafficIncident.getStopTime().getTime() / (1000 * 60));
    } else {
      stopTime = -1;
    }
    
    Byte tendencyId = 0;
    Tendency tendency = trafficIncident.getTendency();
    if (tendency != null) {
      tendencyId = (Byte) (byte) tendency.getValue();
    }
    
    String tendencyText;
    if (trafficIncident.getTendencyText() != null) {
      tendencyText= trafficIncident.getTendencyText();
    } else {
      tendencyText = "";
    }
    
    int lengthAffected = -1;
    if (trafficIncident.getLengthAffected() != null) {
      lengthAffected =trafficIncident.getLengthAffected();
    }
    
    int averageSpeedAbsolute = -1;
    if (trafficIncident.getAverageSpeedAbsolute() != null) {
      averageSpeedAbsolute = trafficIncident.getAverageSpeedAbsolute();
    }
    
    int delay = -1;
    if (trafficIncident.isSetDelay() &&  trafficIncident.getDelay() != null) {
      delay = trafficIncident.getDelay();
    }
    
    int segmentSpeedLimit = -1;
    if (trafficIncident.getSegmentSpeedLimit() != null) {
      segmentSpeedLimit = trafficIncident.getSegmentSpeedLimit();
    }
    
    int expectedSpeedAbsolute = -1;
    if (trafficIncident.getExpectedSpeedAbsolute() != null) {
    	expectedSpeedAbsolute = trafficIncident.getExpectedSpeedAbsolute();
    }
    
    EList<Cause> causes = trafficIncident.getCauses();
    List<CauseDiscriminatedVariant> causeDiscriminatedVariants = new ArrayList<>();
    for (Cause cause: causes) {
      CauseDiscriminatedVariant causeDiscriminatedVariant = causeToCauseDiscriminatedVariant(cause);
      causeDiscriminatedVariants.add(causeDiscriminatedVariant);
    }
    
    List<LocationDiscriminatedVariant> locationDiscriminatedVariants = new ArrayList<>();
    if (trafficIncident.getLocation() != null) {
      LocationDiscriminatedVariant locationDiscriminatedVariant = locationToLocationDiscriminatedVariant(trafficIncident.getLocation());
      locationDiscriminatedVariants.add(locationDiscriminatedVariant);
    }
    
    EList<Advice> advices = trafficIncident.getAdvices();
    List<AdviceStruct> adviceStructs = new ArrayList<>();
    for (int i = 0; i < advices.size(); i++) {
      AdviceStruct adviceStruct = adviceToAdviceStruct(advices.get(i));
      adviceStructs.add(adviceStruct);
    }
    
    EList<Applicability> applicabilities = trafficIncident.getApplicability();
    List<ApplicabilityStruct> applicabilityStructs = new ArrayList<>();
    for (int i = 0; i < applicabilities.size(); i++) {
      ApplicabilityStruct applicabilityStruct = applicabilityToApplicabilityStruct(applicabilities.get(i));
      applicabilityStructs.add(applicabilityStruct);
    }

    EList<TemporarySpeedLimit> temporarySpeedLimits = trafficIncident.getTemporarySpeedLimit();
    List<TemporarySpeedLimitStruct> temporarySpeedLimitStructs = new ArrayList<>();
    for (int i = 0; i < temporarySpeedLimits.size(); i++) {
      TemporarySpeedLimitStruct temporarySpeedLimitStruct = temporarySpeedLimitToTemporarySpeedLimitStruct(temporarySpeedLimits.get(i));
      temporarySpeedLimitStructs.add(temporarySpeedLimitStruct);
    }
    
    List<LocationInfoDiscriminatedVariant> locationInfoDiscriminatedVariants = new ArrayList<>();
    if (trafficIncident.getLocationInfo() != null) {
      LocationInfoDiscriminatedVariant locationInfoDiscriminatedVariant = locationInfoToLocationInfoDiscriminatedVariant(trafficIncident.getLocationInfo());
      locationInfoDiscriminatedVariants.add(locationInfoDiscriminatedVariant);
    }

    List<String> causeTexts = new ArrayList<>();
    for (String text: trafficIncident.getCauseTexts()) {
      causeTexts.add(text);
    }
    
    List<String> applicabilityTexts = new ArrayList<>();
    for (String text: trafficIncident.getApplicabilityTexts()) {
      applicabilityTexts.add(text);
    }
    
    List<String> adviceTexts = new ArrayList<>();
    for (String text: trafficIncident.getAdviceTexts()) {
      adviceTexts.add(text);
    }
    
    RectangularArea locationBoundingBox = trafficIncident.getLocationBoundingBox();
    List<RectangularAreaStruct> locationBoundingBoxStructs = new ArrayList<>();
    if (locationBoundingBox != null) {
      RectangularAreaStruct locationBoundingBoxStruct = rectangularAreaToRectangularAreaStruct(locationBoundingBox);
      locationBoundingBoxStructs.add(locationBoundingBoxStruct);
    }
    
    List<Integer> categoryIds = new ArrayList<>();
    for (Integer categoryId: trafficIncident.getCategoryIds()) {
      categoryIds.add(categoryId);
    }
    
    TrafficIncidentStruct trafficIncidentStruct = new TrafficIncidentStruct(
        trafficIncidentId,
        effectCodeId,
        effectText,
        startTime, 
        stopTime, 
        tendencyId, 
        tendencyText,
        lengthAffected, 
        averageSpeedAbsolute, 
        delay,
        segmentSpeedLimit,
        expectedSpeedAbsolute,
        causeDiscriminatedVariants,
        locationDiscriminatedVariants,
        adviceStructs,
        applicabilityStructs, 
        temporarySpeedLimitStructs,
        locationInfoDiscriminatedVariants,
        causeTexts,
        applicabilityTexts,
        adviceTexts,
        locationBoundingBoxStructs,
        categoryIds
        );
    
    return trafficIncidentStruct;
  }

  private static Cause causeDiscriminatedVariantToCause(CauseDiscriminatedVariant causeDiscriminatedVariant) {
    CauseType causeType = CauseType.getCauseType(causeDiscriminatedVariant.causeType);
    CauseStruct causeStruct = reconstructCauseStruct(causeType, causeDiscriminatedVariant.cause);
    LOGGER.info("causeStruct =  " + causeStruct);
    Cause cause;
    switch (causeType) {
    case DIRECT:
      LOGGER.info("is DirectCauseStruct");
      DirectCauseStruct directCauseStruct = (DirectCauseStruct) causeStruct;
      cause = directCauseStructToDirectCause(directCauseStruct);
      break;
      
    case LINKED:
      LOGGER.info("is LinkedCauseStruct");
      LinkedCauseStruct linkedCauseStruct = (LinkedCauseStruct) causeStruct;
      cause = linkedCauseStructToLinkedCause(linkedCauseStruct);
      break;
      
    default:
      throw new RuntimeException("Illegal causeType: " + causeType);
    }
    
    return cause;
  }
  
  private static CauseStruct reconstructCauseStruct(CauseType causeType, Variant<?> causeVariant) {
    LOGGER.info("reconstructCauseStruct => causeType = " + causeType + ", causeVariant" + causeVariant);

    Object[] structFields = (Object[]) causeVariant.getValue();
    CauseStruct causeStruct = null;

    Byte mainCause;
    
    switch (causeType) {
    case DIRECT:
      if (!(structFields.length == 8  &&
            structFields[0] instanceof Byte  &&
            structFields[1] instanceof Byte  &&
            structFields[2] instanceof Boolean  &&
            structFields[3] instanceof Byte  &&
            structFields[4] instanceof Integer  &&
            structFields[5] instanceof Integer  &&
            structFields[6] instanceof Vector  &&
            structFields[7] instanceof String)) {
        for (Object structField: structFields) {
          LOGGER.info("reconstructCauseStructs field = " + structField + " = " + structField.getClass().getName());
        }
        throw new RuntimeException("Wrong signature for DirectCause");
      }
      mainCause = (Byte) structFields[0];
      Byte warningLevel = (Byte) structFields[1];
      LOGGER.info("warningLevel OK");
      Boolean unverifiedInformation = (Boolean) structFields[2];
      LOGGER.info("unverifiedInformation OK");
      Byte subCause = (Byte) structFields[3];
      LOGGER.info("subCause OK");
      int lengthAffected = (Integer) structFields[4];
      LOGGER.info("lengthAffected OK");
      int causeOffset = (Integer) structFields[5];
      LOGGER.info("causeOffset OK");
      @SuppressWarnings("unchecked")
      List<LaneRestrictionsStruct> laneRestrictions = reconstructLaneRestrictionsStructs((Vector<Object>) structFields[6]);
      LOGGER.info("LaneRestrictionsStruct OK");
      String freeText = (String) structFields[7];
      LOGGER.info("freeTexts OK");
      causeStruct = new DirectCauseStruct(mainCause, warningLevel, unverifiedInformation,
          subCause, lengthAffected, causeOffset, laneRestrictions, freeText);
      break;
      
    case LINKED:
      if (!(structFields.length == 2  &&
            structFields[0] instanceof Byte  &&
            structFields[1] instanceof Integer)) {
        LOGGER.severe("Wrong signature for LinkedCause");
        for (Object structField: structFields) {
          LOGGER.severe("reconstructCauseStructs field = " + structField + " = " + structField.getClass().getName());
        }
        throw new RuntimeException("Wrong signature for LinkedCause");
      }
      mainCause = (Byte) structFields[0];
      Integer causeTrafficIncidentId = (Integer) structFields[1];
      causeStruct = new LinkedCauseStruct(mainCause, causeTrafficIncidentId);
      break;
    }

    LOGGER.info("reconstructCauseStruct <= " + causeStruct);
    return causeStruct;
  }

  private static CauseDiscriminatedVariant causeToCauseDiscriminatedVariant(Cause cause) {
    CauseType causeType;
    CauseStruct causeStruct;
    
    if (cause instanceof DirectCause) {
      causeType = CauseType.DIRECT;
      causeStruct = directCauseToDirectCauseStruct((DirectCause) cause);
    } else if (cause instanceof LinkedCause) {
      causeType = CauseType.LINKED;
      causeStruct = linkedCauseToLinkedCauseStruct((LinkedCause) cause);      
    } else {
      throw new IllegalArgumentException("Unknow subclass of Cause");
    }
    
    Variant<? extends CauseStruct> causeVariant = new Variant<CauseStruct>(causeStruct);
    return new CauseDiscriminatedVariant(causeType.getValue(), causeVariant);
  }

  private static LinkedCause linkedCauseStructToLinkedCause(LinkedCauseStruct linkedCauseStruct) {
    LinkedCause linkedCause = TRAFFIC_INCIDENT_FACTORY.createLinkedCause();
    
    CauseCode mainCause = CauseCode.get(linkedCauseStruct.mainCause);
    linkedCause.setMainCause(mainCause);
    
    linkedCause.setCauseTrafficIncidentId(linkedCauseStruct.causeTrafficIncidentId);
    
    return linkedCause;
  }
  
  private static LinkedCauseStruct linkedCauseToLinkedCauseStruct(LinkedCause linkedCause) {
    Byte mainCause = (byte) linkedCause.getMainCause().getValue();
    Integer causeTrafficIncidentId = linkedCause.getCauseTrafficIncidentId();
    
    LinkedCauseStruct linkedCauseStruct = new LinkedCauseStruct(mainCause, causeTrafficIncidentId);
    
    return linkedCauseStruct;
  }

  private static DirectCause directCauseStructToDirectCause(DirectCauseStruct directCauseStruct) {
    DirectCause directCause = TRAFFIC_INCIDENT_FACTORY.createDirectCause();

    CauseCode mainCause = CauseCode.get(directCauseStruct.mainCause);
    directCause.setMainCause(mainCause);

    if (directCauseStruct.warningLevel != 0) {
      WarningLevel warningLevel = WarningLevel.get(directCauseStruct.warningLevel);
      directCause.setWarningLevel(warningLevel);
    }

    boolean unverifiedInformation = directCauseStruct.unverifiedInformation;
    directCause.setUnverifiedInformation(unverifiedInformation);

    Byte subCauseValue = directCauseStruct.subCause;

    if (subCauseValue != 0) {
      Object subCause;
      switch (mainCause) {
      case ACCIDENT:
        subCause = Accident.get(subCauseValue);
        break;

      case ANIMALS_ON_ROADWAY:
        subCause = AnimalsOnRoadway.get(subCauseValue);
        break;

      case BROKEN_DOWN_VEHICLES:
        subCause = BrokenDownVehicles.get(subCauseValue);
        break;

      case DANGEROUS_END_OF_QUEUE:
        subCause = DangerousEndOfQueue.get(subCauseValue);
        break;

      case EXTREME_WEATHER_CONDITIONS:
        subCause = ExtremeWeatherConditions.get(subCauseValue);
        break;

      case FIRE:
        subCause = Fire.get(subCauseValue);
        break;

      case HAZARDOUS_DRIVING_CONDITIONS:
        subCause = HazardousDrivingConditions.get(subCauseValue);
        break;

      case IMPASSIBILITY:
        subCause = Impassibility.get(subCauseValue);
        break;

      case MAJOR_EVENT:
        subCause = MajorEvent.get(subCauseValue);
        break;

      case MALFUNCTIONING_ROADSIDE_EQUIPMENT:
        subCause = MalfunctioningRoadsideEquipment.get(subCauseValue);
        break;

      case NARROW_LANES:
        subCause = NarrowLanes.get(subCauseValue);
        break;

      case OBJECTS_ON_THE_ROAD:
        subCause = ObjectsOnTheRoad.get(subCauseValue);
        break;

      case PEOPLE_ON_ROADWAY:
        subCause = PeopleOnRoadway.get(subCauseValue);
        break;

      case POLICE_CHECKPOINT:
        subCause = PoliceCheckpoint.get(subCauseValue);
        break;

      case PRECIPITATION:
        subCause = Precipitation.get(subCauseValue);
        break;

      case RECKLESS_PERSONS:
        subCause = RecklessPersons.get(subCauseValue);
        break;

      case REGULATORY_MEASURE:
        subCause = RegulatoryMeasure.get(subCauseValue);
        break;

      case RESCUE_AND_RECOVERY_WORK_IN_PROGRESS:
        subCause = RescueAndRecoveryWorkInProgress.get(subCauseValue);
        break;

      case RISK_OF_FIRE:
        subCause = RiskOfFire.get(subCauseValue);
        break;

      case ROADWORKS:
        subCause = RoadWorks.get(subCauseValue);
        break;

      case SERVICE_NOT_OPERATING:
        subCause = ServiceNotOperating.get(subCauseValue);
        break;

      case SERVICE_NOT_USEABLE:
        subCause = ServiceNotUsable.get(subCauseValue);
        break;

      case SLIPPERY_ROAD:
        subCause = SlipperyRoad.get(subCauseValue);
        break;

      case SLOW_MOVING_VEHICLES:
        subCause = SlowMovingVehicles.get(subCauseValue);
        break;

      case TIME_DELAY:
        subCause = TimeDelay.get(subCauseValue);
        break;

      case TRAFFIC_CONGESTION:
        subCause = TrafficCongestion.get(subCauseValue);
        break;

      case VISIBILITY_REDUCED:
        subCause = VisibilityReduced.get(subCauseValue);
        break;

      case AQUAPLANING:
      case OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED:
      case TRAFFIC_REGULATIONS_CHANGED:
      case VEHICLE_ON_WRONG_CARRIAGEWAY:
        throw new IllegalArgumentException("Subcause for main cause which doesn't support a subcause");

      default:
        throw new IllegalArgumentException("Unknown mainCause");
      }

      directCause.setSubCause(subCause);
    }

    if (directCauseStruct.lengthAffected != -1) {    
      directCause.setLengthAffected(directCauseStruct.lengthAffected);
    }
    
    if (directCauseStruct.causeOffset != -1) {
      directCause.setCauseOffset(directCauseStruct.causeOffset);
    }

    if (directCauseStruct.laneRestrictions.size() == 1) {
      LaneRestrictions laneRestrictions = laneRestrictionsStructToLaneRestrictions(directCauseStruct.laneRestrictions.get(0));
      directCause.setLaneRestrictions(laneRestrictions);
    } else if (directCauseStruct.laneRestrictions.size() == 0) {
      // no action
    } else {
      throw new RuntimeException("Illegal size of LaneRestrictions list: " + directCauseStruct.laneRestrictions.size());
    }

    if (!directCauseStruct.freeText.isEmpty()) {
      directCause.setFreeText(directCauseStruct.freeText);
    }

    return directCause;
  }
  
  private static DirectCauseStruct directCauseToDirectCauseStruct(DirectCause directCause) {
    Byte mainCause = (byte) directCause.getMainCause().getValue();

    Byte warningLevel = 0;
    if (directCause.getWarningLevel() != null) {
      warningLevel = (byte) directCause.getWarningLevel().getValue();
    }

    Boolean unverifiedInformation = directCause.isUnverifiedInformation();

    Object subCauseObj = directCause.getSubCause();
    int subCauseValue = -1;
    Byte subCause = 0;
    if (subCauseObj != null) {
      switch (directCause.getMainCause()) {
      case ACCIDENT:
        subCauseValue = ((Accident) subCauseObj).getValue();
        break;

      case ANIMALS_ON_ROADWAY:
        subCauseValue = ((AnimalsOnRoadway) subCauseObj).getValue();
        break;

      case BROKEN_DOWN_VEHICLES:
        subCauseValue = ((BrokenDownVehicles) subCauseObj).getValue();
        break;

      case DANGEROUS_END_OF_QUEUE:
        subCauseValue = ((DangerousEndOfQueue) subCauseObj).getValue();
        break;

      case EXTREME_WEATHER_CONDITIONS:
        subCauseValue = ((ExtremeWeatherConditions) subCauseObj).getValue();
        break;

      case FIRE:
        subCauseValue = ((Fire) subCauseObj).getValue();
        break;

      case HAZARDOUS_DRIVING_CONDITIONS:
        subCauseValue = ((HazardousDrivingConditions) subCauseObj).getValue();
        break;

      case IMPASSIBILITY:
        subCauseValue = ((Impassibility) subCauseObj).getValue();
        break;

      case MAJOR_EVENT:
        subCauseValue = ((MajorEvent) subCauseObj).getValue();
        break;

      case MALFUNCTIONING_ROADSIDE_EQUIPMENT:
        subCauseValue = ((MalfunctioningRoadsideEquipment) subCauseObj).getValue();
        break;

      case NARROW_LANES:
        subCauseValue = ((NarrowLanes) subCauseObj).getValue();
        break;

      case OBJECTS_ON_THE_ROAD:
        subCauseValue = ((ObjectsOnTheRoad) subCauseObj).getValue();
        break;

      case PEOPLE_ON_ROADWAY:
        subCauseValue = ((PeopleOnRoadway) subCauseObj).getValue();
        break;

      case POLICE_CHECKPOINT:
        subCauseValue = ((PoliceCheckpoint) subCauseObj).getValue();
        break;

      case PRECIPITATION:
        subCauseValue = ((Precipitation) subCauseObj).getValue();
        break;

      case RECKLESS_PERSONS:
        subCauseValue = ((RecklessPersons) subCauseObj).getValue();
        break;

      case REGULATORY_MEASURE:
        subCauseValue = ((RegulatoryMeasure) subCauseObj).getValue();
        break;

      case RESCUE_AND_RECOVERY_WORK_IN_PROGRESS:
        subCauseValue = ((RescueAndRecoveryWorkInProgress) subCauseObj).getValue();
        break;

      case RISK_OF_FIRE:
        subCauseValue = ((RiskOfFire) subCauseObj).getValue();
        break;

      case ROADWORKS:
        subCauseValue = ((RoadWorks) subCauseObj).getValue();
        break;

      case SERVICE_NOT_OPERATING:
        subCauseValue = ((ServiceNotOperating) subCauseObj).getValue();
        break;

      case SERVICE_NOT_USEABLE:
        subCauseValue = ((ServiceNotUsable) subCauseObj).getValue();
        break;

      case SLIPPERY_ROAD:
        subCauseValue = ((SlipperyRoad) subCauseObj).getValue();
        break;

      case SLOW_MOVING_VEHICLES:
        subCauseValue = ((SlowMovingVehicles) subCauseObj).getValue();
        break;

      case TIME_DELAY:
        subCauseValue = ((TimeDelay) subCauseObj).getValue();
        break;

      case TRAFFIC_CONGESTION:
        subCauseValue = ((TrafficCongestion) subCauseObj).getValue();
        break;

      case VISIBILITY_REDUCED:
        subCauseValue = ((VisibilityReduced) subCauseObj).getValue();
        break;

      case AQUAPLANING:
      case OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED:
      case TRAFFIC_REGULATIONS_CHANGED:
      case VEHICLE_ON_WRONG_CARRIAGEWAY:
        throw new IllegalArgumentException("Subcause for main cause which doesn't support a subcause");

      default:
        throw new IllegalArgumentException("Unknown mainCause");
      }
      subCause = (byte) subCauseValue;
    }

    int lengthAffected = -1;
    if (directCause.getLengthAffected() != null) {
      lengthAffected = directCause.getLengthAffected();
    }
    
    int causeOffset = -1;
    if (directCause.getCauseOffset() != null) {
      causeOffset = directCause.getCauseOffset();
    }

    LaneRestrictions laneRestrictions = directCause.getLaneRestrictions();
    List<LaneRestrictionsStruct> laneRestrictionsStructs = new ArrayList<>();
    if (laneRestrictions != null) {
      LaneRestrictionsStruct laneRestrictionsStruct = laneRestrictionsToLaneRestrictionsStruct(laneRestrictions);
      laneRestrictionsStructs.add(laneRestrictionsStruct);
    }

    String freeText = "";
    if (directCause.isSetFreeText()) {
      freeText = directCause.getFreeText();
    }

    DirectCauseStruct directCauseStruct = new DirectCauseStruct(
        mainCause,
        warningLevel,
        unverifiedInformation,
        subCause,
        lengthAffected,
        causeOffset,
        laneRestrictionsStructs,
        freeText);

    return directCauseStruct;
  }

  private static List<LaneRestrictionsStruct> reconstructLaneRestrictionsStructs(Vector<Object> vector) {
    LOGGER.info("reconstructLaneRestrictionsStructs =>");
    List<LaneRestrictionsStruct> laneRestrictionsStructs = new ArrayList<>();
    
    for (Object object: vector) {
      LOGGER.info("Handling object: " + object + " = " + object.getClass().getName());
      if (object instanceof Object[]) {
        LOGGER.info("Type OK");
        LaneRestrictionsStruct laneRestrictionsStruct = reconstructLaneRestrictionsStruct((Object[]) object);
        laneRestrictionsStructs.add(laneRestrictionsStruct);
      } else {
        LOGGER.info("Wrong Type");
      }
    }
    
    LOGGER.info("reconstructLaneRestrictionsStructs <= " + laneRestrictionsStructs);
    return laneRestrictionsStructs;
  }

  private static LaneRestrictionsStruct reconstructLaneRestrictionsStruct(Object[] objects) {
    LOGGER.info("reconstructLaneRestrictionsStruct =>");
    if (objects.length != 2) {
      LOGGER.info("Wrong number of elements");
      return null;
    }
    
    Byte laneRestrictionType = 0;
    int numberOfLanes = -1;
    
    if (objects[0] instanceof Byte) {
      laneRestrictionType = (Byte) objects[0];
      LOGGER.info("laneRestrictionType OK");
    } else {
      LOGGER.info("Wrong type for laneRestrictionType");
    }
    
    if (objects[1] instanceof Integer) {
      numberOfLanes = (Integer) objects[1];
      LOGGER.info("numberOfLanes OK");
    } else {
      LOGGER.info("Wrong type for numberOfLanes");
    }
    
    LaneRestrictionsStruct laneRestrictionsStruct = new LaneRestrictionsStruct(laneRestrictionType, numberOfLanes);

    LOGGER.info("reconstructLaneRestrictionsStruct <= " + laneRestrictionsStruct);
    return laneRestrictionsStruct;
  }

  private static Location locationDiscriminatedVariantToLocation(LocationDiscriminatedVariant locationDiscriminatedVariant) {
    LocationType locationType = LocationType.getLocationType(locationDiscriminatedVariant.locationType);
    LocationStruct locationStruct = reconstructLocationStruct(locationType, locationDiscriminatedVariant.location);
    LOGGER.info("locationStruct = " + locationStruct);
    
    Location location;
    
    switch (locationType) {
    case POINT:
      LOGGER.info("is PointLocation");
      PointLocationStruct pointLocationStruct = (PointLocationStruct) locationStruct;
      location = pointLocationStructToPointLocation(pointLocationStruct);
      break;
      
    case LINEAR:
      LOGGER.info("is LinearLocation");
      LinearLocationStruct linearLocationStruct = (LinearLocationStruct) locationStruct;
      location = linearLocationStructToLinearLocation(linearLocationStruct);
      break;
      
    case AREA:
      LOGGER.info("is AreaLocation");
      AreaLocationStruct areaLocationStruct = (AreaLocationStruct) locationStruct;
      location = areaLocationStructToAreaLocation(areaLocationStruct);
      break;
      
    default:
      throw new RuntimeException("Illegal locationType: " + locationType);
    }
    
    return location;    
  }

  private static LocationStruct reconstructLocationStruct(LocationType locationType, Variant<?> locationVariant) {
    LOGGER.info("reconstructLocationStruct => locationType = " + locationType + ", locationVariant" + locationVariant);

    Object[] structFields = (Object[]) locationVariant.getValue();
    LocationStruct locationStruct = null;

    
    switch (locationType) {
    case POINT:
      throw new RuntimeException("PointLocation isn't supported");
      
    case LINEAR:
      if (!(structFields.length == 3  &&
            structFields[0] instanceof List<?>  &&
            structFields[1] instanceof UInt32  &&
            structFields[2] instanceof UInt32)) {
        LOGGER.severe("Wrong signature for LinearLocation");
        for (Object structField: structFields) {
          LOGGER.severe("reconstructLocationStruct field = " + structField + " = " + structField.getClass().getName());
        }
        throw new RuntimeException("Wrong signature for LinearLocation");
      }
      LOGGER.info("LinearLocationStruct");
      @SuppressWarnings("unchecked")
      List<Long> segments = (List<Long>) structFields[0];
      LOGGER.fine("parameter 0 OK");
      UInt32 positiveOffset = (UInt32) structFields[1];
      LOGGER.fine("parameter 1 OK");
      UInt32 negativeOffset = (UInt32) structFields[2];
      LOGGER.fine("parameter 2 OK");
      locationStruct = new LinearLocationStruct(segments, positiveOffset, negativeOffset);
      break;
      
    case AREA:
      throw new RuntimeException("AreaLocation isn't supported");
    }

    LOGGER.info("reconstructLocationStruct <= " + locationStruct);
    return locationStruct;
  }

  public static Location locationStructToLocation(LocationStruct locationStruct) {
    Location location = LOCATION_FACTORY.createLocation();
   
    if (locationStruct instanceof PointLocationStruct) {
      location = pointLocationStructToPointLocation((PointLocationStruct) locationStruct);
    } else if (locationStruct instanceof LinearLocationStruct) {
      location = linearLocationStructToLinearLocation((LinearLocationStruct) locationStruct);
    } else if (locationStruct instanceof AreaLocationStruct) {
      location = areaLocationStructToAreaLocation((AreaLocationStruct) locationStruct);
    } else {
      throw new IllegalArgumentException("Unknown subclass of LocationStruct");
    }
    
    return location;
  }

  private static LocationDiscriminatedVariant locationToLocationDiscriminatedVariant(Location location) {
    LocationType locationType;
    LocationStruct locationStruct;
    
    if (location instanceof PointLocation) {
      locationType = LocationType.POINT;
      locationStruct = pointLocationToPointLocationStruct((PointLocation) location);
    } else if (location instanceof LinearLocation) {
      locationType = LocationType.LINEAR;
      locationStruct = linearLocationToLinearLocationStruct((LinearLocation) location);
    } else if (location instanceof AreaLocation) {
      locationType = LocationType.AREA;
      locationStruct = areaLocationToAreaLocationStruct((AreaLocation) location);
    } else {
      throw new IllegalArgumentException("Unknow subclass of Location");
    }
    
    Variant<? extends LocationStruct> locationVariant = new Variant<LocationStruct>(locationStruct);
    return new LocationDiscriminatedVariant(locationType.getValue(), locationVariant);
  }
  
  public static PointLocation pointLocationStructToPointLocation(PointLocationStruct pointLocationStruct) {
    PointLocation pointLocation = LOCATION_FACTORY.createPointLocation();
    
    return pointLocation;
  }
  
  public static PointLocationStruct pointLocationToPointLocationStruct(PointLocation pointLocation) {
    PointLocationStruct pointLocationStruct = new PointLocationStruct();
    
    return pointLocationStruct;
  }
  
  public static LinearLocation linearLocationStructToLinearLocation(LinearLocationStruct linearLocationStruct) {
    LinearLocation linearLocation = LOCATION_FACTORY.createLinearLocation();
    
    for (Long segment: linearLocationStruct.segments) {
      linearLocation.getSegments().add(segment.longValue());
    }
    
    linearLocation.setPositiveOffset(linearLocationStruct.positiveOffset.longValue());

    linearLocation.setNegativeOffset(linearLocationStruct.negativeOffset.longValue());
    
    return linearLocation;
  }
  
  public static LinearLocationStruct linearLocationToLinearLocationStruct(LinearLocation linearLocation) {
    EList<Long> segments = linearLocation.getSegments();
    
    UInt32 positiveOffset = new UInt32(linearLocation.getPositiveOffset());
    
    UInt32 negativeOffset = new UInt32(linearLocation.getNegativeOffset());
    
    LinearLocationStruct linearLocationStruct = new LinearLocationStruct(
        segments, positiveOffset, negativeOffset);
    
    return linearLocationStruct;
  }
  
  public static AreaLocation areaLocationStructToAreaLocation(AreaLocationStruct areaLocationStruct) {
    AreaLocation areaLocation = LOCATION_FACTORY.createAreaLocation();
    
    return areaLocation;
  }
  
  public static AreaLocationStruct areaLocationToAreaLocationStruct(AreaLocation areaLocation) {
    AreaLocationStruct areaLocationStruct = new AreaLocationStruct();
    
    return areaLocationStruct;
  }

  private static LocationInfo locationInfoDiscriminatedVariantToLocationInfo(LocationInfoDiscriminatedVariant locationInfoDiscriminatedVariant) {
    LocationInfoType locationInfoType = LocationInfoType.getLocationInfoType(locationInfoDiscriminatedVariant.locationInfoType);
    LocationInfoStruct locationInfoStruct = reconstructLocationInfoStruct(locationInfoType, locationInfoDiscriminatedVariant.locationInfo);
    LOGGER.info("locationInfoStruct = " + locationInfoStruct);
    
    LocationInfo locationInfo;
    
    switch (locationInfoType) {
    case POINT:
      LOGGER.info("is PointLocationInfo");
      PointLocationInfoStruct pointLocationInfoStruct = (PointLocationInfoStruct) locationInfoStruct;
      locationInfo = pointLocationInfoStructToPointLocationInfo(pointLocationInfoStruct);
      break;
      
    case LINEAR:
      LOGGER.info("is LinearLocationInfo");
      LinearLocationInfoStruct linearLocationInfoStruct = (LinearLocationInfoStruct) locationInfoStruct;
      locationInfo = linearLocationInfoStructToLinearLocationInfo(linearLocationInfoStruct);
      break;
      
    case AREA:
      LOGGER.info("is AreaLocationInfo");
      AreaLocationInfoStruct areaLocationInfoStruct = (AreaLocationInfoStruct) locationInfoStruct;
      locationInfo = areaLocationInfoStructToAreaLocationInfo(areaLocationInfoStruct);
      break;
      
    default:
      throw new RuntimeException("Illegal locationInfoType: " + locationInfoType);
    }
    
    return locationInfo;    
  }

  @SuppressWarnings("unchecked")
  private static LocationInfoStruct reconstructLocationInfoStruct(LocationInfoType locationInfoType, Variant<?> locationInfoVariant) {
    LOGGER.info("reconstructLocationInfoStruct => locationInfoType = " + locationInfoType + ", locationInfoVariant" + locationInfoVariant);

    Object[] structFields = (Object[]) locationInfoVariant.getValue();
    LocationInfoStruct locationInfoStruct = null;
    
    String name;
    List<CoordinateStruct> mainLocationStructs;
    
    if (structFields.length >= 2  &&
        structFields[0] instanceof String  &&
        structFields[1] instanceof Vector) {
      name = (String) structFields[0];
      mainLocationStructs = reconstructCoordinateStructs((Vector<Object>) structFields[1]);
    } else {
      LOGGER.severe("Wrong signature for LocationInfo");
      for (Object structField: structFields) {
        LOGGER.severe("reconstructLocationStruct field = " + structField + " = " + structField.getClass().getName());
      }
      throw new RuntimeException("Wrong signature for LocationInfo");
    }

    switch (locationInfoType) {
    case POINT:
      if (!(structFields.length == 3  &&
            structFields[2] instanceof Integer)) {
        LOGGER.severe("Wrong signature for PointLocationInfo");
        for (Object structField: structFields) {
          LOGGER.severe("reconstructLocationStruct field = " + structField + " = " + structField.getClass().getName());
        }
        throw new RuntimeException("Wrong signature for PointLocationInfo");
      }
      LOGGER.info("PointLocationInfoStruct");
      int locationType = (Integer) structFields[2];
      LOGGER.info("locationType OK");
      locationInfoStruct = new PointLocationInfoStruct(name, mainLocationStructs, locationType);
      break;
      
    case LINEAR:
      if (!(structFields.length == 7  &&
            structFields[2] instanceof String  &&
            structFields[3] instanceof String  &&
            structFields[4] instanceof String  &&
            structFields[5] instanceof String  &&
            structFields[6] instanceof Vector)) {
        LOGGER.severe("Wrong signature for LinearLocationInfo");
        for (Object structField: structFields) {
          LOGGER.severe("reconstructLocationStruct field = " + structField + " = " + structField.getClass().getName());
        }
        throw new RuntimeException("Wrong signature for LinearLocationInfo");
      }
      LOGGER.info("LinearLocationInfoStruct");
      String fromLocationName = (String) structFields[2];
      LOGGER.info("fromLocationName OK");
      String fromLocationParentName = (String) structFields[3];
      LOGGER.info("fromLocationParentName OK");
      String toLocationName = (String) structFields[4];
      LOGGER.info("toLocationName OK");
      String toLocationParentName = (String) structFields[5];
      LOGGER.info("toLocationParentName OK");
      List<CoordinateStruct> coordinates = reconstructCoordinateStructs((Vector<Object>) structFields[6]);
      LOGGER.info("coordinates OK");
      locationInfoStruct = new LinearLocationInfoStruct(name, mainLocationStructs, fromLocationName,
          fromLocationParentName, toLocationName, toLocationParentName, coordinates);
      break;
      
    case AREA:
      if (!(structFields.length == 2)) {
        LOGGER.severe("Wrong signature for AreaLocationInfo");
        for (Object structField: structFields) {
          LOGGER.severe("reconstructLocationStruct field = " + structField + " = " + structField.getClass().getName());
        }
        throw new RuntimeException("Wrong signature for AreaLocationInfo");
      }
      LOGGER.info("AreaLocationInfoStruct");
      locationInfoStruct = new AreaLocationInfoStruct(name, mainLocationStructs);
      break;
    }

    LOGGER.info("reconstructLocationInfoStruct <= " + locationInfoStruct);
    return locationInfoStruct;
  }
  
  public static LocationInfo locationInfoStructToLocationInfo(LocationInfoStruct locationInfoStruct) {
    if (locationInfoStruct instanceof PointLocationInfoStruct) {
      return pointLocationInfoStructToPointLocationInfo((PointLocationInfoStruct) locationInfoStruct);
    } else if (locationInfoStruct instanceof LinearLocationInfoStruct) {
      return linearLocationInfoStructToLinearLocationInfo((LinearLocationInfoStruct) locationInfoStruct);
    } else if (locationInfoStruct instanceof AreaLocationInfoStruct) {
      return areaLocationInfoStructToAreaLocationInfo((AreaLocationInfoStruct) locationInfoStruct);
    } else {
      throw new IllegalArgumentException("Unknow subclass of LocationInfoStruct");
    }
  }
  
  private static LocationInfoDiscriminatedVariant locationInfoToLocationInfoDiscriminatedVariant(LocationInfo locationInfo) {
    LocationInfoType locationInfoType;
    LocationInfoStruct locationInfoStruct;
    
    if (locationInfo instanceof PointLocationInfo) {
      locationInfoType = LocationInfoType.POINT;
      locationInfoStruct = pointLocationInfoToPointLocationInfoStruct((PointLocationInfo) locationInfo);
    } else if (locationInfo instanceof LinearLocationInfo) {
      locationInfoType = LocationInfoType.LINEAR;
      locationInfoStruct = linearLocationInfoToLinearLocationInfoStruct((LinearLocationInfo) locationInfo);
    } else if (locationInfo instanceof AreaLocationInfo) {
      locationInfoType = LocationInfoType.AREA;
      locationInfoStruct = areaLocationInfoToAreaLocationInfoStruct((AreaLocationInfo) locationInfo);
    } else {
      throw new IllegalArgumentException("Unknow subclass of LocationInfo");
    }
    
    Variant<? extends LocationInfoStruct> locationInfoVariant = new Variant<LocationInfoStruct>(locationInfoStruct);
    return new LocationInfoDiscriminatedVariant(locationInfoType.getValue(), locationInfoVariant);
  }
  
  public static PointLocationInfo pointLocationInfoStructToPointLocationInfo(PointLocationInfoStruct pointLocationInfoStruct) {
    PointLocationInfo pointLocationInfo = LOCATION_FACTORY.createPointLocationInfo();
    
    String name = pointLocationInfoStruct.name;
    pointLocationInfo.setName(name);
    
    if (pointLocationInfoStruct.mainLocation.size() == 1) {
      Coordinate mainLocation = coordinateStructToCoordinate(pointLocationInfoStruct.mainLocation.get(0));
      pointLocationInfo.setMainLocation(mainLocation);
    } else if (pointLocationInfoStruct.mainLocation.size() != 0){
      throw new RuntimeException("Illegal size of mainLocation: " + pointLocationInfoStruct.mainLocation.size());
    }
    
    PointLocationType pointLocationType = PointLocationType.get(pointLocationInfoStruct.locationType);
    pointLocationInfo.setLocationType(pointLocationType);
    
    return pointLocationInfo;
  }
  
  public static PointLocationInfoStruct pointLocationInfoToPointLocationInfoStruct(PointLocationInfo pointLocationInfo) {
    String name = pointLocationInfo.getName();
    
    Coordinate mainLocation = pointLocationInfo.getMainLocation();
    List<CoordinateStruct> mainLocationStructs = new ArrayList<>();
    if (mainLocation != null) {
      CoordinateStruct mainLocationStruct = coordinateToCoordinateStruct(mainLocation);
      mainLocationStructs.add(mainLocationStruct);
    }
    
    int locationType = pointLocationInfo.getLocationType().getValue();
    
    PointLocationInfoStruct pointLocationInfoStruct = new PointLocationInfoStruct(
        name, mainLocationStructs, locationType);
    
    return pointLocationInfoStruct;
  }
  
  public static LinearLocationInfo linearLocationInfoStructToLinearLocationInfo(LinearLocationInfoStruct linearLocationInfoStruct) {
    LinearLocationInfo linearLocationInfo = LOCATION_FACTORY.createLinearLocationInfo();
    
    String name = linearLocationInfoStruct.name;
    if (!name.isEmpty()) {
      linearLocationInfo.setName(name);
    }
    
    if (linearLocationInfoStruct.mainLocation.size() == 1) {
      Coordinate mainLocation = coordinateStructToCoordinate(linearLocationInfoStruct.mainLocation.get(0));
      linearLocationInfo.setMainLocation(mainLocation);
    } else if (linearLocationInfoStruct.mainLocation.size() != 0){
      throw new RuntimeException("Illegal size of mainLocation: " + linearLocationInfoStruct.mainLocation.size());
    }
    
    if (!linearLocationInfoStruct.fromLocationName.isEmpty()) {
      linearLocationInfo.setFromLocationName(linearLocationInfoStruct.fromLocationName);
    }
    
    if (!linearLocationInfoStruct.fromLocationParentName.isEmpty()) {
      linearLocationInfo.setFromLocationParentName(linearLocationInfoStruct.fromLocationParentName);
    }
    
    if (!linearLocationInfoStruct.toLocationName.isEmpty()) {
      linearLocationInfo.setToLocationName(linearLocationInfoStruct.toLocationName);
    }
    
    if (!linearLocationInfoStruct.toLocationParentName.isEmpty()) {
      linearLocationInfo.setToLocationParentName(linearLocationInfoStruct.toLocationParentName);
    }
    
    for (CoordinateStruct coordinateStruct: linearLocationInfoStruct.coordinates) {
      Coordinate coordinate = coordinateStructToCoordinate(coordinateStruct);
      linearLocationInfo.getCoordinates().add(coordinate);
    }
    
    return linearLocationInfo;
  }
  
  public static LinearLocationInfoStruct linearLocationInfoToLinearLocationInfoStruct(LinearLocationInfo linearLocationInfo) {
    String name;
    if (linearLocationInfo.getName() != null) {
      name = linearLocationInfo.getName();
    } else {
      name = "";
    }
    
    Coordinate mainLocation = linearLocationInfo.getMainLocation();
    List<CoordinateStruct> mainLocationStructs = new ArrayList<>();
    if (mainLocation != null) {
      CoordinateStruct mainLocationStruct = coordinateToCoordinateStruct(mainLocation);
      mainLocationStructs.add(mainLocationStruct);
    }
    
    String fromLocationName;
    if (linearLocationInfo.getFromLocationName() != null) { 
      fromLocationName = linearLocationInfo.getFromLocationName();
    } else {
      fromLocationName = "";
    }
    
    String fromLocationParentName;
    if (linearLocationInfo.getFromLocationParentName() != null) {
      fromLocationParentName = linearLocationInfo.getFromLocationParentName();
    } else {
      fromLocationParentName = "";
    }
    
    String toLocationName;
    if (linearLocationInfo.getToLocationName() != null) {
      toLocationName = linearLocationInfo.getToLocationName();
    } else {
      toLocationName = "";
    }
    
    String toLocationParentName;
    if (linearLocationInfo.getToLocationParentName() != null) {
      toLocationParentName = linearLocationInfo.getToLocationParentName();
    } else {
      toLocationParentName = "";
    }
    
    EList<Coordinate> coordinates = linearLocationInfo.getCoordinates();
    List<CoordinateStruct> coordinateStructs = new ArrayList<>();
    for (int i = 0; i < coordinates.size(); i++) {
      CoordinateStruct coordinateStruct = coordinateToCoordinateStruct(coordinates.get(i));
      coordinateStructs.add(coordinateStruct);
    }
    
    LinearLocationInfoStruct linearLocationInfoStruct = new LinearLocationInfoStruct(
        name, mainLocationStructs, 
        fromLocationName, fromLocationParentName, 
        toLocationName, toLocationParentName, 
        coordinateStructs);
    
    return linearLocationInfoStruct;
  }

  public static AreaLocationInfo areaLocationInfoStructToAreaLocationInfo(AreaLocationInfoStruct areaLocationInfoStruct) {
    AreaLocationInfo areaLocationInfo = LOCATION_FACTORY.createAreaLocationInfo();
    
    String name = areaLocationInfoStruct.name;
    areaLocationInfo.setName(name);
    
    if (areaLocationInfoStruct.mainLocation.size() == 1) {
      Coordinate mainLocation = coordinateStructToCoordinate(areaLocationInfoStruct.mainLocation.get(0));
      areaLocationInfo.setMainLocation(mainLocation);
    } else if (areaLocationInfoStruct.mainLocation.size() != 0){
      throw new RuntimeException("Illegal size of mainLocation: " + areaLocationInfoStruct.mainLocation.size());
    }
    
    return areaLocationInfo;
  }
  
  public static AreaLocationInfoStruct areaLocationInfoToAreaLocationInfoStruct(AreaLocationInfo areaLocationInfo) {
    String name = areaLocationInfo.getName();
    
    Coordinate mainLocation = areaLocationInfo.getMainLocation();
    List<CoordinateStruct> mainLocationStructs = new ArrayList<>();
    if (mainLocation != null) {
      CoordinateStruct mainLocationStruct = coordinateToCoordinateStruct(mainLocation);
      mainLocationStructs.add(mainLocationStruct);
    }
    
    AreaLocationInfoStruct areaLocationInfoStruct = new AreaLocationInfoStruct(
        name, mainLocationStructs);
    
    return areaLocationInfoStruct;
  }

  private static List<CoordinateStruct> reconstructCoordinateStructs(Vector<Object> vector) {
    LOGGER.info("reconstructCoordinateStructs => " + vector);
    List<CoordinateStruct> coordinateStructs = new ArrayList<>();
    
    for (Object object: vector) {
      if (object instanceof Object[]) {
        CoordinateStruct coordinateStruct = reconstructCoordinateStruct((Object[]) object);
        coordinateStructs.add(coordinateStruct);
      } else {
        LOGGER.severe("Wrong type");
      }
    }
    
    LOGGER.info("reconstructCoordinateStructs <= " + coordinateStructs);
    return coordinateStructs;
  }

  private static CoordinateStruct reconstructCoordinateStruct(Object[] objects) {
    LOGGER.info("reconstructCoordinateStruct => " + objects);
    
    CoordinateStruct coordinateStruct = null;
    
    if (objects.length != 3) {
      LOGGER.info("Wrong number of elements");
      return null;      
    }
    
    Double latitude = null;
    Double longitude = null;
    int altitude = -1;
    
    if (objects[0] instanceof Double) {
      latitude = (Double) objects[0];
      LOGGER.info("latitude OK");
    } else {
      LOGGER.severe("Wrong type for latitude");
    }
    
    if (objects[1] instanceof Double) {
      longitude = (Double) objects[1];
      LOGGER.info("longitude OK");
    } else {
      LOGGER.severe("Wrong type for longitude");
    }
    
    if (objects[2] instanceof Integer) {
      altitude = (Integer) objects[2];
      LOGGER.info("altitude OK");
    } else {
      LOGGER.severe("Wrong type for altitude");
    }
      
    coordinateStruct = new CoordinateStruct(latitude, longitude, altitude);
    
    LOGGER.info("reconstructCoordinateStruct <= " + coordinateStruct);
    return coordinateStruct;
  }

  private static Advice adviceStructToAdvice(AdviceStruct adviceStruct) {
    LOGGER.info("adviceStructToAdvice => adviceStruct = " + adviceStruct);
    Advice advice = TRAFFIC_INCIDENT_FACTORY.createAdvice();
    
    AdviceCode mainAdvice = AdviceCode.get(adviceStruct.mainAdvice);
    advice.setMainAdvice(mainAdvice);
    
    Byte subAdviceValue = adviceStruct.subAdvice;
    if (subAdviceValue != 0) {
      Object subAdviceObj;
      switch (mainAdvice) {
      case DO_NOT_LEAVE_YOUR_VEHICLE:
        subAdviceObj = DoNotLeaveYourVehicle.get(subAdviceValue);
        break;
    
      case DRIVE_CAREFULLY:
        subAdviceObj = DriveCarefully.get(subAdviceValue);
        break;
        
      case DRIVING_NOT_ALLOWED:
        subAdviceObj = DrivingNotAllowed.get(subAdviceValue);
        break;
        
      case FOLLOW_DIVERSION:
        subAdviceObj = FollowDiversion.get(subAdviceValue);
        break;
        
      case GIVING_PATH_VEHICLES_COMING_FROM_BEHIND:
        subAdviceObj = GivingPathVehiclesFromBehind.get(subAdviceValue);
        break;
        
      case OVERTAKING_NOT_ALLOWED:
        subAdviceObj = OvertakingNotAllowed.get(subAdviceValue);
        break;
    
      case USE_TOLL_LANES:
        subAdviceObj = UseTollLanes.get(subAdviceValue);
        break;

      case AVOID_THE_AREA:
      case DO_NOT_DIVERT:
      case DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE:
      case FOLLOW_POLICE_INSTRUCTIONS:
      case NO_DIVERSION_TO_RECOMMEND:
      case SWITCH_ON_RADIO:
      case USE_HARD_SHOULDER_AS_LANE:
      case WAIT_FOR_CONVOI:
      case WAIT_FOR_IMPROVED_WEATHER:
      case WAIT_FOR_POLICE_PATROL:
        throw new IllegalArgumentException("Subadvice for main advice which doesn't support a subadvice");
        
      default:
        throw new IllegalArgumentException("Unknown mainAdvice");
      }
      advice.setSubAdvice(subAdviceObj);
    }
    
    if (!adviceStruct.freeText.isEmpty()) {
      advice.setFreeText(adviceStruct.freeText);
    }
    
    for (ApplicabilityStruct applicabilityStruct: adviceStruct.applicability) {
      Applicability applicability = applicabilityStructToApplicability(applicabilityStruct);
      advice.getApplicability().add(applicability);
    }
    
    LOGGER.info("adviceStructToAdvice <= advice = " + advice);
    return advice;
  }
    
  private static AdviceStruct adviceToAdviceStruct(Advice advice) {
    Byte mainAdvice = (Byte) (byte) advice.getMainAdvice().getValue();

    Object subAdviceObj = advice.getSubAdvice();
    int subAdviceValue = 0;
    if (subAdviceObj != null) {
      switch (advice.getMainAdvice()) {
      case DO_NOT_LEAVE_YOUR_VEHICLE:
        subAdviceValue = ((DoNotLeaveYourVehicle) subAdviceObj).getValue();
        break;

      case DRIVE_CAREFULLY:
        subAdviceValue = ((DriveCarefully) subAdviceObj).getValue();
        break;

      case DRIVING_NOT_ALLOWED:
        subAdviceValue = ((DrivingNotAllowed) subAdviceObj).getValue();
        break;

      case FOLLOW_DIVERSION:
        subAdviceValue = ((FollowDiversion) subAdviceObj).getValue();
        break;

      case GIVING_PATH_VEHICLES_COMING_FROM_BEHIND:
        subAdviceValue = ((GivingPathVehiclesFromBehind) subAdviceObj).getValue();
        break;

      case OVERTAKING_NOT_ALLOWED:
        subAdviceValue = ((OvertakingNotAllowed) subAdviceObj).getValue();
        break;

      case USE_TOLL_LANES:
        subAdviceValue = ((UseTollLanes) subAdviceObj).getValue();
        break;

      case AVOID_THE_AREA:
      case DO_NOT_DIVERT:
      case DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE:
      case FOLLOW_POLICE_INSTRUCTIONS:
      case NO_DIVERSION_TO_RECOMMEND:
      case SWITCH_ON_RADIO:
      case USE_HARD_SHOULDER_AS_LANE:
      case WAIT_FOR_CONVOI:
      case WAIT_FOR_IMPROVED_WEATHER:
      case WAIT_FOR_POLICE_PATROL:
        throw new IllegalArgumentException("Subadvice for main advice which doesn't support a subadvice");

      default:
        throw new IllegalArgumentException("Unknown mainAdvice");
      }
    }
    Byte subAdvice = (Byte) (byte) subAdviceValue;
   
    String freeText = "";
    if (advice.isSetFreeText()) {
      freeText = advice.getFreeText();
    }
    
    EList<Applicability> applicabilities = advice.getApplicability();
    List<ApplicabilityStruct> applicabilityStructs = new ArrayList<>();
    for (int i = 0; i < applicabilities.size(); i++) {
      ApplicabilityStruct applicabilityStruct = applicabilityToApplicabilityStruct(applicabilities.get(i));
      applicabilityStructs.add(applicabilityStruct);
    }
    
    AdviceStruct adviceStruct = new AdviceStruct(
        mainAdvice,
        subAdvice,
        freeText,
        applicabilityStructs);
    
    return adviceStruct;
  }
  
  public static Applicability applicabilityStructToApplicability(ApplicabilityStruct applicabilityStruct) {
    LOGGER.info("applicabilityStructToApplicability() => " + applicabilityStruct);
    Applicability applicability = TRAFFIC_INCIDENT_FACTORY.createApplicability();
    
    if (applicabilityStruct.vehicleType != 0) {
      VehicleType vehicleType = VehicleType.get(applicabilityStruct.vehicleType);
      applicability.setVehicleType(vehicleType);
      LOGGER.info("applicabilityStructToApplicability: vehicleType set to " + vehicleType + " = " + vehicleType.getValue());
    }
    
    for (VehicleRelatedRestrictionStruct vehicleRelatedRestrictionStruct: applicabilityStruct.vehicleRelatedRestrictions) {
      LOGGER.info("applicabilityStructToApplicability: loop for vehicleRelatedRestrictionStruct = " + vehicleRelatedRestrictionStruct);
      VehicleRelatedRestriction vehicleRelatedRestriction = vehicleRelatedRestrictionStructToVehicleRelatedRestriction(vehicleRelatedRestrictionStruct);
      applicability.getVehicleRelatedRestrictions().add(vehicleRelatedRestriction);
      LOGGER.info("applicabilityStructToApplicability: loop: vehicleRelatedRestriction = " + vehicleRelatedRestriction);
    }
    
    LOGGER.info("applicabilityStructToApplicability() <= " + applicability);
    return applicability;
  }
  
  public static ApplicabilityStruct applicabilityToApplicabilityStruct(Applicability applicability) {
    Byte vehicleType = 0;
    if (applicability.getVehicleType() != null) {
      vehicleType = (Byte) (byte) applicability.getVehicleType().getValue();
    }
    
    EList<VehicleRelatedRestriction> vehicleRelatedRestrictions = applicability.getVehicleRelatedRestrictions();
    List<VehicleRelatedRestrictionStruct> vehicleRelatedRestrictionStructs = new ArrayList<>();
    for (int i = 0; i < vehicleRelatedRestrictions.size(); i++) {
      VehicleRelatedRestrictionStruct vehicleRelatedRestrictionStruct = vehicleRelatedRestrictionToVehicleRelatedRestrictionStruct(vehicleRelatedRestrictions.get(i));
      vehicleRelatedRestrictionStructs.add(vehicleRelatedRestrictionStruct);
    }
    
    ApplicabilityStruct applicabilityStruct = new ApplicabilityStruct(
        vehicleType,
        vehicleRelatedRestrictionStructs);
    
    return applicabilityStruct;
  }
  
  public static VehicleRelatedRestriction vehicleRelatedRestrictionStructToVehicleRelatedRestriction(VehicleRelatedRestrictionStruct vehicleRelatedRestrictionStruct) {
    LOGGER.info("vehicleRelatedRestrictionStructToVehicleRelatedRestriction() => " + vehicleRelatedRestrictionStruct);
    VehicleRelatedRestriction vehicleRelatedRestriction = TRAFFIC_INCIDENT_FACTORY.createVehicleRelatedRestriction();
    RestrictionType restrictionType = RestrictionType.get(vehicleRelatedRestrictionStruct.restrictionType);
    vehicleRelatedRestriction.setRestrictionType(restrictionType);
    LOGGER.info("restrictionType = " + restrictionType + " = " + restrictionType.getValue());
    
    if (vehicleRelatedRestrictionStruct.restrictionValue.size() == 1) {
      vehicleRelatedRestriction.setRestrictionValue(vehicleRelatedRestrictionStruct.restrictionValue.get(0));
      LOGGER.info("restrictionValue = " + vehicleRelatedRestriction.getRestrictionValue());
    } else if (vehicleRelatedRestrictionStruct.restrictionValue.size() == 0) {
      LOGGER.info("No restrictionValue");
    } else {
      throw new RuntimeException("Illegal size of restrictionValue: " + vehicleRelatedRestrictionStruct.restrictionValue);
    }
        
    if (vehicleRelatedRestrictionStruct.restrictionLocation.size() == 1) {
      Location restrictionLocation = locationDiscriminatedVariantToLocation(vehicleRelatedRestrictionStruct.restrictionLocation.get(0));
      vehicleRelatedRestriction.setRestrictionLocation(restrictionLocation);
    } else if (vehicleRelatedRestrictionStruct.restrictionLocation.size() == 0) {
      // No action
    } else {
      throw new RuntimeException("Illegal size for restrictionLocation: " + vehicleRelatedRestrictionStruct.restrictionLocation.size());
    }    
    LOGGER.info("RestrictionLocation is handled");
    
    LOGGER.info("vehicleRelatedRestrictionStructToVehicleRelatedRestriction() <= " + vehicleRelatedRestriction);
    return vehicleRelatedRestriction;
  }
  
  public static VehicleRelatedRestrictionStruct vehicleRelatedRestrictionToVehicleRelatedRestrictionStruct(VehicleRelatedRestriction vehicleRelatedRestriction) {
    Byte restrictionType = (Byte) (byte) vehicleRelatedRestriction.getRestrictionType().getValue();

    List<Integer> restrictionValues = new ArrayList<>();
    if (vehicleRelatedRestriction.getRestrictionValue() != null) {
      Integer restrictionValue = vehicleRelatedRestriction.getRestrictionValue();
      restrictionValues.add(restrictionValue);
    }

    List<LocationDiscriminatedVariant> restrictionLocationDiscriminatedVariants = new ArrayList<>();
    if (vehicleRelatedRestriction.getRestrictionLocation() != null) {
      LocationDiscriminatedVariant restrictionLocationDiscriminatedVariant = locationToLocationDiscriminatedVariant(vehicleRelatedRestriction.getRestrictionLocation());
      restrictionLocationDiscriminatedVariants.add(restrictionLocationDiscriminatedVariant);
    }

    VehicleRelatedRestrictionStruct vehicleRelatedRestrictionStruct = new VehicleRelatedRestrictionStruct(
        restrictionType, restrictionValues, restrictionLocationDiscriminatedVariants);

    return vehicleRelatedRestrictionStruct;
  }
  
  public static LaneRestrictions laneRestrictionsStructToLaneRestrictions(LaneRestrictionsStruct laneRestrictionsStruct) {
    LaneRestrictions laneRestrictions = TRAFFIC_INCIDENT_FACTORY.createLaneRestrictions();
    
    if (laneRestrictionsStruct.laneRestrictionType != 0 ) {
      LaneRestrictionType laneRestrictionType = LaneRestrictionType.get(laneRestrictionsStruct.laneRestrictionType);
      laneRestrictions.setLaneRestrictionType(laneRestrictionType);
    }
    
    if (laneRestrictionsStruct.numberOfLanes != -1) {
      laneRestrictions.setNumberOfLanes(laneRestrictionsStruct.numberOfLanes);
    }
    
    return laneRestrictions;
  }
  
  public static LaneRestrictionsStruct laneRestrictionsToLaneRestrictionsStruct(LaneRestrictions laneRestrictions) {
    Byte laneRestrictionType = 0;
    if (laneRestrictions.getLaneRestrictionType() != null) {
      laneRestrictionType = (Byte) (byte) laneRestrictions.getLaneRestrictionType().getValue();
    }
    
    int numberOfLanes = -1;
    if (laneRestrictions.getNumberOfLanes() != null) {
      numberOfLanes= laneRestrictions.getNumberOfLanes();
    }
    
    LaneRestrictionsStruct laneRestrictionsStruct = new LaneRestrictionsStruct(
        laneRestrictionType,
        numberOfLanes);
    
    return laneRestrictionsStruct;
  }

  public static IconSet iconSetStructToIconSet(IconSetStruct iconSetStruct) {
    IconSet iconSet = ICON_SET_FACTORY.createIconSet();
    
    iconSet.setIconSetId(iconSetStruct.iconSetId);
    
    if (iconSetStruct.colorType != 0) {
      ColorType colorType = ColorType.get(iconSetStruct.colorType);
      iconSet.setColorType(colorType);
    }
    
    if (iconSetStruct.dimension != 0) {
      IconDimension dimension = IconDimension.get(iconSetStruct.dimension);
      iconSet.setDimension(dimension);
    }
    
    if (iconSetStruct.size.length != 0) {
      IconSize size = iconSizeStructToIconSize(iconSetStruct.size[0]);
      iconSet.setSize(size);
    }
    
    iconSet.setDayTimeIcon(iconSetStruct.dayTimeIcon);
    
    iconSet.setThemeId(iconSetStruct.themeId);
    
    iconSet.setMediumType(iconSetStruct.mediumType);
    
    for (IconDescriptorStruct iconDescriptorStruct: iconSetStruct.iconDescriptors) {
      IconDescriptor iconDescriptor = iconDescriptorStructToIconDescriptor(iconDescriptorStruct);
      iconSet.getIconDescriptors().add(iconDescriptor);
    }
    
    return iconSet;
  }
  
  public static IconSetStruct iconSetToIconSetStruct(IconSet iconSet) {
    int iconSetId = iconSet.getIconSetId();
    byte colorType = 0;
    if (iconSet.isSetColorType()) {
      colorType = (byte) iconSet.getColorType().getValue();
    }
    byte dimension = 0;
    if (iconSet.isSetDimension()) {
      dimension = (byte) iconSet.getDimension().getValue();
    }
    IconSizeStruct[] iconSizeStruct;
    if (iconSet.isSetSize()) {
      iconSizeStruct = new IconSizeStruct[1];
      iconSizeStruct[0] = iconSizeToIconSizeStruct(iconSet.getSize());
    } else {
      iconSizeStruct = new IconSizeStruct[0];
    }
    Boolean dayTimeIcon = iconSet.isDayTimeIcon();
    int themeId = iconSet.getThemeId();
    String mediumType = iconSet.getMediumType();
    
    EList<IconDescriptor> iconDescriptors = iconSet.getIconDescriptors();
    IconDescriptorStruct[] iconDescriptorStructs = new IconDescriptorStruct[iconDescriptors.size()];
    for (int i = 0; i < iconDescriptors.size(); i++) {
      IconDescriptorStruct iconDescriptorStruct = iconDescriptorToIconDescriptorStruct(iconDescriptors.get(i));
      iconDescriptorStructs[i] = iconDescriptorStruct;
    }
    
    IconSetStruct iconSetStruct = new IconSetStruct(
        iconSetId,
        colorType,
        dimension,
        iconSizeStruct,
        dayTimeIcon,
        themeId,
        mediumType,
        iconDescriptorStructs);
    
    return iconSetStruct;
  }

  public static IconDescriptor iconDescriptorStructToIconDescriptor(IconDescriptorStruct iconDescriptorStruct) {
    IconDescriptor iconDescriptor = ICON_SET_FACTORY.createIconDescriptor();
    
    if (!iconDescriptorStruct.url.isEmpty()) {
      iconDescriptor.setUrl(iconDescriptorStruct.url);
    }
    iconDescriptor.setIconId(iconDescriptorStruct.iconId);
    
    return iconDescriptor;
  }
  
  public static IconDescriptorStruct iconDescriptorToIconDescriptorStruct(IconDescriptor iconDescriptor) {
    String url = iconDescriptor.getUrl();
    if (url == null) {
      url = "";
    }
    int iconId = iconDescriptor.getIconId();
    
    IconDescriptorStruct iconDescriptorStruct = new IconDescriptorStruct(url, iconId);
    
    return iconDescriptorStruct;
  }

  public static IconSize iconSizeStructToIconSize(IconSizeStruct sizeStruct) {
    IconSize iconSize = ICON_SET_FACTORY.createIconSize();
    
    iconSize.setWidth(sizeStruct.width);
    iconSize.setHeight(sizeStruct.height);
    iconSize.setDpi(sizeStruct.dpi);
    
    return iconSize;
  }
  
  public static IconSizeStruct iconSizeToIconSizeStruct(IconSize iconSize) {
    int width = iconSize.getWidth();
    int height = iconSize.getHeight();
    int dpi = iconSize.getDpi();
    
    IconSizeStruct iconSizeStruct = new IconSizeStruct(width, height, dpi);
    
    return iconSizeStruct;
  }

  public static IconDefinition iconDefinitionStructToIconDefinition(IconDefinitionStruct iconDefinitionStruct) {
    IconDefinition iconDefinition = ICON_SET_FACTORY.createIconDefinition();
    
    IconInfo iconInfo = iconInfoStructToIconInfo(iconDefinitionStruct.iconInfo);
    iconDefinition.setIconInfo(iconInfo);
    
    IconData iconData = iconDataStructToIconData(iconDefinitionStruct.iconData);
    iconDefinition.setIconData(iconData);
    
    return iconDefinition;
  }
  
  public static IconDefinitionStruct iconDefinitionToIconDefinitionStruct(IconDefinition iconDefinition) {
    IconInfoStruct iconInfoStruct = iconInfoToIconInfoStruct(iconDefinition.getIconInfo());
    IconDataStruct iconDataStruct = iconDataToIconDataStruct(iconDefinition.getIconData());
    
    IconDefinitionStruct iconDefinitionStruct = new IconDefinitionStruct(iconInfoStruct, iconDataStruct);
    
    return iconDefinitionStruct;
  }

  public static IconData iconDataStructToIconData(IconDataStruct iconDataStruct) {
    IconData iconData = ICON_SET_FACTORY.createIconData();
    
    iconData.setData(iconDataStruct.data);
    
    return iconData;
  }
  
  public static IconDataStruct iconDataToIconDataStruct(IconData iconData) {
    IconDataStruct iconDataStruct = new IconDataStruct(iconData.getData());
    
    return iconDataStruct;
  }

  public static IconInfo iconInfoStructToIconInfo(IconInfoStruct iconInfoStruct) {
    IconInfo iconInfo = ICON_SET_FACTORY.createIconInfo();
    
    iconInfo.setIconSetId(iconInfoStruct.iconSetId);
    iconInfo.setIconId(iconInfoStruct.iconId);
    
    return iconInfo;
  }
  
  public static IconInfoStruct iconInfoToIconInfoStruct(IconInfo iconInfo) {
    int iconSetId = iconInfo.getIconSetId();
    int iconId = iconInfo.getIconId();
    
    IconInfoStruct iconInfoStruct = new IconInfoStruct(iconSetId, iconId);
    
    return iconInfoStruct;
  }

  public static CategoryDefinition categoryDefinitionStructToCategoryDefinition(CategoryDefinitionStruct categoryDefinitionStruct) {
    CategoryDefinition categoryDefinition = TRAFFIC_INCIDENTS_SVC_FACTORY.createCategoryDefinition();

    List<LocalizedStringStruct> localizedNamesStructs = categoryDefinitionStruct.localizedNames;
    LocalizedString[] localizedNames = new LocalizedString[localizedNamesStructs.size()];
    for (int i = 0; i < localizedNamesStructs.size(); i++) {
      LocalizedStringStruct localizedStringStruct = localizedNamesStructs.get(i);
      LocalizedString localizedString = localizedStringStructToLocalizedString(localizedStringStruct);
      localizedNames[i] = localizedString;
    }
    categoryDefinition.setLocalizedNames(localizedNames);
    
    categoryDefinition.setCategoryId(categoryDefinitionStruct.categoryId);
    List<IconInfoStruct> iconStructs = categoryDefinitionStruct.icons;
    IconInfo[] icons = new IconInfo[iconStructs.size()];
    for (int i = 0; i < iconStructs.size(); i++) {
      IconInfoStruct iconInfoStruct = iconStructs.get(i);
      IconInfo iconInfo = iconInfoStructToIconInfo(iconInfoStruct);
      icons[i] = iconInfo;
    }
    categoryDefinition.setIcons(icons);
    
    categoryDefinition.setExpression(categoryDefinitionStruct.expression);
    
    return categoryDefinition;
  }
  
  public static CategoryDefinitionStruct categoryDefinitionToCategoryDefinitionStruct(CategoryDefinition categoryDefinition) {
    LocalizedString[] localizedNames = categoryDefinition.getLocalizedNames();
    List<LocalizedStringStruct> localizedNameStructs = new ArrayList<>();
    for (int i = 0; i < localizedNames.length; i++) {
      LocalizedStringStruct localizedStringStruct = localizedStringToLocalizedStringStruct(localizedNames[i]);
      localizedNameStructs.add(localizedStringStruct);
    }
    
    int categoryId = categoryDefinition.getCategoryId();
    
    IconInfo[] icons = categoryDefinition.getIcons();
    List<IconInfoStruct> iconInfoStructs = new ArrayList<>();
    for (int i = 0; i < icons.length; i++) {
      IconInfoStruct iconInfoStruct = iconInfoToIconInfoStruct(icons[i]);
      iconInfoStructs.add(iconInfoStruct);
    }
    
    String expression = categoryDefinition.getExpression();
    
    CategoryDefinitionStruct categoryDefinitionStruct = new CategoryDefinitionStruct(
        localizedNameStructs, categoryId, iconInfoStructs, expression);
    
    return categoryDefinitionStruct;
  }
  
  public static Coordinate coordinateStructToCoordinate(CoordinateStruct coordinateStruct) {
    Coordinate coordinate = COMMON_FACTORY.createCoordinate();
    
    coordinate.setLatitude(coordinateStruct.latitude);
    coordinate.setLongitude(coordinateStruct.longitude);
    coordinate.setAltitude(coordinateStruct.altitude);
    
    return coordinate;
  }
  
  public static CoordinateStruct coordinateToCoordinateStruct(Coordinate coordinate) {
    Double latitude = coordinate.getLatitude();
    Double longitude = coordinate.getLongitude();
    int altitude = coordinate.getAltitude();
    
    CoordinateStruct coordinateStruct = new CoordinateStruct(
        latitude, longitude, altitude);
    
    return coordinateStruct;
  }

  public static RectangularArea rectangularAreaStructToRectangularArea(RectangularAreaStruct rectangularAreastruct) {
    RectangularArea rectangularArea = COMMON_FACTORY.createRectangularArea();
    
    Coordinate bottomLeft = coordinateStructToCoordinate(rectangularAreastruct.bottomLeft);
    rectangularArea.setBottomLeft(bottomLeft);
    
    Coordinate topRight = coordinateStructToCoordinate(rectangularAreastruct.topRight);
    rectangularArea.setTopRight(topRight);
    
    return rectangularArea;
  }
  
  public static RectangularAreaStruct rectangularAreaToRectangularAreaStruct(RectangularArea rectangularArea) {
    CoordinateStruct bottomLeft = coordinateToCoordinateStruct(rectangularArea.getBottomLeft());
    CoordinateStruct topRight = coordinateToCoordinateStruct(rectangularArea.getTopRight());
    
    RectangularAreaStruct rectangularAreaStruct = new RectangularAreaStruct(
        bottomLeft, topRight);
    
    return rectangularAreaStruct;
  }
  
  public static LocalizedString localizedStringStructToLocalizedString(LocalizedStringStruct localizedStringStruct) {
    LocalizedString localizedString = COMMON_FACTORY.createLocalizedString();
    
    localizedString.setLanguageCode(localizedStringStruct.languageCode);
    if (!localizedStringStruct.countryCode.isEmpty()) {
      localizedString.setCountryCode(localizedStringStruct.countryCode);
    }
    localizedString.setString(localizedStringStruct.string);
    
    return localizedString;
  }
  
  public static LocalizedStringStruct localizedStringToLocalizedStringStruct(LocalizedString localizedString) {
    String languageCode = localizedString.getLanguageCode();
    if (languageCode == null) {
      throw new IllegalArgumentException("languageCode may not be null");
    }
    String countryCode = localizedString.getCountryCode();
    if (countryCode == null) {
      countryCode = "";
    }
    String string = localizedString.getString();
    if (string == null) {
      throw new IllegalArgumentException("string may not be null");
    }
    
    LocalizedStringStruct localizedStringStruct = new LocalizedStringStruct(
        languageCode, countryCode, string);
    
    return localizedStringStruct;
  }
  
  public static FeedInformation feedInformationStructToFeedInformation(FeedInformationStruct feedInformationStruct) {
    FeedInformation feedInformation = TRAFFIC_INCIDENTS_SVC_FACTORY.createFeedInformation();
    
    if (!feedInformationStruct.dataProviderName.isEmpty()) {
      feedInformation.setDataProviderName(feedInformationStruct.dataProviderName);
    }
    
    if (!feedInformationStruct.protocolName.isEmpty()) {
      feedInformation.setProtocolName(feedInformationStruct.protocolName);
    }
    
    if (!feedInformationStruct.communicationChannelName.isEmpty()) {
      feedInformation.setCommunicationChannelName(feedInformationStruct.communicationChannelName);
    }
    
    if (feedInformationStruct.feedStatus != 0) {
      TrafficIncidentFeedStatus trafficIncidentFeedStatus = TrafficIncidentFeedStatus.get(feedInformationStruct.feedStatus);
      feedInformation.setFeedStatus(trafficIncidentFeedStatus);
    }

    if (feedInformationStruct.trafficIncidentsStatus != 0) {
      TrafficIncidentsStatus trafficIncidentsStatus = TrafficIncidentsStatus.get(feedInformationStruct.trafficIncidentsStatus);
      feedInformation.setTrafficIncidentsStatus(trafficIncidentsStatus);
    }

    return feedInformation;
  }
  
  public static FeedInformationStruct feedInformationToFeedInformationStruct(FeedInformation feedInformation) {
    String dataProviderName = feedInformation.getDataProviderName();
    if (dataProviderName == null) {
      dataProviderName = "";
    }
    
    String protocolName = feedInformation.getProtocolName();
    if (protocolName == null) {
      protocolName = "";
    }
    
    String communicationChannelName = feedInformation.getCommunicationChannelName();
    if (communicationChannelName == null) {
      communicationChannelName = "";
    }
    
    TrafficIncidentFeedStatus feedStatus = feedInformation.getFeedStatus();
    Byte feedStatusId;
    if (feedStatus != null) {
      feedStatusId = (Byte) (byte) feedStatus.getValue();
    } else {
      feedStatusId = 0;
    }
    
    TrafficIncidentsStatus trafficIncidentsStatus = feedInformation.getTrafficIncidentsStatus();
    Byte trafficIncidentsStatusId;
    if (trafficIncidentsStatus != null) {
      trafficIncidentsStatusId = (Byte) (byte) trafficIncidentsStatus.getValue();
    } else {
      trafficIncidentsStatusId = 0;
    }
    
    FeedInformationStruct feedInformationStruct = new FeedInformationStruct(
        dataProviderName, protocolName, communicationChannelName,
        feedStatusId, trafficIncidentsStatusId);
    
    return feedInformationStruct;
  }

  private static TemporarySpeedLimit temporarySpeedLimitStructToTemporarySpeedLimit(TemporarySpeedLimitStruct temporarySpeedLimitStruct) {
    LOGGER.info("temporarySpeedLimitStructToTemporarySpeedLimit() => " + temporarySpeedLimitStruct);
    TemporarySpeedLimit temporarySpeedLimit = TRAFFIC_INCIDENT_FACTORY.createTemporarySpeedLimit();

    temporarySpeedLimit.setUnitsMPH(temporarySpeedLimitStruct.unitsMPH);

    if (temporarySpeedLimitStruct.offset != -1) {
      temporarySpeedLimit.setOffset(temporarySpeedLimitStruct.offset);
    }

    for (TemporarySpeedLimitSectionStruct temporarySpeedLimitSectionStruct: temporarySpeedLimitStruct.temporarySpeedLimitSections) {
      TemporarySpeedLimitSection temporarySpeedLimitSection = temporarySpeedLimitSectionStructToTemporarySpeedLimitSection(temporarySpeedLimitSectionStruct);
      temporarySpeedLimit.getTemporarySpeedLimitSections().add(temporarySpeedLimitSection);
    }

    for (ApplicabilityStruct applicabilityStruct: temporarySpeedLimitStruct.applicability) {
      Applicability applicability = applicabilityStructToApplicability(applicabilityStruct);
      temporarySpeedLimit.getApplicability().add(applicability);
    }

    LOGGER.info("temporarySpeedLimitStructToTemporarySpeedLimit() <= " + temporarySpeedLimit);
    return temporarySpeedLimit;
  }

  private static TemporarySpeedLimitStruct temporarySpeedLimitToTemporarySpeedLimitStruct(TemporarySpeedLimit temporarySpeedLimit) {
    Boolean unitsMPH = temporarySpeedLimit.isUnitsMPH();

    Integer offset = -1;
    if (temporarySpeedLimit.isSetOffset()) {
      offset = temporarySpeedLimit.getOffset();
    }

    EList<TemporarySpeedLimitSection> temporarySpeedLimitSections = temporarySpeedLimit.getTemporarySpeedLimitSections();
    List<TemporarySpeedLimitSectionStruct> temporarySpeedLimitSectionStructs = new ArrayList<>();
    for (int i = 0; i < temporarySpeedLimitSections.size(); i++) {
      TemporarySpeedLimitSectionStruct temporarySpeedLimitSectionStruct = temporarySpeedLimitSectionToTemporarySpeedLimitSectionStruct(temporarySpeedLimitSections.get(i));
      temporarySpeedLimitSectionStructs.add(temporarySpeedLimitSectionStruct);
    }

    EList<Applicability> applicabilities = temporarySpeedLimit.getApplicability();
    List<ApplicabilityStruct> applicabilityStructs = new ArrayList<>();
    for (int i = 0; i < applicabilities.size(); i++) {
      ApplicabilityStruct applicabilityStruct = applicabilityToApplicabilityStruct(applicabilities.get(i));
      applicabilityStructs.add(applicabilityStruct);
    }

    TemporarySpeedLimitStruct temporarySpeedLimitStruct = new TemporarySpeedLimitStruct(
        unitsMPH, 
        offset,
        temporarySpeedLimitSectionStructs,
        applicabilityStructs
        );

    return temporarySpeedLimitStruct;
  }

  private static TemporarySpeedLimitSection temporarySpeedLimitSectionStructToTemporarySpeedLimitSection(TemporarySpeedLimitSectionStruct temporarySpeedLimitSectionStruct) {
    TemporarySpeedLimitSection temporarySpeedLimitSection = TRAFFIC_INCIDENT_FACTORY.createTemporarySpeedLimitSection();

    if (temporarySpeedLimitSectionStruct.speedLimitValue != -1) {
      temporarySpeedLimitSection.setSpeedLimitValue(temporarySpeedLimitSectionStruct.speedLimitValue);
    }

    if (temporarySpeedLimitSectionStruct.speedLimitValueWet != -1) {
      temporarySpeedLimitSection.setSpeedLimitValueWet(temporarySpeedLimitSectionStruct.speedLimitValueWet);
    }

    if (temporarySpeedLimitSectionStruct.speedLimitLength != -1) {
      temporarySpeedLimitSection.setSpeedLimitLength(temporarySpeedLimitSectionStruct.speedLimitLength);
    }

    return temporarySpeedLimitSection;
  }

  private static TemporarySpeedLimitSectionStruct temporarySpeedLimitSectionToTemporarySpeedLimitSectionStruct(TemporarySpeedLimitSection temporarySpeedLimitSection) {
    Short speedLimitValue = -1;
    if (temporarySpeedLimitSection.isSetSpeedLimitValue()) {
      speedLimitValue = temporarySpeedLimitSection.getSpeedLimitValue();
    }

    Short speedLimitValueWet = -1;
    if (temporarySpeedLimitSection.isSetSpeedLimitValueWet()) {
      speedLimitValueWet = temporarySpeedLimitSection.getSpeedLimitValueWet();
    }

    Integer speedLimitLength = -1;
    if (temporarySpeedLimitSection.isSetSpeedLimitLength()) {
      speedLimitLength = temporarySpeedLimitSection.getSpeedLimitLength();
    }

    TemporarySpeedLimitSectionStruct temporarySpeedLimitSectionStruct = new TemporarySpeedLimitSectionStruct(
        speedLimitValue,
        speedLimitValueWet,
        speedLimitLength
        );

    return temporarySpeedLimitSectionStruct;
  }
}
