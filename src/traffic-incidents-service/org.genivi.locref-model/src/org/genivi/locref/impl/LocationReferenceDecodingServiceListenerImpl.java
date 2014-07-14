/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.locref.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.location.Location;

import org.genivi.location.LocationInfo;
import org.genivi.locref.LocationReferenceDecodingServiceListener;
import org.genivi.locref.locrefPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Location Reference Decoding Service Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LocationReferenceDecodingServiceListenerImpl extends EObjectImpl implements LocationReferenceDecodingServiceListener {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected LocationReferenceDecodingServiceListenerImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return locrefPackage.Literals.LOCATION_REFERENCE_DECODING_SERVICE_LISTENER;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void decodeReply(Location location, LocationInfo locationInfo) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void getLanguageReply(String languageCode, String countryCode) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //LocationReferenceDecodingServiceListenerImpl
