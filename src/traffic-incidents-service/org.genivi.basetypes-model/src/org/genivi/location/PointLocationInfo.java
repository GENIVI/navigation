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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Point Location Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.location.PointLocationInfo#getLocationType <em>Location Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.location.LocationPackage#getPointLocationInfo()
 * @model
 * @generated
 */
public interface PointLocationInfo extends LocationInfo {
  /**
	 * Returns the value of the '<em><b>Location Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.location.PointLocationType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Location Type</em>' attribute.
	 * @see org.genivi.location.PointLocationType
	 * @see #setLocationType(PointLocationType)
	 * @see org.genivi.location.LocationPackage#getPointLocationInfo_LocationType()
	 * @model
	 * @generated
	 */
  PointLocationType getLocationType();

  /**
	 * Sets the value of the '{@link org.genivi.location.PointLocationInfo#getLocationType <em>Location Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location Type</em>' attribute.
	 * @see org.genivi.location.PointLocationType
	 * @see #getLocationType()
	 * @generated
	 */
  void setLocationType(PointLocationType value);

} // PointLocationInfo
