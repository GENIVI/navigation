/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Serv Comp Multiplex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex#getMultiplexContent <em>Multiplex Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServCompMultiplex()
 * @model
 * @generated
 */
public interface ServCompMultiplex extends EObject {
  /**
   * Returns the value of the '<em><b>Multiplex Content</b></em>' containment reference list.
   * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplex Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplex Content</em>' containment reference list.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServCompMultiplex_MultiplexContent()
   * @model containment="true" required="true"
   * @generated
   */
  EList<ServiceComponentFrame> getMultiplexContent();

} // ServCompMultiplex
