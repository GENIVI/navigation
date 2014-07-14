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
 * A representation of the model object '<em><b>Location Referencing Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer#getMethod <em>Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getLocationReferencingContainer()
 * @model
 * @generated
 */
public interface LocationReferencingContainer extends EObject {

  /**
   * Returns the value of the '<em><b>Method</b></em>' containment reference list.
   * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tpegfwktypes.Method}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method</em>' containment reference list.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getLocationReferencingContainer_Method()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Method> getMethod();
} // LocationReferencingContainer
