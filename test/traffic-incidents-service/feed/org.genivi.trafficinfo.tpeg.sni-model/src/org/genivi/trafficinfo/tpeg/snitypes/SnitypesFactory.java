/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage
 * @generated
 */
public interface SnitypesFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SnitypesFactory eINSTANCE = org.genivi.trafficinfo.tpeg.snitypes.impl.SnitypesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Sni Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sni Component</em>'.
   * @generated
   */
  SniComponent createSniComponent();

  /**
   * Returns a new object of class '<em>Sni Component Fast Tuning</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sni Component Fast Tuning</em>'.
   * @generated
   */
  SniComponentFastTuning createSniComponentFastTuning();

  /**
   * Returns a new object of class '<em>Line Of Table1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Line Of Table1</em>'.
   * @generated
   */
  LineOfTable1 createLineOfTable1();

  /**
   * Returns a new object of class '<em>Operating Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operating Time</em>'.
   * @generated
   */
  OperatingTime createOperatingTime();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SnitypesPackage getSnitypesPackage();

} //SnitypesFactory
