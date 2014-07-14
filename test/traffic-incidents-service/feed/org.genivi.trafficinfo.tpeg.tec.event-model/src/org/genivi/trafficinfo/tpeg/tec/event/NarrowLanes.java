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
 * A representation of the literals of the enumeration '<em><b>Narrow Lanes</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getNarrowLanes()
 * @model
 * @generated
 */
public enum NarrowLanes implements Enumerator {
	/**
	 * The '<em><b>CONTRAFLOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTRAFLOW_VALUE
	 * @generated
	 * @ordered
	 */
	CONTRAFLOW(1, "CONTRAFLOW", "CONTRAFLOW"),

	/**
	 * The '<em><b>HARD SHOULDER CLOSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HARD_SHOULDER_CLOSED_VALUE
	 * @generated
	 * @ordered
	 */
	HARD_SHOULDER_CLOSED(2, "HARD_SHOULDER_CLOSED", "HARD_SHOULDER_CLOSED"),

	/**
	 * The '<em><b>SLIP LANE CLOSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIP_LANE_CLOSED_VALUE
	 * @generated
	 * @ordered
	 */
	SLIP_LANE_CLOSED(3, "SLIP_LANE_CLOSED", "SLIP_LANE_CLOSED"),

	/**
	 * The '<em><b>CRAWLER LANE CLOSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRAWLER_LANE_CLOSED_VALUE
	 * @generated
	 * @ordered
	 */
	CRAWLER_LANE_CLOSED(4, "CRAWLER_LANE_CLOSED", "CRAWLER_LANE_CLOSED");

	/**
	 * The '<em><b>CONTRAFLOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTRAFLOW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTRAFLOW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTRAFLOW_VALUE = 1;

	/**
	 * The '<em><b>HARD SHOULDER CLOSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HARD SHOULDER CLOSED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HARD_SHOULDER_CLOSED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HARD_SHOULDER_CLOSED_VALUE = 2;

	/**
	 * The '<em><b>SLIP LANE CLOSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIP LANE CLOSED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIP_LANE_CLOSED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIP_LANE_CLOSED_VALUE = 3;

	/**
	 * The '<em><b>CRAWLER LANE CLOSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CRAWLER LANE CLOSED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CRAWLER_LANE_CLOSED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CRAWLER_LANE_CLOSED_VALUE = 4;

	/**
	 * An array of all the '<em><b>Narrow Lanes</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final NarrowLanes[] VALUES_ARRAY =
		new NarrowLanes[] {
			CONTRAFLOW,
			HARD_SHOULDER_CLOSED,
			SLIP_LANE_CLOSED,
			CRAWLER_LANE_CLOSED,
		};

	/**
	 * A public read-only list of all the '<em><b>Narrow Lanes</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<NarrowLanes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Narrow Lanes</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NarrowLanes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NarrowLanes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Narrow Lanes</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NarrowLanes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NarrowLanes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Narrow Lanes</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NarrowLanes get(int value) {
		switch (value) {
			case CONTRAFLOW_VALUE: return CONTRAFLOW;
			case HARD_SHOULDER_CLOSED_VALUE: return HARD_SHOULDER_CLOSED;
			case SLIP_LANE_CLOSED_VALUE: return SLIP_LANE_CLOSED;
			case CRAWLER_LANE_CLOSED_VALUE: return CRAWLER_LANE_CLOSED;
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
	private NarrowLanes(int value, String name, String literal) {
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
	
} //NarrowLanes
