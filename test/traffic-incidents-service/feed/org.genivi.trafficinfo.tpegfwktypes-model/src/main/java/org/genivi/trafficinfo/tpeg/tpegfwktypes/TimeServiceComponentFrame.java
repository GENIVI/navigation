/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Service Component Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getDate <em>Date</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getFormattedDate <em>Formatted Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTimeServiceComponentFrame()
 * @model
 * @generated
 */
public interface TimeServiceComponentFrame extends ServiceComponentFrame {
  /**
   * Returns the value of the '<em><b>Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date</em>' attribute.
   * @see #isSetDate()
   * @see #unsetDate()
   * @see #setDate(Date)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTimeServiceComponentFrame_Date()
   * @model unsettable="true"
   * @generated
   */
  Date getDate();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getDate <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date</em>' attribute.
   * @see #isSetDate()
   * @see #unsetDate()
   * @see #getDate()
   * @generated
   */
  void setDate(Date value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getDate <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetDate()
   * @see #getDate()
   * @see #setDate(Date)
   * @generated
   */
  void unsetDate();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getDate <em>Date</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Date</em>' attribute is set.
   * @see #unsetDate()
   * @see #getDate()
   * @see #setDate(Date)
   * @generated
   */
  boolean isSetDate();

  /**
   * Returns the value of the '<em><b>Formatted Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formatted Date</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formatted Date</em>' attribute.
   * @see #isSetFormattedDate()
   * @see #unsetFormattedDate()
   * @see #setFormattedDate(String)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTimeServiceComponentFrame_FormattedDate()
   * @model unsettable="true"
   * @generated
   */
  String getFormattedDate();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getFormattedDate <em>Formatted Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formatted Date</em>' attribute.
   * @see #isSetFormattedDate()
   * @see #unsetFormattedDate()
   * @see #getFormattedDate()
   * @generated
   */
  void setFormattedDate(String value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getFormattedDate <em>Formatted Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFormattedDate()
   * @see #getFormattedDate()
   * @see #setFormattedDate(String)
   * @generated
   */
  void unsetFormattedDate();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getFormattedDate <em>Formatted Date</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Formatted Date</em>' attribute is set.
   * @see #unsetFormattedDate()
   * @see #getFormattedDate()
   * @see #setFormattedDate(String)
   * @generated
   */
  boolean isSetFormattedDate();

} // TimeServiceComponentFrame
