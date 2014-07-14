/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.tpegtecfeed.refimpl;

import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;

public class TecUtil {
  public static String createMessageId(ServiceIdentifier originatorSID, byte COID, int messageId) {
    StringBuilder buf = new StringBuilder();
    buf.append(String.valueOf(originatorSID.getSidA()));
    buf.append(".");
    buf.append(String.valueOf(originatorSID.getSidB()));
    buf.append(".");
    buf.append(String.valueOf(originatorSID.getSidC()));
    buf.append(":");
    buf.append(String.valueOf(COID));
    buf.append(":");
    buf.append(String.valueOf(messageId));
    
    return buf.toString();
  }
}
