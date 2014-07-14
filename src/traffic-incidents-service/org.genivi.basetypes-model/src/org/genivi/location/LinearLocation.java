/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.location;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linear Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The location is a road stretch, e.g. the road stretch where there is a traffic jam.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.location.LinearLocation#getSegments <em>Segments</em>}</li>
 *   <li>{@link org.genivi.location.LinearLocation#getPositiveOffset <em>Positive Offset</em>}</li>
 *   <li>{@link org.genivi.location.LinearLocation#getNegativeOffset <em>Negative Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.location.LocationPackage#getLinearLocation()
 * @model
 * @generated
 */
public interface LinearLocation extends Location {

	/**
	 * Returns the value of the '<em><b>Segments</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segments</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The database segments of the location.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Segments</em>' attribute list.
	 * @see org.genivi.location.LocationPackage#getLinearLocation_Segments()
	 * @model required="true"
	 * @generated
	 */
	EList<Long> getSegments();

  /**
	 * Returns the value of the '<em><b>Positive Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The positive offset is the distance (in meters) between the begin node of the first segment and the start point of the actual location.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Positive Offset</em>' attribute.
	 * @see #isSetPositiveOffset()
	 * @see #unsetPositiveOffset()
	 * @see #setPositiveOffset(long)
	 * @see org.genivi.location.LocationPackage#getLinearLocation_PositiveOffset()
	 * @model unsettable="true"
	 * @generated
	 */
  long getPositiveOffset();

  /**
	 * Sets the value of the '{@link org.genivi.location.LinearLocation#getPositiveOffset <em>Positive Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Positive Offset</em>' attribute.
	 * @see #isSetPositiveOffset()
	 * @see #unsetPositiveOffset()
	 * @see #getPositiveOffset()
	 * @generated
	 */
  void setPositiveOffset(long value);

  /**
	 * Unsets the value of the '{@link org.genivi.location.LinearLocation#getPositiveOffset <em>Positive Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetPositiveOffset()
	 * @see #getPositiveOffset()
	 * @see #setPositiveOffset(long)
	 * @generated
	 */
  void unsetPositiveOffset();

  /**
	 * Returns whether the value of the '{@link org.genivi.location.LinearLocation#getPositiveOffset <em>Positive Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Positive Offset</em>' attribute is set.
	 * @see #unsetPositiveOffset()
	 * @see #getPositiveOffset()
	 * @see #setPositiveOffset(long)
	 * @generated
	 */
  boolean isSetPositiveOffset();

  /**
	 * Returns the value of the '<em><b>Negative Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The negative offset is the distance (in meters) between the end point of the actual location and the end node of the last segment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Negative Offset</em>' attribute.
	 * @see #isSetNegativeOffset()
	 * @see #unsetNegativeOffset()
	 * @see #setNegativeOffset(long)
	 * @see org.genivi.location.LocationPackage#getLinearLocation_NegativeOffset()
	 * @model unsettable="true"
	 * @generated
	 */
  long getNegativeOffset();

  /**
	 * Sets the value of the '{@link org.genivi.location.LinearLocation#getNegativeOffset <em>Negative Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negative Offset</em>' attribute.
	 * @see #isSetNegativeOffset()
	 * @see #unsetNegativeOffset()
	 * @see #getNegativeOffset()
	 * @generated
	 */
  void setNegativeOffset(long value);

  /**
	 * Unsets the value of the '{@link org.genivi.location.LinearLocation#getNegativeOffset <em>Negative Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetNegativeOffset()
	 * @see #getNegativeOffset()
	 * @see #setNegativeOffset(long)
	 * @generated
	 */
  void unsetNegativeOffset();

  /**
	 * Returns whether the value of the '{@link org.genivi.location.LinearLocation#getNegativeOffset <em>Negative Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Negative Offset</em>' attribute is set.
	 * @see #unsetNegativeOffset()
	 * @see #getNegativeOffset()
	 * @see #setNegativeOffset(long)
	 * @generated
	 */
  boolean isSetNegativeOffset();
} // LinearLocation
