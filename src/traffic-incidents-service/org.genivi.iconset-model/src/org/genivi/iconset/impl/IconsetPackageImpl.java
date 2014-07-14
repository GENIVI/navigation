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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genivi.iconset.ColorType;
import org.genivi.iconset.IconData;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconDescriptor;
import org.genivi.iconset.IconDimension;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.iconset.IconSize;
import org.genivi.iconset.IconsetFactory;
import org.genivi.iconset.IconsetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IconsetPackageImpl extends EPackageImpl implements IconsetPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass iconSetEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass iconSizeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass iconDescriptorEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass iconDataEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass iconInfoEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass iconDefinitionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum colorTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum iconDimensionEEnum = null;

  /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.genivi.iconset.IconsetPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private IconsetPackageImpl() {
		super(eNS_URI, IconsetFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link IconsetPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static IconsetPackage init() {
		if (isInited) return (IconsetPackage)EPackage.Registry.INSTANCE.getEPackage(IconsetPackage.eNS_URI);

		// Obtain or create and register package
		IconsetPackageImpl theIconsetPackage = (IconsetPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof IconsetPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new IconsetPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theIconsetPackage.createPackageContents();

		// Initialize created meta-data
		theIconsetPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIconsetPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IconsetPackage.eNS_URI, theIconsetPackage);
		return theIconsetPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getIconSet() {
		return iconSetEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconSet_IconSetId() {
		return (EAttribute)iconSetEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconSet_ColorType() {
		return (EAttribute)iconSetEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconSet_Dimension() {
		return (EAttribute)iconSetEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getIconSet_Size() {
		return (EReference)iconSetEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconSet_DayTimeIcon() {
		return (EAttribute)iconSetEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconSet_ThemeId() {
		return (EAttribute)iconSetEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconSet_MediumType() {
		return (EAttribute)iconSetEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getIconSet_IconDescriptors() {
		return (EReference)iconSetEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getIconSize() {
		return iconSizeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconSize_Width() {
		return (EAttribute)iconSizeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconSize_Height() {
		return (EAttribute)iconSizeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconSize_Dpi() {
		return (EAttribute)iconSizeEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getIconDescriptor() {
		return iconDescriptorEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconDescriptor_Url() {
		return (EAttribute)iconDescriptorEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconDescriptor_IconId() {
		return (EAttribute)iconDescriptorEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getIconData() {
		return iconDataEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconData_Data() {
		return (EAttribute)iconDataEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getIconInfo() {
		return iconInfoEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconInfo_IconSetId() {
		return (EAttribute)iconInfoEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getIconInfo_IconId() {
		return (EAttribute)iconInfoEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getIconDefinition() {
		return iconDefinitionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getIconDefinition_IconInfo() {
		return (EReference)iconDefinitionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getIconDefinition_IconData() {
		return (EReference)iconDefinitionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getColorType() {
		return colorTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getIconDimension() {
		return iconDimensionEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconsetFactory getIconsetFactory() {
		return (IconsetFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		iconSetEClass = createEClass(ICON_SET);
		createEAttribute(iconSetEClass, ICON_SET__ICON_SET_ID);
		createEAttribute(iconSetEClass, ICON_SET__COLOR_TYPE);
		createEAttribute(iconSetEClass, ICON_SET__DIMENSION);
		createEReference(iconSetEClass, ICON_SET__SIZE);
		createEAttribute(iconSetEClass, ICON_SET__DAY_TIME_ICON);
		createEAttribute(iconSetEClass, ICON_SET__THEME_ID);
		createEAttribute(iconSetEClass, ICON_SET__MEDIUM_TYPE);
		createEReference(iconSetEClass, ICON_SET__ICON_DESCRIPTORS);

		iconSizeEClass = createEClass(ICON_SIZE);
		createEAttribute(iconSizeEClass, ICON_SIZE__WIDTH);
		createEAttribute(iconSizeEClass, ICON_SIZE__HEIGHT);
		createEAttribute(iconSizeEClass, ICON_SIZE__DPI);

		iconDescriptorEClass = createEClass(ICON_DESCRIPTOR);
		createEAttribute(iconDescriptorEClass, ICON_DESCRIPTOR__URL);
		createEAttribute(iconDescriptorEClass, ICON_DESCRIPTOR__ICON_ID);

		iconDataEClass = createEClass(ICON_DATA);
		createEAttribute(iconDataEClass, ICON_DATA__DATA);

		iconInfoEClass = createEClass(ICON_INFO);
		createEAttribute(iconInfoEClass, ICON_INFO__ICON_SET_ID);
		createEAttribute(iconInfoEClass, ICON_INFO__ICON_ID);

		iconDefinitionEClass = createEClass(ICON_DEFINITION);
		createEReference(iconDefinitionEClass, ICON_DEFINITION__ICON_INFO);
		createEReference(iconDefinitionEClass, ICON_DEFINITION__ICON_DATA);

		// Create enums
		colorTypeEEnum = createEEnum(COLOR_TYPE);
		iconDimensionEEnum = createEEnum(ICON_DIMENSION);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(iconSetEClass, IconSet.class, "IconSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIconSet_IconSetId(), ecorePackage.getEInt(), "iconSetId", null, 1, 1, IconSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconSet_ColorType(), this.getColorType(), "colorType", null, 1, 1, IconSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconSet_Dimension(), this.getIconDimension(), "dimension", null, 0, 1, IconSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIconSet_Size(), this.getIconSize(), null, "size", null, 1, 1, IconSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconSet_DayTimeIcon(), ecorePackage.getEBoolean(), "dayTimeIcon", null, 1, 1, IconSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconSet_ThemeId(), ecorePackage.getEInt(), "themeId", null, 0, 1, IconSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconSet_MediumType(), ecorePackage.getEString(), "mediumType", null, 1, 1, IconSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIconSet_IconDescriptors(), this.getIconDescriptor(), null, "iconDescriptors", null, 0, -1, IconSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iconSizeEClass, IconSize.class, "IconSize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIconSize_Width(), ecorePackage.getEInt(), "width", null, 1, 1, IconSize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconSize_Height(), ecorePackage.getEInt(), "height", null, 1, 1, IconSize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconSize_Dpi(), ecorePackage.getEInt(), "dpi", null, 0, 1, IconSize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iconDescriptorEClass, IconDescriptor.class, "IconDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIconDescriptor_Url(), ecorePackage.getEString(), "url", null, 0, 1, IconDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconDescriptor_IconId(), ecorePackage.getEInt(), "iconId", null, 1, 1, IconDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iconDataEClass, IconData.class, "IconData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIconData_Data(), ecorePackage.getEByteArray(), "data", null, 0, 1, IconData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iconInfoEClass, IconInfo.class, "IconInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIconInfo_IconSetId(), ecorePackage.getEInt(), "iconSetId", null, 1, 1, IconInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconInfo_IconId(), ecorePackage.getEInt(), "iconId", null, 1, 1, IconInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iconDefinitionEClass, IconDefinition.class, "IconDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIconDefinition_IconInfo(), this.getIconInfo(), null, "iconInfo", null, 1, 1, IconDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIconDefinition_IconData(), this.getIconData(), null, "iconData", null, 1, 1, IconDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(colorTypeEEnum, ColorType.class, "ColorType");
		addEEnumLiteral(colorTypeEEnum, ColorType.BLACK_AND_WHITE);
		addEEnumLiteral(colorTypeEEnum, ColorType.GRAY_4);
		addEEnumLiteral(colorTypeEEnum, ColorType.GRAY_8);
		addEEnumLiteral(colorTypeEEnum, ColorType.RGB555);
		addEEnumLiteral(colorTypeEEnum, ColorType.RGB565);
		addEEnumLiteral(colorTypeEEnum, ColorType.RGB888);

		initEEnum(iconDimensionEEnum, IconDimension.class, "IconDimension");
		addEEnumLiteral(iconDimensionEEnum, IconDimension.D2D);
		addEEnumLiteral(iconDimensionEEnum, IconDimension.D25D);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// GenModel
		createGenModelAnnotations();
	}

		/**
	 * Initializes the annotations for <b>GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "GenModel";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "documentation", "Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/."
		   });
	}

} //IconsetPackageImpl
