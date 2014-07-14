/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.locref;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Location Reference Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.locref.locrefPackage#getLocationReferenceType()
 * @model
 * @generated
 */
public enum LocationReferenceType implements Enumerator {
  /**
	 * The '<em><b>TMC LOC</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TMC_LOC_VALUE
	 * @generated
	 * @ordered
	 */
  TMC_LOC(1, "TMC_LOC", "TMC_LOC"),

  /**
	 * The '<em><b>OPEN LR</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #OPEN_LR_VALUE
	 * @generated
	 * @ordered
	 */
  OPEN_LR(2, "OPEN_LR", "OPEN_LR");

  /**
	 * The '<em><b>TMC LOC</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TMC LOC</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TMC_LOC
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TMC_LOC_VALUE = 1;

  /**
	 * The '<em><b>OPEN LR</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OPEN LR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #OPEN_LR
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int OPEN_LR_VALUE = 2;

  /**
	 * An array of all the '<em><b>Location Reference Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final LocationReferenceType[] VALUES_ARRAY =
    new LocationReferenceType[] {
			TMC_LOC,
			OPEN_LR,
		};

  /**
	 * A public read-only list of all the '<em><b>Location Reference Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<LocationReferenceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Location Reference Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static LocationReferenceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LocationReferenceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Location Reference Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static LocationReferenceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LocationReferenceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Location Reference Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static LocationReferenceType get(int value) {
		switch (value) {
			case TMC_LOC_VALUE: return TMC_LOC;
			case OPEN_LR_VALUE: return OPEN_LR;
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
  private LocationReferenceType(int value, String name, String literal) {
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
  
} //LocationReferenceType
