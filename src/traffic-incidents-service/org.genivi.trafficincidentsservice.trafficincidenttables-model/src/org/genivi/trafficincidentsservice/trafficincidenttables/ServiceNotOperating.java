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
 * A representation of the literals of the enumeration '<em><b>Service Not Operating</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getServiceNotOperating()
 * @model
 * @generated
 */
public enum ServiceNotOperating implements Enumerator {
  /**
	 * The '<em><b>FERRY SERVICE NOT OPERATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #FERRY_SERVICE_NOT_OPERATING_VALUE
	 * @generated
	 * @ordered
	 */
  FERRY_SERVICE_NOT_OPERATING(1, "FERRY_SERVICE_NOT_OPERATING", "FERRY_SERVICE_NOT_OPERATING"),

  /**
	 * The '<em><b>PLANE SERVICE NOT OPERATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #PLANE_SERVICE_NOT_OPERATING_VALUE
	 * @generated
	 * @ordered
	 */
  PLANE_SERVICE_NOT_OPERATING(2, "PLANE_SERVICE_NOT_OPERATING", "PLANE_SERVICE_NOT_OPERATING"),

  /**
	 * The '<em><b>TRAIN SERVICE NOT OPERATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TRAIN_SERVICE_NOT_OPERATING_VALUE
	 * @generated
	 * @ordered
	 */
  TRAIN_SERVICE_NOT_OPERATING(3, "TRAIN_SERVICE_NOT_OPERATING", "TRAIN_SERVICE_NOT_OPERATING"),

  /**
	 * The '<em><b>BUS SERVICE NOT OPERATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #BUS_SERVICE_NOT_OPERATING_VALUE
	 * @generated
	 * @ordered
	 */
  BUS_SERVICE_NOT_OPERATING(4, "BUS_SERVICE_NOT_OPERATING", "BUS_SERVICE_NOT_OPERATING");

  /**
	 * The '<em><b>FERRY SERVICE NOT OPERATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FERRY SERVICE NOT OPERATING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #FERRY_SERVICE_NOT_OPERATING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int FERRY_SERVICE_NOT_OPERATING_VALUE = 1;

  /**
	 * The '<em><b>PLANE SERVICE NOT OPERATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PLANE SERVICE NOT OPERATING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #PLANE_SERVICE_NOT_OPERATING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int PLANE_SERVICE_NOT_OPERATING_VALUE = 2;

  /**
	 * The '<em><b>TRAIN SERVICE NOT OPERATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TRAIN SERVICE NOT OPERATING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TRAIN_SERVICE_NOT_OPERATING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TRAIN_SERVICE_NOT_OPERATING_VALUE = 3;

  /**
	 * The '<em><b>BUS SERVICE NOT OPERATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BUS SERVICE NOT OPERATING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #BUS_SERVICE_NOT_OPERATING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int BUS_SERVICE_NOT_OPERATING_VALUE = 4;

  /**
	 * An array of all the '<em><b>Service Not Operating</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final ServiceNotOperating[] VALUES_ARRAY =
    new ServiceNotOperating[] {
			FERRY_SERVICE_NOT_OPERATING,
			PLANE_SERVICE_NOT_OPERATING,
			TRAIN_SERVICE_NOT_OPERATING,
			BUS_SERVICE_NOT_OPERATING,
		};

  /**
	 * A public read-only list of all the '<em><b>Service Not Operating</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<ServiceNotOperating> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Service Not Operating</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ServiceNotOperating get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceNotOperating result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Service Not Operating</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ServiceNotOperating getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceNotOperating result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Service Not Operating</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ServiceNotOperating get(int value) {
		switch (value) {
			case FERRY_SERVICE_NOT_OPERATING_VALUE: return FERRY_SERVICE_NOT_OPERATING;
			case PLANE_SERVICE_NOT_OPERATING_VALUE: return PLANE_SERVICE_NOT_OPERATING;
			case TRAIN_SERVICE_NOT_OPERATING_VALUE: return TRAIN_SERVICE_NOT_OPERATING;
			case BUS_SERVICE_NOT_OPERATING_VALUE: return BUS_SERVICE_NOT_OPERATING;
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
  private ServiceNotOperating(int value, String name, String literal) {
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
  
} //ServiceNotOperating
