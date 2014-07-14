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
 * A representation of the model object '<em><b>Car</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.family.Car#getNumberOfSeats <em>Number Of Seats</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.family.FamilyPackage#getCar()
 * @model
 * @generated
 */
public interface Car extends EObject {
  /**
	 * Returns the value of the '<em><b>Number Of Seats</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number Of Seats</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Seats</em>' attribute.
	 * @see #isSetNumberOfSeats()
	 * @see #unsetNumberOfSeats()
	 * @see #setNumberOfSeats(Integer)
	 * @see org.genivi.family.FamilyPackage#getCar_NumberOfSeats()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getNumberOfSeats();

  /**
	 * Sets the value of the '{@link org.genivi.family.Car#getNumberOfSeats <em>Number Of Seats</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Seats</em>' attribute.
	 * @see #isSetNumberOfSeats()
	 * @see #unsetNumberOfSeats()
	 * @see #getNumberOfSeats()
	 * @generated
	 */
  void setNumberOfSeats(Integer value);

  /**
	 * Unsets the value of the '{@link org.genivi.family.Car#getNumberOfSeats <em>Number Of Seats</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetNumberOfSeats()
	 * @see #getNumberOfSeats()
	 * @see #setNumberOfSeats(Integer)
	 * @generated
	 */
  void unsetNumberOfSeats();

  /**
	 * Returns whether the value of the '{@link org.genivi.family.Car#getNumberOfSeats <em>Number Of Seats</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Of Seats</em>' attribute is set.
	 * @see #unsetNumberOfSeats()
	 * @see #getNumberOfSeats()
	 * @see #setNumberOfSeats(Integer)
	 * @generated
	 */
  boolean isSetNumberOfSeats();

} // Car
