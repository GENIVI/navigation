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
 * A representation of the literals of the enumeration '<em><b>Tendency</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTendency()
 * @model
 * @generated
 */
public enum Tendency implements Enumerator {
	/**
	 * The '<em><b>SLIGHTLY INCREASING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIGHTLY_INCREASING_VALUE
	 * @generated
	 * @ordered
	 */
	SLIGHTLY_INCREASING(1, "SLIGHTLY_INCREASING", "SLIGHTLY_INCREASING"),

	/**
	 * The '<em><b>INCREASING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INCREASING_VALUE
	 * @generated
	 * @ordered
	 */
	INCREASING(2, "INCREASING", "INCREASING"),

	/**
	 * The '<em><b>STRONGLY INCREASING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRONGLY_INCREASING_VALUE
	 * @generated
	 * @ordered
	 */
	STRONGLY_INCREASING(3, "STRONGLY_INCREASING", "STRONGLY_INCREASING"),

	/**
	 * The '<em><b>SLIGHTLY DECREASING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIGHTLY_DECREASING_VALUE
	 * @generated
	 * @ordered
	 */
	SLIGHTLY_DECREASING(4, "SLIGHTLY_DECREASING", "SLIGHTLY_DECREASING"),

	/**
	 * The '<em><b>DECREASING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECREASING_VALUE
	 * @generated
	 * @ordered
	 */
	DECREASING(5, "DECREASING", "DECREASING"),

	/**
	 * The '<em><b>STRONGLY DECREASING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRONGLY_DECREASING_VALUE
	 * @generated
	 * @ordered
	 */
	STRONGLY_DECREASING(6, "STRONGLY_DECREASING", "STRONGLY_DECREASING"),

	/**
	 * The '<em><b>CONSTANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTANT_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTANT(7, "CONSTANT", "CONSTANT");

	/**
	 * The '<em><b>SLIGHTLY INCREASING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIGHTLY INCREASING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIGHTLY_INCREASING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIGHTLY_INCREASING_VALUE = 1;

	/**
	 * The '<em><b>INCREASING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INCREASING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INCREASING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INCREASING_VALUE = 2;

	/**
	 * The '<em><b>STRONGLY INCREASING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRONGLY INCREASING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRONGLY_INCREASING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRONGLY_INCREASING_VALUE = 3;

	/**
	 * The '<em><b>SLIGHTLY DECREASING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIGHTLY DECREASING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIGHTLY_DECREASING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIGHTLY_DECREASING_VALUE = 4;

	/**
	 * The '<em><b>DECREASING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DECREASING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECREASING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DECREASING_VALUE = 5;

	/**
	 * The '<em><b>STRONGLY DECREASING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRONGLY DECREASING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRONGLY_DECREASING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRONGLY_DECREASING_VALUE = 6;

	/**
	 * The '<em><b>CONSTANT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSTANT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTANT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSTANT_VALUE = 7;

	/**
	 * An array of all the '<em><b>Tendency</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Tendency[] VALUES_ARRAY =
		new Tendency[] {
			SLIGHTLY_INCREASING,
			INCREASING,
			STRONGLY_INCREASING,
			SLIGHTLY_DECREASING,
			DECREASING,
			STRONGLY_DECREASING,
			CONSTANT,
		};

	/**
	 * A public read-only list of all the '<em><b>Tendency</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Tendency> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Tendency</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Tendency get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Tendency result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tendency</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Tendency getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Tendency result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tendency</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Tendency get(int value) {
		switch (value) {
			case SLIGHTLY_INCREASING_VALUE: return SLIGHTLY_INCREASING;
			case INCREASING_VALUE: return INCREASING;
			case STRONGLY_INCREASING_VALUE: return STRONGLY_INCREASING;
			case SLIGHTLY_DECREASING_VALUE: return SLIGHTLY_DECREASING;
			case DECREASING_VALUE: return DECREASING;
			case STRONGLY_DECREASING_VALUE: return STRONGLY_DECREASING;
			case CONSTANT_VALUE: return CONSTANT;
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
	private Tendency(int value, String name, String literal) {
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
	
} //Tendency
