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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genivi.locref.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class locrefFactoryImpl extends EFactoryImpl implements locrefFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static locrefFactory init() {
		try {
			locrefFactory thelocrefFactory = (locrefFactory)EPackage.Registry.INSTANCE.getEFactory(locrefPackage.eNS_URI);
			if (thelocrefFactory != null) {
				return thelocrefFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new locrefFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public locrefFactoryImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case locrefPackage.LOCATION_REFERENCE: return createLocationReference();
			case locrefPackage.LOCATION_REFERENCE_DECODING_SERVICE: return createLocationReferenceDecodingService();
			case locrefPackage.LOCATION_REFERENCE_DECODING_SERVICE_LISTENER: return createLocationReferenceDecodingServiceListener();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case locrefPackage.LOCATION_REFERENCE_TYPE:
				return createLocationReferenceTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case locrefPackage.LOCATION_REFERENCE_TYPE:
				return convertLocationReferenceTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LocationReference createLocationReference() {
		LocationReferenceImpl locationReference = new LocationReferenceImpl();
		return locationReference;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LocationReferenceDecodingService createLocationReferenceDecodingService() {
		LocationReferenceDecodingServiceImpl locationReferenceDecodingService = new LocationReferenceDecodingServiceImpl();
		return locationReferenceDecodingService;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LocationReferenceDecodingServiceListener createLocationReferenceDecodingServiceListener() {
		LocationReferenceDecodingServiceListenerImpl locationReferenceDecodingServiceListener = new LocationReferenceDecodingServiceListenerImpl();
		return locationReferenceDecodingServiceListener;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LocationReferenceType createLocationReferenceTypeFromString(EDataType eDataType, String initialValue) {
		LocationReferenceType result = LocationReferenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertLocationReferenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public locrefPackage getlocrefPackage() {
		return (locrefPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static locrefPackage getPackage() {
		return locrefPackage.eINSTANCE;
	}

} //locrefFactoryImpl
