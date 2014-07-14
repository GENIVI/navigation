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
 * A representation of the literals of the enumeration '<em><b>Accident</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getAccident()
 * @model
 * @generated
 */
public enum Accident implements Enumerator {
	/**
	 * The '<em><b>MULTI VEHICLE ACCIDENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTI_VEHICLE_ACCIDENT_VALUE
	 * @generated
	 * @ordered
	 */
	MULTI_VEHICLE_ACCIDENT(1, "MULTI_VEHICLE_ACCIDENT", "MULTI_VEHICLE_ACCIDENT"),

	/**
	 * The '<em><b>HEAVY ACCIDENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEAVY_ACCIDENT_VALUE
	 * @generated
	 * @ordered
	 */
	HEAVY_ACCIDENT(2, "HEAVY_ACCIDENT", "HEAVY_ACCIDENT"),

	/**
	 * The '<em><b>ACCIDENT INVOLVING LORRY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCIDENT_INVOLVING_LORRY_VALUE
	 * @generated
	 * @ordered
	 */
	ACCIDENT_INVOLVING_LORRY(3, "ACCIDENT_INVOLVING_LORRY", "ACCIDENT_INVOLVING_LORRY"),

	/**
	 * The '<em><b>ACCIDENT INVOLVING BUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCIDENT_INVOLVING_BUS_VALUE
	 * @generated
	 * @ordered
	 */
	ACCIDENT_INVOLVING_BUS(4, "ACCIDENT_INVOLVING_BUS", "ACCIDENT_INVOLVING_BUS"),

	/**
	 * The '<em><b>ACCIDENT INVOLVING HAZARDOUS MATERIALS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS_VALUE
	 * @generated
	 * @ordered
	 */
	ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS(5, "ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS", "ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS"),

	/**
	 * The '<em><b>ACCIDENT ON OPPOSITE LANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCIDENT_ON_OPPOSITE_LANE_VALUE
	 * @generated
	 * @ordered
	 */
	ACCIDENT_ON_OPPOSITE_LANE(6, "ACCIDENT_ON_OPPOSITE_LANE", "ACCIDENT_ON_OPPOSITE_LANE"),

	/**
	 * The '<em><b>UNSECURED ACCIDENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSECURED_ACCIDENT_VALUE
	 * @generated
	 * @ordered
	 */
	UNSECURED_ACCIDENT(7, "UNSECURED_ACCIDENT", "UNSECURED_ACCIDENT");

	/**
	 * The '<em><b>MULTI VEHICLE ACCIDENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MULTI VEHICLE ACCIDENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MULTI_VEHICLE_ACCIDENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MULTI_VEHICLE_ACCIDENT_VALUE = 1;

	/**
	 * The '<em><b>HEAVY ACCIDENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEAVY ACCIDENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEAVY_ACCIDENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEAVY_ACCIDENT_VALUE = 2;

	/**
	 * The '<em><b>ACCIDENT INVOLVING LORRY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACCIDENT INVOLVING LORRY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCIDENT_INVOLVING_LORRY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACCIDENT_INVOLVING_LORRY_VALUE = 3;

	/**
	 * The '<em><b>ACCIDENT INVOLVING BUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACCIDENT INVOLVING BUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCIDENT_INVOLVING_BUS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACCIDENT_INVOLVING_BUS_VALUE = 4;

	/**
	 * The '<em><b>ACCIDENT INVOLVING HAZARDOUS MATERIALS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACCIDENT INVOLVING HAZARDOUS MATERIALS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS_VALUE = 5;

	/**
	 * The '<em><b>ACCIDENT ON OPPOSITE LANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACCIDENT ON OPPOSITE LANE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCIDENT_ON_OPPOSITE_LANE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACCIDENT_ON_OPPOSITE_LANE_VALUE = 6;

	/**
	 * The '<em><b>UNSECURED ACCIDENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNSECURED ACCIDENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSECURED_ACCIDENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNSECURED_ACCIDENT_VALUE = 7;

	/**
	 * An array of all the '<em><b>Accident</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Accident[] VALUES_ARRAY =
		new Accident[] {
			MULTI_VEHICLE_ACCIDENT,
			HEAVY_ACCIDENT,
			ACCIDENT_INVOLVING_LORRY,
			ACCIDENT_INVOLVING_BUS,
			ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS,
			ACCIDENT_ON_OPPOSITE_LANE,
			UNSECURED_ACCIDENT,
		};

	/**
	 * A public read-only list of all the '<em><b>Accident</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Accident> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Accident</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Accident get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Accident result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Accident</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Accident getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Accident result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Accident</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Accident get(int value) {
		switch (value) {
			case MULTI_VEHICLE_ACCIDENT_VALUE: return MULTI_VEHICLE_ACCIDENT;
			case HEAVY_ACCIDENT_VALUE: return HEAVY_ACCIDENT;
			case ACCIDENT_INVOLVING_LORRY_VALUE: return ACCIDENT_INVOLVING_LORRY;
			case ACCIDENT_INVOLVING_BUS_VALUE: return ACCIDENT_INVOLVING_BUS;
			case ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS_VALUE: return ACCIDENT_INVOLVING_HAZARDOUS_MATERIALS;
			case ACCIDENT_ON_OPPOSITE_LANE_VALUE: return ACCIDENT_ON_OPPOSITE_LANE;
			case UNSECURED_ACCIDENT_VALUE: return UNSECURED_ACCIDENT;
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
	private Accident(int value, String name, String literal) {
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
	
} //Accident
