/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Component Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getSCID <em>SCID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getFieldLength <em>Field Length</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getScHeaderCRC <em>Sc Header CRC</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceComponentFrame()
 * @model
 * @generated
 */
public interface ServiceComponentFrame extends EObject {
  /**
   * Returns the value of the '<em><b>SCID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>SCID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>SCID</em>' attribute.
   * @see #setSCID(byte)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceComponentFrame_SCID()
   * @model required="true"
   * @generated
   */
  byte getSCID();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getSCID <em>SCID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>SCID</em>' attribute.
   * @see #getSCID()
   * @generated
   */
  void setSCID(byte value);

  /**
   * Returns the value of the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field Length</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Length</em>' attribute.
   * @see #setFieldLength(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceComponentFrame_FieldLength()
   * @model required="true"
   * @generated
   */
  int getFieldLength();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getFieldLength <em>Field Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field Length</em>' attribute.
   * @see #getFieldLength()
   * @generated
   */
  void setFieldLength(int value);

  /**
   * Returns the value of the '<em><b>Sc Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sc Header CRC</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sc Header CRC</em>' attribute.
   * @see #setScHeaderCRC(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceComponentFrame_ScHeaderCRC()
   * @model required="true"
   * @generated
   */
  int getScHeaderCRC();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getScHeaderCRC <em>Sc Header CRC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sc Header CRC</em>' attribute.
   * @see #getScHeaderCRC()
   * @generated
   */
  void setScHeaderCRC(int value);

} // ServiceComponentFrame
