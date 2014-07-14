/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes.impl;


import java.util.Date;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MMC Switch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCSwitchImpl#getMessageID <em>Message ID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCSwitchImpl#getVersionID <em>Version ID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCSwitchImpl#getMessageExpiryTime <em>Message Expiry Time</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCSwitchImpl#isCancelFlag <em>Cancel Flag</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCSwitchImpl#getMessageGenerationTime <em>Message Generation Time</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCSwitchImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MMCSwitchImpl extends EObjectImpl implements MMCSwitch {
  /**
   * The default value of the '{@link #getMessageID() <em>Message ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageID()
   * @generated
   * @ordered
   */
  protected static final int MESSAGE_ID_EDEFAULT = 0;
  /**
   * The cached value of the '{@link #getMessageID() <em>Message ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageID()
   * @generated
   * @ordered
   */
  protected int messageID = MESSAGE_ID_EDEFAULT;
  /**
   * The default value of the '{@link #getVersionID() <em>Version ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersionID()
   * @generated
   * @ordered
   */
  protected static final int VERSION_ID_EDEFAULT = 0;
  /**
   * The cached value of the '{@link #getVersionID() <em>Version ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersionID()
   * @generated
   * @ordered
   */
  protected int versionID = VERSION_ID_EDEFAULT;
  /**
   * The default value of the '{@link #getMessageExpiryTime() <em>Message Expiry Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageExpiryTime()
   * @generated
   * @ordered
   */
  protected static final Date MESSAGE_EXPIRY_TIME_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getMessageExpiryTime() <em>Message Expiry Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageExpiryTime()
   * @generated
   * @ordered
   */
  protected Date messageExpiryTime = MESSAGE_EXPIRY_TIME_EDEFAULT;
  /**
   * The default value of the '{@link #isCancelFlag() <em>Cancel Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCancelFlag()
   * @generated
   * @ordered
   */
  protected static final boolean CANCEL_FLAG_EDEFAULT = false;
  /**
   * The cached value of the '{@link #isCancelFlag() <em>Cancel Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCancelFlag()
   * @generated
   * @ordered
   */
  protected boolean cancelFlag = CANCEL_FLAG_EDEFAULT;
  /**
   * The default value of the '{@link #getMessageGenerationTime() <em>Message Generation Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageGenerationTime()
   * @generated
   * @ordered
   */
  protected static final Date MESSAGE_GENERATION_TIME_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getMessageGenerationTime() <em>Message Generation Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageGenerationTime()
   * @generated
   * @ordered
   */
  protected Date messageGenerationTime = MESSAGE_GENERATION_TIME_EDEFAULT;
  /**
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final int PRIORITY_EDEFAULT = 0;
  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected int priority = PRIORITY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MMCSwitchImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.MMC_SWITCH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMessageID() {
    return messageID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessageID(int newMessageID) {
    int oldMessageID = messageID;
    messageID = newMessageID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.MMC_SWITCH__MESSAGE_ID, oldMessageID, messageID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getVersionID() {
    return versionID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersionID(int newVersionID) {
    int oldVersionID = versionID;
    versionID = newVersionID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.MMC_SWITCH__VERSION_ID, oldVersionID, versionID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Date getMessageExpiryTime() {
    return messageExpiryTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessageExpiryTime(Date newMessageExpiryTime) {
    Date oldMessageExpiryTime = messageExpiryTime;
    messageExpiryTime = newMessageExpiryTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.MMC_SWITCH__MESSAGE_EXPIRY_TIME, oldMessageExpiryTime, messageExpiryTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCancelFlag() {
    return cancelFlag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCancelFlag(boolean newCancelFlag) {
    boolean oldCancelFlag = cancelFlag;
    cancelFlag = newCancelFlag;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.MMC_SWITCH__CANCEL_FLAG, oldCancelFlag, cancelFlag));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Date getMessageGenerationTime() {
    return messageGenerationTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessageGenerationTime(Date newMessageGenerationTime) {
    Date oldMessageGenerationTime = messageGenerationTime;
    messageGenerationTime = newMessageGenerationTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.MMC_SWITCH__MESSAGE_GENERATION_TIME, oldMessageGenerationTime, messageGenerationTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPriority() {
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriority(int newPriority) {
    int oldPriority = priority;
    priority = newPriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.MMC_SWITCH__PRIORITY, oldPriority, priority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_ID:
        return getMessageID();
      case TpegfwktypesPackage.MMC_SWITCH__VERSION_ID:
        return getVersionID();
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_EXPIRY_TIME:
        return getMessageExpiryTime();
      case TpegfwktypesPackage.MMC_SWITCH__CANCEL_FLAG:
        return isCancelFlag();
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_GENERATION_TIME:
        return getMessageGenerationTime();
      case TpegfwktypesPackage.MMC_SWITCH__PRIORITY:
        return getPriority();
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
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_ID:
        setMessageID((Integer)newValue);
        return;
      case TpegfwktypesPackage.MMC_SWITCH__VERSION_ID:
        setVersionID((Integer)newValue);
        return;
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_EXPIRY_TIME:
        setMessageExpiryTime((Date)newValue);
        return;
      case TpegfwktypesPackage.MMC_SWITCH__CANCEL_FLAG:
        setCancelFlag((Boolean)newValue);
        return;
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_GENERATION_TIME:
        setMessageGenerationTime((Date)newValue);
        return;
      case TpegfwktypesPackage.MMC_SWITCH__PRIORITY:
        setPriority((Integer)newValue);
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
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_ID:
        setMessageID(MESSAGE_ID_EDEFAULT);
        return;
      case TpegfwktypesPackage.MMC_SWITCH__VERSION_ID:
        setVersionID(VERSION_ID_EDEFAULT);
        return;
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_EXPIRY_TIME:
        setMessageExpiryTime(MESSAGE_EXPIRY_TIME_EDEFAULT);
        return;
      case TpegfwktypesPackage.MMC_SWITCH__CANCEL_FLAG:
        setCancelFlag(CANCEL_FLAG_EDEFAULT);
        return;
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_GENERATION_TIME:
        setMessageGenerationTime(MESSAGE_GENERATION_TIME_EDEFAULT);
        return;
      case TpegfwktypesPackage.MMC_SWITCH__PRIORITY:
        setPriority(PRIORITY_EDEFAULT);
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
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_ID:
        return messageID != MESSAGE_ID_EDEFAULT;
      case TpegfwktypesPackage.MMC_SWITCH__VERSION_ID:
        return versionID != VERSION_ID_EDEFAULT;
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_EXPIRY_TIME:
        return MESSAGE_EXPIRY_TIME_EDEFAULT == null ? messageExpiryTime != null : !MESSAGE_EXPIRY_TIME_EDEFAULT.equals(messageExpiryTime);
      case TpegfwktypesPackage.MMC_SWITCH__CANCEL_FLAG:
        return cancelFlag != CANCEL_FLAG_EDEFAULT;
      case TpegfwktypesPackage.MMC_SWITCH__MESSAGE_GENERATION_TIME:
        return MESSAGE_GENERATION_TIME_EDEFAULT == null ? messageGenerationTime != null : !MESSAGE_GENERATION_TIME_EDEFAULT.equals(messageGenerationTime);
      case TpegfwktypesPackage.MMC_SWITCH__PRIORITY:
        return priority != PRIORITY_EDEFAULT;
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
    result.append(" (messageID: ");
    result.append(messageID);
    result.append(", versionID: ");
    result.append(versionID);
    result.append(", messageExpiryTime: ");
    result.append(messageExpiryTime);
    result.append(", cancelFlag: ");
    result.append(cancelFlag);
    result.append(", messageGenerationTime: ");
    result.append(messageGenerationTime);
    result.append(", priority: ");
    result.append(priority);
    result.append(')');
    return result.toString();
  }

} //MMCSwitchImpl
