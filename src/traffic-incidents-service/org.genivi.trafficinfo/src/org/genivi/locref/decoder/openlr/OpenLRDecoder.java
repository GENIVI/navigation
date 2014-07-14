/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.locref.decoder.openlr;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import openlr.OpenLRRuntimeException;
import openlr.binary.ByteArray;
import openlr.binary.OpenLRBinaryRuntimeException;
import openlr.decoder.OpenLRDecoderRuntimeException;
import openlr.decoder.properties.generated.OpenLRDecoderProperties;
import openlr.map.Line;
import openlr.map.MapDatabase;
import openlr.map.Node;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.genivi.common.CommonFactory;
import org.genivi.common.Coordinate;
import org.genivi.location.LinearLocation;
import org.genivi.location.LinearLocationInfo;
import org.genivi.location.Location;
import org.genivi.location.LocationFactory;
import org.genivi.location.LocationInfo;
import org.genivi.locref.decoder.LocationData;
import org.genivi.locref.decoder.LocationReferenceDecoder;

public class OpenLRDecoder implements LocationReferenceDecoder {
  private final static Logger LOGGER = Logger.getLogger(OpenLRDecoder.class.getName()); 
  private static final LocationFactory LOCATION_FACTORY = LocationFactory.eINSTANCE;
  private static final CommonFactory COMMON_FACTORY = CommonFactory.eINSTANCE;

  private static final String        DEFAULT_LANGUAGE = "nld";
  private static final String        DEFAULT_COUNTRY = null;

  /** The Constant DECODER_PROPERTIES_FILE. */
  private static final String DECODER_PROPERTIES_FILE = "/OpenLR-Decoder-Properties.xml";

  private static Map<String, String>     languageMap = new HashMap<String, String>();
  private static Map<String, String>     countryMap = new HashMap<String, String>();

  private MapDatabase mapDataBase;
  private OpenLRDecoderProperties openLRDecoderProperties;
  private String languageCode = DEFAULT_LANGUAGE;
  private String countryCode = DEFAULT_COUNTRY;
  private Locale locale;
  
  static {
    languageMap.put("deu", "de");
    languageMap.put("eng", "en");
    languageMap.put("fra", "fr");
    languageMap.put("nld", "nl");
    
    countryMap.put("nld", "NL");
    countryMap.put("gbr", "GB");
    countryMap.put("usa", "US");
    countryMap.put("fra", "FR");
    countryMap.put("deu", "DE");
  }

  public OpenLRDecoder(MapDatabase mapDataBase) {
    this.mapDataBase = mapDataBase;

    InputStream is = null;
    is = getClass().getResourceAsStream(DECODER_PROPERTIES_FILE);
    try {
      openLRDecoderProperties = openlr.decoder.properties.OpenLRPropertiesReader.loadPropertiesFile(is);
    } catch (OpenLRDecoderRuntimeException e) {
      throw new RuntimeException("Parsing of decoder properties failed!");
    }
    
    handleLanguageChange();
  }

  @Override
  public void setLanguage(String languageCode, String countryCode) {
    LOGGER.fine("=> languageCode = " + languageCode + ", countryCode = " + countryCode);
    this.languageCode = languageCode;
    this.countryCode = countryCode;
    
    handleLanguageChange();
  }
  
  private void handleLanguageChange() {
    String twoCharLanguageCode = languageMap.get(languageCode);
    String twoCharCountryCode = null;
    if (countryCode != null) {
      twoCharCountryCode = countryMap.get(countryCode);
    }
    
    if (twoCharCountryCode != null) {
      locale = new Locale(twoCharLanguageCode, twoCharCountryCode);
    } else {
      locale = new Locale(twoCharLanguageCode);
    }
    LOGGER.fine("locale = " + locale.getDisplayName());
  }

  @Override
  public LocationData decode(Object locationReference) {
    if (! (locationReference instanceof byte[])) {
      throw new IllegalArgumentException("Wrong class for locationReference (not byte[])");
    }
    
    openlr.LocationReference openLrLocationReference = null;
    ByteArray ba = new ByteArray((byte[]) locationReference);
    try {
      openLrLocationReference = new openlr.binary.impl.LocationReferenceBinaryImpl("", ba);
    } catch (OpenLRBinaryRuntimeException e) {
      e.printStackTrace();
    }

    openlr.Location openlrLocation = null;  // Decoding result
    Location location = null;               // Decoding result in GENIVI format
    LocationInfo locationInfo = null;       // Location info related to location

    try {
      openlrLocation = openlr.decoder.OpenLRDecoder.decode(openLRDecoderProperties, openLrLocationReference, mapDataBase);
    } catch (OpenLRRuntimeException e) {
      e.printStackTrace();
    }

    switch (openlrLocation.getLocationType()) {
    case LINE_LOCATION:
      LinearLocation linearLocation = LOCATION_FACTORY.createLinearLocation();
      List<Long> segments = linearLocation.getSegments();
      
      List<? extends Line> openlrMapLines = openlrLocation.getLocationLines();
      for (Line openlrMapLine: openlrMapLines) {
        segments.add(openlrMapLine.getID());
      }
      linearLocation.setPositiveOffset(openlrLocation.getPositiveOffset());
      linearLocation.setNegativeOffset(openlrLocation.getNegativeOffset());
      LOGGER.fine("Positive Offset = " + linearLocation.getPositiveOffset() + ", Negative Offset = " + linearLocation.getNegativeOffset());

      location = linearLocation;
      locationInfo = getLinearLocationInfo(linearLocation);
      break;
      
    case GEO_COORDINATES:
    case POI_WITH_ACCESS_POINT:
    case POINT_ALONG_LINE:
    case UNKNOWN:
      // TODO PRIO9: FULL_IMPL Implement other location types (and error handling for illegal types).
      throw new IllegalArgumentException("Unsupported location type: " + openlrLocation.getLocationType());
    }
    
    return new LocationData(location, locationInfo);
  }

  
  private LocationInfo getLinearLocationInfo(LinearLocation linearLocation) {
    LinearLocationInfo locationInfo = LOCATION_FACTORY.createLinearLocationInfo();
    
    EList<Long> segmentIds = linearLocation.getSegments();
    if (!segmentIds.isEmpty()) {
      // set fromLocationName to name of first line connected to first node, with a different name.
      Long firstSegmentId = segmentIds.get(0);
      Line firstLine = mapDataBase.getLine(firstSegmentId);
      String firstLineName = getStreetName(firstLine);
      LOGGER.fine("firstLineName =  " + firstLineName);
      locationInfo.setName(firstLineName);

      LOGGER.fine("Going to handle PrevLines ");
      Iterator<? extends Line> prevLines = firstLine.getPrevLines();
      while (prevLines.hasNext()) {
        Line prevLine = prevLines.next();
        String fromName = getStreetName(prevLine);
        LOGGER.fine("PrevLine: " + fromName);
        if (!fromName.equals(firstLineName)) {
          LOGGER.fine("fromName found: " + fromName);
          locationInfo.setFromLocationName(fromName);
          break;
        } else {
          LOGGER.fine("skipping name, name equals firstLineName: " + fromName);
        }
      }

      // set toLocationName to name of first line connected to last node, with a different name.
      Long lastSegmentId = segmentIds.get(segmentIds.size() - 1);
      Line lastLine = mapDataBase.getLine(lastSegmentId);               
      String lastLineName = getStreetName(lastLine);
      LOGGER.fine("lastLineName =  " + lastLineName);

      LOGGER.fine("Going to handle NextLines ");
      Iterator<? extends Line> nextLines = lastLine.getNextLines();
      while (nextLines.hasNext()) {
        Line nextLine = nextLines.next();
        String toName = getStreetName(nextLine);
        if (!toName.equals(lastLineName)) {
          LOGGER.fine("toName found: " + toName);
          locationInfo.setToLocationName(toName);
          break;
        } else {
          LOGGER.fine("skipping name, name equals lastLineName: " + toName);
        }
      }

    }
    
    // TODO PRIO9: FULL_IMPL Replace with an implementation for finding parent names in the database.
    if (locationInfo.getName() != null  &&
        locationInfo.getName().equals("Hogeweide")) {
      locationInfo.setFromLocationParentName("Amsterdam");
      locationInfo.setToLocationParentName("Eindhoven");
    }
    
    fillCoordinates(linearLocation, locationInfo);

    return locationInfo;
  }
  
  private void fillCoordinates(LinearLocation linearLocation,
      LinearLocationInfo locationInfo) {
    EList<Long> segmentIds = linearLocation.getSegments();
    EList<Coordinate> coordinates = locationInfo.getCoordinates();

    if (segmentIds.isEmpty()) {
      return;
    }
    
    int numberOfSegments = segmentIds.size();
    Coordinate coordinate;
    
    for (int i = 0; i < numberOfSegments; i++) {
      Long segmentId = segmentIds.get(i);
      Line line = mapDataBase.getLine(segmentId);
      
      if (i == 0) {
        // calculate start coordinate from start node and positive offset
        coordinate = calculateCoordinateOnSegment(line.getStartNode(), line.getEndNode(), linearLocation.getPositiveOffset());
        LOGGER.fine("Start coordinate added: " + coordinate);
        coordinates.add(coordinate);
        
        // This is also the main location
        locationInfo.setMainLocation(EcoreUtil.copy(coordinate));
      }
      if (i != numberOfSegments - 1) {
        coordinate = COMMON_FACTORY.createCoordinate();
        coordinate.setLatitude(line.getEndNode().getLatitudeDeg());
        coordinate.setLongitude(line.getEndNode().getLongitudeDeg());
        LOGGER.fine("Intermediate coordinate added: " + coordinate);
        coordinates.add(coordinate);
      } else {
        // calculate end coordinate from end node and negative offset
        coordinate = calculateCoordinateOnSegment(line.getEndNode(), line.getStartNode(), linearLocation.getNegativeOffset());
        LOGGER.fine("End coordinate added: " + coordinate);
        coordinates.add(coordinate);
      }
    }
  }

  private Coordinate calculateCoordinateOnSegment(Node startNode, Node endNode,
      long offset) {
    LOGGER.fine("offset = " + offset);
    double startLatitude = startNode.getLatitudeDeg();
    double startLongitude = startNode.getLongitudeDeg();
    double endLatitude = endNode.getLatitudeDeg();
    double endLongitude = endNode.getLongitudeDeg();
    LOGGER.fine("startLatitude = " + startLatitude + ", startLongitude = " + startLongitude);
    LOGGER.fine("endLatitude = " + endLatitude + ", endLongitude = " + endLongitude);
    
    double distance = distanceBetweenCoordinates(startLatitude, startLongitude, endLatitude, endLongitude);
    LOGGER.fine("distance = " + distance);
    
    double deltaLatitude = endLatitude - startLatitude;
    double deltaLongitude = endLongitude - startLongitude;
    LOGGER.fine("deltaLatitude = " + deltaLatitude + ", deltaLongitude = " + deltaLongitude);
    double latitude = startLatitude + offset / distance * deltaLatitude;
    double longitude = startLongitude + offset / distance * deltaLongitude;
    LOGGER.fine("latitude = " + latitude + ", longitude = " + longitude);
    
    Coordinate coordinate = COMMON_FACTORY.createCoordinate();
    coordinate.setLatitude(latitude);
    coordinate.setLongitude(longitude);

    return coordinate;
  }

  /**
   * Algorithm taken from:
   * http://stackoverflow.com/questions/837872/calculate-distance-in-meters-when-you-know-longitude-and-latitude-in-java
   */
  private double distanceBetweenCoordinates(double startLatitude,
      double startLongitude, double endLatitude, double endLongitude) {
    double earthMeanRadius = 6371009;
    double dLat = Math.toRadians(endLatitude - startLatitude);
    double dLng = Math.toRadians(endLongitude - startLongitude);
    LOGGER.fine("dLat = " + dLat + ", dLng = " + dLng);
    
    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
        Math.cos(Math.toRadians(startLatitude)) * Math.cos(Math.toRadians(endLatitude)) *
        Math.sin(dLng/2) * Math.sin(dLng/2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    double dist = earthMeanRadius * c;
    
    return dist;
  }

  private String getStreetName(Line line) {
    Map<Locale, List<String>> names = line.getNames();
    
    // First check for a name in requested locale
    List<String> namesForLocale = names.get(locale);
    if (namesForLocale != null  &&  !namesForLocale.isEmpty()) {
      LOGGER.fine("Found name in requested locale: " + namesForLocale.get(0));
      return namesForLocale.get(0);
    }
    
    // Next find any name for any locale
    for (Locale locale: names.keySet()) {
      LOGGER.fine("Checking for locale: " + locale.getDisplayName());
      List<String> namesPerLocale = names.get(locale);
      if (!namesPerLocale.isEmpty()) {
        LOGGER.fine("Found name in this locale: " + namesPerLocale.get(0));
        return namesPerLocale.get(0);
      }
    }
    
    return null;
  }

//  /**
//   * Convert a byte array to a human readable string.
//   */
//  private static String toHex(byte[] messageData) {
//      StringBuffer buffer= new StringBuffer("[ ");
//      for (int i = 0; i < messageData.length; i++) {
//          buffer.append(getHex(messageData[i])).append(' ');
//      }
//      buffer.append(']');
//      return buffer.toString();
//  }
//
//  /**
//   * Convert a byte to a printable format.
//   * @param b
//   * @return
//   */
//  private static String getHex(byte b) {
//      char char0, char1;
//      byte byte1= (byte) (0x0f & (b >> 4));
//      byte byte2= (byte) (0x0f & b);
//      char0 = (char) (byte1 > 9 ? 'a' + byte1 - 10 : '0' + byte1);
//      char1 = (char) (byte2 > 9 ? 'a' + byte2 - 10 : '0' + byte2);
//      return "" + char0 + char1;
//  }
}
