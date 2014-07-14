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
 * A representation of the literals of the enumeration '<em><b>Effect Code</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEffectCode()
 * @model
 * @generated
 */
public enum EffectCode implements Enumerator {
	/**
	 * The '<em><b>TRAFFIC FLOW UNKNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRAFFIC_FLOW_UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	TRAFFIC_FLOW_UNKNOWN(1, "TRAFFIC_FLOW_UNKNOWN", "TRAFFIC_FLOW_UNKNOWN"),

	/**
	 * The '<em><b>FREE TRAFFIC FLOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREE_TRAFFIC_FLOW_VALUE
	 * @generated
	 * @ordered
	 */
	FREE_TRAFFIC_FLOW(2, "FREE_TRAFFIC_FLOW", "FREE_TRAFFIC_FLOW"),

	/**
	 * The '<em><b>HEAVY TRAFFIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEAVY_TRAFFIC_VALUE
	 * @generated
	 * @ordered
	 */
	HEAVY_TRAFFIC(3, "HEAVY_TRAFFIC", "HEAVY_TRAFFIC"),

	/**
	 * The '<em><b>SLOW TRAFFIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLOW_TRAFFIC_VALUE
	 * @generated
	 * @ordered
	 */
	SLOW_TRAFFIC(4, "SLOW_TRAFFIC", "SLOW_TRAFFIC"),

	/**
	 * The '<em><b>QUEUING TRAFFIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUEUING_TRAFFIC_VALUE
	 * @generated
	 * @ordered
	 */
	QUEUING_TRAFFIC(5, "QUEUING_TRAFFIC", "QUEUING_TRAFFIC"),

	/**
	 * The '<em><b>STATIONARY TRAFFIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATIONARY_TRAFFIC_VALUE
	 * @generated
	 * @ordered
	 */
	STATIONARY_TRAFFIC(6, "STATIONARY_TRAFFIC", "STATIONARY_TRAFFIC"),

	/**
	 * The '<em><b>NO TRAFFIC FLOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_TRAFFIC_FLOW_VALUE
	 * @generated
	 * @ordered
	 */
	NO_TRAFFIC_FLOW(7, "NO_TRAFFIC_FLOW", "NO_TRAFFIC_FLOW");

	/**
	 * The '<em><b>TRAFFIC FLOW UNKNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRAFFIC FLOW UNKNOWN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRAFFIC_FLOW_UNKNOWN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRAFFIC_FLOW_UNKNOWN_VALUE = 1;

	/**
	 * The '<em><b>FREE TRAFFIC FLOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREE TRAFFIC FLOW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREE_TRAFFIC_FLOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREE_TRAFFIC_FLOW_VALUE = 2;

	/**
	 * The '<em><b>HEAVY TRAFFIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEAVY TRAFFIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEAVY_TRAFFIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEAVY_TRAFFIC_VALUE = 3;

	/**
	 * The '<em><b>SLOW TRAFFIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLOW TRAFFIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLOW_TRAFFIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLOW_TRAFFIC_VALUE = 4;

	/**
	 * The '<em><b>QUEUING TRAFFIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QUEUING TRAFFIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUEUING_TRAFFIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QUEUING_TRAFFIC_VALUE = 5;

	/**
	 * The '<em><b>STATIONARY TRAFFIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATIONARY TRAFFIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATIONARY_TRAFFIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATIONARY_TRAFFIC_VALUE = 6;

	/**
	 * The '<em><b>NO TRAFFIC FLOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NO TRAFFIC FLOW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO_TRAFFIC_FLOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NO_TRAFFIC_FLOW_VALUE = 7;

	/**
	 * An array of all the '<em><b>Effect Code</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EffectCode[] VALUES_ARRAY =
		new EffectCode[] {
			TRAFFIC_FLOW_UNKNOWN,
			FREE_TRAFFIC_FLOW,
			HEAVY_TRAFFIC,
			SLOW_TRAFFIC,
			QUEUING_TRAFFIC,
			STATIONARY_TRAFFIC,
			NO_TRAFFIC_FLOW,
		};

	/**
	 * A public read-only list of all the '<em><b>Effect Code</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EffectCode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Effect Code</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EffectCode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EffectCode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Effect Code</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EffectCode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EffectCode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Effect Code</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EffectCode get(int value) {
		switch (value) {
			case TRAFFIC_FLOW_UNKNOWN_VALUE: return TRAFFIC_FLOW_UNKNOWN;
			case FREE_TRAFFIC_FLOW_VALUE: return FREE_TRAFFIC_FLOW;
			case HEAVY_TRAFFIC_VALUE: return HEAVY_TRAFFIC;
			case SLOW_TRAFFIC_VALUE: return SLOW_TRAFFIC;
			case QUEUING_TRAFFIC_VALUE: return QUEUING_TRAFFIC;
			case STATIONARY_TRAFFIC_VALUE: return STATIONARY_TRAFFIC;
			case NO_TRAFFIC_FLOW_VALUE: return NO_TRAFFIC_FLOW;
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
	private EffectCode(int value, String name, String literal) {
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
	
} //EffectCode
