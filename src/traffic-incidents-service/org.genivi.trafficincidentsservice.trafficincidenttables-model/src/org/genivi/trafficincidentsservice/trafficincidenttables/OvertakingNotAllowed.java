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
 * A representation of the literals of the enumeration '<em><b>Overtaking Not Allowed</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getOvertakingNotAllowed()
 * @model
 * @generated
 */
public enum OvertakingNotAllowed implements Enumerator {
  /**
	 * The '<em><b>DO NOT USE OVERTAKING LANES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DO_NOT_USE_OVERTAKING_LANES_VALUE
	 * @generated
	 * @ordered
	 */
  DO_NOT_USE_OVERTAKING_LANES(1, "DO_NOT_USE_OVERTAKING_LANES", "DO_NOT_USE_OVERTAKING_LANES"),

  /**
	 * The '<em><b>OVERTAKING NOT ALLOWED DRIVE ON CRAWLER LANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE_VALUE
	 * @generated
	 * @ordered
	 */
  OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE(2, "OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE", "OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE"),

  /**
	 * The '<em><b>OVERTAKING NOT ALLOWED DRIVE ON LEFT MOST LANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE_VALUE
	 * @generated
	 * @ordered
	 */
  OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE(3, "OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE", "OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE"),

  /**
	 * The '<em><b>OVERTAKING NOT ALLOWED DRIVE ON RIGHT MOST LANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE_VALUE
	 * @generated
	 * @ordered
	 */
  OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE(4, "OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE", "OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE");

  /**
	 * The '<em><b>DO NOT USE OVERTAKING LANES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DO NOT USE OVERTAKING LANES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DO_NOT_USE_OVERTAKING_LANES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DO_NOT_USE_OVERTAKING_LANES_VALUE = 1;

  /**
	 * The '<em><b>OVERTAKING NOT ALLOWED DRIVE ON CRAWLER LANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OVERTAKING NOT ALLOWED DRIVE ON CRAWLER LANE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE_VALUE = 2;

  /**
	 * The '<em><b>OVERTAKING NOT ALLOWED DRIVE ON LEFT MOST LANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OVERTAKING NOT ALLOWED DRIVE ON LEFT MOST LANE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE_VALUE = 3;

  /**
	 * The '<em><b>OVERTAKING NOT ALLOWED DRIVE ON RIGHT MOST LANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OVERTAKING NOT ALLOWED DRIVE ON RIGHT MOST LANE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE_VALUE = 4;

  /**
	 * An array of all the '<em><b>Overtaking Not Allowed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final OvertakingNotAllowed[] VALUES_ARRAY =
    new OvertakingNotAllowed[] {
			DO_NOT_USE_OVERTAKING_LANES,
			OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE,
			OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE,
			OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE,
		};

  /**
	 * A public read-only list of all the '<em><b>Overtaking Not Allowed</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<OvertakingNotAllowed> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Overtaking Not Allowed</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static OvertakingNotAllowed get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OvertakingNotAllowed result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Overtaking Not Allowed</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static OvertakingNotAllowed getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OvertakingNotAllowed result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Overtaking Not Allowed</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static OvertakingNotAllowed get(int value) {
		switch (value) {
			case DO_NOT_USE_OVERTAKING_LANES_VALUE: return DO_NOT_USE_OVERTAKING_LANES;
			case OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE_VALUE: return OVERTAKING_NOT_ALLOWED_DRIVE_ON_CRAWLER_LANE;
			case OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE_VALUE: return OVERTAKING_NOT_ALLOWED_DRIVE_ON_LEFT_MOST_LANE;
			case OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE_VALUE: return OVERTAKING_NOT_ALLOWED_DRIVE_ON_RIGHT_MOST_LANE;
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
  private OvertakingNotAllowed(int value, String name, String literal) {
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
  
} //OvertakingNotAllowed
