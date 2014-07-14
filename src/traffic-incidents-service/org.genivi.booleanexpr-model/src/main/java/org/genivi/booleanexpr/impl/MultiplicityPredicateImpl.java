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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.genivi.booleanexpr.BooleanExpression;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.FilterexprPackage;
import org.genivi.booleanexpr.ListOperator;
import org.genivi.booleanexpr.MultiplicityPredicate;
import org.genivi.booleanexpr.util.FilterExprUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.impl.MultiplicityPredicateImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.MultiplicityPredicateImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.MultiplicityPredicateImpl#getListOperator <em>List Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicityPredicateImpl extends PredicateImpl implements MultiplicityPredicate {
  private final static Logger LOGGER = Logger.getLogger(SubClassPredicateImpl.class.getName());
  private static final String NEW_LINE = System.getProperty("line.separator");

  /**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
  protected BooleanExpression expression;

  /**
	 * This is true if the Expression containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean expressionESet;

  /**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
  protected ClassAttribute attribute;

  /**
	 * This is true if the Attribute containment reference has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean attributeESet;

  /**
	 * The default value of the '{@link #getListOperator() <em>List Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getListOperator()
	 * @generated
	 * @ordered
	 */
  protected static final ListOperator LIST_OPERATOR_EDEFAULT = ListOperator.ANY;

  /**
	 * The cached value of the '{@link #getListOperator() <em>List Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getListOperator()
	 * @generated
	 * @ordered
	 */
  protected ListOperator listOperator = LIST_OPERATOR_EDEFAULT;

  /**
	 * This is true if the List Operator attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean listOperatorESet;
  
  static {
    LOGGER.setLevel(Level.SEVERE);
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected MultiplicityPredicateImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FilterexprPackage.Literals.MULTIPLICITY_PREDICATE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BooleanExpression getExpression() {
		return expression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetExpression(BooleanExpression newExpression, NotificationChain msgs) {
		BooleanExpression oldExpression = expression;
		expression = newExpression;
		boolean oldExpressionESet = expressionESet;
		expressionESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION, oldExpression, newExpression, !oldExpressionESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setExpression(BooleanExpression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldExpressionESet = expressionESet;
			expressionESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION, newExpression, newExpression, !oldExpressionESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetExpression(NotificationChain msgs) {
		BooleanExpression oldExpression = expression;
		expression = null;
		boolean oldExpressionESet = expressionESet;
		expressionESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION, oldExpression, null, oldExpressionESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetExpression() {
		if (expression != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION, null, msgs);
			msgs = basicUnsetExpression(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldExpressionESet = expressionESet;
			expressionESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION, null, null, oldExpressionESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetExpression() {
		return expressionESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ListOperator getListOperator() {
		return listOperator;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setListOperator(ListOperator newListOperator) {
		ListOperator oldListOperator = listOperator;
		listOperator = newListOperator == null ? LIST_OPERATOR_EDEFAULT : newListOperator;
		boolean oldListOperatorESet = listOperatorESet;
		listOperatorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.MULTIPLICITY_PREDICATE__LIST_OPERATOR, oldListOperator, listOperator, !oldListOperatorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetListOperator() {
		ListOperator oldListOperator = listOperator;
		boolean oldListOperatorESet = listOperatorESet;
		listOperator = LIST_OPERATOR_EDEFAULT;
		listOperatorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.MULTIPLICITY_PREDICATE__LIST_OPERATOR, oldListOperator, LIST_OPERATOR_EDEFAULT, oldListOperatorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetListOperator() {
		return listOperatorESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ClassAttribute getAttribute() {
		return attribute;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetAttribute(ClassAttribute newAttribute, NotificationChain msgs) {
		ClassAttribute oldAttribute = attribute;
		attribute = newAttribute;
		boolean oldAttributeESet = attributeESet;
		attributeESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE, oldAttribute, newAttribute, !oldAttributeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAttribute(ClassAttribute newAttribute) {
		if (newAttribute != attribute) {
			NotificationChain msgs = null;
			if (attribute != null)
				msgs = ((InternalEObject)attribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE, null, msgs);
			if (newAttribute != null)
				msgs = ((InternalEObject)newAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE, null, msgs);
			msgs = basicSetAttribute(newAttribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldAttributeESet = attributeESet;
			attributeESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE, newAttribute, newAttribute, !oldAttributeESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicUnsetAttribute(NotificationChain msgs) {
		ClassAttribute oldAttribute = attribute;
		attribute = null;
		boolean oldAttributeESet = attributeESet;
		attributeESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE, oldAttribute, null, oldAttributeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetAttribute() {
		if (attribute != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)attribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE, null, msgs);
			msgs = basicUnsetAttribute(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldAttributeESet = attributeESet;
			attributeESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE, null, null, oldAttributeESet));
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetAttribute() {
		return attributeESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION:
				return basicUnsetExpression(msgs);
			case FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE:
				return basicUnsetAttribute(msgs);
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
			case FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION:
				return getExpression();
			case FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE:
				return getAttribute();
			case FilterexprPackage.MULTIPLICITY_PREDICATE__LIST_OPERATOR:
				return getListOperator();
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
			case FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION:
				setExpression((BooleanExpression)newValue);
				return;
			case FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE:
				setAttribute((ClassAttribute)newValue);
				return;
			case FilterexprPackage.MULTIPLICITY_PREDICATE__LIST_OPERATOR:
				setListOperator((ListOperator)newValue);
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
			case FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION:
				unsetExpression();
				return;
			case FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE:
				unsetAttribute();
				return;
			case FilterexprPackage.MULTIPLICITY_PREDICATE__LIST_OPERATOR:
				unsetListOperator();
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
			case FilterexprPackage.MULTIPLICITY_PREDICATE__EXPRESSION:
				return isSetExpression();
			case FilterexprPackage.MULTIPLICITY_PREDICATE__ATTRIBUTE:
				return isSetAttribute();
			case FilterexprPackage.MULTIPLICITY_PREDICATE__LIST_OPERATOR:
				return isSetListOperator();
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
    
    // ListOperator
    if (listOperatorESet)
      result.append(FilterExprUtil.listOperatorToString(listOperator));
    else
      result.append("<unset>");
    
    // ClassAttribute
    result.append(' ');
    if (attribute != null) {
      result.append(attribute.toString());
    } else {
      result.append("<not set>");
    }
    
    // Expression
    result.append(" (");
    result.append(expression.toString());
    result.append(')');
    
    return result.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String format(String indent, String indentSize) {
    StringBuffer result = new StringBuffer();
    
    result.append(indent);
    // ListOperator
    if (listOperatorESet)
      result.append(FilterExprUtil.listOperatorToString(listOperator));
    else
      result.append("<unset>");
    
    // ClassAttribute
    result.append(' ');
    if (attribute != null) {
      result.append(attribute.toString());
    } else {
      result.append("<not set>");
    }
    
    // Expression
    result.append(" (");
    result.append(NEW_LINE);
    
    indent += indentSize;

    result.append(expression.format(indent, indentSize));
    result.append(NEW_LINE);
    
    indent = indent.substring(0, indent.lastIndexOf(indentSize));

    result.append(indent);
    result.append(')');
    
    return result.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean evaluate(Object object) {
    LOGGER.info("evaluate => " + toString());
    
    boolean returnValue = false;
    
    Object attributeObject = attribute.getListValue((EObject) object);
    
    // subClassObject can be
    // a simple object, e.g. Integer
    // a list of simple objects
    // a subClass
    // a list of subClasses.
    
    if (attributeObject instanceof EList<?>) {
      LOGGER.fine("EList, so many");
      @SuppressWarnings("unchecked")
      EList<EObject> eObjects = (EList<EObject>) attributeObject;

      switch (listOperator) {
      case ALL:
        returnValue = evaluateForAllListOperator(eObjects);
        break;

      case ANY:
        returnValue = evaluateForAnyListOperator(eObjects);
        break;
        
      case NONE:
        returnValue = !evaluateForAnyListOperator(eObjects);
        break;
        
      default:
        throw new IllegalArgumentException("Operator not supported: " + listOperator);
      }
    } else {
      LOGGER.severe("No EList, so single subclass object");
      throw new IllegalArgumentException("Attribute \'" + attribute.getAttributeName() + "\' is not a list.");
    }

    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  private boolean evaluateForAllListOperator(EList<EObject> eObjects) {
    LOGGER.info("=>");
    
    boolean returnValue = true;
    
    for (EObject eObject: eObjects) {
      boolean result = expression.evaluate(eObject);
      if (result == false) {
        returnValue = false;
        break;
      }
    }
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  private boolean evaluateForAnyListOperator(EList<EObject> eObjects) {
    LOGGER.info("=>");
    
    boolean returnValue = false;
    
    for (Object eObject: eObjects) {
      LOGGER.info("Handling eObject in for loop");
      boolean result = expression.evaluate(eObject);
      if (result == true) {
        returnValue = true;
        break;
      }
    }
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }
} //MultiplicityPredicateImpl
