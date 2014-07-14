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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.genivi.family.FamilyFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface FamilyPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "family";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://org.genivi.family";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "family";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  FamilyPackage eINSTANCE = org.genivi.family.impl.FamilyPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.genivi.family.impl.FamilyImpl <em>Family</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.family.impl.FamilyImpl
	 * @see org.genivi.family.impl.FamilyPackageImpl#getFamily()
	 * @generated
	 */
  int FAMILY = 0;

  /**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FAMILY__MEMBERS = 0;

  /**
	 * The feature id for the '<em><b>Surname</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FAMILY__SURNAME = 1;

  /**
	 * The feature id for the '<em><b>Number Of Pets</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FAMILY__NUMBER_OF_PETS = 2;

  /**
	 * The feature id for the '<em><b>Has ASwimming Pool</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FAMILY__HAS_ASWIMMING_POOL = 3;

  /**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FAMILY__ADDRESS = 4;

  /**
	 * The feature id for the '<em><b>Favorite Holiday Destinations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FAMILY__FAVORITE_HOLIDAY_DESTINATIONS = 5;

  /**
	 * The number of structural features of the '<em>Family</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FAMILY_FEATURE_COUNT = 6;

  /**
	 * The meta object id for the '{@link org.genivi.family.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.family.impl.PersonImpl
	 * @see org.genivi.family.impl.FamilyPackageImpl#getPerson()
	 * @generated
	 */
  int PERSON = 1;

  /**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PERSON__FIRST_NAME = 0;

  /**
	 * The feature id for the '<em><b>Sexe</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PERSON__SEXE = 1;

  /**
	 * The feature id for the '<em><b>Owned Cars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PERSON__OWNED_CARS = 2;

  /**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PERSON_FEATURE_COUNT = 3;

  /**
	 * The meta object id for the '{@link org.genivi.family.impl.CarImpl <em>Car</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.family.impl.CarImpl
	 * @see org.genivi.family.impl.FamilyPackageImpl#getCar()
	 * @generated
	 */
  int CAR = 2;

  /**
	 * The feature id for the '<em><b>Number Of Seats</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CAR__NUMBER_OF_SEATS = 0;

  /**
	 * The number of structural features of the '<em>Car</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CAR_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link org.genivi.family.impl.AddressImpl <em>Address</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.family.impl.AddressImpl
	 * @see org.genivi.family.impl.FamilyPackageImpl#getAddress()
	 * @generated
	 */
  int ADDRESS = 3;

  /**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADDRESS__STREET = 0;

  /**
	 * The number of structural features of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADDRESS_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link org.genivi.family.impl.WealthyFamilyImpl <em>Wealthy Family</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.family.impl.WealthyFamilyImpl
	 * @see org.genivi.family.impl.FamilyPackageImpl#getWealthyFamily()
	 * @generated
	 */
  int WEALTHY_FAMILY = 4;

  /**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int WEALTHY_FAMILY__MEMBERS = FAMILY__MEMBERS;

  /**
	 * The feature id for the '<em><b>Surname</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int WEALTHY_FAMILY__SURNAME = FAMILY__SURNAME;

  /**
	 * The feature id for the '<em><b>Number Of Pets</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int WEALTHY_FAMILY__NUMBER_OF_PETS = FAMILY__NUMBER_OF_PETS;

  /**
	 * The feature id for the '<em><b>Has ASwimming Pool</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int WEALTHY_FAMILY__HAS_ASWIMMING_POOL = FAMILY__HAS_ASWIMMING_POOL;

  /**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int WEALTHY_FAMILY__ADDRESS = FAMILY__ADDRESS;

  /**
	 * The feature id for the '<em><b>Favorite Holiday Destinations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int WEALTHY_FAMILY__FAVORITE_HOLIDAY_DESTINATIONS = FAMILY__FAVORITE_HOLIDAY_DESTINATIONS;

  /**
	 * The feature id for the '<em><b>Forbes Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int WEALTHY_FAMILY__FORBES_RANKING = FAMILY_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Wealthy Family</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int WEALTHY_FAMILY_FEATURE_COUNT = FAMILY_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.genivi.family.Sexe <em>Sexe</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.family.Sexe
	 * @see org.genivi.family.impl.FamilyPackageImpl#getSexe()
	 * @generated
	 */
  int SEXE = 5;


  /**
	 * Returns the meta object for class '{@link org.genivi.family.Family <em>Family</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Family</em>'.
	 * @see org.genivi.family.Family
	 * @generated
	 */
  EClass getFamily();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.family.Family#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.genivi.family.Family#getMembers()
	 * @see #getFamily()
	 * @generated
	 */
  EReference getFamily_Members();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.family.Family#getSurname <em>Surname</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Surname</em>'.
	 * @see org.genivi.family.Family#getSurname()
	 * @see #getFamily()
	 * @generated
	 */
  EAttribute getFamily_Surname();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.family.Family#getNumberOfPets <em>Number Of Pets</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Pets</em>'.
	 * @see org.genivi.family.Family#getNumberOfPets()
	 * @see #getFamily()
	 * @generated
	 */
  EAttribute getFamily_NumberOfPets();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.family.Family#isHasASwimmingPool <em>Has ASwimming Pool</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has ASwimming Pool</em>'.
	 * @see org.genivi.family.Family#isHasASwimmingPool()
	 * @see #getFamily()
	 * @generated
	 */
  EAttribute getFamily_HasASwimmingPool();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.family.Family#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see org.genivi.family.Family#getAddress()
	 * @see #getFamily()
	 * @generated
	 */
  EReference getFamily_Address();

  /**
	 * Returns the meta object for the attribute list '{@link org.genivi.family.Family#getFavoriteHolidayDestinations <em>Favorite Holiday Destinations</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Favorite Holiday Destinations</em>'.
	 * @see org.genivi.family.Family#getFavoriteHolidayDestinations()
	 * @see #getFamily()
	 * @generated
	 */
  EAttribute getFamily_FavoriteHolidayDestinations();

  /**
	 * Returns the meta object for class '{@link org.genivi.family.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see org.genivi.family.Person
	 * @generated
	 */
  EClass getPerson();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.family.Person#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.genivi.family.Person#getFirstName()
	 * @see #getPerson()
	 * @generated
	 */
  EAttribute getPerson_FirstName();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.family.Person#getSexe <em>Sexe</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sexe</em>'.
	 * @see org.genivi.family.Person#getSexe()
	 * @see #getPerson()
	 * @generated
	 */
  EAttribute getPerson_Sexe();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.family.Person#getOwnedCars <em>Owned Cars</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Cars</em>'.
	 * @see org.genivi.family.Person#getOwnedCars()
	 * @see #getPerson()
	 * @generated
	 */
  EReference getPerson_OwnedCars();

  /**
	 * Returns the meta object for class '{@link org.genivi.family.Car <em>Car</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Car</em>'.
	 * @see org.genivi.family.Car
	 * @generated
	 */
  EClass getCar();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.family.Car#getNumberOfSeats <em>Number Of Seats</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Seats</em>'.
	 * @see org.genivi.family.Car#getNumberOfSeats()
	 * @see #getCar()
	 * @generated
	 */
  EAttribute getCar_NumberOfSeats();

  /**
	 * Returns the meta object for class '{@link org.genivi.family.Address <em>Address</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address</em>'.
	 * @see org.genivi.family.Address
	 * @generated
	 */
  EClass getAddress();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.family.Address#getStreet <em>Street</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Street</em>'.
	 * @see org.genivi.family.Address#getStreet()
	 * @see #getAddress()
	 * @generated
	 */
  EAttribute getAddress_Street();

  /**
	 * Returns the meta object for class '{@link org.genivi.family.WealthyFamily <em>Wealthy Family</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wealthy Family</em>'.
	 * @see org.genivi.family.WealthyFamily
	 * @generated
	 */
  EClass getWealthyFamily();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.family.WealthyFamily#getForbesRanking <em>Forbes Ranking</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Forbes Ranking</em>'.
	 * @see org.genivi.family.WealthyFamily#getForbesRanking()
	 * @see #getWealthyFamily()
	 * @generated
	 */
  EAttribute getWealthyFamily_ForbesRanking();

  /**
	 * Returns the meta object for enum '{@link org.genivi.family.Sexe <em>Sexe</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sexe</em>'.
	 * @see org.genivi.family.Sexe
	 * @generated
	 */
  EEnum getSexe();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  FamilyFactory getFamilyFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals {
    /**
		 * The meta object literal for the '{@link org.genivi.family.impl.FamilyImpl <em>Family</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.family.impl.FamilyImpl
		 * @see org.genivi.family.impl.FamilyPackageImpl#getFamily()
		 * @generated
		 */
    EClass FAMILY = eINSTANCE.getFamily();

    /**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference FAMILY__MEMBERS = eINSTANCE.getFamily_Members();

    /**
		 * The meta object literal for the '<em><b>Surname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute FAMILY__SURNAME = eINSTANCE.getFamily_Surname();

    /**
		 * The meta object literal for the '<em><b>Number Of Pets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute FAMILY__NUMBER_OF_PETS = eINSTANCE.getFamily_NumberOfPets();

    /**
		 * The meta object literal for the '<em><b>Has ASwimming Pool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute FAMILY__HAS_ASWIMMING_POOL = eINSTANCE.getFamily_HasASwimmingPool();

    /**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference FAMILY__ADDRESS = eINSTANCE.getFamily_Address();

    /**
		 * The meta object literal for the '<em><b>Favorite Holiday Destinations</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute FAMILY__FAVORITE_HOLIDAY_DESTINATIONS = eINSTANCE.getFamily_FavoriteHolidayDestinations();

    /**
		 * The meta object literal for the '{@link org.genivi.family.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.family.impl.PersonImpl
		 * @see org.genivi.family.impl.FamilyPackageImpl#getPerson()
		 * @generated
		 */
    EClass PERSON = eINSTANCE.getPerson();

    /**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PERSON__FIRST_NAME = eINSTANCE.getPerson_FirstName();

    /**
		 * The meta object literal for the '<em><b>Sexe</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PERSON__SEXE = eINSTANCE.getPerson_Sexe();

    /**
		 * The meta object literal for the '<em><b>Owned Cars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference PERSON__OWNED_CARS = eINSTANCE.getPerson_OwnedCars();

    /**
		 * The meta object literal for the '{@link org.genivi.family.impl.CarImpl <em>Car</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.family.impl.CarImpl
		 * @see org.genivi.family.impl.FamilyPackageImpl#getCar()
		 * @generated
		 */
    EClass CAR = eINSTANCE.getCar();

    /**
		 * The meta object literal for the '<em><b>Number Of Seats</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CAR__NUMBER_OF_SEATS = eINSTANCE.getCar_NumberOfSeats();

    /**
		 * The meta object literal for the '{@link org.genivi.family.impl.AddressImpl <em>Address</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.family.impl.AddressImpl
		 * @see org.genivi.family.impl.FamilyPackageImpl#getAddress()
		 * @generated
		 */
    EClass ADDRESS = eINSTANCE.getAddress();

    /**
		 * The meta object literal for the '<em><b>Street</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ADDRESS__STREET = eINSTANCE.getAddress_Street();

    /**
		 * The meta object literal for the '{@link org.genivi.family.impl.WealthyFamilyImpl <em>Wealthy Family</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.family.impl.WealthyFamilyImpl
		 * @see org.genivi.family.impl.FamilyPackageImpl#getWealthyFamily()
		 * @generated
		 */
    EClass WEALTHY_FAMILY = eINSTANCE.getWealthyFamily();

    /**
		 * The meta object literal for the '<em><b>Forbes Ranking</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute WEALTHY_FAMILY__FORBES_RANKING = eINSTANCE.getWealthyFamily_ForbesRanking();

    /**
		 * The meta object literal for the '{@link org.genivi.family.Sexe <em>Sexe</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.family.Sexe
		 * @see org.genivi.family.impl.FamilyPackageImpl#getSexe()
		 * @generated
		 */
    EEnum SEXE = eINSTANCE.getSexe();

  }

} //FamilyPackage
