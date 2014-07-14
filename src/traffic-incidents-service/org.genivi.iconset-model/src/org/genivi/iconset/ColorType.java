/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.iconset;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Color Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.iconset.IconsetPackage#getColorType()
 * @model
 * @generated
 */
public enum ColorType implements Enumerator {
  /**
	 * The '<em><b>BLACK AND WHITE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #BLACK_AND_WHITE_VALUE
	 * @generated
	 * @ordered
	 */
  BLACK_AND_WHITE(1, "BLACK_AND_WHITE", "BLACK_AND_WHITE"),

  /**
	 * The '<em><b>GRAY 4</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #GRAY_4_VALUE
	 * @generated
	 * @ordered
	 */
  GRAY_4(2, "GRAY_4", "GRAY_4"),

  /**
	 * The '<em><b>GRAY 8</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #GRAY_8_VALUE
	 * @generated
	 * @ordered
	 */
  GRAY_8(3, "GRAY_8", "GRAY_8"),

  /**
	 * The '<em><b>RGB555</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RGB555_VALUE
	 * @generated
	 * @ordered
	 */
  RGB555(4, "RGB555", "RGB555"),

  /**
	 * The '<em><b>RGB565</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RGB565_VALUE
	 * @generated
	 * @ordered
	 */
  RGB565(5, "RGB565", "RGB565"),

  /**
	 * The '<em><b>RGB888</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #RGB888_VALUE
	 * @generated
	 * @ordered
	 */
  RGB888(6, "RGB888", "RGB888");

  /**
	 * The '<em><b>BLACK AND WHITE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BLACK AND WHITE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #BLACK_AND_WHITE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int BLACK_AND_WHITE_VALUE = 1;

  /**
	 * The '<em><b>GRAY 4</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GRAY 4</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #GRAY_4
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int GRAY_4_VALUE = 2;

  /**
	 * The '<em><b>GRAY 8</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GRAY 8</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #GRAY_8
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int GRAY_8_VALUE = 3;

  /**
	 * The '<em><b>RGB555</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RGB555</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RGB555
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int RGB555_VALUE = 4;

  /**
	 * The '<em><b>RGB565</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RGB565</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RGB565
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int RGB565_VALUE = 5;

  /**
	 * The '<em><b>RGB888</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RGB888</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #RGB888
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int RGB888_VALUE = 6;

  /**
	 * An array of all the '<em><b>Color Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final ColorType[] VALUES_ARRAY =
    new ColorType[] {
			BLACK_AND_WHITE,
			GRAY_4,
			GRAY_8,
			RGB555,
			RGB565,
			RGB888,
		};

  /**
	 * A public read-only list of all the '<em><b>Color Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<ColorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Color Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ColorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ColorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Color Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ColorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ColorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Color Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ColorType get(int value) {
		switch (value) {
			case BLACK_AND_WHITE_VALUE: return BLACK_AND_WHITE;
			case GRAY_4_VALUE: return GRAY_4;
			case GRAY_8_VALUE: return GRAY_8;
			case RGB555_VALUE: return RGB555;
			case RGB565_VALUE: return RGB565;
			case RGB888_VALUE: return RGB888;
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
  private ColorType(int value, String name, String literal) {
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
  
} //ColorType
