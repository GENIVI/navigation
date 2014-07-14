/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficincidentsservice.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.genivi.common.CommonPackage;
import org.genivi.iconset.IconsetPackage;
import org.genivi.trafficincidentsservice.CategoryDefinition;
import org.genivi.trafficincidentsservice.FeedInformation;
import org.genivi.trafficincidentsservice.LengthUnit;
import org.genivi.trafficincidentsservice.SpeedUnit;
import org.genivi.trafficincidentsservice.TextDetailLevel;
import org.genivi.trafficincidentsservice.TrafficIncidentFeed;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedListener;
import org.genivi.trafficincidentsservice.TrafficIncidentFeedStatus;
import org.genivi.trafficincidentsservice.TrafficIncidentField;
import org.genivi.trafficincidentsservice.TrafficIncidents;
import org.genivi.trafficincidentsservice.TrafficIncidentsListener;
import org.genivi.trafficincidentsservice.TrafficIncidentsStatus;
import org.genivi.trafficincidentsservice.WeightUnit;
import org.genivi.trafficincidentsservice.trafficincidentsserviceFactory;
import org.genivi.trafficincidentsservice.trafficincidentsservicePackage;
import org.genivi.trafficincidentsservice.trafficincidentfeed.trafficincident.XTrafficIncidentPackage;
import org.genivi.trafficincidentsservice.trafficincidents.trafficincident.trafficincidentPackage;
import org.genivi.trafficincidentsservice.trafficincidenttables.trafficincidenttablesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class trafficincidentsservicePackageImpl extends EPackageImpl implements trafficincidentsservicePackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass trafficIncidentsEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass trafficIncidentsListenerEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass trafficIncidentFeedEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass trafficIncidentFeedListenerEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass feedInformationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass categoryDefinitionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum trafficIncidentFieldEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum textDetailLevelEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum trafficIncidentFeedStatusEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum trafficIncidentsStatusEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum speedUnitEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum lengthUnitEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum weightUnitEEnum = null;

  /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.genivi.trafficincidentsservice.trafficincidentsservicePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private trafficincidentsservicePackageImpl() {
		super(eNS_URI, trafficincidentsserviceFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link trafficincidentsservicePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static trafficincidentsservicePackage init() {
		if (isInited) return (trafficincidentsservicePackage)EPackage.Registry.INSTANCE.getEPackage(trafficincidentsservicePackage.eNS_URI);

		// Obtain or create and register package
		trafficincidentsservicePackageImpl thetrafficincidentsservicePackage = (trafficincidentsservicePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof trafficincidentsservicePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new trafficincidentsservicePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IconsetPackage.eINSTANCE.eClass();
		trafficincidentPackage.eINSTANCE.eClass();
		XTrafficIncidentPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thetrafficincidentsservicePackage.createPackageContents();

		// Initialize created meta-data
		thetrafficincidentsservicePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thetrafficincidentsservicePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(trafficincidentsservicePackage.eNS_URI, thetrafficincidentsservicePackage);
		return thetrafficincidentsservicePackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTrafficIncidents() {
		return trafficIncidentsEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTrafficIncidentsListener() {
		return trafficIncidentsListenerEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTrafficIncidentFeed() {
		return trafficIncidentFeedEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTrafficIncidentFeedListener() {
		return trafficIncidentFeedListenerEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getFeedInformation() {
		return feedInformationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getFeedInformation_DataProviderName() {
		return (EAttribute)feedInformationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getFeedInformation_ProtocolName() {
		return (EAttribute)feedInformationEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getFeedInformation_CommunicationChannelName() {
		return (EAttribute)feedInformationEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getFeedInformation_FeedStatus() {
		return (EAttribute)feedInformationEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getFeedInformation_TrafficIncidentsStatus() {
		return (EAttribute)feedInformationEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getCategoryDefinition() {
		return categoryDefinitionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getCategoryDefinition_LocalizedNames() {
		return (EReference)categoryDefinitionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCategoryDefinition_CategoryId() {
		return (EAttribute)categoryDefinitionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getCategoryDefinition_Icons() {
		return (EReference)categoryDefinitionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCategoryDefinition_Expression() {
		return (EAttribute)categoryDefinitionEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getTrafficIncidentField() {
		return trafficIncidentFieldEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getTextDetailLevel() {
		return textDetailLevelEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getTrafficIncidentFeedStatus() {
		return trafficIncidentFeedStatusEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getTrafficIncidentsStatus() {
		return trafficIncidentsStatusEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getSpeedUnit() {
		return speedUnitEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getLengthUnit() {
		return lengthUnitEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getWeightUnit() {
		return weightUnitEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public trafficincidentsserviceFactory gettrafficincidentsserviceFactory() {
		return (trafficincidentsserviceFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		trafficIncidentsEClass = createEClass(TRAFFIC_INCIDENTS);

		trafficIncidentsListenerEClass = createEClass(TRAFFIC_INCIDENTS_LISTENER);

		trafficIncidentFeedEClass = createEClass(TRAFFIC_INCIDENT_FEED);

		trafficIncidentFeedListenerEClass = createEClass(TRAFFIC_INCIDENT_FEED_LISTENER);

		feedInformationEClass = createEClass(FEED_INFORMATION);
		createEAttribute(feedInformationEClass, FEED_INFORMATION__DATA_PROVIDER_NAME);
		createEAttribute(feedInformationEClass, FEED_INFORMATION__PROTOCOL_NAME);
		createEAttribute(feedInformationEClass, FEED_INFORMATION__COMMUNICATION_CHANNEL_NAME);
		createEAttribute(feedInformationEClass, FEED_INFORMATION__FEED_STATUS);
		createEAttribute(feedInformationEClass, FEED_INFORMATION__TRAFFIC_INCIDENTS_STATUS);

		categoryDefinitionEClass = createEClass(CATEGORY_DEFINITION);
		createEReference(categoryDefinitionEClass, CATEGORY_DEFINITION__LOCALIZED_NAMES);
		createEAttribute(categoryDefinitionEClass, CATEGORY_DEFINITION__CATEGORY_ID);
		createEReference(categoryDefinitionEClass, CATEGORY_DEFINITION__ICONS);
		createEAttribute(categoryDefinitionEClass, CATEGORY_DEFINITION__EXPRESSION);

		// Create enums
		trafficIncidentFieldEEnum = createEEnum(TRAFFIC_INCIDENT_FIELD);
		textDetailLevelEEnum = createEEnum(TEXT_DETAIL_LEVEL);
		trafficIncidentFeedStatusEEnum = createEEnum(TRAFFIC_INCIDENT_FEED_STATUS);
		trafficIncidentsStatusEEnum = createEEnum(TRAFFIC_INCIDENTS_STATUS);
		speedUnitEEnum = createEEnum(SPEED_UNIT);
		lengthUnitEEnum = createEEnum(LENGTH_UNIT);
		weightUnitEEnum = createEEnum(WEIGHT_UNIT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		trafficincidenttablesPackage thetrafficincidenttablesPackage = (trafficincidenttablesPackage)EPackage.Registry.INSTANCE.getEPackage(trafficincidenttablesPackage.eNS_URI);
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
		IconsetPackage theIconsetPackage = (IconsetPackage)EPackage.Registry.INSTANCE.getEPackage(IconsetPackage.eNS_URI);
		trafficincidentPackage thetrafficincidentPackage = (trafficincidentPackage)EPackage.Registry.INSTANCE.getEPackage(trafficincidentPackage.eNS_URI);
		XTrafficIncidentPackage theXTrafficIncidentPackage = (XTrafficIncidentPackage)EPackage.Registry.INSTANCE.getEPackage(XTrafficIncidentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(trafficIncidentsEClass, TrafficIncidents.class, "TrafficIncidents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(trafficIncidentsEClass, null, "getVersion", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "addUpdateListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thetrafficincidenttablesPackage.getWarningLevel(), "warningLevels", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "categoryIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "updateListener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "addAreasUpdateListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thetrafficincidenttablesPackage.getWarningLevel(), "warningLevels", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "categoryIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonPackage.getRectangularArea(), "areas", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "updateListener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "getLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "setLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "languageCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "countryCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "setTimeFormat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "timeFormat", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "setDateFormat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "dateFormat", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "setLengthUnit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLengthUnit(), "lengthUnit", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "setWeightUnit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getWeightUnit(), "weightUnit", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "getApplicability", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "setApplicability", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "filterExpression", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "reserveIconSetIds", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "numberOfIds", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "freeIconSetIds", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "iconSetIds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "getIconSets", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "addIconSetDefinitions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theIconsetPackage.getIconSet(), "iconSets", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "removeIconSetDefinitions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "iconSetIds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "getIconDefinitions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theIconsetPackage.getIconInfo(), "iconInfos", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "addIconDefinitions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theIconsetPackage.getIconDefinition(), "iconDefinitions", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "removeIconDefinitions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theIconsetPackage.getIconInfo(), "iconInfos", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "reserveCategoryIds", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "numberOfIds", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "freeCategoryIds", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "categoryIds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "getCategoryDefinitions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "addCategoryDefinitions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCategoryDefinition(), "categoryDefinitions", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "removeCategoryDefinitions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "categoryIds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "getTrafficIncidentIds", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thetrafficincidenttablesPackage.getWarningLevel(), "warningLevels", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "categoryIds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "getTrafficIncidentIdsInAreas", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thetrafficincidenttablesPackage.getWarningLevel(), "warningLevels", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "categoryIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonPackage.getRectangularArea(), "areas", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "getTrafficIncidents", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "trafficIncidentIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "includeTextFields", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "getTrafficIncidentsFields", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "trafficIncidentIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentField(), "trafficIncidentFields", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "getTexts", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "trafficIncidentIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTextDetailLevel(), "textDetailLevel", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "addTrafficIncidentsStatusListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "trafficIncidentsStatusListener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "addFeedInformationListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "feedInformationListener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "removeUpdateListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "updateListener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "removeAreasUpdateListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "updateListener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "removeTrafficIncidentsStatusListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "trafficIncidentsStatusListener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsEClass, null, "removeFeedInformationListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsListener(), "feedInformationListener", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(trafficIncidentsListenerEClass, TrafficIncidentsListener.class, "TrafficIncidentsListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getVersionReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonPackage.getVersion(), "version", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "updates", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "unchangedTrafficIncidentIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "changedTrafficIncidentIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "newTrafficIncidentIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "deletedTrafficIncidentIds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "updatesInAreas", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonPackage.getRectangularArea(), "areas", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "trafficIncidentsStatus", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentFeedStatus(), "trafficIncidentFeedStatus", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsStatus(), "trafficIncidentsStatus", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "feedInformation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFeedInformation(), "feedsInformation", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getLanguageReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "languageCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "countryCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getApplicabilityReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "filterExpression", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "reserveIconSetIdsReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "iconSetIds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "reserveCategoryIdsReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "categoryIds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getTrafficIncidentIdsReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "trafficIncidentIds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getTrafficIncidentIdsInAreasReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "trafficIncidentIds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getTrafficIncidentsReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thetrafficincidentPackage.getTrafficIncident(), "trafficIncidents", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getTrafficIncidentsFieldsReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thetrafficincidentPackage.getTrafficIncident(), "trafficIncidents", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getTextsReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "texts", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "addTrafficIncidentsStatusListenerReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "addFeedInformationListenerReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "addUpdateListenerReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "removeUpdateListenerReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "addAreasUpdateListenerReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "removeAreasUpdateListenerReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "setLanguageReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "setTimeFormatReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "setDateFormatReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "setLengthUnitReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "setWeightUnitReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "setApplicabilityReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "freeCategoryIdsReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getCategoryDefinitionsReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCategoryDefinition(), "categoryDefinitions", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "addCategoryDefinitionsReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "removeCategoryDefinitionsReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "freeIconSetIdsReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getIconDefinitionsReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theIconsetPackage.getIconDefinition(), "iconDefinitions", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "addIconDefinitionsReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "removeIconDefinitionsReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentsListenerEClass, null, "getIconSetsReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theIconsetPackage.getIconSet(), "iconSets", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "addIconSetDefinitionsReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "removeIconSetDefinitionsReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "removeFeedInformationListenerReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentsListenerEClass, null, "removeTrafficIncidentsStatusListenerReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(trafficIncidentFeedEClass, TrafficIncidentFeed.class, "TrafficIncidentFeed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(trafficIncidentFeedEClass, null, "getVersion", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentFeedListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentFeedEClass, null, "getLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentFeedListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentFeedEClass, null, "addLanguageListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentFeedListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentFeedListener(), "changeListener", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentFeedEClass, null, "clear", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentFeedEClass, null, "updateIncidents", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "feedId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "cancelledIncidentIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theXTrafficIncidentPackage.getTrafficIncident(), "updatedIncidents", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentFeedEClass, null, "updateStatus", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "feedId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentFeedStatus(), "feedStatus", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentsStatus(), "incidentsStatus", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentFeedEClass, null, "registerFeed", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentFeedListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "dataProviderName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "protocolName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "communicationChannelName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentFeedEClass, null, "removeLanguageListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentFeedListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTrafficIncidentFeedListener(), "changeListener", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(trafficIncidentFeedListenerEClass, TrafficIncidentFeedListener.class, "TrafficIncidentFeedListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(trafficIncidentFeedListenerEClass, null, "getVersionReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonPackage.getVersion(), "version", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentFeedListenerEClass, null, "getLanguageReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "languageCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "countryCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(trafficIncidentFeedListenerEClass, null, "registerFeedReply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "feedId", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentFeedListenerEClass, null, "addLanguageListenerReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(trafficIncidentFeedListenerEClass, null, "removeLanguageListenerReply", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(feedInformationEClass, FeedInformation.class, "FeedInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeedInformation_DataProviderName(), ecorePackage.getEString(), "dataProviderName", null, 0, 1, FeedInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeedInformation_ProtocolName(), ecorePackage.getEString(), "protocolName", null, 0, 1, FeedInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeedInformation_CommunicationChannelName(), ecorePackage.getEString(), "communicationChannelName", null, 0, 1, FeedInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeedInformation_FeedStatus(), this.getTrafficIncidentFeedStatus(), "feedStatus", null, 1, 1, FeedInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeedInformation_TrafficIncidentsStatus(), this.getTrafficIncidentsStatus(), "trafficIncidentsStatus", null, 1, 1, FeedInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryDefinitionEClass, CategoryDefinition.class, "CategoryDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategoryDefinition_LocalizedNames(), theCommonPackage.getLocalizedString(), null, "localizedNames", null, 0, -1, CategoryDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryDefinition_CategoryId(), ecorePackage.getEInt(), "categoryId", null, 1, 1, CategoryDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategoryDefinition_Icons(), theIconsetPackage.getIconInfo(), null, "icons", null, 0, -1, CategoryDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryDefinition_Expression(), ecorePackage.getEString(), "expression", null, 1, 1, CategoryDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(trafficIncidentFieldEEnum, TrafficIncidentField.class, "TrafficIncidentField");
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.TRAFFIC_INCIDENT_ID);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.EFFECT_CODE);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.EFFECT_TEXT);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.START_TIME);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.STOP_TIME);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.TENDENCY);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.TENDENCY_TEXT);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.LENGTH_AFFECTED);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.AVERAGE_SPEED_ABSOLUTE);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.DELAY);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.SEGMENT_SPEED_LIMIT);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.CAUSES);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.CAUSE_TEXTS);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.APPLICABILITY_TEXTS);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.LOCATION);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.LOCATION_INFO);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.LOCATION_BOUNDING_BOX);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.APPLICABILITY);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.ADVICES);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.ADVICE_TEXTS);
		addEEnumLiteral(trafficIncidentFieldEEnum, TrafficIncidentField.EXPECTED_SPEED_ABSOLUTE);

		initEEnum(textDetailLevelEEnum, TextDetailLevel.class, "TextDetailLevel");
		addEEnumLiteral(textDetailLevelEEnum, TextDetailLevel.FULL);
		addEEnumLiteral(textDetailLevelEEnum, TextDetailLevel.SUMMARY);

		initEEnum(trafficIncidentFeedStatusEEnum, TrafficIncidentFeedStatus.class, "TrafficIncidentFeedStatus");
		addEEnumLiteral(trafficIncidentFeedStatusEEnum, TrafficIncidentFeedStatus.UNAVAILABLE);
		addEEnumLiteral(trafficIncidentFeedStatusEEnum, TrafficIncidentFeedStatus.CONNECTED);
		addEEnumLiteral(trafficIncidentFeedStatusEEnum, TrafficIncidentFeedStatus.DISCONNECTED);

		initEEnum(trafficIncidentsStatusEEnum, TrafficIncidentsStatus.class, "TrafficIncidentsStatus");
		addEEnumLiteral(trafficIncidentsStatusEEnum, TrafficIncidentsStatus.UNAVAILABLE);
		addEEnumLiteral(trafficIncidentsStatusEEnum, TrafficIncidentsStatus.PARTLY_AVAILABLE);
		addEEnumLiteral(trafficIncidentsStatusEEnum, TrafficIncidentsStatus.AVAILABLE);

		initEEnum(speedUnitEEnum, SpeedUnit.class, "SpeedUnit");
		addEEnumLiteral(speedUnitEEnum, SpeedUnit.KILOMETERS_PER_HOUR);
		addEEnumLiteral(speedUnitEEnum, SpeedUnit.MILES_PER_HOUR);

		initEEnum(lengthUnitEEnum, LengthUnit.class, "LengthUnit");
		addEEnumLiteral(lengthUnitEEnum, LengthUnit.KILOMETERS);
		addEEnumLiteral(lengthUnitEEnum, LengthUnit.MILES);

		initEEnum(weightUnitEEnum, WeightUnit.class, "WeightUnit");
		addEEnumLiteral(weightUnitEEnum, WeightUnit.KILOGRAM);
		addEEnumLiteral(weightUnitEEnum, WeightUnit.POUND);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// GenModel
		createGenModelAnnotations();
		// http://www.tomtom.com/emfidl/2012/GenModel
		createGenModel_2Annotations();
	}

  /**
	 * Initializes the annotations for <b>GenModel</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createGenModelAnnotations() {
		String source = "GenModel";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "documentation", "Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/."
		   });																																																																																										
	}

  /**
	 * Initializes the annotations for <b>http://www.tomtom.com/emfidl/2012/GenModel</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createGenModel_2Annotations() {
		String source = "http://www.tomtom.com/emfidl/2012/GenModel";				
		addAnnotation
		  (trafficIncidentsEClass, 
		   source, 
		   new String[] {
			 "versionMajor", "0",
			 "versionMinor", "1"
		   });																																																																																								
	}

} //trafficincidentsservicePackageImpl
