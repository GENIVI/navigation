/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.family;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.family.Address#getStreet <em>Street</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.family.FamilyPackage#getAddress()
 * @model
 * @generated
 */
public interface Address extends EObject {
  /**
	 * Returns the value of the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Street</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Street</em>' attribute.
	 * @see #isSetStreet()
	 * @see #unsetStreet()
	 * @see #setStreet(String)
	 * @see org.genivi.family.FamilyPackage#getAddress_Street()
	 * @model unsettable="true"
	 * @generated
	 */
  String getStreet();

  /**
	 * Sets the value of the '{@link org.genivi.family.Address#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @see #isSetStreet()
	 * @see #unsetStreet()
	 * @see #getStreet()
	 * @generated
	 */
  void setStreet(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.family.Address#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetStreet()
	 * @see #getStreet()
	 * @see #setStreet(String)
	 * @generated
	 */
  void unsetStreet();

  /**
	 * Returns whether the value of the '{@link org.genivi.family.Address#getStreet <em>Street</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Street</em>' attribute is set.
	 * @see #unsetStreet()
	 * @see #getStreet()
	 * @see #setStreet(String)
	 * @generated
	 */
  boolean isSetStreet();

} // Address
