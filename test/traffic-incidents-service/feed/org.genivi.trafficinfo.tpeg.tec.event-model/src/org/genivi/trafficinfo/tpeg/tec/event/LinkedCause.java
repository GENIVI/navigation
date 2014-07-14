/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event;

import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linked Cause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getLinkedMessage <em>Linked Message</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getCOID <em>COID</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getOriginatorSID <em>Originator SID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getLinkedCause()
 * @model
 * @generated
 */
public interface LinkedCause extends Cause {
	/**
	 * Returns the value of the '<em><b>Linked Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Linked Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Linked Message</em>' attribute.
	 * @see #isSetLinkedMessage()
	 * @see #unsetLinkedMessage()
	 * @see #setLinkedMessage(Integer)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getLinkedCause_LinkedMessage()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  Integer getLinkedMessage();

  /**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getLinkedMessage <em>Linked Message</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked Message</em>' attribute.
	 * @see #isSetLinkedMessage()
	 * @see #unsetLinkedMessage()
	 * @see #getLinkedMessage()
	 * @generated
	 */
  void setLinkedMessage(Integer value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getLinkedMessage <em>Linked Message</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLinkedMessage()
	 * @see #getLinkedMessage()
	 * @see #setLinkedMessage(Integer)
	 * @generated
	 */
  void unsetLinkedMessage();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getLinkedMessage <em>Linked Message</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linked Message</em>' attribute is set.
	 * @see #unsetLinkedMessage()
	 * @see #getLinkedMessage()
	 * @see #setLinkedMessage(Integer)
	 * @generated
	 */
  boolean isSetLinkedMessage();

  /**
	 * Returns the value of the '<em><b>COID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>COID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>COID</em>' attribute.
	 * @see #isSetCOID()
	 * @see #unsetCOID()
	 * @see #setCOID(byte)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getLinkedCause_COID()
	 * @model unsettable="true"
	 * @generated
	 */
  byte getCOID();

  /**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getCOID <em>COID</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>COID</em>' attribute.
	 * @see #isSetCOID()
	 * @see #unsetCOID()
	 * @see #getCOID()
	 * @generated
	 */
  void setCOID(byte value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getCOID <em>COID</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetCOID()
	 * @see #getCOID()
	 * @see #setCOID(byte)
	 * @generated
	 */
  void unsetCOID();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getCOID <em>COID</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>COID</em>' attribute is set.
	 * @see #unsetCOID()
	 * @see #getCOID()
	 * @see #setCOID(byte)
	 * @generated
	 */
  boolean isSetCOID();

  /**
	 * Returns the value of the '<em><b>Originator SID</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Originator SID</em>' containment reference.
	 * @see #setOriginatorSID(ServiceIdentifier)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getLinkedCause_OriginatorSID()
	 * @model containment="true"
	 * @generated
	 */
  ServiceIdentifier getOriginatorSID();

  /**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getOriginatorSID <em>Originator SID</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Originator SID</em>' containment reference.
	 * @see #getOriginatorSID()
	 * @generated
	 */
  void setOriginatorSID(ServiceIdentifier value);

} // LinkedCause
