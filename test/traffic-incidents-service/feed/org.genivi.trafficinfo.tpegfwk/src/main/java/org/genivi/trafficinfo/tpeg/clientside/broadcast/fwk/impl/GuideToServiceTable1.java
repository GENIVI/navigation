/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk.impl;

import java.util.Iterator;
import java.util.LinkedList;

import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesFactory;



@SuppressWarnings("serial")
public class GuideToServiceTable1 extends LinkedList<GuideToServiceTable1Entry> {
  private static final TpegfwktypesFactory FACTORY = TpegfwktypesFactory.eINSTANCE;

  public GuideToServiceTable1Entry getEntryForServiceComponentId(byte serviceComponentId) {
    Iterator<GuideToServiceTable1Entry> iterator = iterator();
    while (iterator.hasNext()) {
      GuideToServiceTable1Entry entry = iterator.next();
      if (entry.getServiceComponentId() == serviceComponentId) {
        return entry;
      }
    }
    
    return null;
  }
  
  public static void main(String[] args) {
    GuideToServiceTable1 serviceTable = new GuideToServiceTable1();
    GuideToServiceTable1Entry entry;
    ServiceIdentifier serviceId;
    
    serviceId = FACTORY.createServiceIdentifier();
    serviceId.setSidA((byte) 9);
    serviceId.setSidB((byte) 10);
    serviceId.setSidC((byte) 11);
    entry = new GuideToServiceTable1Entry((byte) 100, (byte) 200, serviceId, (byte) 10);
    
    serviceTable.add(entry);
    
    serviceId = FACTORY.createServiceIdentifier();
    serviceId.setSidA((byte) 20);
    serviceId.setSidB((byte) 21);
    serviceId.setSidC((byte) 22);
    entry = new GuideToServiceTable1Entry((byte) 101, (byte) 201, serviceId, (byte) 11);
    
    serviceTable.add(entry);
    
    entry = serviceTable.getEntryForServiceComponentId((byte) 10);
    
  }
}
