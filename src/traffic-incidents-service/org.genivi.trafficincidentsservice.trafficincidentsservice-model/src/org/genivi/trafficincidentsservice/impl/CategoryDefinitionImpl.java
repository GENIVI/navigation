/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.genivi.common.LocalizedString;
import org.genivi.iconset.IconInfo;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.trafficincidentsservicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.impl.CategoryDefinitionImpl#getLocalizedNamesList <em>Localized Names</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.impl.CategoryDefinitionImpl#getCategoryId <em>Category Id</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.impl.CategoryDefinitionImpl#getIconsList <em>Icons</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.impl.CategoryDefinitionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CategoryDefinitionImpl extends EObjectImpl implements CategoryDefinition {
  /**
	 * The cached value of the '{@link #getLocalizedNamesList() <em>Localized Names</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocalizedNamesList()
	 * @generated
	 * @ordered
	 */
  protected EList<LocalizedString> localizedNames;

  /**
	 * The empty value for the '{@link #getLocalizedNames() <em>Localized Names</em>}' array accessor.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocalizedNames()
	 * @generated
	 * @ordered
	 */
  protected static final LocalizedString[] LOCALIZED_NAMES_EEMPTY_ARRAY = new LocalizedString [0];

  /**
	 * The default value of the '{@link #getCategoryId() <em>Category Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCategoryId()
	 * @generated
	 * @ordered
	 */
  protected static final int CATEGORY_ID_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getCategoryId() <em>Category Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCategoryId()
	 * @generated
	 * @ordered
	 */
  protected int categoryId = CATEGORY_ID_EDEFAULT;

  /**
	 * The cached value of the '{@link #getIconsList() <em>Icons</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIconsList()
	 * @generated
	 * @ordered
	 */
  protected EList<IconInfo> icons;

  /**
	 * The empty value for the '{@link #getIcons() <em>Icons</em>}' array accessor.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIcons()
	 * @generated
	 * @ordered
	 */
  protected static final IconInfo[] ICONS_EEMPTY_ARRAY = new IconInfo [0];

  /**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
  protected static final String EXPRESSION_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
  protected String expression = EXPRESSION_EDEFAULT;

  /**
	 * This is true if the Expression attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean expressionESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CategoryDefinitionImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return trafficincidentsservicePackage.Literals.CATEGORY_DEFINITION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LocalizedString[] getLocalizedNames() {
		if (localizedNames == null || localizedNames.isEmpty()) return LOCALIZED_NAMES_EEMPTY_ARRAY;
		BasicEList<LocalizedString> list = (BasicEList<LocalizedString>)localizedNames;
		list.shrink();
		return (LocalizedString[])list.data();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LocalizedString getLocalizedNames(int index) {
		return getLocalizedNamesList().get(index);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getLocalizedNamesLength() {
		return localizedNames == null ? 0 : localizedNames.size();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLocalizedNames(LocalizedString[] newLocalizedNames) {
		((BasicEList<LocalizedString>)getLocalizedNamesList()).setData(newLocalizedNames.length, newLocalizedNames);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLocalizedNames(int index, LocalizedString element) {
		getLocalizedNamesList().set(index, element);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<LocalizedString> getLocalizedNamesList() {
		if (localizedNames == null) {
			localizedNames = new EObjectContainmentEList<LocalizedString>(LocalizedString.class, this, trafficincidentsservicePackage.CATEGORY_DEFINITION__LOCALIZED_NAMES);
		}
		return localizedNames;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getCategoryId() {
		return categoryId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCategoryId(int newCategoryId) {
		int oldCategoryId = categoryId;
		categoryId = newCategoryId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentsservicePackage.CATEGORY_DEFINITION__CATEGORY_ID, oldCategoryId, categoryId));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconInfo[] getIcons() {
		if (icons == null || icons.isEmpty()) return ICONS_EEMPTY_ARRAY;
		BasicEList<IconInfo> list = (BasicEList<IconInfo>)icons;
		list.shrink();
		return (IconInfo[])list.data();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconInfo getIcons(int index) {
		return getIconsList().get(index);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getIconsLength() {
		return icons == null ? 0 : icons.size();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setIcons(IconInfo[] newIcons) {
		((BasicEList<IconInfo>)getIconsList()).setData(newIcons.length, newIcons);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setIcons(int index, IconInfo element) {
		getIconsList().set(index, element);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<IconInfo> getIconsList() {
		if (icons == null) {
			icons = new EObjectContainmentEList<IconInfo>(IconInfo.class, this, trafficincidentsservicePackage.CATEGORY_DEFINITION__ICONS);
		}
		return icons;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getExpression() {
		return expression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		boolean oldExpressionESet = expressionESet;
		expressionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentsservicePackage.CATEGORY_DEFINITION__EXPRESSION, oldExpression, expression, !oldExpressionESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetExpression() {
		String oldExpression = expression;
		boolean oldExpressionESet = expressionESet;
		expression = EXPRESSION_EDEFAULT;
		expressionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentsservicePackage.CATEGORY_DEFINITION__EXPRESSION, oldExpression, EXPRESSION_EDEFAULT, oldExpressionESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetExpression() {
		return expressionESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__LOCALIZED_NAMES:
				return ((InternalEList<?>)getLocalizedNamesList()).basicRemove(otherEnd, msgs);
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__ICONS:
				return ((InternalEList<?>)getIconsList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__LOCALIZED_NAMES:
				return getLocalizedNamesList();
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__CATEGORY_ID:
				return getCategoryId();
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__ICONS:
				return getIconsList();
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__EXPRESSION:
				return getExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__LOCALIZED_NAMES:
				getLocalizedNamesList().clear();
				getLocalizedNamesList().addAll((Collection<? extends LocalizedString>)newValue);
				return;
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__CATEGORY_ID:
				setCategoryId((Integer)newValue);
				return;
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__ICONS:
				getIconsList().clear();
				getIconsList().addAll((Collection<? extends IconInfo>)newValue);
				return;
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__EXPRESSION:
				setExpression((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__LOCALIZED_NAMES:
				getLocalizedNamesList().clear();
				return;
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__CATEGORY_ID:
				setCategoryId(CATEGORY_ID_EDEFAULT);
				return;
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__ICONS:
				getIconsList().clear();
				return;
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__EXPRESSION:
				unsetExpression();
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__LOCALIZED_NAMES:
				return localizedNames != null && !localizedNames.isEmpty();
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__CATEGORY_ID:
				return categoryId != CATEGORY_ID_EDEFAULT;
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__ICONS:
				return icons != null && !icons.isEmpty();
			case trafficincidentsservicePackage.CATEGORY_DEFINITION__EXPRESSION:
				return isSetExpression();
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (categoryId: ");
		result.append(categoryId);
		result.append(", expression: ");
		if (expressionESet) result.append(expression); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //CategoryDefinitionImpl
