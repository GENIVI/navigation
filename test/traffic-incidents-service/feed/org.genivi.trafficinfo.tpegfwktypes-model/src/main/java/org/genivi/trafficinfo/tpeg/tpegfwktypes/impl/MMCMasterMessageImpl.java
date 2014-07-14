/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMasterMessage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MMC Master Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMasterMessageImpl#getMultiPartMessageDirectory <em>Multi Part Message Directory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MMCMasterMessageImpl extends MMCSwitchImpl implements MMCMasterMessage {
  /**
   * The cached value of the '{@link #getMultiPartMessageDirectory() <em>Multi Part Message Directory</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiPartMessageDirectory()
   * @generated
   * @ordered
   */
  protected EList<MultiPartMessageDirectory> multiPartMessageDirectory;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MMCMasterMessageImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.MMC_MASTER_MESSAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MultiPartMessageDirectory> getMultiPartMessageDirectory() {
    if (multiPartMessageDirectory == null) {
      multiPartMessageDirectory = new EObjectContainmentEList<MultiPartMessageDirectory>(MultiPartMessageDirectory.class, this, TpegfwktypesPackage.MMC_MASTER_MESSAGE__MULTI_PART_MESSAGE_DIRECTORY);
    }
    return multiPartMessageDirectory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case TpegfwktypesPackage.MMC_MASTER_MESSAGE__MULTI_PART_MESSAGE_DIRECTORY:
        return ((InternalEList<?>)getMultiPartMessageDirectory()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.MMC_MASTER_MESSAGE__MULTI_PART_MESSAGE_DIRECTORY:
        return getMultiPartMessageDirectory();
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
      case TpegfwktypesPackage.MMC_MASTER_MESSAGE__MULTI_PART_MESSAGE_DIRECTORY:
        getMultiPartMessageDirectory().clear();
        getMultiPartMessageDirectory().addAll((Collection<? extends MultiPartMessageDirectory>)newValue);
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
      case TpegfwktypesPackage.MMC_MASTER_MESSAGE__MULTI_PART_MESSAGE_DIRECTORY:
        getMultiPartMessageDirectory().clear();
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
      case TpegfwktypesPackage.MMC_MASTER_MESSAGE__MULTI_PART_MESSAGE_DIRECTORY:
        return multiPartMessageDirectory != null && !multiPartMessageDirectory.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MMCMasterMessageImpl
