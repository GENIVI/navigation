/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.genivi.trafficinfo.tpeg.tec.event.*;
import org.genivi.trafficinfo.tpeg.tec.event.Advice;
import org.genivi.trafficinfo.tpeg.tec.event.Cause;
import org.genivi.trafficinfo.tpeg.tec.event.DirectCause;
import org.genivi.trafficinfo.tpeg.tec.event.Event;
import org.genivi.trafficinfo.tpeg.tec.event.EventPackage;
import org.genivi.trafficinfo.tpeg.tec.event.LinkedCause;
import org.genivi.trafficinfo.tpeg.tec.event.TECMessage;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction;


/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage
 * @generated
 */
public class EventSwitch<T> extends Switch<T> {
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static EventPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EventSwitch() {
		if (modelPackage == null) {
			modelPackage = EventPackage.eINSTANCE;
		}
	}

  /**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EventPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventPackage.CAUSE: {
				Cause cause = (Cause)theEObject;
				T result = caseCause(cause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventPackage.LINKED_CAUSE: {
				LinkedCause linkedCause = (LinkedCause)theEObject;
				T result = caseLinkedCause(linkedCause);
				if (result == null) result = caseCause(linkedCause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventPackage.DIRECT_CAUSE: {
				DirectCause directCause = (DirectCause)theEObject;
				T result = caseDirectCause(directCause);
				if (result == null) result = caseCause(directCause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventPackage.ADVICE: {
				Advice advice = (Advice)theEObject;
				T result = caseAdvice(advice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventPackage.VEHICLE_RESTRICTION: {
				VehicleRestriction vehicleRestriction = (VehicleRestriction)theEObject;
				T result = caseVehicleRestriction(vehicleRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventPackage.VEHICLE_RELATED_RESTRICTION: {
				VehicleRelatedRestriction vehicleRelatedRestriction = (VehicleRelatedRestriction)theEObject;
				T result = caseVehicleRelatedRestriction(vehicleRelatedRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventPackage.TEC_MESSAGE: {
				TECMessage tecMessage = (TECMessage)theEObject;
				T result = caseTECMessage(tecMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventPackage.TEMPORARY_SPEED_LIMIT_SECTION: {
				TemporarySpeedLimitSection temporarySpeedLimitSection = (TemporarySpeedLimitSection)theEObject;
				T result = caseTemporarySpeedLimitSection(temporarySpeedLimitSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventPackage.TEMPORARY_SPEED_LIMIT: {
				TemporarySpeedLimit temporarySpeedLimit = (TemporarySpeedLimit)theEObject;
				T result = caseTemporarySpeedLimit(temporarySpeedLimit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseEvent(Event object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Cause</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCause(Cause object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Linked Cause</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linked Cause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLinkedCause(LinkedCause object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Direct Cause</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direct Cause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDirectCause(DirectCause object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Advice</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Advice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAdvice(Advice object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Vehicle Restriction</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vehicle Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVehicleRestriction(VehicleRestriction object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Vehicle Related Restriction</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vehicle Related Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVehicleRelatedRestriction(VehicleRelatedRestriction object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>TEC Message</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TEC Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTECMessage(TECMessage object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Temporary Speed Limit Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Temporary Speed Limit Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemporarySpeedLimitSection(TemporarySpeedLimitSection object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Temporary Speed Limit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Temporary Speed Limit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemporarySpeedLimit(TemporarySpeedLimit object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  @Override
  public T defaultCase(EObject object) {
		return null;
	}

} //EventSwitch
