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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stream Directory Frame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.StreamDirectoryFrameImpl#getSID <em>SID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.StreamDirectoryFrameImpl#getNumberOfServices <em>Number Of Services</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.StreamDirectoryFrameImpl#getHeaderCRC <em>Header CRC</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StreamDirectoryFrameImpl extends EObjectImpl implements StreamDirectoryFrame {
  /**
   * The cached value of the '{@link #getSID() <em>SID</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSID()
   * @generated
   * @ordered
   */
  protected EList<ServiceIdentifier> sid;

  /**
   * The default value of the '{@link #getNumberOfServices() <em>Number Of Services</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumberOfServices()
   * @generated
   * @ordered
   */
  protected static final int NUMBER_OF_SERVICES_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNumberOfServices() <em>Number Of Services</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumberOfServices()
   * @generated
   * @ordered
   */
  protected int numberOfServices = NUMBER_OF_SERVICES_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StreamDirectoryFrameImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.STREAM_DIRECTORY_FRAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ServiceIdentifier> getSID() {
    if (sid == null) {
      sid = new EObjectContainmentEList<ServiceIdentifier>(ServiceIdentifier.class, this, TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__SID);
    }
    return sid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getNumberOfServices() {
    return numberOfServices;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumberOfServices(int newNumberOfServices) {
    int oldNumberOfServices = numberOfServices;
    numberOfServices = newNumberOfServices;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__NUMBER_OF_SERVICES, oldNumberOfServices, numberOfServices));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__HEADER_CRC, oldHeaderCRC, headerCRC));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__SID:
        return ((InternalEList<?>)getSID()).basicRemove(otherEnd, msgs);
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
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__SID:
        return getSID();
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__NUMBER_OF_SERVICES:
        return getNumberOfServices();
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__HEADER_CRC:
        return getHeaderCRC();
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
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__SID:
        getSID().clear();
        getSID().addAll((Collection<? extends ServiceIdentifier>)newValue);
        return;
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__NUMBER_OF_SERVICES:
        setNumberOfServices((Integer)newValue);
        return;
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__HEADER_CRC:
        setHeaderCRC((Integer)newValue);
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
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__SID:
        getSID().clear();
        return;
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__NUMBER_OF_SERVICES:
        setNumberOfServices(NUMBER_OF_SERVICES_EDEFAULT);
        return;
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__HEADER_CRC:
        setHeaderCRC(HEADER_CRC_EDEFAULT);
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
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__SID:
        return sid != null && !sid.isEmpty();
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__NUMBER_OF_SERVICES:
        return numberOfServices != NUMBER_OF_SERVICES_EDEFAULT;
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME__HEADER_CRC:
        return headerCRC != HEADER_CRC_EDEFAULT;
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
    result.append(" (numberOfServices: ");
    result.append(numberOfServices);
    result.append(", headerCRC: ");
    result.append(headerCRC);
    result.append(')');
    return result.toString();
  }

} //StreamDirectoryFrameImpl
