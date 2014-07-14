/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.LaneRestrictionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lane Restrictions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LaneRestrictionsImpl#getLaneRestrictionType <em>Lane Restriction Type</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LaneRestrictionsImpl#getNumberOfLanes <em>Number Of Lanes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LaneRestrictionsImpl extends EObjectImpl implements LaneRestrictions {
  /**
	 * The default value of the '{@link #getLaneRestrictionType() <em>Lane Restriction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLaneRestrictionType()
	 * @generated
	 * @ordered
	 */
  protected static final LaneRestrictionType LANE_RESTRICTION_TYPE_EDEFAULT = LaneRestrictionType.LANES_CLOSED;

  /**
	 * The cached value of the '{@link #getLaneRestrictionType() <em>Lane Restriction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLaneRestrictionType()
	 * @generated
	 * @ordered
	 */
  protected LaneRestrictionType laneRestrictionType = LANE_RESTRICTION_TYPE_EDEFAULT;

  /**
	 * This is true if the Lane Restriction Type attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean laneRestrictionTypeESet;

  /**
	 * The default value of the '{@link #getNumberOfLanes() <em>Number Of Lanes</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNumberOfLanes()
	 * @generated
	 * @ordered
	 */
  protected static final Integer NUMBER_OF_LANES_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getNumberOfLanes() <em>Number Of Lanes</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNumberOfLanes()
	 * @generated
	 * @ordered
	 */
  protected Integer numberOfLanes = NUMBER_OF_LANES_EDEFAULT;

  /**
	 * This is true if the Number Of Lanes attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean numberOfLanesESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected LaneRestrictionsImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return trafficincidentPackage.Literals.LANE_RESTRICTIONS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LaneRestrictionType getLaneRestrictionType() {
		return laneRestrictionType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLaneRestrictionType(LaneRestrictionType newLaneRestrictionType) {
		LaneRestrictionType oldLaneRestrictionType = laneRestrictionType;
		laneRestrictionType = newLaneRestrictionType == null ? LANE_RESTRICTION_TYPE_EDEFAULT : newLaneRestrictionType;
		boolean oldLaneRestrictionTypeESet = laneRestrictionTypeESet;
		laneRestrictionTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.LANE_RESTRICTIONS__LANE_RESTRICTION_TYPE, oldLaneRestrictionType, laneRestrictionType, !oldLaneRestrictionTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLaneRestrictionType() {
		LaneRestrictionType oldLaneRestrictionType = laneRestrictionType;
		boolean oldLaneRestrictionTypeESet = laneRestrictionTypeESet;
		laneRestrictionType = LANE_RESTRICTION_TYPE_EDEFAULT;
		laneRestrictionTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.LANE_RESTRICTIONS__LANE_RESTRICTION_TYPE, oldLaneRestrictionType, LANE_RESTRICTION_TYPE_EDEFAULT, oldLaneRestrictionTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLaneRestrictionType() {
		return laneRestrictionTypeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getNumberOfLanes() {
		return numberOfLanes;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setNumberOfLanes(Integer newNumberOfLanes) {
		Integer oldNumberOfLanes = numberOfLanes;
		numberOfLanes = newNumberOfLanes;
		boolean oldNumberOfLanesESet = numberOfLanesESet;
		numberOfLanesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.LANE_RESTRICTIONS__NUMBER_OF_LANES, oldNumberOfLanes, numberOfLanes, !oldNumberOfLanesESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetNumberOfLanes() {
		Integer oldNumberOfLanes = numberOfLanes;
		boolean oldNumberOfLanesESet = numberOfLanesESet;
		numberOfLanes = NUMBER_OF_LANES_EDEFAULT;
		numberOfLanesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.LANE_RESTRICTIONS__NUMBER_OF_LANES, oldNumberOfLanes, NUMBER_OF_LANES_EDEFAULT, oldNumberOfLanesESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetNumberOfLanes() {
		return numberOfLanesESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trafficincidentPackage.LANE_RESTRICTIONS__LANE_RESTRICTION_TYPE:
				return getLaneRestrictionType();
			case trafficincidentPackage.LANE_RESTRICTIONS__NUMBER_OF_LANES:
				return getNumberOfLanes();
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
			case trafficincidentPackage.LANE_RESTRICTIONS__LANE_RESTRICTION_TYPE:
				setLaneRestrictionType((LaneRestrictionType)newValue);
				return;
			case trafficincidentPackage.LANE_RESTRICTIONS__NUMBER_OF_LANES:
				setNumberOfLanes((Integer)newValue);
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
			case trafficincidentPackage.LANE_RESTRICTIONS__LANE_RESTRICTION_TYPE:
				unsetLaneRestrictionType();
				return;
			case trafficincidentPackage.LANE_RESTRICTIONS__NUMBER_OF_LANES:
				unsetNumberOfLanes();
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
			case trafficincidentPackage.LANE_RESTRICTIONS__LANE_RESTRICTION_TYPE:
				return isSetLaneRestrictionType();
			case trafficincidentPackage.LANE_RESTRICTIONS__NUMBER_OF_LANES:
				return isSetNumberOfLanes();
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
		result.append(" (laneRestrictionType: ");
		if (laneRestrictionTypeESet) result.append(laneRestrictionType); else result.append("<unset>");
		result.append(", numberOfLanes: ");
		if (numberOfLanesESet) result.append(numberOfLanes); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //LaneRestrictionsImpl
