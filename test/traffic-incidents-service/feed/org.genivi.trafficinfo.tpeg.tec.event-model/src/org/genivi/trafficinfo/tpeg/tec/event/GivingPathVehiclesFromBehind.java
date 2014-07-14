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
 * A representation of the literals of the enumeration '<em><b>Giving Path Vehicles From Behind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getGivingPathVehiclesFromBehind()
 * @model
 * @generated
 */
public enum GivingPathVehiclesFromBehind implements Enumerator {
  /**
	 * The '<em><b>GIVING PATH FOR RESCUE VEHICLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #GIVING_PATH_FOR_RESCUE_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
  GIVING_PATH_FOR_RESCUE_VEHICLE(1, "GIVING_PATH_FOR_RESCUE_VEHICLE", "GIVING_PATH_FOR_RESCUE_VEHICLE"),

  /**
	 * The '<em><b>GIVING PATH FOR SERVICE VEHICLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #GIVING_PATH_FOR_SERVICE_VEHICLES_VALUE
	 * @generated
	 * @ordered
	 */
  GIVING_PATH_FOR_SERVICE_VEHICLES(2, "GIVING_PATH_FOR_SERVICE_VEHICLES", "GIVING_PATH_FOR_SERVICE_VEHICLES");

  /**
	 * The '<em><b>GIVING PATH FOR RESCUE VEHICLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GIVING PATH FOR RESCUE VEHICLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #GIVING_PATH_FOR_RESCUE_VEHICLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int GIVING_PATH_FOR_RESCUE_VEHICLE_VALUE = 1;

  /**
	 * The '<em><b>GIVING PATH FOR SERVICE VEHICLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GIVING PATH FOR SERVICE VEHICLES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #GIVING_PATH_FOR_SERVICE_VEHICLES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int GIVING_PATH_FOR_SERVICE_VEHICLES_VALUE = 2;

  /**
	 * An array of all the '<em><b>Giving Path Vehicles From Behind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final GivingPathVehiclesFromBehind[] VALUES_ARRAY =
    new GivingPathVehiclesFromBehind[] {
			GIVING_PATH_FOR_RESCUE_VEHICLE,
			GIVING_PATH_FOR_SERVICE_VEHICLES,
		};

  /**
	 * A public read-only list of all the '<em><b>Giving Path Vehicles From Behind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<GivingPathVehiclesFromBehind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Giving Path Vehicles From Behind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static GivingPathVehiclesFromBehind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GivingPathVehiclesFromBehind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Giving Path Vehicles From Behind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static GivingPathVehiclesFromBehind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GivingPathVehiclesFromBehind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Giving Path Vehicles From Behind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static GivingPathVehiclesFromBehind get(int value) {
		switch (value) {
			case GIVING_PATH_FOR_RESCUE_VEHICLE_VALUE: return GIVING_PATH_FOR_RESCUE_VEHICLE;
			case GIVING_PATH_FOR_SERVICE_VEHICLES_VALUE: return GIVING_PATH_FOR_SERVICE_VEHICLES;
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
  private GivingPathVehiclesFromBehind(int value, String name, String literal) {
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
  
} //GivingPathVehiclesFromBehind
