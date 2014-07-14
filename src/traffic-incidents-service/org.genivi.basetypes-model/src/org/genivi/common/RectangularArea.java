/**
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.genivi.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rectangular Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This datatype represents a rectangular area. The area is defined by the WGS84 coordinates of its bottomLeft and topRight corners.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genivi.common.RectangularArea#getBottomLeft <em>Bottom Left</em>}</li>
 *   <li>{@link org.genivi.common.RectangularArea#getTopRight <em>Top Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genivi.common.CommonPackage#getRectangularArea()
 * @model
 * @generated
 */
public interface RectangularArea extends EObject {

	/**
	 * Returns the value of the '<em><b>Bottom Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The bottom-left corner of the area.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bottom Left</em>' containment reference.
	 * @see #setBottomLeft(Coordinate)
	 * @see org.genivi.common.CommonPackage#getRectangularArea_BottomLeft()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Coordinate getBottomLeft();

	/**
	 * Sets the value of the '{@link org.genivi.common.RectangularArea#getBottomLeft <em>Bottom Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Left</em>' containment reference.
	 * @see #getBottomLeft()
	 * @generated
	 */
	void setBottomLeft(Coordinate value);

	/**
	 * Returns the value of the '<em><b>Top Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The top-right corner of the area.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Top Right</em>' containment reference.
	 * @see #setTopRight(Coordinate)
	 * @see org.genivi.common.CommonPackage#getRectangularArea_TopRight()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Coordinate getTopRight();

	/**
	 * Sets the value of the '{@link org.genivi.common.RectangularArea#getTopRight <em>Top Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Right</em>' containment reference.
	 * @see #getTopRight()
	 * @generated
	 */
	void setTopRight(Coordinate value);
} // RectangularArea
