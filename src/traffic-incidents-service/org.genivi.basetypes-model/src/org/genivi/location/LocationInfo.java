/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.location;

import org.eclipse.emf.ecore.EObject;

import org.genivi.common.Coordinate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.location.LocationInfo#getName <em>Name</em>}</li>
 *   <li>{@link org.genivi.location.LocationInfo#getMainLocation <em>Main Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.location.LocationPackage#getLocationInfo()
 * @model
 * @generated
 */
public interface LocationInfo extends EObject {
  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.genivi.location.LocationPackage#getLocationInfo_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link org.genivi.location.LocationInfo#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Main Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Main Location</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Location</em>' containment reference.
	 * @see #setMainLocation(Coordinate)
	 * @see org.genivi.location.LocationPackage#getLocationInfo_MainLocation()
	 * @model containment="true"
	 * @generated
	 */
  Coordinate getMainLocation();

  /**
	 * Sets the value of the '{@link org.genivi.location.LocationInfo#getMainLocation <em>Main Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Location</em>' containment reference.
	 * @see #getMainLocation()
	 * @generated
	 */
  void setMainLocation(Coordinate value);

} // LocationInfo
