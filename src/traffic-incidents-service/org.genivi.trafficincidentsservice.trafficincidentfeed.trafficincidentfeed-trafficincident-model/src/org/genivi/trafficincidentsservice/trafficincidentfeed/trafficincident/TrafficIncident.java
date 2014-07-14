/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.genivi.locref.LocationReference;

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
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getEffectCode <em>Effect Code</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTendency <em>Tendency</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLengthAffected <em>Length Affected</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getDelay <em>Delay</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getSegmentSpeedLimit <em>Segment Speed Limit</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getCauses <em>Causes</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAdvices <em>Advices</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getApplicability <em>Applicability</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTrafficIncidentId <em>Traffic Incident Id</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpirationTime <em>Expiration Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getUpdateTime <em>Update Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLocationReference <em>Location Reference</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTemporarySpeedLimit <em>Temporary Speed Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident()
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
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_EffectCode()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  EffectCode getEffectCode();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getEffectCode <em>Effect Code</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getEffectCode <em>Effect Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetEffectCode()
	 * @see #getEffectCode()
	 * @see #setEffectCode(EffectCode)
	 * @generated
	 */
  void unsetEffectCode();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getEffectCode <em>Effect Code</em>}' attribute is set.
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
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_StartTime()
	 * @model unsettable="true"
	 * @generated
	 */
  Date getStartTime();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStartTime <em>Start Time</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetStartTime()
	 * @see #getStartTime()
	 * @see #setStartTime(Date)
	 * @generated
	 */
  void unsetStartTime();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStartTime <em>Start Time</em>}' attribute is set.
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
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_StopTime()
	 * @model unsettable="true"
	 * @generated
	 */
  Date getStopTime();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStopTime <em>Stop Time</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStopTime <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetStopTime()
	 * @see #getStopTime()
	 * @see #setStopTime(Date)
	 * @generated
	 */
  void unsetStopTime();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStopTime <em>Stop Time</em>}' attribute is set.
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
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_Tendency()
	 * @model unsettable="true"
	 * @generated
	 */
  Tendency getTendency();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTendency <em>Tendency</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTendency <em>Tendency</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetTendency()
	 * @see #getTendency()
	 * @see #setTendency(Tendency)
	 * @generated
	 */
  void unsetTendency();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTendency <em>Tendency</em>}' attribute is set.
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
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_LengthAffected()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getLengthAffected();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLengthAffected <em>Length Affected</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLengthAffected <em>Length Affected</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLengthAffected()
	 * @see #getLengthAffected()
	 * @see #setLengthAffected(Integer)
	 * @generated
	 */
  void unsetLengthAffected();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLengthAffected <em>Length Affected</em>}' attribute is set.
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
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_AverageSpeedAbsolute()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getAverageSpeedAbsolute();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAverageSpeedAbsolute()
	 * @see #getAverageSpeedAbsolute()
	 * @see #setAverageSpeedAbsolute(Integer)
	 * @generated
	 */
  void unsetAverageSpeedAbsolute();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}' attribute is set.
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
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_Delay()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getDelay();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getDelay <em>Delay</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetDelay()
	 * @see #getDelay()
	 * @see #setDelay(Integer)
	 * @generated
	 */
  void unsetDelay();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getDelay <em>Delay</em>}' attribute is set.
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
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_SegmentSpeedLimit()
	 * @model unsettable="true"
	 * @generated
	 */
  Integer getSegmentSpeedLimit();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getSegmentSpeedLimit <em>Segment Speed Limit</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getSegmentSpeedLimit <em>Segment Speed Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSegmentSpeedLimit()
	 * @see #getSegmentSpeedLimit()
	 * @see #setSegmentSpeedLimit(Integer)
	 * @generated
	 */
  void unsetSegmentSpeedLimit();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getSegmentSpeedLimit <em>Segment Speed Limit</em>}' attribute is set.
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
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Causes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Causes</em>' containment reference list.
	 * @see #isSetCauses()
	 * @see #unsetCauses()
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_Causes()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<Cause> getCauses();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getCauses <em>Causes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetCauses()
	 * @see #getCauses()
	 * @generated
	 */
  void unsetCauses();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getCauses <em>Causes</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Causes</em>' containment reference list is set.
	 * @see #unsetCauses()
	 * @see #getCauses()
	 * @generated
	 */
  boolean isSetCauses();

  /**
	 * Returns the value of the '<em><b>Advices</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Advices</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Advices</em>' containment reference list.
	 * @see #isSetAdvices()
	 * @see #unsetAdvices()
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_Advices()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<Advice> getAdvices();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAdvices <em>Advices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAdvices()
	 * @see #getAdvices()
	 * @generated
	 */
  void unsetAdvices();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAdvices <em>Advices</em>}' containment reference list is set.
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
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applicability</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicability</em>' containment reference list.
	 * @see #isSetApplicability()
	 * @see #unsetApplicability()
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_Applicability()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
  EList<Applicability> getApplicability();

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getApplicability <em>Applicability</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetApplicability()
	 * @see #getApplicability()
	 * @generated
	 */
  void unsetApplicability();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getApplicability <em>Applicability</em>}' containment reference list is set.
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
	 * @see #setTrafficIncidentId(String)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_TrafficIncidentId()
	 * @model unsettable="true"
	 * @generated
	 */
  String getTrafficIncidentId();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTrafficIncidentId <em>Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traffic Incident Id</em>' attribute.
	 * @see #isSetTrafficIncidentId()
	 * @see #unsetTrafficIncidentId()
	 * @see #getTrafficIncidentId()
	 * @generated
	 */
  void setTrafficIncidentId(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTrafficIncidentId <em>Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetTrafficIncidentId()
	 * @see #getTrafficIncidentId()
	 * @see #setTrafficIncidentId(String)
	 * @generated
	 */
  void unsetTrafficIncidentId();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTrafficIncidentId <em>Traffic Incident Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Traffic Incident Id</em>' attribute is set.
	 * @see #unsetTrafficIncidentId()
	 * @see #getTrafficIncidentId()
	 * @see #setTrafficIncidentId(String)
	 * @generated
	 */
  boolean isSetTrafficIncidentId();

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
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_ExpectedSpeedAbsolute()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getExpectedSpeedAbsolute();

		/**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExpectedSpeedAbsolute()
	 * @see #getExpectedSpeedAbsolute()
	 * @see #setExpectedSpeedAbsolute(Integer)
	 * @generated
	 */
	void unsetExpectedSpeedAbsolute();

		/**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Expiration Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expiration Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Expiration Time</em>' attribute.
	 * @see #isSetExpirationTime()
	 * @see #unsetExpirationTime()
	 * @see #setExpirationTime(Date)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_ExpirationTime()
	 * @model unsettable="true"
	 * @generated
	 */
  Date getExpirationTime();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpirationTime <em>Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expiration Time</em>' attribute.
	 * @see #isSetExpirationTime()
	 * @see #unsetExpirationTime()
	 * @see #getExpirationTime()
	 * @generated
	 */
  void setExpirationTime(Date value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpirationTime <em>Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetExpirationTime()
	 * @see #getExpirationTime()
	 * @see #setExpirationTime(Date)
	 * @generated
	 */
  void unsetExpirationTime();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpirationTime <em>Expiration Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expiration Time</em>' attribute is set.
	 * @see #unsetExpirationTime()
	 * @see #getExpirationTime()
	 * @see #setExpirationTime(Date)
	 * @generated
	 */
  boolean isSetExpirationTime();

  /**
	 * Returns the value of the '<em><b>Update Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Update Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Update Time</em>' attribute.
	 * @see #isSetUpdateTime()
	 * @see #unsetUpdateTime()
	 * @see #setUpdateTime(Date)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_UpdateTime()
	 * @model unsettable="true"
	 * @generated
	 */
  Date getUpdateTime();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getUpdateTime <em>Update Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update Time</em>' attribute.
	 * @see #isSetUpdateTime()
	 * @see #unsetUpdateTime()
	 * @see #getUpdateTime()
	 * @generated
	 */
  void setUpdateTime(Date value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getUpdateTime <em>Update Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetUpdateTime()
	 * @see #getUpdateTime()
	 * @see #setUpdateTime(Date)
	 * @generated
	 */
  void unsetUpdateTime();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getUpdateTime <em>Update Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Update Time</em>' attribute is set.
	 * @see #unsetUpdateTime()
	 * @see #getUpdateTime()
	 * @see #setUpdateTime(Date)
	 * @generated
	 */
  boolean isSetUpdateTime();

  /**
	 * Returns the value of the '<em><b>Location Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Location Reference</em>' containment reference.
	 * @see #isSetLocationReference()
	 * @see #unsetLocationReference()
	 * @see #setLocationReference(LocationReference)
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_LocationReference()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
  LocationReference getLocationReference();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLocationReference <em>Location Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location Reference</em>' containment reference.
	 * @see #isSetLocationReference()
	 * @see #unsetLocationReference()
	 * @see #getLocationReference()
	 * @generated
	 */
  void setLocationReference(LocationReference value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLocationReference <em>Location Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLocationReference()
	 * @see #getLocationReference()
	 * @see #setLocationReference(LocationReference)
	 * @generated
	 */
  void unsetLocationReference();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLocationReference <em>Location Reference</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Location Reference</em>' containment reference is set.
	 * @see #unsetLocationReference()
	 * @see #getLocationReference()
	 * @see #setLocationReference(LocationReference)
	 * @generated
	 */
  boolean isSetLocationReference();

		/**
	 * Returns the value of the '<em><b>Temporary Speed Limit</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temporary Speed Limit</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temporary Speed Limit</em>' containment reference list.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage#getTrafficIncident_TemporarySpeedLimit()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemporarySpeedLimit> getTemporarySpeedLimit();

} // TrafficIncident
