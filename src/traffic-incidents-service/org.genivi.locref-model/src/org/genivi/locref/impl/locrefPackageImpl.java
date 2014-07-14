/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.locref.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genivi.common.CommonPackage;

import org.genivi.location.LocationPackage;

import org.genivi.locref.LocationReference;
import org.genivi.locref.LocationReferenceDecodingService;
import org.genivi.locref.LocationReferenceDecodingServiceListener;
import org.genivi.locref.LocationReferenceType;
import org.genivi.locref.locrefFactory;
import org.genivi.locref.locrefPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class locrefPackageImpl extends EPackageImpl implements locrefPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass locationReferenceEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass locationReferenceDecodingServiceEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass locationReferenceDecodingServiceListenerEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum locationReferenceTypeEEnum = null;

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
	 * @see org.genivi.locref.locrefPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private locrefPackageImpl() {
		super(eNS_URI, locrefFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link locrefPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static locrefPackage init() {
		if (isInited) return (locrefPackage)EPackage.Registry.INSTANCE.getEPackage(locrefPackage.eNS_URI);

		// Obtain or create and register package
		locrefPackageImpl thelocrefPackage = (locrefPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof locrefPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new locrefPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		LocationPackage.eINSTANCE.eClass();
		CommonPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thelocrefPackage.createPackageContents();

		// Initialize created meta-data
		thelocrefPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thelocrefPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(locrefPackage.eNS_URI, thelocrefPackage);
		return thelocrefPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getLocationReference() {
		return locationReferenceEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLocationReference_Data() {
		return (EAttribute)locationReferenceEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLocationReference_LocationReferenceType() {
		return (EAttribute)locationReferenceEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getLocationReferenceDecodingService() {
		return locationReferenceDecodingServiceEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getLocationReferenceDecodingServiceListener() {
		return locationReferenceDecodingServiceListenerEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getLocationReferenceType() {
		return locationReferenceTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public locrefFactory getlocrefFactory() {
		return (locrefFactory)getEFactoryInstance();
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
		locationReferenceEClass = createEClass(LOCATION_REFERENCE);
		createEAttribute(locationReferenceEClass, LOCATION_REFERENCE__DATA);
		createEAttribute(locationReferenceEClass, LOCATION_REFERENCE__LOCATION_REFERENCE_TYPE);

		locationReferenceDecodingServiceEClass = createEClass(LOCATION_REFERENCE_DECODING_SERVICE);

		locationReferenceDecodingServiceListenerEClass = createEClass(LOCATION_REFERENCE_DECODING_SERVICE_LISTENER);

		// Create enums
		locationReferenceTypeEEnum = createEEnum(LOCATION_REFERENCE_TYPE);
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

		// Obtain other dependent packages
		LocationPackage theLocationPackage = (LocationPackage)EPackage.Registry.INSTANCE.getEPackage(LocationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(locationReferenceEClass, LocationReference.class, "LocationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocationReference_Data(), ecorePackage.getEJavaObject(), "data", null, 1, 1, LocationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocationReference_LocationReferenceType(), ecorePackage.getEByte(), "locationReferenceType", null, 1, 1, LocationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(locationReferenceDecodingServiceEClass, LocationReferenceDecodingService.class, "LocationReferenceDecodingService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(locationReferenceDecodingServiceEClass, null, "decode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLocationReferenceDecodingServiceListener(), "listener", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLocationReference(), "locationReference", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(locationReferenceDecodingServiceEClass, null, "setLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "languageCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "countryCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(locationReferenceDecodingServiceEClass, null, "getLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLocationReferenceDecodingServiceListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(locationReferenceDecodingServiceListenerEClass, LocationReferenceDecodingServiceListener.class, "LocationReferenceDecodingServiceListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(locationReferenceDecodingServiceListenerEClass, null, "decodeReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theLocationPackage.getLocation(), "location", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theLocationPackage.getLocationInfo(), "locationInfo", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(locationReferenceDecodingServiceListenerEClass, null, "getLanguageReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "languageCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "countryCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(locationReferenceTypeEEnum, LocationReferenceType.class, "LocationReferenceType");
		addEEnumLiteral(locationReferenceTypeEEnum, LocationReferenceType.TMC_LOC);
		addEEnumLiteral(locationReferenceTypeEEnum, LocationReferenceType.OPEN_LR);

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

} //locrefPackageImpl
