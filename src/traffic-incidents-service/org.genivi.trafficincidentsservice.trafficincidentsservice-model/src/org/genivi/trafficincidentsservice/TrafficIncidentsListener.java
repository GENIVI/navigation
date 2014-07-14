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

import org.genivi.common.RectangularArea;
import org.genivi.common.Version;

import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconSet;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traffic Incidents Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getTrafficIncidentsListener()
 * @model
 * @generated
 */
public interface TrafficIncidentsListener extends EObject {
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
	 * This method is called as a response to getTrafficIncidentIds().
	 * @param trafficIncidentIds The Ids of the requested traffic incidents.
	 * <!-- end-model-doc -->
	 * @model trafficIncidentIdsMany="true"
	 * @generated
	 */
  void getTrafficIncidentIdsReply(EList<Integer> trafficIncidentIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method is called as a response to getTrafficIncidentIdsInAreas().
	 * @param trafficIncidentIds The Ids of the requested traffic incidents.
	 * <!-- end-model-doc -->
	 * @model trafficIncidentIdsMany="true"
	 * @generated
	 */
  void getTrafficIncidentIdsInAreasReply(EList<Integer> trafficIncidentIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method is called as a response to getTrafficIncidents().
	 * @param trafficIncidents
	 *   The requested Traffic Incidents. This list may be shorter than the request list
	 *   as nothing is returned for Ids that don't exist (anymore).
	 * <!-- end-model-doc -->
	 * @model trafficIncidentsMany="true"
	 * @generated
	 */
  void getTrafficIncidentsReply(EList<TrafficIncident> trafficIncidents);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method is called as a response to getTrafficIncidentsFields().
	 * @param trafficIncidents
	 *   The requested Traffic Incidents, with only the requested fields filled in.
	 *   This list may be shorter than the request list as nothing is returned for
	 *   Ids that don't exist (anymore).
	 * <!-- end-model-doc -->
	 * @model trafficIncidentsMany="true"
	 * @generated
	 */
  void getTrafficIncidentsFieldsReply(EList<TrafficIncident> trafficIncidents);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method is called as a response to getTexts().
	 * @param texts
	 *   Text information per requested traffic incident.
	 *   The texts will be in the same order as the trafficIncidentIds in the request.
	 * <!-- end-model-doc -->
	 * @model textsMany="true"
	 * @generated
	 */
  void getTextsReply(EList<String> texts);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void addTrafficIncidentsStatusListenerReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void addFeedInformationListenerReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void addUpdateListenerReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeUpdateListenerReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void addAreasUpdateListenerReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeAreasUpdateListenerReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setLanguageReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setTimeFormatReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setDateFormatReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setLengthUnitReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setWeightUnitReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setApplicabilityReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void freeCategoryIdsReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a client has registered itself as a listener for any updates in the traffic incidents,
	 * this method is called if there are changes.
	 * <!-- end-model-doc -->
	 * @model unchangedTrafficIncidentIdsMany="true" changedTrafficIncidentIdsMany="true" newTrafficIncidentIdsMany="true" deletedTrafficIncidentIdsMany="true"
	 * @generated
	 */
  void updates(EList<Integer> unchangedTrafficIncidentIds, EList<Integer> changedTrafficIncidentIds, EList<Integer> newTrafficIncidentIds, EList<Integer> deletedTrafficIncidentIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a client has registered itself as a listener for updates in the traffic incidents in one or more area's
	 * (via addAreaUpdateListener() or addAreasUpdateListener()),
	 * this method is called if there are changes.
	 * @param areas The area's in which changes have taken place.
	 * <!-- end-model-doc -->
	 * @model areasMany="true"
	 * @generated
	 */
  void updatesInAreas(EList<RectangularArea> areas);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method is called as a response to getLanguage().
	 * @param languageCode The language.
	 * @param countryCode The country specific variant for the language.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void getLanguageReply(String languageCode, String countryCode);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a client has registered itself as a listener for changes in the Traffic Incidents status,
	 * this method is called upon changes in the Traffic Incidents status.
	 * The provided status information is the combined status of the available feeds in the system.
	 * Details of how the information is combined is given per parameter.
	 * @param trafficIncidentFeedStatus
	 *   The combined status of the Traffic Incident Feeds.
	 *   If all Feeds are UNAVAILABLE, the status is UNAVAILABLE.
	 *   Else, if any of the Feeds is CONNECTED, the status is CONNECTED.
	 *   Else, the status is DISCONNECTED (so there are Feeds available, but none of them is connected).
	 * @param trafficIncidentsStatus
	 *   The combined status of the Traffic Incidents.
	 *   If the status for all the Feeds is AVAILABLE, , the combined status is AVAILABLE.
	 *   Else, if the status for one of the Feeds is PARTLY_AVAILABLE, the combined status is PARTLY_AVAILABLE.
	 *   Else, the combined status is UNAVAILABLE (so there are no Traffic Incidents at all).
	 *   
	 *         
	 *   Meaning of the enum values at this level:
	 *   UNAVAILABLE: The are no incidents in the system, and currently they can also not be received.
	 *   PARTLY_AVAILABLE: There are or may be incidents in the system, but the set of incidents is probably not up to date.
	 *   This means that big changes are possible. Examples: Upon start-up, some incidents have already been received,
	 *   but there are more incidents to receive. If the user is looking at the map display, new incidents may suddenly appear.
	 *   When a connection is lost, the information stays valid for some time, but the information may no longer be fully up to date,
	 *   and at some point in time a lot of incidents may suddenly disappear because they are no longer valid.
	 *   AVAILABLE: The reception and handling of the incidents is stable, and as up to date as possible with respect to the used protocol(s).
	 *   It is however still possible that there are currently no Traffic Incidents.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void trafficIncidentsStatus(TrafficIncidentFeedStatus trafficIncidentFeedStatus, TrafficIncidentsStatus trafficIncidentsStatus);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a client has registered itself as a listener for changes in the Feed Information,
	 * this method is called upon changes in the Feed Information.
	 * @param feedsInformation The information per Traffic Incident Feed.
	 * <!-- end-model-doc -->
	 * @model feedsInformationMany="true"
	 * @generated
	 */
  void feedInformation(EList<FeedInformation> feedsInformation);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model categoryIdsMany="true"
	 * @generated
	 */
  void reserveCategoryIdsReply(EList<Integer> categoryIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model iconSetIdsMany="true"
	 * @generated
	 */
  void reserveIconSetIdsReply(EList<Integer> iconSetIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model iconSetsMany="true"
	 * @generated
	 */
  void getIconSetsReply(EList<IconSet> iconSets);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void addIconSetDefinitionsReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeIconSetDefinitionsReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeFeedInformationListenerReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeTrafficIncidentsStatusListenerReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model iconDefinitionsMany="true"
	 * @generated
	 */
  void getIconDefinitionsReply(EList<IconDefinition> iconDefinitions);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void addIconDefinitionsReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeIconDefinitionsReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model categoryDefinitionsMany="true"
	 * @generated
	 */
  void getCategoryDefinitionsReply(EList<CategoryDefinition> categoryDefinitions);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void addCategoryDefinitionsReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeCategoryDefinitionsReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void freeIconSetIdsReply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void getApplicabilityReply(String filterExpression);

} // TrafficIncidentsListener
