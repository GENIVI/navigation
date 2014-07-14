/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.locref.refimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.locref.LocationReference;
import org.genivi.locref.LocationReferenceDecodingService;
import org.genivi.locref.LocationReferenceDecodingServiceListener;
import org.genivi.locref.decoder.LocationData;
import org.genivi.locref.decoder.LocationReferenceDecoder;


public class LocationReferenceDecodingHandlerRefImpl extends EObjectImpl implements LocationReferenceDecodingService {
    private final static Logger LOGGER = Logger.getLogger(LocationReferenceDecodingHandlerRefImpl.class.getName()); 
 
    private static final String        DEFAULT_LANGUAGE = "nld";
    private static final String        DEFAULT_COUNTRY = null;
 
    private String languageCode = DEFAULT_LANGUAGE;
    private String countryCode = DEFAULT_COUNTRY;
    Map<Byte, LocationReferenceDecoder> decoders = new HashMap<>();
    

    public LocationReferenceDecodingHandlerRefImpl() {
      LOGGER.setLevel(Level.SEVERE);
    }
    
    @Override
    public void setLanguage(String languageCode, String countryCode) {
      this.languageCode = languageCode;
      this.countryCode = countryCode;
      for (LocationReferenceDecoder decoder: decoders.values()) {
        decoder.setLanguage(languageCode, countryCode);
      }
    }

    @Override
    public void getLanguage(LocationReferenceDecodingServiceListener listener) {
      listener.getLanguageReply(languageCode, countryCode);
    }
    
    public void addDecoder(Byte type, LocationReferenceDecoder decoder) {
      decoder.setLanguage(languageCode, countryCode);
      decoders.put(type, decoder);
    }

    public void removeDecoder(String type) {
      decoders.remove(type);
    }

    @Override
    public void decode(LocationReferenceDecodingServiceListener listener,
        LocationReference locationReference) {
      if (locationReference == null) {
        throw new RuntimeException("LocationReferenceDecodingHandlerRefImpl: locationReference is null");
      }
      Byte locationReferenceType = (Byte) (byte) locationReference.getLocationReferenceType();
      LocationReferenceDecoder decoder = decoders.get(locationReferenceType);
      if (decoder == null) {
          throw new RuntimeException("Location reference type \'" +
                  locationReferenceType.toString() + "\' not supported");
      }
      Object locationReferenceData = locationReference.getData();
      LOGGER.info("Decoding location of type: " + locationReferenceType.toString());
      LocationData locationData = decoder.decode(locationReferenceData);
      
      listener.decodeReply(locationData.getLocation(), locationData.getLocationInfo());
    }
}
