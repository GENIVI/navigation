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
 * A representation of the literals of the enumeration '<em><b>Traffic Incident Feed Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This type provides information on the status of a Traffic Incident Feed, or of a combination of Traffic Incident Feeds.  
 * <!-- end-model-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getTrafficIncidentFeedStatus()
 * @model
 * @generated
 */
public enum TrafficIncidentFeedStatus implements Enumerator {
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
	 * The '<em><b>CONNECTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #CONNECTED_VALUE
	 * @generated
	 * @ordered
	 */
  CONNECTED(2, "CONNECTED", "CONNECTED"),

  /**
	 * The '<em><b>DISCONNECTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DISCONNECTED_VALUE
	 * @generated
	 * @ordered
	 */
  DISCONNECTED(3, "DISCONNECTED", "DISCONNECTED");

  /**
	 * The '<em><b>UNAVAILABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is no Traffic Incident Feed available. A feed is not available if a connection is not possible.
	 * Examples of this are: there is no location table available for the current country (in case of TMC),
	 * or the user has no valid subscription.
	 * <!-- end-model-doc -->
	 * @see #UNAVAILABLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int UNAVAILABLE_VALUE = 1;

  /**
	 * The '<em><b>CONNECTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * One or more Traffic Incident Feeds are available and connected (a communication channel is operational).
	 * <!-- end-model-doc -->
	 * @see #CONNECTED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int CONNECTED_VALUE = 2;

  /**
	 * The '<em><b>DISCONNECTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * One or more Traffic Incident Feeds are available but none of them is currently connected
	 * (the communication channels are not operational).
	 * For example, an RDS/TMC receiver is available but there is no signal,
	 * or a TPEG over HTTP/IP feed is available but the connection to the server failed.
	 * <!-- end-model-doc -->
	 * @see #DISCONNECTED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DISCONNECTED_VALUE = 3;

  /**
	 * An array of all the '<em><b>Traffic Incident Feed Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final TrafficIncidentFeedStatus[] VALUES_ARRAY =
    new TrafficIncidentFeedStatus[] {
			UNAVAILABLE,
			CONNECTED,
			DISCONNECTED,
		};

  /**
	 * A public read-only list of all the '<em><b>Traffic Incident Feed Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<TrafficIncidentFeedStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Traffic Incident Feed Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficIncidentFeedStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TrafficIncidentFeedStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Traffic Incident Feed Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficIncidentFeedStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TrafficIncidentFeedStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Traffic Incident Feed Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficIncidentFeedStatus get(int value) {
		switch (value) {
			case UNAVAILABLE_VALUE: return UNAVAILABLE;
			case CONNECTED_VALUE: return CONNECTED;
			case DISCONNECTED_VALUE: return DISCONNECTED;
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
  private TrafficIncidentFeedStatus(int value, String name, String literal) {
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
  
} //TrafficIncidentFeedStatus
