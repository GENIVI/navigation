/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.trafficinfo.tpeg.snitypes.SniComponent;
import org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sni Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentImpl#getN <em>N</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SniComponentImpl extends EObjectImpl implements SniComponent {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final byte ID_EDEFAULT = 0x00;
  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected byte id = ID_EDEFAULT;
  /**
   * This is true if the Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean idESet;
  /**
   * The default value of the '{@link #getN() <em>N</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getN()
   * @generated
   * @ordered
   */
  protected static final int N_EDEFAULT = 0;
  /**
   * The cached value of the '{@link #getN() <em>N</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getN()
   * @generated
   * @ordered
   */
  protected int n = N_EDEFAULT;

  /**
   * This is true if the N attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean nESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SniComponentImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return SnitypesPackage.Literals.SNI_COMPONENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getId() {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(byte newId) {
    byte oldId = id;
    id = newId;
    boolean oldIdESet = idESet;
    idESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.SNI_COMPONENT__ID, oldId, id, !oldIdESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetId() {
    byte oldId = id;
    boolean oldIdESet = idESet;
    id = ID_EDEFAULT;
    idESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.SNI_COMPONENT__ID, oldId, ID_EDEFAULT, oldIdESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetId() {
    return idESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getN() {
    return n;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setN(int newN) {
    int oldN = n;
    n = newN;
    boolean oldNESet = nESet;
    nESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.SNI_COMPONENT__N, oldN, n, !oldNESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetN() {
    int oldN = n;
    boolean oldNESet = nESet;
    n = N_EDEFAULT;
    nESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.SNI_COMPONENT__N, oldN, N_EDEFAULT, oldNESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetN() {
    return nESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case SnitypesPackage.SNI_COMPONENT__ID:
        return getId();
      case SnitypesPackage.SNI_COMPONENT__N:
        return getN();
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
      case SnitypesPackage.SNI_COMPONENT__ID:
        setId((Byte)newValue);
        return;
      case SnitypesPackage.SNI_COMPONENT__N:
        setN((Integer)newValue);
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
      case SnitypesPackage.SNI_COMPONENT__ID:
        unsetId();
        return;
      case SnitypesPackage.SNI_COMPONENT__N:
        unsetN();
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
      case SnitypesPackage.SNI_COMPONENT__ID:
        return isSetId();
      case SnitypesPackage.SNI_COMPONENT__N:
        return isSetN();
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
    result.append(" (id: ");
    if (idESet) result.append(id); else result.append("<unset>");
    result.append(", n: ");
    if (nESet) result.append(n); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //SniComponentImpl
