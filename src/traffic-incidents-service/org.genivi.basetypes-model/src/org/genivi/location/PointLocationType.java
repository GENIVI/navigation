/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.location;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Point Location Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.location.LocationPackage#getPointLocationType()
 * @model
 * @generated
 */
public enum PointLocationType implements Enumerator {
  /**
	 * The '<em><b>MOTORWAY EXIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MOTORWAY_EXIT_VALUE
	 * @generated
	 * @ordered
	 */
  MOTORWAY_EXIT(0, "MOTORWAY_EXIT", "MOTORWAY_EXIT"),

  /**
	 * The '<em><b>MOTORWAY TRIANGLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MOTORWAY_TRIANGLE_VALUE
	 * @generated
	 * @ordered
	 */
  MOTORWAY_TRIANGLE(1, "MOTORWAY_TRIANGLE", "MOTORWAY_TRIANGLE"),

  /**
	 * The '<em><b>MOTORWAY CROSSING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MOTORWAY_CROSSING_VALUE
	 * @generated
	 * @ordered
	 */
  MOTORWAY_CROSSING(2, "MOTORWAY_CROSSING", "MOTORWAY_CROSSING"),

  /**
	 * The '<em><b>MOTORWAY ENTRY</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MOTORWAY_ENTRY_VALUE
	 * @generated
	 * @ordered
	 */
  MOTORWAY_ENTRY(3, "MOTORWAY_ENTRY", "MOTORWAY_ENTRY");

  /**
	 * The '<em><b>MOTORWAY EXIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MOTORWAY EXIT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MOTORWAY_EXIT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MOTORWAY_EXIT_VALUE = 0;

  /**
	 * The '<em><b>MOTORWAY TRIANGLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MOTORWAY TRIANGLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MOTORWAY_TRIANGLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MOTORWAY_TRIANGLE_VALUE = 1;

  /**
	 * The '<em><b>MOTORWAY CROSSING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MOTORWAY CROSSING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MOTORWAY_CROSSING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MOTORWAY_CROSSING_VALUE = 2;

  /**
	 * The '<em><b>MOTORWAY ENTRY</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MOTORWAY ENTRY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MOTORWAY_ENTRY
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MOTORWAY_ENTRY_VALUE = 3;

  /**
	 * An array of all the '<em><b>Point Location Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final PointLocationType[] VALUES_ARRAY =
    new PointLocationType[] {
			MOTORWAY_EXIT,
			MOTORWAY_TRIANGLE,
			MOTORWAY_CROSSING,
			MOTORWAY_ENTRY,
		};

  /**
	 * A public read-only list of all the '<em><b>Point Location Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<PointLocationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Point Location Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static PointLocationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PointLocationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Point Location Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static PointLocationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PointLocationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Point Location Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static PointLocationType get(int value) {
		switch (value) {
			case MOTORWAY_EXIT_VALUE: return MOTORWAY_EXIT;
			case MOTORWAY_TRIANGLE_VALUE: return MOTORWAY_TRIANGLE;
			case MOTORWAY_CROSSING_VALUE: return MOTORWAY_CROSSING;
			case MOTORWAY_ENTRY_VALUE: return MOTORWAY_ENTRY;
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
  private PointLocationType(int value, String name, String literal) {
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
  
} //PointLocationType
