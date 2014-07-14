/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traffic Incidents Updates</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This interface can be used by Traffic Incident Feeds to feed Traffic Incidents into the Traffic Incidents Service.
 * <!-- end-model-doc -->
 *
 *
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getTrafficIncidentFeed()
 * @model
 * @generated
 */
public interface TrafficIncidentFeed extends EObject {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the API version of this interface implemented by the service.
	 * @param listener The class on which the callback function is called.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void getVersion(TrafficIncidentFeedListener listener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the current language. In case of a client/server based Feed, this language can be sent to the server in order to receive any textual information in the right language.
	 * @param listener The class on which the callback function is called.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void getLanguage(TrafficIncidentFeedListener listener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Add this client as a listener for changes in the current language. In case of changes, getLanguageReply() is called on the listener.
	 * @param listener The class on which the callback function is called.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void addLanguageListener(TrafficIncidentFeedListener listener, TrafficIncidentFeedListener changeListener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Clear the internal store of the Traffic Incidents Service. This may be needed if the source of the Traffic Incidents is changed, or if the server indicates that a reset is needed.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void clear();

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Update the Traffic Incidents in the internal store of the Traffic Incidents Service. These updates can consist of incidents to be removed (cancelledIncidentIds), and/or new or updated incidents (updatedIncidents). The 'cancels' are handled before the 'updates'.
	 * @param cancelledIncidentIds The unique Ids of the incidents to be deleted.
	 * @param updatedIncidents The new or updated incidents.
	 * <!-- end-model-doc -->
	 * @model cancelledIncidentIdsMany="true" updatedIncidentsMany="true"
	 * @generated
	 */
	void updateIncidents(int feedId, EList<String> cancelledIncidentIds, EList<TrafficIncident> updatedIncidents);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void updateStatus(int feedId, TrafficIncidentFeedStatus feedStatus, TrafficIncidentsStatus incidentsStatus);

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void registerFeed(TrafficIncidentFeedListener listener, String dataProviderName, String protocolName, String communicationChannelName);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Remove this client as a listener for changes in the current language.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void removeLanguageListener(TrafficIncidentFeedListener listener, TrafficIncidentFeedListener changeListener);

} // TrafficIncidentFeed
