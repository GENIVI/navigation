/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.genivi.common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "common";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.genivi.common";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonPackage eINSTANCE = org.genivi.common.impl.CommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.genivi.common.impl.CoordinateImpl <em>Coordinate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.common.impl.CoordinateImpl
	 * @see org.genivi.common.impl.CommonPackageImpl#getCoordinate()
	 * @generated
	 */
	int COORDINATE = 0;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COORDINATE__LATITUDE = 0;

  /**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COORDINATE__LONGITUDE = 1;

  /**
	 * The feature id for the '<em><b>Altitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COORDINATE__ALTITUDE = 2;

  /**
	 * The number of structural features of the '<em>Coordinate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COORDINATE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.genivi.common.impl.RectangularAreaImpl <em>Rectangular Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.common.impl.RectangularAreaImpl
	 * @see org.genivi.common.impl.CommonPackageImpl#getRectangularArea()
	 * @generated
	 */
	int RECTANGULAR_AREA = 1;

	/**
	 * The feature id for the '<em><b>Bottom Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_AREA__BOTTOM_LEFT = 0;

	/**
	 * The feature id for the '<em><b>Top Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_AREA__TOP_RIGHT = 1;

	/**
	 * The number of structural features of the '<em>Rectangular Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_AREA_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.genivi.common.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.common.impl.VersionImpl
	 * @see org.genivi.common.impl.CommonPackageImpl#getVersion()
	 * @generated
	 */
  int VERSION = 2;

  /**
	 * The feature id for the '<em><b>Major</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VERSION__MAJOR = 0;

  /**
	 * The feature id for the '<em><b>Minor</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VERSION__MINOR = 1;

  /**
	 * The feature id for the '<em><b>Micro</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VERSION__MICRO = 2;

  /**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VERSION__DATE = 3;

  /**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VERSION_FEATURE_COUNT = 4;


  /**
	 * The meta object id for the '{@link org.genivi.common.impl.LocalizedStringImpl <em>Localized String</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.common.impl.LocalizedStringImpl
	 * @see org.genivi.common.impl.CommonPackageImpl#getLocalizedString()
	 * @generated
	 */
  int LOCALIZED_STRING = 3;

  /**
	 * The feature id for the '<em><b>Language Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCALIZED_STRING__LANGUAGE_CODE = 0;

  /**
	 * The feature id for the '<em><b>Country Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCALIZED_STRING__COUNTRY_CODE = 1;

  /**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCALIZED_STRING__STRING = 2;

  /**
	 * The number of structural features of the '<em>Localized String</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCALIZED_STRING_FEATURE_COUNT = 3;


  /**
	 * Returns the meta object for class '{@link org.genivi.common.Coordinate <em>Coordinate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coordinate</em>'.
	 * @see org.genivi.common.Coordinate
	 * @generated
	 */
	EClass getCoordinate();

	/**
	 * Returns the meta object for the attribute '{@link org.genivi.common.Coordinate#getLatitude <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latitude</em>'.
	 * @see org.genivi.common.Coordinate#getLatitude()
	 * @see #getCoordinate()
	 * @generated
	 */
  EAttribute getCoordinate_Latitude();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.common.Coordinate#getLongitude <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Longitude</em>'.
	 * @see org.genivi.common.Coordinate#getLongitude()
	 * @see #getCoordinate()
	 * @generated
	 */
  EAttribute getCoordinate_Longitude();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.common.Coordinate#getAltitude <em>Altitude</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Altitude</em>'.
	 * @see org.genivi.common.Coordinate#getAltitude()
	 * @see #getCoordinate()
	 * @generated
	 */
  EAttribute getCoordinate_Altitude();

  /**
	 * Returns the meta object for class '{@link org.genivi.common.RectangularArea <em>Rectangular Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangular Area</em>'.
	 * @see org.genivi.common.RectangularArea
	 * @generated
	 */
	EClass getRectangularArea();

	/**
	 * Returns the meta object for the containment reference '{@link org.genivi.common.RectangularArea#getBottomLeft <em>Bottom Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bottom Left</em>'.
	 * @see org.genivi.common.RectangularArea#getBottomLeft()
	 * @see #getRectangularArea()
	 * @generated
	 */
	EReference getRectangularArea_BottomLeft();

	/**
	 * Returns the meta object for the containment reference '{@link org.genivi.common.RectangularArea#getTopRight <em>Top Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Top Right</em>'.
	 * @see org.genivi.common.RectangularArea#getTopRight()
	 * @see #getRectangularArea()
	 * @generated
	 */
	EReference getRectangularArea_TopRight();

	/**
	 * Returns the meta object for class '{@link org.genivi.common.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.genivi.common.Version
	 * @generated
	 */
  EClass getVersion();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.common.Version#getMajor <em>Major</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Major</em>'.
	 * @see org.genivi.common.Version#getMajor()
	 * @see #getVersion()
	 * @generated
	 */
  EAttribute getVersion_Major();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.common.Version#getMinor <em>Minor</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minor</em>'.
	 * @see org.genivi.common.Version#getMinor()
	 * @see #getVersion()
	 * @generated
	 */
  EAttribute getVersion_Minor();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.common.Version#getMicro <em>Micro</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Micro</em>'.
	 * @see org.genivi.common.Version#getMicro()
	 * @see #getVersion()
	 * @generated
	 */
  EAttribute getVersion_Micro();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.common.Version#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.genivi.common.Version#getDate()
	 * @see #getVersion()
	 * @generated
	 */
  EAttribute getVersion_Date();

  /**
	 * Returns the meta object for class '{@link org.genivi.common.LocalizedString <em>Localized String</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Localized String</em>'.
	 * @see org.genivi.common.LocalizedString
	 * @generated
	 */
  EClass getLocalizedString();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.common.LocalizedString#getLanguageCode <em>Language Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language Code</em>'.
	 * @see org.genivi.common.LocalizedString#getLanguageCode()
	 * @see #getLocalizedString()
	 * @generated
	 */
  EAttribute getLocalizedString_LanguageCode();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.common.LocalizedString#getCountryCode <em>Country Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Country Code</em>'.
	 * @see org.genivi.common.LocalizedString#getCountryCode()
	 * @see #getLocalizedString()
	 * @generated
	 */
  EAttribute getLocalizedString_CountryCode();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.common.LocalizedString#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see org.genivi.common.LocalizedString#getString()
	 * @see #getLocalizedString()
	 * @generated
	 */
  EAttribute getLocalizedString_String();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommonFactory getCommonFactory();

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
		 * The meta object literal for the '{@link org.genivi.common.impl.CoordinateImpl <em>Coordinate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.common.impl.CoordinateImpl
		 * @see org.genivi.common.impl.CommonPackageImpl#getCoordinate()
		 * @generated
		 */
		EClass COORDINATE = eINSTANCE.getCoordinate();

		/**
		 * The meta object literal for the '<em><b>Latitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COORDINATE__LATITUDE = eINSTANCE.getCoordinate_Latitude();

    /**
		 * The meta object literal for the '<em><b>Longitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COORDINATE__LONGITUDE = eINSTANCE.getCoordinate_Longitude();

    /**
		 * The meta object literal for the '<em><b>Altitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COORDINATE__ALTITUDE = eINSTANCE.getCoordinate_Altitude();

    /**
		 * The meta object literal for the '{@link org.genivi.common.impl.RectangularAreaImpl <em>Rectangular Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.common.impl.RectangularAreaImpl
		 * @see org.genivi.common.impl.CommonPackageImpl#getRectangularArea()
		 * @generated
		 */
		EClass RECTANGULAR_AREA = eINSTANCE.getRectangularArea();

		/**
		 * The meta object literal for the '<em><b>Bottom Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGULAR_AREA__BOTTOM_LEFT = eINSTANCE.getRectangularArea_BottomLeft();

		/**
		 * The meta object literal for the '<em><b>Top Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGULAR_AREA__TOP_RIGHT = eINSTANCE.getRectangularArea_TopRight();

    /**
		 * The meta object literal for the '{@link org.genivi.common.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.common.impl.VersionImpl
		 * @see org.genivi.common.impl.CommonPackageImpl#getVersion()
		 * @generated
		 */
    EClass VERSION = eINSTANCE.getVersion();

    /**
		 * The meta object literal for the '<em><b>Major</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VERSION__MAJOR = eINSTANCE.getVersion_Major();

    /**
		 * The meta object literal for the '<em><b>Minor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VERSION__MINOR = eINSTANCE.getVersion_Minor();

    /**
		 * The meta object literal for the '<em><b>Micro</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VERSION__MICRO = eINSTANCE.getVersion_Micro();

    /**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VERSION__DATE = eINSTANCE.getVersion_Date();

    /**
		 * The meta object literal for the '{@link org.genivi.common.impl.LocalizedStringImpl <em>Localized String</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.common.impl.LocalizedStringImpl
		 * @see org.genivi.common.impl.CommonPackageImpl#getLocalizedString()
		 * @generated
		 */
    EClass LOCALIZED_STRING = eINSTANCE.getLocalizedString();

    /**
		 * The meta object literal for the '<em><b>Language Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LOCALIZED_STRING__LANGUAGE_CODE = eINSTANCE.getLocalizedString_LanguageCode();

    /**
		 * The meta object literal for the '<em><b>Country Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LOCALIZED_STRING__COUNTRY_CODE = eINSTANCE.getLocalizedString_CountryCode();

    /**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LOCALIZED_STRING__STRING = eINSTANCE.getLocalizedString_String();

	}

} //CommonPackage
