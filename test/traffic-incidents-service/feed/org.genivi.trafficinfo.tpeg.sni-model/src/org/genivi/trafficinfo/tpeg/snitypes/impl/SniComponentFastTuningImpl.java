/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1;
import org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning;
import org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sni Component Fast Tuning</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentFastTuningImpl#getTableIncrementalVersionNumber <em>Table Incremental Version Number</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentFastTuningImpl#getCharTab <em>Char Tab</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.impl.SniComponentFastTuningImpl#getLinesOfTable1 <em>Lines Of Table1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SniComponentFastTuningImpl extends SniComponentImpl implements SniComponentFastTuning {
  /**
   * The default value of the '{@link #getTableIncrementalVersionNumber() <em>Table Incremental Version Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTableIncrementalVersionNumber()
   * @generated
   * @ordered
   */
  protected static final byte TABLE_INCREMENTAL_VERSION_NUMBER_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getTableIncrementalVersionNumber() <em>Table Incremental Version Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTableIncrementalVersionNumber()
   * @generated
   * @ordered
   */
  protected byte tableIncrementalVersionNumber = TABLE_INCREMENTAL_VERSION_NUMBER_EDEFAULT;

  /**
   * This is true if the Table Incremental Version Number attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean tableIncrementalVersionNumberESet;

  /**
   * The default value of the '{@link #getCharTab() <em>Char Tab</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharTab()
   * @generated
   * @ordered
   */
  protected static final byte CHAR_TAB_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getCharTab() <em>Char Tab</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharTab()
   * @generated
   * @ordered
   */
  protected byte charTab = CHAR_TAB_EDEFAULT;

  /**
   * This is true if the Char Tab attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean charTabESet;

  /**
   * The cached value of the '{@link #getLinesOfTable1() <em>Lines Of Table1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinesOfTable1()
   * @generated
   * @ordered
   */
  protected EList<LineOfTable1> linesOfTable1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SniComponentFastTuningImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return SnitypesPackage.Literals.SNI_COMPONENT_FAST_TUNING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getTableIncrementalVersionNumber() {
    return tableIncrementalVersionNumber;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTableIncrementalVersionNumber(byte newTableIncrementalVersionNumber) {
    byte oldTableIncrementalVersionNumber = tableIncrementalVersionNumber;
    tableIncrementalVersionNumber = newTableIncrementalVersionNumber;
    boolean oldTableIncrementalVersionNumberESet = tableIncrementalVersionNumberESet;
    tableIncrementalVersionNumberESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.SNI_COMPONENT_FAST_TUNING__TABLE_INCREMENTAL_VERSION_NUMBER, oldTableIncrementalVersionNumber, tableIncrementalVersionNumber, !oldTableIncrementalVersionNumberESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetTableIncrementalVersionNumber() {
    byte oldTableIncrementalVersionNumber = tableIncrementalVersionNumber;
    boolean oldTableIncrementalVersionNumberESet = tableIncrementalVersionNumberESet;
    tableIncrementalVersionNumber = TABLE_INCREMENTAL_VERSION_NUMBER_EDEFAULT;
    tableIncrementalVersionNumberESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.SNI_COMPONENT_FAST_TUNING__TABLE_INCREMENTAL_VERSION_NUMBER, oldTableIncrementalVersionNumber, TABLE_INCREMENTAL_VERSION_NUMBER_EDEFAULT, oldTableIncrementalVersionNumberESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetTableIncrementalVersionNumber() {
    return tableIncrementalVersionNumberESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getCharTab() {
    return charTab;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCharTab(byte newCharTab) {
    byte oldCharTab = charTab;
    charTab = newCharTab;
    boolean oldCharTabESet = charTabESet;
    charTabESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnitypesPackage.SNI_COMPONENT_FAST_TUNING__CHAR_TAB, oldCharTab, charTab, !oldCharTabESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetCharTab() {
    byte oldCharTab = charTab;
    boolean oldCharTabESet = charTabESet;
    charTab = CHAR_TAB_EDEFAULT;
    charTabESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, SnitypesPackage.SNI_COMPONENT_FAST_TUNING__CHAR_TAB, oldCharTab, CHAR_TAB_EDEFAULT, oldCharTabESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetCharTab() {
    return charTabESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LineOfTable1> getLinesOfTable1() {
    if (linesOfTable1 == null) {
      linesOfTable1 = new EObjectContainmentEList.Unsettable<LineOfTable1>(LineOfTable1.class, this, SnitypesPackage.SNI_COMPONENT_FAST_TUNING__LINES_OF_TABLE1);
    }
    return linesOfTable1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetLinesOfTable1() {
    if (linesOfTable1 != null) ((InternalEList.Unsettable<?>)linesOfTable1).unset();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetLinesOfTable1() {
    return linesOfTable1 != null && ((InternalEList.Unsettable<?>)linesOfTable1).isSet();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__LINES_OF_TABLE1:
        return ((InternalEList<?>)getLinesOfTable1()).basicRemove(otherEnd, msgs);
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
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__TABLE_INCREMENTAL_VERSION_NUMBER:
        return getTableIncrementalVersionNumber();
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__CHAR_TAB:
        return getCharTab();
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__LINES_OF_TABLE1:
        return getLinesOfTable1();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__TABLE_INCREMENTAL_VERSION_NUMBER:
        setTableIncrementalVersionNumber((Byte)newValue);
        return;
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__CHAR_TAB:
        setCharTab((Byte)newValue);
        return;
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__LINES_OF_TABLE1:
        getLinesOfTable1().clear();
        getLinesOfTable1().addAll((Collection<? extends LineOfTable1>)newValue);
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
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__TABLE_INCREMENTAL_VERSION_NUMBER:
        unsetTableIncrementalVersionNumber();
        return;
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__CHAR_TAB:
        unsetCharTab();
        return;
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__LINES_OF_TABLE1:
        unsetLinesOfTable1();
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
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__TABLE_INCREMENTAL_VERSION_NUMBER:
        return isSetTableIncrementalVersionNumber();
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__CHAR_TAB:
        return isSetCharTab();
      case SnitypesPackage.SNI_COMPONENT_FAST_TUNING__LINES_OF_TABLE1:
        return isSetLinesOfTable1();
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
    result.append(" (tableIncrementalVersionNumber: ");
    if (tableIncrementalVersionNumberESet) result.append(tableIncrementalVersionNumber); else result.append("<unset>");
    result.append(", charTab: ");
    if (charTabESet) result.append(charTab); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //SniComponentFastTuningImpl
