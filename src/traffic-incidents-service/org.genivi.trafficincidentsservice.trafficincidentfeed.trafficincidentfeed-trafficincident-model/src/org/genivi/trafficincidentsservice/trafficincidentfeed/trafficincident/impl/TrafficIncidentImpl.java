/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genivi.locref.LocationReference;

import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode;
import org.genivi.trafficincidentsservice.trafficincidenttables.Tendency;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traffic Incident</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getEffectCode <em>Effect Code</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getTendency <em>Tendency</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getLengthAffected <em>Length Affected</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getDelay <em>Delay</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getSegmentSpeedLimit <em>Segment Speed Limit</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getCauses <em>Causes</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getAdvices <em>Advices</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getApplicability <em>Applicability</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getTrafficIncidentId <em>Traffic Incident Id</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getExpirationTime <em>Expiration Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getUpdateTime <em>Update Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getLocationReference <em>Location Reference</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl#getTemporarySpeedLimit <em>Temporary Speed Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TrafficIncidentImpl extends EObjectImpl implements TrafficIncident {
  /**
	 * The default value of the '{@link #getEffectCode() <em>Effect Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEffectCode()
	 * @generated
	 * @ordered
	 */
  protected static final EffectCode EFFECT_CODE_EDEFAULT = EffectCode.TRAFFIC_FLOW_UNKNOWN;

  /**
	 * The cached value of the '{@link #getEffectCode() <em>Effect Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEffectCode()
	 * @generated
	 * @ordered
	 */
  protected EffectCode effectCode = EFFECT_CODE_EDEFAULT;

  /**
	 * This is true if the Effect Code attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean effectCodeESet;

  /**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
  protected static final Date START_TIME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
  protected Date startTime = START_TIME_EDEFAULT;

  /**
	 * This is true if the Start Time attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean startTimeESet;

  /**
	 * The default value of the '{@link #getStopTime() <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getStopTime()
	 * @generated
	 * @ordered
	 */
  protected static final Date STOP_TIME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getStopTime() <em>Stop Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getStopTime()
	 * @generated
	 * @ordered
	 */
  protected Date stopTime = STOP_TIME_EDEFAULT;

  /**
	 * This is true if the Stop Time attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean stopTimeESet;

  /**
	 * The default value of the '{@link #getTendency() <em>Tendency</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTendency()
	 * @generated
	 * @ordered
	 */
  protected static final Tendency TENDENCY_EDEFAULT = Tendency.SLIGHTLY_INCREASING;

  /**
	 * The cached value of the '{@link #getTendency() <em>Tendency</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTendency()
	 * @generated
	 * @ordered
	 */
  protected Tendency tendency = TENDENCY_EDEFAULT;

  /**
	 * This is true if the Tendency attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean tendencyESet;

  /**
	 * The default value of the '{@link #getLengthAffected() <em>Length Affected</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLengthAffected()
	 * @generated
	 * @ordered
	 */
  protected static final Integer LENGTH_AFFECTED_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getLengthAffected() <em>Length Affected</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLengthAffected()
	 * @generated
	 * @ordered
	 */
  protected Integer lengthAffected = LENGTH_AFFECTED_EDEFAULT;

  /**
	 * This is true if the Length Affected attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean lengthAffectedESet;

  /**
	 * The default value of the '{@link #getAverageSpeedAbsolute() <em>Average Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAverageSpeedAbsolute()
	 * @generated
	 * @ordered
	 */
  protected static final Integer AVERAGE_SPEED_ABSOLUTE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getAverageSpeedAbsolute() <em>Average Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAverageSpeedAbsolute()
	 * @generated
	 * @ordered
	 */
  protected Integer averageSpeedAbsolute = AVERAGE_SPEED_ABSOLUTE_EDEFAULT;

  /**
	 * This is true if the Average Speed Absolute attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean averageSpeedAbsoluteESet;

  /**
	 * The default value of the '{@link #getDelay() <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDelay()
	 * @generated
	 * @ordered
	 */
  protected static final Integer DELAY_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getDelay() <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDelay()
	 * @generated
	 * @ordered
	 */
  protected Integer delay = DELAY_EDEFAULT;

  /**
	 * This is true if the Delay attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean delayESet;

  /**
	 * The default value of the '{@link #getSegmentSpeedLimit() <em>Segment Speed Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSegmentSpeedLimit()
	 * @generated
	 * @ordered
	 */
  protected static final Integer SEGMENT_SPEED_LIMIT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getSegmentSpeedLimit() <em>Segment Speed Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSegmentSpeedLimit()
	 * @generated
	 * @ordered
	 */
  protected Integer segmentSpeedLimit = SEGMENT_SPEED_LIMIT_EDEFAULT;

  /**
	 * This is true if the Segment Speed Limit attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean segmentSpeedLimitESet;

  /**
	 * The cached value of the '{@link #getCauses() <em>Causes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCauses()
	 * @generated
	 * @ordered
	 */
  protected EList<Cause> causes;

  /**
	 * The cached value of the '{@link #getAdvices() <em>Advices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAdvices()
	 * @generated
	 * @ordered
	 */
  protected EList<Advice> advices;

  /**
	 * The cached value of the '{@link #getApplicability() <em>Applicability</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getApplicability()
	 * @generated
	 * @ordered
	 */
  protected EList<Applicability> applicability;

  /**
	 * The default value of the '{@link #getTrafficIncidentId() <em>Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTrafficIncidentId()
	 * @generated
	 * @ordered
	 */
  protected static final String TRAFFIC_INCIDENT_ID_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getTrafficIncidentId() <em>Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTrafficIncidentId()
	 * @generated
	 * @ordered
	 */
  protected String trafficIncidentId = TRAFFIC_INCIDENT_ID_EDEFAULT;

  /**
	 * This is true if the Traffic Incident Id attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean trafficIncidentIdESet;

  /**
	 * The default value of the '{@link #getExpectedSpeedAbsolute() <em>Expected Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpectedSpeedAbsolute()
	 * @generated
	 * @ordered
	 */
	protected static final Integer EXPECTED_SPEED_ABSOLUTE_EDEFAULT = null;

		/**
	 * The cached value of the '{@link #getExpectedSpeedAbsolute() <em>Expected Speed Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpectedSpeedAbsolute()
	 * @generated
	 * @ordered
	 */
	protected Integer expectedSpeedAbsolute = EXPECTED_SPEED_ABSOLUTE_EDEFAULT;

		/**
	 * This is true if the Expected Speed Absolute attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean expectedSpeedAbsoluteESet;

		/**
	 * The default value of the '{@link #getExpirationTime() <em>Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExpirationTime()
	 * @generated
	 * @ordered
	 */
  protected static final Date EXPIRATION_TIME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getExpirationTime() <em>Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExpirationTime()
	 * @generated
	 * @ordered
	 */
  protected Date expirationTime = EXPIRATION_TIME_EDEFAULT;

  /**
	 * This is true if the Expiration Time attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean expirationTimeESet;

  /**
	 * The default value of the '{@link #getUpdateTime() <em>Update Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUpdateTime()
	 * @generated
	 * @ordered
	 */
  protected static final Date UPDATE_TIME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getUpdateTime() <em>Update Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUpdateTime()
	 * @generated
	 * @ordered
	 */
  protected Date updateTime = UPDATE_TIME_EDEFAULT;

  /**
	 * This is true if the Update Time attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean updateTimeESet;

  /**
	 * The cached value of the '{@link #getLocationReference() <em>Location Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocationReference()
	 * @generated
	 * @ordered
	 */
  protected LocationReference locationReference;

  /**
	 * This is true if the Location Reference containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean locationReferenceESet;

  /**
	 * The cached value of the '{@link #getTemporarySpeedLimit() <em>Temporary Speed Limit</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 * @ordered
	 */
	protected EList<TemporarySpeedLimit> temporarySpeedLimit;

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TrafficIncidentImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return XTrafficIncidentPackage.Literals.TRAFFIC_INCIDENT;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EffectCode getEffectCode() {
		return effectCode;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setEffectCode(EffectCode newEffectCode) {
		EffectCode oldEffectCode = effectCode;
		effectCode = newEffectCode == null ? EFFECT_CODE_EDEFAULT : newEffectCode;
		boolean oldEffectCodeESet = effectCodeESet;
		effectCodeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE, oldEffectCode, effectCode, !oldEffectCodeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetEffectCode() {
		EffectCode oldEffectCode = effectCode;
		boolean oldEffectCodeESet = effectCodeESet;
		effectCode = EFFECT_CODE_EDEFAULT;
		effectCodeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE, oldEffectCode, EFFECT_CODE_EDEFAULT, oldEffectCodeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetEffectCode() {
		return effectCodeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Date getStartTime() {
		return startTime;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setStartTime(Date newStartTime) {
		Date oldStartTime = startTime;
		startTime = newStartTime;
		boolean oldStartTimeESet = startTimeESet;
		startTimeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__START_TIME, oldStartTime, startTime, !oldStartTimeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetStartTime() {
		Date oldStartTime = startTime;
		boolean oldStartTimeESet = startTimeESet;
		startTime = START_TIME_EDEFAULT;
		startTimeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__START_TIME, oldStartTime, START_TIME_EDEFAULT, oldStartTimeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetStartTime() {
		return startTimeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Date getStopTime() {
		return stopTime;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setStopTime(Date newStopTime) {
		Date oldStopTime = stopTime;
		stopTime = newStopTime;
		boolean oldStopTimeESet = stopTimeESet;
		stopTimeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__STOP_TIME, oldStopTime, stopTime, !oldStopTimeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetStopTime() {
		Date oldStopTime = stopTime;
		boolean oldStopTimeESet = stopTimeESet;
		stopTime = STOP_TIME_EDEFAULT;
		stopTimeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__STOP_TIME, oldStopTime, STOP_TIME_EDEFAULT, oldStopTimeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetStopTime() {
		return stopTimeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Tendency getTendency() {
		return tendency;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTendency(Tendency newTendency) {
		Tendency oldTendency = tendency;
		tendency = newTendency == null ? TENDENCY_EDEFAULT : newTendency;
		boolean oldTendencyESet = tendencyESet;
		tendencyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__TENDENCY, oldTendency, tendency, !oldTendencyESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetTendency() {
		Tendency oldTendency = tendency;
		boolean oldTendencyESet = tendencyESet;
		tendency = TENDENCY_EDEFAULT;
		tendencyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__TENDENCY, oldTendency, TENDENCY_EDEFAULT, oldTendencyESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetTendency() {
		return tendencyESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getLengthAffected() {
		return lengthAffected;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLengthAffected(Integer newLengthAffected) {
		Integer oldLengthAffected = lengthAffected;
		lengthAffected = newLengthAffected;
		boolean oldLengthAffectedESet = lengthAffectedESet;
		lengthAffectedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED, oldLengthAffected, lengthAffected, !oldLengthAffectedESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLengthAffected() {
		Integer oldLengthAffected = lengthAffected;
		boolean oldLengthAffectedESet = lengthAffectedESet;
		lengthAffected = LENGTH_AFFECTED_EDEFAULT;
		lengthAffectedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED, oldLengthAffected, LENGTH_AFFECTED_EDEFAULT, oldLengthAffectedESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLengthAffected() {
		return lengthAffectedESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getAverageSpeedAbsolute() {
		return averageSpeedAbsolute;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAverageSpeedAbsolute(Integer newAverageSpeedAbsolute) {
		Integer oldAverageSpeedAbsolute = averageSpeedAbsolute;
		averageSpeedAbsolute = newAverageSpeedAbsolute;
		boolean oldAverageSpeedAbsoluteESet = averageSpeedAbsoluteESet;
		averageSpeedAbsoluteESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE, oldAverageSpeedAbsolute, averageSpeedAbsolute, !oldAverageSpeedAbsoluteESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetAverageSpeedAbsolute() {
		Integer oldAverageSpeedAbsolute = averageSpeedAbsolute;
		boolean oldAverageSpeedAbsoluteESet = averageSpeedAbsoluteESet;
		averageSpeedAbsolute = AVERAGE_SPEED_ABSOLUTE_EDEFAULT;
		averageSpeedAbsoluteESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE, oldAverageSpeedAbsolute, AVERAGE_SPEED_ABSOLUTE_EDEFAULT, oldAverageSpeedAbsoluteESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetAverageSpeedAbsolute() {
		return averageSpeedAbsoluteESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getDelay() {
		return delay;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDelay(Integer newDelay) {
		Integer oldDelay = delay;
		delay = newDelay;
		boolean oldDelayESet = delayESet;
		delayESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__DELAY, oldDelay, delay, !oldDelayESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetDelay() {
		Integer oldDelay = delay;
		boolean oldDelayESet = delayESet;
		delay = DELAY_EDEFAULT;
		delayESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__DELAY, oldDelay, DELAY_EDEFAULT, oldDelayESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetDelay() {
		return delayESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getSegmentSpeedLimit() {
		return segmentSpeedLimit;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSegmentSpeedLimit(Integer newSegmentSpeedLimit) {
		Integer oldSegmentSpeedLimit = segmentSpeedLimit;
		segmentSpeedLimit = newSegmentSpeedLimit;
		boolean oldSegmentSpeedLimitESet = segmentSpeedLimitESet;
		segmentSpeedLimitESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT, oldSegmentSpeedLimit, segmentSpeedLimit, !oldSegmentSpeedLimitESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetSegmentSpeedLimit() {
		Integer oldSegmentSpeedLimit = segmentSpeedLimit;
		boolean oldSegmentSpeedLimitESet = segmentSpeedLimitESet;
		segmentSpeedLimit = SEGMENT_SPEED_LIMIT_EDEFAULT;
		segmentSpeedLimitESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT, oldSegmentSpeedLimit, SEGMENT_SPEED_LIMIT_EDEFAULT, oldSegmentSpeedLimitESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetSegmentSpeedLimit() {
		return segmentSpeedLimitESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Cause> getCauses() {
		if (causes == null) {
			causes = new EObjectContainmentEList.Unsettable<Cause>(Cause.class, this, XTrafficIncidentPackage.TRAFFIC_INCIDENT__CAUSES);
		}
		return causes;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetCauses() {
		if (causes != null) ((InternalEList.Unsettable<?>)causes).unset();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetCauses() {
		return causes != null && ((InternalEList.Unsettable<?>)causes).isSet();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Advice> getAdvices() {
		if (advices == null) {
			advices = new EObjectContainmentEList.Unsettable<Advice>(Advice.class, this, XTrafficIncidentPackage.TRAFFIC_INCIDENT__ADVICES);
		}
		return advices;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetAdvices() {
		if (advices != null) ((InternalEList.Unsettable<?>)advices).unset();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetAdvices() {
		return advices != null && ((InternalEList.Unsettable<?>)advices).isSet();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Applicability> getApplicability() {
		if (applicability == null) {
			applicability = new EObjectContainmentEList.Unsettable<Applicability>(Applicability.class, this, XTrafficIncidentPackage.TRAFFIC_INCIDENT__APPLICABILITY);
		}
		return applicability;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetApplicability() {
		if (applicability != null) ((InternalEList.Unsettable<?>)applicability).unset();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetApplicability() {
		return applicability != null && ((InternalEList.Unsettable<?>)applicability).isSet();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getTrafficIncidentId() {
		return trafficIncidentId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTrafficIncidentId(String newTrafficIncidentId) {
		String oldTrafficIncidentId = trafficIncidentId;
		trafficIncidentId = newTrafficIncidentId;
		boolean oldTrafficIncidentIdESet = trafficIncidentIdESet;
		trafficIncidentIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID, oldTrafficIncidentId, trafficIncidentId, !oldTrafficIncidentIdESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetTrafficIncidentId() {
		String oldTrafficIncidentId = trafficIncidentId;
		boolean oldTrafficIncidentIdESet = trafficIncidentIdESet;
		trafficIncidentId = TRAFFIC_INCIDENT_ID_EDEFAULT;
		trafficIncidentIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID, oldTrafficIncidentId, TRAFFIC_INCIDENT_ID_EDEFAULT, oldTrafficIncidentIdESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetTrafficIncidentId() {
		return trafficIncidentIdESet;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getExpectedSpeedAbsolute() {
		return expectedSpeedAbsolute;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpectedSpeedAbsolute(Integer newExpectedSpeedAbsolute) {
		Integer oldExpectedSpeedAbsolute = expectedSpeedAbsolute;
		expectedSpeedAbsolute = newExpectedSpeedAbsolute;
		boolean oldExpectedSpeedAbsoluteESet = expectedSpeedAbsoluteESet;
		expectedSpeedAbsoluteESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE, oldExpectedSpeedAbsolute, expectedSpeedAbsolute, !oldExpectedSpeedAbsoluteESet));
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExpectedSpeedAbsolute() {
		Integer oldExpectedSpeedAbsolute = expectedSpeedAbsolute;
		boolean oldExpectedSpeedAbsoluteESet = expectedSpeedAbsoluteESet;
		expectedSpeedAbsolute = EXPECTED_SPEED_ABSOLUTE_EDEFAULT;
		expectedSpeedAbsoluteESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE, oldExpectedSpeedAbsolute, EXPECTED_SPEED_ABSOLUTE_EDEFAULT, oldExpectedSpeedAbsoluteESet));
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExpectedSpeedAbsolute() {
		return expectedSpeedAbsoluteESet;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Date getExpirationTime() {
		return expirationTime;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setExpirationTime(Date newExpirationTime) {
		Date oldExpirationTime = expirationTime;
		expirationTime = newExpirationTime;
		boolean oldExpirationTimeESet = expirationTimeESet;
		expirationTimeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPIRATION_TIME, oldExpirationTime, expirationTime, !oldExpirationTimeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetExpirationTime() {
		Date oldExpirationTime = expirationTime;
		boolean oldExpirationTimeESet = expirationTimeESet;
		expirationTime = EXPIRATION_TIME_EDEFAULT;
		expirationTimeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPIRATION_TIME, oldExpirationTime, EXPIRATION_TIME_EDEFAULT, oldExpirationTimeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetExpirationTime() {
		return expirationTimeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Date getUpdateTime() {
		return updateTime;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setUpdateTime(Date newUpdateTime) {
		Date oldUpdateTime = updateTime;
		updateTime = newUpdateTime;
		boolean oldUpdateTimeESet = updateTimeESet;
		updateTimeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__UPDATE_TIME, oldUpdateTime, updateTime, !oldUpdateTimeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetUpdateTime() {
		Date oldUpdateTime = updateTime;
		boolean oldUpdateTimeESet = updateTimeESet;
		updateTime = UPDATE_TIME_EDEFAULT;
		updateTimeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__UPDATE_TIME, oldUpdateTime, UPDATE_TIME_EDEFAULT, oldUpdateTimeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetUpdateTime() {
		return updateTimeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LocationReference getLocationReference() {
		return locationReference;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLocationReference(LocationReference newLocationReference, NotificationChain msgs) {
		LocationReference oldLocationReference = locationReference;
		locationReference = newLocationReference;
		boolean oldLocationReferenceESet = locationReferenceESet;
		locationReferenceESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE, oldLocationReference, newLocationReference, !oldLocationReferenceESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLocationReference(LocationReference newLocationReference) {
		if (newLocationReference != locationReference) {
			NotificationChain msgs = null;
			if (locationReference != null)
				msgs = ((InternalEObject)locationReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE, null, msgs);
			if (newLocationReference != null)
				msgs = ((InternalEObject)newLocationReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE, null, msgs);
			msgs = basicSetLocationReference(newLocationReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLocationReferenceESet = locationReferenceESet;
			locationReferenceESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE, newLocationReference, newLocationReference, !oldLocationReferenceESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetLocationReference(NotificationChain msgs) {
		LocationReference oldLocationReference = locationReference;
		locationReference = null;
		boolean oldLocationReferenceESet = locationReferenceESet;
		locationReferenceESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE, oldLocationReference, null, oldLocationReferenceESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLocationReference() {
		if (locationReference != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)locationReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE, null, msgs);
			msgs = basicUnsetLocationReference(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLocationReferenceESet = locationReferenceESet;
			locationReferenceESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE, null, null, oldLocationReferenceESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLocationReference() {
		return locationReferenceESet;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemporarySpeedLimit> getTemporarySpeedLimit() {
		if (temporarySpeedLimit == null) {
			temporarySpeedLimit = new EObjectContainmentEList<TemporarySpeedLimit>(TemporarySpeedLimit.class, this, XTrafficIncidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT);
		}
		return temporarySpeedLimit;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__CAUSES:
				return ((InternalEList<?>)getCauses()).basicRemove(otherEnd, msgs);
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__ADVICES:
				return ((InternalEList<?>)getAdvices()).basicRemove(otherEnd, msgs);
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__APPLICABILITY:
				return ((InternalEList<?>)getApplicability()).basicRemove(otherEnd, msgs);
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE:
				return basicUnsetLocationReference(msgs);
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT:
				return ((InternalEList<?>)getTemporarySpeedLimit()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE:
				return getEffectCode();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__START_TIME:
				return getStartTime();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__STOP_TIME:
				return getStopTime();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TENDENCY:
				return getTendency();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED:
				return getLengthAffected();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE:
				return getAverageSpeedAbsolute();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__DELAY:
				return getDelay();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT:
				return getSegmentSpeedLimit();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__CAUSES:
				return getCauses();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__ADVICES:
				return getAdvices();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__APPLICABILITY:
				return getApplicability();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID:
				return getTrafficIncidentId();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE:
				return getExpectedSpeedAbsolute();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPIRATION_TIME:
				return getExpirationTime();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__UPDATE_TIME:
				return getUpdateTime();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE:
				return getLocationReference();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT:
				return getTemporarySpeedLimit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE:
				setEffectCode((EffectCode)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__START_TIME:
				setStartTime((Date)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__STOP_TIME:
				setStopTime((Date)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TENDENCY:
				setTendency((Tendency)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED:
				setLengthAffected((Integer)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE:
				setAverageSpeedAbsolute((Integer)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__DELAY:
				setDelay((Integer)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT:
				setSegmentSpeedLimit((Integer)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__CAUSES:
				getCauses().clear();
				getCauses().addAll((Collection<? extends Cause>)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__ADVICES:
				getAdvices().clear();
				getAdvices().addAll((Collection<? extends Advice>)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__APPLICABILITY:
				getApplicability().clear();
				getApplicability().addAll((Collection<? extends Applicability>)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID:
				setTrafficIncidentId((String)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE:
				setExpectedSpeedAbsolute((Integer)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPIRATION_TIME:
				setExpirationTime((Date)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__UPDATE_TIME:
				setUpdateTime((Date)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE:
				setLocationReference((LocationReference)newValue);
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT:
				getTemporarySpeedLimit().clear();
				getTemporarySpeedLimit().addAll((Collection<? extends TemporarySpeedLimit>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE:
				unsetEffectCode();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__START_TIME:
				unsetStartTime();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__STOP_TIME:
				unsetStopTime();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TENDENCY:
				unsetTendency();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED:
				unsetLengthAffected();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE:
				unsetAverageSpeedAbsolute();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__DELAY:
				unsetDelay();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT:
				unsetSegmentSpeedLimit();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__CAUSES:
				unsetCauses();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__ADVICES:
				unsetAdvices();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__APPLICABILITY:
				unsetApplicability();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID:
				unsetTrafficIncidentId();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE:
				unsetExpectedSpeedAbsolute();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPIRATION_TIME:
				unsetExpirationTime();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__UPDATE_TIME:
				unsetUpdateTime();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE:
				unsetLocationReference();
				return;
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT:
				getTemporarySpeedLimit().clear();
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE:
				return isSetEffectCode();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__START_TIME:
				return isSetStartTime();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__STOP_TIME:
				return isSetStopTime();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TENDENCY:
				return isSetTendency();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED:
				return isSetLengthAffected();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE:
				return isSetAverageSpeedAbsolute();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__DELAY:
				return isSetDelay();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT:
				return isSetSegmentSpeedLimit();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__CAUSES:
				return isSetCauses();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__ADVICES:
				return isSetAdvices();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__APPLICABILITY:
				return isSetApplicability();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID:
				return isSetTrafficIncidentId();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE:
				return isSetExpectedSpeedAbsolute();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__EXPIRATION_TIME:
				return isSetExpirationTime();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__UPDATE_TIME:
				return isSetUpdateTime();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__LOCATION_REFERENCE:
				return isSetLocationReference();
			case XTrafficIncidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT:
				return temporarySpeedLimit != null && !temporarySpeedLimit.isEmpty();
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (effectCode: ");
		if (effectCodeESet) result.append(effectCode); else result.append("<unset>");
		result.append(", startTime: ");
		if (startTimeESet) result.append(startTime); else result.append("<unset>");
		result.append(", stopTime: ");
		if (stopTimeESet) result.append(stopTime); else result.append("<unset>");
		result.append(", tendency: ");
		if (tendencyESet) result.append(tendency); else result.append("<unset>");
		result.append(", lengthAffected: ");
		if (lengthAffectedESet) result.append(lengthAffected); else result.append("<unset>");
		result.append(", averageSpeedAbsolute: ");
		if (averageSpeedAbsoluteESet) result.append(averageSpeedAbsolute); else result.append("<unset>");
		result.append(", delay: ");
		if (delayESet) result.append(delay); else result.append("<unset>");
		result.append(", segmentSpeedLimit: ");
		if (segmentSpeedLimitESet) result.append(segmentSpeedLimit); else result.append("<unset>");
		result.append(", trafficIncidentId: ");
		if (trafficIncidentIdESet) result.append(trafficIncidentId); else result.append("<unset>");
		result.append(", expectedSpeedAbsolute: ");
		if (expectedSpeedAbsoluteESet) result.append(expectedSpeedAbsolute); else result.append("<unset>");
		result.append(", expirationTime: ");
		if (expirationTimeESet) result.append(expirationTime); else result.append("<unset>");
		result.append(", updateTime: ");
		if (updateTimeESet) result.append(updateTime); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TrafficIncidentImpl
