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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.genivi.booleanexpr.BooleanLiteral;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.FilterexprPackage;
import org.genivi.booleanexpr.InOperator;
import org.genivi.booleanexpr.InPredicate;
import org.genivi.booleanexpr.Literal;
import org.genivi.booleanexpr.SignedIntegerLiteral;
import org.genivi.booleanexpr.StringLiteral;
import org.genivi.booleanexpr.util.FilterExprUtil;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>In Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.impl.InPredicateImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.InPredicateImpl#getInOperator <em>In Operator</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.InPredicateImpl#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InPredicateImpl extends PredicateImpl implements InPredicate {
  private final static Logger LOGGER = Logger.getLogger(ComparisonPredicateImpl.class.getName());

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
	 * The default value of the '{@link #getInOperator() <em>In Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getInOperator()
	 * @generated
	 * @ordered
	 */
  protected static final InOperator IN_OPERATOR_EDEFAULT = InOperator.IN;
  /**
	 * The cached value of the '{@link #getInOperator() <em>In Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getInOperator()
	 * @generated
	 * @ordered
	 */
  protected InOperator inOperator = IN_OPERATOR_EDEFAULT;
  /**
	 * This is true if the In Operator attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean inOperatorESet;
  /**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
  protected EList<Literal> literals;
  
  static {
    LOGGER.setLevel(Level.SEVERE);
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected InPredicateImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FilterexprPackage.Literals.IN_PREDICATE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.IN_PREDICATE__ATTRIBUTE, oldAttribute, newAttribute, !oldAttributeESet);
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
				msgs = ((InternalEObject)attribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.IN_PREDICATE__ATTRIBUTE, null, msgs);
			if (newAttribute != null)
				msgs = ((InternalEObject)newAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.IN_PREDICATE__ATTRIBUTE, null, msgs);
			msgs = basicSetAttribute(newAttribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldAttributeESet = attributeESet;
			attributeESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.IN_PREDICATE__ATTRIBUTE, newAttribute, newAttribute, !oldAttributeESet));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.IN_PREDICATE__ATTRIBUTE, oldAttribute, null, oldAttributeESet);
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
			msgs = ((InternalEObject)attribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.IN_PREDICATE__ATTRIBUTE, null, msgs);
			msgs = basicUnsetAttribute(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldAttributeESet = attributeESet;
			attributeESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.IN_PREDICATE__ATTRIBUTE, null, null, oldAttributeESet));
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
  public InOperator getInOperator() {
		return inOperator;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setInOperator(InOperator newInOperator) {
		InOperator oldInOperator = inOperator;
		inOperator = newInOperator == null ? IN_OPERATOR_EDEFAULT : newInOperator;
		boolean oldInOperatorESet = inOperatorESet;
		inOperatorESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.IN_PREDICATE__IN_OPERATOR, oldInOperator, inOperator, !oldInOperatorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetInOperator() {
		InOperator oldInOperator = inOperator;
		boolean oldInOperatorESet = inOperatorESet;
		inOperator = IN_OPERATOR_EDEFAULT;
		inOperatorESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FilterexprPackage.IN_PREDICATE__IN_OPERATOR, oldInOperator, IN_OPERATOR_EDEFAULT, oldInOperatorESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetInOperator() {
		return inOperatorESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Literal> getLiterals() {
		if (literals == null) {
			literals = new EObjectContainmentEList.Unsettable<Literal>(Literal.class, this, FilterexprPackage.IN_PREDICATE__LITERALS);
		}
		return literals;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetLiterals() {
		if (literals != null) ((InternalEList.Unsettable<?>)literals).unset();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetLiterals() {
		return literals != null && ((InternalEList.Unsettable<?>)literals).isSet();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FilterexprPackage.IN_PREDICATE__ATTRIBUTE:
				return basicUnsetAttribute(msgs);
			case FilterexprPackage.IN_PREDICATE__LITERALS:
				return ((InternalEList<?>)getLiterals()).basicRemove(otherEnd, msgs);
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
			case FilterexprPackage.IN_PREDICATE__ATTRIBUTE:
				return getAttribute();
			case FilterexprPackage.IN_PREDICATE__IN_OPERATOR:
				return getInOperator();
			case FilterexprPackage.IN_PREDICATE__LITERALS:
				return getLiterals();
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
			case FilterexprPackage.IN_PREDICATE__ATTRIBUTE:
				setAttribute((ClassAttribute)newValue);
				return;
			case FilterexprPackage.IN_PREDICATE__IN_OPERATOR:
				setInOperator((InOperator)newValue);
				return;
			case FilterexprPackage.IN_PREDICATE__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends Literal>)newValue);
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
			case FilterexprPackage.IN_PREDICATE__ATTRIBUTE:
				unsetAttribute();
				return;
			case FilterexprPackage.IN_PREDICATE__IN_OPERATOR:
				unsetInOperator();
				return;
			case FilterexprPackage.IN_PREDICATE__LITERALS:
				unsetLiterals();
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
			case FilterexprPackage.IN_PREDICATE__ATTRIBUTE:
				return isSetAttribute();
			case FilterexprPackage.IN_PREDICATE__IN_OPERATOR:
				return isSetInOperator();
			case FilterexprPackage.IN_PREDICATE__LITERALS:
				return isSetLiterals();
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
    
    if (attribute != null) {
      result.append(attribute.toString());
    } else {
      result.append("@");
    }
    result.append(' ');
    result.append(FilterExprUtil.inOperatorToString(inOperator));
    result.append(" [");
    boolean first = true;
    for (Literal literal: literals) {
      if (first) {
        first = false;
      } else {
        result.append(", ");
      }
      result.append(literal.toString());
    }
    result.append("]");
    
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
    Object attributeObjectValue = null;
    if (object instanceof EObject) {
      attributeObjectValue = attribute.getValue((EObject) object);
    } else {
      attributeObjectValue = object;
    }
    if (attributeObjectValue == null) {
      returnValue = evaluateNull();
    } else if (attributeObjectValue instanceof Boolean) {
      returnValue = evaluateBoolean(attributeObjectValue);
    } else if (attributeObjectValue instanceof Integer) {
      returnValue = evaluateInteger(attributeObjectValue);
    } else if (attributeObjectValue instanceof Long) {
      returnValue = evaluateInteger(attributeObjectValue);
    } else if (attributeObjectValue instanceof String) {
      returnValue = evaluateString(attributeObjectValue);
    } else {
      throw new IllegalArgumentException("Unsupported attribute type in InPredicate. Attribute value = " + attributeObjectValue);
    }
    
    LOGGER.info("evaluate <= " + returnValue);
    
    return returnValue;
  }


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  private boolean evaluateNull() {
    LOGGER.info("=>");
        
    boolean returnValue = false;
    
    switch (inOperator) {
      
    case NOT_IN:
      returnValue = true;
      break;
      
    default:
      break; // No action.
    }
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  private boolean evaluateBoolean(Object attributeObjectValue) {
    LOGGER.info("=>");
    boolean attributeValue = (Boolean) attributeObjectValue;
    List<Boolean> literalValues = new ArrayList<Boolean>();
    
    for (Literal literal: literals) {
      if (!(literal instanceof BooleanLiteral)) {
        throw new IllegalArgumentException("Incompatible types in ComparisonPredicate. Attribute value is Boolean, while literal is not a Boolean. Literal = " + literal);
      }
      
      boolean literalValue = ((BooleanLiteral) literal).isValue();
      literalValues.add(literalValue);
    }
    
    boolean returnValue = false;
    
    switch (inOperator) {
    case IN:
      LOGGER.info("Applying IN");
      returnValue = literalValues.contains(attributeValue);
      break;
      
    case NOT_IN:
      LOGGER.info("Applying NOT_IN");
      returnValue = !literalValues.contains(attributeValue);
      break;
    }
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  private boolean evaluateInteger(Object attributeObjectValue) {
    LOGGER.info("=>");
    Long attributeValue = null;
    if (attributeObjectValue != null) {
      if (attributeObjectValue instanceof Long) {
        attributeValue = (Long) attributeObjectValue;
      } else {
        attributeValue = new Long(((Integer) attributeObjectValue).intValue());
      }
    }
    List<Long> literalValues = new ArrayList<Long>();
    
    for (Literal literal: literals) {
      if (!(literal instanceof SignedIntegerLiteral)) {
        throw new IllegalArgumentException("Incompatible types in ComparisonPredicate. Attribute value is Integer, while literal is not a Integer. Literal = " + literal);
      }
      
      Long literalValue = ((SignedIntegerLiteral) literal).getValue();
      literalValues.add(literalValue);
    }
    
    boolean returnValue = false;
    
    switch (inOperator) {
    case IN:
      LOGGER.info("Applying IN");
      returnValue = literalValues.contains(attributeValue);
      break;
      
    case NOT_IN:
      LOGGER.info("Applying NOT_IN");
      returnValue = !literalValues.contains(attributeValue);
      break;
    }
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  private boolean evaluateString(Object attributeObjectValue) {
    LOGGER.info("=>");
    String attributeValue = (String) attributeObjectValue;
    List<String> literalValues = new ArrayList<String>();
    
    for (Literal literal: literals) {
      if (!(literal instanceof StringLiteral)) {
        throw new IllegalArgumentException("Incompatible types in ComparisonPredicate. Attribute value is String, while literal is not a String. Literal = " + literal);
      }
      
      String literalValue = ((StringLiteral) literal).getValue();
      literalValues.add(literalValue);
    }
    
    boolean returnValue = false;
    
    switch (inOperator) {
    case IN:
      LOGGER.info("Applying IN");
      returnValue = literalValues.contains(attributeValue);
      break;
      
    case NOT_IN:
      LOGGER.info("Applying NOT_IN");
      returnValue = !literalValues.contains(attributeValue);
      break;
    }
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }

} //InPredicateImpl
