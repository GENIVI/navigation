/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sni Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getId <em>Id</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getN <em>N</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getSniComponent()
 * @model
 * @generated
 */
public interface SniComponent extends EObject {

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Component identifier
   * <!-- end-model-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #setId(byte)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getSniComponent_Id()
   * @model unsettable="true" required="true"
   * @generated
   */
  byte getId();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #isSetId()
   * @see #unsetId()
   * @see #getId()
   * @generated
   */
  void setId(byte value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetId()
   * @see #getId()
   * @see #setId(byte)
   * @generated
   */
  void unsetId();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getId <em>Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Id</em>' attribute is set.
   * @see #unsetId()
   * @see #getId()
   * @see #setId(byte)
   * @generated
   */
  boolean isSetId();

  /**
   * Returns the value of the '<em><b>N</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Length of component data in bytes.
   * <!-- end-model-doc -->
   * @return the value of the '<em>N</em>' attribute.
   * @see #isSetN()
   * @see #unsetN()
   * @see #setN(int)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getSniComponent_N()
   * @model unsettable="true" required="true"
   * @generated
   */
  int getN();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getN <em>N</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>N</em>' attribute.
   * @see #isSetN()
   * @see #unsetN()
   * @see #getN()
   * @generated
   */
  void setN(int value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getN <em>N</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetN()
   * @see #getN()
   * @see #setN(int)
   * @generated
   */
  void unsetN();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getN <em>N</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>N</em>' attribute is set.
   * @see #unsetN()
   * @see #getN()
   * @see #setN(int)
   * @generated
   */
  boolean isSetN();
} // SniComponent
