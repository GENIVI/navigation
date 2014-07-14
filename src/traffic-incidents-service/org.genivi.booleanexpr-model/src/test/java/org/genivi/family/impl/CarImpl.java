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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.family.Car;
import org.genivi.family.FamilyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Car</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.family.impl.CarImpl#getNumberOfSeats <em>Number Of Seats</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CarImpl extends EObjectImpl implements Car {
  /**
	 * The default value of the '{@link #getNumberOfSeats() <em>Number Of Seats</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNumberOfSeats()
	 * @generated
	 * @ordered
	 */
  protected static final Integer NUMBER_OF_SEATS_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getNumberOfSeats() <em>Number Of Seats</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNumberOfSeats()
	 * @generated
	 * @ordered
	 */
  protected Integer numberOfSeats = NUMBER_OF_SEATS_EDEFAULT;

  /**
	 * This is true if the Number Of Seats attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean numberOfSeatsESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CarImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FamilyPackage.Literals.CAR;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setNumberOfSeats(Integer newNumberOfSeats) {
		Integer oldNumberOfSeats = numberOfSeats;
		numberOfSeats = newNumberOfSeats;
		boolean oldNumberOfSeatsESet = numberOfSeatsESet;
		numberOfSeatsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.CAR__NUMBER_OF_SEATS, oldNumberOfSeats, numberOfSeats, !oldNumberOfSeatsESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetNumberOfSeats() {
		Integer oldNumberOfSeats = numberOfSeats;
		boolean oldNumberOfSeatsESet = numberOfSeatsESet;
		numberOfSeats = NUMBER_OF_SEATS_EDEFAULT;
		numberOfSeatsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FamilyPackage.CAR__NUMBER_OF_SEATS, oldNumberOfSeats, NUMBER_OF_SEATS_EDEFAULT, oldNumberOfSeatsESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetNumberOfSeats() {
		return numberOfSeatsESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FamilyPackage.CAR__NUMBER_OF_SEATS:
				return getNumberOfSeats();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FamilyPackage.CAR__NUMBER_OF_SEATS:
				setNumberOfSeats((Integer)newValue);
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
			case FamilyPackage.CAR__NUMBER_OF_SEATS:
				unsetNumberOfSeats();
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
			case FamilyPackage.CAR__NUMBER_OF_SEATS:
				return isSetNumberOfSeats();
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
		result.append(" (numberOfSeats: ");
		if (numberOfSeatsESet) result.append(numberOfSeats); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //CarImpl
