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
 * A representation of the literals of the enumeration '<em><b>Traffic Congestion</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getTrafficCongestion()
 * @model
 * @generated
 */
public enum TrafficCongestion implements Enumerator {
  /**
	 * The '<em><b>INCREASED VOLUME OF TRAFFIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #INCREASED_VOLUME_OF_TRAFFIC_VALUE
	 * @generated
	 * @ordered
	 */
  INCREASED_VOLUME_OF_TRAFFIC(1, "INCREASED_VOLUME_OF_TRAFFIC", "INCREASED_VOLUME_OF_TRAFFIC");

  /**
	 * The '<em><b>INCREASED VOLUME OF TRAFFIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INCREASED VOLUME OF TRAFFIC</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #INCREASED_VOLUME_OF_TRAFFIC
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int INCREASED_VOLUME_OF_TRAFFIC_VALUE = 1;

  /**
	 * An array of all the '<em><b>Traffic Congestion</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final TrafficCongestion[] VALUES_ARRAY =
    new TrafficCongestion[] {
			INCREASED_VOLUME_OF_TRAFFIC,
		};

  /**
	 * A public read-only list of all the '<em><b>Traffic Congestion</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<TrafficCongestion> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Traffic Congestion</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficCongestion get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TrafficCongestion result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Traffic Congestion</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficCongestion getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TrafficCongestion result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Traffic Congestion</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficCongestion get(int value) {
		switch (value) {
			case INCREASED_VOLUME_OF_TRAFFIC_VALUE: return INCREASED_VOLUME_OF_TRAFFIC;
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
  private TrafficCongestion(int value, String name, String literal) {
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
  
} //TrafficCongestion
