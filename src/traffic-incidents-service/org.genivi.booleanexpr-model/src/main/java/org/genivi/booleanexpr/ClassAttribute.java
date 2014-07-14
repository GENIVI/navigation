/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.booleanexpr;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class represents an attribute of a class of a data model. The attribute is identified by its name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.ClassAttribute#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.ClassAttribute#getMetaOperator <em>Meta Operator</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.ClassAttribute#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.booleanexpr.FilterexprPackage#getClassAttribute()
 * @model
 * @generated
 */
public interface ClassAttribute extends EObject {
  /**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #isSetAttributeName()
	 * @see #unsetAttributeName()
	 * @see #setAttributeName(String)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getClassAttribute_AttributeName()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
  String getAttributeName();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.ClassAttribute#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #isSetAttributeName()
	 * @see #unsetAttributeName()
	 * @see #getAttributeName()
	 * @generated
	 */
  void setAttributeName(String value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.ClassAttribute#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAttributeName()
	 * @see #getAttributeName()
	 * @see #setAttributeName(String)
	 * @generated
	 */
  void unsetAttributeName();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.ClassAttribute#getAttributeName <em>Attribute Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Attribute Name</em>' attribute is set.
	 * @see #unsetAttributeName()
	 * @see #getAttributeName()
	 * @see #setAttributeName(String)
	 * @generated
	 */
  boolean isSetAttributeName();

  /**
	 * Returns the value of the '<em><b>Meta Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.genivi.booleanexpr.MetaOperator}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Meta Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.MetaOperator
	 * @see #isSetMetaOperator()
	 * @see #unsetMetaOperator()
	 * @see #setMetaOperator(MetaOperator)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getClassAttribute_MetaOperator()
	 * @model unsettable="true"
	 * @generated
	 */
  MetaOperator getMetaOperator();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.ClassAttribute#getMetaOperator <em>Meta Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Operator</em>' attribute.
	 * @see org.genivi.booleanexpr.MetaOperator
	 * @see #isSetMetaOperator()
	 * @see #unsetMetaOperator()
	 * @see #getMetaOperator()
	 * @generated
	 */
  void setMetaOperator(MetaOperator value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.ClassAttribute#getMetaOperator <em>Meta Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetMetaOperator()
	 * @see #getMetaOperator()
	 * @see #setMetaOperator(MetaOperator)
	 * @generated
	 */
  void unsetMetaOperator();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.ClassAttribute#getMetaOperator <em>Meta Operator</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Meta Operator</em>' attribute is set.
	 * @see #unsetMetaOperator()
	 * @see #getMetaOperator()
	 * @see #setMetaOperator(MetaOperator)
	 * @generated
	 */
  boolean isSetMetaOperator();

  /**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #isSetIndex()
	 * @see #unsetIndex()
	 * @see #setIndex(int)
	 * @see org.genivi.booleanexpr.FilterexprPackage#getClassAttribute_Index()
	 * @model unsettable="true"
	 * @generated
	 */
  int getIndex();

  /**
	 * Sets the value of the '{@link org.genivi.booleanexpr.ClassAttribute#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #isSetIndex()
	 * @see #unsetIndex()
	 * @see #getIndex()
	 * @generated
	 */
  void setIndex(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.booleanexpr.ClassAttribute#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetIndex()
	 * @see #getIndex()
	 * @see #setIndex(int)
	 * @generated
	 */
  void unsetIndex();

  /**
	 * Returns whether the value of the '{@link org.genivi.booleanexpr.ClassAttribute#getIndex <em>Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Index</em>' attribute is set.
	 * @see #unsetIndex()
	 * @see #getIndex()
	 * @see #setIndex(int)
	 * @generated
	 */
  boolean isSetIndex();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  boolean isSet(EObject object);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model many="false"
	 * @generated
	 */
  EList<?> getListValue(Object object);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  Object getValue(Object object);

} // ClassAttribute
