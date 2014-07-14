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
 * A representation of the literals of the enumeration '<em><b>Advice Code</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getAdviceCode()
 * @model
 * @generated
 */
public enum AdviceCode implements Enumerator {
  /**
	 * The '<em><b>DRIVE TO NEXT AVAILABLE PARKING PLACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE_VALUE
	 * @generated
	 * @ordered
	 */
  DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE(1, "DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE", "DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE"),

  /**
	 * The '<em><b>OVERTAKING NOT ALLOWED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #OVERTAKING_NOT_ALLOWED_VALUE
	 * @generated
	 * @ordered
	 */
  OVERTAKING_NOT_ALLOWED(2, "OVERTAKING_NOT_ALLOWED", "OVERTAKING_NOT_ALLOWED"),

  /**
	 * The '<em><b>DRIVING NOT ALLOWED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DRIVING_NOT_ALLOWED_VALUE
	 * @generated
	 * @ordered
	 */
  DRIVING_NOT_ALLOWED(3, "DRIVING_NOT_ALLOWED", "DRIVING_NOT_ALLOWED"),

  /**
	 * The '<em><b>USE HARD SHOULDER AS LANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #USE_HARD_SHOULDER_AS_LANE_VALUE
	 * @generated
	 * @ordered
	 */
  USE_HARD_SHOULDER_AS_LANE(4, "USE_HARD_SHOULDER_AS_LANE", "USE_HARD_SHOULDER_AS_LANE"),

  /**
	 * The '<em><b>WAIT FOR POLICE PATROL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WAIT_FOR_POLICE_PATROL_VALUE
	 * @generated
	 * @ordered
	 */
  WAIT_FOR_POLICE_PATROL(5, "WAIT_FOR_POLICE_PATROL", "WAIT_FOR_POLICE_PATROL"),

  /**
	 * The '<em><b>WAIT FOR IMPROVED WEATHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WAIT_FOR_IMPROVED_WEATHER_VALUE
	 * @generated
	 * @ordered
	 */
  WAIT_FOR_IMPROVED_WEATHER(6, "WAIT_FOR_IMPROVED_WEATHER", "WAIT_FOR_IMPROVED_WEATHER"),

  /**
	 * The '<em><b>GIVING PATH VEHICLES COMING FROM BEHIND</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #GIVING_PATH_VEHICLES_COMING_FROM_BEHIND_VALUE
	 * @generated
	 * @ordered
	 */
  GIVING_PATH_VEHICLES_COMING_FROM_BEHIND(7, "GIVING_PATH_VEHICLES_COMING_FROM_BEHIND", "GIVING_PATH_VEHICLES_COMING_FROM_BEHIND"),

  /**
	 * The '<em><b>FOLLOW DIVERSION</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #FOLLOW_DIVERSION_VALUE
	 * @generated
	 * @ordered
	 */
  FOLLOW_DIVERSION(8, "FOLLOW_DIVERSION", "FOLLOW_DIVERSION"),

  /**
	 * The '<em><b>NO DIVERSION TO RECOMMEND</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #NO_DIVERSION_TO_RECOMMEND_VALUE
	 * @generated
	 * @ordered
	 */
  NO_DIVERSION_TO_RECOMMEND(9, "NO_DIVERSION_TO_RECOMMEND", "NO_DIVERSION_TO_RECOMMEND"),

  /**
	 * The '<em><b>DO NOT DIVERT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DO_NOT_DIVERT_VALUE
	 * @generated
	 * @ordered
	 */
  DO_NOT_DIVERT(10, "DO_NOT_DIVERT", "DO_NOT_DIVERT"),

  /**
	 * The '<em><b>FOLLOW POLICE INSTRUCTIONS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #FOLLOW_POLICE_INSTRUCTIONS_VALUE
	 * @generated
	 * @ordered
	 */
  FOLLOW_POLICE_INSTRUCTIONS(11, "FOLLOW_POLICE_INSTRUCTIONS", "FOLLOW_POLICE_INSTRUCTIONS"),

  /**
	 * The '<em><b>AVOID THE AREA</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #AVOID_THE_AREA_VALUE
	 * @generated
	 * @ordered
	 */
  AVOID_THE_AREA(12, "AVOID_THE_AREA", "AVOID_THE_AREA"),

  /**
	 * The '<em><b>DRIVE CAREFULLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DRIVE_CAREFULLY_VALUE
	 * @generated
	 * @ordered
	 */
  DRIVE_CAREFULLY(13, "DRIVE_CAREFULLY", "DRIVE_CAREFULLY"),

  /**
	 * The '<em><b>DO NOT LEAVE YOUR VEHICLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DO_NOT_LEAVE_YOUR_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
  DO_NOT_LEAVE_YOUR_VEHICLE(14, "DO_NOT_LEAVE_YOUR_VEHICLE", "DO_NOT_LEAVE_YOUR_VEHICLE"),

  /**
	 * The '<em><b>SWITCH ON RADIO</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SWITCH_ON_RADIO_VALUE
	 * @generated
	 * @ordered
	 */
  SWITCH_ON_RADIO(15, "SWITCH_ON_RADIO", "SWITCH_ON_RADIO"),

  /**
	 * The '<em><b>USE TOLL LANES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #USE_TOLL_LANES_VALUE
	 * @generated
	 * @ordered
	 */
  USE_TOLL_LANES(16, "USE_TOLL_LANES", "USE_TOLL_LANES"),

  /**
	 * The '<em><b>WAIT FOR CONVOI</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WAIT_FOR_CONVOI_VALUE
	 * @generated
	 * @ordered
	 */
  WAIT_FOR_CONVOI(17, "WAIT_FOR_CONVOI", "WAIT_FOR_CONVOI"),

  /**
	 * The '<em><b>UNDECODABLE ADVICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #UNDECODABLE_ADVICE_VALUE
	 * @generated
	 * @ordered
	 */
  UNDECODABLE_ADVICE(255, "UNDECODABLE_ADVICE", "UNDECODABLE_ADVICE");

  /**
	 * The '<em><b>DRIVE TO NEXT AVAILABLE PARKING PLACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DRIVE TO NEXT AVAILABLE PARKING PLACE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE_VALUE = 1;

  /**
	 * The '<em><b>OVERTAKING NOT ALLOWED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OVERTAKING NOT ALLOWED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #OVERTAKING_NOT_ALLOWED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int OVERTAKING_NOT_ALLOWED_VALUE = 2;

  /**
	 * The '<em><b>DRIVING NOT ALLOWED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DRIVING NOT ALLOWED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DRIVING_NOT_ALLOWED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DRIVING_NOT_ALLOWED_VALUE = 3;

  /**
	 * The '<em><b>USE HARD SHOULDER AS LANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>USE HARD SHOULDER AS LANE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #USE_HARD_SHOULDER_AS_LANE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int USE_HARD_SHOULDER_AS_LANE_VALUE = 4;

  /**
	 * The '<em><b>WAIT FOR POLICE PATROL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WAIT FOR POLICE PATROL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WAIT_FOR_POLICE_PATROL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WAIT_FOR_POLICE_PATROL_VALUE = 5;

  /**
	 * The '<em><b>WAIT FOR IMPROVED WEATHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WAIT FOR IMPROVED WEATHER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WAIT_FOR_IMPROVED_WEATHER
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WAIT_FOR_IMPROVED_WEATHER_VALUE = 6;

  /**
	 * The '<em><b>GIVING PATH VEHICLES COMING FROM BEHIND</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GIVING PATH VEHICLES COMING FROM BEHIND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #GIVING_PATH_VEHICLES_COMING_FROM_BEHIND
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int GIVING_PATH_VEHICLES_COMING_FROM_BEHIND_VALUE = 7;

  /**
	 * The '<em><b>FOLLOW DIVERSION</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FOLLOW DIVERSION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #FOLLOW_DIVERSION
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int FOLLOW_DIVERSION_VALUE = 8;

  /**
	 * The '<em><b>NO DIVERSION TO RECOMMEND</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NO DIVERSION TO RECOMMEND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #NO_DIVERSION_TO_RECOMMEND
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int NO_DIVERSION_TO_RECOMMEND_VALUE = 9;

  /**
	 * The '<em><b>DO NOT DIVERT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DO NOT DIVERT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DO_NOT_DIVERT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DO_NOT_DIVERT_VALUE = 10;

  /**
	 * The '<em><b>FOLLOW POLICE INSTRUCTIONS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FOLLOW POLICE INSTRUCTIONS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #FOLLOW_POLICE_INSTRUCTIONS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int FOLLOW_POLICE_INSTRUCTIONS_VALUE = 11;

  /**
	 * The '<em><b>AVOID THE AREA</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AVOID THE AREA</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #AVOID_THE_AREA
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int AVOID_THE_AREA_VALUE = 12;

  /**
	 * The '<em><b>DRIVE CAREFULLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DRIVE CAREFULLY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DRIVE_CAREFULLY
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DRIVE_CAREFULLY_VALUE = 13;

  /**
	 * The '<em><b>DO NOT LEAVE YOUR VEHICLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DO NOT LEAVE YOUR VEHICLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DO_NOT_LEAVE_YOUR_VEHICLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DO_NOT_LEAVE_YOUR_VEHICLE_VALUE = 14;

  /**
	 * The '<em><b>SWITCH ON RADIO</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SWITCH ON RADIO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SWITCH_ON_RADIO
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SWITCH_ON_RADIO_VALUE = 15;

  /**
	 * The '<em><b>USE TOLL LANES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>USE TOLL LANES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #USE_TOLL_LANES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int USE_TOLL_LANES_VALUE = 16;

  /**
	 * The '<em><b>WAIT FOR CONVOI</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WAIT FOR CONVOI</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WAIT_FOR_CONVOI
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WAIT_FOR_CONVOI_VALUE = 17;

  /**
	 * The '<em><b>UNDECODABLE ADVICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNDECODABLE ADVICE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #UNDECODABLE_ADVICE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int UNDECODABLE_ADVICE_VALUE = 255;

  /**
	 * An array of all the '<em><b>Advice Code</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final AdviceCode[] VALUES_ARRAY =
    new AdviceCode[] {
			DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE,
			OVERTAKING_NOT_ALLOWED,
			DRIVING_NOT_ALLOWED,
			USE_HARD_SHOULDER_AS_LANE,
			WAIT_FOR_POLICE_PATROL,
			WAIT_FOR_IMPROVED_WEATHER,
			GIVING_PATH_VEHICLES_COMING_FROM_BEHIND,
			FOLLOW_DIVERSION,
			NO_DIVERSION_TO_RECOMMEND,
			DO_NOT_DIVERT,
			FOLLOW_POLICE_INSTRUCTIONS,
			AVOID_THE_AREA,
			DRIVE_CAREFULLY,
			DO_NOT_LEAVE_YOUR_VEHICLE,
			SWITCH_ON_RADIO,
			USE_TOLL_LANES,
			WAIT_FOR_CONVOI,
			UNDECODABLE_ADVICE,
		};

  /**
	 * A public read-only list of all the '<em><b>Advice Code</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<AdviceCode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Advice Code</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static AdviceCode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AdviceCode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Advice Code</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static AdviceCode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AdviceCode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Advice Code</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static AdviceCode get(int value) {
		switch (value) {
			case DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE_VALUE: return DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE;
			case OVERTAKING_NOT_ALLOWED_VALUE: return OVERTAKING_NOT_ALLOWED;
			case DRIVING_NOT_ALLOWED_VALUE: return DRIVING_NOT_ALLOWED;
			case USE_HARD_SHOULDER_AS_LANE_VALUE: return USE_HARD_SHOULDER_AS_LANE;
			case WAIT_FOR_POLICE_PATROL_VALUE: return WAIT_FOR_POLICE_PATROL;
			case WAIT_FOR_IMPROVED_WEATHER_VALUE: return WAIT_FOR_IMPROVED_WEATHER;
			case GIVING_PATH_VEHICLES_COMING_FROM_BEHIND_VALUE: return GIVING_PATH_VEHICLES_COMING_FROM_BEHIND;
			case FOLLOW_DIVERSION_VALUE: return FOLLOW_DIVERSION;
			case NO_DIVERSION_TO_RECOMMEND_VALUE: return NO_DIVERSION_TO_RECOMMEND;
			case DO_NOT_DIVERT_VALUE: return DO_NOT_DIVERT;
			case FOLLOW_POLICE_INSTRUCTIONS_VALUE: return FOLLOW_POLICE_INSTRUCTIONS;
			case AVOID_THE_AREA_VALUE: return AVOID_THE_AREA;
			case DRIVE_CAREFULLY_VALUE: return DRIVE_CAREFULLY;
			case DO_NOT_LEAVE_YOUR_VEHICLE_VALUE: return DO_NOT_LEAVE_YOUR_VEHICLE;
			case SWITCH_ON_RADIO_VALUE: return SWITCH_ON_RADIO;
			case USE_TOLL_LANES_VALUE: return USE_TOLL_LANES;
			case WAIT_FOR_CONVOI_VALUE: return WAIT_FOR_CONVOI;
			case UNDECODABLE_ADVICE_VALUE: return UNDECODABLE_ADVICE;
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
  private AdviceCode(int value, String name, String literal) {
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
  
} //AdviceCode
