/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.locref;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.locref.LocationReference#getData <em>Data</em>}</li>
 *   <li>{@link org.genivi.locref.LocationReference#getLocationReferenceType <em>Location Reference Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.locref.locrefPackage#getLocationReference()
 * @model
 * @generated
 */
public interface LocationReference extends EObject {
  /**
	 * Returns the value of the '<em><b>Location Reference Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location Reference Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Location Reference Type</em>' attribute.
	 * @see #isSetLocationReferenceType()
	 * @see #unsetLocationReferenceType()
	 * @see #setLocationReferenceType(byte)
	 * @see org.genivi.locref.locrefPackage#getLocationReference_LocationReferenceType()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  byte getLocationReferenceType();

  /**
	 * Sets the value of the '{@link org.genivi.locref.LocationReference#getLocationReferenceType <em>Location Reference Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location Reference Type</em>' attribute.
	 * @see #isSetLocationReferenceType()
	 * @see #unsetLocationReferenceType()
	 * @see #getLocationReferenceType()
	 * @generated
	 */
  void setLocationReferenceType(byte value);

  /**
	 * Unsets the value of the '{@link org.genivi.locref.LocationReference#getLocationReferenceType <em>Location Reference Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLocationReferenceType()
	 * @see #getLocationReferenceType()
	 * @see #setLocationReferenceType(byte)
	 * @generated
	 */
  void unsetLocationReferenceType();

  /**
	 * Returns whether the value of the '{@link org.genivi.locref.LocationReference#getLocationReferenceType <em>Location Reference Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Location Reference Type</em>' attribute is set.
	 * @see #unsetLocationReferenceType()
	 * @see #getLocationReferenceType()
	 * @see #setLocationReferenceType(byte)
	 * @generated
	 */
  boolean isSetLocationReferenceType();

  /**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #isSetData()
	 * @see #unsetData()
	 * @see #setData(Object)
	 * @see org.genivi.locref.locrefPackage#getLocationReference_Data()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  Object getData();

  /**
	 * Sets the value of the '{@link org.genivi.locref.LocationReference#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #isSetData()
	 * @see #unsetData()
	 * @see #getData()
	 * @generated
	 */
  void setData(Object value);

  /**
	 * Unsets the value of the '{@link org.genivi.locref.LocationReference#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetData()
	 * @see #getData()
	 * @see #setData(Object)
	 * @generated
	 */
  void unsetData();

  /**
	 * Returns whether the value of the '{@link org.genivi.locref.LocationReference#getData <em>Data</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Data</em>' attribute is set.
	 * @see #unsetData()
	 * @see #getData()
	 * @see #setData(Object)
	 * @generated
	 */
  boolean isSetData();

} // LocationReference
