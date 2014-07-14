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
 * A representation of the literals of the enumeration '<em><b>Driving Not Allowed</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getDrivingNotAllowed()
 * @model
 * @generated
 */
public enum DrivingNotAllowed implements Enumerator {
  /**
	 * The '<em><b>DRIVING NOT ALLOWED TAKE NEXT POSSIBLE PLACE TO STOP VEHICLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
  DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE(1, "DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE", "DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE");

  /**
	 * The '<em><b>DRIVING NOT ALLOWED TAKE NEXT POSSIBLE PLACE TO STOP VEHICLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DRIVING NOT ALLOWED TAKE NEXT POSSIBLE PLACE TO STOP VEHICLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE_VALUE = 1;

  /**
	 * An array of all the '<em><b>Driving Not Allowed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final DrivingNotAllowed[] VALUES_ARRAY =
    new DrivingNotAllowed[] {
			DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE,
		};

  /**
	 * A public read-only list of all the '<em><b>Driving Not Allowed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<DrivingNotAllowed> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Driving Not Allowed</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DrivingNotAllowed get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DrivingNotAllowed result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Driving Not Allowed</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DrivingNotAllowed getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DrivingNotAllowed result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Driving Not Allowed</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DrivingNotAllowed get(int value) {
		switch (value) {
			case DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE_VALUE: return DRIVING_NOT_ALLOWED_TAKE_NEXT_POSSIBLE_PLACE_TO_STOP_VEHICLE;
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
  private DrivingNotAllowed(int value, String name, String literal) {
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
  
} //DrivingNotAllowed
