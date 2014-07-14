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
 * A representation of the model object '<em><b>Family</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.family.Family#getMembers <em>Members</em>}</li>
 *   <li>{@link org.genivi.family.Family#getSurname <em>Surname</em>}</li>
 *   <li>{@link org.genivi.family.Family#getNumberOfPets <em>Number Of Pets</em>}</li>
 *   <li>{@link org.genivi.family.Family#isHasASwimmingPool <em>Has ASwimming Pool</em>}</li>
 *   <li>{@link org.genivi.family.Family#getAddress <em>Address</em>}</li>
 *   <li>{@link org.genivi.family.Family#getFavoriteHolidayDestinations <em>Favorite Holiday Destinations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.family.FamilyPackage#getFamily()
 * @model
 * @generated
 */
public interface Family extends EObject {
  /**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.family.Person}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.genivi.family.FamilyPackage#getFamily_Members()
	 * @model containment="true" required="true"
	 * @generated
	 */
  EList<Person> getMembers();

  /**
	 * Returns the value of the '<em><b>Surname</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Surname</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Surname</em>' attribute.
	 * @see #isSetSurname()
	 * @see #unsetSurname()
	 * @see #setSurname(String)
	 * @see org.genivi.family.FamilyPackage#getFamily_Surname()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  String getSurname();

  /**
	 * Sets the value of the '{@link org.genivi.family.Family#getSurname <em>Surname</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surname</em>' attribute.
	 * @see #isSetSurname()
	 * @see #unsetSurname()
	 * @see #getSurname()
	 * @generated
	 */
  void setSurname(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.family.Family#getSurname <em>Surname</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSurname()
	 * @see #getSurname()
	 * @see #setSurname(String)
	 * @generated
	 */
  void unsetSurname();

  /**
	 * Returns whether the value of the '{@link org.genivi.family.Family#getSurname <em>Surname</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Surname</em>' attribute is set.
	 * @see #unsetSurname()
	 * @see #getSurname()
	 * @see #setSurname(String)
	 * @generated
	 */
  boolean isSetSurname();

  /**
	 * Returns the value of the '<em><b>Number Of Pets</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number Of Pets</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Pets</em>' attribute.
	 * @see #isSetNumberOfPets()
	 * @see #unsetNumberOfPets()
	 * @see #setNumberOfPets(int)
	 * @see org.genivi.family.FamilyPackage#getFamily_NumberOfPets()
	 * @model unsettable="true"
	 * @generated
	 */
  int getNumberOfPets();

  /**
	 * Sets the value of the '{@link org.genivi.family.Family#getNumberOfPets <em>Number Of Pets</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Pets</em>' attribute.
	 * @see #isSetNumberOfPets()
	 * @see #unsetNumberOfPets()
	 * @see #getNumberOfPets()
	 * @generated
	 */
  void setNumberOfPets(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.family.Family#getNumberOfPets <em>Number Of Pets</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetNumberOfPets()
	 * @see #getNumberOfPets()
	 * @see #setNumberOfPets(int)
	 * @generated
	 */
  void unsetNumberOfPets();

  /**
	 * Returns whether the value of the '{@link org.genivi.family.Family#getNumberOfPets <em>Number Of Pets</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Of Pets</em>' attribute is set.
	 * @see #unsetNumberOfPets()
	 * @see #getNumberOfPets()
	 * @see #setNumberOfPets(int)
	 * @generated
	 */
  boolean isSetNumberOfPets();

  /**
	 * Returns the value of the '<em><b>Has ASwimming Pool</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has ASwimming Pool</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Has ASwimming Pool</em>' attribute.
	 * @see #isSetHasASwimmingPool()
	 * @see #unsetHasASwimmingPool()
	 * @see #setHasASwimmingPool(boolean)
	 * @see org.genivi.family.FamilyPackage#getFamily_HasASwimmingPool()
	 * @model unsettable="true"
	 * @generated
	 */
  boolean isHasASwimmingPool();

  /**
	 * Sets the value of the '{@link org.genivi.family.Family#isHasASwimmingPool <em>Has ASwimming Pool</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has ASwimming Pool</em>' attribute.
	 * @see #isSetHasASwimmingPool()
	 * @see #unsetHasASwimmingPool()
	 * @see #isHasASwimmingPool()
	 * @generated
	 */
  void setHasASwimmingPool(boolean value);

  /**
	 * Unsets the value of the '{@link org.genivi.family.Family#isHasASwimmingPool <em>Has ASwimming Pool</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetHasASwimmingPool()
	 * @see #isHasASwimmingPool()
	 * @see #setHasASwimmingPool(boolean)
	 * @generated
	 */
  void unsetHasASwimmingPool();

  /**
	 * Returns whether the value of the '{@link org.genivi.family.Family#isHasASwimmingPool <em>Has ASwimming Pool</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has ASwimming Pool</em>' attribute is set.
	 * @see #unsetHasASwimmingPool()
	 * @see #isHasASwimmingPool()
	 * @see #setHasASwimmingPool(boolean)
	 * @generated
	 */
  boolean isSetHasASwimmingPool();

  /**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Address</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #isSetAddress()
	 * @see #unsetAddress()
	 * @see #setAddress(Address)
	 * @see org.genivi.family.FamilyPackage#getFamily_Address()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  Address getAddress();

  /**
	 * Sets the value of the '{@link org.genivi.family.Family#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #isSetAddress()
	 * @see #unsetAddress()
	 * @see #getAddress()
	 * @generated
	 */
  void setAddress(Address value);

  /**
	 * Unsets the value of the '{@link org.genivi.family.Family#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAddress()
	 * @see #getAddress()
	 * @see #setAddress(Address)
	 * @generated
	 */
  void unsetAddress();

  /**
	 * Returns whether the value of the '{@link org.genivi.family.Family#getAddress <em>Address</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Address</em>' containment reference is set.
	 * @see #unsetAddress()
	 * @see #getAddress()
	 * @see #setAddress(Address)
	 * @generated
	 */
  boolean isSetAddress();

  /**
	 * Returns the value of the '<em><b>Favorite Holiday Destinations</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Favorite Holiday Destinations</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Favorite Holiday Destinations</em>' attribute list.
	 * @see org.genivi.family.FamilyPackage#getFamily_FavoriteHolidayDestinations()
	 * @model
	 * @generated
	 */
  EList<String> getFavoriteHolidayDestinations();

} // Family
