/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.location;

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
 * @see org.genivi.location.LocationFactory
 * @model kind="package"
 * @generated
 */
public interface LocationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "location";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.genivi.location";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "common";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LocationPackage eINSTANCE = org.genivi.location.impl.LocationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.genivi.location.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.location.impl.LocationImpl
	 * @see org.genivi.location.impl.LocationPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 0;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.genivi.location.impl.PointLocationImpl <em>Point Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.location.impl.PointLocationImpl
	 * @see org.genivi.location.impl.LocationPackageImpl#getPointLocation()
	 * @generated
	 */
	int POINT_LOCATION = 1;

	/**
	 * The number of structural features of the '<em>Point Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_LOCATION_FEATURE_COUNT = LOCATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.genivi.location.impl.AreaLocationImpl <em>Area Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.location.impl.AreaLocationImpl
	 * @see org.genivi.location.impl.LocationPackageImpl#getAreaLocation()
	 * @generated
	 */
	int AREA_LOCATION = 2;

	/**
	 * The number of structural features of the '<em>Area Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_LOCATION_FEATURE_COUNT = LOCATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.genivi.location.impl.LinearLocationImpl <em>Linear Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.location.impl.LinearLocationImpl
	 * @see org.genivi.location.impl.LocationPackageImpl#getLinearLocation()
	 * @generated
	 */
	int LINEAR_LOCATION = 3;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_LOCATION__SEGMENTS = LOCATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Positive Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINEAR_LOCATION__POSITIVE_OFFSET = LOCATION_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Negative Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINEAR_LOCATION__NEGATIVE_OFFSET = LOCATION_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Linear Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_LOCATION_FEATURE_COUNT = LOCATION_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.genivi.location.impl.LocationInfoImpl <em>Info</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.location.impl.LocationInfoImpl
	 * @see org.genivi.location.impl.LocationPackageImpl#getLocationInfo()
	 * @generated
	 */
  int LOCATION_INFO = 4;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCATION_INFO__NAME = 0;

  /**
	 * The feature id for the '<em><b>Main Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCATION_INFO__MAIN_LOCATION = 1;

  /**
	 * The number of structural features of the '<em>Info</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCATION_INFO_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.genivi.location.impl.PointLocationInfoImpl <em>Point Location Info</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.location.impl.PointLocationInfoImpl
	 * @see org.genivi.location.impl.LocationPackageImpl#getPointLocationInfo()
	 * @generated
	 */
  int POINT_LOCATION_INFO = 5;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int POINT_LOCATION_INFO__NAME = LOCATION_INFO__NAME;

  /**
	 * The feature id for the '<em><b>Main Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int POINT_LOCATION_INFO__MAIN_LOCATION = LOCATION_INFO__MAIN_LOCATION;

  /**
	 * The feature id for the '<em><b>Location Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int POINT_LOCATION_INFO__LOCATION_TYPE = LOCATION_INFO_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Point Location Info</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int POINT_LOCATION_INFO_FEATURE_COUNT = LOCATION_INFO_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.genivi.location.impl.LinearLocationInfoImpl <em>Linear Location Info</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.location.impl.LinearLocationInfoImpl
	 * @see org.genivi.location.impl.LocationPackageImpl#getLinearLocationInfo()
	 * @generated
	 */
  int LINEAR_LOCATION_INFO = 6;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINEAR_LOCATION_INFO__NAME = LOCATION_INFO__NAME;

  /**
	 * The feature id for the '<em><b>Main Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINEAR_LOCATION_INFO__MAIN_LOCATION = LOCATION_INFO__MAIN_LOCATION;

  /**
	 * The feature id for the '<em><b>From Location Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINEAR_LOCATION_INFO__FROM_LOCATION_NAME = LOCATION_INFO_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>From Location Parent Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINEAR_LOCATION_INFO__FROM_LOCATION_PARENT_NAME = LOCATION_INFO_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>To Location Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINEAR_LOCATION_INFO__TO_LOCATION_NAME = LOCATION_INFO_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>To Location Parent Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINEAR_LOCATION_INFO__TO_LOCATION_PARENT_NAME = LOCATION_INFO_FEATURE_COUNT + 3;

  /**
	 * The feature id for the '<em><b>Coordinates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINEAR_LOCATION_INFO__COORDINATES = LOCATION_INFO_FEATURE_COUNT + 4;

  /**
	 * The number of structural features of the '<em>Linear Location Info</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINEAR_LOCATION_INFO_FEATURE_COUNT = LOCATION_INFO_FEATURE_COUNT + 5;

  /**
	 * The meta object id for the '{@link org.genivi.location.impl.AreaLocationInfoImpl <em>Area Location Info</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.location.impl.AreaLocationInfoImpl
	 * @see org.genivi.location.impl.LocationPackageImpl#getAreaLocationInfo()
	 * @generated
	 */
  int AREA_LOCATION_INFO = 7;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int AREA_LOCATION_INFO__NAME = LOCATION_INFO__NAME;

  /**
	 * The feature id for the '<em><b>Main Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int AREA_LOCATION_INFO__MAIN_LOCATION = LOCATION_INFO__MAIN_LOCATION;

  /**
	 * The number of structural features of the '<em>Area Location Info</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int AREA_LOCATION_INFO_FEATURE_COUNT = LOCATION_INFO_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.genivi.location.PointLocationType <em>Point Location Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.location.PointLocationType
	 * @see org.genivi.location.impl.LocationPackageImpl#getPointLocationType()
	 * @generated
	 */
  int POINT_LOCATION_TYPE = 8;


  /**
	 * Returns the meta object for class '{@link org.genivi.location.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see org.genivi.location.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for class '{@link org.genivi.location.PointLocation <em>Point Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point Location</em>'.
	 * @see org.genivi.location.PointLocation
	 * @generated
	 */
	EClass getPointLocation();

	/**
	 * Returns the meta object for class '{@link org.genivi.location.AreaLocation <em>Area Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area Location</em>'.
	 * @see org.genivi.location.AreaLocation
	 * @generated
	 */
	EClass getAreaLocation();

	/**
	 * Returns the meta object for class '{@link org.genivi.location.LinearLocation <em>Linear Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Location</em>'.
	 * @see org.genivi.location.LinearLocation
	 * @generated
	 */
	EClass getLinearLocation();

	/**
	 * Returns the meta object for the attribute list '{@link org.genivi.location.LinearLocation#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Segments</em>'.
	 * @see org.genivi.location.LinearLocation#getSegments()
	 * @see #getLinearLocation()
	 * @generated
	 */
	EAttribute getLinearLocation_Segments();

	/**
	 * Returns the meta object for the attribute '{@link org.genivi.location.LinearLocation#getPositiveOffset <em>Positive Offset</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Positive Offset</em>'.
	 * @see org.genivi.location.LinearLocation#getPositiveOffset()
	 * @see #getLinearLocation()
	 * @generated
	 */
  EAttribute getLinearLocation_PositiveOffset();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.location.LinearLocation#getNegativeOffset <em>Negative Offset</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Negative Offset</em>'.
	 * @see org.genivi.location.LinearLocation#getNegativeOffset()
	 * @see #getLinearLocation()
	 * @generated
	 */
  EAttribute getLinearLocation_NegativeOffset();

  /**
	 * Returns the meta object for class '{@link org.genivi.location.LocationInfo <em>Info</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Info</em>'.
	 * @see org.genivi.location.LocationInfo
	 * @generated
	 */
  EClass getLocationInfo();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.location.LocationInfo#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.genivi.location.LocationInfo#getName()
	 * @see #getLocationInfo()
	 * @generated
	 */
  EAttribute getLocationInfo_Name();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.location.LocationInfo#getMainLocation <em>Main Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Main Location</em>'.
	 * @see org.genivi.location.LocationInfo#getMainLocation()
	 * @see #getLocationInfo()
	 * @generated
	 */
  EReference getLocationInfo_MainLocation();

  /**
	 * Returns the meta object for class '{@link org.genivi.location.PointLocationInfo <em>Point Location Info</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point Location Info</em>'.
	 * @see org.genivi.location.PointLocationInfo
	 * @generated
	 */
  EClass getPointLocationInfo();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.location.PointLocationInfo#getLocationType <em>Location Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location Type</em>'.
	 * @see org.genivi.location.PointLocationInfo#getLocationType()
	 * @see #getPointLocationInfo()
	 * @generated
	 */
  EAttribute getPointLocationInfo_LocationType();

  /**
	 * Returns the meta object for class '{@link org.genivi.location.LinearLocationInfo <em>Linear Location Info</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Location Info</em>'.
	 * @see org.genivi.location.LinearLocationInfo
	 * @generated
	 */
  EClass getLinearLocationInfo();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.location.LinearLocationInfo#getFromLocationName <em>From Location Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Location Name</em>'.
	 * @see org.genivi.location.LinearLocationInfo#getFromLocationName()
	 * @see #getLinearLocationInfo()
	 * @generated
	 */
  EAttribute getLinearLocationInfo_FromLocationName();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.location.LinearLocationInfo#getFromLocationParentName <em>From Location Parent Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Location Parent Name</em>'.
	 * @see org.genivi.location.LinearLocationInfo#getFromLocationParentName()
	 * @see #getLinearLocationInfo()
	 * @generated
	 */
  EAttribute getLinearLocationInfo_FromLocationParentName();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.location.LinearLocationInfo#getToLocationName <em>To Location Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Location Name</em>'.
	 * @see org.genivi.location.LinearLocationInfo#getToLocationName()
	 * @see #getLinearLocationInfo()
	 * @generated
	 */
  EAttribute getLinearLocationInfo_ToLocationName();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.location.LinearLocationInfo#getToLocationParentName <em>To Location Parent Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Location Parent Name</em>'.
	 * @see org.genivi.location.LinearLocationInfo#getToLocationParentName()
	 * @see #getLinearLocationInfo()
	 * @generated
	 */
  EAttribute getLinearLocationInfo_ToLocationParentName();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.location.LinearLocationInfo#getCoordinates <em>Coordinates</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Coordinates</em>'.
	 * @see org.genivi.location.LinearLocationInfo#getCoordinates()
	 * @see #getLinearLocationInfo()
	 * @generated
	 */
  EReference getLinearLocationInfo_Coordinates();

  /**
	 * Returns the meta object for class '{@link org.genivi.location.AreaLocationInfo <em>Area Location Info</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area Location Info</em>'.
	 * @see org.genivi.location.AreaLocationInfo
	 * @generated
	 */
  EClass getAreaLocationInfo();

  /**
	 * Returns the meta object for enum '{@link org.genivi.location.PointLocationType <em>Point Location Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Point Location Type</em>'.
	 * @see org.genivi.location.PointLocationType
	 * @generated
	 */
  EEnum getPointLocationType();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LocationFactory getLocationFactory();

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
		 * The meta object literal for the '{@link org.genivi.location.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.location.impl.LocationImpl
		 * @see org.genivi.location.impl.LocationPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '{@link org.genivi.location.impl.PointLocationImpl <em>Point Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.location.impl.PointLocationImpl
		 * @see org.genivi.location.impl.LocationPackageImpl#getPointLocation()
		 * @generated
		 */
		EClass POINT_LOCATION = eINSTANCE.getPointLocation();

		/**
		 * The meta object literal for the '{@link org.genivi.location.impl.AreaLocationImpl <em>Area Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.location.impl.AreaLocationImpl
		 * @see org.genivi.location.impl.LocationPackageImpl#getAreaLocation()
		 * @generated
		 */
		EClass AREA_LOCATION = eINSTANCE.getAreaLocation();

		/**
		 * The meta object literal for the '{@link org.genivi.location.impl.LinearLocationImpl <em>Linear Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.location.impl.LinearLocationImpl
		 * @see org.genivi.location.impl.LocationPackageImpl#getLinearLocation()
		 * @generated
		 */
		EClass LINEAR_LOCATION = eINSTANCE.getLinearLocation();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEAR_LOCATION__SEGMENTS = eINSTANCE.getLinearLocation_Segments();

    /**
		 * The meta object literal for the '<em><b>Positive Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LINEAR_LOCATION__POSITIVE_OFFSET = eINSTANCE.getLinearLocation_PositiveOffset();

    /**
		 * The meta object literal for the '<em><b>Negative Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LINEAR_LOCATION__NEGATIVE_OFFSET = eINSTANCE.getLinearLocation_NegativeOffset();

    /**
		 * The meta object literal for the '{@link org.genivi.location.impl.LocationInfoImpl <em>Info</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.location.impl.LocationInfoImpl
		 * @see org.genivi.location.impl.LocationPackageImpl#getLocationInfo()
		 * @generated
		 */
    EClass LOCATION_INFO = eINSTANCE.getLocationInfo();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LOCATION_INFO__NAME = eINSTANCE.getLocationInfo_Name();

    /**
		 * The meta object literal for the '<em><b>Main Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference LOCATION_INFO__MAIN_LOCATION = eINSTANCE.getLocationInfo_MainLocation();

    /**
		 * The meta object literal for the '{@link org.genivi.location.impl.PointLocationInfoImpl <em>Point Location Info</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.location.impl.PointLocationInfoImpl
		 * @see org.genivi.location.impl.LocationPackageImpl#getPointLocationInfo()
		 * @generated
		 */
    EClass POINT_LOCATION_INFO = eINSTANCE.getPointLocationInfo();

    /**
		 * The meta object literal for the '<em><b>Location Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute POINT_LOCATION_INFO__LOCATION_TYPE = eINSTANCE.getPointLocationInfo_LocationType();

    /**
		 * The meta object literal for the '{@link org.genivi.location.impl.LinearLocationInfoImpl <em>Linear Location Info</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.location.impl.LinearLocationInfoImpl
		 * @see org.genivi.location.impl.LocationPackageImpl#getLinearLocationInfo()
		 * @generated
		 */
    EClass LINEAR_LOCATION_INFO = eINSTANCE.getLinearLocationInfo();

    /**
		 * The meta object literal for the '<em><b>From Location Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LINEAR_LOCATION_INFO__FROM_LOCATION_NAME = eINSTANCE.getLinearLocationInfo_FromLocationName();

    /**
		 * The meta object literal for the '<em><b>From Location Parent Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LINEAR_LOCATION_INFO__FROM_LOCATION_PARENT_NAME = eINSTANCE.getLinearLocationInfo_FromLocationParentName();

    /**
		 * The meta object literal for the '<em><b>To Location Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LINEAR_LOCATION_INFO__TO_LOCATION_NAME = eINSTANCE.getLinearLocationInfo_ToLocationName();

    /**
		 * The meta object literal for the '<em><b>To Location Parent Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LINEAR_LOCATION_INFO__TO_LOCATION_PARENT_NAME = eINSTANCE.getLinearLocationInfo_ToLocationParentName();

    /**
		 * The meta object literal for the '<em><b>Coordinates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference LINEAR_LOCATION_INFO__COORDINATES = eINSTANCE.getLinearLocationInfo_Coordinates();

    /**
		 * The meta object literal for the '{@link org.genivi.location.impl.AreaLocationInfoImpl <em>Area Location Info</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.location.impl.AreaLocationInfoImpl
		 * @see org.genivi.location.impl.LocationPackageImpl#getAreaLocationInfo()
		 * @generated
		 */
    EClass AREA_LOCATION_INFO = eINSTANCE.getAreaLocationInfo();

    /**
		 * The meta object literal for the '{@link org.genivi.location.PointLocationType <em>Point Location Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.location.PointLocationType
		 * @see org.genivi.location.impl.LocationPackageImpl#getPointLocationType()
		 * @generated
		 */
    EEnum POINT_LOCATION_TYPE = eINSTANCE.getPointLocationType();

	}

} //LocationPackage
