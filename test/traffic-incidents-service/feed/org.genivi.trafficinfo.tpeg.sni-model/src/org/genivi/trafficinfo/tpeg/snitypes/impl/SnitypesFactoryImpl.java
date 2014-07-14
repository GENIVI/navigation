/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genivi.trafficinfo.tpeg.snitypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SnitypesFactoryImpl extends EFactoryImpl implements SnitypesFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SnitypesFactory init() {
    try {
      SnitypesFactory theSnitypesFactory = (SnitypesFactory)EPackage.Registry.INSTANCE.getEFactory(SnitypesPackage.eNS_URI);
      if (theSnitypesFactory != null) {
        return theSnitypesFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SnitypesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnitypesFactoryImpl() {
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
      case SnitypesPackage.SNI_COMPONENT: return createSniComponent();
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING: return createSniComponentFastTuning();
      case SnitypesPackage.LINE_OF_TABLE1: return createLineOfTable1();
      case SnitypesPackage.OPERATING_TIME: return createOperatingTime();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SniComponent createSniComponent() {
    SniComponentImpl sniComponent = new SniComponentImpl();
    return sniComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SniComponentFastTuning createSniComponentFastTuning() {
    SniComponentFastTuningImpl sniComponentFastTuning = new SniComponentFastTuningImpl();
    return sniComponentFastTuning;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LineOfTable1 createLineOfTable1() {
    LineOfTable1Impl lineOfTable1 = new LineOfTable1Impl();
    return lineOfTable1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperatingTime createOperatingTime() {
    OperatingTimeImpl operatingTime = new OperatingTimeImpl();
    return operatingTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnitypesPackage getSnitypesPackage() {
    return (SnitypesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SnitypesPackage getPackage() {
    return SnitypesPackage.eINSTANCE;
  }

} //SnitypesFactoryImpl
