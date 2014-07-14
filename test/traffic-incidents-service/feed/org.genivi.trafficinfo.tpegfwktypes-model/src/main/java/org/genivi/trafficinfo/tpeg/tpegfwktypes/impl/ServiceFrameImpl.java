/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Frame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceFrameImpl#getServEncID <em>Serv Enc ID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceFrameImpl#getServiceFrameContent <em>Service Frame Content</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceFrameImpl#getSID <em>SID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceFrameImpl extends EObjectImpl implements ServiceFrame {
  /**
   * The default value of the '{@link #getServEncID() <em>Serv Enc ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServEncID()
   * @generated
   * @ordered
   */
  protected static final int SERV_ENC_ID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getServEncID() <em>Serv Enc ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServEncID()
   * @generated
   * @ordered
   */
  protected int servEncID = SERV_ENC_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getServiceFrameContent() <em>Service Frame Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServiceFrameContent()
   * @generated
   * @ordered
   */
  protected ServCompMultiplex serviceFrameContent;

  /**
   * The cached value of the '{@link #getSID() <em>SID</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSID()
   * @generated
   * @ordered
   */
  protected ServiceIdentifier sid;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ServiceFrameImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.SERVICE_FRAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getServEncID() {
    return servEncID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setServEncID(int newServEncID) {
    int oldServEncID = servEncID;
    servEncID = newServEncID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_FRAME__SERV_ENC_ID, oldServEncID, servEncID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServCompMultiplex getServiceFrameContent() {
    return serviceFrameContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetServiceFrameContent(ServCompMultiplex newServiceFrameContent, NotificationChain msgs) {
    ServCompMultiplex oldServiceFrameContent = serviceFrameContent;
    serviceFrameContent = newServiceFrameContent;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_FRAME__SERVICE_FRAME_CONTENT, oldServiceFrameContent, newServiceFrameContent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setServiceFrameContent(ServCompMultiplex newServiceFrameContent) {
    if (newServiceFrameContent != serviceFrameContent) {
      NotificationChain msgs = null;
      if (serviceFrameContent != null)
        msgs = ((InternalEObject)serviceFrameContent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TpegfwktypesPackage.SERVICE_FRAME__SERVICE_FRAME_CONTENT, null, msgs);
      if (newServiceFrameContent != null)
        msgs = ((InternalEObject)newServiceFrameContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TpegfwktypesPackage.SERVICE_FRAME__SERVICE_FRAME_CONTENT, null, msgs);
      msgs = basicSetServiceFrameContent(newServiceFrameContent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_FRAME__SERVICE_FRAME_CONTENT, newServiceFrameContent, newServiceFrameContent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceIdentifier getSID() {
    return sid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSID(ServiceIdentifier newSID, NotificationChain msgs) {
    ServiceIdentifier oldSID = sid;
    sid = newSID;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_FRAME__SID, oldSID, newSID);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSID(ServiceIdentifier newSID) {
    if (newSID != sid) {
      NotificationChain msgs = null;
      if (sid != null)
        msgs = ((InternalEObject)sid).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TpegfwktypesPackage.SERVICE_FRAME__SID, null, msgs);
      if (newSID != null)
        msgs = ((InternalEObject)newSID).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TpegfwktypesPackage.SERVICE_FRAME__SID, null, msgs);
      msgs = basicSetSID(newSID, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_FRAME__SID, newSID, newSID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case TpegfwktypesPackage.SERVICE_FRAME__SERVICE_FRAME_CONTENT:
        return basicSetServiceFrameContent(null, msgs);
      case TpegfwktypesPackage.SERVICE_FRAME__SID:
        return basicSetSID(null, msgs);
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
      case TpegfwktypesPackage.SERVICE_FRAME__SERV_ENC_ID:
        return getServEncID();
      case TpegfwktypesPackage.SERVICE_FRAME__SERVICE_FRAME_CONTENT:
        return getServiceFrameContent();
      case TpegfwktypesPackage.SERVICE_FRAME__SID:
        return getSID();
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
      case TpegfwktypesPackage.SERVICE_FRAME__SERV_ENC_ID:
        setServEncID((Integer)newValue);
        return;
      case TpegfwktypesPackage.SERVICE_FRAME__SERVICE_FRAME_CONTENT:
        setServiceFrameContent((ServCompMultiplex)newValue);
        return;
      case TpegfwktypesPackage.SERVICE_FRAME__SID:
        setSID((ServiceIdentifier)newValue);
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
      case TpegfwktypesPackage.SERVICE_FRAME__SERV_ENC_ID:
        setServEncID(SERV_ENC_ID_EDEFAULT);
        return;
      case TpegfwktypesPackage.SERVICE_FRAME__SERVICE_FRAME_CONTENT:
        setServiceFrameContent((ServCompMultiplex)null);
        return;
      case TpegfwktypesPackage.SERVICE_FRAME__SID:
        setSID((ServiceIdentifier)null);
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
      case TpegfwktypesPackage.SERVICE_FRAME__SERV_ENC_ID:
        return servEncID != SERV_ENC_ID_EDEFAULT;
      case TpegfwktypesPackage.SERVICE_FRAME__SERVICE_FRAME_CONTENT:
        return serviceFrameContent != null;
      case TpegfwktypesPackage.SERVICE_FRAME__SID:
        return sid != null;
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
    result.append(" (servEncID: ");
    result.append(servEncID);
    result.append(')');
    return result.toString();
  }

} //ServiceFrameImpl
