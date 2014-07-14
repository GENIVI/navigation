/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.common;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.common.CommonPackage
 * @generated
 */
public interface CommonFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonFactory eINSTANCE = org.genivi.common.impl.CommonFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Coordinate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Coordinate</em>'.
	 * @generated
	 */
	Coordinate createCoordinate();

	/**
	 * Returns a new object of class '<em>Rectangular Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rectangular Area</em>'.
	 * @generated
	 */
	RectangularArea createRectangularArea();

	/**
	 * Returns a new object of class '<em>Version</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version</em>'.
	 * @generated
	 */
  Version createVersion();

  /**
	 * Returns a new object of class '<em>Localized String</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Localized String</em>'.
	 * @generated
	 */
  LocalizedString createLocalizedString();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommonPackage getCommonPackage();

} //CommonFactory
