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
 * A representation of the literals of the enumeration '<em><b>Precipitation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getPrecipitation()
 * @model
 * @generated
 */
public enum Precipitation implements Enumerator {
  /**
	 * The '<em><b>HEAVY RAIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #HEAVY_RAIN_VALUE
	 * @generated
	 * @ordered
	 */
  HEAVY_RAIN(1, "HEAVY_RAIN", "HEAVY_RAIN"),

  /**
	 * The '<em><b>HEAVY SNOWFALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #HEAVY_SNOWFALL_VALUE
	 * @generated
	 * @ordered
	 */
  HEAVY_SNOWFALL(2, "HEAVY_SNOWFALL", "HEAVY_SNOWFALL"),

  /**
	 * The '<em><b>SOFT HAIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SOFT_HAIL_VALUE
	 * @generated
	 * @ordered
	 */
  SOFT_HAIL(3, "SOFT_HAIL", "SOFT_HAIL");

  /**
	 * The '<em><b>HEAVY RAIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HEAVY RAIN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #HEAVY_RAIN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int HEAVY_RAIN_VALUE = 1;

  /**
	 * The '<em><b>HEAVY SNOWFALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HEAVY SNOWFALL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #HEAVY_SNOWFALL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int HEAVY_SNOWFALL_VALUE = 2;

  /**
	 * The '<em><b>SOFT HAIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SOFT HAIL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SOFT_HAIL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SOFT_HAIL_VALUE = 3;

  /**
	 * An array of all the '<em><b>Precipitation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final Precipitation[] VALUES_ARRAY =
    new Precipitation[] {
			HEAVY_RAIN,
			HEAVY_SNOWFALL,
			SOFT_HAIL,
		};

  /**
	 * A public read-only list of all the '<em><b>Precipitation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<Precipitation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Precipitation</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static Precipitation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Precipitation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Precipitation</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static Precipitation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Precipitation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Precipitation</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static Precipitation get(int value) {
		switch (value) {
			case HEAVY_RAIN_VALUE: return HEAVY_RAIN;
			case HEAVY_SNOWFALL_VALUE: return HEAVY_SNOWFALL;
			case SOFT_HAIL_VALUE: return SOFT_HAIL;
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
  private Precipitation(int value, String name, String literal) {
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
  
} //Precipitation
