/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.family.impl;

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

import org.genivi.family.Car;
import org.genivi.family.FamilyPackage;
import org.genivi.family.Person;
import org.genivi.family.Sexe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.family.impl.PersonImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.genivi.family.impl.PersonImpl#getSexe <em>Sexe</em>}</li>
 *   <li>{@link org.genivi.family.impl.PersonImpl#getOwnedCars <em>Owned Cars</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonImpl extends EObjectImpl implements Person {
  /**
	 * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
  protected static final String FIRST_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
  protected String firstName = FIRST_NAME_EDEFAULT;

  /**
	 * This is true if the First Name attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean firstNameESet;

  /**
	 * The default value of the '{@link #getSexe() <em>Sexe</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSexe()
	 * @generated
	 * @ordered
	 */
  protected static final Sexe SEXE_EDEFAULT = Sexe.MALE;

  /**
	 * The cached value of the '{@link #getSexe() <em>Sexe</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSexe()
	 * @generated
	 * @ordered
	 */
  protected Sexe sexe = SEXE_EDEFAULT;

  /**
	 * This is true if the Sexe attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean sexeESet;

  /**
	 * The cached value of the '{@link #getOwnedCars() <em>Owned Cars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOwnedCars()
	 * @generated
	 * @ordered
	 */
  protected EList<Car> ownedCars;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected PersonImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FamilyPackage.Literals.PERSON;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getFirstName() {
		return firstName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFirstName(String newFirstName) {
		String oldFirstName = firstName;
		firstName = newFirstName;
		boolean oldFirstNameESet = firstNameESet;
		firstNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.PERSON__FIRST_NAME, oldFirstName, firstName, !oldFirstNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetFirstName() {
		String oldFirstName = firstName;
		boolean oldFirstNameESet = firstNameESet;
		firstName = FIRST_NAME_EDEFAULT;
		firstNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FamilyPackage.PERSON__FIRST_NAME, oldFirstName, FIRST_NAME_EDEFAULT, oldFirstNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetFirstName() {
		return firstNameESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Sexe getSexe() {
		return sexe;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSexe(Sexe newSexe) {
		Sexe oldSexe = sexe;
		sexe = newSexe == null ? SEXE_EDEFAULT : newSexe;
		boolean oldSexeESet = sexeESet;
		sexeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.PERSON__SEXE, oldSexe, sexe, !oldSexeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetSexe() {
		Sexe oldSexe = sexe;
		boolean oldSexeESet = sexeESet;
		sexe = SEXE_EDEFAULT;
		sexeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FamilyPackage.PERSON__SEXE, oldSexe, SEXE_EDEFAULT, oldSexeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetSexe() {
		return sexeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Car> getOwnedCars() {
		if (ownedCars == null) {
			ownedCars = new EObjectContainmentEList<Car>(Car.class, this, FamilyPackage.PERSON__OWNED_CARS);
		}
		return ownedCars;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FamilyPackage.PERSON__OWNED_CARS:
				return ((InternalEList<?>)getOwnedCars()).basicRemove(otherEnd, msgs);
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
			case FamilyPackage.PERSON__FIRST_NAME:
				return getFirstName();
			case FamilyPackage.PERSON__SEXE:
				return getSexe();
			case FamilyPackage.PERSON__OWNED_CARS:
				return getOwnedCars();
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
			case FamilyPackage.PERSON__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case FamilyPackage.PERSON__SEXE:
				setSexe((Sexe)newValue);
				return;
			case FamilyPackage.PERSON__OWNED_CARS:
				getOwnedCars().clear();
				getOwnedCars().addAll((Collection<? extends Car>)newValue);
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
			case FamilyPackage.PERSON__FIRST_NAME:
				unsetFirstName();
				return;
			case FamilyPackage.PERSON__SEXE:
				unsetSexe();
				return;
			case FamilyPackage.PERSON__OWNED_CARS:
				getOwnedCars().clear();
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
			case FamilyPackage.PERSON__FIRST_NAME:
				return isSetFirstName();
			case FamilyPackage.PERSON__SEXE:
				return isSetSexe();
			case FamilyPackage.PERSON__OWNED_CARS:
				return ownedCars != null && !ownedCars.isEmpty();
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
		result.append(" (firstName: ");
		if (firstNameESet) result.append(firstName); else result.append("<unset>");
		result.append(", sexe: ");
		if (sexeESet) result.append(sexe); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //PersonImpl
