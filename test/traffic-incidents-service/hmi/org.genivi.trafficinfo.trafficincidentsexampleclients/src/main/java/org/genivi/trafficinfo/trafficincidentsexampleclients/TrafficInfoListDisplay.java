/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentsexampleclients;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.genivi.booleanexpr.BooleanExpression;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.ComparisonOperator;
import org.genivi.booleanexpr.ComparisonPredicate;
import org.genivi.booleanexpr.DyadicExpression;
import org.genivi.booleanexpr.DyadicLogicalOperator;
import org.genivi.booleanexpr.FilterexprFactory;
import org.genivi.booleanexpr.IsSetPredicate;
import org.genivi.booleanexpr.ListOperator;
import org.genivi.booleanexpr.MetaOperator;
import org.genivi.booleanexpr.MultiplicityPredicate;
import org.genivi.booleanexpr.SignedIntegerLiteral;
import org.genivi.booleanexpr.util.FilterExprUtil;
import org.genivi.common.LocalizedString;
import org.genivi.common.Version;
import org.genivi.iconset.ColorType;
import org.genivi.iconset.IconData;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconDescriptor;
import org.genivi.iconset.IconDimension;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.iconset.IconsetFactory;
import org.genivi.location.AreaLocation;
import org.genivi.location.AreaLocationInfo;
import org.genivi.location.LinearLocation;
import org.genivi.location.LinearLocationInfo;
import org.genivi.location.Location;
import org.genivi.location.LocationInfo;
import org.genivi.location.PointLocation;
import org.genivi.location.PointLocationInfo;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsListener;
import org.genivi.trafficincidentsservice.FeedInformation;
import org.genivi.trafficincidentsservice.LengthUnit;
import org.genivi.trafficincidentsservice.TextDetailLevel;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentField;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.WeightUnit;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction;
import org.genivi.trafficincidentsservice.trafficincidenttables.RestrictionType;
import org.genivi.trafficincidentsservice.trafficincidenttables.VehicleType;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;


@SuppressWarnings("serial")
public class TrafficInfoListDisplay extends JFrame {
  private final static Logger LOGGER = Logger.getLogger(TrafficInfoMapView.class.getName());
  private static final String TITLE_BODY = "Traffic Incidents List Display (TrafficIncidentsService version: ";
  private static final String NEW_LINE = System.getProperty("line.separator");
  private static final SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  private final static FilterexprFactory FILTER_EXPR_FACTORY = FilterexprFactory.eINSTANCE;
  private final static trafficincidentPackage tip = trafficincidentPackage.eINSTANCE;
  private static final String NO_COUNTRY = "<none>";
  private static String[] SUPPORTED_LANGUAGES = {
    "nld", "eng", "fra", "deu"
  };
  private static String[] SUPPORTED_COUNTRIES = {
    NO_COUNTRY, "nld", "gbr", "usa", "fra", "deu"
  };
  private static String[] FEED_INFO_TABLE_COLUMN_NAMES = {
    "Data Provider", "Protocol", "Communication Channel", "Feed Status", "Traffic Incidents Status"
  };
  private static Object[][] UNKOWN_FEED_INFO = {
    {"-", "-", "-", "-", "-"}
  };
  private static final long AXLE_LOAD_NORMAL = 4;
  private static final long AXLE_LOAD_EXTRA = 3;
  
  private final static IconsetFactory iconsetFactory = IconsetFactory.eINSTANCE;  
  private static List<TrafficIncidentField> trafficIncidentFields = new ArrayList<TrafficIncidentField>();
  
  private TrafficIncidents trafficIncidentsService;
  
  private boolean versionInfoObtained = false;
  private boolean iconSetsObtained = false;
  private boolean iconDefinitionsObtained = false;
  private boolean categoryDefinitionsObtained = false;
  
  private EList<IconSet> iconSets;         // Descriptions of the icon sets available in the system. These are obtained from the TrafficIncidentsService.
  private EList<Integer> iconThemes;       // Icon themes available in iconSets.
  private EList<ColorType> iconColorTypes; // Color types available in iconSets.
  private EList<IconDimension> iconDimensions;  // Icon dimensions available in iconSets.
  private boolean dayTimeSupported = false;   // Indicates whether there are daytime icons in iconSets.
  private boolean nightTimeSupported = false; // Indicates whether there are night time icons in iconSets.
  private EList<Integer> iconSetsPriorityOrder;  // Priority order for the icon to be used.
  private Map<IconInfo, BufferedImage> iconImages = new HashMap<IconInfo, BufferedImage>();  // Images of all icons.
  private Map<Integer, CategoryDefinition> categoryDefinitionsMap = new HashMap<Integer, CategoryDefinition>();
  private EList<Integer> currentCategoryIds = new BasicEList<Integer>();
  private JCheckBox holdCheckBox;
  private JCheckBox applicabilityCheckBox;
  private JCheckBox extraTonsCheckBox;
  private JTextArea fullTextArea;
  private JTextArea summaryTextArea;
  private JPanel fieldsTextPanel;
  private Version trafficIncidentsVersion = null;
  private Date lastUpdateDate = null;
  private TrafficIncidentsListener primaryUpdateListener;
  private TrafficIncidentsListener updateListener = null;
  private TrafficIncidentsListener fullTextListener;
  private TrafficIncidentsListener summaryTextListener;
  private TrafficIncidentsListener fieldsListener;
  private JCheckBox allCategoriesCheckBox;
  private JList<ListCategoryDefinition> categoriesSelectionList;
  private JComboBox<String> languageSelectionBox;
  private JComboBox<String> languageCountrySelectionBox;
  private JComboBox<Integer> iconThemeSelectionBox;
  private JComboBox<ColorType> iconColorTypeSelectionBox;
  private JComboBox<IconDimension> iconDimensionSelectionBox;
  private JCheckBox nightTimeCheckbox;
  private JLabel iconSetPriorityOrderLabel;
  private JPanel statusPanel;
  private JLabel trafficIncidentFeedStatusLabel;
  private JLabel trafficIncidentsStatusLabel;
  DefaultTableModel feedInfoTableModel;
  private String currentLanguage;
  private String currentLanguageCountry;
  private JComboBox<LengthUnit> lengthUnitSelectionBox;
  private JComboBox<WeightUnit> weightUnitSelectionBox;
  private JTextField dateFormatTextField;
  private JTextField timeFormatTextField;
  
  static {
    for (TrafficIncidentField trafficIncidentField: TrafficIncidentField.values()) {
      trafficIncidentFields.add(trafficIncidentField);
    }
  }
  
  public TrafficInfoListDisplay(TrafficIncidents trafficIncidents) {
    super(TITLE_BODY + "<no version info available>");
    LOGGER.setLevel(Level.SEVERE);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.trafficIncidentsService = trafficIncidents;
    
    primaryUpdateListener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getVersionReply(Version trafficIncidentsVersion) {
        LOGGER.info("getVersionReply() called.");
        setTrafficIncidentsVersion(trafficIncidentsVersion);
        
        updateTitle();
        
        versionInfoObtained = true;
        
        // Only start the real work after we obtained the necessary information.
        if (readyToGo()  &&  (updateListener == null)) {
          updateListener = this;
          updateApplicabilitySetting();
          
          trafficIncidentsService.addUpdateListener(this, new BasicEList<WarningLevel>(), currentCategoryIds, this);
        }
      }

      @Override
      public void updates(EList<Integer> unchangedTrafficIncidentIds, EList<Integer> changedTrafficIncidentIds, EList<Integer> newTrafficIncidentIds, EList<Integer> deletedTrafficIncidentIds) {
        LOGGER.info("updates() called. unchangedTrafficIncidentIds = " + unchangedTrafficIncidentIds + ", changedTrafficIncidentIds = " + changedTrafficIncidentIds + ", newTrafficIncidentIds = " + newTrafficIncidentIds + ", deletedTrafficIncidentIds = " + deletedTrafficIncidentIds);
        
        EList<Integer> incidentIds = new BasicEList<>(unchangedTrafficIncidentIds);
        incidentIds.addAll(changedTrafficIncidentIds);
        incidentIds.addAll(newTrafficIncidentIds);
        
        LOGGER.info("New list of incidents = " + incidentIds);
        updateFullTextPaneStep1(incidentIds);
        updateSummaryTextPaneStep1(incidentIds);
        updateFieldsTextPaneStep1(incidentIds);
        lastUpdateDate = new Date();
        updateTitle();
      }
      
      @Override
      public void getLanguageReply(String languageCode, String countryCode) {
        LOGGER.info("getLanguageReply() called.");
        updateSelectedLanguage(languageCode, countryCode);
      }
      
      @Override
      public void trafficIncidentsStatus(
          TrafficIncidentFeedStatus trafficIncidentFeedStatus,
          TrafficIncidentsStatus trafficIncidentsStatus) {
        LOGGER.info("trafficIncidentsStatus() called.");
        updateStatusInfo(trafficIncidentFeedStatus, trafficIncidentsStatus);
      }

      @Override
      public void feedInformation(EList<FeedInformation> feedsInformation) {
        LOGGER.info("feedInformation() called.");
        updateFeedInfo(feedsInformation);
      }

      @Override
      public void getIconSetsReply(EList<IconSet> iconSets) {
        LOGGER.info("getIconSetsReply() called.");
        boolean obtainIconsFromTrafficIncidentsService = handleIconSets(iconSets);
        if (obtainIconsFromTrafficIncidentsService) {
          LOGGER.info("Calling getIconDefinitions()");
          trafficIncidentsService.getIconDefinitions(this, new BasicEList<IconInfo>());
        } else {
          iconDefinitionsObtained = true;
        }
        
        iconSetsObtained = true;
        
        // Only start the real work after we obtained the necessary information.
        if (readyToGo()  &&  (updateListener == null)) {
          updateListener = this;
          updateApplicabilitySetting();
          
          trafficIncidentsService.addUpdateListener(this, new BasicEList<WarningLevel>(), new BasicEList<Integer>(), this);
        }
      }

      @Override
      public void getIconDefinitionsReply(EList<IconDefinition> iconDefinitions) {
        LOGGER.info("getIconDefinitionsReply() called.");
        handleIconDefinitions(iconDefinitions);
        iconDefinitionsObtained = true;        
        
        // Only start the real work after we obtained the necessary information.
        if (readyToGo()  &&  (updateListener == null)) {
          updateListener = this;
          updateApplicabilitySetting();
          
          trafficIncidentsService.addUpdateListener(this, new BasicEList<WarningLevel>(), new BasicEList<Integer>(), this);
        }
      }

      @Override
      public void getCategoryDefinitionsReply(EList<CategoryDefinition> categoryDefinitions) {
        LOGGER.info("getCategoryDefinitionsReply() called.");
        handleCategoryDefinitions(categoryDefinitions);
        categoryDefinitionsObtained = true;      
        
        // Only start the real work after we obtained the necessary information.
        if (readyToGo()  &&  (updateListener == null)) {
          updateListener = this;
          updateApplicabilitySetting();
          
          trafficIncidentsService.addUpdateListener(this, new BasicEList<WarningLevel>(), new BasicEList<Integer>(), this);
        }
      }

      @Override
      public void addUpdateListenerReply() {
        LOGGER.info("addUpdateListenerReply() called.");
        // no action
      }

      @Override
      public void removeUpdateListenerReply() {
        LOGGER.info("Installing new updateListener");
        trafficIncidentsService.addUpdateListener(this, new BasicEList<WarningLevel>(), currentCategoryIds, this);
      }
    };
    
    fullTextListener = new DefaultTrafficIncidentsListener() {
      
      @Override
      public void getTextsReply(EList<String> texts) {
        LOGGER.info("getTextsReply() for Full Text called.");
        updateFullTextPaneStep2(texts);
      }
    };

    summaryTextListener = new DefaultTrafficIncidentsListener() {
            
      @Override
      public void getTextsReply(EList<String> texts) {
        LOGGER.info("getTextsReply() for Summary called.");
        updateSummaryTextPaneStep2(texts);
      }
    };
    
    fieldsListener = new DefaultTrafficIncidentsListener() {

      @Override
      public void getTrafficIncidentsReply(EList<TrafficIncident> trafficIncidents) {
        LOGGER.info("getTrafficIncidentsReply() called.");
        updateFieldsTextPaneStep2(trafficIncidents);
      }
      
    };
    
    init();
    
    pack();
    
    updateTitle();
    
    LOGGER.info("Calling getVersion()");
    trafficIncidents.getVersion(primaryUpdateListener);
    LOGGER.info("Calling getLanguage()");
    trafficIncidents.getLanguage(primaryUpdateListener);
    LOGGER.info("Calling getIconSets()");
    trafficIncidents.getIconSets(primaryUpdateListener);
    LOGGER.info("Calling getCategoryDefinitions()");
    trafficIncidents.getCategoryDefinitions(primaryUpdateListener);
    LOGGER.info("Calling addTrafficIncidentsStatusListener()");
    trafficIncidents.addTrafficIncidentsStatusListener(null, primaryUpdateListener);
    LOGGER.info("Calling addFeedInformationListener()");
    trafficIncidents.addFeedInformationListener(null, primaryUpdateListener);
  }

  protected void handleCategoryDefinitions(EList<CategoryDefinition> categoryDefinitions) {
    for (CategoryDefinition categoryDefinition: categoryDefinitions) {
      categoryDefinitionsMap.put(categoryDefinition.getCategoryId(), categoryDefinition);
    }
    
    updateCategoriesSelectionBox();
  }

  private void updateCategoriesSelectionBox() {
    DefaultListModel<ListCategoryDefinition> listModel = new DefaultListModel<>();
    for (CategoryDefinition categoryDefinition: categoryDefinitionsMap.values()) {
      listModel.addElement(new ListCategoryDefinition(categoryDefinition));
    }
    categoriesSelectionList.setSelectionInterval(0, listModel.getSize());
    categoriesSelectionList.setModel(listModel);
  }

  private boolean readyToGo() {
    LOGGER.info("In readyToGo: versionInfoObtained = " + versionInfoObtained + ", iconSetsObtained = " + iconSetsObtained + ", iconDefinitionsObtained = " + iconDefinitionsObtained + ", categoryDefinitionsObtained = " + categoryDefinitionsObtained);
   if (versionInfoObtained && iconSetsObtained &&
        iconDefinitionsObtained  &&  categoryDefinitionsObtained) {
     LOGGER.info("Ready to GO!");
   } else {
     LOGGER.info("Not yet ready to go");
   }
    return versionInfoObtained && iconSetsObtained &&
        iconDefinitionsObtained  &&  categoryDefinitionsObtained;
  }
  
  protected boolean handleIconSets(EList<IconSet> iconSets) {
    this.iconSets = iconSets;
    
    boolean obtainIconsFromTrafficIncidentsService = false;
    
    for (IconSet iconSet: iconSets) {
      for (IconDescriptor iconDescriptor: iconSet.getIconDescriptors()) {
        if (iconDescriptor.isSetUrl()) {
          readIconFromFile(iconSet.getIconSetId(), iconDescriptor);
        } else {
          obtainIconsFromTrafficIncidentsService = true;
        }
      }
    }
    
    updateIconSetControls();
    
    return obtainIconsFromTrafficIncidentsService;
  }
  
  private void updateIconSetControls() {
    determineIconThemes();
    updateIconThemeSelectionBox();
    determineIconColorTypes();
    updateIconColorTypeSelectionBox();
    determineIconDimensions();
    updateIconDimensionSelectionBox();
    determineDayNightSupport();
    updateNightTimeCheckbox();
    
    determineIconSetsOrder();
  }
  
  private void determineIconThemes() {
    iconThemes = new BasicEList<Integer>();
    
    for (IconSet iconSet: iconSets) {
      Integer themeId = iconSet.getThemeId();
      if (!iconThemes.contains(themeId)) {
        iconThemes.add(themeId);
      }
    }
  }
  
  private void updateIconThemeSelectionBox() {
    iconThemeSelectionBox.removeAllItems();
    
    for (Integer themeId: iconThemes) {
      iconThemeSelectionBox.addItem(themeId);
    }
    
    iconThemeSelectionBox.setSelectedIndex(0);
  }
  
  private void determineIconColorTypes() {
    iconColorTypes = new BasicEList<ColorType>();
    
    for (IconSet iconSet: iconSets) {
      ColorType colorType = iconSet.getColorType();
      if (!iconColorTypes.contains(colorType)) {
        iconColorTypes.add(colorType);
      }
    }
  }
  
  private void updateIconColorTypeSelectionBox() {
    iconColorTypeSelectionBox.removeAllItems();
    
    for (ColorType colorType: iconColorTypes) {
      iconColorTypeSelectionBox.addItem(colorType);
    }
    
    iconColorTypeSelectionBox.setSelectedIndex(0);
  }
  
  private void determineIconDimensions() {
    iconDimensions = new BasicEList<IconDimension>();
    
    for (IconSet iconSet: iconSets) {
      IconDimension iconDimension = iconSet.getDimension();
      if (!iconDimensions.contains(iconDimension)) {
        iconDimensions.add(iconDimension);
      }
    }
  }
  
  private void updateIconDimensionSelectionBox() {
    iconDimensionSelectionBox.removeAllItems();
    
    for (IconDimension iconDimension: iconDimensions) {
      iconDimensionSelectionBox.addItem(iconDimension);
    }
    
    iconDimensionSelectionBox.setSelectedIndex(0);
  }
  
  private void determineDayNightSupport() {
    dayTimeSupported = false;
    nightTimeSupported = false;
    
    for (IconSet iconSet: iconSets) {
      boolean isDayTimeIcon = iconSet.isDayTimeIcon();
      if (isDayTimeIcon) {
        dayTimeSupported = true;
      } else {
        nightTimeSupported = true;
      }
    }
  }
  
  private void updateNightTimeCheckbox() {
    if (dayTimeSupported  &&  nightTimeSupported) {
      nightTimeCheckbox.setEnabled(true);
      nightTimeCheckbox.setSelected(false);
    } else {
      nightTimeCheckbox.setEnabled(true);
      if (dayTimeSupported) {
        nightTimeCheckbox.setSelected(false);
      } else {
        nightTimeCheckbox.setSelected(true);
      }
    }
  }
   
  private void determineIconSetsOrder() {
    // Get latest values from controls
    Integer preferredIconThemeId = (Integer) iconThemeSelectionBox.getSelectedItem();
    ColorType preferredIconColorType = (ColorType) iconColorTypeSelectionBox.getSelectedItem();
    IconDimension preferredIconDimension = (IconDimension) iconDimensionSelectionBox.getSelectedItem();
    boolean dayTimePreferred = !nightTimeCheckbox.isSelected();

    
    iconSetsPriorityOrder = new BasicEList<Integer>();
   
    // Add icons: Start with specifying all properties, ..., end with all don't cares.
    iconSetOrderAddSets(preferredIconThemeId, preferredIconColorType,
        preferredIconDimension, dayTimePreferred);
    iconSetOrderAddSets(preferredIconThemeId, preferredIconColorType,
        preferredIconDimension, null);
    iconSetOrderAddSets(preferredIconThemeId, preferredIconColorType,
        null, null);
    iconSetOrderAddSets(null, preferredIconColorType,
        null, null);
    iconSetOrderAddSets(null, null,
        null, null);
    
    updateIconSetPriorityOrderLabel();
  }
  
  private void iconSetOrderAddSets(Integer themeId, ColorType colorType,
      IconDimension iconDimension, Boolean isDayTimeIcon) {
    EList<IconSet> iconSetsToAdd = getIconSets(themeId, colorType, iconDimension, isDayTimeIcon);
    
    for (IconSet iconSet: iconSetsToAdd) {
      Integer iconSetId = iconSet.getIconSetId();
      if (!iconSetsPriorityOrder.contains(iconSetId)) {
        iconSetsPriorityOrder.add(iconSetId);
      }
    }
  }
  
  private EList<IconSet> getIconSets(Integer themeId, ColorType colorType,
      IconDimension iconDimension, Boolean isDayTimeIcon) {
    EList<IconSet> filteredIconSets = new BasicEList<IconSet>();
    
    for (IconSet iconSet: iconSets) {
      if (((themeId == null)  ||  (iconSet.getThemeId() == themeId))  &&
          ((colorType == null)  ||  (iconSet.getColorType() == colorType))  &&
          ((iconDimension == null)  ||  (iconSet.getDimension() == iconDimension))  &&
          ((isDayTimeIcon == null)  ||  (iconSet.isDayTimeIcon() == isDayTimeIcon))) {
        filteredIconSets.add(iconSet);
      }
    }
    return filteredIconSets;
  }
  
  private void updateIconSetPriorityOrderLabel() {
    StringBuilder buf = new StringBuilder();
    boolean first = true;
    
    for (Integer iconSetId: iconSetsPriorityOrder) {
      if (!first) {
        buf.append(", ");
      } else {
        first = false;
      }
      buf.append(iconSetId);
    }
    
    iconSetPriorityOrderLabel.setText(buf.toString());
  }

  private void readIconFromFile(int iconSetId, IconDescriptor iconDescriptor) {    
    IconInfo iconInfo = iconsetFactory.createIconInfo();
    iconInfo.setIconSetId(iconSetId);
    iconInfo.setIconId(iconDescriptor.getIconId());
    
    File input = new File(iconDescriptor.getUrl());
    try {
      BufferedImage image = ImageIO.read(input);
      iconImages.put(iconInfo, image);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected void handleIconDefinitions(EList<IconDefinition> iconDefinitions) {
    for (IconDefinition iconDefinition: iconDefinitions) {
      IconData iconData = iconDefinition.getIconData();
      ByteArrayInputStream inputStream = new ByteArrayInputStream(iconData.getData());
      try {
        BufferedImage image = ImageIO.read(inputStream);
        iconImages.put(iconDefinition.getIconInfo(), image);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void setTrafficIncidentsVersion(Version trafficIncidentsVersion) {
    this.trafficIncidentsVersion = trafficIncidentsVersion;
  }


  private void init() {
    Container contentPane = getContentPane();

    // create control pane on the top.
    contentPane.add(createStatusAndControlPanel(), BorderLayout.NORTH);
    
    // create the 3 message text panels.
    JPanel incidentsPanel = new JPanel();
    incidentsPanel.setLayout(new BorderLayout());
    incidentsPanel.add(createFullTextPanel(), BorderLayout.NORTH);
    incidentsPanel.add(createSummaryTextPanel(), BorderLayout.CENTER);
    incidentsPanel.add(createFieldsTextPanel(), BorderLayout.SOUTH);
    contentPane.add(incidentsPanel, BorderLayout.CENTER);

    // call the update methods to get the text for 'no messages' in the panels.
    updateFullTextPaneStep1(null);
    updateSummaryTextPaneStep1(null);
    updateFieldsTextPaneStep1(null);
  }
  
  private JPanel createStatusAndControlPanel() {
    JPanel panel = new JPanel();
    panel.add(createCategoriesSelectionPanel());
    
    JPanel statusAndControlPanel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(statusAndControlPanel, BoxLayout.Y_AXIS);
    statusAndControlPanel.setLayout(boxLayout);
    
    statusAndControlPanel.add(createStatusPanel());
    statusAndControlPanel.add(createIconSetSelectionPanel());
    statusAndControlPanel.add(createUnitControlPanel());
    
    panel.add(statusAndControlPanel);
    
    return panel;
  }

  private JPanel createStatusPanel() {
    JPanel panel = new JPanel();
    
    panel.add(createHoldApplicabilityAndTrafficIncidentsStatusPanel());
    panel.add(createFeedInfoPanel());
    
    return panel;
  }
  
  private Component createHoldApplicabilityAndTrafficIncidentsStatusPanel() {
    JPanel panel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(boxLayout);
    
    panel.add(createHoldAndApplicabilityPanel());
    panel.add(createTrafficIncidentsStatusPanel());
    
    return panel;
  }

  private Component createHoldAndApplicabilityPanel() {
    JPanel panel = new JPanel();
    
    holdCheckBox = new JCheckBox("hold");
    panel.add(holdCheckBox);
    
    applicabilityCheckBox = new JCheckBox("applicability");
    applicabilityCheckBox.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        updateApplicabilitySetting();
      }
      
    });
    panel.add(applicabilityCheckBox);
    extraTonsCheckBox = new JCheckBox("Add " + AXLE_LOAD_EXTRA + "t to " + AXLE_LOAD_NORMAL + "t");
    extraTonsCheckBox.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        updateApplicabilitySetting();
      }
      
    });
    panel.add(extraTonsCheckBox);
    
    
    
    return panel;
  }

  protected void updateApplicabilitySetting() {
    String expressionString;
    
    if (applicabilityCheckBox.isSelected()) {
      BooleanExpression applicabilityFilterExpression;

      if (extraTonsCheckBox.isSelected()) {
        applicabilityFilterExpression = createApplicabilityExpression(1000 * (AXLE_LOAD_NORMAL + AXLE_LOAD_EXTRA));        
      } else {
        applicabilityFilterExpression = createApplicabilityExpression(1000 * AXLE_LOAD_NORMAL);
      }
      expressionString = applicabilityFilterExpression.toString();
      LOGGER.info("expressionString = " + expressionString);
    } else {
      expressionString = "";
    }
    
    LOGGER.info("Filter expression: " + expressionString);
    trafficIncidentsService.setApplicability(null, expressionString);
    applicabilityCheckBox.setToolTipText("Test" + NEW_LINE + "ok" + NEW_LINE + "last");
  }

  private Component createUnitControlPanel() {
    JPanel panel = new JPanel();
    
    panel.add(createLanguageSelectionsPanel());
    panel.add(createLengthUnitPanel());
    panel.add(createWeightUnitPanel());
    panel.add(createDateFormatPanel());
    panel.add(createTimeFormatPanel());
    
    return panel;
  }

  private Component createLengthUnitPanel() {
    JPanel panel = new JPanel();
    
    JLabel label = new JLabel("Length unit:");
    panel.add(label);
    
    lengthUnitSelectionBox = new JComboBox<>(LengthUnit.values());
    Dimension lengthUnitSelectionBoxDimension = new Dimension(75, 26);
    lengthUnitSelectionBox.setSize(lengthUnitSelectionBoxDimension);
    lengthUnitSelectionBox.setMaximumSize(lengthUnitSelectionBoxDimension);
    lengthUnitSelectionBox.setPreferredSize(lengthUnitSelectionBoxDimension);
    lengthUnitSelectionBox.setSelectedIndex(-1);
    lengthUnitSelectionBox.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        updateLengthUnit();
      }
      
    });
    panel.add(lengthUnitSelectionBox);
    
    return panel;
  }
  
  private void updateLengthUnit() {
    LengthUnit lengthUnit = (LengthUnit) lengthUnitSelectionBox.getSelectedItem();
    LOGGER.info("Setting length unit to: " + lengthUnit);
    trafficIncidentsService.setLengthUnit(null, lengthUnit);
  }

  private Component createWeightUnitPanel() {
    JPanel panel = new JPanel();
    
    JLabel label = new JLabel("Weight unit:");
    panel.add(label);
    
    weightUnitSelectionBox = new JComboBox<>(WeightUnit.values());
    Dimension weightUnitSelectionBoxDimension = new Dimension(75, 26);
    weightUnitSelectionBox.setSize(weightUnitSelectionBoxDimension);
    weightUnitSelectionBox.setMaximumSize(weightUnitSelectionBoxDimension);
    weightUnitSelectionBox.setPreferredSize(weightUnitSelectionBoxDimension);
    weightUnitSelectionBox.setSelectedIndex(-1);
    weightUnitSelectionBox.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        updateWeightUnit();
      }
      
    });
    panel.add(weightUnitSelectionBox);
    
    return panel;
  }
  
  private void updateWeightUnit() {
    WeightUnit weightUnit = (WeightUnit) weightUnitSelectionBox.getSelectedItem();
    LOGGER.info("Setting weight unit to: " + weightUnit);
    trafficIncidentsService.setWeightUnit(null, weightUnit);
  }

  private Component createDateFormatPanel() {
    JPanel panel = new JPanel();
    
    JLabel label = new JLabel("Date format:");
    panel.add(label);
    
    dateFormatTextField = new JTextField(6);
    dateFormatTextField.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        updateDateFormat();
      }
      
    });
    panel.add(dateFormatTextField);
    
    return panel;
  }
  
  private void updateDateFormat() {
    String dateFormat = dateFormatTextField.getText();
    LOGGER.info("Setting date format to: " + dateFormat);
    trafficIncidentsService.setDateFormat(null, dateFormat);
  }

  private Component createTimeFormatPanel() {
    JPanel panel = new JPanel();
    
    JLabel label = new JLabel("Time format:");
    panel.add(label);
    
    timeFormatTextField = new JTextField(6);
    timeFormatTextField.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        updateTimeFormat();
      }
      
    });
    panel.add(timeFormatTextField);
    
    return panel;
  }
  
  private void updateTimeFormat() {
    String timeFormat = timeFormatTextField.getText();
    LOGGER.info("Setting time format to: " + timeFormat);
    trafficIncidentsService.setTimeFormat(null, timeFormat);
  }
 

  private JPanel createCategoriesSelectionPanel() {
    JPanel panel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(boxLayout);
    
    JButton showExpressionsPanel = new JButton("Boolean Expressions");
    showExpressionsPanel.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
    	  showExpressionsPanel();        
      }
      
    });
    panel.add(showExpressionsPanel);
    
    JLabel label = new JLabel("Categories:");
    panel.add(label);
    
    allCategoriesCheckBox = new JCheckBox("All categories");
    allCategoriesCheckBox.setSelected(true);
    allCategoriesCheckBox.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        if (allCategoriesCheckBox.isSelected()) {
          categoriesSelectionList.setEnabled(false);
        } else {
          categoriesSelectionList.setEnabled(true);
        }
        handleCategorySelectionChanged();        
      }
      
    });
    panel.add(allCategoriesCheckBox);
   
    categoriesSelectionList = new JList<>();
    categoriesSelectionList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    categoriesSelectionList.setVisibleRowCount(-1);
    categoriesSelectionList.setEnabled(false);
    categoriesSelectionList.addListSelectionListener(new ListSelectionListener() {

      @Override
      public void valueChanged(ListSelectionEvent e) {
        handleCategorySelectionChanged();        
      }
    });
    JScrollPane listScroller = new JScrollPane(categoriesSelectionList);
    listScroller.setPreferredSize(new Dimension(100, 80));
    panel.add(listScroller);
    
    return panel;
  }
  
  protected void showExpressionsPanel() {
    String[] descriptions = new String[5];
    String[] expressions = new String[5];
    
    descriptions[0] = "applicability 3t";
    expressions[0] = createApplicabilityExpression(1000 * AXLE_LOAD_NORMAL).format("", "  ");

    descriptions[1] = "applicability 7t";
    expressions[1] = createApplicabilityExpression(1000 * (AXLE_LOAD_NORMAL + AXLE_LOAD_EXTRA)).format("", "  ");
    
    int index = 2;
    for (CategoryDefinition categoryDefinition: categoryDefinitionsMap.values()) {
      descriptions[index] = categoryDefinition.getLocalizedNames(1).getString();
      String expressionString = categoryDefinition.getExpression();
      BooleanExpression expression = FilterExprUtil.parseFilterExpression(expressionString);
      expressions[index] = expression.format("", "  ");
      index++;
    }
    
    BooleanExpressionsFrame booleanExpressionsFrame = new BooleanExpressionsFrame(descriptions, expressions);
    booleanExpressionsFrame.setVisible(true);
  }

  protected void handleCategorySelectionChanged() {
    LOGGER.info("=>");
    EList<Integer> selectedCategoryIds = new BasicEList<Integer>();
    
    if (allCategoriesCheckBox.isSelected()) {
      // selectedCategoryIds stays empty.
      LOGGER.info("allCategoriesCheckBox is selected, so empty category list");
    } else {
      int[] selectedIndices = categoriesSelectionList.getSelectedIndices();
      for (int i = 0; i < selectedIndices.length; i++) {
        ListCategoryDefinition listCategoryDefinition = categoriesSelectionList.getModel().getElementAt(selectedIndices[i]);
        LOGGER.info("Adding selected category Id: " + listCategoryDefinition.getCategoryDefinition().getCategoryId());
        selectedCategoryIds.add(listCategoryDefinition.getCategoryDefinition().getCategoryId());
      }
    }
    
    if (!selectedCategoryIds.equals(currentCategoryIds)) {
      currentCategoryIds = selectedCategoryIds;
      LOGGER.info("Going to remove updateListener: " + updateListener);
      trafficIncidentsService.removeUpdateListener(primaryUpdateListener, updateListener);
    }
    
    LOGGER.info("<=");
  }

  private JPanel createLanguageSelectionsPanel() {
    JPanel panel = new JPanel();
    
    JLabel label = new JLabel("UI Language:");
    panel.add(label);
    
    languageSelectionBox = new JComboBox<>(SUPPORTED_LANGUAGES);
    languageSelectionBox.setSelectedIndex(-1);
    languageSelectionBox.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        LOGGER.info("languageSelectionBox: actionPerformed");
        String selectedLanguage = (String) languageSelectionBox.getSelectedItem();
        LOGGER.info("languageSelectionBox: actionPerformed, currentLanguage = " + currentLanguage +  ", selectedLanguage = " + selectedLanguage);
        
        if (!selectedLanguage.equals(currentLanguage)) {
          currentLanguage = selectedLanguage;
          LOGGER.info("Calling setLanguage()");
          trafficIncidentsService.setLanguage(null, currentLanguage, currentLanguageCountry);
        } else {
          LOGGER.info("Same language selected, no action");
        }
        
      }
      
    });
    panel.add(languageSelectionBox);
    
    languageCountrySelectionBox = new JComboBox<>(SUPPORTED_COUNTRIES);
    languageCountrySelectionBox.setSelectedIndex(-1);
    languageCountrySelectionBox.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        LOGGER.info("languageCountrySelectionBox: actionPerformed");
        String selectedLanguageCountry = (String) languageCountrySelectionBox.getSelectedItem();
        if (selectedLanguageCountry.equals(NO_COUNTRY)) {
          selectedLanguageCountry = null;
        }
        LOGGER.info("languageCountrySelectionBox: actionPerformed, currentLanguageCountry = " + currentLanguageCountry +  ", selectedLanguageCountry = " + selectedLanguageCountry);
        
        if (!isRequestedLanguageCountry(selectedLanguageCountry)) {
          currentLanguageCountry = selectedLanguageCountry;
          LOGGER.info("Calling setLanguage()");
          trafficIncidentsService.setLanguage(null, currentLanguage, currentLanguageCountry);
        } else {
          LOGGER.info("Same country selected, no action");
        }
        
      }
      
    });
    panel.add(languageCountrySelectionBox);

    return panel;
  }
  
  private JPanel createIconSetSelectionPanel() {
    // Theme
    JPanel panel = new JPanel();
    
    JLabel label = new JLabel("Theme:");
    panel.add(label);
    
    iconThemeSelectionBox = new JComboBox<>();
    iconThemeSelectionBox.setSelectedIndex(-1);
    iconThemeSelectionBox.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        determineIconSetsOrder();
      }
      
    });
    panel.add(iconThemeSelectionBox);
    
    // Color type
    label = new JLabel("Color type:");
    panel.add(label);
    
    iconColorTypeSelectionBox = new JComboBox<>();
    iconColorTypeSelectionBox.setSelectedIndex(-1);
    iconColorTypeSelectionBox.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        determineIconSetsOrder();  
      }
      
    });
    panel.add(iconColorTypeSelectionBox);
    
    
    // Icon dimension
    label = new JLabel("Dimension:");
    panel.add(label);
    
    iconDimensionSelectionBox = new JComboBox<>();
    iconDimensionSelectionBox.setSelectedIndex(-1);
    iconDimensionSelectionBox.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        determineIconSetsOrder();
      }
      
    });
    panel.add(iconDimensionSelectionBox);
    
    // Night time
    nightTimeCheckbox = new JCheckBox("Night time");
    nightTimeCheckbox.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent arg0) {
        determineIconSetsOrder();
      }
      
    });
    panel.add(nightTimeCheckbox);
    
    
    // Calculated priority order
    label = new JLabel("IconSet priority order:");
    panel.add(label);
    
    iconSetPriorityOrderLabel = new JLabel("No icon sets available");
    panel.add(iconSetPriorityOrderLabel);
    
    return panel;
  }
  
  private JPanel createTrafficIncidentsStatusPanel() {
    statusPanel = new JPanel();
    
    GridLayout layout = new GridLayout(2, 2);
    statusPanel.setLayout(layout);
    statusPanel.setForeground(Color.ORANGE);
    
    JLabel label;
    
    label = new JLabel("Feed status: ");
    statusPanel.add(label);
    
    trafficIncidentFeedStatusLabel = new JLabel("INIT");
    statusPanel.add(trafficIncidentFeedStatusLabel);
    
    label = new JLabel("Traffic Incidents status: ");
    statusPanel.add(label);
    
    trafficIncidentsStatusLabel = new JLabel("init");
    statusPanel.add(trafficIncidentsStatusLabel);
    
    return statusPanel;
  }
  
  private JPanel createFeedInfoPanel() {
    JPanel feedInfoTablePanel = new JPanel();
    feedInfoTableModel = new DefaultTableModel(UNKOWN_FEED_INFO, FEED_INFO_TABLE_COLUMN_NAMES);
    JTable table = new JTable(feedInfoTableModel);
    table.setPreferredScrollableViewportSize(new Dimension(600, 40));
    table.setFillsViewportHeight(true);

    //Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(table);

    //Add the scroll pane to this panel.
    feedInfoTablePanel.add(scrollPane);

    return feedInfoTablePanel;
  }

  /**
   * Create a panel for the Full message texts.
   */
  private JPanel createFullTextPanel() {
    JPanel panel = new JPanel();
    
    panel.setBorder(BorderFactory.createTitledBorder("Full text"));
    
    fullTextArea = new JTextArea(8, 100);
    fullTextArea.setLineWrap(true);
    fullTextArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(fullTextArea);
    panel.add(scrollPane, BorderLayout.CENTER);
    
    return panel;
  }

  /**
   * Create a panel for the Summary messages texts.
   */
  private JPanel createSummaryTextPanel() {
    JPanel panel = new JPanel();
    
    panel.setBorder(BorderFactory.createTitledBorder("Summary text"));
    
    summaryTextArea = new JTextArea(6, 100);
    summaryTextArea.setLineWrap(true);
    summaryTextArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(summaryTextArea);
    panel.add(scrollPane, BorderLayout.CENTER);
    
    return panel;
  }

  /**
   * Create a panel for the texts created from the fields in a
   * Traffic Incident.
   */
  private JPanel createFieldsTextPanel() {
    fieldsTextPanel = new JPanel();
    fieldsTextPanel.setBorder(BorderFactory.createTitledBorder("Fields text"));
    return fieldsTextPanel;
  }
  
  /**
   * First step in updating the Full text panel:
   * - display a default text if there are no incidents
   * - otherwise send a request for the texts, with fullTextListener as listener.
   */
  private void updateFullTextPaneStep1(EList<Integer> incidentIds) {
    LOGGER.info("=>");
    if (incidentIds == null  ||  incidentIds.size() == 0) {
      LOGGER.info("<= No Traffic Incidents.");
      if (holdCheckBox.isSelected()) {
        return;
      }
      
      fullTextArea.setText("Nothing to report");
      return;
    }
    
    trafficIncidentsService.getTexts(fullTextListener, incidentIds, TextDetailLevel.FULL);
    LOGGER.info("<= Traffic Incidents.");
  }
  
  /**
   * Second step in updating the Full text panel:
   * - display the received texts.
   */
  private void updateFullTextPaneStep2(EList<String> texts) {
    if (holdCheckBox.isSelected()) {
      return;
    }
    
    StringBuilder buf = new StringBuilder();

    boolean first = true;
    for (String text: texts) {
      if (!first) {
        buf.append(NEW_LINE);
        buf.append(NEW_LINE);
      } else {
        first = false;
      }
      buf.append(text);
    }

    fullTextArea.setText(buf.toString());
    
    this.repaint();
  }
  
  
  /**
   * First step in updating the Summary text panel:
   * - display a default text if there are no incidents
   * - otherwise send a request for the texts, with summaryTextListener as listener.
   */
  private void updateSummaryTextPaneStep1(EList<Integer> incidentIds) {
    if (incidentIds == null  ||  incidentIds.size() == 0) {
      if (holdCheckBox.isSelected()) {
        return;
      }
      
      summaryTextArea.setText("Nothing to report");
      return;
    }
    
    trafficIncidentsService.getTexts(summaryTextListener, incidentIds, TextDetailLevel.SUMMARY);
  }
  
  
  /**
   * Second step in updating the Summary text panel:
   * - display the received texts.
   */
  private void updateSummaryTextPaneStep2(EList<String> texts) {
    if (holdCheckBox.isSelected()) {
      return;
    }
    
    StringBuilder buf = new StringBuilder();

    boolean first = true;
    for (String text: texts) {
      if (!first) {
        buf.append(NEW_LINE);
        buf.append(NEW_LINE);
      } else {
        first = false;
      }
      buf.append(text);
    }

    summaryTextArea.setText(buf.toString());
    
    repaint();
  }
  
  
  /**
   * First step in updating the Fields text panel:
   * - display a default text if there are no incidents
   * - otherwise send a request for the Traffic Incidents, with fieldsListener as listener.
   */
  private void updateFieldsTextPaneStep1(EList<Integer> incidentIds) {
    if ((incidentIds == null)  ||  (incidentIds.size() == 0)) {
      updateFieldsTextPaneStep2(null);
      return;
    }
    
    trafficIncidentsService.getTrafficIncidents(fieldsListener, incidentIds, true);
  }
  
  
  /**
   * Second step in updating the Summary text panel:
   * - display the information per field for each incident.
   */
  private void updateFieldsTextPaneStep2(EList<TrafficIncident> incidents) {
    if (holdCheckBox.isSelected()) {
      return;
    }
    
    fieldsTextPanel.removeAll();
    
    JPanel incidentsPanel = new JPanel();
    
    if (incidents != null) {
      LOGGER.info("incidents list in not null, number of incidents = " + incidents.size());
      BoxLayout boxLayout = new BoxLayout(incidentsPanel, BoxLayout.Y_AXIS);
      incidentsPanel.setLayout(boxLayout);
      for (TrafficIncident incident: incidents) {
        incidentsPanel.add(createIncidentPanel(incident));
      }
    } else {
      incidentsPanel.add(new JLabel("Nothing to report"));
    }
    JScrollPane scrollPane = new JScrollPane(incidentsPanel);
    Dimension dimension = new Dimension(1000, 400);
    scrollPane.setPreferredSize(dimension);
    fieldsTextPanel.add(scrollPane);
        
    fieldsTextPanel.revalidate();
    fieldsTextPanel.repaint();
  }
  
  private JPanel createIncidentPanel(TrafficIncident incident) {
    LOGGER.info("Creating panel for incident with Id: " + incident.getTrafficIncidentId());
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    
    panel.add(createTextFieldsPanel(incident), BorderLayout.CENTER);
    EList<Integer> categoryIds;
    categoryIds = incident.getCategoryIds();
    panel.add(createCategoriesPanel(categoryIds), BorderLayout.WEST);
    
    return panel;
  }

  private Component createTextFieldsPanel(TrafficIncident incident) {    
    StringBuilder buf = new StringBuilder();
    generateFieldsText(buf, incident);
    JTextArea textArea = new JTextArea(buf.toString());
    textArea.setEditable(false);
    
    return textArea;
  }

  private Component createCategoriesPanel(EList<Integer> categoryIds) {
    JPanel panel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(boxLayout);
    
    if (categoryIds.size() != 0) {
      for (int categoryId: categoryIds) {
        panel.add(createCategoryPanel(categoryId));
      }
    } else {
      panel.add(createCategoryPanel(-1));
    }
    
    return panel;
  }

  private Component createCategoryPanel(int categoryId) {
    JPanel panel = new JPanel();
    Dimension dimension = new Dimension(200, 50);
    panel.setMaximumSize(dimension);
    panel.setPreferredSize(dimension);
    
    panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

    panel.setLayout(new BorderLayout());
    
    if (categoryId != -1) {
      CategoryDefinition categoryDefinition = categoryDefinitionsMap.get(categoryId);
      
      // Add icon as CENTER
      // Create a map with icons related to the category, the set we have to chose from.
      Map<Integer, IconInfo> categoryIcons = new HashMap<Integer, IconInfo>();
      for (IconInfo iconInfo: categoryDefinition.getIcons()) {
        LOGGER.fine("Adding iconInfo to categoryIcons: iconSetId = " + iconInfo.getIconSetId() + ", iconId = " + iconInfo.getIconId());
        categoryIcons.put(iconInfo.getIconSetId(), iconInfo);
      }
      
      // In priority order, check which one is available for the category.
      IconInfo iconInfo = null;
      for (Integer iconSetId: iconSetsPriorityOrder) {
        LOGGER.fine("Looking for iconSetId: " + iconSetId);
        if (categoryIcons.containsKey(iconSetId)) {
          LOGGER.fine("Found it!");
          iconInfo = categoryIcons.get(iconSetId);
          break;
        }
      }
      if (iconInfo != null) {
        LOGGER.info("iconInfo: iconSetId = " + iconInfo.getIconSetId() + ", iconId = " + iconInfo.getIconId());
      } else {
        LOGGER.info("iconInfo: iconSetId = null!");
      }
      BufferedImage image = iconImages.get(iconInfo);
      panel.add(new ImagePanel(image), BorderLayout.CENTER);
      
      // Add category name as SOUTH
      // First search for language and country, then for language, then take first name
      String categoryName = null;
      for (LocalizedString localizedString: categoryDefinition.getLocalizedNames()) {
        if (isRequestedLocale(localizedString.getLanguageCode(), localizedString.getCountryCode())) {
          categoryName = localizedString.getString();
          LOGGER.info("Category name found for current language and country");
          break;
        }
      }
      if (categoryName == null) {
        for (LocalizedString localizedString: categoryDefinition.getLocalizedNames()) {
          if (isRequestedLanguage(localizedString.getLanguageCode())) {
            categoryName = localizedString.getString();
            LOGGER.info("Category name found for current language");
            break;
          }
        }
      }
      if (categoryName == null) {
        categoryName = categoryDefinition.getLocalizedNames(0).getString();
      }
      panel.add(new JLabel(categoryName), BorderLayout.SOUTH);
    } else {
      panel.add(new JLabel("No category"), BorderLayout.SOUTH);
    }
    
    return panel;
  }

  private boolean isRequestedLocale(String languageCode, String countryCode) {
    return isRequestedLanguage(languageCode)  &&  isRequestedLanguageCountry(countryCode);
  }

  private boolean isRequestedLanguage(String languageCode) {
    boolean returnValue = ((languageCode == null  &&  currentLanguage == null)  ||
        ((languageCode != null)  &&  (currentLanguage != null)  &&
            languageCode.equals(currentLanguage)));
    LOGGER.info("<=" + returnValue);
    return returnValue;
  }

  private boolean isRequestedLanguageCountry(String languageCountryCode) {
    boolean returnValue = ((languageCountryCode == null  &&  currentLanguageCountry == null)  ||
        ((languageCountryCode != null)  &&  (currentLanguageCountry != null)  &&
         languageCountryCode.equals(currentLanguageCountry)));
    LOGGER.info("<=" + returnValue);
    return returnValue;
  }

  /**
   * Generate text field information for a single incident.
   */
  private void generateFieldsText(StringBuilder buf, TrafficIncident trafficIncident) {
    LOGGER.info("Creating Fields Text for incident with Id: " + trafficIncident.getTrafficIncidentId());
    
    buf.append("General Information");
    
    buf.append(NEW_LINE);
    
    buf.append("\tEffect: ");
    String effect = trafficIncident.getEffectText();
    if (effect != null) {
      buf.append(effect);
    } else {
      buf.append("---");
    }
    buf.append(" (effectCode = ");
    if (trafficIncident.isSetEffectCode()) {
      buf.append(trafficIncident.getEffectCode());
      buf.append(" = ");
      buf.append(trafficIncident.getEffectCode().getValue());
    } else {
      buf.append("---");
    }
    buf.append(")");
    
    buf.append(NEW_LINE);
    
    buf.append("\tValidity Period: ");
    if (trafficIncident.isSetStartTime()) {
      buf.append(" from ");
      buf.append(DF.format(trafficIncident.getStartTime()));
    }
    if (trafficIncident.isSetStopTime()) {
      buf.append(" till ");
      buf.append(DF.format(trafficIncident.getStopTime()));
    }
    buf.append(NEW_LINE);
    
    buf.append("\tTendency: ");
    String tendency = trafficIncident.getTendencyText();
    if (tendency != null) {
      buf.append(tendency);
    } else {
      buf.append("---");
    }
    buf.append(" (tendency = ");
    if (trafficIncident.isSetTendency()) {
      buf.append(trafficIncident.getTendency());
      buf.append(" = ");
      buf.append(trafficIncident.getTendency().getValue());
    } else {
      buf.append("---");
    }
    buf.append(")");
    buf.append(NEW_LINE);
    
    buf.append("\tLength Affected: ");
    if (trafficIncident.isSetLengthAffected()) {
      buf.append(String.valueOf(trafficIncident.getLengthAffected()));
      buf.append(" meters");
    } else {
      buf.append("---");
    }
    
    buf.append(NEW_LINE);
    
    buf.append("\tAverage Speed: ");
    if (trafficIncident.isSetAverageSpeedAbsolute()) {
      buf.append(String.valueOf(trafficIncident.getAverageSpeedAbsolute()));
      buf.append(" m/s");
    } else {
      buf.append("---");
    }
    
    buf.append(NEW_LINE);
    
    buf.append("\tDelay: ");
    if (trafficIncident.isSetDelay()) {
      buf.append(String.valueOf(trafficIncident.getDelay()));
      buf.append(" minutes");
    } else {
      buf.append("---");
    }
    
    buf.append(NEW_LINE);
    
    buf.append("\tSpeed Limit: ");
    if (trafficIncident.isSetSegmentSpeedLimit()) {
      buf.append(String.valueOf(trafficIncident.getSegmentSpeedLimit()));
      buf.append(" m/s");
    } else {
      buf.append("---");
    }
    
    buf.append(NEW_LINE);
    
    buf.append("\tExpected Speed: ");
    if (trafficIncident.isSetExpectedSpeedAbsolute()) {
      buf.append(String.valueOf(trafficIncident.getExpectedSpeedAbsolute()));
      buf.append(" m/s");
    } else {
      buf.append("---");
    }
    
    buf.append(NEW_LINE);
    
    buf.append("Location: ");
    if (trafficIncident.isSetLocation()) {
      Location location = trafficIncident.getLocation();
      if (location instanceof PointLocation) {
        buf.append("point location");
      } else if (location instanceof LinearLocation) {
        buf.append("linear location");
        LinearLocation linearLocation = (LinearLocation) location;
        buf.append(", positive offet = ");
        buf.append(linearLocation.getPositiveOffset());
        buf.append(", negative offset = ");
        buf.append(linearLocation.getNegativeOffset());
        buf.append(", segments");
        for (Long segment: linearLocation.getSegments()) {
          buf.append(": ");
          buf.append(segment);
        }
      } else if (location instanceof AreaLocation) {
        buf.append("area location");
      }
    } else {
      buf.append("---");
    }
    
    buf.append(NEW_LINE);

    buf.append("Location Info: ");
    if (trafficIncident.isSetLocationInfo()) {
      LocationInfo locationInfo = trafficIncident.getLocationInfo();
      if (locationInfo instanceof PointLocationInfo) {
        buf.append("(point location) ");
        buf.append(locationInfo.getName());
      } else if (locationInfo instanceof LinearLocationInfo) {
        LinearLocationInfo linearLocationInfo = (LinearLocationInfo) locationInfo;
        buf.append("(linear location) ");
        buf.append(linearLocationInfo.getName());
        buf.append(": ");
        if (linearLocationInfo.getFromLocationParentName() != null  &&
            linearLocationInfo.getToLocationParentName() != null) {
          buf.append(linearLocationInfo.getFromLocationParentName());
          buf.append(" => ");
          buf.append(linearLocationInfo.getToLocationParentName());
          buf.append(" ");
        }
        buf.append("section: ");
        buf.append(linearLocationInfo.getFromLocationName());
        buf.append(" - ");
        buf.append(linearLocationInfo.getToLocationName());
      } else if (locationInfo instanceof AreaLocationInfo) {
        buf.append("(area location) ");
        buf.append(locationInfo.getName());
      }
    } else {
      buf.append("---");
    }
    
    buf.append(NEW_LINE);

    buf.append("Cause texts");    
    buf.append(NEW_LINE);
    
    List<String> causes = trafficIncident.getCauseTexts();
    for (String cause: causes) {
      buf.append("\tCause: ");
      buf.append(cause);
      buf.append(NEW_LINE);
    }
    
    buf.append("Cause model data");
    buf.append(NEW_LINE);
    for (Cause cause: trafficIncident.getCauses()) {
      buf.append("mainCause = " + cause.getMainCause() + " = " + cause.getMainCause().getValue());
      if (cause instanceof DirectCause) {
        buf.append(", direct cause, ");
        DirectCause directCause = (DirectCause) cause;
        buf.append(", warning level = " + directCause.getWarningLevel() + " = " + directCause.getWarningLevel().getValue());
        if (directCause.isUnverifiedInformation()) {
          buf.append(", unverified information");
        } else {
          buf.append(", verified information");
        }
        buf.append(", sub cause = ");
        if (directCause.isSetSubCause()) {
          buf.append(directCause.getSubCause());
        } else {
          buf.append("---");
        }
        buf.append(", length affected = ");
        if (directCause.isSetLengthAffected()) {
        buf.append(directCause.getLengthAffected());
        } else {
          buf.append("---");
        }
        buf.append(", lane restrictions: ");
        if (directCause.isSetLaneRestrictions()) {
          LaneRestrictions laneRestrictions = directCause.getLaneRestrictions();
          buf.append("type = " + laneRestrictions.getLaneRestrictionType() + " = " + laneRestrictions.getLaneRestrictionType().getValue());
          buf.append("; number of lanes = " + laneRestrictions.getNumberOfLanes());
        } else {
          buf.append("---");
        }
        buf.append(", free text = " );
        if (directCause.isSetFreeText()) {
          buf.append(directCause.getFreeText());
        } else {
          buf.append("---");
        }
      } else if (cause instanceof LinkedCause) {
        buf.append(", linked cause, ");
        LinkedCause linkedCause = (LinkedCause) cause;
        buf.append(" trafficIncidentId = ");
        buf.append(linkedCause.getCauseTrafficIncidentId());
      }
      buf.append(NEW_LINE);
    }

    buf.append("Advices");
    buf.append(NEW_LINE);
    
    buf.append("Advice model data");
    buf.append(NEW_LINE);
    for (Advice advice: trafficIncident.getAdvices()) {
      buf.append("mainAdvice = " + advice.getMainAdvice() + " = " + advice.getMainAdvice().getValue());
      buf.append(", sub advice = ");
      if (advice.isSetSubAdvice()) {
        buf.append(advice.getSubAdvice());
      } else {
        buf.append("---");
      }
      buf.append(", free text = " );
      if (advice.isSetFreeText()) {
        buf.append(advice.getFreeText());
      } else {
        buf.append(" ---");
      }
      buf.append(", applicability =" );
      if (advice.isSetApplicability()) {
        bufAppendApplicability(buf, advice.getApplicability());
      } else {
        buf.append(" ---");
      }
      buf.append(NEW_LINE);
    }

    
    List<String> advices = trafficIncident.getAdviceTexts();
    for (String advice: advices) {
      buf.append("\tAdvice: ");
      buf.append(advice);
      buf.append(NEW_LINE);
    }
    

    buf.append("Applicability");
    buf.append(NEW_LINE);
      
    List<String> applicabilityList = trafficIncident.getApplicabilityTexts();
    for (String applicability: applicabilityList) {
      buf.append("\tApplicability: ");
      buf.append(applicability);
      buf.append(NEW_LINE);
    }
    
    buf.append("Applicability from data model");
    if (trafficIncident.isSetApplicability()) {
      bufAppendApplicability(buf, trafficIncident.getApplicability());
    } else {
      buf.append(" ---");
    }  
    buf.append(NEW_LINE);
  }
  
  private void bufAppendApplicability(StringBuilder buf, List<Applicability> applicabilities) {
    for (Applicability applicability: applicabilities) {
      buf.append(" vehicle type = ");
      buf.append(applicability.getVehicleType());
      buf.append(" = ");
      buf.append(applicability.getVehicleType().getValue());
      
      buf.append("; vehicle related restrictions: ");
      if (applicability.isSetVehicleRelatedRestrictions()) {
        bufAppendVehicleRelatedRestrictions(buf, applicability.getVehicleRelatedRestrictions());
      } else {
        buf.append("---");
      }
    }
  }

  private void bufAppendVehicleRelatedRestrictions(StringBuilder buf, List<VehicleRelatedRestriction> vehicleRelatedRestrictions) {
   for (VehicleRelatedRestriction restriction: vehicleRelatedRestrictions) {
      buf.append("restriction type = ");
      buf.append(restriction.getRestrictionType());
      buf.append(" = ");
      buf.append(restriction.getRestrictionType().getValue());
      buf.append("; restriction type = ");
      buf.append(restriction.getRestrictionValue());
    }
    
  }

  /**
   * Update the title of the Frame.
   */
  private void updateTitle() {
    // Create and display title, using the version received from trafficIncidentsService.
    StringBuilder title = new StringBuilder();
    title.append(TITLE_BODY);
    
    if (trafficIncidentsVersion != null) {
    title.append(String.valueOf(trafficIncidentsVersion.getMajor()));
    title.append(".");
    title.append(String.valueOf(trafficIncidentsVersion.getMinor()));
    title.append(".");
    title.append(String.valueOf(trafficIncidentsVersion.getMicro()));
    title.append(" ");
    title.append(trafficIncidentsVersion.getDate());
    } else {
      title.append("<no version info available>");
    }
    
    title.append(", last updated: ");
    if (lastUpdateDate != null) {
      title.append(DF.format(lastUpdateDate));
    } else {
      title.append("<nothing received yet>");
    }
    title.append(")");
    setTitle(title.toString());
  }
  
  private void updateSelectedLanguage(String languageCode, String languageCountryCode) {
    currentLanguage = languageCode;
    currentLanguageCountry = languageCountryCode;
    
    String selectedLanguage = (String) languageSelectionBox.getSelectedItem();
    if (selectedLanguage != null) {
      if (!selectedLanguage.equals(currentLanguage)) {
        languageSelectionBox.setSelectedItem(currentLanguage);
      }
    } else {
      languageSelectionBox.setSelectedItem(currentLanguage);
    }
    
    String selectedLanguageCountry = (String) languageCountrySelectionBox.getSelectedItem();
    if (selectedLanguageCountry != null) {
      if (!selectedLanguageCountry.equals(currentLanguageCountry)) {
        if (currentLanguageCountry != null) {
          languageCountrySelectionBox.setSelectedItem(currentLanguageCountry);
        } else {
          languageCountrySelectionBox.setSelectedItem(NO_COUNTRY);
        }
      }
    } else {
      if (currentLanguageCountry != null) {
        languageCountrySelectionBox.setSelectedItem(currentLanguageCountry);
      } else {
        languageCountrySelectionBox.setSelectedItem(NO_COUNTRY);
      }
    }
  }
  
  private void updateStatusInfo(TrafficIncidentFeedStatus trafficIncidentFeedStatus, TrafficIncidentsStatus trafficIncidentsStatus) {
    trafficIncidentFeedStatusLabel.setText(trafficIncidentFeedStatus.getName());
    trafficIncidentsStatusLabel.setText(trafficIncidentsStatus.getName());
    
    Color backgroundColor = null;
    if (trafficIncidentFeedStatus == TrafficIncidentFeedStatus.UNAVAILABLE) {
      backgroundColor = Color.LIGHT_GRAY;
    } else {
      switch (trafficIncidentsStatus) {
      case AVAILABLE:
        backgroundColor = Color.GREEN;
        break;
        
      case PARTLY_AVAILABLE:
        backgroundColor = Color.ORANGE;
        break;
        
      case UNAVAILABLE:
        backgroundColor = Color.RED;
        break;
      }
    }
    statusPanel.setBackground(backgroundColor);
  }

  protected void updateFeedInfo(EList<FeedInformation> feedsInformation) {
    feedInfoTableModel.setRowCount(feedsInformation.size());
    int row = 0;
    for (FeedInformation feedInformation: feedsInformation) {
      if (feedInformation.getDataProviderName() != null) {
        feedInfoTableModel.setValueAt(feedInformation.getDataProviderName(), row, 0);
      } else {
        feedInfoTableModel.setValueAt("-", row, 0);
      }
      if (feedInformation.getProtocolName() != null) {
        feedInfoTableModel.setValueAt(feedInformation.getProtocolName(), row, 1);
      } else {
        feedInfoTableModel.setValueAt("-", row, 1);
      }
      if (feedInformation.getCommunicationChannelName() != null) {
        feedInfoTableModel.setValueAt(feedInformation.getCommunicationChannelName(), row, 2);
      } else {
        feedInfoTableModel.setValueAt("-", row, 2);
      }
      if (feedInformation.getFeedStatus() != null) {
        feedInfoTableModel.setValueAt(feedInformation.getFeedStatus().getName(), row, 3);
      } else {
        feedInfoTableModel.setValueAt("-", row, 3);
      }
      if (feedInformation.getTrafficIncidentsStatus() != null) {
        feedInfoTableModel.setValueAt(feedInformation.getTrafficIncidentsStatus().getName(), row, 4);
      } else {
        feedInfoTableModel.setValueAt("-", row, 4);
      }
      row++;
    }
  }
  
  /**
   * When does the statement isApplicable() evaluate to true?
   * 
   * If there is no Applicability, it is applicable to all cars.
   * If there is one Applicability, it is applicable to cars matching the Applicability.
   * If there is more than one Applicability this should be interpreted as:
   * - for cars matching Applicability-1
   * - and for cars matching Applicability-2
   * - and ....
   * - and for cars matching Applicability-n.
   * 
   * In a logical expression this is:
   * - there is no Applicability
   * - OR
   *   - vehicle parameters match Applicability-1
   *   - OR vehicle parameters match Applicability-2
   *   - OR ..
   *   - OR vehicle parameters match Applicability-n.
   *   
   * Or isApplicable() is true if:
   * - there is no Applicability
   * - OR ANY Applicability matches the vehicle parameters
   * 
   * An Applicability matches the vehicle parameters:
   * - if Applicability contains a vehicleType AND
   *      vehicleType matches the carVehicleType
   * - AND the VehicleRelatedRestrictions match
   *  
   * VehicleRelatedRestrictions match if:
   * - if there are no VehicleRelatedRestrictions
   * - OR each VehicleRelatedRestriction matches the related car parameter
   * 
   * How to handle unknown car parameters?
   * E.g. what if the car type or weight is unknown.
   * In this case the application has to chose between:
   * - false positives
   *   Incidents which aren't applicable are treated as applicable.
   *   This is achieved by defining the test related to an unknown parameter to always be true.
   * - false negatives
   *   Incidents which are applicable aren't treated as applicable.
   *   This is achieved by defining the test related to an unknown parameter to always be false.
   * It is advised to go for false positives.
   * 
   * This description shows that it will be simpler to define the isNotApplicable expression (so the expression for the incidents
   * to be filtered out).
   * 
   * When does the statement isNotApplicable() evaluate to true?
   * 
   * isNotApplicable() is true if:
   * - there is at least one Applicability
   * - AND all Applicabilities don't match the vehicle parameters.
   * 
   * An Applicability doesn't match the vehicle parameters:
   * - if Applicability contains a vehicleType AND
   *      vehicleType doesn't match the carVehicleType
   * - OR the VehicleRelatedRestrictions don't match
   *   
   * VehicleRelatedRestrictions don't match if:
   * - any VehicleRelatedRestriction doesn't match the related car parameter
   * 
   * Using false positives this changes to:
   * 
   * An Applicability doesn't match the vehicle parameters:
   * - if carVehicleType is known AND
   *      Applicability contains a vehicleType AND
   *      vehicleType doesn't match the carVehicleType
   * - OR the VehicleRelatedRestrictions don't match
   *   
   * VehicleRelatedRestrictions don't match if:
   * - any VehicleRelatedRestriction related to a known car parameter doesn't match this parameter
   * 
   * 
   * This method creates an ApplicabilityExpression for:
   * - Vehicle type: LORRY
   * - AXLE_LOAD: 7000 kg (7 tonnes)
   * - False positives for all other parameters.
   * 
   * ApplicabilityExpression := applicabilitySpecified AND ALL ApplicabilityDoesntMatchTheVehicleParameters
   * ApplicabilityExpression := ALL ApplicabilityDoesntMatchTheVehicleParameters
   * ApplicabilityDoesntMatchTheVehicleParameters := VehicleTypeDoesntMatch OR VehicleRelatedRestrictionsDontMatch
   * VehicleTypeDoesntMatch := vehicleTypeIsSet AND vehicleType != LORRY
   * VehicleRelatedRestrictionsDontMatch := ANY VehicleRelatedRestrictionDoesntMatch
   * VehicleRelatedRestrictionDoesntMatch := AxleLoadNotLessThan7t OR AxleLoadNotGreaterThan7t
   * AxleLoadNotLessThan7t := restrictionType == AXLE_LOAD_LESS_THAN AND restrictionValue < 7000
   * AxleLoadNotGreaterThan7t := restrictionType == AXLE_LOAD_GREATER_THAN AND restrictionValue > 7000
   * @param axleLoad 
   * 
   * @return
   */
  private BooleanExpression createApplicabilityExpression(long axleLoad) {
    ClassAttribute restrictionType;
              
    // AxleLoadGreaterThan7t := restrictionType == AXLE_LOAD_GREATER_THAN AND restrictionValue > 7000
    // Comparison Predicate: restrictionType == AXLE_LOAD_GREATER_THAN
    ComparisonPredicate restrictionTypeIsAxleLoadGreaterThan = FILTER_EXPR_FACTORY.createComparisonPredicate();
    restrictionType = FILTER_EXPR_FACTORY.createClassAttribute();
    restrictionType.setAttributeName(tip.getVehicleRelatedRestriction_RestrictionType().getName());
    restrictionTypeIsAxleLoadGreaterThan.setAttribute(restrictionType);
    restrictionTypeIsAxleLoadGreaterThan.setComparisonOperator(ComparisonOperator.EQUAL);
    SignedIntegerLiteral restrictionTypeGreaterThanEnumValue = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    restrictionTypeGreaterThanEnumValue.setValue(RestrictionType.AXLE_LOAD_GREATER_THAN.getValue());
    restrictionTypeIsAxleLoadGreaterThan.setLiteral(restrictionTypeGreaterThanEnumValue);
    
    // Comparison Predicate: restrictionValue > 7000
    ComparisonPredicate restrictionValueGreaterThan7t = FILTER_EXPR_FACTORY.createComparisonPredicate();
    ClassAttribute restrictionValue = FILTER_EXPR_FACTORY.createClassAttribute();
    restrictionValue.setAttributeName(tip.getVehicleRelatedRestriction_RestrictionValue().getName());
    restrictionValueGreaterThan7t.setAttribute(restrictionValue);
    restrictionValueGreaterThan7t.setComparisonOperator(ComparisonOperator.GREATER_THEN);
    SignedIntegerLiteral literal7t = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    literal7t.setValue(axleLoad);
    restrictionValueGreaterThan7t.setLiteral(literal7t);
    
    // Dyadic Expression: restrictionType == AXLE_LOAD_GREATER_THAN AND restrictionValue > 7000
    DyadicExpression axleLoadGreaterThan7t = FILTER_EXPR_FACTORY.createDyadicExpression();
    axleLoadGreaterThan7t.setLeftHandTerm(restrictionTypeIsAxleLoadGreaterThan);
    axleLoadGreaterThan7t.setLogicalOperator(DyadicLogicalOperator.AND);
    axleLoadGreaterThan7t.setRightHandTerm(restrictionValueGreaterThan7t);
   

    // AxleLoadNotLessThan7t := restrictionType == AXLE_LOAD_LESS_THAN AND restrictionValue < 7000
    // Comparison Predicate: restrictionType == AXLE_LOAD_LESS_THAN
    ComparisonPredicate restrictionTypeIsAxleLoadLessThan = FILTER_EXPR_FACTORY.createComparisonPredicate();
    restrictionType = FILTER_EXPR_FACTORY.createClassAttribute();
    restrictionType.setAttributeName(tip.getVehicleRelatedRestriction_RestrictionType().getName());
    restrictionTypeIsAxleLoadLessThan.setAttribute(restrictionType);
    restrictionTypeIsAxleLoadLessThan.setComparisonOperator(ComparisonOperator.EQUAL);
    SignedIntegerLiteral restrictionTypeEnumValue = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    restrictionTypeEnumValue.setValue(RestrictionType.AXLE_LOAD_LESS_THAN.getValue());
    restrictionTypeIsAxleLoadLessThan.setLiteral(restrictionTypeEnumValue);
    
    // Comparison Predicate: restrictionValue < 7000
    ComparisonPredicate restrictionValueLessThan7t = FILTER_EXPR_FACTORY.createComparisonPredicate();
    restrictionValue = FILTER_EXPR_FACTORY.createClassAttribute();
    restrictionValue.setAttributeName(tip.getVehicleRelatedRestriction_RestrictionValue().getName());
    restrictionValueLessThan7t.setAttribute(restrictionValue);
    restrictionValueLessThan7t.setComparisonOperator(ComparisonOperator.LESS_THAN);
    literal7t = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    literal7t.setValue(axleLoad);
    restrictionValueLessThan7t.setLiteral(literal7t);
    
    // Dyadic Expression: restrictionType == AXLE_LOAD_LESS_THAN AND restrictionValue < 7000
    DyadicExpression axleLoadLessThan7t = FILTER_EXPR_FACTORY.createDyadicExpression();
    axleLoadLessThan7t.setLeftHandTerm(restrictionTypeIsAxleLoadLessThan);
    axleLoadLessThan7t.setLogicalOperator(DyadicLogicalOperator.AND);
    axleLoadLessThan7t.setRightHandTerm(restrictionValueLessThan7t);
   
    // VehicleRelatedRestrictionDoesntMatch := AxleLoadLessThan7t OR AxleLoadGreaterThan7t
    // Dyadic Expression: ((restrictionType == AXLE_LOAD_LESS_THAN AND restrictionValue < 7000) ||
    //                     (restrictionType == AXLE_LOAD_GREATER_THAN AND restrictionValue > 7000))
    DyadicExpression axleLoadLessThan7tOrAxleLoadGreaterThan7t = FILTER_EXPR_FACTORY.createDyadicExpression();
    axleLoadLessThan7tOrAxleLoadGreaterThan7t.setLeftHandTerm(axleLoadLessThan7t);
    axleLoadLessThan7tOrAxleLoadGreaterThan7t.setLogicalOperator(DyadicLogicalOperator.OR);
    axleLoadLessThan7tOrAxleLoadGreaterThan7t.setRightHandTerm(axleLoadGreaterThan7t);
    
    
    // Sub Class Predicate: Applicability: (isSet(vehicle type) AND vehicle type != LORRY) ||
    //                                     (restrictionType == AXLE_LOAD_LESS_THAN AND restrictionValue < 7000) ||
    //                                     (restrictionType == AXLE_LOAD_GREATER_THAN AND restrictionValue > 7000)    

    // VehicleRelatedRestrictionsDontMatch := ANY VehicleRelatedRestrictionDoesntMatch
    MultiplicityPredicate vehicleRelatedRestrictionsDontMatch = FILTER_EXPR_FACTORY.createMultiplicityPredicate();
    vehicleRelatedRestrictionsDontMatch.setListOperator(ListOperator.ANY);
    ClassAttribute vehicleRelatedRestrictions = FILTER_EXPR_FACTORY.createClassAttribute();
    vehicleRelatedRestrictions.setAttributeName(tip.getApplicability_VehicleRelatedRestrictions().getName());
    vehicleRelatedRestrictionsDontMatch.setAttribute(vehicleRelatedRestrictions);
    vehicleRelatedRestrictionsDontMatch.setExpression(axleLoadLessThan7tOrAxleLoadGreaterThan7t);
    
    ClassAttribute vehicleType;
    // VehicleTypeDoesntMatch := isSet(vehicle type) AND vehicleType != LORRY
    
    // Is Set Predicate: isSet(vehicle type)
    vehicleType = FILTER_EXPR_FACTORY.createClassAttribute();
    vehicleType.setAttributeName(tip.getApplicability_VehicleType().getName());
    IsSetPredicate vehicleTypeIsSet = FILTER_EXPR_FACTORY.createIsSetPredicate();
    vehicleTypeIsSet.setAttribute(vehicleType);
    
    // Comparison Predicate: vehicle type != LORRY
    ComparisonPredicate vehicleTypeNotLorry = FILTER_EXPR_FACTORY.createComparisonPredicate();
    vehicleType = FILTER_EXPR_FACTORY.createClassAttribute();
    vehicleType.setAttributeName(tip.getApplicability_VehicleType().getName());
    vehicleTypeNotLorry.setAttribute(vehicleType);
    vehicleTypeNotLorry.setComparisonOperator(ComparisonOperator.NOT_EQUAL);
    SignedIntegerLiteral lorryEnumValue = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    lorryEnumValue.setValue(VehicleType.LORRY.getValue());
    vehicleTypeNotLorry.setLiteral(lorryEnumValue);
    
    // Dyadic Expression: isSet(vehicle type) AND vehicle type != LORRY
    DyadicExpression vehicleTypeIsSetAndNotLorry = FILTER_EXPR_FACTORY.createDyadicExpression();
    vehicleTypeIsSetAndNotLorry.setLeftHandTerm(vehicleTypeIsSet);
    vehicleTypeIsSetAndNotLorry.setLogicalOperator(DyadicLogicalOperator.AND);
    vehicleTypeIsSetAndNotLorry.setRightHandTerm(vehicleTypeNotLorry);
   
    
    
    // ApplicabilityDoesntMatchTheVehicleParameters := VehicleTypeDoesntMatch OR VehicleRelatedRestrictionsDontMatch
    // Dyadic Expression: (isSet(vehicle type) AND vehicle type != LORRY) ||
    //                    ((restrictionType == AXLE_LOAD_LESS_THAN AND restrictionValue < 7000) ||
    //                    (restrictionType == AXLE_LOAD_GREATER_THAN AND restrictionValue > 7000))
    DyadicExpression notLorryAndAxleLoad = FILTER_EXPR_FACTORY.createDyadicExpression();
    notLorryAndAxleLoad.setLeftHandTerm(vehicleTypeIsSetAndNotLorry);
    notLorryAndAxleLoad.setLogicalOperator(DyadicLogicalOperator.OR);
    notLorryAndAxleLoad.setRightHandTerm(vehicleRelatedRestrictionsDontMatch);
    
    // Sub Class Predicate: Applicability: (isSet(vehicle type) AND vehicle type != LORRY) ||
    //                                     (restrictionType == AXLE_LOAD_LESS_THAN AND restrictionValue < 7000) ||
    //                                     (restrictionType == AXLE_LOAD_GREATER_THAN AND restrictionValue > 7000)
    
    ClassAttribute applicabilityAttribute;
    
    // ApplicabilityExpression := ALL ApplicabilityDoesntMatchTheVehicleParameters
    // Multiplicity Predicate: ALL (Applicability: (isSet(vehicle type) AND vehicle type != LORRY) ||
    //                                             (restrictionType == AXLE_LOAD_LESS_THAN AND restrictionValue < 7000) ||
    //                                             (restrictionType == AXLE_LOAD_GREATER_THAN AND restrictionValue > 7000))
    MultiplicityPredicate allApplicabilityNotLorryAndAxleLoad = FILTER_EXPR_FACTORY.createMultiplicityPredicate();
    allApplicabilityNotLorryAndAxleLoad.setListOperator(ListOperator.ALL);
    applicabilityAttribute = FILTER_EXPR_FACTORY.createClassAttribute();
    applicabilityAttribute.setAttributeName(tip.getTrafficIncident_Applicability().getName());
    allApplicabilityNotLorryAndAxleLoad.setAttribute(applicabilityAttribute);
    allApplicabilityNotLorryAndAxleLoad.setExpression(notLorryAndAxleLoad);
    
    // ApplicabilitySpecified := COUNT(applicability) > 0
    // Multiplicity Predicate: LIST (COUNT > 0)
    
    applicabilityAttribute = FILTER_EXPR_FACTORY.createClassAttribute();
    applicabilityAttribute.setAttributeName(tip.getTrafficIncident_Applicability().getName());
    applicabilityAttribute.setMetaOperator(MetaOperator.SIZE);

    ComparisonPredicate applicabilityListSizeGreaterThan0 = FILTER_EXPR_FACTORY.createComparisonPredicate();
    applicabilityListSizeGreaterThan0.setAttribute(applicabilityAttribute);
    applicabilityListSizeGreaterThan0.setComparisonOperator(ComparisonOperator.GREATER_THEN);
    SignedIntegerLiteral zeroValue = FILTER_EXPR_FACTORY.createSignedIntegerLiteral();
    zeroValue.setValue(0l);
    applicabilityListSizeGreaterThan0.setLiteral(zeroValue);

    DyadicExpression isNotApplicable = FILTER_EXPR_FACTORY.createDyadicExpression();
    isNotApplicable.setLeftHandTerm(applicabilityListSizeGreaterThan0);
    isNotApplicable.setLogicalOperator(DyadicLogicalOperator.AND);
    isNotApplicable.setRightHandTerm(allApplicabilityNotLorryAndAxleLoad);
    
    return isNotApplicable;
  }
  
  private class ListCategoryDefinition {
    CategoryDefinition categoryDefinition;
    
    public ListCategoryDefinition(CategoryDefinition categoryDefinition) {
      this.categoryDefinition = categoryDefinition;
    }
    
    public CategoryDefinition getCategoryDefinition() {
      return categoryDefinition;
    }

    public String toString() {
      LOGGER.fine("toString => currentLanguage = " + currentLanguage);
      String categoryName = null;
      
      for (LocalizedString localizedString: categoryDefinition.getLocalizedNames()) {
        if (localizedString.getLanguageCode().equals(currentLanguage)  &&
            (localizedString.getCountryCode() == null  ||
            localizedString.getCountryCode().equals(currentLanguageCountry))) {
          categoryName = localizedString.getString();
          LOGGER.fine("Category name found for current language and country");
          break;
        }
      }
      
      if (categoryName == null) {
        for (LocalizedString localizedString: categoryDefinition.getLocalizedNames()) {
          if (localizedString.getLanguageCode().equals(currentLanguage)) {
            categoryName = localizedString.getString();
            LOGGER.fine("Category name found for current language");
            break;
          }
        }
      }
      
      if (categoryName == null) {
        LOGGER.fine("Using default (first) language.");
        categoryName = categoryDefinition.getLocalizedNames(0).getString();
      }
      
      LOGGER.fine("toString <=");
      return categoryName;
    }
  }
}
