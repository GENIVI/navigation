/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Cause Code</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getCauseCode()
 * @model
 * @generated
 */
public enum CauseCode implements Enumerator {
	/**
	 * The '<em><b>TRAFFIC CONGESTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRAFFIC_CONGESTION_VALUE
	 * @generated
	 * @ordered
	 */
	TRAFFIC_CONGESTION(1, "TRAFFIC_CONGESTION", "TRAFFIC_CONGESTION"),

	/**
	 * The '<em><b>ACCIDENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCIDENT_VALUE
	 * @generated
	 * @ordered
	 */
	ACCIDENT(2, "ACCIDENT", "ACCIDENT"),

	/**
	 * The '<em><b>ROADWORKS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROADWORKS_VALUE
	 * @generated
	 * @ordered
	 */
	ROADWORKS(3, "ROADWORKS", "ROADWORKS"),

	/**
	 * The '<em><b>NARROW LANES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NARROW_LANES_VALUE
	 * @generated
	 * @ordered
	 */
	NARROW_LANES(4, "NARROW_LANES", "NARROW_LANES"),

	/**
	 * The '<em><b>IMPASSIBILITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPASSIBILITY_VALUE
	 * @generated
	 * @ordered
	 */
	IMPASSIBILITY(5, "IMPASSIBILITY", "IMPASSIBILITY"),

	/**
	 * The '<em><b>SLIPPERY ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIPPERY_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
	SLIPPERY_ROAD(6, "SLIPPERY_ROAD", "SLIPPERY_ROAD"),

	/**
	 * The '<em><b>AQUAPLANING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AQUAPLANING_VALUE
	 * @generated
	 * @ordered
	 */
	AQUAPLANING(7, "AQUAPLANING", "AQUAPLANING"),

	/**
	 * The '<em><b>FIRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRE_VALUE
	 * @generated
	 * @ordered
	 */
	FIRE(8, "FIRE", "FIRE"),

	/**
	 * The '<em><b>HAZARDOUS DRIVING CONDITIONS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HAZARDOUS_DRIVING_CONDITIONS_VALUE
	 * @generated
	 * @ordered
	 */
	HAZARDOUS_DRIVING_CONDITIONS(9, "HAZARDOUS_DRIVING_CONDITIONS", "HAZARDOUS_DRIVING_CONDITIONS"),

	/**
	 * The '<em><b>OBJECTS ON THE ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBJECTS_ON_THE_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
	OBJECTS_ON_THE_ROAD(10, "OBJECTS_ON_THE_ROAD", "OBJECTS_ON_THE_ROAD"),

	/**
	 * The '<em><b>ANIMALS ON ROADWAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANIMALS_ON_ROADWAY_VALUE
	 * @generated
	 * @ordered
	 */
	ANIMALS_ON_ROADWAY(11, "ANIMALS_ON_ROADWAY", "ANIMALS_ON_ROADWAY"),

	/**
	 * The '<em><b>PEOPLE ON ROADWAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PEOPLE_ON_ROADWAY_VALUE
	 * @generated
	 * @ordered
	 */
	PEOPLE_ON_ROADWAY(12, "PEOPLE_ON_ROADWAY", "PEOPLE_ON_ROADWAY"),

	/**
	 * The '<em><b>BROKEN DOWN VEHICLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BROKEN_DOWN_VEHICLES_VALUE
	 * @generated
	 * @ordered
	 */
	BROKEN_DOWN_VEHICLES(13, "BROKEN_DOWN_VEHICLES", "BROKEN_DOWN_VEHICLES"),

	/**
	 * The '<em><b>VEHICLE ON WRONG CARRIAGEWAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLE_ON_WRONG_CARRIAGEWAY_VALUE
	 * @generated
	 * @ordered
	 */
	VEHICLE_ON_WRONG_CARRIAGEWAY(14, "VEHICLE_ON_WRONG_CARRIAGEWAY", "VEHICLE_ON_WRONG_CARRIAGEWAY"),

	/**
	 * The '<em><b>RESCUE AND RECOVERY WORK IN PROGRESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESCUE_AND_RECOVERY_WORK_IN_PROGRESS_VALUE
	 * @generated
	 * @ordered
	 */
	RESCUE_AND_RECOVERY_WORK_IN_PROGRESS(15, "RESCUE_AND_RECOVERY_WORK_IN_PROGRESS", "RESCUE_AND_RECOVERY_WORK_IN_PROGRESS"),

	/**
	 * The '<em><b>REGULATORY MEASURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGULATORY_MEASURE_VALUE
	 * @generated
	 * @ordered
	 */
	REGULATORY_MEASURE(16, "REGULATORY_MEASURE", "REGULATORY_MEASURE"),

	/**
	 * The '<em><b>EXTREME WEATHER CONDITIONS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXTREME_WEATHER_CONDITIONS_VALUE
	 * @generated
	 * @ordered
	 */
	EXTREME_WEATHER_CONDITIONS(17, "EXTREME_WEATHER_CONDITIONS", "EXTREME_WEATHER_CONDITIONS"),

	/**
	 * The '<em><b>VISIBILITY REDUCED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VISIBILITY_REDUCED_VALUE
	 * @generated
	 * @ordered
	 */
	VISIBILITY_REDUCED(18, "VISIBILITY_REDUCED", "VISIBILITY_REDUCED"),

	/**
	 * The '<em><b>PRECIPITATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRECIPITATION_VALUE
	 * @generated
	 * @ordered
	 */
	PRECIPITATION(19, "PRECIPITATION", "PRECIPITATION"),

	/**
	 * The '<em><b>RECKLESS PERSONS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECKLESS_PERSONS_VALUE
	 * @generated
	 * @ordered
	 */
	RECKLESS_PERSONS(20, "RECKLESS_PERSONS", "RECKLESS_PERSONS"),

	/**
	 * The '<em><b>OVER HEIGHT WARNING SYSTEM TRIGGERED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED_VALUE
	 * @generated
	 * @ordered
	 */
	OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED(21, "OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED", "OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED"),

	/**
	 * The '<em><b>TRAFFIC REGULATIONS CHANGED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRAFFIC_REGULATIONS_CHANGED_VALUE
	 * @generated
	 * @ordered
	 */
	TRAFFIC_REGULATIONS_CHANGED(22, "TRAFFIC_REGULATIONS_CHANGED", "TRAFFIC_REGULATIONS_CHANGED"),

	/**
	 * The '<em><b>MAJOR EVENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAJOR_EVENT_VALUE
	 * @generated
	 * @ordered
	 */
	MAJOR_EVENT(23, "MAJOR_EVENT", "MAJOR_EVENT"),

	/**
	 * The '<em><b>SERVICE NOT OPERATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERVICE_NOT_OPERATING_VALUE
	 * @generated
	 * @ordered
	 */
	SERVICE_NOT_OPERATING(24, "SERVICE_NOT_OPERATING", "SERVICE_NOT_OPERATING"),

	/**
	 * The '<em><b>SERVICE NOT USEABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERVICE_NOT_USEABLE_VALUE
	 * @generated
	 * @ordered
	 */
	SERVICE_NOT_USEABLE(25, "SERVICE_NOT_USEABLE", "SERVICE_NOT_USEABLE"),

	/**
	 * The '<em><b>SLOW MOVING VEHICLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLOW_MOVING_VEHICLES_VALUE
	 * @generated
	 * @ordered
	 */
	SLOW_MOVING_VEHICLES(26, "SLOW_MOVING_VEHICLES", "SLOW_MOVING_VEHICLES"),

	/**
	 * The '<em><b>DANGEROUS END OF QUEUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DANGEROUS_END_OF_QUEUE_VALUE
	 * @generated
	 * @ordered
	 */
	DANGEROUS_END_OF_QUEUE(27, "DANGEROUS_END_OF_QUEUE", "DANGEROUS_END_OF_QUEUE"),

	/**
	 * The '<em><b>RISK OF FIRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RISK_OF_FIRE_VALUE
	 * @generated
	 * @ordered
	 */
	RISK_OF_FIRE(28, "RISK_OF_FIRE", "RISK_OF_FIRE"),

	/**
	 * The '<em><b>TIME DELAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIME_DELAY_VALUE
	 * @generated
	 * @ordered
	 */
	TIME_DELAY(29, "TIME_DELAY", "TIME_DELAY"),

	/**
	 * The '<em><b>POLICE CHECKPOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POLICE_CHECKPOINT_VALUE
	 * @generated
	 * @ordered
	 */
	POLICE_CHECKPOINT(30, "POLICE_CHECKPOINT", "POLICE_CHECKPOINT"),

	/**
	 * The '<em><b>MALFUNCTIONING ROADSIDE EQUIPMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MALFUNCTIONING_ROADSIDE_EQUIPMENT_VALUE
	 * @generated
	 * @ordered
	 */
	MALFUNCTIONING_ROADSIDE_EQUIPMENT(31, "MALFUNCTIONING_ROADSIDE_EQUIPMENT", "MALFUNCTIONING_ROADSIDE_EQUIPMENT"), /**
	 * The '<em><b>TEST MESSAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TEST_MESSAGE_VALUE
	 * @generated
	 * @ordered
	 */
  TEST_MESSAGE(100, "TEST_MESSAGE", "TEST_MESSAGE"), /**
	 * The '<em><b>UNDECODABLE CAUSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #UNDECODABLE_CAUSE_VALUE
	 * @generated
	 * @ordered
	 */
  UNDECODABLE_CAUSE(255, "UNDECODABLE_CAUSE", "UNDECODABLE_CAUSE");

	/**
	 * The '<em><b>TRAFFIC CONGESTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRAFFIC CONGESTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRAFFIC_CONGESTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRAFFIC_CONGESTION_VALUE = 1;

	/**
	 * The '<em><b>ACCIDENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACCIDENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCIDENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACCIDENT_VALUE = 2;

	/**
	 * The '<em><b>ROADWORKS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROADWORKS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROADWORKS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROADWORKS_VALUE = 3;

	/**
	 * The '<em><b>NARROW LANES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NARROW LANES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NARROW_LANES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NARROW_LANES_VALUE = 4;

	/**
	 * The '<em><b>IMPASSIBILITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IMPASSIBILITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMPASSIBILITY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IMPASSIBILITY_VALUE = 5;

	/**
	 * The '<em><b>SLIPPERY ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIPPERY ROAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIPPERY_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIPPERY_ROAD_VALUE = 6;

	/**
	 * The '<em><b>AQUAPLANING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AQUAPLANING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AQUAPLANING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AQUAPLANING_VALUE = 7;

	/**
	 * The '<em><b>FIRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIRE_VALUE = 8;

	/**
	 * The '<em><b>HAZARDOUS DRIVING CONDITIONS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HAZARDOUS DRIVING CONDITIONS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HAZARDOUS_DRIVING_CONDITIONS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HAZARDOUS_DRIVING_CONDITIONS_VALUE = 9;

	/**
	 * The '<em><b>OBJECTS ON THE ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OBJECTS ON THE ROAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OBJECTS_ON_THE_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OBJECTS_ON_THE_ROAD_VALUE = 10;

	/**
	 * The '<em><b>ANIMALS ON ROADWAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANIMALS ON ROADWAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANIMALS_ON_ROADWAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANIMALS_ON_ROADWAY_VALUE = 11;

	/**
	 * The '<em><b>PEOPLE ON ROADWAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PEOPLE ON ROADWAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PEOPLE_ON_ROADWAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PEOPLE_ON_ROADWAY_VALUE = 12;

	/**
	 * The '<em><b>BROKEN DOWN VEHICLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BROKEN DOWN VEHICLES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BROKEN_DOWN_VEHICLES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BROKEN_DOWN_VEHICLES_VALUE = 13;

	/**
	 * The '<em><b>VEHICLE ON WRONG CARRIAGEWAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VEHICLE ON WRONG CARRIAGEWAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VEHICLE_ON_WRONG_CARRIAGEWAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEHICLE_ON_WRONG_CARRIAGEWAY_VALUE = 14;

	/**
	 * The '<em><b>RESCUE AND RECOVERY WORK IN PROGRESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RESCUE AND RECOVERY WORK IN PROGRESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESCUE_AND_RECOVERY_WORK_IN_PROGRESS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RESCUE_AND_RECOVERY_WORK_IN_PROGRESS_VALUE = 15;

	/**
	 * The '<em><b>REGULATORY MEASURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REGULATORY MEASURE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REGULATORY_MEASURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REGULATORY_MEASURE_VALUE = 16;

	/**
	 * The '<em><b>EXTREME WEATHER CONDITIONS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXTREME WEATHER CONDITIONS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXTREME_WEATHER_CONDITIONS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXTREME_WEATHER_CONDITIONS_VALUE = 17;

	/**
	 * The '<em><b>VISIBILITY REDUCED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VISIBILITY REDUCED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VISIBILITY_REDUCED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VISIBILITY_REDUCED_VALUE = 18;

	/**
	 * The '<em><b>PRECIPITATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRECIPITATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRECIPITATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRECIPITATION_VALUE = 19;

	/**
	 * The '<em><b>RECKLESS PERSONS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RECKLESS PERSONS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECKLESS_PERSONS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RECKLESS_PERSONS_VALUE = 20;

	/**
	 * The '<em><b>OVER HEIGHT WARNING SYSTEM TRIGGERED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVER HEIGHT WARNING SYSTEM TRIGGERED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED_VALUE = 21;

	/**
	 * The '<em><b>TRAFFIC REGULATIONS CHANGED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRAFFIC REGULATIONS CHANGED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRAFFIC_REGULATIONS_CHANGED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRAFFIC_REGULATIONS_CHANGED_VALUE = 22;

	/**
	 * The '<em><b>MAJOR EVENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAJOR EVENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAJOR_EVENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAJOR_EVENT_VALUE = 23;

	/**
	 * The '<em><b>SERVICE NOT OPERATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVICE NOT OPERATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVICE_NOT_OPERATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERVICE_NOT_OPERATING_VALUE = 24;

	/**
	 * The '<em><b>SERVICE NOT USEABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVICE NOT USEABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVICE_NOT_USEABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERVICE_NOT_USEABLE_VALUE = 25;

	/**
	 * The '<em><b>SLOW MOVING VEHICLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLOW MOVING VEHICLES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLOW_MOVING_VEHICLES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLOW_MOVING_VEHICLES_VALUE = 26;

	/**
	 * The '<em><b>DANGEROUS END OF QUEUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DANGEROUS END OF QUEUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DANGEROUS_END_OF_QUEUE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DANGEROUS_END_OF_QUEUE_VALUE = 27;

	/**
	 * The '<em><b>RISK OF FIRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RISK OF FIRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RISK_OF_FIRE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RISK_OF_FIRE_VALUE = 28;

	/**
	 * The '<em><b>TIME DELAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIME DELAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIME_DELAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIME_DELAY_VALUE = 29;

	/**
	 * The '<em><b>POLICE CHECKPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POLICE CHECKPOINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POLICE_CHECKPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POLICE_CHECKPOINT_VALUE = 30;

	/**
	 * The '<em><b>MALFUNCTIONING ROADSIDE EQUIPMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MALFUNCTIONING ROADSIDE EQUIPMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MALFUNCTIONING_ROADSIDE_EQUIPMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MALFUNCTIONING_ROADSIDE_EQUIPMENT_VALUE = 31;

	/**
	 * The '<em><b>TEST MESSAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TEST MESSAGE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TEST_MESSAGE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TEST_MESSAGE_VALUE = 100;

  /**
	 * The '<em><b>UNDECODABLE CAUSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNDECODABLE CAUSE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #UNDECODABLE_CAUSE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int UNDECODABLE_CAUSE_VALUE = 255;

  /**
	 * An array of all the '<em><b>Cause Code</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CauseCode[] VALUES_ARRAY =
		new CauseCode[] {
			TRAFFIC_CONGESTION,
			ACCIDENT,
			ROADWORKS,
			NARROW_LANES,
			IMPASSIBILITY,
			SLIPPERY_ROAD,
			AQUAPLANING,
			FIRE,
			HAZARDOUS_DRIVING_CONDITIONS,
			OBJECTS_ON_THE_ROAD,
			ANIMALS_ON_ROADWAY,
			PEOPLE_ON_ROADWAY,
			BROKEN_DOWN_VEHICLES,
			VEHICLE_ON_WRONG_CARRIAGEWAY,
			RESCUE_AND_RECOVERY_WORK_IN_PROGRESS,
			REGULATORY_MEASURE,
			EXTREME_WEATHER_CONDITIONS,
			VISIBILITY_REDUCED,
			PRECIPITATION,
			RECKLESS_PERSONS,
			OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED,
			TRAFFIC_REGULATIONS_CHANGED,
			MAJOR_EVENT,
			SERVICE_NOT_OPERATING,
			SERVICE_NOT_USEABLE,
			SLOW_MOVING_VEHICLES,
			DANGEROUS_END_OF_QUEUE,
			RISK_OF_FIRE,
			TIME_DELAY,
			POLICE_CHECKPOINT,
			MALFUNCTIONING_ROADSIDE_EQUIPMENT,
			TEST_MESSAGE,
			UNDECODABLE_CAUSE,
		};

	/**
	 * A public read-only list of all the '<em><b>Cause Code</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CauseCode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Cause Code</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CauseCode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CauseCode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Cause Code</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CauseCode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CauseCode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Cause Code</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CauseCode get(int value) {
		switch (value) {
			case TRAFFIC_CONGESTION_VALUE: return TRAFFIC_CONGESTION;
			case ACCIDENT_VALUE: return ACCIDENT;
			case ROADWORKS_VALUE: return ROADWORKS;
			case NARROW_LANES_VALUE: return NARROW_LANES;
			case IMPASSIBILITY_VALUE: return IMPASSIBILITY;
			case SLIPPERY_ROAD_VALUE: return SLIPPERY_ROAD;
			case AQUAPLANING_VALUE: return AQUAPLANING;
			case FIRE_VALUE: return FIRE;
			case HAZARDOUS_DRIVING_CONDITIONS_VALUE: return HAZARDOUS_DRIVING_CONDITIONS;
			case OBJECTS_ON_THE_ROAD_VALUE: return OBJECTS_ON_THE_ROAD;
			case ANIMALS_ON_ROADWAY_VALUE: return ANIMALS_ON_ROADWAY;
			case PEOPLE_ON_ROADWAY_VALUE: return PEOPLE_ON_ROADWAY;
			case BROKEN_DOWN_VEHICLES_VALUE: return BROKEN_DOWN_VEHICLES;
			case VEHICLE_ON_WRONG_CARRIAGEWAY_VALUE: return VEHICLE_ON_WRONG_CARRIAGEWAY;
			case RESCUE_AND_RECOVERY_WORK_IN_PROGRESS_VALUE: return RESCUE_AND_RECOVERY_WORK_IN_PROGRESS;
			case REGULATORY_MEASURE_VALUE: return REGULATORY_MEASURE;
			case EXTREME_WEATHER_CONDITIONS_VALUE: return EXTREME_WEATHER_CONDITIONS;
			case VISIBILITY_REDUCED_VALUE: return VISIBILITY_REDUCED;
			case PRECIPITATION_VALUE: return PRECIPITATION;
			case RECKLESS_PERSONS_VALUE: return RECKLESS_PERSONS;
			case OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED_VALUE: return OVER_HEIGHT_WARNING_SYSTEM_TRIGGERED;
			case TRAFFIC_REGULATIONS_CHANGED_VALUE: return TRAFFIC_REGULATIONS_CHANGED;
			case MAJOR_EVENT_VALUE: return MAJOR_EVENT;
			case SERVICE_NOT_OPERATING_VALUE: return SERVICE_NOT_OPERATING;
			case SERVICE_NOT_USEABLE_VALUE: return SERVICE_NOT_USEABLE;
			case SLOW_MOVING_VEHICLES_VALUE: return SLOW_MOVING_VEHICLES;
			case DANGEROUS_END_OF_QUEUE_VALUE: return DANGEROUS_END_OF_QUEUE;
			case RISK_OF_FIRE_VALUE: return RISK_OF_FIRE;
			case TIME_DELAY_VALUE: return TIME_DELAY;
			case POLICE_CHECKPOINT_VALUE: return POLICE_CHECKPOINT;
			case MALFUNCTIONING_ROADSIDE_EQUIPMENT_VALUE: return MALFUNCTIONING_ROADSIDE_EQUIPMENT;
			case TEST_MESSAGE_VALUE: return TEST_MESSAGE;
			case UNDECODABLE_CAUSE_VALUE: return UNDECODABLE_CAUSE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CauseCode(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //CauseCode
