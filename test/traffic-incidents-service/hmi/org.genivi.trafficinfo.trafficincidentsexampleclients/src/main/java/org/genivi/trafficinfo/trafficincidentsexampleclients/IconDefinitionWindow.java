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
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.eclipse.emf.common.util.EList;
import org.genivi.iconset.IconData;
import org.genivi.iconset.IconDefinition;
import org.genivi.iconset.IconDescriptor;
import org.genivi.iconset.IconInfo;
import org.genivi.iconset.IconSet;
import org.genivi.iconset.IconsetFactory;

@SuppressWarnings("serial")
public class IconDefinitionWindow extends JFrame {
  private static final String NEW_LINE = System.getProperty("line.separator");
  private static final IconsetFactory iconsetFactory = IconsetFactory.eINSTANCE;

  private boolean useIconFiles = false;
  private Map<IconInfo, IconDefinition> iconDefinitionsMap = new HashMap<IconInfo, IconDefinition>();
  
  public IconDefinitionWindow(EList<IconDefinition> iconDefinitions, EList<IconSet> iconSets, boolean useIconFiles) {
    this.useIconFiles = useIconFiles;
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    if (!useIconFiles) {
      for (IconDefinition iconDefinition: iconDefinitions) {
        iconDefinitionsMap.put(iconDefinition.getIconInfo(), iconDefinition);
      } 
    }
    
    JPanel panel = new JPanel();
            
    panel.add(creatIconThemePanel(iconSets, 28));
    panel.add(creatIconThemePanel(iconSets, 44));    
    
    setContentPane(panel);
    pack();
  }
  
  private Component creatIconThemePanel(EList<IconSet> iconSets, int themeId) {
    JPanel panel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(boxLayout);

    for (IconSet iconSet: iconSets) {
      if (iconSet.getThemeId() == themeId) {
        panel.add(createIconSetPanel(iconSet));
      }
    }

    return panel;
  }

  private Component createIconSetPanel(IconSet iconSet) {
    JPanel panel = new JPanel();
    panel.add(createMetaDataPanel(iconSet));
    for (IconDescriptor iconDescriptor: iconSet.getIconDescriptors()) {
      panel.add(createIconPreviewPanel(iconSet, iconDescriptor));
    }
    return panel;
  }

  private Component createIconPreviewPanel(IconSet iconSet,
      IconDescriptor iconDescriptor) {
    JPanel panel = new JPanel();
    
    panel.setLayout(new BorderLayout());
    IconInfo iconInfo = iconsetFactory.createIconInfo();
    iconInfo.setIconSetId(iconSet.getIconSetId());
    iconInfo.setIconId(iconDescriptor.getIconId());
    BufferedImage image = null;
    if (useIconFiles) {
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
    panel.add(new ImagePanel(image), BorderLayout.CENTER);
    
    JLabel label = new JLabel("icon " + iconDescriptor.getIconId());
    panel.add(label, BorderLayout.SOUTH);
    
    return panel;
  }

  private Component createMetaDataPanel(IconSet iconSet) {
    JPanel panel = new JPanel();
    StringBuilder buf = new StringBuilder();
    
    buf.append("iconSetId: ");
    buf.append(iconSet.getIconSetId());
    buf.append(NEW_LINE);
    
    buf.append("colorType: ");
    buf.append(iconSet.getColorType().getName());
    buf.append(NEW_LINE);

    buf.append("dimension: ");
    buf.append(iconSet.getDimension().getName());
    buf.append(NEW_LINE);
    
    buf.append("daytime/nighttime: ");
    if (iconSet.isDayTimeIcon()) {
      buf.append("daytime");
    } else {
      buf.append("nighttime");
    }
    buf.append(NEW_LINE);

    buf.append("themeId: ");
    buf.append(iconSet.getThemeId());
    buf.append(NEW_LINE);
    
    buf.append("size: ");
    buf.append(iconSet.getSize().getWidth());
    buf.append(" x ");
    buf.append(iconSet.getSize().getHeight());
    buf.append(NEW_LINE);

    JTextArea textArea = new JTextArea(buf.toString());
    textArea.setEditable(false);
    
    return panel.add(textArea);
  }
}
