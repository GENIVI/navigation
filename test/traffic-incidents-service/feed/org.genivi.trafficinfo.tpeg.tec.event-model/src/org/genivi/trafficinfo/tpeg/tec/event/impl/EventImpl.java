/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event.impl;


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
import org.genivi.trafficinfo.tpeg.tec.event.Advice;
import org.genivi.trafficinfo.tpeg.tec.event.Cause;
import org.genivi.trafficinfo.tpeg.tec.event.EffectCode;
import org.genivi.trafficinfo.tpeg.tec.event.Event;
import org.genivi.trafficinfo.tpeg.tec.event.EventPackage;
import org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit;
import org.genivi.trafficinfo.tpeg.tec.event.Tendency;
import org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getEffectCode <em>Effect Code</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getTendency <em>Tendency</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getLengthAffected <em>Length Affected</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getDelay <em>Delay</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getSegmentSpeedLimit <em>Segment Speed Limit</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getCause <em>Cause</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getAdvice <em>Advice</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getVehicleRestriction <em>Vehicle Restriction</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl#getTemporarySpeedLimit <em>Temporary Speed Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventImpl extends EObjectImpl implements Event {
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
	 * The cached value of the '{@link #getCause() <em>Cause</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCause()
	 * @generated
	 * @ordered
	 */
  protected EList<Cause> cause;

  /**
	 * The cached value of the '{@link #getAdvice() <em>Advice</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAdvice()
	 * @generated
	 * @ordered
	 */
  protected EList<Advice> advice;

  /**
	 * The cached value of the '{@link #getVehicleRestriction() <em>Vehicle Restriction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVehicleRestriction()
	 * @generated
	 * @ordered
	 */
  protected EList<VehicleRestriction> vehicleRestriction;

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
	protected EventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventPackage.Literals.EVENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.EVENT__EFFECT_CODE, oldEffectCode, effectCode, !oldEffectCodeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.EVENT__EFFECT_CODE, oldEffectCode, EFFECT_CODE_EDEFAULT, oldEffectCodeESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.EVENT__START_TIME, oldStartTime, startTime, !oldStartTimeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.EVENT__START_TIME, oldStartTime, START_TIME_EDEFAULT, oldStartTimeESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.EVENT__STOP_TIME, oldStopTime, stopTime, !oldStopTimeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.EVENT__STOP_TIME, oldStopTime, STOP_TIME_EDEFAULT, oldStopTimeESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.EVENT__TENDENCY, oldTendency, tendency, !oldTendencyESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.EVENT__TENDENCY, oldTendency, TENDENCY_EDEFAULT, oldTendencyESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.EVENT__LENGTH_AFFECTED, oldLengthAffected, lengthAffected, !oldLengthAffectedESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.EVENT__LENGTH_AFFECTED, oldLengthAffected, LENGTH_AFFECTED_EDEFAULT, oldLengthAffectedESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.EVENT__AVERAGE_SPEED_ABSOLUTE, oldAverageSpeedAbsolute, averageSpeedAbsolute, !oldAverageSpeedAbsoluteESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.EVENT__AVERAGE_SPEED_ABSOLUTE, oldAverageSpeedAbsolute, AVERAGE_SPEED_ABSOLUTE_EDEFAULT, oldAverageSpeedAbsoluteESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.EVENT__DELAY, oldDelay, delay, !oldDelayESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.EVENT__DELAY, oldDelay, DELAY_EDEFAULT, oldDelayESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.EVENT__SEGMENT_SPEED_LIMIT, oldSegmentSpeedLimit, segmentSpeedLimit, !oldSegmentSpeedLimitESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.EVENT__SEGMENT_SPEED_LIMIT, oldSegmentSpeedLimit, SEGMENT_SPEED_LIMIT_EDEFAULT, oldSegmentSpeedLimitESet));
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
  public EList<Cause> getCause() {
		if (cause == null) {
			cause = new EObjectContainmentEList<Cause>(Cause.class, this, EventPackage.EVENT__CAUSE);
		}
		return cause;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Advice> getAdvice() {
		if (advice == null) {
			advice = new EObjectContainmentEList<Advice>(Advice.class, this, EventPackage.EVENT__ADVICE);
		}
		return advice;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<VehicleRestriction> getVehicleRestriction() {
		if (vehicleRestriction == null) {
			vehicleRestriction = new EObjectContainmentEList<VehicleRestriction>(VehicleRestriction.class, this, EventPackage.EVENT__VEHICLE_RESTRICTION);
		}
		return vehicleRestriction;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventPackage.EVENT__EXPECTED_SPEED_ABSOLUTE, oldExpectedSpeedAbsolute, expectedSpeedAbsolute, !oldExpectedSpeedAbsoluteESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, EventPackage.EVENT__EXPECTED_SPEED_ABSOLUTE, oldExpectedSpeedAbsolute, EXPECTED_SPEED_ABSOLUTE_EDEFAULT, oldExpectedSpeedAbsoluteESet));
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
	public EList<TemporarySpeedLimit> getTemporarySpeedLimit() {
		if (temporarySpeedLimit == null) {
			temporarySpeedLimit = new EObjectContainmentEList<TemporarySpeedLimit>(TemporarySpeedLimit.class, this, EventPackage.EVENT__TEMPORARY_SPEED_LIMIT);
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
			case EventPackage.EVENT__CAUSE:
				return ((InternalEList<?>)getCause()).basicRemove(otherEnd, msgs);
			case EventPackage.EVENT__ADVICE:
				return ((InternalEList<?>)getAdvice()).basicRemove(otherEnd, msgs);
			case EventPackage.EVENT__VEHICLE_RESTRICTION:
				return ((InternalEList<?>)getVehicleRestriction()).basicRemove(otherEnd, msgs);
			case EventPackage.EVENT__TEMPORARY_SPEED_LIMIT:
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
			case EventPackage.EVENT__EFFECT_CODE:
				return getEffectCode();
			case EventPackage.EVENT__START_TIME:
				return getStartTime();
			case EventPackage.EVENT__STOP_TIME:
				return getStopTime();
			case EventPackage.EVENT__TENDENCY:
				return getTendency();
			case EventPackage.EVENT__LENGTH_AFFECTED:
				return getLengthAffected();
			case EventPackage.EVENT__AVERAGE_SPEED_ABSOLUTE:
				return getAverageSpeedAbsolute();
			case EventPackage.EVENT__DELAY:
				return getDelay();
			case EventPackage.EVENT__SEGMENT_SPEED_LIMIT:
				return getSegmentSpeedLimit();
			case EventPackage.EVENT__CAUSE:
				return getCause();
			case EventPackage.EVENT__ADVICE:
				return getAdvice();
			case EventPackage.EVENT__VEHICLE_RESTRICTION:
				return getVehicleRestriction();
			case EventPackage.EVENT__EXPECTED_SPEED_ABSOLUTE:
				return getExpectedSpeedAbsolute();
			case EventPackage.EVENT__TEMPORARY_SPEED_LIMIT:
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
			case EventPackage.EVENT__EFFECT_CODE:
				setEffectCode((EffectCode)newValue);
				return;
			case EventPackage.EVENT__START_TIME:
				setStartTime((Date)newValue);
				return;
			case EventPackage.EVENT__STOP_TIME:
				setStopTime((Date)newValue);
				return;
			case EventPackage.EVENT__TENDENCY:
				setTendency((Tendency)newValue);
				return;
			case EventPackage.EVENT__LENGTH_AFFECTED:
				setLengthAffected((Integer)newValue);
				return;
			case EventPackage.EVENT__AVERAGE_SPEED_ABSOLUTE:
				setAverageSpeedAbsolute((Integer)newValue);
				return;
			case EventPackage.EVENT__DELAY:
				setDelay((Integer)newValue);
				return;
			case EventPackage.EVENT__SEGMENT_SPEED_LIMIT:
				setSegmentSpeedLimit((Integer)newValue);
				return;
			case EventPackage.EVENT__CAUSE:
				getCause().clear();
				getCause().addAll((Collection<? extends Cause>)newValue);
				return;
			case EventPackage.EVENT__ADVICE:
				getAdvice().clear();
				getAdvice().addAll((Collection<? extends Advice>)newValue);
				return;
			case EventPackage.EVENT__VEHICLE_RESTRICTION:
				getVehicleRestriction().clear();
				getVehicleRestriction().addAll((Collection<? extends VehicleRestriction>)newValue);
				return;
			case EventPackage.EVENT__EXPECTED_SPEED_ABSOLUTE:
				setExpectedSpeedAbsolute((Integer)newValue);
				return;
			case EventPackage.EVENT__TEMPORARY_SPEED_LIMIT:
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
			case EventPackage.EVENT__EFFECT_CODE:
				unsetEffectCode();
				return;
			case EventPackage.EVENT__START_TIME:
				unsetStartTime();
				return;
			case EventPackage.EVENT__STOP_TIME:
				unsetStopTime();
				return;
			case EventPackage.EVENT__TENDENCY:
				unsetTendency();
				return;
			case EventPackage.EVENT__LENGTH_AFFECTED:
				unsetLengthAffected();
				return;
			case EventPackage.EVENT__AVERAGE_SPEED_ABSOLUTE:
				unsetAverageSpeedAbsolute();
				return;
			case EventPackage.EVENT__DELAY:
				unsetDelay();
				return;
			case EventPackage.EVENT__SEGMENT_SPEED_LIMIT:
				unsetSegmentSpeedLimit();
				return;
			case EventPackage.EVENT__CAUSE:
				getCause().clear();
				return;
			case EventPackage.EVENT__ADVICE:
				getAdvice().clear();
				return;
			case EventPackage.EVENT__VEHICLE_RESTRICTION:
				getVehicleRestriction().clear();
				return;
			case EventPackage.EVENT__EXPECTED_SPEED_ABSOLUTE:
				unsetExpectedSpeedAbsolute();
				return;
			case EventPackage.EVENT__TEMPORARY_SPEED_LIMIT:
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
			case EventPackage.EVENT__EFFECT_CODE:
				return isSetEffectCode();
			case EventPackage.EVENT__START_TIME:
				return isSetStartTime();
			case EventPackage.EVENT__STOP_TIME:
				return isSetStopTime();
			case EventPackage.EVENT__TENDENCY:
				return isSetTendency();
			case EventPackage.EVENT__LENGTH_AFFECTED:
				return isSetLengthAffected();
			case EventPackage.EVENT__AVERAGE_SPEED_ABSOLUTE:
				return isSetAverageSpeedAbsolute();
			case EventPackage.EVENT__DELAY:
				return isSetDelay();
			case EventPackage.EVENT__SEGMENT_SPEED_LIMIT:
				return isSetSegmentSpeedLimit();
			case EventPackage.EVENT__CAUSE:
				return cause != null && !cause.isEmpty();
			case EventPackage.EVENT__ADVICE:
				return advice != null && !advice.isEmpty();
			case EventPackage.EVENT__VEHICLE_RESTRICTION:
				return vehicleRestriction != null && !vehicleRestriction.isEmpty();
			case EventPackage.EVENT__EXPECTED_SPEED_ABSOLUTE:
				return isSetExpectedSpeedAbsolute();
			case EventPackage.EVENT__TEMPORARY_SPEED_LIMIT:
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
		result.append(", expectedSpeedAbsolute: ");
		if (expectedSpeedAbsoluteESet) result.append(expectedSpeedAbsolute); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EventImpl
