/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.genivi.common.RectangularArea;

import org.genivi.location.Location;
import org.genivi.location.LocationInfo;

import org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode;
import org.genivi.trafficincidentsservice.trafficincidenttables.Tendency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traffic Incident</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * See http://vos.intra.local/display/GENIVI/GENIVI+Traffic+Information+-+Traffic+Incident+Definition for definitions of the meanings of the attributes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectCode <em>Effect Code</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectText <em>Effect Text</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendency <em>Tendency</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendencyText <em>Tendency Text</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLengthAffected <em>Length Affected</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getDelay <em>Delay</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getSegmentSpeedLimit <em>Segment Speed Limit</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCauses <em>Causes</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocation <em>Location</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAdvices <em>Advices</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getApplicability <em>Applicability</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTrafficIncidentId <em>Traffic Incident Id</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocationInfo <em>Location Info</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCauseTexts <em>Cause Texts</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getApplicabilityTexts <em>Applicability Texts</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAdviceTexts <em>Advice Texts</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCategoryIds <em>Category Ids</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocationBoundingBox <em>Location Bounding Box</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTemporarySpeedLimit <em>Temporary Speed Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident()
 * @model
 * @generated
 */
public interface TrafficIncident extends EObject {
  /**
	 * Returns the value of the '<em><b>Effect Code</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Effect Code</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Effect Code</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode
	 * @see #isSetEffectCode()
	 * @see #unsetEffectCode()
	 * @see #setEffectCode(EffectCode)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_EffectCode()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  EffectCode getEffectCode();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectCode <em>Effect Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect Code</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode
	 * @see #isSetEffectCode()
	 * @see #unsetEffectCode()
	 * @see #getEffectCode()
	 * @generated
	 */
  void setEffectCode(EffectCode value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectCode <em>Effect Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetEffectCode()
	 * @see #getEffectCode()
	 * @see #setEffectCode(EffectCode)
	 * @generated
	 */
  void unsetEffectCode();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectCode <em>Effect Code</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Effect Code</em>' attribute is set.
	 * @see #unsetEffectCode()
	 * @see #getEffectCode()
	 * @see #setEffectCode(EffectCode)
	 * @generated
	 */
  boolean isSetEffectCode();

  /**
	 * Returns the value of the '<em><b>Effect Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Effect Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Effect Text</em>' attribute.
	 * @see #isSetEffectText()
	 * @see #unsetEffectText()
	 * @see #setEffectText(String)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_EffectText()
	 * @model unsettable="true"
	 * @generated
	 */
  String getEffectText();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectText <em>Effect Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect Text</em>' attribute.
	 * @see #isSetEffectText()
	 * @see #unsetEffectText()
	 * @see #getEffectText()
	 * @generated
	 */
  void setEffectText(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectText <em>Effect Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetEffectText()
	 * @see #getEffectText()
	 * @see #setEffectText(String)
	 * @generated
	 */
  void unsetEffectText();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectText <em>Effect Text</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Effect Text</em>' attribute is set.
	 * @see #unsetEffectText()
	 * @see #getEffectText()
	 * @see #setEffectText(String)
	 * @generated
	 */
  boolean isSetEffectText();

  /**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #isSetStartTime()
	 * @see #unsetStartTime()
	 * @see #setStartTime(Date)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_StartTime()
	 * @model unsettable="true"
	 * @generated
	 */
  Date getStartTime();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #isSetStartTime()
	 * @see #unsetStartTime()
	 * @see #getStartTime()
	 * @generated
	 */
  void setStartTime(Date value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetStartTime()
	 * @see #getStartTime()
	 * @see #setStartTime(Date)
	 * @generated
	 */
  void unsetStartTime();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStartTime <em>Start Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Time</em>' attribute is set.
	 * @see #unsetStartTime()
	 * @see #getStartTime()
	 * @see #setStartTime(Date)
	 * @generated
	 */
  boolean isSetStartTime();

  /**
	 * Returns the value of the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stop Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Time</em>' attribute.
	 * @see #isSetStopTime()
	 * @see #unsetStopTime()
	 * @see #setStopTime(Date)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_StopTime()
	 * @model unsettable="true"
	 * @generated
	 */
  Date getStopTime();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStopTime <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Time</em>' attribute.
	 * @see #isSetStopTime()
	 * @see #unsetStopTime()
	 * @see #getStopTime()
	 * @generated
	 */
  void setStopTime(Date value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStopTime <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetStopTime()
	 * @see #getStopTime()
	 * @see #setStopTime(Date)
	 * @generated
	 */
  void unsetStopTime();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStopTime <em>Stop Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Stop Time</em>' attribute is set.
	 * @see #unsetStopTime()
	 * @see #getStopTime()
	 * @see #setStopTime(Date)
	 * @generated
	 */
  boolean isSetStopTime();

  /**
	 * Returns the value of the '<em><b>Tendency</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficincidentsservice.trafficincidenttables.Tendency}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tendency</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Tendency</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Tendency
	 * @see #isSetTendency()
	 * @see #unsetTendency()
	 * @see #setTendency(Tendency)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_Tendency()
	 * @model unsettable="true"
	 * @generated
	 */
  Tendency getTendency();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendency <em>Tendency</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tendency</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.trafficincidenttables.Tendency
	 * @see #isSetTendency()
	 * @see #unsetTendency()
	 * @see #getTendency()
	 * @generated
	 */
  void setTendency(Tendency value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendency <em>Tendency</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetTendency()
	 * @see #getTendency()
	 * @see #setTendency(Tendency)
	 * @generated
	 */
  void unsetTendency();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendency <em>Tendency</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tendency</em>' attribute is set.
	 * @see #unsetTendency()
	 * @see #getTendency()
	 * @see #setTendency(Tendency)
	 * @generated
	 */
  boolean isSetTendency();

  /**
	 * Returns the value of the '<em><b>Tendency Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tendency Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Tendency Text</em>' attribute.
	 * @see #isSetTendencyText()
	 * @see #unsetTendencyText()
	 * @see #setTendencyText(String)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_TendencyText()
	 * @model unsettable="true"
	 * @generated
	 */
  String getTendencyText();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendencyText <em>Tendency Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tendency Text</em>' attribute.
	 * @see #isSetTendencyText()
	 * @see #unsetTendencyText()
	 * @see #getTendencyText()
	 * @generated
	 */
  void setTendencyText(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendencyText <em>Tendency Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetTendencyText()
	 * @see #getTendencyText()
	 * @see #setTendencyText(String)
	 * @generated
	 */
  void unsetTendencyText();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendencyText <em>Tendency Text</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tendency Text</em>' attribute is set.
	 * @see #unsetTendencyText()
	 * @see #getTendencyText()
	 * @see #setTendencyText(String)
	 * @generated
	 */
  boolean isSetTendencyText();

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
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_LengthAffected()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getLengthAffected();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLengthAffected <em>Length Affected</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLengthAffected <em>Length Affected</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLengthAffected()
	 * @see #getLengthAffected()
	 * @see #setLengthAffected(Integer)
	 * @generated
	 */
  void unsetLengthAffected();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLengthAffected <em>Length Affected</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Average Speed Absolute</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Average Speed Absolute</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Average Speed Absolute</em>' attribute.
	 * @see #isSetAverageSpeedAbsolute()
	 * @see #unsetAverageSpeedAbsolute()
	 * @see #setAverageSpeedAbsolute(Integer)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_AverageSpeedAbsolute()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getAverageSpeedAbsolute();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Average Speed Absolute</em>' attribute.
	 * @see #isSetAverageSpeedAbsolute()
	 * @see #unsetAverageSpeedAbsolute()
	 * @see #getAverageSpeedAbsolute()
	 * @generated
	 */
  void setAverageSpeedAbsolute(Integer value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAverageSpeedAbsolute()
	 * @see #getAverageSpeedAbsolute()
	 * @see #setAverageSpeedAbsolute(Integer)
	 * @generated
	 */
  void unsetAverageSpeedAbsolute();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Average Speed Absolute</em>' attribute is set.
	 * @see #unsetAverageSpeedAbsolute()
	 * @see #getAverageSpeedAbsolute()
	 * @see #setAverageSpeedAbsolute(Integer)
	 * @generated
	 */
  boolean isSetAverageSpeedAbsolute();

  /**
	 * Returns the value of the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Delay</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay</em>' attribute.
	 * @see #isSetDelay()
	 * @see #unsetDelay()
	 * @see #setDelay(Integer)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_Delay()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getDelay();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay</em>' attribute.
	 * @see #isSetDelay()
	 * @see #unsetDelay()
	 * @see #getDelay()
	 * @generated
	 */
  void setDelay(Integer value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetDelay()
	 * @see #getDelay()
	 * @see #setDelay(Integer)
	 * @generated
	 */
  void unsetDelay();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getDelay <em>Delay</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Delay</em>' attribute is set.
	 * @see #unsetDelay()
	 * @see #getDelay()
	 * @see #setDelay(Integer)
	 * @generated
	 */
  boolean isSetDelay();

  /**
	 * Returns the value of the '<em><b>Segment Speed Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Segment Speed Limit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Segment Speed Limit</em>' attribute.
	 * @see #isSetSegmentSpeedLimit()
	 * @see #unsetSegmentSpeedLimit()
	 * @see #setSegmentSpeedLimit(Integer)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_SegmentSpeedLimit()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getSegmentSpeedLimit();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getSegmentSpeedLimit <em>Segment Speed Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segment Speed Limit</em>' attribute.
	 * @see #isSetSegmentSpeedLimit()
	 * @see #unsetSegmentSpeedLimit()
	 * @see #getSegmentSpeedLimit()
	 * @generated
	 */
  void setSegmentSpeedLimit(Integer value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getSegmentSpeedLimit <em>Segment Speed Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSegmentSpeedLimit()
	 * @see #getSegmentSpeedLimit()
	 * @see #setSegmentSpeedLimit(Integer)
	 * @generated
	 */
  void unsetSegmentSpeedLimit();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getSegmentSpeedLimit <em>Segment Speed Limit</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Segment Speed Limit</em>' attribute is set.
	 * @see #unsetSegmentSpeedLimit()
	 * @see #getSegmentSpeedLimit()
	 * @see #setSegmentSpeedLimit(Integer)
	 * @generated
	 */
  boolean isSetSegmentSpeedLimit();

  /**
	 * Returns the value of the '<em><b>Causes</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Causes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Causes</em>' containment reference list.
	 * @see #isSetCauses()
	 * @see #unsetCauses()
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_Causes()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<Cause> getCauses();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCauses <em>Causes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetCauses()
	 * @see #getCauses()
	 * @generated
	 */
  void unsetCauses();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCauses <em>Causes</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Causes</em>' containment reference list is set.
	 * @see #unsetCauses()
	 * @see #getCauses()
	 * @generated
	 */
  boolean isSetCauses();

  /**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' containment reference.
	 * @see #isSetLocation()
	 * @see #unsetLocation()
	 * @see #setLocation(Location)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_Location()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  Location getLocation();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #isSetLocation()
	 * @see #unsetLocation()
	 * @see #getLocation()
	 * @generated
	 */
  void setLocation(Location value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLocation()
	 * @see #getLocation()
	 * @see #setLocation(Location)
	 * @generated
	 */
  void unsetLocation();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocation <em>Location</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Location</em>' containment reference is set.
	 * @see #unsetLocation()
	 * @see #getLocation()
	 * @see #setLocation(Location)
	 * @generated
	 */
  boolean isSetLocation();

  /**
	 * Returns the value of the '<em><b>Advices</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Advices</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Advices</em>' containment reference list.
	 * @see #isSetAdvices()
	 * @see #unsetAdvices()
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_Advices()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<Advice> getAdvices();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAdvices <em>Advices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAdvices()
	 * @see #getAdvices()
	 * @generated
	 */
  void unsetAdvices();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAdvices <em>Advices</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Advices</em>' containment reference list is set.
	 * @see #unsetAdvices()
	 * @see #getAdvices()
	 * @generated
	 */
  boolean isSetAdvices();

  /**
	 * Returns the value of the '<em><b>Applicability</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applicability</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicability</em>' containment reference list.
	 * @see #isSetApplicability()
	 * @see #unsetApplicability()
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_Applicability()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<Applicability> getApplicability();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getApplicability <em>Applicability</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetApplicability()
	 * @see #getApplicability()
	 * @generated
	 */
  void unsetApplicability();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getApplicability <em>Applicability</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applicability</em>' containment reference list is set.
	 * @see #unsetApplicability()
	 * @see #getApplicability()
	 * @generated
	 */
  boolean isSetApplicability();

  /**
	 * Returns the value of the '<em><b>Traffic Incident Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Traffic Incident Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Traffic Incident Id</em>' attribute.
	 * @see #isSetTrafficIncidentId()
	 * @see #unsetTrafficIncidentId()
	 * @see #setTrafficIncidentId(Integer)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_TrafficIncidentId()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getTrafficIncidentId();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTrafficIncidentId <em>Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traffic Incident Id</em>' attribute.
	 * @see #isSetTrafficIncidentId()
	 * @see #unsetTrafficIncidentId()
	 * @see #getTrafficIncidentId()
	 * @generated
	 */
  void setTrafficIncidentId(Integer value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTrafficIncidentId <em>Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetTrafficIncidentId()
	 * @see #getTrafficIncidentId()
	 * @see #setTrafficIncidentId(Integer)
	 * @generated
	 */
  void unsetTrafficIncidentId();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTrafficIncidentId <em>Traffic Incident Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Traffic Incident Id</em>' attribute is set.
	 * @see #unsetTrafficIncidentId()
	 * @see #getTrafficIncidentId()
	 * @see #setTrafficIncidentId(Integer)
	 * @generated
	 */
  boolean isSetTrafficIncidentId();

  /**
	 * Returns the value of the '<em><b>Location Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location Info</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Location Info</em>' containment reference.
	 * @see #isSetLocationInfo()
	 * @see #unsetLocationInfo()
	 * @see #setLocationInfo(LocationInfo)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_LocationInfo()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  LocationInfo getLocationInfo();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocationInfo <em>Location Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location Info</em>' containment reference.
	 * @see #isSetLocationInfo()
	 * @see #unsetLocationInfo()
	 * @see #getLocationInfo()
	 * @generated
	 */
  void setLocationInfo(LocationInfo value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocationInfo <em>Location Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLocationInfo()
	 * @see #getLocationInfo()
	 * @see #setLocationInfo(LocationInfo)
	 * @generated
	 */
  void unsetLocationInfo();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocationInfo <em>Location Info</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Location Info</em>' containment reference is set.
	 * @see #unsetLocationInfo()
	 * @see #getLocationInfo()
	 * @see #setLocationInfo(LocationInfo)
	 * @generated
	 */
  boolean isSetLocationInfo();

  /**
	 * Returns the value of the '<em><b>Cause Texts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cause Texts</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Cause Texts</em>' attribute list.
	 * @see #isSetCauseTexts()
	 * @see #unsetCauseTexts()
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_CauseTexts()
	 * @model unsettable="true"
	 * @generated
	 */
  EList<String> getCauseTexts();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCauseTexts <em>Cause Texts</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetCauseTexts()
	 * @see #getCauseTexts()
	 * @generated
	 */
  void unsetCauseTexts();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCauseTexts <em>Cause Texts</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cause Texts</em>' attribute list is set.
	 * @see #unsetCauseTexts()
	 * @see #getCauseTexts()
	 * @generated
	 */
  boolean isSetCauseTexts();

  /**
	 * Returns the value of the '<em><b>Applicability Texts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applicability Texts</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicability Texts</em>' attribute list.
	 * @see #isSetApplicabilityTexts()
	 * @see #unsetApplicabilityTexts()
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_ApplicabilityTexts()
	 * @model unsettable="true"
	 * @generated
	 */
  EList<String> getApplicabilityTexts();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getApplicabilityTexts <em>Applicability Texts</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetApplicabilityTexts()
	 * @see #getApplicabilityTexts()
	 * @generated
	 */
  void unsetApplicabilityTexts();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getApplicabilityTexts <em>Applicability Texts</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applicability Texts</em>' attribute list is set.
	 * @see #unsetApplicabilityTexts()
	 * @see #getApplicabilityTexts()
	 * @generated
	 */
  boolean isSetApplicabilityTexts();

  /**
	 * Returns the value of the '<em><b>Advice Texts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Advice Texts</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice Texts</em>' attribute list.
	 * @see #isSetAdviceTexts()
	 * @see #unsetAdviceTexts()
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_AdviceTexts()
	 * @model unsettable="true"
	 * @generated
	 */
  EList<String> getAdviceTexts();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAdviceTexts <em>Advice Texts</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAdviceTexts()
	 * @see #getAdviceTexts()
	 * @generated
	 */
  void unsetAdviceTexts();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAdviceTexts <em>Advice Texts</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Advice Texts</em>' attribute list is set.
	 * @see #unsetAdviceTexts()
	 * @see #getAdviceTexts()
	 * @generated
	 */
  boolean isSetAdviceTexts();

  /**
	 * Returns the value of the '<em><b>Category Ids</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category Ids</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Category Ids</em>' attribute list.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_CategoryIds()
	 * @model
	 * @generated
	 */
  EList<Integer> getCategoryIds();

  /**
	 * Returns the value of the '<em><b>Location Bounding Box</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location Bounding Box</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Location Bounding Box</em>' containment reference.
	 * @see #setLocationBoundingBox(RectangularArea)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_LocationBoundingBox()
	 * @model containment="true" required="true"
	 * @generated
	 */
  RectangularArea getLocationBoundingBox();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocationBoundingBox <em>Location Bounding Box</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location Bounding Box</em>' containment reference.
	 * @see #getLocationBoundingBox()
	 * @generated
	 */
  void setLocationBoundingBox(RectangularArea value);

		/**
	 * Returns the value of the '<em><b>Expected Speed Absolute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expected Speed Absolute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected Speed Absolute</em>' attribute.
	 * @see #isSetExpectedSpeedAbsolute()
	 * @see #unsetExpectedSpeedAbsolute()
	 * @see #setExpectedSpeedAbsolute(Integer)
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_ExpectedSpeedAbsolute()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getExpectedSpeedAbsolute();

		/**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected Speed Absolute</em>' attribute.
	 * @see #isSetExpectedSpeedAbsolute()
	 * @see #unsetExpectedSpeedAbsolute()
	 * @see #getExpectedSpeedAbsolute()
	 * @generated
	 */
	void setExpectedSpeedAbsolute(Integer value);

		/**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExpectedSpeedAbsolute()
	 * @see #getExpectedSpeedAbsolute()
	 * @see #setExpectedSpeedAbsolute(Integer)
	 * @generated
	 */
	void unsetExpectedSpeedAbsolute();

		/**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expected Speed Absolute</em>' attribute is set.
	 * @see #unsetExpectedSpeedAbsolute()
	 * @see #getExpectedSpeedAbsolute()
	 * @see #setExpectedSpeedAbsolute(Integer)
	 * @generated
	 */
	boolean isSetExpectedSpeedAbsolute();

		/**
	 * Returns the value of the '<em><b>Temporary Speed Limit</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temporary Speed Limit</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temporary Speed Limit</em>' containment reference list.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage#getTrafficIncident_TemporarySpeedLimit()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemporarySpeedLimit> getTemporarySpeedLimit();

} // TrafficIncident
