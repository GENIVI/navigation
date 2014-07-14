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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Icon Size</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.iconset.IconSize#getWidth <em>Width</em>}</li>
 *   <li>{@link org.genivi.iconset.IconSize#getHeight <em>Height</em>}</li>
 *   <li>{@link org.genivi.iconset.IconSize#getDpi <em>Dpi</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.iconset.IconsetPackage#getIconSize()
 * @model
 * @generated
 */
public interface IconSize extends EObject {
  /**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Width</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #isSetWidth()
	 * @see #unsetWidth()
	 * @see #setWidth(int)
	 * @see org.genivi.iconset.IconsetPackage#getIconSize_Width()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  int getWidth();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconSize#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #isSetWidth()
	 * @see #unsetWidth()
	 * @see #getWidth()
	 * @generated
	 */
  void setWidth(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSize#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetWidth()
	 * @see #getWidth()
	 * @see #setWidth(int)
	 * @generated
	 */
  void unsetWidth();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSize#getWidth <em>Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Width</em>' attribute is set.
	 * @see #unsetWidth()
	 * @see #getWidth()
	 * @see #setWidth(int)
	 * @generated
	 */
  boolean isSetWidth();

  /**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Height</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #isSetHeight()
	 * @see #unsetHeight()
	 * @see #setHeight(int)
	 * @see org.genivi.iconset.IconsetPackage#getIconSize_Height()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  int getHeight();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconSize#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #isSetHeight()
	 * @see #unsetHeight()
	 * @see #getHeight()
	 * @generated
	 */
  void setHeight(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSize#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetHeight()
	 * @see #getHeight()
	 * @see #setHeight(int)
	 * @generated
	 */
  void unsetHeight();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSize#getHeight <em>Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Height</em>' attribute is set.
	 * @see #unsetHeight()
	 * @see #getHeight()
	 * @see #setHeight(int)
	 * @generated
	 */
  boolean isSetHeight();

  /**
	 * Returns the value of the '<em><b>Dpi</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dpi</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Dpi</em>' attribute.
	 * @see #isSetDpi()
	 * @see #unsetDpi()
	 * @see #setDpi(int)
	 * @see org.genivi.iconset.IconsetPackage#getIconSize_Dpi()
	 * @model unsettable="true"
	 * @generated
	 */
  int getDpi();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconSize#getDpi <em>Dpi</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dpi</em>' attribute.
	 * @see #isSetDpi()
	 * @see #unsetDpi()
	 * @see #getDpi()
	 * @generated
	 */
  void setDpi(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconSize#getDpi <em>Dpi</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetDpi()
	 * @see #getDpi()
	 * @see #setDpi(int)
	 * @generated
	 */
  void unsetDpi();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconSize#getDpi <em>Dpi</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dpi</em>' attribute is set.
	 * @see #unsetDpi()
	 * @see #getDpi()
	 * @see #setDpi(int)
	 * @generated
	 */
  boolean isSetDpi();

} // IconSize
