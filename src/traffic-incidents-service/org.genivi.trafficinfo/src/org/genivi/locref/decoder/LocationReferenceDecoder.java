/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.locref.decoder;



public interface LocationReferenceDecoder {

  /**
   * Set the language.
   * @param languageCode The language to be used.
   * @param countryCode The country specific variant for the language to be used.
   * <!-- end-model-doc -->
   * @model
   * @generated
   */
  public void setLanguage(String languageCode, String countryCode);

  public LocationData decode(Object locationReference);
}
