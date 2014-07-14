/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.common.Version;

public class DefaultTrafficIncidentsUpdatesListener extends EObjectImpl implements TrafficIncidentFeedListener {
  private final static Logger LOGGER = Logger.getLogger(DefaultTrafficIncidentsUpdatesListener.class.getName());

  static {
    LOGGER.setLevel(Level.SEVERE);
  }
  
  @Override
  public void getVersionReply(Version version) {
    // No action. Override this method if action is needed.
    LOGGER.info("Call to getVersionReply ignored!");
  }

  @Override
  public void getLanguageReply(String languageCode, String countryCode) {
    // No action. Override this method if action is needed.
    LOGGER.info("Call to getLanguageReply ignored!");
  }

  @Override
  public void registerFeedReply(int feedId) {
    // No action. Override this method if action is needed.
    LOGGER.info("Call to registerFeedReply ignored!");
  }

  @Override
  public void addLanguageListenerReply() {
    // No action. Override this method if action is needed.
    LOGGER.info("Call to addLanguageListenerReply ignored!");
  }

  @Override
  public void removeLanguageListenerReply() {
    // No action. Override this method if action is needed.
    LOGGER.info("Call to removeLanguageListenerReply ignored!");
  }


}
