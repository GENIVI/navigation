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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.genivi.iconset.IconsetFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface IconsetPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "iconset";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://org.genivi.iconset";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "iconset";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  IconsetPackage eINSTANCE = org.genivi.iconset.impl.IconsetPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.genivi.iconset.impl.IconSetImpl <em>Icon Set</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.iconset.impl.IconSetImpl
	 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconSet()
	 * @generated
	 */
  int ICON_SET = 0;

  /**
	 * The feature id for the '<em><b>Icon Set Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SET__ICON_SET_ID = 0;

  /**
	 * The feature id for the '<em><b>Color Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SET__COLOR_TYPE = 1;

  /**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SET__DIMENSION = 2;

  /**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SET__SIZE = 3;

  /**
	 * The feature id for the '<em><b>Day Time Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SET__DAY_TIME_ICON = 4;

  /**
	 * The feature id for the '<em><b>Theme Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SET__THEME_ID = 5;

  /**
	 * The feature id for the '<em><b>Medium Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SET__MEDIUM_TYPE = 6;

  /**
	 * The feature id for the '<em><b>Icon Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SET__ICON_DESCRIPTORS = 7;

  /**
	 * The number of structural features of the '<em>Icon Set</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SET_FEATURE_COUNT = 8;

  /**
	 * The meta object id for the '{@link org.genivi.iconset.impl.IconSizeImpl <em>Icon Size</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.iconset.impl.IconSizeImpl
	 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconSize()
	 * @generated
	 */
  int ICON_SIZE = 1;

  /**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SIZE__WIDTH = 0;

  /**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SIZE__HEIGHT = 1;

  /**
	 * The feature id for the '<em><b>Dpi</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SIZE__DPI = 2;

  /**
	 * The number of structural features of the '<em>Icon Size</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_SIZE_FEATURE_COUNT = 3;

  /**
	 * The meta object id for the '{@link org.genivi.iconset.impl.IconDescriptorImpl <em>Icon Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.iconset.impl.IconDescriptorImpl
	 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconDescriptor()
	 * @generated
	 */
  int ICON_DESCRIPTOR = 2;

  /**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_DESCRIPTOR__URL = 0;

  /**
	 * The feature id for the '<em><b>Icon Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_DESCRIPTOR__ICON_ID = 1;

  /**
	 * The number of structural features of the '<em>Icon Descriptor</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_DESCRIPTOR_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.genivi.iconset.impl.IconDataImpl <em>Icon Data</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.iconset.impl.IconDataImpl
	 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconData()
	 * @generated
	 */
  int ICON_DATA = 3;

  /**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_DATA__DATA = 0;

  /**
	 * The number of structural features of the '<em>Icon Data</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_DATA_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link org.genivi.iconset.impl.IconInfoImpl <em>Icon Info</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.iconset.impl.IconInfoImpl
	 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconInfo()
	 * @generated
	 */
  int ICON_INFO = 4;

  /**
	 * The feature id for the '<em><b>Icon Set Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_INFO__ICON_SET_ID = 0;

  /**
	 * The feature id for the '<em><b>Icon Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_INFO__ICON_ID = 1;

  /**
	 * The number of structural features of the '<em>Icon Info</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_INFO_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.genivi.iconset.impl.IconDefinitionImpl <em>Icon Definition</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.iconset.impl.IconDefinitionImpl
	 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconDefinition()
	 * @generated
	 */
  int ICON_DEFINITION = 5;

  /**
	 * The feature id for the '<em><b>Icon Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_DEFINITION__ICON_INFO = 0;

  /**
	 * The feature id for the '<em><b>Icon Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_DEFINITION__ICON_DATA = 1;

  /**
	 * The number of structural features of the '<em>Icon Definition</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ICON_DEFINITION_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.genivi.iconset.ColorType <em>Color Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.iconset.ColorType
	 * @see org.genivi.iconset.impl.IconsetPackageImpl#getColorType()
	 * @generated
	 */
  int COLOR_TYPE = 6;

  /**
	 * The meta object id for the '{@link org.genivi.iconset.IconDimension <em>Icon Dimension</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.iconset.IconDimension
	 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconDimension()
	 * @generated
	 */
  int ICON_DIMENSION = 7;


  /**
	 * Returns the meta object for class '{@link org.genivi.iconset.IconSet <em>Icon Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon Set</em>'.
	 * @see org.genivi.iconset.IconSet
	 * @generated
	 */
  EClass getIconSet();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconSet#getIconSetId <em>Icon Set Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Set Id</em>'.
	 * @see org.genivi.iconset.IconSet#getIconSetId()
	 * @see #getIconSet()
	 * @generated
	 */
  EAttribute getIconSet_IconSetId();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconSet#getColorType <em>Color Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Type</em>'.
	 * @see org.genivi.iconset.IconSet#getColorType()
	 * @see #getIconSet()
	 * @generated
	 */
  EAttribute getIconSet_ColorType();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconSet#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimension</em>'.
	 * @see org.genivi.iconset.IconSet#getDimension()
	 * @see #getIconSet()
	 * @generated
	 */
  EAttribute getIconSet_Dimension();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.iconset.IconSet#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size</em>'.
	 * @see org.genivi.iconset.IconSet#getSize()
	 * @see #getIconSet()
	 * @generated
	 */
  EReference getIconSet_Size();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconSet#isDayTimeIcon <em>Day Time Icon</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Day Time Icon</em>'.
	 * @see org.genivi.iconset.IconSet#isDayTimeIcon()
	 * @see #getIconSet()
	 * @generated
	 */
  EAttribute getIconSet_DayTimeIcon();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconSet#getThemeId <em>Theme Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Theme Id</em>'.
	 * @see org.genivi.iconset.IconSet#getThemeId()
	 * @see #getIconSet()
	 * @generated
	 */
  EAttribute getIconSet_ThemeId();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconSet#getMediumType <em>Medium Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Medium Type</em>'.
	 * @see org.genivi.iconset.IconSet#getMediumType()
	 * @see #getIconSet()
	 * @generated
	 */
  EAttribute getIconSet_MediumType();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.iconset.IconSet#getIconDescriptors <em>Icon Descriptors</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icon Descriptors</em>'.
	 * @see org.genivi.iconset.IconSet#getIconDescriptors()
	 * @see #getIconSet()
	 * @generated
	 */
  EReference getIconSet_IconDescriptors();

  /**
	 * Returns the meta object for class '{@link org.genivi.iconset.IconSize <em>Icon Size</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon Size</em>'.
	 * @see org.genivi.iconset.IconSize
	 * @generated
	 */
  EClass getIconSize();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconSize#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.genivi.iconset.IconSize#getWidth()
	 * @see #getIconSize()
	 * @generated
	 */
  EAttribute getIconSize_Width();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconSize#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.genivi.iconset.IconSize#getHeight()
	 * @see #getIconSize()
	 * @generated
	 */
  EAttribute getIconSize_Height();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconSize#getDpi <em>Dpi</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dpi</em>'.
	 * @see org.genivi.iconset.IconSize#getDpi()
	 * @see #getIconSize()
	 * @generated
	 */
  EAttribute getIconSize_Dpi();

  /**
	 * Returns the meta object for class '{@link org.genivi.iconset.IconDescriptor <em>Icon Descriptor</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon Descriptor</em>'.
	 * @see org.genivi.iconset.IconDescriptor
	 * @generated
	 */
  EClass getIconDescriptor();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconDescriptor#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.genivi.iconset.IconDescriptor#getUrl()
	 * @see #getIconDescriptor()
	 * @generated
	 */
  EAttribute getIconDescriptor_Url();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconDescriptor#getIconId <em>Icon Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Id</em>'.
	 * @see org.genivi.iconset.IconDescriptor#getIconId()
	 * @see #getIconDescriptor()
	 * @generated
	 */
  EAttribute getIconDescriptor_IconId();

  /**
	 * Returns the meta object for class '{@link org.genivi.iconset.IconData <em>Icon Data</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon Data</em>'.
	 * @see org.genivi.iconset.IconData
	 * @generated
	 */
  EClass getIconData();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconData#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.genivi.iconset.IconData#getData()
	 * @see #getIconData()
	 * @generated
	 */
  EAttribute getIconData_Data();

  /**
	 * Returns the meta object for class '{@link org.genivi.iconset.IconInfo <em>Icon Info</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon Info</em>'.
	 * @see org.genivi.iconset.IconInfo
	 * @generated
	 */
  EClass getIconInfo();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconInfo#getIconSetId <em>Icon Set Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Set Id</em>'.
	 * @see org.genivi.iconset.IconInfo#getIconSetId()
	 * @see #getIconInfo()
	 * @generated
	 */
  EAttribute getIconInfo_IconSetId();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.iconset.IconInfo#getIconId <em>Icon Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Id</em>'.
	 * @see org.genivi.iconset.IconInfo#getIconId()
	 * @see #getIconInfo()
	 * @generated
	 */
  EAttribute getIconInfo_IconId();

  /**
	 * Returns the meta object for class '{@link org.genivi.iconset.IconDefinition <em>Icon Definition</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon Definition</em>'.
	 * @see org.genivi.iconset.IconDefinition
	 * @generated
	 */
  EClass getIconDefinition();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.iconset.IconDefinition#getIconInfo <em>Icon Info</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icon Info</em>'.
	 * @see org.genivi.iconset.IconDefinition#getIconInfo()
	 * @see #getIconDefinition()
	 * @generated
	 */
  EReference getIconDefinition_IconInfo();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.iconset.IconDefinition#getIconData <em>Icon Data</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icon Data</em>'.
	 * @see org.genivi.iconset.IconDefinition#getIconData()
	 * @see #getIconDefinition()
	 * @generated
	 */
  EReference getIconDefinition_IconData();

  /**
	 * Returns the meta object for enum '{@link org.genivi.iconset.ColorType <em>Color Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Color Type</em>'.
	 * @see org.genivi.iconset.ColorType
	 * @generated
	 */
  EEnum getColorType();

  /**
	 * Returns the meta object for enum '{@link org.genivi.iconset.IconDimension <em>Icon Dimension</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Icon Dimension</em>'.
	 * @see org.genivi.iconset.IconDimension
	 * @generated
	 */
  EEnum getIconDimension();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  IconsetFactory getIconsetFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals {
    /**
		 * The meta object literal for the '{@link org.genivi.iconset.impl.IconSetImpl <em>Icon Set</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.iconset.impl.IconSetImpl
		 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconSet()
		 * @generated
		 */
    EClass ICON_SET = eINSTANCE.getIconSet();

    /**
		 * The meta object literal for the '<em><b>Icon Set Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_SET__ICON_SET_ID = eINSTANCE.getIconSet_IconSetId();

    /**
		 * The meta object literal for the '<em><b>Color Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_SET__COLOR_TYPE = eINSTANCE.getIconSet_ColorType();

    /**
		 * The meta object literal for the '<em><b>Dimension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_SET__DIMENSION = eINSTANCE.getIconSet_Dimension();

    /**
		 * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ICON_SET__SIZE = eINSTANCE.getIconSet_Size();

    /**
		 * The meta object literal for the '<em><b>Day Time Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_SET__DAY_TIME_ICON = eINSTANCE.getIconSet_DayTimeIcon();

    /**
		 * The meta object literal for the '<em><b>Theme Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_SET__THEME_ID = eINSTANCE.getIconSet_ThemeId();

    /**
		 * The meta object literal for the '<em><b>Medium Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_SET__MEDIUM_TYPE = eINSTANCE.getIconSet_MediumType();

    /**
		 * The meta object literal for the '<em><b>Icon Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ICON_SET__ICON_DESCRIPTORS = eINSTANCE.getIconSet_IconDescriptors();

    /**
		 * The meta object literal for the '{@link org.genivi.iconset.impl.IconSizeImpl <em>Icon Size</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.iconset.impl.IconSizeImpl
		 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconSize()
		 * @generated
		 */
    EClass ICON_SIZE = eINSTANCE.getIconSize();

    /**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_SIZE__WIDTH = eINSTANCE.getIconSize_Width();

    /**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_SIZE__HEIGHT = eINSTANCE.getIconSize_Height();

    /**
		 * The meta object literal for the '<em><b>Dpi</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_SIZE__DPI = eINSTANCE.getIconSize_Dpi();

    /**
		 * The meta object literal for the '{@link org.genivi.iconset.impl.IconDescriptorImpl <em>Icon Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.iconset.impl.IconDescriptorImpl
		 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconDescriptor()
		 * @generated
		 */
    EClass ICON_DESCRIPTOR = eINSTANCE.getIconDescriptor();

    /**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_DESCRIPTOR__URL = eINSTANCE.getIconDescriptor_Url();

    /**
		 * The meta object literal for the '<em><b>Icon Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_DESCRIPTOR__ICON_ID = eINSTANCE.getIconDescriptor_IconId();

    /**
		 * The meta object literal for the '{@link org.genivi.iconset.impl.IconDataImpl <em>Icon Data</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.iconset.impl.IconDataImpl
		 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconData()
		 * @generated
		 */
    EClass ICON_DATA = eINSTANCE.getIconData();

    /**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_DATA__DATA = eINSTANCE.getIconData_Data();

    /**
		 * The meta object literal for the '{@link org.genivi.iconset.impl.IconInfoImpl <em>Icon Info</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.iconset.impl.IconInfoImpl
		 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconInfo()
		 * @generated
		 */
    EClass ICON_INFO = eINSTANCE.getIconInfo();

    /**
		 * The meta object literal for the '<em><b>Icon Set Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_INFO__ICON_SET_ID = eINSTANCE.getIconInfo_IconSetId();

    /**
		 * The meta object literal for the '<em><b>Icon Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ICON_INFO__ICON_ID = eINSTANCE.getIconInfo_IconId();

    /**
		 * The meta object literal for the '{@link org.genivi.iconset.impl.IconDefinitionImpl <em>Icon Definition</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.iconset.impl.IconDefinitionImpl
		 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconDefinition()
		 * @generated
		 */
    EClass ICON_DEFINITION = eINSTANCE.getIconDefinition();

    /**
		 * The meta object literal for the '<em><b>Icon Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ICON_DEFINITION__ICON_INFO = eINSTANCE.getIconDefinition_IconInfo();

    /**
		 * The meta object literal for the '<em><b>Icon Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ICON_DEFINITION__ICON_DATA = eINSTANCE.getIconDefinition_IconData();

    /**
		 * The meta object literal for the '{@link org.genivi.iconset.ColorType <em>Color Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.iconset.ColorType
		 * @see org.genivi.iconset.impl.IconsetPackageImpl#getColorType()
		 * @generated
		 */
    EEnum COLOR_TYPE = eINSTANCE.getColorType();

    /**
		 * The meta object literal for the '{@link org.genivi.iconset.IconDimension <em>Icon Dimension</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.iconset.IconDimension
		 * @see org.genivi.iconset.impl.IconsetPackageImpl#getIconDimension()
		 * @generated
		 */
    EEnum ICON_DIMENSION = eINSTANCE.getIconDimension();

  }

} //IconsetPackage
