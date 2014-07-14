/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.trafficincidentsexampleclients;

import java.util.logging.Logger;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.genivi.trafficincidentsservice.DefaultTrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TextDetailLevel;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;

/**
 * This class is a very simple Traffic Incidents Service client.
 * Every 3 seconds:
 *  - It requests the Ids of all the current Traffic Incidents
 *  - For these Ids it requests the full texts
 *  - It prints the Ids and the texts to System.out.
 */
public class ATrafficInfoClient extends Thread {
  private final static Logger LOGGER = Logger.getLogger(ATrafficInfoClient.class.getName());
  
  private TrafficIncidents trafficInfo = null;
  private EList<Integer> incidentIds;
  private TrafficIncidentsListener trafficIncidentsListener;

  public ATrafficInfoClient() {
    LOGGER.info("Creating ATrafficInfoClient");
    
    trafficIncidentsListener = new DefaultTrafficIncidentsListener() {

      @Override
      public void getTrafficIncidentIdsReply(EList<Integer> incidentIds) {
        LOGGER.info("getTrafficIncidentIdsReply called.");
        getAndShowTrafficInfoStep2(incidentIds);
      }


      @Override
      public void getTextsReply(EList<String> texts) {
        LOGGER.info("getTextsReply called.");
        getAndShowTrafficInfoStep3(texts);
      }
    };
  }

  public TrafficIncidents getTrafficInfo() {
    return trafficInfo;
  }

  public void setTrafficIncidentsService(TrafficIncidents trafficInfo) {
    this.trafficInfo = trafficInfo;
  }

  public void run() {
    for ( ; ; ) {
      if (trafficInfo != null) {
        getAndShowTrafficInfoStep1();
      } else {
        System.out.println("ATrafficInfoClient: No traffic info provider");
      }

      try {
        sleep(1000 * 3);
      } catch (InterruptedException e) {
        System.out.println("ATrafficInfoClient woke up too early");
      }
    }
  }


  private void getAndShowTrafficInfoStep1() {
    LOGGER.info("Polling; calling getTrafficIncidentIds()");
    trafficInfo.getTrafficIncidentIds(trafficIncidentsListener, new BasicEList<WarningLevel>(), new BasicEList<Integer>());		
  }

  private void getAndShowTrafficInfoStep2(EList<Integer> incidentIds) {
    this.incidentIds = incidentIds;
    LOGGER.info("Getting the texts for the Traffic Incidents by calling getTexts().");
    trafficInfo.getTexts(trafficIncidentsListener, incidentIds, TextDetailLevel.FULL);
  }

  private void getAndShowTrafficInfoStep3(EList<String> messageTexts) {
    System.out.println("Current Traffic Incidents:");
    System.out.print("Ids:");
    for (Integer incidentId: incidentIds) {
      System.out.print(" " + incidentId.toString());
    }
    System.out.println();
    for (String messageText: messageTexts) {
      System.out.println(messageText);
    }
  }
}
