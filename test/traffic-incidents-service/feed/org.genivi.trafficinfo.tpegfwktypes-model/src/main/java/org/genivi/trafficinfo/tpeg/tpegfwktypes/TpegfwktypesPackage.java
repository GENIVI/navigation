/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

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
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesFactory
 * @model kind="package"
 *        annotation="GenModel documentation='Copyright (C) 2013 TomTom International B.V.\r\n\r\nThis Source Code Form is subject to the terms of the Mozilla Public\r\nLicense, v. 2.0. If a copy of the MPL was not distributed with this\r\nfile, You can obtain one at http://mozilla.org/MPL/2.0/.'"
 * @generated
 */
public interface TpegfwktypesPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "tpegfwktypes";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://org.genivi.trafficinfo.tpegfwktypes";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "com.tomtom.ti";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TpegfwktypesPackage eINSTANCE = org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.LocalisedShortStringImpl <em>Localised Short String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.LocalisedShortStringImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getLocalisedShortString()
   * @generated
   */
  int LOCALISED_SHORT_STRING = 0;

  /**
   * The feature id for the '<em><b>Language Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCALISED_SHORT_STRING__LANGUAGE_CODE = 0;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCALISED_SHORT_STRING__STRING = 1;

  /**
   * The number of structural features of the '<em>Localised Short String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCALISED_SHORT_STRING_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.LocationReferencingContainerImpl <em>Location Referencing Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.LocationReferencingContainerImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getLocationReferencingContainer()
   * @generated
   */
  int LOCATION_REFERENCING_CONTAINER = 1;

  /**
   * The feature id for the '<em><b>Method</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCATION_REFERENCING_CONTAINER__METHOD = 0;

  /**
   * The number of structural features of the '<em>Location Referencing Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCATION_REFERENCING_CONTAINER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameTemplateImpl <em>Transport Frame Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameTemplateImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTransportFrameTemplate()
   * @generated
   */
  int TRANSPORT_FRAME_TEMPLATE = 2;

  /**
   * The feature id for the '<em><b>Meta Information TODO</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TEMPLATE__META_INFORMATION_TODO = 0;

  /**
   * The feature id for the '<em><b>Sync Word</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TEMPLATE__SYNC_WORD = 1;

  /**
   * The feature id for the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TEMPLATE__FIELD_LENGTH = 2;

  /**
   * The feature id for the '<em><b>Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TEMPLATE__HEADER_CRC = 3;

  /**
   * The feature id for the '<em><b>Frame Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TEMPLATE__FRAME_TYPE = 4;

  /**
   * The number of structural features of the '<em>Transport Frame Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TEMPLATE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameType0Impl <em>Transport Frame Type0</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameType0Impl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTransportFrameType0()
   * @generated
   */
  int TRANSPORT_FRAME_TYPE0 = 3;

  /**
   * The feature id for the '<em><b>Meta Information TODO</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE0__META_INFORMATION_TODO = TRANSPORT_FRAME_TEMPLATE__META_INFORMATION_TODO;

  /**
   * The feature id for the '<em><b>Sync Word</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE0__SYNC_WORD = TRANSPORT_FRAME_TEMPLATE__SYNC_WORD;

  /**
   * The feature id for the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE0__FIELD_LENGTH = TRANSPORT_FRAME_TEMPLATE__FIELD_LENGTH;

  /**
   * The feature id for the '<em><b>Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE0__HEADER_CRC = TRANSPORT_FRAME_TEMPLATE__HEADER_CRC;

  /**
   * The feature id for the '<em><b>Frame Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE0__FRAME_TYPE = TRANSPORT_FRAME_TEMPLATE__FRAME_TYPE;

  /**
   * The feature id for the '<em><b>Transport Frame Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE0__TRANSPORT_FRAME_CONTENT = TRANSPORT_FRAME_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Transport Frame Type0</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE0_FEATURE_COUNT = TRANSPORT_FRAME_TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameType1Impl <em>Transport Frame Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameType1Impl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTransportFrameType1()
   * @generated
   */
  int TRANSPORT_FRAME_TYPE1 = 4;

  /**
   * The feature id for the '<em><b>Meta Information TODO</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE1__META_INFORMATION_TODO = TRANSPORT_FRAME_TEMPLATE__META_INFORMATION_TODO;

  /**
   * The feature id for the '<em><b>Sync Word</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE1__SYNC_WORD = TRANSPORT_FRAME_TEMPLATE__SYNC_WORD;

  /**
   * The feature id for the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE1__FIELD_LENGTH = TRANSPORT_FRAME_TEMPLATE__FIELD_LENGTH;

  /**
   * The feature id for the '<em><b>Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE1__HEADER_CRC = TRANSPORT_FRAME_TEMPLATE__HEADER_CRC;

  /**
   * The feature id for the '<em><b>Frame Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE1__FRAME_TYPE = TRANSPORT_FRAME_TEMPLATE__FRAME_TYPE;

  /**
   * The feature id for the '<em><b>Transport Frame Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT = TRANSPORT_FRAME_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Transport Frame Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSPORT_FRAME_TYPE1_FEATURE_COUNT = TRANSPORT_FRAME_TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceComponentFrameImpl <em>Service Component Frame</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceComponentFrameImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServiceComponentFrame()
   * @generated
   */
  int SERVICE_COMPONENT_FRAME = 5;

  /**
   * The feature id for the '<em><b>SCID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_COMPONENT_FRAME__SCID = 0;

  /**
   * The feature id for the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_COMPONENT_FRAME__FIELD_LENGTH = 1;

  /**
   * The feature id for the '<em><b>Sc Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_COMPONENT_FRAME__SC_HEADER_CRC = 2;

  /**
   * The number of structural features of the '<em>Service Component Frame</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_COMPONENT_FRAME_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceFrameImpl <em>Service Frame</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceFrameImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServiceFrame()
   * @generated
   */
  int SERVICE_FRAME = 6;

  /**
   * The feature id for the '<em><b>Serv Enc ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_FRAME__SERV_ENC_ID = 0;

  /**
   * The feature id for the '<em><b>Service Frame Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_FRAME__SERVICE_FRAME_CONTENT = 1;

  /**
   * The feature id for the '<em><b>SID</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_FRAME__SID = 2;

  /**
   * The number of structural features of the '<em>Service Frame</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_FRAME_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.StreamDirectoryFrameImpl <em>Stream Directory Frame</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.StreamDirectoryFrameImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getStreamDirectoryFrame()
   * @generated
   */
  int STREAM_DIRECTORY_FRAME = 7;

  /**
   * The feature id for the '<em><b>SID</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STREAM_DIRECTORY_FRAME__SID = 0;

  /**
   * The feature id for the '<em><b>Number Of Services</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STREAM_DIRECTORY_FRAME__NUMBER_OF_SERVICES = 1;

  /**
   * The feature id for the '<em><b>Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STREAM_DIRECTORY_FRAME__HEADER_CRC = 2;

  /**
   * The number of structural features of the '<em>Stream Directory Frame</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STREAM_DIRECTORY_FRAME_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompMultiplexImpl <em>Serv Comp Multiplex</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompMultiplexImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServCompMultiplex()
   * @generated
   */
  int SERV_COMP_MULTIPLEX = 8;

  /**
   * The feature id for the '<em><b>Multiplex Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_MULTIPLEX__MULTIPLEX_CONTENT = 0;

  /**
   * The number of structural features of the '<em>Serv Comp Multiplex</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_MULTIPLEX_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceIdentifierImpl <em>Service Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceIdentifierImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServiceIdentifier()
   * @generated
   */
  int SERVICE_IDENTIFIER = 9;

  /**
   * The feature id for the '<em><b>Sid A</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_IDENTIFIER__SID_A = 0;

  /**
   * The feature id for the '<em><b>Sid B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_IDENTIFIER__SID_B = 1;

  /**
   * The feature id for the '<em><b>Sid C</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_IDENTIFIER__SID_C = 2;

  /**
   * The number of structural features of the '<em>Service Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_IDENTIFIER_FEATURE_COUNT = 3;


  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFrameProtectedImpl <em>Serv Comp Frame Protected</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFrameProtectedImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServCompFrameProtected()
   * @generated
   */
  int SERV_COMP_FRAME_PROTECTED = 10;

  /**
   * The feature id for the '<em><b>SCID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PROTECTED__SCID = SERVICE_COMPONENT_FRAME__SCID;

  /**
   * The feature id for the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PROTECTED__FIELD_LENGTH = SERVICE_COMPONENT_FRAME__FIELD_LENGTH;

  /**
   * The feature id for the '<em><b>Sc Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PROTECTED__SC_HEADER_CRC = SERVICE_COMPONENT_FRAME__SC_HEADER_CRC;

  /**
   * The feature id for the '<em><b>Application Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PROTECTED__APPLICATION_CONTENT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Data CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PROTECTED__DATA_CRC = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Serv Comp Frame Protected</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PROTECTED_FEATURE_COUNT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFrameCountedProtectedImpl <em>Serv Comp Frame Counted Protected</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFrameCountedProtectedImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServCompFrameCountedProtected()
   * @generated
   */
  int SERV_COMP_FRAME_COUNTED_PROTECTED = 11;

  /**
   * The feature id for the '<em><b>SCID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_COUNTED_PROTECTED__SCID = SERVICE_COMPONENT_FRAME__SCID;

  /**
   * The feature id for the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_COUNTED_PROTECTED__FIELD_LENGTH = SERVICE_COMPONENT_FRAME__FIELD_LENGTH;

  /**
   * The feature id for the '<em><b>Sc Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_COUNTED_PROTECTED__SC_HEADER_CRC = SERVICE_COMPONENT_FRAME__SC_HEADER_CRC;

  /**
   * The feature id for the '<em><b>Message Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_COUNTED_PROTECTED__MESSAGE_COUNT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Application Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_COUNTED_PROTECTED__APPLICATION_CONTENT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Data CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_COUNTED_PROTECTED__DATA_CRC = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Serv Comp Frame Counted Protected</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_COUNTED_PROTECTED_FEATURE_COUNT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedProtectedImpl <em>Serv Comp Frame Prioritised Protected</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedProtectedImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServCompFramePrioritisedProtected()
   * @generated
   */
  int SERV_COMP_FRAME_PRIORITISED_PROTECTED = 12;

  /**
   * The feature id for the '<em><b>SCID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_PROTECTED__SCID = SERVICE_COMPONENT_FRAME__SCID;

  /**
   * The feature id for the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_PROTECTED__FIELD_LENGTH = SERVICE_COMPONENT_FRAME__FIELD_LENGTH;

  /**
   * The feature id for the '<em><b>Sc Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_PROTECTED__SC_HEADER_CRC = SERVICE_COMPONENT_FRAME__SC_HEADER_CRC;

  /**
   * The feature id for the '<em><b>Group Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_PROTECTED__GROUP_PRIORITY = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Application Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_PROTECTED__APPLICATION_CONTENT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Data CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_PROTECTED__DATA_CRC = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Serv Comp Frame Prioritised Protected</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_PROTECTED_FEATURE_COUNT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedCountedProtectedImpl <em>Serv Comp Frame Prioritised Counted Protected</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedCountedProtectedImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServCompFramePrioritisedCountedProtected()
   * @generated
   */
  int SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED = 13;

  /**
   * The feature id for the '<em><b>SCID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__SCID = SERVICE_COMPONENT_FRAME__SCID;

  /**
   * The feature id for the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__FIELD_LENGTH = SERVICE_COMPONENT_FRAME__FIELD_LENGTH;

  /**
   * The feature id for the '<em><b>Sc Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__SC_HEADER_CRC = SERVICE_COMPONENT_FRAME__SC_HEADER_CRC;

  /**
   * The feature id for the '<em><b>Group Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__GROUP_PRIORITY = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Message Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__MESSAGE_COUNT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Application Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__APPLICATION_CONTENT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Data CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__DATA_CRC = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Serv Comp Frame Prioritised Counted Protected</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED_FEATURE_COUNT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 4;


  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCSwitchImpl <em>MMC Switch</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCSwitchImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMMCSwitch()
   * @generated
   */
  int MMC_SWITCH = 14;

  /**
   * The feature id for the '<em><b>Message ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_SWITCH__MESSAGE_ID = 0;

  /**
   * The feature id for the '<em><b>Version ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_SWITCH__VERSION_ID = 1;

  /**
   * The feature id for the '<em><b>Message Expiry Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_SWITCH__MESSAGE_EXPIRY_TIME = 2;

  /**
   * The feature id for the '<em><b>Cancel Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_SWITCH__CANCEL_FLAG = 3;

  /**
   * The feature id for the '<em><b>Message Generation Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_SWITCH__MESSAGE_GENERATION_TIME = 4;

  /**
   * The feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_SWITCH__PRIORITY = 5;

  /**
   * The number of structural features of the '<em>MMC Switch</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_SWITCH_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MessageManagementContainerImpl <em>Message Management Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MessageManagementContainerImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMessageManagementContainer()
   * @generated
   */
  int MESSAGE_MANAGEMENT_CONTAINER = 15;

  /**
   * The feature id for the '<em><b>Message ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_MANAGEMENT_CONTAINER__MESSAGE_ID = MMC_SWITCH__MESSAGE_ID;

  /**
   * The feature id for the '<em><b>Version ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_MANAGEMENT_CONTAINER__VERSION_ID = MMC_SWITCH__VERSION_ID;

  /**
   * The feature id for the '<em><b>Message Expiry Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_MANAGEMENT_CONTAINER__MESSAGE_EXPIRY_TIME = MMC_SWITCH__MESSAGE_EXPIRY_TIME;

  /**
   * The feature id for the '<em><b>Cancel Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_MANAGEMENT_CONTAINER__CANCEL_FLAG = MMC_SWITCH__CANCEL_FLAG;

  /**
   * The feature id for the '<em><b>Message Generation Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_MANAGEMENT_CONTAINER__MESSAGE_GENERATION_TIME = MMC_SWITCH__MESSAGE_GENERATION_TIME;

  /**
   * The feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_MANAGEMENT_CONTAINER__PRIORITY = MMC_SWITCH__PRIORITY;

  /**
   * The number of structural features of the '<em>Message Management Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_MANAGEMENT_CONTAINER_FEATURE_COUNT = MMC_SWITCH_FEATURE_COUNT + 0;


  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMasterMessageImpl <em>MMC Master Message</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMasterMessageImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMMCMasterMessage()
   * @generated
   */
  int MMC_MASTER_MESSAGE = 16;

  /**
   * The feature id for the '<em><b>Message ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MASTER_MESSAGE__MESSAGE_ID = MMC_SWITCH__MESSAGE_ID;

  /**
   * The feature id for the '<em><b>Version ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MASTER_MESSAGE__VERSION_ID = MMC_SWITCH__VERSION_ID;

  /**
   * The feature id for the '<em><b>Message Expiry Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MASTER_MESSAGE__MESSAGE_EXPIRY_TIME = MMC_SWITCH__MESSAGE_EXPIRY_TIME;

  /**
   * The feature id for the '<em><b>Cancel Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MASTER_MESSAGE__CANCEL_FLAG = MMC_SWITCH__CANCEL_FLAG;

  /**
   * The feature id for the '<em><b>Message Generation Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MASTER_MESSAGE__MESSAGE_GENERATION_TIME = MMC_SWITCH__MESSAGE_GENERATION_TIME;

  /**
   * The feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MASTER_MESSAGE__PRIORITY = MMC_SWITCH__PRIORITY;

  /**
   * The feature id for the '<em><b>Multi Part Message Directory</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MASTER_MESSAGE__MULTI_PART_MESSAGE_DIRECTORY = MMC_SWITCH_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>MMC Master Message</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MASTER_MESSAGE_FEATURE_COUNT = MMC_SWITCH_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MultiPartMessageDirectoryImpl <em>Multi Part Message Directory</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MultiPartMessageDirectoryImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMultiPartMessageDirectory()
   * @generated
   */
  int MULTI_PART_MESSAGE_DIRECTORY = 17;

  /**
   * The feature id for the '<em><b>Part ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_PART_MESSAGE_DIRECTORY__PART_ID = 0;

  /**
   * The feature id for the '<em><b>Part Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_PART_MESSAGE_DIRECTORY__PART_TYPE = 1;

  /**
   * The number of structural features of the '<em>Multi Part Message Directory</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_PART_MESSAGE_DIRECTORY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMessagePartImpl <em>MMC Message Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMessagePartImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMMCMessagePart()
   * @generated
   */
  int MMC_MESSAGE_PART = 18;

  /**
   * The feature id for the '<em><b>Message ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MESSAGE_PART__MESSAGE_ID = MMC_SWITCH__MESSAGE_ID;

  /**
   * The feature id for the '<em><b>Version ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MESSAGE_PART__VERSION_ID = MMC_SWITCH__VERSION_ID;

  /**
   * The feature id for the '<em><b>Message Expiry Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MESSAGE_PART__MESSAGE_EXPIRY_TIME = MMC_SWITCH__MESSAGE_EXPIRY_TIME;

  /**
   * The feature id for the '<em><b>Cancel Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MESSAGE_PART__CANCEL_FLAG = MMC_SWITCH__CANCEL_FLAG;

  /**
   * The feature id for the '<em><b>Message Generation Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MESSAGE_PART__MESSAGE_GENERATION_TIME = MMC_SWITCH__MESSAGE_GENERATION_TIME;

  /**
   * The feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MESSAGE_PART__PRIORITY = MMC_SWITCH__PRIORITY;

  /**
   * The feature id for the '<em><b>Part ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MESSAGE_PART__PART_ID = MMC_SWITCH_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Update Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MESSAGE_PART__UPDATE_MODE = MMC_SWITCH_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Master Message Versions</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MESSAGE_PART__MASTER_MESSAGE_VERSIONS = MMC_SWITCH_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>MMC Message Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMC_MESSAGE_PART_FEATURE_COUNT = MMC_SWITCH_FEATURE_COUNT + 3;


  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MethodImpl <em>Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MethodImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMethod()
   * @generated
   */
  int METHOD = 19;

  /**
   * The number of structural features of the '<em>Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TPEGLocationReferenceImpl <em>TPEG Location Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TPEGLocationReferenceImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTPEGLocationReference()
   * @generated
   */
  int TPEG_LOCATION_REFERENCE = 20;

  /**
   * The number of structural features of the '<em>TPEG Location Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPEG_LOCATION_REFERENCE_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.DLR1LocationReferenceImpl <em>DLR1 Location Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.DLR1LocationReferenceImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getDLR1LocationReference()
   * @generated
   */
  int DLR1_LOCATION_REFERENCE = 21;

  /**
   * The number of structural features of the '<em>DLR1 Location Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DLR1_LOCATION_REFERENCE_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TMCLocationReferenceImpl <em>TMC Location Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TMCLocationReferenceImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTMCLocationReference()
   * @generated
   */
  int TMC_LOCATION_REFERENCE = 22;

  /**
   * The number of structural features of the '<em>TMC Location Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMC_LOCATION_REFERENCE_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.VICSLinkReferenceImpl <em>VICS Link Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.VICSLinkReferenceImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getVICSLinkReference()
   * @generated
   */
  int VICS_LINK_REFERENCE = 23;

  /**
   * The number of structural features of the '<em>VICS Link Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VICS_LINK_REFERENCE_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.KoreanNodeLinkLocationReferenceImpl <em>Korean Node Link Location Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.KoreanNodeLinkLocationReferenceImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getKoreanNodeLinkLocationReference()
   * @generated
   */
  int KOREAN_NODE_LINK_LOCATION_REFERENCE = 24;

  /**
   * The number of structural features of the '<em>Korean Node Link Location Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KOREAN_NODE_LINK_LOCATION_REFERENCE_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TETLocationReferenceImpl <em>TET Location Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TETLocationReferenceImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTETLocationReference()
   * @generated
   */
  int TET_LOCATION_REFERENCE = 25;

  /**
   * The number of structural features of the '<em>TET Location Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TET_LOCATION_REFERENCE_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.GLRLocationReferenceImpl <em>GLR Location Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.GLRLocationReferenceImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getGLRLocationReference()
   * @generated
   */
  int GLR_LOCATION_REFERENCE = 26;

  /**
   * The number of structural features of the '<em>GLR Location Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLR_LOCATION_REFERENCE_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.OLRLocationReferenceImpl <em>OLR Location Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.OLRLocationReferenceImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getOLRLocationReference()
   * @generated
   */
  int OLR_LOCATION_REFERENCE = 27;

  /**
   * The feature id for the '<em><b>Location Data</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OLR_LOCATION_REFERENCE__LOCATION_DATA = METHOD_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>OLR Location Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OLR_LOCATION_REFERENCE_FEATURE_COUNT = METHOD_FEATURE_COUNT + 1;


  /**
   * The meta object id for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TimeServiceComponentFrameImpl <em>Time Service Component Frame</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TimeServiceComponentFrameImpl
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTimeServiceComponentFrame()
   * @generated
   */
  int TIME_SERVICE_COMPONENT_FRAME = 28;

  /**
   * The feature id for the '<em><b>SCID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_SERVICE_COMPONENT_FRAME__SCID = SERVICE_COMPONENT_FRAME__SCID;

  /**
   * The feature id for the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_SERVICE_COMPONENT_FRAME__FIELD_LENGTH = SERVICE_COMPONENT_FRAME__FIELD_LENGTH;

  /**
   * The feature id for the '<em><b>Sc Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_SERVICE_COMPONENT_FRAME__SC_HEADER_CRC = SERVICE_COMPONENT_FRAME__SC_HEADER_CRC;

  /**
   * The feature id for the '<em><b>Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_SERVICE_COMPONENT_FRAME__DATE = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Formatted Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_SERVICE_COMPONENT_FRAME__FORMATTED_DATE = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Time Service Component Frame</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_SERVICE_COMPONENT_FRAME_FEATURE_COUNT = SERVICE_COMPONENT_FRAME_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString <em>Localised Short String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Localised Short String</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString
   * @generated
   */
  EClass getLocalisedShortString();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString#getLanguageCode <em>Language Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Language Code</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString#getLanguageCode()
   * @see #getLocalisedShortString()
   * @generated
   */
  EAttribute getLocalisedShortString_LanguageCode();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString#getString()
   * @see #getLocalisedShortString()
   * @generated
   */
  EAttribute getLocalisedShortString_String();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer <em>Location Referencing Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Location Referencing Container</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer
   * @generated
   */
  EClass getLocationReferencingContainer();

  /**
   * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Method</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer#getMethod()
   * @see #getLocationReferencingContainer()
   * @generated
   */
  EReference getLocationReferencingContainer_Method();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate <em>Transport Frame Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transport Frame Template</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate
   * @generated
   */
  EClass getTransportFrameTemplate();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getMetaInformationTODO <em>Meta Information TODO</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Meta Information TODO</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getMetaInformationTODO()
   * @see #getTransportFrameTemplate()
   * @generated
   */
  EAttribute getTransportFrameTemplate_MetaInformationTODO();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getSyncWord <em>Sync Word</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sync Word</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getSyncWord()
   * @see #getTransportFrameTemplate()
   * @generated
   */
  EAttribute getTransportFrameTemplate_SyncWord();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getFieldLength <em>Field Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Field Length</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getFieldLength()
   * @see #getTransportFrameTemplate()
   * @generated
   */
  EAttribute getTransportFrameTemplate_FieldLength();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getHeaderCRC <em>Header CRC</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Header CRC</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getHeaderCRC()
   * @see #getTransportFrameTemplate()
   * @generated
   */
  EAttribute getTransportFrameTemplate_HeaderCRC();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getFrameType <em>Frame Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Frame Type</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getFrameType()
   * @see #getTransportFrameTemplate()
   * @generated
   */
  EAttribute getTransportFrameTemplate_FrameType();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType0 <em>Transport Frame Type0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transport Frame Type0</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType0
   * @generated
   */
  EClass getTransportFrameType0();

  /**
   * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType0#getTransportFrameContent <em>Transport Frame Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Transport Frame Content</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType0#getTransportFrameContent()
   * @see #getTransportFrameType0()
   * @generated
   */
  EReference getTransportFrameType0_TransportFrameContent();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType1 <em>Transport Frame Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transport Frame Type1</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType1
   * @generated
   */
  EClass getTransportFrameType1();

  /**
   * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType1#getTransportFrameContent <em>Transport Frame Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Transport Frame Content</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType1#getTransportFrameContent()
   * @see #getTransportFrameType1()
   * @generated
   */
  EReference getTransportFrameType1_TransportFrameContent();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame <em>Service Component Frame</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Service Component Frame</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame
   * @generated
   */
  EClass getServiceComponentFrame();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getSCID <em>SCID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>SCID</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getSCID()
   * @see #getServiceComponentFrame()
   * @generated
   */
  EAttribute getServiceComponentFrame_SCID();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getFieldLength <em>Field Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Field Length</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getFieldLength()
   * @see #getServiceComponentFrame()
   * @generated
   */
  EAttribute getServiceComponentFrame_FieldLength();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getScHeaderCRC <em>Sc Header CRC</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sc Header CRC</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame#getScHeaderCRC()
   * @see #getServiceComponentFrame()
   * @generated
   */
  EAttribute getServiceComponentFrame_ScHeaderCRC();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame <em>Service Frame</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Service Frame</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame
   * @generated
   */
  EClass getServiceFrame();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getServEncID <em>Serv Enc ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Serv Enc ID</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getServEncID()
   * @see #getServiceFrame()
   * @generated
   */
  EAttribute getServiceFrame_ServEncID();

  /**
   * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getServiceFrameContent <em>Service Frame Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Service Frame Content</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getServiceFrameContent()
   * @see #getServiceFrame()
   * @generated
   */
  EReference getServiceFrame_ServiceFrameContent();

  /**
   * Returns the meta object for the containment reference '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getSID <em>SID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>SID</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame#getSID()
   * @see #getServiceFrame()
   * @generated
   */
  EReference getServiceFrame_SID();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame <em>Stream Directory Frame</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stream Directory Frame</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame
   * @generated
   */
  EClass getStreamDirectoryFrame();

  /**
   * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getSID <em>SID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>SID</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getSID()
   * @see #getStreamDirectoryFrame()
   * @generated
   */
  EReference getStreamDirectoryFrame_SID();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getNumberOfServices <em>Number Of Services</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number Of Services</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getNumberOfServices()
   * @see #getStreamDirectoryFrame()
   * @generated
   */
  EAttribute getStreamDirectoryFrame_NumberOfServices();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getHeaderCRC <em>Header CRC</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Header CRC</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame#getHeaderCRC()
   * @see #getStreamDirectoryFrame()
   * @generated
   */
  EAttribute getStreamDirectoryFrame_HeaderCRC();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex <em>Serv Comp Multiplex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Serv Comp Multiplex</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex
   * @generated
   */
  EClass getServCompMultiplex();

  /**
   * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex#getMultiplexContent <em>Multiplex Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Multiplex Content</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex#getMultiplexContent()
   * @see #getServCompMultiplex()
   * @generated
   */
  EReference getServCompMultiplex_MultiplexContent();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier <em>Service Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Service Identifier</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier
   * @generated
   */
  EClass getServiceIdentifier();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidA <em>Sid A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sid A</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidA()
   * @see #getServiceIdentifier()
   * @generated
   */
  EAttribute getServiceIdentifier_SidA();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidB <em>Sid B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sid B</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidB()
   * @see #getServiceIdentifier()
   * @generated
   */
  EAttribute getServiceIdentifier_SidB();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidC <em>Sid C</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sid C</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier#getSidC()
   * @see #getServiceIdentifier()
   * @generated
   */
  EAttribute getServiceIdentifier_SidC();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameProtected <em>Serv Comp Frame Protected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Serv Comp Frame Protected</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameProtected
   * @generated
   */
  EClass getServCompFrameProtected();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameProtected#getApplicationContent <em>Application Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Application Content</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameProtected#getApplicationContent()
   * @see #getServCompFrameProtected()
   * @generated
   */
  EAttribute getServCompFrameProtected_ApplicationContent();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameProtected#getDataCRC <em>Data CRC</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data CRC</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameProtected#getDataCRC()
   * @see #getServCompFrameProtected()
   * @generated
   */
  EAttribute getServCompFrameProtected_DataCRC();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected <em>Serv Comp Frame Counted Protected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Serv Comp Frame Counted Protected</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected
   * @generated
   */
  EClass getServCompFrameCountedProtected();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected#getMessageCount <em>Message Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message Count</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected#getMessageCount()
   * @see #getServCompFrameCountedProtected()
   * @generated
   */
  EAttribute getServCompFrameCountedProtected_MessageCount();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected#getApplicationContent <em>Application Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Application Content</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected#getApplicationContent()
   * @see #getServCompFrameCountedProtected()
   * @generated
   */
  EAttribute getServCompFrameCountedProtected_ApplicationContent();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected#getDataCRC <em>Data CRC</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data CRC</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected#getDataCRC()
   * @see #getServCompFrameCountedProtected()
   * @generated
   */
  EAttribute getServCompFrameCountedProtected_DataCRC();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected <em>Serv Comp Frame Prioritised Protected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Serv Comp Frame Prioritised Protected</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected
   * @generated
   */
  EClass getServCompFramePrioritisedProtected();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getGroupPriority <em>Group Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Group Priority</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getGroupPriority()
   * @see #getServCompFramePrioritisedProtected()
   * @generated
   */
  EAttribute getServCompFramePrioritisedProtected_GroupPriority();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getApplicationContent <em>Application Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Application Content</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getApplicationContent()
   * @see #getServCompFramePrioritisedProtected()
   * @generated
   */
  EAttribute getServCompFramePrioritisedProtected_ApplicationContent();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getDataCRC <em>Data CRC</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data CRC</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected#getDataCRC()
   * @see #getServCompFramePrioritisedProtected()
   * @generated
   */
  EAttribute getServCompFramePrioritisedProtected_DataCRC();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected <em>Serv Comp Frame Prioritised Counted Protected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Serv Comp Frame Prioritised Counted Protected</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected
   * @generated
   */
  EClass getServCompFramePrioritisedCountedProtected();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected#getGroupPriority <em>Group Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Group Priority</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected#getGroupPriority()
   * @see #getServCompFramePrioritisedCountedProtected()
   * @generated
   */
  EAttribute getServCompFramePrioritisedCountedProtected_GroupPriority();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected#getMessageCount <em>Message Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message Count</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected#getMessageCount()
   * @see #getServCompFramePrioritisedCountedProtected()
   * @generated
   */
  EAttribute getServCompFramePrioritisedCountedProtected_MessageCount();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected#getApplicationContent <em>Application Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Application Content</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected#getApplicationContent()
   * @see #getServCompFramePrioritisedCountedProtected()
   * @generated
   */
  EAttribute getServCompFramePrioritisedCountedProtected_ApplicationContent();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected#getDataCRC <em>Data CRC</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data CRC</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected#getDataCRC()
   * @see #getServCompFramePrioritisedCountedProtected()
   * @generated
   */
  EAttribute getServCompFramePrioritisedCountedProtected_DataCRC();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch <em>MMC Switch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MMC Switch</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch
   * @generated
   */
  EClass getMMCSwitch();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageID <em>Message ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message ID</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageID()
   * @see #getMMCSwitch()
   * @generated
   */
  EAttribute getMMCSwitch_MessageID();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getVersionID <em>Version ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version ID</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getVersionID()
   * @see #getMMCSwitch()
   * @generated
   */
  EAttribute getMMCSwitch_VersionID();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageExpiryTime <em>Message Expiry Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message Expiry Time</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageExpiryTime()
   * @see #getMMCSwitch()
   * @generated
   */
  EAttribute getMMCSwitch_MessageExpiryTime();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#isCancelFlag <em>Cancel Flag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cancel Flag</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#isCancelFlag()
   * @see #getMMCSwitch()
   * @generated
   */
  EAttribute getMMCSwitch_CancelFlag();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageGenerationTime <em>Message Generation Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message Generation Time</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getMessageGenerationTime()
   * @see #getMMCSwitch()
   * @generated
   */
  EAttribute getMMCSwitch_MessageGenerationTime();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getPriority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priority</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch#getPriority()
   * @see #getMMCSwitch()
   * @generated
   */
  EAttribute getMMCSwitch_Priority();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MessageManagementContainer <em>Message Management Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message Management Container</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MessageManagementContainer
   * @generated
   */
  EClass getMessageManagementContainer();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMasterMessage <em>MMC Master Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MMC Master Message</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMasterMessage
   * @generated
   */
  EClass getMMCMasterMessage();

  /**
   * Returns the meta object for the containment reference list '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMasterMessage#getMultiPartMessageDirectory <em>Multi Part Message Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Multi Part Message Directory</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMasterMessage#getMultiPartMessageDirectory()
   * @see #getMMCMasterMessage()
   * @generated
   */
  EReference getMMCMasterMessage_MultiPartMessageDirectory();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory <em>Multi Part Message Directory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multi Part Message Directory</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory
   * @generated
   */
  EClass getMultiPartMessageDirectory();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory#getPartID <em>Part ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Part ID</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory#getPartID()
   * @see #getMultiPartMessageDirectory()
   * @generated
   */
  EAttribute getMultiPartMessageDirectory_PartID();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory#getPartType <em>Part Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Part Type</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory#getPartType()
   * @see #getMultiPartMessageDirectory()
   * @generated
   */
  EAttribute getMultiPartMessageDirectory_PartType();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart <em>MMC Message Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MMC Message Part</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart
   * @generated
   */
  EClass getMMCMessagePart();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getPartID <em>Part ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Part ID</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getPartID()
   * @see #getMMCMessagePart()
   * @generated
   */
  EAttribute getMMCMessagePart_PartID();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getUpdateMode <em>Update Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Update Mode</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getUpdateMode()
   * @see #getMMCMessagePart()
   * @generated
   */
  EAttribute getMMCMessagePart_UpdateMode();

  /**
   * Returns the meta object for the attribute list '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getMasterMessageVersions <em>Master Message Versions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Master Message Versions</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart#getMasterMessageVersions()
   * @see #getMMCMessagePart()
   * @generated
   */
  EAttribute getMMCMessagePart_MasterMessageVersions();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.Method <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.Method
   * @generated
   */
  EClass getMethod();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TPEGLocationReference <em>TPEG Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TPEG Location Reference</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TPEGLocationReference
   * @generated
   */
  EClass getTPEGLocationReference();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.DLR1LocationReference <em>DLR1 Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DLR1 Location Reference</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.DLR1LocationReference
   * @generated
   */
  EClass getDLR1LocationReference();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TMCLocationReference <em>TMC Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TMC Location Reference</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TMCLocationReference
   * @generated
   */
  EClass getTMCLocationReference();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.VICSLinkReference <em>VICS Link Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>VICS Link Reference</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.VICSLinkReference
   * @generated
   */
  EClass getVICSLinkReference();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.KoreanNodeLinkLocationReference <em>Korean Node Link Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Korean Node Link Location Reference</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.KoreanNodeLinkLocationReference
   * @generated
   */
  EClass getKoreanNodeLinkLocationReference();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TETLocationReference <em>TET Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TET Location Reference</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TETLocationReference
   * @generated
   */
  EClass getTETLocationReference();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.GLRLocationReference <em>GLR Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>GLR Location Reference</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.GLRLocationReference
   * @generated
   */
  EClass getGLRLocationReference();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference <em>OLR Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>OLR Location Reference</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference
   * @generated
   */
  EClass getOLRLocationReference();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference#getLocationData <em>Location Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Location Data</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference#getLocationData()
   * @see #getOLRLocationReference()
   * @generated
   */
  EAttribute getOLRLocationReference_LocationData();

  /**
   * Returns the meta object for class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame <em>Time Service Component Frame</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Service Component Frame</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame
   * @generated
   */
  EClass getTimeServiceComponentFrame();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getDate <em>Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Date</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getDate()
   * @see #getTimeServiceComponentFrame()
   * @generated
   */
  EAttribute getTimeServiceComponentFrame_Date();

  /**
   * Returns the meta object for the attribute '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getFormattedDate <em>Formatted Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Formatted Date</em>'.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame#getFormattedDate()
   * @see #getTimeServiceComponentFrame()
   * @generated
   */
  EAttribute getTimeServiceComponentFrame_FormattedDate();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TpegfwktypesFactory getTpegfwktypesFactory();

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
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.LocalisedShortStringImpl <em>Localised Short String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.LocalisedShortStringImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getLocalisedShortString()
     * @generated
     */
    EClass LOCALISED_SHORT_STRING = eINSTANCE.getLocalisedShortString();

    /**
     * The meta object literal for the '<em><b>Language Code</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOCALISED_SHORT_STRING__LANGUAGE_CODE = eINSTANCE.getLocalisedShortString_LanguageCode();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOCALISED_SHORT_STRING__STRING = eINSTANCE.getLocalisedShortString_String();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.LocationReferencingContainerImpl <em>Location Referencing Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.LocationReferencingContainerImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getLocationReferencingContainer()
     * @generated
     */
    EClass LOCATION_REFERENCING_CONTAINER = eINSTANCE.getLocationReferencingContainer();

    /**
     * The meta object literal for the '<em><b>Method</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCATION_REFERENCING_CONTAINER__METHOD = eINSTANCE.getLocationReferencingContainer_Method();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameTemplateImpl <em>Transport Frame Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameTemplateImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTransportFrameTemplate()
     * @generated
     */
    EClass TRANSPORT_FRAME_TEMPLATE = eINSTANCE.getTransportFrameTemplate();

    /**
     * The meta object literal for the '<em><b>Meta Information TODO</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSPORT_FRAME_TEMPLATE__META_INFORMATION_TODO = eINSTANCE.getTransportFrameTemplate_MetaInformationTODO();

    /**
     * The meta object literal for the '<em><b>Sync Word</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSPORT_FRAME_TEMPLATE__SYNC_WORD = eINSTANCE.getTransportFrameTemplate_SyncWord();

    /**
     * The meta object literal for the '<em><b>Field Length</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSPORT_FRAME_TEMPLATE__FIELD_LENGTH = eINSTANCE.getTransportFrameTemplate_FieldLength();

    /**
     * The meta object literal for the '<em><b>Header CRC</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSPORT_FRAME_TEMPLATE__HEADER_CRC = eINSTANCE.getTransportFrameTemplate_HeaderCRC();

    /**
     * The meta object literal for the '<em><b>Frame Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSPORT_FRAME_TEMPLATE__FRAME_TYPE = eINSTANCE.getTransportFrameTemplate_FrameType();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameType0Impl <em>Transport Frame Type0</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameType0Impl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTransportFrameType0()
     * @generated
     */
    EClass TRANSPORT_FRAME_TYPE0 = eINSTANCE.getTransportFrameType0();

    /**
     * The meta object literal for the '<em><b>Transport Frame Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSPORT_FRAME_TYPE0__TRANSPORT_FRAME_CONTENT = eINSTANCE.getTransportFrameType0_TransportFrameContent();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameType1Impl <em>Transport Frame Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TransportFrameType1Impl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTransportFrameType1()
     * @generated
     */
    EClass TRANSPORT_FRAME_TYPE1 = eINSTANCE.getTransportFrameType1();

    /**
     * The meta object literal for the '<em><b>Transport Frame Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT = eINSTANCE.getTransportFrameType1_TransportFrameContent();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceComponentFrameImpl <em>Service Component Frame</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceComponentFrameImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServiceComponentFrame()
     * @generated
     */
    EClass SERVICE_COMPONENT_FRAME = eINSTANCE.getServiceComponentFrame();

    /**
     * The meta object literal for the '<em><b>SCID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERVICE_COMPONENT_FRAME__SCID = eINSTANCE.getServiceComponentFrame_SCID();

    /**
     * The meta object literal for the '<em><b>Field Length</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERVICE_COMPONENT_FRAME__FIELD_LENGTH = eINSTANCE.getServiceComponentFrame_FieldLength();

    /**
     * The meta object literal for the '<em><b>Sc Header CRC</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERVICE_COMPONENT_FRAME__SC_HEADER_CRC = eINSTANCE.getServiceComponentFrame_ScHeaderCRC();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceFrameImpl <em>Service Frame</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceFrameImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServiceFrame()
     * @generated
     */
    EClass SERVICE_FRAME = eINSTANCE.getServiceFrame();

    /**
     * The meta object literal for the '<em><b>Serv Enc ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERVICE_FRAME__SERV_ENC_ID = eINSTANCE.getServiceFrame_ServEncID();

    /**
     * The meta object literal for the '<em><b>Service Frame Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERVICE_FRAME__SERVICE_FRAME_CONTENT = eINSTANCE.getServiceFrame_ServiceFrameContent();

    /**
     * The meta object literal for the '<em><b>SID</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERVICE_FRAME__SID = eINSTANCE.getServiceFrame_SID();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.StreamDirectoryFrameImpl <em>Stream Directory Frame</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.StreamDirectoryFrameImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getStreamDirectoryFrame()
     * @generated
     */
    EClass STREAM_DIRECTORY_FRAME = eINSTANCE.getStreamDirectoryFrame();

    /**
     * The meta object literal for the '<em><b>SID</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STREAM_DIRECTORY_FRAME__SID = eINSTANCE.getStreamDirectoryFrame_SID();

    /**
     * The meta object literal for the '<em><b>Number Of Services</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STREAM_DIRECTORY_FRAME__NUMBER_OF_SERVICES = eINSTANCE.getStreamDirectoryFrame_NumberOfServices();

    /**
     * The meta object literal for the '<em><b>Header CRC</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STREAM_DIRECTORY_FRAME__HEADER_CRC = eINSTANCE.getStreamDirectoryFrame_HeaderCRC();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompMultiplexImpl <em>Serv Comp Multiplex</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompMultiplexImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServCompMultiplex()
     * @generated
     */
    EClass SERV_COMP_MULTIPLEX = eINSTANCE.getServCompMultiplex();

    /**
     * The meta object literal for the '<em><b>Multiplex Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERV_COMP_MULTIPLEX__MULTIPLEX_CONTENT = eINSTANCE.getServCompMultiplex_MultiplexContent();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceIdentifierImpl <em>Service Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServiceIdentifierImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServiceIdentifier()
     * @generated
     */
    EClass SERVICE_IDENTIFIER = eINSTANCE.getServiceIdentifier();

    /**
     * The meta object literal for the '<em><b>Sid A</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERVICE_IDENTIFIER__SID_A = eINSTANCE.getServiceIdentifier_SidA();

    /**
     * The meta object literal for the '<em><b>Sid B</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERVICE_IDENTIFIER__SID_B = eINSTANCE.getServiceIdentifier_SidB();

    /**
     * The meta object literal for the '<em><b>Sid C</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERVICE_IDENTIFIER__SID_C = eINSTANCE.getServiceIdentifier_SidC();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFrameProtectedImpl <em>Serv Comp Frame Protected</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFrameProtectedImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServCompFrameProtected()
     * @generated
     */
    EClass SERV_COMP_FRAME_PROTECTED = eINSTANCE.getServCompFrameProtected();

    /**
     * The meta object literal for the '<em><b>Application Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_PROTECTED__APPLICATION_CONTENT = eINSTANCE.getServCompFrameProtected_ApplicationContent();

    /**
     * The meta object literal for the '<em><b>Data CRC</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_PROTECTED__DATA_CRC = eINSTANCE.getServCompFrameProtected_DataCRC();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFrameCountedProtectedImpl <em>Serv Comp Frame Counted Protected</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFrameCountedProtectedImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServCompFrameCountedProtected()
     * @generated
     */
    EClass SERV_COMP_FRAME_COUNTED_PROTECTED = eINSTANCE.getServCompFrameCountedProtected();

    /**
     * The meta object literal for the '<em><b>Message Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_COUNTED_PROTECTED__MESSAGE_COUNT = eINSTANCE.getServCompFrameCountedProtected_MessageCount();

    /**
     * The meta object literal for the '<em><b>Application Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_COUNTED_PROTECTED__APPLICATION_CONTENT = eINSTANCE.getServCompFrameCountedProtected_ApplicationContent();

    /**
     * The meta object literal for the '<em><b>Data CRC</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_COUNTED_PROTECTED__DATA_CRC = eINSTANCE.getServCompFrameCountedProtected_DataCRC();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedProtectedImpl <em>Serv Comp Frame Prioritised Protected</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedProtectedImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServCompFramePrioritisedProtected()
     * @generated
     */
    EClass SERV_COMP_FRAME_PRIORITISED_PROTECTED = eINSTANCE.getServCompFramePrioritisedProtected();

    /**
     * The meta object literal for the '<em><b>Group Priority</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_PRIORITISED_PROTECTED__GROUP_PRIORITY = eINSTANCE.getServCompFramePrioritisedProtected_GroupPriority();

    /**
     * The meta object literal for the '<em><b>Application Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_PRIORITISED_PROTECTED__APPLICATION_CONTENT = eINSTANCE.getServCompFramePrioritisedProtected_ApplicationContent();

    /**
     * The meta object literal for the '<em><b>Data CRC</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_PRIORITISED_PROTECTED__DATA_CRC = eINSTANCE.getServCompFramePrioritisedProtected_DataCRC();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedCountedProtectedImpl <em>Serv Comp Frame Prioritised Counted Protected</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.ServCompFramePrioritisedCountedProtectedImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getServCompFramePrioritisedCountedProtected()
     * @generated
     */
    EClass SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED = eINSTANCE.getServCompFramePrioritisedCountedProtected();

    /**
     * The meta object literal for the '<em><b>Group Priority</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__GROUP_PRIORITY = eINSTANCE.getServCompFramePrioritisedCountedProtected_GroupPriority();

    /**
     * The meta object literal for the '<em><b>Message Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__MESSAGE_COUNT = eINSTANCE.getServCompFramePrioritisedCountedProtected_MessageCount();

    /**
     * The meta object literal for the '<em><b>Application Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__APPLICATION_CONTENT = eINSTANCE.getServCompFramePrioritisedCountedProtected_ApplicationContent();

    /**
     * The meta object literal for the '<em><b>Data CRC</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__DATA_CRC = eINSTANCE.getServCompFramePrioritisedCountedProtected_DataCRC();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCSwitchImpl <em>MMC Switch</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCSwitchImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMMCSwitch()
     * @generated
     */
    EClass MMC_SWITCH = eINSTANCE.getMMCSwitch();

    /**
     * The meta object literal for the '<em><b>Message ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MMC_SWITCH__MESSAGE_ID = eINSTANCE.getMMCSwitch_MessageID();

    /**
     * The meta object literal for the '<em><b>Version ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MMC_SWITCH__VERSION_ID = eINSTANCE.getMMCSwitch_VersionID();

    /**
     * The meta object literal for the '<em><b>Message Expiry Time</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MMC_SWITCH__MESSAGE_EXPIRY_TIME = eINSTANCE.getMMCSwitch_MessageExpiryTime();

    /**
     * The meta object literal for the '<em><b>Cancel Flag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MMC_SWITCH__CANCEL_FLAG = eINSTANCE.getMMCSwitch_CancelFlag();

    /**
     * The meta object literal for the '<em><b>Message Generation Time</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MMC_SWITCH__MESSAGE_GENERATION_TIME = eINSTANCE.getMMCSwitch_MessageGenerationTime();

    /**
     * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MMC_SWITCH__PRIORITY = eINSTANCE.getMMCSwitch_Priority();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MessageManagementContainerImpl <em>Message Management Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MessageManagementContainerImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMessageManagementContainer()
     * @generated
     */
    EClass MESSAGE_MANAGEMENT_CONTAINER = eINSTANCE.getMessageManagementContainer();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMasterMessageImpl <em>MMC Master Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMasterMessageImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMMCMasterMessage()
     * @generated
     */
    EClass MMC_MASTER_MESSAGE = eINSTANCE.getMMCMasterMessage();

    /**
     * The meta object literal for the '<em><b>Multi Part Message Directory</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MMC_MASTER_MESSAGE__MULTI_PART_MESSAGE_DIRECTORY = eINSTANCE.getMMCMasterMessage_MultiPartMessageDirectory();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MultiPartMessageDirectoryImpl <em>Multi Part Message Directory</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MultiPartMessageDirectoryImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMultiPartMessageDirectory()
     * @generated
     */
    EClass MULTI_PART_MESSAGE_DIRECTORY = eINSTANCE.getMultiPartMessageDirectory();

    /**
     * The meta object literal for the '<em><b>Part ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTI_PART_MESSAGE_DIRECTORY__PART_ID = eINSTANCE.getMultiPartMessageDirectory_PartID();

    /**
     * The meta object literal for the '<em><b>Part Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTI_PART_MESSAGE_DIRECTORY__PART_TYPE = eINSTANCE.getMultiPartMessageDirectory_PartType();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMessagePartImpl <em>MMC Message Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MMCMessagePartImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMMCMessagePart()
     * @generated
     */
    EClass MMC_MESSAGE_PART = eINSTANCE.getMMCMessagePart();

    /**
     * The meta object literal for the '<em><b>Part ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MMC_MESSAGE_PART__PART_ID = eINSTANCE.getMMCMessagePart_PartID();

    /**
     * The meta object literal for the '<em><b>Update Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MMC_MESSAGE_PART__UPDATE_MODE = eINSTANCE.getMMCMessagePart_UpdateMode();

    /**
     * The meta object literal for the '<em><b>Master Message Versions</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MMC_MESSAGE_PART__MASTER_MESSAGE_VERSIONS = eINSTANCE.getMMCMessagePart_MasterMessageVersions();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MethodImpl <em>Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.MethodImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getMethod()
     * @generated
     */
    EClass METHOD = eINSTANCE.getMethod();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TPEGLocationReferenceImpl <em>TPEG Location Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TPEGLocationReferenceImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTPEGLocationReference()
     * @generated
     */
    EClass TPEG_LOCATION_REFERENCE = eINSTANCE.getTPEGLocationReference();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.DLR1LocationReferenceImpl <em>DLR1 Location Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.DLR1LocationReferenceImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getDLR1LocationReference()
     * @generated
     */
    EClass DLR1_LOCATION_REFERENCE = eINSTANCE.getDLR1LocationReference();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TMCLocationReferenceImpl <em>TMC Location Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TMCLocationReferenceImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTMCLocationReference()
     * @generated
     */
    EClass TMC_LOCATION_REFERENCE = eINSTANCE.getTMCLocationReference();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.VICSLinkReferenceImpl <em>VICS Link Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.VICSLinkReferenceImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getVICSLinkReference()
     * @generated
     */
    EClass VICS_LINK_REFERENCE = eINSTANCE.getVICSLinkReference();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.KoreanNodeLinkLocationReferenceImpl <em>Korean Node Link Location Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.KoreanNodeLinkLocationReferenceImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getKoreanNodeLinkLocationReference()
     * @generated
     */
    EClass KOREAN_NODE_LINK_LOCATION_REFERENCE = eINSTANCE.getKoreanNodeLinkLocationReference();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TETLocationReferenceImpl <em>TET Location Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TETLocationReferenceImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTETLocationReference()
     * @generated
     */
    EClass TET_LOCATION_REFERENCE = eINSTANCE.getTETLocationReference();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.GLRLocationReferenceImpl <em>GLR Location Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.GLRLocationReferenceImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getGLRLocationReference()
     * @generated
     */
    EClass GLR_LOCATION_REFERENCE = eINSTANCE.getGLRLocationReference();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.OLRLocationReferenceImpl <em>OLR Location Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.OLRLocationReferenceImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getOLRLocationReference()
     * @generated
     */
    EClass OLR_LOCATION_REFERENCE = eINSTANCE.getOLRLocationReference();

    /**
     * The meta object literal for the '<em><b>Location Data</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OLR_LOCATION_REFERENCE__LOCATION_DATA = eINSTANCE.getOLRLocationReference_LocationData();

    /**
     * The meta object literal for the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TimeServiceComponentFrameImpl <em>Time Service Component Frame</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TimeServiceComponentFrameImpl
     * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesPackageImpl#getTimeServiceComponentFrame()
     * @generated
     */
    EClass TIME_SERVICE_COMPONENT_FRAME = eINSTANCE.getTimeServiceComponentFrame();

    /**
     * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_SERVICE_COMPONENT_FRAME__DATE = eINSTANCE.getTimeServiceComponentFrame_Date();

    /**
     * The meta object literal for the '<em><b>Formatted Date</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_SERVICE_COMPONENT_FRAME__FORMATTED_DATE = eINSTANCE.getTimeServiceComponentFrame_FormattedDate();

  }

} //TpegfwktypesPackage
