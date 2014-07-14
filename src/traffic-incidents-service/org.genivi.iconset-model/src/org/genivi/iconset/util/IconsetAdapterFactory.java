/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.iconset.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.genivi.iconset.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.iconset.IconsetPackage
 * @generated
 */
public class IconsetAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static IconsetPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconsetAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = IconsetPackage.eINSTANCE;
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
  protected IconsetSwitch<Adapter> modelSwitch =
    new IconsetSwitch<Adapter>() {
			@Override
			public Adapter caseIconSet(IconSet object) {
				return createIconSetAdapter();
			}
			@Override
			public Adapter caseIconSize(IconSize object) {
				return createIconSizeAdapter();
			}
			@Override
			public Adapter caseIconDescriptor(IconDescriptor object) {
				return createIconDescriptorAdapter();
			}
			@Override
			public Adapter caseIconData(IconData object) {
				return createIconDataAdapter();
			}
			@Override
			public Adapter caseIconInfo(IconInfo object) {
				return createIconInfoAdapter();
			}
			@Override
			public Adapter caseIconDefinition(IconDefinition object) {
				return createIconDefinitionAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.genivi.iconset.IconSet <em>Icon Set</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.iconset.IconSet
	 * @generated
	 */
  public Adapter createIconSetAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.iconset.IconSize <em>Icon Size</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.iconset.IconSize
	 * @generated
	 */
  public Adapter createIconSizeAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.iconset.IconDescriptor <em>Icon Descriptor</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.iconset.IconDescriptor
	 * @generated
	 */
  public Adapter createIconDescriptorAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.iconset.IconData <em>Icon Data</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.iconset.IconData
	 * @generated
	 */
  public Adapter createIconDataAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.iconset.IconInfo <em>Icon Info</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.iconset.IconInfo
	 * @generated
	 */
  public Adapter createIconInfoAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.iconset.IconDefinition <em>Icon Definition</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.iconset.IconDefinition
	 * @generated
	 */
  public Adapter createIconDefinitionAdapter() {
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

} //IconsetAdapterFactory
