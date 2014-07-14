/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.textgenerator.basictextgenerator;

import java.util.ListResourceBundle;

public class TextParts_nl extends ListResourceBundle {
  public Object[][] getContents() {
    return contents;
  }

  private Object[][] contents = {
      {"locationTemplate", "Op de {0} van {1} naar {2} tussen {3} en {4}: "},
      {"locationTemplateShort", "Op de {0} tussen {1} en {2}: "},
      {"averageSpeedAbsoluteTemplate", " met een gemiddelde rijsnelheid van {0,number} {1}"},
      {"speedLimitTemplate", " met een maximum snelheid van {0,number} {1}"},
      {"expectedSpeedTemplate", " met een verwachtte snelheid van {0,number} {1}"},
      {"lengthAffectedTemplate", " over een lengte van {0,number} {1}"},
      {"delayTemplate", " resulterend in een vertraging van {0} minuten"},
      {"fromPart", " van "},
      {"tillPart", " tot "},
      {"tendencyPart", " tendens is "},
      {"causedByPart", " veroorzaakt door"},
      {"advicePart", "advies"},
      {"laneRestrictionsPart", " rijstrook beperkingen "},
      {"unverifiedInformationPart", " (informatie niet geverifieerd)"},
      {"applicabilityPart", " Deze informatie is alleen van toepassing voor:"},
      {"tomorrow", "morgen "},
      {"tonnes", "ton"},
      {"pounds", "pond"},
      {"foot", "voet"}
  };

}
