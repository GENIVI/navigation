/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.location.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.genivi.common.CommonPackage;
import org.genivi.common.impl.CommonPackageImpl;
import org.genivi.location.AreaLocation;
import org.genivi.location.AreaLocationInfo;
import org.genivi.location.LinearLocation;
import org.genivi.location.LinearLocationInfo;
import org.genivi.location.Location;
import org.genivi.location.LocationFactory;
import org.genivi.location.LocationInfo;
import org.genivi.location.LocationPackage;
import org.genivi.location.PointLocation;
import org.genivi.location.PointLocationInfo;
import org.genivi.location.PointLocationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LocationPackageImpl extends EPackageImpl implements LocationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass locationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass areaLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass locationInfoEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass pointLocationInfoEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass linearLocationInfoEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass areaLocationInfoEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum pointLocationTypeEEnum = null;

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
	 * @see org.genivi.location.LocationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LocationPackageImpl() {
		super(eNS_URI, LocationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LocationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LocationPackage init() {
		if (isInited) return (LocationPackage)EPackage.Registry.INSTANCE.getEPackage(LocationPackage.eNS_URI);

		// Obtain or create and register package
		LocationPackageImpl theLocationPackage = (LocationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LocationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LocationPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CommonPackageImpl theCommonPackage = (CommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI) : CommonPackage.eINSTANCE);

		// Create package meta-data objects
		theLocationPackage.createPackageContents();
		theCommonPackage.createPackageContents();

		// Initialize created meta-data
		theLocationPackage.initializePackageContents();
		theCommonPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLocationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LocationPackage.eNS_URI, theLocationPackage);
		return theLocationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocation() {
		return locationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPointLocation() {
		return pointLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAreaLocation() {
		return areaLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinearLocation() {
		return linearLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinearLocation_Segments() {
		return (EAttribute)linearLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLinearLocation_PositiveOffset() {
		return (EAttribute)linearLocationEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLinearLocation_NegativeOffset() {
		return (EAttribute)linearLocationEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getLocationInfo() {
		return locationInfoEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLocationInfo_Name() {
		return (EAttribute)locationInfoEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getLocationInfo_MainLocation() {
		return (EReference)locationInfoEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPointLocationInfo() {
		return pointLocationInfoEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPointLocationInfo_LocationType() {
		return (EAttribute)pointLocationInfoEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getLinearLocationInfo() {
		return linearLocationInfoEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLinearLocationInfo_FromLocationName() {
		return (EAttribute)linearLocationInfoEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLinearLocationInfo_FromLocationParentName() {
		return (EAttribute)linearLocationInfoEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLinearLocationInfo_ToLocationName() {
		return (EAttribute)linearLocationInfoEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLinearLocationInfo_ToLocationParentName() {
		return (EAttribute)linearLocationInfoEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getLinearLocationInfo_Coordinates() {
		return (EReference)linearLocationInfoEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getAreaLocationInfo() {
		return areaLocationInfoEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getPointLocationType() {
		return pointLocationTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationFactory getLocationFactory() {
		return (LocationFactory)getEFactoryInstance();
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
		locationEClass = createEClass(LOCATION);

		pointLocationEClass = createEClass(POINT_LOCATION);

		areaLocationEClass = createEClass(AREA_LOCATION);

		linearLocationEClass = createEClass(LINEAR_LOCATION);
		createEAttribute(linearLocationEClass, LINEAR_LOCATION__SEGMENTS);
		createEAttribute(linearLocationEClass, LINEAR_LOCATION__POSITIVE_OFFSET);
		createEAttribute(linearLocationEClass, LINEAR_LOCATION__NEGATIVE_OFFSET);

		locationInfoEClass = createEClass(LOCATION_INFO);
		createEAttribute(locationInfoEClass, LOCATION_INFO__NAME);
		createEReference(locationInfoEClass, LOCATION_INFO__MAIN_LOCATION);

		pointLocationInfoEClass = createEClass(POINT_LOCATION_INFO);
		createEAttribute(pointLocationInfoEClass, POINT_LOCATION_INFO__LOCATION_TYPE);

		linearLocationInfoEClass = createEClass(LINEAR_LOCATION_INFO);
		createEAttribute(linearLocationInfoEClass, LINEAR_LOCATION_INFO__FROM_LOCATION_NAME);
		createEAttribute(linearLocationInfoEClass, LINEAR_LOCATION_INFO__FROM_LOCATION_PARENT_NAME);
		createEAttribute(linearLocationInfoEClass, LINEAR_LOCATION_INFO__TO_LOCATION_NAME);
		createEAttribute(linearLocationInfoEClass, LINEAR_LOCATION_INFO__TO_LOCATION_PARENT_NAME);
		createEReference(linearLocationInfoEClass, LINEAR_LOCATION_INFO__COORDINATES);

		areaLocationInfoEClass = createEClass(AREA_LOCATION_INFO);

		// Create enums
		pointLocationTypeEEnum = createEEnum(POINT_LOCATION_TYPE);
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
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pointLocationEClass.getESuperTypes().add(this.getLocation());
		areaLocationEClass.getESuperTypes().add(this.getLocation());
		linearLocationEClass.getESuperTypes().add(this.getLocation());
		pointLocationInfoEClass.getESuperTypes().add(this.getLocationInfo());
		linearLocationInfoEClass.getESuperTypes().add(this.getLocationInfo());
		areaLocationInfoEClass.getESuperTypes().add(this.getLocationInfo());

		// Initialize classes and features; add operations and parameters
		initEClass(locationEClass, Location.class, "Location", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pointLocationEClass, PointLocation.class, "PointLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(areaLocationEClass, AreaLocation.class, "AreaLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linearLocationEClass, LinearLocation.class, "LinearLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinearLocation_Segments(), ecorePackage.getELong(), "segments", null, 1, -1, LinearLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinearLocation_PositiveOffset(), ecorePackage.getELong(), "positiveOffset", null, 0, 1, LinearLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinearLocation_NegativeOffset(), ecorePackage.getELong(), "negativeOffset", null, 0, 1, LinearLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(locationInfoEClass, LocationInfo.class, "LocationInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocationInfo_Name(), ecorePackage.getEString(), "name", null, 0, 1, LocationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocationInfo_MainLocation(), theCommonPackage.getCoordinate(), null, "mainLocation", null, 0, 1, LocationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointLocationInfoEClass, PointLocationInfo.class, "PointLocationInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPointLocationInfo_LocationType(), this.getPointLocationType(), "locationType", null, 0, 1, PointLocationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linearLocationInfoEClass, LinearLocationInfo.class, "LinearLocationInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinearLocationInfo_FromLocationName(), ecorePackage.getEString(), "fromLocationName", null, 0, 1, LinearLocationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinearLocationInfo_FromLocationParentName(), ecorePackage.getEString(), "fromLocationParentName", null, 0, 1, LinearLocationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinearLocationInfo_ToLocationName(), ecorePackage.getEString(), "toLocationName", null, 0, 1, LinearLocationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinearLocationInfo_ToLocationParentName(), ecorePackage.getEString(), "toLocationParentName", null, 0, 1, LinearLocationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLinearLocationInfo_Coordinates(), theCommonPackage.getCoordinate(), null, "coordinates", null, 0, -1, LinearLocationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(areaLocationInfoEClass, AreaLocationInfo.class, "AreaLocationInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(pointLocationTypeEEnum, PointLocationType.class, "PointLocationType");
		addEEnumLiteral(pointLocationTypeEEnum, PointLocationType.MOTORWAY_EXIT);
		addEEnumLiteral(pointLocationTypeEEnum, PointLocationType.MOTORWAY_TRIANGLE);
		addEEnumLiteral(pointLocationTypeEEnum, PointLocationType.MOTORWAY_CROSSING);
		addEEnumLiteral(pointLocationTypeEEnum, PointLocationType.MOTORWAY_ENTRY);

		// Create resource
		createResource(eNS_URI);
	}

} //LocationPackageImpl
