/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes;


import org.eclipse.emf.ecore.EObject;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line Of Table1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getServiceComponentId <em>Service Component Id</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOriginatorServiceIdentifier <em>Originator Service Identifier</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getContentId <em>Content Id</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getApplicationId <em>Application Id</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOperatingTime <em>Operating Time</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getEncryptionIndicator <em>Encryption Indicator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getLineOfTable1()
 * @model
 * @generated
 */
public interface LineOfTable1 extends EObject {
  /**
   * Returns the value of the '<em><b>Service Component Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service Component Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service Component Id</em>' attribute.
   * @see #isSetServiceComponentId()
   * @see #unsetServiceComponentId()
   * @see #setServiceComponentId(byte)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getLineOfTable1_ServiceComponentId()
   * @model unsettable="true" required="true"
   * @generated
   */
  byte getServiceComponentId();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getServiceComponentId <em>Service Component Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Service Component Id</em>' attribute.
   * @see #isSetServiceComponentId()
   * @see #unsetServiceComponentId()
   * @see #getServiceComponentId()
   * @generated
   */
  void setServiceComponentId(byte value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getServiceComponentId <em>Service Component Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetServiceComponentId()
   * @see #getServiceComponentId()
   * @see #setServiceComponentId(byte)
   * @generated
   */
  void unsetServiceComponentId();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getServiceComponentId <em>Service Component Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Service Component Id</em>' attribute is set.
   * @see #unsetServiceComponentId()
   * @see #getServiceComponentId()
   * @see #setServiceComponentId(byte)
   * @generated
   */
  boolean isSetServiceComponentId();

  /**
   * Returns the value of the '<em><b>Selector</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Component elements supplied
   * <!-- end-model-doc -->
   * @return the value of the '<em>Selector</em>' attribute.
   * @see #isSetSelector()
   * @see #unsetSelector()
   * @see #setSelector(byte)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getLineOfTable1_Selector()
   * @model unsettable="true" required="true"
   * @generated
   */
  byte getSelector();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getSelector <em>Selector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Selector</em>' attribute.
   * @see #isSetSelector()
   * @see #unsetSelector()
   * @see #getSelector()
   * @generated
   */
  void setSelector(byte value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getSelector <em>Selector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetSelector()
   * @see #getSelector()
   * @see #setSelector(byte)
   * @generated
   */
  void unsetSelector();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getSelector <em>Selector</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Selector</em>' attribute is set.
   * @see #unsetSelector()
   * @see #getSelector()
   * @see #setSelector(byte)
   * @generated
   */
  boolean isSetSelector();

  /**
   * Returns the value of the '<em><b>Originator Service Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Present only, when different from Carrier ServiceID. Indicated by selector = xxxxxxx1.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Originator Service Identifier</em>' containment reference.
   * @see #isSetOriginatorServiceIdentifier()
   * @see #unsetOriginatorServiceIdentifier()
   * @see #setOriginatorServiceIdentifier(ServiceIdentifier)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getLineOfTable1_OriginatorServiceIdentifier()
   * @model containment="true" unsettable="true"
   * @generated
   */
  ServiceIdentifier getOriginatorServiceIdentifier();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOriginatorServiceIdentifier <em>Originator Service Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Originator Service Identifier</em>' containment reference.
   * @see #isSetOriginatorServiceIdentifier()
   * @see #unsetOriginatorServiceIdentifier()
   * @see #getOriginatorServiceIdentifier()
   * @generated
   */
  void setOriginatorServiceIdentifier(ServiceIdentifier value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOriginatorServiceIdentifier <em>Originator Service Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetOriginatorServiceIdentifier()
   * @see #getOriginatorServiceIdentifier()
   * @see #setOriginatorServiceIdentifier(ServiceIdentifier)
   * @generated
   */
  void unsetOriginatorServiceIdentifier();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOriginatorServiceIdentifier <em>Originator Service Identifier</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Originator Service Identifier</em>' containment reference is set.
   * @see #unsetOriginatorServiceIdentifier()
   * @see #getOriginatorServiceIdentifier()
   * @see #setOriginatorServiceIdentifier(ServiceIdentifier)
   * @generated
   */
  boolean isSetOriginatorServiceIdentifier();

  /**
   * Returns the value of the '<em><b>Content Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content Id</em>' attribute.
   * @see #isSetContentId()
   * @see #unsetContentId()
   * @see #setContentId(byte)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getLineOfTable1_ContentId()
   * @model unsettable="true" required="true"
   * @generated
   */
  byte getContentId();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getContentId <em>Content Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content Id</em>' attribute.
   * @see #isSetContentId()
   * @see #unsetContentId()
   * @see #getContentId()
   * @generated
   */
  void setContentId(byte value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getContentId <em>Content Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetContentId()
   * @see #getContentId()
   * @see #setContentId(byte)
   * @generated
   */
  void unsetContentId();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getContentId <em>Content Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Content Id</em>' attribute is set.
   * @see #unsetContentId()
   * @see #getContentId()
   * @see #setContentId(byte)
   * @generated
   */
  boolean isSetContentId();

  /**
   * Returns the value of the '<em><b>Application Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Application Id</em>' attribute.
   * @see #isSetApplicationId()
   * @see #unsetApplicationId()
   * @see #setApplicationId(byte)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getLineOfTable1_ApplicationId()
   * @model unsettable="true" required="true"
   * @generated
   */
  byte getApplicationId();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getApplicationId <em>Application Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Application Id</em>' attribute.
   * @see #isSetApplicationId()
   * @see #unsetApplicationId()
   * @see #getApplicationId()
   * @generated
   */
  void setApplicationId(byte value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getApplicationId <em>Application Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetApplicationId()
   * @see #getApplicationId()
   * @see #setApplicationId(byte)
   * @generated
   */
  void unsetApplicationId();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getApplicationId <em>Application Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Application Id</em>' attribute is set.
   * @see #unsetApplicationId()
   * @see #getApplicationId()
   * @see #setApplicationId(byte)
   * @generated
   */
  boolean isSetApplicationId();

  /**
   * Returns the value of the '<em><b>Operating Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Present if selector = xxxxx1xx.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Operating Time</em>' containment reference.
   * @see #isSetOperatingTime()
   * @see #unsetOperatingTime()
   * @see #setOperatingTime(OperatingTime)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getLineOfTable1_OperatingTime()
   * @model containment="true" unsettable="true"
   * @generated
   */
  OperatingTime getOperatingTime();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOperatingTime <em>Operating Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operating Time</em>' containment reference.
   * @see #isSetOperatingTime()
   * @see #unsetOperatingTime()
   * @see #getOperatingTime()
   * @generated
   */
  void setOperatingTime(OperatingTime value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOperatingTime <em>Operating Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetOperatingTime()
   * @see #getOperatingTime()
   * @see #setOperatingTime(OperatingTime)
   * @generated
   */
  void unsetOperatingTime();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getOperatingTime <em>Operating Time</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Operating Time</em>' containment reference is set.
   * @see #unsetOperatingTime()
   * @see #getOperatingTime()
   * @see #setOperatingTime(OperatingTime)
   * @generated
   */
  boolean isSetOperatingTime();

  /**
   * Returns the value of the '<em><b>Encryption Indicator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Present if selector = xxxx1xxx.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Encryption Indicator</em>' attribute.
   * @see #isSetEncryptionIndicator()
   * @see #unsetEncryptionIndicator()
   * @see #setEncryptionIndicator(byte)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getLineOfTable1_EncryptionIndicator()
   * @model unsettable="true"
   * @generated
   */
  byte getEncryptionIndicator();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getEncryptionIndicator <em>Encryption Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Encryption Indicator</em>' attribute.
   * @see #isSetEncryptionIndicator()
   * @see #unsetEncryptionIndicator()
   * @see #getEncryptionIndicator()
   * @generated
   */
  void setEncryptionIndicator(byte value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getEncryptionIndicator <em>Encryption Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetEncryptionIndicator()
   * @see #getEncryptionIndicator()
   * @see #setEncryptionIndicator(byte)
   * @generated
   */
  void unsetEncryptionIndicator();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1#getEncryptionIndicator <em>Encryption Indicator</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Encryption Indicator</em>' attribute is set.
   * @see #unsetEncryptionIndicator()
   * @see #getEncryptionIndicator()
   * @see #setEncryptionIndicator(byte)
   * @generated
   */
  boolean isSetEncryptionIndicator();

} // LineOfTable1
