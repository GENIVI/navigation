/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.common.RectangularArea;
import org.genivi.common.Version;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconSet;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;

public class DefaultTrafficIncidentsListener extends EObjectImpl implements TrafficIncidentsListener {
  private final static Logger LOGGER = Logger.getLogger(DefaultTrafficIncidentsListener.class.getName());

  @Override
  public void getVersionReply(Version version) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getVersionReply ignored!");
  }

  @Override
  public void getLanguageReply(String languageCode, String countryCode) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getLanguageReply ignored!");
  }

  @Override
  public void setLanguageReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to setLanguageReply ignored!");
  }

  @Override
  public void setTimeFormatReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to setTimeFormatReply ignored!");
  }

  @Override
  public void setDateFormatReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to setDateFormatReply ignored!");
  }

  @Override
  public void setLengthUnitReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to setLengthUnitReply ignored!");
  }

  @Override
  public void setWeightUnitReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to setWeightUnitReply ignored!");
  }

  @Override
  public void getApplicabilityReply(String filterExpression) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getApplicabilityReply ignored!");
  }

  @Override
  public void setApplicabilityReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to setApplicabilityReply ignored!");
  }

  @Override
  public void reserveIconSetIdsReply(EList<Integer> iconSetIds) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to reserveIconSetIdsReply ignored!");
  }

  @Override
  public void freeIconSetIdsReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to freeIconSetIdsReply ignored!");
  }

  @Override
  public void getIconSetsReply(EList<IconSet> iconSets) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getIconSetsReply ignored!");
  }

  @Override
  public void addIconSetDefinitionsReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to addIconSetsDefinitionsReply ignored!");
  }

  @Override
  public void removeIconSetDefinitionsReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to removeIconSetDefinitionsReply ignored!");
  }

  @Override
  public void getIconDefinitionsReply(EList<IconDefinition> iconDefinitions) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getIconDefinitionsReply ignored!");
  }

  @Override
  public void addIconDefinitionsReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to addIconDefinitionsReply ignored!");
  }

  @Override
  public void removeIconDefinitionsReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to addIconDefinitionsReply ignored!");
  }

  @Override
  public void reserveCategoryIdsReply(EList<Integer> categoryIds) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to reserveCategoryIdsReply ignored!");
  }

  @Override
  public void freeCategoryIdsReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to freeCategoryIdsReply ignored!");
  }

  @Override
  public void getCategoryDefinitionsReply(EList<CategoryDefinition> categoryDefinitions) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getCategoryDefinitionsReply ignored!");
  }

  @Override
  public void addCategoryDefinitionsReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to addCategoryDefinitionsReply ignored!");
  }

  @Override
  public void removeCategoryDefinitionsReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to removeCategoryDefinitionsReply ignored!");
  }
  
  @Override
  public void getTrafficIncidentIdsReply(EList<Integer> incidentIds) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getTrafficIncidentIdsReply ignored!");
  }

  @Override
  public void getTrafficIncidentIdsInAreasReply(EList<Integer> trafficIncidentIds) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getTrafficIncidentIdsInAreasReply ignored!");
  }

  @Override
  public void getTrafficIncidentsReply(EList<TrafficIncident> trafficIncidents) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getTrafficIncidentsReply ignored!");
  }

  @Override
  public void getTrafficIncidentsFieldsReply(EList<TrafficIncident> trafficIncidents) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getTrafficIncidentsFieldsReply ignored!");
  }

  @Override
  public void getTextsReply(EList<String> texts) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to getTextsReply ignored!");
  }

  @Override
  public void addTrafficIncidentsStatusListenerReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to addTrafficIncidentsStatusListenerReply ignored!");
  }

  @Override
  public void removeTrafficIncidentsStatusListenerReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to removeTrafficIncidentsStatusListenerReply ignored!");
  }

  @Override
  public void addFeedInformationListenerReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to addFeedInformationListenerReply ignored!");
  }

  @Override
  public void removeFeedInformationListenerReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to removeFeedInformationListenerReply ignored!");
  }

  @Override
  public void addUpdateListenerReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to addUpdateListenerReply ignored!");
  }

  @Override
  public void removeUpdateListenerReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to removeUpdateListenerReply ignored!");
  }

  @Override
  public void addAreasUpdateListenerReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to addAreasUpdateListenerReply ignored!");
  }

  @Override
  public void removeAreasUpdateListenerReply() {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to removeAreasUpdateListenerReply ignored!");
  }

  @Override
  public void trafficIncidentsStatus(
      TrafficIncidentFeedStatus trafficIncidentFeedStatus,
      TrafficIncidentsStatus trafficIncidentsStatus) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to trafficIncidentsStatus ignored!");
  }

  @Override
  public void feedInformation(EList<FeedInformation> feedsInformation) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to feedInformation ignored!");
  }

  @Override
  public void updates(EList<Integer> unchangedTrafficIncidentIds, EList<Integer> changedTrafficIncidentIds, EList<Integer> newTrafficIncidentIds, EList<Integer> deletedTrafficIncidentIds) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to updates ignored!");
  }

  @Override
  public void updatesInAreas(EList<RectangularArea> areas) {
    // No action. Override this method if action is needed.
    LOGGER.severe("Call to updatesInAreas ignored!");
  }
}
