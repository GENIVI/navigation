/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.textgenerator;

import org.genivi.common.Version;
import org.genivi.trafficincidentsservice.LengthUnit;
import org.genivi.trafficincidentsservice.TextDetailLevel;
import org.genivi.trafficincidentsservice.WeightUnit;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;

/**
 * This interface is the interface for generating texts from a Traffic Incident data model.
 * A text generator is not a service to be used by different clients,
 * therefore it will be a plain C++ interface, instead of a D-Bus inteface.
 */
public interface TrafficIncidentTextGenerator {
  /**
   * Get the API version implemented by the TrafficIncidentTextGenerator.
   * @return
   */
  public Version getVersion();

  /**
   * Set the default language for text generation.
   * @param languageCode ISO 639-3 language code
   * @param countryCode ISO 3166-1 alpha 3 country code 
   */
  public void setLanguage(String languageCode, String countryCode);
  
  public void setDateFormat(String dateFormat);
  
  public void setTimeFormat(String timeFormat);
  
  public void setLengthUnit(LengthUnit lengthUnit);
  
  public void setWeightUnit(WeightUnit weightUnit);
  
  String getText(TrafficIncident trafficIncident, TextDetailLevel textDetailLevel);
  
  String[] getApplicabilityTexts(TrafficIncident trafficIncident);
  String[] getCauseTexts(TrafficIncident trafficIncident);
  String[] getAdviceTexts(TrafficIncident trafficIncident);
  String getEffectText(TrafficIncident trafficIncident);
  String getTendencyText(TrafficIncident trafficIncident);
}
