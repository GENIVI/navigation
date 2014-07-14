/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes.util;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage
 * @generated
 */
public class TpegfwktypesSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TpegfwktypesPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TpegfwktypesSwitch() {
    if (modelPackage == null) {
      modelPackage = TpegfwktypesPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case TpegfwktypesPackage.LOCALISED_SHORT_STRING: {
        LocalisedShortString localisedShortString = (LocalisedShortString)theEObject;
        T result = caseLocalisedShortString(localisedShortString);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.LOCATION_REFERENCING_CONTAINER: {
        LocationReferencingContainer locationReferencingContainer = (LocationReferencingContainer)theEObject;
        T result = caseLocationReferencingContainer(locationReferencingContainer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.TRANSPORT_FRAME_TEMPLATE: {
        TransportFrameTemplate transportFrameTemplate = (TransportFrameTemplate)theEObject;
        T result = caseTransportFrameTemplate(transportFrameTemplate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.TRANSPORT_FRAME_TYPE0: {
        TransportFrameType0 transportFrameType0 = (TransportFrameType0)theEObject;
        T result = caseTransportFrameType0(transportFrameType0);
        if (result == null) result = caseTransportFrameTemplate(transportFrameType0);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.TRANSPORT_FRAME_TYPE1: {
        TransportFrameType1 transportFrameType1 = (TransportFrameType1)theEObject;
        T result = caseTransportFrameType1(transportFrameType1);
        if (result == null) result = caseTransportFrameTemplate(transportFrameType1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.SERVICE_COMPONENT_FRAME: {
        ServiceComponentFrame serviceComponentFrame = (ServiceComponentFrame)theEObject;
        T result = caseServiceComponentFrame(serviceComponentFrame);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.SERVICE_FRAME: {
        ServiceFrame serviceFrame = (ServiceFrame)theEObject;
        T result = caseServiceFrame(serviceFrame);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.STREAM_DIRECTORY_FRAME: {
        StreamDirectoryFrame streamDirectoryFrame = (StreamDirectoryFrame)theEObject;
        T result = caseStreamDirectoryFrame(streamDirectoryFrame);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.SERV_COMP_MULTIPLEX: {
        ServCompMultiplex servCompMultiplex = (ServCompMultiplex)theEObject;
        T result = caseServCompMultiplex(servCompMultiplex);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.SERVICE_IDENTIFIER: {
        ServiceIdentifier serviceIdentifier = (ServiceIdentifier)theEObject;
        T result = caseServiceIdentifier(serviceIdentifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.SERV_COMP_FRAME_PROTECTED: {
        ServCompFrameProtected servCompFrameProtected = (ServCompFrameProtected)theEObject;
        T result = caseServCompFrameProtected(servCompFrameProtected);
        if (result == null) result = caseServiceComponentFrame(servCompFrameProtected);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.SERV_COMP_FRAME_COUNTED_PROTECTED: {
        ServCompFrameCountedProtected servCompFrameCountedProtected = (ServCompFrameCountedProtected)theEObject;
        T result = caseServCompFrameCountedProtected(servCompFrameCountedProtected);
        if (result == null) result = caseServiceComponentFrame(servCompFrameCountedProtected);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_PROTECTED: {
        ServCompFramePrioritisedProtected servCompFramePrioritisedProtected = (ServCompFramePrioritisedProtected)theEObject;
        T result = caseServCompFramePrioritisedProtected(servCompFramePrioritisedProtected);
        if (result == null) result = caseServiceComponentFrame(servCompFramePrioritisedProtected);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.SERV_COMP_FRAME_PRIORITISED_COUNTED_PROTECTED: {
        ServCompFramePrioritisedCountedProtected servCompFramePrioritisedCountedProtected = (ServCompFramePrioritisedCountedProtected)theEObject;
        T result = caseServCompFramePrioritisedCountedProtected(servCompFramePrioritisedCountedProtected);
        if (result == null) result = caseServiceComponentFrame(servCompFramePrioritisedCountedProtected);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.MMC_SWITCH: {
        MMCSwitch mmcSwitch = (MMCSwitch)theEObject;
        T result = caseMMCSwitch(mmcSwitch);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.MESSAGE_MANAGEMENT_CONTAINER: {
        MessageManagementContainer messageManagementContainer = (MessageManagementContainer)theEObject;
        T result = caseMessageManagementContainer(messageManagementContainer);
        if (result == null) result = caseMMCSwitch(messageManagementContainer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.MMC_MASTER_MESSAGE: {
        MMCMasterMessage mmcMasterMessage = (MMCMasterMessage)theEObject;
        T result = caseMMCMasterMessage(mmcMasterMessage);
        if (result == null) result = caseMMCSwitch(mmcMasterMessage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.MULTI_PART_MESSAGE_DIRECTORY: {
        MultiPartMessageDirectory multiPartMessageDirectory = (MultiPartMessageDirectory)theEObject;
        T result = caseMultiPartMessageDirectory(multiPartMessageDirectory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.MMC_MESSAGE_PART: {
        MMCMessagePart mmcMessagePart = (MMCMessagePart)theEObject;
        T result = caseMMCMessagePart(mmcMessagePart);
        if (result == null) result = caseMMCSwitch(mmcMessagePart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.METHOD: {
        Method method = (Method)theEObject;
        T result = caseMethod(method);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.TPEG_LOCATION_REFERENCE: {
        TPEGLocationReference tpegLocationReference = (TPEGLocationReference)theEObject;
        T result = caseTPEGLocationReference(tpegLocationReference);
        if (result == null) result = caseMethod(tpegLocationReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.DLR1_LOCATION_REFERENCE: {
        DLR1LocationReference dlr1LocationReference = (DLR1LocationReference)theEObject;
        T result = caseDLR1LocationReference(dlr1LocationReference);
        if (result == null) result = caseMethod(dlr1LocationReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.TMC_LOCATION_REFERENCE: {
        TMCLocationReference tmcLocationReference = (TMCLocationReference)theEObject;
        T result = caseTMCLocationReference(tmcLocationReference);
        if (result == null) result = caseMethod(tmcLocationReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.VICS_LINK_REFERENCE: {
        VICSLinkReference vicsLinkReference = (VICSLinkReference)theEObject;
        T result = caseVICSLinkReference(vicsLinkReference);
        if (result == null) result = caseMethod(vicsLinkReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.KOREAN_NODE_LINK_LOCATION_REFERENCE: {
        KoreanNodeLinkLocationReference koreanNodeLinkLocationReference = (KoreanNodeLinkLocationReference)theEObject;
        T result = caseKoreanNodeLinkLocationReference(koreanNodeLinkLocationReference);
        if (result == null) result = caseMethod(koreanNodeLinkLocationReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.TET_LOCATION_REFERENCE: {
        TETLocationReference tetLocationReference = (TETLocationReference)theEObject;
        T result = caseTETLocationReference(tetLocationReference);
        if (result == null) result = caseMethod(tetLocationReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.GLR_LOCATION_REFERENCE: {
        GLRLocationReference glrLocationReference = (GLRLocationReference)theEObject;
        T result = caseGLRLocationReference(glrLocationReference);
        if (result == null) result = caseMethod(glrLocationReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.OLR_LOCATION_REFERENCE: {
        OLRLocationReference olrLocationReference = (OLRLocationReference)theEObject;
        T result = caseOLRLocationReference(olrLocationReference);
        if (result == null) result = caseMethod(olrLocationReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TpegfwktypesPackage.TIME_SERVICE_COMPONENT_FRAME: {
        TimeServiceComponentFrame timeServiceComponentFrame = (TimeServiceComponentFrame)theEObject;
        T result = caseTimeServiceComponentFrame(timeServiceComponentFrame);
        if (result == null) result = caseServiceComponentFrame(timeServiceComponentFrame);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Localised Short String</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Localised Short String</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalisedShortString(LocalisedShortString object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Location Referencing Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Location Referencing Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocationReferencingContainer(LocationReferencingContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transport Frame Template</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transport Frame Template</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransportFrameTemplate(TransportFrameTemplate object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transport Frame Type0</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transport Frame Type0</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransportFrameType0(TransportFrameType0 object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transport Frame Type1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transport Frame Type1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransportFrameType1(TransportFrameType1 object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Service Component Frame</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Service Component Frame</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServiceComponentFrame(ServiceComponentFrame object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Service Frame</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Service Frame</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServiceFrame(ServiceFrame object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stream Directory Frame</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stream Directory Frame</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStreamDirectoryFrame(StreamDirectoryFrame object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Serv Comp Multiplex</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Serv Comp Multiplex</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServCompMultiplex(ServCompMultiplex object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Service Identifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Service Identifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServiceIdentifier(ServiceIdentifier object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Serv Comp Frame Protected</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Serv Comp Frame Protected</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServCompFrameProtected(ServCompFrameProtected object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Serv Comp Frame Counted Protected</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Serv Comp Frame Counted Protected</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServCompFrameCountedProtected(ServCompFrameCountedProtected object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Serv Comp Frame Prioritised Protected</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Serv Comp Frame Prioritised Protected</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServCompFramePrioritisedProtected(ServCompFramePrioritisedProtected object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Serv Comp Frame Prioritised Counted Protected</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Serv Comp Frame Prioritised Counted Protected</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServCompFramePrioritisedCountedProtected(ServCompFramePrioritisedCountedProtected object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MMC Switch</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MMC Switch</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMMCSwitch(MMCSwitch object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Message Management Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message Management Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessageManagementContainer(MessageManagementContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MMC Master Message</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MMC Master Message</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMMCMasterMessage(MMCMasterMessage object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multi Part Message Directory</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multi Part Message Directory</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiPartMessageDirectory(MultiPartMessageDirectory object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MMC Message Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MMC Message Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMMCMessagePart(MMCMessagePart object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Method</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Method</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMethod(Method object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TPEG Location Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TPEG Location Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTPEGLocationReference(TPEGLocationReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>DLR1 Location Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>DLR1 Location Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDLR1LocationReference(DLR1LocationReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TMC Location Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TMC Location Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTMCLocationReference(TMCLocationReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>VICS Link Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>VICS Link Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVICSLinkReference(VICSLinkReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Korean Node Link Location Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Korean Node Link Location Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKoreanNodeLinkLocationReference(KoreanNodeLinkLocationReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TET Location Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TET Location Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTETLocationReference(TETLocationReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>GLR Location Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>GLR Location Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGLRLocationReference(GLRLocationReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>OLR Location Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>OLR Location Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOLRLocationReference(OLRLocationReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Time Service Component Frame</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Time Service Component Frame</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTimeServiceComponentFrame(TimeServiceComponentFrame object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} //TpegfwktypesSwitch
