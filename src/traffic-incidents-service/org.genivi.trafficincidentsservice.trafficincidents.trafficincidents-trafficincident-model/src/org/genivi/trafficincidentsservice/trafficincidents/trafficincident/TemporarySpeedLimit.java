/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident;

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
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getTemporarySpeedLimitSections <em>Temporary Speed Limit Sections</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#isUnitsMPH <em>Units MPH</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getApplicability <em>Applicability</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTemporarySpeedLimit()
 * @model
 * @generated
 */
public interface TemporarySpeedLimit extends EObject {
	/**
	 * Returns the value of the '<em><b>Temporary Speed Limit Sections</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temporary Speed Limit Sections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temporary Speed Limit Sections</em>' containment reference list.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTemporarySpeedLimit_TemporarySpeedLimitSections()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TemporarySpeedLimitSection> getTemporarySpeedLimitSections();

	/**
	 * Returns the value of the '<em><b>Units MPH</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units MPH</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units MPH</em>' attribute.
	 * @see #isSetUnitsMPH()
	 * @see #unsetUnitsMPH()
	 * @see #setUnitsMPH(boolean)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTemporarySpeedLimit_UnitsMPH()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
	boolean isUnitsMPH();

	/**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#isUnitsMPH <em>Units MPH</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Units MPH</em>' attribute.
	 * @see #isSetUnitsMPH()
	 * @see #unsetUnitsMPH()
	 * @see #isUnitsMPH()
	 * @generated
	 */
	void setUnitsMPH(boolean value);

	/**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#isUnitsMPH <em>Units MPH</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnitsMPH()
	 * @see #isUnitsMPH()
	 * @see #setUnitsMPH(boolean)
	 * @generated
	 */
	void unsetUnitsMPH();

	/**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#isUnitsMPH <em>Units MPH</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Units MPH</em>' attribute is set.
	 * @see #unsetUnitsMPH()
	 * @see #isUnitsMPH()
	 * @see #setUnitsMPH(boolean)
	 * @generated
	 */
	boolean isSetUnitsMPH();

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
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTemporarySpeedLimit_Offset()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getOffset();

	/**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getOffset <em>Offset</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffset()
	 * @see #getOffset()
	 * @see #setOffset(Integer)
	 * @generated
	 */
	void unsetOffset();

	/**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getOffset <em>Offset</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Applicability</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applicability</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicability</em>' containment reference list.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTemporarySpeedLimit_Applicability()
	 * @model containment="true"
	 * @generated
	 */
	EList<Applicability> getApplicability();

} // TemporarySpeedLimit
