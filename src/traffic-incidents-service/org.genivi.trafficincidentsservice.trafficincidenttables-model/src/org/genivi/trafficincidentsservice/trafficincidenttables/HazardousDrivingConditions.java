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
 * A representation of the literals of the enumeration '<em><b>Hazardous Driving Conditions</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getHazardousDrivingConditions()
 * @model
 * @generated
 */
public enum HazardousDrivingConditions implements Enumerator {
  /**
	 * The '<em><b>ROCKFALLS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ROCKFALLS_VALUE
	 * @generated
	 * @ordered
	 */
  ROCKFALLS(1, "ROCKFALLS", "ROCKFALLS"),

  /**
	 * The '<em><b>EARTHQUAKE DAMAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #EARTHQUAKE_DAMAGE_VALUE
	 * @generated
	 * @ordered
	 */
  EARTHQUAKE_DAMAGE(2, "EARTHQUAKE_DAMAGE", "EARTHQUAKE_DAMAGE"),

  /**
	 * The '<em><b>SEWER COLLAPSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SEWER_COLLAPSE_VALUE
	 * @generated
	 * @ordered
	 */
  SEWER_COLLAPSE(3, "SEWER_COLLAPSE", "SEWER_COLLAPSE"),

  /**
	 * The '<em><b>SUBSIDENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SUBSIDENCE_VALUE
	 * @generated
	 * @ordered
	 */
  SUBSIDENCE(4, "SUBSIDENCE", "SUBSIDENCE"),

  /**
	 * The '<em><b>SNOW DRIFTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SNOW_DRIFTS_VALUE
	 * @generated
	 * @ordered
	 */
  SNOW_DRIFTS(5, "SNOW_DRIFTS", "SNOW_DRIFTS"),

  /**
	 * The '<em><b>STORM DAMAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #STORM_DAMAGE_VALUE
	 * @generated
	 * @ordered
	 */
  STORM_DAMAGE(6, "STORM_DAMAGE", "STORM_DAMAGE"),

  /**
	 * The '<em><b>BURST PIPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #BURST_PIPE_VALUE
	 * @generated
	 * @ordered
	 */
  BURST_PIPE(7, "BURST_PIPE", "BURST_PIPE"),

  /**
	 * The '<em><b>VOLCANO ERUPTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #VOLCANO_ERUPTION_VALUE
	 * @generated
	 * @ordered
	 */
  VOLCANO_ERUPTION(8, "VOLCANO_ERUPTION", "VOLCANO_ERUPTION"),

  /**
	 * The '<em><b>FALLING ICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #FALLING_ICE_VALUE
	 * @generated
	 * @ordered
	 */
  FALLING_ICE(9, "FALLING_ICE", "FALLING_ICE");

  /**
	 * The '<em><b>ROCKFALLS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ROCKFALLS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ROCKFALLS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int ROCKFALLS_VALUE = 1;

  /**
	 * The '<em><b>EARTHQUAKE DAMAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EARTHQUAKE DAMAGE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #EARTHQUAKE_DAMAGE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int EARTHQUAKE_DAMAGE_VALUE = 2;

  /**
	 * The '<em><b>SEWER COLLAPSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SEWER COLLAPSE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SEWER_COLLAPSE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SEWER_COLLAPSE_VALUE = 3;

  /**
	 * The '<em><b>SUBSIDENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUBSIDENCE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SUBSIDENCE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SUBSIDENCE_VALUE = 4;

  /**
	 * The '<em><b>SNOW DRIFTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SNOW DRIFTS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SNOW_DRIFTS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SNOW_DRIFTS_VALUE = 5;

  /**
	 * The '<em><b>STORM DAMAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STORM DAMAGE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #STORM_DAMAGE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int STORM_DAMAGE_VALUE = 6;

  /**
	 * The '<em><b>BURST PIPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BURST PIPE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #BURST_PIPE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int BURST_PIPE_VALUE = 7;

  /**
	 * The '<em><b>VOLCANO ERUPTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VOLCANO ERUPTION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #VOLCANO_ERUPTION
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int VOLCANO_ERUPTION_VALUE = 8;

  /**
	 * The '<em><b>FALLING ICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FALLING ICE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #FALLING_ICE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int FALLING_ICE_VALUE = 9;

  /**
	 * An array of all the '<em><b>Hazardous Driving Conditions</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final HazardousDrivingConditions[] VALUES_ARRAY =
    new HazardousDrivingConditions[] {
			ROCKFALLS,
			EARTHQUAKE_DAMAGE,
			SEWER_COLLAPSE,
			SUBSIDENCE,
			SNOW_DRIFTS,
			STORM_DAMAGE,
			BURST_PIPE,
			VOLCANO_ERUPTION,
			FALLING_ICE,
		};

  /**
	 * A public read-only list of all the '<em><b>Hazardous Driving Conditions</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<HazardousDrivingConditions> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Hazardous Driving Conditions</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static HazardousDrivingConditions get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HazardousDrivingConditions result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Hazardous Driving Conditions</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static HazardousDrivingConditions getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HazardousDrivingConditions result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Hazardous Driving Conditions</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static HazardousDrivingConditions get(int value) {
		switch (value) {
			case ROCKFALLS_VALUE: return ROCKFALLS;
			case EARTHQUAKE_DAMAGE_VALUE: return EARTHQUAKE_DAMAGE;
			case SEWER_COLLAPSE_VALUE: return SEWER_COLLAPSE;
			case SUBSIDENCE_VALUE: return SUBSIDENCE;
			case SNOW_DRIFTS_VALUE: return SNOW_DRIFTS;
			case STORM_DAMAGE_VALUE: return STORM_DAMAGE;
			case BURST_PIPE_VALUE: return BURST_PIPE;
			case VOLCANO_ERUPTION_VALUE: return VOLCANO_ERUPTION;
			case FALLING_ICE_VALUE: return FALLING_ICE;
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
  private HazardousDrivingConditions(int value, String name, String literal) {
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
  
} //HazardousDrivingConditions
