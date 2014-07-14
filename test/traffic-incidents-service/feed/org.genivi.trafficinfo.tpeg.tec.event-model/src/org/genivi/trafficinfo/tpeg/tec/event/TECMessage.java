/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event;

import org.eclipse.emf.ecore.EObject;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TEC Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getMmt <em>Mmt</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getEvent <em>Event</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getLoc <em>Loc</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTECMessage()
 * @model
 * @generated
 */
public interface TECMessage extends EObject {

  /**
	 * Returns the value of the '<em><b>Mmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mmt</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Mmt</em>' containment reference.
	 * @see #setMmt(MMCSwitch)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTECMessage_Mmt()
	 * @model containment="true" required="true"
	 * @generated
	 */
  MMCSwitch getMmt();

  /**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getMmt <em>Mmt</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mmt</em>' containment reference.
	 * @see #getMmt()
	 * @generated
	 */
  void setMmt(MMCSwitch value);

  /**
	 * Returns the value of the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' containment reference.
	 * @see #setEvent(Event)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTECMessage_Event()
	 * @model containment="true"
	 * @generated
	 */
  Event getEvent();

  /**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getEvent <em>Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' containment reference.
	 * @see #getEvent()
	 * @generated
	 */
  void setEvent(Event value);

  /**
	 * Returns the value of the '<em><b>Loc</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Loc</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Loc</em>' containment reference.
	 * @see #setLoc(LocationReferencingContainer)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getTECMessage_Loc()
	 * @model containment="true"
	 * @generated
	 */
  LocationReferencingContainer getLoc();

  /**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getLoc <em>Loc</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loc</em>' containment reference.
	 * @see #getLoc()
	 * @generated
	 */
  void setLoc(LocationReferencingContainer value);
} // TECMessage
