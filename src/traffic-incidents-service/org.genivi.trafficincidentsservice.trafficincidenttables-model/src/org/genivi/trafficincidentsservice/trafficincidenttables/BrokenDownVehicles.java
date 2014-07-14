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
 * A representation of the literals of the enumeration '<em><b>Broken Down Vehicles</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getBrokenDownVehicles()
 * @model
 * @generated
 */
public enum BrokenDownVehicles implements Enumerator {
  /**
	 * The '<em><b>BROKEN DOWN VEHICLE BURNING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #BROKEN_DOWN_VEHICLE_BURNING_VALUE
	 * @generated
	 * @ordered
	 */
  BROKEN_DOWN_VEHICLE_BURNING(1, "BROKEN_DOWN_VEHICLE_BURNING", "BROKEN_DOWN_VEHICLE_BURNING"),

  /**
	 * The '<em><b>BROKEN DOWN UNLIT VEHICLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #BROKEN_DOWN_UNLIT_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
  BROKEN_DOWN_UNLIT_VEHICLE(2, "BROKEN_DOWN_UNLIT_VEHICLE", "BROKEN_DOWN_UNLIT_VEHICLE");

  /**
	 * The '<em><b>BROKEN DOWN VEHICLE BURNING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BROKEN DOWN VEHICLE BURNING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #BROKEN_DOWN_VEHICLE_BURNING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int BROKEN_DOWN_VEHICLE_BURNING_VALUE = 1;

  /**
	 * The '<em><b>BROKEN DOWN UNLIT VEHICLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BROKEN DOWN UNLIT VEHICLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #BROKEN_DOWN_UNLIT_VEHICLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int BROKEN_DOWN_UNLIT_VEHICLE_VALUE = 2;

  /**
	 * An array of all the '<em><b>Broken Down Vehicles</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final BrokenDownVehicles[] VALUES_ARRAY =
    new BrokenDownVehicles[] {
			BROKEN_DOWN_VEHICLE_BURNING,
			BROKEN_DOWN_UNLIT_VEHICLE,
		};

  /**
	 * A public read-only list of all the '<em><b>Broken Down Vehicles</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<BrokenDownVehicles> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Broken Down Vehicles</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static BrokenDownVehicles get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BrokenDownVehicles result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Broken Down Vehicles</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static BrokenDownVehicles getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BrokenDownVehicles result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Broken Down Vehicles</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static BrokenDownVehicles get(int value) {
		switch (value) {
			case BROKEN_DOWN_VEHICLE_BURNING_VALUE: return BROKEN_DOWN_VEHICLE_BURNING;
			case BROKEN_DOWN_UNLIT_VEHICLE_VALUE: return BROKEN_DOWN_UNLIT_VEHICLE;
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
  private BrokenDownVehicles(int value, String name, String literal) {
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
  
} //BrokenDownVehicles
