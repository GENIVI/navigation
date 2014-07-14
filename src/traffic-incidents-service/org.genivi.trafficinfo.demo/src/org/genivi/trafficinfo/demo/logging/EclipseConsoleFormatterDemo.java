/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.trafficinfo.demo.logging;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EclipseConsoleFormatterDemo {
  private final static Logger LOGGER = Logger.getLogger(EclipseConsoleFormatterDemo.class.getName()); 
  
  public static void main(String args[]) {
    EclipseConsoleFormatterDemo logTest = new EclipseConsoleFormatterDemo();
    logTest.logSetup();
    logTest.writeOutput();
  }

  private void logSetup() {
    // Create Logger
    Logger logger = Logger.getLogger("");
    logger.setLevel(Level.INFO);
    
    Handler consoleHandler = null;
    for (Handler handler: logger.getHandlers()) {
      if (handler.getClass().getName().equals("java.util.logging.ConsoleHandler")) {
        consoleHandler = handler;
        break;
      }
    }
    consoleHandler.setFormatter(new EclipseConsoleFormatter());
  }

  private void writeOutput() {
    LOGGER.info("Where am I?");
  }
}
