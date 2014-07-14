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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Icon Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.iconset.IconSet#getIconSetId <em>Icon Set Id</em>}</li>
 *   <li>{@link org.genivi.iconset.IconSet#getColorType <em>Color Type</em>}</li>
 *   <li>{@link org.genivi.iconset.IconSet#getDimension <em>Dimension</em>}</li>
 *   <li>{@link org.genivi.iconset.IconSet#getSize <em>Size</em>}</li>
 *   <li>{@link org.genivi.iconset.IconSet#isDayTimeIcon <em>Day Time Icon</em>}</li>
 *   <li>{@link org.genivi.iconset.IconSet#getThemeId <em>Theme Id</em>}</li>
 *   <li>{@link org.genivi.iconset.IconSet#getMediumType <em>Medium Type</em>}</li>
 *   <li>{@link org.genivi.iconset.IconSet#getIconDescriptors <em>Icon Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.iconset.IconsetPackage#getIconSet()
 * @model
 * @generated
 */
public interface IconSet extends EObject {
  /**
	 * Returns the value of the '<em><b>Icon Set Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Icon Set Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Set Id</em>' attribute.
	 * @see #isSetIconSetId()
	 * @see #unsetIconSetId()
	 * @see #setIconSetId(int)
	 * @see org.genivi.iconset.IconsetPackage#getIconSet_IconSetId()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  int getIconSetId();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconSet#getIconSetId <em>Icon Set Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Set Id</em>' attribute.
	 * @see #isSetIconSetId()
	 * @see #unsetIconSetId()
	 * @see #getIconSetId()
	 * @generated
	 */
  void setIconSetId(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSet#getIconSetId <em>Icon Set Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetIconSetId()
	 * @see #getIconSetId()
	 * @see #setIconSetId(int)
	 * @generated
	 */
  void unsetIconSetId();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSet#getIconSetId <em>Icon Set Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Icon Set Id</em>' attribute is set.
	 * @see #unsetIconSetId()
	 * @see #getIconSetId()
	 * @see #setIconSetId(int)
	 * @generated
	 */
  boolean isSetIconSetId();

  /**
	 * Returns the value of the '<em><b>Color Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.iconset.ColorType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Color Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Type</em>' attribute.
	 * @see org.genivi.iconset.ColorType
	 * @see #isSetColorType()
	 * @see #unsetColorType()
	 * @see #setColorType(ColorType)
	 * @see org.genivi.iconset.IconsetPackage#getIconSet_ColorType()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  ColorType getColorType();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconSet#getColorType <em>Color Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Type</em>' attribute.
	 * @see org.genivi.iconset.ColorType
	 * @see #isSetColorType()
	 * @see #unsetColorType()
	 * @see #getColorType()
	 * @generated
	 */
  void setColorType(ColorType value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSet#getColorType <em>Color Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetColorType()
	 * @see #getColorType()
	 * @see #setColorType(ColorType)
	 * @generated
	 */
  void unsetColorType();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSet#getColorType <em>Color Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Color Type</em>' attribute is set.
	 * @see #unsetColorType()
	 * @see #getColorType()
	 * @see #setColorType(ColorType)
	 * @generated
	 */
  boolean isSetColorType();

  /**
	 * Returns the value of the '<em><b>Dimension</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.iconset.IconDimension}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dimension</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' attribute.
	 * @see org.genivi.iconset.IconDimension
	 * @see #isSetDimension()
	 * @see #unsetDimension()
	 * @see #setDimension(IconDimension)
	 * @see org.genivi.iconset.IconsetPackage#getIconSet_Dimension()
	 * @model unsettable="true"
	 * @generated
	 */
  IconDimension getDimension();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconSet#getDimension <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimension</em>' attribute.
	 * @see org.genivi.iconset.IconDimension
	 * @see #isSetDimension()
	 * @see #unsetDimension()
	 * @see #getDimension()
	 * @generated
	 */
  void setDimension(IconDimension value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSet#getDimension <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetDimension()
	 * @see #getDimension()
	 * @see #setDimension(IconDimension)
	 * @generated
	 */
  void unsetDimension();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSet#getDimension <em>Dimension</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dimension</em>' attribute is set.
	 * @see #unsetDimension()
	 * @see #getDimension()
	 * @see #setDimension(IconDimension)
	 * @generated
	 */
  boolean isSetDimension();

  /**
	 * Returns the value of the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Size</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' containment reference.
	 * @see #isSetSize()
	 * @see #unsetSize()
	 * @see #setSize(IconSize)
	 * @see org.genivi.iconset.IconsetPackage#getIconSet_Size()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  IconSize getSize();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconSet#getSize <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' containment reference.
	 * @see #isSetSize()
	 * @see #unsetSize()
	 * @see #getSize()
	 * @generated
	 */
  void setSize(IconSize value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSet#getSize <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSize()
	 * @see #getSize()
	 * @see #setSize(IconSize)
	 * @generated
	 */
  void unsetSize();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSet#getSize <em>Size</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Size</em>' containment reference is set.
	 * @see #unsetSize()
	 * @see #getSize()
	 * @see #setSize(IconSize)
	 * @generated
	 */
  boolean isSetSize();

  /**
	 * Returns the value of the '<em><b>Day Time Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Day Time Icon</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Day Time Icon</em>' attribute.
	 * @see #isSetDayTimeIcon()
	 * @see #unsetDayTimeIcon()
	 * @see #setDayTimeIcon(boolean)
	 * @see org.genivi.iconset.IconsetPackage#getIconSet_DayTimeIcon()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  boolean isDayTimeIcon();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconSet#isDayTimeIcon <em>Day Time Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day Time Icon</em>' attribute.
	 * @see #isSetDayTimeIcon()
	 * @see #unsetDayTimeIcon()
	 * @see #isDayTimeIcon()
	 * @generated
	 */
  void setDayTimeIcon(boolean value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSet#isDayTimeIcon <em>Day Time Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetDayTimeIcon()
	 * @see #isDayTimeIcon()
	 * @see #setDayTimeIcon(boolean)
	 * @generated
	 */
  void unsetDayTimeIcon();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSet#isDayTimeIcon <em>Day Time Icon</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Day Time Icon</em>' attribute is set.
	 * @see #unsetDayTimeIcon()
	 * @see #isDayTimeIcon()
	 * @see #setDayTimeIcon(boolean)
	 * @generated
	 */
  boolean isSetDayTimeIcon();

  /**
	 * Returns the value of the '<em><b>Theme Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Theme Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Theme Id</em>' attribute.
	 * @see #isSetThemeId()
	 * @see #unsetThemeId()
	 * @see #setThemeId(int)
	 * @see org.genivi.iconset.IconsetPackage#getIconSet_ThemeId()
	 * @model unsettable="true"
	 * @generated
	 */
  int getThemeId();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconSet#getThemeId <em>Theme Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Theme Id</em>' attribute.
	 * @see #isSetThemeId()
	 * @see #unsetThemeId()
	 * @see #getThemeId()
	 * @generated
	 */
  void setThemeId(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSet#getThemeId <em>Theme Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetThemeId()
	 * @see #getThemeId()
	 * @see #setThemeId(int)
	 * @generated
	 */
  void unsetThemeId();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSet#getThemeId <em>Theme Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Theme Id</em>' attribute is set.
	 * @see #unsetThemeId()
	 * @see #getThemeId()
	 * @see #setThemeId(int)
	 * @generated
	 */
  boolean isSetThemeId();

  /**
	 * Returns the value of the '<em><b>Medium Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Medium Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Medium Type</em>' attribute.
	 * @see #isSetMediumType()
	 * @see #unsetMediumType()
	 * @see #setMediumType(String)
	 * @see org.genivi.iconset.IconsetPackage#getIconSet_MediumType()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  String getMediumType();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconSet#getMediumType <em>Medium Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Medium Type</em>' attribute.
	 * @see #isSetMediumType()
	 * @see #unsetMediumType()
	 * @see #getMediumType()
	 * @generated
	 */
  void setMediumType(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSet#getMediumType <em>Medium Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetMediumType()
	 * @see #getMediumType()
	 * @see #setMediumType(String)
	 * @generated
	 */
  void unsetMediumType();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSet#getMediumType <em>Medium Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Medium Type</em>' attribute is set.
	 * @see #unsetMediumType()
	 * @see #getMediumType()
	 * @see #setMediumType(String)
	 * @generated
	 */
  boolean isSetMediumType();

  /**
	 * Returns the value of the '<em><b>Icon Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.iconset.IconDescriptor}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Icon Descriptors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Descriptors</em>' containment reference list.
	 * @see #isSetIconDescriptors()
	 * @see #unsetIconDescriptors()
	 * @see org.genivi.iconset.IconsetPackage#getIconSet_IconDescriptors()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<IconDescriptor> getIconDescriptors();

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSet#getIconDescriptors <em>Icon Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetIconDescriptors()
	 * @see #getIconDescriptors()
	 * @generated
	 */
  void unsetIconDescriptors();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSet#getIconDescriptors <em>Icon Descriptors</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Icon Descriptors</em>' containment reference list is set.
	 * @see #unsetIconDescriptors()
	 * @see #getIconDescriptors()
	 * @generated
	 */
  boolean isSetIconDescriptors();

} // IconSet
