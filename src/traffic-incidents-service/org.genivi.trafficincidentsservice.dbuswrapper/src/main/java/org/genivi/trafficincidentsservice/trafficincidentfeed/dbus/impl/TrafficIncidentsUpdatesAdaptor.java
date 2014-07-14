/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.freedesktop.dbus.AbstractConnection;
import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;
import org.genivi.common.Version;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsUpdatesListener;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentFeed;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedListener;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.TrafficIncidentStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.TrafficIncidentFeedDBus;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.VersionStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TwoTuple;

public class TrafficIncidentsUpdatesAdaptor implements TrafficIncidentFeedDBus {
  private final static Logger LOGGER = Logger.getLogger(TrafficIncidentsUpdatesAdaptor.class.getName());
  
  private DBusConnection conn;
  private TrafficIncidentFeed trafficIncidentsService;
  private List<String> languageChangedListeners = new ArrayList<>();
  private TrafficIncidentFeedListener languageChangedListener = null;
  
  private PendingReplyGetLanguage pendingReplyGetLanguage;
  private PendingReply pendingReplyAddLanguageListener;
  private PendingReply pendingReplyRemoveLanguageListener;
  private PendingReplyGetVersion pendingReplyGetVersion;
  private PendingReplyRegisterFeed pendingReplyRegisterFeed;

  
  public TrafficIncidentsUpdatesAdaptor(DBusConnection conn, TrafficIncidentFeed trafficIncidentsService) {
    this.conn = conn;
    this.trafficIncidentsService = trafficIncidentsService;
    
    LOGGER.setLevel(Level.SEVERE);    
  }
  
@Override
  public boolean isRemote() {
    return false;
  }

  @Override
  public VersionStruct GetVersion() {
    LOGGER.info("getVersion =>");
    TrafficIncidentFeedListener listener = new DefaultTrafficIncidentsUpdatesListener() {
      
      @Override
      public void getVersionReply(Version trafficIncidentsVersion) {
        LOGGER.info("getVersionReply => trafficIncidentsVersion = " + trafficIncidentsVersion);
        pendingReplyGetVersion.setVersion(trafficIncidentsVersion);
        pendingReplyGetVersion.setReplyReceived(true);
      }  
    };
    pendingReplyGetVersion = new PendingReplyGetVersion(listener);
    
    trafficIncidentsService.getVersion(listener);
    
    while (!pendingReplyGetVersion.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getVersion - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }

    LOGGER.info("getVersion: reply received");
    Version version = pendingReplyGetVersion.getVersion();
    LOGGER.info("getVersion: version = " + version);
    VersionStruct versionStruct = StructUtil.versionToVersionStruct(version);
    
    LOGGER.info("getVersion <= versionStruct = " + versionStruct);
    return versionStruct;
  }

  @Override
  public TwoTuple<String, String> GetLanguage() {
    LOGGER.info("getLanguage =>");
    TrafficIncidentFeedListener listener = new DefaultTrafficIncidentsUpdatesListener() {
      
      @Override
      public void getLanguageReply(String languageCode, String countryCode) {
        LOGGER.info("getLanguageReply => languageCode = " + languageCode + ", countryCode = " + countryCode);
        pendingReplyGetLanguage.setLanguageCode(languageCode);
        pendingReplyGetLanguage.setCountryCode(countryCode);
        pendingReplyGetLanguage.setReplyReceived(true);
      }  
    };
    pendingReplyGetLanguage = new PendingReplyGetLanguage(listener);
    
    trafficIncidentsService.getLanguage(listener);
    
    while (!pendingReplyGetLanguage.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getLanguage - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    String countryCode = pendingReplyGetLanguage.getCountryCode();
    if (countryCode == null) {
      countryCode = "";
    }
    TwoTuple<String, String> language = new TwoTuple<>(
        pendingReplyGetLanguage.getLanguageCode(),
        countryCode);
    LOGGER.info("getLanguage <= language = " + language.a + ", " + language.b);
    return language;
  }

  @Override
  public void AddLanguageListener() {
    LOGGER.info("addLanguageListener =>");
    
    String sender = AbstractConnection.currentSender;
    if (!languageChangedListeners.contains(sender)) {
      languageChangedListeners.add(sender);
    }
    
    if (languageChangedListener == null) {
      languageChangedListener = new DefaultTrafficIncidentsUpdatesListener() {
        
        @Override
        public void getLanguageReply(String languageCode, String countryCode) {   
          LOGGER.info("getLanguageReply: " + languageCode + ", " + countryCode);
          sendLanguageChangedSignal(languageCode, countryCode);
        }
      };
     
      TrafficIncidentFeedListener listener = new DefaultTrafficIncidentsUpdatesListener() {
        
        @Override
        public void addLanguageListenerReply() {
          LOGGER.info("addLanguageListenerReply =>");
          pendingReplyAddLanguageListener.setReplyReceived(true);
        }  
      };
      pendingReplyAddLanguageListener = new PendingReply(listener);
      
      trafficIncidentsService.addLanguageListener(listener, languageChangedListener);
      
      while (!pendingReplyAddLanguageListener.isReplyReceived()) {
        try {
          Thread.sleep(10);
          LOGGER.info("pendingReplyAddLanguageListener - Waiting for reply ...");
        } catch (InterruptedException e) {
        }
      }
    }
    
    LOGGER.info("addLanguageListener <=");
  }

  @Override
  public void RemoveLanguageListener() {
    LOGGER.info("removeLanguageListener =>");
    
    String sender = AbstractConnection.currentSender;
    languageChangedListeners.remove(sender);
    
    if (languageChangedListeners.isEmpty()) {
      TrafficIncidentFeedListener listener = new DefaultTrafficIncidentsUpdatesListener() {
        
        @Override
        public void removeLanguageListenerReply() {
          LOGGER.info("removeLanguageListenerReply =>");
          languageChangedListener = null;
          pendingReplyRemoveLanguageListener.setReplyReceived(true);
        }  
      };
      pendingReplyRemoveLanguageListener = new PendingReply(listener);
      
      trafficIncidentsService.removeLanguageListener(listener, languageChangedListener);
      
      while (!pendingReplyRemoveLanguageListener.isReplyReceived()) {
        try {
          Thread.sleep(10);
          LOGGER.info("removeLanguageListener - Waiting for reply ...");
        } catch (InterruptedException e) {
        }
      }
    }
    
    LOGGER.info("removeLanguageListener <=");
  }

  @Override
  public Integer RegisterFeed(String dataProviderName, String protocolName,
      String communicationChannelName) {
    LOGGER.info("registerFeed => dataProviderName = " + dataProviderName +
        ", protocolName = " + protocolName + ", communicationChannelName = " + communicationChannelName);
    TrafficIncidentFeedListener listener = new DefaultTrafficIncidentsUpdatesListener() {
      
      @Override
      public void registerFeedReply(int feedId) {
        LOGGER.info("registerFeedReply => feedId = " + feedId);
        pendingReplyRegisterFeed.setFeedId(feedId);
        pendingReplyRegisterFeed.setReplyReceived(true);
      }
    };
    pendingReplyRegisterFeed = new PendingReplyRegisterFeed(listener);
    
    trafficIncidentsService.registerFeed(listener, dataProviderName, protocolName, communicationChannelName);
    
    while (!pendingReplyRegisterFeed.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("registerFeed - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }

    Integer feedId = pendingReplyRegisterFeed.getFeedId();
    
    LOGGER.info("registerFeed <= feedId = " + feedId);
    return feedId;
  }

  @Override
  public void Clear() {
    LOGGER.info("clear =>");
    trafficIncidentsService.clear();
    
    LOGGER.info("clear <=");
  }

  @Override
  public void UpdateIncidents(Integer feedId, List<String> cancelledIncidentIds,
      List<TrafficIncidentStruct> updatedIncidentStructs) {
    LOGGER.info("updateIncidents => feedId = " + feedId + ", cancelledIncidentIds = " +
      cancelledIncidentIds + ", updatedIncidentStructs = " + updatedIncidentStructs);
    EList<String> cancelledIncidentIdsEList = new BasicEList<>(cancelledIncidentIds);
    
    EList<TrafficIncident> updatedIncidents = new BasicEList<>();
    for (TrafficIncidentStruct managedTrafficIncidentStruct: updatedIncidentStructs) {
      TrafficIncident managedTrafficIncident = StructUtil.trafficIncidentStructToTrafficIncident(managedTrafficIncidentStruct);
      updatedIncidents.add(managedTrafficIncident);
    }
    LOGGER.info("Calling service feedId = " + feedId + ", cancelledIncidentIdsEList = " +
        cancelledIncidentIdsEList + ", updatedIncidents = " + updatedIncidents);
    trafficIncidentsService.updateIncidents(feedId, cancelledIncidentIdsEList, updatedIncidents);
    
    LOGGER.info("updateIncidents <=");
  }

  @Override
  public void UpdateStatus(Integer feedId, Byte feedStatusId,
      Byte incidentsStatusId) {
    LOGGER.info("updateStatus => feedId = " + feedId +
        ", feedStatusId = " + feedStatusId + ", incidentsStatusId = " + incidentsStatusId);

    TrafficIncidentFeedStatus feedStatus = TrafficIncidentFeedStatus.get(feedStatusId);
    TrafficIncidentsStatus incidentsStatus = TrafficIncidentsStatus.get(incidentsStatusId);
    
    trafficIncidentsService.updateStatus(feedId, feedStatus, incidentsStatus);
    LOGGER.info("updateStatus <=");
  }

  private void sendLanguageChangedSignal(String languageCode, String countryCode) {
    LOGGER.info("going to send LanguageChanged signal");
    
    try {
      conn.sendSignal(new TrafficIncidentFeedDBus.LanguageChanged("/trafficincidentfeed", languageCode, countryCode));
    } catch (DBusException e) {
      e.printStackTrace();
    }
  }

  public class PendingReply {
    private boolean replyReceived = false;
    private TrafficIncidentFeedListener listener;
    
    public PendingReply(TrafficIncidentFeedListener listener) {
      this.listener = listener;
    }

    public boolean isReplyReceived() {
      return replyReceived;
    }

    public void setReplyReceived(boolean replyReceived) {
      this.replyReceived = replyReceived;
    }

    public TrafficIncidentFeedListener getListener() {
      return listener;
    }
  }
  
  class PendingReplyGetVersion extends PendingReply {
    private Version version;
    
    public PendingReplyGetVersion(TrafficIncidentFeedListener listener) {
      super(listener);
    }

    public Version getVersion() {
      return version;
    }

    public void setVersion(Version version) {
      this.version = version;
    }
  }
  
  class PendingReplyGetLanguage extends PendingReply {
    private String languageCode;
    private String countryCode;

    public PendingReplyGetLanguage(TrafficIncidentFeedListener listener) {
      super(listener);
    }

    public String getLanguageCode() {
      return languageCode;
    }

    public void setLanguageCode(String languageCode) {
      this.languageCode = languageCode;
    }

    public String getCountryCode() {
      return countryCode;
    }

    public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
    }
  }
  
  class PendingReplyRegisterFeed extends PendingReply {
    private Integer feedId;
    
    public PendingReplyRegisterFeed(TrafficIncidentFeedListener listener) {
      super(listener);
    }

    public Integer getFeedId() {
      return feedId;
    }

    public void setFeedId(Integer feedId) {
      this.feedId = feedId;
    }
  }
}
