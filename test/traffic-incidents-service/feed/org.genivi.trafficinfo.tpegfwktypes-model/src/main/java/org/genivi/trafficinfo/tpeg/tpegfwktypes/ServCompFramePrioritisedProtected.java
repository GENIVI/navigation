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
 * A representation of the model object '<em><b>Serv Comp Frame Prioritised Protected</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getGroupPriority <em>Group Priority</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getApplicationContent <em>Application Content</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getDataCRC <em>Data CRC</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServCompFramePrioritisedProtected()
 * @model
 * @generated
 */
public interface ServCompFramePrioritisedProtected extends ServiceComponentFrame {
  /**
   * Returns the value of the '<em><b>Group Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group Priority</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group Priority</em>' attribute.
   * @see #setGroupPriority(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServCompFramePrioritisedProtected_GroupPriority()
   * @model required="true"
   * @generated
   */
  int getGroupPriority();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getGroupPriority <em>Group Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group Priority</em>' attribute.
   * @see #getGroupPriority()
   * @generated
   */
  void setGroupPriority(int value);

  /**
   * Returns the value of the '<em><b>Application Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Content</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Content</em>' attribute.
   * @see #setApplicationContent(Object)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServCompFramePrioritisedProtected_ApplicationContent()
   * @model required="true"
   * @generated
   */
  Object getApplicationContent();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getApplicationContent <em>Application Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Application Content</em>' attribute.
   * @see #getApplicationContent()
   * @generated
   */
  void setApplicationContent(Object value);

  /**
   * Returns the value of the '<em><b>Data CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data CRC</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data CRC</em>' attribute.
   * @see #setDataCRC(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServCompFramePrioritisedProtected_DataCRC()
   * @model required="true"
   * @generated
   */
  int getDataCRC();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getDataCRC <em>Data CRC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data CRC</em>' attribute.
   * @see #getDataCRC()
   * @generated
   */
  void setDataCRC(int value);

} // ServCompFramePrioritisedProtected
