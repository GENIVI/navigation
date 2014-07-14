/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.freedesktop.dbus.CallbackHandler;
import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.DBusSigHandler;
import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.exceptions.DBusExecutionException;
import org.genivi.common.Version;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentFeed;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedListener;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.TrafficIncidentStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.TrafficIncidentFeedDBus;
import org.genivi.trafficincidentsservice.trafficincidentfeed.dbus.VersionStruct;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TwoTuple;

public class TrafficIncidentFeedDBusProxy extends EObjectImpl implements TrafficIncidentFeed {
  private final static Logger LOGGER = Logger.getLogger(TrafficIncidentFeedDBusProxy.class.getName());
  
  private DBusConnection conn;
  private TrafficIncidentFeedDBus trafficIncidentFeedDBus;
  
  private Map<CallbackHandler<?>, TrafficIncidentFeedListener> callsInProgress = new HashMap<>();
  private List<TrafficIncidentFeedListener> languageChangedListeners = new ArrayList<>();

  public TrafficIncidentFeedDBusProxy(DBusConnection conn, TrafficIncidentFeedDBus trafficIncidentFeedDBus) {
    super();
    this.conn = conn;
    this.trafficIncidentFeedDBus = trafficIncidentFeedDBus;
    LOGGER.setLevel(Level.SEVERE);
    
    try {
      conn.addSigHandler(TrafficIncidentFeedDBus.LanguageChanged.class, new LanguageChangedSignalHandler());
    } catch (DBusException e) {
      LOGGER.severe("Failed to install signal handler for LanguageChanged");
      e.printStackTrace();
    }
  }

  @Override
  public void getVersion(TrafficIncidentFeedListener listener) {
    LOGGER.info("getVersion => listener = " + listener);
    
    CallbackHandler<VersionStruct> callbackHandler = new CallbackHandler<VersionStruct>() {
      @Override
      public void handle(VersionStruct versionStruct) {
        LOGGER.info("getVersion:handle => versionStruct " + versionStruct);
        TrafficIncidentFeedListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
        
        Version version = StructUtil.versionStructToVersion(versionStruct);
        
        LOGGER.info("version = " + version);
        
        listener.getVersionReply(version);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    conn.callWithCallback(trafficIncidentFeedDBus, "GetVersion", callbackHandler);
    
    LOGGER.info("getVersion <=");
  }

  @Override
  public void getLanguage(TrafficIncidentFeedListener listener) {
    LOGGER.info("getLanguage => listener = " + listener);
    
    CallbackHandler<TwoTuple<String, String>> callbackHandler = new CallbackHandler<TwoTuple<String, String>>() {
      @Override
      public void handle(TwoTuple<String, String> languageTuple) {
        LOGGER.info("getLanguage:handle => languageTuple = " + languageTuple);
        TrafficIncidentFeedListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
             
        String languageCode = languageTuple.a;
        String countryCode = languageTuple.b;
        if (countryCode.isEmpty()) {
          countryCode = null;
        }
        LOGGER.info("languageCode = " + languageCode + ", countryCode = " + countryCode);
        
        listener.getLanguageReply(languageCode, countryCode);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    conn.callWithCallback(trafficIncidentFeedDBus, "GetLanguage", callbackHandler);
    
    LOGGER.info("getLanguage <=");
  }

  @Override
  public void addLanguageListener(
      TrafficIncidentFeedListener listener, TrafficIncidentFeedListener languageChangedListener) {
    LOGGER.info("addLanguageListener => listener = " + listener + ", languageChangedListener = " + languageChangedListener);
    
    languageChangedListeners.add(languageChangedListener);
    
    if (languageChangedListeners.size() == 1) {
      // First listener added, so notify the TrafficIncidentsService that we are listening.
      if (listener != null) {
        CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
          @Override
          public void handle(Integer dummyReturnValue) {
            LOGGER.info("addLanguageListener:handle => dummyReturnValue = " + dummyReturnValue);
            TrafficIncidentFeedListener listener = callsInProgress.remove(this);
            if (listener == null) {
              throw new RuntimeException("No entry for callbackHandler found");
            }

            listener.addLanguageListenerReply();
          }

          @Override
          public void handleError(DBusExecutionException e) {
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
          }

        };

        callsInProgress.put(callbackHandler, listener);
        conn.callWithCallback(trafficIncidentFeedDBus, "AddLanguageListener", callbackHandler);
      } else {
        conn.callMethodAsync(trafficIncidentFeedDBus, "AddLanguageListener");
      }    
    } else {
      if (listener != null) {
        listener.addLanguageListenerReply();
      }
    }
    
    LOGGER.info("addLanguageListener <=");
  }

  @Override
  public void removeLanguageListener(TrafficIncidentFeedListener listener, TrafficIncidentFeedListener languageChangedListener) {
    LOGGER.info("removeLanguageListener => listener = " + listener + ", languageChangedListener = " + languageChangedListener);
    
    languageChangedListeners.remove(languageChangedListener);
    
    if (languageChangedListeners.isEmpty()) {
      // Last listener removed, so notify the TrafficIncidentsService that we are no longer listening.
      if (listener != null) {
        CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
          @Override
          public void handle(Integer dummyReturnValue) {
            LOGGER.info("removeLanguageListener:handle => dummyReturnValue = " + dummyReturnValue);
            TrafficIncidentFeedListener listener = callsInProgress.remove(this);
            if (listener == null) {
              throw new RuntimeException("No entry for callbackHandler found");
            }

            listener.removeLanguageListenerReply();
          }

          @Override
          public void handleError(DBusExecutionException e) {
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
          }

        };

        callsInProgress.put(callbackHandler, listener);
        conn.callWithCallback(trafficIncidentFeedDBus, "RemoveLanguageListener", callbackHandler);
      } else {
        conn.callMethodAsync(trafficIncidentFeedDBus, "RemoveLanguageListener");
      }    
    } else {
      if (listener != null) {
        listener.removeLanguageListenerReply();
      }
    }
        
    LOGGER.fine("removeLanguageListener <=");
  }

  @Override
  public void clear() {
    LOGGER.info("clear =>");
    
    conn.callMethodAsync(trafficIncidentFeedDBus, "Clear");
    
    LOGGER.info("clear <=");
  }

  @Override
  public void updateIncidents(int feedId, EList<String> cancelledIncidentIds,
      EList<TrafficIncident> updatedIncidents) {
    LOGGER.info("updateIncidents => feedId = " + feedId + ", cancelledIncidentIds = " + cancelledIncidentIds + ", updatedIncidents = " + updatedIncidents);
    
    UInt32 feedIdUInt32 = new UInt32(feedId);
    List<TrafficIncidentStruct> updatedIncidentStructs = new ArrayList<>();
    for (TrafficIncident managedTrafficIncident: updatedIncidents) {
      TrafficIncidentStruct managedTrafficIncidentStruct = StructUtil.trafficIncidentToTrafficIncidentStruct(managedTrafficIncident);
      updatedIncidentStructs.add(managedTrafficIncidentStruct);
      LOGGER.info("updateIncidents, added incident = " + managedTrafficIncidentStruct);
    }
    conn.callMethodAsync(trafficIncidentFeedDBus, "UpdateIncidents", feedIdUInt32, cancelledIncidentIds,
        updatedIncidentStructs);
    
    LOGGER.info("updateIncidents <=");
  }

  @Override
  public void updateStatus(int feedId, TrafficIncidentFeedStatus feedStatus,
      TrafficIncidentsStatus incidentsStatus) {
    LOGGER.info("updateStatus => feedId = " + feedId + ", feedStatus = " + feedStatus + ", incidentsStatus = " + incidentsStatus);
    
    UInt32 feedIdUInt32 = new UInt32(feedId);
    Integer feedStatusValue = feedStatus.getValue();
    Integer incidentsStatusValue = incidentsStatus.getValue();
    conn.callMethodAsync(trafficIncidentFeedDBus, "UpdateStatus", feedIdUInt32, feedStatusValue,
        incidentsStatusValue);
    
    LOGGER.info("updateStatus <=");
  }

  @Override
  public void registerFeed(TrafficIncidentFeedListener listener,
      String dataProviderName, String protocolName,
      String communicationChannelName) {
    LOGGER.info("registerFeed => listener = " + listener + ", dataProviderName = " + dataProviderName +
        ", protocolName = " + protocolName +
        ", communicationChannelName = " + communicationChannelName);
    
    CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
      @Override
      public void handle(Integer feedId) {
        LOGGER.info("registerFeed:handle => feedId " + feedId);
        TrafficIncidentFeedListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
                
        listener.registerFeedReply(feedId);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    
    conn.callWithCallback(trafficIncidentFeedDBus, "RegisterFeed", callbackHandler, dataProviderName, protocolName,
        communicationChannelName);
    
    LOGGER.info("registerFeed <=");
  }
  
  
  class LanguageChangedSignalHandler implements DBusSigHandler<TrafficIncidentFeedDBus.LanguageChanged> {
    public void handle(TrafficIncidentFeedDBus.LanguageChanged languageChanged) {
      LOGGER.info("LanguageChangedSignalHandler => path = " + languageChanged.getPath());
      
      String languageCode = null;
      if (!languageChanged.languageCode.isEmpty()) {
        languageCode = languageChanged.languageCode;
      }
      
      String countryCode = null;
      if (!languageChanged.countryCode.isEmpty()) {
        countryCode = languageChanged.countryCode;
      }
            
      if (languageChangedListeners.isEmpty()) {
        LOGGER.info("No listener registered");
      } else {
        for (TrafficIncidentFeedListener listener: languageChangedListeners) {
          LOGGER.info("Calling getLanguageReply: languageCode = " + languageCode + ", countryCode = " + countryCode);
          listener.getLanguageReply(languageCode, countryCode);        
        }
      }
    }
  }
}
