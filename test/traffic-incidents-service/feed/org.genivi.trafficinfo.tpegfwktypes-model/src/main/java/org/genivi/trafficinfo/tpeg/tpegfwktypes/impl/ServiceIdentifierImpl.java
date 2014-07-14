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
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceIdentifierImpl#getSidA <em>Sid A</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceIdentifierImpl#getSidB <em>Sid B</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceIdentifierImpl#getSidC <em>Sid C</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceIdentifierImpl extends EObjectImpl implements ServiceIdentifier {
  /**
   * The default value of the '{@link #getSidA() <em>Sid A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSidA()
   * @generated
   * @ordered
   */
  protected static final byte SID_A_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getSidA() <em>Sid A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSidA()
   * @generated
   * @ordered
   */
  protected byte sidA = SID_A_EDEFAULT;

  /**
   * The default value of the '{@link #getSidB() <em>Sid B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSidB()
   * @generated
   * @ordered
   */
  protected static final byte SID_B_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getSidB() <em>Sid B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSidB()
   * @generated
   * @ordered
   */
  protected byte sidB = SID_B_EDEFAULT;

  /**
   * The default value of the '{@link #getSidC() <em>Sid C</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSidC()
   * @generated
   * @ordered
   */
  protected static final byte SID_C_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getSidC() <em>Sid C</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSidC()
   * @generated
   * @ordered
   */
  protected byte sidC = SID_C_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ServiceIdentifierImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.SERVICE_IDENTIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getSidA() {
    return sidA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSidA(byte newSidA) {
    byte oldSidA = sidA;
    sidA = newSidA;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_A, oldSidA, sidA));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getSidB() {
    return sidB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSidB(byte newSidB) {
    byte oldSidB = sidB;
    sidB = newSidB;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_B, oldSidB, sidB));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getSidC() {
    return sidC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSidC(byte newSidC) {
    byte oldSidC = sidC;
    sidC = newSidC;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_C, oldSidC, sidC));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_A:
        return getSidA();
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_B:
        return getSidB();
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_C:
        return getSidC();
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
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_A:
        setSidA((Byte)newValue);
        return;
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_B:
        setSidB((Byte)newValue);
        return;
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_C:
        setSidC((Byte)newValue);
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
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_A:
        setSidA(SID_A_EDEFAULT);
        return;
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_B:
        setSidB(SID_B_EDEFAULT);
        return;
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_C:
        setSidC(SID_C_EDEFAULT);
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
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_A:
        return sidA != SID_A_EDEFAULT;
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_B:
        return sidB != SID_B_EDEFAULT;
      case TpegfwktypesPackage.SERVICE_IDENTIFIER__SID_C:
        return sidC != SID_C_EDEFAULT;
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
    result.append(" (sidA: ");
    result.append(sidA);
    result.append(", sidB: ");
    result.append(sidB);
    result.append(", sidC: ");
    result.append(sidC);
    result.append(')');
    return result.toString();
  }

} //ServiceIdentifierImpl
