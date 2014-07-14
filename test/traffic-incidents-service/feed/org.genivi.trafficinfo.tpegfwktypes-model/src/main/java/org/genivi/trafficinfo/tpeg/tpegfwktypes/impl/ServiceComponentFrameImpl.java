/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Component Frame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceComponentFrameImpl#getSCID <em>SCID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceComponentFrameImpl#getFieldLength <em>Field Length</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceComponentFrameImpl#getScHeaderCRC <em>Sc Header CRC</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceComponentFrameImpl extends EObjectImpl implements ServiceComponentFrame {
  /**
   * The default value of the '{@link #getSCID() <em>SCID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSCID()
   * @generated
   * @ordered
   */
  protected static final byte SCID_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getSCID() <em>SCID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSCID()
   * @generated
   * @ordered
   */
  protected byte scid = SCID_EDEFAULT;

  /**
   * The default value of the '{@link #getFieldLength() <em>Field Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldLength()
   * @generated
   * @ordered
   */
  protected static final int FIELD_LENGTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getFieldLength() <em>Field Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldLength()
   * @generated
   * @ordered
   */
  protected int fieldLength = FIELD_LENGTH_EDEFAULT;

  /**
   * The default value of the '{@link #getScHeaderCRC() <em>Sc Header CRC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScHeaderCRC()
   * @generated
   * @ordered
   */
  protected static final int SC_HEADER_CRC_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getScHeaderCRC() <em>Sc Header CRC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScHeaderCRC()
   * @generated
   * @ordered
   */
  protected int scHeaderCRC = SC_HEADER_CRC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ServiceComponentFrameImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.SERVICE_COMPONENT_FRAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getSCID() {
    return scid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSCID(byte newSCID) {
    byte oldSCID = scid;
    scid = newSCID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__SCID, oldSCID, scid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getFieldLength() {
    return fieldLength;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldLength(int newFieldLength) {
    int oldFieldLength = fieldLength;
    fieldLength = newFieldLength;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__FIELD_LENGTH, oldFieldLength, fieldLength));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getScHeaderCRC() {
    return scHeaderCRC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScHeaderCRC(int newScHeaderCRC) {
    int oldScHeaderCRC = scHeaderCRC;
    scHeaderCRC = newScHeaderCRC;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__SC_HEADER_CRC, oldScHeaderCRC, scHeaderCRC));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__SCID:
        return getSCID();
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__FIELD_LENGTH:
        return getFieldLength();
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__SC_HEADER_CRC:
        return getScHeaderCRC();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__SCID:
        setSCID((Byte)newValue);
        return;
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__FIELD_LENGTH:
        setFieldLength((Integer)newValue);
        return;
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__SC_HEADER_CRC:
        setScHeaderCRC((Integer)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__SCID:
        setSCID(SCID_EDEFAULT);
        return;
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__FIELD_LENGTH:
        setFieldLength(FIELD_LENGTH_EDEFAULT);
        return;
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__SC_HEADER_CRC:
        setScHeaderCRC(SC_HEADER_CRC_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__SCID:
        return scid != SCID_EDEFAULT;
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__FIELD_LENGTH:
        return fieldLength != FIELD_LENGTH_EDEFAULT;
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME__SC_HEADER_CRC:
        return scHeaderCRC != SC_HEADER_CRC_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (SCID: ");
    result.append(scid);
    result.append(", fieldLength: ");
    result.append(fieldLength);
    result.append(", scHeaderCRC: ");
    result.append(scHeaderCRC);
    result.append(')');
    return result.toString();
  }

} //ServiceComponentFrameImpl
