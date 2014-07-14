/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Speed Unit</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getSpeedUnit()
 * @model
 * @generated
 */
public enum SpeedUnit implements Enumerator {
  /**
	 * The '<em><b>KILOMETERS PER HOUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #KILOMETERS_PER_HOUR_VALUE
	 * @generated
	 * @ordered
	 */
  KILOMETERS_PER_HOUR(1, "KILOMETERS_PER_HOUR", "KILOMETERS_PER_HOUR"),

  /**
	 * The '<em><b>MILES PER HOUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MILES_PER_HOUR_VALUE
	 * @generated
	 * @ordered
	 */
  MILES_PER_HOUR(2, "MILES_PER_HOUR", "MILES_PER_HOUR");

  /**
	 * The '<em><b>KILOMETERS PER HOUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>KILOMETERS PER HOUR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #KILOMETERS_PER_HOUR
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int KILOMETERS_PER_HOUR_VALUE = 1;

  /**
	 * The '<em><b>MILES PER HOUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MILES PER HOUR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MILES_PER_HOUR
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MILES_PER_HOUR_VALUE = 2;

  /**
	 * An array of all the '<em><b>Speed Unit</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final SpeedUnit[] VALUES_ARRAY =
    new SpeedUnit[] {
			KILOMETERS_PER_HOUR,
			MILES_PER_HOUR,
		};

  /**
	 * A public read-only list of all the '<em><b>Speed Unit</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<SpeedUnit> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Speed Unit</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static SpeedUnit get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SpeedUnit result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Speed Unit</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static SpeedUnit getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SpeedUnit result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Speed Unit</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static SpeedUnit get(int value) {
		switch (value) {
			case KILOMETERS_PER_HOUR_VALUE: return KILOMETERS_PER_HOUR;
			case MILES_PER_HOUR_VALUE: return MILES_PER_HOUR;
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
  private SpeedUnit(int value, String name, String literal) {
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
  
} //SpeedUnit
