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
 * A representation of the literals of the enumeration '<em><b>Time Delay</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTimeDelay()
 * @model
 * @generated
 */
public enum TimeDelay implements Enumerator {
  /**
	 * The '<em><b>TIME DELAY AT FRONTIER</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TIME_DELAY_AT_FRONTIER_VALUE
	 * @generated
	 * @ordered
	 */
  TIME_DELAY_AT_FRONTIER(1, "TIME_DELAY_AT_FRONTIER", "TIME_DELAY_AT_FRONTIER"),

  /**
	 * The '<em><b>TIME DELAY AT FERRY PORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TIME_DELAY_AT_FERRY_PORT_VALUE
	 * @generated
	 * @ordered
	 */
  TIME_DELAY_AT_FERRY_PORT(2, "TIME_DELAY_AT_FERRY_PORT", "TIME_DELAY_AT_FERRY_PORT"),

  /**
	 * The '<em><b>TIME DELAY AT VEHICLE ON RAIL TERMINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL_VALUE
	 * @generated
	 * @ordered
	 */
  TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL(3, "TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL", "TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL");

  /**
	 * The '<em><b>TIME DELAY AT FRONTIER</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TIME DELAY AT FRONTIER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TIME_DELAY_AT_FRONTIER
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TIME_DELAY_AT_FRONTIER_VALUE = 1;

  /**
	 * The '<em><b>TIME DELAY AT FERRY PORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TIME DELAY AT FERRY PORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TIME_DELAY_AT_FERRY_PORT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TIME_DELAY_AT_FERRY_PORT_VALUE = 2;

  /**
	 * The '<em><b>TIME DELAY AT VEHICLE ON RAIL TERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TIME DELAY AT VEHICLE ON RAIL TERMINAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL_VALUE = 3;

  /**
	 * An array of all the '<em><b>Time Delay</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final TimeDelay[] VALUES_ARRAY =
    new TimeDelay[] {
			TIME_DELAY_AT_FRONTIER,
			TIME_DELAY_AT_FERRY_PORT,
			TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL,
		};

  /**
	 * A public read-only list of all the '<em><b>Time Delay</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<TimeDelay> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Time Delay</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TimeDelay get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TimeDelay result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Time Delay</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TimeDelay getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TimeDelay result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Time Delay</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TimeDelay get(int value) {
		switch (value) {
			case TIME_DELAY_AT_FRONTIER_VALUE: return TIME_DELAY_AT_FRONTIER;
			case TIME_DELAY_AT_FERRY_PORT_VALUE: return TIME_DELAY_AT_FERRY_PORT;
			case TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL_VALUE: return TIME_DELAY_AT_VEHICLE_ON_RAIL_TERMINAL;
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
  private TimeDelay(int value, String name, String literal) {
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
  
} //TimeDelay
