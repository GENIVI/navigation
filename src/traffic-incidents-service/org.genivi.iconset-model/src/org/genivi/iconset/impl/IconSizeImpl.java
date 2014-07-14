/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.iconset.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genivi.iconset.IconSize;
import org.genivi.iconset.IconsetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Icon Size</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.iconset.impl.IconSizeImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.genivi.iconset.impl.IconSizeImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.genivi.iconset.impl.IconSizeImpl#getDpi <em>Dpi</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IconSizeImpl extends EObjectImpl implements IconSize {
  /**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
  protected static final int WIDTH_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
  protected int width = WIDTH_EDEFAULT;

  /**
	 * This is true if the Width attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean widthESet;

  /**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
  protected static final int HEIGHT_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
  protected int height = HEIGHT_EDEFAULT;

  /**
	 * This is true if the Height attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean heightESet;

  /**
	 * The default value of the '{@link #getDpi() <em>Dpi</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDpi()
	 * @generated
	 * @ordered
	 */
  protected static final int DPI_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getDpi() <em>Dpi</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDpi()
	 * @generated
	 * @ordered
	 */
  protected int dpi = DPI_EDEFAULT;

  /**
	 * This is true if the Dpi attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean dpiESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected IconSizeImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return IconsetPackage.Literals.ICON_SIZE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getWidth() {
		return width;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		boolean oldWidthESet = widthESet;
		widthESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SIZE__WIDTH, oldWidth, width, !oldWidthESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetWidth() {
		int oldWidth = width;
		boolean oldWidthESet = widthESet;
		width = WIDTH_EDEFAULT;
		widthESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SIZE__WIDTH, oldWidth, WIDTH_EDEFAULT, oldWidthESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetWidth() {
		return widthESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getHeight() {
		return height;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setHeight(int newHeight) {
		int oldHeight = height;
		height = newHeight;
		boolean oldHeightESet = heightESet;
		heightESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SIZE__HEIGHT, oldHeight, height, !oldHeightESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetHeight() {
		int oldHeight = height;
		boolean oldHeightESet = heightESet;
		height = HEIGHT_EDEFAULT;
		heightESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SIZE__HEIGHT, oldHeight, HEIGHT_EDEFAULT, oldHeightESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetHeight() {
		return heightESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getDpi() {
		return dpi;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDpi(int newDpi) {
		int oldDpi = dpi;
		dpi = newDpi;
		boolean oldDpiESet = dpiESet;
		dpiESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SIZE__DPI, oldDpi, dpi, !oldDpiESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetDpi() {
		int oldDpi = dpi;
		boolean oldDpiESet = dpiESet;
		dpi = DPI_EDEFAULT;
		dpiESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SIZE__DPI, oldDpi, DPI_EDEFAULT, oldDpiESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetDpi() {
		return dpiESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IconsetPackage.ICON_SIZE__WIDTH:
				return getWidth();
			case IconsetPackage.ICON_SIZE__HEIGHT:
				return getHeight();
			case IconsetPackage.ICON_SIZE__DPI:
				return getDpi();
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
			case IconsetPackage.ICON_SIZE__WIDTH:
				setWidth((Integer)newValue);
				return;
			case IconsetPackage.ICON_SIZE__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case IconsetPackage.ICON_SIZE__DPI:
				setDpi((Integer)newValue);
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
			case IconsetPackage.ICON_SIZE__WIDTH:
				unsetWidth();
				return;
			case IconsetPackage.ICON_SIZE__HEIGHT:
				unsetHeight();
				return;
			case IconsetPackage.ICON_SIZE__DPI:
				unsetDpi();
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
			case IconsetPackage.ICON_SIZE__WIDTH:
				return isSetWidth();
			case IconsetPackage.ICON_SIZE__HEIGHT:
				return isSetHeight();
			case IconsetPackage.ICON_SIZE__DPI:
				return isSetDpi();
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
		result.append(" (width: ");
		if (widthESet) result.append(width); else result.append("<unset>");
		result.append(", height: ");
		if (heightESet) result.append(height); else result.append("<unset>");
		result.append(", dpi: ");
		if (dpiESet) result.append(dpi); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //IconSizeImpl
