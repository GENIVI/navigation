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
 * A representation of the literals of the enumeration '<em><b>Use Toll Lanes</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getUseTollLanes()
 * @model
 * @generated
 */
public enum UseTollLanes implements Enumerator {
  /**
	 * The '<em><b>USE MANUAL PAYMENT TOLL LANES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #USE_MANUAL_PAYMENT_TOLL_LANES_VALUE
	 * @generated
	 * @ordered
	 */
  USE_MANUAL_PAYMENT_TOLL_LANES(1, "USE_MANUAL_PAYMENT_TOLL_LANES", "USE_MANUAL_PAYMENT_TOLL_LANES"),

  /**
	 * The '<em><b>USE AUTOMATIC PAYMENT TOLL LANES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #USE_AUTOMATIC_PAYMENT_TOLL_LANES_VALUE
	 * @generated
	 * @ordered
	 */
  USE_AUTOMATIC_PAYMENT_TOLL_LANES(2, "USE_AUTOMATIC_PAYMENT_TOLL_LANES", "USE_AUTOMATIC_PAYMENT_TOLL_LANES");

  /**
	 * The '<em><b>USE MANUAL PAYMENT TOLL LANES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>USE MANUAL PAYMENT TOLL LANES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #USE_MANUAL_PAYMENT_TOLL_LANES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int USE_MANUAL_PAYMENT_TOLL_LANES_VALUE = 1;

  /**
	 * The '<em><b>USE AUTOMATIC PAYMENT TOLL LANES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>USE AUTOMATIC PAYMENT TOLL LANES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #USE_AUTOMATIC_PAYMENT_TOLL_LANES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int USE_AUTOMATIC_PAYMENT_TOLL_LANES_VALUE = 2;

  /**
	 * An array of all the '<em><b>Use Toll Lanes</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final UseTollLanes[] VALUES_ARRAY =
    new UseTollLanes[] {
			USE_MANUAL_PAYMENT_TOLL_LANES,
			USE_AUTOMATIC_PAYMENT_TOLL_LANES,
		};

  /**
	 * A public read-only list of all the '<em><b>Use Toll Lanes</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<UseTollLanes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Use Toll Lanes</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static UseTollLanes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UseTollLanes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Use Toll Lanes</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static UseTollLanes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UseTollLanes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Use Toll Lanes</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static UseTollLanes get(int value) {
		switch (value) {
			case USE_MANUAL_PAYMENT_TOLL_LANES_VALUE: return USE_MANUAL_PAYMENT_TOLL_LANES;
			case USE_AUTOMATIC_PAYMENT_TOLL_LANES_VALUE: return USE_AUTOMATIC_PAYMENT_TOLL_LANES;
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
  private UseTollLanes(int value, String name, String literal) {
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
  
} //UseTollLanes
