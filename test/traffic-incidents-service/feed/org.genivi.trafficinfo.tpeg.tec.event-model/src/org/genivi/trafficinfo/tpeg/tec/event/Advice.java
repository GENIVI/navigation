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
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getAdviceCode <em>Advice Code</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getSubAdviceCode <em>Sub Advice Code</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getFreeText <em>Free Text</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getVehicleRestriction <em>Vehicle Restriction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getAdvice()
 * @model
 * @generated
 */
public interface Advice extends EObject {
  /**
	 * Returns the value of the '<em><b>Advice Code</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficinfo.tpeg.tec.event.AdviceCode}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Advice Code</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice Code</em>' attribute.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.AdviceCode
	 * @see #isSetAdviceCode()
	 * @see #unsetAdviceCode()
	 * @see #setAdviceCode(AdviceCode)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getAdvice_AdviceCode()
	 * @model unsettable="true"
	 * @generated
	 */
  AdviceCode getAdviceCode();

  /**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getAdviceCode <em>Advice Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Advice Code</em>' attribute.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.AdviceCode
	 * @see #isSetAdviceCode()
	 * @see #unsetAdviceCode()
	 * @see #getAdviceCode()
	 * @generated
	 */
  void setAdviceCode(AdviceCode value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getAdviceCode <em>Advice Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAdviceCode()
	 * @see #getAdviceCode()
	 * @see #setAdviceCode(AdviceCode)
	 * @generated
	 */
  void unsetAdviceCode();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getAdviceCode <em>Advice Code</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Advice Code</em>' attribute is set.
	 * @see #unsetAdviceCode()
	 * @see #getAdviceCode()
	 * @see #setAdviceCode(AdviceCode)
	 * @generated
	 */
  boolean isSetAdviceCode();

  /**
	 * Returns the value of the '<em><b>Sub Advice Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Advice Code</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Advice Code</em>' attribute.
	 * @see #isSetSubAdviceCode()
	 * @see #unsetSubAdviceCode()
	 * @see #setSubAdviceCode(Object)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getAdvice_SubAdviceCode()
	 * @model unsettable="true"
	 * @generated
	 */
  Object getSubAdviceCode();

  /**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getSubAdviceCode <em>Sub Advice Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Advice Code</em>' attribute.
	 * @see #isSetSubAdviceCode()
	 * @see #unsetSubAdviceCode()
	 * @see #getSubAdviceCode()
	 * @generated
	 */
  void setSubAdviceCode(Object value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getSubAdviceCode <em>Sub Advice Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSubAdviceCode()
	 * @see #getSubAdviceCode()
	 * @see #setSubAdviceCode(Object)
	 * @generated
	 */
  void unsetSubAdviceCode();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getSubAdviceCode <em>Sub Advice Code</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sub Advice Code</em>' attribute is set.
	 * @see #unsetSubAdviceCode()
	 * @see #getSubAdviceCode()
	 * @see #setSubAdviceCode(Object)
	 * @generated
	 */
  boolean isSetSubAdviceCode();

  /**
	 * Returns the value of the '<em><b>Free Text</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Free Text</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Free Text</em>' containment reference list.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getAdvice_FreeText()
	 * @model containment="true"
	 * @generated
	 */
  EList<LocalisedShortString> getFreeText();

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
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getAdvice_VehicleRestriction()
	 * @model containment="true"
	 * @generated
	 */
  EList<VehicleRestriction> getVehicleRestriction();

} // Advice
