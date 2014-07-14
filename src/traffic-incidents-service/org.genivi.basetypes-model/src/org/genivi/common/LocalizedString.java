/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Localized String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.common.LocalizedString#getLanguageCode <em>Language Code</em>}</li>
 *   <li>{@link org.genivi.common.LocalizedString#getCountryCode <em>Country Code</em>}</li>
 *   <li>{@link org.genivi.common.LocalizedString#getString <em>String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.common.CommonPackage#getLocalizedString()
 * @model
 * @generated
 */
public interface LocalizedString extends EObject {
  /**
	 * Returns the value of the '<em><b>Language Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Language Code</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Code</em>' attribute.
	 * @see #isSetLanguageCode()
	 * @see #unsetLanguageCode()
	 * @see #setLanguageCode(String)
	 * @see org.genivi.common.CommonPackage#getLocalizedString_LanguageCode()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  String getLanguageCode();

  /**
	 * Sets the value of the '{@link org.genivi.common.LocalizedString#getLanguageCode <em>Language Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language Code</em>' attribute.
	 * @see #isSetLanguageCode()
	 * @see #unsetLanguageCode()
	 * @see #getLanguageCode()
	 * @generated
	 */
  void setLanguageCode(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.common.LocalizedString#getLanguageCode <em>Language Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLanguageCode()
	 * @see #getLanguageCode()
	 * @see #setLanguageCode(String)
	 * @generated
	 */
  void unsetLanguageCode();

  /**
	 * Returns whether the value of the '{@link org.genivi.common.LocalizedString#getLanguageCode <em>Language Code</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Language Code</em>' attribute is set.
	 * @see #unsetLanguageCode()
	 * @see #getLanguageCode()
	 * @see #setLanguageCode(String)
	 * @generated
	 */
  boolean isSetLanguageCode();

  /**
	 * Returns the value of the '<em><b>Country Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Country Code</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Country Code</em>' attribute.
	 * @see #isSetCountryCode()
	 * @see #unsetCountryCode()
	 * @see #setCountryCode(String)
	 * @see org.genivi.common.CommonPackage#getLocalizedString_CountryCode()
	 * @model unsettable="true"
	 * @generated
	 */
  String getCountryCode();

  /**
	 * Sets the value of the '{@link org.genivi.common.LocalizedString#getCountryCode <em>Country Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Country Code</em>' attribute.
	 * @see #isSetCountryCode()
	 * @see #unsetCountryCode()
	 * @see #getCountryCode()
	 * @generated
	 */
  void setCountryCode(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.common.LocalizedString#getCountryCode <em>Country Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetCountryCode()
	 * @see #getCountryCode()
	 * @see #setCountryCode(String)
	 * @generated
	 */
  void unsetCountryCode();

  /**
	 * Returns whether the value of the '{@link org.genivi.common.LocalizedString#getCountryCode <em>Country Code</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Country Code</em>' attribute is set.
	 * @see #unsetCountryCode()
	 * @see #getCountryCode()
	 * @see #setCountryCode(String)
	 * @generated
	 */
  boolean isSetCountryCode();

  /**
	 * Returns the value of the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' attribute.
	 * @see #isSetString()
	 * @see #unsetString()
	 * @see #setString(String)
	 * @see org.genivi.common.CommonPackage#getLocalizedString_String()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  String getString();

  /**
	 * Sets the value of the '{@link org.genivi.common.LocalizedString#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' attribute.
	 * @see #isSetString()
	 * @see #unsetString()
	 * @see #getString()
	 * @generated
	 */
  void setString(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.common.LocalizedString#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetString()
	 * @see #getString()
	 * @see #setString(String)
	 * @generated
	 */
  void unsetString();

  /**
	 * Returns whether the value of the '{@link org.genivi.common.LocalizedString#getString <em>String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>String</em>' attribute is set.
	 * @see #unsetString()
	 * @see #getString()
	 * @see #setString(String)
	 * @generated
	 */
  boolean isSetString();

} // LocalizedString
