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
 * A representation of the literals of the enumeration '<em><b>Dangerous End Of Queue</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getDangerousEndOfQueue()
 * @model
 * @generated
 */
public enum DangerousEndOfQueue implements Enumerator {
  /**
	 * The '<em><b>SUDDEN END OF QUEUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SUDDEN_END_OF_QUEUE_VALUE
	 * @generated
	 * @ordered
	 */
  SUDDEN_END_OF_QUEUE(1, "SUDDEN_END_OF_QUEUE", "SUDDEN_END_OF_QUEUE"),

  /**
	 * The '<em><b>QUEUE OVER HILL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #QUEUE_OVER_HILL_VALUE
	 * @generated
	 * @ordered
	 */
  QUEUE_OVER_HILL(2, "QUEUE_OVER_HILL", "QUEUE_OVER_HILL"),

  /**
	 * The '<em><b>QUEUE AROUND BEND</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #QUEUE_AROUND_BEND_VALUE
	 * @generated
	 * @ordered
	 */
  QUEUE_AROUND_BEND(3, "QUEUE_AROUND_BEND", "QUEUE_AROUND_BEND"),

  /**
	 * The '<em><b>QUEUE IN TUNNEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #QUEUE_IN_TUNNEL_VALUE
	 * @generated
	 * @ordered
	 */
  QUEUE_IN_TUNNEL(4, "QUEUE_IN_TUNNEL", "QUEUE_IN_TUNNEL");

  /**
	 * The '<em><b>SUDDEN END OF QUEUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUDDEN END OF QUEUE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SUDDEN_END_OF_QUEUE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SUDDEN_END_OF_QUEUE_VALUE = 1;

  /**
	 * The '<em><b>QUEUE OVER HILL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>QUEUE OVER HILL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #QUEUE_OVER_HILL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int QUEUE_OVER_HILL_VALUE = 2;

  /**
	 * The '<em><b>QUEUE AROUND BEND</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>QUEUE AROUND BEND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #QUEUE_AROUND_BEND
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int QUEUE_AROUND_BEND_VALUE = 3;

  /**
	 * The '<em><b>QUEUE IN TUNNEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>QUEUE IN TUNNEL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #QUEUE_IN_TUNNEL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int QUEUE_IN_TUNNEL_VALUE = 4;

  /**
	 * An array of all the '<em><b>Dangerous End Of Queue</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final DangerousEndOfQueue[] VALUES_ARRAY =
    new DangerousEndOfQueue[] {
			SUDDEN_END_OF_QUEUE,
			QUEUE_OVER_HILL,
			QUEUE_AROUND_BEND,
			QUEUE_IN_TUNNEL,
		};

  /**
	 * A public read-only list of all the '<em><b>Dangerous End Of Queue</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<DangerousEndOfQueue> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Dangerous End Of Queue</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DangerousEndOfQueue get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DangerousEndOfQueue result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Dangerous End Of Queue</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DangerousEndOfQueue getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DangerousEndOfQueue result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Dangerous End Of Queue</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DangerousEndOfQueue get(int value) {
		switch (value) {
			case SUDDEN_END_OF_QUEUE_VALUE: return SUDDEN_END_OF_QUEUE;
			case QUEUE_OVER_HILL_VALUE: return QUEUE_OVER_HILL;
			case QUEUE_AROUND_BEND_VALUE: return QUEUE_AROUND_BEND;
			case QUEUE_IN_TUNNEL_VALUE: return QUEUE_IN_TUNNEL;
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
  private DangerousEndOfQueue(int value, String name, String literal) {
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
  
} //DangerousEndOfQueue
