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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.family.Person#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.genivi.family.Person#getSexe <em>Sexe</em>}</li>
 *   <li>{@link org.genivi.family.Person#getOwnedCars <em>Owned Cars</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.family.FamilyPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
  /**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #isSetFirstName()
	 * @see #unsetFirstName()
	 * @see #setFirstName(String)
	 * @see org.genivi.family.FamilyPackage#getPerson_FirstName()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  String getFirstName();

  /**
	 * Sets the value of the '{@link org.genivi.family.Person#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #isSetFirstName()
	 * @see #unsetFirstName()
	 * @see #getFirstName()
	 * @generated
	 */
  void setFirstName(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.family.Person#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetFirstName()
	 * @see #getFirstName()
	 * @see #setFirstName(String)
	 * @generated
	 */
  void unsetFirstName();

  /**
	 * Returns whether the value of the '{@link org.genivi.family.Person#getFirstName <em>First Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>First Name</em>' attribute is set.
	 * @see #unsetFirstName()
	 * @see #getFirstName()
	 * @see #setFirstName(String)
	 * @generated
	 */
  boolean isSetFirstName();

  /**
	 * Returns the value of the '<em><b>Sexe</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.family.Sexe}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sexe</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Sexe</em>' attribute.
	 * @see org.genivi.family.Sexe
	 * @see #isSetSexe()
	 * @see #unsetSexe()
	 * @see #setSexe(Sexe)
	 * @see org.genivi.family.FamilyPackage#getPerson_Sexe()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  Sexe getSexe();

  /**
	 * Sets the value of the '{@link org.genivi.family.Person#getSexe <em>Sexe</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sexe</em>' attribute.
	 * @see org.genivi.family.Sexe
	 * @see #isSetSexe()
	 * @see #unsetSexe()
	 * @see #getSexe()
	 * @generated
	 */
  void setSexe(Sexe value);

  /**
	 * Unsets the value of the '{@link org.genivi.family.Person#getSexe <em>Sexe</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSexe()
	 * @see #getSexe()
	 * @see #setSexe(Sexe)
	 * @generated
	 */
  void unsetSexe();

  /**
	 * Returns whether the value of the '{@link org.genivi.family.Person#getSexe <em>Sexe</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sexe</em>' attribute is set.
	 * @see #unsetSexe()
	 * @see #getSexe()
	 * @see #setSexe(Sexe)
	 * @generated
	 */
  boolean isSetSexe();

  /**
	 * Returns the value of the '<em><b>Owned Cars</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.family.Car}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Cars</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Cars</em>' containment reference list.
	 * @see org.genivi.family.FamilyPackage#getPerson_OwnedCars()
	 * @model containment="true"
	 * @generated
	 */
  EList<Car> getOwnedCars();

} // Person
