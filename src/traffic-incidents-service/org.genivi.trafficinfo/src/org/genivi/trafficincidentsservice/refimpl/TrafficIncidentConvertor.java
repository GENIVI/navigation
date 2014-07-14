/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

import java.util.Date;
import java.util.List;

import org.genivi.common.LocalizedString;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentFactory;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction;

public class TrafficIncidentConvertor {
  private static final trafficincidentFactory TI_FACTORY = trafficincidentFactory.eINSTANCE;

  public static TrafficIncident xTrafficIncident2TrafficIncident(
      org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident xTrafficIncident,
      String languageCode, String languageCountryCode) {
    TrafficIncident trafficIncident = TI_FACTORY.createTrafficIncident();
    
    // trafficIncidentId: not available in xTrafficIncident.
    
    // effectCode
    if (xTrafficIncident.isSetEffectCode()) {
      trafficIncident.setEffectCode(xTrafficIncident.getEffectCode());
    }
    
    // effectText: not available in xTrafficIncident.
    
    // startTime
    if (xTrafficIncident.isSetStartTime()) {
      Date startDate = new Date(xTrafficIncident.getStartTime().getTime());
      trafficIncident.setStartTime(startDate);
    }
    
    // stopTime
    if (xTrafficIncident.isSetStopTime()) {
      Date stopDate = new Date(xTrafficIncident.getStopTime().getTime());
      trafficIncident.setStopTime(stopDate);
    }
    
    // tendency
    if (xTrafficIncident.isSetTendency()) {
      trafficIncident.setTendency(xTrafficIncident.getTendency());
    }
    
    // tendencyText:; not available in xTrafficIncident.
    
    // lengthAffected
    if (xTrafficIncident.isSetLengthAffected()) {
      trafficIncident.setLengthAffected(xTrafficIncident.getLengthAffected());
    }
    
    // averageSpeedAbsolute
    if (xTrafficIncident.isSetAverageSpeedAbsolute()) {
      trafficIncident.setAverageSpeedAbsolute(xTrafficIncident.getAverageSpeedAbsolute());
    }
    
    // delay
    if (xTrafficIncident.isSetDelay()) {
      trafficIncident.setDelay(xTrafficIncident.getDelay());
    }
    
    // segmentSpeedLimit
    if (xTrafficIncident.isSetSegmentSpeedLimit()) {
      trafficIncident.setSegmentSpeedLimit(xTrafficIncident.getSegmentSpeedLimit());
    }
    
    // expectedSpeedAbsolute
    if (xTrafficIncident.isSetExpectedSpeedAbsolute()) {
      trafficIncident.setExpectedSpeedAbsolute(xTrafficIncident.getExpectedSpeedAbsolute());
    }
    
    // locationInfo: not available in xTrafficIncident.
    
    // causeTexts: not available in xTrafficIncident.
    
    // applicabilityTexts: not available in xTrafficIncident.
    
    // adviceTexts: not available in xTrafficIncident.
    
    // categoryIds: not available in xTrafficIncident.
    
    // locationInfo: not available in xTrafficIncident.
    
    // causes
    for (org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause xCause: xTrafficIncident.getCauses()) {
      trafficIncident.getCauses().add(xCause2Cause(xCause, languageCode, languageCountryCode));
    }
    
    // advices
    for (org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice xAdvice: xTrafficIncident.getAdvices()) {
      trafficIncident.getAdvices().add(xAdvice2Advice(xAdvice, languageCode, languageCountryCode));
    }
    
    // applicability
    for (org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability xApplicability: xTrafficIncident.getApplicability()) {
      trafficIncident.getApplicability().add(xApplicability2Applicability(xApplicability));
    }
    
    // location: not available in xTrafficIncident.
    
    // locationBoundingBox: not available in xTrafficIncident.
    
    return trafficIncident;
  }

  private static Cause xCause2Cause(org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause xCause, String languageCode, String languageCountryCode) {
    Cause cause;
    
    if (xCause instanceof org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause) {
      cause = xDirectCause2DirectCause((org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause) xCause, languageCode, languageCountryCode);
    } else {
      cause = xLinkedCause2LinkedCause((org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause) xCause);
    }
    cause.setMainCause(xCause.getMainCause());
    
    return cause;
  }

  private static DirectCause xDirectCause2DirectCause(org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause xDirectCause,
      String languageCode, String languageCountryCode) {
    DirectCause directCause = TI_FACTORY.createDirectCause();
    
    // warningLevel
    if (xDirectCause.isSetWarningLevel()) {
      directCause.setWarningLevel(xDirectCause.getWarningLevel());
    }
    
    // unverifiedInformation
    directCause.setUnverifiedInformation(xDirectCause.isUnverifiedInformation());
    
    // subCause
    if (xDirectCause.isSetSubCause()) {
      directCause.setSubCause(xDirectCause.getSubCause());
    }
    
    // lengthAffected
    if (xDirectCause.isSetLengthAffected()) {
      directCause.setLengthAffected(xDirectCause.getLengthAffected());
    }
    
    // freeText
    if (xDirectCause.getFreeText().size() != 0) {
      directCause.setFreeText(getTextForSelectedLanguage(xDirectCause.getFreeText(), languageCode, languageCountryCode));
    }
    
    // laneRestrictions
    if (xDirectCause.isSetLaneRestrictions()) {
      directCause.setLaneRestrictions(xLaneRestrictions2LaneRestrictions(xDirectCause.getLaneRestrictions()));
    }
    
    // causeOffset
    if (xDirectCause.isSetCauseOffset()) {
      directCause.setCauseOffset(xDirectCause.getCauseOffset());
    }
    
    return directCause;
  }

  private static LaneRestrictions xLaneRestrictions2LaneRestrictions(
      org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions xLaneRestrictions) {
    LaneRestrictions laneRestrictions = TI_FACTORY.createLaneRestrictions();
    
    // laneRestrictionType
    laneRestrictions.setLaneRestrictionType(xLaneRestrictions.getLaneRestrictionType());
    
    // numberOfLanes
    if (xLaneRestrictions.isSetNumberOfLanes()) {
      laneRestrictions.setNumberOfLanes(xLaneRestrictions.getNumberOfLanes());
    }
    
    return laneRestrictions;
  }

  private static LinkedCause xLinkedCause2LinkedCause(org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause xLinkedCause) {
    LinkedCause linkedCause = TI_FACTORY.createLinkedCause();
    
    // causeTrafficIncidentId: not available in xTrafficIncident.
    
    return linkedCause;
  }

  private static Advice xAdvice2Advice(org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice xAdvice, String languageCode, String languageCountryCode) {
    Advice advice = TI_FACTORY.createAdvice();
    
    // mainAdvice
    advice.setMainAdvice(xAdvice.getMainAdvice());
    
    // subAdvice
    if (xAdvice.isSetSubAdvice()) {
      advice.setSubAdvice(xAdvice.getSubAdvice());
    }
    
    // freeText
    if (xAdvice.getFreeText().size() != 0) {
      advice.setFreeText(getTextForSelectedLanguage(xAdvice.getFreeText(), languageCode, languageCountryCode));
    }
    
    // applicability
    for (org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability xApplicability: xAdvice.getApplicability()) {
      advice.getApplicability().add(xApplicability2Applicability(xApplicability));
    }
    
    return advice;
  }

  private static Applicability xApplicability2Applicability(org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability xApplicability) {
    Applicability applicability = TI_FACTORY.createApplicability();
    
    // vehicleType
    applicability.setVehicleType(xApplicability.getVehicleType());
    
    // vehicleRelatedRestrictions
    for (org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction xVehicleRelatedRestriction: xApplicability.getVehicleRelatedRestrictions()) {
      applicability.getVehicleRelatedRestrictions().add(xVehicleRelatedRestriction2VehicleRelatedRestriction(xVehicleRelatedRestriction));
    }
    
    return applicability;
  }

  private static VehicleRelatedRestriction xVehicleRelatedRestriction2VehicleRelatedRestriction(
      org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction xVehicleRelatedRestriction) {
    VehicleRelatedRestriction vehicleRelatedRestriction = TI_FACTORY.createVehicleRelatedRestriction();
    
    // restrictionType
    vehicleRelatedRestriction.setRestrictionType(xVehicleRelatedRestriction.getRestrictionType());
    
    // restrictionValue
    if (xVehicleRelatedRestriction.isSetRestrictionValue()) {
      vehicleRelatedRestriction.setRestrictionValue(xVehicleRelatedRestriction.getRestrictionValue());
    }
    
    // restrictionLocation: not available in xTrafficIncident.
    
    return vehicleRelatedRestriction;
  }

  public static String getTextForSelectedLanguage(List<LocalizedString> localizedStrings, String languageCode, String languageCountryCode) {
    // if languageCountryCode is set, try to find a match on language and country
    if (languageCountryCode != null) {
      for (LocalizedString localizedString: localizedStrings) {
        if (localizedString.getLanguageCode().equals(languageCode)  &&
            localizedString.isSetCountryCode()  &&
            localizedString.getCountryCode().equals(languageCountryCode)) {
          return localizedString.getString();
        }
      }
    }
    
    // try to find a match language only
    for (LocalizedString localizedString: localizedStrings) {
      if (localizedString.getLanguageCode().equals(languageCode)) {
        return localizedString.getString();
      }
    }
    
    // just take the first one
    return localizedStrings.get(0).getString();
  }
}
