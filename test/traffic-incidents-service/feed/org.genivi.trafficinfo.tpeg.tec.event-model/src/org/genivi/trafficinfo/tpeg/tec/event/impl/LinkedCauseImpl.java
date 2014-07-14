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
import org.genivi.trafficinfo.tpeg.tec.event.EventPackage;
import org.genivi.trafficinfo.tpeg.tec.event.LinkedCause;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linked Cause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.LinkedCauseImpl#getLinkedMessage <em>Linked Message</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.LinkedCauseImpl#getCOID <em>COID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.LinkedCauseImpl#getOriginatorSID <em>Originator SID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkedCauseImpl extends CauseImpl implements LinkedCause {
	/**
	 * The default value of the '{@link #getLinkedMessage() <em>Linked Message</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLinkedMessage()
	 * @generated
	 * @ordered
	 */
  protected static final Integer LINKED_MESSAGE_EDEFAULT = null;
  /**
	 * The cached value of the '{@link #getLinkedMessage() <em>Linked Message</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLinkedMessage()
	 * @generated
	 * @ordered
	 */
  protected Integer linkedMessage = LINKED_MESSAGE_EDEFAULT;
  /**
	 * This is true if the Linked Message attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean linkedMessageESet;
  /**
	 * The default value of the '{@link #getCOID() <em>COID</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCOID()
	 * @generated
	 * @ordered
	 */
  protected static final byte COID_EDEFAULT = 0x00;
  /**
	 * The cached value of the '{@link #getCOID() <em>COID</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCOID()
	 * @generated
	 * @ordered
	 */
  protected byte coid = COID_EDEFAULT;
  /**
	 * This is true if the COID attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean coidESet;
  /**
	 * The cached value of the '{@link #getOriginatorSID() <em>Originator SID</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOriginatorSID()
	 * @generated
	 * @ordered
	 */
  protected ServiceIdentifier originatorSID;
  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkedCauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventPackage.Literals.LINKED_CAUSE;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getLinkedMessage() {
		return linkedMessage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLinkedMessage(Integer newLinkedMessage) {
		Integer oldLinkedMessage = linkedMessage;
		linkedMessage = newLinkedMessage;
		boolean oldLinkedMessageESet = linkedMessageESet;
		linkedMessageESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.LINKED_CAUSE__LINKED_MESSAGE, oldLinkedMessage, linkedMessage, !oldLinkedMessageESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLinkedMessage() {
		Integer oldLinkedMessage = linkedMessage;
		boolean oldLinkedMessageESet = linkedMessageESet;
		linkedMessage = LINKED_MESSAGE_EDEFAULT;
		linkedMessageESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.LINKED_CAUSE__LINKED_MESSAGE, oldLinkedMessage, LINKED_MESSAGE_EDEFAULT, oldLinkedMessageESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLinkedMessage() {
		return linkedMessageESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public byte getCOID() {
		return coid;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCOID(byte newCOID) {
		byte oldCOID = coid;
		coid = newCOID;
		boolean oldCOIDESet = coidESet;
		coidESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.LINKED_CAUSE__COID, oldCOID, coid, !oldCOIDESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetCOID() {
		byte oldCOID = coid;
		boolean oldCOIDESet = coidESet;
		coid = COID_EDEFAULT;
		coidESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.LINKED_CAUSE__COID, oldCOID, COID_EDEFAULT, oldCOIDESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetCOID() {
		return coidESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ServiceIdentifier getOriginatorSID() {
		return originatorSID;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetOriginatorSID(ServiceIdentifier newOriginatorSID, NotificationChain msgs) {
		ServiceIdentifier oldOriginatorSID = originatorSID;
		originatorSID = newOriginatorSID;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventPackage.LINKED_CAUSE__ORIGINATOR_SID, oldOriginatorSID, newOriginatorSID);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setOriginatorSID(ServiceIdentifier newOriginatorSID) {
		if (newOriginatorSID != originatorSID) {
			NotificationChain msgs = null;
			if (originatorSID != null)
				msgs = ((InternalEObject)originatorSID).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventPackage.LINKED_CAUSE__ORIGINATOR_SID, null, msgs);
			if (newOriginatorSID != null)
				msgs = ((InternalEObject)newOriginatorSID).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventPackage.LINKED_CAUSE__ORIGINATOR_SID, null, msgs);
			msgs = basicSetOriginatorSID(newOriginatorSID, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.LINKED_CAUSE__ORIGINATOR_SID, newOriginatorSID, newOriginatorSID));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventPackage.LINKED_CAUSE__ORIGINATOR_SID:
				return basicSetOriginatorSID(null, msgs);
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
			case EventPackage.LINKED_CAUSE__LINKED_MESSAGE:
				return getLinkedMessage();
			case EventPackage.LINKED_CAUSE__COID:
				return getCOID();
			case EventPackage.LINKED_CAUSE__ORIGINATOR_SID:
				return getOriginatorSID();
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
			case EventPackage.LINKED_CAUSE__LINKED_MESSAGE:
				setLinkedMessage((Integer)newValue);
				return;
			case EventPackage.LINKED_CAUSE__COID:
				setCOID((Byte)newValue);
				return;
			case EventPackage.LINKED_CAUSE__ORIGINATOR_SID:
				setOriginatorSID((ServiceIdentifier)newValue);
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
			case EventPackage.LINKED_CAUSE__LINKED_MESSAGE:
				unsetLinkedMessage();
				return;
			case EventPackage.LINKED_CAUSE__COID:
				unsetCOID();
				return;
			case EventPackage.LINKED_CAUSE__ORIGINATOR_SID:
				setOriginatorSID((ServiceIdentifier)null);
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
			case EventPackage.LINKED_CAUSE__LINKED_MESSAGE:
				return isSetLinkedMessage();
			case EventPackage.LINKED_CAUSE__COID:
				return isSetCOID();
			case EventPackage.LINKED_CAUSE__ORIGINATOR_SID:
				return originatorSID != null;
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
		result.append(" (linkedMessage: ");
		if (linkedMessageESet) result.append(linkedMessage); else result.append("<unset>");
		result.append(", COID: ");
		if (coidESet) result.append(coid); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //LinkedCauseImpl
