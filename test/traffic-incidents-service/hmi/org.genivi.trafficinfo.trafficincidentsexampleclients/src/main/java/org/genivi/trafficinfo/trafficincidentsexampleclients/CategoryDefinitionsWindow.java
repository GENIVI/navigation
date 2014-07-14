/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentsexampleclients;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.eclipse.emf.common.util.EList;
import org.genivi.common.LocalizedString;
import org.genivi.iconset.IconData;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconDescriptor;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.iconset.IconsetFactory;
import org.genivi.trafficincidentsservice.CategoryDefinition;

@SuppressWarnings("serial")
public class CategoryDefinitionsWindow extends JFrame {
  private static final String NEW_LINE = System.getProperty("line.separator");
  private static final IconsetFactory ICON_SET_FACTORY = IconsetFactory.eINSTANCE;

  private boolean useIconFiles = false;
  private Map<IconInfo, IconDefinition> iconDefinitionsMap = new HashMap<>();
  private Map<IconInfo, IconDescriptor> iconDescriptorsMap = new HashMap<>();
  
  public CategoryDefinitionsWindow(
      EList<CategoryDefinition> categoryDefinitions,
      EList<IconDefinition> iconDefinitions, EList<IconSet> iconSets, boolean useIconFiles) {
    this.useIconFiles = useIconFiles;
    
    for (IconSet iconSet: iconSets) {
      for (IconDescriptor iconDescriptor: iconSet.getIconDescriptors()) {
        IconInfo iconInfo = ICON_SET_FACTORY.createIconInfo();
        iconInfo.setIconId(iconDescriptor.getIconId());
        iconInfo.setIconSetId(iconSet.getIconSetId());
        iconDescriptorsMap.put(iconInfo, iconDescriptor);
      }
    }
    
    if (!useIconFiles) {
      for (IconDefinition iconDefinition: iconDefinitions) {
        iconDefinitionsMap.put(iconDefinition.getIconInfo(), iconDefinition);
      } 
    }
    
    JPanel panel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(boxLayout);
    
    for (CategoryDefinition categoryDefinition: categoryDefinitions) {
      panel.add(createCategoryDefinitionPanel(categoryDefinition));
    }

    getContentPane().add(panel, BorderLayout.CENTER);
    pack();
  }

  private Component createCategoryDefinitionPanel(
      CategoryDefinition categoryDefinition) {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createLoweredBevelBorder());
    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(boxLayout);
    
    panel.add(createTextPanel(categoryDefinition));
    panel.add(createIconsPanel(categoryDefinition));
    
    return panel;
  }

  private Component createTextPanel(CategoryDefinition categoryDefinition) {
    StringBuilder buf = new StringBuilder();
    
    buf.append("categoryId: ");
    buf.append(categoryDefinition.getCategoryId());
    buf.append(NEW_LINE);
    
    buf.append("expression: ");
    buf.append(categoryDefinition.getExpression());
    buf.append(NEW_LINE);
    
    buf.append("Localized names: ");
    for (LocalizedString localizedName: categoryDefinition.getLocalizedNames()) {
      buf.append(NEW_LINE);
      buf.append("    languageCode: ");
      buf.append(localizedName.getLanguageCode());
      buf.append(NEW_LINE);
      buf.append("    countryCode: ");
      buf.append(localizedName.getCountryCode());
      buf.append(NEW_LINE);
      buf.append("    name: ");
      buf.append(localizedName.getString());
      buf.append(NEW_LINE);
    }
    
    buf.append(NEW_LINE);
    buf.append("icons:");

    
    JTextArea textArea = new JTextArea(buf.toString());
    textArea.setEditable(false);
    textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
    return textArea;
  }

  private Component createIconsPanel(CategoryDefinition categoryDefinition) {
    JPanel panel = new JPanel();
    
    for (IconInfo iconInfo: categoryDefinition.getIcons()) {
      panel.add(createIconPanel(iconInfo));
    }
    
    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
    return panel;
  }

  private Component createIconPanel(IconInfo iconInfo) {
    JPanel panel = new JPanel();
    
    panel.setLayout(new BorderLayout());
    BufferedImage image = null;
    if (useIconFiles) {
      IconDescriptor iconDescriptor = iconDescriptorsMap.get(iconInfo);
      File imageFile = new File(iconDescriptor.getUrl());
      try {
        image = ImageIO.read(imageFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      IconDefinition iconDefinition = iconDefinitionsMap.get(iconInfo);
      IconData iconData = iconDefinition.getIconData();
      ByteArrayInputStream inputStream = new ByteArrayInputStream(iconData.getData());
      try {
        image = ImageIO.read(inputStream);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    panel.add(new JLabel(new ImageIcon(image)), BorderLayout.CENTER);
    
    panel.add(createIconInfoTextPanel(iconInfo), BorderLayout.SOUTH);
    
    return panel;
  }

  private Component createIconInfoTextPanel(IconInfo iconInfo) {
    JPanel panel = new JPanel();
    StringBuilder buf = new StringBuilder();
    
    buf.append("iconSetId: ");
    buf.append(iconInfo.getIconSetId());
    buf.append(NEW_LINE);
    
    buf.append("iconId: ");
    buf.append(iconInfo.getIconId());
    
    JTextArea textArea = new JTextArea(buf.toString());
    textArea.setEditable(false);
    
    panel.add(textArea);
    
    return panel;
  }
}
