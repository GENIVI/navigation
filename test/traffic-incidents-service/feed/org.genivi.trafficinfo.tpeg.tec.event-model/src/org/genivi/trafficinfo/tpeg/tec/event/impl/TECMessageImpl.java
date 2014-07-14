/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.trafficinfo.tpeg.tec.event.Event;
import org.genivi.trafficinfo.tpeg.tec.event.EventPackage;
import org.genivi.trafficinfo.tpeg.tec.event.TECMessage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TEC Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TECMessageImpl#getMmt <em>Mmt</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TECMessageImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TECMessageImpl#getLoc <em>Loc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TECMessageImpl extends EObjectImpl implements TECMessage {
  /**
	 * The cached value of the '{@link #getMmt() <em>Mmt</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMmt()
	 * @generated
	 * @ordered
	 */
  protected MMCSwitch mmt;
  /**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
  protected Event event;
  /**
	 * The cached value of the '{@link #getLoc() <em>Loc</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLoc()
	 * @generated
	 * @ordered
	 */
  protected LocationReferencingContainer loc;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TECMessageImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return EventPackage.Literals.TEC_MESSAGE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MMCSwitch getMmt() {
		return mmt;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetMmt(MMCSwitch newMmt, NotificationChain msgs) {
		MMCSwitch oldMmt = mmt;
		mmt = newMmt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPackage.TEC_MESSAGE__MMT, oldMmt, newMmt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMmt(MMCSwitch newMmt) {
		if (newMmt != mmt) {
			NotificationChain msgs = null;
			if (mmt != null)
				msgs = ((InternalEObject)mmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPackage.TEC_MESSAGE__MMT, null, msgs);
			if (newMmt != null)
				msgs = ((InternalEObject)newMmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPackage.TEC_MESSAGE__MMT, null, msgs);
			msgs = basicSetMmt(newMmt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.TEC_MESSAGE__MMT, newMmt, newMmt));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Event getEvent() {
		return event;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetEvent(Event newEvent, NotificationChain msgs) {
		Event oldEvent = event;
		event = newEvent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPackage.TEC_MESSAGE__EVENT, oldEvent, newEvent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setEvent(Event newEvent) {
		if (newEvent != event) {
			NotificationChain msgs = null;
			if (event != null)
				msgs = ((InternalEObject)event).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPackage.TEC_MESSAGE__EVENT, null, msgs);
			if (newEvent != null)
				msgs = ((InternalEObject)newEvent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPackage.TEC_MESSAGE__EVENT, null, msgs);
			msgs = basicSetEvent(newEvent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.TEC_MESSAGE__EVENT, newEvent, newEvent));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LocationReferencingContainer getLoc() {
		return loc;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLoc(LocationReferencingContainer newLoc, NotificationChain msgs) {
		LocationReferencingContainer oldLoc = loc;
		loc = newLoc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPackage.TEC_MESSAGE__LOC, oldLoc, newLoc);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLoc(LocationReferencingContainer newLoc) {
		if (newLoc != loc) {
			NotificationChain msgs = null;
			if (loc != null)
				msgs = ((InternalEObject)loc).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPackage.TEC_MESSAGE__LOC, null, msgs);
			if (newLoc != null)
				msgs = ((InternalEObject)newLoc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPackage.TEC_MESSAGE__LOC, null, msgs);
			msgs = basicSetLoc(newLoc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.TEC_MESSAGE__LOC, newLoc, newLoc));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventPackage.TEC_MESSAGE__MMT:
				return basicSetMmt(null, msgs);
			case EventPackage.TEC_MESSAGE__EVENT:
				return basicSetEvent(null, msgs);
			case EventPackage.TEC_MESSAGE__LOC:
				return basicSetLoc(null, msgs);
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
			case EventPackage.TEC_MESSAGE__MMT:
				return getMmt();
			case EventPackage.TEC_MESSAGE__EVENT:
				return getEvent();
			case EventPackage.TEC_MESSAGE__LOC:
				return getLoc();
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
			case EventPackage.TEC_MESSAGE__MMT:
				setMmt((MMCSwitch)newValue);
				return;
			case EventPackage.TEC_MESSAGE__EVENT:
				setEvent((Event)newValue);
				return;
			case EventPackage.TEC_MESSAGE__LOC:
				setLoc((LocationReferencingContainer)newValue);
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
			case EventPackage.TEC_MESSAGE__MMT:
				setMmt((MMCSwitch)null);
				return;
			case EventPackage.TEC_MESSAGE__EVENT:
				setEvent((Event)null);
				return;
			case EventPackage.TEC_MESSAGE__LOC:
				setLoc((LocationReferencingContainer)null);
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
			case EventPackage.TEC_MESSAGE__MMT:
				return mmt != null;
			case EventPackage.TEC_MESSAGE__EVENT:
				return event != null;
			case EventPackage.TEC_MESSAGE__LOC:
				return loc != null;
		}
		return super.eIsSet(featureID);
	}

} //TECMessageImpl
