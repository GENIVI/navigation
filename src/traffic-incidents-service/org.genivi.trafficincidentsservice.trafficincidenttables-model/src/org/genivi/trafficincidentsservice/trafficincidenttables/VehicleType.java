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
 * A representation of the literals of the enumeration '<em><b>Vehicle Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage#getVehicleType()
 * @model
 * @generated
 */
public enum VehicleType implements Enumerator {
  /**
	 * The '<em><b>CAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #CAR_VALUE
	 * @generated
	 * @ordered
	 */
  CAR(1, "CAR", "CAR"),

  /**
	 * The '<em><b>LORRY</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #LORRY_VALUE
	 * @generated
	 * @ordered
	 */
  LORRY(2, "LORRY", "LORRY"),

  /**
	 * The '<em><b>BUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #BUS_VALUE
	 * @generated
	 * @ordered
	 */
  BUS(3, "BUS", "BUS"),

  /**
	 * The '<em><b>TAXI</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TAXI_VALUE
	 * @generated
	 * @ordered
	 */
  TAXI(4, "TAXI", "TAXI"),

  /**
	 * The '<em><b>TRAIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TRAIN_VALUE
	 * @generated
	 * @ordered
	 */
  TRAIN(5, "TRAIN", "TRAIN"),

  /**
	 * The '<em><b>MOTOR CYCLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MOTOR_CYCLE_VALUE
	 * @generated
	 * @ordered
	 */
  MOTOR_CYCLE(6, "MOTOR_CYCLE", "MOTOR_CYCLE"),

  /**
	 * The '<em><b>VEHICLE WITH TRAILER</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #VEHICLE_WITH_TRAILER_VALUE
	 * @generated
	 * @ordered
	 */
  VEHICLE_WITH_TRAILER(7, "VEHICLE_WITH_TRAILER", "VEHICLE_WITH_TRAILER"),

  /**
	 * The '<em><b>MOTOR VEHICLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MOTOR_VEHICLES_VALUE
	 * @generated
	 * @ordered
	 */
  MOTOR_VEHICLES(8, "MOTOR_VEHICLES", "MOTOR_VEHICLES"),

  /**
	 * The '<em><b>TRANSPORT OF DANGEROUS GOODS</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TRANSPORT_OF_DANGEROUS_GOODS_VALUE
	 * @generated
	 * @ordered
	 */
  TRANSPORT_OF_DANGEROUS_GOODS(9, "TRANSPORT_OF_DANGEROUS_GOODS", "TRANSPORT_OF_DANGEROUS_GOODS"),

  /**
	 * The '<em><b>TRANSPORT OF ABNORMAL LOAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #TRANSPORT_OF_ABNORMAL_LOAD_VALUE
	 * @generated
	 * @ordered
	 */
  TRANSPORT_OF_ABNORMAL_LOAD(10, "TRANSPORT_OF_ABNORMAL_LOAD", "TRANSPORT_OF_ABNORMAL_LOAD"),

  /**
	 * The '<em><b>HEAVY VEHICLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #HEAVY_VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
  HEAVY_VEHICLE(11, "HEAVY_VEHICLE", "HEAVY_VEHICLE");

  /**
	 * The '<em><b>CAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CAR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #CAR
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int CAR_VALUE = 1;

  /**
	 * The '<em><b>LORRY</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LORRY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #LORRY
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int LORRY_VALUE = 2;

  /**
	 * The '<em><b>BUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BUS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #BUS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int BUS_VALUE = 3;

  /**
	 * The '<em><b>TAXI</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TAXI</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TAXI
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TAXI_VALUE = 4;

  /**
	 * The '<em><b>TRAIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TRAIN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TRAIN
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TRAIN_VALUE = 5;

  /**
	 * The '<em><b>MOTOR CYCLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MOTOR CYCLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MOTOR_CYCLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MOTOR_CYCLE_VALUE = 6;

  /**
	 * The '<em><b>VEHICLE WITH TRAILER</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VEHICLE WITH TRAILER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #VEHICLE_WITH_TRAILER
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int VEHICLE_WITH_TRAILER_VALUE = 7;

  /**
	 * The '<em><b>MOTOR VEHICLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MOTOR VEHICLES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MOTOR_VEHICLES
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MOTOR_VEHICLES_VALUE = 8;

  /**
	 * The '<em><b>TRANSPORT OF DANGEROUS GOODS</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TRANSPORT OF DANGEROUS GOODS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TRANSPORT_OF_DANGEROUS_GOODS
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TRANSPORT_OF_DANGEROUS_GOODS_VALUE = 9;

  /**
	 * The '<em><b>TRANSPORT OF ABNORMAL LOAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TRANSPORT OF ABNORMAL LOAD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #TRANSPORT_OF_ABNORMAL_LOAD
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int TRANSPORT_OF_ABNORMAL_LOAD_VALUE = 10;

  /**
	 * The '<em><b>HEAVY VEHICLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HEAVY VEHICLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #HEAVY_VEHICLE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int HEAVY_VEHICLE_VALUE = 11;

  /**
	 * An array of all the '<em><b>Vehicle Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final VehicleType[] VALUES_ARRAY =
    new VehicleType[] {
			CAR,
			LORRY,
			BUS,
			TAXI,
			TRAIN,
			MOTOR_CYCLE,
			VEHICLE_WITH_TRAILER,
			MOTOR_VEHICLES,
			TRANSPORT_OF_DANGEROUS_GOODS,
			TRANSPORT_OF_ABNORMAL_LOAD,
			HEAVY_VEHICLE,
		};

  /**
	 * A public read-only list of all the '<em><b>Vehicle Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<VehicleType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Vehicle Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static VehicleType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VehicleType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Vehicle Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static VehicleType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VehicleType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Vehicle Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static VehicleType get(int value) {
		switch (value) {
			case CAR_VALUE: return CAR;
			case LORRY_VALUE: return LORRY;
			case BUS_VALUE: return BUS;
			case TAXI_VALUE: return TAXI;
			case TRAIN_VALUE: return TRAIN;
			case MOTOR_CYCLE_VALUE: return MOTOR_CYCLE;
			case VEHICLE_WITH_TRAILER_VALUE: return VEHICLE_WITH_TRAILER;
			case MOTOR_VEHICLES_VALUE: return MOTOR_VEHICLES;
			case TRANSPORT_OF_DANGEROUS_GOODS_VALUE: return TRANSPORT_OF_DANGEROUS_GOODS;
			case TRANSPORT_OF_ABNORMAL_LOAD_VALUE: return TRANSPORT_OF_ABNORMAL_LOAD;
			case HEAVY_VEHICLE_VALUE: return HEAVY_VEHICLE;
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
  private VehicleType(int value, String name, String literal) {
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
  
} //VehicleType
