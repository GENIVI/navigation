/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.genivi.common.RectangularArea;
import org.genivi.location.Location;
import org.genivi.location.LocationInfo;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.EffectCode;
import org.genivi.trafficincidentsservice.trafficincidenttables.Tendency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traffic Incident</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getEffectCode <em>Effect Code</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getEffectText <em>Effect Text</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getStopTime <em>Stop Time</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getTendency <em>Tendency</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getTendencyText <em>Tendency Text</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getLengthAffected <em>Length Affected</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getDelay <em>Delay</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getSegmentSpeedLimit <em>Segment Speed Limit</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getCauses <em>Causes</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getAdvices <em>Advices</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getApplicability <em>Applicability</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getTrafficIncidentId <em>Traffic Incident Id</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getLocationInfo <em>Location Info</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getCauseTexts <em>Cause Texts</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getApplicabilityTexts <em>Applicability Texts</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getAdviceTexts <em>Advice Texts</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getCategoryIds <em>Category Ids</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getLocationBoundingBox <em>Location Bounding Box</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl#getTemporarySpeedLimit <em>Temporary Speed Limit</em>}</li>
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
	 * The default value of the '{@link #getEffectText() <em>Effect Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEffectText()
	 * @generated
	 * @ordered
	 */
  protected static final String EFFECT_TEXT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getEffectText() <em>Effect Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEffectText()
	 * @generated
	 * @ordered
	 */
  protected String effectText = EFFECT_TEXT_EDEFAULT;

  /**
	 * This is true if the Effect Text attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean effectTextESet;

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
	 * The default value of the '{@link #getTendencyText() <em>Tendency Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTendencyText()
	 * @generated
	 * @ordered
	 */
  protected static final String TENDENCY_TEXT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getTendencyText() <em>Tendency Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTendencyText()
	 * @generated
	 * @ordered
	 */
  protected String tendencyText = TENDENCY_TEXT_EDEFAULT;

  /**
	 * This is true if the Tendency Text attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean tendencyTextESet;

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
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
  protected Location location;

  /**
	 * This is true if the Location containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean locationESet;

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
  protected static final Integer TRAFFIC_INCIDENT_ID_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getTrafficIncidentId() <em>Traffic Incident Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTrafficIncidentId()
	 * @generated
	 * @ordered
	 */
  protected Integer trafficIncidentId = TRAFFIC_INCIDENT_ID_EDEFAULT;

  /**
	 * This is true if the Traffic Incident Id attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean trafficIncidentIdESet;

  /**
	 * The cached value of the '{@link #getLocationInfo() <em>Location Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocationInfo()
	 * @generated
	 * @ordered
	 */
  protected LocationInfo locationInfo;

  /**
	 * This is true if the Location Info containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean locationInfoESet;

  /**
	 * The cached value of the '{@link #getCauseTexts() <em>Cause Texts</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCauseTexts()
	 * @generated
	 * @ordered
	 */
  protected EList<String> causeTexts;

  /**
	 * The cached value of the '{@link #getApplicabilityTexts() <em>Applicability Texts</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getApplicabilityTexts()
	 * @generated
	 * @ordered
	 */
  protected EList<String> applicabilityTexts;

  /**
	 * The cached value of the '{@link #getAdviceTexts() <em>Advice Texts</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAdviceTexts()
	 * @generated
	 * @ordered
	 */
  protected EList<String> adviceTexts;

  /**
	 * The cached value of the '{@link #getCategoryIds() <em>Category Ids</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCategoryIds()
	 * @generated
	 * @ordered
	 */
  protected EList<Integer> categoryIds;

  /**
	 * The cached value of the '{@link #getLocationBoundingBox() <em>Location Bounding Box</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocationBoundingBox()
	 * @generated
	 * @ordered
	 */
  protected RectangularArea locationBoundingBox;

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
		return trafficincidentPackage.Literals.TRAFFIC_INCIDENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE, oldEffectCode, effectCode, !oldEffectCodeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE, oldEffectCode, EFFECT_CODE_EDEFAULT, oldEffectCodeESet));
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
  public String getEffectText() {
		return effectText;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setEffectText(String newEffectText) {
		String oldEffectText = effectText;
		effectText = newEffectText;
		boolean oldEffectTextESet = effectTextESet;
		effectTextESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_TEXT, oldEffectText, effectText, !oldEffectTextESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetEffectText() {
		String oldEffectText = effectText;
		boolean oldEffectTextESet = effectTextESet;
		effectText = EFFECT_TEXT_EDEFAULT;
		effectTextESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_TEXT, oldEffectText, EFFECT_TEXT_EDEFAULT, oldEffectTextESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetEffectText() {
		return effectTextESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__START_TIME, oldStartTime, startTime, !oldStartTimeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__START_TIME, oldStartTime, START_TIME_EDEFAULT, oldStartTimeESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__STOP_TIME, oldStopTime, stopTime, !oldStopTimeESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__STOP_TIME, oldStopTime, STOP_TIME_EDEFAULT, oldStopTimeESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY, oldTendency, tendency, !oldTendencyESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY, oldTendency, TENDENCY_EDEFAULT, oldTendencyESet));
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
  public String getTendencyText() {
		return tendencyText;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTendencyText(String newTendencyText) {
		String oldTendencyText = tendencyText;
		tendencyText = newTendencyText;
		boolean oldTendencyTextESet = tendencyTextESet;
		tendencyTextESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY_TEXT, oldTendencyText, tendencyText, !oldTendencyTextESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetTendencyText() {
		String oldTendencyText = tendencyText;
		boolean oldTendencyTextESet = tendencyTextESet;
		tendencyText = TENDENCY_TEXT_EDEFAULT;
		tendencyTextESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY_TEXT, oldTendencyText, TENDENCY_TEXT_EDEFAULT, oldTendencyTextESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetTendencyText() {
		return tendencyTextESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED, oldLengthAffected, lengthAffected, !oldLengthAffectedESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED, oldLengthAffected, LENGTH_AFFECTED_EDEFAULT, oldLengthAffectedESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE, oldAverageSpeedAbsolute, averageSpeedAbsolute, !oldAverageSpeedAbsoluteESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE, oldAverageSpeedAbsolute, AVERAGE_SPEED_ABSOLUTE_EDEFAULT, oldAverageSpeedAbsoluteESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__DELAY, oldDelay, delay, !oldDelayESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__DELAY, oldDelay, DELAY_EDEFAULT, oldDelayESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT, oldSegmentSpeedLimit, segmentSpeedLimit, !oldSegmentSpeedLimitESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT, oldSegmentSpeedLimit, SEGMENT_SPEED_LIMIT_EDEFAULT, oldSegmentSpeedLimitESet));
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
			causes = new EObjectContainmentEList.Unsettable<Cause>(Cause.class, this, trafficincidentPackage.TRAFFIC_INCIDENT__CAUSES);
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
  public Location getLocation() {
		return location;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLocation(Location newLocation, NotificationChain msgs) {
		Location oldLocation = location;
		location = newLocation;
		boolean oldLocationESet = locationESet;
		locationESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION, oldLocation, newLocation, !oldLocationESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLocation(Location newLocation) {
		if (newLocation != location) {
			NotificationChain msgs = null;
			if (location != null)
				msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION, null, msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION, null, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLocationESet = locationESet;
			locationESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION, newLocation, newLocation, !oldLocationESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetLocation(NotificationChain msgs) {
		Location oldLocation = location;
		location = null;
		boolean oldLocationESet = locationESet;
		locationESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION, oldLocation, null, oldLocationESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLocation() {
		if (location != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION, null, msgs);
			msgs = basicUnsetLocation(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLocationESet = locationESet;
			locationESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION, null, null, oldLocationESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLocation() {
		return locationESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Advice> getAdvices() {
		if (advices == null) {
			advices = new EObjectContainmentEList.Unsettable<Advice>(Advice.class, this, trafficincidentPackage.TRAFFIC_INCIDENT__ADVICES);
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
			applicability = new EObjectContainmentEList.Unsettable<Applicability>(Applicability.class, this, trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY);
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
  public Integer getTrafficIncidentId() {
		return trafficIncidentId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTrafficIncidentId(Integer newTrafficIncidentId) {
		Integer oldTrafficIncidentId = trafficIncidentId;
		trafficIncidentId = newTrafficIncidentId;
		boolean oldTrafficIncidentIdESet = trafficIncidentIdESet;
		trafficIncidentIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID, oldTrafficIncidentId, trafficIncidentId, !oldTrafficIncidentIdESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetTrafficIncidentId() {
		Integer oldTrafficIncidentId = trafficIncidentId;
		boolean oldTrafficIncidentIdESet = trafficIncidentIdESet;
		trafficIncidentId = TRAFFIC_INCIDENT_ID_EDEFAULT;
		trafficIncidentIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID, oldTrafficIncidentId, TRAFFIC_INCIDENT_ID_EDEFAULT, oldTrafficIncidentIdESet));
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
  public LocationInfo getLocationInfo() {
		return locationInfo;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLocationInfo(LocationInfo newLocationInfo, NotificationChain msgs) {
		LocationInfo oldLocationInfo = locationInfo;
		locationInfo = newLocationInfo;
		boolean oldLocationInfoESet = locationInfoESet;
		locationInfoESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO, oldLocationInfo, newLocationInfo, !oldLocationInfoESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLocationInfo(LocationInfo newLocationInfo) {
		if (newLocationInfo != locationInfo) {
			NotificationChain msgs = null;
			if (locationInfo != null)
				msgs = ((InternalEObject)locationInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO, null, msgs);
			if (newLocationInfo != null)
				msgs = ((InternalEObject)newLocationInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO, null, msgs);
			msgs = basicSetLocationInfo(newLocationInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLocationInfoESet = locationInfoESet;
			locationInfoESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO, newLocationInfo, newLocationInfo, !oldLocationInfoESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetLocationInfo(NotificationChain msgs) {
		LocationInfo oldLocationInfo = locationInfo;
		locationInfo = null;
		boolean oldLocationInfoESet = locationInfoESet;
		locationInfoESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO, oldLocationInfo, null, oldLocationInfoESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLocationInfo() {
		if (locationInfo != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)locationInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO, null, msgs);
			msgs = basicUnsetLocationInfo(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLocationInfoESet = locationInfoESet;
			locationInfoESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO, null, null, oldLocationInfoESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLocationInfo() {
		return locationInfoESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<String> getCauseTexts() {
		if (causeTexts == null) {
			causeTexts = new EDataTypeUniqueEList.Unsettable<String>(String.class, this, trafficincidentPackage.TRAFFIC_INCIDENT__CAUSE_TEXTS);
		}
		return causeTexts;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetCauseTexts() {
		if (causeTexts != null) ((InternalEList.Unsettable<?>)causeTexts).unset();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetCauseTexts() {
		return causeTexts != null && ((InternalEList.Unsettable<?>)causeTexts).isSet();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<String> getApplicabilityTexts() {
		if (applicabilityTexts == null) {
			applicabilityTexts = new EDataTypeUniqueEList.Unsettable<String>(String.class, this, trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY_TEXTS);
		}
		return applicabilityTexts;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetApplicabilityTexts() {
		if (applicabilityTexts != null) ((InternalEList.Unsettable<?>)applicabilityTexts).unset();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetApplicabilityTexts() {
		return applicabilityTexts != null && ((InternalEList.Unsettable<?>)applicabilityTexts).isSet();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<String> getAdviceTexts() {
		if (adviceTexts == null) {
			adviceTexts = new EDataTypeUniqueEList.Unsettable<String>(String.class, this, trafficincidentPackage.TRAFFIC_INCIDENT__ADVICE_TEXTS);
		}
		return adviceTexts;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetAdviceTexts() {
		if (adviceTexts != null) ((InternalEList.Unsettable<?>)adviceTexts).unset();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetAdviceTexts() {
		return adviceTexts != null && ((InternalEList.Unsettable<?>)adviceTexts).isSet();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Integer> getCategoryIds() {
		if (categoryIds == null) {
			categoryIds = new EDataTypeUniqueEList<Integer>(Integer.class, this, trafficincidentPackage.TRAFFIC_INCIDENT__CATEGORY_IDS);
		}
		return categoryIds;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RectangularArea getLocationBoundingBox() {
		return locationBoundingBox;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLocationBoundingBox(RectangularArea newLocationBoundingBox, NotificationChain msgs) {
		RectangularArea oldLocationBoundingBox = locationBoundingBox;
		locationBoundingBox = newLocationBoundingBox;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX, oldLocationBoundingBox, newLocationBoundingBox);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLocationBoundingBox(RectangularArea newLocationBoundingBox) {
		if (newLocationBoundingBox != locationBoundingBox) {
			NotificationChain msgs = null;
			if (locationBoundingBox != null)
				msgs = ((InternalEObject)locationBoundingBox).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX, null, msgs);
			if (newLocationBoundingBox != null)
				msgs = ((InternalEObject)newLocationBoundingBox).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX, null, msgs);
			msgs = basicSetLocationBoundingBox(newLocationBoundingBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX, newLocationBoundingBox, newLocationBoundingBox));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE, oldExpectedSpeedAbsolute, expectedSpeedAbsolute, !oldExpectedSpeedAbsoluteESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE, oldExpectedSpeedAbsolute, EXPECTED_SPEED_ABSOLUTE_EDEFAULT, oldExpectedSpeedAbsoluteESet));
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
			temporarySpeedLimit = new EObjectContainmentEList<TemporarySpeedLimit>(TemporarySpeedLimit.class, this, trafficincidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT);
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
			case trafficincidentPackage.TRAFFIC_INCIDENT__CAUSES:
				return ((InternalEList<?>)getCauses()).basicRemove(otherEnd, msgs);
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION:
				return basicUnsetLocation(msgs);
			case trafficincidentPackage.TRAFFIC_INCIDENT__ADVICES:
				return ((InternalEList<?>)getAdvices()).basicRemove(otherEnd, msgs);
			case trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY:
				return ((InternalEList<?>)getApplicability()).basicRemove(otherEnd, msgs);
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO:
				return basicUnsetLocationInfo(msgs);
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX:
				return basicSetLocationBoundingBox(null, msgs);
			case trafficincidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT:
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
			case trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE:
				return getEffectCode();
			case trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_TEXT:
				return getEffectText();
			case trafficincidentPackage.TRAFFIC_INCIDENT__START_TIME:
				return getStartTime();
			case trafficincidentPackage.TRAFFIC_INCIDENT__STOP_TIME:
				return getStopTime();
			case trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY:
				return getTendency();
			case trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY_TEXT:
				return getTendencyText();
			case trafficincidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED:
				return getLengthAffected();
			case trafficincidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE:
				return getAverageSpeedAbsolute();
			case trafficincidentPackage.TRAFFIC_INCIDENT__DELAY:
				return getDelay();
			case trafficincidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT:
				return getSegmentSpeedLimit();
			case trafficincidentPackage.TRAFFIC_INCIDENT__CAUSES:
				return getCauses();
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION:
				return getLocation();
			case trafficincidentPackage.TRAFFIC_INCIDENT__ADVICES:
				return getAdvices();
			case trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY:
				return getApplicability();
			case trafficincidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID:
				return getTrafficIncidentId();
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO:
				return getLocationInfo();
			case trafficincidentPackage.TRAFFIC_INCIDENT__CAUSE_TEXTS:
				return getCauseTexts();
			case trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY_TEXTS:
				return getApplicabilityTexts();
			case trafficincidentPackage.TRAFFIC_INCIDENT__ADVICE_TEXTS:
				return getAdviceTexts();
			case trafficincidentPackage.TRAFFIC_INCIDENT__CATEGORY_IDS:
				return getCategoryIds();
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX:
				return getLocationBoundingBox();
			case trafficincidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE:
				return getExpectedSpeedAbsolute();
			case trafficincidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT:
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
			case trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE:
				setEffectCode((EffectCode)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_TEXT:
				setEffectText((String)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__START_TIME:
				setStartTime((Date)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__STOP_TIME:
				setStopTime((Date)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY:
				setTendency((Tendency)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY_TEXT:
				setTendencyText((String)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED:
				setLengthAffected((Integer)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE:
				setAverageSpeedAbsolute((Integer)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__DELAY:
				setDelay((Integer)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT:
				setSegmentSpeedLimit((Integer)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__CAUSES:
				getCauses().clear();
				getCauses().addAll((Collection<? extends Cause>)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION:
				setLocation((Location)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__ADVICES:
				getAdvices().clear();
				getAdvices().addAll((Collection<? extends Advice>)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY:
				getApplicability().clear();
				getApplicability().addAll((Collection<? extends Applicability>)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID:
				setTrafficIncidentId((Integer)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO:
				setLocationInfo((LocationInfo)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__CAUSE_TEXTS:
				getCauseTexts().clear();
				getCauseTexts().addAll((Collection<? extends String>)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY_TEXTS:
				getApplicabilityTexts().clear();
				getApplicabilityTexts().addAll((Collection<? extends String>)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__ADVICE_TEXTS:
				getAdviceTexts().clear();
				getAdviceTexts().addAll((Collection<? extends String>)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__CATEGORY_IDS:
				getCategoryIds().clear();
				getCategoryIds().addAll((Collection<? extends Integer>)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX:
				setLocationBoundingBox((RectangularArea)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE:
				setExpectedSpeedAbsolute((Integer)newValue);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT:
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
			case trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE:
				unsetEffectCode();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_TEXT:
				unsetEffectText();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__START_TIME:
				unsetStartTime();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__STOP_TIME:
				unsetStopTime();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY:
				unsetTendency();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY_TEXT:
				unsetTendencyText();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED:
				unsetLengthAffected();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE:
				unsetAverageSpeedAbsolute();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__DELAY:
				unsetDelay();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT:
				unsetSegmentSpeedLimit();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__CAUSES:
				unsetCauses();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION:
				unsetLocation();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__ADVICES:
				unsetAdvices();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY:
				unsetApplicability();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID:
				unsetTrafficIncidentId();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO:
				unsetLocationInfo();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__CAUSE_TEXTS:
				unsetCauseTexts();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY_TEXTS:
				unsetApplicabilityTexts();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__ADVICE_TEXTS:
				unsetAdviceTexts();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__CATEGORY_IDS:
				getCategoryIds().clear();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX:
				setLocationBoundingBox((RectangularArea)null);
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE:
				unsetExpectedSpeedAbsolute();
				return;
			case trafficincidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT:
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
			case trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_CODE:
				return isSetEffectCode();
			case trafficincidentPackage.TRAFFIC_INCIDENT__EFFECT_TEXT:
				return isSetEffectText();
			case trafficincidentPackage.TRAFFIC_INCIDENT__START_TIME:
				return isSetStartTime();
			case trafficincidentPackage.TRAFFIC_INCIDENT__STOP_TIME:
				return isSetStopTime();
			case trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY:
				return isSetTendency();
			case trafficincidentPackage.TRAFFIC_INCIDENT__TENDENCY_TEXT:
				return isSetTendencyText();
			case trafficincidentPackage.TRAFFIC_INCIDENT__LENGTH_AFFECTED:
				return isSetLengthAffected();
			case trafficincidentPackage.TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE:
				return isSetAverageSpeedAbsolute();
			case trafficincidentPackage.TRAFFIC_INCIDENT__DELAY:
				return isSetDelay();
			case trafficincidentPackage.TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT:
				return isSetSegmentSpeedLimit();
			case trafficincidentPackage.TRAFFIC_INCIDENT__CAUSES:
				return isSetCauses();
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION:
				return isSetLocation();
			case trafficincidentPackage.TRAFFIC_INCIDENT__ADVICES:
				return isSetAdvices();
			case trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY:
				return isSetApplicability();
			case trafficincidentPackage.TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID:
				return isSetTrafficIncidentId();
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_INFO:
				return isSetLocationInfo();
			case trafficincidentPackage.TRAFFIC_INCIDENT__CAUSE_TEXTS:
				return isSetCauseTexts();
			case trafficincidentPackage.TRAFFIC_INCIDENT__APPLICABILITY_TEXTS:
				return isSetApplicabilityTexts();
			case trafficincidentPackage.TRAFFIC_INCIDENT__ADVICE_TEXTS:
				return isSetAdviceTexts();
			case trafficincidentPackage.TRAFFIC_INCIDENT__CATEGORY_IDS:
				return categoryIds != null && !categoryIds.isEmpty();
			case trafficincidentPackage.TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX:
				return locationBoundingBox != null;
			case trafficincidentPackage.TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE:
				return isSetExpectedSpeedAbsolute();
			case trafficincidentPackage.TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT:
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
		result.append(", effectText: ");
		if (effectTextESet) result.append(effectText); else result.append("<unset>");
		result.append(", startTime: ");
		if (startTimeESet) result.append(startTime); else result.append("<unset>");
		result.append(", stopTime: ");
		if (stopTimeESet) result.append(stopTime); else result.append("<unset>");
		result.append(", tendency: ");
		if (tendencyESet) result.append(tendency); else result.append("<unset>");
		result.append(", tendencyText: ");
		if (tendencyTextESet) result.append(tendencyText); else result.append("<unset>");
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
		result.append(", causeTexts: ");
		result.append(causeTexts);
		result.append(", applicabilityTexts: ");
		result.append(applicabilityTexts);
		result.append(", adviceTexts: ");
		result.append(adviceTexts);
		result.append(", categoryIds: ");
		result.append(categoryIds);
		result.append(", expectedSpeedAbsolute: ");
		if (expectedSpeedAbsoluteESet) result.append(expectedSpeedAbsolute); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TrafficIncidentImpl
