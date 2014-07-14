/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.locref;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.genivi.locref.locrefFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface locrefPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "locref";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://org.genivi.locref";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "locref";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  locrefPackage eINSTANCE = org.genivi.locref.impl.locrefPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.genivi.locref.impl.LocationReferenceImpl <em>Location Reference</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.locref.impl.LocationReferenceImpl
	 * @see org.genivi.locref.impl.locrefPackageImpl#getLocationReference()
	 * @generated
	 */
  int LOCATION_REFERENCE = 0;

  /**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCATION_REFERENCE__DATA = 0;

  /**
	 * The feature id for the '<em><b>Location Reference Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCATION_REFERENCE__LOCATION_REFERENCE_TYPE = 1;

  /**
	 * The number of structural features of the '<em>Location Reference</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCATION_REFERENCE_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.genivi.locref.impl.LocationReferenceDecodingServiceImpl <em>Location Reference Decoding Service</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.locref.impl.LocationReferenceDecodingServiceImpl
	 * @see org.genivi.locref.impl.locrefPackageImpl#getLocationReferenceDecodingService()
	 * @generated
	 */
  int LOCATION_REFERENCE_DECODING_SERVICE = 1;

  /**
	 * The number of structural features of the '<em>Location Reference Decoding Service</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCATION_REFERENCE_DECODING_SERVICE_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.genivi.locref.impl.LocationReferenceDecodingServiceListenerImpl <em>Location Reference Decoding Service Listener</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.locref.impl.LocationReferenceDecodingServiceListenerImpl
	 * @see org.genivi.locref.impl.locrefPackageImpl#getLocationReferenceDecodingServiceListener()
	 * @generated
	 */
  int LOCATION_REFERENCE_DECODING_SERVICE_LISTENER = 2;

  /**
	 * The number of structural features of the '<em>Location Reference Decoding Service Listener</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LOCATION_REFERENCE_DECODING_SERVICE_LISTENER_FEATURE_COUNT = 0;


  /**
	 * The meta object id for the '{@link org.genivi.locref.LocationReferenceType <em>Location Reference Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.locref.LocationReferenceType
	 * @see org.genivi.locref.impl.locrefPackageImpl#getLocationReferenceType()
	 * @generated
	 */
  int LOCATION_REFERENCE_TYPE = 3;


  /**
	 * Returns the meta object for class '{@link org.genivi.locref.LocationReference <em>Location Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location Reference</em>'.
	 * @see org.genivi.locref.LocationReference
	 * @generated
	 */
  EClass getLocationReference();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.locref.LocationReference#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.genivi.locref.LocationReference#getData()
	 * @see #getLocationReference()
	 * @generated
	 */
  EAttribute getLocationReference_Data();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.locref.LocationReference#getLocationReferenceType <em>Location Reference Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location Reference Type</em>'.
	 * @see org.genivi.locref.LocationReference#getLocationReferenceType()
	 * @see #getLocationReference()
	 * @generated
	 */
  EAttribute getLocationReference_LocationReferenceType();

  /**
	 * Returns the meta object for class '{@link org.genivi.locref.LocationReferenceDecodingService <em>Location Reference Decoding Service</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location Reference Decoding Service</em>'.
	 * @see org.genivi.locref.LocationReferenceDecodingService
	 * @generated
	 */
  EClass getLocationReferenceDecodingService();

  /**
	 * Returns the meta object for class '{@link org.genivi.locref.LocationReferenceDecodingServiceListener <em>Location Reference Decoding Service Listener</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location Reference Decoding Service Listener</em>'.
	 * @see org.genivi.locref.LocationReferenceDecodingServiceListener
	 * @generated
	 */
  EClass getLocationReferenceDecodingServiceListener();

  /**
	 * Returns the meta object for enum '{@link org.genivi.locref.LocationReferenceType <em>Location Reference Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Location Reference Type</em>'.
	 * @see org.genivi.locref.LocationReferenceType
	 * @generated
	 */
  EEnum getLocationReferenceType();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  locrefFactory getlocrefFactory();

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
		 * The meta object literal for the '{@link org.genivi.locref.impl.LocationReferenceImpl <em>Location Reference</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.locref.impl.LocationReferenceImpl
		 * @see org.genivi.locref.impl.locrefPackageImpl#getLocationReference()
		 * @generated
		 */
    EClass LOCATION_REFERENCE = eINSTANCE.getLocationReference();

    /**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LOCATION_REFERENCE__DATA = eINSTANCE.getLocationReference_Data();

    /**
		 * The meta object literal for the '<em><b>Location Reference Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LOCATION_REFERENCE__LOCATION_REFERENCE_TYPE = eINSTANCE.getLocationReference_LocationReferenceType();

    /**
		 * The meta object literal for the '{@link org.genivi.locref.impl.LocationReferenceDecodingServiceImpl <em>Location Reference Decoding Service</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.locref.impl.LocationReferenceDecodingServiceImpl
		 * @see org.genivi.locref.impl.locrefPackageImpl#getLocationReferenceDecodingService()
		 * @generated
		 */
    EClass LOCATION_REFERENCE_DECODING_SERVICE = eINSTANCE.getLocationReferenceDecodingService();

    /**
		 * The meta object literal for the '{@link org.genivi.locref.impl.LocationReferenceDecodingServiceListenerImpl <em>Location Reference Decoding Service Listener</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.locref.impl.LocationReferenceDecodingServiceListenerImpl
		 * @see org.genivi.locref.impl.locrefPackageImpl#getLocationReferenceDecodingServiceListener()
		 * @generated
		 */
    EClass LOCATION_REFERENCE_DECODING_SERVICE_LISTENER = eINSTANCE.getLocationReferenceDecodingServiceListener();

    /**
		 * The meta object literal for the '{@link org.genivi.locref.LocationReferenceType <em>Location Reference Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.locref.LocationReferenceType
		 * @see org.genivi.locref.impl.locrefPackageImpl#getLocationReferenceType()
		 * @generated
		 */
    EEnum LOCATION_REFERENCE_TYPE = eINSTANCE.getLocationReferenceType();

  }

} //locrefPackage
