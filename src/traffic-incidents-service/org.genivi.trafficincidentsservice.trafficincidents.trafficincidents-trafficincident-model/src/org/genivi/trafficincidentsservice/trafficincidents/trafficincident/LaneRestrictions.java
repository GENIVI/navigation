/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident;

import org.eclipse.emf.ecore.EObject;

import org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lane Restrictions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getLaneRestrictionType <em>Lane Restriction Type</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getNumberOfLanes <em>Number Of Lanes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getLaneRestrictions()
 * @model
 * @generated
 */
public interface LaneRestrictions extends EObject {
  /**
	 * Returns the value of the '<em><b>Lane Restriction Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lane Restriction Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Restriction Type</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType
	 * @see #isSetLaneRestrictionType()
	 * @see #unsetLaneRestrictionType()
	 * @see #setLaneRestrictionType(LaneRestrictionType)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getLaneRestrictions_LaneRestrictionType()
	 * @model unsettable="true"
	 * @generated
	 */
  LaneRestrictionType getLaneRestrictionType();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getLaneRestrictionType <em>Lane Restriction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane Restriction Type</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType
	 * @see #isSetLaneRestrictionType()
	 * @see #unsetLaneRestrictionType()
	 * @see #getLaneRestrictionType()
	 * @generated
	 */
  void setLaneRestrictionType(LaneRestrictionType value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getLaneRestrictionType <em>Lane Restriction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLaneRestrictionType()
	 * @see #getLaneRestrictionType()
	 * @see #setLaneRestrictionType(LaneRestrictionType)
	 * @generated
	 */
  void unsetLaneRestrictionType();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getLaneRestrictionType <em>Lane Restriction Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lane Restriction Type</em>' attribute is set.
	 * @see #unsetLaneRestrictionType()
	 * @see #getLaneRestrictionType()
	 * @see #setLaneRestrictionType(LaneRestrictionType)
	 * @generated
	 */
  boolean isSetLaneRestrictionType();

  /**
	 * Returns the value of the '<em><b>Number Of Lanes</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number Of Lanes</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Lanes</em>' attribute.
	 * @see #isSetNumberOfLanes()
	 * @see #unsetNumberOfLanes()
	 * @see #setNumberOfLanes(Integer)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getLaneRestrictions_NumberOfLanes()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getNumberOfLanes();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getNumberOfLanes <em>Number Of Lanes</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Lanes</em>' attribute.
	 * @see #isSetNumberOfLanes()
	 * @see #unsetNumberOfLanes()
	 * @see #getNumberOfLanes()
	 * @generated
	 */
  void setNumberOfLanes(Integer value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getNumberOfLanes <em>Number Of Lanes</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetNumberOfLanes()
	 * @see #getNumberOfLanes()
	 * @see #setNumberOfLanes(Integer)
	 * @generated
	 */
  void unsetNumberOfLanes();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getNumberOfLanes <em>Number Of Lanes</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Of Lanes</em>' attribute is set.
	 * @see #unsetNumberOfLanes()
	 * @see #getNumberOfLanes()
	 * @see #setNumberOfLanes(Integer)
	 * @generated
	 */
  boolean isSetNumberOfLanes();

} // LaneRestrictions
