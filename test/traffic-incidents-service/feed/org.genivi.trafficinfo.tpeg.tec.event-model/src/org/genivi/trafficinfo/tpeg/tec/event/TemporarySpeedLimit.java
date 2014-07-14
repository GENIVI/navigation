/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Temporary Speed Limit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getSpeedLimitSection <em>Speed Limit Section</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#isUnitsMPH <em>Units MPH</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getVehicleRestriction <em>Vehicle Restriction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTemporarySpeedLimit()
 * @model
 * @generated
 */
public interface TemporarySpeedLimit extends EObject {
	/**
	 * Returns the value of the '<em><b>Speed Limit Section</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speed Limit Section</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed Limit Section</em>' containment reference list.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTemporarySpeedLimit_SpeedLimitSection()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TemporarySpeedLimitSection> getSpeedLimitSection();

	/**
	 * Returns the value of the '<em><b>Units MPH</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units MPH</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units MPH</em>' attribute.
	 * @see #setUnitsMPH(boolean)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTemporarySpeedLimit_UnitsMPH()
	 * @model required="true"
	 * @generated
	 */
	boolean isUnitsMPH();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#isUnitsMPH <em>Units MPH</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Units MPH</em>' attribute.
	 * @see #isUnitsMPH()
	 * @generated
	 */
	void setUnitsMPH(boolean value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #isSetOffset()
	 * @see #unsetOffset()
	 * @see #setOffset(Integer)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTemporarySpeedLimit_Offset()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getOffset();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #isSetOffset()
	 * @see #unsetOffset()
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(Integer value);

	/**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffset()
	 * @see #getOffset()
	 * @see #setOffset(Integer)
	 * @generated
	 */
	void unsetOffset();

	/**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getOffset <em>Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset</em>' attribute is set.
	 * @see #unsetOffset()
	 * @see #getOffset()
	 * @see #setOffset(Integer)
	 * @generated
	 */
	boolean isSetOffset();

	/**
	 * Returns the value of the '<em><b>Vehicle Restriction</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicle Restriction</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Restriction</em>' containment reference list.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTemporarySpeedLimit_VehicleRestriction()
	 * @model containment="true"
	 * @generated
	 */
	EList<VehicleRestriction> getVehicleRestriction();

} // TemporarySpeedLimit
