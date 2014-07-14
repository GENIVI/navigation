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
import org.genivi.family.FamilyPackage;
import org.genivi.family.WealthyFamily;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wealthy Family</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.family.impl.WealthyFamilyImpl#getForbesRanking <em>Forbes Ranking</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WealthyFamilyImpl extends FamilyImpl implements WealthyFamily {
  /**
	 * The default value of the '{@link #getForbesRanking() <em>Forbes Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getForbesRanking()
	 * @generated
	 * @ordered
	 */
  protected static final int FORBES_RANKING_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getForbesRanking() <em>Forbes Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getForbesRanking()
	 * @generated
	 * @ordered
	 */
  protected int forbesRanking = FORBES_RANKING_EDEFAULT;

  /**
	 * This is true if the Forbes Ranking attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean forbesRankingESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected WealthyFamilyImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FamilyPackage.Literals.WEALTHY_FAMILY;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getForbesRanking() {
		return forbesRanking;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setForbesRanking(int newForbesRanking) {
		int oldForbesRanking = forbesRanking;
		forbesRanking = newForbesRanking;
		boolean oldForbesRankingESet = forbesRankingESet;
		forbesRankingESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.WEALTHY_FAMILY__FORBES_RANKING, oldForbesRanking, forbesRanking, !oldForbesRankingESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetForbesRanking() {
		int oldForbesRanking = forbesRanking;
		boolean oldForbesRankingESet = forbesRankingESet;
		forbesRanking = FORBES_RANKING_EDEFAULT;
		forbesRankingESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FamilyPackage.WEALTHY_FAMILY__FORBES_RANKING, oldForbesRanking, FORBES_RANKING_EDEFAULT, oldForbesRankingESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetForbesRanking() {
		return forbesRankingESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FamilyPackage.WEALTHY_FAMILY__FORBES_RANKING:
				return getForbesRanking();
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
			case FamilyPackage.WEALTHY_FAMILY__FORBES_RANKING:
				setForbesRanking((Integer)newValue);
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
			case FamilyPackage.WEALTHY_FAMILY__FORBES_RANKING:
				unsetForbesRanking();
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
			case FamilyPackage.WEALTHY_FAMILY__FORBES_RANKING:
				return isSetForbesRanking();
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
		result.append(" (forbesRanking: ");
		if (forbesRankingESet) result.append(forbesRanking); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //WealthyFamilyImpl
