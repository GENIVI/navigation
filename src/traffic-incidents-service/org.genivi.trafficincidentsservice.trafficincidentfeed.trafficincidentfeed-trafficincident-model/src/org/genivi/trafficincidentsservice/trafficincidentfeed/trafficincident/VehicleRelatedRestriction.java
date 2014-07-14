/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident;

import org.eclipse.emf.ecore.EObject;

import org.genivi.locref.LocationReference;

import org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle Related Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionType <em>Restriction Type</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionValue <em>Restriction Value</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionLocationReference <em>Restriction Location Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getVehicleRelatedRestriction()
 * @model
 * @generated
 */
public interface VehicleRelatedRestriction extends EObject {
  /**
	 * Returns the value of the '<em><b>Restriction Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Restriction Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Restriction Type</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType
	 * @see #isSetRestrictionType()
	 * @see #unsetRestrictionType()
	 * @see #setRestrictionType(RestrictionType)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getVehicleRelatedRestriction_RestrictionType()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  RestrictionType getRestrictionType();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionType <em>Restriction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restriction Type</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType
	 * @see #isSetRestrictionType()
	 * @see #unsetRestrictionType()
	 * @see #getRestrictionType()
	 * @generated
	 */
  void setRestrictionType(RestrictionType value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionType <em>Restriction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetRestrictionType()
	 * @see #getRestrictionType()
	 * @see #setRestrictionType(RestrictionType)
	 * @generated
	 */
  void unsetRestrictionType();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionType <em>Restriction Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Restriction Type</em>' attribute is set.
	 * @see #unsetRestrictionType()
	 * @see #getRestrictionType()
	 * @see #setRestrictionType(RestrictionType)
	 * @generated
	 */
  boolean isSetRestrictionType();

  /**
	 * Returns the value of the '<em><b>Restriction Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Restriction Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Restriction Value</em>' attribute.
	 * @see #isSetRestrictionValue()
	 * @see #unsetRestrictionValue()
	 * @see #setRestrictionValue(Integer)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getVehicleRelatedRestriction_RestrictionValue()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getRestrictionValue();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionValue <em>Restriction Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restriction Value</em>' attribute.
	 * @see #isSetRestrictionValue()
	 * @see #unsetRestrictionValue()
	 * @see #getRestrictionValue()
	 * @generated
	 */
  void setRestrictionValue(Integer value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionValue <em>Restriction Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetRestrictionValue()
	 * @see #getRestrictionValue()
	 * @see #setRestrictionValue(Integer)
	 * @generated
	 */
  void unsetRestrictionValue();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionValue <em>Restriction Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Restriction Value</em>' attribute is set.
	 * @see #unsetRestrictionValue()
	 * @see #getRestrictionValue()
	 * @see #setRestrictionValue(Integer)
	 * @generated
	 */
  boolean isSetRestrictionValue();

  /**
	 * Returns the value of the '<em><b>Restriction Location Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Restriction Location Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Restriction Location Reference</em>' containment reference.
	 * @see #isSetRestrictionLocationReference()
	 * @see #unsetRestrictionLocationReference()
	 * @see #setRestrictionLocationReference(LocationReference)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getVehicleRelatedRestriction_RestrictionLocationReference()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  LocationReference getRestrictionLocationReference();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionLocationReference <em>Restriction Location Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restriction Location Reference</em>' containment reference.
	 * @see #isSetRestrictionLocationReference()
	 * @see #unsetRestrictionLocationReference()
	 * @see #getRestrictionLocationReference()
	 * @generated
	 */
  void setRestrictionLocationReference(LocationReference value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionLocationReference <em>Restriction Location Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetRestrictionLocationReference()
	 * @see #getRestrictionLocationReference()
	 * @see #setRestrictionLocationReference(LocationReference)
	 * @generated
	 */
  void unsetRestrictionLocationReference();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionLocationReference <em>Restriction Location Reference</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Restriction Location Reference</em>' containment reference is set.
	 * @see #unsetRestrictionLocationReference()
	 * @see #getRestrictionLocationReference()
	 * @see #setRestrictionLocationReference(LocationReference)
	 * @generated
	 */
  boolean isSetRestrictionLocationReference();

} // VehicleRelatedRestriction
