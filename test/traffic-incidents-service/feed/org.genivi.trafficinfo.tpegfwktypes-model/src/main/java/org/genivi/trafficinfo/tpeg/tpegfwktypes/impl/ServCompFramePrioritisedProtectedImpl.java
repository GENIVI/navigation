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
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Serv Comp Frame Prioritised Protected</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedProtectedImpl#getGroupPriority <em>Group Priority</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedProtectedImpl#getApplicationContent <em>Application Content</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedProtectedImpl#getDataCRC <em>Data CRC</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServCompFramePrioritisedProtectedImpl extends ServiceComponentFrameImpl implements ServCompFramePrioritisedProtected {
  /**
   * The default value of the '{@link #getGroupPriority() <em>Group Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroupPriority()
   * @generated
   * @ordered
   */
  protected static final int GROUP_PRIORITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getGroupPriority() <em>Group Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroupPriority()
   * @generated
   * @ordered
   */
  protected int groupPriority = GROUP_PRIORITY_EDEFAULT;

  /**
   * The default value of the '{@link #getApplicationContent() <em>Application Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplicationContent()
   * @generated
   * @ordered
   */
  protected static final Object APPLICATION_CONTENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getApplicationContent() <em>Application Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplicationContent()
   * @generated
   * @ordered
   */
  protected Object applicationContent = APPLICATION_CONTENT_EDEFAULT;

  /**
   * The default value of the '{@link #getDataCRC() <em>Data CRC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataCRC()
   * @generated
   * @ordered
   */
  protected static final int DATA_CRC_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDataCRC() <em>Data CRC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataCRC()
   * @generated
   * @ordered
   */
  protected int dataCRC = DATA_CRC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ServCompFramePrioritisedProtectedImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.SERV_COMP_FRAME_PRIORITISED_PROTECTED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getGroupPriority() {
    return groupPriority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGroupPriority(int newGroupPriority) {
    int oldGroupPriority = groupPriority;
    groupPriority = newGroupPriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__GROUP_PRIORITY, oldGroupPriority, groupPriority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object getApplicationContent() {
    return applicationContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplicationContent(Object newApplicationContent) {
    Object oldApplicationContent = applicationContent;
    applicationContent = newApplicationContent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__APPLICATION_CONTENT, oldApplicationContent, applicationContent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDataCRC() {
    return dataCRC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataCRC(int newDataCRC) {
    int oldDataCRC = dataCRC;
    dataCRC = newDataCRC;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__DATA_CRC, oldDataCRC, dataCRC));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__GROUP_PRIORITY:
        return getGroupPriority();
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__APPLICATION_CONTENT:
        return getApplicationContent();
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__DATA_CRC:
        return getDataCRC();
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
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__GROUP_PRIORITY:
        setGroupPriority((Integer)newValue);
        return;
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__APPLICATION_CONTENT:
        setApplicationContent(newValue);
        return;
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__DATA_CRC:
        setDataCRC((Integer)newValue);
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
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__GROUP_PRIORITY:
        setGroupPriority(GROUP_PRIORITY_EDEFAULT);
        return;
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__APPLICATION_CONTENT:
        setApplicationContent(APPLICATION_CONTENT_EDEFAULT);
        return;
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__DATA_CRC:
        setDataCRC(DATA_CRC_EDEFAULT);
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
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__GROUP_PRIORITY:
        return groupPriority != GROUP_PRIORITY_EDEFAULT;
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__APPLICATION_CONTENT:
        return APPLICATION_CONTENT_EDEFAULT == null ? applicationContent != null : !APPLICATION_CONTENT_EDEFAULT.equals(applicationContent);
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED__DATA_CRC:
        return dataCRC != DATA_CRC_EDEFAULT;
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
    result.append(" (groupPriority: ");
    result.append(groupPriority);
    result.append(", applicationContent: ");
    result.append(applicationContent);
    result.append(", dataCRC: ");
    result.append(dataCRC);
    result.append(')');
    return result.toString();
  }

} //ServCompFramePrioritisedProtectedImpl
