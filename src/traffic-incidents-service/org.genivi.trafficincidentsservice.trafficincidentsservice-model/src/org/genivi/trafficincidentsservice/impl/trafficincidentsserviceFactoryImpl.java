/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.genivi.trafficincidentsservice.*;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.FeedInformation;
import org.genivi.trafficincidentsservice.LengthUnit;
import org.genivi.trafficincidentsservice.SpeedUnit;
import org.genivi.trafficincidentsservice.TextDetailLevel;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentField;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentFeed;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedListener;
import org.genivi.trafficincidentsservice.WeightUnit;
import org.genivi.trafficincidentsservice.trafficincidentsserviceFactory;
import org.genivi.trafficincidentsservice.trafficincidentsservicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class trafficincidentsserviceFactoryImpl extends EFactoryImpl implements trafficincidentsserviceFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static trafficincidentsserviceFactory init() {
		try {
			trafficincidentsserviceFactory thetrafficincidentsserviceFactory = (trafficincidentsserviceFactory)EPackage.Registry.INSTANCE.getEFactory(trafficincidentsservicePackage.eNS_URI);
			if (thetrafficincidentsserviceFactory != null) {
				return thetrafficincidentsserviceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new trafficincidentsserviceFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public trafficincidentsserviceFactoryImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case trafficincidentsservicePackage.TRAFFIC_INCIDENTS: return createTrafficIncidents();
			case trafficincidentsservicePackage.TRAFFIC_INCIDENTS_LISTENER: return createTrafficIncidentsListener();
			case trafficincidentsservicePackage.TRAFFIC_INCIDENT_FEED: return createTrafficIncidentFeed();
			case trafficincidentsservicePackage.TRAFFIC_INCIDENT_FEED_LISTENER: return createTrafficIncidentFeedListener();
			case trafficincidentsservicePackage.FEED_INFORMATION: return createFeedInformation();
			case trafficincidentsservicePackage.CATEGORY_DEFINITION: return createCategoryDefinition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case trafficincidentsservicePackage.TRAFFIC_INCIDENT_FIELD:
				return createTrafficIncidentFieldFromString(eDataType, initialValue);
			case trafficincidentsservicePackage.TEXT_DETAIL_LEVEL:
				return createTextDetailLevelFromString(eDataType, initialValue);
			case trafficincidentsservicePackage.TRAFFIC_INCIDENT_FEED_STATUS:
				return createTrafficIncidentFeedStatusFromString(eDataType, initialValue);
			case trafficincidentsservicePackage.TRAFFIC_INCIDENTS_STATUS:
				return createTrafficIncidentsStatusFromString(eDataType, initialValue);
			case trafficincidentsservicePackage.SPEED_UNIT:
				return createSpeedUnitFromString(eDataType, initialValue);
			case trafficincidentsservicePackage.LENGTH_UNIT:
				return createLengthUnitFromString(eDataType, initialValue);
			case trafficincidentsservicePackage.WEIGHT_UNIT:
				return createWeightUnitFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case trafficincidentsservicePackage.TRAFFIC_INCIDENT_FIELD:
				return convertTrafficIncidentFieldToString(eDataType, instanceValue);
			case trafficincidentsservicePackage.TEXT_DETAIL_LEVEL:
				return convertTextDetailLevelToString(eDataType, instanceValue);
			case trafficincidentsservicePackage.TRAFFIC_INCIDENT_FEED_STATUS:
				return convertTrafficIncidentFeedStatusToString(eDataType, instanceValue);
			case trafficincidentsservicePackage.TRAFFIC_INCIDENTS_STATUS:
				return convertTrafficIncidentsStatusToString(eDataType, instanceValue);
			case trafficincidentsservicePackage.SPEED_UNIT:
				return convertSpeedUnitToString(eDataType, instanceValue);
			case trafficincidentsservicePackage.LENGTH_UNIT:
				return convertLengthUnitToString(eDataType, instanceValue);
			case trafficincidentsservicePackage.WEIGHT_UNIT:
				return convertWeightUnitToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficIncidents createTrafficIncidents() {
		TrafficIncidentsImpl trafficIncidents = new TrafficIncidentsImpl();
		return trafficIncidents;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficIncidentsListener createTrafficIncidentsListener() {
		TrafficIncidentsListenerImpl trafficIncidentsListener = new TrafficIncidentsListenerImpl();
		return trafficIncidentsListener;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficIncidentFeed createTrafficIncidentFeed() {
		TrafficIncidentFeedImpl trafficIncidentFeed = new TrafficIncidentFeedImpl();
		return trafficIncidentFeed;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficIncidentFeedListener createTrafficIncidentFeedListener() {
		TrafficIncidentFeedListenerImpl trafficIncidentFeedListener = new TrafficIncidentFeedListenerImpl();
		return trafficIncidentFeedListener;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FeedInformation createFeedInformation() {
		FeedInformationImpl feedInformation = new FeedInformationImpl();
		return feedInformation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CategoryDefinition createCategoryDefinition() {
		CategoryDefinitionImpl categoryDefinition = new CategoryDefinitionImpl();
		return categoryDefinition;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficIncidentField createTrafficIncidentFieldFromString(EDataType eDataType, String initialValue) {
		TrafficIncidentField result = TrafficIncidentField.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertTrafficIncidentFieldToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TextDetailLevel createTextDetailLevelFromString(EDataType eDataType, String initialValue) {
		TextDetailLevel result = TextDetailLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertTextDetailLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficIncidentFeedStatus createTrafficIncidentFeedStatusFromString(EDataType eDataType, String initialValue) {
		TrafficIncidentFeedStatus result = TrafficIncidentFeedStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertTrafficIncidentFeedStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrafficIncidentsStatus createTrafficIncidentsStatusFromString(EDataType eDataType, String initialValue) {
		TrafficIncidentsStatus result = TrafficIncidentsStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertTrafficIncidentsStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SpeedUnit createSpeedUnitFromString(EDataType eDataType, String initialValue) {
		SpeedUnit result = SpeedUnit.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertSpeedUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LengthUnit createLengthUnitFromString(EDataType eDataType, String initialValue) {
		LengthUnit result = LengthUnit.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertLengthUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public WeightUnit createWeightUnitFromString(EDataType eDataType, String initialValue) {
		WeightUnit result = WeightUnit.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertWeightUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public trafficincidentsservicePackage gettrafficincidentsservicePackage() {
		return (trafficincidentsservicePackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static trafficincidentsservicePackage getPackage() {
		return trafficincidentsservicePackage.eINSTANCE;
	}

} //trafficincidentsserviceFactoryImpl
