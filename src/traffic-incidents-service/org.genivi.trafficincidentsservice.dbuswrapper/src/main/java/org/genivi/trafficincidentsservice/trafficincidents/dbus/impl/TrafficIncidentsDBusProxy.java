/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.dbus.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.freedesktop.DBus.Introspectable;
import org.freedesktop.dbus.CallbackHandler;
import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.DBusSigHandler;
import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.exceptions.DBusExecutionException;
import org.genivi.common.RectangularArea;
import org.genivi.common.Version;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.FeedInformation;
import org.genivi.trafficincidentsservice.LengthUnit;
import org.genivi.trafficincidentsservice.TextDetailLevel;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentField;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.WeightUnit;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.CategoryDefinitionStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.FeedInformationStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.IconDefinitionStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.IconInfoStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.IconSetStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.RectangularAreaStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TrafficIncidentStruct;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TrafficIncidentsDBus;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.TwoTuple;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.VersionStruct;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;

/**
 * All method have a listener as first parameter.
 * For methods where this parameter cannot be null (always a reply):
 * A CallBackHandler is created and the remote method is called with 'callWithCallback'.
 * 
 * For methods where this parameter can be null (fire and forget if null):
 * If the listener is null, 'callMethodAsync' is called.
 * If the listener is not null, same handling as when the parameter cannot be null.
 *
 *
 * A CallBackHandler needs a type, even if there are no output parameters. In this case
 * always the type Integer is used, and the parameter of the 'handle' method is called dummyReturnValue.
 */
public class TrafficIncidentsDBusProxy extends EObjectImpl implements TrafficIncidents {
  private final static Logger LOGGER = Logger.getLogger(TrafficIncidentsDBusProxy.class.getName());
  
  private DBusConnection conn;
  private TrafficIncidentsDBus trafficIncidentsDBus;
  
  private Map<CallbackHandler<?>, TrafficIncidentsListener> callsInProgress = new HashMap<>();
  private Map<Integer, TrafficIncidentsListener> updatesListeners = new HashMap<>();
  private Map<Integer, TrafficIncidentsListener> updatesInAreasListeners = new HashMap<>();
  private List<TrafficIncidentsListener> trafficIncidentsStatusListeners = new ArrayList<>();
  private List<TrafficIncidentsListener> feedInformationListeners = new ArrayList<>();

  private int firstListenerId;

  public TrafficIncidentsDBusProxy(
      String trafficIncidentsInterfaceName,
      String trafficIncidentsObjectPath) throws DBusException {
    super();
    
    LOGGER.setLevel(Level.SEVERE);
    
    Date date = new Date();
    long time = date.getTime();
    firstListenerId = (int) (time % 100);
    LOGGER.info("TrafficIncidentsDBusProxy: firstListenerId = " + firstListenerId);
    
    conn = DBusConnection.getConnection(DBusConnection.SESSION);
    
    // Show the D-Bus xml interface definition
    Introspectable introSpectable = (Introspectable) conn.getRemoteObject(trafficIncidentsInterfaceName, trafficIncidentsObjectPath, Introspectable.class);
    boolean introspectOk = false;
    while (!introspectOk) {
      LOGGER.fine("Waiting for service to become available ...");
      try {
        String data = introSpectable.Introspect();
        LOGGER.severe("Connected to interface with following specification:");
        LOGGER.severe(data);
        introspectOk = true;
      } catch (Exception e) {
        LOGGER.info(e.getMessage());
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
    
    trafficIncidentsDBus = (TrafficIncidentsDBus) conn.getRemoteObject(trafficIncidentsInterfaceName, trafficIncidentsObjectPath, TrafficIncidentsDBus.class);
    LOGGER.fine("TrafficIncidentsDBus obtained");
    
    try {
      conn.addSigHandlerWithoutMatch(TrafficIncidentsDBus.Updates.class, new UpdatesSignalHandler());
      conn.addSigHandlerWithoutMatch(TrafficIncidentsDBus.UpdatesInAreas.class, new UpdatesInAreasSignalHandler());
      conn.addSigHandler(TrafficIncidentsDBus.TrafficIncidentsStatus.class, new TrafficIncidentsStatusSignalHandler());
      conn.addSigHandler(TrafficIncidentsDBus.FeedInformation.class, new FeedInformationSignalHandler());
    } catch (DBusException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void getVersion(TrafficIncidentsListener listener) {
    LOGGER.fine("getVersion => listener = " + listener);
    
    CallbackHandler<VersionStruct> callbackHandler = new CallbackHandler<VersionStruct>() {
      @Override
      public void handle(VersionStruct versionStruct) {
        LOGGER.fine("getVersion:handle => versionStruct " + versionStruct);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
        
        Version version = StructUtil.versionStructToVersion(versionStruct);
        
        LOGGER.fine("version = " + version);
        
        listener.getVersionReply(version);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    conn.callWithCallback(trafficIncidentsDBus, "GetVersion", callbackHandler);
    
    LOGGER.fine("getVersion <=");
  }

  @Override
  public void getLanguage(TrafficIncidentsListener listener) {
    LOGGER.fine("getLanguage => listener = " + listener);
    
    CallbackHandler<TwoTuple<String, String>> callbackHandler = new CallbackHandler<TwoTuple<String, String>>() {
      @Override
      public void handle(TwoTuple<String, String> languageTuple) {
        LOGGER.fine("getLanguage:handle => languageTuple = " + languageTuple);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
             
        String languageCode = languageTuple.a;
        String countryCode = languageTuple.b;
        if (countryCode.isEmpty()) {
          countryCode = null;
        }
        LOGGER.fine("languageCode = " + languageCode + ", countryCode = " + countryCode);
        
        listener.getLanguageReply(languageCode, countryCode);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    conn.callWithCallback(trafficIncidentsDBus, "GetLanguage", callbackHandler);
    
    LOGGER.fine("getLanguage <=");
  }

  @Override
  public void setLanguage(TrafficIncidentsListener listener, String languageCode, String countryCode) {
    LOGGER.info("setLanguage => languageCode = " + languageCode + ", countryCode = " + countryCode);

    if (languageCode == null) {
      languageCode = "";
    }

    if (countryCode == null) {
      countryCode = "";
    }

    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("setLanguage:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.setLanguageReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "SetLanguage", callbackHandler, languageCode, countryCode);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "SetLanguage", languageCode, countryCode);
    }

    LOGGER.fine("setLanguage <=");
  }

  @Override
  public void setTimeFormat(TrafficIncidentsListener listener, String timeFormat) {
    LOGGER.fine("setTimeFormat => timeFormat = " + timeFormat);

    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("setTimeFormat:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.setTimeFormatReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "SetTimeFormat", callbackHandler, timeFormat);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "SetTimeFormat", timeFormat);
    }
    
    LOGGER.fine("setTimeFormat <=");
  }

  @Override
  public void setDateFormat(TrafficIncidentsListener listener, String dateFormat) {
    LOGGER.fine("setDateFormat => + dateFormat = " + dateFormat);
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("setDateFormat:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.setDateFormatReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "SetDateFormat", callbackHandler, dateFormat);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "SetDateFormat", dateFormat);
    }
    
    LOGGER.fine("setDateFormat <=");
  }

  @Override
  public void setLengthUnit(TrafficIncidentsListener listener, LengthUnit lengthUnit) {
    LOGGER.fine("setLengthUnit => lengthUnit = " + lengthUnit);
    
    Byte lengthUnitId = (byte) lengthUnit.getValue();
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("setLengthUnit:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.setLengthUnitReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "SetLengthUnit", callbackHandler, lengthUnitId);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "SetLengthUnit", lengthUnitId);
    }
    
    LOGGER.fine("setLengthUnit <=");
  }

  @Override
  public void setWeightUnit(TrafficIncidentsListener listener, WeightUnit weightUnit) {
    LOGGER.fine("setWeightUnit => weightUnit = " + weightUnit);
    
    Byte weightUnitId = (byte) weightUnit.getValue();
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("setWeightUnit:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.setWeightUnitReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "SetWeightUnit", callbackHandler, weightUnitId);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "SetWeightUnit", weightUnitId);
    }
    
    LOGGER.fine("setWeightUnit <=");
  }

  @Override
  public void getApplicability(TrafficIncidentsListener listener) {
    LOGGER.fine("getApplicability => listener = " + listener);
    
    CallbackHandler<String> callbackHandler = new CallbackHandler<String>() {
      @Override
      public void handle(String filterExpression) {
        LOGGER.fine("getApplicability:handle => filterExpression = " + filterExpression);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
        
        listener.getApplicabilityReply(filterExpression);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    conn.callWithCallback(trafficIncidentsDBus, "GetApplicability", callbackHandler);
    
    LOGGER.fine("getApplicability <=");
  }

  @Override
  public void setApplicability(TrafficIncidentsListener listener, String filterExpression) {
    LOGGER.fine("setApplicability => filterExpression = " + filterExpression);
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("setApplicability:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.setApplicabilityReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "SetApplicability", callbackHandler, filterExpression);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "SetApplicability", filterExpression);
    }    
    
    LOGGER.fine("setApplicability <=");
  }

  @Override
  public void reserveIconSetIds(TrafficIncidentsListener listener, int numberOfIds) {
    LOGGER.fine("reserveIconSetIds => listener = " + listener + ", numberOfIds = " + numberOfIds);
    
    CallbackHandler<List<Integer>> callbackHandler = new CallbackHandler<List<Integer>>() {
      @Override
      public void handle(List<Integer> iconSetIds) {
        LOGGER.fine("reserveIconSetIds:handle => iconSetIds = " + iconSetIds);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
                
        EList<Integer> eListIconSetIds = new BasicEList<>(iconSetIds);
        listener.reserveIconSetIdsReply(eListIconSetIds);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    conn.callWithCallback(trafficIncidentsDBus, "ReserveIconSetIds", callbackHandler, (Integer) numberOfIds);
    
    LOGGER.fine("reserveIconSetIds <=");
  }

  @Override
  public void freeIconSetIds(TrafficIncidentsListener listener, EList<Integer> iconSetIds) {
    LOGGER.fine("freeIconSetIds => iconSetIds = " + iconSetIds);
    
    List<Integer> listIconSetIds = new ArrayList<>(iconSetIds);
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("freeIconSetIds:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.freeIconSetIdsReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "FreeIconSetIds", callbackHandler, listIconSetIds);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "FreeIconSetIds", listIconSetIds);
    }    
    
    LOGGER.fine("freeIconSetIds <=");
  }

  @Override
  public void getIconSets(TrafficIncidentsListener listener) {
    LOGGER.fine("getIconSets => listener = " + listener);
    
    CallbackHandler<List<IconSetStruct>> callbackHandler = new CallbackHandler<List<IconSetStruct>>() {
      @Override
      public void handle(List<IconSetStruct> iconSetStructs) {
        LOGGER.fine("getIconSets:handle => iconSetStructs = " + iconSetStructs);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
                
        
        EList<IconSet> iconSets = new BasicEList<>();
        for (IconSetStruct iconSetStruct: iconSetStructs) {
          IconSet iconSet = StructUtil.iconSetStructToIconSet(iconSetStruct);
          iconSets.add(iconSet);
        }
        LOGGER.fine("iconSets => " + iconSets);
        listener.getIconSetsReply(iconSets);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    conn.callWithCallback(trafficIncidentsDBus, "GetIconSets", callbackHandler);
    
    LOGGER.fine("getIconSets <=");
  }

  @Override
  public void addIconSetDefinitions(TrafficIncidentsListener listener, EList<IconSet> iconSets) {
    LOGGER.fine("addIconSetDefinitions => iconSets = " + iconSets);
    
    List<IconSetStruct> iconSetStructs = new ArrayList<>();
    for (IconSet iconSet: iconSets) {
      IconSetStruct iconSetStruct = StructUtil.iconSetToIconSetStruct(iconSet);
      iconSetStructs.add(iconSetStruct);
    }
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("addIconSetDefinitions:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.addIconSetDefinitionsReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "AddIconSetDefinitions", callbackHandler, iconSetStructs);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "AddIconSetDefinitions", iconSetStructs);
    }    
    
    LOGGER.fine("addIconSetDefinitions <=");
  }

  @Override
  public void removeIconSetDefinitions(TrafficIncidentsListener listener, EList<Integer> iconSetIds) {
    LOGGER.fine("removeIconSetDefinitions => iconSetIds = " + iconSetIds);
    
    List<Integer> listIconSetIds = new ArrayList<>(iconSetIds);
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("removeIconSetDefinitions:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.removeIconSetDefinitionsReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "RemoveIconSetDefinitions", callbackHandler, listIconSetIds);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "RemoveIconSetDefinitions", listIconSetIds);
    }    
    
    LOGGER.fine("removeIconSetDefinitions <=");
  }

  @Override
  public void getIconDefinitions(TrafficIncidentsListener listener, EList<IconInfo> iconInfos) {
    LOGGER.fine("getIconDefinitions => listener = " + listener + ", iconInfos" + iconInfos);
    
    CallbackHandler<List<IconDefinitionStruct>> callbackHandler = new CallbackHandler<List<IconDefinitionStruct>>() {
      @Override
      public void handle(List<IconDefinitionStruct> iconDefinitionStructs) {
        LOGGER.fine("getIconDefinitions:handle => icondefinitionStructs = " + iconDefinitionStructs);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
                
        
        EList<IconDefinition> iconDefinitions = new BasicEList<IconDefinition>();
        for (IconDefinitionStruct iconDefinitionStruct: iconDefinitionStructs) {
          IconDefinition iconDefinition = StructUtil.iconDefinitionStructToIconDefinition(iconDefinitionStruct);
          iconDefinitions.add(iconDefinition);
        }
        LOGGER.fine("iconDefinitions => " + iconDefinitions);
        listener.getIconDefinitionsReply(iconDefinitions);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    List<IconInfoStruct> iconInfoStructs = new ArrayList<>();
    for (IconInfo iconInfo: iconInfos) {
      IconInfoStruct iconInfoStruct = StructUtil.iconInfoToIconInfoStruct(iconInfo);
      LOGGER.fine("iconInfoStruct = " + iconInfoStruct.iconId + ", " + iconInfoStruct.iconSetId);
      iconInfoStructs.add(iconInfoStruct);
    }
    if (iconInfoStructs.size() == 0) {
      IconInfoStruct iconInfoStruct = new IconInfoStruct(-1, -1);
      LOGGER.fine("Added iconInfoStruct = " + iconInfoStruct.iconId + ", " + iconInfoStruct.iconSetId);
      iconInfoStructs.add(iconInfoStruct);
    }
    conn.callWithCallback(trafficIncidentsDBus, "GetIconDefinitions", callbackHandler, iconInfoStructs);
    
    LOGGER.fine("getIconDefinitions <=");
  }

  @Override
  public void addIconDefinitions(TrafficIncidentsListener listener, EList<IconDefinition> iconDefinitions) {
    
    LOGGER.fine("addIconDefinitions => iconDefinitions = " + iconDefinitions);
    
    List<IconDefinitionStruct> iconDefinitionStructs = new ArrayList<>();
    for (IconDefinition iconDefinition: iconDefinitions) {
      IconDefinitionStruct iconDefinitionStruct = StructUtil.iconDefinitionToIconDefinitionStruct(iconDefinition);
      iconDefinitionStructs.add(iconDefinitionStruct);
    }
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("addIconDefinitions:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.addIconDefinitionsReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "AddIconDefinitions", callbackHandler, iconDefinitionStructs);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "AddIconDefinitions", iconDefinitionStructs);
    }    
    
    LOGGER.fine("addIconDefinitions <=");
  }

  @Override
  public void removeIconDefinitions(TrafficIncidentsListener listener, EList<IconInfo> iconInfos) {
    LOGGER.fine("removeIconDefinitions => iconInfos = " + iconInfos);
    
    List<IconInfoStruct> iconInfoStructs = new ArrayList<>();
    for (IconInfo iconInfo: iconInfos) {
      IconInfoStruct iconInfoStruct = StructUtil.iconInfoToIconInfoStruct(iconInfo);
      iconInfoStructs.add(iconInfoStruct);
    }
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("removeIconDefinitions:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.removeIconDefinitionsReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "RemoveIconDefinitions", callbackHandler, iconInfoStructs);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "RemoveIconDefinitions", iconInfoStructs);
    }    
    
    LOGGER.fine("removeIconDefinitions <=");
  }

  @Override
  public void reserveCategoryIds(TrafficIncidentsListener listener, int numberOfIds) {
    LOGGER.fine("reserveCategoryIds => listener = " + listener + ", numberOfIds = " + numberOfIds);
    
    CallbackHandler<List<Integer>> callbackHandler = new CallbackHandler<List<Integer>>() {
      @Override
      public void handle(List<Integer> categoryIds) {
        LOGGER.fine("reserveCategoryIds:handle => categoryIds = " + categoryIds);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        } 
        
        EList<Integer> eListCategoryIds = new BasicEList<>(categoryIds);
        listener.reserveCategoryIdsReply(eListCategoryIds);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    conn.callWithCallback(trafficIncidentsDBus, "ReserveCategoryIds", callbackHandler, (Integer) numberOfIds);
    
    LOGGER.fine("reserveCategoryIds <=");
  }

  @Override
  public void freeCategoryIds(TrafficIncidentsListener listener, EList<Integer> categoryIds) {
    LOGGER.fine("freeCategoryIds => categoryIds = " + categoryIds);
    
    List<Integer> listCategoryIds = new ArrayList<>(categoryIds);
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("freeCategoryIds:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.freeCategoryIdsReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "FreeCategoryIds", callbackHandler, listCategoryIds);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "FreeCategoryIds", listCategoryIds);
    }    
    
    LOGGER.fine("freeCategoryIds <=");
  }

  @Override
  public void getCategoryDefinitions(TrafficIncidentsListener listener) {
    LOGGER.info("getCategoryDefinitions => listener = " + listener);
    
    CallbackHandler<List<CategoryDefinitionStruct>> callbackHandler = new CallbackHandler<List<CategoryDefinitionStruct>>() {
      @Override
      public void handle(List<CategoryDefinitionStruct> categoryDefinitionStructs) {
        LOGGER.info("getCategoryDefinitions:handle => categoryDefinitionStructs = " + categoryDefinitionStructs);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
                
        
        EList<CategoryDefinition> categoryDefinitions = new BasicEList<>();
        for (CategoryDefinitionStruct categoryDefinitionStruct: categoryDefinitionStructs) {
          CategoryDefinition categoryDefinition = StructUtil.categoryDefinitionStructToCategoryDefinition(categoryDefinitionStruct);
          categoryDefinitions.add(categoryDefinition);
        }
        LOGGER.info("categoryDefinitions => " + categoryDefinitions);
        listener.getCategoryDefinitionsReply(categoryDefinitions);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    conn.callWithCallback(trafficIncidentsDBus, "GetCategoryDefinitions", callbackHandler);
    
    LOGGER.info("getCategoryDefinitions <=");
  }

  @Override
  public void addCategoryDefinitions(TrafficIncidentsListener listener, EList<CategoryDefinition> categoryDefinitions) {
    LOGGER.info("addCategoryDefinitions => categoryDefinitions = " + categoryDefinitions);
    
    List<CategoryDefinitionStruct> categoryDefinitionStructs = new ArrayList<>();
    for (CategoryDefinition categoryDefinition: categoryDefinitions) {
      CategoryDefinitionStruct categoryDefinitionStruct = StructUtil.categoryDefinitionToCategoryDefinitionStruct(categoryDefinition);
      categoryDefinitionStructs.add(categoryDefinitionStruct);
    }
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("addCategoryDefinitions:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.addCategoryDefinitionsReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "AddCategoryDefinitions", callbackHandler, categoryDefinitionStructs);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "AddCategoryDefinitions", categoryDefinitionStructs);
    }    
    
    LOGGER.info("addCategoryDefinitions <=");
  }

  @Override
  public void removeCategoryDefinitions(TrafficIncidentsListener listener, EList<Integer> categoryIds) {
    LOGGER.fine("removeCategoryDefinitions => categoryIds = " + categoryIds);
    
    List<Integer> listCategoryIds = new ArrayList<>(categoryIds);
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("removeCategoryDefinitions:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.removeCategoryDefinitionsReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "RemoveCategoryDefinitions", callbackHandler, listCategoryIds);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "RemoveCategoryDefinitions", listCategoryIds);
    }    
    
    LOGGER.fine("removeCategoryDefinitions <=");
  }

  @Override
  public void getTrafficIncidentIds(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds) {
    LOGGER.fine("getTrafficIncidentIds => listener = " + listener + ", warningLevels = " + warningLevels + ", categoryIds = " + categoryIds);
    
    CallbackHandler<List<Integer>> callbackHandler = new CallbackHandler<List<Integer>>() {
      @Override
      public void handle(List<Integer> trafficIncidentIds) {
        LOGGER.fine("getTrafficIncidentIds:handle => trafficIncidentids = " + trafficIncidentIds);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
                
        EList<Integer> eListTrafficIncidentIds = new BasicEList<>(trafficIncidentIds);
        listener.getTrafficIncidentIdsReply(eListTrafficIncidentIds);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    List<Byte> warningLevelIds = new ArrayList<>();
    for (WarningLevel warningLevel: warningLevels) {
      Byte warningLevelId = (byte) warningLevel.getValue();
      warningLevelIds.add(warningLevelId);
    }
    conn.callWithCallback(trafficIncidentsDBus, "GetTrafficIncidentIds", callbackHandler, warningLevelIds, categoryIds);
    
    LOGGER.fine("getTrafficIncidentIds <=");
  }

  @Override
  public void getTrafficIncidentIdsInAreas(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds, EList<RectangularArea> areas) {
    LOGGER.fine("getTrafficIncidentIdsInAreas => listener = " + listener + ", warningLevels = " + warningLevels + ", categoryIds = " + categoryIds + ", areas = " + areas);
    
    CallbackHandler<List<Integer>> callbackHandler = new CallbackHandler<List<Integer>>() {
      @Override
      public void handle(List<Integer> trafficIncidentIds) {
        LOGGER.fine("getTrafficIncidentIdsInAreas:handle => trafficIncidentIds = " + trafficIncidentIds);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
                
        EList<Integer> eListTrafficIncidentIds = new BasicEList<>(trafficIncidentIds);
        listener.getTrafficIncidentIdsReply(eListTrafficIncidentIds);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    List<Byte> warningLevelIds = new ArrayList<>();
    for (WarningLevel warningLevel: warningLevels) {
      Byte warningLevelId = (byte) warningLevel.getValue();
      warningLevelIds.add(warningLevelId);
    }
    List<RectangularAreaStruct> rectangularAreaStructs = new ArrayList<>();
    for (RectangularArea rectangularArea: areas) {
      RectangularAreaStruct rectangularAreaStruct = StructUtil.rectangularAreaToRectangularAreaStruct(rectangularArea);
      rectangularAreaStructs.add(rectangularAreaStruct);
    }
    conn.callWithCallback(trafficIncidentsDBus, "GetTrafficIncidentIdsInAreas", callbackHandler, warningLevelIds, categoryIds, rectangularAreaStructs);
    
    LOGGER.fine("getTrafficIncidentIdsInAreas <=");
  }

  @Override
  public void getTrafficIncidents(TrafficIncidentsListener listener, EList<Integer> trafficIncidentIds, boolean includeTextFields) {
    LOGGER.info("getTrafficIncidents => listener = " + listener + ", trafficIncidentIds = " + trafficIncidentIds + ", includeTextFields = " + includeTextFields);
    
    CallbackHandler<List<TrafficIncidentStruct>> callbackHandler = new CallbackHandler<List<TrafficIncidentStruct>>() {
      @Override
      public void handle(List<TrafficIncidentStruct> trafficIncidentStructs) {
        LOGGER.info("getTrafficIncidents:handle => trafficIncidentStructs = " + trafficIncidentStructs);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
                
        
        EList<TrafficIncident> trafficIncidents = new BasicEList<>();
        for (TrafficIncidentStruct trafficIncidentStruct: trafficIncidentStructs) {
          TrafficIncident trafficIncident = StructUtil.trafficIncidentStructToTrafficIncident(trafficIncidentStruct);
          trafficIncidents.add(trafficIncident);
        }
        LOGGER.info("trafficIncidents = " + trafficIncidents);
        listener.getTrafficIncidentsReply(trafficIncidents);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    conn.callWithCallback(trafficIncidentsDBus, "GetTrafficIncidents", callbackHandler, trafficIncidentIds, includeTextFields);
    
    LOGGER.info("getTrafficIncidents <=");
  }

  @Override
  public void getTrafficIncidentsFields(TrafficIncidentsListener listener, EList<Integer> trafficIncidentIds, EList<TrafficIncidentField> trafficIncidentFields) {
    LOGGER.fine("getTrafficIncidentsFields => listener = " + listener + ", trafficIncidentIds = " + trafficIncidentIds + ", trafficIncidentFields = " + trafficIncidentFields);
    
    CallbackHandler<List<TrafficIncidentStruct>> callbackHandler = new CallbackHandler<List<TrafficIncidentStruct>>() {
      @Override
      public void handle(List<TrafficIncidentStruct> trafficIncidentStructs) {
        LOGGER.fine("getTrafficIncidentsFields:handle => trafficIncidentStructs = " + trafficIncidentStructs);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
                
        
        EList<TrafficIncident> trafficIncidents = new BasicEList<>();
        for (TrafficIncidentStruct trafficIncidentStruct: trafficIncidentStructs) {
          TrafficIncident trafficIncident = StructUtil.trafficIncidentStructToTrafficIncident(trafficIncidentStruct);
          trafficIncidents.add(trafficIncident);
        }
        LOGGER.fine("trafficIncidents = " + trafficIncidents);
        listener.getTrafficIncidentsReply(trafficIncidents);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    List<Byte> trafficIncidentFieldIds = new ArrayList<>();
    for (TrafficIncidentField trafficIncidentField: trafficIncidentFields) {
      Byte trafficIncidentFieldId = (Byte) (byte) trafficIncidentField.getValue();
      trafficIncidentFieldIds.add(trafficIncidentFieldId);
    }
    LOGGER.info("trafficIncidentFieldIds = " + trafficIncidentFieldIds);
    conn.callWithCallback(trafficIncidentsDBus, "GetTrafficIncidentsFields", callbackHandler, trafficIncidentIds, trafficIncidentFieldIds);
    
    LOGGER.fine("getTrafficIncidentsFields <=");
  }

  @Override
  public void getTexts(TrafficIncidentsListener listener, EList<Integer> trafficIncidentIds, TextDetailLevel textDetailLevel) {
    LOGGER.fine("getTexts => listener = " + listener + ", trafficIncidentIds = " + trafficIncidentIds + ", textDetailLevel = " + textDetailLevel);
    
    CallbackHandler<List<String>> callbackHandler = new CallbackHandler<List<String>>() {
      @Override
      public void handle(List<String> texts) {
        LOGGER.fine("getTexts:handle => texts = " + texts);
        TrafficIncidentsListener listener = callsInProgress.remove(this);
        if (listener == null) {
          throw new RuntimeException("No entry for callbackHandler found");
        }
                
        EList<String> eListTexts = new BasicEList<>(texts);
        listener.getTextsReply(eListTexts);
      }

      @Override
      public void handleError(DBusExecutionException e) {
        LOGGER.severe(e.getMessage());
        e.printStackTrace();
      }
      
    };
    
    callsInProgress.put(callbackHandler, listener);
    Integer textDetailLevelId = textDetailLevel.getValue();
    conn.callWithCallback(trafficIncidentsDBus, "GetTexts", callbackHandler, trafficIncidentIds, textDetailLevelId);
    
    LOGGER.fine("getTexts <=");
  }

  @Override
  public void addTrafficIncidentsStatusListener(TrafficIncidentsListener listener, TrafficIncidentsListener trafficIncidentsStatusListener) {
    LOGGER.fine("addTrafficIncidentsStatusListener => listener = " + listener + ", trafficIncidentsStatusListener = " + trafficIncidentsStatusListener);
    
    trafficIncidentsStatusListeners.add(trafficIncidentsStatusListener);
    
    if (trafficIncidentsStatusListeners.size() == 1) {
      // First listener added, so notify the TrafficIncidentsService that we are listening.
      if (listener != null) {
        CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
          @Override
          public void handle(Integer dummyReturnValue) {
            LOGGER.info("addTrafficIncidentsStatusListener:handle => dummyReturnValue = " + dummyReturnValue);
            TrafficIncidentsListener listener = callsInProgress.remove(this);
            if (listener == null) {
              throw new RuntimeException("No entry for callbackHandler found");
            }

            listener.addTrafficIncidentsStatusListenerReply();
          }

          @Override
          public void handleError(DBusExecutionException e) {
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
          }

        };

        callsInProgress.put(callbackHandler, listener);
        conn.callWithCallback(trafficIncidentsDBus, "AddTrafficIncidentsStatusListener", callbackHandler);
      } else {
        conn.callMethodAsync(trafficIncidentsDBus, "AddTrafficIncidentsStatusListener");
      }    
    } else {
      if (listener != null) {
        listener.addTrafficIncidentsStatusListenerReply();
      }
    }
        
    LOGGER.fine("addTrafficIncidentsStatusListener <=");
  }

  @Override
  public void removeTrafficIncidentsStatusListener(TrafficIncidentsListener listener, TrafficIncidentsListener trafficIncidentsStatusListener) {
    LOGGER.fine("removeTrafficIncidentsStatusListener => listener = " + listener + ", trafficIncidentsStatusListener = " + trafficIncidentsStatusListener);
    
    trafficIncidentsStatusListeners.remove(trafficIncidentsStatusListener);
    
    if (trafficIncidentsStatusListeners.isEmpty()) {
      // Last listener removed, so notify the TrafficIncidentsService that we are no longer listening.
      if (listener != null) {
        CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
          @Override
          public void handle(Integer dummyReturnValue) {
            LOGGER.info("removeTrafficIncidentsStatusListener:handle => dummyReturnValue = " + dummyReturnValue);
            TrafficIncidentsListener listener = callsInProgress.remove(this);
            if (listener == null) {
              throw new RuntimeException("No entry for callbackHandler found");
            }

            listener.removeTrafficIncidentsStatusListenerReply();
          }

          @Override
          public void handleError(DBusExecutionException e) {
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
          }

        };

        callsInProgress.put(callbackHandler, listener);
        conn.callWithCallback(trafficIncidentsDBus, "RemoveTrafficIncidentsStatusListener", callbackHandler);
      } else {
        conn.callMethodAsync(trafficIncidentsDBus, "RemoveTrafficIncidentsStatusListener");
      }    
    } else {
      if (listener != null) {
        listener.removeTrafficIncidentsStatusListenerReply();
      }
    }
        
    LOGGER.fine("removeTrafficIncidentsStatusListener <=");
  }

  @Override
  public void addFeedInformationListener(TrafficIncidentsListener listener, TrafficIncidentsListener feedInformationListener) {
    LOGGER.fine("addFeedInformationListener => listener = " + listener + ", feedInformationListener = " + feedInformationListener);
    
    feedInformationListeners.add(feedInformationListener);
    
    if (feedInformationListeners.size() == 1) {
      // First listener added, so notify the TrafficIncidentsService that we are listening.
      if (listener != null) {
        CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
          @Override
          public void handle(Integer dummyReturnValue) {
            LOGGER.info("addFeedInformationListener:handle => dummyReturnValue = " + dummyReturnValue);
            TrafficIncidentsListener listener = callsInProgress.remove(this);
            if (listener == null) {
              throw new RuntimeException("No entry for callbackHandler found");
            }

            listener.addFeedInformationListenerReply();
          }

          @Override
          public void handleError(DBusExecutionException e) {
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
          }

        };

        callsInProgress.put(callbackHandler, listener);
        conn.callWithCallback(trafficIncidentsDBus, "AddFeedInformationListener", callbackHandler);
      } else {
        conn.callMethodAsync(trafficIncidentsDBus, "AddFeedInformationListener");
      }    
    } else {
      if (listener != null) {
        listener.addFeedInformationListenerReply();
      }
    }
    
    LOGGER.fine("addFeedInformationListener <=");
  }

  @Override
  public void removeFeedInformationListener(TrafficIncidentsListener listener, TrafficIncidentsListener feedInformationListener) {
    LOGGER.fine("removeFeedInformationListener => listener = " + listener + ", feedInformationListener = " + feedInformationListener);
    
    feedInformationListeners.remove(feedInformationListener);
    
    if (feedInformationListeners.isEmpty()) {
      // Last listener removed, so notify the TrafficIncidentsService that we are no longer listening.
      if (listener != null) {
        CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
          @Override
          public void handle(Integer dummyReturnValue) {
            LOGGER.info("removeFeedInformationListener:handle => dummyReturnValue = " + dummyReturnValue);
            TrafficIncidentsListener listener = callsInProgress.remove(this);
            if (listener == null) {
              throw new RuntimeException("No entry for callbackHandler found");
            }

            listener.removeFeedInformationListenerReply();
          }

          @Override
          public void handleError(DBusExecutionException e) {
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
          }

        };

        callsInProgress.put(callbackHandler, listener);
        conn.callWithCallback(trafficIncidentsDBus, "RemoveFeedInformationListener", callbackHandler);
      } else {
        conn.callMethodAsync(trafficIncidentsDBus, "RemoveFeedInformationListener");
      }    
    } else {
      if (listener != null) {
        listener.removeFeedInformationListenerReply();
      }
    }
        
    LOGGER.fine("removeFeedInformationListener <=");
  }

  @Override
  public void addUpdateListener(TrafficIncidentsListener listener, EList<WarningLevel> warningLevels, EList<Integer> categoryIds,
      TrafficIncidentsListener updatesListener) {
    LOGGER.info("addUpdateListener => listener = " + listener + ", warningLevels = " + warningLevels + ", categoryIds = " + categoryIds + 
        ", updatesListener = " + updatesListener);
    
    if(updatesListeners.containsValue(updatesListener)) {
      throw new IllegalArgumentException("Listener already exists");
    }
    
    Integer listenerId = generateListenerId(updatesListeners);
    LOGGER.info("addUpdateListener: listenerId = " + listenerId);
    updatesListeners.put(listenerId, updatesListener);
    
    List<Byte> warningLevelIds = new ArrayList<>();
    for (WarningLevel warningLevel: warningLevels) {
      Byte warningLevelId = (Byte) (byte) warningLevel.getValue();
      warningLevelIds.add(warningLevelId);
    }
   
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("addUpdateListener:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.addUpdateListenerReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      LOGGER.info("Going to send addUpdateListener D-Bus request (with Callback)");
      conn.callWithCallback(trafficIncidentsDBus, "AddUpdateListener", callbackHandler, listenerId, warningLevelIds, categoryIds);
    } else {
      LOGGER.info("Going to send addUpdateListener D-Bus request (fire and forget)");
      conn.callMethodAsync(trafficIncidentsDBus, "AddUpdateListener", listenerId, warningLevelIds, categoryIds);
    }    
    
    LOGGER.info("addUpdateListener <=");
  }

  @Override
  public void removeUpdateListener(TrafficIncidentsListener listener, TrafficIncidentsListener updatesListener) {
    LOGGER.fine("removeUpdateListener => listener = " + listener + ", updatesListener = " + updatesListener);
    
    Integer listenerId = null;
    for (Integer key: updatesListeners.keySet()) {
      if (updatesListeners.get(key).equals(updatesListener)) {
        listenerId = key;
        break;
      }
    }
    
    if (listenerId == null) {
      throw new IllegalArgumentException("Unknown updatesListener");
    }
    
    updatesListeners.remove(listenerId);
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("removeUpdateListener:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.removeUpdateListenerReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "RemoveUpdateListener", callbackHandler, listenerId);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "RemoveUpdateListener", listenerId);
    }    
    
    LOGGER.fine("removeUpdateListener <=");
  }

  @Override
  public void addAreasUpdateListener(TrafficIncidentsListener listener,
      EList<WarningLevel> warningLevels, EList<Integer> categoryIds, EList<RectangularArea> areas,
      TrafficIncidentsListener areasUpdateListener) {
    LOGGER.fine("addAreasUpdateListener => listener = " + listener +
        ", warningLevels = " + warningLevels + ", categoryIds = " + categoryIds +
        ", areas = " + areas + ", areasUpdateListener" + areasUpdateListener);
    
    if(updatesInAreasListeners.containsValue(areasUpdateListener)) {
      throw new IllegalArgumentException("Listener already exists");
    }
    
    Integer listenerId = generateListenerId(updatesInAreasListeners);
    updatesInAreasListeners.put(listenerId, areasUpdateListener);

    List<Byte> warningLevelIds = new ArrayList<>();
    for (WarningLevel warningLevel: warningLevels) {
      Byte warningLevelId = (Byte) (byte) warningLevel.getValue();
      warningLevelIds.add(warningLevelId);
    }
    List<RectangularAreaStruct> areaStructs = new ArrayList<>();
    for (RectangularArea rectangularArea: areas) {
      RectangularAreaStruct rectangularAreaStruct = StructUtil.rectangularAreaToRectangularAreaStruct(rectangularArea);
      areaStructs.add(rectangularAreaStruct);
    }
   
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("addAreasUpdateListener:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.addAreasUpdateListenerReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      LOGGER.info("Going to send addAreasUpdateListener D-Bus request (with Callback)");
      conn.callWithCallback(trafficIncidentsDBus, "AddAreasUpdateListener", callbackHandler, listenerId, warningLevelIds, categoryIds, areaStructs);
    } else {
      LOGGER.info("Going to send addAreasUpdateListener D-Bus request (fire and forget)");
      conn.callMethodAsync(trafficIncidentsDBus, "AddAreasUpdateListener", listenerId, warningLevelIds, categoryIds, areaStructs);
    }    
    
    LOGGER.fine("addAreasUpdateListener <=");
  }

  @Override
  public void removeAreasUpdateListener(TrafficIncidentsListener listener, TrafficIncidentsListener areasUpdateListener) {
    LOGGER.fine("removeAreasUpdateListener => listener = " + listener + ", areasUpdateListener = " + areasUpdateListener);
    
    Integer listenerId = null;
    for (Integer key: updatesInAreasListeners.keySet()) {
      if (updatesInAreasListeners.get(key).equals(areasUpdateListener)) {
        listenerId = key;
        break;
      }
    }
    
    if (listenerId == null) {
      throw new IllegalArgumentException("Unknown areasUpdateListener");
    }
    
    updatesInAreasListeners.remove(listenerId);
    
    if (listener != null) {
      CallbackHandler<Integer> callbackHandler = new CallbackHandler<Integer>() {
        @Override
        public void handle(Integer dummyReturnValue) {
          LOGGER.info("removeAreasUpdateListener:handle => dummyReturnValue = " + dummyReturnValue);
          TrafficIncidentsListener listener = callsInProgress.remove(this);
          if (listener == null) {
            throw new RuntimeException("No entry for callbackHandler found");
          }

          listener.removeAreasUpdateListenerReply();
        }

        @Override
        public void handleError(DBusExecutionException e) {
          LOGGER.severe(e.getMessage());
          e.printStackTrace();
        }

      };

      callsInProgress.put(callbackHandler, listener);
      conn.callWithCallback(trafficIncidentsDBus, "RemoveAreasUpdateListener", callbackHandler, listenerId);
    } else {
      conn.callMethodAsync(trafficIncidentsDBus, "RemoveAreasUpdateListener", listenerId);
    }    
    
    LOGGER.fine("removeAreasUpdateListener <=");
  }

  private Integer generateListenerId(Map<Integer, TrafficIncidentsListener> currentListeners) {
    Set<Integer> currentIds = currentListeners.keySet();
    
    for (int id = firstListenerId; id < Integer.MAX_VALUE; id++) {
      if (!currentIds.contains(id)) {
        return id;
      }
    }
    
    throw new RuntimeException("UpdateListenerId overflow.");
  }
  
  class TrafficIncidentsStatusSignalHandler implements DBusSigHandler<TrafficIncidentsDBus.TrafficIncidentsStatus> {
    public void handle(TrafficIncidentsDBus.TrafficIncidentsStatus status) {
      LOGGER.fine("TrafficIncidentsStatusSignalHandler => path = " + status.getPath());
      
      TrafficIncidentFeedStatus trafficIncidentFeedStatus = null;
      if (status.trafficIncidentFeedStatus != 0) {
        trafficIncidentFeedStatus = TrafficIncidentFeedStatus.get(status.trafficIncidentFeedStatus);
      }
      
      TrafficIncidentsStatus trafficIncidentsStatus = null;
      if (status.trafficIncidentsStatus != 0) {
        trafficIncidentsStatus = TrafficIncidentsStatus.get(status.trafficIncidentsStatus);
      }
      
      if (trafficIncidentsStatusListeners.isEmpty()) {
        LOGGER.info("TrafficIncidentsStatusSignalHandler: No listener registered");
      } else {
        for (TrafficIncidentsListener listener: trafficIncidentsStatusListeners) {
          listener.trafficIncidentsStatus(trafficIncidentFeedStatus, trafficIncidentsStatus);        
        }
      }
    }
  }
  
  class FeedInformationSignalHandler implements DBusSigHandler<TrafficIncidentsDBus.FeedInformation> {
    public void handle(TrafficIncidentsDBus.FeedInformation info) {
      LOGGER.fine("TrafficIncidentsStatusSignalHandler => path = " + info.getPath());
      
      EList<FeedInformation> feedsInformation = new BasicEList<>();
      List<FeedInformationStruct> feedsInformationStructs = info.feedsInformation;
      
      for (FeedInformationStruct feedInformationStruct: feedsInformationStructs) {
        FeedInformation feedInformation = StructUtil.feedInformationStructToFeedInformation(feedInformationStruct);
        feedsInformation.add(feedInformation);
      }
      
      if (feedInformationListeners.isEmpty()) {
        LOGGER.info("FeedInformationSignalHandler: No listener registered");
      } else {
        for (TrafficIncidentsListener listener: feedInformationListeners) {
          listener.feedInformation(feedsInformation);        
        }
      }
    }
  }
  
  class UpdatesSignalHandler implements DBusSigHandler<TrafficIncidentsDBus.Updates> {
    public void handle(TrafficIncidentsDBus.Updates updates) {
      LOGGER.info("UpdatesSignalHandler => path = " + updates.getPath());
      EList<Integer> unchangedTrafficIncidentIds = new BasicEList<>();
      EList<Integer> changedTrafficIncidentIds = new BasicEList<>();
      EList<Integer> newTrafficIncidentIds = new BasicEList<>();
      EList<Integer> deletedTrafficIncidentIds = new BasicEList<>();
      
      for (Integer id: updates.unchangedTrafficIncidentIds) {
        unchangedTrafficIncidentIds.add(id);
      }

      for (Integer id: updates.changedTrafficIncidentIds) {
        changedTrafficIncidentIds.add(id);
      }

      for (Integer id: updates.newTrafficIncidentIds) {
        newTrafficIncidentIds.add(id);
      }

      for (Integer id: updates.deletedTrafficIncidentIds) {
        deletedTrafficIncidentIds.add(id);
      }      
        
      int listenerId = updates.listenerId;
      LOGGER.info("UpdatesSignalHandler: listenerId = " + listenerId);
      
      TrafficIncidentsListener listener = updatesListeners.get(listenerId);
      
      if (listener != null) {
        LOGGER.info("UpdatesSignalHandler: calling updates on listener");
        listener.updates(unchangedTrafficIncidentIds, changedTrafficIncidentIds, newTrafficIncidentIds, deletedTrafficIncidentIds);        
      } else {
        LOGGER.severe("UpdatesSignalHandler: Signal received for listenerId that is not in use at this node, listenerId = " + listenerId);
      }    
      
      LOGGER.info("UpdatesSignalHandler <=");
    }
  }
  
  
  class UpdatesInAreasSignalHandler implements DBusSigHandler<TrafficIncidentsDBus.UpdatesInAreas> {
    public void handle(TrafficIncidentsDBus.UpdatesInAreas updatesInAreas) {
      LOGGER.fine("UpdatesInAreasSignalHandler => path = " + updatesInAreas.getPath());
      EList<RectangularArea> areas = new BasicEList<>();
      
      for (RectangularAreaStruct rectangularAreaStruct: updatesInAreas.areas) {
        RectangularArea rectangularArea = StructUtil.rectangularAreaStructToRectangularArea(rectangularAreaStruct);
        areas.add(rectangularArea);
      }
      
      int listenerId = updatesInAreas.listenerId;
      LOGGER.fine("listenerId = " + listenerId);
      
      TrafficIncidentsListener listener = updatesInAreasListeners.get(listenerId);
      
      if (listener != null) {
        listener.updatesInAreas(areas);        
      } else {
        LOGGER.severe("UpdatesInAreasSignalHandler: Signal received for listenerId that is not in use at this node, listenerId = " + listenerId);
      }      
    }
  }
}
