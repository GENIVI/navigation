/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident;

import org.eclipse.emf.common.util.EList;

import org.genivi.common.LocalizedString;

import org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direct Cause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getWarningLevel <em>Warning Level</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#isUnverifiedInformation <em>Unverified Information</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getSubCause <em>Sub Cause</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLengthAffected <em>Length Affected</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLaneRestrictions <em>Lane Restrictions</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getFreeText <em>Free Text</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getCauseOffset <em>Cause Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getDirectCause()
 * @model
 * @generated
 */
public interface DirectCause extends Cause {
  /**
	 * Returns the value of the '<em><b>Warning Level</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Warning Level</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Warning Level</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel
	 * @see #isSetWarningLevel()
	 * @see #unsetWarningLevel()
	 * @see #setWarningLevel(WarningLevel)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getDirectCause_WarningLevel()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  WarningLevel getWarningLevel();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getWarningLevel <em>Warning Level</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warning Level</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.WarningLevel
	 * @see #isSetWarningLevel()
	 * @see #unsetWarningLevel()
	 * @see #getWarningLevel()
	 * @generated
	 */
  void setWarningLevel(WarningLevel value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getWarningLevel <em>Warning Level</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetWarningLevel()
	 * @see #getWarningLevel()
	 * @see #setWarningLevel(WarningLevel)
	 * @generated
	 */
  void unsetWarningLevel();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getWarningLevel <em>Warning Level</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warning Level</em>' attribute is set.
	 * @see #unsetWarningLevel()
	 * @see #getWarningLevel()
	 * @see #setWarningLevel(WarningLevel)
	 * @generated
	 */
  boolean isSetWarningLevel();

  /**
	 * Returns the value of the '<em><b>Unverified Information</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unverified Information</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Unverified Information</em>' attribute.
	 * @see #isSetUnverifiedInformation()
	 * @see #unsetUnverifiedInformation()
	 * @see #setUnverifiedInformation(boolean)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getDirectCause_UnverifiedInformation()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  boolean isUnverifiedInformation();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#isUnverifiedInformation <em>Unverified Information</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unverified Information</em>' attribute.
	 * @see #isSetUnverifiedInformation()
	 * @see #unsetUnverifiedInformation()
	 * @see #isUnverifiedInformation()
	 * @generated
	 */
  void setUnverifiedInformation(boolean value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#isUnverifiedInformation <em>Unverified Information</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetUnverifiedInformation()
	 * @see #isUnverifiedInformation()
	 * @see #setUnverifiedInformation(boolean)
	 * @generated
	 */
  void unsetUnverifiedInformation();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#isUnverifiedInformation <em>Unverified Information</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unverified Information</em>' attribute is set.
	 * @see #unsetUnverifiedInformation()
	 * @see #isUnverifiedInformation()
	 * @see #setUnverifiedInformation(boolean)
	 * @generated
	 */
  boolean isSetUnverifiedInformation();

  /**
	 * Returns the value of the '<em><b>Sub Cause</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The actual value of this atttribute depends on the mainCause. So based on the mainCause it has to be cast to the related enum.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Cause</em>' attribute.
	 * @see #isSetSubCause()
	 * @see #unsetSubCause()
	 * @see #setSubCause(Object)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getDirectCause_SubCause()
	 * @model unsettable="true"
	 * @generated
	 */
  Object getSubCause();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getSubCause <em>Sub Cause</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Cause</em>' attribute.
	 * @see #isSetSubCause()
	 * @see #unsetSubCause()
	 * @see #getSubCause()
	 * @generated
	 */
  void setSubCause(Object value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getSubCause <em>Sub Cause</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSubCause()
	 * @see #getSubCause()
	 * @see #setSubCause(Object)
	 * @generated
	 */
  void unsetSubCause();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getSubCause <em>Sub Cause</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sub Cause</em>' attribute is set.
	 * @see #unsetSubCause()
	 * @see #getSubCause()
	 * @see #setSubCause(Object)
	 * @generated
	 */
  boolean isSetSubCause();

  /**
	 * Returns the value of the '<em><b>Length Affected</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Length Affected</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Length Affected</em>' attribute.
	 * @see #isSetLengthAffected()
	 * @see #unsetLengthAffected()
	 * @see #setLengthAffected(Integer)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getDirectCause_LengthAffected()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getLengthAffected();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLengthAffected <em>Length Affected</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length Affected</em>' attribute.
	 * @see #isSetLengthAffected()
	 * @see #unsetLengthAffected()
	 * @see #getLengthAffected()
	 * @generated
	 */
  void setLengthAffected(Integer value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLengthAffected <em>Length Affected</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLengthAffected()
	 * @see #getLengthAffected()
	 * @see #setLengthAffected(Integer)
	 * @generated
	 */
  void unsetLengthAffected();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLengthAffected <em>Length Affected</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Length Affected</em>' attribute is set.
	 * @see #unsetLengthAffected()
	 * @see #getLengthAffected()
	 * @see #setLengthAffected(Integer)
	 * @generated
	 */
  boolean isSetLengthAffected();

  /**
	 * Returns the value of the '<em><b>Lane Restrictions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lane Restrictions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Restrictions</em>' containment reference.
	 * @see #isSetLaneRestrictions()
	 * @see #unsetLaneRestrictions()
	 * @see #setLaneRestrictions(LaneRestrictions)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getDirectCause_LaneRestrictions()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  LaneRestrictions getLaneRestrictions();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLaneRestrictions <em>Lane Restrictions</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane Restrictions</em>' containment reference.
	 * @see #isSetLaneRestrictions()
	 * @see #unsetLaneRestrictions()
	 * @see #getLaneRestrictions()
	 * @generated
	 */
  void setLaneRestrictions(LaneRestrictions value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLaneRestrictions <em>Lane Restrictions</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLaneRestrictions()
	 * @see #getLaneRestrictions()
	 * @see #setLaneRestrictions(LaneRestrictions)
	 * @generated
	 */
  void unsetLaneRestrictions();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLaneRestrictions <em>Lane Restrictions</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lane Restrictions</em>' containment reference is set.
	 * @see #unsetLaneRestrictions()
	 * @see #getLaneRestrictions()
	 * @see #setLaneRestrictions(LaneRestrictions)
	 * @generated
	 */
  boolean isSetLaneRestrictions();

  /**
	 * Returns the value of the '<em><b>Free Text</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.common.LocalizedString}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Free Text</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Free Text</em>' containment reference list.
	 * @see #isSetFreeText()
	 * @see #unsetFreeText()
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getDirectCause_FreeText()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<LocalizedString> getFreeText();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getFreeText <em>Free Text</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetFreeText()
	 * @see #getFreeText()
	 * @generated
	 */
  void unsetFreeText();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getFreeText <em>Free Text</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Free Text</em>' containment reference list is set.
	 * @see #unsetFreeText()
	 * @see #getFreeText()
	 * @generated
	 */
  boolean isSetFreeText();

		/**
	 * Returns the value of the '<em><b>Cause Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cause Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cause Offset</em>' attribute.
	 * @see #isSetCauseOffset()
	 * @see #unsetCauseOffset()
	 * @see #setCauseOffset(Integer)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getDirectCause_CauseOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getCauseOffset();

		/**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getCauseOffset <em>Cause Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cause Offset</em>' attribute.
	 * @see #isSetCauseOffset()
	 * @see #unsetCauseOffset()
	 * @see #getCauseOffset()
	 * @generated
	 */
	void setCauseOffset(Integer value);

		/**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getCauseOffset <em>Cause Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCauseOffset()
	 * @see #getCauseOffset()
	 * @see #setCauseOffset(Integer)
	 * @generated
	 */
	void unsetCauseOffset();

		/**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getCauseOffset <em>Cause Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cause Offset</em>' attribute is set.
	 * @see #unsetCauseOffset()
	 * @see #getCauseOffset()
	 * @see #setCauseOffset(Integer)
	 * @generated
	 */
	boolean isSetCauseOffset();

} // DirectCause
