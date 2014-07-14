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
 * A representation of the literals of the enumeration '<em><b>Drive Carefully</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getDriveCarefully()
 * @model
 * @generated
 */
public enum DriveCarefully implements Enumerator {
  /**
	 * The '<em><b>DRIVE CAREFULLY DANGEROUS SITUATION ON ENTRY SLIP ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
  DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD(1, "DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD", "DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD"),

  /**
	 * The '<em><b>DRIVE CAREFULLY DANGEROUS SITUATION ON EXIT SLIP ROAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD_VALUE
	 * @generated
	 * @ordered
	 */
  DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD(2, "DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD", "DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD"),

  /**
	 * The '<em><b>DRIVE CAREFULLY ICE BUILDUP ON CABLE STRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
  DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE(3, "DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE", "DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE");

  /**
	 * The '<em><b>DRIVE CAREFULLY DANGEROUS SITUATION ON ENTRY SLIP ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DRIVE CAREFULLY DANGEROUS SITUATION ON ENTRY SLIP ROAD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD_VALUE = 1;

  /**
	 * The '<em><b>DRIVE CAREFULLY DANGEROUS SITUATION ON EXIT SLIP ROAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DRIVE CAREFULLY DANGEROUS SITUATION ON EXIT SLIP ROAD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD_VALUE = 2;

  /**
	 * The '<em><b>DRIVE CAREFULLY ICE BUILDUP ON CABLE STRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DRIVE CAREFULLY ICE BUILDUP ON CABLE STRUCTURE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE_VALUE = 3;

  /**
	 * An array of all the '<em><b>Drive Carefully</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final DriveCarefully[] VALUES_ARRAY =
    new DriveCarefully[] {
			DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD,
			DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD,
			DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE,
		};

  /**
	 * A public read-only list of all the '<em><b>Drive Carefully</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<DriveCarefully> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Drive Carefully</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DriveCarefully get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DriveCarefully result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Drive Carefully</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DriveCarefully getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DriveCarefully result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Drive Carefully</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DriveCarefully get(int value) {
		switch (value) {
			case DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD_VALUE: return DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_ENTRY_SLIP_ROAD;
			case DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD_VALUE: return DRIVE_CAREFULLY_DANGEROUS_SITUATION_ON_EXIT_SLIP_ROAD;
			case DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE_VALUE: return DRIVE_CAREFULLY_ICE_BUILDUP_ON_CABLE_STRUCTURE;
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
  private DriveCarefully(int value, String name, String literal) {
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
  
} //DriveCarefully
