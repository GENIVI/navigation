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
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This datatype is used to provide version information.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.common.Version#getMajor <em>Major</em>}</li>
 *   <li>{@link org.genivi.common.Version#getMinor <em>Minor</em>}</li>
 *   <li>{@link org.genivi.common.Version#getMicro <em>Micro</em>}</li>
 *   <li>{@link org.genivi.common.Version#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.common.CommonPackage#getVersion()
 * @model
 * @generated
 */
public interface Version extends EObject {
  /**
	 * Returns the value of the '<em><b>Major</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Major</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The major version number.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Major</em>' attribute.
	 * @see #isSetMajor()
	 * @see #unsetMajor()
	 * @see #setMajor(int)
	 * @see org.genivi.common.CommonPackage#getVersion_Major()
	 * @model unsettable="true" required="true"
	 *        annotation="http://www.tomtom.com/emfidl/2012/GenModel valueMin='0' valueMax='32767'"
	 * @generated
	 */
  int getMajor();

  /**
	 * Sets the value of the '{@link org.genivi.common.Version#getMajor <em>Major</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Major</em>' attribute.
	 * @see #isSetMajor()
	 * @see #unsetMajor()
	 * @see #getMajor()
	 * @generated
	 */
  void setMajor(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.common.Version#getMajor <em>Major</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetMajor()
	 * @see #getMajor()
	 * @see #setMajor(int)
	 * @generated
	 */
  void unsetMajor();

  /**
	 * Returns whether the value of the '{@link org.genivi.common.Version#getMajor <em>Major</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Major</em>' attribute is set.
	 * @see #unsetMajor()
	 * @see #getMajor()
	 * @see #setMajor(int)
	 * @generated
	 */
  boolean isSetMajor();

  /**
	 * Returns the value of the '<em><b>Minor</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Minor</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minor version number.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minor</em>' attribute.
	 * @see #isSetMinor()
	 * @see #unsetMinor()
	 * @see #setMinor(int)
	 * @see org.genivi.common.CommonPackage#getVersion_Minor()
	 * @model unsettable="true" required="true"
	 *        annotation="http://www.tomtom.com/emfidl/2012/GenModel valueMin='0' valueMax='32767'"
	 * @generated
	 */
  int getMinor();

  /**
	 * Sets the value of the '{@link org.genivi.common.Version#getMinor <em>Minor</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minor</em>' attribute.
	 * @see #isSetMinor()
	 * @see #unsetMinor()
	 * @see #getMinor()
	 * @generated
	 */
  void setMinor(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.common.Version#getMinor <em>Minor</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetMinor()
	 * @see #getMinor()
	 * @see #setMinor(int)
	 * @generated
	 */
  void unsetMinor();

  /**
	 * Returns whether the value of the '{@link org.genivi.common.Version#getMinor <em>Minor</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Minor</em>' attribute is set.
	 * @see #unsetMinor()
	 * @see #getMinor()
	 * @see #setMinor(int)
	 * @generated
	 */
  boolean isSetMinor();

  /**
	 * Returns the value of the '<em><b>Micro</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Micro</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The micro version number.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Micro</em>' attribute.
	 * @see #isSetMicro()
	 * @see #unsetMicro()
	 * @see #setMicro(int)
	 * @see org.genivi.common.CommonPackage#getVersion_Micro()
	 * @model unsettable="true" required="true"
	 *        annotation="http://www.tomtom.com/emfidl/2012/GenModel valueMin='0' valueMax='32767'"
	 * @generated
	 */
  int getMicro();

  /**
	 * Sets the value of the '{@link org.genivi.common.Version#getMicro <em>Micro</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Micro</em>' attribute.
	 * @see #isSetMicro()
	 * @see #unsetMicro()
	 * @see #getMicro()
	 * @generated
	 */
  void setMicro(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.common.Version#getMicro <em>Micro</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetMicro()
	 * @see #getMicro()
	 * @see #setMicro(int)
	 * @generated
	 */
  void unsetMicro();

  /**
	 * Returns whether the value of the '{@link org.genivi.common.Version#getMicro <em>Micro</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Micro</em>' attribute is set.
	 * @see #unsetMicro()
	 * @see #getMicro()
	 * @see #setMicro(int)
	 * @generated
	 */
  boolean isSetMicro();

  /**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The date of this version.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #isSetDate()
	 * @see #unsetDate()
	 * @see #setDate(String)
	 * @see org.genivi.common.CommonPackage#getVersion_Date()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  String getDate();

  /**
	 * Sets the value of the '{@link org.genivi.common.Version#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #isSetDate()
	 * @see #unsetDate()
	 * @see #getDate()
	 * @generated
	 */
  void setDate(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.common.Version#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetDate()
	 * @see #getDate()
	 * @see #setDate(String)
	 * @generated
	 */
  void unsetDate();

  /**
	 * Returns whether the value of the '{@link org.genivi.common.Version#getDate <em>Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Date</em>' attribute is set.
	 * @see #unsetDate()
	 * @see #getDate()
	 * @see #setDate(String)
	 * @generated
	 */
  boolean isSetDate();

} // Version
