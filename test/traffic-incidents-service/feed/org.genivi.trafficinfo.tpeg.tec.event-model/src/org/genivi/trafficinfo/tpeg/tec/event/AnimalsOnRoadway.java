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
 * A representation of the literals of the enumeration '<em><b>Animals On Roadway</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getAnimalsOnRoadway()
 * @model
 * @generated
 */
public enum AnimalsOnRoadway implements Enumerator {
	/**
	 * The '<em><b>WILD ANIMALS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WILD_ANIMALS_VALUE
	 * @generated
	 * @ordered
	 */
	WILD_ANIMALS(1, "WILD_ANIMALS", "WILD_ANIMALS"),

	/**
	 * The '<em><b>HERD OF ANIMALS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HERD_OF_ANIMALS_VALUE
	 * @generated
	 * @ordered
	 */
	HERD_OF_ANIMALS(2, "HERD_OF_ANIMALS", "HERD_OF_ANIMALS"),

	/**
	 * The '<em><b>SMALL ANIMALS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMALL_ANIMALS_VALUE
	 * @generated
	 * @ordered
	 */
	SMALL_ANIMALS(3, "SMALL_ANIMALS", "SMALL_ANIMALS"),

	/**
	 * The '<em><b>LARGE ANIMALS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LARGE_ANIMALS_VALUE
	 * @generated
	 * @ordered
	 */
	LARGE_ANIMALS(4, "LARGE_ANIMALS", "LARGE_ANIMALS");

	/**
	 * The '<em><b>WILD ANIMALS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WILD ANIMALS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WILD_ANIMALS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WILD_ANIMALS_VALUE = 1;

	/**
	 * The '<em><b>HERD OF ANIMALS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HERD OF ANIMALS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HERD_OF_ANIMALS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HERD_OF_ANIMALS_VALUE = 2;

	/**
	 * The '<em><b>SMALL ANIMALS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SMALL ANIMALS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMALL_ANIMALS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SMALL_ANIMALS_VALUE = 3;

	/**
	 * The '<em><b>LARGE ANIMALS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LARGE ANIMALS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LARGE_ANIMALS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LARGE_ANIMALS_VALUE = 4;

	/**
	 * An array of all the '<em><b>Animals On Roadway</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AnimalsOnRoadway[] VALUES_ARRAY =
		new AnimalsOnRoadway[] {
			WILD_ANIMALS,
			HERD_OF_ANIMALS,
			SMALL_ANIMALS,
			LARGE_ANIMALS,
		};

	/**
	 * A public read-only list of all the '<em><b>Animals On Roadway</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AnimalsOnRoadway> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Animals On Roadway</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnimalsOnRoadway get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnimalsOnRoadway result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Animals On Roadway</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnimalsOnRoadway getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnimalsOnRoadway result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Animals On Roadway</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnimalsOnRoadway get(int value) {
		switch (value) {
			case WILD_ANIMALS_VALUE: return WILD_ANIMALS;
			case HERD_OF_ANIMALS_VALUE: return HERD_OF_ANIMALS;
			case SMALL_ANIMALS_VALUE: return SMALL_ANIMALS;
			case LARGE_ANIMALS_VALUE: return LARGE_ANIMALS;
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
	private AnimalsOnRoadway(int value, String name, String literal) {
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
	
} //AnimalsOnRoadway
