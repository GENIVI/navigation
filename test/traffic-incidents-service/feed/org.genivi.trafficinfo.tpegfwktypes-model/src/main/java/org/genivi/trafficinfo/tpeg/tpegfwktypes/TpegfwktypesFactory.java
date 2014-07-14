/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage
 * @generated
 */
public interface TpegfwktypesFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TpegfwktypesFactory eINSTANCE = org.genivi.trafficinfo.tpeg.tpegfwktypes.impl.TpegfwktypesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Localised Short String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Localised Short String</em>'.
   * @generated
   */
  LocalisedShortString createLocalisedShortString();

  /**
   * Returns a new object of class '<em>Location Referencing Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Location Referencing Container</em>'.
   * @generated
   */
  LocationReferencingContainer createLocationReferencingContainer();

  /**
   * Returns a new object of class '<em>Transport Frame Template</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transport Frame Template</em>'.
   * @generated
   */
  TransportFrameTemplate createTransportFrameTemplate();

  /**
   * Returns a new object of class '<em>Transport Frame Type0</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transport Frame Type0</em>'.
   * @generated
   */
  TransportFrameType0 createTransportFrameType0();

  /**
   * Returns a new object of class '<em>Transport Frame Type1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transport Frame Type1</em>'.
   * @generated
   */
  TransportFrameType1 createTransportFrameType1();

  /**
   * Returns a new object of class '<em>Service Component Frame</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Service Component Frame</em>'.
   * @generated
   */
  ServiceComponentFrame createServiceComponentFrame();

  /**
   * Returns a new object of class '<em>Service Frame</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Service Frame</em>'.
   * @generated
   */
  ServiceFrame createServiceFrame();

  /**
   * Returns a new object of class '<em>Stream Directory Frame</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stream Directory Frame</em>'.
   * @generated
   */
  StreamDirectoryFrame createStreamDirectoryFrame();

  /**
   * Returns a new object of class '<em>Serv Comp Multiplex</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Serv Comp Multiplex</em>'.
   * @generated
   */
  ServCompMultiplex createServCompMultiplex();

  /**
   * Returns a new object of class '<em>Service Identifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Service Identifier</em>'.
   * @generated
   */
  ServiceIdentifier createServiceIdentifier();

  /**
   * Returns a new object of class '<em>Serv Comp Frame Protected</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Serv Comp Frame Protected</em>'.
   * @generated
   */
  ServCompFrameProtected createServCompFrameProtected();

  /**
   * Returns a new object of class '<em>Serv Comp Frame Counted Protected</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Serv Comp Frame Counted Protected</em>'.
   * @generated
   */
  ServCompFrameCountedProtected createServCompFrameCountedProtected();

  /**
   * Returns a new object of class '<em>Serv Comp Frame Prioritised Protected</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Serv Comp Frame Prioritised Protected</em>'.
   * @generated
   */
  ServCompFramePrioritisedProtected createServCompFramePrioritisedProtected();

  /**
   * Returns a new object of class '<em>Serv Comp Frame Prioritised Counted Protected</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Serv Comp Frame Prioritised Counted Protected</em>'.
   * @generated
   */
  ServCompFramePrioritisedCountedProtected createServCompFramePrioritisedCountedProtected();

  /**
   * Returns a new object of class '<em>MMC Switch</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MMC Switch</em>'.
   * @generated
   */
  MMCSwitch createMMCSwitch();

  /**
   * Returns a new object of class '<em>Message Management Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Management Container</em>'.
   * @generated
   */
  MessageManagementContainer createMessageManagementContainer();

  /**
   * Returns a new object of class '<em>MMC Master Message</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MMC Master Message</em>'.
   * @generated
   */
  MMCMasterMessage createMMCMasterMessage();

  /**
   * Returns a new object of class '<em>Multi Part Message Directory</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multi Part Message Directory</em>'.
   * @generated
   */
  MultiPartMessageDirectory createMultiPartMessageDirectory();

  /**
   * Returns a new object of class '<em>MMC Message Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MMC Message Part</em>'.
   * @generated
   */
  MMCMessagePart createMMCMessagePart();

  /**
   * Returns a new object of class '<em>Method</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method</em>'.
   * @generated
   */
  Method createMethod();

  /**
   * Returns a new object of class '<em>TPEG Location Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TPEG Location Reference</em>'.
   * @generated
   */
  TPEGLocationReference createTPEGLocationReference();

  /**
   * Returns a new object of class '<em>DLR1 Location Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DLR1 Location Reference</em>'.
   * @generated
   */
  DLR1LocationReference createDLR1LocationReference();

  /**
   * Returns a new object of class '<em>TMC Location Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TMC Location Reference</em>'.
   * @generated
   */
  TMCLocationReference createTMCLocationReference();

  /**
   * Returns a new object of class '<em>VICS Link Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>VICS Link Reference</em>'.
   * @generated
   */
  VICSLinkReference createVICSLinkReference();

  /**
   * Returns a new object of class '<em>Korean Node Link Location Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Korean Node Link Location Reference</em>'.
   * @generated
   */
  KoreanNodeLinkLocationReference createKoreanNodeLinkLocationReference();

  /**
   * Returns a new object of class '<em>TET Location Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TET Location Reference</em>'.
   * @generated
   */
  TETLocationReference createTETLocationReference();

  /**
   * Returns a new object of class '<em>GLR Location Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>GLR Location Reference</em>'.
   * @generated
   */
  GLRLocationReference createGLRLocationReference();

  /**
   * Returns a new object of class '<em>OLR Location Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>OLR Location Reference</em>'.
   * @generated
   */
  OLRLocationReference createOLRLocationReference();

  /**
   * Returns a new object of class '<em>Time Service Component Frame</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Service Component Frame</em>'.
   * @generated
   */
  TimeServiceComponentFrame createTimeServiceComponentFrame();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TpegfwktypesPackage getTpegfwktypesPackage();

} //TpegfwktypesFactory
