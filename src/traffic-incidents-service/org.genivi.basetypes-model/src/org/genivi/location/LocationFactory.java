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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.location.LocationPackage
 * @generated
 */
public interface LocationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LocationFactory eINSTANCE = org.genivi.location.impl.LocationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Location</em>'.
	 * @generated
	 */
	Location createLocation();

	/**
	 * Returns a new object of class '<em>Point Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Point Location</em>'.
	 * @generated
	 */
	PointLocation createPointLocation();

	/**
	 * Returns a new object of class '<em>Area Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Area Location</em>'.
	 * @generated
	 */
	AreaLocation createAreaLocation();

	/**
	 * Returns a new object of class '<em>Linear Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linear Location</em>'.
	 * @generated
	 */
	LinearLocation createLinearLocation();

	/**
	 * Returns a new object of class '<em>Info</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Info</em>'.
	 * @generated
	 */
  LocationInfo createLocationInfo();

  /**
	 * Returns a new object of class '<em>Point Location Info</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Point Location Info</em>'.
	 * @generated
	 */
  PointLocationInfo createPointLocationInfo();

  /**
	 * Returns a new object of class '<em>Linear Location Info</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linear Location Info</em>'.
	 * @generated
	 */
  LinearLocationInfo createLinearLocationInfo();

  /**
	 * Returns a new object of class '<em>Area Location Info</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Area Location Info</em>'.
	 * @generated
	 */
  AreaLocationInfo createAreaLocationInfo();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LocationPackage getLocationPackage();

} //LocationFactory
