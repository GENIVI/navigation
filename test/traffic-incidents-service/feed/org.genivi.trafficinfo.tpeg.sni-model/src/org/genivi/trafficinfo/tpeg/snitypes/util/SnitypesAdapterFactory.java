/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.genivi.trafficinfo.tpeg.snitypes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage
 * @generated
 */
public class SnitypesAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SnitypesPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnitypesAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = SnitypesPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SnitypesSwitch<Adapter> modelSwitch =
    new SnitypesSwitch<Adapter>() {
      @Override
      public Adapter caseSniComponent(SniComponent object) {
        return createSniComponentAdapter();
      }
      @Override
      public Adapter caseSniComponentFastTuning(SniComponentFastTuning object) {
        return createSniComponentFastTuningAdapter();
      }
      @Override
      public Adapter caseLineOfTable1(LineOfTable1 object) {
        return createLineOfTable1Adapter();
      }
      @Override
      public Adapter caseOperatingTime(OperatingTime object) {
        return createOperatingTimeAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent <em>Sni Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.snitypes.SniComponent
   * @generated
   */
  public Adapter createSniComponentAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning <em>Sni Component Fast Tuning</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning
   * @generated
   */
  public Adapter createSniComponentFastTuningAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1 <em>Line Of Table1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1
   * @generated
   */
  public Adapter createLineOfTable1Adapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.snitypes.OperatingTime <em>Operating Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.snitypes.OperatingTime
   * @generated
   */
  public Adapter createOperatingTimeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //SnitypesAdapterFactory
