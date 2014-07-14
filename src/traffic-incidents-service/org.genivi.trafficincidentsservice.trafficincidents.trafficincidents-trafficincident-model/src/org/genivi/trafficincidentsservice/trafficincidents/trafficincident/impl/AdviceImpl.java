/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.AdviceImpl#getMainAdvice <em>Main Advice</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.AdviceImpl#getSubAdvice <em>Sub Advice</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.AdviceImpl#getApplicability <em>Applicability</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.AdviceImpl#getFreeText <em>Free Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdviceImpl extends EObjectImpl implements Advice {
  /**
	 * The default value of the '{@link #getMainAdvice() <em>Main Advice</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMainAdvice()
	 * @generated
	 * @ordered
	 */
  protected static final AdviceCode MAIN_ADVICE_EDEFAULT = AdviceCode.DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE;

  /**
	 * The cached value of the '{@link #getMainAdvice() <em>Main Advice</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMainAdvice()
	 * @generated
	 * @ordered
	 */
  protected AdviceCode mainAdvice = MAIN_ADVICE_EDEFAULT;

  /**
	 * This is true if the Main Advice attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean mainAdviceESet;

  /**
	 * The default value of the '{@link #getSubAdvice() <em>Sub Advice</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSubAdvice()
	 * @generated
	 * @ordered
	 */
  protected static final Object SUB_ADVICE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getSubAdvice() <em>Sub Advice</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSubAdvice()
	 * @generated
	 * @ordered
	 */
  protected Object subAdvice = SUB_ADVICE_EDEFAULT;

  /**
	 * This is true if the Sub Advice attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean subAdviceESet;

  /**
	 * The cached value of the '{@link #getApplicability() <em>Applicability</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getApplicability()
	 * @generated
	 * @ordered
	 */
  protected EList<Applicability> applicability;

  /**
	 * The default value of the '{@link #getFreeText() <em>Free Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFreeText()
	 * @generated
	 * @ordered
	 */
  protected static final String FREE_TEXT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getFreeText() <em>Free Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFreeText()
	 * @generated
	 * @ordered
	 */
  protected String freeText = FREE_TEXT_EDEFAULT;

  /**
	 * This is true if the Free Text attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean freeTextESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AdviceImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return trafficincidentPackage.Literals.ADVICE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AdviceCode getMainAdvice() {
		return mainAdvice;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMainAdvice(AdviceCode newMainAdvice) {
		AdviceCode oldMainAdvice = mainAdvice;
		mainAdvice = newMainAdvice == null ? MAIN_ADVICE_EDEFAULT : newMainAdvice;
		boolean oldMainAdviceESet = mainAdviceESet;
		mainAdviceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.ADVICE__MAIN_ADVICE, oldMainAdvice, mainAdvice, !oldMainAdviceESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetMainAdvice() {
		AdviceCode oldMainAdvice = mainAdvice;
		boolean oldMainAdviceESet = mainAdviceESet;
		mainAdvice = MAIN_ADVICE_EDEFAULT;
		mainAdviceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.ADVICE__MAIN_ADVICE, oldMainAdvice, MAIN_ADVICE_EDEFAULT, oldMainAdviceESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetMainAdvice() {
		return mainAdviceESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object getSubAdvice() {
		return subAdvice;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSubAdvice(Object newSubAdvice) {
		Object oldSubAdvice = subAdvice;
		subAdvice = newSubAdvice;
		boolean oldSubAdviceESet = subAdviceESet;
		subAdviceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.ADVICE__SUB_ADVICE, oldSubAdvice, subAdvice, !oldSubAdviceESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetSubAdvice() {
		Object oldSubAdvice = subAdvice;
		boolean oldSubAdviceESet = subAdviceESet;
		subAdvice = SUB_ADVICE_EDEFAULT;
		subAdviceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.ADVICE__SUB_ADVICE, oldSubAdvice, SUB_ADVICE_EDEFAULT, oldSubAdviceESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetSubAdvice() {
		return subAdviceESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Applicability> getApplicability() {
		if (applicability == null) {
			applicability = new EObjectContainmentEList.Unsettable<Applicability>(Applicability.class, this, trafficincidentPackage.ADVICE__APPLICABILITY);
		}
		return applicability;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetApplicability() {
		if (applicability != null) ((InternalEList.Unsettable<?>)applicability).unset();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetApplicability() {
		return applicability != null && ((InternalEList.Unsettable<?>)applicability).isSet();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getFreeText() {
		return freeText;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFreeText(String newFreeText) {
		String oldFreeText = freeText;
		freeText = newFreeText;
		boolean oldFreeTextESet = freeTextESet;
		freeTextESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.ADVICE__FREE_TEXT, oldFreeText, freeText, !oldFreeTextESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetFreeText() {
		String oldFreeText = freeText;
		boolean oldFreeTextESet = freeTextESet;
		freeText = FREE_TEXT_EDEFAULT;
		freeTextESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.ADVICE__FREE_TEXT, oldFreeText, FREE_TEXT_EDEFAULT, oldFreeTextESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetFreeText() {
		return freeTextESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trafficincidentPackage.ADVICE__APPLICABILITY:
				return ((InternalEList<?>)getApplicability()).basicRemove(otherEnd, msgs);
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
			case trafficincidentPackage.ADVICE__MAIN_ADVICE:
				return getMainAdvice();
			case trafficincidentPackage.ADVICE__SUB_ADVICE:
				return getSubAdvice();
			case trafficincidentPackage.ADVICE__APPLICABILITY:
				return getApplicability();
			case trafficincidentPackage.ADVICE__FREE_TEXT:
				return getFreeText();
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
			case trafficincidentPackage.ADVICE__MAIN_ADVICE:
				setMainAdvice((AdviceCode)newValue);
				return;
			case trafficincidentPackage.ADVICE__SUB_ADVICE:
				setSubAdvice(newValue);
				return;
			case trafficincidentPackage.ADVICE__APPLICABILITY:
				getApplicability().clear();
				getApplicability().addAll((Collection<? extends Applicability>)newValue);
				return;
			case trafficincidentPackage.ADVICE__FREE_TEXT:
				setFreeText((String)newValue);
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
			case trafficincidentPackage.ADVICE__MAIN_ADVICE:
				unsetMainAdvice();
				return;
			case trafficincidentPackage.ADVICE__SUB_ADVICE:
				unsetSubAdvice();
				return;
			case trafficincidentPackage.ADVICE__APPLICABILITY:
				unsetApplicability();
				return;
			case trafficincidentPackage.ADVICE__FREE_TEXT:
				unsetFreeText();
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
			case trafficincidentPackage.ADVICE__MAIN_ADVICE:
				return isSetMainAdvice();
			case trafficincidentPackage.ADVICE__SUB_ADVICE:
				return isSetSubAdvice();
			case trafficincidentPackage.ADVICE__APPLICABILITY:
				return isSetApplicability();
			case trafficincidentPackage.ADVICE__FREE_TEXT:
				return isSetFreeText();
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
		result.append(" (mainAdvice: ");
		if (mainAdviceESet) result.append(mainAdvice); else result.append("<unset>");
		result.append(", subAdvice: ");
		if (subAdviceESet) result.append(subAdvice); else result.append("<unset>");
		result.append(", freeText: ");
		if (freeTextESet) result.append(freeText); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //AdviceImpl
