/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stream Directory Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getSID <em>SID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getNumberOfServices <em>Number Of Services</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getHeaderCRC <em>Header CRC</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getStreamDirectoryFrame()
 * @model
 * @generated
 */
public interface StreamDirectoryFrame extends EObject {
  /**
   * Returns the value of the '<em><b>SID</b></em>' containment reference list.
   * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>SID</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>SID</em>' containment reference list.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getStreamDirectoryFrame_SID()
   * @model containment="true" required="true"
   * @generated
   */
  EList<ServiceIdentifier> getSID();

  /**
   * Returns the value of the '<em><b>Number Of Services</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number Of Services</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number Of Services</em>' attribute.
   * @see #setNumberOfServices(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getStreamDirectoryFrame_NumberOfServices()
   * @model required="true"
   * @generated
   */
  int getNumberOfServices();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getNumberOfServices <em>Number Of Services</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number Of Services</em>' attribute.
   * @see #getNumberOfServices()
   * @generated
   */
  void setNumberOfServices(int value);

  /**
   * Returns the value of the '<em><b>Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Header CRC</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Header CRC</em>' attribute.
   * @see #setHeaderCRC(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getStreamDirectoryFrame_HeaderCRC()
   * @model required="true"
   * @generated
   */
  int getHeaderCRC();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getHeaderCRC <em>Header CRC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Header CRC</em>' attribute.
   * @see #getHeaderCRC()
   * @generated
   */
  void setHeaderCRC(int value);

} // StreamDirectoryFrame
