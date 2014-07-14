/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OLR Location Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference#getLocationData <em>Location Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getOLRLocationReference()
 * @model
 * @generated
 */
public interface OLRLocationReference extends Method {

  /**
   * Returns the value of the '<em><b>Location Data</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location Data</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Location Data</em>' attribute.
   * @see #setLocationData(byte[])
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getOLRLocationReference_LocationData()
   * @model required="true"
   * @generated
   */
  byte[] getLocationData();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference#getLocationData <em>Location Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Location Data</em>' attribute.
   * @see #getLocationData()
   * @generated
   */
  void setLocationData(byte[] value);
} // OLRLocationReference
