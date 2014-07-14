/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus;

import java.util.List;

import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.DBusSignal;
import org.freedesktop.dbus.exceptions.DBusException;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TwoTuple;

public interface TrafficIncidentFeedDBus extends DBusInterface {
  public VersionStruct GetVersion();

  public TwoTuple<String, String> GetLanguage();

  public Integer RegisterFeed(String dataProviderName, String protocolName,
      String communicationChannelName);
  
  public void Clear();
  
  public void UpdateIncidents(Integer feedId, List<String> cancelledIncidentIds,
      List<TrafficIncidentStruct> updatedIncidents);
  
  public void UpdateStatus(Integer feedId, Byte feedStatus, Byte incidentsStatus);
  
  public void AddLanguageListener();
  
  public void RemoveLanguageListener();
  
  public class LanguageChanged extends DBusSignal {
    public final String languageCode;
    public final String countryCode;
    
    public LanguageChanged(String path, String languageCode, String countryCode) throws DBusException {
      super(path, languageCode, countryCode);
      this.languageCode = languageCode;
      this.countryCode = countryCode;
    }
  }
}
