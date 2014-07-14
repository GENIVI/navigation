/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.common.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genivi.common.CommonFactory;
import org.genivi.common.CommonPackage;
import org.genivi.common.Coordinate;
import org.genivi.common.LocalizedString;
import org.genivi.common.RectangularArea;

import org.genivi.common.Version;
import org.genivi.location.LocationPackage;

import org.genivi.location.impl.LocationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonPackageImpl extends EPackageImpl implements CommonPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coordinateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rectangularAreaEClass = null;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass versionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass localizedStringEClass = null;

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
	 * @see org.genivi.common.CommonPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CommonPackageImpl() {
		super(eNS_URI, CommonFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CommonPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CommonPackage init() {
		if (isInited) return (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Obtain or create and register package
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CommonPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		LocationPackageImpl theLocationPackage = (LocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LocationPackage.eNS_URI) instanceof LocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LocationPackage.eNS_URI) : LocationPackage.eINSTANCE);

		// Create package meta-data objects
		theCommonPackage.createPackageContents();
		theLocationPackage.createPackageContents();

		// Initialize created meta-data
		theCommonPackage.initializePackageContents();
		theLocationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommonPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CommonPackage.eNS_URI, theCommonPackage);
		return theCommonPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoordinate() {
		return coordinateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCoordinate_Latitude() {
		return (EAttribute)coordinateEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCoordinate_Longitude() {
		return (EAttribute)coordinateEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCoordinate_Altitude() {
		return (EAttribute)coordinateEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRectangularArea() {
		return rectangularAreaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRectangularArea_BottomLeft() {
		return (EReference)rectangularAreaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRectangularArea_TopRight() {
		return (EReference)rectangularAreaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getVersion() {
		return versionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVersion_Major() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVersion_Minor() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVersion_Micro() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVersion_Date() {
		return (EAttribute)versionEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getLocalizedString() {
		return localizedStringEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLocalizedString_LanguageCode() {
		return (EAttribute)localizedStringEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLocalizedString_CountryCode() {
		return (EAttribute)localizedStringEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLocalizedString_String() {
		return (EAttribute)localizedStringEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonFactory getCommonFactory() {
		return (CommonFactory)getEFactoryInstance();
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
		coordinateEClass = createEClass(COORDINATE);
		createEAttribute(coordinateEClass, COORDINATE__LATITUDE);
		createEAttribute(coordinateEClass, COORDINATE__LONGITUDE);
		createEAttribute(coordinateEClass, COORDINATE__ALTITUDE);

		rectangularAreaEClass = createEClass(RECTANGULAR_AREA);
		createEReference(rectangularAreaEClass, RECTANGULAR_AREA__BOTTOM_LEFT);
		createEReference(rectangularAreaEClass, RECTANGULAR_AREA__TOP_RIGHT);

		versionEClass = createEClass(VERSION);
		createEAttribute(versionEClass, VERSION__MAJOR);
		createEAttribute(versionEClass, VERSION__MINOR);
		createEAttribute(versionEClass, VERSION__MICRO);
		createEAttribute(versionEClass, VERSION__DATE);

		localizedStringEClass = createEClass(LOCALIZED_STRING);
		createEAttribute(localizedStringEClass, LOCALIZED_STRING__LANGUAGE_CODE);
		createEAttribute(localizedStringEClass, LOCALIZED_STRING__COUNTRY_CODE);
		createEAttribute(localizedStringEClass, LOCALIZED_STRING__STRING);
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

		// Initialize classes and features; add operations and parameters
		initEClass(coordinateEClass, Coordinate.class, "Coordinate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCoordinate_Latitude(), ecorePackage.getEDouble(), "latitude", null, 1, 1, Coordinate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoordinate_Longitude(), ecorePackage.getEDouble(), "longitude", null, 1, 1, Coordinate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoordinate_Altitude(), ecorePackage.getEInt(), "altitude", null, 0, 1, Coordinate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rectangularAreaEClass, RectangularArea.class, "RectangularArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRectangularArea_BottomLeft(), this.getCoordinate(), null, "bottomLeft", null, 1, 1, RectangularArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRectangularArea_TopRight(), this.getCoordinate(), null, "topRight", null, 1, 1, RectangularArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionEClass, Version.class, "Version", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersion_Major(), ecorePackage.getEInt(), "major", null, 1, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Minor(), ecorePackage.getEInt(), "minor", null, 1, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Micro(), ecorePackage.getEInt(), "micro", null, 1, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Date(), ecorePackage.getEString(), "date", null, 1, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localizedStringEClass, LocalizedString.class, "LocalizedString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalizedString_LanguageCode(), ecorePackage.getEString(), "languageCode", null, 1, 1, LocalizedString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalizedString_CountryCode(), ecorePackage.getEString(), "countryCode", null, 0, 1, LocalizedString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalizedString_String(), ecorePackage.getEString(), "string", null, 1, 1, LocalizedString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.tomtom.com/emfidl/2012/GenModel
		createGenModel_1Annotations();
	}

  /**
	 * Initializes the annotations for <b>http://www.tomtom.com/emfidl/2012/GenModel</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createGenModel_1Annotations() {
		String source = "http://www.tomtom.com/emfidl/2012/GenModel";											
		addAnnotation
		  (getVersion_Major(), 
		   source, 
		   new String[] {
			 "valueMin", "0",
			 "valueMax", "32767"
		   });			
		addAnnotation
		  (getVersion_Minor(), 
		   source, 
		   new String[] {
			 "valueMin", "0",
			 "valueMax", "32767"
		   });			
		addAnnotation
		  (getVersion_Micro(), 
		   source, 
		   new String[] {
			 "valueMin", "0",
			 "valueMax", "32767"
		   });	
	}

} //CommonPackageImpl
