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
 * A representation of the literals of the enumeration '<em><b>Extreme Weather Conditions</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getExtremeWeatherConditions()
 * @model
 * @generated
 */
public enum ExtremeWeatherConditions implements Enumerator {
  /**
	 * The '<em><b>STRONG WINDS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #STRONG_WINDS_VALUE
	 * @generated
	 * @ordered
	 */
  STRONG_WINDS(1, "STRONG_WINDS", "STRONG_WINDS"),

  /**
	 * The '<em><b>DAMAGING HAIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DAMAGING_HAIL_VALUE
	 * @generated
	 * @ordered
	 */
  DAMAGING_HAIL(2, "DAMAGING_HAIL", "DAMAGING_HAIL"),

  /**
	 * The '<em><b>HURRICANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #HURRICANE_VALUE
	 * @generated
	 * @ordered
	 */
  HURRICANE(3, "HURRICANE", "HURRICANE"),

  /**
	 * The '<em><b>THUNDERSTORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #THUNDERSTORM_VALUE
	 * @generated
	 * @ordered
	 */
  THUNDERSTORM(4, "THUNDERSTORM", "THUNDERSTORM"),

  /**
	 * The '<em><b>TORNADO</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TORNADO_VALUE
	 * @generated
	 * @ordered
	 */
  TORNADO(5, "TORNADO", "TORNADO"),

  /**
	 * The '<em><b>BLIZARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #BLIZARD_VALUE
	 * @generated
	 * @ordered
	 */
  BLIZARD(6, "BLIZARD", "BLIZARD");

  /**
	 * The '<em><b>STRONG WINDS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STRONG WINDS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #STRONG_WINDS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int STRONG_WINDS_VALUE = 1;

  /**
	 * The '<em><b>DAMAGING HAIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DAMAGING HAIL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DAMAGING_HAIL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DAMAGING_HAIL_VALUE = 2;

  /**
	 * The '<em><b>HURRICANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HURRICANE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #HURRICANE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int HURRICANE_VALUE = 3;

  /**
	 * The '<em><b>THUNDERSTORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>THUNDERSTORM</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #THUNDERSTORM
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int THUNDERSTORM_VALUE = 4;

  /**
	 * The '<em><b>TORNADO</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TORNADO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TORNADO
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TORNADO_VALUE = 5;

  /**
	 * The '<em><b>BLIZARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BLIZARD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #BLIZARD
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int BLIZARD_VALUE = 6;

  /**
	 * An array of all the '<em><b>Extreme Weather Conditions</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final ExtremeWeatherConditions[] VALUES_ARRAY =
    new ExtremeWeatherConditions[] {
			STRONG_WINDS,
			DAMAGING_HAIL,
			HURRICANE,
			THUNDERSTORM,
			TORNADO,
			BLIZARD,
		};

  /**
	 * A public read-only list of all the '<em><b>Extreme Weather Conditions</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<ExtremeWeatherConditions> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Extreme Weather Conditions</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ExtremeWeatherConditions get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExtremeWeatherConditions result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Extreme Weather Conditions</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ExtremeWeatherConditions getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExtremeWeatherConditions result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Extreme Weather Conditions</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ExtremeWeatherConditions get(int value) {
		switch (value) {
			case STRONG_WINDS_VALUE: return STRONG_WINDS;
			case DAMAGING_HAIL_VALUE: return DAMAGING_HAIL;
			case HURRICANE_VALUE: return HURRICANE;
			case THUNDERSTORM_VALUE: return THUNDERSTORM;
			case TORNADO_VALUE: return TORNADO;
			case BLIZARD_VALUE: return BLIZARD;
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
  private ExtremeWeatherConditions(int value, String name, String literal) {
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
  
} //ExtremeWeatherConditions
