/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MMC Message Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMessagePartImpl#getPartID <em>Part ID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMessagePartImpl#getUpdateMode <em>Update Mode</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMessagePartImpl#getMasterMessageVersions <em>Master Message Versions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MMCMessagePartImpl extends MMCSwitchImpl implements MMCMessagePart {
  /**
   * The default value of the '{@link #getPartID() <em>Part ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartID()
   * @generated
   * @ordered
   */
  protected static final int PART_ID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPartID() <em>Part ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartID()
   * @generated
   * @ordered
   */
  protected int partID = PART_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getUpdateMode() <em>Update Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdateMode()
   * @generated
   * @ordered
   */
  protected static final int UPDATE_MODE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getUpdateMode() <em>Update Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdateMode()
   * @generated
   * @ordered
   */
  protected int updateMode = UPDATE_MODE_EDEFAULT;

  /**
   * The cached value of the '{@link #getMasterMessageVersions() <em>Master Message Versions</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMasterMessageVersions()
   * @generated
   * @ordered
   */
  protected EList<Integer> masterMessageVersions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MMCMessagePartImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.MMC_MESSAGE_PART;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPartID() {
    return partID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartID(int newPartID) {
    int oldPartID = partID;
    partID = newPartID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.MMC_MESSAGE_PART__PART_ID, oldPartID, partID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getUpdateMode() {
    return updateMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpdateMode(int newUpdateMode) {
    int oldUpdateMode = updateMode;
    updateMode = newUpdateMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.MMC_MESSAGE_PART__UPDATE_MODE, oldUpdateMode, updateMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getMasterMessageVersions() {
    if (masterMessageVersions == null) {
      masterMessageVersions = new EDataTypeUniqueEList<Integer>(Integer.class, this, TpegfwktypesPackage.MMC_MESSAGE_PART__MASTER_MESSAGE_VERSIONS);
    }
    return masterMessageVersions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.MMC_MESSAGE_PART__PART_ID:
        return getPartID();
      case TpegfwktypesPackage.MMC_MESSAGE_PART__UPDATE_MODE:
        return getUpdateMode();
      case TpegfwktypesPackage.MMC_MESSAGE_PART__MASTER_MESSAGE_VERSIONS:
        return getMasterMessageVersions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case TpegfwktypesPackage.MMC_MESSAGE_PART__PART_ID:
        setPartID((Integer)newValue);
        return;
      case TpegfwktypesPackage.MMC_MESSAGE_PART__UPDATE_MODE:
        setUpdateMode((Integer)newValue);
        return;
      case TpegfwktypesPackage.MMC_MESSAGE_PART__MASTER_MESSAGE_VERSIONS:
        getMasterMessageVersions().clear();
        getMasterMessageVersions().addAll((Collection<? extends Integer>)newValue);
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
      case TpegfwktypesPackage.MMC_MESSAGE_PART__PART_ID:
        setPartID(PART_ID_EDEFAULT);
        return;
      case TpegfwktypesPackage.MMC_MESSAGE_PART__UPDATE_MODE:
        setUpdateMode(UPDATE_MODE_EDEFAULT);
        return;
      case TpegfwktypesPackage.MMC_MESSAGE_PART__MASTER_MESSAGE_VERSIONS:
        getMasterMessageVersions().clear();
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
      case TpegfwktypesPackage.MMC_MESSAGE_PART__PART_ID:
        return partID != PART_ID_EDEFAULT;
      case TpegfwktypesPackage.MMC_MESSAGE_PART__UPDATE_MODE:
        return updateMode != UPDATE_MODE_EDEFAULT;
      case TpegfwktypesPackage.MMC_MESSAGE_PART__MASTER_MESSAGE_VERSIONS:
        return masterMessageVersions != null && !masterMessageVersions.isEmpty();
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
    result.append(" (partID: ");
    result.append(partID);
    result.append(", updateMode: ");
    result.append(updateMode);
    result.append(", masterMessageVersions: ");
    result.append(masterMessageVersions);
    result.append(')');
    return result.toString();
  }

} //MMCMessagePartImpl
