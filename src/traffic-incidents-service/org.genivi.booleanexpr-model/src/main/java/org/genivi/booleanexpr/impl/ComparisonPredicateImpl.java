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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.genivi.booleanexpr.BooleanLiteral;
import org.genivi.booleanexpr.ClassAttribute;
import org.genivi.booleanexpr.ComparisonOperator;
import org.genivi.booleanexpr.ComparisonPredicate;
import org.genivi.booleanexpr.FilterexprPackage;
import org.genivi.booleanexpr.Literal;
import org.genivi.booleanexpr.SignedIntegerLiteral;
import org.genivi.booleanexpr.StringLiteral;
import org.genivi.booleanexpr.util.FilterExprUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Comparison Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genivi.booleanexpr.impl.ComparisonPredicateImpl#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.ComparisonPredicateImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.genivi.booleanexpr.impl.ComparisonPredicateImpl#getComparisonOperator <em>Comparison Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComparisonPredicateImpl extends PredicateImpl implements ComparisonPredicate {
  private final static Logger LOGGER = Logger.getLogger(ComparisonPredicateImpl.class.getName());
  
  /**
	 * The cached value of the '{@link #getLiteral() <em>Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLiteral()
	 * @generated
	 * @ordered
	 */
  protected Literal literal;

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
	 * The default value of the '{@link #getComparisonOperator() <em>Comparison Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getComparisonOperator()
	 * @generated
	 * @ordered
	 */
  protected static final ComparisonOperator COMPARISON_OPERATOR_EDEFAULT = ComparisonOperator.EQUAL;

  /**
	 * The cached value of the '{@link #getComparisonOperator() <em>Comparison Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getComparisonOperator()
	 * @generated
	 * @ordered
	 */
  protected ComparisonOperator comparisonOperator = COMPARISON_OPERATOR_EDEFAULT;
  
  static {
    LOGGER.setLevel(Level.SEVERE);
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ComparisonPredicateImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return FilterexprPackage.Literals.COMPARISON_PREDICATE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ComparisonOperator getComparisonOperator() {
		return comparisonOperator;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setComparisonOperator(ComparisonOperator newComparisonOperator) {
		ComparisonOperator oldComparisonOperator = comparisonOperator;
		comparisonOperator = newComparisonOperator == null ? COMPARISON_OPERATOR_EDEFAULT : newComparisonOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.COMPARISON_PREDICATE__COMPARISON_OPERATOR, oldComparisonOperator, comparisonOperator));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Literal getLiteral() {
		return literal;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLiteral(Literal newLiteral, NotificationChain msgs) {
		Literal oldLiteral = literal;
		literal = newLiteral;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.COMPARISON_PREDICATE__LITERAL, oldLiteral, newLiteral);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLiteral(Literal newLiteral) {
		if (newLiteral != literal) {
			NotificationChain msgs = null;
			if (literal != null)
				msgs = ((InternalEObject)literal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.COMPARISON_PREDICATE__LITERAL, null, msgs);
			if (newLiteral != null)
				msgs = ((InternalEObject)newLiteral).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.COMPARISON_PREDICATE__LITERAL, null, msgs);
			msgs = basicSetLiteral(newLiteral, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.COMPARISON_PREDICATE__LITERAL, newLiteral, newLiteral));
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
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FilterexprPackage.COMPARISON_PREDICATE__ATTRIBUTE, oldAttribute, newAttribute);
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
				msgs = ((InternalEObject)attribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.COMPARISON_PREDICATE__ATTRIBUTE, null, msgs);
			if (newAttribute != null)
				msgs = ((InternalEObject)newAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FilterexprPackage.COMPARISON_PREDICATE__ATTRIBUTE, null, msgs);
			msgs = basicSetAttribute(newAttribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilterexprPackage.COMPARISON_PREDICATE__ATTRIBUTE, newAttribute, newAttribute));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FilterexprPackage.COMPARISON_PREDICATE__LITERAL:
				return basicSetLiteral(null, msgs);
			case FilterexprPackage.COMPARISON_PREDICATE__ATTRIBUTE:
				return basicSetAttribute(null, msgs);
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
			case FilterexprPackage.COMPARISON_PREDICATE__LITERAL:
				return getLiteral();
			case FilterexprPackage.COMPARISON_PREDICATE__ATTRIBUTE:
				return getAttribute();
			case FilterexprPackage.COMPARISON_PREDICATE__COMPARISON_OPERATOR:
				return getComparisonOperator();
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
			case FilterexprPackage.COMPARISON_PREDICATE__LITERAL:
				setLiteral((Literal)newValue);
				return;
			case FilterexprPackage.COMPARISON_PREDICATE__ATTRIBUTE:
				setAttribute((ClassAttribute)newValue);
				return;
			case FilterexprPackage.COMPARISON_PREDICATE__COMPARISON_OPERATOR:
				setComparisonOperator((ComparisonOperator)newValue);
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
			case FilterexprPackage.COMPARISON_PREDICATE__LITERAL:
				setLiteral((Literal)null);
				return;
			case FilterexprPackage.COMPARISON_PREDICATE__ATTRIBUTE:
				setAttribute((ClassAttribute)null);
				return;
			case FilterexprPackage.COMPARISON_PREDICATE__COMPARISON_OPERATOR:
				setComparisonOperator(COMPARISON_OPERATOR_EDEFAULT);
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
			case FilterexprPackage.COMPARISON_PREDICATE__LITERAL:
				return literal != null;
			case FilterexprPackage.COMPARISON_PREDICATE__ATTRIBUTE:
				return attribute != null;
			case FilterexprPackage.COMPARISON_PREDICATE__COMPARISON_OPERATOR:
				return comparisonOperator != COMPARISON_OPERATOR_EDEFAULT;
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
    
    // Attribute
    if (attribute != null) {
      result.append(attribute.toString());
    } else {
      result.append("<attribute is null>");
    }
    result.append(' ');
    
    // ComparisonOperator
    result.append(FilterExprUtil.comparisonOperatorToString(comparisonOperator));
    result.append(' ');
    
    // Literal
    if (literal != null) {
      result.append(literal.toString());
    } else {
      result.append("<literal is null>");
    }
    
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
    result.append(toString());
    
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
    if (attribute != null) {
      attributeObjectValue = attribute.getValue(object);
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
      throw new IllegalArgumentException("Unsupported attribute type in ComparisonPredicate. Attribute value = " + attributeObjectValue);
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
        
    Object literalValue = null;
    if (literal instanceof BooleanLiteral) {
      literalValue = ((BooleanLiteral) literal).isValue();
    } else if (literal instanceof SignedIntegerLiteral) {
      literalValue = ((SignedIntegerLiteral) literal).getValue();
    } else if (literal instanceof StringLiteral) {
      literalValue = ((StringLiteral) literal).getValue();
    } else {
      throw new IllegalArgumentException("Unsupported literal type in ComparisonPredicate. literal = " + literal);
    }
    boolean returnValue = false;
    
    LOGGER.info("Applying: " + comparisonOperator + " on literalValue: " + literalValue);
    switch (comparisonOperator) {
    case EQUAL:
      if (literalValue == null) {
        returnValue = true;
      }
      break;
      
    case GREATER_OR_EQUAL_THAN:
      break;
      
    case GREATER_THEN:
      break;
      
    case LESS_OR_EQUAL_THAN:
      break;
      
    case LESS_THAN:
      break;
      
    case NOT_EQUAL:
      if (literalValue != null) {
        returnValue = true;
      }
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
  private boolean evaluateBoolean(Object attributeObjectValue) {
    LOGGER.info("=>");
    
    if (!(literal instanceof BooleanLiteral)) {
      throw new IllegalArgumentException("Incompatible types in ComparisonPredicate. Attribute value is Boolean, while literal is not a Boolean. Literal = " + literal);
    }
    
    boolean attributeValue = (Boolean) attributeObjectValue;
    boolean literalValue = ((BooleanLiteral) literal).isValue();
    boolean returnValue = false;
    
    switch (comparisonOperator) {
    case EQUAL:
      LOGGER.info("Applying EQUAL");
      returnValue = (attributeValue == literalValue);
      break;
      
    case GREATER_OR_EQUAL_THAN:
    case GREATER_THEN:
    case LESS_OR_EQUAL_THAN:
    case LESS_THAN:
      throw new IllegalArgumentException("Illegal comparisonOperator in ComparisonPredicate. comparisonOperator = " + comparisonOperator);
            
    case NOT_EQUAL:
      LOGGER.info("Applying NOT_EQUAL");
      returnValue = (attributeValue != literalValue);
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
    
    if (!(literal instanceof SignedIntegerLiteral)) {
      throw new IllegalArgumentException("Incompatible types in ComparisonPredicate. Attribute value is Integer, while literal is not a Integer. Literal = " + literal);
    }
    
    // TODO PRIO 2: Do we have to support null in expressions? I think so!
    long attributeValue;
    if (attributeObjectValue != null) {
      if (attributeObjectValue instanceof Long) {
        attributeValue = (Long) attributeObjectValue;
      } else {
        attributeValue = new Long(((Integer) attributeObjectValue).intValue());
      }
    } else {
      throw new IllegalArgumentException("attributeObjectValue is null, which is currently not allowed");
    }
    
    long literalValue = ((SignedIntegerLiteral) literal).getValue();
    boolean returnValue = false;
    
    LOGGER.fine("Applying: " + comparisonOperator + " on attributevalue: " + attributeValue + ", and literalValue: " + literalValue);

    switch (comparisonOperator) {
    case EQUAL:
      returnValue = (attributeValue == literalValue);
      break;
      
    case GREATER_OR_EQUAL_THAN:
      returnValue = (attributeValue >= literalValue);
      break;
      
    case GREATER_THEN:
      returnValue = (attributeValue > literalValue);
      break;
      
    case LESS_OR_EQUAL_THAN:
      returnValue = (attributeValue <= literalValue);
      break;
      
    case LESS_THAN:
      returnValue = (attributeValue < literalValue);
      break;
      
    case NOT_EQUAL:
      returnValue = (attributeValue != literalValue);
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
    
    if (!(literal instanceof StringLiteral)) {
      throw new IllegalArgumentException("Incompatible types in ComparisonPredicate. Attribute value is String, while literal is not a String. Literal = " + literal);
    }
    
    String attributeValue = (String) attributeObjectValue;  // TODO PRIO 2: Do we have to support null in expressions? I think so!
    String literalValue = ((StringLiteral) literal).getValue();
    boolean returnValue = false;
    
    LOGGER.info("Applying: " + comparisonOperator);
    switch (comparisonOperator) {
    case EQUAL:
      returnValue = attributeValue.equals(literalValue);
      break;
      
    case GREATER_OR_EQUAL_THAN:
    case GREATER_THEN:
    case LESS_OR_EQUAL_THAN:
    case LESS_THAN:
      throw new IllegalArgumentException("Illegal comparisonOperator in ComparisonPredicate. comparisonOperator = " + comparisonOperator);
      
    case NOT_EQUAL:
      returnValue = !attributeValue.equals(literalValue);
      break;
    }
    
    LOGGER.info("<= " + returnValue);
    
    return returnValue;
  }
} //ComparisonPredicateImpl
