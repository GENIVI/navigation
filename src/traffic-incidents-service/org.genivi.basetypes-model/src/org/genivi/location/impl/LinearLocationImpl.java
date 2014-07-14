/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.location.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.genivi.location.LinearLocation;
import org.genivi.location.LocationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linear Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.location.impl.LinearLocationImpl#getSegments <em>Segments</em>}</li>
 *   <li>{@link org.genivi.location.impl.LinearLocationImpl#getPositiveOffset <em>Positive Offset</em>}</li>
 *   <li>{@link org.genivi.location.impl.LinearLocationImpl#getNegativeOffset <em>Negative Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinearLocationImpl extends LocationImpl implements LinearLocation {
	/**
	 * The cached value of the '{@link #getSegments() <em>Segments</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegments()
	 * @generated
	 * @ordered
	 */
	protected EList<Long> segments;

	/**
	 * The default value of the '{@link #getPositiveOffset() <em>Positive Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPositiveOffset()
	 * @generated
	 * @ordered
	 */
  protected static final long POSITIVE_OFFSET_EDEFAULT = 0L;
  /**
	 * The cached value of the '{@link #getPositiveOffset() <em>Positive Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPositiveOffset()
	 * @generated
	 * @ordered
	 */
  protected long positiveOffset = POSITIVE_OFFSET_EDEFAULT;
  /**
	 * This is true if the Positive Offset attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean positiveOffsetESet;
  /**
	 * The default value of the '{@link #getNegativeOffset() <em>Negative Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNegativeOffset()
	 * @generated
	 * @ordered
	 */
  protected static final long NEGATIVE_OFFSET_EDEFAULT = 0L;
  /**
	 * The cached value of the '{@link #getNegativeOffset() <em>Negative Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNegativeOffset()
	 * @generated
	 * @ordered
	 */
  protected long negativeOffset = NEGATIVE_OFFSET_EDEFAULT;
  /**
	 * This is true if the Negative Offset attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean negativeOffsetESet;

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinearLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LocationPackage.Literals.LINEAR_LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Long> getSegments() {
		if (segments == null) {
			segments = new EDataTypeUniqueEList<Long>(Long.class, this, LocationPackage.LINEAR_LOCATION__SEGMENTS);
		}
		return segments;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public long getPositiveOffset() {
		return positiveOffset;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPositiveOffset(long newPositiveOffset) {
		long oldPositiveOffset = positiveOffset;
		positiveOffset = newPositiveOffset;
		boolean oldPositiveOffsetESet = positiveOffsetESet;
		positiveOffsetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LINEAR_LOCATION__POSITIVE_OFFSET, oldPositiveOffset, positiveOffset, !oldPositiveOffsetESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetPositiveOffset() {
		long oldPositiveOffset = positiveOffset;
		boolean oldPositiveOffsetESet = positiveOffsetESet;
		positiveOffset = POSITIVE_OFFSET_EDEFAULT;
		positiveOffsetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LocationPackage.LINEAR_LOCATION__POSITIVE_OFFSET, oldPositiveOffset, POSITIVE_OFFSET_EDEFAULT, oldPositiveOffsetESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetPositiveOffset() {
		return positiveOffsetESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public long getNegativeOffset() {
		return negativeOffset;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setNegativeOffset(long newNegativeOffset) {
		long oldNegativeOffset = negativeOffset;
		negativeOffset = newNegativeOffset;
		boolean oldNegativeOffsetESet = negativeOffsetESet;
		negativeOffsetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LINEAR_LOCATION__NEGATIVE_OFFSET, oldNegativeOffset, negativeOffset, !oldNegativeOffsetESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetNegativeOffset() {
		long oldNegativeOffset = negativeOffset;
		boolean oldNegativeOffsetESet = negativeOffsetESet;
		negativeOffset = NEGATIVE_OFFSET_EDEFAULT;
		negativeOffsetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, LocationPackage.LINEAR_LOCATION__NEGATIVE_OFFSET, oldNegativeOffset, NEGATIVE_OFFSET_EDEFAULT, oldNegativeOffsetESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetNegativeOffset() {
		return negativeOffsetESet;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LocationPackage.LINEAR_LOCATION__SEGMENTS:
				return getSegments();
			case LocationPackage.LINEAR_LOCATION__POSITIVE_OFFSET:
				return getPositiveOffset();
			case LocationPackage.LINEAR_LOCATION__NEGATIVE_OFFSET:
				return getNegativeOffset();
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
			case LocationPackage.LINEAR_LOCATION__SEGMENTS:
				getSegments().clear();
				getSegments().addAll((Collection<? extends Long>)newValue);
				return;
			case LocationPackage.LINEAR_LOCATION__POSITIVE_OFFSET:
				setPositiveOffset((Long)newValue);
				return;
			case LocationPackage.LINEAR_LOCATION__NEGATIVE_OFFSET:
				setNegativeOffset((Long)newValue);
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
			case LocationPackage.LINEAR_LOCATION__SEGMENTS:
				getSegments().clear();
				return;
			case LocationPackage.LINEAR_LOCATION__POSITIVE_OFFSET:
				unsetPositiveOffset();
				return;
			case LocationPackage.LINEAR_LOCATION__NEGATIVE_OFFSET:
				unsetNegativeOffset();
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
			case LocationPackage.LINEAR_LOCATION__SEGMENTS:
				return segments != null && !segments.isEmpty();
			case LocationPackage.LINEAR_LOCATION__POSITIVE_OFFSET:
				return isSetPositiveOffset();
			case LocationPackage.LINEAR_LOCATION__NEGATIVE_OFFSET:
				return isSetNegativeOffset();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String toString() {
//		if (eIsProxy()) return super.toString();
//
//		StringBuffer result = new StringBuffer(super.toString());
//		result.append(" (segments: ");
//		result.append(segments);
//		result.append(')');
//		return result.toString();
		StringBuffer result = new StringBuffer();

		boolean first = true;
		for (long segment: segments) {
			if (first) {
				first = false;
			} else {
				result.append(",");
			}
			result.append(segment);
		}

		return result.toString();
	}

} //LinearLocationImpl
