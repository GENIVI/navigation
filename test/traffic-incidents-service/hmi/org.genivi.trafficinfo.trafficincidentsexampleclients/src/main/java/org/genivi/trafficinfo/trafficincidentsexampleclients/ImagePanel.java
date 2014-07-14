/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentsexampleclients;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(String imageFileName) {
    this(new ImageIcon(imageFileName).getImage());
  }

  public ImagePanel(Image img) {
    this.img = img;
    Dimension dimension = new Dimension(img.getWidth(null), img.getHeight(null));
    setSize(dimension);
    setPreferredSize(dimension);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, img.getWidth(null), img.getHeight(null), this);
  }
}