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
 * A representation of the model object '<em><b>Transport Frame Type0</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType0#getTransportFrameContent <em>Transport Frame Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTransportFrameType0()
 * @model
 * @generated
 */
public interface TransportFrameType0 extends TransportFrameTemplate {
  /**
   * Returns the value of the '<em><b>Transport Frame Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transport Frame Content</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transport Frame Content</em>' containment reference.
   * @see #setTransportFrameContent(StreamDirectoryFrame)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTransportFrameType0_TransportFrameContent()
   * @model containment="true" required="true"
   * @generated
   */
  StreamDirectoryFrame getTransportFrameContent();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType0#getTransportFrameContent <em>Transport Frame Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transport Frame Content</em>' containment reference.
   * @see #getTransportFrameContent()
   * @generated
   */
  void setTransportFrameContent(StreamDirectoryFrame value);

} // TransportFrameType0
