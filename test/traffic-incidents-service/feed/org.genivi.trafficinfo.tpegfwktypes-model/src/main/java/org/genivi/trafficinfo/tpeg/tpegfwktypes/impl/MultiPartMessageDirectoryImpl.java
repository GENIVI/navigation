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
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Part Message Directory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MultiPartMessageDirectoryImpl#getPartID <em>Part ID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MultiPartMessageDirectoryImpl#getPartType <em>Part Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiPartMessageDirectoryImpl extends EObjectImpl implements MultiPartMessageDirectory {
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
   * The default value of the '{@link #getPartType() <em>Part Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartType()
   * @generated
   * @ordered
   */
  protected static final int PART_TYPE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPartType() <em>Part Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartType()
   * @generated
   * @ordered
   */
  protected int partType = PART_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultiPartMessageDirectoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.MULTI_PART_MESSAGE_DIRECTORY;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY__PART_ID, oldPartID, partID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPartType() {
    return partType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartType(int newPartType) {
    int oldPartType = partType;
    partType = newPartType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY__PART_TYPE, oldPartType, partType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY__PART_ID:
        return getPartID();
      case TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY__PART_TYPE:
        return getPartType();
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
      case TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY__PART_ID:
        setPartID((Integer)newValue);
        return;
      case TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY__PART_TYPE:
        setPartType((Integer)newValue);
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
      case TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY__PART_ID:
        setPartID(PART_ID_EDEFAULT);
        return;
      case TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY__PART_TYPE:
        setPartType(PART_TYPE_EDEFAULT);
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
      case TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY__PART_ID:
        return partID != PART_ID_EDEFAULT;
      case TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY__PART_TYPE:
        return partType != PART_TYPE_EDEFAULT;
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
    result.append(", partType: ");
    result.append(partType);
    result.append(')');
    return result.toString();
  }

} //MultiPartMessageDirectoryImpl
