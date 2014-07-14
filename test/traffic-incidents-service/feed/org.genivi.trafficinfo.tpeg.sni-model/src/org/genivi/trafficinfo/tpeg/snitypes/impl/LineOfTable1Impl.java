/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1;
import org.genivi.trafficinfo.tpeg.snitypes.OperatingTime;
import org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage;
import org.genivi.trafficinfo.tpeg.tpegfwktypes.ServiceIdentifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Line Of Table1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl#getServiceComponentId <em>Service Component Id</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl#getOriginatorServiceIdentifier <em>Originator Service Identifier</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl#getContentId <em>Content Id</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl#getApplicationId <em>Application Id</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl#getOperatingTime <em>Operating Time</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.LineOfTable1Impl#getEncryptionIndicator <em>Encryption Indicator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LineOfTable1Impl extends EObjectImpl implements LineOfTable1 {
  /**
   * The default value of the '{@link #getServiceComponentId() <em>Service Component Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServiceComponentId()
   * @generated
   * @ordered
   */
  protected static final byte SERVICE_COMPONENT_ID_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getServiceComponentId() <em>Service Component Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServiceComponentId()
   * @generated
   * @ordered
   */
  protected byte serviceComponentId = SERVICE_COMPONENT_ID_EDEFAULT;

  /**
   * This is true if the Service Component Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean serviceComponentIdESet;

  /**
   * The default value of the '{@link #getSelector() <em>Selector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelector()
   * @generated
   * @ordered
   */
  protected static final byte SELECTOR_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getSelector() <em>Selector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelector()
   * @generated
   * @ordered
   */
  protected byte selector = SELECTOR_EDEFAULT;

  /**
   * This is true if the Selector attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean selectorESet;

  /**
   * The cached value of the '{@link #getOriginatorServiceIdentifier() <em>Originator Service Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOriginatorServiceIdentifier()
   * @generated
   * @ordered
   */
  protected ServiceIdentifier originatorServiceIdentifier;

  /**
   * This is true if the Originator Service Identifier containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean originatorServiceIdentifierESet;

  /**
   * The default value of the '{@link #getContentId() <em>Content Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContentId()
   * @generated
   * @ordered
   */
  protected static final byte CONTENT_ID_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getContentId() <em>Content Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContentId()
   * @generated
   * @ordered
   */
  protected byte contentId = CONTENT_ID_EDEFAULT;

  /**
   * This is true if the Content Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean contentIdESet;

  /**
   * The default value of the '{@link #getApplicationId() <em>Application Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplicationId()
   * @generated
   * @ordered
   */
  protected static final byte APPLICATION_ID_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getApplicationId() <em>Application Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getApplicationId()
   * @generated
   * @ordered
   */
  protected byte applicationId = APPLICATION_ID_EDEFAULT;

  /**
   * This is true if the Application Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean applicationIdESet;

  /**
   * The cached value of the '{@link #getOperatingTime() <em>Operating Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperatingTime()
   * @generated
   * @ordered
   */
  protected OperatingTime operatingTime;

  /**
   * This is true if the Operating Time containment reference has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean operatingTimeESet;

  /**
   * The default value of the '{@link #getEncryptionIndicator() <em>Encryption Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEncryptionIndicator()
   * @generated
   * @ordered
   */
  protected static final byte ENCRYPTION_INDICATOR_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getEncryptionIndicator() <em>Encryption Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEncryptionIndicator()
   * @generated
   * @ordered
   */
  protected byte encryptionIndicator = ENCRYPTION_INDICATOR_EDEFAULT;

  /**
   * This is true if the Encryption Indicator attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean encryptionIndicatorESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LineOfTable1Impl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return SnitypesPackage.Literals.LINE_OF_TABLE1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getServiceComponentId() {
    return serviceComponentId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setServiceComponentId(byte newServiceComponentId) {
    byte oldServiceComponentId = serviceComponentId;
    serviceComponentId = newServiceComponentId;
    boolean oldServiceComponentIdESet = serviceComponentIdESet;
    serviceComponentIdESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.LINE_OF_TABLE1__SERVICE_COMPONENT_ID, oldServiceComponentId, serviceComponentId, !oldServiceComponentIdESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetServiceComponentId() {
    byte oldServiceComponentId = serviceComponentId;
    boolean oldServiceComponentIdESet = serviceComponentIdESet;
    serviceComponentId = SERVICE_COMPONENT_ID_EDEFAULT;
    serviceComponentIdESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.LINE_OF_TABLE1__SERVICE_COMPONENT_ID, oldServiceComponentId, SERVICE_COMPONENT_ID_EDEFAULT, oldServiceComponentIdESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetServiceComponentId() {
    return serviceComponentIdESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getSelector() {
    return selector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelector(byte newSelector) {
    byte oldSelector = selector;
    selector = newSelector;
    boolean oldSelectorESet = selectorESet;
    selectorESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.LINE_OF_TABLE1__SELECTOR, oldSelector, selector, !oldSelectorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetSelector() {
    byte oldSelector = selector;
    boolean oldSelectorESet = selectorESet;
    selector = SELECTOR_EDEFAULT;
    selectorESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.LINE_OF_TABLE1__SELECTOR, oldSelector, SELECTOR_EDEFAULT, oldSelectorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetSelector() {
    return selectorESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceIdentifier getOriginatorServiceIdentifier() {
    return originatorServiceIdentifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOriginatorServiceIdentifier(ServiceIdentifier newOriginatorServiceIdentifier, NotificationChain msgs) {
    ServiceIdentifier oldOriginatorServiceIdentifier = originatorServiceIdentifier;
    originatorServiceIdentifier = newOriginatorServiceIdentifier;
    boolean oldOriginatorServiceIdentifierESet = originatorServiceIdentifierESet;
    originatorServiceIdentifierESet = true;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER, oldOriginatorServiceIdentifier, newOriginatorServiceIdentifier, !oldOriginatorServiceIdentifierESet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOriginatorServiceIdentifier(ServiceIdentifier newOriginatorServiceIdentifier) {
    if (newOriginatorServiceIdentifier != originatorServiceIdentifier) {
      NotificationChain msgs = null;
      if (originatorServiceIdentifier != null)
        msgs = ((InternalEObject)originatorServiceIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER, null, msgs);
      if (newOriginatorServiceIdentifier != null)
        msgs = ((InternalEObject)newOriginatorServiceIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER, null, msgs);
      msgs = basicSetOriginatorServiceIdentifier(newOriginatorServiceIdentifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else {
      boolean oldOriginatorServiceIdentifierESet = originatorServiceIdentifierESet;
      originatorServiceIdentifierESet = true;
      if (eNotificationRequired())
        eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER, newOriginatorServiceIdentifier, newOriginatorServiceIdentifier, !oldOriginatorServiceIdentifierESet));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicUnsetOriginatorServiceIdentifier(NotificationChain msgs) {
    ServiceIdentifier oldOriginatorServiceIdentifier = originatorServiceIdentifier;
    originatorServiceIdentifier = null;
    boolean oldOriginatorServiceIdentifierESet = originatorServiceIdentifierESet;
    originatorServiceIdentifierESet = false;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER, oldOriginatorServiceIdentifier, null, oldOriginatorServiceIdentifierESet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOriginatorServiceIdentifier() {
    if (originatorServiceIdentifier != null) {
      NotificationChain msgs = null;
      msgs = ((InternalEObject)originatorServiceIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER, null, msgs);
      msgs = basicUnsetOriginatorServiceIdentifier(msgs);
      if (msgs != null) msgs.dispatch();
    }
    else {
      boolean oldOriginatorServiceIdentifierESet = originatorServiceIdentifierESet;
      originatorServiceIdentifierESet = false;
      if (eNotificationRequired())
        eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER, null, null, oldOriginatorServiceIdentifierESet));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOriginatorServiceIdentifier() {
    return originatorServiceIdentifierESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getContentId() {
    return contentId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContentId(byte newContentId) {
    byte oldContentId = contentId;
    contentId = newContentId;
    boolean oldContentIdESet = contentIdESet;
    contentIdESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.LINE_OF_TABLE1__CONTENT_ID, oldContentId, contentId, !oldContentIdESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetContentId() {
    byte oldContentId = contentId;
    boolean oldContentIdESet = contentIdESet;
    contentId = CONTENT_ID_EDEFAULT;
    contentIdESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.LINE_OF_TABLE1__CONTENT_ID, oldContentId, CONTENT_ID_EDEFAULT, oldContentIdESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetContentId() {
    return contentIdESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getApplicationId() {
    return applicationId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setApplicationId(byte newApplicationId) {
    byte oldApplicationId = applicationId;
    applicationId = newApplicationId;
    boolean oldApplicationIdESet = applicationIdESet;
    applicationIdESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.LINE_OF_TABLE1__APPLICATION_ID, oldApplicationId, applicationId, !oldApplicationIdESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetApplicationId() {
    byte oldApplicationId = applicationId;
    boolean oldApplicationIdESet = applicationIdESet;
    applicationId = APPLICATION_ID_EDEFAULT;
    applicationIdESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.LINE_OF_TABLE1__APPLICATION_ID, oldApplicationId, APPLICATION_ID_EDEFAULT, oldApplicationIdESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetApplicationId() {
    return applicationIdESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperatingTime getOperatingTime() {
    return operatingTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperatingTime(OperatingTime newOperatingTime, NotificationChain msgs) {
    OperatingTime oldOperatingTime = operatingTime;
    operatingTime = newOperatingTime;
    boolean oldOperatingTimeESet = operatingTimeESet;
    operatingTimeESet = true;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME, oldOperatingTime, newOperatingTime, !oldOperatingTimeESet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperatingTime(OperatingTime newOperatingTime) {
    if (newOperatingTime != operatingTime) {
      NotificationChain msgs = null;
      if (operatingTime != null)
        msgs = ((InternalEObject)operatingTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME, null, msgs);
      if (newOperatingTime != null)
        msgs = ((InternalEObject)newOperatingTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME, null, msgs);
      msgs = basicSetOperatingTime(newOperatingTime, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else {
      boolean oldOperatingTimeESet = operatingTimeESet;
      operatingTimeESet = true;
      if (eNotificationRequired())
        eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME, newOperatingTime, newOperatingTime, !oldOperatingTimeESet));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicUnsetOperatingTime(NotificationChain msgs) {
    OperatingTime oldOperatingTime = operatingTime;
    operatingTime = null;
    boolean oldOperatingTimeESet = operatingTimeESet;
    operatingTimeESet = false;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME, oldOperatingTime, null, oldOperatingTimeESet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOperatingTime() {
    if (operatingTime != null) {
      NotificationChain msgs = null;
      msgs = ((InternalEObject)operatingTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME, null, msgs);
      msgs = basicUnsetOperatingTime(msgs);
      if (msgs != null) msgs.dispatch();
    }
    else {
      boolean oldOperatingTimeESet = operatingTimeESet;
      operatingTimeESet = false;
      if (eNotificationRequired())
        eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME, null, null, oldOperatingTimeESet));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOperatingTime() {
    return operatingTimeESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getEncryptionIndicator() {
    return encryptionIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEncryptionIndicator(byte newEncryptionIndicator) {
    byte oldEncryptionIndicator = encryptionIndicator;
    encryptionIndicator = newEncryptionIndicator;
    boolean oldEncryptionIndicatorESet = encryptionIndicatorESet;
    encryptionIndicatorESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.LINE_OF_TABLE1__ENCRYPTION_INDICATOR, oldEncryptionIndicator, encryptionIndicator, !oldEncryptionIndicatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetEncryptionIndicator() {
    byte oldEncryptionIndicator = encryptionIndicator;
    boolean oldEncryptionIndicatorESet = encryptionIndicatorESet;
    encryptionIndicator = ENCRYPTION_INDICATOR_EDEFAULT;
    encryptionIndicatorESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.LINE_OF_TABLE1__ENCRYPTION_INDICATOR, oldEncryptionIndicator, ENCRYPTION_INDICATOR_EDEFAULT, oldEncryptionIndicatorESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetEncryptionIndicator() {
    return encryptionIndicatorESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER:
        return basicUnsetOriginatorServiceIdentifier(msgs);
      case SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME:
        return basicUnsetOperatingTime(msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case SnitypesPackage.LINE_OF_TABLE1__SERVICE_COMPONENT_ID:
        return getServiceComponentId();
      case SnitypesPackage.LINE_OF_TABLE1__SELECTOR:
        return getSelector();
      case SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER:
        return getOriginatorServiceIdentifier();
      case SnitypesPackage.LINE_OF_TABLE1__CONTENT_ID:
        return getContentId();
      case SnitypesPackage.LINE_OF_TABLE1__APPLICATION_ID:
        return getApplicationId();
      case SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME:
        return getOperatingTime();
      case SnitypesPackage.LINE_OF_TABLE1__ENCRYPTION_INDICATOR:
        return getEncryptionIndicator();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case SnitypesPackage.LINE_OF_TABLE1__SERVICE_COMPONENT_ID:
        setServiceComponentId((Byte)newValue);
        return;
      case SnitypesPackage.LINE_OF_TABLE1__SELECTOR:
        setSelector((Byte)newValue);
        return;
      case SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER:
        setOriginatorServiceIdentifier((ServiceIdentifier)newValue);
        return;
      case SnitypesPackage.LINE_OF_TABLE1__CONTENT_ID:
        setContentId((Byte)newValue);
        return;
      case SnitypesPackage.LINE_OF_TABLE1__APPLICATION_ID:
        setApplicationId((Byte)newValue);
        return;
      case SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME:
        setOperatingTime((OperatingTime)newValue);
        return;
      case SnitypesPackage.LINE_OF_TABLE1__ENCRYPTION_INDICATOR:
        setEncryptionIndicator((Byte)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case SnitypesPackage.LINE_OF_TABLE1__SERVICE_COMPONENT_ID:
        unsetServiceComponentId();
        return;
      case SnitypesPackage.LINE_OF_TABLE1__SELECTOR:
        unsetSelector();
        return;
      case SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER:
        unsetOriginatorServiceIdentifier();
        return;
      case SnitypesPackage.LINE_OF_TABLE1__CONTENT_ID:
        unsetContentId();
        return;
      case SnitypesPackage.LINE_OF_TABLE1__APPLICATION_ID:
        unsetApplicationId();
        return;
      case SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME:
        unsetOperatingTime();
        return;
      case SnitypesPackage.LINE_OF_TABLE1__ENCRYPTION_INDICATOR:
        unsetEncryptionIndicator();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case SnitypesPackage.LINE_OF_TABLE1__SERVICE_COMPONENT_ID:
        return isSetServiceComponentId();
      case SnitypesPackage.LINE_OF_TABLE1__SELECTOR:
        return isSetSelector();
      case SnitypesPackage.LINE_OF_TABLE1__ORIGINATOR_SERVICE_IDENTIFIER:
        return isSetOriginatorServiceIdentifier();
      case SnitypesPackage.LINE_OF_TABLE1__CONTENT_ID:
        return isSetContentId();
      case SnitypesPackage.LINE_OF_TABLE1__APPLICATION_ID:
        return isSetApplicationId();
      case SnitypesPackage.LINE_OF_TABLE1__OPERATING_TIME:
        return isSetOperatingTime();
      case SnitypesPackage.LINE_OF_TABLE1__ENCRYPTION_INDICATOR:
        return isSetEncryptionIndicator();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (serviceComponentId: ");
    if (serviceComponentIdESet) result.append(serviceComponentId); else result.append("<unset>");
    result.append(", selector: ");
    if (selectorESet) result.append(selector); else result.append("<unset>");
    result.append(", contentId: ");
    if (contentIdESet) result.append(contentId); else result.append("<unset>");
    result.append(", applicationId: ");
    if (applicationIdESet) result.append(applicationId); else result.append("<unset>");
    result.append(", encryptionIndicator: ");
    if (encryptionIndicatorESet) result.append(encryptionIndicator); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //LineOfTable1Impl
