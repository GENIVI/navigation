/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.family.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genivi.family.Address;
import org.genivi.family.Car;
import org.genivi.family.Family;
import org.genivi.family.FamilyFactory;
import org.genivi.family.FamilyPackage;
import org.genivi.family.Person;
import org.genivi.family.Sexe;
import org.genivi.family.WealthyFamily;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FamilyPackageImpl extends EPackageImpl implements FamilyPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass familyEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass personEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass carEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass addressEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass wealthyFamilyEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum sexeEEnum = null;

  /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.genivi.family.FamilyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private FamilyPackageImpl() {
		super(eNS_URI, FamilyFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FamilyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static FamilyPackage init() {
		if (isInited) return (FamilyPackage)EPackage.Registry.INSTANCE.getEPackage(FamilyPackage.eNS_URI);

		// Obtain or create and register package
		FamilyPackageImpl theFamilyPackage = (FamilyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FamilyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FamilyPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFamilyPackage.createPackageContents();

		// Initialize created meta-data
		theFamilyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFamilyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FamilyPackage.eNS_URI, theFamilyPackage);
		return theFamilyPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getFamily() {
		return familyEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getFamily_Members() {
		return (EReference)familyEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getFamily_Surname() {
		return (EAttribute)familyEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getFamily_NumberOfPets() {
		return (EAttribute)familyEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getFamily_HasASwimmingPool() {
		return (EAttribute)familyEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getFamily_Address() {
		return (EReference)familyEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getFamily_FavoriteHolidayDestinations() {
		return (EAttribute)familyEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPerson() {
		return personEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPerson_FirstName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPerson_Sexe() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPerson_OwnedCars() {
		return (EReference)personEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getCar() {
		return carEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCar_NumberOfSeats() {
		return (EAttribute)carEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getAddress() {
		return addressEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getAddress_Street() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getWealthyFamily() {
		return wealthyFamilyEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getWealthyFamily_ForbesRanking() {
		return (EAttribute)wealthyFamilyEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getSexe() {
		return sexeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FamilyFactory getFamilyFactory() {
		return (FamilyFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		familyEClass = createEClass(FAMILY);
		createEReference(familyEClass, FAMILY__MEMBERS);
		createEAttribute(familyEClass, FAMILY__SURNAME);
		createEAttribute(familyEClass, FAMILY__NUMBER_OF_PETS);
		createEAttribute(familyEClass, FAMILY__HAS_ASWIMMING_POOL);
		createEReference(familyEClass, FAMILY__ADDRESS);
		createEAttribute(familyEClass, FAMILY__FAVORITE_HOLIDAY_DESTINATIONS);

		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__FIRST_NAME);
		createEAttribute(personEClass, PERSON__SEXE);
		createEReference(personEClass, PERSON__OWNED_CARS);

		carEClass = createEClass(CAR);
		createEAttribute(carEClass, CAR__NUMBER_OF_SEATS);

		addressEClass = createEClass(ADDRESS);
		createEAttribute(addressEClass, ADDRESS__STREET);

		wealthyFamilyEClass = createEClass(WEALTHY_FAMILY);
		createEAttribute(wealthyFamilyEClass, WEALTHY_FAMILY__FORBES_RANKING);

		// Create enums
		sexeEEnum = createEEnum(SEXE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		wealthyFamilyEClass.getESuperTypes().add(this.getFamily());

		// Initialize classes and features; add operations and parameters
		initEClass(familyEClass, Family.class, "Family", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFamily_Members(), this.getPerson(), null, "members", null, 1, -1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFamily_Surname(), ecorePackage.getEString(), "surname", null, 1, 1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFamily_NumberOfPets(), ecorePackage.getEInt(), "numberOfPets", null, 0, 1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFamily_HasASwimmingPool(), ecorePackage.getEBoolean(), "hasASwimmingPool", null, 0, 1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFamily_Address(), this.getAddress(), null, "address", null, 0, 1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFamily_FavoriteHolidayDestinations(), ecorePackage.getEString(), "favoriteHolidayDestinations", null, 0, -1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_FirstName(), ecorePackage.getEString(), "firstName", null, 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Sexe(), this.getSexe(), "sexe", null, 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_OwnedCars(), this.getCar(), null, "ownedCars", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(carEClass, Car.class, "Car", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCar_NumberOfSeats(), ecorePackage.getEIntegerObject(), "numberOfSeats", null, 0, 1, Car.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addressEClass, Address.class, "Address", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddress_Street(), ecorePackage.getEString(), "street", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wealthyFamilyEClass, WealthyFamily.class, "WealthyFamily", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWealthyFamily_ForbesRanking(), ecorePackage.getEInt(), "forbesRanking", null, 0, 1, WealthyFamily.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sexeEEnum, Sexe.class, "Sexe");
		addEEnumLiteral(sexeEEnum, Sexe.MALE);
		addEEnumLiteral(sexeEEnum, Sexe.FEMALE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// GenModel
		createGenModelAnnotations();
	}

  /**
	 * Initializes the annotations for <b>GenModel</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createGenModelAnnotations() {
		String source = "GenModel";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "documentation", "Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/."
		   });
	}

} //FamilyPackageImpl
