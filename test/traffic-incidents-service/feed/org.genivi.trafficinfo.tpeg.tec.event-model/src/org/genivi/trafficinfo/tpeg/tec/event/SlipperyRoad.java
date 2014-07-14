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
 * A representation of the literals of the enumeration '<em><b>Slippery Road</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getSlipperyRoad()
 * @model
 * @generated
 */
public enum SlipperyRoad implements Enumerator {
	/**
	 * The '<em><b>HEAVY FROST ON ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEAVY_FROST_ON_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
	HEAVY_FROST_ON_ROAD(1, "HEAVY_FROST_ON_ROAD", "HEAVY_FROST_ON_ROAD"),

	/**
	 * The '<em><b>FUEL ON ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUEL_ON_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
	FUEL_ON_ROAD(2, "FUEL_ON_ROAD", "FUEL_ON_ROAD"),

	/**
	 * The '<em><b>MUD ON ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUD_ON_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
	MUD_ON_ROAD(3, "MUD_ON_ROAD", "MUD_ON_ROAD"),

	/**
	 * The '<em><b>SNOW ON ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SNOW_ON_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
	SNOW_ON_ROAD(4, "SNOW_ON_ROAD", "SNOW_ON_ROAD"),

	/**
	 * The '<em><b>ICE ON ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ICE_ON_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
	ICE_ON_ROAD(5, "ICE_ON_ROAD", "ICE_ON_ROAD"),

	/**
	 * The '<em><b>BLACK ICE ON ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLACK_ICE_ON_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
	BLACK_ICE_ON_ROAD(6, "BLACK_ICE_ON_ROAD", "BLACK_ICE_ON_ROAD"),

	/**
	 * The '<em><b>OIL ON ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OIL_ON_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
	OIL_ON_ROAD(7, "OIL_ON_ROAD", "OIL_ON_ROAD"),

	/**
	 * The '<em><b>LOOSE CHIPPINGS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOOSE_CHIPPINGS_VALUE
	 * @generated
	 * @ordered
	 */
	LOOSE_CHIPPINGS(8, "LOOSE_CHIPPINGS", "LOOSE_CHIPPINGS"),

	/**
	 * The '<em><b>INSTANT BLACK ICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTANT_BLACK_ICE_VALUE
	 * @generated
	 * @ordered
	 */
	INSTANT_BLACK_ICE(9, "INSTANT_BLACK_ICE", "INSTANT_BLACK_ICE"), /**
	 * The '<em><b>ROADS SALTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ROADS_SALTED_VALUE
	 * @generated
	 * @ordered
	 */
  ROADS_SALTED(10, "ROADS_SALTED", "ROADS_SALTED");

	/**
	 * The '<em><b>HEAVY FROST ON ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEAVY FROST ON ROAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEAVY_FROST_ON_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEAVY_FROST_ON_ROAD_VALUE = 1;

	/**
	 * The '<em><b>FUEL ON ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FUEL ON ROAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FUEL_ON_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FUEL_ON_ROAD_VALUE = 2;

	/**
	 * The '<em><b>MUD ON ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MUD ON ROAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUD_ON_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MUD_ON_ROAD_VALUE = 3;

	/**
	 * The '<em><b>SNOW ON ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SNOW ON ROAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SNOW_ON_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SNOW_ON_ROAD_VALUE = 4;

	/**
	 * The '<em><b>ICE ON ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ICE ON ROAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ICE_ON_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ICE_ON_ROAD_VALUE = 5;

	/**
	 * The '<em><b>BLACK ICE ON ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BLACK ICE ON ROAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLACK_ICE_ON_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BLACK_ICE_ON_ROAD_VALUE = 6;

	/**
	 * The '<em><b>OIL ON ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OIL ON ROAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OIL_ON_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OIL_ON_ROAD_VALUE = 7;

	/**
	 * The '<em><b>LOOSE CHIPPINGS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOOSE CHIPPINGS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOOSE_CHIPPINGS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOOSE_CHIPPINGS_VALUE = 8;

	/**
	 * The '<em><b>INSTANT BLACK ICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSTANT BLACK ICE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTANT_BLACK_ICE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INSTANT_BLACK_ICE_VALUE = 9;

	/**
	 * The '<em><b>ROADS SALTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ROADS SALTED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ROADS_SALTED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int ROADS_SALTED_VALUE = 10;

  /**
	 * An array of all the '<em><b>Slippery Road</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SlipperyRoad[] VALUES_ARRAY =
		new SlipperyRoad[] {
			HEAVY_FROST_ON_ROAD,
			FUEL_ON_ROAD,
			MUD_ON_ROAD,
			SNOW_ON_ROAD,
			ICE_ON_ROAD,
			BLACK_ICE_ON_ROAD,
			OIL_ON_ROAD,
			LOOSE_CHIPPINGS,
			INSTANT_BLACK_ICE,
			ROADS_SALTED,
		};

	/**
	 * A public read-only list of all the '<em><b>Slippery Road</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SlipperyRoad> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Slippery Road</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SlipperyRoad get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SlipperyRoad result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Slippery Road</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SlipperyRoad getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SlipperyRoad result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Slippery Road</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SlipperyRoad get(int value) {
		switch (value) {
			case HEAVY_FROST_ON_ROAD_VALUE: return HEAVY_FROST_ON_ROAD;
			case FUEL_ON_ROAD_VALUE: return FUEL_ON_ROAD;
			case MUD_ON_ROAD_VALUE: return MUD_ON_ROAD;
			case SNOW_ON_ROAD_VALUE: return SNOW_ON_ROAD;
			case ICE_ON_ROAD_VALUE: return ICE_ON_ROAD;
			case BLACK_ICE_ON_ROAD_VALUE: return BLACK_ICE_ON_ROAD;
			case OIL_ON_ROAD_VALUE: return OIL_ON_ROAD;
			case LOOSE_CHIPPINGS_VALUE: return LOOSE_CHIPPINGS;
			case INSTANT_BLACK_ICE_VALUE: return INSTANT_BLACK_ICE;
			case ROADS_SALTED_VALUE: return ROADS_SALTED;
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
	private SlipperyRoad(int value, String name, String literal) {
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
	
} //SlipperyRoad
