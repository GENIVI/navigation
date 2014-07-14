/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes.impl;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.DLR1LocationReference;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.GLRLocationReference;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.KoreanNodeLinkLocationReference;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMasterMessage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MessageManagementContainer;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.Method;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameProtected;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TETLocationReference;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TMCLocationReference;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TPEGLocationReference;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesFactory;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType0;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType1;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.VICSLinkReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TpegfwktypesPackageImpl extends EPackageImpl implements TpegfwktypesPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localisedShortStringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass locationReferencingContainerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transportFrameTemplateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transportFrameType0EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transportFrameType1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass serviceComponentFrameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass serviceFrameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass streamDirectoryFrameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass servCompMultiplexEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass serviceIdentifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass servCompFrameProtectedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass servCompFrameCountedProtectedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass servCompFramePrioritisedProtectedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass servCompFramePrioritisedCountedProtectedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mmcSwitchEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass messageManagementContainerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mmcMasterMessageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiPartMessageDirectoryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mmcMessagePartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tpegLocationReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dlr1LocationReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tmcLocationReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vicsLinkReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass koreanNodeLinkLocationReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tetLocationReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass glrLocationReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass olrLocationReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeServiceComponentFrameEClass = null;

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
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TpegfwktypesPackageImpl() {
    super(eNS_URI, TpegfwktypesFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link TpegfwktypesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TpegfwktypesPackage init() {
    if (isInited) return (TpegfwktypesPackage)EPackage.Registry.INSTANCE.getEPackage(TpegfwktypesPackage.eNS_URI);

    // Obtain or create and register package
    TpegfwktypesPackageImpl theTpegfwktypesPackage = (TpegfwktypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TpegfwktypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TpegfwktypesPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theTpegfwktypesPackage.createPackageContents();

    // Initialize created meta-data
    theTpegfwktypesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTpegfwktypesPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TpegfwktypesPackage.eNS_URI, theTpegfwktypesPackage);
    return theTpegfwktypesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocalisedShortString() {
    return localisedShortStringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLocalisedShortString_LanguageCode() {
    return (EAttribute)localisedShortStringEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLocalisedShortString_String() {
    return (EAttribute)localisedShortStringEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocationReferencingContainer() {
    return locationReferencingContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocationReferencingContainer_Method() {
    return (EReference)locationReferencingContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransportFrameTemplate() {
    return transportFrameTemplateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransportFrameTemplate_MetaInformationTODO() {
    return (EAttribute)transportFrameTemplateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransportFrameTemplate_SyncWord() {
    return (EAttribute)transportFrameTemplateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransportFrameTemplate_FieldLength() {
    return (EAttribute)transportFrameTemplateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransportFrameTemplate_HeaderCRC() {
    return (EAttribute)transportFrameTemplateEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransportFrameTemplate_FrameType() {
    return (EAttribute)transportFrameTemplateEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransportFrameType0() {
    return transportFrameType0EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransportFrameType0_TransportFrameContent() {
    return (EReference)transportFrameType0EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransportFrameType1() {
    return transportFrameType1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransportFrameType1_TransportFrameContent() {
    return (EReference)transportFrameType1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServiceComponentFrame() {
    return serviceComponentFrameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServiceComponentFrame_SCID() {
    return (EAttribute)serviceComponentFrameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServiceComponentFrame_FieldLength() {
    return (EAttribute)serviceComponentFrameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServiceComponentFrame_ScHeaderCRC() {
    return (EAttribute)serviceComponentFrameEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServiceFrame() {
    return serviceFrameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServiceFrame_ServEncID() {
    return (EAttribute)serviceFrameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getServiceFrame_ServiceFrameContent() {
    return (EReference)serviceFrameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getServiceFrame_SID() {
    return (EReference)serviceFrameEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStreamDirectoryFrame() {
    return streamDirectoryFrameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStreamDirectoryFrame_SID() {
    return (EReference)streamDirectoryFrameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStreamDirectoryFrame_NumberOfServices() {
    return (EAttribute)streamDirectoryFrameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStreamDirectoryFrame_HeaderCRC() {
    return (EAttribute)streamDirectoryFrameEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServCompMultiplex() {
    return servCompMultiplexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getServCompMultiplex_MultiplexContent() {
    return (EReference)servCompMultiplexEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServiceIdentifier() {
    return serviceIdentifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServiceIdentifier_SidA() {
    return (EAttribute)serviceIdentifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServiceIdentifier_SidB() {
    return (EAttribute)serviceIdentifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServiceIdentifier_SidC() {
    return (EAttribute)serviceIdentifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServCompFrameProtected() {
    return servCompFrameProtectedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFrameProtected_ApplicationContent() {
    return (EAttribute)servCompFrameProtectedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFrameProtected_DataCRC() {
    return (EAttribute)servCompFrameProtectedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServCompFrameCountedProtected() {
    return servCompFrameCountedProtectedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFrameCountedProtected_MessageCount() {
    return (EAttribute)servCompFrameCountedProtectedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFrameCountedProtected_ApplicationContent() {
    return (EAttribute)servCompFrameCountedProtectedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFrameCountedProtected_DataCRC() {
    return (EAttribute)servCompFrameCountedProtectedEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServCompFramePrioritisedProtected() {
    return servCompFramePrioritisedProtectedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFramePrioritisedProtected_GroupPriority() {
    return (EAttribute)servCompFramePrioritisedProtectedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFramePrioritisedProtected_ApplicationContent() {
    return (EAttribute)servCompFramePrioritisedProtectedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFramePrioritisedProtected_DataCRC() {
    return (EAttribute)servCompFramePrioritisedProtectedEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServCompFramePrioritisedCountedProtected() {
    return servCompFramePrioritisedCountedProtectedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFramePrioritisedCountedProtected_GroupPriority() {
    return (EAttribute)servCompFramePrioritisedCountedProtectedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFramePrioritisedCountedProtected_MessageCount() {
    return (EAttribute)servCompFramePrioritisedCountedProtectedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFramePrioritisedCountedProtected_ApplicationContent() {
    return (EAttribute)servCompFramePrioritisedCountedProtectedEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getServCompFramePrioritisedCountedProtected_DataCRC() {
    return (EAttribute)servCompFramePrioritisedCountedProtectedEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMMCSwitch() {
    return mmcSwitchEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMCSwitch_MessageID() {
    return (EAttribute)mmcSwitchEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMCSwitch_VersionID() {
    return (EAttribute)mmcSwitchEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMCSwitch_MessageExpiryTime() {
    return (EAttribute)mmcSwitchEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMCSwitch_CancelFlag() {
    return (EAttribute)mmcSwitchEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMCSwitch_MessageGenerationTime() {
    return (EAttribute)mmcSwitchEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMCSwitch_Priority() {
    return (EAttribute)mmcSwitchEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMessageManagementContainer() {
    return messageManagementContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMMCMasterMessage() {
    return mmcMasterMessageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMMCMasterMessage_MultiPartMessageDirectory() {
    return (EReference)mmcMasterMessageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiPartMessageDirectory() {
    return multiPartMessageDirectoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiPartMessageDirectory_PartID() {
    return (EAttribute)multiPartMessageDirectoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiPartMessageDirectory_PartType() {
    return (EAttribute)multiPartMessageDirectoryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMMCMessagePart() {
    return mmcMessagePartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMCMessagePart_PartID() {
    return (EAttribute)mmcMessagePartEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMCMessagePart_UpdateMode() {
    return (EAttribute)mmcMessagePartEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMCMessagePart_MasterMessageVersions() {
    return (EAttribute)mmcMessagePartEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethod() {
    return methodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTPEGLocationReference() {
    return tpegLocationReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDLR1LocationReference() {
    return dlr1LocationReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTMCLocationReference() {
    return tmcLocationReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVICSLinkReference() {
    return vicsLinkReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKoreanNodeLinkLocationReference() {
    return koreanNodeLinkLocationReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTETLocationReference() {
    return tetLocationReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGLRLocationReference() {
    return glrLocationReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOLRLocationReference() {
    return olrLocationReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOLRLocationReference_LocationData() {
    return (EAttribute)olrLocationReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeServiceComponentFrame() {
    return timeServiceComponentFrameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeServiceComponentFrame_Date() {
    return (EAttribute)timeServiceComponentFrameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeServiceComponentFrame_FormattedDate() {
    return (EAttribute)timeServiceComponentFrameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TpegfwktypesFactory getTpegfwktypesFactory() {
    return (TpegfwktypesFactory)getEFactoryInstance();
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
    localisedShortStringEClass = createEClass(LOCALISED_SHORT_STRING);
    createEAttribute(localisedShortStringEClass, LOCALISED_SHORT_STRING__LANGUAGE_CODE);
    createEAttribute(localisedShortStringEClass, LOCALISED_SHORT_STRING__STRING);

    locationReferencingContainerEClass = createEClass(LOCATION_REFERENCING_CONTAINER);
    createEReference(locationReferencingContainerEClass, LOCATION_REFERENCING_CONTAINER__METHOD);

    transportFrameTemplateEClass = createEClass(TRANSPORT_FRAME_TEMPLATE);
    createEAttribute(transportFrameTemplateEClass, TRANSPORT_FRAME_TEMPLATE__META_INFORMATION_TODO);
    createEAttribute(transportFrameTemplateEClass, TRANSPORT_FRAME_TEMPLATE__SYNC_WORD);
    createEAttribute(transportFrameTemplateEClass, TRANSPORT_FRAME_TEMPLATE__FIELD_LENGTH);
    createEAttribute(transportFrameTemplateEClass, TRANSPORT_FRAME_TEMPLATE__HEADER_CRC);
    createEAttribute(transportFrameTemplateEClass, TRANSPORT_FRAME_TEMPLATE__FRAME_TYPE);

    transportFrameType0EClass = createEClass(TRANSPORT_FRAME_TYPE0);
    createEReference(transportFrameType0EClass, TRANSPORT_FRAME_TYPE0__TRANSPORT_FRAME_CONTENT);

    transportFrameType1EClass = createEClass(TRANSPORT_FRAME_TYPE1);
    createEReference(transportFrameType1EClass, TRANSPORT_FRAME_TYPE1__TRANSPORT_FRAME_CONTENT);

    serviceComponentFrameEClass = createEClass(SERVICE_COMPONENT_FRAME);
    createEAttribute(serviceComponentFrameEClass, SERVICE_COMPONENT_FRAME__SCID);
    createEAttribute(serviceComponentFrameEClass, SERVICE_COMPONENT_FRAME__FIELD_LENGTH);
    createEAttribute(serviceComponentFrameEClass, SERVICE_COMPONENT_FRAME__SC_HEADER_CRC);

    serviceFrameEClass = createEClass(SERVICE_FRAME);
    createEAttribute(serviceFrameEClass, SERVICE_FRAME__SERV_ENC_ID);
    createEReference(serviceFrameEClass, SERVICE_FRAME__SERVICE_FRAME_CONTENT);
    createEReference(serviceFrameEClass, SERVICE_FRAME__SID);

    streamDirectoryFrameEClass = createEClass(STREAM_DIRECTORY_FRAME);
    createEReference(streamDirectoryFrameEClass, STREAM_DIRECTORY_FRAME__SID);
    createEAttribute(streamDirectoryFrameEClass, STREAM_DIRECTORY_FRAME__NUMBER_OF_SERVICES);
    createEAttribute(streamDirectoryFrameEClass, STREAM_DIRECTORY_FRAME__HEADER_CRC);

    servCompMultiplexEClass = createEClass(SERV_COMP_MULTIPLEX);
    createEReference(servCompMultiplexEClass, SERV_COMP_MULTIPLEX__MULTIPLEX_CONTENT);

    serviceIdentifierEClass = createEClass(SERVICE_IDENTIFIER);
    createEAttribute(serviceIdentifierEClass, SERVICE_IDENTIFIER__SID_A);
    createEAttribute(serviceIdentifierEClass, SERVICE_IDENTIFIER__SID_B);
    createEAttribute(serviceIdentifierEClass, SERVICE_IDENTIFIER__SID_C);

    servCompFrameProtectedEClass = createEClass(SERV_COMP_FRAME_PROTECTED);
    createEAttribute(servCompFrameProtectedEClass, SERV_COMP_FRAME_PROTECTED__APPLICATION_CONTENT);
    createEAttribute(servCompFrameProtectedEClass, SERV_COMP_FRAME_PROTECTED__DATA_CRC);

    servCompFrameCountedProtectedEClass = createEClass(SERV_COMP_FRAME_COUNTED_PROTECTED);
    createEAttribute(servCompFrameCountedProtectedEClass, SERV_COMP_FRAME_COUNTED_PROTECTED__MESSAGE_COUNT);
    createEAttribute(servCompFrameCountedProtectedEClass, SERV_COMP_FRAME_COUNTED_PROTECTED__APPLICATION_CONTENT);
    createEAttribute(servCompFrameCountedProtectedEClass, SERV_COMP_FRAME_COUNTED_PROTECTED__DATA_CRC);

    servCompFramePrioritisedProtectedEClass = createEClass(SERV_COMP_FRAME_PRIORITISED_PROTECTED);
    createEAttribute(servCompFramePrioritisedProtectedEClass, SERV_COMP_FRAME_PRIORITISED_PROTECTED__GROUP_PRIORITY);
    createEAttribute(servCompFramePrioritisedProtectedEClass, SERV_COMP_FRAME_PRIORITISED_PROTECTED__APPLICATION_CONTENT);
    createEAttribute(servCompFramePrioritisedProtectedEClass, SERV_COMP_FRAME_PRIORITISED_PROTECTED__DATA_CRC);

    servCompFramePrioritisedCountedProtectedEClass = createEClass(SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED);
    createEAttribute(servCompFramePrioritisedCountedProtectedEClass, SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__GROUP_PRIORITY);
    createEAttribute(servCompFramePrioritisedCountedProtectedEClass, SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__MESSAGE_COUNT);
    createEAttribute(servCompFramePrioritisedCountedProtectedEClass, SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__APPLICATION_CONTENT);
    createEAttribute(servCompFramePrioritisedCountedProtectedEClass, SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED__DATA_CRC);

    mmcSwitchEClass = createEClass(MMC_SWITCH);
    createEAttribute(mmcSwitchEClass, MMC_SWITCH__MESSAGE_ID);
    createEAttribute(mmcSwitchEClass, MMC_SWITCH__VERSION_ID);
    createEAttribute(mmcSwitchEClass, MMC_SWITCH__MESSAGE_EXPIRY_TIME);
    createEAttribute(mmcSwitchEClass, MMC_SWITCH__CANCEL_FLAG);
    createEAttribute(mmcSwitchEClass, MMC_SWITCH__MESSAGE_GENERATION_TIME);
    createEAttribute(mmcSwitchEClass, MMC_SWITCH__PRIORITY);

    messageManagementContainerEClass = createEClass(MESSAGE_MANAGEMENT_CONTAINER);

    mmcMasterMessageEClass = createEClass(MMC_MASTER_MESSAGE);
    createEReference(mmcMasterMessageEClass, MMC_MASTER_MESSAGE__MULTI_PART_MESSAGE_DIRECTORY);

    multiPartMessageDirectoryEClass = createEClass(MULTI_PART_MESSAGE_DIRECTORY);
    createEAttribute(multiPartMessageDirectoryEClass, MULTI_PART_MESSAGE_DIRECTORY__PART_ID);
    createEAttribute(multiPartMessageDirectoryEClass, MULTI_PART_MESSAGE_DIRECTORY__PART_TYPE);

    mmcMessagePartEClass = createEClass(MMC_MESSAGE_PART);
    createEAttribute(mmcMessagePartEClass, MMC_MESSAGE_PART__PART_ID);
    createEAttribute(mmcMessagePartEClass, MMC_MESSAGE_PART__UPDATE_MODE);
    createEAttribute(mmcMessagePartEClass, MMC_MESSAGE_PART__MASTER_MESSAGE_VERSIONS);

    methodEClass = createEClass(METHOD);

    tpegLocationReferenceEClass = createEClass(TPEG_LOCATION_REFERENCE);

    dlr1LocationReferenceEClass = createEClass(DLR1_LOCATION_REFERENCE);

    tmcLocationReferenceEClass = createEClass(TMC_LOCATION_REFERENCE);

    vicsLinkReferenceEClass = createEClass(VICS_LINK_REFERENCE);

    koreanNodeLinkLocationReferenceEClass = createEClass(KOREAN_NODE_LINK_LOCATION_REFERENCE);

    tetLocationReferenceEClass = createEClass(TET_LOCATION_REFERENCE);

    glrLocationReferenceEClass = createEClass(GLR_LOCATION_REFERENCE);

    olrLocationReferenceEClass = createEClass(OLR_LOCATION_REFERENCE);
    createEAttribute(olrLocationReferenceEClass, OLR_LOCATION_REFERENCE__LOCATION_DATA);

    timeServiceComponentFrameEClass = createEClass(TIME_SERVICE_COMPONENT_FRAME);
    createEAttribute(timeServiceComponentFrameEClass, TIME_SERVICE_COMPONENT_FRAME__DATE);
    createEAttribute(timeServiceComponentFrameEClass, TIME_SERVICE_COMPONENT_FRAME__FORMATTED_DATE);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    transportFrameType0EClass.getESuperTypes().add(this.getTransportFrameTemplate());
    transportFrameType1EClass.getESuperTypes().add(this.getTransportFrameTemplate());
    servCompFrameProtectedEClass.getESuperTypes().add(this.getServiceComponentFrame());
    servCompFrameCountedProtectedEClass.getESuperTypes().add(this.getServiceComponentFrame());
    servCompFramePrioritisedProtectedEClass.getESuperTypes().add(this.getServiceComponentFrame());
    servCompFramePrioritisedCountedProtectedEClass.getESuperTypes().add(this.getServiceComponentFrame());
    messageManagementContainerEClass.getESuperTypes().add(this.getMMCSwitch());
    mmcMasterMessageEClass.getESuperTypes().add(this.getMMCSwitch());
    mmcMessagePartEClass.getESuperTypes().add(this.getMMCSwitch());
    tpegLocationReferenceEClass.getESuperTypes().add(this.getMethod());
    dlr1LocationReferenceEClass.getESuperTypes().add(this.getMethod());
    tmcLocationReferenceEClass.getESuperTypes().add(this.getMethod());
    vicsLinkReferenceEClass.getESuperTypes().add(this.getMethod());
    koreanNodeLinkLocationReferenceEClass.getESuperTypes().add(this.getMethod());
    tetLocationReferenceEClass.getESuperTypes().add(this.getMethod());
    glrLocationReferenceEClass.getESuperTypes().add(this.getMethod());
    olrLocationReferenceEClass.getESuperTypes().add(this.getMethod());
    timeServiceComponentFrameEClass.getESuperTypes().add(this.getServiceComponentFrame());

    // Initialize classes and features; add operations and parameters
    initEClass(localisedShortStringEClass, LocalisedShortString.class, "LocalisedShortString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLocalisedShortString_LanguageCode(), ecorePackage.getEInt(), "languageCode", null, 1, 1, LocalisedShortString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLocalisedShortString_String(), ecorePackage.getEString(), "string", null, 1, 1, LocalisedShortString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(locationReferencingContainerEClass, LocationReferencingContainer.class, "LocationReferencingContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLocationReferencingContainer_Method(), this.getMethod(), null, "method", null, 1, -1, LocationReferencingContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transportFrameTemplateEClass, TransportFrameTemplate.class, "TransportFrameTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransportFrameTemplate_MetaInformationTODO(), ecorePackage.getEString(), "metaInformationTODO", null, 0, 1, TransportFrameTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransportFrameTemplate_SyncWord(), ecorePackage.getEInt(), "syncWord", "0", 1, 1, TransportFrameTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransportFrameTemplate_FieldLength(), ecorePackage.getEInt(), "fieldLength", null, 1, 1, TransportFrameTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransportFrameTemplate_HeaderCRC(), ecorePackage.getEInt(), "headerCRC", null, 1, 1, TransportFrameTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransportFrameTemplate_FrameType(), ecorePackage.getEInt(), "frameType", null, 1, 1, TransportFrameTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transportFrameType0EClass, TransportFrameType0.class, "TransportFrameType0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransportFrameType0_TransportFrameContent(), this.getStreamDirectoryFrame(), null, "transportFrameContent", null, 1, 1, TransportFrameType0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transportFrameType1EClass, TransportFrameType1.class, "TransportFrameType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransportFrameType1_TransportFrameContent(), this.getServiceFrame(), null, "transportFrameContent", null, 1, 1, TransportFrameType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(serviceComponentFrameEClass, ServiceComponentFrame.class, "ServiceComponentFrame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getServiceComponentFrame_SCID(), ecorePackage.getEByte(), "SCID", null, 1, 1, ServiceComponentFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServiceComponentFrame_FieldLength(), ecorePackage.getEInt(), "fieldLength", null, 1, 1, ServiceComponentFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServiceComponentFrame_ScHeaderCRC(), ecorePackage.getEInt(), "scHeaderCRC", null, 1, 1, ServiceComponentFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(serviceFrameEClass, ServiceFrame.class, "ServiceFrame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getServiceFrame_ServEncID(), ecorePackage.getEInt(), "servEncID", null, 1, 1, ServiceFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getServiceFrame_ServiceFrameContent(), this.getServCompMultiplex(), null, "serviceFrameContent", null, 1, 1, ServiceFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getServiceFrame_SID(), this.getServiceIdentifier(), null, "SID", null, 1, 1, ServiceFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(streamDirectoryFrameEClass, StreamDirectoryFrame.class, "StreamDirectoryFrame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStreamDirectoryFrame_SID(), this.getServiceIdentifier(), null, "SID", null, 1, -1, StreamDirectoryFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStreamDirectoryFrame_NumberOfServices(), ecorePackage.getEInt(), "numberOfServices", null, 1, 1, StreamDirectoryFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStreamDirectoryFrame_HeaderCRC(), ecorePackage.getEInt(), "headerCRC", null, 1, 1, StreamDirectoryFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(servCompMultiplexEClass, ServCompMultiplex.class, "ServCompMultiplex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getServCompMultiplex_MultiplexContent(), this.getServiceComponentFrame(), null, "multiplexContent", null, 1, -1, ServCompMultiplex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(serviceIdentifierEClass, ServiceIdentifier.class, "ServiceIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getServiceIdentifier_SidA(), ecorePackage.getEByte(), "sidA", null, 1, 1, ServiceIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServiceIdentifier_SidB(), ecorePackage.getEByte(), "sidB", null, 1, 1, ServiceIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServiceIdentifier_SidC(), ecorePackage.getEByte(), "sidC", null, 1, 1, ServiceIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(servCompFrameProtectedEClass, ServCompFrameProtected.class, "ServCompFrameProtected", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getServCompFrameProtected_ApplicationContent(), ecorePackage.getEJavaObject(), "applicationContent", null, 1, 1, ServCompFrameProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServCompFrameProtected_DataCRC(), ecorePackage.getEInt(), "dataCRC", null, 1, 1, ServCompFrameProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(servCompFrameCountedProtectedEClass, ServCompFrameCountedProtected.class, "ServCompFrameCountedProtected", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getServCompFrameCountedProtected_MessageCount(), ecorePackage.getEInt(), "messageCount", null, 1, 1, ServCompFrameCountedProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServCompFrameCountedProtected_ApplicationContent(), ecorePackage.getEJavaObject(), "applicationContent", null, 1, 1, ServCompFrameCountedProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServCompFrameCountedProtected_DataCRC(), ecorePackage.getEInt(), "dataCRC", null, 1, 1, ServCompFrameCountedProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(servCompFramePrioritisedProtectedEClass, ServCompFramePrioritisedProtected.class, "ServCompFramePrioritisedProtected", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getServCompFramePrioritisedProtected_GroupPriority(), ecorePackage.getEInt(), "groupPriority", null, 1, 1, ServCompFramePrioritisedProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServCompFramePrioritisedProtected_ApplicationContent(), ecorePackage.getEJavaObject(), "applicationContent", null, 1, 1, ServCompFramePrioritisedProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServCompFramePrioritisedProtected_DataCRC(), ecorePackage.getEInt(), "dataCRC", null, 1, 1, ServCompFramePrioritisedProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(servCompFramePrioritisedCountedProtectedEClass, ServCompFramePrioritisedCountedProtected.class, "ServCompFramePrioritisedCountedProtected", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getServCompFramePrioritisedCountedProtected_GroupPriority(), ecorePackage.getEInt(), "groupPriority", null, 1, 1, ServCompFramePrioritisedCountedProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServCompFramePrioritisedCountedProtected_MessageCount(), ecorePackage.getEInt(), "messageCount", null, 1, 1, ServCompFramePrioritisedCountedProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServCompFramePrioritisedCountedProtected_ApplicationContent(), ecorePackage.getEJavaObject(), "applicationContent", null, 1, 1, ServCompFramePrioritisedCountedProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getServCompFramePrioritisedCountedProtected_DataCRC(), ecorePackage.getEInt(), "dataCRC", null, 1, 1, ServCompFramePrioritisedCountedProtected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mmcSwitchEClass, MMCSwitch.class, "MMCSwitch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMMCSwitch_MessageID(), ecorePackage.getEInt(), "messageID", null, 1, 1, MMCSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMCSwitch_VersionID(), ecorePackage.getEInt(), "versionID", null, 1, 1, MMCSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMCSwitch_MessageExpiryTime(), ecorePackage.getEDate(), "messageExpiryTime", null, 1, 1, MMCSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMCSwitch_CancelFlag(), ecorePackage.getEBoolean(), "cancelFlag", null, 1, 1, MMCSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMCSwitch_MessageGenerationTime(), ecorePackage.getEDate(), "messageGenerationTime", null, 0, 1, MMCSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMCSwitch_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1, MMCSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messageManagementContainerEClass, MessageManagementContainer.class, "MessageManagementContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mmcMasterMessageEClass, MMCMasterMessage.class, "MMCMasterMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMMCMasterMessage_MultiPartMessageDirectory(), this.getMultiPartMessageDirectory(), null, "multiPartMessageDirectory", null, 1, 255, MMCMasterMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiPartMessageDirectoryEClass, MultiPartMessageDirectory.class, "MultiPartMessageDirectory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMultiPartMessageDirectory_PartID(), ecorePackage.getEInt(), "partID", null, 1, 1, MultiPartMessageDirectory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiPartMessageDirectory_PartType(), ecorePackage.getEInt(), "partType", null, 1, 1, MultiPartMessageDirectory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mmcMessagePartEClass, MMCMessagePart.class, "MMCMessagePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMMCMessagePart_PartID(), ecorePackage.getEInt(), "partID", null, 1, 1, MMCMessagePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMCMessagePart_UpdateMode(), ecorePackage.getEInt(), "updateMode", null, 1, 1, MMCMessagePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMCMessagePart_MasterMessageVersions(), ecorePackage.getEInt(), "masterMessageVersions", null, 0, 255, MMCMessagePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tpegLocationReferenceEClass, TPEGLocationReference.class, "TPEGLocationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(dlr1LocationReferenceEClass, DLR1LocationReference.class, "DLR1LocationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tmcLocationReferenceEClass, TMCLocationReference.class, "TMCLocationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(vicsLinkReferenceEClass, VICSLinkReference.class, "VICSLinkReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(koreanNodeLinkLocationReferenceEClass, KoreanNodeLinkLocationReference.class, "KoreanNodeLinkLocationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tetLocationReferenceEClass, TETLocationReference.class, "TETLocationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(glrLocationReferenceEClass, GLRLocationReference.class, "GLRLocationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(olrLocationReferenceEClass, OLRLocationReference.class, "OLRLocationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOLRLocationReference_LocationData(), ecorePackage.getEByteArray(), "locationData", null, 1, 1, OLRLocationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeServiceComponentFrameEClass, TimeServiceComponentFrame.class, "TimeServiceComponentFrame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimeServiceComponentFrame_Date(), ecorePackage.getEDate(), "date", null, 0, 1, TimeServiceComponentFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeServiceComponentFrame_FormattedDate(), ecorePackage.getEString(), "formattedDate", null, 0, 1, TimeServiceComponentFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

} //TpegfwktypesPackageImpl
