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
 * A representation of the literals of the enumeration '<em><b>Rescue And Recovery Work In Progress</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getRescueAndRecoveryWorkInProgress()
 * @model
 * @generated
 */
public enum RescueAndRecoveryWorkInProgress implements Enumerator {
  /**
	 * The '<em><b>EMERGENCY VEHICLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #EMERGENCY_VEHICLES_VALUE
	 * @generated
	 * @ordered
	 */
  EMERGENCY_VEHICLES(1, "EMERGENCY_VEHICLES", "EMERGENCY_VEHICLES"),

  /**
	 * The '<em><b>RESCUE HELICOPTER LANDING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RESCUE_HELICOPTER_LANDING_VALUE
	 * @generated
	 * @ordered
	 */
  RESCUE_HELICOPTER_LANDING(2, "RESCUE_HELICOPTER_LANDING", "RESCUE_HELICOPTER_LANDING"),

  /**
	 * The '<em><b>POLICE ACTIVITY ONGOING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #POLICE_ACTIVITY_ONGOING_VALUE
	 * @generated
	 * @ordered
	 */
  POLICE_ACTIVITY_ONGOING(3, "POLICE_ACTIVITY_ONGOING", "POLICE_ACTIVITY_ONGOING"),

  /**
	 * The '<em><b>MEDICAL EMERGENCY ONGOING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MEDICAL_EMERGENCY_ONGOING_VALUE
	 * @generated
	 * @ordered
	 */
  MEDICAL_EMERGENCY_ONGOING(4, "MEDICAL_EMERGENCY_ONGOING", "MEDICAL_EMERGENCY_ONGOING"),

  /**
	 * The '<em><b>CHILD ABDUCTION IN PROGRESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #CHILD_ABDUCTION_IN_PROGRESS_VALUE
	 * @generated
	 * @ordered
	 */
  CHILD_ABDUCTION_IN_PROGRESS(5, "CHILD_ABDUCTION_IN_PROGRESS", "CHILD_ABDUCTION_IN_PROGRESS");

  /**
	 * The '<em><b>EMERGENCY VEHICLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EMERGENCY VEHICLES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #EMERGENCY_VEHICLES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int EMERGENCY_VEHICLES_VALUE = 1;

  /**
	 * The '<em><b>RESCUE HELICOPTER LANDING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RESCUE HELICOPTER LANDING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RESCUE_HELICOPTER_LANDING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int RESCUE_HELICOPTER_LANDING_VALUE = 2;

  /**
	 * The '<em><b>POLICE ACTIVITY ONGOING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>POLICE ACTIVITY ONGOING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #POLICE_ACTIVITY_ONGOING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int POLICE_ACTIVITY_ONGOING_VALUE = 3;

  /**
	 * The '<em><b>MEDICAL EMERGENCY ONGOING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MEDICAL EMERGENCY ONGOING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MEDICAL_EMERGENCY_ONGOING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MEDICAL_EMERGENCY_ONGOING_VALUE = 4;

  /**
	 * The '<em><b>CHILD ABDUCTION IN PROGRESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CHILD ABDUCTION IN PROGRESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #CHILD_ABDUCTION_IN_PROGRESS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int CHILD_ABDUCTION_IN_PROGRESS_VALUE = 5;

  /**
	 * An array of all the '<em><b>Rescue And Recovery Work In Progress</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final RescueAndRecoveryWorkInProgress[] VALUES_ARRAY =
    new RescueAndRecoveryWorkInProgress[] {
			EMERGENCY_VEHICLES,
			RESCUE_HELICOPTER_LANDING,
			POLICE_ACTIVITY_ONGOING,
			MEDICAL_EMERGENCY_ONGOING,
			CHILD_ABDUCTION_IN_PROGRESS,
		};

  /**
	 * A public read-only list of all the '<em><b>Rescue And Recovery Work In Progress</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<RescueAndRecoveryWorkInProgress> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Rescue And Recovery Work In Progress</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RescueAndRecoveryWorkInProgress get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RescueAndRecoveryWorkInProgress result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Rescue And Recovery Work In Progress</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RescueAndRecoveryWorkInProgress getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RescueAndRecoveryWorkInProgress result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Rescue And Recovery Work In Progress</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RescueAndRecoveryWorkInProgress get(int value) {
		switch (value) {
			case EMERGENCY_VEHICLES_VALUE: return EMERGENCY_VEHICLES;
			case RESCUE_HELICOPTER_LANDING_VALUE: return RESCUE_HELICOPTER_LANDING;
			case POLICE_ACTIVITY_ONGOING_VALUE: return POLICE_ACTIVITY_ONGOING;
			case MEDICAL_EMERGENCY_ONGOING_VALUE: return MEDICAL_EMERGENCY_ONGOING;
			case CHILD_ABDUCTION_IN_PROGRESS_VALUE: return CHILD_ABDUCTION_IN_PROGRESS;
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
  private RescueAndRecoveryWorkInProgress(int value, String name, String literal) {
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
  
} //RescueAndRecoveryWorkInProgress
