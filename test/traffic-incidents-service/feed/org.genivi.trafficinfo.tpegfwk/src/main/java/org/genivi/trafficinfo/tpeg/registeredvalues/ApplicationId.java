/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.registeredvalues;

public enum ApplicationId {
  SNI((byte) 0x0000, "Service and Network Information application", "SNI", true),
  RTM((byte) 0x0001, "Road Traffic Message application", "RTM", false),
  PTI((byte) 0x0002, "Public Transport Information application", "PTI", true),
  PKI((byte) 0x0003, "Parking Information application", "PKI", true),
  CTT((byte) 0x0004, "Congestion and Travel Time application", "CTT", false),
  TEC((byte) 0x0005, "Traffic Event Compact application", "TEC", true),
  CAI((byte) 0x0006, "Conditional Access Information application", "CAI", true),
  TFP((byte) 0x0007, "Traffic Flow and Prediction", "TFP", true),
  FPI((byte) 0x0008, "Fuel Price Information and availability", "FPI", true),
  RTM_TEST((byte) 0x8001, "TEST: RTM application", null, false),
  PTI_TEST((byte) 0x8002, "TEST: PTI application", null, false),
  PKI_TEST((byte) 0x8003, "TEST: PKI application", null, false),
  CTT_TEST((byte) 0x8004, "TEST: CTT application", null, false),
  TEC_TEST((byte) 0x8005, "TEST: TEC application", null, false),
  CAI_TEST((byte) 0x8006, "TEST: CAI application", null, false),
  TFP_TEST((byte) 0x8007, "TEST: TFP application", null, false),
  FPI_TEST((byte) 0x8008, "TEST: FPI application", null, false),
  TIME((byte) 0x8043, "My Time test application", null, false);
  
  private byte aid;  // Application Identification number. Test applications start at 0x8000.
  private String applicationName;  // Name of the (Test) Application
  private String abbreviation;     // Abbreviation for the Appication. For Test applications there's no abbreviation.
  private boolean definedInTpeg2Series;  // If true, this is (planned to be) part of TPEG2
  
  ApplicationId(byte aid, String applicationName, String abbreviation,
      boolean definedInTpeg2Series) {
	  this.aid = aid;
	  this.applicationName = applicationName;
	  this.abbreviation = abbreviation;
	  this.definedInTpeg2Series = definedInTpeg2Series;
  }
  
  public byte getAid() {
	  return aid;
  }
  
  public String getApplicationName() {
    return applicationName;
  }

  public String getAbbreviation() {
    return abbreviation;
  }
  
  public boolean isDefinedInTpeg2Series() {
    return definedInTpeg2Series;
  }

  public boolean isTestApplication() {
    return aid >= 0x8000;
  }

  public static ApplicationId getApplicationIdForId(int id) {
    for (ApplicationId applicationId: values()) {
      if (applicationId.aid == id) {
        return applicationId;
      }
    }
    
    return null;
  }
}
