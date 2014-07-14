/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidenttables;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Malfunctioning Roadside Equipment</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getMalfunctioningRoadsideEquipment()
 * @model
 * @generated
 */
public enum MalfunctioningRoadsideEquipment implements Enumerator {
  /**
	 * The '<em><b>ROAD RAIL CROSSING FAILURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ROAD_RAIL_CROSSING_FAILURE_VALUE
	 * @generated
	 * @ordered
	 */
  ROAD_RAIL_CROSSING_FAILURE(1, "ROAD_RAIL_CROSSING_FAILURE", "ROAD_RAIL_CROSSING_FAILURE"),

  /**
	 * The '<em><b>TUNNEL VENTILATION NOT WORKING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TUNNEL_VENTILATION_NOT_WORKING_VALUE
	 * @generated
	 * @ordered
	 */
  TUNNEL_VENTILATION_NOT_WORKING(2, "TUNNEL_VENTILATION_NOT_WORKING", "TUNNEL_VENTILATION_NOT_WORKING"),

  /**
	 * The '<em><b>TRAFFIC CONTROL SIGNALS WORKING INCORRECTLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY_VALUE
	 * @generated
	 * @ordered
	 */
  TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY(3, "TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY", "TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY"),

  /**
	 * The '<em><b>EMERGENCY TELEPHONES NOT WORKING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #EMERGENCY_TELEPHONES_NOT_WORKING_VALUE
	 * @generated
	 * @ordered
	 */
  EMERGENCY_TELEPHONES_NOT_WORKING(4, "EMERGENCY_TELEPHONES_NOT_WORKING", "EMERGENCY_TELEPHONES_NOT_WORKING"),

  /**
	 * The '<em><b>AUTOMATIC PAYMENT LANES NOT WORKING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #AUTOMATIC_PAYMENT_LANES_NOT_WORKING_VALUE
	 * @generated
	 * @ordered
	 */
  AUTOMATIC_PAYMENT_LANES_NOT_WORKING(5, "AUTOMATIC_PAYMENT_LANES_NOT_WORKING", "AUTOMATIC_PAYMENT_LANES_NOT_WORKING");

  /**
	 * The '<em><b>ROAD RAIL CROSSING FAILURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ROAD RAIL CROSSING FAILURE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ROAD_RAIL_CROSSING_FAILURE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int ROAD_RAIL_CROSSING_FAILURE_VALUE = 1;

  /**
	 * The '<em><b>TUNNEL VENTILATION NOT WORKING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TUNNEL VENTILATION NOT WORKING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TUNNEL_VENTILATION_NOT_WORKING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TUNNEL_VENTILATION_NOT_WORKING_VALUE = 2;

  /**
	 * The '<em><b>TRAFFIC CONTROL SIGNALS WORKING INCORRECTLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TRAFFIC CONTROL SIGNALS WORKING INCORRECTLY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY_VALUE = 3;

  /**
	 * The '<em><b>EMERGENCY TELEPHONES NOT WORKING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EMERGENCY TELEPHONES NOT WORKING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #EMERGENCY_TELEPHONES_NOT_WORKING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int EMERGENCY_TELEPHONES_NOT_WORKING_VALUE = 4;

  /**
	 * The '<em><b>AUTOMATIC PAYMENT LANES NOT WORKING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AUTOMATIC PAYMENT LANES NOT WORKING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #AUTOMATIC_PAYMENT_LANES_NOT_WORKING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int AUTOMATIC_PAYMENT_LANES_NOT_WORKING_VALUE = 5;

  /**
	 * An array of all the '<em><b>Malfunctioning Roadside Equipment</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final MalfunctioningRoadsideEquipment[] VALUES_ARRAY =
    new MalfunctioningRoadsideEquipment[] {
			ROAD_RAIL_CROSSING_FAILURE,
			TUNNEL_VENTILATION_NOT_WORKING,
			TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY,
			EMERGENCY_TELEPHONES_NOT_WORKING,
			AUTOMATIC_PAYMENT_LANES_NOT_WORKING,
		};

  /**
	 * A public read-only list of all the '<em><b>Malfunctioning Roadside Equipment</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<MalfunctioningRoadsideEquipment> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Malfunctioning Roadside Equipment</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static MalfunctioningRoadsideEquipment get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MalfunctioningRoadsideEquipment result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Malfunctioning Roadside Equipment</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static MalfunctioningRoadsideEquipment getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MalfunctioningRoadsideEquipment result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Malfunctioning Roadside Equipment</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static MalfunctioningRoadsideEquipment get(int value) {
		switch (value) {
			case ROAD_RAIL_CROSSING_FAILURE_VALUE: return ROAD_RAIL_CROSSING_FAILURE;
			case TUNNEL_VENTILATION_NOT_WORKING_VALUE: return TUNNEL_VENTILATION_NOT_WORKING;
			case TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY_VALUE: return TRAFFIC_CONTROL_SIGNALS_WORKING_INCORRECTLY;
			case EMERGENCY_TELEPHONES_NOT_WORKING_VALUE: return EMERGENCY_TELEPHONES_NOT_WORKING;
			case AUTOMATIC_PAYMENT_LANES_NOT_WORKING_VALUE: return AUTOMATIC_PAYMENT_LANES_NOT_WORKING;
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
  private MalfunctioningRoadsideEquipment(int value, String name, String literal) {
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
  
} //MalfunctioningRoadsideEquipment
