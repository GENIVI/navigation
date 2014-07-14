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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.locref.locrefPackage
 * @generated
 */
public interface locrefFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  locrefFactory eINSTANCE = org.genivi.locref.impl.locrefFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Location Reference</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Location Reference</em>'.
	 * @generated
	 */
  LocationReference createLocationReference();

  /**
	 * Returns a new object of class '<em>Location Reference Decoding Service</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Location Reference Decoding Service</em>'.
	 * @generated
	 */
  LocationReferenceDecodingService createLocationReferenceDecodingService();

  /**
	 * Returns a new object of class '<em>Location Reference Decoding Service Listener</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Location Reference Decoding Service Listener</em>'.
	 * @generated
	 */
  LocationReferenceDecodingServiceListener createLocationReferenceDecodingServiceListener();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  locrefPackage getlocrefPackage();

} //locrefFactory
