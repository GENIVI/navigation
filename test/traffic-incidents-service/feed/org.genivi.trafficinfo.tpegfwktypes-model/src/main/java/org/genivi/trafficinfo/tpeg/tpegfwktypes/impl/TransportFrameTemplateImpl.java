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
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transport Frame Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameTemplateImpl#getMetaInformationTODO <em>Meta Information TODO</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameTemplateImpl#getSyncWord <em>Sync Word</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameTemplateImpl#getFieldLength <em>Field Length</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameTemplateImpl#getHeaderCRC <em>Header CRC</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameTemplateImpl#getFrameType <em>Frame Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransportFrameTemplateImpl extends EObjectImpl implements TransportFrameTemplate {
  /**
   * The default value of the '{@link #getMetaInformationTODO() <em>Meta Information TODO</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetaInformationTODO()
   * @generated
   * @ordered
   */
  protected static final String META_INFORMATION_TODO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMetaInformationTODO() <em>Meta Information TODO</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetaInformationTODO()
   * @generated
   * @ordered
   */
  protected String metaInformationTODO = META_INFORMATION_TODO_EDEFAULT;

  /**
   * The default value of the '{@link #getSyncWord() <em>Sync Word</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSyncWord()
   * @generated
   * @ordered
   */
  protected static final int SYNC_WORD_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSyncWord() <em>Sync Word</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSyncWord()
   * @generated
   * @ordered
   */
  protected int syncWord = SYNC_WORD_EDEFAULT;

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
   * The default value of the '{@link #getHeaderCRC() <em>Header CRC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeaderCRC()
   * @generated
   * @ordered
   */
  protected static final int HEADER_CRC_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getHeaderCRC() <em>Header CRC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeaderCRC()
   * @generated
   * @ordered
   */
  protected int headerCRC = HEADER_CRC_EDEFAULT;

  /**
   * The default value of the '{@link #getFrameType() <em>Frame Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrameType()
   * @generated
   * @ordered
   */
  protected static final int FRAME_TYPE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getFrameType() <em>Frame Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrameType()
   * @generated
   * @ordered
   */
  protected int frameType = FRAME_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransportFrameTemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.TRANSPORT_FRAME_TEMPLATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMetaInformationTODO() {
    return metaInformationTODO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetaInformationTODO(String newMetaInformationTODO) {
    String oldMetaInformationTODO = metaInformationTODO;
    metaInformationTODO = newMetaInformationTODO;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__META_INFORMATION_TODO, oldMetaInformationTODO, metaInformationTODO));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSyncWord() {
    return syncWord;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSyncWord(int newSyncWord) {
    int oldSyncWord = syncWord;
    syncWord = newSyncWord;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__SYNC_WORD, oldSyncWord, syncWord));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__FIELD_LENGTH, oldFieldLength, fieldLength));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getHeaderCRC() {
    return headerCRC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHeaderCRC(int newHeaderCRC) {
    int oldHeaderCRC = headerCRC;
    headerCRC = newHeaderCRC;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__HEADER_CRC, oldHeaderCRC, headerCRC));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getFrameType() {
    return frameType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFrameType(int newFrameType) {
    int oldFrameType = frameType;
    frameType = newFrameType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__FRAME_TYPE, oldFrameType, frameType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__META_INFORMATION_TODO:
        return getMetaInformationTODO();
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__SYNC_WORD:
        return getSyncWord();
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__FIELD_LENGTH:
        return getFieldLength();
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__HEADER_CRC:
        return getHeaderCRC();
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__FRAME_TYPE:
        return getFrameType();
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
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__META_INFORMATION_TODO:
        setMetaInformationTODO((String)newValue);
        return;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__SYNC_WORD:
        setSyncWord((Integer)newValue);
        return;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__FIELD_LENGTH:
        setFieldLength((Integer)newValue);
        return;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__HEADER_CRC:
        setHeaderCRC((Integer)newValue);
        return;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__FRAME_TYPE:
        setFrameType((Integer)newValue);
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
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__META_INFORMATION_TODO:
        setMetaInformationTODO(META_INFORMATION_TODO_EDEFAULT);
        return;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__SYNC_WORD:
        setSyncWord(SYNC_WORD_EDEFAULT);
        return;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__FIELD_LENGTH:
        setFieldLength(FIELD_LENGTH_EDEFAULT);
        return;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__HEADER_CRC:
        setHeaderCRC(HEADER_CRC_EDEFAULT);
        return;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__FRAME_TYPE:
        setFrameType(FRAME_TYPE_EDEFAULT);
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
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__META_INFORMATION_TODO:
        return META_INFORMATION_TODO_EDEFAULT == null ? metaInformationTODO != null : !META_INFORMATION_TODO_EDEFAULT.equals(metaInformationTODO);
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__SYNC_WORD:
        return syncWord != SYNC_WORD_EDEFAULT;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__FIELD_LENGTH:
        return fieldLength != FIELD_LENGTH_EDEFAULT;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__HEADER_CRC:
        return headerCRC != HEADER_CRC_EDEFAULT;
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE__FRAME_TYPE:
        return frameType != FRAME_TYPE_EDEFAULT;
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
    result.append(" (metaInformationTODO: ");
    result.append(metaInformationTODO);
    result.append(", syncWord: ");
    result.append(syncWord);
    result.append(", fieldLength: ");
    result.append(fieldLength);
    result.append(", headerCRC: ");
    result.append(headerCRC);
    result.append(", frameType: ");
    result.append(frameType);
    result.append(')');
    return result.toString();
  }

} //TransportFrameTemplateImpl
