/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.textgenerator.basictextgenerator;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.genivi.common.CommonFactory;
import org.genivi.common.Version;
import org.genivi.location.LinearLocationInfo;
import org.genivi.trafficincidentsservice.LengthUnit;
import org.genivi.trafficincidentsservice.TextDetailLevel;
import org.genivi.trafficincidentsservice.WeightUnit;
import org.genivi.trafficincidentsservice.textgenerator.TrafficIncidentTextGenerator;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction;
import org.genivi.trafficincidentsservice.trafficincidenttables.Accident;
import org.genivi.trafficincidentsservice.trafficincidenttables.AnimalsOnRoadway;
import org.genivi.trafficincidentsservice.trafficincidenttables.BrokenDownVehicles;
import org.genivi.trafficincidentsservice.trafficincidenttables.DangerousEndOfQueue;
import org.genivi.trafficincidentsservice.trafficincidenttables.DoNotLeaveYourVehicle;
import org.genivi.trafficincidentsservice.trafficincidenttables.DriveCarefully;
import org.genivi.trafficincidentsservice.trafficincidenttables.DrivingNotAllowed;
import org.genivi.trafficincidentsservice.trafficincidenttables.ExtremeWeatherConditions;
import org.genivi.trafficincidentsservice.trafficincidenttables.Fire;
import org.genivi.trafficincidentsservice.trafficincidenttables.FollowDiversion;
import org.genivi.trafficincidentsservice.trafficincidenttables.GivingPathVehiclesFromBehind;
import org.genivi.trafficincidentsservice.trafficincidenttables.HazardousDrivingConditions;
import org.genivi.trafficincidentsservice.trafficincidenttables.Impassibility;
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
import org.genivi.trafficincidentsservice.trafficincidenttables.TimeDelay;
import org.genivi.trafficincidentsservice.trafficincidenttables.TrafficCongestion;
import org.genivi.trafficincidentsservice.trafficincidenttables.UseTollLanes;
import org.genivi.trafficincidentsservice.trafficincidenttables.VisibilityReduced;

public class BasicTextGenerator implements TrafficIncidentTextGenerator {
  private final static Logger LOGGER = Logger.getLogger(BasicTextGenerator.class.getName()); 
  private static final CommonFactory COMMON_FACTORY = CommonFactory.eINSTANCE;
  private static final Double        KM_TO_MILES_FACTOR = 1.609344;
  private static final Double        KG_TO_POUNDS_FACTOR = 0.45359237; //  1 pound = 0.45359237 kilograms
  private static final double        FOOT_TO_METER_FACTOR = 0.304800; // 1 foot = 0,304 800 m
  private static final int           MAJOR_VERSION_NUMBER = 0;
  private static final int           MINOR_VERSION_NUMBER = 1;
  private static final int           MICRO_VERSION_NUMBER = 0;
  private static final String        VERSION_DATE = "13-3-2012";
  
  private static final String        DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
  private static final String        DEFAULT_TIME_FORMAT = "hh:mm a";
  private static final LengthUnit    DEFAULT_LENGTH_UNIT = LengthUnit.KILOMETERS;
  private static final WeightUnit    DEFAULT_WEIGHT_UNIT = WeightUnit.KILOGRAM;
  private static final String        DEFAULT_LANGUAGE = "nld";
  private static final String        DEFAULT_COUNTRY = null;
  
  private static Version VERSION;
  private static Map<String, String>     languageMap = new HashMap<String, String>();
  private static Map<String, String>     countryMap = new HashMap<String, String>();
  private static Map<LengthUnit, String> speedUnitMap = new HashMap<LengthUnit, String>();
  private static Map<LengthUnit, String> lengthUnitMapLarge = new HashMap<LengthUnit, String>();
  
  private SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
  private SimpleDateFormat timeFormat = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
  private LengthUnit lengthUnit = DEFAULT_LENGTH_UNIT;
  private WeightUnit weightUnit = DEFAULT_WEIGHT_UNIT;
  private String languageCode = DEFAULT_LANGUAGE;
  private String countryCode = DEFAULT_COUNTRY;
  private Locale locale = null;
  private ResourceBundle textParts = null;
  private MessageFormat messageFormat = new MessageFormat("");
  
  static {
    VERSION = COMMON_FACTORY.createVersion();
    VERSION.setMajor(MAJOR_VERSION_NUMBER);
    VERSION.setMinor(MINOR_VERSION_NUMBER);
    VERSION.setMicro(MICRO_VERSION_NUMBER);
    VERSION.setDate(VERSION_DATE);
    
    speedUnitMap.put(LengthUnit.KILOMETERS, "km/h");
    speedUnitMap.put(LengthUnit.MILES, "mph");
    
    lengthUnitMapLarge.put(LengthUnit.KILOMETERS, "km");
    lengthUnitMapLarge.put(LengthUnit.MILES, "mile");
    
    languageMap.put("deu", "de");
    languageMap.put("eng", "en");
    languageMap.put("fra", "fr");
    languageMap.put("nld", "nl");
    
    countryMap.put("nld", "NL");
    countryMap.put("gbr", "GB");
    countryMap.put("usa", "US");
    countryMap.put("fra", "FR");
    countryMap.put("deu", "DE");
  }
  
  public BasicTextGenerator() {
    LOGGER.setLevel(Level.SEVERE);
    LOGGER.info("=>");
    handleLanguageChange();
  }
  
  private void handleLanguageChange() {
    String twoCharLanguageCode = languageMap.get(languageCode);
    String twoCharCountryCode = null;
    if (countryCode != null) {
      twoCharCountryCode = countryMap.get(countryCode);
    }
    
    if (twoCharCountryCode != null) {
      locale = new Locale(twoCharLanguageCode, twoCharCountryCode);
    } else {
      locale = new Locale(twoCharLanguageCode);
    }
    LOGGER.info("locale = " + locale.getDisplayName());
    messageFormat.setLocale(locale);
    textParts = ResourceBundle.getBundle("org.genivi.trafficincidentsservice.textgenerator.basictextgenerator.TextParts", locale);
  }

  @Override
  public Version getVersion() {
    return VERSION;
  }

  @Override
  public void setLanguage(String languageCode, String countryCode) {
    LOGGER.info("=> languageCode = " + languageCode + ", countryCode = " + countryCode);
    this.languageCode = languageCode;
    this.countryCode = countryCode;
    
    handleLanguageChange();
  }

  @Override
  public void setDateFormat(String dateFormat) {
    this.dateFormat = new SimpleDateFormat(dateFormat);
  }

  @Override
  public void setTimeFormat(String timeFormat) {
    this.timeFormat = new SimpleDateFormat(timeFormat);
  }

  @Override
  public void setLengthUnit(LengthUnit lengthUnit) {
    this.lengthUnit = lengthUnit;
  }

  @Override
  public void setWeightUnit(WeightUnit weightUnit) {
    this.weightUnit = weightUnit;
  }
  
  @Override
  public String getText(TrafficIncident trafficIncident,
      TextDetailLevel textDetailLevel) {
    StringBuffer buf = new StringBuffer();
    
    fillLocation(buf, trafficIncident);

    fillEffect(buf, trafficIncident);

    fillAverageSpeedAbsolute(buf, trafficIncident);

    fillSpeedLimit(buf, trafficIncident, textDetailLevel);

    fillExpectedSpeed(buf, trafficIncident, textDetailLevel);

    fillLengthAffected(buf, trafficIncident);

    fillDelay(buf, trafficIncident);

    fillValidityPeriod(buf, trafficIncident);

    fillTendencyPart(buf, trafficIncident, textDetailLevel);

    // Causes
    if (textDetailLevel == TextDetailLevel.FULL &&
        trafficIncident.isSetCauses()) {
      buf.append(textParts.getString("causedByPart"));
      
      boolean first = true;
      for (Cause cause: trafficIncident.getCauses()) {
        if (first) {
          first = false;
        } else {
          buf.append(", ");
        }
        fillCause(buf, cause);
      }
    }

    // Advices
    if (textDetailLevel == TextDetailLevel.FULL &&
        trafficIncident.isSetAdvices()) {
      buf.append(", ");
      buf.append(textParts.getString("advicePart"));

      boolean first = true;
      for (Advice advice: trafficIncident.getAdvices()) {
        if (first) {
          first = false;
        } else {
          buf.append(", ");
        }
        fillAdvice(buf, advice);
      }
    }
    buf.append(".");

    fillApplicabilityPart(buf, trafficIncident);

    return buf.toString();
  }

  private void formatDateTime(StringBuffer buf, Date dateTime) {
    if (dateIsToday(dateTime)) {
      // no date printed
    } else if (dateIsTomorrow(dateTime)) {
      buf.append(textParts.getString("tomorrow"));
    } else {
      buf.append(dateFormat.format(dateTime));
      buf.append(" ");
    }
    
  }

  private boolean dateIsToday(Date dateTime) {
    GregorianCalendar dateTimeCalendar = new GregorianCalendar();
    dateTimeCalendar.setTime(dateTime);
    
    GregorianCalendar todayCalendar = new GregorianCalendar();
    todayCalendar.setTime(new Date());
    
    if ((dateTimeCalendar.get(Calendar.YEAR) == todayCalendar.get(Calendar.YEAR)) &&
        (dateTimeCalendar.get(Calendar.DAY_OF_YEAR) == todayCalendar.get(Calendar.DAY_OF_YEAR))) {
      return true;
    } else {
      return false;
    }
  }

  private boolean dateIsTomorrow(Date dateTime) {
    GregorianCalendar dateTimeCalendar = new GregorianCalendar();
    dateTimeCalendar.setTime(dateTime);
    
    GregorianCalendar tomorrowCalendar = new GregorianCalendar();
    tomorrowCalendar.setTime(new Date());
    tomorrowCalendar.add(Calendar.DATE, 1);
    
    if ((dateTimeCalendar.get(Calendar.YEAR) == tomorrowCalendar.get(Calendar.YEAR)) &&
        (dateTimeCalendar.get(Calendar.DAY_OF_YEAR) == tomorrowCalendar.get(Calendar.DAY_OF_YEAR))) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public String[] getApplicabilityTexts(TrafficIncident trafficIncident) {
    if (trafficIncident.isSetApplicability()) {
      StringBuffer buf = new StringBuffer();

      List<Applicability> applicabilities = trafficIncident.getApplicability();
      String[] texts = new String[applicabilities.size()];

      int i = 0;
      for (Applicability applicability: applicabilities) {
        buf.setLength(0);
        fillApplicability(buf, applicability);
        texts[i++] = buf.toString();
      }
      
      return texts;
    } else {
      return null;
    }
  }

  @Override
  public String[] getCauseTexts(TrafficIncident trafficIncident) {
    if (trafficIncident.isSetCauses()) {
      StringBuffer buf = new StringBuffer();

      List<Cause> causes = trafficIncident.getCauses();
      String[] texts = new String[causes.size()];

      int i = 0;
      for (Cause cause: causes) {
        buf.setLength(0);
        fillCause(buf, cause);
        LOGGER.fine("buf = " + buf.toString());
        texts[i++] = buf.toString();
      }
      
      for (String text: texts) {
        LOGGER.fine("text = " + text);
      }
      return texts;
    } else {
      return null;
    }
  }

  @Override
  public String[] getAdviceTexts(TrafficIncident trafficIncident) {
    if (trafficIncident.isSetAdvices()) {
      StringBuffer buf = new StringBuffer();

      List<Advice> advices = trafficIncident.getAdvices();
      String[] texts = new String[advices.size()];

      int i = 0;
      for (Advice advice: advices) {
        buf.setLength(0);
        fillAdvice(buf, advice);
        LOGGER.fine("buf = " + buf.toString());
        texts[i++] = buf.toString();
      }
      
      for (String text: texts) {
        LOGGER.fine("text = " + text);
      }
      return texts;
    } else {
      return null;
    }
  }

  @Override
  public String getEffectText(TrafficIncident trafficIncident) {
    StringBuffer buf = new StringBuffer();
    
    fillEffect(buf, trafficIncident);
    
    return buf.toString();
  }

  @Override
  public String getTendencyText(TrafficIncident trafficIncident) {
    StringBuffer buf = new StringBuffer();
    
    fillTendency(buf, trafficIncident);
    
    return buf.toString();
  }


  private void fillLocation(StringBuffer buf, TrafficIncident trafficIncident) {
    if (trafficIncident.isSetLocationInfo()) {
      LinearLocationInfo linearLocationInfo = (LinearLocationInfo) trafficIncident.getLocationInfo();

      if (linearLocationInfo.getFromLocationParentName() != null  &&
          linearLocationInfo.getToLocationParentName() != null) {   
        messageFormat.applyPattern(textParts.getString("locationTemplate"));
        Object[] messageArguments = {
            linearLocationInfo.getName(),
            linearLocationInfo.getFromLocationParentName(),
            linearLocationInfo.getToLocationParentName(),
            linearLocationInfo.getFromLocationName(),
            linearLocationInfo.getToLocationName()
        };
        messageFormat.format(messageArguments, buf, null);
      } else {
        messageFormat.applyPattern(textParts.getString("locationTemplateShort"));
        Object[] messageArguments = {
            linearLocationInfo.getName(),
            linearLocationInfo.getFromLocationName(),
            linearLocationInfo.getToLocationName()
        };
        messageFormat.format(messageArguments, buf, null);
      }
    }
  }

  private void fillEffect(StringBuffer buf, TrafficIncident trafficIncident) {
    if (trafficIncident.isSetEffectCode()) {
      buf.append(trafficIncident.getEffectCode().getLiteral());
    } else {
      buf.append("<NO EFFECTCODE>");
    }
  }
  
  private void fillAverageSpeedAbsolute(StringBuffer buf, TrafficIncident trafficIncident) {
    if (trafficIncident.isSetAverageSpeedAbsolute()) {
      messageFormat.applyPattern(textParts.getString("averageSpeedAbsoluteTemplate"));
      double speed = msToKmh(trafficIncident.getAverageSpeedAbsolute());
      if (lengthUnit == LengthUnit.MILES) {
        speed = kmToMiles(speed);
      }
      Object[] messageArguments = {
          speed,
          speedUnitMap.get(lengthUnit)
      };
      messageFormat.format(messageArguments, buf, null);
    }
  }
  
  private void fillSpeedLimit(StringBuffer buf, TrafficIncident trafficIncident, TextDetailLevel textDetailLevel) {
    if (textDetailLevel == TextDetailLevel.FULL &&
        trafficIncident.isSetSegmentSpeedLimit()) {
      messageFormat.applyPattern(textParts.getString("speedLimitTemplate"));
      double speedLimit = msToKmh(trafficIncident.getSegmentSpeedLimit());
      if (lengthUnit == LengthUnit.MILES) {
        speedLimit = kmToMiles(speedLimit);
      }
      Object[] messageArguments = {
          speedLimit,
          speedUnitMap.get(lengthUnit)
      };
      messageFormat.format(messageArguments, buf, null);
    }
  }
  
  private void fillExpectedSpeed(StringBuffer buf, TrafficIncident trafficIncident, TextDetailLevel textDetailLevel) {
    if (textDetailLevel == TextDetailLevel.FULL &&
        trafficIncident.isSetExpectedSpeedAbsolute()) {
      messageFormat.applyPattern(textParts.getString("expectedSpeedTemplate"));
      double expectedSpeed = msToKmh(trafficIncident.getExpectedSpeedAbsolute());
      if (lengthUnit == LengthUnit.MILES) {
    	  expectedSpeed = kmToMiles(expectedSpeed);
      }
      Object[] messageArguments = {
    	  expectedSpeed,
          speedUnitMap.get(lengthUnit)
      };
      messageFormat.format(messageArguments, buf, null);
    }
  }
  
  private void fillLengthAffected(StringBuffer buf, TrafficIncident trafficIncident) {
    if (trafficIncident.isSetLengthAffected()) {
      messageFormat.applyPattern(textParts.getString("lengthAffectedTemplate"));
      double lengthAffected = trafficIncident.getLengthAffected() / 1000.0;
      if (lengthUnit == LengthUnit.MILES) {
        lengthAffected = kmToMiles(lengthAffected);
      }
      Object[] messageArguments = {
          lengthAffected,
          lengthUnitMapLarge.get(lengthUnit)
      };
      messageFormat.format(messageArguments, buf, null);
    }
  }
  
  private void fillDelay(StringBuffer buf, TrafficIncident trafficIncident) {
    if (trafficIncident.isSetDelay()) {
      messageFormat.applyPattern(textParts.getString("delayTemplate"));
      Object[] messageArguments = {
          trafficIncident.getDelay()
      };
      messageFormat.format(messageArguments, buf, null);
    }
  }

  
  private void fillValidityPeriod(StringBuffer buf, TrafficIncident trafficIncident) {
    // StartTime and StopTime
    if (trafficIncident.isSetStartTime()) {
      buf.append(textParts.getString("fromPart"));
      formatDateTime(buf, trafficIncident.getStartTime());
      buf.append(timeFormat.format(trafficIncident.getStartTime()));
    }
    if (trafficIncident.isSetStopTime()) {
      buf.append(textParts.getString("tillPart"));
      formatDateTime(buf, trafficIncident.getStopTime());
      buf.append(timeFormat.format(trafficIncident.getStopTime()));
    }
  }

  private void fillTendencyPart(StringBuffer buf, TrafficIncident trafficIncident, TextDetailLevel textDetailLevel) {
    if (textDetailLevel == TextDetailLevel.FULL  &&
        trafficIncident.isSetTendency()) {
      buf.append(textParts.getString("tendencyPart"));
      fillTendency(buf, trafficIncident);
    }
  }
  
  private void fillTendency(StringBuffer buf, TrafficIncident trafficIncident) {
    if (trafficIncident.isSetTendency()) {
      buf.append(trafficIncident.getTendency().getLiteral());
    }
  }

  private void fillCause(StringBuffer buf, Cause cause) {
    String causeText = cause.getMainCause().getLiteral();
    if (cause instanceof DirectCause) {
      DirectCause directCause = (DirectCause) cause;


      // subCause
      Object subCause = directCause.getSubCause();

      if (subCause != null) {
        switch (cause.getMainCause()) {
        case TRAFFIC_CONGESTION:
          causeText = ((TrafficCongestion) subCause).getLiteral();
          break;

        case ACCIDENT:
          causeText = ((Accident) subCause).getLiteral();
          break;

        case ROADWORKS:
          causeText = ((RoadWorks) subCause).getLiteral();
          break;

        case NARROW_LANES:
          causeText = ((NarrowLanes) subCause).getLiteral();
          break;

        case IMPASSIBILITY:
          causeText = ((Impassibility) subCause).getLiteral();
          break;

        case SLIPPERY_ROAD:
          causeText = ((SlipperyRoad) subCause).getLiteral();
          break;

        case AQUAPLANING:
          // No SubCause
          break;

        case FIRE:
          causeText = ((Fire) subCause).getLiteral();
          break;

        case HAZARDOUS_DRIVING_CONDITIONS:
          causeText = ((HazardousDrivingConditions) subCause).getLiteral();
          break;

        case OBJECTS_ON_THE_ROAD:
          causeText = ((ObjectsOnTheRoad) subCause).getLiteral();
          break;

        case ANIMALS_ON_ROADWAY:
          causeText = ((AnimalsOnRoadway) subCause).getLiteral();
          break;

        case PEOPLE_ON_ROADWAY:
          causeText = ((PeopleOnRoadway) subCause).getLiteral();
          break;

        case BROKEN_DOWN_VEHICLES:
          causeText = ((BrokenDownVehicles) subCause).getLiteral();
          break;

        case VEHICLE_ON_WRONG_CARRIAGEWAY:
          // No SubCause
          break;

        case RESCUE_AND_RECOVERY_WORK_IN_PROGRESS:
          causeText = ((RescueAndRecoveryWorkInProgress) subCause).getLiteral();
          break;

        case REGULATORY_MEASURE:
          causeText = ((RegulatoryMeasure) subCause).getLiteral();
          break;

        case EXTREME_WEATHER_CONDITIONS:
          causeText = ((ExtremeWeatherConditions) subCause).getLiteral();
          break;

        case VISIBILITY_REDUCED:
          causeText = ((VisibilityReduced) subCause).getLiteral();
          break;

        case PRECIPITATION:
          causeText = ((Precipitation) subCause).getLiteral();
          break;

        case RECKLESS_PERSONS:
          causeText = ((RecklessPersons) subCause).getLiteral();
          break;

        case OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED:
          // No SubCause
          break;

        case TRAFFIC_REGULATIONS_CHANGED:
          // No SubCause
          break;

        case MAJOR_EVENT:
          causeText = ((MajorEvent) subCause).getLiteral();
          break;

        case SERVICE_NOT_OPERATING:
          causeText = ((ServiceNotOperating) subCause).getLiteral();
          break;

        case SERVICE_NOT_USEABLE:
          causeText = ((ServiceNotUsable) subCause).getLiteral();
          break;

        case SLOW_MOVING_VEHICLES:
          causeText = ((SlowMovingVehicles) subCause).getLiteral();
          break;

        case DANGEROUS_END_OF_QUEUE:
          causeText = ((DangerousEndOfQueue) subCause).getLiteral();
          break;

        case RISK_OF_FIRE:
          causeText = ((RiskOfFire) subCause).getLiteral();
          break;

        case TIME_DELAY:
          causeText = ((TimeDelay) subCause).getLiteral();
          break;

        case POLICE_CHECKPOINT:
          causeText = ((PoliceCheckpoint) subCause).getLiteral();
          break;

        case MALFUNCTIONING_ROADSIDE_EQUIPMENT:
          causeText = ((MalfunctioningRoadsideEquipment) subCause).getLiteral();
          break;
        }
      }
      buf.append(" ");
      buf.append(causeText);
      
      // lengthAffected
      if (directCause.getLengthAffected() != null) {
        messageFormat.applyPattern(textParts.getString("lengthAffectedTemplate"));
        double lengthAffected = directCause.getLengthAffected() / 1000.0;
        if (lengthUnit == LengthUnit.MILES) {
          lengthAffected = kmToMiles(lengthAffected);
        }
        Object[] messageArguments = {
            lengthAffected,
            lengthUnitMapLarge.get(lengthUnit)
        };
        messageFormat.format(messageArguments, buf, null);
      }

      // laneRestrictions
      LaneRestrictions laneRestrictions = directCause.getLaneRestrictions();
      if (laneRestrictions != null) {
        buf.append(textParts.getString("laneRestrictionsPart"));
        if (laneRestrictions.getNumberOfLanes() != null) {
          buf.append(String.valueOf(laneRestrictions.getNumberOfLanes()));
          buf.append(" ");
        }
        buf.append(laneRestrictions.getLaneRestrictionType().getLiteral());
      }
      
      // freeText
      if (directCause.isSetFreeText()) {
        buf.append(" ");
        buf.append(directCause.getFreeText());
      }

      // unverifiedInformation
      if (directCause.isUnverifiedInformation()) {
        buf.append(textParts.getString("unverifiedInformationPart"));
      }
    } else {
      buf.append(" ");
      buf.append(causeText);
    }
  }

  private void fillApplicabilityPart(StringBuffer buf, TrafficIncident trafficIncident) {
    // Applicability
    if (trafficIncident.isSetApplicability()) {
      buf.append(textParts.getString("applicabilityPart"));
      
      for (Applicability applicability: trafficIncident.getApplicability()) {
        fillApplicability(buf, applicability);
      }
    }
  }
  
  private void fillApplicability(StringBuffer buf, Applicability applicability) {
    if (applicability.getVehicleType() != null) {
      buf.append(" ");
      buf.append(applicability.getVehicleType().getLiteral());
    }

    for (VehicleRelatedRestriction vehicleRelatedRestriction: applicability.getVehicleRelatedRestrictions()) {
      buf.append(" ");
      buf.append(vehicleRelatedRestriction.getRestrictionType().getLiteral());
      
      fillRestrictionTypeValueAndUnit(buf, vehicleRelatedRestriction.getRestrictionType(), vehicleRelatedRestriction.getRestrictionValue());
    }
  }

  private void fillAdvice(StringBuffer buf, Advice advice) {
    String adviceText = advice.getMainAdvice().getLiteral();
    // subCause
    Object subAdviceCode = null;
    if (advice.isSetSubAdvice()) {
      subAdviceCode = advice.getSubAdvice();
    }

    if (subAdviceCode != null) {
      switch (advice.getMainAdvice()) {
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
        // No SubCause
        break;

      case DO_NOT_LEAVE_YOUR_VEHICLE:
        adviceText = ((DoNotLeaveYourVehicle) subAdviceCode).getLiteral();
        break;

      case DRIVE_CAREFULLY:
        adviceText = ((DriveCarefully) subAdviceCode).getLiteral();
        break;

      case DRIVING_NOT_ALLOWED:
        adviceText = ((DrivingNotAllowed) subAdviceCode).getLiteral();
        break;

      case FOLLOW_DIVERSION:
        adviceText = ((FollowDiversion) subAdviceCode).getLiteral();
        break;

      case GIVING_PATH_VEHICLES_COMING_FROM_BEHIND:
        adviceText = ((GivingPathVehiclesFromBehind) subAdviceCode).getLiteral();
        break;

      case OVERTAKING_NOT_ALLOWED:
        adviceText = ((OvertakingNotAllowed) subAdviceCode).getLiteral();
        break;

      case USE_TOLL_LANES:
        adviceText = ((UseTollLanes) subAdviceCode).getLiteral();
        break;
      }
    }
    buf.append(" ");
    buf.append(adviceText);
  }
  
  private void fillRestrictionTypeValueAndUnit(StringBuffer buf, RestrictionType restrictionType, Integer restrictionValue) {
    if (restrictionValue == null) {
      return;
    }
    
    double value = restrictionValue;
    String unit = null;
    switch (restrictionType) {
    // units in Tonnes
    case AXLE_LOAD_GREATER_THAN:
    case AXLE_LOAD_LESS_THAN:
    case WEIGHT_GREATER_THAN:
    case WEIGHT_LESS_THAN:
      switch (weightUnit) {
      case KILOGRAM:
        value = value / 1000;
        unit = textParts.getString("tonnes");
        break;
        
      case POUND:
        value = kgToPounds(value);
        unit = textParts.getString("pounds");
        break;
      }
      break;
    
    // units in m
    case HEIGTH_GREATER_THAN:
    case HEIGTH_LESS_THAN:
    case LENGTH_GREATER_THAN:
    case LENGTH_LESS_THAN:
    case WIDTH_GREATER_THAN:
    case WIDTH_LESS_THAN:
      switch (lengthUnit) {
      case KILOMETERS:
        unit = "m";
        value = value / 100;
        break;
      
      case MILES:
        unit = textParts.getString("foot");
        value = meterToFoot(value / 100);
        break;
      }
      break;
      
    case VEHICLE_FULFILLS_EMISSION_STANDARD_EURO3:
    case VEHICLE_FULFILLS_EMISSION_STANDARD_EURO3D4:
    case VEHICLE_FULFILLS_EMISSION_STANDARD_EURO4:
    case VEHICLE_FULFILLS_EMISSION_STANDARD_EURO5:
    case EVEN_NUMBER_PLATE:
    case ODD_NUMBER_PLATE:
    case PERSONS_IN_VEHICLE_LESS_THAN:
    case PERSONS_IN_VEHICLE_MORE_THAN:
    case WITH_TRAILER:
    case WITH_CARAVAN:
    case WITHOUT_SNOW_CHAIN:
    case WITHOUT_WINTER_TYRE:
    case RESIDENTS_TRAFFIC:
    case WITH_LPG_ENGINE:
    case WITH_PETROL_ENGINE:
    case WITH_DIESEL_ENGINE:
    case WITH_DESTINATION_IN_GIVEN_AREA:
    case THROUGH_TRAFFIC:
      // No unit
      break;
    }

    buf.append(" ");
    buf.append(String.valueOf(value));

    if (unit != null) {
      buf.append(" ");
      buf.append(unit);
    }
  }

  public static double msToKmh(int ms) {
    return 3600.0 * ms / 1000.0;
  }
  
  public static double kmToMiles(double km) {
    return km / KM_TO_MILES_FACTOR;
  }
  
  public static double metersToYards(double length) {
    return 0.0;
  }
  
  public static double kgToPounds(double kg) {
    return kg / KG_TO_POUNDS_FACTOR;
  }
  
  public static double meterToFoot(double meter) {
    return meter / FOOT_TO_METER_FACTOR;
  }
}
