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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genivi.family.Address;
import org.genivi.family.Family;
import org.genivi.family.FamilyPackage;
import org.genivi.family.Person;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Family</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.family.impl.FamilyImpl#getMembers <em>Members</em>}</li>
 *   <li>{@link org.genivi.family.impl.FamilyImpl#getSurname <em>Surname</em>}</li>
 *   <li>{@link org.genivi.family.impl.FamilyImpl#getNumberOfPets <em>Number Of Pets</em>}</li>
 *   <li>{@link org.genivi.family.impl.FamilyImpl#isHasASwimmingPool <em>Has ASwimming Pool</em>}</li>
 *   <li>{@link org.genivi.family.impl.FamilyImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link org.genivi.family.impl.FamilyImpl#getFavoriteHolidayDestinations <em>Favorite Holiday Destinations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FamilyImpl extends EObjectImpl implements Family {
  /**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
  protected EList<Person> members;

  /**
	 * The default value of the '{@link #getSurname() <em>Surname</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSurname()
	 * @generated
	 * @ordered
	 */
  protected static final String SURNAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getSurname() <em>Surname</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSurname()
	 * @generated
	 * @ordered
	 */
  protected String surname = SURNAME_EDEFAULT;

  /**
	 * This is true if the Surname attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean surnameESet;

  /**
	 * The default value of the '{@link #getNumberOfPets() <em>Number Of Pets</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNumberOfPets()
	 * @generated
	 * @ordered
	 */
  protected static final int NUMBER_OF_PETS_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getNumberOfPets() <em>Number Of Pets</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNumberOfPets()
	 * @generated
	 * @ordered
	 */
  protected int numberOfPets = NUMBER_OF_PETS_EDEFAULT;

  /**
	 * This is true if the Number Of Pets attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean numberOfPetsESet;

  /**
	 * The default value of the '{@link #isHasASwimmingPool() <em>Has ASwimming Pool</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isHasASwimmingPool()
	 * @generated
	 * @ordered
	 */
  protected static final boolean HAS_ASWIMMING_POOL_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isHasASwimmingPool() <em>Has ASwimming Pool</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isHasASwimmingPool()
	 * @generated
	 * @ordered
	 */
  protected boolean hasASwimmingPool = HAS_ASWIMMING_POOL_EDEFAULT;

  /**
	 * This is true if the Has ASwimming Pool attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean hasASwimmingPoolESet;

  /**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
  protected Address address;

  /**
	 * This is true if the Address containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean addressESet;

  /**
	 * The cached value of the '{@link #getFavoriteHolidayDestinations() <em>Favorite Holiday Destinations</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFavoriteHolidayDestinations()
	 * @generated
	 * @ordered
	 */
  protected EList<String> favoriteHolidayDestinations;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected FamilyImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FamilyPackage.Literals.FAMILY;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Person> getMembers() {
		if (members == null) {
			members = new EObjectContainmentEList<Person>(Person.class, this, FamilyPackage.FAMILY__MEMBERS);
		}
		return members;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getSurname() {
		return surname;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSurname(String newSurname) {
		String oldSurname = surname;
		surname = newSurname;
		boolean oldSurnameESet = surnameESet;
		surnameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.FAMILY__SURNAME, oldSurname, surname, !oldSurnameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetSurname() {
		String oldSurname = surname;
		boolean oldSurnameESet = surnameESet;
		surname = SURNAME_EDEFAULT;
		surnameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FamilyPackage.FAMILY__SURNAME, oldSurname, SURNAME_EDEFAULT, oldSurnameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetSurname() {
		return surnameESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getNumberOfPets() {
		return numberOfPets;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setNumberOfPets(int newNumberOfPets) {
		int oldNumberOfPets = numberOfPets;
		numberOfPets = newNumberOfPets;
		boolean oldNumberOfPetsESet = numberOfPetsESet;
		numberOfPetsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.FAMILY__NUMBER_OF_PETS, oldNumberOfPets, numberOfPets, !oldNumberOfPetsESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetNumberOfPets() {
		int oldNumberOfPets = numberOfPets;
		boolean oldNumberOfPetsESet = numberOfPetsESet;
		numberOfPets = NUMBER_OF_PETS_EDEFAULT;
		numberOfPetsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FamilyPackage.FAMILY__NUMBER_OF_PETS, oldNumberOfPets, NUMBER_OF_PETS_EDEFAULT, oldNumberOfPetsESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetNumberOfPets() {
		return numberOfPetsESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isHasASwimmingPool() {
		return hasASwimmingPool;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setHasASwimmingPool(boolean newHasASwimmingPool) {
		boolean oldHasASwimmingPool = hasASwimmingPool;
		hasASwimmingPool = newHasASwimmingPool;
		boolean oldHasASwimmingPoolESet = hasASwimmingPoolESet;
		hasASwimmingPoolESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.FAMILY__HAS_ASWIMMING_POOL, oldHasASwimmingPool, hasASwimmingPool, !oldHasASwimmingPoolESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetHasASwimmingPool() {
		boolean oldHasASwimmingPool = hasASwimmingPool;
		boolean oldHasASwimmingPoolESet = hasASwimmingPoolESet;
		hasASwimmingPool = HAS_ASWIMMING_POOL_EDEFAULT;
		hasASwimmingPoolESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FamilyPackage.FAMILY__HAS_ASWIMMING_POOL, oldHasASwimmingPool, HAS_ASWIMMING_POOL_EDEFAULT, oldHasASwimmingPoolESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetHasASwimmingPool() {
		return hasASwimmingPoolESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Address getAddress() {
		return address;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetAddress(Address newAddress, NotificationChain msgs) {
		Address oldAddress = address;
		address = newAddress;
		boolean oldAddressESet = addressESet;
		addressESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FamilyPackage.FAMILY__ADDRESS, oldAddress, newAddress, !oldAddressESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAddress(Address newAddress) {
		if (newAddress != address) {
			NotificationChain msgs = null;
			if (address != null)
				msgs = ((InternalEObject)address).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FamilyPackage.FAMILY__ADDRESS, null, msgs);
			if (newAddress != null)
				msgs = ((InternalEObject)newAddress).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FamilyPackage.FAMILY__ADDRESS, null, msgs);
			msgs = basicSetAddress(newAddress, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldAddressESet = addressESet;
			addressESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.FAMILY__ADDRESS, newAddress, newAddress, !oldAddressESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetAddress(NotificationChain msgs) {
		Address oldAddress = address;
		address = null;
		boolean oldAddressESet = addressESet;
		addressESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, FamilyPackage.FAMILY__ADDRESS, oldAddress, null, oldAddressESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetAddress() {
		if (address != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)address).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FamilyPackage.FAMILY__ADDRESS, null, msgs);
			msgs = basicUnsetAddress(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldAddressESet = addressESet;
			addressESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, FamilyPackage.FAMILY__ADDRESS, null, null, oldAddressESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetAddress() {
		return addressESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<String> getFavoriteHolidayDestinations() {
		if (favoriteHolidayDestinations == null) {
			favoriteHolidayDestinations = new EDataTypeUniqueEList<String>(String.class, this, FamilyPackage.FAMILY__FAVORITE_HOLIDAY_DESTINATIONS);
		}
		return favoriteHolidayDestinations;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FamilyPackage.FAMILY__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
			case FamilyPackage.FAMILY__ADDRESS:
				return basicUnsetAddress(msgs);
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
			case FamilyPackage.FAMILY__MEMBERS:
				return getMembers();
			case FamilyPackage.FAMILY__SURNAME:
				return getSurname();
			case FamilyPackage.FAMILY__NUMBER_OF_PETS:
				return getNumberOfPets();
			case FamilyPackage.FAMILY__HAS_ASWIMMING_POOL:
				return isHasASwimmingPool();
			case FamilyPackage.FAMILY__ADDRESS:
				return getAddress();
			case FamilyPackage.FAMILY__FAVORITE_HOLIDAY_DESTINATIONS:
				return getFavoriteHolidayDestinations();
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
			case FamilyPackage.FAMILY__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends Person>)newValue);
				return;
			case FamilyPackage.FAMILY__SURNAME:
				setSurname((String)newValue);
				return;
			case FamilyPackage.FAMILY__NUMBER_OF_PETS:
				setNumberOfPets((Integer)newValue);
				return;
			case FamilyPackage.FAMILY__HAS_ASWIMMING_POOL:
				setHasASwimmingPool((Boolean)newValue);
				return;
			case FamilyPackage.FAMILY__ADDRESS:
				setAddress((Address)newValue);
				return;
			case FamilyPackage.FAMILY__FAVORITE_HOLIDAY_DESTINATIONS:
				getFavoriteHolidayDestinations().clear();
				getFavoriteHolidayDestinations().addAll((Collection<? extends String>)newValue);
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
			case FamilyPackage.FAMILY__MEMBERS:
				getMembers().clear();
				return;
			case FamilyPackage.FAMILY__SURNAME:
				unsetSurname();
				return;
			case FamilyPackage.FAMILY__NUMBER_OF_PETS:
				unsetNumberOfPets();
				return;
			case FamilyPackage.FAMILY__HAS_ASWIMMING_POOL:
				unsetHasASwimmingPool();
				return;
			case FamilyPackage.FAMILY__ADDRESS:
				unsetAddress();
				return;
			case FamilyPackage.FAMILY__FAVORITE_HOLIDAY_DESTINATIONS:
				getFavoriteHolidayDestinations().clear();
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
			case FamilyPackage.FAMILY__MEMBERS:
				return members != null && !members.isEmpty();
			case FamilyPackage.FAMILY__SURNAME:
				return isSetSurname();
			case FamilyPackage.FAMILY__NUMBER_OF_PETS:
				return isSetNumberOfPets();
			case FamilyPackage.FAMILY__HAS_ASWIMMING_POOL:
				return isSetHasASwimmingPool();
			case FamilyPackage.FAMILY__ADDRESS:
				return isSetAddress();
			case FamilyPackage.FAMILY__FAVORITE_HOLIDAY_DESTINATIONS:
				return favoriteHolidayDestinations != null && !favoriteHolidayDestinations.isEmpty();
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
		result.append(" (surname: ");
		if (surnameESet) result.append(surname); else result.append("<unset>");
		result.append(", numberOfPets: ");
		if (numberOfPetsESet) result.append(numberOfPets); else result.append("<unset>");
		result.append(", hasASwimmingPool: ");
		if (hasASwimmingPoolESet) result.append(hasASwimmingPool); else result.append("<unset>");
		result.append(", favoriteHolidayDestinations: ");
		result.append(favoriteHolidayDestinations);
		result.append(')');
		return result.toString();
	}

} //FamilyImpl
