/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Temporary Speed Limit Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValue <em>Speed Limit Value</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValueWet <em>Speed Limit Value Wet</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitLength <em>Speed Limit Length</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTemporarySpeedLimitSection()
 * @model
 * @generated
 */
public interface TemporarySpeedLimitSection extends EObject {
	/**
	 * Returns the value of the '<em><b>Speed Limit Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speed Limit Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed Limit Value</em>' attribute.
	 * @see #isSetSpeedLimitValue()
	 * @see #unsetSpeedLimitValue()
	 * @see #setSpeedLimitValue(byte)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTemporarySpeedLimitSection_SpeedLimitValue()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
	byte getSpeedLimitValue();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValue <em>Speed Limit Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed Limit Value</em>' attribute.
	 * @see #isSetSpeedLimitValue()
	 * @see #unsetSpeedLimitValue()
	 * @see #getSpeedLimitValue()
	 * @generated
	 */
	void setSpeedLimitValue(byte value);

	/**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValue <em>Speed Limit Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpeedLimitValue()
	 * @see #getSpeedLimitValue()
	 * @see #setSpeedLimitValue(byte)
	 * @generated
	 */
	void unsetSpeedLimitValue();

	/**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValue <em>Speed Limit Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Speed Limit Value</em>' attribute is set.
	 * @see #unsetSpeedLimitValue()
	 * @see #getSpeedLimitValue()
	 * @see #setSpeedLimitValue(byte)
	 * @generated
	 */
	boolean isSetSpeedLimitValue();

	/**
	 * Returns the value of the '<em><b>Speed Limit Value Wet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speed Limit Value Wet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed Limit Value Wet</em>' attribute.
	 * @see #isSetSpeedLimitValueWet()
	 * @see #unsetSpeedLimitValueWet()
	 * @see #setSpeedLimitValueWet(byte)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTemporarySpeedLimitSection_SpeedLimitValueWet()
	 * @model unsettable="true"
	 * @generated
	 */
	byte getSpeedLimitValueWet();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValueWet <em>Speed Limit Value Wet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed Limit Value Wet</em>' attribute.
	 * @see #isSetSpeedLimitValueWet()
	 * @see #unsetSpeedLimitValueWet()
	 * @see #getSpeedLimitValueWet()
	 * @generated
	 */
	void setSpeedLimitValueWet(byte value);

	/**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValueWet <em>Speed Limit Value Wet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpeedLimitValueWet()
	 * @see #getSpeedLimitValueWet()
	 * @see #setSpeedLimitValueWet(byte)
	 * @generated
	 */
	void unsetSpeedLimitValueWet();

	/**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValueWet <em>Speed Limit Value Wet</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Speed Limit Value Wet</em>' attribute is set.
	 * @see #unsetSpeedLimitValueWet()
	 * @see #getSpeedLimitValueWet()
	 * @see #setSpeedLimitValueWet(byte)
	 * @generated
	 */
	boolean isSetSpeedLimitValueWet();

	/**
	 * Returns the value of the '<em><b>Speed Limit Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speed Limit Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed Limit Length</em>' attribute.
	 * @see #isSetSpeedLimitLength()
	 * @see #unsetSpeedLimitLength()
	 * @see #setSpeedLimitLength(Integer)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTemporarySpeedLimitSection_SpeedLimitLength()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getSpeedLimitLength();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitLength <em>Speed Limit Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed Limit Length</em>' attribute.
	 * @see #isSetSpeedLimitLength()
	 * @see #unsetSpeedLimitLength()
	 * @see #getSpeedLimitLength()
	 * @generated
	 */
	void setSpeedLimitLength(Integer value);

	/**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitLength <em>Speed Limit Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpeedLimitLength()
	 * @see #getSpeedLimitLength()
	 * @see #setSpeedLimitLength(Integer)
	 * @generated
	 */
	void unsetSpeedLimitLength();

	/**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitLength <em>Speed Limit Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Speed Limit Length</em>' attribute is set.
	 * @see #unsetSpeedLimitLength()
	 * @see #getSpeedLimitLength()
	 * @see #setSpeedLimitLength(Integer)
	 * @generated
	 */
	boolean isSetSpeedLimitLength();

} // TemporarySpeedLimitSection
