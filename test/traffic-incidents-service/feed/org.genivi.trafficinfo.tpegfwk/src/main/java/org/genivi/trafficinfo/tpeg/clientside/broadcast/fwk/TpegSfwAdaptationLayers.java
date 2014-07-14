/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.clientside.broadcast.fwk;

public interface TpegSfwAdaptationLayers {
  public long registerAdaptationLayer(Object adaptationLayer, String communicationChannelName);
  
  public void unregisterAdaptationLayer(long channelId);

  public void transportFrameReceived(long channelId, Object data);
}
