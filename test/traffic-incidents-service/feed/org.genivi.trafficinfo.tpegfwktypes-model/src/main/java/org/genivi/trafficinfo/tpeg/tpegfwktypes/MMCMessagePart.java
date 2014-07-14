/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MMC Message Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getPartID <em>Part ID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getUpdateMode <em>Update Mode</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getMasterMessageVersions <em>Master Message Versions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCMessagePart()
 * @model
 * @generated
 */
public interface MMCMessagePart extends MMCSwitch {
  /**
   * Returns the value of the '<em><b>Part ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Part ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Part ID</em>' attribute.
   * @see #setPartID(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCMessagePart_PartID()
   * @model required="true"
   * @generated
   */
  int getPartID();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getPartID <em>Part ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Part ID</em>' attribute.
   * @see #getPartID()
   * @generated
   */
  void setPartID(int value);

  /**
   * Returns the value of the '<em><b>Update Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * TODO: change type to TPEG type UpdateMode
   * <!-- end-model-doc -->
   * @return the value of the '<em>Update Mode</em>' attribute.
   * @see #setUpdateMode(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCMessagePart_UpdateMode()
   * @model required="true"
   * @generated
   */
  int getUpdateMode();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getUpdateMode <em>Update Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Update Mode</em>' attribute.
   * @see #getUpdateMode()
   * @generated
   */
  void setUpdateMode(int value);

  /**
   * Returns the value of the '<em><b>Master Message Versions</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Master Message Versions</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Master Message Versions</em>' attribute list.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCMessagePart_MasterMessageVersions()
   * @model upper="255"
   * @generated
   */
  EList<Integer> getMasterMessageVersions();

} // MMCMessagePart
