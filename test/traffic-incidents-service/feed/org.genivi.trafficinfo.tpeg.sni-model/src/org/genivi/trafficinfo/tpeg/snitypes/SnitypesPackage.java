/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes;

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
 * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface SnitypesPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "snitypes";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://org.genivi.tpeg.snitypes";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "snitypes";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SnitypesPackage eINSTANCE = org.genivi.trafficinfo.tpeg.snitypes.impl.SnitypesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentImpl <em>Sni Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentImpl
   * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SnitypesPackageImpl#getSniComponent()
   * @generated
   */
  int SNI_COMPONENT = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNI_COMPONENT__ID = 0;

  /**
   * The feature id for the '<em><b>N</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNI_COMPONENT__N = 1;

  /**
   * The number of structural features of the '<em>Sni Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNI_COMPONENT_FEATURE_COUNT = 2;


  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentFastTuningImpl <em>Sni Component Fast Tuning</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentFastTuningImpl
   * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SnitypesPackageImpl#getSniComponentFastTuning()
   * @generated
   */
  int SNI_COMPONENT_FAST_TUNING = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNI_COMPONENT_FAST_TUNING__ID = SNI_COMPONENT__ID;

  /**
   * The feature id for the '<em><b>N</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNI_COMPONENT_FAST_TUNING__N = SNI_COMPONENT__N;

  /**
   * The feature id for the '<em><b>Table Incremental Version Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNI_COMPONENT_FAST_TUNING__TABLE_INCREMENTAL_VERSION_NUMBER = SNI_COMPONENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Char Tab</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNI_COMPONENT_FAST_TUNING__CHAR_TAB = SNI_COMPONENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Lines Of Table1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNI_COMPONENT_FAST_TUNING__LINES_OF_TABLE1 = SNI_COMPONENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Sni Component Fast Tuning</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNI_COMPONENT_FAST_TUNING_FEATURE_COUNT = SNI_COMPONENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl <em>Line Of Table1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl
   * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SnitypesPackageImpl#getLineOfTable1()
   * @generated
   */
  int LINE_OF_TABLE1 = 2;

  /**
   * The feature id for the '<em><b>Service Component Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_OF_TABLE1__SERVICE_COMPONENT_ID = 0;

  /**
   * The feature id for the '<em><b>Selector</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_OF_TABLE1__SELECTOR = 1;

  /**
   * The feature id for the '<em><b>Originator Service Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER = 2;

  /**
   * The feature id for the '<em><b>Content Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_OF_TABLE1__CONTENT_ID = 3;

  /**
   * The feature id for the '<em><b>Application Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_OF_TABLE1__APPLICATION_ID = 4;

  /**
   * The feature id for the '<em><b>Operating Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_OF_TABLE1__OPERATING_TIME = 5;

  /**
   * The feature id for the '<em><b>Encryption Indicator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_OF_TABLE1__ENCRYPTION_INDICATOR = 6;

  /**
   * The number of structural features of the '<em>Line Of Table1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_OF_TABLE1_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.snitypes.impl.OperatingTimeImpl <em>Operating Time</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.snitypes.impl.OperatingTimeImpl
   * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SnitypesPackageImpl#getOperatingTime()
   * @generated
   */
  int OPERATING_TIME = 3;

  /**
   * The number of structural features of the '<em>Operating Time</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATING_TIME_FEATURE_COUNT = 0;


  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent <em>Sni Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sni Component</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.SniComponent
   * @generated
   */
  EClass getSniComponent();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getId()
   * @see #getSniComponent()
   * @generated
   */
  EAttribute getSniComponent_Id();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getN <em>N</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>N</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.SniComponent#getN()
   * @see #getSniComponent()
   * @generated
   */
  EAttribute getSniComponent_N();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning <em>Sni Component Fast Tuning</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sni Component Fast Tuning</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning
   * @generated
   */
  EClass getSniComponentFastTuning();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getTableIncrementalVersionNumber <em>Table Incremental Version Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Table Incremental Version Number</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getTableIncrementalVersionNumber()
   * @see #getSniComponentFastTuning()
   * @generated
   */
  EAttribute getSniComponentFastTuning_TableIncrementalVersionNumber();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getCharTab <em>Char Tab</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Char Tab</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getCharTab()
   * @see #getSniComponentFastTuning()
   * @generated
   */
  EAttribute getSniComponentFastTuning_CharTab();

  /**
   * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getLinesOfTable1 <em>Lines Of Table1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Lines Of Table1</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getLinesOfTable1()
   * @see #getSniComponentFastTuning()
   * @generated
   */
  EReference getSniComponentFastTuning_LinesOfTable1();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1 <em>Line Of Table1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Line Of Table1</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1
   * @generated
   */
  EClass getLineOfTable1();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getServiceComponentId <em>Service Component Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Service Component Id</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getServiceComponentId()
   * @see #getLineOfTable1()
   * @generated
   */
  EAttribute getLineOfTable1_ServiceComponentId();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getSelector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Selector</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getSelector()
   * @see #getLineOfTable1()
   * @generated
   */
  EAttribute getLineOfTable1_Selector();

  /**
   * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOriginatorServiceIdentifier <em>Originator Service Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Originator Service Identifier</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOriginatorServiceIdentifier()
   * @see #getLineOfTable1()
   * @generated
   */
  EReference getLineOfTable1_OriginatorServiceIdentifier();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getContentId <em>Content Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content Id</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getContentId()
   * @see #getLineOfTable1()
   * @generated
   */
  EAttribute getLineOfTable1_ContentId();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getApplicationId <em>Application Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Application Id</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getApplicationId()
   * @see #getLineOfTable1()
   * @generated
   */
  EAttribute getLineOfTable1_ApplicationId();

  /**
   * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOperatingTime <em>Operating Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operating Time</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOperatingTime()
   * @see #getLineOfTable1()
   * @generated
   */
  EReference getLineOfTable1_OperatingTime();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getEncryptionIndicator <em>Encryption Indicator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Encryption Indicator</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getEncryptionIndicator()
   * @see #getLineOfTable1()
   * @generated
   */
  EAttribute getLineOfTable1_EncryptionIndicator();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.snitypes.OperatingTime <em>Operating Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operating Time</em>'.
   * @see org.genivi.trafficinfo.tpeg.snitypes.OperatingTime
   * @generated
   */
  EClass getOperatingTime();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SnitypesFactory getSnitypesFactory();

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
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentImpl <em>Sni Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentImpl
     * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SnitypesPackageImpl#getSniComponent()
     * @generated
     */
    EClass SNI_COMPONENT = eINSTANCE.getSniComponent();
    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SNI_COMPONENT__ID = eINSTANCE.getSniComponent_Id();
    /**
     * The meta object literal for the '<em><b>N</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SNI_COMPONENT__N = eINSTANCE.getSniComponent_N();
    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentFastTuningImpl <em>Sni Component Fast Tuning</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentFastTuningImpl
     * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SnitypesPackageImpl#getSniComponentFastTuning()
     * @generated
     */
    EClass SNI_COMPONENT_FAST_TUNING = eINSTANCE.getSniComponentFastTuning();
    /**
     * The meta object literal for the '<em><b>Table Incremental Version Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SNI_COMPONENT_FAST_TUNING__TABLE_INCREMENTAL_VERSION_NUMBER = eINSTANCE.getSniComponentFastTuning_TableIncrementalVersionNumber();
    /**
     * The meta object literal for the '<em><b>Char Tab</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SNI_COMPONENT_FAST_TUNING__CHAR_TAB = eINSTANCE.getSniComponentFastTuning_CharTab();
    /**
     * The meta object literal for the '<em><b>Lines Of Table1</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SNI_COMPONENT_FAST_TUNING__LINES_OF_TABLE1 = eINSTANCE.getSniComponentFastTuning_LinesOfTable1();
    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl <em>Line Of Table1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl
     * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SnitypesPackageImpl#getLineOfTable1()
     * @generated
     */
    EClass LINE_OF_TABLE1 = eINSTANCE.getLineOfTable1();
    /**
     * The meta object literal for the '<em><b>Service Component Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINE_OF_TABLE1__SERVICE_COMPONENT_ID = eINSTANCE.getLineOfTable1_ServiceComponentId();
    /**
     * The meta object literal for the '<em><b>Selector</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINE_OF_TABLE1__SELECTOR = eINSTANCE.getLineOfTable1_Selector();
    /**
     * The meta object literal for the '<em><b>Originator Service Identifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER = eINSTANCE.getLineOfTable1_OriginatorServiceIdentifier();
    /**
     * The meta object literal for the '<em><b>Content Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINE_OF_TABLE1__CONTENT_ID = eINSTANCE.getLineOfTable1_ContentId();
    /**
     * The meta object literal for the '<em><b>Application Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINE_OF_TABLE1__APPLICATION_ID = eINSTANCE.getLineOfTable1_ApplicationId();
    /**
     * The meta object literal for the '<em><b>Operating Time</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINE_OF_TABLE1__OPERATING_TIME = eINSTANCE.getLineOfTable1_OperatingTime();
    /**
     * The meta object literal for the '<em><b>Encryption Indicator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINE_OF_TABLE1__ENCRYPTION_INDICATOR = eINSTANCE.getLineOfTable1_EncryptionIndicator();
    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.snitypes.impl.OperatingTimeImpl <em>Operating Time</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.snitypes.impl.OperatingTimeImpl
     * @see org.genivi.trafficinfo.tpeg.snitypes.impl.SnitypesPackageImpl#getOperatingTime()
     * @generated
     */
    EClass OPERATING_TIME = eINSTANCE.getOperatingTime();

  }

} //SnitypesPackage
