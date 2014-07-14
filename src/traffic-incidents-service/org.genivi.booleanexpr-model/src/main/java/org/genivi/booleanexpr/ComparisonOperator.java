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
 * A representation of the literals of the enumeration '<em><b>Comparison Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This enumeration defines the operators for comparison.
 * <!-- end-model-doc -->
 * @see org.genivi.booleanexpr.FilterexprPackage#getComparisonOperator()
 * @model
 * @generated
 */
public enum ComparisonOperator implements Enumerator {
  /**
	 * The '<em><b>EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
  EQUAL(0, "EQUAL", "EQUAL"),

  /**
	 * The '<em><b>NOT EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #NOT_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
  NOT_EQUAL(1, "NOT_EQUAL", "NOT_EQUAL"),

  /**
	 * The '<em><b>GREATER THEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #GREATER_THEN_VALUE
	 * @generated
	 * @ordered
	 */
  GREATER_THEN(2, "GREATER_THEN", "GREATER_THEN"),

  /**
	 * The '<em><b>GREATER OR EQUAL THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #GREATER_OR_EQUAL_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  GREATER_OR_EQUAL_THAN(3, "GREATER_OR_EQUAL_THAN", "GREATER_OR_EQUAL_THAN"),

  /**
	 * The '<em><b>LESS THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LESS_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  LESS_THAN(4, "LESS_THAN", "LESS_THAN"),

  /**
	 * The '<em><b>LESS OR EQUAL THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LESS_OR_EQUAL_THAN_VALUE
	 * @generated
	 * @ordered
	 */
  LESS_OR_EQUAL_THAN(5, "LESS_OR_EQUAL_THAN", "LESS_OR_EQUAL_THAN");

  /**
	 * The '<em><b>EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EQUAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #EQUAL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int EQUAL_VALUE = 0;

  /**
	 * The '<em><b>NOT EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NOT EQUAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #NOT_EQUAL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int NOT_EQUAL_VALUE = 1;

  /**
	 * The '<em><b>GREATER THEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GREATER THEN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #GREATER_THEN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int GREATER_THEN_VALUE = 2;

  /**
	 * The '<em><b>GREATER OR EQUAL THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GREATER OR EQUAL THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #GREATER_OR_EQUAL_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int GREATER_OR_EQUAL_THAN_VALUE = 3;

  /**
	 * The '<em><b>LESS THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LESS THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LESS_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LESS_THAN_VALUE = 4;

  /**
	 * The '<em><b>LESS OR EQUAL THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LESS OR EQUAL THAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LESS_OR_EQUAL_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LESS_OR_EQUAL_THAN_VALUE = 5;

  /**
	 * An array of all the '<em><b>Comparison Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final ComparisonOperator[] VALUES_ARRAY =
    new ComparisonOperator[] {
			EQUAL,
			NOT_EQUAL,
			GREATER_THEN,
			GREATER_OR_EQUAL_THAN,
			LESS_THAN,
			LESS_OR_EQUAL_THAN,
		};

  /**
	 * A public read-only list of all the '<em><b>Comparison Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<ComparisonOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Comparison Operator</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ComparisonOperator get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComparisonOperator result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Comparison Operator</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ComparisonOperator getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComparisonOperator result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Comparison Operator</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ComparisonOperator get(int value) {
		switch (value) {
			case EQUAL_VALUE: return EQUAL;
			case NOT_EQUAL_VALUE: return NOT_EQUAL;
			case GREATER_THEN_VALUE: return GREATER_THEN;
			case GREATER_OR_EQUAL_THAN_VALUE: return GREATER_OR_EQUAL_THAN;
			case LESS_THAN_VALUE: return LESS_THAN;
			case LESS_OR_EQUAL_THAN_VALUE: return LESS_OR_EQUAL_THAN;
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
  private ComparisonOperator(int value, String name, String literal) {
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
  
} //ComparisonOperator
