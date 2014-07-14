/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.dbus;

import java.util.List;

import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.DBusSignal;
import org.freedesktop.dbus.exceptions.DBusException;

public interface TrafficIncidentsDBus extends DBusInterface {
  public VersionStruct GetVersion();

  public TwoTuple<String, String> GetLanguage();

  public void SetLanguage(String languageCode, String countryCode);

  public void SetTimeFormat(String timeFormat);

  public void SetDateFormat(String dateFormat);

  public void SetLengthUnit(Byte lengthUnit);

  public void SetWeightUnit(Byte weightUnit);

  public String GetApplicability();

  public void SetApplicability(String expression);

  public List<Integer> ReserveIconSetIds(Integer numberOfIds);

  public void FreeIconSetIds(List<Integer> iconSetIds);

  public List<IconSetStruct> GetIconSets();

  public void AddIconSetDefinitions(List<IconSetStruct> iconSets);

  public void RemoveIconSetDefinitions(List<Integer> iconSetIds);

  public List<IconDefinitionStruct> GetIconDefinitions(List<IconInfoStruct> iconInfos);

  public void AddIconDefinitions(List<IconDefinitionStruct> iconDefinitions);

  public void RemoveIconDefinitions(List<IconInfoStruct> iconInfos);

  public List<Integer> ReserveCategoryIds(Integer numberOfIds);

  public void FreeCategoryIds(List<Integer> categoryIds);

  public List<CategoryDefinitionStruct> GetCategoryDefinitions();

  public void AddCategoryDefinitions(List<CategoryDefinitionStruct> categoryDefinitions);

  public void RemoveCategoryDefinitions(List<Integer> categoryIds);

  public List<Integer> GetTrafficIncidentIds(List<Byte> warningLevels, List<Integer> categoryIds);

  public List<Integer> GetTrafficIncidentIdsInAreas(List<Byte> warningLevels, List<Integer> categoryIds, List<RectangularAreaStruct> areas);

  public List<TrafficIncidentStruct> GetTrafficIncidents(List<Integer> trafficIncidentIds, boolean includeTextFields);

  public List<TrafficIncidentStruct> GetTrafficIncidentsFields(List<Integer> trafficIncidentIds, List<Byte> trafficIncidentFields);

  public List<String> GetTexts(List<Integer> trafficIncidentIds, Byte textDetailLevel);

  public void AddTrafficIncidentsStatusListener();

  public void RemoveTrafficIncidentsStatusListener();

  public void AddFeedInformationListener();

  public void RemoveFeedInformationListener();

  public void AddUpdateListener(Integer listenerId, List<Byte> warningLevels, List<Integer> categoryIds);

  public void RemoveUpdateListener(Integer listenerId);

  public void AddAreasUpdateListener(Integer listenerId, List<Byte> warningLevels, List<Integer> categoryIds, List<RectangularAreaStruct> areas);

  public void RemoveAreasUpdateListener(Integer listenerId);
  
  
  public class TrafficIncidentsStatus extends DBusSignal {
    public final Byte trafficIncidentFeedStatus;
    public final Byte trafficIncidentsStatus;
    
    public TrafficIncidentsStatus(String path,
        Byte trafficIncidentFeedStatus,
        Byte trafficIncidentsStatus) throws DBusException {
      super(path, trafficIncidentFeedStatus, trafficIncidentsStatus);
      this.trafficIncidentFeedStatus = trafficIncidentFeedStatus;
      this.trafficIncidentsStatus =trafficIncidentsStatus;
    }
  }

  
  public class FeedInformation extends DBusSignal {
    public final List<FeedInformationStruct> feedsInformation;
    
    public FeedInformation(String path, List<FeedInformationStruct> feedsInformation) throws DBusException {
      super(path, feedsInformation);
      this.feedsInformation = feedsInformation;
    }
  }

  
  public class Updates extends DBusSignal {
    public final Integer listenerId;
    public final List<Integer> unchangedTrafficIncidentIds;
    public final List<Integer> changedTrafficIncidentIds;
    public final List<Integer> newTrafficIncidentIds;
    public final List<Integer> deletedTrafficIncidentIds;
    
    public Updates(String path, Integer listenerId,
        List<Integer> unchangedTrafficIncidentIds,
        List<Integer> changedTrafficIncidentIds,
        List<Integer> newTrafficIncidentIds,
        List<Integer> deletedTrafficIncidentIds) throws DBusException {
      super(path, listenerId, unchangedTrafficIncidentIds, changedTrafficIncidentIds, newTrafficIncidentIds, deletedTrafficIncidentIds);
      this.listenerId = listenerId;
      this.unchangedTrafficIncidentIds = unchangedTrafficIncidentIds;
      this.changedTrafficIncidentIds = changedTrafficIncidentIds;
      this.newTrafficIncidentIds = newTrafficIncidentIds;
      this.deletedTrafficIncidentIds = deletedTrafficIncidentIds;
    }
  }

  
  public class UpdatesInAreas extends DBusSignal {
    public final Integer listenerId;
    public final List<RectangularAreaStruct> areas;
    
    public UpdatesInAreas(String path, Integer listenerId,
        List<RectangularAreaStruct> areas) throws DBusException {
      super(path, listenerId, areas);
      this.listenerId = listenerId;
      this.areas = areas;
    }
  }
}
