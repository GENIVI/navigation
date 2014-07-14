/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.textgenerator.basictextgenerator;

import java.util.ListResourceBundle;

public class TextParts_en_US extends ListResourceBundle {
  public Object[][] getContents() {
    return contents;
  }

  private Object[][] contents = {
      {"locationTemplate", "On the {0} from {1} to {2} between {3} and {4}: "},
      {"locationTemplateShort", "On the {0} between {1} and {2}: "},
      {"averageSpeedAbsoluteTemplate", " with an av. speed of {0,number} {1}"},
      {"speedLimitTemplate", " with a speedlimit of {0,number} {1}"},
      {"expectedSpeedTemplate", " with an expected speed of {0,number} {1}"},
      {"lengthAffectedTemplate", " over a length of {0,number} {1}"},
      {"delayTemplate", " resulting in a dlay of {0} minutes"},
      {"fromPart", " from "},
      {"tillPart", " till "},
      {"tendencyPart", " tendency "},
      {"causedByPart", " caused by"},
      {"advicePart", "advice"},
      {"laneRestrictionsPart", " lane restr. "},
      {"unverifiedInformationPart", " (unverified info)"},
      {"applicabilityPart", " This info is only appl. for:"},
      {"tomorrow", "tomorrow "},
      {"tonnes", "tonnes"},
      {"pounds", "pound"},
      {"foot", "feet"}
  };
}
