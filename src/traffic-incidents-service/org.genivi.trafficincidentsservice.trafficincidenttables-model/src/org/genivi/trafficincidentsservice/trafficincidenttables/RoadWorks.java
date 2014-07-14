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
 * A representation of the literals of the enumeration '<em><b>Road Works</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getRoadWorks()
 * @model
 * @generated
 */
public enum RoadWorks implements Enumerator {
  /**
	 * The '<em><b>MAJOR ROADWORKS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MAJOR_ROADWORKS_VALUE
	 * @generated
	 * @ordered
	 */
  MAJOR_ROADWORKS(1, "MAJOR_ROADWORKS", "MAJOR_ROADWORKS"),

  /**
	 * The '<em><b>ROAD MARKING WORK</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ROAD_MARKING_WORK_VALUE
	 * @generated
	 * @ordered
	 */
  ROAD_MARKING_WORK(2, "ROAD_MARKING_WORK", "ROAD_MARKING_WORK"),

  /**
	 * The '<em><b>SLOW MOVING ROAD MAINTENANCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SLOW_MOVING_ROAD_MAINTENANCE_VALUE
	 * @generated
	 * @ordered
	 */
  SLOW_MOVING_ROAD_MAINTENANCE(3, "SLOW_MOVING_ROAD_MAINTENANCE", "SLOW_MOVING_ROAD_MAINTENANCE");

  /**
	 * The '<em><b>MAJOR ROADWORKS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MAJOR ROADWORKS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MAJOR_ROADWORKS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MAJOR_ROADWORKS_VALUE = 1;

  /**
	 * The '<em><b>ROAD MARKING WORK</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ROAD MARKING WORK</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ROAD_MARKING_WORK
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int ROAD_MARKING_WORK_VALUE = 2;

  /**
	 * The '<em><b>SLOW MOVING ROAD MAINTENANCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SLOW MOVING ROAD MAINTENANCE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SLOW_MOVING_ROAD_MAINTENANCE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SLOW_MOVING_ROAD_MAINTENANCE_VALUE = 3;

  /**
	 * An array of all the '<em><b>Road Works</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final RoadWorks[] VALUES_ARRAY =
    new RoadWorks[] {
			MAJOR_ROADWORKS,
			ROAD_MARKING_WORK,
			SLOW_MOVING_ROAD_MAINTENANCE,
		};

  /**
	 * A public read-only list of all the '<em><b>Road Works</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<RoadWorks> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Road Works</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RoadWorks get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RoadWorks result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Road Works</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RoadWorks getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RoadWorks result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Road Works</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static RoadWorks get(int value) {
		switch (value) {
			case MAJOR_ROADWORKS_VALUE: return MAJOR_ROADWORKS;
			case ROAD_MARKING_WORK_VALUE: return ROAD_MARKING_WORK;
			case SLOW_MOVING_ROAD_MAINTENANCE_VALUE: return SLOW_MOVING_ROAD_MAINTENANCE;
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
  private RoadWorks(int value, String name, String literal) {
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
  
} //RoadWorks
