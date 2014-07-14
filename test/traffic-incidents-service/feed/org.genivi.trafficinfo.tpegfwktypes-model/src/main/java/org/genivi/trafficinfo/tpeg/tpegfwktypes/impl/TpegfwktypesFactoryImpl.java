/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TpegfwktypesFactoryImpl extends EFactoryImpl implements TpegfwktypesFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TpegfwktypesFactory init() {
    try {
      TpegfwktypesFactory theTpegfwktypesFactory = (TpegfwktypesFactory)EPackage.Registry.INSTANCE.getEFactory(TpegfwktypesPackage.eNS_URI);
      if (theTpegfwktypesFactory != null) {
        return theTpegfwktypesFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TpegfwktypesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TpegfwktypesFactoryImpl() {
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
      case TpegfwktypesPackage.LOCALISED_SHORT_STRING: return createLocalisedShortString();
      case TpegfwktypesPackage.LOCATION_REFERENCING_CONTAINER: return createLocationReferencingContainer();
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE: return createTransportFrameTemplate();
      case TpegfwktypesPackage.TRANSPORT_FRAME_TYPE0: return createTransportFrameType0();
      case TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1: return createTransportFrameType1();
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME: return createServiceComponentFrame();
      case TpegfwktypesPackage.SERVICE_FRAME: return createServiceFrame();
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME: return createStreamDirectoryFrame();
      case TpegfwktypesPackage.SERV_COMP_MULTIPLEX: return createServCompMultiplex();
      case TpegfwktypesPackage.SERVICE_IDENTIFIER: return createServiceIdentifier();
      case TpegfwktypesPackage.SERV_COMP_FRAME_PROTECTED: return createServCompFrameProtected();
      case TpegfwktypesPackage.SERV_COMP_FRAME_COUNTED_PROTECTED: return createServCompFrameCountedProtected();
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED: return createServCompFramePrioritisedProtected();
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED: return createServCompFramePrioritisedCountedProtected();
      case TpegfwktypesPackage.MMC_SWITCH: return createMMCSwitch();
      case TpegfwktypesPackage.MESSAGE_MANAGEMENT_CONTAINER: return createMessageManagementContainer();
      case TpegfwktypesPackage.MMC_MASTER_MESSAGE: return createMMCMasterMessage();
      case TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY: return createMultiPartMessageDirectory();
      case TpegfwktypesPackage.MMC_MESSAGE_PART: return createMMCMessagePart();
      case TpegfwktypesPackage.METHOD: return createMethod();
      case TpegfwktypesPackage.TPEG_LOCATION_REFERENCE: return createTPEGLocationReference();
      case TpegfwktypesPackage.DLR1_LOCATION_REFERENCE: return createDLR1LocationReference();
      case TpegfwktypesPackage.TMC_LOCATION_REFERENCE: return createTMCLocationReference();
      case TpegfwktypesPackage.VICS_LINK_REFERENCE: return createVICSLinkReference();
      case TpegfwktypesPackage.KOREAN_NODE_LINK_LOCATION_REFERENCE: return createKoreanNodeLinkLocationReference();
      case TpegfwktypesPackage.TET_LOCATION_REFERENCE: return createTETLocationReference();
      case TpegfwktypesPackage.GLR_LOCATION_REFERENCE: return createGLRLocationReference();
      case TpegfwktypesPackage.OLR_LOCATION_REFERENCE: return createOLRLocationReference();
      case TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME: return createTimeServiceComponentFrame();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalisedShortString createLocalisedShortString() {
    LocalisedShortStringImpl localisedShortString = new LocalisedShortStringImpl();
    return localisedShortString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocationReferencingContainer createLocationReferencingContainer() {
    LocationReferencingContainerImpl locationReferencingContainer = new LocationReferencingContainerImpl();
    return locationReferencingContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransportFrameTemplate createTransportFrameTemplate() {
    TransportFrameTemplateImpl transportFrameTemplate = new TransportFrameTemplateImpl();
    return transportFrameTemplate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransportFrameType0 createTransportFrameType0() {
    TransportFrameType0Impl transportFrameType0 = new TransportFrameType0Impl();
    return transportFrameType0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransportFrameType1 createTransportFrameType1() {
    TransportFrameType1Impl transportFrameType1 = new TransportFrameType1Impl();
    return transportFrameType1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceComponentFrame createServiceComponentFrame() {
    ServiceComponentFrameImpl serviceComponentFrame = new ServiceComponentFrameImpl();
    return serviceComponentFrame;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceFrame createServiceFrame() {
    ServiceFrameImpl serviceFrame = new ServiceFrameImpl();
    return serviceFrame;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StreamDirectoryFrame createStreamDirectoryFrame() {
    StreamDirectoryFrameImpl streamDirectoryFrame = new StreamDirectoryFrameImpl();
    return streamDirectoryFrame;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServCompMultiplex createServCompMultiplex() {
    ServCompMultiplexImpl servCompMultiplex = new ServCompMultiplexImpl();
    return servCompMultiplex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceIdentifier createServiceIdentifier() {
    ServiceIdentifierImpl serviceIdentifier = new ServiceIdentifierImpl();
    return serviceIdentifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServCompFrameProtected createServCompFrameProtected() {
    ServCompFrameProtectedImpl servCompFrameProtected = new ServCompFrameProtectedImpl();
    return servCompFrameProtected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServCompFrameCountedProtected createServCompFrameCountedProtected() {
    ServCompFrameCountedProtectedImpl servCompFrameCountedProtected = new ServCompFrameCountedProtectedImpl();
    return servCompFrameCountedProtected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServCompFramePrioritisedProtected createServCompFramePrioritisedProtected() {
    ServCompFramePrioritisedProtectedImpl servCompFramePrioritisedProtected = new ServCompFramePrioritisedProtectedImpl();
    return servCompFramePrioritisedProtected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServCompFramePrioritisedCountedProtected createServCompFramePrioritisedCountedProtected() {
    ServCompFramePrioritisedCountedProtectedImpl servCompFramePrioritisedCountedProtected = new ServCompFramePrioritisedCountedProtectedImpl();
    return servCompFramePrioritisedCountedProtected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MMCSwitch createMMCSwitch() {
    MMCSwitchImpl mmcSwitch = new MMCSwitchImpl();
    return mmcSwitch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageManagementContainer createMessageManagementContainer() {
    MessageManagementContainerImpl messageManagementContainer = new MessageManagementContainerImpl();
    return messageManagementContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MMCMasterMessage createMMCMasterMessage() {
    MMCMasterMessageImpl mmcMasterMessage = new MMCMasterMessageImpl();
    return mmcMasterMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiPartMessageDirectory createMultiPartMessageDirectory() {
    MultiPartMessageDirectoryImpl multiPartMessageDirectory = new MultiPartMessageDirectoryImpl();
    return multiPartMessageDirectory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MMCMessagePart createMMCMessagePart() {
    MMCMessagePartImpl mmcMessagePart = new MMCMessagePartImpl();
    return mmcMessagePart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Method createMethod() {
    MethodImpl method = new MethodImpl();
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TPEGLocationReference createTPEGLocationReference() {
    TPEGLocationReferenceImpl tpegLocationReference = new TPEGLocationReferenceImpl();
    return tpegLocationReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DLR1LocationReference createDLR1LocationReference() {
    DLR1LocationReferenceImpl dlr1LocationReference = new DLR1LocationReferenceImpl();
    return dlr1LocationReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TMCLocationReference createTMCLocationReference() {
    TMCLocationReferenceImpl tmcLocationReference = new TMCLocationReferenceImpl();
    return tmcLocationReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VICSLinkReference createVICSLinkReference() {
    VICSLinkReferenceImpl vicsLinkReference = new VICSLinkReferenceImpl();
    return vicsLinkReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KoreanNodeLinkLocationReference createKoreanNodeLinkLocationReference() {
    KoreanNodeLinkLocationReferenceImpl koreanNodeLinkLocationReference = new KoreanNodeLinkLocationReferenceImpl();
    return koreanNodeLinkLocationReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TETLocationReference createTETLocationReference() {
    TETLocationReferenceImpl tetLocationReference = new TETLocationReferenceImpl();
    return tetLocationReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GLRLocationReference createGLRLocationReference() {
    GLRLocationReferenceImpl glrLocationReference = new GLRLocationReferenceImpl();
    return glrLocationReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OLRLocationReference createOLRLocationReference() {
    OLRLocationReferenceImpl olrLocationReference = new OLRLocationReferenceImpl();
    return olrLocationReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeServiceComponentFrame createTimeServiceComponentFrame() {
    TimeServiceComponentFrameImpl timeServiceComponentFrame = new TimeServiceComponentFrameImpl();
    return timeServiceComponentFrame;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TpegfwktypesPackage getTpegfwktypesPackage() {
    return (TpegfwktypesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TpegfwktypesPackage getPackage() {
    return TpegfwktypesPackage.eINSTANCE;
  }

} //TpegfwktypesFactoryImpl
