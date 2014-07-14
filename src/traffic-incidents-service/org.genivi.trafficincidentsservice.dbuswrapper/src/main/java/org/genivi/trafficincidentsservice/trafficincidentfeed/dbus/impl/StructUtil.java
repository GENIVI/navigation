/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.freedesktop.dbus.UInt16;
import org.freedesktop.dbus.Variant;
import org.genivi.common.CommonFactory;
import org.genivi.common.LocalizedString;
import org.genivi.common.Version;
import org.genivi.locref.LocationReference;
import org.genivi.locref.locrefFactory;
import org.genivi.trafficincidentsservice.FeedInformation;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.trafficincidentsserviceFactory;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.AdviceStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.ApplicabilityStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.CauseDiscriminatedVariant;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.CauseStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.CauseType;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.DirectCauseStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.LaneRestrictionsStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.LinkedCauseStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.LocalizedStringStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.LocationReferenceStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.TemporarySpeedLimitSectionStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.TemporarySpeedLimitStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.TrafficIncidentStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.VehicleRelatedRestrictionStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.VersionStruct;
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
import org.genivi.trafficincidentsservice.trafficincidents.dbus.FeedInformationStruct;
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
  private final static locrefFactory LOCATION_REFERENCE_FACTORY = locrefFactory.eINSTANCE;
  private final static XTrafficIncidentFactory TRAFFIC_INCIDENT_FACTORY = XTrafficIncidentFactory.eINSTANCE;
  private final static trafficincidentsserviceFactory TRAFFIC_INCIDENTS_SVC_FACTORY = trafficincidentsserviceFactory.eINSTANCE;
  
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
    LOGGER.info("=>");
    UInt16 major = new UInt16(version.getMajor());
    UInt16 minor = new UInt16(version.getMinor());
    UInt16 micro = new UInt16(version.getMicro());
    
    VersionStruct versionStruct = new VersionStruct(major, minor, micro, version.getDate());
    
    LOGGER.info("<= " + versionStruct);
    return versionStruct;
  }

  public static TrafficIncident trafficIncidentStructToTrafficIncident(TrafficIncidentStruct trafficIncidentStruct) {
    LOGGER.info("trafficIncidentStructToTrafficIncident =>");
    TrafficIncident trafficIncident = TRAFFIC_INCIDENT_FACTORY.createTrafficIncident();
    
    if (trafficIncidentStruct.effectCode != 0) {
      EffectCode effectCode = EffectCode.get(trafficIncidentStruct.effectCode);
      trafficIncident.setEffectCode(effectCode);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: effectCode set: " + trafficIncident.getEffectCode());
    }
    LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: effectCode handled OK");
    
    long startTimeValue = trafficIncidentStruct.startTime;
    if (startTimeValue != -1) {
      Date startTime = new Date(startTimeValue * 1000 * 60);
      trafficIncident.setStartTime(startTime);
      LOGGER.info("startTimeValue = " + startTimeValue);
      LOGGER.info("startTimeValue * 1000 * 60 = " + startTimeValue * 1000 * 60);
      LOGGER.info("trafficIncidentStruct.startTime * 1000 * 60 = " + trafficIncidentStruct.startTime * 1000 * 60);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: startTime set: " + trafficIncident.getStartTime());
    }
    
    long stopTimeValue = trafficIncidentStruct.stopTime;
    if (stopTimeValue != -1) {
      Date stopTime = new Date(stopTimeValue * 1000 * 60);
      trafficIncident.setStopTime(stopTime);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: stopTime set: " + trafficIncident.getStopTime());
    }
    
    if (trafficIncidentStruct.tendency != 0) {
      Tendency tendency = Tendency.get(trafficIncidentStruct.tendency);
      trafficIncident.setTendency(tendency);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: tendency set: " + trafficIncident.getTendency());
    }

    if (trafficIncidentStruct.lengthAffected != -1) {
      trafficIncident.setLengthAffected(trafficIncidentStruct.lengthAffected);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: lengthAffected set: " + trafficIncident.getLengthAffected());
    }
    
    if (trafficIncidentStruct.averageSpeedAbsolute != -1) {
      trafficIncident.setAverageSpeedAbsolute(trafficIncidentStruct.averageSpeedAbsolute);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: averageSpeedAbsolute set: " + trafficIncident.getAverageSpeedAbsolute());
    }
    
    if (trafficIncidentStruct.delay != -1) {
      trafficIncident.setDelay(trafficIncidentStruct.delay);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: delay set: " + trafficIncident.getDelay());
    }
    
    if (trafficIncidentStruct.segmentSpeedLimit != -1) {
      trafficIncident.setSegmentSpeedLimit(trafficIncidentStruct.segmentSpeedLimit);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: segmentSpeedLimit set: " + trafficIncident.getSegmentSpeedLimit());
    }
    
    if (trafficIncidentStruct.expectedSpeedAbsolute != -1) {
      trafficIncident.setExpectedSpeedAbsolute(trafficIncidentStruct.expectedSpeedAbsolute);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: expectedSpeedAbsolute set: " + trafficIncident.getExpectedSpeedAbsolute());
    }
    
    for (CauseDiscriminatedVariant causeDiscriminatedVariant: trafficIncidentStruct.causes) {
      Cause cause = causeDiscriminatedVariantToCause(causeDiscriminatedVariant);
      trafficIncident.getCauses().add(cause);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: cause added: " + cause);
    }
    
    LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: number of advices = " + trafficIncidentStruct.advices.size());
    for (AdviceStruct adviceUpdateStruct: trafficIncidentStruct.advices) {
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: loop start");
      Advice advice = adviceStructToAdvice(adviceUpdateStruct);
      trafficIncident.getAdvices().add(advice);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: advice added: " + advice);
    }
    
    for (ApplicabilityStruct applicabilityStruct: trafficIncidentStruct.applicability) {
      Applicability applicability = applicabilityStructToApplicability(applicabilityStruct);
      trafficIncident.getApplicability().add(applicability);
      LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: applicability added: " + applicability);
    }
    
    for (TemporarySpeedLimitStruct temporarySpeedLimitStruct: trafficIncidentStruct.temporarySpeedLimits) {
      TemporarySpeedLimit temporarySpeedLimit = temporarySpeedLimitStructToTemporarySpeedLimit(temporarySpeedLimitStruct);
      trafficIncident.getTemporarySpeedLimit().add(temporarySpeedLimit);
      LOGGER.info("temporarySpeedLimit added: " + temporarySpeedLimit);
    }
        
    trafficIncident.setTrafficIncidentId(trafficIncidentStruct.trafficIncidentId);
    
    long expirationTimeValue = trafficIncidentStruct.expirationTime;
    if (expirationTimeValue != -1) {
      Date expirationTime = new Date(expirationTimeValue * 1000 * 60);
      trafficIncident.setExpirationTime(expirationTime);
    }
    LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: expirationTime handled OK");
    
    long updateTimeValue = trafficIncidentStruct.updateTime;
    if (updateTimeValue != -1) {
      Date updateTime = new Date(updateTimeValue * 1000 * 60);
      trafficIncident.setUpdateTime(updateTime);
    }
    LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: updateTime handled OK");

    LocationReference locationReference = locationReferenceStructToLocationReference(trafficIncidentStruct.locationReference);
    trafficIncident.setLocationReference(locationReference);
    LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident: locationReference handled OK");
    
    LOGGER.info("managedTrafficIncidentStructToManagedTrafficIncident <=");
    return trafficIncident;
  }

  public static TrafficIncidentStruct trafficIncidentToTrafficIncidentStruct(
      TrafficIncident trafficIncident) {
    
    byte effectCodeId = 0;
    EffectCode effectCode = trafficIncident.getEffectCode();
    if (effectCode != null) {
      effectCodeId = (byte) effectCode.getValue();
    }
    
    Integer startTime;
    if (trafficIncident.isSetStartTime()) {
      LOGGER.info("Start date = " + trafficIncident.getStartTime());
      LOGGER.info("Start date.time = " + trafficIncident.getStartTime().getTime());
      startTime = (int) (trafficIncident.getStartTime().getTime() / (1000 * 60));
      LOGGER.info("Start struct = " + startTime);
    } else {
      startTime = -1;
    }
    
    Integer stopTime;
    if (trafficIncident.isSetStopTime()) {
      stopTime = (int) (trafficIncident.getStopTime().getTime() / (1000 * 60));
    } else {
      stopTime = -1;
    }
    
    Byte tendencyId = 0;
    Tendency tendency = trafficIncident.getTendency();
    if (tendency != null) {
      tendencyId = (Byte) (byte) tendency.getValue();
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
    if (trafficIncident.isSetDelay()  &&  trafficIncident.getDelay() != null) {
      Integer integerDelay = trafficIncident.getDelay();
      if (integerDelay != null) {
        delay = integerDelay;
      }
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
    
    String trafficIncidentManagementId = trafficIncident.getTrafficIncidentId();
    
    Integer expirationTime;
    if (trafficIncident.isSetExpirationTime()  && trafficIncident.getExpirationTime() != null) {
      expirationTime = (int) (trafficIncident.getExpirationTime().getTime() / (1000 * 60));
    } else {
      expirationTime = -1;
    }
    
    Integer updateTime;
    if (trafficIncident.isSetUpdateTime()) {
      updateTime = (int) (trafficIncident.getUpdateTime().getTime() / (1000 * 60));
    } else {
      updateTime = -1;
    }
    
    LocationReferenceStruct locationReferenceStruct = locationReferenceToLocationReferenceStruct(trafficIncident.getLocationReference());

    
    TrafficIncidentStruct trafficIncidentStruct = new TrafficIncidentStruct(
        trafficIncidentManagementId,
        effectCodeId,
        startTime, 
        stopTime, 
        tendencyId, 
        lengthAffected, 
        averageSpeedAbsolute, 
        delay,
        segmentSpeedLimit,
        expectedSpeedAbsolute,
        causeDiscriminatedVariants,
        adviceStructs,
        applicabilityStructs, 
        temporarySpeedLimitStructs,
        expirationTime,
        updateTime,
        locationReferenceStruct
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
            structFields[7] instanceof Vector)) {
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
      LOGGER.info("causeCode OK");
      @SuppressWarnings("unchecked")
      List<LaneRestrictionsStruct> laneRestrictions = reconstructLaneRestrictionsStructs((Vector<Object>) structFields[6]);
      LOGGER.info("LaneRestrictionsStruct OK");
      @SuppressWarnings("unchecked")
      List<LocalizedStringStruct> freeTexts = reconstructLocalizedStringStructs((Vector<Object>) structFields[7]);
      LOGGER.info("freeTexts OK");
      causeStruct = new DirectCauseStruct(mainCause, warningLevel, unverifiedInformation,
          subCause, lengthAffected, causeOffset, laneRestrictions, freeTexts);
      break;
      
    case LINKED:
      if (!(structFields.length == 2  &&
            structFields[0] instanceof Byte  &&
            structFields[1] instanceof String)) {
        LOGGER.severe("Wrong signature for LinkedCause");
        for (Object structField: structFields) {
          LOGGER.severe("reconstructCauseStructs field = " + structField + " = " + structField.getClass().getName());
        }
        throw new RuntimeException("Wrong signature for LinkedCause");
      }
      mainCause = (Byte) structFields[0];
      String causeTrafficIncidentId = (String) structFields[1];
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
    String causeTrafficIncidentId = linkedCause.getCauseTrafficIncidentId();
    
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

    for (LocalizedStringStruct localizedStringStruct: directCauseStruct.freeText) {
      LocalizedString freeText = localizedStringStructToLocalizedString(localizedStringStruct);
      directCause.getFreeText().add(freeText);
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

    EList<LocalizedString> freeTexts = directCause.getFreeText();
    List<LocalizedStringStruct> freeTextStructs = new ArrayList<>();
    for (int i = 0; i < freeTexts.size(); i++) {
      LocalizedStringStruct freeTextStruct = localizedStringToLocalizedStringStruct(freeTexts.get(i));
      freeTextStructs.add(freeTextStruct);
    }

    DirectCauseStruct directCauseStruct = new DirectCauseStruct(
        mainCause,
        warningLevel,
        unverifiedInformation,
        subCause,
        lengthAffected,
        causeOffset,
        laneRestrictionsStructs,
        freeTextStructs);

    return directCauseStruct;
  }

  private static List<LocalizedStringStruct> reconstructLocalizedStringStructs(Vector<Object> vector) {
    LOGGER.info("reconstructLocalizedStringStructs =>");
    List<LocalizedStringStruct> localizedStringStructs = new ArrayList<>();
    
    for (Object object: vector) {
      LOGGER.info("Handling object: " + object + " = " + object.getClass().getName());
      if (object instanceof Object[]) {
        LOGGER.info("Type OK");
        LocalizedStringStruct localizedStringStruct = reconstructLocalizedStringStruct((Object[]) object);
        localizedStringStructs.add(localizedStringStruct);
      } else {
        LOGGER.info("Wrong Type");
      }
    }
    
    LOGGER.info("reconstructLocalizedStringStructs <= " + localizedStringStructs);
    return localizedStringStructs;
  }

  private static LocalizedStringStruct reconstructLocalizedStringStruct(Object[] objects) {
    LOGGER.info("reconstructLocalizedStringStruct => " + objects);
    
    LocalizedStringStruct localizedStringStruct = null;
    
    if (objects.length != 3) {
      LOGGER.info("Wrong number of elements");
      return null;      
    }
    
    String languageCode = null;
    String text = null;
    String countryCode = null;
    
    if (objects[0] instanceof String) {
      languageCode = (String) objects[0];
      LOGGER.fine("languageCode OK");
    } else {
      LOGGER.info("Wrong type for languageCode");
    }
    
    if (objects[1] instanceof String) {
      text = (String) objects[1];
      LOGGER.fine("text OK");
    } else {
      LOGGER.info("Wrong type for text");
    }
    
    if (objects[2] instanceof String) {
      countryCode = (String) objects[2];
      LOGGER.fine("countryCode OK");
    } else {
      LOGGER.info("Wrong type for countryCode");
    }
      
    localizedStringStruct = new LocalizedStringStruct(languageCode, text, countryCode);
    
    LOGGER.info("reconstructLocalizedStringStruct <= " + localizedStringStruct);
    return localizedStringStruct;
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
    
    for (LocalizedStringStruct localizedStringStruct: adviceStruct.freeText) {
      LocalizedString localizedString = localizedStringStructToLocalizedString(localizedStringStruct);
      advice.getFreeText().add(localizedString);
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
   
    EList<LocalizedString> freeTexts = advice.getFreeText();
    List<LocalizedStringStruct> freeTextStructs = new ArrayList<>();
    for (int i = 0; i < freeTexts.size(); i++) {
      LocalizedStringStruct localizedStringStruct = localizedStringToLocalizedStringStruct(freeTexts.get(i));
      freeTextStructs.add(localizedStringStruct);
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
        freeTextStructs,
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
        
    if (vehicleRelatedRestrictionStruct.restrictionLocationReference.size() == 1) {
      LocationReference restrictionLocationReference = locationReferenceStructToLocationReference(vehicleRelatedRestrictionStruct.restrictionLocationReference.get(0));
      vehicleRelatedRestriction.setRestrictionLocationReference(restrictionLocationReference);
    } else if (vehicleRelatedRestrictionStruct.restrictionLocationReference.size() == 0) {
      // No action
    } else {
      throw new RuntimeException("Illegal size for restrictionLocation: " + vehicleRelatedRestrictionStruct.restrictionLocationReference.size());
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

    List<LocationReferenceStruct> restrictionLocationReferences = new ArrayList<>();
    if (vehicleRelatedRestriction.isSetRestrictionLocationReference()) {
      LocationReferenceStruct locationReferenceStruct = locationReferenceToLocationReferenceStruct(vehicleRelatedRestriction.getRestrictionLocationReference());
      restrictionLocationReferences.add(locationReferenceStruct);
    }

    VehicleRelatedRestrictionStruct vehicleRelatedRestrictionStruct = new VehicleRelatedRestrictionStruct(
        restrictionType, restrictionValues, restrictionLocationReferences);

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

  private static LocationReference locationReferenceStructToLocationReference(LocationReferenceStruct locationReferenceStruct) {
    LOGGER.info("locationReferenceStructToLocationReference =>");
    LocationReference locationReference = LOCATION_REFERENCE_FACTORY.createLocationReference();
    
    locationReference.setLocationReferenceType(locationReferenceStruct.locationReferenceType);
    locationReference.setData(locationReferenceStruct.data);
    
    LOGGER.info("locationReferenceStructToLocationReference <=");
    return locationReference;
  }

  private static LocationReferenceStruct locationReferenceToLocationReferenceStruct(LocationReference locationReference) {
    Byte locationReferenceType = 0;
    if (locationReference.isSetLocationReferenceType()) {
      locationReferenceType = (Byte) (byte) locationReference.getLocationReferenceType();
    }
    
    byte[] data;
    if (locationReference.isSetData()) {
      data = (byte[]) locationReference.getData();
    } else {
      data = new byte[0];
    }
    
    LocationReferenceStruct locationReferenceStruct = new LocationReferenceStruct(
        locationReferenceType,
        data
        );
    
    return locationReferenceStruct;
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
