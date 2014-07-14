/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Traffic Incident Field</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getTrafficIncidentField()
 * @model
 * @generated
 */
public enum TrafficIncidentField implements Enumerator {
  /**
	 * The '<em><b>TRAFFIC INCIDENT ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TRAFFIC_INCIDENT_ID_VALUE
	 * @generated
	 * @ordered
	 */
  TRAFFIC_INCIDENT_ID(1, "TRAFFIC_INCIDENT_ID", "TRAFFIC_INCIDENT_ID"),

  /**
	 * The '<em><b>EFFECT CODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #EFFECT_CODE_VALUE
	 * @generated
	 * @ordered
	 */
  EFFECT_CODE(2, "EFFECT_CODE", "EFFECT_CODE"),

  /**
	 * The '<em><b>EFFECT TEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #EFFECT_TEXT_VALUE
	 * @generated
	 * @ordered
	 */
  EFFECT_TEXT(3, "EFFECT_TEXT", "EFFECT_TEXT"),

  /**
	 * The '<em><b>START TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #START_TIME_VALUE
	 * @generated
	 * @ordered
	 */
  START_TIME(4, "START_TIME", "START_TIME"),

  /**
	 * The '<em><b>STOP TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #STOP_TIME_VALUE
	 * @generated
	 * @ordered
	 */
  STOP_TIME(5, "STOP_TIME", "STOP_TIME"),

  /**
	 * The '<em><b>TENDENCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TENDENCY_VALUE
	 * @generated
	 * @ordered
	 */
  TENDENCY(6, "TENDENCY", "TENDENCY"),

  /**
	 * The '<em><b>TENDENCY TEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TENDENCY_TEXT_VALUE
	 * @generated
	 * @ordered
	 */
  TENDENCY_TEXT(7, "TENDENCY_TEXT", "TENDENCY_TEXT"),

  /**
	 * The '<em><b>LENGTH AFFECTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LENGTH_AFFECTED_VALUE
	 * @generated
	 * @ordered
	 */
  LENGTH_AFFECTED(8, "LENGTH_AFFECTED", "LENGTH_AFFECTED"),

  /**
	 * The '<em><b>AVERAGE SPEED ABSOLUTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #AVERAGE_SPEED_ABSOLUTE_VALUE
	 * @generated
	 * @ordered
	 */
  AVERAGE_SPEED_ABSOLUTE(9, "AVERAGE_SPEED_ABSOLUTE", "AVERAGE_SPEED_ABSOLUTE"),

  /**
	 * The '<em><b>DELAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #DELAY_VALUE
	 * @generated
	 * @ordered
	 */
  DELAY(10, "DELAY", "DELAY"),

  /**
	 * The '<em><b>SEGMENT SPEED LIMIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #SEGMENT_SPEED_LIMIT_VALUE
	 * @generated
	 * @ordered
	 */
  SEGMENT_SPEED_LIMIT(11, "SEGMENT_SPEED_LIMIT", "SEGMENT_SPEED_LIMIT"),

  /**
	 * The '<em><b>CAUSES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #CAUSES_VALUE
	 * @generated
	 * @ordered
	 */
  CAUSES(13, "CAUSES", "CAUSES"),

  /**
	 * The '<em><b>CAUSE TEXTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #CAUSE_TEXTS_VALUE
	 * @generated
	 * @ordered
	 */
  CAUSE_TEXTS(14, "CAUSE_TEXTS", "CAUSE_TEXTS"),

  /**
	 * The '<em><b>APPLICABILITY TEXTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #APPLICABILITY_TEXTS_VALUE
	 * @generated
	 * @ordered
	 */
  APPLICABILITY_TEXTS(16, "APPLICABILITY_TEXTS", "APPLICABILITY_TEXTS"),

  /**
	 * The '<em><b>LOCATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LOCATION_VALUE
	 * @generated
	 * @ordered
	 */
  LOCATION(17, "LOCATION", "LOCATION"),

  /**
	 * The '<em><b>LOCATION INFO</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LOCATION_INFO_VALUE
	 * @generated
	 * @ordered
	 */
  LOCATION_INFO(18, "LOCATION_INFO", "LOCATION_INFO"),

  /**
	 * The '<em><b>LOCATION BOUNDING BOX</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LOCATION_BOUNDING_BOX_VALUE
	 * @generated
	 * @ordered
	 */
  LOCATION_BOUNDING_BOX(19, "LOCATION_BOUNDING_BOX", "LOCATION_BOUNDING_BOX"), /**
	 * The '<em><b>APPLICABILITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #APPLICABILITY_VALUE
	 * @generated
	 * @ordered
	 */
  APPLICABILITY(15, "APPLICABILITY", "APPLICABILITY"), /**
	 * The '<em><b>ADVICES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ADVICES_VALUE
	 * @generated
	 * @ordered
	 */
  ADVICES(20, "ADVICES", "ADVICES"), /**
	 * The '<em><b>ADVICE TEXTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ADVICE_TEXTS_VALUE
	 * @generated
	 * @ordered
	 */
  ADVICE_TEXTS(21, "ADVICE_TEXTS", "ADVICE_TEXTS"), /**
	 * The '<em><b>EXPECTED SPEED ABSOLUTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXPECTED_SPEED_ABSOLUTE_VALUE
	 * @generated
	 * @ordered
	 */
	EXPECTED_SPEED_ABSOLUTE(12, "EXPECTED_SPEED_ABSOLUTE", "EXPECTED_SPEED_ABSOLUTE");

  /**
	 * The '<em><b>TRAFFIC INCIDENT ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TRAFFIC INCIDENT ID</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TRAFFIC_INCIDENT_ID
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TRAFFIC_INCIDENT_ID_VALUE = 1;

  /**
	 * The '<em><b>EFFECT CODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EFFECT CODE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #EFFECT_CODE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int EFFECT_CODE_VALUE = 2;

  /**
	 * The '<em><b>EFFECT TEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EFFECT TEXT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #EFFECT_TEXT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int EFFECT_TEXT_VALUE = 3;

  /**
	 * The '<em><b>START TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>START TIME</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #START_TIME
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int START_TIME_VALUE = 4;

  /**
	 * The '<em><b>STOP TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STOP TIME</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #STOP_TIME
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int STOP_TIME_VALUE = 5;

  /**
	 * The '<em><b>TENDENCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TENDENCY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TENDENCY
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TENDENCY_VALUE = 6;

  /**
	 * The '<em><b>TENDENCY TEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TENDENCY TEXT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TENDENCY_TEXT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TENDENCY_TEXT_VALUE = 7;

  /**
	 * The '<em><b>LENGTH AFFECTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LENGTH AFFECTED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LENGTH_AFFECTED
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LENGTH_AFFECTED_VALUE = 8;

  /**
	 * The '<em><b>AVERAGE SPEED ABSOLUTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AVERAGE SPEED ABSOLUTE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #AVERAGE_SPEED_ABSOLUTE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int AVERAGE_SPEED_ABSOLUTE_VALUE = 9;

  /**
	 * The '<em><b>DELAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DELAY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #DELAY
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int DELAY_VALUE = 10;

  /**
	 * The '<em><b>SEGMENT SPEED LIMIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SEGMENT SPEED LIMIT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #SEGMENT_SPEED_LIMIT
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int SEGMENT_SPEED_LIMIT_VALUE = 11;

  /**
	 * The '<em><b>CAUSES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CAUSES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #CAUSES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int CAUSES_VALUE = 13;

  /**
	 * The '<em><b>CAUSE TEXTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CAUSE TEXTS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #CAUSE_TEXTS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int CAUSE_TEXTS_VALUE = 14;

  /**
	 * The '<em><b>APPLICABILITY TEXTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>APPLICABILITY TEXTS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #APPLICABILITY_TEXTS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int APPLICABILITY_TEXTS_VALUE = 16;

  /**
	 * The '<em><b>LOCATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LOCATION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LOCATION
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LOCATION_VALUE = 17;

  /**
	 * The '<em><b>LOCATION INFO</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LOCATION INFO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LOCATION_INFO
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LOCATION_INFO_VALUE = 18;

  /**
	 * The '<em><b>LOCATION BOUNDING BOX</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LOCATION BOUNDING BOX</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LOCATION_BOUNDING_BOX
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LOCATION_BOUNDING_BOX_VALUE = 19;

		/**
	 * The '<em><b>APPLICABILITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>APPLICABILITY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #APPLICABILITY
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int APPLICABILITY_VALUE = 15;

  /**
	 * The '<em><b>ADVICES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ADVICES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ADVICES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int ADVICES_VALUE = 20;

  /**
	 * The '<em><b>ADVICE TEXTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ADVICE TEXTS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ADVICE_TEXTS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int ADVICE_TEXTS_VALUE = 21;

  /**
	 * The '<em><b>EXPECTED SPEED ABSOLUTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXPECTED SPEED ABSOLUTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPECTED_SPEED_ABSOLUTE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXPECTED_SPEED_ABSOLUTE_VALUE = 12;

		/**
	 * An array of all the '<em><b>Traffic Incident Field</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final TrafficIncidentField[] VALUES_ARRAY =
    new TrafficIncidentField[] {
			TRAFFIC_INCIDENT_ID,
			EFFECT_CODE,
			EFFECT_TEXT,
			START_TIME,
			STOP_TIME,
			TENDENCY,
			TENDENCY_TEXT,
			LENGTH_AFFECTED,
			AVERAGE_SPEED_ABSOLUTE,
			DELAY,
			SEGMENT_SPEED_LIMIT,
			CAUSES,
			CAUSE_TEXTS,
			APPLICABILITY_TEXTS,
			LOCATION,
			LOCATION_INFO,
			LOCATION_BOUNDING_BOX,
			APPLICABILITY,
			ADVICES,
			ADVICE_TEXTS,
			EXPECTED_SPEED_ABSOLUTE,
		};

  /**
	 * A public read-only list of all the '<em><b>Traffic Incident Field</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<TrafficIncidentField> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Traffic Incident Field</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficIncidentField get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TrafficIncidentField result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Traffic Incident Field</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficIncidentField getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TrafficIncidentField result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Traffic Incident Field</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static TrafficIncidentField get(int value) {
		switch (value) {
			case TRAFFIC_INCIDENT_ID_VALUE: return TRAFFIC_INCIDENT_ID;
			case EFFECT_CODE_VALUE: return EFFECT_CODE;
			case EFFECT_TEXT_VALUE: return EFFECT_TEXT;
			case START_TIME_VALUE: return START_TIME;
			case STOP_TIME_VALUE: return STOP_TIME;
			case TENDENCY_VALUE: return TENDENCY;
			case TENDENCY_TEXT_VALUE: return TENDENCY_TEXT;
			case LENGTH_AFFECTED_VALUE: return LENGTH_AFFECTED;
			case AVERAGE_SPEED_ABSOLUTE_VALUE: return AVERAGE_SPEED_ABSOLUTE;
			case DELAY_VALUE: return DELAY;
			case SEGMENT_SPEED_LIMIT_VALUE: return SEGMENT_SPEED_LIMIT;
			case CAUSES_VALUE: return CAUSES;
			case CAUSE_TEXTS_VALUE: return CAUSE_TEXTS;
			case APPLICABILITY_TEXTS_VALUE: return APPLICABILITY_TEXTS;
			case LOCATION_VALUE: return LOCATION;
			case LOCATION_INFO_VALUE: return LOCATION_INFO;
			case LOCATION_BOUNDING_BOX_VALUE: return LOCATION_BOUNDING_BOX;
			case APPLICABILITY_VALUE: return APPLICABILITY;
			case ADVICES_VALUE: return ADVICES;
			case ADVICE_TEXTS_VALUE: return ADVICE_TEXTS;
			case EXPECTED_SPEED_ABSOLUTE_VALUE: return EXPECTED_SPEED_ABSOLUTE;
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
  private TrafficIncidentField(int value, String name, String literal) {
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
  
} //TrafficIncidentField
