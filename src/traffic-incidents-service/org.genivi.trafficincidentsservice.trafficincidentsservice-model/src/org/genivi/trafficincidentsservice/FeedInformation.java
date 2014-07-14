/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feed Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This data type provides information about a Traffic Incident Feed.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.FeedInformation#getDataProviderName <em>Data Provider Name</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.FeedInformation#getProtocolName <em>Protocol Name</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.FeedInformation#getCommunicationChannelName <em>Communication Channel Name</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.FeedInformation#getFeedStatus <em>Feed Status</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.FeedInformation#getTrafficIncidentsStatus <em>Traffic Incidents Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getFeedInformation()
 * @model
 * @generated
 */
public interface FeedInformation extends EObject {
  /**
	 * Returns the value of the '<em><b>Data Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Provider Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the data provider.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data Provider Name</em>' attribute.
	 * @see #isSetDataProviderName()
	 * @see #unsetDataProviderName()
	 * @see #setDataProviderName(String)
	 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getFeedInformation_DataProviderName()
	 * @model unsettable="true"
	 * @generated
	 */
  String getDataProviderName();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getDataProviderName <em>Data Provider Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Provider Name</em>' attribute.
	 * @see #isSetDataProviderName()
	 * @see #unsetDataProviderName()
	 * @see #getDataProviderName()
	 * @generated
	 */
  void setDataProviderName(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getDataProviderName <em>Data Provider Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetDataProviderName()
	 * @see #getDataProviderName()
	 * @see #setDataProviderName(String)
	 * @generated
	 */
  void unsetDataProviderName();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getDataProviderName <em>Data Provider Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Data Provider Name</em>' attribute is set.
	 * @see #unsetDataProviderName()
	 * @see #getDataProviderName()
	 * @see #setDataProviderName(String)
	 * @generated
	 */
  boolean isSetDataProviderName();

  /**
	 * Returns the value of the '<em><b>Protocol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Protocol Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the protocol via which the Traffic Incidents are received.
	 * There are no predefined values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protocol Name</em>' attribute.
	 * @see #isSetProtocolName()
	 * @see #unsetProtocolName()
	 * @see #setProtocolName(String)
	 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getFeedInformation_ProtocolName()
	 * @model unsettable="true"
	 * @generated
	 */
  String getProtocolName();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getProtocolName <em>Protocol Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol Name</em>' attribute.
	 * @see #isSetProtocolName()
	 * @see #unsetProtocolName()
	 * @see #getProtocolName()
	 * @generated
	 */
  void setProtocolName(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getProtocolName <em>Protocol Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetProtocolName()
	 * @see #getProtocolName()
	 * @see #setProtocolName(String)
	 * @generated
	 */
  void unsetProtocolName();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getProtocolName <em>Protocol Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Protocol Name</em>' attribute is set.
	 * @see #unsetProtocolName()
	 * @see #getProtocolName()
	 * @see #setProtocolName(String)
	 * @generated
	 */
  boolean isSetProtocolName();

  /**
	 * Returns the value of the '<em><b>Communication Channel Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Communication Channel Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the communication channel.
	 * There are no predefined values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Communication Channel Name</em>' attribute.
	 * @see #isSetCommunicationChannelName()
	 * @see #unsetCommunicationChannelName()
	 * @see #setCommunicationChannelName(String)
	 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getFeedInformation_CommunicationChannelName()
	 * @model unsettable="true"
	 * @generated
	 */
  String getCommunicationChannelName();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getCommunicationChannelName <em>Communication Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Communication Channel Name</em>' attribute.
	 * @see #isSetCommunicationChannelName()
	 * @see #unsetCommunicationChannelName()
	 * @see #getCommunicationChannelName()
	 * @generated
	 */
  void setCommunicationChannelName(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getCommunicationChannelName <em>Communication Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetCommunicationChannelName()
	 * @see #getCommunicationChannelName()
	 * @see #setCommunicationChannelName(String)
	 * @generated
	 */
  void unsetCommunicationChannelName();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getCommunicationChannelName <em>Communication Channel Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Communication Channel Name</em>' attribute is set.
	 * @see #unsetCommunicationChannelName()
	 * @see #getCommunicationChannelName()
	 * @see #setCommunicationChannelName(String)
	 * @generated
	 */
  boolean isSetCommunicationChannelName();

  /**
	 * Returns the value of the '<em><b>Feed Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feed Status</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The status of the Feed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feed Status</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus
	 * @see #isSetFeedStatus()
	 * @see #unsetFeedStatus()
	 * @see #setFeedStatus(TrafficIncidentFeedStatus)
	 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getFeedInformation_FeedStatus()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  TrafficIncidentFeedStatus getFeedStatus();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getFeedStatus <em>Feed Status</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feed Status</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus
	 * @see #isSetFeedStatus()
	 * @see #unsetFeedStatus()
	 * @see #getFeedStatus()
	 * @generated
	 */
  void setFeedStatus(TrafficIncidentFeedStatus value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getFeedStatus <em>Feed Status</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetFeedStatus()
	 * @see #getFeedStatus()
	 * @see #setFeedStatus(TrafficIncidentFeedStatus)
	 * @generated
	 */
  void unsetFeedStatus();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getFeedStatus <em>Feed Status</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Feed Status</em>' attribute is set.
	 * @see #unsetFeedStatus()
	 * @see #getFeedStatus()
	 * @see #setFeedStatus(TrafficIncidentFeedStatus)
	 * @generated
	 */
  boolean isSetFeedStatus();

  /**
	 * Returns the value of the '<em><b>Traffic Incidents Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.trafficincidentsservice.TrafficIncidentsStatus}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The status of the Traffic Incidents delivered by this Feed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Traffic Incidents Status</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentsStatus
	 * @see #isSetTrafficIncidentsStatus()
	 * @see #unsetTrafficIncidentsStatus()
	 * @see #setTrafficIncidentsStatus(TrafficIncidentsStatus)
	 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#getFeedInformation_TrafficIncidentsStatus()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  TrafficIncidentsStatus getTrafficIncidentsStatus();

  /**
	 * Sets the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getTrafficIncidentsStatus <em>Traffic Incidents Status</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traffic Incidents Status</em>' attribute.
	 * @see org.genivi.trafficincidentsservice.TrafficIncidentsStatus
	 * @see #isSetTrafficIncidentsStatus()
	 * @see #unsetTrafficIncidentsStatus()
	 * @see #getTrafficIncidentsStatus()
	 * @generated
	 */
  void setTrafficIncidentsStatus(TrafficIncidentsStatus value);

  /**
	 * Unsets the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getTrafficIncidentsStatus <em>Traffic Incidents Status</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetTrafficIncidentsStatus()
	 * @see #getTrafficIncidentsStatus()
	 * @see #setTrafficIncidentsStatus(TrafficIncidentsStatus)
	 * @generated
	 */
  void unsetTrafficIncidentsStatus();

  /**
	 * Returns whether the value of the '{@link org.genivi.trafficincidentsservice.FeedInformation#getTrafficIncidentsStatus <em>Traffic Incidents Status</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Traffic Incidents Status</em>' attribute is set.
	 * @see #unsetTrafficIncidentsStatus()
	 * @see #getTrafficIncidentsStatus()
	 * @see #setTrafficIncidentsStatus(TrafficIncidentsStatus)
	 * @generated
	 */
  boolean isSetTrafficIncidentsStatus();

} // FeedInformation
