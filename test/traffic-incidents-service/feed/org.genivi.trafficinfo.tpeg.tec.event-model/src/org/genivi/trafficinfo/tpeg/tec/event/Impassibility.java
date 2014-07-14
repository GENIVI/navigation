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
 * A representation of the literals of the enumeration '<em><b>Impassibility</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getImpassibility()
 * @model
 * @generated
 */
public enum Impassibility implements Enumerator {
	/**
	 * The '<em><b>FLOODING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOODING_VALUE
	 * @generated
	 * @ordered
	 */
	FLOODING(1, "FLOODING", "FLOODING"),

	/**
	 * The '<em><b>DANGER OF AVALANCHES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DANGER_OF_AVALANCHES_VALUE
	 * @generated
	 * @ordered
	 */
	DANGER_OF_AVALANCHES(2, "DANGER_OF_AVALANCHES", "DANGER_OF_AVALANCHES"),

	/**
	 * The '<em><b>BLASTING OF AVALANCHES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLASTING_OF_AVALANCHES_VALUE
	 * @generated
	 * @ordered
	 */
	BLASTING_OF_AVALANCHES(3, "BLASTING_OF_AVALANCHES", "BLASTING_OF_AVALANCHES"),

	/**
	 * The '<em><b>LANDSLIPS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LANDSLIPS_VALUE
	 * @generated
	 * @ordered
	 */
	LANDSLIPS(4, "LANDSLIPS", "LANDSLIPS"),

	/**
	 * The '<em><b>CHEMICAL SPILLAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHEMICAL_SPILLAGE_VALUE
	 * @generated
	 * @ordered
	 */
	CHEMICAL_SPILLAGE(5, "CHEMICAL_SPILLAGE", "CHEMICAL_SPILLAGE"), /**
	 * The '<em><b>WINTER CLOSURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #WINTER_CLOSURE_VALUE
	 * @generated
	 * @ordered
	 */
  WINTER_CLOSURE(6, "WINTER_CLOSURE", "WINTER_CLOSURE");

	/**
	 * The '<em><b>FLOODING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOODING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOODING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOODING_VALUE = 1;

	/**
	 * The '<em><b>DANGER OF AVALANCHES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DANGER OF AVALANCHES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DANGER_OF_AVALANCHES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DANGER_OF_AVALANCHES_VALUE = 2;

	/**
	 * The '<em><b>BLASTING OF AVALANCHES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BLASTING OF AVALANCHES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLASTING_OF_AVALANCHES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BLASTING_OF_AVALANCHES_VALUE = 3;

	/**
	 * The '<em><b>LANDSLIPS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LANDSLIPS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LANDSLIPS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LANDSLIPS_VALUE = 4;

	/**
	 * The '<em><b>CHEMICAL SPILLAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHEMICAL SPILLAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHEMICAL_SPILLAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHEMICAL_SPILLAGE_VALUE = 5;

	/**
	 * The '<em><b>WINTER CLOSURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WINTER CLOSURE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #WINTER_CLOSURE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int WINTER_CLOSURE_VALUE = 6;

  /**
	 * An array of all the '<em><b>Impassibility</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Impassibility[] VALUES_ARRAY =
		new Impassibility[] {
			FLOODING,
			DANGER_OF_AVALANCHES,
			BLASTING_OF_AVALANCHES,
			LANDSLIPS,
			CHEMICAL_SPILLAGE,
			WINTER_CLOSURE,
		};

	/**
	 * A public read-only list of all the '<em><b>Impassibility</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Impassibility> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Impassibility</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Impassibility get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Impassibility result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Impassibility</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Impassibility getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Impassibility result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Impassibility</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Impassibility get(int value) {
		switch (value) {
			case FLOODING_VALUE: return FLOODING;
			case DANGER_OF_AVALANCHES_VALUE: return DANGER_OF_AVALANCHES;
			case BLASTING_OF_AVALANCHES_VALUE: return BLASTING_OF_AVALANCHES;
			case LANDSLIPS_VALUE: return LANDSLIPS;
			case CHEMICAL_SPILLAGE_VALUE: return CHEMICAL_SPILLAGE;
			case WINTER_CLOSURE_VALUE: return WINTER_CLOSURE;
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
	private Impassibility(int value, String name, String literal) {
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
	
} //Impassibility
