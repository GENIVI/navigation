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
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Localised Short String</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.LocalisedShortStringImpl#getLanguageCode <em>Language Code</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.LocalisedShortStringImpl#getString <em>String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalisedShortStringImpl extends EObjectImpl implements LocalisedShortString {
  /**
   * The default value of the '{@link #getLanguageCode() <em>Language Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguageCode()
   * @generated
   * @ordered
   */
  protected static final int LANGUAGE_CODE_EDEFAULT = 0;
  /**
   * The cached value of the '{@link #getLanguageCode() <em>Language Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguageCode()
   * @generated
   * @ordered
   */
  protected int languageCode = LANGUAGE_CODE_EDEFAULT;
  /**
   * This is true if the Language Code attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean languageCodeESet;
  /**
   * The default value of the '{@link #getString() <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected static final String STRING_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getString() <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected String string = STRING_EDEFAULT;
  /**
   * This is true if the String attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean stringESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LocalisedShortStringImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TpegfwktypesPackage.Literals.LOCALISED_SHORT_STRING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLanguageCode() {
    return languageCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLanguageCode(int newLanguageCode) {
    int oldLanguageCode = languageCode;
    languageCode = newLanguageCode;
    boolean oldLanguageCodeESet = languageCodeESet;
    languageCodeESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.LOCALISED_SHORT_STRING__LANGUAGE_CODE, oldLanguageCode, languageCode, !oldLanguageCodeESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLanguageCode() {
    int oldLanguageCode = languageCode;
    boolean oldLanguageCodeESet = languageCodeESet;
    languageCode = LANGUAGE_CODE_EDEFAULT;
    languageCodeESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, TpegfwktypesPackage.LOCALISED_SHORT_STRING__LANGUAGE_CODE, oldLanguageCode, LANGUAGE_CODE_EDEFAULT, oldLanguageCodeESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLanguageCode() {
    return languageCodeESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getString() {
    return string;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setString(String newString) {
    String oldString = string;
    string = newString;
    boolean oldStringESet = stringESet;
    stringESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TpegfwktypesPackage.LOCALISED_SHORT_STRING__STRING, oldString, string, !oldStringESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetString() {
    String oldString = string;
    boolean oldStringESet = stringESet;
    string = STRING_EDEFAULT;
    stringESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, TpegfwktypesPackage.LOCALISED_SHORT_STRING__STRING, oldString, STRING_EDEFAULT, oldStringESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetString() {
    return stringESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TpegfwktypesPackage.LOCALISED_SHORT_STRING__LANGUAGE_CODE:
        return getLanguageCode();
      case TpegfwktypesPackage.LOCALISED_SHORT_STRING__STRING:
        return getString();
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
      case TpegfwktypesPackage.LOCALISED_SHORT_STRING__LANGUAGE_CODE:
        setLanguageCode((Integer)newValue);
        return;
      case TpegfwktypesPackage.LOCALISED_SHORT_STRING__STRING:
        setString((String)newValue);
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
      case TpegfwktypesPackage.LOCALISED_SHORT_STRING__LANGUAGE_CODE:
        unsetLanguageCode();
        return;
      case TpegfwktypesPackage.LOCALISED_SHORT_STRING__STRING:
        unsetString();
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
      case TpegfwktypesPackage.LOCALISED_SHORT_STRING__LANGUAGE_CODE:
        return isSetLanguageCode();
      case TpegfwktypesPackage.LOCALISED_SHORT_STRING__STRING:
        return isSetString();
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
    result.append(" (languageCode: ");
    if (languageCodeESet) result.append(languageCode); else result.append("<unset>");
    result.append(", string: ");
    if (stringESet) result.append(string); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //LocalisedShortStringImpl
