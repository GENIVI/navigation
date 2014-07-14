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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class EclipseConsoleFormatter extends SimpleFormatter {
  private final static String LOGGER = "java.util.logging.Logger";
  private static final String NEW_LINE = System.getProperty("line.separator");

  @Override
  public String format(LogRecord record) {
    String fileName = null;
    String className = null;
    String methodName = null;
    int lineNumber = -1;
    
    boolean loggerFound = false;
    for ( StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace() ) {
      className = stackTraceElement.getClassName();
      
      if (!loggerFound) {
        if (className.equals(LOGGER)) {
          loggerFound = true;
          continue;
        }
      }
      
      
      if (loggerFound && !className.equals(LOGGER)) {
        className = className.substring(className.lastIndexOf(".") + 1);
        fileName = stackTraceElement.getFileName();
        methodName = stackTraceElement.getMethodName();
        lineNumber = stackTraceElement.getLineNumber();
        break;
      }
    }
        
    StringBuilder buf = new StringBuilder();
    buf.append(className);
    buf.append(".");
    buf.append(methodName);
    buf.append(": ");
    buf.append(formatMessage(record));
    
    if (record.getThrown() != null) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println();
        record.getThrown().printStackTrace(pw);
        pw.close();
        buf.append(sw.toString());
    }
    
    buf.append(" (");
    buf.append(fileName);
    buf.append(":");
    buf.append(lineNumber);
    buf.append(")");
    buf.append(NEW_LINE);
        
    return buf.toString();
  }

}
