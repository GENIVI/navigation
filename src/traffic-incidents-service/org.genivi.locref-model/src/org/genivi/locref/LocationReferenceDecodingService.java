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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location Reference Decoding Service</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.genivi.locref.locrefPackage#getLocationReferenceDecodingService()
 * @model
 * @generated
 */
public interface LocationReferenceDecodingService extends EObject {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model listenerRequired="true" locationReferenceRequired="true"
	 * @generated
	 */
  void decode(LocationReferenceDecodingServiceListener listener, LocationReference locationReference);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setLanguage(String languageCode, String countryCode);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void getLanguage(LocationReferenceDecodingServiceListener listener);

} // LocationReferenceDecodingService
