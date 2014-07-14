/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MMC Master Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMasterMessage#getMultiPartMessageDirectory <em>Multi Part Message Directory</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCMasterMessage()
 * @model
 * @generated
 */
public interface MMCMasterMessage extends MMCSwitch {
  /**
   * Returns the value of the '<em><b>Multi Part Message Directory</b></em>' containment reference list.
   * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multi Part Message Directory</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multi Part Message Directory</em>' containment reference list.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getMMCMasterMessage_MultiPartMessageDirectory()
   * @model containment="true" required="true" upper="255"
   * @generated
   */
  EList<MultiPartMessageDirectory> getMultiPartMessageDirectory();

} // MMCMasterMessage
