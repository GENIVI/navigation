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
 * A representation of the model object '<em><b>Cause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Cause#getMainCause <em>Main Cause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getCause()
 * @model
 * @generated
 */
public interface Cause extends EObject {
	/**
	 * Returns the value of the '<em><b>Main Cause</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficinfo.tpeg.tec.event.CauseCode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Cause</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Cause</em>' attribute.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.CauseCode
	 * @see #isSetMainCause()
	 * @see #unsetMainCause()
	 * @see #setMainCause(CauseCode)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getCause_MainCause()
	 * @model unsettable="true"
	 * @generated
	 */
	CauseCode getMainCause();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Cause#getMainCause <em>Main Cause</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Cause</em>' attribute.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.CauseCode
	 * @see #isSetMainCause()
	 * @see #unsetMainCause()
	 * @see #getMainCause()
	 * @generated
	 */
	void setMainCause(CauseCode value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Cause#getMainCause <em>Main Cause</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetMainCause()
	 * @see #getMainCause()
	 * @see #setMainCause(CauseCode)
	 * @generated
	 */
  void unsetMainCause();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Cause#getMainCause <em>Main Cause</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Main Cause</em>' attribute is set.
	 * @see #unsetMainCause()
	 * @see #getMainCause()
	 * @see #setMainCause(CauseCode)
	 * @generated
	 */
  boolean isSetMainCause();

} // Cause
