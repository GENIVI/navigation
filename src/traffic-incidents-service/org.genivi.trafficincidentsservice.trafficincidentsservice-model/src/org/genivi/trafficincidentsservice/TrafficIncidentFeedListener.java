/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

import org.eclipse.emf.ecore.EObject;

import org.genivi.common.Version;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traffic Incidents Updates Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getTrafficIncidentFeedListener()
 * @model
 * @generated
 */
public interface TrafficIncidentFeedListener extends EObject {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method is called as a response to getVersion().
	 * @param version The API version of this interface implemented by the service.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void getVersionReply(Version version);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method is called as a response to getLanguage() or addLanguegeListener() when the language is changed.
	 * @param languageCode The currently used language.
	 * @param countryCode The currently used, country specific variant of the language.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void getLanguageReply(String languageCode, String countryCode);

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerFeedReply(int feedId);

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void addLanguageListenerReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeLanguageListenerReply();

} // TrafficIncidentFeedListener
