/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.common.CommonPackage;
import org.genivi.common.Coordinate;
import org.genivi.common.RectangularArea;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rectangular Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.common.impl.RectangularAreaImpl#getBottomLeft <em>Bottom Left</em>}</li>
 *   <li>{@link org.genivi.common.impl.RectangularAreaImpl#getTopRight <em>Top Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RectangularAreaImpl extends EObjectImpl implements RectangularArea {
	/**
	 * The cached value of the '{@link #getBottomLeft() <em>Bottom Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottomLeft()
	 * @generated
	 * @ordered
	 */
	protected Coordinate bottomLeft;
	/**
	 * The cached value of the '{@link #getTopRight() <em>Top Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopRight()
	 * @generated
	 * @ordered
	 */
	protected Coordinate topRight;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RectangularAreaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.RECTANGULAR_AREA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Coordinate getBottomLeft() {
		return bottomLeft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBottomLeft(Coordinate newBottomLeft, NotificationChain msgs) {
		Coordinate oldBottomLeft = bottomLeft;
		bottomLeft = newBottomLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.RECTANGULAR_AREA__BOTTOM_LEFT, oldBottomLeft, newBottomLeft);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomLeft(Coordinate newBottomLeft) {
		if (newBottomLeft != bottomLeft) {
			NotificationChain msgs = null;
			if (bottomLeft != null)
				msgs = ((InternalEObject)bottomLeft).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.RECTANGULAR_AREA__BOTTOM_LEFT, null, msgs);
			if (newBottomLeft != null)
				msgs = ((InternalEObject)newBottomLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.RECTANGULAR_AREA__BOTTOM_LEFT, null, msgs);
			msgs = basicSetBottomLeft(newBottomLeft, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.RECTANGULAR_AREA__BOTTOM_LEFT, newBottomLeft, newBottomLeft));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Coordinate getTopRight() {
		return topRight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopRight(Coordinate newTopRight, NotificationChain msgs) {
		Coordinate oldTopRight = topRight;
		topRight = newTopRight;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonPackage.RECTANGULAR_AREA__TOP_RIGHT, oldTopRight, newTopRight);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopRight(Coordinate newTopRight) {
		if (newTopRight != topRight) {
			NotificationChain msgs = null;
			if (topRight != null)
				msgs = ((InternalEObject)topRight).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonPackage.RECTANGULAR_AREA__TOP_RIGHT, null, msgs);
			if (newTopRight != null)
				msgs = ((InternalEObject)newTopRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonPackage.RECTANGULAR_AREA__TOP_RIGHT, null, msgs);
			msgs = basicSetTopRight(newTopRight, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.RECTANGULAR_AREA__TOP_RIGHT, newTopRight, newTopRight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonPackage.RECTANGULAR_AREA__BOTTOM_LEFT:
				return basicSetBottomLeft(null, msgs);
			case CommonPackage.RECTANGULAR_AREA__TOP_RIGHT:
				return basicSetTopRight(null, msgs);
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
			case CommonPackage.RECTANGULAR_AREA__BOTTOM_LEFT:
				return getBottomLeft();
			case CommonPackage.RECTANGULAR_AREA__TOP_RIGHT:
				return getTopRight();
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
			case CommonPackage.RECTANGULAR_AREA__BOTTOM_LEFT:
				setBottomLeft((Coordinate)newValue);
				return;
			case CommonPackage.RECTANGULAR_AREA__TOP_RIGHT:
				setTopRight((Coordinate)newValue);
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
			case CommonPackage.RECTANGULAR_AREA__BOTTOM_LEFT:
				setBottomLeft((Coordinate)null);
				return;
			case CommonPackage.RECTANGULAR_AREA__TOP_RIGHT:
				setTopRight((Coordinate)null);
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
			case CommonPackage.RECTANGULAR_AREA__BOTTOM_LEFT:
				return bottomLeft != null;
			case CommonPackage.RECTANGULAR_AREA__TOP_RIGHT:
				return topRight != null;
		}
		return super.eIsSet(featureID);
	}

} //RectangularAreaImpl
