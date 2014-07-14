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
 * A representation of the literals of the enumeration '<em><b>Reckless Persons</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getRecklessPersons()
 * @model
 * @generated
 */
public enum RecklessPersons implements Enumerator {
  /**
	 * The '<em><b>RECKLESS DRIVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RECKLESS_DRIVER_VALUE
	 * @generated
	 * @ordered
	 */
  RECKLESS_DRIVER(1, "RECKLESS_DRIVER", "RECKLESS_DRIVER"),

  /**
	 * The '<em><b>GUNFIRE ON ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #GUNFIRE_ON_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
  GUNFIRE_ON_ROAD(2, "GUNFIRE_ON_ROAD", "GUNFIRE_ON_ROAD"),

  /**
	 * The '<em><b>STONE THROWING PERSONS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #STONE_THROWING_PERSONS_VALUE
	 * @generated
	 * @ordered
	 */
  STONE_THROWING_PERSONS(3, "STONE_THROWING_PERSONS", "STONE_THROWING_PERSONS");

  /**
	 * The '<em><b>RECKLESS DRIVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RECKLESS DRIVER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RECKLESS_DRIVER
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int RECKLESS_DRIVER_VALUE = 1;

  /**
	 * The '<em><b>GUNFIRE ON ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GUNFIRE ON ROAD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #GUNFIRE_ON_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int GUNFIRE_ON_ROAD_VALUE = 2;

  /**
	 * The '<em><b>STONE THROWING PERSONS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STONE THROWING PERSONS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #STONE_THROWING_PERSONS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int STONE_THROWING_PERSONS_VALUE = 3;

  /**
	 * An array of all the '<em><b>Reckless Persons</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final RecklessPersons[] VALUES_ARRAY =
    new RecklessPersons[] {
			RECKLESS_DRIVER,
			GUNFIRE_ON_ROAD,
			STONE_THROWING_PERSONS,
		};

  /**
	 * A public read-only list of all the '<em><b>Reckless Persons</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<RecklessPersons> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Reckless Persons</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RecklessPersons get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RecklessPersons result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Reckless Persons</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RecklessPersons getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RecklessPersons result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Reckless Persons</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RecklessPersons get(int value) {
		switch (value) {
			case RECKLESS_DRIVER_VALUE: return RECKLESS_DRIVER;
			case GUNFIRE_ON_ROAD_VALUE: return GUNFIRE_ON_ROAD;
			case STONE_THROWING_PERSONS_VALUE: return STONE_THROWING_PERSONS;
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
  private RecklessPersons(int value, String name, String literal) {
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
  
} //RecklessPersons
