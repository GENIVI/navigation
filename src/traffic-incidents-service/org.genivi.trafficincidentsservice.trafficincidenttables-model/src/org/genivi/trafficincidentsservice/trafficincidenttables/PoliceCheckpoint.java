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
 * A representation of the literals of the enumeration '<em><b>Police Checkpoint</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getPoliceCheckpoint()
 * @model
 * @generated
 */
public enum PoliceCheckpoint implements Enumerator {
  /**
	 * The '<em><b>PERMANENT POLICE CHECKPOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #PERMANENT_POLICE_CHECKPOINT_VALUE
	 * @generated
	 * @ordered
	 */
  PERMANENT_POLICE_CHECKPOINT(1, "PERMANENT_POLICE_CHECKPOINT", "PERMANENT_POLICE_CHECKPOINT"),

  /**
	 * The '<em><b>TEMPORARY POLICE CHECKPOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TEMPORARY_POLICE_CHECKPOINT_VALUE
	 * @generated
	 * @ordered
	 */
  TEMPORARY_POLICE_CHECKPOINT(2, "TEMPORARY_POLICE_CHECKPOINT", "TEMPORARY_POLICE_CHECKPOINT");

  /**
	 * The '<em><b>PERMANENT POLICE CHECKPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PERMANENT POLICE CHECKPOINT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #PERMANENT_POLICE_CHECKPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int PERMANENT_POLICE_CHECKPOINT_VALUE = 1;

  /**
	 * The '<em><b>TEMPORARY POLICE CHECKPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TEMPORARY POLICE CHECKPOINT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TEMPORARY_POLICE_CHECKPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TEMPORARY_POLICE_CHECKPOINT_VALUE = 2;

  /**
	 * An array of all the '<em><b>Police Checkpoint</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final PoliceCheckpoint[] VALUES_ARRAY =
    new PoliceCheckpoint[] {
			PERMANENT_POLICE_CHECKPOINT,
			TEMPORARY_POLICE_CHECKPOINT,
		};

  /**
	 * A public read-only list of all the '<em><b>Police Checkpoint</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<PoliceCheckpoint> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Police Checkpoint</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static PoliceCheckpoint get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PoliceCheckpoint result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Police Checkpoint</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static PoliceCheckpoint getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PoliceCheckpoint result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Police Checkpoint</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static PoliceCheckpoint get(int value) {
		switch (value) {
			case PERMANENT_POLICE_CHECKPOINT_VALUE: return PERMANENT_POLICE_CHECKPOINT;
			case TEMPORARY_POLICE_CHECKPOINT_VALUE: return TEMPORARY_POLICE_CHECKPOINT;
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
  private PoliceCheckpoint(int value, String name, String literal) {
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
  
} //PoliceCheckpoint
