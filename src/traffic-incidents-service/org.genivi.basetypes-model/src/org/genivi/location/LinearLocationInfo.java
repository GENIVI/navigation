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

import org.eclipse.emf.common.util.EList;

import org.genivi.common.Coordinate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linear Location Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.location.LinearLocationInfo#getFromLocationName <em>From Location Name</em>}</li>
 *   <li>{@link org.genivi.location.LinearLocationInfo#getFromLocationParentName <em>From Location Parent Name</em>}</li>
 *   <li>{@link org.genivi.location.LinearLocationInfo#getToLocationName <em>To Location Name</em>}</li>
 *   <li>{@link org.genivi.location.LinearLocationInfo#getToLocationParentName <em>To Location Parent Name</em>}</li>
 *   <li>{@link org.genivi.location.LinearLocationInfo#getCoordinates <em>Coordinates</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.location.LocationPackage#getLinearLocationInfo()
 * @model
 * @generated
 */
public interface LinearLocationInfo extends LocationInfo {
  /**
	 * Returns the value of the '<em><b>From Location Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From Location Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>From Location Name</em>' attribute.
	 * @see #setFromLocationName(String)
	 * @see org.genivi.location.LocationPackage#getLinearLocationInfo_FromLocationName()
	 * @model
	 * @generated
	 */
  String getFromLocationName();

  /**
	 * Sets the value of the '{@link org.genivi.location.LinearLocationInfo#getFromLocationName <em>From Location Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Location Name</em>' attribute.
	 * @see #getFromLocationName()
	 * @generated
	 */
  void setFromLocationName(String value);

  /**
	 * Returns the value of the '<em><b>From Location Parent Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From Location Parent Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>From Location Parent Name</em>' attribute.
	 * @see #setFromLocationParentName(String)
	 * @see org.genivi.location.LocationPackage#getLinearLocationInfo_FromLocationParentName()
	 * @model
	 * @generated
	 */
  String getFromLocationParentName();

  /**
	 * Sets the value of the '{@link org.genivi.location.LinearLocationInfo#getFromLocationParentName <em>From Location Parent Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Location Parent Name</em>' attribute.
	 * @see #getFromLocationParentName()
	 * @generated
	 */
  void setFromLocationParentName(String value);

  /**
	 * Returns the value of the '<em><b>To Location Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Location Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>To Location Name</em>' attribute.
	 * @see #setToLocationName(String)
	 * @see org.genivi.location.LocationPackage#getLinearLocationInfo_ToLocationName()
	 * @model
	 * @generated
	 */
  String getToLocationName();

  /**
	 * Sets the value of the '{@link org.genivi.location.LinearLocationInfo#getToLocationName <em>To Location Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Location Name</em>' attribute.
	 * @see #getToLocationName()
	 * @generated
	 */
  void setToLocationName(String value);

  /**
	 * Returns the value of the '<em><b>To Location Parent Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Location Parent Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>To Location Parent Name</em>' attribute.
	 * @see #setToLocationParentName(String)
	 * @see org.genivi.location.LocationPackage#getLinearLocationInfo_ToLocationParentName()
	 * @model
	 * @generated
	 */
  String getToLocationParentName();

  /**
	 * Sets the value of the '{@link org.genivi.location.LinearLocationInfo#getToLocationParentName <em>To Location Parent Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Location Parent Name</em>' attribute.
	 * @see #getToLocationParentName()
	 * @generated
	 */
  void setToLocationParentName(String value);

  /**
	 * Returns the value of the '<em><b>Coordinates</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.common.Coordinate}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Coordinates</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinates</em>' containment reference list.
	 * @see org.genivi.location.LocationPackage#getLinearLocationInfo_Coordinates()
	 * @model containment="true"
	 * @generated
	 */
  EList<Coordinate> getCoordinates();

} // LinearLocationInfo
