/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.booleanexpr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Dyadic Logical Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This enumeration defines the operators for DyadicExpressions.
 * AND has a higher precedence than OR.
 * <!-- end-model-doc -->
 * @see org.genivi.booleanexpr.FilterexprPackage#getDyadicLogicalOperator()
 * @model
 * @generated
 */
public enum DyadicLogicalOperator implements Enumerator {
  /**
	 * The '<em><b>AND</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #AND_VALUE
	 * @generated
	 * @ordered
	 */
  AND(0, "AND", "AND"),

  /**
	 * The '<em><b>OR</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #OR_VALUE
	 * @generated
	 * @ordered
	 */
  OR(1, "OR", "OR");

  /**
	 * The '<em><b>AND</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #AND
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int AND_VALUE = 0;

  /**
	 * The '<em><b>OR</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #OR
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int OR_VALUE = 1;

  /**
	 * An array of all the '<em><b>Dyadic Logical Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final DyadicLogicalOperator[] VALUES_ARRAY =
    new DyadicLogicalOperator[] {
			AND,
			OR,
		};

  /**
	 * A public read-only list of all the '<em><b>Dyadic Logical Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<DyadicLogicalOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Dyadic Logical Operator</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DyadicLogicalOperator get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DyadicLogicalOperator result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Dyadic Logical Operator</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DyadicLogicalOperator getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DyadicLogicalOperator result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Dyadic Logical Operator</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static DyadicLogicalOperator get(int value) {
		switch (value) {
			case AND_VALUE: return AND;
			case OR_VALUE: return OR;
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
  private DyadicLogicalOperator(int value, String name, String literal) {
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
  
} //DyadicLogicalOperator
