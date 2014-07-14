/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes.impl;


import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Service Component Frame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TimeServiceComponentFrameImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TimeServiceComponentFrameImpl#getFormattedDate <em>Formatted Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeServiceComponentFrameImpl extends ServiceComponentFrameImpl implements TimeServiceComponentFrame {
  /**
   * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDate()
   * @generated
   * @ordered
   */
  protected static final Date DATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDate()
   * @generated
   * @ordered
   */
  protected Date date = DATE_EDEFAULT;

  /**
   * This is true if the Date attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean dateESet;

  /**
   * The default value of the '{@link #getFormattedDate() <em>Formatted Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormattedDate()
   * @generated
   * @ordered
   */
  protected static final String FORMATTED_DATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFormattedDate() <em>Formatted Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormattedDate()
   * @generated
   * @ordered
   */
  protected String formattedDate = FORMATTED_DATE_EDEFAULT;

  /**
   * This is true if the Formatted Date attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean formattedDateESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimeServiceComponentFrameImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.TIME_SERVICE_COMPONENT_FRAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Date getDate() {
    return date;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDate(Date newDate) {
    Date oldDate = date;
    date = newDate;
    boolean oldDateESet = dateESet;
    dateESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__DATE, oldDate, date, !oldDateESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetDate() {
    Date oldDate = date;
    boolean oldDateESet = dateESet;
    date = DATE_EDEFAULT;
    dateESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__DATE, oldDate, DATE_EDEFAULT, oldDateESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetDate() {
    return dateESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFormattedDate() {
    return formattedDate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormattedDate(String newFormattedDate) {
    String oldFormattedDate = formattedDate;
    formattedDate = newFormattedDate;
    boolean oldFormattedDateESet = formattedDateESet;
    formattedDateESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__FORMATTED_DATE, oldFormattedDate, formattedDate, !oldFormattedDateESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetFormattedDate() {
    String oldFormattedDate = formattedDate;
    boolean oldFormattedDateESet = formattedDateESet;
    formattedDate = FORMATTED_DATE_EDEFAULT;
    formattedDateESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__FORMATTED_DATE, oldFormattedDate, FORMATTED_DATE_EDEFAULT, oldFormattedDateESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetFormattedDate() {
    return formattedDateESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__DATE:
        return getDate();
      case TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__FORMATTED_DATE:
        return getFormattedDate();
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
      case TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__DATE:
        setDate((Date)newValue);
        return;
      case TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__FORMATTED_DATE:
        setFormattedDate((String)newValue);
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
      case TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__DATE:
        unsetDate();
        return;
      case TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__FORMATTED_DATE:
        unsetFormattedDate();
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
      case TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__DATE:
        return isSetDate();
      case TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME__FORMATTED_DATE:
        return isSetFormattedDate();
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
    result.append(" (date: ");
    if (dateESet) result.append(date); else result.append("<unset>");
    result.append(", formattedDate: ");
    if (formattedDateESet) result.append(formattedDate); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //TimeServiceComponentFrameImpl
