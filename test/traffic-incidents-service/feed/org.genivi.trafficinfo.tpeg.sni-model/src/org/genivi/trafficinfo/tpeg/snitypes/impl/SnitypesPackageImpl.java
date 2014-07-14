/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1;
import org.genivi.trafficinfo.tpeg.snitypes.OperatingTime;
import org.genivi.trafficinfo.tpeg.snitypes.SniComponent;
import org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning;
import org.genivi.trafficinfo.tpeg.snitypes.SnitypesFactory;
import org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SnitypesPackageImpl extends EPackageImpl implements SnitypesPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sniComponentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sniComponentFastTuningEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lineOfTable1EClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operatingTimeEClass = null;

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
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SnitypesPackageImpl() {
    super(eNS_URI, SnitypesFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link SnitypesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SnitypesPackage init() {
    if (isInited) return (SnitypesPackage)EPackage.Registry.INSTANCE.getEPackage(SnitypesPackage.eNS_URI);

    // Obtain or create and register package
    SnitypesPackageImpl theSnitypesPackage = (SnitypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SnitypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SnitypesPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    TpegfwktypesPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theSnitypesPackage.createPackageContents();

    // Initialize created meta-data
    theSnitypesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSnitypesPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SnitypesPackage.eNS_URI, theSnitypesPackage);
    return theSnitypesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSniComponent() {
    return sniComponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSniComponent_Id() {
    return (EAttribute)sniComponentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSniComponent_N() {
    return (EAttribute)sniComponentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSniComponentFastTuning() {
    return sniComponentFastTuningEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSniComponentFastTuning_TableIncrementalVersionNumber() {
    return (EAttribute)sniComponentFastTuningEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSniComponentFastTuning_CharTab() {
    return (EAttribute)sniComponentFastTuningEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSniComponentFastTuning_LinesOfTable1() {
    return (EReference)sniComponentFastTuningEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLineOfTable1() {
    return lineOfTable1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLineOfTable1_ServiceComponentId() {
    return (EAttribute)lineOfTable1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLineOfTable1_Selector() {
    return (EAttribute)lineOfTable1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLineOfTable1_OriginatorServiceIdentifier() {
    return (EReference)lineOfTable1EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLineOfTable1_ContentId() {
    return (EAttribute)lineOfTable1EClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLineOfTable1_ApplicationId() {
    return (EAttribute)lineOfTable1EClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLineOfTable1_OperatingTime() {
    return (EReference)lineOfTable1EClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLineOfTable1_EncryptionIndicator() {
    return (EAttribute)lineOfTable1EClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperatingTime() {
    return operatingTimeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnitypesFactory getSnitypesFactory() {
    return (SnitypesFactory)getEFactoryInstance();
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
    sniComponentEClass = createEClass(SNI_COMPONENT);
    createEAttribute(sniComponentEClass, SNI_COMPONENT__ID);
    createEAttribute(sniComponentEClass, SNI_COMPONENT__N);

    sniComponentFastTuningEClass = createEClass(SNI_COMPONENT_FAST_TUNING);
    createEAttribute(sniComponentFastTuningEClass, SNI_COMPONENT_FAST_TUNING__TABLE_INCREMENTAL_VERSION_NUMBER);
    createEAttribute(sniComponentFastTuningEClass, SNI_COMPONENT_FAST_TUNING__CHAR_TAB);
    createEReference(sniComponentFastTuningEClass, SNI_COMPONENT_FAST_TUNING__LINES_OF_TABLE1);

    lineOfTable1EClass = createEClass(LINE_OF_TABLE1);
    createEAttribute(lineOfTable1EClass, LINE_OF_TABLE1__SERVICE_COMPONENT_ID);
    createEAttribute(lineOfTable1EClass, LINE_OF_TABLE1__SELECTOR);
    createEReference(lineOfTable1EClass, LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER);
    createEAttribute(lineOfTable1EClass, LINE_OF_TABLE1__CONTENT_ID);
    createEAttribute(lineOfTable1EClass, LINE_OF_TABLE1__APPLICATION_ID);
    createEReference(lineOfTable1EClass, LINE_OF_TABLE1__OPERATING_TIME);
    createEAttribute(lineOfTable1EClass, LINE_OF_TABLE1__ENCRYPTION_INDICATOR);

    operatingTimeEClass = createEClass(OPERATING_TIME);
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
    TpegfwktypesPackage theTpegfwktypesPackage = (TpegfwktypesPackage)EPackage.Registry.INSTANCE.getEPackage(TpegfwktypesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    sniComponentFastTuningEClass.getESuperTypes().add(this.getSniComponent());

    // Initialize classes and features; add operations and parameters
    initEClass(sniComponentEClass, SniComponent.class, "SniComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSniComponent_Id(), ecorePackage.getEByte(), "id", null, 1, 1, SniComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSniComponent_N(), ecorePackage.getEInt(), "n", null, 1, 1, SniComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sniComponentFastTuningEClass, SniComponentFastTuning.class, "SniComponentFastTuning", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSniComponentFastTuning_TableIncrementalVersionNumber(), ecorePackage.getEByte(), "tableIncrementalVersionNumber", null, 1, 1, SniComponentFastTuning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSniComponentFastTuning_CharTab(), ecorePackage.getEByte(), "charTab", null, 0, 1, SniComponentFastTuning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSniComponentFastTuning_LinesOfTable1(), this.getLineOfTable1(), null, "linesOfTable1", null, 0, -1, SniComponentFastTuning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lineOfTable1EClass, LineOfTable1.class, "LineOfTable1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLineOfTable1_ServiceComponentId(), ecorePackage.getEByte(), "serviceComponentId", null, 1, 1, LineOfTable1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLineOfTable1_Selector(), ecorePackage.getEByte(), "selector", null, 1, 1, LineOfTable1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLineOfTable1_OriginatorServiceIdentifier(), theTpegfwktypesPackage.getServiceIdentifier(), null, "originatorServiceIdentifier", null, 0, 1, LineOfTable1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLineOfTable1_ContentId(), ecorePackage.getEByte(), "contentId", null, 1, 1, LineOfTable1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLineOfTable1_ApplicationId(), ecorePackage.getEByte(), "applicationId", null, 1, 1, LineOfTable1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLineOfTable1_OperatingTime(), this.getOperatingTime(), null, "operatingTime", null, 0, 1, LineOfTable1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLineOfTable1_EncryptionIndicator(), ecorePackage.getEByte(), "encryptionIndicator", null, 0, 1, LineOfTable1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operatingTimeEClass, OperatingTime.class, "OperatingTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // GenModel
    createGenModelAnnotations();
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

} //SnitypesPackageImpl
