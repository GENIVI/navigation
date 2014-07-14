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
 * A representation of the literals of the enumeration '<em><b>Do Not Leave Your Vehicle</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getDoNotLeaveYourVehicle()
 * @model
 * @generated
 */
public enum DoNotLeaveYourVehicle implements Enumerator {
  /**
	 * The '<em><b>DO NOT LEAVE YOUR VEHICLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DO_NOT_LEAVE_YOUR_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
  DO_NOT_LEAVE_YOUR_VEHICLE(1, "DO_NOT_LEAVE_YOUR_VEHICLE", "DO_NOT_LEAVE_YOUR_VEHICLE"),

  /**
	 * The '<em><b>DO NOT LEAVE YOUR VEHICLE CLOSE WINDOWS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS_VALUE
	 * @generated
	 * @ordered
	 */
  DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS(2, "DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS", "DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS");

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
  public static final int DO_NOT_LEAVE_YOUR_VEHICLE_VALUE = 1;

  /**
	 * The '<em><b>DO NOT LEAVE YOUR VEHICLE CLOSE WINDOWS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DO NOT LEAVE YOUR VEHICLE CLOSE WINDOWS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS_VALUE = 2;

  /**
	 * An array of all the '<em><b>Do Not Leave Your Vehicle</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final DoNotLeaveYourVehicle[] VALUES_ARRAY =
    new DoNotLeaveYourVehicle[] {
			DO_NOT_LEAVE_YOUR_VEHICLE,
			DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS,
		};

  /**
	 * A public read-only list of all the '<em><b>Do Not Leave Your Vehicle</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<DoNotLeaveYourVehicle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Do Not Leave Your Vehicle</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DoNotLeaveYourVehicle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DoNotLeaveYourVehicle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Do Not Leave Your Vehicle</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DoNotLeaveYourVehicle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DoNotLeaveYourVehicle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Do Not Leave Your Vehicle</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DoNotLeaveYourVehicle get(int value) {
		switch (value) {
			case DO_NOT_LEAVE_YOUR_VEHICLE_VALUE: return DO_NOT_LEAVE_YOUR_VEHICLE;
			case DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS_VALUE: return DO_NOT_LEAVE_YOUR_VEHICLE_CLOSE_WINDOWS;
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
  private DoNotLeaveYourVehicle(int value, String name, String literal) {
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
  
} //DoNotLeaveYourVehicle
