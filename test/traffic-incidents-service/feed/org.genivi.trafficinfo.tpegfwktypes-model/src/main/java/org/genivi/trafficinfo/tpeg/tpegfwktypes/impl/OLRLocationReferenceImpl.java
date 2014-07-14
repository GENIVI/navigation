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
import org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OLR Location Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.OLRLocationReferenceImpl#getLocationData <em>Location Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OLRLocationReferenceImpl extends MethodImpl implements OLRLocationReference {
  /**
   * The default value of the '{@link #getLocationData() <em>Location Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocationData()
   * @generated
   * @ordered
   */
  protected static final byte[] LOCATION_DATA_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getLocationData() <em>Location Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocationData()
   * @generated
   * @ordered
   */
  protected byte[] locationData = LOCATION_DATA_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OLRLocationReferenceImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.OLR_LOCATION_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte[] getLocationData() {
    return locationData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocationData(byte[] newLocationData) {
    byte[] oldLocationData = locationData;
    locationData = newLocationData;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.OLR_LOCATION_REFERENCE__LOCATION_DATA, oldLocationData, locationData));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.OLR_LOCATION_REFERENCE__LOCATION_DATA:
        return getLocationData();
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
      case TpegfwktypesPackage.OLR_LOCATION_REFERENCE__LOCATION_DATA:
        setLocationData((byte[])newValue);
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
      case TpegfwktypesPackage.OLR_LOCATION_REFERENCE__LOCATION_DATA:
        setLocationData(LOCATION_DATA_EDEFAULT);
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
      case TpegfwktypesPackage.OLR_LOCATION_REFERENCE__LOCATION_DATA:
        return LOCATION_DATA_EDEFAULT == null ? locationData != null : !LOCATION_DATA_EDEFAULT.equals(locationData);
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
    result.append(" (locationData: ");
    result.append(locationData);
    result.append(')');
    return result.toString();
  }

} //OLRLocationReferenceImpl
