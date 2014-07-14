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
 * A representation of the literals of the enumeration '<em><b>Risk Of Fire</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getRiskOfFire()
 * @model
 * @generated
 */
public enum RiskOfFire implements Enumerator {
  /**
	 * The '<em><b>LEAKAGE OF FUEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LEAKAGE_OF_FUEL_VALUE
	 * @generated
	 * @ordered
	 */
  LEAKAGE_OF_FUEL(1, "LEAKAGE_OF_FUEL", "LEAKAGE_OF_FUEL"),

  /**
	 * The '<em><b>LEAKAGE OF GAS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LEAKAGE_OF_GAS_VALUE
	 * @generated
	 * @ordered
	 */
  LEAKAGE_OF_GAS(2, "LEAKAGE_OF_GAS", "LEAKAGE_OF_GAS");

  /**
	 * The '<em><b>LEAKAGE OF FUEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LEAKAGE OF FUEL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LEAKAGE_OF_FUEL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LEAKAGE_OF_FUEL_VALUE = 1;

  /**
	 * The '<em><b>LEAKAGE OF GAS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LEAKAGE OF GAS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LEAKAGE_OF_GAS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LEAKAGE_OF_GAS_VALUE = 2;

  /**
	 * An array of all the '<em><b>Risk Of Fire</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final RiskOfFire[] VALUES_ARRAY =
    new RiskOfFire[] {
			LEAKAGE_OF_FUEL,
			LEAKAGE_OF_GAS,
		};

  /**
	 * A public read-only list of all the '<em><b>Risk Of Fire</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<RiskOfFire> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Risk Of Fire</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RiskOfFire get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RiskOfFire result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Risk Of Fire</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RiskOfFire getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RiskOfFire result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Risk Of Fire</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RiskOfFire get(int value) {
		switch (value) {
			case LEAKAGE_OF_FUEL_VALUE: return LEAKAGE_OF_FUEL;
			case LEAKAGE_OF_GAS_VALUE: return LEAKAGE_OF_GAS;
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
  private RiskOfFire(int value, String name, String literal) {
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
  
} //RiskOfFire
