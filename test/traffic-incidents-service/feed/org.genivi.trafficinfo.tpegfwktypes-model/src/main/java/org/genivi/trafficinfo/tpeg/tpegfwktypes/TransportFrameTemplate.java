/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.trafficinfo.tpeg.tpegfwktypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transport Frame Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getMetaInformationTODO <em>Meta Information TODO</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getSyncWord <em>Sync Word</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getFieldLength <em>Field Length</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getHeaderCRC <em>Header CRC</em>}</li>
 *   <li>{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getFrameType <em>Frame Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTransportFrameTemplate()
 * @model
 * @generated
 */
public interface TransportFrameTemplate extends EObject {
  /**
   * Returns the value of the '<em><b>Meta Information TODO</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Meta Information TODO</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Meta Information TODO</em>' attribute.
   * @see #setMetaInformationTODO(String)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTransportFrameTemplate_MetaInformationTODO()
   * @model
   * @generated
   */
  String getMetaInformationTODO();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getMetaInformationTODO <em>Meta Information TODO</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Meta Information TODO</em>' attribute.
   * @see #getMetaInformationTODO()
   * @generated
   */
  void setMetaInformationTODO(String value);

  /**
   * Returns the value of the '<em><b>Sync Word</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sync Word</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sync Word</em>' attribute.
   * @see #setSyncWord(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTransportFrameTemplate_SyncWord()
   * @model default="0" required="true"
   * @generated
   */
  int getSyncWord();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getSyncWord <em>Sync Word</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sync Word</em>' attribute.
   * @see #getSyncWord()
   * @generated
   */
  void setSyncWord(int value);

  /**
   * Returns the value of the '<em><b>Field Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field Length</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Length</em>' attribute.
   * @see #setFieldLength(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTransportFrameTemplate_FieldLength()
   * @model required="true"
   * @generated
   */
  int getFieldLength();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getFieldLength <em>Field Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field Length</em>' attribute.
   * @see #getFieldLength()
   * @generated
   */
  void setFieldLength(int value);

  /**
   * Returns the value of the '<em><b>Header CRC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Header CRC</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Header CRC</em>' attribute.
   * @see #setHeaderCRC(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTransportFrameTemplate_HeaderCRC()
   * @model required="true"
   * @generated
   */
  int getHeaderCRC();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getHeaderCRC <em>Header CRC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Header CRC</em>' attribute.
   * @see #getHeaderCRC()
   * @generated
   */
  void setHeaderCRC(int value);

  /**
   * Returns the value of the '<em><b>Frame Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Frame Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Frame Type</em>' attribute.
   * @see #setFrameType(int)
   * @see org.genivi.trafficinfo.tpeg.tpegfwktypes.TpegfwktypesPackage#getTransportFrameTemplate_FrameType()
   * @model required="true"
   * @generated
   */
  int getFrameType();

  /**
   * Sets the value of the '{@link org.genivi.trafficinfo.tpeg.tpegfwktypes.TransportFrameTemplate#getFrameType <em>Frame Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Frame Type</em>' attribute.
   * @see #getFrameType()
   * @generated
   */
  void setFrameType(int value);

} // TransportFrameTemplate
