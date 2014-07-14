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
 * A representation of the model object '<em><b>Service Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getServEncID <em>Serv Enc ID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getServiceFrameContent <em>Service Frame Content</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getSID <em>SID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceFrame()
 * @model
 * @generated
 */
public interface ServiceFrame extends EObject {
  /**
   * Returns the value of the '<em><b>Serv Enc ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Serv Enc ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Serv Enc ID</em>' attribute.
   * @see #setServEncID(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceFrame_ServEncID()
   * @model required="true"
   * @generated
   */
  int getServEncID();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getServEncID <em>Serv Enc ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Serv Enc ID</em>' attribute.
   * @see #getServEncID()
   * @generated
   */
  void setServEncID(int value);

  /**
   * Returns the value of the '<em><b>Service Frame Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service Frame Content</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service Frame Content</em>' containment reference.
   * @see #setServiceFrameContent(ServCompMultiplex)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceFrame_ServiceFrameContent()
   * @model containment="true" required="true"
   * @generated
   */
  ServCompMultiplex getServiceFrameContent();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getServiceFrameContent <em>Service Frame Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Service Frame Content</em>' containment reference.
   * @see #getServiceFrameContent()
   * @generated
   */
  void setServiceFrameContent(ServCompMultiplex value);

  /**
   * Returns the value of the '<em><b>SID</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>SID</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>SID</em>' containment reference.
   * @see #setSID(ServiceIdentifier)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getServiceFrame_SID()
   * @model containment="true" required="true"
   * @generated
   */
  ServiceIdentifier getSID();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getSID <em>SID</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>SID</em>' containment reference.
   * @see #getSID()
   * @generated
   */
  void setSID(ServiceIdentifier value);

} // ServiceFrame
