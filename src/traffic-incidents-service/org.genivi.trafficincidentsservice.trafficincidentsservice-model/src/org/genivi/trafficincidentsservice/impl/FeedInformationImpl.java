/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.trafficincidentsservice.FeedInformation;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.trafficincidentsservicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feed Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficincidentsservice.impl.FeedInformationImpl#getDataProviderName <em>Data Provider Name</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.impl.FeedInformationImpl#getProtocolName <em>Protocol Name</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.impl.FeedInformationImpl#getCommunicationChannelName <em>Communication Channel Name</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.impl.FeedInformationImpl#getFeedStatus <em>Feed Status</em>}</li>
 *   <li>{@link org.genivi.trafficincidentsservice.impl.FeedInformationImpl#getTrafficIncidentsStatus <em>Traffic Incidents Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeedInformationImpl extends EObjectImpl implements FeedInformation {
  /**
	 * The default value of the '{@link #getDataProviderName() <em>Data Provider Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDataProviderName()
	 * @generated
	 * @ordered
	 */
  protected static final String DATA_PROVIDER_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getDataProviderName() <em>Data Provider Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDataProviderName()
	 * @generated
	 * @ordered
	 */
  protected String dataProviderName = DATA_PROVIDER_NAME_EDEFAULT;

  /**
	 * This is true if the Data Provider Name attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean dataProviderNameESet;

  /**
	 * The default value of the '{@link #getProtocolName() <em>Protocol Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getProtocolName()
	 * @generated
	 * @ordered
	 */
  protected static final String PROTOCOL_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getProtocolName() <em>Protocol Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getProtocolName()
	 * @generated
	 * @ordered
	 */
  protected String protocolName = PROTOCOL_NAME_EDEFAULT;

  /**
	 * This is true if the Protocol Name attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean protocolNameESet;

  /**
	 * The default value of the '{@link #getCommunicationChannelName() <em>Communication Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCommunicationChannelName()
	 * @generated
	 * @ordered
	 */
  protected static final String COMMUNICATION_CHANNEL_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getCommunicationChannelName() <em>Communication Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCommunicationChannelName()
	 * @generated
	 * @ordered
	 */
  protected String communicationChannelName = COMMUNICATION_CHANNEL_NAME_EDEFAULT;

  /**
	 * This is true if the Communication Channel Name attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean communicationChannelNameESet;

  /**
	 * The default value of the '{@link #getFeedStatus() <em>Feed Status</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFeedStatus()
	 * @generated
	 * @ordered
	 */
  protected static final TrafficIncidentFeedStatus FEED_STATUS_EDEFAULT = TrafficIncidentFeedStatus.UNAVAILABLE;

  /**
	 * The cached value of the '{@link #getFeedStatus() <em>Feed Status</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFeedStatus()
	 * @generated
	 * @ordered
	 */
  protected TrafficIncidentFeedStatus feedStatus = FEED_STATUS_EDEFAULT;

  /**
	 * This is true if the Feed Status attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean feedStatusESet;

  /**
	 * The default value of the '{@link #getTrafficIncidentsStatus() <em>Traffic Incidents Status</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTrafficIncidentsStatus()
	 * @generated
	 * @ordered
	 */
  protected static final TrafficIncidentsStatus TRAFFIC_INCIDENTS_STATUS_EDEFAULT = TrafficIncidentsStatus.UNAVAILABLE;

  /**
	 * The cached value of the '{@link #getTrafficIncidentsStatus() <em>Traffic Incidents Status</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTrafficIncidentsStatus()
	 * @generated
	 * @ordered
	 */
  protected TrafficIncidentsStatus trafficIncidentsStatus = TRAFFIC_INCIDENTS_STATUS_EDEFAULT;

  /**
	 * This is true if the Traffic Incidents Status attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean trafficIncidentsStatusESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected FeedInformationImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return trafficincidentsservicePackage.Literals.FEED_INFORMATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getDataProviderName() {
		return dataProviderName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDataProviderName(String newDataProviderName) {
		String oldDataProviderName = dataProviderName;
		dataProviderName = newDataProviderName;
		boolean oldDataProviderNameESet = dataProviderNameESet;
		dataProviderNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentsservicePackage.FEED_INFORMATION__DATA_PROVIDER_NAME, oldDataProviderName, dataProviderName, !oldDataProviderNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetDataProviderName() {
		String oldDataProviderName = dataProviderName;
		boolean oldDataProviderNameESet = dataProviderNameESet;
		dataProviderName = DATA_PROVIDER_NAME_EDEFAULT;
		dataProviderNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentsservicePackage.FEED_INFORMATION__DATA_PROVIDER_NAME, oldDataProviderName, DATA_PROVIDER_NAME_EDEFAULT, oldDataProviderNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetDataProviderName() {
		return dataProviderNameESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getProtocolName() {
		return protocolName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setProtocolName(String newProtocolName) {
		String oldProtocolName = protocolName;
		protocolName = newProtocolName;
		boolean oldProtocolNameESet = protocolNameESet;
		protocolNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentsservicePackage.FEED_INFORMATION__PROTOCOL_NAME, oldProtocolName, protocolName, !oldProtocolNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetProtocolName() {
		String oldProtocolName = protocolName;
		boolean oldProtocolNameESet = protocolNameESet;
		protocolName = PROTOCOL_NAME_EDEFAULT;
		protocolNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentsservicePackage.FEED_INFORMATION__PROTOCOL_NAME, oldProtocolName, PROTOCOL_NAME_EDEFAULT, oldProtocolNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetProtocolName() {
		return protocolNameESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getCommunicationChannelName() {
		return communicationChannelName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCommunicationChannelName(String newCommunicationChannelName) {
		String oldCommunicationChannelName = communicationChannelName;
		communicationChannelName = newCommunicationChannelName;
		boolean oldCommunicationChannelNameESet = communicationChannelNameESet;
		communicationChannelNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentsservicePackage.FEED_INFORMATION__COMMUNICATION_CHANNEL_NAME, oldCommunicationChannelName, communicationChannelName, !oldCommunicationChannelNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetCommunicationChannelName() {
		String oldCommunicationChannelName = communicationChannelName;
		boolean oldCommunicationChannelNameESet = communicationChannelNameESet;
		communicationChannelName = COMMUNICATION_CHANNEL_NAME_EDEFAULT;
		communicationChannelNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentsservicePackage.FEED_INFORMATION__COMMUNICATION_CHANNEL_NAME, oldCommunicationChannelName, COMMUNICATION_CHANNEL_NAME_EDEFAULT, oldCommunicationChannelNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetCommunicationChannelName() {
		return communicationChannelNameESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficIncidentFeedStatus getFeedStatus() {
		return feedStatus;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFeedStatus(TrafficIncidentFeedStatus newFeedStatus) {
		TrafficIncidentFeedStatus oldFeedStatus = feedStatus;
		feedStatus = newFeedStatus == null ? FEED_STATUS_EDEFAULT : newFeedStatus;
		boolean oldFeedStatusESet = feedStatusESet;
		feedStatusESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentsservicePackage.FEED_INFORMATION__FEED_STATUS, oldFeedStatus, feedStatus, !oldFeedStatusESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetFeedStatus() {
		TrafficIncidentFeedStatus oldFeedStatus = feedStatus;
		boolean oldFeedStatusESet = feedStatusESet;
		feedStatus = FEED_STATUS_EDEFAULT;
		feedStatusESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentsservicePackage.FEED_INFORMATION__FEED_STATUS, oldFeedStatus, FEED_STATUS_EDEFAULT, oldFeedStatusESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetFeedStatus() {
		return feedStatusESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficIncidentsStatus getTrafficIncidentsStatus() {
		return trafficIncidentsStatus;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTrafficIncidentsStatus(TrafficIncidentsStatus newTrafficIncidentsStatus) {
		TrafficIncidentsStatus oldTrafficIncidentsStatus = trafficIncidentsStatus;
		trafficIncidentsStatus = newTrafficIncidentsStatus == null ? TRAFFIC_INCIDENTS_STATUS_EDEFAULT : newTrafficIncidentsStatus;
		boolean oldTrafficIncidentsStatusESet = trafficIncidentsStatusESet;
		trafficIncidentsStatusESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trafficincidentsservicePackage.FEED_INFORMATION__TRAFFIC_INCIDENTS_STATUS, oldTrafficIncidentsStatus, trafficIncidentsStatus, !oldTrafficIncidentsStatusESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetTrafficIncidentsStatus() {
		TrafficIncidentsStatus oldTrafficIncidentsStatus = trafficIncidentsStatus;
		boolean oldTrafficIncidentsStatusESet = trafficIncidentsStatusESet;
		trafficIncidentsStatus = TRAFFIC_INCIDENTS_STATUS_EDEFAULT;
		trafficIncidentsStatusESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, trafficincidentsservicePackage.FEED_INFORMATION__TRAFFIC_INCIDENTS_STATUS, oldTrafficIncidentsStatus, TRAFFIC_INCIDENTS_STATUS_EDEFAULT, oldTrafficIncidentsStatusESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetTrafficIncidentsStatus() {
		return trafficIncidentsStatusESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trafficincidentsservicePackage.FEED_INFORMATION__DATA_PROVIDER_NAME:
				return getDataProviderName();
			case trafficincidentsservicePackage.FEED_INFORMATION__PROTOCOL_NAME:
				return getProtocolName();
			case trafficincidentsservicePackage.FEED_INFORMATION__COMMUNICATION_CHANNEL_NAME:
				return getCommunicationChannelName();
			case trafficincidentsservicePackage.FEED_INFORMATION__FEED_STATUS:
				return getFeedStatus();
			case trafficincidentsservicePackage.FEED_INFORMATION__TRAFFIC_INCIDENTS_STATUS:
				return getTrafficIncidentsStatus();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case trafficincidentsservicePackage.FEED_INFORMATION__DATA_PROVIDER_NAME:
				setDataProviderName((String)newValue);
				return;
			case trafficincidentsservicePackage.FEED_INFORMATION__PROTOCOL_NAME:
				setProtocolName((String)newValue);
				return;
			case trafficincidentsservicePackage.FEED_INFORMATION__COMMUNICATION_CHANNEL_NAME:
				setCommunicationChannelName((String)newValue);
				return;
			case trafficincidentsservicePackage.FEED_INFORMATION__FEED_STATUS:
				setFeedStatus((TrafficIncidentFeedStatus)newValue);
				return;
			case trafficincidentsservicePackage.FEED_INFORMATION__TRAFFIC_INCIDENTS_STATUS:
				setTrafficIncidentsStatus((TrafficIncidentsStatus)newValue);
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
			case trafficincidentsservicePackage.FEED_INFORMATION__DATA_PROVIDER_NAME:
				unsetDataProviderName();
				return;
			case trafficincidentsservicePackage.FEED_INFORMATION__PROTOCOL_NAME:
				unsetProtocolName();
				return;
			case trafficincidentsservicePackage.FEED_INFORMATION__COMMUNICATION_CHANNEL_NAME:
				unsetCommunicationChannelName();
				return;
			case trafficincidentsservicePackage.FEED_INFORMATION__FEED_STATUS:
				unsetFeedStatus();
				return;
			case trafficincidentsservicePackage.FEED_INFORMATION__TRAFFIC_INCIDENTS_STATUS:
				unsetTrafficIncidentsStatus();
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
			case trafficincidentsservicePackage.FEED_INFORMATION__DATA_PROVIDER_NAME:
				return isSetDataProviderName();
			case trafficincidentsservicePackage.FEED_INFORMATION__PROTOCOL_NAME:
				return isSetProtocolName();
			case trafficincidentsservicePackage.FEED_INFORMATION__COMMUNICATION_CHANNEL_NAME:
				return isSetCommunicationChannelName();
			case trafficincidentsservicePackage.FEED_INFORMATION__FEED_STATUS:
				return isSetFeedStatus();
			case trafficincidentsservicePackage.FEED_INFORMATION__TRAFFIC_INCIDENTS_STATUS:
				return isSetTrafficIncidentsStatus();
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
		result.append(" (dataProviderName: ");
		if (dataProviderNameESet) result.append(dataProviderName); else result.append("<unset>");
		result.append(", protocolName: ");
		if (protocolNameESet) result.append(protocolName); else result.append("<unset>");
		result.append(", communicationChannelName: ");
		if (communicationChannelNameESet) result.append(communicationChannelName); else result.append("<unset>");
		result.append(", feedStatus: ");
		if (feedStatusESet) result.append(feedStatus); else result.append("<unset>");
		result.append(", trafficIncidentsStatus: ");
		if (trafficIncidentsStatusESet) result.append(trafficIncidentsStatus); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //FeedInformationImpl
