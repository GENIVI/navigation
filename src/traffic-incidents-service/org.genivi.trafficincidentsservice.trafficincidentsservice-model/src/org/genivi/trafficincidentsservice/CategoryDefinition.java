/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.genivi.common.LocalizedString;
import org.genivi.iconset.IconInfo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.CategoryDefinition#getLocalizedNamesList <em>Localized Names</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.CategoryDefinition#getCategoryId <em>Category Id</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.CategoryDefinition#getIconsList <em>Icons</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.CategoryDefinition#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getCategoryDefinition()
 * @model
 * @generated
 */
public interface CategoryDefinition extends EObject {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  LocalizedString[] getLocalizedNames();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  LocalizedString getLocalizedNames(int index);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  int getLocalizedNamesLength();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  void setLocalizedNames(LocalizedString[] newLocalizedNames);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  void setLocalizedNames(int index, LocalizedString element);

  /**
	 * Returns the value of the '<em><b>Localized Names</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.common.LocalizedString}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Localized Names</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Localized Names</em>' containment reference list.
	 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getCategoryDefinition_LocalizedNames()
	 * @model containment="true"
	 * @generated
	 */
  EList<LocalizedString> getLocalizedNamesList();

  /**
	 * Returns the value of the '<em><b>Category Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Category Id</em>' attribute.
	 * @see #setCategoryId(int)
	 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getCategoryDefinition_CategoryId()
	 * @model required="true"
	 * @generated
	 */
  int getCategoryId();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.CategoryDefinition#getCategoryId <em>Category Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category Id</em>' attribute.
	 * @see #getCategoryId()
	 * @generated
	 */
  void setCategoryId(int value);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  IconInfo[] getIcons();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  IconInfo getIcons(int index);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  int getIconsLength();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  void setIcons(IconInfo[] newIcons);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  void setIcons(int index, IconInfo element);

  /**
	 * Returns the value of the '<em><b>Icons</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.iconset.IconInfo}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Icons</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Icons</em>' containment reference list.
	 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getCategoryDefinition_Icons()
	 * @model containment="true"
	 * @generated
	 */
  EList<IconInfo> getIconsList();

  /**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #setExpression(String)
	 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getCategoryDefinition_Expression()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  String getExpression();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.CategoryDefinition#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @generated
	 */
  void setExpression(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.CategoryDefinition#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetExpression()
	 * @see #getExpression()
	 * @see #setExpression(String)
	 * @generated
	 */
  void unsetExpression();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.CategoryDefinition#getExpression <em>Expression</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expression</em>' attribute is set.
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @see #setExpression(String)
	 * @generated
	 */
  boolean isSetExpression();

} // CategoryDefinition
