/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus;

import java.util.List;

import org.freedesktop.dbus.Position;
import org.freedesktop.dbus.Struct;

public class TrafficIncidentStruct extends Struct {
  @Position(0)
  public final String trafficIncidentId;
  
  @Position(1)
  public final Byte effectCode;  // EffectCode
  
  @Position(2)
  public final Integer startTime;
  
  @Position(3)
  public final Integer stopTime;
  
  @Position(4)
  public final Byte tendency;  // Tendency
  
  @Position(5)
  public final Integer lengthAffected;
  
  @Position(6)
  public final Integer averageSpeedAbsolute;
  
  @Position(7)
  public final Integer delay;
  
  @Position(8)
  public final Integer segmentSpeedLimit;
  
  @Position(9)
  public final Integer expectedSpeedAbsolute;
  
  @Position(10)
  public final List<CauseDiscriminatedVariant> causes;
  
  @Position(11)
  public final List<AdviceStruct> advices;
  
  @Position(12)
  public final List<ApplicabilityStruct> applicability;
  
  @Position(13)
  public final List<TemporarySpeedLimitStruct> temporarySpeedLimits;
  
  @Position(14)
  public final Integer expirationTime;
  
  @Position(15)
  public final Integer updateTime;
  
  @Position(16)
  public final LocationReferenceStruct locationReference;
  
  
  public TrafficIncidentStruct(
      String trafficIncidentManagementId,
      Byte effectCode,
      Integer startTime,
      Integer stopTime,
      Byte tendency,
      Integer lengthAffected,
      Integer averageSpeedAbsolute,
      Integer delay,
      Integer segmentSpeedLimit,
      Integer expectedSpeedAbsolute,
      List<CauseDiscriminatedVariant> causes,
      List<AdviceStruct> advices,
      List<ApplicabilityStruct> applicability,
      List<TemporarySpeedLimitStruct> temporarySpeedLimits,
      Integer expirationTime,
      Integer updateTime,
      LocationReferenceStruct locationReference
      ) {
    super();
    this.trafficIncidentId = trafficIncidentManagementId;
    this.effectCode = effectCode;
    this.startTime   = startTime;
    this.stopTime = stopTime;
    this.tendency = tendency;
    this.lengthAffected = lengthAffected;
    this.averageSpeedAbsolute = averageSpeedAbsolute;
    this.delay = delay;
    this.segmentSpeedLimit = segmentSpeedLimit;
    this.expectedSpeedAbsolute = expectedSpeedAbsolute;
    this.causes = causes;
    this.advices = advices;
    this.applicability = applicability;
    this.temporarySpeedLimits = temporarySpeedLimits;
    this.expirationTime = expirationTime;
    this.updateTime = updateTime;
    this.locationReference = locationReference;
  }
}
