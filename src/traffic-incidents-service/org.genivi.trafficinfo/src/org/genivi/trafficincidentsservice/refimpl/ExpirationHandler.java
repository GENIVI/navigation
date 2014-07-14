/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.refimpl;

import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

public class ExpirationHandler extends Thread {
	TrafficIncidentsService trafficInfoStore;
	
    public ExpirationHandler(TrafficIncidentsService trafficInfoStore) {
    	this.trafficInfoStore = trafficInfoStore;
    }
    
    public void run() {
    	for ( ; ; ) {
    		try {
				sleep(1000 * 60);
			} catch (InterruptedException e) {
			}
    		
    		cancelExpiredMessages();
    	}
    }

	private void cancelExpiredMessages() {
		Date currentTime = new Date();
		EList<String> cancelList = new BasicEList<>();
		
		for (ManagedTrafficIncident managedTrafficIncident: trafficInfoStore.getManagedEvents()) {
			Date expirationTime = managedTrafficIncident.getxTrafficIncident().getExpirationTime();
			if (expirationTime != null  &&  currentTime.after(expirationTime)) {
				cancelList.add(managedTrafficIncident.getxTrafficIncident().getTrafficIncidentId());
			}
		}
		
		if (cancelList.size() != 0) {
		  trafficInfoStore.updateIncidents(-1, cancelList, null);
		}		
	}
}
