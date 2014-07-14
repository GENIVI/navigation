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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genivi.location.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LocationFactoryImpl extends EFactoryImpl implements LocationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LocationFactory init() {
		try {
			LocationFactory theLocationFactory = (LocationFactory)EPackage.Registry.INSTANCE.getEFactory(LocationPackage.eNS_URI);
			if (theLocationFactory != null) {
				return theLocationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LocationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationFactoryImpl() {
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
			case LocationPackage.LOCATION: return createLocation();
			case LocationPackage.POINT_LOCATION: return createPointLocation();
			case LocationPackage.AREA_LOCATION: return createAreaLocation();
			case LocationPackage.LINEAR_LOCATION: return createLinearLocation();
			case LocationPackage.LOCATION_INFO: return createLocationInfo();
			case LocationPackage.POINT_LOCATION_INFO: return createPointLocationInfo();
			case LocationPackage.LINEAR_LOCATION_INFO: return createLinearLocationInfo();
			case LocationPackage.AREA_LOCATION_INFO: return createAreaLocationInfo();
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
			case LocationPackage.POINT_LOCATION_TYPE:
				return createPointLocationTypeFromString(eDataType, initialValue);
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
			case LocationPackage.POINT_LOCATION_TYPE:
				return convertPointLocationTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location createLocation() {
		LocationImpl location = new LocationImpl();
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointLocation createPointLocation() {
		PointLocationImpl pointLocation = new PointLocationImpl();
		return pointLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaLocation createAreaLocation() {
		AreaLocationImpl areaLocation = new AreaLocationImpl();
		return areaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearLocation createLinearLocation() {
		LinearLocationImpl linearLocation = new LinearLocationImpl();
		return linearLocation;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LocationInfo createLocationInfo() {
		LocationInfoImpl locationInfo = new LocationInfoImpl();
		return locationInfo;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PointLocationInfo createPointLocationInfo() {
		PointLocationInfoImpl pointLocationInfo = new PointLocationInfoImpl();
		return pointLocationInfo;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LinearLocationInfo createLinearLocationInfo() {
		LinearLocationInfoImpl linearLocationInfo = new LinearLocationInfoImpl();
		return linearLocationInfo;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AreaLocationInfo createAreaLocationInfo() {
		AreaLocationInfoImpl areaLocationInfo = new AreaLocationInfoImpl();
		return areaLocationInfo;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PointLocationType createPointLocationTypeFromString(EDataType eDataType, String initialValue) {
		PointLocationType result = PointLocationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertPointLocationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationPackage getLocationPackage() {
		return (LocationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LocationPackage getPackage() {
		return LocationPackage.eINSTANCE;
	}

} //LocationFactoryImpl
