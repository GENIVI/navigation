/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface XTrafficIncidentPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "trafficincident";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://org.genivi.xtrafficinfo";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "TrafficIncident";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  XTrafficIncidentPackage eINSTANCE = org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl <em>Traffic Incident</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getTrafficIncident()
	 * @generated
	 */
  int TRAFFIC_INCIDENT = 0;

  /**
	 * The feature id for the '<em><b>Effect Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__EFFECT_CODE = 0;

  /**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__START_TIME = 1;

  /**
	 * The feature id for the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__STOP_TIME = 2;

  /**
	 * The feature id for the '<em><b>Tendency</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__TENDENCY = 3;

  /**
	 * The feature id for the '<em><b>Length Affected</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__LENGTH_AFFECTED = 4;

  /**
	 * The feature id for the '<em><b>Average Speed Absolute</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE = 5;

  /**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__DELAY = 6;

  /**
	 * The feature id for the '<em><b>Segment Speed Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT = 7;

  /**
	 * The feature id for the '<em><b>Causes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__CAUSES = 8;

  /**
	 * The feature id for the '<em><b>Advices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__ADVICES = 9;

  /**
	 * The feature id for the '<em><b>Applicability</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__APPLICABILITY = 10;

  /**
	 * The feature id for the '<em><b>Traffic Incident Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID = 11;

  /**
	 * The feature id for the '<em><b>Expected Speed Absolute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE = 12;

		/**
	 * The feature id for the '<em><b>Expiration Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__EXPIRATION_TIME = 13;

  /**
	 * The feature id for the '<em><b>Update Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__UPDATE_TIME = 14;

  /**
	 * The feature id for the '<em><b>Location Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__LOCATION_REFERENCE = 15;

  /**
	 * The feature id for the '<em><b>Temporary Speed Limit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT = 16;

		/**
	 * The number of structural features of the '<em>Traffic Incident</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT_FEATURE_COUNT = 17;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.CauseImpl <em>Cause</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.CauseImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getCause()
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
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.LinkedCauseImpl <em>Linked Cause</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.LinkedCauseImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getLinkedCause()
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
	 * The feature id for the '<em><b>Cause Traffic Incident Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINKED_CAUSE__CAUSE_TRAFFIC_INCIDENT_ID = CAUSE_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Linked Cause</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LINKED_CAUSE_FEATURE_COUNT = CAUSE_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.DirectCauseImpl <em>Direct Cause</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.DirectCauseImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getDirectCause()
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
	 * The feature id for the '<em><b>Lane Restrictions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE__LANE_RESTRICTIONS = CAUSE_FEATURE_COUNT + 4;

  /**
	 * The feature id for the '<em><b>Free Text</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE__FREE_TEXT = CAUSE_FEATURE_COUNT + 5;

  /**
	 * The feature id for the '<em><b>Cause Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_CAUSE__CAUSE_OFFSET = CAUSE_FEATURE_COUNT + 6;

		/**
	 * The number of structural features of the '<em>Direct Cause</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DIRECT_CAUSE_FEATURE_COUNT = CAUSE_FEATURE_COUNT + 7;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.LaneRestrictionsImpl <em>Lane Restrictions</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.LaneRestrictionsImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getLaneRestrictions()
	 * @generated
	 */
  int LANE_RESTRICTIONS = 4;

  /**
	 * The feature id for the '<em><b>Lane Restriction Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LANE_RESTRICTIONS__LANE_RESTRICTION_TYPE = 0;

  /**
	 * The feature id for the '<em><b>Number Of Lanes</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LANE_RESTRICTIONS__NUMBER_OF_LANES = 1;

  /**
	 * The number of structural features of the '<em>Lane Restrictions</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LANE_RESTRICTIONS_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.AdviceImpl <em>Advice</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.AdviceImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getAdvice()
	 * @generated
	 */
  int ADVICE = 5;

  /**
	 * The feature id for the '<em><b>Main Advice</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE__MAIN_ADVICE = 0;

  /**
	 * The feature id for the '<em><b>Sub Advice</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE__SUB_ADVICE = 1;

  /**
	 * The feature id for the '<em><b>Free Text</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE__FREE_TEXT = 2;

  /**
	 * The feature id for the '<em><b>Applicability</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE__APPLICABILITY = 3;

  /**
	 * The number of structural features of the '<em>Advice</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE_FEATURE_COUNT = 4;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.ApplicabilityImpl <em>Applicability</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.ApplicabilityImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getApplicability()
	 * @generated
	 */
  int APPLICABILITY = 6;

  /**
	 * The feature id for the '<em><b>Vehicle Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int APPLICABILITY__VEHICLE_TYPE = 0;

  /**
	 * The feature id for the '<em><b>Vehicle Related Restrictions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int APPLICABILITY__VEHICLE_RELATED_RESTRICTIONS = 1;

  /**
	 * The number of structural features of the '<em>Applicability</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int APPLICABILITY_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.VehicleRelatedRestrictionImpl <em>Vehicle Related Restriction</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.VehicleRelatedRestrictionImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getVehicleRelatedRestriction()
	 * @generated
	 */
  int VEHICLE_RELATED_RESTRICTION = 7;

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
	 * The feature id for the '<em><b>Restriction Location Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION_REFERENCE = 2;

  /**
	 * The number of structural features of the '<em>Vehicle Related Restriction</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VEHICLE_RELATED_RESTRICTION_FEATURE_COUNT = 3;


  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitSectionImpl <em>Temporary Speed Limit Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitSectionImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getTemporarySpeedLimitSection()
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
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitImpl <em>Temporary Speed Limit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getTemporarySpeedLimit()
	 * @generated
	 */
	int TEMPORARY_SPEED_LIMIT = 9;

		/**
	 * The feature id for the '<em><b>Temporary Speed Limit Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT__TEMPORARY_SPEED_LIMIT_SECTIONS = 0;

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
	 * The feature id for the '<em><b>Applicability</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT__APPLICABILITY = 3;

		/**
	 * The number of structural features of the '<em>Temporary Speed Limit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORARY_SPEED_LIMIT_FEATURE_COUNT = 4;


		/**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident <em>Traffic Incident</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traffic Incident</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident
	 * @generated
	 */
  EClass getTrafficIncident();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getEffectCode <em>Effect Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effect Code</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getEffectCode()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_EffectCode();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStartTime()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_StartTime();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStopTime <em>Stop Time</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Time</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getStopTime()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_StopTime();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTendency <em>Tendency</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tendency</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTendency()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_Tendency();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLengthAffected <em>Length Affected</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length Affected</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLengthAffected()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_LengthAffected();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average Speed Absolute</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAverageSpeedAbsolute()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_AverageSpeedAbsolute();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getDelay()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_Delay();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getSegmentSpeedLimit <em>Segment Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Segment Speed Limit</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getSegmentSpeedLimit()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_SegmentSpeedLimit();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getCauses <em>Causes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Causes</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getCauses()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EReference getTrafficIncident_Causes();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAdvices <em>Advices</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Advices</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getAdvices()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EReference getTrafficIncident_Advices();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getApplicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applicability</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getApplicability()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EReference getTrafficIncident_Applicability();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTrafficIncidentId <em>Traffic Incident Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traffic Incident Id</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTrafficIncidentId()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_TrafficIncidentId();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected Speed Absolute</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpectedSpeedAbsolute()
	 * @see #getTrafficIncident()
	 * @generated
	 */
	EAttribute getTrafficIncident_ExpectedSpeedAbsolute();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpirationTime <em>Expiration Time</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiration Time</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getExpirationTime()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_ExpirationTime();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getUpdateTime <em>Update Time</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Update Time</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getUpdateTime()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_UpdateTime();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLocationReference <em>Location Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location Reference</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getLocationReference()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EReference getTrafficIncident_LocationReference();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTemporarySpeedLimit <em>Temporary Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Temporary Speed Limit</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TrafficIncident#getTemporarySpeedLimit()
	 * @see #getTrafficIncident()
	 * @generated
	 */
	EReference getTrafficIncident_TemporarySpeedLimit();

		/**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cause</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause
	 * @generated
	 */
  EClass getCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause#getMainCause <em>Main Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main Cause</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Cause#getMainCause()
	 * @see #getCause()
	 * @generated
	 */
  EAttribute getCause_MainCause();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause <em>Linked Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linked Cause</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause
	 * @generated
	 */
  EClass getLinkedCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause#getCauseTrafficIncidentId <em>Cause Traffic Incident Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cause Traffic Incident Id</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LinkedCause#getCauseTrafficIncidentId()
	 * @see #getLinkedCause()
	 * @generated
	 */
  EAttribute getLinkedCause_CauseTrafficIncidentId();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause <em>Direct Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direct Cause</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause
	 * @generated
	 */
  EClass getDirectCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getWarningLevel <em>Warning Level</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Warning Level</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getWarningLevel()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_WarningLevel();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#isUnverifiedInformation <em>Unverified Information</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unverified Information</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#isUnverifiedInformation()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_UnverifiedInformation();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getSubCause <em>Sub Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Cause</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getSubCause()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_SubCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLengthAffected <em>Length Affected</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length Affected</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLengthAffected()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_LengthAffected();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLaneRestrictions <em>Lane Restrictions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lane Restrictions</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getLaneRestrictions()
	 * @see #getDirectCause()
	 * @generated
	 */
  EReference getDirectCause_LaneRestrictions();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getFreeText <em>Free Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Free Text</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getFreeText()
	 * @see #getDirectCause()
	 * @generated
	 */
  EReference getDirectCause_FreeText();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getCauseOffset <em>Cause Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cause Offset</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.DirectCause#getCauseOffset()
	 * @see #getDirectCause()
	 * @generated
	 */
	EAttribute getDirectCause_CauseOffset();

		/**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions <em>Lane Restrictions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lane Restrictions</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions
	 * @generated
	 */
  EClass getLaneRestrictions();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions#getLaneRestrictionType <em>Lane Restriction Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Restriction Type</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions#getLaneRestrictionType()
	 * @see #getLaneRestrictions()
	 * @generated
	 */
  EAttribute getLaneRestrictions_LaneRestrictionType();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions#getNumberOfLanes <em>Number Of Lanes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Lanes</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.LaneRestrictions#getNumberOfLanes()
	 * @see #getLaneRestrictions()
	 * @generated
	 */
  EAttribute getLaneRestrictions_NumberOfLanes();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advice</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice
	 * @generated
	 */
  EClass getAdvice();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getMainAdvice <em>Main Advice</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main Advice</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getMainAdvice()
	 * @see #getAdvice()
	 * @generated
	 */
  EAttribute getAdvice_MainAdvice();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getSubAdvice <em>Sub Advice</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Advice</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getSubAdvice()
	 * @see #getAdvice()
	 * @generated
	 */
  EAttribute getAdvice_SubAdvice();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getFreeText <em>Free Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Free Text</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getFreeText()
	 * @see #getAdvice()
	 * @generated
	 */
  EReference getAdvice_FreeText();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getApplicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applicability</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Advice#getApplicability()
	 * @see #getAdvice()
	 * @generated
	 */
  EReference getAdvice_Applicability();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Applicability</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability
	 * @generated
	 */
  EClass getApplicability();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability#getVehicleType <em>Vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Type</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability#getVehicleType()
	 * @see #getApplicability()
	 * @generated
	 */
  EAttribute getApplicability_VehicleType();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability#getVehicleRelatedRestrictions <em>Vehicle Related Restrictions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicle Related Restrictions</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.Applicability#getVehicleRelatedRestrictions()
	 * @see #getApplicability()
	 * @generated
	 */
  EReference getApplicability_VehicleRelatedRestrictions();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction <em>Vehicle Related Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle Related Restriction</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction
	 * @generated
	 */
  EClass getVehicleRelatedRestriction();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionType <em>Restriction Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restriction Type</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionType()
	 * @see #getVehicleRelatedRestriction()
	 * @generated
	 */
  EAttribute getVehicleRelatedRestriction_RestrictionType();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionValue <em>Restriction Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restriction Value</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionValue()
	 * @see #getVehicleRelatedRestriction()
	 * @generated
	 */
  EAttribute getVehicleRelatedRestriction_RestrictionValue();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionLocationReference <em>Restriction Location Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Restriction Location Reference</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.VehicleRelatedRestriction#getRestrictionLocationReference()
	 * @see #getVehicleRelatedRestriction()
	 * @generated
	 */
  EReference getVehicleRelatedRestriction_RestrictionLocationReference();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection <em>Temporary Speed Limit Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporary Speed Limit Section</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection
	 * @generated
	 */
	EClass getTemporarySpeedLimitSection();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection#getSpeedLimitValue <em>Speed Limit Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Limit Value</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection#getSpeedLimitValue()
	 * @see #getTemporarySpeedLimitSection()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimitSection_SpeedLimitValue();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection#getSpeedLimitValueWet <em>Speed Limit Value Wet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Limit Value Wet</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection#getSpeedLimitValueWet()
	 * @see #getTemporarySpeedLimitSection()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimitSection_SpeedLimitValueWet();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection#getSpeedLimitLength <em>Speed Limit Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Limit Length</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimitSection#getSpeedLimitLength()
	 * @see #getTemporarySpeedLimitSection()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimitSection_SpeedLimitLength();

		/**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit <em>Temporary Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporary Speed Limit</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit
	 * @generated
	 */
	EClass getTemporarySpeedLimit();

		/**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit#getTemporarySpeedLimitSections <em>Temporary Speed Limit Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Temporary Speed Limit Sections</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit#getTemporarySpeedLimitSections()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EReference getTemporarySpeedLimit_TemporarySpeedLimitSections();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit#isUnitsMPH <em>Units MPH</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Units MPH</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit#isUnitsMPH()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimit_UnitsMPH();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit#getOffset()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimit_Offset();

		/**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit#getApplicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applicability</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.TemporarySpeedLimit#getApplicability()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EReference getTemporarySpeedLimit_Applicability();

		/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  XTrafficIncidentFactory getXTrafficIncidentFactory();

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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl <em>Traffic Incident</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TrafficIncidentImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getTrafficIncident()
		 * @generated
		 */
    EClass TRAFFIC_INCIDENT = eINSTANCE.getTrafficIncident();

    /**
		 * The meta object literal for the '<em><b>Effect Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__EFFECT_CODE = eINSTANCE.getTrafficIncident_EffectCode();

    /**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__START_TIME = eINSTANCE.getTrafficIncident_StartTime();

    /**
		 * The meta object literal for the '<em><b>Stop Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__STOP_TIME = eINSTANCE.getTrafficIncident_StopTime();

    /**
		 * The meta object literal for the '<em><b>Tendency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__TENDENCY = eINSTANCE.getTrafficIncident_Tendency();

    /**
		 * The meta object literal for the '<em><b>Length Affected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__LENGTH_AFFECTED = eINSTANCE.getTrafficIncident_LengthAffected();

    /**
		 * The meta object literal for the '<em><b>Average Speed Absolute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE = eINSTANCE.getTrafficIncident_AverageSpeedAbsolute();

    /**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__DELAY = eINSTANCE.getTrafficIncident_Delay();

    /**
		 * The meta object literal for the '<em><b>Segment Speed Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT = eINSTANCE.getTrafficIncident_SegmentSpeedLimit();

    /**
		 * The meta object literal for the '<em><b>Causes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRAFFIC_INCIDENT__CAUSES = eINSTANCE.getTrafficIncident_Causes();

    /**
		 * The meta object literal for the '<em><b>Advices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRAFFIC_INCIDENT__ADVICES = eINSTANCE.getTrafficIncident_Advices();

    /**
		 * The meta object literal for the '<em><b>Applicability</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRAFFIC_INCIDENT__APPLICABILITY = eINSTANCE.getTrafficIncident_Applicability();

    /**
		 * The meta object literal for the '<em><b>Traffic Incident Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID = eINSTANCE.getTrafficIncident_TrafficIncidentId();

    /**
		 * The meta object literal for the '<em><b>Expected Speed Absolute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE = eINSTANCE.getTrafficIncident_ExpectedSpeedAbsolute();

				/**
		 * The meta object literal for the '<em><b>Expiration Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__EXPIRATION_TIME = eINSTANCE.getTrafficIncident_ExpirationTime();

    /**
		 * The meta object literal for the '<em><b>Update Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__UPDATE_TIME = eINSTANCE.getTrafficIncident_UpdateTime();

    /**
		 * The meta object literal for the '<em><b>Location Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRAFFIC_INCIDENT__LOCATION_REFERENCE = eINSTANCE.getTrafficIncident_LocationReference();

    /**
		 * The meta object literal for the '<em><b>Temporary Speed Limit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT = eINSTANCE.getTrafficIncident_TemporarySpeedLimit();

				/**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.CauseImpl <em>Cause</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.CauseImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getCause()
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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.LinkedCauseImpl <em>Linked Cause</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.LinkedCauseImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getLinkedCause()
		 * @generated
		 */
    EClass LINKED_CAUSE = eINSTANCE.getLinkedCause();

    /**
		 * The meta object literal for the '<em><b>Cause Traffic Incident Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LINKED_CAUSE__CAUSE_TRAFFIC_INCIDENT_ID = eINSTANCE.getLinkedCause_CauseTrafficIncidentId();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.DirectCauseImpl <em>Direct Cause</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.DirectCauseImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getDirectCause()
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
		 * The meta object literal for the '<em><b>Lane Restrictions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DIRECT_CAUSE__LANE_RESTRICTIONS = eINSTANCE.getDirectCause_LaneRestrictions();

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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.LaneRestrictionsImpl <em>Lane Restrictions</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.LaneRestrictionsImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getLaneRestrictions()
		 * @generated
		 */
    EClass LANE_RESTRICTIONS = eINSTANCE.getLaneRestrictions();

    /**
		 * The meta object literal for the '<em><b>Lane Restriction Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LANE_RESTRICTIONS__LANE_RESTRICTION_TYPE = eINSTANCE.getLaneRestrictions_LaneRestrictionType();

    /**
		 * The meta object literal for the '<em><b>Number Of Lanes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LANE_RESTRICTIONS__NUMBER_OF_LANES = eINSTANCE.getLaneRestrictions_NumberOfLanes();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.AdviceImpl <em>Advice</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.AdviceImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getAdvice()
		 * @generated
		 */
    EClass ADVICE = eINSTANCE.getAdvice();

    /**
		 * The meta object literal for the '<em><b>Main Advice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ADVICE__MAIN_ADVICE = eINSTANCE.getAdvice_MainAdvice();

    /**
		 * The meta object literal for the '<em><b>Sub Advice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ADVICE__SUB_ADVICE = eINSTANCE.getAdvice_SubAdvice();

    /**
		 * The meta object literal for the '<em><b>Free Text</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ADVICE__FREE_TEXT = eINSTANCE.getAdvice_FreeText();

    /**
		 * The meta object literal for the '<em><b>Applicability</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ADVICE__APPLICABILITY = eINSTANCE.getAdvice_Applicability();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.ApplicabilityImpl <em>Applicability</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.ApplicabilityImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getApplicability()
		 * @generated
		 */
    EClass APPLICABILITY = eINSTANCE.getApplicability();

    /**
		 * The meta object literal for the '<em><b>Vehicle Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute APPLICABILITY__VEHICLE_TYPE = eINSTANCE.getApplicability_VehicleType();

    /**
		 * The meta object literal for the '<em><b>Vehicle Related Restrictions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference APPLICABILITY__VEHICLE_RELATED_RESTRICTIONS = eINSTANCE.getApplicability_VehicleRelatedRestrictions();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.VehicleRelatedRestrictionImpl <em>Vehicle Related Restriction</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.VehicleRelatedRestrictionImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getVehicleRelatedRestriction()
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
		 * The meta object literal for the '<em><b>Restriction Location Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference VEHICLE_RELATED_RESTRICTION__RESTRICTION_LOCATION_REFERENCE = eINSTANCE.getVehicleRelatedRestriction_RestrictionLocationReference();

				/**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitSectionImpl <em>Temporary Speed Limit Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitSectionImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getTemporarySpeedLimitSection()
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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitImpl <em>Temporary Speed Limit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.TemporarySpeedLimitImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.impl.XTrafficIncidentPackageImpl#getTemporarySpeedLimit()
		 * @generated
		 */
		EClass TEMPORARY_SPEED_LIMIT = eINSTANCE.getTemporarySpeedLimit();

				/**
		 * The meta object literal for the '<em><b>Temporary Speed Limit Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPORARY_SPEED_LIMIT__TEMPORARY_SPEED_LIMIT_SECTIONS = eINSTANCE.getTemporarySpeedLimit_TemporarySpeedLimitSections();

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
		 * The meta object literal for the '<em><b>Applicability</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPORARY_SPEED_LIMIT__APPLICABILITY = eINSTANCE.getTemporarySpeedLimit_Applicability();

  }

} //XTrafficIncidentPackage
