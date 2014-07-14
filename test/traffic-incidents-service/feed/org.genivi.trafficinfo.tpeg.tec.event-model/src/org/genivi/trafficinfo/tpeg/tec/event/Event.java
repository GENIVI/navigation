/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getEffectCode <em>Effect Code</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getTendency <em>Tendency</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getLengthAffected <em>Length Affected</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getDelay <em>Delay</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getSegmentSpeedLimit <em>Segment Speed Limit</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getCause <em>Cause</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getAdvice <em>Advice</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getVehicleRestriction <em>Vehicle Restriction</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getTemporarySpeedLimit <em>Temporary Speed Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends EObject {
	/**
	 * Returns the value of the '<em><b>Effect Code</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficinfo.tpeg.tec.event.EffectCode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effect Code</em>' attribute.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EffectCode
	 * @see #isSetEffectCode()
	 * @see #unsetEffectCode()
	 * @see #setEffectCode(EffectCode)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_EffectCode()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
	EffectCode getEffectCode();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getEffectCode <em>Effect Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect Code</em>' attribute.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EffectCode
	 * @see #isSetEffectCode()
	 * @see #unsetEffectCode()
	 * @see #getEffectCode()
	 * @generated
	 */
	void setEffectCode(EffectCode value);

	/**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getEffectCode <em>Effect Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetEffectCode()
	 * @see #getEffectCode()
	 * @see #setEffectCode(EffectCode)
	 * @generated
	 */
  void unsetEffectCode();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getEffectCode <em>Effect Code</em>}' attribute is set.
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
	 * <!-- begin-model-doc -->
	 * TODO: TEC MODEL  change type to TPEG DateTime
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #isSetStartTime()
	 * @see #unsetStartTime()
	 * @see #setStartTime(Date)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_StartTime()
	 * @model unsettable="true"
	 * @generated
	 */
	Date getStartTime();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getStartTime <em>Start Time</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetStartTime()
	 * @see #getStartTime()
	 * @see #setStartTime(Date)
	 * @generated
	 */
  void unsetStartTime();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getStartTime <em>Start Time</em>}' attribute is set.
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
	 * <!-- begin-model-doc -->
	 * TODO: TEC MODEL  change type to TPEG DateTime
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stop Time</em>' attribute.
	 * @see #isSetStopTime()
	 * @see #unsetStopTime()
	 * @see #setStopTime(Date)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_StopTime()
	 * @model unsettable="true"
	 * @generated
	 */
	Date getStopTime();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getStopTime <em>Stop Time</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getStopTime <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetStopTime()
	 * @see #getStopTime()
	 * @see #setStopTime(Date)
	 * @generated
	 */
  void unsetStopTime();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getStopTime <em>Stop Time</em>}' attribute is set.
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
	 * The literals are from the enumeration {@link org.genivi.trafficinfo.tpeg.tec.event.Tendency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tendency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tendency</em>' attribute.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Tendency
	 * @see #isSetTendency()
	 * @see #unsetTendency()
	 * @see #setTendency(Tendency)
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_Tendency()
	 * @model unsettable="true"
	 * @generated
	 */
	Tendency getTendency();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getTendency <em>Tendency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tendency</em>' attribute.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Tendency
	 * @see #isSetTendency()
	 * @see #unsetTendency()
	 * @see #getTendency()
	 * @generated
	 */
	void setTendency(Tendency value);

	/**
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getTendency <em>Tendency</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetTendency()
	 * @see #getTendency()
	 * @see #setTendency(Tendency)
	 * @generated
	 */
  void unsetTendency();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getTendency <em>Tendency</em>}' attribute is set.
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
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_LengthAffected()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getLengthAffected();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getLengthAffected <em>Length Affected</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getLengthAffected <em>Length Affected</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetLengthAffected()
	 * @see #getLengthAffected()
	 * @see #setLengthAffected(Integer)
	 * @generated
	 */
  void unsetLengthAffected();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getLengthAffected <em>Length Affected</em>}' attribute is set.
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
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_AverageSpeedAbsolute()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getAverageSpeedAbsolute();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAverageSpeedAbsolute()
	 * @see #getAverageSpeedAbsolute()
	 * @see #setAverageSpeedAbsolute(Integer)
	 * @generated
	 */
  void unsetAverageSpeedAbsolute();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}' attribute is set.
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
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_Delay()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getDelay();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getDelay <em>Delay</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetDelay()
	 * @see #getDelay()
	 * @see #setDelay(Integer)
	 * @generated
	 */
  void unsetDelay();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getDelay <em>Delay</em>}' attribute is set.
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
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_SegmentSpeedLimit()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getSegmentSpeedLimit();

	/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getSegmentSpeedLimit <em>Segment Speed Limit</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getSegmentSpeedLimit <em>Segment Speed Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetSegmentSpeedLimit()
	 * @see #getSegmentSpeedLimit()
	 * @see #setSegmentSpeedLimit(Integer)
	 * @generated
	 */
  void unsetSegmentSpeedLimit();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getSegmentSpeedLimit <em>Segment Speed Limit</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Cause</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tec.event.Cause}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cause</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Cause</em>' containment reference list.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_Cause()
	 * @model containment="true"
	 * @generated
	 */
  EList<Cause> getCause();

  /**
	 * Returns the value of the '<em><b>Advice</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tec.event.Advice}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Advice</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice</em>' containment reference list.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_Advice()
	 * @model containment="true"
	 * @generated
	 */
  EList<Advice> getAdvice();

  /**
	 * Returns the value of the '<em><b>Vehicle Restriction</b></em>' containment reference list.
	 * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vehicle Restriction</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Restriction</em>' containment reference list.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_VehicleRestriction()
	 * @model containment="true"
	 * @generated
	 */
  EList<VehicleRestriction> getVehicleRestriction();

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
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_ExpectedSpeedAbsolute()
	 * @model unsettable="true"
	 * @generated
	 */
	Integer getExpectedSpeedAbsolute();

		/**
	 * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}' attribute.
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
	 * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExpectedSpeedAbsolute()
	 * @see #getExpectedSpeedAbsolute()
	 * @see #setExpectedSpeedAbsolute(Integer)
	 * @generated
	 */
	void unsetExpectedSpeedAbsolute();

		/**
	 * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}' attribute is set.
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
	 * The list contents are of type {@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temporary Speed Limit</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temporary Speed Limit</em>' containment reference list.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EventPackage#getEvent_TemporarySpeedLimit()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemporarySpeedLimit> getTemporarySpeedLimit();

} // Event
