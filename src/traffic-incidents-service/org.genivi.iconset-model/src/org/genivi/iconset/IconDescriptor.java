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
 * A representation of the model object '<em><b>Icon Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.iconset.IconDescriptor#getUrl <em>Url</em>}</li>
 *   <li>{@link org.genivi.iconset.IconDescriptor#getIconId <em>Icon Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.iconset.IconsetPackage#getIconDescriptor()
 * @model
 * @generated
 */
public interface IconDescriptor extends EObject {
  /**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Url</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #isSetUrl()
	 * @see #unsetUrl()
	 * @see #setUrl(String)
	 * @see org.genivi.iconset.IconsetPackage#getIconDescriptor_Url()
	 * @model unsettable="true"
	 * @generated
	 */
  String getUrl();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconDescriptor#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #isSetUrl()
	 * @see #unsetUrl()
	 * @see #getUrl()
	 * @generated
	 */
  void setUrl(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconDescriptor#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetUrl()
	 * @see #getUrl()
	 * @see #setUrl(String)
	 * @generated
	 */
  void unsetUrl();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconDescriptor#getUrl <em>Url</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Url</em>' attribute is set.
	 * @see #unsetUrl()
	 * @see #getUrl()
	 * @see #setUrl(String)
	 * @generated
	 */
  boolean isSetUrl();

  /**
	 * Returns the value of the '<em><b>Icon Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Icon Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Id</em>' attribute.
	 * @see #isSetIconId()
	 * @see #unsetIconId()
	 * @see #setIconId(int)
	 * @see org.genivi.iconset.IconsetPackage#getIconDescriptor_IconId()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  int getIconId();

  /**
	 * Sets the value of the '{@link org.genivi.iconset.IconDescriptor#getIconId <em>Icon Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Id</em>' attribute.
	 * @see #isSetIconId()
	 * @see #unsetIconId()
	 * @see #getIconId()
	 * @generated
	 */
  void setIconId(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.iconset.IconDescriptor#getIconId <em>Icon Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetIconId()
	 * @see #getIconId()
	 * @see #setIconId(int)
	 * @generated
	 */
  void unsetIconId();

  /**
	 * Returns whether the value of the '{@link org.genivi.iconset.IconDescriptor#getIconId <em>Icon Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Icon Id</em>' attribute is set.
	 * @see #unsetIconId()
	 * @see #getIconId()
	 * @see #setIconId(int)
	 * @generated
	 */
  boolean isSetIconId();

} // IconDescriptor
