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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genivi.iconset.ColorType;
import org.genivi.iconset.IconDescriptor;
import org.genivi.iconset.IconDimension;
import org.genivi.iconset.IconSet;
import org.genivi.iconset.IconSize;
import org.genivi.iconset.IconsetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Icon Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.iconset.impl.IconSetImpl#getIconSetId <em>Icon Set Id</em>}</li>
 *   <li>{@link org.genivi.iconset.impl.IconSetImpl#getColorType <em>Color Type</em>}</li>
 *   <li>{@link org.genivi.iconset.impl.IconSetImpl#getDimension <em>Dimension</em>}</li>
 *   <li>{@link org.genivi.iconset.impl.IconSetImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.genivi.iconset.impl.IconSetImpl#isDayTimeIcon <em>Day Time Icon</em>}</li>
 *   <li>{@link org.genivi.iconset.impl.IconSetImpl#getThemeId <em>Theme Id</em>}</li>
 *   <li>{@link org.genivi.iconset.impl.IconSetImpl#getMediumType <em>Medium Type</em>}</li>
 *   <li>{@link org.genivi.iconset.impl.IconSetImpl#getIconDescriptors <em>Icon Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IconSetImpl extends EObjectImpl implements IconSet {
  /**
	 * The default value of the '{@link #getIconSetId() <em>Icon Set Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIconSetId()
	 * @generated
	 * @ordered
	 */
  protected static final int ICON_SET_ID_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getIconSetId() <em>Icon Set Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIconSetId()
	 * @generated
	 * @ordered
	 */
  protected int iconSetId = ICON_SET_ID_EDEFAULT;

  /**
	 * This is true if the Icon Set Id attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean iconSetIdESet;

  /**
	 * The default value of the '{@link #getColorType() <em>Color Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getColorType()
	 * @generated
	 * @ordered
	 */
  protected static final ColorType COLOR_TYPE_EDEFAULT = ColorType.BLACK_AND_WHITE;

  /**
	 * The cached value of the '{@link #getColorType() <em>Color Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getColorType()
	 * @generated
	 * @ordered
	 */
  protected ColorType colorType = COLOR_TYPE_EDEFAULT;

  /**
	 * This is true if the Color Type attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean colorTypeESet;

  /**
	 * The default value of the '{@link #getDimension() <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDimension()
	 * @generated
	 * @ordered
	 */
  protected static final IconDimension DIMENSION_EDEFAULT = IconDimension.D2D;

  /**
	 * The cached value of the '{@link #getDimension() <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDimension()
	 * @generated
	 * @ordered
	 */
  protected IconDimension dimension = DIMENSION_EDEFAULT;

  /**
	 * This is true if the Dimension attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean dimensionESet;

  /**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
  protected IconSize size;

  /**
	 * This is true if the Size containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean sizeESet;

  /**
	 * The default value of the '{@link #isDayTimeIcon() <em>Day Time Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isDayTimeIcon()
	 * @generated
	 * @ordered
	 */
  protected static final boolean DAY_TIME_ICON_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isDayTimeIcon() <em>Day Time Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isDayTimeIcon()
	 * @generated
	 * @ordered
	 */
  protected boolean dayTimeIcon = DAY_TIME_ICON_EDEFAULT;

  /**
	 * This is true if the Day Time Icon attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean dayTimeIconESet;

  /**
	 * The default value of the '{@link #getThemeId() <em>Theme Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getThemeId()
	 * @generated
	 * @ordered
	 */
  protected static final int THEME_ID_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getThemeId() <em>Theme Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getThemeId()
	 * @generated
	 * @ordered
	 */
  protected int themeId = THEME_ID_EDEFAULT;

  /**
	 * This is true if the Theme Id attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean themeIdESet;

  /**
	 * The default value of the '{@link #getMediumType() <em>Medium Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMediumType()
	 * @generated
	 * @ordered
	 */
  protected static final String MEDIUM_TYPE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getMediumType() <em>Medium Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMediumType()
	 * @generated
	 * @ordered
	 */
  protected String mediumType = MEDIUM_TYPE_EDEFAULT;

  /**
	 * This is true if the Medium Type attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean mediumTypeESet;

  /**
	 * The cached value of the '{@link #getIconDescriptors() <em>Icon Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIconDescriptors()
	 * @generated
	 * @ordered
	 */
  protected EList<IconDescriptor> iconDescriptors;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected IconSetImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return IconsetPackage.Literals.ICON_SET;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getIconSetId() {
		return iconSetId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setIconSetId(int newIconSetId) {
		int oldIconSetId = iconSetId;
		iconSetId = newIconSetId;
		boolean oldIconSetIdESet = iconSetIdESet;
		iconSetIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SET__ICON_SET_ID, oldIconSetId, iconSetId, !oldIconSetIdESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetIconSetId() {
		int oldIconSetId = iconSetId;
		boolean oldIconSetIdESet = iconSetIdESet;
		iconSetId = ICON_SET_ID_EDEFAULT;
		iconSetIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SET__ICON_SET_ID, oldIconSetId, ICON_SET_ID_EDEFAULT, oldIconSetIdESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetIconSetId() {
		return iconSetIdESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ColorType getColorType() {
		return colorType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setColorType(ColorType newColorType) {
		ColorType oldColorType = colorType;
		colorType = newColorType == null ? COLOR_TYPE_EDEFAULT : newColorType;
		boolean oldColorTypeESet = colorTypeESet;
		colorTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SET__COLOR_TYPE, oldColorType, colorType, !oldColorTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetColorType() {
		ColorType oldColorType = colorType;
		boolean oldColorTypeESet = colorTypeESet;
		colorType = COLOR_TYPE_EDEFAULT;
		colorTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SET__COLOR_TYPE, oldColorType, COLOR_TYPE_EDEFAULT, oldColorTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetColorType() {
		return colorTypeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconDimension getDimension() {
		return dimension;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDimension(IconDimension newDimension) {
		IconDimension oldDimension = dimension;
		dimension = newDimension == null ? DIMENSION_EDEFAULT : newDimension;
		boolean oldDimensionESet = dimensionESet;
		dimensionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SET__DIMENSION, oldDimension, dimension, !oldDimensionESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetDimension() {
		IconDimension oldDimension = dimension;
		boolean oldDimensionESet = dimensionESet;
		dimension = DIMENSION_EDEFAULT;
		dimensionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SET__DIMENSION, oldDimension, DIMENSION_EDEFAULT, oldDimensionESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetDimension() {
		return dimensionESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IconSize getSize() {
		return size;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetSize(IconSize newSize, NotificationChain msgs) {
		IconSize oldSize = size;
		size = newSize;
		boolean oldSizeESet = sizeESet;
		sizeESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SET__SIZE, oldSize, newSize, !oldSizeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSize(IconSize newSize) {
		if (newSize != size) {
			NotificationChain msgs = null;
			if (size != null)
				msgs = ((InternalEObject)size).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IconsetPackage.ICON_SET__SIZE, null, msgs);
			if (newSize != null)
				msgs = ((InternalEObject)newSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IconsetPackage.ICON_SET__SIZE, null, msgs);
			msgs = basicSetSize(newSize, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSizeESet = sizeESet;
			sizeESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SET__SIZE, newSize, newSize, !oldSizeESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetSize(NotificationChain msgs) {
		IconSize oldSize = size;
		size = null;
		boolean oldSizeESet = sizeESet;
		sizeESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SET__SIZE, oldSize, null, oldSizeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetSize() {
		if (size != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)size).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IconsetPackage.ICON_SET__SIZE, null, msgs);
			msgs = basicUnsetSize(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSizeESet = sizeESet;
			sizeESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SET__SIZE, null, null, oldSizeESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetSize() {
		return sizeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isDayTimeIcon() {
		return dayTimeIcon;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDayTimeIcon(boolean newDayTimeIcon) {
		boolean oldDayTimeIcon = dayTimeIcon;
		dayTimeIcon = newDayTimeIcon;
		boolean oldDayTimeIconESet = dayTimeIconESet;
		dayTimeIconESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SET__DAY_TIME_ICON, oldDayTimeIcon, dayTimeIcon, !oldDayTimeIconESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetDayTimeIcon() {
		boolean oldDayTimeIcon = dayTimeIcon;
		boolean oldDayTimeIconESet = dayTimeIconESet;
		dayTimeIcon = DAY_TIME_ICON_EDEFAULT;
		dayTimeIconESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SET__DAY_TIME_ICON, oldDayTimeIcon, DAY_TIME_ICON_EDEFAULT, oldDayTimeIconESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetDayTimeIcon() {
		return dayTimeIconESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getThemeId() {
		return themeId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setThemeId(int newThemeId) {
		int oldThemeId = themeId;
		themeId = newThemeId;
		boolean oldThemeIdESet = themeIdESet;
		themeIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SET__THEME_ID, oldThemeId, themeId, !oldThemeIdESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetThemeId() {
		int oldThemeId = themeId;
		boolean oldThemeIdESet = themeIdESet;
		themeId = THEME_ID_EDEFAULT;
		themeIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SET__THEME_ID, oldThemeId, THEME_ID_EDEFAULT, oldThemeIdESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetThemeId() {
		return themeIdESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getMediumType() {
		return mediumType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMediumType(String newMediumType) {
		String oldMediumType = mediumType;
		mediumType = newMediumType;
		boolean oldMediumTypeESet = mediumTypeESet;
		mediumTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IconsetPackage.ICON_SET__MEDIUM_TYPE, oldMediumType, mediumType, !oldMediumTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetMediumType() {
		String oldMediumType = mediumType;
		boolean oldMediumTypeESet = mediumTypeESet;
		mediumType = MEDIUM_TYPE_EDEFAULT;
		mediumTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, IconsetPackage.ICON_SET__MEDIUM_TYPE, oldMediumType, MEDIUM_TYPE_EDEFAULT, oldMediumTypeESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetMediumType() {
		return mediumTypeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<IconDescriptor> getIconDescriptors() {
		if (iconDescriptors == null) {
			iconDescriptors = new EObjectContainmentEList.Unsettable<IconDescriptor>(IconDescriptor.class, this, IconsetPackage.ICON_SET__ICON_DESCRIPTORS);
		}
		return iconDescriptors;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetIconDescriptors() {
		if (iconDescriptors != null) ((InternalEList.Unsettable<?>)iconDescriptors).unset();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetIconDescriptors() {
		return iconDescriptors != null && ((InternalEList.Unsettable<?>)iconDescriptors).isSet();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IconsetPackage.ICON_SET__SIZE:
				return basicUnsetSize(msgs);
			case IconsetPackage.ICON_SET__ICON_DESCRIPTORS:
				return ((InternalEList<?>)getIconDescriptors()).basicRemove(otherEnd, msgs);
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
			case IconsetPackage.ICON_SET__ICON_SET_ID:
				return getIconSetId();
			case IconsetPackage.ICON_SET__COLOR_TYPE:
				return getColorType();
			case IconsetPackage.ICON_SET__DIMENSION:
				return getDimension();
			case IconsetPackage.ICON_SET__SIZE:
				return getSize();
			case IconsetPackage.ICON_SET__DAY_TIME_ICON:
				return isDayTimeIcon();
			case IconsetPackage.ICON_SET__THEME_ID:
				return getThemeId();
			case IconsetPackage.ICON_SET__MEDIUM_TYPE:
				return getMediumType();
			case IconsetPackage.ICON_SET__ICON_DESCRIPTORS:
				return getIconDescriptors();
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
			case IconsetPackage.ICON_SET__ICON_SET_ID:
				setIconSetId((Integer)newValue);
				return;
			case IconsetPackage.ICON_SET__COLOR_TYPE:
				setColorType((ColorType)newValue);
				return;
			case IconsetPackage.ICON_SET__DIMENSION:
				setDimension((IconDimension)newValue);
				return;
			case IconsetPackage.ICON_SET__SIZE:
				setSize((IconSize)newValue);
				return;
			case IconsetPackage.ICON_SET__DAY_TIME_ICON:
				setDayTimeIcon((Boolean)newValue);
				return;
			case IconsetPackage.ICON_SET__THEME_ID:
				setThemeId((Integer)newValue);
				return;
			case IconsetPackage.ICON_SET__MEDIUM_TYPE:
				setMediumType((String)newValue);
				return;
			case IconsetPackage.ICON_SET__ICON_DESCRIPTORS:
				getIconDescriptors().clear();
				getIconDescriptors().addAll((Collection<? extends IconDescriptor>)newValue);
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
			case IconsetPackage.ICON_SET__ICON_SET_ID:
				unsetIconSetId();
				return;
			case IconsetPackage.ICON_SET__COLOR_TYPE:
				unsetColorType();
				return;
			case IconsetPackage.ICON_SET__DIMENSION:
				unsetDimension();
				return;
			case IconsetPackage.ICON_SET__SIZE:
				unsetSize();
				return;
			case IconsetPackage.ICON_SET__DAY_TIME_ICON:
				unsetDayTimeIcon();
				return;
			case IconsetPackage.ICON_SET__THEME_ID:
				unsetThemeId();
				return;
			case IconsetPackage.ICON_SET__MEDIUM_TYPE:
				unsetMediumType();
				return;
			case IconsetPackage.ICON_SET__ICON_DESCRIPTORS:
				unsetIconDescriptors();
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
			case IconsetPackage.ICON_SET__ICON_SET_ID:
				return isSetIconSetId();
			case IconsetPackage.ICON_SET__COLOR_TYPE:
				return isSetColorType();
			case IconsetPackage.ICON_SET__DIMENSION:
				return isSetDimension();
			case IconsetPackage.ICON_SET__SIZE:
				return isSetSize();
			case IconsetPackage.ICON_SET__DAY_TIME_ICON:
				return isSetDayTimeIcon();
			case IconsetPackage.ICON_SET__THEME_ID:
				return isSetThemeId();
			case IconsetPackage.ICON_SET__MEDIUM_TYPE:
				return isSetMediumType();
			case IconsetPackage.ICON_SET__ICON_DESCRIPTORS:
				return isSetIconDescriptors();
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
		result.append(" (iconSetId: ");
		if (iconSetIdESet) result.append(iconSetId); else result.append("<unset>");
		result.append(", colorType: ");
		if (colorTypeESet) result.append(colorType); else result.append("<unset>");
		result.append(", dimension: ");
		if (dimensionESet) result.append(dimension); else result.append("<unset>");
		result.append(", dayTimeIcon: ");
		if (dayTimeIconESet) result.append(dayTimeIcon); else result.append("<unset>");
		result.append(", themeId: ");
		if (themeIdESet) result.append(themeId); else result.append("<unset>");
		result.append(", mediumType: ");
		if (mediumTypeESet) result.append(mediumType); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //IconSetImpl
