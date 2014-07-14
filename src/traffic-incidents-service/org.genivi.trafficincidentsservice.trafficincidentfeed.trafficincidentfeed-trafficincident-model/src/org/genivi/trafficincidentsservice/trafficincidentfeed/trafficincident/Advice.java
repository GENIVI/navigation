/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.genivi.common.LocalizedString;

import org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getMainAdvice <em>Main Advice</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getSubAdvice <em>Sub Advice</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getFreeText <em>Free Text</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getApplicability <em>Applicability</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getAdvice()
 * @model
 * @generated
 */
public interface Advice extends EObject {
  /**
	 * Returns the value of the '<em><b>Main Advice</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Main Advice</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Advice</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode
	 * @see #isSetMainAdvice()
	 * @see #unsetMainAdvice()
	 * @see #setMainAdvice(AdviceCode)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getAdvice_MainAdvice()
	 * @model unsettable="true"
	 * @generated
	 */
  AdviceCode getMainAdvice();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getMainAdvice <em>Main Advice</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Advice</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.AdviceCode
	 * @see #isSetMainAdvice()
	 * @see #unsetMainAdvice()
	 * @see #getMainAdvice()
	 * @generated
	 */
  void setMainAdvice(AdviceCode value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getMainAdvice <em>Main Advice</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetMainAdvice()
	 * @see #getMainAdvice()
	 * @see #setMainAdvice(AdviceCode)
	 * @generated
	 */
  void unsetMainAdvice();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getMainAdvice <em>Main Advice</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Main Advice</em>' attribute is set.
	 * @see #unsetMainAdvice()
	 * @see #getMainAdvice()
	 * @see #setMainAdvice(AdviceCode)
	 * @generated
	 */
  boolean isSetMainAdvice();

  /**
	 * Returns the value of the '<em><b>Sub Advice</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The actual value of this atttribute depends on the adviceCode. So based on the adviceCode it has to be cast to the related enum.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Advice</em>' attribute.
	 * @see #isSetSubAdvice()
	 * @see #unsetSubAdvice()
	 * @see #setSubAdvice(Object)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getAdvice_SubAdvice()
	 * @model unsettable="true"
	 * @generated
	 */
  Object getSubAdvice();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getSubAdvice <em>Sub Advice</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Advice</em>' attribute.
	 * @see #isSetSubAdvice()
	 * @see #unsetSubAdvice()
	 * @see #getSubAdvice()
	 * @generated
	 */
  void setSubAdvice(Object value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getSubAdvice <em>Sub Advice</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSubAdvice()
	 * @see #getSubAdvice()
	 * @see #setSubAdvice(Object)
	 * @generated
	 */
  void unsetSubAdvice();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getSubAdvice <em>Sub Advice</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sub Advice</em>' attribute is set.
	 * @see #unsetSubAdvice()
	 * @see #getSubAdvice()
	 * @see #setSubAdvice(Object)
	 * @generated
	 */
  boolean isSetSubAdvice();

  /**
	 * Returns the value of the '<em><b>Free Text</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.common.LocalizedString}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Free Text</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Free Text</em>' containment reference list.
	 * @see #isSetFreeText()
	 * @see #unsetFreeText()
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getAdvice_FreeText()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<LocalizedString> getFreeText();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getFreeText <em>Free Text</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetFreeText()
	 * @see #getFreeText()
	 * @generated
	 */
  void unsetFreeText();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getFreeText <em>Free Text</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Free Text</em>' containment reference list is set.
	 * @see #unsetFreeText()
	 * @see #getFreeText()
	 * @generated
	 */
  boolean isSetFreeText();

  /**
	 * Returns the value of the '<em><b>Applicability</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applicability</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicability</em>' containment reference list.
	 * @see #isSetApplicability()
	 * @see #unsetApplicability()
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getAdvice_Applicability()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<Applicability> getApplicability();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getApplicability <em>Applicability</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetApplicability()
	 * @see #getApplicability()
	 * @generated
	 */
  void unsetApplicability();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getApplicability <em>Applicability</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applicability</em>' containment reference list is set.
	 * @see #unsetApplicability()
	 * @see #getApplicability()
	 * @generated
	 */
  boolean isSetApplicability();

} // Advice
