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

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Serv Comp Multiplex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompMultiplexImpl#getMultiplexContent <em>Multiplex Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServCompMultiplexImpl extends EObjectImpl implements ServCompMultiplex {
  /**
   * The cached value of the '{@link #getMultiplexContent() <em>Multiplex Content</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplexContent()
   * @generated
   * @ordered
   */
  protected EList<ServiceComponentFrame> multiplexContent;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ServCompMultiplexImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.SERV_COMP_MULTIPLEX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ServiceComponentFrame> getMultiplexContent() {
    if (multiplexContent == null) {
      multiplexContent = new EObjectContainmentEList<ServiceComponentFrame>(ServiceComponentFrame.class, this, TpegfwktypesPackage.SERV_COMP_MULTIPLEX__MULTIPLEX_CONTENT);
    }
    return multiplexContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case TpegfwktypesPackage.SERV_COMP_MULTIPLEX__MULTIPLEX_CONTENT:
        return ((InternalEList<?>)getMultiplexContent()).basicRemove(otherEnd, msgs);
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
      case TpegfwktypesPackage.SERV_COMP_MULTIPLEX__MULTIPLEX_CONTENT:
        return getMultiplexContent();
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
      case TpegfwktypesPackage.SERV_COMP_MULTIPLEX__MULTIPLEX_CONTENT:
        getMultiplexContent().clear();
        getMultiplexContent().addAll((Collection<? extends ServiceComponentFrame>)newValue);
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
      case TpegfwktypesPackage.SERV_COMP_MULTIPLEX__MULTIPLEX_CONTENT:
        getMultiplexContent().clear();
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
      case TpegfwktypesPackage.SERV_COMP_MULTIPLEX__MULTIPLEX_CONTENT:
        return multiplexContent != null && !multiplexContent.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ServCompMultiplexImpl
