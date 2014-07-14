/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Coordinate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This data type represents a 3D WGS84 coordinate.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.common.Coordinate#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link org.genivi.common.Coordinate#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link org.genivi.common.Coordinate#getAltitude <em>Altitude</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.common.CommonPackage#getCoordinate()
 * @model
 * @generated
 */
public interface Coordinate extends EObject {
  /**
	 * Returns the value of the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * latitude >= -90 and <= 90
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Latitude</em>' attribute.
	 * @see #setLatitude(double)
	 * @see org.genivi.common.CommonPackage#getCoordinate_Latitude()
	 * @model required="true"
	 * @generated
	 */
  double getLatitude();

  /**
	 * Sets the value of the '{@link org.genivi.common.Coordinate#getLatitude <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude</em>' attribute.
	 * @see #getLatitude()
	 * @generated
	 */
  void setLatitude(double value);

  /**
	 * Returns the value of the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * longitude >= -180 and <= 180
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Longitude</em>' attribute.
	 * @see #setLongitude(double)
	 * @see org.genivi.common.CommonPackage#getCoordinate_Longitude()
	 * @model required="true"
	 * @generated
	 */
  double getLongitude();

  /**
	 * Sets the value of the '{@link org.genivi.common.Coordinate#getLongitude <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude</em>' attribute.
	 * @see #getLongitude()
	 * @generated
	 */
  void setLongitude(double value);

  /**
	 * Returns the value of the '<em><b>Altitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * altitude values are in meters above sea level
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Altitude</em>' attribute.
	 * @see #setAltitude(int)
	 * @see org.genivi.common.CommonPackage#getCoordinate_Altitude()
	 * @model
	 * @generated
	 */
  int getAltitude();

  /**
	 * Sets the value of the '{@link org.genivi.common.Coordinate#getAltitude <em>Altitude</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Altitude</em>' attribute.
	 * @see #getAltitude()
	 * @generated
	 */
  void setAltitude(int value);

} // Coordinate
