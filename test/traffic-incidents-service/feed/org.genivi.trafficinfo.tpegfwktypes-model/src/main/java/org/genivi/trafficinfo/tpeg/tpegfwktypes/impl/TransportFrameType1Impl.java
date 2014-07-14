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
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transport Frame Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameType1Impl#getTransportFrameContent <em>Transport Frame Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransportFrameType1Impl extends TransportFrameTemplateImpl implements TransportFrameType1 {
  /**
   * The cached value of the '{@link #getTransportFrameContent() <em>Transport Frame Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransportFrameContent()
   * @generated
   * @ordered
   */
  protected ServiceFrame transportFrameContent;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransportFrameType1Impl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.TRANSPORT_FRAME_TYPE1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceFrame getTransportFrameContent() {
    return transportFrameContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTransportFrameContent(ServiceFrame newTransportFrameContent, NotificationChain msgs) {
    ServiceFrame oldTransportFrameContent = transportFrameContent;
    transportFrameContent = newTransportFrameContent;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT, oldTransportFrameContent, newTransportFrameContent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransportFrameContent(ServiceFrame newTransportFrameContent) {
    if (newTransportFrameContent != transportFrameContent) {
      NotificationChain msgs = null;
      if (transportFrameContent != null)
        msgs = ((InternalEObject)transportFrameContent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT, null, msgs);
      if (newTransportFrameContent != null)
        msgs = ((InternalEObject)newTransportFrameContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT, null, msgs);
      msgs = basicSetTransportFrameContent(newTransportFrameContent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT, newTransportFrameContent, newTransportFrameContent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT:
        return basicSetTransportFrameContent(null, msgs);
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
      case TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT:
        return getTransportFrameContent();
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
      case TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT:
        setTransportFrameContent((ServiceFrame)newValue);
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
      case TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT:
        setTransportFrameContent((ServiceFrame)null);
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
      case TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT:
        return transportFrameContent != null;
    }
    return super.eIsSet(featureID);
  }

} //TransportFrameType1Impl
