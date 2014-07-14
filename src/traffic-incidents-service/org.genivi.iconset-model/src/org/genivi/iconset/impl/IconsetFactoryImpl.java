/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.iconset.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genivi.iconset.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IconsetFactoryImpl extends EFactoryImpl implements IconsetFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static IconsetFactory init() {
		try {
			IconsetFactory theIconsetFactory = (IconsetFactory)EPackage.Registry.INSTANCE.getEFactory(IconsetPackage.eNS_URI);
			if (theIconsetFactory != null) {
				return theIconsetFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IconsetFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconsetFactoryImpl() {
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
			case IconsetPackage.ICON_SET: return createIconSet();
			case IconsetPackage.ICON_SIZE: return createIconSize();
			case IconsetPackage.ICON_DESCRIPTOR: return createIconDescriptor();
			case IconsetPackage.ICON_DATA: return createIconData();
			case IconsetPackage.ICON_INFO: return createIconInfo();
			case IconsetPackage.ICON_DEFINITION: return createIconDefinition();
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
			case IconsetPackage.COLOR_TYPE:
				return createColorTypeFromString(eDataType, initialValue);
			case IconsetPackage.ICON_DIMENSION:
				return createIconDimensionFromString(eDataType, initialValue);
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
			case IconsetPackage.COLOR_TYPE:
				return convertColorTypeToString(eDataType, instanceValue);
			case IconsetPackage.ICON_DIMENSION:
				return convertIconDimensionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconSet createIconSet() {
		IconSetImpl iconSet = new IconSetImpl();
		return iconSet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconSize createIconSize() {
		IconSizeImpl iconSize = new IconSizeImpl();
		return iconSize;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconDescriptor createIconDescriptor() {
		IconDescriptorImpl iconDescriptor = new IconDescriptorImpl();
		return iconDescriptor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconData createIconData() {
		IconDataImpl iconData = new IconDataImpl();
		return iconData;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconInfo createIconInfo() {
		IconInfoImpl iconInfo = new IconInfoImpl();
		return iconInfo;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconDefinition createIconDefinition() {
		IconDefinitionImpl iconDefinition = new IconDefinitionImpl();
		return iconDefinition;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ColorType createColorTypeFromString(EDataType eDataType, String initialValue) {
		ColorType result = ColorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertColorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconDimension createIconDimensionFromString(EDataType eDataType, String initialValue) {
		IconDimension result = IconDimension.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertIconDimensionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconsetPackage getIconsetPackage() {
		return (IconsetPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static IconsetPackage getPackage() {
		return IconsetPackage.eINSTANCE;
	}

} //IconsetFactoryImpl
