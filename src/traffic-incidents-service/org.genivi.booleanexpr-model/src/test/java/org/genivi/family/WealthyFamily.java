/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.family;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wealthy Family</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.family.WealthyFamily#getForbesRanking <em>Forbes Ranking</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.family.FamilyPackage#getWealthyFamily()
 * @model
 * @generated
 */
public interface WealthyFamily extends Family {
  /**
	 * Returns the value of the '<em><b>Forbes Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Forbes Ranking</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Forbes Ranking</em>' attribute.
	 * @see #isSetForbesRanking()
	 * @see #unsetForbesRanking()
	 * @see #setForbesRanking(int)
	 * @see org.genivi.family.FamilyPackage#getWealthyFamily_ForbesRanking()
	 * @model unsettable="true"
	 * @generated
	 */
  int getForbesRanking();

  /**
	 * Sets the value of the '{@link org.genivi.family.WealthyFamily#getForbesRanking <em>Forbes Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forbes Ranking</em>' attribute.
	 * @see #isSetForbesRanking()
	 * @see #unsetForbesRanking()
	 * @see #getForbesRanking()
	 * @generated
	 */
  void setForbesRanking(int value);

  /**
	 * Unsets the value of the '{@link org.genivi.family.WealthyFamily#getForbesRanking <em>Forbes Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetForbesRanking()
	 * @see #getForbesRanking()
	 * @see #setForbesRanking(int)
	 * @generated
	 */
  void unsetForbesRanking();

  /**
	 * Returns whether the value of the '{@link org.genivi.family.WealthyFamily#getForbesRanking <em>Forbes Ranking</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Forbes Ranking</em>' attribute is set.
	 * @see #unsetForbesRanking()
	 * @see #getForbesRanking()
	 * @see #setForbesRanking(int)
	 * @generated
	 */
  boolean isSetForbesRanking();

} // WealthyFamily
