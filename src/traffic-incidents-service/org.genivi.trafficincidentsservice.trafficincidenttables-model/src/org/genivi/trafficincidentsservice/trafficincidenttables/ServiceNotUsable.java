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
 * A representation of the literals of the enumeration '<em><b>Service Not Usable</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getServiceNotUsable()
 * @model
 * @generated
 */
public enum ServiceNotUsable implements Enumerator {
  /**
	 * The '<em><b>FUEL STATION CLOSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #FUEL_STATION_CLOSED_VALUE
	 * @generated
	 * @ordered
	 */
  FUEL_STATION_CLOSED(1, "FUEL_STATION_CLOSED", "FUEL_STATION_CLOSED"),

  /**
	 * The '<em><b>SERVICE AREA CLOSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SERVICE_AREA_CLOSED_VALUE
	 * @generated
	 * @ordered
	 */
  SERVICE_AREA_CLOSED(2, "SERVICE_AREA_CLOSED", "SERVICE_AREA_CLOSED"),

  /**
	 * The '<em><b>SERVICE AREA BUSY</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SERVICE_AREA_BUSY_VALUE
	 * @generated
	 * @ordered
	 */
  SERVICE_AREA_BUSY(3, "SERVICE_AREA_BUSY", "SERVICE_AREA_BUSY"),

  /**
	 * The '<em><b>PARKING FULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #PARKING_FULL_VALUE
	 * @generated
	 * @ordered
	 */
  PARKING_FULL(4, "PARKING_FULL", "PARKING_FULL"),

  /**
	 * The '<em><b>CAR PARK CLOSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #CAR_PARK_CLOSED_VALUE
	 * @generated
	 * @ordered
	 */
  CAR_PARK_CLOSED(5, "CAR_PARK_CLOSED", "CAR_PARK_CLOSED");

  /**
	 * The '<em><b>FUEL STATION CLOSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FUEL STATION CLOSED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #FUEL_STATION_CLOSED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int FUEL_STATION_CLOSED_VALUE = 1;

  /**
	 * The '<em><b>SERVICE AREA CLOSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SERVICE AREA CLOSED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SERVICE_AREA_CLOSED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SERVICE_AREA_CLOSED_VALUE = 2;

  /**
	 * The '<em><b>SERVICE AREA BUSY</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SERVICE AREA BUSY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SERVICE_AREA_BUSY
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SERVICE_AREA_BUSY_VALUE = 3;

  /**
	 * The '<em><b>PARKING FULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PARKING FULL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #PARKING_FULL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int PARKING_FULL_VALUE = 4;

  /**
	 * The '<em><b>CAR PARK CLOSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CAR PARK CLOSED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #CAR_PARK_CLOSED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int CAR_PARK_CLOSED_VALUE = 5;

  /**
	 * An array of all the '<em><b>Service Not Usable</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final ServiceNotUsable[] VALUES_ARRAY =
    new ServiceNotUsable[] {
			FUEL_STATION_CLOSED,
			SERVICE_AREA_CLOSED,
			SERVICE_AREA_BUSY,
			PARKING_FULL,
			CAR_PARK_CLOSED,
		};

  /**
	 * A public read-only list of all the '<em><b>Service Not Usable</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<ServiceNotUsable> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Service Not Usable</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ServiceNotUsable get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceNotUsable result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Service Not Usable</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ServiceNotUsable getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceNotUsable result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Service Not Usable</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ServiceNotUsable get(int value) {
		switch (value) {
			case FUEL_STATION_CLOSED_VALUE: return FUEL_STATION_CLOSED;
			case SERVICE_AREA_CLOSED_VALUE: return SERVICE_AREA_CLOSED;
			case SERVICE_AREA_BUSY_VALUE: return SERVICE_AREA_BUSY;
			case PARKING_FULL_VALUE: return PARKING_FULL;
			case CAR_PARK_CLOSED_VALUE: return CAR_PARK_CLOSED;
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
  private ServiceNotUsable(int value, String name, String literal) {
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
  
} //ServiceNotUsable
