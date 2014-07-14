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
 * A representation of the literals of the enumeration '<em><b>Major Event</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getMajorEvent()
 * @model
 * @generated
 */
public enum MajorEvent implements Enumerator {
  /**
	 * The '<em><b>SPORTS EVENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SPORTS_EVENT_VALUE
	 * @generated
	 * @ordered
	 */
  SPORTS_EVENT(1, "SPORTS_EVENT", "SPORTS_EVENT"),

  /**
	 * The '<em><b>DEMONSTRATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DEMONSTRATION_VALUE
	 * @generated
	 * @ordered
	 */
  DEMONSTRATION(2, "DEMONSTRATION", "DEMONSTRATION"),

  /**
	 * The '<em><b>DEMONSTRATION WITH VEHICLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DEMONSTRATION_WITH_VEHICLES_VALUE
	 * @generated
	 * @ordered
	 */
  DEMONSTRATION_WITH_VEHICLES(3, "DEMONSTRATION_WITH_VEHICLES", "DEMONSTRATION_WITH_VEHICLES"),

  /**
	 * The '<em><b>CONCERT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #CONCERT_VALUE
	 * @generated
	 * @ordered
	 */
  CONCERT(4, "CONCERT", "CONCERT"),

  /**
	 * The '<em><b>FAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #FAIR_VALUE
	 * @generated
	 * @ordered
	 */
  FAIR(5, "FAIR", "FAIR"),

  /**
	 * The '<em><b>MILITARY TRAINING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MILITARY_TRAINING_VALUE
	 * @generated
	 * @ordered
	 */
  MILITARY_TRAINING(6, "MILITARY_TRAINING", "MILITARY_TRAINING"),

  /**
	 * The '<em><b>EMERGENCY TRAINING</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #EMERGENCY_TRAINING_VALUE
	 * @generated
	 * @ordered
	 */
  EMERGENCY_TRAINING(7, "EMERGENCY_TRAINING", "EMERGENCY_TRAINING"),

  /**
	 * The '<em><b>FESTIVITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #FESTIVITY_VALUE
	 * @generated
	 * @ordered
	 */
  FESTIVITY(8, "FESTIVITY", "FESTIVITY"),

  /**
	 * The '<em><b>PROCESSION</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #PROCESSION_VALUE
	 * @generated
	 * @ordered
	 */
  PROCESSION(9, "PROCESSION", "PROCESSION");

  /**
	 * The '<em><b>SPORTS EVENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SPORTS EVENT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SPORTS_EVENT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SPORTS_EVENT_VALUE = 1;

  /**
	 * The '<em><b>DEMONSTRATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DEMONSTRATION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DEMONSTRATION
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DEMONSTRATION_VALUE = 2;

  /**
	 * The '<em><b>DEMONSTRATION WITH VEHICLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DEMONSTRATION WITH VEHICLES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DEMONSTRATION_WITH_VEHICLES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DEMONSTRATION_WITH_VEHICLES_VALUE = 3;

  /**
	 * The '<em><b>CONCERT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONCERT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #CONCERT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int CONCERT_VALUE = 4;

  /**
	 * The '<em><b>FAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FAIR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #FAIR
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int FAIR_VALUE = 5;

  /**
	 * The '<em><b>MILITARY TRAINING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MILITARY TRAINING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MILITARY_TRAINING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MILITARY_TRAINING_VALUE = 6;

  /**
	 * The '<em><b>EMERGENCY TRAINING</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EMERGENCY TRAINING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #EMERGENCY_TRAINING
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int EMERGENCY_TRAINING_VALUE = 7;

  /**
	 * The '<em><b>FESTIVITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FESTIVITY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #FESTIVITY
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int FESTIVITY_VALUE = 8;

  /**
	 * The '<em><b>PROCESSION</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROCESSION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #PROCESSION
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int PROCESSION_VALUE = 9;

  /**
	 * An array of all the '<em><b>Major Event</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final MajorEvent[] VALUES_ARRAY =
    new MajorEvent[] {
			SPORTS_EVENT,
			DEMONSTRATION,
			DEMONSTRATION_WITH_VEHICLES,
			CONCERT,
			FAIR,
			MILITARY_TRAINING,
			EMERGENCY_TRAINING,
			FESTIVITY,
			PROCESSION,
		};

  /**
	 * A public read-only list of all the '<em><b>Major Event</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<MajorEvent> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Major Event</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static MajorEvent get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MajorEvent result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Major Event</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static MajorEvent getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MajorEvent result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Major Event</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static MajorEvent get(int value) {
		switch (value) {
			case SPORTS_EVENT_VALUE: return SPORTS_EVENT;
			case DEMONSTRATION_VALUE: return DEMONSTRATION;
			case DEMONSTRATION_WITH_VEHICLES_VALUE: return DEMONSTRATION_WITH_VEHICLES;
			case CONCERT_VALUE: return CONCERT;
			case FAIR_VALUE: return FAIR;
			case MILITARY_TRAINING_VALUE: return MILITARY_TRAINING;
			case EMERGENCY_TRAINING_VALUE: return EMERGENCY_TRAINING;
			case FESTIVITY_VALUE: return FESTIVITY;
			case PROCESSION_VALUE: return PROCESSION;
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
  private MajorEvent(int value, String name, String literal) {
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
  
} //MajorEvent
