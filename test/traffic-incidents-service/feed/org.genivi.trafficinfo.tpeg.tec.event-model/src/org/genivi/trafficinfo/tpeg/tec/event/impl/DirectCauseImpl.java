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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.genivi.trafficinfo.tpeg.tec.event.DirectCause;
import org.genivi.trafficinfo.tpeg.tec.event.EventPackage;
import org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType;
import org.genivi.trafficinfo.tpeg.tec.event.WarningLevel;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Direct Cause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl#getWarningLevel <em>Warning Level</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl#isUnverifiedInformation <em>Unverified Information</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl#getSubCause <em>Sub Cause</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl#getLengthAffected <em>Length Affected</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl#getLaneRestrictionType <em>Lane Restriction Type</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl#getNumberOfLanes <em>Number Of Lanes</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl#getFreeText <em>Free Text</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl#getCauseOffset <em>Cause Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirectCauseImpl extends CauseImpl implements DirectCause {
	/**
	 * The default value of the '{@link #getWarningLevel() <em>Warning Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarningLevel()
	 * @generated
	 * @ordered
	 */
	protected static final WarningLevel WARNING_LEVEL_EDEFAULT = WarningLevel.INFORMATIVE;

	/**
	 * The cached value of the '{@link #getWarningLevel() <em>Warning Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarningLevel()
	 * @generated
	 * @ordered
	 */
	protected WarningLevel warningLevel = WARNING_LEVEL_EDEFAULT;

	/**
	 * This is true if the Warning Level attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean warningLevelESet;

  /**
	 * The default value of the '{@link #isUnverifiedInformation() <em>Unverified Information</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnverifiedInformation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNVERIFIED_INFORMATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnverifiedInformation() <em>Unverified Information</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnverifiedInformation()
	 * @generated
	 * @ordered
	 */
	protected boolean unverifiedInformation = UNVERIFIED_INFORMATION_EDEFAULT;

	/**
	 * This is true if the Unverified Information attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean unverifiedInformationESet;

  /**
	 * The default value of the '{@link #getSubCause() <em>Sub Cause</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSubCause()
	 * @generated
	 * @ordered
	 */
  protected static final Object SUB_CAUSE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getSubCause() <em>Sub Cause</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSubCause()
	 * @generated
	 * @ordered
	 */
  protected Object subCause = SUB_CAUSE_EDEFAULT;

  /**
	 * This is true if the Sub Cause attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean subCauseESet;

  /**
	 * The default value of the '{@link #getLengthAffected() <em>Length Affected</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLengthAffected()
	 * @generated
	 * @ordered
	 */
  protected static final Integer LENGTH_AFFECTED_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getLengthAffected() <em>Length Affected</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLengthAffected()
	 * @generated
	 * @ordered
	 */
  protected Integer lengthAffected = LENGTH_AFFECTED_EDEFAULT;

  /**
	 * This is true if the Length Affected attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean lengthAffectedESet;

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
	 * The cached value of the '{@link #getFreeText() <em>Free Text</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFreeText()
	 * @generated
	 * @ordered
	 */
  protected EList<LocalisedShortString> freeText;

  /**
	 * The default value of the '{@link #getCauseOffset() <em>Cause Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCauseOffset()
	 * @generated
	 * @ordered
	 */
	protected static final Integer CAUSE_OFFSET_EDEFAULT = null;

		/**
	 * The cached value of the '{@link #getCauseOffset() <em>Cause Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCauseOffset()
	 * @generated
	 * @ordered
	 */
	protected Integer causeOffset = CAUSE_OFFSET_EDEFAULT;

		/**
	 * This is true if the Cause Offset attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean causeOffsetESet;

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectCauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventPackage.Literals.DIRECT_CAUSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WarningLevel getWarningLevel() {
		return warningLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarningLevel(WarningLevel newWarningLevel) {
		WarningLevel oldWarningLevel = warningLevel;
		warningLevel = newWarningLevel == null ? WARNING_LEVEL_EDEFAULT : newWarningLevel;
		boolean oldWarningLevelESet = warningLevelESet;
		warningLevelESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.DIRECT_CAUSE__WARNING_LEVEL, oldWarningLevel, warningLevel, !oldWarningLevelESet));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetWarningLevel() {
		WarningLevel oldWarningLevel = warningLevel;
		boolean oldWarningLevelESet = warningLevelESet;
		warningLevel = WARNING_LEVEL_EDEFAULT;
		warningLevelESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.DIRECT_CAUSE__WARNING_LEVEL, oldWarningLevel, WARNING_LEVEL_EDEFAULT, oldWarningLevelESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetWarningLevel() {
		return warningLevelESet;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnverifiedInformation() {
		return unverifiedInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnverifiedInformation(boolean newUnverifiedInformation) {
		boolean oldUnverifiedInformation = unverifiedInformation;
		unverifiedInformation = newUnverifiedInformation;
		boolean oldUnverifiedInformationESet = unverifiedInformationESet;
		unverifiedInformationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.DIRECT_CAUSE__UNVERIFIED_INFORMATION, oldUnverifiedInformation, unverifiedInformation, !oldUnverifiedInformationESet));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetUnverifiedInformation() {
		boolean oldUnverifiedInformation = unverifiedInformation;
		boolean oldUnverifiedInformationESet = unverifiedInformationESet;
		unverifiedInformation = UNVERIFIED_INFORMATION_EDEFAULT;
		unverifiedInformationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.DIRECT_CAUSE__UNVERIFIED_INFORMATION, oldUnverifiedInformation, UNVERIFIED_INFORMATION_EDEFAULT, oldUnverifiedInformationESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetUnverifiedInformation() {
		return unverifiedInformationESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object getSubCause() {
		return subCause;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSubCause(Object newSubCause) {
		Object oldSubCause = subCause;
		subCause = newSubCause;
		boolean oldSubCauseESet = subCauseESet;
		subCauseESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.DIRECT_CAUSE__SUB_CAUSE, oldSubCause, subCause, !oldSubCauseESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetSubCause() {
		Object oldSubCause = subCause;
		boolean oldSubCauseESet = subCauseESet;
		subCause = SUB_CAUSE_EDEFAULT;
		subCauseESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.DIRECT_CAUSE__SUB_CAUSE, oldSubCause, SUB_CAUSE_EDEFAULT, oldSubCauseESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetSubCause() {
		return subCauseESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getLengthAffected() {
		return lengthAffected;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLengthAffected(Integer newLengthAffected) {
		Integer oldLengthAffected = lengthAffected;
		lengthAffected = newLengthAffected;
		boolean oldLengthAffectedESet = lengthAffectedESet;
		lengthAffectedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.DIRECT_CAUSE__LENGTH_AFFECTED, oldLengthAffected, lengthAffected, !oldLengthAffectedESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLengthAffected() {
		Integer oldLengthAffected = lengthAffected;
		boolean oldLengthAffectedESet = lengthAffectedESet;
		lengthAffected = LENGTH_AFFECTED_EDEFAULT;
		lengthAffectedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.DIRECT_CAUSE__LENGTH_AFFECTED, oldLengthAffected, LENGTH_AFFECTED_EDEFAULT, oldLengthAffectedESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLengthAffected() {
		return lengthAffectedESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.DIRECT_CAUSE__LANE_RESTRICTION_TYPE, oldLaneRestrictionType, laneRestrictionType, !oldLaneRestrictionTypeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.DIRECT_CAUSE__LANE_RESTRICTION_TYPE, oldLaneRestrictionType, LANE_RESTRICTION_TYPE_EDEFAULT, oldLaneRestrictionTypeESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.DIRECT_CAUSE__NUMBER_OF_LANES, oldNumberOfLanes, numberOfLanes, !oldNumberOfLanesESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.DIRECT_CAUSE__NUMBER_OF_LANES, oldNumberOfLanes, NUMBER_OF_LANES_EDEFAULT, oldNumberOfLanesESet));
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
  public EList<LocalisedShortString> getFreeText() {
		if (freeText == null) {
			freeText = new EObjectContainmentEList<LocalisedShortString>(LocalisedShortString.class, this, EventPackage.DIRECT_CAUSE__FREE_TEXT);
		}
		return freeText;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getCauseOffset() {
		return causeOffset;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCauseOffset(Integer newCauseOffset) {
		Integer oldCauseOffset = causeOffset;
		causeOffset = newCauseOffset;
		boolean oldCauseOffsetESet = causeOffsetESet;
		causeOffsetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.DIRECT_CAUSE__CAUSE_OFFSET, oldCauseOffset, causeOffset, !oldCauseOffsetESet));
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCauseOffset() {
		Integer oldCauseOffset = causeOffset;
		boolean oldCauseOffsetESet = causeOffsetESet;
		causeOffset = CAUSE_OFFSET_EDEFAULT;
		causeOffsetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.DIRECT_CAUSE__CAUSE_OFFSET, oldCauseOffset, CAUSE_OFFSET_EDEFAULT, oldCauseOffsetESet));
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCauseOffset() {
		return causeOffsetESet;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventPackage.DIRECT_CAUSE__FREE_TEXT:
				return ((InternalEList<?>)getFreeText()).basicRemove(otherEnd, msgs);
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
			case EventPackage.DIRECT_CAUSE__WARNING_LEVEL:
				return getWarningLevel();
			case EventPackage.DIRECT_CAUSE__UNVERIFIED_INFORMATION:
				return isUnverifiedInformation();
			case EventPackage.DIRECT_CAUSE__SUB_CAUSE:
				return getSubCause();
			case EventPackage.DIRECT_CAUSE__LENGTH_AFFECTED:
				return getLengthAffected();
			case EventPackage.DIRECT_CAUSE__LANE_RESTRICTION_TYPE:
				return getLaneRestrictionType();
			case EventPackage.DIRECT_CAUSE__NUMBER_OF_LANES:
				return getNumberOfLanes();
			case EventPackage.DIRECT_CAUSE__FREE_TEXT:
				return getFreeText();
			case EventPackage.DIRECT_CAUSE__CAUSE_OFFSET:
				return getCauseOffset();
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
			case EventPackage.DIRECT_CAUSE__WARNING_LEVEL:
				setWarningLevel((WarningLevel)newValue);
				return;
			case EventPackage.DIRECT_CAUSE__UNVERIFIED_INFORMATION:
				setUnverifiedInformation((Boolean)newValue);
				return;
			case EventPackage.DIRECT_CAUSE__SUB_CAUSE:
				setSubCause(newValue);
				return;
			case EventPackage.DIRECT_CAUSE__LENGTH_AFFECTED:
				setLengthAffected((Integer)newValue);
				return;
			case EventPackage.DIRECT_CAUSE__LANE_RESTRICTION_TYPE:
				setLaneRestrictionType((LaneRestrictionType)newValue);
				return;
			case EventPackage.DIRECT_CAUSE__NUMBER_OF_LANES:
				setNumberOfLanes((Integer)newValue);
				return;
			case EventPackage.DIRECT_CAUSE__FREE_TEXT:
				getFreeText().clear();
				getFreeText().addAll((Collection<? extends LocalisedShortString>)newValue);
				return;
			case EventPackage.DIRECT_CAUSE__CAUSE_OFFSET:
				setCauseOffset((Integer)newValue);
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
			case EventPackage.DIRECT_CAUSE__WARNING_LEVEL:
				unsetWarningLevel();
				return;
			case EventPackage.DIRECT_CAUSE__UNVERIFIED_INFORMATION:
				unsetUnverifiedInformation();
				return;
			case EventPackage.DIRECT_CAUSE__SUB_CAUSE:
				unsetSubCause();
				return;
			case EventPackage.DIRECT_CAUSE__LENGTH_AFFECTED:
				unsetLengthAffected();
				return;
			case EventPackage.DIRECT_CAUSE__LANE_RESTRICTION_TYPE:
				unsetLaneRestrictionType();
				return;
			case EventPackage.DIRECT_CAUSE__NUMBER_OF_LANES:
				unsetNumberOfLanes();
				return;
			case EventPackage.DIRECT_CAUSE__FREE_TEXT:
				getFreeText().clear();
				return;
			case EventPackage.DIRECT_CAUSE__CAUSE_OFFSET:
				unsetCauseOffset();
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
			case EventPackage.DIRECT_CAUSE__WARNING_LEVEL:
				return isSetWarningLevel();
			case EventPackage.DIRECT_CAUSE__UNVERIFIED_INFORMATION:
				return isSetUnverifiedInformation();
			case EventPackage.DIRECT_CAUSE__SUB_CAUSE:
				return isSetSubCause();
			case EventPackage.DIRECT_CAUSE__LENGTH_AFFECTED:
				return isSetLengthAffected();
			case EventPackage.DIRECT_CAUSE__LANE_RESTRICTION_TYPE:
				return isSetLaneRestrictionType();
			case EventPackage.DIRECT_CAUSE__NUMBER_OF_LANES:
				return isSetNumberOfLanes();
			case EventPackage.DIRECT_CAUSE__FREE_TEXT:
				return freeText != null && !freeText.isEmpty();
			case EventPackage.DIRECT_CAUSE__CAUSE_OFFSET:
				return isSetCauseOffset();
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
		result.append(" (warningLevel: ");
		if (warningLevelESet) result.append(warningLevel); else result.append("<unset>");
		result.append(", unverifiedInformation: ");
		if (unverifiedInformationESet) result.append(unverifiedInformation); else result.append("<unset>");
		result.append(", subCause: ");
		if (subCauseESet) result.append(subCause); else result.append("<unset>");
		result.append(", lengthAffected: ");
		if (lengthAffectedESet) result.append(lengthAffected); else result.append("<unset>");
		result.append(", laneRestrictionType: ");
		if (laneRestrictionTypeESet) result.append(laneRestrictionType); else result.append("<unset>");
		result.append(", numberOfLanes: ");
		if (numberOfLanesESet) result.append(numberOfLanes); else result.append("<unset>");
		result.append(", causeOffset: ");
		if (causeOffsetESet) result.append(causeOffset); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //DirectCauseImpl
