/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidA <em>Sid A</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidB <em>Sid B</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidC <em>Sid C</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceIdentifier()
 * @model
 * @generated
 */
public interface ServiceIdentifier extends EObject {
  /**
   * Returns the value of the '<em><b>Sid A</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sid A</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sid A</em>' attribute.
   * @see #setSidA(byte)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceIdentifier_SidA()
   * @model required="true"
   * @generated
   */
  byte getSidA();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidA <em>Sid A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sid A</em>' attribute.
   * @see #getSidA()
   * @generated
   */
  void setSidA(byte value);

  /**
   * Returns the value of the '<em><b>Sid B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sid B</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sid B</em>' attribute.
   * @see #setSidB(byte)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceIdentifier_SidB()
   * @model required="true"
   * @generated
   */
  byte getSidB();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidB <em>Sid B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sid B</em>' attribute.
   * @see #getSidB()
   * @generated
   */
  void setSidB(byte value);

  /**
   * Returns the value of the '<em><b>Sid C</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sid C</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sid C</em>' attribute.
   * @see #setSidC(byte)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceIdentifier_SidC()
   * @model required="true"
   * @generated
   */
  byte getSidC();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidC <em>Sid C</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sid C</em>' attribute.
   * @see #getSidC()
   * @generated
   */
  void setSidC(byte value);

} // ServiceIdentifier
