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
 * A representation of the model object '<em><b>Multi Part Message Directory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory#getPartID <em>Part ID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory#getPartType <em>Part Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMultiPartMessageDirectory()
 * @model
 * @generated
 */
public interface MultiPartMessageDirectory extends EObject {
  /**
   * Returns the value of the '<em><b>Part ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Part ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Part ID</em>' attribute.
   * @see #setPartID(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMultiPartMessageDirectory_PartID()
   * @model required="true"
   * @generated
   */
  int getPartID();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory#getPartID <em>Part ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Part ID</em>' attribute.
   * @see #getPartID()
   * @generated
   */
  void setPartID(int value);

  /**
   * Returns the value of the '<em><b>Part Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * TODO: change type to TPEG PartType
   * <!-- end-model-doc -->
   * @return the value of the '<em>Part Type</em>' attribute.
   * @see #setPartType(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMultiPartMessageDirectory_PartType()
   * @model required="true"
   * @generated
   */
  int getPartType();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory#getPartType <em>Part Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Part Type</em>' attribute.
   * @see #getPartType()
   * @generated
   */
  void setPartType(int value);

} // MultiPartMessageDirectory
