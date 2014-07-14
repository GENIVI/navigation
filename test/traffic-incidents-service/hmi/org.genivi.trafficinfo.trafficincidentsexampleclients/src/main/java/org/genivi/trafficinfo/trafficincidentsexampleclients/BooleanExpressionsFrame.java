/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentsexampleclients;

import java.awt.Component;
import java.awt.Dimension;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class BooleanExpressionsFrame extends JFrame {
  private final static Logger LOGGER = Logger.getLogger(TrafficInfoMapView.class.getName());
  
  public BooleanExpressionsFrame(String[] descriptions, String[] expressions) {
    init(descriptions, expressions);

    pack();
  }

  private void init(String[] descriptions, String[] expressions) {
    JPanel mainPanel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
    mainPanel.setLayout(boxLayout);
    
    for (int i = 0; i < descriptions.length; i++) {
      mainPanel.add(createExpressionPanel(descriptions[i], expressions[i]));
    }
    
    JScrollPane scrollPane = new JScrollPane(mainPanel);
    
    setContentPane(scrollPane);
    
    setPreferredSize(new Dimension(850, 900));
  }

  private Component createExpressionPanel(String description, String expression) {
    LOGGER.info("=> description = " + description + ", expression = " + expression);
    JPanel panel = new JPanel();
    
    JLabel descriptionLabel = new JLabel(description);
    JPanel labelPanel = new JPanel();
    labelPanel.add(descriptionLabel);
    Dimension currentSize = labelPanel.getPreferredSize();
    Dimension labelPanelSize = new Dimension(200, (int) currentSize.getHeight());
    labelPanel.setSize(labelPanelSize);
    labelPanel.setMinimumSize(labelPanelSize);
    labelPanel.setMaximumSize(labelPanelSize);
    labelPanel.setPreferredSize(labelPanelSize);
    panel.add(labelPanel);
    
    JTextPane expressionPane = new JTextPane();
    expressionPane.setText(expression);
    expressionPane.setEditable(false);
    currentSize = expressionPane.getPreferredSize();
    Dimension expressionPaneSize = new Dimension(600, (int) currentSize.getHeight());
    expressionPane.setSize(expressionPaneSize);
    expressionPane.setMinimumSize(expressionPaneSize);
    expressionPane.setMaximumSize(expressionPaneSize);
    expressionPane.setPreferredSize(expressionPaneSize);
    panel.add(expressionPane);
    
    return panel;
  }

}
