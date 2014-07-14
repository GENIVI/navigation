/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.dbus;

import java.util.List;

import org.freedesktop.dbus.Position;
import org.freedesktop.dbus.Struct;

public class TrafficIncidentStruct extends Struct {
  @Position(0)
  public final Integer trafficIncidentId;
  
  @Position(1)
  public final Byte effectCode;
  
  @Position(2)
  public final String effectText;
  
  @Position(3)
  public final Integer startTime;
  
  @Position(4)
  public final Integer stopTime;
  
  @Position(5)
  public final Byte tendency;  // Tendency
  
  @Position(6)
  public final String tendencyText;
  
  @Position(7)
  public final Integer lengthAffected;
  
  @Position(8)
  public final Integer averageSpeedAbsolute;
  
  @Position(9)
  public final Integer delay;
  
  @Position(10)
  public final Integer segmentSpeedLimit;
  
  @Position(11)
  public final Integer expectedSpeedAbsolute;
  
  @Position(12)
  public final List<CauseDiscriminatedVariant> causes;
  
  @Position(13)
  // Actually an optional value, which is represented by an array of length 0 or 1.
  public final List<LocationDiscriminatedVariant> location;  // LocationUnion
  
  @Position(14)
  public final List<AdviceStruct> advices;
  
  @Position(15)
  public final List<ApplicabilityStruct> applicability;

  @Position(16)
  public final List<TemporarySpeedLimitStruct> temporarySpeedLimits;
  
  @Position(17)
  // Actually an optional value, which is represented by an array of length 0 or 1.
  public final List<LocationInfoDiscriminatedVariant> locationInfo;  // LocationInfoUnion
  
  @Position(18)
  public final List<String> causeTexts;
  
  @Position(19)
  public final List<String> applicabilityTexts;
  
  @Position(20)
  public final List<String> adviceTexts;
  
  @Position(21)
  // Actually an optional value, which is represented by an array of length 0 or 1.
  public final List<RectangularAreaStruct> locationBoundingBox;
  
  @Position(22)
  public final List<Integer> categoryIds;
  
  public TrafficIncidentStruct(
      Integer trafficIncidentId,
      Byte effectCode,
      String effectText,
      Integer startTime,
      Integer stopTime,
      Byte tendency,
      String tendencyText,
      Integer lengthAffected,
      Integer averageSpeedAbsolute,
      Integer delay,
      Integer segmentSpeedLimit,
      Integer expectedSpeedAbsolute,
      List<CauseDiscriminatedVariant> causes,
      List<LocationDiscriminatedVariant> location,
      List<AdviceStruct> advices,
      List<ApplicabilityStruct> applicability,
      List<TemporarySpeedLimitStruct> temporarySpeedLimits,
      List<LocationInfoDiscriminatedVariant> locationInfo,
      List<String> causeTexts,
      List<String> applicabilityTexts,
      List<String> adviceTexts,
      List<RectangularAreaStruct> locationBoundingBox,
      List<Integer> categoryIds
      ) {
    super();
    this.trafficIncidentId = trafficIncidentId;
    this.effectCode = effectCode;
    this.effectText = effectText;
    this.startTime   = startTime;
    this.stopTime = stopTime;
    this.tendency = tendency;
    this.tendencyText = tendencyText;
    this.lengthAffected = lengthAffected;
    this.averageSpeedAbsolute = averageSpeedAbsolute;
    this.delay = delay;
    this.segmentSpeedLimit = segmentSpeedLimit;
    this.expectedSpeedAbsolute = expectedSpeedAbsolute;
    this.causes = causes;
    this.location = location;
    this.advices = advices;
    this.applicability = applicability;
    this.locationInfo = locationInfo;
    this.causeTexts = causeTexts;
    this.applicabilityTexts = applicabilityTexts;
    this.adviceTexts = adviceTexts;
    this.locationBoundingBox = locationBoundingBox;
    this.categoryIds = categoryIds;
    this.temporarySpeedLimits = temporarySpeedLimits;
  }
}
