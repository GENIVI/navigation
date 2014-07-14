/**
 * 
 * Copyright (C) 2013 TomTom International B.V.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 */
package org.genivi.booleanexpr.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.EEnumImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.FilterexprPackage;
import org.genivi.booleanexpr.MetaOperator;
import org.genivi.booleanexpr.util.FilterExprUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.impl.ClassAttributeImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.ClassAttributeImpl#getMetaOperator <em>Meta Operator</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.ClassAttributeImpl#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassAttributeImpl extends EObjectImpl implements ClassAttribute {
  /**
	 * The default value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
  protected static final String ATTRIBUTE_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
  protected String attributeName = ATTRIBUTE_NAME_EDEFAULT;

  /**
	 * This is true if the Attribute Name attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean attributeNameESet;

  /**
	 * The default value of the '{@link #getMetaOperator() <em>Meta Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMetaOperator()
	 * @generated
	 * @ordered
	 */
  protected static final MetaOperator META_OPERATOR_EDEFAULT = MetaOperator.SIZE;

  /**
	 * The cached value of the '{@link #getMetaOperator() <em>Meta Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMetaOperator()
	 * @generated
	 * @ordered
	 */
  protected MetaOperator metaOperator = META_OPERATOR_EDEFAULT;

  /**
	 * This is true if the Meta Operator attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean metaOperatorESet;

  /**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
  protected static final int INDEX_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
  protected int index = INDEX_EDEFAULT;

  /**
	 * This is true if the Index attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean indexESet;

  private final static Logger LOGGER = Logger.getLogger(ClassAttributeImpl.class.getName());
  
  static {
    LOGGER.setLevel(Level.SEVERE);
  }
  
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ClassAttributeImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FilterexprPackage.Literals.CLASS_ATTRIBUTE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getAttributeName() {
		return attributeName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAttributeName(String newAttributeName) {
		String oldAttributeName = attributeName;
		attributeName = newAttributeName;
		boolean oldAttributeNameESet = attributeNameESet;
		attributeNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.CLASS_ATTRIBUTE__ATTRIBUTE_NAME, oldAttributeName, attributeName, !oldAttributeNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetAttributeName() {
		String oldAttributeName = attributeName;
		boolean oldAttributeNameESet = attributeNameESet;
		attributeName = ATTRIBUTE_NAME_EDEFAULT;
		attributeNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.CLASS_ATTRIBUTE__ATTRIBUTE_NAME, oldAttributeName, ATTRIBUTE_NAME_EDEFAULT, oldAttributeNameESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetAttributeName() {
		return attributeNameESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MetaOperator getMetaOperator() {
		return metaOperator;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMetaOperator(MetaOperator newMetaOperator) {
		MetaOperator oldMetaOperator = metaOperator;
		metaOperator = newMetaOperator == null ? META_OPERATOR_EDEFAULT : newMetaOperator;
		boolean oldMetaOperatorESet = metaOperatorESet;
		metaOperatorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.CLASS_ATTRIBUTE__META_OPERATOR, oldMetaOperator, metaOperator, !oldMetaOperatorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetMetaOperator() {
		MetaOperator oldMetaOperator = metaOperator;
		boolean oldMetaOperatorESet = metaOperatorESet;
		metaOperator = META_OPERATOR_EDEFAULT;
		metaOperatorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.CLASS_ATTRIBUTE__META_OPERATOR, oldMetaOperator, META_OPERATOR_EDEFAULT, oldMetaOperatorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetMetaOperator() {
		return metaOperatorESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getIndex() {
		return index;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		boolean oldIndexESet = indexESet;
		indexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.CLASS_ATTRIBUTE__INDEX, oldIndex, index, !oldIndexESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetIndex() {
		int oldIndex = index;
		boolean oldIndexESet = indexESet;
		index = INDEX_EDEFAULT;
		indexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.CLASS_ATTRIBUTE__INDEX, oldIndex, INDEX_EDEFAULT, oldIndexESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetIndex() {
		return indexESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FilterexprPackage.CLASS_ATTRIBUTE__ATTRIBUTE_NAME:
				return getAttributeName();
			case FilterexprPackage.CLASS_ATTRIBUTE__META_OPERATOR:
				return getMetaOperator();
			case FilterexprPackage.CLASS_ATTRIBUTE__INDEX:
				return getIndex();
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
			case FilterexprPackage.CLASS_ATTRIBUTE__ATTRIBUTE_NAME:
				setAttributeName((String)newValue);
				return;
			case FilterexprPackage.CLASS_ATTRIBUTE__META_OPERATOR:
				setMetaOperator((MetaOperator)newValue);
				return;
			case FilterexprPackage.CLASS_ATTRIBUTE__INDEX:
				setIndex((Integer)newValue);
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
			case FilterexprPackage.CLASS_ATTRIBUTE__ATTRIBUTE_NAME:
				unsetAttributeName();
				return;
			case FilterexprPackage.CLASS_ATTRIBUTE__META_OPERATOR:
				unsetMetaOperator();
				return;
			case FilterexprPackage.CLASS_ATTRIBUTE__INDEX:
				unsetIndex();
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
			case FilterexprPackage.CLASS_ATTRIBUTE__ATTRIBUTE_NAME:
				return isSetAttributeName();
			case FilterexprPackage.CLASS_ATTRIBUTE__META_OPERATOR:
				return isSetMetaOperator();
			case FilterexprPackage.CLASS_ATTRIBUTE__INDEX:
				return isSetIndex();
		}
		return super.eIsSet(featureID);
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String toString() {
    StringBuffer result = new StringBuffer();

    if (attributeNameESet) {
      result.append("@");
      result.append(attributeName);
      
      if (indexESet) {
        result.append("[");
        result.append(index);
        result.append("]");
      }
      
      if (metaOperatorESet) {
        result.append("^");
        result.append(FilterExprUtil.metaOperatorToString(metaOperator));
      }
    } else {
      result.append("<unset>");
    }

    return result.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isSet(EObject object) {
    LOGGER.info("Looking for attribute name: " + attributeName);
    
    boolean returnValue = false;
    
    EStructuralFeature eStructuralFeature = getEStructuralFeatureForAttributeName(object, attributeName);
    
    if (eStructuralFeature != null) {
      
      LOGGER.info("Feature found: eType = " + eStructuralFeature.getEType());
      returnValue = object.eIsSet(eStructuralFeature);
    } else {
      LOGGER.info("Feature NOT found");
      throw new IllegalArgumentException("The object doesn't have an attribute named: " + attributeName);
    }
    
    LOGGER.info("<=" + returnValue);
    
    return returnValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public EList<?> getListValue(Object object) {
    LOGGER.info("=> " + toString());
    
    EList<?> returnValue = null;
    EObject eObject = (EObject) object;
    
    EStructuralFeature eStructuralFeature = getEStructuralFeatureForAttributeName(eObject, attributeName);
    
    if (eStructuralFeature != null) {
      
      LOGGER.fine("Feature found: eType = " + eStructuralFeature.getEType());
      Object attributeValue = eObject.eGet(eStructuralFeature);
            
      if (attributeValue instanceof EList<?>) {
        returnValue = (EList<?>) attributeValue;
      } else {
        throw new IllegalArgumentException("The object is not a list ");
      }
    } else {
      LOGGER.info("Feature NOT found");
      throw new IllegalArgumentException("The object doesn't have an attribute named: " + attributeName);
    }
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object getValue(Object object) {
    LOGGER.info("=> " + toString());
    
    Object returnValue = null;
    EObject eObject = (EObject) object;
    boolean indexHandled = false;
    
    EStructuralFeature eStructuralFeature = getEStructuralFeatureForAttributeName(eObject, attributeName);
    
    if (eStructuralFeature != null) {
      
      LOGGER.info("Feature found: eType = " + eStructuralFeature.getEType());
      Object attributeObject = eObject.eGet(eStructuralFeature);
      
      if (attributeObject instanceof EList<?>  && indexESet) {
        attributeObject = ((EList<?>) attributeObject).get(index);
        indexHandled = true;
      }
      
      if (attributeObject instanceof EList<?>) {
        EList<?> eListObject = (EList<?>) attributeObject;
        if (metaOperatorESet) {
          switch (metaOperator) {
          case SIZE:
            returnValue = eListObject.size();
            break;
            
          default:
            throw new IllegalArgumentException("Illegal meta operator: " + metaOperator);
          }
        } else {
          throw new IllegalArgumentException("A list class attribute can only be used in combination with an index or a metaOperator.");
        }
      } else if (attributeObject instanceof EEnumImpl) {
        LOGGER.info("EType is instance of EEnumImpl => Attribute is enum");
        
        if (indexESet  && !indexHandled) {
          throw new IllegalArgumentException("An index can not be used on an enum.");
        }
        
        if (metaOperatorESet) {
          throw new IllegalArgumentException("A meta operator cannot be used on an enum.");
        }
        
        Enumerator enumerator = (Enumerator) attributeObject;
        returnValue =  (Long) (long) enumerator.getValue();
//      } else if (eStructuralFeature.getEType().isInstance(Enumerator.class)) {
      } else if (attributeObject instanceof Enumerator) {
        LOGGER.info("EType isInstance is Enumerator => Attribute is enum");
        LOGGER.info("EObject = " + eObject);
        LOGGER.info("eStructuralFeature = " + eStructuralFeature);
        
        if (indexESet  && !indexHandled) {
          throw new IllegalArgumentException("An index can not be used on an enum.");
        }
        
        if (metaOperatorESet) {
          throw new IllegalArgumentException("A meta operator cannot be used on an enum.");
        }
        
        Enumerator enumerator = (Enumerator) attributeObject;
        if (enumerator != null) {
          returnValue = (Long) (long) enumerator.getValue();
        }
      } else {
        
        if (indexESet  && !indexHandled) {
          throw new IllegalArgumentException("An index can only be used on a list.");
        }
        
        if (metaOperatorESet) {
          throw new IllegalArgumentException("A meta operator can only be used on a list.");
        }
        
        returnValue = attributeObject;
      }
    } else {
      LOGGER.info("Feature NOT found");
      throw new IllegalArgumentException("The object doesn't have an attribute named: " + attributeName);
    }
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public EAttribute getEStructuralFeatureForAttributeByName(EObject object, String attributeName) {
    for (EAttribute eAttribute: object.eClass().getEAllAttributes()) {
      if (eAttribute.getName().equals(attributeName)) {
        return eAttribute;
      }
    }
    
    return null;
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public EStructuralFeature getEStructuralFeatureForAttributeName(EObject object, String attributeName) {
    for (EStructuralFeature eStructuralFeature: object.eClass().getEAllStructuralFeatures()) {
      if (eStructuralFeature.getName().equals(attributeName)) {
        return eStructuralFeature;
      }
    }
    
    return null;
  }

} //ClassAttributeImpl
