/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tec.event;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tec.event.EventFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface EventPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "event";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://org.genivi.trafficinfo.tec";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "model";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  EventPackage eINSTANCE = org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getEvent()
	 * @generated
	 */
  int EVENT = 0;

  /**
	 * The feature id for the '<em><b>Effect Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__EFFECT_CODE = 0;

  /**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__START_TIME = 1;

  /**
	 * The feature id for the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__STOP_TIME = 2;

  /**
	 * The feature id for the '<em><b>Tendency</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__TENDENCY = 3;

  /**
	 * The feature id for the '<em><b>Length Affected</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__LENGTH_AFFECTED = 4;

  /**
	 * The feature id for the '<em><b>Average Speed Absolute</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__AVERAGE_SPEED_ABSOLUTE = 5;

  /**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__DELAY = 6;

  /**
	 * The feature id for the '<em><b>Segment Speed Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__SEGMENT_SPEED_LIMIT = 7;

  /**
	 * The feature id for the '<em><b>Cause</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__CAUSE = 8;

  /**
	 * The feature id for the '<em><b>Advice</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__ADVICE = 9;

  /**
	 * The feature id for the '<em><b>Vehicle Restriction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT__VEHICLE_RESTRICTION = 10;

  /**
	 * The feature id for the '<em><b>Expected Speed Absolute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__EXPECTED_SPEED_ABSOLUTE = 11;

		/**
	 * The feature id for the '<em><b>Temporary Speed Limit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TEMPORARY_SPEED_LIMIT = 12;

		/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int EVENT_FEATURE_COUNT = 13;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.CauseImpl <em>Cause</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.CauseImpl
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getCause()
	 * @generated
	 */
  int CAUSE = 1;

  /**
	 * The feature id for the '<em><b>Main Cause</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CAUSE__MAIN_CAUSE = 0;

  /**
	 * The number of structural features of the '<em>Cause</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CAUSE_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.LinkedCauseImpl <em>Linked Cause</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.LinkedCauseImpl
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getLinkedCause()
	 * @generated
	 */
  int LINKED_CAUSE = 2;

  /**
	 * The feature id for the '<em><b>Main Cause</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINKED_CAUSE__MAIN_CAUSE = CAUSE__MAIN_CAUSE;

  /**
	 * The feature id for the '<em><b>Linked Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINKED_CAUSE__LINKED_MESSAGE = CAUSE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>COID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINKED_CAUSE__COID = CAUSE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Originator SID</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINKED_CAUSE__ORIGINATOR_SID = CAUSE_FEATURE_COUNT + 2;

  /**
	 * The number of structural features of the '<em>Linked Cause</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINKED_CAUSE_FEATURE_COUNT = CAUSE_FEATURE_COUNT + 3;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl <em>Direct Cause</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getDirectCause()
	 * @generated
	 */
  int DIRECT_CAUSE = 3;

  /**
	 * The feature id for the '<em><b>Main Cause</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE__MAIN_CAUSE = CAUSE__MAIN_CAUSE;

  /**
	 * The feature id for the '<em><b>Warning Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE__WARNING_LEVEL = CAUSE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Unverified Information</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE__UNVERIFIED_INFORMATION = CAUSE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Sub Cause</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE__SUB_CAUSE = CAUSE_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Length Affected</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE__LENGTH_AFFECTED = CAUSE_FEATURE_COUNT + 3;

  /**
	 * The feature id for the '<em><b>Lane Restriction Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE__LANE_RESTRICTION_TYPE = CAUSE_FEATURE_COUNT + 4;

  /**
	 * The feature id for the '<em><b>Number Of Lanes</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE__NUMBER_OF_LANES = CAUSE_FEATURE_COUNT + 5;

  /**
	 * The feature id for the '<em><b>Free Text</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE__FREE_TEXT = CAUSE_FEATURE_COUNT + 6;

  /**
	 * The feature id for the '<em><b>Cause Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_CAUSE__CAUSE_OFFSET = CAUSE_FEATURE_COUNT + 7;

		/**
	 * The number of structural features of the '<em>Direct Cause</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE_FEATURE_COUNT = CAUSE_FEATURE_COUNT + 8;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.AdviceImpl <em>Advice</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.AdviceImpl
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getAdvice()
	 * @generated
	 */
  int ADVICE = 4;

  /**
	 * The feature id for the '<em><b>Advice Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE__ADVICE_CODE = 0;

  /**
	 * The feature id for the '<em><b>Sub Advice Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE__SUB_ADVICE_CODE = 1;

  /**
	 * The feature id for the '<em><b>Free Text</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE__FREE_TEXT = 2;

  /**
	 * The feature id for the '<em><b>Vehicle Restriction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE__VEHICLE_RESTRICTION = 3;

  /**
	 * The number of structural features of the '<em>Advice</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE_FEATURE_COUNT = 4;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRestrictionImpl <em>Vehicle Restriction</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRestrictionImpl
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getVehicleRestriction()
	 * @generated
	 */
  int VEHICLE_RESTRICTION = 5;

  /**
	 * The feature id for the '<em><b>Vehicle Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VEHICLE_RESTRICTION__VEHICLE_TYPE = 0;

  /**
	 * The feature id for the '<em><b>Restriction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VEHICLE_RESTRICTION__RESTRICTION = 1;

  /**
	 * The number of structural features of the '<em>Vehicle Restriction</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VEHICLE_RESTRICTION_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRelatedRestrictionImpl <em>Vehicle Related Restriction</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRelatedRestrictionImpl
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getVehicleRelatedRestriction()
	 * @generated
	 */
  int VEHICLE_RELATED_RESTRICTION = 6;

  /**
	 * The feature id for the '<em><b>Restriction Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VEHICLE_RELATED_RESTRICTION__RESTRICTION_TYPE = 0;

  /**
	 * The feature id for the '<em><b>Restriction Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VEHICLE_RELATED_RESTRICTION__RESTRICTION_VALUE = 1;

  /**
	 * The feature id for the '<em><b>Restriction Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION = 2;

  /**
	 * The number of structural features of the '<em>Vehicle Related Restriction</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VEHICLE_RELATED_RESTRICTION_FEATURE_COUNT = 3;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TECMessageImpl <em>TEC Message</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.TECMessageImpl
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTECMessage()
	 * @generated
	 */
  int TEC_MESSAGE = 7;

  /**
	 * The feature id for the '<em><b>Mmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TEC_MESSAGE__MMT = 0;

  /**
	 * The feature id for the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TEC_MESSAGE__EVENT = 1;

  /**
	 * The feature id for the '<em><b>Loc</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TEC_MESSAGE__LOC = 2;

  /**
	 * The number of structural features of the '<em>TEC Message</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TEC_MESSAGE_FEATURE_COUNT = 3;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitSectionImpl <em>Temporary Speed Limit Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitSectionImpl
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTemporarySpeedLimitSection()
	 * @generated
	 */
	int TEMPORARY_SPEED_LIMIT_SECTION = 8;

		/**
	 * The feature id for the '<em><b>Speed Limit Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE = 0;

		/**
	 * The feature id for the '<em><b>Speed Limit Value Wet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE_WET = 1;

		/**
	 * The feature id for the '<em><b>Speed Limit Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_LENGTH = 2;

		/**
	 * The number of structural features of the '<em>Temporary Speed Limit Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT_SECTION_FEATURE_COUNT = 3;

		/**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitImpl <em>Temporary Speed Limit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitImpl
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTemporarySpeedLimit()
	 * @generated
	 */
	int TEMPORARY_SPEED_LIMIT = 9;

		/**
	 * The feature id for the '<em><b>Speed Limit Section</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT__SPEED_LIMIT_SECTION = 0;

		/**
	 * The feature id for the '<em><b>Units MPH</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT__UNITS_MPH = 1;

		/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT__OFFSET = 2;

		/**
	 * The feature id for the '<em><b>Vehicle Restriction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT__VEHICLE_RESTRICTION = 3;

		/**
	 * The number of structural features of the '<em>Temporary Speed Limit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT_FEATURE_COUNT = 4;

		/**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.EffectCode <em>Effect Code</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EffectCode
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getEffectCode()
	 * @generated
	 */
  int EFFECT_CODE = 10;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.Tendency <em>Tendency</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Tendency
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTendency()
	 * @generated
	 */
  int TENDENCY = 11;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.CauseCode <em>Cause Code</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.CauseCode
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getCauseCode()
	 * @generated
	 */
  int CAUSE_CODE = 12;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.WarningLevel <em>Warning Level</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.WarningLevel
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getWarningLevel()
	 * @generated
	 */
  int WARNING_LEVEL = 13;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion <em>Traffic Congestion</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTrafficCongestion()
	 * @generated
	 */
  int TRAFFIC_CONGESTION = 14;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.Accident <em>Accident</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Accident
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getAccident()
	 * @generated
	 */
  int ACCIDENT = 15;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RoadWorks <em>Road Works</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RoadWorks
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRoadWorks()
	 * @generated
	 */
  int ROAD_WORKS = 16;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes <em>Narrow Lanes</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getNarrowLanes()
	 * @generated
	 */
  int NARROW_LANES = 17;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.Impassibility <em>Impassibility</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Impassibility
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getImpassibility()
	 * @generated
	 */
  int IMPASSIBILITY = 18;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad <em>Slippery Road</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getSlipperyRoad()
	 * @generated
	 */
  int SLIPPERY_ROAD = 19;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.Fire <em>Fire</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Fire
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getFire()
	 * @generated
	 */
  int FIRE = 20;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions <em>Hazardous Driving Conditions</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getHazardousDrivingConditions()
	 * @generated
	 */
  int HAZARDOUS_DRIVING_CONDITIONS = 21;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad <em>Objects On The Road</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getObjectsOnTheRoad()
	 * @generated
	 */
  int OBJECTS_ON_THE_ROAD = 22;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway <em>Animals On Roadway</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getAnimalsOnRoadway()
	 * @generated
	 */
  int ANIMALS_ON_ROADWAY = 23;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway <em>People On Roadway</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getPeopleOnRoadway()
	 * @generated
	 */
  int PEOPLE_ON_ROADWAY = 24;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles <em>Broken Down Vehicles</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getBrokenDownVehicles()
	 * @generated
	 */
  int BROKEN_DOWN_VEHICLES = 25;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress <em>Rescue And Recovery Work In Progress</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRescueAndRecoveryWorkInProgress()
	 * @generated
	 */
  int RESCUE_AND_RECOVERY_WORK_IN_PROGRESS = 26;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure <em>Regulatory Measure</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRegulatoryMeasure()
	 * @generated
	 */
  int REGULATORY_MEASURE = 27;


  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType <em>Lane Restriction Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getLaneRestrictionType()
	 * @generated
	 */
  int LANE_RESTRICTION_TYPE = 28;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.AdviceCode <em>Advice Code</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.AdviceCode
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getAdviceCode()
	 * @generated
	 */
  int ADVICE_CODE = 29;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleType <em>Vehicle Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleType
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getVehicleType()
	 * @generated
	 */
  int VEHICLE_TYPE = 30;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RestrictionType <em>Restriction Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RestrictionType
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRestrictionType()
	 * @generated
	 */
  int RESTRICTION_TYPE = 31;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions <em>Extreme Weather Conditions</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getExtremeWeatherConditions()
	 * @generated
	 */
  int EXTREME_WEATHER_CONDITIONS = 32;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced <em>Visibility Reduced</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getVisibilityReduced()
	 * @generated
	 */
  int VISIBILITY_REDUCED = 33;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.Precipitation <em>Precipitation</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Precipitation
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getPrecipitation()
	 * @generated
	 */
  int PRECIPITATION = 34;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons <em>Reckless Persons</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRecklessPersons()
	 * @generated
	 */
  int RECKLESS_PERSONS = 35;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.MajorEvent <em>Major Event</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.MajorEvent
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getMajorEvent()
	 * @generated
	 */
  int MAJOR_EVENT = 36;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating <em>Service Not Operating</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getServiceNotOperating()
	 * @generated
	 */
  int SERVICE_NOT_OPERATING = 37;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable <em>Service Not Usable</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getServiceNotUsable()
	 * @generated
	 */
  int SERVICE_NOT_USABLE = 38;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles <em>Slow Moving Vehicles</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getSlowMovingVehicles()
	 * @generated
	 */
  int SLOW_MOVING_VEHICLES = 39;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue <em>Dangerous End Of Queue</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getDangerousEndOfQueue()
	 * @generated
	 */
  int DANGEROUS_END_OF_QUEUE = 40;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire <em>Risk Of Fire</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRiskOfFire()
	 * @generated
	 */
  int RISK_OF_FIRE = 41;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.TimeDelay <em>Time Delay</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TimeDelay
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTimeDelay()
	 * @generated
	 */
  int TIME_DELAY = 42;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint <em>Police Checkpoint</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getPoliceCheckpoint()
	 * @generated
	 */
  int POLICE_CHECKPOINT = 43;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment <em>Malfunctioning Roadside Equipment</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getMalfunctioningRoadsideEquipment()
	 * @generated
	 */
  int MALFUNCTIONING_ROADSIDE_EQUIPMENT = 44;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed <em>Overtaking Not Allowed</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getOvertakingNotAllowed()
	 * @generated
	 */
  int OVERTAKING_NOT_ALLOWED = 45;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed <em>Driving Not Allowed</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getDrivingNotAllowed()
	 * @generated
	 */
  int DRIVING_NOT_ALLOWED = 46;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind <em>Giving Path Vehicles From Behind</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getGivingPathVehiclesFromBehind()
	 * @generated
	 */
  int GIVING_PATH_VEHICLES_FROM_BEHIND = 47;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion <em>Follow Diversion</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getFollowDiversion()
	 * @generated
	 */
  int FOLLOW_DIVERSION = 48;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully <em>Drive Carefully</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getDriveCarefully()
	 * @generated
	 */
  int DRIVE_CAREFULLY = 49;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle <em>Do Not Leave Your Vehicle</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getDoNotLeaveYourVehicle()
	 * @generated
	 */
  int DO_NOT_LEAVE_YOUR_VEHICLE = 50;

  /**
	 * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes <em>Use Toll Lanes</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes
	 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getUseTollLanes()
	 * @generated
	 */
  int USE_TOLL_LANES = 51;


  /**
	 * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tec.event.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event
	 * @generated
	 */
  EClass getEvent();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getEffectCode <em>Effect Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effect Code</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getEffectCode()
	 * @see #getEvent()
	 * @generated
	 */
  EAttribute getEvent_EffectCode();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getStartTime()
	 * @see #getEvent()
	 * @generated
	 */
  EAttribute getEvent_StartTime();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getStopTime <em>Stop Time</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Time</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getStopTime()
	 * @see #getEvent()
	 * @generated
	 */
  EAttribute getEvent_StopTime();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getTendency <em>Tendency</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tendency</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getTendency()
	 * @see #getEvent()
	 * @generated
	 */
  EAttribute getEvent_Tendency();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getLengthAffected <em>Length Affected</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length Affected</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getLengthAffected()
	 * @see #getEvent()
	 * @generated
	 */
  EAttribute getEvent_LengthAffected();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average Speed Absolute</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getAverageSpeedAbsolute()
	 * @see #getEvent()
	 * @generated
	 */
  EAttribute getEvent_AverageSpeedAbsolute();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getDelay()
	 * @see #getEvent()
	 * @generated
	 */
  EAttribute getEvent_Delay();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getSegmentSpeedLimit <em>Segment Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Segment Speed Limit</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getSegmentSpeedLimit()
	 * @see #getEvent()
	 * @generated
	 */
  EAttribute getEvent_SegmentSpeedLimit();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getCause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cause</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getCause()
	 * @see #getEvent()
	 * @generated
	 */
  EReference getEvent_Cause();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getAdvice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Advice</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getAdvice()
	 * @see #getEvent()
	 * @generated
	 */
  EReference getEvent_Advice();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getVehicleRestriction <em>Vehicle Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicle Restriction</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getVehicleRestriction()
	 * @see #getEvent()
	 * @generated
	 */
  EReference getEvent_VehicleRestriction();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected Speed Absolute</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getExpectedSpeedAbsolute()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_ExpectedSpeedAbsolute();

		/**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tec.event.Event#getTemporarySpeedLimit <em>Temporary Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Temporary Speed Limit</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Event#getTemporarySpeedLimit()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_TemporarySpeedLimit();

		/**
	 * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tec.event.Cause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cause</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Cause
	 * @generated
	 */
  EClass getCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Cause#getMainCause <em>Main Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main Cause</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Cause#getMainCause()
	 * @see #getCause()
	 * @generated
	 */
  EAttribute getCause_MainCause();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause <em>Linked Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linked Cause</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.LinkedCause
	 * @generated
	 */
  EClass getLinkedCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getLinkedMessage <em>Linked Message</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Linked Message</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getLinkedMessage()
	 * @see #getLinkedCause()
	 * @generated
	 */
  EAttribute getLinkedCause_LinkedMessage();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getCOID <em>COID</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>COID</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getCOID()
	 * @see #getLinkedCause()
	 * @generated
	 */
  EAttribute getLinkedCause_COID();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getOriginatorSID <em>Originator SID</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Originator SID</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.LinkedCause#getOriginatorSID()
	 * @see #getLinkedCause()
	 * @generated
	 */
  EReference getLinkedCause_OriginatorSID();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tec.event.DirectCause <em>Direct Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direct Cause</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DirectCause
	 * @generated
	 */
  EClass getDirectCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getWarningLevel <em>Warning Level</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Warning Level</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getWarningLevel()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_WarningLevel();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.DirectCause#isUnverifiedInformation <em>Unverified Information</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unverified Information</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DirectCause#isUnverifiedInformation()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_UnverifiedInformation();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getSubCause <em>Sub Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Cause</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getSubCause()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_SubCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getLengthAffected <em>Length Affected</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length Affected</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getLengthAffected()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_LengthAffected();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getLaneRestrictionType <em>Lane Restriction Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Restriction Type</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getLaneRestrictionType()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_LaneRestrictionType();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getNumberOfLanes <em>Number Of Lanes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Lanes</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getNumberOfLanes()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_NumberOfLanes();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getFreeText <em>Free Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Free Text</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getFreeText()
	 * @see #getDirectCause()
	 * @generated
	 */
  EReference getDirectCause_FreeText();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getCauseOffset <em>Cause Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cause Offset</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DirectCause#getCauseOffset()
	 * @see #getDirectCause()
	 * @generated
	 */
	EAttribute getDirectCause_CauseOffset();

		/**
	 * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advice</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Advice
	 * @generated
	 */
  EClass getAdvice();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getAdviceCode <em>Advice Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Advice Code</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Advice#getAdviceCode()
	 * @see #getAdvice()
	 * @generated
	 */
  EAttribute getAdvice_AdviceCode();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getSubAdviceCode <em>Sub Advice Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Advice Code</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Advice#getSubAdviceCode()
	 * @see #getAdvice()
	 * @generated
	 */
  EAttribute getAdvice_SubAdviceCode();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getFreeText <em>Free Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Free Text</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Advice#getFreeText()
	 * @see #getAdvice()
	 * @generated
	 */
  EReference getAdvice_FreeText();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tec.event.Advice#getVehicleRestriction <em>Vehicle Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicle Restriction</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Advice#getVehicleRestriction()
	 * @see #getAdvice()
	 * @generated
	 */
  EReference getAdvice_VehicleRestriction();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction <em>Vehicle Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle Restriction</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction
	 * @generated
	 */
  EClass getVehicleRestriction();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction#getVehicleType <em>Vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Type</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction#getVehicleType()
	 * @see #getVehicleRestriction()
	 * @generated
	 */
  EAttribute getVehicleRestriction_VehicleType();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction#getRestriction <em>Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Restriction</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleRestriction#getRestriction()
	 * @see #getVehicleRestriction()
	 * @generated
	 */
  EReference getVehicleRestriction_Restriction();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction <em>Vehicle Related Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle Related Restriction</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction
	 * @generated
	 */
  EClass getVehicleRelatedRestriction();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction#getRestrictionType <em>Restriction Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restriction Type</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction#getRestrictionType()
	 * @see #getVehicleRelatedRestriction()
	 * @generated
	 */
  EAttribute getVehicleRelatedRestriction_RestrictionType();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction#getRestrictionValue <em>Restriction Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restriction Value</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction#getRestrictionValue()
	 * @see #getVehicleRelatedRestriction()
	 * @generated
	 */
  EAttribute getVehicleRelatedRestriction_RestrictionValue();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction#getRestrictionLocation <em>Restriction Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Restriction Location</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleRelatedRestriction#getRestrictionLocation()
	 * @see #getVehicleRelatedRestriction()
	 * @generated
	 */
  EReference getVehicleRelatedRestriction_RestrictionLocation();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage <em>TEC Message</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TEC Message</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TECMessage
	 * @generated
	 */
  EClass getTECMessage();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getMmt <em>Mmt</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mmt</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getMmt()
	 * @see #getTECMessage()
	 * @generated
	 */
  EReference getTECMessage_Mmt();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getEvent()
	 * @see #getTECMessage()
	 * @generated
	 */
  EReference getTECMessage_Event();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getLoc <em>Loc</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loc</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TECMessage#getLoc()
	 * @see #getTECMessage()
	 * @generated
	 */
  EReference getTECMessage_Loc();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection <em>Temporary Speed Limit Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporary Speed Limit Section</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection
	 * @generated
	 */
	EClass getTemporarySpeedLimitSection();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValue <em>Speed Limit Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Limit Value</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValue()
	 * @see #getTemporarySpeedLimitSection()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimitSection_SpeedLimitValue();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValueWet <em>Speed Limit Value Wet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Limit Value Wet</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitValueWet()
	 * @see #getTemporarySpeedLimitSection()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimitSection_SpeedLimitValueWet();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitLength <em>Speed Limit Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Limit Length</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimitSection#getSpeedLimitLength()
	 * @see #getTemporarySpeedLimitSection()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimitSection_SpeedLimitLength();

		/**
	 * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit <em>Temporary Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporary Speed Limit</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit
	 * @generated
	 */
	EClass getTemporarySpeedLimit();

		/**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getSpeedLimitSection <em>Speed Limit Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Speed Limit Section</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getSpeedLimitSection()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EReference getTemporarySpeedLimit_SpeedLimitSection();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#isUnitsMPH <em>Units MPH</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Units MPH</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#isUnitsMPH()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimit_UnitsMPH();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getOffset()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimit_Offset();

		/**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getVehicleRestriction <em>Vehicle Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicle Restriction</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TemporarySpeedLimit#getVehicleRestriction()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EReference getTemporarySpeedLimit_VehicleRestriction();

		/**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.EffectCode <em>Effect Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Effect Code</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.EffectCode
	 * @generated
	 */
  EEnum getEffectCode();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.Tendency <em>Tendency</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tendency</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Tendency
	 * @generated
	 */
  EEnum getTendency();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.CauseCode <em>Cause Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cause Code</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.CauseCode
	 * @generated
	 */
  EEnum getCauseCode();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.WarningLevel <em>Warning Level</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Warning Level</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.WarningLevel
	 * @generated
	 */
  EEnum getWarningLevel();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion <em>Traffic Congestion</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Traffic Congestion</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion
	 * @generated
	 */
  EEnum getTrafficCongestion();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.Accident <em>Accident</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Accident</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Accident
	 * @generated
	 */
  EEnum getAccident();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.RoadWorks <em>Road Works</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Road Works</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RoadWorks
	 * @generated
	 */
  EEnum getRoadWorks();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes <em>Narrow Lanes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Narrow Lanes</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes
	 * @generated
	 */
  EEnum getNarrowLanes();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.Impassibility <em>Impassibility</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Impassibility</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Impassibility
	 * @generated
	 */
  EEnum getImpassibility();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad <em>Slippery Road</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Slippery Road</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad
	 * @generated
	 */
  EEnum getSlipperyRoad();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.Fire <em>Fire</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fire</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Fire
	 * @generated
	 */
  EEnum getFire();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions <em>Hazardous Driving Conditions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Hazardous Driving Conditions</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions
	 * @generated
	 */
  EEnum getHazardousDrivingConditions();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad <em>Objects On The Road</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Objects On The Road</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad
	 * @generated
	 */
  EEnum getObjectsOnTheRoad();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway <em>Animals On Roadway</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Animals On Roadway</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway
	 * @generated
	 */
  EEnum getAnimalsOnRoadway();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway <em>People On Roadway</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>People On Roadway</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway
	 * @generated
	 */
  EEnum getPeopleOnRoadway();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles <em>Broken Down Vehicles</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Broken Down Vehicles</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles
	 * @generated
	 */
  EEnum getBrokenDownVehicles();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress <em>Rescue And Recovery Work In Progress</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rescue And Recovery Work In Progress</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress
	 * @generated
	 */
  EEnum getRescueAndRecoveryWorkInProgress();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure <em>Regulatory Measure</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Regulatory Measure</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure
	 * @generated
	 */
  EEnum getRegulatoryMeasure();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType <em>Lane Restriction Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Lane Restriction Type</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType
	 * @generated
	 */
  EEnum getLaneRestrictionType();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.AdviceCode <em>Advice Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Advice Code</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.AdviceCode
	 * @generated
	 */
  EEnum getAdviceCode();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleType <em>Vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Vehicle Type</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleType
	 * @generated
	 */
  EEnum getVehicleType();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.RestrictionType <em>Restriction Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Restriction Type</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RestrictionType
	 * @generated
	 */
  EEnum getRestrictionType();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions <em>Extreme Weather Conditions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Extreme Weather Conditions</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions
	 * @generated
	 */
  EEnum getExtremeWeatherConditions();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced <em>Visibility Reduced</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility Reduced</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced
	 * @generated
	 */
  EEnum getVisibilityReduced();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.Precipitation <em>Precipitation</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Precipitation</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.Precipitation
	 * @generated
	 */
  EEnum getPrecipitation();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons <em>Reckless Persons</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Reckless Persons</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons
	 * @generated
	 */
  EEnum getRecklessPersons();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.MajorEvent <em>Major Event</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Major Event</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.MajorEvent
	 * @generated
	 */
  EEnum getMajorEvent();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating <em>Service Not Operating</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Not Operating</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating
	 * @generated
	 */
  EEnum getServiceNotOperating();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable <em>Service Not Usable</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Not Usable</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable
	 * @generated
	 */
  EEnum getServiceNotUsable();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles <em>Slow Moving Vehicles</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Slow Moving Vehicles</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles
	 * @generated
	 */
  EEnum getSlowMovingVehicles();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue <em>Dangerous End Of Queue</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dangerous End Of Queue</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue
	 * @generated
	 */
  EEnum getDangerousEndOfQueue();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire <em>Risk Of Fire</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Risk Of Fire</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire
	 * @generated
	 */
  EEnum getRiskOfFire();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.TimeDelay <em>Time Delay</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Delay</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.TimeDelay
	 * @generated
	 */
  EEnum getTimeDelay();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint <em>Police Checkpoint</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Police Checkpoint</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint
	 * @generated
	 */
  EEnum getPoliceCheckpoint();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment <em>Malfunctioning Roadside Equipment</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Malfunctioning Roadside Equipment</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment
	 * @generated
	 */
  EEnum getMalfunctioningRoadsideEquipment();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed <em>Overtaking Not Allowed</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Overtaking Not Allowed</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed
	 * @generated
	 */
  EEnum getOvertakingNotAllowed();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed <em>Driving Not Allowed</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Driving Not Allowed</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed
	 * @generated
	 */
  EEnum getDrivingNotAllowed();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind <em>Giving Path Vehicles From Behind</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Giving Path Vehicles From Behind</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind
	 * @generated
	 */
  EEnum getGivingPathVehiclesFromBehind();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion <em>Follow Diversion</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Follow Diversion</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion
	 * @generated
	 */
  EEnum getFollowDiversion();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully <em>Drive Carefully</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Drive Carefully</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully
	 * @generated
	 */
  EEnum getDriveCarefully();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle <em>Do Not Leave Your Vehicle</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Do Not Leave Your Vehicle</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle
	 * @generated
	 */
  EEnum getDoNotLeaveYourVehicle();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes <em>Use Toll Lanes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Use Toll Lanes</em>'.
	 * @see org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes
	 * @generated
	 */
  EEnum getUseTollLanes();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  EventFactory getEventFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals {
    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventImpl
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getEvent()
		 * @generated
		 */
    EClass EVENT = eINSTANCE.getEvent();

    /**
		 * The meta object literal for the '<em><b>Effect Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute EVENT__EFFECT_CODE = eINSTANCE.getEvent_EffectCode();

    /**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute EVENT__START_TIME = eINSTANCE.getEvent_StartTime();

    /**
		 * The meta object literal for the '<em><b>Stop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute EVENT__STOP_TIME = eINSTANCE.getEvent_StopTime();

    /**
		 * The meta object literal for the '<em><b>Tendency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute EVENT__TENDENCY = eINSTANCE.getEvent_Tendency();

    /**
		 * The meta object literal for the '<em><b>Length Affected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute EVENT__LENGTH_AFFECTED = eINSTANCE.getEvent_LengthAffected();

    /**
		 * The meta object literal for the '<em><b>Average Speed Absolute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute EVENT__AVERAGE_SPEED_ABSOLUTE = eINSTANCE.getEvent_AverageSpeedAbsolute();

    /**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute EVENT__DELAY = eINSTANCE.getEvent_Delay();

    /**
		 * The meta object literal for the '<em><b>Segment Speed Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute EVENT__SEGMENT_SPEED_LIMIT = eINSTANCE.getEvent_SegmentSpeedLimit();

    /**
		 * The meta object literal for the '<em><b>Cause</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference EVENT__CAUSE = eINSTANCE.getEvent_Cause();

    /**
		 * The meta object literal for the '<em><b>Advice</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference EVENT__ADVICE = eINSTANCE.getEvent_Advice();

    /**
		 * The meta object literal for the '<em><b>Vehicle Restriction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference EVENT__VEHICLE_RESTRICTION = eINSTANCE.getEvent_VehicleRestriction();

    /**
		 * The meta object literal for the '<em><b>Expected Speed Absolute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__EXPECTED_SPEED_ABSOLUTE = eINSTANCE.getEvent_ExpectedSpeedAbsolute();

				/**
		 * The meta object literal for the '<em><b>Temporary Speed Limit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__TEMPORARY_SPEED_LIMIT = eINSTANCE.getEvent_TemporarySpeedLimit();

				/**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.CauseImpl <em>Cause</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.CauseImpl
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getCause()
		 * @generated
		 */
    EClass CAUSE = eINSTANCE.getCause();

    /**
		 * The meta object literal for the '<em><b>Main Cause</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CAUSE__MAIN_CAUSE = eINSTANCE.getCause_MainCause();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.LinkedCauseImpl <em>Linked Cause</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.LinkedCauseImpl
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getLinkedCause()
		 * @generated
		 */
    EClass LINKED_CAUSE = eINSTANCE.getLinkedCause();

    /**
		 * The meta object literal for the '<em><b>Linked Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LINKED_CAUSE__LINKED_MESSAGE = eINSTANCE.getLinkedCause_LinkedMessage();

    /**
		 * The meta object literal for the '<em><b>COID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LINKED_CAUSE__COID = eINSTANCE.getLinkedCause_COID();

    /**
		 * The meta object literal for the '<em><b>Originator SID</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference LINKED_CAUSE__ORIGINATOR_SID = eINSTANCE.getLinkedCause_OriginatorSID();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl <em>Direct Cause</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.DirectCauseImpl
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getDirectCause()
		 * @generated
		 */
    EClass DIRECT_CAUSE = eINSTANCE.getDirectCause();

    /**
		 * The meta object literal for the '<em><b>Warning Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DIRECT_CAUSE__WARNING_LEVEL = eINSTANCE.getDirectCause_WarningLevel();

    /**
		 * The meta object literal for the '<em><b>Unverified Information</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DIRECT_CAUSE__UNVERIFIED_INFORMATION = eINSTANCE.getDirectCause_UnverifiedInformation();

    /**
		 * The meta object literal for the '<em><b>Sub Cause</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DIRECT_CAUSE__SUB_CAUSE = eINSTANCE.getDirectCause_SubCause();

    /**
		 * The meta object literal for the '<em><b>Length Affected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DIRECT_CAUSE__LENGTH_AFFECTED = eINSTANCE.getDirectCause_LengthAffected();

    /**
		 * The meta object literal for the '<em><b>Lane Restriction Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DIRECT_CAUSE__LANE_RESTRICTION_TYPE = eINSTANCE.getDirectCause_LaneRestrictionType();

    /**
		 * The meta object literal for the '<em><b>Number Of Lanes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DIRECT_CAUSE__NUMBER_OF_LANES = eINSTANCE.getDirectCause_NumberOfLanes();

    /**
		 * The meta object literal for the '<em><b>Free Text</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DIRECT_CAUSE__FREE_TEXT = eINSTANCE.getDirectCause_FreeText();

    /**
		 * The meta object literal for the '<em><b>Cause Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECT_CAUSE__CAUSE_OFFSET = eINSTANCE.getDirectCause_CauseOffset();

				/**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.AdviceImpl <em>Advice</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.AdviceImpl
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getAdvice()
		 * @generated
		 */
    EClass ADVICE = eINSTANCE.getAdvice();

    /**
		 * The meta object literal for the '<em><b>Advice Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ADVICE__ADVICE_CODE = eINSTANCE.getAdvice_AdviceCode();

    /**
		 * The meta object literal for the '<em><b>Sub Advice Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ADVICE__SUB_ADVICE_CODE = eINSTANCE.getAdvice_SubAdviceCode();

    /**
		 * The meta object literal for the '<em><b>Free Text</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ADVICE__FREE_TEXT = eINSTANCE.getAdvice_FreeText();

    /**
		 * The meta object literal for the '<em><b>Vehicle Restriction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ADVICE__VEHICLE_RESTRICTION = eINSTANCE.getAdvice_VehicleRestriction();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRestrictionImpl <em>Vehicle Restriction</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRestrictionImpl
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getVehicleRestriction()
		 * @generated
		 */
    EClass VEHICLE_RESTRICTION = eINSTANCE.getVehicleRestriction();

    /**
		 * The meta object literal for the '<em><b>Vehicle Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VEHICLE_RESTRICTION__VEHICLE_TYPE = eINSTANCE.getVehicleRestriction_VehicleType();

    /**
		 * The meta object literal for the '<em><b>Restriction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference VEHICLE_RESTRICTION__RESTRICTION = eINSTANCE.getVehicleRestriction_Restriction();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRelatedRestrictionImpl <em>Vehicle Related Restriction</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.VehicleRelatedRestrictionImpl
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getVehicleRelatedRestriction()
		 * @generated
		 */
    EClass VEHICLE_RELATED_RESTRICTION = eINSTANCE.getVehicleRelatedRestriction();

    /**
		 * The meta object literal for the '<em><b>Restriction Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VEHICLE_RELATED_RESTRICTION__RESTRICTION_TYPE = eINSTANCE.getVehicleRelatedRestriction_RestrictionType();

    /**
		 * The meta object literal for the '<em><b>Restriction Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VEHICLE_RELATED_RESTRICTION__RESTRICTION_VALUE = eINSTANCE.getVehicleRelatedRestriction_RestrictionValue();

    /**
		 * The meta object literal for the '<em><b>Restriction Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION = eINSTANCE.getVehicleRelatedRestriction_RestrictionLocation();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TECMessageImpl <em>TEC Message</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.TECMessageImpl
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTECMessage()
		 * @generated
		 */
    EClass TEC_MESSAGE = eINSTANCE.getTECMessage();

    /**
		 * The meta object literal for the '<em><b>Mmt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TEC_MESSAGE__MMT = eINSTANCE.getTECMessage_Mmt();

    /**
		 * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TEC_MESSAGE__EVENT = eINSTANCE.getTECMessage_Event();

    /**
		 * The meta object literal for the '<em><b>Loc</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TEC_MESSAGE__LOC = eINSTANCE.getTECMessage_Loc();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitSectionImpl <em>Temporary Speed Limit Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitSectionImpl
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTemporarySpeedLimitSection()
		 * @generated
		 */
		EClass TEMPORARY_SPEED_LIMIT_SECTION = eINSTANCE.getTemporarySpeedLimitSection();

				/**
		 * The meta object literal for the '<em><b>Speed Limit Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE = eINSTANCE.getTemporarySpeedLimitSection_SpeedLimitValue();

				/**
		 * The meta object literal for the '<em><b>Speed Limit Value Wet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_VALUE_WET = eINSTANCE.getTemporarySpeedLimitSection_SpeedLimitValueWet();

				/**
		 * The meta object literal for the '<em><b>Speed Limit Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPORARY_SPEED_LIMIT_SECTION__SPEED_LIMIT_LENGTH = eINSTANCE.getTemporarySpeedLimitSection_SpeedLimitLength();

				/**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitImpl <em>Temporary Speed Limit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.TemporarySpeedLimitImpl
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTemporarySpeedLimit()
		 * @generated
		 */
		EClass TEMPORARY_SPEED_LIMIT = eINSTANCE.getTemporarySpeedLimit();

				/**
		 * The meta object literal for the '<em><b>Speed Limit Section</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPORARY_SPEED_LIMIT__SPEED_LIMIT_SECTION = eINSTANCE.getTemporarySpeedLimit_SpeedLimitSection();

				/**
		 * The meta object literal for the '<em><b>Units MPH</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPORARY_SPEED_LIMIT__UNITS_MPH = eINSTANCE.getTemporarySpeedLimit_UnitsMPH();

				/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPORARY_SPEED_LIMIT__OFFSET = eINSTANCE.getTemporarySpeedLimit_Offset();

				/**
		 * The meta object literal for the '<em><b>Vehicle Restriction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPORARY_SPEED_LIMIT__VEHICLE_RESTRICTION = eINSTANCE.getTemporarySpeedLimit_VehicleRestriction();

				/**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.EffectCode <em>Effect Code</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.EffectCode
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getEffectCode()
		 * @generated
		 */
    EEnum EFFECT_CODE = eINSTANCE.getEffectCode();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.Tendency <em>Tendency</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.Tendency
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTendency()
		 * @generated
		 */
    EEnum TENDENCY = eINSTANCE.getTendency();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.CauseCode <em>Cause Code</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.CauseCode
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getCauseCode()
		 * @generated
		 */
    EEnum CAUSE_CODE = eINSTANCE.getCauseCode();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.WarningLevel <em>Warning Level</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.WarningLevel
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getWarningLevel()
		 * @generated
		 */
    EEnum WARNING_LEVEL = eINSTANCE.getWarningLevel();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion <em>Traffic Congestion</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.TrafficCongestion
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTrafficCongestion()
		 * @generated
		 */
    EEnum TRAFFIC_CONGESTION = eINSTANCE.getTrafficCongestion();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.Accident <em>Accident</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.Accident
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getAccident()
		 * @generated
		 */
    EEnum ACCIDENT = eINSTANCE.getAccident();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RoadWorks <em>Road Works</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.RoadWorks
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRoadWorks()
		 * @generated
		 */
    EEnum ROAD_WORKS = eINSTANCE.getRoadWorks();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes <em>Narrow Lanes</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.NarrowLanes
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getNarrowLanes()
		 * @generated
		 */
    EEnum NARROW_LANES = eINSTANCE.getNarrowLanes();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.Impassibility <em>Impassibility</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.Impassibility
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getImpassibility()
		 * @generated
		 */
    EEnum IMPASSIBILITY = eINSTANCE.getImpassibility();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad <em>Slippery Road</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.SlipperyRoad
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getSlipperyRoad()
		 * @generated
		 */
    EEnum SLIPPERY_ROAD = eINSTANCE.getSlipperyRoad();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.Fire <em>Fire</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.Fire
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getFire()
		 * @generated
		 */
    EEnum FIRE = eINSTANCE.getFire();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions <em>Hazardous Driving Conditions</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.HazardousDrivingConditions
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getHazardousDrivingConditions()
		 * @generated
		 */
    EEnum HAZARDOUS_DRIVING_CONDITIONS = eINSTANCE.getHazardousDrivingConditions();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad <em>Objects On The Road</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.ObjectsOnTheRoad
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getObjectsOnTheRoad()
		 * @generated
		 */
    EEnum OBJECTS_ON_THE_ROAD = eINSTANCE.getObjectsOnTheRoad();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway <em>Animals On Roadway</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.AnimalsOnRoadway
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getAnimalsOnRoadway()
		 * @generated
		 */
    EEnum ANIMALS_ON_ROADWAY = eINSTANCE.getAnimalsOnRoadway();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway <em>People On Roadway</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.PeopleOnRoadway
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getPeopleOnRoadway()
		 * @generated
		 */
    EEnum PEOPLE_ON_ROADWAY = eINSTANCE.getPeopleOnRoadway();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles <em>Broken Down Vehicles</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.BrokenDownVehicles
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getBrokenDownVehicles()
		 * @generated
		 */
    EEnum BROKEN_DOWN_VEHICLES = eINSTANCE.getBrokenDownVehicles();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress <em>Rescue And Recovery Work In Progress</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.RescueAndRecoveryWorkInProgress
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRescueAndRecoveryWorkInProgress()
		 * @generated
		 */
    EEnum RESCUE_AND_RECOVERY_WORK_IN_PROGRESS = eINSTANCE.getRescueAndRecoveryWorkInProgress();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure <em>Regulatory Measure</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.RegulatoryMeasure
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRegulatoryMeasure()
		 * @generated
		 */
    EEnum REGULATORY_MEASURE = eINSTANCE.getRegulatoryMeasure();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType <em>Lane Restriction Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.LaneRestrictionType
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getLaneRestrictionType()
		 * @generated
		 */
    EEnum LANE_RESTRICTION_TYPE = eINSTANCE.getLaneRestrictionType();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.AdviceCode <em>Advice Code</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.AdviceCode
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getAdviceCode()
		 * @generated
		 */
    EEnum ADVICE_CODE = eINSTANCE.getAdviceCode();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.VehicleType <em>Vehicle Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.VehicleType
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getVehicleType()
		 * @generated
		 */
    EEnum VEHICLE_TYPE = eINSTANCE.getVehicleType();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RestrictionType <em>Restriction Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.RestrictionType
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRestrictionType()
		 * @generated
		 */
    EEnum RESTRICTION_TYPE = eINSTANCE.getRestrictionType();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions <em>Extreme Weather Conditions</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.ExtremeWeatherConditions
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getExtremeWeatherConditions()
		 * @generated
		 */
    EEnum EXTREME_WEATHER_CONDITIONS = eINSTANCE.getExtremeWeatherConditions();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced <em>Visibility Reduced</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.VisibilityReduced
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getVisibilityReduced()
		 * @generated
		 */
    EEnum VISIBILITY_REDUCED = eINSTANCE.getVisibilityReduced();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.Precipitation <em>Precipitation</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.Precipitation
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getPrecipitation()
		 * @generated
		 */
    EEnum PRECIPITATION = eINSTANCE.getPrecipitation();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons <em>Reckless Persons</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.RecklessPersons
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRecklessPersons()
		 * @generated
		 */
    EEnum RECKLESS_PERSONS = eINSTANCE.getRecklessPersons();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.MajorEvent <em>Major Event</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.MajorEvent
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getMajorEvent()
		 * @generated
		 */
    EEnum MAJOR_EVENT = eINSTANCE.getMajorEvent();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating <em>Service Not Operating</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.ServiceNotOperating
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getServiceNotOperating()
		 * @generated
		 */
    EEnum SERVICE_NOT_OPERATING = eINSTANCE.getServiceNotOperating();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable <em>Service Not Usable</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.ServiceNotUsable
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getServiceNotUsable()
		 * @generated
		 */
    EEnum SERVICE_NOT_USABLE = eINSTANCE.getServiceNotUsable();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles <em>Slow Moving Vehicles</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.SlowMovingVehicles
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getSlowMovingVehicles()
		 * @generated
		 */
    EEnum SLOW_MOVING_VEHICLES = eINSTANCE.getSlowMovingVehicles();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue <em>Dangerous End Of Queue</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.DangerousEndOfQueue
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getDangerousEndOfQueue()
		 * @generated
		 */
    EEnum DANGEROUS_END_OF_QUEUE = eINSTANCE.getDangerousEndOfQueue();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire <em>Risk Of Fire</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.RiskOfFire
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getRiskOfFire()
		 * @generated
		 */
    EEnum RISK_OF_FIRE = eINSTANCE.getRiskOfFire();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.TimeDelay <em>Time Delay</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.TimeDelay
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getTimeDelay()
		 * @generated
		 */
    EEnum TIME_DELAY = eINSTANCE.getTimeDelay();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint <em>Police Checkpoint</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.PoliceCheckpoint
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getPoliceCheckpoint()
		 * @generated
		 */
    EEnum POLICE_CHECKPOINT = eINSTANCE.getPoliceCheckpoint();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment <em>Malfunctioning Roadside Equipment</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.MalfunctioningRoadsideEquipment
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getMalfunctioningRoadsideEquipment()
		 * @generated
		 */
    EEnum MALFUNCTIONING_ROADSIDE_EQUIPMENT = eINSTANCE.getMalfunctioningRoadsideEquipment();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed <em>Overtaking Not Allowed</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.OvertakingNotAllowed
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getOvertakingNotAllowed()
		 * @generated
		 */
    EEnum OVERTAKING_NOT_ALLOWED = eINSTANCE.getOvertakingNotAllowed();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed <em>Driving Not Allowed</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.DrivingNotAllowed
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getDrivingNotAllowed()
		 * @generated
		 */
    EEnum DRIVING_NOT_ALLOWED = eINSTANCE.getDrivingNotAllowed();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind <em>Giving Path Vehicles From Behind</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.GivingPathVehiclesFromBehind
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getGivingPathVehiclesFromBehind()
		 * @generated
		 */
    EEnum GIVING_PATH_VEHICLES_FROM_BEHIND = eINSTANCE.getGivingPathVehiclesFromBehind();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion <em>Follow Diversion</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.FollowDiversion
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getFollowDiversion()
		 * @generated
		 */
    EEnum FOLLOW_DIVERSION = eINSTANCE.getFollowDiversion();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully <em>Drive Carefully</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.DriveCarefully
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getDriveCarefully()
		 * @generated
		 */
    EEnum DRIVE_CAREFULLY = eINSTANCE.getDriveCarefully();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle <em>Do Not Leave Your Vehicle</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.DoNotLeaveYourVehicle
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getDoNotLeaveYourVehicle()
		 * @generated
		 */
    EEnum DO_NOT_LEAVE_YOUR_VEHICLE = eINSTANCE.getDoNotLeaveYourVehicle();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes <em>Use Toll Lanes</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficinfo.tpeg.tec.event.UseTollLanes
		 * @see org.genivi.trafficinfo.tpeg.tec.event.impl.EventPackageImpl#getUseTollLanes()
		 * @generated
		 */
    EEnum USE_TOLL_LANES = eINSTANCE.getUseTollLanes();

  }

} //EventPackage
