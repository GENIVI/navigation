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
 * A representation of the literals of the enumeration '<em><b>Objects On The Road</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getObjectsOnTheRoad()
 * @model
 * @generated
 */
public enum ObjectsOnTheRoad implements Enumerator {
	/**
	 * The '<em><b>SHED LOAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHED_LOAD_VALUE
	 * @generated
	 * @ordered
	 */
	SHED_LOAD(1, "SHED_LOAD", "SHED_LOAD"),

	/**
	 * The '<em><b>PARTS OF VEHICLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTS_OF_VEHICLES_VALUE
	 * @generated
	 * @ordered
	 */
	PARTS_OF_VEHICLES(2, "PARTS_OF_VEHICLES", "PARTS_OF_VEHICLES"),

	/**
	 * The '<em><b>PARTS OF TYRES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTS_OF_TYRES_VALUE
	 * @generated
	 * @ordered
	 */
	PARTS_OF_TYRES(3, "PARTS_OF_TYRES", "PARTS_OF_TYRES"),

	/**
	 * The '<em><b>BIG OBJECTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIG_OBJECTS_VALUE
	 * @generated
	 * @ordered
	 */
	BIG_OBJECTS(4, "BIG_OBJECTS", "BIG_OBJECTS"),

	/**
	 * The '<em><b>FALLEN TREES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FALLEN_TREES_VALUE
	 * @generated
	 * @ordered
	 */
	FALLEN_TREES(5, "FALLEN_TREES", "FALLEN_TREES"),

	/**
	 * The '<em><b>HUB CAPS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HUB_CAPS_VALUE
	 * @generated
	 * @ordered
	 */
	HUB_CAPS(6, "HUB_CAPS", "HUB_CAPS"), /**
	 * The '<em><b>WAITING VEHICLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WAITING_VEHICLES_VALUE
	 * @generated
	 * @ordered
	 */
  WAITING_VEHICLES(7, "WAITING_VEHICLES", "WAITING_VEHICLES");

	/**
	 * The '<em><b>SHED LOAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHED LOAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHED_LOAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHED_LOAD_VALUE = 1;

	/**
	 * The '<em><b>PARTS OF VEHICLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PARTS OF VEHICLES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARTS_OF_VEHICLES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PARTS_OF_VEHICLES_VALUE = 2;

	/**
	 * The '<em><b>PARTS OF TYRES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PARTS OF TYRES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARTS_OF_TYRES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PARTS_OF_TYRES_VALUE = 3;

	/**
	 * The '<em><b>BIG OBJECTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BIG OBJECTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BIG_OBJECTS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BIG_OBJECTS_VALUE = 4;

	/**
	 * The '<em><b>FALLEN TREES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FALLEN TREES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FALLEN_TREES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FALLEN_TREES_VALUE = 5;

	/**
	 * The '<em><b>HUB CAPS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HUB CAPS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HUB_CAPS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HUB_CAPS_VALUE = 6;

	/**
	 * The '<em><b>WAITING VEHICLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WAITING VEHICLES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WAITING_VEHICLES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WAITING_VEHICLES_VALUE = 7;

  /**
	 * An array of all the '<em><b>Objects On The Road</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ObjectsOnTheRoad[] VALUES_ARRAY =
		new ObjectsOnTheRoad[] {
			SHED_LOAD,
			PARTS_OF_VEHICLES,
			PARTS_OF_TYRES,
			BIG_OBJECTS,
			FALLEN_TREES,
			HUB_CAPS,
			WAITING_VEHICLES,
		};

	/**
	 * A public read-only list of all the '<em><b>Objects On The Road</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ObjectsOnTheRoad> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Objects On The Road</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ObjectsOnTheRoad get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ObjectsOnTheRoad result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Objects On The Road</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ObjectsOnTheRoad getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ObjectsOnTheRoad result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Objects On The Road</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ObjectsOnTheRoad get(int value) {
		switch (value) {
			case SHED_LOAD_VALUE: return SHED_LOAD;
			case PARTS_OF_VEHICLES_VALUE: return PARTS_OF_VEHICLES;
			case PARTS_OF_TYRES_VALUE: return PARTS_OF_TYRES;
			case BIG_OBJECTS_VALUE: return BIG_OBJECTS;
			case FALLEN_TREES_VALUE: return FALLEN_TREES;
			case HUB_CAPS_VALUE: return HUB_CAPS;
			case WAITING_VEHICLES_VALUE: return WAITING_VEHICLES;
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
	private ObjectsOnTheRoad(int value, String name, String literal) {
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
	
} //ObjectsOnTheRoad
