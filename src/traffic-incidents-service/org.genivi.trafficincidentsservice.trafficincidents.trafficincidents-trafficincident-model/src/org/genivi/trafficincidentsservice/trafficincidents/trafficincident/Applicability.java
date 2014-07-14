/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Applicability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleType <em>Vehicle Type</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleRelatedRestrictions <em>Vehicle Related Restrictions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getApplicability()
 * @model
 * @generated
 */
public interface Applicability extends EObject {
  /**
	 * Returns the value of the '<em><b>Vehicle Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vehicle Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Type</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType
	 * @see #isSetVehicleType()
	 * @see #unsetVehicleType()
	 * @see #setVehicleType(VehicleType)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getApplicability_VehicleType()
	 * @model unsettable="true"
	 * @generated
	 */
  VehicleType getVehicleType();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleType <em>Vehicle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Type</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType
	 * @see #isSetVehicleType()
	 * @see #unsetVehicleType()
	 * @see #getVehicleType()
	 * @generated
	 */
  void setVehicleType(VehicleType value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleType <em>Vehicle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetVehicleType()
	 * @see #getVehicleType()
	 * @see #setVehicleType(VehicleType)
	 * @generated
	 */
  void unsetVehicleType();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleType <em>Vehicle Type</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Vehicle Related Restrictions</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vehicle Related Restrictions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Related Restrictions</em>' containment reference list.
	 * @see #isSetVehicleRelatedRestrictions()
	 * @see #unsetVehicleRelatedRestrictions()
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getApplicability_VehicleRelatedRestrictions()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<VehicleRelatedRestriction> getVehicleRelatedRestrictions();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleRelatedRestrictions <em>Vehicle Related Restrictions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetVehicleRelatedRestrictions()
	 * @see #getVehicleRelatedRestrictions()
	 * @generated
	 */
  void unsetVehicleRelatedRestrictions();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleRelatedRestrictions <em>Vehicle Related Restrictions</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Vehicle Related Restrictions</em>' containment reference list is set.
	 * @see #unsetVehicleRelatedRestrictions()
	 * @see #getVehicleRelatedRestrictions()
	 * @generated
	 */
  boolean isSetVehicleRelatedRestrictions();

} // Applicability
