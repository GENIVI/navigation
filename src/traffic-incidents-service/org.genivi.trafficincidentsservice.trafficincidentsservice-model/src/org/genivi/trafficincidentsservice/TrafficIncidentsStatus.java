/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Traffic Incidents Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This type provides information on the status of the Traffic Incidents.  
 * <!-- end-model-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getTrafficIncidentsStatus()
 * @model
 * @generated
 */
public enum TrafficIncidentsStatus implements Enumerator {
  /**
	 * The '<em><b>UNAVAILABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #UNAVAILABLE_VALUE
	 * @generated
	 * @ordered
	 */
  UNAVAILABLE(1, "UNAVAILABLE", "UNAVAILABLE"),

  /**
	 * The '<em><b>PARTLY AVAILABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #PARTLY_AVAILABLE_VALUE
	 * @generated
	 * @ordered
	 */
  PARTLY_AVAILABLE(2, "PARTLY_AVAILABLE", "PARTLY_AVAILABLE"),

  /**
	 * The '<em><b>AVAILABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #AVAILABLE_VALUE
	 * @generated
	 * @ordered
	 */
  AVAILABLE(3, "AVAILABLE", "AVAILABLE");

  /**
	 * The '<em><b>UNAVAILABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is no Traffic Incident data available.
	 * <!-- end-model-doc -->
	 * @see #UNAVAILABLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int UNAVAILABLE_VALUE = 1;

  /**
	 * The '<em><b>PARTLY AVAILABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is incomplete Traffic Incident data available. This happens e.g. if the Feed status has changed from DISCONNECTED to CONNECTED
	 * and the system knows that not all information has been received, or if the Feed status goes temporarily from CONNECTED to DISCONNECTED.
	 * <!-- end-model-doc -->
	 * @see #PARTLY_AVAILABLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int PARTLY_AVAILABLE_VALUE = 2;

  /**
	 * The '<em><b>AVAILABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is Traffic Incident data available.
	 * <!-- end-model-doc -->
	 * @see #AVAILABLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int AVAILABLE_VALUE = 3;

  /**
	 * An array of all the '<em><b>Traffic Incidents Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final TrafficIncidentsStatus[] VALUES_ARRAY =
    new TrafficIncidentsStatus[] {
			UNAVAILABLE,
			PARTLY_AVAILABLE,
			AVAILABLE,
		};

  /**
	 * A public read-only list of all the '<em><b>Traffic Incidents Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<TrafficIncidentsStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Traffic Incidents Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficIncidentsStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TrafficIncidentsStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Traffic Incidents Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficIncidentsStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TrafficIncidentsStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Traffic Incidents Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficIncidentsStatus get(int value) {
		switch (value) {
			case UNAVAILABLE_VALUE: return UNAVAILABLE;
			case PARTLY_AVAILABLE_VALUE: return PARTLY_AVAILABLE;
			case AVAILABLE_VALUE: return AVAILABLE;
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
  private TrafficIncidentsStatus(int value, String name, String literal) {
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
  
} //TrafficIncidentsStatus
