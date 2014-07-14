/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentsconfiguration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.freedesktop.dbus.exceptions.DBusException;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.ComparisonOperator;
import org.genivi.booleanexpr.ComparisonPredicate;
import org.genivi.booleanexpr.DownCastPredicate;
import org.genivi.booleanexpr.DyadicExpression;
import org.genivi.booleanexpr.DyadicLogicalOperator;
import org.genivi.booleanexpr.FilterexprFactory;
import org.genivi.booleanexpr.ListOperator;
import org.genivi.booleanexpr.MultiplicityPredicate;
import org.genivi.booleanexpr.SignedIntegerLiteral;
import org.genivi.common.CommonFactory;
import org.genivi.common.LocalizedString;
import org.genivi.iconset.ColorType;
import org.genivi.iconset.IconData;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconDescriptor;
import org.genivi.iconset.IconDimension;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.iconset.IconSize;
import org.genivi.iconset.IconsetFactory;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.trafficincidentsserviceFactory;
import org.genivi.trafficincidentsservice.trafficincidents.dbus.impl.TrafficIncidentsDBusProxy;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.CauseCode;
import org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode;
import org.genivi.trafficincidentsservice.trafficincidenttables.VisibilityReduced;

import cx.ath.matthew.debug.Debug;


public class TrafficIncidentsConfiguration {
  private final static Logger LOGGER = Logger.getLogger(TrafficIncidentsConfiguration.class.getName());
  private static final String NEWLINE = System.getProperty("line.separator");
  private final static String TRAFFIC_INCIDENTS_SERVICE_NAME = "org.genivi.trafficinfo.TrafficIncidentsDBus";
  private final static String OBJECT_PATH_SERVICE = "/java";
  private final static CommonFactory COMMON_FACTORY = CommonFactory.eINSTANCE;
  private final static IconsetFactory iconsetFactory = IconsetFactory.eINSTANCE;
  private final static trafficincidentsserviceFactory TRAFFIC_INCIDENTS_SVC_FACTORY = trafficincidentsserviceFactory.eINSTANCE;
  private final static FilterexprFactory FILTER_EXPR_FACTORY = FilterexprFactory.eINSTANCE;
  private final static trafficincidentPackage tip = trafficincidentPackage.eINSTANCE;

  
  private String objectPath = OBJECT_PATH_SERVICE;
  private String interfaceName = TRAFFIC_INCIDENTS_SERVICE_NAME;

  

  // settings to control what to run and what not
  private final static Level logLevel = Level.SEVERE;
  private final static boolean useIconFiles = false;

  private EList<Integer> iconSetIds = null;
  private EList<Integer> categoryIds = null;
  private EList<IconSet> iconSets = null;
  private EList<IconDefinition> iconDefinitions = null;  
  
  private TrafficIncidentsDBusProxy trafficIncidentsService;
  
  TrafficIncidentsConfiguration() throws DBusException {
    // Create the Traffic Information Service Proxy
    trafficIncidentsService = new TrafficIncidentsDBusProxy(interfaceName, objectPath);
    
    try {
      Debug.setOutput(System.out);
      Debug.setLineNos(true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    // Customize the Service
    customizeTrafficIncidentsService(trafficIncidentsService);
    
  }
  
  private void customizeTrafficIncidentsService(TrafficIncidents trafficIncidentsService) {
    
    TrafficIncidentsListener reserveIconSetIdsReplyListener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void reserveIconSetIdsReply(EList<Integer> iconSetIds) {
        setIconSetIds(iconSetIds);
      }
    };
    
    trafficIncidentsService.reserveIconSetIds(reserveIconSetIdsReplyListener, 10);
    while (iconSetIds == null) {
      LOGGER.info("Waiting for iconSetIds");
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    LOGGER.info("iconSetIds received");
    
    // Create the icon set definitions.
    iconSets = new BasicEList<IconSet>();
    iconSets.add(createIconSet(iconSetIds.get(0), ColorType.GRAY_8, IconDimension.D2D, true, 28, 32, useIconFiles));
    iconSets.add(createIconSet(iconSetIds.get(1), ColorType.RGB888, IconDimension.D2D, true, 28, 32, useIconFiles));
    iconSets.add(createIconSet(iconSetIds.get(2), ColorType.GRAY_8, IconDimension.D2D, false, 28, 32, useIconFiles));
    iconSets.add(createIconSet(iconSetIds.get(3), ColorType.RGB888, IconDimension.D2D, false, 28, 32, useIconFiles));
    iconSets.add(createIconSet(iconSetIds.get(4), ColorType.RGB888, IconDimension.D25D, true, 28, 32, useIconFiles));
    iconSets.add(createIconSet(iconSetIds.get(5), ColorType.RGB888, IconDimension.D25D, false, 28, 32, useIconFiles));
    iconSets.add(createIconSet(iconSetIds.get(6), ColorType.GRAY_8, IconDimension.D2D, true, 44, 32, useIconFiles));
    iconSets.add(createIconSet(iconSetIds.get(7), ColorType.RGB888, IconDimension.D2D, true, 44, 32, useIconFiles));
    iconSets.add(createIconSet(iconSetIds.get(8), ColorType.GRAY_8, IconDimension.D2D, false, 44, 32, useIconFiles));
    iconSets.add(createIconSet(iconSetIds.get(9), ColorType.RGB888, IconDimension.D2D, false, 44, 32, useIconFiles));

    iconDefinitions = createIconDefinitions(iconSets);

    trafficIncidentsService.addIconDefinitions(null, iconDefinitions);
    trafficIncidentsService.addIconSetDefinitions(null, iconSets);
    
    TrafficIncidentsListener reserveCategoryIdsReplyListener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void reserveCategoryIdsReply(EList<Integer> categoryIds) {
        setCategoryIds(categoryIds);
      }
    };
    
    trafficIncidentsService.reserveCategoryIds(reserveCategoryIdsReplyListener, 3);
    while (categoryIds == null) {
      LOGGER.info("Waiting for categoryIds");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    LOGGER.info("categoryIds received");

    EList<CategoryDefinition> categoryDefinitions = new BasicEList<CategoryDefinition>();
    categoryDefinitions.add(createCategory1(categoryIds.get(0)));
    categoryDefinitions.add(createCategory2(categoryIds.get(1)));
    categoryDefinitions.add(createCategory3(categoryIds.get(2)));
    
    trafficIncidentsService.addCategoryDefinitions(new DefaultTrafficIncidentsListener(), categoryDefinitions);
  }

  private void setIconSetIds(EList<Integer> iconSetIds) {
    this.iconSetIds = iconSetIds;
  }
  
  private void setCategoryIds(EList<Integer> categoryIds) {
    this.categoryIds = categoryIds;
  }

  private IconSet createIconSet(int iconSetId, ColorType colorType,
      IconDimension iconDimension, boolean dayTimeIcon, int themeId,
      int size, boolean useIconFiles) {
    IconSet iconSet = iconsetFactory.createIconSet();
    iconSet.setIconSetId(iconSetId);
    iconSet.setColorType(colorType);
    iconSet.setDimension(iconDimension);
    iconSet.setDayTimeIcon(dayTimeIcon);
    iconSet.setThemeId(themeId);
    iconSet.setMediumType("image/png");
    IconSize iconSize = iconsetFactory.createIconSize();
    iconSize.setWidth(size);
    iconSize.setHeight(size);
    iconSet.setSize(iconSize);
    for (int iconId = 1; iconId <= 6; iconId++) {
      IconDescriptor iconDescriptor = iconsetFactory.createIconDescriptor();
      if (useIconFiles) {
        iconDescriptor.setUrl(constructIconFileName(iconSet, iconId));
      }
      iconDescriptor.setIconId(iconId);
      iconSet.getIconDescriptors().add(iconDescriptor);
    }
    
    return iconSet;
  }
  
  private String constructIconFileName(IconSet iconSet, int iconId) {
    StringBuilder buf = new StringBuilder();
    
    buf.append("icons");
    buf.append(File.separator);
    
    buf.append("icon_setId");
    buf.append(iconSet.getIconSetId());
    buf.append("_");
    buf.append(iconSet.getColorType().getName());
    buf.append("_");
    buf.append(iconSet.getDimension().getName());
    buf.append("_");
    if (iconSet.isDayTimeIcon()) {
      buf.append("day");
    } else {
      buf.append("night");
    }
    buf.append("_themeId");
    buf.append(iconSet.getThemeId());
    buf.append("_");
    buf.append(iconSet.getSize().getWidth());
    buf.append("x");
    buf.append(iconSet.getSize().getHeight());
    buf.append("_iconId");
    buf.append(iconId);
    buf.append(".png");
   
    return buf.toString();
  }

  private EList<IconDefinition> createIconDefinitions(EList<IconSet> iconSets) {
    EList<IconDefinition> iconDefinitions = new BasicEList<IconDefinition>();
    
    for (IconSet iconSet: iconSets) {
      for (IconDescriptor iconDescriptor: iconSet.getIconDescriptors()) {
        iconDescriptor.getIconId();
        iconDescriptor.getUrl();
        BufferedImage image = createIcon(iconSet.getIconSetId(), iconSet.getColorType(), iconSet.getDimension(),
            iconSet.isDayTimeIcon(), iconSet.getThemeId(), iconSet.getSize(), iconDescriptor.getIconId());
        IconDefinition iconDefinition = iconsetFactory.createIconDefinition();
        IconInfo iconInfo = iconsetFactory.createIconInfo();
        iconInfo.setIconSetId(iconSet.getIconSetId());
        iconInfo.setIconId(iconDescriptor.getIconId());
        iconDefinition.setIconInfo(iconInfo);

        if (iconDescriptor.isSetUrl()) {
          File output = new File(iconDescriptor.getUrl());
          try {
            ImageIO.write(image, "png", output);
          } catch (IOException e) {
            e.printStackTrace();
          }
        } else {
          try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);
            IconData iconData = iconsetFactory.createIconData();
            byte[] bytes = outputStream.toByteArray();
            iconData.setData(bytes);
            iconDefinition.setIconData(iconData);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        iconDefinitions.add(iconDefinition);
        
      }
    }

    return iconDefinitions;
  }
  
  private Color getColor(ColorType colorType, int iconId, boolean dayTimeIcon) {
    Color color = null;
    
    switch (colorType) {
    case BLACK_AND_WHITE:
    case GRAY_4:
    case GRAY_8:
      int componentValue = 255 - (28 * iconId);
      if (!dayTimeIcon) {
        componentValue = 255 - componentValue;
      }
      color = new Color(componentValue, componentValue, componentValue);
      break;
      
    case RGB555:
    case RGB565:
    case RGB888:
      int red = 42 * (iconId - 1);
      int green = 125;
      int blue = 42 * (6 - iconId);
      if (!dayTimeIcon) {
        red = 255 - red;
        green = 255 - green;
        blue = 255 - blue;
      }
      color = new Color(red, green, blue);
    }
    
    return color;
  }
  
  private BufferedImage createIcon(int iconSetId, ColorType colorType,
      IconDimension iconDimension, boolean dayTimeIcon, int themeId,
      IconSize iconSize, int iconId) {
    BufferedImage bi = new BufferedImage(iconSize.getWidth(), iconSize.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics g = bi.getGraphics();
    
    g.setColor(getColor(colorType, iconId, dayTimeIcon));
    
    if (themeId == 44) {
      g.fillOval(0, 0, iconSize.getWidth() - 1, iconSize.getHeight() - 1);
    } else {
      g.fill3DRect(0, 0, iconSize.getWidth() - 1, iconSize.getHeight() - 1, true);
    }
    
    if (iconDimension == IconDimension.D25D) {
    g.setColor(Color.GRAY);
    g.drawString(iconSetId + "/" + iconId, 10, 18);
    g.drawString(iconSetId + "/" + iconId, 9, 19);
    g.drawString(iconSetId + "/" + iconId, 8, 20);
    }
    
    if (dayTimeIcon) {
      g.setColor(Color.BLACK);
    } else {
      g.setColor(Color.WHITE);
    }
    g.drawString(iconSetId + "/" + iconId, 7, 21);
    
    return bi;
  }
  
  private CategoryDefinition createCategory1(int categoryId) {
    CategoryDefinition categoryDefinition = TRAFFIC_INCIDENTS_SVC_FACTORY.createCategoryDefinition();
    
    categoryDefinition.setCategoryId(categoryId);
    
    LocalizedString[] localizedNames = new LocalizedString[2];
    LocalizedString localizedCategoryName;
    localizedCategoryName = COMMON_FACTORY.createLocalizedString();
    localizedCategoryName.setLanguageCode("nld");
    localizedCategoryName.setString("file");
    localizedNames[0] = localizedCategoryName;
    localizedCategoryName = COMMON_FACTORY.createLocalizedString();
    localizedCategoryName.setLanguageCode("eng");
    localizedCategoryName.setString("stationary traffic");
    localizedNames[1] = localizedCategoryName;
    categoryDefinition.setLocalizedNames(localizedNames);

    // Comparison Predicate: effectCode == STATIONARY_TRAFFIC
    ComparisonPredicate effectIsStationaryTraffic = FILTER_EXPR_FACTORY.createComparisonPredicate();
    ClassAttribute effectCode = FILTER_EXPR_FACTORY.createClassAttribute();
    effectCode.setAttributeName(tip.getTrafficIncident_EffectCode().getName());
    effectIsStationaryTraffic.setAttribute(effectCode);
    effectIsStationaryTraffic.setComparisonOperator(ComparisonOperator.EQUAL);
    SignedIntegerLiteral stationaryTrafficEnumValue = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    stationaryTrafficEnumValue.setValue(EffectCode.STATIONARY_TRAFFIC.getValue());
    effectIsStationaryTraffic.setLiteral(stationaryTrafficEnumValue);
    
    categoryDefinition.setExpression(effectIsStationaryTraffic.toString());
    
    for (IconSet iconSet: iconSets) {
      for (IconDescriptor iconDescriptor: iconSet.getIconDescriptors()) {
        if (iconDescriptor.getIconId() == 1) {
          IconInfo iconInfo = iconsetFactory.createIconInfo();
          iconInfo.setIconSetId(iconSet.getIconSetId());
          iconInfo.setIconId(iconDescriptor.getIconId());
          categoryDefinition.getIconsList().add(iconInfo);
        }
      }
    }
    
    return categoryDefinition;
  }
  
  private CategoryDefinition createCategory2(int categoryId) {
    CategoryDefinition categoryDefinition = TRAFFIC_INCIDENTS_SVC_FACTORY.createCategoryDefinition();
    
    categoryDefinition.setCategoryId(categoryId);
    
    LocalizedString[] localizedNames = new LocalizedString[2];
    LocalizedString localizedCategoryName;
    localizedCategoryName = COMMON_FACTORY.createLocalizedString();
    localizedCategoryName.setLanguageCode("nld");
    localizedCategoryName.setString("druk verkeer - laagstaande zon");
    localizedNames[0] = localizedCategoryName;
    localizedCategoryName = COMMON_FACTORY.createLocalizedString();
    localizedCategoryName.setLanguageCode("eng");
    localizedCategoryName.setString("heavy traffic - low sunglare");
    localizedNames[1] = localizedCategoryName;
    categoryDefinition.setLocalizedNames(localizedNames);
        
    // Comparison Predicate: effectCode == HEAVY_TRAFFIC
    ComparisonPredicate effectIsHeavyTraffic = FILTER_EXPR_FACTORY.createComparisonPredicate();
    ClassAttribute effectCode = FILTER_EXPR_FACTORY.createClassAttribute();
    effectCode.setAttributeName(tip.getTrafficIncident_EffectCode().getName());
    effectIsHeavyTraffic.setAttribute(effectCode);
    effectIsHeavyTraffic.setComparisonOperator(ComparisonOperator.EQUAL);
    SignedIntegerLiteral heavyTrafficEnumValue = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    heavyTrafficEnumValue.setValue(EffectCode.HEAVY_TRAFFIC.getValue());
    effectIsHeavyTraffic.setLiteral(heavyTrafficEnumValue);

    
    // Comparison Predicate: mainCause == VISIBILITY_REDUCED
    ComparisonPredicate mainCauseIsVisibilityReduced = FILTER_EXPR_FACTORY.createComparisonPredicate();
    ClassAttribute mainCause = FILTER_EXPR_FACTORY.createClassAttribute();
    mainCause.setAttributeName(tip.getCause_MainCause().getName());
    mainCauseIsVisibilityReduced.setAttribute(mainCause);
    mainCauseIsVisibilityReduced.setComparisonOperator(ComparisonOperator.EQUAL);
    SignedIntegerLiteral visibilityReducedEnumValue = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    visibilityReducedEnumValue.setValue(CauseCode.VISIBILITY_REDUCED.getValue());
    mainCauseIsVisibilityReduced.setLiteral(visibilityReducedEnumValue);
    
    // Comparison Predicate: subCause == LOW_SUNGLARE
    ComparisonPredicate subCauseIsLowSunglare = FILTER_EXPR_FACTORY.createComparisonPredicate();
    ClassAttribute subCause = FILTER_EXPR_FACTORY.createClassAttribute();
    subCause.setAttributeName(tip.getDirectCause_SubCause().getName());
    subCauseIsLowSunglare.setAttribute(subCause);
    subCauseIsLowSunglare.setComparisonOperator(ComparisonOperator.EQUAL);
    SignedIntegerLiteral lowSunglareEnumValue = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    lowSunglareEnumValue.setValue(VisibilityReduced.VISIBILITY_REDUCED_DUE_TO_LOW_SUN_GLARE.getValue());
    subCauseIsLowSunglare.setLiteral(lowSunglareEnumValue);
    
    // Dyadic Expression: (mainCause == VISIBILITY_REDUCED) && (subCause == LOW_SUNGLARE)
    DyadicExpression causeExpression = FILTER_EXPR_FACTORY.createDyadicExpression();
    causeExpression.setLeftHandTerm(mainCauseIsVisibilityReduced);
    causeExpression.setLogicalOperator(DyadicLogicalOperator.AND);
    causeExpression.setRightHandTerm(subCauseIsLowSunglare);
    
    // Downcast: to DirectCause where (mainCause == VISIBILITY_REDUCED) && (subCause == LOW_SUNGLARE)
    DownCastPredicate directCauseDownCast = FILTER_EXPR_FACTORY.createDownCastPredicate();
    directCauseDownCast.setClassName(tip.getDirectCause().getName());
    directCauseDownCast.setExpression(causeExpression);
    
    // Multiplicity Predicate: ANY cause instanceof DirectCause where (mainCause == VISIBILITY_REDUCED) && (subCause == LOW_SUNGLARE)
    MultiplicityPredicate anyCausePredicate = FILTER_EXPR_FACTORY.createMultiplicityPredicate();
    anyCausePredicate.setListOperator(ListOperator.ANY);
    ClassAttribute causes = FILTER_EXPR_FACTORY.createClassAttribute();
    causes.setAttributeName(tip.getTrafficIncident_Causes().getName());
    anyCausePredicate.setAttribute(causes);
    anyCausePredicate.setExpression(directCauseDownCast);
    
    
    // Dyadic Expression: (effectCode == HAEVY_TRAFFIC) AND (ANY cause instanceof DirectCause where (mainCause == VISIBILITY_REDUCED) && (subCause == LOW_SUNGLARE))
    DyadicExpression expression = FILTER_EXPR_FACTORY.createDyadicExpression();
    expression.setLeftHandTerm(effectIsHeavyTraffic);
    expression.setLogicalOperator(DyadicLogicalOperator.AND);
    expression.setRightHandTerm(anyCausePredicate);
        
    categoryDefinition.setExpression(expression.toString());
    
    for (IconSet iconSet: iconSets) {
      for (IconDescriptor iconDescriptor: iconSet.getIconDescriptors()) {
        if (iconDescriptor.getIconId() == 2) {
          IconInfo iconInfo = iconsetFactory.createIconInfo();
          iconInfo.setIconSetId(iconSet.getIconSetId());
          iconInfo.setIconId(iconDescriptor.getIconId());
          categoryDefinition.getIconsList().add(iconInfo);
        }
      }
    }
    
    return categoryDefinition;
  }
  
  private CategoryDefinition createCategory3(int categoryId) {
    CategoryDefinition categoryDefinition = TRAFFIC_INCIDENTS_SVC_FACTORY.createCategoryDefinition();
    
    categoryDefinition.setCategoryId(categoryId);
    
    LocalizedString[] localizedNames = new LocalizedString[2];
    LocalizedString localizedCategoryName;
    localizedCategoryName = COMMON_FACTORY.createLocalizedString();
    localizedCategoryName.setLanguageCode("nld");
    localizedCategoryName.setString("beperkt zicht");
    localizedNames[0] = localizedCategoryName;
    localizedCategoryName = COMMON_FACTORY.createLocalizedString();
    localizedCategoryName.setLanguageCode("eng");
    localizedCategoryName.setString("visibility reduced");
    localizedNames[1] = localizedCategoryName;
    categoryDefinition.setLocalizedNames(localizedNames);
        
    
    // Comparison Predicate: mainCause == VISIBILITY_REDUCED
    ComparisonPredicate mainCauseIsVisibilityReduced = FILTER_EXPR_FACTORY.createComparisonPredicate();
    ClassAttribute mainCause = FILTER_EXPR_FACTORY.createClassAttribute();
    mainCause.setAttributeName(tip.getCause_MainCause().getName());
    mainCauseIsVisibilityReduced.setAttribute(mainCause);
    mainCauseIsVisibilityReduced.setComparisonOperator(ComparisonOperator.EQUAL);
    SignedIntegerLiteral visibilityReducedEnumValue = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    visibilityReducedEnumValue.setValue(CauseCode.VISIBILITY_REDUCED.getValue());
    mainCauseIsVisibilityReduced.setLiteral(visibilityReducedEnumValue);
    
    // Multiplicity Predicate: ANY cause where (mainCause == VISIBILITY_REDUCED)
    MultiplicityPredicate anyCausePredicate = FILTER_EXPR_FACTORY.createMultiplicityPredicate();
    anyCausePredicate.setListOperator(ListOperator.ANY);
    ClassAttribute causes = FILTER_EXPR_FACTORY.createClassAttribute();
    causes.setAttributeName(tip.getTrafficIncident_Causes().getName());
    anyCausePredicate.setAttribute(causes);
    anyCausePredicate.setExpression(mainCauseIsVisibilityReduced);

    categoryDefinition.setExpression(anyCausePredicate.toString());
    
    for (IconSet iconSet: iconSets) {
      for (IconDescriptor iconDescriptor: iconSet.getIconDescriptors()) {
        if (iconDescriptor.getIconId() == 3) {
          IconInfo iconInfo = iconsetFactory.createIconInfo();
          iconInfo.setIconSetId(iconSet.getIconSetId());
          iconInfo.setIconId(iconDescriptor.getIconId());
          categoryDefinition.getIconsList().add(iconInfo);
        }
      }
    }
    
    return categoryDefinition;
  }


  public static void main(String[] args) throws DBusException {
    LOGGER.setLevel(logLevel);

    // Check the arguments and if not OK, show a message and exit.
    // TrafficIncidentsConfiguration has no arguments.
    if (args.length != 0) {
      showUsageInfoDialogAndExit(args);    
    }
    
    @SuppressWarnings("unused")
    TrafficIncidentsConfiguration trafficIncidentsConfiguration = new TrafficIncidentsConfiguration();
    
    trafficIncidentsConfiguration = null;
    
    System.exit(0);
  }
  
  private static void showUsageInfoDialogAndExit(final String[] args) {
    StringBuilder argInfo = new StringBuilder();

    argInfo.append("TrafficIncidentsListClient has to be called without any arguments.").append(NEWLINE);
    argInfo.append("The following arguments were given:");
    for (int i = 0; i < args.length; i++) {
      argInfo.append(NEWLINE).append(args[i]);
    }

    JOptionPane.showMessageDialog(null,
        argInfo.toString(),
        "Error",
        JOptionPane.ERROR_MESSAGE);
    
    System.exit(0);
  }
}
