/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.trafficincidents.trafficincident;

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
 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface trafficincidentPackage extends EPackage {
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
  String eNS_URI = "http://org.genivi.trafficinfo";

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
  trafficincidentPackage eINSTANCE = org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl <em>Traffic Incident</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getTrafficIncident()
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
	 * The feature id for the '<em><b>Effect Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__EFFECT_TEXT = 1;

  /**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__START_TIME = 2;

  /**
	 * The feature id for the '<em><b>Stop Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__STOP_TIME = 3;

  /**
	 * The feature id for the '<em><b>Tendency</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__TENDENCY = 4;

  /**
	 * The feature id for the '<em><b>Tendency Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__TENDENCY_TEXT = 5;

  /**
	 * The feature id for the '<em><b>Length Affected</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__LENGTH_AFFECTED = 6;

  /**
	 * The feature id for the '<em><b>Average Speed Absolute</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__AVERAGE_SPEED_ABSOLUTE = 7;

  /**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__DELAY = 8;

  /**
	 * The feature id for the '<em><b>Segment Speed Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__SEGMENT_SPEED_LIMIT = 9;

  /**
	 * The feature id for the '<em><b>Causes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__CAUSES = 10;

  /**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__LOCATION = 11;

  /**
	 * The feature id for the '<em><b>Advices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__ADVICES = 12;

  /**
	 * The feature id for the '<em><b>Applicability</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__APPLICABILITY = 13;

  /**
	 * The feature id for the '<em><b>Traffic Incident Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__TRAFFIC_INCIDENT_ID = 14;

  /**
	 * The feature id for the '<em><b>Location Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__LOCATION_INFO = 15;

  /**
	 * The feature id for the '<em><b>Cause Texts</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__CAUSE_TEXTS = 16;

  /**
	 * The feature id for the '<em><b>Applicability Texts</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__APPLICABILITY_TEXTS = 17;

  /**
	 * The feature id for the '<em><b>Advice Texts</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__ADVICE_TEXTS = 18;

  /**
	 * The feature id for the '<em><b>Category Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__CATEGORY_IDS = 19;

  /**
	 * The feature id for the '<em><b>Location Bounding Box</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX = 20;

  /**
	 * The feature id for the '<em><b>Expected Speed Absolute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE = 21;

		/**
	 * The feature id for the '<em><b>Temporary Speed Limit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT = 22;

		/**
	 * The number of structural features of the '<em>Traffic Incident</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT_FEATURE_COUNT = 23;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.CauseImpl <em>Cause</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.CauseImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getCause()
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
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LinkedCauseImpl <em>Linked Cause</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LinkedCauseImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getLinkedCause()
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
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.DirectCauseImpl <em>Direct Cause</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.DirectCauseImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getDirectCause()
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
	 * The feature id for the '<em><b>Free Text</b></em>' attribute.
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
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LaneRestrictionsImpl <em>Lane Restrictions</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LaneRestrictionsImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getLaneRestrictions()
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
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.AdviceImpl <em>Advice</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.AdviceImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getAdvice()
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
	 * The feature id for the '<em><b>Applicability</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE__APPLICABILITY = 2;

  /**
	 * The feature id for the '<em><b>Free Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE__FREE_TEXT = 3;

  /**
	 * The number of structural features of the '<em>Advice</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ADVICE_FEATURE_COUNT = 4;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.ApplicabilityImpl <em>Applicability</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.ApplicabilityImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getApplicability()
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
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.VehicleRelatedRestrictionImpl <em>Vehicle Related Restriction</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.VehicleRelatedRestrictionImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getVehicleRelatedRestriction()
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
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitImpl <em>Temporary Speed Limit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getTemporarySpeedLimit()
	 * @generated
	 */
	int TEMPORARY_SPEED_LIMIT = 8;

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
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitSectionImpl <em>Temporary Speed Limit Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitSectionImpl
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getTemporarySpeedLimitSection()
	 * @generated
	 */
	int TEMPORARY_SPEED_LIMIT_SECTION = 9;

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
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident <em>Traffic Incident</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traffic Incident</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident
	 * @generated
	 */
  EClass getTrafficIncident();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectCode <em>Effect Code</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effect Code</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectCode()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_EffectCode();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectText <em>Effect Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effect Text</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getEffectText()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_EffectText();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStartTime()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_StartTime();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStopTime <em>Stop Time</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Time</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getStopTime()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_StopTime();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendency <em>Tendency</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tendency</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendency()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_Tendency();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendencyText <em>Tendency Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tendency Text</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTendencyText()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_TendencyText();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLengthAffected <em>Length Affected</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length Affected</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLengthAffected()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_LengthAffected();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAverageSpeedAbsolute <em>Average Speed Absolute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average Speed Absolute</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAverageSpeedAbsolute()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_AverageSpeedAbsolute();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getDelay()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_Delay();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getSegmentSpeedLimit <em>Segment Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Segment Speed Limit</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getSegmentSpeedLimit()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_SegmentSpeedLimit();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCauses <em>Causes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Causes</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCauses()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EReference getTrafficIncident_Causes();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocation()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EReference getTrafficIncident_Location();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAdvices <em>Advices</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Advices</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAdvices()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EReference getTrafficIncident_Advices();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getApplicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applicability</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getApplicability()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EReference getTrafficIncident_Applicability();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTrafficIncidentId <em>Traffic Incident Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traffic Incident Id</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTrafficIncidentId()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_TrafficIncidentId();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocationInfo <em>Location Info</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location Info</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocationInfo()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EReference getTrafficIncident_LocationInfo();

  /**
	 * Returns the meta object for the attribute list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCauseTexts <em>Cause Texts</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Cause Texts</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCauseTexts()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_CauseTexts();

  /**
	 * Returns the meta object for the attribute list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getApplicabilityTexts <em>Applicability Texts</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Applicability Texts</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getApplicabilityTexts()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_ApplicabilityTexts();

  /**
	 * Returns the meta object for the attribute list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAdviceTexts <em>Advice Texts</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Advice Texts</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getAdviceTexts()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_AdviceTexts();

  /**
	 * Returns the meta object for the attribute list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCategoryIds <em>Category Ids</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Category Ids</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getCategoryIds()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EAttribute getTrafficIncident_CategoryIds();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocationBoundingBox <em>Location Bounding Box</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location Bounding Box</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getLocationBoundingBox()
	 * @see #getTrafficIncident()
	 * @generated
	 */
  EReference getTrafficIncident_LocationBoundingBox();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getExpectedSpeedAbsolute <em>Expected Speed Absolute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected Speed Absolute</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getExpectedSpeedAbsolute()
	 * @see #getTrafficIncident()
	 * @generated
	 */
	EAttribute getTrafficIncident_ExpectedSpeedAbsolute();

		/**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTemporarySpeedLimit <em>Temporary Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Temporary Speed Limit</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TrafficIncident#getTemporarySpeedLimit()
	 * @see #getTrafficIncident()
	 * @generated
	 */
	EReference getTrafficIncident_TemporarySpeedLimit();

		/**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cause</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause
	 * @generated
	 */
  EClass getCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause#getMainCause <em>Main Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main Cause</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Cause#getMainCause()
	 * @see #getCause()
	 * @generated
	 */
  EAttribute getCause_MainCause();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause <em>Linked Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linked Cause</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause
	 * @generated
	 */
  EClass getLinkedCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause#getCauseTrafficIncidentId <em>Cause Traffic Incident Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cause Traffic Incident Id</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LinkedCause#getCauseTrafficIncidentId()
	 * @see #getLinkedCause()
	 * @generated
	 */
  EAttribute getLinkedCause_CauseTrafficIncidentId();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause <em>Direct Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direct Cause</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause
	 * @generated
	 */
  EClass getDirectCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getWarningLevel <em>Warning Level</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Warning Level</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getWarningLevel()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_WarningLevel();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#isUnverifiedInformation <em>Unverified Information</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unverified Information</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#isUnverifiedInformation()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_UnverifiedInformation();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getSubCause <em>Sub Cause</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Cause</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getSubCause()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_SubCause();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getLengthAffected <em>Length Affected</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length Affected</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getLengthAffected()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_LengthAffected();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getLaneRestrictions <em>Lane Restrictions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lane Restrictions</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getLaneRestrictions()
	 * @see #getDirectCause()
	 * @generated
	 */
  EReference getDirectCause_LaneRestrictions();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getFreeText <em>Free Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Free Text</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getFreeText()
	 * @see #getDirectCause()
	 * @generated
	 */
  EAttribute getDirectCause_FreeText();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getCauseOffset <em>Cause Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cause Offset</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.DirectCause#getCauseOffset()
	 * @see #getDirectCause()
	 * @generated
	 */
	EAttribute getDirectCause_CauseOffset();

		/**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions <em>Lane Restrictions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lane Restrictions</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions
	 * @generated
	 */
  EClass getLaneRestrictions();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getLaneRestrictionType <em>Lane Restriction Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Restriction Type</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getLaneRestrictionType()
	 * @see #getLaneRestrictions()
	 * @generated
	 */
  EAttribute getLaneRestrictions_LaneRestrictionType();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getNumberOfLanes <em>Number Of Lanes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Lanes</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.LaneRestrictions#getNumberOfLanes()
	 * @see #getLaneRestrictions()
	 * @generated
	 */
  EAttribute getLaneRestrictions_NumberOfLanes();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advice</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice
	 * @generated
	 */
  EClass getAdvice();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice#getMainAdvice <em>Main Advice</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main Advice</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice#getMainAdvice()
	 * @see #getAdvice()
	 * @generated
	 */
  EAttribute getAdvice_MainAdvice();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice#getSubAdvice <em>Sub Advice</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Advice</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice#getSubAdvice()
	 * @see #getAdvice()
	 * @generated
	 */
  EAttribute getAdvice_SubAdvice();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice#getApplicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applicability</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice#getApplicability()
	 * @see #getAdvice()
	 * @generated
	 */
  EReference getAdvice_Applicability();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice#getFreeText <em>Free Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Free Text</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Advice#getFreeText()
	 * @see #getAdvice()
	 * @generated
	 */
  EAttribute getAdvice_FreeText();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Applicability</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability
	 * @generated
	 */
  EClass getApplicability();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleType <em>Vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Type</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleType()
	 * @see #getApplicability()
	 * @generated
	 */
  EAttribute getApplicability_VehicleType();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleRelatedRestrictions <em>Vehicle Related Restrictions</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicle Related Restrictions</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.Applicability#getVehicleRelatedRestrictions()
	 * @see #getApplicability()
	 * @generated
	 */
  EReference getApplicability_VehicleRelatedRestrictions();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction <em>Vehicle Related Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle Related Restriction</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction
	 * @generated
	 */
  EClass getVehicleRelatedRestriction();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction#getRestrictionType <em>Restriction Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restriction Type</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction#getRestrictionType()
	 * @see #getVehicleRelatedRestriction()
	 * @generated
	 */
  EAttribute getVehicleRelatedRestriction_RestrictionType();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction#getRestrictionValue <em>Restriction Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Restriction Value</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction#getRestrictionValue()
	 * @see #getVehicleRelatedRestriction()
	 * @generated
	 */
  EAttribute getVehicleRelatedRestriction_RestrictionValue();

  /**
	 * Returns the meta object for the containment reference '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction#getRestrictionLocation <em>Restriction Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Restriction Location</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.VehicleRelatedRestriction#getRestrictionLocation()
	 * @see #getVehicleRelatedRestriction()
	 * @generated
	 */
  EReference getVehicleRelatedRestriction_RestrictionLocation();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit <em>Temporary Speed Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporary Speed Limit</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit
	 * @generated
	 */
	EClass getTemporarySpeedLimit();

		/**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getTemporarySpeedLimitSections <em>Temporary Speed Limit Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Temporary Speed Limit Sections</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getTemporarySpeedLimitSections()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EReference getTemporarySpeedLimit_TemporarySpeedLimitSections();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#isUnitsMPH <em>Units MPH</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Units MPH</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#isUnitsMPH()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimit_UnitsMPH();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getOffset()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimit_Offset();

		/**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getApplicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applicability</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimit#getApplicability()
	 * @see #getTemporarySpeedLimit()
	 * @generated
	 */
	EReference getTemporarySpeedLimit_Applicability();

		/**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection <em>Temporary Speed Limit Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporary Speed Limit Section</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection
	 * @generated
	 */
	EClass getTemporarySpeedLimitSection();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection#getSpeedLimitValue <em>Speed Limit Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Limit Value</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection#getSpeedLimitValue()
	 * @see #getTemporarySpeedLimitSection()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimitSection_SpeedLimitValue();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection#getSpeedLimitValueWet <em>Speed Limit Value Wet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Limit Value Wet</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection#getSpeedLimitValueWet()
	 * @see #getTemporarySpeedLimitSection()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimitSection_SpeedLimitValueWet();

		/**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection#getSpeedLimitLength <em>Speed Limit Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Limit Length</em>'.
	 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.TemporarySpeedLimitSection#getSpeedLimitLength()
	 * @see #getTemporarySpeedLimitSection()
	 * @generated
	 */
	EAttribute getTemporarySpeedLimitSection_SpeedLimitLength();

		/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  trafficincidentFactory gettrafficincidentFactory();

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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl <em>Traffic Incident</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TrafficIncidentImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getTrafficIncident()
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
		 * The meta object literal for the '<em><b>Effect Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__EFFECT_TEXT = eINSTANCE.getTrafficIncident_EffectText();

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
		 * The meta object literal for the '<em><b>Tendency Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__TENDENCY_TEXT = eINSTANCE.getTrafficIncident_TendencyText();

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
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRAFFIC_INCIDENT__LOCATION = eINSTANCE.getTrafficIncident_Location();

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
		 * The meta object literal for the '<em><b>Location Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRAFFIC_INCIDENT__LOCATION_INFO = eINSTANCE.getTrafficIncident_LocationInfo();

    /**
		 * The meta object literal for the '<em><b>Cause Texts</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__CAUSE_TEXTS = eINSTANCE.getTrafficIncident_CauseTexts();

    /**
		 * The meta object literal for the '<em><b>Applicability Texts</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__APPLICABILITY_TEXTS = eINSTANCE.getTrafficIncident_ApplicabilityTexts();

    /**
		 * The meta object literal for the '<em><b>Advice Texts</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__ADVICE_TEXTS = eINSTANCE.getTrafficIncident_AdviceTexts();

    /**
		 * The meta object literal for the '<em><b>Category Ids</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TRAFFIC_INCIDENT__CATEGORY_IDS = eINSTANCE.getTrafficIncident_CategoryIds();

    /**
		 * The meta object literal for the '<em><b>Location Bounding Box</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TRAFFIC_INCIDENT__LOCATION_BOUNDING_BOX = eINSTANCE.getTrafficIncident_LocationBoundingBox();

    /**
		 * The meta object literal for the '<em><b>Expected Speed Absolute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRAFFIC_INCIDENT__EXPECTED_SPEED_ABSOLUTE = eINSTANCE.getTrafficIncident_ExpectedSpeedAbsolute();

				/**
		 * The meta object literal for the '<em><b>Temporary Speed Limit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRAFFIC_INCIDENT__TEMPORARY_SPEED_LIMIT = eINSTANCE.getTrafficIncident_TemporarySpeedLimit();

				/**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.CauseImpl <em>Cause</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.CauseImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getCause()
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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LinkedCauseImpl <em>Linked Cause</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LinkedCauseImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getLinkedCause()
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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.DirectCauseImpl <em>Direct Cause</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.DirectCauseImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getDirectCause()
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
		 * The meta object literal for the '<em><b>Free Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DIRECT_CAUSE__FREE_TEXT = eINSTANCE.getDirectCause_FreeText();

    /**
		 * The meta object literal for the '<em><b>Cause Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECT_CAUSE__CAUSE_OFFSET = eINSTANCE.getDirectCause_CauseOffset();

				/**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LaneRestrictionsImpl <em>Lane Restrictions</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.LaneRestrictionsImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getLaneRestrictions()
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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.AdviceImpl <em>Advice</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.AdviceImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getAdvice()
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
		 * The meta object literal for the '<em><b>Applicability</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ADVICE__APPLICABILITY = eINSTANCE.getAdvice_Applicability();

    /**
		 * The meta object literal for the '<em><b>Free Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ADVICE__FREE_TEXT = eINSTANCE.getAdvice_FreeText();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.ApplicabilityImpl <em>Applicability</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.ApplicabilityImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getApplicability()
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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.VehicleRelatedRestrictionImpl <em>Vehicle Related Restriction</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.VehicleRelatedRestrictionImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getVehicleRelatedRestriction()
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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitImpl <em>Temporary Speed Limit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getTemporarySpeedLimit()
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

				/**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitSectionImpl <em>Temporary Speed Limit Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.TemporarySpeedLimitSectionImpl
		 * @see org.genivi.trafficincidentsservice.trafficincidents.trafficincident.impl.trafficincidentPackageImpl#getTemporarySpeedLimitSection()
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

  }

} //trafficincidentPackage
