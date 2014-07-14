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
 * A representation of the literals of the enumeration '<em><b>Regulatory Measure</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getRegulatoryMeasure()
 * @model
 * @generated
 */
public enum RegulatoryMeasure implements Enumerator {
	/**
	 * The '<em><b>SECURITY ALERT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECURITY_ALERT_VALUE
	 * @generated
	 * @ordered
	 */
	SECURITY_ALERT(1, "SECURITY_ALERT", "SECURITY_ALERT"),

	/**
	 * The '<em><b>CONTAGIOUS DISEASE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTAGIOUS_DISEASE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTAGIOUS_DISEASE(2, "CONTAGIOUS_DISEASE", "CONTAGIOUS_DISEASE"),

	/**
	 * The '<em><b>ENVIRONMENTAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENVIRONMENTAL_VALUE
	 * @generated
	 * @ordered
	 */
	ENVIRONMENTAL(3, "ENVIRONMENTAL", "ENVIRONMENTAL"),

	/**
	 * The '<em><b>SMOG ALERT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMOG_ALERT_VALUE
	 * @generated
	 * @ordered
	 */
	SMOG_ALERT(4, "SMOG_ALERT", "SMOG_ALERT"), /**
	 * The '<em><b>BATCH SERVICE IN PROGRESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #BATCH_SERVICE_IN_PROGRESS_VALUE
	 * @generated
	 * @ordered
	 */
  BATCH_SERVICE_IN_PROGRESS(5, "BATCH_SERVICE_IN_PROGRESS", "BATCH_SERVICE_IN_PROGRESS"), /**
	 * The '<em><b>ROAD CLOSED BY THE REGULATORY AUTHORITIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES_VALUE
	 * @generated
	 * @ordered
	 */
	ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES(6, "ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES", "ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES");

	/**
	 * The '<em><b>SECURITY ALERT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SECURITY ALERT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECURITY_ALERT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SECURITY_ALERT_VALUE = 1;

	/**
	 * The '<em><b>CONTAGIOUS DISEASE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTAGIOUS DISEASE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTAGIOUS_DISEASE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTAGIOUS_DISEASE_VALUE = 2;

	/**
	 * The '<em><b>ENVIRONMENTAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENVIRONMENTAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENVIRONMENTAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENVIRONMENTAL_VALUE = 3;

	/**
	 * The '<em><b>SMOG ALERT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SMOG ALERT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMOG_ALERT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SMOG_ALERT_VALUE = 4;

	/**
	 * The '<em><b>BATCH SERVICE IN PROGRESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BATCH SERVICE IN PROGRESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #BATCH_SERVICE_IN_PROGRESS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int BATCH_SERVICE_IN_PROGRESS_VALUE = 5;

  /**
	 * The '<em><b>ROAD CLOSED BY THE REGULATORY AUTHORITIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROAD CLOSED BY THE REGULATORY AUTHORITIES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES_VALUE = 6;

		/**
	 * An array of all the '<em><b>Regulatory Measure</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RegulatoryMeasure[] VALUES_ARRAY =
		new RegulatoryMeasure[] {
			SECURITY_ALERT,
			CONTAGIOUS_DISEASE,
			ENVIRONMENTAL,
			SMOG_ALERT,
			BATCH_SERVICE_IN_PROGRESS,
			ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES,
		};

	/**
	 * A public read-only list of all the '<em><b>Regulatory Measure</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RegulatoryMeasure> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Regulatory Measure</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RegulatoryMeasure get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RegulatoryMeasure result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Regulatory Measure</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RegulatoryMeasure getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RegulatoryMeasure result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Regulatory Measure</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RegulatoryMeasure get(int value) {
		switch (value) {
			case SECURITY_ALERT_VALUE: return SECURITY_ALERT;
			case CONTAGIOUS_DISEASE_VALUE: return CONTAGIOUS_DISEASE;
			case ENVIRONMENTAL_VALUE: return ENVIRONMENTAL;
			case SMOG_ALERT_VALUE: return SMOG_ALERT;
			case BATCH_SERVICE_IN_PROGRESS_VALUE: return BATCH_SERVICE_IN_PROGRESS;
			case ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES_VALUE: return ROAD_CLOSED_BY_THE_REGULATORY_AUTHORITIES;
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
	private RegulatoryMeasure(int value, String name, String literal) {
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
	
} //RegulatoryMeasure
