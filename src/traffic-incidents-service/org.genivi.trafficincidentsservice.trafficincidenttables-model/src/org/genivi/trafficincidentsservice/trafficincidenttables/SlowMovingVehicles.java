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
 * A representation of the literals of the enumeration '<em><b>Slow Moving Vehicles</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getSlowMovingVehicles()
 * @model
 * @generated
 */
public enum SlowMovingVehicles implements Enumerator {
  /**
	 * The '<em><b>SLOW MOVING MAINTENANCE VEHICLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SLOW_MOVING_MAINTENANCE_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
  SLOW_MOVING_MAINTENANCE_VEHICLE(1, "SLOW_MOVING_MAINTENANCE_VEHICLE", "SLOW_MOVING_MAINTENANCE_VEHICLE"),

  /**
	 * The '<em><b>VEHICLES SLOWING TO LOOK AT ACCIDENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT_VALUE
	 * @generated
	 * @ordered
	 */
  VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT(2, "VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT", "VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT"),

  /**
	 * The '<em><b>ABNORMAL LOAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ABNORMAL_LOAD_VALUE
	 * @generated
	 * @ordered
	 */
  ABNORMAL_LOAD(3, "ABNORMAL_LOAD", "ABNORMAL_LOAD"),

  /**
	 * The '<em><b>ABNORMAL WIDE LOAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ABNORMAL_WIDE_LOAD_VALUE
	 * @generated
	 * @ordered
	 */
  ABNORMAL_WIDE_LOAD(4, "ABNORMAL_WIDE_LOAD", "ABNORMAL_WIDE_LOAD"),

  /**
	 * The '<em><b>CONVOY</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #CONVOY_VALUE
	 * @generated
	 * @ordered
	 */
  CONVOY(5, "CONVOY", "CONVOY"),

  /**
	 * The '<em><b>SNOWPLOUGH</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SNOWPLOUGH_VALUE
	 * @generated
	 * @ordered
	 */
  SNOWPLOUGH(6, "SNOWPLOUGH", "SNOWPLOUGH"),

  /**
	 * The '<em><b>DEICING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DEICING_VALUE
	 * @generated
	 * @ordered
	 */
  DEICING(7, "DEICING", "DEICING"),

  /**
	 * The '<em><b>SALTING VEHICLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SALTING_VEHICLES_VALUE
	 * @generated
	 * @ordered
	 */
  SALTING_VEHICLES(8, "SALTING_VEHICLES", "SALTING_VEHICLES");

  /**
	 * The '<em><b>SLOW MOVING MAINTENANCE VEHICLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SLOW MOVING MAINTENANCE VEHICLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SLOW_MOVING_MAINTENANCE_VEHICLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SLOW_MOVING_MAINTENANCE_VEHICLE_VALUE = 1;

  /**
	 * The '<em><b>VEHICLES SLOWING TO LOOK AT ACCIDENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VEHICLES SLOWING TO LOOK AT ACCIDENT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT_VALUE = 2;

  /**
	 * The '<em><b>ABNORMAL LOAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ABNORMAL LOAD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ABNORMAL_LOAD
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int ABNORMAL_LOAD_VALUE = 3;

  /**
	 * The '<em><b>ABNORMAL WIDE LOAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ABNORMAL WIDE LOAD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ABNORMAL_WIDE_LOAD
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int ABNORMAL_WIDE_LOAD_VALUE = 4;

  /**
	 * The '<em><b>CONVOY</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONVOY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #CONVOY
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int CONVOY_VALUE = 5;

  /**
	 * The '<em><b>SNOWPLOUGH</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SNOWPLOUGH</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SNOWPLOUGH
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SNOWPLOUGH_VALUE = 6;

  /**
	 * The '<em><b>DEICING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DEICING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DEICING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DEICING_VALUE = 7;

  /**
	 * The '<em><b>SALTING VEHICLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SALTING VEHICLES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SALTING_VEHICLES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SALTING_VEHICLES_VALUE = 8;

  /**
	 * An array of all the '<em><b>Slow Moving Vehicles</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final SlowMovingVehicles[] VALUES_ARRAY =
    new SlowMovingVehicles[] {
			SLOW_MOVING_MAINTENANCE_VEHICLE,
			VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT,
			ABNORMAL_LOAD,
			ABNORMAL_WIDE_LOAD,
			CONVOY,
			SNOWPLOUGH,
			DEICING,
			SALTING_VEHICLES,
		};

  /**
	 * A public read-only list of all the '<em><b>Slow Moving Vehicles</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<SlowMovingVehicles> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Slow Moving Vehicles</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static SlowMovingVehicles get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SlowMovingVehicles result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Slow Moving Vehicles</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static SlowMovingVehicles getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SlowMovingVehicles result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Slow Moving Vehicles</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static SlowMovingVehicles get(int value) {
		switch (value) {
			case SLOW_MOVING_MAINTENANCE_VEHICLE_VALUE: return SLOW_MOVING_MAINTENANCE_VEHICLE;
			case VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT_VALUE: return VEHICLES_SLOWING_TO_LOOK_AT_ACCIDENT;
			case ABNORMAL_LOAD_VALUE: return ABNORMAL_LOAD;
			case ABNORMAL_WIDE_LOAD_VALUE: return ABNORMAL_WIDE_LOAD;
			case CONVOY_VALUE: return CONVOY;
			case SNOWPLOUGH_VALUE: return SNOWPLOUGH;
			case DEICING_VALUE: return DEICING;
			case SALTING_VEHICLES_VALUE: return SALTING_VEHICLES;
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
  private SlowMovingVehicles(int value, String name, String literal) {
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
  
} //SlowMovingVehicles
