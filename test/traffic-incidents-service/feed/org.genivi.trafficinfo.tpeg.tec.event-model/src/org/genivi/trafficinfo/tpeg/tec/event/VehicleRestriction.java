/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction#getVehicleType <em>Vehicle Type</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction#getRestriction <em>Restriction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getVehicleRestriction()
 * @model
 * @generated
 */
public interface VehicleRestriction extends EObject {
  /**
	 * Returns the value of the '<em><b>Vehicle Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficinfo.tpeg.tec.event.VehicleType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vehicle Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Type</em>' attribute.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleType
	 * @see #isSetVehicleType()
	 * @see #unsetVehicleType()
	 * @see #setVehicleType(VehicleType)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getVehicleRestriction_VehicleType()
	 * @model unsettable="true"
	 * @generated
	 */
  VehicleType getVehicleType();

  /**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction#getVehicleType <em>Vehicle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Type</em>' attribute.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleType
	 * @see #isSetVehicleType()
	 * @see #unsetVehicleType()
	 * @see #getVehicleType()
	 * @generated
	 */
  void setVehicleType(VehicleType value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction#getVehicleType <em>Vehicle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetVehicleType()
	 * @see #getVehicleType()
	 * @see #setVehicleType(VehicleType)
	 * @generated
	 */
  void unsetVehicleType();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction#getVehicleType <em>Vehicle Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Vehicle Type</em>' attribute is set.
	 * @see #unsetVehicleType()
	 * @see #getVehicleType()
	 * @see #setVehicleType(VehicleType)
	 * @generated
	 */
  boolean isSetVehicleType();

  /**
	 * Returns the value of the '<em><b>Restriction</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Restriction</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Restriction</em>' containment reference list.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getVehicleRestriction_Restriction()
	 * @model containment="true"
	 * @generated
	 */
  EList<VehicleRelatedRestriction> getRestriction();

} // VehicleRestriction
