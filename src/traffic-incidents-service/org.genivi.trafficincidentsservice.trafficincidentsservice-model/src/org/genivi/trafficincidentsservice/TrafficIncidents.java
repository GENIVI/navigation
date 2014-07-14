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

import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traffic Incidents</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is the main interface via which a client obtains Traffic Information.
 * <!-- end-model-doc -->
 *
 *
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getTrafficIncidents()
 * @model annotation="http://www.tomtom.com/emfidl/2012/GenModel versionMajor='0' versionMinor='1'"
 * @generated
 */
public interface TrafficIncidents extends EObject {
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
  void getVersion(TrafficIncidentsListener listener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get all the Ids of the current traffic incidents.
	 * @param listener The class on which the callback function is called.
	 * @param warningLevels
	 *   Only incidents with one of the specified warning levels will be returned.
	 *   In case of an empty list, traffic incidents with any warning level (and no specified warning level) are returned.
	 * <!-- end-model-doc -->
	 * @model warningLevelsMany="true" categoryIdsMany="true"
	 * @generated
	 */
  void getTrafficIncidentIds(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the Ids of the traffic incidents in a number of areas.
	 * @param listener The class on which the callback function is called.
	 * @param warningLevels
	 *   Only incidents with one of the specified warning levels will be returned.
	 *   In case of an empty list, traffic incidents with any warning level (and no specified warning level) are returned.
	 * @param areas The areas for which the traffic incident Ids are requested.
	 * <!-- end-model-doc -->
	 * @model warningLevelsMany="true" categoryIdsMany="true" areasMany="true"
	 * @generated
	 */
  void getTrafficIncidentIdsInAreas(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds, EList<RectangularArea> areas);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get a number of Traffic Incidents.
	 * @param listener The class on which the callback function is called.
	 * @param trafficIncidentIds The Ids of the requested Traffic Incidents.
	 * @param includeTextFields The text fields in the returned Traffic Incident will only be filled in if this parameter is set to true.
	 * <!-- end-model-doc -->
	 * @model trafficIncidentIdsMany="true"
	 * @generated
	 */
  void getTrafficIncidents(TrafficIncidentsListener listener, EList<Integer> trafficIncidentIds, boolean includeTextFields);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get a number of Traffic Incidents, where only specific fields are filled in..
	 * @param listener The class on which the callback function is called.
	 * @param trafficIncidentIds The Ids of the requested Traffic Incidents.
	 * @param trafficIncidentFields The fields (attributes) to be filled in in the Traffic Incident.
	 * <!-- end-model-doc -->
	 * @model trafficIncidentIdsMany="true" trafficIncidentFieldsMany="true"
	 * @generated
	 */
  void getTrafficIncidentsFields(TrafficIncidentsListener listener, EList<Integer> trafficIncidentIds, EList<TrafficIncidentField> trafficIncidentFields);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the texts for a number of Traffic Incidents.
	 * @param listener The class on which the callback function is called.
	 * @param trafficIncidentIds The Ids of the Traffic Incidents for which the texts are requested.
	 * @param textDetailLevel The amount of detail to be provided in the texts.
	 * <!-- end-model-doc -->
	 * @model trafficIncidentIdsMany="true"
	 * @generated
	 */
  void getTexts(TrafficIncidentsListener listener, EList<Integer> trafficIncidentIds, TextDetailLevel textDetailLevel);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Add a listener which is notified in case of any change in Traffic Incidents status.
	 * In case of a status change, the TrafficIncidentsStatus() method of the listener is called.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void addTrafficIncidentsStatusListener(TrafficIncidentsListener listener, TrafficIncidentsListener trafficIncidentsStatusListener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void addFeedInformationListener(TrafficIncidentsListener listener, TrafficIncidentsListener feedInformationListener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeUpdateListener(TrafficIncidentsListener listener, TrafficIncidentsListener updateListener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeAreasUpdateListener(TrafficIncidentsListener listener, TrafficIncidentsListener updateListener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeTrafficIncidentsStatusListener(TrafficIncidentsListener listener, TrafficIncidentsListener trafficIncidentsStatusListener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void removeFeedInformationListener(TrafficIncidentsListener listener, TrafficIncidentsListener feedInformationListener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Add a listener which is notified in case of any update in the traffic information.
	 * In case of an update the updates() method of the listener is called.
	 * @param listener The class on which the callback function is called.
	 * @param warningLevels
	 *   Only incidents with one of the specified warning levels will be returned.
	 *   In case of an empty list, traffic incidents with any warning level (and no specified warning level) are returned.
	 * <!-- end-model-doc -->
	 * @model warningLevelsMany="true" categoryIdsMany="true"
	 * @generated
	 */
  void addUpdateListener(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds, TrafficIncidentsListener updateListener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Add a listener which is notified in case of an update in the traffic information in one or more specific area's.
	 * In case of an update the updatesInAreas() method of the listener is called.
	 * @param listener The class on which the callback function is called.
	 * @param warningLevels
	 *   Only incidents with one of the specified warning levels will be returned.
	 *   In case of an empty list, traffic incidents with any warning level (and no specified warning level) are returned.
	 * @param areas The area's to be observed for changes.
	 * <!-- end-model-doc -->
	 * @model warningLevelsMany="true" categoryIdsMany="true" areasMany="true"
	 * @generated
	 */
  void addAreasUpdateListener(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds, EList<RectangularArea> areas, TrafficIncidentsListener updateListener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the current language.
	 * @param listener The class on which the callback function is called.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void getLanguage(TrafficIncidentsListener listener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set the language.
	 * @param languageCode The language to be used.
	 * @param countryCode The country specific variant for the language to be used.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
  void setLanguage(TrafficIncidentsListener listener, String languageCode, String countryCode);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setTimeFormat(TrafficIncidentsListener listener, String timeFormat);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setDateFormat(TrafficIncidentsListener listener, String dateFormat);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setLengthUnit(TrafficIncidentsListener listener, LengthUnit lengthUnit);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setWeightUnit(TrafficIncidentsListener listener, WeightUnit weightUnit);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void reserveIconSetIds(TrafficIncidentsListener listener, int numberOfIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model iconSetIdsMany="true"
	 * @generated
	 */
  void freeIconSetIds(TrafficIncidentsListener listener, EList<Integer> iconSetIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void getIconSets(TrafficIncidentsListener listener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model iconSetsMany="true"
	 * @generated
	 */
  void addIconSetDefinitions(TrafficIncidentsListener listener, EList<IconSet> iconSets);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model iconSetIdsMany="true"
	 * @generated
	 */
  void removeIconSetDefinitions(TrafficIncidentsListener listener, EList<Integer> iconSetIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model iconInfosMany="true"
	 * @generated
	 */
  void getIconDefinitions(TrafficIncidentsListener listener, EList<IconInfo> iconInfos);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model iconDefinitionsMany="true"
	 * @generated
	 */
  void addIconDefinitions(TrafficIncidentsListener listener, EList<IconDefinition> iconDefinitions);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model iconInfosMany="true"
	 * @generated
	 */
  void removeIconDefinitions(TrafficIncidentsListener listener, EList<IconInfo> iconInfos);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void reserveCategoryIds(TrafficIncidentsListener listener, int numberOfIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model categoryIdsMany="true"
	 * @generated
	 */
  void freeCategoryIds(TrafficIncidentsListener listener, EList<Integer> categoryIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void getCategoryDefinitions(TrafficIncidentsListener listener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model categoryDefinitionsMany="true"
	 * @generated
	 */
  void addCategoryDefinitions(TrafficIncidentsListener listener, EList<CategoryDefinition> categoryDefinitions);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model categoryIdsMany="true"
	 * @generated
	 */
  void removeCategoryDefinitions(TrafficIncidentsListener listener, EList<Integer> categoryIds);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void getApplicability(TrafficIncidentsListener listener);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setApplicability(TrafficIncidentsListener listener, String filterExpression);

} // TrafficIncidents
