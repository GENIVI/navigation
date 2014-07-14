/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tecservice.testsetplayer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.genivi.trafficinfo.tpeg.registeredvalues.ApplicationId;
import org.genivi.trafficinfo.tpeg.serverside.broadcast.app.fwk.ApplicationServer;
import org.genivi.trafficinfo.tpeg.serverside.broadcast.fwk.impl.BroadcastFrameworkImplementation;
import org.genivi.trafficinfo.tpeg.tec.event.Advice;
import org.genivi.trafficinfo.tpeg.tec.event.AdviceCode;
import org.genivi.trafficinfo.tpeg.tec.event.CauseCode;
import org.genivi.trafficinfo.tpeg.tec.event.DirectCause;
import org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle;
import org.genivi.trafficinfo.tpeg.tec.event.EffectCode;
import org.genivi.trafficinfo.tpeg.tec.event.Event;
import org.genivi.trafficinfo.tpeg.tec.event.EventFactory;
import org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType;
import org.genivi.trafficinfo.tpeg.tec.event.RestrictionType;
import org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles;
import org.genivi.trafficinfo.tpeg.tec.event.TECMessage;
import org.genivi.trafficinfo.tpeg.tec.event.Tendency;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleType;
import org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced;
import org.genivi.trafficinfo.tpeg.tec.event.WarningLevel;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MessageManagementContainer;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesFactory;
import org.genivi.trafficinfo.tpeg.tpegtables.LanguageCode;


/**
 * This TEC service repeatedly plays a fixed set of test messages.
 * In this description the messages are referred to by their name,
 * which has the format message<messageId>.
 * There are 3 messages:
 * message1234
 * message4567
 * message7878
 * 
 * Message sequence:
 * The method getApplicationData() repeatedly returns the following sequence:
 * Call 1
 *   new message: message1234
 * Call 2
 *   cancel message: message1234
 *   new message: message4567
 * Call 3
 *   new message: message7878
 * Call 4
 *   cancel messages: message7878, message4567
 */
public class TestPlayerTecService implements ApplicationServer {
  private final static Logger LOGGER = Logger.getLogger(TestPlayerTecService.class.getName()); 
  private final static byte CONTENT_ID = (byte) 13;
  
  private static final EventFactory EVENT_FACTORY = EventFactory.eINSTANCE;
  private static final TpegfwktypesFactory FACTORY = TpegfwktypesFactory.eINSTANCE;
  private static OLRLocationReference olrLocationReference1;
  private static OLRLocationReference olrLocationReference1b;
  private static OLRLocationReference olrLocationReference2;
  private static TECMessage message1234;
  private static TECMessage cancelMessage1234;
  private static TECMessage message4567;
  private static TECMessage cancelMessage4567;
  private static TECMessage message7878;
  private static TECMessage cancelMessage7878;
  
  private static List<TECMessage> fixedSet;
  private static List<List<TECMessage>> testSets;

  private BroadcastFrameworkImplementation broadcastFramework;
  private byte myServiceComponentId;
  private int callNumber = 0; // Used to cycle through test Sets.

  static {
    olrLocationReference1 = createOlrLocationReference1();
    olrLocationReference1b = createOlrLocationReference1b();
    olrLocationReference2 = createOlrLocationReference2();
    
    message1234 = createTecMessage1234();
    cancelMessage1234 = createTecCancelMessage1234();
    message4567 = createTecMessage4567();
    cancelMessage4567 = createTecCancelMessage4567();
    message7878 = createTecMessage7878();
    cancelMessage7878 = createTecCancelMessage7878();
    
    testSets = new ArrayList<List<TECMessage>>();
    
    fixedSet = new ArrayList<TECMessage>();
    fixedSet.add(message1234);
    fixedSet.add(message4567);
    fixedSet.add(message7878);

    createTestSet1(testSets);
    createTestSet2(testSets);
    createTestSet3(testSets);
    createTestSet4(testSets);
  }
  
  public TestPlayerTecService(BroadcastFrameworkImplementation broadcastFramework) {
    LOGGER.setLevel(Level.SEVERE);
    LOGGER.info("Creating TestPlayerTecService");
    this.broadcastFramework = broadcastFramework;
    if (broadcastFramework != null) {
      myServiceComponentId = broadcastFramework.registerApplicationServer(ApplicationId.TEC.getAid(), CONTENT_ID, null, this);
    }
  }
  
  public void stopServer() {
    broadcastFramework.unregisterApplicationServer(myServiceComponentId);
  }

  private static OLRLocationReference createOlrLocationReference1() {
    // create OpenLR location reference.
    byte[] locationData = {
            (byte) 0x0a, (byte) 0x03, (byte) 0xa2, (byte) 0x60,
            (byte) 0x25, (byte) 0x0c, (byte) 0xa0, (byte) 0x13,
            (byte) 0x56, (byte) 0x02, (byte) 0xff, (byte) 0x4f,
            (byte) 0xff, (byte) 0xe3, (byte) 0x12, (byte) 0x06};
    OLRLocationReference olrLocationReference = FACTORY.createOLRLocationReference();
    olrLocationReference.setLocationData(locationData);
    
    return olrLocationReference;
  }

  private static OLRLocationReference createOlrLocationReference1b() {
    // create OpenLR location reference.
    byte[] locationData = {
            (byte) 0x0a, (byte) 0x03, (byte) 0xa2, (byte) 0x60,
            (byte) 0x25, (byte) 0x0c, (byte) 0xa0, (byte) 0x13,
            (byte) 0x56, (byte) 0x02, (byte) 0xff, (byte) 0x4f,
            (byte) 0xff, (byte) 0xe3, (byte) 0x12, (byte) 0x06};
    OLRLocationReference olrLocationReference = FACTORY.createOLRLocationReference();
    olrLocationReference.setLocationData(locationData);
    
    return olrLocationReference;
  }

  private static OLRLocationReference createOlrLocationReference2() {
    // create OpenLR location reference.
    byte[] locationData = {
        (byte) 0x0b, (byte) 0x03, (byte) 0x9b, (byte) 0x37,
        (byte) 0x25, (byte) 0x0a, (byte) 0x87, (byte) 0x1b,
        (byte) 0x82, (byte) 0x16, (byte) 0xfd, (byte) 0xc6,
        (byte) 0x03, (byte) 0xf6, (byte) 0x23, (byte) 0x6e,
        (byte) 0x58, (byte) 0x11};
    OLRLocationReference olrLocationReference = FACTORY.createOLRLocationReference();
    olrLocationReference.setLocationData(locationData);
    
    return olrLocationReference;
  }

  @Override
  public ServiceComponentFrame getApplicationData() {
    ServCompFramePrioritisedCountedProtected serviceComponentFrame = FACTORY.createServCompFramePrioritisedCountedProtected();
//    List<TECMessage> testEvents = fixedSet;
    List<TECMessage> testEvents = testSets.get(callNumber);
    
    callNumber++;
    if (callNumber >= testSets.size()) {
      callNumber = 0;
    }
    
    serviceComponentFrame.setApplicationContent(testEvents);
    serviceComponentFrame.setDataCRC(0);  // NOTE Data CRC not filled in.
    serviceComponentFrame.setGroupPriority(0); // NOTE Group priority not filled in.
    serviceComponentFrame.setMessageCount(testEvents.size());

    StringBuilder buf = new StringBuilder();
    boolean first = true;
    buf.append("(");
    for (TECMessage tecMessage: testEvents) {
      if (!first) {
        buf.append(", ");
        first = true;
      }
      MMCSwitch mmcSwitch = tecMessage.getMmt();
      buf.append(mmcSwitch.getMessageID());
      if (mmcSwitch.isCancelFlag()) {
        buf.append(" (cancelled)");
      }
    }
    buf.append(")");
    LOGGER.info("TestPlayerTecService providing TEC events: " + buf.toString());
    return serviceComponentFrame;
  }


  private static TECMessage createTecMessage1234() {
    TECMessage tecMessage;
    MessageManagementContainer messageManagementContainer;
    Event event;
    
    tecMessage = EVENT_FACTORY.createTECMessage();
    
    messageManagementContainer = FACTORY.createMessageManagementContainer();
    messageManagementContainer.setMessageID(1234);
    tecMessage.setMmt(messageManagementContainer);
    
    event = EVENT_FACTORY.createEvent();
    event.setEffectCode(EffectCode.STATIONARY_TRAFFIC);
    tecMessage.setEvent(event);
    
    LocationReferencingContainer locationReferencingContainer = FACTORY.createLocationReferencingContainer();
    locationReferencingContainer.getMethod().add(olrLocationReference1);
    tecMessage.setLoc(locationReferencingContainer);
    
    return tecMessage;
  }

  private static TECMessage createTecCancelMessage1234() {
    TECMessage tecMessage;
    MessageManagementContainer messageManagementContainer;
    
    tecMessage = EVENT_FACTORY.createTECMessage();
    
    messageManagementContainer = FACTORY.createMessageManagementContainer();
    messageManagementContainer.setMessageID(1234);
    messageManagementContainer.setCancelFlag(true);
    tecMessage.setMmt(messageManagementContainer);
    
    return tecMessage;
  }

  private static TECMessage createTecMessage4567() {
    TECMessage tecMessage;
    MessageManagementContainer messageManagementContainer;
    Event event;
    DirectCause directCause;
    LocalisedShortString freeText;
    VehicleRestriction vehicleRestriction;
    VehicleRelatedRestriction vehicleRelatedRestriction;
    LocationReferencingContainer locationReferencingContainer;
    
    tecMessage = EVENT_FACTORY.createTECMessage();
    
    messageManagementContainer = FACTORY.createMessageManagementContainer();
    messageManagementContainer.setMessageID(4567);
    tecMessage.setMmt(messageManagementContainer);
    
    event = EVENT_FACTORY.createEvent();
    event.setEffectCode(EffectCode.HEAVY_TRAFFIC);
    Calendar calendar = new GregorianCalendar();
    calendar.add(Calendar.DATE, 3);
    calendar.add(Calendar.HOUR, 1);
    event.setStartTime(calendar.getTime());
    calendar.add(Calendar.HOUR, 2);
    event.setStopTime(calendar.getTime());
    event.setTendency(Tendency.SLIGHTLY_INCREASING);
    event.setLengthAffected(3400);
    event.setAverageSpeedAbsolute(10);
    event.setSegmentSpeedLimit(22);
    event.setExpectedSpeedAbsolute(12);
    directCause = EVENT_FACTORY.createDirectCause();
    directCause.setWarningLevel(WarningLevel.DANGER_LEVEL_2);
    directCause.setUnverifiedInformation(true);
    directCause.setMainCause(CauseCode.SLOW_MOVING_VEHICLES);
    directCause.setSubCause(SlowMovingVehicles.SLOW_MOVING_MAINTENANCE_VEHICLE);
    directCause.setLengthAffected(5000);
    directCause.setLaneRestrictionType(LaneRestrictionType.LEFT_LANES_CLOSED);
    directCause.setNumberOfLanes(2);
    freeText = FACTORY.createLocalisedShortString();
    freeText.setLanguageCode(LanguageCode.FRENCH.getCode());
    freeText.setString("ces véhicules sont de couleur rouge");
    directCause.getFreeText().add(freeText);
    freeText = FACTORY.createLocalisedShortString();
    freeText.setLanguageCode(LanguageCode.ENGLISH.getCode());
    freeText.setString("The vehicles are red");
    directCause.getFreeText().add(freeText);
    freeText = FACTORY.createLocalisedShortString();
    freeText.setLanguageCode(LanguageCode.GERMAN.getCode());
    freeText.setString("Die Fahrzeuge sind rot");
    directCause.getFreeText().add(freeText);
    event.getCause().add(directCause);
    directCause = EVENT_FACTORY.createDirectCause();
    directCause.setWarningLevel(WarningLevel.DANGER_LEVEL_1);
    directCause.setMainCause(CauseCode.VISIBILITY_REDUCED);
    directCause.setSubCause(VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_LOW_SUN_GLARE);
    event.getCause().add(directCause);
    vehicleRestriction = EVENT_FACTORY.createVehicleRestriction();
    vehicleRestriction.setVehicleType(VehicleType.LORRY);
    vehicleRelatedRestriction = EVENT_FACTORY.createVehicleRelatedRestriction();
    vehicleRelatedRestriction.setRestrictionType(RestrictionType.AXLE_LOAD_GREATER_THAN);
    vehicleRelatedRestriction.setRestrictionValue(5000);
    vehicleRestriction.getRestriction().add(vehicleRelatedRestriction);
    vehicleRelatedRestriction = EVENT_FACTORY.createVehicleRelatedRestriction();
    vehicleRelatedRestriction.setRestrictionType(RestrictionType.WIDTH_GREATER_THAN);
    vehicleRelatedRestriction.setRestrictionValue(260);
    vehicleRestriction.getRestriction().add(vehicleRelatedRestriction);
    event.getVehicleRestriction().add(vehicleRestriction);
    vehicleRestriction = EVENT_FACTORY.createVehicleRestriction();
    vehicleRestriction.setVehicleType(VehicleType.VEHICLE_WITH_TRAILER);
    event.getVehicleRestriction().add(vehicleRestriction);
    tecMessage.setEvent(event);
    
    locationReferencingContainer = FACTORY.createLocationReferencingContainer();
    locationReferencingContainer.getMethod().add(olrLocationReference2);
    tecMessage.setLoc(locationReferencingContainer);
    
    return tecMessage;
  }
  
  private static TECMessage createTecCancelMessage4567() {
    TECMessage tecMessage;
    MessageManagementContainer messageManagementContainer;
    
    tecMessage = EVENT_FACTORY.createTECMessage();
    
    messageManagementContainer = FACTORY.createMessageManagementContainer();
    messageManagementContainer.setMessageID(4567);
    messageManagementContainer.setCancelFlag(true);
    tecMessage.setMmt(messageManagementContainer);
    
    return tecMessage;
  }

  private static TECMessage createTecMessage7878() {
    TECMessage tecMessage;
    MessageManagementContainer messageManagementContainer;
    Event event;
    DirectCause directCause;
    Advice advice;
    LocationReferencingContainer locationReferencingContainer;
    
    tecMessage = EVENT_FACTORY.createTECMessage();

    messageManagementContainer = FACTORY.createMessageManagementContainer();
    messageManagementContainer.setMessageID(7878);
    tecMessage.setMmt(messageManagementContainer);
    
    event = EVENT_FACTORY.createEvent();
    event.setEffectCode(EffectCode.NO_TRAFFIC_FLOW);
    tecMessage.setEvent(event);
    directCause = EVENT_FACTORY.createDirectCause();
    directCause.setWarningLevel(WarningLevel.DANGER_LEVEL_3);
    directCause.setMainCause(CauseCode.FIRE);
    directCause.setLengthAffected(9000);
    event.getCause().add(directCause);
    advice = EVENT_FACTORY.createAdvice();
    advice.setAdviceCode(AdviceCode.DO_NOT_LEAVE_YOUR_VEHICLE);
    advice.setSubAdviceCode(DoNotLeaveYourVehicle.DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS);
    event.getAdvice().add(advice);
    advice = EVENT_FACTORY.createAdvice();
    advice.setAdviceCode(AdviceCode.DRIVING_NOT_ALLOWED);
    event.getAdvice().add(advice);
    advice = EVENT_FACTORY.createAdvice();
    advice.setAdviceCode(AdviceCode.SWITCH_ON_RADIO);
    event.getAdvice().add(advice);
    
    locationReferencingContainer = FACTORY.createLocationReferencingContainer();
    locationReferencingContainer.getMethod().add(olrLocationReference1b);
    tecMessage.setLoc(locationReferencingContainer);
    
    return tecMessage;
  }
  
  private static TECMessage createTecCancelMessage7878() {
    TECMessage tecMessage;
    MessageManagementContainer messageManagementContainer;
    
    tecMessage = EVENT_FACTORY.createTECMessage();
    
    messageManagementContainer = FACTORY.createMessageManagementContainer();
    messageManagementContainer.setMessageID(7878);
    messageManagementContainer.setCancelFlag(true);
    tecMessage.setMmt(messageManagementContainer);
    
    return tecMessage;
  }

  private static void createTestSet1(List<List<TECMessage>> testSets) {
    List<TECMessage> testEvents = new ArrayList<TECMessage>();
    testEvents.add(message1234);
    testSets.add(testEvents);
  }

  private static void createTestSet2(List<List<TECMessage>> testSets) {
    List<TECMessage> testEvents = new ArrayList<TECMessage>();
    testEvents.add(cancelMessage1234);
    testEvents.add(message4567);
    testSets.add(testEvents);
  }

  private static void createTestSet3(List<List<TECMessage>> testSets) {
    List<TECMessage> testEvents = new ArrayList<TECMessage>();
    testEvents.add(message7878);
    testSets.add(testEvents);
  }

  private static void createTestSet4(List<List<TECMessage>> testSets) {
    List<TECMessage> testEvents = new ArrayList<TECMessage>();
    testEvents.add(cancelMessage4567);
    testEvents.add(cancelMessage7878);
    testSets.add(testEvents);
  }
  
}
