/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.snitypes;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sni Component Fast Tuning</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * id = 0x01
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getTableIncrementalVersionNumber <em>Table Incremental Version Number</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getCharTab <em>Char Tab</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getLinesOfTable1 <em>Lines Of Table1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getSniComponentFastTuning()
 * @model
 * @generated
 */
public interface SniComponentFastTuning extends SniComponent {
  /**
   * Returns the value of the '<em><b>Table Incremental Version Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Table Incremental Version Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Table Incremental Version Number</em>' attribute.
   * @see #isSetTableIncrementalVersionNumber()
   * @see #unsetTableIncrementalVersionNumber()
   * @see #setTableIncrementalVersionNumber(byte)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getSniComponentFastTuning_TableIncrementalVersionNumber()
   * @model unsettable="true" required="true"
   * @generated
   */
  byte getTableIncrementalVersionNumber();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getTableIncrementalVersionNumber <em>Table Incremental Version Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Table Incremental Version Number</em>' attribute.
   * @see #isSetTableIncrementalVersionNumber()
   * @see #unsetTableIncrementalVersionNumber()
   * @see #getTableIncrementalVersionNumber()
   * @generated
   */
  void setTableIncrementalVersionNumber(byte value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getTableIncrementalVersionNumber <em>Table Incremental Version Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTableIncrementalVersionNumber()
   * @see #getTableIncrementalVersionNumber()
   * @see #setTableIncrementalVersionNumber(byte)
   * @generated
   */
  void unsetTableIncrementalVersionNumber();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getTableIncrementalVersionNumber <em>Table Incremental Version Number</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Table Incremental Version Number</em>' attribute is set.
   * @see #unsetTableIncrementalVersionNumber()
   * @see #getTableIncrementalVersionNumber()
   * @see #setTableIncrementalVersionNumber(byte)
   * @generated
   */
  boolean isSetTableIncrementalVersionNumber();

  /**
   * Returns the value of the '<em><b>Char Tab</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Character table identifier.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Char Tab</em>' attribute.
   * @see #isSetCharTab()
   * @see #unsetCharTab()
   * @see #setCharTab(byte)
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getSniComponentFastTuning_CharTab()
   * @model unsettable="true"
   * @generated
   */
  byte getCharTab();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getCharTab <em>Char Tab</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Char Tab</em>' attribute.
   * @see #isSetCharTab()
   * @see #unsetCharTab()
   * @see #getCharTab()
   * @generated
   */
  void setCharTab(byte value);

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getCharTab <em>Char Tab</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetCharTab()
   * @see #getCharTab()
   * @see #setCharTab(byte)
   * @generated
   */
  void unsetCharTab();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getCharTab <em>Char Tab</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Char Tab</em>' attribute is set.
   * @see #unsetCharTab()
   * @see #getCharTab()
   * @see #setCharTab(byte)
   * @generated
   */
  boolean isSetCharTab();

  /**
   * Returns the value of the '<em><b>Lines Of Table1</b></em>' containment reference list.
   * The list contents are of type {@link org.genivi.trafficinfo.tpeg.snitypes.LineOfTable1}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lines Of Table1</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lines Of Table1</em>' containment reference list.
   * @see #isSetLinesOfTable1()
   * @see #unsetLinesOfTable1()
   * @see org.genivi.trafficinfo.tpeg.snitypes.SnitypesPackage#getSniComponentFastTuning_LinesOfTable1()
   * @model containment="true" unsettable="true"
   * @generated
   */
  EList<LineOfTable1> getLinesOfTable1();

  /**
   * Unsets the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getLinesOfTable1 <em>Lines Of Table1</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLinesOfTable1()
   * @see #getLinesOfTable1()
   * @generated
   */
  void unsetLinesOfTable1();

  /**
   * Returns whether the value of the '{@link org.genivi.trafficinfo.tpeg.snitypes.SniComponentFastTuning#getLinesOfTable1 <em>Lines Of Table1</em>}' containment reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Lines Of Table1</em>' containment reference list is set.
   * @see #unsetLinesOfTable1()
   * @see #getLinesOfTable1()
   * @generated
   */
  boolean isSetLinesOfTable1();

} // SniComponentFastTuning
