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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.family.FamilyPackage
 * @generated
 */
public interface FamilyFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  FamilyFactory eINSTANCE = org.genivi.family.impl.FamilyFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Family</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Family</em>'.
	 * @generated
	 */
  Family createFamily();

  /**
	 * Returns a new object of class '<em>Person</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Person</em>'.
	 * @generated
	 */
  Person createPerson();

  /**
	 * Returns a new object of class '<em>Car</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Car</em>'.
	 * @generated
	 */
  Car createCar();

  /**
	 * Returns a new object of class '<em>Address</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address</em>'.
	 * @generated
	 */
  Address createAddress();

  /**
	 * Returns a new object of class '<em>Wealthy Family</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wealthy Family</em>'.
	 * @generated
	 */
  WealthyFamily createWealthyFamily();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  FamilyPackage getFamilyPackage();

} //FamilyFactory
