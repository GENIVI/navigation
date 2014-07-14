/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event.impl;



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
import org.genivi.trafficinfo.tpeg.tec.event.Advice;
import org.genivi.trafficinfo.tpeg.tec.event.AdviceCode;
import org.genivi.trafficinfo.tpeg.tec.event.EventPackage;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.AdviceImpl#getAdviceCode <em>Advice Code</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.AdviceImpl#getSubAdviceCode <em>Sub Advice Code</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.AdviceImpl#getFreeText <em>Free Text</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.AdviceImpl#getVehicleRestriction <em>Vehicle Restriction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdviceImpl extends EObjectImpl implements Advice {
  /**
	 * The default value of the '{@link #getAdviceCode() <em>Advice Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAdviceCode()
	 * @generated
	 * @ordered
	 */
  protected static final AdviceCode ADVICE_CODE_EDEFAULT = AdviceCode.DRIVE_TO_NEXT_AVAILABLE_PARKING_PLACE;

  /**
	 * The cached value of the '{@link #getAdviceCode() <em>Advice Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAdviceCode()
	 * @generated
	 * @ordered
	 */
  protected AdviceCode adviceCode = ADVICE_CODE_EDEFAULT;

  /**
	 * This is true if the Advice Code attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean adviceCodeESet;

  /**
	 * The default value of the '{@link #getSubAdviceCode() <em>Sub Advice Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSubAdviceCode()
	 * @generated
	 * @ordered
	 */
  protected static final Object SUB_ADVICE_CODE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getSubAdviceCode() <em>Sub Advice Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSubAdviceCode()
	 * @generated
	 * @ordered
	 */
  protected Object subAdviceCode = SUB_ADVICE_CODE_EDEFAULT;

  /**
	 * This is true if the Sub Advice Code attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean subAdviceCodeESet;

  /**
	 * The cached value of the '{@link #getFreeText() <em>Free Text</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFreeText()
	 * @generated
	 * @ordered
	 */
  protected EList<LocalisedShortString> freeText;

  /**
	 * The cached value of the '{@link #getVehicleRestriction() <em>Vehicle Restriction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVehicleRestriction()
	 * @generated
	 * @ordered
	 */
  protected EList<VehicleRestriction> vehicleRestriction;

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
		return EventPackage.Literals.ADVICE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AdviceCode getAdviceCode() {
		return adviceCode;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAdviceCode(AdviceCode newAdviceCode) {
		AdviceCode oldAdviceCode = adviceCode;
		adviceCode = newAdviceCode == null ? ADVICE_CODE_EDEFAULT : newAdviceCode;
		boolean oldAdviceCodeESet = adviceCodeESet;
		adviceCodeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.ADVICE__ADVICE_CODE, oldAdviceCode, adviceCode, !oldAdviceCodeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetAdviceCode() {
		AdviceCode oldAdviceCode = adviceCode;
		boolean oldAdviceCodeESet = adviceCodeESet;
		adviceCode = ADVICE_CODE_EDEFAULT;
		adviceCodeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.ADVICE__ADVICE_CODE, oldAdviceCode, ADVICE_CODE_EDEFAULT, oldAdviceCodeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetAdviceCode() {
		return adviceCodeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object getSubAdviceCode() {
		return subAdviceCode;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSubAdviceCode(Object newSubAdviceCode) {
		Object oldSubAdviceCode = subAdviceCode;
		subAdviceCode = newSubAdviceCode;
		boolean oldSubAdviceCodeESet = subAdviceCodeESet;
		subAdviceCodeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.ADVICE__SUB_ADVICE_CODE, oldSubAdviceCode, subAdviceCode, !oldSubAdviceCodeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetSubAdviceCode() {
		Object oldSubAdviceCode = subAdviceCode;
		boolean oldSubAdviceCodeESet = subAdviceCodeESet;
		subAdviceCode = SUB_ADVICE_CODE_EDEFAULT;
		subAdviceCodeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.ADVICE__SUB_ADVICE_CODE, oldSubAdviceCode, SUB_ADVICE_CODE_EDEFAULT, oldSubAdviceCodeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetSubAdviceCode() {
		return subAdviceCodeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<LocalisedShortString> getFreeText() {
		if (freeText == null) {
			freeText = new EObjectContainmentEList<LocalisedShortString>(LocalisedShortString.class, this, EventPackage.ADVICE__FREE_TEXT);
		}
		return freeText;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<VehicleRestriction> getVehicleRestriction() {
		if (vehicleRestriction == null) {
			vehicleRestriction = new EObjectContainmentEList<VehicleRestriction>(VehicleRestriction.class, this, EventPackage.ADVICE__VEHICLE_RESTRICTION);
		}
		return vehicleRestriction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventPackage.ADVICE__FREE_TEXT:
				return ((InternalEList<?>)getFreeText()).basicRemove(otherEnd, msgs);
			case EventPackage.ADVICE__VEHICLE_RESTRICTION:
				return ((InternalEList<?>)getVehicleRestriction()).basicRemove(otherEnd, msgs);
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
			case EventPackage.ADVICE__ADVICE_CODE:
				return getAdviceCode();
			case EventPackage.ADVICE__SUB_ADVICE_CODE:
				return getSubAdviceCode();
			case EventPackage.ADVICE__FREE_TEXT:
				return getFreeText();
			case EventPackage.ADVICE__VEHICLE_RESTRICTION:
				return getVehicleRestriction();
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
			case EventPackage.ADVICE__ADVICE_CODE:
				setAdviceCode((AdviceCode)newValue);
				return;
			case EventPackage.ADVICE__SUB_ADVICE_CODE:
				setSubAdviceCode(newValue);
				return;
			case EventPackage.ADVICE__FREE_TEXT:
				getFreeText().clear();
				getFreeText().addAll((Collection<? extends LocalisedShortString>)newValue);
				return;
			case EventPackage.ADVICE__VEHICLE_RESTRICTION:
				getVehicleRestriction().clear();
				getVehicleRestriction().addAll((Collection<? extends VehicleRestriction>)newValue);
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
			case EventPackage.ADVICE__ADVICE_CODE:
				unsetAdviceCode();
				return;
			case EventPackage.ADVICE__SUB_ADVICE_CODE:
				unsetSubAdviceCode();
				return;
			case EventPackage.ADVICE__FREE_TEXT:
				getFreeText().clear();
				return;
			case EventPackage.ADVICE__VEHICLE_RESTRICTION:
				getVehicleRestriction().clear();
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
			case EventPackage.ADVICE__ADVICE_CODE:
				return isSetAdviceCode();
			case EventPackage.ADVICE__SUB_ADVICE_CODE:
				return isSetSubAdviceCode();
			case EventPackage.ADVICE__FREE_TEXT:
				return freeText != null && !freeText.isEmpty();
			case EventPackage.ADVICE__VEHICLE_RESTRICTION:
				return vehicleRestriction != null && !vehicleRestriction.isEmpty();
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
		result.append(" (adviceCode: ");
		if (adviceCodeESet) result.append(adviceCode); else result.append("<unset>");
		result.append(", subAdviceCode: ");
		if (subAdviceCodeESet) result.append(subAdviceCode); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //AdviceImpl
