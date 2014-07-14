/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.common.CommonFactory;
import org.genivi.common.Coordinate;
import org.genivi.common.RectangularArea;
import org.genivi.location.AreaLocationInfo;
import org.genivi.location.LinearLocationInfo;
import org.genivi.location.Location;
import org.genivi.location.LocationInfo;
import org.genivi.location.PointLocationInfo;
import org.genivi.locref.LocationReferenceDecodingServiceListener;
import org.genivi.locref.refimpl.LocationReferenceDecodingHandlerRefImpl;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction;


public class LocationReferenceHandler {
  private final static Logger LOGGER = Logger.getLogger(LocationReferenceHandler.class.getName());
  private final static CommonFactory COMMON_FACTORY = CommonFactory.eINSTANCE;
  
  private TrafficIncidentsService trafficIncidentsService;
  private LocationReferenceDecodingHandlerRefImpl locationReferencDecodingHandler;
  private List<ManagedTrafficIncident> incidents;
  private boolean allDecodingRequestsSent = false;
  private boolean trafficIncidentsServiceNotified = true;
  private List<LocationDecodingHandlerListener> locationDecodingHandlerListeners = new ArrayList<LocationDecodingHandlerListener>();

  public LocationReferenceHandler(TrafficIncidentsService trafficIncidentsService,
      LocationReferenceDecodingHandlerRefImpl locationReferencDecodingHandler) {
    LOGGER.setLevel(Level.SEVERE);
    
    this.trafficIncidentsService = trafficIncidentsService;
    this.locationReferencDecodingHandler = locationReferencDecodingHandler;
  }

  public void setLanguage(String languageCode, String countryCode) {
    locationReferencDecodingHandler.setLanguage(languageCode, countryCode);
  }  

  public void handleLocationReferences(List<ManagedTrafficIncident> incidents) {
    LOGGER.info("Going to handle location references.");
    this.incidents = incidents;
    LocationDecodingHandlerListener locationDecodingHandlerListener;

    allDecodingRequestsSent = false;
    trafficIncidentsServiceNotified = false;

    for (ManagedTrafficIncident managedTrafficIncident: incidents) {
      LOGGER.info("Handling managedTrafficIncident: " + managedTrafficIncident.getxTrafficIncident().getTrafficIncidentId());
      org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident xTrafficIncident = managedTrafficIncident.getxTrafficIncident();
      TrafficIncident trafficIncident = managedTrafficIncident.getTrafficIncident();

      // Check for LocationReference to be decoded.
      if (xTrafficIncident.isSetLocationReference()) {
        LOGGER.info("Location to be dereferenced.");
        locationDecodingHandlerListener = new LocationDecodingHandlerListener(this, trafficIncident);
        locationDecodingHandlerListeners.add(locationDecodingHandlerListener);

        locationReferencDecodingHandler.decode(locationDecodingHandlerListener, xTrafficIncident.getLocationReference());
      }

      // Check for VehicleRelatedRestrictions - RestrictionLocations to be decoded.
      for (int applicabilityIndex = 0; applicabilityIndex < xTrafficIncident.getApplicability().size(); applicabilityIndex++) {
        org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability xApplicability = xTrafficIncident.getApplicability().get(applicabilityIndex);
        Applicability applicability = trafficIncident.getApplicability().get(applicabilityIndex);
        for (int restrictionIndex = 0; restrictionIndex < xApplicability.getVehicleRelatedRestrictions().size(); restrictionIndex++) {
          org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction xVehicleRelatedRestriction = xApplicability.getVehicleRelatedRestrictions().get(restrictionIndex);
          VehicleRelatedRestriction vehicleRelatedRestriction = applicability.getVehicleRelatedRestrictions().get(restrictionIndex);
          
          if (xVehicleRelatedRestriction.isSetRestrictionLocationReference()) {
            LOGGER.info("Restriction Location to be dereferenced.");
            locationDecodingHandlerListener = new LocationDecodingHandlerListener(this, vehicleRelatedRestriction);
            locationDecodingHandlerListeners.add(locationDecodingHandlerListener);

            locationReferencDecodingHandler.decode(locationDecodingHandlerListener, xVehicleRelatedRestriction.getRestrictionLocationReference());
          }
        }
      }
    }
    allDecodingRequestsSent = true;

    handleLocationDecoded(null);
  }
  
  synchronized void handleLocationDecoded(LocationDecodingHandlerListener locationDecodingHandlerListener) {
    if (locationDecodingHandlerListener != null) {
      locationDecodingHandlerListeners.remove(locationDecodingHandlerListener);
    }
    
    if (allDecodingRequestsSent  &&  locationDecodingHandlerListeners.isEmpty()  &&
        !trafficIncidentsServiceNotified) {
      trafficIncidentsServiceNotified = true;
      LOGGER.info("Ready with handling location references. Inform the TrafficIncidentsService that decoding the locations is done.");
      trafficIncidentsService.locationsDereferenced(incidents);
    }
  }

  public RectangularArea calculateBoundingBox(LocationInfo locationInfo) {
    Coordinate coordinate = locationInfo.getMainLocation();
    double minLatitude = coordinate.getLatitude();
    double maxLatitude = minLatitude;
    double minLongitude = coordinate.getLongitude();
    double maxLongitude = minLongitude;
    
    if (locationInfo instanceof LinearLocationInfo) {
      LinearLocationInfo linearLocationInfo = (LinearLocationInfo) locationInfo;
      
      for (Coordinate loopCoordinate: linearLocationInfo.getCoordinates()) {
        if (loopCoordinate.getLatitude() < minLatitude) {
          minLatitude = loopCoordinate.getLatitude();
        }
        if (loopCoordinate.getLatitude() > maxLatitude) {
          maxLatitude = loopCoordinate.getLatitude();
        }
        if (loopCoordinate.getLongitude() < minLongitude) {
          minLongitude = loopCoordinate.getLongitude();
        }
        if (loopCoordinate.getLongitude() > maxLongitude) {
          maxLongitude = loopCoordinate.getLongitude();
        }
      }
    } else if (locationInfo instanceof PointLocationInfo) {
      // Nothing else to do
    } else if (locationInfo instanceof AreaLocationInfo) {
      // TODO PRIO9: FULL_IMPL Implement bounding box for area locations.
    }
    
    Coordinate bottomLeft = COMMON_FACTORY.createCoordinate();
    bottomLeft.setAltitude(0);
    bottomLeft.setLongitude(minLongitude);
    bottomLeft.setLatitude(minLatitude);
    
    Coordinate topRight = COMMON_FACTORY.createCoordinate();
    topRight.setAltitude(0);
    topRight.setLongitude(maxLongitude);
    topRight.setLatitude(maxLatitude);
    
    RectangularArea boundingBox = COMMON_FACTORY.createRectangularArea();
    boundingBox.setBottomLeft(bottomLeft);
    boundingBox.setTopRight(topRight);
    
    return boundingBox;
  }

  class LocationDecodingHandlerListener extends EObjectImpl implements LocationReferenceDecodingServiceListener {
    private LocationReferenceHandler locationReferenceHandler;
    private Object targetLocationObject;

    LocationDecodingHandlerListener(LocationReferenceHandler locationReferenceHandler, Object targetLocationObject) {
      this.locationReferenceHandler = locationReferenceHandler;
      this.targetLocationObject = targetLocationObject;
    }
    
    @Override
    public void decodeReply(Location location, LocationInfo locationInfo) {
      if (targetLocationObject instanceof TrafficIncident) {
        TrafficIncident managedTrafficIncident = (TrafficIncident) targetLocationObject;
        if (location != null) {
          managedTrafficIncident.setLocation(location);
        }
        if (locationInfo != null) {
          managedTrafficIncident.setLocationInfo(locationInfo);
          managedTrafficIncident.setLocationBoundingBox(calculateBoundingBox(locationInfo));
        }
      } else if (targetLocationObject instanceof VehicleRelatedRestriction) {
        VehicleRelatedRestriction managedVehicleRelatedRestriction = (VehicleRelatedRestriction) targetLocationObject;
        managedVehicleRelatedRestriction.setRestrictionLocation(location);
      }

      locationReferenceHandler.handleLocationDecoded(this);
    }

    @Override
    public void getLanguageReply(String languageCode, String countryCode) {
      // no action.
    }
    
  }
}
