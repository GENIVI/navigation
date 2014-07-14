/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes.util;


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage
 * @generated
 */
public class TpegfwktypesAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TpegfwktypesPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TpegfwktypesAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = TpegfwktypesPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TpegfwktypesSwitch<Adapter> modelSwitch =
    new TpegfwktypesSwitch<Adapter>() {
      @Override
      public Adapter caseLocalisedShortString(LocalisedShortString object) {
        return createLocalisedShortStringAdapter();
      }
      @Override
      public Adapter caseLocationReferencingContainer(LocationReferencingContainer object) {
        return createLocationReferencingContainerAdapter();
      }
      @Override
      public Adapter caseTransportFrameTemplate(TransportFrameTemplate object) {
        return createTransportFrameTemplateAdapter();
      }
      @Override
      public Adapter caseTransportFrameType0(TransportFrameType0 object) {
        return createTransportFrameType0Adapter();
      }
      @Override
      public Adapter caseTransportFrameType1(TransportFrameType1 object) {
        return createTransportFrameType1Adapter();
      }
      @Override
      public Adapter caseServiceComponentFrame(ServiceComponentFrame object) {
        return createServiceComponentFrameAdapter();
      }
      @Override
      public Adapter caseServiceFrame(ServiceFrame object) {
        return createServiceFrameAdapter();
      }
      @Override
      public Adapter caseStreamDirectoryFrame(StreamDirectoryFrame object) {
        return createStreamDirectoryFrameAdapter();
      }
      @Override
      public Adapter caseServCompMultiplex(ServCompMultiplex object) {
        return createServCompMultiplexAdapter();
      }
      @Override
      public Adapter caseServiceIdentifier(ServiceIdentifier object) {
        return createServiceIdentifierAdapter();
      }
      @Override
      public Adapter caseServCompFrameProtected(ServCompFrameProtected object) {
        return createServCompFrameProtectedAdapter();
      }
      @Override
      public Adapter caseServCompFrameCountedProtected(ServCompFrameCountedProtected object) {
        return createServCompFrameCountedProtectedAdapter();
      }
      @Override
      public Adapter caseServCompFramePrioritisedProtected(ServCompFramePrioritisedProtected object) {
        return createServCompFramePrioritisedProtectedAdapter();
      }
      @Override
      public Adapter caseServCompFramePrioritisedCountedProtected(ServCompFramePrioritisedCountedProtected object) {
        return createServCompFramePrioritisedCountedProtectedAdapter();
      }
      @Override
      public Adapter caseMMCSwitch(MMCSwitch object) {
        return createMMCSwitchAdapter();
      }
      @Override
      public Adapter caseMessageManagementContainer(MessageManagementContainer object) {
        return createMessageManagementContainerAdapter();
      }
      @Override
      public Adapter caseMMCMasterMessage(MMCMasterMessage object) {
        return createMMCMasterMessageAdapter();
      }
      @Override
      public Adapter caseMultiPartMessageDirectory(MultiPartMessageDirectory object) {
        return createMultiPartMessageDirectoryAdapter();
      }
      @Override
      public Adapter caseMMCMessagePart(MMCMessagePart object) {
        return createMMCMessagePartAdapter();
      }
      @Override
      public Adapter caseMethod(Method object) {
        return createMethodAdapter();
      }
      @Override
      public Adapter caseTPEGLocationReference(TPEGLocationReference object) {
        return createTPEGLocationReferenceAdapter();
      }
      @Override
      public Adapter caseDLR1LocationReference(DLR1LocationReference object) {
        return createDLR1LocationReferenceAdapter();
      }
      @Override
      public Adapter caseTMCLocationReference(TMCLocationReference object) {
        return createTMCLocationReferenceAdapter();
      }
      @Override
      public Adapter caseVICSLinkReference(VICSLinkReference object) {
        return createVICSLinkReferenceAdapter();
      }
      @Override
      public Adapter caseKoreanNodeLinkLocationReference(KoreanNodeLinkLocationReference object) {
        return createKoreanNodeLinkLocationReferenceAdapter();
      }
      @Override
      public Adapter caseTETLocationReference(TETLocationReference object) {
        return createTETLocationReferenceAdapter();
      }
      @Override
      public Adapter caseGLRLocationReference(GLRLocationReference object) {
        return createGLRLocationReferenceAdapter();
      }
      @Override
      public Adapter caseOLRLocationReference(OLRLocationReference object) {
        return createOLRLocationReferenceAdapter();
      }
      @Override
      public Adapter caseTimeServiceComponentFrame(TimeServiceComponentFrame object) {
        return createTimeServiceComponentFrameAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString <em>Localised Short String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.LocalisedShortString
   * @generated
   */
  public Adapter createLocalisedShortStringAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer <em>Location Referencing Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.LocationReferencingContainer
   * @generated
   */
  public Adapter createLocationReferencingContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate <em>Transport Frame Template</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate
   * @generated
   */
  public Adapter createTransportFrameTemplateAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType0 <em>Transport Frame Type0</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType0
   * @generated
   */
  public Adapter createTransportFrameType0Adapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType1 <em>Transport Frame Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameType1
   * @generated
   */
  public Adapter createTransportFrameType1Adapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame <em>Service Component Frame</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceComponentFrame
   * @generated
   */
  public Adapter createServiceComponentFrameAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame <em>Service Frame</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceFrame
   * @generated
   */
  public Adapter createServiceFrameAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame <em>Stream Directory Frame</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.StreamDirectoryFrame
   * @generated
   */
  public Adapter createStreamDirectoryFrameAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex <em>Serv Comp Multiplex</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompMultiplex
   * @generated
   */
  public Adapter createServCompMultiplexAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier <em>Service Identifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier
   * @generated
   */
  public Adapter createServiceIdentifierAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameProtected <em>Serv Comp Frame Protected</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameProtected
   * @generated
   */
  public Adapter createServCompFrameProtectedAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected <em>Serv Comp Frame Counted Protected</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFrameCountedProtected
   * @generated
   */
  public Adapter createServCompFrameCountedProtectedAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected <em>Serv Comp Frame Prioritised Protected</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedProtected
   * @generated
   */
  public Adapter createServCompFramePrioritisedProtectedAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected <em>Serv Comp Frame Prioritised Counted Protected</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.ServCompFramePrioritisedCountedProtected
   * @generated
   */
  public Adapter createServCompFramePrioritisedCountedProtectedAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch <em>MMC Switch</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCSwitch
   * @generated
   */
  public Adapter createMMCSwitchAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MessageManagementContainer <em>Message Management Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MessageManagementContainer
   * @generated
   */
  public Adapter createMessageManagementContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMasterMessage <em>MMC Master Message</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMasterMessage
   * @generated
   */
  public Adapter createMMCMasterMessageAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory <em>Multi Part Message Directory</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MultiPartMessageDirectory
   * @generated
   */
  public Adapter createMultiPartMessageDirectoryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart <em>MMC Message Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.MMCMessagePart
   * @generated
   */
  public Adapter createMMCMessagePartAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.Method <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.Method
   * @generated
   */
  public Adapter createMethodAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TPEGLocationReference <em>TPEG Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TPEGLocationReference
   * @generated
   */
  public Adapter createTPEGLocationReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.DLR1LocationReference <em>DLR1 Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.DLR1LocationReference
   * @generated
   */
  public Adapter createDLR1LocationReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TMCLocationReference <em>TMC Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TMCLocationReference
   * @generated
   */
  public Adapter createTMCLocationReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.VICSLinkReference <em>VICS Link Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.VICSLinkReference
   * @generated
   */
  public Adapter createVICSLinkReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.KoreanNodeLinkLocationReference <em>Korean Node Link Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.KoreanNodeLinkLocationReference
   * @generated
   */
  public Adapter createKoreanNodeLinkLocationReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TETLocationReference <em>TET Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TETLocationReference
   * @generated
   */
  public Adapter createTETLocationReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.GLRLocationReference <em>GLR Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.GLRLocationReference
   * @generated
   */
  public Adapter createGLRLocationReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference <em>OLR Location Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.OLRLocationReference
   * @generated
   */
  public Adapter createOLRLocationReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame <em>Time Service Component Frame</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TimeServiceComponentFrame
   * @generated
   */
  public Adapter createTimeServiceComponentFrameAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //TpegfwktypesAdapterFactory
