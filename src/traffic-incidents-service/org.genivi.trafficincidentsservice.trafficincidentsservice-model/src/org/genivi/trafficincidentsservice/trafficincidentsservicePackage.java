/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

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
 * @see org.genivi.trafficincidentsservice.trafficincidentsserviceFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface trafficincidentsservicePackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "trafficincidentsservice";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://org.genivi.trafficinfo.trafficincidentsservice";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "trafficincidentsservice";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  trafficincidentsservicePackage eINSTANCE = org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl.init();

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.impl.TrafficIncidentsImpl <em>Traffic Incidents</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.impl.TrafficIncidentsImpl
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidents()
	 * @generated
	 */
  int TRAFFIC_INCIDENTS = 0;

  /**
	 * The number of structural features of the '<em>Traffic Incidents</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENTS_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.impl.TrafficIncidentsListenerImpl <em>Traffic Incidents Listener</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.impl.TrafficIncidentsListenerImpl
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentsListener()
	 * @generated
	 */
  int TRAFFIC_INCIDENTS_LISTENER = 1;

  /**
	 * The number of structural features of the '<em>Traffic Incidents Listener</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENTS_LISTENER_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.impl.TrafficIncidentFeedImpl <em>Traffic Incident Feed</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.impl.TrafficIncidentFeedImpl
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentFeed()
	 * @generated
	 */
  int TRAFFIC_INCIDENT_FEED = 2;

  /**
	 * The number of structural features of the '<em>Traffic Incident Feed</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT_FEED_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.impl.TrafficIncidentFeedListenerImpl <em>Traffic Incident Feed Listener</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.impl.TrafficIncidentFeedListenerImpl
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentFeedListener()
	 * @generated
	 */
  int TRAFFIC_INCIDENT_FEED_LISTENER = 3;

  /**
	 * The number of structural features of the '<em>Traffic Incident Feed Listener</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TRAFFIC_INCIDENT_FEED_LISTENER_FEATURE_COUNT = 0;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.impl.FeedInformationImpl <em>Feed Information</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.impl.FeedInformationImpl
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getFeedInformation()
	 * @generated
	 */
  int FEED_INFORMATION = 4;

  /**
	 * The feature id for the '<em><b>Data Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEED_INFORMATION__DATA_PROVIDER_NAME = 0;

  /**
	 * The feature id for the '<em><b>Protocol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEED_INFORMATION__PROTOCOL_NAME = 1;

  /**
	 * The feature id for the '<em><b>Communication Channel Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEED_INFORMATION__COMMUNICATION_CHANNEL_NAME = 2;

  /**
	 * The feature id for the '<em><b>Feed Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEED_INFORMATION__FEED_STATUS = 3;

  /**
	 * The feature id for the '<em><b>Traffic Incidents Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEED_INFORMATION__TRAFFIC_INCIDENTS_STATUS = 4;

  /**
	 * The number of structural features of the '<em>Feed Information</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int FEED_INFORMATION_FEATURE_COUNT = 5;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.impl.CategoryDefinitionImpl <em>Category Definition</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.impl.CategoryDefinitionImpl
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getCategoryDefinition()
	 * @generated
	 */
  int CATEGORY_DEFINITION = 5;

  /**
	 * The feature id for the '<em><b>Localized Names</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CATEGORY_DEFINITION__LOCALIZED_NAMES = 0;

  /**
	 * The feature id for the '<em><b>Category Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CATEGORY_DEFINITION__CATEGORY_ID = 1;

  /**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CATEGORY_DEFINITION__ICONS = 2;

  /**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CATEGORY_DEFINITION__EXPRESSION = 3;

  /**
	 * The number of structural features of the '<em>Category Definition</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CATEGORY_DEFINITION_FEATURE_COUNT = 4;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.TrafficIncidentField <em>Traffic Incident Field</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentField
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentField()
	 * @generated
	 */
  int TRAFFIC_INCIDENT_FIELD = 6;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.TextDetailLevel <em>Text Detail Level</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.TextDetailLevel
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTextDetailLevel()
	 * @generated
	 */
  int TEXT_DETAIL_LEVEL = 7;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus <em>Traffic Incident Feed Status</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentFeedStatus()
	 * @generated
	 */
  int TRAFFIC_INCIDENT_FEED_STATUS = 8;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.TrafficIncidentsStatus <em>Traffic Incidents Status</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentsStatus
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentsStatus()
	 * @generated
	 */
  int TRAFFIC_INCIDENTS_STATUS = 9;


  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.SpeedUnit <em>Speed Unit</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.SpeedUnit
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getSpeedUnit()
	 * @generated
	 */
  int SPEED_UNIT = 10;


  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.LengthUnit <em>Length Unit</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.LengthUnit
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getLengthUnit()
	 * @generated
	 */
  int LENGTH_UNIT = 11;

  /**
	 * The meta object id for the '{@link org.genivi.trafficincidentsservice.WeightUnit <em>Weight Unit</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.genivi.trafficincidentsservice.WeightUnit
	 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getWeightUnit()
	 * @generated
	 */
  int WEIGHT_UNIT = 12;


  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.TrafficIncidents <em>Traffic Incidents</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traffic Incidents</em>'.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidents
	 * @generated
	 */
  EClass getTrafficIncidents();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.TrafficIncidentsListener <em>Traffic Incidents Listener</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traffic Incidents Listener</em>'.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentsListener
	 * @generated
	 */
  EClass getTrafficIncidentsListener();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.TrafficIncidentFeed <em>Traffic Incident Feed</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traffic Incident Feed</em>'.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentFeed
	 * @generated
	 */
  EClass getTrafficIncidentFeed();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.TrafficIncidentFeedListener <em>Traffic Incident Feed Listener</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traffic Incident Feed Listener</em>'.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentFeedListener
	 * @generated
	 */
  EClass getTrafficIncidentFeedListener();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.FeedInformation <em>Feed Information</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feed Information</em>'.
	 * @see org.genivi.trafficincidentsservice.FeedInformation
	 * @generated
	 */
  EClass getFeedInformation();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.FeedInformation#getDataProviderName <em>Data Provider Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Provider Name</em>'.
	 * @see org.genivi.trafficincidentsservice.FeedInformation#getDataProviderName()
	 * @see #getFeedInformation()
	 * @generated
	 */
  EAttribute getFeedInformation_DataProviderName();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.FeedInformation#getProtocolName <em>Protocol Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protocol Name</em>'.
	 * @see org.genivi.trafficincidentsservice.FeedInformation#getProtocolName()
	 * @see #getFeedInformation()
	 * @generated
	 */
  EAttribute getFeedInformation_ProtocolName();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.FeedInformation#getCommunicationChannelName <em>Communication Channel Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Communication Channel Name</em>'.
	 * @see org.genivi.trafficincidentsservice.FeedInformation#getCommunicationChannelName()
	 * @see #getFeedInformation()
	 * @generated
	 */
  EAttribute getFeedInformation_CommunicationChannelName();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.FeedInformation#getFeedStatus <em>Feed Status</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feed Status</em>'.
	 * @see org.genivi.trafficincidentsservice.FeedInformation#getFeedStatus()
	 * @see #getFeedInformation()
	 * @generated
	 */
  EAttribute getFeedInformation_FeedStatus();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.FeedInformation#getTrafficIncidentsStatus <em>Traffic Incidents Status</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traffic Incidents Status</em>'.
	 * @see org.genivi.trafficincidentsservice.FeedInformation#getTrafficIncidentsStatus()
	 * @see #getFeedInformation()
	 * @generated
	 */
  EAttribute getFeedInformation_TrafficIncidentsStatus();

  /**
	 * Returns the meta object for class '{@link org.genivi.trafficincidentsservice.CategoryDefinition <em>Category Definition</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category Definition</em>'.
	 * @see org.genivi.trafficincidentsservice.CategoryDefinition
	 * @generated
	 */
  EClass getCategoryDefinition();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.CategoryDefinition#getLocalizedNamesList <em>Localized Names</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Localized Names</em>'.
	 * @see org.genivi.trafficincidentsservice.CategoryDefinition#getLocalizedNamesList()
	 * @see #getCategoryDefinition()
	 * @generated
	 */
  EReference getCategoryDefinition_LocalizedNames();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.CategoryDefinition#getCategoryId <em>Category Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category Id</em>'.
	 * @see org.genivi.trafficincidentsservice.CategoryDefinition#getCategoryId()
	 * @see #getCategoryDefinition()
	 * @generated
	 */
  EAttribute getCategoryDefinition_CategoryId();

  /**
	 * Returns the meta object for the containment reference list '{@link org.genivi.trafficincidentsservice.CategoryDefinition#getIconsList <em>Icons</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icons</em>'.
	 * @see org.genivi.trafficincidentsservice.CategoryDefinition#getIconsList()
	 * @see #getCategoryDefinition()
	 * @generated
	 */
  EReference getCategoryDefinition_Icons();

  /**
	 * Returns the meta object for the attribute '{@link org.genivi.trafficincidentsservice.CategoryDefinition#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.genivi.trafficincidentsservice.CategoryDefinition#getExpression()
	 * @see #getCategoryDefinition()
	 * @generated
	 */
  EAttribute getCategoryDefinition_Expression();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.TrafficIncidentField <em>Traffic Incident Field</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Traffic Incident Field</em>'.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentField
	 * @generated
	 */
  EEnum getTrafficIncidentField();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.TextDetailLevel <em>Text Detail Level</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Text Detail Level</em>'.
	 * @see org.genivi.trafficincidentsservice.TextDetailLevel
	 * @generated
	 */
  EEnum getTextDetailLevel();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus <em>Traffic Incident Feed Status</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Traffic Incident Feed Status</em>'.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus
	 * @generated
	 */
  EEnum getTrafficIncidentFeedStatus();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.TrafficIncidentsStatus <em>Traffic Incidents Status</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Traffic Incidents Status</em>'.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentsStatus
	 * @generated
	 */
  EEnum getTrafficIncidentsStatus();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.SpeedUnit <em>Speed Unit</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Speed Unit</em>'.
	 * @see org.genivi.trafficincidentsservice.SpeedUnit
	 * @generated
	 */
  EEnum getSpeedUnit();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.LengthUnit <em>Length Unit</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Length Unit</em>'.
	 * @see org.genivi.trafficincidentsservice.LengthUnit
	 * @generated
	 */
  EEnum getLengthUnit();

  /**
	 * Returns the meta object for enum '{@link org.genivi.trafficincidentsservice.WeightUnit <em>Weight Unit</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Weight Unit</em>'.
	 * @see org.genivi.trafficincidentsservice.WeightUnit
	 * @generated
	 */
  EEnum getWeightUnit();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  trafficincidentsserviceFactory gettrafficincidentsserviceFactory();

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
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.impl.TrafficIncidentsImpl <em>Traffic Incidents</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.impl.TrafficIncidentsImpl
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidents()
		 * @generated
		 */
    EClass TRAFFIC_INCIDENTS = eINSTANCE.getTrafficIncidents();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.impl.TrafficIncidentsListenerImpl <em>Traffic Incidents Listener</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.impl.TrafficIncidentsListenerImpl
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentsListener()
		 * @generated
		 */
    EClass TRAFFIC_INCIDENTS_LISTENER = eINSTANCE.getTrafficIncidentsListener();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.impl.TrafficIncidentFeedImpl <em>Traffic Incident Feed</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.impl.TrafficIncidentFeedImpl
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentFeed()
		 * @generated
		 */
    EClass TRAFFIC_INCIDENT_FEED = eINSTANCE.getTrafficIncidentFeed();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.impl.TrafficIncidentFeedListenerImpl <em>Traffic Incident Feed Listener</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.impl.TrafficIncidentFeedListenerImpl
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentFeedListener()
		 * @generated
		 */
    EClass TRAFFIC_INCIDENT_FEED_LISTENER = eINSTANCE.getTrafficIncidentFeedListener();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.impl.FeedInformationImpl <em>Feed Information</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.impl.FeedInformationImpl
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getFeedInformation()
		 * @generated
		 */
    EClass FEED_INFORMATION = eINSTANCE.getFeedInformation();

    /**
		 * The meta object literal for the '<em><b>Data Provider Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute FEED_INFORMATION__DATA_PROVIDER_NAME = eINSTANCE.getFeedInformation_DataProviderName();

    /**
		 * The meta object literal for the '<em><b>Protocol Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute FEED_INFORMATION__PROTOCOL_NAME = eINSTANCE.getFeedInformation_ProtocolName();

    /**
		 * The meta object literal for the '<em><b>Communication Channel Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute FEED_INFORMATION__COMMUNICATION_CHANNEL_NAME = eINSTANCE.getFeedInformation_CommunicationChannelName();

    /**
		 * The meta object literal for the '<em><b>Feed Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute FEED_INFORMATION__FEED_STATUS = eINSTANCE.getFeedInformation_FeedStatus();

    /**
		 * The meta object literal for the '<em><b>Traffic Incidents Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute FEED_INFORMATION__TRAFFIC_INCIDENTS_STATUS = eINSTANCE.getFeedInformation_TrafficIncidentsStatus();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.impl.CategoryDefinitionImpl <em>Category Definition</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.impl.CategoryDefinitionImpl
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getCategoryDefinition()
		 * @generated
		 */
    EClass CATEGORY_DEFINITION = eINSTANCE.getCategoryDefinition();

    /**
		 * The meta object literal for the '<em><b>Localized Names</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CATEGORY_DEFINITION__LOCALIZED_NAMES = eINSTANCE.getCategoryDefinition_LocalizedNames();

    /**
		 * The meta object literal for the '<em><b>Category Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CATEGORY_DEFINITION__CATEGORY_ID = eINSTANCE.getCategoryDefinition_CategoryId();

    /**
		 * The meta object literal for the '<em><b>Icons</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CATEGORY_DEFINITION__ICONS = eINSTANCE.getCategoryDefinition_Icons();

    /**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CATEGORY_DEFINITION__EXPRESSION = eINSTANCE.getCategoryDefinition_Expression();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.TrafficIncidentField <em>Traffic Incident Field</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.TrafficIncidentField
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentField()
		 * @generated
		 */
    EEnum TRAFFIC_INCIDENT_FIELD = eINSTANCE.getTrafficIncidentField();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.TextDetailLevel <em>Text Detail Level</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.TextDetailLevel
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTextDetailLevel()
		 * @generated
		 */
    EEnum TEXT_DETAIL_LEVEL = eINSTANCE.getTextDetailLevel();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus <em>Traffic Incident Feed Status</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentFeedStatus()
		 * @generated
		 */
    EEnum TRAFFIC_INCIDENT_FEED_STATUS = eINSTANCE.getTrafficIncidentFeedStatus();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.TrafficIncidentsStatus <em>Traffic Incidents Status</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.TrafficIncidentsStatus
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getTrafficIncidentsStatus()
		 * @generated
		 */
    EEnum TRAFFIC_INCIDENTS_STATUS = eINSTANCE.getTrafficIncidentsStatus();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.SpeedUnit <em>Speed Unit</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.SpeedUnit
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getSpeedUnit()
		 * @generated
		 */
    EEnum SPEED_UNIT = eINSTANCE.getSpeedUnit();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.LengthUnit <em>Length Unit</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.LengthUnit
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getLengthUnit()
		 * @generated
		 */
    EEnum LENGTH_UNIT = eINSTANCE.getLengthUnit();

    /**
		 * The meta object literal for the '{@link org.genivi.trafficincidentsservice.WeightUnit <em>Weight Unit</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.genivi.trafficincidentsservice.WeightUnit
		 * @see org.genivi.trafficincidentsservice.impl.trafficincidentsservicePackageImpl#getWeightUnit()
		 * @generated
		 */
    EEnum WEIGHT_UNIT = eINSTANCE.getWeightUnit();

  }

} //trafficincidentsservicePackage
