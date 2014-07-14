/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.iconset;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.iconset.IconsetPackage
 * @generated
 */
public interface IconsetFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  IconsetFactory eINSTANCE = org.genivi.iconset.impl.IconsetFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Icon Set</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icon Set</em>'.
	 * @generated
	 */
  IconSet createIconSet();

  /**
	 * Returns a new object of class '<em>Icon Size</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icon Size</em>'.
	 * @generated
	 */
  IconSize createIconSize();

  /**
	 * Returns a new object of class '<em>Icon Descriptor</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icon Descriptor</em>'.
	 * @generated
	 */
  IconDescriptor createIconDescriptor();

  /**
	 * Returns a new object of class '<em>Icon Data</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icon Data</em>'.
	 * @generated
	 */
  IconData createIconData();

  /**
	 * Returns a new object of class '<em>Icon Info</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icon Info</em>'.
	 * @generated
	 */
  IconInfo createIconInfo();

  /**
	 * Returns a new object of class '<em>Icon Definition</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icon Definition</em>'.
	 * @generated
	 */
  IconDefinition createIconDefinition();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  IconsetPackage getIconsetPackage();

} //IconsetFactory
