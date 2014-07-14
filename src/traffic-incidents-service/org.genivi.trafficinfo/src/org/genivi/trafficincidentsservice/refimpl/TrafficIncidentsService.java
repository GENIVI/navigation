/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

/**
 * Applicability handling.
 * The way that the Traffic Incidents Service shall handle the Applicability
 * is a tradeoff between the best user experience and performance (use of system resources).
 * It is based on the idea that the application (user) will hardly ever change the
 * Applicability settings.
 * Behaviour:
 * - Traffic Incidents that are not applicable may be thrown away on reception.
 *   This can be done before any location dereferencing takes place. This implies
 *   that an Applicability Expression should not refer to any location.
 *   In a client/server solution it is even possible that the server is instructed
 *   not to transmit these incidents.
 * - If the Applicability Expression is changed, it is applied on the current set of
 *   Traffic Incidents. This may lead to the removal of incidents, which in its turn
 *   may trigger notifications being sent to listeners for changes in the traffic situation.
 * - Incidents that are not Applicable are never given to a client of this service.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.genivi.booleanexpr.BooleanExpression;
import org.genivi.booleanexpr.util.FilterExprUtil;
import org.genivi.common.CommonFactory;
import org.genivi.common.RectangularArea;
import org.genivi.common.Version;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.locref.refimpl.LocationReferenceDecodingHandlerRefImpl;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.FeedInformation;
import org.genivi.trafficincidentsservice.LengthUnit;
import org.genivi.trafficincidentsservice.TextDetailLevel;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentField;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentFeed;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedListener;
import org.genivi.trafficincidentsservice.WeightUnit;
import org.genivi.trafficincidentsservice.trafficincidentsserviceFactory;
import org.genivi.trafficincidentsservice.textgenerator.TrafficIncidentTextGenerator;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentFactory;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;

public class TrafficIncidentsService extends EObjectImpl implements TrafficIncidents, TrafficIncidentFeed {
  private final static Logger LOGGER = Logger.getLogger(TrafficIncidentsService.class.getName()); 
  private static final trafficincidentsserviceFactory TRAFFIC_INCIDENTS_FACTORY = trafficincidentsserviceFactory.eINSTANCE;
  private static final trafficincidentFactory TRAFFIC_INCIDENT_FACTORY = trafficincidentFactory.eINSTANCE;
  private static final CommonFactory COMMON_FACTORY = CommonFactory.eINSTANCE;   // Used to create a Version
  
  private static final int NORMAL_DRIVING_SPEED_IN_METERS_PER_SECOND = 30;  // TODO PRIO9: FULL_IMPL This value has to be obtained from the map database, for the related segment(s).
  
  // Version information
  private static final int MAJOR_VERSION_NUMBER = 1;
  private static final int MINOR_VERSION_NUMBER = 0;
  private static final int MICRO_VERSION_NUMBER = 0;
  private static final String VERSION_DATE = "06-03-2014";
  
  // Default language information.
  private static final String DEFAULT_LANGUAGE_CODE = "eng";
  private static final String DEFAULT_LANGUAGE_COUNTRY_CODE = null;
  
  // List of TrafficIncidentFields which are text fields.
  private static final TrafficIncidentField[] TRAFFIC_INCIDENT_TEXT_FIELDS = {
    TrafficIncidentField.APPLICABILITY_TEXTS,
    TrafficIncidentField.CAUSE_TEXTS,
    TrafficIncidentField.ADVICE_TEXTS,
    TrafficIncidentField.EFFECT_TEXT,
    TrafficIncidentField.TENDENCY_TEXT,
    TrafficIncidentField.TRAFFIC_INCIDENT_ID
  };

  private static Version VERSION;

  // references to other components used.
  private TrafficIncidentTextGenerator trafficIncidentTextGenerator;
  private ExpirationHandler expirationHandler;
//  private LocationReferenceHandler locationReferenceHandler;
  private LocationReferenceDecodingHandlerRefImpl locationReferencDecodingHandler;
  
  // settings
  private String languageCode = DEFAULT_LANGUAGE_CODE;
  private String languageCountryCode = DEFAULT_LANGUAGE_COUNTRY_CODE;
  
  // Status information
  private TrafficIncidentFeedStatus trafficIncidentFeedStatus = TrafficIncidentFeedStatus.UNAVAILABLE;
  private TrafficIncidentsStatus trafficIncidentsStatus = TrafficIncidentsStatus.UNAVAILABLE;

  /*
   *  all other information.
   */
  
  // IconSet Ids reserved by applications.
  private Set<Integer> reservedIconSetIds = new HashSet<Integer>();
  
  // All known icons (including the actual data).
  private Map<IconInfo, IconDefinition> iconDefinitionsMap = new HashMap<IconInfo, IconDefinition>();
  
  // IconSets meta data.
  private EList<IconSet> iconSets = new BasicEList<IconSet>();
  
  // Category Ids reserved by applications.
  private Set<Integer> reservedCategoryIds = new HashSet<Integer>();
  
  // Category definitions
  private EList<CategoryDefinition> categoryDefinitions = new BasicEList<CategoryDefinition>();
  
  // Applicability filter
  private ExpressionFilter applicabilityFilter = null;
  
  /*
   *  The Traffic Incidents
   */  
  private List<ManagedTrafficIncident> managedIncidents;
  private Map<String, ManagedTrafficIncident> xIncidentIdToManagedIncidentMap;
  private Map<Integer, ManagedTrafficIncident> incidentIdToManagedIncidentMap;
  
  /*
   * The update listeners.
   */
  // Listeners to updates in the Traffic Incidents: based on filters for area, warning level and category.
  private Map<TrafficIncidentsListener, UpdateListenerInfo> updateListeners = new HashMap<>();
  // Listeners for changes in the general status.
  private List<TrafficIncidentsListener> trafficIncidentsStatusListeners = new ArrayList<TrafficIncidentsListener>();
  // Listeners for changes in the Feed information.
  private List<TrafficIncidentsListener> feedInformationListeners = new ArrayList<TrafficIncidentsListener>();
  private List<TrafficIncidentFeedListener> trafficIncidentFeedListeners = new ArrayList<TrafficIncidentFeedListener>();
  private Map<Integer, FeedInformation> feedsInformation = new HashMap<>();
  private int nextFeedId = 1;
  private int nextTrafficIncidentId = 1;  // Use 0 as undefined.

  
  static {
    VERSION = COMMON_FACTORY.createVersion();
    VERSION.setMajor(MAJOR_VERSION_NUMBER);
    VERSION.setMinor(MINOR_VERSION_NUMBER);
    VERSION.setMicro(MICRO_VERSION_NUMBER);
    VERSION.setDate(VERSION_DATE);
  }

  public TrafficIncidentsService(LocationReferenceDecodingHandlerRefImpl locationReferencDecodingHandler, TrafficIncidentTextGenerator trafficIncidentTextGenerator) {
    LOGGER.setLevel(Level.SEVERE);
    LOGGER.info("Creating TrafficIncidentsService");
    
    this.locationReferencDecodingHandler = locationReferencDecodingHandler;
    this.trafficIncidentTextGenerator = trafficIncidentTextGenerator;
    trafficIncidentTextGenerator.setLanguage(languageCode, languageCountryCode);

    managedIncidents = new ArrayList<>();
    xIncidentIdToManagedIncidentMap = new HashMap<>();
    incidentIdToManagedIncidentMap = new HashMap<>();

    expirationHandler = new ExpirationHandler(this);
    expirationHandler.start();
  }

  @Override
  public void getVersion(TrafficIncidentsListener listener) {
    listener.getVersionReply(VERSION);
  }

  @Override
  public void getTrafficIncidentIds(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds) {
    LOGGER.info("getTrafficIncidentIds() called, forwarding to getTrafficIncidentIdsInAreas()");
    getTrafficIncidentIdsInAreas(listener, warningLevels, categoryIds, new BasicEList<RectangularArea>());
  }

  @Override
  public void getTrafficIncidentIdsInAreas(TrafficIncidentsListener listener, EList<WarningLevel> severities, EList<Integer> categoryIds, EList<RectangularArea> areas) {
    LOGGER.info("=>");
    EList<Filter> filters = new BasicEList<Filter>();
    
    if (!severities.isEmpty()) {
      filters.add(TrafficIncidentFilterUtils.createWarningLevelFilter(severities));
    }
    
    if (!categoryIds.isEmpty()) {
      filters.add(TrafficIncidentFilterUtils.createCategoryIdsFilter(categoryIds));
    }
    
    if (!areas.isEmpty()) {
      filters.add(new AreasFilter(areas));
    }
    
    EList<EObject> relevantTrafficIncidents = Filter.applyFilters(getTrafficIncidents(), filters);

    EList<Integer> trafficIncidentIds = new BasicEList<>();
    for (EObject eObject: relevantTrafficIncidents) {
      TrafficIncident trafficIncident = (TrafficIncident) eObject;
      LOGGER.info("adding trafficIncidentId " + trafficIncident.getTrafficIncidentId() + " to result list.");
      trafficIncidentIds.add(trafficIncident.getTrafficIncidentId());
    }

    LOGGER.info("Calling getTrafficIncidentIdsReply().");
    listener.getTrafficIncidentIdsReply(trafficIncidentIds);
    LOGGER.info("<=");
  }

  private TrafficIncident getTrafficIncident(int trafficIncidentId, boolean includeTextFields) {
    LOGGER.info("getTrafficIncident => trafficIncidentId = " + trafficIncidentId + ", includeTextFields = " + includeTextFields);
    ManagedTrafficIncident managedTrafficIncident = incidentIdToManagedIncidentMap.get(trafficIncidentId);
    if (managedTrafficIncident != null) {
      TrafficIncident trafficIncident = managedTrafficIncident.getTrafficIncident();

      if (trafficIncident != null) {
        LOGGER.info("managedTrafficIncident = " + trafficIncident);
        if (includeTextFields) {
          fillTextFields(trafficIncident);
        }
        return trafficIncident;
      }
    }

    LOGGER.info("getTrafficIncident <= " + null);
    return null;
  }
  
  private void fillTextFields(TrafficIncident trafficIncident) {
    String[] texts;
    
    for (TrafficIncidentField trafficIncidentField: TRAFFIC_INCIDENT_TEXT_FIELDS) {
      // Check whether the field is already filled in or not.
      switch (trafficIncidentField) {
      case APPLICABILITY_TEXTS:
        if (!trafficIncident.isSetApplicabilityTexts()) {
          texts = trafficIncidentTextGenerator.getApplicabilityTexts(trafficIncident);
          if (texts != null) {
            for (String text: texts) {
              trafficIncident.getApplicabilityTexts().add(text);
            }
          }
        }
        break;
        
      case CAUSE_TEXTS:
        if (!trafficIncident.isSetCauseTexts()) {
          texts = trafficIncidentTextGenerator.getCauseTexts(trafficIncident);
          if (texts != null) {
            for (String text: texts) {
              trafficIncident.getCauseTexts().add(text);
            }
          }
        }
        break;
        
      case ADVICE_TEXTS:
        if (!trafficIncident.isSetAdviceTexts()) {
          texts = trafficIncidentTextGenerator.getAdviceTexts(trafficIncident);
          if (texts != null) {
            for (String text: texts) {
              trafficIncident.getAdviceTexts().add(text);
            }
          }
        }
        break;
        
      case EFFECT_TEXT:
        if (!trafficIncident.isSetEffectText()) {
          trafficIncident.setEffectText(trafficIncidentTextGenerator.getEffectText(trafficIncident));
        }
        break;
        
      case TENDENCY_TEXT:
        if (!trafficIncident.isSetTendencyText()) {
          trafficIncident.setTendencyText(trafficIncidentTextGenerator.getTendencyText(trafficIncident));
        }
        break;
        
      case TRAFFIC_INCIDENT_ID:
        break;
        
      default:
        // no action
        break;
      } 
    }
  }

  @Override
  public void getTrafficIncidents(TrafficIncidentsListener listener, 
      EList<Integer> trafficIncidentIds, boolean includeTextFields) {
    listener.getTrafficIncidentsReply(getTrafficIncidents(trafficIncidentIds, includeTextFields));
  }

  private EList<TrafficIncident> getTrafficIncidents(EList<Integer> trafficIncidentIds, boolean includeTextFields) {
    LOGGER.info("getTrafficIncidents => trafficIncidentIds = " + trafficIncidentIds + ", includeTextFields = " + includeTextFields);
    EList<TrafficIncident> trafficIncidents = new BasicEList<TrafficIncident>();

    for (int trafficIncidentId: trafficIncidentIds) {
      TrafficIncident trafficIncident = getTrafficIncident(trafficIncidentId, includeTextFields);
      if (trafficIncident != null) {
        LOGGER.info("adding trafficIncident: " + trafficIncident);
        trafficIncidents.add(trafficIncident);
      } else {
        LOGGER.info("skipping null value");
      }
    }

    LOGGER.info("getTrafficIncidents <= " + trafficIncidents);
    return trafficIncidents;
  }

  @Override
  public void clear() {
    managedIncidents.clear();
  }

  @Override
  public synchronized void updateIncidents(int feedId, EList<String> idsToCancel, EList<org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident> newOrUpdatedIncidents) {
    LOGGER.info("updateIncidents => feedId = " + feedId + ", idsToCancel = " + idsToCancel + ", newOrUpdatedIncidents = " + newOrUpdatedIncidents);
    
    dumpManagedIncidentsMap("Before updating");
    dumpIncidents("Before updating");

    for (String trafficIncidentManagementId: idsToCancel) {
      ManagedTrafficIncident managedTrafficIncident = xIncidentIdToManagedIncidentMap.get(trafficIncidentManagementId);
      if (managedTrafficIncident == null) {
        LOGGER.info("No ManagedTrafficIncident found for TrafficIncidentManagementId: " + trafficIncidentManagementId);
      } else {
        Integer trafficIncidentId = managedTrafficIncident.getTrafficIncident().getTrafficIncidentId();
        xIncidentIdToManagedIncidentMap.remove(trafficIncidentManagementId);
        incidentIdToManagedIncidentMap.remove(trafficIncidentId);
        managedIncidents.remove(managedTrafficIncident);
        LOGGER.info("Traffic Incident removed, Id = " + trafficIncidentId + ", managementId = " + trafficIncidentManagementId);
      }
    }
    
    dumpManagedIncidentsMap("After handling cancels");
    dumpIncidents("After handling cancels");
    EList<org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident> applicableNewOrUpdatedIncidents;
    
    if (applicabilityFilter != null) {
      applicableNewOrUpdatedIncidents = Filter.applyRejectFilter(newOrUpdatedIncidents, applicabilityFilter);
    } else {
      applicableNewOrUpdatedIncidents = newOrUpdatedIncidents;
    }
    
    Date receivedAt = new Date();
    List<ManagedTrafficIncident> managedApplicableNewOrUpdatedIncidents = new ArrayList<>();
    for (org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident xTrafficIncident: applicableNewOrUpdatedIncidents) {
      TrafficIncident newOrUpdatedIncident = TrafficIncidentConvertor.xTrafficIncident2TrafficIncident(xTrafficIncident, languageCode, languageCountryCode);
      ManagedTrafficIncident managedTrafficIncident  = new ManagedTrafficIncident(xTrafficIncident, newOrUpdatedIncident, receivedAt);
      managedApplicableNewOrUpdatedIncidents.add(managedTrafficIncident);
    }
    
    
    LOGGER.info("Triggering location dereferencing.");
    
    // Trigger the LocationReferenceHandler. If this is ready, it calls locationsDereferenced().
    LocationReferenceHandler locationReferenceHandler = new LocationReferenceHandler(this, locationReferencDecodingHandler);
    locationReferenceHandler.setLanguage(languageCode, languageCountryCode);
    locationReferenceHandler.handleLocationReferences(managedApplicableNewOrUpdatedIncidents);

    notifyAll();
  }

  public void locationsDereferenced(List<ManagedTrafficIncident> incidents) {
    for (ManagedTrafficIncident managedTrafficIncident: incidents) {
      org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident xTrafficIncident = managedTrafficIncident.getxTrafficIncident();
      TrafficIncident trafficIncident = managedTrafficIncident.getTrafficIncident();

      String trafficIncidentManagementId = xTrafficIncident.getTrafficIncidentId();
      ManagedTrafficIncident originalEvent = xIncidentIdToManagedIncidentMap.get(trafficIncidentManagementId);

      if (originalEvent != null) {
        // It is an update
        // Merge the new data into the existing incident
        mergeIncidentData(originalEvent, managedTrafficIncident);
        // Continue with the updated, existing incident
        trafficIncident = originalEvent.getTrafficIncident();
      }
      
      calculateDelayIfApplicable(trafficIncident);
      
      trafficIncident.getCategoryIds().clear();
      for (CategoryDefinition categoryDefinition: categoryDefinitions) {
        BooleanExpression filterExpression = FilterExprUtil.parseFilterExpression(categoryDefinition.getExpression());
        Filter filter = new ExpressionFilter(filterExpression);
        if (filter.filter(trafficIncident)) {
          LOGGER.info("Category filter passed, adding category Id to traffic incident: " + categoryDefinition.getCategoryId());
          trafficIncident.getCategoryIds().add(categoryDefinition.getCategoryId());
        } else {
          LOGGER.info("Category filter NOT passed, category Id NOT added to traffic incident: " + categoryDefinition.getCategoryId());
        }
      }
      
      updateLinksWithOtherIncidents(managedTrafficIncident);
      
      xTrafficIncident.setUpdateTime(new Date());
      
      if (originalEvent == null) {
        // There was no event with this Id yet, so it is a new one.
        // So add an application level trafficIncidentId.
        int trafficIncidentId = createTrafficIncidentId();
        LOGGER.info("Adding message, Id = " + trafficIncidentId + ", managementId = " + trafficIncidentManagementId);
        trafficIncident.setTrafficIncidentId(trafficIncidentId);
        managedIncidents.add(managedTrafficIncident);
        incidentIdToManagedIncidentMap.put(trafficIncidentId, managedTrafficIncident);
        xIncidentIdToManagedIncidentMap.put(trafficIncidentManagementId, managedTrafficIncident);
      }
      
      
    }
    
    dumpManagedIncidentsMap("After updating");
    dumpIncidents("After updating");
    
    notifyUpdateListeners();
  }

  /**
   * The method handles the links between this incident and other incidents.
   * If this incident has a link to another incident, and this incident is already in
   * our store, the incidentId of that incident is filled in.
   * There can also be an incident in our store, which has a link to this new incident.
   * In that case the incidentId is also filled in.
   * @param managedTrafficIncident
   */
  private void updateLinksWithOtherIncidents(ManagedTrafficIncident managedTrafficIncident) {
    TrafficIncident trafficIncident = managedTrafficIncident.getTrafficIncident();
    org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident xTrafficIncident = managedTrafficIncident.getxTrafficIncident();
    
    // Handle a possible link from this incident to one in our store.
    for (int i = 0; i < xTrafficIncident.getCauses().size(); i++) {
      org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause xCause = xTrafficIncident.getCauses().get(i);
      if (xCause instanceof org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause) {
        org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause xLinkedCause = (org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause) xCause;
        String trafficIncidentManagementId = xLinkedCause.getCauseTrafficIncidentId();
        ManagedTrafficIncident referedToManagedIncident = xIncidentIdToManagedIncidentMap.get(trafficIncidentManagementId);
        if (referedToManagedIncident != null) {
          Cause cause = trafficIncident.getCauses().get(i);
          LinkedCause linkedCause = (LinkedCause) cause;
          Integer trafficIncidentId = referedToManagedIncident.getTrafficIncident().getTrafficIncidentId();
          linkedCause.setCauseTrafficIncidentId(trafficIncidentId);
        }
      }
    }
    
    // Handle a possile link from any incident in our store to this incident.
    for (ManagedTrafficIncident referredFromManagedIncident: managedIncidents) {
      TrafficIncident referredFromIncident = referredFromManagedIncident.getTrafficIncident();
      for (int i = 0; i < referredFromIncident.getCauses().size(); i++) {
        Cause cause = referredFromIncident.getCauses().get(i);
        if (cause instanceof LinkedCause) {
          LinkedCause linkedCause = (LinkedCause) cause;
          Integer referToId = linkedCause.getCauseTrafficIncidentId();
          if (referToId == null) {
            org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident referredFromXIncident = referredFromManagedIncident.getxTrafficIncident();
            org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause xLinkedCause = (org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause) referredFromXIncident.getCauses().get(i);
            String referToManagementId = xLinkedCause.getCauseTrafficIncidentId();
            if (referToManagementId.equals(xTrafficIncident.getTrafficIncidentId())) {
              linkedCause.setCauseTrafficIncidentId(trafficIncident.getTrafficIncidentId());
            }
          }
        }
      }
    }
  }

  private void mergeIncidentData(ManagedTrafficIncident existingManagedTrafficIncident, ManagedTrafficIncident updateManagedTrafficIncident) {
    // TODO PRIO9: FULL_IMPL For now only one field merged, full implementation required.
    TrafficIncident existingTrafficIncident = existingManagedTrafficIncident.getTrafficIncident();
    TrafficIncident updateTrafficIncident = updateManagedTrafficIncident.getTrafficIncident();
    if (updateTrafficIncident.isSetAverageSpeedAbsolute()) {
      existingTrafficIncident.setAverageSpeedAbsolute(updateTrafficIncident.getAverageSpeedAbsolute());
    }
  }

  private void calculateDelayIfApplicable(TrafficIncident managedTrafficIncident) {
    if ((managedTrafficIncident.getDelay() == null)  &&
        (managedTrafficIncident.getLengthAffected() != null)  &&
        (managedTrafficIncident.getLengthAffected() != null)) {
      managedTrafficIncident.getLengthAffected();  // meters
      managedTrafficIncident.getAverageSpeedAbsolute();  // m/s
      // normal driving time (in seconds) = length affecte (in meters) / normal driving speed (in m/s)
      int normalDrivingTimeInSeconds = managedTrafficIncident.getLengthAffected() / NORMAL_DRIVING_SPEED_IN_METERS_PER_SECOND;
      // current driving time (in seconds) = length affecte (in meters)  / current driving speed (in m/s)
      int currentDrivingTimeInSeconds = managedTrafficIncident.getLengthAffected() / managedTrafficIncident.getAverageSpeedAbsolute();
      // delay is the difference rounded to minutes.
      int delay = (currentDrivingTimeInSeconds - normalDrivingTimeInSeconds + 30) / 60;
        managedTrafficIncident.setDelay(delay);
    }
  }

  private void dumpManagedIncidentsMap(String whenText) {
//    LOGGER.info("Contents of managedIncidentMap - " + whenText);
//
//    for (TrafficIncidentManagementId id: managedIncidents.keySet()) {
//      LOGGER.info("managementId = " + id.getId());
//    }
  }
  
  public void dumpIncidents(String whenText) {
//    LOGGER.info("Current Traffic Incidents - " + whenText);
//
//    for (ManagedTrafficIncident managedTrafficIncident: managedIncidents.values()) {
//      LOGGER.info("TrafficIncident = " + managedTrafficIncident);
//      EList<Cause> causes = managedTrafficIncident.getCauses();
//      for (Cause cause: causes) {
//        LOGGER.info("Cause = " + cause);
//      }
//    }
  }

  @Override
  public void updateStatus(int feedId, TrafficIncidentFeedStatus feedStatus,
      TrafficIncidentsStatus incidentsStatus) {
    boolean statusChanged = false;
    
    FeedInformation feedInformation = feedsInformation.get(feedId);
    
    if (feedInformation.getFeedStatus() != feedStatus) {
      feedInformation.setFeedStatus(feedStatus);
      statusChanged = true;
    }
    if (feedInformation.getTrafficIncidentsStatus() != incidentsStatus) {
      feedInformation.setTrafficIncidentsStatus(incidentsStatus);
      LOGGER.info("+++++++++++++ status = " + feedInformation.getTrafficIncidentsStatus());
      statusChanged = true;
    }
    
    if (statusChanged) {
      notifyFeedInformationListeners();
    }
    
    determineNewStatus();
  }

  private void determineNewStatus() {
    TrafficIncidentFeedStatus newTrafficIncidentFeedStatus = TrafficIncidentFeedStatus.UNAVAILABLE;
    TrafficIncidentsStatus newTrafficIncidentsStatus = TrafficIncidentsStatus.UNAVAILABLE;
    
    for (Integer feedId: feedsInformation.keySet()) {
      FeedInformation feedInformation = feedsInformation.get(feedId);
      
      TrafficIncidentFeedStatus thisTrafficIncidentFeedStatus = feedInformation.getFeedStatus();
      if (thisTrafficIncidentFeedStatus == TrafficIncidentFeedStatus.CONNECTED) {
        newTrafficIncidentFeedStatus = TrafficIncidentFeedStatus.CONNECTED;
      }
      if (thisTrafficIncidentFeedStatus == TrafficIncidentFeedStatus.DISCONNECTED  &&
          newTrafficIncidentFeedStatus == TrafficIncidentFeedStatus.UNAVAILABLE) {
        newTrafficIncidentFeedStatus = TrafficIncidentFeedStatus.DISCONNECTED;
      }
      
      TrafficIncidentsStatus thisTrafficIncidentsStatus = feedInformation.getTrafficIncidentsStatus();
      if (thisTrafficIncidentsStatus == TrafficIncidentsStatus.PARTLY_AVAILABLE) {
        newTrafficIncidentsStatus = TrafficIncidentsStatus.PARTLY_AVAILABLE;
      }
      if (thisTrafficIncidentsStatus == TrafficIncidentsStatus.AVAILABLE  &&
          newTrafficIncidentsStatus == TrafficIncidentsStatus.UNAVAILABLE) {
        newTrafficIncidentsStatus = TrafficIncidentsStatus.AVAILABLE;
      }
      
      if (newTrafficIncidentFeedStatus != trafficIncidentFeedStatus  ||
          newTrafficIncidentsStatus != trafficIncidentsStatus) {
        trafficIncidentFeedStatus = newTrafficIncidentFeedStatus;
        trafficIncidentsStatus = newTrafficIncidentsStatus;
        notifyTrafficIncidentsStatusListeners();
      }
    }

  }

  @Override
  public void addLanguageListener(
      TrafficIncidentFeedListener listener, TrafficIncidentFeedListener languageChangeListener) {
    languageChangeListener.getLanguageReply(languageCode, languageCountryCode);
    trafficIncidentFeedListeners.add(languageChangeListener);
    
    if (listener != null) {
      listener.addLanguageListenerReply();
    }
  }

  @Override
  public void removeLanguageListener(
      TrafficIncidentFeedListener listener, TrafficIncidentFeedListener languageChangeListener) {
    trafficIncidentFeedListeners.remove(languageChangeListener);
    
    if (listener != null) {
      listener.removeLanguageListenerReply();
    }
  }
  
  @Override
  public void getLanguage(TrafficIncidentFeedListener listener) {
    listener.getLanguageReply(languageCode, languageCountryCode);    
  }

  private int generateFeedId() {
    return nextFeedId++;  // This should never cause overflow.
  }

  private int createTrafficIncidentId() {
    int trafficIncidentId = nextTrafficIncidentId ;

    if (nextTrafficIncidentId < Integer.MAX_VALUE) {
      nextTrafficIncidentId++;
    } else {
      nextTrafficIncidentId = 1;
    }
    return trafficIncidentId;
  }

  public Collection<ManagedTrafficIncident> getManagedEvents() {
    return managedIncidents;
  }

  @Override
  public void addUpdateListener(TrafficIncidentsListener listener,
      EList<WarningLevel> warningLevels, EList<Integer> categoryIds,
      TrafficIncidentsListener updateListener) {
    addAreasUpdateListener(listener, warningLevels, categoryIds, new BasicEList<RectangularArea>(), updateListener);
  }

  @Override
  public void addAreasUpdateListener(TrafficIncidentsListener listener,
      EList<WarningLevel> warningLevels, EList<Integer> categoryIds, EList<RectangularArea> areas,
      TrafficIncidentsListener updateListener) {
    LOGGER.info("Adding (areas)UpdateListener => listener = " + listener +
        ", warningLevels = " + warningLevels + ", categoryIds = " + categoryIds +
        ", areas = " + areas + ", updateListener = " + updateListener);
    UpdateListenerInfo updateListenerInfo = new UpdateListenerInfo(warningLevels, categoryIds, areas);
    updateListeners.put(updateListener, updateListenerInfo);
    
    listener.addUpdateListenerReply();
    
    HandleUpdateListenerRunnable handleUpdateListenerRunnable = new HandleUpdateListenerRunnable(updateListener);
    Thread thread = new Thread(handleUpdateListenerRunnable);
    thread.start();
  }

  @Override
  public void removeAreasUpdateListener(TrafficIncidentsListener listener, TrafficIncidentsListener updateListener) {
    updateListeners.remove(updateListener);
    
    if (listener != null) {
      listener.removeAreasUpdateListenerReply();
    }
  }
  
  @Override
  public void removeUpdateListener(TrafficIncidentsListener listener, TrafficIncidentsListener updateListener) {
    LOGGER.info("removeUpdateListener => listener = " + listener + ", updateListener = " + updateListener);
    updateListeners.remove(updateListener);    
    
    if (listener != null) {
      listener.removeUpdateListenerReply();
    }
  }
  
  private void notifyUpdateListeners() {
    for (TrafficIncidentsListener updateListener: updateListeners.keySet()) {
      LOGGER.info("Notify update listener by calling updates()");
      handleUpdateListener(updateListener);
    }
  }
  
  private void handleUpdateListener(TrafficIncidentsListener updateListener) {
    LOGGER.info("handleUpdateListener => updateListener = " + updateListener);
    UpdateListenerInfo updateListenerInfo = updateListeners.get(updateListener);
    
    EList<Filter> filters = new BasicEList<Filter>();
    
    if (updateListenerInfo.getSeveritiesFilter() != null) {
      LOGGER.info("adding severitiesFilter");
      filters.add(updateListenerInfo.getSeveritiesFilter());
    }
    LOGGER.info("AFTER severitiesFilter");
    
    if (updateListenerInfo.getCategoriesFilter() != null) {
      LOGGER.info("adding category filter");
      filters.add(updateListenerInfo.getCategoriesFilter());
    }
    LOGGER.info("AFTER category Filter");
    
    if (updateListenerInfo.getAreasFilter() != null) {
      filters.add(updateListenerInfo.getAreasFilter());
    }
    LOGGER.info("AFTER Areas Filter");
    
    EList<ManagedTrafficIncident> relevantTrafficIncidents = applyFilters(managedIncidents, filters);
    LOGGER.info("AFTER applyFilters");
    
    List<Integer> unchangedIds = new ArrayList<>();
    List<Integer> updatedIds = new ArrayList<>();
    List<Integer> newIds = new ArrayList<>();
    List<Integer> deletedIds = new ArrayList<>();
    
    List<Integer> relevantTrafficIncidentIds = new ArrayList<>();
    printList("incidentIdsToListener", updateListenerInfo.getIncidentIdsToListener());

    for (ManagedTrafficIncident eObject: relevantTrafficIncidents) {
      TrafficIncident trafficIncident = eObject.getTrafficIncident();
      Integer trafficIncidentId = trafficIncident.getTrafficIncidentId();
      LOGGER.info("Handling relevantTrafficIncidentId " + trafficIncidentId);
      relevantTrafficIncidentIds.add(trafficIncidentId);

      // if there is no current, everything is new.
      if (updateListenerInfo.getIncidentIdsToListener() != null) {
        // if in current and new, the incident is either unchanged or updated.
        // else it is new.
        if (updateListenerInfo.getIncidentIdsToListener().contains(trafficIncidentId)) {
          if (eObject.getReceivedAt().after(updateListenerInfo.getUpdateTime())) {
            // in current and new, but later timestamp, so updated.
            LOGGER.info("adding trafficIncidentId " + trafficIncidentId + " to Updated list.");
            updatedIds.add(trafficIncidentId);
          } else {
            // in current and new, and same timestamp, so unchanged.
            LOGGER.info("adding trafficIncidentId " + trafficIncidentId + " to Unchanged list.");
            unchangedIds.add(trafficIncidentId);
          }
        } else {
          LOGGER.info("adding trafficIncidentId " + trafficIncidentId + " to New list.");
          newIds.add(trafficIncidentId);
        }
      } else {
        LOGGER.info("adding trafficIncidentId " + trafficIncidentId + " to New list (first update).");
        newIds.add(trafficIncidentId);
      }
    }
     
    // if incidentIdsToListener is null, nothing is deleted.
    if (updateListenerInfo.getIncidentIdsToListener() != null) {
      for (Integer trafficIncidentId: updateListenerInfo.getIncidentIdsToListener()) {
        if (!relevantTrafficIncidentIds.contains(trafficIncidentId)) {
          LOGGER.info("adding trafficIncidentId " + trafficIncidentId + " to Deleted list.");
          deletedIds.add(trafficIncidentId);
        }
      }
    }
    
    printList("unchangedIds", unchangedIds);
    printList("updatedIds", updatedIds);
    printList("newIds", newIds);
    printList("deletedIds", deletedIds);
    
    
    // call the listener if the listener is new, or if there are any changes.
    // There are changes if any of updatedIds, newIds or deletedIds is not empty.
    if ((updateListenerInfo.getIncidentIdsToListener() == null)  ||
        (!updatedIds.isEmpty()  ||
        !newIds.isEmpty()  ||
        !deletedIds.isEmpty())) {
      LOGGER.info("Calling updates() on listener.");
      updateListener.updates(new BasicEList<Integer>(unchangedIds),
          new BasicEList<Integer>(updatedIds),
          new BasicEList<Integer>(newIds),
          new BasicEList<Integer>(deletedIds));
      LOGGER.info("After calling updates() on listener.");
 
      unchangedIds.addAll(updatedIds);
      unchangedIds.addAll(newIds);
      updateListenerInfo.setIncidentIdsToListener(unchangedIds);
      updateListenerInfo.setUpdateTime(new Date());
    } else {
      LOGGER.info("NOT Calling getTrafficIncidentIdsReply().");
    }
    LOGGER.info("handleUpdateListener <=");
  }

  private void printList(String listName, List<Integer> incidentIds) {
    StringBuilder buf = new StringBuilder();
    
    buf.append("INCIDENTS: ");
    buf.append(listName);
    buf.append(":");
    
    if (incidentIds == null) {
      buf.append("NULL");
    } else if (incidentIds.isEmpty()) {
      buf.append("EMPTY");
    } else {
      for (Integer incidentId: incidentIds) {
        buf.append(" ");
        buf.append(incidentId);
      }
    }
    
    LOGGER.info(buf.toString());
  }

  @Override
  public void getLanguage(TrafficIncidentsListener listener) {
    listener.getLanguageReply(languageCode, languageCountryCode);
  }
  
  @Override
  public void setLanguage(TrafficIncidentsListener listener, String languageCode, String countryCode) {
    LOGGER.info("Setting language to: " + languageCode + ", " + countryCode);
    this.languageCode = languageCode;
    this.languageCountryCode = countryCode;
    
    trafficIncidentTextGenerator.setLanguage(languageCode, countryCode);
    
    notifyLanguageListeners();
    
    if (listener != null) {
      listener.setLanguageReply();
    }
  }

  @Override
  public void getTexts(TrafficIncidentsListener listener, EList<Integer> trafficIncidentIds, TextDetailLevel textDetailLevel) {
    EList<TrafficIncident> trafficIncidents = getTrafficIncidents(trafficIncidentIds, false);
    EList<String> texts = new BasicEList<String>();

    for (int i = 0; i < trafficIncidents.size(); i++) {
      texts.add(trafficIncidentTextGenerator.getText(trafficIncidents.get(i), textDetailLevel));
    }
    
    listener.getTextsReply(texts);
  }

  @Override
  public void getTrafficIncidentsFields(TrafficIncidentsListener listener,
      EList<Integer> trafficIncidentIds, EList<TrafficIncidentField> trafficIncidentFields) {
    LOGGER.info("=> listener = " + listener + ", trafficIncidentIds = " + trafficIncidentIds + ", trafficIncidentFields = " + trafficIncidentFields);
    EList<TrafficIncident> trafficIncidents = getTrafficIncidentsFields(trafficIncidentIds, trafficIncidentFields);
    LOGGER.info("trafficIncidents = " + trafficIncidents);
    listener.getTrafficIncidentsReply(trafficIncidents);
    LOGGER.info("<=");
  }

  private EList<TrafficIncident> getTrafficIncidentsFields(EList<Integer> trafficIncidentIds, EList<TrafficIncidentField> trafficIncidentFields) {
    EList<TrafficIncident> trafficIncidents = new BasicEList<TrafficIncident>();

    for (int trafficIncidentId: trafficIncidentIds) {
      TrafficIncident trafficIncident = getTrafficIncident(trafficIncidentId, true);
      if (trafficIncident != null) {
        trafficIncidents.add(constructTrafficIncidentFields(trafficIncident, trafficIncidentFields));
      }
    }

    return trafficIncidents;
  }
  
  private TrafficIncident constructTrafficIncidentFields(TrafficIncident trafficIncident, EList<TrafficIncidentField> trafficIncidentFields) {
    TrafficIncident incident;
    incident = TRAFFIC_INCIDENT_FACTORY.createTrafficIncident();
    incident.setTrafficIncidentId(trafficIncident.getTrafficIncidentId());
    
    for (TrafficIncidentField trafficIncidentField: trafficIncidentFields) {
      switch (trafficIncidentField) {
      case APPLICABILITY:
        EList<Applicability> applicability = incident.getApplicability();
        for (Applicability trafficIncidentApplicability: trafficIncident.getApplicability()) {
          applicability.add(EcoreUtil.copy(trafficIncidentApplicability));
        }
        break;
        
      case APPLICABILITY_TEXTS:
        EList<String> applicabilityTexts = incident.getApplicabilityTexts();
        for (String trafficIncidentApplicabilityText: trafficIncident.getApplicabilityTexts()) {
          applicabilityTexts.add(trafficIncidentApplicabilityText);
        }
        break;
        
      case AVERAGE_SPEED_ABSOLUTE:
        if (trafficIncident.isSetAverageSpeedAbsolute()) {
          trafficIncident.setAverageSpeedAbsolute(trafficIncident.getAverageSpeedAbsolute());
        }
        break;
        
      case CAUSE_TEXTS:
        EList<String> causeTexts = incident.getCauseTexts();
        for (String trafficIncidentCauseText: trafficIncident.getCauseTexts()) {
          causeTexts.add(trafficIncidentCauseText);
        }
        break;
        
      case CAUSES:
        EList<Cause> causes = incident.getCauses();
        for (Cause trafficIncidentCause: trafficIncident.getCauses()) {
          causes.add(EcoreUtil.copy(trafficIncidentCause));
        }       
        break;
        
      case DELAY:
        if (trafficIncident.isSetDelay()) {
          incident.setDelay(trafficIncident.getDelay());
        }
        break;
        
      case EFFECT_CODE:
        if (trafficIncident.isSetEffectCode()) {
          incident.setEffectCode(trafficIncident.getEffectCode());
        }
        break;
        
      case EFFECT_TEXT:
        if (trafficIncident.isSetEffectText()) {
          incident.setEffectText(trafficIncident.getEffectText());
        }
        break;

      case LENGTH_AFFECTED:
        if (trafficIncident.isSetLengthAffected()) {
          trafficIncident.setLengthAffected(trafficIncident.getLengthAffected());
        }
        break;

      case LOCATION:
        if (trafficIncident.isSetLocation()) {
          incident.setLocation(EcoreUtil.copy(trafficIncident.getLocation()));
        }
        break;

      case LOCATION_BOUNDING_BOX:
        incident.setLocationBoundingBox(EcoreUtil.copy(trafficIncident.getLocationBoundingBox()));
        break;

      case LOCATION_INFO:
        if (trafficIncident.isSetLocationInfo()) {
          incident.setLocationInfo(EcoreUtil.copy(trafficIncident.getLocationInfo()));
        }
        break;
        
      case SEGMENT_SPEED_LIMIT:
        if (trafficIncident.isSetSegmentSpeedLimit()) {
          incident.setSegmentSpeedLimit(trafficIncident.getSegmentSpeedLimit());
        }
        break;
        
      case EXPECTED_SPEED_ABSOLUTE:
    	if (trafficIncident.isSetExpectedSpeedAbsolute()) {
    	  incident.setExpectedSpeedAbsolute(trafficIncident.getExpectedSpeedAbsolute());
    	}
        
      case START_TIME:
        if (trafficIncident.isSetStartTime()) {
          incident.setStartTime(trafficIncident.getStartTime());
        }
        break;
        
      case STOP_TIME:
        if (trafficIncident.isSetStopTime()) {
          incident.setStopTime(trafficIncident.getStopTime());
        }
        break;
        
      case TENDENCY:
        if (trafficIncident.isSetTendency()) {
          incident.setTendency(trafficIncident.getTendency());
        }
        break;
        
      case TENDENCY_TEXT:
        if (trafficIncident.isSetTendencyText()) {
          incident.setTendencyText(trafficIncident.getTendencyText());
        }
        break;
        
      case TRAFFIC_INCIDENT_ID:
        // No action as the Id is always filled in.
        break;
      
      case ADVICES:
        EList<Advice> advices = incident.getAdvices();
        for (Advice advice: trafficIncident.getAdvices()) {
          advices.add(EcoreUtil.copy(advice));
        }       
        break;
        
      case ADVICE_TEXTS:
        EList<String> adviceTexts = incident.getAdviceTexts();
        for (String adviceText: trafficIncident.getAdviceTexts()) {
          adviceTexts.add(adviceText);
        }
        break;
      }
    }
    
    return incident;
  }
  
  private void notifyLanguageListeners() {
    for (TrafficIncidentFeedListener listener: trafficIncidentFeedListeners) {
      listener.getLanguageReply(languageCode, languageCountryCode);
    }
  }

  @Override
  public void getVersion(TrafficIncidentFeedListener listener) {
    listener.getVersionReply(VERSION);
  }

  @Override
  public synchronized void addTrafficIncidentsStatusListener(
      TrafficIncidentsListener listener, TrafficIncidentsListener trafficIncidentsStatusListener) {
    trafficIncidentsStatusListeners.add(trafficIncidentsStatusListener);
    trafficIncidentsStatusListener.trafficIncidentsStatus(trafficIncidentFeedStatus, trafficIncidentsStatus);
    
    if (listener != null) {
      listener.addTrafficIncidentsStatusListenerReply();
    }
  }

  @Override
  public void removeTrafficIncidentsStatusListener(
      TrafficIncidentsListener listener,
      TrafficIncidentsListener trafficIncidentsStatusListener) {
    trafficIncidentsStatusListeners.remove(trafficIncidentsStatusListener);
    
    if (listener != null) {
      listener.removeTrafficIncidentsStatusListenerReply();
    }
  }

  @Override
  public void addFeedInformationListener(TrafficIncidentsListener listener, TrafficIncidentsListener feedInformationListener) {
    feedInformationListeners.add(feedInformationListener);
    feedInformationListener.feedInformation(createFeedsInformationList());
    
    if (listener != null) {
      listener.addFeedInformationListenerReply();
    }
  }

  @Override
  public void removeFeedInformationListener(TrafficIncidentsListener listener,
      TrafficIncidentsListener feedInformationListener) {
    feedInformationListeners.remove(feedInformationListener);
    
    if (listener != null) {
      listener.removeFeedInformationListenerReply();
    }
  }
  
  private void notifyTrafficIncidentsStatusListeners() {
    for (TrafficIncidentsListener trafficIncidentsStatusListener: trafficIncidentsStatusListeners) {
      LOGGER.info("Notify update listeners by calling updates()");
      trafficIncidentsStatusListener.trafficIncidentsStatus(trafficIncidentFeedStatus, trafficIncidentsStatus);
    }
  }

  @Override
  public void registerFeed(TrafficIncidentFeedListener listener,
      String dataProviderName, String protocolName,
      String communicationChannelName) {
    FeedInformation feedInformation = TRAFFIC_INCIDENTS_FACTORY.createFeedInformation();
    feedInformation.setDataProviderName(dataProviderName);
    feedInformation.setProtocolName(protocolName);
    feedInformation.setCommunicationChannelName(communicationChannelName);
    feedInformation.setFeedStatus(TrafficIncidentFeedStatus.UNAVAILABLE);
    feedInformation.setTrafficIncidentsStatus(TrafficIncidentsStatus.UNAVAILABLE);
    
    Integer feedId = generateFeedId();
    
    feedsInformation.put(feedId, feedInformation);

    notifyFeedInformationListeners();
    
    listener.registerFeedReply(feedId);
  }

  private void notifyFeedInformationListeners() {
    LOGGER.info("=> ");
    EList<FeedInformation> feedsInformationList = createFeedsInformationList();
    
    for (TrafficIncidentsListener feedInformationListener: feedInformationListeners) {
      LOGGER.info("Going to notify listener: " + feedInformationListener);
      feedInformationListener.feedInformation(feedsInformationList);
    }
    LOGGER.info("<= ");
  }
  
  private EList<FeedInformation> createFeedsInformationList() {
    EList<FeedInformation> feedsInformationList = new BasicEList<FeedInformation>();
    for (Integer feedId: feedsInformation.keySet()) {
      FeedInformation feedInformation = feedsInformation.get(feedId);
      feedsInformationList.add(feedInformation);
    }
    
    return feedsInformationList;
  }
  

  @Override
  public void addCategoryDefinitions(
      TrafficIncidentsListener listener, EList<CategoryDefinition> categoryDefinitions) {
    LOGGER.info("addCategoryDefinitions => categoryDefinitions = " + categoryDefinitions);
    for (CategoryDefinition categoryDefinition: categoryDefinitions) {
      LOGGER.info("addCategoryDefinitions: adding categoryDefinition: " + categoryDefinition);
      this.categoryDefinitions.add(categoryDefinition);
    }
    
    if (listener != null) {
      listener.addCategoryDefinitionsReply();
    }
    LOGGER.info("addCategoryDefinitions <=");
  }

  @Override
  public void reserveIconSetIds(TrafficIncidentsListener listener, int numberOfIds) {
    EList<Integer> iconSetIds = new BasicEList<Integer>();
    for (int i = 1; i <= numberOfIds; i++) {
      Integer iconSetId = reserveIconSetId();
      iconSetIds.add(iconSetId);
    }
    listener.reserveIconSetIdsReply(iconSetIds);
  }

  private Integer reserveIconSetId() {
    for (int i = 1; i < Integer.MAX_VALUE; i++) {
      if (reservedIconSetIds.add(i)) {
        return i;
      }
    }
    throw new RuntimeException("No more IconSetId available");
  }

  @Override
  public void freeIconSetIds(TrafficIncidentsListener listener, EList<Integer> iconSetIds) {
    for (Integer iconSetId: iconSetIds) {
      reservedIconSetIds.remove(iconSetId);
    }
    
    if (listener != null) {
      listener.freeIconSetIdsReply();
    }
  }

  @Override
  public void addIconDefinitions(TrafficIncidentsListener listener, EList<IconDefinition> iconDefinitions) {
    for (IconDefinition iconDefinition: iconDefinitions) {
      iconDefinitionsMap.put(iconDefinition.getIconInfo(), iconDefinition);
    }
    
    if (listener != null) {
      listener.addIconDefinitionsReply();
    }
  }

  @Override
  public void removeIconDefinitions(TrafficIncidentsListener listener, EList<IconInfo> iconInfos) {
    for (IconInfo iconInfo: iconInfos) {
      iconDefinitionsMap.remove(iconInfo);
    }
    
    if (listener != null) {
      listener.removeIconDefinitionsReply();
    }
  }

  @Override
  public void addIconSetDefinitions(TrafficIncidentsListener listener, EList<IconSet> iconSets) {
    for (IconSet iconSet: iconSets) {
      this.iconSets.add(iconSet);
    }
    
    if (listener != null) {
      listener.addIconSetDefinitionsReply();
    }
  }

  @Override
  public void removeIconSetDefinitions(TrafficIncidentsListener listener, EList<Integer> iconSetIds) {
    for (int iconSetId: iconSetIds) {
      for (IconSet iconSet: iconSets) {
        if (iconSet.getIconSetId() == iconSetId) {
          iconSets.remove(iconSet);
          break;
        }
      }
    }
    
    if (listener != null) {
      listener.removeIconSetDefinitionsReply();
    }
  }

  @Override
  public void getIconSets(TrafficIncidentsListener listener) {
    listener.getIconSetsReply(iconSets);
  }

  @Override
  public void getIconDefinitions(TrafficIncidentsListener listener, EList<IconInfo> iconInfos) {
    BasicEList<IconDefinition> requestedIconDefinitions = new BasicEList<IconDefinition>();
    if (iconInfos.size() == 0) {
      for (IconDefinition iconDefinition: iconDefinitionsMap.values()) {
        requestedIconDefinitions.add(iconDefinition);
      }
    } else {
      for (IconInfo iconInfo: iconInfos) {
        requestedIconDefinitions.add(iconDefinitionsMap.get(iconInfo));
      }
    }
    
    listener.getIconDefinitionsReply(requestedIconDefinitions);
  }

  @Override
  public void reserveCategoryIds(TrafficIncidentsListener listener, int numberOfIds) {
    EList<Integer> categoryIds = new BasicEList<Integer>();
    for (int i = 1; i <= numberOfIds; i++) {
      Integer categoryId = reserveCategoryId();
      categoryIds.add(categoryId);
    }
    listener.reserveCategoryIdsReply(categoryIds);
  }

  private Integer reserveCategoryId() {
    for (int i = 1; i < Integer.MAX_VALUE; i++) {
      if (reservedCategoryIds.add(i)) {
        return i;
      }
    }
    throw new RuntimeException("No more IconSetId available");
  }

  @Override
  public void freeCategoryIds(TrafficIncidentsListener listener, EList<Integer> categoryIds) {
    for (Integer categoryId: categoryIds) {
      reservedCategoryIds.remove(categoryId);
    }
    
    if (listener != null) {
      listener.freeCategoryIdsReply();
    }
  }

  @Override
  public void removeCategoryDefinitions(TrafficIncidentsListener listener, EList<Integer> categoryIds) {
    for (int categoryId: categoryIds) {
      for (CategoryDefinition categoryDefinition: categoryDefinitions) {
        if (categoryDefinition.getCategoryId() == categoryId) {
          categoryDefinitions.remove(categoryDefinition);
          break;
        }
      }
    }
    
    if (listener != null) {
      listener.removeCategoryDefinitionsReply();
    }
  }

  @Override
  public void getCategoryDefinitions(TrafficIncidentsListener listener) {
    listener.getCategoryDefinitionsReply(categoryDefinitions);
  }

  @Override
  public void setApplicability(TrafficIncidentsListener listener, String expressionString) {
    LOGGER.info("=> " + expressionString);
    
    BooleanExpression filterExpression = FilterExprUtil.parseFilterExpression(expressionString);
    if (filterExpression != null) {
      LOGGER.info("filterExpression: " + filterExpression.toString());
    } else {
      LOGGER.info("filterExpression is null");
    }
    setApplicability(filterExpression);
    
    
    if (listener != null) {
      listener.setApplicabilityReply();
    }
    LOGGER.info("<= ");
  }

  public void setApplicability(BooleanExpression filterExpression) {
    LOGGER.info("=> ");
    if (filterExpression == null) {
      applicabilityFilter = null;
      // No need to check for incidents which aren't applicable anymore.
    } else {
      applicabilityFilter = new ExpressionFilter(filterExpression);
      handleApplicabilityChanged();
    }
    LOGGER.info("<= ");
  }

  private void handleApplicabilityChanged() {
    LOGGER.info("=> ");
    
    // Create a list of current incidents which are no longer Applicable: a cancel list.
    EList<ManagedTrafficIncident> incidentsToCancel = applyAcceptFilter(managedIncidents, applicabilityFilter);
    LOGGER.info("incidentsToCancel: " + incidentsToCancel);
    
    // Remove these from the current incidents.
    for (ManagedTrafficIncident managedTrafficIncident: incidentsToCancel) {
      String trafficIncidentManagementId = managedTrafficIncident.getxTrafficIncident().getTrafficIncidentId();
      int trafficIncidentId = managedTrafficIncident.getTrafficIncident().getTrafficIncidentId();
      xIncidentIdToManagedIncidentMap.remove(trafficIncidentManagementId);
      incidentIdToManagedIncidentMap.remove(trafficIncidentId);
      managedIncidents.remove(managedTrafficIncident);
      LOGGER.info("Traffic Incident removed, Id = " + trafficIncidentId + ", managementId = " + trafficIncidentManagementId);
    }
    
    // Notify listeners in case of changes.
    if (!incidentsToCancel.isEmpty()) {
      notifyUpdateListeners();
    }
    LOGGER.info("<= ");
  }

  @Override
  public void getApplicability(TrafficIncidentsListener listener) {
    String expressionString = "";
    
    if (applicabilityFilter != null) {
      BooleanExpression filterExpression = applicabilityFilter.getExpression();
      expressionString = filterExpression.toString();
    }
    
    listener.getApplicabilityReply(expressionString);
  }

  @Override
  public void setTimeFormat(TrafficIncidentsListener listener, String timeFormat) {
    trafficIncidentTextGenerator.setTimeFormat(timeFormat);
    
    if (listener != null) {
      listener.setTimeFormatReply();
    }
  }

  @Override
  public void setDateFormat(TrafficIncidentsListener listener, String dateFormat) {
    trafficIncidentTextGenerator.setDateFormat(dateFormat);
    
    
    if (listener != null) {
      listener.setDateFormatReply();
    }
  }

  @Override
  public void setLengthUnit(TrafficIncidentsListener listener, LengthUnit lengthUnit) {
    trafficIncidentTextGenerator.setLengthUnit(lengthUnit);
    
    if (listener != null) {
      listener.setLengthUnitReply();
    }
  }

  @Override
  public void setWeightUnit(TrafficIncidentsListener listener, WeightUnit weightUnit) {
    trafficIncidentTextGenerator.setWeightUnit(weightUnit);    
    
    if (listener != null) {
      listener.setWeightUnitReply();
    }
  }

  public static EList<ManagedTrafficIncident> applyAcceptFilter(List<ManagedTrafficIncident> managedIncidents, Filter filter) {
    LOGGER.info("=>");
    EList<ManagedTrafficIncident> filteredManagedIncidents = new BasicEList<>();
    
    for (ManagedTrafficIncident managedIncident: managedIncidents) {
      if (filter.filter(managedIncident.getTrafficIncident())) {
        LOGGER.info("Adding object to filteredList: " + managedIncident);
        filteredManagedIncidents.add(managedIncident);
      } else {
        LOGGER.info("Object NOT added to filteredList: " + managedIncident);
      }
    }
    
    LOGGER.info("<=");
    return filteredManagedIncidents;
  }

  public static EList<ManagedTrafficIncident> applyFilters(List<ManagedTrafficIncident> managedIncidents, EList<Filter> filters) {
    EList<ManagedTrafficIncident> filteredList = new BasicEList<>(managedIncidents);
    for (Filter filter: filters) {
      filteredList = applyAcceptFilter(filteredList, filter);
    }
    return filteredList;
  }
  
  private List<TrafficIncident> getTrafficIncidents() {
    List<TrafficIncident> trafficIncidents = new ArrayList<>();
    
    for (ManagedTrafficIncident managedTrafficIncident: managedIncidents) {
      trafficIncidents.add(managedTrafficIncident.getTrafficIncident());
    }
    
    return trafficIncidents;
  }
  
  class HandleUpdateListenerRunnable implements Runnable {
    private TrafficIncidentsListener updateListener;
    
    public HandleUpdateListenerRunnable(TrafficIncidentsListener updateListener) {
      this.updateListener = updateListener;
    }
    
    @Override
    public void run() {
      handleUpdateListener(updateListener);      
    }
    
  }
}
