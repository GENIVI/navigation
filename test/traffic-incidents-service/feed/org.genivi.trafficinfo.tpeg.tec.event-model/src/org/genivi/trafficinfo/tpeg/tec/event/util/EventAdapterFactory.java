/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event.util;


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.genivi.trafficinfo.tpeg.tec.event.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage
 * @generated
 */
public class EventAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static EventPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EventAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EventPackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EventSwitch<Adapter> modelSwitch =
    new EventSwitch<Adapter>() {
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseCause(Cause object) {
				return createCauseAdapter();
			}
			@Override
			public Adapter caseLinkedCause(LinkedCause object) {
				return createLinkedCauseAdapter();
			}
			@Override
			public Adapter caseDirectCause(DirectCause object) {
				return createDirectCauseAdapter();
			}
			@Override
			public Adapter caseAdvice(Advice object) {
				return createAdviceAdapter();
			}
			@Override
			public Adapter caseVehicleRestriction(VehicleRestriction object) {
				return createVehicleRestrictionAdapter();
			}
			@Override
			public Adapter caseVehicleRelatedRestriction(VehicleRelatedRestriction object) {
				return createVehicleRelatedRestrictionAdapter();
			}
			@Override
			public Adapter caseTECMessage(TECMessage object) {
				return createTECMessageAdapter();
			}
			@Override
			public Adapter caseTemporarySpeedLimitSection(TemporarySpeedLimitSection object) {
				return createTemporarySpeedLimitSectionAdapter();
			}
			@Override
			public Adapter caseTemporarySpeedLimit(TemporarySpeedLimit object) {
				return createTemporarySpeedLimitAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tec.event.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event
	 * @generated
	 */
  public Adapter createEventAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tec.event.Cause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Cause
	 * @generated
	 */
  public Adapter createCauseAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause <em>Linked Cause</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.LinkedCause
	 * @generated
	 */
  public Adapter createLinkedCauseAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tec.event.DirectCause <em>Direct Cause</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DirectCause
	 * @generated
	 */
  public Adapter createDirectCauseAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Advice
	 * @generated
	 */
  public Adapter createAdviceAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction <em>Vehicle Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction
	 * @generated
	 */
  public Adapter createVehicleRestrictionAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction <em>Vehicle Related Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction
	 * @generated
	 */
  public Adapter createVehicleRelatedRestrictionAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage <em>TEC Message</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TECMessage
	 * @generated
	 */
  public Adapter createTECMessageAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection <em>Temporary Speed Limit Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection
	 * @generated
	 */
	public Adapter createTemporarySpeedLimitSectionAdapter() {
		return null;
	}

		/**
	 * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit <em>Temporary Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit
	 * @generated
	 */
	public Adapter createTemporarySpeedLimitAdapter() {
		return null;
	}

		/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter() {
		return null;
	}

} //EventAdapterFactory
