/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.dbus.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.freedesktop.dbus.AbstractConnection;
import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;
import org.genivi.common.RectangularArea;
import org.genivi.common.Version;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsListener;
import org.genivi.trafficincidentsservice.LengthUnit;
import org.genivi.trafficincidentsservice.TextDetailLevel;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentField;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.WeightUnit;
import org.genivi.trafficincidentsservice.refimpl.TrafficIncidentsService;
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

public class TrafficIncidentsAdaptor implements TrafficIncidentsDBus {
  private final static Logger LOGGER = Logger.getLogger(TrafficIncidentsAdaptor.class.getName());
  
  private DBusConnection conn;
  private TrafficIncidentsService trafficIncidentsService;
  
  private List<String> trafficIncidentsStatusListeners = new ArrayList<>();
  private TrafficIncidentsListener trafficIncidentsStatusListener;
  private List<String> feedInformationListeners = new ArrayList<>();
  private TrafficIncidentsListener feedInformationListener = null;
  private List<TrafficIncidentsListenerProxy> updatesListeners = new ArrayList<>();
  private List<TrafficIncidentsListenerProxy> updatesInAreasListeners = new ArrayList<>();
  
  private PendingReplyAddAreasUpdateListener pendingReplyAddAreasUpdateListener;
  private PendingReply pendingReplyAddCategoryDefinitions;
  private PendingReply pendingReplyAddFeedInformationListener;
  private PendingReply pendingReplyAddIconDefinitions;
  private PendingReply pendingReplyAddIconSetDefinitions;
  private PendingReply pendingReplyAddTrafficIncidentsStatusListener;
  private PendingReply pendingReplyAddUpdateListener;
  private PendingReply pendingReplyFreeCategoryIds;
  private PendingReply pendingReplyFreeIconSetIds;
  private PendingReplyGetApplicability pendingReplyGetApplicability;
  private PendingReplyGetCategoryDefinitions pendingReplyGetCategoryDefinitions;
  private PendingReplyGetIconDefinitions pendingReplyGetIconDefinitions;
  private PendingReplyGetIconSets pendingReplyGetIconSets;
  private PendingReplyGetLanguage pendingReplyGetLanguage;
  private PendingReplyGetTexts pendingReplyGetTexts;
  private PendingReplyGetTrafficIncidentIds pendingReplyGetTrafficIncidentIds;
  private PendingReplyGetTrafficIncidentIdsInAreas pendingReplyGetTrafficIncidentIdsInAreas;
  private PendingReplyGetTrafficIncidents pendingReplyGetTrafficIncidents;
  private PendingReplyGetTrafficIncidentsFields pendingReplyGetTrafficIncidentsFields;
  private PendingReplyGetVersion pendingReplyGetVersion;
  private PendingReply pendingReplyRemoveAreasUpdateListener;
  private PendingReply pendingReplyRemoveCategoryDefinitions;
  private PendingReply pendingReplyRemoveIconDefinitions;
  private PendingReply pendingReplyRemoveIconSetDefinitions;
  private PendingReply pendingReplyRemoveFeedInformationListener;
  private PendingReply pendingReplyRemoveTrafficIncidentsStatusListener;
  private PendingReply pendingReplyRemoveUpdateListener;
  private PendingReplyReserveCategoryIds pendingReplyReserveCategoryIds;
  private PendingReplyReserveIconSetIds pendingReplyReserveIconSetIds;
  private PendingReply pendingReplySetApplicability;
  private PendingReply pendingReplySetDateFormat;
  private PendingReply pendingReplySetLanguage;
  private PendingReply pendingReplySetLengthUnit;
  private PendingReply pendingReplySetTimeFormat;
  private PendingReply pendingReplySetWeightUnit;
  
  public TrafficIncidentsAdaptor(DBusConnection conn, TrafficIncidentsService trafficIncidentsService) {
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
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
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

    Version version = pendingReplyGetVersion.getVersion();
    VersionStruct versionStruct = StructUtil.versionToVersionStruct(version);
    
    LOGGER.info("getVersion <= versionStruct = " + versionStruct);
    return versionStruct;
  }

  @Override
  public TwoTuple<String, String> GetLanguage() {
    LOGGER.info("getLanguage =>");
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
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
  public void SetLanguage(String languageCode, String countryCode) {
    LOGGER.info("setLanguage => languageCode = " + languageCode + ", countryCode = " + countryCode);
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void setLanguageReply() {
        LOGGER.info("setLanguageReply =>");
        pendingReplySetLanguage.setReplyReceived(true);
      }  
    };
    pendingReplySetLanguage = new PendingReply(listener);
    
    if (languageCode.isEmpty()) {
      languageCode = null;
    }
    if (countryCode.isEmpty()) {
      countryCode = null;
    }
    
    trafficIncidentsService.setLanguage(listener, languageCode, countryCode);
    
    while (!pendingReplySetLanguage.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("setLanguage - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("setLanguage <=");
  }

  @Override
  public void SetTimeFormat(String timeFormat) {
    LOGGER.info("setTimeFormat => timeFormat = " + timeFormat);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void setTimeFormatReply() {
        LOGGER.info("setTimeFormatReply =>");
        pendingReplySetTimeFormat.setReplyReceived(true);
      }  
    };
    pendingReplySetTimeFormat = new PendingReply(listener);
    
    trafficIncidentsService.setTimeFormat(listener, timeFormat);
    
    while (!pendingReplySetTimeFormat.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("setTimeFormat - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("setTimeFormat <=");
  }

  @Override
  public void SetDateFormat(String dateFormat) {
    LOGGER.info("setDateFormat => dateFormat = " + dateFormat);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void setDateFormatReply() {
        LOGGER.info("setDateFormatReply =>");
        pendingReplySetDateFormat.setReplyReceived(true);
      }  
    };
    pendingReplySetDateFormat = new PendingReply(listener);
    
    trafficIncidentsService.setDateFormat(listener, dateFormat);
    
    while (!pendingReplySetDateFormat.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("setDateFormat - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("setDateFormat <=");
  }

  @Override
  public void SetLengthUnit(Byte lengthUnitId) {
    LOGGER.info("setLengthUnit => lengthUnitId = " + lengthUnitId);
    LengthUnit lengthUnit = LengthUnit.get(lengthUnitId);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void setLengthUnitReply() {
        LOGGER.info("setLengthUnitReply =>");
        pendingReplySetLengthUnit.setReplyReceived(true);
      }  
    };
    pendingReplySetLengthUnit = new PendingReply(listener);
    
    trafficIncidentsService.setLengthUnit(listener, lengthUnit);    
    
    while (!pendingReplySetLengthUnit.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("setLengthUnit - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("setLengthUnit <=");
  }

  @Override
  public void SetWeightUnit(Byte weightUnitId) {
    LOGGER.info("setWeightUnit => weightUnitId = " + weightUnitId);
    WeightUnit weightUnit = WeightUnit.get(weightUnitId);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void setWeightUnitReply() {
        LOGGER.info("setWeightUnitReply =>");
        pendingReplySetWeightUnit.setReplyReceived(true);
      }  
    };
    pendingReplySetWeightUnit = new PendingReply(listener);
    
    trafficIncidentsService.setWeightUnit(listener, weightUnit);
    
    while (!pendingReplySetWeightUnit.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("setWeightUnit - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("setWeightUnit <=");
  }
  
  @Override
  public String GetApplicability() {
    LOGGER.info("getApplicability =>");
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getApplicabilityReply(String filterExpression) {
        LOGGER.info("getApplicabilityReply => filterExpression = " + filterExpression);
        pendingReplyGetApplicability.setFilterExpression(filterExpression);
        pendingReplyGetApplicability.setReplyReceived(true);
      }  
    };
    pendingReplyGetApplicability = new PendingReplyGetApplicability(listener);
    
    trafficIncidentsService.getApplicability(listener);
    
    while (!pendingReplyGetApplicability.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getApplicability - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    String filterExpression = pendingReplyGetApplicability.getFilterExpression();
    LOGGER.info("getApplicability <= filterExpression = " + filterExpression);
    return filterExpression;
  }
  
  @Override
  public void SetApplicability(String expression) {    
    LOGGER.info("setApplicability => expression = " + expression);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void setApplicabilityReply() {
        LOGGER.info("setApplicabilityReply =>");
        pendingReplySetApplicability.setReplyReceived(true);
      }  
    };
    pendingReplySetApplicability = new PendingReply(listener);
    
    trafficIncidentsService.setApplicability(listener, expression);
    
    while (!pendingReplySetApplicability.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("setApplicability - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("setApplicability <=");
  }

  @Override
  public List<Integer> ReserveIconSetIds(Integer numberOfIds) {
    LOGGER.info("reserveIconSetIds => numberOfIds = " + numberOfIds);
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void reserveIconSetIdsReply(EList<Integer> iconSetIds) {
        LOGGER.info("reserveIconSetIdsReply => iconSetIds = " + iconSetIds);
        pendingReplyReserveIconSetIds.setIconSetIds(iconSetIds);
        pendingReplyReserveIconSetIds.setReplyReceived(true);
      }  
    };
    pendingReplyReserveIconSetIds = new PendingReplyReserveIconSetIds(listener);
    
    trafficIncidentsService.reserveIconSetIds(listener, numberOfIds);
    
    while (!pendingReplyReserveIconSetIds.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("reserveIconSetIds - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    List<Integer> iconSetIds = pendingReplyReserveIconSetIds.getIconSetIds();
    LOGGER.info("reserveIconSetIds <= iconSetIds = " + iconSetIds);
    return iconSetIds;
  }

  @Override
  public void FreeIconSetIds(List<Integer> iconSetIds) {
    LOGGER.info("freeIconSetIds => iconSetIds = " + iconSetIds);
    
    EList<Integer> eListIconSetIds = new BasicEList<>(iconSetIds);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void freeIconSetIdsReply() {
        LOGGER.info("freeIconSetIdsReply =>");
        pendingReplyFreeIconSetIds.setReplyReceived(true);
      }  
    };
    pendingReplyFreeIconSetIds = new PendingReply(listener);
    
    trafficIncidentsService.freeIconSetIds(listener, eListIconSetIds);
    
    while (!pendingReplyFreeIconSetIds.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("freeIconSetIds - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
   
    LOGGER.info("freeIconSetIds <=");
  }

  @Override
  public List<IconSetStruct> GetIconSets() {
    LOGGER.info("getIconSets =>");
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getIconSetsReply(EList<IconSet> iconSets) {
        LOGGER.info("getIconSetsReply => iconSets = " + iconSets);
        pendingReplyGetIconSets.setIconSets(iconSets);
        pendingReplyGetIconSets.setReplyReceived(true);
      }  
    };
    pendingReplyGetIconSets = new PendingReplyGetIconSets(listener);
    
    trafficIncidentsService.getIconSets(listener);
    
    while (!pendingReplyGetIconSets.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getIconSets - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    List<IconSetStruct> iconSetStructs = new ArrayList<>();
    for (IconSet iconSet: pendingReplyGetIconSets.getIconSets()) {
      IconSetStruct iconSetStruct = StructUtil.iconSetToIconSetStruct(iconSet);
      iconSetStructs.add(iconSetStruct);
    }
    LOGGER.info("getIconSets <= iconSetStructs = " + iconSetStructs);
    return iconSetStructs;
  }

  @Override
  public void AddIconSetDefinitions(List<IconSetStruct> iconSetStructs) {
    LOGGER.info("addIconSetDefinitions => iconSetStructs = " + iconSetStructs);
    
    EList<IconSet> iconSets = new BasicEList<>();
    for (IconSetStruct iconSetStruct: iconSetStructs) {
      IconSet iconSet = StructUtil.iconSetStructToIconSet(iconSetStruct);
      iconSets.add(iconSet);
    }
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void addIconSetDefinitionsReply() {
        LOGGER.info("addIconSetDefinitionsReply =>");
        pendingReplyAddIconSetDefinitions.setReplyReceived(true);
      }  
    };
    pendingReplyAddIconSetDefinitions = new PendingReply(listener);
    
    trafficIncidentsService.addIconSetDefinitions(listener, iconSets);
    
    while (!pendingReplyAddIconSetDefinitions.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("addIconSetDefinitions - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("addIconSetDefinitions <=");
  }

  @Override
  public void RemoveIconSetDefinitions(List<Integer> iconSetIds) {
    LOGGER.info("removeIconSetDefinitions => iconSetIds = " + iconSetIds);
    
    EList<Integer> eListIconSetIds = new BasicEList<>(iconSetIds);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void removeIconSetDefinitionsReply() {
        LOGGER.info("removeIconSetDefinitionsReply =>");
        pendingReplyRemoveIconSetDefinitions.setReplyReceived(true);
      }  
    };
    pendingReplyRemoveIconSetDefinitions = new PendingReply(listener);
    
    trafficIncidentsService.removeIconSetDefinitions(listener, eListIconSetIds);
    
    while (!pendingReplyRemoveIconSetDefinitions.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("removeIconSetDefinitions - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("removeIconSetDefinitions <=");
  }

  @Override
  public List<IconDefinitionStruct> GetIconDefinitions(List<IconInfoStruct> iconInfoStructs) {
    LOGGER.info("getIconDefinitions => iconInfoStructs = " + iconInfoStructs);
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getIconDefinitionsReply(EList<IconDefinition> iconDefinitions) {
        LOGGER.info("getIconDefinitionsReply => iconDefinitions = " + iconDefinitions);
        pendingReplyGetIconDefinitions.setIconDefinitions(iconDefinitions);
        pendingReplyGetIconDefinitions.setReplyReceived(true);
      }
    };
    pendingReplyGetIconDefinitions = new PendingReplyGetIconDefinitions(listener);
    
    EList<IconInfo> iconInfos = new BasicEList<>();
    if (!(iconInfoStructs.size() == 1  &&  iconInfoStructs.get(0).iconId == -1  &&  iconInfoStructs.get(0).iconSetId == -1)) {
      for (IconInfoStruct iconInfoStruct: iconInfoStructs) {
        IconInfo iconInfo = StructUtil.iconInfoStructToIconInfo(iconInfoStruct);
        iconInfos.add(iconInfo);
      }
    }
    trafficIncidentsService.getIconDefinitions(listener, iconInfos);
    
    while (!pendingReplyGetIconDefinitions.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getIconDefinitions - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    List<IconDefinitionStruct> iconDefinitionStructs = new ArrayList<>();
    for (IconDefinition iconDefinition: pendingReplyGetIconDefinitions.getIconDefinitions()) {
      IconDefinitionStruct iconDefinitionStruct = StructUtil.iconDefinitionToIconDefinitionStruct(iconDefinition);
      iconDefinitionStructs.add(iconDefinitionStruct);
    }
    LOGGER.info("getIconDefinitions <= iconDefinitionStructs = " + iconDefinitionStructs);
    return iconDefinitionStructs;
  }

  @Override
  public void AddIconDefinitions(List<IconDefinitionStruct> iconDefinitionStructs) {
    LOGGER.info("addIconDefinitions => iconDefinitionStructs = " + iconDefinitionStructs);
    
    EList<IconDefinition> iconDefinitions = new BasicEList<>();
    for (IconDefinitionStruct iconDefinitionStruct: iconDefinitionStructs) {
      IconDefinition iconDefinition = StructUtil.iconDefinitionStructToIconDefinition(iconDefinitionStruct);
      iconDefinitions.add(iconDefinition);
    }
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void addIconDefinitionsReply() {
        LOGGER.info("addIconDefinitionsReply =>");
        pendingReplyAddIconDefinitions.setReplyReceived(true);
      }  
    };
    pendingReplyAddIconDefinitions = new PendingReply(listener);
    
    trafficIncidentsService.addIconDefinitions(listener, iconDefinitions);
    
    while (!pendingReplyAddIconDefinitions.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("addIconDefinitions - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("addIconDefinitions <=");
  }

  @Override
  public void RemoveIconDefinitions(List<IconInfoStruct> iconInfoStructs) {
    LOGGER.info("removeIconDefinitions => iconInfoStructs = " + iconInfoStructs);
    
    EList<IconInfo> iconInfos = new BasicEList<>();
    for (IconInfoStruct iconInfoStruct: iconInfoStructs) {
      IconInfo iconInfo = StructUtil.iconInfoStructToIconInfo(iconInfoStruct);
      iconInfos.add(iconInfo);
    }
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void removeIconDefinitionsReply() {
        LOGGER.info("removeIconDefinitionsReply =>");
        pendingReplyRemoveIconDefinitions.setReplyReceived(true);
      }  
    };
    pendingReplyRemoveIconDefinitions = new PendingReply(listener);
    
    trafficIncidentsService.removeIconDefinitions(listener, iconInfos);
    
    while (!pendingReplyRemoveIconDefinitions.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("removeIconDefinitions - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("removeIconDefinitions <=");
  }

  @Override
  public List<Integer> ReserveCategoryIds(Integer numberOfIds) {
    LOGGER.info("reserveCategoryIds => numberOfIds = " + numberOfIds);
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void reserveCategoryIdsReply(EList<Integer> categoryIds) {
        LOGGER.info("reserveCategoryIdsReply => categoryIds = " + categoryIds);
        pendingReplyReserveCategoryIds.setCategoryIds(categoryIds);
        pendingReplyReserveCategoryIds.setReplyReceived(true);
      }  
    };
    pendingReplyReserveCategoryIds = new PendingReplyReserveCategoryIds(listener);
    
    trafficIncidentsService.reserveCategoryIds(listener, numberOfIds);
    
    while (!pendingReplyReserveCategoryIds.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("reserveCategoryIds - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    List<Integer> categoryIds = pendingReplyReserveCategoryIds.getCategoryIds();
    LOGGER.info("reserveCategoryIds <= categoryIds = " + categoryIds);
    return categoryIds;
  }

  @Override
  public void FreeCategoryIds(List<Integer> categoryIds) {
    LOGGER.info("freeCategoryIds => categoryIds = " + categoryIds);
    
    EList<Integer> eListCategoryIds = new BasicEList<>(categoryIds);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void freeCategoryIdsReply() {
        LOGGER.info("freeCategoryIdsReply =>");
        pendingReplyFreeCategoryIds.setReplyReceived(true);
      }  
    };
    pendingReplyFreeCategoryIds = new PendingReply(listener);
    
    trafficIncidentsService.freeCategoryIds(listener, eListCategoryIds);
    
    while (!pendingReplyFreeCategoryIds.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("freeCategoryIds - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("freeCategoryIds <=");
  }

  @Override
  public List<CategoryDefinitionStruct> GetCategoryDefinitions() {
   LOGGER.info("getCategoryDefinitions =>");
   TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getCategoryDefinitionsReply(EList<CategoryDefinition> categoryDefinitions) {
        LOGGER.info("getCategoryDefinitionsReply => categoryDefinitions = " + categoryDefinitions);
        pendingReplyGetCategoryDefinitions.setCategoryDefinitions(categoryDefinitions);
        pendingReplyGetCategoryDefinitions.setReplyReceived(true);
      }
    };
    pendingReplyGetCategoryDefinitions = new PendingReplyGetCategoryDefinitions(listener);
    
    trafficIncidentsService.getCategoryDefinitions(listener);
    
    while (!pendingReplyGetCategoryDefinitions.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getCategoryDefinitions - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    List<CategoryDefinitionStruct> categoryDefinitionStructs = new ArrayList<>();
    for (CategoryDefinition categoryDefinition: pendingReplyGetCategoryDefinitions.getCategoryDefinitions()) {
      CategoryDefinitionStruct categoryDefinitionStruct = StructUtil.categoryDefinitionToCategoryDefinitionStruct(categoryDefinition);
      categoryDefinitionStructs.add(categoryDefinitionStruct);
    }
    LOGGER.info("getCategoryDefinitions <= categoryDefinitionStructs = " + categoryDefinitionStructs);
    return categoryDefinitionStructs;
  }

  @Override
  public void AddCategoryDefinitions(List<CategoryDefinitionStruct> categoryDefinitionStructs) {
    LOGGER.info("addCategoryDefinitions => categoryDefinitionStructs = " + categoryDefinitionStructs);
    
    EList<CategoryDefinition> categoryDefinitions = new BasicEList<>();
    for (CategoryDefinitionStruct categoryDefinitionStruct: categoryDefinitionStructs) {
      CategoryDefinition categoryDefinition = StructUtil.categoryDefinitionStructToCategoryDefinition(categoryDefinitionStruct);
      categoryDefinitions.add(categoryDefinition);
    }
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void addCategoryDefinitionsReply() {
        LOGGER.info("addCategoryDefinitionsReply =>");
        pendingReplyAddCategoryDefinitions.setReplyReceived(true);
      }  
    };
    pendingReplyAddCategoryDefinitions = new PendingReply(listener);
    
    trafficIncidentsService.addCategoryDefinitions(listener, categoryDefinitions);
    
    while (!pendingReplyAddCategoryDefinitions.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("addCategoryDefinitions - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("addCategoryDefinitions <=");
  }

  @Override
  public void RemoveCategoryDefinitions(List<Integer> categoryIds) {
    LOGGER.info("removeCategoryDefinitions => categoryIds = " + categoryIds);
    
    EList<Integer> eListCategoryIds = new BasicEList<>(categoryIds);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void removeCategoryDefinitionsReply() {
        LOGGER.info("removeCategoryDefinitionsReply =>");
        pendingReplyRemoveCategoryDefinitions.setReplyReceived(true);
      }  
    };
    pendingReplyRemoveCategoryDefinitions = new PendingReply(listener);
    
    trafficIncidentsService.removeCategoryDefinitions(listener, eListCategoryIds);
    
    while (!pendingReplyRemoveCategoryDefinitions.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("removeCategoryDefinitions - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("removeCategoryDefinitions <=");
  }
  
  @Override
  public synchronized List<Integer> GetTrafficIncidentIds(List<Byte> warningLevelIds, List<Integer> categoryIds) {
    LOGGER.info("getTrafficIncidentIds => warningLevelIds = " + warningLevelIds + ", categoryIds = " + categoryIds);
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getTrafficIncidentIdsReply(EList<Integer> incidentIds) {
        LOGGER.info("getTrafficIncidentIdsReply => incidentIds = " + incidentIds);
        pendingReplyGetTrafficIncidentIds.setIncidentIds(incidentIds);
        pendingReplyGetTrafficIncidentIds.setReplyReceived(true);
      }  
    };
    pendingReplyGetTrafficIncidentIds = new PendingReplyGetTrafficIncidentIds(listener);
    
    EList<WarningLevel> warningLevels = new BasicEList<>();
    for (Byte warningLevelId: warningLevelIds) {
      warningLevels.add(WarningLevel.get(warningLevelId));
    }
    EList<Integer> eListCategoryIds = new BasicEList<>(categoryIds);
    trafficIncidentsService.getTrafficIncidentIds(listener, warningLevels, eListCategoryIds);
    
    while (!pendingReplyGetTrafficIncidentIds.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getTrafficIncidentIds - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }

    List<Integer> incidentIds = pendingReplyGetTrafficIncidentIds.getIncidentIds();
    
    LOGGER.info("getTrafficIncidentIds <= incidentIds = " + incidentIds);
    return incidentIds;
  }

  @Override
  public synchronized List<Integer> GetTrafficIncidentIdsInAreas(List<Byte> warningLevelIds, List<Integer> categoryIds, List<RectangularAreaStruct> areaStructs) {
    LOGGER.info("getTrafficIncidentIdsInAreas => warningLevelIds = " + warningLevelIds + ", categoryIds = " + categoryIds + ", areaStructs = " + areaStructs);
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getTrafficIncidentIdsReply(EList<Integer> incidentIds) {
        LOGGER.info("getTrafficIncidentIdsReply => incidentIds = " + incidentIds);
        pendingReplyGetTrafficIncidentIdsInAreas.setIncidentIds(incidentIds);
        pendingReplyGetTrafficIncidentIdsInAreas.setReplyReceived(true);
      }  
    };
    pendingReplyGetTrafficIncidentIdsInAreas = new PendingReplyGetTrafficIncidentIdsInAreas(listener);
    
    EList<WarningLevel> warningLevels = new BasicEList<>();
    for (Byte warningLevelId: warningLevelIds) {
      warningLevels.add(WarningLevel.get(warningLevelId));
    }
    EList<RectangularArea> areas = new BasicEList<>();
    for (RectangularAreaStruct rectangularAreaStruct: areaStructs) {
      RectangularArea rectangularArea = StructUtil.rectangularAreaStructToRectangularArea(rectangularAreaStruct);
      areas.add(rectangularArea);
    }
    EList<Integer> eListCategoryIds = new BasicEList<>(categoryIds);
    trafficIncidentsService.getTrafficIncidentIdsInAreas(listener, warningLevels, eListCategoryIds, areas);
    
    while (!pendingReplyGetTrafficIncidentIdsInAreas.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getTrafficIncidentIdsInAreas - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }

    List<Integer> incidentIds = pendingReplyGetTrafficIncidentIdsInAreas.getIncidentIds();
    
    LOGGER.info("getTrafficIncidentIdsInAreas <= incidentIds = " + incidentIds);
    return incidentIds;
  }

  @Override
  public synchronized List<TrafficIncidentStruct> GetTrafficIncidents(List<Integer> trafficIncidentIds, boolean includeTextFields) {
    LOGGER.info("getTrafficIncidents => trafficIncidentIds = " + trafficIncidentIds + ", includeTextFields = " + includeTextFields);
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getTrafficIncidentsReply(EList<TrafficIncident> trafficIncidents) {
        LOGGER.info("getTrafficIncidentsReply => trafficIncidents = " + trafficIncidents);
        pendingReplyGetTrafficIncidents.setTrafficIncidents(trafficIncidents);
        pendingReplyGetTrafficIncidents.setReplyReceived(true);
      }  
    };
    pendingReplyGetTrafficIncidents = new PendingReplyGetTrafficIncidents(listener);
    
    EList<Integer> eListTrafficIncidentIds = new BasicEList<>(trafficIncidentIds);
    trafficIncidentsService.getTrafficIncidents(listener, eListTrafficIncidentIds, includeTextFields);
    
    while (!pendingReplyGetTrafficIncidents.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getTrafficIncidents - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }

    EList<TrafficIncident> trafficIncidents = pendingReplyGetTrafficIncidents.getTrafficIncidents();
    List<TrafficIncidentStruct> trafficIncidentStructs = new ArrayList<>();
    for (TrafficIncident trafficIncident: trafficIncidents) {
      TrafficIncidentStruct trafficIncidentStruct = StructUtil.trafficIncidentToTrafficIncidentStruct(trafficIncident);
      trafficIncidentStructs.add(trafficIncidentStruct);
    }
    
    LOGGER.info("getTrafficIncidents <= trafficIncidentStructs = " + trafficIncidentStructs);
    return trafficIncidentStructs;
  }

  @Override
  public synchronized List<TrafficIncidentStruct> GetTrafficIncidentsFields(List<Integer> trafficIncidentIds, List<Byte> trafficIncidentFieldIds) {
    LOGGER.info("getTrafficIncidentsFields => trafficIncidentIds = " + trafficIncidentIds + ", trafficIncidentFieldIds = " + trafficIncidentFieldIds);
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getTrafficIncidentsReply(EList<TrafficIncident> trafficIncidents) {
        LOGGER.info("getTrafficIncidentsFieldsReply => trafficIncidents = " + trafficIncidents);
        pendingReplyGetTrafficIncidentsFields.setTrafficIncidents(trafficIncidents);
        pendingReplyGetTrafficIncidentsFields.setReplyReceived(true);
      }  
    };
    LOGGER.info("listner = " + listener);
    pendingReplyGetTrafficIncidentsFields = new PendingReplyGetTrafficIncidentsFields(listener);
    
    EList<TrafficIncidentField> trafficIncidentFields = new BasicEList<>();
    for (Byte trafficIncidentFieldId: trafficIncidentFieldIds) {
      trafficIncidentFields.add(TrafficIncidentField.get(trafficIncidentFieldId));
    }
    EList<Integer> eListTrafficIncidentIds = new BasicEList<>(trafficIncidentIds);
    trafficIncidentsService.getTrafficIncidentsFields(listener, eListTrafficIncidentIds, trafficIncidentFields);
    
    while (!pendingReplyGetTrafficIncidentsFields.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getTrafficIncidentsFields - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }

    EList<TrafficIncident> trafficIncidents = pendingReplyGetTrafficIncidentsFields.getTrafficIncidents();
    List<TrafficIncidentStruct> trafficIncidentStructs = new ArrayList<>();
    for (TrafficIncident trafficIncident: trafficIncidents) {
      TrafficIncidentStruct trafficIncidentStruct = StructUtil.trafficIncidentToTrafficIncidentStruct(trafficIncident);
      trafficIncidentStructs.add(trafficIncidentStruct);
    }
    
    LOGGER.info("getTrafficIncidentsFields <= trafficIncidentStructs = " + trafficIncidentStructs);
    return trafficIncidentStructs;
  }

  @Override
  public synchronized List<String> GetTexts(List<Integer> trafficIncidentIds, Byte textDetailLevelId) {
    LOGGER.info("getTexts => trafficIncidentIds = " + trafficIncidentIds + ", textDetailLevelId = " + textDetailLevelId);
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getTextsReply(EList<String> texts) {
        LOGGER.info("getTextsReply => texts = " + texts);
        pendingReplyGetTexts.setTexts(texts);
        pendingReplyGetTexts.setReplyReceived(true);
      }  
    };
    pendingReplyGetTexts = new PendingReplyGetTexts(listener);
    
    TextDetailLevel textDetailLevel = TextDetailLevel.get(textDetailLevelId);
    EList<Integer> eListTrafficIncidentIds = new BasicEList<>(trafficIncidentIds);
    trafficIncidentsService.getTexts(listener, eListTrafficIncidentIds, textDetailLevel);
    
    while (!pendingReplyGetTexts.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("getTexts - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    List<String> texts = pendingReplyGetTexts.getTexts();
    LOGGER.info("getTexts <= texts = " + texts);
    return texts;
  }

  @Override
  public void AddTrafficIncidentsStatusListener() {
    LOGGER.info("addTrafficIncidentsStatusListener =>");
    
    String sender = AbstractConnection.currentSender;
    if (!trafficIncidentsStatusListeners.contains(sender)) {
      trafficIncidentsStatusListeners.add(sender);
    }
    
    if (trafficIncidentsStatusListener == null) {
      trafficIncidentsStatusListener = new DefaultTrafficIncidentsListener() {
        
        @Override
        public void trafficIncidentsStatus(
            TrafficIncidentFeedStatus trafficIncidentFeedStatus,
            org.genivi.trafficincidentsservice.TrafficIncidentsStatus trafficIncidentsStatus) {
          LOGGER.info("trafficIncidentsStatus() called.");
          sendSignalTrafficIncidentsStatus(trafficIncidentFeedStatus, trafficIncidentsStatus);
        }
      };
     
      TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
        
        @Override
        public void addTrafficIncidentsStatusListenerReply() {
          LOGGER.info("addTrafficIncidentsStatusListenerReply =>");
          pendingReplyAddTrafficIncidentsStatusListener.setReplyReceived(true);
        }  
      };
      pendingReplyAddTrafficIncidentsStatusListener = new PendingReply(listener);
      
      trafficIncidentsService.addTrafficIncidentsStatusListener(listener, trafficIncidentsStatusListener);
      
      while (!pendingReplyAddTrafficIncidentsStatusListener.isReplyReceived()) {
        try {
          Thread.sleep(10);
          LOGGER.info("addTrafficIncidentsStatusListener - Waiting for reply ...");
        } catch (InterruptedException e) {
        }
      }
    }
    
    LOGGER.info("addTrafficIncidentsStatusListener <=");
  }

  @Override
  public void RemoveTrafficIncidentsStatusListener() {
    LOGGER.info("removeTrafficIncidentsStatusListener =>");
    
    String sender = AbstractConnection.currentSender;
    trafficIncidentsStatusListeners.remove(sender);
    
    if (trafficIncidentsStatusListeners.isEmpty()) {
      TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
        
        @Override
        public void removeTrafficIncidentsStatusListenerReply() {
          LOGGER.info("removeTrafficIncidentsStatusListenerReply =>");
          trafficIncidentsStatusListener = null;
          pendingReplyRemoveTrafficIncidentsStatusListener.setReplyReceived(true);
        }  
      };
      pendingReplyRemoveTrafficIncidentsStatusListener = new PendingReply(listener);
      
      trafficIncidentsService.removeTrafficIncidentsStatusListener(listener, trafficIncidentsStatusListener);
      
      while (!pendingReplyRemoveTrafficIncidentsStatusListener.isReplyReceived()) {
        try {
          Thread.sleep(10);
          LOGGER.info("removeTrafficIncidentsStatusListener - Waiting for reply ...");
        } catch (InterruptedException e) {
        }
      }
    }
    
    LOGGER.info("removeTrafficIncidentsStatusListener <=");
  }

  @Override
  public void AddFeedInformationListener() {
    LOGGER.info("addFeedInformationListener =>");
    
    String sender = AbstractConnection.currentSender;
    if (!feedInformationListeners.contains(sender)) {
      feedInformationListeners.add(sender);
    }
    
    if (feedInformationListener == null) {
      feedInformationListener = new DefaultTrafficIncidentsListener() {
        
        @Override
        public void feedInformation(EList<org.genivi.trafficincidentsservice.FeedInformation> feedsInformation) {
          LOGGER.info("feedInformation() called.");
          sendSignalFeedInformation(feedsInformation);
        }
      };
     
      TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
        
        @Override
        public void addFeedInformationListenerReply() {
          LOGGER.info("addFeedInformationListenerReply =>");
          pendingReplyAddFeedInformationListener.setReplyReceived(true);
        }  
      };
      pendingReplyAddFeedInformationListener = new PendingReply(listener);
      
      trafficIncidentsService.addFeedInformationListener(listener, feedInformationListener);
      
      while (!pendingReplyAddFeedInformationListener.isReplyReceived()) {
        try {
          Thread.sleep(10);
          LOGGER.info("addFeedInformationListener - Waiting for reply ...");
        } catch (InterruptedException e) {
        }
      }
    }
    
    LOGGER.info("addFeedInformationListener <=");
  }

  @Override
  public void RemoveFeedInformationListener() {
    LOGGER.info("removeFeedInformationListener =>");
    
    String sender = AbstractConnection.currentSender;
    feedInformationListeners.remove(sender);
    
    if (feedInformationListeners.isEmpty()) {
      TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
        
        @Override
        public void removeFeedInformationListenerReply() {
          LOGGER.info("removeFeedInformationListenerReply =>");
          feedInformationListener = null;
          pendingReplyRemoveFeedInformationListener.setReplyReceived(true);
        }  
      };
      pendingReplyRemoveFeedInformationListener = new PendingReply(listener);
      
      trafficIncidentsService.removeFeedInformationListener(listener, feedInformationListener);
      
      while (!pendingReplyRemoveFeedInformationListener.isReplyReceived()) {
        try {
          Thread.sleep(10);
          LOGGER.info("removeFeedInformationListener - Waiting for reply ...");
        } catch (InterruptedException e) {
        }
      }
    }
    
    LOGGER.info("removeFeedInformationListener <=");
  }

  @Override
  public void AddUpdateListener(Integer listenerId, List<Byte> warningLevelIds, List<Integer> categoryIds) {
    LOGGER.info("addUpdateListener => listenerId = " + listenerId +
        ", warningLevelIds = " + warningLevelIds + ", categoryIds = " + categoryIds);
    String sender = AbstractConnection.currentSender;
    LOGGER.info(">>> Sender = " + sender);
    
    // Listener for the addUpdateListenerReply
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void addUpdateListenerReply() {
        LOGGER.info("addUpdateListenerReply =>");
        pendingReplyAddUpdateListener.setReplyReceived(true);
      }

    };
    pendingReplyAddUpdateListener = new PendingReply(listener);
        
    EList<WarningLevel> warningLevels = new BasicEList<>();
    for (Byte warningLevelId: warningLevelIds) {
      warningLevels.add(WarningLevel.get(warningLevelId));
    }
    EList<Integer> eListCategoryIds = new BasicEList<>(categoryIds);
    
    // listener proxy to forward the update to the remote client.
    TrafficIncidentsListenerProxy trafficIncidentsListenerProxy = new TrafficIncidentsListenerProxy(sender, listenerId);
    updatesListeners.add(trafficIncidentsListenerProxy);
    trafficIncidentsService.addUpdateListener(listener, warningLevels, eListCategoryIds, trafficIncidentsListenerProxy);
    
    while (!pendingReplyAddUpdateListener.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("addUpdateListener - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("addUpdateListener <=");
  }

  @Override
  public void RemoveUpdateListener(Integer listenerId) {
    LOGGER.info("removeUpdateListener => listenerId = " + listenerId);
    String sender = AbstractConnection.currentSender;
    LOGGER.info(">>> Sender = " + sender);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void removeUpdateListenerReply() {
        LOGGER.info("removeUpdateListenerReply =>");
        pendingReplyRemoveUpdateListener.setReplyReceived(true);
      }

    };
    pendingReplyRemoveUpdateListener = new PendingReply(listener);
        
    TrafficIncidentsListener trafficIncidentsListener = null;
    for (TrafficIncidentsListenerProxy trafficIncidentsListenerProxy: updatesListeners) {
      if (trafficIncidentsListenerProxy.getDestination().equals(sender)  &&
          trafficIncidentsListenerProxy.getListenerId() == listenerId) {
        trafficIncidentsListener = trafficIncidentsListenerProxy;
      }
    }
    updatesListeners.remove(trafficIncidentsListener);
    
    trafficIncidentsService.removeUpdateListener(listener, trafficIncidentsListener);
    
    while (!pendingReplyRemoveUpdateListener.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("removeUpdateListener - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("removeUpdateListener <=");
  }
  
  @Override
  public void AddAreasUpdateListener(Integer listenerId, List<Byte> warningLevelIds, List<Integer> categoryIds, List<RectangularAreaStruct> areaStructs) {
    LOGGER.info("addAreasUpdateListener => listenerId = " + listenerId + ", warningLevelIds = " + warningLevelIds +
        ", categoryIds = " + categoryIds + ", areaStructs = " + areaStructs);
    String sender = AbstractConnection.currentSender;
    LOGGER.info(">>> Sender = " + sender);
    
    // Listener for the addAreasUpdateListenerReply
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void addAreasUpdateListenerReply() {
        LOGGER.info("addAreasUpdateListenerReply =>");
        pendingReplyAddAreasUpdateListener.setReplyReceived(true);
      }
    };
    pendingReplyAddAreasUpdateListener = new PendingReplyAddAreasUpdateListener(listener);
    
    EList<WarningLevel> warningLevels = new BasicEList<>();
    for (Byte warningLevelId: warningLevelIds) {
      warningLevels.add(WarningLevel.get(warningLevelId));
    }
    EList<RectangularArea> areas = new BasicEList<>();
    for (RectangularAreaStruct rectangularAreaStruct: areaStructs) {
      RectangularArea rectangularArea = StructUtil.rectangularAreaStructToRectangularArea(rectangularAreaStruct);
      areas.add(rectangularArea);
    }
    EList<Integer> eListCategoryIds = new BasicEList<>(categoryIds);
    
    
    // listener proxy to forward the update to the remote client.
    TrafficIncidentsListenerProxy trafficIncidentsListenerProxy = new TrafficIncidentsListenerProxy(sender, listenerId);
    updatesInAreasListeners.add(trafficIncidentsListenerProxy);
    trafficIncidentsService.addAreasUpdateListener(listener, warningLevels, eListCategoryIds, areas, trafficIncidentsListenerProxy);
    
    while (!pendingReplyAddAreasUpdateListener.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("addAreasUpdateListener - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("addAreasUpdateListener <=");
  }

  @Override
  public void RemoveAreasUpdateListener(Integer listenerId) {
    LOGGER.info("removeAreasUpdateListener => listenerId = " + listenerId);
    String sender = AbstractConnection.currentSender;
    LOGGER.info(">>> Sender = " + sender);
    
    TrafficIncidentsListener listener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void removeAreasUpdateListenerReply() {
        LOGGER.info("removeAreasUpdateListenerReply =>");
        pendingReplyRemoveAreasUpdateListener.setReplyReceived(true);
      }

    };
    pendingReplyRemoveAreasUpdateListener = new PendingReply(listener);
        
    TrafficIncidentsListener trafficIncidentsListener = null;
    for (TrafficIncidentsListenerProxy trafficIncidentsListenerProxy: updatesInAreasListeners) {
      if (trafficIncidentsListenerProxy.getDestination().equals(sender)  &&
          trafficIncidentsListenerProxy.getListenerId() == listenerId) {
        trafficIncidentsListener = trafficIncidentsListenerProxy;
      }
    }
    updatesInAreasListeners.remove(trafficIncidentsListener);
    
    trafficIncidentsService.removeAreasUpdateListener(listener, trafficIncidentsListener);
    
    while (!pendingReplyRemoveAreasUpdateListener.isReplyReceived()) {
      try {
        Thread.sleep(10);
        LOGGER.info("removeAreasUpdateListener - Waiting for reply ...");
      } catch (InterruptedException e) {
      }
    }
    
    LOGGER.info("removeAreasUpdateListener <=");
  }

  public void sendSignalTrafficIncidentsStatus(TrafficIncidentFeedStatus trafficIncidentFeedStatus, org.genivi.trafficincidentsservice.TrafficIncidentsStatus trafficIncidentsStatus) {
    Byte trafficIncidentFeedStatusId = 0;
    if (trafficIncidentFeedStatus != null) {
      trafficIncidentFeedStatusId = (Byte) (byte) trafficIncidentFeedStatus.getValue();
    }
    
    Byte trafficIncidentsStatusId = 0;
    if (trafficIncidentsStatus != null) {
      trafficIncidentsStatusId = (Byte) (byte) trafficIncidentsStatus.getValue();
    }
    
    LOGGER.info("going to send TrafficIncidentsStatus signal");
    
    try {
      conn.sendSignal(new TrafficIncidentsDBus.TrafficIncidentsStatus("/java", trafficIncidentFeedStatusId, trafficIncidentsStatusId));
    } catch (DBusException e) {
      e.printStackTrace();
    }
  }

  public void sendSignalFeedInformation(EList<org.genivi.trafficincidentsservice.FeedInformation> feedsInformation) {
    List<FeedInformationStruct> feedsInformationStructs = new ArrayList<>();
    for (org.genivi.trafficincidentsservice.FeedInformation feedInformation: feedsInformation) {
      FeedInformationStruct feedInformationStruct = StructUtil.feedInformationToFeedInformationStruct(feedInformation);
      feedsInformationStructs.add(feedInformationStruct);
    }
    
    LOGGER.info("going to send FeedInformation signal");
    
    try {
      conn.sendSignal(new TrafficIncidentsDBus.FeedInformation("/java", feedsInformationStructs));
    } catch (DBusException e) {
      e.printStackTrace();
    }
  }

  public class PendingReply {
    private boolean replyReceived = false;
    private TrafficIncidentsListener listener;
    
    public PendingReply(TrafficIncidentsListener listener) {
      this.listener = listener;
    }

    public boolean isReplyReceived() {
      return replyReceived;
    }

    public void setReplyReceived(boolean replyReceived) {
      this.replyReceived = replyReceived;
    }

    public TrafficIncidentsListener getListener() {
      return listener;
    }
  }
  
  class PendingReplyGetVersion extends PendingReply {
    private Version version;
    
    public PendingReplyGetVersion(TrafficIncidentsListener listener) {
      super(listener);
    }

    public Version getVersion() {
      return version;
    }

    public void setVersion(Version version) {
      this.version = version;
    }
  }
  
  class PendingReplyGetTrafficIncidentIds extends PendingReply {
    private EList<Integer> incidentIds;

    public PendingReplyGetTrafficIncidentIds(TrafficIncidentsListener listener) {
      super(listener);
    }

    public EList<Integer> getIncidentIds() {
      return incidentIds;
    }

    public void setIncidentIds(EList<Integer> incidentIds) {
      this.incidentIds = incidentIds;
    }
  }
  
  class PendingReplyGetTrafficIncidentIdsInAreas extends PendingReply {
    private EList<Integer> incidentIds;

    public PendingReplyGetTrafficIncidentIdsInAreas(TrafficIncidentsListener listener) {
      super(listener);
    }

    public EList<Integer> getIncidentIds() {
      return incidentIds;
    }

    public void setIncidentIds(EList<Integer> incidentIds) {
      this.incidentIds = incidentIds;
    }
  }
  
  class PendingReplyGetTrafficIncidents extends PendingReply {
    private EList<TrafficIncident> trafficIncidents;

    public PendingReplyGetTrafficIncidents(TrafficIncidentsListener listener) {
      super(listener);
    }

    public EList<TrafficIncident> getTrafficIncidents() {
      return trafficIncidents;
    }

    public void setTrafficIncidents(EList<TrafficIncident> trafficIncidents) {
      this.trafficIncidents = trafficIncidents;
    }
  }
  
  class PendingReplyGetTrafficIncidentsFields extends PendingReply {
    private EList<TrafficIncident> trafficIncidents;

    public PendingReplyGetTrafficIncidentsFields(TrafficIncidentsListener listener) {
      super(listener);
    }

    public EList<TrafficIncident> getTrafficIncidents() {
      return trafficIncidents;
    }

    public void setTrafficIncidents(EList<TrafficIncident> trafficIncidents) {
      this.trafficIncidents = trafficIncidents;
    }
  }
  
  class PendingReplyGetTexts extends PendingReply {
    private EList<String> texts;

    public PendingReplyGetTexts(TrafficIncidentsListener listener) {
      super(listener);
    }

    public EList<String> getTexts() {
      return texts;
    }

    public void setTexts(EList<String> texts) {
      this.texts = texts;
    }
  }
  
  class PendingReplyAddAreasUpdateListener extends PendingReply {
    private int listenerId;

    public PendingReplyAddAreasUpdateListener(TrafficIncidentsListener listener) {
      super(listener);
    }

    public int getListenerId() {
      return listenerId;
    }

    public void setListenerId(int listenerId) {
      this.listenerId = listenerId;
    }
  }
  
  class PendingReplyGetLanguage extends PendingReply {
    private String languageCode;
    private String countryCode;

    public PendingReplyGetLanguage(TrafficIncidentsListener listener) {
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
  
  class PendingReplyReserveIconSetIds extends PendingReply {
    private EList<Integer> iconSetIds;

    public PendingReplyReserveIconSetIds(TrafficIncidentsListener listener) {
      super(listener);
    }

    public EList<Integer> getIconSetIds() {
      return iconSetIds;
    }

    public void setIconSetIds(EList<Integer> iconSetIds) {
      this.iconSetIds = iconSetIds;
    }
  }
  
  class PendingReplyGetIconSets extends PendingReply {
    private EList<IconSet> iconSets;

    public PendingReplyGetIconSets(TrafficIncidentsListener listener) {
      super(listener);
    }

    public EList<IconSet> getIconSets() {
      return iconSets;
    }

    public void setIconSets(EList<IconSet> iconSets) {
      this.iconSets = iconSets;
    }
  }
  
  class PendingReplyGetIconDefinitions extends PendingReply {
    private EList<IconDefinition> iconDefinitions;

    public PendingReplyGetIconDefinitions(TrafficIncidentsListener listener) {
      super(listener);
    }

    public EList<IconDefinition> getIconDefinitions() {
      return iconDefinitions;
    }

    public void setIconDefinitions(EList<IconDefinition> iconDefinitions) {
      this.iconDefinitions = iconDefinitions;
    }
  }
  
  class PendingReplyReserveCategoryIds extends PendingReply {
    private EList<Integer> categoryIds;

    public PendingReplyReserveCategoryIds(TrafficIncidentsListener listener) {
      super(listener);
    }

    public EList<Integer> getCategoryIds() {
      return categoryIds;
    }

    public void setCategoryIds(EList<Integer> categoryIds) {
      this.categoryIds = categoryIds;
    }
  }
  
  class PendingReplyGetCategoryDefinitions extends PendingReply {
    private EList<CategoryDefinition> categoryDefinitions;

    public PendingReplyGetCategoryDefinitions(TrafficIncidentsListener listener) {
      super(listener);
    }

    public EList<CategoryDefinition> getCategoryDefinitions() {
      return categoryDefinitions;
    }

    public void setCategoryDefinitions(EList<CategoryDefinition> categoryDefinitions) {
      this.categoryDefinitions = categoryDefinitions;
    }
  }
  
  class PendingReplyGetApplicability extends PendingReply {
    private String filterExpression;

    public PendingReplyGetApplicability(TrafficIncidentsListener listener) {
      super(listener);
    }

    public String getFilterExpression() {
      return filterExpression;
    }

    public void setFilterExpression(String filterExpression) {
      this.filterExpression = filterExpression;
    }

  }
}
