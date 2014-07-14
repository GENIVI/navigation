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
 * A representation of the literals of the enumeration '<em><b>Lane Restriction Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getLaneRestrictionType()
 * @model
 * @generated
 */
public enum LaneRestrictionType implements Enumerator {
  /**
	 * The '<em><b>LANES CLOSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LANES_CLOSED_VALUE
	 * @generated
	 * @ordered
	 */
  LANES_CLOSED(1, "LANES_CLOSED", "LANES_CLOSED"),

  /**
	 * The '<em><b>LANES OPEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LANES_OPEN_VALUE
	 * @generated
	 * @ordered
	 */
  LANES_OPEN(2, "LANES_OPEN", "LANES_OPEN"),

  /**
	 * The '<em><b>RIGHT LANES CLOSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RIGHT_LANES_CLOSED_VALUE
	 * @generated
	 * @ordered
	 */
  RIGHT_LANES_CLOSED(3, "RIGHT_LANES_CLOSED", "RIGHT_LANES_CLOSED"),

  /**
	 * The '<em><b>LEFT LANES CLOSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LEFT_LANES_CLOSED_VALUE
	 * @generated
	 * @ordered
	 */
  LEFT_LANES_CLOSED(4, "LEFT_LANES_CLOSED", "LEFT_LANES_CLOSED");

  /**
	 * The '<em><b>LANES CLOSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LANES CLOSED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LANES_CLOSED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LANES_CLOSED_VALUE = 1;

  /**
	 * The '<em><b>LANES OPEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LANES OPEN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LANES_OPEN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LANES_OPEN_VALUE = 2;

  /**
	 * The '<em><b>RIGHT LANES CLOSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RIGHT LANES CLOSED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RIGHT_LANES_CLOSED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int RIGHT_LANES_CLOSED_VALUE = 3;

  /**
	 * The '<em><b>LEFT LANES CLOSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LEFT LANES CLOSED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LEFT_LANES_CLOSED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LEFT_LANES_CLOSED_VALUE = 4;

  /**
	 * An array of all the '<em><b>Lane Restriction Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final LaneRestrictionType[] VALUES_ARRAY =
    new LaneRestrictionType[] {
			LANES_CLOSED,
			LANES_OPEN,
			RIGHT_LANES_CLOSED,
			LEFT_LANES_CLOSED,
		};

  /**
	 * A public read-only list of all the '<em><b>Lane Restriction Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<LaneRestrictionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Lane Restriction Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static LaneRestrictionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LaneRestrictionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Lane Restriction Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static LaneRestrictionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LaneRestrictionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Lane Restriction Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static LaneRestrictionType get(int value) {
		switch (value) {
			case LANES_CLOSED_VALUE: return LANES_CLOSED;
			case LANES_OPEN_VALUE: return LANES_OPEN;
			case RIGHT_LANES_CLOSED_VALUE: return RIGHT_LANES_CLOSED;
			case LEFT_LANES_CLOSED_VALUE: return LEFT_LANES_CLOSED;
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
  private LaneRestrictionType(int value, String name, String literal) {
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
  
} //LaneRestrictionType
