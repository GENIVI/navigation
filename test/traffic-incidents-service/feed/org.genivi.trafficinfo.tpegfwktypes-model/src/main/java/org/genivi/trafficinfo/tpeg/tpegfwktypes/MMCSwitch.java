/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

import java.util.Date;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MMC Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageID <em>Message ID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getVersionID <em>Version ID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageExpiryTime <em>Message Expiry Time</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#isCancelFlag <em>Cancel Flag</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageGenerationTime <em>Message Generation Time</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCSwitch()
 * @model
 * @generated
 */
public interface MMCSwitch extends EObject {

  /**
   * Returns the value of the '<em><b>Message ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message ID</em>' attribute.
   * @see #setMessageID(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCSwitch_MessageID()
   * @model required="true"
   * @generated
   */
  int getMessageID();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageID <em>Message ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message ID</em>' attribute.
   * @see #getMessageID()
   * @generated
   */
  void setMessageID(int value);

  /**
   * Returns the value of the '<em><b>Version ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version ID</em>' attribute.
   * @see #setVersionID(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCSwitch_VersionID()
   * @model required="true"
   * @generated
   */
  int getVersionID();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getVersionID <em>Version ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version ID</em>' attribute.
   * @see #getVersionID()
   * @generated
   */
  void setVersionID(int value);

  /**
   * Returns the value of the '<em><b>Message Expiry Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * TODO: Change type to TPEG DateTime
   * <!-- end-model-doc -->
   * @return the value of the '<em>Message Expiry Time</em>' attribute.
   * @see #setMessageExpiryTime(Date)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCSwitch_MessageExpiryTime()
   * @model required="true"
   * @generated
   */
  Date getMessageExpiryTime();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageExpiryTime <em>Message Expiry Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Expiry Time</em>' attribute.
   * @see #getMessageExpiryTime()
   * @generated
   */
  void setMessageExpiryTime(Date value);

  /**
   * Returns the value of the '<em><b>Cancel Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cancel Flag</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cancel Flag</em>' attribute.
   * @see #setCancelFlag(boolean)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCSwitch_CancelFlag()
   * @model required="true"
   * @generated
   */
  boolean isCancelFlag();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#isCancelFlag <em>Cancel Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cancel Flag</em>' attribute.
   * @see #isCancelFlag()
   * @generated
   */
  void setCancelFlag(boolean value);

  /**
   * Returns the value of the '<em><b>Message Generation Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * TODO Change to TPEG DateTime.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Message Generation Time</em>' attribute.
   * @see #setMessageGenerationTime(Date)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCSwitch_MessageGenerationTime()
   * @model
   * @generated
   */
  Date getMessageGenerationTime();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageGenerationTime <em>Message Generation Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Generation Time</em>' attribute.
   * @see #getMessageGenerationTime()
   * @generated
   */
  void setMessageGenerationTime(Date value);

  /**
   * Returns the value of the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * TODO Change to TPEG type Priority
   * <!-- end-model-doc -->
   * @return the value of the '<em>Priority</em>' attribute.
   * @see #setPriority(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCSwitch_Priority()
   * @model
   * @generated
   */
  int getPriority();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getPriority <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' attribute.
   * @see #getPriority()
   * @generated
   */
  void setPriority(int value);
} // MMCSwitch
