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
 * A representation of the literals of the enumeration '<em><b>Restriction Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getRestrictionType()
 * @model
 * @generated
 */
public enum RestrictionType implements Enumerator {
  /**
	 * The '<em><b>WIDTH LESS THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WIDTH_LESS_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  WIDTH_LESS_THAN(1, "WIDTH_LESS_THAN", "WIDTH_LESS_THAN"),

  /**
	 * The '<em><b>WIDTH GREATER THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WIDTH_GREATER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  WIDTH_GREATER_THAN(2, "WIDTH_GREATER_THAN", "WIDTH_GREATER_THAN"),

  /**
	 * The '<em><b>HEIGTH LESS THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #HEIGTH_LESS_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  HEIGTH_LESS_THAN(3, "HEIGTH_LESS_THAN", "HEIGTH_LESS_THAN"),

  /**
	 * The '<em><b>HEIGTH GREATER THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #HEIGTH_GREATER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  HEIGTH_GREATER_THAN(4, "HEIGTH_GREATER_THAN", "HEIGTH_GREATER_THAN"),

  /**
	 * The '<em><b>WEIGHT LESS THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WEIGHT_LESS_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  WEIGHT_LESS_THAN(5, "WEIGHT_LESS_THAN", "WEIGHT_LESS_THAN"),

  /**
	 * The '<em><b>WEIGHT GREATER THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WEIGHT_GREATER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  WEIGHT_GREATER_THAN(6, "WEIGHT_GREATER_THAN", "WEIGHT_GREATER_THAN"),

  /**
	 * The '<em><b>WITHOUT WINTER TYRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WITHOUT_WINTER_TYRE_VALUE
	 * @generated
	 * @ordered
	 */
  WITHOUT_WINTER_TYRE(7, "WITHOUT_WINTER_TYRE", "WITHOUT_WINTER_TYRE"),

  /**
	 * The '<em><b>WITHOUT SNOW CHAIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WITHOUT_SNOW_CHAIN_VALUE
	 * @generated
	 * @ordered
	 */
  WITHOUT_SNOW_CHAIN(8, "WITHOUT_SNOW_CHAIN", "WITHOUT_SNOW_CHAIN"),

  /**
	 * The '<em><b>WITH TRAILER</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WITH_TRAILER_VALUE
	 * @generated
	 * @ordered
	 */
  WITH_TRAILER(9, "WITH_TRAILER", "WITH_TRAILER"),

  /**
	 * The '<em><b>WITH CARAVAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WITH_CARAVAN_VALUE
	 * @generated
	 * @ordered
	 */
  WITH_CARAVAN(10, "WITH_CARAVAN", "WITH_CARAVAN"),

  /**
	 * The '<em><b>PERSONS IN VEHICLE LESS THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #PERSONS_IN_VEHICLE_LESS_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  PERSONS_IN_VEHICLE_LESS_THAN(11, "PERSONS_IN_VEHICLE_LESS_THAN", "PERSONS_IN_VEHICLE_LESS_THAN"),

  /**
	 * The '<em><b>PERSONS IN VEHICLE MORE THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #PERSONS_IN_VEHICLE_MORE_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  PERSONS_IN_VEHICLE_MORE_THAN(12, "PERSONS_IN_VEHICLE_MORE_THAN", "PERSONS_IN_VEHICLE_MORE_THAN"),

  /**
	 * The '<em><b>EVEN NUMBER PLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #EVEN_NUMBER_PLATE_VALUE
	 * @generated
	 * @ordered
	 */
  EVEN_NUMBER_PLATE(13, "EVEN_NUMBER_PLATE", "EVEN_NUMBER_PLATE"),

  /**
	 * The '<em><b>ODD NUMBER PLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ODD_NUMBER_PLATE_VALUE
	 * @generated
	 * @ordered
	 */
  ODD_NUMBER_PLATE(14, "ODD_NUMBER_PLATE", "ODD_NUMBER_PLATE"),

  /**
	 * The '<em><b>LENGTH LESS THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LENGTH_LESS_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  LENGTH_LESS_THAN(15, "LENGTH_LESS_THAN", "LENGTH_LESS_THAN"),

  /**
	 * The '<em><b>LENGTH GREATER THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LENGTH_GREATER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  LENGTH_GREATER_THAN(16, "LENGTH_GREATER_THAN", "LENGTH_GREATER_THAN"),

  /**
	 * The '<em><b>AXLE LOAD LESS THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #AXLE_LOAD_LESS_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  AXLE_LOAD_LESS_THAN(17, "AXLE_LOAD_LESS_THAN", "AXLE_LOAD_LESS_THAN"),

  /**
	 * The '<em><b>AXLE LOAD GREATER THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #AXLE_LOAD_GREATER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  AXLE_LOAD_GREATER_THAN(18, "AXLE_LOAD_GREATER_THAN", "AXLE_LOAD_GREATER_THAN"),

  /**
	 * The '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO3</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3_VALUE
	 * @generated
	 * @ordered
	 */
  VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3(19, "VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3", "VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3"),

  /**
	 * The '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO3D4</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4_VALUE
	 * @generated
	 * @ordered
	 */
  VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4(20, "VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4", "VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4"),

  /**
	 * The '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO4</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4_VALUE
	 * @generated
	 * @ordered
	 */
  VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4(21, "VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4", "VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4"),

  /**
	 * The '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO5</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5_VALUE
	 * @generated
	 * @ordered
	 */
  VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5(22, "VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5", "VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5"),

  /**
	 * The '<em><b>WITH PETROL ENGINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WITH_PETROL_ENGINE_VALUE
	 * @generated
	 * @ordered
	 */
  WITH_PETROL_ENGINE(23, "WITH_PETROL_ENGINE", "WITH_PETROL_ENGINE"),

  /**
	 * The '<em><b>WITH LPG ENGINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WITH_LPG_ENGINE_VALUE
	 * @generated
	 * @ordered
	 */
  WITH_LPG_ENGINE(25, "WITH_LPG_ENGINE", "WITH_LPG_ENGINE"),

  /**
	 * The '<em><b>WITH DIESEL ENGINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WITH_DIESEL_ENGINE_VALUE
	 * @generated
	 * @ordered
	 */
  WITH_DIESEL_ENGINE(24, "WITH_DIESEL_ENGINE", "WITH_DIESEL_ENGINE"),

  /**
	 * The '<em><b>THROUGH TRAFFIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #THROUGH_TRAFFIC_VALUE
	 * @generated
	 * @ordered
	 */
  THROUGH_TRAFFIC(26, "THROUGH_TRAFFIC", "THROUGH_TRAFFIC"),

  /**
	 * The '<em><b>RESIDENTS TRAFFIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RESIDENTS_TRAFFIC_VALUE
	 * @generated
	 * @ordered
	 */
  RESIDENTS_TRAFFIC(27, "RESIDENTS_TRAFFIC", "RESIDENTS_TRAFFIC"),

  /**
	 * The '<em><b>WITH DESTINATION IN GIVEN AREA</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WITH_DESTINATION_IN_GIVEN_AREA_VALUE
	 * @generated
	 * @ordered
	 */
  WITH_DESTINATION_IN_GIVEN_AREA(28, "WITH_DESTINATION_IN_GIVEN_AREA", "WITH_DESTINATION_IN_GIVEN_AREA"),

  /**
	 * The '<em><b>UNDECODABLE RESTRICTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #UNDECODABLE_RESTRICTION_VALUE
	 * @generated
	 * @ordered
	 */
  UNDECODABLE_RESTRICTION(255, "UNDECODABLE_RESTRICTION", "UNDECODABLE_RESTRICTION");

  /**
	 * The '<em><b>WIDTH LESS THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WIDTH LESS THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WIDTH_LESS_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WIDTH_LESS_THAN_VALUE = 1;

  /**
	 * The '<em><b>WIDTH GREATER THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WIDTH GREATER THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WIDTH_GREATER_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WIDTH_GREATER_THAN_VALUE = 2;

  /**
	 * The '<em><b>HEIGTH LESS THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HEIGTH LESS THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #HEIGTH_LESS_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int HEIGTH_LESS_THAN_VALUE = 3;

  /**
	 * The '<em><b>HEIGTH GREATER THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HEIGTH GREATER THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #HEIGTH_GREATER_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int HEIGTH_GREATER_THAN_VALUE = 4;

  /**
	 * The '<em><b>WEIGHT LESS THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WEIGHT LESS THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WEIGHT_LESS_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WEIGHT_LESS_THAN_VALUE = 5;

  /**
	 * The '<em><b>WEIGHT GREATER THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WEIGHT GREATER THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WEIGHT_GREATER_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WEIGHT_GREATER_THAN_VALUE = 6;

  /**
	 * The '<em><b>WITHOUT WINTER TYRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WITHOUT WINTER TYRE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WITHOUT_WINTER_TYRE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WITHOUT_WINTER_TYRE_VALUE = 7;

  /**
	 * The '<em><b>WITHOUT SNOW CHAIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WITHOUT SNOW CHAIN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WITHOUT_SNOW_CHAIN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WITHOUT_SNOW_CHAIN_VALUE = 8;

  /**
	 * The '<em><b>WITH TRAILER</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WITH TRAILER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WITH_TRAILER
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WITH_TRAILER_VALUE = 9;

  /**
	 * The '<em><b>WITH CARAVAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WITH CARAVAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WITH_CARAVAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WITH_CARAVAN_VALUE = 10;

  /**
	 * The '<em><b>PERSONS IN VEHICLE LESS THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PERSONS IN VEHICLE LESS THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #PERSONS_IN_VEHICLE_LESS_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int PERSONS_IN_VEHICLE_LESS_THAN_VALUE = 11;

  /**
	 * The '<em><b>PERSONS IN VEHICLE MORE THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PERSONS IN VEHICLE MORE THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #PERSONS_IN_VEHICLE_MORE_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int PERSONS_IN_VEHICLE_MORE_THAN_VALUE = 12;

  /**
	 * The '<em><b>EVEN NUMBER PLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EVEN NUMBER PLATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #EVEN_NUMBER_PLATE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int EVEN_NUMBER_PLATE_VALUE = 13;

  /**
	 * The '<em><b>ODD NUMBER PLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ODD NUMBER PLATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ODD_NUMBER_PLATE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int ODD_NUMBER_PLATE_VALUE = 14;

  /**
	 * The '<em><b>LENGTH LESS THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LENGTH LESS THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LENGTH_LESS_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LENGTH_LESS_THAN_VALUE = 15;

  /**
	 * The '<em><b>LENGTH GREATER THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LENGTH GREATER THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LENGTH_GREATER_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LENGTH_GREATER_THAN_VALUE = 16;

  /**
	 * The '<em><b>AXLE LOAD LESS THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AXLE LOAD LESS THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #AXLE_LOAD_LESS_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int AXLE_LOAD_LESS_THAN_VALUE = 17;

  /**
	 * The '<em><b>AXLE LOAD GREATER THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AXLE LOAD GREATER THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #AXLE_LOAD_GREATER_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int AXLE_LOAD_GREATER_THAN_VALUE = 18;

  /**
	 * The '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO3</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO3</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3_VALUE = 19;

  /**
	 * The '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO3D4</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO3D4</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4_VALUE = 20;

  /**
	 * The '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO4</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO4</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4_VALUE = 21;

  /**
	 * The '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO5</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VEHICLE FULFILLS EMMISSION STANDARD EURO5</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5_VALUE = 22;

  /**
	 * The '<em><b>WITH PETROL ENGINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WITH PETROL ENGINE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WITH_PETROL_ENGINE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WITH_PETROL_ENGINE_VALUE = 23;

  /**
	 * The '<em><b>WITH LPG ENGINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WITH LPG ENGINE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WITH_LPG_ENGINE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WITH_LPG_ENGINE_VALUE = 25;

  /**
	 * The '<em><b>WITH DIESEL ENGINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WITH DIESEL ENGINE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WITH_DIESEL_ENGINE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WITH_DIESEL_ENGINE_VALUE = 24;

  /**
	 * The '<em><b>THROUGH TRAFFIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>THROUGH TRAFFIC</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #THROUGH_TRAFFIC
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int THROUGH_TRAFFIC_VALUE = 26;

  /**
	 * The '<em><b>RESIDENTS TRAFFIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RESIDENTS TRAFFIC</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RESIDENTS_TRAFFIC
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int RESIDENTS_TRAFFIC_VALUE = 27;

  /**
	 * The '<em><b>WITH DESTINATION IN GIVEN AREA</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WITH DESTINATION IN GIVEN AREA</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WITH_DESTINATION_IN_GIVEN_AREA
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WITH_DESTINATION_IN_GIVEN_AREA_VALUE = 28;

  /**
	 * The '<em><b>UNDECODABLE RESTRICTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNDECODABLE RESTRICTION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #UNDECODABLE_RESTRICTION
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int UNDECODABLE_RESTRICTION_VALUE = 255;

  /**
	 * An array of all the '<em><b>Restriction Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final RestrictionType[] VALUES_ARRAY =
    new RestrictionType[] {
			WIDTH_LESS_THAN,
			WIDTH_GREATER_THAN,
			HEIGTH_LESS_THAN,
			HEIGTH_GREATER_THAN,
			WEIGHT_LESS_THAN,
			WEIGHT_GREATER_THAN,
			WITHOUT_WINTER_TYRE,
			WITHOUT_SNOW_CHAIN,
			WITH_TRAILER,
			WITH_CARAVAN,
			PERSONS_IN_VEHICLE_LESS_THAN,
			PERSONS_IN_VEHICLE_MORE_THAN,
			EVEN_NUMBER_PLATE,
			ODD_NUMBER_PLATE,
			LENGTH_LESS_THAN,
			LENGTH_GREATER_THAN,
			AXLE_LOAD_LESS_THAN,
			AXLE_LOAD_GREATER_THAN,
			VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3,
			VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4,
			VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4,
			VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5,
			WITH_PETROL_ENGINE,
			WITH_LPG_ENGINE,
			WITH_DIESEL_ENGINE,
			THROUGH_TRAFFIC,
			RESIDENTS_TRAFFIC,
			WITH_DESTINATION_IN_GIVEN_AREA,
			UNDECODABLE_RESTRICTION,
		};

  /**
	 * A public read-only list of all the '<em><b>Restriction Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<RestrictionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Restriction Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RestrictionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RestrictionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Restriction Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RestrictionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RestrictionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Restriction Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RestrictionType get(int value) {
		switch (value) {
			case WIDTH_LESS_THAN_VALUE: return WIDTH_LESS_THAN;
			case WIDTH_GREATER_THAN_VALUE: return WIDTH_GREATER_THAN;
			case HEIGTH_LESS_THAN_VALUE: return HEIGTH_LESS_THAN;
			case HEIGTH_GREATER_THAN_VALUE: return HEIGTH_GREATER_THAN;
			case WEIGHT_LESS_THAN_VALUE: return WEIGHT_LESS_THAN;
			case WEIGHT_GREATER_THAN_VALUE: return WEIGHT_GREATER_THAN;
			case WITHOUT_WINTER_TYRE_VALUE: return WITHOUT_WINTER_TYRE;
			case WITHOUT_SNOW_CHAIN_VALUE: return WITHOUT_SNOW_CHAIN;
			case WITH_TRAILER_VALUE: return WITH_TRAILER;
			case WITH_CARAVAN_VALUE: return WITH_CARAVAN;
			case PERSONS_IN_VEHICLE_LESS_THAN_VALUE: return PERSONS_IN_VEHICLE_LESS_THAN;
			case PERSONS_IN_VEHICLE_MORE_THAN_VALUE: return PERSONS_IN_VEHICLE_MORE_THAN;
			case EVEN_NUMBER_PLATE_VALUE: return EVEN_NUMBER_PLATE;
			case ODD_NUMBER_PLATE_VALUE: return ODD_NUMBER_PLATE;
			case LENGTH_LESS_THAN_VALUE: return LENGTH_LESS_THAN;
			case LENGTH_GREATER_THAN_VALUE: return LENGTH_GREATER_THAN;
			case AXLE_LOAD_LESS_THAN_VALUE: return AXLE_LOAD_LESS_THAN;
			case AXLE_LOAD_GREATER_THAN_VALUE: return AXLE_LOAD_GREATER_THAN;
			case VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3_VALUE: return VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3;
			case VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4_VALUE: return VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO3D4;
			case VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4_VALUE: return VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO4;
			case VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5_VALUE: return VEHICLE_FULFILLS_EMMISSION_STANDARD_EURO5;
			case WITH_PETROL_ENGINE_VALUE: return WITH_PETROL_ENGINE;
			case WITH_LPG_ENGINE_VALUE: return WITH_LPG_ENGINE;
			case WITH_DIESEL_ENGINE_VALUE: return WITH_DIESEL_ENGINE;
			case THROUGH_TRAFFIC_VALUE: return THROUGH_TRAFFIC;
			case RESIDENTS_TRAFFIC_VALUE: return RESIDENTS_TRAFFIC;
			case WITH_DESTINATION_IN_GIVEN_AREA_VALUE: return WITH_DESTINATION_IN_GIVEN_AREA;
			case UNDECODABLE_RESTRICTION_VALUE: return UNDECODABLE_RESTRICTION;
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
  private RestrictionType(int value, String name, String literal) {
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
  
} //RestrictionType
