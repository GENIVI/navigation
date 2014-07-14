/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.locref;

import org.eclipse.emf.ecore.EObject;
import org.genivi.location.Location;
import org.genivi.location.LocationInfo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location Reference Decoding Service Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.genivi.locref.locrefPackage#getLocationReferenceDecodingServiceListener()
 * @model
 * @generated
 */
public interface LocationReferenceDecodingServiceListener extends EObject {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model locationRequired="true"
	 * @generated
	 */
  void decodeReply(Location location, LocationInfo locationInfo);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void getLanguageReply(String languageCode, String countryCode);

} // LocationReferenceDecodingServiceListener
